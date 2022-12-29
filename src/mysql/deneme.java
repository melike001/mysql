package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class deneme {
	static final String DB="jdbc:mysql://localhost:3306/ogrenci";
	static final String USER="root";
	static final String PASS="rott";
	static final String QUERY="SELECT * FROM kayit"+" WHERE adi='Ali'";
	 
	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection(DB,USER,PASS);
		Statement st=con.createStatement();
		System.out.println("veri tabanına bağlandı");
		/*String sql="INSERT INTO kayıt VALUES (101,'Ali','Veli',30)";
		st.executeUpdate(sql);*/
		/*String sql2="INSERT INTO kayıt VALUES (102, 'Melike', 'Saglam', 21)";
		st.executeUpdate(sql2);*/	
		System.out.println("veri tabanında aradığınız yaşı giriniz: ");
		Scanner i =new Scanner(System.in);
		int old=i.nextInt();
		String sql="SELECT * FROM kayıt"+" WHERE yas="+old+" ";
		
		
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID: "+rs.getInt("idkayıt"));
			System.out.println("YAS :"+rs.getInt("yas"));
			System.out.println("Adi: "+rs.getString("adi"));
			System.out.println("Soyadi: "+rs.getString("soyadi"));
			}
		rs.close();
		
		
	}
	
}
