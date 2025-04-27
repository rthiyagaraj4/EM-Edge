<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
1-Nov-2012      100           	Karthikeyan.K          created  
---------------------------------------------------------------------------------------------------------------
-->

<%-- JSP Page specific attributes start --%>
<%@ page   
	import="webbeans.eCommon.*,eBL.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*,blHcard.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language="javascript"     src="../../eCommon/js/ValidateControl.js"></script> 
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language='javascript' src='../js/HealthCardMaster.js'></script>
<%-- JSP Page specific attributes end --%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
			String facilityId=(String)session.getAttribute("facility_id");
			String locale=(String)session.getAttribute("LOCALE");			

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />

<script>
var locale="<%=locale%>";
var facilityId="<%=facilityId%>";
var PRICE_LOOKUP_QUERY="select price_class_code code, short_desc description from bl_price_class_lang_vw where language_id='"+locale+"' and upper(price_class_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2";
var SERVICE_LOOKUP_QUERY="select blng_serv_code code, short_desc description from bl_blng_serv_lang where language_id='"+locale+"' and upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2";
var CLINIC_LOOKUP_QUERY="select clinic_code code, short_desc description from op_clinic_lang_vw where language_id='"+locale+"' and FACILITY_ID = '"+facilityId+"' and upper(clinic_code) like upper(?) and upper(short_desc) like upper(?) ORDER BY 2";
var VISIT_LOOKUP_QUERY="select A.visit_type_code code, A.short_desc description from op_visit_type_lang_vw A, op_visit_type_for_clinic B where A.FACILITY_ID = B.FACILITY_ID and A.VISIT_TYPE_CODE = B.VISIT_TYPE_CODE and B.FACILITY_ID = '"+facilityId+"' and A.language_id='"+locale+"' and A.EFF_STATUS = 'E'	and B.EFF_STATUS = 'E' and upper(A.visit_type_code) like upper(?) and upper(A.short_desc) like upper(?) and B.CLINIC_CODE = ";
var BLNGGRPCODE_LOOKUP_QUERY="select code, description from  ( select '**' code , 'All Billing Groups' description from dual union all  select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and  (status is null or status <> 'S') and SETTLEMENT_IND='C' ) where  upper(code) like upper(?) and upper(description) like upper(?)  ORDER BY 2";
var SERVICE_LOOKUP_QUERY_CODE="select blng_serv_code code, short_desc description from bl_blng_serv_lang where language_id='"+locale+"' and upper(short_desc) like upper(?) and upper(blng_serv_code) like upper(?) ORDER BY 2";

</script>

<%
String action_mode= request.getParameter("action_mode");
String card_type_code= request.getParameter("card_type_code");
boolean authSuccess=Boolean.parseBoolean(request.getParameter("auth_success"))?true:false; 
String dbOperation="insert";
boolean createMode = true;
boolean updateMode = false;

int ageDetailrowCount=1;
int visitDetailrowCount=1;
int groupDetailrowCount=1;

if(action_mode!=null && action_mode.equals("update")){
	createMode=false;	
	updateMode=true;
	dbOperation="update";
}

boolean authenticated=true;
if(updateMode && !authSuccess){
	authenticated=false;
}

String beanId = "HealthCareMasterBean";
String beanName = "eBL.HealthCareMasterBean";
HealthCareMasterBean bean = null;
ArrayList<blHcard.HealthCardAgeDetailBean> hcAgeDetailList=new ArrayList<blHcard.HealthCardAgeDetailBean>();
ArrayList<blHcard.HealthCardVisitRuleBean> hcVisitDetailList=new ArrayList<blHcard.HealthCardVisitRuleBean>();
ArrayList<blHcard.HealthCardCashBillingGroupBean> hcBlngGrpList=new ArrayList<blHcard.HealthCardCashBillingGroupBean>();
boolean ageDetailDataFound=false;
boolean visitDetailDataFound=false;
boolean groupDetailDataFound=false;


