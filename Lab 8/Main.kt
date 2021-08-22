/**
 * Programa cliente que muestra el correcto funcionamiento de la
 * estructura Cola de Prioridad implementada mediante la clase
 * PriorityQueue.
 */
fun main() {

    // Se construye un arreglo de enteros de 10 elementos
    print("Arreglo para inicializar la cola de prioridad: ")
    val paramArray = Array<Int>(10, { (5 * (it + 1) + 3) % 17 } )
    println(paramArray.contentToString())

    // Se inicializa la cola de prioridad con el arreglo:
    val pQueue = PriorityQueue(paramArray)
    println("Cola de prioridad creada: pQueue = $pQueue\n")

    // Se extraen 4 elementos de la cola
    println("Extrayendo los 4 elementos con mayor prioridad:")
    repeat(4) { println("$pQueue.extractMax() -> ${pQueue.extractMax()} extraído") }

    // Se aumenta la clave del elemento en el índice 2
    println("\nAumentando la prioridad de pQueue[2] a 100:")
    print("$pQueue.increaseKey(2, 100) -> ")
    pQueue.increaseKey(2, 100)
    println("$pQueue\n")
    
    // Se obtiene el máximo de la cola:
    println("El máximo actual de la cola es: ${pQueue.maximumElem()}\n")

    print("Añadiendo 10 elementos a la cola: <")
    repeat(10) { 
        i ->
        val add = i * i
        print(if (i != 9) "$add, " else "$add")
        pQueue.insert(add) 
    }
    println(">\nCola resultante: $pQueue\n")

    // Se vacía la cola:
    println("Vaciando la cola: ")
    repeat(16) { println("$pQueue.extractMax() -> ${pQueue.extractMax()}") }

    println("\nCola vacía: $pQueue")
}