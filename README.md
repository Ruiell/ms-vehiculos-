# ms-vehiculos

microservicio de gestión de vehiculos sirviendo como fundamento para el pipeline de despliegue concebido en la Evaluación Parcial 1 de Ingeniería DevOps.

## estrategia de ramificacion: GitFlow

elegimos GitFlow porque nos permite separar bien el desarrollo de nuevas funciones (feature/) y el arreglo de errores urgentes (hotfix/) asi mantenemos la rama main siempre estable para produccion y develop para integrar el codigo asegurando que ningun cambio sin probar se suba directamente a produccion

### conformacion de ramas

main: el codigo estable preparado para su puesta en produccion
develop: aqui el ramal de integración donde convergen las funcionalidades antes de su ascenso a main
feature/: aqui para las nuevas funcionalidades estas emergen desde develop y se reincorpora a develop a traves de una solicitud de extraccion la cual seria (pull request)
hotfix/: aqui destinamos a las correcciones criticas y apresuradas surgen de main y se integran simultaneamente tanto en main como en develop

## convenciones de commits
se aplica el prefijo indicativo del tipo de alteracion al comienzo del mensaje
feat: aqui implementamos una nueva caracteristica
fix: aqui solucionamos los problemas existentes
docs: aqui modificamos la documentacion
refactor: aqui transforma el codigo sin alterar la funcionalidad o corregir errores

## convenciones de nomenclatura de ramas

feature/descripcion-clara (por ejemplo el feature/incluir-punto-acceso-vehiculo)
hotfix/descripcion-clara (por ejemplo el hotfix/reparar-validaciones)

## proceso de integracion

1)bueno aqui se origina la rama pertinente a (feature/ partiendo de develop, hotfix/ partiendo de main)
2)aqui ejecutamos las modificaciones y las confirmaciones en dicha rama
3)aqui cagamos la rama al repositorio compartido con (git push)
4)aqui lo que hacemos es iniciar la cual consiste en una solicitud de extraccion dirigada a la rama principal indicada (develop para funcionalidades main para correcciones urgentes)
5)aqui el pr se examina y procede a su fusion
6)cuando se trata de una correccion urgente la modificacion tambien se integra a develop

## metodologia de validacion
cada peticion de extraccion precisara contextualizar de manera breve la mutacion realizada
antes de aprobarse la integracion verificamos que no halla disparidades con el ramal de origen y que la alteracion corresponda a lo expuesto en el encabezado del pr 
 se habilito un proceso automatico en github actions
 este proceso se dispara solito despues de cada push al ambiente  develop ademas de cada peticion de extraccion (pull request) que se dirige hacia la rama  main  su objetivo es asegurar detalladamente la perfecta compilación de este proyecto