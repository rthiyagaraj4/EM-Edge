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
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	</head>
	<form name="QueryPatientExternalDrugProfileResultform" id="QueryPatientExternalDrugProfileResultform"><!--ADDED FOR IN070786 -->
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
		String facility_id		=(String)session.getValue("facility_id"); // facility_id added for AAKH-CRF-0088.2
		boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
		String patient_id	= request.getParameter("patient_id");	
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"); // encounter_id added for AAKH-CRF-0088.2
	    if(encounter_id.equals("null"))//AAKH-CRF-0088.2  start IN[62946]
		  encounter_id="";//AAKH-CRF-0088.2  end IN[62946]
		String mode 		="";
		mode      	        = request.getParameter("mode")== null ? "" : request.getParameter("mode");
		String disabled     = "";
		if(mode.equals("Q")){
			disabled		=	"disabled";
		}
		else {
			disabled    	=	"";
		}
		String dt_from	    = CommonBean.checkForNull(request.getParameter("dt_from"));
		String dt_to	    = CommonBean.checkForNull(request.getParameter("dt_to"));
        String called_frm	    = CommonBean.checkForNull(request.getParameter("called_frm"));
		//String enc_id1 = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		String ReqDb	    =	request.getParameter("RepDb")==null?"":request.getParameter("RepDb");//Added for MMS-DM-CRF-115.4
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for MMS-DM-CRF-115.4
		if(ReqDb.equals("undefined"))
		    ReqDb="";
		String enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		if(enc_id1.equals("undefined"))
		    enc_id1="";
		String	bean_id			=	"QueryPatientDrugProfileBean" ;
		String	bean_name		=	"ePH.QueryPatientDrugProfileBean";
	     	String bean_id1		= "@PrescriptionBean_1";//added for IN070786
				String bean_name1	= "ePH.PrescriptionBean_1";//added for IN070786
         	String ADDED     =null;//Added for ML-MMOH-CRF-0510[IN060510] START
		Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TRANSCRIBED_BY");//Added for ML-MMOH-CRF-0510[IN060510] END
		boolean site1 = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","RECORD_CLINICAL_NOTES");//Added for AAKH-CRF-0088.2 [IN061987]
		String pat_class = request.getParameter("pat_class")== null ? "" : request.getParameter("pat_class"); // Added for AAKH-CRF-0088.2 [IN061987]
		QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		//added for IN070786 start
		PrescriptionBean_1 bean1		= (PrescriptionBean_1)getBeanObject( bean_id1,bean_name1,request );
		System.out.println("in patient drug profile patient_id"+patient_id+"encounter_id"+encounter_id);
		String no_ext_drug=(String)bean1.extDrugApplicableYN(patient_id,encounter_id);//added for mms-kh-crf-0016.1
		System.out.println("no_ext_drug"+no_ext_drug);
		String checked_no_ext="";
		String disabled_no_ext="";
		if(no_ext_drug.equals("Y") && !mode.equals("Q")){
			checked_no_ext="checked";
			disabled_no_ext="disabled";
		}
		else
		{
			checked_no_ext="";
			disabled_no_ext="";
		}
		//added for IN070786 end
		if(called_from.equals("CDR")){//added for MMS-DM-CRF-115.4
			disabled		=	"disabled";
		}
		try{

			HashMap funcMap1 = new HashMap();
			HashMap sqlMap1 = new HashMap();

			//String drugprofile="SELECT DRUG_CODE,DRUG_DESC,TO_CHAR(START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(END_DATE,'DD/MM/YYYY HH24:MI') END_DATE,INSTRUCTIONS FROM PH_PATIENT_EXT_DRUG_PROFILE WHERE UPPER(PATIENT_ID) LIKE UPPER(?)and START_DATE BETWEEN  NVL (TO_DATE (?,'DD/MM/YYYY'),sysdate-30) AND  NVL (TO_DATE (?,'DD/MM/YYYY'),sysdate ) ORDER BY PH_PATIENT_EXT_DRUG_PROFILE.START_DATE DESC";

			//String drugprofile="SELECT A.DRUG_CODE,A.DRUG_DESC,TO_CHAR(A.START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(A.END_DATE,'DD/MM/YYYY HH24:MI') END_DATE, nvl(b.practitioner_name, a.practitioner_name) practitioner_name,A.INSTRUCTIONS,(SELECT GENERIC_NAME FROM PH_DRUG_VW WHERE DRUG_CODE=A.DRUG_CODE) GENERIC_NAME FROM PH_PATIENT_EXT_DRUG_PROFILE A,am_practitioner_lang_vw B WHERE A.PATIENT_ID  = ? and A.START_DATE BETWEEN  NVL (TO_DATE (?,'DD/MM/YYYY'),sysdate-30) AND  NVL (TO_DATE (?,'DD/MM/YYYY'),sysdate+30 ) AND b.PRACTITIONER_ID(+)=a.PRACTITIONER_ID AND b.language_id(+)=? ORDER BY A.START_DATE DESC";//<!--am_practitioner_lang_vw table added for IN050551 -->added generic name for AAKH-CRF-0088 [IN:060357]  
			//modified for IN070786
			String drugprofile="SELECT A.DRUG_CODE,A.DRUG_DESC,TO_CHAR(A.START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(A.END_DATE,'DD/MM/YYYY HH24:MI') END_DATE,a.practitioner_name,A.INSTRUCTIONS,(SELECT GENERIC_NAME FROM PH_DRUG_VW ##REQDB## WHERE DRUG_CODE=A.DRUG_CODE) GENERIC_NAME,am_get_desc.am_practitioner ##REQDB## (a.added_by_id,?,'1')ADDED,A.ADDED_BY_ID,A.PRACTITIONER_ID,A.ACCESSION_NUM,A.SRL_NO,a.QTY_VALUE,A.QTY_DESC,(SELECT route_desc FROM ph_drug_vw  WHERE drug_code = A.drug_code) route_desc, (SELECT FREQ_DESC FROM AM_FREQUENCY WHERE FREQ_CODE = A.FREQUENCY)FREQ_DESC,(SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE = A.FREQUENCY) FREQ_NATURE FROM PH_PATIENT_EXT_DRUG_PROFILE ##REQDB## A WHERE A.PATIENT_ID  = ? and A.START_DATE BETWEEN  NVL (TO_DATE (?,'DD/MM/YYYY'),sysdate-30) AND  NVL (TO_DATE (?,'DD/MM/YYYY'),sysdate+30 ) ORDER BY A.START_DATE DESC";// REMOVED FOR AND b.PRACTITIONER_ID(+)=a.PRACTITIONER_ID AND b.language_id(+)=? MMS-KH-CRF-0016.1//<!--am_practitioner_lang_vw table added for IN050551 -->added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]  // A.ACCESSION_NUM,SRL_NO added for AAKH-CRF-0088.2
			
			drugprofile=drugprofile.replaceAll("##REQDB##",ReqDb);//Added for MMS-DM-CRF-115.4

			sqlMap1.put( "sqlData",drugprofile);

			ArrayList displayFields1 = new ArrayList();
			displayFields1.add("DRUG_CODE");  
			displayFields1.add("DRUG_DESC");  
			displayFields1.add("START_DATE");  
			displayFields1.add("END_DATE");
			displayFields1.add("PRACTITIONER_NAME");//added for IN050551 
			displayFields1.add("INSTRUCTIONS");  
			displayFields1.add("GENERIC_NAME");  //added generic name for AAKH-CRF-0088 [IN:060357]
		//added  and modified for IN070786
			displayFields1.add("ADDED_BY_ID");//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]
			displayFields1.add("PRACTITIONER_ID");//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]
			
			displayFields1.add("QTY_VALUE"); 
		    displayFields1.add("QTY_DESC"); 
			displayFields1.add("ROUTE_DESC"); 
		    displayFields1.add("FREQ_DESC"); 
		    displayFields1.add("FREQ_NATURE"); 
			// added and mofied for IN070786
					if(site){
			displayFields1.add("ADDED"); //added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]
            		}
			if(site1) { // AAKH-CRF-0088.2 
				displayFields1.add("ACCESSION_NUM"); 
				displayFields1.add("SRL_NO"); 
			}		
			if(dt_from.equals(""))
				dt_from="01/01/1998";
			
			
			 
			ArrayList chkFields1 = new ArrayList();
			System.out.println("Line No:92 patient_id------>"+patient_id);
			chkFields1.add(locale);//added for IN070786
			chkFields1.add( patient_id.trim() );
			System.out.println("Line No:94 dt_from------>"+dt_from);
			System.out.println("Line No:95 dt_to------>"+dt_to);
			chkFields1.add( dt_from );
			chkFields1.add( dt_to );
			//chkFields1.add(locale);//added for IN050551 commented for  for IN070786

			// Adding function related array list into the HashMap
			funcMap1.put( "displayFields", displayFields1 );
			funcMap1.put( "chkFields", chkFields1 );
		  
			ArrayList result1=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap1,funcMap1,request);
		System.out.println("result1"+result1);
			int count=Integer.parseInt((String)result1.get(0));//ADDED FOR IN070786
