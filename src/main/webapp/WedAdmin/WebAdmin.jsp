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

<!--Trang chủ-->
<main id="main">

    <div class="container">
        <div class="section-title">
            <h2>Trang Chủ</h2>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th style=" width: 50px ; text-align: center">idProduct</th>
            <th style="width: 380px ; text-align: center">IMG</th>
            <th style="width: 100px ;text-align: center">nameProduct</th>
            <th style=" width: 50px ; text-align: center">price</th>
            <th style=" width: 50px ; text-align: center">amount</th>
            <th style=" width: 50px ; text-align: center">productType</th>
        </tr>
        </thead>
        <tbody>
        <form method="get" action="/AdminAdd_Product">
            <tr>
                <td>
                    <p>Thêm Sản Phẩm</p>
                </td>
                <td>
                    <input name="img" style=" width: 380px ;">
                </td>
                <td>
                    <input name="nameProduct" style=" width: 100px ;">
                </td>
                <td>
                    <input name="price" style=" width: 50px ; text-align: center">
                </td>
                <td>
                    <input name="amount" style=" width: 50px ; text-align: center">
                </td>
                <td>
                    <input style=" width: 70px ; text-align: center" class="form-control" list="browsers"
                           name="browser" id="browser1" name="">
                    <datalist id="browsers1">
                        <option value="1">Pod</option>
                        <option value="2">Tinh Dầu</option>
                        <option value="3">Pod 1 lần</option>
                    </datalist>
                </td>
                <td>
                    <button type="submit" class="btn btn-outline-primary" style="width: 100px">ADD</button>
                </td>
            </tr>
        </form>
        <c:forEach items="${product}" var="sp">
            <form action="/AdminEdit_Product" method="get">
                <tr>
                    <td>
                        <input name="idProduct" value="${sp.getIdproduct()}" readonly
                               style=" width: 50px ; text-align: center">
                    </td>
                    <td>
                        <input name="img" value="${sp.getImg()}" style=" width: 380px ;">
                    </td>
                    <td>
                        <input name="nameProduct" value="${sp.getNameSP()}" style=" width: 100px ;">
                    </td>
                    <td>
                        <input name="price" value="${sp.getPrice()}" style=" width: 50px ; text-align: center">
                    </td>
                    <td>
                        <input name="amount" value="${sp.getAmount()}" style=" width: 50px ; text-align: center">
                    </td>
                    <td>
                        <input style=" width: 70px ; text-align: center" class="form-control" list="browsers"
                               name="browser" id="browser" value="${sp.getProductType()}">
                        <datalist id="browsers">
                            <option value="1">Pod</option>
                            <option value="2">Tinh Dầu</option>
                            <option value="3">Pod 1 lần</option>
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