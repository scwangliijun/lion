<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<#assign contextPath = request.contextPath/>
<#import "/common/spring.ftl" as spring/> 
<#include "/common/include-jeasyui.html" encoding="UTF-8">
</head>
<body >
<style type="text/css"> 
body{
	font-size: 12px;
	font-family: "微软雅黑"
}
.showinfo{
	border: solid 0px #A7B6CD;
	width:100%;
	align:center;
	font-size: 12px;
	font-family: "微软雅黑"
}
.showinfo tr{
	height:29px;
}
.showinfo thead th{
	width:30%;
	border-right: dotted 1px #A7B6CD;
	background-color: #FAFAFA;
}
.showinfo thead td{
	width:60%;
	padding-left:3px;
	background-color: #FAFAFA;
}
.showinfo tbody th{
	width:30%;
	border-right: dotted 1px #A7B6CD;
	background-color: #FAFAFA;
	border-top:dotted 1px #A7B6CD
}
.showinfo  tbody td{
	width:60%;
	padding-left:3px;
	border-top: dotted 1px #A7B6CD;
	background-color:#FAFAFA;
}
.footer{
	border-bottom: dotted 1px #A7B6CD;
}
</style>
	<table style="height:98%;width:100%;" cellpadding="0" cellspacing="0">
		<tr>
			<td width="60%" rowspan="2" height="98%"  valign="top" align="left" style="padding-top:5px;padding-left:10px;">
				<div id="p" class="easyui-panel" title="系统信息"  fit="true">
					<table class="showinfo"  cellpadding="0" cellspacing="0" align="center">
						<thead>
							<tr >
								<th align="right" width="30%">应用程序名称：</th>
								<td width="70%">${applicationInfo.name!}</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th width="30%"  style="background-color:#FFFFFF" align="right">应用程序版本：</th>
								<td width="70%"  style="background-color:#FFFFFF">${applicationInfo.version!}</td>
							</tr>
							<tr height="35px">
								 <th width="30%"   align="right">本次启动时间：</th>
								 <td width="70%" >
								 	 ${applicationInfo.startDate!}
								 </td>
							</tr>
							<tr>
								<th width="30%"   style="background-color:#FFFFFF"   align="right">当前己登录用户数：</th>
								<td width="70%"   style="background-color:#FFFFFF" >${applicationInfo.loginUserCount!}</td>
							</tr>
							<tr>
								 <th width="30%" align="right">是否是调试模式：</th>
								 <td width="70%">${applicationInfo.mode!}</td>
							</tr>
							<tr>
								 <th width="30%"  style="background-color:#FFFFFF"  align="right">操作系统名称：</th>
								 <td width="70%"  style="background-color:#FFFFFF" >${applicationInfo.osName!}</td>
							</tr>
							<tr>
								 <th width="30%" align="right">操作系统版本：</th>
								 <td width="70%">${applicationInfo.version!}</td>
							</tr>
							<tr>
								 <th width="30%" align="right"   style="background-color:#FFFFFF" >操作系统补丁：</th>
								 <td width="70%" style="background-color:#FFFFFF" >
								 	${applicationInfo.osArch!}
								 </td>
							</tr>
							<tr>
								 <th width="30%" align="right"   >JDK厂商：</th>
								 <td width="70%">${applicationInfo.jdkVendor!}</td>
							</tr>
							<tr>
								 <th width="30%" align="right"   style="background-color:#FFFFFF" >JDK版本：</th>
								 <td width="70%" style="background-color:#FFFFFF" >${applicationInfo.jdkVersion!}</td>
							</tr>
							<tr >
								 <th width="30%" align="right">JDK主目录：</th>
								 <td width="70%">${applicationInfo.jdkHomePath!}</td>
							</tr>
							<tr >
								 <th width="30%" align="right"  style="background-color:#FFFFFF" >Web容器名称：</th>
								 <td width="70%"  style="background-color:#FFFFFF" >${applicationInfo.webContainerName!}</td>
							</tr>
							<tr >
								 <th width="30%" align="right">启动Web容器的用户名：</th>
								 <td width="70%">${applicationInfo.startWebContainerUser!}</td>
							</tr>
							<tr >
								 <th width="30%" align="right" >JVM内存数/最大可用数(MB)：</th>
								 <td width="70%">
								 	${applicationInfo.maxMemory!}/${applicationInfo.maxUseMemory!} MB
								 </td>
							</tr>
							<tr >
								 <th width="30%" align="right"   class="footer" style="background-color:#FFFFFF;" >系统编码：</th>
								 <td width="70%"  class="footer" style="background-color:#FFFFFF" >${applicationInfo.encoding!}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</td>
				<td width="40%" height="49%" valign="top" align="center" style="padding-left:10px;padding-top:5px;padding-right:10px;">
				<div id="p" class="easyui-panel" title="数据库配置信息"  fit="true"  style="min-height:200px;">
					<table class="showinfo"  cellpadding="0" cellspacing="0" align="center">
						<thead>
							<tr >
								<th align="right" width="30%">类型：</th>
								<td width="70%">MySQL</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th width="30%"  style="background-color:#FFFFFF" align="right">服务地址：</th>
								<td width="70%"  style="background-color:#FFFFFF">localhost</td>
							</tr>
							<tr>
								<th width="30%"    align="right">端口：</th>
								<td width="70%"  >3306</td>
							</tr>
							<tr>
								<th width="30%"  style="background-color:#FFFFFF" align="right">SID：</th>
								<td width="70%"  style="background-color:#FFFFFF">commerce</td>
							</tr>
							<tr>
								<th width="30%" class="footer"  align="right">用户名：</th>
								<td width="70%" class="footer" >root</td>
							</tr>
					    </tbody>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td width="40%" height="49%" valign="top" align="center" style="padding-left:10px;padding-top:5px;padding-right:10px;">
				 <div id="p" class="easyui-panel" title="授权信息" fit="true"  style="min-height:200px;">
						<table class="showinfo"  cellpadding="0" cellspacing="0" align="center">
						<thead>
							<tr >
								<th align="right" width="30%">授权给：</th>
								<td width="70%">MySQL</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th width="30%"  style="background-color:#FFFFFF" align="right">有效期至：</th>
								<td width="70%"  style="background-color:#FFFFFF">localhost</td>
							</tr>
							<tr>
								<th width="30%" align="right">授权用户数：</th>
								<td width="70%" >1000</td>
							</tr>
							<tr>
								<th width="30%"   style="background-color:#FFFFFF"  align="right">授权产品代码：</th>
								<td width="70%"   style="background-color:#FFFFFF" >ecommerce</td>
							</tr>
							<tr>
								<th width="30%" class="footer"    align="right">授权MAC地址：</th>
								<td width="70%" class="footer"   >&nbsp;</td>
							</tr>
					    </tbody>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>