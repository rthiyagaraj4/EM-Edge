<!DOCTYPE html>
<!--
	Created On	: 6/21/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Record Lost/Found
-->
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
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
<script>parent.search_criteria.document.getElementById("hdr_tab1").style.visibility = 'Visible';</script>
<FORM name = 'fm_lost_found_frame' action='' method='post' target='messageFrame'>
<%
	Connection con			= ConnectionManager.getConnection(request);
	//java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

try
{
	stmt						= con.createStatement();
	String facilityid 			= (String) session.getValue("facility_id");
	String sql					= "";
	String more_Criteria		= "";
	String patient_id	        = request.getParameter("patient_id");
	String p_doc_file_no		= request.getParameter("p_doc_file_no");
	String doc_type_code		= request.getParameter("doc_type_code");
	String doc_folder_id		= request.getParameter("doc_folder_id");	
	String appl_user_name		= request.getParameter("appl_user_name");

	if(patient_id == null || patient_id.equals("null")) patient_id = "";
	if(p_doc_file_no == null || p_doc_file_no.equals("null")) p_doc_file_no = "";	
	if(appl_user_name == null || appl_user_name.equals("null")) appl_user_name = "";	
		if(!patient_id.equals("")) 
	{		
		more_Criteria = " AND a.patient_id = '"+patient_id+"' ";
	}
	sql = "select a.file_no,a.patient_id,a.doc_folder_id,a.doc_folder_name,a.doc_type_code,a.doc_type_name,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE  ', ' || GET_PATIENT_LINE(b.PATIENT_ID,'"+localeName+"') END) docline,a.file_type_code,decode(a.curr_file_status,'I','Inside','O','Outside','L','Lost','A','Archived','T','In Transit','E','Extrnal') curr_file_status,a.curr_fs_locn_short_desc curr_fs_locn_desc,nvl(to_char(a.iss_date_time,'dd/mm/rrrr hh24:mi'),'&nbsp;')iss_date_time, nvl(to_char(a.return_date_time,'dd/mm/rrrr hh24:mi'),'&nbsp;') return_date_time,decode(a.curr_fs_locn_identity,'D','Department','T','Practitioner','X','External','C','Clinic','N','Nursing Unit','E','Procedure Unit','Y','Daycare Unit') curr_fs_locn_identity,a.volume_no,c.encounter_id FROM fm_curr_locn_vw a,fm_doc_folder b,FM_ENCOUNTER_DOC_TYPE_LINK c WHERE a.facility_id='"+facilityid+"' and a.facility_id = b.facility_id(+) and a.doc_folder_id = b.doc_folder_id(+) and a.facility_id = c.facility_id and a.file_no = c.file_no and a.doc_type_code='"+doc_type_code+"' and a.doc_folder_id = '"+doc_folder_id+"' "+more_Criteria+" and a.curr_file_status not in('T','R') order by a.doc_folder_id";	
	//and a.file_no = '"+p_doc_file_no+"'
	rs = stmt.executeQuery(sql);	
%>

<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id='tb1'>
<%
int i = 0;
int x=1;

String classValue="";
String p_file_no="";
String p_doc_type_code = "";
String p_doc_folder_id = "";
boolean first_time = false;
while ( rs != null && rs.next() )
{ 	
	if ( i % 2 == 0 )
	  	classValue = "QRYEVEN" ;
	else
	  	classValue = "QRYODD" ;

	p_file_no = "'" + rs.getString("file_no") + "'";

	p_doc_type_code = "'" + rs.getString("doc_type_code") + "'";
	if(p_doc_type_code == null || p_doc_type_code.equals("null")) p_doc_type_code ="";

	p_doc_folder_id = "'" + rs.getString("doc_folder_id") + "'";
	if(p_doc_folder_id == null || p_doc_folder_id.equals("null")) p_doc_folder_id ="";	
	
	String p_ret_date_time =rs.getString("return_date_time");
	if(p_ret_date_time == null || p_ret_date_time.equals("null"))
		p_ret_date_time = "&nbsp;";

	String p_is_date_time =rs.getString("iss_date_time");
	if(p_is_date_time == null || p_is_date_time.equals("null"))
		p_is_date_time = "&nbsp;";

	String doc_type_name =rs.getString("doc_type_name");
	if(doc_type_name == null || doc_type_name.equals("null"))
		doc_type_name = "&nbsp;";

	String patientid =rs.getString("patient_id");
	if(patientid == null || patientid.equals("null"))
		patientid = "";

	String encounter_id =rs.getString("encounter_id");
	if(encounter_id == null || encounter_id.equals("null"))
		encounter_id = "";

	out.println("<tr><td width='28%' class='" + classValue + "' ><font size=1>");
	out.println("<a name="+x+" onClick='changeRowColor(this,7)'  href=javascript:DTcallChangeStatus("+p_file_no+","+p_doc_type_code+","+p_doc_folder_id+")>" + rs.getString("doc_folder_name")+"</a>"+"<input type=hidden name=p_file_no"+i+" value="+rs.getString("file_no")+"><br>&nbsp;&nbsp;"+rs.getString("docline"));
	
	out.println("</font></td><td width='11%' class='" + classValue + "'><font size=1><CENTER>");
	out.println(rs.getString("doc_type_name")+"</CENTER>");

	out.println("</font></td><td width='10%' class='" + classValue + "'><font size=1><CENTER>");
	out.println("<a name="+x+" onClick='changeRowColor(this,7)'  href=javascript:showEncounter("+encounter_id+","+patientid+")>" + rs.getString("patient_id")+"</a>");

	out.println("</font></td><td width='8%'  class='" + classValue + "'><font size=1>");
	out.println(rs.getString("curr_file_status") );
	out.println("</font></td><td width='14%'  class='" + classValue + "'><font size=1>");
	out.println(rs.getString("curr_fs_locn_desc") +" <br> &nbsp;&nbsp;&nbsp; (" + rs.getString("curr_fs_locn_identity") +")");
	out.println("</font></td><td width='14%' class='" + classValue + "'><font size=1>");
	out.println(p_is_date_time);
	out.println("</font></td><td width='15%'  class='" + classValue + "' nowrap><font size=1>");
	out.println(p_ret_date_time);
	out.println("</font></td></tr>");

	first_time = true;
	i++;
	x++;
	
  } //endwhile
	if(first_time)
	{
%>
		<script>
		parent.frames[1].document.forms[0].f_curr_fs_locn.disabled=true;
		parent.frames[1].document.forms[0].appl_user_id.disabled=true;
		</script>
	<%
	}
%>
<script>
	for (i=0;i<6;i++)
	{
		if ((document.getElementById("tb1").rows(i+1) != null) && (document.getElementById("tb1").rows(i+1).cells(i) != null))
		{
			parent.search_criteria.document.getElementById("hdr_tab1").rows(0).cells(i).width = document.getElementById("tb1").rows(i+1).cells(i).width; 
		}
	}
</script>
<input type='hidden' name='p_select_values' id='p_select_values' value=''>
<input type='hidden' name='p_deselect_values' id='p_deselect_values' value=''>
<input type='hidden' name='p_doc_file_no' id='p_doc_file_no' value=''>
<input type='hidden' name='doc_folder_id' id='doc_folder_id' value=''>
<input type='hidden' name='doc_type_no' id='doc_type_no' value=''>
<input type='hidden' name='p_patient_volume_no' id='p_patient_volume_no' value=''>
<input type='hidden' name='p_valtype' id='p_valtype' value=''>
<input type='hidden' name='p_load_select' id='p_load_select' value=''>
<input type='hidden' name='p_load_deselect' id='p_load_deselect' value=''>
<input type='hidden' name='p_total_records' id='p_total_records' value=''>
<input type='hidden' name='p_select_files' id='p_select_files' value=''>
<input type='hidden' name='p_deselect_files' id='p_deselect_files' value=''>
<input type='hidden' name='p_total_select' id='p_total_select' value=''>

</FORM>
</BODY>
<%
if(stmt!=null) stmt.close();
if(rs!=null)	rs.close();
}
catch(Exception e)
{
	out.println("Exception :"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
<script>
	//changeRowColor(document.getElementById("tb1").rows(1)2,5)
</script>
</HTML>

