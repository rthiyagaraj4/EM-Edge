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
import java.util.*;
import com.ehis.util.*;

public final class __penddiscsummdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PendDiscSummDetails.jsp", 1709116038763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- \n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History      \tName        \t\tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n20/01/2016\t  \tIN057193\t\t\tKarthi L\t\t\t\t\t\t\t\t\t\t\tFlag For Discharge Summary Not Done\t\t\t\t\t\t\t\t\n29/01/2016\t\tIN059021\t\t\tKarthi L\t\t\t\t\t\t\t\t\t\t\tRecord does not display when the Discharge Summary Note is marked as Error\n17/03/2016\t\tIN059603\t\t\tKarthi L\t\t\t\t\t\t\t\t\t\t\tWhen Discharge Summary is captured, system removes both records though discharge summary recorded for only one discharged encounter\n12/07/2017\t\tIN061885\t\t\tRaja S\t\t\t\t13/07/2017\t\tRamesh G\t\tML-MMOH-CRF-0537\n05/06/2018\tIN67872\t\t\tDinesh T\t\t05/06/2018\tRamesh G\t\tGHL-CRF-0497.1\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n\t\n\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/PendDiscSummNotes.js\'></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\"PendDiscSummDtl_form\" id=\"PendDiscSummDtl_form\" method=\"post\" target=messageFrame>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'content\'>\n<table  border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'>Discharge Practitioner</td>\n\t<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" <!-- Added If Condition for IN061885 -->\n\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<Script language=javascript>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</table>\n</body>\n<input type=\"hidden\" name=\"noofrec\" id=\"noofrec\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name=\"tempAccession_Num\" id=\"tempAccession_Num\" value=\"\">\n\n\n\n\n</form>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try
	{
		con = ConnectionManager.getConnection(request);

		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");		
		String 	clinicianId	=	(String)	session.getValue("ca_practitioner_id");
		//String	respId		=	(String)	session.getValue("responsibility_id");
		String	facilityId	=	(String)	session.getValue("facility_id");
		String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		String fromDate =request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
		String toDate =request.getParameter("toDate")==null?"":request.getParameter("toDate");
		fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
		toDate = com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
		String viewBy =request.getParameter("viewBy")==null?"":request.getParameter("viewBy");//Added for IN061885

		
		StringBuffer sql = new StringBuffer(); 
		String classValue = "";
		int i = 0;
		//IN061885 Starts
		String pendDisSumGracPrd ="";
		try{
			String dateSql ="SELECT PEND_DISCHRG_SUMM_DAYS FROM CA_PARAM";

		
			pstmt = con.prepareStatement( dateSql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
					pendDisSumGracPrd	=	rs.getString("PEND_DISCHRG_SUMM_DAYS");
			}
		}
		catch(Exception d){
			d.printStackTrace();
		}
		finally
		{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
		}
		//IN061885 Ends

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(!"NURSE".equals(viewBy)){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
		if(sql.length() > 0) sql.delete(0,sql.length());
			//IN061885 Changes Starts
			//sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - 2 AND PATIENT_CLASS IN ('IP', 'DC') AND (ATTEND_PRACTITIONER_ID = ? OR DISCH_PRACTITIONER_ID = ?) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS != '9') ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603 //Commented for IN061885

			if(!"NURSE".equals(viewBy)){
			//sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - 2 AND PATIENT_CLASS IN ('IP', 'DC') AND (ATTEND_PRACTITIONER_ID = ? OR DISCH_PRACTITIONER_ID = ?) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS != '9') ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603//IN67872
			sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - 2 AND PATIENT_CLASS IN ('IP', 'DC') AND (ATTEND_PRACTITIONER_ID = ? OR DISCH_PRACTITIONER_ID = ?) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS not in ('9','8')) ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603//IN67872
			}
			else{
			//sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - "+pendDisSumGracPrd+" AND PATIENT_CLASS IN ('IP', 'DC') AND 'Y'=ca_pract_by_locn_yn(A.FACILITY_ID,?,A.PAT_CURR_LOCN_CODE) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS != '9') ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603//IN67872
			sql.append(" SELECT  am_get_desc.am_practitioner (a.ATTEND_PRACTITIONER_ID,?, '1' ) attend_pract_name, am_get_desc.am_practitioner (a.DISCH_PRACTITIONER_ID,?, '1' ) disch_pract_name, get_patient.get_line_detail (a.facility_id, a.encounter_id, ? )  patient_detail, TO_CHAR (a.DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi') disch_date_time, patient_id, encounter_id, patient_class FROM   PR_ENCOUNTER A WHERE A.ADT_STATUS = '08' AND A.DISCHARGE_DATE_TIME IS NOT NULL AND DISCHARGE_DATE_TIME < SYSDATE - "+pendDisSumGracPrd+" AND PATIENT_CLASS IN ('IP', 'DC') AND 'Y'=ca_pract_by_locn_yn(A.FACILITY_ID,?,A.PAT_CURR_LOCN_CODE) AND FACILITY_ID = ? AND NOT EXISTS (SELECT 1 FROM CA_ENCNTR_NOTE B, CA_NOTE_GROUP C, CA_NOTE_TYPE D WHERE B.NOTE_TYPE = D.NOTE_TYPE AND C.NOTE_GROUP = D.NOTE_GROUP_ID AND C.APPL_TASK_ID = 'DISCHARGE_SUMMARY' AND B.PATIENT_ID = A.PATIENT_ID AND B.ENCOUNTER_ID = A.ENCOUNTER_ID AND B.EVENT_STATUS not in ('9','8')) ");// added AND B.EVENT_STATUS  for IN059021// added encounter_id condition for IN059603//IN67872
			}
			//IN061885 Changes Ends
		
			if(!fromDate.equals("")&&(!toDate.equals("")))
			{
				sql.append( " and a.DISCHARGE_DATE_TIME between to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY')+.9999 ");
			}
			else if(!fromDate.equals("") && (toDate.equals("")))
			{
				sql.append(" 	and a.DISCHARGE_DATE_TIME >= to_date( ?, 'DD/MM/YYYY' ) ");
			}
			else if(fromDate.equals("") && !toDate.equals(""))
			{
				sql.append(" 	and a.DISCHARGE_DATE_TIME <= to_date( ?,'DD/MM/YYYY' )+.9999 ");
			}
			if(!patientId.equals(""))
				sql.append( " and a.patient_id =? ");
				
			
			sql.append("  order by discharge_date_time desc  ");
			
						
			System.out.println("Line No:173 ReviewNotesDetails.jsp sql>"+sql);
			pstmt=con.prepareStatement(sql.toString());

			//*********parameter binding
			int count=0;
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,locale);
			pstmt.setString(++count,clinicianId);
			if(!"NURSE".equals(viewBy)){ //Added if condition for IN061885
			pstmt.setString(++count,clinicianId);
			}
			pstmt.setString(++count,facilityId);
			
			if(!fromDate.equals("")&&(!toDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				
				pstmt.setString(++count,toDate);
				
			}
			else if(!fromDate.equals("") && (toDate.equals("")))
			{
				pstmt.setString(++count,fromDate);
				
			}
			else if(fromDate.equals("") && !toDate.equals(""))
			{
				pstmt.setString(++count,toDate);
				
			}
			if(!patientId.equals(""))
				pstmt.setString(++count,patientId);	
			
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{	
				if(i%2 == 0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";
				String patdetails = rs.getString("patient_detail");
				if (patdetails== null) patdetails="";
				patdetails = patdetails.replace('|',',');
				String attend_pract_name 	= rs.getString("attend_pract_name")==null?"":rs.getString("attend_pract_name");
				String disch_pract_name 	= rs.getString("disch_pract_name")==null?"":rs.getString("disch_pract_name");
				//String disch_date_time 		= rs.getString("disch_date_time")==null?"":rs.getString("disch_date_time");
				String encounter_id 		= rs.getString("encounter_id")==null?"":rs.getString("encounter_id"); 
				String patient_class		= rs.getString("patient_class")==null?"":rs.getString("patient_class");	
				String patient_id			= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				
				out.println("<tr><td class='gridData'>"+ attend_pract_name 	+"</td>");
				out.println("<td class='gridData'>"+ disch_pract_name 	+"</td>");
				out.println("<td class='gridData' > "+com.ehis.util.DateUtils.convertDate(rs.getString("disch_date_time"),"DMYHM","en",locale)+"</td>");
				out.println("<td class='gridData'>"+patdetails+"</td>");
				if(!"NURSE".equals(viewBy)){// Added If condition for IN061885
				out.println("<td class='gridData'><a class='gridLink'  href=\"javascript:callDiscSummNotes('"+patient_id+"','"+encounter_id+"','"+patient_class+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.recordsign.label","ca_labels")+"</a></td></tr>");
				}
				i++;
				
				
			}
            _bw.write(_wl_block16Bytes, _wl_block16);


			 if(i==0){ 
            _bw.write(_wl_block17Bytes, _wl_block17);
}
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block20Bytes, _wl_block20);
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

            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedatetime.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
}
