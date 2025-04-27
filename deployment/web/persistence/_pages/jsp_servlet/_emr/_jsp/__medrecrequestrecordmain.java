package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __medrecrequestrecordmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedRecRequestRecordMain.jsp", 1733911692059L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t\n\t\t<iframe name=\'pline\' id=\'pline\' src=\"../../eCommon/jsp/pline.jsp?Patient_ID=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" frameborder=no scrolling=\'no\' style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'CurEnc\' id=\'CurEnc\' src=\'../jsp/MedicalReportResult.jsp?flag=true&PatientId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&request_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&call_function=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' noresize  frameborder=no scrolling=\'auto\' style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'DetailFrame\' id=\'DetailFrame\'  src=\'../jsp/MedRecRequestRecordDetail.jsp?LastDet=1&encounter_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patientId=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&finalSelect=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&new_func_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&selitem=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&from=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&to=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&req_status=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' noresize  frameborder=no scrolling=\'auto\'style=\'height:94vh;width:100vw\' ></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=no noresize scrolling=\'no\' style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'RecordButton\' id=\'RecordButton\'  src=\'../jsp/MedicalRequestButtons.jsp?encounter_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&called_from=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&request_status_des=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' noresize frameborder=no scrolling=\'no\' style=\'height:4vh;width:99vw\'></iframe>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t     <title>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</title>\n\t     \n\t\t<iframe name=\'pline\' id=\'pline\' \tsrc=\"../../eCommon/jsp/pline.jsp?Patient_ID=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" frameborder=no scrolling=no style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'CurEnc\' id=\'CurEnc\' src=\'../jsp/MedicalReportResult.jsp?flag=true&PatientId=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' noresize  frameborder=no scrolling=auto style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'DetailFrame\' id=\'DetailFrame\'  src=\'../jsp/MedRecRequestRecordDetail.jsp?LastDet=1&encounter_id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' noresize  frameborder=no scrolling=\'auto\' style=\'height:94vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=no noresize scrolling=\'no\' style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'StatusButton\' id=\'StatusButton\'  src=\'../jsp/MedicalRequestButtons.jsp?encounter_id=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" frameborder=no scrolling=no style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'CurEnc\' id=\'CurEnc\' src=\'../jsp/MedRecRequestResult.jsp?criteria=validate&flag=true&";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&PatientId=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&chkSelect=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' noresize  frameborder=no scrolling=\'auto\' style=\'height:0vh;width:100vw\'></iframe>\n \t\t<iframe name=\'DetailFrame\' id=\'DetailFrame\'  src=\'../jsp/MedRecRequestRecordDetail.jsp?LastDet=1&encounter_id=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' noresize  frameborder=no scrolling=\'auto\' style=\'height:95vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=no noresize scrolling=\'no\' style=\'height:0vh;width:100vw\'></iframe>\n\t\t<iframe name=\'recordFrame\' id=\'recordFrame\'  src=\'../jsp/MedicalRequestButtons.jsp?encounter_id=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</head>\n</html>\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	
	String title = "";
	String params		= request.getQueryString() ;
	String PatientId	= checkForNull(request.getParameter("PatientId"));
	String selitem		= checkForNull(request.getParameter("selitem"));
	String called_from	= checkForNull(request.getParameter("called_from"));
	String finalSelect	= checkForNull(request.getParameter("finalSelect"));
	String from			= checkForNull(request.getParameter("from"));
	String to			= checkForNull(request.getParameter("to"));
	String encounter_id = checkForNull(request.getParameter("encounterId"));
	String overdue_status = checkForNull(request.getParameter("overdue_status"));
	String isAcceptRequestByPractAppl = checkForNull(request.getParameter("isAcceptRequestByPractAppl"));
	//added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 


	String frfunction = checkForNull(request.getParameter("p_fr_function"));
	if(frfunction.equals("IP"))
		title = "Stay Details";

	String call_function = checkForNull(request.getParameter("call_function"));
	String new_func_id = "";
	String request_id = checkForNull(request.getParameter("request_id"));
	String req_status = checkForNull(request.getParameter("req_status"));
	String request_status_des = checkForNull(request.getParameter("request_status_des")); // added by mujafar for ML-MMOH-CRF-0714
