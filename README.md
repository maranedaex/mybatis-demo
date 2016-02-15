Ejemplo MyBatis
===============

Este es un pequeño ejemplo de como usar MyBatis 3 para independizar
el código Java de las sentiencias SQL. El ejemplo crea un único objeto
de dominio.

Para compilar usar:

    $> mvn clean package

Para probar la ejecución:

    $> mvn exec:java -Dexec.mainClass='pin.ramon.mybatis.demo.MainMyBatisDemo'

El ejemplo usa MySQL como base de datos de ejemplo. La carpeta ddl contiene
el script para crear el schema usado en el ejemplo así como un fichero Dockerfile
para construir una imagen docker con el schema cargado.

Para construir la imagen Docker y ejecutarla usar:

    $> cd ddl 
    $> docker build -t myblog-sample .
    $> docker run -d -p 3306:3306 --name myblog-sample myblog-sample

Nota sobre el driver JDBC
=========================
El ejemplo usa el driver de MariaDB aún cuando la base de datos de prueba en 
el Dockerfile es MySQL. Esto es debido a que el driver JDBC de MySQL deja Threads
'colgados' que producen el conocido warning a la hora de parar la aplicación.
El driver de MariaDB no tiene este problema.

