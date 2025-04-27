package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.contactreason.common.model.ContactReasonModel;
import java.util.List;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.contactreason.cancelappointment.response.ContactReasonForCancelApptResponse;
import portalrefimpl.contactreason.cancelappointment.svc.ContactReasonForCancelApptServiceInvoker;
import java.util.Locale;
import portalrefimpl.PortalConstants;
import portalrefimpl.schedule.common.request.AppointmentType;
import portalrefimpl.contactreason.cancelappointment.request.ContactReasonForCancelApptRequest;
import portalrefimpl.schedule.ScheduleConstants;

public final class __cancelappconfirm extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/CancelAppConfirm.jsp", 1669269355953L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>::: Confirm cancel appointment :::</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n\r\n<script>\r\nfunction cancelAppointment(appointmentNumber,appointmentStatus,facilityId){\r\n\tvar cancelReasonComp = document.getElementById(\"cancelAppReason\");\r\n\tif(cancelReasonComp){\r\n\t\tvar selectedReasonCode = cancelReasonComp.value;\r\n\t\tif(selectedReasonCode.length == 0){\r\n\t\t\talert(\'Please select cancellation reason\');\r\n\t\t\treturn false;\r\n\t\t}\r\n\t\tcancelAppointmentMain(appointmentNumber,appointmentStatus,facilityId,selectedReasonCode);\r\n\t}\r\n\t\r\n}\r\n\r\n\r\n</script>\r\n\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n\r\n<div id=\"popwrapperbooked\">\r\n\t<div id=\"popheader\">\r\n\t\t<div class=\"row\">\r\n\t\t\t\t<div id=\"poptitle\">Confirmation\r\n\t\t        </div>\r\n\t\t        <div id=\"close\" onclick=\"closeConfirmCancelAppointmentPopup()\">x\r\n\t\t        </div>\r\n\t\t</div>\r\n\t</div>\r\n\r\n\t<div id=\"popmsgboxbooked\">\r\n\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\t\t<div style=\"min-height: 25px;\">\r\n\t\t\t<span class=\"loginerror\" style=\"padding-left: 10px;margin-top: 5px;\">";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\t\t\t</span>\r\n\t\t</div>\r\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t<div id=\"resultholder\">\r\n\t\t\t<div class=\"row\">\r\n\t\t        <div id=\"resultcell\">\r\n\t\t\t\t\t<div class=\"bookedDetails\" >\r\n\t\t\t\t\t\t<div class=\"bookedcontent\" >\r\n\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =",</span><span class=\"contentnormal\"> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span><br/>\r\n\t\t\t\t\t\t<div class=\"popupoverflow\">\r\n\t\t\t\t\t\t\t<div class=\"floatleft\">\r\n\t\t\t\t\t\t\t\t<span  class=\"contentnormalpopup\" >Appointment No</span><span class=\"contentnormalpopup\">Appointment Date and Time</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"floatleft\">\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">:&nbsp;</span><span class=\"contenbold\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span><br>\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">:&nbsp;</span><span class=\"contenbold\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =", ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" - ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span><br/>\r\n\t\t\t\t\t\t\t\t<!-- <span class=\"contentnormal\">:&nbsp;</span><span class=\"contenbold\">27 Jan 2013, 10:00 - 10.30</span><br/> -->\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"CancelpopupFields\">\r\n\t\t\t\t\t\t<div class=\"bookedcontent\">\r\n\t\t\t\t\t\t\t<div class=\"popupoverflow\">\r\n\t\t\t\t\t\t\t\t<div class=\"floatleft\">\r\n\t\t\t\t\t\t\t\t\t<span  class=\"contentnormalCancelpopup\" >Reason</span>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t<div class=\"floatleft\">\r\n\t\t\t\t\t\t\t\t\t<select class=\"Combotimesearchcancelpopup\" id=\"cancelAppReason\" name=\"cancelAppReason\">\r\n\t\t\t\t\t\t\t\t\t\t<option value=\"\">---- Select ----</option>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t</select>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<span class=\"contentnormal\">Click </span><span class=\"contenbold\">\"Ok\"</span><span class=\"contentnormal\"> to confirm details</span><br>\r\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\r\n\t\t        \t<span><a href=\"#\"  onclick=\"cancelAppointment(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\" class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">Ok</a></span> \r\n\t\t\t\t\t<span><a href=\"#\"  onclick=\"closeConfirmCancelAppointmentPopup()\" class=\"popbtncenter\">Cancel</a></span><br>\r\n\t\t\t\t\t\t\t\t\r\n\t\t        </div>\r\n\t\t    </div>\r\n\t\t</div>\r\n\t\r\n\t</div>\r\n</div>\r\n<!-- #wrapper -->\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String appointmentNumber = request.getParameter("appointmentNumber");
String appointmentStatus = request.getParameter("status");
String specialty = request.getParameter("specialty");
String facilityId = request.getParameter("facilityId");
String practitionerName = request.getParameter("practitionerName");
String appointmentDate = request.getParameter("appointmentDate");
String startTime = request.getParameter("startTime");
String endTime = request.getParameter("endTime");

