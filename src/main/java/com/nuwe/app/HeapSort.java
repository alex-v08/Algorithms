package com.nuwe.app;

public class HeapSort {
    // Función para mantener la propiedad de max-heap
    public static void heapify(int[] arr, int n, int i) {


            // Asumimos que el nodo raíz es el más grande
            int largest = i;
            int leftChild = 2 * i + 1;  // Índice del hijo izquierdo
            int rightChild = 2 * i + 2; // Índice del hijo derecho

            // Comparamos con el hijo izquierdo
            if (leftChild < n && arr[leftChild] > arr[largest])
                largest = leftChild;

            // Comparamos con el hijo derecho
            if (rightChild < n && arr[rightChild] > arr[largest])
                largest = rightChild;

            // Si el más grande no es la raíz
            if (largest != i) {
                // Intercambiamos la raíz con el más grande
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Recursivamente heapify el subárbol afectado
                heapify(arr, n, largest);
            }

    }

    public static void heapSort(int[] arr) {

        int n = arr.length;

        // FASE 1: Construcción del heap máximo
        // Comenzamos desde el último nodo padre (n/2 - 1)
        // y vamos hacia arriba hasta la raíz
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // FASE 2: Extracción de elementos uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Movemos la raíz actual (el elemento más grande)
            // al final del array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamamos heapify en el heap reducido
            // para mantener la propiedad de max-heap
            heapify(arr, i, 0);
        }
}
}

