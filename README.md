Команды, использованные для запуска:

docker-compose down -v --rmi all
docker-compose up
docker exec -it autotesthw8-mysql-1  mysql -u appuser -papppass appdb -e "DELETE FROM card_transactions; DELETE FROM auth_codes; DELETE FROM cards; DELETE FROM users;"
java -jar ./artifacts/app-deadline.jar -P:jdbc.url="jdbc:mysql://localhost:3306/appdb" -P:jdbc.user="appuser" -P:jdbc.password="apppass" 



Запросы из БД выполняются с логином vasya, потому что известен пароль
