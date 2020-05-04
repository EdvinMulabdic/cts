<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix ="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_dashboard"/>">Klijenti</a>F
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_list"/>">Lista klijenata</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_certificates"><c:param name="clientId" value="${client.id}"/></c:url>">Certifikati klijenta</a>
                <i class="icon-angle-right"></i>
                <a>Dodaj file</a>
            </li>
        </ul>

        <form:form method="POST" action="upload_file" enctype="multipart/form-data">
            <div class="control-group">
                <label class="control-label" for="revisionId">Nadzor</label>
                <div class="controls">
                    <select  data-rel="chosen" name="revisionId" id="revisionId" required>
                        <option value="0">Certifikacija</option>
                        <option value="1">Prvi nadzor</option>
                        <option value="2">Drugi nadzor</option>
                    </select>
                </div>
            </div>
            <input type="file" name="file" multiple="multiple">
            <input name="clientId" value="${client.id}" style="display: none">
            <input name="certificateName" value="${certificateName}" style="display: none">
            <input name="certificationDate" value="${certificationDate}" style="display: none">
            <input name="firstRevisionDate" value="${firstRevisionDate}" style="display: none">
            <input name="secondRevisionDate" value="${secondRevisionDate}" style="display: none">
            <input type="submit" value="Upload">
        </form:form>

    </div>
</t:wrapper>