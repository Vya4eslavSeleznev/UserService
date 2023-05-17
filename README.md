# Задание

### Описание задачи:
- Необходимо реализовать REST-API средствами языка программирования Java и фреймворка Spring.
- Выбор СУБД для хранения данных остаётся за Вами.
- Пункты помеченные звёздочкой, являются дополнительными.

### Обязательные условия:
1. *Реализовать возможность авторизации по логину и паролю (admin:admin). Тип авторизации разрешается выбрать с
обоснованием: Base Auth, OAuth, JWT;
2. Реализовать CRUD модель для работы с пользователями (контактная информация);
3. Реализовать CRUD модель для работы с детальной информацией о
пользователе;
4. *Реализовать CRUD модель для возможности работы с фотографией пользователя;

### Хранимая информации о пользователе:

1. Фамилия
2. Имя
3. Отчество
4. Дата рождения
5. Электронная почта
6. Номер телефона
7. *Фотограифия

### Будет плюсом, если:

1. Выбранная Вами СУБД - PostgreSQL;
2. Проект будет покрыт автотестами;
3. В проекте будут присутствовать комментарии;
4. Для работы с базой данных будет использован JDBC / Hibernate;
5. *Хотя бы одно из дополнительных заданий в разделе обязательных будет выполнено;

### Ожидаемые данные:

1. Исходный код готового проекта;
2. Экспортированный JSON из Postman для тестирования REST-API;

# Стек

Использовались следующие технологии:

- Java 11
- Spring Boot
- Spring Mvc
- Spring Security
- Hibernate
- Swagger 3
- Junit 5
- Mockito
- Docker
- Lombok
- PostgreSQL

# Описание базы данных

![Db](docs/db.png)

- База данных содержит в себе три таблицы:
    - `contact` - хранит контактную информацию пользователя email и номер телефона
    - `credential` - хранит секреты пользователя: роль, пароль и логин
    - `customer` - хранит всю информацию о пользователе: имя, фамилия, отчество, дата рождения

# Данные в БД

- При запуске приложения уже будут доступны клиенты и админ со следующими персональными данными:

|   Роль   |   Имя    |  Пароль  |
|----------|----------|----------|
|   USER   |    q     |   pwd    |
|   USER   |   qw     |   pwd    |
|   USER   |   qwe    |   pwd    |
|   USER   |   qwer   |   pwd    |
|   USER   |  qwert   |   pwd    |
|  ADMIN   |  admin   |   pwd    |

# Дополнительное задание

### Security

- Для реализации дополнительного задания была выбрана аутентификация по JWT токенам. Это связано с тем, что JWT известны
своей большей безопасностью и надежностью. Более того, при использовании JWT требуется меньше места для хранения данных

# Описание эндпоинтов

### `http://localhost:8081/auth/signin`

- Для использование приложения необходимо авторизироваться

- Body:

```json
{
    "username" : "admin",
    "password" : "pwd"
}
```

- Response:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTY4NDMxMDcwMywiZXhwIjoxNjg0MzIxNTAzfQ.QcPE1EE1u52Q9zo3ANN-SByQ3ax1TJH4Yr7rmyJGMKU"
}
```


### `http://localhost:8081/customer/{id}`

- Получение пользователя по id

- Response:

```json
{
  "id": 1,
  "name": "name1",
  "surname": "surname1",
  "lastName": "lastName1",
  "username": "q",
  "email": "email1@gmail.com",
  "phone": "79998887760"
}
```

### `http://localhost:8081/customer`

- Добавление пользователя

- Body:

```json
{
  "name": "Vyacheslav",
  "surname": "Seleznev",
  "lastName": "Seleznev",
  "email": "testMail@gmail.com",
  "phone": "76668885544",
  "username": "vya4eslava",
  "password": "secret",
  "birthDate": "1966-05-17"
}
```

### `http://localhost:8081/customer/update`

- Обновление пользователя

- Body:

```json
{
  "id": 1,
  "contactId": 1,
  "credentialId": 1,
  "name": "updated",
  "surname": "updated",
  "lastName": "updated",
  "email": "updated@gmail.com",
  "phone": "79990000001",
  "birthDate": "2023-05-17T09:22:02.614Z"
}
```

### `http://localhost:8081/customer/all`

- Просмотр всех пользователей

- Response:

```json
[
  {
    "id": 2,
    "name": "name2",
    "surname": "surname2",
    "lastName": "lastName2",
    "username": "qw",
    "email": "email2@gmail.com",
    "phone": "79998887761"
  },
  {
    "id": 3,
    "name": "name3",
    "surname": "surname3",
    "lastName": "lastName3",
    "username": "qwe",
    "email": "email3@gmail.com",
    "phone": "79998887762"
  },
  {
    "id": 4,
    "name": "name4",
    "surname": "surname4",
    "lastName": "lastName4",
    "username": "qwer",
    "email": "email4@gmail.com",
    "phone": "79998887763"
  },
  {
    "id": 5,
    "name": "name5",
    "surname": "surname5",
    "lastName": "lastName5",
    "username": "qwert",
    "email": "email5@gmail.com",
    "phone": "79998887764"
  },
  {
    "id": 6,
    "name": "Vyacheslav",
    "surname": "Seleznev",
    "lastName": "Seleznev",
    "username": "vya4eslava",
    "email": "testMail@gmail.com",
    "phone": "76668885544"
  },
  {
    "id": 1,
    "name": "updated",
    "surname": "updated",
    "lastName": "updated",
    "username": "q",
    "email": "updated@gmail.com",
    "phone": "79990000001"
  }
]
```

### `http://localhost:8081/contact`

- Просмотр всех контакнтых данных пользователя

- Response:

```json
[
  {
    "id": 2,
    "email": "email2@gmail.com",
    "phone": "79998887761"
  },
  {
    "id": 3,
    "email": "email3@gmail.com",
    "phone": "79998887762"
  },
  {
    "id": 4,
    "email": "email4@gmail.com",
    "phone": "79998887763"
  },
  {
    "id": 5,
    "email": "email5@gmail.com",
    "phone": "79998887764"
  },
  {
    "id": 6,
    "email": "testMail@gmail.com",
    "phone": "76668885544"
  },
  {
    "id": 1,
    "email": "updated@gmail.com",
    "phone": "79990000001"
  }
]
```

### `http://localhost:8081/contact/{id}`

- Просмотр  контакнтых данных пользователя по id

- Response:

```json
{
  "id": 1,
  "email": "updated@gmail.com",
  "phone": "79990000001"
}
```

### `http://localhost:8081/customer/{id}`

- Удаление пользователя по id. Удаляются все его записи в таблицах `credential` и `contact`

### Swagger

- для запуска Swagger необходимо воспользоваться url:

```
http://localhost:8081/swagger-ui/index.html#/
```

# Как запустить?

- Предварительно мной был создан образы приложения и добавлен на [DockerHub](https://hub.docker.com/u/vya4eslava):

- Для запуска Вам необходимо клонировать на свой компьютер репозиторий. Либо скачать .zip архив с проектом. После этого
выполнить команду:

```shell script
docker compose up -d
```
