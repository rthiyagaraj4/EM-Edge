<!DOCTYPE html>
 <%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
09/05/2017      GHL-SCF-1193  IN064097  SOFIA       RTN_MED_NO is empty when encounterID not there
07/01/2021      TFS-12069	     Prabha         SKR-SCF-1551
---------------------------------------------------------------------------------------------------------------
*/ %>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
        request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/ReturnMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
	<!-- <body topmargin="0"> -->
	<body topmargin="0" onMouseDown="" onKeyDown="lockKey()">
		<form id="FormReturnMedicationDrug" name="FormReturnMedicationDrug" id="FormReturnMedicationDrug">
<%
			//Search Criteria's from Query Criteria page
			String patientid		= request.getParameter( "patientid" );
			String drugcode			= request.getParameter( "drugcode" );
			String nationalid		= "" ;
			String healthcard     	= "";
			String dispno     		= request.getParameter( "dispno" ) ;
			String cutoff     		= request.getParameter( "cutoff" ) ;
			String orderid     		= request.getParameter( "orderid" ) ;
			String displocn     	= request.getParameter( "dispLocn" ) ;
			String FormStore     	=  CommonBean.checkForNull(request.getParameter( "FormStore" ));
			String eff_status     	=  CommonBean.checkForNull(request.getParameter( "eff_status" ));
			String Ward_Date_From     	=  CommonBean.checkForNull(request.getParameter( "Ward_Date_From" ));
			String ward_Date_To     	=  CommonBean.checkForNull(request.getParameter( "ward_Date_To" ));
			String From_Location     	=  CommonBean.checkForNull(request.getParameter( "From_Location" ));
			String encounter_id		=  CommonBean.checkForNull(request.getParameter( "encounter_id" ));
			String medn_rtn_after_bill_gen	=  CommonBean.checkForNull(request.getParameter( "medn_rtn_after_bill_gen" ));
			String blDocType	=  CommonBean.checkForNull(request.getParameter( "blDocType" )); //added for MMS-DM-CRF-0039 [IN:055958]
			String blDocNo	=  CommonBean.checkForNull(request.getParameter( "blDocNo" )); //added for MMS-DM-CRF-0039 [IN:055958]
			String patcat     		= request.getParameter( "patcat" ) ;
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "ReturnMedicationBean"+login_at_ws_no ;
			String bean_name	= "ePH.ReturnMedicationBean";
			int count1=1; // Added for GHL_CRF-413.8 US001
			/* Initialize Function specific start */
			ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
			String barcode_applicable=bean.getBarCodeflag((String)session.getValue("facility_id"), displocn);//"Y"; // Added for GHL_CRF-413.8 US001
			//Added for GHL-SCF-1193 Start
			bean.clearRetnMednNo();
			//Added for GHL-SCF-1193 End
			if(patientid.equals("")){
				patientid=(String)bean.getPatient_ID(dispno);
			}
			bean.clearSavedList();//added for GHL-CRF-0413.8
			bean.setFromStore(FormStore);
			bean.setEffstatus(eff_status);
			//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
			String FacilityFlag=bean.getFacility_Flag();
			if(FacilityFlag.equals("")){
				FacilityFlag="N";	
			}
			if(!(FacilityFlag.equals("Y"))){ 
				ArrayList drugDetails=bean.getDrugDetails(patientid,drugcode,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,encounter_id,locale,medn_rtn_after_bill_gen, blDocType, blDocNo, displocn);//code medn_rtn_after_bill_gen added for FD-JD-CRF-0178[IN039208] // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958] //displocn added for SKR-SCF-1551
				//	out.println(drugDetails);
				// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility
				if (drugDetails==null || drugDetails.size()==0){
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script> 
<%
				}
				else{	   
					/*	out.println(drugDetails.get(0));
					if (5==5){
					  return;
					}*/
					
					ArrayList patientDetails=new ArrayList();
					patientDetails=bean.getPatientDetails(patientid);
					String remarksUrl="../../ePH/jsp/ReturnMedicationRemarks.jsp?"+request.getQueryString();
					String patientUrl="../../ePH/jsp/ReturnMedicationPatientDetails.jsp?patient_id="+patientid+"&patient_name="+patientDetails.get(0)+"&sex="+patientDetails.get(1)+"&age="+patientDetails.get(2)+"&dispno="+dispno;
%>
					<script>parent.retmedicationremarksframe.location.href="<%=remarksUrl%>";
					parent.retmedicationplineframe.location.href="<%=patientUrl%>";</script>
					<TABLE width="99%" align="left" cellspacing=0 cellpadding=0 border=1>
						<TR>
							<TH width="15%" align="right"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type=checkbox name="SelectAll" id="SelectAll" id="SelectAll"  onClick="selectAll(this)"></th ><TH ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
							</th>
						</tr>
<%
						int rowCount=0;
						String classvalue="";
						int rc=drugDetails.size();
						for (int i=0;i<drugDetails.size();i+=3){ //Incremented from 2 to 3 for AMS-SCF-0190 IN038440 . 
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}
%>
							<TR>
							<!-- IF else condtions are Added for GHL_CRF-413.8 US001 start -->
								<%if(barcode_applicable.equals("Y")){ %>
								<TD  class=<%=classvalue%> align="right">
								<INPUT TYPE="Checkbox"  name="DrugSelect"  id="check_id<%=count1%>"  onClick="enableProceed(this)">
								<input type=hidden name="drugid"  id="drug_id<%=count1%>"  value="<%=drugDetails.get(i)%>">
								<input type=hidden name="barcodeid"  id="barcode_id<%=count1%>"  value="">
								</TD>
								<%}else{ %>
								<TD  class=<%=classvalue%> align="right">
								<INPUT TYPE="Checkbox"  name="DrugSelect" id="DrugSelect"  onClick="enableProceed(this)">
								<input type=hidden name="drugid" id="drugid" value="<%=drugDetails.get(i)%>">
								</TD>
								<%
								}
							%>
							<!-- IF else condtions are Added for GHL_CRF-413.8 US001 end -->
								<TD class=<%=classvalue%>  style="font-family:verdana;font-size:8pt;" >
									<%=drugDetails.get(i+1)%>
<%
								if(bean.getTradeName_Flag().equals("Y") && (drugDetails.get(i+2)!=null && !drugDetails.get(i+2).equals(""))){ //added for AMS-SCF-0190 IN038440
%>
									<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=drugDetails.get(i+2) %>)</label>
<%
								}
%>
								</TD>
							</TR>
<%                      // Added for GHL-CRF-413.8 Start
						if(barcode_applicable.equals("Y")){ 
	                        count1++; 
	                     } // Added for GHL-CRF-413.8 end
						}
						  // Added for GHL-CRF-413.8 Start
						if(barcode_applicable.equals("Y")){ 
%>
                        <input type="hidden" name="total_count" id="total_count"value="<%=count1-1%>">  
					<%}  %>   <!--  Added for GHL-CRF-413.8 end  --> 
					</TABLE>