// there is a need to get the reasons for cancel appointment
ContactReasonForCancelApptRequest contactReasonRequest = new ContactReasonForCancelApptRequest();
if(ScheduleConstants.CANCELAPPT_APPT_REQUEST_TYPE_IDENTIFIER.equals(appointmentStatus)){
	contactReasonRequest.setAppointmentType(AppointmentType.Appointment_Request);
}else if(ScheduleConstants.CANCELAPPT_APPT_IDENTIFIER.equals(appointmentStatus)){
	contactReasonRequest.setAppointmentType(AppointmentType.Appointment);
}

String patientId = "";
patientId = (String) session.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
if (patientId == null) {
	patientId = (String) getServletConfig().getServletContext()
			.getAttribute("patientId");
	if (patientId == null) {
		patientId = "";
	}
}

contactReasonRequest.setPatientId(patientId);
contactReasonRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
contactReasonRequest.setLocale(Locale.getDefault().getLanguage());

/* ContactReasonForCancelApptSvcImpl svcImpl = new ContactReasonForCancelApptSvcImpl();
svcImpl.registerService(contactReasonRequest); */

ContactReasonForCancelApptServiceInvoker serviceInvoker = new ContactReasonForCancelApptServiceInvoker();
serviceInvoker.registerService(contactReasonRequest);
ContactReasonForCancelApptResponse contactReasonResponse = (ContactReasonForCancelApptResponse) serviceInvoker.getDataThroughWebService(contactReasonRequest);

/* ErrorInfo errorInfo = contactReasonResponse.getErrorInfo();
int errorCode = errorInfo.getErrorCode();
 */
String errorMessage = null;//errorInfo.getErrorMessage();

            _bw.write(_wl_block2Bytes, _wl_block2);

			if(!contactReasonResponse.isSuccessful()){
				errorMessage = contactReasonResponse.getErrorMessage();
		
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(errorMessage ));
            _bw.write(_wl_block4Bytes, _wl_block4);

			}
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(practitionerName ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(specialty ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(appointmentNumber ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(appointmentDate ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(startTime ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(endTime ));
            _bw.write(_wl_block11Bytes, _wl_block11);

										List<ContactReasonModel> contactReasonModelList = null;
										if(contactReasonResponse.isSuccessful()){
											contactReasonModelList = contactReasonResponse.getContactReasonList();			
											if(!contactReasonModelList.isEmpty()){
												for(ContactReasonModel contactReason : contactReasonModelList){
														
										
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(contactReason.getCode() ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(contactReason.getDescription() ));
            _bw.write(_wl_block14Bytes, _wl_block14);

												}
											}
										}
										
            _bw.write(_wl_block15Bytes, _wl_block15);

					String okButtonStyle = "popbtncenter";
					if(!contactReasonResponse.isSuccessful()){
						okButtonStyle = "cancelApptConfirmOkDisabled";
					}
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appointmentNumber ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(appointmentStatus ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(okButtonStyle));
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
