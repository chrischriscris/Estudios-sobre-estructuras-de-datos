import java.lang.StringBuilder
import kotlin.system.exitProcess

/**
 * Estructura de datos de lista circular doblemente
 * enlazada con centinela.
 */
class ListaCircular() {
    val centinela = Nodo(0)

    /**
    * Inserta un nodo con el número entero [key] al final
    * de la lista.
    */
    fun insertar(key: Int) {
        val x = Nodo(key)

        /* Rearregla los punteros de los nodos
        afectados por la inserción del nuevo */
        x.prev = centinela.prev 
        x.next = centinela
        centinela.prev.next = x
        centinela.prev = x
    }

    /**
    * Elimina el nodo [x] de la lista.
    *
    * El nodo debe ser distinto del centinela de la lista.
    */
    fun eliminar(x: Nodo){
        /* Rearregla los punteros que apuntaban
        al nodo a eliminar */
        if (x == centinela) {
            if (x.next == centinela) println("Error: Lista vacía, no se puede eliminar objeto")
            else println("Error: No se puede eliminar al centinela de la lista")
            exitProcess(1)
        } else {
            x.prev.next = x.next
            x.next.prev = x.prev
        }
        
    }

    /**
    * Elimina el primer nodo de la lista.
    *
    * La lista no debe estar vacía.
    */
    fun eliminarPrimero() {
        val x = centinela.next
        eliminar(x)
    }

    /**
    * Elimina el último nodo de la lista.
    *
    * La lista no debe estar vacía.
    */
    fun eliminarUltimo() {
        val x = centinela.prev
        eliminar(x)
    }

    /**
     * Retorna el entero almacenado como primero en la lista.
     * 
     * La lista no debe estar vacía.
     */
    fun primero(): Int {
        val x = centinela.next

        if (x == centinela) {
            println("Error: Se intentó obtener el primer elemento de una lista vacía")
        }

        return x.key
    }

    /**
     * Retorna el entero almacenado como primero en la lista.
     * 
     * La lista no debe estar vacía.
     */
    fun ultimo(): Int {
        val x = centinela.prev

        if (x == centinela) {
            println("Error: Se intentó obtener el primer elemento de una lista vacía")
        }

        return x.key
    }

    /**
     * Retorna un string con la representación de la lista circular, donde
     * los elementos están encerrados entre "[ ]", y los insertados más
     * recientemente aparecen la final.
     */
    override fun toString(): String {
        val strRep = StringBuilder("[")

        var x = centinela.next
        while (x != centinela) {
            strRep.append("${x.key}")
            x = x.next
            if (x != centinela) strRep.append(", ") 
        }
        strRep.append("]")

        return strRep.toString()
    }
}