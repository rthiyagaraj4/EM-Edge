<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page	import="java.util.*, eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" --%>
<%-- To call the Common MultipleHandler where the id will be as mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
  <head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrderStatusCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	 function lockKey()
	  {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }
	</script>
  </head>

  <body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" onload="FocusFirstElement()">
  <%
	
	/* Mandatory checks start */
	String mode				= request.getParameter( "mode" ) ;
	//String function_id		= request.getParameter( "function_id" ) ;
	String bean_id			= "Or_order_status_code" ;
	String bean_name		= "eOR.OrderStatusCode";
	String readOnly			= "" ;
	//String checked			= "";
	//String order_status_desc= "";	
	String order_status_type= "";
	if ( mode == null || mode.equals("") )
		return ;

	/* Mandatory checks end */
	/* Initialize Function specific start */
	OrderStatusCode bean = (OrderStatusCode)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	if ( mode.equals(  CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
		{
		   String order_status_code =   request.getParameter( "order_status_code" ) ;
		   order_status_type =   request.getParameter( "order_status_type" ) ;
		   bean.setOrderStatusCode(order_status_code.trim() ) ;
		   bean.setOrderStatusType(order_status_type.trim() ) ;
		   bean.loadData() ;
		   readOnly					= "readOnly";
	    }
		else
		  readOnly					= "";

  %>

   <form name="order_status_code_form" id="order_status_code_form" method="post" action="../../servlet/ORe.OrControllerServlet?set_common=Y"	target="messageFrame">
	   <table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
			 <td colspan="5"></td>
		</tr>
		<tr>
			<td class="label" ></td>
			<td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class=fields><input class='fields' type="text" name="order_status_code" id="order_status_code" value="<%=bean.getOrderStatusCode()%>" size="2" maxlength="2" onBlur="ChangeUpperCase( this );"  <%=readOnly%>  onKeyPress="return CheckForSpecChars(event);"><img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
			<td class="label" colspan='2'></td>
		</tr>
		<tr>
			 <td colspan="5"></td>
		</tr>
		<tr>
			<td class="label" ></td>
			<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class=fields><input type="text" name="long_desc" id="long_desc" value="<%=bean.getLongDesc()%>"   size="60" maxLength="60" onBlur="makeValidString( this );"><img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
			<td class="label" colspan='2'></td>
		</tr>
		<tr>
			 <td colspan="5"></td>
		</tr>
		<tr>
			<td class="label" ></td>
			<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class=fields>
			   <input type="text" name="short_desc" id="short_desc" value="<%=bean.getShortDesc()%>"  size="30" maxLength="30" onBlur="makeValidString( this );" ><img src="../../eCommon/images/mandatory.gif" align=center></img>
			</td>
			<td class="label" colspan='2'></td>
		</tr>
		<tr>
		 	<td class="label" colspan='5'></td>
		</tr>
		<tr>
			<td class="label" ></td>
			<td class="label"><fmt:message key="eOR.StatusType.label" bundle="${or_labels}"/></td>
			<td>
<%
			String[] record = new String[2] ;
			if ( mode.equals(  CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
			{	
				order_status_type = "40"; // Always user defined
			}
		    String OrderStatusTypeDesc = bean.getStatusTypeDesc(order_status_type);
			//out.println("in jsp, orderstatustypdesc is...."+OrderStatusTypeDesc);
			//if (OrderStatusTypeDesc.equals("40��In Proc : User-def")) 
			//System.out.println("staisfied");
			
			if(OrderStatusTypeDesc!=null && OrderStatusTypeDesc!="")
			{
				//System.out.println("came here");
				StringTokenizer stTokenizer = new StringTokenizer(OrderStatusTypeDesc,"||");
				record[0] = stTokenizer.nextToken();
				//System.out.println("stTokenizer value"+record[0]);
				while(stTokenizer.hasMoreTokens())
				{
					
					record[1] = stTokenizer.nextToken();
					//System.out.println("In record value"+record[1]);
				}
				
			}			
			
			%>
		<input type="text" name="order_status_type_desc" id="order_status_type_desc" value="<%=record[1]%>"  size="30" maxLength="30" readOnly>
 		<input type="hidden" name="order_status_type" id="order_status_type" value="<%=record[0]%>"  size="2" maxLength="2">
			</td>
			<td class="label" colspan='2'></td>
		</tr>
		<tr>
		 	<td class="label" colspan='5'></td>
		</tr>
	  </table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	</form>

 </body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

