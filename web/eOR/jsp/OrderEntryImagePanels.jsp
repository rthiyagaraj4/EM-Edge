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
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------
17/07/2018	IN064543		Kamalakannan		 17/07/2018		Ramesh G		ML-MMOH-CRF-0776	
-------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*,java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%  
try
{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter("bean_id");
	String bean_name 		= request.getParameter("bean_name");
	/* Mandatory checks end */

	/* Initialize Function specific start */
		//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		OrderEntryBean bean	  = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
                   bean.setLanguageId(localeName);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	String order_type_code 	= bean.checkForNull(request.getParameter("order_type_code"),"");
	String order_category 	= bean.checkForNull(request.getParameter("order_category"),"");
	String activity_type 	= bean.checkForNull(request.getParameter("activity_type"),"");
	String hotspot_id 		= bean.checkForNull(request.getParameter("hotspot_id"),"");
	String image_id 		= bean.checkForNull(request.getParameter("image_id"),"");
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	String priv_applicability_yn 		= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
	String prev_group_title	= "";
	String checkedAttribute = "";
	String disabled			= "";
	String key				= (bean.getPatientId()+bean.getEncounterId());
	if(!order_type_code.equals(""))	order_type_code = order_type_code.trim();
	if(!order_category.equals(""))	order_category 	= order_category.trim();
	if(!hotspot_id.equals(""))		hotspot_id 		= hotspot_id.trim();
	if(!image_id.equals(""))		image_id 		= image_id.trim();
	if(!activity_type.equals(""))	activity_type 	= activity_type.trim();
	if(!priv_applicability_yn.equals(""))	priv_applicability_yn 	= priv_applicability_yn.trim();
		
	int i							= 0,count = 0; // counters for loop
	String amend_key				= "";
	HashMap previousValues			= null;
	HashMap amendPreviousValues		= null;
	//ArrayList Panels 				= null;
	StringTokenizer stBillMsg		= null;
	String measure_id				= "" , contr_msr_panel_id = "";
	String category					= "";
	String[] records				= null;
	String entryValue				= "";
	String group_title="";
	Set setValues 					= null;
	Iterator iterator				= null;
%>

<html>
<head><title><fmt:message key="eOR.OrderEntryImagePanels.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name ="imagePanelsForm" id ="imagePanelsForm">
<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr>
<%
		// Since at the maximum there will be 100 or 150 records no need for next/previous
		ArrayList ImagePanels = bean.getImagePanels(order_type_code,order_category,image_id,hotspot_id,activity_type,priv_applicability_yn);
		for(i=0; i<ImagePanels.size(); i++)
		{
			checkedAttribute = "";disabled= "";
			records = (String[])ImagePanels.get(i);
			if(records[13].equalsIgnoreCase("P"))
			{	
					group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Panel.label","common_labels");
			}else if(records[13].equalsIgnoreCase("S"))
			{
				group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSet.label","or_labels");
			}
			else if(records[13].equalsIgnoreCase("A"))
			{
					group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Individual.label","common_labels");
			}
			if(!prev_group_title.equals(records[13]))
			{
				if( count%2 > 0)
				{
					 for (int u=0;u<2-count%2;u++)
						out.println("<td width=\"20%\"  colspan=\"3\"  align=\"left\">&nbsp;&nbsp;</td>");
						out.println("</tr>");
				}
				count =0 ;
				out.println("<tr>");
				out.println("<td colspan=\"6\" align=\"center\" class=\"CAGROUP\">"+group_title+" </td>");
				out.println("</tr><tr>");
			}
			// records[14]  -- > ordr_catalog_nature
			if(records[13].equals("P") || records[13].equals("S"))
			{
				contr_msr_panel_id 	= records[10];
				category     		= records[2];
				if(records[13].equals("P")) // Pass the discrete_measure_id & contr_msr_panel_id
				{
					measure_id = records[8]; // discrete_measure_id
				}
				else if(records[13].equals("S")) // Pass the catalog_code
				{
					measure_id = records[0]; // Catalog Code 
				}
			} // End of If
			
			if(!records[13].equals("") && (records[13].equalsIgnoreCase("P")) || records[13].equalsIgnoreCase("S"))
			{
%>				<td class="LABEL"  width="20%" onClick='parent.parent.parent.displayToolTip(escape("<%=measure_id%>"),escape("<%=contr_msr_panel_id%>"),"<%=records[13]%>","<%=category%>","<%=bean_id%>","<%=bean_name%>","<%=(String)records[0]%>","<%=i%>","imagePanelsForm")' onMouseOver='showToolTip("<%=(String)records[0]%>","imagePanelsForm")' onMouseOut="hideToolTip()"> <font size=1 color="BLUE">
<%			}
			else
			{
%>			    <td class="LABEL"  width="20%" onMouseOver='showToolTip("<%=(String)records[0]%>","imagePanelsForm")' onMouseOut="hideToolTip()"><font size=1>
<%			}  %>
				
				   <%=(String)records[1]%>
				   <input type="hidden" name="catalog_desc<%=(String)records[0]%><%=i%>" id="catalog_desc<%=(String)records[0]%><%=i%>" value="<%=(String)records[1]%>">	
				</font></td>
<%
				 previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
				if(previousValues!=null)
				{
		   			setValues 		= previousValues.keySet();
		   			iterator 		= setValues.iterator();
		   			for(int prev_count=0;prev_count<previousValues.size();prev_count++)
		   			{
						entryValue = ((String)iterator.next()) ;
						if(entryValue.equalsIgnoreCase("ck"+(String)records[0]))
						{
							checkedAttribute = "CHECKED";
							break;
						}
						else
						   checkedAttribute = "";
					}
				}
				// From Query --> Depending upon the privilege to enable/disable the checkbox
				/*Added by Uma on 8/24/2009 for PMG20089 -CRF 641*/
				if( ((String)records[14])!=null && (((String)records[14]).equals("Y")) ) 
					disabled		 = "";
				else 
					disabled		 = "DISABLED";
				/*End Here*/
			// For Amend of Review Order
				if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
				{
					amend_key			= (bean.getPatientId()+bean.getEncounterId()+bean.getOrderId());  // Unique key (For Existing Orders) to keep the Value in the Bean
					amendPreviousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
					if(amendPreviousValues!=null)
					{
						setValues 		 = amendPreviousValues.keySet();
						iterator 		= setValues.iterator();
						for(int prev_count=0;prev_count<amendPreviousValues.size();prev_count++)
						{
							entryValue = ((String)iterator.next()) ;
							if(entryValue.equalsIgnoreCase("ck"+(String)records[0]))
							{
								checkedAttribute = "CHECKED";
								disabled		 = "DISABLED";
								break;
							}
						}
					}
				} 
				
 %>
				<td class="LABEL"  width="5%" >
					<%-- <input type="checkbox" name="ck<%=(String)records[0]%>" id="ck<%=(String)records[0]%>" value="Y" onClick='parent.parent.parent.setCheckBoxVal(this,escape("<%=(String)records[11]%>"),escape("<%=(String)records[0]%>"),"imagePanelsForm","");' <%=checkedAttribute%><%=disabled%> ><!--<%=disabled%> removed--> --%>
					<!-- IN064543 Start -->	
							<input type="checkbox" name="ck<%=(String)records[0]%>" id="ck<%=(String)records[0]%>" value="Y" onClick='parent.parent.parent.setCheckBoxVal(this,escape("<%=(String)records[11]%>"),escape("<%=(String)records[0]%>"),"imagePanelsForm");<%
							if(((String)records[13]).equalsIgnoreCase("A")&& ((String)records[16]).equals("Y"))
							{
							%>parent.parent.parent.showEditor(this,"<%=(String)records[0]%>","<%=(String)records[13]%>","<%=(String)records[2]%>","<%=bean_id%>","<%=bean_name%>","<%=records[0]%>","<%=(String)records[17]%>","<%=(String)records[1]%>");<%
							}%>' <%=checkedAttribute%> <%=disabled%> > 
					<!--IN064543 End-->		
					<input type="hidden" name="h1<%=(String)records[0]%>" id="h1<%=(String)records[0]%>" value="<%=(String)records[2]%>">
					<input type="hidden" name="h2<%=(String)records[0]%>" id="h2<%=(String)records[0]%>" value="<%=(String)records[3]%>">

					<input type="hidden" name="prompt_desc<%=(String)records[0]%>" id="prompt_desc<%=(String)records[0]%>" value="<%=bean.checkForNull((String)records[12],"")%>"> <%-- Display the Message, kept with the catalog_code--%>
					<input type="hidden" name="explanatory_text<%=(String)records[0]%>" id="explanatory_text<%=(String)records[0]%>" value="<%=bean.checkForNull((String)records[15],"")%>"> <%-- explanatory_text--%>
				</td>
				<td class="LABEL"  width="3%" nowrap>
<%				if(((String)records[4]).equalsIgnoreCase("Y")) // For Authorization Required
				{
%>					<img id='authorization"+i+"' src="../../eOR/images/Authorization.gif" align="center"></img>
<%				}	%>
<% 				if(((String)records[6]).equalsIgnoreCase("Y")) // For Special Approval Required
				{
%>					<img id='special_approval"+i+"' src="../../eOR/images/SpecialApproval.gif" align="center"></img>
<%				}	%>
				</td>
<%			count++;
			if( count%2 == 0)
				  out.println("</tr><tr>");
			prev_group_title = records[13];
		} // End of for
		if( count%2 > 0)
		{
			for (int u=0;u<2-count%2;u++)
		 		out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
			 	out.println("</tr>");
		}

		if(ImagePanels!=null && ImagePanels.size()==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script> ");
		}
		
		// Nullifying the objects
		previousValues		= null;		amendPreviousValues = null;
		ImagePanels			= null;		//Nullifying the objects
		setValues 			= null;		iterator			= null;
		stBillMsg			= null;		records				= null;

%>
	</table>
	<input type="hidden" name="bean_id" id="bean_id" 			value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" 			value="<%=bean_name%>">
	<input type="hidden" name="order_category" id="order_category" 		value="<%=order_category%>">

	<input type="hidden" name="check_box_val" id="check_box_val" 	value="N">

	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=bean.getEncounterId()%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=bean.getPatientClass()%>">
	<input type="hidden" name="admission_date" id="admission_date" value="<%=bean.getVisitAdmDate()%>">
	<input type="hidden" name="discharge_date_time" id="discharge_date_time" value="<%=bean.getDischargeDateTime()%>">
	<input type="hidden" name="priv_applicability_yn" id="priv_applicability_yn" value="<%=priv_applicability_yn%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">

 </form>
 	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
 		<table id="tooltiptable" cellpadding=3 cellspacing=0 border="0"  width="100%" height="100%" align="center">
 		   	<tr>
 		 		<td width="100%" id="t"></td>
 			</tr>
 		</table>
	</div>
</body>
</html>
<%
	// set it back persistence
	//putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e)
	{e.printStackTrace();}
%>

