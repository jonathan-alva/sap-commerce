<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 11/6/2020
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<template:page pageTitle="${pageTitle}">
    <c:url value="/" var="homePageUrl"/>
    <div class="wrapper">
        <cms:pageSlot position="TopBanner" var="feature" element="div" class="row no-margin">
            <cms:component component="${feature}" element="div" class="col-xs-12 col-sm-12 no-space yComponentWrapper"/>
        </cms:pageSlot>
        <div class="container d-flex">
            <c:forEach items="${productList}" var="products">
                <div class="item">
                    <div class="card">
                        <div class="card-data">
                            <%--<a class="product__list--thumb" href="${fn:escapeXml(productUrl)}" title="${fn:escapeXml(product.name)}" >--%>
                                <%--<product:productPrimaryImage product="${products}" format="thumbnail"/>--%>
                            <%--</a>--%>
                            <p>${products.getName()}</p>
                            <p>${products.getSku()}</p>
                            <p>${products.getMaterial()}</p>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>

    </div>
</template:page>

