<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_dashboard"/>">Servers</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_list"/>">Server list</a>
                <i class="icon-angle-right"></i>
                <a>Certificates for ${clientName}</a>
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
                <form:form method="get" action="/add_duration" class="form-horizontal">
                    <div class="box-header" data-original-title id="height">
                        <h2><i class="halflings-icon white user"></i><span class="break"></span>Certificates for ${clientName}</h2>
                    </div>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <thead>
                            <tr>
                                <th>Duration</th>
                                <th>Certificate number</th>
                                <th>Certification date</th>
                                <th>Expiration date</th>
<%--                                <th>First Validation date</th>--%>
                                <th>Responsible engineer</th>
                                <th>Used</th>
<%--                                <th style="text-align: center">Validate</th>--%>
<%--                                <th style="text-align: center">Add a document</th>--%>
<%--                                <th style="text-align: center">View documents</th>--%>
                                <th style="text-align: center">Update</th>
                                <th style="text-align: center">Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${not empty certificates}">
                                <c:forEach var="certificate" items="${certificates}">
                                    <tr>
                                        <td>${certificate.certificate.certificateName}</td>
                                        <td>${certificate.certificateNumber}</td>
                                        <td>${certificate.certificationDate}</td>
                                        <td>${certificate.expirationDate}</td>
<%--                                        <td>${certificate.firstRevisionDate}</td>--%>
                                        <td>${certificate.appUser.name}</td>
                                        <td>
                                            <c:if test="${certificate.accredited == true}">
                                                YES
                                            </c:if>
                                            <c:if test="${certificate.accredited == false}">
                                                NO
                                            </c:if>
                                        </td>
<%--                                        <td style="text-align: center">--%>
<%--                                            <a class="btn btn-info" href="<c:url value="/createRevisionForma"><c:param name="certificationNumber" value="${certificate.certificateNumber}"/></c:url> ">--%>
<%--                                                <i class="halflings-icon white plus"></i>--%>
<%--                                            </a>--%>
<%--                                        </td>--%>
<%--                                        <td style="text-align: center">--%>
<%--                                            <a class="btn btn-info" href="<c:url value="/upload_file_forma"><c:param name="clientId" value="${certificate.client.id}"/>--%>
<%--                                                <c:param name="certificateName" value="${certificate.certificate.certificateName}"/>--%>
<%--                                                <c:param name="certificateNumber" value="${certificate.certificateNumber}"/>--%>
<%--                                                <c:param name="certificationDate" value="${certificate.certificationDate}"/>--%>
<%--                                                <c:param name="firstRevisionDate" value="${certificate.firstRevisionDate}"/>--%>
<%--                                                <c:param name="secondRevisionDate" value="${certificate.secondRevisionDate}"/>--%>
<%--                                                </c:url> ">--%>
<%--                                                <i class="halflings-icon white folder-open"></i>--%>
<%--                                            </a>--%>
<%--                                        </td>--%>
<%--                                        <td style="text-align: center">--%>
<%--                                            <a class="btn btn-info" href="<c:url value="/folderi"><c:param name="clientId" value="${certificate.client.id}"/>--%>
<%--                                                                                                             <c:param name="certificateName" value="${certificate.certificate.certificateName}"/>--%>
<%--                                                                                                             <c:param name="certificationDate" value="${fn:substring(certificate.certificationDate.toString(), 0, 4)}"/>--%>
<%--                                                                                                             <c:param name="firstRevisionDate" value="${fn:substring(certificate.firstRevisionDate.toString(), 0, 4)}"/>--%>
<%--                                                                                                             <c:param name="secondRevisionDate" value="${fn:substring(certificate.secondRevisionDate.toString(), 0, 4)}"/>--%>
<%--                                                </c:url> ">--%>
<%--                                                <i class="halflings-icon white folder-open"></i>--%>
<%--                                            </a>--%>
<%--                                        </td>--%>
                                        <td style="text-align: center">
                                            <a class="btn btn-info"
                                               href="<c:url value="/updateCertificateClientForma"><c:param name="certificationNumber" value="${certificate.certificateNumber}"/> </c:url>">
                                                <i class="halflings-icon white edit"></i>
                                            </a>
                                        </td>
                                        <td style="text-align: center">
                                            <a class="btn btn-danger" data-role="delete-person" onclick="return confirm('Are you sure you want to delete a certificate?');"
                                               href="<c:url value="/delete_client_certificate"><c:param name="clientId" value="${clientId}"/> <c:param name="certificateId" value="${certificate.certificate.id}"/>
                                                                                                      <c:param name="certificateClientId" value="${certificate.id}"/></c:url> ">
                                                <i class="halflings-icon white trash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                    <input type="text" name="clientId" value="${clientId}" style="display: none">
                    <div class="box-icon" style="text-align: center">
                        <button type="submit" class="btn btn-primary">Add certificate</button>
                    </div>
                </form:form>
            </div><!--/span-->
        </div><!--/row-->
    </div>
</t:wrapper>
