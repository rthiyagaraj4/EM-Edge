package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkhistreptree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkHistRepTree.jsp", 1709116165169L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart4.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<form name=\"documents_detail_form\" id=\"documents_detail_form\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<table cellspacing=0 cellpadding=0 width=\'100%\' border=1 id=\'tb1\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</table>\n<!-- <input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"> -->\n<input type=\"hidden\" name=\"hist_rec_type\" id=\"hist_rec_type\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\"hidden\" name=\"totalDateCount\" id=\"totalDateCount\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\"hidden\" name=\"totalEventClassCount\" id=\"totalEventClassCount\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<input type=\"hidden\" name=\"totalEventGroupCount\" id=\"totalEventGroupCount\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=\"hidden\" name=\"totalEventCount\" id=\"totalEventCount\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name=\"data_type\" id=\"data_type\" value=\"\">\n<input type=\"hidden\" name=\"selected_events\" id=\"selected_events\" value=\"\">\n</form>\n</body>\n</html>\n\n";
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
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con	= ConnectionManager.getConnection(request);
	PreparedStatement stmt	= null;//con.createStatement();
	ResultSet rs			= null;

	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");


	//out.println("QUERY STRING " +request.getQueryString());
	
    String  patientid = "";
    String  hist_rec_type	 = "";
	String  class1	 = "";
    String  event_group	 = "";
    String  abnormal	 = "";
	String  comp_id	 = "";
    String  comp_val	 = "";
    String  search_criteria	 = "";
    String  current_encounter	 = "";
    String  order_by1	 = "";
    String  order_by2	 = "";

	String result_linked_rec_type	= request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	
	 patientid		=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
    
	//out.println("<script>alert('patient_id result"+patientid+"');</script>");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");

	class1		=	(request.getParameter("class")==null)	?	""	:	request.getParameter("class");
	
	event_group		=	(request.getParameter("event_group")==null)	?	""	:	request.getParameter("event_group");
	
	abnormal		=	(request.getParameter("abnormal")==null)	?	""	:	
	request.getParameter("abnormal");
	
	comp_id		=	(request.getParameter("comp_id")==null)	?	""	:	request.getParameter("comp_id");
	
	comp_val		=	(request.getParameter("comp_val")==null)	?	""	:	request.getParameter("comp_val");
	
	search_criteria		=	(request.getParameter("search_criteria")==null)	?	""	:	request.getParameter("search_criteria");
	
	current_encounter		=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter");
	
	order_by1		=	(request.getParameter("order_by1")==null)	?	""	:	request.getParameter("order_by1");
	
	order_by2		=	(request.getParameter("order_by2")==null)	?	""	:	request.getParameter("order_by2");

	String facility_id				= (String) session.getValue("facility_id");
	String preveventclassCode = "";
	String preveventgroupCode = "";
	String preveventdate = "";
	String prevNewEventGroup = "";
	String prevMedType = "";
	String classValue = "";
	StringBuffer sql= new StringBuffer();
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id == null)resp_id ="";
	int i=0;
	int j=0;
	int k = 0;
	int l = 0;


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{
		if ( result_linked_rec_type.equals("DIAG") )
		{
			//sql.append(" Select a.ONSET_DATE EVENT_DATE ,to_char(a.ONSET_DATE,'dd/mm/yyyy hh24:mi') e_date,'DIAG' hist_rec_type ,'Diagnosis' hist_rec_type_desc ,b.SPECIALTY_CODE event_class ,b.SPECIALTY_CODE event_class_original ,c.long_desc  event_class_desc ,a.DIAG_TYPE event_group ,a.DIAG_TYPE event_group_original ,decode(a.DIAG_TYPE,'D','Differential','F','Final','P','Provisional')  event_group_desc ,a.DIAG_CODE event_code ,a.DIAG_CODE event_code_original ,a.DIAG_CODE||','||diag_desc||', Stage:'||decode(a.IP_DIAG_STAGE,'A','Admission','I','Intermediate','D','Discharge','')||', Onset Date:'||to_char(a.ONSET_DATE,'dd/mm/yyyy')||decode(a.SENSITIVE_YN,'Y',', Sensitive','')||decode(a.NOTIFIABLE_YN,'Y',', Notifiable','')||decode(PROBLEM_REMARKS,null,null,'<br> <b> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+":<br></b>'||replace(PROBLEM_REMARKS,chr(10),'<br>'))  event_code_desc ,'DIAG' hist_data_type, a.diag_code accession_num ,null contr_sys_id, null contr_sys_event_code ,0 rec_count FROM pr_problem a, am_speciality C, pr_encounter B where b.facility_id=a.ONSET_facility_id and B.encounter_id=A.ONSET_encounter_id and c.SPECIALiTY_CODE(+) =b.SPECIALTY_CODE AND a.patient_id =? ");
			sql.append("Select a.ONSET_DATE EVENT_DATE ,to_char(a.ONSET_DATE,'dd/mm/yyyy hh24:mi') e_date, f.hist_rec_type ,F.short_desc hist_rec_type_desc ,b.SPECIALTY_CODE event_class ,b.SPECIALTY_CODE event_class_original ,c.long_desc  event_class_desc ,a.DIAG_TYPE event_group ,a.DIAG_TYPE event_group_original ,a.DIAG_TYPE  event_group_desc ,a.DIAG_CODE event_code ,a.DIAG_CODE event_code_original ,a.DIAG_CODE||','||diag_desc||', Stage:'||a.IP_DIAG_STAGE||', Onset Date:'||to_char(a.ONSET_DATE,'dd/mm/yyyy')||a.SENSITIVE_YN||a.NOTIFIABLE_YN||PROBLEM_REMARKS)  event_code_desc ,F.hist_rec_type  hist_data_type, a.diag_code accession_num ,null contr_sys_id, null contr_sys_event_code ,0 rec_count FROM pr_problem a, am_speciality_lang_vw C, pr_encounter B,CR_HIS_RECTYP_LNG_VW F  where f.hist_rec_type = 'DIAG' and c.language_id = ? and b.facility_id=a.ONSET_facility_id and B.encounter_id=A.ONSET_encounter_id and c.SPECIALiTY_CODE(+) =b.SPECIALTY_CODE AND a.patient_id =? ");
		}
		else if ( result_linked_rec_type.equals("MEDN") )
		{
			//sql.append(" Select distinct a.START_DATE EVENT_DATE ,to_char(a.START_DATE,'dd/mm/yyyy hh24:mi') e_date,'MEDN' hist_rec_type ,'Medication' hist_rec_type_desc ,b.SPECIALTY_CODE event_class ,b.SPECIALTY_CODE event_class_original ,c.long_desc  event_class_desc ,a.GENERIC_ID event_group ,a.GENERIC_ID event_group_original ,GENERIC_NAME  event_group_desc ,a.DRUG_CODE event_code ,a.DRUG_CODE event_code_original , e.form_code||' '||e.DRUG_DESC||' '||RTRIM(RTRIM(TO_CHAR(a.dosage,'9999999999999990.999999999999'),'0'),'.') ||' '||a.dosage_uom_code||' '||a.FREQ_CODE||' * '||a.DURATION||' '||f.DURN_DESC||' Period:'||to_char(a.start_date,'dd/mm/yy')||'-'||to_char(a.end_date,'dd/mm/yy')||' Prescribed by :'||(select short_name from am_practitioner where practitioner_id=a.PRES_PRACTITIONER_ID)||'  '||decode(ON_HOLD_BY_ID,null,null,'Put on hold by '||(select short_name from am_practitioner where practitioner_id=ON_HOLD_BY_ID)||' on ' || to_char(ON_HOLD_DATE_TIME,'dd/mm/yyyy hh24:mi')) ||decode(DISCONT_BY_ID,null,null,'Discontinued by '||(select short_name from am_practitioner where practitioner_id=DISCONT_BY_ID)||' on ' || to_char(DISCONT_DATE_TIME,'dd/mm/yyyy hh24:mi'))|| decode(STOP_PRACTITIONER_ID,null,null,'Stopped by '||(select short_name from am_practitioner where practitioner_id=STOP_PRACTITIONER_ID)||' on '|| to_char(STOP_DATE_TIME,'dd/mm/yyyy hh24:mi')) event_code_desc ,'MEDN' hist_data_type, a.DRUG_CODE accession_num ,null contr_sys_id, null contr_sys_event_code  ,0 rec_count,(SELECT DECODE(DISCHARGE_IND,'D','Discharge Prescription','Inpatient Prescription')  FROM OR_ORDER WHERE ORDER_ID=ORIG_ORDER_ID) med_type  FROM ph_patient_drug_profile a,  am_speciality C, pr_encounter B ,PH_GENERIC_NAME D, ph_drug e,am_duration_type f, am_frequency g  where b.facility_id=a.facility_id and  B.encounter_id=A.encounter_id and c.SPECIALiTY_CODE =b.SPECIALTY_CODE AND D.GENERIC_ID=A.GENERIC_ID AND e.DRUG_CODE=a.DRUG_CODE AND g.freq_code(+)=a.FREQ_CODE AND f.durn_type(+)=g.INTERVAL_DURN_TYPE and a.CANCEL_YN='N' and a.facility_id = ? and a.patient_id =? ");
			sql.append(" Select distinct a.START_DATE EVENT_DATE ,to_char(a.START_DATE,'dd/mm/yyyy hh24:mi') e_date,h.hist_rec_type  hist_rec_type, h.short_desc  hist_rec_type_desc ,b.SPECIALTY_CODE event_class ,b.SPECIALTY_CODE event_class_original ,c.long_desc  event_class_desc ,a.GENERIC_ID event_group ,a.GENERIC_ID event_group_original ,GENERIC_NAME  event_group_desc ,a.DRUG_CODE event_code ,a.DRUG_CODE event_code_original , e.form_code||' '||e.DRUG_DESC||' '||RTRIM(RTRIM(TO_CHAR(a.dosage,'9999999999999990.999999999999'),'0'),'.') ||' '||a.dosage_uom_code||' '||a.FREQ_CODE||' * '||a.DURATION||' '||f.DURN_DESC||' Period:'||to_char(a.start_date,'dd/mm/yy')||'-'||to_char(a.end_date,'dd/mm/yy')||' Prescribed by :'||AM_GET_DESC.AM_PRACTITIONER(A.PRES_PRACTITIONER_ID,?,'2')||'  '||decode(ON_HOLD_BY_ID,null,null,'Put on hold by '||AM_GET_DESC.AM_PRACTITIONER(ON_HOLD_BY_ID,?,'2')||' on ' || to_char(ON_HOLD_DATE_TIME,'dd/mm/yyyy hh24:mi')) ||decode(DISCONT_BY_ID,null,null,'Discontinued by '||AM_GET_DESC.AM_PRACTITIONER(DICONT_BY_ID,?,'2')||' on ' || to_char(DISCONT_DATE_TIME,'dd/mm/yyyy hh24:mi'))|| decode(STOP_PRACTITIONER_ID,null,null,'Stopped by '||AM_GET_DESC.AM_PRACTITIONER(STOP_PRACTITIONER_ID,?,'2')||' on '|| to_char(STOP_DATE_TIME,'dd/mm/yyyy hh24:mi')) event_code_desc ,'MEDN' hist_data_type, a.DRUG_CODE accession_num ,null contr_sys_id, null contr_sys_event_code  ,0 rec_count,(SELECT DISCHARGE_IND FROM OR_ORDER WHERE ORDER_ID=ORIG_ORDER_ID) med_type  FROM ph_patient_drug_profile a,  am_speciality_lang_vw C, pr_encounter B ,PH_GENERIC_NAME D, ph_drug e,am_duration_type_lang_vw f, am_frequency_lang_vw g, CR_HIS_RECTYP_LNG_VW H  where h.hist_rec_type = 'MEDN' and c.language_id = ? h.language_id = ? and b.facility_id=a.facility_id and  f.language_id = ? and g.language_id = ?  and B.encounter_id=A.encounter_id and c.SPECIALiTY_CODE =b.SPECIALTY_CODE AND D.GENERIC_ID=A.GENERIC_ID AND e.DRUG_CODE=a.DRUG_CODE AND g.freq_code(+)=a.FREQ_CODE AND f.durn_type(+)=g.INTERVAL_DURN_TYPE and a.CANCEL_YN='N' and a.facility_id = ? and a.patient_id =? ");
		}

		else
		{
			
		//sql.append(" Select a.EVENT_DATE ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') e_date ,a.hist_rec_type hist_rec_type ,b.short_desc hist_rec_type_desc ,translate(a.event_class,'!@#$%^&*()','1234567890') event_class ,a.event_class event_class_original ,c.long_desc  event_class_desc  ,translate(a.event_group,'!@#$%^&*()','1234567890') event_group ,a.event_group event_group_original ,e.long_desc  event_group_desc ,translate(a.event_code,'!@#$%^&*()','1234567890') event_code ,a.event_code event_code_original ,d.long_desc  event_code_desc  ,hist_data_type, a.accession_num ,a.contr_sys_id, a.contr_sys_event_code ,count(*) rec_count  From cr_encounter_detail a  ,cr_hist_rec_type b  ,cr_event_class   c  ,cr_clin_event_mast d  ,cr_clin_event_group e  where b.hist_rec_type=a.hist_rec_type  and  c.hist_rec_type=a.hist_rec_type  and  c.event_class= a.event_class  and  d.hist_rec_type=a.hist_rec_type  and  d.event_code=a.event_code  and  e.hist_rec_type(+)=a.hist_rec_type  and  e.event_group(+)=a.event_group  and a.hist_rec_type = ?  and a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR (nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,NULL)='A')) and nvl(a.STATUS,'NYSE') not in ('S','E')  group by a.EVENT_DATE, to_char(a.event_date,'dd/mm/yyyy hh24:mi'), a.hist_rec_type, b.short_desc  ,a.event_class,c.long_desc,a.event_group  ,d.long_desc, a.event_code, e.long_desc, hist_data_type, a.accession_num , a.contr_sys_id, a.contr_sys_event_code ");
		sql.append(" Select a.EVENT_DATE ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') e_date ,a.hist_rec_type hist_rec_type ,b.short_desc hist_rec_type_desc ,translate(a.event_class,'!@#$%^&*()','1234567890') event_class ,a.event_class event_class_original ,c.long_desc  event_class_desc  ,translate(a.event_group,'!@#$%^&*()','1234567890') event_group ,a.event_group event_group_original ,e.long_desc  event_group_desc ,translate(a.event_code,'!@#$%^&*()','1234567890') event_code ,a.event_code event_code_original ,d.long_desc  event_code_desc  ,hist_data_type, a.accession_num ,a.contr_sys_id, a.contr_sys_event_code ,count(*) rec_count  From cr_encounter_detail a  ,cr_hist_rec_type_lang_Vw b  ,CR_EVENT_CLASS_LANG_VW   c  ,CR_CLN_EVT_MST_LANG_VW d  ,CR_CLN_EVT_GRP_LANG_VW e  where b.hist_rec_type=a.hist_rec_type  and  c.hist_rec_type=a.hist_rec_type  and  c.event_class= a.event_class  and  b.language_id = ? and c.language_id = ? and d.language_id = ? e.language_id = ? and d.hist_rec_type=a.hist_rec_type  and  d.event_code=a.event_code  and  e.hist_rec_type(+)=a.hist_rec_type  and  e.event_group(+)=a.event_group  and a.hist_rec_type = ?  and a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR (nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,NULL)='A')) and nvl(a.STATUS,'NYSE') not in ('S','E')  group by a.EVENT_DATE, to_char(a.event_date,'dd/mm/yyyy hh24:mi'), a.hist_rec_type, b.short_desc  ,a.event_class,c.long_desc,a.event_group  ,d.long_desc, a.event_code, e.long_desc, hist_data_type, a.accession_num , a.contr_sys_id, a.contr_sys_event_code ");

		}
		if ( result_linked_rec_type.equals("MEDN") )
			sql.append(" order by med_type, 1 desc ,5,8,11 ");
		else
			sql.append(" order by 1 desc,5,8 nulls first,11");	
		//out.println(sql);
		stmt = con.prepareStatement(sql.toString());
		if ( result_linked_rec_type.equals("DIAG") )
		{
			stmt.setString(1, locale);
			stmt.setString(2, patientid);			
		}
		else if ( result_linked_rec_type.equals("MEDN") )
		{
			stmt.setString(1, locale);
			stmt.setString(2, locale);
			stmt.setString(3, locale);
			stmt.setString(4, locale);
			stmt.setString(5, locale);
			stmt.setString(6, locale);
			stmt.setString(7, locale);
			stmt.setString(8, locale);
			stmt.setString(9, facility_id);
			stmt.setString(10,patientid);
		}
		else
		{
			
			stmt.setString(1, locale);
			stmt.setString(2, locale);
			stmt.setString(3, locale);
			stmt.setString(4, locale);
			stmt.setString(5, result_linked_rec_type);
			stmt.setString(6, patientid);
			stmt.setString(7, resp_id);
		}

		rs = stmt.executeQuery();
		int counterForCode=0;
		int counterForCodeForNullGroup=0;
		int counterForGroup=0;
		int counterForClass=0;

		int prevCounterForClass=0;
		
		String eventclassdesc = "",eventclassdescPrev ="";
		String eventgroupdesc = "",eventgroupdescPrev="";
		String eventcodedesc = "",eventcodedescPrev="";
		
		String newEventClassCode = "",newEventClassCodePrev="";	
		String eventgroupcode	= "",eventgroupcodePrev="";
		String newEventGroupCode = "",newEventGroupCodePrev="";
		String accessionnum = "",accessionnumPrev="";
		String value	= "", valuePrev="";                           
		String eventdatetime = "";//,eventdatetimePrev="";
		String eventdate = "",eventdatePrev="";
		String eventtime = "",eventtimePrev="";
		String eventDateWithoutSlash="",eventDateWithoutSlashPrev ="";
		String eventTimeWithoutColon="",eventTimeWithoutColonPrev = "";
		String medType ="",medTypePrev="";
		String eventClassOriginal="",eventClassOriginalPrev="";
		String eventGroupOriginal="",eventGroupOriginalPrev="";
		String eventCodeOriginal="",eventCodeOriginalPrev="";
		String strMedType	="";
		
		int recordCounter = 0;

		if(rs != null)
		{
			while (rs.next())
			{
				
				
				//histtypedesc	= rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
				eventclassdesc	= rs.getString("event_class_desc")==null?"":"&nbsp;"+rs.getString("event_class_desc");
				//eventgroupdesc	= rs.getString("event_group_desc")==null?"":"&nbsp;&nbsp;"+rs.getString("event_group_desc");
				eventgroupdesc		= rs.getString("event_group_desc")==null?"":"&nbsp;&nbsp;"+rs.getString("event_group_desc");
				eventcodedesc	= rs.getString("event_code_desc")==null?"":"&nbsp;&nbsp;&nbsp;"+rs.getString("event_code_desc");
				//eventclasscode	= rs.getString("event_class")==null?"":"&nbsp;"+rs.getString("event_class");
				newEventClassCode = rs.getString("event_class")==null?"":rs.getString("event_class");
				eventgroupcode	= rs.getString("event_group")==null?"":"&nbsp;&nbsp;"+rs.getString("event_group");
				newEventGroupCode = rs.getString("event_group")==null?"_":rs.getString("event_group");
				//eventcode	= rs.getString("event_code")==null?"":"&nbsp;&nbsp;&nbsp;"+rs.getString("event_code");
				accessionnum = rs.getString("accession_num");
				//reccount	= "&nbsp;("+rs.getString("rec_count")+")";
				eventdatetime	= rs.getString("e_date")==null?"":rs.getString("e_date");
				eventClassOriginal = rs.getString("event_class_original")==null?"":rs.getString("event_class_original");
				eventGroupOriginal = rs.getString("event_group_original")==null?"":rs.getString("event_group_original");
				eventCodeOriginal  = rs.getString("event_code_original")==null?"":rs.getString("event_code_original");
				
				//
				if(eventgroupdesc.equals("D"))
					eventgroupdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
				else if(eventgroupdesc.equals("F"))
					eventgroupdesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");
				else if(eventgroupdesc.equals("P"))
					eventgroupdesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
				else
					eventgroupdesc = eventgroupdesc;
				
				//
				eventdate = eventdatetime.substring(0,eventdatetime.indexOf(" "));
				eventtime = eventdatetime.substring(eventdatetime.indexOf(" "));
				
				
				value = rs.getString("accession_num")+"~"+rs.getString("hist_data_type")+"~"+rs.getString("hist_rec_type")+"~"+rs.getString("contr_sys_id")+"~"+rs.getString("contr_sys_event_code")+"~";
				
				value = value + eventdatetime+"~";
				
				eventDateWithoutSlash=eventdate.replace('/','k').trim();
				eventTimeWithoutColon=eventtime.replace(':','c').trim(); 
				
				if ( result_linked_rec_type.equals("MEDN"))
				{
					//medType = rs.getString("med_type")==null?"Inpatient Prescription":rs.getString("med_type");
					strMedType= rs.getString("med_type");

					if(strMedType == null) strMedType = "";

					if(strMedType.equals("D"))
						medType= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Prescription.label","ph_labels");
					else 
						medType= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Prescription.label","ph_labels"); 
				}
				
				//******************************************************//
				//actual priniting of the tree starts from here
				//remember the printing is the record fetched prior to this record ie it is one fetch behind
				//this is done so as to get the next time of the recorded event
				if(recordCounter > 0)
				{
					if ( result_linked_rec_type.equals("MEDN"))
					{
						
						if(!prevMedType.equals(medTypePrev))
						{
							out.println("<tr  ><td class='columnheader'  colspan=2><font size=2>"+medType+"</font></td></tr>");
							prevMedType = medTypePrev;
						}
					}
					if(!eventdatePrev.equals("") && !preveventdate.equals(eventdatePrev))
					{
						counterForCode=0;
						counterForGroup=0;
						counterForClass=0;
						counterForCodeForNullGroup=0;
						if ( result_linked_rec_type.equals("DIAG")||result_linked_rec_type.equals("MEDN") )
						{
							out.println("<tr><td colspan=2 class='COMMONTOOLBARFUNCTION'><font size=1>"+eventdatePrev+"</font></td></tr>");
						}
						else
						{
							
							out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev+"','Heading')\" class='COMMONTOOLBARFUNCTION'><font size=1>"+eventdatePrev+"</font></td><td class='COMMONTOOLBARFUNCTION'><input type='checkbox'   onClick=\"showDetails('"+valuePrev+"','Heading');CheckAllClass('"+newEventGroupCodePrev+"','"+eventDateWithoutSlashPrev+"','"+newEventClassCodePrev+"',this);\"></td></tr>");
						}

						//<td class='COMMONTOOLBARFUNCTION'><input type='checkbox' name='checkBoxDate_"+i+"' id='checkBoxDate_"+i+"' id='"+accessionnum+"' value='"+eventdatetime+"'> </td>
						 preveventclassCode = "";
						 preveventgroupCode = "";
						 i++;
					}
					valuePrev = valuePrev + eventClassOriginalPrev+"~" ;
					//if(!eventclassdesc.equals("") && (!preveventclassdesc.equals(eventclassdesc) ||!preveventdate.equals(eventdate)))
					if(!newEventClassCodePrev.equals("") && (!preveventclassCode.equals(newEventClassCodePrev) ||!preveventdate.equals(eventdatePrev)))
					{
						counterForCode=0;
						counterForGroup=0;
						counterForCodeForNullGroup=0;
						if ( result_linked_rec_type.equals("DIAG")||result_linked_rec_type.equals("MEDN") )
						{
							out.println("<tr><td colspan=2 class='CAGROUP'><font size=1>"+eventclassdescPrev+"</font></td></tr>");
						}
						else
						{
							out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev+"','Heading')\" class='CAGROUP'><font size=1>"+eventclassdescPrev+"</font></td><td class='CAGROUP'><input type='checkbox'   value='"+newEventClassCodePrev+"~"+newEventGroupCodePrev+"' title='"+eventTimeWithoutColonPrev+"' name='a"+eventDateWithoutSlashPrev+counterForClass+"' id='a"+eventDateWithoutSlashPrev+counterForClass+"' onClick=\"showDetails('"+valuePrev+"','Heading');CheckAllGroup('"+newEventGroupCodePrev+"','"+eventDateWithoutSlashPrev+"','"+newEventClassCodePrev+"',this,"+counterForClass+")\"></td></tr>");
						}
						j++;
						prevCounterForClass=counterForClass;
						counterForClass++;
						//<td class='CAGROUP'><input type='checkbox' name='checkBoxEventClass_"+j+"' id='checkBoxEventClass_"+j+"' id='"+accessionnum+"' value='"+eventclasscode+"'></td>
					}
					valuePrev = valuePrev + eventGroupOriginalPrev+"~" ;
					
					//if(!eventgroupdesc.equals("") && (!preveventgroupdesc.equals(eventgroupdesc)||!preveventclassdesc.equals(eventclassdesc) ||(!preveventdate.equals(eventdate))))
					if(!eventgroupcodePrev.equals("") && (!preveventgroupCode.equals(eventgroupcodePrev)||!preveventclassCode.equals(newEventClassCodePrev) ||(!preveventdate.equals(eventdatePrev))))
					{
						counterForCode=0;
						//counterForGroup=0;
						if ( result_linked_rec_type.equals("DIAG")||result_linked_rec_type.equals("MEDN") )
						{
							out.println("<tr><td colspan=2 class='CAFOURTHLEVELCOLOR'><font size=1>"+eventgroupdescPrev+"</font></td></tr>");
						}
						else
						{
							out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev+"','Heading')\" class='CAFOURTHLEVELCOLOR'><font size=1>"+eventgroupdescPrev+"</font></td><td class='CAFOURTHLEVELCOLOR'><input type='checkbox' name='a"+eventDateWithoutSlashPrev+prevCounterForClass+newEventClassCodePrev+counterForGroup+"' id='a"+eventDateWithoutSlashPrev+prevCounterForClass+newEventClassCodePrev+counterForGroup+"'  value='"+newEventGroupCodePrev+"' title='"+eventTimeWithoutColonPrev+"'  onClick=\"showDetails('"+valuePrev+"','Heading');CheckAllCode('"+newEventGroupCodePrev+"','"+eventDateWithoutSlashPrev+"','"+newEventClassCodePrev+"',this,"+prevCounterForClass+",'"+eventTimeWithoutColonPrev+"');\"></td></tr>");
						}
						k++;
						counterForGroup++;
						//<td class='CAFOURTHLEVELCOLOR'><input type='checkbox' name='checkBoxEventGroup_"+k+"' id='checkBoxEventGroup_"+k+"' id='"+accessionnum+"' value='"+eventgroupcode+"'>
					}
					valuePrev+=eventCodeOriginalPrev;
					if(l%2==0)
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";
					
					if(!newEventGroupCodePrev.equals(prevNewEventGroup))
					{
						counterForCode=0;
					}
					if ( result_linked_rec_type.equals("DIAG")||result_linked_rec_type.equals("MEDN") )
					{
						out.println("<tr id='tblrow_id"+l+"' title='"+prevMedType+"'><td class='"+classValue+"'><font size=1>"+"&nbsp;&nbsp;"+eventcodedescPrev+"</font></td><td class='"+classValue+"'><input type='checkbox' name='checkBoxEventCode_"+l+"' id='checkBoxEventCode_"+l+"' id='"+accessionnumPrev+"' value='"+valuePrev+"' onClick='OnCheckBoxClick(this)'></td></tr>");
					}
					else
					{
						if(newEventGroupCodePrev.equals("_"))
						{
							counterForCode = counterForCodeForNullGroup;
							counterForCodeForNullGroup++;
						}
						out.println("<tr id='tblrow_id"+l+"'><td onClick=\"javascript:showDetails('"+valuePrev+"')\" class='"+classValue+"'><font size=1>"+"&nbsp;&nbsp;"+eventtimePrev+eventcodedescPrev+"</font></td><td class='"+classValue+"'><input type='checkbox' title='"+eventTimeWithoutColon+"' name='a"+eventDateWithoutSlashPrev+prevCounterForClass+newEventClassCodePrev+newEventGroupCodePrev+eventTimeWithoutColonPrev+counterForCode+"' id='a"+eventDateWithoutSlashPrev+prevCounterForClass+newEventClassCodePrev+newEventGroupCodePrev+eventTimeWithoutColonPrev+counterForCode+"' id='"+accessionnumPrev+"' value='"+valuePrev+"' onClick='OnCheckBoxClick(this)'></td></tr>");						
						
					}
					l++;
					counterForCode++;
								
					preveventdate = eventdatePrev ;
					preveventclassCode = newEventClassCodePrev;
					preveventgroupCode = eventgroupcodePrev;
					//preveventcodedesc = eventcodedesc;
					prevNewEventGroup = newEventGroupCodePrev;
				}
				//*****************************************************************/
				//histtypedescPrev = histtypedesc;       
				eventclassdescPrev = eventclassdesc;    
				eventgroupdescPrev = eventgroupdesc;    
				eventcodedescPrev = eventcodedesc;    
				//eventclasscodePrev = eventclasscode;    
				newEventClassCodePrev = newEventClassCode;	    
				eventgroupcodePrev= eventgroupcode;   
				newEventGroupCodePrev= newEventGroupCode;
				//eventcodePrev = eventcode;      
				accessionnumPrev = accessionnum;
				//reccountPrev = reccount;               
				valuePrev = value;          
				//eventdatetimePrev = eventdatetime; 
				eventdatePrev = eventdate;
				eventtimePrev = eventtime;
				eventDateWithoutSlashPrev = eventDateWithoutSlash;
				eventTimeWithoutColonPrev = eventTimeWithoutColon;
				eventClassOriginalPrev= eventClassOriginal;
				eventGroupOriginalPrev= eventGroupOriginal;
				eventCodeOriginalPrev= eventCodeOriginal;
				
				if ( result_linked_rec_type.equals("MEDN"))
				{
					medTypePrev=medType;                          
				}
				recordCounter++;
			}//end of while
			
			//**************************************************************//
			//printing the last record
			if(recordCounter>0)
			{
				if (result_linked_rec_type.equals("MEDN"))
				{
					
					if(!prevMedType.equals(medTypePrev))
					{
						out.println("<tr  ><td class='columnheader' align=left colspan=2><font size=2>"+medType+"</font></td></tr>");
						//prevMedType = medTypePrev;
					}
				}
				if(!eventdatePrev.equals("") && !preveventdate.equals(eventdatePrev))
				{
					counterForCode=0;
					counterForGroup=0;
					counterForClass=0;
					counterForCodeForNullGroup=0;
					if ( result_linked_rec_type.equals("DIAG")||result_linked_rec_type.equals("MEDN") )
					{
						out.println("<tr><td colspan=2 class='COMMONTOOLBARFUNCTION'><font size=1>"+eventdatePrev+"</font></td></tr>");
					}
					else
					{
						out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev+"','Heading')\" class='COMMONTOOLBARFUNCTION'><font size=1>"+eventdatePrev+"</font></td><td class='COMMONTOOLBARFUNCTION'><input type='checkbox'   onClick=\"showDetails('"+valuePrev+"','Heading');CheckAllClass('"+newEventGroupCodePrev+"','"+eventDateWithoutSlashPrev+"','"+newEventClassCodePrev+"',this);\"></td></tr>");
					}
					 preveventclassCode = "";
					 preveventgroupCode = "";
					 i++;
				}
				valuePrev = valuePrev + eventClassOriginalPrev+"~" ;
				if(!newEventClassCodePrev.equals("") && (!preveventclassCode.equals(newEventClassCodePrev) ||!preveventdate.equals(eventdatePrev)))
				{
					counterForCode=0;
					counterForGroup=0;
					counterForCodeForNullGroup=0;
					if ( result_linked_rec_type.equals("DIAG")||result_linked_rec_type.equals("MEDN") )
					{
						out.println("<tr><td colspan=2 class='CAGROUP'><font size=1>"+eventclassdescPrev+"</font></td></tr>");
					}
					else
					{
						
						out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev+"','Heading')\" class='CAGROUP'><font size=1>"+eventclassdescPrev+"</font></td><td class='CAGROUP'><input type='checkbox'   value='"+newEventClassCodePrev+"~"+newEventGroupCodePrev+"' title='"+eventTimeWithoutColonPrev+"' name='a"+eventDateWithoutSlashPrev+counterForClass+"' id='a"+eventDateWithoutSlashPrev+counterForClass+"' onClick=\"showDetails('"+valuePrev+"','Heading');CheckAllGroup('"+newEventGroupCodePrev+"','"+eventDateWithoutSlashPrev+"','"+newEventClassCodePrev+"',this,"+counterForClass+");\"></td></tr>");
					}
					j++;
					prevCounterForClass=counterForClass;
					counterForClass++;
				}
				valuePrev = valuePrev + eventGroupOriginalPrev+"~" ;
				
				if(!eventgroupcodePrev.equals("") && (!preveventgroupCode.equals(eventgroupcodePrev)||!preveventclassCode.equals(newEventClassCodePrev) ||(!preveventdate.equals(eventdatePrev))))
				{
					counterForCode=0;
					//counterForGroup=0;
					if ( result_linked_rec_type.equals("DIAG")||result_linked_rec_type.equals("MEDN") )
					{
						out.println("<tr><td colspan=2 class='CAFOURTHLEVELCOLOR'><font size=1>"+eventgroupdescPrev+"</font></td></tr>");
					}
					else
					{
							
						out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev+"','Heading')\" class='CAFOURTHLEVELCOLOR'><font size=1>"+eventgroupdescPrev+"</font></td><td class='CAFOURTHLEVELCOLOR'><input type='checkbox' name='a"+eventDateWithoutSlashPrev+prevCounterForClass+newEventClassCodePrev+counterForGroup+"' id='a"+eventDateWithoutSlashPrev+prevCounterForClass+newEventClassCodePrev+counterForGroup+"'  value='"+newEventGroupCodePrev+"' title='"+eventTimeWithoutColonPrev+"'  onClick=CheckAllCode('"+newEventGroupCodePrev+"','"+eventDateWithoutSlashPrev+"','"+newEventClassCodePrev+"',this,"+prevCounterForClass+",'"+eventTimeWithoutColonPrev+"')></td></tr>");
					}
					k++;
					counterForGroup++;
				}
				valuePrev+=eventCodeOriginalPrev;
				if(l%2==0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";
				
				if(!newEventGroupCodePrev.equals(prevNewEventGroup))
				{
					counterForCode=0;
				}
				if ( result_linked_rec_type.equals("DIAG")||result_linked_rec_type.equals("MEDN") )
				{
					out.println("<tr id='tblrow_id"+l+"' title='"+prevMedType+"'><td class='"+classValue+"'><font size=1>"+"&nbsp;&nbsp;"+eventcodedescPrev+"</font></td><td class='"+classValue+"'><input type='checkbox' name='checkBoxEventCode_"+l+"' id='checkBoxEventCode_"+l+"' id='"+accessionnumPrev+"' value='"+valuePrev+"' onClick='OnCheckBoxClick(this)'></td></tr>");
				}
				else
				{
					if(newEventGroupCodePrev.equals("_"))
					{
						counterForCode = counterForCodeForNullGroup;
						counterForCodeForNullGroup++;
					}
					out.println("<tr id='tblrow_id"+l+"'><td onClick=\"javascript:showDetails('"+valuePrev+"')\" class='"+classValue+"'><font size=1>"+"&nbsp;&nbsp;"+eventtimePrev+eventcodedescPrev+"</font></td><td class='"+classValue+"'><input type='checkbox' title='' name='a"+eventDateWithoutSlashPrev+prevCounterForClass+newEventClassCodePrev+newEventGroupCodePrev+eventTimeWithoutColonPrev+counterForCode+"' id='a"+eventDateWithoutSlashPrev+prevCounterForClass+newEventClassCodePrev+newEventGroupCodePrev+eventTimeWithoutColonPrev+counterForCode+"' id='"+accessionnumPrev+"' value='"+valuePrev+"' onClick='OnCheckBoxClick(this)'></td></tr>");						
					
				}
				l++;
			}
			else if(recordCounter==0 )
			{
					out.println("<script>alert('recordCounter"+recordCounter+"')</script>");
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.close();</script>");
			}
		//*****************************************************************/
		}
	
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	}	catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
			
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(result_linked_rec_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(j));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(k));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(l));
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
