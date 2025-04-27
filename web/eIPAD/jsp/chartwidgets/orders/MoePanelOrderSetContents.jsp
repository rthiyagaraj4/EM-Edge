
<%@page import="eOR.OrderEntryQueryBean"%>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>

<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="querybean" scope="page" class="eOR.OrderEntryQueryBean"/>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 


PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
OrderEntryBean bean = null;
ArrayList Panels = null;
if(patientContext!=null){
	String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
	String or_bean_name = "eOR.OrderEntryBean";
	bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
	querybean.setLanguageId(patientContext.getLocale());
	
	Properties properties = (Properties)session.getValue("jdbc"); 
	String measure_id = bean.checkForNull(request.getParameter("measure_id"), "");
	String order_catalog_nature	= bean.checkForNull(request.getParameter("order_catalog_nature"), "");
	String contr_msr_panel_id = bean.checkForNull(request.getParameter("contr_msr_panel_id"), "");
	String category					= bean.checkForNull(request.getParameter("category"), "");	
	String facility_id				= patientContext.getFacilityId();
	String encounter_id				= bean.checkForNull(patientContext.getEncounterId(), "");	
	String patient_class			= bean.checkForNull(patientContext.getPatientClass(), "");	
	String admission_date			= bean.checkForNull(bean.getVisitAdmDate(), "");	
	String discharge_date_time		= bean.checkForNull(bean.getDischargeDateTime(), "");	
	String catalog_code 				= bean.checkForNull(request.getParameter("catalog_code"), "");
	String pract_type		        = bean.checkForNull(patientContext.getPracType(), "");
	Panels				= querybean.getPanelItems(properties, measure_id,order_catalog_nature,contr_msr_panel_id,category, facility_id,encounter_id,patient_class,admission_date,discharge_date_time,catalog_code,pract_type);
	
}


%>
<!DOCTYPE html>
<html>
<head>

<script src="${path}/eIPAD/js/ColumnLayout.js"></script>
<script src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 


<meta charset=utf-8 />
<title>JS Bin</title>
<link rel="stylesheet" href="${path}/eIPAD/css/PlaceOrders.css" />
<script type="text/javascript">

var ordItemContentsScroll;

function assignOrdItemContentsScroll () {
	ordItemContentsScroll = new IScroll('#OrdItemContentsWrap', { 
		scrollX: false, 
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true, disableMouse: false,  disablePointer: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
}



</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
.vscroller5{
	width: 100%;
	height: auto;
	position: absolute;
	z-index: 1;
}
.ORi_item
{
margin-bottom: 2px;
border-top: 1px solid rgba(203, 214, 225, 0.76);
border-bottom: 1px solid rgba(203, 214, 225, 0.76);
padding-top: 10px;
padding-bottom: 10px;
padding-left: 5px;
font-family: Arial, Helvetica, sans-serif;
font-size: 12px;
font-weight: bold;
color: #484848;
text-align: left;
list-style: none;
overflow:hidden;
}

</style>
</head>
<body onload="assignOrdItemContentsScroll()">

<div id="OrdItemContentsWrap" style="position: absolute;width: 100%;height:100%;overflow: hidden;">
	<div class="vscroller5" id="">
		<%if(Panels!=null && !Panels.isEmpty()) {%>
		<ul data-role="none" style="padding:0;margin:0">
			<%for(int i=0;i<Panels.size();i++) {
				String[] record = (String[])Panels.get(i);
			%>
			<%-- <div style="display:table-row">
				<div style="display:table-cell;height:40px;vertical-align:middle;padding-left:10px;border-top:1px solid #d0dfee;border-bottom:1px solid #d0dfee"><%=bean.checkForNull( record[1],"")%></div>
			</div>
			<!--  empty row for the 1px gap effect -->
			<div style="display:table-row">
				<div style="display:table-cell;height:1px"></div>
			</div> --%>
				<li class="ORi_item"><%=bean.checkForNull( record[1],"")%></li>
			
			<%}%>
		</ul>
		<%} %>
	</div>
</div>

 
</body>
</html>	
	

