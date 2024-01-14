<#include "security.ftl">
<#macro login path isRegisterForm>
    <form action="${path}" method="post" style=" display: flex; align-items: center; justify-content: center; width: 100%; flex-direction: column">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="username">Имя пользователя</label>
            <div class="col-sm-6">
                <input type="text" value="<#if user??>${user.username!}</#if>" id="username" name="username"
                       class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="Введите Ваше имя"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError!}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="password">Пароль</label>
            <div class="col-sm-6">
                <input type="password" id="password" name="password" value="<#if user??>${user.password!}</#if>"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}" placeholder="Введите Ваш пароль"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError!}
                    </div>
                </#if>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <#if !isRegisterForm><a href="/registration">Создать нового пользователя</a></#if>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Создать<#else>Войти</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit"><#if name != "Гость">Выйти<#else>Войти</#if></button>
    </form>
</#macro>