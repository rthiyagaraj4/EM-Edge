<!DOCTYPE html>
<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*,java.util.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
  	String  PkgByPolicy="";
	String	newPkg="";		
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
	//GHL-CRF-0502 Starts
	Connection con = null;
	HttpSession httpSession = request.getSession(false);
	String facilityId =  (String)httpSession.getValue("facility_id");
	if(facilityId == null) facilityId="";
	try {
		con = ConnectionManager.getConnection();
	
	boolean SiteAgeSpecialty = false;
	boolean siteAutoApplyPkgDiscYN = false;
	SiteAgeSpecialty = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AGE_SPECIALITY_APP_FOR_DISC");	
	siteAutoApplyPkgDiscYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_AUTO_APPLY_PKG_DISC_YN");
	//GHL-CRF-0502 Ends
	
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 STARTS-->
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;		
	String sqlStr="";
	//sqlStr="select  pkg_cust_disc_by_policy, pkg_cust_disc_new_pkg  from bl_parameters " ;
	sqlStr="select pkg_cust_disc_by_policy, pkg_cust_disc_new_pkg  from bl_parameters where OPERATING_FACILITY_ID='"+facilityId+"'" ;
	pstmt=con.prepareStatement(sqlStr);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
		PkgByPolicy=rs.getString("pkg_cust_disc_by_policy");
		newPkg=rs.getString("pkg_cust_disc_new_pkg");
	}		
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 ENDS-->
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>
	<tr>
		<td class='COLUMNHEADER' >
			<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>
		</td> 
		<td class='COLUMNHEADER' >
			<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>
		</td> 
		<!-- MMS-QH-CRF- 128.1 STARTS -->
		<% if(siteAutoApplyPkgDiscYN){
		 if("Y".equals(PkgByPolicy)){%>
	 	<td class='COLUMNHEADER' >
			<fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
		</td>
		<%}} %>
		<!-- MMS-QH-CRF- 128.1 ENDS -->		
		<td class='COLUMNHEADER' > 
			<fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/>
		</td>		
		<!-- MMS-QH-CRF- 128.1 Ends -->		
		<!-- GHL-CRF-0502 Starts -->
		<%
		if(SiteAgeSpecialty){
		%>
		<td class='COLUMNHEADER' > 
			<fmt:message key="eBL.HCMasterAgeGroup.label" bundle="${bl_labels}"/>
		</td>
		<td class='COLUMNHEADER' > 
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<%
			}
		%>
		<!-- GHL-CRF-0502 Ends -->
		<td class='COLUMNHEADER' > 
			<fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/>
		</td> 
		<td class='COLUMNHEADER' > 
			<fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/>
		</td>		
		<td class='COLUMNHEADER' >
			<fmt:message key="eBL.discountType.label" bundle="${bl_labels}"/>
		</td>
		<td class='COLUMNHEADER' >
			<fmt:message key="eBL.Discount.label" bundle="${bl_labels}"/>
		</td>
		<td class='COLUMNHEADER' >
			<fmt:message key="Common.Select.label" bundle="${common_labels}"/>
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


