<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Assign File Store Location
	Function		:	This function is used for Search Result.
-->
<%@ page contentType="text/html; charset=UTF-8" import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, webbeans.eCommon.RecordSet" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="recordSet" scope="session" class="webbeans.eCommon.RecordSet"/>
<%!int row_count=0;%>
<%
	
	Connection con				=	null;
	java.sql.Statement stmt		=	null;
	java.sql.Statement stmt1	=	null;
	java.sql.Statement stmt2	=	null;
	ResultSet rs				=	null;
	ResultSet rs1				=	null;

	HashMap		htRecord	=	null;
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
		stmt1	=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
	//	int row_disp	= 9;
		int start		= 0 ;
		int end			= 0 ;
		int fm_disp = 0, to_disp = 0;

		String file_no = "",patient_id = "",patient_name = "",associate_yn_prop = "", tblrow_id = "",classValue = "",fs_locn_code = "",fs_desc = "",fn_locn_code = "";
		String locn_identity = "",narration_code = "",holder_name = "",pat_details = "",str = "";
		
		String file_type_code       = "";
		String file_type_desc       = "";
		String doc_folder_id        = "";
		String doc_type_code        = "";
		String associate_yn			= "N";

		StringBuffer result_query	= null;
		StringBuffer check_sql		= null;
		String sql_query = "";
		;

		result_query				= new StringBuffer();	
		
		String facility_id			= (String) session.getValue("facility_id");
	//	String login_id				= (String) session.getValue("login_user");

		String from					= request.getParameter( "from" ) ;
		String to					= request.getParameter( "to" ) ;
		String mode					= request.getParameter("mode") ;
		String file_type_appl_yn	= request.getParameter("file_type_appl_yn") ;
		
	
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
		if(mode == null || mode.equals("null")) mode="";

		if(from == null) start = 1 ;
		else start = Integer.parseInt( from ) ;

		if(to == null)	end = 9 ;
		else end = Integer.parseInt(to) ;

		if(mode.equals(""))
		{
			str = request.getParameter("whereClause");
			if(str == null) str = "";
			if(!(str.equals(""))) recordSet.clearAll();
			if(str == null) str = "";
			else str = str.replace('~','%');
			

		
			
			
			
			if(file_type_appl_yn.equals("N"))
			{
				result_query.append("select a.file_no, a.patient_id,a.doc_folder_id,a.doc_type_code, a.file_type_code file_type_code, get_patient_line(a.patient_id,'"+localeName+"') pat_details from mr_pat_file_index a where a.fs_locn_code is null and a.facility_id='"+facility_id+"'  ");
				result_query.append(str);
			}
			else if(file_type_appl_yn.equals("Y"))
			{
				//result_query.append("select a.file_no, a.patient_id,a.doc_folder_id,a.doc_type_code, a.file_type_code,b.short_desc file_type_desc, get_patient_line(a.patient_id) pat_details from mr_pat_file_index a, mr_file_type b where a.fs_locn_code is null and a.facility_id='"+facility_id+"' and a.facility_id = b.facility_id(+) and a.file_type_code = b.file_type_code(+) ");

				result_query.append("SELECT" );
				result_query.append("  a.File_No" );
				result_query.append("  , a.Patient_Id" );
				result_query.append("  , a.Doc_Folder_Id" );
				result_query.append("  , a.Doc_Type_Code" );
				result_query.append("  , a.File_Type_Code" );
				result_query.append("  , b.Short_desc File_Type_desc" );
				result_query.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') Pat_Details " );
				result_query.append("FROM" );
				result_query.append("  mr_Pat_File_Index a" );
				result_query.append("  , mr_file_type_lang_vw b " );
				result_query.append("WHERE a.fs_Locn_Code IS" );
				result_query.append("  NULL " );
				result_query.append("  AND B.LANGUAGE_ID='"+localeName+"' " );
				result_query.append("  AND a.Facility_Id = '"+facility_id+"' " );
				result_query.append("  AND a.facility_id = b.facility_id(+) " );
				result_query.append("  AND a.file_type_code = b.file_type_code(+)" );
				result_query.append(str);
			}
			
			
			rs = stmt.executeQuery(result_query.toString());
			associate_yn = "N";
			
			while(rs != null && rs.next())
			{
					file_no			=	rs.getString("file_no");
					patient_id		=	rs.getString("patient_id");
					file_type_code	=	rs.getString("file_type_code");
					doc_folder_id	=	rs.getString("doc_folder_id");
					doc_type_code	=	rs.getString("doc_type_code");

					if(file_type_appl_yn.equals("Y"))
					{
						file_type_desc	= rs.getString("file_type_desc");
						if(file_type_desc == null || file_type_desc.equals("null"))
							file_type_desc="&nbsp;";
					}					
					pat_details		=	rs.getString("pat_details").substring(0,rs.getString("pat_details").length()-6);

					if(file_no == null || file_no.equals("null"))file_no="";
					if(patient_id == null || patient_id.equals("null"))patient_id="";
					if(file_type_code == null || file_type_code.equals("null"))file_type_code="";
					if(patient_name == null || patient_name.equals("null"))patient_name="";				
					if(pat_details == null || pat_details.equals("null"))pat_details="";
					if(doc_folder_id == null || doc_folder_id.equals("null"))doc_folder_id="";
					if(doc_type_code == null || doc_type_code.equals("null"))doc_type_code="";

					htRecord			=	new HashMap();

					htRecord.put("file_no"		  ,	file_no);
					htRecord.put("patient_id"	  ,	patient_id);
					htRecord.put("doc_folder_id"  ,	doc_folder_id);
					htRecord.put("doc_type_code"  ,	doc_type_code);
					htRecord.put("file_type_code" ,	file_type_code);
					htRecord.put("patient_name"	  ,	patient_name);				
					htRecord.put("associate_yn"	  ,	associate_yn);
					htRecord.put("fn_locn_code"	  ,	fn_locn_code);
					htRecord.put("locn_identity"  ,	locn_identity);
					htRecord.put("narration_code" ,	narration_code);
					htRecord.put("holder_name"	  ,	holder_name);
					htRecord.put("pat_details"	  ,	pat_details);
			
					recordSet.putObject(htRecord);
			}
			row_count				=	recordSet.getSize();
			if(rs != null) rs.close();
			if(stmt  != null) stmt.close();
			if((result_query != null) && (result_query.length() > 0))
			{
				result_query.delete(0,result_query.length());
			}

			fm_disp	=	0;
			to_disp	=	9;
			if(to_disp > (row_count-1))
					to_disp=(row_count-1);
		}
		fm_disp =	start-1;
		to_disp	=	end-1;
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMAssignStorageLocn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onLoad='dispRecord(); loadCurrPage();' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='FMAssnStrLocnMainResultForm' id='FMAssnStrLocnMainResultForm' action='' method=''>
<P>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
	{
%>
	<A HREF='../jsp/FMAssignStorageLocnMainResult.jsp?from=<%=start-9%>&to=<%=end-9%>&file_type_appl_yn=<%=file_type_appl_yn%>&mode=Previous' onClick='checkVal();' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%
	}
