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
                <a href="<c:url value="/server_dashboard"/>">Certificates</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_list"/>">Certificate list</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_certificates"><c:param name="clientId" value="${certificate.client.id}"/></c:url>">Durations</a>
                <i class="icon-angle-right"></i>
                <a>Add a validation</a>
            </li>
        </ul>
        <div class="box-content">
            <form:form method="POST" action="/createRevision" class="form-horizontal">
                <div class="control-group">
                    <label class="control-label" for="clientId">Duration name</label>
                    <div class="controls">
                        <input class="input-xlarge focused" id="clientId" name="clientId" type="text" readonly value="${certificate.certificate.certificateName}" readonly>
                    </div>
                </div>
                <div class="control-group">
                        <label class="control-label" for="certificateId">Certificate</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="certificateId" name="certificateId" type="text" readonly value="${certificate.client.clientName}" readonly>
                        </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="certificateNumber">Certificate number</label>
                    <div class="controls">
                        <input class="input-xlarge focused" id="certificateNumber" name="certificateNumber" type="text" value="${certificate.certificateNumber}">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="certificationDate">Certificate date</label>
                    <div class="controls">
                        <input type="date"  class="date-check" name="certificationDate" id="certificationDate" value="${certificate.certificationDate}" readonly/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="revisionId">Validation date</label>
                    <div class="controls">
                        <select  data-rel="chosen" name="revisionId" id="revisionId" required>
                                <option value="1">First</option>
                                <option value="2">Second</option>
                        </select>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="revisionDate">Validation date</label>
                    <div class="controls">
                        <input type="date"  class="date-check" name="revisionDate" id="revisionDate" required/>
                    </div>
                </div>
                <input class="input-xlarge focused" id="clientId" name="clientIdHidden" type="text" readonly value="${certificate.client.id}" style="display: none">

                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form:form>
        </div>
    </div>
</t:wrapper>