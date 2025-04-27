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

public final class __signnotestree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SignNotesTree.jsp", 1709116316528L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\t\tRev.Date\tRev.Name\tDescription\n--------------------------------------------------------------------------------------------------------------------\n?             \t100            \t\t?\t\tcreated\n06/02/2013\tIN037675\t\t\tDinesh T\tIN037675\n27/02/2013\tIN038176\t\tDineshT\t\tPrivilege level setup with sign is not working\t\t\n16/03/2013\tIN038659\t\tDineshT\t\tPrivilege level setup with sign is not working\t\t\n15/09/2015  IN057492\t\tVijayakumar K\t16/09/2015\tDinesh T\tPMG2015-CRF-AAKH-CA-0001\n01-FEB-2015 INT-CA004_CA\tRAJA S\t\t\t\t\t\t\t\t\tScript Error found issue which checking IE11 in Patient Assessment\n05/06/2018\tIN67872\t\t\tDinesh T\t\t05/06/2018\tRamesh G\t\tGHL-CRF-0497.1\t\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="</title>\n\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\n\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/SignNotes.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'content\'>\n<form name=\"SignNotesTree_form\" id=\"SignNotesTree_form\">\n<table  width=\"100%\" class=\'grid\' align=\'center\' id=\'tb1\'>\n \t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</table>\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<!-- Start Added by Sridhar Reddy on 20/01/2009 PMGCRF0359 For Frame Reference in Servlet-->\n<input type=\"hidden\" name=\"optionID\" id=\"optionID\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\t\n<!--End-->\n</form>\n</body>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
	try
	{
		con = ConnectionManager.getConnection(request);
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		//Added By Archana Dhal on 22/01/2010 related to IN18229.
		String requestedbyid = request.getParameter("requested_by_id")==null?"":(String)request.getParameter("requested_by_id");
		if (requestedbyid.equals("ALL")) requestedbyid="";
	//	String	respid		=	(String)	session.getValue("responsibility_id");

		
		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		String 	userid	=	(String)	session.getValue("login_user");
		String	facilityid	=	(String)	session.getValue("facility_id");
		String	respid		=	(String)	session.getValue("responsibility_id");
		
		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String ToDate =request.getParameter("ToDate")==null?"":request.getParameter("ToDate");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		String p_called_func =request.getParameter("p_called_func")==null?"":request.getParameter("p_called_func"); //IN057492

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

		String code = "";
		String desc = "";

		StringBuffer sql =new StringBuffer();
		String gridData = "";
		int i = 1;
		int total = 0;

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
		if(sql.length() > 0) sql.delete(0,sql.length());
			/*
			sql.append(" select note_type,note_type_desc, ");
			sql.append(" sum(grptot)  grptot ");
			sql.append(" from  ( ");

			sql.append(" select a.note_type, a.note_type_desc, count(*) grptot ");
			sql.append(" from ca_encntr_note_audit_log_view a, ca_note_type_for_resp b ");
			sql.append(" where facility_id=? ");
			sql.append(	" and a.action_type = 'SN' and a.ACTION_STATUS ='RQ' ");
			sql.append(" and a.action_by_id = ? and a.note_type=b.note_type ");
			if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");
			sql.append("and b.resp_id =? group by a.note_type,a.note_type_desc ");

			sql.append(" union all ");
			sql.append(" select  c.note_type , b.note_type_desc ");
			sql.append(" , count(*) grptot  from ca_encntr_note c ,ca_note_type b,ca_note_type_for_resp a ");
			sql.append("  where  c.facility_id=?  and c.event_status='1' ");
			sql.append("  and c.added_by_id = ? ");
			if(!requestedbyid.equals(""))
			 sql.append(" and c.performed_by_id = ? ");
				sql.append(" and b.note_type=c.note_type and a.resp_id =? and a.note_type=c.note_type ");
			sql.append(" group by c.note_type ");
			sql.append(" , b.note_type_desc ");
			sql.append(" )  ");
			sql.append(" group by note_type,note_type_desc ");
			*/

			/*sql.append(" select note_type,note_type_desc, ");
			sql.append(" sum(grptot)  grptot ");
			sql.append(" from  ( ");

			sql.append(" select a.note_type, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc, count(*) grptot ");
			sql.append(" from ca_encntr_note_audit_log_view a, ca_note_type_for_resp b ");
			sql.append(" where facility_id=? ");
			sql.append(	" and a.action_type = 'SN' and a.ACTION_STATUS ='RQ' ");
			sql.append(" and a.action_by_id = ? and a.note_type=b.note_type ");
			if(!requestedbyid.equals(""))
			sql.append(" and a.request_by_id = ? ");
			sql.append("and b.resp_id =? group by a.note_type,a.note_type_desc ");

			sql.append(" union all ");
			sql.append(" select  c.note_type , b.note_type_desc ");
			sql.append(" , count(*) grptot  from ca_encntr_note c ,ca_note_type_lang_vw  b,ca_note_type_for_resp a ");
			sql.append("  where  c.facility_id=?  and c.event_status='1' ");
			sql.append("  and c.added_by_id = ? ");
			if(!requestedbyid.equals(""))
			 sql.append(" and c.performed_by_id = ? ");
				sql.append(" and b.note_type=c.note_type and b.language_id = ? and a.resp_id =? and a.note_type=c.note_type ");
			sql.append(" group by c.note_type ");
			sql.append(" , b.note_type_desc ");
			sql.append(" )  ");
			sql.append(" group by note_type,note_type_desc ");

			*/
	/*		fromDate = "";
			ToDate = "";  */
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.facility_id = ? AND a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? ");//IN037675
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.facility_id = ? AND a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675//IN038176
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.FWD_TO_FAC_ID = ? AND a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675//IN038176
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675//IN038176//IN038176
			
			//sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status !=9 AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A' ,a.facility_id)) in (?,'*A')");//IN038659//IN67872
			sql.append("SELECT oa.note_type, ca_get_desc.ca_note_type(oa.note_type,?,1) note_type_desc, SUM (grptot) grptot FROM (SELECT   d.note_type, COUNT (*) grptot FROM ca_encntr_note_audit_log a, CA_ENCNTR_NOTE D,ca_note_type_for_resp b WHERE a.action_type = 'SN' AND a.action_status = 'RQ' AND a.action_by_id = ? and d.facility_id=a.FACILITY_ID and d.ACCESSION_NUM=a.ACCESSION_NUM and D.event_status not in ('9','8') AND b.note_type = d.note_type AND b.resp_id = ? and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A' ,a.facility_id)) in (?,'*A')");//IN038659//IN67872
			//---[IN057492]/Start------
			if(!p_called_func.equals("MC")) 
			{
				//sql.append(" AND d.note_type not in ( SELECT note_type FROM ca_note_type WHERE note_group_id = (SELECT note_group FROM ca_note_group WHERE appl_task_id = 'MC_CONSULT')) ");//IN67872
				sql.append(" AND d.note_type not in ( SELECT note_type FROM ca_note_type WHERE note_group_id = (SELECT note_group FROM ca_note_group a WHERE appl_task_id = 'MC_CONSULT' and a.note_group=note_group_id)) ");//IN67872
			}
			//---[IN057492]/End------
			if(!requestedbyid.equals(""))
		{
			sql.append(" and a.request_by_id = ? ");
		}
			sql.append("  and nvl(ca_view_confidnt_event (d.facility_id,d.ENCOUNTER_ID,d.PATIENT_ID,d.accession_num,'CA',d.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',d.PERFORMED_BY_ID,d.AUTHORIZED_BY_ID,null),'N')='Y' ");  // INT-CA004_CA

			if(!fromDate.equals("")&&(!ToDate.equals("")))
		{
			sql.append( " and a.request_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
		}
		//Added By Archana Dhal on 22/01/2010 related to IN18229.
			else if(!fromDate.equals("") && (ToDate.equals("")))//
		{
			sql.append(" 	and a.request_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
		}
		else if(fromDate.equals("") && !ToDate.equals(""))
		{
			sql.append(" 	and a.request_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
		}
			if(!patientId.equals(""))
			sql.append( "and d.patient_id =? ");

		//---[IN057492]/Start------
		//sql.append("GROUP BY d.note_type UNION ALL SELECT c.note_type, COUNT (*) grptot FROM ca_encntr_note c,ca_note_type_for_resp b //WHERE c.facility_id = ? AND c.event_status = '1' AND c.added_by_id = ? and c.contr_mod_accession_num is null AND //b.note_type = C.note_type AND b.resp_id = ? ");
		
		if(!p_called_func.equals("MC")) 
		{
			sql.append("GROUP BY d.note_type UNION ALL SELECT c.note_type, COUNT (*) grptot FROM ca_encntr_note c,ca_note_type_for_resp b WHERE c.facility_id = ? AND c.event_status = '1' AND c.added_by_id = ? and c.contr_mod_accession_num is null AND b.note_type = C.note_type AND b.resp_id = ? ");
		}
		else 
		{
			//sql.append("GROUP BY d.note_type UNION ALL SELECT c.note_type, COUNT (*) grptot FROM ca_encntr_note c,ca_note_type_for_resp b WHERE c.facility_id = ? AND c.event_status = '1' AND c.added_by_id = ? and c.contr_mod_accession_num is not null and c.note_type IN (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group where appl_task_id = 'MC_CONSULT')) AND b.note_type = C.note_type AND b.resp_id = ? ");//IN67872
			sql.append("GROUP BY d.note_type UNION ALL SELECT c.note_type, COUNT (*) grptot FROM ca_encntr_note c,ca_note_type_for_resp b WHERE c.facility_id = ? AND c.event_status = '1' AND c.added_by_id = ? and c.contr_mod_accession_num is not null and c.note_type IN (select note_type from ca_note_type where note_group_id = (select note_group from ca_note_group a where appl_task_id = 'MC_CONSULT' and a.note_group=note_group_id)) AND b.note_type = C.note_type AND b.resp_id = ? ");//IN67872			
		}
		//---[IN057492]/End------
		sql.append("  and nvl(ca_view_confidnt_event (c.facility_id,c.ENCOUNTER_ID,c.PATIENT_ID,c.accession_num,'CA',c.NOTE_TYPE,'CLNT','"+clinicianid+"','"+respid+"',c.PERFORMED_BY_ID,c.AUTHORIZED_BY_ID,null),'N')='Y' ");   // INT-CA004_CA
		
		if(!fromDate.equals("")&&(!ToDate.equals("")))
		{
			sql.append( " and c.event_date_time between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
		}
		else if(!fromDate.equals("") && (ToDate.equals("")))
		{
			sql.append(" 	and c.event_date_time >= to_date( ?, 'DD/MM/YYYY' ) ");
		}
		else if(fromDate.equals("") && !ToDate.equals(""))
		{
			sql.append(" 	and c.event_date_time <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
		}

			if(!patientId.equals(""))
			sql.append( "and c.patient_id =? ");

			sql.append("GROUP BY c.note_type) oa ");
			sql.append( " GROUP BY oa.note_type order by 2 ");


			
			pstmt=con.prepareStatement(sql.toString());

			//variable binding
			int count=0;

			pstmt.setString(++count,locale);
			//pstmt.setString(++count,facilityid);//IN038176
			pstmt.setString(++count,clinicianid);
			pstmt.setString(++count,respid);
			if(!requestedbyid.equals(""))
		{
			pstmt.setString(++count,requestedbyid);
			//out.println("requestedbyid"+requestedbyid);
		}
			pstmt.setString(++count,facilityid);//IN037675
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

			pstmt.setString(++count,facilityid);
			pstmt.setString(++count,userid);
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
			if(!patientId.equals(""))
				pstmt.setString(++count,patientId);

			
			
			//pstmt.setString(++count,locale);
			/*if(!requestedbyid.equals(""))
				pstmt.setString(++count,requestedbyid);
			pstmt.setString(++count,respid); 
			pstmt.setString(++count,facilityid);
			pstmt.setString(++count,userid);
			if(!requestedbyid.equals(""))
				pstmt.setString(++count,requestedbyid);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,respid); */

			/*Added by Deepa on 2/1/2010 at 11:11 AM for IN018729*/
			/*Passing the date that is NOT converted, to the next page, since the date gets converted again in the next page*/
			rs = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				if(i%2 == 0)
					gridData = "QRYEVEN";
				else
					gridData = "QRYODD";
				code = rs.getString("note_type");
				desc = rs.getString("note_type_desc");
				out.println("<tr><td class='gridData'><a class='gridLink' name='"+i+"' href=\"javascript:filterNShowDetails(this,'"+code+"','"+fromDateParam+"','"+ToDateParam+"','"+requestedbyid+"')\">"+desc+"</a><b>&nbsp;("+rs.getInt("grptot")+")</b></td></tr>");
				i++;
				total =total+rs.getInt("grptot");
			}
			if(i%2 == 0)
					gridData = "QRYEVEN";
			else
					gridData = "QRYODD";
			out.println("<tr><td class='CAGROUP' ><a class='gridLink' name='"+i+"' href=\"javascript:filterNShowDetails(this,'','"+fromDateParam+"','"+ToDateParam+"','"+requestedbyid+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</a>&nbsp;<b>("+total+")</td></tr>");
			/*Added by Deepa on 2/1/2010 at 11:11 AM for IN018729*/
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
	
		 if(rs != null) rs.close();
		 if(pstmt != null) pstmt.close();
	}
	catch (Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally   
	{
        if(con!=null)
			ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
}
