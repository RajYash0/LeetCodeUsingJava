class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;

        String s3 = swap(s1, 0, 2);
        String s4 = swap(s3, 1, 3);
        if (s3.equals(s2) || s4.equals(s2)) {
            return true;
        }

        String s5 = swap(s1, 1, 3);
        String s6 = swap(s5, 0, 2);
        if (s5.equals(s2) || s6.equals(s2)) {
            return true;
        }

        return false;
    }

    private String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();

        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return new String(charArray);
    }
}
