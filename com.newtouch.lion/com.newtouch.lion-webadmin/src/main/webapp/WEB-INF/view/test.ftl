<#assign contextPath = request.contextPath/>
<#import  "/tags/lion.ftl" as lions/>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8"/>
<title>应用管理系统</title>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-sidebar-closed-hide-logo">
<br/>
<@lion.greet person="wanglijun"/>
<br/>dddd
<@lion.greet person="Even"/>
<br/>
<@lion.border>The bordered text</@lion.border>
<br/>
<@ui.menu>
</@ui.menu>
</body>
</html>