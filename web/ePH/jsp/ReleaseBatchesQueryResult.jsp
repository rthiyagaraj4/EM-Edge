<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
        request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../js/ReleaseBatches.js"></script>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="frmReleaseBatchesResult" id="frmReleaseBatchesResult" >
<%
		try{
			//Search Criteria's from Query Criteria page
			String dt_from		= request.getParameter("dt_from");
			String dt_to		= request.getParameter("dt_to");
			String disp_locn	= request.getParameter("disp_locn");
			String called_frm	= request.getParameter("called_from");
			String batches		= request.getParameter("batches");
			String patient_id	= request.getParameter("patient_id");
			String drug_code	= request.getParameter("drug_code");
			String bl_installed_yn=CommonBean.checkForNull(request.getParameter("bl_installed_yn"));
			String paid_status	=CommonBean.checkForNull(request.getParameter("paid_status"));
			String disabled		=	"";
			String st1		=	"";
			String st2		=	"";
			String select_value = ""; // added for ML-BRU-SCF-0603 [IN:036245]
			
			if(patient_id == null) 
				patient_id="";

			String from			= CommonBean.checkForNull(request.getParameter("from"));
			String to			= CommonBean.checkForNull(request.getParameter("to"));
			String prevnext		= CommonBean.checkForNull(request.getParameter("prevnext"));

			String bean_id				= "ReleaseBatchesBean";
			String bean_name			= "ePH.ReleaseBatchesBean";
			ReleaseBatchesBean bean		= (ReleaseBatchesBean)getBeanObject( bean_id,bean_name,request);
			String facility_id					= (String) session.getValue("facility_id");
		
			if(called_frm!=null && called_frm.equals("search") && !prevnext.equals("prevnext")) {
				bean.clear();
			}
			bean.setLanguageId(locale);
			bean.setMode(CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			bean.setLanguageId(locale);
			ArrayList result			=	bean.getAllocatedRecords(dt_from, dt_to, disp_locn, from, to,patient_id,batches,drug_code,locale,paid_status,bl_installed_yn);
			String classValue			=	"";
			String check_status			=	"";
			String chk_value			=	"";
			String sel_rsn_code			=	"";
			String opt_sel				=	"";
			
			boolean flag=true;

			HashMap record_status		=	bean.getRecordStatus();
			HashMap rsn_cds				=	bean.getRsnCodes();
			ArrayList reason_codes		=	bean.getReasonCodes(locale);
			if(record_status != null && record_status.containsValue("Y")) // if block added for ML-BRU-SCF-0603 [IN:036245]
				select_value = "Y"; 
			
			String sAdmixChk="";//Added for SRR20056-SCF-7734 ICN 28022 - Start
			String sPrevOrderID="";
			String sPrevOrderLineNo="";
			String sIVPrepYN="";
			String sWorkSheetId="";
			String drug_count = "1";
			String sPrevAdmixOrderID = bean.getPrevAdmixOrderID();
			String sPrevAdmixReasonCode = bean.getPrevAdmixReasonCode();
			String sPrevAdmixWorkSheetId = bean.getPrevAdmixWorkSheetId();
			String incompleteAdmixFoundPrev = bean.getIncompleteAdmixFoundPrev();
			String incompleteAdmixORdID ="";
			String admixYN = "";//Added for SRR20056-SCF-7734 ICN 28022 - End
			if(result.size()<=1) {
%>
				<script language="javascript">
				    parent.f_batch_result.location.href = "../../eCommon/html/blank.html"; //Added for MMS ADHOC Testing
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
				return;
			}
%>
<!-- Display the Previous Next link -->
<% 
			if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ) && ( !( ((String) result.get(0)).equals("")) )){
%>
				<table cellpadding='0' cellspacing='0' align="center" id="nav_table" width="98%" BORDER='0'>
					<tr>
						<td width="75%" class="white">&nbsp;</td>
<%
							// For display the previous/next link
							out.println(result.get(0));
							System.err.println(result.get(0));
							//result.remove(0);
%>
					</tr>
				</table>
<%
			}
