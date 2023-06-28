<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CuaHang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">Create!</h1>
<div class="createForm container" style="width: 1200px;">

    <form:form method="POST" action="/admin/cuaHang/create" modelAttribute="cuahang">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="ma"></form:input>
                <form:errors path="ma" cssStyle="color: red"> </form:errors>
                <label style="color: red">${errMa}</label>
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Ten</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="ten"></form:input>
                <form:errors path="ten" cssStyle="color: red"> </form:errors>
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
                    <option value="Việt Nam">Việt Nam</option>
                    <option value="Lào">Lào</option>
                    <option value="Campuchia">Campuchia</option>
                </form:select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <form:select name="thanhPho" class="form-select" path="thanhPho">
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Đà Nẵng">Đà Nẵng</option>
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