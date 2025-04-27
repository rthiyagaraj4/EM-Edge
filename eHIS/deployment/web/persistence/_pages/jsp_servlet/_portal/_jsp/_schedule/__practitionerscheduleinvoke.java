package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;

public final class __practitionerscheduleinvoke extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/PractitionerScheduleInvoke.jsp", 1669269355969L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Insert title here</title>\r\n<script>\r\n$(document).ready(function() {\r\n\talert(\"in function \");\r\n\tsubmitPage();\r\n\t//alert($(\"#ApptPreferredDate\").val());\r\n\t//$(\"#practitionerScheduleForm\").attr(\"action\",\"./PractitionerScheduleServlet\");\r\n\t//$(\"#practitionerScheduleForm\").submit();\r\n});\r\n\r\nfunction submitPage(){\r\n\talert(\"in submit function \");\r\n\tvar formComp = document.getElementById(\"practitionerScheduleForm\");\r\n\tif(formComp){\r\n\t\talert(\"form is initialized\");\r\n\t\tformComp.action = \"./PractitionerScheduleServlet\";\r\n\t\tformComp.submit();\r\n\t}\r\n\t//alert($(\"#ApptPreferredDate\").val());\r\n}\r\n\r\n</script>\r\n</head>\r\n<body onload=\"submitPage()\">\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<form id=\"practitionerScheduleForm\" method=\"POST\">\r\n\r\n<input type=\"hidden\" name=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" id=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\r\n<input type=\"hidden\" name=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\r\n\r\n</form>\r\n\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String preferredDateStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
	if (preferredDateStr == null) {
		preferredDateStr = "";
	}

	String preferredFromTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (preferredFromTime == null) {
		preferredFromTime = "";
	}

	String preferredToTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY);
	if (preferredToTime == null) {
		preferredToTime = "";
	}

	String selectedFacilityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY);
	if(selectedFacilityId == null){
		selectedFacilityId = "";
	}
	
	String selectedFacilityDesc = request.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY);
	if(selectedFacilityDesc == null){
		selectedFacilityDesc = "";
	}
	
	String selectedSpecialityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY);
	if(selectedSpecialityId == null){
		selectedSpecialityId = "";
	}
	
	String selectedSpecialityDesc = request.getParameter(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY);
	if(selectedSpecialityDesc == null){
		selectedSpecialityDesc = "";
	}
	
	String practitionerId = request.getParameter(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY);
	if(practitionerId == null){
		practitionerId = "";
	}
	
	String practitionerName = request.getParameter(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY);
	if(practitionerName == null){
		practitionerName = "";
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(preferredDateStr));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(preferredFromTime));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(preferredToTime));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(selectedFacilityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(selectedFacilityDesc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(selectedSpecialityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(selectedSpecialityDesc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(practitionerId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
