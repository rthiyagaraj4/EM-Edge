<!DOCTYPE html>
<%
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Diagnosis Recoding
/// Developer		:	SRIDHAR R
/// Created On		:	27 JULY 2004
/// Function 		:   Used to define the result page of recode diagnosis
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper "  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>

<script src='../js/PatProblem.js' language='javascript'></SCRIPT>
<script src='../js/DateValidation.js' language='javascript'></SCRIPT>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCA/js/PatHighRisk.js' language='javascript'></SCRIPT>
<script src='../../eMR/js/MedRecRequest.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con				= null; 
	Statement stmt				= null;
    PreparedStatement stmt_1	= null;
    ResultSet rs				= null;
    ResultSet rs_1				= null;

    SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
    String currentdate			= dateFormat.format(new java.util.Date()) ;
    String facilityId				= (String) session.getValue( "facility_id" ) ;

	String srl_no					= request.getParameter("srl_no");
    String Patient_Id			= request.getParameter("patient_id");
    String Encounter_Id		= request.getParameter("Encounter_Id");


	String scheme_desc			= "";
    String scheme					= "";
	String srl_no_from_table	="";
    String diag_code				="";
    String diag_desc				="";
    String primary_yn				="N";
    String onset_date				=currentdate;
    String close_date				="";
    String problem_status		="";

   // String id[] ={"","B","W","S","C"};
   // String val[]={"-- Select --","Better","Worse","Same","Close"};

    String cause_ind="";
	primary_yn		=	(request.getParameter("primary_yn")==null)?"N" : request.getParameter("primary_yn");

	StringBuffer sql_1 = new StringBuffer();
	String record_type="";
	String onSet_facilityID="";
	String onSet_EncounterID="";
	String diag_code_scheme="";
	int count = 0;
	String recoded_code			= "";
	String recoded_code_desc	= "";
	String recoded_remarks		= "";

