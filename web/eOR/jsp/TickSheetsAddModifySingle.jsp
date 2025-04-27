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
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %> <!-- IN072524  -->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	 
	String readOnly = "" ;
	//String disabled = "" ;
	String enableStatus = "";

	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "tSheet1" ;
	String bean_name = "eOR.Tick_Sheets";
	


	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;


/* Mandatory checks end */
	
	/* Initialize Function specific start */
	Tick_Sheets bean =
	(Tick_Sheets)getBeanObject( bean_id,bean_name, request );  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	/* Initialize Function specific end */

		String order_category_desc	=  "" ;
		String order_category		= "";
		String tick_sheet_id		="";
		if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ) {

		tick_sheet_id	=request.getParameter("tick_sheet_id") ;
		order_category	=request.getParameter("order_category") ;
		order_category_desc	=request.getParameter("order_category_desc") ;
				 
				
		bean.setTick_sheet_id(tick_sheet_id.trim());
		bean.setOrder_category(order_category.trim());

	
		bean.loadData() ;

		readOnly = "readonly" ;
		//disabled = "disabled" ;

		if((bean.getEff_status()).equalsIgnoreCase("D")){
		  enableStatus = "disabled"	  ;
		}
	}
		//IN072524 Starts
		Boolean isfppapplicable = false;
		Connection connection =  null;
		try{
		connection = ConnectionManager.getConnection(request); 
		
		isfppapplicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","FPP_APPLICABLE_YN");

		}catch(Exception e1){
			e1.printStackTrace();
		}finally{
			if(connection!=null) connection.close();
		}
		 //IN072524 ENDS
%>
<form name='Tick_Sheets_update' id='Tick_Sheets_update' >
<table cellpadding=3 cellspacing=0 border=0 width='100%'  align='center'>
<tr>
  <td class="label" width="40%"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td> 
	<td class='fields'><input type=text name='tick_sheet_id' id='tick_sheet_id' size=6 maxlength=6 value="<%=bean.getTick_sheet_id().trim()%>" <%=readOnly%>
	<%=enableStatus%>><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>

<tr>
	<td colspan="2"></td>
</tr>

<tr>
	<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td> 
	<td class='fields'><input type=text name='tick_sheet_desc' id='tick_sheet_desc' size=30 maxlength=30 value="<%=bean.getTick_sheet_desc().trim()%>" onBlur="makeValidString(this)" <%=enableStatus%>>
	<img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>

<tr><td colspan="2"></td></tr>

<tr>
	<td class="label"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td> 
	<td class=fields><input type=text name='seq_no' id='seq_no' size=1 maxlength=2 value="<%=bean.getSeq_no().trim()%>" <%=bean.getSeq_no().trim().equals("")?"":"readOnly"%> <%//=readOnly%> <%=enableStatus%>>
	</td>
</tr>



<tr>
	<td class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td> 
	<td class='fields'><INPUT TYPE="text" name="order_category_desc" id="order_category_desc" value="<%=order_category_desc.trim()%>" readonly <%=enableStatus%>>
	<img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>



<tr>
	<td class="label"><fmt:message key="eOR.Index.label" bundle="${or_labels}"/></td> 
	<td class='fields'><input type="checkbox" name="indexed_yn" id="indexed_yn" value="<%=bean.getIndexed_yn().trim()%>" <%=eHISFormatter.ChkBoxChecked("Y" ,bean.getIndexed_yn())%> <%=enableStatus%>  ></td>
</tr>



<tr>
	<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td> 
	<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="<%=bean.getEff_status().trim()%>" <%=eHISFormatter.ChkBoxChecked("E" ,bean.getEff_status())%> ></td>
</tr>
<!-- IN072524 -->
<%if(isfppapplicable) {%>
<tr>
	<td class="label"><fmt:message key="eOR.FPPPATIENT.label" bundle="${common_labels}"/></td> 
	<td class='fields'><input type="checkbox" name="fpp_yn" id="fpp_yn" value="<%=bean.getFpp_yn().trim()%>" <%=eHISFormatter.ChkBoxChecked("Y" ,bean.getFpp_yn())%> disabled></td>
</tr>
<%} %>
<!-- IN072524 -->
</table>

	<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="order_category" id="order_category" value="<%=order_category.trim()%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
    <input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
  </form>
 </body>
</html>


<%
		putObjectInBean(bean_id,bean,request);
 
%>

