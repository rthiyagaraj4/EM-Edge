package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __pendingresultspractitionersfs_45_newui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/PendingResultsPractitionerSFS-newUI.jsp", 1738426140946L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>IP View</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> -->\n\n\n<link rel=\"stylesheet\" href=\"../css/iPadNew_IP.css\" />\n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />  \n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" /> \n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script> -->\n<script type=\"application/javascript\" src=\"../js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction searchFormSubmit()\n{\n\t //$.trim($(\"#hdnPatientId\").val($.trim($(\"#txtPatientId\").val())));\n\t //alert(document.getElementById(\"txtPatientId\").value.length);\n\t //var trimmedPatId= document.getElementById(\"txtPatientId\").value.trim();\n\t //alert(trimmedPatId.length);\n\t //document.getElementById(\"hdnPatientId\").value = document.getElementById(\"txtPatientId\").value;\n\t document.getElementById(\"PracSearchForm\").submit();\n}\n/* function ipSearch(){\n\tparent.document.getElementById(\'hdnSpeciality\').value = document.getElementById(\'hdnSpecialityId\').value;\n\tparent.document.getElementById(\'hdnNursingUnit\').value = document.getElementById(\'hdnNursingUnitId\').value;\n\tparent.document.getElementById(\'hdnClinicianId\').value = document.getElementById(\'hdnPractitionerId\').value;\n\tparent.document.getElementById(\'hdnPatientId\').value = \'\';\n\tparent.document.getElementById(\'IpForm\').submit();\n} */\n\n/* function back(){\n\tvar searchForm = document.getElementById(\"PracSearchForm\");\n\tsearchForm.action = \'IPSearch-newUI.jsp\';\n\tsearchForm.submit();\n} */\n\n</script>\n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />\n</head>\n<body style=\"width: 100%; height: 100%;\">\n\t<form name=\'PracSearchForm\' id=\'PracSearchForm\' method=\'post\' id=\"PracSearchForm\" action=\"PendingResultsPractitionerList-newUI.jsp\">\n\t\t<div class=\"ipSearchHeader ipSearchHeaderTheme\">\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td style=\"width:100px;\"><div class=\"prPracSearchHeaderButtonTheme\" onclick=\"parent.showPracSfs()\">Cancel</div></td>\n\t\t\t\t\t<td style=\"width:200px;\"><div class=\"prPracSearchHeaderText prPracSearchHeaderTextTheme\">";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="</div></td>\n\t\t\t\t\t<td style=\"width:100px;\"><div class=\"prPracSearchHeaderButtonDisabledTheme\">Done</div></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\n\t\t<div class=\"prPracSearchContainer prPracSearchContainerTheme\">\n\t\t\t<div>\n\t\t\t\t<table  cellpadding = \"0\" cellspacing = \"0\" border = \"0\" style=\"width:100%;height:100%;\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td style=\"width:50%;\"><div class=\"prPracSearchTabSelected prPracSearchTabSelectedTheme\"><div class=\"prPracSearchTabText\">Search</div></div></td>\n\t\t\t\t\t\t<td style=\"width:50%;\"><div class=\"prPracSearchTabNotSelected prPracSearchTabNotSelectedTheme\"><div class=\"prPracSearchTabText\">Recent Search</div></div></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\n\t\t\t\t<div class=\"ipSearchSfsItem ipSearchSfsItemTheme\" id=\"ipSearchItemSpeciality\">\n\t\t\t\t\t\t<div class=\"ipSearchItemHeadingTheme\">";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</div>\n\t\t\t\t\t\t<div class=\"ipSearchItemRadioButtons\">\n\t\t\t\t\t\t\t<span><input type=\"radio\" id=\"rdCode\" class=\"ipSearchRadioTheme\" data-role=\"none\" name=\"specialitySearch\" id=\"specialitySearch\" value=\"code\" checked></span>\n\t\t\t\t\t\t\t<span class=\"ipSearchSfsItemTextTheme\">Code</span>\n\t\t\t\t\t\t\t<span><input type=\"radio\" id=\"rdDesc\" class=\"ipSearchRadioTheme\" data-role=\"none\" name=\"specialitySearch\" id=\"specialitySearch\" value=\"desc\"></span>\n\t\t\t\t\t\t\t<span class=\"ipSearchSfsItemTextTheme\">Description</span>\n\t\t\t\t\t\t</div>\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"ipSearchSfsItem ipSearchSfsItemTheme\" id=\"ipSearchItemSpecialityCriteria\">\n\t\t\t\t\t\t<div class=\"ipSearchItemHeadingTheme\">Search Criteria</div>\n\t\t\t\t\t\t<div class=\"ipSearchItemRadioButtons\">\n\t\t\t\t\t\t\t<span><input type=\"radio\" id=\"rdStartWith\" class=\"ipSearchRadioTheme\" data-role=\"none\" name=\"specialitySearchCriteria\" id=\"specialitySearchCriteria\" value=\"SW\" checked></span>\n\t\t\t\t\t\t\t<span class=\"ipSearchSfsItemTextTheme\">Starts With</span>\n\t\t\t\t\t\t\t<span><input type=\"radio\" id=\"rdEndWith\" class=\"ipSearchRadioTheme\" data-role=\"none\" name=\"specialitySearchCriteria\" id=\"specialitySearchCriteria\" value=\"EW\"></span>\n\t\t\t\t\t\t\t<span class=\"ipSearchSfsItemTextTheme\">Ends With</span>\n\t\t\t\t\t\t\t<span><input type=\"radio\" id=\"rdContains\" class=\"ipSearchRadioTheme\" data-role=\"none\" name=\"specialitySearchCriteria\" id=\"specialitySearchCriteria\" value=\"CN\"></span>\n\t\t\t\t\t\t\t<span class=\"ipSearchSfsItemTextTheme\">Contains</span>\n\t\t\t\t\t\t</div>\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"ipSearchSfsItem ipSearchSfsItemTheme\" id=\"ipSearchItemSpecialitySearchText\">\n\t\t\t\t\t\t<div class=\"ipSearchItemHeadingTheme\">Search Text</div>\n\t\n\t\t\t\t\t\t<div style=\"display:table\"  class=\"ipSearchSfsItemTextSearch\">\n\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle\"><input type=\"text\" name=\"specialitySearchText\" id=\"specialitySearchText\" id=\"specialitySearchText\" class=\"ipSearchSfsItemTextBoxTheme\"></div>\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:5px\"> </div>\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle\"><div class=\"WidgetButtonTheme\" onclick=\"searchFormSubmit()\"><img src = \"../images/Search.png\"/></div></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\t\n\t\t\t\t</div>\n\n\t\t</div>\n\t\t\n\n\t\t<input type = \"hidden\" name =\"hdnPractitionerId\" id =\"hdnPractitionerId\" value =\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnPractitionerName\" id =\"hdnPractitionerName\" value =\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/>\n\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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

	request.setCharacterEncoding("UTF-8");

	String locale = "en";
	String fPractitionerId = "";
	String fPractitionerName = "";
	String searchHeading = "Practitioner";

	if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId").trim() != "")
	{
	 
		fPractitionerId = ((String)request.getParameter("hdnPractitionerId"));
	}
	if(request.getParameter("hdnPractitionerName") != null && request.getParameter("hdnPractitionerName").trim() != "")
	{
	 
		fPractitionerName = ((String)request.getParameter("hdnPractitionerName"));
	}
	
	

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(searchHeading ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(searchHeading));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(fPractitionerId ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(fPractitionerName ));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
