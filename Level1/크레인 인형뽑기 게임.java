import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            move--;
            int doll = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][move] != 0) {
                    doll = board[i][move];
                    board[i][move] = 0;
                    break;
                }
            }
            
            if (doll != 0) {
                if (!stack.isEmpty() && stack.peek() == doll) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(doll);
                }
            }
        }
        return answer;
    }
}