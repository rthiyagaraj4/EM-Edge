<!DOCTYPE html>
<!--  by Meghanath	-->
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="recordSet" scope="session" class="webbeans.eCommon.RecordSet"/>
<%! int row_count=0; %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con		=	null;
	java.sql.Statement stmt		=	null;
	java.sql.Statement stmt1		=	null;
	java.sql.Statement stmt2		=	null;
	ResultSet rs		=	null;
	ResultSet rs1		=	null;
	HashMap htRecord	=	null;

	String file_no="", patient_id="",  associate_yn="N",associate_yn_prop="", tblrow_id="",classValue="",fs_locn_code="",fs_desc="",fn_locn_code="";
	String locn_identity="", narration_code="", holder_name="",fs_locn_disp="";
	String result_query="", header="", fs_locn="",mr_pat_fs_locn_desc="", curr_fs_locn_desc="";
	String other_locn_code="",curr_fs_locn_identity="",	curr_holder_name="",curr_mr_locn_yn="",mr_locn_yn="";
	String file_type_code = "",volume_no = "";
	String dissable_attribute = "";
	String sql_query = "";
	
	String docline			= "";
	String doc_folder_id	= "";
	String doc_folder_name	= "";
	String doc_type_code	= "";
	String doc_type_name	= "";


	
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
		stmt1	=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

	//	int row_disp	= 7;
		int start		= 0;
		int end			= 0;
		int fm_disp=0, to_disp = 0;
		
		String facility_id			=   (String)session.getValue("facility_id");	
		String from					=	request.getParameter("from");
		String to					=	request.getParameter("to");
		String mode					=	request.getParameter("mode");
		patient_id					=	request.getParameter("patient_id");
		file_type_code				=	request.getParameter("file_type_code");
		
		if(mode == null || mode.equals("null")) 
			mode="";
	   if ( from == null )
		start = 1 ;
		else
		start = Integer.parseInt( from );
		if ( to == null )
	  		end = 7 ;
		else
			end = Integer.parseInt( to );
		if(mode.equals(""))
		{
			String str=request.getParameter("whereClause");
			if(str==null)str="";
			fs_locn	=	request.getParameter("fs_locn");
			if(fs_locn==null)fs_locn="P";
			if(!(str.equals(""))) recordSet.clearAll();
			if(str==null)str="";
			else str = str.replace('~','%');
						
			if(fs_locn.equals("P"))
			{
				result_query ="select a.file_no,a.patient_id, a.doc_folder_id,a.doc_folder_name,a.doc_type_code,a.doc_type_name,a.volume_no,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ') ELSE  ', ' || GET_PATIENT_LINE(b.PATIENT_ID,'"+localeName+"') END) docline,a.file_type_code,a.volume_no, a.mr_pat_fs_locn_code fs_locn_code, a.curr_fs_locn_code other_locn,a.mr_pat_locn_short_desc mr_pat_fs_locn_desc, a.curr_fs_locn_short_desc curr_fs_locn_desc, a.curr_fs_locn_identity, a.curr_holder_name, a.mr_locn_yn FROM fm_curr_locn_vw a,fm_doc_folder b WHERE a.facility_id='"+facility_id+"' AND a.doc_folder_id = b.doc_folder_id(+) and a.facility_id = b.facility_id(+) " + str;
			}
			else
			{
				result_query="select a.file_no,a.patient_id, a.doc_folder_id,a.doc_folder_name,a.doc_type_code,a.doc_type_name,a.volume_no,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE b.patient_id END) docline, a.file_type_code,a.volume_no,a.curr_fs_locn_code fs_locn_code, a.mr_pat_fs_locn_code other_locn, a.mr_pat_locn_short_desc mr_pat_fs_locn_desc, a.curr_fs_locn_short_desc curr_fs_locn_desc, a.curr_fs_locn_identity, a.curr_holder_name, a.mr_locn_yn FROM fm_curr_locn_vw a,fm_doc_folder b WHERE a.facility_id='"+facility_id+"' AND a.doc_folder_id = b.doc_folder_id(+) AND a.facility_id = b.facility_id(+) " +  str;
			}
			rs=stmt.executeQuery(result_query);
			associate_yn="N";
			if(rs != null)
			{
				while(rs.next())
				{
					docline					=	rs.getString("docline");
					file_no					=	rs.getString("file_no");
					patient_id				=	rs.getString("patient_id");
					doc_folder_id			=	rs.getString("doc_folder_id");
					doc_folder_name			=	rs.getString("doc_folder_name");
					doc_type_code			=	rs.getString("doc_type_code");
					doc_type_name			=	rs.getString("doc_type_name");	
					volume_no				=	rs.getString("volume_no");
					fs_locn_disp			=	rs.getString("fs_locn_code");
					other_locn_code			=	rs.getString("other_locn");
					mr_pat_fs_locn_desc		=	rs.getString("mr_pat_fs_locn_desc");
					curr_fs_locn_desc		=	rs.getString("curr_fs_locn_desc");
					curr_fs_locn_identity	=	rs.getString("curr_fs_locn_identity");
					curr_holder_name		=	rs.getString("curr_holder_name");
					curr_mr_locn_yn			=	rs.getString("mr_locn_yn");
					
					if(docline == null || docline.equals("null"))docline="&nbsp;";
					if(file_no == null || file_no.equals("null"))file_no="";
					if(patient_id == null || patient_id.equals("null"))patient_id="";
					if(doc_folder_id == null || doc_folder_id.equals("null"))doc_folder_id="";
					if(doc_folder_name == null || doc_folder_name.equals("null"))doc_folder_name="";
					if(doc_type_code == null || doc_type_code.equals("null"))doc_type_code="";
					if(doc_type_name == null || doc_type_name.equals("null"))doc_type_name="";				
					if(volume_no == null || volume_no.equals("null"))volume_no="";
					if(fs_locn_disp == null || fs_locn_disp.equals("null"))fs_locn_disp="";
					if(mr_pat_fs_locn_desc == null || mr_pat_fs_locn_desc.equals("null"))mr_pat_fs_locn_desc="";
					if(curr_fs_locn_desc == null || curr_fs_locn_desc.equals("null"))curr_fs_locn_desc="";
					if(other_locn_code == null || other_locn_code.equals("null"))other_locn_code="";
					if(curr_fs_locn_identity == null || curr_fs_locn_identity.equals("null"))curr_fs_locn_identity="";
					if(curr_holder_name == null || curr_holder_name.equals("null"))curr_holder_name="";
					if(curr_mr_locn_yn == null || curr_mr_locn_yn.equals("null")) curr_mr_locn_yn="";
					
					htRecord			=	new HashMap();

					htRecord.put("file_no"		        ,file_no);
					htRecord.put("patient_id"	        ,patient_id);
					htRecord.put("file_type_code"       ,file_type_code);
					htRecord.put("doc_type_code"        ,doc_type_code);
					htRecord.put("doc_folder_id"        ,doc_folder_id);
					htRecord.put("volume_no"		    ,volume_no);		
					
					htRecord.put("associate_yn"	        ,associate_yn);
					htRecord.put("fn_locn_code"	        ,fn_locn_code);
					htRecord.put("locn_identity"	    ,locn_identity);
					htRecord.put("narration_code"	    ,narration_code);
					htRecord.put("holder_name"		    ,holder_name);
					htRecord.put("mr_locn_yn"		    ,mr_locn_yn);
					htRecord.put("fs_locn_disp"		    ,fs_locn_disp);
					htRecord.put("mr_pat_fs_locn_desc"  ,mr_pat_fs_locn_desc);
					htRecord.put("curr_fs_locn_desc"    ,curr_fs_locn_desc);
					htRecord.put("other_locn_code"      ,other_locn_code);
					htRecord.put("curr_fs_locn_identity",curr_fs_locn_identity);
					htRecord.put("curr_holder_name"     ,curr_holder_name);
					htRecord.put("curr_mr_locn_yn"      ,curr_mr_locn_yn);

					recordSet.putObject(htRecord);
				}
			}
			row_count				=	recordSet.getSize();
			fm_disp	=	0;
			to_disp	=	7;
			if(to_disp > (row_count-1))
					to_disp=(row_count-1);
		}
		fm_disp =	start-1;
		to_disp	=	end-1;
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
%>
<HTML>
<HEAD>
	<!-- <LINK rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eFM/js/FMChangeStorageLocn.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</HEAD>
