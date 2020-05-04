<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="form" uri = "http://www.springframework.org/tags/form" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/durations"/>">Durations</a>
                <i class="icon-angle-right"></i>
                <a>Update duration</a>
            </li>
        </ul>
        <div class="box-content">
            <form:form method="POST" action="/update_certificate" class="form-horizontal">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="certificateName">Duration name</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="certificateName" name="certificateName" type="text" value="${certificate.certificateName}" required>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="certificateDuration">Duration validity</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="certificateDuration" name="certificateDuration" type="number" value="${certificate.certificateDuration}" min="0" required>
                        </div>
                    </div>
                    <input name="certificateId" value="${certificate.id}" type="text" style="display: none">
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</t:wrapper>