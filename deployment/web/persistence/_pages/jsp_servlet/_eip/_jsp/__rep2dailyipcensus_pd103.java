package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;

public final class __rep2dailyipcensus_pd103 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/Rep2DailyIPCensus_PD103.jsp", 1721636475992L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<html>\t\n<HEAD>\n<TITLE></TITLE>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tasync function searchCode(obj,target)\n\t\t{\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \"400px\" ;\n\t\t\t\tvar dialogWidth\t= \"700px\" ;\n\t\t\t\tvar status = \"no\";\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tvar sql=\"\";\n\t\t\t\tvar search_code=\"\";\n\t\t\t\tvar search_desc=\"\";\n\t\t\t\tvar tit=\"\";\n\t\n\t\t\t\tif(obj.name==\"nursing_unit\")\n\t\t\t\t{\n\t\t\t\t\ttit=\"Nursing Unit\"\n\t\t\t\t\tsql=\"select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="`\";\n\t\t\t\t\tsearch_code=\"nursing_unit_code\";\n\t\t\t\t\tsearch_desc= \"short_desc\";\n\t\t\t\t}\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\t\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit,arguments,features);\n\t\n\t\t\t\tif (!(retVal == null))\n\t\t\t\t{\n\t\t\t\t\ttarget.value=retVal;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\ttarget.focus();\n\t\t}\n function ValidString(event)\n{\n\tif((((event.keyCode>=48) && (event.keyCode<=57))\n\t\t||((event.keyCode>=65) && (event.keyCode<=90))\n\t\t||((event.keyCode>=97) && (event.keyCode<=122))\n\t\t||(event.keyCode==42)||(event.keyCode==95)))\n\t{\n\t\treturn true\n\t}\n\telse\n\t{\t\n\t\treturn false\n\t}\n}\n/*Below function added IN:052797 */\nfunction validateCensusDate(obj) {\n\t\tvar from = obj.value;\t\n\t\tvar to = document.forms[0].CurrentDate.value;  \n\t\tvar localeName=document.forms[0].locale.value; \n        var fromarray;\n\t\tvar toarray;\n\t\tfromarray  = from.split(\"/\");\n\t\ttoarray    = to.split(\"/\");\n\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\t\n\t\tif (!isBeforeNow(obj.value,\"DMY\",localeName)){\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) {\n\t\t\t\t\tvar invaldt = getMessage(\"DATE1_GT_DATE2\",\'IP\') ;\n\t\t\t\t\tvar census_date_from=getLabel(\"eIP.CensusDate.label\",\"IP\");\t\t\t\t\t\n\t\t\t\t\tvar sys_date=getLabel(\"Common.CurrentDate.label\",\"Common\");\n\t\t\t\t\tinvaldt=invaldt.replace(\'$\',census_date_from);\n\t\t\t\t\tinvaldt=invaldt.replace(\'#\',sys_date);\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\tobj.focus();\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n</script>\n\n</HEAD>\n\n<BODY onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<br>\n<br>\n<form name=\"Rep2DailyIPCensusForm\" id=\"Rep2DailyIPCensusForm\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n\t\t<th align=\'left\'> Report Criteria\n\t\t</th>\n\n\t<tr>\n\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\n\t\t\t<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\' >\n\n\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\' width=\'35%\' class=\"label\">Census Date &nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'  >\n\t\t\t\t\t\t<input type=text  name=\'p_trn_date\' id=\'p_trn_date\' size=\"10\" maxlength=\"10\" align=\"center\" onBlur=\"if(CheckDate(this))validateCensusDate(this);\"><input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'p_trn_date\');\">\t<img align=\'center\' src=\'../../eMP/images/mandatory.gif\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td colspan =\'2\'>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"center\" width=\"35%\">&nbsp;</td>\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'left\' width=\'30%\' class=\"label\">Nursing Unit Code&nbsp;</td>\n\t\t\t\t\t\t<td width=\'20%\'  >\n\t\t\t\t\t\t\t<input type=text onkeypress=\'return ValidString(event)\' name=\'p_nursing_unit_code\' id=\'p_nursing_unit_code\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'nursing_unit\' id=\'nursing_unit\' value=\'?\' class=\'button\' onclick=\'searchCode(this, p_nursing_unit_code)\'>\n\t\t\t\t\t\t\t<img align=\'center\' src=\'../../eMP/images/mandatory.gif\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t</table>\n\t</td>\n</tr>\n</table>\n\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type=\"hidden\" name=\"CurrentDate\" id=\"CurrentDate\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDBDCN" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	
	    java.util.Date dNow = new java.util.Date();
        java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy");        	
		String CurrentDate=ft.format(dNow);	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(CurrentDate));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
