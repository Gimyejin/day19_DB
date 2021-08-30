package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBClass {
	private String url;
	private String id;
	private String pwd;
	private Connection con;

	public DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			id = "test";
			pwd = "test";
			con = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 추가
	public int insert(int num, String name, String addr, String email, String phone) {
		String sql = "insert into member values(?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, name);
			ps.setString(3, addr);
			ps.setString(4, email);
			ps.setString(5, phone);
			result = ps.executeUpdate();// 저장시 1을 반환
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 수정
	public int update(String name, String addr, String email, String phone) {
		int result = 0;
		String sql = "update member set addr=?,email=?,phone=? where name=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// 숫자는 ?의 위치
			ps.setString(1, addr);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, name);
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// 삭제
	public int delete(int num) {
		int result =0;
		String spl = "delete from member where num=?";
		try {
			PreparedStatement ps= con.prepareStatement(spl);
			ps.setInt(1, num);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// list
	public ArrayList<MemberDTO> getList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt("num"));// sql문의num 내용을 dto에 담기
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
