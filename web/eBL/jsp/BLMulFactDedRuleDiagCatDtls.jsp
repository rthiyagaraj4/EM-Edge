<!DOCTYPE html>
<%@page import="eBL.MFDRDiagCatBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eBL.Common.BlRepository"%>


<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLMultiFactorDeductRule.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onload="parent.parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
	
	private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
%>
<%
String beanId = "bl_MFDRDiagCatBean";
String beanName = "eBL.MFDRDiagCatBean";
MFDRDiagCatBean policyBean = null;
HashMap<String,List<MFDRDiagCatBean>> policyMap = null;
List<MFDRDiagCatBean> policyList = null; 
String checked = "";
String disabled = "";
String exclDisabled = "";
String siteId = ""; 
System.err.println("Mode in diagCat is "+request.getParameter("mode"));
String mode = checkForNull(request.getParameter("mode"));
System.err.println("Mode is "+mode);
String payerGroup = checkForNull(request.getParameter("payergroupCode"));
System.err.println("Payer Group in modify mode is: "+payerGroup);
String payer = checkForNull(request.getParameter("payerCode"));
System.err.println("Payer in modify mode is: "+payer);
String policy = checkForNull(request.getParameter("policyCode"));
System.err.println("Policy Type in modify mode is: "+policy);
String diagCategory = checkForNull(request.getParameter("cat_code"));
System.err.println("Diag Category in modify mode is: "+diagCategory);
String calledForm = request.getParameter("calledForm") == null ? "" : request.getParameter("calledForm");
System.err.println("calledForm--->"+calledForm);
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
String totalDisabled = "";
String auth = "";
auth = request.getParameter("auth");
String cust_group_code="";
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");
String readonly = "";
String diagCat_code_desp = "";

HttpSession httpSession = request.getSession(false);
Properties p = (Properties)httpSession.getValue("jdbc");
String strLoggedUser = p.getProperty("login_user");
if(strLoggedUser == null) strLoggedUser="";


int tableIndex = 1;

