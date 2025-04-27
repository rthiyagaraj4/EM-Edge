<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
28/6/2011     101            Chowminya      Incident No: IN027797 - <Mandatory flag issue in the header order format> 
11/08/2011	  IN00747		 Chowminya		Incident No: IN00747 - <Clinical comments mandatory check in Preview  screen>
29/11/2012	  IN031304		Karthi L		To load three tier waiting list screen when RD_OA_INTEGRATION_YN param is Y and order_category is RD(IN035976) 		
11/12/2013  IN045512		Nijithas	    The dependent field option is not displayed in View Order Format
21/04/2019	IN070295		Ramesh G		ML-BRU-SCF-1939
---------------------------------------------------------------------------------------------------------------
*/
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	//String practitioner_type = (String)session.getAttribute("practitioner_type");
	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 			 = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);

	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
	String rd_oa_integration_yn = bean.getOaIntegrationKey(); // added for IN031304
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();

	//orderEntryRecordBean.setLanguageId(localeName);
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	String key						 = (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
   	HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
   	/*	---------Till Here------------- */
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
   	String ammend_called_from		 = bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String order_id = bean.checkForNull(request.getParameter("order_id"),"");
	if(order_id.equals(""))
		order_id=bean.getOrderId();	
	String function_from			 = bean.checkForNull(request.getParameter("function_from"),"");
	//String practitioner_id			 = bean.checkForNull(request.getParameter("practitioner_id"),"");
	//String practitioner_name			 = bean.checkForNull(request.getParameter("practitioner_name"),"");
	//String query_string				 = bean.checkForNull(request.getQueryString(),"");
   	String order_category			 = request.getParameter("order_category");
	//System.out.println("order_category="+order_category);
	String signature_yn				 = "N";	
   	//String signature_yn            = bean.getSignatureYN();
	String auth_reqd = "";
	
   	//String auth_reqd				 = bean.getAccessReqd(order_category,"auth_yn");	// Column Name. auth_yn is passed
   	String cosign_reqd				 = bean.getAccessReqd(order_category,"cosign_yn");	// Column Name. cosign_yn is passed
   	String special_approval_reqd	 = bean.getAccessReqd(order_category,"ord_spl_appr_reqd_yn");	// Column Name. auth_yn is passed
  	//String forceStatus=bean.getForceStatus(practitioner_type,order_category);
	//System.out.println("forceStatus="+forceStatus);
	//String fStatus[]=forceStatus.split(":");
	//if(fStatus[0].equals("Y"))
	//auth_reqd="X";
	//if(fStatus[1].equals("Y"))
	//cosign_reqd="X";

	String vist_admin_date =bean.getVisitAdmDate();
	
	if(vist_admin_date != null && vist_admin_date!="")
	{
	  vist_admin_date= com.ehis.util.DateUtils.convertDate(bean.getVisitAdmDate(),"DMYHM","en",localeName);
	}
	String format_id				 = "", pract_id		  ="";
   	String format_id_mandatory_yn	 = "N";
   	String physician_name			 = "";String readOnly = "READONLY";
   	//String location_type			 = bean.checkForNull(bean.getLocationType(),"");
   	//String location_code			 = bean.checkForNull(bean.getLocationCode(),"");
   	String location_name			 = "";
	/*ArrayList locn_dtls			 = new ArrayList();
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

	}*/
   	String order_types_comb			 = bean.checkForNull(bean.getOrderTypes(previousValues),"");  // Order Types Combination for the order_category
   	String rd_install_yn			 = "N";
	String ot_install_yn			 = "N";
// 	if(order_category.equals("RD"))   //  IN070295 
	   rd_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
//	else if(order_category.equals("OT"))  //IN070295
	   ot_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N"); // check whether the ot_module is installed or not, used in EJB & order formats
   	String nationality_desc			 = "";
   	String patient_name				 = "";
	String clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N"); // For clinical cmts to be mandatory or not.
   	ArrayList Nationality  = new ArrayList();
	//Nationality = bean.getNationality(bean.getPatientId());// Get the Nationality Desc
   	//if(Nationality!=null && Nationality.size() > 0)
   	//{
   	    //nationality_desc = (String)Nationality.get(0);
   	    //patient_name     = (String)Nationality.get(1); // Get the patient_name
   	//}
	String cosign_reqd_yn			 = "N";
  	String[] amendRecords 			 = null;
	String[] records				 = null;
 	int count						 = 0;
   	int order_format_mandatory		 = 0, order_format = 0;
	String display_style="visibility:hidden";
	//String displaying_style="visibility:hidden";
	//String displays_style="visibility:hidden";
	String displays_style1="visibility:hidden";
	String displays_style2="visibility:hidden";
	
	String clin_cmts_value_entered_yn="N";
	StringBuffer comments = new StringBuffer();
	
	//Modified by Ambiga.M on 2/3/2010 for Clinical comments issue.
	if(ammend_called_from.equalsIgnoreCase("existing_order"))
	{		
		if(bean.getAmendClinicalComments().length() > 0 )
		{
			comments = new StringBuffer();
			comments.append(bean.getAmendClinicalComments());		
		}
		else
		{
			comments = new StringBuffer();
			comments.append(bean.getAmendComments(order_id));
		}
	}
	else
	{		
		comments				= (StringBuffer)orderEntryRecordBean.getOrderFormats(order_category+"_CLINICALCOMMENTS",order_category+"_CLINICALCOMMENTS_0");
		
		if(comments==null)
		{		
			comments 				= new StringBuffer();
		}
	}


 %>
<html>
  <head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>

	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
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
		//System.out.println("physician_name=="+physician_name);
		pract_id				 		= (String)bean.getPractitionerId();
		// Query to get the values from the Header already recorded
		
		if(function_from.equals("AMEND_ORDER"))
		{
			readOnly					= "READONLY";
			ArrayList AmendPlaceOrderHeader	= bean.getAmendPlaceOrderHeader(bean.getOrderId());// Only one record will be there for the order_id
			for(int i=0; i<AmendPlaceOrderHeader.size(); i++)
			{
				amendRecords = (String[])AmendPlaceOrderHeader.get(i);
			}
			if(AmendPlaceOrderHeader != null && AmendPlaceOrderHeader.size() == 0)
			{
				//Modified by Uma on 3/12/2010 for IN019169
				amendRecords = new String[11];
				amendRecords[0] = "";
				amendRecords[1] = "";
				amendRecords[2] = "";
				amendRecords[3] = "";
			}
			dateString					= amendRecords[2];
			//Commented by Uma on 3/10/2010 for IN019713
			//physician_name				= amendRecords[3];
			//System.out.println("physician_name==="+physician_name);
			AmendPlaceOrderHeader		= null;
		}//Nullifying the objects
		//System.out.println("dateString===="+dateString);
		// Get the Future Date and the past date
		ArrayList PlaceOrderItems		= bean.getDate(dateString);

		//System.err.println("PlaceOrderItems"+PlaceOrderItems);
		for(int i=0; i<PlaceOrderItems.size(); i++)
		{
			records 			= (String[])PlaceOrderItems.get(i);
			future_order_date	 		= records[0];
			past_order_date 	 		= records[1];
		}
		PlaceOrderItems					= null;  //Nullifying the objects
%>
   	<table cellpadding=3 cellspacing=0 width="100%" align="center">
  		<tr>
  			 <td id="hdg" class="label" colspan='2'>
		
<%			/*if(!order_category.equalsIgnoreCase("CS"))
				{
							
					if(!auth_reqd.equalsIgnoreCase("X") || !cosign_reqd.equalsIgnoreCase("X") || !special_approval_reqd.equalsIgnoreCase("X"))
					{  
						displays_style="visibility:visible";
						displaying_style="visibility:hidden";
					}
					else
					{
						displaying_style="visibility:visible";
						displays_style="visibility:hidden";
						}
				}*/
						%>
						<!-- <label  id="link"  style="display:none"><%out.println("&nbsp;"); %></label> -->
						<label  id=\"links1\"  style="display:none"><%out.println("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PressLinkto.label","or_labels")+"</b>"); %></label>
			</td>
  			<td id="imageId" class="label" ><%if(!order_category.equalsIgnoreCase("CS"))out.println("<img id=\"textimg\" src=\"../../eOR/images/Authorization.gif\" align=\"left\" style=\"display:none\"> ");%></td>
  			<td id="authorizedId" class="label" align="left">
<%
			if(!order_category.equalsIgnoreCase("CS"))
			{
				if(!auth_reqd.equalsIgnoreCase("X")) 
				{
					displays_style1="visibility:visible";
					displays_style2="visibility:hidden";
				}
				else
				{
					displays_style2="visibility:visible";
					displays_style1="visibility:hidden";
				}
			}
			if(!order_category.equalsIgnoreCase("CS"))
			{
			%>			
				<label  id="auths"  style="display"><a class='gridLink' href='javascript:CheckAuthorization("X")' title='Authorize'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></a></label><label  id="auth"  style="display:none">		<%out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+"");%></label>
				<%
			}
			%>
			 </td>
			 <td id="imageCosignId" class="label" align="left"><%if(!order_category.equalsIgnoreCase("CS"))out.println("<img id=\"textcosignimg\" src=\"../../eOR/images/Cosign_click.gif\" align=\"right\"> ");%></td>
  			 <td id="cosignId" class="label" align="left" nowrap>