/*
	Medical Report Request				|	MEDICAL_REPORT_REQUEST	|		1
	Status of Medical Report Request	|	MEDICAL_REPORT_STATUS	|		2 
	Forward Medical Report Request		|	FORWARD_MEDICAL_REPORT	|		3 
	Prepare Med Report By Practitioner	|	PREPARE_MEDICAL_REPORT	|		4 
	Receive Medical Report				|	RECEIVE_MEDICAL_REPORT	|		5 
	Deliver Medical Report				|	DELIVER_MEDICAL_REPORT	|		6 
	Revise Medical Report				|	REVISE_MEDICAL_REPORT	|		0 
*/
	if(call_function.equals("APP_FOR_MED_BOARD"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicationforMedicalBoard.label","mr_labels");

		new_func_id = "APP_FOR_MED_BOARD";
	}

	if(req_status.equals(""))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MedicalReportRequest.label","common_labels");
		call_function = "MEDICAL_REPORT_REQUEST"; 
	}
	else if(req_status.equals("1") || req_status.equals("7"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusofMedicalReportRequest.label","mr_labels");
		call_function = "MEDICAL_REPORT_STATUS"; 
	}
	else if(req_status.equals("2") )
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardMedicalReportRequest.label","mr_labels");
		call_function = "FORWARD_MEDICAL_REPORT"; 
	}/*Added By Dharma on Nov 30th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
	else if(req_status.equals("9")){
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardToPractitioner.label","mr_labels");
		call_function = "FORWARD_TO_HOD"; 
	}else if(req_status.equals("10")){
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardMedicalReportRequest.label","mr_labels");
		call_function = "REQUEST_RETURNED"; 
	}else if(req_status.equals("11")){
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardToPractitioner.label","mr_labels");
		call_function = "REQUEST_ACCEPTED"; 
	}
	/*Added By Dharma on Nov 30th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/
	else if(req_status.equals("3") || req_status.equals("0") || req_status.equals("98")) // modified by mujafar for ML-MMOH-CRF-0714
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PrepareMedicalReport.label","mr_labels");
		call_function = "PREPARE_MEDICAL_REPORT"; 
	}
	else if(isAcceptRequestByPractAppl.equals("true") && req_status.equals("13")  ) //added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 START
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AcceptedbyPractitioner.label","mr_labels");
		call_function = "ACCEPTED_BY_PRACTITIONER"; 
	}
		else if(isAcceptRequestByPractAppl.equals("true") && req_status.equals("15")  )
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoHOD.label","mr_labels");
		call_function = "REJECTED_BY_PRACT_TO_HOD"; 
	}
	else if(isAcceptRequestByPractAppl.equals("true") && req_status.equals("14")  )
	{ //added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 END
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoMRD.label","mr_labels");
		call_function = "REJECTED_BY_PRACT_TO_MRD"; 
	}
	else if(req_status.equals("4"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReceiveMedicalReport.label","mr_labels");
		call_function = "RECEIVE_MEDICAL_REPORT"; 
	}
	else if(req_status.equals("5"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DeliverMedicalReport.label","mr_labels");
		call_function = "DELIVER_MEDICAL_REPORT"; 
	}
	else if(req_status.equals("6"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReportCompleted.label","mr_labels");
		call_function = "MEDICAL_REPORT_COMPLETED"; 
	}
	else if(req_status.equals("8"))
	{
		//title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReport.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReportCancelled.label","mr_labels");
		call_function = "MEDICAL_REPORT_CANCELLED"; 
	}
	/*Added by Thamizh selvi on 17th July 2017 for ML-MMOH-CRF-0719 Start*/
	else if(req_status.equals("99"))
	{
		//title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReport.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Auto.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReportAutoCancelled.label","mr_labels");
		call_function = "MEDICAL_REPORT_CANCELLED"; 
	}/*End*/
	else if(call_function.equals("QUERY_DELAY_IN_MRR"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DelayOverdueofMedicalReport.label","mr_labels");
		call_function = "QUERY_DELAY_IN_MRR"; 
	}

	if(overdue_status.equals("Y") && !req_status.equals("6"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReviseMedicalReport.label","mr_labels");
		call_function = "REVISE_MEDICAL_REPORT"; 
	}

            _bw.write(_wl_block6Bytes, _wl_block6);

if(call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("REVISE_MEDICAL_REPORT") || 
call_function.equals("QUERY_DELAY_IN_MRR") || call_function.equals("MEDICAL_REPORT_COMPLETED") || call_function.equals("ACCEPTED_BY_PRACTITIONER") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") )
{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(new_func_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(selitem));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(from));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(to));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(req_status));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(req_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request_status_des));
            _bw.write(_wl_block24Bytes, _wl_block24);

}else if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
{ 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(title));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(new_func_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(selitem));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(from));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(to));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(req_status));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block24Bytes, _wl_block24);

}else{	//for Medical Report Request
	
	//out.println("<script>alert(\"finalSelect"+finalSelect+"\");</script>");
//out.println("<script>alert(\"params "+params+"\");</script>");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(params));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(selitem));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(from));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(to));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(new_func_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(selitem));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(from));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(to));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(req_status));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(finalSelect));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block24Bytes, _wl_block24);
	} 
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
