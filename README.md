# Práctica SpringBoot

Correr el aplicativo one line

``` bash
docker run -e DB_URL=jdbc:mysql://localhost:3306/mydb -e DB_USERNAME=root -e DB_PASSWORD=rootpassword -e DB_DRIVER=com.mysql.cj.jdbc.Driver -p 8080:8080 your-springboot-app
```

Levantar entorno

```bash
docker-compose up -d
```

## TODO

- [] github actions
- [] Despliegue con terraform
- [] Hacer un front pequeño :D
