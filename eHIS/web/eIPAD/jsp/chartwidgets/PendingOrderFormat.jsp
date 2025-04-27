<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@page import="eIPAD.chartsummary.pendingorders.response.PendingOrderFormatResponse"%>
<%@ page import="java.util.ArrayList"%>
<%@page  import="eCommon.Common.CommonBean" %>

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
PendingOrderFormatResponse orderFormatResp = (PendingOrderFormatResponse)request.getAttribute("POFormatResponse");
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();

if(orderFormatResp!=null){
	errorList = orderFormatResp.getErrorsList();
}

%>


<div style="width:100%;" data-role = "none">
	<%
	String lineId = request.getParameter("LineNum")==null?"":request.getParameter("LineNum");
		if(orderFormatResp.isSuccessResponse()&&!orderFormatResp.isEmptyDataResponse()){
			List<String[]> order_format_dtl = orderFormatResp.getOrderFormatDtl();
			if(order_format_dtl!=null){
				%>
<table cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
<% 

	int j=0;
	String disabled = " disabled ";
	String checked = "";
	String colspan = "0";
	String order_format_field_values="";
	int transplant_exists = 0;
	String transplant_checked = "";
	String display_transplant = "";

	for(int i=0; i<order_format_dtl.size(); i++)
	{
		if(i%2 == 0)
		{
			out.println("<tr>");
			j++;
		}

		String record[] = (String[])order_format_dtl.get(i);
		record[0]=CommonBean.checkForNull(record[0],"");
		record[1]=CommonBean.checkForNull(record[1],"");
		record[2]=CommonBean.checkForNull(record[2],"");
		record[3]=CommonBean.checkForNull(record[3],"");
		record[4]=CommonBean.checkForNull(record[4],"");

		if(record[0].equals("E"))
		{ 			
			record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en","en");				
		}
		else if(record[0].equals("D"))
        {
			record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMY","en","en");				
		}

		if(lineId.equals("")) 
		{
			order_format_field_values = CommonBean.checkForNull(record[2],"")+" "+CommonBean.checkForNull(record[4],"");
		}
		else
		{
			record[5]=CommonBean.checkForNull(record[5],"");
			record[6]=CommonBean.checkForNull(record[6],"");
			record[7]=CommonBean.checkForNull(record[7],"");
			order_format_field_values = CommonBean.checkForNull(record[2],"")+" "+CommonBean.checkForNull(record[7],"");
		}
	
		if(lineId.equals("")) 
		{
			if(record[5].equals("TRANSPLANT_PAT_YN"))
			{
				transplant_exists++;
				if(record[0].equals("C"))
				{
 					if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
						transplant_checked = "";
					else transplant_checked = "checked";
				}
			}
			if(transplant_exists>0 &&transplant_checked.equalsIgnoreCase(""))
			{		
				if(record[5].equals("DONOR_BLOOD_GROUP")||record[5].equals("DONOR_RHESUS")||record[5].equals("TRANSPLANT_DATE"))
				{
					display_transplant="display:none";
				}
				else
				{
					display_transplant="display:inline";
				}
			}
			else
			{
				display_transplant="display:inline";
			}
		}
		else
		{
			if(record[4].equals("TRANSPLANT_PAT_YN"))
			{
				transplant_exists++;
				if(record[0].equals("C"))
				{
 					if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
						transplant_checked = "";
					else transplant_checked = "checked";
				}
			}
			if(transplant_exists>0 &&transplant_checked.equalsIgnoreCase(""))
			{		
				if(record[4].equals("DONOR_BLOOD_GROUP")||record[4].equals("DONOR_RHESUS")||record[4].equals("TRANSPLANT_DATE"))
				{
					display_transplant="display:none";
				}
				else
				{
					display_transplant="display:inline";
				}
			}
			else
			{
				display_transplant="display:inline";
			}
		}
		if(record[0].equals("A"))
		{  
%>
				<td  width='25%'><%=record[1]%></td>
				<%
				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
	
				%>
				<td width='25%' colspan="<%=colspan%>" ><TEXTAREA NAME='' ROWS='3' COLS='30' readOnly><%=((record[2] == null) ? "" : record[2])%></TEXTAREA></td>
<%
							

			}else if(record[0].equals("C"))
			{
 				if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
					checked = "";
				else checked = "checked";

%>
				<td  style="<%=display_transplant%>"  width='25%' ><%=record[1]%></td>
				<%
				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
				%>
				<td  width='25%' colspan="<%=colspan%>" style="<%=display_transplant%>"><input type=checkbox value="<%=record[2]%>" <%=disabled%> <%=checked%>></td>
<%
			}
			else 
			{
%>
				<td width='25%' style="<%=display_transplant%>"><%=record[1]%></td>
				<%
				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
				
				%>
				<td width='25%' colspan="<%=colspan%>" style="<%=display_transplant%>"><B><%=order_format_field_values%></B></td>
<%
			}
	}
%>
</tr>
</table>						

							
	<%					
			}
	%>
	
	<%} else{
	%>
	<div class="WidgetVwErrContainer">
		<%
		for(int k=0;k<errorList.size();k++){
		%>
		<div class="WidgetErrorResponse WidgetErrorResponseTheme"><%= errorList.get(k).getErrorMessage()%></div>
		<%} %> 
	</div>
	<%} %>	
	
</div>

