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
<h1 style="text-align: center">Hóa Đơn</h1>
<section>
    <div class="container" style="width: 1200px">
        <form:form method="POST" action="/user/purchase/updateHoaDon/${hoadon.id}" modelAttribute="hoadon">
            <div class="row mt-4">
                <div class="col-6">
                    <label>Mã</label>
                    <form:input type="text" class="form-control" path="ma" readonly="true"></form:input>
                    <form:errors path="ma" cssStyle="color: red"></form:errors>
                    <label style="color: red">${errMa}</label>
                </div>
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <form:input type="text" class="form-control" path="sdt"></form:input>
                    <form:errors path="sdt" cssStyle="color: red"> </form:errors>
                </div>
            </div>
            <div class="row mt-4">

                <div class="col-6">
                    <label>Tên Người Nhận</label>
                    <form:input type="text" class="form-control" path="tenNguoiNhan"></form:input>
                    <form:errors path="tenNguoiNhan" cssStyle="color: red"></form:errors>
                </div>
                <div class="col-6">
                    <label>Khach Hang</label>
                    <label style="font-size: 20px">${tenKhachHang}</label>
                </div>
            </div>  <div class="row mt-4">

                <div class="col-6">
                    <label>Địa chỉ</label>
                    <form:input type="text" class="form-control" path="diaChhi"></form:input>
                    <form:errors path="diaChhi" cssStyle="color: red"></form:errors>
                </div>
            <div class="col-6">
                    <label>Ngày tạo</label>
                    <form:input type="date" class="form-control" path="ngayTao" readonly="true"></form:input>
                    <form:errors path="ngayTao" cssStyle="color: red"></form:errors>
                </div>

            </div>
            <div class="row mt-4">

                <div class="col-6">
                    <label>Sản phẩm</label>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Tên Sản phẩm</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Đơn giá</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ds}" var="sp" varStatus="stt">
                                <tr>
                                    <td>
                                            ${stt.index + 1}
                                    </td>
                                    <td>
                                            ${sp.idChiTietSP.idSP.ten}
                                    </td>
                                    <td>
                                            ${sp.soLuong}
                                    </td>
                                    <td>
                                            ${sp.donGia}
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-6">
                    <label >Thành tiền: <div style="color: red;font-size: 30px"> ${totalAmount}</div></label>
                </div>
            </div>

            <br>
            <div class="buttonAdd">
                <form:button type="submit"
                   class="btn btn-primary btn-info">Thanh Toan</form:button>
            </div>
            <div class="buttonBack col-6" style="text-align: right" >
                <a type="button" href="/user/purchase/listGhct/${idGioHang}" class="btn btn-secondary">Back</a>
            </div>
        </form:form>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>