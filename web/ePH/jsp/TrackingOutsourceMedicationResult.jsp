<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<HTML>
	<HEAD>
<%

request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/TrackingOutsourceMedication.js"></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	</HEAD>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="frmTrackingOutsourceMedicationResult" id="frmTrackingOutsourceMedicationResult" method='post'>
<%
		try{
				String	bean_id			=	"TrackingOutsourceMedicationBean" ;
				String	bean_name		=	"ePH.TrackingOutsourceMedicationBean";
				TrackingOutsourceMedicationBean bean = (TrackingOutsourceMedicationBean)getBeanObject(bean_id,bean_name ,request);
				String trackingAction = request.getParameter("trackingAction")==null?"":request.getParameter("trackingAction");
				String order_date_from = request.getParameter("order_date_from")==null?"":request.getParameter("order_date_from");
				String order_date_to = request.getParameter("order_date_to")==null?"":request.getParameter("order_date_to");
				String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
				String order_type = request.getParameter("order_type")==null?"":request.getParameter("order_type");
				String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
				String from	= CommonBean.checkForNull(request.getParameter("from"));
				String to	= CommonBean.checkForNull(request.getParameter("to"));
				String login_facility_id = (String)session.getValue( "facility_id" );
				bean.setTrackingAction(trackingAction);
				bean.setOrderType(order_type);
				if(!locale.equals("en")){
					order_date_from = com.ehis.util.DateUtils.convertDate(order_date_from,"DMY",locale,"en");
					order_date_to = com.ehis.util.DateUtils.convertDate(order_date_to,"DMY",locale,"en");
				}
				ArrayList alTrackingDetails =bean.queryTrackingDetails(trackingAction, order_date_from, order_date_to,patient_id,drug_code,from,to );
				if(alTrackingDetails==null || alTrackingDetails.size()<=1){
%>
					<script language="javascript">
						parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"); 
						displayResult('N', '<%=called_from%>', '<%=trackingAction%>');
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
				}
				else{
%>
					<script>
						displayResult('Y', '<%=called_from%>', '<%=trackingAction%>');
					</script>
<%
					String currPatId, prevPatID="", patName, classvalue="", gender, age, sourceType="", drug_view, encounterId, genericId, drugCode, orderStatusType, orderId, orderLineNum, key="", selected="", selected_val="", patientClass="", outsourceId="", drugName="", remarks="", outsourced_pract_name="";
					String ipLocnLookupSql ="", opLocnLookupSql="", userLookupSql="", deliverToInd="", deliverTo="", deliverToName="", delverToTitle="", deliverSource="", deliverSourceCode="";
					int selectedCount=0;
					HashMap hmTrackingDetails = null;
					if( (alTrackingDetails.size()>=2) && ( !( ((String) alTrackingDetails.get(0)).equals("0")) ) && ( !( ((String) alTrackingDetails.get(0)).equals("")) )){
%>
						<table cellpadding=0 cellspacing=0 width="100%" align="center">
							<tr>
								<td width="78%" class="white">&nbsp;</td>
								<td width="20%" class="white">&nbsp;
<%
									out.println(alTrackingDetails.get(0));// For display the previous/next link
%>
								</td>
								<td width="2%" class="white">&nbsp;
							</tr>
						</table>
<% 
					}
					else{
%>
						 <table cellpadding=0 cellspacing=0 width="100%" align="center">
							<tr>
								<td width="78%" class="white">&nbsp;</td>
							</tr>
						</table>
<%
					}
%>
					<table cellpadding='0' cellspacing='0' width="99%" align="center" border='1'>
						<tr >
							<td class="COLUMNHEADER" width="*%" nowrap><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" width="10%" nowrap><fmt:message key="ePH.OrderedDate.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADER" width="15%" nowrap><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
							<td class="COLUMNHEADER" width="15%" nowrap><fmt:message key="ePH.OrderedPractitioner.label" bundle="${ph_labels}"/></td>
<%
							if(trackingAction.equals("R")){
%>
								<td class="COLUMNHEADER" width="10%" nowrap><fmt:message key="ePH.Outsource.label" bundle="${ph_labels}"/></td>
								<td class="COLUMNHEADER" width="10%" nowrap><fmt:message key="Common.received.label" bundle="${common_labels}"/></td>
<%
							}
							else if(trackingAction.equals("D")){
								ipLocnLookupSql = " SELECT NURSING_UNIT_CODE code, SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW WHERE  eff_status='E' and FACILITY_ID='"+login_facility_id+"' and LANGUAGE_ID='"+locale+"'  and upper(NURSING_UNIT_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2";
								opLocnLookupSql = " SELECT CLINIC_CODE code, SHORT_DESC description FROM OP_CLINIC_LANG_VW WHERE eff_status='E' and FACILITY_ID='"+login_facility_id+"' and LANGUAGE_ID='"+locale+"' and upper(CLINIC_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by 2";

								userLookupSql ="SELECT  appl_user_id code, appl_user_name description FROM sm_appl_user a, am_practitioner b WHERE b.eff_status='E' AND language_id = '"+locale+"' and A.APPL_USER_ID = B.PRACTITIONER_ID and ( (trunc(b.eff_date_from) <= trunc(sysdate) and b.eff_date_to is null )  or (trunc(b.eff_date_to) >= trunc(sysdate) and b.eff_date_from is null)  or (b.eff_date_from is null and b.eff_date_to is null ) or (trunc(sysdate) between trunc(b.eff_date_from) and trunc(b.eff_date_to) and b.eff_date_from is not null and b.eff_date_to is not null)) and   b.pract_type IN ('NS', 'MD', 'DN', 'PH') AND UPPER (appl_user_id) LIKE UPPER (?) AND UPPER (appl_user_name) LIKE UPPER (?) ORDER BY 2";
%>
								<td class="COLUMNHEADER" width="8%" nowrap><fmt:message key="ePH.Outsource.label" bundle="${ph_labels}"/></td>
								<td class="COLUMNHEADER" width="8%" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
								<td class="COLUMNHEADER" width="20%" nowrap><fmt:message key="ePH.Deliver.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
<%
							}
%>
							<td class="COLUMNHEADER" width="7%" nowrap><fmt:message key="Common.Select.label" bundle="${common_labels}"/>&nbsp;

<%
							if(!trackingAction.equals("R")){
%>
								<input type='checkbox' name='selectAll' id='selectAll' value='' onclick="selectALL(this)"></td>	
<%
							}
%>
						</tr>
<%	
						HashMap hmSel_TrackingDetails = bean.getTrackingDetails();
						HashMap hmTrackingDetail = null;
						ArrayList alPatTackingDtls = null;
						int patDtlColspan=5;
						for(int i=1; i<alTrackingDetails.size(); i++){
							hmTrackingDetails = (HashMap)alTrackingDetails.get(i);
							if(hmTrackingDetails!=null && hmTrackingDetails.size()>0){
								if(i%2==0)
									classvalue = "QRYEVENSMALL";
								else
									classvalue = "QRYODDSMALL";
								currPatId = (String)hmTrackingDetails.get("PATIENT_ID");
								sourceType = (String)hmTrackingDetails.get("SOURCE_TYPE");
								encounterId = (String)hmTrackingDetails.get("ENCOUNTER_ID");
								drugCode = (String)hmTrackingDetails.get("DRUG_CODE");
								drugName = (String)hmTrackingDetails.get("DRUG_DESC");
								genericId = (String)hmTrackingDetails.get("GENERIC_ID");
								orderId = (String)hmTrackingDetails.get("ORDER_ID");
								orderLineNum = (String)hmTrackingDetails.get("ORDER_LINE_NUM");
								orderStatusType = (String)hmTrackingDetails.get("ORDER_STATUS_TYPE");
								remarks = "";
								patientClass="";
								outsourceId = (String)hmTrackingDetails.get("OUTSOURCE_ID")==null?"":(String)hmTrackingDetails.get("OUTSOURCE_ID");
								drug_view		=	"onClick=\"callMenuFunctions('View','Pharmacy','"+currPatId+"','"+encounterId+"','"+orderId+"','"+orderLineNum+"','"+orderStatusType+"','','PH','"+drugCode+"','"+genericId+"')\"  style='cursor:pointer;color:blue'";
								key="";
								selected="";
								selected_val = "N";
								delverToTitle = "";
								if(trackingAction.equals("D")){
									patientClass = hmTrackingDetails.get("PATIENT_CLASS")==null?"":(String)hmTrackingDetails.get("PATIENT_CLASS");
									deliverTo = hmTrackingDetails.get("DELIVERED_TO")==null?"":(String)hmTrackingDetails.get("DELIVERED_TO");
									deliverToInd = hmTrackingDetails.get("DELIVERED_TO_IND")==null?"L":(String)hmTrackingDetails.get("DELIVERED_TO_IND");
									deliverToName = hmTrackingDetails.get("DELIVERED_TO_NAME")==null?"":(String)hmTrackingDetails.get("DELIVERED_TO_NAME");
									outsourced_pract_name = hmTrackingDetails.get("OUTSOURCED_PRACT_NAME")==null?"":(String)hmTrackingDetails.get("OUTSOURCED_PRACT_NAME");
									deliverSourceCode =hmTrackingDetails.get("DELIVERED_SOURCE_CODE")==null?"":(String)hmTrackingDetails.get("DELIVERED_SOURCE_CODE");
									deliverSource = hmTrackingDetails.get("DELIVERED_SOURCE_DESC")==null?"":(String)hmTrackingDetails.get("DELIVERED_SOURCE_DESC");
									if(deliverTo.equals(""))
										deliverTo = (String)hmTrackingDetails.get("DELIVERED_SOURCE_CODE");
									if(deliverToInd.equals("L"))
										delverToTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Deliver.label", "ph_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.to.label", "common_labels")+": "+deliverTo+" / "+deliverToName;
								}
								if(trackingAction.equals("S")){
									key = orderId+"~"+orderLineNum;
									if(hmSel_TrackingDetails!=null && hmSel_TrackingDetails.containsKey(currPatId))
										alPatTackingDtls = (ArrayList)hmSel_TrackingDetails.get(currPatId);
									if(alPatTackingDtls!=null && alPatTackingDtls.contains(key)){
										selected = "checked";
										selected_val="Y";
										selectedCount++;
									}
								}
								else{
									key = outsourceId+"~"+orderId+"~"+orderLineNum;
									if(hmSel_TrackingDetails.containsKey(key)){
										selected = "checked";
										selected_val="Y";
										selectedCount++;
										if(trackingAction.equals("D")){
											hmTrackingDetail = (HashMap)hmSel_TrackingDetails.get(key);
											patientClass = hmTrackingDetail.get("PATIENT_CLASS")==null?"":(String)hmTrackingDetail.get("PATIENT_CLASS");
											deliverTo = hmTrackingDetail.get("DELIVERED_TO")==null?"":(String)hmTrackingDetail.get("DELIVERED_TO");
											deliverToInd = hmTrackingDetail.get("DELIVERED_TO_IND")==null?"L":(String)hmTrackingDetail.get("DELIVERED_TO_IND");
											deliverToName = hmTrackingDetail.get("DELIVERED_TO_NAME")==null?"":(String)hmTrackingDetail.get("DELIVERED_TO_NAME");
											outsourced_pract_name = hmTrackingDetail.get("OUTSOURCED_PRACT_NAME")==null?"":(String)hmTrackingDetail.get("OUTSOURCED_PRACT_NAME");
											deliverSourceCode =hmTrackingDetail.get("DELIVERED_SOURCE_CODE")==null?"":(String)hmTrackingDetail.get("DELIVERED_SOURCE_CODE");
											deliverSource = hmTrackingDetail.get("DELIVERED_SOURCE_DESC")==null?"":(String)hmTrackingDetail.get("DELIVERED_SOURCE_DESC");
											if(deliverTo.equals("")){
												deliverTo = (String)hmTrackingDetails.get("DELIVERED_SOURCE_CODE");
											}
											if(deliverToInd.equals("O"))
												delverToTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Deliver.label", "ph_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.to.label", "common_labels")+": "+deliverTo+" / "+deliverToName;
										}
									}
								}
								if(hmSel_TrackingDetails.containsKey(key)){
									selected = "checked";
									selected_val="Y";
									selectedCount++;
								}
								if(!currPatId.equals(prevPatID)){
									prevPatID = currPatId;
									patName = (String)hmTrackingDetails.get("PATIENT_NAME");
									age = (String)hmTrackingDetails.get("AGE");
									gender = (String)hmTrackingDetails.get("SEX");
									if(trackingAction.equals("R"))
										patDtlColspan=7;
									else if(trackingAction.equals("D"))
										patDtlColspan=8;
%>
									<tr>
										<td class="commontoolbarfunction" style='color:black;font-size:10;font-weight:bold' colspan='<%=patDtlColspan%>'>&nbsp;<label style='color:blue;cursor:pointer;' onClick="showDrugProfile('<%=currPatId%>','<%=bean.getDispLocnCode()%>')"><%=currPatId%></label> &nbsp;:&nbsp;<%=patName%>&nbsp;,&nbsp;<%=gender%>&nbsp;,&nbsp;<%=age%> </th>
									</tr>
<%
								}
%>
								<tr>
									<td class='<%=classvalue%>' nowrap>&nbsp;<label style='color:blue;cursor:pointer;' <%=drug_view%>><%=drugName%></label></td>
									<td class='<%=classvalue%>' nowrap>&nbsp;<%=com.ehis.util.DateUtils.convertDate((String)hmTrackingDetails.get("ORD_DATE_TIME"),"DMYHM","en",locale)%></td>
									<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)hmTrackingDetails.get("SOURCE_DESC")%>&nbsp;
<%
									if(sourceType.equals("C") || sourceType.equals("E")){
%>
										<b>/</b>&nbsp;<fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
<%
									}
									else if(sourceType.equals("N")){
%>
										<b>/</b>&nbsp;<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
<%
									}
%>
									</td>
									<td class='<%=classvalue%>' nowrap>&nbsp;<%=(String)hmTrackingDetails.get("PRACTITIONER_NAME")%></td>
<%
									if(trackingAction.equals("R")){
										remarks = (String)hmTrackingDetails.get("OUTSOURCED_REMARKS")==null?"":(String)hmTrackingDetails.get("OUTSOURCED_REMARKS");
										outsourced_pract_name = (String)hmTrackingDetails.get("OUTSOURCED_PRACT_NAME")==null?"":(String)hmTrackingDetails.get("OUTSOURCED_PRACT_NAME");
%>
										<td class='<%=classvalue%>' style='text-align:center;' nowrap><label style='color:blue;cursor:pointer;' onclick='viewSentDtls("<%=i%>");'><fmt:message key="Common.details.label" bundle="${common_labels}"/></label></td>
										<td class='<%=classvalue%>' style='text-align:center;' nowrap><label style='color:blue;cursor:pointer;' onclick='editReceiveDtls("<%=i%>");'><fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img></label></td>
										<input type='hidden' name='receiveDtl<%=i%>' id='receiveDtl<%=i%>' value='N'> 
<%
									}
									else if(trackingAction.equals("D")){
%>
										<td class='<%=classvalue%>' style='text-align:center;' nowrap><label style='color:blue;cursor:pointer;' onclick='viewOutsourceDtls("<%=outsourceId%>","<%=orderId%>","<%=orderLineNum%>");'><fmt:message key="Common.details.label" bundle="${common_labels}"/></label></td>
										<td class='<%=classvalue%>'  nowrap>
											<input type='text' name='deliverSource<%=i%>' id='deliverSource<%=i%>' value = '<%=deliverSource%>' onBlur="searchLocation('<%=i%>','TEXT');" /><input type="button" name="locn_search" id="locn_search" value="?" class="button"  onClick="searchLocation('<%=i%>','BUTTON');">&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
											<input type='hidden' name='deliverSourceCode<%=i%>' id='deliverSourceCode<%=i%>' value = '<%=deliverSourceCode%>' /> 
										</td>
										<td class='<%=classvalue%>'  nowrap>
<%
											if(deliverToInd.equals("L")){
%>
												<input type='radio' name='deliverToInd<%=i%>' id='deliverToInd<%=i%>' value='L' onclick='changeDeliverTo(this,"<%=i%>");' checked/><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
<%
											}
											else{
%>
												<input type='radio' name='deliverToInd<%=i%>' id='deliverToInd<%=i%>' value='L' onclick='changeDeliverTo(this,"<%=i%>");'/><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
<%
											}
											if(deliverToInd.equals("P")){
%>
												<input type='radio' name='deliverToInd<%=i%>' id='deliverToInd<%=i%>' value='P' onclick='changeDeliverTo(this,"<%=i%>");' checked/><fmt:message key="Common.patient.label" bundle="${common_labels}"/>
<%
											}
											else{
%>
											<input type='radio' name='deliverToInd<%=i%>' id='deliverToInd<%=i%>' value='P' onclick='changeDeliverTo(this,"<%=i%>");'/><fmt:message key="Common.patient.label" bundle="${common_labels}"/>
<%
											}
%>
											<label id='deliverOthers<%=i%>' title='<%=delverToTitle%>'>
<%
												if(deliverToInd.equals("O")){
%>
													<input type='radio' name='deliverToInd<%=i%>' id='deliverToInd<%=i%>' value='O' onclick='changeDeliverTo(this,"<%=i%>");'  checked/><fmt:message key="Common.others.label" bundle="${common_labels}"/> </label>
<%
												}
												else{
%>
													<input type='radio' name='deliverToInd<%=i%>' id='deliverToInd<%=i%>' value='O' onclick='changeDeliverTo(this,"<%=i%>");'/><fmt:message key="Common.others.label" bundle="${common_labels}"/> 
<%
												}
%>
											</label>
										</td>
<%
									}
%>
									<td class='<%=classvalue%>' style='text-align:center;' nowrap> <input type='checkbox' name='select<%=i%>' id='select<%=i%>' value='<%=selected_val%>' <%=selected%> onclick="selectDrug(this,'<%=i%>');"></td>
								</tr>
								<input type='hidden' name='outsourceId<%=i%>' id='outsourceId<%=i%>' value='<%=outsourceId%>'/>
								<input type='hidden' name='outsourced_by<%=i%>' id='outsourced_by<%=i%>' value='<%=(String)hmTrackingDetails.get("OUTSOURCED_BY")%>'/>
								<input type='hidden' name='outsourced_date<%=i%>' id='outsourced_date<%=i%>' value='<%=com.ehis.util.DateUtils.convertDate((String)hmTrackingDetails.get("OUTSOURCED_DATE"),"DMYHM","en",locale)%>'/>
								<input type='hidden' name='outsourced_pract_name<%=i%>' id='outsourced_pract_name<%=i%>' value='<%=java.net.URLEncoder.encode(outsourced_pract_name,"UTF-8")%>'/>
								<input type='hidden' name='facility_id<%=i%>' id='facility_id<%=i%>' value='<%=(String)hmTrackingDetails.get("FACILITY_ID")%>'/>
								<input type='hidden' name='remarks<%=i%>' id='remarks<%=i%>' value='<%=java.net.URLEncoder.encode(remarks,"UTF-8")%>'/>
								<input type='hidden' name='patientId<%=i%>' id='patientId<%=i%>' value='<%=currPatId%>'/>
								<input type='hidden' name='orderId<%=i%>' id='orderId<%=i%>' value='<%=(String)hmTrackingDetails.get("ORDER_ID")%>'/>
								<input type='hidden' name='orderLineNum<%=i%>' id='orderLineNum<%=i%>' value='<%=(String)hmTrackingDetails.get("ORDER_LINE_NUM")%>'/>
								<input type='hidden' name='drugCode<%=i%>' id='drugCode<%=i%>' value='<%=(String)hmTrackingDetails.get("DRUG_CODE")%>'/>
								<input type='hidden' name='sourceType<%=i%>' id='sourceType<%=i%>' value='<%=(String)hmTrackingDetails.get("SOURCE_TYPE")%>'/>
								<input type='hidden' name='sourceCode<%=i%>' id='sourceCode<%=i%>' value='<%=(String)hmTrackingDetails.get("SOURCE_CODE")%>'/>
								<input type='hidden' name='ordPractId<%=i%>' id='ordPractId<%=i%>' value='<%=(String)hmTrackingDetails.get("ORD_PRACT_ID")%>'/>
								<input type='hidden' name='orderingFacilityId<%=i%>' id='orderingFacilityId<%=i%>' value='<%=(String)hmTrackingDetails.get("ORDERING_FACILITY_ID")%>'/>
								<input type='hidden' name='deliverTo<%=i%>' id='deliverTo<%=i%>' value='<%=deliverTo%>'/>
								<input type='hidden' name='deliverToName<%=i%>' id='deliverToName<%=i%>' value='<%=deliverToName%>'/>
								<input type='hidden' name='deliverToIndr<%=i%>' id='deliverToIndr<%=i%>' value='<%=deliverToInd%>'/>
								<input type='hidden' name='deliverToIndicator<%=i%>' id='deliverToIndicator<%=i%>' value='<%=deliverToInd%>'/>
<%
						}
					}
%>
					</table>
					<input type="hidden" name="from" id="from" value="">
					<input type="hidden" name="to" id="to" value="">
					<input type="hidden" name="trackingAction" id="trackingAction" value="<%=trackingAction%>">
					<input type="hidden" name="order_date_from" id="order_date_from" value="<%=order_date_from%>">
					<input type="hidden" name="order_date_to" id="order_date_to" value="<%=order_date_to%>">
					<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
					<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
					<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
					<input type='hidden' name='recCount' id='recCount' value='<%=alTrackingDetails.size()-1%>'/>
					<input type='hidden' name='language_id' id='language_id' value='<%=locale%>'/>
					<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
					<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
					<input type="hidden" name="selectedCount" id="selectedCount" value="<%=selectedCount%>">
					<input type="hidden" name="opLocnLookupSql" id="opLocnLookupSql" value="<%=opLocnLookupSql%>">
					<input type="hidden" name="ipLocnLookupSql" id="ipLocnLookupSql" value="<%=ipLocnLookupSql%>">
					<input type="hidden" name="userLookupSql" id="userLookupSql" value="<%=userLookupSql%>">
					<input type="hidden" name="login_facility_id" id="login_facility_id" value="<%=login_facility_id%>">
<%
					if(selectedCount == (alTrackingDetails.size()-1)){
%>
						<script>
							document.frmTrackingOutsourceMedicationResult.selectAll.checked = true;
							document.frmTrackingOutsourceMedicationResult.selectAll.value = "Y";
						</script>
<%
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
%>
		</form>
	</BODY>
</HTML>

