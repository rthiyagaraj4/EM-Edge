<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
14/12/2012		IN035950		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
											more appealing. Keeping the display of information more clear and visible.
14/12/2012		IN040966		Chowminya   Order Type name and Order ID of medication doesn?t have background as grey color
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

07/03/2022		27788			Ramesh Goli		07/03/2022		RAMESH G    	MMS-ME-SCF-0067
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,ePH.*,ePH.Common.*, eOR.*,org.apache.commons.codec.binary.Base64,eCommon.XSSRequestWrapper"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	//[IN035950] Starts
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
	
	//27788 Start.
	String prefStyleSheet 	= "";
	String content_ID 		= "";
	String patient_id 		= "";
	String encounter_id	    = "";
	String called_from	    = "";
	String ReqDb	    	= "";
	String enc_id1	    	= "";
	String p_called_from_widget	    = "";
	String ord_id			= "";
	String title = request.getParameter("title");
	String compressed =request.getParameter("compressed")==null?"N":(String)request.getParameter("compressed");
	if("Y".equals(compressed)){		
		patient_id		=	new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		encounter_id	    =	new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));		
	}else{		
		patient_id		=	request.getParameter("patient_id");
		encounter_id	    =	request.getParameter("encounter_id");				
	}
	prefStyleSheet = request.getParameter("prefStyle");//Nijitha
	content_ID = request.getParameter("content_ID")==null?"": request.getParameter("content_ID");	
	called_from	    =	request.getParameter("called_from")==null?"":request.getParameter("called_from"); //Added for MMS-DM-CRF-115.4
	ReqDb	    =	request.getParameter("RepDb")==null?"":request.getParameter("RepDb"); //Added for MMS-DM-CRF-115.4
	enc_id1	    =	request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
	p_called_from_widget	    =	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//&p_called_from_widget=CURRENT_MEDICATION
	
	ord_id	=	request.getParameter("ord_id")==null?"":request.getParameter("ord_id");
	
	//27788 End.
	
	String sessionStyle = "";
	if(prefStyleSheet!=null && !prefStyleSheet.equals("")){
		sessionStyle=prefStyleSheet;
	}//[IN035950] Ends
	String facility_id=(String)session.getValue( "facility_id" );//Added for Bru-HIMS-CRF-400
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale = (String) session.getAttribute("LOCALE");
	
	String	bean_id			=	"ChartSummaryCurrentMedicationsBean" ;
	String	bean_name		=	"ePH.ChartSummaryCurrentMedicationsBean";
	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name,request ) ;
	ChartSummaryCurrentMedicationsBean bean = (ChartSummaryCurrentMedicationsBean)getBeanObject(bean_id,bean_name ,request) ;
	bean.setLanguageId(locale);
	if(!p_called_from_widget.equals("CURRENT_MEDICATION"))
		orbean.clearRenewOrders();
	HashMap hmRenewOrders = orbean.getRenewOrderIds();
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript" src="../js/ChartSummaryCurrentMedications.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<head>
		<title><fmt:message key="Common.ChartSummaryCurrentMedications.label" bundle="${common_labels}"/></title>
		<style>
			TH {
			   BACKGROUND-COLOR: #8A8A8A;
			   FONT-SIZE:9pt; 
			   FONT-WEIGHT: bolder;
			}

		</style>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='ChartSummaryCurrentMedicationsForm' id='ChartSummaryCurrentMedicationsForm' method='post'>
			<table cellpadding=0 cellspacing=0 border=1 width='100%'>
