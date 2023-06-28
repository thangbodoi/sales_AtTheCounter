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
<h1 style="text-align: center">Danh sách sản phẩm trong giỏ</h1>
<div style="margin-left: 60%">
    <form action="/user/purchase/listGhct/${idGioHang}" method="get">
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
        <th scope="col">Sản phẩm</th>
        <th scope="col">Dòng Sản phẩm</th>
        <th scope="col">Màu sắc</th>
        <th scope="col">Nơi sản xuất</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Đơn giá</th>
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
                        ${gh.idChiTietSP.idSP.ten}
                </td>
                <td>
                        ${gh.idChiTietSP.idDongSP.ten}
                </td>
                <td>
                        ${gh.idChiTietSP.idMauSac.ten}
                </td>
                <td>
                        ${gh.idChiTietSP.idNsx.ten}
                </td>
                <td>
                        ${gh.soLuong}

                </td>
                <td>
                        ${gh.donGia}
                </td>

                <td>
                    <a href="/user/purchase/updateGhct_view/${gh.idChiTietSP.id}"
                       class="btn btn-primary btn-info">Sửa số lượng</a>
                    <a href="/user/purchase/deleteGhct/${gh.idChiTietSP.id}"
                       class="btn btn-primary btn-info">Xóa sản phẩm</a>
                </td>

            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<div style="text-align: center">
    <c:if test="${currentPage > 1}">
        <a href="/user/purchase/listGhct/${idGioHang}?page=${currentPage - 1}&fields=${fields}">Previous</a>
    </c:if>
    <c:forEach var="pageNumber" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${pageNumber == currentPage}">
                <strong>${pageNumber}</strong>
            </c:when>
            <c:otherwise>
                <a href="/user/purchase/listGhct/${idGioHang}?page=${pageNumber}&fields=${fields}">${pageNumber}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${currentPage < totalPages}">
        <a href="/user/purchase/listGhct/${idGioHang}?page=${currentPage + 1}&fields=${fields}">Next</a>
    </c:if>
</div>
<div>
    <a href="/user/purchase/listCtsp" class="btn btn-primary btn-success">Thêm sản phẩm vào giỏ hàng</a>
    <a href="/user/purchase/addHoaDon" class="btn btn-primary btn-success">Tạo hóa đơn</a>
    <a href="/user/purchase/danhSachGioHang" class="btn btn-primary btn-info">Back</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>