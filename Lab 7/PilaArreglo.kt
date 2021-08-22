import java.lang.StringBuilder
import kotlin.system.exitProcess

/**
 * Implementación del TAD Pila que usa un arreglo para almacenar
 * los datos (números enteros).
 * 
 * @param n: Entero positivo, número máximo de elementos permitidos
 *          en la cola.
 */
class PilaArreglo(n: Int) {

    val MAX = if (n <= 0) {
        println("Error: No se puede crear una pila de $n elementos, el tamaño debe ser positivo.")
        exitProcess(1) 
    } else {
        n
    }
    val p = Array<Int>(MAX, { 0 } )
    var topeInd: Int

    /* Se prescinde de un atributo con el número
    de elementos porque siempre se podrá obtener
    con topeInd + 1 */ 
    init {
        topeInd = -1
    }

    /**
     * Inserta un entero [e] al final de la pila.
     *
     * El número de elementos actual en la pila no debe sobrepasar
     * al máximo [MAX] establecido.
     */
    fun empilar(e: Int) {
        if (topeInd + 1 >= MAX) {
            println("Error: Overflow de pila")
            exitProcess(1)
        }

        p[++topeInd] = e
    }

    /**
     * Elimina de la pila al elemento insertado más recientemente.
     *
     * La pila no debe estar vacía.
     */
    fun desempilar() {
        if (estaVacia()) {
            println("Error: Underflow de pila")
            exitProcess(1)
        }
            
        topeInd--
    }

    /**
     * Retorna el elemento que está en el tope de la pila.
     *
     * La pila no debe estar vacía.
     */
    fun tope(): Int {
        if (estaVacia()) {
            println("Error al obtener primer elemento: Pila vacía")
            exitProcess(1)
        }

        return p[topeInd] 
    }

    /** Retorna true si la pila no tiene elementos, false de otra forma. */
    fun estaVacia(): Boolean = topeInd + 1 == 0

    /**
     * Retorna un string con la representación del TAD Pila implementado
     * con un arreglo, donde los elementos están encerrados entre "< >",
     * y los empilados más recientemente aparecen al final.
     */
    override fun toString(): String {
        val strRep = StringBuilder("<")

        for (i in 0..topeInd) {
            strRep.append(if (i == topeInd) "${p[i]}" else "${p[i]}, ")
        }

        strRep.append(">")

        return strRep.toString()
    }
}