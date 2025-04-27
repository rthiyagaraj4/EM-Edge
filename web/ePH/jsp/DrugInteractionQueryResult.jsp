<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/11/2019	IN070606		Ramesh Goli											MMS-KH-CRF-0029							
------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id		= "DrugInteractionBean";
		String bean_name	= "ePH.DrugInteractionBean";
		String mode			= request.getParameter("mode");
		DrugInteractionBean bean = (DrugInteractionBean)getBeanObject( bean_id,bean_name,request) ;
		bean.clear();
		bean.setLanguageId(locale);
		bean.setMode( mode ) ;
		String facility_id					= (String) session.getValue("facility_id");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugInteraction.js"></SCRIPT> 
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page
		String intr_code1 		=	request.getParameter( "intr_code1" )==null?"":request.getParameter( "intr_code1" );
		String intr_code2 		=	request.getParameter( "intr_code2" )==null?"":request.getParameter( "intr_code2" );
		String intr_name1 		=	request.getParameter( "intr_name1" )==null?"":request.getParameter( "intr_name1" );
		String intr_name2 		=	request.getParameter( "intr_name2" )==null?"":request.getParameter( "intr_name2" );
		String severity_level 		=	request.getParameter( "Severity_Level" )==null?"":request.getParameter( "Severity_Level" );
		String significant_level 		=	request.getParameter( "Significant_level" )==null?"":request.getParameter( "Significant_level" );
		String probability 		=	request.getParameter( "Probability" )==null?"":request.getParameter( "Probability" );
		String nature 		=	request.getParameter( "nature" )==null?"":request.getParameter( "nature" );
		String Optionval 		=	request.getParameter( "InteractionBy" )==null?"":request.getParameter( "InteractionBy" );
		String intr_type 		=	request.getParameter( "InteractionType" )==null?"":request.getParameter( "InteractionType" ); //IN070606
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		ArrayList qeuryrecord=new ArrayList();

		try{
			String classvalue= "", restrict_yn, intr_remarks;
			
			//Common parameters.
			HashMap sqlMap = new HashMap();
			//include all the common parameters.
			//IN070606 Start.
			if(Optionval.equals("D") && intr_type.equals("D") ){
				sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_QUERY_DTL_DRUG"));
			}else if(Optionval.equals("G") && intr_type.equals("D") ){
				sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_QUERY_DTL_GNERIC"));
			}else if(Optionval.equals("D") && intr_type.equals("F") ){
				sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_QUERY_DTL_DRUGTOFOOD"));
			}else if(Optionval.equals("G") && intr_type.equals("F") ){
				sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_QUERY_DTL_GNERICTOFOOD"));
			}else if(Optionval.equals("D") && intr_type.equals("L") ){
				sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_QUERY_DTL_DRUGTOLAB"));
			}else if(Optionval.equals("G") && intr_type.equals("L") ){
				sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_QUERY_DTL_GNERICTOLAB"));
			}else if(Optionval.equals("D") && intr_type.equals("I") ){
				sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_QUERY_DTL_DRUGTOICD"));
			}else if(Optionval.equals("G") && intr_type.equals("I") ){
				sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_INT_QUERY_DTL_GNERICTOICD"));
			}
			//IN070606	end.		
			if(intr_code1.equals("")){
				intr_code1 = "%";
			}
			if(intr_code2.equals("")){
				intr_code2  = "%";	
			}
			intr_name1 += "%";
			intr_name2  += "%";	
			severity_level+="%"; 				
			significant_level+="%";		
			probability+="%";		
			
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "intr_code1" ); //0
			displayFields.add( "intr_name1" );
			displayFields.add( "intr_code2" );
			displayFields.add( "intr_name2" );
			displayFields.add( "intr_severity_level" ); //4
			displayFields.add( "intr_signif_level" ); //5
			displayFields.add( "intr_prob_level" );
			displayFields.add( "INTR_RESTRT_YN" );
			displayFields.add( "INTR_REMARKS" );
			displayFields.add( "eff_status" ); //9
			displayFields.add( "form_code1" ); //10
			displayFields.add( "form_code2" ); 
			displayFields.add( "form_desc1" ); 
			displayFields.add( "form_desc2" );  //13

			ArrayList chkFields = new ArrayList();
			chkFields.add( intr_code1.trim());
			chkFields.add( intr_code2.trim());
			if(intr_type.equals("D")){ //IN070606
			chkFields.add( intr_name1.trim());
			chkFields.add( intr_name2.trim());
			} //IN070606
			chkFields.add( severity_level.trim());
			chkFields.add( significant_level.trim());
			chkFields.add( probability.trim());
			chkFields.add( nature.trim());
			chkFields.add( locale);
			if(intr_type.equals("D")) //IN070606
			chkFields.add(locale);
			
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			String intr_Type_Desc="";
			if("D".equals(intr_type))
				intr_Type_Desc	= "Drug-Drug";
			else if("F".equals(intr_type))
				intr_Type_Desc	= "Drug-Food";
			else if("L".equals(intr_type))
				intr_Type_Desc	= "Drug-Labaratory";
			else if("I".equals(intr_type))//Added for MMS-DM-CRF-0229
				intr_Type_Desc	= "Drug-Disease";

			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
				if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
							out.println(result.get(1)); // For display the previous/next link
