<%@ page contentType="text/html" language="java" %>
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
                <a href="<c:url value="/server_dashboard"/>">Servers</a>
                <i class="icon-angle-right"></i>
                <a>Add a server</a>
            </li>
        </ul>
        <div class="box-content">
            <form:form method="POST" action="/add_server" class="form-horizontal">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="name">Server role</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="name" name="clientName" type="text">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="contactPerson">Hostname</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="contactPerson" name="contactPerson" type="text">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="positionInOrganization">IP Address</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="positionInOrganization" name="positionInOrganization" type="text">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="address">Datacenter</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="address" name="address" type="text">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="address2">Rack</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="address2" name="address2" type="text">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="phone">RU Number</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="phone" name="phone" type="tel">
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="email">Certificates</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="email" name="email" type="text">
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="webAddress">Web address</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="webAddress" name="webAddress" type="text">
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="clientPDVNumber">PDV broj</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="clientPDVNumber" name="clientPDVNumber" type="text">
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="isTransferred">Prelaznik</label>
                        <div class="controls" style="margin-top: 15px !important;">
                            <input type="checkbox" id="isTransferred" name="isTransferred">
                        </div>
                    </div>
                    <div class="control-group" id="transferredDiv" style="display: none">
                        <label class="control-label" for="transferred">Datum prelaska</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="transferred" name="transferred" type="text">
                        </div>
                    </div>
                    <div class="form-actions">
                        <button  onclick="displayVals()" type="submit" class="btn btn-primary">Add</button>
                    </div>
                </fieldset>
                <input id="certificateId" name="certificateId" style="display: none">
            </form:form>
        </div>
    </div>
</t:wrapper>
