<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------------------------
Date       		Edit History     	Name        Rev.Date  		 Rev.By			Description
-----------------------------------------------------------------------------------------
17/07/2018	  	IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <jsp:useBean id="bean" scope="page" class="eOR.OrderEntryQueryBean"/>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
	<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eOR.Instruction.label" bundle="${or_labels}"/>-<%=bean.checkForNull(request.getParameter("catalog_desc"), "")%></title>
		<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>
	</head>
	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
		<form name="placeOrderForm" id="placeOrderForm">
<%		
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		bean.setLanguageId(localeName);
		String catalog_code 			= bean.checkForNull(request.getParameter("catalog_code"), "");
		String order_catalog_nature		= bean.checkForNull(request.getParameter("order_catalog_nature"), "");
		String measure_id				= bean.checkForNull(request.getParameter("measure_id"), "");
		String contr_msr_panel_id		= bean.checkForNull(request.getParameter("contr_msr_panel_id"), "");
		ArrayList listTemp = null;
		LinkedHashMap<String,ArrayList> Instructions = new LinkedHashMap<String,ArrayList>();
		LinkedHashMap<String,LinkedHashMap<String,ArrayList>> InstructionsForOrderSet  = new LinkedHashMap<String,LinkedHashMap<String,ArrayList>>();
		String key=(request.getParameter("key")==null||request.getParameter("key").equals(""))?"":request.getParameter("key");
		String class_name_first			= "";
		String InsType 					= "T";
		if("A".equalsIgnoreCase(order_catalog_nature)){
			InsType = bean.checkForNull(request.getParameter("prep_instrn_content_type"), "");
			key = catalog_code;
			InstructionsForOrderSet = bean.getInstructions(catalog_code,order_catalog_nature,InsType);
			Instructions			= InstructionsForOrderSet.get(catalog_code);
			if(!Instructions.containsKey("PR")){
				listTemp = new ArrayList();
				listTemp.add(0, "");
				Instructions.put("PR", listTemp);
			}
			if(!Instructions.containsKey("DR")){
				listTemp = new ArrayList();
				listTemp.add(0, "");
				Instructions.put("DR", listTemp);
			}
			if((!Instructions.containsKey("IM")) && (!Instructions.containsKey("IS"))){
				listTemp = new ArrayList();
				listTemp.add(0, "");
				Instructions.put("IS", listTemp);
			}
			ArrayList getInstrnType = new ArrayList();
			getInstrnType	= Instructions.get("InsType");
			InsType = (String)getInstrnType.get(0);
			eOR.OrderEntryQueryBean queryBean = (eOR.OrderEntryQueryBean)getObjectFromBean("instrn","eOR.OrderEntryQueryBean",session);	
		}else if("S".equalsIgnoreCase(order_catalog_nature)||"P".equalsIgnoreCase(order_catalog_nature) ){
			ArrayList<String> catalog_codes = null;
			if("S".equalsIgnoreCase(order_catalog_nature)){
				catalog_codes = bean.getCatalogCodeForOrderset(measure_id);
			}else if("P".equalsIgnoreCase(order_catalog_nature)){
				catalog_codes = bean.getCatalogCodeForPanel(contr_msr_panel_id);
			}
		InstructionsForOrderSet	= bean.getInstructions(catalog_codes,order_catalog_nature);
		Instructions			= InstructionsForOrderSet.get(key);
		if(!Instructions.containsKey("PR")){
			listTemp = new ArrayList();
			listTemp.add(0, "");
			Instructions.put("PR", listTemp);
		}
		if(!Instructions.containsKey("DR")){
			listTemp = new ArrayList();
			listTemp.add(0, "");
			Instructions.put("DR", listTemp);
		}
		if((!Instructions.containsKey("IM")) && (!Instructions.containsKey("IS"))){
			listTemp = new ArrayList();
			listTemp.add(0, "");
			Instructions.put("IS", listTemp);
		}
		ArrayList getInstrnType = new ArrayList();
		getInstrnType	= Instructions.get("InsType");
		InsType = (String)getInstrnType.get(0);
		eOR.OrderEntryQueryBean queryBean = (eOR.OrderEntryQueryBean)getObjectFromBean("instrn","eOR.OrderEntryQueryBean",session);	 
		}%>
		<script>
		var currClass="";
		</script>
		<%
		String showHide = "display:none";
		%>	
		
				
			<%	/**************************************************************************************************************************/		
				if(InsType.equals("E")){
					class_name_first		= "CAFIRSTSELECTHORZ"; 
			%>
				<table width="100%" border="1" cellspacing="0" cellpadding="0" class="grid">
					<tr>
						<td id="PRTAB" width="33%" style='cursor:pointer' class="CASECONDSELECTHORZ <%=class_name_first%>" onClick='sendKeyForEditor("PR");change_common_tab("PRTAB")' onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)" align="center" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('PRTAB')"><fmt:message key="eOR.PreparatoryInstruction.label" bundle="${or_labels}"/></a></td>                   
						<td id="DRTAB" width="33%" style='cursor:pointer' class="<%=class_name_first%>" onClick='sendKeyForEditor("DR");change_common_tab("DRTAB")' onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)" align="center" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('DRTAB')"><fmt:message key="eOR.DepartmentInstruction.label" bundle="${or_labels}"/></a></td>
						<td id="ISTAB" width="33%" style='cursor:pointer' class="<%=class_name_first%>" onClick='sendKeyForEditor("IS");change_common_tab("ISTAB")' onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)" align="center" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('ISTAB')"><fmt:message key="eOR.PatientInstruction.label" bundle="${or_labels}"/></a></td>
					</tr>
				</table>
		
			<table width="100%" border="0" cellspacing="0" cellpadding="0">			
		<%	
			for (String insName : Instructions.keySet()) {
					showHide = "display:none";
					if("PR".equals(insName))
					{
						showHide = "display:inline";
					}
					String instrn = "";
					String multInstrn[] = null;
					ArrayList getInstrnValues = new ArrayList();
					if("PR".equalsIgnoreCase(insName)){
						getInstrnValues=Instructions.get("PR");
						instrn =(String)getInstrnValues.get(0);
					}else if("DR".equalsIgnoreCase(insName)){
						getInstrnValues=Instructions.get("DR");
						instrn =(String)getInstrnValues.get(0);
					}else if("IS".equalsIgnoreCase(insName)){
						getInstrnValues=Instructions.get("IS");
						instrn =(String)getInstrnValues.get(0);
					}else if("IM".equalsIgnoreCase(insName)){
						getInstrnValues = (ArrayList)Instructions.get("IM");
					}
					%>
				<%if(!"IM".equals(insName)){ %>
					<tr id='<%=insName%>' style='<%=showHide%>'>
						<td class="">
							<div class="outer-container" style='width:800px;height:495px'>
	    						<div class="top-section" style='width:800px;height:495px;overflow:auto'>
									<table width='100%' align='center'>
										<tr>											
												<%if("".equals(Instructions.get(insName).get(0)) || "<ADDRESS>&nbsp;</ADDRESS>".equals(Instructions.get(insName).get(0)) ||  "&nbsp;".equals(Instructions.get(insName).get(0))){%><!-- handling pre created ADDRESS tags -->
													<td class="label" width='100%'>APP-000052 No Records Found....</td>
												<%}else{%>
													<td><%=Instructions.get(insName).get(0)%></td>
												<%}%>										
										</tr>
									</table>
								</div>	
							</div>
						</td>
					</tr>
				<%
				}
				else{
					%>
						<%if(getInstrnValues.size()>0){%>
						
					<tr id='<%=insName%>' style='<%=showHide%>'>
						<td class="">							
							<div class="outer-container" style='width:800px;height:75px'>
								<div class="top-section" style='width:800px;height:75px;overflow:auto'>
									<table width='100%' align='center'>
										<tr>
											<td class='COLUMNHEADER'></td>
											<td class='COLUMNHEADER' colspan='3' align='center'><b><----------<fmt:message key="Common.MinAge.label" bundle="${common_labels}"/>----------></b></td>
											<td class='COLUMNHEADER' colspan='3' align='center'><b><----------<fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/>----------></b></td>
											<td class='COLUMNHEADER'></td>
										</tr>
										<tr>
											<td class='CAHIGHER_LEVEL_COLOR' ><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>
											<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
											<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
											<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
											<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
											<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
											<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
											<td  class='CAHIGHER_LEVEL_COLOR'><fmt:message key="eOR.Instrn.label" bundle="${or_labels}"/></td>
										</tr>
									<%for(int i=0; i<getInstrnValues.size(); i++){
										multInstrn = (String[])getInstrnValues.get(i);
										%>
										<tr>
										<%	String instrns="";
										for(int j=1; j<multInstrn.length-1 ; j++){
											instrns=multInstrn[j];
										%>
											<td><%=instrns%></td>
											<%}%><td><a class="image-link" id="<%=i%>"  href='javascript:showMultIns("<%=i%>","<%=key%>","IM")'><b>Instrn</b></a></td>
										</tr>
										<%}%>	
									</table>
									</div>
								</div>
						</td>
					</tr>
					<%}else{%>
						<tr><td class='label'>APP-000052 No Records Found....</td></tr>
					<%}%>	
				<%}%>
			<%}
	}else if(InsType.equals("T")){
		class_name_first		= "CAFIRSTSELECTHORZ"; 
%>
			<table width="100%" border="1" cellspacing="0" cellpadding="0" class="grid">
					<tr>
						<td id="PRTAB" width="33%" style='cursor:pointer' class="CASECONDSELECTHORZ <%=class_name_first%>" onClick='sendKeyForEditor("PR");change_common_tab("PRTAB")' onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)" align="center" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('PRTAB')"><fmt:message key="eOR.PreparatoryInstruction.label" bundle="${or_labels}"/></a></td>                   
						<td id="DRTAB" width="33%" style='cursor:pointer' class="<%=class_name_first%>" onClick='sendKeyForEditor("DR");change_common_tab("DRTAB")' onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)" align="center" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('DRTAB')"><fmt:message key="eOR.DepartmentInstruction.label" bundle="${or_labels}"/></a></td>
						<td id="ISTAB" width="33%" style='cursor:pointer' class="<%=class_name_first%>" onClick='sendKeyForEditor("IS");change_common_tab("ISTAB")' onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)" align="center" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('ISTAB')"><fmt:message key="eOR.PatientInstruction.label" bundle="${or_labels}"/></a></td>
					</tr>
			</table>	
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<%	
				for (String insName : Instructions.keySet()) {
						showHide = "display:none";
						if("PR".equals(insName))
						{
							showHide = "display:inline";
						}
						String instrn = "";
						String multInstrn[] = null;
						ArrayList getInstrnValues = new ArrayList();
						if("PR".equalsIgnoreCase(insName)){
							getInstrnValues=Instructions.get("PR");
							if(getInstrnValues.size()>0)
							instrn =(String)getInstrnValues.get(0);
						}else if("DR".equalsIgnoreCase(insName)){
							getInstrnValues=Instructions.get("DR");
							if(getInstrnValues.size()>0)
							instrn =(String)getInstrnValues.get(0);
						}else if("IS".equalsIgnoreCase(insName)){
							getInstrnValues=Instructions.get("IS");
							if(getInstrnValues.size()>0)
							instrn =(String)getInstrnValues.get(0);
						}else if("IM".equalsIgnoreCase(insName)){
							getInstrnValues = (ArrayList)Instructions.get("IM");
						}
						%>
					<%if(!"IM".equals(insName)){ %>
					<tr id='<%=insName%>' style='<%=showHide%>'>
						<td class="">
							<div class="outer-container" style='width:800px;height:495px'>
		    					<div class="top-section" style='width:800px;height:495px;overflow:auto'>
		    						<table width='100%' align='center'>
										<tr>
											<%if("".equals(instrn)){%>
												<td class="label" colspan="3" width='100%'>APP-000052 No Records Found....</td>
											<%}else{%>
												<td class="" colspan="3" width='100%'><%=instrn%></td>
											<%}%>
										</tr>
									</table>
								</div>		
							</div>	
						</td>
					</tr>	
					<%}else{
						%><tr id='<%=insName%>' style='<%=showHide%>'>
						<%if(getInstrnValues.size()>0){%>
							<td class="">							
								<div class="outer-container" style='width:800px;height:75px'>
	    						<div class="top-section" style='width:800px;height:75px;overflow:auto'>
									<table width='100%' align='center'>
										<tr>
											<td class='COLUMNHEADER'>&nbsp;</td>
											<td class='COLUMNHEADER' colspan='3' align='center'><b><----------<fmt:message key="Common.MinAge.label" bundle="${common_labels}"/>----------></b></th>
											<td class='COLUMNHEADER' colspan='3' align='center'><b><----------<fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/>----------></b></th>
											<td class='COLUMNHEADER'>&nbsp;</td>
										</tr>
										<tr>
												<td class='CAHIGHER_LEVEL_COLOR' ><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>
												<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
												<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
												<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
												<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
												<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
												<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
												<td class='CAHIGHER_LEVEL_COLOR'>&nbsp;</td>
										</tr>
							<%for(int i=0; i<getInstrnValues.size(); i++){
								multInstrn = (String[])getInstrnValues.get(i);
								%>
										<tr>
											<% String instrns="";
											for(int j=1; j<multInstrn.length-1 ; j++){
												instrns=multInstrn[j];
											%>
												<td><%=instrns%></td>
												<%}%>
												<td>
													<a id="<%=i%>" class="image-link" href='javascript:showMultIns("<%=i%>","<%=key%>","IM")'><b>Instrn</b></a>
												</td>
										</tr>
											<%}%>	
									</table>
								</div>
							</div>	
						</td>
				</tr>	
										<%}else{%>
										<tr><td class='label'>APP-000052 No Records Found....</td></tr>
										<%}%>
							<%
						}%>
					<%}
				}	
				%>	
			</table>
				<%for (String insName : Instructions.keySet()) { 
					if("IM".equals(insName)){ %>
			
				<iframe class='' id="ageSexInstrnFrame" FRAMEBORDER=NO src='../../eCommon/html/blank.html' width="100%" height="0px" onKeyPress=''>
				</iframe>
				<%}
					}%>
				<table cellpadding=3 cellspacing=0 border=0 align=center width='100%'>
					<tr><td class='button' colspan='2' align='right'><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'></td></tr>
				</table>	
</form>
</body>
</html>
<%
		putObjectInBean("instrn",bean,request); 
%>

