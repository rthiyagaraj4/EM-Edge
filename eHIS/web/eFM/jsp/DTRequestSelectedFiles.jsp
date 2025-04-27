<!DOCTYPE html>
?<!--
	Created On	: 9/15/2004
	Created By	: Kiran K K.
	Module		: Document Tracking (DT)
	Function	: Request of Document

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
	<script language='javascript' src='../../eFM/js/FMRequestFile.js'></script>
</head>

<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_select_form' method='get' target='messageFrame'>
<%
	Connection con = ConnectionManager.getConnection(request);
//	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
	Statement stmt		= null;	
	ResultSet rs		= null;
	
try
{

	stmt						= con.createStatement();
	StringBuffer SelectSqlBuffer = null;
	SelectSqlBuffer				 = new StringBuffer();	
	String p_stored_val			= request.getParameter("p_select_files");	
//	out.println("<script language='JavaScript'>alert('p_stored_val"+p_stored_val+"');</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
	String p_not_in_files		= request.getParameter("p_deselect_files");
	String p_include_in_select	= request.getParameter("p_include_in_select");
	String p_enter_fcy			= request.getParameter("p_enter_fcy");
	String p_req_fs_locn		= request.getParameter("p_req_fs_locn");
	String conc_remarks		 	= request.getParameter("conc_remarks");
	String added_volumes	 	= request.getParameter("added_volumes");
	String file_type_appl_yn 	= request.getParameter("file_type_appl_yn");
	if(added_volumes==null)  added_volumes = "";
	if(file_type_appl_yn==null)  added_volumes = "N";
	conc_remarks = java.net.URLDecoder.decode(conc_remarks);
	added_volumes = java.net.URLDecoder.decode(added_volumes);
	HashMap hash	= new HashMap();

	if (!(conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null")  )) {
		StringTokenizer st = new StringTokenizer(conc_remarks, "`");

		while(st.hasMoreTokens()) {
			hash.put(st.nextToken(), st.nextToken());

		}
	}

	String p_select_values		= "";
	String p_added_values		= "";
	String p_concat_string		= "";
	String p_files_not_in		= "";
	int p_count = 0;	

	if (p_not_in_files==null) p_not_in_files="";
	if (p_include_in_select==null) p_include_in_select="";
	if (p_req_fs_locn==null) p_req_fs_locn="";

	StringTokenizer token=new StringTokenizer(p_stored_val,"|");

	while(token.hasMoreTokens())
		{
				if (p_count ==0 )
				{
					p_concat_string     = "'" + token.nextToken() +"'";
				}
				else
				{
					p_concat_string     = p_concat_string + ",'" + token.nextToken() +"'";
				}
				p_count++;
		}			

		p_count=0;

	if (!p_not_in_files.equals(""))
	{
		StringTokenizer token1=new StringTokenizer(p_not_in_files,"|");
		String getTokenValue="";

		while(token1.hasMoreTokens())
			{
				getTokenValue = token1.nextToken();

					if (p_count ==0 )
					{
						p_files_not_in     = "'" + getTokenValue +"'";
					}
					else
					{
						p_files_not_in     = p_files_not_in + ",'" + getTokenValue +"'";
					}
					p_count++;
			}
	}

		SelectSqlBuffer.append("select a.file_no,a.facility_id,a.patient_id,  a.fs_locn_short_desc, decode(a.curr_file_status,'I','Inside','O','Outside','L','Lost','T','In Transit','A','Archived','E','Other Facility', 'R', 'Returned')curr_file_status,(case when a.curr_fs_locn_code = '"+p_req_fs_locn+"' then 'X' else a.curr_file_status end)curr_file_status1, a.curr_fs_locn_short_desc, decode(a.curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, (CASE WHEN a.curr_fs_locn_code = '"+p_req_fs_locn+"' THEN  6 ELSE  DECODE(a.curr_file_status,'I',1,'O',1,'L',4,'T',2,'A',5,'E',3) END) order_by_status, (case when a.curr_facility_id <> '"+p_enter_fcy+"' then '(' || a.curr_facility_name || ')' else '&nbsp;' end)other_facility_name, a.volume_no, a.file_type_code,  a.doc_folder_id doc_folder_id, a.doc_folder_name, a.doc_type_name, a.doc_type_code, (CASE WHEN b.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(b.from_period,'dd/mm/rrrr ')|| ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE ', ' || decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) END)doc_type ,c.encounter_id,a.patient_name FROM fm_curr_locn_vw a,fm_doc_folder b,FM_ENCOUNTER_DOC_TYPE_LINK c where a.file_no in("+p_concat_string+") ");	
		SelectSqlBuffer.append(" and a.doc_folder_id = b.doc_folder_id(+) and a.facility_id = b.facility_id(+) and a.facility_id = c.facility_id and a.file_no = c.file_no and a.facility_id='"+p_enter_fcy+"' order by order_by_status,a.file_no ");
	
	rs = stmt.executeQuery(SelectSqlBuffer.toString());

%>
<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id="srch_result">

<%
int i = 1;
int p_rec_cnt = 0;

String classValue="";
String bgcolor="";
String p_allow_select="";
String p_checked="";
int p_request_cnt=0;
int p_not_request_cnt=0;
String doc_folder_id = "", doc_folder_name = "", doc_type_name = "", doc_type="", doc_type_code = "";
String doc_patient = "";
String encounter_id = "";
String patient_name = "";
String doc_file_no = "";
%>
<script>parent.frames[3].document.getElementById("hdr_tab").style.visibility='Visible';</script>
<%


while ( rs.next() )
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
	if (rs.getString("curr_file_status1").equals("A"))
	{
		bgcolor			= "FFEECC";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("T"))
	{
		bgcolor = "CCEEDD";
		p_allow_select	= "";
		p_checked		= "";

	}
	else if (rs.getString("curr_file_status1").equals("L"))
	{
		bgcolor = "FFFFEE";
		p_allow_select	= "disabled";
		p_checked		= "";

	}
	else if (rs.getString("curr_file_status1").equals("X"))
	{
		bgcolor = "ADD8E6";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("E"))
	{
		bgcolor = "E0FFFF";
		p_allow_select	= "";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("O"))
	{
		bgcolor = "#D1BBA7";
		p_allow_select	= "";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("R"))
	{
		bgcolor = "#C0C0C0";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else
	{
		bgcolor = "";
		p_allow_select	= "";
		p_checked		= "";
	}
	doc_folder_id = checkForNull(rs.getString("doc_folder_id"));
	doc_folder_name = checkForNull(rs.getString("doc_folder_name"));
	doc_type_name = checkForNull(rs.getString("doc_type_name"));
	doc_type = checkForNull(rs.getString("doc_type"));
	doc_type_code = checkForNull(rs.getString("doc_type_code"));
	doc_patient = checkForNull(rs.getString("patient_id"));
	encounter_id = checkForNull(rs.getString("encounter_id"));
	patient_name = checkForNull(rs.getString("patient_name"));
	doc_file_no = checkForNull(rs.getString("file_no"));


		
	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O") || rs.getString("curr_file_status1").equals("T"))
	{
		if (p_request_cnt==0)
		{
%>
		<TR>
			<Td colspan = '9' class='columnheader'><b><h5><font size=1><fmt:message key="Common.Requested.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.documents.label" bundle="${common_labels}"/></font></Td>
		</TR>
<%		}
		p_request_cnt++;

	}

	if (rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A"))
	{
		if (p_not_request_cnt==0)
		{
			if (p_request_cnt>0)
			{
%>
		<TR>
			<Td colspan = '9' class='columnheader'><b><h5><font size=1><fmt:message key="eFM.Documentscannotberequested.label" bundle="${fm_labels}"/></font></Td>
		</TR>
<%
			}
			else
			{
%>
		<TR>
			<Td colspan = '9' class='columnheader'><b><h5><font size=1><fmt:message key="eFM.Documentscannotberequested.label" bundle="${fm_labels}"/></font></Td>
		</TR>
<%
			}
		}

		p_not_request_cnt++;
	}

%>

	<tr>

	<td width="15%"  class="<%= classValue %>" ><input type=hidden name=p_file_no<%= i %> value=<%= rs.getString("file_no") %>`<%=rs.getString("facility_id") %>>&nbsp;<input type=hidden name=p_doc_folder_id<%=i%> value=<%=doc_folder_id%>><input type=hidden name=p_doc_type_code<%= i %> value=<%=doc_type_code%>><font size=1><b><%=doc_folder_name%></b><br>&nbsp;<%=doc_type%></font></td>
	<td width="8%"  class="<%= classValue %>" ><font size=1><%=doc_type_name%><input type='hidden' name="file_type<%=i%>" id="file_type<%=i%>" value="<%= rs.getString("file_type_code")%>"><input type='hidden' name="p_volume_no<%=i%>" id="p_volume_no<%=i%>" value="<%=rs.getString("volume_no")%>"><input type='hidden' name="p_patient_id<%=i%>" id="p_patient_id<%=i%>" value="<%=rs.getString("patient_id")%>"></font></td>
	<td width="14%"  class="<%= classValue %>" ><font size=1><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="callPatDetails('<%=doc_patient%>')">&nbsp;<%=doc_patient%>&nbsp;</A><BR><%=patient_name%></font></td>
	<td width="12%"  class="<%= classValue %>" ><font size=1><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="showEncounter('<%=encounter_id%>','<%=doc_patient%>','<%=doc_file_no%>')">&nbsp;<%=encounter_id%></A></font></td>
<%
	
	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("T") ||rs.getString("curr_file_status1").equals("O")) {
		if (conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null") || conc_remarks.equals("") ) {
%>
	</font></td><td width='8%' align="CENTER" class="<%= classValue %>"><font size=1><a href="javascript:GetRemarks(<%= i %>)"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td><td width='13%'  class="<%= classValue %>"><font size=1><input type="hidden" name="rem_recnum_<%= i %>" id="rem_recnum_<%= i %>" value="">
<%
		}
		else {
			String tempstr = (String)hash.get(rs.getString("file_no")) ;
			if (tempstr == null || tempstr.equals(":|:")) tempstr = "";
%>
			</font></td><td width='8%' align="CENTER" class="<%= classValue %>"><font size=1><a href="javascript:GetRemarks(<%= i %>)"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td><td width="13%"  class="<%= classValue %>"><font size=1><input type="hidden" name="rem_recnum_<%= i %>" id="rem_recnum_<%= i %>" value="<%= tempstr %>">
<%
		}
	}
	else {
%>
		</font></td><td width="8%" class="<%= classValue %>"><font size=1>&nbsp;&nbsp;</font></td><td width="13%"  class="<%= classValue %>"><font size=1><input type="hidden" name="rem_recnum_<%=i%>" id="rem_recnum_<%=i%>" value="">
<%
	}
%>
	<%= rs.getString("fs_locn_short_desc") %></font></td><td width='13%'  class="<%= classValue %>"><font size=1>
	<%= rs.getString("curr_fs_locn_short_desc") %> <br> &nbsp;&nbsp;(<%= rs.getString("curr_fs_locn_identity") %>)
	</font></td><td width='9%'  class="<%= classValue %>"><font size=1>
	<%= (rs.getString("curr_file_status")==null)?"&nbsp;":rs.getString("curr_file_status") %> <br><%= rs.getString("other_facility_name") %>
	</font></td><td width='8%' align="center" style="background-color:<%= bgcolor %>" class="<%= classValue %>"><font size=1>
	<input type=checkbox name=req_select<%= i %> <%= p_checked %> <%= p_allow_select %> value="Y">
	</font></td></tr>

<%
	if (p_select_values=="")
	{
		p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	else
	{
		p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	if (p_added_values=="")
	{
		p_added_values = rs.getString("file_no")+"$$"+rs.getString("volume_no");
	}
	else
	{
		p_added_values = p_added_values + '|' + rs.getString("file_no")+"$$"+rs.getString("volume_no");
	}
	i++;
	p_rec_cnt++;

  } //endwhile


%>
</TABLE>
<script>
//	parent.frames[3].document.forms[0].p_patient_id.value="";
//	parent.frames[3].document.forms[0].doc_folder_id.value="";
//	parent.frames[3].document.forms[0].doc_folder_desc.value="";

	parent.frames[3].document.forms[0].p_deselect_values.value = "<%=p_not_in_files%>";
	var old_value = parent.frames[3].document.forms[0].added_values.value;
	if (old_value != "")
		old_value += "|"+"<%=p_added_values%>";
	else old_value = "<%=p_added_values%>";
	parent.frames[3].document.forms[0].added_values.value=old_value;
	parent.frames[3].document.forms[0].p_select_values.value = "<%=p_stored_val%>";
	parent.frames[3].document.forms[0].p_total_records.value = "<%=p_rec_cnt%>";

	var p_in_files		= parent.frames[3].document.forms[0].p_select_values.value;
	var p_not_files	= parent.frames[3].document.forms[0].p_deselect_values.value;

	HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form2' id='form2' method='post' action='../../eFM/jsp/FMRequestDeSelectedFiles.jsp'><input name='p_new_string' id='p_new_string' type='hidden' value="+p_in_files+"><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_not_files+"></form></BODY></HTML>";

	parent.frames[3].document.forms[0].p_total_select.value = '<%=p_rec_cnt%>';
	for (i=0;i<7;i++)
	{
		if ((document.getElementById("srch_result").rows(i+1) != null) && (document.getElementById("srch_result").rows(i+1).cells(i) != null))
		{
			parent.frames[3].document.getElementById("hdr_tab").rows(0).cells(i).width = document.getElementById("srch_result").rows(i+1).cells(i).width; 
		}
	}

</script>
<input type='hidden' name=p_select_values value='<%=p_select_values%>'>
<input type='hidden' name=p_total_select value='<%=p_rec_cnt%>'>

</FORM>
</BODY>
<%
	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}
	if(stmt!=null) stmt.close();
	if(rs!=null)	rs.close();
}
catch(Exception e)
{}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}

%>

