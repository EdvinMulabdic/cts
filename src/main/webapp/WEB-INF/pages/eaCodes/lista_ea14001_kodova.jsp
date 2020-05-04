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
                <a href="<c:url value="/eaCodes"/>">EA kodovi</a>
                <i class="icon-angle-right"></i>
                <a>Lista EA 14001 kodova</a>
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
                    <h2><i class="halflings-icon white user"></i><span class="break"></span>Lista EA 14001 kodova</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>Naziv koda</th>
                            <th>Broj koda</th>
                            <th>Ažuriraj</th>
                            <th>Obriši</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty ea14001Codes}">
                            <c:forEach var="ea14001Code" items="${ea14001Codes}">
                                <tr>
                                    <td class="center">${ea14001Code.codeName}</td>
                                    <td class="center">${ea14001Code.codeNumber}</td>
                                    <td style="text-align: center">
                                        <a class="btn btn-info"
                                           href="<c:url value="/azuriraj_ea14001_forma"><c:param name="codeId" value="${ea14001Code.id}"/> </c:url>">
                                            <i class="halflings-icon white edit"></i>
                                        </a>
                                    </td>
                                    <td style="text-align: center">
                                        <a class="btn btn-danger" data-role="delete-user"
                                           onclick="return confirm('Da li ste sigurni da želite obrisati kod?');"
                                           href="<c:url value="/brisanje_ea14001_koda"><c:param name="codeId" value="${ea14001Code.id}"/> </c:url>">
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