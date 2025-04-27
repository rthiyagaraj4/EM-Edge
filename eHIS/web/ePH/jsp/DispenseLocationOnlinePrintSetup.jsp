<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" ePH.*, ePH.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseLocation.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
#table_container_right > table > tbody > tr > td
{
height:19px;
}
</style>

		<title><fmt:message key="ePH.OnlinePrintSetup.label" bundle="${ph_labels}"/></title>
	</head>

	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
		<FORM name="formDispenseOnlineSetup" id="formDispenseOnlineSetup">
<%
			String	bean_id				= "DispenseLocationBean" ;
			String	bean_name			= "ePH.DispenseLocationBean";
			DispenseLocationBean bean	= (DispenseLocationBean)getBeanObject( bean_id, bean_name, request);

			String delivery_legend = request.getParameter("delivery_legend");
			String allocate_legend = request.getParameter("allocate_legend");
			String fill_legend = request.getParameter("fill_legend");
			String mode = request.getParameter("mode");
			String pharmacyType = request.getParameter("pharmacyType");
			String disp_locn_code = request.getParameter("disp_locn_code");


			String print  =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels");	
			String noPrint = 	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoPrint.label","ph_labels");	
			String printDefault =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrintDefault.label","ph_labels");	
			//String label = "";
			//String classvalue = "";
			String select_all = "";
			String disableOPCategory ="";
			String disableIPCategory ="";
			String reoprtLabel ="";
			String str ="";
			//Adding start for MOHE-CRF-0069
			Connection con			= null; 
			con				= ConnectionManager.getConnection(request);
			boolean refill_site=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REFILL_LABEL");//added for MOHE-CRF-0069

			int count = 0;
			 HashMap printMap = bean.getOnlinePrintSetupMap(); 
			if (mode.equals("1")){
				if(printMap==null || printMap.size()==0){
					bean.setOnlinePrintDetails(bean.getLoggedInFacility(),disp_locn_code);	
				}
				 if (pharmacyType.equals("I")){
					 disableIPCategory = "";
					 disableOPCategory = "disabled";
				 }
				 else if (pharmacyType.equals("O")){
					disableIPCategory = "disabled";
					disableOPCategory = "";
				}
				else{
					disableOPCategory = "";
					disableIPCategory = "";
				}
			}
			else{

				if (bean.getDispLocnCategory().equals("I")){
					disableOPCategory = "disabled";
					disableIPCategory = "";
				}
				else if (bean.getDispLocnCategory().equals("O")){
					disableIPCategory = "disabled";
					disableOPCategory = "";
				}
				else{
					disableOPCategory = "";
					disableIPCategory = "";
				}
			}
			 select_all = bean.getSelectAll() ==  "" ? "PD" :  bean.getSelectAll();

			 Set keyset=printMap.keySet();
			 Object[] sorted_set = keyset.toArray();
			 Arrays.sort(sorted_set);
%>
			<input type = 'hidden' name = 'h_select_all' value = '<%=bean.getSelectAll()%>'>
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="90%" >
				<tr><td  CLASS="label"> <fmt:message key="Common.selectall.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<select name="select_all" id="select_all" onchange="selectAll(this)">
				<option value ="NP" <%=select_all.equals("NP") ? "selected":"" %>><%=noPrint%></option>
				<option value ="PT" <%=select_all.equals("PT") ? "selected":"" %>><%=print%></option>
				<option value ="PD" <%=select_all.equals("PD") ? "selected":"" %>><%=printDefault%></option>
				</TD>
			</TABLE>

			<div id='table_container_left' style='overflow:hidden;width:320px;height:342px;position:relative;float:left;'>
				<TABLE   BORDER="1" CELLPADDING="0" CELLSPACING="0" ALIGN="LEFT" >
					<TR style='position:relative' ><TH  WIDTH = "25%">&nbsp;</TH></TR>
					<TR style='position:relative' ><TH><fmt:message key="ePH.PHOnlineReportName.label" bundle="${ph_labels}"/></TH></TR>
					<TR style='position:relative' ><TH>&nbsp;</TH></TR>
