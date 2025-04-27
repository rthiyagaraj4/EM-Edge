<!DOCTYPE html>
<%
/**
	MODULE			:	Medical Records..(MR)
	Function Name	:	WEHU - A1 / A2 && WEHU - D1 / D2
	Developer		:	SRIDHAR R
	Created On		:	10 JAN 2005
**/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"  %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId		= (String) session.getValue("facility_id");
	String PatientId		= request.getParameter("PatientId");
    String Encounter_Id     = request.getParameter("Encounter_Id");
	int j=1;
		
	String call_function	= request.getParameter("call_function");	

    //String scheme       ="";
   // String scheme_desc  ="";
	String significant_yn = "";
	significant_yn			=	request.getParameter("significant_yn");
	if(significant_yn==null) significant_yn = "N";
    int k=1;
    int aname=2;
    String classValue = "";
	String diag_type="", temp="";

	/*String sql_1="select diag_code_scheme scheme,decode(diag_code_scheme,'1','ICD 10','2','ICD 9CM','5','READ')scheme_desc from mr_parameter";*/

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	
	<script src='../js/rowcolor.js' language='javascript'></script>
	
		
	<script src='../../eMR/js/MRReports.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<script>



srl_no_array = new Array();
var prev=1;
var i=0;
var prev1=0;
var j=0;


</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name='query_form' id='query_form' method='post' target='messageFrame' action='../../servlet/eMR.RepWEHUADDiagServlet'>
<%
        Connection conn 	= null; 
        PreparedStatement  pstmt = null;
        ResultSet  rs		= null;
        //Statement  stmt_1	= null;
        //ResultSet  rs_1		= null;
		
		Statement  recode_count_stmt	= null;
        ResultSet  recode_count_rs		= null;
		Statement  recode_stmt	= null;

		int recode_count	= 0;
        int maxRecord 		= 0;
		String diag_code			= "";
		//String diag_code_scheme_desc= "";
		//String DIAG_CODE_SCHEME		= "";


/// Added by SRIDHAR R on 8 Oct 2004...
/// This will execute if the function is Diagnosis Recoding & will display the values to the user in the update mode.. if records already exists in mr_diag_recoding...

		//String added_date			= "";
		//String added_by_id			= "";

