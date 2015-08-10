// $ANTLR 3.1 Fcl.g 2014-02-13 11:23:10

package net.sourceforge.jFuzzyLogic.fcl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class FclParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "POINT", "FCL", "VALUE_REAL", "VALUE_ID", "ABS", "ACCU", "ACT", "AND", "ASUM", "BDIF", "BSUM", "COA", "COSINE", "COG", "COGS", "COGF", "COS", "DEFAULT", "DEFUZZIFY", "DMAX", "DMIN", "DSIGM", "EINSTEIN", "END_DEFUZZIFY", "END_FUNCTION_BLOCK", "END_FUZZIFY", "END_RULEBLOCK", "END_VAR", "EXP", "HAMACHER", "FUNCTION", "GAUSS", "GAUSS2", "GBELL", "FUNCTION_BLOCK", "FUZZIFY", "IF", "IS", "LM", "LN", "LOG", "MAX", "METHOD", "MIN", "NIPMIN", "NIPMAX", "MM", "NC", "NOT", "NSUM", "OR", "PROBOR", "PROD", "RANGE", "RM", "RULE", "RULEBLOCK", "SIGM", "SIN", "SINGLETONS", "SUM", "TAN", "TERM", "THEN", "TRAPE", "TRIAN", "TYPE_REAL", "VAR_INPUT", "VAR_OUTPUT", "WITH", "WS", "NEWLINE", "ASSIGN_OPERATOR", "COLON", "COMMA", "DOT", "DOTS", "HAT", "LEFT_CURLY", "LEFT_PARENTHESIS", "MINUS", "PERCENT", "PLUS", "RIGHT_CURLY", "RIGHT_PARENTHESIS", "SEMICOLON", "SLASH", "STAR", "DIGIT", "NUMBER", "LOWER", "UPPER", "LETTER", "ALPHANUM", "REAL", "COMMENT", "COMMENT_C", "COMMENT_SL", "ID"
    };
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
    public static final int TAN=65;
    public static final int LEFT_PARENTHESIS=83;
    public static final int COMMENT=99;
    public static final int GAUSS2=36;
    public static final int NC=51;
    public static final int END_RULEBLOCK=30;
    public static final int VAR_OUTPUT=72;
    public static final int ACT=10;
    public static final int END_DEFUZZIFY=27;
    public static final int RULE=59;
    public static final int NUMBER=93;
    public static final int GBELL=37;
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
    public static final int FUZZIFY=39;
    public static final int END_FUNCTION_BLOCK=28;
    public static final int METHOD=46;
    public static final int GAUSS=35;

    // delegates
    // delegators


        public FclParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public FclParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return FclParser.tokenNames; }
    public String getGrammarFileName() { return "Fcl.g"; }


    public static class main_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main"
    // Fcl.g:167:1: main : f= fcl -> ^( FCL $f) ;
    public final FclParser.main_return main() throws RecognitionException {
        FclParser.main_return retval = new FclParser.main_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.fcl_return f = null;


        RewriteRuleSubtreeStream stream_fcl=new RewriteRuleSubtreeStream(adaptor,"rule fcl");
        try {
            // Fcl.g:167:6: (f= fcl -> ^( FCL $f) )
            // Fcl.g:167:8: f= fcl
            {
            pushFollow(FOLLOW_fcl_in_main2585);
            f=fcl();

            state._fsp--;

            stream_fcl.add(f.getTree());


            // AST REWRITE
            // elements: f
            // token labels: 
            // rule labels: f, retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",f!=null?f.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 167:14: -> ^( FCL $f)
            {
                // Fcl.g:167:17: ^( FCL $f)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FCL, "FCL"), root_1);

                adaptor.addChild(root_1, stream_f.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "main"

    public static class fcl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fcl"
    // Fcl.g:168:1: fcl : ( function_block )+ ;
    public final FclParser.fcl_return fcl() throws RecognitionException {
        FclParser.fcl_return retval = new FclParser.fcl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.function_block_return function_block1 = null;



        try {
            // Fcl.g:168:5: ( ( function_block )+ )
            // Fcl.g:168:7: ( function_block )+
            {
            root_0 = (Object)adaptor.nil();

            // Fcl.g:168:7: ( function_block )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==FUNCTION_BLOCK) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Fcl.g:168:8: function_block
            	    {
            	    pushFollow(FOLLOW_function_block_in_fcl2602);
            	    function_block1=function_block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, function_block1.getTree());

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


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fcl"

    public static class function_block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_block"
    // Fcl.g:171:1: function_block : FUNCTION_BLOCK ( ID )? ( declaration )* END_FUNCTION_BLOCK ;
    public final FclParser.function_block_return function_block() throws RecognitionException {
        FclParser.function_block_return retval = new FclParser.function_block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FUNCTION_BLOCK2=null;
        Token ID3=null;
        Token END_FUNCTION_BLOCK5=null;
        FclParser.declaration_return declaration4 = null;


        Object FUNCTION_BLOCK2_tree=null;
        Object ID3_tree=null;
        Object END_FUNCTION_BLOCK5_tree=null;

        try {
            // Fcl.g:171:16: ( FUNCTION_BLOCK ( ID )? ( declaration )* END_FUNCTION_BLOCK )
            // Fcl.g:171:18: FUNCTION_BLOCK ( ID )? ( declaration )* END_FUNCTION_BLOCK
            {
            root_0 = (Object)adaptor.nil();

            FUNCTION_BLOCK2=(Token)match(input,FUNCTION_BLOCK,FOLLOW_FUNCTION_BLOCK_in_function_block2613); 
            FUNCTION_BLOCK2_tree = (Object)adaptor.create(FUNCTION_BLOCK2);
            root_0 = (Object)adaptor.becomeRoot(FUNCTION_BLOCK2_tree, root_0);

            // Fcl.g:171:34: ( ID )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Fcl.g:171:35: ID
                    {
                    ID3=(Token)match(input,ID,FOLLOW_ID_in_function_block2617); 
                    ID3_tree = (Object)adaptor.create(ID3);
                    adaptor.addChild(root_0, ID3_tree);


                    }
                    break;

            }

            // Fcl.g:171:40: ( declaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==DEFUZZIFY||LA3_0==FUZZIFY||LA3_0==RULEBLOCK||(LA3_0>=VAR_INPUT && LA3_0<=VAR_OUTPUT)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Fcl.g:171:41: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_function_block2622);
            	    declaration4=declaration();

            	    state._fsp--;

            	    adaptor.addChild(root_0, declaration4.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            END_FUNCTION_BLOCK5=(Token)match(input,END_FUNCTION_BLOCK,FOLLOW_END_FUNCTION_BLOCK_in_function_block2626); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_block"

    public static class declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration"
    // Fcl.g:172:1: declaration : ( var_input | var_output | fuzzify_block | defuzzify_block | rule_block );
    public final FclParser.declaration_return declaration() throws RecognitionException {
        FclParser.declaration_return retval = new FclParser.declaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.var_input_return var_input6 = null;

        FclParser.var_output_return var_output7 = null;

        FclParser.fuzzify_block_return fuzzify_block8 = null;

        FclParser.defuzzify_block_return defuzzify_block9 = null;

        FclParser.rule_block_return rule_block10 = null;



        try {
            // Fcl.g:172:13: ( var_input | var_output | fuzzify_block | defuzzify_block | rule_block )
            int alt4=5;
            switch ( input.LA(1) ) {
            case VAR_INPUT:
                {
                alt4=1;
                }
                break;
            case VAR_OUTPUT:
                {
                alt4=2;
                }
                break;
            case FUZZIFY:
                {
                alt4=3;
                }
                break;
            case DEFUZZIFY:
                {
                alt4=4;
                }
                break;
            case RULEBLOCK:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // Fcl.g:172:15: var_input
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_var_input_in_declaration2635);
                    var_input6=var_input();

                    state._fsp--;

                    adaptor.addChild(root_0, var_input6.getTree());

                    }
                    break;
                case 2 :
                    // Fcl.g:172:27: var_output
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_var_output_in_declaration2639);
                    var_output7=var_output();

                    state._fsp--;

                    adaptor.addChild(root_0, var_output7.getTree());

                    }
                    break;
                case 3 :
                    // Fcl.g:172:40: fuzzify_block
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_fuzzify_block_in_declaration2643);
                    fuzzify_block8=fuzzify_block();

                    state._fsp--;

                    adaptor.addChild(root_0, fuzzify_block8.getTree());

                    }
                    break;
                case 4 :
                    // Fcl.g:172:56: defuzzify_block
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_defuzzify_block_in_declaration2647);
                    defuzzify_block9=defuzzify_block();

                    state._fsp--;

                    adaptor.addChild(root_0, defuzzify_block9.getTree());

                    }
                    break;
                case 5 :
                    // Fcl.g:172:74: rule_block
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_rule_block_in_declaration2651);
                    rule_block10=rule_block();

                    state._fsp--;

                    adaptor.addChild(root_0, rule_block10.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaration"

    public static class var_input_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_input"
    // Fcl.g:175:1: var_input : VAR_INPUT ( var_def )* END_VAR ;
    public final FclParser.var_input_return var_input() throws RecognitionException {
        FclParser.var_input_return retval = new FclParser.var_input_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR_INPUT11=null;
        Token END_VAR13=null;
        FclParser.var_def_return var_def12 = null;


        Object VAR_INPUT11_tree=null;
        Object END_VAR13_tree=null;

        try {
            // Fcl.g:175:11: ( VAR_INPUT ( var_def )* END_VAR )
            // Fcl.g:175:13: VAR_INPUT ( var_def )* END_VAR
            {
            root_0 = (Object)adaptor.nil();

            VAR_INPUT11=(Token)match(input,VAR_INPUT,FOLLOW_VAR_INPUT_in_var_input2660); 
            VAR_INPUT11_tree = (Object)adaptor.create(VAR_INPUT11);
            root_0 = (Object)adaptor.becomeRoot(VAR_INPUT11_tree, root_0);

            // Fcl.g:175:24: ( var_def )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Fcl.g:175:25: var_def
            	    {
            	    pushFollow(FOLLOW_var_def_in_var_input2664);
            	    var_def12=var_def();

            	    state._fsp--;

            	    adaptor.addChild(root_0, var_def12.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            END_VAR13=(Token)match(input,END_VAR,FOLLOW_END_VAR_in_var_input2668); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_input"

    public static class var_output_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_output"
    // Fcl.g:176:1: var_output : VAR_OUTPUT ( var_def )+ END_VAR ;
    public final FclParser.var_output_return var_output() throws RecognitionException {
        FclParser.var_output_return retval = new FclParser.var_output_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR_OUTPUT14=null;
        Token END_VAR16=null;
        FclParser.var_def_return var_def15 = null;


        Object VAR_OUTPUT14_tree=null;
        Object END_VAR16_tree=null;

        try {
            // Fcl.g:176:12: ( VAR_OUTPUT ( var_def )+ END_VAR )
            // Fcl.g:176:14: VAR_OUTPUT ( var_def )+ END_VAR
            {
            root_0 = (Object)adaptor.nil();

            VAR_OUTPUT14=(Token)match(input,VAR_OUTPUT,FOLLOW_VAR_OUTPUT_in_var_output2676); 
            VAR_OUTPUT14_tree = (Object)adaptor.create(VAR_OUTPUT14);
            root_0 = (Object)adaptor.becomeRoot(VAR_OUTPUT14_tree, root_0);

            // Fcl.g:176:26: ( var_def )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Fcl.g:176:27: var_def
            	    {
            	    pushFollow(FOLLOW_var_def_in_var_output2680);
            	    var_def15=var_def();

            	    state._fsp--;

            	    adaptor.addChild(root_0, var_def15.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            END_VAR16=(Token)match(input,END_VAR,FOLLOW_END_VAR_in_var_output2684); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_output"

    public static class var_def_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_def"
    // Fcl.g:177:1: var_def : ID COLON data_type SEMICOLON ( range )? ;
    public final FclParser.var_def_return var_def() throws RecognitionException {
        FclParser.var_def_return retval = new FclParser.var_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID17=null;
        Token COLON18=null;
        Token SEMICOLON20=null;
        FclParser.data_type_return data_type19 = null;

        FclParser.range_return range21 = null;


        Object ID17_tree=null;
        Object COLON18_tree=null;
        Object SEMICOLON20_tree=null;

        try {
            // Fcl.g:177:9: ( ID COLON data_type SEMICOLON ( range )? )
            // Fcl.g:177:11: ID COLON data_type SEMICOLON ( range )?
            {
            root_0 = (Object)adaptor.nil();

            ID17=(Token)match(input,ID,FOLLOW_ID_in_var_def2692); 
            ID17_tree = (Object)adaptor.create(ID17);
            root_0 = (Object)adaptor.becomeRoot(ID17_tree, root_0);

            COLON18=(Token)match(input,COLON,FOLLOW_COLON_in_var_def2695); 
            pushFollow(FOLLOW_data_type_in_var_def2698);
            data_type19=data_type();

            state._fsp--;

            adaptor.addChild(root_0, data_type19.getTree());
            SEMICOLON20=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_var_def2700); 
            // Fcl.g:177:43: ( range )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RANGE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Fcl.g:177:44: range
                    {
                    pushFollow(FOLLOW_range_in_var_def2704);
                    range21=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range21.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_def"

    public static class fuzzify_block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fuzzify_block"
    // Fcl.g:180:1: fuzzify_block : FUZZIFY ID ( linguistic_term )* END_FUZZIFY ;
    public final FclParser.fuzzify_block_return fuzzify_block() throws RecognitionException {
        FclParser.fuzzify_block_return retval = new FclParser.fuzzify_block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FUZZIFY22=null;
        Token ID23=null;
        Token END_FUZZIFY25=null;
        FclParser.linguistic_term_return linguistic_term24 = null;


        Object FUZZIFY22_tree=null;
        Object ID23_tree=null;
        Object END_FUZZIFY25_tree=null;

        try {
            // Fcl.g:180:15: ( FUZZIFY ID ( linguistic_term )* END_FUZZIFY )
            // Fcl.g:180:17: FUZZIFY ID ( linguistic_term )* END_FUZZIFY
            {
            root_0 = (Object)adaptor.nil();

            FUZZIFY22=(Token)match(input,FUZZIFY,FOLLOW_FUZZIFY_in_fuzzify_block2716); 
            FUZZIFY22_tree = (Object)adaptor.create(FUZZIFY22);
            root_0 = (Object)adaptor.becomeRoot(FUZZIFY22_tree, root_0);

            ID23=(Token)match(input,ID,FOLLOW_ID_in_fuzzify_block2719); 
            ID23_tree = (Object)adaptor.create(ID23);
            adaptor.addChild(root_0, ID23_tree);

            // Fcl.g:180:29: ( linguistic_term )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==TERM) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Fcl.g:180:30: linguistic_term
            	    {
            	    pushFollow(FOLLOW_linguistic_term_in_fuzzify_block2722);
            	    linguistic_term24=linguistic_term();

            	    state._fsp--;

            	    adaptor.addChild(root_0, linguistic_term24.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            END_FUZZIFY25=(Token)match(input,END_FUZZIFY,FOLLOW_END_FUZZIFY_in_fuzzify_block2726); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fuzzify_block"

    public static class linguistic_term_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "linguistic_term"
    // Fcl.g:181:1: linguistic_term : TERM ID ASSIGN_OPERATOR membership_function SEMICOLON ;
    public final FclParser.linguistic_term_return linguistic_term() throws RecognitionException {
        FclParser.linguistic_term_return retval = new FclParser.linguistic_term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TERM26=null;
        Token ID27=null;
        Token ASSIGN_OPERATOR28=null;
        Token SEMICOLON30=null;
        FclParser.membership_function_return membership_function29 = null;


        Object TERM26_tree=null;
        Object ID27_tree=null;
        Object ASSIGN_OPERATOR28_tree=null;
        Object SEMICOLON30_tree=null;

        try {
            // Fcl.g:181:16: ( TERM ID ASSIGN_OPERATOR membership_function SEMICOLON )
            // Fcl.g:181:18: TERM ID ASSIGN_OPERATOR membership_function SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            TERM26=(Token)match(input,TERM,FOLLOW_TERM_in_linguistic_term2733); 
            TERM26_tree = (Object)adaptor.create(TERM26);
            root_0 = (Object)adaptor.becomeRoot(TERM26_tree, root_0);

            ID27=(Token)match(input,ID,FOLLOW_ID_in_linguistic_term2736); 
            ID27_tree = (Object)adaptor.create(ID27);
            adaptor.addChild(root_0, ID27_tree);

            ASSIGN_OPERATOR28=(Token)match(input,ASSIGN_OPERATOR,FOLLOW_ASSIGN_OPERATOR_in_linguistic_term2738); 
            pushFollow(FOLLOW_membership_function_in_linguistic_term2741);
            membership_function29=membership_function();

            state._fsp--;

            adaptor.addChild(root_0, membership_function29.getTree());
            SEMICOLON30=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_linguistic_term2743); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "linguistic_term"

    public static class membership_function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "membership_function"
    // Fcl.g:182:1: membership_function : ( function | singleton | singletons | piece_wise_linear | gauss | gauss2 | trian | trape | sigm | gbell | cosine | dsigm );
    public final FclParser.membership_function_return membership_function() throws RecognitionException {
        FclParser.membership_function_return retval = new FclParser.membership_function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.function_return function31 = null;

        FclParser.singleton_return singleton32 = null;

        FclParser.singletons_return singletons33 = null;

        FclParser.piece_wise_linear_return piece_wise_linear34 = null;

        FclParser.gauss_return gauss35 = null;

        FclParser.gauss2_return gauss236 = null;

        FclParser.trian_return trian37 = null;

        FclParser.trape_return trape38 = null;

        FclParser.sigm_return sigm39 = null;

        FclParser.gbell_return gbell40 = null;

        FclParser.cosine_return cosine41 = null;

        FclParser.dsigm_return dsigm42 = null;



        try {
            // Fcl.g:182:21: ( function | singleton | singletons | piece_wise_linear | gauss | gauss2 | trian | trape | sigm | gbell | cosine | dsigm )
            int alt9=12;
            switch ( input.LA(1) ) {
            case FUNCTION:
                {
                alt9=1;
                }
                break;
            case REAL:
            case ID:
                {
                alt9=2;
                }
                break;
            case SINGLETONS:
                {
                alt9=3;
                }
                break;
            case LEFT_PARENTHESIS:
                {
                alt9=4;
                }
                break;
            case GAUSS:
                {
                alt9=5;
                }
                break;
            case GAUSS2:
                {
                alt9=6;
                }
                break;
            case TRIAN:
                {
                alt9=7;
                }
                break;
            case TRAPE:
                {
                alt9=8;
                }
                break;
            case SIGM:
                {
                alt9=9;
                }
                break;
            case GBELL:
                {
                alt9=10;
                }
                break;
            case COSINE:
                {
                alt9=11;
                }
                break;
            case DSIGM:
                {
                alt9=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // Fcl.g:182:23: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_membership_function2751);
                    function31=function();

                    state._fsp--;

                    adaptor.addChild(root_0, function31.getTree());

                    }
                    break;
                case 2 :
                    // Fcl.g:182:34: singleton
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_singleton_in_membership_function2755);
                    singleton32=singleton();

                    state._fsp--;

                    adaptor.addChild(root_0, singleton32.getTree());

                    }
                    break;
                case 3 :
                    // Fcl.g:182:46: singletons
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_singletons_in_membership_function2759);
                    singletons33=singletons();

                    state._fsp--;

                    adaptor.addChild(root_0, singletons33.getTree());

                    }
                    break;
                case 4 :
                    // Fcl.g:182:59: piece_wise_linear
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_piece_wise_linear_in_membership_function2763);
                    piece_wise_linear34=piece_wise_linear();

                    state._fsp--;

                    adaptor.addChild(root_0, piece_wise_linear34.getTree());

                    }
                    break;
                case 5 :
                    // Fcl.g:182:79: gauss
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_gauss_in_membership_function2767);
                    gauss35=gauss();

                    state._fsp--;

                    adaptor.addChild(root_0, gauss35.getTree());

                    }
                    break;
                case 6 :
                    // Fcl.g:182:87: gauss2
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_gauss2_in_membership_function2771);
                    gauss236=gauss2();

                    state._fsp--;

                    adaptor.addChild(root_0, gauss236.getTree());

                    }
                    break;
                case 7 :
                    // Fcl.g:182:96: trian
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_trian_in_membership_function2775);
                    trian37=trian();

                    state._fsp--;

                    adaptor.addChild(root_0, trian37.getTree());

                    }
                    break;
                case 8 :
                    // Fcl.g:182:104: trape
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_trape_in_membership_function2779);
                    trape38=trape();

                    state._fsp--;

                    adaptor.addChild(root_0, trape38.getTree());

                    }
                    break;
                case 9 :
                    // Fcl.g:182:112: sigm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_sigm_in_membership_function2783);
                    sigm39=sigm();

                    state._fsp--;

                    adaptor.addChild(root_0, sigm39.getTree());

                    }
                    break;
                case 10 :
                    // Fcl.g:182:119: gbell
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_gbell_in_membership_function2787);
                    gbell40=gbell();

                    state._fsp--;

                    adaptor.addChild(root_0, gbell40.getTree());

                    }
                    break;
                case 11 :
                    // Fcl.g:182:127: cosine
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_cosine_in_membership_function2791);
                    cosine41=cosine();

                    state._fsp--;

                    adaptor.addChild(root_0, cosine41.getTree());

                    }
                    break;
                case 12 :
                    // Fcl.g:182:136: dsigm
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_dsigm_in_membership_function2795);
                    dsigm42=dsigm();

                    state._fsp--;

                    adaptor.addChild(root_0, dsigm42.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "membership_function"

    public static class cosine_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cosine"
    // Fcl.g:183:1: cosine : COSINE atom atom ;
    public final FclParser.cosine_return cosine() throws RecognitionException {
        FclParser.cosine_return retval = new FclParser.cosine_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COSINE43=null;
        FclParser.atom_return atom44 = null;

        FclParser.atom_return atom45 = null;


        Object COSINE43_tree=null;

        try {
            // Fcl.g:183:7: ( COSINE atom atom )
            // Fcl.g:183:9: COSINE atom atom
            {
            root_0 = (Object)adaptor.nil();

            COSINE43=(Token)match(input,COSINE,FOLLOW_COSINE_in_cosine2802); 
            COSINE43_tree = (Object)adaptor.create(COSINE43);
            root_0 = (Object)adaptor.becomeRoot(COSINE43_tree, root_0);

            pushFollow(FOLLOW_atom_in_cosine2805);
            atom44=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom44.getTree());
            pushFollow(FOLLOW_atom_in_cosine2807);
            atom45=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom45.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cosine"

    public static class dsigm_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dsigm"
    // Fcl.g:184:1: dsigm : DSIGM atom atom atom atom ;
    public final FclParser.dsigm_return dsigm() throws RecognitionException {
        FclParser.dsigm_return retval = new FclParser.dsigm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DSIGM46=null;
        FclParser.atom_return atom47 = null;

        FclParser.atom_return atom48 = null;

        FclParser.atom_return atom49 = null;

        FclParser.atom_return atom50 = null;


        Object DSIGM46_tree=null;

        try {
            // Fcl.g:184:6: ( DSIGM atom atom atom atom )
            // Fcl.g:184:8: DSIGM atom atom atom atom
            {
            root_0 = (Object)adaptor.nil();

            DSIGM46=(Token)match(input,DSIGM,FOLLOW_DSIGM_in_dsigm2813); 
            DSIGM46_tree = (Object)adaptor.create(DSIGM46);
            root_0 = (Object)adaptor.becomeRoot(DSIGM46_tree, root_0);

            pushFollow(FOLLOW_atom_in_dsigm2816);
            atom47=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom47.getTree());
            pushFollow(FOLLOW_atom_in_dsigm2818);
            atom48=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom48.getTree());
            pushFollow(FOLLOW_atom_in_dsigm2820);
            atom49=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom49.getTree());
            pushFollow(FOLLOW_atom_in_dsigm2822);
            atom50=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom50.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dsigm"

    public static class gauss_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gauss"
    // Fcl.g:185:1: gauss : GAUSS atom atom ;
    public final FclParser.gauss_return gauss() throws RecognitionException {
        FclParser.gauss_return retval = new FclParser.gauss_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token GAUSS51=null;
        FclParser.atom_return atom52 = null;

        FclParser.atom_return atom53 = null;


        Object GAUSS51_tree=null;

        try {
            // Fcl.g:185:6: ( GAUSS atom atom )
            // Fcl.g:185:8: GAUSS atom atom
            {
            root_0 = (Object)adaptor.nil();

            GAUSS51=(Token)match(input,GAUSS,FOLLOW_GAUSS_in_gauss2828); 
            GAUSS51_tree = (Object)adaptor.create(GAUSS51);
            root_0 = (Object)adaptor.becomeRoot(GAUSS51_tree, root_0);

            pushFollow(FOLLOW_atom_in_gauss2831);
            atom52=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom52.getTree());
            pushFollow(FOLLOW_atom_in_gauss2833);
            atom53=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom53.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gauss"

    public static class gauss2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gauss2"
    // Fcl.g:186:1: gauss2 : GAUSS2 atom atom atom atom ;
    public final FclParser.gauss2_return gauss2() throws RecognitionException {
        FclParser.gauss2_return retval = new FclParser.gauss2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token GAUSS254=null;
        FclParser.atom_return atom55 = null;

        FclParser.atom_return atom56 = null;

        FclParser.atom_return atom57 = null;

        FclParser.atom_return atom58 = null;


        Object GAUSS254_tree=null;

        try {
            // Fcl.g:186:7: ( GAUSS2 atom atom atom atom )
            // Fcl.g:186:9: GAUSS2 atom atom atom atom
            {
            root_0 = (Object)adaptor.nil();

            GAUSS254=(Token)match(input,GAUSS2,FOLLOW_GAUSS2_in_gauss22839); 
            GAUSS254_tree = (Object)adaptor.create(GAUSS254);
            root_0 = (Object)adaptor.becomeRoot(GAUSS254_tree, root_0);

            pushFollow(FOLLOW_atom_in_gauss22842);
            atom55=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom55.getTree());
            pushFollow(FOLLOW_atom_in_gauss22844);
            atom56=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom56.getTree());
            pushFollow(FOLLOW_atom_in_gauss22846);
            atom57=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom57.getTree());
            pushFollow(FOLLOW_atom_in_gauss22848);
            atom58=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom58.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gauss2"

    public static class gbell_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gbell"
    // Fcl.g:187:1: gbell : GBELL atom atom atom ;
    public final FclParser.gbell_return gbell() throws RecognitionException {
        FclParser.gbell_return retval = new FclParser.gbell_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token GBELL59=null;
        FclParser.atom_return atom60 = null;

        FclParser.atom_return atom61 = null;

        FclParser.atom_return atom62 = null;


        Object GBELL59_tree=null;

        try {
            // Fcl.g:187:6: ( GBELL atom atom atom )
            // Fcl.g:187:8: GBELL atom atom atom
            {
            root_0 = (Object)adaptor.nil();

            GBELL59=(Token)match(input,GBELL,FOLLOW_GBELL_in_gbell2854); 
            GBELL59_tree = (Object)adaptor.create(GBELL59);
            root_0 = (Object)adaptor.becomeRoot(GBELL59_tree, root_0);

            pushFollow(FOLLOW_atom_in_gbell2857);
            atom60=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom60.getTree());
            pushFollow(FOLLOW_atom_in_gbell2859);
            atom61=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom61.getTree());
            pushFollow(FOLLOW_atom_in_gbell2861);
            atom62=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom62.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gbell"

    public static class piece_wise_linear_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "piece_wise_linear"
    // Fcl.g:188:1: piece_wise_linear : ( points )+ ;
    public final FclParser.piece_wise_linear_return piece_wise_linear() throws RecognitionException {
        FclParser.piece_wise_linear_return retval = new FclParser.piece_wise_linear_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.points_return points63 = null;



        try {
            // Fcl.g:188:18: ( ( points )+ )
            // Fcl.g:188:20: ( points )+
            {
            root_0 = (Object)adaptor.nil();

            // Fcl.g:188:20: ( points )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==LEFT_PARENTHESIS) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Fcl.g:188:21: points
            	    {
            	    pushFollow(FOLLOW_points_in_piece_wise_linear2868);
            	    points63=points();

            	    state._fsp--;

            	    adaptor.addChild(root_0, points63.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "piece_wise_linear"

    public static class sigm_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sigm"
    // Fcl.g:189:1: sigm : SIGM atom atom ;
    public final FclParser.sigm_return sigm() throws RecognitionException {
        FclParser.sigm_return retval = new FclParser.sigm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SIGM64=null;
        FclParser.atom_return atom65 = null;

        FclParser.atom_return atom66 = null;


        Object SIGM64_tree=null;

        try {
            // Fcl.g:189:5: ( SIGM atom atom )
            // Fcl.g:189:7: SIGM atom atom
            {
            root_0 = (Object)adaptor.nil();

            SIGM64=(Token)match(input,SIGM,FOLLOW_SIGM_in_sigm2876); 
            SIGM64_tree = (Object)adaptor.create(SIGM64);
            root_0 = (Object)adaptor.becomeRoot(SIGM64_tree, root_0);

            pushFollow(FOLLOW_atom_in_sigm2879);
            atom65=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom65.getTree());
            pushFollow(FOLLOW_atom_in_sigm2881);
            atom66=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom66.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sigm"

    public static class singleton_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "singleton"
    // Fcl.g:190:1: singleton : atom ;
    public final FclParser.singleton_return singleton() throws RecognitionException {
        FclParser.singleton_return retval = new FclParser.singleton_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.atom_return atom67 = null;



        try {
            // Fcl.g:190:11: ( atom )
            // Fcl.g:190:13: atom
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atom_in_singleton2888);
            atom67=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom67.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "singleton"

    public static class singletons_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "singletons"
    // Fcl.g:191:1: singletons : SINGLETONS ( points )+ ;
    public final FclParser.singletons_return singletons() throws RecognitionException {
        FclParser.singletons_return retval = new FclParser.singletons_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SINGLETONS68=null;
        FclParser.points_return points69 = null;


        Object SINGLETONS68_tree=null;

        try {
            // Fcl.g:191:11: ( SINGLETONS ( points )+ )
            // Fcl.g:191:13: SINGLETONS ( points )+
            {
            root_0 = (Object)adaptor.nil();

            SINGLETONS68=(Token)match(input,SINGLETONS,FOLLOW_SINGLETONS_in_singletons2894); 
            SINGLETONS68_tree = (Object)adaptor.create(SINGLETONS68);
            root_0 = (Object)adaptor.becomeRoot(SINGLETONS68_tree, root_0);

            // Fcl.g:191:25: ( points )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==LEFT_PARENTHESIS) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Fcl.g:191:26: points
            	    {
            	    pushFollow(FOLLOW_points_in_singletons2898);
            	    points69=points();

            	    state._fsp--;

            	    adaptor.addChild(root_0, points69.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "singletons"

    public static class trape_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trape"
    // Fcl.g:192:1: trape : TRAPE atom atom atom atom ;
    public final FclParser.trape_return trape() throws RecognitionException {
        FclParser.trape_return retval = new FclParser.trape_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TRAPE70=null;
        FclParser.atom_return atom71 = null;

        FclParser.atom_return atom72 = null;

        FclParser.atom_return atom73 = null;

        FclParser.atom_return atom74 = null;


        Object TRAPE70_tree=null;

        try {
            // Fcl.g:192:6: ( TRAPE atom atom atom atom )
            // Fcl.g:192:8: TRAPE atom atom atom atom
            {
            root_0 = (Object)adaptor.nil();

            TRAPE70=(Token)match(input,TRAPE,FOLLOW_TRAPE_in_trape2907); 
            TRAPE70_tree = (Object)adaptor.create(TRAPE70);
            root_0 = (Object)adaptor.becomeRoot(TRAPE70_tree, root_0);

            pushFollow(FOLLOW_atom_in_trape2910);
            atom71=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom71.getTree());
            pushFollow(FOLLOW_atom_in_trape2912);
            atom72=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom72.getTree());
            pushFollow(FOLLOW_atom_in_trape2914);
            atom73=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom73.getTree());
            pushFollow(FOLLOW_atom_in_trape2916);
            atom74=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom74.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "trape"

    public static class trian_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trian"
    // Fcl.g:193:1: trian : TRIAN atom atom atom ;
    public final FclParser.trian_return trian() throws RecognitionException {
        FclParser.trian_return retval = new FclParser.trian_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TRIAN75=null;
        FclParser.atom_return atom76 = null;

        FclParser.atom_return atom77 = null;

        FclParser.atom_return atom78 = null;


        Object TRIAN75_tree=null;

        try {
            // Fcl.g:193:6: ( TRIAN atom atom atom )
            // Fcl.g:193:8: TRIAN atom atom atom
            {
            root_0 = (Object)adaptor.nil();

            TRIAN75=(Token)match(input,TRIAN,FOLLOW_TRIAN_in_trian2922); 
            TRIAN75_tree = (Object)adaptor.create(TRIAN75);
            root_0 = (Object)adaptor.becomeRoot(TRIAN75_tree, root_0);

            pushFollow(FOLLOW_atom_in_trian2925);
            atom76=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom76.getTree());
            pushFollow(FOLLOW_atom_in_trian2927);
            atom77=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom77.getTree());
            pushFollow(FOLLOW_atom_in_trian2929);
            atom78=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom78.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "trian"

    public static class points_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "points"
    // Fcl.g:194:1: points : LEFT_PARENTHESIS x= atom COMMA y= atom RIGHT_PARENTHESIS -> ^( POINT $x $y) ;
    public final FclParser.points_return points() throws RecognitionException {
        FclParser.points_return retval = new FclParser.points_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LEFT_PARENTHESIS79=null;
        Token COMMA80=null;
        Token RIGHT_PARENTHESIS81=null;
        FclParser.atom_return x = null;

        FclParser.atom_return y = null;


        Object LEFT_PARENTHESIS79_tree=null;
        Object COMMA80_tree=null;
        Object RIGHT_PARENTHESIS81_tree=null;
        RewriteRuleTokenStream stream_RIGHT_PARENTHESIS=new RewriteRuleTokenStream(adaptor,"token RIGHT_PARENTHESIS");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LEFT_PARENTHESIS=new RewriteRuleTokenStream(adaptor,"token LEFT_PARENTHESIS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // Fcl.g:194:8: ( LEFT_PARENTHESIS x= atom COMMA y= atom RIGHT_PARENTHESIS -> ^( POINT $x $y) )
            // Fcl.g:194:10: LEFT_PARENTHESIS x= atom COMMA y= atom RIGHT_PARENTHESIS
            {
            LEFT_PARENTHESIS79=(Token)match(input,LEFT_PARENTHESIS,FOLLOW_LEFT_PARENTHESIS_in_points2936);  
            stream_LEFT_PARENTHESIS.add(LEFT_PARENTHESIS79);

            pushFollow(FOLLOW_atom_in_points2940);
            x=atom();

            state._fsp--;

            stream_atom.add(x.getTree());
            COMMA80=(Token)match(input,COMMA,FOLLOW_COMMA_in_points2942);  
            stream_COMMA.add(COMMA80);

            pushFollow(FOLLOW_atom_in_points2946);
            y=atom();

            state._fsp--;

            stream_atom.add(y.getTree());
            RIGHT_PARENTHESIS81=(Token)match(input,RIGHT_PARENTHESIS,FOLLOW_RIGHT_PARENTHESIS_in_points2948);  
            stream_RIGHT_PARENTHESIS.add(RIGHT_PARENTHESIS81);



            // AST REWRITE
            // elements: x, y
            // token labels: 
            // rule labels: retval, y, x
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_y=new RewriteRuleSubtreeStream(adaptor,"token y",y!=null?y.tree:null);
            RewriteRuleSubtreeStream stream_x=new RewriteRuleSubtreeStream(adaptor,"token x",x!=null?x.tree:null);

            root_0 = (Object)adaptor.nil();
            // 194:65: -> ^( POINT $x $y)
            {
                // Fcl.g:194:68: ^( POINT $x $y)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(POINT, "POINT"), root_1);

                adaptor.addChild(root_1, stream_x.nextTree());
                adaptor.addChild(root_1, stream_y.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "points"

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // Fcl.g:195:1: atom : ( real | id );
    public final FclParser.atom_return atom() throws RecognitionException {
        FclParser.atom_return retval = new FclParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.real_return real82 = null;

        FclParser.id_return id83 = null;



        try {
            // Fcl.g:195:6: ( real | id )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==REAL) ) {
                alt12=1;
            }
            else if ( (LA12_0==ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // Fcl.g:195:8: real
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_real_in_atom2967);
                    real82=real();

                    state._fsp--;

                    adaptor.addChild(root_0, real82.getTree());

                    }
                    break;
                case 2 :
                    // Fcl.g:195:15: id
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_id_in_atom2971);
                    id83=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id83.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class id_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id"
    // Fcl.g:196:1: id : x= ID -> ^( VALUE_ID $x) ;
    public final FclParser.id_return id() throws RecognitionException {
        FclParser.id_return retval = new FclParser.id_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token x=null;

        Object x_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // Fcl.g:196:5: (x= ID -> ^( VALUE_ID $x) )
            // Fcl.g:196:7: x= ID
            {
            x=(Token)match(input,ID,FOLLOW_ID_in_id2981);  
            stream_ID.add(x);



            // AST REWRITE
            // elements: x
            // token labels: x
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_x=new RewriteRuleTokenStream(adaptor,"token x",x);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 196:13: -> ^( VALUE_ID $x)
            {
                // Fcl.g:196:16: ^( VALUE_ID $x)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE_ID, "VALUE_ID"), root_1);

                adaptor.addChild(root_1, stream_x.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "id"

    public static class real_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "real"
    // Fcl.g:197:1: real : x= REAL -> ^( VALUE_REAL $x) ;
    public final FclParser.real_return real() throws RecognitionException {
        FclParser.real_return retval = new FclParser.real_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token x=null;

        Object x_tree=null;
        RewriteRuleTokenStream stream_REAL=new RewriteRuleTokenStream(adaptor,"token REAL");

        try {
            // Fcl.g:197:6: (x= REAL -> ^( VALUE_REAL $x) )
            // Fcl.g:197:9: x= REAL
            {
            x=(Token)match(input,REAL,FOLLOW_REAL_in_real3001);  
            stream_REAL.add(x);



            // AST REWRITE
            // elements: x
            // token labels: x
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_x=new RewriteRuleTokenStream(adaptor,"token x",x);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 197:17: -> ^( VALUE_REAL $x)
            {
                // Fcl.g:197:20: ^( VALUE_REAL $x)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE_REAL, "VALUE_REAL"), root_1);

                adaptor.addChild(root_1, stream_x.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "real"

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // Fcl.g:200:1: function : FUNCTION fun_pm ;
    public final FclParser.function_return function() throws RecognitionException {
        FclParser.function_return retval = new FclParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FUNCTION84=null;
        FclParser.fun_pm_return fun_pm85 = null;


        Object FUNCTION84_tree=null;

        try {
            // Fcl.g:200:9: ( FUNCTION fun_pm )
            // Fcl.g:200:11: FUNCTION fun_pm
            {
            root_0 = (Object)adaptor.nil();

            FUNCTION84=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_function3019); 
            FUNCTION84_tree = (Object)adaptor.create(FUNCTION84);
            root_0 = (Object)adaptor.becomeRoot(FUNCTION84_tree, root_0);

            pushFollow(FOLLOW_fun_pm_in_function3022);
            fun_pm85=fun_pm();

            state._fsp--;

            adaptor.addChild(root_0, fun_pm85.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class fun_pm_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fun_pm"
    // Fcl.g:201:1: fun_pm : fun_md ( ( PLUS | MINUS ) fun_md )* ;
    public final FclParser.fun_pm_return fun_pm() throws RecognitionException {
        FclParser.fun_pm_return retval = new FclParser.fun_pm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS87=null;
        Token MINUS88=null;
        FclParser.fun_md_return fun_md86 = null;

        FclParser.fun_md_return fun_md89 = null;


        Object PLUS87_tree=null;
        Object MINUS88_tree=null;

        try {
            // Fcl.g:201:7: ( fun_md ( ( PLUS | MINUS ) fun_md )* )
            // Fcl.g:201:9: fun_md ( ( PLUS | MINUS ) fun_md )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_fun_md_in_fun_pm3028);
            fun_md86=fun_md();

            state._fsp--;

            adaptor.addChild(root_0, fun_md86.getTree());
            // Fcl.g:201:16: ( ( PLUS | MINUS ) fun_md )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==MINUS||LA14_0==PLUS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Fcl.g:201:17: ( PLUS | MINUS ) fun_md
            	    {
            	    // Fcl.g:201:17: ( PLUS | MINUS )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==PLUS) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==MINUS) ) {
            	        alt13=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // Fcl.g:201:18: PLUS
            	            {
            	            PLUS87=(Token)match(input,PLUS,FOLLOW_PLUS_in_fun_pm3032); 
            	            PLUS87_tree = (Object)adaptor.create(PLUS87);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS87_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // Fcl.g:201:26: MINUS
            	            {
            	            MINUS88=(Token)match(input,MINUS,FOLLOW_MINUS_in_fun_pm3037); 
            	            MINUS88_tree = (Object)adaptor.create(MINUS88);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS88_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_fun_md_in_fun_pm3042);
            	    fun_md89=fun_md();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fun_md89.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fun_pm"

    public static class fun_md_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fun_md"
    // Fcl.g:202:1: fun_md : fun_mp ( ( STAR | SLASH ) fun_mp )* ;
    public final FclParser.fun_md_return fun_md() throws RecognitionException {
        FclParser.fun_md_return retval = new FclParser.fun_md_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STAR91=null;
        Token SLASH92=null;
        FclParser.fun_mp_return fun_mp90 = null;

        FclParser.fun_mp_return fun_mp93 = null;


        Object STAR91_tree=null;
        Object SLASH92_tree=null;

        try {
            // Fcl.g:202:7: ( fun_mp ( ( STAR | SLASH ) fun_mp )* )
            // Fcl.g:202:9: fun_mp ( ( STAR | SLASH ) fun_mp )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_fun_mp_in_fun_md3055);
            fun_mp90=fun_mp();

            state._fsp--;

            adaptor.addChild(root_0, fun_mp90.getTree());
            // Fcl.g:202:16: ( ( STAR | SLASH ) fun_mp )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=SLASH && LA16_0<=STAR)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // Fcl.g:202:17: ( STAR | SLASH ) fun_mp
            	    {
            	    // Fcl.g:202:17: ( STAR | SLASH )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==STAR) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==SLASH) ) {
            	        alt15=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // Fcl.g:202:18: STAR
            	            {
            	            STAR91=(Token)match(input,STAR,FOLLOW_STAR_in_fun_md3059); 
            	            STAR91_tree = (Object)adaptor.create(STAR91);
            	            root_0 = (Object)adaptor.becomeRoot(STAR91_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // Fcl.g:202:26: SLASH
            	            {
            	            SLASH92=(Token)match(input,SLASH,FOLLOW_SLASH_in_fun_md3064); 
            	            SLASH92_tree = (Object)adaptor.create(SLASH92);
            	            root_0 = (Object)adaptor.becomeRoot(SLASH92_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_fun_mp_in_fun_md3068);
            	    fun_mp93=fun_mp();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fun_mp93.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fun_md"

    public static class fun_mp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fun_mp"
    // Fcl.g:203:1: fun_mp : fun_atom ( ( HAT | PERCENT ) fun_atom )* ;
    public final FclParser.fun_mp_return fun_mp() throws RecognitionException {
        FclParser.fun_mp_return retval = new FclParser.fun_mp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token HAT95=null;
        Token PERCENT96=null;
        FclParser.fun_atom_return fun_atom94 = null;

        FclParser.fun_atom_return fun_atom97 = null;


        Object HAT95_tree=null;
        Object PERCENT96_tree=null;

        try {
            // Fcl.g:203:8: ( fun_atom ( ( HAT | PERCENT ) fun_atom )* )
            // Fcl.g:203:10: fun_atom ( ( HAT | PERCENT ) fun_atom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_fun_atom_in_fun_mp3082);
            fun_atom94=fun_atom();

            state._fsp--;

            adaptor.addChild(root_0, fun_atom94.getTree());
            // Fcl.g:203:19: ( ( HAT | PERCENT ) fun_atom )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==HAT||LA18_0==PERCENT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Fcl.g:203:20: ( HAT | PERCENT ) fun_atom
            	    {
            	    // Fcl.g:203:20: ( HAT | PERCENT )
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==HAT) ) {
            	        alt17=1;
            	    }
            	    else if ( (LA17_0==PERCENT) ) {
            	        alt17=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // Fcl.g:203:21: HAT
            	            {
            	            HAT95=(Token)match(input,HAT,FOLLOW_HAT_in_fun_mp3086); 
            	            HAT95_tree = (Object)adaptor.create(HAT95);
            	            root_0 = (Object)adaptor.becomeRoot(HAT95_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // Fcl.g:203:28: PERCENT
            	            {
            	            PERCENT96=(Token)match(input,PERCENT,FOLLOW_PERCENT_in_fun_mp3091); 
            	            PERCENT96_tree = (Object)adaptor.create(PERCENT96);
            	            root_0 = (Object)adaptor.becomeRoot(PERCENT96_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_fun_atom_in_fun_mp3095);
            	    fun_atom97=fun_atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fun_atom97.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fun_mp"

    public static class fun_atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fun_atom"
    // Fcl.g:204:1: fun_atom : ( atom | ( EXP | LN | LOG | SIN | COS | TAN | ABS )? LEFT_PARENTHESIS fun_pm RIGHT_PARENTHESIS );
    public final FclParser.fun_atom_return fun_atom() throws RecognitionException {
        FclParser.fun_atom_return retval = new FclParser.fun_atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EXP99=null;
        Token LN100=null;
        Token LOG101=null;
        Token SIN102=null;
        Token COS103=null;
        Token TAN104=null;
        Token ABS105=null;
        Token LEFT_PARENTHESIS106=null;
        Token RIGHT_PARENTHESIS108=null;
        FclParser.atom_return atom98 = null;

        FclParser.fun_pm_return fun_pm107 = null;


        Object EXP99_tree=null;
        Object LN100_tree=null;
        Object LOG101_tree=null;
        Object SIN102_tree=null;
        Object COS103_tree=null;
        Object TAN104_tree=null;
        Object ABS105_tree=null;
        Object LEFT_PARENTHESIS106_tree=null;
        Object RIGHT_PARENTHESIS108_tree=null;

        try {
            // Fcl.g:204:10: ( atom | ( EXP | LN | LOG | SIN | COS | TAN | ABS )? LEFT_PARENTHESIS fun_pm RIGHT_PARENTHESIS )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==REAL||LA20_0==ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==ABS||LA20_0==COS||LA20_0==EXP||(LA20_0>=LN && LA20_0<=LOG)||LA20_0==SIN||LA20_0==TAN||LA20_0==LEFT_PARENTHESIS) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // Fcl.g:204:12: atom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_fun_atom3109);
                    atom98=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom98.getTree());

                    }
                    break;
                case 2 :
                    // Fcl.g:204:19: ( EXP | LN | LOG | SIN | COS | TAN | ABS )? LEFT_PARENTHESIS fun_pm RIGHT_PARENTHESIS
                    {
                    root_0 = (Object)adaptor.nil();

                    // Fcl.g:204:19: ( EXP | LN | LOG | SIN | COS | TAN | ABS )?
                    int alt19=8;
                    switch ( input.LA(1) ) {
                        case EXP:
                            {
                            alt19=1;
                            }
                            break;
                        case LN:
                            {
                            alt19=2;
                            }
                            break;
                        case LOG:
                            {
                            alt19=3;
                            }
                            break;
                        case SIN:
                            {
                            alt19=4;
                            }
                            break;
                        case COS:
                            {
                            alt19=5;
                            }
                            break;
                        case TAN:
                            {
                            alt19=6;
                            }
                            break;
                        case ABS:
                            {
                            alt19=7;
                            }
                            break;
                    }

                    switch (alt19) {
                        case 1 :
                            // Fcl.g:204:20: EXP
                            {
                            EXP99=(Token)match(input,EXP,FOLLOW_EXP_in_fun_atom3114); 
                            EXP99_tree = (Object)adaptor.create(EXP99);
                            root_0 = (Object)adaptor.becomeRoot(EXP99_tree, root_0);


                            }
                            break;
                        case 2 :
                            // Fcl.g:204:25: LN
                            {
                            LN100=(Token)match(input,LN,FOLLOW_LN_in_fun_atom3117); 
                            LN100_tree = (Object)adaptor.create(LN100);
                            root_0 = (Object)adaptor.becomeRoot(LN100_tree, root_0);


                            }
                            break;
                        case 3 :
                            // Fcl.g:204:29: LOG
                            {
                            LOG101=(Token)match(input,LOG,FOLLOW_LOG_in_fun_atom3120); 
                            LOG101_tree = (Object)adaptor.create(LOG101);
                            root_0 = (Object)adaptor.becomeRoot(LOG101_tree, root_0);


                            }
                            break;
                        case 4 :
                            // Fcl.g:204:34: SIN
                            {
                            SIN102=(Token)match(input,SIN,FOLLOW_SIN_in_fun_atom3123); 
                            SIN102_tree = (Object)adaptor.create(SIN102);
                            root_0 = (Object)adaptor.becomeRoot(SIN102_tree, root_0);


                            }
                            break;
                        case 5 :
                            // Fcl.g:204:39: COS
                            {
                            COS103=(Token)match(input,COS,FOLLOW_COS_in_fun_atom3126); 
                            COS103_tree = (Object)adaptor.create(COS103);
                            root_0 = (Object)adaptor.becomeRoot(COS103_tree, root_0);


                            }
                            break;
                        case 6 :
                            // Fcl.g:204:44: TAN
                            {
                            TAN104=(Token)match(input,TAN,FOLLOW_TAN_in_fun_atom3129); 
                            TAN104_tree = (Object)adaptor.create(TAN104);
                            root_0 = (Object)adaptor.becomeRoot(TAN104_tree, root_0);


                            }
                            break;
                        case 7 :
                            // Fcl.g:204:49: ABS
                            {
                            ABS105=(Token)match(input,ABS,FOLLOW_ABS_in_fun_atom3132); 
                            ABS105_tree = (Object)adaptor.create(ABS105);
                            root_0 = (Object)adaptor.becomeRoot(ABS105_tree, root_0);


                            }
                            break;

                    }

                    LEFT_PARENTHESIS106=(Token)match(input,LEFT_PARENTHESIS,FOLLOW_LEFT_PARENTHESIS_in_fun_atom3137); 
                    pushFollow(FOLLOW_fun_pm_in_fun_atom3140);
                    fun_pm107=fun_pm();

                    state._fsp--;

                    adaptor.addChild(root_0, fun_pm107.getTree());
                    RIGHT_PARENTHESIS108=(Token)match(input,RIGHT_PARENTHESIS,FOLLOW_RIGHT_PARENTHESIS_in_fun_atom3142); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fun_atom"

    public static class defuzzify_block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defuzzify_block"
    // Fcl.g:207:1: defuzzify_block : DEFUZZIFY ID ( defuzzify_item )* END_DEFUZZIFY ;
    public final FclParser.defuzzify_block_return defuzzify_block() throws RecognitionException {
        FclParser.defuzzify_block_return retval = new FclParser.defuzzify_block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DEFUZZIFY109=null;
        Token ID110=null;
        Token END_DEFUZZIFY112=null;
        FclParser.defuzzify_item_return defuzzify_item111 = null;


        Object DEFUZZIFY109_tree=null;
        Object ID110_tree=null;
        Object END_DEFUZZIFY112_tree=null;

        try {
            // Fcl.g:207:17: ( DEFUZZIFY ID ( defuzzify_item )* END_DEFUZZIFY )
            // Fcl.g:207:19: DEFUZZIFY ID ( defuzzify_item )* END_DEFUZZIFY
            {
            root_0 = (Object)adaptor.nil();

            DEFUZZIFY109=(Token)match(input,DEFUZZIFY,FOLLOW_DEFUZZIFY_in_defuzzify_block3153); 
            DEFUZZIFY109_tree = (Object)adaptor.create(DEFUZZIFY109);
            root_0 = (Object)adaptor.becomeRoot(DEFUZZIFY109_tree, root_0);

            ID110=(Token)match(input,ID,FOLLOW_ID_in_defuzzify_block3156); 
            ID110_tree = (Object)adaptor.create(ID110);
            adaptor.addChild(root_0, ID110_tree);

            // Fcl.g:207:33: ( defuzzify_item )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==DEFAULT||LA21_0==METHOD||LA21_0==RANGE||LA21_0==TERM) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Fcl.g:207:34: defuzzify_item
            	    {
            	    pushFollow(FOLLOW_defuzzify_item_in_defuzzify_block3159);
            	    defuzzify_item111=defuzzify_item();

            	    state._fsp--;

            	    adaptor.addChild(root_0, defuzzify_item111.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            END_DEFUZZIFY112=(Token)match(input,END_DEFUZZIFY,FOLLOW_END_DEFUZZIFY_in_defuzzify_block3163); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defuzzify_block"

    public static class defuzzify_item_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defuzzify_item"
    // Fcl.g:208:1: defuzzify_item : ( defuzzification_method | default_value | linguistic_term | range );
    public final FclParser.defuzzify_item_return defuzzify_item() throws RecognitionException {
        FclParser.defuzzify_item_return retval = new FclParser.defuzzify_item_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.defuzzification_method_return defuzzification_method113 = null;

        FclParser.default_value_return default_value114 = null;

        FclParser.linguistic_term_return linguistic_term115 = null;

        FclParser.range_return range116 = null;



        try {
            // Fcl.g:208:16: ( defuzzification_method | default_value | linguistic_term | range )
            int alt22=4;
            switch ( input.LA(1) ) {
            case METHOD:
                {
                alt22=1;
                }
                break;
            case DEFAULT:
                {
                alt22=2;
                }
                break;
            case TERM:
                {
                alt22=3;
                }
                break;
            case RANGE:
                {
                alt22=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // Fcl.g:208:18: defuzzification_method
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_defuzzification_method_in_defuzzify_item3171);
                    defuzzification_method113=defuzzification_method();

                    state._fsp--;

                    adaptor.addChild(root_0, defuzzification_method113.getTree());

                    }
                    break;
                case 2 :
                    // Fcl.g:208:43: default_value
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_default_value_in_defuzzify_item3175);
                    default_value114=default_value();

                    state._fsp--;

                    adaptor.addChild(root_0, default_value114.getTree());

                    }
                    break;
                case 3 :
                    // Fcl.g:208:59: linguistic_term
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_linguistic_term_in_defuzzify_item3179);
                    linguistic_term115=linguistic_term();

                    state._fsp--;

                    adaptor.addChild(root_0, linguistic_term115.getTree());

                    }
                    break;
                case 4 :
                    // Fcl.g:208:77: range
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_range_in_defuzzify_item3183);
                    range116=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range116.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defuzzify_item"

    public static class range_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "range"
    // Fcl.g:209:1: range : RANGE ASSIGN_OPERATOR LEFT_PARENTHESIS REAL DOTS REAL RIGHT_PARENTHESIS SEMICOLON ;
    public final FclParser.range_return range() throws RecognitionException {
        FclParser.range_return retval = new FclParser.range_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE117=null;
        Token ASSIGN_OPERATOR118=null;
        Token LEFT_PARENTHESIS119=null;
        Token REAL120=null;
        Token DOTS121=null;
        Token REAL122=null;
        Token RIGHT_PARENTHESIS123=null;
        Token SEMICOLON124=null;

        Object RANGE117_tree=null;
        Object ASSIGN_OPERATOR118_tree=null;
        Object LEFT_PARENTHESIS119_tree=null;
        Object REAL120_tree=null;
        Object DOTS121_tree=null;
        Object REAL122_tree=null;
        Object RIGHT_PARENTHESIS123_tree=null;
        Object SEMICOLON124_tree=null;

        try {
            // Fcl.g:209:7: ( RANGE ASSIGN_OPERATOR LEFT_PARENTHESIS REAL DOTS REAL RIGHT_PARENTHESIS SEMICOLON )
            // Fcl.g:209:9: RANGE ASSIGN_OPERATOR LEFT_PARENTHESIS REAL DOTS REAL RIGHT_PARENTHESIS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            RANGE117=(Token)match(input,RANGE,FOLLOW_RANGE_in_range3190); 
            RANGE117_tree = (Object)adaptor.create(RANGE117);
            root_0 = (Object)adaptor.becomeRoot(RANGE117_tree, root_0);

            ASSIGN_OPERATOR118=(Token)match(input,ASSIGN_OPERATOR,FOLLOW_ASSIGN_OPERATOR_in_range3193); 
            LEFT_PARENTHESIS119=(Token)match(input,LEFT_PARENTHESIS,FOLLOW_LEFT_PARENTHESIS_in_range3196); 
            REAL120=(Token)match(input,REAL,FOLLOW_REAL_in_range3199); 
            REAL120_tree = (Object)adaptor.create(REAL120);
            adaptor.addChild(root_0, REAL120_tree);

            DOTS121=(Token)match(input,DOTS,FOLLOW_DOTS_in_range3201); 
            REAL122=(Token)match(input,REAL,FOLLOW_REAL_in_range3204); 
            REAL122_tree = (Object)adaptor.create(REAL122);
            adaptor.addChild(root_0, REAL122_tree);

            RIGHT_PARENTHESIS123=(Token)match(input,RIGHT_PARENTHESIS,FOLLOW_RIGHT_PARENTHESIS_in_range3206); 
            SEMICOLON124=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_range3209); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "range"

    public static class defuzzification_method_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defuzzification_method"
    // Fcl.g:210:1: defuzzification_method : METHOD COLON ( COG | COGS | COGF | COA | LM | RM | MM ) SEMICOLON ;
    public final FclParser.defuzzification_method_return defuzzification_method() throws RecognitionException {
        FclParser.defuzzification_method_return retval = new FclParser.defuzzification_method_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token METHOD125=null;
        Token COLON126=null;
        Token set127=null;
        Token SEMICOLON128=null;

        Object METHOD125_tree=null;
        Object COLON126_tree=null;
        Object set127_tree=null;
        Object SEMICOLON128_tree=null;

        try {
            // Fcl.g:210:24: ( METHOD COLON ( COG | COGS | COGF | COA | LM | RM | MM ) SEMICOLON )
            // Fcl.g:210:26: METHOD COLON ( COG | COGS | COGF | COA | LM | RM | MM ) SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            METHOD125=(Token)match(input,METHOD,FOLLOW_METHOD_in_defuzzification_method3217); 
            METHOD125_tree = (Object)adaptor.create(METHOD125);
            root_0 = (Object)adaptor.becomeRoot(METHOD125_tree, root_0);

            COLON126=(Token)match(input,COLON,FOLLOW_COLON_in_defuzzification_method3220); 
            set127=(Token)input.LT(1);
            if ( input.LA(1)==COA||(input.LA(1)>=COG && input.LA(1)<=COGF)||input.LA(1)==LM||input.LA(1)==MM||input.LA(1)==RM ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set127));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            SEMICOLON128=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_defuzzification_method3239); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defuzzification_method"

    public static class default_value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "default_value"
    // Fcl.g:211:1: default_value : DEFAULT ASSIGN_OPERATOR ( REAL | NC ) SEMICOLON ;
    public final FclParser.default_value_return default_value() throws RecognitionException {
        FclParser.default_value_return retval = new FclParser.default_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DEFAULT129=null;
        Token ASSIGN_OPERATOR130=null;
        Token set131=null;
        Token SEMICOLON132=null;

        Object DEFAULT129_tree=null;
        Object ASSIGN_OPERATOR130_tree=null;
        Object set131_tree=null;
        Object SEMICOLON132_tree=null;

        try {
            // Fcl.g:211:15: ( DEFAULT ASSIGN_OPERATOR ( REAL | NC ) SEMICOLON )
            // Fcl.g:211:17: DEFAULT ASSIGN_OPERATOR ( REAL | NC ) SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DEFAULT129=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_default_value3247); 
            DEFAULT129_tree = (Object)adaptor.create(DEFAULT129);
            root_0 = (Object)adaptor.becomeRoot(DEFAULT129_tree, root_0);

            ASSIGN_OPERATOR130=(Token)match(input,ASSIGN_OPERATOR,FOLLOW_ASSIGN_OPERATOR_in_default_value3250); 
            set131=(Token)input.LT(1);
            if ( input.LA(1)==NC||input.LA(1)==REAL ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set131));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            SEMICOLON132=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_default_value3261); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "default_value"

    public static class rule_block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule_block"
    // Fcl.g:214:1: rule_block : RULEBLOCK ID ( rule_item )* END_RULEBLOCK ;
    public final FclParser.rule_block_return rule_block() throws RecognitionException {
        FclParser.rule_block_return retval = new FclParser.rule_block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RULEBLOCK133=null;
        Token ID134=null;
        Token END_RULEBLOCK136=null;
        FclParser.rule_item_return rule_item135 = null;


        Object RULEBLOCK133_tree=null;
        Object ID134_tree=null;
        Object END_RULEBLOCK136_tree=null;

        try {
            // Fcl.g:214:12: ( RULEBLOCK ID ( rule_item )* END_RULEBLOCK )
            // Fcl.g:214:14: RULEBLOCK ID ( rule_item )* END_RULEBLOCK
            {
            root_0 = (Object)adaptor.nil();

            RULEBLOCK133=(Token)match(input,RULEBLOCK,FOLLOW_RULEBLOCK_in_rule_block3271); 
            RULEBLOCK133_tree = (Object)adaptor.create(RULEBLOCK133);
            root_0 = (Object)adaptor.becomeRoot(RULEBLOCK133_tree, root_0);

            ID134=(Token)match(input,ID,FOLLOW_ID_in_rule_block3274); 
            ID134_tree = (Object)adaptor.create(ID134);
            adaptor.addChild(root_0, ID134_tree);

            // Fcl.g:214:28: ( rule_item )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=ACCU && LA23_0<=AND)||LA23_0==OR||LA23_0==RULE) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // Fcl.g:214:29: rule_item
            	    {
            	    pushFollow(FOLLOW_rule_item_in_rule_block3277);
            	    rule_item135=rule_item();

            	    state._fsp--;

            	    adaptor.addChild(root_0, rule_item135.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            END_RULEBLOCK136=(Token)match(input,END_RULEBLOCK,FOLLOW_END_RULEBLOCK_in_rule_block3281); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule_block"

    public static class rule_item_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule_item"
    // Fcl.g:215:1: rule_item : ( operator_definition | activation_method | accumulation_method | rule );
    public final FclParser.rule_item_return rule_item() throws RecognitionException {
        FclParser.rule_item_return retval = new FclParser.rule_item_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.operator_definition_return operator_definition137 = null;

        FclParser.activation_method_return activation_method138 = null;

        FclParser.accumulation_method_return accumulation_method139 = null;

        FclParser.rule_return rule140 = null;



        try {
            // Fcl.g:215:11: ( operator_definition | activation_method | accumulation_method | rule )
            int alt24=4;
            switch ( input.LA(1) ) {
            case AND:
            case OR:
                {
                alt24=1;
                }
                break;
            case ACT:
                {
                alt24=2;
                }
                break;
            case ACCU:
                {
                alt24=3;
                }
                break;
            case RULE:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // Fcl.g:215:13: operator_definition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_operator_definition_in_rule_item3289);
                    operator_definition137=operator_definition();

                    state._fsp--;

                    adaptor.addChild(root_0, operator_definition137.getTree());

                    }
                    break;
                case 2 :
                    // Fcl.g:215:35: activation_method
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_activation_method_in_rule_item3293);
                    activation_method138=activation_method();

                    state._fsp--;

                    adaptor.addChild(root_0, activation_method138.getTree());

                    }
                    break;
                case 3 :
                    // Fcl.g:215:55: accumulation_method
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_accumulation_method_in_rule_item3297);
                    accumulation_method139=accumulation_method();

                    state._fsp--;

                    adaptor.addChild(root_0, accumulation_method139.getTree());

                    }
                    break;
                case 4 :
                    // Fcl.g:215:77: rule
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_rule_in_rule_item3301);
                    rule140=rule();

                    state._fsp--;

                    adaptor.addChild(root_0, rule140.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule_item"

    public static class operator_definition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operator_definition"
    // Fcl.g:216:1: operator_definition : ( operator_definition_or | operator_definition_and );
    public final FclParser.operator_definition_return operator_definition() throws RecognitionException {
        FclParser.operator_definition_return retval = new FclParser.operator_definition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        FclParser.operator_definition_or_return operator_definition_or141 = null;

        FclParser.operator_definition_and_return operator_definition_and142 = null;



        try {
            // Fcl.g:216:21: ( operator_definition_or | operator_definition_and )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==OR) ) {
                alt25=1;
            }
            else if ( (LA25_0==AND) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // Fcl.g:216:23: operator_definition_or
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_operator_definition_or_in_operator_definition3308);
                    operator_definition_or141=operator_definition_or();

                    state._fsp--;

                    adaptor.addChild(root_0, operator_definition_or141.getTree());

                    }
                    break;
                case 2 :
                    // Fcl.g:216:48: operator_definition_and
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_operator_definition_and_in_operator_definition3312);
                    operator_definition_and142=operator_definition_and();

                    state._fsp--;

                    adaptor.addChild(root_0, operator_definition_and142.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operator_definition"

    public static class operator_definition_or_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operator_definition_or"
    // Fcl.g:217:1: operator_definition_or : OR COLON ( MAX | ASUM | BSUM | DMAX | NIPMAX | EINSTEIN ) SEMICOLON ;
    public final FclParser.operator_definition_or_return operator_definition_or() throws RecognitionException {
        FclParser.operator_definition_or_return retval = new FclParser.operator_definition_or_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR143=null;
        Token COLON144=null;
        Token set145=null;
        Token SEMICOLON146=null;

        Object OR143_tree=null;
        Object COLON144_tree=null;
        Object set145_tree=null;
        Object SEMICOLON146_tree=null;

        try {
            // Fcl.g:217:24: ( OR COLON ( MAX | ASUM | BSUM | DMAX | NIPMAX | EINSTEIN ) SEMICOLON )
            // Fcl.g:217:26: OR COLON ( MAX | ASUM | BSUM | DMAX | NIPMAX | EINSTEIN ) SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            OR143=(Token)match(input,OR,FOLLOW_OR_in_operator_definition_or3319); 
            OR143_tree = (Object)adaptor.create(OR143);
            root_0 = (Object)adaptor.becomeRoot(OR143_tree, root_0);

            COLON144=(Token)match(input,COLON,FOLLOW_COLON_in_operator_definition_or3322); 
            set145=(Token)input.LT(1);
            if ( input.LA(1)==ASUM||input.LA(1)==BSUM||input.LA(1)==DMAX||input.LA(1)==EINSTEIN||input.LA(1)==MAX||input.LA(1)==NIPMAX ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set145));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            SEMICOLON146=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_operator_definition_or3339); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operator_definition_or"

    public static class operator_definition_and_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operator_definition_and"
    // Fcl.g:218:1: operator_definition_and : AND COLON ( MIN | PROD | BDIF | DMIN | NIPMIN | HAMACHER ) SEMICOLON ;
    public final FclParser.operator_definition_and_return operator_definition_and() throws RecognitionException {
        FclParser.operator_definition_and_return retval = new FclParser.operator_definition_and_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND147=null;
        Token COLON148=null;
        Token set149=null;
        Token SEMICOLON150=null;

        Object AND147_tree=null;
        Object COLON148_tree=null;
        Object set149_tree=null;
        Object SEMICOLON150_tree=null;

        try {
            // Fcl.g:218:25: ( AND COLON ( MIN | PROD | BDIF | DMIN | NIPMIN | HAMACHER ) SEMICOLON )
            // Fcl.g:218:27: AND COLON ( MIN | PROD | BDIF | DMIN | NIPMIN | HAMACHER ) SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            AND147=(Token)match(input,AND,FOLLOW_AND_in_operator_definition_and3347); 
            AND147_tree = (Object)adaptor.create(AND147);
            root_0 = (Object)adaptor.becomeRoot(AND147_tree, root_0);

            COLON148=(Token)match(input,COLON,FOLLOW_COLON_in_operator_definition_and3350); 
            set149=(Token)input.LT(1);
            if ( input.LA(1)==BDIF||input.LA(1)==DMIN||input.LA(1)==HAMACHER||(input.LA(1)>=MIN && input.LA(1)<=NIPMIN)||input.LA(1)==PROD ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set149));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            SEMICOLON150=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_operator_definition_and3367); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operator_definition_and"

    public static class activation_method_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "activation_method"
    // Fcl.g:219:1: activation_method : ACT COLON ( PROD | MIN ) SEMICOLON ;
    public final FclParser.activation_method_return activation_method() throws RecognitionException {
        FclParser.activation_method_return retval = new FclParser.activation_method_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ACT151=null;
        Token COLON152=null;
        Token set153=null;
        Token SEMICOLON154=null;

        Object ACT151_tree=null;
        Object COLON152_tree=null;
        Object set153_tree=null;
        Object SEMICOLON154_tree=null;

        try {
            // Fcl.g:219:19: ( ACT COLON ( PROD | MIN ) SEMICOLON )
            // Fcl.g:219:21: ACT COLON ( PROD | MIN ) SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            ACT151=(Token)match(input,ACT,FOLLOW_ACT_in_activation_method3375); 
            ACT151_tree = (Object)adaptor.create(ACT151);
            root_0 = (Object)adaptor.becomeRoot(ACT151_tree, root_0);

            COLON152=(Token)match(input,COLON,FOLLOW_COLON_in_activation_method3378); 
            set153=(Token)input.LT(1);
            if ( input.LA(1)==MIN||input.LA(1)==PROD ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set153));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            SEMICOLON154=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_activation_method3387); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "activation_method"

    public static class accumulation_method_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "accumulation_method"
    // Fcl.g:220:1: accumulation_method : ACCU COLON ( MAX | BSUM | NSUM | PROBOR | SUM ) SEMICOLON ;
    public final FclParser.accumulation_method_return accumulation_method() throws RecognitionException {
        FclParser.accumulation_method_return retval = new FclParser.accumulation_method_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ACCU155=null;
        Token COLON156=null;
        Token set157=null;
        Token SEMICOLON158=null;

        Object ACCU155_tree=null;
        Object COLON156_tree=null;
        Object set157_tree=null;
        Object SEMICOLON158_tree=null;

        try {
            // Fcl.g:220:21: ( ACCU COLON ( MAX | BSUM | NSUM | PROBOR | SUM ) SEMICOLON )
            // Fcl.g:220:23: ACCU COLON ( MAX | BSUM | NSUM | PROBOR | SUM ) SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            ACCU155=(Token)match(input,ACCU,FOLLOW_ACCU_in_accumulation_method3395); 
            ACCU155_tree = (Object)adaptor.create(ACCU155);
            root_0 = (Object)adaptor.becomeRoot(ACCU155_tree, root_0);

            COLON156=(Token)match(input,COLON,FOLLOW_COLON_in_accumulation_method3398); 
            set157=(Token)input.LT(1);
            if ( input.LA(1)==BSUM||input.LA(1)==MAX||input.LA(1)==NSUM||input.LA(1)==PROBOR||input.LA(1)==SUM ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set157));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            SEMICOLON158=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_accumulation_method3413); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "accumulation_method"

    public static class rule_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule"
    // Fcl.g:221:1: rule : RULE rule_name COLON if_clause then_clause ( with )? SEMICOLON ;
    public final FclParser.rule_return rule() throws RecognitionException {
        FclParser.rule_return retval = new FclParser.rule_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RULE159=null;
        Token COLON161=null;
        Token SEMICOLON165=null;
        FclParser.rule_name_return rule_name160 = null;

        FclParser.if_clause_return if_clause162 = null;

        FclParser.then_clause_return then_clause163 = null;

        FclParser.with_return with164 = null;


        Object RULE159_tree=null;
        Object COLON161_tree=null;
        Object SEMICOLON165_tree=null;

        try {
            // Fcl.g:221:6: ( RULE rule_name COLON if_clause then_clause ( with )? SEMICOLON )
            // Fcl.g:221:8: RULE rule_name COLON if_clause then_clause ( with )? SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            RULE159=(Token)match(input,RULE,FOLLOW_RULE_in_rule3421); 
            RULE159_tree = (Object)adaptor.create(RULE159);
            root_0 = (Object)adaptor.becomeRoot(RULE159_tree, root_0);

            pushFollow(FOLLOW_rule_name_in_rule3424);
            rule_name160=rule_name();

            state._fsp--;

            adaptor.addChild(root_0, rule_name160.getTree());
            COLON161=(Token)match(input,COLON,FOLLOW_COLON_in_rule3426); 
            pushFollow(FOLLOW_if_clause_in_rule3429);
            if_clause162=if_clause();

            state._fsp--;

            adaptor.addChild(root_0, if_clause162.getTree());
            pushFollow(FOLLOW_then_clause_in_rule3431);
            then_clause163=then_clause();

            state._fsp--;

            adaptor.addChild(root_0, then_clause163.getTree());
            // Fcl.g:221:53: ( with )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==WITH) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // Fcl.g:221:54: with
                    {
                    pushFollow(FOLLOW_with_in_rule3434);
                    with164=with();

                    state._fsp--;

                    adaptor.addChild(root_0, with164.getTree());

                    }
                    break;

            }

            SEMICOLON165=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_rule3438); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule"

    public static class rule_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rule_name"
    // Fcl.g:222:1: rule_name : ( ID | REAL );
    public final FclParser.rule_name_return rule_name() throws RecognitionException {
        FclParser.rule_name_return retval = new FclParser.rule_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set166=null;

        Object set166_tree=null;

        try {
            // Fcl.g:222:11: ( ID | REAL )
            // Fcl.g:
            {
            root_0 = (Object)adaptor.nil();

            set166=(Token)input.LT(1);
            if ( input.LA(1)==REAL||input.LA(1)==ID ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set166));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rule_name"

    public static class if_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_clause"
    // Fcl.g:223:1: if_clause : IF condition ;
    public final FclParser.if_clause_return if_clause() throws RecognitionException {
        FclParser.if_clause_return retval = new FclParser.if_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IF167=null;
        FclParser.condition_return condition168 = null;


        Object IF167_tree=null;

        try {
            // Fcl.g:223:11: ( IF condition )
            // Fcl.g:223:13: IF condition
            {
            root_0 = (Object)adaptor.nil();

            IF167=(Token)match(input,IF,FOLLOW_IF_in_if_clause3458); 
            IF167_tree = (Object)adaptor.create(IF167);
            root_0 = (Object)adaptor.becomeRoot(IF167_tree, root_0);

            pushFollow(FOLLOW_condition_in_if_clause3461);
            condition168=condition();

            state._fsp--;

            adaptor.addChild(root_0, condition168.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_clause"

    public static class then_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "then_clause"
    // Fcl.g:224:1: then_clause : THEN conclusion ;
    public final FclParser.then_clause_return then_clause() throws RecognitionException {
        FclParser.then_clause_return retval = new FclParser.then_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token THEN169=null;
        FclParser.conclusion_return conclusion170 = null;


        Object THEN169_tree=null;

        try {
            // Fcl.g:224:13: ( THEN conclusion )
            // Fcl.g:224:15: THEN conclusion
            {
            root_0 = (Object)adaptor.nil();

            THEN169=(Token)match(input,THEN,FOLLOW_THEN_in_then_clause3468); 
            THEN169_tree = (Object)adaptor.create(THEN169);
            root_0 = (Object)adaptor.becomeRoot(THEN169_tree, root_0);

            pushFollow(FOLLOW_conclusion_in_then_clause3471);
            conclusion170=conclusion();

            state._fsp--;

            adaptor.addChild(root_0, conclusion170.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "then_clause"

    public static class condition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condition"
    // Fcl.g:225:1: condition : subcondition ( ( AND | OR ) subcondition )* ;
    public final FclParser.condition_return condition() throws RecognitionException {
        FclParser.condition_return retval = new FclParser.condition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND172=null;
        Token OR173=null;
        FclParser.subcondition_return subcondition171 = null;

        FclParser.subcondition_return subcondition174 = null;


        Object AND172_tree=null;
        Object OR173_tree=null;

        try {
            // Fcl.g:225:11: ( subcondition ( ( AND | OR ) subcondition )* )
            // Fcl.g:225:13: subcondition ( ( AND | OR ) subcondition )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_subcondition_in_condition3478);
            subcondition171=subcondition();

            state._fsp--;

            adaptor.addChild(root_0, subcondition171.getTree());
            // Fcl.g:225:26: ( ( AND | OR ) subcondition )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==AND||LA28_0==OR) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // Fcl.g:225:27: ( AND | OR ) subcondition
            	    {
            	    // Fcl.g:225:27: ( AND | OR )
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==AND) ) {
            	        alt27=1;
            	    }
            	    else if ( (LA27_0==OR) ) {
            	        alt27=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // Fcl.g:225:28: AND
            	            {
            	            AND172=(Token)match(input,AND,FOLLOW_AND_in_condition3482); 
            	            AND172_tree = (Object)adaptor.create(AND172);
            	            root_0 = (Object)adaptor.becomeRoot(AND172_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // Fcl.g:225:33: OR
            	            {
            	            OR173=(Token)match(input,OR,FOLLOW_OR_in_condition3485); 
            	            OR173_tree = (Object)adaptor.create(OR173);
            	            root_0 = (Object)adaptor.becomeRoot(OR173_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_subcondition_in_condition3489);
            	    subcondition174=subcondition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, subcondition174.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "condition"

    public static class subcondition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subcondition"
    // Fcl.g:226:1: subcondition : ( NOT )? ( subcondition_bare | subcondition_paren ) ;
    public final FclParser.subcondition_return subcondition() throws RecognitionException {
        FclParser.subcondition_return retval = new FclParser.subcondition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT175=null;
        FclParser.subcondition_bare_return subcondition_bare176 = null;

        FclParser.subcondition_paren_return subcondition_paren177 = null;


        Object NOT175_tree=null;

        try {
            // Fcl.g:226:14: ( ( NOT )? ( subcondition_bare | subcondition_paren ) )
            // Fcl.g:226:16: ( NOT )? ( subcondition_bare | subcondition_paren )
            {
            root_0 = (Object)adaptor.nil();

            // Fcl.g:226:16: ( NOT )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==NOT) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // Fcl.g:226:17: NOT
                    {
                    NOT175=(Token)match(input,NOT,FOLLOW_NOT_in_subcondition3499); 
                    NOT175_tree = (Object)adaptor.create(NOT175);
                    root_0 = (Object)adaptor.becomeRoot(NOT175_tree, root_0);


                    }
                    break;

            }

            // Fcl.g:226:24: ( subcondition_bare | subcondition_paren )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==ID) ) {
                alt30=1;
            }
            else if ( (LA30_0==LEFT_PARENTHESIS) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // Fcl.g:226:25: subcondition_bare
                    {
                    pushFollow(FOLLOW_subcondition_bare_in_subcondition3505);
                    subcondition_bare176=subcondition_bare();

                    state._fsp--;

                    adaptor.addChild(root_0, subcondition_bare176.getTree());

                    }
                    break;
                case 2 :
                    // Fcl.g:226:45: subcondition_paren
                    {
                    pushFollow(FOLLOW_subcondition_paren_in_subcondition3509);
                    subcondition_paren177=subcondition_paren();

                    state._fsp--;

                    adaptor.addChild(root_0, subcondition_paren177.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subcondition"

    public static class subcondition_bare_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subcondition_bare"
    // Fcl.g:227:1: subcondition_bare : ID ( IS ( NOT )? ID )? ;
    public final FclParser.subcondition_bare_return subcondition_bare() throws RecognitionException {
        FclParser.subcondition_bare_return retval = new FclParser.subcondition_bare_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID178=null;
        Token IS179=null;
        Token NOT180=null;
        Token ID181=null;

        Object ID178_tree=null;
        Object IS179_tree=null;
        Object NOT180_tree=null;
        Object ID181_tree=null;

        try {
            // Fcl.g:227:19: ( ID ( IS ( NOT )? ID )? )
            // Fcl.g:227:21: ID ( IS ( NOT )? ID )?
            {
            root_0 = (Object)adaptor.nil();

            ID178=(Token)match(input,ID,FOLLOW_ID_in_subcondition_bare3517); 
            ID178_tree = (Object)adaptor.create(ID178);
            root_0 = (Object)adaptor.becomeRoot(ID178_tree, root_0);

            // Fcl.g:227:25: ( IS ( NOT )? ID )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IS) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Fcl.g:227:26: IS ( NOT )? ID
                    {
                    IS179=(Token)match(input,IS,FOLLOW_IS_in_subcondition_bare3521); 
                    // Fcl.g:227:30: ( NOT )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==NOT) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // Fcl.g:227:31: NOT
                            {
                            NOT180=(Token)match(input,NOT,FOLLOW_NOT_in_subcondition_bare3525); 
                            NOT180_tree = (Object)adaptor.create(NOT180);
                            adaptor.addChild(root_0, NOT180_tree);


                            }
                            break;

                    }

                    ID181=(Token)match(input,ID,FOLLOW_ID_in_subcondition_bare3529); 
                    ID181_tree = (Object)adaptor.create(ID181);
                    adaptor.addChild(root_0, ID181_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subcondition_bare"

    public static class subcondition_paren_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subcondition_paren"
    // Fcl.g:228:1: subcondition_paren : LEFT_PARENTHESIS condition RIGHT_PARENTHESIS ;
    public final FclParser.subcondition_paren_return subcondition_paren() throws RecognitionException {
        FclParser.subcondition_paren_return retval = new FclParser.subcondition_paren_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LEFT_PARENTHESIS182=null;
        Token RIGHT_PARENTHESIS184=null;
        FclParser.condition_return condition183 = null;


        Object LEFT_PARENTHESIS182_tree=null;
        Object RIGHT_PARENTHESIS184_tree=null;

        try {
            // Fcl.g:228:20: ( LEFT_PARENTHESIS condition RIGHT_PARENTHESIS )
            // Fcl.g:228:22: LEFT_PARENTHESIS condition RIGHT_PARENTHESIS
            {
            root_0 = (Object)adaptor.nil();

            LEFT_PARENTHESIS182=(Token)match(input,LEFT_PARENTHESIS,FOLLOW_LEFT_PARENTHESIS_in_subcondition_paren3539); 
            LEFT_PARENTHESIS182_tree = (Object)adaptor.create(LEFT_PARENTHESIS182);
            root_0 = (Object)adaptor.becomeRoot(LEFT_PARENTHESIS182_tree, root_0);

            pushFollow(FOLLOW_condition_in_subcondition_paren3542);
            condition183=condition();

            state._fsp--;

            adaptor.addChild(root_0, condition183.getTree());
            RIGHT_PARENTHESIS184=(Token)match(input,RIGHT_PARENTHESIS,FOLLOW_RIGHT_PARENTHESIS_in_subcondition_paren3544); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subcondition_paren"

    public static class conclusion_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conclusion"
    // Fcl.g:229:1: conclusion : sub_conclusion ( COMMA sub_conclusion )* ;
    public final FclParser.conclusion_return conclusion() throws RecognitionException {
        FclParser.conclusion_return retval = new FclParser.conclusion_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA186=null;
        FclParser.sub_conclusion_return sub_conclusion185 = null;

        FclParser.sub_conclusion_return sub_conclusion187 = null;


        Object COMMA186_tree=null;

        try {
            // Fcl.g:229:12: ( sub_conclusion ( COMMA sub_conclusion )* )
            // Fcl.g:229:14: sub_conclusion ( COMMA sub_conclusion )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sub_conclusion_in_conclusion3552);
            sub_conclusion185=sub_conclusion();

            state._fsp--;

            adaptor.addChild(root_0, sub_conclusion185.getTree());
            // Fcl.g:229:29: ( COMMA sub_conclusion )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==COMMA) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Fcl.g:229:30: COMMA sub_conclusion
            	    {
            	    COMMA186=(Token)match(input,COMMA,FOLLOW_COMMA_in_conclusion3555); 
            	    pushFollow(FOLLOW_sub_conclusion_in_conclusion3558);
            	    sub_conclusion187=sub_conclusion();

            	    state._fsp--;

            	    adaptor.addChild(root_0, sub_conclusion187.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conclusion"

    public static class sub_conclusion_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sub_conclusion"
    // Fcl.g:230:1: sub_conclusion : ID IS ID ;
    public final FclParser.sub_conclusion_return sub_conclusion() throws RecognitionException {
        FclParser.sub_conclusion_return retval = new FclParser.sub_conclusion_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID188=null;
        Token IS189=null;
        Token ID190=null;

        Object ID188_tree=null;
        Object IS189_tree=null;
        Object ID190_tree=null;

        try {
            // Fcl.g:230:16: ( ID IS ID )
            // Fcl.g:230:18: ID IS ID
            {
            root_0 = (Object)adaptor.nil();

            ID188=(Token)match(input,ID,FOLLOW_ID_in_sub_conclusion3567); 
            ID188_tree = (Object)adaptor.create(ID188);
            root_0 = (Object)adaptor.becomeRoot(ID188_tree, root_0);

            IS189=(Token)match(input,IS,FOLLOW_IS_in_sub_conclusion3570); 
            ID190=(Token)match(input,ID,FOLLOW_ID_in_sub_conclusion3573); 
            ID190_tree = (Object)adaptor.create(ID190);
            adaptor.addChild(root_0, ID190_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sub_conclusion"

    public static class with_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "with"
    // Fcl.g:231:1: with : WITH REAL ;
    public final FclParser.with_return with() throws RecognitionException {
        FclParser.with_return retval = new FclParser.with_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WITH191=null;
        Token REAL192=null;

        Object WITH191_tree=null;
        Object REAL192_tree=null;

        try {
            // Fcl.g:231:5: ( WITH REAL )
            // Fcl.g:231:7: WITH REAL
            {
            root_0 = (Object)adaptor.nil();

            WITH191=(Token)match(input,WITH,FOLLOW_WITH_in_with3579); 
            WITH191_tree = (Object)adaptor.create(WITH191);
            root_0 = (Object)adaptor.becomeRoot(WITH191_tree, root_0);

            REAL192=(Token)match(input,REAL,FOLLOW_REAL_in_with3582); 
            REAL192_tree = (Object)adaptor.create(REAL192);
            adaptor.addChild(root_0, REAL192_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "with"

    public static class data_type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "data_type"
    // Fcl.g:234:1: data_type : TYPE_REAL ;
    public final FclParser.data_type_return data_type() throws RecognitionException {
        FclParser.data_type_return retval = new FclParser.data_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TYPE_REAL193=null;

        Object TYPE_REAL193_tree=null;

        try {
            // Fcl.g:234:11: ( TYPE_REAL )
            // Fcl.g:234:13: TYPE_REAL
            {
            root_0 = (Object)adaptor.nil();

            TYPE_REAL193=(Token)match(input,TYPE_REAL,FOLLOW_TYPE_REAL_in_data_type3591); 
            TYPE_REAL193_tree = (Object)adaptor.create(TYPE_REAL193);
            adaptor.addChild(root_0, TYPE_REAL193_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "data_type"

    // Delegated rules


 

    public static final BitSet FOLLOW_fcl_in_main2585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_block_in_fcl2602 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_FUNCTION_BLOCK_in_function_block2613 = new BitSet(new long[]{0x1000008010400000L,0x0000004000000180L});
    public static final BitSet FOLLOW_ID_in_function_block2617 = new BitSet(new long[]{0x1000008010400000L,0x0000000000000180L});
    public static final BitSet FOLLOW_declaration_in_function_block2622 = new BitSet(new long[]{0x1000008010400000L,0x0000000000000180L});
    public static final BitSet FOLLOW_END_FUNCTION_BLOCK_in_function_block2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_input_in_declaration2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_output_in_declaration2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fuzzify_block_in_declaration2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defuzzify_block_in_declaration2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_block_in_declaration2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_INPUT_in_var_input2660 = new BitSet(new long[]{0x0000000080000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_var_def_in_var_input2664 = new BitSet(new long[]{0x0000000080000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_END_VAR_in_var_input2668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_OUTPUT_in_var_output2676 = new BitSet(new long[]{0x0000000080000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_var_def_in_var_output2680 = new BitSet(new long[]{0x0000000080000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_END_VAR_in_var_output2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_var_def2692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_var_def2695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_data_type_in_var_def2698 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_var_def2700 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_range_in_var_def2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUZZIFY_in_fuzzify_block2716 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_fuzzify_block2719 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_linguistic_term_in_fuzzify_block2722 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_END_FUZZIFY_in_fuzzify_block2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TERM_in_linguistic_term2733 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_linguistic_term2736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_ASSIGN_OPERATOR_in_linguistic_term2738 = new BitSet(new long[]{0xA000003C02010000L,0x0000004400080030L});
    public static final BitSet FOLLOW_membership_function_in_linguistic_term2741 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_linguistic_term2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_membership_function2751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleton_in_membership_function2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singletons_in_membership_function2759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_piece_wise_linear_in_membership_function2763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gauss_in_membership_function2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gauss2_in_membership_function2771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trian_in_membership_function2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trape_in_membership_function2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sigm_in_membership_function2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gbell_in_membership_function2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cosine_in_membership_function2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dsigm_in_membership_function2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COSINE_in_cosine2802 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_cosine2805 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_cosine2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DSIGM_in_dsigm2813 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_dsigm2816 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_dsigm2818 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_dsigm2820 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_dsigm2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GAUSS_in_gauss2828 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gauss2831 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gauss2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GAUSS2_in_gauss22839 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gauss22842 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gauss22844 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gauss22846 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gauss22848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GBELL_in_gbell2854 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gbell2857 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gbell2859 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_gbell2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_points_in_piece_wise_linear2868 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_SIGM_in_sigm2876 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_sigm2879 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_sigm2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_singleton2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLETONS_in_singletons2894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_points_in_singletons2898 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_TRAPE_in_trape2907 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_trape2910 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_trape2912 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_trape2914 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_trape2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRIAN_in_trian2922 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_trian2925 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_trian2927 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_trian2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PARENTHESIS_in_points2936 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_points2940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_COMMA_in_points2942 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_atom_in_points2946 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RIGHT_PARENTHESIS_in_points2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_real_in_atom2967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_atom2971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_id2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_real3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function3019 = new BitSet(new long[]{0x4000180100100100L,0x0000004400080002L});
    public static final BitSet FOLLOW_fun_pm_in_function3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fun_md_in_fun_pm3028 = new BitSet(new long[]{0x0000000000000002L,0x0000000000500000L});
    public static final BitSet FOLLOW_PLUS_in_fun_pm3032 = new BitSet(new long[]{0x4000180100100100L,0x0000004400080002L});
    public static final BitSet FOLLOW_MINUS_in_fun_pm3037 = new BitSet(new long[]{0x4000180100100100L,0x0000004400080002L});
    public static final BitSet FOLLOW_fun_md_in_fun_pm3042 = new BitSet(new long[]{0x0000000000000002L,0x0000000000500000L});
    public static final BitSet FOLLOW_fun_mp_in_fun_md3055 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_STAR_in_fun_md3059 = new BitSet(new long[]{0x4000180100100100L,0x0000004400080002L});
    public static final BitSet FOLLOW_SLASH_in_fun_md3064 = new BitSet(new long[]{0x4000180100100100L,0x0000004400080002L});
    public static final BitSet FOLLOW_fun_mp_in_fun_md3068 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_fun_atom_in_fun_mp3082 = new BitSet(new long[]{0x0000000000000002L,0x0000000000220000L});
    public static final BitSet FOLLOW_HAT_in_fun_mp3086 = new BitSet(new long[]{0x4000180100100100L,0x0000004400080002L});
    public static final BitSet FOLLOW_PERCENT_in_fun_mp3091 = new BitSet(new long[]{0x4000180100100100L,0x0000004400080002L});
    public static final BitSet FOLLOW_fun_atom_in_fun_mp3095 = new BitSet(new long[]{0x0000000000000002L,0x0000000000220000L});
    public static final BitSet FOLLOW_atom_in_fun_atom3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXP_in_fun_atom3114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_LN_in_fun_atom3117 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_LOG_in_fun_atom3120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_SIN_in_fun_atom3123 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_COS_in_fun_atom3126 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_TAN_in_fun_atom3129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_ABS_in_fun_atom3132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_LEFT_PARENTHESIS_in_fun_atom3137 = new BitSet(new long[]{0x4000180100100100L,0x0000004400080002L});
    public static final BitSet FOLLOW_fun_pm_in_fun_atom3140 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RIGHT_PARENTHESIS_in_fun_atom3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFUZZIFY_in_defuzzify_block3153 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_defuzzify_block3156 = new BitSet(new long[]{0x0200400028200000L,0x0000000000000004L});
    public static final BitSet FOLLOW_defuzzify_item_in_defuzzify_block3159 = new BitSet(new long[]{0x0200400028200000L,0x0000000000000004L});
    public static final BitSet FOLLOW_END_DEFUZZIFY_in_defuzzify_block3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defuzzification_method_in_defuzzify_item3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_default_value_in_defuzzify_item3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linguistic_term_in_defuzzify_item3179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_defuzzify_item3183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_range3190 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_ASSIGN_OPERATOR_in_range3193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_LEFT_PARENTHESIS_in_range3196 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_REAL_in_range3199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_DOTS_in_range3201 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_REAL_in_range3204 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RIGHT_PARENTHESIS_in_range3206 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_range3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METHOD_in_defuzzification_method3217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_defuzzification_method3220 = new BitSet(new long[]{0x04040400000E8000L});
    public static final BitSet FOLLOW_set_in_defuzzification_method3223 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_defuzzification_method3239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_default_value3247 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_ASSIGN_OPERATOR_in_default_value3250 = new BitSet(new long[]{0x0008000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_set_in_default_value3253 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_default_value3261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULEBLOCK_in_rule_block3271 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_rule_block3274 = new BitSet(new long[]{0x0840000040000E00L});
    public static final BitSet FOLLOW_rule_item_in_rule_block3277 = new BitSet(new long[]{0x0840000040000E00L});
    public static final BitSet FOLLOW_END_RULEBLOCK_in_rule_block3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_definition_in_rule_item3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_activation_method_in_rule_item3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accumulation_method_in_rule_item3297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_rule_item3301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_definition_or_in_operator_definition3308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_definition_and_in_operator_definition3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_operator_definition_or3319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_operator_definition_or3322 = new BitSet(new long[]{0x0002200004805000L});
    public static final BitSet FOLLOW_set_in_operator_definition_or3325 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_operator_definition_or3339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_operator_definition_and3347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_operator_definition_and3350 = new BitSet(new long[]{0x0101800201002000L});
    public static final BitSet FOLLOW_set_in_operator_definition_and3353 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_operator_definition_and3367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACT_in_activation_method3375 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_activation_method3378 = new BitSet(new long[]{0x0100800000000000L});
    public static final BitSet FOLLOW_set_in_activation_method3381 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_activation_method3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACCU_in_accumulation_method3395 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_accumulation_method3398 = new BitSet(new long[]{0x00A0200000004000L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_accumulation_method3401 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_accumulation_method3413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_rule3421 = new BitSet(new long[]{0x0000000000000000L,0x0000004400000000L});
    public static final BitSet FOLLOW_rule_name_in_rule3424 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_rule3426 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_if_clause_in_rule3429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_then_clause_in_rule3431 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000200L});
    public static final BitSet FOLLOW_with_in_rule3434 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_rule3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_rule_name0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_clause3458 = new BitSet(new long[]{0x0010000000000000L,0x0000004000080000L});
    public static final BitSet FOLLOW_condition_in_if_clause3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THEN_in_then_clause3468 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_conclusion_in_then_clause3471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subcondition_in_condition3478 = new BitSet(new long[]{0x0040000000000802L});
    public static final BitSet FOLLOW_AND_in_condition3482 = new BitSet(new long[]{0x0010000000000000L,0x0000004000080000L});
    public static final BitSet FOLLOW_OR_in_condition3485 = new BitSet(new long[]{0x0010000000000000L,0x0000004000080000L});
    public static final BitSet FOLLOW_subcondition_in_condition3489 = new BitSet(new long[]{0x0040000000000802L});
    public static final BitSet FOLLOW_NOT_in_subcondition3499 = new BitSet(new long[]{0x0010000000000000L,0x0000004000080000L});
    public static final BitSet FOLLOW_subcondition_bare_in_subcondition3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subcondition_paren_in_subcondition3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_subcondition_bare3517 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_IS_in_subcondition_bare3521 = new BitSet(new long[]{0x0010000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_NOT_in_subcondition_bare3525 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_subcondition_bare3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_PARENTHESIS_in_subcondition_paren3539 = new BitSet(new long[]{0x0010000000000000L,0x0000004000080000L});
    public static final BitSet FOLLOW_condition_in_subcondition_paren3542 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RIGHT_PARENTHESIS_in_subcondition_paren3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sub_conclusion_in_conclusion3552 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_COMMA_in_conclusion3555 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_sub_conclusion_in_conclusion3558 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_ID_in_sub_conclusion3567 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_IS_in_sub_conclusion3570 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_ID_in_sub_conclusion3573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_with3579 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_REAL_in_with3582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_REAL_in_data_type3591 = new BitSet(new long[]{0x0000000000000002L});

}