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
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper"%> <!--IN072524  -->
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
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="javascript" src="../../eOR/js/TickSheets.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<%
	
	String readOnly = "" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "tSheet1" ;
	String bean_name = "eOR.Tick_Sheets";
	//String disabled = "" ;
	int		totalRecords	=	0;



	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	Tick_Sheets bean = null ;
	Connection con=null ;//IN072524
	
	Boolean isFPPApplicableyn =false;//IN072524
	try{
		con = ConnectionManager.getConnection(request);//IN072524
		isFPPApplicableyn = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","FPP_APPLICABLE_YN");//IN072524
	 bean = 	(Tick_Sheets)getBeanObject( bean_id,bean_name, request ); 
	// System.out.println("bean="+bean);
	}catch(Exception e){
	System.out.println("Caught=" + e.getMessage());	
	}
	finally{//IN072524 starts
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con, request);
		 }catch(Exception e){System.out.println("exception"+e);
		 
		 }
	}//IN072524 Ends
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;

	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	/* Initialize Function specific end */


%>

<form name='Tick_Sheets_insert' id='Tick_Sheets_insert' target='messageFrame' >
<table class='grid' width='100%'>
<tr>
		<th class='columnheader' width='15%' style="text-align: left;"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th> 
		<th class='columnheader' width='25%' style="text-align: left;"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th> <!--IN072524-->
		<th class='columnheader' width='15%' style="text-align: left;"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th> 
		<th class='columnheader' width='15%'  style="text-align: left;"><fmt:message key="eOR.Index.label" bundle="${or_labels}"/></th> 
		<!-- IN072524 -->
		<%if(isFPPApplicableyn){ %>
		<th class='columnheader' width='15%'  style="text-align: left;"><fmt:message key="eOR.FPPPATIENT.label" bundle="${or_labels}"/></th>
		<%} %> 
		<!-- IN072524 -->
		<th class='columnheader' width='15%'  style="text-align: left;"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th> 
</tr>

<%
int i = 0;
while(i < 10){
	
	String  classValue = "";

	if ( i % 2 == 0 )
		  	classValue = "gridData" ;
		  else
		  	classValue = "gridData" ;
	%>
<tr >
	<td class='<%=classValue%>' ><input class='fields' type=text name='tick_sheet_id<%=i%>' id='tick_sheet_id<%=i%>' onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this);parent.parent.resetColorCode(this);" size=6 maxlength=6 value='' <%=readOnly%>>
	<%if(i==0){%><img src="../../eCommon/images/mandatory.gif" align=center ></img><%}%></td>

	<td class='<%=classValue%>'><input class='fields' type=text name='tick_sheet_desc<%=i%>' id='tick_sheet_desc<%=i%>' onBlur="makeValidString(this);parent.parent.resetColorCode(this);" size=30 maxlength=30 value=""  <%=readOnly%>>	<%if(i==0){%><img src="../../eCommon/images/mandatory.gif" align=center></img><%}%></td>

	<td class='<%=classValue%>'><input class='fields' type=text name='seq_no<%=i%>' id='seq_no<%=i%>'  onkeypress="return allowPositiveNumber()"  onBlur="checkPositiveNumber(this);parent.parent.resetColorCode(this);" size=1 maxlength=2 value=""  <%=readOnly%>></td>

	<td class='<%=classValue%>'><input class='fields' type="checkbox" name='indexed_yn<%=i%>' id='indexed_yn<%=i%>' value="Y"  <%=readOnly%> ></td>
	<!-- IN072524  -->
	<%if(isFPPApplicableyn){ %>
	<td class='<%=classValue%>'><input class='fields' type="checkbox" name='fpp_yn<%=i%>' id='fpp_yn<%=i%>' id ='fpp_yn<%=i%>' value="N"  onclick="setFPPYN(this,<%=i%>)" <%=readOnly%> ></td>
	<%} %> 
	<!-- IN072524 -->
	<td class='<%=classValue%>'><input class='fields' type="checkbox" name='eff_status<%=i%>' id='eff_status<%=i%>' value="E" checked  <%=readOnly%> ></td>
</tr >
<%i++;}%>

</table>

	<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
	<INPUT TYPE="hidden" name="order_category" id="order_category" value="">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
  
  </form>
 </body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

