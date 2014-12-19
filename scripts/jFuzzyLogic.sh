#!/bin/sh

for i in `ls lib/*.jar`
do
	export CLASSPATH=$CLASSPATH:$i
done

export CLASSPATH=$CLASSPATH:./bin

java net.sourceforge.jFuzzyLogic.JFuzzyLogic $*

