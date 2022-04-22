import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void menu() {

        final int DEFAULT_N = 10;
        int answer;
        String fileName;

        while (true) {
            System.out.println("Select a task. Enter 1 for Fibonacci Numbers, 2 for JSON Parser, 0 to close the program.");
            try {
                Scanner input = new Scanner(System.in);
                answer = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                answer = 3;
            }

            if (answer == 1) {
                System.out.println("Enter the required number.");
                try {
                    Scanner input = new Scanner(System.in);
                    answer = input.nextInt();
                } catch (java.util.InputMismatchException e) {
                    answer = DEFAULT_N;
                }
                task1(answer);

            } else if (answer == 2) {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter the file name.");
                fileName = input.next();
                try {
                    task2(fileName);
                } catch (IOException | ParseException e) {
                    System.out.println("Incorrect file. Please check the file and try again");
                }

            } else if (answer == 0) {
                System.out.println("OK, goodbye.");
                return;
            } else {
                System.out.println("Please enter a valid value.");
            }
        }
    }

    public static void task1(int N) {
        int n0 = 0;
        int n1 = 1;
        int n2;
        System.out.print(n0 + " " + n1 + " ");

        for (int i = 2; i <= N; i++) {
            n2 = n0 + n1;
            System.out.print(n2 + " ");
            n0 = n1;
            n1 = n2;
        }
        System.out.println();
    }

    public static void task2(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(fileName));

        Set<String> keySet = jsonObject.keySet();
        Iterator<String> iterator = keySet.iterator();
        String str;
        while (iterator.hasNext()) {
            str = iterator.next();
            System.out.print(str + " ");
            System.out.println(jsonObject.get(str).toString());

        }
        // Additionally
        System.out.println(jsonObject);
    }

    public static void main(String[] args) {
        menu();
    }
}
