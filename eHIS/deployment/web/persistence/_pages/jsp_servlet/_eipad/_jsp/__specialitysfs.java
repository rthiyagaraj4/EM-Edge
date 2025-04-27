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

public final class __specialitysfs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/specialitySFS.jsp", 1709118032412L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n<!DOCTYPE html> \n<html> \n<head> \n<title>Prac</title> \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n<link rel=\"stylesheet\" href=\"../css/ipad.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script> \n\n<style>\n  .bgClr{   \n              height : 30px;\n         \n      \n        background :   -moz-linear-gradient( #015555 , #2496ac ); \n        background :  -webkit-gradient(linear, left top, left bottom, from( #015555 ), to( \n\n#2496ac )); /* Saf4+, Chrome */\n        background : -webkit-linear-gradient( #015555 , #2496ac ); /* Chrome 10+, Saf5.1+ \n\n*/\n        border:1px solid red;\n        border-radius:5px;\n        -moz-border-radius:5px;\n       font-family: Gotham-Bold;\n\tfont-size: 12pt;\n       /* margin-left : 25px;*/\n  }\n  .tbIpContent2 tr:active{    \n   background-color:#a2d7d7; \n   } \n</style>\n<script type=\"text/javascript\">\n/*\n $(document).bind(\"swipe\", function(event, data){\n\t//alert(\"helloo\")\n\tevent.preventDefault();\t\n });\n */\nfunction openPatient()\n {\n\t// alert(\"hi\");\n\t// window.parent.location =\"Appointment.html\";\n\t// $(\'#page12\').html(\"Loading.....\")\n\t // window.parent.slidee(\"true\");\n\t // window.location =\"Appointment.html\";\n\t //window.parent.location =\"Appointment.html\";\n\t\n\t//window.open(\"Appointment.html\");\n }\n function showCriteria()\n {\n\t// $(\'#divSrchCriteria\').slideToggle(\'fast\');\n\t//alert(\"searchcc\");\n\t// window.parent.test();\n\t// $(\"#page12\").dialog(\"close\");\n \n }\n function closeSrch(strCode,strDesc)\n {\n\t// alert(\"hi\");\n\t window.parent.CloseSearchCriteria();\n }\n function srchclose(strCode,strDesc,objTr)\n {\n\t// alert(\"hii\");\n\t// $(this).css(\'background\' , \'#a2d7d7\');\n\t//alert($(this));\n\t//$(this).removeClass(\"trSrchRow2\");\n\t//$(this).addClass(\"trIpRowsTouch\");\n\t// alert($(this));\n\t// window.parent.test(strCode,strDesc);\n\t//alert(objTr);\n\t//alert(objTr.style.background-color);\n\t//objTr.style.border = \"3px solid\";\n\tobjTr.style.backgroundColor = \"#a2d7d7\";\n\t//var d = document.getElementById(\"tbSrchcontrol\");\n\twindow.parent.Speciality(strCode,strDesc);\n\t//alert(objTr);\n }\n function dummyFn()\n {\n\t \n }\n function changerowColor(objTr)\n {\n\t// alert(\"hj\");\n\n\t objTr.style.backgroundColor = \"#a2d7d7\";\n }\n function move(e)\n {\n\t e.preventDefault(); \n }\n function show(objTr)\n {\n\t objTr.style.border = \"3px solid #48d1d8\";\n\t// alert(objTr.style.backgroundColor);\n\t//alert( $(this));\n\t// $(this).removeClass(\'btnType1\');               \n\t// $(this).addClass(\'bgClr\');\n     document.getElementById(\"hdnIsPostBack\").value = \"true\";\n\tdocument.getElementById(\"frmNursingUnit\").submit();\n }\n\t \n function LoadDefaultValues()\n {\n\t document.getElementById(\"txtSrchCriteria\").value =  document.getElementById(\"hdnSearchText\").value;\n\t document.getElementById(\"cmbCriteria\").value =  document.getElementById(\"hdnSearchcriteria\").value;\n\t if(document.getElementById(\"hdnRdCode\").value == \"true\")\n     {\n\t\t document.getElementById(\"rdCode\").checked = true;\n\t }\n\t else\n\t{\n\t\t document.getElementById(\"rdDesc\").checked = true;\n\t}\n\t \n }\n </script>\n   \n<body onload = \"LoadDefaultValues()\">\n  \n    <section id=\"specialityPage\" data-role=\"page\"  style=\"padding:0px\">  \n    <form id = \"frmNursingUnit\" method = \"post\" name = \"frmNursingUnit\" >\n    <div style=\"width:100%;height:auto>";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="</div>\n  <div id = \"divSrch\"  data-role =\"none\" class=\"dvApp\" >\n    <span class = \"spanDvsrch\">Speciality</span> \n  \n  </div>\n  \n  \n  <div id=\"divspeciality\"   style = \"display:block;height:auto\" class = \"dvCriteria\">\n  <table style=\"height:75px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\" id = \"tbSrchcontrol\" >\n\n     <tr style=\"height:30px\">\n      <td align = \"left\" style=\"width:34%\"><span class = \"spSrchCriteria\">Search By</span></td>\n      <td align = \"left\" style=\"width:32%\"><span class = \"spSrchCriteria\">Search Criteria</span></td>\n      <td align = \"left\" style=\"width:32%\"><span class = \"spSrchCriteria\">Search Text</span></td>\n      <td align = \"left\" style=\"width:2%\"></td>\n \n     </tr>\n     \n     <tr style=\"height:35px\">\n      <td align = \"left\" style=\"width:34%\" valign = \"center\" nowrap = \"false\">\n       <table style=\"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n         <tr style=\"width:100%;height:100%\">\n\t         <td style=\"width :25%\" align = \"center\">\n\t\t     \t <input type = \"radio\" name=\"group1\" id=\"group1\"  id=\"rdCode\" data-role = \"none\" class = \"radioGroup\" value = \"code\" />\n\t\t     </td> \n\t\t     <td style=\"width :20%\">\n\t\t     \t <span class = \"spRadio\">Code</span>\n\t\t      </td>\n\t\t      <td style=\"width :25%\" align = \"center\">\n\t\t     \t <input type = \"radio\" name=\"group1\" id=\"group1\"  data-role = \"none\" class = \"radioGroup\" value = \"desc\" id = \"rdDesc\"/>\n\t\t      </td>\n\t\t      <td style=\"width :20%\">\n\t\t     \t <span class = \"spRadio\">Description</span>\n\t\t      </td>\n\t\t       <td style=\"width :10%\">\n\t\t     \t &nbsp;\n\t\t      </td>\n\t     </tr> \n\t    </table>  \n      </td>\n      <td align = \"left\" style=\"width:32%\">\n        <select  class=\"cmbSrchCriteria\" data-role=\"none\" id=\"cmbCriteria\" name = \"cmbCriteria\"> \n           \n\t\t\t<option value = \"SW\">Starts With</option> \n\t\t\t<option value = \"CN\">Contains</option> \n\t\t\t<option value = \"EW\">Ends With</option> \n\t\t\t\n\n\t\t</select> \n      </td>\n      <td align = \"left\" style=\"width:32%\"><input type = textbox data-role = \"none\" class = \"tbPatCriteria\" name = \"txtSrchCriteria\" id = \"txtSrchCriteria\"/></td>\n        <td align = \"left\" style=\"width:2%\"></td>\n     </tr>\n     <tr style = \"height:10px;width:100%\">\n       <td >&nbsp;</td>\n     <tr>\n\n     \n   </table>\n   <div id = \"divSrchPanel\" style=\"height:auto\" class = \"dvSrchPanel\">\n\t\t\t      <table style=\"height:44px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t        <tr style=\"width:100%\">\n\t\t\t          <td style=\"width:75%\">&nbsp;</td>\n\t\t\t          <td style= \"width:25%\" nowrap = \"false\"> \n\t\t\t            <table style=\"width:100%\" border = \"0\">\n\t\t\t             <tr style=\"width:100%\">\n\t\t\t             <td align = \"right\" valign =\"center\" >\n\t\t\t               <input type =\"button\" name=\'search_btn\' id=\'search_btn\' value=\'Search\' class=\"btnType1\"  data-role = \"none\" onclick = \"show(this)\"/>\n\t\t\t             </td>\n\t\t\t             <td style=\"width:8%\"></td> \n\t\t\t             <td> \n\t\t\t               <input type =\"button\" name=\'clear_btn\' id=\'clear_btn\' value=\'Close\' class=\"btnType1\"  data-role = \"none\" onclick = \"closeSrch(\'\',\'\',this)\"/>\n\t\t\t             </td>  \n\t\t\t             </tr>\n\t\t\t            </table>\n\t\t\t          </td>\n\t\t\t      \n\t\t\t        </tr>\n\t\t\t      </table>\n\t     </div>\n   \n   </div>\n   \n   \n   \t      \n   \n \n   <div id = \'divSrchcContent\'   class = \'dvSrchcontent\' >\n     <div  data-role =\"none\" class =\"dvApp\">\n\t  \n\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  <tr style = \"height:100%;width:30%\">\n\t\t\t    <td style = \"width:30%\" align =\"left\" >\n\t\t\t         <span class = \"spanDvsrch\">Code</span>\n\t\t\t    </td>\n\t\t\t    <td style = \"width:70%\" align = \"left\" valign = \"center\">\n\t\t\t     \n\t\t\t     <span class = \"spanDvsrch\">Description</span>   \n\t\t\t    </td>\n\t\t\t    \n\t\t\t    \n\t\t\t  </tr>\n\t\t    </table>\t  \n\t  </div>\n   ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n     <table class = \"tbIpContent2\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\">\n      <tr class = \"trSrchRow";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"  onclick = \"srchclose(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\',\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\',this)\">\n        <td style=\"width:30%\" align = \"left\" valign = \"center\">\n          <span class = \"srchLabel\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span>\n        </td>\n        <td style=\"width:70%\" align = \"left\" valign = \"center\">\n            <span class = \"srchLabel\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\n        </td>\n        \n      </tr>\n     </table>\n      ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t      ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n     \n  \n    </div>\n   <input type = \"hidden\" name = \"hdnIsPostBack\" id = \"hdnIsPostBack\" value = \"false\" />\n   <input type = \"hidden\" name = \"hdnSearchText\" id = \"hdnSearchText\"  value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n   <input type = \"hidden\" name = \"hdnSearchcriteria\" id = \"hdnSearchcriteria\" value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" />\n   <input type = \"hidden\" name = \"hdnRdCode\" id = \"hdnRdCode\" value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" />\n   <input type = \"hidden\" name = \"hdnRdDesc\" id = \"hdnRdDesc\" value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" />\n</form>\n </section>  \n       \n     \n\n   ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\n  \n      </body>  \n    \n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
StringBuffer sqlStr = new StringBuffer("");



