<!DOCTYPE html>
<HTML>
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,com.ehis.util.DateUtils,java.util.Map,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/ViewEvents.css' type='text/css'></link>

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script language="javascript">

function funSubmit()
{
	parent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.action = '../../eXH/jsp/XHPatientMembershipCheckResult.jsp';
	parent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.target="resultFrame";
	parent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.submit();
}

function funAction(typ)
{  
	parent.resultFrame.PAYER_CHECK_ELIGIBILITY_FORM.action_type.value = typ;
	funSubmit();
}

//function callForOrderBy
function callForOrderBy(obj,order)
{	
	if(order == 'A') obj = obj + ' asc';
	if(order == 'D') obj = obj + ' desc';
	var url = '&orderBy=' + obj + '&order=' + order;

	this.document.forms[0].action_type.value = "";
	this.document.forms[0].action = "../../eXH/jsp/XHPatientMembershipCheckResult.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
}

async function checkEligibility(obj)
{
	var patient_id = obj.getAttribute('patient_id');
	var encounter_id = obj.getAttribute('encounter_id');
	var pat_name = obj.getAttribute('pat_name');
	var national_id = obj.getAttribute('national_id');
	var pat_dob = obj.getAttribute('pat_dob');
	var pat_contactno = obj.getAttribute('pat_contactno');
	var membership_no = obj.getAttribute('membership_no');
	var policy_holder_name = obj.getAttribute('policy_holder_name');
	var policy_number = obj.getAttribute('policy_number');
	var pStartDate = obj.getAttribute('pStartDate');
	var pEndDate = obj.getAttribute('pEndDate');
	var provider_code = obj.getAttribute('provider_code');
	var service_code = obj.getAttribute('service_code');
	var payer_code = obj.getAttribute('payer_code');
	var policy_type_code = obj.getAttribute('policy_type_code');
	var billing_group_id = obj.getAttribute('billing_group_id');
	var p_g_desc = obj.getAttribute('p_g_desc');
	var priority = obj.getAttribute('priority');
	var payerName = obj.getAttribute('payerName');
	var nursing_unit_code = obj.getAttribute('nursing_unit_code');
	var visit_adm_date_time = obj.getAttribute('visit_adm_date_time');
	var effectiveFrom = obj.getAttribute('effectiveFrom');
	var effectiveTo = obj.getAttribute('effectiveTo');
	var billing_group_desc = obj.getAttribute('bl_g_desc');

	var policy_type_desc = obj.getAttribute('policy_type_desc');

	var operating_facility_id = obj.getAttribute('operating_facility_id');
	var episode_id = obj.getAttribute('episode_id');
	var visit_id = obj.getAttribute('visit_id');
	var episode_type = obj.getAttribute('eptype');
	var asno = obj.getAttribute('asno');
	var slid = obj.getAttribute('settlement_ind');

	var trans_id = obj.getAttribute('trans_id');
	var respDTime = obj.getAttribute('respDTime');
	var resp_code = obj.getAttribute('resp_code');
	var elg_code = obj.getAttribute('elgCode');
	var err_msg = obj.getAttribute('err_msg');
	var remarks = obj.getAttribute('remarks');
	var validity_type = obj.getAttribute('validity_type');
	var validity_until = obj.getAttribute('validity_until');


	var dialogHeight = "65vh";			    
	var dialogWidth  = "55vw";
	var dialogTop    = "0vh";
	var title=getLabel("eBL.ADD_PAYER.label","BL");
	title=encodeURIComponent(title);
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	policy_type_desc = encodeURIComponent(policy_type_desc);
	billing_group_desc = encodeURIComponent(billing_group_desc);
	payerName = encodeURIComponent(payerName);

	/* var params= "title="+title+"&pid="+patient_id+"&eid="+encounter_id+"&nuc="+nursing_unit_code+"&pst="+pStartDate+"&ped="+pEndDate+"&pn="+pat_name+"&pdob="+pat_dob+"&ni="+national_id+"&pcn="+pat_contactno+"&mcn="+membership_no+"&phn="+policy_holder_name+"&pln="+policy_number+"&pdc="+provider_code+"&sc="+service_code+"&pyc="+payer_code+"&ptc="+policy_type_code+"&bgi="+billing_group_id+"&pgd="+p_g_desc+"&prio="+priority+"&pyname="+payerName+"&vdt="+visit_adm_date_time+"&eff="+effectiveFrom+"&eft="+effectiveTo+"&bgd="+billing_group_desc+"&ofd="+operating_facility_id+"&epid="+episode_id+"&vsid="+visit_id;  */

	var params= "title="+title+"&pid="+patient_id+"&eid="+encounter_id+"&pst="+pStartDate+"&ped="+pEndDate+"&pn="+pat_name+"&mcn="+membership_no+"&phn="+policy_holder_name+"&pln="+policy_number+"&pdc="+provider_code+"&sc="+service_code+"&pyc="+payer_code+"&ptc="+policy_type_code+"&bgi="+billing_group_id+"&pgd="+p_g_desc+"&prio="+priority+"&pyname="+payerName+"&vdt="+visit_adm_date_time+"&eff="+effectiveFrom+"&eft="+effectiveTo+"&bgd="+billing_group_desc+"&ofd="+operating_facility_id+"&epid="+episode_id+"&vsid="+visit_id+"&eptype="+episode_type+"&asno="+asno+"&slid="+slid+"&ptydesc="+policy_type_desc+"&transId="+trans_id+"&respDTime="+respDTime+"&respCode="+resp_code+"&elgCode="+elg_code+"&errMsg="+err_msg+"&remarks="+remarks+"&validityType="+validity_type+"&validity_until="+validity_until;
	//var act = '../../eXH/jsp/XHPatientMembershipEligibilityCheck.jsp';
	
	var arguments = new Array();
	var url = "../../eXH/jsp/XHPatientMembershipEligibilityCheck.jsp?" +params;
	
	var retVal = await window.showModalDialog(url,arguments,features);

}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown='' >
<form name="PAYER_CHECK_ELIGIBILITY_FORM" id="PAYER_CHECK_ELIGIBILITY_FORM" method="POST" action=''  >
<%
String order = "";
String orderBy = "";
String action_type=null;
Connection conn = null;
Statement stmt=null;
ResultSet rset=null ;
HttpSession httpSession = request.getSession(false);
String facilityId = (String)httpSession.getValue("facility_id");
String patient_id= XHDBAdapter.checkNull(request.getParameter("patient_id"));
String encounter_id = XHDBAdapter.checkNull(request.getParameter("encounter_id"));
String practitioner_id = XHDBAdapter.checkNull(request.getParameter("practitioner_id"));
String patient_class = XHDBAdapter.checkNull(request.getParameter("patient_class"));
String nursing_unit_code = XHDBAdapter.checkNull(request.getParameter("nursing_unit_code"));
String period_dt1 = XHDBAdapter.checkNull(request.getParameter("period_dt1"));
if(period_dt1!="" && period_dt1!=null)
{
   period_dt1 = period_dt1+ " 00:00:00";
}

