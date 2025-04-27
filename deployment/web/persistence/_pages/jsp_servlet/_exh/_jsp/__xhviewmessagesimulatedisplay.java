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

public final class __xhviewmessagesimulatedisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/XHViewMessageSimulateDisplay.jsp", 1743587284983L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML> \n";
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

    private final static java.lang.String  _wl_block6 ="\t\t\n<HEAD> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<style type = \'text/css\'> \nTD.COLUMNHEADER { \t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t    \n   BACKGROUND-COLOR: #404040;\n   COLOR: white ; \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n   FONT-SIZE: 8pt;   \n   font-weight: bolder;\n   PADDING-LEFT:7px;\n   PADDING-RIGHT:7px\n}\n  </STYLE>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\n<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n<link rel=\"StyleSheet\" href=\"../../eXH/html/dtree.css\" type=\"text/css\" />\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\"StyleSheet\" href=\"../../eXH/html/lris_style.css\" type=\"text/css\" />\n<script type=\"text/javascript\" src=\"../../eXH/js/dtree1.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script> \t\t\t\t\t    \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n \n\n </head>\n <BODY   >     \t\t\t\t\t\t\t\t\t\t\t\t\t\t      \n<form name=\"view_segment_form\" id=\"view_segment_form\">\n<div class=\"dtree\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n<table cellspacing=0 cellpadding=3 width=\'99%\' align=center >\n<tr> \n<td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<input type=hidden id=\'Standard_Symbols\' name=\'Standard_Symbolsright\' id=\'Standard_Symbolsright\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' > \n<input type=hidden name=\'Facility\' id=\'Facility\' value=\'\' >\n<input type=hidden name=\'Message_ID\' id=\'Message_ID\' value=\'\' >\n<input type=hidden name=\'Protocol_link\' id=\'Protocol_link\' value=\'\' >\n<input type=hidden id=\'Message_text\' name=\'Message_textright\' id=\'Message_textright\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  >\t   \n<input type=hidden id=\'Message_Syn\' name=\'Message_Synright\' id=\'Message_Synright\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' >\n<input type=hidden id=\'rule\' name=\'rule\' id=\'rule\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' >\n<input type=hidden id=\'Standard_code\' name=\'Standard_code\' id=\'Standard_code\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' >\n<input type=hidden id=\'Standard_type\' name=\'Standard_typeright\' id=\'Standard_typeright\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' >\n<input type=hidden id=\'rules\' name=\'rules\' id=\'rules\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=hidden id=\'applicationId\' name=\'applicationId\' id=\'applicationId\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=hidden id=\'facilityId\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=hidden id=\'Msg_Id\' name=\'Msg_Id\' id=\'Msg_Id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=hidden id=\'even_type\' name=\'even_type\' id=\'even_type\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=hidden id=\'ProtocolID\' name=\'ProtocolID\' id=\'ProtocolID\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=hidden id=\'sub_module\' name=\'sub_module\' id=\'sub_module\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=hidden id=\'applicationName\' name=\'applicationName\' id=\'applicationName\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=hidden id=\'facilityName\' name=\'facilityName\' id=\'facilityName\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=hidden id=\'protocolMode\' name=\'protocolMode\' id=\'protocolMode\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=hidden id=\'srlNo\' name=\'srlNo\' id=\'srlNo\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=hidden id=\'event_name\' name=\'event_name\' id=\'event_name\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=hidden id=\'element\' name=\'element\' id=\'element\' value=\'\'>\n<input type=hidden id=\'img\' name=\'img\' id=\'img\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\n<input type=\"hidden\" name=\"purge_status\" id=\"purge_status\" id=\"purge_status\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'/> \n<script>\ntry { \nvar remind=0;\nvar eventre=0;\nvar deboo=false;\nvar Mainboolean=true;\nvar comsixteen;\nvar storecap=\"\";\nvar gendrcou=0;\nvar boxte=0;\nvar storegenc=0;\nd = new dTree(\'d\');\nvar caplength=0;\nvar pipsing=-1;\nvar capcsec=0;\nvar dollor=0;\nvar countingpip=new Array();\nvar countcap=new Array();\nvar treeval =new Array();\nvar tswArr =new Array();\nvar AtArr =new Array();\nvar ExcArr =new Array();\nvar pipArr =new Array();\nvar capArr =new Array();\nvar TextVal=new Array();\nvar tswVal=new Array();\nvar AtVal=new Array();\nvar ExcVal=new Array(); \nvar PiptVal=new Array();\nvar CapVal=new Array();\nvar AmperVal=new Array();\nvar OpenVal=new Array();\nvar piplength=0;\nvar CloseVal=new Array();\nvar tsw=0;\nvar cou=1;\nvar Exc=0;\nvar At=0;\nvar pip=0;\nvar tswt=0;\nvar Att=0;\nvar Exct=0;\nvar Pipt=0;\nvar cc=0;\nvar cc1=-1;\nvar Capt=0;\nvar Ampert=0;\nvar cate=-1;\nvar storecate=0\nvar treeval =new Array();\nvar hashArr =new Array();\nvar dolArr =new Array();\nvar perArr =new Array();\nvar pipArr =new Array();\nvar capArr =new Array();\nvar dolVal=new Array();\nvar PerVal=new Array();\nvar hashVal=new Array();\nvar TextVal=new Array();\nvar Open=0;\nvar Amper=0;\nvar Opent=0;\nvar Closet=0;\nvar pip=0;var Cap=0;\nvar elementflag=false;\nvar hash=0;\nvar hashCou;\nvar dolCou;\nvar perCou;\nvar pipCou;\nvar capCou;\nvar l_pos;\nvar boo=true;\nvar cou=1;\nvar temp=\'\';\nvar perce=0;\nvar dola=0;\nvar som=0;\nvar pip=0;\nvar hasht=0;\nvar dolt=0;\nvar Pert=0;\nvar ll=0;\nvar capte1=0;\nvar k2=\"\";\nvar ic3=0;\nvar symbolvalue;\nvar losec=0;\nvar temp=\'\';\nvar d1=0;\nvar val=\"\";\nvar piptwoarray=new Array();\nvar captwoarray=new Array();\nvar captwoarraysec=new Array();\nvar acchar=0;\nvar sy=\'\';\nvar Symbols=new Array();\nvar elementval=new Array();\nvar s1=0;\nvar Lesstan=new Array();\nvar less=0;\nvar MessageHead=\"\";\nvar CapVal1=new Array();\nvar Capt1=0;\nvar boxval=new Array();\nvar box=0;\nvar checkpu=0;\nvar messegetext=unescape(document.forms[0].Message_textright.value); \nvar Messegesyntax=unescape(document.forms[0].Message_Synright.value); \n   \n\nvar emptyflag=false;\nif(Messegesyntax==\'\')\n{\n\tvar message=getMessage(\'XH0076\',\'XH\');\n\tmessage=message.replace(\'$\',\'\');\n\t   alert(message);\n\t   emptyflag=true;\n\t/*parent.f_query_add_mod_tree.document.location.href=\"../../eXH/jsp/XHViewMessageSimulateDisplay.jsp?applicationID=\"+document.forms[0].applicationId.value+\"&facilityID=\"+document.forms[0].facilityId.value+\"&purge_status=\"+document.forms[0].purge_status.value+\"&msgID=\"+document.forms[0].Msg_Id.value+\"&even_type=\"+document.forms[0].even_type.value+\"&protocol_link_id=\"+document.forms[0].ProtocolID.value+\"&sub_module=\"+document.forms[0].sub_module.value+\"&applicationName=\"+document.forms[0].applicationName.value+\"&facilityName=\"+document.forms[0].facilityName.value+\"&srlNo=\"+document.forms[0].srlNo.value+\"&event_name=\"+document.forms[0].event_name.value+\"&protocolMode=\"+document.forms[0].protocolMode.value+\"&rule=J&rule2=H&img=\"+document.forms[0].img.value;\t*/ \n}\nvar Standard_symbols=document.forms[0].Standard_Symbolsright.value;\nvar count=0;\n\nvar compilesimples=3;\nvar Standard_type1=document.forms[0].Standard_typeright.value;\n\n\nvar SplitinElements=new Array();\nvar sp=0;\nvar spliting=Standard_symbols.split(\"{{{\");\n\nfor(var s=0;s<spliting.length;s++)\n{\n\nif(spliting[s].indexOf(\'|\')!=-1)\n{\nvar SpilitngStandardpip=spliting[s].split(\'|\');\n\n\nSplitinElements[sp]=SpilitngStandardpip[1];\n\n}\n\nelse\n{\nSplitinElements[sp]=spliting[s];\n\n}\nsp++;\n\n//} \n}\n\nvar pi=1;\nvar lo=1;\nvar spt1=0;\nvar intSymbols=new Array();\nvar intd=0;\nfor(var spt=0;spt<SplitinElements.length;spt++)\n{\nif(spt==0 || spt==1 || spt==2)\n{\nSymbols[spt1]=\"#\"+String.fromCharCode(SplitinElements[spt])+\"#\";\nintSymbols[intd]=\"#\"+String.fromCharCode(SplitinElements[spt])+\"#\";\nintd++;\n}\nelse\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n{\n\nSymbols[spt1]=String.fromCharCode(SplitinElements[spt]);\nintSymbols[intd]=String.fromCharCode(SplitinElements[spt]);\nintd++;\n}\nspt1++;\n\n}\n\n\nif(Standard_type1==\'H\')\n{\nvar acchar1=0;\nvar pipsimple=\"|\";\nvar pipsym=messegetext.indexOf(\'|\');\nvar firstmessage=messegetext.substring(0,pipsym);\npiptwoarray[0]=new Array();\ncaptwoarray[0]=new Array();\npiptwoarray[0][0]=pipsimple;\n//CapVal[0]=pipsimple;\nPiptVal[0]=firstmessage;\nvar messagevaluepip=messegetext.substring((pipsym+1),messegetext.length);\nvar nextpip=messagevaluepip.indexOf(\'|\');\nvar massagenextpip=messagevaluepip.substring(0,(nextpip+1));\nvar secondsplit=messagevaluepip.substring(nextpip,messagevaluepip.length);\npiptwoarray[0][1]=massagenextpip;\n//CapVal[1]=massagenextpip;\nif(Symbols[3]!=null )\n{\nvar ch=Symbols[3].toString();\n}\nelse\n{\n\n}\n\nvar identifysimbol=Messegesyntax.indexOf(ch);\nvar identifypip=Messegesyntax.indexOf(\'|\');\n\nvar MsgsubString=Messegesyntax.substring(identifysimbol+1,identifypip);\nvar tillMegHeead=Messegesyntax.substring(0,identifysimbol);\nvar tillsegHead=Messegesyntax.substring(identifypip,Messegesyntax.length);\nvar ic1=2;\nvar ic2=2;\nvar Replace=\"\";\nvar pp=0;\nif(Symbols[5]!=null)\n{\nReplace=Symbols[5].toString()+MsgsubString;\n\n}\nelse\n{\nReplace=ch+MsgsubString;\n}\n\n Messegesyntax=tillMegHeead+ch+Replace+tillsegHead+\'|\';\n// alert(Messegesyntax);\n\nCapt=2;\nk2=secondsplit;\nPipt=1;\nvar flag=0;\n\nvar pipflag=0;\n\nfor(var i=0;i<k2.length;i++)\n{\n someval=(k2.charAt(i)).toString()+((k2.charAt(i+1)).toString())+((k2.charAt(i+2)).toString());\n  if((k2.charAt(i+2)).toString()==\"\" || (k2.charAt(i+1)).toString()==\"\")\n  {\n    someval=someval+\"lam,x\"+\"lam,x\";\n   }\n   if(someval == intSymbols[0] || someval == intSymbols[1] || someval == intSymbols[2]  || someval == intSymbols[3]  || someval == intSymbols[4] ||  someval == intSymbols[5] || someval == intSymbols[6] )\n{\n\n}\n var nextsimpol=someval.substring(0,1);\n curval= (k2.charAt(i)).toString();\n if(curval==\'+\')\n{\ncurval=\' \';\n}\n\n\n\nif(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == \'*\')\n{\n\n\n if(temp.length>0 )\n{\nif(temp.indexOf(\"^\")!=-1 || temp.indexOf(\"|\")!=-1 )\n{\nvar somethingdata1=temp.substring(0,1);\n\nif(somethingdata1==\'|\')\n{\n\npipflag=ic1;\n\nic3=0;\n\n}\nelse if(somethingdata1==\'^\')\n{\n\ncaptwoarraysec[losec]=new Array();\nlosec++;\n}\n}\nvar somethingdata=temp.substring(0,1);\nif(somethingdata==\'|\' && nextsimpol==\'|\' )\n{\n\n}\nelse\n{\n\n//Capt=0;\n//pp++;\n}\n\nswitch(test(somethingdata))\n{\n\ncase 0:\n\nbreak;\ncase 1:\n\nbreak;\ncase 2:\n\nbreak;\ncase 3:\nboxval[box]=temp.substring(1);\nbox++;\nbreak;\ncase 4:\nvar value3=temp.substring(1);\n\nif (value3==null)\n{\nLesstan[less]=MessageHead;\nless++;\n}\nelse\n{\nLesstan[less]=value3;\n\nless++;\n}\nbreak;\ncase 5:\nPiptVal[Pipt]=temp.substring(1);\npiptwoarray[pi]=new Array();\ncaptwoarray[lo]=new Array();\ncc=lo;\nlo++;\nic2=0;\nCapt=0;\npp++;\npi++;\nPipt++;\nbreak;\ncase 6:\nif(nextsimpol==\'^\')\n{\npiptwoarray[pp][Capt]=temp.substring(1)+nextsimpol;\n}\nelse\n{\npiptwoarray[pp][Capt]=temp.substring(1);\n\n}\n\nif(piptwoarray[pp][Capt]==\"\")\n{\nboo=false;\n}\nelse\n{\n\nboo=true;\nic1++;\nic3=0;\nic2++;\n}\n\nCapt++;\n\n\n\n\nbreak;\ncase 7:\nif(boo==true)\n{\ncc1++;\n}\ncaptwoarray[cc][ic2]=temp.substring(1);\ncaptwoarraysec[cc1][ic3]=temp.substring(1);\n\n\n\n//alert(\"cc :\"+cc1+\" ic2 \"+ic3+\" captwoarray[cc][ic2] :\"+captwoarraysec[cc1][ic3]);\nic3++;\n\nCapVal1[Capt1]=pipflag;\nic2++;\nCapt1++;\n\nboo=false;\n\n\nbreak;\n\n\n}\n}\ntemp=curval;\n}\nelse \n  {\n\ttemp=temp+curval;\n  }\n}\n if(temp.length>0)\n{\nswitch(test(curval))\n{\n\ncase 0:\n\nbreak;\ncase 1:\n\nbreak;\ncase 2:\n\nbreak;\ncase 3:\nboxval[box]=temp.substring(1);\nbox++;\nbreak;\ncase 4:\nvar value3=temp.substring(1);\n\nif (value3==null)\n{\nLesstan[less]=MessageHead;\nless++;\n}\nelse\n{\nLesstan[less]=value3;\n\nless++;\n}\nbreak;\ncase 5:\nPiptVal[Pipt]=temp.substring(1);\npiptwoarray[pi]=new Array();\ncaptwoarray[lo]=new Array();\ncc=lo;\nlo++;\nic2=0;\nCapt=0;\npp++;\npi++;\nPipt++;\nbreak;\ncase 6:\nif(nextsimpol==\'^\')\n{\npiptwoarray[pp][Capt]=temp.substring(1)+nextsimpol;\n}\nelse\n{\npiptwoarray[pp][Capt]=temp.substring(1);\n\n}\n\nif(piptwoarray[pp][Capt]==\"\")\n{\nboo=false;\n}\nelse\n{\n\nboo=true;\nic1++;\nic3=0;\nic2++;\n}\n\nCapt++;\n\n\n\n\nbreak;\ncase 7:\nif(boo==true)\n{\ncc1++;\n}\ncaptwoarray[cc][ic2]=temp.substring(1);\ncaptwoarraysec[cc1][ic3]=temp.substring(1);\n//alert(\"cc :\"+cc+\" ic2 \"+ic2+\" captwoarray[cc][ic2] :\"+captwoarray[cc][ic2]);\nic3++;\n\nCapVal1[Capt1]=pipflag;\nic2++;\nCapt1++;\n\nboo=false;\n\n\nbreak;\n\n}\n}\n\n\n/**************************populate Tree*************************////\n/**********************************Populate Tree*****************************/\nvar tswte=0;\nvar Atte=0;\nvar Excte=0;\nvar pipte=0;\nvar capte=0;\nvar cou1=1;\nvar Opente=0;\nvar Closete=0;\nvar Amperte=0\nvar hashte=0;\nvar pipsom=0;\nvar dolte=0;\nvar perte=0;\nvar lesste=0;\nvar cap=0;\n\nvar pipcheck=0;\nvar capc=0;\nd.add(0,-1,\'\');\nvar counting=1;\nvar spe=0;\nvar incr=0;\nfor(var i=0;i<Messegesyntax.length;i++)\n{\n\n\t curval=(Messegesyntax.charAt(i)).toString();\n\t curval1=(Messegesyntax.charAt(i)).toString();\n\tsome=(Messegesyntax.charAt(i)).toString()+((Messegesyntax.charAt(i+1)).toString())+((Messegesyntax.charAt(i+2)).toString());\n\n\n  if((Messegesyntax.charAt(i+2)).toString()==\"\" || (Messegesyntax.charAt(i+1)).toString()==\"\")\n  {\n    some=some+\"lam,x\"+\"lam,x\";\n   }\n\nif(compilesimples==i)\n{\ncurval=some1;\n\n}\n\nif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n{\ncompilesimples=(i+2);\nsome1=some;\ncounting=3;\nspe=2;\n}\nelse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n{\ncurval=curval1;\nspe=0;\ncounting=1;\n}\n\n       if(curval==\"+\")\n{\n\ncurval=\" \";\n}\n var nextsimpol=some.substring(0,1);\n\t\t \n\t  \n\n\n \n if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])\n \n {\n\n\n if(temp.length>0 )\n{\n\n\n\n\ntemp=temp.substring(0,(temp.length-spe));\n\nif(temp.indexOf(\"#%#\")!=-1)\n{\ncounting=3;\n\n}\n\nvar somethingdata=temp.substring(0,counting);\n\n\nswitch(test(somethingdata))\n{\ncase 0:\nvar value11=temp.substring(counting);\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\n\nvar value1=value11+\"     =     \"+hashVal[hashte];\n\n}\n\nelementval[eventre]=value11;\neventre++;\nd.add(cou1,0,value1,\"javascript:selectLink()\");\n\nhash=cou1;\ncou1++;\nhashte++;\n\n}\nbreak;\ncase 1:\nvar value12=temp.substring((counting));\nif(value12==\"\")\n{\n\n\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"     =     \"+dolVal[dolte];\n\n}\nelementval[eventre]=value12;\neventre++;\nd.add(cou1,hash,value2,\"javascript:selectLink()\");\ndola=cou1;\ncou1++;\ndolte++;\n}\nbreak;\ncase 2:\n\ndola=getData(dola,hash,1);\nvar value13=temp.substring((counting));\n\n\nif(value13==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"     =     \"+PerVal[perte];\n\n}\nelementval[eventre]=value13;\neventre++; \nd.add(cou1,dola,value3,\"javascript:selectLink()\");\nd.oPnode(true,0);\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\ncounting=0;\n}\nbreak;\ncase 3:\n\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\n\n\nvar somevalue1=\"\";\n\n\nvar somevalue=temp.substring(counting);\nif(somevalue==\"\")\n{\n}\nelse\n{\nif(boxval[boxte]==null)\n{\nsomevalue1=somevalue;\n\n\n}\nelse\n{\nsomevalue1=somevalue+\"     =     \"+boxval[boxte];\n\n}\n\nelementval[eventre]=somevalue;\neventre++;\nd.add(cou1,perce,somevalue1,\"javascript:selectLink()\");\npipsom=cou1;\n//som=cou1;\nboxte++;\ncou1++;\n\n}\n\n\nbreak;\ncase 4:\n\nsom =getData(som,hash,1);\nsom=getData(som,dola,2);\nsom=getData(pipsom,perce,3);\nvar lessval1=\"\";\n\nvar lessval=temp.substring(1);\n\nif(lessval==\"\")\n{\n}\nelse\n{\nif(Lesstan[lesste]==null)\n{\nlessval1=lessval;\n}\nelse\n{\nlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\n\n}\nelementval[eventre]=lessval;\neventre++;\nd.add(cou1,som,lessval1,\"javascript:selectLink()\");\npipsom=som;\npip=cou1;\nlesste++;\ncou1++;\n\n}\n\nbreak;\ncase 5:\ncheckRemainingVal(caplength,capc,cou1,ll);\npip=getData(pip,hash,1);\npip=getData(pip,dola,2);\npip=getData(pip,perce,3);\npip=getData(pip,pipsom,4);\nvar valuePip1=temp.substring(1);\nif(valuePip1==\"\")\n{\n}\nelse\n{\nif(PiptVal[pipte]==null)\n{\nvar valuePip=valuePip1;\n}\nelse\n{\nvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\npipsing=pipsing+1;\ncountingpip[pipte]=new Array();\n\n}\nelementval[eventre]=valuePip1;\neventre++;\n//acchar1=0;\nacchar=0;\ncapc=0;\n\n//d.add(cou1,pip,valuePip,valuePip);\nd.add(cou1,pip,valuePip,\"javascript:selectLink()\");\n\npiplength=piptwoarray[pipsing].length;\n cap=cou1;\n cou1++;\n pipte++;\n\n//cate++;\n }\nbreak;\ncase 6:\n//checkFunCap();\ncheckRemainingVal(caplength,capc,cou1,ll);\ncheckIndexChar(storecap,storegenc);\ncap=getData(cap,hash,1);\ncap=getData(cap,dola,2);\ncap=getData(cap,perce,3);\ncap=getData(cap,som,4);\ncap=getData(cap,pip,5);\nvar valueCap1=temp.substring(1);\nvar comsixteen=\"\";\n\n\n\n//if(acchar<16)                                  remove  16 characters condition \n//{\nif(!piptwoarray[pipsing][acchar])\n{\ndeboo=false;\n}\nelse\n{\n\ncomsixteen=piptwoarray[pipsing][acchar];\ncapc++;\n}\nif(comsixteen==\"\" )\n{\ndeboo=false;\n}\nelse\n{\n\ndeboo=true;\n}\n//}                                             end   16 character loop \n\n\n\nif(comsixteen.indexOf(\'^\')!=-1)\n{\n\nvar capcheck=comsixteen.substring(comsixteen.length-1);\ncomsixteen=comsixteen.substring(0,comsixteen.length-1);\nif(capcheck.indexOf(\'^\')!=-1)\n{\n\n\nstorecap=\"^\";\nstoregenc=gendrcou;\n}\nelse if(capcheck.indexOf(\'^\')==-1)\n{\nstorecap=\"\";\n}\n}\n\n  \nelementval[eventre]=valueCap1;\n \n//alert(\" elementval : \"+elementval[eventre]+\" valueCap1 : \"+valueCap1+\" eventre :\"+eventre);\n\n\n\n//alert(document.forms[0].element.value);\ncountingpip[pipsing][gendrcou]=valueCap1+\" = \"+comsixteen;\nd.add(cou1,cap,countingpip[pipsing][gendrcou],\"javascript:selectLink()\");\ngendrcou++;\nacchar++;\neventre++;\ncaplength=0; \nll=cou1;\ncou1++;\nflag=0;   \n//}\nbreak;\ncase 7:\n\nvar compacap=\"\";\n//alert(capc);\nif(deboo==true)\n{\n//cate++;\nif(flag==0)\n{\nif(captwoarray[pipsing][capc] || captwoarray[pipsing][capc]==\'\')\n{\ncate++;\nif(cate<captwoarraysec.length)\n{\ncaplength=captwoarraysec[cate].length;\n}\nvar valueCap13=temp.substring(1);\n//alert(valueCap13);\n}\nelse if(captwoarray[pipsing][capc]==undefined )\n{\n}\nelse if(captwoarray[pipsing][capc]==null )\n{\n}\nelse\n{\n//cate++;\n//if(cate<captwoarraysec.length)\n//{\n\n//caplength=captwoarraysec[cate].length;\n//}\n///var valueCap13=temp.substring(1);\n//var check=captwoarray[pipsing][capc]=\"\"?\"empty\":captwoarray[pipsing][capc];\n\n\n}\n\n}\ncapcsec=0;\n}\nll=getData(ll,hash,1);\nll=getData(ll,dola,2);\nll=getData(ll,perce,3);\nll=getData(ll,som,4);\nll=getData(ll,pip,5);\nll=getData(ll,cap,6);\nvar valueCap12=temp.substring(1);\ncompacap=captwoarray[pipsing][capc];\nif(compacap==null)\n{\nvar capattanddet=valueCap12+\" = \";\n//countingpip[pipsing][gendrcou]=valueCap12+\" = \";\n}\nelse\n{\nvar capattanddet=valueCap12+\" = \"+compacap;\n//alert(capattanddet);\nremind=1;\n\ncaplength=caplength-remind;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n//countingpip[pipsing][gendrcou]=valueCap12+\" = \"+compacap;\ncapc++;\n}\nif(valueCap12==\'\')\n{\nelementval[eventre]=valueCap12;\neventre++; \n}\nelse\n{\nelementval[eventre]=valueCap12;\neventre++; \n}\nd.add(cou1,ll,capattanddet,\"\");\n\n\n\n/*if(cate<captwoarraysec.length)\n{\nif(!captwoarraysec[cate][capcsec])\n{\ncompacap=\"\";\n}\nelse\n{\ncompacap=captwoarraysec[cate][capcsec];\n}\n\n\nif(caplength>0)\n{\n//countingpip[pipsing][gendrcou]=valueCap12+\" = \"+compacap;\ncapcsec++;\n}\nelse\n{\ncountingpip[pipsing][gendrcou]=valueCap12+\" = \";\n}\ncaplength--;\n}\nelse\n{\ncountingpip[pipsing][gendrcou]=valueCap12+\" = \";\n}*/\n\nflag=1;\ndeboo=false;\ngendrcou++;\ncou1++;\n\nbreak;\n\n}\n}\n\n\ntemp=curval;\n\n}\nelse \n{\n\ttemp=temp+curval;\n\n\t\n}\n\n\n\n\n\n\n\n\n\n\n  }\n if(temp.length>0 )\n{\ntemp=temp.substring(0,(temp.length-spe));\n\nif(temp.indexOf(\"#%#\")!=-1)\n{\ncounting=3;\n}\n\n\nvar somethingdata=temp.substring(0,counting)\n\n\nswitch(test(somethingdata))\n /*curval= Messegesyntax.charAt(i);\nif(curval==\'+\')\n{\n\ncurval=\' \';\n}\n\n\nif(curval == Symbols[0] ||curval ==Symbols[1] ||curval == Symbols[2] || curval == Symbols[3] ||curval == Symbols[4] || curval == Symbols[5] || curval == Symbols[6] ||curval == Symbols[7] || curval == Symbols[8] ||curval == Symbols[9] ||curval == Symbols[10] || curval == \'*\')\n {\n if(temp.length>0)\n{\nswitch(test())*/\n{\ncase 0:\n\n\nvar value11=temp.substring(counting);\n\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\n\nvar value1=value11+\"     =     \"+hashVal[hashte];\nelementval[eventre]=value11;\neventre++;\n}\n\nd.add(cou1,0,value1,\"javascript:selectLink()\");\nhash=cou1;\ncou1++;\nhashte++;\n\n}\nbreak;\ncase 1:\n\nvar value12=temp.substring((counting));\n\n\n\nif(value12==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"     =     \"+dolVal[dolte];\nelementval[eventre]=value12;\neventre++;\n}\n}\n\nd.add(cou1,hash,value2,\"javascript:selectLink()\");\ndola=cou1;\ncou1++;\ndolte++;\n\nbreak;\ncase 2:\ndola=getData(dola,hash,1);\nvar value13=temp.substring((counting));\nif(value13==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"     =     \"+PerVal[perte];\nelementval[eventre]=value13;\neventre++;\n}\n\nd.add(cou1,dola,value3,\"javascript:selectLink()\");\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\ncounting=0;\n}\nbreak;\ncase 3:\n\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\n\nvar somevalue1=\"\";\n\n\nvar somevalue=temp.substring(counting);\nif(somevalue==\"\")\n{\n}\nelse\n{\nif(boxval[boxte]==null)\n{\nsomevalue1=somevalue;\n\n\n}\nelse\n{\nsomevalue1=somevalue+\"     =     \"+Lesstan[lesste];\nelementval[eventre]=somevalue;\neventre++;\n}\n\n\nd.add(cou1,perce,somevalue1,\"javascript:selectLink()\");\nsom=cou1;\nboxte++;\ncou1++;\n\n}\n\n\nbreak;\ncase 4:\n\nsom =getData(som,hash,1);\nsom=getData(som,dola,2);\nsom=getData(som,perce,3);\nvar lessval1=\"\";\nvar lessval=temp.substring(1);\n\nif(lessval==\"\")\n{\n}\nelse\n{\nif(Lesstan[lesste]==null)\n{\nlessval1=lessval;\n}\nelse\n{\nlessval1=lessval+\"     =     \"+Lesstan[lesste];\nelementval[eventre]=lessval;\neventre++;\n}\n\nd.add(cou1,som,lessval1,\"javascript:selectLink()\");\npip=cou1;\nlesste++;\ncou1++;\n\n}\n\nbreak;\ncase 5:\npip=getData(pip,hash,1);\npip=getData(pip,dola,2);\npip=getData(pip,perce,3);\npip=getData(pip,som,4);\n\n\nvar valuePip1=temp.substring(1);\n\n\n\nif(valuePip1==\"\")\n{\n}\nelse\n{\nif(PiptVal[pipte]==null)\n{\nvar valuePip=valuePip1;\n}\nelse\n{\nvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\nelementval[eventre]=valuePip1;\neventre++;\n\n}\n\nd.add(cou1,pip,valuePip,\"javascript:selectLink()\");\n\n cap=cou1;\n cou1++;\n pipte++;\n\n }\nbreak;\ncase 6:\ncap=getData(cap,hash,1);\ncap=getData(cap,dola,2);\ncap=getData(cap,perce,3);\ncap=getData(cap,som,4);\ncap=getData(cap,pip,5);\nvar valueCap1=temp.substring(1);\n\n\nif(valueCap1==\"\")\n{\n}\nelse\n{\nif(CapVal[capte]==null)\n{\nvar valueCap=valueCap1;\n}\nelse\n{\nvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\nelementval[eventre]=valueCap1;\neventre++;\n\n\n}\n\nd.add(cou1,cap,valueCap,\"javascript:selectLink()\");\nll=cou1;\ncou1++;\ncapte++;\n\n}\nbreak;\ncase 7:\nll=getData(ll,hash,1);\nll=getData(ll,dola,2);\nll=getData(ll,perce,3);\nll=getData(ll,som,4);\nll=getData(ll,pip,5);\nll=getData(ll,cap,6);\nvar valueCap12=temp.substring(1);\n\nif(CapVal1[capte1]==null)\n{\nvar valueCap3=valueCap12;\n}\nelse\n{\nvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\nelementval[eventre]=valueCap12;\neventre++;\n}\nd.add(cou1,ll,valueCap3,\"\");\ncou1++;\ncapte1++;\n\n\nbreak;\n\n}\n}\n\n\ndocument.write(d);\nd.nodeStatus(true,1,true);\nd.nodeStatus(true,2,true);\nd.nodeStatus(true,3,true);\n//d.openAll();\n}\n\nelse\n{\n\nvar temp1=\'\';\nk2=messegetext;\nfor(var i=0;i<k2.length;i++)\n{\n curval= (k2.charAt(i)).toString();\n\n if(curval==\'+\')\n{\n\n\ncurval=\'      \';\n}\n\n\n  if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == \'*\')\n {\n\n \n\n if(temp1.length>0 )\n{\nvar somethingdata=temp1.substring(0,1);\n\n\nswitch(test(somethingdata))\n{\n\ncase 0:\n\nbreak;\ncase 1:\n\nbreak;\ncase 2:\n\nbreak;\ncase 3:\nMessageHead=temp1.substring(1);\nif(MessageHead==\"\" || MessageHead==null)\n{\n}\nelse\n{\nboxval[box]=MessageHead;\n\nbox++;\n\n}\nbreak;\ncase 4:\nvar value3=temp1.substring(1);\n\n\nif (value3==null)\n{\nLesstan[less]=MessageHead;\nless++;\n}\nelse\n{\nLesstan[less]=value3;\n\nless++;\n}\nbreak;\ncase 5:\nPiptVal[Pipt]=temp1.substring(1);\n\nPipt++;\nbreak;\ncase 6:\nCapVal[Capt]=temp1.substring(1);\n\n\nCapt++;\nbreak;\ncase 7:\nCapVal1[Capt1]=temp1.substring(1);\n\nCapt1++;\nbreak;\n\n\n\n}\n}\ntemp1=curval;\n}\nelse \n  {\n\ttemp1=temp1+curval;\n  }\n}\n if(temp1.length>0)\n{\nswitch(test(somethingdata))\n{\n\ncase 0:\n\nbreak;\ncase 1:\n\nbreak; \ncase 2:\n\nbreak;\ncase 3:\n\nMessageHead=temp1.substring(1);\n\n\n\nif(MessageHead==\"\" || MessageHead==null)\n{\n}\t\t\t\t\t\t\t\t\t\t\t\t\t\t \nelse\n{\nboxval[box]=MessageHead;\nbox++;\n\n}\n\nbreak;\ncase 4:\n\nLesstan[less]=temp1.substring(1);\n\nless++;\nbreak;\ncase 5:\n\nif(temp1.substring(1)==\'*\')\n{\n}\nelse\n{\nPiptVal[Pipt]=temp1.substring(1);\n\nPipt++;\n}\nbreak;\ncase 6:\nCapVal[Capt]=temp1.substring(1);\nCapt++;\nbreak;\ncase 7:\nCapVal1[Capt1]=temp1.substring(1);\nCapt1++;\n\n}\n}\n\n\n/**************************populate Tree*************************////\n/**********************************Populate Tree*****************************/\nvar tswte=0;\nvar Atte=0;\nvar Excte=0;\nvar pipte=0;\nvar capte=0;\nvar cou1=1;\nvar Opente=0;\nvar Closete=0;\nvar Amperte=0\nvar hashte=0;\nvar dolte=0;\nvar perte=0;\nvar lesste=0;\nvar cap=0;\nd.add(0,-1,\'\');\nvar some1;\n\n\n\n\nfor(var i=0;i<Messegesyntax.length;i++)\n{\n curval=(Messegesyntax.charAt(i)).toString();\n curval1=(Messegesyntax.charAt(i)).toString();\nsome=(Messegesyntax.charAt(i)).toString()+((Messegesyntax.charAt(i+1)).toString())+((Messegesyntax.charAt(i+2)).toString());\n\n\n  if((Messegesyntax.charAt(i+2)).toString()==\"\" && (Messegesyntax.charAt(i+1)).toString()==\"\")\n  {\n some=some+\"lak,xm\"+\"lak,xm\";\n}\n\n\nif(compilesimples==i)\n{\ncurval=some1;\n\n}\n\nif(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )\n{\ncompilesimples=(i+2);\nsome1=some;\ncounting=3;\nspe=2;\n}\nelse if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])\n{\ncurval=curval1;\nspe=0;\ncounting=1;\n}\n          \nif(curval==\"+\")\n{\n\ncurval=\"  \";\n}\n/*if(compilesimples%3=0)\n{\n\n\n}*/\n\n//if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == Symbols[3] ||curval == Symbols[4] || curval == Symbols[5] || curval == Symbols[6] ||curval == Symbols[7] || curval == Symbols[8] ||curval == Symbols[9] ||curval == Symbols[10] ||  curval == \'*\')\n \n if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])\n \n {\n if(temp.length>0 )\n{\n\ntemp=temp.substring(0,(temp.length-spe));\nif(temp.indexOf(\"#%#\")!=-1)\n{\ncounting=3;\n\n\n}\n\n\nvar somethingdata=temp.substring(0,counting)\n\nswitch(test(somethingdata))\n {\ncase 0:\n\n\nvar value11=temp.substring(counting);\n\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\n\nvar value1=value11+\"     =     \"+hashVal[hashte];\n}\nelementval[eventre]=value11;\neventre++;\nd.add(cou1,0,value1,\"javascript:selectLink()\");\nhash=cou1;\ncou1++;\nhashte++;\n\n}\nbreak;\ncase 1:\n\ndola=getData(dola,hash,1);\n\nvar value12=temp.substring((counting));\n\n\n\nif(value12==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"     =     \"+dolVal[dolte];\n\n}\nelementval[eventre]=value12;\neventre++;\nd.add(cou1,hash,value2,\"javascript:selectLink()\");\ndola=cou1;\ncou1++;\ndolte++;\n}\n\n\nbreak;\ncase 2:\ndollor=getData(dollor,hash,1);\ndollor=getData(dollor,dola,2);\n\n\nvar value13=temp.substring((counting));\n\n\nif(value13==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"     =     \"+PerVal[perte];\n\n}\nelementval[eventre]=value13;\neventre++;\nd.add(cou1,dola,value3,\"javascript:selectLink()\");\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\ncounting=0;\n}\nbreak;\ncase 3:\n\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\nperce=getData(perce,dollor,3);\nvar somevalue1=\"\";\n\n\nvar somevalue=temp.substring(counting);\n\nif(somevalue==\"\")\n{\n}\nelse\n{\nif(boxval[boxte]==null)\n{\nsomevalue1=somevalue;\n}\nelse\n{\nsomevalue1=somevalue+\"     =     \"+boxval[boxte];\n\n}\n\nelementval[eventre]=somevalue;\neventre++;\nd.add(cou1,perce,somevalue1,\"javascript:selectLink()\");\nsom=cou1;\nboxte++;\ncou1++;\n\n}\n\n\nbreak;\ncase 4:\n\nsom =getData(som,hash,1);\nsom=getData(som,dola,2);\nsom=getData(som,dollor,3);\nsom=getData(som,perce,4);\nvar lessval1=\"\";\n\nvar lessval=temp.substring(counting);\n\nif(lessval==\"\")\n{\n}\nelse\n{\nif(Lesstan[lesste]==null)\n{\nlessval1=lessval;\n}\nelse\n{\nlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\n}\nelementval[eventre]=lessval;\neventre++;\nd.add(cou1,som,lessval1,\"javascript:selectLink()\");\npip=cou1;\nlesste++;\ncou1++;\n\n}\n\nbreak;\ncase 5:\npip=getData(pip,hash,1);\npip=getData(pip,dola,2);\npip=getData(pip,dollor,3);\npip=getData(pip,perce,4);\npip=getData(pip,som,5);\n\n\n\nvar valuePip1=temp.substring(1);\n\n\n\nif(valuePip1==\"\")\n{\n}\nelse\n{\nif(PiptVal[pipte]==null)\n{\nvar valuePip=valuePip1;\n}\nelse\n{\nvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n}\nelementval[eventre]=valuePip1;\neventre++;\nd.add(cou1,pip,valuePip,\"javascript:selectLink()\");\n\n cap=cou1;\n cou1++;\n pipte++;\n\n }\nbreak;\ncase 6:\ncap=getData(cap,hash,1);\ncap=getData(cap,dola,2);\ncap=getData(cap,dollor,3);\ncap=getData(cap,perce,4);\ncap=getData(cap,som,5);\ncap=getData(cap,pip,6);\nvar valueCap1=temp.substring(1);\n\n\nif(valueCap1==\"\")\n{\n}\nelse\n{\nif(CapVal[capte]==null)\n{\nvar valueCap=valueCap1;\n}\nelse\n{\nvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\n\n}\nelementval[eventre]=valueCap1;\neventre++;\nd.add(cou1,cap,valueCap,\"javascript:selectLink()\");\nll=cou1;\ncou1++;\ncapte++;\n\n}\nbreak;\ncase 7:\nll=getData(ll,hash,1);\nll=getData(ll,dola,2);\nll=getData(ll,dollor,3);\nll=getData(ll,perce,4);\nll=getData(ll,som,5);\nll=getData(ll,pip,6);\nll=getData(ll,cap,7);\nvar valueCap12=temp.substring(1);\nif(valueCap12==\"\")\n{\n}\nelse\n{\nif(CapVal1[capte1]==null)\n{\nvar valueCap3=valueCap12;\n}\nelse\n{\nvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\n\n}\nelementval[eventre]=valueCap12;\neventre++;\nd.add(cou1,ll,valueCap3,\"\");\ncou1++;\ncapte1++;\n\n}\nbreak;\n\n\n}\n}\n\n\ntemp=curval;\n\n}\nelse \n{\n\ttemp=temp+curval;\n\n\t\n}\n  }\n if(temp.length>0 )\n{\ntemp=temp.substring(0,(temp.length-spe));\nswitch(test(somethingdata))\n\n{\ncase 0:\n\n\nvar value11=temp.substring(counting);\n\nif(value11==\"\")\n{\n}\nelse\n{\nif(hashVal[hashte]==null)\n{\nvar value1=value11;\n}\nelse\n{\n\nvar value1=value11+\"     =     \"+hashVal[hashte];\n\n}\nelementval[eventre]=value11;\neventre++;\nd.add(cou1,0,value1,\"javascript:selectLink()\");\nhash=cou1;\ncou1++;\nhashte++;\n\n}\nbreak;\ncase 1:\n\ndola=getData(dola,hash,1);\n\nvar value12=temp.substring((counting));\n\n\n\nif(value12==\"\")\n{\n}\nelse\n{\nif(dolVal[dolte]==null)\n{\nvar value2=value12;\n}\nelse\n{\nvar value2=value12+\"     =     \"+dolVal[dolte];\n\n}\nelementval[eventre]=value12;\neventre++;\nd.add(cou1,hash,value2,\"javascript:selectLink()\");\ndola=cou1;\ncou1++;\ndolte++;\n}\n\n\nbreak;\ncase 2:\ndollor=getData(dollor,hash,1);\ndollor=getData(dollor,dola,2);\n\n\nvar value13=temp.substring((counting));\n\n\nif(value13==\"\")\n{\n}\nelse\n{\nif(PerVal[perte]==null)\n{\nvar value3=value13;\n}\nelse\n{\nvar value3=value13+\"     =     \"+PerVal[perte];\n\n}\nelementval[eventre]=value13;\neventre++;\nd.add(cou1,dola,value3,\"javascript:selectLink()\");\nperce=cou1;\nperce=cou1;\ncou1++;\nperte++;\ncounting=0;\n}\nbreak;\ncase 3:\n\nperce =getData(perce,hash,1);\nperce=getData(perce,dola,2);\nperce=getData(perce,dollor,3);\nvar somevalue1=\"\";\n\n\nvar somevalue=temp.substring(counting);\n\nif(somevalue==\"\")\n{\n}\nelse\n{\nif(boxval[boxte]==null)\n{\nsomevalue1=somevalue;\n\n\n}\nelse\n{\nsomevalue1=somevalue+\"     =     \"+Lesstan[lesste];\n\n}\n\nelementval[eventre]=somevalue;\neventre++;\nd.add(cou1,perce,somevalue1,\"javascript:selectLink()\");\nsom=cou1;\nboxte++;\ncou1++;\n\n}\n\n\nbreak;\ncase 4:\n\nsom =getData(som,hash,1);\nsom=getData(som,dola,2);\nsom=getData(som,dollor,3);\nsom=getData(som,perce,4);\nvar lessval1=\"\";\n\nvar lessval=temp.substring(counting);\n\nif(lessval==\"\")\n{\n}\nelse\n{\nif(Lesstan[lesste]==null)\n{\nlessval1=lessval;\n}\nelse\n{\nlessval1=lessval+\"     =     \"+Lesstan[lesste];\n\n}\nelementval[eventre]=lessval;\neventre++;\nd.add(cou1,som,lessval1,\"javascript:selectLink()\");\npip=cou1;\nlesste++;\ncou1++;\n\n}\n\nbreak;\ncase 5:\npip=getData(pip,hash,1);\npip=getData(pip,dola,2);\npip=getData(pip,dollor,3);\npip=getData(pip,perce,4);\npip=getData(pip,som,5);\n\n\n\nvar valuePip1=temp.substring(1);\n\n\n\nif(valuePip1==\"\")\n{\n}\nelse\n{\nif(PiptVal[pipte]==null)\n{\nvar valuePip=valuePip1;\n}\nelse\n{\nvar valuePip=valuePip1+\"     =     \"+PiptVal[pipte];\n\n}\nelementval[eventre]=valuePip1;\neventre++;\nd.add(cou1,pip,valuePip,\"javascript:selectLink()\");\n\n cap=cou1;\n cou1++;\n pipte++;\n\n }\nbreak;\ncase 6:\ncap=getData(cap,hash,1);\ncap=getData(cap,dola,2);\ncap=getData(cap,dollor,3);\ncap=getData(cap,perce,4);\ncap=getData(cap,som,5);\ncap=getData(cap,pip,6);\nvar valueCap1=temp.substring(1);\n\n\nif(valueCap1==\"\")\n{\n}\nelse\n{\nif(CapVal[capte]==null)\n{\nvar valueCap=valueCap1;\n}\nelse\n{\nvar valueCap=valueCap1+\"     =     \"+CapVal[capte];\n\n}\nelementval[eventre]=valueCap1;\neventre++;\n\nd.add(cou1,cap,valueCap,\"javascript:selectLink()\");\nll=cou1;\ncou1++;\ncapte++;\n\n}\nbreak;\ncase 7:\nll=getData(ll,hash,1);\nll=getData(ll,dola,2);\nll=getData(ll,dollor,3);\nll=getData(ll,perce,4);\nll=getData(ll,som,5);\nll=getData(ll,pip,6);\nll=getData(ll,cap,7);\nvar valueCap12=temp.substring(1);\nif(valueCap12==\"\")\n{\n}\nelse\n{\nif(CapVal1[capte1]==null)\n{\nvar valueCap3=valueCap12;\n}\nelse\n{\nvar valueCap3=valueCap12+\"     =     \"+CapVal1[capte1];\n\n\n}\nelementval[eventre]=valueCap12;\neventre++;\nd.add(cou1,ll,valueCap3,\"\");\ncou1++;\ncapte1++;\n\n}\nbreak;\n\n\n}\n}\n\n \ndocument.write(d);\nd.nodeStatus(true,1,true);\nd.nodeStatus(true,2,true);\nd.nodeStatus(true,3,true);\n//d.openAll();\n\n}\n\nfunction  getData(val1,val2)\n {\n if(val1 < val2)   val1 =val2; \n   return val1;\t\n }\nfunction  test(val1)\n{\nvar align=0;\n\n\nfor(var spk=0;spk<SplitinElements.length;spk++)\n{\nif(val1==intSymbols[spk])\n{\n\nalign=(spk);\n\n\n}\n\n}\n\n\nreturn align;\n}\nfunction  compare(val1)\n {\n\nvar val2;\n\n\n\n\nif(val1==Symbols[0]  || val1==Symbols[1] || val1==Symbols[2] || val1==Symbols[3] || val1==Symbols[4] || val1==Symbols[5] || val1==Symbols[6] || val1==Symbols[7] || val1==Symbols[8] || val1==Symbols[9] || val1==Symbols[10] || val1==Symbols[11] || val1==Symbols[11]  )\n{\n\nval2=val1;\n}\nelse\n{\n\nfor(var intds=0;intds<intSymbols.length;intds++)\n{\n\nif(val1==intSymbols[intds])\n{\n\nval2=intSymbols[intds];\n}\n\n}\n}\nreturn val2;\t\n\n}\n  function  test2(firstar,secondar)\n{\n\n\tif(!captwoarray[firstar][secondar])\n\t{\n\t\talign=6; \n\t\tMainboolean==true;\t\t\t\t\t\t\t   \n\t}\n\telse\n\t{\n\t\tMainboolean=false;\n\t\talign=7;\n\t}\n\treturn align;\n}\nfunction  test1(val1,current,next,firstar,secondar)\n{\nvar align=0;\nvar pipsym=\'|\';\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \nvar capsym=\'^\';\nif(val1==pipsym)\n{\n\tif(next==capsym)\n\t{\n      if(!captwoarray[firstar][secondar])\n\t\t{\n\t\t\t align=6;\n             Mainboolean=true;\n\t\t}\n\n\t}\n}\n\n\n}\n/*\nfunction  test1(val1,current,next,firstar,secondar)\n{\n\nvar align=0;\nvar pipsym=\'|\';\nvar capsym=\'^\';\nif(val1==pipsym)\n{\n\tif(next==pipsym)\n\t{\n\t        for(var spk=0;spk<SplitinElements.length;spk++)\n\t\t\t{\n\t\t\t\tif(val1==intSymbols[spk])\n\t\t\t\t{\n                   \n\t\t\t\t\talign=(spk);\n\t\t\t\t\tMainboolean=true;\n\t\t\t\t}\n\n\t\t\t}\n\t\t/*if(!captwoarray[(firstar+1)][secondar])\n\t\t{\n\t\t\tfor(var spk=0;spk<SplitinElements.length;spk++)\n\t\t\t{\n\t\t\t\tif(val1==intSymbols[spk])\n\t\t\t\t{\n                   \n\t\t\t\t\talign=(spk);\n\t\t\t\t\tMainboolean=true;\n\t\t\t\t}\n\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\talert(firstar+\" secondar : \"+secondar+\" \" +captwoarray[(firstar+1)][secondar]);\n\t\t alert(\"condi 1: 2\")\n\t\t\talign=7;\n\t\t\tdeboo=true;\n            Mainboolean=false;\n\t\t//}\n\n\t}\n    else if(next==capsym)\n    {\n\talert(\"condi 1: 3\");\n        align=7;\n\t\tMainboolean=true;\n\t}\n\telse\n\t{\n\t    for(var spk=0;spk<SplitinElements.length;spk++)\n\t\t\t{\n\t\t\t\tif(val1==intSymbols[spk])\n\t\t\t\t{\n\n\t\t\t\t\talign=(spk);\n                    Mainboolean=true;\n\t\t\t\t}\n\n\t\t\t}\n\t}\n\n}\nelse if(val1==capsym)\n{\n   if(next==pipsym)\n\t{\n       if(!captwoarray[firstar][secondar])\n\t\t{\n\t\t\talign=6;\n             Mainboolean=true;\n\t\t}\n\t\telse\n\t\t{\n            align=7;\n\t\t\t  Mainboolean=false;\n\t\t}\n\t \n\t}\n\telse if(next==capsym)\n\t{\n            align=7;\n\t\t\tMainboolean=true;\n\t}\n    else\n\t{\n\t    for(var spk=0;spk<SplitinElements.length;spk++)\n\t\t\t{\n\t\t\t\tif(val1==intSymbols[spk])\n\t\t\t\t{\n\n\t\t\t\t\talign=(spk);\n\t\t\t\t\tMainboolean=true;\n\t\t\t\t}\n\n\t\t\t}\n\t}\n\n\n}\n\nelse\n{\nfor(var spk=0;spk<SplitinElements.length;spk++)\n{\nif(val1==intSymbols[spk])\n{\n\nalign=(spk);\nMainboolean=true;\n\n}\n\n}\n}\nalert(\"Mainboolean \"+Mainboolean);\nalert(\"align :\"+align);\nreturn align;\n}\n*/\n\n\n \n\n function Trim(str)\n{ \nwhile(str.charAt(0) == (\" \") )\n  {  str = str.substring(1);\n  }\n  while(str.charAt(str.length-1) == \" \" )\n  {  str = str.substring(0,str.length-1);\n\n  }\n  return str;\n}\n\n\nfunction checkFunCap()\n{\n\nwhile(caplength>0)\n{\n\n\ncountingpip[pipsing][gendrcou]=\" \"+\"  =  \"+captwoarraysec[cate][capcsec];\nd.add(cou1,storecate,countingpip[pipsing][gendrcou],\"javascript:selectLink()\");\ncapc++;\ncapcsec++;\ncou1++;\ngendrcou++;\ncaplength--;\n\n}\n\n}\nfunction checkRemainingVal(rem,capc1,cou1,ll)\n{\nvar bool=false;\n\nwhile(rem>0)\n{\n\n\tvar check=captwoarraysec[cate][capcsec];\nelementval[eventre]=\"\";\neventre++;\n   d.add((cou1-1),ll,\" \"+\" = \"+captwoarray[pipsing][capc1],\"\");\n\tcountingpip[pipsing][gendrcou]=\" \"+\"  =  \"+captwoarray[pipsing][capc];\nbool=true;\ngendrcou++;\ncapcsec++;\ncapc1++;\ncou1++;\n\nrem--;\n}\n\n\nif(bool==true)\n{\n//alert(\"inga\");\n//alert(\"capc \"+capc);\ncapc=capc1;\n//cate++;\n//capcsec=0;\n\n}\t\t\t\t\t\t\t\t\t\t\t \n//cate++;\n}\n\nasync function selectLink()\n{ \n \tvar url=\'../../eXH/jsp/ViewElementTreeText.jsp?&standard_code=\'+document.forms[0].Standard_code.value+\'&event=\'+elementval[(d.selectedNode-1)];\n\t   var arguments  =new Array();\nvar dialogTop   = \"350\";\nvar dialogHeight= \"27\" ;\nvar dialogWidth = \"250\" ;\t\nvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\t\n\tawait window.showModalDialog(url,arguments,features);\n\n\t//parent.parent.frames[2].location.href=str\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n}  \nfunction checkIndexChar(sym,gen)\n{\n\n \n\tif(sym==\'^\')\n\t{\n\n\t\tif(gen==(gendrcou-1))\n\t\t{ \n        capcsec=0;\n        cate=cate+1;\n\t\n\t\tvar leng=captwoarraysec[cate].length;\n\t\n       while(leng>0)\n\t\t{\n  \n\t\t //d.add(cou1,ll,countingpip[pipsing][gendrcou],valueCap); \n\t\tcountingpip[pipsing][gendrcou]=\" \"+\"  =  \"+captwoarraysec[cate][capcsec];\n\t    d.add(cou1,ll,countingpip[pipsing][gendrcou],\"\"); \n\t\tgendrcou++;\n\t\tcapcsec++;\n        capc++;\n\t\tleng--;\n\t\tcou1++;\n\t\telementval[eventre]=\"\";\n\t\teventre++;\n\t\t}\n\t\n\t\t}\n\t\t\n\t}\n}\n}\ncatch(e)\n{\n\t  \n\n/*parent.frames[0].document.location.href=\"../../eXH/jsp/ViewTree.jsp?applicationID=\"+document.forms[0].applicationId.value+\"&facilityID=\"+document.forms[0].facilityId.value+\"&purge_status=\"+document.forms[0].purge_status.value+\"&msgID=\"+document.forms[0].Msg_Id.value+\"&even_type=\"+document.forms[0].even_type.value+\"&protocol_link_id=\"+document.forms[0].ProtocolID.value+\"&sub_module=\"+document.forms[0].sub_module.value+\"&applicationName=\"+document.forms[0].applicationName.value+\"&facilityName=\"+document.forms[0].facilityName.value+\"&srlNo=\"+document.forms[0].srlNo.value+\"&event_name=\"+document.forms[0].event_name.value+\"&protocolMode=\"+document.forms[0].protocolMode.value+\"&rule=J&rule2=H&img=\"+document.forms[0].img.value;\t */\n\nif(e instanceof RangeError)\n{\n\n\n\tif(document.forms[0].rule.value==\'R\')\n\t{\n\n\t\tif(emptyflag==false)\n\t{\n\t\tvar message=getMessage(\'XH0076\',\'XH\');\n\t\tmessage=message.replace(\'$\',\'\');\n\t   alert(message);\n\t}\n\telse\n\t{\n\t}\n\t}\n\telse \n\t{\n\t}\n} \nelse\n{ \n\tif(emptyflag==false)\n\t{\n\t\tvar message=getMessage(\'XH0076\',\'XH\');\n\t\tmessage=message.replace(\'$\',\'\');\n\t\talert(message);\n\t}\n\telse\n\t{\n\n\t}\n}\n \n}\n\n\n\n</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</td>\n</tr>\n</table>\n</div>\n</form>\n\n</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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

