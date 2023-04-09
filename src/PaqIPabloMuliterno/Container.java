package PaqIPabloMuliterno;

public class Container {
    private int id, weight, priority;
    private String origin, description, sender, receiver;
    private boolean inspected;

    public Container(int id, int weight, int priority, String origin, String description, String sender, String receiver, boolean inspected) {
        this.id = id;
        this.weight = weight;
        this.priority = priority;
        this.origin = origin;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
        this.inspected = inspected;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public boolean isInspected() {
        return inspected;
    }
    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }
    public String toString() {
        return "Container\n " + id + "\nWeight:\n " + weight + "\nPriority:\n " + priority + "\nOrigin:\n " + origin + "\nDescription:\n " + description + "\nSender:\n " + sender + "\nReceiver:\n " + receiver + "\nInspected:\n " + inspected;

    }
}
