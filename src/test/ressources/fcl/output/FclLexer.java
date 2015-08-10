// $ANTLR 3.1 Fcl.g 2014-02-13 11:23:11

package net.sourceforge.jFuzzyLogic.fcl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class FclLexer extends Lexer {
    public static final int FUNCTION=34;
    public static final int SIGM=61;
    public static final int STAR=91;
    public static final int LN=43;
    public static final int LETTER=96;
    public static final int LM=42;
    public static final int LOG=44;
    public static final int EINSTEIN=26;
    public static final int COG=17;
    public static final int NOT=52;
    public static final int EOF=-1;
    public static final int COA=15;
    public static final int HAT=81;
    public static final int SIN=62;
    public static final int EXP=32;
    public static final int MM=50;
    public static final int COS=20;
    public static final int LEFT_PARENTHESIS=83;
    public static final int TAN=65;
    public static final int COMMENT=99;
    public static final int GAUSS2=36;
    public static final int NC=51;
    public static final int VAR_OUTPUT=72;
    public static final int END_RULEBLOCK=30;
    public static final int ACT=10;
    public static final int END_DEFUZZIFY=27;
    public static final int RULE=59;
    public static final int GBELL=37;
    public static final int NUMBER=93;
    public static final int SEMICOLON=89;
    public static final int DMIN=24;
    public static final int VALUE_REAL=6;
    public static final int ALPHANUM=97;
    public static final int TYPE_REAL=70;
    public static final int ABS=8;
    public static final int REAL=98;
    public static final int WS=74;
    public static final int NSUM=53;
    public static final int LEFT_CURLY=82;
    public static final int OR=54;
    public static final int LOWER=94;
    public static final int END_FUZZIFY=29;
    public static final int UPPER=95;
    public static final int TERM=66;
    public static final int COGF=19;
    public static final int PROBOR=55;
    public static final int RIGHT_CURLY=87;
    public static final int NIPMIN=48;
    public static final int POINT=4;
    public static final int RM=58;
    public static final int MAX=45;
    public static final int DOTS=80;
    public static final int COGS=18;
    public static final int ID=102;
    public static final int AND=11;
    public static final int SUM=64;
    public static final int VALUE_ID=7;
    public static final int DSIGM=25;
    public static final int IF=40;
    public static final int SLASH=90;
    public static final int THEN=67;
    public static final int RIGHT_PARENTHESIS=88;
    public static final int COMMA=78;
    public static final int IS=41;
    public static final int DMAX=23;
    public static final int TRAPE=68;
    public static final int BDIF=13;
    public static final int PROD=56;
    public static final int COSINE=16;
    public static final int PLUS=86;
    public static final int DIGIT=92;
    public static final int DOT=79;
    public static final int FUNCTION_BLOCK=38;
    public static final int WITH=73;
    public static final int END_VAR=31;
    public static final int ACCU=9;
    public static final int ASUM=12;
    public static final int PERCENT=85;
    public static final int SINGLETONS=63;
    public static final int NIPMAX=49;
    public static final int ASSIGN_OPERATOR=76;
    public static final int TRIAN=69;
    public static final int DEFAULT=21;
    public static final int HAMACHER=33;
    public static final int COMMENT_C=100;
    public static final int FCL=5;
    public static final int RANGE=57;
    public static final int MIN=47;
    public static final int MINUS=84;
    public static final int DEFUZZIFY=22;
    public static final int COLON=77;
    public static final int NEWLINE=75;
    public static final int COMMENT_SL=101;
    public static final int VAR_INPUT=71;
    public static final int BSUM=14;
    public static final int RULEBLOCK=60;
    public static final int END_FUNCTION_BLOCK=28;
    public static final int FUZZIFY=39;
    public static final int METHOD=46;
    public static final int GAUSS=35;

    // delegates
    // delegators

    public FclLexer() {;} 
    public FclLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public FclLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Fcl.g"; }

    // $ANTLR start "ABS"
    public final void mABS() throws RecognitionException {
        try {
            int _type = ABS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:34:5: ( ( 'a' | 'A' ) ( 'b' | 'B' ) ( 's' | 'S' ) )
            // Fcl.g:34:7: ( 'a' | 'A' ) ( 'b' | 'B' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ABS"

    // $ANTLR start "ACCU"
    public final void mACCU() throws RecognitionException {
        try {
            int _type = ACCU;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:35:6: ( ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'c' | 'C' ) ( 'u' | 'U' ) )
            // Fcl.g:35:8: ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'c' | 'C' ) ( 'u' | 'U' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ACCU"

    // $ANTLR start "ACT"
    public final void mACT() throws RecognitionException {
        try {
            int _type = ACT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:36:5: ( ( 'a' | 'A' ) ( 'c' | 'C' ) ( 't' | 'T' ) )
            // Fcl.g:36:7: ( 'a' | 'A' ) ( 'c' | 'C' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ACT"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:37:5: ( ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
            // Fcl.g:37:7: ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "ASUM"
    public final void mASUM() throws RecognitionException {
        try {
            int _type = ASUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:38:6: ( ( 'a' | 'A' ) ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' ) )
            // Fcl.g:38:8: ( 'a' | 'A' ) ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASUM"

    // $ANTLR start "BDIF"
    public final void mBDIF() throws RecognitionException {
        try {
            int _type = BDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:39:6: ( ( 'b' | 'B' ) ( 'd' | 'D' ) ( 'i' | 'I' ) ( 'f' | 'F' ) )
            // Fcl.g:39:8: ( 'b' | 'B' ) ( 'd' | 'D' ) ( 'i' | 'I' ) ( 'f' | 'F' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BDIF"

    // $ANTLR start "BSUM"
    public final void mBSUM() throws RecognitionException {
        try {
            int _type = BSUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:40:6: ( ( 'b' | 'B' ) ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' ) )
            // Fcl.g:40:8: ( 'b' | 'B' ) ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BSUM"

    // $ANTLR start "COA"
    public final void mCOA() throws RecognitionException {
        try {
            int _type = COA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:41:5: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'a' | 'A' ) )
            // Fcl.g:41:7: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'a' | 'A' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COA"

    // $ANTLR start "COSINE"
    public final void mCOSINE() throws RecognitionException {
        try {
            int _type = COSINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:42:8: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'e' | 'E' ) )
            // Fcl.g:42:10: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COSINE"

    // $ANTLR start "COG"
    public final void mCOG() throws RecognitionException {
        try {
            int _type = COG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:43:5: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'g' | 'G' ) )
            // Fcl.g:43:7: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COG"

    // $ANTLR start "COGS"
    public final void mCOGS() throws RecognitionException {
        try {
            int _type = COGS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:44:6: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'g' | 'G' ) ( 's' | 'S' ) )
            // Fcl.g:44:8: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'g' | 'G' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COGS"

    // $ANTLR start "COGF"
    public final void mCOGF() throws RecognitionException {
        try {
            int _type = COGF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:45:6: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'g' | 'G' ) ( 'f' | 'F' ) )
            // Fcl.g:45:8: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'g' | 'G' ) ( 'f' | 'F' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COGF"

    // $ANTLR start "COS"
    public final void mCOS() throws RecognitionException {
        try {
            int _type = COS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:46:5: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' ) )
            // Fcl.g:46:7: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COS"

    // $ANTLR start "DEFAULT"
    public final void mDEFAULT() throws RecognitionException {
        try {
            int _type = DEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:47:9: ( ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' ) )
            // Fcl.g:47:11: ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEFAULT"

    // $ANTLR start "DEFUZZIFY"
    public final void mDEFUZZIFY() throws RecognitionException {
        try {
            int _type = DEFUZZIFY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:48:11: ( ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'z' | 'Z' ) ( 'z' | 'Z' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'y' | 'Y' ) )
            // Fcl.g:48:13: ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'z' | 'Z' ) ( 'z' | 'Z' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEFUZZIFY"

    // $ANTLR start "DMAX"
    public final void mDMAX() throws RecognitionException {
        try {
            int _type = DMAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:49:6: ( ( 'd' | 'D' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' ) )
            // Fcl.g:49:8: ( 'd' | 'D' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DMAX"

    // $ANTLR start "DMIN"
    public final void mDMIN() throws RecognitionException {
        try {
            int _type = DMIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:50:6: ( ( 'd' | 'D' ) ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // Fcl.g:50:8: ( 'd' | 'D' ) ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DMIN"

    // $ANTLR start "DSIGM"
    public final void mDSIGM() throws RecognitionException {
        try {
            int _type = DSIGM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:51:7: ( ( 'd' | 'D' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'm' | 'M' ) )
            // Fcl.g:51:9: ( 'd' | 'D' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DSIGM"

    // $ANTLR start "EINSTEIN"
    public final void mEINSTEIN() throws RecognitionException {
        try {
            int _type = EINSTEIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:52:10: ( ( 'e' | 'E' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // Fcl.g:52:12: ( 'e' | 'E' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EINSTEIN"

    // $ANTLR start "END_DEFUZZIFY"
    public final void mEND_DEFUZZIFY() throws RecognitionException {
        try {
            int _type = END_DEFUZZIFY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:53:15: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'z' | 'Z' ) ( 'z' | 'Z' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'y' | 'Y' ) )
            // Fcl.g:53:17: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'z' | 'Z' ) ( 'z' | 'Z' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_DEFUZZIFY"

    // $ANTLR start "END_FUNCTION_BLOCK"
    public final void mEND_FUNCTION_BLOCK() throws RecognitionException {
        try {
            int _type = END_FUNCTION_BLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:54:20: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) '_' ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'k' | 'K' ) )
            // Fcl.g:54:22: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) '_' ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'k' | 'K' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_FUNCTION_BLOCK"

    // $ANTLR start "END_FUZZIFY"
    public final void mEND_FUZZIFY() throws RecognitionException {
        try {
            int _type = END_FUZZIFY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:55:13: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'z' | 'Z' ) ( 'z' | 'Z' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'y' | 'Y' ) )
            // Fcl.g:55:15: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'z' | 'Z' ) ( 'z' | 'Z' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_FUZZIFY"

    // $ANTLR start "END_RULEBLOCK"
    public final void mEND_RULEBLOCK() throws RecognitionException {
        try {
            int _type = END_RULEBLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:56:15: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'k' | 'K' ) )
            // Fcl.g:56:17: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'k' | 'K' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_RULEBLOCK"

    // $ANTLR start "END_VAR"
    public final void mEND_VAR() throws RecognitionException {
        try {
            int _type = END_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:57:9: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'r' | 'R' ) )
            // Fcl.g:57:11: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) '_' ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_VAR"

    // $ANTLR start "EXP"
    public final void mEXP() throws RecognitionException {
        try {
            int _type = EXP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:58:5: ( ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'p' | 'P' ) )
            // Fcl.g:58:7: ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'p' | 'P' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXP"

    // $ANTLR start "HAMACHER"
    public final void mHAMACHER() throws RecognitionException {
        try {
            int _type = HAMACHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:59:10: ( ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' ) )
            // Fcl.g:59:12: ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HAMACHER"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:60:10: ( ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) )
            // Fcl.g:60:12: ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "GAUSS"
    public final void mGAUSS() throws RecognitionException {
        try {
            int _type = GAUSS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:61:7: ( ( 'g' | 'G' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 's' | 'S' ) ( 's' | 'S' ) )
            // Fcl.g:61:9: ( 'g' | 'G' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 's' | 'S' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GAUSS"

    // $ANTLR start "GAUSS2"
    public final void mGAUSS2() throws RecognitionException {
        try {
            int _type = GAUSS2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:62:8: ( ( 'g' | 'G' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 's' | 'S' ) ( 's' | 'S' ) '2' )
            // Fcl.g:62:10: ( 'g' | 'G' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 's' | 'S' ) ( 's' | 'S' ) '2'
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('2'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GAUSS2"

    // $ANTLR start "GBELL"
    public final void mGBELL() throws RecognitionException {
        try {
            int _type = GBELL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:63:7: ( ( 'g' | 'G' ) ( 'b' | 'B' ) ( 'e' | 'E' ) ( 'l' | 'L' ) ( 'l' | 'L' ) )
            // Fcl.g:63:9: ( 'g' | 'G' ) ( 'b' | 'B' ) ( 'e' | 'E' ) ( 'l' | 'L' ) ( 'l' | 'L' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GBELL"

    // $ANTLR start "FUNCTION_BLOCK"
    public final void mFUNCTION_BLOCK() throws RecognitionException {
        try {
            int _type = FUNCTION_BLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:64:16: ( ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) '_' ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'k' | 'K' ) )
            // Fcl.g:64:18: ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) '_' ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'k' | 'K' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION_BLOCK"

    // $ANTLR start "FUZZIFY"
    public final void mFUZZIFY() throws RecognitionException {
        try {
            int _type = FUZZIFY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:65:9: ( ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'z' | 'Z' ) ( 'z' | 'Z' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'y' | 'Y' ) )
            // Fcl.g:65:11: ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'z' | 'Z' ) ( 'z' | 'Z' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUZZIFY"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:66:4: ( ( 'i' | 'I' ) ( 'f' | 'F' ) )
            // Fcl.g:66:6: ( 'i' | 'I' ) ( 'f' | 'F' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:67:4: ( ( 'i' | 'I' ) ( 's' | 'S' ) )
            // Fcl.g:67:6: ( 'i' | 'I' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "LM"
    public final void mLM() throws RecognitionException {
        try {
            int _type = LM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:68:4: ( ( 'l' | 'L' ) ( 'm' | 'M' ) )
            // Fcl.g:68:6: ( 'l' | 'L' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LM"

    // $ANTLR start "LN"
    public final void mLN() throws RecognitionException {
        try {
            int _type = LN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:69:4: ( ( 'l' | 'L' ) ( 'n' | 'N' ) )
            // Fcl.g:69:6: ( 'l' | 'L' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LN"

    // $ANTLR start "LOG"
    public final void mLOG() throws RecognitionException {
        try {
            int _type = LOG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:70:5: ( ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'g' | 'G' ) )
            // Fcl.g:70:7: ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOG"

    // $ANTLR start "MAX"
    public final void mMAX() throws RecognitionException {
        try {
            int _type = MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:71:5: ( ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' ) )
            // Fcl.g:71:7: ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAX"

    // $ANTLR start "METHOD"
    public final void mMETHOD() throws RecognitionException {
        try {
            int _type = METHOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:72:8: ( ( 'm' | 'M' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'o' | 'O' ) ( 'd' | 'D' ) )
            // Fcl.g:72:10: ( 'm' | 'M' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'o' | 'O' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "METHOD"

    // $ANTLR start "MIN"
    public final void mMIN() throws RecognitionException {
        try {
            int _type = MIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:73:5: ( ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // Fcl.g:73:7: ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MIN"

    // $ANTLR start "NIPMIN"
    public final void mNIPMIN() throws RecognitionException {
        try {
            int _type = NIPMIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:74:8: ( ( 'n' | 'N' ) ( 'i' | 'I' ) ( 'p' | 'P' ) ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // Fcl.g:74:10: ( 'n' | 'N' ) ( 'i' | 'I' ) ( 'p' | 'P' ) ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NIPMIN"

    // $ANTLR start "NIPMAX"
    public final void mNIPMAX() throws RecognitionException {
        try {
            int _type = NIPMAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:75:8: ( ( 'n' | 'N' ) ( 'i' | 'I' ) ( 'p' | 'P' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' ) )
            // Fcl.g:75:10: ( 'n' | 'N' ) ( 'i' | 'I' ) ( 'p' | 'P' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NIPMAX"

    // $ANTLR start "MM"
    public final void mMM() throws RecognitionException {
        try {
            int _type = MM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:76:4: ( ( 'm' | 'M' ) ( 'm' | 'M' ) )
            // Fcl.g:76:6: ( 'm' | 'M' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MM"

    // $ANTLR start "NC"
    public final void mNC() throws RecognitionException {
        try {
            int _type = NC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:77:4: ( ( 'n' | 'N' ) ( 'c' | 'C' ) )
            // Fcl.g:77:6: ( 'n' | 'N' ) ( 'c' | 'C' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NC"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:78:5: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 't' | 'T' ) )
            // Fcl.g:78:7: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "NSUM"
    public final void mNSUM() throws RecognitionException {
        try {
            int _type = NSUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:79:6: ( ( 'n' | 'N' ) ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' ) )
            // Fcl.g:79:8: ( 'n' | 'N' ) ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NSUM"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:80:4: ( ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // Fcl.g:80:6: ( 'o' | 'O' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "PROBOR"
    public final void mPROBOR() throws RecognitionException {
        try {
            int _type = PROBOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:81:8: ( ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'b' | 'B' ) ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // Fcl.g:81:10: ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'b' | 'B' ) ( 'o' | 'O' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROBOR"

    // $ANTLR start "PROD"
    public final void mPROD() throws RecognitionException {
        try {
            int _type = PROD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:82:6: ( ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'd' | 'D' ) )
            // Fcl.g:82:8: ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROD"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:83:7: ( ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'g' | 'G' ) ( 'e' | 'E' ) )
            // Fcl.g:83:9: ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'g' | 'G' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "RM"
    public final void mRM() throws RecognitionException {
        try {
            int _type = RM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:84:4: ( ( 'r' | 'R' ) ( 'm' | 'M' ) )
            // Fcl.g:84:6: ( 'r' | 'R' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RM"

    // $ANTLR start "RULE"
    public final void mRULE() throws RecognitionException {
        try {
            int _type = RULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:85:6: ( ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'e' | 'E' ) )
            // Fcl.g:85:8: ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE"

    // $ANTLR start "RULEBLOCK"
    public final void mRULEBLOCK() throws RecognitionException {
        try {
            int _type = RULEBLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:86:11: ( ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'k' | 'K' ) )
            // Fcl.g:86:13: ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'k' | 'K' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULEBLOCK"

    // $ANTLR start "SIGM"
    public final void mSIGM() throws RecognitionException {
        try {
            int _type = SIGM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:87:6: ( ( 's' | 'S' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'm' | 'M' ) )
            // Fcl.g:87:8: ( 's' | 'S' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIGM"

    // $ANTLR start "SIN"
    public final void mSIN() throws RecognitionException {
        try {
            int _type = SIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:88:5: ( ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // Fcl.g:88:7: ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIN"

    // $ANTLR start "SINGLETONS"
    public final void mSINGLETONS() throws RecognitionException {
        try {
            int _type = SINGLETONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:89:12: ( ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'g' | 'G' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) )
            // Fcl.g:89:14: ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'g' | 'G' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINGLETONS"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:90:5: ( ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' ) )
            // Fcl.g:90:7: ( 's' | 'S' ) ( 'u' | 'U' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUM"

    // $ANTLR start "TAN"
    public final void mTAN() throws RecognitionException {
        try {
            int _type = TAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:91:5: ( ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) )
            // Fcl.g:91:7: ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TAN"

    // $ANTLR start "TERM"
    public final void mTERM() throws RecognitionException {
        try {
            int _type = TERM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:92:6: ( ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'm' | 'M' ) )
            // Fcl.g:92:8: ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TERM"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:93:6: ( ( 't' | 'T' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'n' | 'N' ) )
            // Fcl.g:93:8: ( 't' | 'T' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "TRAPE"
    public final void mTRAPE() throws RecognitionException {
        try {
            int _type = TRAPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:94:7: ( ( 't' | 'T' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'p' | 'P' ) ( 'e' | 'E' ) )
            // Fcl.g:94:9: ( 't' | 'T' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'p' | 'P' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRAPE"

    // $ANTLR start "TRIAN"
    public final void mTRIAN() throws RecognitionException {
        try {
            int _type = TRIAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:95:7: ( ( 't' | 'T' ) ( 'r' | 'R' ) ( 'i' | 'I' ) ( 'a' | 'A' ) ( 'n' | 'N' ) )
            // Fcl.g:95:9: ( 't' | 'T' ) ( 'r' | 'R' ) ( 'i' | 'I' ) ( 'a' | 'A' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRIAN"

    // $ANTLR start "TYPE_REAL"
    public final void mTYPE_REAL() throws RecognitionException {
        try {
            int _type = TYPE_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:96:11: ( ( 'r' | 'R' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 'l' | 'L' ) )
            // Fcl.g:96:13: ( 'r' | 'R' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 'l' | 'L' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE_REAL"

    // $ANTLR start "VAR_INPUT"
    public final void mVAR_INPUT() throws RecognitionException {
        try {
            int _type = VAR_INPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:97:11: ( ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'r' | 'R' ) '_' ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'p' | 'P' ) ( 'u' | 'U' ) ( 't' | 'T' ) )
            // Fcl.g:97:13: ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'r' | 'R' ) '_' ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'p' | 'P' ) ( 'u' | 'U' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR_INPUT"

    // $ANTLR start "VAR_OUTPUT"
    public final void mVAR_OUTPUT() throws RecognitionException {
        try {
            int _type = VAR_OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:98:12: ( ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'r' | 'R' ) '_' ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'p' | 'P' ) ( 'u' | 'U' ) ( 't' | 'T' ) )
            // Fcl.g:98:14: ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'r' | 'R' ) '_' ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'p' | 'P' ) ( 'u' | 'U' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('_'); 
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR_OUTPUT"

    // $ANTLR start "WITH"
    public final void mWITH() throws RecognitionException {
        try {
            int _type = WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:99:6: ( ( 'w' | 'W' ) ( 'i' | 'I' ) ( 't' | 'T' ) ( 'h' | 'H' ) )
            // Fcl.g:99:8: ( 'w' | 'W' ) ( 'i' | 'I' ) ( 't' | 'T' ) ( 'h' | 'H' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WITH"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:106:3: ( ( ' ' | '\\t' )+ )
            // Fcl.g:106:5: ( ' ' | '\\t' )+
            {
            // Fcl.g:106:5: ( ' ' | '\\t' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Fcl.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:111:8: ( ( ( '\\r' )? '\\n' )+ )
            // Fcl.g:111:10: ( ( '\\r' )? '\\n' )+
            {
            // Fcl.g:111:10: ( ( '\\r' )? '\\n' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Fcl.g:111:11: ( '\\r' )? '\\n'
            	    {
            	    // Fcl.g:111:11: ( '\\r' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0=='\r') ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // Fcl.g:111:11: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "ASSIGN_OPERATOR"
    public final void mASSIGN_OPERATOR() throws RecognitionException {
        try {
            int _type = ASSIGN_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:114:17: ( ':' '=' )
            // Fcl.g:114:19: ':' '='
            {
            match(':'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN_OPERATOR"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:115:7: ( ':' )
            // Fcl.g:115:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:116:7: ( ',' )
            // Fcl.g:116:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:117:5: ( '.' )
            // Fcl.g:117:8: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "DOTS"
    public final void mDOTS() throws RecognitionException {
        try {
            int _type = DOTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:118:6: ( '..' )
            // Fcl.g:118:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOTS"

    // $ANTLR start "HAT"
    public final void mHAT() throws RecognitionException {
        try {
            int _type = HAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:119:6: ( '^' )
            // Fcl.g:119:8: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HAT"

    // $ANTLR start "LEFT_CURLY"
    public final void mLEFT_CURLY() throws RecognitionException {
        try {
            int _type = LEFT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:120:12: ( '{' )
            // Fcl.g:120:14: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_CURLY"

    // $ANTLR start "LEFT_PARENTHESIS"
    public final void mLEFT_PARENTHESIS() throws RecognitionException {
        try {
            int _type = LEFT_PARENTHESIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:121:17: ( '(' )
            // Fcl.g:121:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_PARENTHESIS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:122:7: ( '-' )
            // Fcl.g:122:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:123:10: ( '%' )
            // Fcl.g:123:12: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:124:7: ( '+' )
            // Fcl.g:124:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "RIGHT_CURLY"
    public final void mRIGHT_CURLY() throws RecognitionException {
        try {
            int _type = RIGHT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:125:13: ( '}' )
            // Fcl.g:125:15: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_CURLY"

    // $ANTLR start "RIGHT_PARENTHESIS"
    public final void mRIGHT_PARENTHESIS() throws RecognitionException {
        try {
            int _type = RIGHT_PARENTHESIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:126:18: ( ')' )
            // Fcl.g:126:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_PARENTHESIS"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:127:12: ( ';' )
            // Fcl.g:127:14: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:128:8: ( '/' )
            // Fcl.g:128:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:129:7: ( '*' )
            // Fcl.g:129:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            // Fcl.g:132:17: ( ( DIGIT )+ )
            // Fcl.g:132:19: ( DIGIT )+
            {
            // Fcl.g:132:19: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Fcl.g:132:20: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // Fcl.g:135:16: ( '0' .. '9' )
            // Fcl.g:135:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // Fcl.g:138:16: ( LOWER | UPPER )
            // Fcl.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "LOWER"
    public final void mLOWER() throws RecognitionException {
        try {
            // Fcl.g:139:15: ( 'a' .. 'z' )
            // Fcl.g:139:17: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "LOWER"

    // $ANTLR start "UPPER"
    public final void mUPPER() throws RecognitionException {
        try {
            // Fcl.g:140:15: ( 'A' .. 'Z' )
            // Fcl.g:140:17: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UPPER"

    // $ANTLR start "ALPHANUM"
    public final void mALPHANUM() throws RecognitionException {
        try {
            // Fcl.g:143:20: ( LETTER | DIGIT )
            // Fcl.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHANUM"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:146:7: ( ( PLUS | MINUS )? NUMBER ( '.' NUMBER )? ( ( 'e' | 'E' ) ( PLUS | MINUS )? NUMBER )? )
            // Fcl.g:146:11: ( PLUS | MINUS )? NUMBER ( '.' NUMBER )? ( ( 'e' | 'E' ) ( PLUS | MINUS )? NUMBER )?
            {
            // Fcl.g:146:11: ( PLUS | MINUS )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='+'||LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Fcl.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mNUMBER(); 
            // Fcl.g:146:32: ( '.' NUMBER )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Fcl.g:146:34: '.' NUMBER
                    {
                    match('.'); 
                    mNUMBER(); 

                    }
                    break;

            }

            // Fcl.g:146:48: ( ( 'e' | 'E' ) ( PLUS | MINUS )? NUMBER )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='E'||LA8_0=='e') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Fcl.g:146:49: ( 'e' | 'E' ) ( PLUS | MINUS )? NUMBER
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // Fcl.g:146:59: ( PLUS | MINUS )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='+'||LA7_0=='-') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Fcl.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    mNUMBER(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:150:2: ( '(*' ( . )* '*)' ( NEWLINE )? )
            // Fcl.g:150:4: '(*' ( . )* '*)' ( NEWLINE )?
            {
            match("(*"); 

            // Fcl.g:150:9: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==')') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='(')||(LA9_1>='*' && LA9_1<='\uFFFE')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Fcl.g:150:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*)"); 

            // Fcl.g:150:17: ( NEWLINE )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Fcl.g:150:17: NEWLINE
                    {
                    mNEWLINE(); 

                    }
                    break;

            }

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "COMMENT_C"
    public final void mCOMMENT_C() throws RecognitionException {
        try {
            int _type = COMMENT_C;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:154:2: ( '/*' ( . )* '*/' ( NEWLINE )? )
            // Fcl.g:154:4: '/*' ( . )* '*/' ( NEWLINE )?
            {
            match("/*"); 

            // Fcl.g:154:9: ( . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='.')||(LA11_1>='0' && LA11_1<='\uFFFE')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Fcl.g:154:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match("*/"); 

            // Fcl.g:154:17: ( NEWLINE )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Fcl.g:154:17: NEWLINE
                    {
                    mNEWLINE(); 

                    }
                    break;

            }

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT_C"

    // $ANTLR start "COMMENT_SL"
    public final void mCOMMENT_SL() throws RecognitionException {
        try {
            int _type = COMMENT_SL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:157:12: ( '//' (~ ( '\\r' | '\\n' ) )* NEWLINE )
            // Fcl.g:157:14: '//' (~ ( '\\r' | '\\n' ) )* NEWLINE
            {
            match("//"); 

            // Fcl.g:157:19: (~ ( '\\r' | '\\n' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFE')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Fcl.g:157:19: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            mNEWLINE(); 
             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT_SL"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Fcl.g:160:5: ( LETTER ( ALPHANUM | '_' )* )
            // Fcl.g:160:7: LETTER ( ALPHANUM | '_' )*
            {
            mLETTER(); 
            // Fcl.g:160:14: ( ALPHANUM | '_' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Fcl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    public void mTokens() throws RecognitionException {
        // Fcl.g:1:8: ( ABS | ACCU | ACT | AND | ASUM | BDIF | BSUM | COA | COSINE | COG | COGS | COGF | COS | DEFAULT | DEFUZZIFY | DMAX | DMIN | DSIGM | EINSTEIN | END_DEFUZZIFY | END_FUNCTION_BLOCK | END_FUZZIFY | END_RULEBLOCK | END_VAR | EXP | HAMACHER | FUNCTION | GAUSS | GAUSS2 | GBELL | FUNCTION_BLOCK | FUZZIFY | IF | IS | LM | LN | LOG | MAX | METHOD | MIN | NIPMIN | NIPMAX | MM | NC | NOT | NSUM | OR | PROBOR | PROD | RANGE | RM | RULE | RULEBLOCK | SIGM | SIN | SINGLETONS | SUM | TAN | TERM | THEN | TRAPE | TRIAN | TYPE_REAL | VAR_INPUT | VAR_OUTPUT | WITH | WS | NEWLINE | ASSIGN_OPERATOR | COLON | COMMA | DOT | DOTS | HAT | LEFT_CURLY | LEFT_PARENTHESIS | MINUS | PERCENT | PLUS | RIGHT_CURLY | RIGHT_PARENTHESIS | SEMICOLON | SLASH | STAR | REAL | COMMENT | COMMENT_C | COMMENT_SL | ID )
        int alt15=89;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // Fcl.g:1:10: ABS
                {
                mABS(); 

                }
                break;
            case 2 :
                // Fcl.g:1:14: ACCU
                {
                mACCU(); 

                }
                break;
            case 3 :
                // Fcl.g:1:19: ACT
                {
                mACT(); 

                }
                break;
            case 4 :
                // Fcl.g:1:23: AND
                {
                mAND(); 

                }
                break;
            case 5 :
                // Fcl.g:1:27: ASUM
                {
                mASUM(); 

                }
                break;
            case 6 :
                // Fcl.g:1:32: BDIF
                {
                mBDIF(); 

                }
                break;
            case 7 :
                // Fcl.g:1:37: BSUM
                {
                mBSUM(); 

                }
                break;
            case 8 :
                // Fcl.g:1:42: COA
                {
                mCOA(); 

                }
                break;
            case 9 :
                // Fcl.g:1:46: COSINE
                {
                mCOSINE(); 

                }
                break;
            case 10 :
                // Fcl.g:1:53: COG
                {
                mCOG(); 

                }
                break;
            case 11 :
                // Fcl.g:1:57: COGS
                {
                mCOGS(); 

                }
                break;
            case 12 :
                // Fcl.g:1:62: COGF
                {
                mCOGF(); 

                }
                break;
            case 13 :
                // Fcl.g:1:67: COS
                {
                mCOS(); 

                }
                break;
            case 14 :
                // Fcl.g:1:71: DEFAULT
                {
                mDEFAULT(); 

                }
                break;
            case 15 :
                // Fcl.g:1:79: DEFUZZIFY
                {
                mDEFUZZIFY(); 

                }
                break;
            case 16 :
                // Fcl.g:1:89: DMAX
                {
                mDMAX(); 

                }
                break;
            case 17 :
                // Fcl.g:1:94: DMIN
                {
                mDMIN(); 

                }
                break;
            case 18 :
                // Fcl.g:1:99: DSIGM
                {
                mDSIGM(); 

                }
                break;
            case 19 :
                // Fcl.g:1:105: EINSTEIN
                {
                mEINSTEIN(); 

                }
                break;
            case 20 :
                // Fcl.g:1:114: END_DEFUZZIFY
                {
                mEND_DEFUZZIFY(); 

                }
                break;
            case 21 :
                // Fcl.g:1:128: END_FUNCTION_BLOCK
                {
                mEND_FUNCTION_BLOCK(); 

                }
                break;
            case 22 :
                // Fcl.g:1:147: END_FUZZIFY
                {
                mEND_FUZZIFY(); 

                }
                break;
            case 23 :
                // Fcl.g:1:159: END_RULEBLOCK
                {
                mEND_RULEBLOCK(); 

                }
                break;
            case 24 :
                // Fcl.g:1:173: END_VAR
                {
                mEND_VAR(); 

                }
                break;
            case 25 :
                // Fcl.g:1:181: EXP
                {
                mEXP(); 

                }
                break;
            case 26 :
                // Fcl.g:1:185: HAMACHER
                {
                mHAMACHER(); 

                }
                break;
            case 27 :
                // Fcl.g:1:194: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 28 :
                // Fcl.g:1:203: GAUSS
                {
                mGAUSS(); 

                }
                break;
            case 29 :
                // Fcl.g:1:209: GAUSS2
                {
                mGAUSS2(); 

                }
                break;
            case 30 :
                // Fcl.g:1:216: GBELL
                {
                mGBELL(); 

                }
                break;
            case 31 :
                // Fcl.g:1:222: FUNCTION_BLOCK
                {
                mFUNCTION_BLOCK(); 

                }
                break;
            case 32 :
                // Fcl.g:1:237: FUZZIFY
                {
                mFUZZIFY(); 

                }
                break;
            case 33 :
                // Fcl.g:1:245: IF
                {
                mIF(); 

                }
                break;
            case 34 :
                // Fcl.g:1:248: IS
                {
                mIS(); 

                }
                break;
            case 35 :
                // Fcl.g:1:251: LM
                {
                mLM(); 

                }
                break;
            case 36 :
                // Fcl.g:1:254: LN
                {
                mLN(); 

                }
                break;
            case 37 :
                // Fcl.g:1:257: LOG
                {
                mLOG(); 

                }
                break;
            case 38 :
                // Fcl.g:1:261: MAX
                {
                mMAX(); 

                }
                break;
            case 39 :
                // Fcl.g:1:265: METHOD
                {
                mMETHOD(); 

                }
                break;
            case 40 :
                // Fcl.g:1:272: MIN
                {
                mMIN(); 

                }
                break;
            case 41 :
                // Fcl.g:1:276: NIPMIN
                {
                mNIPMIN(); 

                }
                break;
            case 42 :
                // Fcl.g:1:283: NIPMAX
                {
                mNIPMAX(); 

                }
                break;
            case 43 :
                // Fcl.g:1:290: MM
                {
                mMM(); 

                }
                break;
            case 44 :
                // Fcl.g:1:293: NC
                {
                mNC(); 

                }
                break;
            case 45 :
                // Fcl.g:1:296: NOT
                {
                mNOT(); 

                }
                break;
            case 46 :
                // Fcl.g:1:300: NSUM
                {
                mNSUM(); 

                }
                break;
            case 47 :
                // Fcl.g:1:305: OR
                {
                mOR(); 

                }
                break;
            case 48 :
                // Fcl.g:1:308: PROBOR
                {
                mPROBOR(); 

                }
                break;
            case 49 :
                // Fcl.g:1:315: PROD
                {
                mPROD(); 

                }
                break;
            case 50 :
                // Fcl.g:1:320: RANGE
                {
                mRANGE(); 

                }
                break;
            case 51 :
                // Fcl.g:1:326: RM
                {
                mRM(); 

                }
                break;
            case 52 :
                // Fcl.g:1:329: RULE
                {
                mRULE(); 

                }
                break;
            case 53 :
                // Fcl.g:1:334: RULEBLOCK
                {
                mRULEBLOCK(); 

                }
                break;
            case 54 :
                // Fcl.g:1:344: SIGM
                {
                mSIGM(); 

                }
                break;
            case 55 :
                // Fcl.g:1:349: SIN
                {
                mSIN(); 

                }
                break;
            case 56 :
                // Fcl.g:1:353: SINGLETONS
                {
                mSINGLETONS(); 

                }
                break;
            case 57 :
                // Fcl.g:1:364: SUM
                {
                mSUM(); 

                }
                break;
            case 58 :
                // Fcl.g:1:368: TAN
                {
                mTAN(); 

                }
                break;
            case 59 :
                // Fcl.g:1:372: TERM
                {
                mTERM(); 

                }
                break;
            case 60 :
                // Fcl.g:1:377: THEN
                {
                mTHEN(); 

                }
                break;
            case 61 :
                // Fcl.g:1:382: TRAPE
                {
                mTRAPE(); 

                }
                break;
            case 62 :
                // Fcl.g:1:388: TRIAN
                {
                mTRIAN(); 

                }
                break;
            case 63 :
                // Fcl.g:1:394: TYPE_REAL
                {
                mTYPE_REAL(); 

                }
                break;
            case 64 :
                // Fcl.g:1:404: VAR_INPUT
                {
                mVAR_INPUT(); 

                }
                break;
            case 65 :
                // Fcl.g:1:414: VAR_OUTPUT
                {
                mVAR_OUTPUT(); 

                }
                break;
            case 66 :
                // Fcl.g:1:425: WITH
                {
                mWITH(); 

                }
                break;
            case 67 :
                // Fcl.g:1:430: WS
                {
                mWS(); 

                }
                break;
            case 68 :
                // Fcl.g:1:433: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 69 :
                // Fcl.g:1:441: ASSIGN_OPERATOR
                {
                mASSIGN_OPERATOR(); 

                }
                break;
            case 70 :
                // Fcl.g:1:457: COLON
                {
                mCOLON(); 

                }
                break;
            case 71 :
                // Fcl.g:1:463: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 72 :
                // Fcl.g:1:469: DOT
                {
                mDOT(); 

                }
                break;
            case 73 :
                // Fcl.g:1:473: DOTS
                {
                mDOTS(); 

                }
                break;
            case 74 :
                // Fcl.g:1:478: HAT
                {
                mHAT(); 

                }
                break;
            case 75 :
                // Fcl.g:1:482: LEFT_CURLY
                {
                mLEFT_CURLY(); 

                }
                break;
            case 76 :
                // Fcl.g:1:493: LEFT_PARENTHESIS
                {
                mLEFT_PARENTHESIS(); 

                }
                break;
            case 77 :
                // Fcl.g:1:510: MINUS
                {
                mMINUS(); 

                }
                break;
            case 78 :
                // Fcl.g:1:516: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 79 :
                // Fcl.g:1:524: PLUS
                {
                mPLUS(); 

                }
                break;
            case 80 :
                // Fcl.g:1:529: RIGHT_CURLY
                {
                mRIGHT_CURLY(); 

                }
                break;
            case 81 :
                // Fcl.g:1:541: RIGHT_PARENTHESIS
                {
                mRIGHT_PARENTHESIS(); 

                }
                break;
            case 82 :
                // Fcl.g:1:559: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 83 :
                // Fcl.g:1:569: SLASH
                {
                mSLASH(); 

                }
                break;
            case 84 :
                // Fcl.g:1:575: STAR
                {
                mSTAR(); 

                }
                break;
            case 85 :
                // Fcl.g:1:580: REAL
                {
                mREAL(); 

                }
                break;
            case 86 :
                // Fcl.g:1:585: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 87 :
                // Fcl.g:1:593: COMMENT_C
                {
                mCOMMENT_C(); 

                }
                break;
            case 88 :
                // Fcl.g:1:603: COMMENT_SL
                {
                mCOMMENT_SL(); 

                }
                break;
            case 89 :
                // Fcl.g:1:614: ID
                {
                mID(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\23\45\2\uffff\1\123\1\uffff\1\125\2\uffff\1\127\1\130\1"+
        "\uffff\1\131\3\uffff\1\134\3\uffff\21\45\1\163\1\164\1\165\1\166"+
        "\4\45\1\173\1\45\1\175\2\45\1\u0080\2\45\1\u0083\12\45\13\uffff"+
        "\1\u0090\1\45\1\u0092\1\u0093\3\45\1\u0097\1\u0099\1\u009c\6\45"+
        "\1\u00a4\5\45\4\uffff\1\u00aa\1\u00ab\1\45\1\u00ad\1\uffff\1\45"+
        "\1\uffff\1\u00af\1\45\1\uffff\2\45\1\uffff\3\45\1\u00b8\1\u00b9"+
        "\1\u00ba\6\45\1\uffff\1\u00c1\2\uffff\1\u00c2\1\u00c3\1\u00c4\1"+
        "\uffff\1\45\1\uffff\1\u00c6\1\u00c7\1\uffff\2\45\1\u00ca\1\u00cb"+
        "\3\45\1\uffff\5\45\2\uffff\1\45\1\uffff\1\45\1\uffff\1\u00da\1\45"+
        "\1\u00dc\1\45\1\u00df\1\u00e0\1\u00e1\1\45\3\uffff\1\u00e3\1\u00e4"+
        "\3\45\1\u00e9\4\uffff\1\45\2\uffff\2\45\2\uffff\1\u00ed\10\45\1"+
        "\u00f7\1\u00f8\3\45\1\uffff\1\45\1\uffff\1\u00fd\1\45\3\uffff\1"+
        "\45\2\uffff\1\u0100\1\u0101\2\45\1\uffff\1\u0104\2\45\1\uffff\10"+
        "\45\1\u0110\2\uffff\1\u0111\1\u0112\1\u0113\1\u0114\1\uffff\2\45"+
        "\2\uffff\2\45\1\uffff\1\u0119\6\45\1\u0120\2\45\1\u0123\5\uffff"+
        "\4\45\1\uffff\1\45\1\u0129\4\45\1\uffff\1\u012e\1\u0130\1\uffff"+
        "\4\45\1\u0135\1\uffff\4\45\1\uffff\1\45\1\uffff\1\u013b\1\45\1\u013d"+
        "\1\45\1\uffff\5\45\1\uffff\1\u0144\1\uffff\1\u0145\2\45\1\u0148"+
        "\2\45\2\uffff\2\45\1\uffff\2\45\1\u014f\1\45\1\u0151\1\45\1\uffff"+
        "\1\45\1\uffff\1\u0154\1\45\1\uffff\2\45\1\u0158\1\uffff";
    static final String DFA15_eofS =
        "\u0159\uffff";
    static final String DFA15_minS =
        "\1\11\1\102\1\104\1\117\1\105\1\111\1\101\1\125\1\101\1\106\1\115"+
        "\1\101\1\103\2\122\1\101\1\111\2\101\1\111\2\uffff\1\75\1\uffff"+
        "\1\56\2\uffff\1\52\1\60\1\uffff\1\60\3\uffff\1\52\3\uffff\1\123"+
        "\1\103\1\104\1\125\1\111\1\125\1\101\1\106\1\101\1\111\1\116\1\104"+
        "\1\120\1\115\1\116\1\125\1\105\4\60\1\107\1\130\1\124\1\116\1\60"+
        "\1\120\1\60\1\124\1\125\1\60\1\117\1\116\1\60\1\114\1\101\1\107"+
        "\1\115\1\116\1\122\1\105\1\101\1\122\1\124\13\uffff\1\60\1\125\2"+
        "\60\1\115\1\106\1\115\3\60\1\101\1\130\1\116\1\107\1\123\1\137\1"+
        "\60\1\101\1\103\1\132\1\123\1\114\4\uffff\2\60\1\110\1\60\1\uffff"+
        "\1\115\1\uffff\1\60\1\115\1\uffff\1\102\1\107\1\uffff\1\105\1\114"+
        "\1\115\3\60\1\115\1\116\1\120\1\101\1\137\1\110\1\uffff\1\60\2\uffff"+
        "\3\60\1\uffff\1\116\1\uffff\2\60\1\uffff\1\125\1\132\2\60\1\115"+
        "\1\124\1\104\1\uffff\1\103\1\124\1\111\1\123\1\114\2\uffff\1\117"+
        "\1\uffff\1\101\1\uffff\1\60\1\117\1\60\1\105\3\60\1\114\3\uffff"+
        "\2\60\1\105\1\116\1\111\1\60\4\uffff\1\105\2\uffff\1\114\1\132\2"+
        "\uffff\1\60\2\105\2\125\1\101\1\110\1\111\1\106\2\60\1\104\1\116"+
        "\1\130\1\uffff\1\122\1\uffff\1\60\1\114\3\uffff\1\105\2\uffff\2"+
        "\60\1\116\1\125\1\uffff\1\60\1\124\1\111\1\uffff\1\111\1\106\1\116"+
        "\1\114\1\122\1\105\1\117\1\131\1\60\2\uffff\4\60\1\uffff\1\117\1"+
        "\124\2\uffff\1\120\1\124\1\uffff\1\60\1\106\1\116\1\125\1\103\1"+
        "\132\1\105\1\60\1\122\1\116\1\60\5\uffff\1\103\1\117\1\125\1\120"+
        "\1\uffff\1\131\1\60\1\132\1\124\1\111\1\102\1\uffff\2\60\1\uffff"+
        "\1\113\1\116\1\124\1\125\1\60\1\uffff\1\132\1\111\1\106\1\114\1"+
        "\uffff\1\102\1\uffff\1\60\1\123\1\60\1\124\1\uffff\1\111\1\117\1"+
        "\131\1\117\1\114\1\uffff\1\60\1\uffff\1\60\1\106\1\116\1\60\1\103"+
        "\1\117\2\uffff\1\131\1\137\1\uffff\1\113\1\103\1\60\1\102\1\60\1"+
        "\113\1\uffff\1\114\1\uffff\1\60\1\117\1\uffff\1\103\1\113\1\60\1"+
        "\uffff";
    static final String DFA15_maxS =
        "\1\175\2\163\1\157\1\163\1\170\1\141\1\165\1\142\1\163\1\157\1\155"+
        "\1\163\2\162\2\165\1\162\1\141\1\151\2\uffff\1\75\1\uffff\1\56\2"+
        "\uffff\1\52\1\71\1\uffff\1\71\3\uffff\1\57\3\uffff\1\163\1\164\1"+
        "\144\1\165\1\151\1\165\1\163\1\146\2\151\1\156\1\144\1\160\1\155"+
        "\1\172\1\165\1\145\4\172\1\147\1\170\1\164\1\156\1\172\1\160\1\172"+
        "\1\164\1\165\1\172\1\157\1\156\1\172\1\154\1\141\1\156\1\155\1\156"+
        "\1\162\1\145\1\151\1\162\1\164\13\uffff\1\172\1\165\2\172\1\155"+
        "\1\146\1\155\3\172\1\165\1\170\1\156\1\147\1\163\1\137\1\172\1\141"+
        "\1\143\1\172\1\163\1\154\4\uffff\2\172\1\150\1\172\1\uffff\1\155"+
        "\1\uffff\1\172\1\155\1\uffff\1\144\1\147\1\uffff\1\145\1\154\1\155"+
        "\3\172\1\155\1\156\1\160\1\141\1\137\1\150\1\uffff\1\172\2\uffff"+
        "\3\172\1\uffff\1\156\1\uffff\2\172\1\uffff\1\165\3\172\1\155\1\164"+
        "\1\166\1\uffff\1\143\1\164\1\151\1\163\1\154\2\uffff\1\157\1\uffff"+
        "\1\151\1\uffff\1\172\1\157\1\172\1\145\3\172\1\154\3\uffff\2\172"+
        "\1\145\1\156\1\157\1\172\4\uffff\1\145\2\uffff\1\154\1\172\2\uffff"+
        "\1\172\2\145\2\165\1\141\1\150\1\151\1\146\2\172\1\144\1\156\1\170"+
        "\1\uffff\1\162\1\uffff\1\172\1\154\3\uffff\1\145\2\uffff\2\172\1"+
        "\156\1\165\1\uffff\1\172\1\164\1\151\1\uffff\1\151\1\146\1\172\1"+
        "\154\1\162\1\145\1\157\1\171\1\172\2\uffff\4\172\1\uffff\1\157\1"+
        "\164\2\uffff\1\160\1\164\1\uffff\1\172\1\146\1\156\1\165\1\143\1"+
        "\172\1\145\1\172\1\162\1\156\1\172\5\uffff\1\143\1\157\1\165\1\160"+
        "\1\uffff\1\171\2\172\1\164\1\151\1\142\1\uffff\2\172\1\uffff\1\153"+
        "\1\156\1\164\1\165\1\172\1\uffff\1\172\1\151\1\146\1\154\1\uffff"+
        "\1\142\1\uffff\1\172\1\163\1\172\1\164\1\uffff\1\151\1\157\1\171"+
        "\1\157\1\154\1\uffff\1\172\1\uffff\1\172\1\146\1\156\1\172\1\143"+
        "\1\157\2\uffff\1\171\1\137\1\uffff\1\153\1\143\1\172\1\142\1\172"+
        "\1\153\1\uffff\1\154\1\uffff\1\172\1\157\1\uffff\1\143\1\153\1\172"+
        "\1\uffff";
    static final String DFA15_acceptS =
        "\24\uffff\1\103\1\104\1\uffff\1\107\1\uffff\1\112\1\113\2\uffff"+
        "\1\116\1\uffff\1\120\1\121\1\122\1\uffff\1\124\1\125\1\131\54\uffff"+
        "\1\105\1\106\1\111\1\110\1\126\1\114\1\115\1\117\1\127\1\130\1\123"+
        "\26\uffff\1\41\1\42\1\43\1\44\4\uffff\1\53\1\uffff\1\54\2\uffff"+
        "\1\57\2\uffff\1\63\14\uffff\1\1\1\uffff\1\3\1\4\3\uffff\1\10\1\uffff"+
        "\1\15\2\uffff\1\12\7\uffff\1\31\5\uffff\1\45\1\46\1\uffff\1\50\1"+
        "\uffff\1\55\10\uffff\1\67\1\71\1\72\6\uffff\1\2\1\5\1\6\1\7\1\uffff"+
        "\1\13\1\14\2\uffff\1\20\1\21\16\uffff\1\56\1\uffff\1\61\2\uffff"+
        "\1\64\1\77\1\66\1\uffff\1\73\1\74\4\uffff\1\102\3\uffff\1\22\11"+
        "\uffff\1\34\1\36\4\uffff\1\62\2\uffff\1\75\1\76\2\uffff\1\11\13"+
        "\uffff\1\35\1\47\1\51\1\52\1\60\4\uffff\1\16\6\uffff\1\30\2\uffff"+
        "\1\40\5\uffff\1\23\4\uffff\1\32\1\uffff\1\33\4\uffff\1\17\5\uffff"+
        "\1\65\1\uffff\1\100\6\uffff\1\70\1\101\2\uffff\1\26\6\uffff\1\24"+
        "\1\uffff\1\27\2\uffff\1\37\3\uffff\1\25";
    static final String DFA15_specialS =
        "\u0159\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\24\1\25\2\uffff\1\25\22\uffff\1\24\4\uffff\1\35\2\uffff\1"+
            "\33\1\40\1\43\1\36\1\27\1\34\1\30\1\42\12\44\1\26\1\41\5\uffff"+
            "\1\1\1\2\1\3\1\4\1\5\1\7\1\10\1\6\1\11\2\45\1\12\1\13\1\14\1"+
            "\15\1\16\1\45\1\17\1\20\1\21\1\45\1\22\1\23\3\45\3\uffff\1\31"+
            "\2\uffff\1\1\1\2\1\3\1\4\1\5\1\7\1\10\1\6\1\11\2\45\1\12\1\13"+
            "\1\14\1\15\1\16\1\45\1\17\1\20\1\21\1\45\1\22\1\23\3\45\1\32"+
            "\1\uffff\1\37",
            "\1\46\1\47\12\uffff\1\50\4\uffff\1\51\16\uffff\1\46\1\47\12"+
            "\uffff\1\50\4\uffff\1\51",
            "\1\52\16\uffff\1\53\20\uffff\1\52\16\uffff\1\53",
            "\1\54\37\uffff\1\54",
            "\1\55\7\uffff\1\56\5\uffff\1\57\21\uffff\1\55\7\uffff\1\56"+
            "\5\uffff\1\57",
            "\1\60\4\uffff\1\61\11\uffff\1\62\20\uffff\1\60\4\uffff\1\61"+
            "\11\uffff\1\62",
            "\1\63\37\uffff\1\63",
            "\1\64\37\uffff\1\64",
            "\1\65\1\66\36\uffff\1\65\1\66",
            "\1\67\14\uffff\1\70\22\uffff\1\67\14\uffff\1\70",
            "\1\71\1\72\1\73\35\uffff\1\71\1\72\1\73",
            "\1\74\3\uffff\1\75\3\uffff\1\76\3\uffff\1\77\23\uffff\1\74"+
            "\3\uffff\1\75\3\uffff\1\76\3\uffff\1\77",
            "\1\101\5\uffff\1\100\5\uffff\1\102\3\uffff\1\103\17\uffff\1"+
            "\101\5\uffff\1\100\5\uffff\1\102\3\uffff\1\103",
            "\1\104\37\uffff\1\104",
            "\1\105\37\uffff\1\105",
            "\1\106\3\uffff\1\111\7\uffff\1\107\7\uffff\1\110\13\uffff\1"+
            "\106\3\uffff\1\111\7\uffff\1\107\7\uffff\1\110",
            "\1\112\13\uffff\1\113\23\uffff\1\112\13\uffff\1\113",
            "\1\114\3\uffff\1\115\2\uffff\1\116\11\uffff\1\117\16\uffff"+
            "\1\114\3\uffff\1\115\2\uffff\1\116\11\uffff\1\117",
            "\1\120\37\uffff\1\120",
            "\1\121\37\uffff\1\121",
            "",
            "",
            "\1\122",
            "",
            "\1\124",
            "",
            "",
            "\1\126",
            "\12\44",
            "",
            "\12\44",
            "",
            "",
            "",
            "\1\132\4\uffff\1\133",
            "",
            "",
            "",
            "\1\135\37\uffff\1\135",
            "\1\136\20\uffff\1\137\16\uffff\1\136\20\uffff\1\137",
            "\1\140\37\uffff\1\140",
            "\1\141\37\uffff\1\141",
            "\1\142\37\uffff\1\142",
            "\1\143\37\uffff\1\143",
            "\1\144\5\uffff\1\146\13\uffff\1\145\15\uffff\1\144\5\uffff"+
            "\1\146\13\uffff\1\145",
            "\1\147\37\uffff\1\147",
            "\1\150\7\uffff\1\151\27\uffff\1\150\7\uffff\1\151",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "\1\154\37\uffff\1\154",
            "\1\155\37\uffff\1\155",
            "\1\156\37\uffff\1\156",
            "\1\157\13\uffff\1\160\23\uffff\1\157\13\uffff\1\160",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "\1\172\37\uffff\1\172",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\174\37\uffff\1\174",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\176\37\uffff\1\176",
            "\1\177\37\uffff\1\177",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0082\37\uffff\1\u0082",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0084\37\uffff\1\u0084",
            "\1\u0085\37\uffff\1\u0085",
            "\1\u0086\6\uffff\1\u0087\30\uffff\1\u0086\6\uffff\1\u0087",
            "\1\u0088\37\uffff\1\u0088",
            "\1\u0089\37\uffff\1\u0089",
            "\1\u008a\37\uffff\1\u008a",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\7\uffff\1\u008d\27\uffff\1\u008c\7\uffff\1\u008d",
            "\1\u008e\37\uffff\1\u008e",
            "\1\u008f\37\uffff\1\u008f",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0091\37\uffff\1\u0091",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0094\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0095",
            "\1\u0096\37\uffff\1\u0096",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\10\45\1\u0098\21\45\4\uffff\1\45\1\uffff\10"+
            "\45\1\u0098\21\45",
            "\12\45\7\uffff\5\45\1\u009b\14\45\1\u009a\7\45\4\uffff\1\45"+
            "\1\uffff\5\45\1\u009b\14\45\1\u009a\7\45",
            "\1\u009d\23\uffff\1\u009e\13\uffff\1\u009d\23\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\u00a3",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\u00a7\37\uffff\1\u00a7",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\u00a9\37\uffff\1\u00a9",
            "",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00ac\37\uffff\1\u00ac",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u00ae\37\uffff\1\u00ae",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00b0\37\uffff\1\u00b0",
            "",
            "\1\u00b1\1\uffff\1\u00b2\35\uffff\1\u00b1\1\uffff\1\u00b2",
            "\1\u00b3\37\uffff\1\u00b3",
            "",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b6",
            "\12\45\7\uffff\6\45\1\u00b7\23\45\4\uffff\1\45\1\uffff\6\45"+
            "\1\u00b7\23\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00bb\37\uffff\1\u00bb",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00be",
            "\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u00c5\37\uffff\1\u00c5",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00cc\37\uffff\1\u00cc",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00ce\1\uffff\1\u00cf\13\uffff\1\u00d0\3\uffff\1\u00d1\15"+
            "\uffff\1\u00ce\1\uffff\1\u00cf\13\uffff\1\u00d0\3\uffff\1\u00d1",
            "",
            "\1\u00d2\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d3",
            "\1\u00d4\37\uffff\1\u00d4",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d6",
            "",
            "",
            "\1\u00d7\37\uffff\1\u00d7",
            "",
            "\1\u00d9\7\uffff\1\u00d8\27\uffff\1\u00d9\7\uffff\1\u00d8",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00db\37\uffff\1\u00db",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00dd\37\uffff\1\u00dd",
            "\12\45\7\uffff\1\45\1\u00de\30\45\4\uffff\1\45\1\uffff\1\45"+
            "\1\u00de\30\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00e2\37\uffff\1\u00e2",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\5\uffff\1\u00e8\31\uffff\1\u00e7\5\uffff\1\u00e8",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "",
            "",
            "\1\u00ea\37\uffff\1\u00ea",
            "",
            "",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\u00ef\37\uffff\1\u00ef",
            "\1\u00f0\37\uffff\1\u00f0",
            "\1\u00f1\37\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\u00f5\37\uffff\1\u00f5",
            "\2\45\1\u00f6\7\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00f9\37\uffff\1\u00f9",
            "\1\u00fa\37\uffff\1\u00fa",
            "\1\u00fb\37\uffff\1\u00fb",
            "",
            "\1\u00fc\37\uffff\1\u00fc",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00fe\37\uffff\1\u00fe",
            "",
            "",
            "",
            "\1\u00ff\37\uffff\1\u00ff",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0102\37\uffff\1\u0102",
            "\1\u0103\37\uffff\1\u0103",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0105\37\uffff\1\u0105",
            "\1\u0106\37\uffff\1\u0106",
            "",
            "\1\u0107\37\uffff\1\u0107",
            "\1\u0108\37\uffff\1\u0108",
            "\1\u0109\13\uffff\1\u010a\23\uffff\1\u0109\13\uffff\1\u010a",
            "\1\u010b\37\uffff\1\u010b",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d\37\uffff\1\u010d",
            "\1\u010e\37\uffff\1\u010e",
            "\1\u010f\37\uffff\1\u010f",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u0115\37\uffff\1\u0115",
            "\1\u0116\37\uffff\1\u0116",
            "",
            "",
            "\1\u0117\37\uffff\1\u0117",
            "\1\u0118\37\uffff\1\u0118",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u011a\37\uffff\1\u011a",
            "\1\u011b\37\uffff\1\u011b",
            "\1\u011c\37\uffff\1\u011c",
            "\1\u011d\37\uffff\1\u011d",
            "\1\u011e\37\uffff\1\u011e",
            "\1\u011f\37\uffff\1\u011f",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0121\37\uffff\1\u0121",
            "\1\u0122\37\uffff\1\u0122",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "",
            "",
            "",
            "\1\u0124\37\uffff\1\u0124",
            "\1\u0125\37\uffff\1\u0125",
            "\1\u0126\37\uffff\1\u0126",
            "\1\u0127\37\uffff\1\u0127",
            "",
            "\1\u0128\37\uffff\1\u0128",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u012a\37\uffff\1\u012a",
            "\1\u012b\37\uffff\1\u012b",
            "\1\u012c\37\uffff\1\u012c",
            "\1\u012d\37\uffff\1\u012d",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\u012f\1\uffff\32\45",
            "",
            "\1\u0131\37\uffff\1\u0131",
            "\1\u0132\37\uffff\1\u0132",
            "\1\u0133\37\uffff\1\u0133",
            "\1\u0134\37\uffff\1\u0134",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u0136\37\uffff\1\u0136",
            "\1\u0137\37\uffff\1\u0137",
            "\1\u0138\37\uffff\1\u0138",
            "\1\u0139\37\uffff\1\u0139",
            "",
            "\1\u013a\37\uffff\1\u013a",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u013c\37\uffff\1\u013c",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u013e\37\uffff\1\u013e",
            "",
            "\1\u013f\37\uffff\1\u013f",
            "\1\u0140\37\uffff\1\u0140",
            "\1\u0141\37\uffff\1\u0141",
            "\1\u0142\37\uffff\1\u0142",
            "\1\u0143\37\uffff\1\u0143",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0146\37\uffff\1\u0146",
            "\1\u0147\37\uffff\1\u0147",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0149\37\uffff\1\u0149",
            "\1\u014a\37\uffff\1\u014a",
            "",
            "",
            "\1\u014b\37\uffff\1\u014b",
            "\1\u014c",
            "",
            "\1\u014d\37\uffff\1\u014d",
            "\1\u014e\37\uffff\1\u014e",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0150\37\uffff\1\u0150",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0152\37\uffff\1\u0152",
            "",
            "\1\u0153\37\uffff\1\u0153",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0155\37\uffff\1\u0155",
            "",
            "\1\u0156\37\uffff\1\u0156",
            "\1\u0157\37\uffff\1\u0157",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ABS | ACCU | ACT | AND | ASUM | BDIF | BSUM | COA | COSINE | COG | COGS | COGF | COS | DEFAULT | DEFUZZIFY | DMAX | DMIN | DSIGM | EINSTEIN | END_DEFUZZIFY | END_FUNCTION_BLOCK | END_FUZZIFY | END_RULEBLOCK | END_VAR | EXP | HAMACHER | FUNCTION | GAUSS | GAUSS2 | GBELL | FUNCTION_BLOCK | FUZZIFY | IF | IS | LM | LN | LOG | MAX | METHOD | MIN | NIPMIN | NIPMAX | MM | NC | NOT | NSUM | OR | PROBOR | PROD | RANGE | RM | RULE | RULEBLOCK | SIGM | SIN | SINGLETONS | SUM | TAN | TERM | THEN | TRAPE | TRIAN | TYPE_REAL | VAR_INPUT | VAR_OUTPUT | WITH | WS | NEWLINE | ASSIGN_OPERATOR | COLON | COMMA | DOT | DOTS | HAT | LEFT_CURLY | LEFT_PARENTHESIS | MINUS | PERCENT | PLUS | RIGHT_CURLY | RIGHT_PARENTHESIS | SEMICOLON | SLASH | STAR | REAL | COMMENT | COMMENT_C | COMMENT_SL | ID );";
        }
    }
 

}