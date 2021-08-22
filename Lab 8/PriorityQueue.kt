import kotlin.system.exitProcess
import kotlin.Double.Companion.NEGATIVE_INFINITY

/**
 * Implementación del TAD Cola de Prioridad mediante un Max-Heap,
 * donde los elementos con mayor valor tienen prioridad más alta.
 * 
 * @param initQueueParam: Arreglo de números enteros con el que se
 *                        inicializará la cola de prioridad.
 */
class PriorityQueue(initQueueParam: Array<Int>) {

    var A: Array<Int> = initQueueParam

    var heapSize = A.size
        get() = field
        set(value) {
            if (value < 0) {
                println("Error: heapSize no puede ser menor a 0")
                exitProcess(1)
            }
            
            /* Si se quiere establecer heapSize a un valor más
            grande que el tamaño del arreglo */
            if (value > A.size) {
                while (A.size != value) {
                    /* Se añaden -inf al final del arreglo hasta
                    que sea del tamaño establecido */
                    A += NEGATIVE_INFINITY.toInt()
                }
            }

            field = value
        }

    init {
        // Construye un Max-Heap con todos los elementos del arreglo inicial
        for (i in (A.size / 2 - 1) downTo 0) maxHeapify(A, i)
    }

    /** Intercambia los elementos en los índices [i] y [j] del arreglo [A]. */
    fun swap(A: Array<Int>, i: Int, j: Int) {
        val temp = A[i]
        A[i] = A[j]
        A[j] = temp
    }

    /** Retorna el índice del padre del elemento en el índice [i]. */
    fun parent(i: Int): Int = if (i % 2 == 0) i / 2 - 1 else i / 2

    /**
     * Restaura las propiedades de un Max-Heap en [A] enraizado en el índice
     * [i], asumiendo que los sub-árboles enraizados en los índices 2i+1
     * y 2i+2 satisfacen las propiedades de un Max-Heap.
     */
    fun maxHeapify(A: Array<Int>, i: Int) {
        var (l, r) = Pair(2 * i + 1, 2 * i + 2)
        var largest: Int

        largest = if (l < heapSize && A[l] > A[i]) l else i
        largest = if (r < heapSize && A[r] > A[largest]) r else largest

        if (largest != i) {
            swap(A, i, largest)
            maxHeapify(A, largest)
        }
    }

    /** Agrega un nuevo elemento con prioridad [x] a la cola. */
    fun insert(x: Int) {
        heapSize++
        A[heapSize - 1] = NEGATIVE_INFINITY.toInt()
        increaseKey(heapSize - 1, x) 
    }

    /**
     * Retorna el elemento con mayor prioridad de la cola.
     * La cola debe tener al menos un elemento.
     */
    fun maximumElem() : Int {
        if (heapSize < 1) {
            println("Error al obtener el primer elemento: Cola vacía")
            exitProcess(1)
        }

        return A[0]
    }

    /**
     * Retorna y desencola el elemento con mayor prioridad de la cola.
     * La cola debe tener al menos un elemento.
     */
    fun extractMax() : Int {
	    if (heapSize < 1) {
            println("Error: Underflow de cola")
            exitProcess(1)
        }

        val max = A[0]
        A[0] = A[--heapSize]
        maxHeapify(A, 0)

        return max
    }

    /**
     * Aumenta a [k] la clave del elemento en el índice [x] de la cola.
     * [k] debe ser mayor o igual a la prioridad actual del elemento.
     * [x] debe ser un índice válido de la cola.
     */
    fun increaseKey(x: Int, k: Int) {
        if (k < A[x]) {
            println("Error: Nueva clave ($k) es más pequeña que la anterior (${A[x]})")
            exitProcess(1)
        }

        if (x >= heapSize) {
            println("Error: El índice $x no es un índice válido de la cola")
            exitProcess(1)
        }

        var i = x
        A[i] = k

        while (i > 0 && A[parent(i)] < A[i]) {
            swap(A, i, parent(i))
            i = parent(i)
        }
    }

    /**
     * Retorna un string con la representación del TAD PriorityQueue,
     * en el orden en que se encuentran en el heap de la implementación.
     */
    override fun toString() : String = A.sliceArray(0 until heapSize).contentToString()

}