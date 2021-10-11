# Calculadora
Este proyecto consta de una aplicación web que expone un servicio Rest de calculadora. Dicho servicio expone las operaciones básicas de suma, resta, multiplicación y división.

# Instalación para Mac
Se debe instalar java version 15 JDK. Este puede ser descargado de la pagina de oracle del siguiente link: https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html
Se debe instalar apache-maven version 3.8.3. Para realizar la instalación de este podemos seguir los pasos del siguiente tutorial para mac: https://www.youtube.com/watch?v=uZ1yNWKd7zM    o para windows el que mas convenga.

En la carpeta Applications guardamos la carpeta descomprimida de apache
Segun el tutorial agregamos en .bash_profile
export M2_HOME=/Applications/apache-maven-3.8.3   
export PATH=$PATH:$M2_HOME/bin

# Instalación para Linux-ubuntu
Se debe instalar java versión 11. Esta instalación se puede realizar basado en el video tutorial:  https://www.youtube.com/watch?v=gsTU4OPMx_c&ab_channel=programadornovato
Se debe istalar apache maven 3.6.3. Esta instalación se puede realizar basado en el video tutorial: https://www.youtube.com/watch?v=8mARWZjcYhY&ab_channel=Zatiel


## Ejecución 
Como con cada aplicación Spring boot, esta puede ser ejecutada en la terminal usando el siguiente comando *./mvn spring-boot:run* 
Despues de esto la aplicación puede ser accedida usando la siguiente url base *http://localhost:8080/basic*

## Prueba unitaria
Spring boot genera un archivo llamado "proyectoCalculadoraApplicationTests.java" en el directorio "test/java/com/calculadora/proyectoCalculadora", en este archivo se ejecutan las pruebas unitarias.

