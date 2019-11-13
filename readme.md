
Las prácticas realizadas en la asignatura Diseño de Interfaces de Usuario en la Universidad de Las Palmas de Gran Canaria, otoño 2019.  
Todas las prácticas usan Java 1.8 y Swing.

[Ver screenshots de aplicaciones en Google Drive](https://drive.google.com/open?id=1h6EhFd0-cS6E1Zv6pzDUVUyoEg3_Z4sV)

#### Filtrado de matrices
La aplicación genera una matriz de valores aleatorios entre dos valores delimitantes. Luego se determina el valor del filtrado y se borran todos los valores en la matriz menores de este filtrado.

#### Estadísticas subimagen
El programa calcula las estadísticas (valores mínimo, promedio, máximo) del rectángulo visible de una imagen. Se puede controlar es espacio visible a través de las barras deslizadoras y cambiando el tamaño de la ventana.

La clase EstadísticasImagen fue proveída para la realización de la tarea.  

#### Umbralizar imagenes
Es necesario adjuntar la librería [OpenCV](https://opencv.org/releases/) para realizar el umbralizado.

Umbralizado de imágenes seleccionadas por el usuario. La aplicación maneja ventanas internas en las cuales se abren las imágenes procesadas. Es posible guardar imágenes y está asegurado que no se pierdan los resultados al cerrar el programa. Las ventanas internas se desplazan automáticamente al diminuir el tamaño de la ventana principal así que quedan todas siempre visibles. 

#### Compresor de ficheros
Compresor al formato ZIP usando SwingWorker para procesar la tarea en fondo.
