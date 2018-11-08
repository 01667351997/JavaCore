package timkiem;

import timkiem.KetNoiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TTBD {

    Connection kn = null;
    PreparedStatement ps = null;
    KetNoiDB knoi = new KetNoiDB();

    public ArrayList<KetQuaTuVan> timKiem(Float diemthi, String khoi, String nganh) {

        if (khoi.equals("Tất cả các khối")) {
            khoi = "%";
        }
        if (nganh.equals("Tất cả các ngành")) {
            nganh = "%";
        }
        kn = knoi.ketNoi();
        String sql = "select TenTruong, hocphi.muc,hocbong.muc,tennganh,tenkhoi,diemchuan "
                + " from fdatamain,hocbong,hocphi,khoithi,nganhhoc,truongdh"
                + " where (idtruong=idTruongDH)and (fdatamain.idhocphi=hocphi.idhocphi)"
                + " and(idnganh=idNganhhoc) and(fdatamain.idhocbong=hocbong.idhocbong) and(idkhoi=idkhoithi) "
                + "and( diemchuan>=?-2) and(diemchuan<=?+1) and(tenkhoi like ?)and (tennganh like ?)";

        ArrayList< KetQuaTuVan> listkqtv = new ArrayList<>();
        try {
            ps = kn.prepareStatement(sql);
            ps.setFloat(1, diemthi);
            ps.setFloat(2, diemthi);
            ps.setString(3, khoi);
            ps.setString(4, nganh);
            // khoi tao ket qua tra ve
            // dua du lieu ra tu  cau truy van luu vao kq

            ResultSet kq = ps.executeQuery();
            // pt next tro theo hang,co du lieu thi hien thi

            while (kq.next() == true) {
                KetQuaTuVan kqtv = new KetQuaTuVan();

                kqtv.setTenTruong(kq.getString("TenTruong"));
                kqtv.setMuchp(kq.getString("hocphi.muc"));
                kqtv.setMuchb(kq.getString("hocbong.muc"));
                kqtv.setTenNganh(kq.getString("tennganh"));
                kqtv.setKhoi(kq.getString("tenkhoi"));
                kqtv.setDiemChuan(kq.getFloat("diemchuan"));
                listkqtv.add(kqtv);
            }
            ps.close();
            kn.close();

        } catch (SQLException e) {
            System.out.println("loi" + e.getMessage());
        }

        return listkqtv;
    }

    public KetQuaTuVan htKetQua(String id) {

        kn = knoi.ketNoi();
        String sql = "select TenTruong, hocphi.muc,hocbong.muc,tennganh,tenkhoi,diemchuan"
                + " from fdatamain,hocbong,hocphi,khoithi,nganhhoc,truongdh"
                + " where (idtruong=idTruongDH)and (fdatamain.idhocphi=hocphi.idhocphi)"
                + " and(idnganh=idNganhhoc) and(fdatamain.idhocbong=hocbong.idhocbong) and(idkhoi=idkhoithi) "
                + "and (fdatamain.iddatamain like ? )";

        KetQuaTuVan kqtv = new KetQuaTuVan();
        try {
            ps = kn.prepareStatement(sql);

            ps.setString(1, id);
            // khoi tao ket qua tra ve
            // dua du lieu ra tu  cau truy van luu vao kq

            ResultSet kq = ps.executeQuery();
            // pt next tro theo hang,co du lieu thi hien thi

            while (kq.next() == true) {

                kqtv.setTenTruong(kq.getString("TenTruong"));
                kqtv.setMuchp(kq.getString("hocphi.muc"));
                kqtv.setMuchb(kq.getString("hocbong.muc"));
                kqtv.setTenNganh(kq.getString("tennganh"));
                kqtv.setKhoi(kq.getString("tenkhoi"));
                kqtv.setDiemChuan(kq.getFloat("diemchuan"));

            }
            ps.close();
            kn.close();

        } catch (SQLException e) {
            System.out.println("loi" + e.getMessage());
        }
        return kqtv;
    }
}
