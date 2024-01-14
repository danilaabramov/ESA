<#import "components/common.ftl" as c>
<@c.page>
    <form method="post" action="/addSerial" enctype="multipart/form-data">
        <div class="form-group">
            <div class="col-md-3 ">
                <label for="write-the-name">Название сериала</label>
            </div>
            <div class="form-group col-md-6">
                <input type="text" class="form-control ${(titleError??)?string('is-invalid', '')}" id="write-the-name"
                       value="<#if serial??>${serial.title}</#if>" name="title" placeholder="Название"/>
                <#if titleError??>
                    <div class="invalid-feedback">
                        ${titleError!}
                    </div>
                </#if>
            </div>
            <div class="form-group col-md-6">
                <p>Жанры: </p>
                <#list ["Фантастика", "Фэнтэзи", "Триллер", "Документальный", "Комедийный", "Драма", "Милодрама", "Хоррор", "Приключения", "Мьюзикл"] as genre>
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
                    <label>Постер</label>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="validatedCustomFile"
                           name="file" value="<#if serial??>${serial.filename!}</#if>">
                    <label class="custom-file-label" for="validatedCustomFile">Загрузите файл</label>
                </div>
            </div>
            <div class="form-group col-md-6">
                <label>
                    <textarea maxlength="500" class="form-control ${(descriptionError??)?string('is-invalid', '')}"
                              name="description" value="<#if serial??>${serial.description}</#if>"
                              placeholder="description serial"></textarea>
                </label>
                <#if descriptionError??>
                    <div class="invalid-feedback">
                        ${descriptionError!}
                    </div>
                </#if>
            </div>
            <div class="form-group col-md-6">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group col-md-6">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </div>
    </form>
</@c.page>