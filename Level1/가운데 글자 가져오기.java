class Solution {
    public String solution(String word) {
        return word.substring((word.length() - 1) / 2, word.length() / 2 + 1);
    }
}