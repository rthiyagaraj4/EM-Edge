<!DOCTYPE html>
\<!-- by Meghanath -->
<%@ page contentType="text/html; charset=UTF-8" import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, webbeans.eCommon.RecordSet" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="recordSet" scope="session" class="webbeans.eCommon.RecordSet"/>
<%!int row_count=0;%>
<%
	Connection con	=	null;
	java.sql.Statement stmt	=	null;
//	java.sql.Statement stmt1	=	null;
	java.sql.Statement stmt2	=	null;
	ResultSet rs	=	null;
	ResultSet rs1	=	null;

	HashMap htRecord			=	new HashMap();
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
	//	stmt1	=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
	//	int row_disp	=9;
		int start		= 0 ;
		int end			= 0 ;
		int fm_disp=0, to_disp=0;

		String file_no="", patient_id="", patient_name="", associate_yn="N",associate_yn_prop="", tblrow_id="",classValue="",fs_locn_code="",fs_desc="",fn_locn_code="";
		String locn_identity = "", narration_code="", holder_name="", str="";
		String result_query  = "";
		String check_sql     = "";
		
		String facility_id			=	(String)session.getValue("facility_id");
	//	String login_id				=	(String)session.getValue("login_user");
		String from					=	request.getParameter( "from" ) ;
		String to					=	request.getParameter( "to" ) ;
		String mode					=	request.getParameter("mode") ;
		String file_type_code       =   "";
		String sql_query = "";

		String doc_type_code	= "";
		String doc_type_name	= "";
		String doc_folder_id	= "";
		String doc_folder_name	= "";
		String docline			= "";
		
		if(mode == null || mode.equals("null")) mode="";
		
		if ( from == null )
			start = 1 ;
		    else
			start = Integer.parseInt( from );

		if ( to == null )
	  		end = 9 ;
		else
			end = Integer.parseInt( to ) ;

		if(mode.equals(""))
		{
			str=request.getParameter("whereClause");
			if(str==null)str="";
			if(!(str.equals(""))) recordSet.clearAll();
			if(str==null)str="";
			else str = str.replace('~','%');
						
			result_query="SELECT a.file_no,a.patient_id,a.doc_folder_id,b.doc_folder_name,a.doc_type_code,c.doc_type_name,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE  ', ' || GET_PATIENT_LINE(b.PATIENT_ID,'"+localeName+"') END)  docline, a.file_type_code FROM mr_pat_file_index a,fm_doc_folder b,fm_doc_type c WHERE a.fs_locn_code is null AND a.facility_id='"+facility_id+"' AND a.facility_id = b.facility_id(+) AND a.doc_folder_id = b.doc_folder_id(+) AND a.doc_type_code = c.doc_type_code(+) " + str;
			
			rs=stmt.executeQuery(result_query);
			associate_yn="N";
			while(rs != null && rs.next())
			{
					docline				=	rs.getString("docline");
					file_no				=	rs.getString("file_no");
					doc_type_code		=	rs.getString("doc_type_code");
					doc_type_name		=	rs.getString("doc_type_name");
					doc_folder_id		=	rs.getString("doc_folder_id");
					doc_folder_name		=	rs.getString("doc_folder_name");
					patient_id			=	rs.getString("patient_id");
					file_type_code		=	rs.getString("file_type_code");		
					
					if(file_no == null || file_no.equals("null")) file_no = "";
					if(doc_type_code == null || doc_type_code.equals("null")) doc_type_code = "";
					if(doc_type_name == null || doc_type_name.equals("null")) doc_type_name = "";
					if(doc_folder_id == null || doc_folder_id.equals("null")) doc_folder_id = "";
					if(doc_folder_name == null || doc_folder_name.equals("null")) doc_folder_name = "";
					if(patient_id == null || patient_id.equals("null")) patient_id = "";
					if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
					if(patient_name == null || patient_name.equals("null")) patient_name = "";
					if(docline == null || docline.equals("null")) docline = "";					
					
					htRecord.put("file_no"		  ,	file_no);
					htRecord.put("doc_folder_id"  ,	doc_folder_id);
					htRecord.put("doc_type_code"  ,	doc_type_code);
					htRecord.put("patient_id"	  ,	patient_id);
					htRecord.put("file_type_code" ,	file_type_code);
					htRecord.put("patient_name"	  ,	patient_name);				
					htRecord.put("associate_yn"	  ,	associate_yn);
					htRecord.put("fn_locn_code"	  ,	fn_locn_code);
					htRecord.put("locn_identity"  ,	locn_identity);
					htRecord.put("narration_code" ,	narration_code);
					htRecord.put("holder_name"	  ,	holder_name);
					htRecord.put("docline"	      ,	docline);
			
					recordSet.putObject(htRecord);
			}
			if(rs != null) rs.close();
			row_count				=	recordSet.getSize();
			htRecord.clear();

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
					<A HREF='../jsp/FMAssignStorageLocnMainResult.jsp?from=<%=start-9%>&to=<%=end-9%>mode=Previous' onClick='checkVal();' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%
				}
				if ( !( (start+9) > row_count ) )
				{
%>
					<A HREF='../jsp/FMAssignStorageLocnMainResult.jsp?from=<%=(start+9)%>&to=<%=(end+9)%>mode=next' onClick='checkVal();' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%
				}
