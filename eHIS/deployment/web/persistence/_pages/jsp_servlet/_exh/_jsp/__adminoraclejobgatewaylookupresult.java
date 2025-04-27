package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.lang.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import eXH.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __adminoraclejobgatewaylookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/AdminoraclejobGatewayLookupResult.jsp", 1731859039983L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n   ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\t\t\t    \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\t\t\t\t\t \n\n<html>\n\t<head>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' \ntype=\'text/css\' ></link>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\t\t\t     \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nvar arvalues=new Array();\t\t   \nvar y=0;\nfunction enableCheck(obj,listvalue,cou)\n{\n\tif(obj.checked)\n\t{\n\t  obj.value=\"Y\";\n\n\n\t  \tdocument.forms[0].action_type.value =\"R\";\n\t\tvar act = \'../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp\';      \n\t\tthis.document.forms[0].action = act;\n\t\tthis.document.forms[0].target=\'refusal_resultframe_list\';\t     \n\t\tthis.document.forms[0].submit(); \n\t//  parent.refusal_resultframe_list.document.location.href=\"../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp\";\n\t /* \tvar boo=false;\n\t    if(arvalues.length>0)\n\t\t{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t  \n\t\t    for(var k=0;k<arvalues.length;k++)\n\t\t\t{\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t    \n\t\t\t\tif(arvalues[k]==listvalue)\n\t\t\t\t{\n\n\t\t\t\t boo=true;\n\t\t\t\t}\n\t\t\t\t else\n\t\t\t\t{\n\t\t\t\t\t boo=false;\n\t\t\t\t}\n\n\t\t}\n\t\t\t\n\n\t\t}\n\t\t else\n\t\t\t{\n\t\t\t boo=false;\n\t\t\t}\n\n\t\t\tif(!boo)\n\t\t\t{\n\t\t\tvar additem=arvalues.splice(cou,0,listvalue);\n\t\t\t  y++;\n\t\t\t}\n\n\n\t\t  \n\t  parent.frames[0].document.forms[0].search_optiontext.value=document.forms[0].search_option.value+arvalues;  */\n\t // document.forms[0].search_option.value= parent.frames[0].document.forms[0].search_optiontext.value;\n\t}\n\telse\n\t{\n\t   obj.value=\"N\";\n\t\tdocument.forms[0].action_type.value =\"R\";\n\t\tvar act = \'../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp\';      \n\t\tthis.document.forms[0].action = act;\n\t\tthis.document.forms[0].target=\'refusal_resultframe_list\';\t     \n\t\tthis.document.forms[0].submit();  //parent.refusal_resultframe_list.document.location.href=\"../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp\";\n\t\t/* if(arvalues.length>0)\n\t\t{\n\t      var valuecom=arvalues.splice(cou,1);\n\t\t  y--;\n\t\t}\n\t\t\n\t\t  parent.frames[0].document.forms[0].search_optiontext.value=document.forms[0].search_option.value+arvalues;\n\t\t  alert(parent.frames[0].document.forms[0].search_optiontext.value);   \t*/\n\n\t}\n\t\n}  \nfunction selectAllCheck(obj,cou)\n{\n\tvar Arrayval=new Array();\n\tif(obj.checked)\t\t\t\t\t\t\t\t\t\t    \n\t{\n\t   //obj.value=\"Y\";\n\n\t\tobj.checked=true;\n\t   \tfor(var u=0;u<parseInt(document.forms[0].count.value);u++)\n\t  \t{\n\t\t\tdocument.getElementById(u+\"_check\").value=\"Y\";\n\t\t\tdocument.getElementById(u+\"_check\").checked=true;\n\t  \t}\t  \n\n\t  \n\t\tdocument.forms[0].selectYN.value=\"Y\";\n\t}\t\t\t\t\t\t \n\telse\t\t\t\t\t\t\t\t\t\t    \t\t \n\t{\n\t    obj.value=\"N\";\n\t\tobj.checked=false;\n\t  \n\t\tfor(var u=0;u<parseInt(document.forms[0].count.value);u++)\n\t  \t{\n\t\t\tdocument.getElementById(u+\"_check\").value=\"N\";\n\t\t\tdocument.getElementById(u+\"_check\").checked=false;\n\t  \t}\t  \n\t\t\n\t  \tdocument.forms[0].selectYN.value=\"N\";   \t  \n\t}\n\n//\t parent.frames[0].document.forms[0].search_optiontext.value=document.forms[0].search_option.value+Arrayval;\t\t \n\n/*\tdocument.forms[0].rule.value =\"N\";\t\t  \t  \n\tdocument.forms[0].action_type.value =\"R\";\n\tvar act = \'../../eXH/jsp/AdminoraclejobGatewayLookupResult.jsp\';      \n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\'\';\t     \n\tthis.document.forms[0].submit(); \t */\n\t\n\tdocument.forms[0].action_type.value =\"R\";\n\tvar act = \'../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp\';      \n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\'refusal_resultframe_list\';\t     \n\tthis.document.forms[0].submit(); \n}\n/*function funSubmit()\n{\n\tvar act = \'../../eXH/jsp/AdminoraclejobGatewayLookupResult.jsp?\';\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].submit();\n}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \nfunction funAction(typ)\n{\n\tdocument.forms[0].action_type.value = typ;\t\t\t   \n\tthis.document.forms[0].target=\'\'\n\tfunSubmit();\t     \n}\t\t\t*/\n\nfunction funAction(type)\n{\n\n  if(type==\"N\")\n {\n   document.forms[0].pageCount.value=parseInt(document.forms[0].pageCount.value)+1;\n }\n else\n{\n  document.forms[0].pageCount.value=parseInt(document.forms[0].pageCount.value)-1;\n}\n\n\tfunSubmit(type);  \n}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\n//***********************************************************************************************\nfunction funSubmit(type)\n{\n\t document.forms[0].action_type.value = type; \n\t var page=document.forms[0].pageCount.value;\t\t  \n\t/*\t   if(document.forms[0].selectAll.checked)\t\t\t    \n\t{\n\t   document.forms[0].selectAll.value=\"Y\";\n\t   document.forms[0].selectYN.value=\"Y\";\t\t\t\t\t\t\t\t \n\t   \n\t  //document.getElementById(page+\"selectYN\").value=\"Y\";\n\n\t}\t\t\t\t\t\t \t\t\t\t \t\t  \t\t\t\t   \n\telse\t\t\t\t\t\t\t\t\t\t   \n\t{\n\t    document.forms[0].selectAll.value=\"N\";\n\t\tdocument.forms[0].selectYN.value=\"N\";\t\n\t\t// document.getElementById(page+\"selectYN\").value=\"N\";\n\t}\t \t\t*/\n\n\n\t\t \n\t document.forms[0].rule.value =\"Y\";\t  \n\tvar act = \'../../eXH/jsp/AdminoraclejobGatewayLookupResult.jsp\';\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].target=\'\';\t    \n\tthis.document.forms[0].submit();\t  \n}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\nvar gtwyList = new Array();\n\nfunction getDescription(obj,cnt,val)\n{\n\tif(document.getElementById(cnt+\"_enable\").checked)\t\t\t   \n\t{\n//\t\talert(\"Checked\");\n\t\tdocument.getElementById(cnt+\"_enable\").value=\"Y\";\t\n\n\t\tgtwyList[cnt] = val;\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(cnt+\"_enable\").value=\"N\";\n//\t\talert(\"UnChecked\");\n\t\tgtwyList[cnt] = \"\";\t     \n\n\n\t}\n\n//\tfunAction(\"R\");\n}\n\nfunction funok() \n{\n//\tvar gatwayList = gtwyList;\n\tvar str=parent.frames[0].document.getElementById(\"search_optiontext\").value;\n\ttoCloseTopShowModal(str)\n\tif(str!=null || str!=\'\'||str!=\'undefined\'||str!=undefined)\n\t{\n\tstr=str.substring(0,(str.length));\n\t//window.returnValue=str;\n\ttoCloseTopShowModal(str)\n\t}\t\n//\talert(\"gtwyList : \"+gtwyList);\n\t//window.close();\n}\nfunction formLoad()\n{\n\t\n   /*if(parent.frames[0].document.forms[0].search_optiontext.value==null||parent.frames[0].document.forms[0].search_optiontext.value==\'\')\n\t{\n\t  document.forms[0].search_option.value=\'\'; \n\t}\n\telse\n\t{\t\n\t\tdocument.forms[0].search_option.value=parent.frames[0].document.forms[0].search_optiontext.value+\",\";\n\t} */\n\n\n\n}\n</script>\n\t</head>\n\t<body onload=\"formLoad()\" >\n\t<form name=\"MedicationListResult\" id=\"MedicationListResult\" action=\"../../eCommon/jsp/report_options.jsp\"  target=\"messageFrame\" >\t\n\t<input type=hidden name=\"pageCount\" id=\"pageCount\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\t   \n\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"reprint_rep\">\n<tr>\n\t<td colspan=\"8\" align=\"right\"  > \n\t<A class=\'label\'  style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A>\n\t</td>\n\t</tr>\n \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\t\t  \n<script>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\n</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<tr>\n<th> ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </th>\t\t   \t\t\t    \n<th> ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </th>\n<th> ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n<input type=\"checkbox\"  name=\"selectAll\" id=\"selectAll\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"    onClick=\"selectAllCheck(this,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" ></th>   \n</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t     \n\t<tr>\t\n\t\n<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" style=\"font-size=9\" nowrap>&nbsp";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n<input type=hidden id=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" style=\"font-size=9\" nowrap>&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>   \t     \t   \n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" style=\"font-size=9\" nowrap><input type=\"checkbox\"  name=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' value=\"Y\"   onClick=\"enableCheck(this,\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\" checked>  </td>   \t\t  \n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<td class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" style=\"font-size=9\" nowrap>\n\t\t<input type=\"checkbox\"  name=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"   onClick=\"enableCheck(this,\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="  >   \n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n</tr>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t  \n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\n\t\n\t<input type=hidden name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"  >\t\n\t<input type=hidden name=\"selectYN\" id=\"selectYN\"  >\t\t\t\t\t\t\t\t\t  \n\t<input type=hidden name=\"rule\" id=\"rule\"> \n\t<input type=hidden name=\"search_option\" id=\"search_option\" value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' > \n\t<input type=hidden name=\"GatewayList\" id=\"GatewayList\" id=\"GatewayList\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t<input type=hidden name=\"action_type\" id=\"action_type\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"> \t \n\t</table>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t<table border=\'0\' width=\'100%\'>\n\t <tr><td  align=\'right\'><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' width=\'25%\' onclick=\'funok()\'></td></tr>\n\t </table>\n\n</table>\n\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t    \n\t \n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");
																		   
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
 String pageCount=request.getParameter("pageCount")!=null?request.getParameter("pageCount"):"0";


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pageCount));
            _bw.write(_wl_block11Bytes, _wl_block11);

		int i = 0;
