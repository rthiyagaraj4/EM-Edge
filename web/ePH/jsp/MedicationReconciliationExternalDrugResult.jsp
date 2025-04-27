<!DOCTYPE html>
<% /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
18/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- JSP Page specific attributes st art --%>
<%@page import="eOR.OrderEntryBean"%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,java.sql.*,webbeans.eCommon.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../js/MedicationReconciliation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="frmExternalOrdersResult1" id="frmExternalOrdersResult1">
<%
		String facility_id		=(String)session.getValue("facility_id"); // facility_id added for AAKH-CRF-0088.2
		String patient_id	= request.getParameter("patient_id");	
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"); // encounter_id added for AAKH-CRF-0088.2
	    if(encounter_id.equals("null"))
		  encounter_id="";
		String dt_from	    = CommonBean.checkForNull(request.getParameter("dt_from"));
		String dt_to	    = CommonBean.checkForNull(request.getParameter("dt_to"));		
		String bean_id			=	"QueryPatientDrugProfileBean" ;
		String bean_name		=	"ePH.QueryPatientDrugProfileBean";
        String ADDED     =null;		
        String log_pract_id =request.getParameter("log_pract_id")==null?"":request.getParameter("log_pract_id");
        String drug_priv_appln_yn			= (String) session.getValue("PrivilegeApplicability");
		if ( drug_priv_appln_yn == null || drug_priv_appln_yn.equals("")) 
			drug_priv_appln_yn = "N";
        
		QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		String or_bean_name				= "eOR.OrderEntryBean";
		String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
		orbean.setLanguageId(locale);
		
		String bean_id1		= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name1	= "ePH.PrescriptionBean_1";
		
		PrescriptionBean_1 bean1		= (PrescriptionBean_1)getBeanObject( bean_id1,bean_name1,request );
		String no_ext_drug=CommonBean.checkForNull((String)bean1.extDrugApplicableYN(patient_id,encounter_id));//added for IN070786
		
		String disabled		=	"";
		String checked = ""; // Added for Inc#70652
		String checked_no_ext="";//added for IN070786
		String disabled_no_ext="";//added for IN070786
		boolean found			=  false; 
		//added for IN070786 start
		if(no_ext_drug.equals("Y")){
			checked_no_ext="checked";
			disabled_no_ext="disabled";
		}
		else
		{
			checked_no_ext="";
			disabled_no_ext="";
		}
				//added for IN070786 end
		String p_resp_id = orbean.getResponsibilityId();
		try{

			HashMap funcMap1 = new HashMap();
			HashMap sqlMap1 = new HashMap();
			//modified for IN070786
			String drugprofile="SELECT A.DRUG_CODE,A.DRUG_DESC,TO_CHAR(A.START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(A.END_DATE,'DD/MM/YYYY HH24:MI') END_DATE, A.practitioner_name,A.INSTRUCTIONS,(SELECT GENERIC_NAME FROM PH_DRUG_VW WHERE DRUG_CODE=A.DRUG_CODE) GENERIC_NAME,am_get_desc.am_practitioner (a.added_by_id,?,'1')ADDED,A.ADDED_BY_ID,A.PRACTITIONER_ID,A.ACCESSION_NUM,A.SRL_NO,or_get_priv_appl_yn (?, ?, 'OR', a.drug_code, ?, '', 'PH' ) priv_appl_yn,a.qty_value,A.QTY_DESC,(SELECT route_desc FROM ph_drug_vw  WHERE drug_code = A.drug_code) route_desc, (SELECT FREQ_DESC FROM AM_FREQUENCY WHERE FREQ_CODE = A.FREQUENCY)FREQ_DESC,(SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE = A.FREQUENCY) FREQ_NATURE FROM PH_PATIENT_EXT_DRUG_PROFILE A WHERE A.PATIENT_ID  = ? and A.START_DATE BETWEEN  NVL (TO_DATE (?,'DD/MM/YYYY'),sysdate-30) AND  NVL (TO_DATE (?,'DD/MM/YYYY'),sysdate+30 )+ 0.99999  ORDER BY A.START_DATE DESC";//<!--am_practitioner_lang_vw table added for IN050551 -->added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]  // A.ACCESSION_NUM,SRL_NO added for AAKH-CRF-0088.2			
//+ 0.99999 ADDED FOR PMG ISSUES
			sqlMap1.put( "sqlData",drugprofile);

			ArrayList displayFields1 = new ArrayList();
			displayFields1.add("DRUG_CODE");  
			displayFields1.add("DRUG_DESC");  
			displayFields1.add("START_DATE");  
			displayFields1.add("END_DATE");
			displayFields1.add("PRACTITIONER_NAME"); 
			displayFields1.add("INSTRUCTIONS");  
			displayFields1.add("GENERIC_NAME"); 					
			displayFields1.add("ADDED");           
			displayFields1.add("ADDED_BY_ID");
			displayFields1.add("PRACTITIONER_ID");
			displayFields1.add("PRIV_APPL_YN");	
			displayFields1.add("SRL_NO");
			displayFields1.add("QTY_VALUE"); //added for IN070786
		    displayFields1.add("QTY_DESC"); //added for IN070786
			displayFields1.add("ROUTE_DESC"); //added for IN070786
		    displayFields1.add("FREQ_DESC"); //added for IN070786
		    displayFields1.add("FREQ_NATURE"); //added for IN070786
			if(dt_from.equals(""))
				dt_from="01/01/1998";
			ArrayList chkFields1 = new ArrayList();
			chkFields1.add(locale); 
		    chkFields1.add( log_pract_id );
			chkFields1.add( p_resp_id );
			chkFields1.add( drug_priv_appln_yn);
			chkFields1.add( patient_id.trim() );
			chkFields1.add( dt_from );
			chkFields1.add( dt_to );
			//chkFields1.add(locale);  commented for MMS-KH-CRF-0016.1

			funcMap1.put( "displayFields", displayFields1 );
			funcMap1.put( "chkFields", chkFields1 );
		  
			ArrayList result1=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap1,funcMap1,request);
			int count=Integer.parseInt((String)result1.get(0));//ADDED FOR IN070786
			//System.err.println("result1"+dt_from);
		//	if(result1.size()<3){//commented for IN070786
			%>
					<!--	<script> -->
						<!--	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common')); -->
						<!--</script>-->
			<%
					//	return;
			//}
			%>
