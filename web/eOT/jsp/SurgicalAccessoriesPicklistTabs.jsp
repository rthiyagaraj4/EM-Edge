<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eST.OTTransactionBean,eST.*,webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*"%><%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%@ page import="java.util.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<html>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/Tabs.css' type='text/css'/>
	<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
	<script language="JavaScript" src="../../eOT/js/PickList.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<%
	String from_val="";
	from_val=request.getParameter("from_val");
	if(from_val ==null) from_val="PI";
	String strPatientId=CommonBean.checkForNull(request.getParameter("patient_id"));	
	String strSurgeryDate=CommonBean.checkForNull(request.getParameter("surgery_date"));
	String strSurgeonCode=CommonBean.checkForNull(request.getParameter("surgeoncode"));
	String strBookingNum=CommonBean.checkForNull(request.getParameter("booking_no")); 
	String strOperCode=CommonBean.checkForNull(request.getParameter("oper_code"));
	String strOperRoomCode=CommonBean.checkForNull(request.getParameter("oper_room_code"));
//Added newly by MuthuN against CRF-268 Starts
	String ot_Param="";
	Connection connection   = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs2 = null;
	int no_of_units =0;
	String facility_id	= (String)session.getValue("facility_id");
	try{
		connection	= ConnectionManager.getConnection(request);		
		//Based on parameter
		String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
		pstmt = connection.prepareStatement(sqlOtParam);
		pstmt.setString(1,facility_id);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			ot_Param=rs.getString("facility");	
		}
		pstmt = null;
		rs = null;