<%
 			if(!order_category.equalsIgnoreCase("CS"))
 			{
 				if(!cosign_reqd.equalsIgnoreCase("X")) { out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CosignReqd.label","common_labels")+"");
			 } else {
%>					<a class='gridLink' href='javascript:CheckCosign("<%=cosign_reqd%>")' title='Cosign'><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></a>
<% 				}
 			}	%>
 			</td>
 			<td id="imageSpecialId" class="label" align="left"><%if(!order_category.equalsIgnoreCase("CS"))out.println("<img id=\"textspecialimg\" src=\"../../eOR/images/SpecialApproval.gif\" align=\"right\"> ");%></td>
  			<td id="specialId" class="label" align="left">
<%
 			if(!order_category.equalsIgnoreCase("CS"))
 			{
 				if(!special_approval_reqd.equalsIgnoreCase("X")) { out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialApprovalReqd.label","common_labels")+"");
			 } else {
%>					<a class='gridLink' href='javascript:CheckSpecialApproval("<%=special_approval_reqd%>")' title='Special Approval'><fmt:message key="Common.SpecialApproval.label" bundle="${common_labels}"/></a>
<% 				}
 			}	%>

			 </td>
  			 <td class="label" colspan="4">&nbsp;</td>
  		</tr>
  		<tr>
  			<td class="label" style="width: 4%;"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
  			<td  class="fields">
