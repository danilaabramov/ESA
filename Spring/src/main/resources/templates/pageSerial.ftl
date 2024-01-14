<#import "components/common.ftl" as c>
<#import  "components/comment.ftl" as com>
<#include "components/security.ftl">
<#import  "components/editSerilal.ftl" as edit>

<@c.page>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <#if serial.filename??>
                    <img src="/img/${serial.filename}" class="img-fluid" alt="serial-image">
                </#if>
                <p>
                    Просмотров:
                    <#if serial.view??>
                        ${serial.view!}
                    <#else >
                        0
                    </#if>
                </p>
                <p>
                    <#if serial.getRating()?size != 0>
                        <#assign total = 0>
                        <#list serial.rating as item>
                            <#assign total += item.value>
                        </#list>
                        Рейтинг:
                        ${total / serial.getRating()?size}
                    <#else >
                        Напишите комментарий первым!.
                    </#if>
                </p>
            </div>
            <div class="col-md-8">
                <@edit.editSerial serial.title serial.author.getId()>
                </@>
                <@edit.deleteSerial serial.title>

                </@>
                <div class="m-2">
                    <h1>
                        ${serial.title}
                    </h1>
                    <div class="pb-3">
                        <ul class="list-group d-inline-flex flex-row">
                            <#list serial.genres as genre>
                                <li class="list-group-item">${genre!}</li>
                            </#list>
                        </ul>
                    </div>
                    <div>
                        <p>${serial.description}</p>
                    </div>
                    <h3>
                        Комментарии
                    </h3>
                    <#list serial.comments as comment>
                        <div class="col-md-12 pb-3">
                            <div>
                                <nobr>
                                    ${comment.rating.value}
                                    ${comment.user.username}:
                                </nobr>
                            </div>
                            <div>
                                ${comment.comment}
                            </div>
                        </div>
                    </#list>
                    <div class="list-group">
                        <#if user??>
                            <@com.comment serial></@>
                        <#else >
                            <h5>
                                Для написания комментария, нужна регистрация.
                            </h5>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>

</@c.page>