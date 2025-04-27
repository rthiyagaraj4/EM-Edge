<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>

<%
	String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//Added V190325 Gayathri/KDAH-CRF-0503
	Connection con = null;	
	Boolean allow_masterChild_package=false;
	String allow_masterChild_package_map ="";
	String isMasterPackYN="N";
	PreparedStatement pstmt	= null;
	ResultSet rs = null;
	String packageCode =request.getParameter("packageCode")==null?"N":request.getParameter("packageCode");
	String facilityId = (String)session.getAttribute("facility_id");
	String  PkgByPolicy="";	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
	String	newPkg="";		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
	Boolean siteAutoApplyPkgDiscYN = false;
	try
	{
		con = ConnectionManager.getConnection();	
		allow_masterChild_package = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ALLOW_MASTER_CHILD_PKG_MAPPING");	
		String sql="select IS_MASTER_PKG_YN from bl_package where PACKAGE_CODE=? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, packageCode);
		rs = pstmt.executeQuery();
		if( rs != null ) 
		{
			while( rs.next() )
			{			
				isMasterPackYN = rs.getString(1);
			}
		}	
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();	
	
		if(allow_masterChild_package){
			allow_masterChild_package_map="Y";
		}
		else{
			allow_masterChild_package_map="N";
		}
		//Added V190325 Gayathri/KDAH-CRF-0503/Ends
	
		//added by palani/MMS-QH-128.1/STARTS
		//HttpSession httpSession = request.getSession(false);
	
		siteAutoApplyPkgDiscYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_AUTO_APPLY_PKG_DISC_YN");
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 STARTS-->
		String sqlStr="";
		sqlStr = "select  pkg_cust_disc_by_policy, pkg_cust_disc_new_pkg  from bl_parameters where OPERATING_FACILITY_ID=?" ;
		pstmt = con.prepareStatement(sqlStr);
		pstmt.setString(1, facilityId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			PkgByPolicy = rs.getString("pkg_cust_disc_by_policy");			
			newPkg = rs.getString("pkg_cust_disc_new_pkg");	
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();	
		if(con!=null) con.close();
		ConnectionManager.returnConnection(con);
		System.out.println("Conection closed");
	}
	//MMS-QH-CRF-128.1  PALANINARAYANAN 17/6/2020 ENDS-->
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script>
	<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
    <Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>


 

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="chkMasterpack1()">
<form name="frmPkgDefTab" id="frmPkgDefTab" >

<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
			 <li class='tablistitem' title='Package Base Price'>
				<a onclick='showTabDetail("PACKAGE_PRICE","1","<%=from%>")' class="tabA" id="PACKAGE_PRICE">
					<span class="tabAspan" id="PACKAGE_PRICEspan">
						Package Base Price
						</span></a>
			</li> 

			<li class="tablistitem" title='Package Services(Rate Based)'>
				<a onclick="showTabDetail('RATE_BASED','1','<%=from%>')" class="tabA" id="RATE_BASED">
					<span class="tabAspan" id="RATE_BASEDspan">
						<!--<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>-->
						Package Services(Rate Based)
						</span></a>
			</li>

			<li class="tablistitem" title='Package Services(Charge Based)'>
				<a onclick="showTabDetail('CHARGE_BASED','1','<%=from%>')" class="tabA" id="CHARGE_BASED">
					<span class="tabAspan" id="CHARGE_BASEDspan">
						<!--<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>-->
						Package Services(Charge Based)
						</span></a>
			</li>	
			<%if(("Y").equals(allow_masterChild_package_map)){ %>
			 <li class='tablistitem' title='Child Package'>
				<a onclick='showTabDetail("CHILD_PACK","1","<%=from%>")' class="tabA" id="CHILD_PACK">
					<span class="tabAspan" id="CHILD_PACKspan">
						Associate Child Package
						</span></a>
			</li> 	
			<%} %>
		</ul>
	</td>	
	</tr>
	</table>
	<input type='hidden' name='prevTabObj' id='prevTabObj' value="" />
	<input type='hidden' name='fromDate' id='fromDate' value="" />
	<input type='hidden' name='index' id='index' value="0" />
	<input type='hidden' name='allow_masterChild_package_map' id='allow_masterChild_package_map' value="<%=allow_masterChild_package_map%>" />
	<input type='hidden' name='isMasterPackYN' id='isMasterPackYN' value="<%=isMasterPackYN%>" />
	<!-- The below line is required to change the select state of Initial tab selected -->
	<!-- Added for MMS-QH-CRF-128.1 STARTS -->
	<input type='hidden' name='siteAutoApplyPkgDiscYN' id='siteAutoApplyPkgDiscYN' value="<%=siteAutoApplyPkgDiscYN%>" />
	<input type='hidden' name='newPkg' id='newPkg' value="<%=newPkg%>" />
	<!-- Added for MMS-QH-CRF-128.1  ENDS-->
	
	<script>//prevTabObj='PACKAGE_PRICE'</script>
	<script>//showTabDetail('PACKAGE_PRICE','0')</script>
</form>
</body>
</html>

