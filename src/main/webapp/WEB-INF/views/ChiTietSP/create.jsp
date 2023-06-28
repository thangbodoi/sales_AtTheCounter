<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CTSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">Create!</h1>
<div class="createForm container" style="width: 1200px;">

    <form:form method="POST" action="/admin/chiTietSanPham/create" modelAttribute="ctsp">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Giá bán</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" pattern="[0-9]*" inputmode="numeric"
                            path="giaBan"></form:input>
                <form:errors path="giaBan" cssStyle="color: red"> </form:errors>

            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Giá nhập</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" pattern="[0-9]*" inputmode="numeric"
                            path="giaNhap"></form:input>
                <form:errors path="giaNhap" cssStyle="color: red"> </form:errors>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mô tả</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="moTa"></form:input>
                <form:errors path="moTa" cssStyle="color: red"> </form:errors>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Số lượng tồn</label>
            <div class="col-sm-10">
                <form:input type="number" class="form-control" path="soLuongTon"></form:input>
                <form:errors path="soLuongTon" cssStyle="color: red"> </form:errors>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <form:select class="form-select" path="idDongSP">
                    <form:options items="${listDsp}" itemValue="id" itemLabel="ten"></form:options>
                </form:select>
            </div>
            <div class="col-6">
                <label>Màu sắc</label>
                <form:select class="form-select" path="idMauSac">
                    <form:options items="${listMauSac}" itemLabel="ten" itemValue="id"></form:options>
                </form:select>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>NSX</label>
                <form:select class="form-select" path="idNsx">
                    <form:options items="${listNsx}" itemValue="id" itemLabel="ten"></form:options>
                </form:select>
            </div>
            <div class="col-6">
                <label>Sản phẩm</label>
                <form:select class="form-select" path="idSP">
                    <form:options items="${listSp}" itemLabel="ten" itemValue="id"></form:options>
                </form:select>
            </div>
        </div>
        <br>
        <div class="buttonAdd">
            <button type="submit" class="btn btn-primary btn-success">Add</button>
        </div>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>