<#include "security.ftl">
<#import "login.ftl" as l>

<header style="padding-bottom: 62px">
    <nav class="navbar bg-light navbar-expand-sm fixed" style="
    position: fixed; top: 0; width: 100%; z-index: 1000; box-shadow: 0 2px 4px 0 rgba(0,0,0,.2);">
        <div class="header container" style="display: flex; align-items: center; justify-content: center;">
            <a class="navbar-brand" href="/">SeriesCriticHub</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <#if isAdmin>
                        <li class="nav-item">
                            <a class="nav-link" href="/addSerial">
                                <img src="/static/icons/add_to_queue.svg" alt="add_to_queue">
                                Добавить сериал
                            </a>
                        </li>
                    </#if>
                    <#if isAdmin>
                        <li class="nav-item">
                            <a class="nav-link" href="/user">
                                <img src="/static/icons/manage_accounts.svg" alt="manage_accounts">
                                Пользователи
                            </a>
                        </li>
                    </#if>
                </ul>
            </div>

            <div id="navbar-menu" class="collapse navbar-collapse">
                <form method="get" action="/" class="d-flex searcher ml-sm-2" style="height: 36px">
                    <div id="fast-search" class="fast-search input-group mr-3">
                        <label>
                            <input type="text" name="filter" class="form-control mr-3" value="${filter!}"
                                   placeholder="Поиск по названию">
                        </label>
                        <span class="input-group-append">
                <button class="btn btn-outline" type="submit" style="height: 38px">
                    <img src="/static/icons/search.svg" alt="search">
                </button>
                    </span>
                    </div>
                </form>

                <form method="get" action="/" class="d-flex searcher ml-sm-2">
                    <div class="dropdown">
                        <button class="btn dropdown-toggle" type="button" id="dropdownMenu2"
                                data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            Жанры
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <#list ["Фантастика", "Фэнтэзи", "Триллер", "Документальный", "Комедийный", "Драма", "Милодрама", "Хоррор", "Приключения", "Мьюзикл" ] as genre>
                                <button class="dropdown-item" style="cursor: pointer" type="submit" name="genre" value="${genre}">${genre}</button>
                            </#list>
                        </div>
                    </div>
                </form>

                <div class="navbar-text">${name}</div>
                <ul id="accountMenu" class="navbar-nav ml-auto mr-3">
                    <@l.logout></@l.logout>
                </ul>
            </div>
        </div>
        </div>
    </nav>
</header>
