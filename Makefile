JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
				$(JC) $(JFLAGS) $*.java

CLASSES = \
				Group.java \
        Match.java \
        Team.java \
				Tourney.java \
				Sort.java \
				Simulator.java \
				Predictor.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
				$(RM) *.class
