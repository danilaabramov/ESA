<#import "components/common.ftl" as c>
<#import "components/login.ftl" as l>

<@c.page>
    <div class="mb-1">Создать новый аккаунт</div>
    <@l.login "/registration" true/>
</@c.page>