<%			if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
			{
				if(amendRecords[1].equalsIgnoreCase("R")) out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+"");
				else if(amendRecords[1].equalsIgnoreCase("U")) out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels")+"");
				else out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels")+"");
				out.println("<input type=\"hidden\" name=\"priority\" id=\"priority\" value='"+amendRecords[1]+"'>");
			}
			else
			{
%>	 			<select name="priority" id="priority" onChange="setAllPriorities(this)">
  					<option value=R><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
	    			<option value=U><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
	     			<option value=S><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
	    		</select>
<%			} %>
  			</td>
  			<td class="label" >&nbsp;</td>   
			<td  class="label"><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
  			<td  class="fields"><input type="text" name="order_date_time" id="order_date_time" size="16" maxLength="16" value="<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>"  <%=readOnly%>><input type="hidden" name ="order_date_time_calendar" id="order_date_time_calendar" value="<%=com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)%>"><!--<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('order_date_time_calendar',null,'hh:mm');" style='cursor:pointer'> onBlur="changeDateTime(this,'<%=order_category%>')" --></td>
  			<td class="label" >&nbsp;</td>
	<%
		if(bean.getAttendPractitionerName()!=null && (!bean.getAttendPractitionerName().equals("")) && (!bean.getEncounterId().equals("")))
		{
	%>

			<td  class="label"><fmt:message key="eOR.AttendPractitioner.label" bundle="${or_labels}"/></td>
  			<td  class="data"><b><%=bean.getAttendPractitionerName()%></b></td>
  			<td class="label" colspan='2'>&nbsp;</td>
	<%	}	else  { %>
			<td align="right" colspan="4" class="label">&nbsp;</td>
	<%	}	%>
  		</tr>
  		<tr>
  			<td  >
