<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row">
    <div class="col-lg-6">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Update Task</h5>
                <a href="<c:url value="/admin/task/task-list" />">
                    <span class="label label-primary pull-right">
                        <i class="fa fa-bars"></i> Back To List
                    </span>
                </a>
            </div>
            <div class="ibox-content">
                <sf:form class="form" commandName="task" method="POST" id="taskEntry">
                    <div class="row">
                        <c:set var="taskTitleHasBindError"><sf:errors path="taskTitle"/></c:set>
                        <div class="form-group <c:if test="${!empty taskTitleHasBindError}" > has-error </c:if> ">
                            <sf:label path="taskTitle" cssClass="control-label">Task Title</sf:label>
                            <sf:input path="taskTitle" cssClass="form-control" palceholder="Task Title" />
                            <p><sf:errors path="taskTitle" /></p>
                        </div>
                        <c:set var="taskDateHasBindError"><sf:errors path="taskDate"/></c:set>
                        <div class="form-group <c:if test="${!empty taskDateHasBindError}" > has-error </c:if> ">
                            <sf:label path="taskDate" cssClass="control-label">Task Date</sf:label>
                            <sf:input path="taskDate" cssClass="form-control" palceholder="Task Date" />
                            <p><sf:errors path="taskDate" /></p>
                        </div>

                        <c:set var="taskDescriptionHasBindError"><sf:errors path="taskDescription"/></c:set>
                        <div class="form-group <c:if test="${!empty taskDescriptionHasBindError}" > has-error </c:if> ">
                            <sf:label path="taskDescription" cssClass="control-label">Task Description</sf:label>
                            <sf:textarea path="taskDescription" cssClass="form-control" palceholder="Task Description" />
                            <p><sf:errors path="taskDescription" /></p>
                        </div>
                        <div class="form-group">
                            <div class="">
                                <button class="btn btn-sm btn-info" type="submit">Update Task</button>
                            </div>
                        </div>
                    </div>
                </sf:form>
                <script>
                    $("#taskEntry").submit(function (event) {
                        var taskDate = $("#taskDate").val();
                        var d = new Date();
                        var month = d.getMonth() + 1;
                        var day = d.getDate();
                        var systemDate = d.getFullYear() + '/' +(month < 10 ? '0' : '') + month + '/' +(day < 10 ? '0' : '') + day;

                        if(taskDate < systemDate) {
                            alert("Enter a valid date.");
                            $("#taskDate").val(taskDate);
                            event.preventDefault();
                        }
                    });
                    
                    $(document).ready(function () {
                        $('#taskDate').datepicker({dateFormat: 'yy/mm/dd'}).val();
                        $("#taskDate").attr("placeholder", "(YYYY/MM/DD)");
                        $("#taskTitle").attr("placeholder", "Enter Task Title");
                        $("#taskTitle").attr("required", "required");
                        $("#taskDate").attr("required", "required");
                        $("#taskDescription").attr("placeholder", "Enter Task Description");
                    });
                </script>
            </div>
            <div class="ibox-footer">
            </div>
        </div>
    </div>
</div>