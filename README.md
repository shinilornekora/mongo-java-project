# mongo-java-project
Данный проект является демонстрационным примером использования NoSQL базы данных (MongoDB) совместно с Java (Spring).
Одним из важных для понимания принципов такой синергиии является каскадное удаление объектов. 

## Более теоретическое объяснение
Используя SQL, мы привыкли, что этого легко можно добиться через связи. 
Поскольку отношений в нереляционной базе данных быть по определение не может, был использован принцип вложенных документов.
При таком подходе зависимые сущности по факту являются полем родителя. Удаление родителя приводит к удалению всех с ним связанных
сущностей, по той простой причине, что они находятся внутри него.

## Более практическое объяснение
Мы создали каскадную структуру с вложенными сущностями, так как у нас повсюду присутствуют отношения один ко многим. 
Сначала мы создаем сущность, в которой отсутствует внешний ключ (в нашем случае это разработчик), но не сохраняем ее 
в базе данных как документ. Затем мы создаем связанную с ней сущность (задача), которую мы так же не сохраняем в базу 
напрямую, в ней как раз будет храниться список ранее созданных сущностей. То же самое мы повторяем каскадно для сущности 
проекта и уже её, как главную сущность, сохраняем в базу. Таким образом, у нас получается коллекция документов сущности 
проект, в которую вложен набор сущностей задач, в котором, в свою очередь, вложен набор сущностей разработчиков.
