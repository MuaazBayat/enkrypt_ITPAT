package GUIs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * @author muaaz
 */
public class ucanaccess {
    private Connection conn;
    private Statement s;
    private ResultSet rs;
    public ucanaccess()
    {
        try 
        {
            conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//muaaz//Desktop//enkrypt.accdb");
        } 
        catch (SQLException e) 
        {
            System.out.println("Unable to load driver");
        }

    }
    
    public ResultSet ExQuery(String stmt) throws SQLException//Execute Query method
    {
        s = conn.createStatement() ; 
        rs = s.executeQuery(stmt); 
        return rs;
    }

    public void UpdateTable(String stmt) throws SQLException//Update table method
    {
                   
        try (PreparedStatement st = conn.prepareStatement(stmt)) 
        {
            st.executeUpdate();
        }
    }
}
