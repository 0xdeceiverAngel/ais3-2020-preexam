import java.util.ArrayList;
import java.io.*;
import javax.swing.JLabel;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        JLabel[] text = new JLabel[9];
        text[0]=null;
        // String s;
        byte[] flag = new byte[] { 89, 74, 75, 43, 126, 69, 120, 109, 68, 109, 109, 97, 73, 110, 45, 113, 102, 64, 121,
                47, 111, 119, 111, 71, 114, 125, 68, 105, Byte.MAX_VALUE, 124, 94, 103, 46, 107, 97, 104 };

        ArrayList<Integer> cache = new ArrayList<>();
        FileReader fr = new FileReader("hell.txt");
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String s = br.readLine();
            if (s.charAt(0) != '*') 
            {
                int a = Integer.parseInt(s);
                cache.add(Integer.valueOf(a));

                // System.out.println(cache);
            }
        }
        br.close();
        System.out.println(cache.size());


        for (int i = 0; i < cache.size(); i++) {
            flag[i % flag.length] = (byte) ((flag[i % flag.length] ^ ((Integer) cache.get(i)).intValue()));
        }
        String fff = new String(flag);
        // s.setText(String.format("Flag: %s", new Object[] { fff }));
        // text[0].setText());
        System.out.println(String.format("Flag: %s", new Object[] { fff }));

        System.out.println(flag);
        System.out.println(fff);


    }
}
