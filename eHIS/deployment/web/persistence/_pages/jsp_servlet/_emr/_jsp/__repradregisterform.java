package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __repradregisterform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/repRadRegisterForm.jsp", 1743671531805L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\n\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nfunction valid()\n{\n\tvar field1 = parent.f_query_add_mod.document.MROPCSEG.p_patient_class.value;\n}\n function ValidString(event)\n{\n\tif((((event.keyCode>=48) && (event.keyCode<=57))\n\t\t||((event.keyCode>=65) && (event.keyCode<=90))\n\t\t||((event.keyCode>=97) && (event.keyCode<=122))\n\t\t||(event.keyCode==42)||(event.keyCode==95)))\n\t{\n\t\treturn true\n\t}\n\telse\n\t{\t\n\t\treturn false\n\t}\n}\n\t\nasync function searchCode(obj,target)\n{\n\t\t\tvar loctype = document.forms[0].p_location_type.value;\n\t\t\tvar patclass = document.forms[0].p_patient_class.value;\n\t\t\tvar facility = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"28vh\" ;\n\t\t\tvar dialogWidth\t= \"43vw\" ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar sql=\"\";\n\t\t\tvar search_code=\"\";\n\t\t\tvar search_desc=\"\";\n\t\t\tvar tit=\"\";\n\t\t\t\n\t\t\tif(obj.name==\"clinic\")\n\t\t\t{ \n\t\t\t\ttit=getLabel(\"Common.clinic.label\",\"Common\");\n\t\t\t\tsql=\"select clinic_code, long_desc from op_clinic where facility_id=`\"+facility+\"` and CARE_LOCN_TYPE_IND=nvl(`\"+loctype+\"`,CARE_LOCN_TYPE_IND) and LEVEL_OF_CARE_IND=nvl(`\"+patclass+\"`,LEVEL_OF_CARE_IND)\"; \n\t\t\t\tsearch_code=\"clinic_code\";\n\t\t\t\tsearch_desc= \"long_desc\";\n\t\t\t}\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\n\t\t\tretVal =await  window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\ttarget.value=retVal;\n\t\t\t}\n\t\t\telse\n\t\t\t\ttarget.focus();\n\t}\n\nfunction clearList(objSelect)\n{\n\tvar length = objSelect.options.length;\n\tfor(var index = 1 ;index < length ;index++)\n\t{\n\t\tobjSelect.remove(1)\n\t}\n}\n\nfunction doDateCheck(from,to,messageFrame) {\nvar fromarray; var toarray;\nvar fromdate = from.value ;\nvar todate = to.value ;\n\nif(fromdate.length > 0 && todate.length > 0 ) {\nfromarray = fromdate.split(\"/\");\ntoarray = todate.split(\"/\");\nvar fromdt = new Date(fromarray[1],fromarray[0],\"01\");\nvar todt = new Date(toarray[1],toarray[0],\"01\");\nif(Date.parse(todt) < Date.parse(fromdt)) {\n//var error = getMessage(\"MRDATE1_GT_DATE2\",\'MR\');\nvar error = getMessage(\'TO_DT_GR_EQ_FM_DT\',\'SM\');\nmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error;\nreturn false;\n}\nelse if(Date.parse(todt) >= Date.parse(fromdt)) return true;\n}\nreturn true;\n}\n\nfunction ValidateDt(obj,Date1,Date2)\n  {\n\t  /* Date2 should be less than Date1\n\t\t  type determines whether the selected type is \"D\"ay ,\"M\"onth or \"Y\"ear\n\t  */\n\t  var error = getMessage(\'MRDATE1_GT_DATE2\',\'MR\');\n\t  if ( Date1.value==\'\' ||  Date2.value==\'\')\n\t  {\n\t\t  return ;\n\t  }\n\t  else\n\t  {\n\t\t\t  var frm = \t Date1.value;\n\t\t\t  var to  = \t Date2.value;\n\t\t\t  var frm_arr\t= frm.split(\"/\");\n\t\t\t  var to_arr\t    = to.split(\"/\");\n\t\t\t  /*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/\n\t\t\t  var frm_date = new Date(frm_arr[2],frm_arr[1]-1,frm_arr[0]) ;\n\t\t\t  var to_date = new Date(to_arr[2],to_arr[1]-1,to_arr[0]) ;\n\t\t\t  if (Date.parse(to_date) < Date.parse(frm_date))\n\t\t\t  {\n\t\t\t      if (Date2.name==\'current_date\')\n\t\t\t\t  {\n\t\t\t\t\t  if (Date1.name==\'p_fm_Date\')\n\t\t\t\t\t\t  error = error.replace(\'$\',getLabel(\"Common.DateFrom.label\",\"Common\"));\n\t\t\t\t\t  else\n\t\t\t\t\t   \t  error = error.replace(\'$\',getLabel(\"Common.todate.label\",\"Common\")); // For p_to_Date\n\t\t\t\t\t  error = error.replace(\'#\',getLabel(\"Common.CurrentDate.label\",\"Common\"));\n\t\t\t\t\t  alert(error);\n\t\t\t\t\t  Date1.value=\'\';\n\t\t\t\t      Date1.focus();\n\t\t\t\t  }\n\t\t\t\t  else\n\t\t\t\t  {\n\t\t\t\t\t  error = error.replace(\'$\',getLabel(\"Common.DateFrom.label\",\"Common\"));\n\t\t\t\t\t  error = error.replace(\'#\',getLabel(\"Common.todate.label\",\"Common\"));\n\t\t\t\t\t  alert(error);\n\t\t\t\t\t  //Date1.select();\n\t\t\t\t\t  if (obj.name==\'p_fm_Date\')\n\t\t\t\t\t  {\n\t\t\t\t\t  \t\tDate1.value=\'\';\n\t\t\t\t\t\t\tDate1.focus();\n\t\t\t\t\t  }\n\t\t\t\t\t  else\n\t\t\t\t\t  {\n\t\t\t\t\t  \t\tDate2.value=\'\';\n\t\t\t\t\t\t\tDate2.focus();\n\t\t\t\t\t  }\n\t\t\t\t  }\n\t\t\t  }\n\t  }\n\t  return;\n  }\n\n\n/*function mychange()\n {\n\t if (document.getElementById(\"report_type\").value==\'M\')\n\t {\n\t\t if (document.getElementById(\"function_id\").value==\'excepRep\')\n\t\t {\n\t\t     document.forms[0].p_report_id.value=\"MREXCLST\";\n\t\t }else{\n\t\t     document.forms[0].p_report_id.value=\"MROPCSEG\";\n\t\t }\n\t\t document.getElementById(\"MY1\").innerHTML=\"Month&nbsp;\"\n\t\t  document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\' id=\'census_mth\' maxlength=\'7\' size=\'7\' onBlur=\'CheckDate(this)\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'census_mth\',\'mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t else  if (document.getElementById(\"report_type\").value==\'Y\')\n\t {\n\t    if (document.getElementById(\"function_id\").value==\'excepRep\')\n\t\t {\n\t\t     document.forms[0].p_report_id.value=\"MREXCLST\";\n\t\t }else{\n\t\t     document.forms[0].p_report_id.value=\"MROPCSEG\";\n\t\t }\n\t\t document.getElementById(\"MY1\").innerHTML=\"Year&nbsp;\"\n\t\t document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\' id=\'census_date\' maxlength=\'4\' size=\'4\' onBlur=\'CheckDate(this)\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'census_date\',\'y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t  else  if (document.getElementById(\"report_type\").value==\'D\')\n\t {\n\t    if (document.getElementById(\"function_id\").value==\'excepRep\')\n\t\t {\n\t\t     document.forms[0].p_report_id.value=\"MREXCLST\";\n\t\t }else{\n\t\t     document.forms[0].p_report_id.value=\"MROPCSEG\";\n\t\t }\n\t\t document.getElementById(\"MY1\").innerHTML=\"Date&nbsp;\"\n\t\t document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\' id=\'census_date\' maxlength=\'10\'onBlur=\'CheckDate(this)\' size=\'10\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_fm_Date.select();return showCalendar(\'census_date\',\'dd/mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\n\t  if (document.getElementById(\"report_type\").value==\'M\')\n\t {\n\t\t   if (document.getElementById(\"function_id\").value==\'excepRep\')\n\t\t {\n\t\t     document.forms[0].p_report_id.value=\"MREXCLST\";\n\t\t }else{\n\t\t     document.forms[0].p_report_id.value=\"MROPCSEG\";\n\t\t }\n\t\t  document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\' id=\'census_mth1\' maxlength=\'7\' size=\'7\' onBlur=\'CheckDate(this)\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'census_mth1\',\'mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t else  if (document.getElementById(\"report_type\").value==\'Y\')\n\t {\n\t\t\n\t\t  if (document.getElementById(\"function_id\").value==\'excepRep\')\n\t\t {\n\t\t     document.forms[0].p_report_id.value=\"MREXCLST\";\n\t\t }else{\n\t\t     document.forms[0].p_report_id.value=\"MROPCSEG\";\n\t\t }\n\t\t document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\' id=\'census_date1\' maxlength=\'4\' size=\'4\' onBlur=\'CheckDate(this)\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'census_date1\',\'y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t  else  if (document.getElementById(\"report_type\").value==\'D\')\n\t {\n\t\t  if (document.getElementById(\"function_id\").value==\'excepRep\')\n\t\t {\n\t\t     document.forms[0].p_report_id.value=\"MREXCLST\";\n\t\t }else{\n\t\t     document.forms[0].p_report_id.value=\"MROPCSEG\";\n\t\t }\n\t\t document.getElementById(\"MY3\").innerHTML = \"<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\' id=\'census_date1\' maxlength=\'10\' size=\'10\' onBlur=\'CheckDate(this)\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_to_Date.select();return showCalendar(\'census_date1\',\'dd/mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n }\t*/\t\n \n</script>\n</head>\n<!-- <body  OnMouseDown=\"CodeArrest();\" onLoad=\"FocusFirstElement();mychange();\"  onKeyDown = \'lockKey()\'> -->\n<body  OnMouseDown=\"CodeArrest();\" onLoad=\"FocusFirstElement();\"  onKeyDown = \'lockKey()\'>\n<form name=\"MRBLABRG\" id=\"MRBLABRG\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<BR><BR><BR><BR>\n<table border=\"0\" width=\'60%\' cellpadding=\"0\" cellspacing=\"0\"  align=\'center\'>\n<th align=\'left\' colspan=\'3\'> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </th>\n<tr>\n\t<td colspan=3>&nbsp;</td>\n</tr>\n<!--  <tr>\n\t<td align=\'right\' width=\'20%\' class=\"label\">Report Type&nbsp;</td>\n\t<td width=\'25%\'  >\n\t\t <SELECT name=\"report_type\" id=\"report_type\" onchange=\'mychange()\'>\n\t\t <option value=\"D\">Daily</option>\n\t\t <option value=\"M\">Monthly</option>\n\t\t <option value=\"Y\">Yearly</option>\n\t\t </SELECT>\n\t</td>\n\t<td>&nbsp;</td>\n</tr> -->\n<tr>\n\t<td class=\"label\">&nbsp;</td>\n\t<td class=\"querydata\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=\"querydata\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n</tr>\n<tr><td class=\"label\" colspan=\'3\'>&nbsp;</td></tr>\n<tr>\n\t\t<td align=\'right\' id=\'MY1\'class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td>\n\t\t<td align=\'left\' id=\'MY\'>&nbsp;<input type=\'text\' name=\'p_fm_Date\' id=\'p_fm_Date\'  maxlength=\'10\' onBlur=\'ValidateDt(this,p_fm_Date,p_to_Date);CheckDate(this)\' size=\'10\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar(\'p_fm_Date\',\'dd/mm/y\',null)\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t<td align=\'left\' id=\'MY3\'>&nbsp;<input type=\'text\' name=\'p_to_Date\' id=\'p_to_Date\'  maxlength=\'10\' size=\'10\' onBlur=\'ValidateDt(this,p_fm_Date,p_to_Date);CheckDate(this)\'><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].p_to_Date.select();return showCalendar(\'p_to_Date\',\'dd/mm/y\',null)\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n</tr>\n<tr>\n\t<td colspan=3>&nbsp;</td>\n</tr>\n\n\t<td colspan=3>&nbsp;</td>\n</tr>\n\n    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t  <tr>\n\t\t\t  <td align=\'right\' width=\'35%\' class=\"label\">&nbsp;</td>\n\t\t\t  \t\t<td >&nbsp;</td>\n\t\t\t  \t\t<td >&nbsp;<td>\n\t\t\t  </tr>\n\t\t\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\n       ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr>\n\t\t<td colspan=3>&nbsp;</td>\n\t</tr>\n</table>\n<input type=\"hidden\" name=\"p_report\" id=\"p_report\"\tvalue=\"MROPCSEG\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"MR\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n  <input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"MRBLABRG\">\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name=\"P_RESP_ID\" id=\"P_RESP_ID\"\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n \n \n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
    Connection con =null;
	ResultSet rset = null;
	java.sql.Statement stmt1 = null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");

try {
    con=ConnectionManager.getConnection(request);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
	if(function_id.equals("excepRep")){ 
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(function_id.equals("excepRep")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);

} catch(Exception e) { /*  out.println("in else "+e); */e.printStackTrace(); }
finally
{
	if(con != null)ConnectionManager.returnConnection(con,request);
	 if(rset!= null) rset.close();
	 if(stmt1!=null) stmt1.close();
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
