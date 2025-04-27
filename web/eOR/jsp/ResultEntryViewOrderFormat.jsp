<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<FORM name="form1" id="form1">
<%
		
		/* Mandatory checks start */
		String mode	   = "1";//request.getParameter( "mode" ) ;
		//String function_id = request.getParameter( "function_id" ) ;
		String bean_id = "Or_ViewOrder" ;
		String bean_name = "eOR.ViewOrder";
		String orderId = request.getParameter("orderId");
		String called_from = request.getParameter("called_from");
		/* Mandatory checks end */

		/* Initialize Function specific start */
		//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
		 ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

		bean.clear() ;
		bean.setMode( mode ) ;

		ArrayList order_format_dtl = new ArrayList();
		if(called_from.equals("RESULT_ENTRY")) // Line level result entry 
			order_format_dtl = bean.getOrderFormatLineDetail(orderId,"",called_from) ; // No Line Num
%>
	<BR>
	<table cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
<%
		String disabled = "disabled";
		String checked = "";
		String order_line_num = "";
		String old_order_line_num = "";
		String comment			  = "";
		String preps_instrn		  = "";
		String dept_instrn		  = "";
		String patient_instrn	  = "";
		String catalog_desc		  = "";
		String old_catalog_desc	  = "";
		String record_instrns[]	  = null;
		ArrayList Instructions	  = null;
		int count				  = 0;
		int j					  = 0;
		out.println("<tr>");
		for(int i=0; i<order_format_dtl.size(); i++){
				String record[] = (String[])order_format_dtl.get(i);
				order_line_num  = record[5];
				catalog_desc	= record[6];
				if(catalog_desc==null) catalog_desc = "";
				if(!catalog_desc.equals(old_catalog_desc))
					out.println("<tr><td class='PATIENTLINECOLOROTHLANG'  width='25%' colspan='4'>"+catalog_desc+"</td></tr>");
				if(j%2==0 )
					out.println("</tr><tr>");
				if(!order_line_num.equals(old_order_line_num))
				{
					j					= 0;  // Reinitialized
					comment				= record[3];
					count				= bean.getIndTotalCount(orderId, order_line_num);   // Get the total count for the formats
					Instructions		= (ArrayList)bean.getInstructions(orderId, order_line_num); // return an string array
					if(Instructions!=null && order_format_dtl.size() > 0) { 
						for(int k=0; k<Instructions.size(); k++){
						record_instrns	= (String[])Instructions.get(k);
						//Will be of record_instrns[4] --> max	
						if(record_instrns[3]!=null && record_instrns[3].equals("DEPT_INSTRNS"))
							dept_instrn			= record_instrns[2];
						else if(record_instrns[3]!=null && record_instrns[3].equals("PAT_PREPS_TEXT"))
							preps_instrn		= record_instrns[2];
						else if(record_instrns[3]!=null && record_instrns[3].equals("PATIENT_INSTRNS"))
							patient_instrn		= record_instrns[2];
						}
					}
				}
			if(record[0].equals("A")) {
%>
				<td class=label width='25%'><font size=1><%=record[1]%></td>
				<%
				//if(((i+1) == order_format_dtl.size()) && (order_format_dtl.size() % 2 ==1))
				%>
				<td width='25%' ><font size=1><TEXTAREA NAME='' ROWS='3' COLS='30' readOnly><%=((record[2] == null) ? "" : record[2])%></TEXTAREA></td>
<%
			}else if(record[0].equals("C")){
				if(record[2]!=null && (record[2].trim()).equalsIgnoreCase("Y"))
					checked = " checked ";
				else checked = "";
%>
				<td class=label width='25%'><font size=1><%=record[1]%></td>
				<td  width='25%' ><font size=1><input type=checkbox value="<%=record[2]%>" <%=disabled%> <%=checked%>></td>
<%
			} else {
%>
				<td class=label width='25%'><font size=1><%=record[1]%></td>
				<%
				if(record[2] == null) record[2] = "";
				%>
				<td width='25%' class=label ><font size=1><B><%=record[2]%></B></td>
<%
			} 
			if((j+1)==count)
			{
				if(j%2!=1)
				{
%>				
					<td width='25%' class=label colspan="2"></tD> 
<%				}	%>
				</tr><tr><td class=label width='25%'><font size=1><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></font></td>
					     <td class=label width='25%'><font size=1><TEXTAREA NAME='' ROWS='3' COLS='30' readOnly><%=((comment == null) ? "" : comment)%></TEXTAREA></font></td>
					 	 <td class=label width='25%'><font size=1><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></font></td>
					     <td class=label width='25%'><font size=1><TEXTAREA NAME='' ROWS='3' COLS='30' readOnly><%=((preps_instrn == null) ? "" : preps_instrn)%></TEXTAREA></font></td>
					  </tr>
					  <tr><td class=label width='25%'><font size=1><fmt:message key="eOR.DeptInstrn.label" bundle="${or_labels}"/></font></td>
					     <td class=label width='25%'><font size=1><TEXTAREA NAME='' ROWS='3' COLS='30' readOnly><%=((dept_instrn == null) ? "" : dept_instrn)%></TEXTAREA></font></td>
					 	 <td class=label width='25%'><font size=1><fmt:message key="eOR.PatInstrn.label" bundle="${or_labels}"/></font></td>
					     <td class=label width='25%'><font size=1><TEXTAREA NAME='' ROWS='3' COLS='30' readOnly><%=((patient_instrn == null) ? "" : patient_instrn)%></TEXTAREA></font></td>
					  </tr>
					  <tr><td class=label colspan="4"></td></tr>
<%			}
			old_order_line_num = order_line_num;
			old_catalog_desc   = catalog_desc;
			j++;
	}
	out.println("</tr>");
%>
	</table>
	</FORM>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
%>

