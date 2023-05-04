package PaqIPabloMuliterno;

//Pablo Sánchez-Muliterno Guerrero


import java.util.ArrayList;
public class Hub {
    private static ArrayList<Container>[] hub = new ArrayList[3];

    static {
        for (int i = 0; i < hub.length; i++) {
            hub[i] = new ArrayList<>();
        }
    }
    public static void remove(int columnNumber) {
        if (columnNumber >= 0 && columnNumber < hub.length) {
            if (!hub[columnNumber].isEmpty()) {
                hub[columnNumber].remove(hub[columnNumber].size() - 1);
            }
        }
    }
    public static void stack(Container c) {
        hub[c.getPriority() - 1].add(c);
    }
    public static String getPlan() {
        StringBuilder sb = new StringBuilder();
        for (int i = hub.length - 1; i >= 0; i--) {
            sb.append("Priority ").append(i + 1).append(":\n");
            for (int j = hub[i].size() - 1; j >= 0; j--) {
                sb.append(hub[i].get(j).getId()).append("\n");
            }
        }
        return sb.toString();
    }

    public static String Data(int id) {
        for (ArrayList<Container> hub : hub) {
            for (int j = hub.size() - 1; j >= 0; j--) {
                if (hub.get(j).getId() == id) {
                    Container c = hub.get(j);
                    return "Sender: " + c.getSender() + "\n" +
                            "Weight: " + c.getWeight() + "\n" +
                            "Customs Checked: " + c.isInspected() + "\n";
                }
            }
        }
        return "";
    }

    public static int getNumberContainers(String country) {
        int count = 0;
        for (ArrayList<Container> hub : hub) {
            for (Container c : hub) {
                if (c.getOrigin().equals(country)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static String checkContainers(int hNumber, int weight) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Container> containers = hub[hNumber - 1];
        for (Container c : containers) {
            if (c.getWeight() <= weight * 1000) {
                c.setInspected(true);
                sb.append("Container ID: ").append(c.getId()).append("\n")
                        .append("Sender Company: ").append(c.getSender()).append("\n")
                        .append("Weight: ").append(c.getWeight()).append("\n")
                        .append("Customs Check Status: ").append(c.isInspected() ? "Checked" : "Not Checked").append("\n\n");
            }
        }
        return sb.toString();
    }
}
