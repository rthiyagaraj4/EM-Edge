package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __reviewnotesdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ReviewNotesDetails.jsp", 1709116263371L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n29/06/2012\t  IN030468\t\tDinesh T\t BRUHIMS CRF.\n16/07/2012\t  IN033857\t\tDinesh T\t BRUHIMS CRF-Linked Issue\n06/02/2013\t\tIN037675\tDinesh T\tIN037675\n16/03/2013\tIN038659\t\tDineshT\t\tPrivilege level setup with sign is not working\t\n14/05/2013\tIN038659-ForwardingNotes\tvijayakumark \tWe are not able to get all notes which are forwarded from 1 speciality to another speciality in the Practitioner\'s homepage ( Pending Notes Review )  as well as in the navigator under ( Review Notes ).\n26/12/2013\tIN046001\t\tRamesh G\tBru-HIMS-CRF-391-42552/11\n18/03/2020\tIN071264\t\tNijitha S\tGHL-CRF-0604\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\n\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/ReviewNotes.js\'></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"ReviewNotesDetails_form\" id=\"ReviewNotesDetails_form\" action=\"../../servlet/eCA.ReviewNotesServlet\" method=\"post\" target=messageFrame>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'content\'>\n<table  border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'>&nbsp;</td>\n\t<td class=\'COLUMNHEADERCENTER\'>&nbsp;&nbsp;</td>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>if(parent.ReviewNotesCriteriaFrame.document.getElementById(\"search\")!=null)\n\t\t\t\tparent.ReviewNotesCriteriaFrame.document.getElementById(\"search\").disabled=false;</script>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<Script language=javascript>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</table>\n</body>\n<input type=\"hidden\" name=\"noofrec\" id=\"noofrec\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name=\"final_values\" id=\"final_values\" value=\"\">\n<input type=\'hidden\' name=\'requested_to\' id=\'requested_to\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<!--this remarks hidden will be used only for one entry at a time-->\n<input type=\"hidden\" name=\"remarks\" id=\"remarks\" value=\"\">\n</form>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String requested_to = "";
	
	try
	{
		con = ConnectionManager.getConnection(request);

		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");		
		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		String	respid		=	(String)	session.getValue("responsibility_id");
		String	facilityid	=	(String)	session.getValue("facility_id");
		String notetypecode = request.getParameter("note_type_code")==null?"":request.getParameter("note_type_code");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String ToDate =request.getParameter("ToDate")==null?"":request.getParameter("ToDate");
		String requestedbyid = request.getParameter("requested_by_id")==null?"":request.getParameter("requested_by_id");
		String view = request.getParameter("view")==null?"ALL":request.getParameter("view");
		String reqFacility = request.getParameter("reqFacility")==null?"":request.getParameter("reqFacility");//IN030468
		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
		ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

		requested_to = request.getParameter("requested_to");
		if(requested_to==null)
			requested_to = "P";
		//String code = "";
		//String desc = "";
		StringBuffer sql = new StringBuffer(); 
		String classValue = "";
		String prevnotetype = "";
		String value = "";
		String valueForNotes = "";
		String curr_patient_id = "";
		String curr_episode_id = "";
		//String list = "";
		String actionType ="",preActionType="";
		String action_by_group_code	="";
		String action_group_desc	="";
		String action_by_type		="";
		String facility_id			="";
		String request_date_time	="";
		String actionType1			="";
		String patient_class = "";
		String img = "";
		String doc_linked  = "";
		int i = 0;

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
		if(sql.length() > 0) sql.delete(0,sql.length());
			
		/*	sql.append( " select a.note_type,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc, a.facility_id, a.accession_num ");
			sql.append( ", to_char(a.request_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append( " ,a.request_by_id,AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,?,'1') request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id,?) pline");
			sql.append( " ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id,a.ACTION_COMMENT subject,decode(PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE,decode(a.action_type,'RS','Response','RV','Request','Forwarded to Specialty') action_type, ");
			sql.append("a.action_by_group_code action_group_code,a.action_by_type action_by_type, (select short_desc from am_speciality where speciality_code=a.action_by_group_code) action_group_desc ");
			sql.append( " from ca_encntr_note_audit_log_view a ");
			sql.append(" ,ca_note_type_for_resp b where a.action_status = 'RQ'");
			if (requested_to.equals("P"))
				sql.append(" and a.action_by_id = ? and a.action_type in ('RV','RS')  ");
			else if (requested_to.equals("S"))
				sql.append(" and a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");
			else 
				sql.append(" and ( (a.action_by_id = ? and a.action_type in ('RV','RS') ) or a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ))");

			//sql.append( " where a.action_by_id = ? ");
			//sql.append(" and a.facility_id = ? "); //IN030468
			sql.append(" and a.event_status != '9'"); 
			sql.append(" and b.note_type = a.note_type "); 
			sql.append(" and b.resp_id = ? ");
			//sql.append(" and a.action_status = 'RQ' ");

			if(view.equals("ALL"))
			{
				sql.append(" and a.action_type in ('RV','RS','FS') ");
			}
			else if(view.equals("RS"))
			{
				sql.append(" and a.action_type = 'RS' ");
			}
			else if(view.equals("RQ"))
			{
				sql.append(" and a.action_type in ('RV','FS') ");
			}
			if(!notetypecode.equals(""))
			sql.append(" and a.note_type =? ");
			if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");
			if(requested_to!=null && (requested_to.equalsIgnoreCase("P") || requested_to.equalsIgnoreCase("S")))
			{
				sql.append(" and a.action_by_type = ? ");
			}
			sql.append(" order by a.action_type,a.note_type_desc "); */
			
		// new 
		/*In Below query this condition is appended  decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?) as  for new born cases the application shows blank for patient details.
		Added by Archana on 4/16/2010 at 9:31 AM for IN020707*/

			//sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, a.request_by_id, am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name,decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (a.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class  FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b WHERE a.action_status = 'RQ' ");
			//IN038659-ForwardingNotes Start
			//sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, a.request_by_id, am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name,decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (c.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class  FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b WHERE a.action_status = 'RQ' ");//DineshT 7/24/2012
			/*
			//IN038659-ForwardingNotes End.
			if (requested_to.equals("P"))
			{
				sql.append(" and a.action_by_id = ? and a.action_type in ('RV','RS')  ");
				//sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			}
			else if (requested_to.equals("S"))
			{
				sql.append(" and a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");
				//sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			}
			else 
			{
				//sql.append(" and ( (a.action_by_id = ? and a.action_type in ('RV','RS') ) or a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ))");
				sql.append(" and a.action_by_id = ? and a.action_type in ('RV','RS')  ");//IN038659
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
				//sql.append(" or a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");//IN038659
				//sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			}
			
						 
			sql.append(" AND c.event_status in ('3','4','5')  and c.accession_num=a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? ");//IN030468

			if(view.equals("ALL"))
			{
				sql.append(" and a.action_type in ('RV','RS','FS') ");
			}
			else if(view.equals("RS"))
			{
				sql.append(" and a.action_type = 'RS' ");
			}
			else if(view.equals("RQ"))
			{
				sql.append(" and a.action_type in ('RV','FS') ");
			}
			if(!notetypecode.equals(""))
			sql.append(" and c.note_type =? ");
			if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");
			
			*/ //IN038659-ForwardingNotes
		/*	commendedt to fix SRR20056-SCF-3902 (16832)
			if(requested_to!=null && (requested_to.equalsIgnoreCase("P") || requested_to.equalsIgnoreCase("S")))
			{
			sql.append(" and a.action_by_type = ? ");
			}*/
			/*  //IN038659-ForwardingNotes
			if(!fromDate.equals("")&&(!ToDate.equals("")))
			{
				sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
			}
			else if(!fromDate.equals("") && (ToDate.equals("")))
			{
				sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
			}
			else if(fromDate.equals("") && !ToDate.equals(""))
			{
				sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
			}
			if(!patientId.equals(""))
			sql.append( "and c.patient_id =? ");
			//IN030468 starts
			if(!reqFacility.equals(""))
			sql.append("and a.facility_id = ?");
		//unable to see forwarded notes in other facility	
		
		*/  //IN038659-ForwardingNotes
		/*else
		{
			sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
		}*/	
		
		//IN030468 ends//IN033857
		
			/********MODIFIED BY Deepa on 10/5/2009 at 2:22 PM for IN015076**************************/
			//sql.append(" ORDER BY a.action_type,2 ");
			
			// sql.append(" ORDER BY a.action_type,2,a.request_date_time desc ");  //IN038659-ForwardingNotes Start.
			/********MODIFIED BY Deepa on 10/5/2009 at 2:22 PM for IN015076**************************/

			/*  //IN038659-ForwardingNotes Start.
			pstmt=con.prepareStatement(sql.toString());

			//*********parameter binding
			int count=0;
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			//Added by Archana on 4/16/2010 at 9:31 AM for IN020707.
			pstmt.setString(++count,locale);
			
			if (requested_to.equals("P")||requested_to.equals("S"))
			{
				pstmt.setString(++count,clinicianid);
				pstmt.setString(++count,(String)session.getValue("facility_id"));//IN037675
			}
			else
			{
				pstmt.setString(++count,clinicianid);
				pstmt.setString(++count,(String)session.getValue("facility_id"));//IN038659
				//pstmt.setString(++count,clinicianid);
				//pstmt.setString(++count,(String)session.getValue("facility_id"));//IN038659
			}
			//pstmt.setString(++count,clinicianid);
			//pstmt.setString(++count,(String) session.getValue("facility_id"));
			pstmt.setString(++count,respid);
			if(!notetypecode.equals(""))
				pstmt.setString(++count,notetypecode);
			if(!requestedbyid.equals(""))
				pstmt.setString(++count,requestedbyid); 
			*/  //IN038659-ForwardingNotes Start.
			/*if(requested_to!=null && (requested_to.equalsIgnoreCase("P") || requested_to.equalsIgnoreCase("S")))
			{
				pstmt.setString(++count,requested_to);
			}*/
			/*  //IN038659-ForwardingNotes Start.
			if(!fromDate.equals("")&&(!ToDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				pstmt.setString(++count,ToDate);
			}
			else if(!fromDate.equals("") && (ToDate.equals("")))
		  {
				pstmt.setString(++count,fromDate);
		  }
          else if(fromDate.equals("") && !ToDate.equals(""))
		  {
			pstmt.setString(++count,ToDate);
		  }

			if(!patientId.equals(""))
				pstmt.setString(++count,patientId);
			//IN030468 starts
			if(!reqFacility.equals(""))
				pstmt.setString(++count,reqFacility);
			*/ //IN038659-ForwardingNotes Start.
			/*else //unable to see forwarded notes in other facility
			{
				pstmt.setString(++count,clinicianid);
			}//IN030468 ends	*///IN033857
			
			//IN038659-ForwardingNotes starts
			if (requested_to.equals("P") || requested_to.equals("A"))
			{
			
				sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, a.request_by_id, am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name,decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (c.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class  FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b WHERE a.action_status = 'RQ' ");
				//IN046001 Start.
				sql.append("  and nvl(ca_view_confidnt_event (c.facility_id,c.ENCOUNTER_ID,c.PATIENT_ID,c.accession_num,'CA',c.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',c.PERFORMED_BY_ID,c.AUTHORIZED_BY_ID,null),'N')='Y' ");
				//IN046001 End.
				
				sql.append(" and a.action_by_id = ? and a.action_type in ('RV','RS')  ");
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
				
				sql.append(" AND c.event_status in ('3','4','5')  and c.accession_num=a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? ");//IN030468

				if(!fromDate.equals("")&&(!ToDate.equals("")))
				{
					sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
				}
				else if(!fromDate.equals("") && (ToDate.equals("")))
				{
					sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
				}
				else if(fromDate.equals("") && !ToDate.equals(""))
				{
					sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
				}

				if(view.equals("ALL"))
				{
					sql.append(" and a.action_type in ('RV','RS','FS') ");
				}
				else if(view.equals("RS"))
				{
					sql.append(" and a.action_type = 'RS' ");
				}
				else if(view.equals("RQ"))
				{
					sql.append(" and a.action_type in ('RV','FS') ");
				}

				if(!notetypecode.equals(""))
				sql.append(" and c.note_type =? ");
				
				if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");

				if(!patientId.equals(""))
				sql.append( "and c.patient_id =? ");
				
				//IN030468 starts
				if(!reqFacility.equals(""))
				sql.append("and a.facility_id = ?");

				
			}

			if(requested_to.equals("A"))
			{
				sql.append(" union all ");
			}			
			
			if (requested_to.equals("S") || requested_to.equals("A"))
			{
			
				sql.append(" SELECT c.note_type,ca_get_desc.ca_note_type (c.note_type, ?,'1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, a.request_by_id, am_get_desc.am_practitioner (a.request_by_id,?, '1' ) request_by_name,decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?), get_patient.get_line_detail (c.facility_id, c.encounter_id, ? ) ) pline, b.privilege_type, c.patient_id patient_id, c.encounter_id encounter_id, a.action_comment subject, DECODE (c.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type, DECODE (a.action_type, 'RS', 'Response', 'RV', 'Request', 'Forwarded to Specialty' ) action_type, a.action_by_group_code action_group_code, a.action_by_type action_by_type, am_get_desc.am_speciality (a.action_by_group_code,?,1) action_group_desc,c.patient_class patient_class  FROM ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b WHERE a.action_status = 'RQ' ");
				//IN046001 Start.
				sql.append("  and nvl(ca_view_confidnt_event (c.facility_id,c.ENCOUNTER_ID,c.PATIENT_ID,c.accession_num,'CA',c.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',c.PERFORMED_BY_ID,c.AUTHORIZED_BY_ID,null),'N')='Y' ");
				//IN046001 End.
				sql.append(" and a.ACTION_BY_GROUP_CODE = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id = ? ) ");
				sql.append(" AND NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A') ");//IN038659
				
				sql.append(" AND c.event_status in ('3','4','5')  and c.accession_num=a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? ");//IN030468

				if(!fromDate.equals("")&&(!ToDate.equals("")))
				{
					sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
				}
				else if(!fromDate.equals("") && (ToDate.equals("")))
				{
					sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
				}
				else if(fromDate.equals("") && !ToDate.equals(""))
				{
					sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
				}
				
				if(view.equals("ALL"))
				{
					sql.append(" and a.action_type in ('RV','RS','FS') ");
				}
				else if(view.equals("RS"))
				{
					sql.append(" and a.action_type = 'RS' ");
				}
				else if(view.equals("RQ"))
				{
					sql.append(" and a.action_type in ('RV','FS') ");
				}

				if(!notetypecode.equals(""))
				sql.append(" and c.note_type =? ");
				if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");

				if(!patientId.equals(""))
				sql.append( " and c.patient_id =? ");
				//IN030468 starts
				if(!reqFacility.equals(""))
				sql.append(" and a.facility_id = ? ");

				
			}
			
			sql.append(" ORDER BY action_type,2,request_date_time desc ");
			
						
			System.out.println("Line No:173 ReviewNotesDetails.jsp sql>"+sql);
			pstmt=con.prepareStatement(sql.toString());

			//*********parameter binding
			int count=0;
			
			
			if (requested_to.equals("P") || requested_to.equals("A"))
			{
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				//Added by Archana on 4/16/2010 at 9:31 AM for IN020707.
				pstmt.setString(++count,locale);
				pstmt.setString(++count,clinicianid);
				pstmt.setString(++count,facilityid);
				pstmt.setString(++count,respid);
				
				if(!fromDate.equals("")&&(!ToDate.equals("")))
				{
					pstmt.setString(++count,fromDate);
					
					pstmt.setString(++count,ToDate);
					
				}
				else if(!fromDate.equals("") && (ToDate.equals("")))
				{
					pstmt.setString(++count,fromDate);
					
				}
				else if(fromDate.equals("") && !ToDate.equals(""))
				{
					pstmt.setString(++count,ToDate);
					
				}
				
				if(!notetypecode.equals(""))
				{
				
					pstmt.setString(++count,notetypecode);
				}
				if(!requestedbyid.equals(""))
				{
				
					pstmt.setString(++count,requestedbyid);
				}
				if(!patientId.equals(""))
				{
				
					pstmt.setString(++count,patientId);
				}
				if(!reqFacility.equals(""))
				{
				
					pstmt.setString(++count,reqFacility);
				}
			}
			
			if(requested_to.equals("S") || requested_to.equals("A"))
			{
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,clinicianid);
				pstmt.setString(++count,facilityid);
				pstmt.setString(++count,respid);
				
				if(!fromDate.equals("")&&(!ToDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				
				pstmt.setString(++count,ToDate);
				
			}
			else if(!fromDate.equals("") && (ToDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				
			}
			else if(fromDate.equals("") && !ToDate.equals(""))
			{
				pstmt.setString(++count,ToDate);
				
			}
			
			if(!notetypecode.equals(""))
			{
				pstmt.setString(++count,notetypecode);
			}
			
			if(!requestedbyid.equals(""))
			{
				pstmt.setString(++count,requestedbyid);
			}

			if(!patientId.equals(""))
			{
				pstmt.setString(++count,patientId);
			}
			
			if(!reqFacility.equals(""))
			{
				pstmt.setString(++count,reqFacility);
			}
			}
			//IN038659-ForwardingNotes ends		
			
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{	
				if(i%2 == 0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";
				String patdetails = rs.getString("pline");
				if (patdetails== null) patdetails="";
				String notetypedesc = rs.getString("note_type_desc");
				if (notetypedesc== null) notetypedesc="";
			
				doc_linked						=			rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");
							

				String	note_type	=	rs.getString("note_type");
				if (note_type== null) note_type="";
				
				img = "";
				if(doc_linked.equals("Y"))
				img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+rs.getString("accession_num")+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
				else
				img = "&nbsp;";

				String privilegetype = rs.getString("privilege_type");
				if (privilegetype== null) privilegetype="";
				curr_patient_id		=	rs.getString("patient_id");
				patient_class		=	rs.getString("patient_class") == null?"":rs.getString("patient_class");
				curr_episode_id 	=	rs.getString("encounter_id");
				String	subject	=	(rs.getString("subject")==null)?"&nbsp;":rs.getString("subject");
				String  requested_by_id = rs.getString("request_by_id")==null?"":rs.getString("request_by_id");
				action_by_group_code = rs.getString("action_group_code");
				if (action_by_group_code==null)
					action_by_group_code = "";
				action_group_desc = rs.getString("action_group_desc");
				if (action_group_desc==null)
					action_group_desc = "";
				action_by_type = rs.getString("action_by_type");
				if (action_by_type==null)
					action_by_type = "P";
				facility_id = rs.getString("facility_id");

				actionType = rs.getString("action_type");
				if(actionType.equals("Response"))
				{
					actionType1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels");
				}
				else if(actionType.equals("Request"))
				{
					actionType1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels");
				}
				else if(actionType.equals("Forwarded to Specialty"))
				{
					actionType1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
				}			
				
				request_date_time = rs.getString("request_date_time");
				if (request_date_time==null)
					request_date_time = "";
				if(!actionType.equals(preActionType))
					out.println("<tr><td class='gridData' colspan='13'><b>"+actionType1+"</b></td></tr>");
				if(!notetypedesc.equals(prevnotetype))
					out.println("<tr><td class='gridData' colspan='13' ><b>"+notetypedesc+"</b></td></tr>");
				patdetails = patdetails.replace('|',',');

				value = privilegetype+"~"+rs.getString("accession_num")+"~"+clinicianid+"~"+rs.getString("facility_id")+"~"+rs.getString("note_type_desc")+"~"+requested_by_id+"~"+action_by_type+"~"+curr_patient_id+"~"+curr_episode_id+"~"+note_type;// Added patient id,encounter id, note type for IN071264
				

				if(actionType.equals("Response"))
					value = value + "P";

				/**********/
				valueForNotes = privilegetype+"~"+rs.getString("accession_num")+"~"+clinicianid+"~"+rs.getString("facility_id")+"~"+notetypedesc+"~"+note_type+"~"+curr_patient_id+"~"+curr_episode_id+"~"+rs.getString("EPISODE_TYPE")+"~"+patient_class;
				/*********/

				out.println("<tr><td class='gridData' ><input type='checkbox' name='chk_"+i+"' id='chk_"+i+"' value='"+value+"' onClick =\"callSendBackWindow(this,'"+i+"','"+actionType+"')\" ></td>");
				out.println("<td class='gridData'>"+ subject 	+"</td>");
				out.println("<td class='gridData' > "+com.ehis.util.DateUtils.convertDate(rs.getString("request_date_time"),"DMYHM","en",locale)+"</td>");
				out.println("<td class='gridData' >"+rs.getString("request_by_name")+"</td>");
				if(action_by_type.equals("") || action_by_type.equalsIgnoreCase("P"))
				{
					out.println("<td class='gridData'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.self.label","common_labels")+"</td>");
				}
				else if(action_by_type.equalsIgnoreCase("S"))
				{
					out.println("<td class='gridData' >("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" :"+action_group_desc+")</td>");
				}

				out.println("<td class='gridData'>"+patdetails+"</td>");
				out.println("<td class='gridData'>"+img+"</td>");
				out.println("<td class='gridData'><a class='gridLink'  href=\"javascript:showDetails(escape(document.forms[0].valueForNotes"+i+".value))\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a><input type='hidden' name= 'value"+i+"' value=\""+value+"\"><input type='hidden' name='valueForNotes"+i+"' id='valueForNotes"+i+"' value=\""+valueForNotes+"\"></td></tr>");
				i++;
				
				prevnotetype=notetypedesc;
				preActionType = actionType;
			}
            _bw.write(_wl_block14Bytes, _wl_block14);


			 if(i==0){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(requested_to));
            _bw.write(_wl_block19Bytes, _wl_block19);
	 if(rs != null) rs.close();
         if(pstmt != null) pstmt.close();
        
	}
	catch (Exception e)	
	{
		
        e.printStackTrace() ;
		//out.println(e);
	}
	finally    {
	
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReviewNotes.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reviewed.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Subject.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RequestedAt.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedBy.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Requested.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
}
