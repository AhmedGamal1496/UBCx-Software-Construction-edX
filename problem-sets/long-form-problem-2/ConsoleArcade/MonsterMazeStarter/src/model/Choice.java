package model;

public abstract class Choice {
    protected String optionMessage;

    public Choice (String message) {
        optionMessage = message;
    }

    //EFFECTS: prints a message representing this possible next choice
    public void printOptionMessage() {
        System.out.println(optionMessage);
    }

    //EFFECTS: prints the result of choosing this choice
    public abstract void printOutcome();
}
