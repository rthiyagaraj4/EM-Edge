<!DOCTYPE html>

<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<HTML>
	<head> 
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String sql_ph_generic_name_lookup=PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_SELECT_LOOKUP");
		String sql_ph_drug_lookup=PhRepository.getPhKeyValue("SQL_PH_DRUG_ORDER_CAT_NOT_LINK_SELECT1");
		String sql_ds_foodItem_lookup=PhRepository.getPhKeyValue("SQL_DS_INGREDIENT_DETAILS"); //IN070606
		String sql_lb_labOrderCatalog_lookup=PhRepository.getPhKeyValue("SQL_OR_LABORDERCATALOG_DETAILS"); //IN070606
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugAbuse.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="CodeArrest();" onKeyDown="lockKey()" onLoad="restrictionTypeValidate()"  topmargin="0">
<%

		String mode			= request.getParameter("mode");
		/*String bean_id		= "@DrugInteractionBean" ;
		String bean_name	= "ePH.DrugInteractionBean";
		

		DrugInteractionBean bean = (DrugInteractionBean)getBeanObject( bean_id,bean_name,request) ;
		bean.clear();
		bean.setLanguageId(locale);
		bean.setMode( mode ) ;
		String facility_id					= (String) session.getValue("facility_id");*/
%>
		<form name='formDrugAbuseCriteria' id='formDrugAbuseCriteria' method='post' action='DrugAbuseQueryResult.jsp' onsubmit='SelectAll()'>
			<table cellpadding=0 cellspacing=0 width="97%" align="center" border="0">
				<TR>
					  <TH  ALIGN="Left" COLSPAN="10" width='20%'> <fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/>    </TH>
				</TR>
				<tr>
					<td align="right" class="label" width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" width='20%'><input type="text" name="p_patient_id" id="p_patient_id" size="20" value="" maxlength="25"   > <input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch(document.formDrugAbuseCriteria)"  >
					</td>
					<td align="left" class="label" colspan="2"></td>
				</tr>
				<tr>
					<td align="right" class="label" width='10%'>
						<fmt:message key="ePH.RestrictionType.label" bundle="${ph_labels}"/>						
					</td>
					<td ALIGN="left"  class="label" ><select name="p_restriction_type" id="p_restriction_type" onChange="restrictionType(this);" >
							<option value="DC" selected><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></option>
							<option value="DN"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td class="label" ALIGN="right" nowrap >
						<DIV id='drug_class' ><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/>	
							<select name="p_drug_class" id="p_drug_class" id='drug_class_dtl' >
							<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
							<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
							<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
							</select>
						</DIV>
						<DIV id='drug_name_id' style="visibility:hidden"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/> 
						<!-- <input type='text'  name='drug_name' id='drug_name' size="60" maxlength="60" onblur="callDrugSearch(document.formDrugAbuseCriteria.drug_name)">
						<input valign='top' type='button' name='drug_search' id='drug_search' id='drug_search_id' value='?' class='button'  onClick="callDrugSearch(document.formDrugAbuseCriteria.drug_name)"  style="visibility:hidden">
						 -->
						 
					<input type="text" name="drug_name" id="drug_name" maxlength="60" size="40"  value="" onBlur="searchDrug(document.formDrugAbuseCriteria.drug_name)">
					<input type="button" class="button"	value="?" id='drug_search_id' name='drug_search' id='drug_search' 	onClick="searchDrug(document.formDrugAbuseCriteria.drug_name)" >
 
					 <input type="hidden" name="drug_code" id="drug_code" value="">  
	
						 </DIV>
					</TD>
				</tr>
		<tr align="right" class="label" width='10%' >
			<td align="right" class="label" width='10%'>
				<fmt:message key="Common.action.label" bundle="${common_labels}"/>						
			</td>
			<td ALIGN="left" width="20%"  class="label" colspan='3'><select name="p_action_type" id="p_action_type" >

				<option value="%" selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
				<option value="B"><fmt:message key="Common.block.label" bundle="${common_labels}"/></option>
				<option value="U"><fmt:message key="ePH.Unblock.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
			<td align="left" class="label" colspan="2"></td>
		</tr>

			<TR><td  ALIGN="Center" COLSPAN="4"> &nbsp;</td></TR>
				<TR><td  ALIGN="Center" COLSPAN="4"> 
					<table width='100%' align='center' >
						<tr>
							<th align='left' >
							<fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/> </th>
						</tr>
						<tr>
							<td width='60%' > 
							<table width='100%'align='center' >
								<tr>
									<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
									<td>&nbsp;</td>
									<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
								</tr>
								<tr>
									<td width='45%' align='center'>
									<select name='orderbycols' id='orderbycols' size='8' >
										<option value='restriction_type'><fmt:message key="ePH.RestrictionType.label" bundle="${ph_labels}"/></option>
										<option value='action_type_flag'><fmt:message key="Common.action.label" bundle="${common_labels}"/></option>	
									 </select>
									</td>
									<td align='center' width='3%' >
										<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
										<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
									</td>
									<td width='45%' align='center'>
										<select name='orderbycolumns' id='orderbycolumns' size='8' multiple='true'>
											<option value='patient_id'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
										</select>
									</td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			
			<br>
			<table border='0' width='100%' align='center'><tr><td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick="execQuery()" value="Execute" ></td></tr>
			</table>
 
	 
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="p_drug_code" id="p_drug_code" value="">
			<input type="hidden" name="sql_ph_generic_name_lookup" id="sql_ph_generic_name_lookup" value="">
			<input type="hidden" name="sql_ph_drug_lookup" id="sql_ph_drug_lookup" value="">
			<input type="hidden" name="sql_ds_foodItem_lookup" id="sql_ds_foodItem_lookup" value="">  
			<input type="hidden" name="sql_lb_labOrderCatalog_lookup" id="sql_lb_labOrderCatalog_lookup" value="">  
		</form>
	</body>
</HTML>

