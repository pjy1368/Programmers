import java.util.*;

class NumSet implements Comparable<NumSet> {
	int before;
	int now;

	NumSet(int before, int now) {
		this.before = before;
		this.now = now;
	}

	@Override
	public int compareTo(NumSet o) {
		return o.now - now;
	}

}
class Solution {
    public String solution(int[] numbers) {
        NumSet[] numSet = new NumSet[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			int before = numbers[i], now = 0;

			String str = String.valueOf(numbers[i]);
			int n = str.length();

			String input = "";
			switch (n) {
			case 0:
				numSet[i] = new NumSet(0, 0);
				break;
			case 1:
				input = str + str + str + str;

				now = Integer.parseInt(input);
				numSet[i] = new NumSet(before, now);
				break;
			case 2:
				input = str + str;

				now = Integer.parseInt(input);
				numSet[i] = new NumSet(before, now);
				
				break;
			case 3:
				input = str + str.charAt(0);

				now = Integer.parseInt(input);
				numSet[i] = new NumSet(before, now);
				break;
			case 4:
				numSet[i] = new NumSet(before, before);
				break;
			}
		}
		Arrays.sort(numSet);

		String answer = "";
		for (int i = 0; i < numSet.length; i++) {
			answer += numSet[i].before;
		}
		
		if(answer.charAt(0) == '0') {
			return "0";
		}
        return answer;
    }
}