if(updateMode){	
	bean=(HealthCareMasterBean) getBeanObject(beanId, beanName, request);
	bean.setLocale(locale);
	bean.setFacilityId(facilityId);
	bean.clearHealthCardMasterBean();
	bean.getHealthCardMasterBean(card_type_code);
	hcAgeDetailList=bean.getHcAgeDetailList();
	hcVisitDetailList=bean.getHcVisitDetailList();
	hcBlngGrpList=bean.getHcBlngGrpList();
	
/* 	ageDetailrowCount=hcAgeDetailList.size();
	visitDetailrowCount=hcVisitDetailList.size();
	groupDetailrowCount=hcBlngGrpList.size(); */
/* Added by karthik on 3/6/2013 - SCF-38317 */	
	if(hcAgeDetailList.size()>0){
	ageDetailrowCount=hcAgeDetailList.size();
	ageDetailDataFound=true;
	}
	if(hcVisitDetailList.size()>0){
	visitDetailrowCount=hcVisitDetailList.size();
	visitDetailDataFound=true;
	}
	if(hcBlngGrpList.size()>0){
	groupDetailrowCount=hcBlngGrpList.size();
	groupDetailDataFound=true;
	}
	
}
%>

<HTML>
<HEAD>
</HEAD>
<body>
	<form name="frmPrevilageCardMaster" id="frmPrevilageCardMaster" >
		<body OnMouseDown="CodeArrest()" onKeyDown='lockKey()'>
			<br>
			<br>

<!-- Card type and Card validity fields -->
			<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td class='label' width="15%"><fmt:message key="eBL.CARD_TYPE.label" bundle="${common_labels}" /></td>
					<td class='fields' width="85%">
					<input name='cardTypeCode' id='cardTypeCode' size='30' maxlength='30' type='text' onKeyPress='uppercase();' value='<%=updateMode?bean.getCardTypeCode():""%>' <%=updateMode?"readonly onfocus='this.blur()'":""%>  <%=authenticated?"":"disabled"%> >
					<img src='../../eCommon/images/mandatory.gif'>
					<%if(updateMode){ %>
					<input type='button'  name='modButton' id='modButton' value='&nbsp;<fmt:message key="Common.Modify.label" bundle="${common_labels}" /> &nbsp;' onClick='authUser();'  <%=authenticated?"disabled":""%> >
					<%} %>					
					</td>		
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td class='label' width="15%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}" /></td>
					<td class='fields' width="85%">
					<input name='longDescription' id='longDescription' size='60' maxlength='100' type='text' value='<%=updateMode?bean.getLongDescription():""%>' <%=authenticated?"":"disabled"%>>
					<img src='../../eCommon/images/mandatory.gif'>
					</td>		
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td class='label' width="15%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}" /></td>
					<td class='fields' width="85%">
					<input name='shortDescription' id='shortDescription' size='60' maxlength='25' type='text' value='<%=updateMode?bean.getShortDescription():""%>' <%=authenticated?"":"disabled"%>>
					<img src='../../eCommon/images/mandatory.gif'>
					</td>		
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td class='label' width="15%"><fmt:message key="eBL.HCMasterValidity.label" bundle="${common_labels}" /></td>
					<td class='fields' width="85%">
					<input name='validDays' id='validDays' type='text' size='10' maxlength='5' onKeyPress='return(ChkNumberInput(this,event,"0"))' value='<%=updateMode?bean.getValidDays():""%>' <%=authenticated?"":"disabled"%>>
					<img src='../../eCommon/images/mandatory.gif'>
						
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="eBL.HCMasterNoOfPat.label" bundle="${bl_labels}" />
					<% String noOfPatStr = updateMode?((bean.getNoOfPat() == null) ? "" : bean.getNoOfPat()):"";%>
					<input name='noOfPat' id='noOfPat' type='text' size='8' maxlength='5' onKeyPress='return(ChkNumberInput(this,event,"0"))' value='<%=updateMode?noOfPatStr:""%>' <%=authenticated?"":"disabled"%>>
					<img src='../../eCommon/images/mandatory.gif'>
					</td>
				</tr>								
			</TABLE>

