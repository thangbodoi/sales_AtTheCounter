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
<h1 style="text-align: center">Update Mau Sac</h1>
<div class="createForm container" style="width: 1200px;">

    <form:form method="POST" action="/admin/chucVu/update?id=${chucvu.id}" modelAttribute="chucvu">
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="ma"></form:input>
                <form:errors path="ma" cssStyle="color: red"></form:errors>
                <label style="color: red">${errMa}</label>

            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="ten"></form:input>
                <form:errors path="ten" cssStyle="color: red"> </form:errors>

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