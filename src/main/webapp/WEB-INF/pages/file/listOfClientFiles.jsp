<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="form" uri = "http://www.springframework.org/tags/form" %>

<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_dashboard"/>">Klijenti</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_list"/>">Lista klijenata</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_certificates"><c:param name="clientId" value="${clientId}"/></c:url>">Certifikati klijenta</a>
                <i class="icon-angle-right"></i>
                <a>Dokumenti klijenta</a>
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
                    <h2><i class="halflings-icon white user"></i><span class="break"></span>Dokumenti klijenta</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>Naziv dokumenta</th>
                            <th>Pogledaj</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty files}">
                            <c:forEach var="file" items="${files}">
                                <tr>
                                    <td>${file.name}</td>
                                    <td style="text-align: center">
                                        <a class="btn btn-info" href="<c:url value="/pogledaj_dokument">
                                                <c:param name="clientId" value="${clientId}"/>
                                                <c:param name="fileName" value="${file.name}"/>
                                                <c:param name="certificateName" value="${certificateName}"/>
                                                <c:param name="certificationDate" value="${certificationDate}"/></c:url> ">
                                            <i class="halflings-icon white folder-open"></i>
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