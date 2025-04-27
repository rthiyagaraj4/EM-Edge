
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %> 
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
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>

	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../js/ClosingProcessedOrders.js"></script>
<script language='javascript'>

function CheckPositiveNumber1(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) 
	{
    }
    else 
	{
        if ( obj.value.length > 0 ) 
		{
            alert(getMessage("ONLY_POSITIVE_NUM","OR"));
            obj.select();
            obj.focus();
        }
        else if ( obj.value.length == 0 ) 
		{
            obj.value = 0;
		}
    }
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</head>
<body onload='FocusFirstElement()' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

  <%

	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
	String mode				= request.getParameter( "mode" ) ;
	String order_category = request.getParameter("order_category");
	String order_type = request.getParameter("order_type");
	String bean_id			= "Or_Cl_Process_Order" ;
	String bean_name		= "eOR.ClosingProcessOrderBean";
	String slClassValue = "";

	String[] records=null;
	int j=0;
	if ( mode == null || mode.equals("") )
		return ;

	ClosingProcessOrderBean bean = (ClosingProcessOrderBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setMode(mode);
	

	ArrayList OrderTypeData                = bean.getPatientClassValues(order_type) ;
	ArrayList OrderTypeDataForAll     = bean.getAllPatientClassValues(order_type) ;
	
	if(OrderTypeDataForAll.size()>0 ) 
	{
			records = (String[])OrderTypeDataForAll.get(0);
	}
   %>

   <form name="frm_closed_processed_order_bottom" id="frm_closed_processed_order_bottom" method="post" target="messageFrame">
	<table class='grid' width='100%'>
	<tr>
		<td class=columnheader width='15%' valign='top'>
			<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
		</td>
		<td class=columnheader width='30%' nowrap>
			<fmt:message key="eOR.CloseUnprocessedOrdersafter.label" bundle="${or_labels}"/>(<fmt:message key="Common.days.label" bundle="${common_labels}"/>)
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eOR.CloseBilledOrder.label" bundle="${or_labels}"/>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eOR.FutureOrder.label" bundle="${or_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eOR.ReverseCharge.label" bundle="${or_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class=columnheader width='15%' wrap>
			<fmt:message key="eOR.IgnoreOrdersPlacedWithin.label" bundle="${or_labels}"/>(<fmt:message key="Common.hours.label" bundle="${common_labels}"/>)			
		</td>
		<td class=columnheader width='40%' colspan='3' valign='top'>
			<fmt:message key="eOR.CloseInProcessOrdersafter.label" bundle="${or_labels}"/>(<fmt:message key="Common.days.label" bundle="${common_labels}"/>)
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eOR.CloseBilledOrder.label" bundle="${or_labels}"/>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eOR.ReverseCharge.label" bundle="${or_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>

	</tr>
		<input type="hidden" name='totalLength' id='totalLength' value='<%=OrderTypeData.size()+1%>'>
	<tr>
		<td  class='gridData'><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
		<INPUT TYPE="hidden" name="patient_class<%=j%>" id="patient_class<%=j%>" value="*A">
		<td   class='gridData'>
			<input type="text"  name="unprocess<%=j%>" id="unprocess<%=j%>"   size="3" maxLength="3" onkeypress=" return CheckForNumber(event);"onBlur='return checkDecimal1(this)' class='NUMBER' value=<%=(OrderTypeDataForAll.size()>0)?((records[1]!=null)?(!(records[1].equals("0"))?records[1]:""):""):""%> >
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="close_unpr_fut_ord<%=j%>" id="close_unpr_fut_ord<%=j%>"  size="3" class='NUMBER' maxLength="3"  onkeypress=" return CheckForNumber(event);" onBlur='return checkDecimal1(this)' value=<%=(OrderTypeDataForAll.size()>0)?((records[3]!=null)?(!(records[3].equals("0"))?records[3]:""):""):""%>>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="close_unpr_billed_ord<%=j%>" id="close_unpr_billed_ord<%=j%>" onclick="changeChkValue(this)" value=<%=(OrderTypeDataForAll.size()>0)?((records[5]!=null)?(!(records[5].equals(""))?records[5]:"N"):"N"):"N"%> <%if(OrderTypeDataForAll.size()>0 && records[5]!=null && !(records[5].equals("")) &&  (records[5].equals("Y"))) {%>checked<%}%>>&nbsp;&nbsp;
			<input type="checkbox" name="close_unpr_reverse_chrg<%=j%>" id="close_unpr_reverse_chrg<%=j%>" onclick="changeChkValue(this)" value=<%=(OrderTypeDataForAll.size()>0)?((records[6]!=null)?(!(records[6].equals(""))?records[6]:"N"):"N"):"N"%> <%if(OrderTypeDataForAll.size()>0 && records[6]!=null && !(records[6].equals("")) &&  (records[6].equals("Y"))) {%>checked<%}%>>&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td class='gridData'>
			<input type="text" name="ingore_order_in_hrs<%=j%>" id="ingore_order_in_hrs<%=j%>" size="3" class='NUMBER' maxLength="3"  onkeypress=" return CheckForNumber(event);" value=<%=(OrderTypeDataForAll.size()>0)?((records[4]!=null)?(!(records[4].equals("0"))?records[4]:""):""):""%>>
		</td>
	<td class='gridData'>
		<input type="text" name="inprocess<%=j%>" id="inprocess<%=j%>"  size="3"	maxLength="3" onkeypress="return  CheckForNumber(event);"  class='NUMBER' onBlur='return checkDecimal1(this)' value="<%=(OrderTypeDataForAll.size()>0)?((records[2]!=null)?(!(records[2].equals("0"))?records[2]:""):""):""%>" >
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="close_inpr_billed_ord<%=j%>" id="close_inpr_billed_ord<%=j%>" onclick="changeChkValue(this)" value=<%=(OrderTypeDataForAll.size()>0)?((records[7]!=null)?(!(records[7].equals(""))?records[7]:"N"):"N"):"N"%> <%if(OrderTypeDataForAll.size()>0 && records[7]!=null && !(records[7].equals("")) &&  (records[7].equals("Y"))) {%>checked<%}%>>&nbsp;&nbsp;
		<input type="checkbox" name="close_inpr_reverse_chrg<%=j%>" id="close_inpr_reverse_chrg<%=j%>" onclick="changeChkValue(this)" value=<%=(OrderTypeDataForAll.size()>0)?((records[8]!=null)?(!(records[8].equals(""))?records[8]:"N"):"N"):"N"%> <%if(OrderTypeDataForAll.size()>0 && records[8]!=null && !(records[8].equals("")) &&  (records[8].equals("Y"))) {%>checked<%}%>>
	</td>
	</tr>
<%
        String[] record=null;
		slClassValue = "gridData";
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			record = (String[])OrderTypeData.get(i);
			/*	if(i % 2 == 0){
					slClassValue = "gridData";
				}else {
					slClassValue = "gridData";
				}*/
				++j;
	%>
	<tr>
	   <!-- Patient Class -->
	   <td  class='<%=slClassValue%>'><%=record[0]%></td>
	  <INPUT TYPE="hidden" name="patient_class<%=j%>" id="patient_class<%=j%>" value="<%=record[1]%>">
	   <td   class='<%=slClassValue%>'>
			<input type="text"  name="unprocess<%=j%>" id="unprocess<%=j%>"   size="3" maxLength="3" onkeypress=" return CheckForNumber(event);"onBlur='return checkDecimal1(this)' class='NUMBER' value="<%=(record[2]!=null)?(!(record[2].equals("0"))?record[2]:""):""%>">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="close_unpr_fut_ord<%=j%>" id="close_unpr_fut_ord<%=j%>" size="3" class='NUMBER' maxLength="3"  onkeypress=" return CheckForNumber(event);" value="<%=(record[4]!=null)?(!(record[4].equals("0"))?record[4]:""):""%>">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="close_unpr_billed_ord<%=j%>" id="close_unpr_billed_ord<%=j%>" onclick="changeChkValue(this)" value="<%=(record[6]!=null)?(!(record[6].equals(""))?record[6]:"N"):"N"%>" <%if(record[6]!=null && !(record[6].equals("")) &&  (record[6].equals("Y"))) {%>checked<%}%>>&nbsp;&nbsp;
			<input type="checkbox" name="close_unpr_reverse_chrg<%=j%>" id="close_unpr_reverse_chrg<%=j%>" onclick="changeChkValue(this)" value="<%=(record[7]!=null)?(!(record[7].equals(""))?record[7]:"N"):"N"%>" <%if(record[7]!=null && !(record[7].equals("")) &&  (record[7].equals("Y"))) {%>checked<%}%>>&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td class='gridData'>
				<input type="text" name="ingore_order_in_hrs<%=j%>" id="ingore_order_in_hrs<%=j%>" size="3" class='NUMBER' maxLength="3"  onkeypress=" return CheckForNumber(event);" value="<%=(record[5]!=null)?(!(record[5].equals("0"))?record[5]:""):""%>">
			</td>
	   <td class='<%=slClassValue%>'>
			<input type="text" name="inprocess<%=j%>" id="inprocess<%=j%>"  size="3"	maxLength="3" onkeypress="return  CheckForNumber(event);"  class='NUMBER' onBlur='return checkDecimal1(this)' value="<%=(record[3]!=null)?(!(record[3].equals("0"))?record[3]:""):""%>">			
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="close_inpr_billed_ord<%=j%>" id="close_inpr_billed_ord<%=j%>" onclick="changeChkValue(this)" value="<%=(record[8]!=null)?(!(record[8].equals(""))?record[8]:"N"):"N"%>" <%if(record[8]!=null && !(record[8].equals("")) &&  (record[8].equals("Y"))) {%>checked<%}%>>&nbsp;&nbsp;
			<input type="checkbox" name="close_inpr_reverse_chrg<%=j%>" id="close_inpr_reverse_chrg<%=j%>" onclick="changeChkValue(this)" value="<%=(record[9]!=null)?(!(record[9].equals(""))?record[9]:"N"):"N"%>" <%if(record[9]!=null && !(record[9].equals("")) &&  (record[9].equals("Y"))) {%>checked<%}%>>
		</td>
   </tr>
<%		
}  
		OrderTypeData=null;
		
%>
<%
if(order_category.equals("LB")||(order_category.equals("RD"))||(order_category.equals("OT")))
{
%>
	<tr><td class="gridData" colspan="4"><font color="blue"><B><fmt:message key="eOR.IfmoduleisinstalledthenCloseInProcessOrdersafterruleisnotused.label" bundle="${or_labels}"/></font></B></td></tr>
<%
}
%>
	</table>
	<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
	<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">  
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	</form>
   
 </body>
</html>
<%
putObjectInBean( bean_id,bean,request ) ;
%>

