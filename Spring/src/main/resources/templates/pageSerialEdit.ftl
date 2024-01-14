<#import "components/common.ftl" as c>
<#import  "components/comment.ftl" as com>
<#include "components/security.ftl">
<#import  "components/editSerilal.ftl" as edit>

<@c.page>
    <form method="post" action="update" enctype="multipart/form-data">
        <div class="form-group">
            <div class="col-md-3 ">
                <label for="film-name">Название</label>
            </div>
            <div class="form-group col-md-6">
                <input type="text" class="form-control" id="film-name" ${(titleError??)?string('is-invalid', '')}
                value="<#if serial??>${serial.title}</#if>" name="title" placeholder="Напишите название"/>
                <#if titleError??>
                    <div class="invalid-feedback">
                        ${titleError!}
                    </div>
                </#if>
                <div class="form-group col-md-6">
                    <i>Genres: </i>
                    <#list ["HORROR", "COMEDY", "THRILLER", "DOCUMENTARY", "DRAMA", "ADVENTURE", "WESTERN", "MUSICAL", "FANTASY"] as genre>
                        <div class="form-check form-check-inline">
                            <label>
                                <input type="checkbox" value="" name="${genre}">
                                ${genre!}
                            </label>
                        </div>
                    </#list>
                </div>
                <div class="form-group col-md-6">
                    <div>
                        <label>Загрузите постер</label>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="validatedCustomFile"
                               name="file"/>
                        <label class="custom-file-label"
                               for="validatedCustomFile"><#if serial??>${serial.filename!}</#if></label>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label>
<textarea maxlength="500" class="form-control ${(descriptionError??)?string('is-invalid', '')}"
          name="description"
          placeholder="description serial"><#if serial??>${serial.description}</#if></textarea>
                    </label>
                    <#if descriptionError??>
                        <div class="invalid-feedback">
                            ${descriptionError!}
                        </div>
                    </#if>
                </div>
                <div class="form-group col-md-6">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <input type="hidden" name="id" value="<#if serial??>${serial.getId()}</#if>"/>
                    <div class="form-group col-md-6">
                        <button type="submit" class="btn btn-primary">Сохранить сериал</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</@c.page>