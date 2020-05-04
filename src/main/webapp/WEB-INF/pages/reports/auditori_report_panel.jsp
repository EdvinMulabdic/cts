<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="form" uri = "http://www.springframework.org/tags/form" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/report_dashboard"/>">Reports</a>
                <i class="icon-angle-right"></i>
                <a>Search by engineer name</a>
            </li>
        </ul>
        <form:form method="GET" action="/engineer_search_results" class="form-horizontal">
            <div class="control-group">
                <label class="control-label" for="auditor">Choose engineer</label>
                <div class="controls">
                    <select data-rel="chosen" name="auditor" id="auditor" required>
                        <c:forEach var="auditor" items="${auditori}">) {
                            <option value="${auditor.id}">${auditor.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form:form>
    </div>
</t:wrapper>