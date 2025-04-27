package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.lowagie.text.*;
import com.lowagie.text.html.simpleparser.*;
import com.lowagie.text.pdf.*;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;
import com.lowagie.text.DocumentException;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.Common.*;
import java.text.SimpleDateFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __emailnotifiableintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EMailNotifiableIntermediate.jsp", 1709115195888L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


	public String checkForNull(String inputString)
	{
		return ((inputString==null)	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
		
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	created 
21/12/2012	IN030465		Ramesh G		Triggers an alert upon documentation of a Notifiable Disease.	
05/08/2015	IN055185		Ramesh G		ML-BRU-SCF-1598 [IN:055185]							 
06/09/2019	IN071335		Ramesh G		Common-ICN-0012
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
request.setCharacterEncoding("UTF-8");
Connection con=null;
PreparedStatement pst = null;
PreparedStatement pst1 = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
ResultSet rs1 = null;
String clobData="";
String sql ="";


String encounter_id 	= "";
String url_text 		= "";
String file_pathName		= "";
String module_id		= "";
String report_id		= "";

	StringBuffer sb=new StringBuffer();
	StringBuffer logoHeader=new StringBuffer();
	StringBuffer reportHeader=new StringBuffer();
	StringBuffer reportFooter=new StringBuffer();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	
	Hashtable htParameter=new Hashtable();
	HashMap<String,String> paramMap = null;
	
	String disclaimer = "" ;
	String locale ="" ;
	String to_emailId = "" ;
	String to_id = "" ;
	String to_name = "" ;
	String cc_emailId="";
	
	String subject = ""; 
	String editor_content = ""; 
	String verReqdYn = ""; 
	String password = ""; 
	String patient_id = "";
	
	String mailToType = ""; 

	String p_accession_num = "";	
	String p_file_name	 = "";		
	String p_report_type	 = "T";	
	String p_report_text = "";
	String error = "";
	String p_srno = "";
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_hdr		=	"";
	String	section_content_ftr		=	"";
	String appl_user_name 		= ""; 
	String facilityId 			= "";	
	String client_ip_address 	= ""; 
	String  authorized_by		= "";
	String  last_amended_by		= "";
	String  doc_ref_id			= "";
	String	encounter_id1		= "";
	String	episode_type		= "";
	String	performed_by_id		= "";
	String	query_privilege_type	= "";
	String	facility_name		= "" ;
	String	visit_adm_date 		= "";
	String 	med_service			= "";
	String 	discharge_date		= "";
	String 	attending_practitioner	= "";
	String	admitting_practitioner	= "";
	String	performing_phy_name	= "";
	String	age					= "";
	String	gender				= "";
	String	location_code		= "";
	String	patient_name		= "";
	String	speciality_name		= "";
	String	printDateTime		= "";
	String	site_name			= "";
	String	patient_class		= "";
	String	Sex					= "";
	String 	note_type			= "";
	String	note_group_desc		= "";
	String	note_header_code	= "";
	String	footer_code			= "";
	String	report_header_code	= "";
	String 	strEventDateTime	= "";
	String	cal_eventdate		= "";
	String	default_pat_name	= "";
	String	deceased_yn			= "";
	String	deceased_date		= "";
	String 	patient_age			= "";
	String 	contr_mod_accession_num = "";
	String 	login_user_id		= "";
	String 	pract_sign			= "";
	String	clinician_id		= "";
	String 	imageLogoHeader 	= "N";
	String 	textLogoHeader 		= "N";
	
	String logo_hdr_all_pages 	= "";
	String rpt_hdr_all_pages 	= "";
	String printhdrindsyn 		= "";
	String  url1					=	"";
	String  url						=	"";
	
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	
	
	String sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
	String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ?  " ;
	String pract_sign_qry=	"SELECT a.practitioner_name|| CHR (13)|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32)|| b.position_desc|| NVL2 (b.position_desc, CHR (13), '' )|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32)|| credential_id1 || NVL2 (credential_id1, ', ', '')       || credential_id2 || NVL2 (credential_id2, ', ', '')|| credential_id3 || NVL2 (   credential_id1|| credential_id2|| credential_id3,CHR (13),'')|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32) || DEGREE pract_with_pos_cred_deg  FROM am_practitioner a, am_position b WHERE a.position_code = b.position_code AND a.practitioner_id = ? ";
	String head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
	facilityId			= (String) session.getValue( "facility_id" ) ;
	appl_user_name			= (String) session.getValue( "appl_user_name" ) ;
	login_user_id		=	(String)session.getValue("login_user");
	clinician_id			= (String)session.getValue("ca_practitioner_id");
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	client_ip_address	= (String) p.getProperty("client_ip_address");
	locale = (String) p.getProperty("LOCALE") == null ? "" : (String) p.getProperty("LOCALE");	
	// IN071335 Changes Start.
	//url   = HttpUtils.getRequestURL(request).toString();
	//url = url.substring(0,url.indexOf("jsp/"));
	url					= application.getRealPath("/eCA")+"/";
	// IN071335 Changes End.
	url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
	String sqlPwdForRegUser = "select  PASSWORD pwd from SM_REGD_MAIL_USER_PWD where  MAILER_ID =? and sysdate between FROM_DATE  and nvl(TO_DATE,sysdate)";
	
	oracle.jdbc.OracleCallableStatement csFaxMail = null;
	
	try 
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		p_accession_num	= (String)hash.get("accession_num");	
		patient_id 		= (String)hash.get("patient_id"); 
		module_id 		= (String)hash.get("module_id");
		report_id 		= (String)hash.get("report_id");
		mailToType		= (String)hash.get("mailToType");
		con	= ConnectionManager.getConnection(request);
		
		//sql = "SELECT ENCOUNTER_ID,NOTE_CONTENT,PERFORMED_BY_ID FROM CA_ENCNTR_NOTE WHERE ACCESSION_NUM=?";	
		sql = "SELECT EN.ENCOUNTER_ID,EN.NOTE_CONTENT,EN.PERFORMED_BY_ID,EN.NOTE_TYPE,EN.EVENT_DATE_TIME,EN.CONTR_MOD_ACCESSION_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW  WHERE PATIENT_CLASS=EN.PATIENT_CLASS) EPISODE_TYPE FROM CA_ENCNTR_NOTE EN WHERE ACCESSION_NUM=?";
		pst = con.prepareStatement(sql);
		
		pst.setString(1,p_accession_num);
		rs = pst.executeQuery();			
		java.sql.Clob			clob_content	= null;
		if(rs.next()){		
			encounter_id 	= (String) rs.getString("ENCOUNTER_ID");
			episode_type 	= (String) rs.getString("EPISODE_TYPE");
			performed_by_id = (String) rs.getString("PERFORMED_BY_ID");
			note_type		= (String) rs.getString("NOTE_TYPE");
			strEventDateTime= (String) rs.getString("EVENT_DATE_TIME");
			contr_mod_accession_num= (String) rs.getString("CONTR_MOD_ACCESSION_NUM");
			clob_content = (java.sql.Clob) rs.getObject("NOTE_CONTENT");
			if(clob_content!=null && clob_content.length() > 0){
				clobData = clob_content.getSubString(1,( (int)clob_content.length() ));
			}
		}
		cal_eventdate = com.ehis.util.DateUtils.convertDate(strEventDateTime,"DMYHM","en","en");
		clobData = clobData.replaceAll("<o:p></o:p>", "");		
		
		if(rs != null) rs.close();
		if(pst != null) pst.close();
		
		if(	episode_type.equals("O") ){
			query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?"; 
		}else{	
			query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?";
		}
		
		pst	=	con.prepareStatement(pract_sign_qry);
		pst.setString	(	1,	clinician_id	);
		rs		=	pst.executeQuery();
		if(rs.next())
		{
			pract_sign			=	rs.getString("pract_with_pos_cred_deg") == null ? "" : rs.getString("pract_with_pos_cred_deg");
		}
		if(rs!=null)	rs.close();
		if(pst!=null)	pst.close();
		
		pst	=	con.prepareStatement(query_privilege_type);
			pst.setString	(	1,	locale	);
			pst.setString	(	2,	locale	);
			pst.setString	(	3,	locale	);
			pst.setString	(	4,	locale	);
			pst.setString	(	5,	performed_by_id	);
			pst.setString	(	6,	locale	);
			pst.setString	(	7,	locale	);			
			pst.setString	(	8,	locale	);	
			pst.setString	(	9,	locale	);			
			pst.setString	(	10,	locale	);	
			pst.setString	(	11,	encounter_id);
			pst.setString	(	12,	patient_id);

			rs		=	pst.executeQuery();

			if(rs.next())
			{
				facility_name			=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
				visit_adm_date			=	rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
				med_service				=	rs.getString("service_name")==null?"":rs.getString("service_name");
				discharge_date			=	rs.getString("DISCHARGE_DATE_TIME")==null?"":rs.getString("DISCHARGE_DATE_TIME");
				attending_practitioner	=	rs.getString("attending_practitioner")==null?"":rs.getString("attending_practitioner");
				admitting_practitioner	=	rs.getString("admitting_practitioner")==null?"":rs.getString("admitting_practitioner");
				performing_phy_name		=	rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
				age						=	rs.getString("AGE")==null?"":rs.getString("AGE");
				gender					=	rs.getString("gender")==null?"":rs.getString("gender");
				location_code			=	rs.getString("location_code")==null?"":rs.getString("location_code");
				patient_name			=	rs.getString("patient_name")==null?"":rs.getString("patient_name");
				speciality_name			=	rs.getString("specialty_name")==null?"":rs.getString("specialty_name");
				printDateTime			=	rs.getString("print_date_time")==null?"":rs.getString("print_date_time");
				site_name				=	rs.getString("site_name")==null?"":rs.getString("site_name");
				patient_class 			=	rs.getString("patient_class")==null?"":rs.getString("patient_class");
			}
			if(gender.equals("M"))
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if (gender.equals("F"))
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else 
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			if(discharge_date==null)
				discharge_date="";
			
			if(rs!=null)	rs.close();
			if(pst!=null)	pst.close();
			
			pst			=	con.prepareStatement("SELECT A.NOTE_GROUP_DESC NOTEGRDESC FROM CA_NOTE_GROUP A,CA_NOTE_TYPE B WHERE A.NOTE_GROUP=B.NOTE_GROUP_ID AND B.NOTE_TYPE=?");
			pst.setString(1, note_type);			
			rs				=	pst.executeQuery();
			if(rs.next())
			{
				note_group_desc = rs.getString("NOTEGRDESC");
			}
			
			if(rs!=null)	rs.close();
			if(pst!=null)	pst.close();
			
			if(patient_class.equals("OP"))
					patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			else if(patient_class.equals("IP"))
					patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			else if(patient_class.equals("EM"))
					patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			else if(patient_class.equals("DC"))
					patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			
			try{
				pst	= con.prepareStatement(head_foot_qry);
				pst.setString(1,note_type);
				rs = pst.executeQuery();

				while(rs.next()){
					note_header_code = rs.getString("NOTE_HEADER_CODE")==null?"":rs.getString("NOTE_HEADER_CODE");
					footer_code = rs.getString("FOOTER_CODE")==null?"":rs.getString("FOOTER_CODE");
					report_header_code = rs.getString("REPORT_HEADER_CODE")==null?"":rs.getString("REPORT_HEADER_CODE");
				}			
			}catch(Exception ee){
				out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
				ee.printStackTrace();
			}finally{
				if(rs != null) rs.close();
				if(pst != null) pst.close();
			}
			try{
				pst	= con.prepareStatement("select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient where patient_id = ?");//IN040205
				pst.setString(1,patient_id);
				rs = pst.executeQuery();
				
				while(rs.next())
				{
					default_pat_name	= rs.getString("patient_name") == null ? "" : rs.getString("patient_name");
					deceased_yn			= rs.getString("deceased_yn") == null ? "" : rs.getString("deceased_yn");
					deceased_date		= rs.getString("deceased_date") == null ? "" : rs.getString("deceased_date");					
				}
				if(rs!= null) rs.close();
				if(pst != null) pst.close();
					
				String eventdate_isAfter_decdate = "";
				pst	= con.prepareStatement("SELECT CASE WHEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') > TO_DATE (?, 'dd/mm/yyyy hh24:mi') THEN 'Y'  ELSE 'N' END eventdate_isAfter_decdate FROM DUAL");
				pst.setString(1,cal_eventdate);
				pst.setString(2,deceased_date);
				
				rs = pst.executeQuery();
				
				while(rs.next())
				{
					eventdate_isAfter_decdate = rs.getString("eventdate_isAfter_decdate");
				}
				
				if("Y".equals(eventdate_isAfter_decdate))
				{
					cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
				}				
						
			}catch(Exception ee){
				out.println("Exceptionin EMailNotifiableIntermediate.jsp @ pstmt2 : "+ee.toString());
				ee.printStackTrace();
			}finally{
				if(rs != null) rs.close();
				if(pst != null) pst.close();
			}
			
			String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth,decode(deceased_yn,'Y',deceased_date,sysdate)) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from mp_all_patients_vw where patient_id = ? "; 
			try{
				pst	= con.prepareStatement(strPatInfoQuery);
				pst.setString    (	1,	patient_id);

				rs = pst.executeQuery();

				if(rs.next() )
				{
					patient_age		= rs.getString("patient_age") == null ? "" : rs.getString("patient_age");
				}	
			}catch (Exception ePP6){
				ePP6.printStackTrace();
			}finally{
				if(rs != null) rs.close();
				if(pst != null) pst.close();
			}
	//Report Header Start
		try
		{
			pst	= con.prepareStatement(sect_template_query);	
			pst.setString(1,report_header_code);
			rs = pst.executeQuery();
			if(rs.next()){				
				clob_notes_content			=	(java.sql.Clob) rs.getObject("TEMPLATE_FORMAT");
				if(clob_notes_content!=null)
				{
					try
					{					
						content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
						bf_content_reader	= new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						section_content = new String(arr_notes_content);
						bf_content_reader.close();
									
						if(section_content == null)
							section_content = "";
					}catch(Exception e)
					{
						out.println("Exception@1-readCLOB : "+e);
						e.printStackTrace();
					}
				}
			}
		}catch(Exception eee){
			out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
			eee.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(pst != null) pst.close();
		}
		if(!p_accession_num.equals("")){
			try
			{
				pst	= con.prepareStatement(athorise_by_qry);
				pst.setString(1,locale);
				pst.setString(2,locale);
				pst.setString(3,locale);
				pst.setString(4,locale);
				pst.setString(5,p_accession_num);
				pst.setString(6,patient_id);
				rs = pst.executeQuery();
				while(rs.next())
				{
					authorized_by		=	checkForNull( rs.getString("AUTHORIZED_BY_ID") );
					last_amended_by		=	checkForNull( rs.getString("LAST_AMENDED_BY_ID") );
					doc_ref_id		=	checkForNull( rs.getString("DOC_REF_ID") );

				}
			}catch (Exception roro ){
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());
				roro.printStackTrace();
			}finally{
			  if(rs != null) rs.close();
			  if(pst != null) pst.close();
			}
        }
		encounter_id1 = encounter_id ;
		if(encounter_id.equals("0"))				
			encounter_id1 ="";				
				
		if(!visit_adm_date.equals(""))
			visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
		
		if(!discharge_date.equals(""))
			discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);


		htParameter.put("V$ATT_PRACT", attending_practitioner);
		htParameter.put("V$ADM_PRACT", admitting_practitioner);
		htParameter.put("V$REP_PRACT", performing_phy_name);
		htParameter.put("V$PT_SPLTY", speciality_name);
				
		if(patient_name.trim().equals(""))
			htParameter.put("V$PT_NAME", default_pat_name);
		else
			htParameter.put("V$PT_NAME", patient_name);
				
		htParameter.put("V$PT_ID", patient_id);
		htParameter.put("V$SEX", Sex);
		htParameter.put("V$AGE", patient_age);//IN040205
		htParameter.put("V$ENC_ID", encounter_id1);
		htParameter.put("V$ADM_DT", visit_adm_date); 
		htParameter.put("V$DIS_DT", discharge_date); 
		htParameter.put("V$MED_SERV", med_service);
		htParameter.put("V$DOC_REF_H", doc_ref_id);
		htParameter.put("V$PT_LOCN", location_code); 
		htParameter.put("V$PT_CLASS", patient_class);				
		
		StringBuffer section_content_new = new StringBuffer(section_content);
				
		if (! locale.equals("en") )
		{
			if(!section_content_new.toString().equals(""))
			{
				paramMap = new HashMap<String,String>();
				paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
				paramMap.put("LOCALE",locale);						
				paramMap.put("RANGE_PASER_YN","N");
				eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
				section_content_new = tempLangParse.getLangReplacedXML();
				tempLangParse = null;
			}
		}
				
		if(!section_content_new.toString().equals(""))
		{
			//***************************** [CRF-118] Start *****************************					
			eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
			HashMap paramHash=new HashMap();
			Hashtable tempParameter=new Hashtable();
			paramHash.put("#p_patient_id#",patient_id);
			paramHash.put("#p_encounter_id#",encounter_id1);
			paramHash.put("#p_accNum#",p_accession_num);
			paramHash.put("#p_locale#",locale);
			paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num);  
			paramHash.put("#p_eventDate#",cal_eventdate);
			paramHash.put("#p_facility_id#",facilityId);
			tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
			if(tempParameter.size()>0){					
			htParameter.putAll(tempParameter);
			}
			//*****************************[CRF-118] Ends *****************************
			sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
		}

		if(!(sectionContentUpdatedXML.toString().equals(""))){								
			section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

		}


	//Report Header End
	
	//Report Footer Start
	
		try{
			pst	= con.prepareStatement(sect_template_query);
			pst.setString(1,footer_code);
			rs = pst.executeQuery();

			if(rs.next()){				
				clob_notes_content			=	(java.sql.Clob) rs.getObject("TEMPLATE_FORMAT");				

				if(clob_notes_content!=null){
					try{					
						content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
						bf_content_reader	= new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						section_content = new String(arr_notes_content);
						bf_content_reader.close();
									
						if(section_content == null)
							section_content = "";
					}catch(Exception e){
						out.println("Exception@1-readCLOB : "+e);
						e.printStackTrace();
					}


				}
			}
		}catch(Exception eee){
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(pst != null) pst.close();
		}

		if(!printDateTime.equals("")){
			printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
		}

		htParameter=new Hashtable();
		htParameter.put("V$CUR_USR", login_user_id);
		htParameter.put("V$AT_PRACT", authorized_by);
		htParameter.put("V$LT_MODI_USR", last_amended_by);
		htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
		htParameter.put("V$DOC_REF_F", doc_ref_id);
		htParameter.put("V$LT_PT_P_C_D", pract_sign);

		section_content_new = new StringBuffer(section_content);
			
		
		if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
		{							
			eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
			HashMap paramHash=new HashMap();
			Hashtable tempParameter=new Hashtable();
		
			paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
			paramHash.put("#p_accNum#",p_accession_num);
			paramHash.put("#p_locale#",locale);
			paramHash.put("#p_pract_id#",clinician_id);
			tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
			if(tempParameter.size()>0)
			{					
				htParameter.putAll(tempParameter);
			}
		}
		
		sectionContentUpdatedXML = new StringBuffer();
		
		if (! locale.equals("en") )
		{
			if(!section_content_new.toString().equals(""))
			{
				paramMap = new HashMap<String,String>();
				paramMap.put("CURR_SEC_HDG_CODE",footer_code);
				paramMap.put("LOCALE",locale);						
				paramMap.put("RANGE_PASER_YN","N");
				eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
				section_content_new = tempLangParse.getLangReplacedXML();
				tempLangParse = null;
			}
		}				
				
		if(!section_content_new.toString().equals(""))
		{
			sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
		}

		
		if(!(sectionContentUpdatedXML.toString().equals("")))
		{								
				
			section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

		}	
	
	//Report Footer End.
	try{			
		pst	= con.prepareStatement("SELECT IMAGE_REF FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'");
		rs = pst.executeQuery();
		if(rs.next()){
			imageLogoHeader="Y";				
		}
		if(rs != null) rs.close();
		if(pst != null) pst.close();
		
		pst	= con.prepareStatement("SELECT PRINT_LOGO_HEADER_YN,PRINT_TEXT_HDR_YN FROM CA_NOTE_TYPE WHERE NOTE_TYPE=?");
		pst.setString(1,note_type);
		rs = pst.executeQuery();
		if(rs.next()){
			String printLogoHed = rs.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs.getString("PRINT_LOGO_HEADER_YN");
			printhdrindsyn = rs.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs.getString("PRINT_LOGO_HEADER_YN");
			String printtextHed = rs.getString("PRINT_TEXT_HDR_YN")==null?"":(String)rs.getString("PRINT_TEXT_HDR_YN");
			if("Y".equals(printLogoHed) && "Y".equals(printtextHed))
					textLogoHeader="Y";				
		}
		
		if(rs != null) rs.close();
		if(pst != null) pst.close();
		
		
		
		pst =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN  FROM ca_note_param ");
		rs	=	pst.executeQuery();
		if(rs.next())
		{
			logo_hdr_all_pages	= rs.getString("LOGO_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("LOGO_HDR_ALL_PAGE_YN");
			rpt_hdr_all_pages	= rs.getString("RPT_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("RPT_HDR_ALL_PAGE_YN");
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
	}catch(Exception eee)
	{
		out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
		eee.printStackTrace();

	}
	finally
	{
		if(rs != null) rs.close();
		if(pst != null) pst.close();
	}
	
	//logo Heder Start
	
		if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("N")))
				{
					
						if("Y".equals(imageLogoHeader)){
							logoHeader.append("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
							logoHeader.append("<tr><td colspan='2'>");
							logoHeader.append("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
							logoHeader.append("<img src='../../eCA/jsp/CADisplayImages.jsp' ></td></tr></table>");
							logoHeader.append("</td></tr>");
							
							if("Y".equals(textLogoHeader)){
								logoHeader.append("<tr>");	
								logoHeader.append("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
								logoHeader.append("</tr>");
								logoHeader.append("<tr>");	
								logoHeader.append("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
								logoHeader.append("</tr>");
								logoHeader.append("<tr>");	
								logoHeader.append("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
								logoHeader.append("</tr>");
							}
							out.println("</table>");
						}else{
							logoHeader.append("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
							logoHeader.append("<tr>");	
							logoHeader.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");
							if("Y".equals(textLogoHeader)){	
								logoHeader.append("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");
								logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
								logoHeader.append("</tr>");//IN037045
								logoHeader.append("<tr>");
								logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");
								logoHeader.append("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
								logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
								logoHeader.append("</tr>");
								logoHeader.append("<tr>");
								logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");
								logoHeader.append("<td width='60%'  align='center'><h4>"+note_group_desc+"</h4></td>");
								logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
								logoHeader.append("</tr>");
							}else{
								logoHeader.append("<td width='60%' align='center'>&nbsp;</h3></td>");
								logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
								logoHeader.append("</tr>");
							}
							logoHeader.append("</table>");
						}
					
				}
				
				
			logoHeader.append("<table border='0' width='100%'>"); 
			logoHeader.append("<thead>"); 
			   
			 if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("Y")))
			{				
				logoHeader.append("<tr>"); 
				logoHeader.append("<th style='width:100%'>");
				
					
				if("Y".equals(imageLogoHeader)){
					logoHeader.append("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
					logoHeader.append("<tr><td colspan='2'>");
					logoHeader.append("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
					logoHeader.append("<img src='../../eCA/jsp/CADisplayImages.jsp' ></td></tr></table>");
					logoHeader.append("</td></tr>");
					
					if("Y".equals(textLogoHeader)){
						logoHeader.append("<tr>");	
						logoHeader.append("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
						logoHeader.append("</tr>");
						logoHeader.append("<tr>");	
						logoHeader.append("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
						logoHeader.append("</tr>");
						logoHeader.append("<tr>");	
						logoHeader.append("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
						logoHeader.append("</tr>");
					}
					logoHeader.append("</table>");
				}else{
					logoHeader.append("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
					logoHeader.append("<tr>");	
					logoHeader.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");
					if("Y".equals(textLogoHeader)){		
						logoHeader.append("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");
						logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");
						logoHeader.append("</tr>");
						logoHeader.append("<tr>");
						logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");
						logoHeader.append("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
						logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");
						logoHeader.append("</tr>");
						logoHeader.append("<tr>");
						logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");
						logoHeader.append("<td width='60%'  align='center'><h4>"+note_group_desc+"</h4></td>");
						logoHeader.append("<td width='20%'  align='center'>&nbsp;</td>");
						logoHeader.append("</tr>");
					}else{
						logoHeader.append("<td width='60%' align='center'>&nbsp;</h3></td>");
						logoHeader.append("<td width='20%'  align='center'>&nbsp;</td></tr>");
					}
					logoHeader.append("</table>");
				}
				logoHeader.append("</th> ");
				logoHeader.append("</tr> ");
					
			}  
			if(rpt_hdr_all_pages.equals("Y"))
			{
				logoHeader.append("<tr>");
				logoHeader.append("<th style='width:100%'>");
				logoHeader.append("<br>");
				logoHeader.append("<table border='1' cellpadding='0' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>");
				logoHeader.append("<tr>");
				logoHeader.append("<td colspan='3' ><font style ='font-family:Verdana'>");
				logoHeader.append(section_content_rpt);
				logoHeader.append("</font></td></tr>");
				logoHeader.append("</table>");
				logoHeader.append("<br>");
				logoHeader.append("</th>");
				logoHeader.append("</tr>");
			}
			 logoHeader.append("</thead> ");
			 
			logoHeader.append("<tbody>");
			logoHeader.append("<tr> ");
			logoHeader.append("<td width='100%'>");
			
			if(rpt_hdr_all_pages.equals("N")){			
				logoHeader.append("<table border='0' width='100%'>"); 
				logoHeader.append("<thead>"); 
				logoHeader.append("<tr>"); 
				logoHeader.append("<th style='width:100%'>");
				logoHeader.append("<br>");
				logoHeader.append("<table border='1' cellpadding='0' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>");
				logoHeader.append("<tr>");
				logoHeader.append("<td colspan='3' ><font style ='font-family:Verdana'>");
				logoHeader.append(section_content_rpt);
				logoHeader.append("</font></td></tr>");
				logoHeader.append("</table>");
				logoHeader.append("<br>");
				logoHeader.append("</th>"); 
				logoHeader.append("</tr>"); 				
				logoHeader.append("</thead>"); 
				logoHeader.append("</table>");
			}
			
			
			logoHeader.append(clobData);
			
			logoHeader.append("<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>");
			logoHeader.append("<tr>");
			logoHeader.append("<td colspan='3' ><font style ='font-family:Verdana'>");
			logoHeader.append(section_content_ftr);
			logoHeader.append("</font>");
			logoHeader.append("</td>");
			logoHeader.append("</tr>");
			logoHeader.append("</table>");
			
			logoHeader.append("</td>");
			logoHeader.append("</tr>");
			logoHeader.append("</tbody>"); 
			logoHeader.append("</table>");
	//logo Header End
		sql = "SELECT SUBJECT_TEXT,RECIPIENTS_ID,URL_TEXT,VERY_REQD_CONF_RESULT_YN FROM SM_REPORT_MAIL_INFO WHERE MODULE_ID='"+module_id+"' AND REPORT_ID='"+report_id+"'";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();	
		String recipientIds_="";
		while(rs.next()){
			recipientIds_	= rs.getString("recipients_id") == null ? "": (String)rs.getString("RECIPIENTS_ID");
			subject			= rs.getString("SUBJECT_TEXT") == null ? "": (String)rs.getString("SUBJECT_TEXT");
			url_text		= rs.getString("URL_TEXT") == null ? "": (String)rs.getString("URL_TEXT");
			verReqdYn		= rs.getString("VERY_REQD_CONF_RESULT_YN") == null ? "V": (String)rs.getString("VERY_REQD_CONF_RESULT_YN");
		}
		
		if(verReqdYn.equals("Y")) verReqdYn = "A";
		else verReqdYn = "A";
		if(rs != null) rs.close();
		if(pst != null) pst.close();
		if(!"".equals(recipientIds_)){
			String[] temp=recipientIds_.split(",");		
			for(int i=0;i<temp.length;i++){
				 sb.append("'"+temp[i]+"'");			
				 if( (i+1)!=temp.length)
					 sb.append(",");
			}
			if((sb.toString()).equals(""))
				sb.append("''");
		}
		
		java.util.Date date = new java.util.Date(); 
		java.text.SimpleDateFormat sdf;  
		sdf = new java.text.SimpleDateFormat("ddMMyyyyhhmm"); 
		p_file_name = module_id + "-" + report_id + "-" + patient_id+"-"+(String)sdf.format(date)+".pdf";
		file_pathName = url_text+p_file_name;
		
		
		
		//InputStream is = new ByteArrayInputStream(clobData.getBytes());
		InputStream is = new ByteArrayInputStream((logoHeader.toString()).getBytes());
        Tidy tidy = new Tidy(); 
        tidy.setShowWarnings(false);
        tidy.setXmlTags(false);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setXHTML(true); 
        tidy.setMakeClean(true);
		
		Document xmlDoc = tidy.parseDOM(is, null);
        
		ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocument(xmlDoc, null);	    
	  
	    OutputStream os = new FileOutputStream(file_pathName);
	    renderer.layout();
	    renderer.createPDF(os);
	    os.close();
		
		pst = con.prepareStatement("select SM_GET_MAIL_BODY(?,?,?,?,?,?,?,'','',?) email_text FROM DUAL");
		pst.setString(1,module_id);
		pst.setString(2,report_id);
		pst.setString(3,"R");
		pst.setString(4,patient_id);
		pst.setString(5,encounter_id);
		pst.setString(6,facilityId);
		pst.setString(7,locale);
		pst.setString(8,null);
		rs = pst.executeQuery();
		while (rs !=null && rs.next())
		{				
			java.sql.Clob body_template_text = (java.sql.Clob)rs.getClob("email_text");
			if(body_template_text != null && body_template_text.length() > 0)
				editor_content = body_template_text.getSubString(1,( (int)body_template_text.length() ));
		}
		if(rs != null) rs.close();
		if(pst != null) pst.close();
		sql = "SELECT MAILER_ID,MAILER_NAME,EMAIL_ID FROM SM_REGD_MAILING_LST WHERE MAILER_ID IN("+sb.toString()+") AND EFF_STATUS='E'";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()){
			to_emailId	=  rs.getString("EMAIL_ID")==null?"":(String)rs.getString("EMAIL_ID");
			to_id		=  rs.getString("MAILER_ID")==null?"":(String)rs.getString("MAILER_ID");
			to_name		=  rs.getString("MAILER_NAME")==null?"":(String)rs.getString("MAILER_NAME");
			try{
			
				if(mailToType.equals("R")){
					pst1 = con.prepareStatement(sqlPwdForRegUser);
					pst1.setString(1,to_id);
					rs1 = pst1.executeQuery();
					while(rs1.next()){
						password = rs1.getString("pwd") == null ? password : rs1.getString("pwd");
					}

					if(rs1 != null) rs1.close();
					if(pst1 != null) pst1.close();
				}
				
				String addedById = p.getProperty( "login_user" ) ;
				String addedAtWorkstation=client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;
					
				csFaxMail = (oracle.jdbc.OracleCallableStatement) con.prepareCall("{call APPFAXMAIL.fax_mail_report_nf (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				
				csFaxMail.setString(1,facilityId);
				csFaxMail.setString(2,module_id);
				csFaxMail.setString(3,report_id);
				csFaxMail.setString(4,"@");
				csFaxMail.setString(5,"@");
				csFaxMail.setString(6,to_emailId);
				csFaxMail.setString(7,cc_emailId);
				csFaxMail.setString(8,null);
				csFaxMail.setString(9,subject);
				csFaxMail.setString(10,null);
				csFaxMail.setString(11,editor_content);
				csFaxMail.setString(12,disclaimer);
				csFaxMail.setString(13,"N");
				if(to_name.equals(""))
					csFaxMail.setString(14,null);
				else
				csFaxMail.setString(14,to_name);

				csFaxMail.setString(15,null);
				csFaxMail.setString(16,null);
				csFaxMail.setString(17,appl_user_name);
				csFaxMail.setString(18,null);
				csFaxMail.setString(19,null);
				csFaxMail.setString(20,"M");
				csFaxMail.setString(21,p_file_name);
				csFaxMail.setString(22,addedById);
				csFaxMail.setString(23,modifiedAtWorkstation);
				csFaxMail.setString(24,null);
				csFaxMail.registerOutParameter(25,Types.VARCHAR);
				csFaxMail.setString(26,p_report_type);
				csFaxMail.setStringForClob(27,"");
				//csFaxMail.setStringForClob(27,clobData);
				csFaxMail.setString(28,null);
				csFaxMail.setString(29,null);
				csFaxMail.setString(30,verReqdYn);
				csFaxMail.setString(31,password);
				csFaxMail.setString(32,patient_id);
				csFaxMail.setString(33,encounter_id);
				csFaxMail.setString(34,file_pathName);
				csFaxMail.registerOutParameter(35,Types.VARCHAR);
				csFaxMail.execute();
				
				error = csFaxMail.getString(25);
				p_srno = csFaxMail.getString(35);
				
				if(error!=null){
					con.rollback();
					java.util.Hashtable message = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
					error=error+":"+(String) message.get("message");
					message.clear();
					System.err.println("Error : "+error);
				}else{
					try{
						
						
						pstmt=con.prepareStatement("update sm_report_fax_mail_request set NOTIFICATION_DOCUMENT=?,ATTACHMENT_REQUEST_STATUS=? where REQUEST_SRL_NO =?");
							
						File image = new File(file_pathName);
						FileInputStream fis = new FileInputStream(image);
						pstmt.setBinaryStream(1, fis, (int) image.length());
						pstmt.setString(2,"S");
						pstmt.setString(3,p_srno);
						pstmt.execute();
						
						java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
						error=(String) message.get("message");	
						message.clear();
						if(pstmt != null) pstmt.close();
								
					}catch(Exception ex){
						System.err.println("Exception while updating Clob Data ! "+ex.toString());
					}
					con.commit();
				}
			}catch (Exception eeeee){
				con.rollback();
				System.err.println("Exception while parsing SectionTemplate ! "+eeeee.toString());				
				eeeee.printStackTrace();
			}finally{				
				if (csFaxMail != null) 
					csFaxMail.close();
			}
		}
		if(rs != null) rs.close();
		if(pst != null) pst.close();	
	}catch(Exception e){	
		System.err.println("Exception raised by Servlet ...So Record Not Send.  Foll: Error Received : "+e.toString());		
		e.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pst != null) pst.close();
		if(con != null) ConnectionManager.returnConnection(con, request);
	} 

            _bw.write(_wl_block2Bytes, _wl_block2);
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
