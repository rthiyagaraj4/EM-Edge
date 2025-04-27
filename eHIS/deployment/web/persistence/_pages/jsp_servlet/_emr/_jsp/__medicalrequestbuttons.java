package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import eCommon.XSSRequestWrapper;

public final class __medicalrequestbuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedicalRequestButtons.jsp", 1743670786284L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\"../js/MedRecRequestButtons.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<script>\n\tasync function showPrevDelReports()\n\t{\n\t\tvar request_type\t= \"MR\";\n\t\tvar retVal\t\t\t= new String();\n\t\tvar dialogHeight\t= \"70vh\";\n\t\tvar dialogWidth\t\t= \"70vw\";\n\t\tvar dialogTop\t\t= \"72\";\n\t\tvar status\t\t\t= \"no\";\n\t\tvar center\t\t\t= \"\";\n\t\tvar arguments\t\t= \"\";\n\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\n\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/ReportRequestQueryResult.jsp?title=PREV_DEL_REPORT&status_to_show=6&request_type=MR&PatientId=\"+document.record_form.patientId.value,arguments,features);\n\t}\n\t/*Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 Start*/\n\tasync function ModifyDetails(){\n\t\t\n\t\tvar retVal\t\t\t= new String();\n\t\tvar dialogHeight\t= \"12vh\";\n\t\tvar dialogWidth\t\t= \"35vw\";\n\t\tvar dialogTop\t\t= \"\";\n\t\tvar status\t\t\t= \"no\";\n\t\tvar center\t\t\t= \"\";\n\t\tvar arguments\t\t= \"\";\n\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\n\t\tvar deliveredDate = parent.DetailFrame.document.MedicalRecordReqForm.DeliveredDate.value;\n\t\tvar requestId = parent.DetailFrame.document.MedicalRecordReqForm.request_id.value;\n\t\tvar preparedPract = parent.DetailFrame.document.MedicalRecordReqForm.hdd_pract_code.value;\n\t\tvar preparedDate = parent.DetailFrame.document.MedicalRecordReqForm.hdd_PrepareDate.value;\n\t\tvar collectDate = parent.DetailFrame.document.MedicalRecordReqForm.hdd_CollectDate.value;\n\t\tvar collectionMode = parent.DetailFrame.document.MedicalRecordReqForm.collectionMode.value;\n\t\tvar facilityId = parent.DetailFrame.document.MedicalRecordReqForm.facility_id.value;\n\t\tvar patientId = parent.DetailFrame.document.MedicalRecordReqForm.patientId.value;\n\t\tvar revisedCollectDate = parent.DetailFrame.document.MedicalRecordReqForm.old_revised_collect_date.value;\n\n\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/MedRecRequestModifyFrameset.jsp?request_type=MR&deliveredDate=\"+deliveredDate+\"&facilityId=\"+facilityId+\"&requestId=\"+requestId+\"&preparedPract=\"+preparedPract+\"&preparedDate=\"+preparedDate+\"&collectDate=\"+collectDate+\"&revisedCollectDate=\"+revisedCollectDate+\"&collectionMode=\"+collectionMode+\"&patientId=\"+patientId,arguments,features);\n\n\t\tif(retVal != null){\n\t\t\tparent.window.close();\n\t\t}\n\n\t}/*End*/\n</script>\n</head>\n\t<body onKeyDown=\'lockKey()\'>\n\t<form name=\'record_form\' id=\'record_form\'>\n\t\t<table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\n\t\t\t\t\t\t<td class=label width=\"25%\">&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<td class=label width=\"40%\">&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<td class=\"label\" ><input type=\'button\' name=\'Notes\' id=\'Notes\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' class=\'button\' onclick=\'openCAModal()\'></td>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<td class=\"label\" ><input type=\'button\' name=\'Notes\' id=\'Notes\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' class=\'button\' onclick=\'openCAModal()\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<!--Modified by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396-->\n\t\t\t\t\t<td class=\"label\"  ><input type=\'button\' name=\'print\' id=\'print\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' class=\'button\' onclick=\'printReport();\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ></td>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<td class=label width=\"50%\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<!--Modified by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396-->\n\t\t\t\t\t<td class=\'button\' ><input type=\'button\' name=\'print\' id=\'print\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<td class=\'button\'  align=\"right\">\n\t\t\t<!--Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 Start-->\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<input type=\'button\' name=\'modify\' id=\'modify\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' class=\'button\' onclick=\'ModifyDetails();\' >\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<!--End-->\n\t\t\t\n\t\t\t<input type=\'button\' name=\'showPrevDtls\' id=\'showPrevDtls\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' class=\'button\' onclick=\'showPrevDelReports()\'>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\n\t\t\t\t\t<input type=\'button\' name=\'savedraft\' id=\'savedraft\' id=\'savedraft\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' class=\'button\' onclick=\'apply1();\'> \n\t\t\t\t\t\n\t\t\t\t\t<input type=\'button\' name=\'search\' id=\'search\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' class=\'button\' onclick=\'apply();\'> <!-- ADDED by mujafar for ML-MMOH-CRF-0714 -->\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\n\t\t\t\t\t<input type=\'button\' name=\'search\' id=\'search\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' class=\'button\' onclick=\'apply();\'> <!-- ADDED by mujafar for ML-MMOH-CRF-0714 -->\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\n\t\t\t\t\t<input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' class=\'button\' onclick=\'closeME();\'></td>\n\t\t\t</tr>\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\"hidden\" name=\"patient_line\" id=\"patient_line\"\tvalue=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\"\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\"\tvalue=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"\tvalue=\"I\">\n\t\t<input type=\"hidden\" name=\"dischargeDateTime\" id=\"dischargeDateTime\"\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<input type=\"hidden\" name=\"specialty_name\" id=\"specialty_name\"\tvalue=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<input type=\"hidden\" name=\"attending_practitioner\" id=\"attending_practitioner\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<input type=\"hidden\" name=\"request_id\" id=\"request_id\"\tvalue=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\"\tvalue=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\"\tvalue=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\"\tvalue=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\"\tvalue=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"hidden\" name=\"event_status\" id=\"event_status\"\tvalue=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\t\n\t\t<input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\"\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\"\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t</table>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\t\n\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
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
/*
MODULE			:	Medical Records..(MR)
Function Name	:	Medical Report
[Request/Prepare/Status/Forward/Receive/Deliver/Revise]
Created On		:	22 JULY 2004
*/
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	request.setCharacterEncoding("UTF-8");
	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	StringBuffer sqlBuff=new StringBuffer();
	Boolean isRejectReportApplicable = false; //  Added by Mujafar for ML-MMOH-CRF-0714
	//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	String Facility_Id = (String) session.getValue("facility_id");

	String call_function = request.getParameter("call_function");
		if(call_function == null) call_function ="";
