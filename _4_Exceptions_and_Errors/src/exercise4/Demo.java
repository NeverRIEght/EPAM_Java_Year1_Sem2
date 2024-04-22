package exercise4;

class Demo {

    public static int sum(int[] array, int fromIndex, int toIndex) {
        if (array == null) throw new IllegalArgumentException("Array is null");
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex > toIndex: " + fromIndex + " > " + toIndex);
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException("fromIndex < 0: " + fromIndex);
        }
        if (toIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException("toIndex >= array.length: " + toIndex);
        }

        int sum = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            sum += array[i];
        }

        return sum;
    }
}