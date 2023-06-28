<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Purchase</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>
<h1 style="text-align: center">Danh sách giỏ hàng</h1>
<div style="margin-left: 60%">
    <form action="/user/purchase/danhSachGioHang" method="get">
        <div class="row" style="width: 700px;">

            <input style="width: 400px" class="form-control col-lg-10" type="text" name="fields"
                   placeholder="Mời bạn nhập để tìm kiếm!">

            <div class="col-lg-2">
                <button type="submit" class="btn btn-success ">Search</button>
            </div>
        </div>
    </form>
</div>

<p style="color: red">${txtNotice}</p>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Mã</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Ngày Tạo</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Tên người nhận</th>
        <th scope="col">Tình trạng</th>
        <th scope="col">Khách hàng</th>
        <th scope="col">Nhân viên</th>
        <th scope="col">Function</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(ds) == 0}">
        <span>Không có dữ liệu</span>
    </c:if>
    <c:if test="${f:length(ds) != 0}">
        <c:forEach items="${ds}" var="gh" varStatus="stt">
            <tr>
                <td>
                        ${stt.index + 1}
                </td>
                <td>
                        ${gh.ma}
                </td>
                <td>
                        ${gh.diaChi}
                </td>
                <td>
                        ${gh.ngayTao}
                </td>
                <td>
                        ${gh.sdt}
                </td>
                <td>
                        ${gh.tenNguoiNhan}
                </td>
                <td>
                        ${gh.tinhTrang == 0 ? "Chưa có sản phẩm nào" : "Đã có sản phẩm"}
                </td>
                <td>
                        ${gh.idKH.ten}
                </td>
                <td>
                        ${gh.idNV.ten}
                </td>


                <td>
                    <a href="/user/purchase/listGhct/${gh.id}"
                       class="btn btn-primary btn-info">Thêm sản phẩm vào giỏ hàng</a>
                </td>

            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<div style="text-align: center">
    <c:if test="${currentPage > 1}">
        <a href="/user/purchase/danhSachGioHang?page=${currentPage - 1}&fields=${fields}">Previous</a>
    </c:if>
    <c:forEach var="pageNumber" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${pageNumber == currentPage}">
                <strong>${pageNumber}</strong>
            </c:when>
            <c:otherwise>
                <a href="/user/purchase/danhSachGioHang?page=${pageNumber}&fields=${fields}">${pageNumber}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${currentPage < totalPages}">
        <a href="/user/purchase/danhSachGioHang?page=${currentPage + 1}&fields=${fields}">Next</a>
    </c:if>
</div>
<div><a type="button" class="btn btn-success" href="/user/purchase/createGioHang_view">Thêm giỏ hàng</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>