//int count=0;														 		   
//boolean boolToggle =  true;						   
//String strTDClass = ""; 
String strBeanName = XHGatewayListControllerBean.strBeanName; 
Connection conn = null;
ArrayList arrRow = null;
ArrayList arrCol = null;
HashMap resultsQry=null;							 	  
String strPrevious = "";  
String strNext  = "";													 
String classvalue="";
//Statement stmt=null;
//ResultSet rs=null;	
String action_type=request.getParameter("action_type")!=null?request.getParameter("action_type"):"";   
String search_option=request.getParameter("search_option")!=null?request.getParameter("search_option"):"";
String selectAll=""; 
//java.util.Date date_time	 	= new java.util.Date();
//String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	   
LinkedList fullList=null;	 
try
{  


	String commode= XHDBAdapter.checkNull(request.getParameter("commmode"));
	String search_by=request.getParameter("search_by");
	if(search_by==null || search_by=="null") search_by = "C";
 	String description_code=(request.getParameter("description_code")==null||request.getParameter("description_code").equals("null"))?"":request.getParameter("description_code");
	String long_desc=request.getParameter("search_text");  
	if(long_desc==null || long_desc=="null") long_desc = "";

	String option_list=request.getParameter("search_optiontext");
	if(option_list==null || option_list=="null") option_list = "";
	String interfc_mod_id = XHDBAdapter.checkNull(request.getParameter("interfc_mod_id"));
	String gateway_id="";
	String whereCaluse=""; 
	String ResultQry="";
	if(long_desc.equals(""))										   
	{
		 if(option_list.equals(""))	  
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
			   ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";
		}
		else
		{

			if(option_list.indexOf(",")!=-1)
			{										   
			

			 String[] splitstr=option_list.split(",");

		
			String addComma="";
			for(int l=0;l<splitstr.length;l++)
		  {
			if(l==(splitstr.length-1))
			{
			addComma=new String("'"+splitstr[l]+"'");		 
			}
			else
			{
			addComma=new String("'"+splitstr[l]+"',");
			}

			gateway_id=gateway_id+addComma;
			}
			whereCaluse=whereCaluse+"AND PROTOCOL_LINK_ID in ("+gateway_id+") UNION SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) and PROTOCOL_LINK_ID not in ("+gateway_id+") ";	

			 ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'Y'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";

																										    
		}
			else
			{
				gateway_id=option_list;
			  whereCaluse=whereCaluse+"AND PROTOCOL_LINK_ID in ('"+gateway_id+"') UNION SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) and PROTOCOL_LINK_ID not in ('"+gateway_id+"') ";	

			 ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'Y'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";    
			}

		}

	}
	 else
	{
		 if(search_by.equals("C"))									   			  
		{
		if(description_code.equals("S"))
		{
			whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}  
	   else if(description_code.equals("E"))			 
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%"+long_desc+"') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}
		else
		{
		 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}
	 }
	 else
	 {																													    
	   if(description_code.equals("S"))
		{
			whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('"+long_desc+"%') ";																					  
		} 
	   else if(description_code.equals("E"))
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%"+long_desc+"') ";
		}
		else
		{
		 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%"+long_desc+"%') ";
		}
	 }
	  ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";

	}

		 


