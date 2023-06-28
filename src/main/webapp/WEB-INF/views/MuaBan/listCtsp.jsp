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
<h1 style="text-align: center">Mời bạn chọn sản phẩm</h1>
<div style="margin-left: 60%">
    <form action="/user/purchase/listCtsp" method="get">
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
        <th scope="col">Giá bán</th>
        <th scope="col">Giá nhập</th>
        <th scope="col">Mô tả</th>
        <th scope="col">Năm bảo hành</th>
        <th scope="col">Số lượng tồn</th>
        <th scope="col">Dòng sản phẩm</th>
        <th scope="col">Màu sắc</th>
        <th scope="col">Nơi sản xuất</th>
        <th scope="col">Sản phẩm</th>
        <th scope="col">Function</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${f:length(ds) == 0}">
        <span>Khong co du lieu</span>
    </c:if>
    <c:if test="${f:length(ds) != 0}">
        <c:forEach items="${ds}" var="sp" varStatus="index">
            <tr>
                <th scope="row">${index.index + 1 }</th>
                <td>${sp.giaBan}</td>
                <td>${sp.giaNhap}</td>
                <td>${sp.moTa}</td>
                <td>${sp.namBH}</td>
                <td>${sp.soLuongTon}</td>
                <td>${sp.idDongSP.ten}</td>
                <td>${sp.idMauSac.ten}</td>
                <td>${sp.idNsx.ten}</td>
                <td>${sp.idSP.ten}</td>
                <td>
                    <a href="/user/purchase/addGhct_View/${sp.id}" class="btn btn-primary btn-warning">Thêm sản phẩm vào giỏ hàng
                    </a>
                </td>
            </tr>
        </c:forEach>
    </c:if>

    </tbody>
</table>
<div style="text-align: center">
    <c:if test="${currentPage > 1}">
        <a href="/user/purchase/listCtsp?page=${currentPage - 1}&fields=${fields}">Previous</a>
    </c:if>
    <c:forEach var="pageNumber" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${pageNumber == currentPage}">
                <strong>${pageNumber}</strong>
            </c:when>
            <c:otherwise>
                <a href="/user/purchase/listCtsp?page=${pageNumber}&fields=${fields}">${pageNumber}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${currentPage < totalPages}">
        <a href="/user/purchase/listCtsp?page=${currentPage + 1}&fields=${fields}">Next</a>
    </c:if>
</div>
<div><a type="button" class="btn btn-success" href="/user/purchase/listGhct/${idGioHang}">Back</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>