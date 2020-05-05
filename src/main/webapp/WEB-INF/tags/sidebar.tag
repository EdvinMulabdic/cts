<%@tag description="Sidebar" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- start: Main Menu -->
<div id="sidebar-left" class="span2">
    <div class="nav-collapse sidebar-nav">
        <ul class="nav nav-tabs nav-stacked main-menu">
            <li><a href="<c:url value="/main"/>"><i class="icon-dashboard"></i><span
                    class=" hidden-tablet">
                            Dashboard</span></a></li>
            <li>
                <a class="dropmenu" href="#"><i class="icon-group"></i><span class="hidden-tablet">
                                Engineers</span> <span
                        class="label label-important"></span></a>
                <ul>
                    <li><a class="submenu" href="<c:url value="/engineer_dashboard"/>"><i
                            class="icon-bar-chart"></i><span class="hidden-tablet">
                                    Engineer dashboard</span></a></li>
                    <li><a class="submenu" href="/add_engineer_form"><i
                            class="icon-plus"></i><span class="hidden-tablet">
                                    Add engineer</span></a></li>
                    <li><a class="submenu" href="<c:url value="/engineer_list"/>"><i
                            class="icon-list"></i><span class="hidden-tablet">
                                    Engineer list</span></a></li>
                </ul>
            </li>
            <li>
                <a class="dropmenu" href="#"><i class="icon-certificate"></i><span class="hidden-tablet">
                                Certificate Durations</span> </a>
                <ul>
                    <li><a class="submenu" href="<c:url value="/durations"/>"><i
                            class="icon-bar-chart"></i><span class="hidden-tablet">
                                    Durations Dashboard</span></a></li>
                    <li><a class="submenu" href="<c:url value="/add_duration_form"/>"><i class="icon-plus"></i><span
                            class="hidden-tablet">
                                    Add duration</span></a></li>
                    <li><a class="submenu" href="<c:url value="/duration_list"/>"><i class="icon-list"></i><span
                            class="hidden-tablet">
                                    Duration list</span></a></li>
                </ul>
            </li>
            <li>
                <a class="dropmenu" href="#"><i class="icon-briefcase"></i><span class="hidden-tablet">
                                Servers</span> <span
                        class="label label-important"></span></a>
                <ul>
                    <li><a class="submenu" href="<c:url value="/server_dashboard"/>"><i class="icon-bar-chart"></i><span
                            class="hidden-tablet">
                                    Server dashboard </span></a></li>
                    <li><a class="submenu" href="<c:url value="/add_server_form"/>"><i class="icon-plus"></i><span
                            class="hidden-tablet">
                                    Add server </span></a></li>
                    <li><a class="submenu" href="<c:url value="/server_list"/>"><i class="icon-list"></i><span
                            class="hidden-tablet">
                                    Server list</span></a></li>
                </ul>
            </li>

            <li>
                <a class="dropmenu" href="#"><i class="icon-file"></i><span class="hidden-tablet">
                                Reports</span> </a>
                <ul>
                    <li><a class="submenu" href="<c:url value="/report_dashboard"/>"><i
                            class="icon-bar-chart"></i><span class="hidden-tablet">
                                    Reports Dashboard</span></a></li>

                </ul>
            </li>
        </ul>
    </div>
    <input id="numOfMails" value="" hidden>
</div>