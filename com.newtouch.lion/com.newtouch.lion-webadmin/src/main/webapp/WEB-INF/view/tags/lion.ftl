<!-- Freemarker自定义标签 -->
<#assign contextPath = request.contextPath/>
<#macro greet person>     
    <font size="+2">Hello ${person}!</font>     
</#macro>

<#macro border> 
      <table border=4 cellspacing=0 cellpadding=4><tr><td> 
        <#nested> 
      </tr></td></table> 
</#macro>
<!-- BEGIN CONTAINER -->
<div class="page-container">
<!--菜单-->
<#macro menuTree menus>
	<#if menus?? && menus?size gt 0>
		<ul class="sub-menu">
			<#list menus as menu>
				<li>
					<a href="${contextPath!}${menu.path!}">
						<#if  menu.icon??&&menu.icon?length gt 0><i class="${menu.icon!}"></i></#if>
						${menu.nameZh!}
						<#if menu.menus?? && menu.menus?size gt 0>
							<span class="arrow"></span>
						</#if>
					</a>					
					<@menuTree menu.menus/>
				</li>
			</#list>
		</ul>
	</#if>
</#macro>
<#macro menus>
	<@ui.menu>
	<!-- BEGIN SIDEBAR MENU -->
		<ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<#if menus?? && menus?size gt 0>
					<#list menus as menu>
						<!--开始第一个菜单显示样式-->
						<#if menu_index==0>
						<li class="start active">
							<a href="index.htm">
							<#if  menu.icon??&&menu.icon?length gt 0>
								<i class="${menu.icon!}"></i>
							</#if>
							<span class="title">${menu.nameZh!}</span>
							</a>
						</li>
					    <#else>
						    <li>
								<a href="javascript:;">
									<#if  menu.icon??&&menu.icon?length gt 0>
									<i class="${menu.icon!}"></i>
									</#if>
									<span class="title">${menu.nameZh!}</span>
									<#if menu.menus?? && menu.menus?size gt 0>
										<span class="arrow"></span>
									</#if>
								</a>
								<@menuTree menu.menus/>
							</li>
					   </#if> 
					</#list>
				</#if>
	</ul>		
<!-- END SIDEBAR MENU -->		
</@ui.menu>
</#macro>