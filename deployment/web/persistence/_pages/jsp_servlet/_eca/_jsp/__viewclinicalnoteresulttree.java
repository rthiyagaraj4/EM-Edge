package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __viewclinicalnoteresulttree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewClinicalNoteResultTree.jsp", 1739876294716L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n10/11/2011    IN028225      Chowminya G      Incident No: IN028225 - <view clinical notes screen - note type asc/dsc> \n15/05/2012\t  IN032721\t\tRamesh G\t\tWhen we Click on Print Preview the Date is not displayed in the examination date component.\n08/08/2012    IN034220      Chowminya G      Incident No: IN034220 - <view clinical notes screen - note type asc/dsc>\n30/01/2014    EMR1508      Dinesh T      Transcribed note is not shown in the result page\n13/08/2013\t  IN038643\t   Karthi L\t\tA new field by name \"Speciality\" has been introduced as search filter in View Clinical Notes function in Clinician Access\n30/08/2013   IN042671\t\tKarthi L\tAt view clinical Notes System is not displaying recorded notes by selecting the specialty of the Patient. \t\n18/12/2013\tIN042552\t\tRamesh G\tBru-HIMS-CRF-391 --- Notes Confidentiality\t\n--------------------------------------------------------------------------------------------------------------\nDate       \tEdit History      \tName        \tRev.Date\t\tRev.Name\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n07/10/2016\tIN047572\t\t\tKarthi L\t\t\t\t\t\t\t\t\t\t[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?\t\t\t\t\n20/07/2023\t  24094\t   Ranjith P R\t\t21/07/2023\t\tRAMESH G\t\tML-MMOH-CRF-1804\t\t\t\n---------------------------------------------------------------------------------------------------------------\n--> \n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<style>\nTD.TD_BROWN\n{\n    BACKGROUND-COLOR: BROWN;  \n\tCOLOR = WHITE;\n\tFONT-SIZE: 9pt ;\n\tBORDER-STYLE: SOLID;\n\tborder-left-color: #B2B6D7;\n\tborder-right-color: #B2B6D7;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: #E2E3F0;\n\theight:18;\t\n }\n</style>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n\n\t \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"JavaScript\" src=\'../../eCA/js/ViewClinicalNote.js\'></script>\n<script Language=\"JavaScript\" src=\'../../eCA/js/RecClinicalNotesFileUpload.js\'></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n <script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<form name=\'result_form\' id=\'result_form\'>\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n<TR>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<Script language=javascript>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t\tparent.ViewClinicalNoteResultTreeFrame.document.location.href = \"../../eCommon/html/blank.html\";\n\t\t\tif(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'==\'\')\n\t\t\t\t\twindow.close();\n\t\t\telse\n\t\t\t{\t\t\t\t\t\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' != \'INVIDE_WAITLIST\')\t\t\t\t\t\t\t\n\t\t\t\t\tparent.ViewClinicalNoteCriteriaFrame.document.forms[0].searchresult_button.disabled = false;\n\t\t\t}\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</table>\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id	="";
	String note_type_id	="";
	String appl_task_id	="";
	String accession_num="";
	String perform_id	="";
	String med_anc_id	="";
	String status_val	="";
	String from_date	="";
	String end_date		="";
	int k				=0;
	String classValue	="";
	String note_type	="";
	String note_type_desc="";
	String service_name	="";
	String subject		="";
	String date_time	="";
	String modified_date	="";//24094
	String performed_by_name="";
	String authorized_by_name	="";
	String status		="";
	StringBuffer sql=new StringBuffer();
	Connection con		=null;
	ResultSet rs		=null;
	PreparedStatement stmt		=null;
	String cur_epi		="";
	String encounter_id	="";
	String ext_image_appl_id	="";
	String order = "";
	int i=1;
	String function_id = "";
	String l_clinican_id 	= "";
	String resp_id          ="";
	String user_id          ="";
	String facility_id      ="";
	String group = "";
	String prevnote="";
	String prevdate=""; 
	String time="";
	String event_date="";
	String note_group="";
	String no_modal="";
	String called_function_id="";
	String call_fileupload_notes="";
	String ref_no="";
	String encounterId = "";
	String acc_num = "";
	String contr_mod_accession_num = ""; //[IN032721]
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	function_id		=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String first_accession_num = "";
	String speciality_code = ""; //added for BRU-HIMS-CRF-356 [IN038643]
	String attend_pract_code	= "";  //MMS-QH-CRF-0177 [IN047572]			
  

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{
		con					= ConnectionManager.getConnection(request);
		rs					= null;
		stmt				= null;
		note_type_id		= request.getParameter("note_type")==null?"":request.getParameter("note_type");	        
		note_group			= request.getParameter("note_group")==null?"":request.getParameter("note_group"); 
		appl_task_id		= request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id"); 
		perform_id			= request.getParameter("performed_by")==null?"":request.getParameter("performed_by");
		med_anc_id			= request.getParameter("med_anc")==null?"":request.getParameter("med_anc");
		status_val			= request.getParameter("status")==null?"":request.getParameter("status");
		from_date			= request.getParameter("from_date")==null?"":request.getParameter("from_date");
		end_date			= request.getParameter("to_date")==null?"":request.getParameter("to_date");
		from_date			= com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
		end_date			= com.ehis.util.DateUtils.convertDate(end_date,"DMY",locale,"en");
		patient_id			=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		encounter_id		=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		acc_num		=request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
		no_modal			=request.getParameter("no_modal")==null?"":request.getParameter("no_modal");
		called_function_id	=request.getParameter("called_function_id")==null?"":request.getParameter("called_function_id");
		group				=request.getParameter("group")==null?"1":request.getParameter("group");
		order				=request.getParameter("order")==null?"":request.getParameter("order");
		cur_epi				=request.getParameter("cur_api");
		ref_no			=request.getParameter("ref_no")==null?"":request.getParameter("ref_no");
		contr_mod_accession_num =request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num"); //[IN032721]
		String p_event_class = request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");//CHL_CRF_0010
		attend_pract_code	= request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code");//MMS-QH-CRF-0177 [IN047572]	
		if(cur_epi ==null)
			cur_epi="N";

		l_clinican_id				=	(String) session.getValue("ca_practitioner_id");
		resp_id    					=	(String) session.getValue("responsibility_id");
		user_id 					=	(String) session.getValue("login_user");
		facility_id 				=	(String) session.getValue("facility_id");
		speciality_code		= 	 request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"); //added for BRU-HIMS-CRF-356 [IN038643]

		//cur_epi="N";
		if (called_function_id.equals("INVIDE_WAITLIST"))
		{
			sql.append(" SELECT 1 FROM CA_ENCNTR_NOTE WHERE FACILITY_ID=? AND ENCOUNTER_ID=? AND NOTE_TYPE 	IN (SELECT NOTE_TYPE FROM CA_NOTE_TYPE WHERE NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?))" );
			stmt=con.prepareStatement(sql.toString());
			stmt.setString(1,facility_id);
			stmt.setString(2,encounter_id);
			stmt.setString(3,appl_task_id);
			rs=stmt.executeQuery();

			if ((rs !=null) && !(rs.next()))
			{
				rs.close();
				if (stmt!=null) stmt.close();
				sql.setLength(0);
				sql.append("SELECT ENCOUNTER_ID FROM  CA_ENCNTR_NOTE WHERE PATIENT_ID=? AND EVENT_DATE_TIME=(SELECT MAX(EVENT_DATE_TIME) FROM CA_ENCNTR_NOTE WHERE PATIENT_ID=? AND NOTE_TYPE IN (SELECT NOTE_TYPE FROM CA_NOTE_TYPE WHERE NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=? ))) ");
				stmt=con.prepareStatement(sql.toString());
				stmt.setString(1,patient_id);
				stmt.setString(2,patient_id);
				stmt.setString(3,appl_task_id);
				rs=stmt.executeQuery();
			
				if (rs.next())
				{	  
				   
				    if (rs.getString(1)!=null) encounter_id=rs.getString(1);
						
				}			
			}

			if (rs!=null) rs.close();
			if (stmt!=null) stmt.close();
		}
		
		sql.setLength(0);
		if(attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]	- Start
			//added for BRU-HIMS-CRF-356 [IN038643] - Start
			if(!speciality_code.equals("")){
				sql.append("select * from ( "); 
			}
			// End
		} //MMS-QH-CRF-0177 [IN047572]		
		sql.append(" SELECT a.facility_id, a.accession_num, a.note_type,a.encounter_id,  "); 
		sql.append("B.note_type_desc,a.service_code,");
   		sql.append(" A.EVENT_STATUS status,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name,");
		sql.append(" a.event_title_desc,to_char(a.event_date_time,'dd/mm/yyyy HH24:MI')event_date_time,to_char(a.modified_date,'dd/mm/yyyy HH24:MI')modified_date1,to_char(a.event_date_time,'dd/mm/yyyy')event_date,to_char(a.event_date_time,'HH24:MI') time,a.performed_by_id,");//24094
		
		sql.append(" d.practitioner_name performed_by_name,a.authorized_by_id,");
		sql.append(" e.practitioner_name authorized_by_name, ");
		sql.append(" CA_GET_DESC.CA_NOTE_GROUP(b.note_group_id,?,'1') note_group_desc,CA_GET_APPL_NOTE_OPERN(a.facility_id,a.accession_num,?,?,a.note_type,? ) rights ");
		if(attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]	
			//added for BRU-HIMS-CRF-356 [IN038643] - Start
			if(!speciality_code.equals("")){ 
				//sql.append(",(SELECT SPECIALTY_CODE FROM pr_encounter WHERE encounter_id = a.encounter_id and SPECIALTY_CODE in(select SPECIALITY_CODE from am_pract_specialities where practitioner_id = ? and facility_id=?)) SPECIALTY_CODE");// commented for IN042671
				sql.append(",(SELECT   SPECIALTY_CODE FROM pr_encounter WHERE encounter_id = a.encounter_id AND facility_id = ? ) SPECIALITY_CODE1,(SELECT PRIMARY_SPECIALITY_CODE FROM  AM_PRACTITIONER WHERE   practitioner_id = A.PERFORMED_BY_ID) SPECIALITY_CODE2"); // modified for for IN042671
			}      
			//End
		} //MMS-QH-CRF-0177 [IN047572]	
		sql.append(" ,a.ext_image_appl_id FROM ca_encntr_note a,CA_NOTE_TYPE_LANG_VW B,am_practitioner_lang_vw d, ");
		sql.append(" am_practitioner_lang_vw e ");
		if(!attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]	- Start
			sql.append(" , pr_encounter f "); //MMS-QH-CRF-0177 [IN047572]
		} // MMS-QH-CRF-0177 [IN047572]	- End			
		sql.append(" WHERE  ");

		if(!attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]	- Start
			sql.append(" a.patient_id = f.patient_id and ");
		} // MMS-QH-CRF-0177 [IN047572]	- End
		/***********ADDED BY Deepa on 9/16/2009 at 2:47 PM for RD change****************/
		if(acc_num.equals(""))
			sql.append(" a.CONTR_MOD_ACCESSION_NUM is null  and ");
		else
			sql.append(" a.ACCESSION_NUM = ? and ");
		/***********ADDED BY Deepa on 9/16/2009 at 2:47 PM for RD change****************/

		if (!called_function_id.equals("INVIDE_WAITLIST"))
			sql.append("  (CA_GET_APPL_NOTE_OPERN(a.facility_id,a.accession_num,?,?,a.note_type,? )  is not null OR a.CONTR_MOD_ACCESSION_NUM is not null )and ");
		/**** MODIFIED BY Deepa on 12/10/2009 at 11:37 AM for RD issue****/
		//sql.append ("   a.note_type = b.note_type and b.language_id = ?  and a.event_status in ('3','4','5','9')  ");
		//sql.append ("   a.note_type = b.note_type and b.language_id = ?  and (a.event_status in ('3','4','5','9') OR a.CONTR_MOD_ACCESSION_NUM is not null ) ");
		sql.append ("   a.note_type = b.note_type and b.language_id = ?  and (a.event_status in ('2','3','4','5','9') OR a.CONTR_MOD_ACCESSION_NUM is not null ) ");//EMR1508
		/**** MODIFIED BY Deepa on 12/10/2009 at 11:37 AM for RD issue****/
		sql.append(" and d.practitioner_id(+)=a.performed_by_id and d.language_id(+) = ? and e.practitioner_id(+)=a.authorized_by_id and  e.language_id(+) = ?  and a.patient_id=? "); 
		
		//IN042552 Start.
		String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");
		sql.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");
		//IN042552 End.
		
		if (!appl_task_id.equals(""))
		{
			sql.append(" and a.note_type in (SELECT B.NOTE_TYPE FROM CA_NOTE_GROUP a,CA_NOTE_TYPE B WHERE A.APPL_TASK_ID=? AND B.NOTE_GROUP_ID=A.NOTE_GROUP)  ");
		}

		if(!(note_type_id.equals("")))
		{
			sql.append("and a.note_type=? ");
		}

		if(!(note_group.equals("")))
		{
			sql.append("and a.note_type in (select note_type from ca_note_type where note_group_id=?) ");
		}
		if(!(perform_id.equals("")))
		{
			sql.append("and a.performed_by_id=? ");
		}

		if(!(med_anc_id.equals("")))
		{
			sql.append("and a.service_code=? ");
		}

		if(!(status_val.equals("")))
		{
			sql.append("and a.event_status=? ");
		}
		else
		{
			sql.append("and a.event_status != 9");
		}

		if(!(ref_no.equals("")))
		{
			sql.append("and upper(a.DOC_REF_ID) like upper('"+ref_no+"%')");		
		}

		if(cur_epi.equals("Y"))
		{
			if(attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]
				sql.append(" and a.facility_id=? and a.encounter_id=? "); 
			} else {		// MMS-QH-CRF-0177 [IN047572] - Start	
				sql.append(" and a.facility_id=? and a.encounter_id=? and a.encounter_id = f.encounter_id"); 
			}	// MMS-QH-CRF-0177 [IN047572]	- End 	
		} 
		//CHL_CRF_0010 Starts
		if("VIEW_NURSE_NOTES".equals(called_function_id))
		{
			sql.append(" and a.event_class=? ");
		}
		//CHL_CRF_0010 Ends
		if(acc_num.equals(""))
		{		
			if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			{
				sql.append(" and a.event_date_time between to_date(?,'dd/mm/yyyy') and  to_date(?,'dd/mm/yyyy')+.999 ");
			}
			else if((end_date.equals("")) && !(from_date.equals("")))
			{
				 sql.append(" and a.event_date_time >= to_date(?,'dd/mm/yyyy')");
		    }
			else if((from_date.equals("")) && !(end_date.equals("")))
			{
				sql.append(" and a.event_date_time <= to_date(?,'dd/mm/yyyy')+.999");
			}
		}
		if(!attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]	- Start
			sql.append( " AND F.PATIENT_ID = A.PATIENT_ID  AND F.ENCOUNTER_ID = A.ENCOUNTER_ID "); // IN062241 -  MMS-QH-CRF-0177 [IN047572]
			sql.append( " AND F.ATTEND_PRACTITIONER_ID = ? ");
		} // MMS-QH-CRF-0177 [IN047572]	 - End
        if (group.equals("1"))
		{
			if(order.equals("D"))
				//sql.append(" order by a.event_date_time desc,b.note_type_desc desc ,a.note_type desc");//Modified --[IN028225] 
				sql.append(" order by b.note_type_desc desc ,a.note_type desc, a.event_date_time asc");//Modified --[IN034220]
			else
				//sql.append(" order by a.event_date_time desc,b.note_type_desc ,a.note_type"); //Modified --[IN028225]
				sql.append(" order by b.note_type_desc ,a.note_type,  a.event_date_time asc"); //Modified --[IN034220]
		}
		else
		{
			if(order.equals("D"))
				//sql.append(" order by a.event_date_time desc,b.note_type_desc desc ,a.note_type desc  ");//Modified --[IN028225] 
				sql.append(" order by a.event_date_time desc  ");
			else
		        //sql.append(" order by a.event_date_time desc, b.note_type_desc ,a.note_type  ");//Modified --[IN028225]
				sql.append(" order by a.event_date_time asc   ");//Modified --[IN034220]
		}
      //added for BRU-HIMS-CRF-356 [IN038643] - Start
		if(attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]	
	        if(!speciality_code.equals("")){
				//sql.append(") where SPECIALITY_CODE = ?"); // commented for IN042671
				sql.append(") where SPECIALITY_CODE1 = ? or SPECIALITY_CODE2 = ? "); // modified for IN042671
			}
	      // End
		} // MMS-QH-CRF-0177 [IN047572]
     	System.out.println(" 315. VieClinicalNoteResultTree.jsp " + sql.toString());
		stmt=con.prepareStatement(sql.toString());
		int count1=0;
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,resp_id);	    
		stmt.setString(++count1,l_clinican_id);		
		stmt.setString(++count1,user_id);		
		
		if(attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]	
			//added for BRU-HIMS-CRF-356 [IN038643] - Start
			if(!speciality_code.equals("")){
				//stmt.setString(++count1,l_clinican_id);  // commented for IN042671
				stmt.setString(++count1,facility_id);
			}
			// End
		} // MMS-QH-CRF-0177 [IN047572]
		if(!acc_num.equals(""))
			stmt.setString(++count1,acc_num);
		
		if (!called_function_id.equals("INVIDE_WAITLIST"))
		{
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,l_clinican_id);
			stmt.setString(++count1,user_id);
		}

		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);

		stmt.setString(++count1,patient_id);

		if (!appl_task_id.equals(""))
		{
			stmt.setString(++count1,appl_task_id);
		}

		if(!(note_type_id.equals("")))
		{
			stmt.setString(++count1,note_type_id);
		}
		
		if(!(note_group.equals("")))
		{
			stmt.setString(++count1,note_group);
		}

		if(!(perform_id.equals("")))
		{
			stmt.setString(++count1,perform_id);		
		}

		if(!(med_anc_id.equals("")))
		{
			stmt.setString(++count1,med_anc_id);
		}

		if(!(status_val.equals("")))
		{
			stmt.setString(++count1,status_val);
		}
	
		if(cur_epi.equals("Y"))
		{
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,encounter_id);
		} 
		//CHL_CRF_0010 Starts
		if("VIEW_NURSE_NOTES".equals(called_function_id))
		{
			stmt.setString(++count1,p_event_class);
		}
		//CHL_CRF_0010 Ends
		if(acc_num.equals(""))
		{
			if( (!(from_date.equals(""))) && (!(end_date.equals(""))) )
			{
				stmt.setString(++count1,from_date);
				stmt.setString(++count1,end_date);
			}
			else if((end_date.equals("")) && !(from_date.equals("")))
			{
				stmt.setString(++count1,from_date);
			}
	        else if((from_date.equals("")) && !(end_date.equals("")))
			{
				stmt.setString(++count1,end_date);
			}
		}
		if(!attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572]	- Start
			stmt.setString(++count1, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572]	- End
		if(attend_pract_code.equals("")) { // MMS-QH-CRF-0177 [IN047572] - Start	
			//added for BRU-HIMS-CRF-356 [IN038643]  - Start
			if(!speciality_code.equals("")) {
				stmt.setString(++count1,speciality_code);  // added for IN042671
				stmt.setString(++count1,speciality_code);
			}
			// End
		} // MMS-QH-CRF-0177 [IN047572] - End
		rs=stmt.executeQuery();
		

            _bw.write(_wl_block10Bytes, _wl_block10);

