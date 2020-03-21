package ru.spsuace.homework2.objects.simple;

import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Можно пользоваться Arrays.sort(arr), эта функция сортирует входящий массив
     */
    public static int[] getMaxArraySimple(int[] array, int count) {
        if (count > array.length) {
            return null;
        }
        int[] tempArray = Arrays.copyOf(array, array.length);
        Arrays.sort(tempArray);
        int lastElement = tempArray.length - 1;
        int[] formattedArray = new int[count];
        for (int i = 0; i <= count - 1; i++) {
            formattedArray[i] = tempArray[lastElement];
            lastElement -= 1;
        }
        return formattedArray;
    }

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если длина массива меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * Нельзя пользоваться Arrays.sort
     */
    public static int[] getMaxArrayHard(int[] array, int count) {
        int[] tempArray = Arrays.copyOf(array, array.length);
        if (tempArray.length < count) {
            return null;
        }

        int[] formattedArray = new int[count];

        if (count == 0) {
            return formattedArray;
        }

        for (int i = 0; i < tempArray.length; i++) {
            int min = tempArray[i];
            int min_i = i;
            for (int j = i + 1; j < tempArray.length; j++) {
                if (tempArray[j] < min) {
                    min = tempArray[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int temp = tempArray[i];
                tempArray[i] = tempArray[min_i];
                tempArray[min_i] = temp;
            }
        }
        for (int i = 0; i < count; i++) {
            formattedArray[i] = tempArray[tempArray.length - i - 1];
        }
        return formattedArray;
    }
}

