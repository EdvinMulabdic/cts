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
                <a>Modify certificate</a>
            </li>
        </ul>
        <div class="box-content">
            <form:form method="POST" action="/updateCertificateClient" class="form-horizontal">
                <div class="control-group">
                    <label class="control-label" for="clientId">Duration name</label>
                    <div class="controls">
                        <input class="input-xlarge focused" id="clientId" name="clientId" type="text" readonly value="${certificate.certificate.certificateName}" readonly>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="isAccredited">Used</label>
                    <div class="controls">
                        <select  data-rel="chosen" name="isAccredited" id="isAccredited" required>
                            <option selected value="${certificate.accredited}">
                                <c:if test="${certificate.accredited == true}">
                                    YES
                                </c:if>
                                <c:if test="${certificate.accredited == false}">
                                    NO
                                </c:if>
                            </option>
                            <option value="true">YES</option>
                            <option value="false">NO</option>
                        </select>
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
                        <input class="input-xlarge focused" id="certificateNumber" name="certificateNumber" type="text" value="${certificate.certificateNumber}" readonly>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="certificationDate">Certificate date</label>
                    <div class="controls">
                        <input type="date"  class="date-check" name="certificationDate" id="certificationDate" value="${certificate.certificationDate}"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="standardDuration">Duration</label>
                    <div class="controls">
                        <input class="input-xlarge focused" id="standardDuration" name="standardDuration" type="text" value="3" disabled required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="checkbox">Change validity</label>
                    <div class="controls" style="margin-top: 15px !important;">
                        <input type="checkbox" id="checkbox" onclick="enableCertificateDurationChange()">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="name">Responsible engineer</label>
                    <div class="controls">
                        <input class="input-xlarge focused" id="name" name="name" type="text" readonly value="${certificate.appUser.name}">
                    </div>
                </div>
                <input class="input-xlarge focused" id="clientId" name="clientIdHidden" type="text" readonly value="${certificate.client.id}" style="display: none">

                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
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