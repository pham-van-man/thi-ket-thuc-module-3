package org.example.thi_ket_thuc_module_3.repository;

import org.example.thi_ket_thuc_module_3.model.TheMuonSach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositpryTheMuonSachImpl implements RepositoryTheMuonSach {
    private static final BaseRepository BASE_REPOSITORY = new BaseRepository();
    private static final String INSERT_THE_MUON_SACH = "insert into the_muon_sach values(?,?,?,?,?,?)";
    private static final String SELECT_ALL_THE_MUON_SACH = "select * from the_muon_sach";

    @Override
    public void insertTheMuonSach(TheMuonSach theMuonSach) throws SQLException {
        try (Connection connection = BASE_REPOSITORY.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THE_MUON_SACH)) {
            preparedStatement.setString(1, theMuonSach.getMaMuonSach());
            preparedStatement.setString(2, theMuonSach.getMaSach());
            preparedStatement.setString(3, theMuonSach.getMaHocSinh());
            preparedStatement.setInt(4, theMuonSach.getTrangThai());
            preparedStatement.setObject(5, theMuonSach.getNgayMuon());
            preparedStatement.setObject(6, theMuonSach.getNgayTra());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<TheMuonSach> getAllTheMuonSach() throws SQLException {
        List<TheMuonSach> danhSachTheMuonSach = new ArrayList<>();
        try (Connection connection = BASE_REPOSITORY.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THE_MUON_SACH); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String maMuonSach = resultSet.getString("ma_muon_sach");
                String maSach = resultSet.getString("ma_sach");
                String maHocSinh = resultSet.getString("ma_hoc_sinh");
                int trangThai = resultSet.getInt("trang_thai");
                LocalDate ngayMuon = resultSet.getObject("ngay_muon", LocalDate.class);
                LocalDate ngayTra = resultSet.getObject("ngay_tra", LocalDate.class);
                TheMuonSach theMuonSach = new TheMuonSach(maMuonSach, maSach, maHocSinh, trangThai, ngayMuon, ngayTra);
                danhSachTheMuonSach.add(theMuonSach);
            }
        }
        return danhSachTheMuonSach;
    }

    @Override
    public TheMuonSach getTheMuonSach(String maMuonSach) throws SQLException {
        return null;
    }
}
