# TicketManagement
Sistema de Gestión de Tickets

Para realizar el deploy del sistema necesita:
-PostgreSQL 12
-Servidor Web JEE (Se deployó en Payara Server)

Pasos para realizar el despligue:
1 Se debe crear la base de datos, el nombre es indistinto, luego ejecutar sobre dicha base los archivos /META-INF/schema.sql para crear las tablas y /META-INF/data.sql
  para popular las tablas, esto es necesario ya que el sistema tiene un control de acceso con usuarios que están previamente registrados.
2 En el servidor Web, crear un JNDI con el nombre jdbc/ticket el cual debe conectarse a la base de datos.
3 Abrir el proyecto en netbeans o eclipse y realizar el despliegue. También se puede desplegar directamente el archivo WAR que se encuentra en la carpeta TARGET.

Descripción
El sistema permite CREAR, ESCALAR, ATENDER Y CERRAR Tickets de soporte.
Los usuarios poseen dos roles: 
-Usuarios: pueden crear tickets y comentar en ellos.
-Agentes: pueden Escalar, Atender/Comentar y Cerrar los Tickets asignados a ellos.


