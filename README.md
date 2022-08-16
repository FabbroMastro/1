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
...
# Arquitectura:
Se realiza la creacion de 4 servicios para el funcionamento del ejercicio, dos de estos son dos tablas declaradas en database H2 donde se gestiona la informacion de Targer y User. Nuestro servicio donde esta nuestra logica de negocio o sea el servicio de Prestamo recibe los datos de User y Target que se tomaran para validar unas logicas que garantizan el buen funcionamento del proyecto. Esta configuracion pero tambien otro servicio que nos ayuda a crear una istancias de los servicios y configularlos con otros posibles elementos como Circubreaker o LoadBalance, este servicio es Eureka server y en este caso nos va a gestionar la comunicacion entre las aplicaciones.
Se utiliza este Arquitectura porque es mas posible encontrarla en situaciones reales (muy dificilmente que un servicio tenga todos los datos en el mismo proyecto) y tambien porque estamos usando una estructura Octogonal donde al centro hay nuestra logica de negocio y al rededor esta User y Target que serian los adapter para el funcionamento del primero servicio.

# Endpoints:
# target:
- GET localhost:8001/listar
- GET localhost:8001/ver/1
- POST localhost:8001/actualizar_target se envia en el request body un objeto tipo Target ejemplo:


# user:
- GET localhost:8001/listar
- GET localhost:8001/ver/1

# prestamo:
- POST localhost:8001/solicitud-prestamo
- GET localhost:8001/lista-prestamos/from/15-08-2022/to/20-08-2022
- localhost:8001/pago-debito
- localhost:8001/deuda/fecha/20-08-2022
- localhost:8001/deuda_total/fecha/20-08-2022/target/NEW


# Build the project:
Cada Proyecto es un proyecto Spring Boot y esta ya configurado para el build de las imagines Docker.(no pude crear y testiar un Doker.compose porque la ambientacion de Docker presenta problemas entonces tuve necesariamente hacerlo por linea de comando)

Vamos a ver como se contruye el servicio para (Pon el codigo de Build e Run en la consola para despleguar la imagen): 
# target:
- Build: "Docker build -t target:v1 ."
- Run: "docker run -p 8003:8003 --name target --network net-prestamo target:v1"

# user:
- Build: "Docker build -t user:v1 ."
- Run: "docker run -p 8002:8002 --name user --network net-prestamo user:v1"

# prestamo:
- Build: "Docker build -t prestamo:v1 ."
- Run: "docker run -p 8001:8001 --name prestamo --network net-prestamo prestamo:v1"

# eureka:
- Build: "Docker build -t prestamo:v1 ."
- Run: "docker run -p 8761:8761 --name eureka-server --network net-prestamo eureka-server:v1"


