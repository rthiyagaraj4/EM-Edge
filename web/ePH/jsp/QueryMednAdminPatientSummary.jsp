<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
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
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
	<!--<body  onKeyDown="lockKey()"  onKeyDown = 'lockKey()' >-->
	<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()"> 
		<form name="QueryMednAdminChartSummary" id="QueryMednAdminChartSummary">
<%
		String  patientid	=	request.getParameter("patientid");
		String  encounterid	=	request.getParameter("encounterid");	
		String  patient_class	=	request.getParameter("patient_class");
		String  called_from	=	request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String  orig_patient_class="";
		
		if(patient_class.equals("IP")) // ||patient_class.equals("DC") -- code removed for ML-BRU-SCF-0499[IN035594]
			orig_patient_class="IP";
		else if(patient_class.equals("DC")) //else part added for ML-BRU-SCF-0499[IN035594] 
				orig_patient_class="DC";		
		else if(patient_class.equals("E"))
			orig_patient_class="EM";
		else if(patient_class.equals("EM"))
			orig_patient_class="EM";
		else if(patient_class.equals("OP"))
			orig_patient_class="OP";
		else if(patient_class.equals("O"))
			orig_patient_class="OP";
	  

		String qstring	="";
		if(encounterid==null) encounterid="";
		String bean_id		= "QueryMednAdminChartBean";
		String bean_name	= "ePH.QueryMednAdminChartBean";
		QueryMednAdminChartBean bean			= (QueryMednAdminChartBean)getBeanObject(bean_id,bean_name, request);
		
		String ord[]		= request.getParameterValues("orderbycolumns");
		boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
		ArrayList result=new ArrayList();

		try{	
			patientid		= CommonBean.checkForNull( patientid );
			encounterid		= CommonBean.checkForNull( encounterid );	
		
			//Common parameters.
			HashMap sqlMap = new HashMap();
			ArrayList chkFields = new ArrayList();

			//include all the common parameters.
			//String sql=PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT2");
			//	String sql="SELECT  DISTINCT A.ENCOUNTER_ID, ASSIGN_BED_NUM, C.PATIENT_NAME, A.PATIENT_ID, GET_AGE (C.DATE_OF_BIRTH) AGE, DECODE (C.SEX, 'M', 'male', 'F', 'female', 'unknown') GENDER, (SELECT SHORT_NAME FROM MP_COUNTRY_LANG_VW MP_COUNTRY WHERE COUNTRY_CODE = C.NATIONALITY_CODE AND LANGUAGE_ID = ? ) NATIONALITY FROM  PR_ENCOUNTER A, MP_PATIENT C, PH_MEDN_ADMIN D, OR_ORDER_LINE E WHERE E.ORDER_LINE_NUM = D.ORDER_LINE_NUM AND E.ORDER_ID = D.ORDER_ID  AND C.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.ENCOUNTER_ID AND D.FACILITY_ID = A.FACILITY_ID AND C.PATIENT_ID  = ? AND a.encounter_id = nvl(?,a.encounter_id) AND D.FACILITY_ID = ? AND D.SCH_DATE_TIME >= E.ORD_DATE_TIME AND A.PATIENT_CLASS=?";   condition AND D.SCH_DATE_TIME >= E.ORD_DATE_TIME removed coz of issue:24707
			//String sql="SELECT  DISTINCT A.ENCOUNTER_ID, ASSIGN_BED_NUM, nvl( decode(?,'en',C.PATIENT_NAME, PATIENT_NAME_LOC_LANG),PATIENT_NAME) PATIENT_NAME, A.PATIENT_ID, GET_AGE (C.DATE_OF_BIRTH) AGE, DECODE (C.SEX, 'M', 'male', 'F', 'female', 'unknown') GENDER, (SELECT SHORT_NAME FROM MP_COUNTRY_LANG_VW MP_COUNTRY WHERE COUNTRY_CODE = C.NATIONALITY_CODE AND LANGUAGE_ID = ? ) NATIONALITY FROM  PR_ENCOUNTER A, MP_PATIENT C, PH_MEDN_ADMIN D, OR_ORDER_LINE E WHERE E.ORDER_LINE_NUM = D.ORDER_LINE_NUM AND E.ORDER_ID = D.ORDER_ID  AND C.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.ENCOUNTER_ID AND D.FACILITY_ID = A.FACILITY_ID AND C.PATIENT_ID  = ? AND a.encounter_id = nvl(?,a.encounter_id) AND D.FACILITY_ID = ?  AND A.PATIENT_CLASS=? ORDER BY ENCOUNTER_ID DESC ";

             //String sql = "SELECT  DISTINCT A.ENCOUNTER_ID, a.ASSIGN_BED_NUM, 	nvl( decode(?,'en',C.PATIENT_NAME, c.PATIENT_NAME_LOC_LANG),c.PATIENT_NAME) PATIENT_NAME, A.PATIENT_ID, GET_AGE (C.DATE_OF_BIRTH) AGE, DECODE (C.SEX, 'M', 'male', 'F', 'female', 'unknown') GENDER, 	(SELECT SHORT_NAME FROM MP_COUNTRY_LANG_VW MP_COUNTRY WHERE COUNTRY_CODE = C.NATIONALITY_CODE AND LANGUAGE_ID = ? ) NATIONALITY FROM    PR_ENCOUNTER A,  PH_MEDN_ADMIN b, MP_PATIENT C  WHERE	a.FACILITY_ID=b.FACILITY_ID and	a.encounter_id = b.encounter_id and	a.patient_id =b.patient_id AND	a.PATIENT_ID = c.patient_id and	a.FACILITY_ID = ? and	a.encounter_id = nvl(?,a.encounter_id) AND	c.pATIENT_ID  = ? AND	A.PATIENT_CLASS= nvl(?,a.patient_class) order by a.encounter_id desc";   //Query modified for SKR-SCF-1512(Performance)  //commented and changed below for SKR-SCF-1732

             String sql = "SELECT  DISTINCT A.ENCOUNTER_ID, a.ASSIGN_BED_NUM, 	nvl( decode(?,'en',C.PATIENT_NAME, c.PATIENT_NAME_LOC_LANG),c.PATIENT_NAME) PATIENT_NAME, A.PATIENT_ID, GET_AGE (C.DATE_OF_BIRTH) AGE, DECODE (C.SEX, 'M', 'male', 'F', 'female', 'unknown') GENDER, 	(SELECT SHORT_NAME FROM MP_COUNTRY_LANG_VW MP_COUNTRY WHERE COUNTRY_CODE = C.NATIONALITY_CODE AND LANGUAGE_ID = ? ) NATIONALITY FROM    PR_ENCOUNTER A, MP_PATIENT C  WHERE	a.FACILITY_ID = ? and	a.encounter_id = nvl(?,a.encounter_id) AND	c.pATIENT_ID  = ? and a.PATIENT_ID = c.patient_id and	A.PATIENT_CLASS= nvl(?,a.patient_class)  AND EXISTS (select 1 from ph_medn_admin where facility_id=a.facility_id and encounter_id=a.encounter_id and patient_id=a.patient_id) order by a.encounter_id desc";   //Query modified for SKR-SCF-1732(Performance)

 
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(bean.getFacilityId());
			chkFields.add(encounterid);
			chkFields.add(patientid);
			//chkFields.add(patientid);
			chkFields.add(orig_patient_class);
			//End of concatenating search conditions
			sqlMap.put( "sqlData",  sql);
			//Function Parameters
			HashMap funcMap = new HashMap();
			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add("ASSIGN_BED_NUM");
			displayFields.add("PATIENT_ID");
			displayFields.add("PATIENT_NAME");
			displayFields.add("GENDER");
			displayFields.add("AGE");
			displayFields.add("NATIONALITY");
			displayFields.add("ENCOUNTER_ID");
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			//Calling the Result from Common Adaptor as a arraylist.
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
%>	
			<input type="hidden" name="totalRows" id="totalRows" value=<%=result.size()%>>
<%
			//result ::[1, , [29, LD00000458, Martina Padua, FEMALE, 71Y, Philippines, 10061160]]
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
				if (result.get(1)!=""){
%>
					<table cellpadding=0 cellspacing=0 width="100%" align="center" topmargin='0'>
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
							// For display the previous/next link
							out.println(result.get(1));
							//out.println(result);
			
%>
							</td>
						</tr>
					</table>
<%
				}
%>
				<table id="PatientTable" name="PatientTable" id="PatientTable" border="1" cellpadding="0" cellspacing="0" width="100%" align="center" topmargin='0'>
					<tr id="header" name="header">
						<th width="10%"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
						<th width="13%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
						<th width="25%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
						<th width="12%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
						<th width="12%"><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
						<th width="15%"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></th>
						<th width="18%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
						<td id="max" style="display:none;background-color:white;cursor:pointer" width="1%"><img src="../../ePH/images/max.gif" height=18 onClick="expand();"></td>
					</tr>
 
<%
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String classvalue="";
					for(int recCount=2; recCount<result.size(); recCount++) {

						if ( recCount % 2 == 0 ){
							classvalue = "QRYODDSMALL" ;
						}
						else{	
							classvalue = "QRYEVENSMALL" ;
						}
						records=(ArrayList) result.get( recCount );
%>
						<tr id=<%=recCount%> name=<%=recCount%>>
							<input type="hidden" id="EncounterId<%=recCount%>" name="EncounterId<%=recCount%>" value=<%=(String)records.get(6)%>>
							<input type="hidden" id="PatientId<%=recCount%>" name="PatientId<%=recCount%>" value=<%=(String)records.get(1)%>>
							<input type="hidden" id="BedNo<%=recCount%>" name="BedNo<%=recCount%>" value=<%=(String)records.get(0)%>>
<%
	
							qstring	=	"";
							for(int colCount=0; colCount<records.size(); colCount++){
					
								/*	if (colCount>6){
									continue;
								}*/
								String dkVal = (String)records.get( colCount );
								if(dkVal == null)	
									dkVal = "&nbsp" ;
								if(dkVal.equals("")) 
									dkVal = "&nbsp;";
								if (colCount==1){
									//patient id
								qstring="relevantencounter="+(String)records.get(6);
%>
								<td class='<%=classvalue%>' style="cursor:pointer;color:blue" onClick="clickPatient('<%=recCount%>','<%=qstring%>',4,'<%=qstring%>','<%=patient_class%>','<%=called_from%>')">
<%
								out.println(dkVal);
							}					
							else if (colCount==5){
								out.println("<td   class='"+classvalue+"'>");
								out.println(dkVal);
							}               
							else if (colCount==3){
								out.println("<td class='"+classvalue+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+dkVal+".label","common_labels"));
							}
							else{
								out.println("<td class='"+classvalue+"'>");
								out.println(dkVal);
							}
							out.println("</td>");	
						}//emulate the clicking action and hide the top frame if only one record is present
						/*if (result.size()==3){
							out.println("<script>clickPatient('"+recCount+"','"+qstring+"',3,'','"+patient_class+"')</script>");
						}	*/
					}			//end of record count
				}
				else{
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); </script>
<%
				}
%>
				</tr>
<%
				out.println(CommonBean.setForm( request ,"../../ePH/jsp/QueryMednAdminPatientSummary.jsp", searched) );
				if (result.size()==3){
%>
					<script>			
					if(document.forms[0].from.value==""){
						clickPatient('2','<%=qstring%>',3,'','<%=patient_class%>','<%=called_from%>');
					}
					</script>
<%	
				}	
			}//end of try
			catch (Exception e){
				out.print("Exception @ Result JSP :"+e.toString());
			}
%>
			</table>
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

