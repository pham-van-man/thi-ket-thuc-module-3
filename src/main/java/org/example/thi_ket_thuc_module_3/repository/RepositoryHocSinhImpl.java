package org.example.thi_ket_thuc_module_3.repository;

import org.example.thi_ket_thuc_module_3.model.HocSinh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryHocSinhImpl implements RepositoryHocSinh {
    private static final BaseRepository BASE_REPOSITORY = new BaseRepository();
    private static final String SELECT_ALL_HOC_SINH = "select * from hoc_sinh";

    @Override
    public List<HocSinh> getAllHocSinh() throws Exception {
        List<HocSinh> danhSachHocSinh = new ArrayList<>();
        try (Connection connection = BASE_REPOSITORY.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOC_SINH); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String maHocSinh = resultSet.getString("ma_hoc_sinh");
                String hoTen = resultSet.getString("ho_ten");
                String lop = resultSet.getString("lop");
                HocSinh hocSinh = new HocSinh(maHocSinh, hoTen, lop);
                danhSachHocSinh.add(hocSinh);
            }
        }
        return danhSachHocSinh;
    }
}
