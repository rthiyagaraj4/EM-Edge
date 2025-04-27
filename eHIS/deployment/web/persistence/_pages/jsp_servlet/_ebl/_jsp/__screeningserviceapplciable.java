package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import eBL.BLScreenServiceBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __screeningserviceapplciable extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/ScreeningServiceApplciable.jsp", 1743663958052L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\">\nfunction formXMLStringMain(frmObj)\n{\n\t\nif( frmObj!=null && frmObj != \"undefined\" && frmObj.length >0)\n{\n\tvar xmlStr =\"<root><SEARCH \";\n\tif(true)\n\t{\n\tvar arrObj = frmObj.elements;\n\tfor(var i=0;i<arrObj.length;i++)\n\t{\n\t\tvar val = \"\" ;\n\t\tif(arrObj[i].type == \"checkbox\")\n\t\t{\n\t\t\tval = arrObj[i].value;\n\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + val + \"\\\" \" ;\n     }\n\t\t\n\t\t else if(arrObj[i].type == \"radio\")\n\t\t{\n\t\t\tif(arrObj[i].checked)\n\t\t\t{\n\t\t\t\tval = arrObj[i].value;\n\t\t        if(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t\t\txmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n         }\n\t    }\n\t\t\n\t\telse if(arrObj[i].type == \"select-multiple\" )\n\t\t{\n\t\t\tfor(var j=0; j<arrObj[i].options.length; j++)\n\t\t    {\n\t\t\t\tif(arrObj[i].options[j].selected)\n\t\t\t\t\tval+=arrObj[i].options[j].value +\"~\"\n         }\n\t        val= val.substring(0,val.lastIndexOf(\'~\'))\n\t\t    if(arrObj[i].name != null && arrObj[i].name != \"\")\n\t\t\t    xmlStr+= arrObj[i].name+\"=\\\"\" + checkSpl(val) + \"\\\" \" ;\n\t       \n\t\t}\n\t\telse\n\t\t{\n\t\t\tval = arrObj[i].value;\n\t\t\tif(arrObj[i].name != null && arrObj[i].name != \"\")\n\t        {\n\t        \t\txmlStr+= arrObj[i].name+\"=\\\"\" + val + \"\\\" \" ;\n\t        }\n\t\t }\n\t}\n}\nxmlStr +=\" /></root>\";\t\n}\nreturn xmlStr;\n}\nfunction checkSelected(obj)\n{\n\tvar chkCount=0;\n\tvar rowCount =  document.getElementById(\"panel_categories_table\").rows.length;  \n\t\n\t\n\tif(obj.checked)\n\t{\n\t\tobj.value = \"Y\";\n\t\tobj.checked=true;\n\t}\n\telse\n\t{\n\t\tobj.value = \"N\";\n\t\tobj.checked=false;\n\t\t\n\t\t\n\t}\n\tif(rowCount>1)\n\t{\n\t\tfor(var index=0;index<rowCount-1;index++)\n\t\t{\n\t\t\tif(document.getElementById(\"chk\"+index).checked == true)\n\t\t\t\tchkCount++;\n\t\t}\n\t}\n\t//document.getElementById(\"chkCount\").value=chkCount;\n\t//alert(chkCount);\n\tif(chkCount == rowCount-1)\n\t{\n\t\tdocument.getElementById(\'select_all\').checked = true;\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'select_all\').checked = false;\n\t}\n}\n\nfunction selectAll(table,obj)\n{\n\t\n\tvar rowCount =  document.getElementById(table).rows.length;  \n\tdocument.getElementById(\"rowCount\").value=rowCount;\n\t//alert(rowCount);\n\tif(rowCount>1)\n\t{\n\t\tif(obj.checked==true)\n\t\t{\n\t\t\tobj.value=\"Y\";\t\t\t\n\t\t\tobj.checked=true;\n\t\t\tif (obj.name==\"select_all\")\n\t\t\t{\n\t\t\t\t\n\t\t\t\tfor(var index=0;index<rowCount-1;index++)\n\t\t\t\t{\t\n\t\t\t\t\tif(document.getElementById(\'chk\'+index).disabled == false)\n\t\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'chk\'+index).checked=true;\n\t\t\t\t\tdocument.getElementById(\'chk\'+index).value=\"Y\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tobj.value=\"N\";\t\t\t\n\t\t\tobj.checked=false;\n\t\t\tif (obj.name==\"select_all\")\n\t\t\t{\n\t\t\t\tfor(var index=0;index<rowCount-1;index++)\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'chk\'+index).checked=false;\n\t\t\t\t\tdocument.getElementById(\'chk\'+index).value=\"N\";\n\t\t\t\t}\n\t\t\t}\t\n\t\t}\n\t}\n\telse\n\t{\n\t\tobj.value=\"N\";\t\t\t\n\t\tobj.checked=false;\n\t}\n\t\n}\n\nfunction SaveScreeningServiceApplicableCriteria()\n{\n\tvar rowCount =  document.getElementById(\"panel_categories_table\").rows.length;  \n\tdocument.getElementById(\"rowCount\").value=rowCount;\n\t//alert(\"AAA::\"+document.getElementById(\"rowCount\").value);\n\tvar frmObj=document.ScreeningServiceApplciable;\n\tif(frmObj!=\"\" && frmObj!=null && frmObj !=undefined )\n\t{\n\t\tvar xmlString=formXMLStringMain(frmObj);\n\t\tvar updation=formValidationScreeningServiceApplicableCriteria(xmlString); \n\t\t\n\t}\n\t var rowCount =  document.getElementById(\"panel_categories_table\").rows.length;  \n\tvar chkCount=0;\n\tdocument.getElementById(\"rowCount\").value=rowCount;\n\tif(rowCount>1)\n\t{\n\t\tfor(var index=0;index<rowCount-1;index++)\n\t\t{\n\t\t\tif(document.getElementById(\"chk\"+index).checked == true)\n\t\t\t\tchkCount++;\n\t\t}\n\t}\n\tdocument.getElementById(\"chkCount\").value=chkCount;\n\twindow.returnValue = chkCount;\n\tparent.window.close(); \n\treturn retModal(this);\n\t\n}\n\nfunction formValidationScreeningServiceApplicableCriteria(xmlStr)\n{\t \t\n\t//alert(\"INSIDE formValidation:::: \");\nvar temp_jsp=\"../../eBL/jsp/BillingSaveScreeningServiceApplicableCriteria.jsp\";  \n/*var xmlDoc = new ActiveXObject( \"Microsoft.XMLDom\" ) ;\nvar xmlHttp = new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;\nxmlDoc.loadXML(xmlStr);*/\nvar xmlHttp = new XMLHttpRequest();\nvar xmlDoc = \"\";\nnew DOMParser().parseFromString(getXMLString(xmlStr), \"text/xml\");\nif (xmlDoc.parseError.errorCode != 0)\n{\nalert(\"Error in line \" + xmlDoc.parseError.line +\n\" position \" + xmlDoc.parseError.linePos +\n\"\\nError Code: \" + xmlDoc.parseError.errorCode +\n\"\\nError Reason: \" + xmlDoc.parseError.reason +\n\"Error Line: \" + xmlDoc.parseError.srcText);\nreturn(null);\n}\nxmlHttp.open(\"POST\",temp_jsp,false);\nxmlHttp.send(xmlDoc);\nvar responseText=xmlHttp.responseText ;\n//alert(responseText);\n//eval(responseText);\nreturn true; \n}\t\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title><!-- Karthik changed label -->\n</head>\n<body>\n<form name=\"ScreeningServiceApplciable\" id=\"ScreeningServiceApplciable\" id=\"ScreeningServiceApplciable\">\n<TABLE width=\"100%\" CELLSPACING=0 cellpadding=3 align=\'center\'>\n\t\t\t<tr >\n\t\t\t\n\t\t\t\n\t\t\t\t\t<td  class=\"columnheader\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td></tr>\t<!-- Karthik changed label -->\t\n</TABLE>\n<br>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<div id=\"card_type_div\" name=\"card_type_div\" style=\" height:320px; overflow: auto; \" >\t\t \n\t<table align=\'center\'  cellpadding=3 cellspacing=0  width=\"100%\" id=\"panel_categories_table\" name=\"panel_categories_table\" id=\"panel_categories_table\" border=\"1\"  >\t \n\t\n\t\t\t\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th><!-- Karthik changed label -->\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \talign=\"left\"\t>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \talign=\"left\"\t>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t<th class=\'CAFLOWSHEETLEVEL1\' \talign=\"left\"\t><input type=\"Checkbox\" id=\"select_all\" name=\"select_all\" id=\"select_all\" onClick =\"selectAll(\'panel_categories_table\',this)\"></th>\n\t\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<tr>\n\t\t\t\t<td class=\"fields\" align=\"left\" ><input type=\"text\" id=\"criteria";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"criteria";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" \tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"  \t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t/></td> \n\t\t\t\t<td class=\"fields\" align=\"left\"><input type=\"text\" id=\"cd0";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\"cd0";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" \t\t\t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" \t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t/></td> \n\t\t\t\t<td class=\"fields\" align=\"left\"><input type=\"text\" id=\"cd1";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" name=\"cd1";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t/></td>\n\t\t\t\t<td class=\"fields\" align=\"left\"><input type=\"text\" id=\"cd2";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" name=\"cd2";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t/></td> \n\t\t\t\t<td class=\"fields\" align=\"left\"><input type=\"text\" id=\"cd3";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" name=\"cd3";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t/></td> \n\t\t\t\t<td class=\"fields\" align=\"left\"><input type=\"text\" id=\"cd4";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" name=\"cd4";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t/></td>\n\t\t\t\t<td class=\"fields\" align=\"left\"><input type=\"Checkbox\" id=\"chk";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" name=\"chk";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\tvalue=\"true\" onClick =\"checkSelected(this)\"></td> \n\t\t\t\t\t\t\t\t\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\n\t</table>\n\t</div>\n\t<TABLE border=\'0\' cellpadding=\'1\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' width=\"32%\"></td>\n\t\t\t\t\t<td class=\'fields\' width=\"55%\"></td>\n\t\t\t\t\t<td class=\'fields\' width=\"15%\"><input type=\"button\" class=\'button\' name=\"add_mod\" id=\"add_mod\"\tid=\"add_mod\"   value=\"Close\" onClick=\"SaveScreeningServiceApplicableCriteria();\"  /></td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t</TABLE>\t\n\t\t\t<input type=\'hidden\' name=\'rowCount\' id=\'rowCount\' \t\t\tid=\'rowCount\'\t\t\t\tvalue=\"\" >\n\t\t\t<input type=\'hidden\' name=\'chkCount\' id=\'chkCount\' \t\t\tid=\'chkCount\'\t\t\t\tvalue=\"\" >\n</form>\t\t\n</body>\n</body>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
	
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


