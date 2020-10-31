<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 10/31/2020
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<template:page pageTitle="${pageTitle}">

    <c:url value="/" var="homePageUrl" />

    <cms:pageSlot position="MiddleContent" var="comp" element="div" class="">
        <cms:component component="${comp}" element="div" class="" />
    </cms:pageSlot>

    <%--<cms:pageSlot position="BottomContent" var="comp" element="div" class="errorNotFoundPageMiddle">--%>
        <%--<cms:component component="${comp}" element="div" class="errorNotFoundPageMiddle-component" />--%>
    <%--</cms:pageSlot>--%>

</template:page>