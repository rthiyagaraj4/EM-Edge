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

public final class __viewtree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewTree.jsp", 1743587269312L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<HEAD> \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\n  \n<style type = \'text/css\'> \nTD.COLUMNHEADER { \t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n   BACKGROUND-COLOR: #404040;\n   COLOR: white ; \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n   FONT-SIZE: 8pt;   \n   font-weight: bolder;\n   PADDING-LEFT:7px;\n   PADDING-RIGHT:7px\n}\n  </STYLE>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n<link rel=\"StyleSheet\" href=\"../../eXH/html/dtree.css\" type=\"text/css\" />\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\"StyleSheet\" href=\"../../eXH/html/lris_style.css\" type=\"text/css\" />\n<script type=\"text/javascript\" src=\"../../eXH/js/dtree4.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script> \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n<script type=\"text/javascript\" src=\"../../eXH/js/dtree1.js\"></script>\n   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<script type=\"text/javascript\" src=\"../../eXH/js/dtreeElement.js\"></script> \n  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<script type=\"text/javascript\" src=\"../../eXH/js/dtree1.js\"></script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n<link rel=\"StyleSheet\" href=\"../../eXH/html/dtree.css\" type=\"text/css\" />\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\"StyleSheet\" href=\"../../eXH/html/lris_style.css\" type=\"text/css\" />\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script> \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  \n </head>\n <BODY   >     \n<form name=\"view_segment_form\" id=\"view_segment_form\">\n<div class=\"dtree\">\n<table cellspacing=0 cellpadding=3 width=\'99%\' align=center >\n<tr> \n<td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<input type=hidden id=\'Standard_Symbols\' name=\'Standard_Symbolsright\' id=\'Standard_Symbolsright\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' > \n<input type=hidden name=\'Facility\' id=\'Facility\' value=\'\' >\n<input type=hidden name=\'Message_ID\' id=\'Message_ID\' value=\'\' >\n<input type=hidden name=\'Protocol_link\' id=\'Protocol_link\' value=\'\' >\n<input type=hidden id=\'Message_text\' name=\'Message_textright\' id=\'Message_textright\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'  >\n<input type=hidden id=\'Message_Syn\' name=\'Message_Synright\' id=\'Message_Synright\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >\n<input type=hidden id=\'rule\' name=\'rule\' id=\'rule\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >\n<input type=hidden id=\'Standard_code\' name=\'Standard_code\' id=\'Standard_code\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n<input type=hidden id=\'Standard_type\' name=\'Standard_typeright\' id=\'Standard_typeright\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n<input type=hidden id=\'rules\' name=\'rules\' id=\'rules\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=hidden id=\'applicationId\' name=\'applicationId\' id=\'applicationId\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=hidden id=\'facilityId\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=hidden id=\'Msg_Id\' name=\'Msg_Id\' id=\'Msg_Id\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=hidden id=\'even_type\' name=\'even_type\' id=\'even_type\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=hidden id=\'ProtocolID\' name=\'ProtocolID\' id=\'ProtocolID\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=hidden id=\'sub_module\' name=\'sub_module\' id=\'sub_module\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=hidden id=\'applicationName\' name=\'applicationName\' id=\'applicationName\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=hidden id=\'facilityName\' name=\'facilityName\' id=\'facilityName\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=hidden id=\'protocolMode\' name=\'protocolMode\' id=\'protocolMode\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=hidden id=\'srlNo\' name=\'srlNo\' id=\'srlNo\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=hidden id=\'event_name\' name=\'event_name\' id=\'event_name\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=hidden id=\'element\' name=\'element\' id=\'element\' value=\'\'>\n<input type=hidden id=\'img\' name=\'img\' id=\'img\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\"hidden\" name=\"purge_status\" id=\"purge_status\" id=\"purge_status\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'/> \n<script>\ntry { \n\tvar remind=0;\n\tvar eventre=0;\n\tvar deboo=false;\n\tvar Mainboolean=true;\n\tvar comsixteen;\n\tvar storecap=\"\";\n\tvar gendrcou=0;\n\tvar boxte=0;\n\tvar storegenc=0;\n\td = new dTree(\'d\');\n\tvar caplength=0;\n\tvar pipsing=-1;\n\tvar capcsec=0;\n\tvar dollor=0;\n\tvar countingpip=new Array();\n\tvar countcap=new Array();\n\tvar treeval =new Array();\n\tvar tswArr =new Array();\n\tvar AtArr =new Array();\n\tvar ExcArr =new Array();\n\tvar pipArr =new Array();\n\tvar capArr =new Array();\n\tvar TextVal=new Array();\n\tvar tswVal=new Array();\n\tvar AtVal=new Array();\n\tvar ExcVal=new Array(); \n\tvar PiptVal=new Array();\n\tvar CapVal=new Array();\n\tvar AmperVal=new Array();\n\tvar OpenVal=new Array();\n\tvar piplength=0;\n\tvar CloseVal=new Array();\n\tvar tsw=0;\n\tvar cou=1;\n\tvar Exc=0;\n\tvar At=0;\n\tvar pip=0;\n\tvar tswt=0;\n\tvar Att=0;\n\tvar Exct=0;\n\tvar Pipt=0;\n\tvar cc=0;\n\tvar cc1=-1;\n\tvar Capt=0;\n\tvar Ampert=0;\n\tvar cate=-1;\n\tvar storecate=0\n\tvar treeval =new Array();\n\tvar hashArr =new Array();\n\tvar dolArr =new Array();\n\tvar perArr =new Array();\n\tvar pipArr =new Array();\n\tvar capArr =new Array();\n\tvar dolVal=new Array();\n\tvar PerVal=new Array();\n\tvar hashVal=new Array();\n\tvar TextVal=new Array();\n\tvar Open=0;\n\tvar Amper=0;\n\tvar Opent=0;\n\tvar Closet=0;\n\tvar pip=0;var Cap=0;\n\tvar elementflag=false;\n\tvar hash=0;\n\tvar hashCou;\n\tvar dolCou;\n\tvar perCou;\n\tvar pipCou;\n\tvar capCou;\n\tvar l_pos;\n\tvar boo=true;\n\tvar cou=1;\n\tvar temp=\'\';\n\tvar perce=0;\n\tvar dola=0;\n\tvar som=0;\n\tvar pip=0;\n\tvar hasht=0;\n\tvar dolt=0;\n\tvar Pert=0;\n\tvar ll=0;\n\tvar capte1=0;\n\tvar k2=\"\";\n\tvar ic3=0;\n\tvar symbolvalue;\n\tvar losec=0;\n\tvar temp=\'\';\n\tvar d1=0;\n\tvar val=\"\";\n\tvar piptwoarray=new Array();\n\tvar captwoarray=new Array();\n\tvar captwoarraysec=new Array();\n\tvar acchar=0;\n\tvar sy=\'\';\n\tvar Symbols=new Array();\n\tvar elementval=new Array();\n\tvar s1=0;\n\tvar Lesstan=new Array();\n\tvar less=0;\n\tvar MessageHead=\"\";\n\tvar CapVal1=new Array();\n\tvar Capt1=0;\n\tvar boxval=new Array();\n\tvar box=0;\n\tvar checkpu=0;\n\tvar messegetext=unescape(document.forms[0].Message_textright.value); \n\tvar Messegesyntax=unescape(document.forms[0].Message_Synright.value); \n\tvar emptyflag=false;\nif(Messegesyntax==\'\')\n{\n\tvar message=getMessage(\'XH0076\',\'XH\');\n\tmessage=message.replace(\'$\',\'\');\n\talert(message);\n\temptyflag=true;\n\tparent.frames[0].document.location.href=\"../../eXH/jsp/ViewTree.jsp?applicationID=\"+document.forms[0].applicationId.value+\"&facilityID=\"+document.forms[0].facilityId.value+\"&purge_status=\"+document.forms[0].purge_status.value+\"&msgID=\"+document.forms[0].Msg_Id.value+\"&even_type=\"+document.forms[0].even_type.value+\"&protocol_link_id=\"+document.forms[0].ProtocolID.value+\"&sub_module=\"+document.forms[0].sub_module.value+\"&applicationName=\"+document.forms[0].applicationName.value+\"&facilityName=\"+document.forms[0].facilityName.value+\"&srlNo=\"+document.forms[0].srlNo.value+\"&event_name=\"+document.forms[0].event_name.value+\"&protocolMode=\"+document.forms[0].protocolMode.value+\"&rule=J&rule2=H&img=\"+document.forms[0].img.value;\n}\nvar Standard_symbols=document.forms[0].Standard_Symbolsright.value;\nvar count=0;\nvar compilesimples=3;\nvar Standard_type1=document.forms[0].Standard_typeright.value;\nvar SplitinElements=new Array();\nvar sp=0;\nvar spliting=Standard_symbols.split(\"{{{\");\nfor(var s=0;s<spliting.length;s++)\n{\n\tif(spliting[s].indexOf(\'|\')!=-1)\n\t{\n\t\tvar SpilitngStandardpip=spliting[s].split(\'|\');\n\t\tSplitinElements[sp]=SpilitngStandardpip[1];\n\t}\n\telse\n\t{\n\t\tSplitinElements[sp]=spliting[s];\n\t}\n\tsp++;\n}\n\tvar pi=1;\n\tvar lo=1;\n\tvar spt1=0;\n\tvar intSymbols=new Array();\n\tvar intd=0;\n\tfor(var spt=0;spt<SplitinElements.length;spt++)\n\t{\n\t\tif(spt==0 || spt==1 || spt==2)\n\t\t{\n\t\t\tSymbols[spt1]=\"#\"+String.fromCharCode(SplitinElements[spt])+\"#\";\n\t\t\tintSymbols[intd]=\"#\"+String.fromCharCode(SplitinElements[spt])+\"#\";\n\t\t\tintd++;\n\t\t}\n\t\telse\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t{\n\t\t\tSymbols[spt1]=String.fromCharCode(SplitinElements[spt]);\n\t\t\tintSymbols[intd]=String.fromCharCode(SplitinElements[spt]);\n\t\t\tintd++;\n\t\t}\n\t\tspt1++;\n\t}\n\n\nif(Standard_type1==\'H\')\n{\n\tvar acchar1=0;\n\tvar pipsimple=\"|\";\n\tvar pipsym=messegetext.indexOf(\'|\');\n\tvar firstmessage=messegetext.substring(0,pipsym);\n\tpiptwoarray[0]=new Array();\n\tcaptwoarray[0]=new Array();\n\tpiptwoarray[0][0]=pipsimple;\n\tPiptVal[0]=firstmessage;\n\tvar messagevaluepip=messegetext.substring((pipsym+1),messegetext.length);\n\tvar nextpip=messagevaluepip.indexOf(\'|\');\n\tvar massagenextpip=messagevaluepip.substring(0,(nextpip+1));\n\tvar secondsplit=messagevaluepip.substring(nextpip,messagevaluepip.length);\n\tpiptwoarray[0][1]=massagenextpip;\n\tif(Symbols[3]!=null )\n\t{\n\t\tvar ch=Symbols[3].toString();\n\t}\n\telse\n\t{\n\n\t}\n\tvar identifysimbol=Messegesyntax.indexOf(ch);\n\tvar identifypip=Messegesyntax.indexOf(\'|\');\n\tvar MsgsubString=Messegesyntax.substring(identifysimbol+1,identifypip);\n\tvar tillMegHeead=Messegesyntax.substring(0,identifysimbol);\n\tvar tillsegHead=Messegesyntax.substring(identifypip,Messegesyntax.length);\n\tvar ic1=2;\n\tvar ic2=2;\n\tvar Replace=\"\";\n\tvar pp=0;\n\tif(Symbols[5]!=null)\n\t{\n\t\tReplace=Symbols[5].toString()+MsgsubString;\n\t}\n\telse\n\t{\n\t\tReplace=ch+MsgsubString;\n\t}\n\tMessegesyntax=tillMegHeead+ch+Replace+tillsegHead+\'|\';\n\tCapt=2;\n\tk2=secondsplit;\n\tPipt=1;\n\tvar flag=0;\n\tvar pipflag=0;\n\tfor(var i=0;i<k2.length;i++)\n\t{\n\t  someval=(k2.charAt(i)).toString()+((k2.charAt(i+1)).toString())+((k2.charAt(i+2)).toString());\n\t  if((k2.charAt(i+2)).toString()==\"\" || (k2.charAt(i+1)).toString()==\"\")\n\t  {\n\t\tsomeval=someval+\"lam,x\"+\"lam,x\";\n\t  }\n\t if(someval == intSymbols[0] || someval == intSymbols[1] || someval == intSymbols[2]  || someval == intSymbols[3]  || someval == intSymbols[4] ||  someval == intSymbols[5] || someval == intSymbols[6] )\n\t {\n\t }\n\t var nextsimpol=someval.substring(0,1);\n\t curval= (k2.charAt(i)).toString();\n\t if(curval==\'+\')\n\t{\n\tcurval=\' \';\n\t}\n\tif(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == \'*\')\n\t{\n\t if(temp.length>0 )\n\t\t{\n\t\t\tif(temp.indexOf(\"^\")!=-1 || temp.indexOf(\"|\")!=-1 )\n\t\t\t{\n\t\t\tvar somethingdata1=temp.substring(0,1);\n\n\t\t\tif(somethingdata1==\'|\')\n\t\t\t{\n\n\t\t\tpipflag=ic1;\n\n\t\t\tic3=0;\n\n\t\t\t}\n\t\t\telse if(somethingdata1==\'^\')\n\t\t\t{\n\n\t\t\tcaptwoarraysec[losec]=new Array();\n\t\t\tlosec++;\n\t\t\t}\n\t\t}\n\t\tvar somethingdata=temp.substring(0,1);\n\t\tif(somethingdata==\'|\' && nextsimpol==\'|\' )\n\t\t{\n\n\t\t}\n\t\telse\n\t\t{\n\n\t\t//Capt=0;\n\t\t//pp++;\n\t\t}\n\n\t\tswitch(test(somethingdata))\n\t\t{\n\n\t\tcase 0:\n\n\t\tbreak;\n\t\tcase 1:\n\n\t\tbreak;\n\t\tcase 2:\n\n\t\tbreak;\n\t\tcase 3:\n\t\tboxval[box]=temp.substring(1);\n\t\tbox++;\n\t\tbreak;\n\t\tcase 4:\n\t\tvar value3=temp.substring(1);\n\n\t\tif (value3==null)\n\t\t{\n\t\tLesstan[less]=MessageHead;\n\t\tless++;\n\t\t}\n\t\telse\n\t\t{\n\t\tLesstan[less]=value3;\n\n\t\tless++;\n\t\t}\n\t\tbreak;\n\t\tcase 5:\n\t\tPiptVal[Pipt]=temp.substring(1);\n\t\tpiptwoarray[pi]=new Array();\n\t\tcaptwoarray[lo]=new Array();\n\t\tcc=lo;\n\t\tlo++;\n\t\tic2=0;\n\t\tCapt=0;\n\t\tpp++;\n\t\tpi++;\n\t\tPipt++;\n\t\tbreak;\n\t\tcase 6:\n\t\tif(nextsimpol==\'^\')\n\t\t{\n\t\tpiptwoarray[pp][Capt]=temp.substring(1)+nextsimpol;\n\t\t}\n\t\telse\n\t\t{\n\t\tpiptwoarray[pp][Capt]=temp.substring(1);\n\n\t\t}\n\n\t\tif(piptwoarray[pp][Capt]==\"\")\n\t\t{\n\t\tboo=false;\n\t\t}\n\t\telse\n\t\t{\n\n\t\tboo=true;\n\t\tic1++;\n\t\tic3=0;\n\t\tic2++;\n\t\t}\n\n\t\tCapt++;\n\n\n\n\n\t\tbreak;\n\t\tcase 7:\n\t\tif(boo==true)\n\t\t{\n\t\tcc1++;\n\t\t}\n\t\tcaptwoarray[cc][ic2]=temp.substring(1);\n\t\tcaptwoarraysec[cc1][ic3]=temp.substring(1);\n\n\n\n\t\t//alert(\"cc :\"+cc1+\" ic2 \"+ic3+\" captwoarray[cc][ic2] :\"+captwoarraysec[cc1][ic3]);\n\t\tic3++;\n\n\t\tCapVal1[Capt1]=pipflag;\n\t\tic2++;\n\t\tCapt1++;\n\t\tboo=false;\n\t\tbreak;\n\t\t}\n\t}\n\ttemp=curval;\n\t}\n\telse \n\t  {\n\t\ttemp=temp+curval;\n\t  }\n}\n if(temp.length>0)\n{\nswitch(test(curval))\n{\n\ncase 0:\n\nbreak;\ncase 1:\n\nbreak;\ncase 2:\n\nbreak;\ncase 3:\nboxval[box]=temp.substring(1);\nbox++;\nbreak;\ncase 4:\nvar value3=temp.substring(1);\n\nif (value3==null)\n{\nLesstan[less]=MessageHead;\nless++;\n}\nelse\n{\nLesstan[less]=value3;\n\nless++;\n}\nbreak;\ncase 5:\nPiptVal[Pipt]=temp.substring(1);\npiptwoarray[pi]=new Array();\ncaptwoarray[lo]=new Array();\ncc=lo;\nlo++;\nic2=0;\nCapt=0;\npp++;\npi++;\nPipt++;\nbreak;\ncase 6:\nif(nextsimpol==\'^\')\n{\npiptwoarray[pp][Capt]=temp.substring(1)+nextsimpol;\n}\nelse\n{\npiptwoarray[pp][Capt]=temp.substring(1);\n\n}\n\nif(piptwoarray[pp][Capt]==\"\")\n{\nboo=false;\n}\nelse\n{\n\nboo=true;\nic1++;\nic3=0;\nic2++;\n}\n\nCapt++;\n\n\n\n\nbreak;\ncase 7:\nif(boo==true)\n{\ncc1++;\n}\ncaptwoarray[cc][ic2]=temp.substring(1);\ncaptwoarraysec[cc1][ic3]=temp.substring(1);\n//alert(\"cc :\"+cc+\" ic2 \"+ic2+\" captwoarray[cc][ic2] :\"+captwoarray[cc][ic2]);\nic3++;\n\nCapVal1[Capt1]=pipflag;\nic2++;\nCapt1++;\n\nboo=false;\n\n\nbreak;\n\n}\n}\n\n\n/**************************populate Tree*************************////\n/**********************************Populate Tree*****************************/\nvar tswte=0;\nvar Atte=0;\nvar Excte=0;\nvar pipte=0;\nvar capte=0;\nvar cou1=1;\nvar Opente=0;\nvar Closete=0;\nvar Amperte=0\nvar hashte=0;\nvar pipsom=0;\nvar dolte=0;\nvar perte=0;\nvar lesste=0;\nvar cap=0;\n\nvar pipcheck=0;\nvar capc=0;\nd.add(0,-1,\'\');\nvar counting=1;\nvar spe=0;\nvar incr=0;\nfor(var i=0;i<Messegesyntax.length;i++)\n{\n\n\t curval=(Messegesyntax.charAt(i)).toString();\n\t curval1=(Messegesyntax.charAt(i)).toString();\n\tsome=(Messegesyntax.charAt(i)).toString()+((Messegesyntax.charAt(i+1)).toString())+((Messegesyntax.charAt(i+2)).toString());\n\n\n  if((Messegesyntax.charAt(i+2)).toString()==\"\" || (Messegesyntax.charAt(i+1)).toString()==\"\")\n  {\n    some=some+\"lam,x\"+\"lam,x\";\n   }\n\nif(compilesimples==i)\n{\ncurval=some1;\n\n}\n\nif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n{\ncompilesimples=(i+2);\nsome1=some;\ncounting=3;\nspe=2;\n}\nelse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n{\ncurval=curval1;\nspe=0;\ncounting=1;\n}\n\n       if(curval==\"+\")\n{\n\ncurval=\" \";\n}\n var nextsimpol=some.substring(0,1);\n\t\t \n\t  \n\n\n \n if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])\n \n {\n\n\n if(temp.length>0 )\n{\n\n\n\n\ntemp=temp.substring(0,(temp.length-spe));\n\nif(temp.indexOf(\"#%#\")!=-1)\n{\ncounting=3;\n\n}\n\nvar somethingdata=temp.substring(0,counting);\n\n\nswitch(test(somethingdata))\n{\ncase 0:\nvar value11=temp.substring(counting);\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\n\nvar value1=value11+\"     =     \"+hashVal[hashte];\n\n}\n\nelementval[eventre]=value11;\neventre++;\nd.add(cou1,0,value1,\"javascript:selectLink()\");\n\nhash=cou1;\ncou1++;\nhashte++;\n\n}\nbreak;\ncase 1:\nvar value12=temp.substring((counting));\nif(value12==\"\")\n{\n\n\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"     =     \"+dolVal[dolte];\n\n}\nelementval[eventre]=value12;\neventre++;\nd.add(cou1,hash,value2,\"javascript:selectLink()\");\ndola=cou1;\ncou1++;\ndolte++;\n}\nbreak;\ncase 2:\n\ndola=getData(dola,hash,1);\nvar value13=temp.substring((counting));\n\n\nif(value13==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"     =     \"+PerVal[perte];\n\n}\nelementval[eventre]=value13;\neventre++; \nd.add(cou1,dola,value3,\"javascript:selectLink()\");\nd.oPnode(true,0);\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\ncounting=0;\n}\nbreak;\ncase 3:\n\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\n\n\nvar somevalue1=\"\";\n\n\nvar somevalue=temp.substring(counting);\nif(somevalue==\"\")\n{\n}\nelse\n{\nif(boxval[boxte]==null)\n{\nsomevalue1=somevalue;\n\n\n}\nelse\n{\nsomevalue1=somevalue+\"     =     \"+boxval[boxte];\n\n}\n\nelementval[eventre]=somevalue;\neventre++;\nd.add(cou1,perce,somevalue1,\"javascript:selectLink()\");\npipsom=cou1;\n//som=cou1;\nboxte++;\ncou1++;\n\n}\n\n\nbreak;\ncase 4:\n\nsom =getData(som,hash,1);\nsom=getData(som,dola,2);\nsom=getData(pipsom,perce,3);\nvar lessval1=\"\";\n\nvar lessval=temp.substring(1);\n\nif(lessval==\"\")\n{\n}\nelse\n{\nif(Lesstan[lesste]==null)\n{\nlessval1=lessval;\n}\nelse\n{\nlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\n\n}\nelementval[eventre]=lessval;\neventre++;\nd.add(cou1,som,lessval1,\"javascript:selectLink()\");\npipsom=som;\npip=cou1;\nlesste++;\ncou1++;\n\n}\n\nbreak;\ncase 5:\ncheckRemainingVal(caplength,capc,cou1,ll);\npip=getData(pip,hash,1);\npip=getData(pip,dola,2);\npip=getData(pip,perce,3);\npip=getData(pip,pipsom,4);\nvar valuePip1=temp.substring(1);\nif(valuePip1==\"\")\n{\n}\nelse\n{\nif(PiptVal[pipte]==null)\n{\nvar valuePip=valuePip1;\n}\nelse\n{\nvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\npipsing=pipsing+1;\ncountingpip[pipte]=new Array();\n\n}\nelementval[eventre]=valuePip1;\neventre++;\n//acchar1=0;\nacchar=0;\ncapc=0;\n\n//d.add(cou1,pip,valuePip,valuePip);\nd.add(cou1,pip,valuePip,\"javascript:selectLink()\");\n\npiplength=piptwoarray[pipsing].length;\n cap=cou1;\n cou1++;\n pipte++;\n\n//cate++;\n }\nbreak;\ncase 6:\n//checkFunCap();\ncheckRemainingVal(caplength,capc,cou1,ll);\ncheckIndexChar(storecap,storegenc);\ncap=getData(cap,hash,1);\ncap=getData(cap,dola,2);\ncap=getData(cap,perce,3);\ncap=getData(cap,som,4);\ncap=getData(cap,pip,5);\nvar valueCap1=temp.substring(1);\nvar comsixteen=\"\";\n\n\n\n//if(acchar<16)                                  remove  16 characters condition \n//{\nif(!piptwoarray[pipsing][acchar])\n{\ndeboo=false;\n}\nelse\n{\n\ncomsixteen=piptwoarray[pipsing][acchar];\ncapc++;\n}\nif(comsixteen==\"\" )\n{\ndeboo=false;\n}\nelse\n{\n\ndeboo=true;\n}\n//}                                             end   16 character loop \n\n\n\nif(comsixteen.indexOf(\'^\')!=-1)\n{\n\nvar capcheck=comsixteen.substring(comsixteen.length-1);\ncomsixteen=comsixteen.substring(0,comsixteen.length-1);\nif(capcheck.indexOf(\'^\')!=-1)\n{\n\n\nstorecap=\"^\";\nstoregenc=gendrcou;\n}\nelse if(capcheck.indexOf(\'^\')==-1)\n{\nstorecap=\"\";\n}\n}\n\n  \nelementval[eventre]=valueCap1;\n \n//alert(\" elementval : \"+elementval[eventre]+\" valueCap1 : \"+valueCap1+\" eventre :\"+eventre);\n\n\n\n//alert(document.forms[0].element.value);\ncountingpip[pipsing][gendrcou]=valueCap1+\" = \"+comsixteen;\nd.add(cou1,cap,countingpip[pipsing][gendrcou],\"javascript:selectLink()\");\ngendrcou++;\nacchar++;\neventre++;\ncaplength=0; \nll=cou1;\ncou1++;\nflag=0;   \n//}\nbreak;\ncase 7:\n\nvar compacap=\"\";\n//alert(capc);\nif(deboo==true)\n{\n//cate++;\nif(flag==0)\n{\nif(captwoarray[pipsing][capc] || captwoarray[pipsing][capc]==\'\')\n{\ncate++;\nif(cate<captwoarraysec.length)\n{\ncaplength=captwoarraysec[cate].length;\n}\nvar valueCap13=temp.substring(1);\n//alert(valueCap13);\n}\nelse if(captwoarray[pipsing][capc]==undefined )\n{\n}\nelse if(captwoarray[pipsing][capc]==null )\n{\n}\nelse\n{\n//cate++;\n//if(cate<captwoarraysec.length)\n//{\n\n//caplength=captwoarraysec[cate].length;\n//}\n///var valueCap13=temp.substring(1);\n//var check=captwoarray[pipsing][capc]=\"\"?\"empty\":captwoarray[pipsing][capc];\n\n\n}\n\n}\ncapcsec=0;\n}\nll=getData(ll,hash,1);\nll=getData(ll,dola,2);\nll=getData(ll,perce,3);\nll=getData(ll,som,4);\nll=getData(ll,pip,5);\nll=getData(ll,cap,6);\nvar valueCap12=temp.substring(1);\ncompacap=captwoarray[pipsing][capc];\nif(compacap==null)\n{\nvar capattanddet=valueCap12+\" = \";\n//countingpip[pipsing][gendrcou]=valueCap12+\" = \";\n}\nelse\n{\nvar capattanddet=valueCap12+\" = \"+compacap;\n//alert(capattanddet);\nremind=1;\n\ncaplength=caplength-remind;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n//countingpip[pipsing][gendrcou]=valueCap12+\" = \"+compacap;\ncapc++;\n}\nif(valueCap12==\'\')\n{\nelementval[eventre]=valueCap12;\neventre++; \n}\nelse\n{\nelementval[eventre]=valueCap12;\neventre++; \n}\nd.add(cou1,ll,capattanddet,\"\");\n\n\n\n/*if(cate<captwoarraysec.length)\n{\nif(!captwoarraysec[cate][capcsec])\n{\ncompacap=\"\";\n}\nelse\n{\ncompacap=captwoarraysec[cate][capcsec];\n}\n\n\nif(caplength>0)\n{\n//countingpip[pipsing][gendrcou]=valueCap12+\" = \"+compacap;\ncapcsec++;\n}\nelse\n{\ncountingpip[pipsing][gendrcou]=valueCap12+\" = \";\n}\ncaplength--;\n}\nelse\n{\ncountingpip[pipsing][gendrcou]=valueCap12+\" = \";\n}*/\n\nflag=1;\ndeboo=false;\ngendrcou++;\ncou1++;\n\nbreak;\n\n}\n}\n\n\ntemp=curval;\n\n}\nelse \n{\n\ttemp=temp+curval;\n\n\t\n}\n\n\n\n\n\n\n\n\n\n\n  }\n if(temp.length>0 )\n{\ntemp=temp.substring(0,(temp.length-spe));\n\nif(temp.indexOf(\"#%#\")!=-1)\n{\ncounting=3;\n}\n\n\nvar somethingdata=temp.substring(0,counting)\n\n\nswitch(test(somethingdata))\n /*curval= Messegesyntax.charAt(i);\nif(curval==\'+\')\n{\n\ncurval=\' \';\n}\n\n\nif(curval == Symbols[0] ||curval ==Symbols[1] ||curval == Symbols[2] || curval == Symbols[3] ||curval == Symbols[4] || curval == Symbols[5] || curval == Symbols[6] ||curval == Symbols[7] || curval == Symbols[8] ||curval == Symbols[9] ||curval == Symbols[10] || curval == \'*\')\n {\n if(temp.length>0)\n{\nswitch(test())*/\n{\ncase 0:\n\n\nvar value11=temp.substring(counting);\n\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\n\nvar value1=value11+\"     =     \"+hashVal[hashte];\nelementval[eventre]=value11;\neventre++;\n}\n\nd.add(cou1,0,value1,\"javascript:selectLink()\");\nhash=cou1;\ncou1++;\nhashte++;\n\n}\nbreak;\ncase 1:\n\nvar value12=temp.substring((counting));\n\n\n\nif(value12==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"     =     \"+dolVal[dolte];\nelementval[eventre]=value12;\neventre++;\n}\n}\n\nd.add(cou1,hash,value2,\"javascript:selectLink()\");\ndola=cou1;\ncou1++;\ndolte++;\n\nbreak;\ncase 2:\ndola=getData(dola,hash,1);\nvar value13=temp.substring((counting));\nif(value13==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"     =     \"+PerVal[perte];\nelementval[eventre]=value13;\neventre++;\n}\n\nd.add(cou1,dola,value3,\"javascript:selectLink()\");\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\ncounting=0;\n}\nbreak;\ncase 3:\n\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\n\nvar somevalue1=\"\";\n\n\nvar somevalue=temp.substring(counting);\nif(somevalue==\"\")\n{\n}\nelse\n{\nif(boxval[boxte]==null)\n{\nsomevalue1=somevalue;\n\n\n}\nelse\n{\nsomevalue1=somevalue+\"     =     \"+Lesstan[lesste];\nelementval[eventre]=somevalue;\neventre++;\n}\n\n\nd.add(cou1,perce,somevalue1,\"javascript:selectLink()\");\nsom=cou1;\nboxte++;\ncou1++;\n\n}\n\n\nbreak;\ncase 4:\n\nsom =getData(som,hash,1);\nsom=getData(som,dola,2);\nsom=getData(som,perce,3);\nvar lessval1=\"\";\nvar lessval=temp.substring(1);\n\nif(lessval==\"\")\n{\n}\nelse\n{\nif(Lesstan[lesste]==null)\n{\nlessval1=lessval;\n}\nelse\n{\nlessval1=lessval+\"     =     \"+Lesstan[lesste];\nelementval[eventre]=lessval;\neventre++;\n}\n\nd.add(cou1,som,lessval1,\"javascript:selectLink()\");\npip=cou1;\nlesste++;\ncou1++;\n\n}\n\nbreak;\ncase 5:\npip=getData(pip,hash,1);\npip=getData(pip,dola,2);\npip=getData(pip,perce,3);\npip=getData(pip,som,4);\n\n\nvar valuePip1=temp.substring(1);\n\n\n\nif(valuePip1==\"\")\n{\n}\nelse\n{\nif(PiptVal[pipte]==null)\n{\nvar valuePip=valuePip1;\n}\nelse\n{\nvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\nelementval[eventre]=valuePip1;\neventre++;\n\n}\n\nd.add(cou1,pip,valuePip,\"javascript:selectLink()\");\n\n cap=cou1;\n cou1++;\n pipte++;\n\n }\nbreak;\ncase 6:\ncap=getData(cap,hash,1);\ncap=getData(cap,dola,2);\ncap=getData(cap,perce,3);\ncap=getData(cap,som,4);\ncap=getData(cap,pip,5);\nvar valueCap1=temp.substring(1);\n\n\nif(valueCap1==\"\")\n{\n}\nelse\n{\nif(CapVal[capte]==null)\n{\nvar valueCap=valueCap1;\n}\nelse\n{\nvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\nelementval[eventre]=valueCap1;\neventre++;\n\n\n}\n\nd.add(cou1,cap,valueCap,\"javascript:selectLink()\");\nll=cou1;\ncou1++;\ncapte++;\n\n}\nbreak;\ncase 7:\nll=getData(ll,hash,1);\nll=getData(ll,dola,2);\nll=getData(ll,perce,3);\nll=getData(ll,som,4);\nll=getData(ll,pip,5);\nll=getData(ll,cap,6);\nvar valueCap12=temp.substring(1);\n\nif(CapVal1[capte1]==null)\n{\nvar valueCap3=valueCap12;\n}\nelse\n{\nvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\nelementval[eventre]=valueCap12;\neventre++;\n}\nd.add(cou1,ll,valueCap3,\"\");\ncou1++;\ncapte1++;\n\n\nbreak;\n\n}\n}\n\n\ndocument.write(d);\nd.nodeStatus(true,1,true);\nd.nodeStatus(true,2,true);\nd.nodeStatus(true,3,true);\n//d.openAll();\n}\n\nelse\n{\n\nvar temp1=\'\';\nk2=messegetext;\nfor(var i=0;i<k2.length;i++)\n{\n curval= (k2.charAt(i)).toString();\n\n if(curval==\'+\')\n{\n\n\ncurval=\'      \';\n}\n\n\n  if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == \'*\')\n {\n\n \n\n if(temp1.length>0 )\n{\nvar somethingdata=temp1.substring(0,1);\n\n\nswitch(test(somethingdata))\n{\n\ncase 0:\n\nbreak;\ncase 1:\n\nbreak;\ncase 2:\n\nbreak;\ncase 3:\nMessageHead=temp1.substring(1);\nif(MessageHead==\"\" || MessageHead==null)\n{\n}\nelse\n{\nboxval[box]=MessageHead;\n\nbox++;\n\n}\nbreak;\ncase 4:\nvar value3=temp1.substring(1);\n\n\nif (value3==null)\n{\nLesstan[less]=MessageHead;\nless++;\n}\nelse\n{\nLesstan[less]=value3;\n\nless++;\n}\nbreak;\ncase 5:\nPiptVal[Pipt]=temp1.substring(1);\n\nPipt++;\nbreak;\ncase 6:\nCapVal[Capt]=temp1.substring(1);\n\n\nCapt++;\nbreak;\ncase 7:\nCapVal1[Capt1]=temp1.substring(1);\n\nCapt1++;\nbreak;\n\n\n\n}\n}\ntemp1=curval;\n}\nelse \n  {\n\ttemp1=temp1+curval;\n  }\n}\n if(temp1.length>0)\n{\nswitch(test(somethingdata))\n{\n\ncase 0:\n\nbreak;\ncase 1:\n\nbreak; \ncase 2:\n\nbreak;\ncase 3:\n\nMessageHead=temp1.substring(1);\n\n\n\nif(MessageHead==\"\" || MessageHead==null)\n{\n}\nelse\n{\nboxval[box]=MessageHead;\nbox++;\n\n}\n\nbreak;\ncase 4:\n\nLesstan[less]=temp1.substring(1);\n\nless++;\nbreak;\ncase 5:\n\nif(temp1.substring(1)==\'*\')\n{\n}\nelse\n{\nPiptVal[Pipt]=temp1.substring(1);\n\nPipt++;\n}\nbreak;\ncase 6:\nCapVal[Capt]=temp1.substring(1);\nCapt++;\nbreak;\ncase 7:\nCapVal1[Capt1]=temp1.substring(1);\nCapt1++;\n\n}\n}\n\n\n/**************************populate Tree*************************////\n/**********************************Populate Tree*****************************/\nvar tswte=0;\nvar Atte=0;\nvar Excte=0;\nvar pipte=0;\nvar capte=0;\nvar cou1=1;\nvar Opente=0;\nvar Closete=0;\nvar Amperte=0\nvar hashte=0;\nvar dolte=0;\nvar perte=0;\nvar lesste=0;\nvar cap=0;\nd.add(0,-1,\'\');\nvar some1;\n\n\n\n\nfor(var i=0;i<Messegesyntax.length;i++)\n{\n curval=(Messegesyntax.charAt(i)).toString();\n curval1=(Messegesyntax.charAt(i)).toString();\nsome=(Messegesyntax.charAt(i)).toString()+((Messegesyntax.charAt(i+1)).toString())+((Messegesyntax.charAt(i+2)).toString());\n\n\n  if((Messegesyntax.charAt(i+2)).toString()==\"\" && (Messegesyntax.charAt(i+1)).toString()==\"\")\n  {\n some=some+\"lak,xm\"+\"lak,xm\";\n}\n\n\nif(compilesimples==i)\n{\ncurval=some1;\n\n}\n\nif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n{\ncompilesimples=(i+2);\nsome1=some;\ncounting=3;\nspe=2;\n}\nelse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n{\ncurval=curval1;\nspe=0;\ncounting=1;\n}\n          \nif(curval==\"+\")\n{\n\ncurval=\"  \";\n}\n/*if(compilesimples%3=0)\n{\n\n\n}*/\n\n//if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == Symbols[3] ||curval == Symbols[4] || curval == Symbols[5] || curval == Symbols[6] ||curval == Symbols[7] || curval == Symbols[8] ||curval == Symbols[9] ||curval == Symbols[10] ||  curval == \'*\')\n \n if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])\n \n {\n if(temp.length>0 )\n{\n\ntemp=temp.substring(0,(temp.length-spe));\nif(temp.indexOf(\"#%#\")!=-1)\n{\ncounting=3;\n\n\n}\n\n\nvar somethingdata=temp.substring(0,counting)\n\nswitch(test(somethingdata))\n {\ncase 0:\n\n\nvar value11=temp.substring(counting);\n\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\n\nvar value1=value11+\"     =     \"+hashVal[hashte];\n}\nelementval[eventre]=value11;\neventre++;\nd.add(cou1,0,value1,\"javascript:selectLink()\");\nhash=cou1;\ncou1++;\nhashte++;\n\n}\nbreak;\ncase 1:\n\ndola=getData(dola,hash,1);\n\nvar value12=temp.substring((counting));\n\n\n\nif(value12==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"     =     \"+dolVal[dolte];\n\n}\nelementval[eventre]=value12;\neventre++;\nd.add(cou1,hash,value2,\"javascript:selectLink()\");\ndola=cou1;\ncou1++;\ndolte++;\n}\n\n\nbreak;\ncase 2:\ndollor=getData(dollor,hash,1);\ndollor=getData(dollor,dola,2);\n\n\nvar value13=temp.substring((counting));\n\n\nif(value13==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"     =     \"+PerVal[perte];\n\n}\nelementval[eventre]=value13;\neventre++;\nd.add(cou1,dola,value3,\"javascript:selectLink()\");\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\ncounting=0;\n}\nbreak;\ncase 3:\n\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\nperce=getData(perce,dollor,3);\nvar somevalue1=\"\";\n\n\nvar somevalue=temp.substring(counting);\n\nif(somevalue==\"\")\n{\n}\nelse\n{\nif(boxval[boxte]==null)\n{\nsomevalue1=somevalue;\n}\nelse\n{\nsomevalue1=somevalue+\"     =     \"+boxval[boxte];\n\n}\n\nelementval[eventre]=somevalue;\neventre++;\nd.add(cou1,perce,somevalue1,\"javascript:selectLink()\");\nsom=cou1;\nboxte++;\ncou1++;\n\n}\n\n\nbreak;\ncase 4:\n\nsom =getData(som,hash,1);\nsom=getData(som,dola,2);\nsom=getData(som,dollor,3);\nsom=getData(som,perce,4);\nvar lessval1=\"\";\n\nvar lessval=temp.substring(counting);\n\nif(lessval==\"\")\n{\n}\nelse\n{\nif(Lesstan[lesste]==null)\n{\nlessval1=lessval;\n}\nelse\n{\nlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\n}\nelementval[eventre]=lessval;\neventre++;\nd.add(cou1,som,lessval1,\"javascript:selectLink()\");\npip=cou1;\nlesste++;\ncou1++;\n\n}\n\nbreak;\ncase 5:\npip=getData(pip,hash,1);\npip=getData(pip,dola,2);\npip=getData(pip,dollor,3);\npip=getData(pip,perce,4);\npip=getData(pip,som,5);\n\n\n\nvar valuePip1=temp.substring(1);\n\n\n\nif(valuePip1==\"\")\n{\n}\nelse\n{\nif(PiptVal[pipte]==null)\n{\nvar valuePip=valuePip1;\n}\nelse\n{\nvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n}\nelementval[eventre]=valuePip1;\neventre++;\nd.add(cou1,pip,valuePip,\"javascript:selectLink()\");\n\n cap=cou1;\n cou1++;\n pipte++;\n\n }\nbreak;\ncase 6:\ncap=getData(cap,hash,1);\ncap=getData(cap,dola,2);\ncap=getData(cap,dollor,3);\ncap=getData(cap,perce,4);\ncap=getData(cap,som,5);\ncap=getData(cap,pip,6);\nvar valueCap1=temp.substring(1);\n\n\nif(valueCap1==\"\")\n{\n}\nelse\n{\nif(CapVal[capte]==null)\n{\nvar valueCap=valueCap1;\n}\nelse\n{\nvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\n\n}\nelementval[eventre]=valueCap1;\neventre++;\nd.add(cou1,cap,valueCap,\"javascript:selectLink()\");\nll=cou1;\ncou1++;\ncapte++;\n\n}\nbreak;\ncase 7:\nll=getData(ll,hash,1);\nll=getData(ll,dola,2);\nll=getData(ll,dollor,3);\nll=getData(ll,perce,4);\nll=getData(ll,som,5);\nll=getData(ll,pip,6);\nll=getData(ll,cap,7);\nvar valueCap12=temp.substring(1);\nif(valueCap12==\"\")\n{\n}\nelse\n{\nif(CapVal1[capte1]==null)\n{\nvar valueCap3=valueCap12;\n}\nelse\n{\nvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\n\n}\nelementval[eventre]=valueCap12;\neventre++;\nd.add(cou1,ll,valueCap3,\"\");\ncou1++;\ncapte1++;\n\n}\nbreak;\n\n\n}\n}\n\n\ntemp=curval;\n\n}\nelse \n{\n\ttemp=temp+curval;\n\n\t\n}\n  }\n if(temp.length>0 )\n{\ntemp=temp.substring(0,(temp.length-spe));\nswitch(test(somethingdata))\n\n{\ncase 0:\n\n\nvar value11=temp.substring(counting);\n\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\n\nvar value1=value11+\"     =     \"+hashVal[hashte];\n\n}\nelementval[eventre]=value11;\neventre++;\nd.add(cou1,0,value1,\"javascript:selectLink()\");\nhash=cou1;\ncou1++;\nhashte++;\n\n}\nbreak;\ncase 1:\n\ndola=getData(dola,hash,1);\n\nvar value12=temp.substring((counting));\n\n\n\nif(value12==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"     =     \"+dolVal[dolte];\n\n}\nelementval[eventre]=value12;\neventre++;\nd.add(cou1,hash,value2,\"javascript:selectLink()\");\ndola=cou1;\ncou1++;\ndolte++;\n}\n\n\nbreak;\ncase 2:\ndollor=getData(dollor,hash,1);\ndollor=getData(dollor,dola,2);\n\n\nvar value13=temp.substring((counting));\n\n\nif(value13==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"     =     \"+PerVal[perte];\n\n}\nelementval[eventre]=value13;\neventre++;\nd.add(cou1,dola,value3,\"javascript:selectLink()\");\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\ncounting=0;\n}\nbreak;\ncase 3:\n\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\nperce=getData(perce,dollor,3);\nvar somevalue1=\"\";\n\n\nvar somevalue=temp.substring(counting);\n\nif(somevalue==\"\")\n{\n}\nelse\n{\nif(boxval[boxte]==null)\n{\nsomevalue1=somevalue;\n\n\n}\nelse\n{\nsomevalue1=somevalue+\"     =     \"+Lesstan[lesste];\n\n}\n\nelementval[eventre]=somevalue;\neventre++;\nd.add(cou1,perce,somevalue1,\"javascript:selectLink()\");\nsom=cou1;\nboxte++;\ncou1++;\n\n}\n\n\nbreak;\ncase 4:\n\nsom =getData(som,hash,1);\nsom=getData(som,dola,2);\nsom=getData(som,dollor,3);\nsom=getData(som,perce,4);\nvar lessval1=\"\";\n\nvar lessval=temp.substring(counting);\n\nif(lessval==\"\")\n{\n}\nelse\n{\nif(Lesstan[lesste]==null)\n{\nlessval1=lessval;\n}\nelse\n{\nlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\n}\nelementval[eventre]=lessval;\neventre++;\nd.add(cou1,som,lessval1,\"javascript:selectLink()\");\npip=cou1;\nlesste++;\ncou1++;\n\n}\n\nbreak;\ncase 5:\npip=getData(pip,hash,1);\npip=getData(pip,dola,2);\npip=getData(pip,dollor,3);\npip=getData(pip,perce,4);\npip=getData(pip,som,5);\n\n\n\nvar valuePip1=temp.substring(1);\n\n\n\nif(valuePip1==\"\")\n{\n}\nelse\n{\nif(PiptVal[pipte]==null)\n{\nvar valuePip=valuePip1;\n}\nelse\n{\nvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n}\nelementval[eventre]=valuePip1;\neventre++;\nd.add(cou1,pip,valuePip,\"javascript:selectLink()\");\n\n cap=cou1;\n cou1++;\n pipte++;\n\n }\nbreak;\ncase 6:\ncap=getData(cap,hash,1);\ncap=getData(cap,dola,2);\ncap=getData(cap,dollor,3);\ncap=getData(cap,perce,4);\ncap=getData(cap,som,5);\ncap=getData(cap,pip,6);\nvar valueCap1=temp.substring(1);\n\n\nif(valueCap1==\"\")\n{\n}\nelse\n{\nif(CapVal[capte]==null)\n{\nvar valueCap=valueCap1;\n}\nelse\n{\nvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\n}\nelementval[eventre]=valueCap1;\neventre++;\n\nd.add(cou1,cap,valueCap,\"javascript:selectLink()\");\nll=cou1;\ncou1++;\ncapte++;\n\n}\nbreak;\ncase 7:\nll=getData(ll,hash,1);\nll=getData(ll,dola,2);\nll=getData(ll,dollor,3);\nll=getData(ll,perce,4);\nll=getData(ll,som,5);\nll=getData(ll,pip,6);\nll=getData(ll,cap,7);\nvar valueCap12=temp.substring(1);\nif(valueCap12==\"\")\n{\n}\nelse\n{\nif(CapVal1[capte1]==null)\n{\nvar valueCap3=valueCap12;\n}\nelse\n{\nvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\n\n}\nelementval[eventre]=valueCap12;\neventre++;\nd.add(cou1,ll,valueCap3,\"\");\ncou1++;\ncapte1++;\n\n}\nbreak;\n\n\n}\n}\n\n \ndocument.write(d);\nd.nodeStatus(true,1,true);\nd.nodeStatus(true,2,true);\nd.nodeStatus(true,3,true);\n//d.openAll();\n\n}\n\nfunction  getData(val1,val2)\n {\n if(val1 < val2)   val1 =val2; \n   return val1;\t\n }\nfunction  test(val1)\n{\nvar align=0;\n\n\nfor(var spk=0;spk<SplitinElements.length;spk++)\n{\nif(val1==intSymbols[spk])\n{\n\nalign=(spk);\n\n\n}\n\n}\n\n\nreturn align;\n}\nfunction  compare(val1)\n {\n\nvar val2;\n\n\n\n\nif(val1==Symbols[0]  || val1==Symbols[1] || val1==Symbols[2] || val1==Symbols[3] || val1==Symbols[4] || val1==Symbols[5] || val1==Symbols[6] || val1==Symbols[7] || val1==Symbols[8] || val1==Symbols[9] || val1==Symbols[10] || val1==Symbols[11] || val1==Symbols[11]  )\n{\n\nval2=val1;\n}\nelse\n{\n\nfor(var intds=0;intds<intSymbols.length;intds++)\n{\n\nif(val1==intSymbols[intds])\n{\n\nval2=intSymbols[intds];\n}\n\n}\n}\nreturn val2;\t\n\n}\n  function  test2(firstar,secondar)\n{\n\n\tif(!captwoarray[firstar][secondar])\n\t{\n\t\talign=6; \n\t\tMainboolean==true;\t\t\t\t\t\t\t   \n\t}\n\telse\n\t{\n\t\tMainboolean=false;\n\t\talign=7;\n\t}\n\treturn align;\n}\nfunction  test1(val1,current,next,firstar,secondar)\n{\nvar align=0;\nvar pipsym=\'|\';\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \nvar capsym=\'^\';\nif(val1==pipsym)\n{\n\tif(next==capsym)\n\t{\n      if(!captwoarray[firstar][secondar])\n\t\t{\n\t\t\t align=6;\n             Mainboolean=true;\n\t\t}\n\n\t}\n}\n\n\n}\n/*\nfunction  test1(val1,current,next,firstar,secondar)\n{\n\nvar align=0;\nvar pipsym=\'|\';\nvar capsym=\'^\';\nif(val1==pipsym)\n{\n\tif(next==pipsym)\n\t{\n\t        for(var spk=0;spk<SplitinElements.length;spk++)\n\t\t\t{\n\t\t\t\tif(val1==intSymbols[spk])\n\t\t\t\t{\n                   \n\t\t\t\t\talign=(spk);\n\t\t\t\t\tMainboolean=true;\n\t\t\t\t}\n\n\t\t\t}\n\t\t/*if(!captwoarray[(firstar+1)][secondar])\n\t\t{\n\t\t\tfor(var spk=0;spk<SplitinElements.length;spk++)\n\t\t\t{\n\t\t\t\tif(val1==intSymbols[spk])\n\t\t\t\t{\n                   \n\t\t\t\t\talign=(spk);\n\t\t\t\t\tMainboolean=true;\n\t\t\t\t}\n\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\talert(firstar+\" secondar : \"+secondar+\" \" +captwoarray[(firstar+1)][secondar]);\n\t\t alert(\"condi 1: 2\")\n\t\t\talign=7;\n\t\t\tdeboo=true;\n            Mainboolean=false;\n\t\t//}\n\n\t}\n    else if(next==capsym)\n    {\n\talert(\"condi 1: 3\");\n        align=7;\n\t\tMainboolean=true;\n\t}\n\telse\n\t{\n\t    for(var spk=0;spk<SplitinElements.length;spk++)\n\t\t\t{\n\t\t\t\tif(val1==intSymbols[spk])\n\t\t\t\t{\n\n\t\t\t\t\talign=(spk);\n                    Mainboolean=true;\n\t\t\t\t}\n\n\t\t\t}\n\t}\n\n}\nelse if(val1==capsym)\n{\n   if(next==pipsym)\n\t{\n       if(!captwoarray[firstar][secondar])\n\t\t{\n\t\t\talign=6;\n             Mainboolean=true;\n\t\t}\n\t\telse\n\t\t{\n            align=7;\n\t\t\t  Mainboolean=false;\n\t\t}\n\t \n\t}\n\telse if(next==capsym)\n\t{\n            align=7;\n\t\t\tMainboolean=true;\n\t}\n    else\n\t{\n\t    for(var spk=0;spk<SplitinElements.length;spk++)\n\t\t\t{\n\t\t\t\tif(val1==intSymbols[spk])\n\t\t\t\t{\n\n\t\t\t\t\talign=(spk);\n\t\t\t\t\tMainboolean=true;\n\t\t\t\t}\n\n\t\t\t}\n\t}\n\n\n}\n\nelse\n{\nfor(var spk=0;spk<SplitinElements.length;spk++)\n{\nif(val1==intSymbols[spk])\n{\n\nalign=(spk);\nMainboolean=true;\n\n}\n\n}\n}\nalert(\"Mainboolean \"+Mainboolean);\nalert(\"align :\"+align);\nreturn align;\n}\n*/\n\n\n \n\n function Trim(str)\n{ \nwhile(str.charAt(0) == (\" \") )\n  {  str = str.substring(1);\n  }\n  while(str.charAt(str.length-1) == \" \" )\n  {  str = str.substring(0,str.length-1);\n\n  }\n  return str;\n}\n\n\nfunction checkFunCap()\n{\n\nwhile(caplength>0)\n{\n\n\ncountingpip[pipsing][gendrcou]=\" \"+\"  =  \"+captwoarraysec[cate][capcsec];\nd.add(cou1,storecate,countingpip[pipsing][gendrcou],\"javascript:selectLink()\");\ncapc++;\ncapcsec++;\ncou1++;\ngendrcou++;\ncaplength--;\n\n}\n\n}\nfunction checkRemainingVal(rem,capc1,cou1,ll)\n{\nvar bool=false;\n\nwhile(rem>0)\n{\n\n\tvar check=captwoarraysec[cate][capcsec];\nelementval[eventre]=\"\";\neventre++;\n   d.add((cou1-1),ll,\" \"+\" = \"+captwoarray[pipsing][capc1],\"\");\n\tcountingpip[pipsing][gendrcou]=\" \"+\"  =  \"+captwoarray[pipsing][capc];\nbool=true;\ngendrcou++;\ncapcsec++;\ncapc1++;\ncou1++;\n\nrem--;\n}\n\n\nif(bool==true)\n{\n//alert(\"inga\");\n//alert(\"capc \"+capc);\ncapc=capc1;\n//cate++;\n//capcsec=0;\n\n}\t\t\t\t\t\t\t\t\t\t\t \n//cate++;\n}\n\nasync function selectLink()\n{ \n \tvar url=\'../../eXH/jsp/ViewElementTreeText.jsp?&standard_code=\'+document.forms[0].Standard_code.value+\'&event=\'+elementval[(d.selectedNode-1)];\n\t   var arguments  =new Array();\nvar dialogTop   = \"350\";\nvar dialogHeight= \"27\" ;\nvar dialogWidth = \"250\" ;\t\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\t\n\tawait window.showModalDialog(url,arguments,features);\n\n\t//parent.parent.frames[2].location.href=str\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n}  \nfunction checkIndexChar(sym,gen)\n{\n\n \n\tif(sym==\'^\')\n\t{\n\n\t\tif(gen==(gendrcou-1))\n\t\t{ \n        capcsec=0;\n        cate=cate+1;\n\t\n\t\tvar leng=captwoarraysec[cate].length;\n\t\n       while(leng>0)\n\t\t{\n  \n\t\t //d.add(cou1,ll,countingpip[pipsing][gendrcou],valueCap); \n\t\tcountingpip[pipsing][gendrcou]=\" \"+\"  =  \"+captwoarraysec[cate][capcsec];\n\t    d.add(cou1,ll,countingpip[pipsing][gendrcou],\"\"); \n\t\tgendrcou++;\n\t\tcapcsec++;\n        capc++;\n\t\tleng--;\n\t\tcou1++;\n\t\telementval[eventre]=\"\";\n\t\teventre++;\n\t\t}\n\t\n\t\t}\n\t\t\n\t}\n}\n}\ncatch(e)\n{\n\t  \n\nparent.frames[0].document.location.href=\"../../eXH/jsp/ViewTree.jsp?applicationID=\"+document.forms[0].applicationId.value+\"&facilityID=\"+document.forms[0].facilityId.value+\"&purge_status=\"+document.forms[0].purge_status.value+\"&msgID=\"+document.forms[0].Msg_Id.value+\"&even_type=\"+document.forms[0].even_type.value+\"&protocol_link_id=\"+document.forms[0].ProtocolID.value+\"&sub_module=\"+document.forms[0].sub_module.value+\"&applicationName=\"+document.forms[0].applicationName.value+\"&facilityName=\"+document.forms[0].facilityName.value+\"&srlNo=\"+document.forms[0].srlNo.value+\"&event_name=\"+document.forms[0].event_name.value+\"&protocolMode=\"+document.forms[0].protocolMode.value+\"&rule=J&rule2=H&img=\"+document.forms[0].img.value;\n\nif(e instanceof RangeError)\n{\n\n\n\tif(document.forms[0].rule.value==\'R\')\n\t{\n\t\tif(emptyflag==false)\n\t{\n\t\tvar message=getMessage(\'XH0076\',\'XH\');\n\t\tmessage=message.replace(\'$\',\'\');\n\t   alert(message);\n\t}\n\telse\n\t{\n\t}\n\t}\n\telse \n\t{\n\t}\n} \nelse\n{ \n\tif(emptyflag==false)\n\t{\n\t\tvar message=getMessage(\'XH0076\',\'XH\');\n\t\tmessage=message.replace(\'$\',\'\');\n\t\talert(message);\n\t}\n\telse\n\t{\n\n\t}\n}\n \n}\n\n\n\n</script>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</td>\n</tr>\n</table>\n</div>\n</form>\n\n</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8"); 
Properties p = (Properties) session.getValue("jdbc"); 
String loggedUser = p.getProperty("login_user");
//String locale = ((String)session.getAttribute("LOCALE")); 

            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
  
	Connection connection = null;
	CallableStatement  oraclecallablestatement = null;
	boolean authToElement = false;
	try
	{
		if(connection == null) connection = ConnectionManager.getConnection();
/*	}
	catch(Exception e)
	{
		System.out.println("Exception e"+e);
	} */

	String rule=request.getParameter("rule");
	String rule2=request.getParameter("rule2");
	String img = XHDBAdapter.checkNull(request.getParameter("img"));
	String authSql = "SELECT ELEMENT_DESC_YN FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"+loggedUser+"')"; 
	ResultSet authRS = null;	
		try 
		{
			authRS = connection.createStatement().executeQuery(authSql);
			if(authRS.next())
			{		
				String strele_desc_yn = authRS.getString("ELEMENT_DESC_YN");
				if(strele_desc_yn != null && strele_desc_yn.equalsIgnoreCase("Y")) authToElement = true;
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		finally
		{
			if(authRS != null) authRS.close();
		}
if(rule.equals("J") || rule.equals("R")) 
{

            _bw.write(_wl_block10Bytes, _wl_block10);
}else
 { 
	 if(img.equals("Y"))
	 {
		 
            _bw.write(_wl_block11Bytes, _wl_block11);
}
		 else
	 {
		  if(authToElement)
		 {
   
            _bw.write(_wl_block12Bytes, _wl_block12);

		 }
          else
		 {
			
            _bw.write(_wl_block13Bytes, _wl_block13);
}
 }
            _bw.write(_wl_block14Bytes, _wl_block14);
 }
            _bw.write(_wl_block15Bytes, _wl_block15);

	String url="";
	String event_name=""; 
	String applicationId = "";
	String facilityId = "";
	String msgId = "";
	String eventType = "";
	String ProtocolID = "";
	String Msq_txt = "";
	String MsgText = "";
	String Standard_code = "";
	String Message_syntax = "";
	String Standard_symbols = "";
	String errorMsg = "";
	String event="";
	String Standard_type = "";
	String msgstatus = "";
	String applicationName=XHDBAdapter.checkNull(request.getParameter("applicationName"));
	String facilityName=XHDBAdapter.checkNull(request.getParameter("facilityName"));
	String protocol_mode = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
	String sub_module = request.getParameter("sub_module");
	String srlNo = request.getParameter("srlNo");
    applicationId = request.getParameter("applicationID"); 
    facilityId = request.getParameter("facilityID");
    msgId = request.getParameter("msgID");
    ProtocolID = request.getParameter("protocol_link_id");
	if(protocol_mode.equals("Inbound")) 
	{
		protocol_mode = "I";  
	} 
	else if(protocol_mode.equals("Outbound"))
	{
		protocol_mode = "O";
	}
    eventType = request.getParameter("even_type");
	String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
  event_name = XHDBAdapter.checkNull(request.getParameter("event_name"));

	if(rule.equals("J") || rule.equals("R") )
	{

		if(rule2.equals("H"))
		{
			url = "../../eXH/jsp/ViewTree.jsp?applicationID="+applicationId+"&facilityID="+facilityId+"&msgID="+msgId+"&purge_status="+purge_status+"&even_type="+eventType+"&protocol_link_id="+ProtocolID+"&sub_module="+sub_module+"&applicationName="+applicationName+"&facilityName="+facilityName+"&protocolMode="+protocol_mode+"&srlNo="+srlNo+"&event_name="+event_name+"&rule=S&rule2=H&img="+img;
		}
		else
		{
			url = "../../eXH/jsp/ViewTree.jsp?applicationID="+applicationId+"&facilityID="+facilityId+"&msgID="+msgId+"&purge_status="+purge_status+"&even_type="+eventType+"&protocol_link_id="+ProtocolID+"&sub_module="+sub_module+"&applicationName="+applicationName+"&facilityName="+facilityName+"&event_name="+event_name+"&protocolMode="+protocol_mode+"&srlNo="+srlNo+"&rule=S&rule2=&img="+img;
		}

		String sql = "";
	 try
	{ 
		 String underScore = "";
		if(event_name.equals("") || event_name==null)
		{
			event = eventType;
		}
        else
		{ 
	       event = event_name;
		}

		if(purge_status != null && !purge_status.equals(""))
		{
			underScore = "_";
		}
		
		if(protocol_mode!=null && protocol_mode.equalsIgnoreCase("I"))
		{			
			sql = "SELECT a.INBOUND_MESSAGE_TEXT,a.message_status,c.event_name FROM "+
					sub_module + underScore + purge_status + "_INBOUND_MESSAGE a" +
					",xh_event_type c WHERE a.APPLICATION_ID=NVL('"+applicationId+"',a.APPLICATION_ID) " +
					" AND a.MESSAGE_ID=NVL('"+msgId+"',a.MESSAGE_ID)" +
					" AND a.facility_id=NVL('"+facilityId+"',a.facility_id)"+
					" AND a.SRL_NO=NVL('"+srlNo+"',a.SRL_NO) and a.EVENT_TYPE=c.EVENT_TYPE";
		} 
		else if(protocol_mode!=null && protocol_mode.equalsIgnoreCase("O"))
		{														  
			
			if((applicationId.equalsIgnoreCase("EPABXO"))||(applicationId.equalsIgnoreCase("EPABXI")))
			{	
				sql = "SELECT a.MESSAGE_TEXT,a.message_status,c.event_name FROM XP_EVENT a"
						+ ",xh_event_type c WHERE a.APPLICATION_ID=NVL('"+applicationId+"',a.APPLICATION_ID) "
						+ " AND a.MESSAGE_ID=NVL('"+msgId+"',a.MESSAGE_ID)"
						+ " AND a.EVENT_TYPE=NVL('"+eventType+"',a.EVENT_TYPE) "
						+ " AND a.FACILITY_ID=NVL('"+facilityId+"',a.FACILITY_ID ) and a.EVENT_TYPE=c.EVENT_TYPE";
			}
			else
			{
				sql = "SELECT a.MESSAGE_TEXT,a.message_status,c.event_name FROM "+
					sub_module + underScore + purge_status + "_APPLICATION_MESSAGE a"
						+ ",xh_event_type c WHERE a.APPLICATION_ID=NVL('"+applicationId+"',a.APPLICATION_ID) "
						+ " AND a.MESSAGE_ID=NVL('"+msgId+"',a.MESSAGE_ID)"
						+ " AND a.EVENT_TYPE=NVL('"+eventType+"',a.EVENT_TYPE) "
						+ " AND a.FACILITY_ID=NVL('"+facilityId+"',a.FACILITY_ID ) and a.EVENT_TYPE=c.EVENT_TYPE";
			}	
		}
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{ 
			Msq_txt= rs.getString(1);
			event_name=rs.getString(3);		
			msgstatus=rs.getString(2);
		}
		if(event_name.equals("") || event_name==null)
		{
			event=eventType;
		}
        else
		{
	       event=event_name;
		}
		if(stmt!=null)stmt.close();
		if(rs!=null) rs.close();
      }
      catch(Exception exp)
      {
		System.out.println("(ViewTree.jsp sqlQuery -1):"+sql);
		System.out.println("Error in calling getconnection method of ViewSegmentJSP :"+exp.toString());
		exp.printStackTrace(System.err);
	  }
	  out.println("<script>d = new dTree('d');");
	  out.println("d.add(0,-1,'','"+url+"');"); 
	  out.println("d.add(1,0,'"+applicationName+"','"+url+"');"); 
	  out.println("d.add(2,1,'"+facilityName+"','"+url+"');");
	  out.println("d.add(3,2,'"+event+"','"+url+"');");
	  out.println("d.add(4,3,'','');");
	  out.println("document.write(d);</script>");
}
else 
{
	String sql = "";
	String Msg_syntax="";
	String Msg_text="";
	try
	{
		
		if(protocol_mode!=null && protocol_mode.equalsIgnoreCase("I"))
		{
			sql="SELECT a.INBOUND_MESSAGE_TEXT,a.message_status,c.event_name FROM "+sub_module+"_INBOUND_MESSAGE a" +
					",xh_event_type c WHERE a.APPLICATION_ID=NVL('"+applicationId+"',a.APPLICATION_ID) " +
					" AND a.MESSAGE_ID=NVL('"+msgId+"',a.MESSAGE_ID)" +
					" AND a.facility_id=NVL('"+facilityId+"',a.facility_id)"+
					" AND a.SRL_NO=NVL('"+srlNo+"',a.SRL_NO) and a.EVENT_TYPE=c.EVENT_TYPE";
		}
		else if(protocol_mode!=null && protocol_mode.equalsIgnoreCase("O"))
		{														  
			
			if((applicationId.equalsIgnoreCase("EPABXO"))||(applicationId.equalsIgnoreCase("EPABXI")))
			{	
				sql="SELECT a.MESSAGE_TEXT,a.message_status,c.event_name FROM XP_EVENT a"
						+ ",xh_event_type c WHERE a.APPLICATION_ID=NVL('"+applicationId+"',a.APPLICATION_ID) " 
						+ " AND a.MESSAGE_ID=NVL('"+msgId+"',a.MESSAGE_ID)"
						+ " AND a.EVENT_TYPE=NVL('"+eventType+"',a.EVENT_TYPE) "
						+ " AND a.FACILITY_ID=NVL('"+facilityId+"',a.FACILITY_ID ) and a.EVENT_TYPE=c.EVENT_TYPE";
			}
			else
			{
				sql="SELECT a.MESSAGE_TEXT,a.message_status,c.event_name FROM "+sub_module+"_APPLICATION_MESSAGE a"
						+ ",xh_event_type c WHERE a.APPLICATION_ID=NVL('"+applicationId+"',a.APPLICATION_ID) "
						+ " AND a.MESSAGE_ID=NVL('"+msgId+"',a.MESSAGE_ID)"
						+ " AND a.EVENT_TYPE=NVL('"+eventType+"',a.EVENT_TYPE) "
						+ " AND a.FACILITY_ID=NVL('"+facilityId+"',a.FACILITY_ID ) and a.EVENT_TYPE=c.EVENT_TYPE";
			}	
		}

	
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{ 
			Msq_txt= rs.getString(1);
			msgstatus=rs.getString(2);
		    event_name=rs.getString(3);
		}
		 if(event_name.equals("") || event_name==null)
		{
			event=eventType;
		}
        else
		{
			event=event_name;
		}
		if(stmt!=null)stmt.close();
		if(rs!=null) rs.close();
      
      }
      catch(Exception exp)
      {
		  	System.out.println("(ViewTree.jsp sqlQuery -2):"+sql);
		 System.out.println("Error in calling getconnection method of ViewTreeJSP :"+exp.toString());
	 	 exp.printStackTrace(System.err);
      }
try
{
		oraclecallablestatement =  connection.prepareCall("{ call xhgeneric.standard_message_viewer(?,?,?,?,?,?,?,?,?,?,?) }" ); 
		oraclecallablestatement.setString(1,applicationId);
		oraclecallablestatement.setString(2,facilityId);
		oraclecallablestatement.setString(3,msgId);
		oraclecallablestatement.setString(4,ProtocolID);
		oraclecallablestatement.setString(5,eventType);
		CLOB clob = CLOB.createTemporary(connection, true, CLOB.DURATION_SESSION);
		java.io.Writer out1 = clob.getCharacterOutputStream();
		out1.write(Msq_txt);
		out1.close(); 
		oraclecallablestatement.setClob(6, clob); 
		oraclecallablestatement.registerOutParameter(6,java.sql.Types.CLOB);
		oraclecallablestatement.registerOutParameter(7,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(8,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(9,java.sql.Types.CLOB);
		oraclecallablestatement.registerOutParameter(10,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(11,java.sql.Types.VARCHAR);
		oraclecallablestatement.execute();
		MsgText = oraclecallablestatement.getString(6);
		Standard_code = oraclecallablestatement.getString(7);
		Standard_type = oraclecallablestatement.getString(8);
		Message_syntax = oraclecallablestatement.getString(9).trim();
		Standard_symbols = oraclecallablestatement.getString(10).trim();
		errorMsg = oraclecallablestatement.getString(11);
		if(Standard_symbols.indexOf("{64")!=-1)
		{
			Message_syntax=Message_syntax.replaceFirst("@","[");
			MsgText=MsgText.replaceFirst("@","[");
			Standard_symbols=Standard_symbols.replaceFirst("64","91");
		}
		Msg_syntax = java.net.URLEncoder.encode(Message_syntax);
		Msg_text = java.net.URLEncoder.encode(MsgText);
		if(oraclecallablestatement!=null) 
		oraclecallablestatement.close();
	}
	catch(Exception exp)
    {
       exp.printStackTrace(System.err);
	   System.out.println("(ViewTree:StandardMessageViewer)Exception: "+exp);
    }	    

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Standard_symbols));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Msg_text));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Msg_syntax));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rule));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Standard_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Standard_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rule2));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(applicationId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(msgId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(eventType));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ProtocolID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(applicationName));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(protocol_mode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(srlNo));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(event_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(img));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
}	
}
	catch(Exception e)
	{
		System.out.println("ViewTree :StandardMessageViewer closed dbrelated Exception e"+e);
	}

	 finally{
		ConnectionManager.returnConnection(connection);
		//	if(stmt!=null)stmt.close();
	}
            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
