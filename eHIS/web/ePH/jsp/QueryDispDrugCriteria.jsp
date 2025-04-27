<!DOCTYPE html>
<%-- JSP Page specific attributes start --%> 
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String	bean_id			=	"QueryPresVsDispDrugsBean" ;
		String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";
		String	billingYN       =   "";
		String	visible         =   "";
		String  route_color  =   "", fntColor="",backgrndColor="" ;// added for CRF RUT-CRF-0034.1[IN:037389]
		QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request);
		bean.setLanguageId(locale);
		ArrayList route_codes		  =  bean.getRouteCodes();
		billingYN					  =  bean.checkforbillinginterface();//Check from DB
		bean.setBillingYN(billingYN);//Set to bean
		if(billingYN.equals("Y"))
			visible = "visibility:visible";
		else
			 visible = "visibility:hidden";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/QueryDispDrug.js"></script> 
		<script language="javascript" src="../js/DrugNameCommonLookup.js"></script> 
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
		<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- 		Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9384 [IN:056577]  -->
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0"> 
		<form name="FormQueryDispDrug" id="FormQueryDispDrug">
			<table cellpadding="0.5" cellspacing="1" width="100%" align="center" border="0" topmargin="0">
				<tr>
					<td class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
					<td  class="label" colspan=3>&nbsp;&nbsp;
						<input type=radio name="searchby" id="searchby" value="D" checked onclick="clearvalues()"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>
						<input type=radio name="searchby" id="searchby" value="T" onclick="clearvalues()"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/>
					</td> 
					<td  class="label" colspan=2>&nbsp;</td>
				</tr>
				<tr >
					<td class="label"><label id="drug_trade_legend" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></label></td>&nbsp;&nbsp;
					<td   colspan=2><input type=text  maxlength="40" size="40" name="Drug_Name" id="Drug_Name" onchange='searchDrugName(document.FormQueryDispDrug);'><INPUT TYPE="button" name="Drug_Name_Button" id="Drug_Name_Button" VALUE="?" CLASS="button"  onClick="searchDrugName(document.FormQueryDispDrug)">&nbsp;<img name="PhysicalLocMandatory" src="../../eCommon/images/mandatory.gif"></td>
					<td class="label"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
					<td colspan=2>
						<select name="route_code" id="route_code">
<%
						if(route_codes!=null){
							for(int i=0;i<route_codes.size();i=i+3){
								route_color=(String)route_codes.get(i+2);// added for CRF RUT-CRF-0034.1[IN:037389]-start
								if(route_color!= null && !route_color.equals("")){
									if(route_color.length()==12){
										fntColor= route_color.substring(0, 6);
										backgrndColor= route_color.substring(6, 12);
									}
								}
								else{
									fntColor= "";
									backgrndColor= "";
								}// added for CRF RUT-CRF-0034.1[IN:037389]-end
%>
								<option value="<%=(String)route_codes.get(i)%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>'><%=(String)route_codes.get(i+1)%></option>
<%
							}
						}
%>
						</select>
					</td> 
				</TR> 
				<Tr>
					<td class="label" nowrap><fmt:message key="ePH.DispenseDateFrom.label" bundle="${ph_labels}"/>
					</td>
					<td><input type=text  name="Dispense_Date_From" id="Dispense_Date_From" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%= locale %>')" value="<%=com.ehis.util.DateUtils.convertDate(bean.getSysdate(),"DMY","en",locale)%>"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Dispense_Date_From');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></TD><!-- 		Added CheckDateLeap funtion for RollForward from SRR - SRR20056-SCF-9384 [IN:056577]  -->
					<TD>&nbsp;</Td>
					<Td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
					<Td><input type=text  name="Dispense_Date_To" id="Dispense_Date_To" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%= locale %>')" value="<%=com.ehis.util.DateUtils.convertDate(bean.getSysdate(),"DMY","en",locale)%>""><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('Dispense_Date_To');" value="<%=bean.getSysdate()%>">&nbsp;<img src="../../eCommon/images/mandatory.gif"><!-- 		Added CheckDateLeap funtion forRollForward from SRR - SRR20056-SCF-9384 [IN:056577]   -->
					</td>
					<td  class="label" colspan=2>&nbsp;</td>
				</tr>
				<tr>
					<td class="label" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td COLSPAN="2">
						<select name="DispenseLocation" id="DispenseLocation" maxlength="40">
							<option value="all">-----<fmt:message key="Common.all.label" bundle="${common_labels}"/>-----</option>
<%
							ArrayList	arraylistOfDispLoc		=	null;
							HashMap		hmDispLoc		=	null;	
							String		locCode			=	"";
							String		locDesc			=	"";
							arraylistOfDispLoc			=	bean.getAllDispLocn();
							int			arrLength		=	arraylistOfDispLoc.size();
							for(int i=0;i<arrLength; i++){
								hmDispLoc      	=	(HashMap)arraylistOfDispLoc.get(i);
								locCode				=	(String)hmDispLoc.get("code");
								locDesc				=	(String)hmDispLoc.get("desc");
%> 
								<option value="<%=locCode%>"  ><%=locDesc%></option> 	
<% 
							} 
%>
						</select>
					</td>
					<td class="label" ><label style="<%=visible%>"><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></label></td>
					<td COLSPAN="2" >
						<select name="billingGroupcode" id="billingGroupcode" maxlength="40" style="<%=visible%>">
							<option value="all">-----<fmt:message key="Common.all.label" bundle="${common_labels}"/>-----</option>
<%
							ArrayList	arraylistOfBillingGroup		=	null;
							HashMap		hmBillingGroup	    =	 null;	
							String      billingGrupCode		=	 "";
							String	    billingGrupDesc		=	 "";
							arraylistOfBillingGroup		    =	 bean.getAllBillingGroup();
							int arrSize		=	arraylistOfBillingGroup.size();
							for(int i=0;i<arrSize; i++){
								hmBillingGroup      	=	(HashMap)arraylistOfBillingGroup.get(i);
								billingGrupCode				=	(String)hmBillingGroup.get("code");
								billingGrupDesc				=	(String)hmBillingGroup.get("desc");
%> 	
								<option value="<%=billingGrupCode%>"  ><%=billingGrupDesc%></option> 	
<% 	
							} 
%>
						</select>
					</td>
				</tr>
				<tr>
					<td COLSPAN="4">&nbsp;</td>
					<td COLSPAN="1" align='center'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResultPage()"></td>
					<td COLSPAN="1">&nbsp;</td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="Drug_Code" id="Drug_Code" >
			<INPUT TYPE="hidden" name="trade_Code" id="trade_Code" >
			<INPUT TYPE="hidden" name="billingYN" id="billingYN" VALUE="<%=billingYN%>">
			<INPUT TYPE="hidden" name="TRADE_QUERY" id="TRADE_QUERY" VALUE="select TRADE_ID code , SHORT_NAME description from  am_trade_name_lang_vw where language_id like(?) and upper(trade_id) like upper(?) and upper(SHORT_NAME) like upper(?) order by 2">
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
	<script>document.FormQueryDispDrug.Drug_Name.focus();</script>
</html> 

