<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
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
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/TokenSeries.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page
		String disp_locn_code	= request.getParameter( "disp_locn_code" );
		String short_desc		= request.getParameter( "short_desc" ) ;
		String token_series_code= request.getParameter( "token_series_code" ) ;
		String description		= request.getParameter( "description" ) ;
		String eff_status     	= request.getParameter( "eff_status" ) ;
		String facility_id=(String) session.getValue( "facility_id" );
		boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;
		String token_gen_stage="";
		try{
			String classvalue			= "";
			disp_locn_code = CommonBean.checkForNull( disp_locn_code.trim() );
			short_desc = CommonBean.checkForNull( short_desc.trim() );
			token_series_code = CommonBean.checkForNull( token_series_code.trim() );
			description = CommonBean.checkForNull( description.trim() );
			eff_status = CommonBean.checkForNull( eff_status.trim() );
			
			if (eff_status.equals("B")){
				eff_status="";
			}

			//Common parameters.
			HashMap sqlMap = new HashMap();
			//sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_TOKEN_SERIES_SELECT1")); 
			sqlMap.put( "sqlData", "SELECT A.DISP_LOCN_CODE,B.SHORT_DESC, A.TOKEN_SERIES_CODE,A.DESCRIPTION, A.APPLICABLE_SEX_IND,A.NATIONALITY_IND, A.EFF_STATUS,A.GEN_TOKEN_YN,A.TOKEN_GEN_STAGE,  A.QMS_REQUIRED_YN, A.QMS_EDIT_TOKEN_YN FROM PH_TOKEN_SERIES_LANG_VW A, PH_DISP_LOCN_LANG_VW B WHERE  A.DISP_LOCN_CODE=B.DISP_LOCN_CODE AND A.FACILITY_ID=B.FACILITY_ID AND  A.DISP_LOCN_CODE LIKE UPPER(?) AND   UPPER(B.SHORT_DESC) LIKE UPPER(?) AND  A.TOKEN_SERIES_CODE LIKE UPPER(?) AND  UPPER(A.DESCRIPTION) LIKE UPPER(?) AND  UPPER(A.EFF_STATUS) LIKE DECODE(A.EFF_STATUS,'B',A.EFF_STATUS,?) AND A.FACILITY_ID = ? AND A.LANGUAGE_ID = B.LANGUAGE_ID AND A.LANGUAGE_ID = ?"); 
			
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields that are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add( "disp_locn_code" );	//0
			displayFields.add( "short_desc" );	//1
			displayFields.add( "token_series_code" );	//2
			displayFields.add( "description" );	//3
			displayFields.add( "gen_token_yn" );	//4
			displayFields.add( "applicable_sex_ind" );	//5
			displayFields.add( "nationality_ind" );	//6
			displayFields.add( "token_gen_stage" );		//7
			displayFields.add( "QMS_REQUIRED_YN" );	//8
			displayFields.add( "QMS_EDIT_TOKEN_YN" );	//9
			displayFields.add( "eff_status" );	//10
			
			
			ArrayList chkFields = new ArrayList();
			chkFields.add( disp_locn_code.trim() + "%" );
			chkFields.add( short_desc.trim() + "%" );
			chkFields.add( token_series_code.trim() + "%" );
			chkFields.add( description.trim() + "%" );
			chkFields.add( eff_status.trim() + "%" );
			chkFields.add( facility_id.trim() );
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
						</td>
					</tr>
					</table>
					<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
						<tr>
							<th><fmt:message key="ePH.DispenseLocationCode.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.DispenseLocationDescription.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="ePH.TokenSeriesDescription.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="ePH.GenerateToken.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="ePH.ApplicableGender.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="ePH.ApplicableNationality.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="ePH.GenerationUpon.label" bundle="${ph_labels}"/></th>
							<th><fmt:message key="ePH.QMS.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.required.label" bundle="${common_labels}"/></th>
							<th><fmt:message key="ePH.QMS.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.EditToken.label" bundle="${common_labels}"/></th>
							<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
						</tr>
<%
						//Retriving the records from result arraylist
						ArrayList records=new ArrayList();
						for(int recCount=2; recCount<result.size(); recCount++) {
							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
							String link_columns = "1,3";
							records=(ArrayList) result.get( recCount );
							token_gen_stage=((String)records.get( 7 ));
%>
							<tr onClick="Modify(this,'<%=token_gen_stage%>');" >
<%

								for(int colCount=0; colCount<records.size(); colCount++){
									if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>
										<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=(String)records.get( colCount )%></font></td>
<%
									}
									else{				
%>				
										<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
<%
										out.println((String)records.get( colCount ));
										String dkVal = (String)records.get( colCount );
										if(dkVal == null)	
											dkVal = "&nbsp" ;
										if(dkVal.equals("")) 
											dkVal = "&nbsp;";			

										if (colCount==5){
											if (dkVal.equals("F")){
												dkVal = "Female";  	
											}
											else if (dkVal.equals("M")){
												dkVal = "Male";  	
											}
											else{
												dkVal = "Both";  	
											}
										}
										
										if (colCount==6){
											if (dkVal.equals("N")){
												dkVal = "Nationals";  	
											}
											else if (dkVal.equals("E")){
												dkVal = "Expatriates";  	
											}
											else{
												dkVal = "Both";  	
											}
										}
										
										if (colCount==7){
											if (dkVal.equals("RG")){
												dkVal = "RegisterOrder";  	
											}
											else if (dkVal.equals("OR")){
												dkVal = "OrderRelease";  	
											}
											else if (dkVal.equals("RI")){
												dkVal = "ReissueMedication";  	
											}
											else if (dkVal.equals("RM")){
												dkVal = "ReturnMedication";  	
											}
											else if (dkVal.equals("DD")){
												dkVal = "DirectDispensing";  	
											}
										}

										if(colCount == 4 || colCount ==8 || colCount==9 || colCount==10){
											out.println("style='text-align:center'>");  
											out.println(getImage(dkVal)); 
										}
										else if(colCount!=4) {
											out.println("align=\"left\">"); 	
											out.println(dkVal);
										}
											out.println("</td>"); 
										dkVal = "";	
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
						out.println(CommonBean.setForm ( request ,"../../ePH/jsp/TokenSeriesQueryResult.jsp", searched) );
					}
					catch(Exception e) {
						out.print("Exception @ Result JSP :"+e.toString());
					}
%>
<%!
		public String getImage(String value){
			if(value.equalsIgnoreCase("E") || value.equalsIgnoreCase("Y"))
				return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
			else 
				return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
		}
		public String getImage1(String value){
			if(value.equalsIgnoreCase("Y"))
				return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='Y'>";
			else 
				return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='N'>";
		}
%>
	</body>
</html>

