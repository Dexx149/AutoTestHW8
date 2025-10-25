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
    public static String getUserId() {
        var usersSQL = "SELECT id FROM users where login='vasya';";
        try (var conn = getConnection()) {
            return runner.query(conn, usersSQL, new ScalarHandler<String>());
        }
    }

    @SneakyThrows
    public static String getUserLogin() {
        var usersSQL = "SELECT login FROM users where login='vasya';";
        try (var conn = getConnection()) {
            return runner.query(conn, usersSQL, new ScalarHandler<String>());
        }
    }

    @SneakyThrows
    public static String getUserPassword() {
        var usersSQL = "SELECT password FROM users where login='vasya';";
        try (var conn = getConnection()) {
            return runner.query(conn, usersSQL, new ScalarHandler<String>());
        }
    }

    @SneakyThrows
    public static String getLastAuthCode(String userId) {
        var codeSQL = "SELECT code FROM auth_codes WHERE user_id = ? ORDER BY created DESC LIMIT 1;";
        try (var conn = getConnection()) {
            return runner.query(conn, codeSQL, new ScalarHandler<String>(), userId);
        }
    }

}