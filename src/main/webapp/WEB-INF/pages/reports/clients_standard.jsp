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
                <a>Certificate search by duration</a>
            </li>
        </ul>
        <form:form method="GET" action="/certificate_duration_search_result" class="form-horizontal">
            <div class="control-group">
                <label class="control-label" for="standard">Choose duration</label>
                <div class="controls">
                    <select data-rel="chosen" name="standard" id="standard" required>
                        <c:forEach var="standard" items="${standards}">) {
                            <option value="${standard.id}">${standard.certificateName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="control-group" style="display: none">
                <label class="control-label" for="isAccredited">Used</label>
                <div class="controls">
                    <select  data-rel="chosen" name="isAccredited" id="isAccredited" required>
                        <option value="true">YES</option>
                        <option value="false">NO</option>
                    </select>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form:form>

    </div>
</t:wrapper>