int returnInteger(String inputValue){
	if(inputValue==null || inputValue.equals("")){
		return 0;
	}
	else{
		return Integer.parseInt(inputValue);
	}	
}


double returnDouble(String inputValue){
	if(inputValue==null || inputValue.equals("")){
		return 0.0;
	}
	else{
		return Double.parseDouble(inputValue);
	}	
}

	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

String locale																				=	"";
String facilityId																			=	"";
ArrayList screenServiceCriteriaList 														=   null;
HashMap screenServiceCriteriaListMap														=   null;
String p_patient_id																			=	null;
String p_episode_type																		=	null;
String p_episode_id																			=	null;
String p_visit_id 																			=	null;
String beanId 																				= 	"";
String beanName 																			= 	"";
String loginUser																			= 	null;
String disable_flag	=				"readonly onfocus='this.blur()'";


try  
{
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	loginUser																				= 	(String)session.getValue("login_user");
	screenServiceCriteriaListMap 															= 	new HashMap();
	screenServiceCriteriaList 																= 	new ArrayList();
	p_patient_id																			=	checkForNull(request.getParameter("p_patient_id"));
	p_episode_type																			=	checkForNull(request.getParameter("p_episode_type"));
	p_episode_id																			=	checkForNull(request.getParameter("p_episode_id"));
	p_visit_id																				=	checkForNull(request.getParameter("p_visit_id"));
	beanId 																					= 	"BLScreenServiceBean";
	beanName 																				= 	"eBL.BLScreenServiceBean";
	BLScreenServiceBean bllScreenServiceBean 												=  (BLScreenServiceBean)getBeanObject(beanId, beanName, request);
	

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);


