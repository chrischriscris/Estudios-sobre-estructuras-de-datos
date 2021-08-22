KC=	kotlinc
KFLAG=	-cp

all:	\
	PriorityQueue.class \
	MainKt.class

PriorityQueue.class: PriorityQueue.kt
	$(KC) PriorityQueue.kt

MainKt.class: Main.kt
	$(KC) $(KFLAG) . Main.kt

clean:
	rm -rf *.class META-INF