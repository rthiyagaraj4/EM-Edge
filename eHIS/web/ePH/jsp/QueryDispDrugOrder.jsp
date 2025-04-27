<!DOCTYPE html>
 <!--This file is saved on 28/10/2005--> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, java.text.DecimalFormat,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/08/2019      IN071035           Manickavasagam J	  	   Manickavasagam J			  SKR-SCF-1262
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  

%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html> 
	<head>
		<title></title>
<%
			request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
			<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
			<script language="javascript" src="../js/QueryDispDrug.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin='0'>
		<form name="formDispensedDrugs" id="formDispensedDrugs">
<%
			//Search Criteria's from Query Criteria page
			String	bean_id			=	"QueryPresVsDispDrugsBean" ;
			String	bean_name		=	"ePH.QueryPresVsDispDrugsBean";
			QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request);
			bean.setLanguageId(locale);
			String  dt_from				=	request.getParameter("dt_from");
			String  dt_to				=	request.getParameter("dt_to");
			String  from				=	request.getParameter("from");
			String  to					=	request.getParameter("to");
			String  drug_code			=	request.getParameter("drug_code");
			String  trade_Code			=	request.getParameter("trade_Code");
			String  route_code			=   request.getParameter("route_code");
			String  disploc_code		=	request.getParameter("disploc_code");
			String  billinggroup_code	=   request.getParameter("billinggroup_code");
			String  billingYN	        =   bean.getBillingYN();	
			String	visible             =   "";
			String  grp_route_code		=	""; 
			String  disp_loc			=	""; 
			String  route_color =   "", fntColor="",backgrndColor="" ; // added for CRF RUT-CRF-0034.1[IN:037389]
			ArrayList result	=	bean.getDispensedDetails(route_code,drug_code,dt_from,dt_to,from,to,disploc_code,billinggroup_code,trade_Code);
			String classValue	=	"";
			int count			=	0;

			int no_decimals =bean.getNoOfDecimals() ;
			String decimalStringFormat = "#.";
			// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya
			if(no_decimals == 0)
				decimalStringFormat = "#";
			for (int i=0;i<no_decimals;i++){
				decimalStringFormat += "#";
			}
			DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" topmargin='0'>
					<tr>
						<td width="80%" class="white">&nbsp;</td>
						<td width="20%" class="white">&nbsp;
<%
						// For display the previous/next link
						out.println(result.get(0));