//sqlStr.append("SELECT A.PATIENT_CLASS EPISODE_TYPE_DESC,'I' EPISODE_TYPE,A.PATIENT_ID,REPLACE(DECODE('en','en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') PATIENT_NAME,TO_CHAR(A.DOB,'dd/mm/yyyy') DOB,A.AGE,A.SEX,A.LOCN_TYPE,A.CUR_WARD_CODE LOCN_CODE,  NULL FILEUM,NVL(A.CUR_ROOM_NUM,' ')ROOM_NUM,NVL(A.CUR_BED_NUM,' ')BED_NUM, A.CUR_PHYSICIAN_ID PHYSICIAN_ID,AM_GET_DESC.AM_PRACTITIONER(A.CUR_PHYSICIAN_ID,'ru','2') PHYSICIAN_NAME,A.SERVICE_CODE SPLTY_CODE,NVL(AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'ru','1'),' ') SPLTY_NAME,TO_CHAR(A.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') ADM_VISIT_DATE,TO_CHAR(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy') DISCHARGE_DATE_TIME,A.EPISODE_ID,TO_NUMBER('') VISIT_ID,A.ADMISSION_TYPE_CODE VIS_ADM_TYPE_CODE,CASE WHEN A.ADT_STATUS IN ('00','08') THEN CASE WHEN A.ADT_STATUS='08' THEN 'DS' WHEN A.CUR_BED_NUM IS NOT NULL THEN 'BA' ELSE 'AD' END WHEN A.ADT_STATUS='01' THEN  CASE WHEN  (SELECT 'Y' FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=A.FACILITY_ID AND ENCOUNTER_ID=A.EPISODE_ID AND DIS_ADV_STATUS='0' AND ROWNUM=1)='Y' THEN 'AP' WHEN  (SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL WHERE FACILITY_ID=A.FACILITY_ID AND  ENCOUNTER_ID = A.EPISODE_ID  AND ROWNUM=1 AND STATUS!='E' ) = 'Y' THEN 'DR'  ELSE CASE WHEN A.CUR_BED_NUM IS NOT NULL THEN 'BA' ELSE 'AD' END END END VISIT_EPISODE_STATUS,' ' APPT_TIME,' 'QUEUE_NUM,A.ADT_STATUS QUEUE_STATUS ,TO_CHAR(SYSDATE,'hh24:mi:ss') QRYTIME,A.CUR_PHYSICIAN_ID ACTUAL_PHYSICIAN_ID ,TRUNC(A.ADMISSION_DATE_TIME) VISIT_DATE,NULL SECURITY_LEVEL, NULL PROTECTION_IND, (REPLACE(DECODE('en','en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) ,'''','')||','||A.AGE||','||A.SEX) P_LINE,CA_GET_PATIENT_CURR_STATUS(A.FACILITY_ID,A.PATIENT_ID,A.EPISODE_ID,A.PATIENT_CLASS,'NAREN',A.DECEASED_YN)  STATUS,A.PATIENT_CLASS,NULL UNASSIGN_PATIENT_YN,A.ADMISSION_DATE_TIME ORDERBYDATE,A.REFERRAL_ID, A.DOB ACTUAL_DOB,A.ADMISSION_DATE_TIME ADM_DATE1, TO_CHAR(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') CLS_CONS_DATE, NULL PRIORITY_ZONE ,'visit_type' FROM CA_IP_ACTIVE_EPISODE_VW_i A where rownum < 15");
String facility_id=(String)session.getValue("facility_id");
String clinicianId =(String)session.getValue("ca_practitioner_id");
Boolean bRadioCode = true;
Boolean bRadioDesc = false;
//sqlStr.append("SELECT   REPLACE (DECODE ('en','en', patient_name,NVL (patient_name_loc_lang, patient_name)),'''','') patient_name,a.patient_id,NVL (a.age_hrs, a.age) age, a.sex,am_get_desc.am_practitioner (a.cur_physician_id,'en','2') physician_name,TO_CHAR (a.admission_date_time, 'dd/mm/yyyy hh24:mi') adm_visit_date,NVL (a.cur_room_num, ' ') room_num,NVL (a.cur_bed_num, ' ') bed_num,TO_CHAR (a.discharge_date_time, 'dd/mm/yyyy') discharge_date_time FROM ca_ip_active_episode_vw a WHERE a.facility_id = ? AND a.patient_class = 'IP' AND (a.adt_status IN ('01', '02')) AND a.cur_physician_id = ? AND (NOT EXISTS (SELECT 1 FROM mo_mortuary_regn WHERE patient_id = a.patient_id AND body_part_obtained_from IS NULL)) AND UPPER (a.cur_bed_num) LIKE UPPER ('%')ORDER BY patient_name,bed_num,discharge_date_time,physician_name");
//sqlStr.append("SELECT   REPLACE (DECODE ('en','en', patient_name,NVL (patient_name_loc_lang, patient_name)),'''','') patient_name,a.patient_id,NVL (a.age_hrs, a.age) age, a.sex,am_get_desc.am_practitioner (a.cur_physician_id,'en','2') physician_name,TO_CHAR (a.admission_date_time, 'dd/mm/yyyy') adm_visit_date,NVL (a.cur_room_num, ' ') room_num,NVL (a.cur_bed_num, ' ') bed_num,TO_CHAR (a.discharge_date_time, 'dd/mm/yyyy') discharge_date_time FROM ca_ip_active_episode_vw a WHERE a.facility_id ='" + facility_id +"' AND a.patient_class = 'IP' AND (a.adt_status IN ('01', '02')) AND a.cur_physician_id = '" + clinicianId + "' AND (NOT EXISTS (SELECT 1 FROM mo_mortuary_regn WHERE patient_id = a.patient_id AND body_part_obtained_from IS NULL)) AND UPPER (a.cur_bed_num) LIKE UPPER ('%')ORDER BY patient_name,bed_num,discharge_date_time,physician_name");
//sqlStr.append("SELECT NURSING_UNIT_CODE Code,LONG_DESC Description FROM IP_NURSING_UNIT A ");
//sqlStr.append("select apf.practitioner_id,ap.practitioner_name from am_pract_for_facility apf join am_practitioner ap on apf.practitioner_id = ap.practitioner_id");
sqlStr.append("SELECT a.SPECIALITY_CODE code,a.SHORT_DESC description FROM AM_SPECIALITY_lang_vw a WHERE eff_status = 'E' AND LANGUAGE_ID  ='en' AND SPECIALITY_CODE IN (SELECT NVL(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE FROM am_practitioner");
sqlStr.append(" WHERE practitioner_id ='" + clinicianId +"' UNION ALL SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES  ");
sqlStr.append(" WHERE FACILITY_ID ='" + facility_id +"' AND practitioner_id ='" + clinicianId +"')");

