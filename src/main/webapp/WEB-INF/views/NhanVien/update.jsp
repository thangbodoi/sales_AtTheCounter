<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>

<body>
<h1 style="text-align: center">Add Nhân Viên</h1>
<div class="createForm container" style="width: 1200px;">

    <form:form method="POST" action="/admin/nhanVien/update/${nhanvien.id}" modelAttribute="nhanvien">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="ma"></form:input>
                <form:errors path="ma" cssStyle="color: red"></form:errors>
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
            <label class="col-sm-2 col-form-label">Tên đệm</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="tenDem"></form:input>
                <form:errors path="tenDem" cssStyle="color: red"> </form:errors>

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
            <label class="col-sm-2 col-form-label">Địa chỉ</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="diaChi"></form:input>
                <form:errors path="diaChi" cssStyle="color: red"> </form:errors>
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
            <label class="col-sm-2 col-form-label">Trang thai</label>
            <div class="col-sm-10">
                <form:radiobutton path="trangThai" label="Nghi" value="1"></form:radiobutton>
                <form:radiobutton path="trangThai" label="Dang Lam" value="0"></form:radiobutton>
                <form:errors path="trangThai"></form:errors>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Gioi tinh</label>
            <div class="col-sm-10">
                <form:radiobutton path="gioiTinh" label="Nam" value="Nam" checked="true"></form:radiobutton>
                <form:radiobutton path="gioiTinh" label="Nu" value="Nu"></form:radiobutton>
                <form:errors path="gioiTinh"></form:errors>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <label>Chức vụ</label>
                <form:select class="form-select" path="idCV.id">
                    <form:options items="${chucVuList}" itemLabel="ten" itemValue="id"></form:options>
                </form:select>
            </div>
            <div class="col-6">
                <label>Cửa hàng</label>
                <form:select class="form-select" path="idCH.id">
                    <form:options items="${cuaHangList}" itemLabel="ten" itemValue="id"></form:options>
                </form:select>
            </div>
        </div>
        <br>
        <div class="buttonAdd">
            <button type="submit" class="btn btn-primary btn-success">Update</button>
        </div>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>

</body>
</html>