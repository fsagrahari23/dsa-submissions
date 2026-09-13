class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0;
        int r = 1;

        int max = 1;

        while (r < s.length()) {

            // first different character ka index
            int temp = -1;

            int remaining = k;

            while (r < s.length()) {

                if (s.charAt(r) != s.charAt(l)) {

                    if (temp == -1) {
                        temp = r;
                    }

                    if (remaining == 0) {
                        break;
                    }

                    remaining--;
                }

                r++;
            }

            max = Math.max(max, r - l);

            // next window yahan se start hogi
            if (temp != -1) {
                l = temp;
                r = temp + 1;
            } else {
                break;
            }
        }

        return max;
    }
}