
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

		<script language="JavaScript" src ="../../eCA/js/SectionForNoteType.js"></script>
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
			description = request.getParameter("note") == null ? "" : request.getParameter("note");
			sql ="SELECT note_type code, note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type_desc) like upper(?) order by note_type_desc";
		
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
					out.println("parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type_txt.value='"+rs.getString(2)+"' ");
					out.println("parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.flag.value='true' ");	out.println("parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type.value='"+rs.getString(1)+"' ");

				}
			}
			if(rs != null) rs.close();
			out.println("</script>");

			if(count == 0 || count > 1)
			{
				sql = "SELECT note_type code,note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type) like upper(?) and  upper(note_type_desc) like upper(?) ORDER BY  note_type_desc";
%>
	<script>
	notetypeCallingFun();
	async function notetypeCallingFun(){
		 retArray = await callnotetype1("<%=sql%>","NoteType",parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type_txt)
			if(retArray != null && retArray !="")	
			{
							var ret1=unescape(retArray);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}
				    parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type_txt.value = arr[1];
					parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type.value = arr[0];

					parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.flag.value = 'true'
			
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type_txt.value = ''
				parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type.value = ''
				parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.flag.value = 'true'
				parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
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
		//out.println("Exception in Section For Note Type Intermediate Module "+ee.toString());//COMMON-ICN-0181
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

