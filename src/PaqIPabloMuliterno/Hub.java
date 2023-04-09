package PaqIPabloMuliterno;

import java.util.Objects;

public class Hub {
    private static Container[][] containers = new Container[10][12];


    public static String Data(int id){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (containers[i][j] != null && containers[i][j].getId() == id) {
                    return containers[i][j].toString();
                }
            }
        }

        return "Container not found";
    }
    public static boolean remove(int column){
        for (int i = 9; i >= 0; i--) {
            if (containers[i][column] != null) {
                containers[i][column] = null;
                return true;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = column; j < 11; j++) {
                containers[i][j] = containers[i][j + 1];
            }
        }

        return false;
    }

    public static boolean stack(Container cont) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (containers[i][j] != null && containers[i][j].getId() == cont.getId()) {
                    containers[i][j].setWeight(cont.getWeight());
                    containers[i][j].setPriority(cont.getPriority());
                    containers[i][j].setOrigin(cont.getOrigin());
                    containers[i][j].setDescription(cont.getDescription());
                    containers[i][j].setSender(cont.getSender());
                    containers[i][j].setReceiver(cont.getReceiver());
                    containers[i][j].setInspected(cont.isInspected());
                    return true;
                }
            }
        }

        switch (cont.getPriority()) {
            case 1:
                for (int i = 0; i < 10; i++) {
                    if (containers[i][0] == null) {
                        containers[i][0] = cont;
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 10; i++) {
                    if (containers[i][1] == null) {
                        containers[i][1] = cont;
                        return true;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < 10; i++) {
                    for (int j = 2; j < 12; j++) {
                        if (containers[i][j] == null) {
                            containers[i][j] = cont;
                            return true;
                        }
                    }
                }
                break;
        }

        return false;
    }

    //gets the current distribution of the hub and managment
    public static String getPlan() {
        StringBuilder plan = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < 12; j++) {
                plan.append(containers[i][j] != null ? "X" : "O");
            }
            plan.append('\n');
        }
        return plan.toString();
    }

    public static int getNumberContainers(String country){
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (containers[i][j] != null && Objects.equals(containers[i][j].getOrigin(), country)) {
                    count++;
                }
            }
        }

        return count;
    }


}