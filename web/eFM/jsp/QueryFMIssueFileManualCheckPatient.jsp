<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form name="checkvals" id="checkvals">
<%
	Connection con = ConnectionManager.getConnection(request);
	Statement stmt = null;
	ResultSet rs   = null;



try
{
	String sql		= "";
	String found	= "N";
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
	String CURR_FACILITY_NAME = "" ;
	

	String facility_id = (String) session.getValue("facility_id");
	String Facility = request.getParameter("Facility");
	String queryCriteria = request.getParameter("Patient");
	String moreCriteria = "";
	int index = 0;	
	
	if(Facility.equals(facility_id))
		moreCriteria = " ISS_YN = 'Y' ";
	else
		moreCriteria = " ISS_ACROSS_FACILITIES_YN = 'Y' ";

		stmt = con.createStatement();		
		

		 sql = "Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External', 'E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || A.CURR_FACILITY_NAME ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN_VW A where PATIENT_ID='"+queryCriteria+"' and  A.FACILITY_ID='"+facility_id+"' AND CURR_FS_LOCN_CODE is not null ";
		
	

	 rs = stmt.executeQuery(sql);
	  	String str = "";
		if(rs != null)
		{
			while (rs.next())
			{
				found = "Y"; 
				pat_id = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
				file_no =(rs.getString("FILE_NO")==null)?"":rs.getString("FILE_NO");
				str=str + "<option value='"+file_no+"'>"+file_no+"</option>";
				fs_locn = (rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");
				pat_line = (rs.getString("PLINE")==null)?"":rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
				currMrLocn =(rs.getString("CURR_MR_LOCN_YN")==null)?"":rs.getString("CURR_MR_LOCN_YN");
				currLocn =(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");
				currDesc =(rs.getString("CURR_FS_LOCN_DESC")==null)?"":rs.getString("CURR_FS_LOCN_DESC");
				currStat =(rs.getString("CURR_FILE_STATUS")==null)?"":rs.getString("CURR_FILE_STATUS");
				%>
				<script>				
				parent.frames[1].currFileStatus1[<%=index%>]='<%=currStat%>';
				</script>
				<%currStatDesc = (rs.getString("FILE_STATUS_DESC")==null)?"":rs.getString("FILE_STATUS_DESC"); 
				currIden =(rs.getString("CURR_FS_LOCN_IDENTITY")==null)?"":rs.getString("CURR_FS_LOCN_IDENTITY");
			 currIdDesc=(rs.getString("LOCN_IDENTITY_DESC")==null)?"":rs.getString("LOCN_IDENTITY_DESC");
				sysdate = (rs.getString("SYDATE")==null)?"":rs.getString("SYDATE");
				CURR_FACILITY_NAME =(rs.getString("CURR_FACILITY_NAME")==null)?"":rs.getString("CURR_FACILITY_NAME");
				index = index +  1;
			}
			if(fs_locn == null || fs_locn.equals("null"))
				fs_locn = "";
		}		
		
		if(found.equals("N"))
		{
%>			<script>
				var errors = getMessage('PATIENT_FILE_NOT_EXIST','FM');	
				parent.frames[1].document.forms[0].patientid.focus();
				parent.frames[1].document.forms[0].validFile.value ='false';
					parent.frames[1].document.getElementById("PatientDetail").innerHTML =  "&nbsp;" ;
				parent.frames[1].document.getElementById("fileid").innerHTML="<input type='text' name='fileno' id='fileno' tabIndex='2' size='20' maxlength='20' value='' onBlur='ChangeUpperCase(this);CheckFileExists(this.value);' >";
				parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		   	</script>
<%
		}
		else
		{
%>			<script>

				parent.frames[1].document.getElementById("fileid").innerHTML="<select name=fileno tabIndex='2'><%=str%></select>";
				parent.frames[1].document.forms[0].validFile.value ='true';
				parent.frames[1].document.forms[0].currStatDesc.value ='<%=java.net.URLEncoder.encode(currStatDesc)%>';
				parent.frames[1].document.forms[0].currIdDesc.value = '<%=java.net.URLEncoder.encode(currIdDesc)%>';
				parent.frames[1].document.forms[0].Curr_locn_desc.value = '<%=java.net.URLEncoder.encode(currDesc)%>';

				parent.frames[1].document.forms[0].Req_on.value = '<%=sysdate%>';
				parent.frames[1].document.forms[0].Curr_locn_code.value = '<%=currLocn%>';
				parent.frames[1].document.forms[0].Curr_locn_iden.value = '<%=currIden%>';
				parent.frames[1].document.forms[0].Curr_locn_mr_locn.value = '<%=currMrLocn%>';	
				parent.frames[1].document.forms[0].CURR_FACILITY_NAME.value = '<%=java.net.URLEncoder.encode(CURR_FACILITY_NAME)%>';		
			
				parent.frames[1].showPatientLine();		
			
		</script>

<%
		}
if (stmt!=null) stmt.close();
if (rs!=null) rs.close();
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

