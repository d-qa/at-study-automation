#language: ru


Функция: Создание новых пользователей в системе

  Предыстория:
    Пусть В системе есть пользователь "Админ" с параметрами:
      | Администратор | true |
      | API           | API  |
    Также Для пользователя "Админ" заведен "АПИ" клиент



    И В системе есть пользователь "Пользователь1"

  Сценарий: Создание нового пользователя пользователем админинистратором
    Если Выполнить запрос "POST", с телом "Пользователь1" с помощью клиента "АПИ" по адресу "/users.json" и получить ответ "Ответ от сервера"
    Тогда Проверяем, что ответ "Ответ от сервера" имеет код "201"