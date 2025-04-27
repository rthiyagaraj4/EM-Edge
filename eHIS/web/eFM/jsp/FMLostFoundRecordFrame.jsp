<!DOCTYPE html>
<!--
	Created On	: 6/21/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Record Lost/Found
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*"  contentType="text/html; charset=UTF-8"%>
<%@ page %>
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
	<script language='javascript' src='../../eFM/js/FMLostFound.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<script>parent.search_criteria.document.getElementById("hdr_tab").style.visibility = 'Visible';</script>
<FORM name = 'fm_lost_found_frame' action='' method='post' target='messageFrame'>

<%
//	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;

	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

try
{
	String facilityid 			= (String) session.getValue("facility_id");
		
	String p_concat_string		= "";
	String volumeCriteria       = "";
	String more_Criteria        = "";
	String curr_fac_id="";
	StringBuffer SelectSqlBuffer = null;
	SelectSqlBuffer				 = new StringBuffer();

	String patient_id	        = request.getParameter("patient_id");
	String p_patient_file_no	= request.getParameter("p_patient_file_no");
	String file_type_code	    = request.getParameter("file_type_code");
	String volume_no	        = request.getParameter("volume_no");
	String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
	String appl_user_name		= request.getParameter("appl_user_name");

	int p_count	= 0;

	if(p_patient_file_no == null || p_patient_file_no.equals("null")) p_patient_file_no = "";
	if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
	if(volume_no == null || volume_no.equals("null")) volume_no = "";
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
	if(appl_user_name == null || appl_user_name.equals("null")) appl_user_name = "";

   pstmt = con.prepareStatement("select curr_facility_id from fm_curr_locn where facility_id= ? and patient_id= ? and  file_no= ? and volume_no= ?");
	 pstmt.setString(1,facilityid);
	 pstmt.setString(2,patient_id);
	pstmt.setString(3,p_patient_file_no);
	 pstmt.setString(4,volume_no);
	 rs = pstmt.executeQuery();
	while(rs != null && rs.next()) { 
	curr_fac_id =rs.getString("curr_facility_id");
	}
	
	if(rs!=null)   rs.close();
    if(pstmt!=null) pstmt.close();
	
	if((volume_no != null) && !(volume_no.equals(""))) {
		volumeCriteria = " AND VOLUME_NO = "+volume_no+" ";
	}

	if(file_type_appl_yn.equals("N")) {
		StringTokenizer token=new StringTokenizer(p_patient_file_no,"|");
		while(token.hasMoreTokens()) {
			if(p_count == 0) {
				p_concat_string     = "'" + token.nextToken() +"'";
			}
			else {
				p_concat_string     = p_concat_string + ",'" + token.nextToken() +"'";
			}
			p_count++;
		}
		more_Criteria = " AND FILE_NO in ('"+p_patient_file_no+"') ";
	}
	else if(file_type_appl_yn.equals("Y")) {
		StringTokenizer token=new StringTokenizer(file_type_code,"|");
		while(token.hasMoreTokens()) {
			if(p_count ==0) {
				p_concat_string     = "'" + token.nextToken() +"'";
			}
			else {
				p_concat_string     = p_concat_string + ",'" + token.nextToken() +"'";
			}
			p_count++;
		}
		more_Criteria = " AND FILE_TYPE_CODE in ('"+file_type_code+"') ";
	}

	//SelectSqlBuffer.append("select a.file_no,a.file_type_code,a.file_type_desc,get_patient_line(a.patient_id) patient_line,decode(a.curr_file_status,'I','Inside','O','Outside','L','Lost','A','Archived','T','In Transit','E','Extrnal')curr_file_status,a.curr_fs_locn_short_desc curr_fs_locn_desc,nvl(to_char(a.iss_date_time,'dd/mm/rrrr hh24:mi'),'&nbsp;')iss_date_time, nvl(to_char(a.return_date_time,'dd/mm/rrrr hh24:mi'),'&nbsp;') return_date_time,decode(a.curr_fs_locn_identity,'D','Department','T','Practitioner','X','External','C','Clinic','N','Nursing Unit','E','Procedure Unit','Y','Daycare Unit') curr_fs_locn_identity,a.volume_no from fm_curr_locn_vw a where a.facility_id = ? "+more_Criteria+" and a.patient_id = ? "+volumeCriteria+" and a.curr_file_status not in('T','R') order by a.file_no,a.volume_no");

	SelectSqlBuffer.append("SELECT" );
	SelectSqlBuffer.append("  a.File_No" );
	SelectSqlBuffer.append("  , a.File_Type_Code" );
	SelectSqlBuffer.append("  , MR_GET_DESC.MR_FILE_TYPE(A.FACILITY_ID, A.FILE_TYPE_CODE,'"+localeName+"','2') File_Type_desc" );
	SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') Patient_Line" );
	SelectSqlBuffer.append("  , a.Curr_File_Status Curr_File_Status" );
	SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+curr_fac_id+"',a.Curr_fs_Locn_Code,'"+localeName+"',2) Curr_fs_Locn_desc" );
	SelectSqlBuffer.append("  , Nvl(TO_CHAR(a.Iss_Date_Time,'dd/mm/rrrr hh24:mi'),'&nbsp;') Iss_Date_Time" );
	SelectSqlBuffer.append("  , Nvl(TO_CHAR(a.Return_Date_Time,'dd/mm/rrrr hh24:mi'),'&nbsp;') Return_Date_Time" );
	SelectSqlBuffer.append("  , a.Curr_fs_Locn_Identity Curr_fs_Locn_Identity" );
	SelectSqlBuffer.append("  , a.Volume_No " );
	SelectSqlBuffer.append("FROM" );
	SelectSqlBuffer.append("  fm_Curr_Locn a " );
	SelectSqlBuffer.append("WHERE a.Facility_Id = ? " );
	SelectSqlBuffer.append(more_Criteria);
	SelectSqlBuffer.append("  AND a.Patient_Id = ? " );
	SelectSqlBuffer.append(volumeCriteria );
	SelectSqlBuffer.append("  AND a.Curr_File_Status NOT IN ('T','R') " );
	SelectSqlBuffer.append("ORDER BY" );
	SelectSqlBuffer.append("  a.File_No" );
	SelectSqlBuffer.append("  , a.Volume_No" );
    pstmt = con.prepareStatement(SelectSqlBuffer.toString());
	pstmt.setString(1,facilityid);
	pstmt.setString(2,patient_id);
	rs = pstmt.executeQuery();