if(!group.equals("4"))
{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

}

if(!group.equals("1"))
{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

}
 
 if (rs !=null)        
 {
	while(rs.next())
	{
		if ( k%2 == 0 )
		classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;
		
		note_type_desc=rs.getString("note_type_desc");
		ext_image_appl_id=rs.getString("ext_image_appl_id");
		accession_num=rs.getString("accession_num");
		
		if(first_accession_num.equals("") && (called_function_id.equals("INVIDE_WAITLIST")))//Added by Uma on 12/9/2010 for IN024109
			first_accession_num = accession_num;
		service_name=rs.getString("service_name");
		subject=rs.getString("event_title_desc");
		date_time=rs.getString("event_date_time");
		modified_date=rs.getString("modified_date1");//24094
		event_date=rs.getString("event_date");
		
		event_date	= com.ehis.util.DateUtils.convertDate(event_date,"DMY","en",locale);
		date_time	= com.ehis.util.DateUtils.convertDate(date_time,"DMYHM","en",locale);
		modified_date	= com.ehis.util.DateUtils.convertDate(modified_date,"DMYHM","en",locale);//24094
		
		time = rs.getString("time");
		performed_by_name=rs.getString("performed_by_name");
		authorized_by_name=rs.getString("authorized_by_name");
		status=rs.getString("status");
		note_type=rs.getString("note_type");
		encounterId = rs.getString("encounter_id") == null ? "" : rs.getString("encounter_id");
			
		
		if(status.equals ("1"))
		{				
			status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
		}	
		else if(status.equals("2"))
		{
			status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
		}
		else if(status.equals("3"))
		{
			status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
		}
		else if(status.equals ("4"))
		{
			
			status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
			
		}	
		else if(status.equals("5"))
		{
			
			status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
		}			
		else if(status.equals("9"))
		{
			status =	
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
		
		}
	
		if(ext_image_appl_id ==null || ext_image_appl_id.equals(""))
		{
			ext_image_appl_id="";
		}
		if(note_type ==null || note_type.equals(""))
		{
			note_type="";
		}
		if(service_name ==null || service_name.equals(""))
		{
			service_name="";
		}
		if(subject ==null || subject.equals(""))
		{
			subject="";
		}
		if(date_time ==null || date_time.equals(""))
		{
			date_time="";
		}
		if(performed_by_name ==null || performed_by_name.equals(""))
		{
			performed_by_name="";
		}
		if(authorized_by_name ==null || authorized_by_name.equals(""))
		{
			authorized_by_name="";
		}
		if(status ==null || status.equals(""))
		{
			status="";
		}
		if(time ==null || time.equals(""))
		{
			time="";
		}
	
		if(!ext_image_appl_id.equals(""))
		{
			call_fileupload_notes ="<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+note_type+"\")' height='20' title='FileUpload...' ></img>";
		}
		else
			call_fileupload_notes ="";

		if(!note_type.equals(prevnote))
		{			
			if(group.equals("1"))
			{
				out.println("<tr><td  class='CAHIGHERLEVELCOLOR'><font size=2>"+note_type_desc+"</font></td></tr>");
			}
		}

		if(!event_date.equals(prevdate))
		{
			if(group.equals("4"))
			{

				out.println("<tr><td nowrap colspan=2 class='CAHIGHERLEVELCOLOR' ><font size=2>"+event_date+"</font></td></tr>");

			 }
		}

		if(!group.equals("1"))
		{
			out.println("<tr><td nowrap <td  class='gridData' ><a class='gridLink'  href=javascript:call_notes('"+accession_num+"','"+appl_task_id+"','"+no_modal+"','"+called_function_id+"','"+encounterId+"')>&nbsp;&nbsp;"+time+"</a><td <td  class='gridData' >"+note_type_desc+"&nbsp;"+call_fileupload_notes+"</td>");
		}


		if(!group.equals("4"))
		{
			out.println("<tr><td nowrap <td  class='gridData' colspan='2'><a class='gridLink'  href=javascript:call_notes('"+accession_num+"','"+appl_task_id+"','"+no_modal+"','"+called_function_id+"','"+encounterId+"')>&nbsp;&nbsp;&nbsp;"+date_time+"&nbsp;"+call_fileupload_notes+"</a>");
			//24094 starts
			if(status.equals("Modified")){
			out.println("&nbsp;&nbsp;&nbsp;<img style='cursor:pointer;' src='../../eCA/images/modifiedresult.png' alt='"+modified_date+"'/></td>");
		    System.out.println("--->596");
			}
			//24094 ends
		}
		prevnote = note_type;
		prevdate = event_date;

		i++;
		k++;
	  }
  }//if
		
  if(k==0)
  { 
  
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(called_function_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(called_function_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	else if(k==1 && ext_image_appl_id.equals("")) 
	{
			out.println("<script>parent.ViewClinicalNoteResult.cols='0%,100%'</script>");
			/* out.println("<script>parent.document.getElementById('ViewClinicalNoteResultTreeFrame').style.width='0vw';</script>");
			out.println("<script>parent.document.getElementById('ViewClinicalNoteNoteContentMainDetailFrame').style.width='100vw';</script>"); */			
		
		out.println("<script>call_notes('"+accession_num+"','"+appl_task_id+"','"+no_modal+"','"+called_function_id+"','"+encounterId+"','"+contr_mod_accession_num+"')</script>");
	}
	else if (called_function_id.equals("INVIDE_WAITLIST") && k>1)//Added by Uma on 12/9/2010 for IN024109
	{				
		out.println("<script>call_notes('"+first_accession_num+"','"+appl_task_id+"','"+no_modal+"','"+called_function_id+"','"+encounterId+"')</script>");
	}/*Ends Here*/
	out.println("<script>if(parent.ViewClinicalNoteResultTreeFrame !=null && parent.ViewClinicalNoteCriteriaFrame != null) parent.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.searchresult_button.disabled=false</script>");

	if(rs!=null)	rs.close();
	if(stmt!=null) 	stmt.close();
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
}
