KC=	kotlinc
KFLAG=	-cp

all:	\
	AlreadyExistingKeyException.class \
	Diccionario.class \
	HashEntry.class \
	DList.class \
	HashTable.class \
	CuckooEntry.class \
	CuckooTable.class \
	MainKt.class

HashEntry.class: HashEntry.kt
	$(KC) HashEntry.kt

CuckooEntry.class: CuckooEntry.kt
	$(KC) CuckooEntry.kt

DList.class: DList.kt
	$(KC) $(KFLAG) . DList.kt

Diccionario.class: Diccionario.kt
	$(KC) Diccionario.kt

HashTable.class: HashTable.kt
	$(KC) $(KFLAG) . HashTable.kt

CuckooTable.class: CuckooTable.kt
	$(KC) $(KFLAG) . CuckooTable.kt

AlreadyExistingKeyException.class: AlreadyExistingKeyException.kt
	$(KC) AlreadyExistingKeyException.kt

MainKt.class: Main.kt
	$(KC) $(KFLAG) . Main.kt

clean:
	rm -rf *.class META-INF