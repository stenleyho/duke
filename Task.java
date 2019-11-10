public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone(boolean Done)
    {
        this.isDone = Done;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols "\u2713" : "\u2718"
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString(){
        return "[" + this.getStatusIcon() + "]" + this.getDescription();
    }

    public String writeToFile()
    {
        Integer intIsDone = isDone ? 1 : 0;
        return " | " + intIsDone + " | ";
    }
}
