<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 05.02.2021
  Time: 14:57
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
        <a href="<c:url value="/user/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Szczegóły użytkownika</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
<%--                    <thead>--%>
<%--                    <tr>--%>
<%--                        <th>Id</th>--%>
<%--                        <th>Nazwa użytkownika</th>--%>
<%--                        <th>Email</th>--%>
<%--                        <th>Akcja</th>--%>
<%--                    </tr>--%>
<%--                    </thead>--%>
                    <%--                                <tfoot>--%>
                    <%--                                <tr>--%>
                    <%--                                    <th>Name</th>--%>
                    <%--                                    <th>Position</th>--%>
                    <%--                                    <th>Office</th>--%>
                    <%--                                    <th>Age</th>--%>
                    <%--                                    <th>Start date</th>--%>
                    <%--                                    <th>Salary</th>--%>
                    <%--                                </tr>--%>
                    <%--                                </tfoot>--%>
                    <tbody>
                    <tr>
                        <td>Id</td>
                        <td>${user.id}</td>
                    </tr>
                    <tr>
                        <td>Nazwa użytkownika</td>
                        <td>${user.userName}</td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${user.email}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
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
