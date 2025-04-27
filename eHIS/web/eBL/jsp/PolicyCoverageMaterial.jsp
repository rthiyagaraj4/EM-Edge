<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
	<form  id="frmPolicyMaster">	
      	<table width='90%' cellpadding='3'  cellspacing=0 align="center">  
      		<tr>
      		    <td class='label'>
      				<fmt:message key="eBL.DefaultInclExclItem.label" bundle="${bl_labels}"/>
      			</td>
      			<td class='fields' >
      				<Select name='defaultInclExcl' id='defaultInclExcl'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value=''><fmt:message key="eBL.AllItemsIncluded.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.AllItemsExcluded.label" bundle="${bl_labels}"/></option>
					</Select>
      			</td>
      			<td class='label'>
      				<fmt:message key="eBL.MaterialInclExclItem.label" bundle="${bl_labels}"/>
      			</td>
      			<td class='fields' >
      				<Select name='materialInclExcl' id='materialInclExcl'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value=''><fmt:message key="eBL.PayerMatGroup.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.EnterpriseMatGroup.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.SaleCategory.label" bundle="${bl_labels}"/></option>
					</Select>
      			</td>

      		</tr>
      		<tr>
      			<td class='label' >
      				<fmt:message key="eBL.MaterialItemLimit.label" bundle="${bl_labels}"/>
      			</td>
      			<td class='fields'>
      				<Select name='materialLimit' id='materialLimit'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value=''><fmt:message key="eBL.PayerMatGroup.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.EnterpriseMatGroup.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.SaleCategory.label" bundle="${bl_labels}"/></option>
					</Select>
      			</td>
      			
      			<td class='fields' >
					<input type="checkbox" name='overrideInclExcl' id='overrideInclExcl'  />
				</td>                              
				<td class='label' ><fmt:message key="eBL.OverrideInclExcl.label" bundle="${bl_labels}"/></td>	
      			
      			
      		</tr>
      		<tr>
      			<td class='label' >
      				<fmt:message key="eBL.OPCoverageLimit.label" bundle="${bl_labels}"/>
      			</td>
      			<td class='fields'>
      				<Select name='opLimitType' id='opLimitType'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value=''><fmt:message key="eBL.Restricted.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.UnRestricted.label" bundle="${bl_labels}"/></option>
					</Select>
      			</td>
      			<td class='label' ><fmt:message key="eBL.OPCoverageAmt.label" bundle="${bl_labels}"/></td>	
      			<td class='fields' >
					<input type="text" name='opLimitAmt' id='opLimitAmt' size='10' value='' />
				</td>                              
				
      			
      			
      		</tr>
			<tr>
      			<td class='label' >
      				<fmt:message key="eBL.IPCoverageLimit.label" bundle="${bl_labels}"/>
      			</td>
      			<td class='fields'>
      				<Select name='ipLimitType' id='ipLimitType'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value=''><fmt:message key="eBL.Restricted.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.UnRestricted.label" bundle="${bl_labels}"/></option>
					</Select>
      			</td>
      			<td class='label' ><fmt:message key="eBL.IPCoverageAmt.label" bundle="${bl_labels}"/></td>	
      			<td class='fields' >
					<input type="text" name='ipLimitAmt' id='ipLimitAmt' size='10' value='' />
				</td>                              
				
      			
      			
      		</tr>
      	</table>
     </form>
</body>
</html>

