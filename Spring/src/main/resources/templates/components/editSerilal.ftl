<#include "security.ftl">
<#macro editSerial title user>
    <#if isAdmin>
        <form action="${title}/${user}" method="get">
            <button type="submit" class="btn btn-outline-primary">Редактировать</button>
        </form>
    </#if>
</#macro>

<#macro deleteSerial title>
    <#if isAdmin>
        <form action="${title}/delete" method="get">
            <button type="submit" class="btn btn-outline-primary">Удалить</button>
        </form>
    </#if>
</#macro>


