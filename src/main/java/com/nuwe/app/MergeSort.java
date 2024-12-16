package com.nuwe.app;

public class MergeSort {
    // Método principal que inicia el proceso
    public static void mergeSort(int[] arr) {
        // Si el array está vacío o tiene un solo elemento, ya está ordenado
        if (arr == null || arr.length <= 1) return;

        // Llamamos al método recursivo con el rango completo
        mergeSort(arr, 0, arr.length - 1);
    }

    // Método recursivo que divide y ordena el array
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Encontramos el punto medio del array
            int mid = left + (right - left) / 2;

            // Ordenamos recursivamente la primera mitad
            mergeSort(arr, left, mid);

            // Ordenamos recursivamente la segunda mitad
            mergeSort(arr, mid + 1, right);

            // Combinamos las mitades ordenadas
            merge(arr, left, mid, right);
        }
    }

    // Método para combinar dos subarrays ordenados
    public static void merge(int[] arr, int left, int mid, int right) {
        // Calculamos el tamaño de los subarrays temporales
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Creamos arrays temporales
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copiamos los datos a los arrays temporales
        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];

        // Índices iniciales para los tres arrays
        int i = 0, j = 0; // Índices para leftArray y rightArray
        int k = left;     // Índice para el array original

        // Proceso de combinación ordenada
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copiamos los elementos restantes de leftArray, si hay alguno
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copiamos los elementos restantes de rightArray, si hay alguno
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}