System.out.println("XHViewMessageSimulateDisplay.jsp 7:");
request.setCharacterEncoding("UTF-8"); 
Properties p = (Properties) session.getValue("jdbc"); 

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
  
	Connection connection = null;
	CallableStatement  oraclecallablestatement = null;
	boolean authToElement = false;
	try
	{
	if(connection == null) connection = ConnectionManager.getConnection();
	String rule=request.getParameter("rule");
	String rule2=request.getParameter("rule2");
	String img = XHDBAdapter.checkNull(request.getParameter("img"));
		


            _bw.write(_wl_block9Bytes, _wl_block9);
		
	 String Msg_syntax="";
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
	String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
	String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
    applicationId = XHDBAdapter.checkNull(request.getParameter("applicationID")); 
    facilityId = XHDBAdapter.checkNull(request.getParameter("facilityID"));
    msgId = XHDBAdapter.checkNull(request.getParameter("msgID"));				     
    ProtocolID = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
	String Msg_text=java.net.URLDecoder.decode(XHDBAdapter.checkNull(request.getParameter("Msg_text")));	     
	System.out.println("applicationName :"+applicationName+"facilityName :"+facilityName+"protocol_mode :"+protocol_mode+"sub_module :"+sub_module+"srlNo :"+srlNo+"applicationId :"+applicationId+"facilityId :"
	+facilityId+"msgId :"+msgId+"ProtocolID :"+ProtocolID+"Msg_text :"+Msg_text);
	
														     
	if(protocol_mode.equals("Inbound")) 														 
	{
		protocol_mode="I";  									 
	} 																   
	else if(protocol_mode.equals("Outbound"))
	{
	protocol_mode="O";
	}
    eventType = request.getParameter("even_type");										 
	String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
    event_name=XHDBAdapter.checkNull(request.getParameter("event_name"));
	try
	{
		oraclecallablestatement =  connection.prepareCall("{ call xhgeneric.standard_message_viewer(?,?,?,?,?,?,?,?,?,?,?) }" ); 
		oraclecallablestatement.setString(1,applicationId);

		System.out.println("applicationId :"+applicationId);

		oraclecallablestatement.setString(2,facilityId);
		System.out.println("facilityId :"+facilityId);
		oraclecallablestatement.setString(3,msgId);
		System.out.println("msgId :"+msgId);
		oraclecallablestatement.setString(4,ProtocolID);	
		System.out.println("ProtocolID :"+ProtocolID);
		oraclecallablestatement.setString(5,eventType);
		System.out.println("eventType :"+eventType);			  
		CLOB clob = CLOB.createTemporary(connection, true, CLOB.DURATION_SESSION);						 
		java.io.Writer out1 = clob.getCharacterOutputStream();							    
		out1.write(Msg_text);		 
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

		System.out.println("Message_syntax 131 :"+Message_syntax);
		Standard_symbols = oraclecallablestatement.getString(10).trim();

		System.out.println("Standard_symbols :"+Standard_symbols);

		errorMsg = oraclecallablestatement.getString(11);	
		
			System.out.println("errorMsg :"+errorMsg);
		if(Standard_symbols.indexOf("{64")!=-1)
		{
			Message_syntax=Message_syntax.replaceFirst("@","[");
			MsgText=MsgText.replaceFirst("@","[");
			Standard_symbols=Standard_symbols.replaceFirst("64","91");
		}
		System.out.println("errorMsg 2:");
		Msg_syntax =java.net.URLEncoder.encode(Message_syntax);
		Msg_text = java.net.URLEncoder.encode(MsgText);
			//java.net.URLEncoder.encode(MsgText);
		System.out.println("errorMsg 4:");
	//	System.out.println("XHViewMessageSimulateDisplay Msg_syntax 136:"+Msg_syntax);
		//System.out.println("XHViewMessageSimulateDisplay Msg_text 136:"+Msg_text);
		if(oraclecallablestatement!=null) 
		oraclecallablestatement.close();
	}
	catch(Exception exp)
    {
       																			  
	   exp.printStackTrace(System.err);
	   System.out.println("(ViewTree:StandardMessageViewer)Exception: "+exp);
    }


	//catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewSegments :"+ex.toString());
	//	   ex.printStackTrace(System.err); }
	    

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Standard_symbols));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Msg_text));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Msg_syntax));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rule));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Standard_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Standard_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rule2));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(applicationId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(msgId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(eventType));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ProtocolID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(applicationName));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(protocol_mode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(srlNo));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(event_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(img));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
}
	catch(Exception e)
	{
		System.out.println("Error in calling getconnection method of ViewTree.JSP Exception:"+e);
	}

	 finally{
		ConnectionManager.returnConnection(connection);
		//	if(stmt!=null)stmt.close();
	}
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