%>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center">
				<td class='COLUMNHEADER' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="ePH.AllocatedDrug.label" bundle="${ph_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="ePH.AllocatedBy.label" bundle="${ph_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="ePH.AllocatedDate.label" bundle="${ph_labels}"/></td>
<%
				if(bl_installed_yn.equals("Y")){
%>
					<td class='COLUMNHEADER' ><fmt:message key="Common.Paid.label" bundle="${common_labels}"/></td>
<%
				}
%>
				<td class='COLUMNHEADER' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				<input type="checkbox" name="Selcet_chk" id="Selcet_chk" value='' onClick="SelectAll(this)"></td>
<%	
				int rec_count	=	1;
				int row_val		=	0;
				int idrug_count = 1;
				for(int i=0; i<result.size();) {
					if(i==0)
						++i;
					if(row_val%2==0)
					   classValue = "QRYEVENSMALL";
					else
						classValue = "QRYODDSMALL";

					row_val++;
					check_status	=	"";
					chk_value		=	"N";
//Added for SRR20056-SCF-7734 ICN 28022 - Start
					sAdmixChk = "";
					sWorkSheetId	= (String)result.get(i+11);
					sIVPrepYN		=(String)result.get(i+12);
					drug_count = (String)result.get(i+13);
					idrug_count = Integer.parseInt(drug_count);
					if(sIVPrepYN.equals("0") || sIVPrepYN.equals("2") || sIVPrepYN.equals("4") || sIVPrepYN.equals("6") || sIVPrepYN.equals("8"))
						admixYN = "Y";
					else{
						admixYN = "N";
						drug_count = "1";
					}

					if(sIVPrepYN!=null && admixYN.equals("Y")){
						if(!sPrevOrderID.equals((String)result.get(i))){
							sPrevOrderID = (String)result.get(i);
						}
						if(!((String)result.get(i+1)).equals("1")){
							sAdmixChk = "disabled";
						}
					}

//Added for SRR20056-SCF-7734 ICN 28022 - End
					if(record_status.size()>0){
						if(((String)record_status.get((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10))!=null) && ((String)record_status.get((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10))).equals("Y") )  {
							check_status	=	"checked";
							chk_value		=	"Y";
						}
						else{ 
							flag=false;
						}
					}
					if(rsn_cds.size()>0){
						sel_rsn_code	=	(String)rsn_cds.get((String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10));
					}
					// Added for SRR20056-SCF-7734 ICN 28022 - Start
					if(sPrevAdmixOrderID!=null && sPrevAdmixOrderID.equals((String)result.get(i)) && sPrevAdmixWorkSheetId!=null && sPrevAdmixWorkSheetId.equals(sPrevAdmixWorkSheetId)){
						sel_rsn_code= sPrevAdmixReasonCode;
					}
					if (admixYN.equals("Y") && sPrevAdmixOrderID!=null && sPrevAdmixOrderID.equals((String)result.get(i))&& sPrevAdmixWorkSheetId!=null && sPrevAdmixWorkSheetId.equals((String)result.get(i+11))){
						check_status	=	"checked";
						chk_value		=	"Y";
					}
					/*else if ( sPrevAdmixWorkSheetId ==null  || sPrevAdmixWorkSheetId.equals("") ) {
						sel_rsn_code = "";
						check_status	=	"";
						chk_value		=	"N";
					}*/ //Commented for ML-BRU-SCF-0603 [IN:036245]
					if( chk_value ==null || !chk_value.equals("Y")) //if block added for ML-BRU-SCF-0603 [IN:036245]
						sel_rsn_code = "";

					// Added for SRR20056-SCF-7734 ICN 28022 - End
					if(sel_rsn_code==null || sel_rsn_code.equals("")){
						sel_rsn_code = "";
					}
%>
					<tr>
						<td class="<%=classValue%>"><%=(String)result.get(i+2)%></td>
						<td class="<%=classValue%>"><%=(String)result.get(i+3)%></td>
						<td class="<%=classValue%>">
<%
						if(((String)result.get(i+15)).equals("") || ((String)result.get(i+15)).equals("0")){ //Added if block and else condition for ML-BRU-SCF-0674 [IN:037567]
%>
							<%=(String)result.get(i+4)%>
<%
						}
						else{
%>
							<a id="docno_<%=rec_count%>" href="javascript:loadBatchDetails('<%=(String)result.get(i)%>','<%=(String)result.get(i+1)%>','<%=(String)result.get(i+4)%>','docno_<%=rec_count%>')"><%=(String)result.get(i+4)%></a>
<%
						}
%>
						</td>
						<td class="<%=classValue%>"><%=(String)result.get(i+6)%></td>
		<!-- <td class="<%=classValue%>"><%=(String)result.get(i+7)%></td> commented on 7/10/09-->
<%	
						StringTokenizer st =new StringTokenizer(result.get(i+7).toString(), " ");
						while (st.hasMoreTokens()){
							 st1 = st.nextToken();
							 st2 = st.nextToken();
						}
%> 
						<td class="<%=classValue%>" nowrap><%=st1%>  <%=bean.getUomDisplay(facility_id,st2)%></td> 
						<td class="<%=classValue%>"><%=(String)result.get(i+9)%></td>
						<td class="<%=classValue%>"><%=com.ehis.util.DateUtils.convertDate((String)result.get(i+8),"DMY","en",locale)%></td>
<%
						if(bl_installed_yn.equals("Y")){
							if(((String)result.get(i+14)).equals("N")){
								disabled="";
%>
								<td class="<%=classValue%>"><img src="../../eCommon/images/disabled.gif" align="center"></td>
<%
							}
							else{
								disabled="disabled";
%>
								<td class="<%=classValue%>"><img src="../../eCommon/images/enabled.gif" align="center"></td>
<%
							}
						}
//Added for SRR20056-SCF-7734 ICN 28022 - Start
						if(disabled.equals(""))
							disabled = sAdmixChk;
//Added for SRR20056-SCF-7734 ICN 28022 - End
%>
						<td class="<%=classValue%>" align="center">
						<select name="rcode_<%=(String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10)%>" id="rcode_<%=(String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10)%>" <%=disabled%> onchange="selectRsnAdmix('<%=(String)result.get(i)%>','<%=(String)result.get(i+1)%>','<%=(String)result.get(i+10)%>','<%=drug_count%>','<%=rec_count%>')" > <!-- selectRsnAdmix added for Added for SRR20056-SCF-7734 ICN 28022 -->	
							<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
<%
							if(reason_codes !=null && reason_codes.size()>0){
								for(int rc=0; rc<reason_codes.size();rc=rc+3){
									if(sel_rsn_code.equals((String)reason_codes.get(rc)+(String)reason_codes.get(rc+1)))
										opt_sel = "selected";
									else
										opt_sel = "";
%>
									<option value="<%=(String)reason_codes.get(rc)+(String)reason_codes.get(rc+1)%>" <%=opt_sel%>><%=(String)reason_codes.get(rc+2)%></option>
<%	 
								}
								if(flag==true){
%>
									<script>
										document.frmReleaseBatchesResult.Selcet_chk.checked=true;
									</script>
<%
								}
								else{
%>
									<script>
										document.frmReleaseBatchesResult.Selcet_chk.checked=false;
									</script>
<%
								}
							}
%>
						</select>
						</td>	
						<td class="<%=classValue%>" align="center">
							<input type="checkbox" id="check_id<%=rec_count%>" name="chk_<%=(String)result.get(i)+(String)result.get(i+1)+(String)result.get(i+10)%>" <%=check_status%> value="<%=chk_value%>" <%=disabled%> onClick="chkValue(this, '<%=drug_count%>', '<%=rec_count%>','<%=sWorkSheetId%>','<%=(String)result.get(i)%>','<%=(String)result.get(i+1)%>','<%=(String)result.get(i+10)%>' )"> <!-- chkValue params added for Added for SRR20056-SCF-7734 ICN 28022 -->
							<input type='hidden' name='iv_prep_yn<%=rec_count%>' id='iv_prep_yn<%=rec_count%>' value='<%=sIVPrepYN%>'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->
							<input type='hidden' name='workSheetid<%=rec_count%>' id='workSheetid<%=rec_count%>' value='<%=sWorkSheetId%>'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->
							<input type='hidden' name='doc_srl_no<%=rec_count%>' id='doc_srl_no<%=rec_count%>' value='<%=(String)result.get(i+10)%>'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->
							<input type='hidden' name='order_id<%=rec_count%>' id='order_id<%=rec_count%>' value='<%=(String)result.get(i)%>'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->
							<input type='hidden' name='disp_qty<%=rec_count%>' id='disp_qty<%=rec_count%>' value='<%=(String)result.get(i+15)%>'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->
							<input type='hidden' name='bms_qty<%=rec_count%>' id='bms_qty<%=rec_count%>' value='<%=(String)result.get(i+16)%>'> <!-- Added for SRR20056-SCF-7734 ICN 28022-->
						</td>
					</tr>
<%	
					rec_count++;

					if(bl_installed_yn.equals("Y"))
						 i+=17; //changed for SRR20056-SCF-7734 ICN 28022 -- changed from 15->17 for ML-BRU-SCF-0674 [IN:037567]
					else
						i+=18; //changed for SRR20056-SCF-7734 ICN 28022 --Changed from 16-18 for ML-BRU-SCF-0674 [IN:037567]
				} 
				// Added for SRR20056-SCF-7734 ICN 28022 - Start
				rec_count--;
				if(admixYN.equals("Y") && (idrug_count+rec_count > 11))
					incompleteAdmixORdID = sPrevOrderID;
				// Added for SRR20056-SCF-7734 ICN 28022 - End
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="mode" id="mode" value="<%=bean.getMode()%>">
			<input type="hidden" name="from" id="from" value="<%=from%>">
			<input type="hidden" name="to" id="to" value="<%=to%>">
			<input type="hidden" name="dt_from" id="dt_from" value="<%=dt_from%>">
			<input type="hidden" name="dt_to" id="dt_to" value="<%=dt_to%>">
			<input type="hidden" name="disp_locn" id="disp_locn" value="<%=disp_locn%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="called_from" id="called_from" value="<%=called_frm%>">
			<input type="hidden" name="batches" id="batches" value="<%=batches%>">
			<input type="hidden" name="bl_installed_yn" id="bl_installed_yn" value="<%=bl_installed_yn%>">
			<input type="hidden" name="paid_status" id="paid_status" value="<%=paid_status%>">
			<input type="hidden" name="prevnext" id="prevnext" value="">
			<input type="hidden" name="chk_" id="chk_" value="<%=rec_count%>">
			<!-- // Added for SRR20056-SCF-7734 ICN 28022 - Start -->
			<input type="hidden" name="incompleteAdmixFound" id="incompleteAdmixFound" value="">
			<input type="hidden" name="incompleteAdmixFoundPrev" id="incompleteAdmixFoundPrev" value="<%=incompleteAdmixFoundPrev%>">
			<input type="hidden" name="rec_count" id="rec_count" value="<%=rec_count%>">
			<input type="hidden" name="incompleteAdmixORdID" id="incompleteAdmixORdID" value="<%=incompleteAdmixORdID%>">
			<input type="hidden" name="PrevAdmixOrderID" id="PrevAdmixOrderID" value="<%=sPrevAdmixOrderID%>">
			<!-- // Added for SRR20056-SCF-7734 ICN 28022 - End -->
			<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
			<!-- // Added for SRR20056-SCF-7706 ICN IN027926 - End -->
			<input type="hidden" name="select_value" id="select_value" value="<%=select_value%>"> <!-- added for newly added for ML-BRU-SCF-0603 [IN:036245]-->
<% 			putObjectInBean(bean_id,bean,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
		</form>
	</body>
</html>

