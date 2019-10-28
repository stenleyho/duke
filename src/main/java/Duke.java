import java.util.*;
import java.lang.String;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Duke {
    private static ArrayList<Task> Arrtasks = new ArrayList<>();
    private static String FilePath="Task.txt";

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
        File f = new File("Task.txt");
        System.out.println("-----------------------------------------------");
        System.out.println("Full path: " + f.getAbsolutePath());
        System.out.println("File exists?: " + f.exists());
        try{
            loadFileToMemory();
        }
        catch (FileNotFoundException e){
            System.out.println("File Task.txt Not Found!");
        }
        System.out.println("File Task.txt successfully loaded into system memory");
        System.out.println("-----------------------------------------------");
        System.out.println("Please enter 'Todo' or 'Deadline /by' or 'Event /at' to create task. 'Delete' to remove task. 'List' to see tasks and 'Bye' to exit");
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
                                markAsDone(Integer.parseInt(linePart[1]),true);
                                break;
                            case "TODO":
                                if (linePart[1].isBlank()){
                                    throw new ArrayIndexOutOfBoundsException();
                                } else{
                                    addTask(new Todo(linePart[1]),true);
                                }
                                break;
                            case "DEADLINE":
                                String DeadlineArr[] = linePart[1].split("/by", 2);
                                addTask(new Deadlines(DeadlineArr[0], DeadlineArr[1]),true);
                                ;
                                break;
                            case "EVENT":
                                String EventArr[] = linePart[1].split("/at", 2);
                                addTask(new Events(EventArr[0], EventArr[1]),true);
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
                System.out.println("Please enter 'Todo' or 'Deadline /by' or 'Event /at' to create task. 'Delete' to remove task. 'List' to see tasks and 'Bye' to exit");
            }
        }
    }

    public static void addTask(Todo t, boolean tAppend){
        Arrtasks.add(t);
        if (tAppend == true) {
            System.out.println("-----------------------------------------------");
            System.out.println("Got it. I've added this task: :");
            System.out.println(t);
            System.out.println("Now you have " + Arrtasks.size() + " tasks in the list");
            System.out.println("-----------------------------------------------");
            writeTasks();
        }
    }

    public static void addTask(Deadlines t, boolean tAppend){
        Arrtasks.add(t);
        if (tAppend == true) {
            System.out.println("-----------------------------------------------");
            System.out.println("Got it. I've added this task: :");
            System.out.println(t);
            System.out.println("Now you have " + Arrtasks.size() + " tasks in the list");
            System.out.println("-----------------------------------------------");
            writeTasks();
        }
    }

    public static void addTask(Events t, boolean tAppend){
        Arrtasks.add(t);
        if (tAppend ==  true) {
            System.out.println("-----------------------------------------------");
            System.out.println("Got it. I've added this task: :");
            System.out.println(t);
            System.out.println("Now you have " + Arrtasks.size() + " tasks in the list");
            System.out.println("-----------------------------------------------");
            writeTasks();
        }
    }

    public static void GetList() {
        System.out.println("-----------------------------------------------");
        for (int i=0; i<Arrtasks.size(); i++) {
            System.out.println(i + 1 + ". " + Arrtasks.get(i));
        }
        System.out.println("-----------------------------------------------");
    }

    public static void markAsDone(int pos, boolean tIcon) {
        Arrtasks.get(pos-1).markAsDone(true);
        if (tIcon == true) {
            System.out.println("-----------------------------------------------");
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("    [" + Arrtasks.get(pos - 1).getStatusIcon() + "]" + Arrtasks.get(pos - 1).getDescription());
            System.out.println("-----------------------------------------------");
            writeTasks();
        }
    }

    public static void deleteTask(int pos){
        System.out.println("-----------------------------------------------");
        System.out.println("Noted. I've removed this task:");
        System.out.println("    [" +  Arrtasks.get(pos-1).getStatusIcon() + "]" +  Arrtasks.get(pos-1).toString());
        Arrtasks.remove(pos-1);
        System.out.println("Now you have " + Arrtasks.size() + " tasks in the list");
        System.out.println("-----------------------------------------------");
        writeTasks();
    }

    public static void writeTasks()
    {
        try{
            if (Arrtasks.size() == 0) {
                saveFile(FilePath, "", false);
            }
            else {
                for (int i = 0; i < Arrtasks.size(); i++) {
                    saveFile(FilePath, Arrtasks.get(i).writeToFile(), i == 0 ? false : true);
                }
            }
        } catch (IOException e)
        {
            System.out.println("Error write to file!!");
        }
    }

    public static void saveFile(String filePath, String textNew, boolean isAppend)  throws IOException
    {
        FileWriter fw;
        if (isAppend==true)
        {
            fw = new FileWriter(filePath,true);
        }
        else {
            fw = new FileWriter(filePath);

        }
        fw.write(textNew);
        fw.write(System.getProperty( "line.separator"));
        fw.close();
    }

    public static void loadFileToMemory() throws FileNotFoundException
    {
        String [] linearr;
        String line;
        int i=0;
            File f = new File(FilePath);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                line = s.nextLine();
                linearr = line.split(" \\| ");
                i++;
                switch (linearr[0].toUpperCase())
                {
                    case "T":
                        addTask(new Todo(linearr[2]), false);
                        if(linearr[1].equals("1")){
                            markAsDone(i,false);
                        }
                        break;
                    case "D":
                        addTask(new Deadlines(linearr[2], linearr[3]), false);
                        if(linearr[1].equals("1")){
                            markAsDone(i,false);
                        }
                        break;
                    case "E":
                        addTask(new Events(linearr[2], linearr[3]), false);
                        if(linearr[1].equals("1")){
                            markAsDone(i,false);
                        }
                        break;
                }
            }
    }
}
