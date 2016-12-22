<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:choose>
    <c:when test="${!empty message}">
        <p class="login-box-msg">${message}</p>
    </c:when>
    <c:otherwise>
        <p>Login to start your session.</p>
    </c:otherwise>
</c:choose>
<c:if test="${param.logout != null }" >
    You have been logged out.
</c:if>
<form class="m-t" role="form" method="POST" action="${loginProcessingUrl}">
    <div class="form-group has-feedback">
        <input type="text" name="username" id="username" class="form-control" placeholder="Username" required="">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
    </div>
    <div class="form-group has-feedback">
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required="">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary block full-width m-b">Sign In</button>         
</form>
    <div class="row">
            <div class="col-xs-8 col-xs-offset-2 text-center">
                <a class="" href="<c:url value="/register/" />" class="text-center">Create an account</a>
            </div>
        </div>