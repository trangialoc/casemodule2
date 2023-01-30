<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Trang Chủ - User</title>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

    <link href="/WedUser/style.css" rel="stylesheet">

    <style>
        .cssTable {
            float: left;
            margin-left: 20px;
            border-collapse: collapse;
            border: 1px solid black;
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
                <li><a href="/ProductServlet_Show" class="nav-link scrollto active"><i class="bx bx-home"></i> <span>Trang Chủ</span></a>
                </li>
                <li><a href="/ProductSeverlet_Iormation" class="nav-link scrollto"><i class="bx bx-user"></i>
                    <span>Thông Tin</span></a>
                </li>
                <li><a href="/ProductServlet_Cart" class="nav-link scrollto"><i class="bx bx-book-content"></i>
                    <span>Giỏ Hàng</span></a>
                </li>
                <li><a href="/ProductServlet_showBill" class="nav-link scrollto"><i class="bx bx-file-blank"></i>
                    <span>Lịch Sử </span></a></li>
                <li><a href="/LogoutServlet" class="nav-link scrollto"><i class="bx bx-server"></i>
                    <span>Đăng Xuất</span></a>
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

            <table>
                <tr>

                    <td>

                            <div class="dropdown">
                                <button type="submit" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
                                    Loại
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="/SearchProductServlet?action=productType&&value=1">Pod</a></li>
                                    <li><a class="dropdown-item" href="/SearchProductServlet?action=productType&&value=2">Tinh Dầu</a></li>
                                    <li><a class="dropdown-item" href="/SearchProductServlet?action=productType&&value=3">Pod 1 Lần</a></li>
                                </ul>
                            </div>

                    </td>
                    <td>
                            <div class="dropdown">
                                <button type="submit" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
                                    Giá
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="/SearchProductServlet?action=price&&value1=0&&value2=99">< 100</a></li>
                                    <li><a class="dropdown-item" href="/SearchProductServlet?action=price&&value1=100&&value2=500">100- 500</a></li>
                                    <li><a class="dropdown-item" href="/SearchProductServlet?action=price&&value1=501&&value2=10000"> > 500 </a></li>
                                </ul>
                            </div>
                    </td>
                    <td>
                        <form action="/SearchProductServlet" method="post" style="margin-left: 100px">
                            <input name="nameProduct" style="height: 35px; border-radius: 5px">
                            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                        </form>
                    </td>
                </tr>
            </table>
            <c:forEach items="${product}" var="sp">
                <form action="/ProductServlet_Buy" method="get">
                    <img src="${sp.getImg()}" alt="" width="100" height="100">
                    <input name="nameProduct" value="${sp.getNameSP()}" readonly>
                    <a style="text-align: center">Giá: ${sp.getPrice()}</a>
                    <input class="input-qty" max="${sp.getAmount()}" min="1" name="amount" type="number" value="1"
                           style=" width: 100px ; text-align: center">
                    <button type="submit" class="btn btn-outline-success">MUA</button>
                </form>
            </c:forEach>

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
</html>