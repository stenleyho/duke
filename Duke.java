import java.util.*;

public class Duke {
    private static Task[] tasks = new Task[100];
    private static ArrayList<Task> Arrtasks = new ArrayList<>();
    private static int tCount = 0;

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
            try {
                switch (line.toUpperCase()) {
                    case "LIST":
                        GetList();
                        break;
                    case "BYE":
                        System.out.println("Bye. Hope to see you again soon!");
                        return;
                    default:
                        switch (linePart[0].toUpperCase()) {
                            case "DONE":
                                goMarkDone(Integer.parseInt(linePart[1]));
                                break;
                            case "TODO":
                                if (linePart[1].isBlank()){
                                    throw new ArrayIndexOutOfBoundsException();
                                } else{
                                    addTask(new Todo(linePart[1]));
                                }
                                break;
                            case "DEADLINE":
                                String DeadlineArr[] = linePart[1].split("/by", 2);
                                addTask(new Deadlines(DeadlineArr[0], DeadlineArr[1]));
                                ;
                                break;
                            case "EVENT":
                                String EventArr[] = linePart[1].split("/at", 2);
                                addTask(new Events(EventArr[0], EventArr[1]));
                                ;
                                break;
                            case "DELETE":
                                deleteTask(Integer.parseInt(linePart[1]));
                                break;
                            default:
                                throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                        }
                        break;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("OOPS!!! The description of todo cannot be empty");
            }
            catch (DukeException e){
                System.out.println(e);
                System.out.println("Please type 'Todo' or 'Deadline /by' or 'Event /at' to add task. Type 'List' to see tasks and 'Bye' to exit");
            }
        }
    }

    public static void addTask(Todo t){
        Arrtasks.add(t);
        System.out.println("-----------------------------------------------");
        System.out.println("Got it. I've added this task: :");
        System.out.println(t);
        tCount++;
        System.out.println("Now you have " + tCount + " tasks in the list");
        System.out.println("-----------------------------------------------");
    }

    public static void addTask(Deadlines t){
        Arrtasks.add(t);
        System.out.println("-----------------------------------------------");
        System.out.println("Got it. I've added this task: :");
        System.out.println(t);
        tCount++;
        System.out.println("Now you have " + tCount + " tasks in the list");
        System.out.println("-----------------------------------------------");
    }

    public static void addTask(Events t){
        Arrtasks.add(t);
        System.out.println("-----------------------------------------------");
        System.out.println("Got it. I've added this task: :");
        System.out.println(t);
        tCount++;
        System.out.println("Now you have " + tCount + " tasks in the list");
        System.out.println("-----------------------------------------------");
    }

    public static void GetList() {
        System.out.println("-----------------------------------------------");
        for (int i=0; i<Arrtasks.size(); i++) {
            System.out.println(i + 1 + ". " + Arrtasks.get(i));
        }
        System.out.println("-----------------------------------------------");
    }

    public static void goMarkDone(int pos) {
        Arrtasks.get(pos - 1).markAsDone();
        System.out.println("-----------------------------------------------");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(Arrtasks.get(pos-1));
        System.out.println("-----------------------------------------------");
    }

    public static void deleteTask(int pos){
        System.out.println("-----------------------------------------------");
        System.out.println("Noted. I've removed this task:");
        System.out.println(Arrtasks.get(pos-1));
        Arrtasks.remove(pos-1);
        tCount--;
        System.out.println("Now you have " + tCount + " tasks in the list");
    }
}
