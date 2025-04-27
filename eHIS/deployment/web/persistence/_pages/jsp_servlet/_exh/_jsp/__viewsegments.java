package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import oracle.sql.ARRAY;

public final class __viewsegments extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewSegments.jsp", 1709122413287L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!--head-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/dtree.css\" type=\"text/css\" />\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\"StyleSheet\" href=\"../../eCommon/html/lris_style.css\" type=\"text/css\" />\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/dtree1.js\"></script>\n<script language=\"JavaScript\"> \n\nfunction  getData(val1,val2)\n {\n if(val1 < val2)   val1 =val2; \n   return val1;\t\n }\n</script>\n</head>\n<BODY >\n<form name=\"view_segment_form\" id=\"view_segment_form\" >\n<input type=hidden name=\'Facility\' id=\'Facility\' value=\'\'>\n<input type=hidden name=\'Message_ID\' id=\'Message_ID\' value=\'\'>\n<input type=hidden name=\'Protocol_link\' id=\'Protocol_link\' value=\'\'>\n<input type=text id=\'Message_text\' name=\'Message_text\' id=\'Message_text\' value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'  >\n<input type=text id=\'Message_Syn\'name=\'Message_Syn\' value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n<input type=text id=\'Standard_Symbols\' name=\'Standard_Symbols\' id=\'Standard_Symbols\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n<input type=text id=\'Standard_code\' name=\'Standard_code\' id=\'Standard_code\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<input type=text id=\'Standard_type\' name=\'Standard_type\' id=\'Standard_type\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\n\n<!--<input type=hidden name=\'Facility\' id=\'Facility\' value=\'\'>\n<input type=hidden name=\'Message_ID\' id=\'Message_ID\' value=\'\'>\n<input type=hidden name=\'Protocol_link\' id=\'Protocol_link\' value=\'\'>\n<input type=hidden name=\'Message_text\' id=\'Message_text\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=hidden name=\'Message_Syn\' id=\'Message_Syn\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=hidden name=\'Standard_Symbols\' id=\'Standard_Symbols\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=hidden name=\'Standard_code\' id=\'Standard_code\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13_0 ="\'>--->\n<div class=\"tree\">\n<script language=\"JavaScript\">\nd = new dTree(\'d\');\nvar treeval =new Array();\nvar tswArr =new Array();\nvar AtArr =new Array();\nvar ExcArr =new Array();\nvar pipArr =new Array();\nvar capArr =new Array();\nvar TextVal=new Array();\nvar tswVal=new Array();\nvar AtVal=new Array();\nvar ExcVal=new Array();\nvar PiptVal=new Array();\nvar CapVal=new Array();\nvar AmperVal=new Array();\nvar OpenVal=new Array();\nvar CloseVal=new Array();\nvar tsw=0;\nvar cou=1;\nvar temp=\'\';\nvar Exc=0;\nvar At=0;\nvar pip=0;\nvar tswt=0;\nvar Att=0;\nvar Exct=0;\nvar Pipt=0;\nvar Capt=0;\nvar Ampert=0\nvar treeval =new Array();\nvar hashArr =new Array();\nvar dolArr =new Array();\nvar perArr =new Array();\nvar pipArr =new Array();\nvar capArr =new Array();\nvar dolVal=new Array();\t\t\t\t\t   \nvar PerVal=new Array();\nvar hashVal=new Array();\nvar TextVal=new Array();\nvar Open=0;\nvar Amper=0;\nvar Opent=0;\nvar Closet=0;\nvar pip=0;\nvar Cap=0;\nvar hash=0;\nvar hashCou;\nvar dolCou;\nvar perCou;\nvar pipCou;\nvar capCou;\nvar l_pos;\nvar cou=1;\nvar temp=\'\';\nvar perce=0;\nvar dola=0;\n\nvar hasht=0;\nvar dolt=0;\nvar Pert=0;\nvar Capt=0;\n\n//alert(\"frm name1 : \"+parent.parent.frames[0].document.forms[0].name);\n//alert(\"frm name2 : \"+parent.parent.frames[1].document.forms[0].name);\n//alert(\"Syst Def Str : \"+parent.parent.frames[1].document.forms[0].SysDefStr.value);\n//alert(\"Inp_txt Val : \"+parent.parent.frames[1].document.forms[0].InputText.value);\n//alert(parent.frames[0].document.forms[0].name);\nvar k=document.forms[0].Message_Syn.value;\n// alert(parent.frames[0].document.forms[0].name);\n var k2=document.forms[0].Message_text.value;\n  //var f=view_segments_form.Message_Syn.value;\n\n\n//var k=\"#PACS Application$Hospital Siriraj%Update patient information #$@*\";\n//var k2=\"#MSH|^~\\&|IBAEHIS|HS^HS-Facility Siriraj(SRDV)|pacs Application|getwell hospital|20071112105056||ADT^A08|8125|P|2.3|||ALEVN|A08|20071112105056||||20071112105056 PID|||Z100000037||^Test_patient est1^^^||19080310000000|F||OTHERS^Others|^^^^^^M|||||||Z100000037|123456|||||||5110^American||5110^|| PO|Z100000037||||||||Y||||||UN|U||||||KUILA|12-NOV-07|INDBGL-W00155|HS|KUILA|12-NOV-07|INDBGL-W00155|HS| PA|Z100000037||||RES||||||||N|MAI||||||||||N|||||||||N|||||||||N|||||||||N|KUILA|12-NOV-07|INDBGL-W00155|HS|KUILA|12-NOV-07|INDBGL-W00155|HS| ZPR|Z100000037|||||||||||||||||||NEXT||||||||||||FRST||||||||||||EMPR||||||||||||||||||||||||||||||||||||||||4555123568899444|KUILA|12-NOV-07|INDBGL-W00155|HS|KUILA|12-NOV-07|INDBGL-W00155|HS||ID11||ID2||ID3||ID4|||| ZPD|Z100000037|||||||||||||||||||||||||||| ZPI|Z100000037||||||||||||||||||N||||||||||||||HS|HS|N|N||Y|N|||||12-NOV-07|N|||KUILA|12-NOV-07|INDBGL-W00155|HS|KUILA|12-NOV-07|INDBGL-W00155|HS||N||Y|Y|||N|N|Z1|12-NOV-07||123456|ID11|4555123568899444|||||||||||||PRN|||ORN||||||||||||||||||||Test_patient|Test1|||||Test_patient Test1 ,||Test_patient|Test_patie||||Test_patient Test_patie  ,|T231|T230|||T231|T231|TST_FTET|TST1|||TST_FTETST1|TST_FTET|F|10-MAR-08|Y||||1|1||OTHERS||||5110|||N|N\";\n//var k=parent.parent.frames[1].document.forms[0].Message_syntax.value;\n//alert(k);\n//var identify=k;\n//var identify=parent.frames[0].document.forms[0].Message_Syn.value;\n//var k2=document.getElementById(\"Message_text\");\n//alert(k2);\nvar simple1=\"\";\nvar simple2=\"\";\nvar simple3=\"\";\nvar simple4=\"\";\nvar simple5=\"\";\nvar currentvalue;\nfor(var i=0;i<k.length;i++)\n{\ncurval= k.charAt(i);\n\n\nif(curval == \'~\' ||curval == \'@\' ||curval == \'!\' ||curval == \'|\' ||curval == \'^\' || curval == \'#\' || curval == \'$\' ||curval == \'%\' || curval == \'&\' ||curval == \'(\' ||curval == \')\' )\n {\n\n\t\nif(temp.length>0)\n{\nswitch(temp.charAt(0))\n{\ncase \'#\':\nsimple1=\'#\';\nbreak;\ncase \'$\':\nsimple2=\'$\';\n\nbreak;\ncase \'%\':\n\tsimple3=\'%\';\nbreak;\ncase \'|\':\nsimple4=\'|\';\nbreak;\ncase \'^\':\nsimple5=\'^\';\nbreak;\ncase \'~\':\nsimple1=\'~\';\nbreak;\ncase \'@\':\nsimple2=\'@\';\nbreak;\ncase \'!\':\n\tsimple3=\'!\';\nbreak;\ncase \'^\':\nsimple1=\'^\';\nbreak;\ncase \'&\':\nsimple2=\'|\';\nbreak;\ncase \'(\':\nsimple3=\'|\';\nbreak;\ncase \')\':\nsimple4=\'|\';\nbreak;\n}\n}\ntemp=curval;\n }\n else \n{\n\ttemp=temp+curval;\n}\n}\n\nfor(var i=0;i<k2.length;i++)\n{\n curval= k2.charAt(i);\n  if(curval == \'~\' ||curval == \'@\' ||curval == \'!\' ||curval == \'|\' ||curval == \'^\' || curval == \'#\' || curval == \'$\' ||curval == \'%\' || curval == \'&\' ||curval == \'(\' ||curval == \')\' )\n {\n if(temp.length>0)\n{\nswitch(temp.charAt(0))\n{\ncase simple1:\nvar value1=temp.substring(1);\nif(value1==\"\")\n{\n}\nelse\n{\ntswVal[tswt]=value1;\ntswt++;\n}\nbreak;\ncase simple2:\nvar value9=temp.substring(1);\n\nif(value9==\"\")\n{\n}\nelse\n{\nhashVal[hasht]=value9;\nhasht++;\n}\nbreak;\ncase simple3:\nvar value10=temp.substring(1);\nif(value10==\"\")\n{\n}\nelse\n{\ndolVal[dolt]=value10;\ndolt++;\n}\nbreak;\ncase simple4:\nvar value11=temp.substring(1);\nif(value11==\"\")\n{\n}\nelse\n{\nPerVal[Pert]=value11;\nPert++;\n}\nbreak;\ncase simple5:\nvar value122=temp.substring(1);\nif(value11==\"\")\n{\n}\nelse\n{\nCapVal[Capt]=value122;\nCapt++;\n}\nbreak;\n}\n}\ntemp=curval;\n}\nelse \n{\n\ttemp=temp+curval;\n}\n  }\n if(temp.length>0)\n{\nswitch(temp.charAt(0))\n{\ncase simple1:\nvar value1=temp.substring(1);\nif(value1==\"\")\n{\n}\nelse\n{\ntswVal[tswt]=value1;\ntswt++;\n}\nbreak;\ncase simple2:\nvar value9=temp.substring(1);\n\nif(value9==\"\")\n{\n}\nelse\n{\nhashVal[hasht]=value9;\nhasht++;\n}\ncase simple3:\nvar value10=temp.substring(1);\nif(value10==\"\")\n{\n}\nelse\n{\ndolVal[dolt]=value10;\ndolt++;\n}\nbreak;\ncase simple4:\nvar value11=temp.substring(1);\nif(value11==\"\")\n{\n}\nelse\n{\nPerVal[Pert]=value11;\nPert++;\n}\nbreak;\ncase simple5:\nvar value122=temp.substring(1);\nif(value11==\"\")\n{\n}\nelse\n{\nCapVal[Capt]=value122;\nCapt++;\n}\nbreak;\n}\n\n}\n\n\n\nvar tswte=0;\nvar Atte=0;\nvar Excte=0;\nvar pipte=0;\nvar capte=0;\nvar cou1=1;\nvar Opente=0;\nvar Closete=0;\nvar Amperte=0\nvar hashte=0;\nvar dolte=0;\nvar perte=0;\nd.add(0,-1,\'\');\nvar curval1;\n\n\nfor(var i=0;i<k.length;i++)\n{\n curval= k.charAt(i);\nif(curval == \'~\' ||curval == \'@\' ||curval == \'!\' ||curval == \'|\' ||curval == \'^\' || curval == \'#\' || curval == \'$\' ||curval == \'%\' || curval == \'&\' ||curval == \'(\' ||curval == \')\' )\n {\n if(temp.length>0)\n{\nswitch(temp.charAt(0))\n{\ncase simple1:\nvar valuetsw1=temp.substring(1);\nif(valuetsw1==\"\")\n{\n}\nelse\n{\nif(tswVal[tswte]==null)\n{\nvar valuetsw=valuetsw1;\n}\nelse\n{\nvar valuetsw=valuetsw1+\"=\"+tswVal[tswte];\n\n}\nd.add(cou1,0,valuetsw,valuetsw);\ntsw=cou1;\ncou1++;\ntswte++;\n}\nbreak;\ncase simple2:\nvar value11=temp.substring(1);\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\nvar value1=value11+\"=\"+hashVal[hashte];\n}\n\nd.add(cou1,tsw,value1,value1);\nhash=cou1;\ncou1++;\nhashte++;\n}\nbreak;\ncase simple3:\nvar value12=temp.substring(1);\nalert(value12+\"\"+hash);\n\nif(value12==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"=\"+dolVal[dolte];\n}\n\nd.add(cou1,hash,value2,value2);\ndola=cou1;\ncou1++;\n}\nbreak;\ncase simple4:\ndola=getData(dola,hash,1);\nvar value13=temp.substring(1);\nif(value3==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"=\"+PerVal[perte];\n}\n\nd.add(cou1,dola,value3,value3);\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\n}\nbreak;\n/*case simple5:\ndola=getData(dola,hash,1);\nvar value13=temp.substring(1);\nif(value3==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"=\"+PerVal[perte];\n}\n\nd.add(cou1,dola,value3,value3);\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\n}\nbreak;*/\n\n\n\n\n\n\n/*case simple1:\nvar value1=temp.substring(1);\nif(value1==\"\")\n{\n}\nelse\n{\nif(tswVal[tswte]==null)\n{\nvar valuetsw=value1;\n}\nelse\n{\nvar valuetsw=value1+\"=\"+tswVal[tswte];\n}\nd.add(cou1,0,valuetsw,valuetsw);\nhash=cou1;\ncou1++;\ntswte++;\n}\nbreak;\ncase simple2:\nvar value2=temp.substring(1);\nif(value2==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value2;\n}\nelse\n{\nvar value1=value2+\"=\"+hashVal[hashte];\n}\nd.add(cou1,hash,value1,value1);\ndola=cou1;\ncou1++;\nhashte++;\n}\nbreak;\ncase simple3:\ndola=getData(dola,hash,1);\nvar value3=temp.substring(1);\n\n\nif(value3==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar valueDOL=value3;\n}\nelse\n{\nvar valueDOL=value3+\"=\"+dolVal[dolte];\n}\nd.add(cou1,dola,valueDOL,valueDOL);\nperce=cou1;\ncou1++;\nhashte++;\n}\nbreak;\ncase simple4:\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\nvar value4=temp.substring(1);\nif(value4==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value5=value4;\n}\nelse\n{\nvar value5=value4+\"=\"+PerVal[perte];\n}\nd.add(cou1,dola,value5,value5);\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\n }\nbreak;*/\n}\n}\ntemp=curval;\n}\nelse \n{\n\ttemp=temp+curval;\n}\n  }\n if(temp.length>0)\n{\nswitch(temp.charAt(0))\n{\ncase simple1:\nvar valuetsw1=temp.substring(1);\nif(valuetsw1==\"\")\n{\n}\nelse\n{\nif(tswVal[tswte]==null)\n{\nvar valuetsw=valuetsw1;\n}\nelse\n{\nvar valuetsw=valuetsw1+\"=\"+tswVal[tswte];\n}\nd.add(cou1,0,valuetsw,valuetsw);\ntsw=cou1;\ncou1++;\ntswte++;\n}\nbreak;\ncase simple2:\nvar value11=temp.substring(1);\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\nvar value1=value11+\"=\"+hashVal[hashte];\n}\nd.add(cou1,tsw,value1,value1);\nhash=cou1;\ncou1++;\nhashte++;\n}\nbreak;\ncase simple3:\nvar value12=temp.substring(1);\nif(value12==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"=\"+dolVal[dolte];\n}\n\nd.add(cou1,hash,value2,value2);\ndola=cou1;\ncou1++;\n}\nbreak;\ncase simple4:\ndola=getData(dola,hash,1);\nvar value13=temp.substring(1);\nif(value3==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"=\"+PerVal[perte];\n}\nd.add(cou1,dola,value3,value3);\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\n}\nbreak;\n/*case simple1:\nvar value1=temp.substring(1);\nif(value1==\"\")\n{\n}\nelse\n{\nif(tswVal[tswte]==null)\n{\nvar valuetsw=value1;\n}\nelse\n{\nvar valuetsw=value1+\"=\"+tswVal[tswte];\n}\nd.add(cou1,0,valuetsw,valuetsw);\nhash=cou1;\ncou1++;\ntswte++;\n}\nbreak;\ncase simple2:\nvar value2=temp.substring(1);\nif(value2==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value2;\n}\nelse\n{\nvar value1=value2+\"=\"+hashVal[hashte];\n}\nd.add(cou1,hash,value1,value1);\ndola=cou1;\ncou1++;\nhashte++;\n}\nbreak;\ncase simple3:\ndola=getData(dola,hash,1);\nvar value3=temp.substring(1);\nif(value3==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar valueDOL=value3;\n}\nelse\n{\nvar valueDOL=value3+\"=\"+dolVal[dolte];\n}\nd.add(cou1,dola,valueDOL,valueDOL);\nperce=cou1;\nperce=cou1;\ncou1++;\ndolte++;\n}\nbreak;\ncase simple4:\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\nvar value4=temp.substring(1);\nif(value4==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value5=value4;\n}\nelse\n{\nvar value5=value4+\"=\"+PerVal[perte];\n}\nd.add(cou1,dola,value5,value5);\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\n }\nbreak;*/\n}\n\n}\ndocument.write(d);\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n</div>\n\n\n<!--<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n</table>\n<div id=\"style123\" style=\"display:no";
    private final static byte[]  _wl_block13_0Bytes = _getBytes( _wl_block13_0 );

    private final static java.lang.String  _wl_block13_1 ="ne\">\n<fieldset style=\" border-color:black;\" ><legend><b> Query Details </b></legend> \n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<td></td>\n\n\n<tr>\n\t<td width=\'30%\'></td>\n\t<td width=\'70%\'></td>\n</tr>\n\n \n\n<tr>\n\t<td width=\'30%\'></td>\n\t<td width=\'70%\'></td>\n</tr>\n\n\n</table>\n\n</div>\n\n\n\n<!--<script>\ndocument.location.href=\"../../eCommon/html/Left2.html\";\n</scipt>--->\n\n</form>\n</BODY>\n</html>\n\n\n";
    private final static byte[]  _wl_block13_1Bytes = _getBytes( _wl_block13_1 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
 /*
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
*/

            _bw.write(_wl_block3Bytes, _wl_block3);
 
Connection connection = null;
CallableStatement  oraclecallablestatement = null;
String applicationId="";
String applicationName="";
String facilityId="";
//String facilityName="";
String msgId="";
String eventType="";
//String eventName="";
String ProtocolID="";
String Msq_txt="";						 
String MsgText="";
String Standard_code="";
String Message_syntax="";
String Standard_symbols="";
String errorMsg="";
String Standard_type="";
applicationId=(String)session.getAttribute("application_Id");
applicationName=(String)session.getAttribute("applicationName");
facilityId=(String)session.getAttribute("Facility_Id");
msgId=(String)session.getAttribute("Msg_Id");
Msq_txt=(String)session.getAttribute("Message_Text");
ProtocolID="F";
eventType=(String)session.getAttribute("Even_type");


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
oraclecallablestatement = connection.prepareCall("{ call xhgeneric.standard_message_viewer(?,?,?,?,?,?,?,?,?,?,?) }" ); 
oraclecallablestatement.setString(1,applicationId);
//out.println("applicationId"+applicationId);
oraclecallablestatement.setString(2,facilityId);
//out.println("facilityId"+facilityId);
oraclecallablestatement.setString(3,msgId);
//out.println("msgId"+msgId);
oraclecallablestatement.setString(4,ProtocolID);
//out.println("ProtocolID"+ProtocolID);
oraclecallablestatement.setString(5,eventType);
//out.println("eventType"+eventType);
oraclecallablestatement.setString(6,Msq_txt);
//out.println("Msq_txt"+Msq_txt);
oraclecallablestatement.registerOutParameter(6,java.sql.Types.VARCHAR);
oraclecallablestatement.registerOutParameter(7,java.sql.Types.VARCHAR);
oraclecallablestatement.registerOutParameter(8,java.sql.Types.VARCHAR);
oraclecallablestatement.registerOutParameter(9,java.sql.Types.VARCHAR);
oraclecallablestatement.registerOutParameter(10,java.sql.Types.VARCHAR);
oraclecallablestatement.execute();
MsgText = oraclecallablestatement.getString(6);
Standard_code= oraclecallablestatement.getString(7);
Standard_type=oraclecallablestatement.getString(8);


Message_syntax=oraclecallablestatement.getString(9);
Standard_symbols=oraclecallablestatement.getString(10);
errorMsg=oraclecallablestatement.getString(11);

//System.out.println("Message_syntax"+Message_syntax);
//System.out.println("Msq_txt"+MsgText);
if(oraclecallablestatement!=null) 
	oraclecallablestatement.close();
		}
catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceStandardAddModifyServlett:"+ex.toString());
		//exceptions=exceptions+"3"+"*"+ex.toString();
		//ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewSegments :"+ex.toString());
		   ex.printStackTrace(System.err); }
	    

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(MsgText));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Message_syntax));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Standard_symbols));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Standard_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Standard_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(MsgText));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Message_syntax));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Standard_symbols));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Standard_code));
            _bw.write(_wl_block13_0Bytes, _wl_block13_0);
            _bw.write(_wl_block13_1Bytes, _wl_block13_1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