<!-- Card applicability fields -->				
			<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>	
				<tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td class='label' width="15.1%"><fmt:message key="eBL.HCMasterApplicability.label" bundle="${common_labels}" /></td>
					<td class='fields' width="34.9%">
					<input type='text' size='10' name='effectiveFrom' id='effectiveFrom' onblur='dateOnBlur(effectiveFrom);' value='<%=updateMode?bean.getEffectiveFrom():""%>' <%=authenticated?"":"disabled"%>>&nbsp;&nbsp;<img
						src="../../eCommon/images/CommonCalendar.gif"
						onclick="return showCalendar('effectiveFrom');" style='cursor: hand'" <%=authenticated?"":"disabled"%>><img src='../../eCommon/images/mandatory.gif'>	
					&nbsp;-&nbsp;
					<input type='text' size='10' name='effectiveTo' id='effectiveTo' onblur='dateOnBlur(effectiveTo);' value='<%=updateMode?bean.getEffectiveTo():""%>' <%=authenticated?"":"disabled"%>>&nbsp;&nbsp;<img
						src="../../eCommon/images/CommonCalendar.gif"
						onclick="return showCalendar('effectiveTo');" style='cursor: hand'" <%=authenticated?"":"disabled"%>>
					</td>	
					<td class='label' width="10%"><fmt:message key="eBL.HCMasterEnabled.label" bundle="${common_labels}" /></td>
					<td class='fields' width="10%"><input name='cardStatus' id='cardStatus' value="true" type='checkbox' <%=(createMode || (updateMode && bean.getCardStatus().equals("Y")) )?"checked":""%> <%=authenticated?"":"disabled"%>></td>	
					<td width="30%">				
					</td>
				</tr>			
			</TABLE>
<br>

		
<!-- Age Group fields -->			
<TABLE  width='100%'>
<th align='left'><fmt:message key="eBL.HCMasterAgeGroup.label" bundle="${common_labels}" /></th>
</TABLE>
<br>

<TABLE  border='0' cellpadding='1' cellspacing='0' width='100%'>
				<tr>
					<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}" /></td>
					<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.to.label" bundle="${common_labels}" /></td>
					<td class='COLUMNHEADER' width="23%"><fmt:message key="eBL.HCMasterPriceClass.label" bundle="${common_labels}" /></td>
					<td class='COLUMNHEADER' width="37%"><fmt:message key="eBL.MEMBER_SHIP_FEES.label" bundle="${common_labels}" /></td>
				</tr>
</TABLE>