%>
<%
	if ( !( (start+9) > row_count ) )
	{
%>
	<A HREF='../jsp/FMAssignStorageLocnMainResult.jsp?from=<%=(start+9)%>&to=<%=(end+9)%>&file_type_appl_yn=<%=file_type_appl_yn%>&mode=next' onClick='checkVal();' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%
	}
%>
</td>
</tr>
</table>
<br><br>
</P>
<%if(row_count == 0)
{
	check_sql	= new StringBuffer();	

	if(file_type_appl_yn.equals("N"))
	{
		check_sql.append("select a.file_no, a.patient_id,  get_patient_line(a.patient_id,'"+localeName+"') pat_details from mr_pat_file_index a where a.fs_locn_code is not null and a.facility_id = '"+facility_id+"' ");
		check_sql.append(str);
	}
	else if(file_type_appl_yn.equals("Y"))
	{
		//check_sql.append("select a.file_no, a.patient_id,a.file_type_code,b.short_desc file_type_desc, get_patient_line(a.patient_id) pat_details from mr_pat_file_index a,mr_file_type b where a.fs_locn_code is not null and a.facility_id = '"+facility_id+"' and a.facility_id = b.facility_id(+) and a.file_type_code = b.file_type_code(+) ");
		check_sql.append("SELECT" );
		check_sql.append("  a.File_No" );
		check_sql.append("  , a.Patient_Id" );
		check_sql.append("  , a.File_Type_Code" );
		check_sql.append("  , b.Short_desc File_Type_desc" );
		check_sql.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') Pat_Details " );
		check_sql.append("FROM" );
		check_sql.append("  mr_Pat_File_Index a" );
		check_sql.append("  , mr_file_type_lang_vw b " );
		check_sql.append("WHERE a.fs_Locn_Code IS" );
		check_sql.append("  NOT NULL " );
		check_sql.append("  AND B.LANGUAGE_ID='"+localeName+"'" );
		check_sql.append("  AND a.Facility_Id = '"+facility_id+"' " );
		check_sql.append("  AND a.facility_id = b.facility_id(+) " );
		check_sql.append("  AND a.file_type_code = b.file_type_code(+)" );

		check_sql.append(str);
	}
	if(stmt != null)stmt = null;

	
	stmt	=	con.createStatement();
	rs		=	stmt.executeQuery(check_sql.toString());
	if(rs.next())
	{
		%>
		<script>
			var msg =	getMessage('FILES_ALREADY_ASSIGNED','FM');
			displayMessage(msg);
		</script>
		<%
	}
	else
	{
		%>
		<script>
			var msg =	getMessage('NO_RECORDS_FOUND','FM');
			displayMessage(msg);
		</script>
		<%
	} 
	if((check_sql != null) && (check_sql.length() > 0))
	{
		check_sql.delete(0,check_sql.length());
	}
}%>
<table cellpadding='0' cellspacing='0' border='1' width='100%'  >
<%
if(file_type_appl_yn.equals("N"))
{
%>
<td width='20%' class='COLUMNHEADER'><fmt:message key="Common.fileno.label" bundle="${common_labels}"/></td>
<%
}
else if(file_type_appl_yn.equals("Y"))
{
%>
	<td class='COLUMNHEADER' width='10%' nowrap><fmt:message key="Common.filetype.label" bundle="${common_labels}"/></td>
<%
}
%>
<td class='COLUMNHEADER' width='50%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
<td width='15%' class='COLUMNHEADER'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
<td width='5%' class='COLUMNHEADER' ><fmt:message key="eFM.Assign.label" bundle="${fm_labels}"/>?</td>
<%
try
{
/*	Properties prop	=	new Properties();
	prop.put("Statement",stmt1);
	prop.put("login_id",login_id);
	prop.put("facility_id",facility_id);
	rs1	=	eFM.FMUtilities.getStorageLocn(prop);
*/
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		htRecord			=	(java.util.HashMap)	recordSet.getObject(i);

		file_no			=	(String)	htRecord.get("file_no");
		patient_id		=	(String)	htRecord.get("patient_id");
		file_type_code	=	(String)	htRecord.get("file_type_code");
		patient_name	=	(String)	htRecord.get("patient_name");		
		associate_yn	=	(String)	htRecord.get("associate_yn");
		pat_details		=	(String)	htRecord.get("pat_details");

		tblrow_id	=	"tblrow_id"+i;

		if(associate_yn.equals("Y"))
		{
			associate_yn_prop = " CHECKED ";
		}
		else
		{
			associate_yn_prop = " ";
		}

			if(file_type_appl_yn.equals("N"))
			{
%>
			<tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>' ><font size='1'><%=((file_no.equals(""))?"&nbsp;":file_no)%></font></td>
<%
			}
			else if(file_type_appl_yn.equals("Y"))
			{
%>
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' ><font size='1'><%=((file_type_desc.equals(""))?"&nbsp;":file_type_desc)%></font></td>
<%
			}
%>
			<td class='<%=classValue%>' ><font size='1'><%=((pat_details.equals(""))?"&nbsp;":pat_details)%></font></td>
			<td class='<%=classValue%>' align='center'><select name='fs_locn_code<%=i%>' id='fs_locn_code<%=i%>' onChange='checkAssign(this, "<%=i%>");'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option><%
			stmt2	=	con.createStatement();			
						
			//sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";				
			sql_query="select fs_locn_code,fm_Get_desc.Fm_storage_locn('"+facility_id+"',fs_Locn_Code,'"+localeName+"',2) short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";				

			rs1		=	stmt2.executeQuery(sql_query);
			
			
				while(rs1 != null && rs1.next())
				{
					fs_locn_code	=	rs1.getString("fs_locn_code");
					fs_desc			=	rs1.getString("short_desc");
					out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
				}
				if(rs1 != null) rs1.close();
				if(stmt2  != null) stmt2.close();
			
%>			</select></td>

			<td class='<%=classValue%>' align='center'><input type='checkbox' name='associate_yn<%=i%>' id='associate_yn<%=i%>' <%=associate_yn_prop%> value='Y' onClick='CBValue(this,"<%=i%>");'></td>
			</tr>
		<%
		}
%>
			<script>			
				enableFields();
			</script>		
<%
	}
	catch(Exception e)
	{
		out.println("Exception@2: "+e);
	}
	//session.putValue("AssignRecordSet",recordSet);
%>
</table>
<input type='hidden' name='row_count' id='row_count' value='<%=row_count%>'>
<input type='hidden' name='fm_disp' id='fm_disp' value='<%=fm_disp%>'>
<input type='hidden' name='to_disp' id='to_disp' value='<%=to_disp%>'>
<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
</form>
<%
	if(rs1 != null) rs1.close();
	if(rs != null) rs.close();
	if(stmt  != null) stmt.close();
	if(stmt1 != null) stmt1 = null;
	if(stmt2  != null) stmt2.close();
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