%>
							</td>
						</tr>
					</table>
					<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center">
					<td class='COLUMNHEADER' nowrap width='15%'>&nbsp;Intr. Type</td >
<%					if(Optionval.equals("G")&& intr_type.equals("D")){ %>
						<th width='20%' nowrap ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap ><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;2</th>
						<th width='20%' nowrap><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;2</th>
<%					}else if(Optionval.equals("D")&& intr_type.equals("D")){ %>
						<th width='20%' nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;2</th>
						<th width='20%' nowrap><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;2</th>
<%					}else if(Optionval.equals("G")&& intr_type.equals("F")){ %>
						<th width='20%' nowrap ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap ><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="ePH.FoodItemIngredients.label" bundle="${ph_labels}"/></th>						
<%					}else if(Optionval.equals("D")&& intr_type.equals("F")){ %>
						<th width='20%' nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="ePH.FoodItemIngredients.label" bundle="${ph_labels}"/></th>						
<%					}else if(Optionval.equals("G")&& intr_type.equals("L")){ %>
						<th width='20%' nowrap ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap ><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="ePH.LaboratoryTestCode.label" bundle="${ph_labels}"/></th>						
<%					}else if(Optionval.equals("D")&& intr_type.equals("L")){ %>
						<th width='20%' nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="ePH.LaboratoryTestCode.label" bundle="${ph_labels}"/></th>						
<%					}else if(Optionval.equals("G")&& intr_type.equals("I")){ %><!-- Adding start for MMS-DM-CRF-0229 -->
						<th width='20%' nowrap ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap ><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></th>						
<%					}else if(Optionval.equals("D")&& intr_type.equals("I")){ %>
						<th width='20%' nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>&nbsp;1</th>
						<th width='20%' nowrap><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></th>						
<%					}%>
	                <!-- Adding end for MMS-DM-CRF-0229 -->
					<th width='10%' nowrap><fmt:message key="Common.Severity.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
					<th width='10%' nowrap><fmt:message key="Common.significant.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
					<th width='10%' nowrap><fmt:message key="ePH.documentation.label" bundle="${ph_labels}"/>	</th>   <!-- Modified for FD-RUT-CRF-0066.1 [IN036975] -->
					<th width='10%' nowrap><fmt:message key="ePH.RestrictTransaction.label" bundle="${ph_labels}"/>	</th>
					<th width='15%' nowrap><fmt:message key="ePH.Interaction.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th width='5%' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%
					ArrayList records=new ArrayList();
					String formCode="", formDesc="";
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
%>
						<tr >
						<td class="<%=classvalue%>" onclick="disableClick(event); " align="center"><%=intr_Type_Desc%></td>
