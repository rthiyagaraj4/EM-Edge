<!DOCTYPE html>

<!-- /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes st art --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*,java.sql.*,webbeans.eCommon.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCA/js/MedicationOrders.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	</head>
	<form name="MedicationOrdersResultform" id="MedicationOrdersResultform"><!--ADDED FOR IN070786 -->
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%

 //System.err.println("request.getQueryString()in Externaldrugs result============="+request.getQueryString());
	    String facility_id		=(String)session.getValue("facility_id");
		String patient_id	= request.getParameter("patient_id") ==null?"":request.getParameter("patient_id");
		String dt_from		= request.getParameter("from_date")==null?"":request.getParameter("from_date");
		String dt_to		= request.getParameter("to_date")==null?"":request.getParameter("to_date");
		String generic_id	= request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
		String drug_code	= request.getParameter("drug_id")==null?"":request.getParameter("drug_id");
		String pat_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");;
		String status		=	request.getParameter("status")==null?"":request.getParameter("status");
		String encounter_id	    =	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String req_facility_id		=	request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String pract_id		=	request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String selTab		=	request.getParameter("selTab")==null?"":request.getParameter("selTab");
		String order_type		=	request.getParameter("order_type")==null?"":request.getParameter("order_type");
		String date_order		=	request.getParameter("date_order")==null?"":request.getParameter("date_order");
		String type         = request.getParameter("item_type")==null?"D":request.getParameter("item_type");
		if(date_order.equals(""))
		    date_order ="D";
       
		String	bean_id			=	"MedicationOrdersBean" ;
		String	bean_name		=	"eCA.MedicationOrdersBean";
	     	
        String ADDED     =null;//Added for ML-MMOH-CRF-0510[IN060510] START
		Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TRANSCRIBED_BY");//Added for ML-MMOH-CRF-0510[IN060510] END
		boolean site1 = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","RECORD_CLINICAL_NOTES");//Added for AAKH-CRF-0088.2 [IN061987]
		
		MedicationOrdersBean bean = (MedicationOrdersBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		
		try{
		
			ArrayList result1=bean.getExternalDrugResults(locale, patient_id, encounter_id, pract_id, dt_from, dt_to, selTab, pat_class, req_facility_id, status, drug_code, generic_id,  date_order);
			//System.err.println();
		//System.out.println("result1"+result1);
			if(result1.size()>0){

%>
				
			 <div id='patinsID' style='height:358;overflow-y:auto;overflow-x:auto;position:relative;'>
				 <table id="ExternalId" border="1" cellpadding="0" cellspacing="0" width="100%"  >
					<tr style='height:40px;' style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
					     <th width ="1%"> </th>
						<th width ="10%" nowrap><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th>
						<th width ="25%" nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
						<th width ="10%" nowrap><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th><!--  //added generic name for AAKH-CRF-0088 [IN:060357] -->
						<th width ="10%" nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
						<!-- added for IN070786 start -->
						<th width ="10%" nowrap>Dosage</th>
						<th width ="10%" nowrap>Route</th>
						<th width ="10%" nowrap>Frequency</th>
						<!-- added for IN070786 end -->
						<th width ="10%" nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
						<th width ="35%" nowrap><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></th>
						<th width ="19%" nowrap><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th><!-- added for IN050551 -->
						<%if(site){ %>
						<th width ="30%" nowrap><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>  <%} %> <!--added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] -->
						<%if(site1 ){ %>
						<th width ="30%" nowrap><fmt:message key="Common.record.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/>&nbsp;</th> <%} %><!--added Record Clinical Notes for AAKH-CRF-0088.2 [IN061987] -->
						
					</tr>
<%
					String classvalue="";
					String access_num	= "";  // Added for AAKH-CRF-0088.2
					String srl_no	= "";  // Added for AAKH-CRF-0088.2
					for(int recCount=0; recCount<result1.size(); recCount++) {

						if ( recCount % 2 == 0 )
							classvalue = "QRYODDSMALL" ;
						else
							classvalue = "QRYEVENSMALL" ;

						ArrayList records1=(ArrayList) result1.get( recCount );

						String DRUG_CODE		= CommonBean.checkForNull((String)records1.get(0));
						String DRUG_DESC		= CommonBean.checkForNull((String)records1.get(1));
						String START_DATE		= CommonBean.checkForNull((String)records1.get(2));
						String END_DATE		    = CommonBean.checkForNull((String)records1.get(3));
						String PRACTITIONER		= CommonBean.checkForNull((String)records1.get(4));//added for IN050551
						String INSTRUCTIONS		= CommonBean.checkForNull((String)records1.get(5));
						String GENERICNAME		= CommonBean.checkForNull((String)records1.get(6));
						//added for IN070786 start
						String doase			=CommonBean.checkForNull((String)records1.get(12))+" "+CommonBean.checkForNull(bean.getUomDisplay(facility_id,(String)records1.get(13)));
						String route			=CommonBean.checkForNull((String)records1.get(14));
						String frequency			=CommonBean.checkForNull((String)records1.get(15));
						String frequency_nature=	CommonBean.checkForNull((String)records1.get(16));	
						
						//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]start
						if(site1){ // added for AAKH-CRF-0088.2
						   access_num	= CommonBean.checkForNull((String)records1.get(10));
						   srl_no           = CommonBean.checkForNull((String)records1.get(11));
						}	
						if(site){
						String prcid=CommonBean.checkForNull((String)records1.get(8));
					   String addid=CommonBean.checkForNull((String)records1.get(9));
					  
					/* if(prcid.equalsIgnoreCase(addid)){//COMMENTED FOR IN070786
						ADDED		= "";
					}
					else{ */
						ADDED		= CommonBean.checkForNull((String)records1.get(7));
					//}//added  and modified for IN070786
						}//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] end
						
						
%>
						<tr>
						    <td width ="1%"  id ='<%=START_DATE%>'></td>
							<td width ="10%" class="<%=classvalue%>" id="DRUG_CODE">&nbsp;&nbsp;<%=DRUG_CODE%></td>
							<td width ="25%" class="<%=classvalue%>" id="DRUG_DESC" STYLE='WORD-BREAK:BREAK-ALL;'><%=DRUG_DESC%></td><!-- added for IN070786 -->
							<td width ="10%" class="<%=classvalue%>" id="GENERIC_NAME" STYLE='WORD-BREAK:BREAK-ALL;'><%=GENERICNAME%></td><!--  //added generic name for AAKH-CRF-0088 [IN:060357] -->
							<td width ="10%"  class="<%=classvalue%>" id="START_DATE"><%=com.ehis.util.DateUtils.convertDate(START_DATE,"DMYHM","en",locale)%></td>
							<td width ="10%"  class="<%=classvalue%>" id="doase"><%=doase%></td><!-- added for IN070786 -->
							<td width ="10%"  class="<%=classvalue%>" id="route"><%=route%></td><!-- added for IN070786 -->
							<td width ="10%"  class="<%=classvalue%>" id="frequency"><%=frequency%></td><!-- added for IN070786 -->
							<input type="hidden" value="<%=frequency_nature%>" name="frequency_nature" /><!-- added for IN070786 -->
<%
							if(!END_DATE.equals("")){
%>
								<td width ="10%" class="<%=classvalue%>" id="END_DATE"><%=com.ehis.util.DateUtils.convertDate(END_DATE,"DMYHM","en",locale)%></td>
<%
							}
							else{
%>
								<td width ="10%" class="<%=classvalue%>" id="END_DATE">&nbsp;</td>
<%
							}
%>
							<td width ="35%" class="<%=classvalue%>" id="INSTRUCTIONS" STYLE='WORD-BREAK:BREAK-ALL;'><%=INSTRUCTIONS%></td>
							<td width ="19%" class="<%=classvalue%>" id="PRACTITIONER" STYLE='WORD-BREAK:BREAK-ALL;'><%=PRACTITIONER%></td><!--added for IN050551 -->
							<%if(site){%>
							<td width ="35%" class="<%=classvalue%>" id="ADDED_BY_ID" STYLE='WORD-BREAK:BREAK-ALL;'><%=ADDED%></td><!-- added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]-->
							<%}%>
							
							<%
							
								if((site1 && !access_num.equals(""))||(site1 &&  !encounter_id.equals(""))){ // added for AAKH-CRF-0088.2- Modified AAKH-CRF-0088.2  start IN[62946] %>
							<td width ="35%" class="<%=classvalue%>" id="CLINICAL_NOTES"><label style="cursor:pointer;color:blue" onclick="showClinicalNotes('<%=patient_id%>','<%=DRUG_CODE%>','<%=srl_no%>','<%=pat_class%>','<%=access_num%>','<%=facility_id%>','<%=encounter_id %>');"><fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/></label></td><!--added CLINICAL_NOTES for AAKH-CRF-0088.2 [IN061987]AAKH-CRF-0088.2  end IN[62946] -->
							<%}else{
								if(site1){%>
									
									<td width ="10%" class="<%=classvalue%>" >&nbsp;</td>
								<%}
									
								
								
							}%>
						</tr>
<%
					}
			}else{

%>
                    <script>
					//document.f_status_frame.location.href="../../eCommon/html/blank.html";
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				</script>
<% }
					%>
				</table> 
			</div>
			
<%
			
		} 
		catch(Exception e) {
			//out.print("Exception @ MedicationOrdersDrugResult :"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		//Added for ML-MMOH-CRF-0510[IN06051o] START
		finally{
			
			if(con != null)
				ConnectionManager.returnConnection(con,request);
		
		}
		//Added for ML-MMOH-CRF-0510[IN060510] END
%>
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">	<!-- added for IN070786 -->
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>"><!-- added for IN070786 -->	

	
						
	</body>
	</form><!-- ADDED FOR IN070786 -->
<% 
	putObjectInBean(bean_id,bean,request); 
%>
</html>

