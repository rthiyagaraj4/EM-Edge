package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __reportcodesetupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ReportCodeSetupResult.jsp", 1743671258142L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eMR/js/ReportCodeSetup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n/////////////////////\nasync function getLevelGroupId(obj)\n    {\n\t\t\n\t\tvar name=(obj.name);\n\t\t//sub_group\n\t\tvar str=name.substring(9,name.length);\n\t\n\t\tvar Report_id=parent.frames[0].document.forms[0].Report_id.value;\n\t\tvar type=parent.frames[0].document.forms[0].type.value\n\t\tvar target= eval(\"document.forms[0].group_name\"+str);\n\t\tvar retVal\t=  new String();\n\t\tvar dialogTop\t\t\t= \"40\";\n\t\tvar dialogHeight\t\t= \"10vh\" ;\n\t\tvar dialogWidth\t\t\t= \"40vw\" ;\n\t\tvar features\t\t\t=\"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t\t= \"\" ;\n\t\tvar search_desc=\"\";\n\t\tvar search_code=\"\"; \n\t\tvar title=getLabel(\"Common.Group.label\",\"Common\")+\' \'+getLabel(\"Common.description.label\",\"Common\");\n\t\tvar sql =\"select group_desc,group_code from mr_report_grouping where report_id=`\"+Report_id+\"` and  mast_table_name_reference =`\"+type+\"`\";\n\t\tsearch_code=\"group_code\";\n\t\tsearch_desc=\"group_desc\";\n\t    retVal=await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(title)+\"&dispDescFirst=dispDescFirst\",arguments,features);\n\t   \n\t    var arr=new Array();\n\t\t\n\t    if (retVal != null && retVal != \'\' && retVal != \"null\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\n\t\t\tarr=retVal.split(\"::\");\n\t\t\t\n\t\t    var ass1= eval(\"document.forms[0].Group_id\"+str);\n\t\t\t\n\t\t\tass1.value=arr[0];\n\t\t\t\n\t\t\tvar ass2= eval(\"document.forms[0].group_name\"+str);\n\t\t\t\n\t\t\tass2.value=arr[1];\n\t\t\t\n\n\t\t\tass2.focus();\n\t\t\t\n\t\t}\n\t}\n//////////////////////\nfunction allowPositiveNumber() \n\t{\n\t\tvar key = window.event.keyCode;// allows only numbers to be entered\n\t\tif((key<48 )||(key>58)) \n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t}\n\n\tfunction chkDup(obj)\n\t{\n\t\t\n\t\tvar count=document.forms[0].maxrecord.value;\n\t\tvar obj_temp=\'\';\n\t\tvar val= obj.value;\n       \n\t\tvar flag=false;\n\t\tvar i=0;\n\t\tfor(var ind  = 1; ind <count;ind++)\n\t\t{\n\t\t\tif(obj.name ==\"serial_no\"+ind+\"\")\n\t\t\t{\n\t\t\t\t\n\t\t\t\t obj_temp = document.report_form_result[\"Group_id\" + ind];\n\t\t\t\t\n\t\t\t\t//var group_val=obj_temp.value;\n\t\t\t}\n\t\t}\n\n\t\t//var dup=val;\n\t\tfor(var ind  = 1; ind <count;ind++)\n\t\t{\n\t\tif(obj.name !=\"serial_no\"+ind+\"\" && eval(\"document.report_form_result.serial_no\"+ind+\".value\")!=\'\')\n\t\t{\n\t\t\t\n\t\t\t/*if(obj.name ==\"serial_no\"+ind+\"\")\n\t\t\t{\n\t\t\t\t//ert(ind);\n\t\t\t\tvar obj_temp=eval(\"document.report_form_result.Group_id\"+ind+\"\");\n\t\t\t\t//ert(obj_temp.value);\n\t\t\t\t//if(obj_temp != eval(\"document.report_form_result.Group_id\"+ind+\"\n\t\t\t}*/\n\t\t\tdocument.forms[0].status_value.value=\'Y\';\n\t\t\tvar num=eval(\"document.report_form_result.serial_no\"+ind+\".value\")\n\t\t\t\n\t\t\t//obj.name= document.report_form_result.serial_no\"+ind+\" \n\t\t\tif(val==num )\n\t\t\t{\t\n\t\t\t\tvar obj_temp1=eval(\"document.report_form_result.Group_id\"+ind+\"\");\n\t\t\t\tif(obj_temp.value == obj_temp1.value)\n\t\t\t\tflag=true;\n\t\t\t\telse\n\t\t\t\tflag=false;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tflag=false;\n\t\t\t}\t\t\n\t\t\t\n\t\t\tif(flag==true)\n\t\t\t{\n                var errors = getMessage(\'DUPLI_SRL_NO\',\'MR\');\n\t\t\t\talert(errors);\n\t\t\t\t// alert(\"Duplicate Order Serial Nos are not allowed..\");\n\t\t\t\t\n\t\t\t\tobj.focus();\n\t\t\t\tobj.select();\n\t\t\t\ti++;\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\t\t\n\t\n\t\t}\n\t}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));history.go(-1);\n\t\t\t</script>\n\t\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</head>\n\t<body  OnMouseDown=\"CodeArrest();\"  class=\'CONTENT\' onKeyDown = \'lockKey()\'>\n\t<form name=\'report_form_result\' id=\'report_form_result\' action=\"../../servlet/eMR.ReportCodeSetup.java\" method=\'post\' target=\"messageFrame\" >\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t<tr>\n\t\t<td class=\"white\">\t\t\t\n\t<tr>\n\t\t<td>\n\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\"100%\" align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t        <th width=\'10%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n                     <th width=\'10%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<tr>\n\t\t\t\t<td align=\'left\' width=\'10%\' name=\'code";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t\t \n\t\t\t\t\t \n\t\t\t\t\t ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\t\n\t\t\t\t\t\t<td align=\'left\' width=\'25%\' name=\'desc";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t  <td align=\'center\' width=\'10%\' class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t    <input type=\"checkbox\" value=\"Y\" onclick=\"chkDescription(this);\" checked name=\"inc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"inc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t\t\t </td>\n\t\t\t\t\t\t <td align=\'left\' width=\'25%\' class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t\t\t\t   <input type = text  size=\'25\' maxLength=\'40\' \n                        name =\"report_desc";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" ></td>\n\t\t\t\t\t\t<!--Adding group code----->\n\t\t\t\t\t\t<td width=\'25%\' align=\'left\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n                                <input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" name=\"Group_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t     <textarea rows=2  readonly cols=20  name=\"group_name";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"  >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</textarea><input type=\"button\" name=\"sub_group";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"sub_group";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" value=\"?\" class=\"BUTTON\" onClick=\"getLevelGroupId(this);\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- <input type=\"text\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" name=\"group_name";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"> -->\n\t\t\t            </td>\n\t\t\t\t\t\t<!--  endded here--------->\n\t\t\t\t\t\t <td align=\'left\' width=\'10%\' class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t\t\t     <input type = text size=\'2\' maxLength=\'2\' onkeypress=\"return allowPositiveNumber()\"                name =\"serial_no";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"  onBlur=\"checkVal(this);chkDup(this)\" value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t\t\t\t\t\t </td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"N\" onclick=\"chkDescription(this);\" name=\"inc";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t\t\t\t    <input type = text  disabled size=\'25\' maxLength=\'40\' \n                        name =\"report_desc";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!--Adding group code----->\n\t\t\t\t\t\t<td width=\'25%\' align=\'left\' >\n\t\t\t\t\t\t\t<input type=\"hidden\" value=\"\" name=\"Group_id";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"Group_id";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t\t\t\t\t\t\t <textarea rows=2  readonly disabled cols=20  name=\"group_name";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></textarea><input type=\"button\" name=\"sub_group";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" disabled value=\"?\" class=\"BUTTON\" onClick=\"getLevelGroupId(this);\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!--  endded here--------->\n\t\t\t\t\t\t <td align=\'left\' width=\'10%\' class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t\t\t    <input type = text size=\'2\' disabled maxLength=\'2\' onkeypress=\"return allowPositiveNumber()\"\n                        name =\"serial_no";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t\t\t\t\t\t</td>\t\n\t\t\t\t    ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'Rep_id\' id=\'Rep_id\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'code";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'code";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'type\' id=\'type\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'status_value\' id=\'status_value\' value=\'\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'grp_value\' id=\'grp_value\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n  \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<input type=\'hidden\'name=\"maxrecord\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t</table>\t\t\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t\n\t</form>\n</body>\n</html>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null ;
	//ResultSet rset=null;
	int maxRecord=0;
	Statement stmt1=null;
	ResultSet rs1=null ;
			
	String Report_id=request.getParameter("Report_id");
	String type=request.getParameter("type");
	String sql="";
	
	int i=1;
	
    int slno=0;
	//int recordCount = 0;	
	try
	{
		con = ConnectionManager.getConnection(request);
		
		String sql1="Select max(ORDER_BY_SRL_NO) from MR_REPORT_MAPPING where REPORT_ID=? and MAST_TABLE_NAME_REFERENCE=? ";	
		pstmt=con.prepareStatement(sql1);
		pstmt.setString(1,Report_id);
		pstmt.setString(2,type);
		 rs=pstmt.executeQuery();
		if(rs.next())
		{
		slno=rs.getInt(1);
		slno=slno+1;
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		
            _bw.write(_wl_block8Bytes, _wl_block8);
	
		 if(type.equals("SP"))
		{
			sql="select report_id,mast_table_name_reference, mast_code, short_desc, order_by_srl_no,Report_desc,GROUP_CODE  from mr_report_mapping,AM_SPECIALITY where report_id = '"+Report_id+"' and mast_table_name_reference = '"+type+"' and SPECIALITY_CODE = mast_code union select '"+Report_id+"' report_id , '"+type+"'  mast_table_name_reference, speciality_code mast_code,short_desc, 0,null Report_desc,null GROUP_CODE from AM_SPECIALITY where speciality_code not in (select mast_code from mr_report_mapping where report_id = '"+Report_id+"'  and mast_table_name_reference = '"+type+"') order by 3";
		}
		else if(type.equals("RC")){
         sql="select report_id, mast_table_name_reference, mast_code, short_desc,order_by_srl_no,Report_desc,GROUP_CODE  from mr_report_mapping,mp_race where report_id = '"+Report_id+"' and mast_table_name_reference = '"+type+"' AND MAST_CODE= RACE_CODE union select '"+Report_id+"' report_id , '"+type+"'  mast_table_name_reference, race_code mast_code,short_desc, 0,null Report_desc,null GROUP_CODE from mp_race where race_code not in (select mast_code from mr_report_mapping where report_id = '"+Report_id+"'  and mast_table_name_reference = '"+type+"')  order by 3";

		}else if(type.equals("DT")){
         sql=" select report_id, mast_table_name_reference, mast_code, short_desc, order_by_srl_no,Report_desc,GROUP_CODE  from mr_report_mapping,MP_NOD_TYPE where report_id = '"+Report_id+"' and mast_table_name_reference = '"+type+"' AND nod_type=MAST_CODE union select '"+Report_id+"' report_id , '"+type+"'  mast_table_name_reference, nod_type  mast_code,short_desc, 0,null Report_desc,null GROUP_CODE from MP_NOD_TYPE where nod_type not in (select mast_code from mr_report_mapping where report_id = '"+Report_id+"'  and mast_table_name_reference = '"+type+"')  order by 3";

		}else if(type.equals("HC")){
         sql="select report_id, mast_table_name_reference, mast_code, short_desc, order_by_srl_no,Report_desc,GROUP_CODE  from mr_report_mapping,AM_HCARE_SETTING_TYPE where report_id = '"+Report_id+"' and mast_table_name_reference='"+type+"' AND Hcare_setting_type_code= MAST_CODE union select '"+Report_id+"' report_id , '"+type+"'  mast_table_name_reference, Hcare_setting_type_code mast_code,short_desc, 0,null Report_desc,null GROUP_CODE from AM_HCARE_SETTING_TYPE where Hcare_setting_type_code not in (select mast_code from mr_report_mapping where report_id = '"+Report_id+"'  and mast_table_name_reference = '"+type+"') order by 3 ";

		}
		
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=stmt.executeQuery(sql);
		String classValue = "" ;
	
		if(rs != null)
		{
			rs.last();
			maxRecord = rs.getRow();
			rs.beforeFirst();

			if(maxRecord == 0)
		{
            _bw.write(_wl_block9Bytes, _wl_block9);
}}
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

				
				while (rs.next()) 
		{ 
		if ( i % 2 == 0 )
					 	classValue = "QRYEVEN" ;
					 else
					 	classValue = "QRYODD" ;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);

				   String desc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
					String code=rs.getString("mast_code")==null?"":rs.getString("mast_code");
					 String serial_no=rs.getString("order_by_srl_no")==null?"":rs.getString("order_by_srl_no");
			 String Report_desc=rs.getString("Report_desc")==null?"":rs.getString("Report_desc");
			  String group_code=rs.getString("GROUP_CODE")==null?"":rs.getString("GROUP_CODE");
			 			 String group_desc="";
				String group_code_val="";
					 if(serial_no.equals("0"))serial_no="";
					 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(!(serial_no.equals(""))){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Report_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);

							sql ="Select group_desc,GROUP_CODE from mr_report_grouping Where report_id='"+Report_id+"' and   MAST_TABLE_NAME_REFERENCE ='"+type+"' order by group_desc";
			
							stmt1 = con.createStatement();
							rs1 = stmt1.executeQuery(sql);
							while(rs1.next())
							{
								group_desc = rs1.getString("group_desc");
								group_code_val	=rs1.getString("GROUP_CODE");
								if(group_code_val.equals(group_code)){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(group_code_val));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(group_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
}}
							 if(rs1!=null) rs1.close();
							 if(stmt1!=null) stmt1.close();
						
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(group_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(serial_no));
            _bw.write(_wl_block43Bytes, _wl_block43);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(serial_no));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Report_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(group_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
 i++;
		}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
	 
		//if(stmt!=null)stmt.close();
		//if(rs!=null)rs.close();
	}
	  catch(Exception e){/* out.print(e); */ e.printStackTrace();}
	  finally
	  {
	  if(rs!=null)	rs.close();
	  if(stmt!=null)	stmt.close();
	   ConnectionManager.returnConnection(con,request);

	  }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReportDesc.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Group.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderSrlNo.label", java.lang.String .class,"key"));
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
}
