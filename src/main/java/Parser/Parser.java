package Parser;

import Ui.Ui;
import Command.*;
import Exception.DukeException;


public class Parser {

    public static Command parse (String commandline) throws DukeException
    {
        String[] command = commandline.split(" ",2);

        switch(command[0].toUpperCase())
        {
            case "LIST":
                return new ListCommand(commandline);
            case "BYE":
                return new ByeCommand();
            case "DONE":
                return new DoneCommand(commandline);
            case "DELETE":
                return new DeleteCommand(commandline);
            case "TODO":
                return new TodoCommand(commandline);
            case "DEADLINE":
                return new DeadlineCommand(commandline);
            case "EVENT":
                return new EventCommand(commandline);
            default:
                throw new DukeException("Please enter 'Todo' or 'Deadline /by' or 'Event /at' to create task. 'Delete' to remove task. 'List' to see tasks and 'Bye' to exit" + System.lineSeparator());
        }
    }

    public static Command parseFile (String commandline) throws DukeException
    {
        String[] command = commandline.split(" ",2);
        switch(command[0].toUpperCase())
        {
            case "T":
                return new TodoCommand(commandline);
            case "D":
                return new DeadlineCommand(commandline);
            case "E":
                return new EventCommand(commandline);
            default:
                throw new DukeException("Corrupted file. Please replace the file Task.txt in Data folder" + System.lineSeparator());
        }
    }

    public static String parseTodo (String commandline) throws DukeException
    {
        String [] linearr;
        linearr = commandline.split(" ", 2);

        if (linearr.length != 2){
            throw new DukeException("Invalid Todo input. Enter todo ");
        }
        if (linearr[1].equals("")){
            throw new DukeException("Todo cannot be empty");
        }
        return linearr[1];
    }

    public static String[] parseDeadline(String commandline) throws DukeException
    {
        String [] linearr;
        linearr = commandline.split(" ", 2);

        if (linearr.length !=2){
            throw new DukeException("Invalid Deadline input");
        }

        String DL_date[] = linearr[1].split("/by", 2);
        if (DL_date.length != 2){
            throw new DukeException("Invalid Deadline input. Enter deadline /by ");
        }
        if (DL_date[1].equals("")){
            throw new DukeException("Deadline date cannot be empty");
        }
        return DL_date;
    }

    public static String[] parseEvent(String commandline) throws DukeException
    {
        String [] linearr;
        linearr = commandline.split(" ", 2);

        if (linearr.length !=2){
            throw new DukeException("Invalid Event input");
        }
        String E_date[] = linearr[1].split("/at", 2);

        if (E_date.length != 2){
            throw new DukeException("Invalid Event input. Enter event /at ");
        }
        if (E_date[1].equals("")){
            throw new DukeException("Event date cannot be empty");
        }
        return E_date;
    }

    public static String[] parseTodoFile (String commandline) throws DukeException
    {
        String [] linearr;
        linearr = commandline.split(" \\| ");
        return linearr;
    }

    public static String[] parseEventFile(String commandline) throws DukeException
    {
        String [] lineEvent;
        lineEvent = commandline.split(" \\| ");
        return lineEvent;
    }

    public static String[] parseDeadlineFile(String commandline) throws DukeException
    {
        String [] lineDeadline;
        lineDeadline = commandline.split(" \\| ");
        return lineDeadline;
    }

    public static int parseIntegerParameter(String commandline) throws DukeException
    {
        String [] linearr;
        linearr = commandline.split(" ", 2);

        if (linearr.length !=2){
            throw new DukeException("Invalid command");
        }
        if (linearr[1].equals("")) {
            throw new DukeException("Invalid input");
        }
        if (linearr[1].equals("")) {
            throw new DukeException("Invalid input");
        }
        int intNum=0;
        try{
            intNum = Integer.parseInt(linearr[1]);
        }
        catch (NumberFormatException  e)
        {
            Ui.showError("Incorrect command" + e.getMessage());
            throw new DukeException("Invalid input");
        }
        return intNum;
    }
}