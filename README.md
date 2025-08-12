Ключевые механизмы:
Цикл денег: Bank → Spender → Worker → Bank

Случайный выбор:

Spender случайно выбирает Worker

Worker/Spender случайно выбирают Bank

Синхронизация:

Банк обрабатывает одного клиента за раз

Worker работает только на одного Spender одновременно

🛠 Технологии
Java 8+

Многопоточность (Threads, wait/notify)

Шаблоны проектирования:

Abstract Factory (CityEntityFactory)

Singleton (HelpDesk)
🚀 Запуск проекта
Требования:
JDK 8+

Maven (для сборки)

1. Сборка:
bash
mvn clean package
2. Запуск:
bash
java -jar target/worker-spender.jar
Или напрямую:

bash
java -cp src/simulation/CitySimulation.java
