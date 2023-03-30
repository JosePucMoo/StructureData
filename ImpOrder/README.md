# Implementación de ordenamientos

## Descripción:

El programa consiste en ordenar un dataset de 1000 canciones con 4 formas de ordenamientos:

1. BinaryInsertionSort    
2. MergeSort    
3. QuickSort
4. RadixSort

Nuestra base de datos es el dataset, el cual contiene 1000 canciones con métricas de flujo de cada artista y sus respectivas canciones. Las columnas del dataset son las siguientes:

- Position: Es el ranking en Spotify
- Artist Name: Nombre del artista
- Song name: Nombre de la canción
- Days: Días desde el lanzamiento de la canción
- Top 10(xTimes): Número de veces dentro del top 10
- Peak Position: Posición máxima alcanzada
- Peak Position (xTimes): Número de veces que se alcanzó la posición máxima
- Peak Streams: Número total de flujos durante la posición pico
- Total Streams: Transmisiones totales de canciones

El programa consiste en ordenar el conjunto de datos de acuerdo a dos de las nueve columnas(métricas) del dataset. El usuario puede ordenar de acuerdo a los nombres de las canciones o el número de días desde el lanzamiento, así como si desea que el ordenamiento sea ascendente o descendente.

* En el caso de elegir un ordenamiento por nombres de la canciones, entonces el programa ordenará con los métodos:

    1. BinaryInsertionSort
    2. MergeSort
    3. QuickSort


* Si elige un ordenamiento por días de lanzamiento, entonces el programa ordenará por todos los métodos:

    1. BinaryInsertionSort
    2. MergeSort
    3. QuickSort
    4. RadixSort

En ambos casos se creará un archivo llamado "Métricas.csv" el cual se encuentra en la carpeta -orderData- y también un archivo por cada método de ordenamiento que se utilice donde se almacenarán los datos ordenados de cada método.

## Clonar el repositorio




