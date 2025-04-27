<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/11/2019	IN070606		Ramesh Goli											MMS-KH-CRF-0029	
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<HTML>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

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
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugInteraction.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="CodeArrest();" onKeyDown="lockKey()" topmargin="0">
<%
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id		= "@DrugInteractionBean" ;
		String bean_name	= "ePH.DrugInteractionBean";
		String mode			= request.getParameter("mode");

		DrugInteractionBean bean = (DrugInteractionBean)getBeanObject( bean_id,bean_name,request) ;
		bean.clear();
		bean.setLanguageId(locale);
		bean.setMode( mode ) ;
		String facility_id					= (String) session.getValue("facility_id");
		
		String term_desc="",term_code ="",term_set_code="";//Adding start for MMS-DM-CRF-0229
		ArrayList termlist=new ArrayList(); 
        HashMap termlistvalues=new HashMap();
		termlist=bean.getTermList();//Adding end for MMS-DM-CRF-0229
		String intr_option_type="D"; 
%>
		<form name='query_form' id='query_form' method='post' action='DrugInteractionQueryResult.jsp' onsubmit='SelectAll()'>
			<table cellpadding=0 cellspacing=0 width="98%" align="center" border="0">
				<TR>
					<td  ALIGN="Center" COLSPAN="4"> &nbsp;    </td>
				</TR>
				<TR>
					  <TH  ALIGN="Left" COLSPAN="10" width='20%'> <fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/>    </TH>
				</TR>
				<TR><td  ALIGN="Center" COLSPAN="4"> &nbsp;</td></TR>
				<!-- IN070606 Start.-->
				<tr>
					<td align="right" class="label" width='10%'>
						<fmt:message key="ePH.Interaction.label" bundle="${ph_labels}"/> &nbsp; Type						
					</td>
					<td align="left" class="label" colspan='3'>
						<select name="InteractionType" id="InteractionType" id="InteractionType" style="width: 125px;" onChange="onChangeInteractionType1(this);" >
							<option value='D'><fmt:message key="ePH.DrugtoDrug.label" bundle="${ph_labels}"/></option>
							<option value='L' ><fmt:message key="ePH.DrugtoLabaratory.label" bundle="${ph_labels}"/></option>
							<option value='F' ><fmt:message key="ePH.DrugtoFood.label" bundle="${ph_labels}"/></option>
							<option value='I' ><fmt:message key="ePH.DrugDisease.label" bundle="${ph_labels}"/></option><!-- Added for MMS-DM-CRF-0229 -->
						</select>
					</td>
				</tr>
				<!--IN070606 End.-->
				<tr>
					<td align="right" class="label" width='10%' >
						<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>
						<fmt:message key="ePH.By.label" bundle="${ph_labels}"/>
					</td>
					<td align="left" class="label"  colspan='1'>  <!-- colspan='3' modified for term_set -->
						<select name="InteractionBy" id="InteractionBy" style="width: 125px;" onChange="onChangeIntrByQuery();">
						<option value='G'selected><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></option>
						<option value='D'><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td  class="label" id="term_set" style="visibility:hidden;"><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
                         <td >&nbsp;
                           <select name="TermSetList" id="TermSetList" id="TermSetList"  style="visibility:hidden;" >
			                   <option value="" >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<%                                  for(int i=0; i<termlist.size(); i++)
				                     {
					                      termlistvalues = (HashMap)termlist.get(i);
					                      term_code = (String)termlistvalues.get("code");
                                          term_desc = (String)termlistvalues.get("desc");
                                 String term_selct ="";
								  if(term_set_code.equals(term_code)){
									  term_selct ="selected";
								  }
%>
                                <OPTION value="<%=term_code%>" <%=term_selct%> ><%=term_desc%></OPTION>
<%			
}
%>
			             </select>
			                <img name='term_mandatory' id='term_mandatory' style="visibility:hidden;" src="../../eCommon/images/mandatory.gif">
                        </td>
					
				</tr>
				<tr>	
					<td class="label" WIDTH="10%" > <label id='lblIntName1'>
						<fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></label>1
					</td>
					<td class="label"   WIDTH="30%">
						<input type='text' name='intr_name1' id='intr_name1' value='' size='60' onBlur="searchCode2( intr_name1,intr_code1,'<%=mode%>','1' );">
						<input type="button" name="btnintr_name1" id="btnintr_name1"  value="?" class="button"  onClick="searchCode( intr_name1,intr_code1,'<%=mode%>','1' );">
						<input type="hidden" name="intr_code1" id="intr_code1" value="" >			
					</td>
					<td class="label" WIDTH="10%" id="lblIntNametd" > <label id='lblIntName2'>
						<fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></label>2
					</td>
					<td class="label"  WIDTH="30%" > 
						<input type='text' name='intr_name2' id='intr_name2' value='' size='60' onBlur="searchCode2( intr_name2,intr_code2,'<%=mode%>','2' );">
						<input type="button" name="btnIntrName2" id="btnIntrName2"  value="?" class="button" onClick="searchCode( intr_name2,intr_code2,'<%=mode%>','2' );">
						<input type="hidden" name="intr_code2" id="intr_code2" value="" >		
					</td>
				</tr>
				<tr> 
					<td  class="label" >
						<fmt:message key="ePH.SeverityLevel.label" bundle="${ph_labels}"/>
					</td>
					<td class="label" >
						<select name="Severity_Level" id="Severity_Level" onChange="">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='H'><fmt:message key="ePH.Major.label" bundle="${ph_labels}"/></option>
						<option value='M'><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
						<option value='L'><fmt:message key="ePH.Minor.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
					<td align="right" class="label" >
						<fmt:message key="ePH.SignificantLevel.label" bundle="${ph_labels}"/>	
					</td>
					<td class="label">
						<select name="Significant_level" id="Significant_level" >
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='1'>1</option>
						<option value='2'>2</option>
						<option value='3'>3</option>
						<option value='4'>4</option>
						<option value='5'>5</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right" class="label"  name="Probability">
						<fmt:message key="ePH.documentation.label" bundle="${ph_labels}"/>	<!-- probability modified as documentation for FD-RUT-CRF-0066.1 [IN036975]   -->
					</td>
					<td class="label">
						<select name="Probability" id="Probability" onChange="">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<!-- <option value='D'><fmt:message key="Common.Definitive.label" bundle="${common_labels}"/></option>  Commented and added below for FD-RUT-CRF-0066.1 [IN036975]
						<option value='P'><fmt:message key="Common.Probable.label" bundle="${common_labels}"/></option>  -->
						<option value='E'><fmt:message key="ePH.established.label" bundle="${ph_labels}"/></option>
						<option value='P'><fmt:message key="Common.Probable.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="ePH.suspected.label" bundle="${ph_labels}"/></option>
						<option value='O'><fmt:message key="ePH.Possible.label" bundle="${ph_labels}"/></option>
						<option value='U'><fmt:message key="ePH.Unlikely.label" bundle="${ph_labels}"/></option>  <!-- FD-RUT-CRF-0066.1 [IN036975]  -- end-->
						</select>
					</td>
					<td align="right" class="label" > 
						<fmt:message key="Common.Nature.label" bundle="${common_labels}"/>		
					</td>
					<td class="label">
					<select name='nature' id='nature' size='1' >
					 <option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					 <option value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					 <option value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					 </select> 
					 <input type='hidden' value='' name='Nature' id='Nature'>
					</td >
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
										<option value='intr_name2'><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>2</option>
										<option value='form_code1'><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>1</option>   <!-- option value dosage_form1 renamed as form_code1 for FD-RUT-CRF-0066.1 [IN036975]  -->
										<option value='form_code2'><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>2</option>	<!-- dosage_form1 renamed as form_code2 for FD-RUT-CRF-0066.1 [IN036975] -->
										<option value='intr_severity_level'><fmt:message key="Common.Severity.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/></option>
										<option value='intr_signif_level'><fmt:message key="Common.significant.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/></option>
										<option value='intr_prob_level'><fmt:message key="ePH.documentation.label" bundle="${ph_labels}"/></option>  <!-- added for FD-RUT-CRF-0066.1 [IN036975] -->
										<option value='eff_status'><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></option>
									 </select>
									</td>
									<td align='center' width='3%' >
										<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
										<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
									</td>
									<td width='45%' align='center'>
										<select name='orderbycolumns' id='orderbycolumns' size='8' multiple='true'>
											<option value='intr_name1'><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>1</option>
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

			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="sql_ph_generic_name_lookup" id="sql_ph_generic_name_lookup" value="<%=sql_ph_generic_name_lookup%>">
			<input type="hidden" name="sql_ph_drug_lookup" id="sql_ph_drug_lookup" value="<%=sql_ph_drug_lookup%>">
			<input type="hidden" name="sql_ds_foodItem_lookup" id="sql_ds_foodItem_lookup" value="<%=sql_ds_foodItem_lookup%>"> <!--IN070606-->
			<input type="hidden" name="sql_lb_labOrderCatalog_lookup" id="sql_lb_labOrderCatalog_lookup" value="<%=sql_lb_labOrderCatalog_lookup%>"> <!--IN070606 -->
		</form>
	</body>
</HTML>

