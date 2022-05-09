<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06.05.2022
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/css/testPage.css" %>
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<img src="/images/PictureAnya3.png" width="1518" height="609"/>
<div class="text_block" style="margin-top: 30px">
    Если ты хочешь зайти в IT-сферу, но не знаешь, какое направление выбрать, мы тебе поможем! Нужно всего лишь ответить на вопросы ниже, и по итогу ты узнаешь, какая профессия подойдет именно тебе.
</div>
<div class="text_block_small" style="margin-top: 35px">
    Вопрос 1/5
</div>
<div class="text_block_big">
    Идеальная работа – это деятельность, которая дает возможность:
</div>
<div class="form_column" >
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio" value="1" checked>
        <label for="radio-1">Анализировать информацию и принимать нестандартные решения</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio" value="2" >
        <label for="radio-1">Получить стабильность и уверенность в завтрашнем дне</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio" value="3" >
        <label for="radio-1">Действовать нестандартно и находить новые методы и подходы</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio" value="4" >
        <label for="radio-1">Сделать карьеру и получить социальный статус</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio" value="5" >
        <label for="radio-1">Много общаться и взаимодействовать с другими людьми</label>
    </div>
</div>


<div class="text_block_small" style="margin-top: 35px">
    Вопрос 2/5
</div>
<div class="text_block_big">
    Какое хобби могло бы тебя заинтересовать?
</div>
<div class="form_column" >
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio2" value="1" checked>
        <label for="radio-1">Собирать конструктор и радиоуправляемые модели</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio2" value="2" >
        <label for="radio-1">Учавствовать в дебатах, квизах, разгадывать кроссворды</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio2" value="3" >
        <label for="radio-1">Смотреть фильмы и писать отзывы. Всегда подмечаю много деталей!</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio2" value="4" >
        <label for="radio-1">У меня отличное воображение, поэтому подойдет любое творческое занятие</label>
    </div>

</div>


<div class="text_block_small" style="margin-top: 35px">
    Вопрос 3/5
</div>
<div class="text_block_big">
    Давайте представим идеальный рабочий день. Какой он?
</div>
<div class="form_column" >
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio3" value="1" checked>
        <label for="radio-1">Спокойная работа за компьютером - без овертаймов и всякой болтовни</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio3" value="2" >
        <label for="radio-1">Люблю многозадачность: больше продуктивных митингов, планов и эффективных решений</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio3" value="3" >
        <label for="radio-1">Когда есть возможность влиять на процессы и виден результат работы</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio3" value="4" >
        <label for="radio-1">Когда все идеи, даже самые нестандартные, принимают во внимание, а творческий подход только поощеряется</label>
    </div>
</div>


<div class="text_block_small" style="margin-top: 35px">
    Вопрос 4/5
</div>
<div class="text_block_big">
    Предположим, ты совершил ошибку на работе. Начальник на это указал. Твои действия?
</div>
<div class="form_column" >
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio4" value="1" checked>
        <label for="radio-1">На ошибках учатся - все оперативно исправлю</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio4" value="2" >
        <label for="radio-1">Выслушаю начальника, проанализирую проблемы, исправлю ошибку, сделаю выводы</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio4" value="3" >
        <label for="radio-1">Я очень внимательно отношусь к деталям: ошибку исправлю, но проверю недочеты</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio4" value="4" >
        <label for="radio-1">Подойду к проблеме креативно: например, сделаю так, чтобы ошибка не бросалась в глаза</label>
    </div>
</div>


<div class="text_block_small" style="margin-top: 35px">
    Вопрос 5/5
</div>
<div class="text_block_big">
    О каких карьерных достижениях ты мечтаешь?
</div>
<div class="form_column" >
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio5" value="1" checked>
        <label for="radio-1">Создать что-нибудь великое - неважно в команде или самостоятельно</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio5" value="2" >
        <label for="radio-1">Плевать на карьеру, главное - возможность реализовать себя</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio5" value="3" >
        <label for="radio-1">Безусловно, стать руководителем</label>
    </div>
    <div class="form_radio">
        <input id="radio-1" type="radio" name="radio5" value="4" >
        <label for="radio-1">Интересует горизонтальный рост: хочу стать незаменимым специалистом</label>
    </div>
</div>
<input name="save" type="submit" class="button_find" value="Завершить тест">
<jsp:include page="footer.jsp"/>
</body>
</html>
