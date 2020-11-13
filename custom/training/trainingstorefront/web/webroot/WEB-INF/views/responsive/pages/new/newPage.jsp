<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 10/31/2020
  Time: 10:55 AM
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
    <c:url value="/" var="homePageUrl"/>
    <div class="container">
        <h1>
            <cms:pageSlot position="MiddleContent" var="comp" element="div" class="text-center">
                <cms:component component="${comp}" element="div" class="no-space yComponentWrapper"/>
            </cms:pageSlot>
        </h1>
        <div>
            <h3>
                <cms:pageSlot position="Section1HeaderContent" var="comp" element="div" class="">
                    <cms:component component="${comp}" element="div" class="no-space yComponentWrapper"/>
                </cms:pageSlot>
            </h3>
            <cms:pageSlot position="Section1Content" var="comp" element="div" class="">
                <cms:component component="${comp}" element="div" class="no-space yComponentWrapper"/>
            </cms:pageSlot>
        </div>
        <div class="text-right">
            <h3>
                <cms:pageSlot position="Section2HeaderContent" var="comp" element="div" class="">
                    <cms:component component="${comp}" element="div" class="no-space yComponentWrapper"/>
                </cms:pageSlot>
            </h3>
            <cms:pageSlot position="Section2Content" var="comp" element="div" class="">
                <cms:component component="${comp}" element="div" class="no-space yComponentWrapper"/>
            </cms:pageSlot>
        </div>
        <hr/>
        <div>
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                    <ul>
                        <li>Item 1</li>
                        <li>Item 2</li>
                        <li>Item 3</li>
                        <li>Item 4</li>
                        <li>Item 5</li>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm 6 col-md-6 col-lg-6">
                    <ul>
                        <li>Item 6</li>
                        <li>Item 7</li>
                        <li>Item 8</li>
                        <li>Item 9</li>
                        <li>Item 10</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template:page>