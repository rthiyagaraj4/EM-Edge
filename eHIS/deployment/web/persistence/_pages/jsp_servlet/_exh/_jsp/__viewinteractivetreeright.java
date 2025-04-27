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

public final class __viewinteractivetreeright extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewInteractiveTreeRight.jsp", 1709122405787L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

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

    private final static java.lang.String  _wl_block6 ="\n<head>\n<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n<link rel=\"StyleSheet\" href=\"../../eXH/html/dtree.css\" type=\"text/css\" />\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\"StyleSheet\" href=\"../../eCommon/html/lris_style.css\" type=\"text/css\" />\n<script type=\"text/javascript\" src=\"../../eXH/js/dtree1.js\"></script> \n<script language=\"javascript\" src=\"../../eXH/js/Viewtreeimage2.js\" ></script>\n<script language=\'JavaScript\' src=\'../../eXH/js/Validate.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\'JavaScript\' src=\'../../eXH/js/checkfield.js\'></script>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script>\n//parent.f_query_add_mod.document.location.href=\'../../eXH/jsp/ViewinteractiveMessageTreeLeft.jsp\';\n//parent.f_query_add_mod2.document.location.href=\'../../eXH/jsp/ViewinteractiveMessageTreeRight.jsp\';\n//\tsubmitForm();\n\t</script> \n</head>\n<BODY> \n<form name=\"view_segment_form\" id=\"view_segment_form\">\n<table cellspacing=0 cellpadding=3 width=\'99%\' align=center >\n<tr>   \n<input type=hidden name=\'Req_symbols\' id=\'Req_symbols\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' >\n<input type=hidden name=\'Req_type\' id=\'Req_type\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' >  \n<input type=hidden name=\'Res_txt\' id=\'Res_txt\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >\n<input type=hidden name=\'Res_syn\' id=\'Res_syn\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="\' >\n</tr>\n<tr> \n<td> \n<div class=\"tree\">\n<script language=\"JavaScript\">\nd = new dTree(\'d\');\n\tvar treeval =new Array();\n\tvar tswArr =new Array();\n\tvar AtArr =new Array();\n\tvar ExcArr =new Array();\n\tvar pipArr =new Array();\n\tvar capArr =new Array();\n\tvar TextVal=new Array();\n\tvar tswVal=new Array();\n\tvar AtVal=new Array();\n\tvar ExcVal=new Array();\n\tvar PiptVal=new Array();\n\tvar CapVal=new Array();\n\tvar AmperVal=new Array();\n\tvar OpenVal=new Array();\n\tvar CloseVal=new Array();\n\tvar tsw=0;\n\tvar cou=1;\n\tvar Exc=0;\n\tvar At=0;\n\tvar pip=0;\n\tvar tswt=0;\n\tvar Att=0;\n\tvar Exct=0;\n\tvar Pipt=0;\n\tvar Capt=0;\n\tvar Ampert=0\n\tvar treeval =new Array();\n\tvar hashArr =new Array();\n\tvar dolArr =new Array();\n\tvar perArr =new Array();\n\tvar pipArr =new Array();\n\tvar capArr =new Array();\n\tvar dolVal=new Array();\n\tvar PerVal=new Array();\n\tvar hashVal=new Array();\n\tvar TextVal=new Array();\n\tvar Open=0;\n\tvar Amper=0;\n\tvar Opent=0;\n\tvar Closet=0;\n\tvar pip=0;var Cap=0;\n\tvar hash=0;\n\tvar hashCou;\n\tvar dolCou;\n\tvar perCou;\n\tvar pipCou;\n\tvar capCou;\n\tvar l_pos;\n\tvar cou=1;\n\tvar temp=\'\';\n\tvar perce=0;\n\tvar dola=0;\n\tvar som=0;\n\tvar pip=0;\n\tvar hasht=0;\n\tvar dolt=0;\n\tvar Pert=0;\n\tvar ll=0;\n\tvar capte1=0;\n\tvar k2=\"\";\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar symbolvalue;\n\tvar temp=\'\';\n\tvar d1=0;\n\tvar val=\"\";\n\tvar acchar=0;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\tvar sy=\'\';\n\tvar Symbols=new Array();\n\tvar s1=0;\n\tvar Lesstan=new Array();\n\tvar less=0;\n\tvar messagehead=\"\";\n\tvar CapVal1=new Array();\n\tvar Capt1=0;\n\tvar boxval=new Array();\n\tvar box=0;\n\tvar messegetext=unescape(document.forms[0].Res_txt.value)+\'|\';\n\tvar messegesyntax=unescape(document.forms[0].Res_syn.value)+\'|\';\n\tvar standard_symbols=document.forms[0].Req_symbols.value;\n\tif(messegetext==\'\' || messegesyntax==\'\')\n\t{\n\talert(getMessage(\'XH0057\',\'XH\'));\n\t}\n\telse\n\t{\n\t\tvar compilesimples=3;\n\t\tif(messegesyntax.indexOf(\"###\")!=-1);\n\t\t{\n\t\tstandard_symbols=\"35|35|35{{{35|36|35{{{35|37|35{{{\"+document.forms[0].Req_symbols.value;\n\t\t}\n\t\tvar standard_type1=document.forms[0].Req_type.value;\n\t\tvar perce=0;\n\t\tvar SplitinElements=new Array();\n\t\tvar sp=0;\n\t\tvar spliting=standard_symbols.split(\"{{{\");\n\t\tfor(var s=0;s<spliting.length;s++)\n\t\t{\n\t\tif(spliting[s]!=\'\')\n\t\t\t{\n\t\tif(spliting[s].indexOf(\'|\')!=-1)\n\t\t{\n\t\tvar SpilitngStandardpip=spliting[s].split(\'|\');\n\t\tSplitinElements[sp]=SpilitngStandardpip[1];\n\t\t}\n\t\telse\n\t\t{\n\t\tSplitinElements[sp]=spliting[s];\n\n\t\t}\n\t\tsp++;\n\t\t\t}\n\n\t\t}\n\n\t\tvar spt1=0;\n\t\tvar intSymbols=new Array();\n\t\tvar intd=0;\n\n\t\tfor(var spt=0;spt<SplitinElements.length;spt++)\n\t\t{\n\t\tif(spt==0 || spt==1 || spt==2)\n\t\t{\n\t\tSymbols[spt1]=\"#\"+String.fromCharCode(SplitinElements[spt])+\"#\";\n\t\tintSymbols[intd]=\"#\"+String.fromCharCode(SplitinElements[spt])+\"#\";\n\t\tintd++;\n\t\t}\n\t\telse\n\t\t{\n\t\tSymbols[spt1]=String.fromCharCode(SplitinElements[spt]);\n\t\tintSymbols[intd]=String.fromCharCode(SplitinElements[spt]);\n\n\t\tintd++;\n\t\t}\n\t\tspt1++;\n\n\t\t}\n\t\tif(standard_type1==\'H\')\n\t\t   {\n\t\t\t\tvar pipsimple=\"|\";\n\t\t\t\tvar pipsym=messegetext.indexOf(\'|\');\n\t\t\t\tvar firstmessage=messegetext.substring(0,pipsym);\n\n\t\t\t\tCapVal[0]=pipsimple;\n\t\t\t\tPiptVal[0]=firstmessage;\n\t\t\t\tvar messagevaluepip=messegetext.substring((pipsym+1),messegetext.length);\n\t\t\t\tvar nextpip=messagevaluepip.indexOf(\'|\');\n\t\t\t\tvar massagenextpip=messagevaluepip.substring(0,nextpip);\n\t\t\t\tvar secondsplit=messagevaluepip.substring(nextpip,messagevaluepip.length);\n\t\t\t\tCapVal[1]=massagenextpip;\n\t\t\t\tif(Symbols[3]!=null )\n\t\t\t\t{\n\t\t\t\t\tvar ch=Symbols[3].toString();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t}\n\t\t\t\tvar identifysimbol=messegesyntax.indexOf(ch);\n\t\t\t\tvar identifypip=messegesyntax.indexOf(\'|\');\n\t\t\t\tvar MsgsubString=messegesyntax.substring(identifysimbol+1,identifypip);\n\t\t\t\tvar tillMegHeead=messegesyntax.substring(0,identifysimbol);\n\t\t\t\tvar tillsegHead=messegesyntax.substring(identifypip,messegesyntax.length);\n\t\t\t\tvar Replace=\"\";\n\t\t\t\tif(Symbols[5]!=null)\n\t\t\t\t{\n\t\t\t\t\tReplace=Symbols[5].toString()+MsgsubString;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tReplace=ch+MsgsubString;\n\t\t\t\t}\n\t\t\t\tmessegesyntax=tillMegHeead+ch+Replace+tillsegHead+\'|\';\n\t\t\t\tCapt=2;\n\t\t\t\tk2=secondsplit;\n\t\t\t\tPipt=1;\n\t\t\t\tfor(var i=0;i<k2.length;i++)\n\t\t\t\t{\n\t\t\t\t\tcurval= (k2.charAt(i)).toString();\n\t\t\t\tif(curval==\'+\')\n\t\t\t\t{\n\t\t\t\t\tcurval=\' \';\n\t\t\t\t}\n\t\t\t\tif(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == \'*\')\n\t\t\t\t{\n\t\t\t\t\tif(temp.length>0 || curval == intSymbols[3])\n\t\t\t\t\t{\n\t\t\t\t\t\tvar somethingdata=temp.substring(0,1);\n\t\t\t\t\t\tswitch(test(somethingdata))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tcase 0:\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase 1:\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase 2:\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase 3:\n\t\t\t\t\t\t\tboxval[box]=temp.substring(1);\n\t\t\t\t\t\t\tbox++;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase 4:\n\t\t\t\t\t\t\tvar value3=temp.substring(1);\n\t\t\t\t\t\t\tif (value3==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tLesstan[less]=messagehead;\n\t\t\t\t\t\t\t\tless++;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tLesstan[less]=value3;\n\t\t\t\t\t\t\t\tless++;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase 5:\n\t\t\t\t\t\t\tPiptVal[Pipt]=temp.substring(1);\n\t\t\t\t\t\t\tPipt++;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase 6:\n\t\t\t\t\t\t\tCapVal[Capt]=temp.substring(1);\n\t\t\t\t\t\t\tCapt++;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase 7:\n\t\t\t\t\t\t\tCapVal1[Capt1]=temp.substring(1);\n\t\t\t\t\t\t\tCapt1++;\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase \'*\':\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\tcase \'&\':\n\t\t\t\t\t\t\tbreak;\n\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\ttemp=curval;\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t{\n\t\t\t\t\ttemp=temp+curval;\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tif(temp.length>0)\n\t\t\t\t{\n\t\t\t\t\tswitch(test(curval))\n\t\t\t\t\t{\n\t\t\t\t\t\tcase 0:\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 1:\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 2:\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 3:\n\t\t\t\t\t\tmessagehead=temp.substring(1);\n\t\t\t\t\t\tif(messagehead==\"\" || messagehead==null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tboxval[box]=messagehead;\n\t\t\t\t\t\t\tbox++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 4:\n\t\t\t\t\t\tLesstan[less]=temp.substring(1);\n\t\t\t\t\t\tless++;\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 5:\n\t\t\t\t\t\tif(temp.substring(1)==\'*\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tPiptVal[Pipt]=temp.substring(1);\n\t\t\t\t\t\t\tPipt++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 6:\n\t\t\t\t\t\tCapVal[Capt]=temp.substring(1);\n\t\t\t\t\t\tCapt++;\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 7:\n\t\t\t\t\t\tCapVal1[Capt1]=temp.substring(1);\n\t\t\t\t\t\tCapt1++;\n\t\t\t\t\t\tcase \'*\':\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase \'&\':\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t }\n\t\t\t\t}\n\t\t\t\t/**************************populate Tree*************************////\n\t\t\t\t/**********************************Populate Tree*****************************/\n\t\t\tvar tswte=0;\n\t\t\tvar Atte=0;\n\t\t\tvar Excte=0;\n\t\t\tvar pipte=0;\n\t\t\tvar capte=0;\n\t\t\tvar cou1=1;\n\t\t\tvar Opente=0;\n\t\t\tvar Closete=0;\n\t\t\tvar Amperte=0\n\t\t\tvar hashte=0;\n\t\t\tvar pipsom=0;\n\t\t\tvar dolte=0;\n\t\t\tvar perte=0;\n\t\t\tvar lesste=0;\n\t\t\tvar cap=0;\n\t\t\tvar boxte=0;\n\t\t\td.add(0,-1,\'\');\n\t\t\tvar counting=1;\n\t\t\tvar spe=0;\n\t\t\tfor(var i=0;i<messegesyntax.length;i++)\n\t\t\t{\n\t\t\t\tcurval=(messegesyntax.charAt(i)).toString();\n\t\t\t\tcurval1=(messegesyntax.charAt(i)).toString();\n\t\t\t\tsome=(messegesyntax.charAt(i)).toString()+((messegesyntax.charAt(i+1)).toString())+((messegesyntax.charAt(i+2)).toString());;\n\t\t\t\tif((messegesyntax.charAt(i+2)).toString()==\"\" || (messegesyntax.charAt(i+1)).toString()==\"\")\n\t\t\t\t{\n\t\t\t\t\tsome=some+\"lam,x\"+\"lam,x\";\n\t\t\t\t}\n\t\t\t\tif(compilesimples==i)\n\t\t\t\t{\n\t\t\t\t\tcurval=some1;\n\t\t\t\t}\n\t\t\t\tif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n\t\t\t\t{\n\t\t\t\t\tcompilesimples=(i+2);\n\t\t\t\t\tsome1=some;\n\t\t\t\t\tcounting=3;\n\t\t\t\t\tspe=2;\n\t\t\t\t}\n\t\t\t\telse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n\t\t\t\t{\n\t\t\t\t\tcurval=curval1;\n\t\t\t\t\tspe=0;\n\t\t\t\t\tcounting=1;\n\t\t\t\t}\n\t\t\t\tif(curval==\"+\")\n\t\t\t\t{\n\t\t\t\t\tcurval=\" \";\n\t\t\t\t}\n\t\t\t\tif(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])\n\t\t\t\t{\n\t\t\t\tif(temp.length>0 )\n\t\t\t\t{\n\t\t\t\t\ttemp=temp.substring(0,(temp.length-spe));\n\t\t\t\t\tif(temp.indexOf(\"#%#\")!=-1)\n\t\t\t\t\t{\n\t\t\t\t\t\tcounting=3\n\t\t\t\t\t}\n\t\t\t\t\tvar somethingdata=temp.substring(0,counting)\n\t\t\t\t\tswitch(test(somethingdata))\n\t\t\t\t\t{\n\t\t\t\t\t\tcase 0:\n\t\t\t\t\t\tvar value11=temp.substring(counting);\n\t\t\t\t\t\tif(value11==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(hashVal[hashte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar value1=value11;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar value1=value11+\"     =     \"+hashVal[hashte];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,0,value1,value1);\n\t\t\t\t\t\thash=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\thashte++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 1:\n\t\t\t\t\t\tvar value12=temp.substring((counting));\n\t\t\t\t\t\tif(value12==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tif(dolVal[dolte]==null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\tvar value2=value12;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tvar value2=value12+\"     =     \"+dolVal[dolte];\n\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,hash,value2,value2);\n\t\t\t\t\t\tdola=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tdolte++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 2:\n\t\t\t\t\t\tdola=getData(dola,hash,1);\n\t\t\t\t\t\tvar value13=temp.substring((counting));\n\t\t\t\t\t\tif(value13==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(PerVal[perte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar value3=value13;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar value3=value13+\"     =     \"+PerVal[perte];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,dola,value3,value3);\n\t\t\t\t\t\tperce=cou1;\n\t\t\t\t\t\tperce=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tperte++;\n\t\t\t\t\t\tcounting=0;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 3:\n\t\t\t\t\t\tperce =getData(perce,hash,1);\n\t\t\t\t\t\tperce=getData(perce,dola,2);\n\t\t\t\t\t\tvar somevalue1=\"\";\n\t\t\t\t\t\tvar somevalue=temp.substring(counting);\n\t\t\t\t\t\tif(somevalue==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(boxval[boxte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tsomevalue1=somevalue;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tsomevalue1=somevalue+\"     =     \"+boxval[boxte];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,perce,somevalue1,\"\");\n\t\t\t\t\t\tpipsom=cou1;\n\t\t\t\t\t\t//som=cou1;\n\t\t\t\t\t\tboxte++;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 4:\n\t\t\t\t\t\tsom =getData(som,hash,1);\n\t\t\t\t\t\tsom=getData(som,dola,2);\n\t\t\t\t\t\tsom=getData(pipsom,perce,3);\n\t\t\t\t\t\tvar lessval1=\"\";\n\t\t\t\t\t\tvar lessval=temp.substring(1);\n\t\t\t\t\t\tif(lessval==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tif(Lesstan[lesste]==null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\tlessval1=lessval;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,som,lessval1,valuePip);\n\t\t\t\t\t\tpipsom=som;\n\t\t\t\t\t\tpip=cou1;\n\t\t\t\t\t\tlesste++;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 5:\n\t\t\t\t\t\tpip=getData(pip,hash,1);\n\t\t\t\t\t\tpip=getData(pip,dola,2);\n\t\t\t\t\t\tpip=getData(pip,perce,3);\n\t\t\t\t\t\tpip=getData(pip,pipsom,4);\n\t\t\t\t\t\tvar valuePip1=temp.substring(1);\n\t\t\t\t\t\tif(valuePip1==\"\"";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 =")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(PiptVal[pipte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valuePip=valuePip1;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tacchar=0;\n\t\t\t\t\t\td.add(cou1,pip,valuePip,valuePip);\n\t\t\t\t\t\tcap=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tpipte++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 6:\n\t\t\t\t\t\tcap=getData(cap,hash,1);\n\t\t\t\t\t\tcap=getData(cap,dola,2);\n\t\t\t\t\t\tcap=getData(cap,perce,3);\n\t\t\t\t\t\tcap=getData(cap,som,4);\n\t\t\t\t\t\tcap=getData(cap,pip,5);\n\t\t\t\t\t\tvar valueCap1=temp.substring(1);\n\t\t\t\t\t\tvar pipchar=\"\";\n\t\t\t\t\t\tif(valueCap1==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(acchar<16)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tpipchar=CapVal[capte];\n\t\t\t\t\t\t\t\tcapte++;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tpipchar=\"\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(pipchar==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valueCap=valueCap1;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valueCap=valueCap1+\"     =     \"+pipchar;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tacchar++;\n\t\t\t\t\t\td.add(cou1,cap,valueCap,valueCap);\n\t\t\t\t\t\tll=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase 7:\n\t\t\t\t\t\tll=getData(ll,hash,1);\n\t\t\t\t\t\tll=getData(ll,dola,2);\n\t\t\t\t\t\tll=getData(ll,perce,3);\n\t\t\t\t\t\tll=getData(ll,som,4);\n\t\t\t\t\t\tll=getData(ll,pip,5);\n\t\t\t\t\t\tll=getData(ll,cap,6);\n\t\t\t\t\t\tvar valueCap12=temp.substring(1);\n\n\t\t\t\t\t\tif(valueCap12==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tif(CapVal1[capte1]==null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\tvar valueCap3=valueCap12;\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\n\n\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,ll,valueCap3,valueCap);\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tcapte1++;\n\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t\t\t}\n\n\n\t\t\t\ttemp=curval;\n\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t{\n\t\t\t\ttemp=temp+curval;\n\n\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(temp.length>0 )\n\t\t\t{\n\t\t\t\ttemp=temp.substring(0,(temp.length-spe));\n\t\t\t\tif(temp.indexOf(\"#%#\")!=-1)\n\t\t\t\t{\n\t\t\t\t\tcounting=3;\n\t\t\t\t}\n\t\t\t\tvar somethingdata=temp.substring(0,counting)\n\t\t\t\tswitch(test(somethingdata))\n\t\t\t\t\t{\n\t\t\t\t\tcase 0:\n\t\t\t\t\t\tvar value11=temp.substring(counting);\n\t\t\t\t\t\tif(value11==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(hashVal[hashte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar value1=value11;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar value1=value11+\"     =     \"+hashVal[hashte];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,0,value1,value1);\n\t\t\t\t\t\thash=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\thashte++;\n\n\t\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 1:\n\t\t\t\t\t\tvar value12=temp.substring((counting));\n\t\t\t\t\t\tif(value12==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(dolVal[dolte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar value2=value12;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar value2=value12+\"     =     \"+dolVal[dolte];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,hash,value2,value2);\n\t\t\t\t\t\tdola=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tdolte++;\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 2:\n\t\t\t\t\t\tdola=getData(dola,hash,1);\n\t\t\t\t\t\tvar value13=temp.substring((counting));\n\t\t\t\t\t\tif(value13==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(PerVal[perte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar value3=value13;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar value3=value13+\"     =     \"+PerVal[perte];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,dola,value3,value3);\n\t\t\t\t\t\tperce=cou1;\n\t\t\t\t\t\tperce=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tperte++;\n\t\t\t\t\t\tcounting=0;\n\t\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 3:\n\t\t\t\t\t\tperce =getData(perce,hash,1);\n\t\t\t\t\t\tperce=getData(perce,dola,2);\n\t\t\t\t\t\tvar somevalue1=\"\";\n\t\t\t\t\t\tvar somevalue=temp.substring(counting);\n\t\t\t\t\t\tif(somevalue==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(boxval[boxte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tsomevalue1=somevalue;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tsomevalue1=somevalue+\"     =     \"+Lesstan[lesste];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,perce,somevalue1,\"\");\n\t\t\t\t\t\tsom=cou1;\n\t\t\t\t\t\tboxte++;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 4:\n\t\t\t\t\t\tsom =getData(som,hash,1);\n\t\t\t\t\t\tsom=getData(som,dola,2);\n\t\t\t\t\t\tsom=getData(som,perce,3);\n\t\t\t\t\t\tvar lessval1=\"\";\n\t\t\t\t\t\tvar lessval=temp.substring(1);\n\t\t\t\t\t\tif(lessval==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(Lesstan[lesste]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tlessval1=lessval;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,som,lessval1,valuePip);\n\t\t\t\t\t\tpip=cou1;\n\t\t\t\t\t\tlesste++;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 5:\n\t\t\t\t\t\tpip=getData(pip,hash,1);\n\t\t\t\t\t\tpip=getData(pip,dola,2);\n\t\t\t\t\t\tpip=getData(pip,perce,3);\n\t\t\t\t\t\tpip=getData(pip,som,4);\n\t\t\t\t\t\tvar valuePip1=temp.substring(1);\n\t\t\t\t\t\tif(valuePip1==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(PiptVal[pipte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valuePip=valuePip1;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\td.add(cou1,pip,valuePip,valuePip);\n\n\t\t\t\t\t\tcap=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tpipte++;\n\n\t\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 6:\n\t\t\t\t\t\tcap=getData(cap,hash,1);\n\t\t\t\t\t\tcap=getData(cap,dola,2);\n\t\t\t\t\t\tcap=getData(cap,perce,3);\n\t\t\t\t\t\tcap=getData(cap,som,4);\n\t\t\t\t\t\tcap=getData(cap,pip,5);\n\t\t\t\t\t\tvar valueCap1=temp.substring(1);\n\t\t\t\t\t\tif(valueCap1==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(CapVal[capte]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valueCap=valueCap1;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,cap,valueCap,valueCap);\n\t\t\t\t\t\tll=cou1;\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tcapte++;\n\t\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\t\t\tcase 7:\n\t\t\t\t\t\tll=getData(ll,hash,1);\n\t\t\t\t\t\tll=getData(ll,dola,2);\n\t\t\t\t\t\tll=getData(ll,perce,3);\n\t\t\t\t\t\tll=getData(ll,som,4);\n\t\t\t\t\t\tll=getData(ll,pip,5);\n\t\t\t\t\t\tll=getData(ll,cap,6);\n\t\t\t\t\t\tvar valueCap12=temp.substring(1);\n\t\t\t\t\t\tif(valueCap12==\"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(CapVal1[capte1]==null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valueCap3=valueCap12;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\td.add(cou1,ll,valueCap3,valueCap);\n\t\t\t\t\t\tcou1++;\n\t\t\t\t\t\tcapte1++;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\tcase \'*\':\n\t\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t\tdocument.write(d);\n\t\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\tk2=messegetext;\n\t\tfor(var i=0;i<k2.length;i++)\n\t\t{\n\t\t curval=(k2.charAt(i)).toString();\n\t\t curval1=(k2.charAt(i)).toString();\n\t\t some=(k2.charAt(i)).toString()+((k2.charAt(i+1)).toString())+((k2.charAt(i+2)).toString());\n\t\t  if((k2.charAt(i+2)).toString()==\"\" && (k2.charAt(i+1)).toString()==\"\")\n\t\t  {\n\t\t some=some+\'laxs*.\'+\'lax*.\';\n\t\t}\n\t\t if(curval==\'+\')\n\t\t{\n\t\tcurval=\'      \';\n\t\t}\n\t\tif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n\t\t{\n\t\tcompilesimples=(i+2);\n\t\tsome1=some;\n\t\tcounting=3;\n\t\tspe=2;\n\t\t}\n\t\telse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n\t\t{\n\n\t\tcurval=curval1;\n\t\tspe=0;\n\t\tcounting=1;\n\n\t\t}\n\t\t if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == \'*\')\n\t\t {\n\t\t if(temp.length>0)\n\t\t{\n\t\tvar somethingdata=temp.substring(0,counting);\n\t\tswitch(test(somethingdata))\n\t\t{\n\t\tcase 0:\n\t\tbreak;\n\t\tcase 1:\n\t\tbreak;\n\t\tcase 2:\n\t\tbreak;\n\t\tcase 3:\n\t\tmessagehead=temp.substring(1);\n\n\t\tif(messagehead==\"\" || messagehead==null)\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tboxval[box]=messagehead;\n\t\tbox++;\n\t\t}\n\t\tbreak;\n\t\tcase 4:\n\t\t\tvar value3=temp.substring(1);\n\t\tif (value3==null)\n\t\t{\n\t\tLesstan[less]=messagehead;\n\t\tless++;\n\t\t}\n\t\telse\n\t\t{\n\t\tLesstan[less]=value3;\n\t\tless++;\n\t\t}\n\t\tbreak;\n\t\tcase 5:\n\t\tPiptVal[Pipt]=temp.substring(1);\n\t\tPipt++;\n\t\tbreak;\n\t\tcase 6:\n\t\tCapVal[Capt]=temp.substring(1);\n\t\tCapt++;\n\t\tbreak;\n\t\tcase 7:\n\t\tCapVal1[Capt1]=temp.substring(1);\n\t\tCapt1++;\n\t\tbreak;\n\t\tcase \'*\':\n\t\tbreak;\n\t\tcase \'&\':\n\t\tbreak;\n\t\t}\n\t\t}\n\t\ttemp=curval;\n\t\t}\n\t\telse \n\t\t  {\n\t\t\ttemp=temp+curval;\n\t\t  }\n\t\t}\n\t\t if(temp.length>0)\n\t\t{\n\t\tswitch(test(curval))\n\t\t{\n\t\tcase 0:\n\t\tbreak;\n\t\tcase 1:\n\t\tbreak;\n\t\tcase 2:\n\t\tbreak;\n\t\tcase 3:\n\t\tmessagehead=temp.substring(1);\n\t\tif(messagehead==\"\" || messagehead==null)\n\t\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tboxval[box]=messagehead;\n\t\tbox++;\n\t\t}\n\t\tbreak;\n\t\tcase 4:\n\t\tLesstan[less]=temp.substring(1);\n\t\tless++;\n\t\tbreak;\n\t\tcase 5:\n\t\tif(temp.substring(1)==\'*\'){\n\t\t}\n\t\telse\n\t\t{\n\t\tPiptVal[Pipt]=temp.substring(1);\n\t\tPipt++;\n\t\t}\n\t\tbreak;\n\t\tcase 6:\n\t\tCapVal[Capt]=temp.substring(1);\n\t\tCapt++;\n\t\tbreak;\n\t\tcase 7:\n\t\tCapVal1[Capt1]=temp.substring(1);\n\t\tCapt1++;\n\t\tcase \'*\':\n\t\tbreak;\n\t\tcase \'&\':\n\t\tbreak;\n\t\t}\n\t\t}\n\t\t/**************************populate Tree*************************////\n\t\t/**********************************Populate Tree*****************************/\n\t\tvar tswte=0;\n\t\tvar Atte=0;\n\t\tvar Excte=0;\n\t\tvar pipte=0;\n\t\tvar capte=0;\n\t\tvar cou1=1;\n\t\tvar Opente=0;\n\t\tvar Closete=0;\n\t\tvar Amperte=0\n\t\tvar hashte=0;\n\t\tvar dolte=0;\n\t\tvar perte=0;\n\t\tvar lesste=0;\n\t\tvar cap=0;\n\t\td.add(0,-1,\'\');\n\t\tvar some1;\n\t\tvar boxte=0;\n\t\tfor(var i=0;i<messegesyntax.length;i++)\n\t\t\t{\n\t\t curval=(messegesyntax.charAt(i)).toString();\n\t\t curval1=(messegesyntax.charAt(i)).toString();\n\t\tsome=(messegesyntax.charAt(i)).toString()+((messegesyntax.charAt(i+1)).toString())+((messegesyntax.charAt(i+2)).toString());\n\t\t  if((messegesyntax.charAt(i+2)).toString()==\"\" && (messegesyntax.charAt(i+1)).toString()==\"\")\n\t\t  {\n\t\t some=some+\"lak,xm\"+\"lak,xm\";\n\t\t}\n\n\n\t\tif(compilesimples==i)\n\t\t{\n\t\tcurval=some1;\n\n\t\t}\n\n\t\tif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n\t\t{\n\t\tcompilesimples=(i+2);\n\t\tsome1=some;\n\t\tcounting=3;\n\t\tspe=2;\n\t\t}\n\t\telse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n\t\t{\n\t\tcurval=curval1;\n\t\tspe=0;\n\t\tcounting=1;\n\t\t}\n\t\t\t\t  \n\t\tif(curval==\"+\")\n\t\t{\n\n\t\tcurval=\"  \";\n\t\t}\n\t\t/*if(compilesimples%3=0)\n\t\t{\n\n\n\t\t}*/\n\n\t\t//if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == Symbols[3] ||curval == Symbols[4] || curval == Symbols[5] || curval == Symbols[6] ||curval == Symbols[7] || curval == Symbols[8] ||curval == Symbols[9] ||curval == Symbols[10] ||  curval == \'*\')\n\t\t \n\t\t if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])\n\t\t \n\t\t {\n\n\n\t\t//|| curval == intSymbols[3]\n\n\t\t if(temp.length>0 )\n\t\t{\n\n\t\ttemp=temp.substring(0,(temp.length-spe));\n\t\tif(temp.indexOf(\"#%#\")!=-1)\n\t\t{\n\t\tcounting=3;\n\t\tvar somethingdata=temp.substring(0,counting);\n\n\t\t}\n\n\n\t\tvar somethingdata=temp.substring(0,coun";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block10_2 ="ting)\n\n\t\tswitch(test(somethingdata))\n\t\t {\n\t\tcase 0:\n\n\n\t\tvar value11=temp.substring(counting);\n\n\t\tif(value11==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(hashVal[hashte]==null)\n\t\t{\n\t\tvar value1=value11;\n\t\t}\n\t\telse\n\t\t{\n\n\t\tvar value1=value11+\"     =     \"+hashVal[hashte];\n\t\t}\n\t\td.add(cou1,0,value1,value1);\n\t\thash=cou1;\n\t\tcou1++;\n\t\thashte++;\n\n\t\t}\n\t\tbreak;\n\t\tcase 1:\n\n\n\n\t\tvar value12=temp.substring((counting));\n\n\n\n\t\tif(value12==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(dolVal[dolte]==null)\n\t\t{\n\t\tvar value2=value12;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar value2=value12+\"     =     \"+dolVal[dolte];\n\t\t}\n\t\td.add(cou1,hash,value2,value2);\n\t\tdola=cou1;\n\t\tcou1++;\n\t\tdolte++;\n\t\t}\n\n\n\t\tbreak;\n\t\tcase 2:\n\t\tdola=getData(dola,hash,1);\n\t\tvar value3=\"\";\n\n\t\tvar value13=temp.substring((counting));\n\n\n\t\tif(value13==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(PerVal[perte]==null)\n\t\t{\n\t\tvar value3=value13;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar value3=value13+\"     =     \"+PerVal[perte];\n\t\t}\n\n\n\t\td.add(cou1,dola,value3,value3);\n\t\tperce=cou1;\n\t\tperce=cou1;\n\t\tcou1++;\n\t\tperte++;\n\t\tcounting=0;\n\t\t}\n\t\tbreak;\n\t\tcase 3:\n\n\t\tperce =getData(perce,hash,1);\n\t\tperce=getData(perce,dola,2);\n\n\t\tvar somevalue1=\"\";\n\n\n\t\tvar somevalue=temp.substring(counting);\n\n\t\tif(somevalue==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\n\t\tif(boxval[boxte]==null)\n\t\t{\n\t\tsomevalue1=somevalue;\n\n\n\t\t}\n\t\telse\n\t\t{\n\t\tsomevalue1=somevalue+\"     =     \"+boxval[boxte];\n\t\t}\n\n\n\t\td.add(cou1,perce,somevalue1,\"\");\n\t\tsom=cou1;\n\t\tboxte++;\n\t\tcou1++;\n\n\t\t}\n\n\n\t\tbreak;\n\t\tcase 4:\n\n\t\tsom =getData(som,hash,1);\n\t\tsom=getData(som,dola,2);\n\t\t//som=getdata(som,perce,3);\n\t\tvar lessval1=\"\";\n\n\t\tvar lessval=temp.substring(counting);\n\n\t\tif(lessval==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(Lesstan[lesste]==null)\n\t\t{\n\t\tlessval1=lessval;\n\t\t}\n\t\telse\n\t\t{\n\t\tlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\t\t}\n\t\td.add(cou1,som,lessval1,valuePip);\n\t\tpip=cou1;\n\t\tlesste++;\n\t\tcou1++;\n\n\t\t}\n\n\t\tbreak;\n\t\tcase 5:\n\t\tpip=getData(pip,hash,1);\n\t\tpip=getData(pip,dola,2);\n\t\tpip=getData(pip,perce,3);\n\t\tpip=getData(pip,som,4);\n\n\n\t\tvar valuePip1=temp.substring(1);\n\n\n\n\t\tif(valuePip1==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(PiptVal[pipte]==null)\n\t\t{\n\t\tvar valuePip=valuePip1;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n\t\t}\n\n\t\td.add(cou1,pip,valuePip,valuePip);\n\n\t\t cap=cou1;\n\t\t cou1++;\n\t\t pipte++;\n\n\t\t }\n\t\tbreak;\n\t\tcase 6:\n\t\tcap=getData(cap,hash,1);\n\t\tcap=getData(cap,dola,2);\n\t\tcap=getData(cap,perce,3);\n\t\tcap=getData(cap,som,4);\n\t\tcap=getData(cap,pip,5);\n\t\tvar valueCap1=temp.substring(1);\n\n\n\t\tif(valueCap1==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(CapVal[capte]==null)\n\t\t{\n\t\tvar valueCap=valueCap1;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\n\n\t\t}\n\t\td.add(cou1,cap,valueCap,valueCap);\n\t\tll=cou1;\n\t\tcou1++;\n\t\tcapte++;\n\n\t\t}\n\t\tbreak;\n\t\tcase 7:\n\t\tll=getData(ll,hash,1);\n\t\tll=getData(ll,dola,2);\n\t\tll=getData(ll,perce,3);\n\t\tll=getData(ll,som,4);\n\t\tll=getData(ll,pip,5);\n\t\tll=getData(ll,cap,6);\n\t\tvar valueCap12=temp.substring(1);\n\t\tif(valueCap12==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(CapVal1[capte1]==null)\n\t\t{\n\t\tvar valueCap3=valueCap12;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\n\n\t\t}\n\t\td.add(cou1,ll,valueCap3,valueCap);\n\t\tcou1++;\n\t\tcapte1++;\n\n\t\t}\n\t\tbreak;\n\n\t\tcase \'*\':\n\t\tbreak;\n\t\t}\n\t\t}\n\n\n\t\ttemp=curval;\n\n\t\t}\n\t\telse \n\t\t{\n\t\t\ttemp=temp+curval;\n\n\t\t\t\n\t\t}\n\t\t  }\n\t\t if(temp.length>0 )\n\t\t{\n\t\ttemp=temp.substring(0,(temp.length-spe));\n\t\tswitch(test(curval))\n\n\t\t{\n\t\tcase 0:\n\n\n\t\tvar value11=temp.substring(counting);\n\n\t\tif(value11==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(hashVal[hashte]==null)\n\t\t{\n\t\tvar value1=value11;\n\t\t}\n\t\telse\n\t\t{\n\n\t\tvar value1=value11+\"     =     \"+hashVal[hashte];\n\t\t}\n\t\td.add(cou1,0,value1,value1);\n\t\thash=cou1;\n\t\tcou1++;\n\t\thashte++;\n\n\t\t}\n\t\tbreak;\n\t\tcase 1:\n\n\n\n\t\tvar value12=temp.substring((counting));\n\n\n\n\t\tif(value12==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(dolVal[dolte]==null)\n\t\t{\n\t\tvar value2=value12;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar value2=value12+\"     =     \"+dolVal[dolte];\n\t\t}\n\t\t}\n\t\td.add(cou1,hash,value2,value2);\n\t\tdola=cou1;\n\t\tcou1++;\n\t\tdolte++;\n\n\t\tbreak;\n\t\tcase 2:\n\t\tdola=getData(dola,hash,1);\n\t\tvar value13=temp.substring((counting));\n\n\n\t\tif(value3==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(PerVal[perte]==null)\n\t\t{\n\t\tvar value3=value13;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar value3=value13+\"     =     \"+PerVal[perte];\n\t\t}\n\t\td.add(cou1,dola,value3,value3);\n\t\tperce=cou1;\n\t\tperce=cou1;\n\t\tcou1++;\n\t\tperte++;\n\t\tcounting=0;\n\t\t}\n\t\tbreak;\n\t\tcase 3:\n\n\t\tperce =getData(perce,hash,1);\n\t\tperce=getData(perce,dola,2);\n\n\t\tvar somevalue1=\"\";\n\n\n\t\tvar somevalue=temp.substring(counting+2);\n\t\tif(somevalue==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(boxval[boxte]==null)\n\t\t{\n\t\tsomevalue1=somevalue;\n\n\n\t\t}\n\t\telse\n\t\t{\n\t\tsomevalue1=somevalue+\"     =     \"+Lesstan[lesste];\n\t\t}\n\n\n\t\td.add(cou1,perce,somevalue1,\"\");\n\t\tsom=cou1;\n\t\tboxte++;\n\t\tcou1++;\n\n\t\t}\n\n\n\t\tbreak;\n\t\tcase 4:\n\n\t\tsom =getData(som,hash,1);\n\t\tsom=getData(som,dola,2);\n\t\t//som=getdata(som,perce,3);\n\t\tvar lessval1=\"\";\n\t\tvar lessval=temp.substring(1);\n\n\t\tif(lessval==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(Lesstan[lesste]==null)\n\t\t{\n\t\tlessval1=lessval;\n\t\t}\n\t\telse\n\t\t{\n\t\tlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\t\t}\n\t\td.add(cou1,som,lessval1,valuePip);\n\t\tpip=cou1;\n\t\tlesste++;\n\t\tcou1++;\n\n\t\t}\n\n\t\tbreak;\n\t\tcase 5:\n\t\tpip=getData(pip,hash,1);\n\t\tpip=getData(pip,dola,2);\n\t\tpip=getData(pip,perce,3);\n\t\tpip=getData(pip,som,4);\n\n\n\t\tvar valuePip1=temp.substring(1);\n\n\n\n\t\tif(valuePip1==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(PiptVal[pipte]==null)\n\t\t{\n\t\tvar valuePip=valuePip1;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n\t\t}\n\n\t\td.add(cou1,pip,valuePip,valuePip);\n\n\t\t cap=cou1;\n\t\t cou1++;\n\t\t pipte++;\n\n\t\t }\n\t\tbreak;\n\t\tcase 6:\n\t\tcap=getData(cap,hash,1);\n\t\tcap=getData(cap,dola,2);\n\t\tcap=getData(cap,perce,3);\n\t\tcap=getData(cap,som,4);\n\t\tcap=getData(cap,pip,5);\n\t\tvar valueCap1=temp.substring(1);\n\n\n\t\tif(valueCap1==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(CapVal[capte]==null)\n\t\t{\n\t\tvar valueCap=valueCap1;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\n\n\t\t}\n\t\td.add(cou1,cap,valueCap,valueCap);\n\t\tll=cou1;\n\t\tcou1++;\n\t\tcapte++;\n\n\t\t}\n\t\tbreak;\n\t\tcase 7:\n\t\tll=getData(ll,hash,1);\n\t\tll=getData(ll,dola,2);\n\t\tll=getData(ll,perce,3);\n\t\tll=getData(ll,som,4);\n\t\tll=getData(ll,pip,5);\n\t\tll=getData(ll,cap,6);\n\t\tvar valueCap12=temp.substring(1);\n\n\t\tif(valueCap12==\"\")\n\t\t{\n\t\t}\n\t\telse\n\t\t{\n\t\tif(CapVal1[capte1]==null)\n\t\t{\n\t\tvar valueCap3=valueCap12;\n\t\t}\n\t\telse\n\t\t{\n\t\tvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\n\n\t\t}\n\t\td.add(cou1,ll,valueCap3,valueCap);\n\t\tcou1++;\n\t\tcapte1++;\n\n\t\t}\n\t\tbreak;\n\n\t\tcase \'*\':\n\t\tbreak;\n\t\t}\n\t\t}\n\t\tdocument.write(d);\n\t\t}\n\t}\n\tfunction  getData(val1,val2)\n\t {\n\t\tif(val1 < val2)   val1 =val2; \n\t\treturn val1;\t\n\t }\n\tfunction  test(val1)\n\t{\n\t\tvar align=0;\n\t\tfor(var spk=0;spk<SplitinElements.length;spk++)\n\t\t{\n\t\t\tif(val1==intSymbols[spk])\n\t\t\t{\n\t\t\talign=(spk);\n\t\t\t}\n\t\t}\n\treturn align;\n\t}\n\tfunction  compare(val1)\n\t{\n\t\tvar val2;\n\t\tif(val1==Symbols[0]  || val1==Symbols[1] || val1==Symbols[2] || val1==Symbols[3] || val1==Symbols[4] || val1==Symbols[5] || val1==Symbols[6] || val1==Symbols[7] || val1==Symbols[8] || val1==Symbols[9] || val1==Symbols[10] || val1==Symbols[11] || val1==Symbols[11]  )\n\t\t{\n\t\tval2=val1;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tfor(var intds=0;intds<intSymbols.length;intds++)\n\t\t\t{\n\n\t\t\t\tif(val1==intSymbols[intds])\n\t\t\t\t{\n\n\t\t\t\tval2=intSymbols[intds];\n\t\t\t\t}\n\n\t\t\t}\n\t\t}\n\treturn val2;\t\n\n\t}\n\t   \n\t function Trim(str)\n\t{ \n\t\twhile(str.charAt(0) == (\" \") )\n\t\t  {  str = str.substring(1);\n\t\t  }\n\t\t  while(str.charAt(str.length-1) == \" \" )\n\t\t  {  str = str.substring(0,str.length-1);\n\n\t\t  }\n\t\t  return str;\n\t}\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t</td>\n\t</tr>\n</table>\n</form> \n</BODY>\n</html>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block10_2Bytes = _getBytes( _wl_block10_2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection connection = null;
	CallableStatement ostmt = null;											  
	String msgId="";
	String ProfileID="";
	String res_txt="";
	String tableNameSuffix="";
	String sub_module="";
	String purge_status="";
	String REs_Syn="";
	String Standard_type="";
	String Standard_symbols="";											   
	ProfileID=request.getParameter("Profile_id");
	 msgId = request.getParameter("msgID");
	Statement s=null;
	ResultSet r = null;
	System.out.println("ViewInteractiveTreeRight.jsp Msg_Id 38 : "+msgId);
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


	s= connection.createStatement();
	System.out.println("select REQUEST_TEXT, REQUEST_SYNTAX, replace(response_text,'*','X'), REPONSE_SYNTAX from "+tableNameSuffix+" and a.MESSAGE_ID='"+msgId+"'");  
	r = s.executeQuery("select REQUEST_TEXT, REQUEST_SYNTAX, replace(response_text,'*','X'), REPONSE_SYNTAX from "+tableNameSuffix+" and a.MESSAGE_ID='"+msgId+"'");


	  while(r.next()) 				  
	 {
		res_txt=XHIdentify.returnvalue(r.getClob(3));
		System.out.println("ViewInteractiveTreeRight.jsp :res_txt 58 :"+res_txt);
		REs_Syn=XHIdentify.returnvalue(r.getClob(4)); 
		System.out.println("ViewInteractiveTreeRight.jsp :REs_Syn 58 :"+REs_Syn);
	 }   
	r.close() ;
	s.close();
	ostmt = connection.prepareCall("{ call XHSTANDARD.Fetch_standard_Control_Char(?,?,?) }" ); 
	ostmt.setString(1,ProfileID);
	System.out.println("ViewInteractiveTreeRight.jsp 65:ProfileID "+ProfileID);
	ostmt.registerOutParameter(2,java.sql.Types.VARCHAR);
	ostmt.registerOutParameter(3,java.sql.Types.VARCHAR);
	ostmt.execute();
	Standard_type=ostmt.getString(2);
	Standard_symbols=ostmt.getString(3);
	System.out.println("ViewInteractiveTreeRight.jsp 71:Standard_type     "+Standard_type);
	System.out.println("ViewInteractiveTreeRight.jsp 72:Standard_symbols  "+Standard_symbols);
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
            out.print( String.valueOf(res_txt));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(REs_Syn));
            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);
            _bw.write(_wl_block10_2Bytes, _wl_block10_2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
