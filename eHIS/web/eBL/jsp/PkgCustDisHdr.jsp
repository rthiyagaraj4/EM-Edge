<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//GHL-CRF-0502 Starts
	Connection con = null;
	HttpSession httpSession = request.getSession(false);
	try {
		con = ConnectionManager.getConnection();
	/*} catch (Exception ex) {
		ex.printStackTrace();
	}*/	
	boolean SiteAgeSpecialty = false;
	SiteAgeSpecialty = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AGE_SPECIALITY_APP_FOR_DISC");	
	//GHL-CRF-0502 Ends
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>
	<tr>
	<li class="tablistitem" title="Actpackdis">
					<a onclick="" class="tabA" id="AdvanceTab" >
						<span class="tabAspan" id="ActpackdisTabspan"><fmt:message key="eBL.ActivePackDiscount.label" bundle="${bl_labels}"/></span>
					</a>
				</li>
	</tr>
	<tr>
		<td class='columnheader' width='15%' nowrap>
			<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>
		</td> 
		<td class='columnheader' width='15%' nowrap>
			<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>
		</td> 
		<td class='columnheader' width='15%' nowrap>
			<fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
		</td>		
		
		<td class='columnheader' width='15%' nowrap> 
			<fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/>
		</td>
		
		 <td class='columnheader' width='15%' nowrap>
			<fmt:message key="Common.Package.label" bundle="${common_labels}"/>
		</td> 
		
	
		<td class='columnheader' witdh='6%' nowrap> 
			<fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/>
		</td> 
		<td class='columnheader' width='6%' nowrap> 
			<fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/>
		</td>		
		<td class='columnheader' width='6%' nowrap>
			<fmt:message key="eBL.discountType.label" bundle="${bl_labels}"/>
		</td>
		<td class='columnheader' width='7%' nowrap>
			<fmt:message key="eBL.Discount.label" bundle="${bl_labels}"/>
		</td>		
	</tr>
	</table>
</form>	
<%
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	finally
	{
		if(con!=null) con.close();
		//if(con!=null) ConnectionManager.returnConnection(con);
	}
%>
</body>
</html>


