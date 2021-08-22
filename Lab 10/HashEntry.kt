/**
 * Estructura de datos que representa una entrada
 * de una tabla de hash con clave y valor asociado.
 * 
 * Sirve de nodo de una lista doblemente enlazada,
 * por lo que guarda apuntadores a los elementos
 * anterior y próximo, los cuales se inicializan 
 * como valores nulos.
 *
 * @param clave: Entero con la clave de la entrada.
 * @param valor: String con el valor asociado a la clave.
 */
class HashEntry(val clave: Int,val valor: String) {
    var ant: HashEntry? = null
    var prox: HashEntry? = null

    /**
     * Retorna un string con la representación de
     * la entrada de la tabla como un par (clave, valor).
     */
    override fun toString(): String = "($clave, $valor)"
}