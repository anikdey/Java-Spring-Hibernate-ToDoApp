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
                        <h5>Task List</h5>
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
            <div class="ibox-content text-center">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="tabs-container">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">Todays Tasks</a></li>
                                <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false">Tasks Scheduled For Tomorrow</a></li>
                                <li class=""><a data-toggle="tab" href="#tab-3" aria-expanded="false">All Task</a></li>
                            </ul>
                            <div class="tab-content">
                                <div id="tab-1" class="tab-pane active">
                                    <div class="panel-body">
                                        <c:choose>
                                            <c:when test="${!empty tasksScheduledForToday}">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Si No.</th>
                                                            <th>Task</th>
                                                            <th>Date</th>
                                                            <th>Description</th>
                                                            <th>Actions</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <c:forEach items="${tasksScheduledForToday}" var="task">
                                                            <tr>
                                                                <c:set var="count" value="${count + 1}" scope="page"/>
                                                                <td><c:out value="${count}" /></td>
                                                                <td><c:out value="${task.taskTitle}" /></td>
                                                                <td><c:out value="${task.taskDate}" /></td>
                                                                <td><c:out value="${task.taskDescription}" /></td>
                                                                <td>
                                                                    <a href="<c:url value="/admin/task/edit-task/${task.id}" />"><span class="badge bg-green">Edit</span></a>
                                                                    <a href="<c:url value="/admin/task/show-task/${task.id}" />"><span class="badge bg-light-blue">Show</span></a>
                                                                    <a href="<c:url value="/admin/task/delete-task/${task.id}" />" onClick="return checkDelete();"><span class="badge bg-red">Delete</span></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </c:when>
                                            <c:otherwise>
                                                <h2>No Tasks Scheduled For Today</h2>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                                <div id="tab-2" class="tab-pane">
                                    <div class="panel-body">
                                        <c:choose>
                                            <c:when test="${!empty tasksScheduledForTomorrow}">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Si No.</th>
                                                            <th>Task</th>
                                                            <th>Date</th>
                                                            <th>Description</th>
                                                            <th>Actions</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <c:forEach items="${tasksScheduledForTomorrow}" var="task">
                                                            <tr>
                                                                <c:set var="count" value="${count + 1}" scope="page"/>
                                                                <td><c:out value="${count}" /></td>
                                                                <td><c:out value="${task.taskTitle}" /></td>
                                                                <td><c:out value="${task.taskDate}" /></td>
                                                                <td><c:out value="${task.taskDescription}" /></td>
                                                                <td>
                                                                    <a href="<c:url value="/admin/task/edit-task/${task.id}" />"><span class="badge bg-green">Edit</span></a>
                                                                    <a href="<c:url value="/admin/task/show-task/${task.id}" />"><span class="badge bg-light-blue">Show</span></a>
                                                                    <a href="<c:url value="/admin/task/delete-task/${task.id}" />" onClick="return checkDelete();"><span class="badge bg-red">Delete</span></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </c:when>
                                            <c:otherwise>
                                                <h2>No Tasks Scheduled For Tomorrow</h2>
                                            </c:otherwise>
                                        </c:choose>















                                    </div>
                                </div>
                                <div id="tab-3" class="tab-pane">
                                    <div class="panel-body">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Si No.</th>
                                                    <th>Task</th>
                                                    <th>Date</th>
                                                    <th>Description</th>
                                                    <th>Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:set var="count" value="0" scope="page" />
                                                <c:forEach items="${tasks}" var="task">
                                                    <tr>
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                        <td><c:out value="${count}" /></td>
                                                        <td><c:out value="${task.taskTitle}" /></td>
                                                        <td><c:out value="${task.taskDate}" /></td>
                                                        <td><c:out value="${task.taskDescription}" /></td>
                                                        <td>
                                                            <a href="<c:url value="/admin/task/edit-task/${task.id}" />"><span class="badge bg-green">Edit</span></a>
                                                            <a href="<c:url value="/admin/task/show-task/${task.id}" />"><span class="badge bg-light-blue">Show</span></a>
                                                            <a href="<c:url value="/admin/task/delete-task/${task.id}" />" onClick="return checkDelete();"><span class="badge bg-red">Delete</span></a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>