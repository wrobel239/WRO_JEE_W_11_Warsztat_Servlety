<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 05.02.2021
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/users/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>
    </div>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Dodaj użytkownika</h6>
        </div>
        <div class="card-body">
            <form action="/user/add" method="post">
                Nazwa<br>
                <input type="text" name="userName" placeholder="Nazwa użytkownika"><br>
                Email<br>
                <input type="email" name="email" placeholder="Email użytkownika"><br>
                Hasło<br>
                <input type="password" name="password" placeholder="Hasło użytkownika"><br>
                <button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Zapisz</button>
            </form>
<%--            <div class="table-responsive">--%>
<%--                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">--%>
<%--                    <thead>--%>
<%--                    <tr>--%>
<%--                        <th>Id</th>--%>
<%--                        <th>Nazwa użytkownika</th>--%>
<%--                        <th>Email</th>--%>
<%--                        <th>Akcja</th>--%>
<%--                    </tr>--%>
<%--                    </thead>--%>
<%--                    &lt;%&ndash;                                <tfoot>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                <tr>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <th>Name</th>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <th>Position</th>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <th>Office</th>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <th>Age</th>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <th>Start date</th>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <th>Salary</th>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                </tr>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                </tfoot>&ndash;%&gt;--%>
<%--                    <tbody>--%>
<%--                    <c:forEach items="${users}" var="user">--%>
<%--                        <tr>--%>
<%--                            <td>${user.id}</td>--%>
<%--                            <td>${user.userName}</td>--%>
<%--                            <td>${user.email}</td>--%>
<%--                            <td><a href="<c:url value="/user/show?id=${user.id}"/>">Pokaż</a></td>--%>
<%--                        </tr>--%>
<%--                    </c:forEach>--%>
<%--                    </tbody>--%>
<%--                </table>--%>
<%--            </div>--%>
        </div>
    </div>

    <!-- Content Row -->
    <div class="row">

    </div>

    <!-- Content Row -->
    <div class="row">

    </div>

    <!-- Content Row -->
    <div class="row">

        <!-- Content Column -->
        <div class="col-lg-6 mb-4">

        </div>

        <div class="col-lg-6 mb-4">

        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="/users/footer.jsp" %>
