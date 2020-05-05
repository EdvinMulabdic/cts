<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a>Reports</a>
            </li>
        </ul>
        <div class="row-fluid">
            <a class="quick-button metro green span2" href="<c:url value="/server_number"/>">
                <i class="icon-list"></i>
                <p>Number of servers</p>
            </a>
            <a class="quick-button metro greenDark span2" href="<c:url value="/certificate_duration_search"/>">
                <i class="icon-list"></i>
                <p>Certificate search by duration</p>
            </a>
 <%--           <a class=&lt;%&ndash;&ndash;%&gt;"quick-button metro greenLight span2" href="<c:url value="/engineer_search_report"/>">
                <i class="icon-list"></i>
                <p>Search by engineer name</p>
            </a>--%>
        </div>
    </div>
</t:wrapper>