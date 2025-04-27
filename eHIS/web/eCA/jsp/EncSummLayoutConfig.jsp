<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
24/09/2014     		1   		Sethuraman      Created for Configuring Summary Layout  
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String mode="";
	String readOnly = "";
	String status = "";		
	String signatureStatus = "";		
	
	int nSummLayoutHdrListsize = 0;
	int nSummLayoutFieldsListsize = 0;
	
	int iHeaderOrient = 0; 
	int iColorsIndicate = 0; 
	int iTabcellColFill = 0;  
	int iTabCellBorFill = 0;  
	
	int iFooterSignFlag = 0;  
	int iFooterSignPosn = 0;  
	int iFooterSign1Flag = 0;  
	String sFooterSign1Lbl = ""; 
	int iFooterSign1PractID = 0;  
	int iFooterSign1Splty = 0;  
	int iFooterSign2Flag = 0;  
	String sFooterSign2Lbl = "";  
	int iFooterSign2PractID = 0;  
	int iFooterSign2Splty = 0;  
	int iFooterSign3Flag = 0;  
	String sFooterSign3Lbl = "";  
	int iFooterSign3PractID = 0;  
	int iFooterSign3Splty = 0; 
	
	int iFooterDigitSign = 0; 
	
	int iFieldFlag = 0, iFieldOrient = 0;
	String sFieldId = "", sFieldName="", sFieldLbl = "", sFieldFmt = "", sFieldType = "";
	
	int iFacilityTypeFlag = 0, iPatientTypeFlag = 0, iOrderTypeFlag = 0;
	
	int iFieldsCount = 0;
	
	String enabled_checked1="";
	
	String sHeaderCode = "";
	String sFooterCode = "";
	
	String sSummaryCode = "";
	String sSummaryDesc = "";

	String enabled_checked="";
	
	String disabledStatus = "disabled";
	
	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	
	EncSummGroup summGrpDetails = new EncSummGroup(); 		
	
	List<EncSummLayoutHdrBean> oSummLayoutHdrList = null;
	EncSummLayoutHdrBean sSummLayoutHdrBean = null;	
	
	List<EncSummLayoutFieldsBean> oSummLayoutFieldsList = null;
	EncSummLayoutFieldsBean sSummLayoutFieldsBean = null;	
	
	EncSummLayoutHdrBean oSummLayoutHdrBean = null;
	EncSummLayoutFieldsBean oSummLayoutFieldsBean = null;
	
	
	String practType = "";
	practType = practType + "<option value=1>Attending Practitioner</option>";
	practType = practType + "<option value=2>Admitting Practitioner</option>";
	practType = practType + "<option value=3>Authorised By</option>";
	
	if(mode.trim().equalsIgnoreCase("insert")){	
		
		oSummLayoutHdrList = new ArrayList<EncSummLayoutHdrBean>();
		sSummLayoutHdrBean = new EncSummLayoutHdrBean();
		
		oSummLayoutFieldsList = new ArrayList<EncSummLayoutFieldsBean>();
		sSummLayoutFieldsBean = new EncSummLayoutFieldsBean();
		
		sSummaryCode = (request.getParameter("summaryCode")==null)?"":request.getParameter("summaryCode");		
		
		sSummLayoutHdrBean.setRequest(request);		
		sSummLayoutHdrBean.setsSummaryCode(sSummaryCode);
		
		sSummLayoutFieldsBean.setRequest(request);		
		sSummLayoutFieldsBean.setsSummaryCode(sSummaryCode);
		
		oSummLayoutHdrList = summGrpDetails.getLayoutHeader(sSummLayoutHdrBean);
		nSummLayoutHdrListsize = oSummLayoutHdrList.size();
		if (nSummLayoutHdrListsize>0)
		{			
			
			oSummLayoutHdrBean = oSummLayoutHdrList.get(nSummLayoutHdrListsize-1);		
			
			iHeaderOrient 	= oSummLayoutHdrBean.getiHeaderOrient();
			iColorsIndicate = oSummLayoutHdrBean.getiColorsIndicate();
			iTabcellColFill = oSummLayoutHdrBean.getiTabcellColFill();  
			iTabCellBorFill = oSummLayoutHdrBean.getiTabCellBorFill();  
			
			iFooterSignFlag 	= oSummLayoutHdrBean.getiFooterSignFlag();  
			iFooterSignPosn 	= oSummLayoutHdrBean.getiFooterSignPosn();  
			iFooterSign1Flag 	= oSummLayoutHdrBean.getiFooterSign1Flag();  
			sFooterSign1Lbl 	= oSummLayoutHdrBean.getsFooterSign1Lbl(); 
			iFooterSign1PractID = oSummLayoutHdrBean.getiFooterSign1PractID();  
			iFooterSign1Splty 	= oSummLayoutHdrBean.getiFooterSign1Splty();  
			iFooterSign2Flag 	= oSummLayoutHdrBean.getiFooterSign2Flag();  
			sFooterSign2Lbl 	= oSummLayoutHdrBean.getsFooterSign2Lbl();  
			iFooterSign2PractID = oSummLayoutHdrBean.getiFooterSign2PractID();  
			iFooterSign2Splty 	= oSummLayoutHdrBean.getiFooterSign2Splty();  
			iFooterSign3Flag 	= oSummLayoutHdrBean.getiFooterSign3Flag();  
			sFooterSign3Lbl 	= oSummLayoutHdrBean.getsFooterSign3Lbl();  
			iFooterSign3PractID = oSummLayoutHdrBean.getiFooterSign3PractID();  
			iFooterSign3Splty 	= oSummLayoutHdrBean.getiFooterSign3Splty(); 
			
			iFooterDigitSign 	= oSummLayoutHdrBean.getiFooterDigitSign(); 
			
			sHeaderCode 		= oSummLayoutHdrBean.getsHeaderCode();
			sFooterCode			= oSummLayoutHdrBean.getsFooterCode();
			
		}
		
	}
	
	if (iFooterSignFlag == 1)
	{
		signatureStatus = "enabled";
	}
	else
	{
		signatureStatus = "disabled";
	}

	if(mode.trim().equalsIgnoreCase("update")) 
	{
		status="disabled" ;readOnly = "readonly"; 
	}
	else if(mode.trim().equalsIgnoreCase("insert"))
	{
		status = "enabled"; 
		readOnly = "";
	}
	else
	{
		status = "disabled"; 
		readOnly = "readonly";
	}

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/EncSummLayout.js'></script>
<Script language="JavaScript" src='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body class='CONTENT' OnMouseDown="CodeArrest()"
	onload='FocusFirstElement();' onKeyDown="lockKey()">
	<form name="SummLayoutConfigForm" id="SummLayoutConfigForm"
		action="../../servlet/eCA.EncSummLayoutServlet" method="post"
		target="messageFrame">
		
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 900px;">
			<tbody>
				<tr>
					<td class='columnheadercenter' colspan="3">Summary Information&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData' width="45%">Header Orientation&nbsp;</td>
					<td class='Fields' ><input type="radio"
									name="orientation" id="orientation" value="0"
									<%= iHeaderOrient == 0 ? "checked='checked'" : "" %>>Vertical</td>
					<td class='Fields'><input type="radio"
									name="orientation" id="orientation" value="1"
									<%= iHeaderOrient == 1 ? "checked='checked'" : "" %>>Horizontal</td>
				</tr>
				<tr>
					<td class='gridData' width="45%">Color Indicate&nbsp;</td>
					<td class='Fields' colspan="2"><input type="checkbox"
									name="es_colors_indicate" id="es_colors_indicate"
									<%= iColorsIndicate == 1 ? "checked" : "" %>>Yes/No</td>
				</tr>							
			</tbody>
		</table>
	
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 900px;">
			<tbody>
				<tr>
					<td class='columnheadercenter' colspan="2">Table Template&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData' width="45%">Cell Color Fill&nbsp;</td>
					<td class='Fields' width="55%"><input type="checkbox"
									name="es_tab_cell_color" id="es_tab_cell_color"
									<%= iTabcellColFill == 1 ? "checked" : "" %>>Yes/No</td>
				</tr>
				<tr>
					<td class='gridData' width="45%">Cell Border Color Fill&nbsp;</td>
					<td class='Fields' width="55%"><input type="checkbox"
									name="es_tbl_cell_bborder_fill" id="es_tbl_cell_bborder_fill"
									<%= iTabCellBorFill == 1 ? "checked" : "" %>>Yes/No</td>
				</tr>
			</tbody>
		</table>
					
		<%
			oSummLayoutFieldsList = summGrpDetails.getLayoutDetails(sSummLayoutFieldsBean);
			nSummLayoutFieldsListsize = oSummLayoutFieldsList.size();
			
			if (nSummLayoutFieldsListsize>0){
				%>
				<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
						style="width: 900px;">
				<tbody>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER' width="100" >Field Name</td>
					<td class='COLUMNHEADERCENTER'>Enable Flag</td>					
					<td class='COLUMNHEADERCENTER' colspan="2">Orientation</td>
					<td class='COLUMNHEADERCENTER'>Label</td>
				</tr>
				<%
				
				for (int i=0; i<oSummLayoutFieldsList.size(); i++) {
					oSummLayoutFieldsBean = oSummLayoutFieldsList.get(i);
					sFieldId = oSummLayoutFieldsBean.getsFieldId();
					sFieldName = oSummLayoutFieldsBean.getsFieldName();
					iFieldFlag = oSummLayoutFieldsBean.getiFieldFlag();
					iFieldOrient = oSummLayoutFieldsBean.getiFieldOrient();
					sFieldLbl = oSummLayoutFieldsBean.getsFieldLabel();
					sFieldFmt = oSummLayoutFieldsBean.getsFieldFormat();
					sFieldType = oSummLayoutFieldsBean.getsFieldType();
					iFieldsCount = iFieldsCount + 1;
					%>
					
					<%
					
						if (iFacilityTypeFlag == 0){
							
							if (sFieldType.equalsIgnoreCase("f")) 
							{
								%>
								<tr id='trcoll'>
								<td class='COLUMNHEADERCENTER' colspan='5' >Facility Information</td>
								</tr>
								<%
								
								iFacilityTypeFlag = 1;								
							}
							
						}
						if (iPatientTypeFlag == 0){
							
							if (sFieldType.equalsIgnoreCase("p")) 
							{
								%>
								<tr id='trcoll'>
								<td class='COLUMNHEADERCENTER' colspan='5' >Patient Information</td>
								</tr>
								<%
								
								iPatientTypeFlag = 1;								
							}
							
						}
						if (iOrderTypeFlag == 0){
							
							if (sFieldType.equalsIgnoreCase("o") ) 
							{
								%>
								<tr id='trcoll'>
								<td class='COLUMNHEADERCENTER' colspan='5' >Order Information</td>
								</tr>
								<%
								
								iOrderTypeFlag = 1;								
							}
							
						}
					
					%>
					<tr id = 'numRows'<%=i%>>
					<td style='display:none'> <input type= hidden value="<%=sFieldId%>" name='es_field_id<%=i%>'> </td>		
					<td style='display:none'> <input type= hidden value="<%=iFieldFlag%>" name='es_field_hidden_flag<%=i%>'> </td>			
					<td style='display:none'> <input type= hidden value="<%=sFieldFmt%>" name='es_field_fmt<%=i%>'> </td>
					<td style='display:none'> <input type= hidden value="<%=sFieldType%>" name='es_field_type<%=i%>'> </td>
					<td class='gridData'   > <%=sFieldName%></td>								
					<td class='Fields'><input type="checkbox"
													name='es_field_flag<%=i%>' id='es_field_flag<%=i%>'
													<%= iFieldFlag == 1 ? "checked" : "" %>
													onclick='setHeadFootFields(<%=i%>)'>Yes/No</td>	
					<td class='Fields' ><input type="radio"
													name='es_field_orient<%=i%>' id='es_field_orient<%=i%>' value="0"
													<%= iFieldOrient == 0 ? "checked='checked'" : "" %>
													<%= iFieldFlag == 0 ? "disabled" : "" %> <%= sFieldType.equalsIgnoreCase("p") ? "disabled" : "" %>>Header</td>
					<td class='Fields'><input type="radio"
													name='es_field_orient<%=i%>' id='es_field_orient<%=i%>' value="1"
													<%= iFieldOrient == 1 ? "checked='checked'" : "" %>
													<%= iFieldFlag == 0 ? "disabled" : "" %> <%= sFieldType.equalsIgnoreCase("p") ? "disabled" : "" %>>Footer</td>													
					<td class='Fields'><input type="text"
													name='es_field_lbl<%=i%>' id='es_field_lbl<%=i%>' value="<%=sFieldLbl%>"
													size=40 maxlength=40
													onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"
													<%= iFieldFlag == 0 ? "disabled" : "" %>></td>					
					</tr>
					<% 
				}
				
				%>
				</tbody>
				</table>
				<%	
			}
		
		%>
		
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 900px;">
			<tbody>
				<tr>
					<td class='columnheadercenter' colspan="4">Signature Template&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData'>Signature Flag&nbsp;</td>
					<td class='Fields'><input type="checkbox"
									name="es_footer_sign_flag" id="es_footer_sign_flag"
									<%= iFooterSignFlag == 1 ? "checked" : "" %>
									onclick="setSignatureFields(0,this)">Yes/No
							</td>
					<td class='gridData'>Signature Position&nbsp;</td>
					<td class='Fields'><input type="radio"
									name="es_footer_sign_posn" id="es_footer_sign_posn" value="0"
									<%= iFooterSignPosn == 0 ? "checked='checked'" : "" %>
									<%= iFooterSignFlag == 0 ? "disabled" : "" %>>End of each page&nbsp;&nbsp;&nbsp;
									<input type="radio"
									name="es_footer_sign_posn" id="es_footer_sign_posn" value="1"
									<%= iFooterSignPosn == 1 ? "checked='checked'" : "" %>
									<%= iFooterSignFlag == 0 ? "disabled" : "" %>>End of Report
							</td>
				</tr>
				<tr>
					<td class='columnheadercenter' colspan="4">Signature 1 Template&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData'>Signature 1 Required &nbsp;</td>
					<td class='Fields'><input type="checkbox"
									name="es_footer_sign_1_flag" id="es_footer_sign_1_flag" <%=signatureStatus %>
									<%= iFooterSign1Flag == 1 ? "checked" : "" %>
									onclick="setSignatureFields(1,this)">Yes/No
							</td>
					<td class='gridData'>Label&nbsp;</td>
					<td class='Fields'><input type="text"
									name="es_footer_sign_1_label" id="es_footer_sign_1_label" value="<%=sFooterSign1Lbl%>"
									size=30 maxlength=30
									onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"
									<%= iFooterSign1Flag == 0 ? "disabled" : "" %>>
							</td>
				</tr>
				<tr>
					<td class='gridData'>Select Practioner Type&nbsp;</td>
					<td class='Fields'><select name='es_footer_sign_1_practid' id='es_footer_sign_1_practid'
									onchange='mainGroupType(this)' <%= status%> 
									<%= iFooterSign1Flag == 0 ? "disabled" : "" %>>														
										<option value=0> -------------	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />-------------	</option>
										<%=practType%>														
								</select>
								<script>									
									var tempObjName = 'es_footer_sign_1_practid';									
									if ('<%=iFooterSign1PractID%>' > 0 )
									{
										var selTempObj = document.getElementById(tempObjName);										
										for(var i=0;i<selTempObj.options.length;i++){											
								            if (selTempObj.options[i].value == '<%=iFooterSign1PractID%>') {
								            	selTempObj.selectedIndex = i;
								                break;
								            }
								        }
									}
								</script>
							</td>
					<td class='gridData'>Speciality Flag&nbsp;</td>
					<td class='Fields'> <input type="checkbox"
									name="es_footer_sign_1_splty" id="es_footer_sign_1_splty"
									<%= iFooterSign1Splty == 1 ? "checked" : "" %>
									<%= iFooterSign1Flag == 0 ? "disabled" : "" %>>Yes/No
							</td>
				</tr>
				<tr>
					<td class='columnheadercenter' colspan="4">Signature 2 Template&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData'>Signature Required &nbsp;</td>
					<td class='Fields'><input type="checkbox"
									name="es_footer_sign_2_flag" id="es_footer_sign_2_flag" <%=signatureStatus %>
									<%= iFooterSign2Flag == 1 ? "checked" : "" %>
									onclick="setSignatureFields(2,this)">Yes/No
							</td>
					<td class='gridData'>Label&nbsp;</td>
					<td class='Fields'><input type="text"
									name="es_footer_sign_2_label" id="es_footer_sign_2_label" value="<%=sFooterSign2Lbl%>"
									size=30 maxlength=30
									onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"
									<%= iFooterSign2Flag == 0 ? "disabled" : "" %>>
							</td>
				</tr>
				<tr>
					<td class='gridData'>Select Practioner Type&nbsp;</td>
					<td class='Fields'><select name='es_footer_sign_2_practid' id='es_footer_sign_2_practid'
									onchange='mainGroupType(this)' <%= status%>
									<%= iFooterSign2Flag == 0 ? "disabled" : "" %>>														
										<option value=0> -------------	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />-------------	</option>
										<%=practType%>														
								</select>
								<script>
									var tempObjName = 'es_footer_sign_2_practid';									
									if ('<%=iFooterSign2PractID%>' > 0 )
									{
										var selTempObj = document.getElementById(tempObjName);										
										for(var i=0;i<selTempObj.options.length;i++){											
								            if (selTempObj.options[i].value == '<%=iFooterSign2PractID%>') {
								            	selTempObj.selectedIndex = i;
								                break;
								            }
								        }
									}
								</script>
							</td>
					<td class='gridData'>Speciality Flag&nbsp;</td>
					<td class='Fields'><input type="checkbox"
									name="es_footer_sign_2_splty" id="es_footer_sign_2_splty"
									<%= iFooterSign2Splty == 1 ? "checked" : "" %>
									<%= iFooterSign2Flag == 0 ? "disabled" : "" %>>Yes/No
							</td>
				</tr>
				<tr>
					<td class='columnheadercenter' colspan="4">Signature 3 Template&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData'>Signature Required &nbsp;</td>
					<td class='Fields'><input type="checkbox"
									name="es_footer_sign_3_flag" id="es_footer_sign_3_flag" <%=signatureStatus %>
									<%= iFooterSign3Flag == 1 ? "checked" : "" %>
									onclick="setSignatureFields(3,this)">Yes/No
							</td>
					<td class='gridData'>Label&nbsp;</td>
					<td class='Fields'><input type="text"
									name="es_footer_sign_3_label" id="es_footer_sign_3_label" value="<%=sFooterSign3Lbl%>"
									size=30 maxlength=30
									onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"
									<%= iFooterSign3Flag == 0 ? "disabled" : "" %>>
							</td>
				</tr>
				<tr>
					<td class='gridData'>Select Practitioner Type&nbsp;</td>
					<td class='Fields'><select name='es_footer_sign_3_practid' id='es_footer_sign_3_practid'
									onchange='mainGroupType(this)' <%= status%>
									<%= iFooterSign3Flag == 0 ? "disabled" : "" %>>														
										<option value=0> -------------	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />-------------	</option>
										<%=practType%>														
								</select>
								<script>
									var tempObjName = 'es_footer_sign_3_practid';									
									if ('<%=iFooterSign3PractID%>' > 0 )
									{
										var selTempObj = document.getElementById(tempObjName);										
										for(var i=0;i<selTempObj.options.length;i++){											
								            if (selTempObj.options[i].value == '<%=iFooterSign3PractID%>') {

								            	selTempObj.selectedIndex = i;
								                break;
								            }
								        }
									}
								</script>
							</td>
					<td class='gridData'>Speciality Flag&nbsp;</td>
					<td class='Fields'><input type="checkbox"
									name="es_footer_sign_3_splty" id="es_footer_sign_3_splty"
									<%= iFooterSign3Splty == 1 ? "checked" : "" %>
									<%= iFooterSign3Flag == 0 ? "disabled" : "" %>>Yes/No
							</td>
				</tr>
			</tbody>
		</table>
		<!-- Header & Footer Preview Buttons -->
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 900px;">
			<tbody>
				<tr>					
					<td>
						<input type="button" name="search" id="search" value="Page Header Preview" onClick="showHeaderHtml();"  class="button">
					</td>
					<td>
						<input type="button" name="search" id="search" value="Page Footer Preview" onClick="showFooterHtml();"  class="button">
					</td>
				</tr>
				
			</tbody>
		</table>
		
		<br>
		<br>
		<br>
					

		<input type=hidden name="mode" id="mode" value="<%=mode%>"> 
		<input type=hidden name="es_summ_code" id="es_summ_code" value=<%=sSummaryCode%>>
		<input type=hidden name="fieldsCount" id="fieldsCount" value="<%=iFieldsCount%>"> 
		<input type=hidden name="fieldsValue" id="fieldsValue" value=""> 
		<input type=hidden name="flag" id="flag" value="true">
		
		<input type=hidden name="hiddenHeaderOrient" id="hiddenHeaderOrient" value=""> 
		<input type=hidden name="hiddenColorIndicate" id="hiddenColorIndicate" value=""> 
		<input type=hidden name="hiddenTblCellColFill" id="hiddenTblCellColFill" value=""> 
		<input type=hidden name="hiddenTblCellBorFill" id="hiddenTblCellBorFill" value=""> 
		<input type=hidden name="hiddenFooterSignFlag" id="hiddenFooterSignFlag" value=""> 
		<input type=hidden name="hiddenFooterSignPosn" id="hiddenFooterSignPosn" value=""> 
		
		<input type=hidden name="hiddenFooterSign1Flag" id="hiddenFooterSign1Flag" value=""> 
		<input type=hidden name="hiddenFooterSign1Lbl" id="hiddenFooterSign1Lbl" value=""> 
		<input type=hidden name="hiddenFooterSign1Pract" id="hiddenFooterSign1Pract" value=""> 
		<input type=hidden name="hiddenFooterSign1Splty" id="hiddenFooterSign1Splty" value=""> 
		
		<input type=hidden name="hiddenFooterSign2Flag" id="hiddenFooterSign2Flag" value=""> 
		<input type=hidden name="hiddenFooterSign2Lbl" id="hiddenFooterSign2Lbl" value=""> 
		<input type=hidden name="hiddenFooterSign2Pract" id="hiddenFooterSign2Pract" value=""> 
		<input type=hidden name="hiddenFooterSign2Splty" id="hiddenFooterSign2Splty" value="">
		
		<input type=hidden name="hiddenFooterSign3Flag" id="hiddenFooterSign3Flag" value=""> 
		<input type=hidden name="hiddenFooterSign3Lbl" id="hiddenFooterSign3Lbl" value=""> 
		<input type=hidden name="hiddenFooterSign3Pract" id="hiddenFooterSign3Pract" value=""> 
		<input type=hidden name="hiddenFooterSign3Splty" id="hiddenFooterSign3Splty" value="">
		
		<input type=hidden name="headerValue" id="headerValue" value=""> 
		<input type=hidden name="footerValue" id="footerValue" value=""> 
	</form>
</body>
</html>

