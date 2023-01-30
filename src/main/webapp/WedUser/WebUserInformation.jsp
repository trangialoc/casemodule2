<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/1/2022
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Thông Tin - User</title>
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

    <!-- =======================================================
    * Template Name: iPortfolio - v3.9.1
    * Template URL: https://bootstrapmade.com/iportfolio-bootstrap-portfolio-websites-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
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
                <li><a href="/ProductServlet_Show" class="nav-link scrollto active"><i class="bx bx-home"></i> <span>Trang Chủ</span></a>
                </li>
                <li><a href="/ProductSeverlet_Iormation" class="nav-link scrollto"><i class="bx bx-user"></i> <span>Thông Tin</span></a>
                </li>
                <li><a href="/ProductServlet_Cart" class="nav-link scrollto"><i class="bx bx-book-content"></i>
                    <span>Giỏ Hàng</span></a>
                </li>
                <li><a href="/ProductServlet_showBill" class="nav-link scrollto"><i class="bx bx-file-blank"></i>
                    <span>Lịch Sử </span></a></li>
                <li><a href="/LogoutServlet" class="nav-link scrollto"><i class="bx bx-server"></i> <span>Đăng Xuất</span></a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<main id="main">
    <!-- ======= Thông tin ======= -->
    <section id="contact" class="contact">
        <div class="col-lg-12 mt-5 mt-lg-0 d-flex align-items-stretch">
            <div class="section-title">
                <h2>Thông Tin</h2>

                <form action="/ProductSeverlet_Iormation" method="post" role="form" class="php-email-form">
                    <div class="form-group">
                        <label for="name">Name :</label>
                        <br>
                        <input type="text" class="form-control" name="Name" id="subject" required
                               value="${User.getName()}">
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label for="name">UserName :</label>
                            <br>
                            <input type="email" name="UserName" class="form-control" id="name" required
                                   value="${User.getUserName()}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label for="name">PassWord :</label>
                            <br>
                            <input type="text" class="form-control" name="PassWord" id="email" required
                                   value="${User.getPassWord()}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label for="name">Img :</label>
                            <br>
                            <input type="text" class="form-control" name="img" id="img" required
                                   value="${User.getImg()}">
                        </div>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary btn-block">Lưu</button>
                    </div>
                </form>
            </div>
        </div>
        </div>
    </section>
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

</html>