<%
 			if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
 			{
 				count 				= bean.getFormatAmendCount(bean.getOrderId(),"");
 				order_types_comb	= "'"+bean.checkForNull(bean.getAmendOrderType(),"")+"'";
 			}
			if((count<=0 || !bean.getAmendOrder().equalsIgnoreCase("existing_order")) && !order_category.equalsIgnoreCase("CS"))
 			{
				format_id = bean.checkForNull(bean.getFormatIdHdr(order_category,order_types_comb,bean.getSex(), bean.getDob()),"");
				if(!format_id.trim().equals("") )
 				{
 					StringTokenizer stFormat = new StringTokenizer(format_id,"~");
 					while(stFormat.hasMoreTokens())
 					{
 						format_id_mandatory_yn	 	= bean.checkForNull(stFormat.nextToken(),"N");
 						format_id 	 	 			= bean.checkForNull(stFormat.nextToken(),"");
 					}
				}
 			} // End of bean.getAmendOrder()

 			if(!format_id.equals("") || count!=0)
 			{
				//---[101]/start--- commented
				//if(bean.getAmendOrder().equalsIgnoreCase("existing_order") && previousValues!=null && previousValues.size() > 0 )
					//format_id_mandatory_yn = "Y";
				//---[101]/end--- commented	
%>
				<a class='gridLink' href='javascript:orderFormatForHeader("<%=java.net.URLEncoder.encode(format_id)%>","<%=order_category%>","<%=bean.getOrderId()%>","","<%=function_from%>")' title='Order Format'> <!-- additional parameter "function_from" added for ML-MMOH-CRF-0508.1 -->
<%
 			} // End of if format_id
 			if(!format_id.equals("") || count!=0)
 			{
				if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equalsIgnoreCase("Y"))
 				{
 					order_format_mandatory++;
					out.println("<img src='../../eOR/images/Flex_red.gif' align='center'></img></a>");
					out.println("<input type='hidden' name='format_id_yn' id='format_id_yn' value='N'>");
 					ArrayList arrSeqNo = (ArrayList) orderEntryRecordBean.getOrderFormats(order_category, order_category+"_0");
					if(arrSeqNo!=null && arrSeqNo.size()>0 && (!bean.getAmendOrder().equalsIgnoreCase("existing_order")) )
						out.println("<script>setOrderFormat('Y');</script>");
 	     		}else{
					order_format++;
 					out.println("<img src='../../eOR/images/Flex_blue.gif' align='center'></img></a>");
 					out.println("<input type='hidden' name='format_id_yn' id='format_id_yn' value='Y'>");
 				}
 			}
 			else
 				out.println("<input type='hidden' name='format_id_yn' id='format_id_yn' value='Y'>");
			out.println("<input type='hidden' name='format_id_mandatory_yn' id='format_id_mandatory_yn' value='"+format_id_mandatory_yn+"'>");
			out.println("<input type='hidden' name='format_id' id='format_id' value='"+format_id+"'>");

 %>
  			</td>
  			<td class="label" colspan="2">&nbsp;</td>

			<td  class="label"><input type="hidden" name="header_comments" id="header_comments" value="<%=comments%>" >
			
			<%
			if(bean.getAmendOrder().equalsIgnoreCase("existing_order")) 
			{ 
				StringBuffer ammend_comment=bean.getAmendComments((String)bean.getOrderId());
				if(ammend_comment!=null && ammend_comment.length()>0)
				{
					clin_cmts_value_entered_yn="Y";
				}
				%> <!--[101]--passed header_comments in place of obj-->
				<a class='gridLink'  href='javascript:DisplayAmendComments("header_comments","CLINICAL","<%=bean.getOrderId()%>","<%=order_category%>")' title='Clinical Comments'><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a><%if(clin_cmts_reqd_yn.equals("Y")){display_style="visibility:visible";}else{display_style="visibility:hidden";}%><input  id="cl_cmt_mand" name="cl_cmt_mand"  Title="Clinical Comment"  style="<%=display_style%>"></input></td>    
			<% } else { %>
				<a class='gridLink' href='javascript:DisplayClinicalComments("header_comments","CLINICAL","<%=order_category%>")' title='Clinical Comments'> <fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a> <!-- [IN00747]-->
				<%if(clin_cmts_reqd_yn.equals("Y")){display_style="visibility:visible";}else{display_style="visibility:hidden";}%><label  id="cl_cmt_mand" Title="Clinical Comment"  style="<%=display_style%>"><img src="../../eCommon/images/mandatory.gif"></img></label></td>
				<%--<a href="javascript:DisplayComments('header_comments','CLINICAL')" title='Clinical Comments'>Clinical Comments</a></td>--%>
			<% } %>

			<td  class="label" colspan='2'>&nbsp;</td>
			<td  class="label" nowrap><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
			<td class="data"> <b>&nbsp;<%=bean.getPractitionerLocale(pract_id)%></b> </td>
			<td class="label"  colspan='2'>&nbsp;</td>
		</tr>
				<%//System.out.println("=pract_id="+pract_id);%>
				<%//System.out.println("=ca_practitioner_id="+(String)session.getValue("ca_practitioner_id"));%>
