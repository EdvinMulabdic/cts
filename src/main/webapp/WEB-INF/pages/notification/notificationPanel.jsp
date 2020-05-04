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
                <a>Notifications</a>
            </li>
        </ul>
        <div class="row-fluid">
            <a class="quick-button metro greenDark span2" href="<c:url value="/threeMonthsNotifications"/>">
                <i>3</i>
                <p>Certificates expiring in 3 months</p>
            </a>
            <a class="quick-button metro yellow span2" href="<c:url value="/sixMonthsNotifications"/>">
                <i>6</i>
                <p>Certificates expiring in 6 months</p>
            </a>
            <a class="quick-button metro red span2" href="<c:url value="/oneYearNotifications"/>">
                <i>12</i>
                <p>Certificates expiring in 12 months</p>
            </a>
        </div>
    </div>
</t:wrapper>