%>
			<table id="ExternalId_1" border="0" cellpadding="0" cellspacing="0" width="100%"  >
				<!-- ADDED FOR IN070786  START-->
				<tr>
				
				<td  align="right"  class="button" >No External Drug
			  <%if(count>0){ %>
				<input type="checkbox" name="no_external_drug" id="no_external_drug" value="N" onClick="ExternalDrug(this)" disabled />
				<%}else{ %>
				<input type="checkbox" name="no_external_drug" id="no_external_drug" value="Y" onClick="ExternalDrug(this)" <%=checked_no_ext%> <%=disabled%> /><!-- checked_no_ext added for mms-kh-crf-0016.1-->
				<%} %>
				</td>
					<!-- ADDED FOR IN070786  END-->
				<td align="right"><input type="button" class="button" name="ADDDRUGS" id="ADDDRUGS"  value='<fmt:message key="ePH.ADDEXTERNALDRUG.label" bundle="${ph_labels}"/>'  onClick="AddDrugsPage('<%=patient_id%>','<%=dt_from%>','<%=dt_to%>')" <%=disabled_no_ext%> <%=disabled%> ></td><!-- disabled_no_ext added for mms-kh-crf-0016.1 -->
				</tr>
			</table>

			<table id="ExternalId_2" border="0" cellpadding="0" cellspacing="0" width="100%"  >
				<tr style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'><td  width='100%'class="white" align="center">