<!-- ADDED FOR IN070786  START-->
			
						
			<!-- ADDED FOR IN070786  END-->
			 <div id='patinsID' style='height:100%;overflow-y:no;overflow-x:no'>
				 <table id="ExternalId" border="1" cellpadding="0" cellspacing="0" width="100%"  >
				 	<tr style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>				 	
				 		<th  align="right"  class="button" colspan="6">No External Drug
			  			<%if(count>0){ %>
							<input type="checkbox" name="no_external_drug" id="no_external_drug" value="N" onClick="ExternalDrug(this)" disabled />
						<%}else{//checked_no_ext added for mms-kh-crf-0016.1
				 		%>
							<input type="checkbox" name="no_external_drug" id="no_external_drug" value="Y" onClick="ExternalDrug(this)"  <%=checked_no_ext%>/>
						<%} %>
						</th>
				 		<th align="right" colspan="6"><input type="button" class="button" name="ADDDRUGS" id="ADDDRUGS"  value='<fmt:message key="ePH.ADDEXTERNALDRUG.label" bundle="${ph_labels}"/>'  onClick="AddDrugsPage('<%=patient_id%>','<%=dt_from%>','<%=dt_to%>')" <%=disabled_no_ext%> ></th><!-- disabled_no_ext added for mms-kh-crf-0016.1-->				 	
				 	</tr>
					<tr style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
					    <th nowrap width="1%" style="font-size:10"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
						<th nowrap width="1%" style="font-size:10"><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th>
						<th nowrap width="1%" style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
						<th nowrap width="1%" style="font-size:10"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th><!--  //added generic name for AAKH-CRF-0088 [IN:060357] -->
						<th nowrap width="1%" style="font-size:10"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
						<th width ="10%">Dosage</th><!-- added for IN070786-->
						<th width ="10%">Route</th><!-- added for IN070786-->
						<th width ="10%">Frequency</th><!-- added for IN070786-->
						<th nowrap width="1%" style="font-size:10"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
						<th nowrap width="1%" style="font-size:10"><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></th>
						<th nowrap width="1%" style="font-size:10"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th>						
						<th nowrap width="1%" style="font-size:10"><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>
						</tr>
