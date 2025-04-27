<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js"></script>
		<script src="../../eCommon/js/common.js"></script>
		
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
		<script src='../../eCA/js/repResetRunList.js' language='javascript'></script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
	String selFunVal="";
	String Page="";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	String p_facility_id="";
	String sql = "";
	int count =0;
	Page = request.getParameter("PageName")==null ? "" : request.getParameter("PageName");
	try
	{		
	con = ConnectionManager.getConnection(request);	
	if(Page.equals("repLocnForPract")){
	
			
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("practitioner_id") == null ? "" : request.getParameter("practitioner_id");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");			
			//sql="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"' and  upper(practitioner_name) like upper(?) order by 2";//common-icn-0180
			sql="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id =? and  upper(practitioner_name) like upper(?) order by 2";//common-icn-0180

			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,p_facility_id);//common-icn-0180
			ps.setString(2,description);//common-icn-0180
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("Fr_Practitioner"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id.value='"+rs.getString(1)+"' ");

					}
				}
				else if (selFunVal.equals("To_Practitioner"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.value='"+rs.getString(2)+"' ");						
						out.println("parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id.value='"+rs.getString(1)+"' ");

					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"' and  upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2  ";
				
	%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
	if (chkVal=="Fr_Practitioner")
	{
		retArray = await callFunction("<%=sql%>",getLabel('Common.practitioner.label','common'),parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.value = arr[1];
					parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id.value = arr[0];					
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id1.value = '';
					parent.f_query_add_mod.document.repLocnForPract.p_fr_practitioner_id.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="To_Practitioner")
	{
		retArray = await callFunction("<%=sql%>",getLabel('Common.practitioner.label','common'),parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.value = arr[1];
					parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id1.value = '';
					parent.f_query_add_mod.document.repLocnForPract.p_to_practitioner_id.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	}
	toOpenShowModal();
	</script>
	<%
		 }	
	}
	//...............Location for Practitioner-ends 

	//.............repNoteType-start
	else if(Page.equals("repNoteType"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			sql="select note_type code, note_type_desc description from ca_note_type where  upper(note_type_desc) like upper(?) order by 2";				
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
				if (selFunVal.equals("From_code"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteType.p_fr_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteType.p_fr_note_type.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_code"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteType.p_to_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteType.p_to_note_type.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{								
				sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2 ";				
	%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
	if (chkVal=="From_code")
	{
		retArray = await callFunction("<%=sql%>",getLabel("Common.NoteType.label","Common"),parent.f_query_add_mod.document.repNoteType.p_fr_note_type1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repNoteType.p_fr_note_type1.value = arr[1];
					parent.f_query_add_mod.document.repNoteType.p_fr_note_type.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repNoteType.p_fr_note_type1.value= '';
					parent.f_query_add_mod.document.repNoteType.p_fr_note_type.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="To_code")
	{
		retArray = await callFunction("<%=sql%>",getLabel("Common.NoteType.label","Common"),parent.f_query_add_mod.document.repNoteType.p_to_note_type1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repNoteType.p_to_note_type1.value = arr[1];
					parent.f_query_add_mod.document.repNoteType.p_to_note_type.value = arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repNoteType.p_to_note_type1.value = '';
					parent.f_query_add_mod.document.repNoteType.p_to_note_type.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	}
	toOpenShowModal();
		</script>
	<%
		 }		
	}
	//.............repNoteType-start


	//.............repNoteTypeForResp-start
	else if(Page.equals("repNoteTypeForResp"))
	{		
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");				
			sql=" Select resp_id code,resp_name description from sm_resp where upper(resp_name) like upper(?) order by 2 ";
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
				if (selFunVal.equals("From_Resp"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_resp"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql=" Select resp_id code,resp_name description from sm_resp where upper(resp_id) like upper(?) and upper(resp_name) like upper(?) order by 2 ";
				
%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
if (chkVal=="From_Resp")
{
		retArray = await callFunction("<%=sql%>","Responsibility",parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1.value= arr[1];
					parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
				}
				else
				{
					parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id1.value= '';
					parent.f_query_add_mod.document.repNoteTypeForResp.p_fr_resp_id.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
}
else if (chkVal=="To_resp")
{
		retArray = await callFunction("<%=sql%>","Responsibility",parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1.value = arr[1];
					parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id.value = arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
				}
				else
				{
					parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id1.value = '';
					parent.f_query_add_mod.document.repNoteTypeForResp.p_to_resp_id.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
}
	}
	toOpenShowModal();
	</script>
<%
		 }	
	}
	//.............repNoteTypeForResp--end
	
	//.............NoteTypeByService-start
	else if(Page.equals("repNoteTypeByService"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");				
			sql=" Select note_type code,note_type_desc description  from ca_note_type where upper(note_type_desc) like upper(?) and SERV_FACL_SPEC_YN = 'Y' order by 2 ";
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
				if (selFunVal.equals("From_NoteTypeService"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_NoteTypeService"))
				{
					while(rs.next())
					{	
					 out.println("parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type1.value='"+rs.getString(2)+"' ");
					 out.println("parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql=" Select note_type code,note_type_desc description  from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) and SERV_FACL_SPEC_YN = 'Y' order by 2 ";
				
%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
if (chkVal=="From_NoteTypeService")
{
		retArray = await callFunction("<%=sql%>",getLabel("Common.NoteType.label","Common"),parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1.value= arr[1];
					parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type1.value= '';
					parent.f_query_add_mod.document.repNoteTypeByService.p_fr_note_type.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
}
else if (chkVal=="To_NoteTypeService")
{
		retArray = await callFunction("<%=sql%>",getLabel("Common.NoteType.label","Common"),parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type1.value = arr[1];
					parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type.value = arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type1.value = '';
					parent.f_query_add_mod.document.repNoteTypeByService.p_to_note_type.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
}
	}
	toOpenShowModal();
	</script>
<%
		 }		
	}
	//.............NoteTypeByService--end

//.................repSection---start
	else if(Page.equals("repSection"))
	{
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");				
			sql="select sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where upper(sec_hdg_desc) like upper(?)";
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
				if (selFunVal.equals("From_codesection"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_codesection"))
				{
					while(rs.next())
					{	
					 out.println("parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code1.value='"+rs.getString(2)+"' ");
					 out.println("parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql="select sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?)";		
				
%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
if (chkVal=="From_codesection")
{
		retArray = await callFunction("<%=sql%>",getLabel("Common.Section.label","Common"),parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code1.value= arr[1];
					parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code1.value= '';
					parent.f_query_add_mod.document.repSection.p_fr_sec_hdg_code.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
}
else if (chkVal=="To_codesection")
{
		retArray = await callFunction("<%=sql%>",getLabel("Common.Section.label","Common"),parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code1.value = arr[1];
					parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code.value = arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code1.value = "";
					parent.f_query_add_mod.document.repSection.p_to_sec_hdg_code.value = "";
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
}
	}
	toOpenShowModal();
	</script>
<%
		 }		
	}
	//.............reportSection--end


	//.............repSectionForNoteType-start
	else if(Page.equals("repSectionForNoteType"))
	{
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type_desc) like upper(?) order by 2";			
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
				if (selFunVal.equals("From_SecNoteType"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("To_SecNoteType"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{								
				sql="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2";				
	%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
	if (chkVal=="From_SecNoteType")
	{
		retArray = await callFunction("<%=sql%>",getLabel("Common.NoteType.label","Common"),parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1.value = arr[1];
					parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type1.value= '';
					parent.f_query_add_mod.document.repSectionForNoteType.p_fr_note_type.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="To_SecNoteType")
	{
		retArray = await callFunction("<%=sql%>",getLabel("Common.NoteType.label","Common"),parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type1.value = arr[1];
					parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type.value= arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type1.value = '';
					parent.f_query_add_mod.document.repSectionForNoteType.p_to_note_type.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	}
	toOpenShowModal();
		</script>
	<%
		 }	
	
	}
	//.............repSectionForNoteType-end

	//.............repSubSection-start
	else if(Page.equals("repsubSection"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			sql="SELECT sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where content_type ='S' and upper(sec_hdg_desc) like upper(?) ";		
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
				if (selFunVal.equals("From_subSection"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repSubSection.p_fr_header_code1.value='"+rs.getString(2)+"'");
   	                    out.println("parent.f_query_add_mod.document.repSubSection.p_fr_header_code.value='"+rs.getString(1)+"'");
					}					
				}				
				else if (selFunVal.equals("To_subSection"))
				{
					while(rs.next())
					{
						out.println("parent.f_query_add_mod.document.repSubSection.p_to_header_code1.value='"+rs.getString(2)+"'");
   	                    out.println("parent.f_query_add_mod.document.repSubSection.p_to_header_code.value='"+rs.getString(1)+"'");
					}
					
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{								
				sql="SELECT sec_hdg_code code, sec_hdg_desc description from ca_section_hdg where content_type ='S' and upper(sec_hdg_code) like upper(?) and upper(sec_hdg_desc) like upper(?) ";				
	%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
	if (chkVal=="From_subSection")
	{
		retArray = await callFunction("<%=sql%>",getLabel("Common.Section.label","Common"),parent.f_query_add_mod.document.repSubSection.p_fr_header_code1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repSubSection.p_fr_header_code1.value = arr[1];
					parent.f_query_add_mod.document.repSubSection.p_fr_header_code.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repSubSection.p_fr_header_code1.value= '';
					parent.f_query_add_mod.document.repSubSection.p_fr_header_code.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="To_subSection")
	{
		retArray = await callFunction("<%=sql%>",getLabel("Common.Section.label","Common"),parent.f_query_add_mod.document.repSubSection.p_to_header_code1);
		var str =unescape(retArray);
		var arr = str.split(",");	
		if(retArray != null && retArray !="")	
		{
		parent.f_query_add_mod.document.repSubSection.p_to_header_code1.value = arr[1];
		parent.f_query_add_mod.document.repSubSection.p_to_header_code.value= arr[0];	
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';	
		}
		else
		{
		parent.f_query_add_mod.document.repSubSection.p_to_header_code1.value = '';
		parent.f_query_add_mod.document.repSubSection.p_to_header_code.value= '';		
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
		}
	}
	}
	toOpenShowModal();
		</script>
	<%
		 }	
	
	}
	//.............repSubSection-end


	//.............repTextBlock-start
	else if(Page.equals("repTextBlock"))
	{
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			sql="select text_blk_id code, text_blk description from  ca_text_blk_by_serv_pract where upper(text_blk_id) like upper(?) order by 2";	
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
				if (selFunVal.equals("From_TextBlockCode"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id1.value='"+rs.getString(1)+"'");	out.println("parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value='"+rs.getString(1)+"'");
						
					}
				}
				else if (selFunVal.equals("To_TextBlockCode"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id1.value='"+rs.getString(1)+"' ");
						out.println("parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{								
				sql="select text_blk_id code, text_blk description from  ca_text_blk_by_serv_pract where upper(text_blk_id) like upper(?) and upper(text_blk) like upper(?) order by 2";				
	%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
	if (chkVal=="From_TextBlockCode")
	{
		retArray = await callFunctionTextBlock("<%=sql%>","Text Block",parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id1)			
		var str =unescape(retArray);
		var arr = str.split(",");		
		if((retArray[0] != null && retArray[0] !="" ))	
				{
					parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id1.value = arr[0];
					parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id1.value= '';
					parent.f_query_add_mod.document.repTextBlock.p_fr_text_blk_id.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="To_TextBlockCode")
	{
		retArray = await callFunctionTextBlock("<%=sql%>","Text Block",parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id1)
		var str =unescape(retArray);
		var arr = str.split(",");
				if(retArray[0] != null && retArray[0] !="")	
				{
					parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id1.value= arr[0];
					parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value= arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id1.value = '';
					parent.f_query_add_mod.document.repTextBlock.p_to_text_blk_id.value= '';		
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	}
	toOpenShowModal();
		</script>
	<%
		 }	
	
	}
	//.............repTextBlock-end


	//.............RepUnsignedNote-start
	else if(Page.equals("repUnsignedNote"))
	{
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			
			if(selFunVal.equals("PractUnsignednote"))
				{			
					//sql=" select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"'  and upper(practitioner_name) like upper(?) order by 2 ";	//common-icn-0180				
					sql=" select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id =?  and upper(practitioner_name) like upper(?) order by 2 ";//common-icn-0180						
					
				}
				else if(selFunVal.equals("NoteTypeUnsignednote"))
				{					
					sql=" select note_type code, note_type_desc description from ca_note_type where upper(note_type_desc) like upper(?) order by 2 ";					
				}
			
			description = description + "%";
			ps = con.prepareStatement(sql);
			//common-icn-0180	 starts
			if(selFunVal.equals("PractUnsignednote")){
			ps.setString(1,p_facility_id);
			ps.setString(2,description);
			}
			if(selFunVal.equals("NoteTypeUnsignednote")){
			ps.setString(1,description);
			}
			//common-icn-0180 end
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("PractUnsignednote"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("NoteTypeUnsignednote"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_add_mod.document.repUnsignedNote.p_note_type1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_add_mod.document.repUnsignedNote.p_note_type.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{	
				if(selFunVal.equals("PractUnsignednote"))
				{					
					sql=" select distinct b.practitioner_id code, b.practitioner_name description  from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+p_facility_id+"'  and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2 ";	
				}
				else if(selFunVal.equals("NoteTypeUnsignednote"))
				{
					sql=" select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) order by 2 ";
				}		
	%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
	if (chkVal=="PractUnsignednote")
	{
		retArray = await callFunction("<%=sql%>",getLabel('Common.practitioner.label','COMMON'),parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id1)
		var str =unescape(retArray);
		var arr = str.split(",");	
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id1.value = arr[1];
					parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id1.value = '';
					parent.f_query_add_mod.document.repUnsignedNote.p_practitioner_id.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="NoteTypeUnsignednote")
	{
		retArray = await callFunction("<%=sql%>","Note Type",parent.f_query_add_mod.document.repUnsignedNote.p_note_type1)
		var str =unescape(retArray);
		var arr = str.split(",");	
				if(retArray != null && retArray !="")	
				{
					parent.f_query_add_mod.document.repUnsignedNote.p_note_type1.value= arr[1];
					parent.f_query_add_mod.document.repUnsignedNote.p_note_type.value= arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_add_mod.document.repUnsignedNote.p_note_type1.value = '';
					parent.f_query_add_mod.document.repUnsignedNote.p_note_type.value= '';		
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	}
	toOpenShowModal();
		</script>
	<%
		 }		
	}
	//.............RepUnsignedNote-end

//.............ReportspractNoteTypeList-start
	else if(Page.equals("ReportspractNoteTypeList"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");			
			if(selFunVal.equals("fmpractnotetypelist")||selFunVal.equals("topractnotetypelist"))
			{
					//sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+p_facility_id+"' and upper(b.practitioner_name) like upper(?)";//common-icn-0180				
					sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id=? and upper(b.practitioner_name) like upper(?)";	//common-icn-0180				

			}
			else if(selFunVal.equals("fmnotetypelist")||selFunVal.equals("tonotetypelist"))
			{					
					sql ="select note_type code, note_type_desc description from ca_note_type where upper(note_type_desc) like upper(?)";
			}
			
			
			description = description + "%";
			ps = con.prepareStatement(sql);
			//common-icn-0180 starts
			if(selFunVal.equals("fmpractnotetypelist")||selFunVal.equals("topractnotetypelist")){
			ps.setString(1,p_facility_id);
			ps.setString(2,description);
			}
			if(selFunVal.equals("fmnotetypelist")||selFunVal.equals("tonotetypelist")){
			ps.setString(1,description);
			}
			//common-icn-0180 end
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("fmpractnotetypelist"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practNoteTypeReports.fm_pract1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practNoteTypeReports.fm_pract.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("topractnotetypelist"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practNoteTypeReports.to_pract1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practNoteTypeReports.to_pract.value='"+rs.getString(1)+"' ");
					}
				}
				
				else if (selFunVal.equals("fmnotetypelist"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practNoteTypeReports.fm_noteType1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practNoteTypeReports.fm_noteType.value='"+rs.getString(1)+"' ");
					}
				}				
				else if (selFunVal.equals("tonotetypelist"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practNoteTypeReports.to_noteType1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practNoteTypeReports.to_noteType.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{	
				if(selFunVal.equals("fmpractnotetypelist")||selFunVal.equals("topractnotetypelist"))
				{								
					sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+p_facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?)";
				}
				else if(selFunVal.equals("fmnotetypelist")||selFunVal.equals("tonotetypelist"))
				{
					sql ="select note_type code, note_type_desc description from ca_note_type where upper(note_type) like upper(?) and upper(note_type_desc) like upper(?)";
				}
	%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
	if (chkVal=="fmpractnotetypelist")
	{
		retArray = await callFunction("<%=sql%>",getLabel('Common.practitioner.label','COMMON'),parent.f_query_rep.document.practNoteTypeReports.fm_pract1)
		var str =unescape(retArray);
		var arr = str.split(",");	
				if(retArray != null && retArray !="")	
				{
					parent.f_query_rep.document.practNoteTypeReports.fm_pract1.value = arr[1];
					parent.f_query_rep.document.practNoteTypeReports.fm_pract.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_rep.document.practNoteTypeReports.fm_pract1.value = '';
					parent.f_query_rep.document.practNoteTypeReports.fm_pract.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="topractnotetypelist")
	{
		retArray = await callFunction("<%=sql%>","Note Type",parent.f_query_rep.document.practNoteTypeReports.to_pract1)
		var str =unescape(retArray);
		var arr = str.split(",");	
				if(retArray != null && retArray !="")	
				{
					parent.f_query_rep.document.practNoteTypeReports.to_pract1.value= arr[1];
					parent.f_query_rep.document.practNoteTypeReports.to_pract.value= arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_rep.document.practNoteTypeReports.to_pract1.value = '';
					parent.f_query_rep.document.practNoteTypeReports.to_pract.value = '';		
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="fmnotetypelist")
	{
		retArray = await callFunction("<%=sql%>","Note Type",parent.f_query_rep.document.practNoteTypeReports.fm_noteType1)
		var str =unescape(retArray);
		var arr = str.split(",");	
				if(retArray != null && retArray !="")	
				{
					parent.f_query_rep.document.practNoteTypeReports.fm_noteType1.value= arr[1];
					parent.f_query_rep.document.practNoteTypeReports.fm_noteType.value= arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_rep.document.practNoteTypeReports.fm_noteType1.value = '';
					parent.f_query_rep.document.practNoteTypeReports.fm_noteType.value= '';		
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="tonotetypelist")
	{
		retArray = await callFunction("<%=sql%>","Note Type",parent.f_query_rep.document.practNoteTypeReports.to_noteType1)
		var str =unescape(retArray);
		var arr = str.split(",");	
				if(retArray != null && retArray !="")	
				{
					parent.f_query_rep.document.practNoteTypeReports.to_noteType1.value= arr[1];
					parent.f_query_rep.document.practNoteTypeReports.to_noteType.value= arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_rep.document.practNoteTypeReports.to_noteType1.value = '';
					parent.f_query_rep.document.practNoteTypeReports.to_noteType.value= '';		
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	}
	toOpenShowModal();
		</script>
	<%
		 }		
	}
	//.............ReportspractNoteTypeList-end

	//.............RepPractLocationList-start
	else if(Page.equals("ReportPractLocationType"))
	{	
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			description = request.getParameter("description") == null ? "" : request.getParameter("description");
			p_facility_id=request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
			
			if(selFunVal.equals("fmpractLoctypeRep")||selFunVal.equals("topractLoctypeRep"))
			{			
				//sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+p_facility_id+"' and upper(b.practitioner_name) like upper(?)"; //common-icn-0180									
				sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id=? and upper(b.practitioner_name) like upper(?)"; //common-icn-0180								
				
			}			
			description = description + "%";
			ps = con.prepareStatement(sql);
			//common-icn-0180 starts
			if(selFunVal.equals("fmpractLoctypeRep")||selFunVal.equals("topractLoctypeRep")){
			ps.setString(1,p_facility_id);
			ps.setString(2,description);
			}
			//common-icn-0180 ends
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if (selFunVal.equals("fmpractLoctypeRep"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id.value='"+rs.getString(1)+"' ");
					}
				}
				else if (selFunVal.equals("topractLoctypeRep"))
				{
					while(rs.next())
					{	
						out.println("parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1.value='"+rs.getString(2)+"' ");
						out.println("parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id.value='"+rs.getString(1)+"' ");
					}
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{	
				if(selFunVal.equals("fmpractLoctypeRep")||selFunVal.equals("topractLoctypeRep"))
				{					
					sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+p_facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?)";	
				}
				
	%>
	<script>
	async function toOpenShowModal(){
	 var chkVal = "<%=selFunVal%>";
	if (chkVal=="fmpractLoctypeRep")
	{
		retArray = await callFunction("<%=sql%>",getLabel('Common.practitioner.label','COMMON'),parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1)
		var str =unescape(retArray);
		var arr = str.split(",");	
				if(retArray != null && retArray !="")	
				{
					parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1.value = arr[1];
					parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id.value = arr[0];
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id1.value = '';
					parent.f_query_rep.document.practLocationTypeReports.p_fr_practitioner_id.value = '';
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	else if (chkVal=="topractLoctypeRep")
	{
		retArray = await callFunction("<%=sql%>",getLabel('Common.practitioner.label','COMMON'),parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1)
		var str =unescape(retArray);
		var arr = str.split(",");	
				if(retArray != null && retArray !="")	
				{
					parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1.value= arr[1];
					parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id.value= arr[0];				
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id1.value = '';
					parent.f_query_rep.document.practLocationTypeReports.p_to_practitioner_id.value= '';		
					parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
	}
	}
	toOpenShowModal();
		</script>
	<%
		 }
		}
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Report-PractLocationList "+ee.toString());//common-icn-0181
		  ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
	
	//.............RepPractLocationList-end

%>
 </body>
</html>