<%
					for (int i=0;i<sorted_set.length;i++){		 
						str=sorted_set[i].toString();			
						if (str.equals("BMS_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.BMS_SHEET.label","ph_labels");
						else if (str.equals("CERTIFICATE_REIMBURSEMENT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CERTIFICATE_REIMBURSEMENT.label","ph_labels");
						else if (str.equals("DISPENSE_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DISPENSE_SHEET.label","ph_labels");
						else if (str.equals("DRUG_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DRUG_LABEL.label","ph_labels");
						else if (str.equals("FILL_LIST_DRUGMEDICAL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_DRUGMEDICAL.label","ph_labels");
						else if (str.equals("FILL_LIST_PATIENT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_PATIENT","ph_labels");
						else if (str.equals("FILL_LIST_UNALLOCATED"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_UNALLOCATED.label","ph_labels");			
						else if (str.equals("PHPRMEDPL")) //Added PHPRMEDPL For ML-BRU-CRF-072[Inc:29938]
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationPlanSheet.label","ph_labels"); //Added PHPRMEDPL For ML-BRU-CRF-072[Inc:29938] 
						else if (str.equals("HOME_MEDICATION_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels");
						else if (str.equals("MANUFACTURING_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MANUFACTURING_LABEL.label","ph_labels");
						else if (str.equals("MEDICAL_SUPPLY_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICAL_SUPPLY_LABEL.label","ph_labels");
						else if (str.equals("MEDICATION_LIST"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICATION_LIST.label","ph_labels");	
						else if (str.equals("REFILL_MEDICATION_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RefillMedicationSheet.label","ph_labels");	
						else if (str.equals("TOKEN"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TOKEN.label","ph_labels");
						else if (str.equals("WORK_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.WORK_SHEET.label","ph_labels");
						else if (str.equals("HOME_MED_SHEET_TAPER"))//Added for RUT-CRF-0061 - Start
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Taper Order)";
						else if (str.equals("HOME_MED_SHEET_PORTRAIT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Portrait)";
						else if (str.equals("HOME_MED_SHEET_LANDSCAPE"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Landscape)";
						else if (str.equals("REFILL_MEDICATION_LABEL") && refill_site)//Added for MOHE-CRF-0069
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RefillMedicationLabel.label","ph_labels");
						//HashMap rowDetails=(HashMap)printMap.get(str);
%>
						<tr style='height:21px;'><td nowrap class='label'><%=reoprtLabel%> </td></tr>
<%
					}
%>	
				</TABLE>
			</div>
			<div id='table_container_right' style='overflow:scroll;height:450px;'>
				<TABLE   BORDER="1" CELLPADDING="0" CELLSPACING="0" ALIGN="LEFT" >
					<TR>
						<TH   COLSPAN="4" ><fmt:message key="ePH.OPPatientClass.label" bundle="${ph_labels}"/></TH>
						<TH   COLSPAN="6" ><fmt:message key="ePH.IPPatientClass.label" bundle="${ph_labels}"/></TH>
					
					</TR>
					<TR>		
						<TH></TH>
						<TH></TH>
						<TH></TH>
						<TH></TH>
						<TH></TH>
						<TH colspan='2'><%=fill_legend%></TH>
						<TH colspan='2'><%=delivery_legend%></TH>
					</TR>
					<TR>			
						<TH nowrap><%=allocate_legend%></TH>
						<TH nowrap><%=fill_legend%></TH>
						<TH nowrap><%=delivery_legend%></TH>
						<TH nowrap><fmt:message key="ePH.AllStages.label" bundle="${ph_labels}"/></TH>
						<TH nowrap><fmt:message key="ePH.RunIPFill.label" bundle="${ph_labels}"/></TH>
						<TH nowrap><fmt:message key="ePH.WithFillList.label" bundle="${ph_labels}"/></TH>
						<TH nowrap><fmt:message key="ePH.WithoutFillList.label" bundle="${ph_labels}"/></TH>
						<TH nowrap>&nbsp;<fmt:message key="ePH.WithFillList.label" bundle="${ph_labels}"/>&nbsp;</TH>
						<TH nowrap><fmt:message key="ePH.WithoutFillList.label" bundle="${ph_labels}"/></TH>
					</TR>	
<%
					for (int i=0;i<sorted_set.length;i++){
						 str=sorted_set[i].toString();			
						if (str.equals("BMS_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.BMS_SHEET.label","ph_labels");
						else if (str.equals("CERTIFICATE_REIMBURSEMENT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CERTIFICATE_REIMBURSEMENT.label","ph_labels");
						else if (str.equals("DISPENSE_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DISPENSE_SHEET.label","ph_labels");
						else if (str.equals("DRUG_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DRUG_LABEL.label","ph_labels");
						else if (str.equals("FILL_LIST_DRUGMEDICAL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_DRUGMEDICAL.label","ph_labels");
						else if (str.equals("FILL_LIST_PATIENT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_PATIENT","ph_labels");
						else if (str.equals("FILL_LIST_UNALLOCATED"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_UNALLOCATED.label","ph_labels");			
						else if (str.equals("PHPRMEDPL"))//Added PHPRMEDPL For ML-BRU-CRF-072[Inc:29938]
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationPlanSheet.label","ph_labels");//Added PHPRMEDPL For ML-BRU-CRF-072[Inc:29938]
						else if (str.equals("HOME_MEDICATION_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels");
						else if (str.equals("MANUFACTURING_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MANUFACTURING_LABEL.label","ph_labels");
						else if (str.equals("MEDICAL_SUPPLY_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICAL_SUPPLY_LABEL.label","ph_labels");
						else if (str.equals("MEDICATION_LIST"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICATION_LIST.label","ph_labels");	
						else if (str.equals("REFILL_MEDICATION_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RefillMedicationSheet.label","ph_labels");	
						else if (str.equals("TOKEN"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TOKEN.label","ph_labels");
						else if (str.equals("WORK_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.WORK_SHEET.label","ph_labels");
						else if (str.equals("HOME_MED_SHEET_TAPER"))//Added for RUT-CRF-0061 - Start
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Taper Order)";
						else if (str.equals("HOME_MED_SHEET_PORTRAIT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Portrait)";
						else if (str.equals("HOME_MED_SHEET_LANDSCAPE"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Landscape)";//Added for RUT-CRF-0061 - End
						HashMap rowDetails=(HashMap)printMap.get(str);
%>
						 <input type ='hidden' name = 'report_id_<%=count%>' value ="<%=str%>" />
					 <tr>
<%
						if (rowDetails.get("OP_A")==null || rowDetails.get("OP_A").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						}
						else{
%>
							<td class='label'>
								<SELECT name="op_alloc_<%=count%>" id="op_alloc_<%=count%>" onchange='checkList(this,"OP_A","<%=str%>")' <%=disableOPCategory%>  >
								<option value ="NP" <%=rowDetails.get("OP_A").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("OP_A").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("OP_A").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						if (rowDetails.get("OP_F")==null || rowDetails.get("OP_F").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						}
						else{
%>
							<td class='label'>
								<SELECT name="op_fill_<%=count%>" id="op_fill_<%=count%>" onchange='checkList(this,"OP_F","<%=str%>")' <%=disableOPCategory%>  >
								<option value ="NP" <%=rowDetails.get("OP_F").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("OP_F").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("OP_F").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						if (rowDetails.get("OP_D")==null || rowDetails.get("OP_D").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						}
						else{
%>
							<td class='label'>
								<SELECT name="op_deliver_<%=count%>" id="op_deliver_<%=count%>" onchange='checkList(this,"OP_D","<%=str%>")' <%=disableOPCategory%>  >
								<option value ="NP" <%=rowDetails.get("OP_D").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("OP_D").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("OP_D").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						if (rowDetails.get("OP_AS")==null || rowDetails.get("OP_AS").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						  }
						  else{
%>
							<td class='label'>
								<SELECT name="op_allstages_<%=count%>" id="op_allstages_<%=count%>" onchange='checkList(this,"OP_AS","<%=str%>")' <%=disableOPCategory%>  >
								<option value ="NP" <%=rowDetails.get("OP_AS").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("OP_AS").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("OP_AS").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						if (rowDetails.get("IP_FP")==null || rowDetails.get("IP_FP").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						}
						else{
%>
							<td class='label'>
								<SELECT name="ip_fill_fp_<%=count%>" id="ip_fill_fp_<%=count%>" onchange='checkList(this,"IP_FP","<%=str%>")' <%=disableIPCategory%>  >
								<option value ="NP" <%=rowDetails.get("IP_FP").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("IP_FP").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("IP_FP").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						if (rowDetails.get("IP_AF")==null || rowDetails.get("IP_AF").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						}
						else{
%>
							<td class='label'>
								<SELECT name="ip_fill_with_fill_<%=count%>" id="ip_fill_with_fill_<%=count%>" onchange='checkList(this,"IP_AF","<%=str%>")' <%=disableIPCategory%>  >
								<option value ="NP" <%=rowDetails.get("IP_AF").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("IP_AF").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("IP_AF").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						if (rowDetails.get("IP_F")==null || rowDetails.get("IP_F").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						}
						else{
%>
							<td class='label'>
								<SELECT name="ip_fill_without_fill_<%=count%>" id="ip_fill_without_fill_<%=count%>" onchange='checkList(this,"IP_F","<%=str%>")' <%=disableIPCategory%>  >
								<option value ="NP" <%=rowDetails.get("IP_F").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("IP_F").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("IP_F").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						if (rowDetails.get("IP_DF")==null || rowDetails.get("IP_DF").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						}
						else{
%>
							<td class='label'>
								<SELECT name="ip_deliver_with_fill_<%=count%>" id="ip_deliver_with_fill_<%=count%>" onchange='checkList(this,"IP_DF","<%=str%>")' <%=disableIPCategory%>  >
								<option value ="NP" <%=rowDetails.get("IP_DF").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("IP_DF").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("IP_DF").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						if (rowDetails.get("IP_D")==null || rowDetails.get("IP_D").toString().equals("NR")){
%>	 
							<td>&nbsp;</td>
<%
						}
						else{
%>
							<td class='label'>
								<SELECT name="ip_deliver_without_fill_<%=count%>" id="ip_deliver_without_fill_<%=count%>" onchange='checkList(this,"IP_D","<%=str%>")' <%=disableIPCategory%>  >
								<option value ="NP" <%=rowDetails.get("IP_D").toString().equals("NP")?"selected":"" %>><%=noPrint%></option>
								<option value ="PT" <%=rowDetails.get("IP_D").toString().equals("PT")?"selected":"" %>><%=print%></option>
								<option value ="PD" <%=rowDetails.get("IP_D").toString().equals("PD")?"selected":"" %>><%=printDefault%></option>
								</select>
							</td>
<%
						}
						count++;
%>
						</TR>
<%
					}//for
%>
				</TABLE>
			</div>
			<input type= 'hidden' name="rows_count" id="rows_count" value ="<%=count%>" />
			<div id='table_buttons' style='height:40px;width:800px;'>
			<table>
				<tr>
					<td width ="80%"></td>
					<td class='button' align='left'>
						<input type='Button' class='Button'  value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  onclick='setOnlineSetuptoBean("ok");' >
					</TD>
					<td class='button' align='left'>
						<input type='Button' class='Button'  value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick='setOnlineSetuptoBean("cancel")' >&nbsp;&nbsp;&nbsp;
					</TD>
				</tr>
			</table>
			</div>
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
		</form>
	</body>
</html>

