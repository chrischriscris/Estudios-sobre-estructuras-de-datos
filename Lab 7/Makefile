KC=	kotlinc
KFLAG=	-cp

all:	\
	ColaArreglo.class PilaArreglo.class \
	Nodo.class ListaCircular.class \
	ColaLista.class PilaLista.class \
	MainKt.class

ColaArreglo.class PilaArreglo.class: ColaArreglo.kt PilaArreglo.kt
	$(KC) ColaArreglo.kt PilaArreglo.kt

Nodo.class ListaCircular.class: Nodo.kt ListaCircular.kt
	$(KC) Nodo.kt ListaCircular.kt

ColaLista.class PilaLista.class: ColaLista.kt PilaLista.kt
	$(KC) $(KFLAG) . ColaLista.kt PilaLista.kt

MainKt.class: Main.kt
	$(KC) $(KFLAG) . Main.kt

clean:
	rm -rf *.class META-INF