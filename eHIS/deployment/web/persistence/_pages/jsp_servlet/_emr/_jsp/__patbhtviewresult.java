package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class __patbhtviewresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/PatBHTViewResult.jsp", 1742300134990L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCRF Reference No     :  ML-MMOH-CRF-1959\nDetected Release  No      :  SEPTEMBER 2023 Release \nFile prepared by          :  SANTHOSH KUMAR N\nFile prepared date        :  1-07-2023\nPurpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.\nScript Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    \n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<style>\n.inner_table { \n\t\twidth:100%; \n\t\theight: 400px;\n\t\toverflow-y: auto;\n\t}\n</style>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\' />\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\'javascript\' src=\"../js/PatientBHT.js\"></script>\n<script type=\"text/javascript\">\n\tvar CheckedEncounterID = \"\";\n\tvar CheckedBHTStatus=\"\";\n\tfunction bulkOrder(EncounterID, obj, BHTStatus) {\n\t\tif (obj.checked) {\n\t\t\tif (CheckedEncounterID == null || CheckedEncounterID == \"\") {\n\t\t\t\tCheckedEncounterID = EncounterID;\n\t\t\t\tCheckedBHTStatus = BHTStatus;\n\t\t\t} else {\n\t\t\t\tCheckedEncounterID = CheckedEncounterID + \",\" + EncounterID;\n\t\t\t\tCheckedBHTStatus = CheckedBHTStatus + \",\" + BHTStatus;\n\t\t\t}\n\t\t} else {\n\t\t\tvar arrayRemove = new Array();\n\t\t\tvar arrayBHTRemove = new Array();\n\t\t\tarrayRemove = CheckedEncounterID.split(\',\');\n\t\t\tarrayBHTRemove = CheckedBHTStatus.split(\',\');\n\t\t\tvar index = 0;\n\t\t\tvar countRemove = 0;\n\t\t\tfor (var j = 0; j < arrayRemove.length; j++) {\n\t\t\t\tif (arrayRemove[j] == EncounterID) {\n\t\t\t\t\tcountRemove++;\n\t\t\t\t\tindex = j;\n\t\t\t\t}\n\t\t\t}\n\t\t\tif (countRemove > 0) {\n\t\t\t\tarrayRemove.splice(index, 1);\n\t\t\t\tarrayBHTRemove.splice(index, 1);\n\t\t\t\tCheckedEncounterID = arrayRemove.toString();\n\t\t\t\tCheckedBHTStatus = arrayBHTRemove.toString();\n\t\t\t}\n\n\t\t}\n\t\tparent.BHT_result.document.getElementById(\"EncounterID_param\").value = CheckedEncounterID;\n\t\tparent.BHT_result.document.getElementById(\"BHTStatus_param\").value = CheckedBHTStatus;\n\t\t\n\t\tvar BHTStatusArray = new Array();\n\t\tBHTStatusArray = CheckedBHTStatus.split(\',\');\n\t\tvar disableReturn = false;\n\t\tfor (var i = 0; i < BHTStatusArray.length; i++) {\n\t\t\tif(BHTStatusArray[i]!=\"\" && BHTStatusArray[i]!=\"Delivered\"){\n\t\t\t\tdisableReturn=true;\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\t\tif(disableReturn == true){\n\t\t\tdocument.getElementById(\"Return_BHT\").disabled = true;\n\t\t} else {\n\t\t\tdocument.getElementById(\"Return_BHT\").disabled = false;\n\t\t}\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n\t<form name=\"BHTResult\" id=\"BHTResult\" method=\"post\" action=\'../../servlet/eMR.PatBHTServlet\' target=\"messageFrame\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<div class=\"inner_table\">\n\t\t<table class=\'grid\' id=\'PatBHTResultTbl\' border=\'1\' cellpadding=\'1\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<th align=\"center\" nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t<th align=\"center\" nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td nowrap><font size=1><a href=\"#\" onClick=\"showEncounter(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a></td>\n\t\t\t\t<td nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" / ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td nowrap><font size=1><a href=\"#\" onClick=\"viewDiagnosis(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>\n\t\t\t\t<input type=\"hidden\" id=\"remarks_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" name=\"remarks_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</tr>\n\t\t</table>\n\t\t</div>\n\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = checkForNull((String) session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	Statement stmt = null;
	ResultSet rs = null;
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	String locale = (String) session.getAttribute("LOCALE");
	String facility_id = (String) session.getValue("facility_id");
	
	String lstPatientClass = (request.getParameter("lstPatientClass") != null) ? request.getParameter("lstPatientClass") : "";
	String periodTo = DateUtils.convertDate(request.getParameter("periodTo"), "DMY", locale, "en");
	String periodFrom = DateUtils.convertDate(request.getParameter("periodFrom"), "DMY", locale, "en");
	String encounter_id = (request.getParameter("encounter_id") != null) ? request.getParameter("encounter_id") : "";
	String locationType = (request.getParameter("locationType") != null) ? request.getParameter("locationType") : "";
	String loc_val = (request.getParameter("loc_val") != null) ? request.getParameter("loc_val") : "";
	System.err.println(request.getParameter("patientId") != null);
	String patient_Id = (request.getParameter("patientId") != null) ? request.getParameter("patientId") : "";
	System.err.println("PatientId 1== "+patient_Id);
	String BHTStatus = (request.getParameter("BHTStatus") != null) ? request.getParameter("BHTStatus") : "";
	Integer maxDaysBHTSubmission = (!checkForNull(request.getParameter("maxDaysBHTSubmission")).equals("")) ? Integer.parseInt(request.getParameter("maxDaysBHTSubmission")) : 0;
	Date currentDateTime = new Date();
	String cMonth =  String.valueOf(currentDateTime.getMonth() + 1);
	String cDay =  String.valueOf(currentDateTime.getDate());
	String cYear =  String.valueOf(currentDateTime.getYear() + 1900);
	String cHours =  String.valueOf(currentDateTime.getHours());
	String cMinutes =  String.valueOf(currentDateTime.getMinutes());
							
	if(Integer.valueOf(cMonth) < 10)
		cMonth="0"+cMonth;
	if(Integer.valueOf(cDay) < 10)
		cDay="0"+cDay;
	String currentDate = cDay+"/"+cMonth+"/"+cYear+" "+cHours+":"+cMinutes;

	String PatientId = "";
	String BHT_Status = "";
	String EncounterDate = "";
	String EncounterId = "";
	String PatientClass = "";
	String PatientClassDesc = "";
	String LocnType = "";
	String AssignLocnDesc = "";
	String DischargeDate = "";
	String Specaility = "";
	String PractitionerName = "";
	String Facility_ID = "";
	String Remarks = "";

	int cnt = 0;
	HashMap<String,String> remarksMap = new HashMap();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			try {
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT PATIENT_ID,BHT_STATUS,ENCOUNTER_DATE,ENCOUNTER_ID,PATIENT_CLASS,PATIENT_CLASS_DESC,ASSIGN_CARE_LOCN_TYPE_DESC,ASSIGN_CARE_LOCN_DESC,DISCHARGE_DATE_TIME,SPECAILITY_SHORT_DESC,PRACTITIONER_NAME,FACILITY_ID,REMARKS FROM  MR_PAT_BHT_STATUS_VW WHERE PATIENT_CLASS='"+lstPatientClass+"' AND to_date(to_char(TO_DATE (discharge_date_time, 'dd/mm/yyyy  hh24:mi'), 'dd/mm/yyyy'), 'dd/mm/yyyy') BETWEEN to_date('" + periodFrom + "','dd/mm/yyyy') and to_date('" + periodTo + "','dd/mm/yyyy')");
				
				if(!checkForNull(encounter_id).equals("")) {
					sql.append(" AND ENCOUNTER_ID=NVL('"+encounter_id+"',ENCOUNTER_ID)");
				}
				if(!checkForNull(locationType).equals("")) {
					sql.append(" AND ASSIGN_CARE_LOCN_TYPE=NVL('"+locationType+"',ASSIGN_CARE_LOCN_TYPE)");
				}
				System.err.println("loc_val========= "+!checkForNull(loc_val).equals(""));
				System.err.println("checkForNull(loc_val)========= "+checkForNull(loc_val));
				if(!checkForNull(loc_val).equals("")) {
					System.err.println("loc_val========= "+loc_val);
					sql.append(" AND ASSIGN_CARE_LOCN_CODE=NVL('"+loc_val+"',ASSIGN_CARE_LOCN_CODE)");
				}
				if(!checkForNull(patient_Id).equals("")) {
					sql.append(" AND PATIENT_ID=NVL('"+patient_Id+"',PATIENT_ID)");
				} 		
				if(!checkForNull(BHTStatus).equals("")) {
					String BHTStatusDesc = (BHTStatus.equals("P")) ? "Pending" : (BHTStatus.equals("O")) ? "Pending" : (BHTStatus.equals("D")) ? "Delivered"
											: (BHTStatus.equals("R")) ? "Received" : (BHTStatus.equals("X")) ? "Returned" : "";
					sql.append(" AND BHT_STATUS=NVL('" + BHTStatusDesc + "',BHT_STATUS)");
				} else {
					sql.append(" AND BHT_STATUS in('Pending','Overdue','Delivered','Received','Returned')");
				}

				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql.toString());
				rst = pstmt.executeQuery();
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				while (rst != null && rst.next()) {
						PatientId = checkForNull(rst.getString(1));
						BHT_Status = checkForNull(rst.getString(2));
						EncounterDate = checkForNull(rst.getString(3));
						EncounterId = checkForNull(rst.getString(4));
						PatientClass = checkForNull(rst.getString(5));
						PatientClassDesc = checkForNull(rst.getString(6));
						LocnType = checkForNull(rst.getString(7));
						AssignLocnDesc = checkForNull(rst.getString(8));
						DischargeDate = checkForNull(rst.getString(9));
						Specaility = checkForNull(rst.getString(10));
						PractitionerName = checkForNull(rst.getString(11));
						Facility_ID =  checkForNull(rst.getString(12));
						Remarks =  checkForNull(rst.getString(13));
						
						if(maxDaysBHTSubmission > 0 && BHT_Status.equals("Pending")){
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
							Date newDate = sdf.parse(DischargeDate);
							newDate.setDate(newDate.getDate() + maxDaysBHTSubmission);
							String month =  String.valueOf(newDate.getMonth() + 1);
							String day =  String.valueOf(newDate.getDate());
							String year =  String.valueOf(newDate.getYear() + 1900);
							String hours =  String.valueOf(newDate.getHours());
							String minutes =  String.valueOf(newDate.getMinutes());
													
							if(Integer.valueOf(month) < 10)
								month="0"+month;
							if(Integer.valueOf(day) < 10)
								day="0"+day;
							String maxDaysBHT = day+"/"+month+"/"+year+" "+hours+":"+minutes;
							
							Date date1 = sdf.parse(currentDate);
							Date date2 = sdf.parse(maxDaysBHT);
							
							BHT_Status = (BHT_Status.equals("Pending") && date1.after(date2))?"Overdue":BHT_Status;
						}
						String colourCode = BHT_Status.equals("Pending")?"#FFFF00":BHT_Status.equals("Overdue")?"#FF0000":BHT_Status.equals("Delivered")?"#ffa500":BHT_Status.equals("Received")?"#00FF00":BHT_Status.equals("Returned")?"#007FFF":"";
						String styleValue ="WIDTH: 50px; background-color:"+colourCode;
			
            _bw.write(_wl_block11Bytes, _wl_block11);
 if((checkForNull(BHTStatus).equals("")) || (!checkForNull(BHTStatus).equals("") && ((BHTStatus.equals("P") && BHT_Status.equals("Pending")) || (BHTStatus.equals("O") && BHT_Status.equals("Overdue")) || BHTStatus.equals("R") || BHTStatus.equals("D") || BHTStatus.equals("X"))) ){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(BHT_Status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(EncounterDate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((PatientClass==null)?"":PatientClass));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Facility_ID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(PatientClassDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(LocnType));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(AssignLocnDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(DischargeDate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Specaility));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PractitionerName));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Facility_ID));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Remarks));
            _bw.write(_wl_block23Bytes, _wl_block23);

						cnt++;
					}
				}
		
				if (cnt == 0) {
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
				
            _bw.write(_wl_block24Bytes, _wl_block24);

			if (pstmt != null)
					pstmt.close();
				if (rst != null)
					rst.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.returnConnection(con, request);
			}
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.BHTStatus.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisDetails.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisDetails.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }
}
