package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Locale;
import portalrefimpl.PortalConstants;
import java.util.Map;
import portalrefimpl.schedule.ScheduleHelper;
import java.util.Calendar;
import portalrefimpl.PortalHelper;
import java.util.Date;
import portalrefimpl.schedule.createappointment.response.Schedule;
import java.util.List;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleResponse;
import portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerScheduleServiceInvoker;
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleRequest;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;

public final class __practitionerschedule extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/PractitionerSchedule.jsp", 1669269355953L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Insert title here</title>\r\n\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<!-- <link rel=\"stylesheet\" href=\"../../jquery/jquery.mobile-1.0a4.1.min.css\" /> \r\n<script src=\"../../jquery/jquery-1.5.2.min.js\"></script> \r\n<script src=\"../../jquery/jquery.mobile-1.0a4.1.min.js\"></script> -->\r\n\r\n<script>\r\nfunction showLeftPanel(currentCounter,maxPanels){\r\n\tvar currentSectionComp = document.getElementById(\"section\"+currentCounter);\r\n\tif(currentSectionComp){\r\n\t\tcurrentSectionComp.style.display = \'none\';\r\n\t\tvar leftPanelCnt = 0;\r\n\t\ttry{\r\n\t\t\tleftPanelCnt = parseInt(currentCounter);\r\n\t\t}catch(e){\r\n\t\t\tleftPanelCnt = 0;\r\n\t\t}\r\n\t\tif(leftPanelCnt <= 0){\r\n\t\t\talert(\'System error - cannot view earlier records\');\r\n\t\t\tcurrentSectionComp.style.display = \'block\';\r\n\t\t}\r\n\t\t\r\n\t\tleftPanelCnt = leftPanelCnt - 1;\r\n\t\tvar leftPanel = document.getElementById(\"section\"+leftPanelCnt);\r\n\t\tif(leftPanel){\r\n\t\t\tleftPanel.style.display = \'block\';\r\n\t\t}\r\n\t}\r\n}\r\n\r\nfunction showRightPanel(currentCounter,maxPanels){\r\n\tvar currentSectionComp = document.getElementById(\"section\"+currentCounter);\r\n\tif(currentSectionComp){\r\n\t\tcurrentSectionComp.style.display = \'none\';\r\n\t\tvar rightPanelCnt = 0;\r\n\t\ttry{\r\n\t\t\trightPanelCnt = parseInt(currentCounter);\r\n\t\t}catch(e){\r\n\t\t\trightPanelCnt = 0;\r\n\t\t}\r\n\t\tvar maxPanelCnt = 0;\r\n\t\ttry{\r\n\t\t\tmaxPanelCnt = parseInt(maxPanels);\r\n\t\t}catch(e){\r\n\t\t\tmaxPanelCnt = 0;\r\n\t\t}\r\n\t\t\r\n\t\tif(maxPanelCnt == 0 || rightPanelCnt >= maxPanels){\r\n\t\t\talert(\'System error - cannot view future records\');\r\n\t\t\tcurrentSectionComp.style.display = \'block\';\r\n\t\t}\r\n\t\t\r\n\t\trightPanelCnt = rightPanelCnt + 1;\r\n\t\tvar rightPanel = document.getElementById(\"section\"+rightPanelCnt);\r\n\t\tif(rightPanel){\r\n\t\t\trightPanel.style.display = \'block\';\r\n\t\t}\r\n\t}\r\n}\r\n\r\n</script>\r\n\r\n</head>\r\n<body>\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div id=\"popwrapperbooked\"  style=\"width:615px;\">\r\n\t\r\n<div id=\"popheader\">\r\n<div class=\"row\">\r\n\t\t<div id=\"poptitle\">";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'s Schedule\r\n        </div>\r\n        \r\n\t\t<div id=\"close\" onclick=\"window.parent.closePractitionerSchedulePopup()\">x\r\n        </div>\r\n    \r\n</div>\r\n</div>\r\n\r\n<div id=\"popmsgboxbooked\" style=\"width:600px;min-height: 100px;\">\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<span class=\"loginerror\">\r\n   ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n</span>\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t<div id=\"resultholder\">\r\n\t\t<div class=\"row\">\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\r\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t<div id=\"section";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" style=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\r\n\t\t\t<div id=\"resultcell\">\r\n\t\t\t\t<!--  the overall table for display of this page -->\r\n\t\t\t\t<table border=\'0\' cellpadding=\"0\" cellspacing=\"0\" >\r\n        \t\t<tr>\r\n        \t\t<td>\r\n        \t\t<!--  table to show the left arrow -->\r\n\t\t\t\t\t<table border=\'0\' cellpadding=\"0\" cellspacing=\"0\" style=\"float:left;border-left:1px solid #CCCCCC;border-top:1px solid #CCCCCC;\">\r\n\t\t\t\t\t\t<th height=\"48px;\" style=\"width:50px;border-bottom:1px solid #D3D3D3;background-color:#DCE8C6;font-size:12px;color:#090000;\">\r\n\t\t\t\t\t\t\t<span class=\"contenbold\">\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t\t\t\t<img class=\"handcursor\" src=\"../../images/LeftArrow_Dis.png\"/>\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t\t\t\t\t\t\t<img class=\"handcursor\" onclick=\"showLeftPanel(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\" src=\"../../images/LeftArrow.png\"/>\r\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t\t\t\t\t</span>\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<tr style=\"width:50px;\">\r\n\t\t\t\t\t\t\t<td class=\"odd\" height=\"48px;\" style=\"font-size:12px;width:30px;\"></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr style=\"width:50px;\">\r\n\t\t\t\t\t\t\t<td class=\"odd\" height=\"48px;\" style=\"font-size:12px;width:30px;\"></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr style=\"width:50px;\">\r\n\t\t\t\t\t\t\t<td class=\"odd\" height=\"50px;\" style=\"border-bottom:1px solid #D3D3D3;font-size:12px;width:50px;\"></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td valign=\"top\">\r\n\t\t\t\t<!--  table to show the data -->\r\n\t\t\t\t<table border=\'0\' cellpadding=\"0\" cellspacing=\"0\" class=\"scheduleGrid\" style=\"height:100%;min-width: 430px;\">\r\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\r\n\t\t\t\t\t<th>\r\n\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<br>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\r\n\t\t\t\t\t\t</span>\r\n\t\t\t\t\t</th>\r\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\r\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" style=\"min-height: 48px;height:48px;\">&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\r\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" style=\"min-height: 48px;height:48px;\">\r\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\t\t\t\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n\t\t\t\t</table>\r\n\t\t\t\t<!--  end of the table which shows the data -->\t\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\'0\' cellpadding=\"0\" cellspacing=\"0\" style=\"float:left;border-right:1px solid #CCCCCC;border-top:1px solid #CCCCCC;\">\r\n\t\t\t\t<th height=\"48px;\" style=\"width:50px;border-bottom:1px solid #D3D3D3;background-color:#DCE8C6;font-size:12px;font-weight:normal;color:#090000;\">\r\n\t\t\t\t\t\t<span class=\"contenbold\">\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\r\n\t\t\t\t\t\t<img class=\"handcursor\" src=\"../../images/RightArrow_Dis.png\"/>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\r\n\t\t\t\t\t\t<img class=\"handcursor\" onclick=\"showRightPanel(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\" src=\"../../images/RightArrow.png\"/>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</th>\r\n\t\t\t\t<tr style=\"font-size:12px;\">\r\n\t\t\t\t\t\t<td class=\"odd\" height=\"48px;\" style=\"font-size:12px;\"></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr style=\"font-size:12px;\">\r\n\t\t\t\t\t\t<td class=\"odd\" height=\"48px;\" style=\"font-size:12px;\"></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr style=\"font-size:12px;\">\r\n\t\t\t\t\t\t<td class=\"odd\" height=\"50px;\" style=\"border-bottom:1px solid #D3D3D3;font-size:12px;\"></td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n        </table>\r\n\t\t\t\t\r\n        </div>\r\n      <!-- </section> -->\r\n      </div>\r\n      \r\n      ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\r\n        \r\n    </div>\r\n</div>\r\n\r\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\r\n\r\n</div>\r\n</div>\r\n\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	// get the patient id
	String patientId = "";
	patientId = (String) session
			.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
	//patientId = request.getParameter("patientId");
	if (patientId == null) {
		patientId = (String) getServletConfig().getServletContext()
				.getAttribute("patientId");
		if (patientId == null) {
			patientId = "";
		}
	}

	// now get the individual request parameters
	String preferredDateStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
	if (preferredDateStr == null) {
		preferredDateStr = "";
	}
	// convert the date value in string to a date object
	// this is useful later on
	Date preferredDate = PortalHelper
			.getDateFromString(
					preferredDateStr,
					CreateAppointmentConstants.PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT);

	String preferredFromTimeStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (preferredFromTimeStr == null) {
		preferredFromTimeStr = "";
	}

	String preferredToTimeStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY);
	if (preferredToTimeStr == null) {
		preferredToTimeStr = "";
	}

	String facilityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY);
	if (facilityId == null) {
		facilityId = "";
	}

	String facilityDesc = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY);
	if (facilityDesc == null) {
		facilityDesc = "";
	}

	String specialityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY);
	if (specialityId == null) {
		specialityId = "";
	}

	String specialityDesc = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY);
	if (specialityDesc == null) {
		specialityDesc = "";
	}

	String practitionerId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY);
	if (practitionerId == null) {
		practitionerId = "";
	}

	String practitionerName = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY);
	if (practitionerName == null) {
		practitionerName = "";
	}

	System.out.println("Preferred date =" + preferredDateStr);

	//code to get the list of practitioners goes here
	PractitionerScheduleRequest practitionerScheduleRequest = new PractitionerScheduleRequest();
	practitionerScheduleRequest.setPatientId(patientId);
	practitionerScheduleRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	practitionerScheduleRequest.setPractitionerId(practitionerId);
	practitionerScheduleRequest.setSpecialityCode(specialityId);
	practitionerScheduleRequest.setSpecialityDesc(specialityDesc);
	// need to set other request parameters as well
	// facility id
	practitionerScheduleRequest.setFacilityId(facilityId);
	practitionerScheduleRequest.setFacilityDesc(facilityDesc);
	// preferred date
	practitionerScheduleRequest
			.setPreferredDateAsString(preferredDateStr);
	practitionerScheduleRequest
			.setPreferredStartTime(preferredFromTimeStr);
	practitionerScheduleRequest.setPreferredEndTime(preferredToTimeStr);
	practitionerScheduleRequest.setLocale(Locale.getDefault().getLanguage());
	practitionerScheduleRequest
			.setOperationStandardId(CreateAppointmentConstants.PRACTITIONER_SERVICE_OPRSTN_DEFAULT_VALUE);
	practitionerScheduleRequest
			.setResourceClass(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);

	/* PractitionerScheduleSvcImpl practitionerScheduleSvcImpl = new PractitionerScheduleSvcImpl();
	practitionerScheduleSvcImpl
			.registerService(practitionerScheduleRequest); */

	PractitionerScheduleServiceInvoker practScheduleServiceInvoker = new PractitionerScheduleServiceInvoker();
	practScheduleServiceInvoker.registerService(practitionerScheduleRequest);
	PractitionerScheduleResponse practScheduleResponse = (PractitionerScheduleResponse)practScheduleServiceInvoker
			.getDataThroughWebService(practitionerScheduleRequest);

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(practitionerName));
            _bw.write(_wl_block3Bytes, _wl_block3);

	ErrorInfo practErrorInfo = practScheduleResponse.getErrorInfo();
	String errorMessage = null;
	/* if (ErrorInfo.SUCCESS_CODE != practErrorInfo.getErrorCode()) { */
	if (!practScheduleResponse.isSuccessful()) {	
		errorMessage = practScheduleResponse.getErrorMessage();

            _bw.write(_wl_block4Bytes, _wl_block4);

   	out.println(errorMessage);
   
            _bw.write(_wl_block5Bytes, _wl_block5);

	} else {
		// code to populate the schedule information comes here
		List<Schedule> scheduleList = practScheduleResponse
				.getScheduleList();
		// schedule list will be not null and not empty - hence no need
		// to have safe checks
		
		// this code is to calculate the last date to be shown in the GUI 
		// the preferred date should be not null
		Date endDate = preferredDate;
		Calendar startDateCalendar = Calendar.getInstance();
		Calendar endDateCalendar = Calendar.getInstance();
		Calendar runningDateCalendar = Calendar.getInstance();
		if(preferredDate != null){
			startDateCalendar.setTime(preferredDate);
			endDateCalendar.setTime(preferredDate);
			endDateCalendar.add(Calendar.DATE, CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE);
			endDate = endDateCalendar.getTime();
			//runningDateCalendar.setTime(preferredDate);
		}
		
		// the practitioner schedule data is manipulated
		// to return data with which the GUI can be shown
		Map<Date,List<Schedule>> scheduleMap = ScheduleHelper.
						getPractitionerScheduleForDisplay(practScheduleResponse);
		
		// the total number of dates to be shown is always a constant as of now
		// it has a value 30
		int totalDatesToShow = CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE;
		int viewRange = 0;
		int runningCounter = 0;
		// constant denoting the number of weeks till which we need to iterate
		final int NO_OF_WEEKS = 5;
		//int dateCounter = 1;
		Date currentDateSnapshot = preferredDate; 
		
            _bw.write(_wl_block6Bytes, _wl_block6);

		String divDisplayStyle = "display:block";
		// iterate the dates from the preferred date to 30 days in future 
		for(int weekCounter=1;weekCounter <= NO_OF_WEEKS;weekCounter++){
			viewRange = CreateAppointmentConstants.BOOKAPPT_SCHEDULE_VIEW_RANGE;
			if((totalDatesToShow - runningCounter) < CreateAppointmentConstants.BOOKAPPT_SCHEDULE_VIEW_RANGE){
				viewRange = totalDatesToShow - runningCounter;
			}
			
			if(weekCounter > 1){
				divDisplayStyle = "display : none";
			}
			
			runningDateCalendar.setTime(currentDateSnapshot);
			//currentDateSnapshot = runningDateCalendar.getTime();
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(weekCounter ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(divDisplayStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

								if(weekCounter == 1){
							
            _bw.write(_wl_block11Bytes, _wl_block11);

								}else{
							
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(weekCounter ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(NO_OF_WEEKS ));
            _bw.write(_wl_block14Bytes, _wl_block14);

								}
							
            _bw.write(_wl_block15Bytes, _wl_block15);
	
				String dayOfWeek = null;
				Date calendarDate = null;
				String dateInDisplayFormat = null;
				// iteration to show the date for the week as header
				for(int dateCounter = 0;dateCounter < viewRange;dateCounter++){
					if(dateCounter > 0 || weekCounter > 1){
						runningDateCalendar.add(Calendar.DATE, 1);	
					}
					
					calendarDate = runningDateCalendar.getTime();
					dayOfWeek = PortalHelper.getDateAsString
							(calendarDate, CreateAppointmentConstants.PRACTITIONERSCHEDULE_DAYOFWEEK_FORMAT);
					dateInDisplayFormat = PortalHelper.getDateAsString
							(calendarDate, CreateAppointmentConstants.PRACTITIONERSCHEDULE_DATE_FORMAT);
					
					// increment the running counter as well
					runningCounter++;
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dayOfWeek ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dateInDisplayFormat ));
            _bw.write(_wl_block18Bytes, _wl_block18);

				}
				
				// reset the running calendar since we need to iterate once more 
				runningDateCalendar.setTime(currentDateSnapshot);
				List<Schedule> practScheduleList = null;
				Date tempDate = null;
				
				for(int count=0;count<CreateAppointmentConstants.PRACTITIONERSCHEDULE_DISPLAY_TIME_ZONE;count++){
				
            _bw.write(_wl_block19Bytes, _wl_block19);
	
					runningDateCalendar.setTime(currentDateSnapshot);
					String tdStyle = null;
					// iteration to show the schedule
					for(int dateCounter = 0;dateCounter < viewRange;dateCounter++){
						// reset the schedule list
						practScheduleList = null;
						// for setting style
						tdStyle = "even";
						if(dateCounter % 2 != 0){
							tdStyle = "odd";
						}
						
						if(dateCounter > 0 || weekCounter > 1){
							runningDateCalendar.add(Calendar.DATE, 1);	
						}
						tempDate = runningDateCalendar.getTime();
						if(scheduleMap.containsKey(tempDate)){
							practScheduleList = scheduleMap.get(tempDate);
						}
						if(practScheduleList == null || practScheduleList.isEmpty()){
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tdStyle));
            _bw.write(_wl_block21Bytes, _wl_block21);

						}else{
				
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tdStyle));
            _bw.write(_wl_block23Bytes, _wl_block23);

							if(practScheduleList.size() <= count){
				
            _bw.write(_wl_block24Bytes, _wl_block24);

							}else{
								Schedule scheduleObj = practScheduleList.get(count);
								String startTime = scheduleObj.getStartTime();
								String endTime = scheduleObj.getEndTime();
				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(startTime));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(endTime ));
            _bw.write(_wl_block26Bytes, _wl_block26);

							}
						}
					}
				
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
				
				// set the current date snapshot to running calendar's value
				currentDateSnapshot = runningDateCalendar.getTime();
				
				
            _bw.write(_wl_block28Bytes, _wl_block28);

							if(weekCounter == NO_OF_WEEKS){
						
            _bw.write(_wl_block29Bytes, _wl_block29);

							}else{
						
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(weekCounter ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(NO_OF_WEEKS ));
            _bw.write(_wl_block31Bytes, _wl_block31);

							}
						
            _bw.write(_wl_block32Bytes, _wl_block32);

		}
	  
            _bw.write(_wl_block33Bytes, _wl_block33);

	} // end of else loop which shows the practitioner schedule

            _bw.write(_wl_block34Bytes, _wl_block34);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
