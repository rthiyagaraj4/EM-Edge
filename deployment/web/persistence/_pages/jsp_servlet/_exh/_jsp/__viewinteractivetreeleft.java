package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import oracle.sql.*;
import oracle.jdbc.driver.*;
import java.util.*;
import com.ehis.util.*;

public final class __viewinteractivetreeleft extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/exh/jsp/ViewInteractiveTreeLeft.jsp", 1709122405287L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n\t<link rel=\"StyleSheet\" href=\"../../eXH/html/dtree.css\" type=\"text/css\" />\t\t\t\t \n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/lris_style.css\" type=\"text/css\" />\n\t<script type=\"text/javascript\" src=\"../../eXH/js/dtree1.js\"></script>\n\t<script language=\"javascript\" src=\"../../eXH/js/Viewtreeimage2.js\" ></script>\n\t<script language=\'JavaScript\' src=\'../../eXH/js/Validate.js\'></script>\n\t<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\'JavaScript\' src=\'../../eXH/js/checkfield.js\'></script>\t\t\t\t\t\t\t\t  \n\t<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script> \n\t<script>\n\t\n//\tparent.f_query_add_mod.document.location.href=\'../../eXH/jsp/ViewinteractiveMessageTreeLeft.jsp\';\t    \n//parent.f_query_add_mod2.document.location.href=\'../../eXH/jsp/ViewinteractiveMessageTreeRight.jsp\';\n\n//\tsubmitForm();\n\t</script> \n</head>\n<BODY   >\n<form name=\"view_segment_form\" id=\"view_segment_form\" >\n<table cellspacing=0 cellpadding=3 width=\'99%\' align=center >\n<tr> \n<input type=hidden name=\'Req_symbols\' id=\'Req_symbols\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' >\n<input type=hidden name=\'Req_type\' id=\'Req_type\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' >\n<input type=hidden name=\'Req_txt\' id=\'Req_txt\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >\n<input type=hidden name=\'ReQ_Syn\' id=\'ReQ_Syn\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' > \n</TR> \n<TR>\n<td>\n<div class=\"tree\">\n<script language=\"JavaScript\">\n\td = new dTree(\'d\');\n\tvar treeval =new Array();\n\tvar tswArr =new Array();\n\tvar AtArr =new Array(); \n\tvar ExcArr =new Array();\n\tvar pipArr =new Array();\n\tvar capArr =new Array();\n\tvar TextVal=new Array();\n\tvar tswVal=new Array();\n\tvar AtVal=new Array(); \n\tvar ExcVal=new Array();\n\tvar PiptVal=new Array();\n\tvar CapVal=new Array();\n\tvar AmperVal=new Array();\n\tvar OpenVal=new Array();\n\tvar CloseVal=new Array();\n\tvar tsw=0;\n\tvar cou=1;\n\tvar Exc=0;\n\tvar At=0;\n\tvar pip=0;\n\tvar tswt=0;\n\tvar Att=0;\n\tvar Exct=0;\n\tvar Pipt=0;\n\tvar Capt=0;\n\tvar Ampert=0\n\tvar treeval =new Array();\n\tvar hashArr =new Array();\n\tvar dolArr =new Array();\n\tvar perArr =new Array();\n\tvar pipArr =new Array();\n\tvar capArr =new Array();\n\tvar dolVal=new Array();\n\tvar PerVal=new Array();\n\tvar hashVal=new Array();\n\tvar TextVal=new Array();\n\tvar Open=0;\n\tvar Amper=0;\n\tvar Opent=0;\n\tvar Closet=0;\n\tvar pip=0;var Cap=0;\n\tvar hash=0;\n\tvar hashCou;\n\tvar dolCou;\n\tvar perCou;\n\tvar pipCou;\n\tvar capCou;\n\tvar l_pos;\n\tvar cou=1;\n\tvar temp=\'\';\n\tvar perce=0;\n\tvar dola=0;\n\tvar som=0;\n\tvar pip=0;\n\tvar hasht=0;\n\tvar dolt=0;\n\tvar Pert=0;\n\tvar ll=0;\n\tvar capte1=0;\n\tvar k2=\"\";\n\tvar symbolvalue;\n\tvar temp=\'\';\n\tvar d1=0;\n\tvar val=\"\";\n\tvar acchar=0;\n\tvar sy=\'\';\n\tvar Symbols=new Array();\n\tvar s1=0;\n\tvar Lesstan=new Array();\n\tvar less=0;\n\tvar messagehead=\"\";\n\tvar CapVal1=new Array();\n\tvar Capt1=0;\n\tvar boxval=new Array();\n\tvar box=0;\n\tvar messegetext=unescape(document.forms[0].Req_txt.value)+\'|\';\n\tvar messegesyntax=unescape(document.forms[0].ReQ_Syn.value)+\'|\'; \n\tvar standard_symbols=document.forms[0].Req_symbols.value;\n\tvar compilesimples=3;\n\tvar standard_type1=document.forms[0].Req_type.value;\n\n\tvar perce=0;\n\tif(messegesyntax.indexOf(\"###\")!=-1);\n\t{\n\tstandard_symbols=\"35|35|35{{{35|36|35{{{35|37|35{{{\"+document.forms[0].Req_symbols.value;\n\t}\n\tvar SplitinElements=new Array();\n\tvar sp=0;\n\tvar spliting=standard_symbols.split(\"{{{\");\n\tfor(var s=0;s<spliting.length;s++)\n\t{\n\t\tif(spliting[s]!==\'\')\n\t\t{\n\t\tif(spliting[s].indexOf(\'|\')!=-1)\n\t\t{\n\t\tvar SpilitngStandardpip=spliting[s].split(\'|\');\n\t\tSplitinElements[sp]=SpilitngStandardpip[1];\n\n\t\t}\n\n\t\telse\n\t\t{\n\t\tSplitinElements[sp]=spliting[s];\n\n\t\t}\n\t\tsp++;\n\t\t}\n\t}\n\n\n\tvar spt1=0;\n\tvar intSymbols=new Array();\n\tvar intd=0;\n\n\tfor(var spt=0;spt<SplitinElements.length;spt++)\n\t{\n\t\tif(spt==0 || spt==1 || spt==2)\n\t\t{\n\t\tSymbols[spt1]=\"#\"+String.fromCharCode(SplitinElements[spt])+\"#\";\n\t\tintSymbols[intd]=\"#\"+String.fromCharCode(SplitinElements[spt])+\"#\";\n\t\tintd++;\n\t\t}\n\t\telse\n\t\t{\n\t\tSymbols[spt1]=String.fromCharCode(SplitinElements[spt]);\n\t\tintSymbols[intd]=String.fromCharCode(SplitinElements[spt]);\n\n\t\tintd++;\n\t\t}\n\t\tspt1++;\n\n\t}\n\tif(standard_type1==\'H\')\n   {\n\t\tvar pipsimple=\"|\";\n\t\tvar pipsym=messegetext.indexOf(\'|\');\n\t\tvar firstmessage=messegetext.substring(0,pipsym);\n\n\t\tCapVal[0]=pipsimple;\n\t\tPiptVal[0]=firstmessage;\n\t\tvar messagevaluepip=messegetext.substring((pipsym+1),messegetext.length);\n\t\tvar nextpip=messagevaluepip.indexOf(\'|\');\n\t\tvar massagenextpip=messagevaluepip.substring(0,nextpip);\n\t\tvar secondsplit=messagevaluepip.substring(nextpip,messagevaluepip.length);\n\t\tCapVal[1]=massagenextpip;\n\t\tif(Symbols[3]!=null )\n\t\t{\n\t\t\tvar ch=Symbols[3].toString();\n\t\t}\n\t\telse\n\t\t{\n\t\t}\n\t\tvar identifysimbol=messegesyntax.indexOf(ch);\n\t\tvar identifypip=messegesyntax.indexOf(\'|\');\n\t\tvar MsgsubString=messegesyntax.substring(identifysimbol+1,identifypip);\n\t\tvar tillMegHeead=messegesyntax.substring(0,identifysimbol);\n\t\tvar tillsegHead=messegesyntax.substring(identifypip,messegesyntax.length);\n\t\tvar Replace=\"\";\n\t\tif(Symbols[5]!=null)\n\t\t{\n\t\t\tReplace=Symbols[5].toString()+MsgsubString;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tReplace=ch+MsgsubString;\n\t\t}\n\t\tmessegesyntax=tillMegHeead+ch+Replace+tillsegHead+\'|\';\n\t\tCapt=2;\n\t\tk2=secondsplit;\n\t\tPipt=1;\n\t\tfor(var i=0;i<k2.length;i++)\n\t\t{\n\t\t\tcurval= (k2.charAt(i)).toString();\n\t\tif(curval==\'+\')\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t{\n\t\t\tcurval=\' \';\n\t\t}\n\t\tif(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == \'*\')\n\t\t{\n\t\t\tif(temp.length>0 || curval == intSymbols[3])\n\t\t\t{\n\t\t\t\tvar somethingdata=temp.substring(0,1);\n\t\t\t\tswitch(test(somethingdata))\n\t\t\t\t{\n\t\t\t\t\tcase 0:\n\t\t\t\t\tbreak;\n    \t\t\t\tcase 1:\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 2:\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 3:\n\t\t\t\t\tboxval[box]=temp.substring(1);\n\t\t\t\t\tbox++;\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 4:\n\t\t\t\t\tvar value3=temp.substring(1);\n\t\t\t\t\tif (value3==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tLesstan[less]=messagehead;\n\t\t\t\t\t\tless++;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tLesstan[less]=value3;\n\t\t\t\t\t\tless++;\n\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 5:\n\t\t\t\t\tPiptVal[Pipt]=temp.substring(1);\n\t\t\t\t\tPipt++;\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 6:\n\t\t\t\t\tCapVal[Capt]=temp.substring(1);\n\t\t\t\t\tCapt++;\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 7:\n\t\t\t\t\tCapVal1[Capt1]=temp.substring(1);\n\t\t\t\t\tCapt1++;\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase \'*\':\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase \'&\':\n    \t\t\t\tbreak;\n\n\t\t\t\t}\n\t\t\t}\n\t\t\ttemp=curval;\n\t\t}\n\t\telse \n\t\t{\n\t\t\ttemp=temp+curval;\n\t\t}\n\t\t}\n\t\tif(temp.length>0)\n\t\t{\n\t\t\tswitch(test(curval))\n\t\t\t{\n\t\t\t\tcase 0:\n\t\t\t\tbreak;\n\t\t\t\tcase 1:\n\t\t\t\tbreak;\n\t\t\t\tcase 2:\n\t\t\t\tbreak;\n\t\t\t\tcase 3:\n\t\t\t\tmessagehead=temp.substring(1);\n\t\t\t\tif(messagehead==\"\" || messagehead==null)\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tboxval[box]=messagehead;\n\t\t\t\t\tbox++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 4:\n\t\t\t\tLesstan[less]=temp.substring(1);\n\t\t\t\tless++;\n\t\t\t\tbreak;\n\t\t\t\tcase 5:\n\t\t\t\tif(temp.substring(1)==\'*\')\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tPiptVal[Pipt]=temp.substring(1);\n\t\t\t\t\tPipt++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 6:\n\t\t\t\tCapVal[Capt]=temp.substring(1);\n\t\t\t\tCapt++;\n\t\t\t\tbreak;\n\t\t\t\tcase 7:\n\t\t\t\tCapVal1[Capt1]=temp.substring(1);\n\t\t\t\tCapt1++;\n\t\t\t\tcase \'*\':\n\t\t\t\tbreak;\n\t\t\t\tcase \'&\':\n\t\t\t\tbreak;\n\t\t\t }\n\t\t}\n\t\t/**************************populate Tree*************************////\n\t\t/**********************************Populate Tree*****************************/\n\tvar tswte=0;\n\tvar Atte=0;\n\tvar Excte=0;\n\tvar pipte=0;\n\tvar capte=0;\n\tvar cou1=1;\n\tvar Opente=0;\n\tvar Closete=0;\n\tvar Amperte=0\n\tvar hashte=0;\n\tvar pipsom=0;\n\tvar dolte=0;\n\tvar perte=0;\n\tvar lesste=0;\n\tvar cap=0;\n\tvar boxte=0;\n\td.add(0,-1,\'\');\n\tvar counting=1;\n\tvar spe=0;\n\tfor(var i=0;i<messegesyntax.length;i++)\n\t{\n\t\tcurval=(messegesyntax.charAt(i)).toString();\n\t\tcurval1=(messegesyntax.charAt(i)).toString();\n\t\tsome=(messegesyntax.charAt(i)).toString()+((messegesyntax.charAt(i+1)).toString())+((messegesyntax.charAt(i+2)).toString());;\n\t\tif((messegesyntax.charAt(i+2)).toString()==\"\" || (messegesyntax.charAt(i+1)).toString()==\"\")\n\t\t{\n\t\t\tsome=some+\"lam,x\"+\"lam,x\";\n\t\t}\n\t\tif(compilesimples==i)\n\t\t{\n\t\t\tcurval=some1;\n\t\t}\n\t\tif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n\t\t{\n\t\t\tcompilesimples=(i+2);\n\t\t\tsome1=some;\n\t\t\tcounting=3;\n\t\t\tspe=2;\n\t\t}\n\t\telse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n\t\t{\n\t\t\tcurval=curval1;\n\t\t\tspe=0;\n\t\t\tcounting=1;\n\t\t}\n\t\tif(curval==\"+\")\n\t\t{\n\t\t\tcurval=\" \";\n\t\t}\n\t\tif(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])\n\t\t{\n\t\tif(temp.length>0 )\n\t\t{\n\t\t\ttemp=temp.substring(0,(temp.length-spe));\n\t\t\tif(temp.indexOf(\"#%#\")!=-1)\n\t\t\t{\n\t\t\t\tcounting=3\n\t\t\t}\n\t    \tvar somethingdata=temp.substring(0,counting)\n\t\t\tswitch(test(somethingdata))\n\t\t\t{\n\t\t\t\tcase 0:\n\t\t\t\tvar value11=temp.substring(counting);\n\t\t\t\tif(value11==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(hashVal[hashte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar value1=value11;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar value1=value11+\"     =     \"+hashVal[hashte];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,0,value1,value1);\n\t\t\t\thash=cou1;\n\t\t\t\tcou1++;\n\t\t\t\thashte++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 1:\n\t\t\t\tvar value12=temp.substring((counting));\n\t\t\t\tif(value12==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tif(dolVal[dolte]==null)\n\t\t\t\t{\n\t\t\t\tvar value2=value12;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tvar value2=value12+\"     =     \"+dolVal[dolte];\n\t\t\t\t}\n\t\t\t\td.add(cou1,hash,value2,value2);\n\t\t\t\tdola=cou1;\n\t\t\t\tcou1++;\n\t\t\t\tdolte++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 2:\n\t\t\t\tdola=getData(dola,hash,1);\n\t\t\t\tvar value13=temp.substring((counting));\n\t\t\t\tif(value13==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(PerVal[perte]==null)\n\t\t\t\t\t{\n\t\t\t\t\tvar value3=value13;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\tvar value3=value13+\"     =     \"+PerVal[perte];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,dola,value3,value3);\n\t\t\t\tperce=cou1;\n\t\t\t\tperce=cou1;\n\t\t\t\tcou1++;\n\t\t\t\tperte++;\n\t\t\t\tcounting=0;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 3:\n\t\t\t\tperce =getData(perce,hash,1);\n\t\t\t\tperce=getData(perce,dola,2);\n\t\t\t\tvar somevalue1=\"\";\n\t\t\t\tvar somevalue=temp.substring(counting);\n\t\t\t\tif(somevalue==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(boxval[boxte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tsomevalue1=somevalue;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tsomevalue1=somevalue+\"     =     \"+boxval[boxte];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,perce,somevalue1,\"\");\n\t\t\t\tpipsom=cou1;\n\t\t\t\t//som=cou1;\n\t\t\t\tboxte++;\n\t\t\t\tcou1++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 4:\n\t\t\t\tsom =getData(som,hash,1);\n\t\t\t\tsom=getData(som,dola,2);\n\t\t\t\tsom=getData(pipsom,perce,3);\n\t\t\t\tvar lessval1=\"\";\n\t\t\t\tvar lessval=temp.substring(1);\n\t\t\t\tif(lessval==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tif(Lesstan[lesste]==null)\n\t\t\t\t{\n\t\t\t\tlessval1=lessval;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\t\t\t\t}\n\t\t\t\td.add(cou1,som,lessval1,valuePip);\n\t\t\t\tpipsom=som;\n\t\t\t\tpip=cou1;\n\t\t\t\tlesste++;\n\t\t\t\tcou1++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 5:\n\t\t\t\tpip=getData(pip,hash,1);\n\t\t\t\tpip=getData(pip,dola,2);\n\t\t\t\tpip=getData(pip,perce,3);\n\t\t\t\tpip=getData(pip,pipsom,4);\n\t\t\t\tvar valuePip1=temp.substring(1);\n\t\t\t\tif(valuePip1==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(PiptVal[pipte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valuePip=valuePip1;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\t\t\t\t\t}\n\t\t\t\tacchar=0;\n\t\t\t\td.add(cou1,pip,valuePip,valuePip);\n\t\t\t\tcap=cou1;\n\t\t\t\tcou1++;\n\t\t\t\tpipte++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 6:\n\t\t\t\tcap=getData(cap,hash,1);\n\t\t\t\tcap=getData(cap,dola,2);\n\t\t\t\tcap=getData(cap,perce,3);\n\t\t\t\tcap=getData(cap,som,4);\n\t\t\t\tcap=getData(cap,pip,5);\n\t\t\t\tvar valueCap1=temp.substring(1);\n\t\t\t\tvar pipchar=\"\";\n\t\t\t\tif(valueCap1==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(acchar<16)\n\t\t\t\t\t{\n\t\t\t\t\t\tpipchar=CapVal[capte];\n\t\t\t\t\t\tcapte++;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tpipchar=\"\";\n\t\t\t\t\t}\n\t\t\t\t\tif(pipchar==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valueCap=valueCap1;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valueCap=valueCap1+\"     =     \"+pipchar;\n\t\t\t\t\t}\n\t\t\t\tacchar++;\n\t\t\t\td.add(cou1,cap,valueCap,valueCap);\n\t\t\t\tll=cou1;\n\t\t\t\tcou1++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase 7:\n\t\t\t\tll=getData(ll,hash,1);\n\t\t\t\tll=getData(ll,dola,2);\n\t\t\t\tll=getData(ll,perce,3);\n\t\t\t\tll=getData(ll,som,4);\n\t\t\t\tll=getData(ll,pip,5);\n\t\t\t\tll=getData(ll,cap,6);\n\t\t\t\tvar valueCap12=temp.substring(1);\n\n\t\t\t\tif(valueCap12==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tif(CapVal1[capte1]==null)\n\t\t\t\t{\n\t\t\t\tvar valueCap3=valueCap12;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\n\n\t\t\t\t}\n\t\t\t\td.add(cou1,ll,valueCap3,valueCap);\n\t\t\t\tcou1++;\n\t\t\t\tcapte1++;\n\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\n\n\t\ttemp=curval;\n\n\t\t}\n\t\telse \n\t\t{\n\t\ttemp=temp+curval;\n\n\n\t\t}\n\t}\n\tif(temp.length>0 )\n\t{\n\t\ttemp=temp.substring(0,(temp.length-spe));\n\t\tif(temp.indexOf(\"#%#\")!=-1)\n\t\t{\n\t\t\tcounting=3;\n\t\t}\n\t\tvar somethingdata=temp.substring(0,counting)\n\t\tswitch(test(somethingdata))\n\t\t\t{\n\t\t\tcase 0:\n\t\t\t\tvar value11=temp.substring(counting);\n\t\t\t\tif(value11==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(hashVal[hashte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar value1=value11;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar value1=value11+\"     =     \"+hashVal[hashte];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,0,value1,value1);\n\t\t\t\thash=cou1;\n\t\t\t\tcou1++;\n\t\t\t\thashte++;\n\n\t\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 1:\n\t\t\t\tvar value12=temp.substring((counting));\n\t\t\t\tif(value12==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(dolVal[dolte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar value2=value12;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar value2=value12+\"     =     \"+dolVal[dolte];\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\td.add(cou1,hash,value2,value2);\n\t\t\t\tdola=cou1;\n\t\t\t\tcou1++;\n\t\t\t\tdolte++;\n\t\t\tbreak;\n\t\t\tcase 2:\n\t\t\t\tdola=getData(dola,hash,1);\n\t\t\t\tvar value13=temp.substring((counting));\n\t\t\t\tif(value13==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(PerVal[perte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar value3=value13;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar value3=value13+\"     =     \"+PerVal[perte];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,dola,value3,value3);\n\t\t\t\tperce=cou1;\n\t\t\t\tperce=cou1;\n\t\t\t\tcou1++;\n\t\t\t\tperte++;\n\t\t\t\tcounting=0;\n\t\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 3:\n\t\t\t\tperce =getData(perce,hash,1);\n\t\t\t\tperce=getData(perce,dola,2);\n\t\t\t\tvar somevalue1=\"\";\n\t\t\t\tvar somevalue=temp.substring(counting);\n\t\t\t\tif(somevalue==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(boxval[boxte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tsomevalue1=somevalue;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tsomevalue1=somevalue+\"     =     \"+Lesstan[lesste];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,perce,somevalue1,\"\");\n\t\t\t\tsom=cou1;\n\t\t\t\tboxte++;\n\t\t\t\tcou1++;\n\t\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 4:\n\t\t\t\tsom =getData(som,hash,1);\n\t\t\t\tsom=getData(som,dola,2);\n\t\t\t\tsom=getData(som,perce,3);\n\t\t\t\tvar lessval1=\"\";\n\t\t\t\tvar lessval=temp.substring(1);\n\t\t\t\tif(lessval==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(Lesstan[lesste]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tlessval1=lessval;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,som,lessval1,valuePip);\n\t\t\t\tpip=cou1;\n\t\t\t\tlesste++;\n\t\t\t\tcou1++;\n\t\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 5:\n\t\t\t\tpip=getData(pip,hash,1);\n\t\t\t\tpip=getData(pip,dola,2);\n\t\t\t\tpip=getData(pip,perce,3);\n\t\t\t\tpip=getData(pip,som,4);\n\t\t\t\tvar valuePip1=temp.substring(1);\n\t\t\t\tif(valuePip1==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(PiptVal[pipte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valuePip=valuePip1;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n\t\t\t\t\t}\n\n\t\t\t\td.add(cou1,pip,valuePip,valuePip);\n\n\t\t\t\tcap=cou1;\n\t\t\t\tcou1++;\n\t\t\t\tpipte++;\n\n\t\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 6:\n\t\t\t\tcap=getData(cap,hash,1);\n\t\t\t\tcap=getData(cap,dola,2);\n\t\t\t\tcap=getData(cap,perce,3);\n\t\t\t\tcap=getData(cap,som,4);\n\t\t\t\tcap=getData(cap,pip,5);\n\t\t\t\tvar valueCap1=temp.substring(1);\n\t\t\t\tif(valueCap1==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(CapVal[capte]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valueCap=valueCap1;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,cap,valueCap,valueCap);\n\t\t\t\tll=cou1;\n\t\t\t\tcou1++;\n\t\t\t\tcapte++;\n\t\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 7:\n\t\t\t\tll=getData(ll,hash,1);\n\t\t\t\tll=getData(ll,dola,2);\n\t\t\t\tll=getData(ll,perce,3);\n\t\t\t\tll=getData(ll,som,4);\n\t\t\t\tll=getData(ll,pip,5);\n\t\t\t\tll=getData(ll,cap,6);\n\t\t\t\tvar valueCap12=temp.substring(1);\n\t\t\t\tif(valueCap12==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(CapVal1[capte1]==null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valueCap3=valueCap12;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\t\t\t\t\t}\n\t\t\t\td.add(cou1,ll,valueCap3,valueCap);\n\t\t\t\tcou1++;\n\t\t\t\tcapte1++;\n\t\t\t\t}\n\t\t\t\tbreak;\n\t\t\t\tcase \'*\':\n\t\t\t\tbreak;\n\t\t}\n\t}\n\tdocument.write(d);\n\t\t}\n\n\telse\n\t{\n\t\t\n\tk2=messegetext;\n\tfor(var i=0;i<k2.length;i++)\n\t{\n\tcurval=(k2.charAt(i)).toString();\n\tcurval1=(k2.charAt(i)).toString();\n\tsome=(k2.charAt(i)).toString()+((k2.charAt(i+1)).toString())+((k2.charAt(i+2)).toString());\n\tif((k2.charAt(i+2)).toString()==\"\" && (k2.charAt(i+1)).toString()==\"\")\n\t{\n\tsome=some+\'laxs*.\'+\'lax*.\';\n\t}\n\tif(curval==\'+\')\n\t{\n\tcurval=\'      \';\n\t}\n\tif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n\t{\n\tcompilesimples=(i+2);\n\tsome1=some;\n\tcounting=3;\t\t\t\t \n\tspe=2;\n\t}\n\telse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n\t{\n\tcurval=curval1;\n\tspe=0;\n\tcounting=1;\n\t}\n\n\tif(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == \'*\')\n\t{\n\tif(temp.length>0 || curval == intSymbols[3])\n\t\t{\n\t\tvar somethingdata=temp.substring(0,counting);\n\t\tswitch(test(somethingdata))\n\t\t{\n\t\t\tcase 0:\n\t\t\tbreak;\n\t\t\tcase 1:\n\t\t\tbreak;\n\t\t\tcase 2:\n\t\t\tbreak;\n\t\t\tcase 3:\n\t\t\tmessagehead=temp.substring(1);\n\t\t\tif(messagehead==\"\" || messagehead==null)\n\t\t\t{\n\t\t\t\tboxval[box]=messagehead;\n\t\t\t\tbox++;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tboxval[box]=messagehead;\n\t\t\t\tbox++;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 4:\n\t\t\tvar value3=temp.substring(1);\n\n\t\t\n\t\t\tif (value3==null)\n\t\t\t{\n\t\t\t\tLesstan[less]=messagehead;\n\t\t\t\tless++;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tLesstan[less]=value3;\n\t\t\t\tless++;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 5:\n\t\t\tPiptVal[Pipt]=temp.substring(1);\n\t\t\n\t\t\tPipt++;\n\t\t\tbreak;\n\t\t\tcase 6:\n\t\t\tCapVal[Capt]=temp.substring(1);\n\t\t\t\n\t\t\tCapt++;\n\t\t\tbreak;\n\t\t\tcase 7:\n\t\t\tCapVal1[Capt1]=temp.substring(1);\n\t\t\tCapt1++;\n\t\t\tbreak;\n\t\t\tcase \'*\':\n\t\t\tbreak;\n\t\t\tcase \'&\':\n\t\t\tbreak;\n\t\t}\n\t}\n\ttemp=curval;\n\t}\n\telse \n\t{\n\t\ttemp=temp+curval;\n\t}\n}\n\tif(temp.length>0)\n\t\t{\n\t\tswitch(test(curval))\n\t\t{\n\t\t\tcase 0:\n\t\t\tbreak;\n\t\t\tcase 1:\n\t\t\tbreak;\n\t\t\tcase 2:\n\t\t\tbreak;\n\t\t\tcase 3:\n\t\t\tmessagehead=temp.substring(1);\n\t\t\tif(messagehead==\"\" || messagehead==null)\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tboxval[box]=messagehead;\n\t\t\t\tbox++;\n\n\t\t\t}\n\n\t\t\tbreak;\n\t\t\tcase 4:\n\t\t\tLesstan[less]=temp.substring(1);\n\t\t\tless++;\n\t\t\tbreak;\n\t\t\tcase 5:\n\n\t\t\tif(temp.substring(1)==\'*\')\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tPiptVal[Pipt]=temp.substring(1);\n\t\t\t\tPipt++;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 6:\n\t\t\tCapVal[Capt]=temp.substring(1);\n\t\t\tCapt++;\n\t\t\tbreak;\n\t\t\tcase 7:\n\t\t\tCapVal1[Capt1]=temp.substring(1);\n\t\t\tCapt1++;\n\t\t\tcase \'*\':\n\t\t\tbreak;\n\t\t\tcase \'&\':\n\t\t\tbreak;\n\t\t}\n\t}\n\n\n\t/**************************populate Tree*************************////\n\t/**********************************Populate Tree*****************************/\n\tvar tswte=0;\n\tvar Atte=0;\n\tvar Excte=0;\n\tvar pipte=0;\n\tvar capte=0;\n\tvar cou1=1;\n\tvar Opente=0;\n\tvar Closete=0;\n\tvar Amperte=0\n\tvar hashte=0;\n\tvar dolte=0;\n\tvar perte=0;\n\tvar lesste=0;\n\tvar cap=0;\n\td.add(0,-1,\'\');\n\tvar some1;\n\tvar boxte=0;\n\tfor(var i=0;i<messegesyntax.length;i++)\n\t{\n\t\tcurval=(messegesyntax.charAt(i)).toString();\n\t\tcurval1=(messegesyntax.charAt(i)).toString();\n\t\tsome=(messegesyntax.charAt(i)).toString()+((messegesyntax.charAt(i+1)).toString())+((messegesyntax.charAt(i+2)).toString());\n\t\tif((messegesyntax.charAt(i+2)).toString()==\"\" && (messegesyntax.charAt(i+1)).toString()==\"\")\n\t\t{\n\t\t\tsome=some+\"lak,xm\"+\"lak,xm\";\n\t\t}\n\t\tif(compilesimples==i)\n\t\t{\n\t\t\tcurval=some1;\n\t\t}\n\t\tif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n\t\t{\n\t\t\tcompilesimples=(i+2);\n\t\t\tsome1=some;\n\t\t\tcounting=3;\n\t\t\tspe=2;\n\t\t}\n\t\telse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n\t\t{\n\t\t\tcurval=curval1;\n\t\t\tspe=0;\n\t\t\tcounting=1;\n\t\t}\n\t\tif(curval==\"+\")\n\t\t{\n\t\t\tcurval=\"  \";\n\t\t}\n\t\tif(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])\n\t\t{\n\t\tif(temp.length>0 )\n\t\t\t{\n\t\t\t\ttemp=temp.substring(0,(temp.length-spe));\n\t\t\tif(temp.indexOf(\"#%#\")!=-1)\n\t\t\t{\n\t\t\t\tcounting=3;\n\t\t\t\tvar somethingdata=temp.substring(0,counting);\n\t\t\t}\n\t\t\tvar somethingdata=temp.substring(0,counting)\n\t\t\tswitch(test(somethingdata))\n\t\t\t{\n\t\t\tcase 0:\n\t\t\tvar value11=temp.substring(counting);\n\t\t\tif(value11==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(hashVal[hashte]==null)\n\t\t\t{\n\t\t\tvar value1=value11;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar value1=value11+\"     =     \"+hashVal[hashte];\n\t\t\t}\n\t\t\td.add(cou1,0,value1,value1);\n\t\t\thash=cou1;\n\t\t\tcou1++;\n\t\t\thashte++;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 1:\n\t\t\tvar value12=temp.substring((counting));\n\t\t\tif(value12==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(dolVal[dolte]==null)\n\t\t\t{\n\t\t\tvar value2=value12;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar value2=value12+\"     =     \"+dolVal[dolte];\n\t\t\t}\n\t\t\td.add(cou1,hash,value2,value2);\n\t\t\tdola=cou1;\n\t\t\tcou1++;\n\t\t\tdolte++;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 2:\n\t\t\tdola=getData(dola,hash,1);\n\t\t\tvar value3=\"\";\n\t\t\tvar value13=temp.substring((counting));\n\t\t\tif(value13==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(PerVal[perte]==null)\n\t\t\t{\n\t\t\tvar value3=value13;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar value3=value13+\"     =     \"+PerVal[perte];\n\t\t\t}\n\t\t\td.add(cou1,dola,value3,value3);\n\t\t\tperce=cou1;\n\t\t\tperce=cou1;\n\t\t\tcou1++;\n\t\t\tperte++;\n\t\t\tcounting=0;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 3:\n\t\t\tperce =getData(perce,hash,1);\n\t\t\tperce=getData(perce,dola,2);\n\t\t\tvar somevalue1=\"\";\n\t\t\tvar somevalue=temp.substring(counting);\n\n\t\t\t\tif(somevalue==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tif(boxval[boxte]==null)\n\t\t\t\t{\n\t\t\t\t\tsomevalue1=somevalue;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tsomevalue1=somevalue+\"     =     \"+boxval[boxte];\n\t\t\t\t}\n\t\t\t\td.add(cou1,perce,somevalue1,\"\");\n\t\t\t\tsom=cou1;\n\t\t\t\tboxte++;\n\t\t\t\tcou1++;\n\t\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 4:\n\t\t\tsom =getData(som,hash,1);\n\t\t\tsom=getData(som,dola,2);\n\t\t\t//som=getdata(som,perce,3);\n\t\t\tvar lessval1=\"\";\n\t\t\tvar lessval=temp.substring(counting);\n\n\t\t\tif(lessval==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(Lesstan[lesste]==null)\n\t\t\t{\n\t\t\tlessval1=lessval;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\t\t\t}\n\t\t\td.add(cou1,som,lessval1,valuePip);\n\t\t\tpip=cou1;\n\t\t\tlesste++;\n\t\t\tcou1++;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 5:\n\t\t\tpip=getData(pip,hash,1);\n\t\t\tpip=getData(pip,dola,2);\n\t\t\tpip=getData(pip,perce,3);\n\t\t\tpip=getData(pip,som,4);\n\t\t\tvar valuePip1=temp.substring(1);\n\t\t\tif(valuePip1==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(PiptVal[pipte]==null)\n\t\t\t{\n\t\t\tvar valuePip=valuePip1;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\t\t\t}\n\n\t\t\t\n\t\t\td.add(cou1,pip,valuePip,valuePip);\n\t\t\tcap=cou1;\n\t\t\tcou1++;\n\t\t\tpipte++;\n\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 6:\n\t\t\tcap=getData(cap,hash,1);\n\t\t\tcap=getData(cap,dola,2);\n\t\t\tcap=getData(cap,perce,3);\n\t\t\tcap=getData(cap,som,4);\n\t\t\tcap=getData(cap,pip,5);\n\t\t\tvar valueCap1=temp.substring(1);\n\t\t\t\tif(valueCap1==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tif(CapVal[capte]==null)\n\t\t\t\t{\n\t\t\t\t\tvar valueCap=valueCap1;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\t\t\t\t}\n\t\t\t\n\t\t\td.add(cou1,cap,valueCap,valueCap);\n\t\t\tll=cou1;\n\t\t\tcou1++;\n\t\t\tcapte++;\n\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 7:\n\t\t\tll=getData(ll,hash,1);\n\t\t\tll=getData(ll,dola,2);\n\t\t\tll=getData(ll,perce,3);\n\t\t\tll=getData(ll,som,4);\n\t\t\tll=getData(ll,pip,5);\n\t\t\tll=getData(ll,cap,6);\n\t\t\tvar valueCap12=temp.substring(1);\n\t\t\t\tif(valueCap12==\"\")\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tif(CapVal1[capte1]==null)\n\t\t\t\t{\n\t\t\t\t\tvar valueCap3=valueCap12;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\t\t\t\t}\n\t\t\t\td.add(cou1,ll,valueCap3,valueCap);\n\t\t\t\tcou1++;\n\t\t\t\tcapte1++;\n\t\t\t\t}\n\t\t\tbreak;\n\t\t\tcase \'*\':\n\t\t\tbreak;\n\t\t\t}\n\t\t}\n\n\n\t\ttemp=curval;\n\n\t\t}\n\t\telse \n\t\t{\n\t\ttemp=temp+curval;\n\n\n\t\t}\n\t}\n\tif(temp.length>0 )\n\t{\n\t\ttemp=temp.substring(0,(temp.length-spe));\n\t\tswitch(test(curval))\n\n\t\t{\n\t\t\tcase 0:\n\n\n\t\t\tvar value11=temp.substring(counting);\n\n\t\t\tif(value11==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(hashVal[hashte]==null)\n\t\t\t{\n\t\t\tvar value1=value11;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\n\t\t\tvar value1=value11+\"     =     \"+hashVal[hashte];\n\t\t\t}\n\t\t\td.add(cou1,0,value1,value1);\n\t\t\thash=cou1;\n\t\t\tcou1++;\n\t\t\thashte++;\n\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 1:\n\n\n\n\t\t\tvar value12=temp.substring((counting));\n\n\n\n\t\t\tif(value12==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(dolVal[dolte]==null)\n\t\t\t{\n\t\t\tvar value2=value12;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar value2=value12+\"     =     \"+dolVal[dolte];\n\t\t\t}\n\t\t\t}\n\t\t\td.add(cou1,hash,value2,value2);\n\t\t\tdola=cou1;\n\t\t\tcou1++;\n\t\t\tdolte++;\n\n\t\t\tbreak;\n\t\t\tcase 2:\n\t\t\tdola=getData(dola,hash,1);\n\t\t\tvar value13=temp.substring((counting));\n\n\n\t\t\tif(value3==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(PerVal[perte]==null)\n\t\t\t{\n\t\t\tvar value3=value13;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar value3=value13+\"     =     \"+PerVal[perte];\n\t\t\t}\n\t\t\td.add(cou1,dola,value3,value3);\n\t\t\tperce=cou1;\n\t\t\tperce=cou1;\n\t\t\tcou1++;\n\t\t\tperte++;\n\t\t\tcounting=0;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 3:\n\n\t\t\tperce =getData(perce,hash,1);\n\t\t\tperce=getData(perce,dola,2);\n\n\t\t\tvar somevalue1=\"\";\n\n\n\t\t\tvar somevalue=temp.substring(counting+2);\n\t\t\tif(somevalue==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(boxval[boxte]==null)\n\t\t\t{\n\t\t\tsomevalue1=somevalue;\n\n\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tsomevalue1=somevalue+\"     =     \"+Lesstan[lesste];\n\t\t\t}\n\n\n\t\t\td.add(cou1,perce,somevalue1,\"\");\n\t\t\tsom=cou1;\n\t\t\tboxte++;\n\t\t\tcou1++;\n\n\t\t\t}\n\n\n\t\t\tbreak;\n\t\t\tcase 4:\n\n\t\t\tsom =getData(som,hash,1);\n\t\t\tsom=getData(som,dola,2);\n\t\t\t//som=getdata(som,perce,3);\n\t\t\tvar lessval1=\"\";\n\t\t\tvar lessval=temp.substring(1);\n\n\t\t\tif(lessval==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(Lesstan[lesste]==null)\n\t\t\t{\n\t\t\tlessval1=lessval;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\t\t\t}\n\t\t\td.add(cou1,som,lessval1,valuePip);\n\t\t\tpip=cou1;\n\t\t\tlesste++;\n\t\t\tcou1++;\n\n\t\t\t}\n\n\t\t\tbreak;\n\t\t\tcase 5:\n\t\t\tpip=getData(pip,hash,1);\n\t\t\tpip=getData(pip,dola,2);\n\t\t\tpip=getData(pip,perce,3);\n\t\t\tpip=getData(pip,som,4);\n\n\n\t\t\tvar valuePip1=temp.substring(1);\n\n\n\n\t\t\tif(valuePip1==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(PiptVal[pipte]==null)\n\t\t\t{\n\t\t\tvar valuePip=valuePip1;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n\t\t\t}\n\n\t\t\td.add(cou1,pip,valuePip,valuePip);\n\n\t\t\tcap=cou1;\n\t\t\tcou1++;\n\t\t\tpipte++;\n\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 6:\n\t\t\tcap=getData(cap,hash,1);\n\t\t\tcap=getData(cap,dola,2);\n\t\t\tcap=getData(cap,perce,3);\n\t\t\tcap=getData(cap,som,4);\n\t\t\tcap=getData(cap,pip,5);\n\t\t\tvar valueCap1=temp.substring(1);\n\n\n\t\t\tif(valueCap1==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(CapVal[capte]==null)\n\t\t\t{\n\t\t\tvar valueCap=valueCap1;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\n\n\t\t\t}\n\t\t\td.add(cou1,cap,valueCap,valueCap);\n\t\t\tll=cou1;\n\t\t\tcou1++;\n\t\t\tcapte++;\n\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase 7:\n\t\t\tll=getData(ll,hash,1);\n\t\t\tll=getData(ll,dola,2);\n\t\t\tll=getData(ll,perce,3);\n\t\t\tll=getData(ll,som,4);\n\t\t\tll=getData(ll,pip,5);\n\t\t\tll=getData(ll,cap,6);\n\t\t\tvar valueCap12=temp.substring(1);\n\t\t\tif(valueCap12==\"\")\n\t\t\t{\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tif(CapVal1[capte1]==null)\n\t\t\t{\n\t\t\tvar valueCap3=valueCap12;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\t\t\t}\n\t\t\td.add(cou1,ll,valueCap3,valueCap);\n\t\t\tcou1++;\n\t\t\tcapte1++;\n\t\t\t}\n\t\t\tbreak;\n\t\t\tcase \'*\':\n\t\t\tbreak;\n\t\t}\n\t}\n\n\n\tdocument.write(d);\n\n\t}\n\n\n\n\n\n\n\n\n\n\n\n\n\n\tfunction  getData(val1,val2)\n\t{\n\tif(val1 < val2)   val1 =val2; \n\treturn val1;\t\n\t}\n\tfunction  test(val1)\n\t{\n\tvar align=0;\n\n\n\tfor(var spk=0;spk<SplitinElements.length;spk++)\n\t{\n\tif(val1==intSymbols[spk])\n\t{\n\n\talign=(spk);\n\n\n\t}\n\n\t}\n\n\n\treturn align;\n\t}\n\tfunction  compare(val1)\n\t{\n\n\tvar val2;\n\n\n\n\n\tif(val1==Symbols[0]  || val1==Symbols[1] || val1==Symbols[2] || val1==Symbols[3] || val1==Symbols[4] || val1==Symbols[5] || val1==Symbols[6] || val1==Symbols[7] || val1==Symbols[8] || val1==Symbols[9] || val1==Symbols[10] || val1==Symbols[11] || val1==Symbols[11]  )\n\t{\n\n\tval2=val1;\n\t}\n\telse\n\t{\n\n\tfor(var intds=0;intds<intSymbols.length;intds++)\n\t{\n\n\tif(val1==intSymbols[intds])\n\t{\n\n\tval2=intSymbols[intds];\n\t}\n\n\t}\n\t}\n\treturn val2;\t\n\n\t}\n\n\n\n\n\n\tfunction Trim(str)\n\t{ \n\twhile(str.charAt(0) == (\" \") )\n\t{  str = str.substring(1);\n\t}\n\twhile(str.charAt(str.length-1) == \" \" )\n\t{  str = str.substring(0,str.length-1);\n\n\t}\n\treturn str;\n\t}\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</div>\n</td>\n</tr>\n</TABLE> \n</form>\n\n</BODY>\n</html>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
/* 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
*/

            _bw.write(_wl_block1Bytes, _wl_block1);