/*if(long_desc.indexOf(",")!=-1)
{
	String[] splitstr=long_desc.split(",");
	String addComma="";
	for(int l=0;i<splitstr.length;l++)
	{
		if(l==(splitstr.length-1))
		{
		addComma=new String("'"+splitstr[l]+"'");
		}
		else
		{
		addComma=new String("'"+splitstr[l]+"',");
		}

	gateway_id=gateway_id+addComma;
    }
    whereCaluse=whereCaluse+"AND PROTOCOL_LINK_ID in ("+gateway_id+") UNION SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) and PROTOCOL_LINK_ID not in ("+gateway_id+") ";		    
}
else
{

	if(search_by.equals("C"))									   
	{
		if(description_code.equals("S"))
		{
			whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}  
	   else if(description_code.equals("E"))			 
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%"+long_desc+"') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}
		else
		{
		 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}
	 }
	 else
	 {																													    
	   if(description_code.equals("S"))
		{
			whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('"+long_desc+"%') ";
		} 
	   else if(description_code.equals("E"))
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%"+long_desc+"') ";
		}
		else
		{
		 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%"+long_desc+"%') ";
		}
	 }
}	  */
	 String rule=request.getParameter("rule")!=null?request.getParameter("rule"):"N";
			 																				  
		if(rule.equals("N"))
	{
		selectAll=request.getParameter("selectYN")!=null?request.getParameter("selectYN"):"";
	}
														 						 			   
	 request.setAttribute("commode",commode);	 
	 request.setAttribute("interfce_module_id",interfc_mod_id);
		request.setAttribute("Query",ResultQry);
	 request.setAttribute("selectAll",selectAll);					 
	 request.setAttribute("action_attr","");				  
	 conn = ConnectionManager.getConnection(request);			  
	 XHGatewayListControllerBean	xhBean = XHGatewayListControllerBean.getBean(strBeanName,request,session);
	 xhBean.action(request,conn);					    
	 resultsQry = xhBean.getResultSet(); 	
	 arrRow = (ArrayList)resultsQry.get("qry_result"); 
	  fullList=(LinkedList)resultsQry.get("listA");
	 boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 										 
	 boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 	
	
	 if(rule.equals("Y"))
	{
	 selectAll=((String)resultsQry.get("selectAll")).equals("")?"":((String)resultsQry.get("selectAll"));    		   
	}
																	 
	  strPrevious = "Previous";
	 strNext  = "Next";
	 if (boolPrevious == true)														    
	{																	  
		strPrevious ="Previous";			 							   
	}
	else													    
	{													   
		strPrevious = " ";
	}														   
	if (boolNext== true)
	{
		strNext  ="Next";
	}
	else								  
	{													 										  
		strNext  = " ";
	}
	 
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block14Bytes, _wl_block14);

if(arrRow.size()==0)											 	    
{														    			    
	
            _bw.write(_wl_block15Bytes, _wl_block15);

}
else
{
	
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(selectAll));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pageCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((selectAll).equals("Y")?"checked":""));
            _bw.write(_wl_block22Bytes, _wl_block22);
									 			    
for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;				    
			else
				classvalue = "QRYODD" ;
	
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i+"proto"));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((String)arrCol.get(1)));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(selectAll.equals("Y"))
{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)arrCol.get(0)+"_check"));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)arrCol.get(0)+"_check"));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j+"_check"));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block35Bytes, _wl_block35);
}							   
else
		{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)arrCol.get(0)+"_check"));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j+"_check"));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(((String)arrCol.get(2)).equals("Y")?"Y":"N"));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)arrCol.get(0)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(((String)arrCol.get(2)).equals("Y")?"checked":""));
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
	   i++;
			}					   
}
	}
	
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		//arrRow.clear();
	//	arrCol.clear();
		ConnectionManager.returnConnection(conn);
		
	}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(search_option));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(fullList));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
