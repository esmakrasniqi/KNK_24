package Stacioni;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Linjattable {

	private int Lid;
	private String Vendi_nisjes;
	private String Destinacioni;
	private Time Oranisjes;
	private Time OraArritjes;
	private float Cmimi;
	private String EmriKompanis;
	private String Verifikimi;
	
	
	public Linjattable(int Lid, String Vendi_nisjes, String Destinacioni,Time Oranisjes ,Time OraArritjes,float Cmimi,String EmriKompanis,String Verifikimi) {
		this.Lid = Lid;
		this.Vendi_nisjes = Vendi_nisjes;
		this.Destinacioni = Destinacioni;
		this.Oranisjes = Oranisjes;
		this.OraArritjes = OraArritjes;
		this.Cmimi =Cmimi;
		this.EmriKompanis = EmriKompanis;
		this.Verifikimi = Verifikimi;
		
	}
	
	public int getLid() {
		return Lid;
	}
	
	public void setLid(int Lid) {
		this.Lid = Lid;
	}
	
	public String getVendi_nisjes() {
		return Vendi_nisjes;
	}
	
	public void setVendi_nisjes(String Vendi_nisjes) {
		this.Vendi_nisjes = Vendi_nisjes;
	}
	
	public String getDestinacioni() {
		return Destinacioni;
	}
	
	public void setDestinacioni(String Destinacioni) {
		this.Destinacioni = Destinacioni;
	}
	
	public Time getOranisjes() {
		return Oranisjes;
	}
	
	public void setYear(Time Oranisjes) {
		this.Oranisjes = Oranisjes;
	}
	
	public Time getOraArritjes() {
		return OraArritjes;
	}
	
	public void setOraArritjes(Time OraArritjes) {
		this.OraArritjes = OraArritjes;
	}
	public float getCmimi() {
		return Cmimi;
	}
	
	public void setCmimi(float Cmimi) {
		this.Cmimi = Cmimi;
	}
	public String getEmriKompanis() {
		return EmriKompanis;
	}
	
	public void setEmriKompanis(String EmriKompanis) {
		this.EmriKompanis = EmriKompanis;
	}
	public String getVerifikimi() {
		return Verifikimi;
	}
	
	public void setVerifikmi(String Verifikimi) {
		this.Verifikimi = Verifikimi;
	}
	
	public static boolean updateLinjattable(int Lid, String Vendi_nisjes, String Destinacioni,Time Oranisjes,Time OraArritjes,float Cmimi,String EmriKompanis,boolean Verifikimi) {
		String query = "UPDATE Linjat SET Vendi_nisjes=?, Destinacioni=?, Oranisjes=?, OraArritjes=? , Cmimi=?,EmriKompanis=?,Verifikmi=? WHERE Lid=?";
		
		try {
			PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, Vendi_nisjes);
			preparedStatement.setString(2, Destinacioni);
			preparedStatement.setTime(3, Oranisjes);
			preparedStatement.setTime(4, OraArritjes);
			preparedStatement.setFloat(5, Cmimi);
			preparedStatement.setString(6, EmriKompanis);
			preparedStatement.setBoolean(7, Verifikimi);
			
		return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
		return false;
		}
	}
	
	public static boolean deleteLinjattable(int Lid) {
		String query = "Delete from Linjat where Lid=?";
		
		try {
		PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, Lid);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public static List<Linjattable> getLinjattables() {
		DbConnection.getConnection();
		List<Linjattable> LinjattableList = new ArrayList();
		
		String query = "Select * from Linjat";
		
		try {
			PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Linjattable Linjattable = new Linjattable(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTime(4), 
						resultSet.getTime(5),resultSet.getFloat(6),resultSet.getString(7),resultSet.getString(8));
				LinjattableList.add(Linjattable);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return LinjattableList;
	}
}