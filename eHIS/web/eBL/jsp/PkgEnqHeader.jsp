<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,eBL.PkgEnqBean " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%	
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../js/PkgEnq.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<% 
	try
	{		
		String bean_id			= "bl_PkgEnqBean" ;
		String bean_name		= "eBL.PkgEnqBean";
		PkgEnqBean bean			= (PkgEnqBean)getBeanObject( bean_id, bean_name, request ) ;

		String facilityId		= (String) session.getValue( "facility_id" ) ;
		String locale			= (String)session.getAttribute("LOCALE");

		String sysDate			=	checkForNull(bean.getSysDate());
		String packageCode		= request.getParameter("packageCode");
		String packageSeqNo		= request.getParameter("packageSeqNo");
		packageSeqNo			= packageSeqNo == null ? "": packageSeqNo;
		String billingClass		= request.getParameter("billingClass");
		billingClass			= billingClass == null ? "": billingClass;
		String customerGrp		= request.getParameter("customerGrp");
		customerGrp				= customerGrp == null ? "": customerGrp;
		String customerCode		= request.getParameter("customerCode");
		customerCode			= customerCode == null ? "": customerCode;

		bean.setDBValues(packageCode,packageSeqNo,billingClass,customerGrp,customerCode,locale,facilityId,sysDate);	
		String longDesc 		=	checkForNull(bean.getLongDesc());
		String shortDesc 		=	checkForNull(bean.getShortDesc());
		String effFromDate		=	checkForNull(bean.getEffFromDate());
		String effToDate		=	checkForNull(bean.getEffToDate());
		String applSexInd 		=	checkForNull(bean.getApplSexInd());
		String minAgeInYrs		=	checkForNull(bean.getMinAgeInYrs());
		String minAgeInMths		=	checkForNull(bean.getMinAgeInMths());
		String minAgeInDays		=	checkForNull(bean.getMinAgeInDays());
		String maxAgeInYrs		=	checkForNull(bean.getMaxAgeInYrs());
		String maxAgeInMths		=	checkForNull(bean.getMaxAgeInMths());
		String maxAgeInDays		=	checkForNull(bean.getMaxAgeInDays());
		String OpYn				=	checkForNull(bean.getOpYn(),"N");
		String EmYn				=	checkForNull(bean.getEmYn(),"N");
		String IpYn				=	checkForNull(bean.getIpYn(),"N");
		String DcYn				=	checkForNull(bean.getDcYn(),"N");
		String AllYn			=   checkForNull(bean.getAllYn(),"N");
		String orderAssociated  =   checkForNull(bean.getOrderAssociated(),"N");
		String acrossEncounters =   checkForNull(bean.getAcrossEncounters(),"N");
		String applicalbleTo	=   checkForNull(bean.getApplicalbleTo());
		String auto				=   checkForNull(bean.getAuto(),"N");
		String validDays		=	checkForNull(bean.getValidDays());
		String approvedYN	    =   checkForNull(bean.getApprovedYN(),"N");
		String approvedBy	    =   checkForNull(bean.getApprovedBy());
		String approvedDate	    =   checkForNull(bean.getApprovedDate());
		String depositCtdAmt	=   checkForNull(bean.getDepositCtdAmt());
		billingClass		=   checkForNull(bean.getBillingClass());
		customerGrp		=   checkForNull(bean.getCustomerGrp());
		customerCode		=   checkForNull(bean.getCustomerCode());
		String pkgPrice		    =   checkForNull(bean.getPkgPrice());
	//	String status		    =   checkForNull(bean.getStatus());//unused variable
		String allChkYn="",ipChkYn="",dcChkYn="",opChkYn="",emChkYn="";
		String maleSelect="",femaleSelect="",otherSelect="",allSelect="" ,EnqSelect="";
		allSelect= applSexInd.equals("A") ? "SELECTED" : "";						otherSelect=applSexInd.equals("O") ?"SELECTED" : "";
		maleSelect= applSexInd.equals("M")?"SELECTED" :"";
		femaleSelect=applSexInd.equals("F") ?"SELECTED" :"";
		EnqSelect=applSexInd.equals("") ? "SELECTED":"";
		opChkYn=OpYn.equals("Y")?"CHECKED":"";
		emChkYn=EmYn.equals("Y")?"CHECKED":"";
		ipChkYn=IpYn.equals("Y")?"CHECKED":"";
		dcChkYn=DcYn.equals("Y")?"CHECKED":"";
		auto = orderAssociated;
		allChkYn=AllYn.equals("Y")?"CHECKED":"";
   %>
		
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" />
	
	<form name='frmPkgEnqHeader' id='frmPkgEnqHeader' >
	<table border='0' cellpadding='1' cellspacing='1' align='center' width='100%'>
	<tr>
		<td  class="label" width="25%">
		<fmt:message key="Common.code.label" bundle="${common_labels}"/> 
		</td>	
		<td  class='fields' width="25%">
		<input type='text' name='packageCode' id='packageCode' size='8' maxlength="8"  disabled value="<%=packageCode%>">
		</td>
	
		<td class="label" width="25%"> 
		<fmt:message key="Common.LongDesc.label" bundle="${common_labels}"/> 
		</td>	
		<td class="fields" width="25%" >
		<input type='text' name='longDesc' id='longDesc' size='50' maxlength="100" disabled   value="<%=longDesc%>" >
		</td>
	</tr>

	<tr>
		<td class='label' width="25%">
		<fmt:message key="Common.ShortDesc.label" bundle="${common_labels}"/> 
		</td>	
		<td class='fields' width="25%">
		<input type='text' name='shortDesc' id='shortDesc' size='40' maxlength="40" disabled  value="<%=shortDesc%>">
		</td>
		<td class='label' width="25%"> 
		<fmt:message key="Common.gender.label" bundle="${common_labels}"/> 
		</td>	
		<td class='fields' width="25%">
		<select name='applSexInd' id='applSexInd' disabled >
		<option value='M' <%=maleSelect%>><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
		<option value='F' <%=femaleSelect%>><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value='O'<%=otherSelect%>><fmt:message key="Common.other.label" bundle="${common_labels}"/></option>
		<option value='A' <%=allSelect%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		</select>
		</td>
	</tr>
	
	<tr>
		<td class='label'  width="25%">
		<fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/> 
		</td>	
		<td class='fields'  width="25%">
		<input type='text' name='effFromDate' id='effFromDate' size='10' maxlength="10"  value="<%=effFromDate%>"  disabled>
		</td>
		<td class='label'  width="25%"> 
		<fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/> 
		</td>	
		<td class='fields' width="25%">
		<input type='text' name='effToDate' id='effToDate' size='10' maxlength="10" disabled  value="<%=effToDate%>" >
		</td>
	</tr>

	<tr>
		<td class='label' width="25%"> 
		<fmt:message key="Common.MinAge.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'> 
		</td>	
		<td class='fields' width="25%">
		<input type='text' name='minAgeInYrs' id='minAgeInYrs' size='3' maxlength="3"  value="<%=minAgeInYrs%>"  disabled >Y
		<input type='text' name='minAgeInMths' id='minAgeInMths' size='2' maxlength="2"  value="<%=minAgeInMths%>"  disabled >M
		<input type='text' name='minAgeInDays' id='minAgeInDays' size='2' maxlength="2"  value="<%=minAgeInDays%>"  disabled >D
		</td>
		<td class='label' width="25%"> 
		<fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/>
		</td>	
		<td class='fields' width="25%">
		<input type='text' name='maxAgeInYrs' id='maxAgeInYrs' size='3' maxlength="3"  value="<%=maxAgeInYrs%>" disabled >Y
		<input type='text' name='maxAgeInMths' id='maxAgeInMths' size='2' maxlength="2"  value="<%=maxAgeInMths%>" disabled >M
		<input type='text' name='maxAgeInDays' id='maxAgeInDays' size='2' maxlength="2"  value="<%=maxAgeInDays%>" disabled  >D
		</td>	
	</tr>

	<tr>
		<td class='label' width="10%" > <fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/> </td>
		<td class='label' width="50%" &nbsp;&nbsp;>
		<fmt:message key="Common.all.label" bundle="${common_labels}"/>
		<input type='checkbox' name='AllYn' id='AllYn' value="<%=AllYn%>" <%=allChkYn%> disabled >
		<fmt:message key="Common.IP.label" bundle="${common_labels}"/> 
		<input type='checkbox' name='IpYn' id='IpYn' value="<%=IpYn%>" <%=ipChkYn%> disabled  >
		<fmt:message key="Common.DC.label" bundle="${common_labels}"/> 
		<input type='checkbox' name='DcYn' id='DcYn' value="<%=DcYn%>"  <%=dcChkYn%> disabled >
		<fmt:message key="Common.OP.label" bundle="${common_labels}"/> 
		<input type='checkbox' name='OpYn' id='OpYn' value="<%=OpYn%>" <%=opChkYn%>  disabled  >
		<fmt:message key="eMP.EM.label" bundle="${mp_labels}"/> 
		<input type='checkbox' name='EmYn' id='EmYn' value="<%=EmYn%>"  <%=emChkYn%>  disabled  >
		</td>	
		<% if(orderAssociated.equals("Y"))
		{%>
		<td class='label' width="20%" id = 'autocheck' >   
		<fmt:message key="eBL.orderAssociated.label" bundle="${bl_labels}"/> 
		</td>	
		<td class='fields' width="20%" id = 'autocheck1'>
		<input type='checkbox' name='orderAssociated' id='orderAssociated' value="<%=orderAssociated%>"   checked  disabled >
		</td>
			<%}  %>
	</tr>

	<tr>
		<td class='label' width="25%" > <fmt:message key="eBL.AcrossEncounters.label" bundle="${bl_labels}"/>	 </td>
		<td class='fields' width="20%">	<input type='checkbox' name='acrossEncounters' id='acrossEncounters' s value="<%=acrossEncounters%>"  <%=acrossEncounters.equals("Y")?"checked":""%> disabled  />	 </td>
		<td class='label' width="25%" > <fmt:message key="eBL.VALID_DAYS.label" bundle="${bl_labels}"/>	 </td>
		<td class='fields' width="20%">	<input type='text' name='validDays' id='validDays' size='3' maxlength="3"   value="<%=validDays%>" disabled  />	 </td>
	</tr>

	<tr>
		<td class='label' width="25%" > <fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/> </td>
		<td class='fields' width="20%">	<select name='applicalbleTo' id='applicalbleTo' disabled >
		<%if(applicalbleTo.equals("A")){%>
		<option value='A' selected><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></option>
		<%}else if(applicalbleTo.equals("R")){%>
		<option value='R' selected ><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option>
		<%}else if(applicalbleTo.equals("B")){%>
		<option value='B' <%=applicalbleTo.equals("B")?"selected":""%> ><fmt:message key="eBL.CashCredit.label" bundle="${bl_labels}"/></option>
		<%}%>
		</select></td>
		<%if(packageSeqNo.equals(""))
		{%>
		<td class='label'  width="25%">
		<fmt:message key="Common.Approved.label" bundle="${common_labels}"/> 
		</td>
		
		<td class='fields'  width="25%">
		<input type='checkbox' name='approvedYN' id='approvedYN' value="<%=approvedYN%>" <%=approvedYN.equals("Y")?" checked ":""%> disabled />
		</td>
		<%}else
		{%>
		<td class='fields'  width="25%"> <fmt:message key="eBL.DEPOSITCOLECTD.label" bundle="${bl_labels}"/> </td>
		<td class='fields'  width="25%"> <input type='text' name='depositCtdAmt' id='depositCtdAmt' value="<%=depositCtdAmt%>" disabled /> </td>
	   <% } %>
	</tr>
	   <%if(packageSeqNo.equals(""))
		{%>
	<tr>
		<td class='label'  width="25%"> <fmt:message key="Common.ApprovedBy.label" bundle="${common_labels}"/></td>	
		<td class='fields'  width="25%"> 
		<input type='text' name='approvedBy' id='approvedBy' size='10' maxlength="10"  value="<%=approvedBy%>" disabled  /></td>
		<td class='label'  width="25%"> 
		<fmt:message key="eBL.APPROVED_DATE.label" bundle="${bl_labels}"/> 
		</td>	
		<td class='fields'  width="25%">
		<input type='text' name='approvedDate' id='approvedDate' size='10' maxlength="10"  value="<%=approvedDate%>" disabled  />
		</td>
	</tr> 
		
		<% } %>
	<tr>
		<td class='label'  width="25%"> <fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>	
		<td class='fields'  width="25%"> 
		<input type='text' name='billingClass' id='billingClass'  value="<%=billingClass%>"  disabled  />
		</td>
		<td class='label'  width="25%"> 
		<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/> 
		</td>	
		<td class='fields'  width="25%">
		<input type='text' name='customerGrp' id='customerGrp' value="<%=customerGrp%>" disabled   />
		</td>
	</tr>
<tr>
		<td class='label'  width="25%"> <fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>	
		<td class='fields'  width="25%"> 
		<input type='text' name='customerCode' id='customerCode'  value="<%=customerCode%>"  disabled  />
		</td>
		<td class='label'  width="25%"> 
		<fmt:message key="eBL.PKG_PRICE.label" bundle="${bl_labels}"/> 
		</td>	
		<td class='fields'  width="25%">
		<input type='text' name='pkgPrice' id='pkgPrice' value="<%=pkgPrice%>" disabled   />
		</td>
	</tr>
	</table>


<%
putObjectInBean(bean_id,bean,request);

%>
</form>
</body>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from Package Enq  header :"+e);
	e.printStackTrace();
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String EnqaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? EnqaultValue : inputString);
}
%>

