<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/DrugMaster.js"></script>
		<script language="javascript" src="../../ePH/js/DrugMasterDetail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function tab_click1(id){
				selectTab(id);	
				showTabDetail(id);
			}
		</script>
	</HEAD>
	<body  onKeyDown="lockKey()"  onMouseDown = 'CodeArrest()' >
		<form name="drugMasterTitleForm" id="drugMasterTitleForm">
<%
			//Check the version
			String licenceRights = PhLicenceRights.getKey();
			String link		=	request.getParameter("link")==null?"":request.getParameter("link");
			String item_code		= request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" );
			String form_code		= request.getParameter( "form_code" )==null?"":request.getParameter( "form_code" );
			String generic_id		= request.getParameter( "generic_id" )==null?"":request.getParameter( "generic_id" );

			if(link.equals("inventory_tab")){
%>
				<script>
					parent.adjustFrames('<%=link%>');
				</script>
				<table cellpadding="0" cellspacing="0" width="99%"  border="1">
					<tr>
						<th  width="35%"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
						<th  width="25%"><fmt:message key="ePH.StockingUnit.label" bundle="${ph_labels}"/></th>
						<th  width="25%"><fmt:message key="ePH.PackSize/Unit.label" bundle="${ph_labels}"/></th>
						<th  width="15%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					</tr>
				</table>
<%	
			}	
			else if(link.equals("trade_tab")){
%>
				<script>
					parent.adjustFrames('<%=link%>')
				</script>
				<table cellpadding="0" cellspacing="0" width="99%"  border="1">
					<tr>
					<th  width="30%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
					<th  width="5%">&nbsp;&nbsp;</th>
					<th  width="35%"><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></th>
					<th  width="15%"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></th>
					<th  width="15%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					</tr>
				</table>
<%	
			}
			else if(link.equals("weightrecording_tab"))	{	
%>
				<script>
					parent.adjustFrames('<%=link%>')
				</script>
				<table cellpadding="0" cellspacing="0" width="99%"  border="1">
					<tr>
						<th   width="20%" rowspan='2'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></th>
						<th  width="10%" rowspan='2'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
						<th  width="8%" rowspan='2'><fmt:message key="Common.MinAge.label" bundle="${common_labels}"/></th>
						<th  width="8%" rowspan='2'><fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/></th>
						<th  width="10%" rowspan='2'><fmt:message key="Common.AgeUnit.label" bundle="${common_labels}"/></th>
						<th  width="10%" rowspan='2'><fmt:message key="ePH.DrugApplicable.label" bundle="${ph_labels}"/></th>
						<th  width="16%" colspan='2'><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th>
						<th  width="10%" rowspan='2'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					</tr>
					<tr >
						<th  width="8%"><fmt:message key="Common.weight.label" bundle="${common_labels}"/></th>
						<th  width="8%"><fmt:message key="Common.height.label" bundle="${common_labels}"/></th>
					</tr>
				</table>
<%	
			}
			else if(link.equals("generic_tab"))	{
%>
				<script>
					parent.adjustFrames('<%=link%>')
				</script>
				<table cellpadding="0" cellspacing="0" width="99%"  border="1">
					<tr>
					<th	 width="20%"><fmt:message key="ePH.GenericID.label" bundle="${ph_labels}"/></th>
					<th	 width="40%" ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
					<th	 width="15%"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></th>
					<th	 width="15%"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></th>
					<th	 width="10%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					</tr>
				</table>
<%	
			}
			else if(link.equals("dosage_tab")) {  
%>
				<table border="0" width="100%" cellspacing="0" cellpadding="0">
					<tr>
						<!-- <td  id="" class="white" width="10%">
						<img src="../../ePH/images/PrescribingDetails.gif" onClick="javascript:parent.showTabDetail(document.getElementById("prescribing_det"))" id="prescribing_det" onMouseOver="style.cursor='hand'">
						</td> -->
						<td width= "100%" class="white">
							<ul id="tablist" class="tablist" style='padding-left:0px'>
								<li class="tablistitem" title='<fmt:message key="ePH.PrescribingDetails.label" bundle="${ph_labels}"/>'>
									<a onclick="tab_click1('prescribingdet_tab')" class="tabClicked" id="prescribingdet_tab" >
										<span class="tabSpanclicked" id="prescribingdet_tabspan"><fmt:message key="ePH.PrescribingDetails.label" bundle="${ph_labels}"/></span>
									</a>
								</li>
<%
								if (!licenceRights.equals("PHBASIC")){
%>
									<li class="tablistitem" title='<fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/>'>
										<a onclick="tab_click1('dispensingdet_tab')" class="tabA" id="dispensingdet_tab" >
											<span class="tabAspan" id="dispensingdet_tabspan"><fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></span>
										</a>
									</li>
<%
								}
%>
								<li class="tablistitem" title='<fmt:message key="ePH.IVCharacteristics.label" bundle="${ph_labels}"/>'>
									<a onclick="tab_click1('ivchar_tab')" class="tabA" id="ivchar_tab" >
										<span class="tabAspan" id="ivchar_tabspan"><fmt:message key="ePH.IVCharacteristics.label" bundle="${ph_labels}"/></span>
									</a>
								</li>
							</ul>
							<script>prevTabObj='prescribingdet_tab'</script>
							<!-- <%
									if (!licenceRights.equals("PHBASIC")){
							%>
								 -->	<!-- <td  id="" class="white" width="10%">
									<img src="../../ePH/images/Dispensing Rules.gif" onClick="javascript:parent.showTabDetail(document.getElementById("dispensing_det"))" id="dispensing_det" onMouseOver="style.cursor='hand'">
									</td> -->
							<!-- <%
									}
							%> -->
									<!-- <td  id="" class="white" width="10%">
									<img src="../../ePH/images/IV Characteristics.gif" onClick="javascript:parent.showTabDetail(document.getElementById("iv_char"))" id="iv_char" onMouseOver="style.cursor='hand'"> -->
						</td>
					</tr>
				</table>

				<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
				<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
				<input type="hidden" name="generic_id" id="generic_id" value="<%=generic_id%>">
				<script>
					parent.updateCurrentForm("<%=link%>","dummy","parent.frames[0].document.drugMasterMainForm");
					//parent.showTabDetail("prescribingdet_tab");
					prescribingdet_tab.click();
				</script>
<%	
			}
%>
		</form>
	</body>
</html>

