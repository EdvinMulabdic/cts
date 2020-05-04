<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/notifications_dashboard"/>">Notifications</a>
                <i class="icon-angle-right"></i>
                <a>List of sent emails</a>
            </li>
        </ul>
        <div class="row-fluid sortable">
            <div class="box span12 responsive-tabela">
                <div class="box-header" data-original-title id="height">
                    <h2><i class="halflings-icon white user"></i><span class="break"></span>List of sent emails</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>Server name</th>
                            <th>Duration</th>
                            <th>Certificate number</th>
                            <th>Message</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty oneYear}">
                            <c:forEach var="entrySet" items="${oneYear}">
                                <tr>
                                    <td>${entrySet.key.clientName}</td>
                                    <td>${entrySet.value.certificate.certificateName}</td>
                                    <td>${entrySet.value.certificateNumber}</td>
                                    <td>${oneYearMessage}</td>
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