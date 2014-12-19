// $ANTLR 3.1b1 gUnit.g 2008-05-14 15:52:07
package org.antlr.gunit;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class gUnitLexer extends Lexer {
    public static final int RETVAL=7;
    public static final int AST=10;
    public static final int NESTED_ACTION=17;
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
    public static final int T__27=27;
    public static final int STRING_LITERAL=18;
    public static final int T__24=24;
    public static final int T__26=26;
    public static final int ML_STRING=9;
    public static final int T__25=25;
    public static final int ML_COMMENT=13;
    public static final int SL_COMMENT=12;
    public static final int DOC_COMMENT=4;
    public static final int ID=5;
    public static final int NESTED_RETVAL=15;

    // delegates
    // delegators

    public gUnitLexer() {;} 
    public gUnitLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public gUnitLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "gUnit.g"; }

    // $ANTLR start T__22
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:9:7: ( 'gunit' )
            // gUnit.g:9:9: 'gunit'
            {
            match("gunit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__22

    // $ANTLR start T__23
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:10:7: ( 'walks' )
            // gUnit.g:10:9: 'walks'
            {
            match("walks"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__23

    // $ANTLR start T__24
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:11:7: ( ';' )
            // gUnit.g:11:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__24

    // $ANTLR start T__25
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:12:7: ( '@header' )
            // gUnit.g:12:9: '@header'
            {
            match("@header"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__25

    // $ANTLR start T__26
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:13:7: ( ':' )
            // gUnit.g:13:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__26

    // $ANTLR start T__27
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:14:7: ( 'OK' )
            // gUnit.g:14:9: 'OK'
            {
            match("OK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__27

    // $ANTLR start T__28
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:15:7: ( 'FAIL' )
            // gUnit.g:15:9: 'FAIL'
            {
            match("FAIL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__28

    // $ANTLR start T__29
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:16:7: ( 'returns' )
            // gUnit.g:16:9: 'returns'
            {
            match("returns"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__29

    // $ANTLR start T__30
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:17:7: ( '->' )
            // gUnit.g:17:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end T__30

    // $ANTLR start SL_COMMENT
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:134:3: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n' )
            // gUnit.g:134:5: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // gUnit.g:134:10: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // gUnit.g:134:10: ~ ( '\\r' | '\\n' )
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
            	    break loop1;
                }
            } while (true);

            // gUnit.g:134:24: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // gUnit.g:134:24: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end SL_COMMENT

    // $ANTLR start ML_COMMENT
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:138:2: ( '/*' ( . )* '*/' )
            // gUnit.g:138:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            _channel=HIDDEN;
            // gUnit.g:138:28: ( . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='.')||(LA3_1>='0' && LA3_1<='\uFFFE')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<=')')||(LA3_0>='+' && LA3_0<='\uFFFE')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // gUnit.g:138:28: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:141:8: ( '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // gUnit.g:141:10: '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // gUnit.g:141:14: ( ESC | ~ ( '\\\\' | '\"' ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // gUnit.g:141:16: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // gUnit.g:141:22: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); 
            setText(getText().substring(1, getText().length()-1));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start ML_STRING
    public final void mML_STRING() throws RecognitionException {
        try {
            int _type = ML_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:145:2: ( '<<' ( . )* '>>' )
            // gUnit.g:145:4: '<<' ( . )* '>>'
            {
            match("<<"); 

            // gUnit.g:145:9: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='>') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='>') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='=')||(LA5_1>='?' && LA5_1<='\uFFFE')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='=')||(LA5_0>='?' && LA5_0<='\uFFFE')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // gUnit.g:145:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(">>"); 


            		if ( getText().charAt(2)=='\n' && getText().charAt(getText().length()-3)=='\n' ) {
            			setText(getText().substring(3, getText().length()-3));
            		}
            		else if ( getText().charAt(2)=='\n' ) {
            			setText(getText().substring(3, getText().length()-2));
            		}
            		else if ( getText().charAt(getText().length()-3)=='\n' ) {
            			setText(getText().substring(2, getText().length()-3));
            		}
            		else {
            			setText(getText().substring(2, getText().length()-2));
            		}
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ML_STRING

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:162:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // gUnit.g:162:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // gUnit.g:162:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // gUnit.g:
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
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start EXT
    public final void mEXT() throws RecognitionException {
        try {
            int _type = EXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:164:5: ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
            // gUnit.g:164:7: '.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            {
            match('.'); 
            // gUnit.g:164:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // gUnit.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end EXT

    // $ANTLR start RETVAL
    public final void mRETVAL() throws RecognitionException {
        try {
            int _type = RETVAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:166:8: ( NESTED_RETVAL )
            // gUnit.g:166:10: NESTED_RETVAL
            {
            mNESTED_RETVAL(); 
            setText(getText().substring(1, getText().length()-1));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end RETVAL

    // $ANTLR start NESTED_RETVAL
    public final void mNESTED_RETVAL() throws RecognitionException {
        try {
            // gUnit.g:170:15: ( '[' ( options {greedy=false; } : NESTED_RETVAL | . )* ']' )
            // gUnit.g:171:2: '[' ( options {greedy=false; } : NESTED_RETVAL | . )* ']'
            {
            match('['); 
            // gUnit.g:172:2: ( options {greedy=false; } : NESTED_RETVAL | . )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==']') ) {
                    alt8=3;
                }
                else if ( (LA8_0=='[') ) {
                    alt8=1;
                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='Z')||LA8_0=='\\'||(LA8_0>='^' && LA8_0<='\uFFFE')) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // gUnit.g:173:4: NESTED_RETVAL
            	    {
            	    mNESTED_RETVAL(); 

            	    }
            	    break;
            	case 2 :
            	    // gUnit.g:174:4: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(']'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end NESTED_RETVAL

    // $ANTLR start AST
    public final void mAST() throws RecognitionException {
        try {
            int _type = AST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:179:5: ( NESTED_AST ( ( ' ' )? NESTED_AST )* )
            // gUnit.g:179:7: NESTED_AST ( ( ' ' )? NESTED_AST )*
            {
            mNESTED_AST(); 
            // gUnit.g:179:18: ( ( ' ' )? NESTED_AST )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==' '||LA10_0=='(') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // gUnit.g:179:19: ( ' ' )? NESTED_AST
            	    {
            	    // gUnit.g:179:19: ( ' ' )?
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==' ') ) {
            	        alt9=1;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // gUnit.g:179:19: ' '
            	            {
            	            match(' '); 

            	            }
            	            break;

            	    }

            	    mNESTED_AST(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end AST

    // $ANTLR start NESTED_AST
    public final void mNESTED_AST() throws RecognitionException {
        try {
            // gUnit.g:182:12: ( '(' ( options {greedy=false; } : NESTED_AST | . )* ')' )
            // gUnit.g:183:2: '(' ( options {greedy=false; } : NESTED_AST | . )* ')'
            {
            match('('); 
            // gUnit.g:184:2: ( options {greedy=false; } : NESTED_AST | . )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==')') ) {
                    alt11=3;
                }
                else if ( (LA11_0=='(') ) {
                    alt11=1;
                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='\'')||(LA11_0>='*' && LA11_0<='\uFFFE')) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // gUnit.g:185:4: NESTED_AST
            	    {
            	    mNESTED_AST(); 

            	    }
            	    break;
            	case 2 :
            	    // gUnit.g:186:4: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match(')'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end NESTED_AST

    // $ANTLR start ACTION
    public final void mACTION() throws RecognitionException {
        try {
            int _type = ACTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:192:2: ( NESTED_ACTION )
            // gUnit.g:192:4: NESTED_ACTION
            {
            mNESTED_ACTION(); 
            setText(getText().substring(1, getText().length()-1));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end ACTION

    // $ANTLR start NESTED_ACTION
    public final void mNESTED_ACTION() throws RecognitionException {
        try {
            // gUnit.g:196:15: ( '{' ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )* '}' )
            // gUnit.g:197:2: '{' ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )* '}'
            {
            match('{'); 
            // gUnit.g:198:2: ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )*
            loop12:
            do {
                int alt12=5;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // gUnit.g:199:4: NESTED_ACTION
            	    {
            	    mNESTED_ACTION(); 

            	    }
            	    break;
            	case 2 :
            	    // gUnit.g:200:4: STRING_LITERAL
            	    {
            	    mSTRING_LITERAL(); 

            	    }
            	    break;
            	case 3 :
            	    // gUnit.g:201:4: CHAR_LITERAL
            	    {
            	    mCHAR_LITERAL(); 

            	    }
            	    break;
            	case 4 :
            	    // gUnit.g:202:4: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match('}'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end NESTED_ACTION

    // $ANTLR start CHAR_LITERAL
    public final void mCHAR_LITERAL() throws RecognitionException {
        try {
            // gUnit.g:209:2: ( '\\'' ( ESC | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // gUnit.g:209:4: '\\'' ( ESC | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // gUnit.g:209:9: ( ESC | ~ ( '\\'' | '\\\\' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\\') ) {
                alt13=1;
            }
            else if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFE')) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // gUnit.g:209:11: ESC
                    {
                    mESC(); 

                    }
                    break;
                case 2 :
                    // gUnit.g:209:17: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

        }
        finally {
        }
    }
    // $ANTLR end CHAR_LITERAL

    // $ANTLR start STRING_LITERAL
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            // gUnit.g:214:2: ( '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // gUnit.g:214:4: '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // gUnit.g:214:8: ( ESC | ~ ( '\\\\' | '\"' ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\\') ) {
                    alt14=1;
                }
                else if ( ((LA14_0>='\u0000' && LA14_0<='!')||(LA14_0>='#' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFE')) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // gUnit.g:214:10: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // gUnit.g:214:16: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
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

            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end STRING_LITERAL

    // $ANTLR start ESC
    public final void mESC() throws RecognitionException {
        try {
            // gUnit.g:218:5: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . ) )
            // gUnit.g:218:7: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
            {
            match('\\'); 
            // gUnit.g:219:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )
            int alt15=11;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // gUnit.g:219:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // gUnit.g:220:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // gUnit.g:221:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // gUnit.g:222:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // gUnit.g:223:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // gUnit.g:224:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // gUnit.g:225:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // gUnit.g:226:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // gUnit.g:227:5: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 10 :
                    // gUnit.g:228:5: 'u' XDIGIT XDIGIT XDIGIT XDIGIT
                    {
                    match('u'); 
                    mXDIGIT(); 
                    mXDIGIT(); 
                    mXDIGIT(); 
                    mXDIGIT(); 

                    }
                    break;
                case 11 :
                    // gUnit.g:229:5: .
                    {
                    matchAny(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end ESC

    // $ANTLR start XDIGIT
    public final void mXDIGIT() throws RecognitionException {
        try {
            // gUnit.g:234:8: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // gUnit.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end XDIGIT

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // gUnit.g:240:4: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' )+ )
            // gUnit.g:240:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
            {
            // gUnit.g:240:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=4;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt17=1;
                    }
                    break;
                case '\t':
                    {
                    alt17=2;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt17=3;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // gUnit.g:240:8: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // gUnit.g:241:5: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // gUnit.g:242:5: ( '\\r' )? '\\n'
            	    {
            	    // gUnit.g:242:5: ( '\\r' )?
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0=='\r') ) {
            	        alt16=1;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // gUnit.g:242:5: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // gUnit.g:1:8: ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | SL_COMMENT | ML_COMMENT | STRING | ML_STRING | ID | EXT | RETVAL | AST | ACTION | WS )
        int alt18=19;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // gUnit.g:1:10: T__22
                {
                mT__22(); 

                }
                break;
            case 2 :
                // gUnit.g:1:16: T__23
                {
                mT__23(); 

                }
                break;
            case 3 :
                // gUnit.g:1:22: T__24
                {
                mT__24(); 

                }
                break;
            case 4 :
                // gUnit.g:1:28: T__25
                {
                mT__25(); 

                }
                break;
            case 5 :
                // gUnit.g:1:34: T__26
                {
                mT__26(); 

                }
                break;
            case 6 :
                // gUnit.g:1:40: T__27
                {
                mT__27(); 

                }
                break;
            case 7 :
                // gUnit.g:1:46: T__28
                {
                mT__28(); 

                }
                break;
            case 8 :
                // gUnit.g:1:52: T__29
                {
                mT__29(); 

                }
                break;
            case 9 :
                // gUnit.g:1:58: T__30
                {
                mT__30(); 

                }
                break;
            case 10 :
                // gUnit.g:1:64: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 11 :
                // gUnit.g:1:75: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 12 :
                // gUnit.g:1:86: STRING
                {
                mSTRING(); 

                }
                break;
            case 13 :
                // gUnit.g:1:93: ML_STRING
                {
                mML_STRING(); 

                }
                break;
            case 14 :
                // gUnit.g:1:103: ID
                {
                mID(); 

                }
                break;
            case 15 :
                // gUnit.g:1:106: EXT
                {
                mEXT(); 

                }
                break;
            case 16 :
                // gUnit.g:1:110: RETVAL
                {
                mRETVAL(); 

                }
                break;
            case 17 :
                // gUnit.g:1:117: AST
                {
                mAST(); 

                }
                break;
            case 18 :
                // gUnit.g:1:121: ACTION
                {
                mACTION(); 

                }
                break;
            case 19 :
                // gUnit.g:1:128: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA12_eotS =
        "\116\uffff";
    static final String DFA12_eofS =
        "\116\uffff";
    static final String DFA12_minS =
        "\1\0\2\uffff\2\0\1\uffff\1\0\2\uffff\3\0\1\uffff\2\0\1\uffff\2\0"+
        "\74\uffff";
    static final String DFA12_maxS =
        "\1\ufffe\2\uffff\2\ufffe\1\uffff\1\ufffe\2\uffff\3\ufffe\1\uffff"+
        "\2\ufffe\1\uffff\2\ufffe\74\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\5\1\1\2\uffff\1\4\1\uffff\1\4\1\2\3\uffff\1\4\5\uffff"+
        "\37\2\2\uffff\1\3\5\uffff\1\3\2\uffff\15\3\3\uffff\1\3\1\uffff";
    static final String DFA12_specialS =
        "\116\uffff}>";
    static final String[] DFA12_transitionS = {
            "\42\5\1\3\4\5\1\4\123\5\1\2\1\5\1\1\uff81\5",
            "",
            "",
            "\42\13\1\10\4\13\1\12\64\13\1\6\36\13\1\11\1\13\1\7\uff81\13",
            "\42\21\1\16\4\21\1\5\64\21\1\20\36\21\1\15\1\21\1\14\uff81\21",
            "",
            "\42\36\1\27\4\36\1\30\26\36\1\32\35\36\1\31\5\36\1\25\3\36\1"+
            "\26\7\36\1\22\3\36\1\23\1\36\1\24\1\33\5\36\1\35\1\36\1\34\uff81"+
            "\36",
            "",
            "",
            "\42\44\1\40\4\44\1\41\64\44\1\43\36\44\1\37\1\44\1\42\uff81"+
            "\44",
            "\42\51\1\50\4\51\1\52\64\51\1\45\36\51\1\47\1\51\1\46\uff81"+
            "\51",
            "\42\60\1\55\4\60\1\56\64\60\1\57\36\60\1\54\1\60\1\53\uff81"+
            "\60",
            "",
            "\47\5\1\63\uffd7\5",
            "\47\5\1\71\uffd7\5",
            "",
            "\42\110\1\76\4\110\1\77\26\110\1\106\35\110\1\105\5\110\1\103"+
            "\3\110\1\104\7\110\1\100\3\110\1\101\1\110\1\102\1\107\5\110"+
            "\1\75\1\110\1\74\uff81\110",
            "\47\5\1\114\uffd7\5",
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
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "()* loopback of 198:2: ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )*";
        }
    }
    static final String DFA15_eotS =
        "\12\uffff\1\13\2\uffff";
    static final String DFA15_eofS =
        "\15\uffff";
    static final String DFA15_minS =
        "\1\0\11\uffff\1\60\2\uffff";
    static final String DFA15_maxS =
        "\1\ufffe\11\uffff\1\146\2\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13\1\12";
    static final String DFA15_specialS =
        "\15\uffff}>";
    static final String[] DFA15_transitionS = {
            "\42\13\1\6\4\13\1\7\26\13\1\11\35\13\1\10\5\13\1\4\3\13\1\5"+
            "\7\13\1\1\3\13\1\2\1\13\1\3\1\12\uff89\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\14\7\uffff\6\14\32\uffff\6\14",
            "",
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
            return "219:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | '>' | 'u' XDIGIT XDIGIT XDIGIT XDIGIT | . )";
        }
    }
    static final String DFA18_eotS =
        "\1\uffff\2\15\3\uffff\3\15\12\uffff\2\15\1\34\2\15\2\uffff\2\15"+
        "\1\uffff\4\15\1\45\1\15\1\47\1\50\1\uffff\1\15\2\uffff\1\15\1\53"+
        "\1\uffff";
    static final String DFA18_eofS =
        "\54\uffff";
    static final String DFA18_minS =
        "\1\11\1\165\1\141\3\uffff\1\113\1\101\1\145\1\uffff\1\52\10\uffff"+
        "\1\156\1\154\1\60\1\111\1\164\2\uffff\1\151\1\153\1\uffff\1\114"+
        "\1\165\1\164\1\163\1\60\1\162\2\60\1\uffff\1\156\2\uffff\1\163\1"+
        "\60\1\uffff";
    static final String DFA18_maxS =
        "\1\173\1\165\1\141\3\uffff\1\113\1\101\1\145\1\uffff\1\57\10\uffff"+
        "\1\156\1\154\1\172\1\111\1\164\2\uffff\1\151\1\153\1\uffff\1\114"+
        "\1\165\1\164\1\163\1\172\1\162\2\172\1\uffff\1\156\2\uffff\1\163"+
        "\1\172\1\uffff";
    static final String DFA18_acceptS =
        "\3\uffff\1\3\1\4\1\5\3\uffff\1\11\1\uffff\1\14\1\15\1\16\1\17\1"+
        "\20\1\21\1\22\1\23\5\uffff\1\12\1\13\2\uffff\1\6\10\uffff\1\7\1"+
        "\uffff\1\1\1\2\2\uffff\1\10";
    static final String DFA18_specialS =
        "\54\uffff}>";
    static final String[] DFA18_transitionS = {
            "\2\22\2\uffff\1\22\22\uffff\1\22\1\uffff\1\13\5\uffff\1\20\4"+
            "\uffff\1\11\1\16\1\12\12\uffff\1\5\1\3\1\14\3\uffff\1\4\5\15"+
            "\1\7\10\15\1\6\13\15\1\17\3\uffff\1\15\1\uffff\6\15\1\1\12\15"+
            "\1\10\4\15\1\2\3\15\1\21",
            "\1\23",
            "\1\24",
            "",
            "",
            "",
            "\1\25",
            "\1\26",
            "\1\27",
            "",
            "\1\31\4\uffff\1\30",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\32",
            "\1\33",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\35",
            "\1\36",
            "",
            "",
            "\1\37",
            "\1\40",
            "",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\46",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\1\51",
            "",
            "",
            "\1\52",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | SL_COMMENT | ML_COMMENT | STRING | ML_STRING | ID | EXT | RETVAL | AST | ACTION | WS );";
        }
    }
 

}