<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<!-- MODIFIED for MMS-KH-CRF-0028  -->
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><!-- ADDED for IN070605  -->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
28-05-2022			 aakh-crf-0140   prathyusha 
---------------------------------------------------------------------------------------------------------------
*/ %> 
<html>
	<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script>
		<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>	
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>	
		<script language="JavaScript" src="../../ePH/js/IVPrescription.js"></script>	
		<!-- <script language="Javascript" src="../js/PhMessages.js"></script> -->
		<!--<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>-->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
	String calling_func	=	request.getParameter("called_from");
	String calledFor	=	request.getParameter("calledFor")==null?"":request.getParameter("calledFor");
	String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
	String or_mode		=	request.getParameter("or_mode");
	String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");//added for IN070605
	String order_line_no = request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");//added for IN070605
	String allergy_cnt = request.getParameter("allergy_cnt")==null?"":request.getParameter("allergy_cnt");//added for IN070605
	String disp_medication = request.getParameter("disp_medication")==null?"":request.getParameter("disp_medication");//added for IN070605
	if(or_mode == null){
		or_mode="";
	}
	//added for MO-CRF-20159 - start
	String  disc_cancel_flag =request.getParameter("disc_cancel_flag")==null?"":request.getParameter("disc_cancel_flag");//Mo-CRF-20159
	String disc_yn = request.getParameter("disc_yn")==null?"":request.getParameter("disc_yn");
	String disabled = "";
	if(disc_cancel_flag==null)//Mo-CRF-20159
		disc_yn = "";
	if(disc_yn==null || disc_yn.equals(""))
		disabled = "";
	else
		disabled = "disabled";
	//added for MO-CRF-20159 - end
//added for IN070605 START
	String	bean_id_1					=	"DispMedicationBean" ;
	String	bean_name_1					=	"ePH.DispMedicationBean";
	DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
	bean_1.setLanguageId(locale);
	String disp_stage			=	(String)bean_1.getDispStage()== null ? "":(String)bean_1.getDispStage();
	//added for IN070605 END
	String patient_id	=   request.getParameter("patient_id");
	String encounter_id	=   request.getParameter("encounter_id");
