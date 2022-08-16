# Meli-Prestamo-Service
# Ejercicio:
El propósito del challenge es testear tus habilidades para implementar una RESTFull API.
En este escenario simplificado, la unidad de negocios Mercado Crédito quiere emitir
fácilmente nuevos préstamos a los usuarios y averiguar cuál es el valor y el volumen de la
deuda pendiente.
Cabe mencionar que existen 3 targets diferentes de usuarios, dependiendo de la cantidad
de préstamos tomados y el monto de los mismos en el último año. Además, cada target
tiene una tasa de interés propia y un tope máximo a solicitar por préstamo.
- NEW:
- 0 < cant < 2
- amount_total < 100000
- rate: 0.15
- max: 500000
- FREQUENT:
- 2 <= cant < 5
- 100000 < amount_total < 500000
- rate: 0.10
- max: 1000000
- PREMIUM:
- cant > 5
- amount_total > 500000
- rate: 0.05
- max: 5000000
- 
# Arquitectura:
Se realiza la creacion de 4 servicios para el funcionamento del ejercicio, dos de estos son dos tablas en el database H2 donde se gestiona la informacion de Targer y User. Nuestro servicio donde esta nuestra logica de negocio o sea el servicio de Prestamo recibe los datos de User y Target que usera para validar unas logicas que garantizan el buen funcionamento del proyecto. Esta configuracion pero tambien otro servicio que nos ayude a crear istancias de los servicios y configularlos con otros posibles elementos como Circubreaker o LoadBalance, este servicio es Eureka server y en este caso nos va a gestionar la comunicacion entre las aplicaciones.
Se utiliza este Arquitectura porque es mas posible encontrarla en situaciones reales (muy dificilmente que un servicio tenga todos los datos en el mismo proyecto) y tambien porque estamos usando una estructura Octogonal donde al centro hay nuestra logica de negocio y al rededor esta User y Target que serian los adapter para el funcionamento del primero servicio.

# Endpoints:
# target:
# user:
# prestamo:
#Build the project:
Cada Proyecto es un proyecto Spring Boot y esta ya configurado para el build de las imagines Docker.
Vamos a ver como se contruye el servicio para: 
# target:
# user:
# prestamo:
