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

public final class __ipsearch_45_newui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/IPSearch-newUI.jsp", 1738426062208L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<title>IP View</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> -->\n\n\n<link rel=\"stylesheet\" href=\"../css/iPadNew_IP.css\" />\n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" /> \n<script src=\"../jquery-1.5.2.min.js\"></script>\n\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>-->\n<script type=\"application/javascript\" src=\"../js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nfunction openSpecialitySearch(){\n\tvar searchForm = document.getElementById(\"IpMainSearchForm\");\n\tdocument.getElementById(\'hdnSfsContext\').value=\'SP\';\n\tsearchForm.action = \'SpecialitySFS-newUI.jsp\';\n\tsearchForm.submit();\n}\nfunction openNursingUnitSearch(){\n\tvar searchForm = document.getElementById(\"IpMainSearchForm\");\n\tdocument.getElementById(\'hdnSfsContext\').value=\'NU\';\n\tsearchForm.action = \'SpecialitySFS-newUI.jsp\';\n\tsearchForm.submit();\n}\nfunction openPractitionerSearch(){\n\tvar searchForm = document.getElementById(\"IpMainSearchForm\");\n\tdocument.getElementById(\'hdnSfsContext\').value=\'PR\';\n\tsearchForm.action = \'SpecialitySFS-newUI.jsp\';\n\tsearchForm.submit();\n}\nfunction ipSearch(){\n\tparent.document.getElementById(\'hdnSpeciality\').value = document.getElementById(\'hdnSpecialityId\').value;\n\tparent.document.getElementById(\'hdnNursingUnit\').value = document.getElementById(\'hdnNursingUnitId\').value;\n\tparent.document.getElementById(\'hdnClinicianId\').value = document.getElementById(\'hdnPractitionerId\').value;\n\tparent.document.getElementById(\'hdnPatientId\').value = \'\';\n\tparent.document.getElementById(\'IpForm\').submit();\n}\n</script>\n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />\n</head>\n<body style=\"width: 100%; height: 100%;\">\n\t<form name=\'IpSearchForm\' id=\'IpSearchForm\' method=\'post\' id=\"IpMainSearchForm\">\n\t\t<div class=\"ipSearchHeader ipSearchHeaderTheme\">\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td style=\"width:100px\"><div class=\"ipSearchHeaderButtonTheme\" onclick=\"parent.showsfs()\">Cancel</div></td>\n\t\t\t\t\t<td style=\"width:200px\"><div class=\"ipSearchHeaderTextTheme\">In Patient</div></td>\n\t\t\t\t\t<td style=\"width:100px\"><div class=\"ipSearchHeaderButtonTheme\" onclick=\"ipSearch()\">Search</div></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<div class=\"ipSearchContainer ipSearchContainerTheme\">\n\n\t\t\t\t<div class=\"ipSearchItem ipSearchItemTheme\" id=\"ipSearchItemSpeciality\" onclick=\"openSpecialitySearch()\">\n\t\t\t\t\t<div class=\"ipSearchItemHeading ipSearchItemHeadingTheme\">Speciality</div>\n\t\t\t\t\t<div>\n\t\t\t\t\t\t<input type=\"text\" class=\"ipSearchItemTextbox ipSearchItemTextboxTheme\" name=\"specialityName\" id=\"specialityName\" placeholder=\"Speciality\" value =\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\" readonly />\n\t\t\t\t\t</div>\t\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"ipSearchItem ipSearchItemTheme\" id=\"ipSearchItemNursingUnit\" onclick=\"openNursingUnitSearch()\">\n\t\t\t\t\t<div class=\"ipSearchItemHeading ipSearchItemHeadingTheme\">Nursing Unit</div>\n\t\t\t\t\t<div>\n\t\t\t\t\t\t<input type=\"text\" class=\"ipSearchItemTextbox ipSearchItemTextboxTheme\" name=\"nursingUnitName\" id=\"nursingUnitName\" placeholder=\"Nursing Unit\" value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" readonly />\n\t\t\t\t\t</div>\t\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"ipSearchItem ipSearchItemTheme\" id=\"ipSearchItemPractitioner\" onclick=\"openPractitionerSearch()\">\n\t\t\t\t\t<div class=\"ipSearchItemHeading ipSearchItemHeadingTheme\">Practitioner</div>\n\t\t\t\t\t<div>\n\t\t\t\t\t\t<input type=\"text\" class=\"ipSearchItemTextbox ipSearchItemTextboxTheme\" name=\"practitionerName\" id=\"practitionerName\" placeholder=\"Practitioner\" value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"readonly />\n\t\t\t\t\t</div>\t\t\n\t\t\t\t</div>\n\n\t\t</div>\n\t\t\n\t\t<input type = \"hidden\" name =\"hdnSpecialityId\" id =\"hdnSpecialityId\" value =\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnSpecialityName\" id =\"hdnSpecialityName\" value =\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnNursingUnitId\" id =\"hdnNursingUnitId\" value =\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnNursingUnitName\" id =\"hdnNursingUnitName\" value =\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnPractitionerId\" id =\"hdnPractitionerId\" value =\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnPractitionerName\" id =\"hdnPractitionerName\" value =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n\t\t<input type = \"hidden\" name =\"hdnSfsContext\" id =\"hdnSfsContext\" value =\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
	String fSpecialityId = "";
	String fSpecialityName = "";
	String fNursingUnitId = "";
	String fNursingUnitName = "";
	String fPractitionerId = "";
	String fPractitionerName = "";
	String fSfsContext = "";
	
	
	
	if(request.getParameter("hdnSpecialityId") != null && request.getParameter("hdnSpecialityId").trim() != "")
	{
	 
		fSpecialityId = ((String)request.getParameter("hdnSpecialityId"));
	}
	if(request.getParameter("hdnSpecialityName") != null && request.getParameter("hdnSpecialityName").trim() != "")
	{
	 
		fSpecialityName = ((String)request.getParameter("hdnSpecialityName"));
	}
	if(request.getParameter("hdnNursingUnitId") != null && request.getParameter("hdnNursingUnitId").trim() != "")
	{
	 
		fNursingUnitId = ((String)request.getParameter("hdnNursingUnitId"));
	}
	if(request.getParameter("hdnNursingUnitName") != null && request.getParameter("hdnNursingUnitName").trim() != "")
	{
	 
		fNursingUnitName = ((String)request.getParameter("hdnNursingUnitName"));
	}
	if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId").trim() != "")
	{
	 
		fPractitionerId = ((String)request.getParameter("hdnPractitionerId"));
	}
	if(request.getParameter("hdnPractitionerName") != null && request.getParameter("hdnPractitionerName").trim() != "")
	{
	 
		fPractitionerName = ((String)request.getParameter("hdnPractitionerName"));
	}
	if(request.getParameter("hdnSfsContext") != null && request.getParameter("hdnSfsContext").trim() != "")
	{
	 
		fSfsContext = ((String)request.getParameter("hdnSfsContext"));
	}


            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(fSpecialityName ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(fNursingUnitName ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(fPractitionerName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(fSpecialityId ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(fSpecialityName ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(fNursingUnitId ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(fNursingUnitName ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(fPractitionerId ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fPractitionerName ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fSfsContext ));
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
