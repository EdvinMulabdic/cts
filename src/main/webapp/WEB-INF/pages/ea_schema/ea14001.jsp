<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a>Schema EA-14001 kodova</a>
            </li>
        </ul>
        <div class="row-fluid sortable">
            <div class="box span12 responsive-tabela">
                <div class="box-header" data-original-title id="height">
                    <h2><i class="halflings-icon white user"></i><span class="break"></span>Schema EA-14001 kodova</h2>
                </div>
                <div class="box-content">
                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                        <thead>
                        <tr>
                            <th></th>
                            <c:if test="${not empty ea14001}">
                                <c:forEach var="eaCode" items="${ea14001}">
                                    <th style="text-align: center">${eaCode.codeNumber}</th>
                                </c:forEach>
                            </c:if>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty appUsers}">
                            <c:forEach var="user" items="${appUsers}">
                                <tr>
                                    <td>${user.name}</td>
                                    <c:forEach var="code" items="${ea14001}">
                                        <td style="text-align: center; vertical-align: middle">
                                            <i id="${code.id} + ${user.id}"></i>
                                        </td>
                                        <c:forEach var="ea" items="${user.ea14001List}">
                                            <c:if test="${code.id.equals(ea.id)}">
                                                <script>
                                                    document.getElementById('${ea.id} + ${user.id}').classList.add("icon-check");
                                                </script>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div><!--/span-->
        </div><!--/row-->
    </div>
</t:wrapper>
