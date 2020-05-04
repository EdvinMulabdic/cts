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
                <a>EA kodovi</a>
            </li>
        </ul>
        <div class="row-fluid">
            <a class="quick-button metro greenLight span2" href="<c:url value="/dodaj_ea9001_forma"/>">
                <i class="icon-plus"></i>
                <p>Dodaj EA 9001</p>
            </a>
            <a class="quick-button metro greenDark span2" href="<c:url value="/lista_ea9001_kodova"/>">
                <i class="icon-list"></i>
                <p>Lista EA 9001 kodova</p>
            </a>
        </div>
        <div class="row-fluid" style="margin-top: 4%">
            <a class="quick-button metro orangeDark span2" href="<c:url value="/dodaj_ea14001_forma"/>">
                <i class="icon-plus"></i>
                <p>Dodaj EA 14001</p>
            </a>
            <a class="quick-button metro orange span2" href="<c:url value="/lista_ea14001_kodova"/>">
                <i class="icon-list"></i>
                <p>Lista EA 14001 kodova</p>
            </a>
        </div>
    </div>
</t:wrapper>