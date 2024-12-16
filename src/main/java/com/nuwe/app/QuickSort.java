package com.nuwe.app;

public class QuickSort {
    // Método principal que inicia el proceso de ordenamiento
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    // Método recursivo de QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Obtenemos el índice del pivote después de la partición
            int pi = partition(arr, low, high);

            // Ordenamos recursivamente los elementos antes y después de la partición
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Método para particionar el array alrededor del pivote
    public static int partition(int[] arr, int low, int high) {
        // Elegimos el último elemento como pivote
        int pivot = arr[high];

        // Índice del elemento más pequeño
        int i = (low - 1);

        // Recorremos todos los elementos
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (arr[j] < pivot) {
                i++; // Incrementamos el índice del elemento más pequeño
                swap(arr, i, j);
            }
        }

        // Colocamos el pivote en su posición correcta
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Método auxiliar para intercambiar elementos
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}