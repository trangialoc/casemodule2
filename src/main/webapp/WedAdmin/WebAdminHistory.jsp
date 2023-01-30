<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/1/2022
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>iPortfolio Bootstrap Template - Index</title>
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
    <link href="/WedAdmin/style.css" rel="stylesheet">


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
                <li><a href="/AdminWed_Servlet" class="nav-link scrollto active"><i class="bx bx-home"></i> <span>Trang Chủ</span></a>
                </li>
                <li><a href="/AdminQLU_Servlet" class="nav-link scrollto"><i class="bx bx-book-content"></i>
                    <span>Quản Lý</span></a>
                </li>
                <li><a href="/AdminBill_Servlet" class="nav-link scrollto"><i class="bx bx-file-blank"></i>
                    <span>Lịch Sử </span></a></li>
                <li><a href="/LogoutServlet" class="nav-link scrollto"><i class="bx bx-server"></i> <span>Đăng Xuất</span></a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<main id="main">

    <!-- ======= Lịch sử ======= -->
    <section id="portfolio" class="portfolio section-bg">
        <div class="container">
            <div class="section-title">
                <h2>Lịch Sử</h2>
            </div>
            <h1>Tổng : ${DoanhThu}</h1>
            <table class="table">
                <thead>
                <tr>
                    <th style="width: 380px ;">UserName</th>
                    <th style="width: 100px ;">Date</th>
                    <th style=" width: 50px ; ">totalbill</th>
                    <th>Chi tiết</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${bill}" var="bill">
                    <form action="/AdminQLU_Servlet" method="post">
                        <tr>
                            <td>${bill.getUserName()}</td>
                            <td>${bill.getDate()}</td>
                            <td>${bill.getTotabill()}</td>
                            <td><a href="/DetailBillAdminServlet?id=${bill.getIdBill()}">Chi tiết hóa đơn</a></td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <h3>Chi tiết hóa đơn</h3>
        <table class="table table-hover" style="width: 100%">
            <thead>
            <tr>
                <th>NameProduct</th>
                <th>Img</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${product}" var="sp">
                <tr>
                    <td>${sp.getNameSP()}</td>
                    <td style="text-align: center"><img src="${sp.getImg()}" width="100" height="100"></td>
                    <td>${sp.getAmount()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>

</main>


<footer id="footer">
    <div class="container">
        <div class="copyright">
            &copy;Cty TNHH <strong><span>Lê Thanh Sơn</span></strong>
        </div>
        <div class="credits">
            Thành viên: <a href="https://www.facebook.com/profile.php?id=100037618023382">Nguyễn Văn Am</a>
        </div>
    </div>
</footer>
</body>

</html>