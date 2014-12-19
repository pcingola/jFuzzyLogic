#!/bin/sh

OUTDIR="./output"

rm -vf ../src/net/sourceforge/jFuzzyLogic/fcl/FCLLexer.java \
	../src/net/sourceforge/jFuzzyLogic/fcl/FCLLexerTokenTypes.java  \
	../src/net/sourceforge/jFuzzyLogic/fcl/FCLParser.java  \
	../src/net/sourceforge/jFuzzyLogic/fcl/FCLTreeParser.java 
rm -rvf $OUTDIR

ANTLRJAR=`ls $PWD/../lib/antlr*.jar`
java -cp $ANTLRJAR org.antlr.Tool -o $OUTDIR Fcl.g 

echo "Copying files"
cp $OUTDIR/FclLexer.java $OUTDIR/FclParser.java $OUTDIR/Fcl.tokens ../src/net/sourceforge/jFuzzyLogic/fcl


