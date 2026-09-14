class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;

        int count = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {

            char c = s.charAt(r);

            if (map.containsKey(c)) {

                if (map.get(c) > 0) {
                    count--;
                }

                map.put(c, map.get(c) - 1);
            }

            while (count == 0) {

                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);

                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }

                l++;
            }

            r++;
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}