class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] a = num1.split("\\+");
        String[] b = num2.split("\\+");
        int x1 = Integer.parseInt(a[0]);
        int y1 = Integer.parseInt(a[1].replace("i",""));
        int x2 = Integer.parseInt(b[0]);
        int y2 = Integer.parseInt(b[1].replace("i",""));
        int real = x1*x2 - y1*y2;
        int imag = x1*y2 + x2*y1;
        return real + "+" + imag + "i";
    }
}