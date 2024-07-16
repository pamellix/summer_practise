import java.sql.*;

public class ShipManager {

    // Подключение
    public Connection connect() throws SQLException {
        String password = "postgres";
        String user = "postgres";
        String dbName = "postgres";
        String url = "jdbc:postgresql://217.25.92.169:5432/";
        return DriverManager.getConnection(url + dbName, user, password);
    }

    public void addPort(String name, String city, String quantity_of_ships) {
        String SQL = "INSERT INTO ports(name, city, quantity_of_ships) VALUES(?,?,?)";

        try (Connection connect = connect();
             PreparedStatement pst = connect.prepareStatement(SQL)) {
            pst.setString(1, name);
            pst.setString(2, city);
            pst.setString(3, quantity_of_ships);
            pst.executeUpdate();
            System.out.println("Port added successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updatePort(int portId, String name, String city, String quantity_of_ships) {
        String SQL = "UPDATE ports SET name = ?, city = ?, quantity_of_ships = ? WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {
            pst.setString(1, name);
            pst.setString(2, city);
            pst.setString(3, quantity_of_ships);
            pst.setInt(5, portId);
            pst.executeUpdate();
            System.out.println("Port updated successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deletePort(int portId) {
        String SQL = "DELETE FROM ports WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {
            pst.setInt(1, portId);
            pst.executeUpdate();
            System.out.println("Port deleted successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getPort(String namePort) {
        String SQL = "SELECT * FROM ports WHERE name = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {

            pst.setString(1, namePort); // Set the parameter to the namePort value

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("city") + "\t" +
                            rs.getString("quantity_of_ships"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void getAllPorts() {
        String SQL = "SELECT * FROM ports";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("city") + "\t" +
                        rs.getString("quantity_of_ships"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addShip(String name, String capacity, String size, String speed, int routeId) {
        String SQL = "INSERT INTO ships(name, capacity, size, speed, route) VALUES(?,?,?,?,?)";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {
            pst.setString(1, name);
            pst.setString(2, capacity);
            pst.setString(3, size);
            pst.setString(4, speed);
            pst.setInt(5, routeId);
            System.out.println("Ship added successfully");
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateShip(int shipId, String name, String capacity, String size, String speed, int route) {
        String SQL = "UPDATE ships SET name = ?, capacity = ?, size = ?, speed = ?, route = ? WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {
            pst.setString(1, name);
            pst.setString(2, capacity);
            pst.setString(3, size);
            pst.setString(4, speed);
            pst.setInt(5, route);
            pst.setInt(6, shipId);
            pst.executeUpdate();
            System.out.println("Port updated successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteShip(int shipId) {
        String SQL = "DELETE FROM ships WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {
            pst.setInt(1, shipId);
            pst.executeUpdate();
            System.out.println("Ship deleted successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getShip(String name) {
        String SQL = "SELECT * FROM ships WHERE name = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {

            pst.setString(1, name); // Set the parameter to the name value

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("capacity") + "\t" +
                            rs.getString("size") + "\t" +
                            rs.getString("speed") + "\t" +
                            rs.getInt("route"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void getAllShips() {
        String SQL = "SELECT * FROM ships";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("capacity") + "\t" +
                        rs.getString("size") + "\t" +
                        rs.getString("speed") + "\t" +
                        rs.getInt("route"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addTourist(String name, String surname, int shipId, int quantityOfDays) {
        String SQL = "INSERT INTO tourists(name, surname, ship, quantity_of_days) VALUES(?,?,?,?)";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setInt(3, shipId);
            pst.setInt(4, quantityOfDays);
            pst.executeUpdate();
            System.out.println("Tourist added successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateTourist(int touristId, String name, String surname, int shipId, int quantityOfDays) {
        String SQL = "UPDATE tourists SET name = ?, surname = ?, ship = ?, quantity_of_days = ? WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setInt(3, shipId);
            pst.setInt(4, quantityOfDays);
            pst.setInt(5, touristId);
            pst.executeUpdate();
            System.out.println("Tourist updated successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteTourist(int touristId) {
        String SQL = "DELETE FROM tourists WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {
            pst.setInt(1, touristId);
            pst.executeUpdate();
            System.out.println("Tourist deleted successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getTourist(String surname) {
        String SQL = "SELECT * FROM tourists WHERE surname = ?";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL)) {

            pst.setString(1, surname); // Set the parameter to the surname value

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("surname") + "\t" +
                            rs.getInt("ship") + "\t" +
                            rs.getInt("quantity_of_days"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void getAllTourists() {
        String SQL = "SELECT * FROM tourists";

        try (Connection connection = connect();
             PreparedStatement pst = connection.prepareStatement(SQL);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("surname") + "\t" +
                        rs.getInt("ship") + "\t" +
                        rs.getInt("quantity_of_days"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}