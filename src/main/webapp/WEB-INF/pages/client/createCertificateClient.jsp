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
                <a href="<c:url value="/server_dashboard"/>">Servers</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_list"/>">Server list</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_certificates"><c:param name="clientId" value="${client.id}"/></c:url>">Certificates</a>
                <i class="icon-angle-right"></i>
                <a>Add certificate</a>
            </li>
        </ul>

        <div class="box-content">
            <form:form method="POST" action="/add_server_to_client" class="form-horizontal">
                <input class="input-xlarge focused" id="clientId" name="clientId" type="text"  style="display: none" value="${client.id}">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="name">Server name</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="name" name="name" type="text" readonly value="${client.clientName}">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="certificateId">Duration</label>
                        <div class="controls">
                            <select  data-rel="chosen" name="certificateId" id="certificateId" required>
                                <c:forEach var="certificate" items="${certificates}">) {
                                    <option value="${certificate.id}">${certificate.certificateName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="isAccredited">Active</label>
                        <div class="controls">
                            <select  data-rel="chosen" name="isAccredited" id="isAccredited" required>
                                <option selected value="true">YES</option>
                                <option value="false">NO</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="certificateNumber">Certificate number</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="certificateNumber" name="certificateNumber" type="text" >
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="certificationDate">Certification date</label>
                        <div class="controls">
                            <input type="date"  class="date-check" name="certificationDate" id="certificationDate"  required/>
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="standardDuration">Expiration date</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="standardDuration" name="standardDuration" type="text" value="3" disabled>
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="checkbox">Change certificate validity</label>
                        <div class="controls" style="margin-top: 15px !important;">
                            <input type="checkbox" id="checkbox" onclick="enableCertificateDurationChange()">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="auditorId">Responsible Engineer</label>
                        <div class="controls">
                            <select  data-rel="chosen" name="auditorId" id="auditorId" required>
                                <c:forEach var="auditor" items="${auditori}">) {
                                    <option value="${auditor.id}">${auditor.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="ea9001Id">Kod - EA 9001</label>
                        <div class="controls">
                            <select  data-rel="chosen" name="ea9001Id" id="ea9001Id">
                                <option selected>EA9001</option>
                                <c:forEach var="ea9001" items="${ea9001}">) {
                                    <option value="${ea9001.id}">${ea9001.codeNumber}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="ea14001Id">Kod - EA 14001</label>
                        <div class="controls">
                            <select  data-rel="chosen" name="ea14001Id" id="ea14001Id">
                                <option selected>EA14001</option>
                                <c:forEach var="ea14001" items="${ea14001}">) {
                                    <option value="${ea14001.id}">${ea14001.codeNumber}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>

    <script>
        function enableCertificateDurationChange() {
            if($('#checkbox').is(':checked')) {
                $("#standardDuration").prop('disabled', false);
            }else {
                $("#standardDuration").prop('disabled', true);
            }
        };
    </script>
</t:wrapper>