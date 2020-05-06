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
                <a href="<c:url value="/engineer_dashboard"/>">Engineers</a>
                <i class="icon-angle-right"></i>
                <a>Update engineer</a>
            </li>
        </ul>

        <div class="box-content">
            <form:form method="POST" action="/update_engineer" class="form-horizontal">
                <div class="span6">
                    <div class="control-group">
                        <label class="control-label" for="name">Name</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="name" name="name" type="text" value="${user.name}" required>
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="address">Address</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="address" name="address" type="text" value="${user.address}">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="city">City</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="city" name="city" type="text" value="${user.city}" required>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="email">Email</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="email" name="email" type="text" value="${user.email}" required readonly>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="phone">Phone</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="phone" name="phone" type="text" value="${user.phone}" required>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="qualifications">Department</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="qualifications" name="qualifications" type="text" value="${user.qualifications}" required>
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="role">Position</label>
                        <div class="controls">
                            <select data-rel="chosen" name="role" id="role" required>
                                <option value="${user.role.name}">${user.role.name}</option>
                                <c:forEach var="userAccesRole" items="${userAccess}">) {
                                    <option value="${userAccesRole.name}">${userAccesRole.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="password">Password</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="password" name="password" type="password" value="${user.password}">
                        </div>
                    </div>
                </div>

                <div class="form-actions span12" style="text-align: center; padding-left: 0px">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
                <div class="span6" style="display: none">
                    <div class="control-group">
                        <label class="control-label" for="multiple9001">EA-9001 code</label>
                        <div class="controls">
                            <select data-rel="chosen" name="eaCodeId" id="multiple9001" multiple >
                                <c:forEach var="selectedEaCode" items="${user.ea9001List}">) {
                                    <option selected value="${selectedEaCode.id}">${selectedEaCode.codeName}</option>
                                </c:forEach>
                                <c:forEach var="ea9001" items="${ea9001}">) {
                                    <option value="${ea9001.id}">${ea9001.codeName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="multiple14001">EA-14001 code</label>
                        <div class="controls">
                            <select data-rel="chosen" name="eaCodeId" id="multiple14001" multiple >
                                <c:forEach var="selectedEaCode" items="${user.ea14001List}">) {
                                    <option selected value="${selectedEaCode.id}">${selectedEaCode.codeName}</option>
                                </c:forEach>
                                <c:forEach var="ea14001" items="${ea14001}">) {
                                    <option value="${ea14001.id}">${ea14001.codeName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <input type="text" id="ea9001" name="ea9001" style="display: none"/>
                    <input type="text" id="ea14001" name="ea14001" style="display: none"/>
                    <input name="appUserId" value="${user.id}" type="text" style="display: none">

                </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</t:wrapper>