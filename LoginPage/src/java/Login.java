import java.sql.*;
public class Login {
    public static boolean validate(String name,String email,String pass){
        boolean status=false;
    
     try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3308/student"+"?openSSL=false", "root", "root");
       PreparedStatement ps=con.prepareStatement("select*from student where name=? and email=? and pass=?");
       ps.setString(1,name);
       ps.setString(2,email);
       ps.setString(3,pass);
       ResultSet rs=ps.executeQuery();
       status=rs.next();
        }
        catch(Exception e){
                System.out.println(e);}
                return status;
                }
}
    