<%
				// For display the previous/next link
				out.println(result1.get(1));
%>
				</td></tr>
			</table>
			 <div id='patinsID' style='height:358;overflow-y:auto;overflow-x:no'>
				 <table id="ExternalId" border="1" cellpadding="0" cellspacing="0" width="100%"  >
					<tr style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
						<th width ="10%"><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th>
						<th width ="25%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
						<th width ="10%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th><!--  //added generic name for AAKH-CRF-0088 [IN:060357] -->
						<th width ="10%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
						<!-- added for IN070786 start -->
						<th width ="10%">Dosage</th>
						<th width ="10%">Route</th>
						<th width ="10%">Frequency</th>
						<!-- added for IN070786 end -->
						<th width ="10%"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
						<th width ="35%"><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></th>
						<th width ="19%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th><!-- added for IN050551 -->
						<%if(site){ %>
						<th width ="30%"><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>  <%} %> <!--added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] -->
						<%if(site1 ){ %>
						<th width ="30%"><fmt:message key="Common.record.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.ClinicalNotes.label" bundle="${common_labels}"/>&nbsp;</th> <%} %><!--added Record Clinical Notes for AAKH-CRF-0088.2 [IN061987] -->
						
					</tr>
<%
					String classvalue="";
					String access_num	= "";  // Added for AAKH-CRF-0088.2
					String srl_no	= "";  // Added for AAKH-CRF-0088.2
					for(int recCount=2; recCount<result1.size(); recCount++) {

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
						String doase			=CommonBean.checkForNull((String)records1.get(9))+" "+CommonBean.checkForNull(bean.getUomDisplay(facility_id,(String)records1.get(10)));
						String route			=CommonBean.checkForNull((String)records1.get(11));
						String frequency			=CommonBean.checkForNull((String)records1.get(12));
						String frequency_nature=	CommonBean.checkForNull((String)records1.get(13));	
						
						//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510]start
						if(site1){ // added for AAKH-CRF-0088.2
						   access_num	= CommonBean.checkForNull((String)records1.get(14));
						   srl_no           = CommonBean.checkForNull((String)records1.get(15));
						}	
						if(site){
						String prcid=CommonBean.checkForNull((String)records1.get(7));
					   String addid=CommonBean.checkForNull((String)records1.get(8));
					  
					/* if(prcid.equalsIgnoreCase(addid)){//COMMENTED FOR IN070786
						ADDED		= "";
					}
					else{ */
						ADDED		= CommonBean.checkForNull((String)records1.get(7));
					//}//added  and modified for IN070786
						}//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] end
						
						
%>
						<tr>
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
%>
				</table> 
			</div>
			<script language="javascript">
				parent.parent.f_query_status.location.href="../../ePH/jsp/QueryPatientDrugProfileStatus.jsp";
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPatientExternalDrugProfileResult.jsp", searched) );
		} 
		catch(Exception e) {
			out.print("Exception @ QueryPatientExternalDrugProfileResult :"+e.toString());
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