%>
			</td>
		</tr>
	</table>
	<br><br>
	</P>
<%
	if(row_count==0)
	{
		check_sql="select a.file_no,a.patient_id,a.doc_folder_id,b.doc_folder_name,a.doc_type_code,c.doc_type_name,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE b.patient_id END)  docline,a.file_type_code from mr_pat_file_index a,fm_doc_folder b,fm_doc_type c WHERE a.fs_locn_code is not null and a.facility_id='"+facility_id+"' AND a.facility_id = b.facility_id(+) AND a.doc_folder_id = b.doc_folder_id(+) AND a.doc_type_code = c.doc_type_code(+) "+ str;
	
	
	if(stmt  != null) stmt.close();
	stmt	=	con.createStatement();
	rs		=	stmt.executeQuery(check_sql);
	if(rs.next())
	{
%>
		<script>
			var msg =	getMessage('DOC_ALREADY_ASSIGNED','FM');
			if(msg!="")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}
			parent.FMAssnStrLocnSubResultFrame.document.forms[0].locn_code.disabled = "true";
		</script>
<%
	}
	else
	{
%>
		<script>
			var msg =	getMessage('NO_RECORDS_FOUND','FM');
			if(msg!="")
			{
parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}
parent.FMAssnStrLocnSubResultFrame.document.forms[0].locn_code.disabled = "true";
		</script>
<%
	}

}%>
<table cellpadding='0' cellspacing='0' border='1' width='100%' >
<td width='50%' class='columnheader'><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
<td width='20%' class='columnheader'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
<td width='20%' class='columnheader' nowrap><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
<td width='10%' class='columnheader'><fmt:message key="eFM.Assign.label" bundle="${fm_labels}"/>?</td>
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
		doc_folder_id	=	(String)	htRecord.get("doc_folder_id");
		doc_type_code	=	(String)	htRecord.get("doc_type_code");
		patient_id		=	(String)	htRecord.get("patient_id");
		file_type_code	=	(String)	htRecord.get("file_type_code");		
		associate_yn	=	(String)	htRecord.get("associate_yn");
		docline			=	(String)	htRecord.get("docline");

		tblrow_id	=	"tblrow_id"+i;

		if(associate_yn.equals("Y"))
			associate_yn_prop = " CHECKED ";
		else
			associate_yn_prop = " ";
%>
		<tr id='<%=tblrow_id%>'>
		<td class='<%=classValue%>'  width='50%'><font size='1'><B><%=((doc_folder_id.equals(""))?"&nbsp;":doc_folder_id)%></B></font><BR>&nbsp;&nbsp;
		<font size='1'><%=((doc_folder_name.equals(""))?"&nbsp;":doc_folder_name)%></font>
		<font size='1'><%=((docline.equals(""))?"&nbsp;":docline)%></font></td>
		<TD class='<%=classValue%>'  width='20%'><font size='1'><%=((doc_type_name.equals(""))?"&nbsp;":doc_type_name)%></font></TD>
		<td class='<%=classValue%>' align='center' width='20%'><select name='fs_locn_code<%=i%>' id='fs_locn_code<%=i%>' onChange='checkAssign(this, "<%=i%>");'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option><%

		stmt2	=	con.createStatement();			
						
			sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";				

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
			<td class='<%=classValue%>' align='center' width='10%'><input type='checkbox' name='associate_yn<%=i%>' id='associate_yn<%=i%>' <%=associate_yn_prop%> value='Y' onClick='CBValue(this,"<%=i%>");'></td>
			</tr>
<%
	}
%>
			<script>			parent.frames[0].document.forms[0].search_dtl.disabled=false;
			parent.frames[0].document.forms[0].reset1.disabled=false;
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
</form>
<%
if(rs != null) rs.close();
if(stmt  != null) stmt.close();
//if(stmt1 != null) stmt1 = null;
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

