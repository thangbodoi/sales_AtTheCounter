<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>HoaDOn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>
<h1 style="text-align: center">Quan li hoa don</h1>
<div >
    <form action="/user/hoaDon/listHoaDon" method="get">
        <div class="row" style="margin-left: 20%">
            <div class="col-lg-2">
                <label for="startDate">Ngày bắt đầu</label>
                <input type="date" id="startDate" name="startDate"  checked>
            </div>
            <div class="col-lg-2">
                <label for="endDate">Ngày kết thúc</label>
                <input type="date" id="endDate" name="endDate" >
            </div>
            <div class="col-lg-2">
                <input type="radio" id="daThanhToan" name="tinhTrang" value="1" checked>
                <label for="daThanhToan">Đã thanh toán</label>
            </div>
            <div class="col-lg-2">
                <input type="radio" id="chuaThanhToan" name="tinhTrang" value="0">
                <label for="chuaThanhToan">Chưa thanh toán</label>
            </div>
            <div class="col-lg-3">
                <input style="width: 300px" class="form-control" type="text" name="fields" placeholder="Mời bạn nhập để tìm kiếm!">
            </div>
            <div class="col-lg-1">
                <button type="submit" class="btn btn-success">Search</button>
            </div>
        </div>
    </form>
</div>
<div style="margin-top: 20px">
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã</th>
        <th scope="col">Ngày tạo</th>
        <th scope="col">Ngày thanh toán</th>
        <th scope="col">Tình trạng</th>
        <th scope="col">Tên người nhận</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Khách hàng</th>
        <th scope="col">Nhân viên</th>
        <th scope="col">Funtion</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(ds) == 0}">
        <span>Khong co du lieu</span>
    </c:if>
    <c:if test="${f:length(ds) != 0}">
        <c:forEach items="${ds}" var="kh" varStatus="index">
            <tr>
                <th scope="row">${index.index + 1 }</th>
                <td>${kh.ma}</td>
                <td>${kh.ngayTao}</td>
                <td>${kh.ngayThanhToan}</td>
                <td>${kh.tinhTrang == 0 ? "Chưa thanh toán" : "Đã thanh toán"}</td>
                <td>${kh.tenNguoiNhan}</td>
                <td>${kh.diaChhi}</td>
                <td>${kh.sdt}</td>
                <td>${kh.idKH.ten}</td>
                <td>${kh.idNV.ten}</td>
                <td><a type="button" class="btn btn-info" href="/user/hoaDon/xemHdct/${kh.id}">Xem hóa đơn chi tiết</a> |
                </td>
            </tr>
        </c:forEach>
    </c:if>

    </tbody>
</table>
</div>
<div style="text-align: center">
    <c:if test="${currentPage > 1}">
        <a href="/user/hoaDon/listHoaDon?page=${currentPage - 1}&fields=${fields}&tinhTrang=${tinhTrang}">Previous</a>
    </c:if>

    <c:forEach var="pageNumber" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${pageNumber == currentPage}">
                <strong>${pageNumber}</strong>
            </c:when>
            <c:otherwise>
                <a href="/user/hoaDon/listHoaDon?page=${pageNumber}&fields=${fields}&tinhTrang=${tinhTrang}">${pageNumber}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${currentPage < totalPages}">
        <a href="/user/hoaDon/listHoaDon?page=${currentPage + 1}&fields=${fields}&tinhTrang=${tinhTrang}">Next</a>
    </c:if>
</div>
<%--<div><a type="button" class="btn btn-success" href="/user/hoaDon/create_view">ADD</a>--%>
<%--</div>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>