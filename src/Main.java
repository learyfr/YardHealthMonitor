import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yy HH:mm");
        try {
            Date eighteen = parser.parse("3/20/18 14:50");
            System.out.println(eighteen.toString());
            Date twenty = parser.parse("3/20/18 14:54");
            System.out.println(eighteen.compareTo(twenty));
            System.out.println("Twenty: " + twenty.getTime());
            System.out.println("Eighteen: " + eighteen.getTime());
            long diff = eighteen.getTime() - twenty.getTime();
            System.out.println(diff/60000+" minutes");

        } catch (ParseException e) {
            System.out.println("No worky");
            // Invalid Date
        }
    }
}
