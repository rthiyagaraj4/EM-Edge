<!DOCTYPE html>
<%@page import="eIPAD.*"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%-- Mandatory declarations end --%>

<html>
<head>

<script>
function noteclose()
{
	//document.getElementById("notesContentFrame2").src = "../jsp/widgetResultDetail.jsp";
	window.parent.closenotes();
}
</script>

<link rel="stylesheet" href="../css/ipadAllergyContent.css" />

</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");

	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	//String bean_id = "Or_ViewOrder" ;
	//String bean_name = "eOR.ViewOrder";

	String orderId = request.getParameter("orderId");

	String lineId = request.getParameter("lineId");
//out.println("<script>alert("+lineId+");</script>");
//out.println("<script>alert('"+orderId+"');</script>");
	String called_from = request.getParameter("called_from");
	if(called_from==null){
		called_from = "";
	}

	PendingOrderDetails bean = new PendingOrderDetails();
	//ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	PendingOrderFormatRequest formatRequest = new PendingOrderFormatRequest();
	formatRequest.setLanguageId(IPADConstants.LOCALE);
	formatRequest.setCalledFrom(called_from);
	String facilityId = (String) session.getValue( "facility_id" );
	formatRequest.setFacilityId(facilityId);
	formatRequest.setOrderId(orderId);
	formatRequest.setLineId(lineId);

	List<String[]> order_format_dtl = new ArrayList<String[]>();

	if(lineId == null || lineId.equals("null")){
		lineId = "";
	}
	if(lineId.equals("")) 
	{
		order_format_dtl = bean.getOrderFormatDetail( formatRequest ) ;
	}else
	{
		order_format_dtl = bean.getOrderFormatLineDetail(formatRequest) ;
	}
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

<table width="100%" border=0>
<tr>
<td width="90%">&nbsp;
</td>
<td width="10%">
<input type="button" value="close" class="btnType1"  data-role = "none" onclick="noteclose()"/>
</td>
</tr>

</table>


</body>
</html>


