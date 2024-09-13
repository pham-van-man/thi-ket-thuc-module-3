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
    <%--    <form class="row gy-2 gx-3 align-items-center">--%>
    <%--        <div class="col-auto">--%>
    <%--            <label class="visually-hidden" for="autoSizingInput">Name</label>--%>
    <%--            <input type="text" class="form-control" id="autoSizingInput" placeholder="Jane Doe">--%>
    <%--        </div>--%>
    <%--        <div class="col-auto">--%>
    <%--            <label class="visually-hidden" for="autoSizingInputGroup">Username</label>--%>
    <%--            <div class="input-group">--%>
    <%--                <div class="input-group-text">@</div>--%>
    <%--                <input type="text" class="form-control" id="autoSizingInputGroup" placeholder="Username">--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--        <div class="col-auto">--%>
    <%--            <label class="visually-hidden" for="autoSizingSelect">Preference</label>--%>
    <%--            <select class="form-select" id="autoSizingSelect">--%>
    <%--                <option selected>Choose...</option>--%>
    <%--                <option value="1">One</option>--%>
    <%--                <option value="2">Two</option>--%>
    <%--                <option value="3">Three</option>--%>
    <%--            </select>--%>
    <%--        </div>--%>
    <%--        <div class="col-auto">--%>
    <%--            <div class="form-check">--%>
    <%--                <input class="form-check-input" type="checkbox" id="autoSizingCheck">--%>
    <%--                <label class="form-check-label" for="autoSizingCheck">--%>
    <%--                    Remember me--%>
    <%--                </label>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--        <div class="col-auto">--%>
    <%--            <button type="submit" class="btn btn-primary">Submit</button>--%>
    <%--        </div>--%>
    <%--    </form>--%>
    <div class="row">
        <div class="col-lg-12">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Ma Muon Sach</th>
                    <th>Ma Sach</th>
                    <th>Ma Hoc Sinh</th>
                    <th>Tran Thai</th>
                    <th>Ngay Muon</th>
                    <th>Ngay Tra</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="theMuonSach" items="${danhSachTheMuonSach}">
                    <c:if test="${theMuonSach.trangThai ==0}">
                        <tr>
                            <td><c:out value="${theMuonSach.maMuonSach}"></c:out></td>
                            <td><c:out value="${theMuonSach.maSach}"></c:out></td>
                            <td><c:out value="${theMuonSach.maHocSinh}"></c:out></td>
                            <td><c:out value="Dang muon"></c:out></td>
                            <td><c:out value="${theMuonSach.ngayMuon}"></c:out></td>
                            <td><c:out value="${theMuonSach.ngayTra}"></c:out></td>
                            <td><a href="/sach-dang-muon?action=traSach&maSach=${theMuonSach.maMuonSach}" class="btn btn-success">Tra</a></td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
            <%--            <a href="/sach-dang-muon" class="btn btn-success">Danh sach sach dang muon</a>--%>
        </div>
    </div>
</div>
<!-- Button trigger modal -->
<%--<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
<%--    Launch demo modal--%>
<%--</button>--%>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script src="/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
