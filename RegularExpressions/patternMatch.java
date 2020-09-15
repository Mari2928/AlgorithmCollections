import java.util.*;
import java.util.regex.*;

/*
 * Regular expression pattern match. "riya riya@gmail.com" -> "riya" 
 */
static void regExPatternMatch() {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    ArrayList<String> bag = new  ArrayList<>();

    for (int NItr = 0; NItr < N; NItr++) {
        String[] firstNameEmailID = scanner.nextLine().split(" ");

        String firstName = firstNameEmailID[0];
        String emailID = firstNameEmailID[1];
        // gmailを含むstringを見つける
        String myRegExString = "@gmail.com";
        Pattern p = Pattern.compile(myRegExString);
        Matcher m = p.matcher(firstNameEmailID[1]);            
        if( m.find() ) {
            bag.add(firstNameEmailID[0]);               
        }
    }
    scanner.close();
    Collections.sort(bag);
    for(int i = 0; i < bag.size(); i++){
         System.out.println(bag.get(i));
    }
}
