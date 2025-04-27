<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
---------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
19/10/2017	IN065324			Dinesh T				19/10/2017		Ramesh G		To display the price in OR screen and 																							the billing status in Manage Specimen 																							screen
22/01/2019	IN069244		Ramya Maddena		  25/01/2019		Ramesh Goli	   MMS-KH-CRF-0005.1
26/10/2020	IN067210		SIVABAGYAM M	26/10/2020	RAMESH G	ML-MMOH-CRF-1144
-------------------------------------------------------------------------------------------------------------------------------
--> 

<%@page import="java.sql.*,java.util.*,eCA.PatTaskListRepository,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
/**
	modified by Deepa on 5/14/2010 at 3:16 PM for IN021020
	added Dob and sex as part of queryString to handle multiple reference range 
**/
String Dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
String clinician_id		= (String) session.getValue("ca_practitioner_id");//IN067210
String reln_id = request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String facility_id = (String)session.getValue("facility_id");
String resp_id    					=	(String) session.getValue("responsibility_id");

String appl_task_id ="";
String task_applicability ="";
String str_appl_task ="";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
PatTaskListRepository patTask = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);
LinkedHashMap hash_values			= new LinkedHashMap();
hash_values=patTask.get_hash();
//String c_status_code=(String)hash_values.get("c_status_code");
//if(c_status_code.equals("")) c_status_code="TASK_ALL";
//IN065324, starts
patTask.adapter.clearAll();
ArrayList<String> functionIds = new ArrayList<String>();
functionIds.add("BT_VIEW_BILL_DTLS");
patTask.adapter.setSiteSpecific(functionIds,"OR");
boolean isBTViewBillDtls = patTask.adapter.isSiteSpecific("BT_VIEW_BILL_DTLS");
//IN065324, ends
//IN069244 Starts
functionIds.add("THIRDPARTY_VITALS_ACK");
patTask.adapter.setSiteSpecific(functionIds,"CA");
boolean isVitalSignDtls = patTask.adapter.isSiteSpecific("THIRDPARTY_VITALS_ACK");
System.err.println("isVitalSignDtls@@==="+isVitalSignDtls);
//IN069244 ends
ArrayList<String> tasklist =patTask.getTasklist();//IN067210

