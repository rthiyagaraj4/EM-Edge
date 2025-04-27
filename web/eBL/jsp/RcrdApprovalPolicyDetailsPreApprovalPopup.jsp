<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="blPolicy.EncounterSpecificDefinitionBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String title = request.getParameter("title");
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String rowNumber = request.getParameter("rowNumber");
	String criteria = request.getParameter("criteria");
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	String siteId = "";
	String strQueryString= checkForNull(request.getParameter("queryString"));
	if(strQueryString.length()==0)	strQueryString= request.getQueryString();
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=title %></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecAddTable.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script language='javascript'>
function checkDateFrom(obj){
	var stdt = document.forms[0].startDate.value;
	var endt = document.forms[0].endDate.value;
	var startdtarr =stdt.split("/");
	var enddtarr = endt.split("/");
	var objarr = obj.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	var objdt = new Date();
	startdt.setFullYear(startdtarr[2], startdtarr[1]-1, startdtarr[0]);
	enddt.setFullYear(enddtarr[2], enddtarr[1]-1, enddtarr[0]);
	objdt.setFullYear(objarr[2], objarr[1]-1, objarr[0]);
	if((objdt < startdt) || (objdt > enddt) ){
		alert("Please enter date in range "+stdt+" and "+endt);
		obj.value = '';
	}
}
function close(){
	var frmObj = document.forms[0];
	xmlString=formXMLStringMain(frmObj);
	//alert(xmlString);
	updation=formValidation(xmlString,"popup");
	window.close();	
}
	
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('pop_effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('pop_effTo_'+obj)
	}
	
}
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('pop_effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('pop_effTo_'+obj)
	}
	
}

function movePrevthis(start,end)
{
	var params =  document.forms[0].queryString.value;
	

//	var params =  document.forms[0].queryString.value;
 	
  
 var strt = start-10;
 var endd= end-10;
	
 
	document.location.href="../../eBL/jsp/RcrdApprovalPolicyDetailsPreApprovalPopup.jsp?from="+strt+"&to="+endd+"&"+params;
	
	}
	
function moveNextthis(start,end)
{
	var params =  document.forms[0].queryString.value;



	
	var strt = start +10;
	var endd= end+10;


	document.location.href="../../eBL/jsp/RcrdApprovalPolicyDetailsPreApprovalPopup.jsp?from="+strt+"&to="+endd+"&"+params;

	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>

	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 160px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}		

		</style>
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<br/>
<br/>
<%
String beanId = "bl_EncounterSpecificDefinitionBean";
String beanName = "blPolicy.EncounterSpecificDefinitionBean";
String readonly = "";
EncounterSpecificDefinitionBean policyBean = null;
String prevTab = rowNumber;
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<EncounterSpecificDefinitionBean>> policyMap = null;
List<EncounterSpecificDefinitionBean> policyList = null; 
String checked = "";
String disabled = "";
String exclDisabled = "";
//String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payerGroup"));
String payer = checkForNull(request.getParameter("payer"));
String policy = checkForNull(request.getParameter("policy"));
String patClass = checkForNull(request.getParameter("patClass"));
String blngCode = checkForNull(request.getParameter("blngCode"));
String patientId = checkForNull(request.getParameter("patientId"));
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));

