package helpers;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlHelper {

    private static QueryRunner runner = new QueryRunner();

    private SqlHelper() {
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/appdb", "appuser", "apppass");
    }

    @SneakyThrows
    public static String getUserPassword() {
        var usersSQL = "SELECT password FROM users where login='vasya';";
        try (var conn = getConnection()) {
            return runner.query(conn, usersSQL, new ScalarHandler<String>());
        }
    }

    @SneakyThrows
    public static String getLastAuthCode(String login) {
        var codeSQL = "SELECT code FROM auth_codes WHERE user_id = (SELECT id FROM users WHERE login = ?) ORDER BY created DESC LIMIT 1;";
        try (var conn = getConnection()) {
            return runner.query(conn, codeSQL, new ScalarHandler<String>(), login);
        }
    }

    @SneakyThrows
    public static void cleanDatabase() {
        try (var conn = getConnection()) {
            runner.update(conn, "DELETE FROM card_transactions;");
            runner.update(conn, "DELETE FROM auth_codes;");
            runner.update(conn, "DELETE FROM cards;");
            runner.update(conn, "DELETE FROM users;");
        }
    }
}