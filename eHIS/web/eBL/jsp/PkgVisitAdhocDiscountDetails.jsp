<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*,eBL.PkgAdhocDiscountBean" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
 
<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgVisitAdhocDiscount.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		String bean_id			= "bl_PkgAdhocDiscountBean" ;
		String bean_name		= "eBL.PkgAdhocDiscountBean";
		PkgAdhocDiscountBean bean	= (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;

		String locale				= (String)session.getAttribute("LOCALE");
		String facilityId			= (String) session.getValue( "facility_id" ) ;
		String patientId			= request.getParameter("patientId");
		patientId					= patientId==null ?"":patientId;
		String packageCode			= request.getParameter("packageCode");
		packageCode					= packageCode==null ?"":packageCode;
		String packageSeqNo			= request.getParameter("packageSeqNo");
		packageSeqNo				= packageSeqNo==null ?"":packageSeqNo;
		String called_from			= request.getParameter("called_from");
		called_from					= called_from==null ?"":called_from;	
		String episode_id			= request.getParameter("episode_id");
		episode_id					= episode_id==null ?"":episode_id;
		String visit_id				= request.getParameter("visit_id");
		visit_id					= visit_id==null ?"":visit_id;
		String blnggrp				= request.getParameter("blnggrp");
		blnggrp						= blnggrp==null ?"":blnggrp;
		String billdoctype      = request.getParameter("billdoctype");
		billdoctype				= billdoctype==null ?"":billdoctype;
		String billdocnum      = request.getParameter("billdocnum");
		billdocnum				= billdocnum==null ?"":billdocnum;		

		int totalRec = 0;
		String type					= "";
		String noofdecimal			= bean.getNoOfDecimal();
		ArrayList enconterDtls		= new ArrayList();
		ArrayList dtls				= new ArrayList();
		HashMap adhocDiscountDtls	= bean.getAdhocDiscountDtls();
		if(!(adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo)))	
		{
			
			bean.setDBValues(facilityId, patientId, packageSeqNo, packageCode, locale);
			adhocDiscountDtls	= bean.getAdhocDiscountDtls();			
		}
		if(adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo))
		{

			enconterDtls = (ArrayList)adhocDiscountDtls.get(packageSeqNo);
			totalRec = 	enconterDtls.size();
		}
		
		%>

	<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
	<table class="grid"  width='100%' id="pkgDtlsForPatient">
	
	<%
	try
	{
		
		for(int i=0;i<totalRec;i++)
		{
			dtls = (ArrayList)enconterDtls.get(i);
			type =  checkForNull((String)dtls.get(5),"A");
			if(i==0){
			%>
				<tr>				
				<td class='columnheader'><fmt:message key="eBL.CUST_GROUP_CODE.label" bundle="${bl_labels}"/></td>	  
				<td class='columnheader'><fmt:message key="eBL.CUST_GROUP_DESC.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.CUST_NAME.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.DISCOUNT_AS_PER_SETUP.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.ADHOC_DISC_AMT.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.ADHOC_DISC_REASON.label" bundle="${bl_labels}"/></td>
				</tr>
		<%}%>
			<tr>
			<td  nowrap><%=checkForNull((String)dtls.get(0))%></td>
			<td nowrap><%=checkForNull((String)dtls.get(1))%></td>
			<td  nowrap><%=checkForNull((String)dtls.get(2))%></td>
			<td  nowrap><%=checkForNull((String)dtls.get(3))%></td>
			<td nowrap><%=checkForNull((String)dtls.get(4))%></td>
			<td  nowrap> 
			<select name='type_<%=i%>' id='type_<%=i%>' onChange='validateInd(this,"<%=i%>")'>
			<option value='A' <%=(type.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
			<option value='R'  <%=(type.equals("R")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
			</select>
			</td>
			<td nowrap><input type='text' name='adhocDiscount_<%=i%>' id='adhocDiscount_<%=i%>'	value='<%=checkForNull((String)dtls.get(6))%>' size='6' onBlur="chkAmtPer(this,'<%=i%>','<%=noofdecimal%>');"  onKeyPress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")' />
			</td>

			<td nowrap><input type='text' name='reason_desc<%=i%>' id='reason_desc<%=i%>'	value='<%=checkForNull((String)dtls.get(10))%>' size='13'  maxlength='13' onBlur="searchReason('B','<%=i%>')" ><input type='button' class='button' name="reasonbut<%=i%>" id="reasonbut<%=i%>" value='?' onClick="searchReason('C','<%=i%>')"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			</tr>
			<input type="hidden" name='reason_code<%=i%>' id='reason_code<%=i%>'     value='<%=checkForNull((String)dtls.get(9))%>' />
			<input type='hidden' name='cust_group_code<%=i%>' id='cust_group_code<%=i%>' value='<%=checkForNull((String)dtls.get(0))%>' />			
			<input type='hidden' name='cust_group_desc<%=i%>' id='cust_group_desc<%=i%>' value='<%=checkForNull((String)dtls.get(1))%>' />				
			<input type='hidden' name='cust_code<%=i%>' id='cust_code<%=i%>' value='<%=checkForNull((String)dtls.get(2))%>' />				
			<input type='hidden' name='cust_desc<%=i%>' id='cust_desc<%=i%>' value='<%=checkForNull((String)dtls.get(3))%>' />				
			<input type='hidden' name='discountAsPerSetup_<%=i%>' id='discountAsPerSetup_<%=i%>' value='<%=checkForNull((String)dtls.get(4))%>' />
			<input type='hidden' name='to_update<%=i%>' id='to_update<%=i%>' value='<%=checkForNull((String)dtls.get(7))%>' />
<%	}
	%>
 </table>
	<%if(totalRec==0)
	{%>
	 <script>
		parent.PkgVisitAdhocDiscountPatientHdr.location.href="../../eCommon/html/blank.html";
		alert(getMessage("BL8669",'BL')); </script>
	 <%}
}
catch(Exception e)
{
	System.out.println("Exception from Package AdhocDiscount Details  :"+e);
	e.printStackTrace();
}
%>
<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>' />
<input type='hidden' name='packageCode' id='packageCode' value='<%=packageCode%>' />
<input type='hidden' name='packageSeqNo' id='packageSeqNo' value='<%=packageSeqNo%>' />
<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>' />
<input type='hidden' name='totalRec' id='totalRec' value='<%=totalRec%>' />
 <input type='hidden' name='called_from' id='called_from' value='<%=called_from%>' />
 <input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>' />
 <input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id%>' />
 <input type='hidden' name='blnggrp' id='blnggrp' value='<%=blnggrp%>' />
 <input type='hidden' name='billdoctype' id='billdoctype' value='<%=billdoctype%>' />
 <input type='hidden' name='billdocnum' id='billdocnum' value='<%=billdocnum%>' />

 <input type='hidden' name='auth_discount' id='auth_discount' value='' />
 <input type='hidden' name='locale' id='locale' value='<%=locale%>' />
</form>
</body>
</html>

<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>


