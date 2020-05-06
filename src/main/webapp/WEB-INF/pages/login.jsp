<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix ="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<html>
<head>
    <title>CTS</title>
    <link href="<c:url value="../../resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="../../resources/css/bootstrap-responsive.min.css/" />" rel="stylesheet">
    <link href="<c:url value="../../resources/css/style.css/" />" rel="stylesheet">
    <link href="<c:url value="../../resources/css/style-responsive.css/" />" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
          rel='stylesheet' type='text/css'>
    <link href="<c:url value="../../resources/images/favicon.png/"/>" rel="shortcut icon">

    <link href="<c:url value="../../resources/css/font-awesome.min.css/" />" media="all">
    <link href="<c:url value="../../resources/css/glyphicons.css/" />" media="all">
    <link href="<c:url value="../../resources/css/halflings.css/" />" media="all">

</head>
    <body>
        <c:if test="${not empty error}">
            <div class="alert alert-error" align="center">
                <h4 class="align-center"><c:out value="${error}"/></h4>
            </div>
        </c:if>
        <div>
            <div class="row-fluid">
                <div class="login-box">
                    <h2>Login to your account</h2>
                    <form:form method="POST" action="/login_access" class="form-horizontal">
                        <fieldset>
                            <div class="input-prepend" title="Username">
                                <span class="add-on"><i class="halflings-icon user"></i></span>
                                <input class="input-large span10" name="email" id="username" type="text" placeholder="type username"/>
                            </div>
                            <div class="clearfix"></div>

                            <div class="input-prepend" title="Password">
                                <span class="add-on"><i class="halflings-icon lock"></i></span>
                                <input class="input-large span10" name="password" id="password" type="password" placeholder="type password"/>
                            </div>
                            <div class="clearfix"></div>
                            <div class="button-login">
                                <button type="submit" class="btn btn-primary">Login</button>
                            </div>
                            <div class="clearfix"></div>
                        </fieldset>
                    </form:form>
                    <hr>
                </div><!--/span-->
            </div><!--/row-->
        </div>
    </body>

</html>