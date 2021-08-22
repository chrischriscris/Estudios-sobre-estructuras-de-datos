import java.lang.StringBuilder
import kotlin.system.exitProcess

/**
 * Implementación del TAD Cola que usa un arreglo para almacenar
 * los datos (números enteros).
 * 
 * @param n: Entero positivo, valor de MAX.
 */
class ColaArreglo(n: Int) {

    val MAX = if (n <= 0) {
        println("Error: No se puede crear una pila de $n elementos, el tamaño debe ser positivo.")
        exitProcess(1) 
    } else {
        n
    }
    val c = Array<Int>(MAX, { 0 } )
    var cabeza: Int
    var cola: Int
    var nElems: Int

    init {
        cabeza = 0
        cola = 0
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

        c[cola] = e
        cola = if (cola + 1 == MAX) 0 else cola + 1
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

        cabeza = if (cabeza + 1 == MAX) 0 else cabeza + 1
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
        
        return c[cabeza]
    }

    /** Retorna true si la cola no tiene elementos, false de otra forma. */
    fun estaVacia(): Boolean = nElems == 0

    /**
     * Retorna un string con la representación del TAD Cola implementado
     * con un arreglo, donde los elementos están encerrados entre "< >",
     * y los encolados más recientemente aparecen al final.
     */
    override fun toString(): String {
        val strRep = StringBuilder("<")

        var i = cabeza

        repeat(nElems) {
            val sig = if (i + 1 == MAX) 0 else i + 1
            strRep.append(if (sig == cola) "${c[i]}" else "${c[i]}, ")
            i = sig
        }

        strRep.append(">")

        return strRep.toString()
    }
}