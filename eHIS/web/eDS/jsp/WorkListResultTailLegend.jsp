<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String min_max_val="Y";//Added Against ML-MMOH-CRF-1005-US3
%>
<!--Added Against ML-MMOH-CRF-1005-US2 Starts Here -->
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/>
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<!--Added Against ML-MMOH-CRF-1005-US2 Ends Here -->
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
    <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
    <!-- Added against ML-MMOH-CRF-1005-US3 Starts Here -->
	<form name="WorkListResultTailForm" id="WorkListResultTailForm">
		<div style="position:absolute;bottom:0;">

	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img align="center" id = "img_src" src='../../eOT/images/gripper.gif' onclick="expandColorInd()" >
    <!--table border="1" cellpadding=3  cellspacing="1" width="100%"-->
	<table cellpadding="3" id='moreCriteria1' name='moreCriteria1' id='moreCriteria1' style='visible:hidden;display:none' cellspacing="0" width="1530px" align="center" border="1">
	<!-- Added against ML-MMOH-CRF-1005-US3 Ends Here -->
	<!-- Modified against ML-MMOH-CRF-1005-US3 Starts Here -->
	<tr>
	<td align=='right' width='2%' class='OAGREEN'></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eOT.OrderPlacedForCurrentDate.Label" bundle="${ot_labels}"/></td>

	<td align='right' width='2%' class='OARED'></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eOT.OrderPendingForPatient.Label" bundle="${ot_labels}"/></td>

	<td align='right'width='2%' class='CYANCLR'></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eOT.OrderReferredToTheDietician.Label" bundle="${ot_labels}"/></td>
	
	<td align='right'width='2%' class='OAYELLOW'></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eOT.OrderModified.Label" bundle="${ot_labels}"/></td>
	<!--MMS-CRF-006-->
	<td align='right' width='2%'><img src="../../eOT/images/drugInfo.gif"></img></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eDS.DietTypeModified.Label" bundle="${ds_labels}"/></td>
	<!--MMS-CRF-006-->
	<!--ML-MMOH-CRF-0600-US2-->
	<td align='right' width='2%'><img src="../../eDS/css/Action_Pending.PNG"></img></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eDS.PendingMealAcknowledgements.Label" bundle="${ds_labels}"/></td>
	<!--ML-MMOH-CRF-0600-US2-->
	<!---ML-MMOH-CRF-0410--->
	<td align='right' width='2%'><img src="../../eDS/css/NBM_With_Diet.PNG"></img></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eDS.NBMWith.Label" bundle="${ds_labels}"/></td>
	
	<td align='right' width='2%'><img src="../../eDS/css/NBM_Without_Diet.PNG"></img></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eDS.NBMWithout.Label" bundle="${ds_labels}"/></td>
	<!---ML-MMOH-CRF-0410--->
	<!-- Added Against ML-MMOH-CRF-1005-US2 Starts Here -->
	<td align='right'width='2%'><img src="../../eDS/css/Mother_Accompany_Child.png"></img></td>
	<td align='left' colspan='3' class='label'><fmt:message key="eDS.OrderPlacedFor.Label" bundle="${ds_labels}"/>&nbsp <option><%=DSCommonBeanObj.getAttendantLabel()%></option></td>
	<!-- Added Against ML-MMOH-CRF-1005-US2 Ends Here -->
	</tr>
    </table>
	<!-- Modified against ML-MMOH-CRF-1005-US3 Ends Here -->
	<!-- Added against ML-MMOH-CRF-1005-US3 Starts Here -->
	<input type="hidden" name="min_max_val" id="min_max_val" value="<%=min_max_val%>">
	</div>
	<!-- Added against ML-MMOH-CRF-1005-US3 Ends Here -->
    </form>
    </body>
</html>

