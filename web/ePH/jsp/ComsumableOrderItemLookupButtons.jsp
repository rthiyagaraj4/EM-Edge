<!DOCTYPE html>
<%@page import="java.sql.Connection,webbeans.eCommon.ConnectionManager"%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
05/10/2017	  	IN064474	        Devindra 											GHL-CRF-0467 [IN064474] 
07/01/2019		IN068344		    Devindra				 		                    Required indication of different item types during dispense/order 
                                                                                        according to patient billing group.
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
28/05/2020      	IN072995         	Haribabu                                            PMG2020-NMC-JD-CRF-0001                
22/07/2020		IN:072092	        Manickavasagam J			     GHL-CRF-0618
10/08/2020		IN:73512	        Manickavasagam J			     GHL-CRF-0618
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String	consider_stock			=	request.getParameter("consider_stock")==null?"":request.getParameter("consider_stock");	//Added for GHL-CRF-0467
		String allow_alt_for_med_item   = request.getParameter("allow_alt_for_med_item")==null?"":request.getParameter("allow_alt_for_med_item"); // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
	    Connection connection = null; // Added for GHL-CRF-0549 [IN:068344] 
	    boolean item_type_yn  = false;
	    boolean ext_disp_appl =false;//Added for IN072995
	    String	CALL_FROM	=	request.getParameter("CALL_FROM")==null?"":request.getParameter("CALL_FROM"); // Added for GHL-CRF-0549
		boolean formulary_billing_app = false; //GHL-CRF-0618
		try {
			  connection = ConnectionManager.getConnection(request);
			   ext_disp_appl = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","EXT_DISP_APPL");//Added for IN072995
			 if(!"DISP".equals(CALL_FROM)){
			  item_type_yn =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","ITEM_TYPE_APP");
			  formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","FORMULARY_BLG_GRP_APP");  //GHL-CRF-0618
			 }
		}
		catch(Exception e) {
			  out.print("Exception @ Result JSP :"+e.toString());
			  e.printStackTrace();
		}
		finally{		
			if(connection != null)
			  ConnectionManager.returnConnection(connection,request);
		} // Added for GHL-CRF-0549 [IN:068344] - End - Devindra
		//String calling_mode = request.getParameter("calling_mode")==null?"":request.getParameter("calling_mode");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/ConsumableOrder.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frm_consumableItemLkpButtons" id="frm_consumableItemLkpButtons">
		<table border="1" width="100%" cellspacing="1" cellpadding="1">
			<tr>
<% 				if(consider_stock.equals("Y")) {	//if condition added for GHL-CRF-0467
%>					<td class='INSUFFICIENTSTOCK' width='1%'></td>
					<td class='white' >
						<label style="font-size:10;color:red;font-weight:bold"><fmt:message key="ePH.NoStockinDispenseLocation.label" bundle="${ph_labels}"/></label>
					</td>
	
<%} // if condition Added for GHL-CRF-0467 -End
%>						<!-- Commented for GHL-CRF-0467 starts -->
<!-- 					<td class='INSUFFICIENTSTOCK' width='1%'>&nbsp;</td> -->
<!-- 					<td class='white' >&nbsp;&nbsp; -->
<%-- 						<label style="font-size:10;color:red;font-weight:bold"><fmt:message key="ePH.NoStockinDispenseLocation.label" bundle="${ph_labels}"/></label> --%>
<!-- 					</td> -->
						<!-- Commented for GHL-CRF-0467 ends -->
				<td align="right" class="white"><img src='../../ePH/images/Insurance.gif'  height='15' width='15' ></td>
				<td class="white" align="left"><fmt:message key="ePH.PreferredDrugs CoveredUnderPolicy.label" bundle="${ph_labels}"/> </td>
				<!--Added for IN072995 starts -->
				<%if(ext_disp_appl){ %>
				<td align="right" class="white"><img src='../../ePH/images/ExternalDispensing.gif'  height='18' width='20' ></td>
				<td class="white" align="left"  nowrap>&nbsp;&nbsp;<fmt:message key="ePH.ExternalDispensing.label" bundle="${ph_labels}"/> </td>
				<%} 
			     if(item_type_yn && !formulary_billing_app){ // Added for GHL-CRF-0549 [IN:068344] - Start - Devindra and formulary_billing_app for GHL-CRF-0618 %><!--Added for IN072995 end  -->
				<td align="right" class="white"><img src='../../ePH/images/LowCost.jpg'  height='15' width='15' ></td>
				<td class="white" align="left"><fmt:message key="ePH.LowCostItem.label" bundle="${ph_labels}"/></td>
				<td align="right" class="white"><img src='../../ePH/images/HighMargin.jpg'  height='15' width='15' ></td>
				<td class="white" align="left"><fmt:message key="ePH.HighMarginItem.label" bundle="${ph_labels}"/> </td>
				<td align="right" class="white"><img src='../../ePH/images/Innovator.jpg'  height='15' width='15' ></td>
				<td class="white" align="left"><fmt:message key="ePH.Innovator.label" bundle="${ph_labels}"/> </td>
				<%} if(allow_alt_for_med_item.equals("Y")){ %>
				<td align="right" class="white"><img src='../../ePH/images/altenate.jpg'  height='15' width='15' ></td>
				<td class="white" align="left"><fmt:message key="ePH.AlternateItems.label" bundle="${ph_labels}"/> </td>
				<%} // Added for GHL-CRF-0549 [IN:068344]  - End %>
				
			
					<%if(formulary_billing_app)  //Start of GHL-CRF-0618
						{%>
					
							<td class='white' ></td>	
							 <td class="white" align="left">
									<img src="../../ePH/images/Preference1.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem1.label" bundle="${ph_labels}"/>&nbsp;</td>
												
								<td class="white" align="left">
									<img src="../../ePH/images/Preference2.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem2.label" bundle="${ph_labels}"/>&nbsp;</td>
								
								<td class="white" align="left">
									<img src="../../ePH/images/Preference3.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem3.label" bundle="${ph_labels}"/>&nbsp;</td>
								
								<td class="white" align="left">
									<img src="../../ePH/images/Preference4.jpg"  height='15' width='15' >
								</td>
								<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.NonPreferedItem.label" bundle="${ph_labels}"/>&nbsp;</td>
					
							<%
							}%>    <!-- End of GHL-CRF-0618 -->
					<td class='white' align='right'>
					<input type="button" name="btn_itemSelect" id="btn_itemSelect" value='<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>' class="button"  onClick="returnAllSelectedDrugs();" disabled>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html> 

