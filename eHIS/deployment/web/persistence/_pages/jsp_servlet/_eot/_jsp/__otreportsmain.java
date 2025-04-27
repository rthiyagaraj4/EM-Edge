package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.*;
import java.sql.Types;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;

public final class __otreportsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OtReportsMain.jsp", 1722255370353L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n\t<script src=\"../../eOT/js/OtReports.js\" ></script>\n\t<script src=\"../../eCommon/js/dchk.js\" ></script>\n\t<script src=\"../../eCommon/js/common.js\" ></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script src=\"../../eOT/js/OTCommon.js\" ></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\t\n</head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script language=\"javascript\" src=\"../../eOT/js/TopOperationRep.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n    <iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" scrolling=\'no\' noresize style=\"height:8vh;width:100vw\" frameborder=\'0\'></iframe>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<iframe scrolling=\"no\" name=\'f_query_rep\' id=\'f_query_rep\' src=\'../../eOT/jsp/CaseSlipReports.jsp\' style=\"height:85vh;width:100vw\"  frameborder=\'0\'></iframe>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\talert(getMessage(\"CA_NOT_INSTALLED\",\"Common\"));\n\t\t\twindow.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<iframe scrolling=\"no\" name=\'f_query_rep\' id=\'f_query_rep\' src=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" style=\"height:85vh;width:100vw\" frameborder=\'0\'>\t</iframe>\t\t\t\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' noresize scrolling=\'auto\' style=\"height:7vh;width:100vw\" frameborder=\'0\'></iframe>\n\t<iframe name=\'dummy_rep_frame\' id=\'dummy_rep_frame\' src=\"../../eCommon/html/blank.html\" noresize scrolling=\'no\' style=\"height:7vh;width:100vw\" frameborder=\'0\'></iframe>\n\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String function_id = request.getParameter("function_id");
	String source = url + params ;
	String url_name = "";
	String facility_id  = (String) session.getValue("facility_id");
	String customer_id = request.getParameter("CUST_ID");
	Connection con=null;
	CallableStatement cstmt = null;
	String modules_list = "";
	String ca_module_yn="";

	try{
		con = ConnectionManager.getConnection(request);
	// Check for CA Module Existence
		cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("OR|")>=0)
			ca_module_yn="Y";	// When CA is  Operational
		else
			ca_module_yn="N";	// When CA is not Operational
	}catch(Exception e){
		out.println(e);
	}finally { 
		if(cstmt !=null) cstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
	String ca_alert_required_yn = "N";

	if(function_id.equals("OT_OPERATION_LIST")){
		ca_alert_required_yn = "Y";
		url_name = "OperationListReports.jsp";
	}else if(function_id.equals("OT_RGSTR_OPER")){
		ca_alert_required_yn="Y";
		url_name = "OperationRegisterReports.jsp";
	}else if(function_id.equals("OT_OPER_BY_OT_ROOM")){
		ca_alert_required_yn="Y";
		url_name = "OperationByOtRoomReports.jsp";
	}else if(function_id.equals("OT_OPER_BY_SURGEON")){
		ca_alert_required_yn="Y";
		url_name = "OperationBySurgeonReports.jsp";
	}else if(function_id.equals("OT_OPER_BY_ANAESTHETIST")){
		ca_alert_required_yn="Y";
		url_name = "OperationByAnaesthetistReports.jsp";
	}else if(function_id.equals("OT_CANCELLED_REGISTRATIONS")){
		ca_alert_required_yn="Y";
		url_name = "CancelledRegistrationsReports.jsp";
	}else if(function_id.equals("OT_IMPLANT_REGISTRY")){
		ca_alert_required_yn="Y";
		url_name = "ImplantRegistryReports.jsp";
	}
	//AMRI-CRF-0294-US2
	else if(function_id.equals("OT_CANCELLED_OT_EQUIPMENTS")){
		ca_alert_required_yn="Y";
		url_name = "CancelOTEquipmentsReports.jsp";
	}//AMRI-CRF-0294-US2
	else if(function_id.equals("OT_REGISTRY_BDY_PART_SPECIMEN")){
		ca_alert_required_yn="Y";
		url_name = "RegistryBodyPartsNonSpecimenReports.jsp";
	}else if(function_id.equals("OT_SPECIMEN_REGISTER")){
		ca_alert_required_yn="Y";
		url_name = "SpecimenRegisterReports.jsp";
	}else if(function_id.equals("OT_EMERGENCY_OPERATIONS")){
		ca_alert_required_yn="Y";
		if (customer_id.equals("BR")) 
		url_name = "EmergencyOperationsReports_BR.jsp";
		else
		url_name = "EmergencyOperationsReports.jsp";
		
	}else if(function_id.equals("OT_OPERATION_NOTES")){
		ca_alert_required_yn="Y";
		url_name = "OperationNotesReports.jsp";
	}else if(function_id.equals("OT_TH_BKG_STAT_OTROOM")){
		url_name = "TheatreBkgStatByOtRoomReports.jsp";
	}else if(function_id.equals("OT_TH_BKG_STAT_SURGEON")){
		url_name = "TheatreBkgStatByOtSurgeonReports.jsp";
	}else if(function_id.equals("OT_TH_BKGS_BY_SURGEON")){
		url_name = "TheatreBookingsBySurgeonReports.jsp";
	}else if(function_id.equals("OT_TH_BKGS_BY_OTROOM")){
		url_name = "TheatreBookingsByOtRoomReports.jsp";
	}else if(function_id.equals("OT_PAT_TOBE_ADMITTED")){
		url_name = "PatientsToBeAdmittedForOperReports.jsp";
	}else if(function_id.equals("OT_WAITLIST_REPORT_BY_DSS")){
		url_name = "WaitlistReports.jsp";
	}else if(function_id.equals("OT_CANCELLED_BOOKINGS")){
		url_name = "CancelledBookingsReports.jsp";
	}else if(function_id.equals("OT_SMRY_OF_OPER_BY_OTROOM")){
		ca_alert_required_yn="Y";
		url_name = "SummaryOfOperByOtRoomReports.jsp";
	}else if(function_id.equals("OT_SMRY_OF_OPER_BY_SURGEON")){
		ca_alert_required_yn="Y";
		url_name = "SummaryOfOperBySurgeonReports.jsp";
	}else if(function_id.equals("OT_WAITING_TIME_BYSURGEON")){
		url_name = "WaitingTimeBySurgeonReports.jsp";
	}else if(function_id.equals("OT_SMRY_OF_OPER_BY_ANAESTH")){
		ca_alert_required_yn="Y";
		url_name = "SmryOfOperByAnaesthetistReports.jsp";
	}else if(function_id.equals("OT_SURG_AVG_OPRTG_TIME")){
		ca_alert_required_yn="Y";
		url_name = "SurgeonsAvgOperatingTimeReports.jsp";//Commented By MuthuN for Testing CRF-008
	//	url_name = "TurnAroundTimeReports.jsp";//Added MuthuN CRF-008
	}else if(function_id.equals("OT_TURN_AROUND_TIME")){
		ca_alert_required_yn="Y";
		//url_name = "SurgeonsAvgOperatingTimeReports.jsp";//Commented By MuthuN for Testing CRF-008
		url_name = "TurnAroundTimeReports.jsp";//Added MuthuN CRF-008
	}
	else if(function_id.equals("OT_AVG_TIME_FOR_PROCEDURE")){
		ca_alert_required_yn="Y";
		url_name = "AvgTimeTakenForProceduresReports.jsp";
	}else if(function_id.equals("OT_SUR_AVG_TIME")){
		ca_alert_required_yn="Y";
		url_name = "SurgeonsOperTimeStatReports.jsp";
	}else if(function_id.equals("OT_BOOKING_SUMMARY")){
		url_name = "BookingSummaryReport.jsp";
	}else if(function_id.equals("OT_OPER_WITHOUT_OPER_DTLS")){
		ca_alert_required_yn="Y";
		url_name = "OperWithoutPostOperDtlsReports.jsp";
	}else if(function_id.equals("OT_OPERATIVE_MORTALITY")){
		ca_alert_required_yn="Y";
		url_name = "OperativeMortalityReports.jsp";
	}else if(function_id.equals("OT_NOTIF_LIST_BY_OTROOM")){
		url_name = "NotifListByOtRoomReports.jsp";
	}else if(function_id.equals("OT_NOTIF_LIST_BY_WARD")){
		url_name = "NotifListByWardReports.jsp";
	}else if(function_id.equals("OT_STAT_BY_SPECIALITY")){
		ca_alert_required_yn="Y";
		url_name = "StatBySpecialityReports.jsp";
	}else if(function_id.equals("OT_STAT_BY_OPER_TYPES")){
		ca_alert_required_yn="Y";
		url_name = "StatByOperationTypesReports.jsp";
	}else if(function_id.equals("OT_STAT_BY_OPER_DURATION")){
		ca_alert_required_yn="Y";
		url_name = "StatByOperDurationReports.jsp";
	}else if(function_id.equals("OT_THEATER_UTILIZATION")){
		ca_alert_required_yn="Y";
		url_name = "TheatreUtilizationReports.jsp";
	}else if(function_id.equals("OT_TYPE_OF_ANAESTHESIA")){
		ca_alert_required_yn="Y";
		url_name = "TypeOfAnesthesiaReports.jsp";
	}else if(function_id.equals("OT_ANESTH_TYPE_PROC")){
		ca_alert_required_yn="Y";
		url_name = "AnesthGivenForSurgeryTypeReports.jsp";
	}else if(function_id.equals("OT_ANESTH_REGISTRY")){
		ca_alert_required_yn="Y";
		url_name = "AnesthesiaRegistryReports_SRR.jsp";
	}else if(function_id.equals("OT_STAT_BY_OPER_TYPE_SPLTY")){
		ca_alert_required_yn="Y";
		url_name = "StatbyOperTypeSpltyReports.jsp";
	}else if(function_id.equals("OT_ICU_BED_REQUIRED")){
		url_name = "IcdBedReservationsReports.jsp";
	}else if(function_id.equals("OT_OTMS_BY_SURGERY_TYPE")){
		ca_alert_required_yn="Y";
		url_name = "OtmsBySurgeryTypeReports.jsp";
	}else if(function_id.equals("OT_OTMS_BY_OPER_TYPE")){
		ca_alert_required_yn="Y";
		url_name = "OtmsByOperationTypeReports.jsp";
	}else if(function_id.equals("OT_BCP_REPORTS")){
		ca_alert_required_yn="Y";
		url_name = "OtBcpReports.jsp";
	}else if(function_id.equals("OT_TOP_OPERATION_REP")){
		ca_alert_required_yn="Y";
		url_name = "TopOperationReport.jsp"; 
            _bw.write(_wl_block5Bytes, _wl_block5);
}
	/*else if(function_id.equals("OT_CANCELLED_REGISTRATIONS_SRR")){
		ca_alert_required_yn="Y";
		url_name = "CancelledRegistrationsReports_SRR.jsp";
	}else if(function_id.equals("OT_SURG_AVG_OPRTG_TIME_SRR")){
		ca_alert_required_yn="Y";
		url_name = "SurgeonsAvgOperatingTimeReports_SRR.jsp";
	}else if(function_id.equals("OT_SMRY_OF_OPER_BY_OTROOM_SRR")){
		ca_alert_required_yn="Y";
		url_name = "SummaryOfOperByOtRoomReports_SRR.jsp";
	}else if(function_id.equals("OT_THEATER_UTILIZATION_SRR")){
		ca_alert_required_yn="Y";
		url_name = "TheatreUtilizationReports_SRR.jsp";
	}else if(function_id.equals("OT_AVG_TIME_FOR_PROCEDURE_SRR")){
		ca_alert_required_yn="Y";
		url_name = "AvgTimeTakenForProceduresReports_SRR.jsp";
	}else if(function_id.equals("OT_TYPE_OF_ANAESTHESIA_SRR")){
		ca_alert_required_yn="Y";
		url_name = "TypeOfAnesthesiaReports_SRR.jsp";
	}else if(function_id.equals("OT_SMRY_OPER_BY_NURSE_SRR")){
		ca_alert_required_yn="Y";
		url_name = "SummaryOfOperByNurseReports.jsp";
	}else if(function_id.equals("OT_UNSCHOPERATION_LIST_SRR")){
		ca_alert_required_yn="Y";
		url_name = "UnscheduledOperationReports.jsp";
	}else if(function_id.equals("OT_UNUSUAL_OCCURRENCE")){  //OT_UNUSUAL_OCCURRENCE_SRR
		ca_alert_required_yn="Y";
		url_name = "UnusualOccurrenceReports.jsp";
	}else if(function_id.equals("OT_WAITING_TIME_BY_ADMIT")){
		ca_alert_required_yn="Y";
		url_name = "OTWaitingTimeByAdmitReports.jsp";
	}else if(function_id.equals("OT_WAITING_TIME_IN_OR")){// OT_WAITING_TIME_IN_OR_SRR
		ca_alert_required_yn="Y";
		url_name = "OTWaitingTimeInORtReports.jsp";
	}*/
	//Added against MMS-QH-CRF-0215
	else if(function_id.equals("OT_OR_STATISTICS_CATEGORY")){
		url_name = "ORStatisticsByCategorization.jsp";
	}
	//Added against AAKH-CRF-0071
	else if(function_id.equals("OT_BOOKING_OR_LIST")){
		url_name = "BookingOTRoomReports.jsp";
	}
	url_name="../../eOT/jsp/"+url_name+"?"+params;

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block7Bytes, _wl_block7);

		if(function_id.equals("CASE_SLIP")){
	
            _bw.write(_wl_block8Bytes, _wl_block8);

		}else if(ca_module_yn.equals("N") && ca_alert_required_yn.equals("Y")){
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		}else{
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(url_name));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
	
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
