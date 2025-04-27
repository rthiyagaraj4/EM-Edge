package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __signnotesdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SignNotesDetails.jsp", 1734583136593L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\t\tRev.Date\t\tRev.Name\t\t\tDescription\n--------------------------------------------------------------------------------------------------------------------\n?             \t100            \t\t?\t\tcreated\n06/02/2013\tIN037675\t\tDinesh T\tIN037675\n27/02/2013\tIN038176\t\tDineshT\t\tPrivilege level setup with sign is not working\t\t\n16/03/2013\tIN038659\t\tDineshT\t\tPrivilege level setup with sign is not working\t\t\n27/12/2013\tIN046001\t\tRamesh G\tBru-HIMS-CRF-391-42552/11\t\n15/09/2015  IN057492\t\tVijayakumar K\t16/09/2015\t\tDinesh T\t\t\tPMG2015-CRF-AAKH-CA-0001\n25/01/2016\tIN056951\t\tVijayakumar K\t21/08/2015\tDinesh T\tGHL-SCF-959 [IN:056951]\n05/06/2018\tIN67872\t\t\tDinesh T\t\t05/06/2018\tRamesh G\t\tGHL-CRF-0497.1\t\n18/03/2020\tIN071264\t\tNijitha S\t 18/03/2020\t\tRamesh G\t   GHL-CRF-0604\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="</title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\n\n\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/SignNotes.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n\t<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<form name=\"SignNotesDetails_form\" id=\"SignNotesDetails_form\" action=\"../../servlet/eCA.SignNotesServlet\" method=\"post\" target=messageFrame>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'content\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table  width=\'100%\' border=\'0\' align=\'center\'  >\n\t\t<tr><td CLASS=\'BODYCOLORFILLED\' >&nbsp;</td>\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t\n\t\t\t<td class=\'LABEL\'  width=\'8%\'><a class=\'gridLink\'  href=\"../../eCA/jsp/SignNotesDetails.jsp?lower_limit=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&upper_limit=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&note_type_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&requested_by_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&patientId=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&fromDate=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&ToDate=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td>\n\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<td class=\'LABEL\' align=\'center\' width=\'8%\'><a class=\'gridLink\' href=\"../../eCA/jsp/SignNotesDetails.jsp?lower_limit=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</tr></table>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n<table  width=\"100%\" class=\'grid\'>\n\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\"8%\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'width=\"8%\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\"40%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'width=\"15%\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'>&nbsp;</td>\n\t<td class=\'COLUMNHEADERCENTER\'></td>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<script>if(parent.SignNotesCriteriaFrame.document.getElementById(\"search\")!=null)\n\t\t\t\tparent.SignNotesCriteriaFrame.document.getElementById(\"search\").disabled=false;</script>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</table>\n</body>\n<input type=\"hidden\" name=\"noofrec\" id=\"noofrec\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\"hidden\" name=\"final_values\" id=\"final_values\" value=\"\">\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<!-- Start Added by Sridhar Reddy on 20/01/2009 PMGCRF0359 For Frame Reference in Servlet-->\n<input type=\"hidden\" name=\"optionID\" id=\"optionID\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\t\n<!--End-->\n</form>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
	ResultSet rs = null;
	//ResultSet rs1 = null;
	PreparedStatement	pstmt		=	null;
	Boolean fag=true;
	
	try
	{
		con = ConnectionManager.getConnection(request);
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");

		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		String	respid		=	(String)	session.getValue("responsibility_id");
		String	facilityid	=	(String)	session.getValue("facility_id");
		String 	userid	=	(String)	session.getValue("login_user");
		String notetypecode = request.getParameter("note_type_code")==null?"":request.getParameter("note_type_code");
		String p_called_func =request.getParameter("p_called_func")==null?"":request.getParameter("p_called_func"); //IN057492
		
		String requestedbyid = request.getParameter("requested_by_id")==null?"":request.getParameter("requested_by_id");
		if (requestedbyid.equals("ALL")) requestedbyid="";
				
		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String ToDate =request.getParameter("ToDate")==null?"":request.getParameter("ToDate");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");

	/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/
	/*to pass the date that is NOT converted, to the next page*/
		String fromDateParam = fromDate;
		String ToDateParam = ToDate;
	/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/	

   
		//Start Added by Sridhar Reddy on 20/01/2009 PMGCRF0359 For Frame Reference in Servlet
		String option_id =request.getParameter("option_id")==null?"":request.getParameter("option_id");
		//End
		
		if (ToDate.equals(""))
			ToDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

		/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/
		/*converted the date to english, that has to be passed to the query*/

		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
	    ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

		/*Added by Deepa on 2/1/2010 at 10:52 AM for IN018729*/

		/*out.println("<script>alert('="+fromDate+"=');</script>");
		out.println("<script>alert('="+ToDate+"=');</script>");*/
		
		//String code = "";
		//String desc = "";
		StringBuffer sql = new StringBuffer();
		String classValue = "";
		String prevnotetype = "";
		String value = "";
		String valueForNotes = "";
		StringBuffer list = new StringBuffer();
		String curr_patient_id = "";
		String curr_episode_id = "";
		String patient_class = "";
		String img = "";
		String doc_linked = "";
		String autosavetmpdtls ="";//IN071264
		StringBuffer autosavenotestemp = new StringBuffer();//IN071264
		int i = 0;
		//shaiju>> 
		int		rowCnt					=	0,		maxRecordsDisp		=	10;
		int		startIndex				=	0,		endIndex			=	0;
		int		totalRecordCount		=	0;
		String	lower_limit				=	"";	
		String	upper_limit				=	"";
		lower_limit		=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
		upper_limit		=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
		startIndex		=	Integer.parseInt(lower_limit);
		endIndex		=	Integer.parseInt(upper_limit);
		if(sql.length() > 0) sql.delete(0,sql.length());
			/*sql.append( " select a.note_type,a.note_type_desc, a.facility_id, a.accession_num ");
			sql.append(", to_char(a.request_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append( " ,a.request_by_id,a.request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id) pline");
			sql.append( " ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id, a.request_date_time dummydate, a.ACTION_COMMENT subject,decode(a.PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE ");
			sql.append( " from ca_encntr_note_audit_log_view a ");
			sql.append( " ,ca_note_type_for_resp b ");
			sql.append(" where a.facility_id=? ");
			sql.append( " and a.action_type = 'SN' ");
			sql.append( " and a.action_by_id = ? ");
			sql.append(" and b.note_type = a.note_type ");
			sql.append( " and b.resp_id = ? ");
			sql.append( " and a.ACTION_STATUS ='RQ' ");

			if(!notetypecode.equals(""))
				sql.append( " and a.note_type =? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
	 		sql.append("  union all ");
			sql.append(" select a.note_type,c.note_type_desc, a.facility_id, a.accession_num ");
			sql.append( ", to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append(" ,to_char(null) request_by_id,'Self' request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id) pline");
			sql.append(" ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate ,null subject,decode(a.PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE ");
			sql.append( " from ca_encntr_note a ");
			sql.append(" ,ca_note_type_for_resp b ");
			sql.append( " ,ca_note_type c ");
			sql.append( " where a.facility_id=? ");
			sql.append( " and a.added_by_id = ? ");
			sql.append(" and b.note_type = a.note_type ");
			sql.append(" and c.note_type = a.note_type ");
			sql.append(" and b.resp_id = ? ");
			sql.append( " and a.event_status='1' ");
			if(!notetypecode.equals(""))
				sql.append(" and a.note_type =? ");*/

		/*	sql.append( " select a.note_type,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1')note_type_desc, a.facility_id, a.accession_num ");
			sql.append(", to_char(a.request_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append( " ,a.request_by_id,AM_GET_DESC.AM_PRACTITIONER(a.request_by_id,?,'1')request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id,?) pline");
			sql.append( " ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id, a.request_date_time dummydate, a.ACTION_COMMENT subject,decode(a.PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE ");
			sql.append( " from ca_encntr_note_audit_log_view a ");
			sql.append( " ,ca_note_type_for_resp b ");
			sql.append(" where a.facility_id=? ");
			sql.append( " and a.action_type = 'SN' ");
			sql.append( " and a.action_by_id = ? ");
			sql.append(" and b.note_type = a.note_type ");
			sql.append( " and b.resp_id = ? ");
			sql.append( " and a.ACTION_STATUS ='RQ' ");

			if(!notetypecode.equals(""))
				sql.append( " and a.note_type =? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");

			sql.append("  union all ");
			sql.append(" select a.note_type,c.note_type_desc, a.facility_id, a.accession_num ");
			sql.append( ", to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') request_date_time ");
			sql.append(" ,to_char(null) request_by_id,'Self' request_by_name ");
			sql.append( " ,get_patient.get_line_detail(a.facility_id,a.encounter_id,?) pline");
			sql.append(" ,b.privilege_type,a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate ,null subject,decode(a.PATIENT_CLASS,'OP','O','EM','O','I') EPISODE_TYPE ");
			sql.append( " from ca_encntr_note a ");
			sql.append(" ,ca_note_type_for_resp b ");
			sql.append( " ,ca_note_type_lang_vw c ");
			sql.append( " where a.facility_id=? ");
			sql.append( " and a.added_by_id = ? ");
			sql.append(" and b.note_type = a.note_type ");
			sql.append(" and c.note_type = a.note_type ");
			sql.append(" and b.resp_id = ? ");
			sql.append( " and a.event_status='1' ");
			sql.append( " and c.language_id = ? ");
	
		if(!notetypecode.equals(""))
			  sql.append(" and a.note_type =? "); */

		/*In Below query this condition is appended  decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?) as  for new born cases the application shows blank for patient details.
		Added by Archana on 4/16/2010 at 3:07 PM for IN020707*/


		//sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5')  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE a.facility_id = ? AND a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status != 9 ");//IN038176
		//sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5')  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE a.FWD_TO_FAC_ID = ? AND  a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status != 9 ");//IN038176
		//IN056951 starts this fix for privilege type
		//sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5')  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE /*a.FWD_TO_FAC_ID = ? AND */ a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status != 9 ");//IN038176
		//sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5' and ia.resp_id = ? )  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE /*a.FWD_TO_FAC_ID = ? AND */ a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status != 9 ");//IN038176//IN67872
		//IN056951 ends
		sql.append("SELECT C.note_type,ca_get_desc.ca_note_type (C.note_type, ?, '1') note_type_desc,nvl2(c.EXT_IMAGE_APPL_ID,'Y','N') doc_linked,a.facility_id, a.accession_num,TO_CHAR (a.request_date_time, 'dd/mm/yyyy hh24:mi') request_date_time,a.request_by_id, am_get_desc.am_practitioner (a.request_by_id, ?, '1' ) request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?),get_patient.get_line_detail (C.facility_id, C.encounter_id, ?)) pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = c.note_type and privilege_type!='5' and ia.resp_id = ? )  privilege_type, C.patient_id patient_id, C.encounter_id encounter_id, a.request_date_time dummydate, a.action_comment subject, DECODE (C.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,C.patient_class patient_class FROM ca_encntr_note_audit_log a, ca_encntr_note c, ca_note_type_for_resp b WHERE /*a.FWD_TO_FAC_ID = ? AND */ a.action_type = 'SN' AND a.action_by_id = ? AND C.ACCESSION_NUM=A.ACCESSION_NUM AND b.note_type = C.note_type AND b.resp_id = ? AND a.action_status = 'RQ' and c.event_status not in ('9','8') ");//IN038176//IN67872

		//---[IN057492]/Start------
		if(!p_called_func.equals("MC")) 
		{
			//sql.append(" and c.note_type not in ( SELECT note_type FROM ca_note_type WHERE note_group_id = (SELECT note_group FROM ca_note_group WHERE appl_task_id = 'MC_CONSULT')) ");//IN67872
			sql.append(" and c.note_type not in ( SELECT note_type FROM ca_note_type WHERE note_group_id = (SELECT note_group FROM ca_note_group a WHERE appl_task_id = 'MC_CONSULT' and  a.note_group=note_group_id)) ");//IN67872
		}
		//---[IN057492]/End------
		
		//IN046001 Start.
		sql.append("  and nvl(ca_view_confidnt_event (c.facility_id,c.ENCOUNTER_ID,c.PATIENT_ID,c.accession_num,'CA',c.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',c.PERFORMED_BY_ID,c.AUTHORIZED_BY_ID,null),'N')='Y' ");
		//IN046001 End.
				
		if(!notetypecode.equals(""))
			sql.append( " and c.note_type =? ");
		if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");

		if(!fromDate.equals("")&&(!ToDate.equals("")))
		{
			sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
		}
		//Added By Archana Dhal on 22/01/2010 related to IN18229.
			else if(!fromDate.equals("") && (ToDate.equals("")))
		{
			sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
		}
		else if(fromDate.equals("") && !ToDate.equals(""))
		{
			sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
		}
		if(!patientId.equals(""))
			sql.append( " and c.patient_id =? ");
		
		//sql.append(" and nvl(a.FORWARD_TO_FAC_ID,'*') in (?,'*') ");//IN037675
		//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type),'A', '*', a.facility_id)) in (?,'*') ");//IN037675//IN038176
		sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type),'A', '*A','P','*A', a.facility_id)) in (?,'*A') ");//IN038659
		/*In Below query this condition is appended  decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(c.patient_id,?) as  for new born cases the application shows blank for patient details.
		Added by Archana on 4/16/2010 at 3:07 PM for IN020707*/

		//--[IN057492]/Start---
		//sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5')  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS NULL");
		if(!p_called_func.equals("MC")) 
		{
		//IN056951 starts
		//sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5')  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS NULL");
		sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5' and ia.resp_id = ? )  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS NULL");
		//IN056951 ends
		}
		else 
		{
			//IN056951 starts
			//sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select max(privilege_type) from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5')  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS not NULL and c.note_type in (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group where appl_task_id = 'MC_CONSULT'))" );
			//sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5' and ia.resp_id = ?)  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS not NULL and c.note_type in (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group where appl_task_id = 'MC_CONSULT'))" );//IN67872
			//IN056951 ends
			sql.append( " UNION ALL SELECT a.note_type, c.note_type_desc,nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, a.facility_id, a.accession_num,TO_CHAR (a.event_date_time, 'dd/mm/yyyy hh24:mi') request_date_time, TO_CHAR (NULL) request_by_id, 'Self' request_by_name, decode(PATIENT_CLASS,'XT',get_patient.get_line_detail(a.patient_id,?),get_patient.get_line_detail (a.facility_id, a.encounter_id, ?))pline, (select privilege_type from ca_note_type_for_resp  ia where ia.resp_id in (select resp_id from sm_resp_for_user where appl_user_id=? ) and ia.note_type = a.note_type and privilege_type!='5' and ia.resp_id = ?)  privilege_type, a.patient_id patient_id, a.encounter_id encounter_id, a.event_date_time dummydate, NULL subject, DECODE (a.patient_class, 'OP', 'O', 'EM', 'O', 'I') episode_type,a.patient_class patient_class FROM ca_encntr_note a, ca_note_type_for_resp b, ca_note_type_lang_vw c WHERE a.facility_id = ? AND a.added_by_id = ? AND b.note_type = a.note_type  AND c.note_type = a.note_type AND b.resp_id = ? AND a.event_status = '1' AND c.language_id = ? and contr_mod_accession_num IS not NULL and c.note_type in (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group a where appl_task_id = 'MC_CONSULT' and  a.note_group=note_group_id))" );//IN67872
		}
		//--[IN057492]/End---
		//IN046001 Start.
		sql.append("  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y' ");
		//IN046001 End.
				
		if(!notetypecode.equals(""))
			  sql.append(" and a.note_type =? "); 
		if(!fromDate.equals("")&&(!ToDate.equals("")))
		{
			sql.append( " and a.event_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
		}
		else if(!fromDate.equals("") && (ToDate.equals("")))
		{
			sql.append(" 	and a.event_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
		}
		else if(fromDate.equals("") && !ToDate.equals(""))
		{
			sql.append(" 	and a.event_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
		}
		if(!patientId.equals(""))
			sql.append( " and a.patient_id =? ");

		sql.append( " ORDER BY 2,dummydate DESC "); 


			pstmt = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//****parameter binding
			int count=0;
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			//Added by Archana on 4/16/2010 at 3:07 PM for IN020707
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,userid);//app_user
			pstmt.setString(++count,respid);//IN056951
			//pstmt.setString(++count,facilityid);//IN038176
			pstmt.setString(++count,clinicianid);
			pstmt.setString(++count,respid);
			if(!notetypecode.equals(""))
				pstmt.setString(++count,notetypecode);
			if(!requestedbyid.equals(""))
				pstmt.setString(++count,requestedbyid);
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
           	//Added by Archana on 4/16/2010 at 3:07 PM for IN020707.
			pstmt.setString(++count,(String)session.getValue("facility_id"));//IN037675
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,userid);//app_user
			pstmt.setString(++count,respid);//IN056951
			pstmt.setString(++count,facilityid);
			pstmt.setString(++count,userid);
			pstmt.setString(++count,respid);
			pstmt.setString(++count,locale);

			if(!notetypecode.equals(""))
				pstmt.setString(++count,notetypecode);
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

			//***********
			rs = pstmt.executeQuery();
			//rs.absolute(-1);
			rs.last();
			totalRecordCount	=	rs.getRow();
			//rs.absolute(1);
			rs.beforeFirst();
	if( totalRecordCount>maxRecordsDisp)
		{

		//shaiju <<
	

            _bw.write(_wl_block9Bytes, _wl_block9);

		if(startIndex>maxRecordsDisp)
		{  
	/*Added by Deepa on 2/1/2010 at 11:11 AM for IN018729*/
	/*Passing the date that is NOT converted, to the next page, since the date gets converted again in the next page*/
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((startIndex-maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex-maxRecordsDisp)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(notetypecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(requestedbyid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromDateParam));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ToDateParam));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
		if(totalRecordCount>endIndex)
		{
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((startIndex+maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex+maxRecordsDisp)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(notetypecode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(requestedbyid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromDateParam));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ToDateParam));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		/*Added by Deepa on 2/1/2010 at 11:11 AM for IN018729*/
	
            _bw.write(_wl_block21Bytes, _wl_block21);

		}
	
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

			if(startIndex>1)
			rs.absolute((startIndex-1));
			rowCnt=0;
			String	note_type = "";
			while(rs != null && rs.next())
			{	
				rowCnt++;
				fag= false;
				if(i%2 == 0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";
				String patdetails = rs.getString("pline")==null?"":rs.getString("pline");
				String notetypedesc = rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
				
				doc_linked						=			rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");

				String privilegetype = rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
				note_type	=	rs.getString("note_type")==null?"":rs.getString("note_type");

				img = "";
				if(doc_linked.equals("Y"))
				img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+rs.getString("accession_num")+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
				else
				img = "&nbsp;";

				curr_patient_id		=	rs.getString("patient_id")==null?"":rs.getString("patient_id");
				patient_class		=	rs.getString("patient_class")==null?"XT":rs.getString("patient_class");
				curr_episode_id 	=	rs.getString("encounter_id");
				String	subject	=	(rs.getString("subject")==null)?"&nbsp;":rs.getString("subject");
				String requestbyname = (rs.getString("request_by_name")==null)?"&nbsp;":rs.getString("request_by_name");
				list = new StringBuffer();
				
				if(requestbyname.equals("Self") )
					requestbyname = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.self.label","common_labels");
				if(privilegetype.equals("2") )
				{
					// FOR LOOK UP

					list.append("<input type='text' name='forward_to_desc_"+i+"' id='forward_to_desc_"+i+"' value='' size='15' maxlength='20'onBlur='getForwardTo(this,"+i+",\""+note_type+"\");'><input type='hidden'  name='forward_to_"+i+"' id='forward_to_"+i+"' value=''><input type='Button' name='forwardToButton' id='forwardToButton' class='button' value='?' onClick='forwardTo("+i+",\""+note_type+"\");'>");


					//
					
					
					/*list.append("<select name='forward_to_"+i+"' id='forward_to_"+i+"'><option value=''>&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"  ---&nbsp;");
					
					String clincsql = " Select practitioner_id clinician_id, practitioner_name clinician_short_name from am_practitioner_lang_VW where language_id = ? and practitioner_id in ( select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = ? and b.privilege_type in ('3','4') and a.appl_user_id = c.appl_user_id and c.resp_id = b.resp_id )  order by 2 ";

					//if (pstmt!=null) pstmt.close();

					pstmt	=	con.prepareStatement(clincsql);
					pstmt.setString (   1,  locale);
					pstmt.setString	(	2,	note_type	);
					rs1		=	pstmt.executeQuery();
					while(rs1.next())
					{
						list.append("<option value='"+rs1.getString("clinician_id")+"'>"+rs1.getString("clinician_short_name")+"");
					}
					list.append("</select>");
					
					if(rs1!=null)
						rs1.close();
					if(pstmt != null) pstmt.close(); */
				}
				else
				{
					list = new StringBuffer();
					list.append("&nbsp;<input type='hidden' name='forward_to_"+i+"' id='forward_to_"+i+"' value=''>");
				}
				if(!notetypedesc.equals(prevnotetype))
					out.println("<tr><td class='gridData' colspan='7'>"+notetypedesc+"</td></tr>");
				patdetails = patdetails.replace('|',',');

				value = privilegetype+"~"+rs.getString("accession_num")+"~"+clinicianid+"~"+rs.getString("facility_id")+"~"+rs.getString("note_type_desc")+"~"+curr_patient_id+"~"+curr_episode_id+"~"+note_type;//Added patient id, encounter id and note_type for IN071264

				/**********/
				valueForNotes = privilegetype+"~"+rs.getString("accession_num")+"~"+clinicianid+"~"+rs.getString("facility_id")+"~"+notetypedesc+"~"+note_type+"~"+curr_patient_id+"~"+curr_episode_id+"~"+rs.getString("EPISODE_TYPE")+"~"+patient_class;

				/*********/
				out.println("<tr height='1'><td class='gridData' ><input type='checkbox' name='chk_"+i+"' id='chk_"+i+"' value='"+value+"'></td>");
				out.println("<td class='gridData' >"+ subject 	+"</td>");
				out.println("<td class='gridData' >"+com.ehis.util.DateUtils.convertDate(rs.getString("request_date_time"),"DMYHM","en",locale)+"</td>");
				out.println("<td class='gridData' >"+requestbyname+"</td>");
				out.println("<td class='gridData'>"+patdetails+"</td>");
				out.println("<td class='gridData'>"+list.toString()+"</td>");
				out.println("<td class='gridData'>"+img+"</td>");
				out.println("<td class='gridData'><a class='gridLink' href=\"javascript:showDetails(escape(document.forms[0].valueForNotes"+i+".value))\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a><input type='hidden' name='value"+i+"' id='value"+i+"' value=\""+value+"\"></td><input type='hidden' name='valueForNotes"+i+"' id='valueForNotes"+i+"' value=\""+valueForNotes+"\"></td></tr>");
				i++;
				prevnotetype=notetypedesc;
				
				if(rowCnt>=maxRecordsDisp)   break;
			}
            _bw.write(_wl_block28Bytes, _wl_block28);

			if(fag)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
	
		if(rs!=null) rs.close();
		//if(rs1!=null) rs1.close();
		if(pstmt != null) pstmt.close();
		
	}
	catch (Exception e)
	{
		out.println("Error"+e);
		e.printStackTrace();
	}
	finally
	{
		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SignNotes.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sign.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Subject.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RequestedAt.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedBy.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ForwardTo.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
