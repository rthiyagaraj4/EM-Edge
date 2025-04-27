<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date       Edit History      Name        Rev.Date   Rev.By		Description
-----------------------------------------------------------------------
?             100            ?           	    				created
28/10/2011    IN029395      Chowminya G      					Incident No: IN029395 - <exception on dateutil>  
30/01/2014    IN045798		Chowminya    30/01/2014 Chowminya   The Original alignment of the Order format Items are getting changed in the Order format screen    
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="">


<%



	request.setCharacterEncoding("UTF-8");

	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";

	String orderId = request.getParameter("orderId");
	
	String auditTrailYN = request.getParameter("auditTrail")==null?"":(String)request.getParameter("auditTrail"); //IN049419
	String action_seq_num = request.getParameter("action_seq_num")==null?"":(String)request.getParameter("action_seq_num"); //IN049419

	String lineId = request.getParameter("lineId")==null?"":(String)request.getParameter("lineId");
//out.println("<script>alert("+lineId+");</script>");
//out.println("<script>alert('"+orderId+"');</script>");
	String called_from = request.getParameter("called_from");
	if(called_from==null) called_from = "";
/* Mandatory checks end */

	/* Initialize Function specific start */
	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	ArrayList order_format_dtl = new ArrayList();

	if(lineId == null || lineId.equals("null")) lineId = "";
	if(lineId.equals("")) 
	{
		//IN049419 Start.
		//order_format_dtl = bean.getOrderFormatDetail( orderId ) ;
		if(auditTrailYN.equals("Y"))
			order_format_dtl = bean.getOrderFormatDetailAuditTrail( orderId, action_seq_num) ;
		else
			order_format_dtl = bean.getOrderFormatDetail( orderId ) ;
		//IN049419 End.
	}else
	{
		//IN049419 Start.
		//order_format_dtl = bean.getOrderFormatLineDetail(orderId,lineId,called_from) ;
		if(auditTrailYN.equals("Y"))
			order_format_dtl = bean.getOrderFormatLineDetailAuditTrail( orderId, action_seq_num,lineId,called_from) ;
		else
			order_format_dtl = bean.getOrderFormatLineDetail(orderId,lineId,called_from) ;
		//IN049419 End.
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
	String display_hdr = "";//IN045798
	String disp = "";//IN045798

	for(int i=0; i<order_format_dtl.size(); i++)
	{
		/*if(i%2 == 0 )
		{
			out.println("<tr>");
			j++;
		}*/ //IN045798 Commented
		display_hdr = "N"; //IN045798
		String record[] = (String[])order_format_dtl.get(i);
		record[0]=bean.checkForNull(record[0],"");
		record[1]=bean.checkForNull(record[1],"");
		record[2]=bean.checkForNull(record[2],"");
		record[3]=bean.checkForNull(record[3],"");
		record[4]=bean.checkForNull(record[4],"");
		//IN045798 - Start
		if(lineId.equals("")) 
			disp=bean.checkForNull(record[3],""); 
		else
			disp=bean.checkForNull(record[8],""); 
		
		if(record[0].equals("L"))
		{
			display_hdr = bean.getMultiPresentationSelection(record[4].trim()) ;
		}
		if (j == 2)
			j= 0;

		if(disp.equals("D")|| display_hdr.equals("Y"))
		{
			out.println("</tr><tr>");
			j=2;
		}else if(j == 0){
			out.println("</tr><tr>");
			j++;
		}else
			j++;
		//IN045798 - End
		if(record[0].equals("E"))
		{ 	
			if(!(record[2].trim().equals("")))//--[IN029395]
			{
				record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en",localeName);	
			}			
		}
		else if(record[0].equals("D"))
        {
			if(!(record[2].trim().equals("")))//--[IN029395]
			{
				record[2]=com.ehis.util.DateUtils.convertDate(record[2],"DMY","en",localeName);	
			}			
		}

		if(lineId.equals("")) 
		{
			order_format_field_values = bean.checkForNull(record[2],"")+" "+bean.checkForNull(record[4],"");
		}
		else
		{
			record[5]=bean.checkForNull(record[5],"");
			record[6]=bean.checkForNull(record[6],"");
			record[7]=bean.checkForNull(record[7],"");
			order_format_field_values = bean.checkForNull(record[2],"")+" "+bean.checkForNull(record[7],"");
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
					display_transplant="display:";
				}
			}
			else
			{
				display_transplant="display:";
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
					display_transplant="display:";
				}
			}
			else
			{
				display_transplant="display:";
			}
		}
		if(record[0].equals("A"))
		{  
%>
				<td class=label  width='25%' style="<%=display_transplant%>"><font size=1><%=record[1]%></td>
				<%
				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
	
				%>
				<td width='25%' colspan="<%=colspan%>" class='fields' style="<%=display_transplant%>"><font size=1><TEXTAREA NAME='' ROWS='3' COLS='30' readOnly><%=((record[2] == null) ? "" : record[2])%></TEXTAREA></td>
<%
							

			}else if(record[0].equals("C"))
			{
 				if((record[2].trim()).equalsIgnoreCase("N") || (record[2].trim()).equals(""))
					checked = "";
				else checked = "checked";
					//System.out.println("hello2");

%>
				<td class=label   width='25%' style="<%=display_transplant%>"><font size=1><%=record[1]%></td>
				<%
				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
				%>
				<td  width='25%' colspan="<%=colspan%>" class='fields' style="<%=display_transplant%>"><font size=1><input type=checkbox value="<%=record[2]%>" <%=disabled%> <%=checked%>></td>
<%
			}
			else 
			{
				
%>
				<td class=label  width='25%' style="<%=display_transplant%>"><font size=1><%=record[1]%></td>
				<%
				if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
					colspan="3";
				/*if(record[1].contains("Pres"))
					{
						if(record[2].equals("1"))record[2] = "";
					}*/
				%>
				<td width='25%' class="data" colspan="<%=colspan%>" style="<%=display_transplant%>"><font size=1><B><%=order_format_field_values%></B></td>
<%
			//IN045798 - Start
			if(disp.equals("D")|| display_hdr.equals("Y"))
			{
				out.println("</tr>");
			}
			//IN045798 - End
		}
	}
%>
</table>
</FORM>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
%>

