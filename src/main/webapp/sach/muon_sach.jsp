<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: final
Date: 13/09/2024
Time: 2:45 SA
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Muon Sach</h1>
    <form action="/sach" method="post">
        <input type="hidden" name="action" value="muonSach">
        <div class="row mb-3">
            <label for="maMuonSach" class="col-sm-2 col-form-label">Ma muon sach</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="maMuonSach" name="ma-muon-sach" required>
            </div>
        </div>
        <div class="row mb-3">
            <label for="tenSach" class="col-sm-2 col-form-label">Ten sach</label>
            <div class="col-sm-10">
                <input type="hidden" name="ma-sach" value="${sach.maSach}">
                <input type="text" class="form-control" id="tenSach" name="ten-sach" value="${sach.tenSach}" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label for="tenHocSinh" class="col-sm-2 col-form-label">Ten hoc sinh</label>
            <div class="col-sm-10">
                <select class="form-select" aria-label="Default select example" id="tenHocSinh" name="ma-hoc-sinh">
                    <c:forEach items="${danhSachHocSinh}" var="hocSinh" varStatus="status">
                        <c:choose>
                            <c:when test="${status.count == 1}">
                                <option selected value="${hocSinh.maHocSinh}">${hocSinh.hoTen}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${hocSinh.maHocSinh}">${hocSinh.hoTen}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mb-3">
            <label for="ngayMuonSach" class="col-sm-2 col-form-label">Ngay muon sach</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="ngayMuonSach" name="ngay-muon" required>
            </div>
        </div>
        <div class="row mb-3">
            <label for="ngayTraSach" class="col-sm-2 col-form-label">Ngay tra sach</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="ngayTraSach" name="ngay-tra" required>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Muon sach</button>
    </form>
    <a class="btn btn-success" href="/sach">Ve trang chu</a>
</div>
<script src="/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