%>
<script language="javascript">
function load_sel_tab()
{
		var from_val="<%=from_val%>";
		var objStr="";
		if(from_val =="PI")
		{	
		objStr ="Packageimplant";
		}else if(from_val =="IE")
		{
		objStr ="Instrumentsequipment";
		}else if(from_val =="PD")
		{
		objStr ="personaldetail";
		}else if(from_val =="PP")
		{
		objStr ="package";
		}
		selectTab(objStr);
}
function changeTab(objStr)
{
	selectTab(objStr);
	var from_val=document.forms[0].from_val.value;
	var strPatientId=document.forms[0].strPatientId.value;
	var strSurgeryDate=document.forms[0].strSurgeryDate.value;
	var strSurgeonCode=document.forms[0].strSurgeonCode.value;
	var strBookingNum=document.forms[0].strBookingNum.value;
	var strOperCode=document.forms[0].strOperCode.value;
	var strOperRoomCode=document.forms[0].strOperRoomCode.value;
	//var strquantityAvail=document.forms[0].strquantityAvail.value;
	var ot_Param = document.forms[0].ot_Param.value;
	//alert("ot_Param   "+ot_Param );
	if(objStr=='Packageimplant'){
		from_val="PI"
		var url="../../eOT/jsp/PickListReviewItemSelect.jsp?from_val="+from_val+"&patient_id="+strPatientId+"&surgery_date="+strSurgeryDate+"&surgeoncode="+strSurgeonCode+"&booking_no="+strBookingNum+"&oper_code="+strOperCode+"&oper_room_code="+strOperRoomCode;
		parent.frames[1].location.href=url;
	}else if(objStr=='package'){
		from_val="PP"
		//Based on Parameter Values	
		if(ot_Param == 'Y' || ot_Param=='y'){
			//from_val="PP"
		var url="../../eOT/jsp/PickListReviewItemSelect.jsp?from_val="+from_val+"&patient_id="+strPatientId+"&surgery_date="+strSurgeryDate+"&surgeoncode="+strSurgeonCode+"&booking_no="+strBookingNum+"&oper_code="+strOperCode+"&oper_room_code="+strOperRoomCode+"&ot_Param="+ot_Param;
		parent.frames[1].location.href=url;
		}else{
			//from_val="PP"
		var url="../../eOT/jsp/PickListReviewItemSelect.jsp?from_val="+from_val+"&patient_id="+strPatientId+"&surgery_date="+strSurgeryDate+"&surgeoncode="+strSurgeonCode+"&booking_no="+strBookingNum+"&oper_code="+strOperCode+"&oper_room_code="+strOperRoomCode;
		parent.frames[1].location.href=url;
		}
	}else if(objStr=='Instrumentsequipment'){
		from_val="IE"
		//Based on Parameter Values
		if(ot_Param == 'Y' || ot_Param=='y'){
			//from_val="IE"
		var url="../../eOT/jsp/PickListReviewItemSelect.jsp?from_val="+from_val+"&patient_id="+strPatientId+"&surgery_date="+strSurgeryDate+"&surgeoncode="+strSurgeonCode+"&booking_no="+strBookingNum+"&oper_code="+strOperCode+"&oper_room_code="+strOperRoomCode+"&ot_Param="+ot_Param;
		parent.frames[1].location.href=url;
		}else{
		//from_val="IE"
		var url="../../eOT/jsp/PickListReviewItemSelect.jsp?from_val="+from_val+"&patient_id="+strPatientId+"&surgery_date="+strSurgeryDate+"&surgeoncode="+strSurgeonCode+"&booking_no="+strBookingNum+"&oper_code="+strOperCode+"&oper_room_code="+strOperRoomCode;
		//alert("test... IE url "+url);
		parent.frames[1].location.href=url;
		}
	}
	if(objStr=='personaldetail'){
		from_val="PD"		
		var url="../../eOT/jsp/PickListReviewItemSelect.jsp?from_val="+from_val+"&patient_id="+strPatientId+"&surgery_date="+strSurgeryDate+"&surgeoncode="+strSurgeonCode+"&booking_no="+strBookingNum+"&oper_code="+strOperCode+"&oper_room_code="+strOperRoomCode;
		//alert("test... url "+url);
		parent.frames[1].location.href=url;
	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body Onload='load_sel_tab()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="surgicalaccessories_picklisttab" id="surgicalaccessories_picklisttab">

<table border="1" cellpadding=3  cellspacing="0" width="100%" align='center'>
	<tr> 
	<td  class='COLUMNHEADER'>
	<fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/>
	</td>
	</tr>
</table>
<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%'>
<tr>
	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" >
		<li class="tablistitem" title='<fmt:message key="eOT.Implants.Label" bundle="${ot_labels}"/>' >
			<a  class="tabClicked"  onclick="changeTab('Packageimplant');" id="Packageimplant"> 
				<span class="tabSpanclicked" id="Packageimplantspan"><fmt:message key="eOT.Implants.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
		
		<li class="tablistitem" title='<fmt:message key="Common.Package.label" bundle="${common_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('package');" id="package"> 
				<span class="tabAspan" id="packagespan"><fmt:message key="Common.Package.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>

		<li class="tablistitem" title='<fmt:message key="eOT.InstrumentsandEquipments.Label" bundle="${ot_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('Instrumentsequipment');" id="Instrumentsequipment"><span class="tabAspan" id="Instrumentsequipmentspan"><fmt:message key="eOT.InstrumentsandEquipments.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>

		<li class="tablistitem" title='<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('personaldetail');" id="personaldetail"> 
				<span class="tabAspan" id="personaldetailspan"><fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
	</ul>
	</td>
</tr>
</td>
<script>prevTabObj='Packageimplant'</script>


</table>
<input type='hidden' name='param' id='param' value="">
<input type='hidden' name='from_val' id='from_val' value="<%=from_val%>">
<input type='hidden' name='strPatientId' id='strPatientId' value="<%=strPatientId%>">
<input type='hidden' name='strSurgeryDate' id='strSurgeryDate' value="<%=strSurgeryDate%>">
<input type='hidden' name='strSurgeonCode' id='strSurgeonCode' value="<%=strSurgeonCode%>">
<input type='hidden' name='strBookingNum' id='strBookingNum' value="<%=strBookingNum%>">
<input type='hidden' name='strOperCode' id='strOperCode' value="<%=strOperCode%>">
<input type='hidden' name='strOperRoomCode' id='strOperRoomCode' value="<%=strOperRoomCode%>">

<!-- CRF-268 PickList By MuthuN -->
<input type='hidden' name='ot_Param' id='ot_Param' value='<%=ot_Param%>'>
<input type='hidden' name='no_of_units' id='no_of_units' value='<%=no_of_units%>'>
<!-- CRF-268 PickList By MuthuN -->
<%
	}catch ( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountCreateSet: "+e);
		e.printStackTrace() ;
	}finally {
		try{			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception es){es.printStackTrace();}
	}
%>
</form>
</body>
</html>

