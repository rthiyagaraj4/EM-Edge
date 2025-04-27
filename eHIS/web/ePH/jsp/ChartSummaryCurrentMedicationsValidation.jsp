
<%--saved on 27th Oct 2005 --%>
<%@page  import="java.util.*, ePH.Common.*, ePH.*, eOR.*" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	try {
		String identity			= request.getParameter("identity")==null?"":request.getParameter("identity");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String patient_id				= (String) hash.get( "patient_id" );
		String encounter_id			= (String) hash.get( "encounter_id" );
		String or_bean_name				= "eOR.OrderEntryBean";
		String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name,request ) ;
		if(identity.equals("setSelectedRenewOrder")){ 
			String selected_yn	= (String) hash.get( "selected_yn" );
			String orderIdDtl	= (String) hash.get( "orderIdDtl" );
			String drug_code	= (String) hash.get( "drug_code" );
			HashMap hmRenewOrders = orbean.getRenewOrderIds();
			if(hmRenewOrders==null)
				hmRenewOrders = new HashMap();
			if(selected_yn.equals("Y")){
				hmRenewOrders.put(drug_code, orderIdDtl);
			}
			else
				hmRenewOrders.remove(drug_code);
			orbean.setRenewOrderIds(hmRenewOrders);
		}
		putObjectInBean(or_bean_id,orbean,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>