<BODY  onLoad='dispRecord(); loadCurrPage();' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<FORM name='FMChngStrLocnMainResultForm' id='FMChngStrLocnMainResultForm' action='' method=''>
<P>
<TABLE align='right'>
<tr>
<td>
<%
	if (!(start <= 1))
	{
%>
		<A HREF='../jsp/FMChangeStorageLocnMainResult.jsp?from=<%=start-7%>&to=<%=end-7%>&mode=Previous' onClick='checkVal();' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%
	}
	if ( !( (start+7) > row_count ) )
	{
%>
		<A HREF='../jsp/FMChangeStorageLocnMainResult.jsp?from=<%=(start+7)%>&to=<%=(end+7)%>&mode=next' onClick='checkVal();' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%
	}
%>
</td>
</tr>
</TABLE>
	<br><br>
</P>
<%
	if(row_count==0)
	{
%>
		<SCRIPT>
		
			var msg =	getMessage('NO_RECORDS_FOUND','FM');
			if(msg!="")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}
			parent.FMChngStrLocnSubResultFrame.document.FMChngStrLocnSubResultForm.locn_code.disabled = "true";
		</SCRIPT>
<%
	}
%>
<TABLE cellpadding='0' cellspacing='0' border='1' width='100%'>
<%
	if(fs_locn.equals("C")) 
		header="Current FS Location";
	else
	{
		header="Permanent FS Location";
	}
%>
	<td class='columnheader' width='40%'><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='8%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='12%' nowrap><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/></td>
	<td class='columnheader' width='12%' nowrap><fmt:message key="eFM.CurrentFS.label" bundle="${fm_labels}"/><br><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='12%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
	<td class='columnheader' width='6%'><fmt:message key="Common.change.label" bundle="${common_labels}"/>?</td>