%>
						</td>
					</tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" topmargin='0'>
 <%
					String colval , comp_str, gender_String, clval, patientDetails, blGroupDisp="";
					if(!billingYN.equals("Y"))
						blGroupDisp = "display:none";
					StringBuffer sb = null;
					java.util.StringTokenizer st = null;
					for(int i=1;i<result.size(); i+=20){ // i+=19 to i+=20 changed for SCF No : 0892 Inc No:[40991]
						if(!disp_loc.equals((String)result.get(i+17))){
							disp_loc = (String)result.get(i+17);
							route_color=(String)result.get(i+18);// added for CRF RUT-CRF-0034.1[IN:037389]-start
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
							<tr>
								<th class="lable" COLSPAN="9" align='left'><%=disp_loc%></th><!-- COLSPAN="8"  to COLSPAN="9" Modified for SCF No : 0892 Inc No:[40991] -->
							</tr>
							<tr><td COLSPAN="9">&nbsp;</td></tr>
							<tr>
                                <th width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th><!-- patiend id added for SCF No : 0892 Inc No:[40991] -->
								<th width="20%"><fmt:message key="ePH.PatientNameAgeSex.label" bundle="${ph_labels}"/></th>
<% 
								if(billingYN.equals("Y")){
%>
									<th width="10%"><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></th>
<%
								}
								else{
%>
									<th width="0%" style='<%=blGroupDisp%>;'></th>
<%
								}
%>
								<th width="5%" ><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></th>
								<!-- <th width="5%"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th> -->
								<th width="15%"><fmt:message key="ePH.TokenNo/DailySequenceNo.label" bundle="${ph_labels}"/></th>
								<th width="10%"><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></th>
								<th width="10%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
								<th width="10%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></th><!-- th width="15%" changed to  th width="10%" -->
								<th width="*"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
							</tr>
<%
						}
						if(count%2==0)
							classValue	="QRYEVENSMALL";
						else
							classValue	="QRYODDSMALL";
						count++;
						if(!grp_route_code.equals((String)result.get(i+13))){
							grp_route_code = (String)result.get(i+13);
%>
							<tr>
								<td class='label' colspan='8' style='color:<%=fntColor%>;'><b><%=(String)result.get(i+14)%></b></td>
							</tr>
<%
						}
						colval = ((String)result.get(i));
						gender_String="";
						clval="";
						patientDetails =	colval;			
						sb=new StringBuffer();
						st = new java.util.StringTokenizer(colval,",");
						comp_str ="";				
						while( st.hasMoreTokens()) {
							comp_str = st.nextToken();
							if((! (comp_str.trim().equals("female") || comp_str.trim().equals("male") || comp_str.trim().equals("unknown") ))){								
								sb.append(comp_str.trim()+" ");
							}
							if(comp_str.trim().equals("female")){
								gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							}
							if(comp_str.trim().equals("male")){
								gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							}
							if(comp_str.trim().equals("unknown")){
								gender_String=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
							}
							clval=sb.toString()+" "+gender_String;

						}
						//For encoding patient name
						patientDetails=patientDetails.replaceAll(" ","%20");
						patientDetails=	java.net.URLEncoder.encode(patientDetails,"UTF-8");
						patientDetails=patientDetails.replaceAll("%2520","%20");
%> 
						<tr>
						    <td class="<%=classValue%>"><%=(String)result.get(i+19)%></td><!-- patiend id added for  for SCF No : 0892 Inc No:[40991] -->
							<td class="<%=classValue%>"><%=clval%></td>
							<td class="<%=classValue%>" style='<%=blGroupDisp%>;'><%=(String)result.get(i+15)%>&nbsp;</td>
							<td class="<%=classValue%>" ><%=dfToInteger.format( Double.parseDouble((String)result.get(i+1)))%></td>
							<!-- <td class="<%=classValue%>"><%=(String)result.get(i+2)%></td> -->
							<td class="<%=classValue%>">&nbsp;<%=(String)result.get(i+16)%>&nbsp;</td>
							<td class="<%=classValue%>"><%=DateUtils.convertDate((String)result.get(i+3),"DMYHM","en",locale)%></td>
							<td class="<%=classValue%>" style="cursor:pointer;color:blue" onClick='loadOrderDetails("<%=(String)result.get(i+4)%>","<%=(String)result.get(i+8)%>","<%=patientDetails%>","<%=(String)result.get(i+19)%>")'><%=(String)result.get(i+4)%></td><!-- (String)result.get(i+19),Addied for passing patiend id SCF No : 0892 Inc No:[40991] -->
							<td class="<%=classValue%>"><%=DateUtils.convertDate((String)result.get(i+5),"DMYHM","en",locale)%></td>
							<td class="<%=classValue%>"><%=(String)result.get(i+6)%></td>
						</tr>
<%
					}	
				}
				else {
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); </script>
<%
				}
%>	
				</tr>
			</table>
			<input type="hidden" name="from" id="from" value="">
			<input type="hidden" name="to" id="to" value="">
			<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
			<input type="hidden" name="dt_from" id="dt_from" value="<%=dt_from%>">
			<input type="hidden" name="dt_to" id="dt_to" value="<%=dt_to%>">
			<input type="hidden" name="disploc_code" id="disploc_code" value="<%=disploc_code%>">
			<input type="hidden" name="billinggroup_code" id="billinggroup_code" value="<%=billinggroup_code%>">
			<input type="hidden" name="trade_Code" id="trade_Code" value="<%=trade_Code%>"> <!--added for SKR-SCF-1261 -->
			<input type="hidden" name="route_code" id="route_code" value="<%=route_code%>"> <!--added for SKR-SCF-1261 -->


			
		</form>
	</body>
	<script>
<%
		if( (result.size()>=3) ) {
%>
			loadDrugDetails("",encodeURIComponent("<%=(String)result.get(10)%>"),encodeURIComponent("<%=(String)result.get(13)%>"));
<%
		}	
%>
	</script>
	<% putObjectInBean(bean_id,bean,request); %>
</html>

