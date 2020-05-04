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
                <a href="<c:url value="/engineer_search_report"/>">Search by engineer name</a>
                <i class="icon-angle-right"></i>
                <a>Search results</a>
            </li>
        </ul>
        <div class="row-fluid sortable">
            <div class="box span12 responsive-tabela">
                <div class="box-header" data-original-title id="height">
                    <h2><i class="halflings-icon white user"></i><span class="break"></span>Results for engineer ${appUser.name}</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>Server</th>
                            <th>Certificate ID</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty appUserStatistic}">
                            <c:forEach var="code" items="${appUserStatistic}">
                                <tr>
                                    <td>${code.certificate.certificateName}</td>
                                    <td>${code.certificate.id}</td>
                                   <%----%> <td>${code.counter}</td>
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
