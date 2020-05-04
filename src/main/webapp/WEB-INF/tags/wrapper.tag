<%@tag description="Wrapper for jsp" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<html>
    <head>
        <title>CTS</title>

        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
        <link href="<c:url value="/resources/css/bootstrap-responsive.min.css/"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css/" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/style-responsive.css/"/>" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
              rel='stylesheet' type='text/css'>
        <link href="<c:url value="/resources/images/favicon.png/"/>" rel="shortcut icon">
        <link href="<c:url value="/resources/css/font-awesome.min.css/"/>" media="all">
        <link href="<c:url value="/resources/css/glyphicons.css/"/>" media="all">
        <link href="<c:url value="/resources/css/halflings.css/" />" media="all">
    </head>

    <tag:header/>

    <body>
         <div class="container-fluid-full">
             <div class="row-fluid">
                 <tag:sidebar/>
                 <jsp:doBody/>
             </div>
         </div>

         <script src="../../resources/javascripts/js/jquery-1.9.1.min.js"></script>
         <script src="../../resources/javascripts/js/jquery-migrate-1.0.0.min.js"></script>
         <script src="../../resources/javascripts/js/jquery-ui-1.10.0.custom.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.ui.touch-punch.js"></script>
         <script src="../../resources/javascripts/js/modernizr.js"></script>
         <script src="../../resources/javascripts/js/bootstrap.min.js"></script>
         <script src="../../resources/javascripts/js/bootstrap.js"></script>
         <script src="../../resources/javascripts/js/jquery.cookie.js"></script>
         <script src="../../resources/javascripts/js/fullcalendar.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.dataTables.min.js"></script>
         <script src="../../resources/javascripts/js/excanvas.js"></script>
         <script src="../../resources/javascripts/js/jquery.flot.js"></script>
         <script src="../../resources/javascripts/js/jquery.flot.pie.js"></script>
         <script src="../../resources/javascripts/js/jquery.flot.stack.js"></script>
         <script src="../../resources/javascripts/js/jquery.flot.resize.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.chosen.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.uniform.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.cleditor.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.noty.js"></script>
         <script src="../../resources/javascripts/js/jquery.elfinder.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.raty.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.iphone.toggle.js"></script>
         <script src="../../resources/javascripts/js/jquery.uploadify-3.1.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.gritter.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.imagesloaded.js"></script>
         <script src="../../resources/javascripts/js/jquery.masonry.min.js"></script>
         <script src="../../resources/javascripts/js/jquery.knob.modified.js"></script>
         <script src="../../resources/javascripts/js/jquery.sparkline.min.js"></script>
         <script src="../../resources/javascripts/js/counter.js"></script>
         <script src="../../resources/javascripts/js/retina.js"></script>
         <script src="../../resources/javascripts/js/custom.js"></script>
         <script src="../../resources/javascripts/delayEmail.js"></script>
         <script src="../../resources/javascripts/deleteNotifications.js"></script>
         <script src="../../resources/javascripts/eaCodes.js"></script>

    </body>
    <tag:footer/>
</html>