package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NoSql {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		Statement stat=conn.createStatement();
		String Query="insert into student(first_name,last_name,address,ph_num)value('raja','BN','USA','76559879')";
		int result=stat.executeUpdate(Query);
		if(result==1) {
			System.out.println("user created ");
		}
		else {
			System.out.println("user not created");
		}
	}

}
