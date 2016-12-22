<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element"> <span>
                        <img alt="image" class="img-circle" src="<c:url value="/resources/img/profile_small.jpg" />" />
                    </span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="clear">
                            <span class="block m-t-xs"> 
                                <strong class="font-bold">
                                    <p>${user.firstName}</p>
                                </strong>
                            </span> 
                            
                        </span> 
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li class="divider"></li>
                        <li><a href="<c:url value="/logout" />">Logout</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    ToDoApp
                </div>
            </li>
            <li class="">
                <a href="">
                    <i class="fa fa-bars"></i> 
                    <span class="nav-label">Tasks</span> <span class="fa arrow"></span>
                </a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="<c:url value="/admin/task/task-list" />">
                            Task List
                            <span class="label label-primary pull-right">
                                <i class="fa fa-bars"></i>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/task/add-new-task" />">
                            Add New Task
                            <span class="label label-primary pull-right">NEW</span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/task/search-task" />">
                            Search Task
                            <span class="label label-primary pull-right"><i class="fa fa-search"></i></span>
                        </a>
                    </li>
                    
                </ul>
            </li>

        </ul>
    </div>
</nav>