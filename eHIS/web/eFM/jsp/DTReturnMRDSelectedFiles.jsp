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
	<script language='javascript' src='../../eFM/js/FMReturnMRDFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_select_form' action='../../servlet/eFM.FMParameterServlet' method='post' target='messageFrame'>
<%
	Connection con = ConnectionManager.getConnection(request);
	//java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
	PreparedStatement pstmt	= null;
	ResultSet rs		= null;

	StringBuffer SelectSqlBuffer	= null;

	String p_select_values		= "";
	String p_concat_string		= "";
	String p_files_not_in		= "";
	int p_count = 0;

try
{	
	SelectSqlBuffer				= new StringBuffer();
	String facilityid 			= (String) session.getValue("facility_id");	
	String p_stored_val			= request.getParameter("p_select_files");	
	String p_not_in_files		= request.getParameter("p_deselect_files");
	String added_volumes		= request.getParameter("added_volumes");
	String p_include_in_select	= request.getParameter("p_include_in_select");
	String curr_fstat			= request.getParameter("curr_fstat");
	String p_outst_fcy			= request.getParameter("p_outst_fcy");
	String p_fs_locn_id			= request.getParameter("p_fs_locn_id");
	String p_out_fsloc			= request.getParameter("p_out_fsloc");
	String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
	
//	String doc_or_file			= request.getParameter("doc_or_file")==null?"":request.getParameter("doc_or_file");	
	
	String p_fs_location = request.getParameter("p_fs_location")==null?"":request.getParameter("p_fs_location");
	if (file_type_appl_yn==null) file_type_appl_yn="N";
	if (p_not_in_files==null) p_not_in_files="";
	if (p_include_in_select==null) p_include_in_select="";
	if (added_volumes==null) added_volumes="";
	if (curr_fstat==null || curr_fstat.equals("null")) curr_fstat="";
	added_volumes = java.net.URLDecoder.decode(added_volumes);
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
		if (p_concat_string.length() == 0) p_concat_string = "''";
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


		//SelectSqlBuffer.append(" select a.file_no,a.facility_id,a.patient_id,get_patient_line(a.patient_id)patient_line,decode(a.curr_file_status,'I','Inside','O','Outside','L','Lost','T','In Transit','A','Archived')curr_file_status,curr_file_status curr_file_status1,a.curr_fs_locn_code,a.curr_fs_locn_short_desc,decode(a.curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity,nvl(to_char(a.return_date_time,'dd/mm/rrrr hh24:mi') ,'&nbsp;')return_date_time,DECODE(a.curr_file_status,'I',1,'O',1,'L',3,'T',2,'A',4,'E',2)order_by_status,(CASE WHEN a.curr_facility_id<> a.facility_id THEN '('|| a.curr_facility_name ||')' ELSE '&nbsp;' END )curr_facility_name ,ltrim(rtrim(a.req_remarks))req_remarks,ltrim(rtrim(a.remarks))remarks, a.file_type_desc, a.doc_type_code, a.volume_no,a.doc_folder_id,c.encounter_id, a.doc_folder_name, a.doc_type_name,(CASE WHEN b.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE ', ' || get_patient_line(b.patient_id) END)doc_type from fm_curr_locn_vw a, fm_doc_folder b,FM_ENCOUNTER_DOC_TYPE_LINK c where a.mr_pat_fs_locn_code = '"+p_fs_location+"' ");
		SelectSqlBuffer.append("SELECT a.File_No,");
		SelectSqlBuffer.append("        a.Facility_Id,");
		SelectSqlBuffer.append("        a.Patient_Id,");
		SelectSqlBuffer.append("        Get_patient_line(a.Patient_Id,'"+localeName+"') Patient_Line,");
		SelectSqlBuffer.append("        Curr_File_Status Curr_File_Status1,");
		SelectSqlBuffer.append("        a.Curr_fs_Locn_Code,");
		SelectSqlBuffer.append("        a.Curr_fs_Locn_Short_desc,");
		SelectSqlBuffer.append("        a.Curr_fs_Locn_Identity,");
		SelectSqlBuffer.append("        Nvl(To_char(a.Return_Date_Time,'dd/mm/rrrr hh24:mi'),");
		SelectSqlBuffer.append("            '&nbsp;') Return_Date_Time,");
		SelectSqlBuffer.append("        DECODE(a.Curr_File_Status,'I',1,");
		SelectSqlBuffer.append("                                  'O',1,");
		SelectSqlBuffer.append("                                  'L',3,");
		SelectSqlBuffer.append("                                  'T',2,");
		SelectSqlBuffer.append("                                  'A',4,");
		SelectSqlBuffer.append("                                  'E',2) Order_By_Status,");
		SelectSqlBuffer.append("        (CASE ");
		SelectSqlBuffer.append("           WHEN a.Curr_Facility_Id <> a.Facility_Id THEN '('");
		SelectSqlBuffer.append("                                                         ||a.Curr_Facility_Name");
		SelectSqlBuffer.append("                                                         ||')'");
		SelectSqlBuffer.append("           ELSE '&nbsp;'");
		SelectSqlBuffer.append("         END) Curr_Facility_Name,");
		SelectSqlBuffer.append("        Ltrim(Rtrim(a.req_Remarks)) req_Remarks,");
		SelectSqlBuffer.append("        Ltrim(Rtrim(a.Remarks)) Remarks,");
		SelectSqlBuffer.append("        a.File_Type_desc,");
		SelectSqlBuffer.append("        a.Doc_Type_Code,");
		SelectSqlBuffer.append("        a.Volume_No,");
		SelectSqlBuffer.append("        a.Doc_Folder_Id,");
		SelectSqlBuffer.append("        c.Encounter_Id,");
		SelectSqlBuffer.append("        a.Doc_Folder_Name,");
		SelectSqlBuffer.append("        a.Doc_Type_Name,");
		SelectSqlBuffer.append("        (CASE ");
		SelectSqlBuffer.append("           WHEN b.Patient_Period_Specific = 'D' THEN ', '");
		SelectSqlBuffer.append("                                                     ||To_char(b.From_Period,'dd/mm/rrrr ')");
		SelectSqlBuffer.append("                                                     ||' - '");
		SelectSqlBuffer.append("                                                     ||To_char(b.To_Period,'dd/mm/rrrr ')");
		SelectSqlBuffer.append("           ELSE ', '");
		SelectSqlBuffer.append("                ||Get_patient_line(b.Patient_Id,'"+localeName+"')");
		SelectSqlBuffer.append("         END) Doc_Type");
		SelectSqlBuffer.append(" FROM   ");
		SelectSqlBuffer.append("   fm_Curr_Locn_vw a,");
		SelectSqlBuffer.append("   fm_Doc_Folder b,");
		SelectSqlBuffer.append("   fm_Encounter_Doc_Type_Link c");
		SelectSqlBuffer.append(" WHERE  a.mr_Pat_fs_Locn_Code = '"+p_fs_location+"' ");
		if(!p_stored_val.equals(""))
		{
			SelectSqlBuffer.append("AND a.file_no in ("+p_concat_string+") ");
		}
		if (!added_volumes.equals(""))
		{
			SelectSqlBuffer.append("AND a.volume_no in ("+added_volumes+") ");
		}
		if (!curr_fstat.equals("S"))
		{
			SelectSqlBuffer.append("AND a.CURR_FILE_STATUS='"+curr_fstat+"' ");
		}
		SelectSqlBuffer.append( " and a.facility_id='"+facilityid+"' AND a.doc_folder_id=b.doc_folder_id and a.facility_id = c.facility_id and a.file_no = c.file_no AND a.facility_id=b.facility_id and a.curr_facility_id = '"+p_outst_fcy+"' AND a.curr_fs_locn_identity = decode('"+p_fs_locn_id+"','',a.curr_fs_locn_identity,'"+p_fs_locn_id+"') AND a.curr_fs_locn_code =decode('"+p_out_fsloc+"','',a.curr_fs_locn_code,'"+p_out_fsloc+"') AND a.doc_folder_id is not null ORDER BY order_by_status,a.curr_fs_locn_code,a.file_no ");
	pstmt	= con.prepareStatement(SelectSqlBuffer.toString());
	rs		= pstmt.executeQuery();

%>
<script>parent.frames[2].document.getElementById("hdr_tab").style.visibility='Visible';</script>
<TABLE border='1' cellpadding='0' cellspacing='0' width='100%'  id="srch_result">

<%
int i = 0;
int p_rec_cnt = 0;

String classValue="";
String bgcolor="";
String p_allow_select="";
String p_checked="";
int p_return_cnt=0;
int p_not_return_cnt=0;
int counter=0;

String file_type_desc	=	"";
String doc_type_code	=	"";
String volume_no		=	"";
String p_first_curr_fs_locn_code="";

String doc_folder_id = "", doc_folder_name = "", doc_type_name = "", doc_type="";

while ( rs.next() )
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	if (rs.getString("curr_file_status1").equals("A"))
	{
		bgcolor			= "gold";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("T"))
	{
		bgcolor = "darkseagreen";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("L"))
	{
		bgcolor = "mediumvioletred";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("E"))
	{
		bgcolor = "cyan";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else if (rs.getString("curr_file_status1").equals("I"))
	{
		bgcolor = "E0FFFF";
		p_allow_select	= "";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("O"))
	{
		bgcolor = "sandybrown";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("R"))
	{
		bgcolor = "#C0C0C0";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else
	{
		bgcolor = "";
		p_allow_select	= "";
		p_checked		= "";
	}

	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O") )
	{
		if (p_return_cnt==0)
		{
%>
		<TR>
			<td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.DocumentstobeReturned.label" bundle="${fm_labels}"/></font></td>
		</TR>
<%		}
		p_return_cnt++;

	}
	
	if (rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A") || rs.getString("curr_file_status1").equals("T"))
	{
		if (p_not_return_cnt==0)
		{
			if (p_return_cnt>0)
			{
%>
		<TR>
			<td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.DocumentscannotbeReturned.label" bundle="${fm_labels}"/></font></td>
		</TR>
<%
			}
			else
			{
%>
		<TR>
			<td class='columnheader' colspan = '7' ><b><h5><font size=1><fmt:message key="eFM.DocumentscannotbeReturned.label" bundle="${fm_labels}"/></font></td>
		</TR>
<%
			}
		}

		p_not_return_cnt++;
	}
	String curr_fs_locn_identity = rs.getString("curr_fs_locn_identity") ;
	String curr_fs_locn_ident_desc = "";
	switch(curr_fs_locn_identity.charAt(0))
	{
		case 'D' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); 
			break;
		case 'T' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); 
			break;
		case 'C' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;
		case 'N' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;
		case 'X' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;
		case 'E' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;
		case 'Y' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		default : curr_fs_locn_ident_desc = "";
	}
      if (counter==0)
           {
                p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
%>
        <tr>
            <td  height="20" colspan="7"  class='CAGROUPHEADING' ><b><%=rs.getString("curr_fs_locn_short_desc")+" ( " + curr_fs_locn_ident_desc +") "%></b></td>
        </tr>
<%
            }
        else if (!p_first_curr_fs_locn_code.equals(rs.getString("curr_fs_locn_code")))
            {
%>
        <tr>
            <td  height="20" colspan="7" class='CAGROUPHEADING'  ><b><%=rs.getString("curr_fs_locn_short_desc")+" ( " + curr_fs_locn_ident_desc +") "%></b></td>
        </tr>
<%
            }

        counter++ ;

        if ( counter % 2 == 0 )
            classValue = "QRYODD" ;
        else
            classValue = "QRYEVEN" ;


		String tempstr = rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6);
		String patient_id ="";
		StringTokenizer st = new StringTokenizer(tempstr, ",");
		st.nextToken();
		st.nextToken();
		st.nextToken();
		patient_id = st.nextToken();
		file_type_desc  = rs.getString("file_type_desc");
		doc_type_code  = rs.getString("doc_type_code");
		volume_no  = rs.getString("volume_no");
		if ((file_type_desc==null)||(file_type_desc.equals(""))) file_type_desc = "&nbsp;";
		else file_type_desc =file_type_desc + " / ";
		if (doc_type_code==null) file_type_desc = "";
		if (volume_no==null) volume_no = "";
		doc_folder_id = rs.getString("doc_folder_id")==null?"&nbsp;":rs.getString("doc_folder_id");
		doc_folder_name = rs.getString("doc_folder_name")==null?"&nbsp;":rs.getString("doc_folder_name");
		doc_type_name = rs.getString("doc_type_name")==null?"&nbsp;":rs.getString("doc_type_name");
		doc_type = rs.getString("doc_type")==null?"&nbsp;":rs.getString("doc_type");		
%>

	<tr>
	<td width="28%"  class="<%= classValue %>" >
		<font size=1><b><%=doc_folder_id%></b>
		<br><input type=hidden name=file_no<%=i%> value="<%= rs.getString("file_no") %>">&nbsp;<%=doc_folder_name%><%=doc_type%>
	</td>
	<td width="14%"  class="<%=classValue%>"><font size=1><%=doc_type_name%>,<BR><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="showEncounter('<%=rs.getString("ENCOUNTER_ID")%>','<%=rs.getString("PATIENT_ID")%>','<%=rs.getString("FILE_NO")%>')"><%=rs.getString("PATIENT_ID")%>&nbsp;</A></font><input type="Hidden" name="doc_type_code<%=i%>" id="doc_type_code<%=i%>" value="<%=doc_type_code%>"><input type="Hidden" name="volume_no<%=i%>" id="volume_no<%=i%>" value="<%=volume_no%>"></td>	
<%
		
%>
	
	<!-- <input type="Hidden" name="doc_type_code<%=i%>" id="doc_type_code<%=i%>" value="<%=doc_type_code%>"><input type="Hidden" name="volume_no<%=i%>" id="volume_no<%=i%>" value="<%=volume_no%>"> -->
<%
	String p_iss_remarks = rs.getString("remarks");

	out.println("<td align='CENTER' class='"+classValue+"' width='8%'><font size=1>");

	if (p_iss_remarks == null)
	{
		out.println("&nbsp;</font></td>");
	}
	else
	{
%>
	   <a href='javascript:GetShowRemarks("txtComm<%=i%>","<%=p_iss_remarks%>","IR")'>Remarks</a></font></td>
<%					
	}
%>

	<td width=17%  class="<%= classValue %>" ><font size=1>
		<%= rs.getString("curr_fs_locn_short_desc") %>
		<br>&nbsp;&nbsp;(<%= curr_fs_locn_ident_desc%>)&nbsp;<%=rs.getString("curr_facility_name")%>
	</font></td><td width="15%" align="CENTER" class="<%= classValue %>" ><font size=1>
	<%=rs.getString("return_date_time")%>
	</font></td>
		<td width=8% align="CENTER" class="<%= classValue %>" ><font size=1>
	<a href="javascript:GetRemarks(<%= i %>)"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
	<input type="hidden" name="rem_recnum_<%=i%>" id="rem_recnum_<%=i%>" value="">
	</font></td>	
		<td width="10%" align='center' style='background-color:<%=bgcolor%>' class='<%=classValue %>'><font size=1>
	<input type=checkbox name="req_select<%=i%>" id="req_select<%=i%>" <%=p_checked%> <%=p_allow_select%> value='Y'>
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
	i++;
	p_rec_cnt++;

	p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
  } //endwhile


