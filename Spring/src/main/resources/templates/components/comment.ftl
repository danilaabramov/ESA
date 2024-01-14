<#macro comment film>
    <form method="post" action="/poster/${film.title}" enctype="multipart/form-data">
        <div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <label for="inlineFormCustomSelectPref"></label><select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref" name="value">
                <option selected>
                    Рейтинг
                </option>
                <#list [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as value>
                    <option value="${value}">${value}</option>
                </#list>
            </select>
            <label>
                <textarea maxlength="500" class="form-control" name="comment" placeholder="Напишите комментарий"></textarea>
            </label>
            <div class="form-group col-md-6">
                <button type="submit" class="btn btn-primary">Отправить</button>
            </div>

        </div>
    </form>
</#macro>