String period_dt2 = XHDBAdapter.checkNull(request.getParameter("period_dt2"));
if(period_dt2!="" && period_dt2!=null)
{
   period_dt2 =period_dt2 + " 23:59:59";
}
String cust_id = XHDBAdapter.checkNull(request.getParameter("cust_id"));
String function_id = XHDBAdapter.checkNull(request.getParameter("function_id"));

String eligibility_check = XHDBAdapter.checkNull(request.getParameter("eligibility_check"));

String cust_group_code = XHDBAdapter.checkNull(request.getParameter("cust_group_code"));

String application_id = XHDBAdapter.checkNull(request.getParameter("application_id"));

System.out.println("XHPatientMembershipCheckResult.jsp:::cust_group_code....."+cust_group_code);
System.out.println("XHPatientMembershipCheckResult.jsp:::eligibility_check....."+eligibility_check);
System.out.println("XHPatientMembershipCheckResult.jsp:::application_id....."+application_id);
System.out.println("XHPatientMembershipCheckResult.jsp:::period_dt1....."+period_dt1+" period_dt2 :::: "+period_dt2);

/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

action_type = XHDBAdapter.checkNull(request.getParameter("action_type"));

boolean  boolToggle = true;
String strTDClass = "";
String whereClause = "";
try
{ 
    conn = ConnectionManager.getConnection(request);

	/* whereClause = "WHERE a.cust_code = b.cust_code AND a.SETTLEMENT_IND = 'X' AND a.patient_id = c.patient_id and a.CUST_GROUP_CODE = d.CUST_GROUP_CODE and a.patient_id = e.patient_id and a.encounter_id = e.encounter_id AND E.SERVICE_CODE = F.SERVICE_CODE AND A.POLICY_TYPE_CODE = G.POLICY_TYPE_CODE AND A.BLNG_GRP_ID = H.BLNG_GRP_ID"; */

    
	/* WHERE OPERATING_FACILITY_ID = '02' 
and ENC_REGN_DATE_TIME BETWEEN TO_DATE('01/01/2017 00:00:00', 'DD/MM/YYYY HH24:MI:SS') AND TO_DATE('21/03/2017 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
and int_response_code IN (SELECT TO_NUMBER(LIST_ELMT_VALUE) FROM SM_LIST_ITEM WHERE LIST_REF = 'HSELIGIFL' AND  MODULE_ID = 'XH')  */

    whereClause = "WHERE OPERATING_FACILITY_ID ='"+facilityId+"'";

    if( (period_dt1!="" && period_dt1!=null) && (period_dt2!="" && period_dt2!=null))
	{
	   whereClause=whereClause+" AND ENC_REGN_DATE_TIME BETWEEN TO_DATE('"+period_dt1+"', 'DD/MM/YYYY HH24:MI:SS') AND TO_DATE('"+period_dt2+"', 'DD/MM/YYYY HH24:MI:SS')";
	}

	if(application_id!=null && application_id!="")
	{ 
       whereClause=whereClause+" AND application_id = NVL('"+application_id+"',application_id)";
	}
	
	if(eligibility_check!=null && eligibility_check!="")
	{ 
       whereClause=whereClause+" AND INT_RESPONSE_CODE = NVL('"+eligibility_check+"',INT_RESPONSE_CODE)";
	}
	else
	{
		whereClause=whereClause+" AND int_response_code IN (SELECT TO_NUMBER(LIST_ELMT_VALUE) FROM SM_LIST_ITEM WHERE LIST_REF = 'HSELIGIFL' AND  MODULE_ID = 'XH')";
	}

    if(patient_id!=null && patient_id!="")
	{
	   whereClause=whereClause+" AND patient_id = NVL('#patient_id',patient_id)";
	}

	if(encounter_id!=null && encounter_id!="")
	{
	   whereClause=whereClause+" AND encounter_id = NVL('#encounter_id',encounter_id)";
	}

	if(cust_id!="" && cust_id!=null)
	{
	   whereClause=whereClause+" AND CUST_CODE = NVL('#cust_id',CUST_CODE)";
	}

	if(cust_group_code!="" && cust_group_code!=null)
	{
	   whereClause=whereClause+" AND CUST_GROUP_CODE = NVL('"+cust_group_code+"',CUST_GROUP_CODE)";
	}


	if(practitioner_id!="" && practitioner_id!=null)
	{
	   whereClause=whereClause+" AND NVL(attend_practitioner_id,admit_practitioner_id) = NVL('#practitioner_id',NVL(attend_practitioner_id,admit_practitioner_id))";
	}

	if(patient_class!="" && patient_class!=null)
	{
	   whereClause=whereClause+" AND EPISODE_TYPE = NVL(DECODE('#patient_class','IP','I','OP','O','EM','E','DC','D'),EPISODE_TYPE)";
	}

	if(nursing_unit_code!="" && nursing_unit_code!=null)
	{
	   whereClause=whereClause+" AND ASSIGN_CARE_LOCN_CODE = NVL('#nursing_unit_code',ASSIGN_CARE_LOCN_CODE)";
	}

	
	if(whereClause.length()<=7)
	{
		if(orderBy.equals("")||orderBy==null)
		{
					whereClause="";
		}
		else
		{
		   whereClause=whereClause+" order  By patient_id";	 
		}
	}
			
    else
	{
		 whereClause=whereClause +" order  By patient_id";
	}

	      
    System.out.println("whereClause....."+whereClause);
    request.setAttribute(XHQueryRender.strQueryId,"PAYERELIGIBILITYCHECK");		
	request.setAttribute(XHQueryRender.col,"47"); 
	request.setAttribute(XHQueryRender.maxRec,"10");
	request.setAttribute(XHQueryRender.whereClause,whereClause);
    HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	System.out.println("boolPrevious...."+boolPrevious);
	System.out.println("boolNext...."+boolNext);
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
      System.out.println("action_type in jsp...."+action_type);

	 Map<String,String> responseStatusMap = new HashMap<String,String>();
	 try															    
		{  
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='XH' AND list_ref='HSELIGIFL'";
			stmt = conn.createStatement();
			rset =	stmt.executeQuery(queryApplication);			
			
			while(rset.next())
			{				
				responseStatusMap.put(rset.getString(1).toString().trim(),rset.getString(2));
			}
		}
		catch(Exception e1)
		{
			System.out.println("(XHPatientMembershipCheckResult.jsp:Exception-1) "+e1.toString());
		}
		finally{

             try{
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
				}
				catch(Exception e)
				{

				}
		}
     %> 
		     <input type='hidden' name='action_type' id='action_type' value='<%=action_type%>'>

		    <input type='hidden' name='function_id' id='function_id' id="function_id" value='<%=function_id%>'>   	

			<input type='hidden' name='patient_id' id='patient_id' value=<%=patient_id %> >
			<input type='hidden' name='encounter_id' id='encounter_id' value=<%=encounter_id%>>
			<input type='hidden' name='practitioner_id' id='practitioner_id' value=<%=practitioner_id%>>
			<input type='hidden' name='patient_class' id='patient_class' value=<%=patient_class %>>
			<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value=<%=nursing_unit_code %>>
			<input type='hidden' name='period_dt1' id='period_dt1' value=<%=period_dt1 %>>
			<input type='hidden' name='period_dt2' id='period_dt2' value=<%=period_dt2 %>>
			<input type='hidden' name='cust_id' id='cust_id' value=<%=cust_id %>>  
			<input type='hidden' name='eligibility_check' id='eligibility_check' value=<%=eligibility_check %>>
			<input type='hidden' name='cust_group_id' id='cust_group_id' value=<%=cust_group_code %>>  
			
			<input type='hidden' name='pat_name' id='pat_name' value="">
			<input type='hidden' name='pat_dob' id='pat_dob' value="">
			<input type='hidden' name='national_id' id='national_id' value="">
			<input type='hidden' name='pat_contactno' id='pat_contactno' value="">		  
			<input type='hidden' name='membership_no' id='membership_no' value="">
			<input type='hidden' name='policy_holder_name' id='policy_holder_name' value="">
			
			<input type='hidden' name='provider_code' id='provider_code' value="">
			<input type='hidden' name='service_code' id='service_code' value="">
			<input type='hidden' name='payer_code' id='payer_code' value="">
			<input type='hidden' name='settlement_ind' id='settlement_ind' value="">

			<input type='hidden' name='billing_group_id' id='billing_group_id' value="">
			<input type='hidden' name='cust_name' id='cust_name' value="">
			<input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value="">
			<input type='hidden' name='sex' id='sex' value="">  

		   <input type='hidden' name='bl_g_code' id='bl_g_code' value="">
		   <input type='hidden' name='bl_g_desc' id='bl_g_desc' value="">
		   <input type='hidden' name='p_g_desc' id='p_g_desc' value="">
		   <input type='hidden' name='payerName' id='payerName' value="">
		   <input type='hidden' name='priority' id='priority' value="">
		   <input type='hidden' name='policy_number' id='policy_number' value="">
		   <input type='hidden' name='policy_type_code' id='policy_type_code' value="">
		   <input type='hidden' name='policy_type_desc' id='policy_type_desc' value="">
		   <input type='hidden' name='pStartDate' id='pStartDate' value="">
		   <input type='hidden' name='pEndDate' id='pEndDate' value="">
		   <input type='hidden' name='effectiveFrom' id='effectiveFrom' value="">
		   <input type='hidden' name='effectiveTo' id='effectiveTo' value="">

		   <input type='hidden' name='operating_facility_id' id='operating_facility_id' value="">
		   <input type='hidden' name='episode_id' id='episode_id' value="">
		   <input type='hidden' name='visit_id' id='visit_id' value="">
		   <input type='hidden' name='eptype' id='eptype' value="">
		   <input type='hidden' name='asno' id='asno' value="">

		   <input type='hidden' name='trans_id' id='trans_id' value="">
		   <input type='hidden' name='respDTime' id='respDTime' value="">
		   <input type='hidden' name='resp_code' id='resp_code' value="">
		   <input type='hidden' name='elgCode' id='elgCode' value="">
		   <input type='hidden' name='validity_type' id='validity_type' value="">
		   <input type='hidden' name='err_msg' id='err_msg' value="">
		   <input type='hidden' name='remarks' id='remarks' value="">
		   <input type='hidden' name='validity_until' id='validity_until' value="">
		   <input type='hidden' name='userId' id='userId' value="">

	 <%

		if(arrRow.size()==0)
		{
		%>	
			<script>
			//	parent.f_query_footer.location.href='../../eCommon/html/blank.html';
				alert(getMessage('XH1021','XH'));
				history.go(-1);
				/*var function_id=parent.document.getElementById("function_id").value;
				parent.f_query_add_mod.location.href='../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id='+function_id;
				parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';	   */
				parent.resultFrame.location.href='../../eCommon/html/blank.html';

			</script>
																						
			<%
		}
		else
		{
		%> 

	<table cellspacing=0 cellpadding=3 width='100%' align=center border=1>
	<tr>
		<td colspan="27" class="COLUMNHEADER" align='center'>Patient Eligibility Check</td>
	</tr>
	<tr>	   
		<td align="right" class="CAGROUP" > 
			<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
			<A class='label' onClick="funAction('N')" style='cursor:pointer'><%= strNext %></A>
		</td>
	</tr>
	</table>
	<div id="left_child" style="display:inline;">
	<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' border=1 align=center>	
		<tr>
			
			<td class='COLUMNHEADER' width='6%'>
				<font color=white><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='8%'>
				<font color=white><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='6%'>
				<font color=white><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='20%'>
				<font color=white><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='5%'>
				<font color=white><fmt:message key="Common.gender.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='8%'>
				<font color=white><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='10%'>
				<font color=white><fmt:message key="Common.service.label" bundle="${common_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='12%'>
				<font color=white><fmt:message key="eBL.CompanyName.label" bundle="${bl_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='6%'>
				<font color=white><fmt:message key="Common.ByUser.label" bundle="${bl_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='6%'>
				<font color=white><fmt:message key="Common.requesteddate.label" bundle="${bl_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='12%'>
				<font color=white><fmt:message key="Common.Response.label" bundle="${bl_labels}"/></font>
			</td>
			<td class='COLUMNHEADER' width='5%'>
				<font color=white><fmt:message key="eXH.CHECK_ELIGI_DETAILS.Label" bundle="${xh_labels}"/></font>
			</td>
		</tr>

		<%
		for (int j=0; j<arrRow.size();j++)
		{
			arrCol = (ArrayList)arrRow.get(j);
			if (boolToggle == true)
			{
				strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}
		%>

		<tr>
		<td  <%=strTDClass%> align="left" >

         <font size=1>&nbsp;<%=((String)arrCol.get(3)).equals("null")?"":arrCol.get(3)%>

		</td>
		<td <%=strTDClass%> align="left"> 
		    <font size=1>&nbsp;<%=((String)arrCol.get(1)).equals("null")?"":arrCol.get(1)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=((String)arrCol.get(0)).equals("null")?"":arrCol.get(0)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=((String)arrCol.get(9)).equals("null")?"":arrCol.get(9)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=((String)arrCol.get(30)).equals("null")?"":arrCol.get(30)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=((String)arrCol.get(7)).equals("null")?"":arrCol.get(7)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=((String)arrCol.get(31)).equals("null")?"":arrCol.get(31)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=((String)arrCol.get(26)).equals("null")?"":arrCol.get(26)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=((String)arrCol.get(45)).equals("null")?"":arrCol.get(45)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=((String)arrCol.get(38)).equals("null")?"":arrCol.get(38)%>
		</td>
		<td <%=strTDClass%> align="left">
			<font size=1>&nbsp;<%=(responseStatusMap.get(arrCol.get(39))).equals("null")?"":responseStatusMap.get(arrCol.get(39))%>
		</td>


		<td <%=strTDClass%> align="center" >
		<img src="../../eXH/images/ViewDetails.gif" alt="Check Details" align='middle' onClick="checkEligibility(this)" patient_id='<%=arrCol.get(0)+""%>' encounter_id='<%=arrCol.get(1)+""%>' eptype='<%=arrCol.get(2)+""%>' pat_name='<%=arrCol.get(9)+""%>'  national_id='<%=arrCol.get(10)+""%>' pat_dob='<%=arrCol.get(11)+""%>' pat_contactno='<%=arrCol.get(12)+""%>' membership_no='<%=arrCol.get(13)+""%>' policy_holder_name='<%=arrCol.get(14)+""%>' policy_number='<%=arrCol.get(15)+""%>' pStartDate='<%=arrCol.get(16)+""%>' pEndDate='<%=arrCol.get(17)+""%>' effectiveFrom='<%=arrCol.get(18)+""%>' effectiveTo='<%=arrCol.get(19)+""%>' provider_code='<%=arrCol.get(20)+""%>' service_code='<%=arrCol.get(6)+""%>' payer_code='<%=arrCol.get(21)+""%>' policy_type_code='<%=arrCol.get(24)+""%>' policy_type_desc='<%=arrCol.get(32)+""%>' billing_group_id='<%=arrCol.get(25)+""%>' p_g_desc='<%=arrCol.get(27)+""%>' priority='<%=arrCol.get(22)+""%>' payerName='<%=arrCol.get(26)+""%>' visit_adm_date_time='<%=arrCol.get(3)+""%>' nursing_unit_code='<%=arrCol.get(6)+""%>' bl_g_desc='<%=arrCol.get(33)+""%>' operating_facility_id='<%=arrCol.get(34)+""%>' episode_id='<%=arrCol.get(35)+""%>' visit_id='<%=arrCol.get(36)+""%>' asno='<%=arrCol.get(8)+""%>' settlement_ind='<%=arrCol.get(23)+""%>' trans_id='<%=arrCol.get(37)+""%>' respDTime='<%=arrCol.get(38)+""%>' resp_code='<%=arrCol.get(39)+""%>' elgCode='<%=arrCol.get(40)+""%>' validity_type='<%=arrCol.get(41)+""%>' err_msg='<%=arrCol.get(42)+""%>' remarks='<%=arrCol.get(43)+""%>' validity_until='<%=arrCol.get(44)+""%>' userId='<%=arrCol.get(45)+""%>'>
		<!--
		<input type="button" value="Check Eligibility" onClick='checkEligibility(this)' patient_id='<%=arrCol.get(0)+""%>' encounter_id='<%=arrCol.get(1)+""%>' eptype='<%=arrCol.get(2)+""%>' pat_name='<%=arrCol.get(9)+""%>'  national_id='<%=arrCol.get(10)+""%>' pat_dob='<%=arrCol.get(11)+""%>' pat_contactno='<%=arrCol.get(12)+""%>' membership_no='<%=arrCol.get(13)+""%>' policy_holder_name='<%=arrCol.get(14)+""%>' policy_number='<%=arrCol.get(15)+""%>' pStartDate='<%=arrCol.get(16)+""%>' pEndDate='<%=arrCol.get(17)+""%>' effectiveFrom='<%=arrCol.get(18)+""%>' effectiveTo='<%=arrCol.get(19)+""%>' provider_code='<%=arrCol.get(20)+""%>' service_code='<%=arrCol.get(6)+""%>' payer_code='<%=arrCol.get(21)+""%>' policy_type_code='<%=arrCol.get(24)+""%>' policy_type_desc='<%=arrCol.get(32)+""%>' billing_group_id='<%=arrCol.get(25)+""%>' p_g_desc='<%=arrCol.get(27)+""%>' priority='<%=arrCol.get(22)+""%>' payerName='<%=arrCol.get(26)+""%>' visit_adm_date_time='<%=arrCol.get(3)+""%>' nursing_unit_code='<%=arrCol.get(6)+""%>' bl_g_desc='<%=arrCol.get(33)+""%>' operating_facility_id='<%=arrCol.get(34)+""%>' episode_id='<%=arrCol.get(35)+""%>' visit_id='<%=arrCol.get(36)+""%>' asno='<%=arrCol.get(8)+""%>' settlement_ind='<%=arrCol.get(23)+""%>' trans_id='<%=arrCol.get(37)+""%>' respDTime='<%=arrCol.get(38)+""%>' resp_code='<%=arrCol.get(39)+""%>' elgCode='<%=arrCol.get(40)+""%>' validity_type='<%=arrCol.get(41)+""%>' err_msg='<%=arrCol.get(42)+""%>' remarks='<%=arrCol.get(43)+""%>' validity_until='<%=arrCol.get(44)+""%>'>-->
		
		</b>
		</td>
		</tr>

		 
		<%
		}
			}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

 }catch(Exception e1)
			{
			 out.println("(XHPatientMembershipCheckResult.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
%>
</form>
</body>
</html>

