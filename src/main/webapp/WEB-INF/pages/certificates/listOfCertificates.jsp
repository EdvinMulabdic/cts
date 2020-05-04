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
                <a href="<c:url value="/durations"/>">Durations</a>
                <i class="icon-angle-right"></i>
                <a>Durations</a>
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
                    <h2><i class="halflings-icon white user"></i><span class="break"></span>List of certificate durations</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th>Duration</th>
                            <th>Duration time (in years)</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty certificates}">
                            <c:forEach var="certificate" items="${certificates}">
                                <tr>
                                    <td>${certificate.certificateName}</td>
                                    <td class="center">${certificate.certificateDuration}</td>
                                    <td style="text-align: center">
                                        <a class="btn btn-info"
                                           href="<c:url value="/update_duration_form"><c:param name="certificateId" value="${certificate.id}"/> </c:url>">
                                            <i class="halflings-icon white edit"></i>
                                        </a>
                                    </td>
                                    <td style="text-align: center">
                                        <a class="btn btn-danger" data-role="delete-person"
                                           onclick="return confirm('Are you sure you want to delete the duration?');"
                                           href="<c:url value="/delete_duration"><c:param name="certificateId" value="${certificate.id}"/> </c:url>">
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