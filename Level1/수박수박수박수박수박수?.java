class Solution {
    public String solution(int n) {
        // 수박 글자를 5,000개 쓴 데이터를 저장하고, substring() 함수를 이용하여 풀어도 무방함.
        return new String(new char[n / 2 + 1]).replace("\0", "수박").substring(0, n);
    }
}
