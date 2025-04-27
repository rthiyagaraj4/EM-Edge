<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.orderentry.request.MOrderCatalogsSearchRequest"%>
<%@page import="eIPAD.chartsummary.orderentry.healthobject.MOrderCatalogHO"%>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eIPAD.chartsummary.orderentry.bc.MOrderEntryBC"%>
<%@page import="eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
MOrderCatalogListResponse searchResponse = null;
String orderNature = "";
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
	String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
	String or_bean_name = "eOR.OrderEntryBean";
	OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
	String searchMode = request.getParameter("SearchMode") == null?"":request.getParameter("SearchMode");
	//Tick Sheet Search
	if(searchMode.equals("T")){
		String tickSheetId = request.getParameter("TickSheetId") == null?"":request.getParameter("TickSheetId");
		String sectionCode = request.getParameter("SectionCode") == null?"":request.getParameter("SectionCode");
		orderNature = request.getParameter("OrderNature") == null?"":request.getParameter("OrderNature");
		MOrderCatalogsTickSearchRequest tickSearchRequest = new MOrderCatalogsTickSearchRequest();
		tickSearchRequest.setPatientContext(patientContext);
		tickSearchRequest.setOrderEntryBean(bean);
		tickSearchRequest.setTickSheetId(tickSheetId);
		tickSearchRequest.setSectionCode(sectionCode);
		tickSearchRequest.setOrderNature(orderNature);
		MOrderEntryBC bc = new MOrderEntryBC();
		searchResponse =  bc.getTickSheetOrders(tickSearchRequest, true);
	} 
	//Additional Search
	else if(searchMode.equals("A")){
		String orderCategory = request.getParameter("OrderCategory") == null?"":request.getParameter("OrderCategory");
		String orderType = request.getParameter("OrderType") == null?"":request.getParameter("OrderType");
		String searchText = request.getParameter("SearchText") == null?"":request.getParameter("SearchText");
		orderNature = request.getParameter("OrderNature") == null?"":request.getParameter("OrderNature");
		MOrderCatalogsSearchRequest addlSearchRequest = new MOrderCatalogsSearchRequest();
		addlSearchRequest.setPatientContext(patientContext);
		addlSearchRequest.setOrderEntryBean(bean);
		addlSearchRequest.setOrderCategory(orderCategory);
		addlSearchRequest.setOrderType(orderType);
		addlSearchRequest.setSearchText(searchText);
		addlSearchRequest.setOrderNature(orderNature);
		MOrderEntryBC bc = new MOrderEntryBC();
		searchResponse =  bc.getOrdersBySearch(addlSearchRequest, true);
	}
}


%>
<script>
/* $(document).ready(function(){
	
	$(".ontapimg").on("tap",function(){
		  $(this).hide();
		});
}); */
</script>

<div id="OrdListHWrapper_<%=orderNature %>" class="ordListHWrapper"  style="position:relative">
	<div class="ordListcontainer ordItemscroller" id="OrdItemscroller_<%=orderNature %>">
		<ul id="OrdListColWrap_<%=orderNature %>" class="ordListColWrap">
		<%
		if(searchResponse!=null && searchResponse.isSuccessResponse() && !searchResponse.isEmptyDataResponse()){
			ArrayList<MOrderCatalogHO> ordersList = searchResponse.getOrderCatalogList();
			if(ordersList!=null && !ordersList.isEmpty()){
				for(int i=0;i<ordersList.size();i++){
					MOrderCatalogHO orderItem = ordersList.get(i);
					if(orderItem!=null){
		%>
			
				<li>
					<%
					String orderCategoryCode = orderItem.getCatalogNature().equals("S")?"CS":orderItem.getOrderCategory();
					%>
					<div class="ordDraggable ordItemBoxTheme ordDraggable_<%=orderNature %>" data-ordercatalogcode="<%=orderItem.getOrderCatalogCode()%>" data-ordertypecode="<%=orderItem.getOrderTypeCode()%>" data-ordercategorycode="<%=orderCategoryCode%>">
						<div class="ordItemBtnIcon">
							<div class="ordItemLeftBlock">  <%-- onclick="selectOrder('<%=orderItem.getOrderCatalogCode()%>','<%=orderItem.getOrderTypeCode()%>','<%=orderCategoryCode%>')" --%>
								<div class="ordItemText">
								<%=orderItem.getCatalogSynonym()%>
								</div>
							</div>
							<%if(!orderItem.getCatalogNature().equals("A")) {%>
							<div class="ordItemRightBlock"  onclick="openPanelOrderSetContents('<%=orderItem.getOrderCatalogCode()%>','<%=orderItem.getCatalogNature()%>','<%=orderItem.getContrMsrPanelId()%>','<%=orderItem.getOrderCategory()%>','<%=orderItem.getOrderCatalogCode()%>','<%=orderItem.getCatalogSynonym()%>')"><img src="${path}/eIPAD/images/Drop_Arrow.png" width="28" height="44" class="ontapimg"></div>
							<%}%>
							<div class="ordItemRightBlock ordItemDragBtn"><img src="${path}/eIPAD/images/Drop_icon.PNG" width="3" height="17"></div>
						</div>
					</div>
				</li>
			
				<%
						}
					}
				}%>
				</ul>
			
			<%	} else{%>
			<div> Orders could not be got due to some error</div>
	<% 	}
	%>
	
	</div>
</div>

	
