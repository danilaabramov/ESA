<#import "components/common.ftl" as c>
<#import "addSerial.ftl" as f>


<@c.page>
    <div style="flex-wrap: wrap; display: flex; gap: 20px; justify-content: space-around">
        <#list serials as serial>
            <div class="card my-3" style="width: 200px; border-radius: 20px">
                <a href="${serial.getAlias()}">
                    <#if serial.filename??>
                        <img src="/img/${serial.filename}" class="card-img-top" alt="serial-image">
                    </#if>
                </a>
                <div class="m-2">
                    <h3 style="font-size: 20px; font-weight: bold">${serial.title}</h3>
                    <p>
                        <#if serial.getRating()?has_content && serial.getRating()?size != 0>
                            <#assign total = 0>
                            <#list serial.getRating() as item>
                                <#assign total += item.value>
                            </#list>
                            Рейтинг: ${total / serial.getRating()?size}
                        <#else>
                            Напишите первый отзыв!
                        </#if>
                    </p>
                    <div>
                        <span>Жанры:</span>
                        <em><#list serial.genres as genre>${genre!}<#sep>, </#list></em>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@c.page>