<!DOCTYPE html>
<%@page import="eIP.advbedmgmt.transaction.assignbed.AssignBedConstants"%>
<%@page import="eIP.advbedmgmt.common.operatorstation.response.OsRetrieveResponse"%>
<%@page import="eIP.advbedmgmt.common.operatorstation.OsRetrieveConstants"%>
<%@page import="eIP.advbedmgmt.common.operatorstation.bc.OsRetrieveBC"%>
<%@page import="eIP.advbedmgmt.GBMConstants"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="eIP.advbedmgmt.common.operatorstation.request.OsRetrieveRequest"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Bed</title>
<script language ='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body>

<%

String facilityId =	CommonBean.checkForNull((String)session.getValue("facility_id"));
String loginUser = CommonBean.checkForNull((String)session.getValue("login_user"));
// data from request parameter
String nuCode = CommonBean.checkForNull(request.getParameter(AssignBedConstants.NURSING_UNIT_REQ_PARAM));
String nuDesc = CommonBean.checkForNull(request.getParameter(AssignBedConstants.NURSING_UNIT_DESC_REQ_PARAM));
String specialtyCode = CommonBean.checkForNull(request.getParameter(AssignBedConstants.SPECIALTY_CODE_REQ_PARAM));
String specialtyDesc = CommonBean.checkForNull(request.getParameter(AssignBedConstants.SPECIALTY_DESC_REQ_PARAM));
String showNuPopup = CommonBean.checkForNull(request.getParameter
					(AssignBedConstants.SHOW_NU_POPUP_REQ_PARAM),
					AssignBedConstants.SHOW_NU_POPUP_DEFAULT_VALUE);
String showSpecialtyPopup = CommonBean.checkForNull(request.getParameter
					(AssignBedConstants.SHOW_SPECIALTY_POPUP_REQ_PARAM),
					AssignBedConstants.SHOW_SPECIALTY_POPUP_DEFAULT_VALUE);



// get operator station id
OsRetrieveRequest osRetrRequest = new OsRetrieveRequest();
osRetrRequest.setFacilityId(facilityId);
osRetrRequest.setUserId(loginUser);
ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
OsRetrieveBC bcInst = (OsRetrieveBC) context.getBean(OsRetrieveConstants.OS_RETR_BC_NAME);
OsRetrieveResponse osRetrResponse = bcInst.getOsIdForUser(osRetrRequest);

String osId = "";
if(osRetrResponse.isSuccessful()){
	osId = osRetrResponse.getOsId();
}

// constants to be used 
final String FUNCTION_ID = "ASSIGN_BED";
final String JSP_NAME = "AssignBedMain.jsp";
final String CALL_FUNCTION = "assign_bed";
final String WHERE_CONDN = "ASSIGN_BED_YN";
final String CHG_NU_IN_ASSIGN_BED_YN = "N";

StringBuilder searchPanelURL = new StringBuilder("GBMAssignBedSearchPanel.jsp?");
searchPanelURL.append("function_id=").append(FUNCTION_ID);
searchPanelURL.append("&jsp_name=").append(JSP_NAME);
searchPanelURL.append("&call_function=").append(CALL_FUNCTION);
searchPanelURL.append("&wherecondn=").append(WHERE_CONDN);
searchPanelURL.append("&oper_stn_id=").append(osId);
searchPanelURL.append("&chg_nurs_unit_in_assign_bed_yn=").append(CHG_NU_IN_ASSIGN_BED_YN);
searchPanelURL.append("&").append(AssignBedConstants.NURSING_UNIT_REQ_PARAM).append("=").append(nuCode);
searchPanelURL.append("&").append(AssignBedConstants.NURSING_UNIT_DESC_REQ_PARAM).append("=").append(nuDesc);
searchPanelURL.append("&").append(AssignBedConstants.SPECIALTY_CODE_REQ_PARAM).append("=").append(specialtyCode);
searchPanelURL.append("&").append(AssignBedConstants.SPECIALTY_DESC_REQ_PARAM).append("=").append(specialtyDesc);
searchPanelURL.append("&").append(AssignBedConstants.SHOW_NU_POPUP_REQ_PARAM).append("=").append(showNuPopup);
searchPanelURL.append("&").append(AssignBedConstants.SHOW_SPECIALTY_POPUP_REQ_PARAM).append("=").append(showSpecialtyPopup);


%>

<!-- <div id="spaceComp" name="spaceComp" style="height:5px;">
</div> -->

<div id="searchComp" name="searchComp" style="width:100%;height:130px;display:block;">
	<iframe style="width:100%;height:100%;border-top: 0px;" src="<%=searchPanelURL.toString()%>"></iframe>
</div>

<div id="resultComp" name="resultComp" style="width:100%;height:8vh0px;" src="">
	<iframe id="resultframe" name="resultframe" style="width:100%;height:100%;border:0 px;" src=""></iframe>
</div>

<div id="legendComp" name="legendComp" style="width:100%;height:30px;" src="">
	<!-- <object id="legendObj" name="legendObj" type="text/html" data=""></object> -->
	<iframe id="legendframe" name="legendframe" style="width:100%;height:100%;border:0 px;" src=""></iframe>
</div>

<div id="errorComp" name="errorComp" style="width:100%;" src="../../eCommon/jsp/MstCodeError.jsp">
</div>


</body>
</html>

