// $ANTLR 3.1b1 gUnit.g 2008-05-14 15:52:07
package org.antlr.gunit;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class gUnitParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DOC_COMMENT", "ID", "ACTION", "RETVAL", "STRING", "ML_STRING", "AST", "EXT", "SL_COMMENT", "ML_COMMENT", "ESC", "NESTED_RETVAL", "NESTED_AST", "NESTED_ACTION", "STRING_LITERAL", "CHAR_LITERAL", "XDIGIT", "WS", "'gunit'", "'walks'", "';'", "'@header'", "':'", "'OK'", "'FAIL'", "'returns'", "'->'"
    };
    public static final int RETVAL=7;
    public static final int NESTED_ACTION=17;
    public static final int AST=10;
    public static final int T__28=28;
    public static final int EXT=11;
    public static final int T__23=23;
    public static final int WS=21;
    public static final int STRING=8;
    public static final int ACTION=6;
    public static final int T__22=22;
    public static final int ESC=14;
    public static final int XDIGIT=20;
    public static final int T__29=29;
    public static final int NESTED_AST=16;
    public static final int T__30=30;
    public static final int CHAR_LITERAL=19;
    public static final int EOF=-1;
    public static final int STRING_LITERAL=18;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int ML_STRING=9;
    public static final int ML_COMMENT=13;
    public static final int SL_COMMENT=12;
    public static final int DOC_COMMENT=4;
    public static final int NESTED_RETVAL=15;
    public static final int ID=5;

    // delegates
    // delegators


        public gUnitParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public gUnitParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }
        

    public String[] getTokenNames() { return gUnitParser.tokenNames; }
    public String getGrammarFileName() { return "gUnit.g"; }


    public GrammarInfo grammarInfo;
    public gUnitParser(TokenStream input, GrammarInfo grammarInfo) {
    	super(input);
    	this.grammarInfo = grammarInfo;
    }



    // $ANTLR start gUnitDef
    // gUnit.g:44:1: gUnitDef : 'gunit' g1= ID ( 'walks' g2= ID )? ';' ( header )? ( suite )* ;
    public final void gUnitDef() throws RecognitionException {
        Token g1=null;
        Token g2=null;

        try {
            // gUnit.g:44:9: ( 'gunit' g1= ID ( 'walks' g2= ID )? ';' ( header )? ( suite )* )
            // gUnit.g:44:11: 'gunit' g1= ID ( 'walks' g2= ID )? ';' ( header )? ( suite )*
            {
            match(input,22,FOLLOW_22_in_gUnitDef44); 
            g1=(Token)match(input,ID,FOLLOW_ID_in_gUnitDef48); 
            // gUnit.g:44:25: ( 'walks' g2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==23) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // gUnit.g:44:26: 'walks' g2= ID
                    {
                    match(input,23,FOLLOW_23_in_gUnitDef51); 
                    g2=(Token)match(input,ID,FOLLOW_ID_in_gUnitDef55); 

                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_gUnitDef59); 

            		if ( g2==null ) {
            			grammarInfo.setGrammarName((g1!=null?g1.getText():null));
            		}
            		else {
            			grammarInfo.setGrammarName((g2!=null?g2.getText():null));
            			grammarInfo.setTreeGrammarName((g1!=null?g1.getText():null));
            		}
            		
            // gUnit.g:54:3: ( header )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // gUnit.g:54:3: header
                    {
                    pushFollow(FOLLOW_header_in_gUnitDef68);
                    header();

                    state._fsp--;


                    }
                    break;

            }

            // gUnit.g:54:11: ( suite )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // gUnit.g:54:11: suite
            	    {
            	    pushFollow(FOLLOW_suite_in_gUnitDef71);
            	    suite();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end gUnitDef


    // $ANTLR start header
    // gUnit.g:57:1: header : '@header' ACTION ;
    public final void header() throws RecognitionException {
        Token ACTION1=null;

        try {
            // gUnit.g:57:8: ( '@header' ACTION )
            // gUnit.g:57:10: '@header' ACTION
            {
            match(input,25,FOLLOW_25_in_header82); 
            ACTION1=(Token)match(input,ACTION,FOLLOW_ACTION_in_header84); 

            		int pos1, pos2;
            		if ( (pos1=(ACTION1!=null?ACTION1.getText():null).indexOf("package"))!=-1 && (pos2=(ACTION1!=null?ACTION1.getText():null).indexOf(';'))!=-1 ) {
            			grammarInfo.setHeader((ACTION1!=null?ACTION1.getText():null).substring(pos1+8, pos2).trim());	// substring the package path
            		}
            		else {
            			System.err.println("error(line "+ACTION1.getLine()+"): invalid header");
            		}
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end header


    // $ANTLR start suite
    // gUnit.g:69:1: suite : r1= ID ( 'walks' r2= ID )? ':' ( test[ts] )+ ;
    public final void suite() throws RecognitionException {
        Token r1=null;
        Token r2=null;


            gUnitTestSuite ts = null;

        try {
            // gUnit.g:73:2: (r1= ID ( 'walks' r2= ID )? ':' ( test[ts] )+ )
            // gUnit.g:73:4: r1= ID ( 'walks' r2= ID )? ':' ( test[ts] )+
            {
            r1=(Token)match(input,ID,FOLLOW_ID_in_suite109); 
            // gUnit.g:73:10: ( 'walks' r2= ID )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // gUnit.g:73:11: 'walks' r2= ID
                    {
                    match(input,23,FOLLOW_23_in_suite112); 
                    r2=(Token)match(input,ID,FOLLOW_ID_in_suite116); 

                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_suite120); 

            		if ( r2==null ) {
            			ts = new gUnitTestSuite((r1!=null?r1.getText():null));
            		}
            		else {
            			ts = new gUnitTestSuite((r1!=null?r1.getText():null), (r2!=null?r2.getText():null));
            		}
            		
            // gUnit.g:82:3: ( test[ts] )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID) ) {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2==EXT||(LA5_2>=27 && LA5_2<=30)) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>=STRING && LA5_0<=ML_STRING)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // gUnit.g:82:3: test[ts]
            	    {
            	    pushFollow(FOLLOW_test_in_suite129);
            	    test(ts);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            grammarInfo.addRuleTestSuite(ts);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end suite


    // $ANTLR start test
    // gUnit.g:85:1: test[gUnitTestSuite ts] : ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output );
    public final void test(gUnitTestSuite ts) throws RecognitionException {
        Token ok=null;
        Token fail=null;
        Token RETVAL5=null;
        gUnitParser.input_return input2 = null;

        gUnitParser.input_return input3 = null;

        gUnitParser.input_return input4 = null;

        gUnitParser.input_return input6 = null;

        Token output7 = null;


        try {
            // gUnit.g:86:2: ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output )
            int alt6=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                switch ( input.LA(2) ) {
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                case 30:
                    {
                    alt6=4;
                    }
                    break;
                case 29:
                    {
                    alt6=3;
                    }
                    break;
                case 27:
                    {
                    alt6=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

                }
                break;
            case ML_STRING:
                {
                switch ( input.LA(2) ) {
                case 27:
                    {
                    alt6=1;
                    }
                    break;
                case 30:
                    {
                    alt6=4;
                    }
                    break;
                case 29:
                    {
                    alt6=3;
                    }
                    break;
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }

                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case EXT:
                    {
                    switch ( input.LA(3) ) {
                    case 29:
                        {
                        alt6=3;
                        }
                        break;
                    case 27:
                        {
                        alt6=1;
                        }
                        break;
                    case 30:
                        {
                        alt6=4;
                        }
                        break;
                    case 28:
                        {
                        alt6=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 8, input);

                        throw nvae;
                    }

                    }
                    break;
                case 29:
                    {
                    alt6=3;
                    }
                    break;
                case 27:
                    {
                    alt6=1;
                    }
                    break;
                case 30:
                    {
                    alt6=4;
                    }
                    break;
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // gUnit.g:86:4: input ok= 'OK'
                    {
                    pushFollow(FOLLOW_input_in_test146);
                    input2=input();

                    state._fsp--;

                    ok=(Token)match(input,27,FOLLOW_27_in_test150); 
                    ts.testSuites.put(new gUnitTestInput((input2!=null?input2.testInput:null), (input2!=null?input2.inputIsFile:false), (input2!=null?input2.line:0)), new BooleanTest(true));

                    }
                    break;
                case 2 :
                    // gUnit.g:87:4: input fail= 'FAIL'
                    {
                    pushFollow(FOLLOW_input_in_test157);
                    input3=input();

                    state._fsp--;

                    fail=(Token)match(input,28,FOLLOW_28_in_test161); 
                    ts.testSuites.put(new gUnitTestInput((input3!=null?input3.testInput:null), (input3!=null?input3.inputIsFile:false), (input3!=null?input3.line:0)), new BooleanTest(false));

                    }
                    break;
                case 3 :
                    // gUnit.g:88:4: input 'returns' RETVAL
                    {
                    pushFollow(FOLLOW_input_in_test168);
                    input4=input();

                    state._fsp--;

                    match(input,29,FOLLOW_29_in_test170); 
                    RETVAL5=(Token)match(input,RETVAL,FOLLOW_RETVAL_in_test172); 
                    ts.testSuites.put(new gUnitTestInput((input4!=null?input4.testInput:null), (input4!=null?input4.inputIsFile:false), (input4!=null?input4.line:0)), new ReturnTest(RETVAL5));

                    }
                    break;
                case 4 :
                    // gUnit.g:89:4: input '->' output
                    {
                    pushFollow(FOLLOW_input_in_test179);
                    input6=input();

                    state._fsp--;

                    match(input,30,FOLLOW_30_in_test181); 
                    pushFollow(FOLLOW_output_in_test183);
                    output7=output();

                    state._fsp--;

                    ts.testSuites.put(new gUnitTestInput((input6!=null?input6.testInput:null), (input6!=null?input6.inputIsFile:false), (input6!=null?input6.line:0)), new OutputTest(output7));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end test

    public static class input_return extends ParserRuleReturnScope {
        public String testInput;
        public boolean inputIsFile;
        public int line;
    };

    // $ANTLR start input
    // gUnit.g:92:1: input returns [String testInput, boolean inputIsFile, int line] : ( STRING | ML_STRING | file );
    public final gUnitParser.input_return input() throws RecognitionException {
        gUnitParser.input_return retval = new gUnitParser.input_return();
        retval.start = input.LT(1);

        Token STRING8=null;
        Token ML_STRING9=null;
        gUnitParser.file_return file10 = null;


        try {
            // gUnit.g:93:2: ( STRING | ML_STRING | file )
            int alt7=3;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt7=1;
                }
                break;
            case ML_STRING:
                {
                alt7=2;
                }
                break;
            case ID:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // gUnit.g:93:4: STRING
                    {
                    STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_input200); 

                    		retval.testInput = (STRING8!=null?STRING8.getText():null).replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t")
                    		.replace("\\b", "\b").replace("\\f", "\f").replace("\\\"", "\"").replace("\\'", "\'").replace("\\\\", "\\");
                    		retval.inputIsFile = false;
                    		retval.line = (STRING8!=null?STRING8.getLine():0);
                    		

                    }
                    break;
                case 2 :
                    // gUnit.g:100:4: ML_STRING
                    {
                    ML_STRING9=(Token)match(input,ML_STRING,FOLLOW_ML_STRING_in_input210); 

                    		retval.testInput = (ML_STRING9!=null?ML_STRING9.getText():null);
                    		retval.inputIsFile = false;
                    		retval.line = (ML_STRING9!=null?ML_STRING9.getLine():0);
                    		

                    }
                    break;
                case 3 :
                    // gUnit.g:106:4: file
                    {
                    pushFollow(FOLLOW_file_in_input219);
                    file10=file();

                    state._fsp--;


                    		retval.testInput = (file10!=null?input.toString(file10.start,file10.stop):null);
                    		retval.inputIsFile = true;
                    		retval.line = (file10!=null?file10.line:0);
                    		

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end input


    // $ANTLR start output
    // gUnit.g:114:1: output returns [Token token] : ( STRING | ML_STRING | AST | ACTION );
    public final Token output() throws RecognitionException {
        Token token = null;

        Token STRING11=null;
        Token ML_STRING12=null;
        Token AST13=null;
        Token ACTION14=null;

        try {
            // gUnit.g:115:2: ( STRING | ML_STRING | AST | ACTION )
            int alt8=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt8=1;
                }
                break;
            case ML_STRING:
                {
                alt8=2;
                }
                break;
            case AST:
                {
                alt8=3;
                }
                break;
            case ACTION:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // gUnit.g:115:4: STRING
                    {
                    STRING11=(Token)match(input,STRING,FOLLOW_STRING_in_output238); 

                    		STRING11.setText((STRING11!=null?STRING11.getText():null).replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t")
                    		.replace("\\b", "\b").replace("\\f", "\f").replace("\\\"", "\"").replace("\\'", "\'").replace("\\\\", "\\"));
                    		token = STRING11;
                    		

                    }
                    break;
                case 2 :
                    // gUnit.g:121:4: ML_STRING
                    {
                    ML_STRING12=(Token)match(input,ML_STRING,FOLLOW_ML_STRING_in_output248); 
                    token = ML_STRING12;

                    }
                    break;
                case 3 :
                    // gUnit.g:122:4: AST
                    {
                    AST13=(Token)match(input,AST,FOLLOW_AST_in_output255); 
                    token = AST13;

                    }
                    break;
                case 4 :
                    // gUnit.g:123:4: ACTION
                    {
                    ACTION14=(Token)match(input,ACTION,FOLLOW_ACTION_in_output262); 
                    token = ACTION14;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return token;
    }
    // $ANTLR end output

    public static class file_return extends ParserRuleReturnScope {
        public int line;
    };

    // $ANTLR start file
    // gUnit.g:126:1: file returns [int line] : ID ( EXT )? ;
    public final gUnitParser.file_return file() throws RecognitionException {
        gUnitParser.file_return retval = new gUnitParser.file_return();
        retval.start = input.LT(1);

        Token ID15=null;

        try {
            // gUnit.g:127:2: ( ID ( EXT )? )
            // gUnit.g:127:4: ID ( EXT )?
            {
            ID15=(Token)match(input,ID,FOLLOW_ID_in_file280); 
            // gUnit.g:127:7: ( EXT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EXT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // gUnit.g:127:7: EXT
                    {
                    match(input,EXT,FOLLOW_EXT_in_file282); 

                    }
                    break;

            }

            retval.line = (ID15!=null?ID15.getLine():0);

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end file

    // Delegated rules


 

    public static final BitSet FOLLOW_22_in_gUnitDef44 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_gUnitDef48 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_gUnitDef51 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_gUnitDef55 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_gUnitDef59 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_header_in_gUnitDef68 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_suite_in_gUnitDef71 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_25_in_header82 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ACTION_in_header84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_suite109 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_23_in_suite112 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_suite116 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_suite120 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_test_in_suite129 = new BitSet(new long[]{0x0000000000000322L});
    public static final BitSet FOLLOW_input_in_test146 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_test150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_input_in_test157 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_test161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_input_in_test168 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_test170 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RETVAL_in_test172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_input_in_test179 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_test181 = new BitSet(new long[]{0x0000000000000740L});
    public static final BitSet FOLLOW_output_in_test183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_input200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ML_STRING_in_input210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_file_in_input219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_output238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ML_STRING_in_output248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AST_in_output255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_output262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_file280 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_EXT_in_file282 = new BitSet(new long[]{0x0000000000000002L});

}