String SearchBy = "" ;
String SearchCriteria = "" ;
String SearchText = "";
String strPostBack = "";
Statement stmt				= null;
ResultSet rs				= null;

Statement stmt1				= null;
ResultSet rs1				= null;
ResultSet rs2				= null;
Connection con=null;

//if(request.getParameter("hdnIsPostBack") != null && request.getParameter("hdnIsPostBack") == "true")
//{
	strPostBack = request.getParameter("hdnIsPostBack");
		if(request.getParameter("group1") != null && request.getParameter("group1") != "" )
		{
			SearchBy = (String)request.getParameter("group1");
		}
		
		if(request.getParameter("cmbCriteria") != null && request.getParameter("cmbCriteria") != "" )
		{
			SearchCriteria = (String)request.getParameter("cmbCriteria");
		}
		if(request.getParameter("txtSrchCriteria") != null && request.getParameter("txtSrchCriteria") != "" )
		{
			SearchText = (String)request.getParameter("txtSrchCriteria");
		 
		}
		
		
		
		if(!SearchBy.equals("") && SearchBy.equals("code") && !SearchText.equals (""))
		{
			bRadioCode = true;
			bRadioDesc = false;
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("SW"))
			sqlStr.append(" AND upper(a.SPECIALITY_CODE) like upper('" + SearchText + "%')");
		   
		   
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("CN"))
			   sqlStr.append(" AND upper(a.SPECIALITY_CODE) like upper('%" + SearchText + "%')");
		   
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("EW"))
			   sqlStr.append(" AND upper(a.SPECIALITY_CODE) like upper('%" + SearchText + "')");
		   
		}
		
		
		if(!SearchBy.equals("") && SearchBy.equals("desc") && !SearchText.equals (""))
		{
			
			bRadioCode = false;
			bRadioDesc = true;	
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("SW"))
			   sqlStr.append(" AND upper(a.SHORT_DESC) like upper('" + SearchText + "%')");
		   
		   
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("CN"))
			   sqlStr.append(" AND upper(a.SHORT_DESC) like upper('%" + SearchText + "%')");
		   
		   if(!SearchCriteria.equals("") && SearchCriteria.equals("EW"))
			   sqlStr.append(" AND upper(a.SHORT_DESC) like upper('%" + SearchText + "')");
		   
		}
		
		
		
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;

		try {
		//con = ConnectionManager.getConnection(request);
		//stmt = con.createStatement();


		if (rs!=null) rs.close();   
		
		if(strPostBack != null && strPostBack.equals("true") )
		{
			
			con = ConnectionManager.getConnection(request);
			if(con != null)
			stmt = con.createStatement();
		    if(stmt != null)
			rs = stmt.executeQuery(sqlStr.toString());
		}
		//out.println(sqlStr.toString());

		







            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(sqlStr.toString() ));
            _bw.write(_wl_block2Bytes, _wl_block2);

	  int nClassCount = 1;
	  int cnt = 0;
	  
	 if(rs != null) 
	 {
	  while (  rs.next() ){ 
	  
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(nClassCount ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(rs.getString("code")));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rs.getString("description")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("code")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rs.getString("description")));
            _bw.write(_wl_block8Bytes, _wl_block8);

	   cnt = cnt + 1;
		   if(nClassCount==1)
		   {
			   nClassCount = nClassCount +1;
		   }
		   else
		   {
			   nClassCount = nClassCount -1;
		   }
	  }//while
	 }//if
	   if(cnt == 0)
	   {
		   if(strPostBack != null && strPostBack.equals("true"))
		   {
		  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block10Bytes, _wl_block10);

		   }
	   }
	  
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(SearchText ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(SearchCriteria ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bRadioCode ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bRadioDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);

}catch ( Exception e ){
	out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	ConnectionManager.returnConnection(con,request);
}

		

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
