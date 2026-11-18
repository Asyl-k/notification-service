# Notification Service

> **Lab / not maintained.** Это ранний учебный проект: репозиторий заархивирован и оставлен для истории. Актуальные проекты — в [профиле](https://github.com/Asyl-k).
>
> **Lab / not maintained.** This is an early learning project. The repository is archived and kept for history; see [my profile](https://github.com/Asyl-k) for maintained projects.

Kafka consumer для доменных событий уведомлений. Сервис рассчитан на at-least-once доставку: `eventId` — ключ записи и защита от повторной обработки после redelivery.

## Возможности
- Consumer group и JSON-десериализация с ограниченным trusted package.
- Идемпотентный приём сообщений, состояние события хранится в SQL.
- REST read API для проверки состояния события.
- Kafka и база задаются конфигурацией окружения.

## Запуск/проверка
`mvn verify`. Для локального consumer требуется Kafka на `localhost:9092`; без брокера unit-тесты работают автономно.

Java 21 · Spring Boot · Spring Kafka · JPA · PostgreSQL/H2 · JUnit 5.
