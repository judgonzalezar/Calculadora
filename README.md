# Calculadora
Este proyecto consta de una aplicación web que expone un servicio Rest de calculadora. Dicho servicio expone las operaciones básicas de suma, resta, multiplicación y división.

# Instalación para Mac
Se debe instalar java versión 15 JDK. Este puede ser descargado de la página de oracle del siguiente link: https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html

Se debe instalar apache-maven versión 3.8.3. Para realizar la instalación de este podemos seguir los pasos del siguiente tutorial para mac: https://www.youtube.com/watch?v=uZ1yNWKd7zM    o para Windows el que mas convenga.

En la carpeta Applications guardamos la carpeta descomprimida de apache.

Según el tutorial agregamos en .bash_profile

export M2_HOME=/Applications/apache-maven-3.8.3  

export PATH=$PATH:$M2_HOME/bin

# Instalación para Linux-ubuntu
Se debe instalar java versión 11. Esta instalación se puede realizar basado en el video tutorial:  https://www.youtube.com/watch?v=gsTU4OPMx_c&ab_channel=programadornovato

Se debe instalar apache maven 3.6.3. Esta instalación se puede realizar basado en el video tutorial: https://www.youtube.com/watch?v=8mARWZjcYhY&ab_channel=Zatiel


## Ejecución 
Como con cada aplicación Spring boot, esta puede ser ejecutada en la terminal usando el siguiente comando *./mvn spring-boot:run* 

Después de esto la aplicación puede ser accedida usando la siguiente url base *http://localhost:8080/basic*

## Prueba unitaria
Spring boot genera un archivo llamado "proyectoCalculadoraApplicationTests.java" en el directorio "test/java/com/calculadora/proyectoCalculadora", en este archivo se ejecutan las pruebas unitarias.(si sé está utilizando un editor de código como Visual studio code se debe instalar una extensión para realizar los test en este caso seria la extensión "Extension pack for java" la cual incluye la extensión para realizar tests).

## Instalación y configuración de jenkins
La instalación de jenkins se hizo de acuerdo a los pasos mostrados en la página oficial de Jenkins en el siguinte link: https://pkg.jenkins.io/debian-stable/

Se configura un puerto diferente al 8080 para la ejecución del servidor de Jenkins ya que este puerto sé está usando para ejecutar el servidor Tomcat de la aplicación, en mi caso configure el puerto 8081 para ejecutar el servidor de Jenkins así que la url para su configuración es: *http://localhost:8081*

Se creó una tarea en Jenkins y se exportó al archivo calculadora.xml que se encuentra en los archivos de jenkins de este repositorio. Para importar esta tarea se debe descargar el archivo jenkins-cli.jar en algún lugar de su computadora, para hacer esto debes copiar esta dirección URL en la barra de busqueda del navegador
para mi caso es: *localhost:8081/jnlpJars/jenkins-cli.jar* de esta forma se descargara este archivo en la computadora. Ahora deberás guardar el archivo calculadora.xml y el archivo jenkins-cli.jar en una misma ubicación y desde la terminal de comandos ubicado en esa ubicación debes ejecutar la siguiente linea de comando:

Java -jar jenkins-cli.jar -s http://localhost:8081 create-job nuevoNombreDeTarea < calculadora.xml

Esperas a que se ejecute el comando y luego abres la URL de tu Jenkins y veras la tarea creada la cual podras construir y ver la salida de consola.
