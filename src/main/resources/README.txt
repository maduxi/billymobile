
En esta prueba hay dos ejercicios de programación en Java. Lo que se valorará, más allá de resolverlo correctamente, será el enfoque en la resolución que se ha tomado. Si no logras resolverlo por falta de tiempo o por quedarte encallado no te preocupes, simplemente explica cómo lo resolverías. A parte del tiempo que os dejamos aquí, tendrás 24horas adicionales para que puedas acabar o mejorar la propuesta inicial.


Ejercicio 1
=======================


El problema es el siguiente : el archivo adjunto(int_list.txt)  tiene números enteros del 1 a 1,000,000, puede haber repetidos y están desordenados. El archivo contiene un número por cada linea.

Consiste en encontrar dos pares de números que sumen estos números : 

231552,234756,596873,648219,726312,981237,988331,1277361,1283379

Si algún número no se puede encontrar simplemente especificarlo.



Ejercicio 2 
================================

Como input tienes un fichero en el que cada línea especifica un rango de números consecutivos definido por el número inicial y final [a b]  donde a < b . Por ejemplo [2 ,  5] especifica los números 2,3,4,5 .
El ejercicio es calcular la cantidad de números distintos que estan comprendidos en la unión de todos los rangos definidos en el fichero, teniendo en cuenta que los rangos pueden estar solapados o incluidos en otros rangos. Los números pueden estar comprendidos entre 0 y 2^31.

Por ejemplo, dados estos rangos : 
[1 4] 
[6 10]
[13 , 15]
[2 ,4]

La respuesta sería 12, ya que hay 12 números comprendidos entre todos los rangos:  1 , 2 , 3, 4 , 6 , 7, 8 , 9 , 10 , 13, 14, 15 

Devolver el resultado tanto para el fichero 'range_small.txt' como para 'range_large.txt'.