<div id="ageGroupTableDiv" STYLE="width:100%; height:80; overflow: auto;">
<TABLE width='100%' border=0 bordercolor="black">
<TR>
<TD width='100%'>
			<TABLE id="ageGroupTable" valign=center border='0' cellpadding='1' cellspacing='0' width='100%'>
				<% 
				for(int i=0;i<ageDetailrowCount;i++)
				{			
				%>
				<tr>
					<td class='fields' width="21%">
					<input type='text' name='minAgeInDays<%=i%>' id='minAgeInDays<%=i%>' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getMinAgeInDays():""%>' size='2'  onKeyPress='return(ChkNumberInput(this,event,"0"))'  <%=authenticated?"":"disabled"%> <%=createMode?"":"readonly onfocus='this.blur()'"%>>D
					<input type='text' name='minAgeInMths<%=i%>' id='minAgeInMths<%=i%>' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getMinAgeInMths():""%>' size='2'  onKeyPress='return(ChkNumberInput(this,event,"0"))'  <%=authenticated?"":"disabled"%> <%=createMode?"":"readonly onfocus='this.blur()'"%>>M
					<input type='text' name='minAgeInYrs<%=i%>' id='minAgeInYrs<%=i%>'  value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getMinAgeInYrs():""%>' size='3'   onKeyPress='return(ChkNumberInput(this,event,"0"))'  <%=authenticated?"":"disabled"%> <%=createMode?"":"readonly onfocus='this.blur()'"%>>Y
					<img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td class='fields' width="21%">
					<input type='text' name='maxAgeInDays<%=i%>' id='maxAgeInDays<%=i%>' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getMaxAgeInDays():""%>' size='2'  onKeyPress='return(ChkNumberInput(this,event,"0"))' <%=authenticated?"":"disabled"%>>D
					<input type='text' name='maxAgeInMths<%=i%>' id='maxAgeInMths<%=i%>' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getMaxAgeInMths():""%>'  size='2'  onKeyPress='return(ChkNumberInput(this,event,"0"))' <%=authenticated?"":"disabled"%>>M
					<input type='text' name='maxAgeInYrs<%=i%>' id='maxAgeInYrs<%=i%>' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getMaxAgeInYrs():""%>'  size='3'   onKeyPress='return(ChkNumberInput(this,event,"0"))' <%=authenticated?"":"disabled"%>>Y
					<img src='../../eCommon/images/mandatory.gif'>			
					</td>
					<td class='fields' width="24%">
					<input type='hidden' name='priceClassCode<%=i%>' id='priceClassCode<%=i%>' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getPriceClassCode():""%>'>
					<input name='priceClassDesc<%=i%>' id='priceClassDesc<%=i%>' size="30" type='text' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getPriceClassCodeDescription():""%>'  size="4" onBlur='callPkgPriceClass(priceClassCode<%=i%>,priceClassDesc<%=i%>)' <%=authenticated?"":"disabled"%>>
					<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callPkgPriceClass(priceClassCode<%=i%>,priceClassDesc<%=i%>)'  <%=authenticated?"":"disabled"%>>
					</td>
					<td class='fields' width="34%">
					<input type='text' size='10'  name='membershipFeesCode<%=i%>' id='membershipFeesCode<%=i%>' onBlur='callPkgPriceClassForCode(membershipFeesCode<%=i%>,membershipFeesDesc<%=i%>)' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getMembershipFeesCode():""%>' <%=authenticated?"":"disabled"%>>
					<input name='membershipFeesDesc<%=i%>' id='membershipFeesDesc<%=i%>' size="30" type='text' value='<%=updateMode&&ageDetailDataFound?hcAgeDetailList.get(i).getMembershipFeesCodeDescription():""%>'  size="4" onBlur='callPkgPriceClass(membershipFeesCode<%=i%>,membershipFeesDesc<%=i%>)' <%=authenticated?"":"disabled"%>>
					<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callPkgPriceClass(membershipFeesCode<%=i%>,membershipFeesDesc<%=i%>)'  <%=authenticated?"":"disabled"%>>
					</td>
					<td>
					<input type='button' name='ageGroupBtn<%=i%>' id='ageGroupBtn<%=i%>' value='&nbsp;<fmt:message key="Common.Add.label" bundle="${common_labels}" /> &nbsp;' size='20' onClick='ageGroupRowAdd(ageGroupBtn<%=i%>);'  <%=authenticated?"":"disabled"%>>
					</td>
				</tr>
			<%} %>
			</TABLE>

</TD>
</TR>
</TABLE>
</div>
<br>					

<!-- No of Allotment fields -->	
			<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
				<TR>	
				<th align='left'><fmt:message key="eBL.HCMasterOPAllotment.label" bundle="${common_labels}" /></th>
				</TR>
			</TABLE>
<br>
			<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>	
				<tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td class='label' width="15%"><fmt:message key="eBL.BLNoOfOPAllotment.label" bundle="${common_labels}" /></td>
					<td class='fields' width="20%"><input name='noOfVisits' id='noOfVisits' type='text'  onKeyPress='return(ChkNumberInput(this,event,"0"))' value='<%=updateMode?bean.getNoOfVisits():""%>'  <%=authenticated?"":"disabled"%>>
					<img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td width="40%"></td>
					<td width="25%"><input type="button" value='<fmt:message key="Common.Add.label" bundle="${common_labels}" />' onClick='allotmentDetailsRowAdd()'  <%=authenticated?"":"disabled"%>>
					&nbsp;<!--<input type="button" value="Delete">-->
					</td>
				</tr>			
			</TABLE>			
