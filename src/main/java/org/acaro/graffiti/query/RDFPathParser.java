/*  Copyright 2011 Claudio Martella
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/

package org.acaro.graffiti.query;

// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g 2011-11-11 17:19:50

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class RDFPathParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUERY", "LOCATIONSTEP", "CONDITION", "FILTER", "FILTERFUNCTION", "SUBQUERY", "REPEAT", "SHORTESTPATH", "ENDNODEFUNCTION", "STARTNODE", "EDGE", "STRING", "INTVALUE", "TEXTVALUE", "WS", "'::'", "'>'", "'.'", "'['", "']'", "'EQUALS('", "')'", "'SUFFIX('", "'PREFIX('", "'MIN('", "'MAX('", "'='", "'('", "'(*'", "'COUNT()'", "'SUM()'", "'AVG()'", "'MIN()'", "'MAX()'", "'DISTANCE('", "'*'"
    };
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


        public RDFPathParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RDFPathParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return RDFPathParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g"; }


    public static class query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:20:1: query : startNode '::' locationStep ( '>' locationStep )* ( '.' endNodeFunction )? -> ^( QUERY startNode ( locationStep )+ ( endNodeFunction )? ) ;
    public final RDFPathParser.query_return query() throws RecognitionException {
        RDFPathParser.query_return retval = new RDFPathParser.query_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal2=null;
        Token char_literal4=null;
        Token char_literal6=null;
        RDFPathParser.startNode_return startNode1 = null;

        RDFPathParser.locationStep_return locationStep3 = null;

        RDFPathParser.locationStep_return locationStep5 = null;

        RDFPathParser.endNodeFunction_return endNodeFunction7 = null;


        Object string_literal2_tree=null;
        Object char_literal4_tree=null;
        Object char_literal6_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleSubtreeStream stream_endNodeFunction=new RewriteRuleSubtreeStream(adaptor,"rule endNodeFunction");
        RewriteRuleSubtreeStream stream_startNode=new RewriteRuleSubtreeStream(adaptor,"rule startNode");
        RewriteRuleSubtreeStream stream_locationStep=new RewriteRuleSubtreeStream(adaptor,"rule locationStep");
        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:21:2: ( startNode '::' locationStep ( '>' locationStep )* ( '.' endNodeFunction )? -> ^( QUERY startNode ( locationStep )+ ( endNodeFunction )? ) )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:21:4: startNode '::' locationStep ( '>' locationStep )* ( '.' endNodeFunction )?
            {
            pushFollow(FOLLOW_startNode_in_query74);
            startNode1=startNode();

            state._fsp--;

            stream_startNode.add(startNode1.getTree());
            string_literal2=(Token)match(input,19,FOLLOW_19_in_query76);  
            stream_19.add(string_literal2);

            pushFollow(FOLLOW_locationStep_in_query78);
            locationStep3=locationStep();

            state._fsp--;

            stream_locationStep.add(locationStep3.getTree());
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:21:32: ( '>' locationStep )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==20) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:21:33: '>' locationStep
            	    {
            	    char_literal4=(Token)match(input,20,FOLLOW_20_in_query81);  
            	    stream_20.add(char_literal4);

            	    pushFollow(FOLLOW_locationStep_in_query83);
            	    locationStep5=locationStep();

            	    state._fsp--;

            	    stream_locationStep.add(locationStep5.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:21:52: ( '.' endNodeFunction )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==21) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:21:53: '.' endNodeFunction
                    {
                    char_literal6=(Token)match(input,21,FOLLOW_21_in_query88);  
                    stream_21.add(char_literal6);

                    pushFollow(FOLLOW_endNodeFunction_in_query90);
                    endNodeFunction7=endNodeFunction();

                    state._fsp--;

                    stream_endNodeFunction.add(endNodeFunction7.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: endNodeFunction, locationStep, startNode
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 22:3: -> ^( QUERY startNode ( locationStep )+ ( endNodeFunction )? )
            {
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:22:6: ^( QUERY startNode ( locationStep )+ ( endNodeFunction )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_startNode.nextTree());
                if ( !(stream_locationStep.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_locationStep.hasNext() ) {
                    adaptor.addChild(root_1, stream_locationStep.nextTree());

                }
                stream_locationStep.reset();
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:22:38: ( endNodeFunction )?
                if ( stream_endNodeFunction.hasNext() ) {
                    adaptor.addChild(root_1, stream_endNodeFunction.nextTree());

                }
                stream_endNodeFunction.reset();

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
    // $ANTLR end "query"

    public static class locationStep_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "locationStep"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:25:1: locationStep : ( edge ( condition )* -> ^( LOCATIONSTEP edge ( condition )* ) | edge ( condition )* repeat -> ^( LOCATIONSTEP edge ( condition )* repeat ) | edge ( condition )* shortestPath -> ^( LOCATIONSTEP edge ( condition )* shortestPath ) );
    public final RDFPathParser.locationStep_return locationStep() throws RecognitionException {
        RDFPathParser.locationStep_return retval = new RDFPathParser.locationStep_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        RDFPathParser.edge_return edge8 = null;

        RDFPathParser.condition_return condition9 = null;

        RDFPathParser.edge_return edge10 = null;

        RDFPathParser.condition_return condition11 = null;

        RDFPathParser.repeat_return repeat12 = null;

        RDFPathParser.edge_return edge13 = null;

        RDFPathParser.condition_return condition14 = null;

        RDFPathParser.shortestPath_return shortestPath15 = null;


        RewriteRuleSubtreeStream stream_edge=new RewriteRuleSubtreeStream(adaptor,"rule edge");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        RewriteRuleSubtreeStream stream_shortestPath=new RewriteRuleSubtreeStream(adaptor,"rule shortestPath");
        RewriteRuleSubtreeStream stream_repeat=new RewriteRuleSubtreeStream(adaptor,"rule repeat");
        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:26:2: ( edge ( condition )* -> ^( LOCATIONSTEP edge ( condition )* ) | edge ( condition )* repeat -> ^( LOCATIONSTEP edge ( condition )* repeat ) | edge ( condition )* shortestPath -> ^( LOCATIONSTEP edge ( condition )* shortestPath ) )
            int alt6=3;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:26:4: edge ( condition )*
                    {
                    pushFollow(FOLLOW_edge_in_locationStep121);
                    edge8=edge();

                    state._fsp--;

                    stream_edge.add(edge8.getTree());
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:26:9: ( condition )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==22) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:26:9: condition
                    	    {
                    	    pushFollow(FOLLOW_condition_in_locationStep123);
                    	    condition9=condition();

                    	    state._fsp--;

                    	    stream_condition.add(condition9.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: edge, condition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 27:3: -> ^( LOCATIONSTEP edge ( condition )* )
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:27:6: ^( LOCATIONSTEP edge ( condition )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOCATIONSTEP, "LOCATIONSTEP"), root_1);

                        adaptor.addChild(root_1, stream_edge.nextTree());
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:27:26: ( condition )*
                        while ( stream_condition.hasNext() ) {
                            adaptor.addChild(root_1, stream_condition.nextTree());

                        }
                        stream_condition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:28:4: edge ( condition )* repeat
                    {
                    pushFollow(FOLLOW_edge_in_locationStep143);
                    edge10=edge();

                    state._fsp--;

                    stream_edge.add(edge10.getTree());
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:28:9: ( condition )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==22) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:28:9: condition
                    	    {
                    	    pushFollow(FOLLOW_condition_in_locationStep145);
                    	    condition11=condition();

                    	    state._fsp--;

                    	    stream_condition.add(condition11.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    pushFollow(FOLLOW_repeat_in_locationStep148);
                    repeat12=repeat();

                    state._fsp--;

                    stream_repeat.add(repeat12.getTree());


                    // AST REWRITE
                    // elements: condition, edge, repeat
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 29:3: -> ^( LOCATIONSTEP edge ( condition )* repeat )
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:29:6: ^( LOCATIONSTEP edge ( condition )* repeat )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOCATIONSTEP, "LOCATIONSTEP"), root_1);

                        adaptor.addChild(root_1, stream_edge.nextTree());
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:29:26: ( condition )*
                        while ( stream_condition.hasNext() ) {
                            adaptor.addChild(root_1, stream_condition.nextTree());

                        }
                        stream_condition.reset();
                        adaptor.addChild(root_1, stream_repeat.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:30:4: edge ( condition )* shortestPath
                    {
                    pushFollow(FOLLOW_edge_in_locationStep169);
                    edge13=edge();

                    state._fsp--;

                    stream_edge.add(edge13.getTree());
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:30:9: ( condition )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==22) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:30:9: condition
                    	    {
                    	    pushFollow(FOLLOW_condition_in_locationStep171);
                    	    condition14=condition();

                    	    state._fsp--;

                    	    stream_condition.add(condition14.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    pushFollow(FOLLOW_shortestPath_in_locationStep174);
                    shortestPath15=shortestPath();

                    state._fsp--;

                    stream_shortestPath.add(shortestPath15.getTree());


                    // AST REWRITE
                    // elements: shortestPath, condition, edge
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 31:3: -> ^( LOCATIONSTEP edge ( condition )* shortestPath )
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:31:6: ^( LOCATIONSTEP edge ( condition )* shortestPath )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LOCATIONSTEP, "LOCATIONSTEP"), root_1);

                        adaptor.addChild(root_1, stream_edge.nextTree());
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:31:26: ( condition )*
                        while ( stream_condition.hasNext() ) {
                            adaptor.addChild(root_1, stream_condition.nextTree());

                        }
                        stream_condition.reset();
                        adaptor.addChild(root_1, stream_shortestPath.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
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
    // $ANTLR end "locationStep"

    public static class condition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condition"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:34:1: condition : '[' ( filter -> ^( CONDITION filter ) | subquery -> ^( CONDITION subquery ) ) ']' ;
    public final RDFPathParser.condition_return condition() throws RecognitionException {
        RDFPathParser.condition_return retval = new RDFPathParser.condition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal16=null;
        Token char_literal19=null;
        RDFPathParser.filter_return filter17 = null;

        RDFPathParser.subquery_return subquery18 = null;


        Object char_literal16_tree=null;
        Object char_literal19_tree=null;
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleSubtreeStream stream_filter=new RewriteRuleSubtreeStream(adaptor,"rule filter");
        RewriteRuleSubtreeStream stream_subquery=new RewriteRuleSubtreeStream(adaptor,"rule subquery");
        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:35:2: ( '[' ( filter -> ^( CONDITION filter ) | subquery -> ^( CONDITION subquery ) ) ']' )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:35:4: '[' ( filter -> ^( CONDITION filter ) | subquery -> ^( CONDITION subquery ) ) ']'
            {
            char_literal16=(Token)match(input,22,FOLLOW_22_in_condition201);  
            stream_22.add(char_literal16);

            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:35:8: ( filter -> ^( CONDITION filter ) | subquery -> ^( CONDITION subquery ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24||(LA7_0>=26 && LA7_0<=29)) ) {
                alt7=1;
            }
            else if ( (LA7_0==TEXTVALUE) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:35:10: filter
                    {
                    pushFollow(FOLLOW_filter_in_condition205);
                    filter17=filter();

                    state._fsp--;

                    stream_filter.add(filter17.getTree());


                    // AST REWRITE
                    // elements: filter
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 35:17: -> ^( CONDITION filter )
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:35:20: ^( CONDITION filter )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONDITION, "CONDITION"), root_1);

                        adaptor.addChild(root_1, stream_filter.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:36:4: subquery
                    {
                    pushFollow(FOLLOW_subquery_in_condition219);
                    subquery18=subquery();

                    state._fsp--;

                    stream_subquery.add(subquery18.getTree());


                    // AST REWRITE
                    // elements: subquery
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 36:13: -> ^( CONDITION subquery )
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:36:16: ^( CONDITION subquery )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONDITION, "CONDITION"), root_1);

                        adaptor.addChild(root_1, stream_subquery.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }

            char_literal19=(Token)match(input,23,FOLLOW_23_in_condition230);  
            stream_23.add(char_literal19);


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

    public static class filter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filter"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:39:1: filter : filterFunction -> ^( FILTER filterFunction ) ;
    public final RDFPathParser.filter_return filter() throws RecognitionException {
        RDFPathParser.filter_return retval = new RDFPathParser.filter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        RDFPathParser.filterFunction_return filterFunction20 = null;


        RewriteRuleSubtreeStream stream_filterFunction=new RewriteRuleSubtreeStream(adaptor,"rule filterFunction");
        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:40:2: ( filterFunction -> ^( FILTER filterFunction ) )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:40:4: filterFunction
            {
            pushFollow(FOLLOW_filterFunction_in_filter241);
            filterFunction20=filterFunction();

            state._fsp--;

            stream_filterFunction.add(filterFunction20.getTree());


            // AST REWRITE
            // elements: filterFunction
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 41:3: -> ^( FILTER filterFunction )
            {
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:41:6: ^( FILTER filterFunction )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FILTER, "FILTER"), root_1);

                adaptor.addChild(root_1, stream_filterFunction.nextTree());

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
    // $ANTLR end "filter"

    public static class filterFunction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "filterFunction"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:44:1: filterFunction : (fn= 'EQUALS(' v= STRING ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'EQUALS(' v= INTVALUE ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'SUFFIX(' v= STRING ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'PREFIX(' v= STRING ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'MIN(' v= INTVALUE ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'MAX(' v= INTVALUE ')' -> ^( FILTERFUNCTION $fn $v) );
    public final RDFPathParser.filterFunction_return filterFunction() throws RecognitionException {
        RDFPathParser.filterFunction_return retval = new RDFPathParser.filterFunction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token fn=null;
        Token v=null;
        Token char_literal21=null;
        Token char_literal22=null;
        Token char_literal23=null;
        Token char_literal24=null;
        Token char_literal25=null;
        Token char_literal26=null;

        Object fn_tree=null;
        Object v_tree=null;
        Object char_literal21_tree=null;
        Object char_literal22_tree=null;
        Object char_literal23_tree=null;
        Object char_literal24_tree=null;
        Object char_literal25_tree=null;
        Object char_literal26_tree=null;
        RewriteRuleTokenStream stream_INTVALUE=new RewriteRuleTokenStream(adaptor,"token INTVALUE");
        RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:45:2: (fn= 'EQUALS(' v= STRING ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'EQUALS(' v= INTVALUE ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'SUFFIX(' v= STRING ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'PREFIX(' v= STRING ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'MIN(' v= INTVALUE ')' -> ^( FILTERFUNCTION $fn $v) | fn= 'MAX(' v= INTVALUE ')' -> ^( FILTERFUNCTION $fn $v) )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==STRING) ) {
                    alt8=1;
                }
                else if ( (LA8_1==INTVALUE) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt8=3;
                }
                break;
            case 27:
                {
                alt8=4;
                }
                break;
            case 28:
                {
                alt8=5;
                }
                break;
            case 29:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:45:4: fn= 'EQUALS(' v= STRING ')'
                    {
                    fn=(Token)match(input,24,FOLLOW_24_in_filterFunction264);  
                    stream_24.add(fn);

                    v=(Token)match(input,STRING,FOLLOW_STRING_in_filterFunction268);  
                    stream_STRING.add(v);

                    char_literal21=(Token)match(input,25,FOLLOW_25_in_filterFunction270);  
                    stream_25.add(char_literal21);



                    // AST REWRITE
                    // elements: fn, v
                    // token labels: v, fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 45:30: -> ^( FILTERFUNCTION $fn $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:45:33: ^( FILTERFUNCTION $fn $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FILTERFUNCTION, "FILTERFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());
                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:46:4: fn= 'EQUALS(' v= INTVALUE ')'
                    {
                    fn=(Token)match(input,24,FOLLOW_24_in_filterFunction289);  
                    stream_24.add(fn);

                    v=(Token)match(input,INTVALUE,FOLLOW_INTVALUE_in_filterFunction293);  
                    stream_INTVALUE.add(v);

                    char_literal22=(Token)match(input,25,FOLLOW_25_in_filterFunction295);  
                    stream_25.add(char_literal22);



                    // AST REWRITE
                    // elements: fn, v
                    // token labels: v, fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 46:32: -> ^( FILTERFUNCTION $fn $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:46:35: ^( FILTERFUNCTION $fn $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FILTERFUNCTION, "FILTERFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());
                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:47:4: fn= 'SUFFIX(' v= STRING ')'
                    {
                    fn=(Token)match(input,26,FOLLOW_26_in_filterFunction314);  
                    stream_26.add(fn);

                    v=(Token)match(input,STRING,FOLLOW_STRING_in_filterFunction318);  
                    stream_STRING.add(v);

                    char_literal23=(Token)match(input,25,FOLLOW_25_in_filterFunction320);  
                    stream_25.add(char_literal23);



                    // AST REWRITE
                    // elements: fn, v
                    // token labels: v, fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 47:30: -> ^( FILTERFUNCTION $fn $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:47:33: ^( FILTERFUNCTION $fn $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FILTERFUNCTION, "FILTERFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());
                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:48:4: fn= 'PREFIX(' v= STRING ')'
                    {
                    fn=(Token)match(input,27,FOLLOW_27_in_filterFunction339);  
                    stream_27.add(fn);

                    v=(Token)match(input,STRING,FOLLOW_STRING_in_filterFunction343);  
                    stream_STRING.add(v);

                    char_literal24=(Token)match(input,25,FOLLOW_25_in_filterFunction345);  
                    stream_25.add(char_literal24);



                    // AST REWRITE
                    // elements: v, fn
                    // token labels: v, fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 48:30: -> ^( FILTERFUNCTION $fn $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:48:33: ^( FILTERFUNCTION $fn $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FILTERFUNCTION, "FILTERFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());
                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:49:4: fn= 'MIN(' v= INTVALUE ')'
                    {
                    fn=(Token)match(input,28,FOLLOW_28_in_filterFunction364);  
                    stream_28.add(fn);

                    v=(Token)match(input,INTVALUE,FOLLOW_INTVALUE_in_filterFunction368);  
                    stream_INTVALUE.add(v);

                    char_literal25=(Token)match(input,25,FOLLOW_25_in_filterFunction370);  
                    stream_25.add(char_literal25);



                    // AST REWRITE
                    // elements: v, fn
                    // token labels: v, fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 49:29: -> ^( FILTERFUNCTION $fn $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:49:32: ^( FILTERFUNCTION $fn $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FILTERFUNCTION, "FILTERFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());
                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:50:4: fn= 'MAX(' v= INTVALUE ')'
                    {
                    fn=(Token)match(input,29,FOLLOW_29_in_filterFunction389);  
                    stream_29.add(fn);

                    v=(Token)match(input,INTVALUE,FOLLOW_INTVALUE_in_filterFunction393);  
                    stream_INTVALUE.add(v);

                    char_literal26=(Token)match(input,25,FOLLOW_25_in_filterFunction395);  
                    stream_25.add(char_literal26);



                    // AST REWRITE
                    // elements: v, fn
                    // token labels: v, fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 50:29: -> ^( FILTERFUNCTION $fn $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:50:32: ^( FILTERFUNCTION $fn $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FILTERFUNCTION, "FILTERFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());
                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
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
    // $ANTLR end "filterFunction"

    public static class subquery_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subquery"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:53:1: subquery : edge '=' filterFunction -> ^( SUBQUERY edge filterFunction ) ;
    public final RDFPathParser.subquery_return subquery() throws RecognitionException {
        RDFPathParser.subquery_return retval = new RDFPathParser.subquery_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal28=null;
        RDFPathParser.edge_return edge27 = null;

        RDFPathParser.filterFunction_return filterFunction29 = null;


        Object char_literal28_tree=null;
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
        RewriteRuleSubtreeStream stream_edge=new RewriteRuleSubtreeStream(adaptor,"rule edge");
        RewriteRuleSubtreeStream stream_filterFunction=new RewriteRuleSubtreeStream(adaptor,"rule filterFunction");
        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:54:2: ( edge '=' filterFunction -> ^( SUBQUERY edge filterFunction ) )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:54:5: edge '=' filterFunction
            {
            pushFollow(FOLLOW_edge_in_subquery420);
            edge27=edge();

            state._fsp--;

            stream_edge.add(edge27.getTree());
            char_literal28=(Token)match(input,30,FOLLOW_30_in_subquery422);  
            stream_30.add(char_literal28);

            pushFollow(FOLLOW_filterFunction_in_subquery424);
            filterFunction29=filterFunction();

            state._fsp--;

            stream_filterFunction.add(filterFunction29.getTree());


            // AST REWRITE
            // elements: filterFunction, edge
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 55:3: -> ^( SUBQUERY edge filterFunction )
            {
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:55:6: ^( SUBQUERY edge filterFunction )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SUBQUERY, "SUBQUERY"), root_1);

                adaptor.addChild(root_1, stream_edge.nextTree());
                adaptor.addChild(root_1, stream_filterFunction.nextTree());

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
    // $ANTLR end "subquery"

    public static class repeat_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repeat"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:58:1: repeat : '(' v= INTVALUE ')' -> ^( REPEAT $v) ;
    public final RDFPathParser.repeat_return repeat() throws RecognitionException {
        RDFPathParser.repeat_return retval = new RDFPathParser.repeat_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token v=null;
        Token char_literal30=null;
        Token char_literal31=null;

        Object v_tree=null;
        Object char_literal30_tree=null;
        Object char_literal31_tree=null;
        RewriteRuleTokenStream stream_INTVALUE=new RewriteRuleTokenStream(adaptor,"token INTVALUE");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");

        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:59:2: ( '(' v= INTVALUE ')' -> ^( REPEAT $v) )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:59:4: '(' v= INTVALUE ')'
            {
            char_literal30=(Token)match(input,31,FOLLOW_31_in_repeat447);  
            stream_31.add(char_literal30);

            v=(Token)match(input,INTVALUE,FOLLOW_INTVALUE_in_repeat451);  
            stream_INTVALUE.add(v);

            char_literal31=(Token)match(input,25,FOLLOW_25_in_repeat453);  
            stream_25.add(char_literal31);



            // AST REWRITE
            // elements: v
            // token labels: v
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 60:3: -> ^( REPEAT $v)
            {
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:60:6: ^( REPEAT $v)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REPEAT, "REPEAT"), root_1);

                adaptor.addChild(root_1, stream_v.nextNode());

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
    // $ANTLR end "repeat"

    public static class shortestPath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shortestPath"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:63:1: shortestPath : '(*' v= INTVALUE ')' -> ^( SHORTESTPATH $v) ;
    public final RDFPathParser.shortestPath_return shortestPath() throws RecognitionException {
        RDFPathParser.shortestPath_return retval = new RDFPathParser.shortestPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token v=null;
        Token string_literal32=null;
        Token char_literal33=null;

        Object v_tree=null;
        Object string_literal32_tree=null;
        Object char_literal33_tree=null;
        RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
        RewriteRuleTokenStream stream_INTVALUE=new RewriteRuleTokenStream(adaptor,"token INTVALUE");
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");

        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:64:2: ( '(*' v= INTVALUE ')' -> ^( SHORTESTPATH $v) )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:64:4: '(*' v= INTVALUE ')'
            {
            string_literal32=(Token)match(input,32,FOLLOW_32_in_shortestPath476);  
            stream_32.add(string_literal32);

            v=(Token)match(input,INTVALUE,FOLLOW_INTVALUE_in_shortestPath480);  
            stream_INTVALUE.add(v);

            char_literal33=(Token)match(input,25,FOLLOW_25_in_shortestPath482);  
            stream_25.add(char_literal33);



            // AST REWRITE
            // elements: v
            // token labels: v
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 65:3: -> ^( SHORTESTPATH $v)
            {
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:65:6: ^( SHORTESTPATH $v)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SHORTESTPATH, "SHORTESTPATH"), root_1);

                adaptor.addChild(root_1, stream_v.nextNode());

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
    // $ANTLR end "shortestPath"

    public static class endNodeFunction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "endNodeFunction"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:68:1: endNodeFunction : (fn= 'COUNT()' -> ^( ENDNODEFUNCTION $fn) | fn= 'SUM()' -> ^( ENDNODEFUNCTION $fn) | fn= 'AVG()' -> ^( ENDNODEFUNCTION $fn) | fn= 'MIN()' -> ^( ENDNODEFUNCTION $fn) | fn= 'MAX()' -> ^( ENDNODEFUNCTION $fn) | fn= 'DISTANCE(' v= STRING ')' -> ^( ENDNODEFUNCTION $fn $v) );
    public final RDFPathParser.endNodeFunction_return endNodeFunction() throws RecognitionException {
        RDFPathParser.endNodeFunction_return retval = new RDFPathParser.endNodeFunction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token fn=null;
        Token v=null;
        Token char_literal34=null;

        Object fn_tree=null;
        Object v_tree=null;
        Object char_literal34_tree=null;
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");

        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:69:2: (fn= 'COUNT()' -> ^( ENDNODEFUNCTION $fn) | fn= 'SUM()' -> ^( ENDNODEFUNCTION $fn) | fn= 'AVG()' -> ^( ENDNODEFUNCTION $fn) | fn= 'MIN()' -> ^( ENDNODEFUNCTION $fn) | fn= 'MAX()' -> ^( ENDNODEFUNCTION $fn) | fn= 'DISTANCE(' v= STRING ')' -> ^( ENDNODEFUNCTION $fn $v) )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt9=1;
                }
                break;
            case 34:
                {
                alt9=2;
                }
                break;
            case 35:
                {
                alt9=3;
                }
                break;
            case 36:
                {
                alt9=4;
                }
                break;
            case 37:
                {
                alt9=5;
                }
                break;
            case 38:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:69:4: fn= 'COUNT()'
                    {
                    fn=(Token)match(input,33,FOLLOW_33_in_endNodeFunction507);  
                    stream_33.add(fn);



                    // AST REWRITE
                    // elements: fn
                    // token labels: fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 69:17: -> ^( ENDNODEFUNCTION $fn)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:69:20: ^( ENDNODEFUNCTION $fn)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENDNODEFUNCTION, "ENDNODEFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:70:4: fn= 'SUM()'
                    {
                    fn=(Token)match(input,34,FOLLOW_34_in_endNodeFunction524);  
                    stream_34.add(fn);



                    // AST REWRITE
                    // elements: fn
                    // token labels: fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 70:15: -> ^( ENDNODEFUNCTION $fn)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:70:18: ^( ENDNODEFUNCTION $fn)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENDNODEFUNCTION, "ENDNODEFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:71:4: fn= 'AVG()'
                    {
                    fn=(Token)match(input,35,FOLLOW_35_in_endNodeFunction540);  
                    stream_35.add(fn);



                    // AST REWRITE
                    // elements: fn
                    // token labels: fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 71:15: -> ^( ENDNODEFUNCTION $fn)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:71:18: ^( ENDNODEFUNCTION $fn)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENDNODEFUNCTION, "ENDNODEFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:72:4: fn= 'MIN()'
                    {
                    fn=(Token)match(input,36,FOLLOW_36_in_endNodeFunction556);  
                    stream_36.add(fn);



                    // AST REWRITE
                    // elements: fn
                    // token labels: fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 72:15: -> ^( ENDNODEFUNCTION $fn)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:72:18: ^( ENDNODEFUNCTION $fn)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENDNODEFUNCTION, "ENDNODEFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:73:4: fn= 'MAX()'
                    {
                    fn=(Token)match(input,37,FOLLOW_37_in_endNodeFunction572);  
                    stream_37.add(fn);



                    // AST REWRITE
                    // elements: fn
                    // token labels: fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 73:14: -> ^( ENDNODEFUNCTION $fn)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:73:17: ^( ENDNODEFUNCTION $fn)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENDNODEFUNCTION, "ENDNODEFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:74:4: fn= 'DISTANCE(' v= STRING ')'
                    {
                    fn=(Token)match(input,38,FOLLOW_38_in_endNodeFunction587);  
                    stream_38.add(fn);

                    v=(Token)match(input,STRING,FOLLOW_STRING_in_endNodeFunction591);  
                    stream_STRING.add(v);

                    char_literal34=(Token)match(input,25,FOLLOW_25_in_endNodeFunction593);  
                    stream_25.add(char_literal34);



                    // AST REWRITE
                    // elements: fn, v
                    // token labels: v, fn
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleTokenStream stream_fn=new RewriteRuleTokenStream(adaptor,"token fn",fn);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 74:32: -> ^( ENDNODEFUNCTION $fn $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:74:35: ^( ENDNODEFUNCTION $fn $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENDNODEFUNCTION, "ENDNODEFUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_fn.nextNode());
                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
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
    // $ANTLR end "endNodeFunction"

    public static class startNode_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "startNode"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:77:1: startNode : (v= '*' -> ^( STARTNODE $v) | v= TEXTVALUE -> ^( STARTNODE $v) );
    public final RDFPathParser.startNode_return startNode() throws RecognitionException {
        RDFPathParser.startNode_return retval = new RDFPathParser.startNode_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token v=null;

        Object v_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_TEXTVALUE=new RewriteRuleTokenStream(adaptor,"token TEXTVALUE");

        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:78:2: (v= '*' -> ^( STARTNODE $v) | v= TEXTVALUE -> ^( STARTNODE $v) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==39) ) {
                alt10=1;
            }
            else if ( (LA10_0==TEXTVALUE) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:78:4: v= '*'
                    {
                    v=(Token)match(input,39,FOLLOW_39_in_startNode618);  
                    stream_39.add(v);



                    // AST REWRITE
                    // elements: v
                    // token labels: v
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 78:10: -> ^( STARTNODE $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:78:13: ^( STARTNODE $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STARTNODE, "STARTNODE"), root_1);

                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:79:4: v= TEXTVALUE
                    {
                    v=(Token)match(input,TEXTVALUE,FOLLOW_TEXTVALUE_in_startNode634);  
                    stream_TEXTVALUE.add(v);



                    // AST REWRITE
                    // elements: v
                    // token labels: v
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 79:16: -> ^( STARTNODE $v)
                    {
                        // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:79:19: ^( STARTNODE $v)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STARTNODE, "STARTNODE"), root_1);

                        adaptor.addChild(root_1, stream_v.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
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
    // $ANTLR end "startNode"

    public static class edge_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "edge"
    // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:82:1: edge : v= TEXTVALUE -> ^( EDGE $v) ;
    public final RDFPathParser.edge_return edge() throws RecognitionException {
        RDFPathParser.edge_return retval = new RDFPathParser.edge_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token v=null;

        Object v_tree=null;
        RewriteRuleTokenStream stream_TEXTVALUE=new RewriteRuleTokenStream(adaptor,"token TEXTVALUE");

        try {
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:83:2: (v= TEXTVALUE -> ^( EDGE $v) )
            // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:83:4: v= TEXTVALUE
            {
            v=(Token)match(input,TEXTVALUE,FOLLOW_TEXTVALUE_in_edge657);  
            stream_TEXTVALUE.add(v);



            // AST REWRITE
            // elements: v
            // token labels: v
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 84:3: -> ^( EDGE $v)
            {
                // /Users/hammer/TIS/java-hacking/graffiti/resources/RDFPath.g:84:6: ^( EDGE $v)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EDGE, "EDGE"), root_1);

                adaptor.addChild(root_1, stream_v.nextNode());

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
    // $ANTLR end "edge"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\53\uffff";
    static final String DFA6_eofS =
        "\1\uffff\1\3\34\uffff\1\3\14\uffff";
    static final String DFA6_minS =
        "\1\21\1\24\1\21\3\uffff\3\17\2\20\1\36\6\31\1\30\6\27\3\17\2\20"+
        "\1\24\6\31\6\27";
    static final String DFA6_maxS =
        "\1\21\1\40\1\35\3\uffff\1\20\2\17\2\20\1\36\6\31\1\35\6\27\1\20"+
        "\2\17\2\20\1\40\6\31\6\27";
    static final String DFA6_acceptS =
        "\3\uffff\1\1\1\2\1\3\45\uffff";
    static final String DFA6_specialS =
        "\53\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\2\3\1\2\10\uffff\1\4\1\5",
            "\1\13\6\uffff\1\6\1\uffff\1\7\1\10\1\11\1\12",
            "",
            "",
            "",
            "\1\14\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31\1\uffff\1\32\1\33\1\34\1\35",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\37\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\2\3\1\2\10\uffff\1\4\1\5",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\36",
            "\1\36"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "25:1: locationStep : ( edge ( condition )* -> ^( LOCATIONSTEP edge ( condition )* ) | edge ( condition )* repeat -> ^( LOCATIONSTEP edge ( condition )* repeat ) | edge ( condition )* shortestPath -> ^( LOCATIONSTEP edge ( condition )* shortestPath ) );";
        }
    }
 

    public static final BitSet FOLLOW_startNode_in_query74 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_query76 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_locationStep_in_query78 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_20_in_query81 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_locationStep_in_query83 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_21_in_query88 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_endNodeFunction_in_query90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_edge_in_locationStep121 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_condition_in_locationStep123 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_edge_in_locationStep143 = new BitSet(new long[]{0x0000000080400000L});
    public static final BitSet FOLLOW_condition_in_locationStep145 = new BitSet(new long[]{0x0000000080400000L});
    public static final BitSet FOLLOW_repeat_in_locationStep148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_edge_in_locationStep169 = new BitSet(new long[]{0x0000000100400000L});
    public static final BitSet FOLLOW_condition_in_locationStep171 = new BitSet(new long[]{0x0000000100400000L});
    public static final BitSet FOLLOW_shortestPath_in_locationStep174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_condition201 = new BitSet(new long[]{0x000000003D020000L});
    public static final BitSet FOLLOW_filter_in_condition205 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_subquery_in_condition219 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_condition230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filterFunction_in_filter241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_filterFunction264 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_filterFunction268 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_filterFunction270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_filterFunction289 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_INTVALUE_in_filterFunction293 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_filterFunction295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_filterFunction314 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_filterFunction318 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_filterFunction320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_filterFunction339 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_filterFunction343 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_filterFunction345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_filterFunction364 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_INTVALUE_in_filterFunction368 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_filterFunction370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_filterFunction389 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_INTVALUE_in_filterFunction393 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_filterFunction395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_edge_in_subquery420 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_subquery422 = new BitSet(new long[]{0x000000003D000000L});
    public static final BitSet FOLLOW_filterFunction_in_subquery424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_repeat447 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_INTVALUE_in_repeat451 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_repeat453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_shortestPath476 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_INTVALUE_in_shortestPath480 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_shortestPath482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_endNodeFunction507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_endNodeFunction524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_endNodeFunction540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_endNodeFunction556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_endNodeFunction572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_endNodeFunction587 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STRING_in_endNodeFunction591 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_endNodeFunction593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_startNode618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXTVALUE_in_startNode634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXTVALUE_in_edge657 = new BitSet(new long[]{0x0000000000000002L});

}