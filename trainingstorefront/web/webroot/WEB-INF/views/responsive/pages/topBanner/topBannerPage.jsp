<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 11/2/2020
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<template:page pageTitle="${pageTitle}">

    <c:url value="/" var="homePageUrl" />

    <cms:pageSlot position="MiddleContent" var="feature" element="div" class="row no-margin">
        <cms:component component="${feature}" element="div" class="col-xs-12 col-sm-12 no-space yComponentWrapper"/>
    </cms:pageSlot>

</template:page>