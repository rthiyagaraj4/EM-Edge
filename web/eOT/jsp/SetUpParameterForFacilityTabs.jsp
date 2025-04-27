
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facilityid  = (String) session.getValue("facility_id");
%>
    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language='javascript' src='../../eOT/js/SetUpParameterForFacility.js'></script>
	<script language='javascript' src='../../eOT/js/OTCommon.js'></script>
<script language='javascript'>
	
function changeTab(objStr){
	//alert(parent.frames[2].document.forms[0].name);
	if(parent.frames[2].document.forms[0] ){
		var frmObj = parent.frames[2].document.forms[0];
		var retVal = formApply(frmObj,OT_PERSISTENCE_MANAGER);
		//alert(retVal);
	}
	selectTab(objStr);
	var formObj=document.forms[0];
	if(objStr=='MainPage'){
		parent.frames[2].location.href="../../eOT/jsp/SetUpParameterForFacilityAddModify.jsp?";
	}else if(objStr=='OtherDetails'){
		parent.frames[2].location.href="../../eOT/jsp/SetUpParameterForFacilityOtherDetailsAddModify.jsp?";
	}else if(objStr=='BillingSetup'){
		parent.frames[2].location.href="../../eOT/jsp/SetUpParameterForFacilityBillingSetupAddModify.jsp?";
	}
	//Rajesh V
	else if(objStr=='AdditionalDetails'){
		parent.frames[2].location.href="../../eOT/jsp/SetUpParameterForFacilityAdditionalDetailsAddModify.jsp?";
	}
	//Rajesh V
		
 }

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
/*try {			
				String sql="SELECT BL_INTERFACE_FLAG FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
				//String sql="SELECT BL_INTERFACE_FLAG FROM OT_PARAM_FOR_FACILITY";
				conn = ConnectionManager.getConnection(request);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,facilityid);
				rs= pstmt.executeQuery();
				while( rs.next())
				{
					intrfce_billing_yn=rs.getString(1);
					if(intrfce_billing_yn==null) intrfce_billing_yn="";
			
				}
				}catch(Exception e){
					e.printStackTrace();
		   }finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
	}*/
%>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='checkBillSetupFlag();'>
		<form name="SetUpParameterForFacility" id="SetUpParameterForFacility" onload='FocusFirstElement();'  action="../../servlet/eOT.SetUpParameterForFacilityServlet" method="post" target="messageFrame"> 
		  <table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%' align='center'>
			 <tr>
				<td width="100%" class="white">
				 <ul id='tablist' class='tablist' style='padding-left:0px'>
					<li class='tablistitem' title='<fmt:message key="eOT.SetupParameter.Label" bundle="${ot_labels}"/>'>
							<a onclick="changeTab('MainPage')" class="tabclicked" id="MainPage">
								<span class="tabSpanclicked" id="MainPagespan">
								<fmt:message key="eOT.SetupParameter.Label" bundle="${ot_labels}"/></span>
							</a>
				   </li>
				   <li class="tablistitem" title='<fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/>'>
						<a onclick="changeTab('OtherDetails')" class="tabA" id="OtherDetails">
						<span class="tabAspan" id="OtherDetailsspan">
							<fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></span>
						</a>
				   </li>
				    <li class="tablistitem" title='<fmt:message key="eOT.BillingSetup.Label" bundle="${ot_labels}"/>'>
						<a onclick="changeTab('BillingSetup')" class="tabA" id="BillingSetup">
						<span class="tabAspan" id="BillingSetupspan">
							<fmt:message key="eOT.BillingSetup.Label" bundle="${ot_labels}"/></span>
						</a>
				   </li>
				   <!-- Rajesh V-->
				   <li class="tablistitem" title='<fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/>'>
						<a onclick="changeTab('AdditionalDetails')" class="tabA" id="AdditionalDetails">
						<span class="tabAspan" id="AdditionalDetailsspan">
							<fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></span>
						</a>
				   </li>
				   <!-- Rajesh V-->
		        </ul>
	          </td>
           </tr>
        </table>
<!-- The below line is required to change the select state of Initial tab selected -->
	<script>prevTabObj='MainPage'</script>
	<script>changeTab('MainPage')</script>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
  </form>
 </head>
</html>



