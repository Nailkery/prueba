(Base de datos)Primero deben de cambiar la conf de la base de datos y poner la ruta de su base de datos, el usuario y la password
(mapeos) Cuando creen una clase de mapeo deben de especificarla aqui
Puse un ejemplo de relaciones 1:1, 1:n, n:n, donde biene como mapear ese tipo de relaciones
Viene tambien un de como poner los identificadores y el encabezado de los mapeos
Cuando acaben los mapeos pueden especificar los modelos, deben de definirlos aqui(modelos)
en (hibernate) viene un ejemplo de las clases de los modelos.
en (modelo_controlador) hay que poner los modelos que ya definiste como atributos usando @Autowired
y en (controlador) viene un ejemploe de las urls, normalmente se regresa un ModelAndView, done se pueden mandar objetos o variables a las vista
se usa model.add para agregar el nombre de la variable/objeto(como cadena) y depues la variable/objeto.
en ModelAndView se especifica el nombre del jsp que se regresa y el model con los datos adjuntos.
por ultimo en (vista) se usa el hay un ejemplo de como desplegar la info usando ${}