package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.ScheduleHelper;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;
import portalrefimpl.schedule.rescheduleappointment.response.RescheduleAppointmentResponse;

public final class __rescheduleapptreqresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/RescheduleApptReqResult.jsp", 1669269355984L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Patient Portal - Reschedule Appointment Request - Result</title>\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<style scoped>\r\n#popwrapperbooked\r\n{\r\n\twidth:575px;\r\n\theight:auto;\r\n\tbackground-color:#ffffff;\r\n\t-moz-box-shadow: 0px 0px 10px  #ADADAD;\r\n\t-webkit-box-shadow: 0px 0px 10px  #ADADAD;\r\n\tbox-shadow: 0px 0px 10px  #ADADAD;\r\n}\r\n\r\n#popmsgboxbooked\r\n{\r\n\twidth:564px;\r\n\theight:auto;\r\n\tmargin:5px 5px 5px 4px;\r\n\tborder:#92b82d solid 1px;\r\n\tbackground-color:#ffffff;\r\n\tdisplay:table;\r\n}\r\n\r\n</style>\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n\r\n<div id=\"popwrapperbooked\">\r\n\t\r\n<div id=\"popheader\">\r\n<div class=\"row\">\r\n\t\t<div id=\"poptitle\">Details\r\n        </div>\r\n        <div id=\"close\">x\r\n        </div>\r\n    \r\n</div>\r\n</div>\r\n\r\n<div id=\"popmsgboxbooked\">\r\n\r\n<div id=\"resultholder\">\r\n\t<div class=\"row\">\r\n    \t\r\n        <div id=\"resultcell\">\r\n       ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n       \t\t<span id=\"resulttitle\">Appointment request was not rescheduled. System error</span>\r\n       \t\t<div style=\"min-height: 100px;\"></div>\r\n       \t\t<span><a href=\"#\" onclick=\"postOperation(\'1\')\" class=\"popbtncenter\">Ok</a></span>\r\n       ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \r\n       \t\t<span id=\"resulttitle\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\r\n       \t\t<div style=\"min-height: 100px;\"></div>\r\n       \t\t<span><a href=\"#\" onclick=\"postOperation(\'1\')\" class=\"popbtncenter\">Ok</a></span>\r\n       ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t\t        <span id=\"resulttitle\">Appointment rescheduled successfully</span>\r\n\t\t\t\t<div class=\"bookedDetails\">\r\n\t\t\t\t\t<div class=\"bookedcontent\">\r\n\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =",</span><span class=\"contentnormal\"> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span><br/>\r\n\t\t\t\t\t\t<div class=\"popupoverflow\" >\r\n\t\t\t\t\t\t\t<div class=\"floatleft\">\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormalpopup\">Appointment Request Date and Time</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"floatleft\">\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">:&nbsp;</span><span class=\"contenbold\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =", ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span><br/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t    \t<span><a href=\"#\" onclick=\"postOperation(\'2\')\" class=\"popbtncenter\">Ok</a></span>    \r\n        ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n      \t</div>\r\n        \r\n    </div>\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

RescheduleAppointmentResponse rescheduleApptReqResponse = (RescheduleAppointmentResponse) request.
							getAttribute(RescheduleRequestConstants.RESCHEDULE_APPTREQ_RESPONSE_PARAM);


            _bw.write(_wl_block2Bytes, _wl_block2);

       	if(rescheduleApptReqResponse == null){
       
            _bw.write(_wl_block3Bytes, _wl_block3);

       	}else{
       		/* ErrorInfo errorInfo = bookApptResponse.getErrorInfo();
       		int errorCode = errorInfo.getErrorCode(); */
	       	/* if(ErrorInfo.SUCCESS_CODE != errorCode){ */
	       	if(!rescheduleApptReqResponse.isSuccessful()){	
	       		String errorMessage = rescheduleApptReqResponse.getErrorMessage();
       
            _bw.write(_wl_block4Bytes, _wl_block4);
out.println(errorMessage);
            _bw.write(_wl_block5Bytes, _wl_block5);

      		 }else{
    	   		String practitionerName = request.getParameter(
    	   					RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM);
    	   		if(practitionerName == null){
    	   			practitionerName = "";
    	   		}
    	   		String selectedSpecialtyDesc = request.getParameter(
    	   					RescheduleRequestConstants.HIDDEN_SPECIALTY_DESC_PARAM);
    	   		if(selectedSpecialtyDesc == null){
    	   			selectedSpecialtyDesc = "";
    	   		}
    	   		
    	   		String preferredDate = request.getParameter
    	   				(RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM);
    	   		if(preferredDate == null){
    	   			preferredDate = "";
    	   		}
    	   		String preferredDateDisplayStr = ScheduleHelper
						.getPreferredDateInDisplayFormat(
								preferredDate,
								RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT,
								RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT2);
    	   		
    	   		String selectedTimeSlot = request.getParameter
    	   				(RescheduleRequestConstants.SELECTED_TIMESLOT_PARAM);
    	   		if(selectedTimeSlot == null){
    	   			selectedTimeSlot = "";
    	   		}
       
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(practitionerName ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(selectedSpecialtyDesc ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(preferredDateDisplayStr ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selectedTimeSlot ));
            _bw.write(_wl_block10Bytes, _wl_block10);

      		 }
       	}
        
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
