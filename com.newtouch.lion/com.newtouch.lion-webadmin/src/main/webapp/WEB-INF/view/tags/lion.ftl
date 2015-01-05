<!-- Freemarker自定义标签 -->
<#macro greet person>     
    <font size="+2">Hello ${person}!</font>     
</#macro>

<#macro border> 
      <table border=4 cellspacing=0 cellpadding=4><tr><td> 
        <#nested> 
      </tr></td></table> 
</#macro>

<!--菜单-->
<#macro menus>
		
</#macro>