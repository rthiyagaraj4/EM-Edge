<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/NoteType.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	String sql = "";
	int count =0;
	try
	{
		
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("notegroup") == null ? "" : request.getParameter("notegroup");
			
			sql = "SELECT note_group code, note_group_desc description FROM ca_note_group where eff_status='E' and upper(note_group_desc) like upper(?) order by 2";
	
			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
					out.println("parent.f_query_add_mod.document.NoteType_form.note_group_desc.value='"+rs.getString(2)+"' ");
					out.println("parent.f_query_add_mod.document.NoteType_form.flag.value='true' ");	out.println("parent.f_query_add_mod.document.NoteType_form.note_group_id.value='"+rs.getString(1)+"' ");
					out.println("setDocNote('"+rs.getString(1)+"')");
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				
				sql = "SELECT note_group code, note_group_desc description FROM ca_note_group where eff_status='E' and upper(note_group) like upper(?) and  upper(note_group_desc) like upper(?) order by 2";
%>
	<script>
	callState();
		 async function callState(){
retArray = await callFunction("<%=sql%>",getLabel("eCA.NoteGroup.label","CA"),parent.f_query_add_mod.document.NoteType_form.note_group_desc)
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retArray != null && retArray !="")	
			{
					parent.f_query_add_mod.document.NoteType_form.note_group_desc.value = arr[1];
					parent.f_query_add_mod.document.NoteType_form.note_group_id.value = arr[0];
					parent.f_query_add_mod.document.NoteType_form.flag.value = 'true'
					setDocNote(retArray[0]);					
					//parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				parent.f_query_add_mod.document.NoteType_form.note_group_desc.value = ''
				parent.f_query_add_mod.document.NoteType_form.note_group_id.value = ''
				parent.f_query_add_mod.document.NoteType_form.flag.value = 'true'
				parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			}
		 }			
	</script>
<%
		 }	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Note Type Populate Note Group Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
%>
 </body>
</html>

