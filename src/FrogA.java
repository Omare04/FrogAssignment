import java.util.ArrayList;

public class FrogA {

    private class Node {

        private Node next;
        private Node value;

    }


    //Email about the output of the file, refer to p5) for the requred output. 
    public static void main(String[] args) throws Exception {

        int[] arr = {4, 10, 20, 5, 20, 10, 10, 4, 11};
        ArrayList<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        sequence = func(arr, 0, sequence);

        System.out.println(sequence.toString());
    }

    // only jumps i + 1 & i + 2, and cannot be greater than arr.length - 1
    // Each rock has a height of H[i]
    // NRG = | H[i] - H[j]|

    // Takes in our rocks array
    public static ArrayList<Integer> func(int[] arr, int position, ArrayList<Integer> sequence) {

        if (position >= arr.length - 1) {
            return sequence;
        }

        if (position + 2 < arr.length) {

            if (arr[position + 1] > arr[position + 2]) {
                sequence.add(position + 1);
                position = position + 1;
                return func(arr, position, sequence);

            } else if (arr[position + 1] < arr[position + 2]) {
                sequence.add(position + 2);
                position = position + 2;
                return func(arr, position, sequence);

            } else if (arr[position + 1] == arr[position + 2]) {
                sequence.add(position + 1);
                position = position + 1;
                return func(arr, position, sequence);
            }
        }

        return sequence;
    }
}
