<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>

<%
	System.out.println("this is from PkgDefMainTab.jsp");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String authorized =request.getParameter("authorized")==null?"N":request.getParameter("authorized");
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")==null?"N":request.getParameter("pkgApprovedYN");

	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String isUserCanAcess		= (String) session.getValue( "isUserCanAcess" ) ;
	
	boolean siteBLPkgBlngGrp = false; //Added By Shikha For GHL-CRF-0520.1
	
	//sarathkumar added code make as siteSpecific beginning... // saraa
	Connection conn = null;	
	Boolean ss=false;
	try
	{
		conn = ConnectionManager.getConnection();	
		ss = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","INCL/EXCL_HOME_MEDICATION");
		System.out.println("sarath PkgDefMainTab.jsp SiteSpec"+ss);
	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in site specific "+e);
	}
	//Added By Shikha For GHL-CRF-0520.1
	try {		
		siteBLPkgBlngGrp = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_PKG_BLNG_GRP");		
	} catch(Exception ex) {
			System.err.println("Error in PkgDefMainTab.jsp for getting siteBLPkgBlngGrp Connection: "+ex);
			ex.printStackTrace();
	}
	//Ended By Shikha For GHL-CRF-0520.1
//Added V190325 Gayathri/KDAH-CRF-0503
Boolean allow_masterChild_package=false;
String allow_masterChild_package_map ="";
try
{
	
	allow_masterChild_package = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","ALLOW_MASTER_CHILD_PKG_MAPPING");	
}catch(Exception e)
{
	e.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(conn);
	System.out.println("Conection closed");
}
if(allow_masterChild_package){
	allow_masterChild_package_map="Y";
}
else{
	allow_masterChild_package_map="N";
}
//Added V190325 Gayathri/KDAH-CRF-0503/EndsS	
	session.setAttribute( "siteSpecf", ss );
//sarathkumar added code make as siteSpecific ending...
	
	

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src='../../eBL/js/PkgDef.js'></script> 
<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script>
<script language="javascript" src='../../eBL/js/PkgDefBlngGrp.js'></script>  
<script language="javascript" src='../../eBL/js/PkgDefDiscount.js'></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>


 

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmPkgDefTab" id="frmPkgDefTab" >

<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
				<li class="tablistitem" title='Package'>
				<a onclick="showMainTabDetails('PACKAGE')" class="tabA" id="PACKAGE">
					<span class="tabAspan" id="PACKAGEspan">
						<fmt:message key="Common.Package.label" bundle="${common_labels}"/>
						</span></a>
			</li>
			<% if (siteBLPkgBlngGrp) { %>
			<li class="tablistitem" title='<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/>'>
				<a onclick="showMainTabDetails('BILLINGGROUP')" class="tabA" id="BILLINGGROUP" >
					<span class="tabAspan" id="BILLINGGROUPspan">					
					<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/>						
					</span></a>
			</li>
			<%} %> 
			<li class="tablistitem" title='<fmt:message key="eBL.Customers.label" bundle="${bl_labels}"/>'>
				<a onclick="showMainTabDetails('CUSTOMER')" class="tabA" id="CUSTOMER" >
					<span class="tabAspan" id="CUSTOMERspan">					
					<fmt:message key="eBL.Customers.label" bundle="${bl_labels}"/>						
					</span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/>'>
				<a onclick="showMainTabDetails('DISCOUNT')" class="tabA" id="DISCOUNT" >
					<span class="tabAspan" id="DISCOUNTspan">					
					<fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/>						
					</span></a>
			</li>
	
		</ul>
	</td>	
	</tr>
	<input type='hidden' name='last_link' id='last_link' value="PACKAGE"/>
	<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
	<input type='hidden' name='mode' id='mode' value="<%=mode%>" />
	<input type='hidden' name='isUserCanAcess' id='isUserCanAcess' value="<%=isUserCanAcess%>" />
	<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
	<input type='hidden' name='prevTabObj' id='prevTabObj' value="" />
</table>  
<!-- The below line is required to change the select state of Initial tab selected -->
<script>//selectTab("PACKAGE");
changeMainTabClass("PACKAGE",parent.PkgDefMainTab)</script> 

</form>
</body>
</html>

