<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${title}</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/font-awesome/css/font-awesome.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/animate.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
        <script src="<c:url value="/resources/js/jquery-2.1.1.js" />"></script>
    </head>
    <body class="gray-bg">
        <div class="middle-box text-center loginscreen animated fadeInDown">
            <div>
                <div style="margin-top: 150px;"></div>
                <h3>Selise To Do App</h3>
                <tiles:insertAttribute name="content" />
            </div>
        </div>
        
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>