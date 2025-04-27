<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------
Date       		Edit History     	Name        Rev.Date  	 Rev.By		Description
-----------------------------------------------------------------------
17/07/2018	  	IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
-----------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <jsp:useBean id="bean" scope="page" class="eOR.OrderEntryQueryBean"/>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="CommonBean" class="eCommon.Common.CommonBean" scope="page" />
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<title><fmt:message key="eOR.Instruction.label" bundle="${or_labels}"/>-<%=bean.checkForNull(request.getParameter("catalog_desc"), "")%></title>
	</head>
	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
		<form name="placeOrderForm" id="placeOrderForm">
<%		
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String bean_id 					= request.getParameter("bean_id");
		String bean_name 				= request.getParameter("bean_name");
		bean.setLanguageId(localeName);
		Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
		String facility_id				= (String)session.getValue("facility_id");
		String measure_id 				= bean.checkForNull(request.getParameter("measure_id"), "");
		String catalog_code 				= bean.checkForNull(request.getParameter("catalog_code"), ""); 
		String order_catalog_nature		= bean.checkForNull(request.getParameter("order_catalog_nature"), "");
		String contr_msr_panel_id		= bean.checkForNull(request.getParameter("contr_msr_panel_id"), "");
		String category					= bean.checkForNull(request.getParameter("category"), "");	
		String encounter_id				= bean.checkForNull(request.getParameter("encounter_id"), "");	
		String patient_class			= bean.checkForNull(request.getParameter("patient_class"), "");	
		String admission_date			= bean.checkForNull(request.getParameter("admission_date"), "");	
		String discharge_date_time		= bean.checkForNull(request.getParameter("discharge_date_time"), "");	
		String pract_type		        = bean.checkForNull(request.getParameter("pract_type"), "");
		/* HashMap<String,String> Instructions = new HashMap<String,String>();
		HashMap<String,HashMap<String,String>> InstructionsForOrderSet  = new HashMap<String,HashMap<String,String>>(); *///commented for checkstyle
		ArrayList Panels				= bean.getPanelItems(properties, measure_id,order_catalog_nature,contr_msr_panel_id,category, facility_id,encounter_id,patient_class,admission_date,discharge_date_time,catalog_code,pract_type);// IN042045 included pract_type
		String key = "";
		String classValue				= "";
		LinkedHashMap<String,ArrayList<String>> mapCatcodeAndMsrpanelid= new LinkedHashMap<String,ArrayList<String>>();
		LinkedHashMap<String,ArrayList<String>> mapCatcodeAndMsrId= new LinkedHashMap<String,ArrayList<String>>();
		int cnt=0;
		if("P".equals(order_catalog_nature)){
			mapCatcodeAndMsrpanelid 	= bean.getCatalogCodeForMsrpanelid(contr_msr_panel_id);
		}else if("S".equals(order_catalog_nature)){
			mapCatcodeAndMsrId 	= bean.getCatalogCodeForMsrId(measure_id);
		}
		if(Panels!=null && Panels.size() == 0){  
		%><script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
				window.close();
			</script>
<%		}
%>	
		<table width="100%" border="1" cellspacing="0" cellpadding="0" class="grid">
