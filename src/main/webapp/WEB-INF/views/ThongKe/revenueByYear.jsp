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
<h1 style="text-align: center">Thống kê doanh thu </h1>
<div class="createForm container" style="width: 1200px;">
    <h4><a href="/admin/thongKe/revenueByDay_view">Doanh thu theo ngày</a> || <a href="/admin/thongKe/revenueByMonth_view">Doanh thu theo tháng</a> || <a href="/admin/thongKe/revenueByYear_view">Doanh thu theo năm</a></h4>
    <%--    <form method="GET" action="/admin/thongKe/revenueByDay" >--%>

    <%--        <div class="row mb-3">--%>
    <%--            <label class="col-sm-2 col-form-label">Ngày sinh</label>--%>
    <%--            <div class="col-sm-10">--%>
    <%--                <input type="date" class="form-control" name="ngay">--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--        <div style="font-size: 50px;color: red;text-align: center">${revenueByDay} $$</div>--%>

    <%--        <br>--%>
    <%--        <div class="buttonAdd">--%>
    <%--            <button type="submit" class="btn btn-primary btn-success">Xem</button>--%>
    <%--        </div>--%>
    <%--    </form>--%>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Year</th>
            <th scope="col">Doanh thu</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${f:length(ds) == 0}">
            <span>Khong co du lieu</span>
        </c:if>
        <c:if test="${f:length(ds) != 0}">
            <c:forEach items="${ds}" var="revenue" varStatus="index">
                <tr>
                    <th scope="row">${index.index + 1 }</th>
                    <td>${revenue[0]}</td>
                    <td>${revenue[1]}</td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>

</body>
</html>