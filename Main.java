import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.net.URL;

public class Main {

    static final int numberOfStudents = 15;

    public static void main(String[] args) {
        System.out.println("Randomized list of numbers from 1 to " + numberOfStudents + "  based on RANDOM.ORG entropy source:\n");

        try {

            int randomSeed = Integer.parseInt(new BufferedReader(
                    new InputStreamReader(
                            new URL("https://www.random.org/integers/?num=1&min=1&max=100000&col=1&base=10&format=plain&rnd=new").openStream()
                    )
            ).readLine());

            List<Integer> l = IntStream.rangeClosed(1,numberOfStudents).boxed().collect(Collectors.toList());

            Collections.shuffle( l, new Random( randomSeed ) );

            System.out.println( l );

        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }


    }
}
