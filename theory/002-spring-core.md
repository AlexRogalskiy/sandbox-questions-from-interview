Для чего нужен DI?
Как устроен Spring контекст и что за аннотацией Autowired?
Вызов не через прокси в одном бине и как пофиксить
бин фэктори или бин пост процессор что раньше?
есть такая штука как статик бин , зачем это и какие сценарии (например коннекшен пул, или заменить проперти с секъюрити на реальные), он будет раньше всех проинициализирован
Вопрос про то когда cglib и dynamicproxy и отличается поведение ли?

рефакторинг автор сервиса:
там был рест контроллер, можно было бы отрефакторить стрим и вынести маппер в переменную в качестве бина и заюзать toList
также реквест параметр query был как просто строкой и шел в базу данных без какой-либо валидации (можно валидировать через реджекс можно расплитить на параметры)
не было у ентити id, и у другого id стояло на стринге хотя по сути для объекта статистики можно было бы просто заюзать id long как primary key
использовался sout вместо slf4j
не инжектился а просто через new создавался alert service
инъекция используется через поле а не через конструктор
вместо component service
Знает ли спринг про созданные объекты с скоупом Prototype?
алерты в другой сервис и не под транзакцией (а то для базы будет отрыта транзакция а мы не пойдем в базу, и что если упадет то откатиться транзакция)
точно также статистика в другой сервис уже под новой транзакцией и рассказать про проблему вызова из одного бина
В чем отличие разных инъекций?
Что такое спринг АОП и каким образом он реализуется?
Какие есть скоупы бинов в spring?








