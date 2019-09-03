import java.util.Scanner;
import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        GetInPut();
    }

    public static void GetInPut() {
        String line;
        Scanner input = new Scanner(System.in);
        line = input.toString();

        while (!line.equalsIgnoreCase("bye")) {
            line = input.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                break;
            }
            System.out.println(line);
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}

