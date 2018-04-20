# Transportes
Version de la aplicacion transportes
1. Título
Aplicacion para Android con datos de l'ajuntament de València

2. Introducción
El objetivo del proyecto es dar a conocer al usuario las estaciones mas cercanas al punto en el que se encuentra y al que
quiere ir, ademas facilitandole por medio de una mapa la ruta mas corta posible entre esos puntos.
De esta manera facilitamos el uso del transporte sostenible, aportando valor para el usuario al calcular la ruta mas corta.
El problema que resuelve es la falta de aplicaciones (quizá hay alguna, pero la oferta es escasa) que nos muestren la capacidad
de las estaciones valenbisi, y ademas nos marquen el camino mas corto entre ellas.

3. Descripción de la solución planteada
La solución que he planteado es geolocalizar al usuario en cuestión, y que nos introduzca una dirección a la que quiere llegar.
Por medio de la API de google, somos capaces de geolocalizar este punto, y por medio de una serie de calculos, marcamos dos 
estaciones valenbisi dentro de un mapa, que son las mas cercanas a cada uno de los puntos. 
Haciendo uso de otra de las funcionalidades de esta potente API, y apoyandonos en la programación en java, somos capaces de 
encontrar el camino mas corto entre estos dos puntos.

4. Metodología
La metodología empleada en el proyecto ha sido estudiada previamente a fin de sacar el máximo partido a la misma. Antes de 
comenzar el proyecto, no teniamos ninguna noción de programación en android, lo que ha supuesto un gran desafio. Dedicamos
una gran numero de hora a aprender a utilizar esta tecnología, que si bien es cierto, para la parte lógica utiliza como 
lenguaje java (ampliamente conocido y usado por los estudiantes que cursan nuestro grado), tiene ciertas particularidades que
resultan interesantes a la par que dificultosas de entender. También debiamos enteder como está estructurado un proyecto
de este estilo, y ver que elementos se utilizan dentro de esta estructura que lo diferencia de otro tipo de estructuras
vistas anteriormente.
Una vez aprendido (en la medida de lo posible) el complejo entramado, era hora de llevar a cabo un proceso en el que intentabamos
conocer las necesidades del usuario, así como sus gustos, para hacer una interfaz lo mas cómoda posible para el usuario final.
Como último paso, preparamos algunos test para ver que el comportamiento de la aplicacin era el adecuado, o al menos se 
acercaba a lo que inicialmente búscabamos.
 
5. Resultados
El funcionamiento de la aplicación no ha sido el deseado en un primer momento. Hemos tenido bastantes problemas con la obtencion
de los datos y la posterior manipulacion. 
Por medio de java si hemos sido capaces de extraer resultados en una aplicacin de escritorio, en la que tratabamos los datos
y los podiamos manipular. Pero en movilidad ha sido mucho mas complejo ya que tenemos unos parámetros temporales y de calculo
muy inferiores a los que poseemos en un PC. 
Ademas el tipo de datos que necesitabamos obtener en algunas ocasiones para, por ejemplo mostrar los resultados en un mapa, era 
demasiado complejo de obtener, y en algunos casos no hemos podido ni siquiera obtenerlos.

6. Guía de uso
Para el correcto funcionamiento de la aplicación, en primer lugar, hemos de permitir el acceso a la localización GPS de nuestro
dispositivo en la primera ocasión que se ejecute la aplicación en nuestro terminal. Una vez terminado este paso, ya podemos acceder
tantas veces como queramos a la misma sin problemas.
En la pantalla principal nos solicita que introduzcamos el lugar al que queremos ir. Hemos de introducirlo con el formato que nos 
indica el mismo EditText (CP calle, ciudad). Una vez este escrito, presionamos el botón calcular, lo que nos mostrará en pantalla
las coordenadas del punto seleccionado (si la API es capaz de localizarlo). En algunos casos puede no encontrar los puntos por
algún tipo de problema, pero generalmente lo hace. Si queremos mostrarlo en el mapa, debemos pulsar el botón que nos indica
que va a realizar esta acción. 
Así, pasamos a la siguiente pantalla, que es un mapa en el que nos muestra toda la Tierra. Para hacer focus en el punto en el
que nos encontramos, basta con pulsar el boton que tenemos en la esquina superior derecha. Así, veremos en una posición mas 
cercana el punto en el que nos encontramos y la ruta calculada.

7. Términos de uso
El contenido de este repositorio está sujeto a la licencia GNU General Public License v3.0.


