
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/report_dashboard"/>">Reports</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/certificate_duration_search"/>">Certificate search by duration</a>
                <i class="icon-angle-right"></i>
                <a>Search results</a>
            </li>
        </ul>
        <div class="row-fluid sortable">
            <div class="box span12 responsive-tabela">
                <div class="box-header" data-original-title id="height">
                    <h2><i class="halflings-icon white certificate"></i><span class="break"></span>Duration: ${standard.certificateName} <span class="break"></span> Number of servers: ${clients.size()}</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>Servers</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty clients}">
                            <c:forEach var="client" items="${clients}">
                                <tr>
                                    <td>${client.client.clientName}</td>
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
