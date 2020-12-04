import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */
public class EncryptedWords {


    /**
     * Recursive call.
     */
    static String findEncryptedWord(String s) {

        // **** initialization ****
        String r    = "";
        int mid     = 0;

        // **** [0] compute the position of of middle character in S ****
        mid = s.length() / 2;
        if (s.length() % 2 == 0)
            mid -= 1;

        // **** [1] append the middle character of S ****
        r += s.substring(mid, mid + 1);

        // **** [2] append the encrypted version of the substring of S 
        //      that's to the LEFT of the middle character (if non-empty) ****
        if (mid > 0) {

            // **** generate left sub string ****
            String ls = s.substring(0, mid);
    
            // **** encrypt and append ***
            r += findEncryptedWord(ls);
        }

        // **** [3] append the encrypted version of the substring of S 
        //      that's to the RIGHT of the middle character (if non-empty) ****
        if (mid < s.length() - 1) {

            // **** generate right sub string ****
            String rs = s.substring(mid + 1, s.length());

            // **** encrypt and append ****
            r += findEncryptedWord(rs);;
        }

        // **** return encrypted string ****
        return r;
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // **** read string ****
        String s = reader.readLine().trim();

        // **** close buffered reader ****
        reader.close();

        // ???? ????
        System.out.println("main <<< s ==>" + s + "<==");

        // **** encrypt string and display result ****
        System.out.println("main <<< r ==>" + findEncryptedWord(s) + "<==");
    }
}