Connection connection = null;
CallableStatement ostmt = null;							  
String msgId="";
String ProfileID="";
String ReqText="";
String Req_syntax="";
String Standard_type="";
String Standard_symbols="";


ProfileID=request.getParameter("Profile_id"); 														    
Statement s=null;  
  ResultSet r = null;
msgId = request.getParameter("msgID");
System.out.println("ViewInteractiveTreeLeft.jsp Msg_Id 38 : "+msgId);
String tableNameSuffix="";
String sub_module="";
String purge_status="";
try
{
	if(connection==null) connection = ConnectionManager.getConnection();
}
      catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of ViewSegmentJSP :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
	try
	{   
		 sub_module=XHDBAdapter.checkNull(request.getParameter("sub_module"));
		 purge_status=XHDBAdapter.checkNull(request.getParameter("purge_status"));  
		 

			 s= connection.createStatement();

			 if(purge_status != null && !purge_status.equalsIgnoreCase("null"))
			 {
				
													     
				 if(purge_status.equals(""))
				 {
				   tableNameSuffix = "XH_INTERACTIVE_INTEGRATION a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";		  
				 }																				 
				 else
				 {

					tableNameSuffix = "XH"+"_"+purge_status+"_INTERACTVE_INTEGRTN a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";
				 }								   
					
				// request.setAttribute("purge_status","Y");	   			   			  
			 }	
		 System.out.println("select replace(REQUEST_TEXT,'*','X'), REQUEST_SYNTAX, RESPONSE_TEXT, REPONSE_SYNTAX from "+tableNameSuffix+" and a.MESSAGE_ID='"+msgId+"'");
		 r = s.executeQuery("select replace(REQUEST_TEXT,'*','X'), REQUEST_SYNTAX, RESPONSE_TEXT, REPONSE_SYNTAX from "+tableNameSuffix+" and a.MESSAGE_ID='"+msgId+"'");
	 	 while(r.next())				   
		{													 
			ReqText=XHIdentify.returnvalue(r.getClob(1));
			System.out.println("ViewInteractiveTreeLeft.jsp :ReqText 58 :"+ReqText);
			Req_syntax=XHIdentify.returnvalue(r.getClob(2));
			System.out.println("ViewInteractiveTreeLeft.jsp :Req_syntax 58 :"+Req_syntax);
		}   
	r.close() ;									 				 							    
	s.close();
	ostmt = connection.prepareCall("{ call XHSTANDARD.Fetch_standard_Control_Char(?,?,?) }" ); 
	ostmt.setString(1,ProfileID);
	System.out.println("ViewInteractiveTreeLeft.jsp :ProfileID 69 :"+ProfileID);
	ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
	ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
	ostmt.execute();
	Standard_type=ostmt.getString(2);					 
	Standard_symbols=ostmt.getString(3);
	System.out.println("ViewInteractiveTreeLeft.jsp :Standard_type 75 :"+Standard_type);
	System.out.println("ViewInteractiveTreeLeft.jsp : Standard_symbols77"+Standard_symbols);
if(ostmt!=null) 
ostmt.close();
}
catch(Exception exp)													 
    {
       
	   exp.printStackTrace(System.err);
    }
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewSegments :"+ex.toString());
		   ex.printStackTrace(System.err); }
	    

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Standard_symbols));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Standard_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ReqText));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Req_syntax));
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
