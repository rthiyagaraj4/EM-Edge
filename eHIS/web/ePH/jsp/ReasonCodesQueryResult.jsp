<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
 <%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
22/11/2019      IN059899        PRATHYUSHA                          JD-CRF-0200
08/06/2020      IN:072715       Haribabu                            MMS-DM-CRF-0165       
------------------------------------------------------------------------------------------------------------------------------- 
*/ 
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/ReasonCodes.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		//Search Criteria's from Query Criteria page
		String appl_trn_type= request.getParameter( "appl_trn_type" ) ;
		String reason_code	= request.getParameter( "reason_code" ) ;
		String reason_desc	= request.getParameter( "reason_desc" ) ;
		String eff_status	= request.getParameter( "eff_status" ) ;

		//String ord[]			= request.getParameterValues("orderbycolumns");
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			= "";

			appl_trn_type= CommonBean.checkForNull( appl_trn_type );
			reason_code  = CommonBean.checkForNull( reason_code );
			reason_desc	 = CommonBean.checkForNull( reason_desc );
			eff_status	 = CommonBean.checkForNull( eff_status );

			if (eff_status.equals("B")){
				eff_status="";
			}

			//Common parameters.
			HashMap sqlMap = new HashMap();
			//include all the common parameters.
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_REASON_CODES_SELECT2"));
			
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "APPL_TRN_TYPE" );
			displayFields.add( "REASON_CODE" );
			displayFields.add( "REASON_DESC" );
			displayFields.add( "EFF_STATUS" );

			ArrayList chkFields = new ArrayList();
			chkFields.add( appl_trn_type.trim() );
			chkFields.add( reason_code.trim() + "%" );
			chkFields.add( reason_desc.trim() + "%" );
			chkFields.add( eff_status.trim() );
			chkFields.add(locale);
			
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
			
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
				<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
<%
				// For display the previous/next link
				out.println(result.get(1));
%>
				</td></tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<th><fmt:message key="ePH.ApplicableTransaction.label" bundle="${ph_labels}"/></th><th><fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
<%
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
%>
						<tr >
<%
							records=(ArrayList) result.get( recCount );
							for(int colCount=0; colCount<records.size(); colCount++){
								if(colCount==1){ 
%>
									<input type="hidden" name="reason_code<%=recCount%>" id="reason_code<%=recCount%>" value="<%=records.get( colCount )%>">
<%
								}
								else if(colCount==0 || colCount==2){
									String dkVal = (String)records.get( colCount );
									
									if (dkVal.equals("R"))
										  dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationReissue.label","ph_labels");
									else if (dkVal.equals("T")){
										  dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.MedicationReturn.label", "ph_labels");
									}else if (dkVal.equals("H")){
										  dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.MedicationHold.label", "ph_labels");
									}
									else if (dkVal.equals("A")){ 
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Allocation.label", "ph_labels");
									}
									else if (dkVal.equals("F")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Filling.label", "ph_labels");
									}
									else if (dkVal.equals("D")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Delivery.label", "ph_labels");
									}
									else if (dkVal.equals("O")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AmendOrder.label", "ph_labels");
									}
									else if (dkVal.equals("M")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Administration.label", "ph_labels");
									}
									else if (dkVal.equals("RP")){
										 dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReleaseBatchPatient.label", "ph_labels");
									}
									else if (dkVal.equals("RO")){
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReleaseBatchOthers.label", "ph_labels");
									}
									else if(dkVal.equals("TD")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TDMOrder.label", "ph_labels");
									}
									else if(dkVal.equals("RR")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReroutePrescription.label", "ph_labels");
									}
									else if(dkVal.equals("CO")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompleteOrder.label", "ph_labels");
									}
									else if(dkVal.equals("OB")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OverRideBMS.label", "ph_labels");
									}
									else if(dkVal.equals("BR")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.BalanceMedicationRemarks.label", "ph_labels");
									}
									//Added elseif  condition for the incident number 22509 on 7/july/2010--Sandhya
									else if(dkVal.equals("E")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ADRReason.label", "ph_labels");
									}
									else if(dkVal.equals("CN")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CancelNPBRequest.label", "ph_labels");
									} 
									else if(dkVal.equals("AI")) { //code added for HSA-CRF-0005[40601] --Start 
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ADRInErrorReason.label", "ph_labels");
									}
									else if(dkVal.equals("AC")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ADRCancelReason.label", "ph_labels");
									}//code added for HSA-CRF-0005[40601] --End
									else if(dkVal.equals("CM")) {//added for JD-CRF-0200
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CancelMarAdminstration.label", "ph_labels");
									}
									else if(dkVal.equals("MR")) {//added for MMS-KH-CRF-0010
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.MarAdminstrationRemarks.label", "ph_labels");
									}
									//Added for IN:072715 start
									else if(dkVal.equals("AO")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllergyOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("BD")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.BeyondDoseLimitOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("DP")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DuplicateDrugOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("DD")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Drug-DrugInteractionOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("DF")) {
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Drug-FoodInteractionOverrideReason.label", "ph_labels");
									}
									else if(dkVal.equals("DL")) {

																				dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Drug-LabInteractionOverrideReason.label", "ph_labels");
									}else if(dkVal.equals("DI")) {//Added for MMS-DM-CRF-0229
										dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Drug-DiseaseOverrideReason.label", "ph_labels");
									}
									//Added for IN:072715 end
									else if(dkVal.equals("NP")) {
											dkVal =com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NotPreferedItemRemarks.label","ph_labels");
									}
	                 								%>
									<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);" onClick="Modify('<%=records.get( 0 )%>','<%=records.get( 1 )%>')">  <%=dkVal%></font></td>
<%
								}	
								else {		
									String fieldValue=((String)records.get( colCount ));
									String dkVal =fieldValue ;
%>
									<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">
<%
									out.println(getImage(dkVal));
									out.println("</td>");
								}
							}
%>
						</tr>
<%
					}
%>
				</table>
<%
				out.flush();
			}
			else{
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%
			}
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ReasonCodesQueryResult.jsp", searched) );
		}
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
<%!
		public String getImage(String value){
			if(value.equalsIgnoreCase("E"))
				return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
			else
				return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
		}
%>
	</body>
</html>

