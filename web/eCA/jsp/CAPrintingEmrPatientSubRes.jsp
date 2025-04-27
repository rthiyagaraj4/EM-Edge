<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
07/05/2019		ML-MMOH-CRF-1064	Kamalakannan G		07/05/2019		Ramesh Goli		IN066304
20/06/2019		IN070766			Ramesh Goli			20/06/2019		Ramesh Goli		 Regression-CA-ML-MMOH-CRF-1064/03-Select ALL
---------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eOR.Common.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String date_from = request.getParameter("date_from")==null?"":request.getParameter("date_from");
	String date_to = request.getParameter("date_to")==null?"":request.getParameter("date_to");
	 String bean_id					= "CAClinicalHistoryBean" ;
	 String bean_name				= "eCA.CAClinicalHistoryBean";
	 String selectAllDisable = "disabled";
	
	 CAClinicalHistoryBean bean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
	 bean.setLanguageId(localeName); //IN070732
	 LinkedHashMap<String,String> histTypeGenerator = bean.getHistoryTypes();//get all hist type
	 bean.clearParMap();
	 bean.setLanguageId(localeName);
	
	 //LinkedHashMap<String,String> map=bean.updateAllClinicalNotePrintingFlags("CLNT","N");
	 String flag = request.getParameter("flag")==null?"":request.getParameter("flag");
	 if("N".equals(flag)){
		 bean.clearMapObject();
	 }
	 HashMap<String,String> allEvenClass=bean.getAllEventClasses("N");//HashMap for hidden fields
	 HashMap<String,ArrayList<String[]>> applicableRecords = bean.getApplicableRecords(patient_id,date_from,date_to,encounter_id); //get applicable hist type
	 HashMap<String,String> applicableEventClass = new HashMap<String,String>();
	 HashMap<String,HashMap<String,ArrayList<String>>> applicablePrintingValues = bean.applicablePrintingValues(patient_id, date_from, date_to, encounter_id);//MAIN FUNCTION
	 if(applicableRecords.size()!=0)
	 	selectAllDisable = "";
	 for (Map.Entry<String,ArrayList<String[]>> entry : applicableRecords.entrySet()) {
		String key = entry.getKey();
		String result = "";
		Set<String> applicableEventClassList = new HashSet<String>();
		ArrayList<String[]> value = (ArrayList<String[]>)entry.getValue();
		for(int i=0 ; i<value.size(); i++){
			String[] str = value.get(i);
			applicableEventClassList.add(str[0]);
		}
		Iterator iterator = applicableEventClassList.iterator();
		while(iterator.hasNext()){
			if("".equals(result)){
				result = result+iterator.next();
			}else{
				result = result+","+iterator.next();
			}
		}
		applicableEventClass.put(key,result);
		
	 }
	 String appHistTypes = "";
	// System.out.println("applicableRecords==>"+applicableEventClass);
	 %>
  	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css' />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language='javascript' src='../../eCA/js/CAPrintingEmrPatient.js'> </script>
	<script language='javascript' src='../../eCA/js/ClinicEventParameter.js'> </script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css" />
<style>
	.test{
		position:relative;
		display:block;
	}
		.overlay {
	  background: white;
	  position: absolute;
	  display: block;
	 }
</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="CAPrintingEmrPatientSubRes" id="CAPrintingEmrPatientSubRes" action='../../eOR/jsp/NewProcedureQueryResult.jsp' method="post">
		<table width="90%">
		<tr>
			<td>
				<input type='checkbox' name='select_all' id='select_all' value='N' <%=selectAllDisable%> onClick="selectAll(this,'<%=patient_id%>','<%=encounter_id%>','<%=date_from%>','<%=date_to%>')">
			</td>
			<td>
				Select All
			</td>
		</tr>
				<%
				int i = 1;
				int j = 1;
				for (Map.Entry<String,String> entry : histTypeGenerator.entrySet()) { 
					String disabled = "disabled";
					Boolean disableClick = false;
					String eventClassList = "";
					if(j==1){%>
						<tr>
				<%}%>
				<%
				for (Map.Entry<String,ArrayList<String[]>> rec : applicableRecords.entrySet()) {
					if((rec.getKey()).equals(entry.getKey())){
						disabled = "";
						disableClick = true;
						if("".equals(appHistTypes)){
							appHistTypes = entry.getKey();
						}else{
							appHistTypes = appHistTypes+"_"+entry.getKey();
						}
						eventClassList = applicableEventClass.get(rec.getKey());
					}
				 }
				
				%>
					<td><input type='checkbox' name='<%=entry.getKey()%>_yn' id='<%=entry.getKey()%>_yn' value='N' <%=disabled%> onClick="hideToolTip(this,'imgArrow<%=i%>');clntParentCheckBox(this,'<%=eventClassList%>','<%=patient_id%>','<%=encounter_id%>','<%=date_from%>','<%=date_to%>')"></td>
				
				<td>
					<table>
						<tr>
							<td nowrap id='orderctl<%=i%>' style='cursor:pointer' <%if(disableClick){%>onClick="displayToolTip1(this,'imgArrow<%=i%>','<%=entry.getKey()%>','<%=eventClassList%>')" onMouseOver="hideToolTip(this,'imgArrow<%=i%>')"<%}%> >
								<%=entry.getValue()%>
							</td> 
						</tr>
					</table>
				</td>
				<%
				if(j==5){
					j=1;%>
					</tr>
				<%}else{
					j++;
				}
				i++;
				} %>
			</tr>
		</table>
	<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
		<tr >
			<td align="right" valign="middle">
				<input type="button" align="right" value="Print" onClick="valsForPrint('PRINT')">
				<input type="button" align="right" value="View" onClick="valsForPrint('VIEW')">
			</td>
		<tr>	
	</table>	
	<%
		for (Map.Entry<String,String> entry : allEvenClass.entrySet()) {
         %>
         <input type='hidden' name='<%=entry.getKey()%>' id='<%=entry.getKey()%>' value='<%=entry.getValue()%>'>
		<%} 
		//System.out.println("appHistTypes==>"+appHistTypes);
	%>
		  <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
		  <input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		  <input type='hidden' name='date_from' id='date_from' value='<%=date_from%>'>
		  <input type='hidden' name='date_to' id='date_to' value='<%=date_to%>'>
		  <input type='hidden' name='app_hist_types' id='app_hist_types' value='<%=appHistTypes%>'>
	</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue' border='1'>
			<div class='overlay' width='100%' id='t' style='height:150px; overflow-y: scroll; overflow-x: hidden;' border='1'>
	</div>
	</div>
</body>
</html>