%>
	<script>
			parent.frames[1].document.forms[0].p_curr_fs_loc.disabled = false;
			parent.frames[1].document.forms[0].FILE_STAT.disabled = false;
			if (parent.frames[2].document.forms[0].file_no != null)
				parent.frames[2].document.forms[0].file_no.readOnly = false;
			parent.frames[2].document.forms[0].p_out_fcy.disabled = false;
			parent.frames[2].document.forms[0].FS_LOCN_ID.disabled = false;
			parent.frames[2].document.forms[0].p_out_fsloc.disabled = false;
			parent.frames[2].document.forms[0].Add.disabled = false;
			parent.frames[2].document.forms[0].show_files.disabled = false;
			parent.frames[2].document.forms[0].Clear.disabled = false; 
			
	</script>
</TABLE>
<script>
	for (i=0;i<7;i++)
	{
		if ((document.getElementById("srch_result").rows(i+1) != null) && (document.getElementById("srch_result").rows(i+1).cells(i) != null))
		{
			parent.frames[2].document.getElementById("hdr_tab").rows(0).cells(i).width = document.getElementById("srch_result").rows(i+1).cells(i).width; 
		}
	}

	var p_counter = '<%=counter%>';

	if (parseInt(p_counter)==0)
	{
			alert(getMessage('NO_DOC_TO_RETURN','FM'));
			parent.frames[1].document.forms[0].p_curr_fs_loc.disabled = false;
			parent.frames[1].document.forms[0].FILE_STAT.disabled = false;
			if (parent.frames[2].document.forms[0].file_no != null)
				parent.frames[2].document.forms[0].file_no.readOnly = false;
			parent.frames[2].document.forms[0].p_out_fcy.disabled = false;
			parent.frames[2].document.forms[0].FS_LOCN_ID.disabled = false;
			parent.frames[2].document.forms[0].p_out_fsloc.disabled = false;
			parent.frames[2].document.forms[0].Add.disabled = false;
			parent.frames[2].document.forms[0].show_files.disabled = false;
			parent.frames[2].document.forms[0].Clear.disabled = false; 
	}

	parent.frames[1].document.forms[0].p_deselect_values.value = "<%=p_not_in_files%>";

	parent.frames[1].document.forms[0].p_select_values.value = "<%=p_stored_val%>";
	parent.frames[1].document.forms[0].p_total_records.value = "<%=p_rec_cnt%>";

	var p_in_files		= parent.frames[1].document.forms[0].p_select_values.value;
	var p_not_files	= parent.frames[1].document.forms[0].p_deselect_values.value;

	parent.frames[2].document.forms[0].p_total_select.value = "<%=p_rec_cnt%>";
	
	parent.frames[2].document.forms[0].patient_id.value="";
	parent.frames[2].document.forms[0].doc_folder_id.value="";
	parent.frames[2].document.forms[0].doc_folder_desc.value="";

</script>
<input type='hidden' name=p_select_values value='<%=p_select_values%>'>
<input type='hidden' name=p_total_select value='<%=p_rec_cnt%>'>

</FORM>
</BODY>
<%
if(rs!=null)	rs.close();
if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</HTML>

