<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js"></script>
		<script src="../../eCommon/js/common.js"></script>
		<script src='../../eCA/js/TextBlock.js' language='javascript'></script>
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
	String selFunVal="";
	//String Page="";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	//String p_facility_id="";
	String sql = "";
	int count =0;	
	try
	{		
		
			con = ConnectionManager.getConnection(request);
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			if(selFunVal.equals("Service"))
			{
			sql="SELECT service_code code, short_desc description FROM am_service where eff_status='E' and   upper(short_desc) like upper(?) order by 2";
			}
			else if(selFunVal.equals("Practitioner"))
			{
			sql="SELECT practitioner_id code, practitioner_name description FROM am_practitioner where eff_status='E' and   upper(practitioner_name) like upper(?) order by 2";
			}
			else if(selFunVal.equals("NoteType"))
			{
			sql="SELECT note_type code, note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type_desc) like upper(?) order by 2";
			}

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
				if (selFunVal.equals("Service"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.Textblock_form.service_desc.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.Textblock_form.service.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("Practitioner"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.Textblock_form.practitioner_desc.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.Textblock_form.practitioner.value='"+rs.getString(1)+"' ");

					}
				}
				else if (selFunVal.equals("NoteType"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.Textblock_form.Note_Type_Desc.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.Textblock_form.notetype.value='"+rs.getString(1)+"' ");

					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
								
				if(selFunVal.equals("Service"))
				{
				sql="SELECT service_code code, short_desc description FROM am_service where eff_status='E' and upper(service_code) like upper(?) and  upper(short_desc) like upper(?) order by 2";
				}
				else if(selFunVal.equals("Practitioner"))
				{
				sql="SELECT practitioner_id code, practitioner_name description FROM am_practitioner where eff_status='E' and upper(practitioner_id) like upper(?) and  upper(practitioner_name) like upper(?) order by 2";
				}
				else if(selFunVal.equals("NoteType"))
				{
				sql="SELECT note_type code, note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type) like upper(?) and  upper(note_type_desc) like upper(?) order by 2";
				}
				
	%>
	<script>
	 var chkVal = "<%=selFunVal%>";
	//alert(chkVal);
	if (chkVal=="Service")
	{
		retArray = callFunction("<%=sql%>",getLabel("Common.service.label",'common'),parent.f_query_add_mod.document.Textblock_form.service_desc)
			
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.Textblock_form.service_desc.value = retArray[1];
					parent.f_query_add_mod.document.Textblock_form.service.value = retArray[0];					
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.Textblock_form.service_desc.value = '';
					parent.f_query_add_mod.document.Textblock_form.service.value = '';	
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="Practitioner")
	{
		retArray = callFunction("<%=sql%>",getLabel('Common.practitioner.label','common'),parent.f_query_add_mod.document.Textblock_form.practitioner_desc)
			
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.Textblock_form.practitioner_desc.value = retArray[1];
					parent.f_query_add_mod.document.Textblock_form.practitioner.value = retArray[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.Textblock_form.practitioner_desc.value ='';
					parent.f_query_add_mod.document.Textblock_form.practitioner.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="NoteType")
	{
		retArray = callFunction("<%=sql%>",getLabel("Common.NoteType.label",'common'),parent.f_query_add_mod.document.Textblock_form.Note_Type_Desc)
			
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.Textblock_form.Note_Type_Desc.value = retArray[1];
					parent.f_query_add_mod.document.Textblock_form.notetype.value = retArray[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.Textblock_form.Note_Type_Desc.value ='';
					parent.f_query_add_mod.document.Textblock_form.notetype.value = '';
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
		//out.println("Exception in TextBlock intermediate  "+ee.toString());//COMMON-ICN-0181
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

