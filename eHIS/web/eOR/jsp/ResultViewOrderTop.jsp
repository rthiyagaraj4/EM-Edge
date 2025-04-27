<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100         	?            	created
27/01/2012	  	INO30714		Menaka V	 	THAI screen>View Clinical Event History>View>In the Recorded Clinical
												Note the name is not displayed in THAI 
22/02/2013	   	IN036821		Chowminya G	 	Reporting Practitioner name not coming in the CA report										 
08/05/2013	    IN029323		NijithaS    	System displays External order details as "null" and unable to Record the Result for that order.
------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
10/04/2014		IN048449		Karthi L										Alpha-OR-Wrong date format displayed at Results window when application Switched to Thai language
22/06/2015 		IN056017		Nijitha S										Alpha-OR-Existing Orders-System throws script error in Result window for order format item.
09/5/2016		IN058811		Raja S			10/05/2016		Ramesh G		MO-CRF-20107 :National ID to be captured in any orderable (ALL 	Order Categories) is a national requirement.
23/08/2016		IN061345		Ramesh G										Not able to view the lab reports through clinician access.
10/05/2017		IN064215		Krishna Gowtham J 10/05/2017	Ramesh G		PMG2017-SH-CRF-0001		
18/07/2018              IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
4/02/2019               IN066453                Ramya Maddena   6/02/2019       Ramesh G		ML-BRU-CRF-0491
18/09/2020		IN074069			Sivabagyam M		18/09/2020		Ramesh G			SKR-SCF-1437
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
04/10/2022     35142            Twinkle Shah                                     TH-KW-CRF-0020.6
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%> <!-- 35142 added -->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
 	<script language="JavaScript" src="../js/ResultOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
System.out.println("----------------->ResultViewOrderTop.jsp");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	String viewBean_id = "Or_ViewOrder";
	String viewBean_name = "eOR.ViewOrder";
	//String priority="";
	String orderId = request.getParameter("orderId");
	String facility_id = (String)session.getValue("facility_id");
	//String[] allValues = new String[40];//IN066453
	//String[] allValues = new String[44];//added for 7632
	String[] allValues = new String[45];//added for 7632//31792
	String location="";
	String patient_details="";
	String order_line_num = request.getParameter("order_line_num");
	String cont_order_ind = request.getParameter("cont_order_ind");	
	
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name , request) ;
	String  orderFormatAuditTrailYN= bean.getOrderFormatAuditTrailYN();  //IN056017
	bean.setLanguageId(localeName);

	/*****Added by Deepa on 11/4/2009 at 2:55 PM for IN011473*****************/
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String resp_id = (String) session.getAttribute("responsibility_id") == null ? "" : (String) session.getAttribute("responsibility_id");
	String userid = (String)session.getAttribute("login_user") == null ? "" : (String)session.getAttribute("login_user"); //35142
	String repPract = "";
	String repPractName = "";
	ViewOrder vwBean = (ViewOrder) getBeanObject( viewBean_id, viewBean_name,request ) ;
	vwBean.setLanguageId(localeName);	

	//String view_bean_id = "Or_ViewOrder" ;
	//String view_bean_name = "eOR.ViewOrder";
	//ViewOrder view_bean = (ViewOrder)getBeanObject( view_bean_id, view_bean_name , request) ;
	// From the View Order get the clinical comments if it is there
	//view_bean.setLanguageId(localeName);	
 	String ca_pract_name		=  "";
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 	bean.clear() ;
	bean.setMode( mode ) ;
 	allValues		= bean.viewMainDetails(orderId);
	String [] print_details = {"","","","","","",""};
    print_details = (String[])bean.getOrderDetails(orderId);

	// Query to found to call the image file or the result file
	//String image_ref_yn = view_bean.getImageRefYn(orderId);
		
	//out.println("image_ref_yn="+image_ref_yn);
	String order_type_code = bean.checkForNull(allValues[39]);
    String order_status    = print_details[6];
    String reportingTime   = "";
    String specimenCollectedTime   = "";
	String view_by = request.getParameter("view_by"); //IN064215
	String lv_neonate_spec_yn = "";//31792
	lv_neonate_spec_yn = allValues[45];//31792
	System.out.println("------------lv_neonate_spec_yn------->"+lv_neonate_spec_yn);
	/*ADDED BY Deepa */
