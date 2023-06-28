<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Update_KhachHang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">Update!</h1>
<div class="createForm container" style="width: 1200px;">
    <form:form style="width: 600px; margin-left: 300px" method="POST"
               action="/admin/khachHang/update?id=${khachhang.id}" modelAttribute="khachhang">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="ma"></form:input>
                <form:errors path="ma" cssStyle="color: red"> </form:errors>
                <label style="color: red">${errMa}</label>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Họ</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="ho"></form:input>
                <form:errors path="ho" cssStyle="color: red"> </form:errors>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="ten"></form:input>
                <form:errors path="ten" cssStyle="color: red"> </form:errors>

            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên đệm</label>
            <div class="col-sm-10">
                <form:input path="tenDem" type="text" class="form-control"></form:input>
                <form:errors path="tenDem" cssStyle="color: red"> </form:errors>

            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Ngày sinh</label>
            <div class="col-sm-10">
                <form:input type="date" class="form-control" path="ngaySinh"></form:input>
                <form:errors path="ngaySinh" cssStyle="color: red"> </form:errors>

            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Số điện thoại</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="sdt"></form:input>
                <form:errors path="sdt" cssStyle="color: red"> </form:errors>

            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mật Khẩu</label>
            <div class="col-sm-10">
                <form:input type="password" class="form-control" path="matKhau"></form:input>
                <form:errors path="matKhau" cssStyle="color: red"> </form:errors>

            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Địa chỉ</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="diaChi"></form:input>
                <form:errors path="diaChi" cssStyle="color: red"> </form:errors>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label>Quốc gia</label>
                <form:select name="quocGia" class="form-select" path="quocGia">
                    <form:option value="Việt Nam">Việt Nam</form:option>
                    <form:option value="Lào">Lào</form:option>
                    <form:option value="Campuchia">Campuchia</form:option>
                </form:select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <form:select name="thanhPho" class="form-select" path="thanhPho">
                    <form:option value="Hà Nội">Hà Nội</form:option>
                    <form:option value="Đà Nẵng">Đà Nẵng</form:option>
                </form:select>
            </div>
        </div>

        <button type="submit" class="btn btn-primary btn-success">Update</button>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>