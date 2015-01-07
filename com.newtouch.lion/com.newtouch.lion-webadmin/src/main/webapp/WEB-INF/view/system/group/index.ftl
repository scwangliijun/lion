<#assign contextPath = request.contextPath/>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<title>用户组管理</title>
<link href="${base}/resources/admin/layout4/css/custom.css" rel="stylesheet" type="text/css"/>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-sidebar-closed-hide-logo">
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<@lion.menus/>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li>
					<a href="#">Home</a><i class="fa fa-circle"></i>
				</li>
				<li>
					<a href="#">系统设置</a><i class="fa fa-circle"></i>
				</li>
				<li class="active">
					 		系统信息<@shiro.principal property="username"/>
				</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<!-- BEGIN PAGE CONTENT INNER -->
		 	  <div class="row">
				<div class="col-md-12">
					<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet box green">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>系统信息
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table  table-hover">
								<thead>
								<tr>
									<th>#</th>
									<th>应用信息项</th>
									<th> 应用信息值</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td>1</td>
									<th >应用程序名称</th>
									<td >${applicationInfo.name!}</td>
								</tr>
								<tr>
									<td>2</td>
									 <th >系统启动时间</th>
									 <td  >
									 	 ${applicationInfo.startDate!}
									</td>
								</tr>
								</tr>
								<tr>
									<td>3</td>
									<th >当前己登录用户数</th>
									<td >${applicationInfo.name!}</td>
								</tr>
								<tr>
									<td>4</td>
									<th  >是否是调试模式：</th>
								 <td >${applicationInfo.mode!}</td>
								</tr>
								<tr>
									<td>5</td>
								 	<th>操作系统名称：</th>
								 	<td>${applicationInfo.osName!}</td>
									</tr>
									<tr>
										 <td>6</td>
										 <th>操作系统版本：</th>
										 <td>${applicationInfo.version!}</td>
									</tr>
									<tr>
										  <td>7</td>
										 <th>操作系统补丁：</th>
										 <td>
										 	${applicationInfo.osArch!}
										 </td>
									</tr>
									<tr>
										 <td>8</td>
										 <th>JDK厂商：</th>
										 <td>${applicationInfo.jdkVendor!}</td>
									</tr>
									<tr>
										 <td>9</td>
										 <th>JDK版本：</th>
										 <td>${applicationInfo.jdkVersion!}</td>
									</tr>
									<tr>
										<td>10</td>
										 <th>JDK主目录：</th>
										 <td>${applicationInfo.jdkHomePath!}</td>
									</tr>
									<tr>
										<td>11</td>
										 <th>Web容器名称：</th>
										 <td>${applicationInfo.webContainerName!}</td>
									</tr>
									<tr>
										<td>12</td>
										 <th>启动Web容器的用户名：</th>
										 <td>${applicationInfo.startWebContainerUser!}</td>
									</tr>
									<tr>
										<td>13</td>
										 <th>JVM内存数/最大可用数(MB)：</th>
										 <td>${applicationInfo.maxMemory!}/${applicationInfo.maxUseMemory!} MB </td>
									</tr>
									<tr>
										 <td>14</td>
										 <th>系统编码：</th>
										 <td>${applicationInfo.encoding!}</td>
									</tr>
								</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
				</div>
				<div class="col-md-6">
					 <div class="row">
					 	 <div class="col-md-12">
					 	 	<!-- BEGIN BORDERED TABLE PORTLET-->
					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-coffee"></i>数据库配置信息
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-hover">
								<thead>
								<tr>
									<th>
										 #
									</th>
									<th>
										数据库配置项
									</th>
									<th>
										 数据库配置值
									</th>
								</tr>
								</thead>
								<tbody>
								<tr >
									<td>1</td>
									<th>类型：</th>
									<td>MySQL</td>
								</tr>
								<tr>
								     <td>2</td>
									<th>服务地址：</th>
									<td>localhost</td>
								</tr>
								<tr>
									<td>3</td>
									<th>端口：</th>
									<td>3306</td>
								</tr>
								<tr>
									<td>4</td>
									<th >SID：</th>
									<td>commerce</td>
								</tr>
								<tr>
									<td>5</td>
									<th>用户名：</th>
									<td>root</td>
								</tr>
								</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END BORDERED TABLE PORTLET-->
					</div>
					 </div>
					 <div class="row">
					 	 <div class="col-md-12">
					 	 	<!-- BEGIN SAMPLE TABLE PORTLET-->
					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs"></i>授权信息
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse">
								</a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-scrollable">
								<table class="table table-hover">
								<thead>
								<tr>
									<th>
										 #
									</th>
									<th>
										 授权项
									</th>
									<th>
										 授权值
									</th>
								</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<th>授权给：</th>
										<td>MySQL</td>
									</tr>
									<tr>
										<td>2</td>
										<th>有效期至：</th>
										<td>localhost</td>
									</tr>
									<tr>
										<td>3</td>
										<th>授权用户数：</th>
										<td>1000</td>
									</tr>
									<tr>
										<td>4</td>
										<th>授权产品代码：</th>
										<td>ecommerce</td>
									</tr>
									<tr>
										<td>5</td>
										<th>授权MAC地址：</th>
										<td>&nbsp;</td>
									</tr>
								</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- END SAMPLE TABLE PORTLET-->
					 	 </div>
					 </div>
				</div>
			</div>
			</div>
			</div>
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${contextPath}/resources/global/plugins/respond.min.js"></script>
<script src="${contextPath}/resources/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="${contextPath}/resources/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${contextPath}/resources/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${contextPath}/resources/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${contextPath}/resources/admin/layout4/scripts/layout.js" type="text/javascript"></script>
<script src="${contextPath}/resources/admin/pages/scripts/tasks.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
$(document).ready(function() { 
Metronic.init(); // init metronic core componets
Layout.init(); // init layout
Tasks.initDashboardWidget(); // init tash dashboard widget  
});
</script>
<!-- END JAVASCRIPTS -->
</body>