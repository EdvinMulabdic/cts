<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <a>Add Engineer</a>
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
        <div class="box-content">
            <form:form method="POST" action="/add_engineer" class="form-horizontal">
                <fieldset>
                    <div class="span6">
                        <div class="control-group">
                            <label class="control-label" for="name">Name</label>
                            <div class="controls">
                                <input class="input-xlarge focused" id="name" name="name" type="text" required>
                            </div>
                        </div>
                        <div class="control-group" style="display: none">
                            <label class="control-label" for="address">Address</label>
                            <div class="controls">
                                <input class="input-xlarge focused" id="address" name="address" type="text">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="city">City</label>
                            <div class="controls">
                                <input class="input-xlarge focused" id="city" name="city" type="text" required>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="email">Email</label>
                            <div class="controls">
                                <input class="input-xlarge focused" id="email" name="email" type="text" required>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="phone">Phone</label>
                            <div class="controls">
                                <input class="input-xlarge focused" id="phone" name="phone" type="text" required>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="qualifications">Department</label>
                            <div class="controls">
                                <input class="input-xlarge focused" id="qualifications" name="qualifications" type="text" required>
                            </div>
                        </div>
                        <div class="control-group" style="display: none">
                            <label class="control-label" for="role">Position</label>
                            <div class="controls">
                                <select data-rel="chosen" name="role" id="role" required>
                                    <c:forEach var="userAccesRole" items="${userAccess}">) {
                                        <option value="${userAccesRole.name}">${userAccesRole.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="control-group" style="display: none">
                            <label class="control-label" for="password">Password</label>
                            <div class="controls">
                                <input class="input-xlarge focused" id="password" name="password" type="password">
                            </div>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="control-group" style="display: none">
                            <label class="control-label" for="multiple9001">EA-9001 code</label>
                            <div class="controls">
                                <select data-rel="chosen" name="eaCodeId" id="multiple9001" multiple>
                                    <c:forEach var="ea9001" items="${ea9001}">) {
                                        <option value="${ea9001.id}">${ea9001.codeNumber}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="control-group" style="display: none">
                            <label class="control-label" for="multiple14001">EA-14001 code</label>
                            <div class="controls">
                                <select data-rel="chosen" name="eaCodeId" id="multiple14001" multiple>
                                    <c:forEach var="ea14001" items="${ea14001}">) {
                                        <option value="${ea14001.id}">${ea14001.codeNumber}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <input type="text" id="ea9001" name="ea9001" style="display: none"/>
                        <input type="text" id="ea14001" name="ea14001" style="display: none"/>
                    </div>
                    <div class="form-actions span12" style="text-align: center; padding-left: 0px">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</t:wrapper>