<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/engineer_dashboard"/>">Engineers</a>
                <i class="icon-angle-right"></i>
                <a>Engineer List</a>
            </li>
        </ul>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <c:out value="${error}"/>
            </div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="alert alert-success">
                <c:out value="${success}"/>
            </div>
        </c:if>
        <div class="row-fluid sortable">
            <div class="box span12 responsive-tabela">
                <div class="box-header" data-original-title id="height">
                    <h2><i class="halflings-icon white user"></i><span class="break"></span>Engineer List</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
<%--                            <th>Address</th>--%>
                            <th>Phone</th>
                            <th>Department</th>
<%--                            <th>Position</th>--%>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty users}">
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td class="center">${user.name}</td>
                                    <td class="center">${user.email}</td>
<%--                                    <td class="center">${user.address}, ${user.city}</td>--%>
                                    <td class="center">${user.phone}</td>
                                    <td class="center">${user.qualifications}</td>
<%--                                    <td class="center">${user.role.name}</td>--%>
                                    <td style="text-align: center">
                                        <a class="btn btn-info"
                                           href="<c:url value="/update_engineer_form"><c:param name="appUserId" value="${user.id}"/> </c:url>">
                                            <i class="halflings-icon white edit"></i>
                                        </a>
                                    </td>
                                    <td style="text-align: center">
                                        <a class="btn btn-danger" data-role="delete-user"
                                           onclick="return confirm('Are you sure you want to delete a engineer?');"
                                           href="<c:url value="/delete_engineer"><c:param name="userId" value="${user.id}"/> </c:url>">
                                            <i class="halflings-icon white trash"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div><!--/span-->
        </div><!--/row-->
    </div>
</t:wrapper>