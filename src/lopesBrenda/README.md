Plan de codigo:

Para poder reorganizar, quitar y agregrar elementos en el codigo planteado en programación 2:

Cambiar la clase Hamburguesa para que los extras no sean un Array (fijo) si no que un ArrayList<> de extras para que asi exista una gestión mas dinamica y sea posible modificarlos de acuerdo con lo que se necesita. 

Quitar el parametro numeroExtras en el constructor de hamburguesa ya que no es necesario. 

Implementar los métodos CRUD: 
3 métodos que permitirían, reorganizar, quitar y agregar extras de una posición específica de la lista (especificado con su index).

reorganizarExtra() 
eliminarExtra() /
agregarExtraIntermedio()

encontrarExtra()-> Metodo que permitiría encontrar el index del extra en la lista basado en su nombre

Los metodos mostrar y describir también serían modificados, ya que antes hacian un recorrido de extras en el for utilizando un contador "extrasAgregados". Ahora con el arraylist de extras no hace falta un contador para leer la lista.
