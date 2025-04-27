<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
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
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
	<FORM name = 'ManulOtherfiles_form' >
	<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left'>
		<td class='columheader'><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
		<td class='columheader'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='columheader'><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/></td>
		<td class='columheader'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
	<%
	Connection con				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	String facility_id = "";
	String PateintId	 = "";
	try
	{
		facility_id 	= (String) session.getValue("facility_id");

		PateintId	= request.getParameter("PatientId");
	//	String selLocn		= request.getParameter("selLocn");

		String classValue	= "";
		String bgcolor		= "";
		String curr_fs_locn_identity ="";
		
		StringBuffer SelectSqlBuffer	= null;
		SelectSqlBuffer					= new StringBuffer();

		int i = 0;

		//SelectSqlBuffer.append("select a.file_no,get_patient_line(a.patient_id)patient_line,a.fs_locn_code,a.fs_locn_desc,a.locn_identity_desc,decode(b.curr_file_status,'I','Inside','O','Outside','L','Lost','T','In Transit','A','Archived') curr_file_status, curr_file_status curr_file_status1, b.curr_fs_locn_code,b.curr_fs_locn_desc, b.curr_facility_name, decode(b.curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, DECODE(b.curr_file_status,'I',1,'O',1,'L',3,'T',2,'A',4)order_by_status from fm_mr_pat_file_index_vw a, fm_curr_locn_vw b where a.facility_id = ? and a.patient_id = ? and b.curr_file_status in ('T','L','A','O') and a.fs_locn_code is not null and a.facility_id=b.facility_id and a.file_no=b.file_no  order by order_by_status,a.file_no");
		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  a.File_No" );
		SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') Patient_Line" );
		SelectSqlBuffer.append("  , a.perm_fs_locn_code fs_Locn_Code" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.perm_fs_locn_code,'"+localeName+"',2) fs_locn_desc" );
		SelectSqlBuffer.append("  , a.CURR_FS_LOCN_IDENTITY LOCN_IDENTITY" );
		SelectSqlBuffer.append("  , a.Curr_File_Status Curr_File_Status" );
		SelectSqlBuffer.append("  , a.Curr_File_Status Curr_File_Status1" );
		SelectSqlBuffer.append("  , a.Curr_fs_Locn_Code" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn(a.curr_facility_id,a.Curr_fs_Locn_Code,'"+localeName+"',1) curr_fs_locn_desc" );
		SelectSqlBuffer.append("  , sm_Get_desc.Sm_facility_param(a.FACILITY_ID,'"+localeName+"',1)" );
		SelectSqlBuffer.append("  , a.Curr_fs_Locn_Identity Curr_fs_Locn_Identity" );
		SelectSqlBuffer.append("  , a.Curr_File_Status Order_By_Status " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  fm_Curr_Locn a " );
		SelectSqlBuffer.append("WHERE a.Facility_Id = '"+facility_id+"' " );
		SelectSqlBuffer.append("  AND a.Patient_Id = '"+PateintId+"' " );
		SelectSqlBuffer.append("  AND a.Curr_File_Status IN ('T','L','A','O') " );
		SelectSqlBuffer.append("  AND a.perm_fs_Locn_Code IS" );
		SelectSqlBuffer.append("  NOT NULL " );
		SelectSqlBuffer.append("ORDER BY" );
		SelectSqlBuffer.append("  Order_By_Status" );
		SelectSqlBuffer.append("  , a.File_No" );
		
		pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		pstmt.setString(1,facility_id);
		pstmt.setString(2,PateintId);
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{ 
			if( i % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD";

			if(rs.getString("curr_file_status1").equals("O")) bgcolor	= "ADD8E6";
			else if (rs.getString("curr_file_status1").equals("A")) bgcolor	= "FFEECC";
			else if(rs.getString("curr_file_status1").equals("T")) bgcolor = "CCEEDD";
			else if (rs.getString("curr_file_status1").equals("L")) bgcolor = "FFFFEE";
			else bgcolor = "";

			out.println("<tr><td width=45%  style='background-color:"+bgcolor+"' class='" + classValue + "' ><font size=1><b>");
			out.println( rs.getString("file_no")+"</b><br>&nbsp;&nbsp;"+rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6)+"<input type=hidden name=p_file_no"+i+" value="+rs.getString("file_no")+"");
			out.println("</font></td><td width=20%  class='" + classValue + "'><font size=1>");
			out.println(rs.getString("curr_facility_name"));
			out.println("</font></td><td width=20%  class='" + classValue + "'><font size=1>");
			out.println(rs.getString("fs_locn_desc"));
			out.println("</font></td><td width=15%  class='" + classValue + "'><font size=1>");
			curr_fs_locn_identity = rs.getString("curr_fs_locn_identity");
			
			if(!curr_fs_locn_identity.equals(""))
			{
				switch(curr_fs_locn_identity.charAt(0))
				{
					case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

					case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

					case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

					case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

					case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

					case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

					case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
			
				}
			}

			out.println(rs.getString("curr_fs_locn_desc") +"<br>&nbsp;&nbsp;&nbsp;(" + curr_fs_locn_identity+")");
			out.println("</font></td></tr>");
			
			i++;
		}//endwhile

		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("Exception e :"+e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</TABLE>
</FORM>
</BODY>
</HTML>

