package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;

public final class __rep2monthlycensesspeciality_pd104b extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/Rep2MonthlyCensesSpeciality_PD104B.jsp", 1721727062757L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\t\n<HEAD>\n<TITLE></TITLE>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\nfunction mychange()\n{\n\t if (document.getElementById(\"p_type\").value==\'M\')\n\t {\n\t\t document.getElementById(\"MY1\").innerHTML=\"Census Month&nbsp;\"\n\t\t  document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_trn_date\' id=\'p_trn_date\' maxlength=\'5\' size=\'5\' readonly><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_trn_date.select();return showCalendar(\'p_trn_date\',\'mm/y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n\t else  if (document.getElementById(\"p_type\").value==\'Y\')\n\t {\n\t\t document.getElementById(\"MY1\").innerHTML=\"Census Year&nbsp;\"\n\t\t document.getElementById(\"MY\").innerHTML = \"<input type=\'text\' name=\'p_trn_date\' id=\'p_trn_date\' maxlength=\'4\' size=\'4\' readonly><input type=\'image\'  src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"document.forms[0].p_trn_date.select();return showCalendar(\'p_trn_date\',\'y\',null)\\\">&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\"\n\t }\n }\t\t\t\n\tasync function searchCode(obj,target)\n\t\t{\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \"400px\" ;\n\t\t\t\tvar dialogWidth\t= \"700px\" ;\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar sql=\"\";\n\t\t\t\tvar search_code=\"\";\n\t\t\t\tvar search_desc=\"\";\n\t\t\t\tvar tit=\"\";\n\t\n\t\t\t\tif(obj.name==\"speciality\")\n\t\t\t\t{\n\t\t\t\t\ttit=\"Specialty\"\n\t\t\t\t\tsql=\"select speciality_code, short_desc from am_speciality\";\n\t\t\t\t\tsearch_code=\"speciality_code\";\n\t\t\t\t\tsearch_desc= \"short_desc\";\n\t\t\t\t}\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\t\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit,arguments,features);\n\t\n\t\t\t\tif (!(retVal == null))\n\t\t\t\t{\n\t\t\t\t\ttarget.value=retVal;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\ttarget.focus();\n\t\t}\n\n\t\tfunction ChkDateFormat(Object2) {\n\t\t\tvar datefield = Object2;\n\t\t\tif (ChkDate1(Object2) == false) {\n\t\t\t\talert(parent.parent.parent.frames[0].getMessage(\'INVALID_DATE_FMT\'));\n\t\t\t\tdatefield.select();\n\t\t\t\tdatefield.focus();\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\telse {\n\t\t\t\treturn true;\n\t\t\t}\n\t\t}\n\t\t\n\t\tfunction ChkDate1(Object3) {\n\t\tvar strDate;\t\n\t\tvar strMonth;\n\t\tvar strYear;\t\n\t\tvar datefield = Object3;\n\t\tvar strDateArray = new Array();\n\n\t\tstrDate = datefield.value;\n\t\tif (strDate.length == 0) return true; \n\t\t\n\t\tstrDateArray = strDate.split(\"/\");\n\t\tif (strDateArray.length != 2) {\n\t\t\treturn false;\n\t\t}\n\t\telse {\n\t\t\tstrMonth = strDateArray[0];\n\t\t\tstrYear = strDateArray[1];\n\t\t}\n\n\n\t\tif (strYear.length < 4) return false;\n\t\tif (isNaN(strMonth)==true) return false;\n\t\tif (isNaN(strYear)==true) return false;\n\t\tif (strYear < 1900) return false;\n\t\tif (strMonth>12 || strMonth<1) \treturn false;\n\t\treturn true;\n }\n function ValidString(event)\n{\n\tif((((event.keyCode>=48) && (event.keyCode<=57))\n\t\t||((event.keyCode>=65) && (event.keyCode<=90))\n\t\t||((event.keyCode>=97) && (event.keyCode<=122))\n\t\t||(event.keyCode==42)||(event.keyCode==95)))\n\t{\n\t\treturn true\n\t}\n\telse\n\t{\t\n\t\treturn false\n\t}\n}\n</script>\n\n</HEAD>\n\n<BODY onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' onLoad=\"mychange()\">\n<br>\n<br>\n<form name=\"Rep2MonthlyIPCensusSpecialityForm\" id=\"Rep2MonthlyIPCensusSpecialityForm\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n\t\t<th align=\'left\'> Report Criteria\n\t\t</th>\n\n\t<tr>\n\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\t\t<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\' >\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">Report Type&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'>\n\t\t\t\t\t\t <SELECT name=\"p_type\" id=\"p_type\" onchange=\'mychange()\'>\n\t\t\t\t\t\t <option value=\"M\">Month</option>\n\t\t\t\t\t\t <option value=\"Y\">Year</option>\n\t\t\t\t\t\t </SELECT>\n\t\t\t\t\t</td>\n\t\t\t\t\t <td colspan =\'3\'> \n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">  &nbsp;&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  ></td>\n\t\t\t\t\t<td colspan =\'3\'></td>\n\t\t\t\t\t<td colspan =\'3\'></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'left\' id=\'MY1\'class=\"label\"> &nbsp; &nbsp;</td>\n\t\t\t\t\t\t<td align=\'left\' id=\'MY\' > &nbsp; </td><td> </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">  &nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  ></td>\n\t\t\t\t\t<td colspan =\'3\'></td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">Specialty Code&nbsp;</td>\n\t\t\t\t\t\t<td width=\'20%\'  >\n\t\t\t\t\t\t\t<input type=text  name=\'p_speciality_code\' id=\'p_speciality_code\' onkeypress=\'return ValidString(event)\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'speciality\' id=\'speciality\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_speciality_code)\'>\n\t\t\t\t\t\t<img align=\'center\' src=\'../../eMP/images/mandatory.gif\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t</table>\n\t</td>\n</tr>\n</table>\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);

	String p_module_id		= "IP" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
