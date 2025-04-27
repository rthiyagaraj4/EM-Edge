<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String rowNumber = request.getParameter("rowNumber");
	String criteria = request.getParameter("criteria");
	String readonly = "";
	String inclExclDesc = "";
	String inclExclCode = "";
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	PolicyInsuranceMasterBean fmtDtlsBean = null;
	List<PolicyInsuranceMasterBean> policyList = null; 
	String siteId = "";
	request.setCharacterEncoding("UTF-8");
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
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

		TD.YELLOW 
		{
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		</style>
		
		
		<%

String strQueryString= checkForNull(request.getParameter("queryString"));
if(strQueryString.length()==0)	strQueryString= request.getQueryString();

%>

<script language = 'javascript'>
function mandType(obj){
	if(obj == 1){
		alert('Please choose Clinic / Nursing unit');
	}
	else{
		alert('Please choose Inc / Exc Criteria');
	}
}
function movePrevthis(start,end)
{
	var params =  document.forms[0].queryString.value;
	

//	var params =  document.forms[0].queryString.value;
 	
  
 var strt = start-20;
 var endd= end-20;
	
 
	parent.frames[0].location.href="../../eBL/jsp/PolicyServiceLmtLookup.jsp?from="+strt+"&to="+endd+"&"+params;
	
	}
	
function moveNextthis(start,end)
{
	var params =  document.forms[0].queryString.value;



	
	var strt = start +20;
	var endd= end+20 ;


 parent.frames[0].location.href="../../eBL/jsp/PolicyServiceLmtLookup.jsp?from="+strt+"&to="+endd+"&"+params;

	
}

function applyFilter(criteria,bgCode,bgDesc){
	var params =  document.forms[0].queryString.value;
	var frm = document.forms[0];
	var start = document.forms[0].from.value;
	var end = document.forms[0].to.value;
	//parent.frames[0].location.href="../../eBL/jsp/PolicyExclusionDetailsData.jsp?from="+start+"&to="+end+"&criteria_Filter="+criteria.value+
	parent.frames[0].location.href="../../eBL/jsp/PolicyServiceLmtLookup.jsp?criteria_Filter="+criteria.value+
			"&bgCodeFilter="+bgCode.value+"&effFromFilter="+frm.effFrom_filter.value+"&bgDescFilter="+escape(bgDesc.value)+
			"&title=Include Exclude Details"+
			"&startDate="+frm.startDate.value+
			"&endDate="+frm.endDate.value+
			"&mode=modify"+
			"&payerGroup="+frm.payerGroup.value+
			"&payer="+frm.payer.value+
			"&policy="+frm.policy.value+
			"&patClass="+frm.patClass.value+
			"&encEpsd="+frm.encEpsd.value+
			"&gender="+frm.gender.value+
			"&ageGroup="+frm.ageGroup.value+
			"&clinicNursInd="+frm.clinicNursInd.value+
			"&clinicNursCode="+frm.clinicNursCode.value+
			"&spltyCode="+frm.spltyCode.value+
			"&criteria="+frm.criteria.value+
			"&blngCode="+frm.blngCode.value+
			"&rowNumber="+frm.rowNumber.value;
}

function resetFilter(){
	var params =  document.forms[0].queryString.value;
	var frm = document.forms[0];
	parent.frames[0].location.href="../../eBL/jsp/PolicyServiceLmtLookup.jsp?"+
	"title=Include Exclude Details"+
	"&startDate="+frm.startDate.value+
	"&endDate="+frm.endDate.value+
	"&mode=modify"+
	"&payerGroup="+frm.payerGroup.value+
	"&payer="+frm.payer.value+
	"&policy="+frm.policy.value+
	"&patClass="+frm.patClass.value+
	"&encEpsd="+frm.encEpsd.value+
	"&gender="+frm.gender.value+
	"&ageGroup="+frm.ageGroup.value+
	"&clinicNursInd="+frm.clinicNursInd.value+
	"&clinicNursCode="+frm.clinicNursCode.value+
	"&spltyCode="+frm.spltyCode.value+
	"&criteria="+frm.criteria.value+
	"&blngCode="+frm.blngCode.value+
	"&rowNumber="+frm.rowNumber.value;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<br/>
<br/>
<%
String prevTab = rowNumber;
String mode = checkForNull(request.getParameter("mode"));

//String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payerGroup"));
String payer = checkForNull(request.getParameter("payer"));
String policy = checkForNull(request.getParameter("policy"));
String patClass = checkForNull(request.getParameter("patClass"));
String blngCode = checkForNull(request.getParameter("blngCode"));
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));

