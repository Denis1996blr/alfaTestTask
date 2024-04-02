Есть возможность сделать параллельные запуски на гриде. для этого:
- скачать селениум грид  - https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.13.0/selenium-server-4.13.0.jar
- положить в папку src/test/resources/grid
- проапдейтить node1.toml,node2.toml (deviceName,platformVersion, урл до аппиум сервера). Полагается, что есть 2 эмулятора на машине :)
- запустить: appium, run_hub.bat, run_node1.bat, run_node2.bat
- в app.properties изменить host на http://localhost:4444/
- в junit-platform.properties изменить junit.jupiter.execution.parallel.enabled=true

запуск тестов:
- запуск конкретного теста mvn test -Dtest=LoginTests#successLoginTest, запуск всех тестов mvn test 
- либо из IDE выбрав конкретный класс/метод
  
генерация отчета:
allure serve .\target\allure-results\ -  если тест падает, будет приаттачен скрин аплика на упавшем месте
