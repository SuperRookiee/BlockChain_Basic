package util;

import java.sql.*;

public class SQL {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement  pstmt = null;
        String server = "localhost"; // 서버 주소
        String DB = "BlockChain";
        String user_name = "rookie"; //  접속자 id
        String password = "1234"; // 접속자 pw

        // JDBC 드라이버 로드
        // 데이터 관리
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + server + "/"+ DB + "?useSSL=false", user_name, password);
        return conn;
    }

    public static void init(Connection conn, boolean Auth) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement("Delete From Record"+Auth);
        pstmt.executeUpdate();
        System.out.println("이전 데이터 초기화");
    }

    public static int compare(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement("Select * From RecordTrue");
        ResultSet rs1 = pstmt.executeQuery();

        pstmt = conn.prepareStatement("Select * From RecordFalse");
        ResultSet rs2 = pstmt.executeQuery();

        int blockId = 0;
        while (rs1.next() & rs2.next()){
            blockId ++;
            if(rs1.getString(2) !=null && !(rs1.getString(2).equals(rs2.getString(2)))){
                return blockId;
            }
            else if(rs1.getString(2) !=null && !(rs1.getString(5).equals(rs2.getString(5)))){
                return blockId;
            }

        }
        return 0;
    }

}
