<#import "common.ftl" as c>

<#setting date_format="dd-MM-yyyy">
<#setting locale="en_US">


<@c.page>


    <div id="table">

    </div>


    <#if isDevMode??>
        <script src="/js/main.min.js"></script>
    <#else>
        <script src="http://localhost:8000/main.min.js"></script>

    </#if>


</@c.page>