%>

<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id='tb1'>
<%
int i			= 0;
int x			= 1;

String classValue			= "";
String p_file_no			= "";
String p_file_type_code		= "";
String p_volume_no			= "";
String p_file_type_desc		= "";

boolean first_time = false;

while(rs != null && rs.next()) { 
	if(i % 2 == 0) classValue = "QRYEVEN";
	else classValue = "QRYODD";

	p_file_no = "'" + rs.getString("file_no") + "'";
	
	p_file_type_code = "'" + rs.getString("file_type_code") + "'";
	if(p_file_type_code == null || p_file_type_code.equals("null")) p_file_type_code="";
	
	p_volume_no = "'" + rs.getString("volume_no") + "'";
	if(p_volume_no == null || p_volume_no.equals("null")) p_volume_no="";
	
	String p_ret_date_time =rs.getString("return_date_time");
	if(p_ret_date_time == null || p_ret_date_time.equals("null")) p_ret_date_time = "&nbsp;";

	String p_is_date_time =rs.getString("iss_date_time");
	if(p_is_date_time == null || p_is_date_time.equals("null")) p_is_date_time = "&nbsp;";

	if(!p_is_date_time.equals("&nbsp;")) p_is_date_time=DateUtils.convertDate(p_is_date_time,"DMYHM","en",localeName);

	if(!p_ret_date_time.equals("&nbsp;"))	p_ret_date_time=DateUtils.convertDate(p_ret_date_time,"DMYHM","en",localeName);


	String curr_fs_locn_identity=rs.getString("curr_fs_locn_identity");
	String curr_file_status=rs.getString("curr_file_status");

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
			if(!curr_file_status.equals(""))
			{
				switch(curr_file_status.charAt(0))
				{
					case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'E' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;
			
				}
			}
			

	if(file_type_appl_yn.equals("Y")) {
		
		out.println("<tr><td width='33%' class='" + classValue + "' ><font size=1>");
	out.println(rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6)+"</a>"+"<input type=hidden name=p_file_no"+i+" value="+rs.getString("file_no")+">" );	
		
		out.println("</font></td><td width='16%' class='" + classValue + "'><font size=1><CENTER>");
		p_file_type_desc = rs.getString("file_type_desc");
		if(p_file_type_desc == null || p_file_type_desc.equals("null")) {
			p_file_type_desc = "&nbsp;";
		}
		out.println(p_file_type_desc);
		if(!p_file_type_desc.equals("&nbsp;")) {
			out.println(" / ");
		}
	}
	else if (file_type_appl_yn.equals("N")) {
		out.println("<tr><td width='38%' class='" + classValue + "' ><font size=1>");
		out.println("<input type=hidden name=p_file_no"+i+" value="+rs.getString("file_no")+"><br>&nbsp;&nbsp;"+rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6) );
		
		out.println("</font></td><td width='11%' class='" + classValue + "'><font size=1><CENTER>");
		p_file_type_desc = rs.getString("file_type_desc");
		if(p_file_type_desc == null || p_file_type_desc.equals("null")) {
			p_file_type_desc = "&nbsp;";
		}
		out.println(p_file_type_desc);
		if(!p_file_type_desc.equals("&nbsp;")) {
			out.println(" / ");
		}
	}
	out.println(rs.getString("volume_no")+"</CENTER>");
	out.println("</font></td><td width='8%' class='" + classValue + "'><font size=1>");
	out.println(curr_file_status );
	out.println("</font></td><td width='14%' class='" + classValue + "'><font size=1>");
	out.println(rs.getString("curr_fs_locn_desc") +" <br> &nbsp;&nbsp;&nbsp; (" + curr_fs_locn_identity +")");
	out.println("</font></td><td width='14%' class='" + classValue + "'><font size=1>");
	out.println(p_is_date_time);
	out.println("</font></td><td width='15%' align='center' class='" + classValue + "' nowrap><font size=1>");
	out.println(p_ret_date_time);
	out.println("</font></td></tr>");

	first_time = true;
	i++;
	x++;
	
} //endwhile