try{
	con = ConnectionManager.getConnection(request);
	policyBean = (MFDRDiagCatBean) getBeanObject(beanId, beanName, request);
	policyMap = policyBean.getPolicyMap();  
	
	
	MFDRDiagCatBean policyBean_1 = null;
	if ("modify".equals(mode)){
	try{	
		readonly = "readonly";
		disabled = "disabled";
		totalDisabled = "disabled";
		auth = "N";
		policyList = new ArrayList<MFDRDiagCatBean>();
		System.err.println("Inside modify mode");
	//	String sqlInfoPage_1 =  BlRepository.getBlKeyValue("Multi_Factor_Deduct_Rule_Hdr_Info");
		String sqlInfoPage_1 = "select decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, hdr.CUST_CODE, decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type, hdr.POLICY_TYPE_CODE, hdr.operating_facility_id,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to, operating_facility_id, episode_type, episode_encounter, item_category, patient_copay, patient_amount_limit, copay_applied_on  from bl_insu_diag_deduct_dtl hdr where hdr.operating_facility_id = ?  and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.ITEM_CATEGORY = ? ";
			
			pstmt = con.prepareStatement(sqlInfoPage_1);
			System.err.println("Query is: "+sqlInfoPage_1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,diagCategory);
			rst = pstmt.executeQuery();
			System.err.println("Value for facility, PayerGroup, Payer, Policy are: "+facility_id+"::"+payerGroup+"::"+"::"+payer+"::"+policy);
			if(rst != null){
				while(rst.next()){
				policyBean_1 = new MFDRDiagCatBean();
				policyBean_1.setFacilityId(rst.getString("operating_facility_id"));
				policyBean_1.setEpisodeEncounter(rst.getString("episode_encounter")); //V221113
				policyBean_1.setPatClass(rst.getString("EPISODE_TYPE"));  //V221113
				policyBean_1.setPayerGroup(rst.getString("payer_group"));
				policyBean_1.setPayerGroupCode(rst.getString("CUST_GROUP_CODE"));
				policyBean_1.setPayer(rst.getString("payer"));
				policyBean_1.setPayerCode(rst.getString("CUST_CODE"));
				policyBean_1.setPolicyType(rst.getString("policy_type"));
				policyBean_1.setPolicyTypeCode(rst.getString("POLICY_TYPE_CODE"));
				policyBean_1.setDiagCat(rst.getString("item_category"));
				policyBean_1.setPatCopay(rst.getString("patient_copay"));
				policyBean_1.setPatLimitAmt(rst.getString("patient_amount_limit"));
				policyBean_1.setAmtGrossNet(rst.getString("copay_applied_on"));
				policyBean_1.setStartDate(rst.getString("effective_from"));
				policyBean_1.setEndDate(rst.getString("effective_to")); 
				policyBean_1.setStatus("U");				
				policyList.add(policyBean_1);
				}
				rst.close();
			}
			pstmt.close(); 
						
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in Info Frame Load - "+e);	
		}
		finally{
			//ConnectionManager.returnConnection(con);
		} 
	}else{
		if(!(policyMap == null || policyMap.isEmpty())){
			policyList = policyMap.get("DiagCatDtlsPageInfo");		
		}
		else if(policyList == null || policyList.isEmpty()){
			
			policyBean_1 = new MFDRDiagCatBean();
			policyList = new ArrayList<MFDRDiagCatBean>();
			policyList.add(policyBean_1);
		}
	}  
%>

<form name="frmMultiFactorDeductRuleDiagnosisCategory" id="frmMultiFactorDeductRuleDiagnosisCategory" >
<table class='grid' border='1' width='100%' cellpadding='3'  cellspacing=0 align="center" id='MultiFactorDeductRuleDiagCat'>  
      		<tr>
			<td class='COLUMNHEADER' nowrap colspan="12" align="center">Diagnosis Category Details</td>
			<tr>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EpisodeEncounter.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.DiagnosisCategory.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/>(%)&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/>&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/>/<fmt:message key="eBL.Net.label" bundle="${bl_labels}"/>&nbsp;</td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/>&nbsp;</td>
				
			</tr>
			</tr>
			<%
			for (MFDRDiagCatBean policyBean1 : policyList) {	
					
					if("U".equals(policyBean1.getStatus())){
						readonly = "readonly";
						disabled = "disabled";	
					}
					else if("I".equals(policyBean1.getStatus())){
						readonly = "";
						disabled = "";		
					}
			
			%>
			<tr>
			<td class='fields' nowrap>
					<select  id='episode_<%= tableIndex%>' name='episode_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %> onchange='changeEpsdEnc(<%= tableIndex%>);'>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%if("E".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='E' selected><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='E'><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("N".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='N' selected><fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/></option>	
						<%}
						else{%>
							<option value='N'><fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/></option>	
						<%} %>

						<%if("A".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='A' selected><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>	
						<%}
						else{%>
							<option value='A'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>	
						<%} %>
											
					</select>
				</td>
				
				<td class='fields' nowrap>
					<select id='ptClass_<%= tableIndex%>' name='ptClass_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %>>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>

						<%if("O".equals(policyBean1.getPatClass())){ %>
							<option value='O' selected><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='O'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("I".equals(policyBean1.getPatClass())){ %>
							<option value='I' selected><fmt:message key="Common.IP.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='I'><fmt:message key="Common.IP.label" bundle="${common_labels}"/></option>
						<%} %>

						<%if("D".equals(policyBean1.getPatClass())){ %>
							<option value='D' selected><fmt:message key="Common.DC.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='D'><fmt:message key="Common.DC.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("R".equals(policyBean1.getPatClass())){ %>
							<option value='R' selected><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='R'><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("E".equals(policyBean1.getPatClass())){ %>
							<option value='E' selected><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='E'><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
						<%} %>

						<%if("*".equals(policyBean1.getPatClass())){ %>
							<option value='*' selected><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='*'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
						<%} %>
					</select>
				</td>
				
				<td class='fields' nowrap>
					<input type='text' name='payer_group_desc_<%= tableIndex%>' id='payer_group_desc_<%= tableIndex%>' id='payer_group_desc_<%= tableIndex%>' size='10' maxlength='5'  <%=disabled %> value='<%=checkForNull(policyBean1.getPayerGroup()) %>'  
					onblur="if(this.value!=''){ callCommonValidation(3,payer_group_desc_<%= tableIndex%>,payer_group_code_<%= tableIndex%>,<%= tableIndex%>);}else{fnClearCode(payer_group_code_<%= tableIndex%>,<%= tableIndex%>,1);}" onchange="fnEnableDisablePayer_PayerPolicy('sel','payer_group_desc_<%= tableIndex%>','payer_desc_<%= tableIndex%>','policy_type_desc_<%= tableIndex%>',<%= tableIndex%>);">
					<input type='hidden' name='payer_group_code_<%= tableIndex%>' id='payer_group_code_<%= tableIndex%>' id='payer_group_code_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getPayerGroupCode()) %>'>
					<input type='button' class='button' value='?' <%=disabled %> 
					onClick="callCommonValidation(3,payer_group_desc_<%= tableIndex%>,payer_group_code_<%= tableIndex%>,<%= tableIndex%>);" tabindex='2'>
				</td> 
				
				<td class='fields' nowrap>
					<input type='text' name='payer_desc_<%= tableIndex%>' id='payer_desc_<%= tableIndex%>' id='payer_desc_<%= tableIndex%>' size='10' maxlength='5' <%=disabled %> value='<%=checkForNull(policyBean1.getPayer()) %>'  
					onblur="if(this.value!=''){ callCommonValidation(2,payer_desc_<%= tableIndex%>,payer_code_<%= tableIndex%>,<%= tableIndex%>);}else{fnClearCode(payer_code_<%= tableIndex%>,<%= tableIndex%>,2);}">
					<input type='hidden' name='payer_code_<%= tableIndex%>' id='payer_code_<%= tableIndex%>' id='payer_code_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getPayerCode()) %>'>
					<input type='button' class='button' value='?' <%=disabled %> 
					onClick='if(chkForMandFields("P",<%= tableIndex%>)){ callCommonValidation(2,payer_desc_<%= tableIndex%>,payer_code_<%= tableIndex%>,<%= tableIndex%>); }' tabindex='2'>
				</td> 
				
				<td class='fields' nowrap >
					<input type='text' name='policy_type_desc_<%= tableIndex%>' id='policy_type_desc_<%= tableIndex%>' id='policy_type_desc_<%= tableIndex%>' size='10' maxlength='5' <%=disabled %> value="<%=checkForNull(policyBean1.getPolicyType()) %>"  
					onblur="if(this.value!=''){ callCommonValidation(4,policy_type_desc_<%= tableIndex%>,policy_type_code_<%= tableIndex%>,<%= tableIndex%>);}else{fnClearCode(policy_type_code_<%= tableIndex%>,<%= tableIndex%>,3);}" >
					<input type='hidden' name='policy_type_code_<%= tableIndex%>' id='policy_type_code_<%= tableIndex%>' id='policy_type_code_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getPolicyTypeCode())%>'>
					<input type='button' class='button' value='?' <%=disabled %> 
					onClick='if(chkForMandFields("PL",<%= tableIndex%>)){ callCommonValidation(4,policy_type_desc_<%= tableIndex%>,policy_type_code_<%= tableIndex%>,<%= tableIndex%>); }' tabindex='2'>
				</td>   
				
				<td class='fields' nowrap>
					<select  id='diag_category_<%= tableIndex%>' name='diag_category_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %>   onClick="chkForMandFields('D',<%= tableIndex%>)" > 			
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>	
						
<%
			
			pstmt = con.prepareStatement( "select DIAG_CATG_CODE, LONG_DESC from MR_DIAG_CATEGORY where EFF_STATUS = 'E'" ) ;
			rst = pstmt.executeQuery() ;
			diagCat_code_desp = "";
			
			if( rst != null ) 
			{
				while( rst.next() ) 
				{
					String diag_cat_code = rst.getString( "DIAG_CATG_CODE" ) ;
					String long_desc = rst.getString( "LONG_DESC" ) ;
					
					if(diag_cat_code.equals(policyBean1.getDiagCat()))
					{
						out.println("<option selected value=\""+diag_cat_code+"\">"+long_desc+"</option>");
						diagCat_code_desp +=  diag_cat_code + "~" + long_desc+"||" ;
					}
					else{
						out.println("<option value=\""+diag_cat_code+"\">"+long_desc+"</option>");
						diagCat_code_desp +=  diag_cat_code + "~" + long_desc+"||" ;
						System.err.println("Dropdown fields for diag Cat are: "+diagCat_code_desp);
					}
				}
			
			}
			if(rst !=null) rst.close();
			pstmt.close() ;	
			
%>   						
					</select>
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='patCopay_<%= tableIndex%>' name='patCopay_<%= tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatCopay())%>' maxlength='5'>
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='patLimitAmt_<%= tableIndex%>' name='patLimitAmt_<%= tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatLimitAmt())%>' maxlength='10'>
				</td>
				
				<td class='fields' nowrap>
					<select name='AmtMode_<%= tableIndex%>' id='AmtMode_<%= tableIndex%>'>						
						<% if(("N").equals(policyBean1.getAmtGrossNet())){ %>
							<option value='N' selected><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='N'><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} %>		

						<% if(("G").equals(policyBean1.getAmtGrossNet())){ %>
							<option value='G' selected><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='G'><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} %>
					</select>
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='effFrom_<%= tableIndex%>' <%=totalDisabled %> name='effFrom_<%= tableIndex%>' maxlength='10' size='10' <%=readonly %> value='<%=checkForNull(policyBean1.getStartDate())%>' onblur='effFromDateValidation(this, effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>);'>   
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totalDisabled %> id='effFrom_ctrl_<%= tableIndex%>' <%=disabled %> onClick="return showCalendar('effFrom_<%= tableIndex%>');" />
				</td>
				
				<!--V221113 -->
				<td class='fields' nowrap>
					<input type='text' id='effTo_<%= tableIndex%>' name='effTo_<%= tableIndex%>' maxlength='10' size='10' value='<%=checkForNull(policyBean1.getEndDate())%>' onblur='effToDateValidation(this, effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>); '> 
					<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_<%= tableIndex%>' onClick="return showCalendar('effTo_<%= tableIndex%>');" />
					<input type='hidden' id='oldEndDate_<%= tableIndex%>' name='oldEndDate_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getEndDate())%>'>
					<input type='hidden' name='rowStatus_<%= tableIndex%>' id='rowStatus_<%= tableIndex%>' value='<%= checkForStatus(policyBean1.getStatus())%>'>
					<input type='hidden' name='rowNumber_<%= tableIndex%>' id='rowNumber_<%= tableIndex%>' value='<%= tableIndex%>'>
				</td>
				
			</tr>
<%
		tableIndex++;
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
</table>

<input type='hidden' name='pageInfo' id='pageInfo' value='DiagnosisCategoryDetails'>
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
<input type='hidden' name='rowCount' id='rowCount' value='<%=tableIndex -1 %>'>
<input type='hidden' name='last_link' id='last_link' value="">
<input type='hidden' name='diagCat_code_desp' id='diagCat_code_desp' value="<%=diagCat_code_desp%>">
</form>
</body>
</html>

