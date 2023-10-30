import java.util.ArrayList;
import java.util.Arrays;

public class FrogA {

    private class Node {

        private Node next;
        private Node value;

    }

    // Email about the output of the file, refer to p5) for the requred output.
    public static void main(String[] args) throws Exception {

        int[] arr = { 2,1,2 };
        ArrayList<Integer> sequence = new ArrayList<>();
        // sequence.add(0);
        int[] path = new int[arr.length];
        sequence = func(arr, 0, sequence, path);

        System.out.println(sequence.toString());
    }

    // only jumps i + 1 & i + 2, and cannot be greater than arr.length - 1
    // Each rock has a height of H[i]
    // NRG = | H[i] - H[j]|

    // Takes in our rocks array
    public static ArrayList<Integer> func(int[] arr, int position, ArrayList<Integer> sequence, int[] path) {

        int energy = 0;

        if (position >= arr.length - 1) {
            energy = Math.abs(arr[arr.length - 1] - arr[1]);
            path[0] = energy;
            System.out.println("path: " + Arrays.toString(path));
            return sequence;
        }

        if (position + 2 < arr.length) {
            path[1] = 1;
            if (arr[position + 1] > arr[position + 2]) {
                sequence.add(position + 1);
                position = position + 1;
                path[position] = 1;
                return func(arr, position, sequence, path);

            } else if (arr[position + 1] < arr[position + 2]) {
                sequence.add(position + 2);
                position = position + 2;
                path[position] = 1;
                return func(arr, position, sequence, path);

            } else if (arr[position + 1] == arr[position + 2]) {
                sequence.add(position + 1);
                position = position + 1;
                path[position] = 1;
                return func(arr, position, sequence, path);
            }
        }

        energy = Math.abs(arr[arr.length - 1] - arr[1]);
        path[0] = energy;
        System.out.println("path: " + Arrays.toString(path));
        return sequence;

    }
}