String encEpsd = checkForNull(request.getParameter("encEpsd"));
String gender = checkForNull(request.getParameter("gender"));
String ageGroup = checkForNull(request.getParameter("ageGroup"));
String clinicNursInd = checkForNull(request.getParameter("clinicNursInd"));
String clinicNursCode = checkForNull(request.getParameter("clinicNursCode"));
String spltyCode = checkForNull(request.getParameter("spltyCode"));

String criteria_Filter = checkForNull(request.getParameter("criteria_Filter"));
String bgCodeFilter = checkForNull(request.getParameter("bgCodeFilter"));
String bgDescFilter = checkForNull(request.getParameter("bgDescFilter"));
bgDescFilter = java.net.URLDecoder.decode(bgDescFilter,"UTF-8");
String effFromFilter = checkForNull(request.getParameter("effFromFilter"));

Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
String sqlCoverage = "";

try{
	con = ConnectionManager.getConnection(request);
	siteId = BLReportIdMapper.getCustomerId();		
				sqlCoverage =  BlRepository.getBlKeyValue("POLICY_DEF_EXCLUSION_POPUP");

				if(!("".equals(criteria_Filter))){
					sqlCoverage += "and hdr.excl_serv_excl_incl_crit = '"+criteria_Filter+"' ";
				}
				if(!("".equals(bgCodeFilter))){
					sqlCoverage += "and hdr.excl_blng_serv_code = '"+bgCodeFilter+"' ";
				}
				if(!("".equals(effFromFilter))){
					sqlCoverage += "and to_char(hdr.EXCL_EFFECTIVE_FROM,'dd/mm/yyyy') = '"+effFromFilter+"' ";
				}
				
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
				
				if(rst!=null){
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					int rsCnt = 0;
					while (rst.next()) {
						fmtDtlsBean = new PolicyInsuranceMasterBean();

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
						//New Fields Added
						fmtDtlsBean.setPolicyApplicability(rst.getString("across_encounters_yn"));
						fmtDtlsBean.setEncGrpIdSameEpsd(rst.getString("dflt_acr_enc_grp_for_same_epis"));
						fmtDtlsBean.setTimeLimitType(rst.getString("dflt_acr_enc_grp_durn_type"));
						fmtDtlsBean.setTimeLimitValue(rst.getString("dflt_acr_enc_grp_durn"));
						//New Fields Added
						fmtDtlsBean.setStatus("U");
						policyList.add(fmtDtlsBean);
						rsCnt++;
					}
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
	
	<%
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	
	String from = checkForNull(request.getParameter("from"));
	String to = checkForNull(request.getParameter("to"));
	
	
	
	
	if ( from.length()== 0 )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;
	if ( to.length()==0)
	  	end = 20 ;
	else
		end = Integer.parseInt( to ) ;

		System.out.println("from  "+start);
		System.out.println("to  "+end);
		System.out.println("size  "+policyList.size());
		
		
	
	%>
	
	<%
if ( !(start <= 1) )
	out.println("<A HREF='javascript:movePrevthis("+start+","+end+")'   text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if(policyList.size() > end)
	out.println("<A id='nextvalue' HREF='javascript:moveNextthis("+start+","+end+")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	%>
	
	
	
      	<table width='150%' class='grid' border='1' cellpadding='3'  cellspacing=0 align="center" id="PolicyPreApprovalPopup">  
      	<div id="tableContainer">
      	<thead>  
      		<tr>
      			<td class='COLUMNHEADER' nowrap>S No</td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcCriteria.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.BGServiceDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<!-- New Fields Added -->
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' title='Across Encounters' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' title='Same Group ID for Followup' class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.TimeLimitGrpOP.label" bundle="${bl_labels}"></fmt:message> </td>				
				<!-- New Fields Added -->
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
			<tr>
				<td nowrap><input type='button' id='apply_filter' value='Search' onclick='applyFilter(criteriaFilter,bg_code_filter,bg_desc_filter)'>&nbsp;
				<input type='button' id='apply_filter' value='Reset' onclick='resetFilter()'></td>
				<td nowrap>
					<select name='criteriaFilter' id='criteriaFilter'>		
					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>			
					<%
					for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
						String type = (String) iterator.next();
						if(type.equals(criteria_Filter)){
					%>	
						<option value='<%=type%>' selected="selected"><%=criteriaMap.get(type) %></option>
					<%}
						else{%>
							<option value='<%=type%>'><%=criteriaMap.get(type) %></option>
						<%}
					}
					%>
					</select>
				</td>
				<td nowrap>
					<input type='text' id='bg_code_filter' name='bg_code_filter' id='bg_code_filter' size='12'   value='<%=bgCodeFilter %>' onblur="if(this.value!='' && criteriaFilter.value!=''){ callBGDescCode(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_desc_filter); } " >
					<input type='text' id='bg_desc_filter' name='bg_desc_filter' id='bg_desc_filter'  size='20'  value='<%=bgDescFilter %>' onblur="if(this.value!='' && criteriaFilter.value!=''){ callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_code_filter); }">
					<input type='button' id='bg_but_filter' value='?'  onclick='if(criteriaFilter.value!=""){ callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ mandType(2);}' >					
				</td>
				<td  nowrap colspan='10'>&nbsp;</td>
				<td nowrap>
					<input type='text' id='effFrom_filter' name='effFrom_filter' id='effFrom_filter' value='<%=effFromFilter %>' size='10' onblur='isValidDate(this);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_filter' onClick='return showCalendar("effFrom_filter")' />
				</td>
			</tr>
		</thead>
		 <TBODY>
			<%
				int tableIndex = 1;
		 
		 		int tindex =0;
		 
		 
					for (PolicyInsuranceMasterBean policyBean1 : policyList) {
						
						
						tindex++;	
						if(tindex < start)
						{					
							continue;
						}
					if(tindex > end)
							break;
						
			%>
			 <tr  onclick='fnLoadSelectedCoveragePopup("<%=policyBean1.getInclExclCriteria()%>","<%=policyBean1.getBillServCode()%>","<%=policyBean1.getStartDate()%>")'>
			 <td nowrap class='fields'>
			 		<%=tindex %>
			 	</td>
				<td nowrap class='fields'>
					<%=checkForNull(criteriaMap.get(policyBean1.getInclExclCriteria()))%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getBillServDesc())%>
				</td>
				<!-- New Fields Added -->
				<td class='fields' nowrap>	
					<%if("Y".equals(policyBean1.getPolicyApplicability())){ 
						out.print("Y");
					} else if("N".equals(policyBean1.getPolicyApplicability())){
						out.print("N");
					} else{
						out.print("");				
					}%>					
				</td>
				<td class='fields' nowrap>	
					<%if("Y".equals(policyBean1.getEncGrpIdSameEpsd())){ 
						out.print("Y");
					} else if("N".equals(policyBean1.getEncGrpIdSameEpsd())){
						out.print("N");
					} else{
						out.print("");
					} %>						
				</td>
				<td class='fields' nowrap>	
					<%=checkForNull(policyBean1.getTimeLimitValue())%> &nbsp;&nbsp;
					<%if("D".equals(policyBean1.getTimeLimitType())){ %>
						<fmt:message key="Common.day.label" bundle="${common_labels}"/>
					<%} else if("M".equals(policyBean1.getTimeLimitType())){ %>
						<fmt:message key="Common.month.label" bundle="${common_labels}"/>
					<%} else if("Y".equals(policyBean1.getTimeLimitType())){ %>
						<fmt:message key="Common.year.label" bundle="${common_labels}"/>
					<%} %>					
				</td>				
				<!-- New Fields Added -->
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
					out.print("&nbsp;");
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
      	<input type='hidden' name='inclExclDesc' id='inclExclDesc' value='<%=inclExclDesc%>'>
      	<input type='hidden' name='inclExclCode' id='inclExclCode' value='<%=inclExclCode%>'>
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
		<input type='hidden' name='queryString' id='queryString' value="<%=strQueryString%>">
		<input type='hidden' name='from' id='from' value="<%=from%>">
		<input type='hidden' name='to' id='to' value="<%=to%>">
		
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