try{
	con = ConnectionManager.getConnection(request);

	String sql=" select diag_code_scheme scheme, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date from mr_parameter ";
	
	if(rs!=null) rs.close();
	if(stmt != null) stmt.close();
	stmt=con.createStatement();
	rs=stmt.executeQuery(sql);
	
	if(rs.next())
	{
		scheme      = rs.getString("scheme");
		out.print("<script>scheme='"+scheme+"'</script>");
		scheme_desc = rs.getString("scheme_desc");
//		db_date     = rs.getString("db_date");
	}
	else
		 out.print("<script>scheme=''</script>");

	if(rs!=null) rs.close();
	if(stmt != null) stmt.close();

    if(srl_no != null)
    {
    
	String count_sql = "SELECT count(*) FROM  mr_diag_recoding WHERE patient_id = ? AND srl_no = ? and ONSET_FACILITY_ID = ?";
	PreparedStatement countStmt = null;
	ResultSet countRS  = null;

	countStmt = con.prepareStatement(count_sql);
	countStmt.setString(1,Patient_Id);
	countStmt.setString(2,srl_no);
	countStmt.setString(3,facilityId);

	countRS	  = countStmt.executeQuery();

	if(countRS != null )
	{
		if(countRS.next())
		{
			count = countRS.getInt(1);
		}
	}
	if(countStmt != null) countStmt.close();
	if(countRS != null) countRS.close() ;

	if(count == 0)
	{	
//		read_only	= "readonly";
//        data_state	= "modify";
//        dis			= "disabled";
		
		sql_1.append("Select ONSET_ENCOUNTER_ID, ONSET_FACILITY_ID,RECORD_TYPE, srl_no,diag_code,diag_desc,primary_yn,to_char(onset_date,'dd/mm/yyyy') onset_date,to_char(close_date,'dd/mm/yyyy') close_date, problem_status, cause_indicator, ip_diag_stage, decode(ip_diag_stage,'I','Intermediate','A','Admission','D','Discharge') diag_stage_desc, problem_remarks, diag_type, significant_yn, DIAG_CODE_SCHEME ");
        sql_1.append(" from pr_problem where patient_id = ? and srl_no = ? ");

		stmt_1 = con.prepareStatement(sql_1.toString());
		stmt_1.setString(1,Patient_Id);
		stmt_1.setString(2,srl_no);

        rs_1 = stmt_1.executeQuery();

        if (rs_1.next())
        {
			onSet_facilityID			=  rs_1.getString("ONSET_FACILITY_ID");
			onSet_EncounterID	=  rs_1.getString("ONSET_ENCOUNTER_ID");
			diag_code_scheme	=  rs_1.getString("DIAG_CODE_SCHEME");
			srl_no_from_table		=  rs_1.getString("srl_no");

			diag_code					=   rs_1.getString("diag_code");
				if(diag_code==null) diag_code = "";
			record_type   =   rs_1.getString("RECORD_TYPE");
				if(record_type==null) record_type = "";
            diag_desc   =   rs_1.getString("diag_desc");
	            if (diag_desc == null) diag_desc = "";

			primary_yn  =   rs_1.getString("primary_yn");
	            if (primary_yn == null) primary_yn = "";

			onset_date  =   rs_1.getString("onset_date");
	            if (onset_date == null) onset_date = "";
			
			close_date  =   rs_1.getString("close_date");
	            if (close_date == null) close_date = "";

            problem_status= rs_1.getString("problem_status");
	            if (problem_status.equals("A")) problem_status="";

			cause_ind=rs_1.getString("cause_indicator");
	            if(cause_ind==null) cause_ind="";
            
//			diagstage		= rs_1.getString("diag_stage_desc");
//          diagstagecode	= rs_1.getString("ip_diag_stage");
//			significant_yn	= rs_1.getString("significant_yn");

//			diagtype = rs_1.getString("diag_type");
//			if(!(diagtypeselected.equals("") || diagtypeselected.equals("null")))
//              diagtype = diagtypeselected;

//          problemremarks = rs_1.getString("problem_remarks");
//			if(!(remarksselected.equals("") || remarksselected.equals("null")))
//                problemremarks = remarksselected;
/*
            if(diagtype.equals("P"))
				sel1 = "selected";
            else if(diagtype.equals("D"))	
				sel2 = "selected";
            else if(diagtype.equals("F"))	
				sel3 = "selected";
*/

        }
		if(stmt_1!=null)
			stmt_1.close();
		if(rs_1!=null)
			rs_1.close();
    }// count == 0
	else
	{
		 
	String MRsql = " SELECT RECODED_DIAG_CODE mr_diag_code, RECODED_REMARKS mr_remarks, RECODED_DIAG_DESC mr_desc FROM mr_diag_recoding_vw WHERE PATIENT_ID = ? AND SRL_NO = ? AND FACILITY_ID = ? ";

	if(countStmt != null) countStmt = null;
	if(countRS != null) countRS = null;

	countStmt = con.prepareStatement(MRsql);
	countStmt.setString(1,Patient_Id);
	countStmt.setString(2,srl_no);
	countStmt.setString(3,facilityId);

	countRS  = countStmt.executeQuery();

		if(countRS != null )
		{
			if(countRS.next())
			{
				recoded_code		= countRS.getString("mr_diag_code");
					if(recoded_remarks	== null ) recoded_remarks = "";
				recoded_code_desc	= countRS.getString("mr_desc");
					if(recoded_remarks	== null ) recoded_remarks = "";
				recoded_remarks		= countRS.getString("mr_remarks");
					if(recoded_remarks	== null ) recoded_remarks = "";
			}
		}
	}
        if(countRS!=null)  countRS.close();
		if(countStmt!=null) countStmt.close();
	}

%>
<script>

//added on 23/08/2004 for facilitating input of '.' in Code text field the existing function was CheckForSpecChars(event)
	 
//Addition ends

</script>
<form name='diagnosis_recode' id='diagnosis_recode'  action='../../servlet/eMR.DiagnosisRecodeServlet' method='post' target='messageFrame'>
</br>
<table border=0 cellpadding='2' cellspacing='0' width="110%">
<tr>
	<td class="COLUMNHEADER"colspan='8'><fmt:message key="eMR.DiagnosisRecodingDetails.label" bundle="${mr_labels}"/></td>
</tr>
<tr><td class=label colspan=4></td></tr><tr><td class=label colspan=4></td></tr>
<tr><td class=label colspan=4></td></tr><tr><td class=label colspan=4></td></tr>
<tr><td class=label colspan=4></td></tr><tr><td class=label colspan=4></td></tr>
<tr>
	<td align="right" class='label'><fmt:message key="eMR.Recode.label" bundle="${mr_labels}"/> &nbsp;</td>
	<td><input type="text"  name="recode" id="recode" value=""  size=15 maxlength='10' onKeyPress="return(valid_ch(event))" onblur="getDiagnosis1(this)"><input type="button" class='Button' name="search_button" id="search_button" title='Search' value="?" onClick=show_window1('<%=scheme%>') >&nbsp;<img src='../../eCommon/images/mandatory.gif' id='img1' style='visibility:visible'></img>&nbsp;<%=scheme_desc%></td>
	<td align='left' colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td align="right" class='label'><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;</td>
	<td colspan=4><input type="text"  name="Recoded_Description" id="Recoded_Description" value="" size=70 readonly></td>
	<td align='left' colspan='4'>&nbsp;</td>
</tr>
<tr>
	<td align='right' class='label' valign='top'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
	<td colspan='5'><textarea name="remarks" rows="3" cols="60" maxlength='2000'  value="" ></textarea></td>
</tr>
<tr>
	<td colspan="3">&nbsp;&nbsp;</td><td class='button'><input type="button" class='Button' name="record" id="record" title='Record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onclick="apply1();" disabled><input type="button" class='Button' name="close" id="close" title='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick="window.close();" ></td><td>&nbsp;</td>
</tr>
<!-- Following lines added for proper display of scren-->
<% for(int i=0;i<75;i++) { %>
<tr><td class=label colspan=4></td></tr>
<% } %>
<input type='hidden' name="scheme_desc" id="scheme_desc" value='<%=scheme_desc%>'>
<input type='hidden' name="onSet_facilityID" id="onSet_facilityID" value='<%=onSet_facilityID%>'>
<input type="hidden" name="onSet_EncounterID" id="onSet_EncounterID" value="<%=onSet_EncounterID%>">
<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=Encounter_Id%>">
<input type="hidden" name="Patient_Id" id="Patient_Id" value="<%=Patient_Id%>">
<input type="hidden" name="scheme" id="scheme" value="<%=scheme%>">
<input type="hidden" name="diag_code_scheme" id="diag_code_scheme" value="<%=diag_code_scheme%>">
<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no_from_table%>">
<input type="hidden" name="cause_indicator" id="cause_indicator" value="<%=cause_ind%>">
<input type="hidden" name="record_type" id="record_type" value="<%=record_type%>">
<input type="hidden" name="org_diag_code" id="org_diag_code" value="<%=diag_code%>">
<input type="hidden" name="formFields" id="formFields" value="">
<%
	if(count > 0)	
	{ %>
	<script>

		document.forms[0].recode.value			= "<%=recoded_code%>";
		document.forms[0].recode.readOnly		= true;
		document.forms[0].search_button.disabled= true;
		document.forms[0].Recoded_Description.value			= "<%=recoded_code_desc%>";
		document.forms[0].remarks.value			= "<%=recoded_remarks%>";
		document.forms[0].remarks.readOnly		= true;
		document.forms[0].record.disabled		= true;
		document.getElementById("img1").style.visibility='hidden';

	</script>
<%	}	%>

</form>
</body>
</html>

<%
}catch(Exception e)
{
    //out.print("Exception :"+sql_1.toString()+""+e.toString());
	e.printStackTrace();
}
finally
{
	try
	{
	if(rs!=null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
	}
	if(con != null) 
		ConnectionManager.returnConnection(con,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

