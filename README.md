## Учебный проект по автоматизации тестирования (mobile)
<a name="Ссылка"></a>
<p align="center">
<img title="Wikipedia" src="images/screens/wiki-logo2.png">
</p>

##  Содержание

- Технологии и инструменты
- Список проверок, реализованных в тестах
- Запуск тестов (сборка в Jenkins)
- Allure-отчет


## Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://developer.android.com/studio/"><img src="images/logo/androidstudio.svg" width="50" height="50"  alt="AndroidStudio"/></a>
<a href="https://appium.io/"><img src="images/logo/appium.svg" width="50" height="50"  alt="Appium"/></a>
<a href="https://appium.io/"><img src="images/logo/appium-inspector.png" width="50" height="50"  alt="AppiumInspector"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.browserstack.com/"><img src="images/logo/browserstack.svg" width="50" height="50"  alt="Browserstack"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
</p>

Список проверок, реализованных в автотестах

- [x] Тест на поиск статей по слову
- [x] Тест на отмену поиска
- [x] Тест на сравнение заголовка найденной статьи  в поиске и при открытии
- [x] Тест на добавление статьи в сохраненный список


## Запуск тестов

###  Локальный запуск на эмуляторе:
1. Запуск с командной строки: 
gradle clean test -Denv=androidLocal
2. Получение отчёта: gradle allureServe

###  Настройка Jenkins и удаленный запуск в Browserstack:
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/wikiMobileBrowserStack">проект</a>

<p align="center">
<img title="Jenkins Dashboard" src="images/screens/jenkins_mobile.png">
</p>

2. Выбрать пункт **Собрать с параметрами**
3. В поля LOGIN и PASSWORD ввести логин и пароль
<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/loginMobile.png">
</p>
4. Нажать **Собрать**
5. Результат запуска сборки можно посмотреть в отчёте Allure

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/C16-NazilyaMullagildina_mobile-tests/10/allure/">Allure report</a>


[Вернуться к оглавлению ⬆](#Ссылка)
