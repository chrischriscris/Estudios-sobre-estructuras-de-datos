import kotlin.system.exitProcess

/**
 * Implementación del TAD Cola que usa una lista circular
 * doblemente enlazada con centinela para almacenar los datos
 * (números enteros).
 * 
 * @param n: Entero positivo, número máximo de elementos permitidos
 *          en la cola.
 */
class ColaLista(n: Int) {

    val MAX = if (n <= 0) {
        println("Error: No se puede crear una pila de $n elementos, el tamaño debe ser positivo.")
        exitProcess(1) 
    } else {
        n
    }
    val c = ListaCircular()
    var nElems: Int

    init {
        nElems = 0
    }

    /**
     * Inserta un entero [e] al final de la cola.
     *
     * El número de elementos actual en la cola no debe sobrepasar
     * al máximo [MAX] establecido.
     */
    fun encolar(e: Int) {
        if (nElems >= MAX) {
            println("Error: Overflow de cola")
            exitProcess(1)
        }

        c.insertar(e)
        nElems++
    }

    /**
     * Elimina de la cola al elemento con más antiguedad en la misma.
     *
     * La cola no debe estar vacía.
     */
    fun desencolar() {
        if (estaVacia()) {
            println("Error: Underflow de cola")
            exitProcess(1)
        }

        c.eliminarPrimero()
        nElems--
    }

    /**
     * Retorna el elemento que está en la cabeza de la cola.
     *
     * La cola no debe estar vacía.
     */
    fun primero(): Int {
        if (estaVacia()) {
            println("Error al obtener primer elemento: Cola vacía")
            exitProcess(1)
        }
        
        return c.primero()
    }

    /** Retorna true si la cola no tiene elementos, false de otra forma. */
    fun estaVacia(): Boolean = nElems == 0

    /**
     * Retorna un string con la representación del TAD Cola implementado
     * con una lista circular, donde los elementos están encerrados entre
     * "[ ]", y los encolados más recientemente aparecen al final.
     */
    override fun toString(): String = c.toString()
}