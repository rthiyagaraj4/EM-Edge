<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
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
	StringBuffer sql		= new StringBuffer();
	String found	= "N";
	String pat_id = "";
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
	String otherFiles = "N";
	String FirstcurrDesc = "";
	String FirstcurrIdDesc = "";
	String FirstcurrStatDesc = "";
	String facility_id = (String) session.getValue("facility_id");
	String Facility = request.getParameter("Facility");
	String Patient = request.getParameter("Patient");

	String incomp_chk = request.getParameter("incomp_chk");
	String lost_chk = request.getParameter("lost_chk");
	String inact_chk = request.getParameter("inact_chk");
	String dflt_incomplete_fs_locn_code = request.getParameter("dflt_incomplete_fs_locn_code");
	String moreCriteria = "";
	int temp = 1;
	
	if (!Patient.equals(""))
	{
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(facility_id);
		String patient_status = patdata.CheckStatus(con,Patient);
		if (patient_status.equals("INVALID_PATIENT"))
		{
	%>
			<script>
//alert('APP-MP0012 Invalid Patient ID');
			var msg = getMessage('INVALID_VALUE','Common'); 
			msg = msg.replace('#',getLabel('Common.patientId.label','Common'));
			alert(msg);
			parent.frames[1].document.forms[0].patient_id.select();
			parent.volumeFrame.document.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
			</script>
	<%		
		}
	}
	
	if(Facility.equals(facility_id))
		moreCriteria = " ISS_YN = 'Y' ";
	else
		moreCriteria = " ISS_ACROSS_FACILITIES_YN = 'Y' ";

		stmt = con.createStatement();
		sql.append("Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External', 'E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,CURR_FACILITY_ID  from FM_CURR_LOCN_VW A where  PATIENT_ID='"+Patient+"' ");
		if(facility_id.equals("HS"))
	   {
		sql.append("and  CURR_FS_LOCN_CODE is not null order by FILE_NO");
		}else{
		
		// sql.append("and exists (select 1 from fm_curr_locn where patient_id = a.patient_id and (facility_id ='"+facility_id+"' or curr_facility_id ='"+facility_id+"'))");
		sql.append("and exists (select 1 from fm_curr_locn where patient_id = a.patient_id )");
		
		}
		//sql = "Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External', 'E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,CURR_FACILITY_ID  from FM_CURR_LOCN_VW A where  PATIENT_ID='"+Patient+"' and A.FACILITY_ID='"+facility_id+"' AND CURR_FS_LOCN_CODE is not null order by FILE_NO";
	
	
		rs = stmt.executeQuery(sql.toString());

		String str = "";
		if(rs != null)
		{
			while (rs.next())
			{
				found = "Y";
				String file_status =(rs.getString("CURR_FILE_STATUS")==null)?"":rs.getString("CURR_FILE_STATUS");

				if(file_status.equals("I") || file_status.equals("O") ||file_status.equals("L") || file_status.equals("A")||file_status.equals("T")||file_status.equals("E"))
				{
					pat_id = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
					file_no =(rs.getString("FILE_NO")==null)?"":rs.getString("FILE_NO");
					str = str + "<option value='"+file_no+"'>"+file_no+"</option>";
					fs_locn =(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");				
					currMrLocn =(rs.getString("CURR_MR_LOCN_YN")==null)?"":rs.getString("CURR_MR_LOCN_YN");
					currLocn =(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");
					currDesc =(rs.getString("CURR_FS_LOCN_DESC")==null)?"":rs.getString("CURR_FS_LOCN_DESC") ;
					currStat =(rs.getString("CURR_FILE_STATUS")==null)?"":rs.getString("CURR_FILE_STATUS");
					currStatDesc
					=(rs.getString("FILE_STATUS_DESC")==null)?"":rs.getString("FILE_STATUS_DESC"); 
				currIden =(rs.getString("CURR_FS_LOCN_IDENTITY")==null)?"":rs.getString("CURR_FS_LOCN_IDENTITY");
				currIdDesc =(rs.getString("LOCN_IDENTITY_DESC")==null)?"":rs.getString("LOCN_IDENTITY_DESC");
					sysdate  =(rs.getString("SYDATE")==null)?"":rs.getString("SYDATE");

					if(temp == 1)
					{
					FirstcurrDesc =(rs.getString("CURR_FS_LOCN_DESC")==null)?"":rs.getString("CURR_FS_LOCN_DESC") ;
					FirstcurrIdDesc =(rs.getString("LOCN_IDENTITY_DESC")==null)?"":rs.getString("LOCN_IDENTITY_DESC");
					FirstcurrStatDesc =(rs.getString("FILE_STATUS_DESC")==null)?"":rs.getString("FILE_STATUS_DESC"); 
					temp++;
					}
				}
				else
					otherFiles = "Y";
			}
		}

		if(found.equals("N"))
		{
%>			<script>
				var errors = getMessage('PATIENT_FILE_NOT_EXIST','FM');	
				parent.frames[1].document.forms[0].patient_id.focus();
				parent.frames[1].document.forms[0].validFile.value ='false';
				parent.volumeFrame.document.location.href="../../eCommon/html/blank.html";
				parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		   	</script>
<%
		}
		else
		{
%>			<script>

				parent.frames[1].document.forms[0].validFile.value ='true';
				parent.frames[1].document.forms[0].currStatDesc.value ='<%=java.net.URLEncoder.encode(currStatDesc)%>';
				parent.frames[1].document.forms[0].currIdDesc.value = '<%=java.net.URLEncoder.encode(currIdDesc)%>';
				parent.frames[1].document.forms[0].Curr_locn_desc.value = '<%=java.net.URLEncoder.encode(currDesc)%>';

				parent.frames[1].document.forms[0].Req_on.value = '<%=sysdate%>';
				parent.frames[1].document.forms[0].Curr_locn_code.value = '<%=currLocn%>';
				parent.frames[1].document.forms[0].Curr_locn_iden.value = '<%=currIden%>';
				parent.frames[1].document.forms[0].Curr_locn_mr_locn.value = '<%=currMrLocn%>';								
				parent.frames[1].showPatientLine();		
				var patient_id			= parent.frames[1].document.forms[0].patient_id.value;
				var file_type_appl_yn	= parent.frames[1].document.forms[0].file_type_appl_yn.value;

			/*	var incomp_chk	= '<%=incomp_chk%>';
				var lost_chk	= '<%=lost_chk%>';
				var inact_chk	= '<%=inact_chk%>';
				var dflt_incomplete_fs_locn_code	= '<%=dflt_incomplete_fs_locn_code%>';  */

				var incomp_chk	= parent.frames[1].document.forms[0].incomp_chk.value;
				var lost_chk	= parent.frames[1].document.forms[0].lost_chk.value;
				var inact_chk	= parent.frames[1].document.forms[0].inact_chk.value;
				var dflt_incomplete_fs_locn_code	= parent.frames[1].document.forms[0].dflt_incomplete_fs_locn_code.value;

			/*	alert("incomp_chk :"+incomp_chk);
				alert("lost_chk :"+lost_chk);
				alert("inact_chk :"+inact_chk);
				alert("dflt_incomplete_fs_locn_code :"+dflt_incomplete_fs_locn_code); */


				
				parent.volumeFrame.location.href="../../eFM/jsp/QueryCurrentFileTypeVolumeNo.jsp?patient_id="+patient_id+"&file_type_appl_yn="+file_type_appl_yn+"&incomp_chk="+incomp_chk+"&lost_chk="+lost_chk+"&inact_chk="+inact_chk+"&dflt_incomplete_fs_locn_code="+dflt_incomplete_fs_locn_code;

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

