package org.example.thi_ket_thuc_module_3.repository;

import org.example.thi_ket_thuc_module_3.model.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorySachImpl implements RepositorySach {
    private static final BaseRepository BASE_REPOSITORY = new BaseRepository();
    private static final String SELECT_ALL_SACH = "select * from sach";
    private static final String SELECT_SACH = "select * from sach where ma_sach = ?";
    private static final String UPDATE_SACH = "update sach set so_luong = ? where ma_sach = ?";

    @Override
    public List<Sach> getAllSach() throws SQLException {
        List<Sach> danhSachSach = new ArrayList<>();
        try (Connection connection = BASE_REPOSITORY.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SACH); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String maSach = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int soLuong = resultSet.getInt("so_luong");
                Sach sach = new Sach(maSach, tenSach, tacGia, moTa, soLuong);
                danhSachSach.add(sach);
            }
        }
        return danhSachSach;
    }

    @Override
    public Sach getSach(String maSachs) throws SQLException {
        Sach sach = null;
        try (Connection connection = BASE_REPOSITORY.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SACH)) {
            preparedStatement.setString(1, maSachs);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String maSach = resultSet.getString("ma_sach");
                    String tenSach = resultSet.getString("ten_sach");
                    String tacGia = resultSet.getString("tac_gia");
                    String moTa = resultSet.getString("mo_ta");
                    int soLuong = resultSet.getInt("so_luong");
                    sach = new Sach(maSach, tenSach, tacGia, moTa, soLuong);
                }
            }
        }
        return sach;
    }

    @Override
    public void updateSach(Sach sach) throws SQLException {
        try (Connection connection = BASE_REPOSITORY.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SACH)) {
            preparedStatement.setInt(1, sach.getSoLuong());
            preparedStatement.setString(2, sach.getMaSach());
            preparedStatement.executeUpdate();
        }
    }
}
