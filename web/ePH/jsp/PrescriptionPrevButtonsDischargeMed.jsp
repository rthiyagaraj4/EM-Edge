<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,ePH.*,eOR.*,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
 		request.setCharacterEncoding("UTF-8"); 
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String patient_id=request.getParameter("pat_id");
		String pat_class	=	request.getParameter("pat_class");
		String ord_status	=	request.getParameter("ord_status");
		String order_from	=	request.getParameter("order_from");
		String order_to		=	request.getParameter("order_to");
		String pract_id		=	request.getParameter("pract_id");
		String order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String rx_type		=	request.getParameter("rx_type")==null?"":request.getParameter("rx_type");
		String encounter_id=request.getParameter("enc_id");
		String dur_val = "";
		String start_date="";
		String end_date="";
		String durn_desc="d";
		String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name	= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
		ArrayList selectedDetails  = bean.getSelecteddrugs();
		String ext_beanid = "@ExternalProductLinkBean";
		String ext_beanname = "ePH.ExternalProductLinkBean";
		String drug_db_duptherapy_flag="";
		HashMap drugDosageResult = null;
		ArrayList exProd				= new ArrayList();
		ArrayList drugDesc				= new ArrayList();
		String dup_drug_det			    = "";
		ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
		HashMap drugDBCheckResult = new HashMap(); 
		ArrayList extdbdetails = bean.checkdup();
		ArrayList reqChecks = new ArrayList();
		reqChecks.add("N"); //Dosage Check  
		reqChecks.add(extdbdetails.get(0)); //Duplicate Check
		reqChecks.add("N"); //DrugInteraction
		reqChecks.add("N"); //Contra Indication
		reqChecks.add("N"); //AllergyCheck
		if(selectedDetails!=null && selectedDetails.size()>0){
			dur_val = (String)selectedDetails.get(0);
			start_date = (String)selectedDetails.get(2);
			end_date = (String)selectedDetails.get(3);
			durn_desc =selectedDetails.get(1)==null?"d":(String) selectedDetails.get(1);
		}
		if(dur_val==null || dur_val.equals(""))
			dur_val = "1";  //changed from "" to "1" for ML-BRU-SCF-1349 [IN:049402]
		
		String ducheck ="";
		bean.setLanguageId(locale);
		//ArrayList selectedDetails=(ArrayList)bean.getCurrentSelectedDrugs();
		//String expected_date = bean.getExcpectedDate(patient_id);//Commented for ML-BRU-SCF-1349 [IN:049402]
		String defDates[] = bean.getExcpectedDate(patient_id); //Added for ML-BRU-SCF-1349 [IN:049402]
		String expected_date = defDates[0];//Added for ML-BRU-SCF-1349 [IN:049402]
		String commondatefrom="";
		String commondateto="";
		if(!locale.equals("en")){
			expected_date = DateUtils.convertDate(expected_date, "DMYHM","en",locale);
		}
		if(start_date!=null && start_date.trim().length()>0){
			if(!locale.equals("en")){
				start_date = DateUtils.convertDate(start_date, "DMYHM","en",locale);
				end_date = DateUtils.convertDate(end_date, "DMYHM","en",locale);
			}
			commondatefrom = start_date;
			commondateto  =  end_date;
		}
		else{
			commondatefrom = defDates[1];//changed from expected_date to defDates[1] for ML-BRU-SCF-1349 [IN:049402]
			commondateto   = defDates[2]; //changed from expected_date to defDates[2] for ML-BRU-SCF-1349 [IN:049402]
			if(!locale.equals("en")){ // if block Added for ML-BRU-SCF-1349 [IN:049402]
				commondatefrom = DateUtils.convertDate(commondatefrom, "DMYHM","en",locale);
				commondateto = DateUtils.convertDate(commondateto, "DMYHM","en",locale);
			}
		}
		int index = 0;
		String checkdupchk="N";
		ArrayList dischargepres	= bean.getPreviewOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to,order_id,rx_type,commondatefrom,commondateto);
		ArrayList discorders =bean.getdiscPrescriptions();//Added for IN048127--start
		for(int i=1;i<discorders.size();i+=2){
			String discdrugcode= (String)discorders.get(i);
			index = dischargepres.indexOf(discdrugcode);
			checkdupchk = (String)dischargepres.get(index+17);
				if(checkdupchk.equalsIgnoreCase("Y"))
					break;
			
		}//Added for IN048127--END
		for(int p=0; p<dischargepres.size(); p+=21) {
			exProd.add((String)dischargepres.get(p+19));
			drugDesc.add((String)dischargepres.get(p+4));
		}
		for(int i=0 ; i<dischargepres.size(); i+=21) {
			ducheck = (String)dischargepres.get(i+20);
			if(ducheck.equals("Y"))
				break;
		}
		for(int q=0; q<dischargepres.size(); q+=21){
			drugDBCheckResult = ext_beanObj.getExternalDBChecks( reqChecks, (String)dischargepres.get(q+19), patient_id, "", exProd ,drugDesc, null, "Y",commondatefrom,commondateto); 
			if(drugDBCheckResult != null && drugDBCheckResult.size() > 0){
	    		dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
			   if(dup_drug_det!=null && !dup_drug_det.equals("")){
					drug_db_duptherapy_flag="Y";
					break;
				}				
			}
		}
	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../ePH/js/Prescription_1.js"></script>
		<script language="Javascript" src="../../ePH/js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
		<form name="frmdischPrescriptionPrevButtons" id="frmdischPrescriptionPrevButtons">
			<table cellpadding="0" cellspacing="0"  width="100%" align="left" border='0'>
				<tr>
					<td colspan='3'style='text-align:right;' ><img src="../../eCommon/images/disabled.gif" id="Closebutton" height='15'  width='15' onclick="chktoRestore();"  title='Close Discharge Medication Copy' style="cursor:pointer;">&nbsp;</td>
				</tr>
				<tr><td colspan='3' >&nbsp;</td></tr>
				<tr>
					<td align="left" colspan='2' class="label"  nowrap><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
					<td class="label"  nowrap><input type="text" size="1" maxlength="3" name="durn_value" id="durn_value" value="<%=dur_val%>" class="NUMBER" onKeyPress="return(ChkNumberInput(this,event,'0'))" onchange="populateEndDateDisc(this);checkduplicatedisc();">&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
					<select name="durn_desc" id="durn_desc" id="durn_desc" onchange="populateEndDateDisc(this);checkduplicatedisc();">
						<option value="d" ><fmt:message key="Common.Day(s).label" bundle="${common_labels}"/></option> 
						<option value="w" ><fmt:message key="ePH.WEEKS.label" bundle="${ph_labels}"/></option>
						<option value="M" ><fmt:message key="ePH.MONTHS.label" bundle="${ph_labels}"/></option>
						<option value="Y" ><fmt:message key="ePH.years.label" bundle="${ph_labels}"/></option></td><!-- Added onKeyPress event for IN047958-->
					 </select>
				 </tr>
				 <tr>
					<td class="label" colspan='2' align="left"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
					<td nowrap class="label"  align="left"><input type="text" name="order_date_from" id="order_date_from" value="<%=commondatefrom%>" size="14"  maxlength="16" onBlur="validDateFormatDisc(this,'<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_from',null,'hh:mm'); " >&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
				</tr>
				<tr>
					<td class="label" colspan='2' align="left">
					<fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
					<td nowrap class="label"  align="left"><input type="text" name="order_date_to" id="order_date_to"   value="<%=commondateto%>" size="14"  maxlength="16" onBlur="validateEndDatedisc(this,'<%=locale%>');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('order_date_to',null,'hh:mm'); " >&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
					</td>
				</tr>	
