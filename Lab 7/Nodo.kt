/**
 * Estructura de datos de nodo con enlace doble,
 * que contiene un valor entero y enlaces al anterior
 * y siguiente, respectivamente.
 *	
 * Cada nodo se inicializa enlazado a sí mismo para
 * evitar problemas manejando valores nulos.
 *
 * @param key: Entero con el valor que guardará el nodo.
 */
class Nodo(val key: Int){
    /* Cada nodo se inicializa enlazado a sí mismo
    para evitar problemas manejando valores nulos */ 
    var next: Nodo = this
    var prev: Nodo = this
}