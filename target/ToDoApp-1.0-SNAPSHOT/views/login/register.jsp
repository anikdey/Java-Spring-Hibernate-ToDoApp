<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="col-lg-12 ">

    <section class="content">
        <div class="row">
            <div class="col-lg-12">
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">Register a new membership</h3>
                    </div>

                    <div class="box-body">

                        <sf:form method="POST" role="form" commandName="user" cssClass="">
                            <c:set var="firstNameHasBindError"><sf:errors path="firstName"/></c:set>
                            <div class="form-group <c:if test="${!empty firstNameHasBindError}" > has-error </c:if> ">
                                <sf:input path="firstName" cssClass="form-control" />
                                <p><sf:errors path="firstName" /></p>
                            </div>
                            <c:set var="emailHasBindError"><sf:errors path="email"/></c:set>
                            <div class="form-group <c:if test="${!empty emailHasBindError}" > has-error </c:if> ">
                                <sf:input path="email" cssClass="form-control" />
                                <p><sf:errors path="email" /></p>
                            </div>
                            <c:set var="usernameHasBindError"><sf:errors path="username"/></c:set>
                            <div class="form-group <c:if test="${!empty usernameHasBindError}" > has-error </c:if> ">
                                <sf:input path="username" cssClass="form-control" />
                                <p><sf:errors path="username" /></p>
                            </div>
                            <c:set var="passwordHasBindError"><sf:errors path="password"/></c:set>
                            <div class="form-group <c:if test="${!empty passwordHasBindError}" > has-error </c:if> ">
                                <sf:password path="password" cssClass="form-control" />
                                <p><sf:errors path="password" /></p>
                            </div>
                            <c:set var="confirmPasswordHasBindError"><sf:errors path="confirmPassword"/></c:set>
                            <div class="form-group <c:if test="${!empty confirmPasswordHasBindError}" > has-error </c:if> ">
                                <sf:password path="confirmPassword" cssClass="form-control" />
                                <p><sf:errors path="confirmPassword" /></p>
                            </div>
                            <button type="submit" class="btn btn-primary block full-width m-b">Register</button>
                            <a class="btn btn-sm btn-info" href="<c:url value="/" />">Back To Login</a>
                        </sf:form>


                        <script>
                            $(document).ready(function () {
                                $("#firstName").attr("placeholder", "Enter Name");
                                $("#email").attr("placeholder", "Enter Email");
                                $("#username").attr("placeholder", "Enter username");
                                $("#password").attr("placeholder", "Enter password");
                                $("#confirmPassword").attr("placeholder", "Re-enter password");
                                $("#firstName").attr("required", "required");
                                $("#email").attr("required", "required");
                                $("#username").attr("required", "required");
                                $("#password").attr("required", "required");
                                $("#confirmPassword").attr("required", "required");
                            });
                        </script>

                    </div>
                    <div class="box-footer">
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>