import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var manager = new ShipManager();

        System.out.println("Здравствуй, пользователь!");

        var sc = new Scanner(System.in);

        String command;
        while (!(command = sc.nextLine()).equalsIgnoreCase("exit")) {
            String[] commands = command.toLowerCase().split(" ");
            switch (commands[0]) {
                case "add":
                    switch (commands[1]) {
                        case "ship":
                            manager.addShip(commands[2], commands[3], commands[4], commands[5], Integer.parseInt(commands[6]));
                            break;
                        case "port":
                            manager.addPort(commands[2], commands[3], commands[4]);
                            break;
                        case "tourist":
                            manager.addTourist(commands[2], commands[3], Integer.parseInt(commands[4]), Integer.parseInt(commands[5]));
                            break;
                    }
                    break;
                case "update":
                    switch (commands[1]) {
                        case "ship":
                            manager.updateShip(Integer.parseInt(commands[2]), commands[3], commands[4], commands[5], commands[6], Integer.parseInt(commands[7]));
                            break;
                        case "port":
                            manager.updatePort(Integer.parseInt(commands[2]), commands[3], commands[4], commands[5]);
                            break;
                        case "tourist":
                            manager.updateTourist(Integer.parseInt(commands[2]), commands[3], commands[4], Integer.parseInt(commands[5]), Integer.parseInt(commands[6]));
                            break;
                    }
                    break;
                case "delete":
                    switch (commands[1]) {
                        case "ship":
                            manager.deleteShip(Integer.parseInt(commands[2]));
                            break;
                        case "port":
                            manager.deletePort(Integer.parseInt(commands[2]));
                            break;
                        case "tourist":
                            manager.deleteTourist(Integer.parseInt(commands[2]));
                            break;
                    }
                    break;
                case "get":
                    switch (commands[1]) {
                        case "all_ships":
                            manager.getAllShips();
                            break;
                        case "all_ports":
                            manager.getAllPorts();
                            break;
                        case "all_tourists":
                            manager.getAllTourists();
                            break;
                        case "ship":
                            manager.getShip(commands[2]);
                            break;
                        case "port":
                            manager.getPort(commands[2]);
                            break;
                        case "tourist":
                            manager.getTourist(commands[2]);
                            break;
                    }
                    break;
            }
        }
    }
}
