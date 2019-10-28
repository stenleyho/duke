public class Deadlines extends Task {

    protected boolean isDone;
    protected String by;

    public  Deadlines(String description, String by)
    {
        super(description);
        isDone=false;
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D] [" + super.getStatusIcon() +"]" + super.getDescription()  + "(by:" + by + ")" ;
    }

    @Override
    public String writeToFile()
    {
        return "D" + super.writeToFile() + super.getDescription() + " | " + by;
    }
}
