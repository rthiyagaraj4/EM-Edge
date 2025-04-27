package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __viewcareplanpatassmtresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ViewCarePlanPatAssmtResult.jsp", 1709116630746L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n<html>  \n\t<head>\n\t\t<title>PatientAssessmentResult</title>\n\t\t<script src=\'../../eCP/js/ViewCarePlan.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n\t</head>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<body onmousedown = \'CodeArrest();\' onscroll=\'scrollViewCarePlanTable();\'>\n\t\t<script>\n\t\t\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\t\t\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\t\t</script>\n\t\t<form name=\'patAssessmentResultForm\' id=\'patAssessmentResultForm\' action=\'\' >\n\t\t\t<table width=\'100%\' align=\'center\' border=1 cellpadding=\'0\' cellspacing=0 style=\'display:inline\' id=\'valuesTable\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\n\t\t\t<input type=\'hidden\' name=\'qry_string\' id=\'qry_string\' value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");	
	
            _bw.write(_wl_block4Bytes, _wl_block4);

			String facility_id = (String) session.getAttribute("facility_id");

			String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");			
			String location_code = request.getParameter("location_code") == null ? "" : request.getParameter("location_code");			
			String location_type = request.getParameter("location_type") == null ? "" : request.getParameter("location_type");			
			String sex = request.getParameter("Sex") == null ? "" : request.getParameter("Sex");			
			String age = request.getParameter("Age") == null ? "" : request.getParameter("Age");			
			String dob = request.getParameter("Dob") == null ? "" : request.getParameter("Dob");			
			String relationship_id = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id");			
			String function_from = request.getParameter("function_from") == null ? "" : request.getParameter("function_from");	//IN030474
			
			String accession_num = "";
			String assess_ref_no = "";
			String assess_date = "";
			String ua_dependency_desc = "";
			String ss_dependency_desc = "";
			String note_type = "";
			String status = "";
			String status_flag = "";
			String classValue = "";
			String sqlresult = "";	
			String note_desc = "";
			String ua_dependency_code = "";
			String ss_dependency_code = "";
			String prev_assess_date = "";
			String assess_time = "";
			int count = 0;
			
			Connection con = null;
			PreparedStatement psResult = null;
			ResultSet resResult = null;
			PreparedStatement psNote = null;
			ResultSet resNote = null;
			PreparedStatement psNoteDesc = null;
			ResultSet resNoteDesc = null;

			try{
				con = ConnectionManager.getConnection(request);

				sqlresult = "SELECT A.ASSESS_REF_NO, A.ACCESSION_NO, A.ASSESS_PRACT_ID, B.PRACTITIONER_NAME, TO_CHAR(A.ASSESS_DATE,'DD/MM/YYYY') ASSESS_DATE_STR, TO_CHAR(A.ASSESS_DATE,'HH24:MI') ASSESS_TIME_STR,A.SS_DEPENDENCY_CODE, (SELECT SHORT_DESC FROM CP_DEPENDENCY WHERE DEPENDENCY_CODE=A.SS_DEPENDENCY_CODE) SS_DEPENDENCY_DESC, A.UA_DEPENDENCY_CODE, (SELECT SHORT_DESC FROM CP_DEPENDENCY WHERE DEPENDENCY_CODE=A.UA_DEPENDENCY_CODE) UA_DEPENDENCY_DESC FROM CP_PAT_ASSESS A, AM_PRACTITIONER B WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND B.PRACTITIONER_ID=A.ASSESS_PRACT_ID order by a.ASSESS_DATE desc";

				String sql_note_id = "select note_type,  decode(event_status,'1','In Progress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified'),event_status from ca_encntr_note where accession_num = ?";

				String sql_note_desc = "select ASSESS_NOTE_DESC FROM cp_assess_note where ASSESS_NOTE_ID = ?";
			
				psResult = con.prepareStatement(sqlresult);
				psResult.setString(1,facility_id);
				psResult.setString(2,encounter_id);

				psNote = con.prepareStatement(sql_note_id);				
				psNoteDesc = con.prepareStatement(sql_note_desc);

				resResult = psResult.executeQuery();

				while(resResult.next()){
					assess_ref_no = resResult.getString(1);
					accession_num = resResult.getString(2);
					ua_dependency_desc = resResult.getString("UA_DEPENDENCY_DESC");
						if(ua_dependency_desc ==null) ua_dependency_desc="&nbsp;";
					ua_dependency_code = resResult.getString("UA_DEPENDENCY_CODE");
					//out.println("ua_dependency_code = "+ua_dependency_code);
					ss_dependency_desc = resResult.getString("SS_DEPENDENCY_DESC");
						if(ss_dependency_desc ==null) ss_dependency_desc="&nbsp;";
					ss_dependency_code = resResult.getString(6);
					assess_date = resResult.getString("ASSESS_DATE_STR");
					assess_time = resResult.getString("ASSESS_TIME_STR");
					
					psNote.setString(1,accession_num);
					resNote = psNote.executeQuery();
					while(resNote.next())	{
						note_type = resNote.getString(1);
						status = resNote.getString(2);
						status_flag = resNote.getString(3);
					}
					resNote.close();

					psNoteDesc.setString(1,note_type);
					resNoteDesc = psNoteDesc.executeQuery();
					while(resNoteDesc.next())	{
						note_desc = resNoteDesc.getString(1);
					}	
					resNoteDesc.close();

					if(count%2 == 0)
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";
					
					if(!prev_assess_date.equals(assess_date)){
						out.println("<tr>");
						out.println("<td><font size='1' style='font-family: verdana ;BACKGROUND-COLOR: #B2B6D7;COLOR:black'><b> "+assess_date+" </b></font>");
						out.println("</tr>");						
					}

					//out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.println("<tr>");
					//System.out.println("status="+status+", note_desc="+note_desc+", note_type="+note_type+", accession_num="+accession_num+", assess_time="+assess_time+", assess_date="+assess_date+", ua_dependency_desc="+ua_dependency_desc+", assess_ref_no="+assess_ref_no+", patient_id="+patient_id+", patient_class="+patient_class+", encounter_id="+encounter_id+", location_code="+location_code+", location_type="+location_type+", sex="+sex+", age="+age+", dob="+dob+", ua_dependency_code="+ua_dependency_code+", ss_dependency_code="+ss_dependency_code+", relationship_id="+relationship_id+", ss_dependency_desc="+ss_dependency_desc+", status_flag="+status_flag+", assess_time="+assess_time);
					//out.println("<td class="+classValue+" id='tdid"+count+"'><A HREF='javascript:' onclick='loadViewCarePlanAddModifyFrame(\""+status+"\",\""+note_desc+"\",\""+note_type+"\",\""+accession_num+"\",\""+assess_time+"\",\""+assess_date+"\",\""+ua_dependency_desc+"\",\""+assess_ref_no+"\",\""+patient_id+"\",\""+patient_class+"\",\""+encounter_id+"\",\""+location_code+"\",\""+location_type+"\",\""+sex+"\",\""+age+"\",\""+dob+"\",\""+ua_dependency_code+"\",\""+ss_dependency_code+"\",this,\""+relationship_id+"\",\""+ss_dependency_desc+"\",\""+status_flag+"\")' >");//IN030474
					out.println("<td class="+classValue+" id='tdid"+count+"'><A HREF='javascript:' onclick='loadViewCarePlanAddModifyFrame(\""+status+"\",\""+note_desc+"\",\""+note_type+"\",\""+accession_num+"\",\""+assess_time+"\",\""+assess_date+"\",\""+ua_dependency_desc+"\",\""+assess_ref_no+"\",\""+patient_id+"\",\""+patient_class+"\",\""+encounter_id+"\",\""+location_code+"\",\""+location_type+"\",\""+sex+"\",\""+age+"\",\""+dob+"\",\""+ua_dependency_code+"\",\""+ss_dependency_code+"\",this,\""+relationship_id+"\",\""+ss_dependency_desc+"\",\""+status_flag+"\",\""+function_from+"\")' >");//IN030474
					//out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.println("&nbsp;<font size='1'>-"+assess_time+"</font></a> </td>");

					out.println("<tr>");
					//out.println("<br>");					
					count++;
					prev_assess_date = assess_date;
				}//end of while
				resResult.close();
				psNoteDesc.close();
    			psNote.close();
				psResult.close();


			}//end of try
			catch(Exception e){
				e.printStackTrace(System.err);
				System.out.println("Exception in try of ViewCarePlanPatAsssmtResult.jsp "+ e.toString());
			}//end of catch
			finally{
				if(resResult != null) resResult = null;
				if(resNote != null) resNote = null;
				if(resNoteDesc != null) resNoteDesc = null;

				if(psResult != null) psResult = null;
				if(psNote != null) psNote = null;
				if(psNoteDesc != null) psNoteDesc = null;

				if(con != null) ConnectionManager.returnConnection(con);
			}//end of finally			

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
