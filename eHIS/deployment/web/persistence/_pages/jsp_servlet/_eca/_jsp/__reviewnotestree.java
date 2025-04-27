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

public final class __reviewnotestree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ReviewNotesTree.jsp", 1709116265339L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       \tEdit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             \t100            \t?           created\n29/06/2012\t  \tIN030468\t\tDinesh T\t BRUHIMS CRF.\n16/07/2012\t  \tIN033857\t\tDinesh T\t BRUHIMS CRF.\n06/02/2013\t\tIN037675\t\tDinesh T\tIN037675\n16/03/2013\t\tIN038659\t\tDineshT\t\tPrivilege level setup with sign is not working\t\t\n05/11/2013\t\tIN044763\t\tKarthi L\tSystem Displaying Wrong count of Pending review notes, while login practitioner with other facility\n------------------------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History     Name        \tRev.Date\t\tRev.Name\t\tDescription\n------------------------------------------------------------------------------------------------------------------------------\n22/04/2014\t\tIN047254\t\tKarthi L\t\t22/04/2014\t\tRamesh\t\t\tIssue as regards to forwarding these confidentiality notes.\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIn the FD document it was stated that these notes should not be forwarded to any one who does not have access.\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/ReviewNotes.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"ReviewNotesTree_form\" id=\"ReviewNotesTree_form\">\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'content\'>\n<table  border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\' id=\'tb1\'>\n<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</table>\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n</body>\n</form>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		con = ConnectionManager.getConnection(request);

		String requestedbyid		= request.getParameter("requested_by_id")==null?"":request.getParameter("requested_by_id");
		
		String requested_to = "";
		
		requested_to = request.getParameter("requested_to");
		if(requested_to==null)
			requested_to = "P";
		
		String view					= request.getParameter("view")==null?"ALL":request.getParameter("view");

		String 	clinicianid			= (String)	session.getValue("ca_practitioner_id");
		String	respid				= (String)	session.getValue("responsibility_id");
		String	faciltyid				= (String) session.getValue("facility_id");

		String code = "";
		String desc = "";
		StringBuffer sql = new StringBuffer();
		String classValue = "";

		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String ToDate =request.getParameter("ToDate")==null?"":request.getParameter("ToDate");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		String reqFacility = request.getParameter("reqFacility")==null?"":request.getParameter("reqFacility");//IN030468
		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
		ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY",locale,"en");

		int i = 1;
		int total = 0;


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
		
	
		if(requested_to.equals("P"))
		{
			sql.append("select b.note_type, e.note_type_desc, count(*) grptot from ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b, ca_note_type_lang_vw e  WHERE a.action_status = 'RQ' " );
			if(view.equals("ALL"))
			{
				sql.append(" and a.action_type in ('RV','RS') ");
			}
			else if(view.equals("RS"))
			{
				sql.append(" and a.action_type = 'RS' ");
			}
			else if(view.equals("RQ"))
			{
				sql.append(" and a.action_type in ('RV','FS') ");
			}
			if (!patientId.equals(""))
				sql.append(" and c.patient_id=? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
			sql.append(" AND a.action_by_id = ?  AND c.event_status IN ('3', '4', '5') AND c.accession_num = a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? AND E.LANGUAGE_ID=? and e.note_type=b.note_type AND a.request_date_time BETWEEN to_date(?,'dd/mm/yyyy') AND to_date(?,'dd/mm/yyyy')+.9999  ");//IN030468 
			//IN030468 starts
			if(!reqFacility.equals(""))
				sql.append(" and a.facility_id = ? ");
			//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675
			sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			/*else //Chowminya
			{
				sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
			}//IN030468 ends*///IN033857
			sql.append(" and 'Y' = ca_view_confidnt_event (c.facility_id, c.encounter_id, c.patient_id, c.accession_num, 'CA', c.note_type, 'CLNT', ?, ?, c.PERFORMED_BY_ID, c.AUTHORIZED_BY_ID, NULL)"); // added for IN047254
			sql.append(" GROUP BY b.note_type, e.note_type_desc");
		}
		else if(requested_to.equals("S"))
		{
			sql.append(" select b.note_type, e.note_type_desc, count(*) grptot from ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b, ca_note_type_lang_vw e WHERE a.action_status = 'RQ' " );
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
			if (!patientId.equals(""))
				sql.append(" and c.patient_id=? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
			sql.append("AND  a.action_by_group_code = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id=?) AND c.event_status IN ('3', '4', '5') AND c.accession_num = a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? AND E.LANGUAGE_ID=? and e.note_type=b.note_type AND a.request_date_time BETWEEN to_date(?,'dd/mm/yyyy') AND to_date(?,'dd/mm/yyyy')+.9999 ");//IN030468 
			//IN030468 starts
			if(!reqFacility.equals(""))
				sql.append(" and a.facility_id = ? ");			
			//sql.append("and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*')");//IN037675
			sql.append("and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')");//IN038659
			/*else //unable to see forwarded notes in other facility
			{
				sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
			}//IN030468 ends//IN033857
			*/
			sql.append(" and 'Y' = ca_view_confidnt_event (c.facility_id, c.encounter_id, c.patient_id, c.accession_num, 'CA', c.note_type, 'CLNT', ?, ?, c.PERFORMED_BY_ID, c.AUTHORIZED_BY_ID, NULL)"); // added for IN047254
			sql.append(" GROUP BY b.note_type, e.note_type_desc " );
		}
		else
		{
			sql.append(" Select note_type, note_type_desc, sum(grptot) grptot from ( ");
			sql.append( "select b.note_type, e.note_type_desc, count(*) grptot from ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b, ca_note_type_lang_vw e  WHERE a.action_status = 'RQ' " );
			if(view.equals("ALL"))
			{
				sql.append(" and a.action_type in ('RV','RS') ");
			}
			else if(view.equals("RS"))
			{
				sql.append(" and a.action_type = 'RS' ");
			}
			else if(view.equals("RQ"))
			{
				sql.append(" and a.action_type in ('RV','FS') ");
			}
			if (!patientId.equals(""))
				sql.append(" and c.patient_id=? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
			sql.append(" AND a.action_by_id = ? AND c.event_status IN ('3', '4', '5') AND c.accession_num = a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? AND E.LANGUAGE_ID=? and e.note_type=b.note_type AND a.request_date_time BETWEEN to_date(?,'dd/mm/yyyy') AND to_date(?,'dd/mm/yyyy')+.9999 ");
			//IN030468 starts
			if(!reqFacility.equals(""))
				sql.append(" and a.facility_id = ? ");
			//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*') ");//IN037675
			//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')  ");//IN038659 // commented for IN047254 
			sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_pract_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A')  AND 'Y' = ca_view_confidnt_event (a.facility_id, c.encounter_id, c.patient_id, a.accession_num,'CA', c.note_type,'CLNT',?,?, c.PERFORMED_BY_ID, c.AUTHORIZED_BY_ID, NULL) ");// added for IN047254			
			/*else //Chowminya
			{
				sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
			}//IN030468 ends//IN033857
			*/
			sql.append(" GROUP BY b.note_type, e.note_type_desc " );
			sql.append(" union all ");
			sql.append( " select b.note_type, e.note_type_desc, count(*) grptot from ca_encntr_note_audit_log a, ca_encntr_note c,ca_note_type_for_resp b, ca_note_type_lang_vw e WHERE a.action_status = 'RQ' " );
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
			if (!patientId.equals(""))
				sql.append(" and c.patient_id=? ");
			if(!requestedbyid.equals(""))
				sql.append(" and a.request_by_id = ? ");
			sql.append("AND  a.action_by_group_code = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id=?) AND c.event_status IN ('3', '4', '5') AND c.accession_num = a.accession_num AND b.note_type = c.note_type AND b.resp_id = ? AND E.LANGUAGE_ID=? and e.note_type=b.note_type  AND a.request_date_time BETWEEN to_date(?,'dd/mm/yyyy') AND to_date(?,'dd/mm/yyyy')+.9999 ");//IN030468
			//IN030468 starts
			if(!reqFacility.equals(""))
			sql.append(" and a.facility_id = ? ");
			//sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*', a.facility_id)) in (?,'*') ");//IN037675
			sql.append(" and NVL (a.fwd_to_fac_id,DECODE ((SELECT fwd_splty_ind FROM ca_note_type WHERE note_type = b.note_type), 'A', '*A','P','*A', a.facility_id)) in (?,'*A') ");//IN038659
			/*else //Chowminya
			{
				sql.append("and a.facility_id IN (SELECT b.facility_id facility_id FROM sm_facility_param a, sm_facility_for_user b WHERE a.facility_id = b.facility_id AND appl_user_id = ?)");
			}
			//IN030468 ends
			*///IN033857
			sql.append(" AND 'Y' = ca_view_confidnt_event (a.facility_id, c.encounter_id, c.patient_id, a.accession_num,'CA', c.note_type,'CLNT',?,?, c.PERFORMED_BY_ID, c.AUTHORIZED_BY_ID, NULL)"); // added for IN047254
			sql.append(" GROUP BY b.note_type, e.note_type_desc ");
			sql.append(" ) GROUP BY note_type, note_type_desc  ");
		}

		sql.append(" ORDER BY 2 ");
		

		int position=0;
		pstmt=con.prepareStatement(sql.toString());			
		
		if (!patientId.equals(""))
			pstmt.setString(++position,patientId);	
		if(!requestedbyid.equals(""))
					pstmt.setString(++position,requestedbyid);	
		pstmt.setString(++position,clinicianid);	
		//pstmt.setString(++position,faciltyid);	
		pstmt.setString(++position,respid);
		pstmt.setString(++position,locale);
		pstmt.setString(++position,fromDate);
		pstmt.setString(++position,ToDate);
		//IN030468 starts
		if(!requested_to.equals("A"))
		{
			if(!reqFacility.equals(""))
				pstmt.setString(++position,reqFacility);
			/*else //Chowminya
			{
				pstmt.setString(++position,clinicianid);
			}	*///IN033857
			pstmt.setString(++position,faciltyid);//added for IN044763
			pstmt.setString(++position,clinicianid); // added for IN047254
			pstmt.setString(++position,respid); // added for IN047254
		}//IN030468 ends
		//pstmt.setString(++position,faciltyid);//IN037675 Commented for IN044763
		if(requested_to.equals("A"))
		{
			//IN030468 starts
			if(!reqFacility.equals(""))
				pstmt.setString(++position,reqFacility);
		/*	else //Chowminya
			{
				pstmt.setString(++position,clinicianid);
			}//IN030468 ends*///IN033857
			
			pstmt.setString(++position,faciltyid);//added for IN044763
			pstmt.setString(++position,clinicianid); // added for IN047254
			pstmt.setString(++position,respid); // added for IN047254
			if (!patientId.equals(""))
				pstmt.setString(++position,patientId);
			if(!requestedbyid.equals(""))
				pstmt.setString(++position,requestedbyid);				
			pstmt.setString(++position,clinicianid);	
			//pstmt.setString(++position,faciltyid);	
			pstmt.setString(++position,respid);
			pstmt.setString(++position,locale );
			pstmt.setString(++position,fromDate);
			pstmt.setString(++position,ToDate);					
			//IN030468 starts
			if(!reqFacility.equals(""))
			pstmt.setString(++position,reqFacility);
			pstmt.setString(++position,faciltyid);//IN037675
			
			pstmt.setString(++position,clinicianid); // added for IN047254
			pstmt.setString(++position,respid); // added for IN047254
			
			/*else //Chowminya
			{
				pstmt.setString(++position,clinicianid);
			}//IN030468 ends	
			*///IN033857
		
		}
			
		
		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY","en",locale);
		ToDate = com.ehis.util.DateUtils.convertDate(ToDate,"DMY","en",locale);
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			if(i%2 == 0)
				classValue = "QRYEVEN";
			else
				classValue = "QRYODD";
			code = rs.getString("note_type");
			desc = rs.getString("note_type_desc");
							
			i++;
			total =total+rs.getInt("grptot");
			out.println("<tr><td class='"+classValue+"'><a name='"+i+"' href=\"javascript:filterNShowDetails('"+code+"','"+requestedbyid+"','"+requested_to+"','"+fromDate+"','"+ToDate+"','"+reqFacility+"','"+total+"')\"><font size=1>"+desc+"</a><b>&nbsp;("+rs.getInt("grptot")+")</b></font></td></tr>");//IN033857
		}
		if(i%2 == 0)
				classValue = "QRYEVEN";
		else
				classValue = "QRYODD";
		out.println("<tr><td class='CAGROUP' ><a name='"+i+"' href=\"javascript:filterNShowDetails('','"+requestedbyid+"','"+requested_to+"','"+fromDate+"','"+ToDate+"','"+reqFacility+"','"+total+"')\"><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"</a>&nbsp;<b>("+total+")</font></td></tr>");//IN033857
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block12Bytes, _wl_block12);
	
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

            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoteTypes.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
