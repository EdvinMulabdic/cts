<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:wrapper>
    <!-- start: Content -->
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a>Dashboard</a>
            </li>
        </ul>

        <div class="row-fluid">
            <a class="quick-button metro blueDark span2" href="<c:url value="/engineer_dashboard"/>">
                <i class="icon-group"></i>
                <p>Engineers</p>
                <span class="badge"></span>
            </a>
            <a class="quick-button metro greenDark span2" href="<c:url value="/durations"/>">
                <i class="icon-certificate"></i>
                <p>Certificate durations</p>
                <span class="badge"></span>
            </a>
            <a class="quick-button metro yellow span2" href="<c:url value="/server_dashboard"/>">
                <i class="icon-briefcase"></i>
                <p>Servers</p>
                <span class="badge"></span>
            </a>
            <a class="quick-button metro red span2" href="<c:url value="/report_dashboard"/>">
                <i class="icon-file"></i>
                <p>Reports</p>
                <span class="badge"></span>
            </a>
            <div class="clearfix"></div>
        </div><!--/row-->
    </div>
    <!--/.fluid-container-->
    <!-- end: Content -->
</t:wrapper>