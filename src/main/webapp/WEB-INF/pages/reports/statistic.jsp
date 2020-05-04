<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/report_dashboard"/>">Reports</a>
                <i class="icon-angle-right"></i>
                <a>Number of servers</a>
            </li>
        </ul>
        <div class="box-content">
            <fieldset>
                <div class="control-group">
                    <h3> Report date: <fmt:formatDate pattern="dd-MM-yyyy" value="${datum}" /> </h3>
                </div>
                <div class="control-group">
                    <label class="control-label">Number of servers: ${brojKlijenata}</label>
                </div>

            </fieldset>
        </div>

    </div>
</t:wrapper>