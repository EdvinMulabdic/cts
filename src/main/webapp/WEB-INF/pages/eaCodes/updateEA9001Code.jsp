<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="form" uri = "http://www.springframework.org/tags/form" %>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_dashboard"/>">EA kodovi</a>
                <i class="icon-angle-right"></i>
                <a>Ažuriraj kod</a>
            </li>
        </ul>
        <div class="box-content">
            <form:form method="POST" action="/azuriraj_ea9001" class="form-horizontal">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="codeName">Naziv koda</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="codeName" name="codeName" type="text" value="${eaCode.codeName}">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="codeNumber">Broj koda</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="codeNumber" name="codeNumber" type="text" value="${eaCode.codeNumber}">
                        </div>
                    </div>
                    <input type="text" id="codeId" name="codeId" value="${eaCode.id}" style="display: none"/>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Dodaj</button>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</t:wrapper>