<%
					String classvalue="";
					String access_num	= ""; 
					String srl_no	= ""; 
					String priv_appl_yn ="";
					
					ArrayList external_drugs = bean1.getExternal_drugs();
					ArrayList external_drugs_tmp = bean1.getExternal_drugs_tmp();  // modified for Inc#70652					
					for(int recCount=2; recCount<result1.size(); recCount++) {
						priv_appl_yn = "";
						disabled = "";
						checked =""; // Added for Inc#70652
						if ( recCount % 2 == 0 )
							classvalue = "QRYODDSMALL" ;
						else
							classvalue = "QRYEVENSMALL" ;

						ArrayList records1=(ArrayList) result1.get( recCount );

						String DRUG_CODE		= CommonBean.checkForNull((String)records1.get(0));
						String DRUG_DESC		= CommonBean.checkForNull((String)records1.get(1));
						String START_DATE		= CommonBean.checkForNull((String)records1.get(2));
						String END_DATE		    = CommonBean.checkForNull((String)records1.get(3));
						String PRACTITIONER		= CommonBean.checkForNull((String)records1.get(4));
						String INSTRUCTIONS		= CommonBean.checkForNull((String)records1.get(5));
						String GENERICNAME		= CommonBean.checkForNull((String)records1.get(6));
						srl_no                  = CommonBean.checkForNull((String)records1.get(11));												
						ADDED		= CommonBean.checkForNull((String)records1.get(7));
									
						priv_appl_yn            = CommonBean.checkForNull((String)records1.get(10));					
						
						if(external_drugs!= null && external_drugs.contains(DRUG_CODE)){ 
							disabled	=	"disabled";				
						}
						if(external_drugs_tmp!=null && external_drugs_tmp.contains(DRUG_CODE)){ // Added for Inc#70652 - Start
							checked = "checked";
						} // Added for Inc#70652 - End
						//added for IN070786 start
						String doase			=CommonBean.checkForNull((String)records1.get(12))+" "+CommonBean.checkForNull(bean.getUomDisplay(facility_id,(String)records1.get(13)));
						String route			=CommonBean.checkForNull((String)records1.get(14));
						String frequency			=CommonBean.checkForNull((String)records1.get(15));
						String frequency_nature=	CommonBean.checkForNull((String)records1.get(16));	//added for IN070786 end
																		
						
%>
						<tr >						    
						    <td width="1%" class="<%=classvalue%>"   id='drug_<%=DRUG_CODE%>'><input type="checkbox" name='<%=patient_id+","+srl_no%>' id='<%=patient_id+","+srl_no%>' onClick=" return checkDuplicate1(this,'<%=priv_appl_yn%>','External'); "  value="<%=DRUG_CODE%>"<%=disabled%> <%=checked%>> <!-- checked Added for Inc#70652-->
							<td width ="1%" class="<%=classvalue%>" id="DRUG_CODE">&nbsp;&nbsp;<%=DRUG_CODE%></td>
							<td width ="1%" class="<%=classvalue%>" id="DRUG_DESC" STYLE='WORD-BREAK:BREAK-ALL;'><%=DRUG_DESC%></td>
							<td width ="1%" class="<%=classvalue%>" id="GENERIC_NAME" STYLE='WORD-BREAK:BREAK-ALL;'><%=GENERICNAME%>&nbsp;</td>
							<td width ="1%"  class="<%=classvalue%>" id="START_DATE"><%=com.ehis.util.DateUtils.convertDate(START_DATE,"DMYHM","en",locale)%></td>
							<!-- added for IN070786 start -->
							<td width ="10%"  class="<%=classvalue%>" id="doase"><%=doase%>&nbsp;</td>
							<td width ="10%"  class="<%=classvalue%>" id="route"><%=route%>&nbsp;</td>
							<td width ="10%"  class="<%=classvalue%>" id="frequency"><%=frequency%>&nbsp;</td>
							<input type="hidden" value="<%=frequency_nature%>" name="frequency_nature" />
							<!-- added for IN070786 end -->
								
<%
							if(!END_DATE.equals("")){
%>
								<td width ="1%" class="<%=classvalue%>" id="END_DATE"><%=com.ehis.util.DateUtils.convertDate(END_DATE,"DMYHM","en",locale)%></td>
<%
							}
							else{
%>
								<td width ="1%" class="<%=classvalue%>" id="END_DATE">&nbsp;</td>
<%
							}
%>
							<td width ="1%" class="<%=classvalue%>" id="INSTRUCTIONS" STYLE='WORD-BREAK:BREAK-ALL;'><%=INSTRUCTIONS%></td>
							<td width ="1%" class="<%=classvalue%>" id="PRACTITIONER" STYLE='WORD-BREAK:BREAK-ALL;'><%=PRACTITIONER%>&nbsp;</td><!--added for IN050551 -->							
							<td width ="1%" class="<%=classvalue%>" id="ADDED_BY_ID" STYLE='WORD-BREAK:BREAK-ALL;'><%=ADDED%>&nbsp;</td> <!-- &nbsp Added for Inc#70652 -->
																																											
						</tr>
						
<%
					}
%>                      <input type="hidden" name="checkcount" id="checkcount" value=<%=0%>>
                        <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id1%>">
						<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name1%>">	
						<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">	<!-- added for IN070786-->
						<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">	<!-- added for IN070786-->
						  				
						
				</table> 
			</div>
				
<%
		} 
		catch(Exception e) {
			out.print("Exception @ QueryPatientExternalDrugProfileResult :"+e.toString());
			e.printStackTrace();
		}
		//Added for ML-MMOH-CRF-0510[IN06051o] START
// 		finally{
			
// 			if(con != null)
// 				ConnectionManager.returnConnection(con,request);
		
// 		}
		//Added for ML-MMOH-CRF-0510[IN060510] END
%>
	</form>
	</body>
<% 
	putObjectInBean(bean_id,bean,request); 
%>
</html>