<br>

<!-- Display Table -->
<TABLE  border='0' cellpadding='1' cellspacing='0' width='100%'>
				<tr>
					<td class='COLUMNHEADER' width="30%"><fmt:message key="eBL.BLClinic.label" bundle="${common_labels}" /></td>
					<td class='COLUMNHEADER' width="30%"><fmt:message key="eBL.BLVisitType.label" bundle="${common_labels}" /></td>
					<td class='COLUMNHEADER' width="20%"><fmt:message key="eBL.BLNoOfVisit.label" bundle="${common_labels}" /></td>
					<% if(updateMode&&visitDetailDataFound) {%>
					<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.delete.label" bundle="${common_labels}" /></td>
					<% }%>
					<td width="*"></td>
				</tr>
</TABLE>

<div id="allotmentDetailsTableDiv" STYLE="width:100%; height:100; overflow: auto;">
<TABLE width='100%' border=0 bordercolor="black">
<TR>
<TD width='100%'>
			<TABLE id="allotmentDetailsTable" valign=center border='0' cellpadding='1' cellspacing='0' width='100%'>

<% 
for(int i=0;i<visitDetailrowCount;i++) 
{%>
				<tr>
					<td class='fields' width="30%">
					<input type='hidden' name='clinic<%=i%>' id='clinic<%=i%>' value='<%=updateMode&&visitDetailDataFound?hcVisitDetailList.get(i).getClinicCode():""%>'>
					<input name='clinicDesc<%=i%>' id='clinicDesc<%=i%>' size='30' onblur='callVisitTypeClass(clinic<%=i%>,null,clinicDesc<%=i%>)' value='<%=updateMode&&visitDetailDataFound?hcVisitDetailList.get(i).getClinicCodeDescription():""%>'  type='text' <%=authenticated?"":"disabled"%> <%=(createMode||(updateMode &&!visitDetailDataFound))?"":"readonly onfocus='this.blur()'"%>>
					<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callVisitTypeClass(clinic<%=i%>,null,clinicDesc<%=i%>)' <%=authenticated?"":"disabled"%> <%=(createMode||(updateMode &&!visitDetailDataFound))?"":"disabled"%>>					
					</td>
					<td class='fields' width="30%">
					<input type='hidden' name='visitType<%=i%>' id='visitType<%=i%>' value='<%=updateMode&&visitDetailDataFound?hcVisitDetailList.get(i).getVisitTypeCode():""%>'>
					<input name='visitTypeDesc<%=i%>' id='visitTypeDesc<%=i%>' size='30' onblur='callVisitTypeClass(visitType<%=i%>,clinic<%=i%>,visitTypeDesc<%=i%>)' value='<%=updateMode&&visitDetailDataFound?hcVisitDetailList.get(i).getVisitTypeDescription():""%>'  type='text' <%=authenticated?"":"disabled"%> <%=(createMode||(updateMode &&!visitDetailDataFound))?"":"readonly onfocus='this.blur()'"%>>
					<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick='callVisitTypeClass(visitType<%=i%>,clinic<%=i%>,visitTypeDesc<%=i%>)' <%=authenticated?"":"disabled"%> <%=(createMode||(updateMode &&!visitDetailDataFound))?"":"disabled"%>>	
					</td>
					<td class='fields' width="20%"><input name='visitCount<%=i%>' id='visitCount<%=i%>' size='30' value='<%=updateMode&&visitDetailDataFound?hcVisitDetailList.get(i).getNoOfVisitsAllowed():""%>'  type='text' onKeyPress='return(ChkNumberInput(this,event,"0"))' <%=authenticated?"":"disabled"%>></td>
					<td class='fields' width="20%">
					<%if(updateMode&&visitDetailDataFound){ %>
						<input type="checkbox" name='clinicSelected<%=i%>' id='clinicSelected<%=i%>' size='30' value="true" <%=authenticated?"":"disabled"%>>
					<%} %>
					</td>
				</tr>
<%} %>
			</TABLE>
