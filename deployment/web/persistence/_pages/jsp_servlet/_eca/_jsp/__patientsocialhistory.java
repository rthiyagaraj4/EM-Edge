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

public final class __patientsocialhistory extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatientSocialHistory.jsp", 1709115994560L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tDescription\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           \tcreated\n17/12/2012  IN035950      Nijitha        CHL Hospital suggested that the presentation of the Clinician desktop be changed and \n\t\t\t\t\t \t\t\t\t\t  more appealing. Keeping the display of information more clear and visible.  \n18/06/2013  EMR           Nijitha         EMG-CRF18 - encounter specific query has been modified to patient specific.\t\t\t\n---------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n<head>\n\t<title>Recording Clinical Notes Search Result</title>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t\t<!-- ****  Modified by kishor kumar n on 05/12/2008 for crf0387 applied new css grid. **** -->\n\t\t\n\t\t\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesFileUpload.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n   function callRecClinicalNotesSearch(query_string)\n   {\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t//var query_string = document.PatientSocialHistoryForm.new_query_string.value;\n\t\n\t\n\t//self.location.href = \'../../eCA/jsp/RecClinicalNotesSearchResultMain.jsp?\'+query_string;\n\tself.location.href = \'../../eCA/jsp/RecClinicalNotesMain.jsp?\'+query_string;\n\t\n   }\n\t</script> \n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<center>\n<form name=\'PatientSocialHistoryForm\' id=\'PatientSocialHistoryForm\' action=\"\" method=\"\" target=\"\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n\t\t<script>\n\t\t\n\t\tself.location.href =\"../../eCA/jsp/RecClinicalNotes.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"+\"&p_create_mode=Y&p_soc_his=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";//IN038840\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\n\t\t\t<script>\n\t\t\tcallRecClinicalNotesSearch(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</table>\n\t<input type=hidden name=query_string value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=hidden name=new_query_string value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\n\t<!-------------hidden fields for fileupload-------------------->\n\t<input type=hidden name=accession_num value=\'\'>\n\t<input type=hidden name=function_id value=\'\'>\n\t<input type=hidden name=privilege_type value=\'\'>\n\t<input type=hidden name=forwarded_clinician_id value=\'\'>\n\t<input type=hidden name=action_comment value=\'\'>\n\t<input type=hidden name=performed_by_id value=\'\'>\n\t<input type=hidden name=operation_mode value=\'\'>\n\t<input type=hidden name=doc_linked_note_yn value=\'\'>\n\t<input type=hidden name=appl_task_id value=\'\'>\n\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\'\'>\n\t<!--Added by Ambiga.M for 18712 on 2/24/2010   --> \n\t<input type=hidden name=forward_mode value=\'\'>\n\n\n<!------------------------------------------------------------>\n\n<br><br>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:12%; visibility:hidden;\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\' >\n\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t</table>\n\t</div>\t\n\n</form>\n</center>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

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
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);



	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	PreparedStatement	pstmtcnt	=	null;
	ResultSet			rscnt		=	null;

	StringBuffer query_notes_detail	=	new StringBuffer();
	StringBuffer query_string		=	new StringBuffer();
	StringBuffer whereClause		=	new StringBuffer();

	String	function_id				=	"";
	String	classValue				=	"";
	String	facility_id				=	"";	
	String	accession_num			=	"";
	String	note_type				=	"";	
	String	note_type_desc			=	"";
	String	note_group				=	"";		
	String	appl_task_id			=	"";
	String	service_code			=	"";	
	String	service_name			=	"";
	String	event_title_desc		=	"";		
	String	event_date_time			=	"";
	String	performed_by_id			=	"";
	String	performed_by_name		=	"";
	String	authorized_by_name		=	"";
	String	status					=	"";	
	String	status1					=	"";
	String	tblrow_id				=	"";
	String	login_user_id			=	"";	
	String	clinician_id			=	"";
	String	resp_id					=	"";		
	String	operations_allowed		=	"";
	String	amendment_type			=	"";
	String	privilege_type			=	"";
	String	patient_id				=	"";	
	String	encounter_id			=	"";
	String	episode_type			=	"";
	String	lower_limit				=	"";	
	String	upper_limit				=	"";
	String	from_date_time			=	"";		
	String	to_date_time			=	"";
	String	event_status			=   "";	
	String	status_display_text		=	"";
	String	filter					=	"";
	String	strModifiedId			=	"";
	String	patient_class			=	"";
	String	other_unsigned_yn		=	"";
	String	doc_linked				=	"";
	String	doc_linked_note_yn		=	"";
	String	med_anc					=	"";
	String	contr_mod_accession_num					=	"";
	String	performed_by			=	"";
	String	ref_no			=	"";
	String doc_ref_id="";
	String Encline="";
	String oldEncline="";
	String speciality_code="";
	String res_encounter_id="";

	int		rowCnt					=	0,		maxRecordsDisp		=	10;
	int		startIndex				=	0,		endIndex			=	0;
	int		totalRecordCount		=	0,		colIndex			=	0;
	int		sec_count				=	0;

	patient_id			=	(request.getParameter("patient_id")==null) ?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null) ?	""	:	request.getParameter("encounter_id");
	patient_class		=	(request.getParameter("patient_class")==null) ?	""	:	request.getParameter("patient_class");
	episode_type		=	(request.getParameter("episode_type")==null) ?	""	:	request.getParameter("episode_type");
	event_status		=	(request.getParameter("status")==null) ?	"0"	:	request.getParameter("status");
	other_unsigned_yn	=	(request.getParameter("other_unsigned_yn")==null) ?	"Y"	:	request.getParameter("other_unsigned_yn");
	filter				=	(request.getParameter("filter")==null) ?	"A"	:	request.getParameter("filter");
	function_id			=	(request.getParameter("function_id")==null) ? ""	:	request.getParameter("function_id");
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
	upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
	note_type			=(request.getParameter("note_type")==null)?"":request.getParameter("note_type");
	note_group			=	(request.getParameter("note_group")==null)?"":request.getParameter("note_group");
	appl_task_id		=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	performed_by = (request.getParameter("performed_by")==null)?"":request.getParameter("performed_by");
	med_anc = (request.getParameter("med_anc")==null)?"":request.getParameter("med_anc");
	contr_mod_accession_num = (request.getParameter("contr_mod_accession_num")==null)?"":request.getParameter("contr_mod_accession_num");
	ref_no = (request.getParameter("ref_no")==null)?"":request.getParameter("ref_no");
	speciality_code = (request.getParameter("speciality_code")==null)?"":request.getParameter("speciality_code");
	String option_id = (request.getParameter("option_id")==null)	?	""	:	request.getParameter("option_id"); //[IN032060]	
	String p_called_from_widget= request.getParameter("p_called_from_widget");//IN038840
	String p_soc_his= (request.getParameter("p_soc_his")==null)?"N":request.getParameter("p_soc_his");//IN038840
	
	query_string.append("patient_id=");		query_string.append(patient_id);
	query_string.append("&p_called_from_widget=");		query_string.append(p_called_from_widget);//IN038840
	//query_string.append("&p_soc_his=");		query_string.append(p_soc_his);//IN038840 Commented
	query_string.append("&encounter_id=");	query_string.append(encounter_id);
	query_string.append("&episode_type=");	query_string.append(episode_type);
	query_string.append("&function_id=");	query_string.append(function_id);
	query_string.append("&from_date_time="); query_string.append(from_date_time);
	query_string.append("&to_date_time="); query_string.append(to_date_time);
	query_string.append("&appl_task_id="); query_string.append(appl_task_id);
	query_string.append("&patient_class="); query_string.append(patient_class);
	query_string.append("&filter="); query_string.append(filter);
	query_string.append("&status="); query_string.append(event_status);
	query_string.append("&other_unsigned_yn="); query_string.append(other_unsigned_yn);
	query_string.append("&med_anc="); query_string.append(med_anc);
	query_string.append("&performed_by="); query_string.append(performed_by);
	query_string.append("&ref_no="); query_string.append(ref_no);
	query_string.append("&speciality_code="); query_string.append(speciality_code);
	//query_string.append("&operation_mode="); query_string.append("ModifySection");


	from_date_time		= com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time		= com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	
	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);

	try
	{

		con				=	ConnectionManager.getConnection(request);

		login_user_id	=	(String)		session.getValue("login_user");
		facility_id		=	(String)		session.getValue("facility_id");
		resp_id			=	(String)		session.getValue("responsibility_id");
		clinician_id	 =	(String)		session.getValue("ca_practitioner_id");


		
		if(!(from_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
		if(!(to_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");// 0.00068287   +.9999

		if(!(event_status.equals("0")))
			whereClause.append(" 	and a.event_status = ? ");

		if(!(contr_mod_accession_num.equals("")))
			whereClause.append(" 	and a.contr_mod_accession_num = ? ");

		if((filter.equals("R")))
				{
			whereClause.append(" 	and exists( select 1 from CA_ENCNTR_NOTE_AUDIT_LOG where FACILITY_ID=a.FACILITY_ID and ACCESSION_NUM=a.ACCESSION_NUM and ACTION_TYPE='RV' AND ACTION_STATUS='RQ' AND ACTION_BY_ID =?) ");
				}
		else if((filter.equals("S")))
				{
			whereClause.append(" 	and (exists( select 1 from CA_ENCNTR_NOTE_AUDIT_LOG where FACILITY_ID=a.FACILITY_ID and ACCESSION_NUM=a.ACCESSION_NUM and ACTION_TYPE='SN' AND ACTION_STATUS='RQ' AND ACTION_BY_ID =?) OR EVENT_STATUS='1') ");
				}
		if(!note_type.equals(""))
				{
			whereClause.append(" 	and a.note_type=? " );
				}

		if (!note_group.equals(""))
				{
			whereClause.append(" 	and b.note_group_id=? " );
				}

		else
				{
				////[IN032060]	Start.
				//if("OTNOTES".equals(option_id)){
				if("OT_NOTES".equals(appl_task_id)){
					whereClause.append(" 		and 	 (b.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id = ?) OR b.note_group_id IN ('*OPERNOTE'))  " );
				}else{
					whereClause.append(" 		and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
				}
				//whereClause.append(" 		and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
				////[IN032060]	End.
				}
		if(!performed_by.equals(""))
		{
			whereClause.append(" 	and a.PERFORMED_BY_ID=? " );
		}
		
		if(!med_anc.equals(""))
		{
			whereClause.append(" 	and a.SERVICE_CODE=? " );
		}

		if(!ref_no.equals(""))
		{
			whereClause.append(" 	and upper(a.DOC_REF_ID) like upper('%"+ref_no.trim()+"%')" );
		}
		//appl_task_id="MEDICAL_CERTFICATE";

		
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
			query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id,Decode(patient_class,'XT', 'Non-Encounter Specific', replace(CA_GET_VISIT_DTL_NEW(a.FACILITY_ID,a.patient_class,a.ENCOUNTER_ID,A.PATIENT_ID),'\''','  ')) Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b  where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and a.patient_id = ? and b.language_id = ?");
		}else{
			
			//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and a.encounter_id = NVL(?,0) and b.language_id = ? ");
			//query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? and a.encounter_id = NVL(?,0) and b.language_id = ? AND A.EVENT_STATUS NOT IN('9')");//IN038840
			query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ? AND A.EVENT_STATUS NOT IN('9')");//IN038840//EMR - encounter condition removed to make patient specific
		}

		query_notes_detail.append(whereClause.toString());
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
				query_notes_detail.append("	order by a.encounter_id,event_date_time desc");
		}else {
				query_notes_detail.append("	order by event_date_time desc");
		}

		pstmt			=	con.prepareStatement(query_notes_detail.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);
		pstmt.setString( ++colIndex,	other_unsigned_yn	); 

		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);
		pstmt.setString( ++colIndex,	other_unsigned_yn	);
	//	pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	patient_id		);
		

		
		if(!(appl_task_id.equals("MEDICAL_CERTFICATE")) && !(appl_task_id.equals("MC_CONSULT"))){
			pstmt.setString( ++colIndex,	facility_id		);	
			//pstmt.setString( ++colIndex,	encounter_id);//EMR - encounter condition removed

		}
		pstmt.setString( ++colIndex,	locale);


		if(!(from_date_time.equals("")))
			pstmt.setString	(	++colIndex,	from_date_time	);

		if(!(to_date_time.equals("")))
		{
			pstmt.setString	(	++colIndex,	to_date_time	);
		}
		if(!(event_status.equals("0")))
		{

			pstmt.setString	(	++colIndex,	event_status	);
		}
		if(!(contr_mod_accession_num.equals("")))
		{

			pstmt.setString	(	++colIndex,	contr_mod_accession_num);
		}
		if((filter.equals("R")))
		{

			pstmt.setString	(	++colIndex,	clinician_id);

		}
		else if((filter.equals("S")))
		{ 
			pstmt.setString	(	++colIndex,	clinician_id);

		}

		if(!note_type.equals(""))
		{
			
			pstmt.setString	(	++colIndex,	note_type	);

		}
		if (!note_group.equals(""))
		{
			pstmt.setString	(	++colIndex,	note_group	);

		}
		else
		{			
			pstmt.setString	(	++colIndex,	appl_task_id);

		}
		if(!performed_by.equals(""))
		{

			pstmt.setString	(	++colIndex,	performed_by );
		}
		
		if(!med_anc.equals(""))
		{

			pstmt.setString	(	++colIndex,med_anc);
		}
		
		rs				=	pstmt.executeQuery();
		//[IN032060]	Start.
		if(!(rs.next())){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_soc_his));
            _bw.write(_wl_block11Bytes, _wl_block11);
		
		}else{
		//[IN032060]	End.
		rs.last();
		totalRecordCount	=	rs.getRow();
		rs.beforeFirst();
	
		
		String countQuerySec = "select count(*) count  from ca_note_section_view where note_type = ? ";
		pstmtcnt = con.prepareStatement(countQuerySec);
		
		while(rs.next())
		{
			tblrow_id		=	"tblrow_id"+(rowCnt);

			rowCnt++;

			if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";

			facility_id						=			rs.getString("facility_id")==null?"":rs.getString("facility_id");
			accession_num					=			rs.getString("accession_num")==null?"":rs.getString("accession_num");
			note_type						=			rs.getString("note_type")==null?"":rs.getString("note_type");
			note_type_desc					=			rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
			service_code					=			rs.getString("service_code")==null?"":rs.getString("service_code");
			service_name					=			rs.getString("service_name")==null?"":rs.getString("service_name");
			service_name					=			service_name.replace('\'',' ');
			event_title_desc				=			rs.getString("event_title_desc")==null?"&nbsp;":rs.getString("event_title_desc");
			event_date_time					=			rs.getString("event_date_time1")==null?"":rs.getString("event_date_time1");
			performed_by_id					=			rs.getString("performed_by_id")==null?"":rs.getString("performed_by_id");
			performed_by_name				=			rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
			authorized_by_name				=			rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");
			doc_ref_id=rs.getString("doc_ref_id")==null?"":rs.getString("doc_ref_id");
			if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
				Encline=rs.getString("Encline")==null?"":rs.getString("Encline");
			}
			//status						=			rs.getString("status")==null?"&nbsp;":rs.getString("status");
			status1							=			rs.getString("status")==null?"&nbsp;":rs.getString("status");
			operations_allowed				=			rs.getString("operations_allowed")==null?"":rs.getString("operations_allowed");
			amendment_type					=			rs.getString("ammendment_type")==null?"":rs.getString("ammendment_type");
			privilege_type					=			rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
			strModifiedId					=			rs.getString("modifiedid")==null?"":rs.getString("modifiedid");
			doc_linked_note_yn				=			rs.getString("doc_linked_note_yn")==null?"N":rs.getString("doc_linked_note_yn");
			doc_linked						=			rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");
			res_encounter_id						=			rs.getString("encounter_id")==null?"0":rs.getString("encounter_id");
			event_date_time					=			com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);


			
			
			if(doc_linked_note_yn.equals("Y"))
			{
				pstmtcnt.clearParameters();
				pstmtcnt.setString(1,note_type);
				rscnt = pstmtcnt.executeQuery();

				while(rscnt.next())
				{
					sec_count = rscnt.getInt("count");
				}

				if(rscnt!=null)
					rscnt.close();
			}

			if(status1.equals("1"))
				status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
			else if(status1.equals("2"))
				status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
			else if(status1.equals("3"))
				status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
			else if(status1.equals("4"))
				status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
			else if(status1.equals("5"))
				status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
			else if(status1.equals("9"))
				status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");

			
			
			query_string.append("&note_type="); query_string.append(note_type);
			query_string.append("&accession_num="); query_string.append(accession_num);
			query_string.append("&amendment_type="); query_string.append(amendment_type);
			query_string.append("&privilege_type="); query_string.append(privilege_type);
			query_string.append("&service_code="); query_string.append(service_code);
			query_string.append("&authority="); query_string.append(authorized_by_name);
			query_string.append("&modified_by="); query_string.append(strModifiedId);
			query_string.append("&doc_linked_note_yn="); query_string.append(doc_linked_note_yn);
			query_string.append("&sec_count="); query_string.append(sec_count);
			query_string.append("&rec_flag="); query_string.append("N");
			query_string.append("&visit_adm_date="); query_string.append("");
			query_string.append("&dischargeDateTime="); query_string.append("");
			query_string.append("&performed_by_pract="); query_string.append(performed_by_name);
			query_string.append("&location_desc="); query_string.append("");
			query_string.append("&performed_date="); query_string.append(event_date_time);
			query_string.append("&attending_practitioner="); query_string.append("");
			query_string.append("&location_code="); query_string.append("");
			query_string.append("&p_create_mode="); query_string.append("N");//IN038840
			
			if(status1.equals("1"))
			{
				query_string.append("&operation_mode="); query_string.append("Update");
			}
			//IN038840 sTarts
			else if(privilege_type.equals("2") || privilege_type.equals("5") || privilege_type.equals("1"))
			{
			query_string.append("&p_soc_his="); query_string.append("Y");//IN038840
			query_string.append("&operation_mode="); query_string.append("");
			}
			//IN038840 Ends
			else
			{
				query_string.append("&operation_mode="); query_string.append("ModifySection");
			}
				
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
	
		}
		}	
		if(rscnt!=null)	rscnt.close();
		if(pstmtcnt!=null) pstmtcnt.close();
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
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
