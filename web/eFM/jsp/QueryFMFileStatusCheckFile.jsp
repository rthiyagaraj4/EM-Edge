<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body class='message' onKeyDown = 'lockKey()' >
<form name="checkvals" id="checkvals">
<%
	Connection con = ConnectionManager.getConnection(request);
	Statement stmt = null;
	ResultSet rs   = null;

try
{
	String sql		= "";
	
	String pat_id = "";
	String pat_line = "";
	String file_no = "";
	String fs_locn = "";
	String currLocn = "";
	String currDesc = "";
	String currStat = "";
	String currStatDesc = "";
	String currIden = "";
	String currIdDesc = "";
	String currMrLocn = "";
	String sysdate	= "";

	String facility_id = (String) session.getValue("facility_id");
	String FileNo = request.getParameter("FileNo");
	String Facility = request.getParameter("Facility");
	String moreCriteria = "";

	if(Facility.equals(facility_id))
		moreCriteria = " ISS_YN = 'Y' ";
	else
		moreCriteria = " ISS_ACROSS_FACILITIES_YN = 'Y' ";

		stmt = con.createStatement();
		sql = "Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External', 'E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW A where FILE_NO='"+FileNo+"' and  A.FACILITY_ID='"+facility_id+"' AND CURR_FS_LOCN_CODE is not null ";
		rs = stmt.executeQuery(sql);

		if(rs != null)
		{
			while (rs.next())
			{
				pat_id = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
				file_no =(rs.getString("FILE_NO")==null)?"":rs.getString("FILE_NO");
				fs_locn =(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");
				pat_line =(rs.getString("PLINE")==null)?"":rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
				currMrLocn=(rs.getString("CURR_MR_LOCN_YN")==null)?"":rs.getString("CURR_MR_LOCN_YN");
				currLocn =(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");
				currDesc =(rs.getString("CURR_FS_LOCN_DESC")==null)?"":rs.getString("CURR_FS_LOCN_DESC");
				currStat =(rs.getString("CURR_FILE_STATUS")==null)?"":rs.getString("CURR_FILE_STATUS");
				currStatDesc =(rs.getString("FILE_STATUS_DESC")==null)?"":rs.getString("FILE_STATUS_DESC"); 
				currIden =(rs.getString("CURR_FS_LOCN_IDENTITY")==null)?"":rs.getString("CURR_FS_LOCN_IDENTITY");
				currIdDesc =(rs.getString("LOCN_IDENTITY_DESC")==null)?"":rs.getString("LOCN_IDENTITY_DESC");
				sysdate  =(rs.getString("SYDATE")==null)?"":rs.getString("SYDATE");
			}
			if(fs_locn == null || fs_locn.equals("null"))
				fs_locn = "";
		}

		if(file_no.equals(""))
		{
%>			<script>
				var errors = getMessage("PATIENT_FILE_NOT_EXIST","FM");
				parent.frames[1].document.forms[0].fileno.focus();
				parent.frames[1].document.forms[0].validFile.value ='false';
					parent.frames[1].document.getElementById("PatientDetail").innerHTML =  "&nbsp;" ;
				parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			</script>
<%
		}
		else
		{
%>			<script>

				if('<%=fs_locn%>' == "")
				{
					var errors = getMessage('FILES_NO_STORAGE_LOCATION','FM');
					parent.frames[1].document.forms[0].fileno.focus();
					parent.frames[1].document.forms[0].validFile.value ='false';
				}
				else
				{
				parent.frames[1].document.forms[0].patientid.value = '<%=pat_id%>';
				parent.frames[1].document.forms[0].currfilelocn.value = '<%=java.net.URLEncoder.encode(currDesc)%> (<%=java.net.URLEncoder.encode(currIdDesc)%>)';
				parent.frames[1].document.forms[0].currIdDesc.value = '<%=java.net.URLEncoder.encode(currIdDesc)%>';
				parent.frames[1].document.forms[0].Curr_locn_desc.value = '<%=java.net.URLEncoder.encode(currDesc)%>';
				parent.frames[1].document.forms[0].validFile.value ='true';	

				parent.frames[1].document.forms[0].Req_on.value = '<%=sysdate%>';
				parent.frames[1].document.forms[0].Curr_locn_code.value = '<%=currLocn%>';
		
				parent.frames[1].document.forms[0].Curr_locn_iden.value = '<%=currIden%>';
				parent.frames[1].document.forms[0].Curr_locn_mr_locn.value = '<%=currMrLocn%>';					
		
				parent.frames[1].document.forms[0].currStatDesc.value ='<%=currStatDesc%>';
				parent.frames[1].showPatientLine();		
				}
			</script>
<%
		}
	if (rs!=null) rs.close();
	if (stmt!=null) stmt.close();
}
catch(Exception e)
{ out.println("In Exception :"+e.toString()); }
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

