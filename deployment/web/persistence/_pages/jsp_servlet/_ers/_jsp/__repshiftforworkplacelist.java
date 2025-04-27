package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

public final class __repshiftforworkplacelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/repShiftForWorkplaceList.jsp", 1709121646574L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n\n<HEAD>\n\n<TITLE></TITLE>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n<script language=\'javascript\'src=\'../../eRS/js/RSCommon.js\' ></script>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction searchShiftForWorkplace(target1,target2)\n{\n\tvar frmObj = document.form_repShiftForWorkplaceList;\n\tvar argumentArray  = new Array() ;\n\tvar dataNameArray  = new Array() ;\n\tvar dataValueArray = new Array() ;\n\tvar dataTypeArray  = new Array() ;\n\tvar object = target1;\n\tif(object==\'W\')\n\t{\n\targumentArray[0] = \"select workplace_code code, workplace_desc description  from rs_workplace where eff_status = \'E\' and upper(workplace_code) like upper(?) and upper(workplace_desc) like upper(?)order by workplace_desc \";\n\t}else\n\t{\n\targumentArray[0] = \"select shift_code code, short_desc description  from am_shift where eff_status = \'E\' and upper(shift_code) like upper(?) and upper(short_desc) like upper(?)order by short_desc \";\n\t}\n\n\targumentArray[1] = dataNameArray ;\n\targumentArray[2] = dataValueArray ;\n\targumentArray[3] = dataTypeArray ;\n\targumentArray[4] = \"1,2\";\n\targumentArray[5] = target2.value;\n\targumentArray[6] = CODE_LINK ;//CODE_LINK\n\targumentArray[7] = CODE_DESC ;//CODE_DESC\n\tretVal = RSCommonLookup(\"Workplace\", argumentArray );\n\tif(retVal != null && retVal != \"\" )  {\n\ttarget2.value = retVal[1] ;\n\tif(object==\'W\')\n\t\tfrmObj.workplace_code.value = retVal[0];\n\telse\n\t\tfrmObj.shift_code.value = retVal[0];\n\n\t}\n}\n</script>\n</HEAD>\n\n<BODY onKeyDown = \'lockKey()\'>\n<br>\n<br>\n<form name=\"form_repShiftForWorkplaceList\" id=\"form_repShiftForWorkplaceList\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n\t\t<th align=\'left\'> Report Criteria\n\t\t</th>\n\n\t<tr>\n\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\n\t\t\t\t<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\" align=\'center\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\"left\" width=\"35%\">&nbsp;</td>\n\t\t\t\t\t\t<td class=\"label\"  align=\"left\"  width=\"20%\">From</td>\n\t\t\t\t\t\t<td class=\"label\" align=\"left\"  width=\"40%\">To</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\"right\" class=\"label\" width=\"20%\">Workplace &nbsp;</td>\n\t\t\t\t\t\t<td  width=\"30%\">\n\t\t\t\t\t\t<input type=text  name=\'from_workplace_desc\' id=\'from_workplace_desc\' value=\"\" size=\"10\"  onblur=\"searchShiftForWorkplace(\'W\',from_workplace_desc)\"><input type=\'button\' name=\'workplace1\' id=\'workplace1\' value=\'?\' class=\'button\' onclick=\"searchShiftForWorkplace(\'W\',from_workplace_desc)\"><input type=\"hidden\" name=\"workplace_code\" id=\"workplace_code\" value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"50%\">\n\t\t\t\t\t\t<input type=text  name=\'to_workplace_desc\' id=\'to_workplace_desc\' value=\"\" size=\"10\"  onblur=\"searchShiftForWorkplace(\'W\',to_workplace_desc)\"><input type=\'button\' name=\'workplace2\' id=\'workplace2\' value=\'?\' class=\'button\' onclick=\"searchShiftForWorkplace(\'W\',to_workplace_desc)\"><input type=\"hidden\" name=\"workplace_code\" id=\"workplace_code\" value=\"\">\n\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n<tr>\n\t\t\t\t\t\t<td align=\"right\" class=\"label\" width=\"20%\">Shift &nbsp;</td>\n\t\t\t\t\t\t<td  width=\"30%\">\n\t\t\t\t\t\t<input type=text  name=\'from_shift_desc\' id=\'from_shift_desc\' value=\"\" size=\"10\"  onblur=\"searchShiftForWorkplace(\'S\',from_shift_desc)\"><input type=\'button\' name=\'shift1\' id=\'shift1\' value=\'?\' class=\'button\' onclick=\"searchShiftForWorkplace(\'S\',from_shift_desc)\"><input type=\"hidden\" name=\"shift_code\" id=\"shift_code\" value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"50%\">\n\t\t\t\t\t\t<input type=text  name=\'to_shift_desc\' id=\'to_shift_desc\' value=\"\" size=\"10\" onblur=\"searchShiftForWorkplace(\'S\',to_shift_desc)\"><input type=\'button\' name=\'shift2\' id=\'shift2\' value=\'?\' class=\'button\' onclick=\"searchShiftForWorkplace(\'S\',to_shift_desc)\"><input type=\"hidden\" name=\"shift_code\" id=\"shift_code\" value=\"\">\n\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" width=\'30%\' class=\"label\">\n\t\t\t\t\t\tOrder By &nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'20%\' align=\"left\">\n\t\t\t\t\t\t<select name=\'p_order_by\' id=\'p_order_by\'>\n\t\t\t\t\t\t<option value=\'WS\'>Workplace,Shift\n\t\t\t\t\t\t<option value=\'SW\'>Shift,Workplace\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<Td>&nbsp;</td>\n\t\t\t\t</tr>\n\n\t\t</table>\n\t</td>\n</tr>\n</table>\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n<input type=\"hidden\" name=\"pref\" id=\"pref\" >\n<input type=\"hidden\" name=\"text\" id=\"text\" >\n</form>\n</BODY>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	String p_module_id		= "RS" ;
	String p_report_id		= "RSBSHIFTFORWORKPLACE" ;

	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( session.getValue( "facility_id" ) ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( p_module_id ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(  session.getValue( "login_user" ) ));
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
