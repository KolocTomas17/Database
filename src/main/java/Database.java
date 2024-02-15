import java.sql.*;

public class Database {

    public static void getData() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/acc", "root", "");
        PreparedStatement statement = c.prepareStatement("SELECT * FROM users");
        ResultSet set = statement.executeQuery();
        while (set.next()){
            System.out.print(set.getString("id") + " ");
            System.out.print(set.getString("jmeno") + " ");
            System.out.print(set.getString("prijmeni")+ " ");
            System.out.println(set.getString("vek") + " ");
        }
    }
    public static void setData(String jmeno, String prijmeni, Integer vek) throws SQLException{
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/acc", "root", "");
        PreparedStatement statement = c.prepareStatement("INSERT INTO users VALUES (null, ?, ?, ?)");
            statement.setString(1, jmeno);
            statement.setString(2, prijmeni);
            statement.setInt(3, vek);
            statement.execute();
    }
}
