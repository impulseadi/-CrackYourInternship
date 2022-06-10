class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int add = 0;

        for (int i = 1; i < Math.max(a.length(), b.length()) + 1; i++) {
            if(i <= a.length()) add += a.charAt(a.length() - i) - '0';
            if(i <= b.length()) add += b.charAt(b.length() - i) - '0';
            result.append(add % 2);
            add /= 2;
        }

        if (add > 0) result.append(1);
        return result.reverse().toString();
    }
}
