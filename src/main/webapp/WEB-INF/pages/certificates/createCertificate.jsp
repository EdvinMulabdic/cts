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
                <a href="<c:url value="/durations"/>">Durations</a>
                <i class="icon-angle-right"></i>
                <a>Add duration</a>
            </li>
        </ul>

        <div class="box-content">
            <form:form method="POST" action="/add_duration" class="form-horizontal">
                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="certificateName">Duration name</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="certificateName" name="certificateName" type="text" required>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="certificateDuration">Duration time (in years)</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="certificateDuration" name="certificateDuration" type="number" value="3" min="0" required>
                        </div>
                    </div>

                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </fieldset>
            </form:form>

        </div>
    </div>
</t:wrapper>