<%	if(!pract_id.equals((String)session.getValue("ca_practitioner_id"))) {  
		cosign_reqd_yn = "Y";
%>
		<tr>
			 <td class="label" colspan="6">&nbsp;</td>
			 <td class="label" ><fmt:message key="eOR.OrderingBy.label" bundle="${or_labels}"/></td>
			 <td class="DATA" align="left"><%=bean.getPractitionerLocale((String)session.getValue("ca_practitioner_id"))%></td>
			 <td class="label" colspan="2">&nbsp;</td>
		 </tr>
<%	} %>
	</table>
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
		<input type="hidden" name="commentsclinic" id="commentsclinic" value="<%=comments%>">
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
		<input type="hidden" name="signature_yn" id="signature_yn" value="<%=signature_yn%>">
		<input type="hidden" name="clin_cmts_reqd_yn" id="clin_cmts_reqd_yn" value="<%=clin_cmts_reqd_yn%>">
		<input type="hidden" name="clin_cmts_value_entered_yn" id="clin_cmts_value_entered_yn" value="<%=clin_cmts_value_entered_yn%>">
		<input type="hidden" name="amend_order_id" id="amend_order_id" value="<%=bean.getOrderId()%>"> <!-- Used in OrderEntry.js to open the Modal Dialog if mandatory-->
		<input type="hidden" name="cosign_reqd_yn" id="cosign_reqd_yn" value="<%=cosign_reqd_yn%>"> <!-- Used in to set the Cosign_reqd_yn = 'Y' When nurse is logging in -->
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="order_format" id="order_format" value="<%=order_format%>">

		<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=vist_admin_date%>">
		<input type="hidden" name="rd_oa_integration_yn" id="rd_oa_integration_yn" value="<%=rd_oa_integration_yn%>"> <!-- IN031304 -->
		<!--<input type="hidden" name="order_format_onload" id="order_format_onload" value="Y"> IN045512 -->
	<% } 
			// Nullifying the Objects
			//previousValues	= null;	// Nullifying the Objects
			//Nationality		= null;	amendRecords	= null; records = null;

			// no need to set it back persistence
			//putObjectInBean(bean_id,bean,request);
	%>
	<script>parent.legendsFrame.location.href="OrderEntryLegends.jsp?<%=request.getQueryString()%>&order_format_mandatory=<%=order_format_mandatory%>&order_format=<%=order_format%>"</script>
  </form>
  </body>
 </html>