//out.println("<script>alert(\"call_function:"+call_function+"\");</script>");
	String called_from = request.getParameter("called_from");
		if(called_from == null) called_from ="";

	String patientId = request.getParameter("patientId");
		if(patientId == null) patientId ="";

	String request_id = request.getParameter("request_id");
		if(request_id == null) request_id =""; 
	// added by mujafar for ML-MMOH-CRF-0714 START		
	String req_status = request.getParameter("req_status");
		if(req_status == null) req_status ="";
		
	String request_status_des = request.getParameter("request_status_des");
		if(request_status_des == null) request_status_des ="";
	// END
		

	String patient_line			= "";
	String dischargeDateTime	= "";
	String attending_practitioner= "";	
	String accession_num		= "";
	String facility_name		= "";		
	String visit_adm_date		= "";
	String specialty_name		= "";
	String enc_ids				= "";
	String event_status			= "";
	String location_code	= "";
String specialty_code	= "";

	String disViewMedRep = ""; //Added by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396

	Boolean isDeliveredRepModifyAppl = false;//Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 

	Boolean isViewMedicalReportAppl = false;//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331 
	Boolean isAcceptRequestByPractAppl = false; // added by mujafar for ML-MMOH-CRF-1315

try
{
	try
	{
		con = ConnectionManager.getConnection(request);
		isRejectReportApplicable =     eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REPORT_MRP"); //  Added by Mujafar for ML-MMOH-CRF-0714

		isDeliveredRepModifyAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MODIFY_ISSUED_MEDICAL_REPORT"); //Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 

		isViewMedicalReportAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","VIEW_MED_REPORT"); //Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
		isAcceptRequestByPractAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ACCEPT_REJECT_BY_PRACT_APPL"); // added by mujafar for ML-MMOH-CRF-1315
		
		String encSql=" select ENCOUNTER_ID from MR_REPORT_REQUEST_DTL where REQUEST_ID = '"+request_id+"' and FACILITY_ID = '"+Facility_Id+"' and PATIENT_ID = '"+patientId+"' ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(encSql);
		if (rs.next() && rs != null)
		{
			enc_ids = rs.getString("ENCOUNTER_ID");
			
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 1: "+exp.toString());
		exp.printStackTrace();
	}

	try
	{
		sqlBuff.append("select a.event_status, a.accession_num from CA_ENCNTR_NOTE a ");
		sqlBuff.append(" where a.patient_id = ? and a.ACCESSION_NUM = ");
		sqlBuff.append("(select ACCESSION_NUM from MR_REPORT_REQUEST_HDR where ");
		sqlBuff.append("facility_id=? and patient_id =?");
		sqlBuff.append(" and REQUEST_ID = ?)");
		
		pstmt = con.prepareStatement(sqlBuff.toString());
		pstmt.setString(1,patientId);
		pstmt.setString(2,Facility_Id);
		pstmt.setString(3,patientId);
		pstmt.setString(4,request_id);
		rs	=pstmt.executeQuery();
		if (rs.next() && rs != null)
		{
			accession_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
			event_status= rs.getString("EVENT_STATUS")==null?"":rs.getString("EVENT_STATUS");
		}
		
		//Added by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396
		if (accession_num == "")
		{
			disViewMedRep = "disabled";
		}else
		{
			disViewMedRep = "";
		}

		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();

	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 2: "+exp.toString());
		exp.printStackTrace();
	}

	try
	{
		String MainSql=" select AM_GET_DESC.AM_SERVICE(SERVICE_CODE,'"+localeName+"','2')  specialty_name,to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME, (select SHORT_NAME from am_practitioner where practitioner_id = ca_ip_active_episode_vw.CUR_PHYSICIAN_ID) attending_practitioner from CA_IP_ACTIVE_EPISODE_VW where facility_id = '"+Facility_Id+"' and episode_id = '"+enc_ids+"' ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(MainSql);
		if (rs.next() && rs != null)
		{
			visit_adm_date	=	rs.getString("visit_adm_date");
			specialty_name	=	rs.getString("specialty_name");
			dischargeDateTime= rs.getString("discharge_date_time");
			attending_practitioner = rs.getString("attending_practitioner");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 4: "+exp.toString());
		exp.printStackTrace();
	}

	try
	{
		String facilitySql=" select facility_name, get_patient.get_line_detail('"+patientId+"','"+locale+"') patient_line from SM_FACILITY_PARAM where facility_id = '"+Facility_Id+"' ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(facilitySql);
		if (rs.next() && rs != null)
		{
			facility_name	= rs.getString("FACILITY_NAME");
			patient_line	= rs.getString("patient_line");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();


	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 5: "+exp.toString());
		exp.printStackTrace();
	}

	try
	{
		String pr_sql=" select PAT_CURR_LOCN_CODE,SPECIALTY_CODE from PR_ENCOUNTER where  facility_id = '"+Facility_Id+"' and ENCOUNTER_ID = '"+enc_ids+"' and PATIENT_ID='"+patientId+"' ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(pr_sql);
		if (rs.next() && rs != null)
		{
			location_code = rs.getString("PAT_CURR_LOCN_CODE")==null?"":rs.getString("PAT_CURR_LOCN_CODE");
			specialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();


	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 6: "+exp.toString());
		exp.printStackTrace();
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
				if(call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				{	
					if(called_from.equals("CA"))
					{	
					if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				
            _bw.write(_wl_block8Bytes, _wl_block8);
	}}else{	
					if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					
            _bw.write(_wl_block9Bytes, _wl_block9);
	}}	
            _bw.write(_wl_block10Bytes, _wl_block10);
	if(called_from.equals("CA"))
					{
					if(isAcceptRequestByPractAppl){  // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PrepareMedicalReport.label","mr_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RecordNotes.label","mr_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
	}}	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewMedicalReport.label","mr_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disViewMedRep));
            _bw.write(_wl_block17Bytes, _wl_block17);
	}
				/*Modified by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331*/
				else if(!call_function.equals("DELIVER_MEDICAL_REPORT") && !call_function.equals("MEDICAL_REPORT_COMPLETED") && ((isViewMedicalReportAppl && !call_function.equals("RECEIVE_MEDICAL_REPORT")) || !isViewMedicalReportAppl)) 
				{	
					
            _bw.write(_wl_block18Bytes, _wl_block18);
	}	
				/*Modified by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331*/
				if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED") || (isViewMedicalReportAppl && call_function.equals("RECEIVE_MEDICAL_REPORT")))
				{	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewMedicalReport.label","mr_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disViewMedRep));
            _bw.write(_wl_block17Bytes, _wl_block17);
	}	
            _bw.write(_wl_block20Bytes, _wl_block20);

			String disable="";
			int count_req=0;
			// added by mujafar for ML-MMOH-CRF-0714 START
			String disable_record="";
			if(isRejectReportApplicable && req_status.equals("98") && !request_status_des.equals("OVERDUE") && !called_from.equals("CA"))
					disable_record="disabled";
			// END
			StringBuffer sqlPr = new StringBuffer();
			sqlPr.append("SELECT  count(*) count  FROM mr_report_request_hdr where patient_id='"+patientId+"'  AND request_status='6' ");

			stmt = con.createStatement();
			rs	=	stmt.executeQuery(sqlPr.toString());
			
			 while(rs!=null && rs.next()){
				 
				 count_req=rs.getInt(1);
				 
			 }
				
				stmt.close();
				rs.close();
			
			if(count_req==0)
			disable="disabled";
	
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(isDeliveredRepModifyAppl && call_function.equals("MEDICAL_REPORT_COMPLETED")){ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ModificationRequired.label","mr_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PrevDelMedReport.label","mr_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
							
			/*Modified by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331*/
			if(!call_function.equals("MEDICAL_REPORT_COMPLETED") && !call_function.equals("MEDICAL_REPORT_CANCELLED") && !(isViewMedicalReportAppl && called_from.equals("CA") && call_function.equals("RECEIVE_MEDICAL_REPORT")))
				{
					
					
			if(isAcceptRequestByPractAppl && (call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER") ))
				{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 
					
					String disable_record1="";
					if(!called_from.equals("CA")  ) 
						disable_record1 = "disabled";
					
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disable_record1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SaveAsDraft.label","mr_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disable_record));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SubmitMedicalReport.label","mr_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disable_record));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);
	}}	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(enc_ids));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_line));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(dischargeDateTime));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(specialty_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(attending_practitioner));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
	
		if(called_from.equals("CA"))
		{
			/*Modified by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396*/
			if(!accession_num.equals(""))
			{
				out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = false;</script>");
			}else
			{
				out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = true;</script>");
			}
		}
		else
		{
			if(!accession_num.equals("") && ( event_status.equals("4") ||event_status.equals("5")) )
			{
				out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = false;</script>");
			}
			else
			{
				out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = true;</script>");
			}
		}
		
            _bw.write(_wl_block49Bytes, _wl_block49);
	}catch(Exception e) 
	{	
		//out.println(e.toString());
		e.printStackTrace();
	}
    finally
    {
		 ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
