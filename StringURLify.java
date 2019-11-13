/**
 * Replace all spaces in str to %20
 * using only one str buffer rewriting it from the end
 */

public class StringURLify {

    public static void main(String[] args) {
        // given str
        StringBuilder str = new StringBuilder("http://john bo super");
        // remember initial str length
        int strLen = str.length() - 1;
        // count spaces in str using Java8 style
        long count = str.toString().chars().filter(ch -> ch == ' ').count();
        // make str wider to fit new %20
        for (int i = 1; i <= count * 2; i++) {
            str.append(' ');
        }
        // init writing index
        int writeIdx = str.length() - 1;
        // rewrite str from the end
        for (int idx = strLen; idx > 0; idx--) {
            char letter = str.charAt(idx);
            if (letter == ' ') {
                str.setCharAt(writeIdx, '0');
                str.setCharAt(writeIdx - 1, '2');
                str.setCharAt(writeIdx - 2, '%');
                writeIdx -= 3;
            } else {
                str.setCharAt(writeIdx, letter);
                writeIdx--;
            }
        }
        // print result
        System.out.println("'" + str + "'"); // 'http://john%20bo%20super'
    }

}