try
{
	conn = ConnectionManager.getConnection(request);

	String recode_count_sql = " SELECT COUNT (*) FROM mr_diag_recoding WHERE onset_facility_id = '"+facilityId+"' AND onset_encounter_id = '"+Encounter_Id+"' ";
	recode_count_stmt	= conn.createStatement();
	recode_count_rs		= recode_count_stmt.executeQuery(recode_count_sql);
	if(recode_count_rs.next())
	{
		recode_count = recode_count_rs.getInt(1);
	}

	if(recode_count_stmt!=null)	recode_count_stmt.close();
	if(recode_count_rs!=null)	recode_count_rs.close();
	
	/*stmt_1=conn.createStatement();
	rs_1=stmt_1.executeQuery(sql_1);
	if(rs_1.next())
	{
		//scheme      = rs_1.getString("scheme");
		//scheme_desc = rs_1.getString("scheme_desc");
	}

	if(rs_1 !=null) rs_1.close();
	if(stmt_1!=null) stmt_1.close();
*/
	String strsql = "";
	
	strsql = "select count(1) from pr_problem_vw where patient_Id = ? and onset_encounter_id = ?  and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N' and close_date is null ";
	
	pstmt	=	conn.prepareStatement(strsql);
	pstmt.setString(1,PatientId);
	pstmt.setString(2,Encounter_Id);
	rs = pstmt.executeQuery();
	if(rs.next())
	  maxRecord = rs.getInt(1);

	if (maxRecord==0)
	{			
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.window.close();</script>");
	}

	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();

	StringBuffer  sql = new StringBuffer();
	sql.append("");

	if(recode_count == 0)
	{
		sql.append("select DIAG_CODE_SCHEME,srl_no,to_char(onset_date,'dd/mm/yyyy') onset_date1,sensitive_yn,diag_desc,diag_code,diag_code_scheme_desc,ONSET_PRACTITIONER_NAME, significant_yn, decode(diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, nvl(PRIMARY_YN,'N')primary_diag, diag_code||nvl2(cause_indicator,'/'||CAUSE_INDICATOR,null)diag_code_desc,to_char(onset_recorded_date,'dd/mm/yyyy') onset_recorded_date  from pr_problem_vw where patient_Id = ? and onset_encounter_id = ? and nvl(problem_status,'O')!='C' and diag_code_scheme like '%' and nvl(error_yn,'N')='N'  and close_date is null  ");
	}


	if(recode_count == 0)
	{
		sql.append(" order by diagtype, onset_date desc ");
	}

	if(recode_count == 0)
	{
		String sql1 = sql.toString();
		pstmt	=	conn.prepareStatement(sql1);
		pstmt.setString(1,PatientId);
		pstmt.setString(2,Encounter_Id);
		rs = pstmt.executeQuery();
	}

	if(recode_count > 0)
	{
		String recode_sql = " SELECT a.added_by_id, TO_CHAR (a.added_date, 'dd/mm/yyyy') added_date, decode(b.diag_type,'P','Provisional','D','Differential','F','Final','') diagtype, TO_CHAR (b.onset_date, 'dd/mm/yyyy') onset_date1, b.DIAG_DESC diag_desc, a.orig_diag_code, b.diag_code diag_code, a.orig_diag_code_scheme DIAG_CODE_SCHEME, b.primary_yn, b.significant_yn significant_yn, TO_CHAR(b.onset_recorded_date, 'dd/mm/yyyy') onset_recorded_date, b.onset_practitioner_id ONSET_PRACTITIONER_NAME, a.recoded_diag_desc , a.recoded_diag_code, a.RECODED_REMARKS recoded_remarks, nvl(b.PRIMARY_YN,'N') primary_diag, b.diag_code||nvl2(b.cause_indicator,'/'||b.CAUSE_INDICATOR,null)diag_code_desc, b.diag_code_scheme_desc, b.srl_no srl_no, b.sensitive_yn sensitive_yn FROM MR_DIAG_RECODING_VW a, PR_PROBLEM_VW b WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+Encounter_Id+"' AND a.patient_id = b.patient_id AND a.srl_no = b.srl_no ORDER BY b.diag_type " ;
		if(rs != null) rs.close();
		recode_stmt	= conn.createStatement();
		rs	= recode_stmt.executeQuery(recode_sql);
	}
%>
<center>
	<table border="0" cellpadding="0" cellspacing="0" align='center' width="100%">
		<tr>
			<td>	
			<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="Patient_ID" value="<%=PatientId%>" />				
			</jsp:include> 			
			</td>
		</tr>
	</table>
	<table border="1" width='100%' id='dataTitleTable' cellpadding='0' cellspacing='0' align='center'>

	<%	if(rs == null)
		{
            for (int x=0; x<6 ; x++)
            {
                if ( k%2 == 0 )
                    classValue = "QRYEVEN" ;
                else
	                classValue = "QRYODD" ;
				
			%>
                <tr>
					<td class='<%=classValue%>'>&nbsp</td>
					<td class='<%=classValue%>'>&nbsp</td>
					<td class='<%=classValue%>'>&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td class='<%=classValue%>'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
				</tr>
			<%  k++;
            }
        }
        else
        {	%>

			<th align='center' width='10%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
			<th align='center' width='10%'><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></th>
			<th align='center' width='35%'><fmt:message key="Common.DiagnosisDescription.label" bundle="${common_labels}"/></th>
			<th align='center' width='20%'><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></th>
			<th align='center' width='10%'><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/></th>
		<%	
			String onset_date		= "";
			String diag_desc		= "";
			String srl_no			= "";
			String sensitive_yn		= "";
			String Recorded_by		= "";
			String recorded_date	= "";

			while(rs.next())
			{
				/*if(recode_count > 0)
				{
					//added_by_id = checkForNull(rs.getString("added_by_id"));
					added_date	= checkForNull(rs.getString("added_date"));
				}*/

				//DIAG_CODE_SCHEME	=	rs.getString("DIAG_CODE_SCHEME");
				onset_date		=	rs.getString("onset_date1");
				Recorded_by		=	checkForNull(rs.getString("ONSET_PRACTITIONER_NAME"));
				recorded_date	=	checkForNull(rs.getString("onset_recorded_date"));
				diag_desc		=	checkForNull(rs.getString("diag_desc"));
				diag_code		=	checkForNull(rs.getString("diag_code"));
				diag_type		=	rs.getString("diagtype");
					if(diag_type == null)	diag_type ="";
				//diag_code_scheme_desc=	rs.getString("diag_code_scheme_desc");
				srl_no 			= 	rs.getString("srl_no");
				sensitive_yn	=	rs.getString("sensitive_yn");
		
				significant_yn	=	rs.getString("significant_yn");
				if(significant_yn==null)	significant_yn  = "N";
				if(diag_code==null)			diag_code		= "&nbsp;";
				if(sensitive_yn!=null)
				{
				   if(sensitive_yn.equals("Y"))
						classValue="PATQRED";
				}
				if(significant_yn.equals("Y"))
				{
					classValue="SIGNIFICANT";
				}
				
				if ((!(diag_type.equals(temp))))
				{
					if (call_function.equals("VIEW_ENCOUNTER_DTLS"))
					{	%>
						<tr>
						<td colspan='14' class='CAGROUPHEADING' align='left'><b><%=diag_type%></b></td>
						</tr>
				<%	}else 
					{	%>
						<tr>
							<td colspan='14' class='CAGROUPHEADING' align='left'><b><%=diag_type%></b></td>
						</tr>
				<% } %>	
					<script>
					srl_no_array[i] = null;
					i++;
					</script>
					<%
				}
				temp=diag_type;

				if ( k%2 == 0 )
					classValue = "QRYEVEN" ;
				 else
					classValue = "QRYODD" ;					

			%>
				<tr style='background-color:;'><td align="center" class='<%=classValue%>'><%=onset_date%></td>
				<td class='<%=classValue%>' ><a name='<%=aname%>'  href=javascript:submitFormrepWEHUADiagQRes('<%=diag_code%>','<%=k%>')><%=diag_code%></a></td>
				<td class='<%=classValue%>'> <a name='<%=aname%>'  href=javascript:submitFormrepWEHUADiagQRes('<%=diag_code%>','<%=k%>')><%=diag_desc%></a></td>
				<td nowrap class='<%=classValue%>' ><%=Recorded_by%></td>
				<td nowrap class='<%=classValue%>' align="center"><%=recorded_date%></td><input type="hidden" name='diag_desc<%=k%>' id='diag_desc<%=k%>' value="<%=diag_desc%>"><input type="hidden" name='onset_dt<%=k%>' id='onset_dt<%=k%>' value="<%=onset_date%>">
			<%	

				out.println("<input type='hidden' name='srl_no"+k+"' id='srl_no"+k+"' value='"+srl_no+"'></td>");
				out.println("</tr>");
				
				%>	<script>
						srl_no_array[i] = <%=srl_no%>
						i++;
					</script>
				<%	k++;
					j++;
			}
				if(rs!=null)    rs.close();
				if(recode_stmt != null) recode_stmt.close();
		}
%>
</table>
</center>

<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>">
<input type="hidden" name="call_function" id="call_function" value="<%=call_function%>">
<input type="hidden" name="PatientId" id="PatientId" value="<%=PatientId%>">
<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=Encounter_Id%>">
<input type="hidden" name="diag_code" id="diag_code" value="<%=diag_code%>">
<input type="hidden" name="recordNo" id="recordNo" value=""> 
<input type="hidden" name="NumRecords" id="NumRecords" value="<%=j%>">
<input type="hidden" name="recode_count" id="recode_count" value="<%=recode_count%>">

<%
}catch(Exception e)
{
	//out.print("ERROR in repWEHUADDiagnosisQueryResult.jsp : "+e);
	e.printStackTrace();
}
finally
{
	try
	{
	if(pstmt!=null)  pstmt.close();
	}
	catch(Exception e)
	{
	}
	ConnectionManager.returnConnection(conn, request);
}
%>
</form>
</body>
</html>

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