if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0)) {
	SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
}

if(first_time) {
	%>
	<script>
	if(parent.frames[1].document.forms[0].patient_id!=null)
		{
		parent.frames[1].document.forms[0].pat_search.disabled=true;
		}
		parent.frames[1].document.forms[0].f_curr_fs_locn.disabled=true;
		parent.frames[1].document.forms[0].patient_id.disabled=true;
		if(parent.frames[1].document.forms[0].file_no !=null)
			parent.frames[1].document.forms[0].file_no.disabled=true;
		if(parent.frames[1].document.forms[0].file_type_code !=null)
			parent.frames[1].document.forms[0].file_type_code.disabled=true;
		parent.frames[1].document.forms[0].appl_user_id.disabled=true;
	</script>
	<%
}
%>
<script>
	for (i=0;i<6;i++) {
		if((document.getElementById("tb1").rows(i+1) != null) && (document.getElementById("tb1").rows(i+1).cells(i) != null)) {
			parent.search_criteria.document.getElementById("hdr_tab").rows(0).cells(i).width = document.getElementById("tb1").rows(i+1).cells(i).width; 
		}
	}
</script>
	<input type='hidden' name='p_select_values' id='p_select_values' value=''>
	<input type='hidden' name='p_deselect_values' id='p_deselect_values' value=''>
	<input type='hidden' name='p_patient_file_no' id='p_patient_file_no' value=''>
	<input type='hidden' name='p_patient_volume_no' id='p_patient_volume_no' value=''>
	<input type='hidden' name='p_patient_file_type_code' id='p_patient_file_type_code' value=''>
	<input type='hidden' name='p_valtype' id='p_valtype' value=''>
	<input type='hidden' name='p_load_select' id='p_load_select' value=''>
	<input type='hidden' name='p_load_deselect' id='p_load_deselect' value=''>
	<input type='hidden' name='p_total_records' id='p_total_records' value=''>
	<input type='hidden' name='p_select_files' id='p_select_files' value=''>
	<input type='hidden' name='p_deselect_files' id='p_deselect_files' value=''>
	<input type='hidden' name='p_total_select' id='p_total_select' value=''>
	<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
</FORM>
</BODY>
<%
if(rs!=null)   rs.close();
if(pstmt!=null) pstmt.close();
}catch(Exception e){out.println("Exception :"+e.toString());}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</HTML>

