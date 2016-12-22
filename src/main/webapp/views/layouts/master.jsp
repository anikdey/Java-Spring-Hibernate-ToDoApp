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
        <link rel="stylesheet" href="<c:url value="/resources/css/plugins/toastr/toastr.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/js/plugins/gritter/jquery.gritter.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/animate.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        
        <script src="<c:url value="/resources/js/jquery-2.1.1.js" />"></script>
        <script type="text/javascript">
            function checkDelete() {
                var $chk = confirm('Are You Sure You Want To Delete This?');
                if ($chk) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div id="wrapper">
            <tiles:insertAttribute name="sidebar" />
            <div id="page-wrapper" class="gray-bg">
                <div class="row border-bottom">
                    <tiles:insertAttribute name="header" />
                </div>
                <div class="wrapper wrapper-content">
                    <tiles:insertAttribute name="content" />
                </div>
                <div class="footer">
                    <tiles:insertAttribute name="footer" />
                </div>
            </div>
            <!-- Area For The Right Sidebar -->
            <tiles:insertAttribute name="rightSidebar" />
        </div>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/metisMenu/jquery.metisMenu.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/slimscroll/jquery.slimscroll.min.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/flot/jquery.flot.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/flot/jquery.flot.tooltip.min.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/flot/jquery.flot.spline.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/flot/jquery.flot.resize.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/flot/jquery.flot.pie.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/flot/jquery.flot.symbol.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/flot/jquery.flot.time.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/peity/jquery.peity.min.js" />"></script>
        <script src="<c:url value="/resources/js/demo/peity-demo.js" />"></script>
        <script src="<c:url value="/resources/js/inspinia.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/pace/pace.min.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/jquery-ui/jquery-ui.min.js" />" ></script>
        <script src="<c:url value="/resources/js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/easypiechart/jquery.easypiechart.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/sparkline/jquery.sparkline.min.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/gritter/jquery.gritter.min.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/chartJs/Chart.min.js" />"></script>
        <script src="<c:url value="/resources/js/plugins/toastr/toastr.min.js" />"></script>
    </body>
</html>