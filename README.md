[![Build Status](https://travis-ci.org/777Egor777/tracker.svg?branch=master)](https://travis-ci.org/777Egor777/tracker)
[![codecov](https://codecov.io/gh/777Egor777/tracker/branch/master/graph/badge.svg)](https://codecov.io/gh/777Egor777/tracker)

# Проект "Трекер заявок"

* [Технологии](#технологии)
* [Описание](#описание)
* [Структура](#структура)
* [Интерфейс](#интерфейс)
* [Инструкция по установке](#инструкция_по_установке)
* [Документация JavaDoc](#javadoc)
* [Тесты](#тесты)
* [Автор](#автор)
* [Критика и предложения](#критика_и_предложения)

## Технологии
* VCS Git
* Java 14
* Apache Maven
* Travis-CI
* JDBC
* PostgreSQL
* Hibernate
* Junit
* Mockito
* Liquibase

## Описание
Простое CRUD-приложение с консольным интерфейсом.
Можно добавлять/удалять/изменять заявки, а так же выводить все текущие.

## Структура
![Структура](screenshots/TrackerScheme.png)
Проект делится на слои:
1. Ввод (интерфейс [Input](src/main/java/ru/job4j/tracker/input/Input.java)). 
Основная реализация - [ConsoleInput](src/main/java/ru/job4j/tracker/input/ConsoleInput.java), обеспечивающая пользовательский
ввод с консоли. Так же реализована обёртка [ValidateInput](src/main/java/ru/job4j/tracker/input/ValidateInput.java) для валидации ввода из
любого объекта, реализующего Input. Можно создать класс, реализующий интерфейс
Input для пользовательского ввода из любого другого источника(файл, веб и тд),
и установить его экземпляр как объект для ввода без изменения остального кода
2. Хранилище (интерфейс [Store](src/main/java/ru/job4j/tracker/store/Store.java)).
Отвечает за хранение заявок. В проекте есть следующие реализации:
    2.1 [MemTracker](src/main/java/ru/job4j/tracker/store/MemTracker.java)
        Хранилище, использующее память, выделяемую с помощью JVM.
        То есть, обычный Java-объект.
        Соответственно, заявки не сохраняются после завершения работы программы.
    2.2 [SqlTracker](src/main/java/ru/job4j/tracker/store/SqlTracker.java)
        Хранилище, использующее PostgreSql базу данных. Взаимодействие с 
        базой происходит при помощи JDBC - протокола.
    2.3 [HibernateTracker](src/main/java/ru/job4j/tracker/store/HibernateTracker.java)
        Хранилище, использующее PostgreSql базу данных. Взаимодействие с 
        базой происходит при помощи Hibernate.
3. Контроллер [StartUI](src/main/java/ru/job4j/tracker/StartUI.java).
    * Создаёт все необходимые для рабоыт приложения объекты
    * Обеспечивает интерактивное взаимодействие с пользователем.
    * Создаёт все необходимые объекты [UserAction](src/main/java/ru/job4j/tracker/action), выполняющие
    выбранное пользователем действие
4. Интерфейс "пользовательское действие" [UserAction](src/main/java/ru/job4j/tracker/action/UserAction.java). 
   Принимает объекты ввода и хранилища, и реализует определённое действие, которое выбрал пользователь.
   Например, добавить запись в Трекер.     
## Интерфейс

## Инструкция_по_установке

## JavaDoc

## Тесты

## Автор

Гераськин Егор Владимирович

Java-разработчик

yegeraskin13@gmail.com

+79271506651

## Критика_и_предложения
Все замечания и пожелания по этому проекту просьба направлять мне 
на электронный адрес: yegeraskin13@gmail.com
