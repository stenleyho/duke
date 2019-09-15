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
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        GetInPut();
    }

    public static void GetInPut() {
        String line;
        int count = 0;
//        String[] data = new String[100];
        Scanner input = new Scanner(System.in);
        line = input.toString();
        Task[] t = new Task[100];

//    while(true) {
//        switch (line.toUpperCase()) {
//            case "LIST":
//                GetList(t, count);
//                break;
//            case "BYE":
//                System.out.println("Bye. Hope to see you again soon!");
//                break;
//            case "DONE":
//                int line_num = Integer.parseInt(line.split(" ")[1]);
////                System.out.println("im here");
//                for (int i = 0; line_num == i; i++) {
//                    t[line_num].markAsDone();
//                    System.out.println("this is" + line_num);
//                    break;
//                }
//            default:
//                    t[count] = new Task(line);
//                    StoreList(t, line, count);
//                    count++;
//                    break;
//                }
//        }
//    }
        while (!line.equalsIgnoreCase("bye")) {
            line = input.nextLine();

            if (line.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            if (line.split(" ")[0].equalsIgnoreCase("done")) {
                int line_num = Integer.parseInt(line.split(" ")[1]);
//                System.out.println("this is " + line_num);
                    t[line_num-1].markAsDone();
            }
            if (line.equalsIgnoreCase("list")) {
                GetList(t, count);
            }
            else if(!line.equalsIgnoreCase("list")&&
                    !line.split(" ")[0].equalsIgnoreCase("done")) {
                t[count] = new Task (line);
                StoreList(t, line, count);
                count++;
            }
        }
    }

    public static Task[] StoreList(Task[] t, String line, int count) {
        t[count] = new Task(line);
        System.out.println("added:" + line);
        return t;
    }

    public static void GetList(Task[] t, int count) {
        for (int i=0; i<count; i++) {
            String icon = t[i].getStatusIcon();
            System.out.println(i + 1 + "." + "["+ icon +"]" + t[i].getDescription());
        }
    }
}
