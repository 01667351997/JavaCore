package timkiem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiDB {
    // thuc hien khoi tao 1 doi tuong ket noi

    Connection kn = null;

    String url = "jdbc:mysql://localhost:3306/csdl-ai";// khai bao duong dan den database
    String username = "root";// ten tai khoan
    String password = "123";// mat khau

    public Connection ketNoi() {

        try {
            // b2 load drive
            Class.forName("com.mysql.jdbc.Driver");
            // khoi tao ket noi den database
            kn = DriverManager.getConnection(url, username, password);

            // kn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("load drive khong thanh cong");
        } catch (SQLException e) {
            System.out.println("loi" + e.getMessage());
        }
        return kn;
    }
}
