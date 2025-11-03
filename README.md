Команды, использованные для запуска:

docker-compose down -v --rmi all
docker-compose up
java -jar ./artifacts/app-deadline.jar -P:jdbc.url="jdbc:mysql://localhost:3306/appdb" -P:jdbc.user="appuser" -P:jdbc.password="apppass" 

