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
                <a href="<c:url value="/server_dashboard"/>">Servers</a>
                <i class="icon-angle-right"></i>
                <a>Server list</a>
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
                    <h2><i class="halflings-icon white user"></i><span class="break"></span>Certificate List</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>Server role</th>
                            <th>Hostname</th>
                            <th>IP Address</th>
                            <th>Datacenter</th>
                            <th>Rack</th>
                            <th>RU Number</th>
<%--                            <th>Email</th>--%>
<%--                            <th>Web address</th>--%>
<%--                            <th>PDV broj</th>--%>
<%--                            <th>Status</th>--%>
<%--                            <th>Prelaznik</th>--%>
                            <th>Certificates</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty clients}">
                            <c:forEach var="client" items="${clients}">
                                <tr>
                                    <td>${client.clientName}</td>
                                    <td>${client.contactPerson}</td>
                                    <td>${client.positionInOrganization}</td>
                                    <td>${client.address}</td>
                                    <td>${client.address2}</td>
                                    <td>${client.phone}</td>
<%--                                    <td>${client.email}</td>--%>
<%--                                    <td>${client.webAddress}</td>--%>
<%--                                    <td>${client.clientPDVNumber}</td>--%>
<%--                                    <td>${client.clientStatus}</td>--%>
<%--                                    <td>--%>
<%--                                        <c:if test="${client.transferred == true}">--%>
<%--                                            DA--%>
<%--                                        </c:if>--%>
<%--                                    </td>--%>
                                    <td style="text-align: center">
                                        <a class="btn btn-info"
                                           href="<c:url value="/server_certificates"><c:param name="clientId" value="${client.id}"/></c:url>">
                                            <i class="halflings-icon white folder-open"></i>
                                        </a>
                                    </td>
                                    <td style="text-align: center">
                                        <a class="btn btn-info"
                                           href="<c:url value="/update_server_form"><c:param name="clientId" value="${client.id}"/> </c:url>">
                                            <i class="halflings-icon white edit"></i>
                                        </a>
                                        <input type="text" name="clientId" value="${client.id}" style="display: none">
                                    </td>
                                    <td style="text-align: center">
                                        <a class="btn btn-danger" data-role="delete-person"
                                           onclick="return confirm('Are you sure you want to delete a certificate?');"
                                           href="<c:url value="/delete_server"><c:param name="clientId" value="${client.id}"/> </c:url>">
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