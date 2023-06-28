<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My App</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">My App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/chucVu/index">Chức vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/chiTietSanPham/index">CTSP</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/cuaHang/index">Cửa hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/dongSp/index">DÒng SP</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/khachHang/index">Khách Hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/mauSac/index">Màu sắc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/nhanVien/index">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/nsx/index">NSX</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/sanPham/index">Sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/purchase/danhSachGioHang">Mua bán</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/hoaDon/listHoaDon">Hoa Don</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/thongKe/revenueByDay_view">Thong ke</a>
                </li>
                <li class="nav-item">
                    <a  class="nav-link" href="/logout">Login/Logout</a>
                </li>
            </ul>
        </div>
    </nav>
</header>

<div id="content" style="margin-bottom: 50px;
    padding-bottom: 50px;">
    <jsp:include page="${content}"/>
</div>

<footer class="footer mt-auto py-3 bg-light" style="
position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: #f8f9fa;
    padding: 20px 0;
    text-align: center;">
    <div class="container">
        <span class="text-muted">    <p>&copy; 2023 My Website. All rights reserved.</p></span>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>