String visitId = checkForNull(request.getParameter("visitId"));
String acctSeq = checkForNull(request.getParameter("acctSeq"));
String priority = checkForNull(request.getParameter("priority"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForNull(request.getParameter("episodeId"));

String encEpsd = checkForNull(request.getParameter("encEpsd"));
String gender = checkForNull(request.getParameter("gender"));
String ageGroup = checkForNull(request.getParameter("ageGroup"));
String clinicNursInd = checkForNull(request.getParameter("clinicNursInd"));
String clinicNursCode = checkForNull(request.getParameter("clinicNursCode"));
String spltyCode = checkForNull(request.getParameter("spltyCode"));
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
//Delete Definitions
EncounterSpecificDefinitionBean deletedPolicyBean = null;
HashMap<String,List<EncounterSpecificDefinitionBean>> deletedPolicyMap = null;
List<EncounterSpecificDefinitionBean> deletedPolicyList = null; 
//Delete Definitions
//Traverse
int start = 0 ;
int end = 0 ;

String from = checkForNull(request.getParameter("from"));
String to = checkForNull(request.getParameter("to"));

if ( from.length()== 0 )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to.length()==0)
  	end = 10 ;
else
	end = Integer.parseInt( to ) ;
//Traverse
try{
	con = ConnectionManager.getConnection(request);
	siteId = BLReportIdMapper.getCustomerId();
	policyBean = (EncounterSpecificDefinitionBean) getBeanObject(beanId, beanName, request);
	policyMap = policyBean.getPopupMap();
	if(!(policyMap == null || policyMap.isEmpty())){
		policyList = policyMap.get(rowNumber);
	}
	
	//Delete Definitions
	deletedPolicyBean = (EncounterSpecificDefinitionBean) getBeanObject("DeletedEncounterBean", beanName, request);
	deletedPolicyMap = deletedPolicyBean.getPopupMap();
	if(!(deletedPolicyMap == null || deletedPolicyMap.isEmpty())){
		deletedPolicyList = deletedPolicyMap.get(rowNumber);
	}
	//Delete Definitions
		HashMap<String,List<EncounterSpecificDefinitionBean>> fmtDetailsMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
		EncounterSpecificDefinitionBean fmtDtlsBean = null;
		//Delete Definitions
		if(policyList == null || policyList.isEmpty())
		{
			//String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXCLUSION_POPUP");
			
				if(deletedPolicyList == null || deletedPolicyList.isEmpty()){
					if(patientId == null || "".equals(patientId)){
						String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXCLUSION_POPUP");
			
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1,locale);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,payerGroup);
						pstmt.setString(4,payer);
						pstmt.setString(5,policy);
						pstmt.setString(6,criteria);
						pstmt.setString(7,blngCode);
						pstmt.setString(8,patClass);
						
						pstmt.setString(9,encEpsd);
						pstmt.setString(10,gender);
						pstmt.setString(11,ageGroup);
						pstmt.setString(12,clinicNursInd);
						pstmt.setString(13,clinicNursCode);
						pstmt.setString(14,spltyCode);
						pstmt.setString(15,startDate);
						rst = pstmt.executeQuery();
					}
					else{
						String partSql = "";
						
						if(("I".equals(episodeType)) || ("D".equals(episodeType))){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
						}
						else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
						}
						else if("R".equals(episodeType)){
							partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
						}
						
						String sqlCoverage =  BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL_POPUP")+partSql;
			
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1,locale);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,payerGroup);
						pstmt.setString(4,payer);
						pstmt.setString(5,policy);
						pstmt.setString(6,criteria);
						pstmt.setString(7,blngCode);
						pstmt.setString(8,patClass);
						pstmt.setString(9,patientId);
						
						pstmt.setString(10,encEpsd);
						pstmt.setString(11,gender);
						pstmt.setString(12,ageGroup);
						pstmt.setString(13,clinicNursInd);
						pstmt.setString(14,clinicNursCode);
						pstmt.setString(15,spltyCode);
						pstmt.setString(16,startDate);
						
						if(("I".equals(episodeType)) || ("D".equals(episodeType))){
							pstmt.setString(17,episodeType);
							pstmt.setString(18,episodeId);
							pstmt.setString(19,acctSeq);
							pstmt.setString(20,priority);
			
						}
						else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
							pstmt.setString(17,episodeType);
							pstmt.setString(18,episodeId);
							pstmt.setString(19,visitId);
							pstmt.setString(20,acctSeq);
							pstmt.setString(21,priority);
							
						}
						else if("R".equals(episodeType)){
							
							pstmt.setString(17,episodeType);
							pstmt.setString(18,acctSeq);
							pstmt.setString(19,priority);
							
						}
						
						rst = pstmt.executeQuery();
					}
					
					
					if(rst!=null){
						policyList = new ArrayList<EncounterSpecificDefinitionBean>();
						int rsCnt = 0;
						while (rst.next()) {
							fmtDtlsBean = new EncounterSpecificDefinitionBean();
		
							fmtDtlsBean.setInclExclCriteria(rst.getString("excl_serv_excl_incl_crit"));
							fmtDtlsBean.setBillServCode(rst.getString("excl_blng_serv_code"));
							fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
							fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
							fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
							fmtDtlsBean.setValue(rst.getString("copay_val"));
							fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
							fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
							fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
							fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
							fmtDtlsBean.setStartDate(rst.getString("effective_from"));
							fmtDtlsBean.setEndDate(rst.getString("effective_to"));
							fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
							fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
							fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
							fmtDtlsBean.setStatus("U");
							policyList.add(fmtDtlsBean);
							rsCnt++;
						}
						
						if(rsCnt<1){
							policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
							EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
							titleBean.setStartDate(startDate);
							titleBean.setEndDate(endDate);
							policyList = new ArrayList<EncounterSpecificDefinitionBean>();
							policyList.add(titleBean);
							policyMap.put(prevTab, policyList);
						}
					}
					else{
						policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
						EncounterSpecificDefinitionBean titleBean = new EncounterSpecificDefinitionBean();
						titleBean.setStartDate(startDate);
						titleBean.setEndDate(endDate);
						policyList = new ArrayList<EncounterSpecificDefinitionBean>();
						policyList.add(titleBean);
						policyMap.put(prevTab, policyList);
				}		
				
			}
			//Delete Definition
			else{
				policyList.add(new EncounterSpecificDefinitionBean());
			}
			//Delete Definition
		}
		
		pstmt = null;
		rst = null;
		String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
		pstmt = con.prepareStatement(inclExclSql);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();

		if(rst!=null){
			while(rst.next()){
				criteriaMap.put(rst.getString("code"),rst.getString("description"));
			}	
		}

		
}
catch(Exception e){
	System.err.println("Exception "+e);
}
finally{
	ConnectionManager.returnConnection(con);
	pstmt = null;
	rst = null;
}
%>
	<form  id="frmPolicyInclExclCoverage">	
	<table width='90%' align="center">
	<tr>
		<td width='70%'>
		</td>
		<td width='14%' align='right'>
			<%
		if ( !(start <= 1) )
			out.println("<A HREF='javascript:movePrevthis("+start+","+end+")'   text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
			%>
		</td>
		<td width='2%'></td>
		<td width='14%' align='left'>
		<%
		if(policyList.size() > end)
			out.println("<A id='nextvalue' HREF='javascript:moveNextthis("+start+","+end+")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
		</td>
	</tr>
	</table>
	
		
      	<table width='150%' class='grid' border='1' cellpadding='3'  cellspacing=0 align="center" id="PolicyPreApprovalPopup">  
      		<div id="tableContainer">
      	<thead> 
      		<tr>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcCriteria.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.BGServiceDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcInd.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.InclusionBasis.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ServItemQty.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AmtVisit.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AmtIPDay.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Gross / Net</td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Delete Record</td>			 
			</tr>
			 </thead>
			 <TBODY>
			<%
				int tableIndex = 1;
			 	int tindex =0;
					for (EncounterSpecificDefinitionBean policyBean1 : policyList) {
						tindex++;	
						if(tindex < start)
						{					
							continue;
						}
						if(tindex > end)
							break;
						
						if("I".equals(policyBean1.getStatus())){
							readonly = "";
							disabled = "";
						}
						else if("U".equals(policyBean1.getStatus())){
							readonly = "readonly";
							disabled = "disabled";
						}

						if("E".equals(policyBean1.getInclExclInd())){
							exclDisabled = "disabled";
						}
						else{
							exclDisabled = "";
						}
			%>
			 <tr>
				<td nowrap class='fields'>
					<%=checkForNull(criteriaMap.get(policyBean1.getInclExclCriteria()))%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getBillServDesc())%>
				</td>
				<td nowrap class='fields'>
						<%if("I".equals(policyBean1.getInclExclInd())){ %>
							<fmt:message key="Common.Include.label" bundle="${common_labels}"/>
						<%} else if("E".equals(policyBean1.getInclExclInd())){ %>
							<fmt:message key="Common.Exclude.label" bundle="${common_labels}"/>
						<%} %>
						
					</Select>
				</td>
				<td nowrap class='fields'>
						<%if("P".equals(policyBean1.getInclusionBasis())){ %>
							<fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"/>
						<%} else if("R".equals(policyBean1.getInclusionBasis())){ %>
							<fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/>
						<%} else if("F".equals(policyBean1.getInclusionBasis()) && !"ALKA".equals(siteId)){ %>
							<fmt:message key="Common.Fixed.label" bundle="${common_labels}"/>
						<%} %>
						
					</Select>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getValue()) %>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getServItemQty())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getAmtPerVisit())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getAmtPerIPDay())%>
				</td>
				<td nowrap class='fields'>
						<% if(("G").equals(policyBean1.getAmtGrossNet())){ %>
							<fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/>
						<%} else if(("N").equals(policyBean1.getAmtGrossNet())){ %>
							<fmt:message key="eBL.Net.label" bundle="${bl_labels}"/>
						<%} %>	
					</select>
				</td>
				<td class='fields' nowrap>
					<%=checkForNull(policyBean1.getPatCopay())%>
				</td>
				<td class='fields' nowrap>
					<%=checkForNull(policyBean1.getPatLimitAmt())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getNoOfDays())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getStartDate())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getEndDate())%>
				</td>
				<td nowrap class='fields'>
				<%if("Y".equals(policyBean1.getDelFlag())){ 
					out.print("Y");
				} else{ 
					out.print("Y");
				} %>
				</td>
			</tr>
			<%
			tableIndex++;	
			}	
			%>
      	</table>
      	<input type='hidden' name='pageInfo' id='pageInfo' value='PreApprovalPopup'>
      	<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
      	<input type='hidden' name='rowNumber' id='rowNumber' value='<%=rowNumber%>'>
      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      	<input type='hidden' name='criteria' id='criteria' value='<%=criteria %>'>
      	<input type='hidden' name='startDate' id='startDate' value='<%=startDate %>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate %>'>
      	<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>'>
		<input type='hidden' name='blngCode' id='blngCode' value='<%=blngCode%>'>
		
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup %>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer %>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy %>'>
      	<input type='hidden' name='patClass' id='patClass' value='<%=patClass %>'>
      	<input type='hidden' name='encEpsd' id='encEpsd' value='<%=encEpsd %>'>
      	<input type='hidden' name='gender' id='gender' value='<%=gender%>'>
      	<input type='hidden' name='ageGroup' id='ageGroup' value='<%=ageGroup%>'>
      	<input type='hidden' name='clinicNursInd' id='clinicNursInd' value='<%=clinicNursInd%>'>
		<input type='hidden' name='clinicNursCode' id='clinicNursCode' value='<%=clinicNursCode%>'>
		
		<input type='hidden' name='spltyCode' id='spltyCode' value='<%=spltyCode%>'>
      	<input type='hidden' name='visitId' id='visitId' value='<%=visitId%>'>
      	<input type='hidden' name='acctSeq' id='acctSeq' value='<%=acctSeq%>'>
		<input type='hidden' name='priority' id='priority' value='<%=priority%>'>
		
		<input type='hidden' name='episodeType' id='episodeType' value='<%=episodeType%>'>
		<input type='hidden' name='episodeId' id='episodeId' value='<%=episodeId%>'>
		<input type='hidden' name='queryString' id='queryString' value="<%=strQueryString%>">
     </form>
     <div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
     </body>
</TBODY>	
	
	</div>
         <%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
    private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
     %>
</html>