<%              
				if(checkdupchk.equalsIgnoreCase("Y")&& ducheck!=null && ducheck.equals("Y")|| (drug_db_duptherapy_flag!=null && drug_db_duptherapy_flag.equalsIgnoreCase("Y"))){//Modified for BRU-HIMS-CRF-403// //Added checkdupchk for IN048127
%>				
					<tr>
						<td class="label" colspan='2' ><fmt:message key="ePH.OverrideReasons.label" bundle="${ph_labels}"/></td>
						<td class="label"><textarea rows="4" cols="30" name="dupOverRideReason" onKeyPress="javascript:if(event.keyCode != '32'){ return checkMaxLimit(this,255)};" ></textarea><img src="../../eCommon/images/mandatory.gif"  ></img></td>
					</tr>
<%
				}
%>
				<tr>
					<td class='label' colspan='2' nowrap><fmt:message key="ePH.ExpectedDisDate.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td class='label'><b><label align="left" id="exdate" nowrap><%=expected_date %></label></b></td>
				</tr>
				<tr ><td colspan='3'>&nbsp;</td></tr>
				<tr>
					<td nowrap width="3%"class="CURRENTRX">&nbsp;</td>
					<td class='label' colspan='2'>&nbsp;<label><fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/></label></td>
				</tr>
				<tr ><td colspan='3'>&nbsp;</td></tr>
				<tr ><td colspan='3'>&nbsp;</td></tr>
				<tr>
					<td class='label' colspan='3' style='text-align:center;'><input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="copieddiscDrugs()">&nbsp;&nbsp;
					<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="discCancel()"></td>
				</tr>
			</table>
			<input type="hidden" value="<%=bean_id%>" name="bean_id">
			<input type="hidden" value="<%= bean_name %>" name="bean_name">
		</form>
		<script>
			document.frmdischPrescriptionPrevButtons.durn_desc.value='<%=durn_desc%>';
		</script>
	</body>
</html>