<%
try
{
/*	Properties prop	=	new Properties();
	prop.put("fs_locn",fs_locn);
	prop.put("Statement",stmt1);
	prop.put("facility_id",facility_id);
	rs1	=	eFM.FMUtilities.getStorageLocn(prop);
*/	
	if(fs_locn.equals("P"))
	{
		dissable_attribute = "disabled";
	}
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		htRecord			=	(java.util.HashMap)	recordSet.getObject(i);

		file_no				=	(String)	htRecord.get("file_no");
		patient_id			=	(String)	htRecord.get("patient_id");
		file_type_code		=	(String)	htRecord.get("file_type_code");
		doc_type_code		=	(String)	htRecord.get("doc_type_code");
		doc_folder_id		=	(String)	htRecord.get("doc_folder_id");
		volume_no			=	(String)	htRecord.get("volume_no");		
		associate_yn		=	(String)	htRecord.get("associate_yn");
		fs_locn_disp		=	(String)	htRecord.get("fs_locn_disp");
		mr_pat_fs_locn_desc	=	(String)	htRecord.get("mr_pat_fs_locn_desc");
		curr_fs_locn_desc	=	(String)	htRecord.get("curr_fs_locn_desc");

		tblrow_id =	"tblrow_id"+i;

		if(associate_yn.equals("Y"))
		{
			associate_yn_prop = " CHECKED ";
		}
		else
		{
			associate_yn_prop = " ";
		}
%>
			<tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>' ><FONT size='1'><B><%=((doc_folder_id.equals(""))?"&nbsp;":doc_folder_id)%></B></FONT><BR>&nbsp;&nbsp;<FONT size='1'><%=((doc_folder_name.equals(""))?"&nbsp;":doc_folder_name)%></FONT>&nbsp;&nbsp;<font size='1'><%=((docline.equals(""))?"&nbsp;":docline)%></font></td>

			<td class='<%=classValue%>' ><FONT 	size='1'><CENTER>
			<%=((doc_type_name.equals(""))?"&nbsp;":doc_type_name)%></CENTER></FONT></td>

			<td class='<%=classValue%>' ><FONT size='1'><%=((mr_pat_fs_locn_desc.equals(""))?"&nbsp;":mr_pat_fs_locn_desc)%></FONT></td>
			<td class='<%=classValue%>' ><FONT size='1'><%=((curr_fs_locn_desc.equals(""))?"&nbsp;":curr_fs_locn_desc)%></FONT></td>
			<td class='<%=classValue%>' align='center'><SELECT name='fs_locn_code<%=i%>' id='fs_locn_code<%=i%>' <%=dissable_attribute%> onChange='checkAssign(this, "<%=i%>");' onFocus='assignOnFocus(this);'>
			<OPTION value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
<%
			stmt2	=	con.createStatement();			
			if(fs_locn.equals("C"))
				{
					sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and eff_status='E' order by short_desc";
				}
				else
				{
					sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";
				}

				rs1		=	stmt2.executeQuery(sql_query);
			
			
				while(rs1 != null && rs1.next())
				{
					fs_locn_code	=	rs1.getString("fs_locn_code");
					fs_desc			=	rs1.getString("short_desc");

					if(!fs_locn_code.equals(fs_locn_disp))
					{
						out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
					}
				}
				if(rs1 != null) rs1.close();
				if(stmt2  != null) stmt2.close();
%>			</SELECT><INPUT type='hidden' name='default_code<%=i%>' id='default_code<%=i%>' value='<%=fs_locn_disp%>'></td>
		
			<td class='<%=classValue%>' align='center'><INPUT type='checkbox' name='associate_yn<%=i%>' id='associate_yn<%=i%>' <%=associate_yn_prop%> value='Y' <%=dissable_attribute%> onClick='CBValue(this,"<%=i%>");'></td>
			</tr>
<%
		}
%>
			<SCRIPT>			
				parent.frames[0].document.forms[0].fs_locn_code.disabled=false;
				parent.frames[0].document.forms[0].storage_locn.disabled=false;
				parent.frames[0].document.forms[0].search_dtl.disabled=false;
				parent.frames[0].document.forms[0].reset1.disabled=false;
			</SCRIPT>		
<%
	}
	catch(Exception e)
	{
		out.println("Exception@2: "+e);
	}
	
%>
</TABLE>
<INPUT type='hidden' name='row_count' id='row_count' value='<%=row_count%>'>
<INPUT type='hidden' name='fm_disp' id='fm_disp' value='<%=fm_disp%>'>
<INPUT type='hidden' name='to_disp' id='to_disp' value='<%=to_disp%>'>
<INPUT type='hidden' name='fs_locn' id='fs_locn' value='<%=fs_locn%>'>
</FORM>
<%
if(rs1   != null) rs1.close();
if(rs    != null) rs.close();
if(stmt  != null) stmt.close();
if(stmt1 != null) stmt1.close();
if(stmt2  != null) stmt2.close();
}
catch(Exception e)
{
	out.println("Exception in fetching connection"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</BODY>
</HTML>