<%

						records=(ArrayList) result.get( recCount );
						for(int colCount=0; colCount<records.size(); colCount++){
							formDesc="";
							if(colCount==0){
								formCode = records.get(10)==null?"":(String)records.get(10);
								if(formCode.equals("*A"))
									formDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.all.label", "common_labels");
								else
									formDesc = records.get(12)==null?"":(String)records.get(12);
%>
								<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK' onClick="Modify('<%=Optionval%>','<%=records.get(0)%>','<%=records.get(2)%>','<%=records.get(10)%>','<%=records.get(11)%>','<%=intr_type%>' )">&nbsp;<%=(String)records.get( colCount+1 )%></font>
								</td>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">&nbsp;<%=formDesc%>
								</td>
<%
							}
							else if (colCount==2){
								formCode = records.get(11)==null?"":(String)records.get(11);
								if(formCode.equals("*A"))
									formDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.all.label", "common_labels");
								else
									formDesc = records.get(13)==null?"":(String)records.get(13);
								//IN070606 Start.
								if(("D".equals(Optionval)||"G".equals(Optionval))&& "D".equals(intr_type)){
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">&nbsp;<%=(String)records.get( colCount+1 )%>
								</td>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">&nbsp; <%=formDesc%>
								</td>
<%
								}else if("F".equals(intr_type)){
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">&nbsp;<%=(String)records.get( colCount+1 )%></td>								
<%								
								}else if("L".equals(intr_type)){
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">&nbsp;<%=(String)records.get( colCount+1 )%></td>								
<%								
								}else if("I".equals(intr_type)){
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center">&nbsp;<%=(String)records.get( colCount+1 )%></td>	
<%								
								}
								//IN070606 End.
							}
							else if (colCount==4){
								severity_level 	=(String)records.get( colCount );
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center"> 
<%
									if(severity_level.equals("H")){
%>		
										<fmt:message key="ePH.Major.label" bundle="${ph_labels}"/>
<%
									}
									else if(severity_level.equals("M")){
%>
										<fmt:message key="Common.Moderate.label" bundle="${common_labels}"/>
<%
									}
									else if(severity_level.equals("L")){
%>
										<fmt:message key="ePH.Minor.label" bundle="${ph_labels}"/>
<%
									}
%>
								</td>
<%
							}
							else if (colCount==5){
								significant_level 	=(String)records.get( colCount );
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center"> <%=(String)significant_level%>
								</td>
<%
							}
							else if (colCount==6){
								probability  	=(String)records.get( colCount );		
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center"> 
<%
							//if(probability.equals("D")){   Commented and added for FD-RUT-CRF-0066.1 [IN036975] --begin
%>		
								<!--<fmt:message key="Common.Definitive.label" bundle="${common_labels}"/>-->
<%
							//}
							//else if(probability.equals("P")){
%>
							<!--	<fmt:message key="Common.Probable.label" bundle="${common_labels}"/>-->
<%
						//	}

							if(probability.equals("E")){
%>		
							<fmt:message key="ePH.established.label" bundle="${ph_labels}"/>
<%
}							else if(probability.equals("P")){
%>		
	<fmt:message key="Common.Probable.label" bundle="${common_labels}"/>
<%
}							else if(probability.equals("S")){
%>		
	<fmt:message key="ePH.suspected.label" bundle="${ph_labels}"/>
<%
}							else if(probability.equals("O")){
%>		
	<fmt:message key="ePH.Possible.label" bundle="${ph_labels}"/>
<%
}							else if(probability.equals("U")){
%>		
	<fmt:message key="ePH.Unlikely.label" bundle="${ph_labels}"/>
<%
} //FD-RUT-CRF-0066.1 [IN036975] --end
%>
								</td>
<%
							}
							else if (colCount==7){
								restrict_yn 	=(String)records.get( colCount );
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center"> 
<%
								if(restrict_yn.equals("Y")){
%>		
									<img src='../../eCommon/images/enabled.gif'>
<%
								}
								else if(restrict_yn.equals("N")){
%>
									<img src='../../eCommon/images/disabled.gif'>
<%
								}
%>
								</td>
<%
							}
							else if (colCount==8){
								intr_remarks  	=(String)records.get( colCount );		
								String intr_remarks_tooltip=intr_remarks.replaceAll(" ","%20"); // added for FD-RUT-CRF-0066.1 [IN036975] -- begin
								intr_remarks_tooltip = java.net.URLEncoder.encode(intr_remarks_tooltip,"UTF-8" );
								intr_remarks_tooltip=intr_remarks_tooltip.replaceAll("%2520","%20"); // added for FD-RUT-CRF-0066.1 [IN036975] -- end
								if(intr_remarks.length() > 16 )
									intr_remarks = intr_remarks.substring(0,15)+"...";
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " id='intr_desc<%=recCount%>' align="center" > <%=intr_remarks%>
								<script>
								      //assignTitle('<%=recCount%>','<%=java.net.URLEncoder.encode((String)records.get( colCount),"UTF-8")%>' );  // Commented and added for FD-RUT-CRF-0066.1 [IN036975]
									assignTitle('<%=recCount%>','<%=intr_remarks_tooltip%>');   
								</script>
								</td>
<%
							}
							else if (colCount==9){
								nature 		=(String)records.get( colCount );
%>
								<td class="<%=classvalue%>" onclick="disableClick(event); " align="center"> 
<%
								if(nature.equals("E")){
%>		
									<img src='../../eCommon/images/enabled.gif'>
<%
								}
								else if(nature.equals("D")){
%>
									<img src='../../eCommon/images/disabled.gif'>
<%
								}
%>
								</td>
<%
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
				out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugInteractionQueryResult.jsp", searched) );
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
%>
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

