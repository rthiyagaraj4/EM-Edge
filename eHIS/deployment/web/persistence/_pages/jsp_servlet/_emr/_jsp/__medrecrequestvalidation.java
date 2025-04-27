package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __medrecrequestvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedRecRequestValidation.jsp", 1730782879303L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n\n\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body class=message onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\tvar element = parent.frames[2].document.createElement(\'OPTION\')\n\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n//\t\t\t\t\t\telement.selected = true\n\n\t\t\t\t\t\tparent.frames[2].document.forms[0].team_id.add(element);\n//\t\t\t\t\t\tparent.frames[2].document.forms[0].selectTeam.value = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\tparent.frames[2].document.forms[0].pract_desc.value = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\t\n\t\t\tfor(var i=0; i<parent.frames[2].document.forms[0].length;i++)\n\t\t\t{\n\t\t\t\tparent.frames[2].document.forms[0].elements[i].disabled = false;\n\t\t\t}\n\n\t\t\tvar EncIDS = parent.frames[1].document.forms[0].encIDS.value;\n\t\t\tparent.frames[2].document.forms[0].EncounterIDS.value = EncIDS;\n\t\t\tparent.frames[2].document.forms[0].action = \"../../servlet/eMR.MedRecRequestServlet\";\n\t\t\tparent.frames[2].document.MedicalRecordReqForm.submit();\n\n\t\t</script>\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t<script> \n\t\t\t\t\t\t//parent.frames[2].document.forms[0].MedicalMembers.disabled= false\n\t\t\t\t\t</script>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t<script> \n\t\t\t\t\t\t//parent.frames[2].document.forms[0].MedicalMembers.value = \'\';\n\t\t\t\t\t\t//parent.frames[2].document.forms[0].MedicalMembers.disabled = true\n\t\t\t\t\t</script>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t\tvar j=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\teval(\"parent.frames[0].document.forms[0].recodedCode\"+j).value=\"\";\n\t\t\teval(\"parent.frames[0].document.getElementById(\'Description\'\"+j+\")\").innerText=\"         \";\n\t\t\teval(\"parent.frames[0].document.forms[0].reCodedDesc\"+j).value=\"\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\n\t\tvar j=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\teval(\"parent.frames[0].document.getElementById(\'Description\'\"+j+\")\").innerText=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\teval(\"parent.frames[0].document.forms[0].reCodedDesc\"+j).value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(parent.frames[2].document.forms[0].appl_name != null)\n\t\t\t\t\t\tparent.frames[2].document.forms[0].appl_name.value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.frames[3].document.forms[0].appl_name.value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\t</script>\t\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t</script>\t\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<script>\n\t\t\tif(parent.frames[2].document.forms[0].appl_name != null)\n\t\t\t\tparent.frames[2].document.forms[0].appl_name.disabled = true;\n\t\t\telse\n\t\t\t\tparent.frames[3].document.forms[0].appl_name.disabled = true;\n\t\t</script>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<script>\n\t\t\t\t/*\n\t\t\t\tif(parent.frames[3].name == \"resultFrame\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[3].document.forms[0].appl_name.value\t= \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].appl_name.disabled= false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.forms[0].appl_name.value\t= \"\";\n\t\t\t\t\tparent.frames[2].document.forms[0].appl_name.disabled= false;\n\t\t\t\t}*/\n\t\t\t</script>\t\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[1].document.forms[0].event_status.value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" == \'4\' || \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" == \'5\')\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].action = \"../../servlet/eMR.MedBoardTransactionsServlet\";\n\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"NOTE_DOESNOT_EXIST\",\'MR\'));\n\t\t\t\t}\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<script>\n\t\t\t\tparent.DetailFrame.document.forms[0].event_status.value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" == \'5\')\n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.forms[0].action = \"../../servlet/eMR.PrepareReportServlet\";\n\t\t\t\t\tparent.frames[2].document.MedicalRecordReqForm.submit();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"NOTE_DOESNOT_EXIST\",\'MR\'));\n\t\t\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

	public static String checkForNull(String inputString)
	{ 
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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

/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Diagnosis Recoding
/// Developer		:	SRIDHAR R
/// Created On		:	19 JULY 2004
/// Function 		:   Used as validation Page in MR
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId	= (String) session.getValue("facility_id");
	String locale		= (String) session.getAttribute("LOCALE");
	String practid = checkForNull(request.getParameter("ippractid"));
	String called_from = checkForNull(request.getParameter("called_from"));
	String Criteria = checkForNull(request.getParameter("Criteria"));
	String teamid  = checkForNull(request.getParameter("team_id"));
	String REQUESTOR_CODE  = checkForNull(request.getParameter("REQUESTOR_CODE"));
//	String req_type  = checkForNull(request.getParameter("req_type"));
	String j  = checkForNull(request.getParameter("j"));
	String DiagCode  = checkForNull(request.getParameter("DiagCode"));
	String patient_id  = checkForNull(request.getParameter("patientId"));
//	String relationCode  = checkForNull(request.getParameter("relationCode"));
	String accession_num  = checkForNull(request.getParameter("accession_num"));
	String selectsql	= "";

	Connection con		= null;
	PreparedStatement pstmt =null;
	PreparedStatement stmt		= null;
	Statement diagStmt	= null;
	ResultSet rset		= null;
	ResultSet rs		= null;
	ResultSet diagRset	= null;

try
{	
	con = ConnectionManager.getConnection(request);	
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");

	if(Criteria.equals("populateMedicalTeams"))
	{
		//selectsql = "select a.short_desc short_desc , a.team_id team_id from am_medical_team a,am_pract_for_team b  where a.facility_id = ? and a.facility_id = b.facility_id and b.practitioner_id = ? and b.team_id=a.team_id order by 1";
		
		selectsql = "select am_get_desc.AM_MEDICAL_TEAM(a.facility_id, a.team_id,'"+locale+"','2') short_desc , a.team_id team_id from AM_MEDICAL_TEAM a, AM_PRACT_FOR_TEAM b where a.facility_id = ? and a.facility_id = b.facility_id and b.practitioner_id = ? and b.team_id = a.team_id order by 1";

		pstmt 	= con.prepareStatement( selectsql ) ;
		pstmt.setString(1,facilityId);
		pstmt.setString(2,practid);
		rs = pstmt.executeQuery() ;
		String str1 = "";
		String str2 = "";
		if( rs != null ) 
		{
			int i=0; 
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				i++;
				
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block5Bytes, _wl_block5);
	
			}
			if(rs!=null)	rs.close();
			if(pstmt!=null) pstmt.close();
		}
	}
	else if(Criteria.equals("populatePractitioner"))
	{
		//selectsql = "SELECT  c.PRACTITIONER_NAME PRACTITIONER_NAME, a.team_id, b.practitioner_id FROM am_medical_team a, am_pract_for_team b,am_practitioner c  WHERE a.facility_id = ? AND a.facility_id = b.facility_id AND a.team_id = ? AND b.team_id = a.team_id AND b.pract_role = 'C'and c.PRACTITIONER_ID = b.practitioner_id ORDER BY 1";

		selectsql = "SELECT  AM_GET_DESC.AM_PRACTITIONER(c.practitioner_id,'"+locale+"','1') practitioner_name, a.team_id, b.practitioner_id FROM AM_MEDICAL_TEAM a, AM_PRACT_FOR_TEAM b, AM_PRACTITIONER c  WHERE a.facility_id = ? AND a.facility_id = b.facility_id AND a.team_id = ? AND b.team_id = a.team_id AND b.pract_role = 'C' and c.practitioner_id = b.practitioner_id ORDER BY 1";

		stmt 	= con.prepareStatement(selectsql) ;
		stmt.setString(1,facilityId);
		stmt.setString(2,teamid);
		rset = stmt.executeQuery() ;
		String str1 = "";
//		String str2 = "";

		if( rset != null ) 
		{
			while( rset.next() ) 
			{
				str1 = rset.getString( "PRACTITIONER_NAME" ) ;
//				str2 = rset.getString( "practitioner_id" );
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block5Bytes, _wl_block5);
	
			}		
		}
		if(stmt!=null)
			stmt.close();
		if(rset!=null)
			rset.close();
	}
	else if(Criteria.equals("MedBoardMembers"))
	{
		//Modified By Dharma against ML-MMOH-SCF-1689 on Dec 16th 2020
		//String statusSql = "select count(*) from MR_REPORT_REQUEST_HDR where patient_id = ? and request_status != '4' and requestor_code=?";
		String statusSql = "select count(*) from MR_REPORT_REQUEST_HDR where patient_id = ? and request_status not in('4','8') and requestor_code=?";
		if(rset != null)	rset.close();	
		if(stmt != null)	stmt.close();		

		stmt 	= con.prepareStatement(statusSql) ;
		stmt.setString(1,patient_id);
		stmt.setString(2,REQUESTOR_CODE);
		rset = stmt.executeQuery() ;
		int result = 0;

		if( rset != null ) 
		{
			while( rset.next() ) 
			{
				result = rset.getInt(1) ;
			}
		}
	
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();

	if(result > 0)
	{	
		out.println("<script>alert(getMessage('REQUEST_ALREADY_MADE','MR'));</script>");
//		out.println("<script>parent.frames[2].document.getElementById("tab1").scrollIntoView();parent.frames[2].document.forms[0].requestor_desc.value='';parent.frames[2].document.forms[0].requestor_desc.focus();</script>");
		out.println("<script>parent.frames[2].document.forms[0].requestor_desc.value='';parent.frames[2].document.forms[0].requestor_desc.focus();</script>");

	}
	else
	{	
            _bw.write(_wl_block7Bytes, _wl_block7);
	
		//out.println("<script>parent.frames[2].document.forms[0].requestor_validation.value='TRUE';</script>");
	}
/*
	else
	{
		selectsql = "select REQUESTOR_CODE, SHORT_DESC,INDICATOR from mr_requestor where facility_id='"+facilityId+"' and  REQUESTOR_CODE= '"+REQUESTOR_CODE+"' ";

		if(rset != null)	rset.close();	
		if(stmt != null)	stmt.close();	

		stmt 	= con.createStatement() ;
		rset = stmt.executeQuery(selectsql) ;
		String str1 = "";

		if( rset != null ) 
		{
			while( rset.next() ) 
			{
				str1 = rset.getString( "INDICATOR" ) ;
				if(str1.equals("8"))
				{*/
				
            _bw.write(_wl_block8Bytes, _wl_block8);
	/*
				}
				else
				{*/
				
            _bw.write(_wl_block9Bytes, _wl_block9);
	/*

				}
			}		
		}
	  }*/
	}
	else if(Criteria.equals("getDiagnosis"))
	{
		String diagSql = "select DIAG_CODE, LONG_DESC, SHORT_DESC from MR_ICD_CODE ";
		String result= "fail";
		diagStmt = con.createStatement() ;
		diagRset = diagStmt.executeQuery(diagSql) ;
		String diagnosis_code = "";
		String diagnosis_desc = "";

		if( diagRset != null ) 
		{
			while( diagRset.next() ) 
			{
				diagnosis_code = diagRset.getString("DIAG_CODE");
				if(DiagCode.equals(diagnosis_code))
				{
					result = "pass";
					diagnosis_desc = diagRset.getString("SHORT_DESC");
				}
			}
		}
		
		if(diagRset!=null)	diagRset.close();
		if(diagStmt!=null) diagStmt.close();

		if(result.equals("fail"))
		{	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(j));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
		else
		{	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(j));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(diagnosis_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(diagnosis_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
	}
	
	}
	else if(Criteria.equals("populateApplName"))
	{
/*
for NExt of Kin ... use Contact1... columns
First TO notify use Contact 2... columns
Employer ... take contact 3 columns
*/
		String popNameFor = checkForNull(request.getParameter("popNameFor"));	
		String contact1_name = "";
		String contact2_name = "";
		String contact3_name = "";
		String nameSql = " select contact1_name, contact2_name, contact3_name  from MP_PAT_REL_CONTACTS where patient_id =? ";
		
		if(rset != null)	rset.close();	
		if(stmt != null)	stmt.close();	

		stmt 	= con.prepareStatement(nameSql) ;
		stmt.setString(1,patient_id);
		rset = stmt.executeQuery() ;
		if ((rset != null) && (rset.next()))
		{
			contact1_name = checkForNull(rset.getString("contact1_name"));
			contact2_name = checkForNull(rset.getString("contact2_name"));
			contact3_name = checkForNull(rset.getString("contact3_name"));
		}
			if (popNameFor.equals("NKIN"))
			{	
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(contact1_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(contact1_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
	
			}
			else if (popNameFor.equals("FTON"))
			{	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(contact2_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(contact2_name));
            _bw.write(_wl_block19Bytes, _wl_block19);

			}	
			else if (popNameFor.equals("EMP"))
			{	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(contact3_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(contact3_name));
            _bw.write(_wl_block19Bytes, _wl_block19);

			} 
            _bw.write(_wl_block20Bytes, _wl_block20);
	/*
			else if (info_pat_name.equals(""))
			{	*/
            _bw.write(_wl_block21Bytes, _wl_block21);
//	}
	}
	else if(Criteria.equals("populateEventStatus"))
	{
		if(rset != null)	rset.close();
		if(stmt != null)	stmt.close();	

		String event_status="";
		String EventStatusSQL = "select event_status from CA_ENCNTR_NOTE where patient_id=? and accession_num=?";

		stmt 	= con.prepareStatement(EventStatusSQL) ;
		stmt.setString(1,patient_id);
		stmt.setString(2,accession_num);
		rset = stmt.executeQuery() ;
		while(rset.next())
		{
			event_status = checkForNull(rset.getString("EVENT_STATUS"));
		}
		if(called_from.equals("MEDICAL_BOARD"))
		{
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block25Bytes, _wl_block25);
	}
		else
		{	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block27Bytes, _wl_block27);
		}
	}
		
	out.println("</script></head><body onKeyDown='lockKey()' CLASS='MESSAGE'></body></html>");
}catch(Exception e){
	e.printStackTrace();	
}
finally
{
 	ConnectionManager.returnConnection(con,request);	
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();
}
  

            _bw.write(_wl_block28Bytes, _wl_block28);
            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
