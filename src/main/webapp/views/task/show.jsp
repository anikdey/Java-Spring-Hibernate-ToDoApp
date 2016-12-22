<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row">
    <div class="col-lg-6">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Task Detail</h5>
                <div class="ibox-tools">
                    <a href="<c:url value="/admin/task/add-new-task" />">
                        <span class="label label-primary pull-right">
                            <i class="fa fa-user"></i> Add New Task
                        </span>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <div class="row">
                    <div class="col-lg-12">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <td>Task Title</td>
                                    <td>${task.taskTitle}</td>
                                </tr>
                                <tr>
                                    <td>Task Date</td>
                                    <td>${task.taskDate}</td>
                                </tr>
                                <tr>
                                    <td>Task Description</td>
                                    <td>${task.taskDescription}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>