<%@ page import="com.springapp.helpers.ClientHelper"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="form" uri = "http://www.springframework.org/tags/form"%>
<c:set var="statuses" value="<%=ClientHelper.clientStatus.values()%>"/>
<t:wrapper>
    <div id="content" class="span10">
        <ul class="breadcrumb">
            <li>
                <i class="icon-dashboard"></i>
                <a href="<c:url value="/main"/>">Dashboard</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_dashboard"/>">Servers</a>
                <i class="icon-angle-right"></i>
                <a href="<c:url value="/server_list"/>">Server list</a>
                <i class="icon-angle-right"></i>
                <a>Modify server</a>
            </li>
        </ul>
        <div class="box-content span6">
            <form:form method="POST" action="/update_server" class="form-horizontal">
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="name">Server role</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="name" name="clientName" type="text" value="${client.clientName}">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="contactPerson">Hostname</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="contactPerson" name="contactPerson" type="text" value="${client.contactPerson}">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="positionInOrganization">IP Address</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="positionInOrganization" name="positionInOrganization" type="text" value="${client.positionInOrganization}">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="address">Datacenter</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="address" name="address" type="text" value="${client.address}">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="address2">Rack</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="address2" name="address2" type="text" value="${client.address2}">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="phone">RU Number</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="phone" name="phone" type="tel" value="${client.phone}">
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="email">Email</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="email" name="email" type="email" value="${client.email}">
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="webAddress">Web address</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="webAddress" name="webAddress" type="text" value="${client.webAddress}">
                        </div>
                    </div>
                    <div class="control-group" style="display: none">
                        <label class="control-label" for="clientPDVNumber">PDV broj</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="clientPDVNumber" name="clientPDVNumber" type="text" value="${client.clientPDVNumber}" >
                        </div>
                    </div>
                    <div class="control-group" style="display: none" >
                        <label class="control-label" for="clientStatus">Certificate status</label>
                        <div class="controls">
                            <select data-rel="chosen" name="clientStatus" id="clientStatus" required>
                                <option selected value="${client.clientStatus}">${client.clientStatus}</option>
                                <c:forEach var="status" items="${statuses}">) {
                                    <option value="${status}">${status}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <input name="clientId" value="${client.id}" type="text" style="display: none">
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</t:wrapper>