String c_taskSelect=(String)hash_values.get("c_taskSelect");
if(c_taskSelect.equals("")) c_taskSelect="";
	
	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	Hashtable tabdata =new Hashtable() ;	
	PreparedStatement	pstmt1	= null;//IN067210
	ResultSet			rs1	= null;//IN067210
	try
	{
	con = ConnectionManager.getConnection(request);
	//String applcbl_task_query= "SELECT  APPL_TASK_ID,GET_TASK_APPLICABILITY(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) TASK_APPLICABILITY FROM CA_APPL_TASK WHERE APPL_TASK_ID IN ('CA_TASK_LIST_MSPECI','CA_TASK_LIST_MEDADMN','CA_TASK_LIST_INT','CA_TASK_LIST_REGORD','CA_TASK_LIST_RESREP','CA_TASK_LIST_BLDCONS','CA_TASK_LIST_RECCONS')";
	String applcbl_task_query= "SELECT  APPL_TASK_ID,GET_TASK_APPLICABILITY(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) TASK_APPLICABILITY FROM CA_APPL_TASK WHERE APPL_TASK_ID IN ('CA_TASK_LIST_MSPECI','CA_TASK_LIST_MEDADMN','CA_TASK_LIST_INT','CA_TASK_LIST_REGORD','CA_TASK_LIST_RESREP','CA_TASK_LIST_BLDCONS','CA_TASK_LIST_RECCONS','CA_TASK_LIST_VITAL')";//IN069244

	pstmt= con.prepareStatement(applcbl_task_query);
	System.err.println("resp_id@@==="+resp_id+"reln_id=="+reln_id+"facility_id==="+facility_id+"encounter_id==="+encounter_id+"patient_id=="+patient_id);
	pstmt.setString(1,resp_id);
	pstmt.setString(2,reln_id);
	pstmt.setString(3,facility_id);
	pstmt.setString(4,encounter_id);
	pstmt.setString(5,patient_id);
	rs= pstmt.executeQuery();
	
	while (rs.next())
	{
		appl_task_id  = rs.getString("APPL_TASK_ID")==null?"":rs.getString("APPL_TASK_ID");
		task_applicability  = rs.getString("TASK_APPLICABILITY")==null?"":rs.getString("TASK_APPLICABILITY");
		tabdata.put(appl_task_id,task_applicability);
		
		if(str_appl_task.equals(""))
			str_appl_task=appl_task_id+"~"+task_applicability;
		else
		{
			str_appl_task = str_appl_task+"||"+appl_task_id+"~"+task_applicability;
		}
	}	
	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	
	}
	catch(Exception e)
	{
		out.println("Exception in TaskListLeftStatus.jsp"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

		System.err.println("appl_task_id@@==="+appl_task_id);

%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='TaskStatusForm' id='TaskStatusForm'>
<table cellpadding=3 cellspacing=0 border=0 width="100%"  height="30%" align=center>
<tr><TD id="A" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="Common.all.label" bundle="${common_labels}"/></td></tr>

<% 
     System.err.println("tabdata@@==="+tabdata);
	if (tabdata.size()> 0 ) {
	//IN067210 STARTS
	if(tasklist.isEmpty())
	{
		tasklist.add("Y");
		tasklist.add("Y");
		tasklist.add("Y");
		tasklist.add("Y");
		tasklist.add("Y");
		tasklist.add("Y");
		tasklist.add("Y");
		tasklist.add("Y");
		
	} 
	if(tabdata.get("CA_TASK_LIST_MSPECI") != null && tabdata.get("CA_TASK_LIST_MSPECI").equals("A") && tasklist.get(0).equals("Y")){%>
<tr><TD id="S" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("S")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("S")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="eOR.SpecimenOrder.label" bundle="${or_labels}"/></td></tr>
<% } 
	if(tabdata.get("CA_TASK_LIST_REGORD") != null && tabdata.get("CA_TASK_LIST_REGORD").equals("A") && tasklist.get(1).equals("Y")){%>
<tr><TD id="R" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("R")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("R")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="Common.RegisterOrder.label" bundle="${common_labels}"/></td></tr> 
<% } if(tabdata.get("CA_TASK_LIST_RESREP") != null && tabdata.get("CA_TASK_LIST_RESREP").equals("A") && tasklist.get(2).equals("Y")){%>
<tr><TD id="O" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("O")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("O")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="Common.ResultReporting.label" bundle="${common_labels}"/></td></tr>
<% } if(tabdata.get("CA_TASK_LIST_MEDADMN") != null && tabdata.get("CA_TASK_LIST_MEDADMN").equals("A") && tasklist.get(3).equals("Y")){%>
<tr><TD id="M" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("M")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("M")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="eCA.MedAdmin.label" bundle="${ca_labels}"/></td></tr> 
<% } 
if(tabdata.get("CA_TASK_LIST_INT") != null && tabdata.get("CA_TASK_LIST_INT").equals("A") && tasklist.get(4).equals("Y")){%>
<tr><TD id="I" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("I")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("I")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="Common.Intervention.label" bundle="${common_labels}"/></td></tr> 
<%}
if(tabdata.get("CA_TASK_LIST_BLDCONS") != null && tabdata.get("CA_TASK_LIST_BLDCONS").equals("A") && tasklist.get(5).equals("Y")){%>
<tr><TD id="B" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("B")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("B")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="eCA.BloodUnitCons.label" bundle="${ca_labels}"/></td></tr> 
<%}//IN29559 -Start
if(tabdata.get("CA_TASK_LIST_RECCONS") != null && tabdata.get("CA_TASK_LIST_RECCONS").equals("A") && tasklist.get(6).equals("Y")){%>
<tr><TD id="C" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("C")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("C")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="eCA.PendingConsent.label" bundle="${ca_labels}"/></td></tr> 
<%}//IN2955,ends//IN069244 Starts,
if(isVitalSignDtls){
if(tabdata.get("CA_TASK_LIST_VITAL") != null && tabdata.get("CA_TASK_LIST_VITAL").equals("A") && tasklist.get(7).equals("Y")){%>
<tr><TD id="V" background='../../eCA/images/MCT_FullStrip.gif' style='height:30;<%=c_taskSelect.equals("V")?"font-weight:bold;color:#0000FF":""%>' onclick='applycode("V")' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='pointer';">&nbsp;<fmt:message key="eCA.InterVitalSignData.label" bundle="${ca_labels}"/></td></tr> 
<%}}//IN069244 ends
}//IN067210ENDS
%>

</table>


<input type='hidden' name='task_code' id='task_code' value='<%=c_taskSelect%>'>
<input type='hidden' name='c_task_Select' id='c_task_Select' value='<%=c_taskSelect%>'>
<input type='hidden' name='str_appl_task' id='str_appl_task' value='<%=str_appl_task%>'>
<!-- modified by Deepa on 5/14/2010 at 3:16 PM for IN021020
	added Dob and sex as part of queryString to handle multiple reference range -->
<input type='hidden' name='dob' id='dob' value='<%=Dob%>'>
<input type='hidden' name='sex' id='sex' value='<%=sex%>'>
<input type="hidden" name="isBTViewBillDtls" id="isBTViewBillDtls" value="<%=isBTViewBillDtls%>"><!--IN065324-->
</form>
</body>
</html>
<%



%>
<%putObjectInBean("patTask",patTask,session);%>

