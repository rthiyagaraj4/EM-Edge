<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
---------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
---------------------------------------------------------------------------------------------------------
?             100            ?           created

11/08/2011	  IN00747		 Chowminya		Incident No: IN00747 - <Clinical comments mandatory check in Preview  screen>
29/11/2012	  IN031304		Karthi L		To load three tier waiting list screen when RD_OA_INTEGRATION_YN param is Y and order_category is RD(IN035976) 
04/06/2013	  IN039587		Nijitha S	 Alpha-ADHOC-OR-System displays 'null' in External orders- Amend - Preview window. 
28/08/2013    IN030284		Chowminya		java.lang.IllegalArgumentException: Invalid format
15/11/2013	  IN044216		Vijayakumar K	Alpha-CA-Facilty name displayed with special characters at Order Entry preview page.

-------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------

09/05/2016	  IN058811		Raja S			10/05/2016		Ramesh G		MO-CRF-20107 :National ID to be captured in any orderable 
																				(ALL Order Categories) is a national requirement.
06/07/2018	  IN067246		Raja S			06/07/2018		Ramesh G		GHL-CRF-0516
11/02/2019	IN069657	Dinesh  T	11/02/2019	Ramesh G	IN069657	
---------------------------------------------------------------------------------------------------
-->
<html>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%!
/*Added by Uma on 5/4/2010 for IN021062*/
private String decodeLocal(String field,String objVal,PageContext pageContext)
{
	String returntext="";
	if(objVal.trim().equalsIgnoreCase(""))
	{
		return	"";
	}
	if(field.equalsIgnoreCase("sex"))
	{
		if(objVal.equalsIgnoreCase("M"))
		{			
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");	
		}
		else if(objVal.equalsIgnoreCase("F"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}
		//IN039587 Starts
		else if(objVal.equalsIgnoreCase("U"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		//IN039587 Ends
	}
	else
	{
		return "";
	}
	if((returntext.length()>0)&&(returntext!=null))
		return returntext;
	else
		return "";
}
/*Ends Here by Uma on 5/4/2010 for IN021062*/
%>
<%
			 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	int care_set_count=0;
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 			 = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);

	OrderEntryBean bean				 = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String rd_oa_integration_yn = bean.getOaIntegrationKey(); // added for IN031304
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();

	Properties properties			= (Properties) session.getValue( "jdbc" ); 
	String key						 = (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
	HashMap 	previousValues			 = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	
	String ammend_called_from		 = "";
	String function_from			 = bean.checkForNull(request.getParameter("function_from"),"");
 	String physician_name			 = "";// pract_id = "";
//	String sys_date					 = "";
	String cosign_reqd_yn			 = "N";
	String visitdate="";
	String vformat="";
	String pract_id				 	= bean.getPractitionerId();
	ArrayList locn_dtls=new ArrayList();
	if(!pract_id.equals((String)session.getValue("ca_practitioner_id")))   
		cosign_reqd_yn = "Y";
	String display_style="visibility:hidden";
	bean.setSiteSpecificYN("ORSET_IND_FOR_OPREG");//IN067246
	boolean orset_ind_flag = bean.isSiteSpecific("ORSET_IND_FOR_OPREG");//IN067246
	String called_from =bean.checkForNull(request.getParameter("called_from"),"");//IN067246
%>
  <head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryRapidPreview.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
   <body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
   <form name="placeOrderHeaderForm" id="placeOrderHeaderForm">
 <%
 	if(function_from.equals("AMEND_ORDER")  || function_from.equals("COPY_ORDER")  || (previousValues!=null && previousValues.size()>0))
   	{
   		//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
		//java.util.Date date_time	 	= new java.util.Date();
		//String dateString 			= dtSystemFormat.format(date_time);
		String dateString				= bean.getSysDate();
		String future_order_date	 	= "", past_order_date = "";
		physician_name				 	= bean.getPractitionerName();
		//	pract_id				 		= bean.getPractitionerId();
		// Query to get the values from the Header already recorded
		//String[] amendRecords 			= null;
		// Get the Future Date and the past date
		ArrayList PlaceOrderItems		= bean.getDate(dateString);
		for(int i=0; i<PlaceOrderItems.size(); i++)
		{
			String[] records 			= (String[])PlaceOrderItems.get(i);
			future_order_date	 		= records[0];
			past_order_date 	 		= records[1];
			records						= null; // Nullifying the objects
		}
		String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
		String auth_reqd				 = "";
		String location_type			 = bean.checkForNull(bean.getLocationType(),"");
		String location_code			 = bean.checkForNull(bean.getLocationCode(),"");
		String location_name="";
		locn_dtls			 = bean.getLocationName(location_type,location_code);
		if(locn_dtls.size()>0)
		{
			for(int dtls=0;dtls<locn_dtls.size();dtls++)
			{
				String location=(String)locn_dtls.get(dtls);
				dtls++;
				String source_type       =(String)locn_dtls.get(dtls);
				if(source_type.equalsIgnoreCase("C"))
				{								
					source_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
				}
				else if(source_type.equalsIgnoreCase("N"))
				{
					source_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
				}else if(source_type.equalsIgnoreCase("R"))
				{
					source_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
				}
				else if(source_type.equalsIgnoreCase("D"))
				{
					source_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
				}
				location_name=source_type+" / "+location;
			}

	}
 //  	String order_types_comb			 = bean.checkForNull(bean.getOrderTypes(previousValues),"");  // Order Types Combination for the order_category
   	String rd_install_yn			 = "N";
	String ot_install_yn			 = "N";
   	//if(order_category.equals("RD"))
	 rd_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
	//else if(order_category.equals("OT"))
	 ot_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N"); // check whether the ot_module is installed or not, used in EJB & order formats
   	String nationality_desc			 = "";
   	String patient_name				 = "";
	String national_id				 = ""; //IN058811
	String sex						 = (String)bean.getSex();
	sex = (String)decodeLocal("sex",sex,pageContext);
	ArrayList Nationality			 = bean.getNationality(bean.getPatientId());// Get the Nationality Desc
   	if(Nationality!=null && Nationality.size() > 0)
   	{
   	    nationality_desc = (String)Nationality.get(0);
   	    patient_name     = (String)Nationality.get(1); // Get the patient_name
		national_id		 = (String)Nationality.get(2); //IN058811
   	}
 //  	int count						 = 0;
 //  	int order_format_mandatory		 = 0;// order_format = 0;
	String clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N");

%>
	<table width="100%" border="0" cellspacing="0" cellpadding="3" align=center height="auto">
	<tr>
	<!-- IN044216 starts -->
		<!--<td class="BODYCOLORFILLED"   colspan=5 width="auto"><font size="1"><b>&nbsp;&nbsp;<%=bean.getFacilityName()%></b></font></td>-->
		<td class="BODYCOLORFILLED"   colspan=5 width="auto"><font size="1"><b>&nbsp;&nbsp;<%=java.net.URLDecoder.decode(bean.getFacilityName(),"UTF-8")%></b></font></td>
	<!-- IN044216 ends -->	
		<td  class="BODYCOLORFILLED"  width='auto'><font size="1"><b><%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%></b></font></td>
	</tr>
	<table CLASS="BOX" width='100%' border='0' cellspacing='0' cellpadding='3' align=center height='auto'>
		<tr>
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.OrderNo.label" bundle="${common_labels}"/></font></b>
			</td>
			<td class="BODYCOLORFILLED"  width="auto"><font size="1"><fmt:message key="eOR.Tobegenerated.label" bundle="${or_labels}"/></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></b></font>
			</td>
			<input type="hidden" name="order_date_time" id="order_date_time"  value="<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>">
			<td class="BODYCOLORFILLED"  width="auto" id="order_date_time_href_id">:&nbsp;<font size="1"><%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%></font><input type="hidden" name ="order_date_time_calendar"  id="order_date_time_id" value="<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>"></td>
			<!--id="order_date_time_id"<a href="#" onClick="javascript:return changeHeaderDateTime('order_date_time_id')" title="OrderDateTime"></a>-->
			</td>
		</tr>
		<tr>
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b></font>
			</td>
			<td class="BODYCOLORFILLED"  	width="auto"><font size="1"><%=physician_name%></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/></b></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto" id="priority_id"><font size="1"><%if(!function_from.equals("MO")) { %><fmt:message key="Common.routine.label" bundle="${common_labels}"/><%} else {%><fmt:message key="Common.urgent.label" bundle="${common_labels}"/><%}%><a class="gridLink" href="javascript:changePriority('R')" title="Routine"><fmt:message key="eOR.R.label" bundle="${or_labels}"/></a><a href="javascript:changePriority('U')" title="Urgent"><fmt:message key="eOR.U.label" bundle="${or_labels}"/></a><a href="javascript:changePriority('S')" title="Stat"><fmt:message key="eOR.S.label" bundle="${or_labels}"/></a></font></td>
		</tr>
		<tr>
			<td  class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.patient.label" bundle="${common_labels}"/></b></font>
			</td>
			<!--<td  colspan=3 class="BODYCOLORFILLED"  width="auto"><font size="1"><%=patient_name%>,<%=bean.getPatientId()%>,<%=bean.getAge()%>,<%=sex%></font>
			</td>	-->	  <!--commented for IN058811 -->
			<!--IN058811 starts-->
			<td   class="BODYCOLORFILLED"  width="auto"><font size="1"><%=patient_name%>,<%=bean.getPatientId()%>,<%=bean.getAge()%>,<%=sex%></font>
			</td>  
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="eOR.NationalId.label" bundle="${or_labels}"/></b></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto"><font size="1"><%=national_id%></font>
			</td>
			<!--IN058811 Ends-->
		</tr>
		<tr>
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></b></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto"><font size="1"><%=com.ehis.util.DateUtils.convertDate(bean.getDob(),"DMY","en",localeName)%></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></b></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto"><font size="1"><%=nationality_desc%></font>
			</td>
		</tr>
		<tr>
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></b></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto"><font size="1"><%=bean.getEncounterId()%></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto" nowrap><font size="1"><b><fmt:message key="Common.OrderLocation.label" bundle="${common_labels}"/></b></font>
			</td>
			<td class="BODYCOLORFILLED"  width="auto"><font size="1"><%=location_name%></font>
			</td>
		</tr>
		<tr>
			<td  class="BODYCOLORFILLED"  width="auto" valign=top nowrap><font size="1"><b><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></b></font>
			</td>
			<td  colspan=3 class="BODYCOLORFILLED"  width="auto"><font size="1"><input type="hidden" name="header_comments" id="header_comments" value="" >	<a class="gridLink"  href='javascript:DisplayClinicalComments("header_comments","CLINICAL","<%=order_category%>")' title='Clinical Comments'><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a></font> <!-- Modified [IN00747] -->
			<%
			if(clin_cmts_reqd_yn.equalsIgnoreCase("Y"))
			{
				display_style="visibility:visible";
			}
			else
			{
				display_style="visibility:hidden";
			}
			%>
			<label  id="cl_cmt_mand" Title="Clinical Comment"  style="<%=display_style%>"><img src="../../eCommon/images/mandatory.gif"></img></label></td>
		</tr>
		</table>
		<%
			Set setValues			= null;
			Iterator iterator 		= null;
			String entryValue   	= null;
			String keyItems[]		= null;
			if(previousValues!=null)		// Get the Previous Values from the Bean
			{
					setValues 			= previousValues.keySet();
					iterator 				= setValues.iterator();
					String chk_value="";
					for(int z=0;z<previousValues.size();z++)
					{
						entryValue 	 = ((String)iterator.next()) ;
						chk_value= (String)previousValues.get(entryValue);
						keyItems	 = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
						if( keyItems[0].equals("h1"))     // If it is a hidden (h1--denotes order_category)
						{
							order_category = (String)previousValues.get("h1"+keyItems[1]) ;
							if(order_category.equals("CS"))
							{
								care_set_count++;
							}
						}
					}
			}
			//IN067246 starts
			if(care_set_count==1)
				order_category="CS";
			if(!(orset_ind_flag && "OP_VISIT_REG".equals(called_from))){
			//IN067246 ends
			if(care_set_count>0&&previousValues.size()>3)
			{
				out.println("<script>alert(getMessage('CANNOT_PLACE_ORDER','OR'));window.close()</script>");
			}
   			}
%>
		<input type="hidden" name="authorized" id="authorized" value="false">
		<input type="hidden" name="cosigned" id="cosigned" value="false">
		<input type="hidden" name="special_approved" id="special_approved" value="false">

		<input type="hidden" name="future_order_date" id="future_order_date" value="<%=com.ehis.util.DateUtils.convertDate(future_order_date,"DMYHM","en",localeName)%>"> 
		<input type="hidden" name="past_order_date" id="past_order_date" value="<%=com.ehis.util.DateUtils.convertDate(past_order_date,"DMYHM","en",localeName)%>">
		<input type="hidden" name="facility_name" id="facility_name" value="<%=bean.getFacilityName()%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=bean.getPatientId()%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=bean.getEncounterId()%>">
		<input type="hidden" name="physician_name" id="physician_name" value="<%=physician_name%>">
		<input type="hidden" name="sys_date" id="sys_date" value="<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>">

		<input type="hidden" name="sex" id="sex" value="<%=bean.getSex()%>">
		<input type="hidden" name="age" id="age" value="<%=bean.getAge()%>">
		<input type="hidden" name="dob" id="dob" value="<%=bean.getDob()%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
		<input type="hidden" name="ammend_called_from" id="ammend_called_from" value="<%=ammend_called_from%>">
		<input type="hidden" name="patient_class" id="patient_class" value="<%=bean.getPatientClass()%>">
		<input type="hidden" name="location_type" id="location_type" value="<%=bean.getLocationType()%>">
		<input type="hidden" name="location_code" id="location_code" value="<%=bean.getLocationCode()%>">
		<input type="hidden" name="nationality" id="nationality" value="<%=nationality_desc%>">
		<input type="hidden" name="patient_name" id="patient_name" value="<%=patient_name%>">
		<input type="hidden" name="location_name" id="location_name" value="<%=location_name%>">
		<input type="hidden" name="auth_reqd" id="auth_reqd" value="<%=auth_reqd%>">
		<input type="hidden" name="rd_install_yn" id="rd_install_yn" value="<%=rd_install_yn%>">
		<input type="hidden" name="ot_install_yn" id="ot_install_yn" value="<%=ot_install_yn%>">
		<input type="hidden" name="amend_order_id" id="amend_order_id" value="<%=bean.getOrderId()%>"> <!-- Used in OrderEntry.js to open the Modal Dialog if mandatory-->
		<input type="hidden" name="cosign_reqd_yn" id="cosign_reqd_yn" value="<%=cosign_reqd_yn%>"> <!-- Used in to set the Cosign_reqd_yn = 'Y' When nurse is logging in -->
		<%
			visitdate=bean.getVisitAdmDate();
		if(visitdate.length()>11)
		{
			vformat="DMYHMS";
		}else
		{
			vformat="DMY";
		}

		%>
		<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=com.ehis.util.DateUtils.convertDate(bean.getVisitAdmDate(),vformat,"en",localeName)%>">
		<input type="hidden" name="priority" id="priority" value="R"><!--Routine by Default -->
		<input type="hidden" name="format_id_mandatory_yn" id="format_id_mandatory_yn" value="N">
		<input type="hidden" name="format_id" id="format_id" value="N">
		<input type="hidden" name="clin_cmts_reqd_yn" id="clin_cmts_reqd_yn" value="<%=clin_cmts_reqd_yn%>">
		<input type="hidden" name="clin_cmts_value_entered_yn" id="clin_cmts_value_entered_yn" value="N">
		<input type="hidden" name="clin_category_comments" id="clin_category_comments" value="N">	
		<input type="hidden" name="localeName" id="localeName" value='<%=localeName%>'>
		<input type="hidden" name="function_from" id="function_from" value='<%=function_from%>'>
		<input type="hidden" name="commentsclinic" id="commentsclinic" value="">
		<input type="hidden" name="rd_oa_integration_yn" id="rd_oa_integration_yn" value="<%=rd_oa_integration_yn%>"> <!-- IN031304 -->
		<input type="hidden" name="care_set_count" id="care_set_count" value="<%=care_set_count%>"> <!-- IN067246 -->
		<input type="hidden" name="total_size" id="total_size" value="<%=previousValues.size()%>"> <!-- IN067246 -->
		<input type="hidden" name="orset_ind_flag" id="orset_ind_flag" value="<%=orset_ind_flag%>"><!--IN067246-->

<%
		PlaceOrderItems	= null; // Nullifying the objects
		Nationality		= null;
		
	 } %>
	</form>		
	</body>

	<script>
		//IN069657, starts
		//parent.criteriaDetailFrame.location.href="OrderEntryRapidPreviewRecordButtons.jsp?<%=request.getQueryString()%>";
		var l_hidden_refresh;
		
		if(document.placeOrderHeaderForm.order_category)
		{
			var p_order_category=document.placeOrderHeaderForm.order_category.value;
			l_hidden_refresh = (p_order_category!=null && p_order_category=="CS")?"Y":"N";
		}
		
		parent.criteriaDetailFrame.location.href="OrderEntryRapidPreviewRecordButtons.jsp?<%=request.getQueryString()%>"+"&hideRefresh="+l_hidden_refresh;
		//IN069657, ends
		//if(document.placeOrderHeaderForm.function_from.value=="EXTERNAL_ORDER" &&(document.placeOrderHeaderForm.order_category.value=="CS"))
		if(document.placeOrderHeaderForm.order_category)
		{
			var p_order_category=document.placeOrderHeaderForm.order_category.value;
			var care_set_count=document.placeOrderHeaderForm.care_set_count.value;//IN067246
			var total_size=document.placeOrderHeaderForm.total_size.value;//IN067246
			if(p_order_category!=null)
			{
				if(p_order_category=="CS")
				{
					//IN067246 starts
					if("<%=orset_ind_flag%>"=="true" && "<%=called_from%>"=="OP_VISIT_REG"){
						parent.orderTabsFrame.location.href="OrderEntryPlaceOrderTabs.jsp?<%=request.getQueryString()%>&passed_from=Rapid Preview&p_order_category="+p_order_category+"&total_size="+total_size;
					}
					//IN067246 ends
					parent.placeOrderDetailFrame.location.href="OrderEntryPlaceOrderCareSetResults.jsp?<%=request.getQueryString()%>&passed_from=Rapid Preview&p_order_category="+p_order_category;
				}
				else
				{
					//IN067246 starts
					if("<%=orset_ind_flag%>"=="true" && "<%=called_from%>"=="OP_VISIT_REG"){
						parent.orderTabsFrame.location.href="OrderEntryPlaceOrderTabs.jsp?<%=request.getQueryString()%>&p_order_category="+p_order_category+"&total_size="+total_size;
					}
					//IN067246 ends
					parent.placeOrderDetailFrame.location.href="OrderEntryRapidPreviewPlaceOrderResult.jsp?<%=request.getQueryString()%>&total_size="+total_size
				}
			}
		}
		else
		{
			//IN067246 starts
			if("<%=orset_ind_flag%>"=="true" && "<%=called_from%>"=="OP_VISIT_REG"){
				window.close();
			}else{
			//IN067246 ends
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));
			window.close();
			}
		}
	</script>
 </html>

 <%
	// no need to set it back persistence
	//putObjectInBean(bean_id,bean,request);

 %>