</TD>
</TR>
</TABLE>
</div>

<br>

<!-- Membership fees fields -->
<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
<TR>	
<th align='left'><fmt:message key="eBL.HCMasterBGDetails.label" bundle="${common_labels}" /></th>
</TR>
</TABLE>

<TABLE width='75%' border='0' bordercolor="black">
<TR>
<TD>&nbsp;&nbsp;&nbsp;</TD>
<TD width='100%'>
<div id="billingGroupCodeDescTableDiv" STYLE="width:100%; height:75; overflow: auto;">		
		<TABLE id="billingGroupCodeDescTable" border='0' cellpadding='1' cellspacing='0' width='100%'>
			
		<% 
		for(int i=0;i<groupDetailrowCount;i++)
		{%>
				<tr>
					<td class='label' width="20%" align="left" nowrap="nowrap">
					<fmt:message key="eBL.HCMasterBGCode.label" bundle="${common_labels}" />
					</td>
					<td class='fields' width="27%">
					<input name="billingGroupCode<%=i%>" id="billingGroupCode<%=i%>" value='<%=updateMode&&groupDetailDataFound?hcBlngGrpList.get(i).getBlngGrpId():""%>' type='text' size='5' <%if((createMode||(updateMode &&!groupDetailDataFound))){%>onBlur="callBillingGroupCode(billingGroupCode<%=i%>,billingGroupDescription<%=i%>)"<%}%> <%=authenticated?"":"disabled"%> <%=(createMode||(updateMode &&!groupDetailDataFound))?"":"readonly onfocus='this.blur()'"%>>
					<input type=button	class=button name='user_lookup' id='user_lookup' value='?' onClick="callBillingGroupCode(billingGroupCode<%=i%>,billingGroupDescription<%=i%>)" <%=authenticated?"":"disabled"%> <%=(createMode||(updateMode &&!groupDetailDataFound))?"":"disabled"%>>
					</td>
					<td class='label' width="8%"><fmt:message key="Common.description.label" bundle="${common_labels}" /></td>
					<td class='fields' width="20%">
					<input name="billingGroupDescription<%=i%>" id="billingGroupDescription<%=i%>" value='<%=updateMode&&groupDetailDataFound?hcBlngGrpList.get(i).getBlngGroupdescription():""%>' type='text' <%=authenticated?"":"disabled"%> <%=(createMode||(updateMode &&!groupDetailDataFound))?"":"readonly onfocus='this.blur()'"%>>
					</td>
					<td class='fields' width="10%">
					<input type='button' name='billingGroupAddBtn<%=i%>' id='billingGroupAddBtn<%=i%>' value='<fmt:message key="Common.Add.label" bundle="${common_labels}" />' onClick='billingGroupCodeDescRowAdd(billingGroupAddBtn<%=i%>)' <%=authenticated?"":"disabled"%>>
					</td>
					<td  width="*"></td>
				</tr>		
		<%} %>						
			</TABLE>
</TD>
<TD width='50%'></TD>
</TR>
</TABLE>
</div>	
<br><br>

<input type='hidden' name='ageGroupCount' id='ageGroupCount' value='1'>
<input type='hidden' name='clinicCount' id='clinicCount' value='1'>
<input type='hidden' name='billingGroupCount' id='billingGroupCount' value='0'>
<input type='hidden' name='dbOperation' id='dbOperation' value='<%=dbOperation%>'>
<input type='hidden' name='hidden_card_type_code' id='hidden_card_type_code' value='<%=card_type_code%>'>	
		
	</form>
</body>
</HTML>

