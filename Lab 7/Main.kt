import kotlin.system.measureTimeMillis

/** Imprime un separador por la salida estándar. */
fun separador() = println("-..-^`^-..--..-^`^-..--..-^`^-..--..-^`^-..--..-^`^-..-\n")

/**
 * Programa cliente que muestra el correcto funcionamiento de las
 * estructuras implementadas, y hace pruebas sobre sus rendimientos.
 */
fun main() {

    // ---- COLA ARREGLO ------

    val queue = ColaArreglo(5)
    println("""
    |ColaArreglo con capacidad para ${queue.MAX} elementos creada: $queue.
    |
    |$queue.estaVacia() = ${queue.estaVacia()}
    |
    """.trimMargin("|")) 

    println("Encolando 5 elementos, los números enteros en [-2..2]:")
    println("Cola: $queue")
    for (k in -2..2) {
        queue.encolar(k)
        println("Cola: $queue")
    }

    println("\nDesencolando los negativos:")
    println("Cola: $queue")
    repeat(2) { 
        queue.desencolar() 
        println("Cola: $queue")
    }

    println("\nEncolando nuevos números:")
    println("Cola: $queue")
    for (k in 3..4) {
        queue.encolar(k) 
        println("Cola: $queue")
    }

    println("\n$queue.primero() = ${queue.primero()}")
    println("$queue.estaVacia() = ${queue.estaVacia()}\n")
    separador()

    // ---- COLA LISTA ------

    val queueList = ColaLista(5)
    println("""
    |ColaLista con capacidad para ${queueList.MAX} elementos creada: $queueList.
    |
    |$queueList.estaVacia() = ${queueList.estaVacia()}
    |
    """.trimMargin("|")) 

    println("Encolando 5 elementos, los números enteros en [-2..2]:")
    println("Cola: $queueList")
    for (k in -2..2) {
        queueList.encolar(k)
        println("Cola: $queueList")
    }

    println("\nDesencolando los negativos:")
    println("Cola: $queueList")
    repeat(2) { 
        queueList.desencolar() 
        println("Cola: $queueList")
    }

    println("\nEncolando nuevos números:")
    println("Cola: $queueList")
    for (k in 3..4) {
        queueList.encolar(k) 
        println("Cola: $queueList")
    }

    println("\n$queueList.primero() = ${queueList.primero()}")
    println("$queueList.estaVacia() = ${queueList.estaVacia()}\n")
    separador()

    // ------- PILA ARREGLO -------

    val stack = PilaArreglo(5)
    println("""
    |PilaArreglo con capacidad para ${stack.MAX} elementos creada: $stack.
    |
    |$stack.estaVacia() = ${stack.estaVacia()}
    |
    """.trimMargin("|")) 

    println("\nEmpilando 5 elementos, los números enteros en [-2..2]:")
    println("Pila: $stack")
    for (k in -2..2) {
        stack.empilar(k)
        println("Pila: $stack")
    }

    println("\nDesempilando los positivos:")
    println("Pila: $stack")
    repeat(2) {
        stack.desempilar()
        println("Pila: $stack")
    }

    println("\nEmpilándolos en orden inverso:")
    println("Pila: $stack")
    for (k in 2 downTo 1){
        stack.empilar(k)
        println("Pila: $stack")
    }

    println("$stack.tope() = ${stack.tope()}")
    println("$stack.estaVacia() = ${stack.estaVacia()}\n")
    separador()

    // ------- PILA LISTA -------

    val stackList = PilaLista(5)
    println("""
    |PilaLista con capacidad para ${stackList.MAX} elementos creada: $stackList.
    |
    |$stackList.estaVacia() = ${stackList.estaVacia()}
    |
    """.trimMargin("|")) 

    println("\nEmpilando 5 elementos, los números enteros en [-2..2]:")
    println("Pila: $stackList")
    for (k in -2..2) {
        stackList.empilar(k)
        println("Pila: $stackList")
    }

    println("\nDesempilando los positivos:")
    println("Pila: $stackList")
    repeat(2) {
        stackList.desempilar()
        println("Pila: $stackList")
    }

    println("\nEmpilándolos en orden inverso:")
    println("Pila: $stackList")
    for (k in 2 downTo 1){
        stackList.empilar(k)
        println("Pila: $stackList")
    }

    println("$stackList.tope() = ${stackList.tope()}")
    println("$stackList.estaVacia() = ${stackList.estaVacia()}\n")
    separador()

    // ------- BENCHMARKING ---------

    print("Se hará una prueba llenando cada una de las estructuras con 100k elementos ")
    print("y luego vaciándolas mientras se llaman los métodos de primero() o tope() ")
    println("(según el TAD) y estaVacia().\n")

    println("Los resultados de repetir el procedimiento descrito 50 veces son los siguientes:\n")
    val qArrayMs = measureTimeMillis {
    	repeat(50) {
	    	val q = ColaArreglo(100000)
	    	for (k in 0 until 100000) q.encolar(k)
	    	repeat(100000) { 
                q.primero()
                q.desencolar()
                q.estaVacia()
            }
	    }
    }

    val qListMs = measureTimeMillis {
    	repeat(50) {
	    	val q = ColaLista(100000)
	    	for (k in 0 until 100000) q.encolar(k)
	    	repeat(100000) { 
                q.primero()
                q.desencolar()
                q.estaVacia()
            }
	    }
    }

    println("""
    	|Cola arreglo: $qArrayMs ms 
    	|Cola lista:   $qListMs ms 
    	""".trimMargin("|"))

    val sArrayMs = measureTimeMillis {
    	repeat(50) {
	    	val s = PilaArreglo(100000)
	    	for (k in 0 until 100000) s.empilar(k)
	    	repeat(100000) {
                s.tope()
                s.desempilar()
                s.estaVacia()
            }
	    }
    }

    val sListMs = measureTimeMillis {
    	repeat(50) {
	    	val s = PilaLista(100000)
	    	for (k in 0 until 100000) s.empilar(k)
	    	repeat(100000) {
                s.tope()
                s.desempilar()
                s.estaVacia()
            }
	    }
    }

    println("""
    	|Pila arreglo: $sArrayMs ms 
    	|Pila lista:   $sListMs ms 
    	""".trimMargin("|"))
}