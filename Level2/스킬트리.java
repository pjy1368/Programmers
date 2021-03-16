import java.util.HashMap;
import java.util.Map;

class SkillInfo {

    int pos;
    boolean check;

    SkillInfo(int pos, boolean check) {
        this.pos = pos;
        this.check = check;
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        final char[] chars = skill.toCharArray();

        int ans = 0;
        outer: for (final String skill_tree : skill_trees) {
            final Map<Character, SkillInfo> skills = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                skills.put(chars[i], new SkillInfo(i, false));
            }

            for (final char c : skill_tree.toCharArray()) {
                if (!skills.containsKey(c)) {
                    continue;
                }

                final int pos = skills.get(c).pos;

                if (pos == 0) {
                    skills.get(c).check = true;
                    continue;
                }

                final char before = chars[pos - 1];
                if (!skills.get(before).check) {
                    continue outer;
                }
                skills.get(c).check = true;
            }
            ans++;
        }
        return ans;
    }
}