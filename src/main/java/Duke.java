import java.util.*;

public class Duke {
    private static Task[] tasks = new Task[100];
    private static int tCount = 0;

    public static void addTask(Task t){
        tasks[tCount] = t;
        System.out.println("-----------------------------------------------");
        System.out.println("added:" + t.getDescription());
        System.out.println("-----------------------------------------------");
        tCount++;
    }

    public static void GetList() {
        System.out.println("-----------------------------------------------");
            for (int i=0; i<tCount; i++) {
                System.out.println(i + 1 + ". " + tasks[i]);
            }
        System.out.println("-----------------------------------------------");
    }

    public static void markAsDone(int pos) {
         tasks[pos-1].markAsDone(true);
        System.out.println("-----------------------------------------------");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("    [" +  tasks[pos-1].getStatusIcon() + "]" +  tasks[pos-1].getDescription());
        System.out.println("-----------------------------------------------");
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String line;
        String [] linePart;
        while(true) {
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            linePart = line.split(" ", 2);
            switch (line.toUpperCase()) {
                case "LIST":
                    GetList();
                    break;
                case "BYE":
                    System.out.println("Bye. Hope to see you again soon!");
                    return;
                default:
                    switch (linePart[0].toUpperCase())
                    {
                        case "DONE":
			                markAsDone(Integer.parseInt(linePart[1]));
                            break;
                        case "TODO":
                            addTask(new Todo(linePart[1]));
                            break;
                        case "DEADLINE":
                            String DeadlineArr[] = linePart[1].split("/by", 2);
                            addTask(new Deadlines(DeadlineArr[0],DeadlineArr[1])); ;
                            break;
                        case "EVENT":
                            String EventArr[] = linePart[1].split("/at", 2);
                            addTask(new Events(EventArr[0],EventArr[1])); ;
                            break;
                        default:
                            System.out.println("Please type 'Todo' or 'Deadline /by' or 'Event /at' to add task. Type 'List' to see tasks and 'Bye' to exit");
//                            addTask(new Todo(line));
                    }
                    break;
            }
        }
    }

    public static void addTask(Todo t){
        tasks[tCount] = t;
        System.out.println("-----------------------------------------------");
        System.out.println("Got it. I've added this task: :");
        System.out.println(t);
        tCount++;
        System.out.println("Now you have " + tCount + " tasks in the list");
        System.out.println("-----------------------------------------------");
    }

    public static void addTask(Deadlines t){
        tasks[tCount] = t;
        System.out.println("-----------------------------------------------");
        System.out.println("Got it. I've added this task: :");
        System.out.println(t);
        tCount++;
        System.out.println("Now you have " + tCount + " tasks in the list");
        System.out.println("-----------------------------------------------");
    }

    public static void addTask(Events t){
        tasks[tCount] = t;
        System.out.println("-----------------------------------------------");
        System.out.println("Got it. I've added this task: :");
        System.out.println(t);
        tCount++;
        System.out.println("Now you have " + tCount + " tasks in the list");
        System.out.println("-----------------------------------------------");
    }
}