<%
				}	// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - start
			}
			else if(FacilityFlag.equals("Y")){ 
				ArrayList drugDetails=bean.getDrugDetails(patientid,drugcode,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,encounter_id,locale,medn_rtn_after_bill_gen, blDocType, blDocNo, displocn);//code medn_rtn_after_bill_gen added for FD-JD-CRF-0178[IN039208]  // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958] //displocn added for SKR-SCF-1551
				//	out.println(drugDetails);
				if (drugDetails.size()==0){
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script> 
<%
				}
				else{	   
					/*out.println(drugDetails.get(0));
					if (5==5){
					  return;
					}*/
					
					ArrayList patientDetails=new ArrayList();
					patientDetails=bean.getPatientDetails(patientid);
					String remarksUrl="../../ePH/jsp/ReturnMedicationRemarks.jsp?"+request.getQueryString();
					String patientUrl="../../ePH/jsp/ReturnMedicationPatientDetails.jsp?patient_id="+patientid+"&patient_name="+patientDetails.get(0)+"&sex="+patientDetails.get(1)+"&age="+patientDetails.get(2)+"&dispno="+dispno;
%>
					<script>parent.retmedicationremarksframe.location.href="<%=remarksUrl%>";
					parent.retmedicationplineframe.location.href="<%=patientUrl%>";</script>
					<TABLE width="100%" align="right" cellspacing=0 cellpadding=0 border=1>
						<TR>
							<TH width="15%" align="right"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
							<input type=checkbox name="SelectAll" id="SelectAll" id="SelectAll"  onClick="selectAll(this)"></th ><TH ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
							</th>
						</tr>
<%
						int rowCount=0;
						String classvalue="";
						for (int i=0;i<drugDetails.size();i+=3){// Incremented from 2 to 3 for AMS-SCF-0190-IN038440 .
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}
%>
							<TR>
								<!-- IF else condtions are Added for GHL_CRF-413.8 US001 start -->
								<%if(barcode_applicable.equals("Y")){ %>
								<TD  class=<%=classvalue%> align="right">
								<INPUT TYPE="Checkbox"  name="DrugSelect" id="DrugSelect" id="check_id<%=count1%>"  onClick="enableProceed(this)">
								<input type=hidden name="drugid" id="drugid" id="drug_id<%=count1%>"  value="<%=drugDetails.get(i)%>">
								<input type=hidden name="barcodeid" id="barcodeid" id="barcode_id<%=count1%>"  value="">
								</TD>
								<%}else{ %>
								<TD  class=<%=classvalue%> align="right">
								<INPUT TYPE="Checkbox"  name="DrugSelect" id="DrugSelect"  onClick="enableProceed(this)">
								<input type=hidden name="drugid" id="drugid" value="<%=drugDetails.get(i)%>">
								</TD>
								<%
								}
							%>
							<!-- IF else condtions are Added for GHL_CRF-413.8 US001 end -->
								<TD class=<%=classvalue%>  style="font-family:verdana;font-size:8pt;" >
									<%=drugDetails.get(i+1)%>
<%
									if(bean.getTradeName_Flag().equals("Y") && (drugDetails.get(i+2)!=null && drugDetails.get(i+2).equals(""))){ //AMS-SCF-0190-IN038440 Trade Name set based on flag.
%>
										<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=drugDetails.get(i+2) %>)</label>
<%
									}
%>
								</TD>
							</TR>
<%
//Added for GHL-CRF-413.8 Start
if(barcode_applicable.equals("Y")){ 
    count1++; 
 } // Added for GHL-CRF-413.8 end
}

	if(barcode_applicable.equals("Y")){ //If condtion added for GHL-CRF-0413.8
%>
                        <input type="hidden" name="total_count" id="total_count"value="<%=count1-1%>">  
					<%}  %>   <!--  Added for GHL-CRF-413.8 end  --> 
	
					</TABLE>
<%
				}
			}	// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - End
%>
			<INPUT TYPE="hidden" name="dispLocn" id="dispLocn" VALUE="">

		</form>
<% 
		putObjectInBean(bean_id,bean,request); 
%>
	</body>
</html>

