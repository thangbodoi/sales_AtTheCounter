<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Purchase</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

</head>
<body>
<h1 style="text-align: center">Add San Pham</h1>
<section>
    <div class="container" style="width: 1200px">
        <form:form method="POST" action="/user/purchase/addGhct" modelAttribute="ghct">
            <div class="row mt-4">
                <div class="col-6">
                    <form:input type="text" class="form-control" path="soLuong" pattern="[0-9]*" required="true"></form:input>
                    <form:errors path="soLuong" cssStyle="color: red"></form:errors>
                    <p style="color: red">${txtSoLuong}</p>
                </div>
            </div>

            <br>
            <div class="buttonAdd">
                <button type="submit" class="btn btn-primary btn-success">OK</button>
            </div>
        </form:form>
    </div>
</section>
</body>
</html>
