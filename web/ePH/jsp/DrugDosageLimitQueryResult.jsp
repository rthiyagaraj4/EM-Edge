<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugDosageLimit.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
		String drug_code		= request.getParameter( "drug_code" );
		String drug_desc		= request.getParameter( "drug_desc" ) ;
		String generic_name     = request.getParameter( "generic_name" ) ;
		String form_desc     	= request.getParameter( "form_desc" ) ;
		String age_group_desc   = request.getParameter( "age_group_desc" ) ;
		boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;
		String dkVal ="";

		try{
		
			String classvalue			= "";
			drug_code = CommonBean.checkForNull( drug_code.trim() );
			drug_desc = CommonBean.checkForNull( drug_desc.trim() );
			generic_name = CommonBean.checkForNull( generic_name.trim() );
			form_desc = CommonBean.checkForNull( form_desc.trim() );
			age_group_desc = CommonBean.checkForNull( age_group_desc.trim() );
							
				//Common parameters.
			HashMap sqlMap = new HashMap();
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DOSG_LMT_SELECT3"));
			sqlMap.put( "sqlData", " SELECT A.DRUG_CODE,B.DRUG_DESC, A.AGE_GROUP_CODE,C.SHORT_DESC AGE_GROUP_DESC, A.LOW_OF_UNIT_DOSAGE, A.HIGH_OF_UNIT_DOSAGE, A.LOW_OF_DAILY_DOSAGE, A.HIGH_OF_DAILY_DOSAGE, B.FORM_CODE,D.FORM_DESC , E.GENERIC_NAME,B.STRENGTH_VALUE, DECODE(A.GENDER,'M','male','F','female','U','unknown') GENDER, B.PRES_BASE_UOM, F.SHORT_DESC PRES_BASE_DESC, A.MIN_AGE,A.MAX_AGE,A.AGE_UNIT, G.ROUTE_DESC,A.CALC_BY_IND FROM PH_DOSAGE_LIMIT_FOR_AGE_GROUP A, PH_DRUG_LANG_VW B, AM_AGE_GROUP_LANG_VW C, PH_FORM_LANG_VW D ,PH_GENERIC_NAME_LANG_VW E, AM_UOM_LANG_VW F, PH_ROUTE_LANG_VW G WHERE  A.DRUG_CODE=B.DRUG_CODE AND A.AGE_GROUP_CODE=C.AGE_GROUP_CODE AND B.FORM_CODE=D.FORM_CODE(+) AND B.GENERIC_ID=E.GENERIC_ID(+) AND B.PRES_BASE_UOM=F.UOM_CODE(+) AND B.ROUTE_CODE = G.ROUTE_CODE (+) AND A.DRUG_CODE LIKE UPPER(?) AND UPPER(B.DRUG_DESC) LIKE UPPER(?) AND UPPER(E.GENERIC_NAME) LIKE UPPER(?)  AND UPPER(D.FORM_DESC) LIKE UPPER(?) AND UPPER(C.SHORT_DESC) LIKE UPPER(?) AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.LANGUAGE_ID(+) = ? AND E.LANGUAGE_ID(+) = ? AND F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ?");
			
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields that are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "drug_code" );
			displayFields.add( "drug_desc" );
			displayFields.add( "generic_name" );
			displayFields.add( "strength_value" );
			displayFields.add( "calc_by_ind" );
			displayFields.add( "age_group_code" );
			displayFields.add( "age_group_desc" );
			displayFields.add( "gender" );
			displayFields.add( "min_age" );
			displayFields.add( "max_age" );
			displayFields.add( "pres_base_desc" );			

			ArrayList chkFields = new ArrayList();
			chkFields.add( drug_code.trim() + "%" );
			chkFields.add( drug_desc.trim() + "%" );
			chkFields.add( generic_name.trim() + "%" );
			chkFields.add( form_desc.trim() + "%" );
			chkFields.add( age_group_desc.trim() + "%" );
			chkFields.add( locale );
			chkFields.add( locale );
			chkFields.add( locale );
			chkFields.add( locale );
			chkFields.add( locale );
			
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
						<th><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th><th><fmt:message key="ePH.CalculateBy.label" bundle="${ph_labels}"/></th><th colspan="2"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/> </th><th><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th><th colspan="2"><fmt:message key="Common.AgeUnit.label" bundle="${common_labels}"/></th><th><fmt:message key="ePH.BaseUnit.label" bundle="${ph_labels}"/></th>
					</tr>
					<tr>
						<th colspan="5">&nbsp;</th><th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th><th>Desc</th> <th>&nbsp;</th><th><fmt:message key="Common.MIN.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.Max.label" bundle="${common_labels}"/></th><th>&nbsp;</th>
					</tr>
<%
			//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
%>
						<tr onClick="Modify(this);" >
<%
							String link_columns = "1";
							records=(ArrayList) result.get( recCount );
							for(int colCount=0; colCount<records.size(); colCount++){
								if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>
									<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=(String)records.get( colCount )%>    </font></td>
<%
								}
								else {				
									dkVal = (String)records.get( colCount );
									if (colCount==7 && dkVal!= null && !dkVal.equals("")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+dkVal+".label","common_labels");
									}
%>
									<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>" align=\"left\">
<%	
									if(dkVal == null)	
										dkVal = "&nbsp" ;
									if(dkVal.equals("")) 
										dkVal = "&nbsp;";
									
									if (colCount==3 && dkVal.equals("0")){
										dkVal="&nbsp";
									}
									if(colCount==4)
									{
										if(dkVal.equals("A"))
											dkVal="Absolute";
										else if(dkVal.equals("B"))
											dkVal="BSA";
										else if(dkVal.equals("W"))
											dkVal="Weight";
										else
											dkVal="&nbsp";
									}

									out.println(dkVal);
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
				out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugDosageLimitQueryResult.jsp", searched) );
			} catch(Exception e) {
				out.print("Exception @ Result JSP :"+e.toString());
			}
%>
	</body>
</html>