<%
				String  Order_type_legend="",alt_drug_duration="";
				String drug_name = "",	drug_duration = "",IV_Prep_yn="",order_id="",alternate_order_id="";
				String classValue = "",iv_drug_fluid_continuous_lg="",iv_drug_fluid_intermittent_lg="",iv_without_additives_lg="",drug_status="",allow_renew_from_chart_summ_yn="",single_cont_renew_hrs_behind="",single_cont_renew_hrs_ahead="",renew_yn="", drug_code="";//drug_status,allow_renew_from_chart_summ_yn,single_cont_renew_hrs_behind,single_cont_renew_hrs_ahead Added for Bru-HIMS-CRF-400
				String or_order_line = "", orderKey="", renewChecked="";
				int count=1;
				int k=0;
				//Added for Bru-HIMS-CRF-400-Start
				HashMap PeriodChk=bean.getPeriodChk(facility_id);
				if(PeriodChk.size()>0){
					allow_renew_from_chart_summ_yn=(String)PeriodChk.get("ALLOW_RENEW_FROM_CHART_SUMM_YN");
					single_cont_renew_hrs_behind=(String)PeriodChk.get("SINGLE_CONT_RENEW_HRS_BEHIND");
					single_cont_renew_hrs_ahead=(String)PeriodChk.get("SINGLE_CONT_RENEW_HRS_AHEAD");
				}//Added for Bru-HIMS-CRF-400-End
				HashMap Order_Group		=	new HashMap();
				ArrayList legends	=	new ArrayList();			
				
				Order_Group		=	bean.getCurrentMedicationDetails(patient_id,ord_id,allow_renew_from_chart_summ_yn,single_cont_renew_hrs_behind,single_cont_renew_hrs_ahead,called_from,ReqDb,enc_id1);//allow_renew_from_chart_summ_yn,single_cont_renew_hrs_behind,single_cont_renew_hrs_ahead Added for Bru-HIMS-CRF-400//called_from,enc_id1,ReqDb added for MMS-DM-CRF-115.4

				legends							=	bean.getIVLegends();
				if(legends.size()>0){
					iv_drug_fluid_continuous_lg		=	(String)legends.get(0);
					iv_drug_fluid_intermittent_lg	=	(String)legends.get(1);
					iv_without_additives_lg			=	(String)legends.get(2);
				}
				if (Order_Group.get("count") != null && (!Order_Group.get("count").toString().equals(""))){
					count	=	Integer.parseInt(Order_Group.get("count").toString());
				}
				for(int i=1;i<=(count-1);i++){
				   k++;
				   order_id			=	(String)Order_Group.get("order_id"+i);
				   drug_name		=	(String)Order_Group.get("drug_name"+i);
				   drug_duration	=	(String)Order_Group.get("drug_duration"+i);
				   IV_Prep_yn		=	(String)Order_Group.get("IV_Prep_yn"+i);
				   renew_yn			=   (String)Order_Group.get("RENEW_YN"+i);
				   or_order_line 	= (String)Order_Group.get("or_order_line"+i);
				   drug_code 		= (String)Order_Group.get("DRUG_CODE"+i);
				   renewChecked="";
				   if(hmRenewOrders!=null && hmRenewOrders.containsKey(drug_code)){
					   orderKey = (String)hmRenewOrders.get(drug_code);
					   if(orderKey.equals(order_id+","+or_order_line))
						   renewChecked = "checked";
				   }
				   if(IV_Prep_yn.equals(""))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NormalRx.label","ph_labels");
				   else if(IV_Prep_yn.equals("1"))
					   Order_type_legend	=	iv_drug_fluid_continuous_lg;
				   else if(IV_Prep_yn.equals("2"))
					   Order_type_legend	=	iv_drug_fluid_continuous_lg;
				   else if(IV_Prep_yn.equals("3"))
					   Order_type_legend	=	iv_drug_fluid_intermittent_lg;
				   else if(IV_Prep_yn.equals("4"))
					   Order_type_legend	=	iv_drug_fluid_intermittent_lg;
				   else if(IV_Prep_yn.equals("5"))
					   Order_type_legend	=	iv_without_additives_lg;
				   else if(IV_Prep_yn.equals("6"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompoundingRx.label","ph_labels");
				   else if(IV_Prep_yn.equals("7"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNStandardRegimen.label","ph_labels");
				   else if(IV_Prep_yn.equals("8"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPNNONStandardRegimen.label","ph_labels");
				   else if(IV_Prep_yn.equals("9"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OncologyRegimen.label","ph_labels");
				   else if(IV_Prep_yn.equals("0"))
					   Order_type_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OncologyRegimen.label","ph_labels");

					if ( k % 2 == 0 )
						classValue = "QRYODD" ;
					else
						classValue = "QRYEVEN" ;

				   if(IV_Prep_yn.equals("")){
%>
					   <table cellpadding=0 cellspacing=0 border=0 width='100%'>
							<tr> 
							<!--IN035950 Starts-->
							<!--<th align="left"><font size=1><%=Order_type_legend%>/<%=order_id%></th>-->
							<th align="left"><%=Order_type_legend%>/<%=order_id%></th>
							<!--IN035950 Ends-->
						   </tr>
						</table>
						<table cellpadding=0 cellspacing=0 border=1 width='100%'>
						   <tr>
							<!--IN035950 Starts-->
							<!--<td class="<%=classValue%>" width="75%"><font size=1><%=drug_name%></td>
							<td class="<%=classValue%>" width="25%"><font size=1><%=drug_duration%></td>-->
							<td class="gridData" width="75%"><font size=1><%=drug_name%></font></td>
							<td class="gridData" width="25%"><font size=1><%=drug_duration%></font>
<%
							if( renew_yn.equals("Y") && !called_from.equals("REROUTE")){//Added for Bru-HIMS-CRF-400-Start 
								drug_status = "#990000";
								if(!p_called_from_widget.equals("CURRENT_MEDICATION")){
%>
									<td  class="gridData" width="3%" style="background-color:<%=drug_status%>" title='<fmt:message key="ePH.RenewOrder.label" bundle="${ph_labels}"/>'>
										<input type="checkbox" name="renewYN<%=i%>" id="renewYN<%=i%>" value="" onclick='setSelectedRenewOrder(this,"<%=i%>");checkDuplicate(this,"<%=i%>","<%=count%>" );' <%=renewChecked%> >
									</td>
<%
								}
								else{
%>
									<td  class="gridData" width="5%" style="background-color:<%=drug_status%>">
										<input type="checkbox" name="renewYN<%=i%>" id="renewYN<%=i%>" value="" style='display:none;' >
<%
									if(renewChecked.equals("checked")){
%>
										<img style='background-color:white;height:10px;width:10px;' src='../../eCommon/images/enabled.gif'></img>
<%
									}
									else{
%>
										<img style='background-color:white;height:10px;width:10px;visibility:hidden' src='../../eCommon/images/enabled.gif'></img>
<%
									}
%>
									</td>
<%
								}
							}
							else{
%>
								<td  class="gridData" width="3%">
									<input type="checkbox" name="renewYN<%=i%>" id="renewYN<%=i%>" value="" style='display:none;' >
								</td>
<%
							}
%><!--Added for Bru-HIMS-CRF-400-End -->
							<!--IN035950 Ends-->
						</tr>
					</table>
<%
				}
				else{
					if(!(order_id.equals(alternate_order_id))){
%>
						<table cellpadding=0 cellspacing=0 border=0 width='100%'>
							<tr> 
								<!--IN035950 Starts-->
								<!--<th align="left"><font size=1><%=Order_type_legend%>/<%=order_id%></th>-->
<%
								//if(sStyle.equals(prefStyleSheet) ){//Commentted - Start  IN040966 
%>
								<!--	<th align="left"><font size=1><%=Order_type_legend%>/<%=order_id%></th> -->
<%
							//	}
							//	else{
%>
								<!--	<td class='COLUMNHEADERCENTER<%=content_ID%>'><font size=1><%=Order_type_legend%>/<%=order_id%></td> -->
<%
							//	}//Commentted - end  IN040966
%>
							<th align="left"><%=Order_type_legend%>/<%=order_id%></th><!-- IN040966 -->
								<!--IN035950 Ends-->
							</tr>
						   </table>
<%
							alt_drug_duration	=	drug_duration;
						}
						else{
							//alt_drug_duration	=	"&nbsp";
						}
%>
						<table cellpadding=0 cellspacing=0 border=1 width='100%'>
						   <tr>									
								<!-- <td class="<%=classValue%>" width="75%"><font size=1><%=drug_name%></td><!-- IN040966 Start-->
								<td class="<%=classValue%>" width="25%"><font size=1><%=alt_drug_duration%></td>
								<td class="gridData" width="75%"><font size=1><%=drug_name%></td>
								<td class="gridData" width="25%"><font size=1><%=alt_drug_duration%>
								<input type="checkbox" name="renewYN<%=i%>" id="renewYN<%=i%>" value="" style='display:none;' >
								</td>    <!-- IN040966 End-->
						   </tr>
						</table>
<%
						alternate_order_id	=	order_id;
					}
%>
					<input type='hidden' name='OrderId_LineNum<%=i%>' id='OrderId_LineNum<%=i%>' value='<%=order_id%>,<%=or_order_line%>'>
					<input type='hidden' name='drug_code<%=i%>' id='drug_code<%=i%>' value='<%=drug_code%>'>
					<input type='hidden' name='IV_Prep_yn<%=i%>' id='IV_Prep_yn<%=i%>' value='<%=IV_Prep_yn%>'>
<%
				}//IN035950 Starts
				if(k==0){
					out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
				}
				//IN035950 Ends
%>
			</table>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'/>
			<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'/>
			<input type='hidden' name='count' id='count' value='<%=count%>'/>
			<!--  27788 Start. -->
			<input type='hidden' name='prefStyleSheet' id='prefStyleSheet' value='<%=prefStyleSheet%>'/>
			<input type='hidden' name='content_ID' id='content_ID' value='<%=content_ID%>'/>
			<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'/>
			<input type='hidden' name='ReqDb' id='ReqDb' value='<%=ReqDb%>'/>
			<input type='hidden' name='enc_id1' id='enc_id1' value='<%=enc_id1%>'/>
			<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from_widget%>'/>
			<input type='hidden' name='ord_id' id='ord_id' value='<%=ord_id%>'/>
			<!-- 27788 End. -->
		</form>
	</body>
	<script>
		disableDuplicate(); 
	</script>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,orbean,request);
%>

