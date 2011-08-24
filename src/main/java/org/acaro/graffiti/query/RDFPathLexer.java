package org.acaro.graffiti.query;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class RDFPathLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUERY=4;
    public static final int LOCATIONSTEP=5;
    public static final int CONDITION=6;
    public static final int FILTER=7;
    public static final int FILTERFUNCTION=8;
    public static final int SUBQUERY=9;
    public static final int REPEAT=10;
    public static final int SHORTESTPATH=11;
    public static final int ENDNODEFUNCTION=12;
    public static final int STARTNODE=13;
    public static final int EDGE=14;
    public static final int STRING=15;
    public static final int INTVALUE=16;
    public static final int TEXTVALUE=17;
    public static final int WS=18;

    // delegates
    // delegators

    public RDFPathLexer() {;} 
    public RDFPathLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RDFPathLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:3:7: ( '::' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:3:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:4:7: ( '>' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:4:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:5:7: ( '.' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:5:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:6:7: ( '[' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:6:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:7:7: ( ']' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:7:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:8:7: ( 'EQUALS(' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:8:9: 'EQUALS('
            {
            match("EQUALS("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:9:7: ( ')' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:9:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:10:7: ( 'SUFFIX(' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:10:9: 'SUFFIX('
            {
            match("SUFFIX("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:11:7: ( 'PREFIX(' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:11:9: 'PREFIX('
            {
            match("PREFIX("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:12:7: ( 'MIN(' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:12:9: 'MIN('
            {
            match("MIN("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:13:7: ( 'MAX(' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:13:9: 'MAX('
            {
            match("MAX("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:14:7: ( '=' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:14:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:15:7: ( '(' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:16:7: ( '(*' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:16:9: '(*'
            {
            match("(*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:17:7: ( 'COUNT()' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:17:9: 'COUNT()'
            {
            match("COUNT()"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:18:7: ( 'SUM()' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:18:9: 'SUM()'
            {
            match("SUM()"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:19:7: ( 'AVG()' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:19:9: 'AVG()'
            {
            match("AVG()"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:20:7: ( 'MIN()' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:20:9: 'MIN()'
            {
            match("MIN()"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:21:7: ( 'MAX()' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:21:9: 'MAX()'
            {
            match("MAX()"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:22:7: ( 'DISTANCE(' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:22:9: 'DISTANCE('
            {
            match("DISTANCE("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:23:7: ( '*' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:23:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "TEXTVALUE"
    public final void mTEXTVALUE() throws RecognitionException {
        try {
            int _type = TEXTVALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:90:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:90:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:90:23: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:
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
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXTVALUE"

    // $ANTLR start "INTVALUE"
    public final void mINTVALUE() throws RecognitionException {
        try {
            int _type = INTVALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:94:2: ( ( '0' .. '9' )+ )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:94:4: ( '0' .. '9' )+
            {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:94:4: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:94:5: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTVALUE"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:98:2: ( '\\'' TEXTVALUE '\\'' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:98:4: '\\'' TEXTVALUE '\\''
            {
            match('\''); 
            mTEXTVALUE(); 
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:102:2: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:102:4: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | TEXTVALUE | INTVALUE | STRING | WS )
        int alt3=25;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:10: T__19
                {
                mT__19(); 

                }
                break;
            case 2 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:16: T__20
                {
                mT__20(); 

                }
                break;
            case 3 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:22: T__21
                {
                mT__21(); 

                }
                break;
            case 4 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:28: T__22
                {
                mT__22(); 

                }
                break;
            case 5 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:34: T__23
                {
                mT__23(); 

                }
                break;
            case 6 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:40: T__24
                {
                mT__24(); 

                }
                break;
            case 7 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:46: T__25
                {
                mT__25(); 

                }
                break;
            case 8 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:52: T__26
                {
                mT__26(); 

                }
                break;
            case 9 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:58: T__27
                {
                mT__27(); 

                }
                break;
            case 10 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:64: T__28
                {
                mT__28(); 

                }
                break;
            case 11 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:70: T__29
                {
                mT__29(); 

                }
                break;
            case 12 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:76: T__30
                {
                mT__30(); 

                }
                break;
            case 13 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:82: T__31
                {
                mT__31(); 

                }
                break;
            case 14 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:88: T__32
                {
                mT__32(); 

                }
                break;
            case 15 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:94: T__33
                {
                mT__33(); 

                }
                break;
            case 16 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:100: T__34
                {
                mT__34(); 

                }
                break;
            case 17 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:106: T__35
                {
                mT__35(); 

                }
                break;
            case 18 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:112: T__36
                {
                mT__36(); 

                }
                break;
            case 19 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:118: T__37
                {
                mT__37(); 

                }
                break;
            case 20 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:124: T__38
                {
                mT__38(); 

                }
                break;
            case 21 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:130: T__39
                {
                mT__39(); 

                }
                break;
            case 22 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:136: TEXTVALUE
                {
                mTEXTVALUE(); 

                }
                break;
            case 23 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:146: INTVALUE
                {
                mINTVALUE(); 

                }
                break;
            case 24 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:155: STRING
                {
                mSTRING(); 

                }
                break;
            case 25 :
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:1:162: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\6\uffff\1\21\1\uffff\3\21\1\uffff\1\33\3\21\5\uffff\5\21\2\uffff"+
        "\16\21\1\uffff\1\21\1\65\1\67\1\21\1\uffff\4\21\4\uffff\5\21\1\uffff"+
        "\1\21\3\uffff\2\21\1\uffff";
    static final String DFA3_eofS =
        "\105\uffff";
    static final String DFA3_minS =
        "\1\11\5\uffff\1\121\1\uffff\1\125\1\122\1\101\1\uffff\1\52\1\117"+
        "\1\126\1\111\5\uffff\1\125\1\106\1\105\1\116\1\130\2\uffff\1\125"+
        "\1\107\1\123\1\101\1\106\1\50\1\106\2\50\1\116\1\50\1\124\1\114"+
        "\1\111\1\uffff\1\111\2\51\1\124\1\uffff\1\101\1\123\2\130\4\uffff"+
        "\1\50\1\116\3\50\1\uffff\1\103\3\uffff\1\105\1\50\1\uffff";
    static final String DFA3_maxS =
        "\1\172\5\uffff\1\121\1\uffff\1\125\1\122\1\111\1\uffff\1\52\1\117"+
        "\1\126\1\111\5\uffff\1\125\1\115\1\105\1\116\1\130\2\uffff\1\125"+
        "\1\107\1\123\1\101\1\106\1\50\1\106\2\50\1\116\1\50\1\124\1\114"+
        "\1\111\1\uffff\1\111\2\51\1\124\1\uffff\1\101\1\123\2\130\4\uffff"+
        "\1\50\1\116\3\50\1\uffff\1\103\3\uffff\1\105\1\50\1\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\3\uffff\1\14\4\uffff\1"+
        "\25\1\26\1\27\1\30\1\31\5\uffff\1\16\1\15\16\uffff\1\20\4\uffff"+
        "\1\21\4\uffff\1\22\1\12\1\23\1\13\5\uffff\1\17\1\uffff\1\6\1\10"+
        "\1\11\2\uffff\1\24";
    static final String DFA3_specialS =
        "\105\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\24\2\uffff\1\24\22\uffff\1\24\6\uffff\1\23\1\14\1\7\1\20"+
            "\3\uffff\1\3\1\uffff\12\22\1\1\2\uffff\1\13\1\2\2\uffff\1\16"+
            "\1\21\1\15\1\17\1\6\7\21\1\12\2\21\1\11\2\21\1\10\7\21\1\4\1"+
            "\uffff\1\5\3\uffff\32\21",
            "",
            "",
            "",
            "",
            "",
            "\1\25",
            "",
            "\1\26",
            "\1\27",
            "\1\31\7\uffff\1\30",
            "",
            "\1\32",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\40\6\uffff\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "",
            "",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "",
            "\1\63",
            "\1\64",
            "\1\66",
            "\1\70",
            "",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "",
            "\1\102",
            "",
            "",
            "",
            "\1\103",
            "\1\104",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | TEXTVALUE | INTVALUE | STRING | WS );";
        }
    }
 

}