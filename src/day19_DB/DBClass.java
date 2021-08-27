package day19_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBClass {
	private String url;
	private String id;
	private String pwd;
	private Connection con;
	public DBClass() {
	//����Ŭ�� ����� �ڹٿ��� ����ϱ� ����, ������ ó�� ���� ���� �ش�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			id = "java"; 
			pwd = "java";
			con = DriverManager.getConnection(url,id,pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/*
 1.����̺� �ε�(����Ŭ ��� ���)
 2. ����� ��ü�� ���´�
 3. ����� ��ü�� �̿��ؼ� ��ɾ�(������)�� ������ �� �ִ� ���� ��ü�� ���´�
 4. ���� ��ü�� �̿��ؼ� �����ͺ��̽��� ������ ����� ���´�.
 5. ���� ����� int �Ǵ� ResultSet���� �޴´�
 */
	public ArrayList<StudentDTO> getUsers(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		String sql = "select * from newst";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStNum( rs.getString("id") );
				dto.setName( rs.getString("name") );
				dto.setAge( rs.getInt("age") );
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public int saveData(String stNum, String name, int age) {
		// insert into newst values('111','ȫ�浿',20);
		String sql =
		"insert into newst values('"+stNum+"','"+name+"',"+age+")";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ResultSet rs = ps.executeQuery();
			// ���� ������ 1�� ��ȯ, ���н� catch�̵��̳� 0�� ��ȯ
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int saveData02(String stNum, String name, int age) {
		String sql = "insert into newst values(?, ?, ?)";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stNum);
			ps.setString(2, name);
			ps.setInt(3, age);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int delete(String userNum) {
		int result = 0;
		//delete from newst where id = 'userNum';
		String sql = "delete from newst where id = '"+userNum+"'";
		//String sql = "delete from newst where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int modify(String stNum, String name, int age) {
		int result = 0;
		//update newst set name='ȫ�浿', age=20 where id='test';
		String sql = "update newst set name=?, age=? where id = ? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, stNum);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
}



