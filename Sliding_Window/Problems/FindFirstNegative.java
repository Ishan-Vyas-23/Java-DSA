package Sliding_Window.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindFirstNegative {

//https://www.geeksforgeeks.org/dsa/first-negative-integer-every-window-size-k/
    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // creating first window
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                q.add(i);
            }
        }

        // adding first element
        if (!q.isEmpty()) {
            list.add(arr[q.peek()]);
        } else {
            list.add(0);
        }

        // sliding window
        for (int i = k; i < arr.length; i++) {
            // remove elements out of this window
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.remove();
            }

            int entering = arr[i];
            if (entering < 0) {
                q.add(i);
            }

            if (!q.isEmpty()) {
                list.add(arr[q.peek()]);
            } else {
                list.add(0);
            }
        }

        return list;
    }
}
