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
                <a>Servers</a>
            </li>
        </ul>
        <div class="row-fluid">
            <a class="quick-button metro orangeDark span2" href="<c:url value="/add_server_form"/>">
                <i class="icon-plus"></i>
                <p>Add server</p>
            </a>
            <a class="quick-button metro blue span2" href="<c:url value="/server_list"/>">
                <i class="icon-list"></i>
                <p>Server list</p>
            </a>
        </div>
    </div>
</t:wrapper>