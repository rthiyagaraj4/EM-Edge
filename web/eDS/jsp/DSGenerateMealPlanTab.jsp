<!DOCTYPE html>
<%@  page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facility_id	= (String)session.getAttribute("facility_id");
	String gracePeriodApplicable = "";
%>
<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>

<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.GenerateMealPalnTabForm;
	var obj=document.getElementById("GenerateMealPlan");
	var params=frmObj.params.value;
	params=params+"&tab_name="+objStr;
	parent.at_tab_frame.location.href="../../eDS/jsp/DSMealPlanTabFrames.jsp?"+params;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<STYLE TYPE="text/css">
       	A:link{
       	     COLOR: white;
       	}
     	A:visited{
             COLOR: white ;
        }
        A:active{
             COLOR: white;
        }
</style>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try{
		con=ConnectionManager.getConnection(request);
		String sqlQuery = "SELECT GRACE_PERIOD_APPLICABLE_YN FROM DS_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
		stmt=con.prepareStatement(sqlQuery);
		rs=stmt.executeQuery();
		if(rs != null && rs.next()) {
			if(rs.getString(1) == null){
				gracePeriodApplicable = "";
			}else{
				gracePeriodApplicable = rs.getString(1);
			}
			
		}
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in DSGenerateMealPlanTab.jsp ==" + e);
	} finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (con != null) ConnectionManager.returnConnection(con, request);
	}	
%>

<form name="GenerateMealPalnTabForm" id="GenerateMealPalnTabForm">
<table id="tab" cellspacing=3 cellpadding="1" border="0" width="100%">
  <tr>
	<td width= "100%" class="white">
	<!--ul id="tablist" class="tablist" -->
		<ul class="tablistitem" title='<fmt:message key="eOT.GenerateMealPlan.Label" bundle="${ot_labels}"/>'>
			<a  class="tabClicked"  onclick="changeTab('GenerateMealPlan');" id="GenerateMealPlan">
				<span class="tabSpanclicked" id="GenerateMealPlanspan">
				<fmt:message key="eOT.GenerateMealPlan.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</ul>		
		
	<!-- MMS-DM-CRF-0044
	<li class="tablistitem" title='<fmt:message key="eOT.GenerateMealPlanAttendant.Label" bundle="${ot_labels}"/>'>
			<a  class="tabClicked"  onclick="changeTab('GenerateMealPlanAttendant');" id="GenerateMealPlanAttendant">
				<span class="tabAspan" id="GenerateMealPlanAttendantspan">
				<fmt:message key="eOT.GenerateMealPlanAttendant.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
	
	MMS-DM-CRF-0044 -->
		<ul class="tablistitem" title='<fmt:message key="eOT.PrintMealDietList.Label" bundle="${ot_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('PrintMealDietList');" id="PrintMealDietList">
				<span class="tabAspan" id="PrintMealDietListspan">
				<fmt:message key="eOT.PrintMealDietList.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</ul>

	<%
		if(gracePeriodApplicable.equals("Y")){
	%>
	<ul class="tablistitem" title='<fmt:message key="eOT.DischargedPatients.Label" bundle="${ot_labels}"/>'>
<!--			<a  class="tabClicked"  onclick="" id="DischargedPatients">-->
			<a  class="tabA"  onclick="" id="DischargedPatients">

				<span class="tabAspan" id="DischargedPatientsspan">
				<fmt:message key="eOT.DischargedPatients.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</ul>
	<%
		}else{
	%>
	<ul class="tablistitem" title='<fmt:message key="eOT.DischargedPatients.Label" bundle="${ot_labels}"/>'>
			<a  class="tabA"  onclick="changeTab('DischargedPatients')" id="DischargedPatients">
				<span class="tabAspan" id="DischargedPatientsspan">
				<fmt:message key="eOT.DischargedPatients.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</ul>
	<%}
	%>	
	<ul class="tablistitem" title='<fmt:message key="eOT.DietOrderSheet.Label" bundle="${ot_labels}"/>' >
			<!--<a  class="tabClicked"  onclick="changeTab('DietOrderSheet');" id="DietOrderSheet">-->
			<a  class="tabA"  onclick="changeTab('DietOrderSheet');" id="DietOrderSheet">


				<span class="tabAspan" id="DietOrderSheetspan">
				<fmt:message key="eOT.DietOrderSheet.Label" bundle="${ot_labels}"/>
				</span>
			</a>
	</ul>	
	</td>
</tr>
<script> prevTabObj='GenerateMealPlan'</script>
</table>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
</form>
</body>
</html>

