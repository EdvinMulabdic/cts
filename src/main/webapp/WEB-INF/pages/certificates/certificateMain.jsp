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
                <a>Duration</a>
            </li>
        </ul>
        <div class="row-fluid">
            <a class="quick-button metro orange span2" href="<c:url value="/add_duration_form"/>">
                <i class="icon-plus"></i>
                <p>Add a certificate duration</p>
            </a>
            <a class="quick-button metro blueDark span2" href="<c:url value="/duration_list"/>">
                <i class="icon-list"></i>
                <p>List of certificate durations</p>
            </a>
        </div>
    </div>
</t:wrapper>