package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummaryencounterlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryEncounterList.jsp", 1737100348420L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title><!--[IN035950]-->\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' />\n\t\t\n        <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\"../../eCA/js/ResearchPatient.js\" language=\"javascript\"></script>\n\t\t\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<!-- <script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n<form name=chartsummary>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<table border align=\'center\' class=\'grid\' width=\'100%\'>\n\t\t<!-- IN034513 starts-->\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<!-- IN034513 ends-->\n\t\t<tr><td class=\'gridData\'>Date</td><td class=\'gridData\' nowrap>Patient Class</td><td class=\'gridData\' ></td>\t<!--[IN035950] Starts-->\n\n\t\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<tr><td colspan=4 class=CAGROUP >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></td> </tr>\n\t\t\t\t\t<tr><td class=\'gridData\'>Date</td><td class=\'gridData\' nowrap>Patient Class</td><td class=\'gridData\' ></td>\t</tr><!--[IN035950] Starts-->\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<tr title=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"><td class=\'gridData\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td  class=\'gridData\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td  class=\'gridData\'>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t\t\t\t<a class=\'gridLink\' href=\"javascript:showEncounterDialog(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<!--  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  //Commented for IN062564 -->\n\t\t\t\t<a class=\'gridLink\' href=\"javascript:alert(getMessage(\'FUNC_NOTAPP_RESP_RELN\',\'CA\'))\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a> <!-- Added for IN062564 -->\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</table>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<table border  align=\'center\' class=\'grid\' width=\'100%\'  height=\'100%\'>\n\t\t<tr>\n\t\t<td>&nbsp\n\t\t<br><br>\n\t\t<br><br>\n\t\t</td>\n\t\t</tr>\n\t        </table>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<input type=\'hidden\' name=patient_id value=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n\t<input type=\'hidden\' name=Encounter_Id value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n\t<input type=\'hidden\' name=p_called_from_widget  id=p_called_from_widget value=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="><!--IN049663 -->\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.
21/03/2014		IN047977		Nijitha			AAKH-SCF-0106												
21/03/2014	 	IN034513	  	Vijayakumar K 							SS-CRF-0007 In the patient Chart Clinician Access, 
23/04/2014		IN048730		Vijayakumar K							SS-CRF-0007/01 - Only 13 Encounter Details are only displayed																	
23/04/2014		IN048732		Vijayakumar K							ALPHA- CA- Cancelled Admission Record displayed in Encounter Widget
16/06/2014  	IN049663		 Nijitha		HSA_ADHOC_0010
10/01/2017		IN062564		Raja S			12/01/2017		Ramesh G			MO-GN-5511
-------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN049663
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(title));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	
	Connection conn= null;
	PreparedStatement pstmt =null;
	ResultSet rs	 =null;
	String patientid=request.getParameter("patient_id");
	String Encounter_Id=request.getParameter("episode_id");
	//[IN035950] Starts
	String patient_class = request.getParameter("p_encounter");
	if ("null".equals(patient_class) || patient_class==" ") patient_class="";
	//[IN035950] Ends
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	//IN034513 starts	
	String querySpltycode = "select SPECIALTY_CODE service_code from pr_encounter where facility_id=? and encounter_id=?"; //IN034513
	String queryCAWidgetPrm = "SELECT ENC_GRP_BY_SPLTY_YN FROM CA_WIDGET_PARAM"; //IN034513
	String enc_grp_by_splty_yn = "";
	String service_code = "";
	String encounter_id_for_grping = request.getParameter("encounter_id");
	String facilityId_for_grping =	(String)session.getValue( "facility_id" );
	String Sql="";
	String pre_service_ind	=	"*";
	String service_ind = "";
	//IN034513 ends	
	try
	{
		boolean rsval= true;

	String visitdate="",from_date=null,to_date=null;
	String Details ="";

	
	String encounter_dtls1 = "",encounter_dtls2 = "",encounter_dtls="";
	String facilityId = "";
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id == null)resp_id ="";
	String linkFlag="";
	String privilegeStatus=""; //IN062564
	String relnId = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id"); //IN062564
	conn = ConnectionManager.getConnection(request);
	  //reason_for_contact
	 //IN034513 starts
	try
	{
		pstmt = conn.prepareStatement(queryCAWidgetPrm);
		rs = pstmt.executeQuery();
		 while(rs.next())
		{
			enc_grp_by_splty_yn = rs.getString("ENC_GRP_BY_SPLTY_YN");
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
			
		
	}catch(Exception excawidget)
	{
	excawidget.printStackTrace();
	}
	//IN034513 ends	
	//IN062564 starts
	try
	{
		
		pstmt = conn.prepareStatement("SELECT DFLT_PRIVILEGE_STATUS FROM CA_APPL_TASK WHERE APPL_TASK_ID='FLOW_SHEET'");
		rs = pstmt.executeQuery();
		 while(rs.next())
		{
			 privilegeStatus = rs.getString("DFLT_PRIVILEGE_STATUS");
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
			
		
	}catch(Exception apptskawidget)
	{
		apptskawidget.printStackTrace();
	}
	//IN062564 Ends


	 //String Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','O','EM','O','I') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,GET_TASK_APPLICABILITY('FLOW_SHEET',null,?,null) link_flag from pr_encounter_VW a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16)order by visit_adm_date_time desc ";
	   //String Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','O','EM','O','I') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16)order by visit_adm_date_time desc ";//IN035950
	   //String Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16) &&patient_class_filter order by visit_adm_date_time desc ";//IN035950
		//IN034513 starts
		//String Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16) &&patient_class_filter and (visit_status != '99' or visit_status is null) order by visit_adm_date_time desc ";//IN047977		
		if("Y".equals(enc_grp_by_splty_yn))
		{
			try
			{
				pstmt = conn.prepareStatement(querySpltycode);
				pstmt.setString(1, facilityId_for_grping);
				pstmt.setString(2, encounter_id_for_grping);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					service_code = rs.getString("service_code");
				}
				
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}catch(Exception exsplty)
			{
			exsplty.printStackTrace();
			}
			//IN048730 starts
			//Sql="Select decode( SPECIALTY_CODE,'"+service_code+"','Current Specialty Related','Other Specialty Related') service_ind,to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16) &&patient_class_filter and (visit_status != '99' or visit_status is null) order by 1,visit_adm_date_time desc ";
			//IN048732 starts
			//Sql="Select decode( SPECIALTY_CODE,'"+service_code+"','Current Specialty Related','Other Specialty Related') service_ind,to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null)) where RANK_NO <16) &&patient_class_filter  order by 1,visit_adm_date_time desc ";
			//IN048730 ends
			//Sql="Select decode( SPECIALTY_CODE,'"+service_code+"','Current Specialty Related','Other Specialty Related') service_ind,to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null)) where RANK_NO <16) &&patient_class_filter  order by 1,visit_adm_date_time desc "; //Commented for IN062564
			//IN048732 ends
			Sql="Select decode( SPECIALTY_CODE,'"+service_code+"','Current Specialty Related','Other Specialty Related') service_ind,to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,Get_Task_Applicability('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+facilityId_for_grping+"','"+Encounter_Id+"','"+patientid+"') link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null)) where RANK_NO <16) &&patient_class_filter  order by 1,visit_adm_date_time desc ";//Edited for IN062564
		}
		else
		{
			//IN048730 starts
			//Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO <16) &&patient_class_filter and (visit_status != '99' or visit_status is null) order by visit_adm_date_time desc ";//IN047977
			//IN048732 starts
			//Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null)) where RANK_NO <16) &&patient_class_filter order by visit_adm_date_time desc ";
			//IN048730 ends
			//Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,'A' link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null)) where RANK_NO <16) &&patient_class_filter order by visit_adm_date_time desc ";//Commented for IN062564
			//IN048732 ends
			Sql="Select to_char(visit_adm_date_time,'dd/mm/yyyy') visit_date,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') from_date,to_char(least(visit_adm_date_time+7,sysdate),'dd/mm/yyyy')to_date,rtrim(ltrim(SM_GET_DESC.SM_FACILITY_PARAM(a.facility_id,?,'1')||', '||AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')||', '||DECODE (a.assign_care_locn_type,'N', (SELECT LONG_DESC  FROM ip_nursing_unit_lang_vw WHERE nursing_unit_code=a.assign_care_locn_code AND facility_id = a.facility_id and language_id = ?),(SELECT LONG_DESC FROM op_clinic_lang_vw WHERE clinic_code = a.assign_care_locn_code     AND facility_id = a.facility_id and language_id = ?))||', '|| (CASE  WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw    WHERE practitioner_id = a.attend_practitioner_id and language_id = ?) END),','),',')Details,decode(PATIENT_CLASS,'OP','OP','EM','OP','IP') PATIENT_CLASS,encounter_id,(select 'Problem: ' ||DIAG_DESC from pr_problem where ONSET_FACILITY_ID=a.facility_id  and ONSET_ENCOUNTER_ID=a.encounter_id and primary_yn='Y' and rownum=1) Encounter_dtls1,(select ' Contact Reason : '||AM_GET_DESC.AM_CONTACT_REASON(a.contact_reason_code,?,'1') from dual) Encounter_dtls2,a.facility_id,Get_Task_Applicability('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+facilityId_for_grping+"','"+Encounter_Id+"','"+patientid+"') link_flag from pr_encounter a where (facility_id,encounter_id) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? and (visit_status != '99' or visit_status is null) AND (ADT_STATUS != '09' or ADT_STATUS is null)) where RANK_NO <16) &&patient_class_filter order by visit_adm_date_time desc ";//Edited for IN062564
		}
		//IN034513 ends	
	//[IN035950] Starts
	   if((!"".equals(patient_class)) && (null!=patient_class)){
		   Sql=Sql.replace("&&patient_class_filter", " and a.patient_class =?");	
		}
		else{
			Sql=Sql.replace("&&patient_class_filter", "");
		}
	//[IN035950] End
	  pstmt = conn.prepareStatement(Sql);

	   pstmt.setString(1, locale);
	    pstmt.setString(2, locale);
	   pstmt.setString(3, locale);
	    pstmt.setString(4, locale);
	    pstmt.setString(5, locale);
		 pstmt.setString(6, locale);

	//  pstmt.setString(7, resp_id);
	  pstmt.setString(7, patientid);
	//  pstmt.setString(3, patientid);
	//[IN035950] Starts
	if((!"".equals(patient_class)) && (null!=patient_class)){
		System.out.println("ChartSummaryEncounterList.jsp:Line:83");
	  pstmt.setString(8, patient_class);
	}
	//[IN035950] Ends
	  rs = pstmt.executeQuery();

            _bw.write(_wl_block11Bytes, _wl_block11);

		 if (rsval==true)
		 {

            _bw.write(_wl_block12Bytes, _wl_block12);

		if(!("Y".equals(enc_grp_by_splty_yn)))
		{
		
            _bw.write(_wl_block13Bytes, _wl_block13);

		} //IN034513 -- added
		int row=1;
      		String classValue="";

	        while(rs.next())
		{
		 try
		  {
		   if ( row%2 == 0 )
			classValue="QRYEVEN";
		   else
			classValue="QRYODD";

			visitdate=rs.getString("visit_date");

			if(visitdate == null)
				visitdate = "";

			visitdate = com.ehis.util.DateUtils.convertDate(visitdate,"DMY","en",locale);

			Details =rs.getString("Details");
			from_date = rs.getString("from_date");
			to_date = rs.getString("to_date");
			facilityId = rs.getString("facility_id")==null?"":rs.getString("facility_id");
			linkFlag = rs.getString("link_flag")==null?"X":rs.getString("link_flag");
			String patientclass = rs.getString("PATIENT_CLASS")==null?"&nbsp;":rs.getString("PATIENT_CLASS");
			Encounter_Id=rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
			encounter_dtls1 = rs.getString("Encounter_dtls1")==null?"":rs.getString("Encounter_dtls1");
			encounter_dtls2 = rs.getString("Encounter_dtls2")==null?"":rs.getString("Encounter_dtls2");
			if (Details==null)
			{
			    Details="&nbsp";
			}
			encounter_dtls = encounter_dtls1+encounter_dtls2;
			//IN034513 starts
			if("Y".equals(enc_grp_by_splty_yn))
			{
				service_ind		=	rs.getString("service_ind")==null?"":rs.getString("service_ind");
				if (!pre_service_ind.equals(service_ind))
				{
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(service_ind));
            _bw.write(_wl_block15Bytes, _wl_block15);
 
					pre_service_ind=service_ind;
				}
			}
			
			//IN034513 ends
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_dtls));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(visitdate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(linkFlag.equals("A")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Details));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Details));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Details));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

			row++;
		}
		catch(Exception e)
		{
			//out.println("error"+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		 }
		}

		rsval=false;

            _bw.write(_wl_block28Bytes, _wl_block28);

	       }
		else if (rsval==false)
	       {

            _bw.write(_wl_block29Bytes, _wl_block29);
		}

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	}
	catch (Exception e)
	{
		//out.println("Errors have occured"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		
		if (conn != null) ConnectionManager.returnConnection(conn,request);
	}


            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_called_from));
            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
