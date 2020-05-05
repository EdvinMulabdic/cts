<%@tag description="Header" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="btn btn-navbar" data-toggle="collapse"
                   data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="<c:url value="/main"/>"><span>CTS</span></a>
                <!-- start: Header Menu -->
                <div class="nav-no-collapse header-nav">
                    <ul class="nav pull-right">
                        <li class="dropdown hidden-phone">
                            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="icon-bell"></i>
                                <span class="badge red" id="notifications"></span>
                            </a>
                            <ul class="dropdown-menu notifications">
                                <li class="dropdown-menu-title">
                                    <span>Notifications </span>
                                    <a href="#" onclick="sendManually()"><i class="icon-repeat"></i></a>
                                </li>

                                <li class="dropdown-menu-sub-footer" id="allNotifications">
                                    <a href="<c:url value="/notifications_dashboard"/>">Expiring Certificates</a>
                                </li>
                            </ul>
                        </li>
                        <!-- start: User Dropdown -->
                        <li class="dropdown">
                            <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="halflings-icon white user"></i> Admin
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-menu-title">
                                    <span>Account Settings</span>
                                </li>
                                <li><a href="/"><i class="halflings-icon off"></i> Logout</a>
                                </li>
                            </ul>
                        </li>
                        <!-- end: User Dropdown -->
                    </ul>
                </div>
                <!-- end: Header Menu -->
            </div>
        </div>
    </div>
</header>