screenServiceCriteriaListMap = bllScreenServiceBean.getScreenServiceCriteria(facilityId,locale,p_patient_id,p_episode_type,p_episode_id,p_visit_id,loginUser); 
Iterator iterator= screenServiceCriteriaListMap.keySet().iterator();
String chkBoxStatus="enabled";

int totalApplicableQty;
int totalAvailableQty;
double totalApplicableAmt;
double totalAvailableAmt;
String strAvailedQty="";
String strAvailedAmt="";

while(iterator.hasNext())
{
	
	int index =    (Integer)iterator.next();
	bllScreenServiceBean = (BLScreenServiceBean) screenServiceCriteriaListMap.get(index); 

		 totalApplicableQty=	returnInteger(bllScreenServiceBean.getScreeningApplicableQty());
		 totalAvailableQty=	returnInteger(bllScreenServiceBean.getScreeningAvailedQty());
		 totalApplicableAmt=	returnDouble(bllScreenServiceBean.getScreeningApplicableAmt());
		 totalAvailableAmt=	returnDouble(bllScreenServiceBean.getScreeningAvailedAmt());				
		
				  chkBoxStatus="";
				  strAvailedQty=bllScreenServiceBean.getScreeningAvailedQty();
				  strAvailedAmt=bllScreenServiceBean.getScreeningAvailedAmt();	
		if(((totalApplicableQty > 0)  &&  (totalApplicableQty <= totalAvailableQty) )||  (( totalApplicableAmt>0.0) && (totalApplicableAmt <= totalAvailableAmt)))
				{
				  strAvailedQty=bllScreenServiceBean.getScreeningApplicableQty();
				  strAvailedAmt=bllScreenServiceBean.getScreeningApplicableAmt();	  
				  chkBoxStatus="disabled";
				}


            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(index));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(index));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bllScreenServiceBean.getScreeningCategoryCode() 	!=null 	? 	bllScreenServiceBean.getScreeningCategoryCode()		: 	"" ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(index));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bllScreenServiceBean.getScreeningCategoryDesc() 	!=null 	? 	bllScreenServiceBean.getScreeningCategoryDesc()		: 	"" ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(index));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bllScreenServiceBean.getScreeningApplicableQty() 	!=null 	? 	bllScreenServiceBean.getScreeningApplicableQty()	: 	"" ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(index));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bllScreenServiceBean.getScreeningApplicableAmt()	!=null 	? 	bllScreenServiceBean.getScreeningApplicableAmt()	: 	"" ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(index));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strAvailedQty		!=null 	? 	strAvailedQty		: 	"" ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(index));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(index));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strAvailedAmt		!=null 	? 	strAvailedAmt		: 	"" ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(index));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(index));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chkBoxStatus));
            _bw.write(_wl_block33Bytes, _wl_block33);

}	

            _bw.write(_wl_block34Bytes, _wl_block34);

}
catch(Exception e)
{   
	System.out.println("Exception in ScreeningServiceApplciable.jsp::"+e);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ScreeningServiceApplicable.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ScreeningServiceApplicabilityStatus.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrdercatalogCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderCatalogDesc.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApplicableQuantity.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApplicableAmount.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVAILD_QTY.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVAILD_AMT.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