/*
	ArrayList repPractList = new ArrayList();
	String textToolTip = "";
	try
	{
		repPractList = (ArrayList) vwBean.getRepPractCnt(orderId,order_line_num,patient_id,resp_id,facility_id,request.getParameter("ord_cat"),order_status,cont_order_ind);
	
		if(repPractList.size() > 0)
		{
			repPract = (String) repPractList.get(0);	
			repPractName = (String) vwBean.getRepPractName(repPract, localeName);

			if(repPractList.size() == 1) 
			{
				repPractName = repPractName;
				textToolTip = "";
			}
			else 
			{
				repPractName = repPractName + " * ";
				textToolTip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.multipleRepPract.label","or_labels");;
			}
		}
	}
	catch(Exception ee)
	{
		System.out.println("Exception in ResultViewOrderTop.jsp -"+ee.toString());
		ee.printStackTrace(System.err);
	}
	*/
	/*ADDED BY Deepa */
          
	
	//35142 Start.
	String fromFunction=request.getParameter("fromFunction") == null ? "" : request.getParameter("fromFunction");
	bean.setSiteSpecificYN("QUE_PKI_APPLIC_ORDER_TRACKING");
	boolean  quePki_SiteSpecific =bean.isSiteSpecific("QUE_PKI_APPLIC_ORDER_TRACKING");
	bean.setSiteSpecificYN("NEONATAL_MOTHER_SPECIMEN");
	boolean  isSiteSpecificNeonatalMotherSpecimen =bean.isSiteSpecific("NEONATAL_MOTHER_SPECIMEN");
	System.out.println("------------isSiteSpecificNeonatalMotherSpecimen------->"+isSiteSpecificNeonatalMotherSpecimen);
	String  pkiSiteSpecificYN="N";
	//35142 End.
	
	//String max_action_seq_num	= bean.checkForNull(view_bean.getMaxCount(orderId),"");
	String max_action_seq_num	= allValues[29];
	String image_ref_yn=allValues[31];
	if(image_ref_yn==null) image_ref_yn="N";
	ArrayList practitionerDetails = new ArrayList();
	practitionerDetails = bean.getPractitionerDetails(orderId,cont_order_ind,facility_id,request.getParameter("ord_cat"),order_type_code);
	int timeHeader = 0;
	if (practitionerDetails.size() == 2) timeHeader = 1;

	if(allValues!=null && orderId!=null) 
	{
		//ca_pract_name		= bean.checkForNull(view_bean.getOrderPractitioner(orderId),"");
		ca_pract_name		= allValues[30];
	}
	if(ca_pract_name==null)	ca_pract_name = "";

	if(allValues[2] == null  || allValues[2].equals("null") || allValues[2].equals("") )
	{
		allValues[2]="R";
	}
		 
	  if(allValues[2].compareTo("R")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	}
	else if(allValues[2].compareTo("U")==0)
	{						  
	
	    allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
	}
	else if(allValues[2].compareTo("S")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
	}	
	

	String sex1="";
	
	if (allValues[3].equalsIgnoreCase("M"))
		sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(allValues[3].equalsIgnoreCase("F"))
		sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

	if(allValues[36].equalsIgnoreCase("C"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("N"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}
	//IN029323 Starts
	if(null==allValues[4])
		allValues[4]="";
	//IN029323 Ends
	patient_details=allValues[6]+","+sex1+"/"+allValues[34]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+allValues[35];
	//out.println(allValues.length);
//out.println("<script>alert('ca_pract_name="+ca_pract_name+"');</script>");
	
%>
<!--<Script>alert('<%//=practitionerDetails.size()%>')</Script>-->
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center >
	<tr>
		<td  class='label' nowrap><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=orderId%></B>
		<!-- 31792 starts -->
		<% if (isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){ %>
		<input type='image' src='../../eCA/images/MotherBlood.png' onClick="NeonatalMotherSpecimenDetails('<%=allValues[32] %>','<%=allValues[15] %>','<%=allValues[44] %>','<%=allValues[41] %>','<%=allValues[35] %>','<%=allValues[41] %>')"/></td>
		<%} %>
		<!-- 31792 starts -->
		<td  class='label'  nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='data'> <B><%=allValues[0]%></B></td>
	</tr>
	<tr>
		<td  class='label'  nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='data'> <B><%=allValues[1]%></B></td>
		<td  class='label'  nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>		
		<td class='data'> <B><%=allValues[2]%></td>
	</tr>
	<tr>
		<td  class='label'  nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
		<td class='data' ><B><%=patient_details%></B></td>
		<td  class='label'  nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[4]%></B></td>
	</tr>
	<tr>
		<td  class='label'  nowrap><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
		<td class='data' nowrap><B> <%=com.ehis.util.DateUtils.convertDate(allValues[12],"DMYHM","en",localeName)%></B></td>
		<td  class='label'  nowrap><fmt:message key="eOR.NationalId.label" bundle="${or_labels}"/></td><!-- IN058811 New Label-->
		<td class='data'><B><%=(allValues[40]== null)? "" :allValues[40]%></B></td> <!-- IN058811 New Label -->
		
	</tr>
	<tr>
		<td  class='label'  nowrap><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=location%>/<%=allValues[38]%></B></td>
		<td  class='label'  nowrap><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td><!-- IN058811 changed order-->
		<td class='data' nowrap><B><%=allValues[5]%></B></td><!-- IN058811 changed order-->
		
	</tr>
	<tr>
		<td  class='label'  nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[8]%></B></td>
		<td  class='label'  nowrap><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td><!-- IN058811 changed order-->
		<td class='data'><B><%=allValues[7]%></B></td><!-- IN058811 changed order-->
		
	</tr>
	<%
		if(allValues[10] == null) allValues[10] = "";
		// added for IN048449 - Start
		String	converted_date="";	 
		String	format_date="";
		int date_part=allValues[10].indexOf("/");
		if(date_part!=-1)
		{
			if((date_part+14)<=allValues[10].length()&&(allValues[10].substring(date_part-2,date_part+14).matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}")))
			{
				format_date=allValues[10].substring(date_part-2,date_part+14);
				if(com.ehis.util.DateUtils.validDate(format_date,"DMYHM",localeName))
				{
					 converted_date = com.ehis.util.DateUtils.convertDate(format_date,"DMYHM","en",localeName);
					 allValues[10]=allValues[10].replace(format_date,converted_date);
				} 
			}
			else if((date_part+8)<=allValues[10].length()&&(allValues[10].substring(date_part-2,date_part+8).matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}")))
			{
				format_date=allValues[10].substring(date_part-2,date_part+8);
				if(com.ehis.util.DateUtils.validDate(format_date,"DMY",localeName))
				{
						 converted_date = com.ehis.util.DateUtils.convertDate(format_date,"DMY","en",localeName);
						 allValues[10]=allValues[10].replace(format_date,converted_date);
				} 
			}
		}
		 if ((practitionerDetails.size() == 1) ) //IN036821
			//IN061345 End.
			{
				//IN061345 Start.
				ArrayList repPractList = new ArrayList();
				String textToolTip = "";
				try
				{
					repPractList = (ArrayList) vwBean.getRepPractCnt(orderId,order_line_num,patient_id,resp_id,facility_id,request.getParameter("ord_cat"),order_status,cont_order_ind);
				
					if(repPractList.size() > 0)
					{
						repPract = (String) repPractList.get(0);	
						repPractName = (String) vwBean.getRepPractName(repPract, localeName);

						if(repPractList.size() == 1) 
						{
							repPractName = repPractName;
							textToolTip = "";
						}
						else 
						{
							repPractName = repPractName + " * ";
							textToolTip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.multipleRepPract.label","or_labels");;
						}
					}
				}
				catch(Exception ee)
				{
					System.out.println("Exception in ResultViewOrderTop.jsp -"+ee.toString());
					ee.printStackTrace(System.err);
				}
		// added for IN048449 - End
	%>
	<tr>
		<td  class='label' ><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></td>
		<td class='data'  >  <a class="gridLink" href="javascript:viewOrderFormat('<%=orderId%>')"><%=allValues[10]%></a> </td>
		<td  class='label'  nowrap><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td><!-- IN058811 changed order-->
		<td class='data'> <B><%=allValues[9]%> </B></td><!-- IN058811 changed order-->

		
	</tr>
	<tr>
		<%--<td  class='label' align='right'>Reporting Practitioner</td>
		<td class='label'  colspan=2><B><%//=((String)bean.getPractitioner(orderId, cont_order_ind))%></B></td>
		<td  class='label'> &nbsp;</td>--%>
		<%
		//if(!order_line_num.equals("")){
		%>
		<td class='label' ><fmt:message key="eOR.ReportingPractitioner.label" bundle="${or_labels}"/></td>
		<TD class='data'  title='<%=textToolTip%>'><B><%=repPractName%></B></TD>
		<td  class='label' >
		<% if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0"))
		{ 
		%>
			<a class="gridLink" href="javascript:viewHeaderComments('<%=orderId%>')"><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a>  
		<%
		} 
		else 
		{ 		   
			out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"");
		} 
		%>
		</td>
		<td></td>
		
		<%
		if (practitionerDetails.size() == 3) 
		{
			/*Added by Uma on 12/1/2010 for IN025168*/
			specimenCollectedTime = (String)practitionerDetails.get(1);
			specimenCollectedTime =  com.ehis.util.DateUtils.convertDate(specimenCollectedTime,"DMYHM","en",localeName);
			reportingTime		  = (String)practitionerDetails.get(2);
			reportingTime		 =  com.ehis.util.DateUtils.convertDate(reportingTime,"DMYHM","en",localeName);
			/*Ends Here*/
		%>
			<TD class='data'><B><%= practitionerDetails.get(0)== null ? "" :(String)practitionerDetails.get(0)%></B></TD>
		<!-- IN058811 starts changed order-->

		 <td class="label"></td>
		<!-- IN058811 Ends changed order-->			
			</tr>
			<tr>
			<TD class='label' ><fmt:message key="eOR.ReportingTime.label" bundle="${or_labels}"/></TD>
			<TD class='data'><B><%=reportingTime%></B></TD>
			<TD class='label' ><fmt:message key="eOR.SpecimenCollectedTime.label" bundle="${or_labels}"/></TD><!-- IN058811 changed order-->
			<TD class='data'><B><%=specimenCollectedTime%></B></TD><!-- IN058811 changed order-->
			<!-- <TD>&nbsp;</TD> -->
			
		<%
		}
		// IN061345 Start.
		//else if ((practitionerDetails.size() == 1) || !repPractName.equals("")) //IN036821
		//IN061345 End.			
		%>

		<%
		}
		else if(ca_pract_name!=null && !ca_pract_name.equals("")) 
		{
		%>
			<td  class='label'><fmt:message key="eOR.OrderPlacedBy.label" bundle="${or_labels}"/></td>
			<td class='data' ><b><%=ca_pract_name%></b></td>
				<td  class='label' >
		<% if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0"))
		{ 
		%>
			<a class="gridLink" href="javascript:viewHeaderComments('<%=orderId%>')"><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a>  
		<%
		} 
		else 
		{ 		   
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")); 
		} 
		%>
		</td>
		<%
		}
		else
		{
		%>
			<TD class='label' colspan='2'></TD>
			<td  class='label' >
		<% if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0"))
		{ 
		%>
			<a class="gridLink" href="javascript:viewHeaderComments('<%=orderId%>')"><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a>  
		<%
		} 
		else 
		{ 		   
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")); 
		} 
		%>
		</td>
		<%
		}
		//}
		

		%>
	</tr>
	<!-- IN066453 Starts -->
	<%if(allValues[15].equals("LB")){%>
	
		<tr>
			<TD class='label'><fmt:message key="eOR.SpecimenNo.label" bundle="${or_labels}"/></TD>
			<td class='data'><B><%=(allValues[41]== null)? "" :allValues[41]%></B></td>
			<TD class='label'><fmt:message key="eOR.CategoryNo.label" bundle="${or_labels}"/></TD>
			<td class='data'><B><%=(allValues[42]== null)? "" :allValues[42]%></B></td>
			</tr><tr><!-- 7632 -->
			<TD class='label'><fmt:message key="eOR.SpecimenType.label" bundle="${or_labels}"/></TD>
			<td class='data'><B><%=(allValues[43]== null)? "" :allValues[43]%></B></td>
		</tr>
	<%}%>
	<!-- IN066453 ends -->
	
	<!-- 35142 Starts. -->
	
	<%if (quePki_SiteSpecific && "ORDER_TRACKING".equals(fromFunction) && "RD".equals(allValues[15])) {
	pkiSiteSpecificYN="Y";	
	%>
	<tr>
		<td class=label></td>
		<td class=fields></td>	
		<td class=label><fmt:message key="eOR.QuePkiCode.label" bundle="${or_labels}" /></td>
		<td class=fields><input id='quePkiId' name='quePkiId' id='quePkiId' type=text size="25" value='' onBlur="getQUEPKICode(this)"></td>			
	</tr>
	<tr>
		<td class=label></td>
		<td class=fields></td>	
		<td class=label colspan=2 id="quePkiIdMessage">&nbsp;</td>
					
	</tr>
	<%}%> 
	<input type=hidden id="pkiSiteSpecificYN" name="pkiSiteSpecificYN" id="pkiSiteSpecificYN" value="<%=pkiSiteSpecificYN%>"/>
	<input type=hidden id="quePkiStatus" name="quePkiStatus" id="quePkiStatus" value="E"/>
	<input type=hidden id="quePkiStatusText" name="quePkiStatusText" id="quePkiStatusText" value="User missed entering primary key of queue no"/>	
	<input type=hidden id="quePkiToken" name="quePkiToken" id="quePkiToken" value=""/>
	<input type=hidden id="quePkiNumber" name="quePkiNumber" id="quePkiNumber" value=""/>
	<input type=hidden id="quePkiIsueDateTime" name="quePkiIsueDateTime" id="quePkiIsueDateTime" value=""/>
	<input type=hidden id="quePkiCallDateTime" name="quePkiCallDateTime" id="quePkiCallDateTime" value=""/>	
	
	<input type=hidden id="ordFacilityId" name="ordFacilityId" id="ordFacilityId" value="<%=allValues[13]%>"/>
	<input type=hidden id="patientId" name="patientId" id="patientId" value="<%=allValues[35]%>"/>
	<input type=hidden id="encounterId" name="encounterId" id="encounterId" value="<%=allValues[4]%>"/>
	<input type=hidden id="referenceId" name="referenceId" id="referenceId" value="<%=orderId%>"/>
	<input type=hidden id="userId" name="userId" id="userId" value="<%=userid%>"/>
	<!-- 31792 starts -->
	<input type=hidden id="order_id" name="order_id" id="order_id" value="<%=allValues[32]%>"/>
	<input type=hidden id="order_category" name="order_category" id="order_category" value="<%=allValues[15]%>"/>
	<input type=hidden id="performing_facility_id" name="performing_facility_id" id="performing_facility_id" value="<%=allValues[9]%>"/>
	<input type=hidden id="accession_num" name="accession_num" id="accession_num" value="<%=allValues[41]%>"/>
	<input type=hidden id="patient_id" name="patient_id" id="patient_id" value="<%=allValues[35]%>"/>
	<!-- 31792 ends -->

	<!-- 35142 end. -->
			
</table>
<!--INO30714 <Input name='querystring' id='querystring' type='hidden' value='orderId=<%=request.getParameter("orderId")%>&order_line_num=<%=request.getParameter("order_line_num")%>&cont_order_ind=<%=cont_order_ind%>&patient_id=<%=request.getParameter("patient_id")%>&ord_cat=<%=request.getParameter("ord_cat")%>&practitioner_id=<%=allValues[11]%>&timeHeader=<%=timeHeader%>&order_status=<%=order_status%>&pract_reln_id=<%=request.getParameter("pract_reln_id")%>'>INO30714 -->
<!--IN064215 start-->
<!--<Input name='querystring' id='querystring' type='hidden' value='orderId=<%=request.getParameter("orderId")%>&order_line_num=<%=request.getParameter("order_line_num")%>&cont_order_ind=<%=cont_order_ind%>&patient_id=<%=request.getParameter("patient_id")%>&ord_cat=<%=request.getParameter("ord_cat")%>&practitioner_id=<%=allValues[11]%>&timeHeader=<%=timeHeader%>&order_status=<%=order_status%>&pract_reln_id=<%=request.getParameter("pract_reln_id")%>&encounter_id=<%=allValues[4]%>'>--><!--INO30714 -->

<!--<Input name='querystring' id='querystring' type='hidden' value='orderId=<%=request.getParameter("orderId")%>&order_line_num=<%=request.getParameter("order_line_num")%>&cont_order_ind=<%=cont_order_ind%>&patient_id=<%=request.getParameter("patient_id")%>&ord_cat=<%=request.getParameter("ord_cat")%>&practitioner_id=<%=allValues[11]%>&timeHeader=<%=timeHeader%>&order_status=<%=order_status%>&pract_reln_id=<%=request.getParameter("pract_reln_id")%>&encounter_id=<%=allValues[4]%>&view_by=<%=request.getParameter("view_by")%>'>-->
<!--IN064215 end-->
<Input name='querystring' id='querystring' type='hidden' value='orderId=<%=request.getParameter("orderId")%>&order_line_num=<%=request.getParameter("order_line_num")%>&cont_order_ind=<%=cont_order_ind%>&patient_id=<%=request.getParameter("patient_id")%>&ord_cat=<%=request.getParameter("ord_cat")%>&practitioner_id=<%=allValues[11]%>&timeHeader=<%=timeHeader%>&order_status=<%=order_status%>&pract_reln_id=<%=request.getParameter("pract_reln_id")%>&encounter_id=<%=allValues[4]%>&view_by=<%=request.getParameter("view_by")%>&event_code=<%=request.getParameter("event_code")%>&order_catalog_code=<%=request.getParameter("order_catalog_code")%>'><!-- IN061961 -->
<Input type='hidden' name='orderFormatAuditTrailYN' id='orderFormatAuditTrailYN' value='<%=orderFormatAuditTrailYN%>'> <!--  IN056017 -->
<Script>
if((screen.width==800) && (screen.height==600))
{
		var colsfordetail=querystring.value
		colsfordetail+="&cols=74";
		querystring.value=colsfordetail;
}
else
{
		var colsfordetail=querystring.value
		colsfordetail+="&cols=300";
		querystring.value=colsfordetail;
	
}
	//parent.ViewOrderHeader.location.href = "../../eOR/jsp/ResultViewOrderHeader.jsp";
<%  
	if(image_ref_yn.equals("Y")) 
	{ 
%>
		parent.ViewOrderDtl.location.href = "../../eOR/jsp/MedPntredit.jsp?called_from=RESULT_VIEW&order_id=<%=orderId%>&bean_id=<%=bean_id%>&bean_name<%=bean_name%>";
<%  
	}	
	else 
	{ 
		
	%>  // if image is not there call this one 

		parent.ViewOrderDtl.location.href = "../../eOR/jsp/ResultViewOrderDetail.jsp?"+querystring.value;
	<%	
	} 
	%>
</Script>
</body>
</html>
<% 
	putObjectInBean(bean_id,bean,request);
	//putObjectInBean( view_bean_id, view_bean , request) ;
%>

