import kotlin.system.measureTimeMillis
import kotlin.system.exitProcess

/**
 * Recorre el arreglo de pares (clave, valor) dado y busca cada
 * elemento en la tabla de hash. Si el elemento existe, se elimina
 * de esta; de lo contrario, se agrega.
 * 
 * Entrada: Una instancia sin elementos de una implementación de
 *          la interfaz Diccionario.
 *          Un arreglo de pares (clave, valor) con claves enteras
 *          y su String de valor asociado.
 *
 * Salida: Un par con:
 *          -Un Long con el tiempo en milisegundos que se tardó
 *           en ejecutar la ejecutar prueba descrita.
 *          -Un entero con la cantidad de elementos final del
 *           diccionario.
 */
fun testDictionary(
    dict: Diccionario,
    elementos: Array<Pair<Int, String>>
    ): Pair<Long, Int> {

    val time = measureTimeMillis {
        for ((clave, valor) in elementos) {
            if (dict.existe(clave)) dict.eliminar(clave)
            else dict.agregar(clave, valor)
        }
    }
    
    return Pair(time, dict.numElementos())
}

/**
 * Programa cliente que hace pruebas sobre el rendimiento
 * de las clases implementadas: HashTable y CuckooTable.
 * 
 * Las pruebas se ejecutan con un arreglo del tamaño 
 * especificado por el usuario a través de la linea de 
 * comandos.
 */
fun main(args: Array<String>) {

    val n = try {
        args[0].toInt()
    }
    catch (e: NumberFormatException) {
        println("Error: El número dado debe ser un entero positivo.")
        exitProcess(1)
    }

    if (n <= 0) {
        println("Error: El número dado debe ser un entero positivo.")
        exitProcess(1)
    }

    val b = 2 * n / 3 
    // Se genera un arreglo de n enteros en el intervalo [0..2n/3]
    val claves = Array<Int>(n, { (0..b).random() })

    /* Se obtiene el arreglo de pares (clave, valor), donde
    el valor asociado a cada clave es resultado de convertir
    cada clave correspondiente a una string. */
    val pares = Array<Pair<Int, String>>(n,{ Pair(claves[it], claves[it].toString()) })

    val sep = "==========================================================="

    println("$sep\nEjecutando pruebas de implementaciones del TAD Diccionario:")

    println(" Cantidad de claves: $n")
    println(" Intervalo: [0..$b] \n")

    val (hashMs, hashElem) = testDictionary(HashTable(), pares)
    println("Hash Table:   $hashMs ms.")

    val (cuckooMs, cuckooElem) = testDictionary(CuckooTable(), pares)
    println("Cuckoo Table: $cuckooMs ms.\n")

    if (hashElem != cuckooElem) {
        print("Ha habido un error en las pruebas. Los diccionarios resultantes")
        println(" tienen cantidades distintas de elementos.")
        exitProcess(1)
    }
    
    println("Cantidad final de elementos en cada diccionario: $hashElem. \n$sep")

}