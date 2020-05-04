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
                <a>Engineers</a>
            </li>
        </ul>
        <div class="row-fluid">
            <a class="quick-button metro greenDark span2" href="<c:url value="/add_engineer_form"/>">
                <i class="icon-plus"></i>
                <p>Add Engineer</p>
            </a>
            <a class="quick-button metro yellow span2" href="<c:url value="/engineer_list"/>">
                <i class="icon-list"></i>
                <p>Engineer List</p>
            </a>
        </div>
    </div>
</t:wrapper>