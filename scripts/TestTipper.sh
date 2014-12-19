#!/bin/sh

for i in `ls lib/*.jar`
do
	CLASSPATH=$CLASSPATH:$i
done

java net.sourceforge.jFuzzyLogic.test.TestTipper

