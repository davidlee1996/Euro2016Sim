JFLAGS = -g
JC = javac
JVM = java
Python = python3
.SUFFIXES: .java .class .txt
.java.class:
				$(JC) $(JFLAGS) $*.java

CLASSES = \
				Group.java \
        Match.java \
        Team.java \
				Tourney.java \
				Sort.java \
				Simulator.java \
				ReadFile.java \
				FileData.java \
				Predictor.java

MAIN = Simulator
OWN = Predictor
READ = FileData
BASH = bash
TEXT = predict
A = a

default: classes

classes: $(CLASSES:.java=.class)

sim: $(MAIN).class
		$(JVM) $(MAIN)

ap: $(OWN).class
		$(JVM) $(OWN) $(A)

p: $(OWN).class
		$(JVM) $(OWN)

read: $(READ).class
		$(JVM) $(READ)

clean:
	$(RM) *.class
