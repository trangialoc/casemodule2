<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/1/2022
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Giỏ Hàng - User</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="/WedUser/style.css" rel="stylesheet">

    <style>
        #thanhToan {
            position: fixed;
            float: left;
            bottom: 50px;
            left: 300px;
            width: 200px;
            height: 50px;
        }

    </style>
</head>

<body>


<!-- ======= Header ======= -->
<header id="header">
    <div class="d-flex flex-column">
        <div class="profile">
            <img src="${User.getImg()}" alt="" class="img-fluid rounded-circle">
            <h1 class="text-light"><a href="index.html">${User.getName()}</a></h1>
        </div>
        <nav id="navbar" class="nav-menu navbar">
            <ul>
                <li><a href="/SellerProduct_Servlet" class="nav-link scrollto active"><i class="bx bx-home"></i> <span>Trang Chủ</span></a>
                </li>
                <li><a href="/Seller_Iormation" class="nav-link scrollto"><i class="bx bx-user"></i>
                    <span>Thông Tin</span></a>
                </li>
                <li><a href="/Seller_Cart" class="nav-link scrollto"><i class="bx bx-book-content"></i>
                    <span>Giỏ Hàng</span></a>
                </li>
                <li><a href="/Seller_showBill" class="nav-link scrollto"><i class="bx bx-file-blank"></i>
                    <span>Lịch Sử </span></a></li>
                <li><a href="/LogoutServlet" class="nav-link scrollto"><i class="bx bx-server"></i>
                    <span>Đăng Xuất</span></a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<main id="main">
    <!-- ======= Giỏ Hàng ======= -->
    <div class="container">
        <div class="section-title">
            <h2>Giỏ Hàng</h2>
            <table class="table table-hover" style="width: 100%">
                <thead>
                <tr>
                    <th>NameProduct</th>
                    <th>Img</th>
                    <th>Amount</th>
                    <th>Price</th>
                    <td>Sửa</td>
                    <td>Xóa</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${product}" var="sp">
                    <form method="get" action="/SellerCart_Edit">
                        <tr>
                            <td style="text-align: center">
                                <input class="input-qty" name="nameProduct"
                                       value="${sp.getNameSP()}" readonly style=" width: 100px ; text-align: center">
                            </td>
                            <td style="text-align: center"><img src="${sp.getImg()}" width="100" height="100"></td>
                            <td>
                                <input class="input-qty" max="${amountMax}" min="1" name="amount" type="number"
                                       value="${sp.getAmount()}" style=" width: 100px ; text-align: center">
                            </td>
                            <td style="text-align: center">Giá: ${sp.getPrice()}/ 1sp</td>
                            <td style="text-align: center">
                                <button value="Edit" name="action"
                                        class="btn btn-outline-primary">Sửa
                                </button>
                            </td>
                            <td style="text-align: center">
                                <button value="Delete" name="action"
                                        class="btn btn-outline-danger">Xóa
                                </button>
                            </td>
                        </tr>
                        <button type="submit" value="ThanhToan" name="action" class="btn btn-primary" id="thanhToan">Thanh Toán</button>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>

<footer id="footer">
    <div class="container">
        <div class="copyright">
            &copy;Cty TNHH <strong><span>Lê Thanh Sơn</span></strong>
        </div>
        <div class="credits">
            Thành viên: <a href="https://www.facebook.com/profile.php?id=100037618023382">Nguyễn Văn An</a>
        </div>
    </div>
</footer>
</body>
<script>

</script>
</html>
