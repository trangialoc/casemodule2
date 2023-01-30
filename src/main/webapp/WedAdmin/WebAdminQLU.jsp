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

    <div class="container">
        <div class="section-title">
            <h2>Trang Chủ</h2>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th style=" width: 50px ; text-align: center">name</th>
            <th style="width: 380px ; text-align: center">userName</th>
            <th style="width: 100px ;text-align: center">userpassWord</th>
            <th style=" width: 50px ; text-align: center">img</th>
            <th style=" width: 50px ; text-align: center">id_role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${user}" var="user">
            <form action="/AdminQLU_Servlet" method="post">
                <tr>
                    <td>
                        <input name="name" value="${user.getName()}"
                               style=" width: 50px ; text-align: center">
                    </td>
                    <td>
                        <input name="userName" value="${user.getUserName()}" style=" width: 380px ;" readonly>
                    </td>
                    <td>
                        <input name="userpassWord" value="${user.getPassWord()}" style=" width: 100px ;" readonly>
                    </td>
                    <td>
                        <input name="img" value="${user.getImg()}" style=" width: 50px ; text-align: center">
                    </td>
                    <td>
                        <input style=" width: 70px ; text-align: center" class="form-control" list="browsers"
                               name="roles" id="browser" value="${user.getRole()}">
                        <datalist id="browsers">
                            <option value="2">User</option>
                            <option value="3">Seller</option>
                        </datalist>
                    </td>
                    <td>
                        <button value="Edit" name="action" type="submit" class="btn btn-primary">EDIT</button>
                        <button value="Delete" name="action" type="submit" class="btn btn-danger">DELETE</button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
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
