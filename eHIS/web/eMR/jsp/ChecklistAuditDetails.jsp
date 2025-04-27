<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,java.net.*,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<html>
<%	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id = (String)session.getValue("facility_id");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String request_id = checkForNull(request.getParameter("request_id"));
	String req_code = checkForNull(request.getParameter("req_code"));
	String req_type = checkForNull(request.getParameter("req_type"));
	req_code = req_code.trim();
	req_type = req_type.trim();
	
	Connection con=null;
	con=ConnectionManager.getConnection(request);
	
	
	ResultSet rs				= null;
    PreparedStatement pstmt		= null;
	StringBuffer sql= new StringBuffer();
	
	String modified_date=checkForNull(request.getParameter("modified_date")); 
	String modified_by_id = checkForNull(request.getParameter("modified_by_id"));
	
%>
	<head>
	<script>
	function checkListView(request_code,request_type,request_id,modified_by_id,modified_date)
	{ 
	
	while(modified_date.indexOf(";")!=-1)
	modified_date=modified_date.replace(";" ,' ');
	window.location.href = "../jsp/ChecklistAuditDetails.jsp?req_type="+request_type+"&req_code="+request_code+"&modified_by_id="+modified_by_id+"&request_id="+request_id+"&modified_date="+modified_date ;	
	
	}
	
	</script>
	
	
	<title><fmt:message key="eMR.CheckListDetails.label" bundle="${mr_labels}"/></title>
	
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	
	</head>
<body onKeyDown='lockKey()'>
<form name='DiaplayAuditForm' id='DiaplayAuditForm'>
 <table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
 <tr>
 <th width="50%"> <fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/></th>
 <th width="50%"> <fmt:message key="Common.action.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>
 </tr>
 <tr>
 <td> </td>
 </tr>
 <%
 try
 {
	JSONArray checkListAuditJsonArr = new JSONArray();
	checkListAuditJsonArr = eMR.MRCommonBean.getAuditChecklist(con,request_id,facility_id);
	
	int clsCnt=1;
	String classValue= "";
	String check_list1_code = "";
	String modified_date1 = "";
	String modified_date_temp= "";
			for(int i = 0 ; i < checkListAuditJsonArr.size() ; i++) 
				{
					
					if ( clsCnt % 2 == 0 )
						classValue = "QRYEVENSMALL" ;
					else
						classValue = "QRYODDSMALL" ;
					
					JSONObject json	= (JSONObject)checkListAuditJsonArr.get(i);
					 modified_date_temp  = (String) json.get("modified_date");
					  modified_date1 = modified_date_temp;
					String modified_by_id1  = (String) json.get("modified_by_id");
					if(modified_date_temp!=null)
							modified_date_temp = modified_date_temp.replace(' ', ';');
					out.println("<tr>");				
					out.println("<td nowrap align='center' class='querydata'> ");
					out.println("<a href=javascript:void(checkListView('"+req_code+"','"+req_type+"','"+request_id+"','"+modified_by_id1+"','"+java.net.URLEncoder.encode(modified_date_temp)+"'));>"+modified_date1+"</a>");
					out.println("</td>");
					out.println("<td nowrap align='center' class='querydata' >"+modified_by_id1+"</td>");
				
					out.println("</tr>");
					clsCnt++;
				}

	if(!request_id.equals("") && !modified_date.equals("") && !modified_by_id.equals(""))
	{		
			
			JSONArray checkListJsonArr1 = new JSONArray();
			checkListJsonArr1= eMR.MRCommonBean.getChecklistValues(con,req_type,req_code);
			int count = checkListJsonArr1.size();
			JSONArray checkListJsonArr = new JSONArray();
			checkListJsonArr= eMR.MRCommonBean.getAuditChecklistValues(con,request_id,modified_date,modified_by_id,facility_id);
			
			if(checkListJsonArr.size() >0)
			{	
			JSONObject json	= (JSONObject)checkListJsonArr.get(0);
			String code = "";
			String desc = "";
			String status="";
			String sel_1="";
			String sel_2="";
			String sel_3="";
			
		
	  for(int i=0,j=1;i<count;i++,j++)
	  { 
		  String code_temp = "check_list_code_"+j;
		  String desc_temp = "check_list_desc_"+j;
		  String temp_status    = "check_list_status_"+j;
		  code = (String) json.get(code_temp);
		  
		  sel_1="";sel_2="";sel_3="";
		  
		  if(code != "")
		  {
			desc = (String) json.get(desc_temp); 
			status = (String) json.get(temp_status); 
			
			if(status.equals("Y"))sel_1="selected";
			if(status.equals("N"))sel_2="selected";
			if(status.equals("NA"))sel_3="selected";
 %>
<table border="0" width="100%" cellspacing='0' cellpadding='0'>
<tr><td>&nbsp;</td><td>&nbsp;</td><td colspan='4'>&nbsp;</td></tr>

<tr>
			<td  class="label" align="right" width="60%"><%=desc%>&nbsp;</td>
			<td align='left' class="label" colspan='4'>
				<select  disabled >
				<option value='Y' <%=sel_1%>   ><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
				<option value='N' <%=sel_2%>  >No</option>
				<option value='NA' <%=sel_3%>  ><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
		
</table>

 <%
		 }
	  }
	 
	}
	  
	}
 if(rs != null)	rs.close();
		if(pstmt != null)	pstmt.close();
 }
catch(Exception e){
	//out.println("Exception @ ChecklistAuditDetails.jsp "+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
 
 %>
 <tr><td>&nbsp;</td></tr>
 <tr><td>&nbsp;</td><td class='button' align = 'right' td colspan='2'  ><center><input type=button name="Close" id="Close" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="window.close();"></center></td></tr>
 </table>
<input type='hidden' name='request_id' id='request_id' value="<%=request_id%>"> 
<input type='hidden' name='req_type' id='req_type' value="<%=req_type%>"> 
<input type='hidden' name='req_code' id='req_code' value="<%=req_code%>"> 
<input type='hidden' name='modified_date' id='modified_date' value="<%=modified_date%>"> 
<input type='hidden' name='modified_by_id' id='modified_by_id' value="<%=modified_by_id%>">
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

