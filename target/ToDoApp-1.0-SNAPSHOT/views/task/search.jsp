<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row">
    <div class="col-lg-8">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <div class="row">
                    <div class="col-md-2">
                        <h5>Search List</h5>
                    </div>
                    <div class="col-md-4">
                        <c:if test="${!empty message}">
                            <p><i class="icon fa fa-check"></i> ${message}</p>
                        </c:if>  
                    </div>
                    <div class="col-md-5">
                        <a href="<c:url value="/admin/task/task-list" />">
                            <span class="label label-primary">
                                <i class="fa fa-bars"></i>
                            </span>
                        </a>
                        <a href="<c:url value="/admin/task/expires-in-seven-days" />">
                            <span class="label label-primary">
                                Expires in 7 days
                            </span>
                        </a>
                        <a href="<c:url value="/admin/task/expires-in-fifteen-days" />">
                            <span class="label label-primary">
                                Expires in 15 days
                            </span>
                        </a>
                        <a href="<c:url value="/admin/task/search-task" />">
                            <span class="label label-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </a>
                    </div>
                    <div class="col-md-1">
                        <a href="<c:url value="/admin/task/add-new-task" />">
                            <span class="label label-primary pull-right">
                                Add New Task
                            </span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="ibox-content">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <form role="form" class="form-inline" action="<c:url value="/admin/task/search-task" />" method="POST">
                            <div class="form-group">
                                <label for="taskTitle" class="">Task Title : </label>
                                <input type="text" name="taskTitle" placeholder="Task Title" id="taskTitle" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="expiryDate" class="">Expires Within : </label>
                                <input type="text" name="expiryDate" id="expiryDate" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword2" class="sr-only"></label>
                                <button class="btn btn-white" style="margin-top: 6px;" type="submit">Search</button>
                            </div>
                        </form>

                        <script>
                            $(document).ready(function () {
                                $('#expiryDate').datepicker({dateFormat: 'yy/mm/dd'}).val();
                                $("#expiryDate").attr("placeholder", "(YYYY/MM/DD)");
                                $("#taskTitle").attr("placeholder", "Enter Task Title");

                               // $("#taskTitle").attr("required", "required");
                                //$("#expiryDate").attr("required", "required");
                            });
                        </script>    
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>