<%
	if(!order_catalog_nature.equalsIgnoreCase("P") && !order_catalog_nature.equalsIgnoreCase("S")){
			if(Panels!=null && Panels.size() != 0)
			{  
				for(int k=0; k<Panels.size(); k++)
		   		{
					classValue="gridData";
		   			String[] record = (String[])Panels.get(k);
		   			System.out.println("Panels-->"+record[0]);
		   			
%>					<tr>
						<td class="CAFIRSTSELECTHORZ" onClick='sendKey("<%=bean.checkForNull( record[0],"")%>","<%=request.getQueryString()%>")' ><a class='gridLink' href='javascript:;'><%=bean.checkForNull( record[1],"")%></a></td>
					</tr>
<%				}
				
				
				String[] keygetter = new String[1];
				ArrayList keyForPanel = null;
				if("P".equals(order_catalog_nature)){
					keygetter=(String[])Panels.get(0);
					keyForPanel = mapCatcodeAndMsrpanelid.get(bean.checkForNull( keygetter[0],""));
					key = (String)keyForPanel.get(0); 
				}
			}	
			if(Panels!=null) {
				Panels.clear();  Panels = null;
			}
			
	}		
	/****************************************************************************************
	******PANEL AREA START
	*****************************************************************************************/
	if("P".equalsIgnoreCase(order_catalog_nature)){		
			if(mapCatcodeAndMsrpanelid!=null && mapCatcodeAndMsrpanelid.size() == 0){  
		%><script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
				window.close();
			</script>
<%		}
%>	
		<table width="100%" border="1" cellspacing="0" cellpadding="0" class="grid">
<%
			if(mapCatcodeAndMsrpanelid!=null && mapCatcodeAndMsrpanelid.size() != 0)
			{  
				 			
					classValue="gridData";
		   			ArrayList record = new ArrayList();
		   			for (String keys : mapCatcodeAndMsrpanelid.keySet()) {
		   				record = mapCatcodeAndMsrpanelid.get(keys);
%>					<tr>
						<td style='cursor:pointer' id="catPanel<%=cnt%>" onClick='toggleTabColorForPanel("<%=cnt%>");sendKey("<%=bean.checkForNull( (String)record.get(0),"")%>","<%=request.getQueryString()%>")' <%if(cnt==0){%>class='CASECONDSELECTHORZ' <%}else{%>class='CAFIRSTSELECTHORZ'<%} %>); onMouseOver="leftpaneMouseOver(this)" onmouseout="leftpaneMouseOut(this)"><a style='color:white;cursor:pointer' href='#'><%=bean.checkForNull( (String)record.get(1),"")%></a></td>
					</tr>
<%					cnt++;
}
				ArrayList keyForPanel = null;
				for (String keys : mapCatcodeAndMsrpanelid.keySet()) {
					keyForPanel = mapCatcodeAndMsrpanelid.get(keys);
					key = (String)keyForPanel.get(0);
					break;
				}
			}	
			if(mapCatcodeAndMsrpanelid!=null) {
				mapCatcodeAndMsrpanelid.clear();  mapCatcodeAndMsrpanelid = null;
			}
	}	
	/****************************************************************************************
	******ORDERSET AREA START
	*****************************************************************************************/
	if("S".equalsIgnoreCase(order_catalog_nature)){		
			if(mapCatcodeAndMsrId!=null && mapCatcodeAndMsrId.size() == 0){  
		%><script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
				window.close();
			</script>
<%		}
%>	
		<table width="100%" border="1" cellspacing="0" cellpadding="0" class="grid">
<%
			if(mapCatcodeAndMsrId!=null && mapCatcodeAndMsrId.size() != 0)
			{  
				 			
					classValue="gridData";
		   			ArrayList record = new ArrayList();
		   			for (String keys : mapCatcodeAndMsrId.keySet()) {
		   				record = mapCatcodeAndMsrId.get(keys);
%>					<tr >
						<td id="cat<%=cnt%>" style='cursor:pointer' onClick='toggleTabColor("<%=cnt%>");sendKey("<%=bean.checkForNull( keys,"")%>","<%=request.getQueryString()%>");' <%if(cnt==0){%>class='CASECONDSELECTHORZ' <%}else{%>class='CAFIRSTSELECTHORZ'<%} %>); onMouseOver="leftpaneMouseOver(this)" onmouseout="leftpaneMouseOut(this)"><a style='color:white;cursor:pointer' href='#'><%=bean.checkForNull( (String)record.get(0),"")%></a></td>
					</tr>
<%					cnt++;


	}
				//ArrayList keyForPanel = null;//commented for checkstyle
				for (String keys : mapCatcodeAndMsrId.keySet()) {
					key = keys;
					break;
				}
			}	
			if(mapCatcodeAndMsrpanelid!=null) {
				mapCatcodeAndMsrpanelid.clear();  mapCatcodeAndMsrpanelid = null;
			}
	}		
%>
		</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
			<input type="hidden" name="totalCount" id="totalCount" value="<%=cnt%>">

		</form>
		<script language='javascript'>	
			<%if(!key.equals("")||key!=null){%>
				parent.InstrnFrame.location.href = "../../eOR/jsp/OrderEntryInstruction.jsp?<%=request.getQueryString()%>&key=<%=key%>"; 
			<%}%>
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</body>
</html>