%>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="prescription_close_form" id="prescription_close_form"><!-- form  added for IN070605 -->
	<%
	//added for IN070605 start
            Connection con			= null;  
          try{//try catch block added for IN070605
			con				= ConnectionManager.getConnection(request);
			boolean intractn_req_yn =true;//bean.isSite(request,"PH","DISP_STAGE_INTRACTN_REQ_YN");	
			
					// Added for IN070605  end 
					%>
		<table  border='0' align="left" width='100%' cellpadding='0' cellspacing='0' >
<%	
			if (calling_func.equals("refill")) {
%>
				<td  class="button" ><input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="saveRefill();saveAndClose();">&nbsp;&nbsp;&nbsp;
				</td>
<%	
			}
			else if(calling_func.equals("diagnosis")) { 
%>
				<td  nowrap style='background-color:#034844' class="IVFLUID" width="18%" align='center'><label style="font-size:9;font-weight:bold;color:white"><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/></label></td>
				<td  nowrap style='background-color:#3c8279' class="IVINGREDIENT" width="18%" align='center'><label style="font-size:9;font-weight:bold;color:white">&nbsp;<fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/></label></td>
				<td  nowrap style='background-color:#a2e2e9' class="DISCHARGEMED" width="18%" align='center'><label style="font-size:9;font-weight:bold">&nbsp;<fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></label></td>
				<td  nowrap style='background-color:#fe9a96' class="FORMULARY" width="18%" align='center'><label style="font-size:9;font-weight:bold; ">&nbsp;<fmt:message key="ePH.NonFormulary.label" bundle="${ph_labels}"/></label></td>
				<td  nowrap style='background-color:#E4CAFF'  width="18%" align='center'><label style="font-size:9;font-weight:bold;">&nbsp;<fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></label></td>
				<%if(disp_medication.equals("disp_medication")){//ADDED FOR IN070605 %>
				<td class="button"  ><input type="button" class="button" value="Review/Approve" onclick="drugindication_remarks_disp('diagnosis','<%=order_id%>','<%=order_line_no%>','<%=allergy_cnt%>')"></input></td>
<%
				}%>
				<td  class="white" width="4%" align="right"><input type="button" <%=disabled%> value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="savedrugIndicationRemarksClose(document.prescription_close_form.ReviewRemarks);parent.parent.document.getElementById('dialog_tag').close(); "> <!-- disabled added for MO-CRF-20159 -->
				</td>
<%
			} 
			else if(calling_func.equals("normal")) {
%>
				<td class="button"  width="4%" align="right" >
<%
				if(calledFor.equals("Alert")){
%>
					<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button"  onClick="closeWindow();">
<%
				}
				else{
					if(calledFrom.equals("INTRACTIONDTLS")){
%>
						<input type="button" value='Close'  class="BUTTON" onClick="window.close()">
<%
					}
					else{
			if(disp_medication.equals("disp_medication")){//ADDED FOR IN070605 %>
				    <input type="button" class="button" value="Review/Approve" onclick="drugindication_remarks_disp('intaraction','<%=order_id%>','<%=order_line_no%>','<%=allergy_cnt%>')"></input>
				    
		<%}%>
					<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="savedrugIndicationRemarksClose(document.prescription_close_form.ReviewRemarks);parent.parent.document.getElementById('dialog_tag').close();">
<%
					}
				}
%>
				&nbsp;&nbsp;&nbsp;</td>
<%	
			} 
			else if(calling_func.equals("alergy")) { 
			
				if(disp_medication.equals("disp_medication")){//ADDED FOR IN070605 %>
				    <td class="button"  ><input type="button" class="button" value="Review/Approve" onclick="drugindication_remarks_disp('alergy','<%=order_id%>','<%=order_line_no%>','<%=allergy_cnt%>')"></input></td>
				    
		<%}%>
				<td class="button" > 
					<input type="button" value='<fmt:message key="ePH.MoreDetails.label" bundle="${ph_labels}"/>'  class="BUTTON" onClick="callAllergies('<%=patient_id%>');">&nbsp;&nbsp;
				</td>
				<td  class="button" width="4%"  >
					<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="savedrugIndicationRemarksClose(document.prescription_close_form.ReviewRemarks);parent.parent.document.getElementById('dialog_tag').close();">&nbsp;&nbsp;&nbsp;
				   </td>
				    <% }
			else if(calling_func.equals("remarks")) { 
%>
				<td class="button" align="right"> 
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="saveRemarks(parent.remarks_detail.document.prescription_remarks);">&nbsp;&nbsp;
					<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.window.close();">&nbsp;&nbsp;&nbsp;
				</td>
<%
			}
			else if(calling_func.equals("amendremarks")) { 
				if(or_mode.equals("amend")){
%>
					<td  class="button" align="right" > 
						<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="saveIVAmendRemarks(parent.remarks_detail.document.prescription_remarks,'<%=patient_id%>','<%=encounter_id%>');">&nbsp;&nbsp;
						<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.window.close();">&nbsp;&nbsp;&nbsp;
					</td>
<%
				}
				else{
%>
					<td class="button" align="right" > 
						<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.saveAmendRemarks(parent.remarks_detail.document.prescription_remarks);">&nbsp;&nbsp;
						<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.window.close();">&nbsp;&nbsp;&nbsp;
					</td>
<%
				}	
			}
			else if(calling_func.equals("PRNamend")){
%>
				<td class="button" > 
					<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button"  onClick="validatePRNRemarkAmend()">&nbsp;&nbsp;&nbsp;
				</td>
<%
			}	
			else if(calling_func.equals("PRN")){
%>
				<td class="button"> 
				<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button"  onClick="validatePRNRemark()">&nbsp;&nbsp;&nbsp;
				</td>
<%
			}
			else if(calling_func.equals("OverrideReason")){
%>
				<td class="button" align="right" > 
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button" onClick="validate();">&nbsp;&nbsp;&nbsp;</td>
<%
			}
			else if(calling_func.equals("abuse")){//added for aakh-crf-0140
				%>
								<td class="button" > 
									<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="button" onClick="parent.window.close();">&nbsp;&nbsp;&nbsp;</td>
				<%
							}
			else if(calling_func.equals("MediPlan")){//Added for Bru-HIMS-CRF-072.1[IN 049144] start
%>
				<td class="button" >
					<input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}" />' class="button" onClick="addActiveDrugs();"/>
					<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' class="button" onClick="window.close()"/>
				</td>
<%		
			}//Added for Bru-HIMS-CRF-072.1[IN 049144] end
%>
			</tr>
		</table>
	<%	//Added for IN070605 start
	
	putObjectInBean(bean_id_1,bean_1,request);
			}
		catch(Exception e){
			e.printStackTrace();
		}
                finally{ 
          	
          	if(con != null)
          		ConnectionManager.returnConnection(con,request);	
          } //Added for IN070605 end
%>	
<input type='hidden' name='ReviewRemarks' id='ReviewRemarks' value=''><!-- added for IN070605 -->
</form>
	</body>
</html>

