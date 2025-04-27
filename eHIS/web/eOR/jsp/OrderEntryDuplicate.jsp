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
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
?             100            ?           	?				?				created
17/02/2014	  IN024984		Karthi		21/02/2014		Ramesh				Conditional reordering by clinician
10/03/2014	  IN024984		Chowminya	 									Duplicate order recording with reason - new mandatory option	
13/03/2014	  IN047632		Karthi											System popup Duplicate check window with Override Reason Text box for Reject Duplicate check Action 
13/03/2014	  IN047605		Karthi											Alignment format of Duplicate Override reason text is differed
14/03/2014	  IN047686		Karthi											While placing Duplicate Orders for Multiple patients through 'Multi Patient Order' getting Script error.
21/03/2014	  IN047686		Karthi											While placing Duplicate Orders for Multiple patients through 'Multi Patient Order', System not asking to capture the duplicate Override Reason.
03/07/2017    IN062607		Raja S		03/07/2017		Ramesh G			ML-MMOH-CRF-0727
12/07/2017	  IN064747		Raja S		12/07/2017		Ramesh G				ML-MMOH-CRF-0727-US 001-User Entered first duplicate popup screen comments are displayed with %% symbols in Second duplicate popup screen
09/10/2017	  IN063973		Raja S		10/10/2017		Ramesh G			SS-CRF-0058	
------------------------------------------------------------------------------------------
*/ 
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String dupl_message				= "";  // For Lab is installed and panel dupl check
	String susp_message				= "";  // For Lab is installed and catalog is suspended
//	String ord_dupl_message			= "";
	String rd_appt = "";
	String called_from_multi				= "";
	String dup_catalogs			= "";
	String patient_id				= "";
	String dupl_patient_id		= "";
	//String rejectOrder				= "";
	String patRejectOrder		= "";

	ArrayList RejectOrders=new ArrayList();
	ArrayList DuplicateCatalogCodes=new ArrayList();	
	ArrayList dupl_ord_catalogs = new ArrayList();
	ArrayList multi_patient = new ArrayList();
			
	/* Initialize Function specific start */
	OrderEntryBean bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */

	HashMap hashValues				= bean.getAllValues();
	HashMap NewOrderMap		=new HashMap();
	HashMap DuplicateOrderMap		=new HashMap();
	HashMap duplOrdCatalogs = new HashMap();
	StringBuilder builderCatalogList = new StringBuilder(); //IN024984 
	String catalogList	= ""; //IN024984 
	HashMap mandatoryCatagoryMap = null;  //IN024984 
	int dupl_count_alert			= 0;
	int dupl_count_error			= 0;
	//IN047632 - Start
	int dupe_reject_count			= 0;
	int new_order_count  			= 0;
	int dupe_record_count			= 0;
	//IN047632 - End
	int multi_pat_catalog_count 	= 0; //IN024984
	//int row_num = 0;
	//int col_num = 0;
	int conflict_exam_count_records = 0; int conflict_records = 0,total_records=0,total_dupl_count_records=0;
	//int row_col = 0;	
	int count_patient = 0 , count_chk_records = 0 ;
	
	//IN062607 Starts 
	String temp_dup_reason ="";
	String firstDupWin = request.getParameter("fwin")==null?"N":request.getParameter("fwin");
	String emptyVal = request.getParameter("emptyContent")==null?"N":request.getParameter("emptyContent");
	if(!"Y".equals(firstDupWin)){
		if(!"Y".equals(emptyVal)){
			temp_dup_reason=bean.getTempDupeReason()== null?"": bean.getTempDupeReason();
			temp_dup_reason = java.net.URLDecoder.decode(temp_dup_reason,"UTF-8");//[IN064747]
		}
	}
	//IN062607 Ends
	if(hashValues!=null)
	{
		dupl_message		 		= bean.checkForNull((String)hashValues.get("dupl_message"),"");
		susp_message		 		= bean.checkForNull((String)hashValues.get("susp_message"),"");
		rd_appt							= bean.checkForNull((String)hashValues.get("rd_appt"),""); // For Radialogy Appointment
		dupl_count_alert 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_alert"),"0"));
		dupl_count_error 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_error"),"0"));
		conflict_exam_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_exam_count_records"),"0"));
		conflict_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_records"),"0"));
		total_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
		total_dupl_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_dupl_count_records"),"0"));
		called_from_multi				= bean.checkForNull((String)hashValues.get("called_from_multi"),"");
		count_patient			= (Integer)hashValues.get("count_patient")==null?0:(Integer)hashValues.get("count_patient");
		count_chk_records	= (Integer)hashValues.get("count_chk_records")==null?0:(Integer)hashValues.get("count_chk_records");		
		for(int i=1;i<=total_dupl_count_records;i++)
		{
			DuplicateCatalogCodes.add(bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),""));
			if(called_from_multi.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
			{
				String ord_catalog_codes = bean.checkForNull((String)hashValues.get("dupl_catalog_code"+i),"");
				String ord_catalog_desc = bean.checkForNull((String)hashValues.get("dupl_catalog_desc"+i),"");
				if(!dupl_ord_catalogs.contains(ord_catalog_codes))
				{
					dupl_ord_catalogs.add(ord_catalog_codes);
					duplOrdCatalogs.put(ord_catalog_codes,ord_catalog_desc);
				}
				patient_id = bean.checkForNull((String)hashValues.get("patient_id"+i),"");
				if(!dupl_patient_id.equalsIgnoreCase(patient_id))
				{
					multi_patient.add(patient_id);
					dupl_patient_id = patient_id;
				}
			}
		}
		mandatoryCatagoryMap = bean.isDupeMandatoryHashMap(DuplicateCatalogCodes); //IN024984
	}
	for(int i=0;i<dupl_count_error;i++)
	{
		if(!RejectOrders.contains(bean.checkForNull((String)hashValues.get("reject_dupl_catalog_code"+i),"")))
			RejectOrders.add(bean.checkForNull((String)hashValues.get("reject_dupl_catalog_code"+i),""));
	}
	dupe_reject_count = RejectOrders.size(); //IN047632
	for(int dp_orders=0;dp_orders<total_records;dp_orders++)
	{
		if(!DuplicateCatalogCodes.contains((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),""))))
		{			
			NewOrderMap.put((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),"")),(bean.checkForNull((String)hashValues.get("cat_desc"+dp_orders),"")));
		}
		else
		{
			DuplicateOrderMap.put((bean.checkForNull((String)hashValues.get("catalog_code"+dp_orders),"")),(bean.checkForNull((String)hashValues.get("cat_desc"+dp_orders),"")));
			
		}
	}
	new_order_count = NewOrderMap.size(); //IN047632
	dupe_record_count = total_records - new_order_count; //IN047632
	multi_pat_catalog_count = dupl_ord_catalogs.size();
%>	
<html>
	<head>
	<%
 		if(!susp_message.equals("")) 
		{ 
	%>	
		<title><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></title>
	<%
		}  
		else if(conflict_exam_count_records > 0)
		{ 
		%>
			<title><fmt:message key="eOR.ExamConflicts.label" bundle="${or_labels}"/></title>
		<% 
		}
		else if(rd_appt.equals("X"))
		{ 
		%>
			<title><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></title>
	<% 
		} 
		else 
		{ 
		%>
			<title><fmt:message key="eOR.DuplicateCheck.label" bundle="${or_labels}"/></title>
	<% 
		} 
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" onload = "showDupeReasonText(<%=dupe_record_count%>,<%=dupe_reject_count%>)"> <!-- IN047632 -->
	<form name ="duplicateForm">	
	<!--  [IN030464] Start -->
	<BGSOUND><bgsound src="../../eCA/images/DuplicateOrder.wav" LOOP=1></BGSOUND >
	<!--  [IN030464] End -->
	<%
	if(called_from_multi.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
	{
	%>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" align="CENTER" class="grid">
		<tr><td class="gridHeader">&nbsp;</td>
	    <%
		if(duplOrdCatalogs.size()>0)
		{
			for(int dupcatalogs=0;dupcatalogs<dupl_ord_catalogs.size();dupcatalogs++)
			{
				String catalog_code = (String)dupl_ord_catalogs.get(dupcatalogs);
				String catalog_desc = (String)duplOrdCatalogs.get(catalog_code);
				//IN024984 - Start
						String mand = (String)mandatoryCatagoryMap.get(catalog_code);
						String display_style = "visibility:hidden";
						if(mand!=null && mand.equals("Y"))
						{
							display_style = "visibility:visible";
						}
						//IN024984 - End
				
				%>
				<td class = "gridHeader" nowrap id="catalogDesc'<%=dupcatalogs%>'">
					<%=bean.checkForNull(catalog_desc,"")%>
					<input type="checkbox" name="chk<%=dupcatalogs%>" id="chk<%=dupcatalogs%>" id="<%=dupcatalogs%>" checked value="<%=catalog_code%>" onclick="validateCatalogs(this,'<%=dupcatalogs%>');enableMultiDupeReason('<%=dupcatalogs%>')">
					<input type="hidden" value="<%=catalog_code%>" name="hd<%=dupcatalogs%>">
					<a href="#" id = 'order_dupe_reason<%=dupcatalogs%>'  style='display:inline' title='<fmt:message key="eOR.dupoverridereason.label" bundle="${or_labels}"/>' onclick="addDupeCodeReason('<%=catalog_code%>','<%=bean_id%>','<%=bean_name%>','<%=catalog_desc%>')"> Dup... </a><label  id="dup_mand<%=dupcatalogs%>" Title="dup reason"  style="<%=display_style%>"><img src="../../eCommon/images/mandatory.gif"></img></label><!-- added for SS-CRF-20045 --> <!--IN024984 added mandatory img-->
					<input type="hidden" name="mand<%=dupcatalogs%>" id="mand<%=dupcatalogs%>" value="<%=mand%>">
				</td>
				
				
				<%
			}
			for(int i=0;i<multi_patient.size();i++)
			{
				patient_id					= (String)multi_patient.get(i);
				patRejectOrder			= "";
				String[] record			= (String[])bean.getDeceasedPatientYn(patient_id);
				String patient_name	= bean.checkForNull((String)record[1],"");
				%>
					</tr>
					<tr id = 'patient_row<%=i%>'>
					<td class="gridData"  id ="reject_order_hdr<%=i%>"><%=patient_name%><input type="checkbox" name="<%=patient_id%>" id="<%=patient_id%>" id="pat<%=i%>" checked onclick="validatePatients(this,'<%=patient_id%>')">
						<input type="hidden" name="pat_id<%=i%>" id="pat_id<%=i%>" value="<%=patient_id%>">
					</td>
				<%
				int patTotCatalogs = (Integer)hashValues.get(patient_id);
				for(int ord_cat=0;ord_cat<duplOrdCatalogs.size();ord_cat++)
				{	
					boolean datafound = false;
					String[] str			= null;
					String catalog_code = bean.checkForNull((String)dupl_ord_catalogs.get(ord_cat),"");	
					for(int pat_cat=0;pat_cat<patTotCatalogs;pat_cat++)
					{
						String catalog_str = bean.checkForNull((String)hashValues.get(patient_id+pat_cat),"");
						if(catalog_str.indexOf("##")!=-1)
						{
							str = catalog_str.split("##");
						}
						if(catalog_code.equalsIgnoreCase(str[0]))
						{
							datafound = true;
							pat_cat = patTotCatalogs;
						}
					}
					if(datafound)
					{
					%>
						<td  class="gridData" id ="reject_order<%=i%>" > <!-- IN047686 End -->
							<B>
								<%
								//if(RejectOrders.contains(catalog_code))
								if(str[1].equalsIgnoreCase("R"))
								{	
									patRejectOrder = "R";
								%>
									<font color="red" size="3">X</font>
								<%
								}
								else
								{
									patRejectOrder = "";
								%>
									<font color="Orange" size="3">X</font>
								<%
								}
								%>
							</B>
						</td>
					<%
					}
					else
					{
						patRejectOrder = "";
					%>
						<td>&nbsp;</td>
					<%
					}
					%>
				<input type="hidden" name="patRejectOrder<%=i%><%=ord_cat%>" id="patRejectOrder<%=i%><%=ord_cat%>" value ="<%=patRejectOrder%>">
				<%
				}				
			}
			%>
			</table>
			<!-- IN024984, IN047686 Start -->
			<table valign='center' border="0" cellpadding="3" cellspacing="0" width="100%" height = '150px' align="CENTER" >
<tr><td>			
				<tr> 
						<td valign='center' class='gridHeader' id ='dupe_reason_header_title' style = 'text-align:center;display:none;'  ><fmt:message key="eOR.dupoverridereason.label" bundle="${or_labels}"/></td> <!-- IN047632  -->
				</tr>
				<tr>
						<!--<td valign='center' class='gridData' id ='dupe_reason_header_text' style = 'text-align:center;display:none;' ><textarea name="dup_override_reason"  value="" rows="3" cols="50" maxlength='2000' onKeyPress='checkMaxLimit(this,2000);'    onBlur="makeValidString(this)" ></textarea></td> <!-- IN047632  --> <!--Commented for IN062607-->
						<td valign='center' class='gridData' id ='dupe_reason_header_text' style = 'text-align:center;display:none;' ><textarea name="dup_override_reason"  value="" rows="3" cols="50" maxlength='2000' onKeyPress='checkMaxLimit(this,2000);'    onBlur="makeValidString(this)" ><%=temp_dup_reason%></textarea></td> <!-- IN047632  --> <!--Modified for IN062607-->
				</tr>	
</td></tr>				
			<!-- IN024984, IN047686 End -->
			</table>
			<%
		}
	}
	else
	{
	%>
	<br>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" align="CENTER">
		<tr>
			<td class="LABEL" colspan="3" width="100%">
			<%	
			if((dupl_count_error > 0) || (dupl_count_alert > 0) ) // for the duplicate check
			{
			%>
				<%--// Commented here added below after duplicate order for IN063973 starts
				if(NewOrderMap.size()>0)
				{
				%>
					</td></tr><tr><td class="LABEL" colspan="3"  width="100%"><b><font size="2"><fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></font></b></td></tr> 
				<%
					Set newmap=NewOrderMap.keySet();
					Iterator iterator 	 = newmap.iterator();
					while( iterator. hasNext() )
					{
						%>
					<tr>
							<td colspan="3" align="left"><%=NewOrderMap.get(iterator.next())%></td>
					</tr><td>
<%
					}
				}
			 //Commented here added below after duplicate order for IN063973 Ends	
	--%>
	<%
				if((DuplicateOrderMap.size()>0))
				{
				%>
						</td>
					</tr>
					<tr>
						<td class="LABEL" colspan="2" width="50%"><b><font size="2"><fmt:message key="eOR.DuplicateOrders.label" bundle="${or_labels}"/></font></b>
						</td><td class="label" width="50%"><b><font size="2"><fmt:message key="eOR.Discard.label" bundle="${or_labels}"/></b></td>
					</tr>
					<%
					int dr=0;
					Set newmap=DuplicateOrderMap.keySet();
					Iterator iterator 	 = newmap.iterator();
					while( iterator. hasNext() )
					{
						String DupDesckey=(String)iterator.next();
						String DupKeyShortDesc = (String)DuplicateOrderMap.get(DupDesckey);
						//IN024984 - Start
						String mand = (String)mandatoryCatagoryMap.get(DupDesckey);
						String display_style = "visibility:hidden";
						if(mand!=null && mand.equals("Y"))
						{
							display_style = "visibility:visible";
						}
						//IN024984 - End
					%>
					<tr>
					<td width="65%"><a href="#" onclick="viewDuplicateRecords('<%=DupDesckey%>')"><%=DuplicateOrderMap.get(DupDesckey)%></a></td>
					<%
					if(RejectOrders.contains(DupDesckey))
					{
						dup_catalogs="checked disabled";
					}
					else
					{
						dup_catalogs="";
						builderCatalogList.append(DupDesckey); //IN024984
						builderCatalogList.append("#"); //IN024984
					}
					%>
					<td width="5%">
					<input type="checkbox"  name='chk<%=dr%>' id='chk<%=dr%>' value="<%=DupDesckey%>" <%=dup_catalogs%> onclick = "enableDupeReason('<%=dr%>')">
					</td>
					<!-- IN024984 Start -->
					<%
					if(dup_catalogs.equals("")){
						DupKeyShortDesc = java.net.URLEncoder.encode(DupKeyShortDesc,"UTF-8");
					%>
					<td width="40%" id = 'order_dupe_reason<%=dr%>' style='display:inline'>
						<a href="#" onclick="addDupeCodeReason('<%=DupDesckey%>','<%=bean_id%>','<%=bean_name%>','<%=DupKeyShortDesc%>')"> <fmt:message key="eOR.dupoverridereason.label" bundle="${or_labels}"/> </a> <label  id="dup_mand" Title="dup reason"  style="<%=display_style%>"><img src="../../eCommon/images/mandatory.gif"></img></label><!-- added for SS-CRF-20045 --> <!--IN024984 added mandatory img-->
					</td>
					<%
					}else{
					%>
					<td width="40%">&nbsp;</td>
					<%}					
					%>
					<input type="hidden" name="DupDesckey<%=dr%>" id="DupDesckey<%=dr%>" value="<%=DupDesckey%>">	
					<input type="hidden" name="mand<%=dr%>" id="mand<%=dr%>" value="<%=mand%>">
					<input type="hidden" name="discard<%=dr%>" id="discard<%=dr%>" value="N">
					<!-- IN024984 End -->
					</tr><td>
<%
						dr++;
					}
%>
					<!-- IN024984 Start -->
					<tr>
						<td colspan="3" id ='dupe_reason_header_title' style = 'font-size:9pt;font-weight:normal;text-align:center;display:none'  ><fmt:message key="eOR.dupoverridereason.label" bundle="${or_labels}"/></td> <!-- IN047632  -->
					</tr>
					<tr>
						<!--<td id ='dupe_reason_header_text' style = 'font-size:9pt;font-weight:normal;text-align:center;display:none' ><textarea name="dup_override_reason"  value="" rows="3" cols="50" maxlength='2000' onKeyPress='checkMaxLimit(this,2000);'    onBlur="makeValidString(this)" ></textarea></td>  <!-- IN047632  --> <!--Commented for IN062607-->
						<td colspan="3" id ='dupe_reason_header_text' style = 'font-size:9pt;font-weight:normal;text-align:center;display:none' ><textarea name="dup_override_reason"  value="" rows="3" cols="50" maxlength='2000' onKeyPress='checkMaxLimit(this,2000);'    onBlur="makeValidString(this)" ><%=temp_dup_reason%></textarea></td>  <!-- IN047632  --> <!--Modified for IN062607-->
					</tr>
					<!-- IN024984 End -->
<%					
					catalogList = builderCatalogList.toString();
				}
				//commented at the top added below for IN063973 starts
				if(NewOrderMap.size()>0)
				{
				%>
					</td></tr><tr><td class="LABEL" colspan="3" width="100%"><b><font size="2"><fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></font></b></td></tr>
				<%
					Set newmap=NewOrderMap.keySet();
					Iterator iterator 	 = newmap.iterator();
					while( iterator. hasNext() )
					{
						%>
					<tr>
							<td colspan="3"><%=NewOrderMap.get(iterator.next())%></td>
					</tr><td>
<%
					}
				}
				//commented at the top added below for IN063973  ends
		}
		else if(conflict_exam_count_records >0) // For the Exam Conflicts for radialogy
		{
			if(conflict_records > 0 ) //That means it can be proceeded
				out.println("Exam Conflicts Found...");
			else  // otherwise cannot proceed further should stop (displaying the last record desc)
			out.println("Exam Conflicts Found...Cannot Proceed...<br>");
			out.println(bean.checkForNull((String)hashValues.get("conflict_reason0"),""));
  		}
		else if(rd_appt.equals("X")) 	// For the Radiology , if appointment is there 
		{
			out.println("Other Appointments already exists...");
		}
		else if(!susp_message.equals("")) {  // For Lab Installed and Test Codes and Panel Matching
		  	out.println("<b>"+susp_message+"</b><br> has been Suspended/Invalid.<br> Cannot Proceed...");	
		} else   // For Lab Installed and Test Codes and Panel Matching
			out.println("<b>"+dupl_message+"</b><br> is Already Selected in the Panel.<br> Cannot Proceed...");
%>
		</tr>
		<tr><td colspan="3" class="LABEL">&nbsp;</td></tr>
	</table>
	<%
	}
	%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="total_dupl_count_records" id="total_dupl_count_records" value="<%=total_dupl_count_records%>">
		<input type="hidden" name="total_dup_catalogs" id="total_dup_catalogs" value="<%=dupl_ord_catalogs.size()%>">
		<input type="hidden" name="total_dup_patients" id="total_dup_patients" value="<%=multi_patient.size()%>">
		<input type="hidden" name="patient_count" id="patient_count" value="<%=count_patient%>">
		<input type="hidden" name="chk_records_count" id="chk_records_count" value="<%=count_chk_records%>">
		<input type="hidden" name="dupe_catalogcode_list" id="dupe_catalogcode_list" value="<%=catalogList%>"> <!-- IN024984 -->
		<input type="hidden" name="validated_reason_hashmap" id="validated_reason_hashmap" value=""> <!-- IN024984 -->
		<input type="hidden" name="dupe_reject_count" id="dupe_reject_count" value="<%=RejectOrders.size()%>"> <!-- IN047605 -->
		<input type="hidden" name="dupe_reason_header_title" id="dupe_reason_header_title" value=""><!-- IN047686 -->
		<input type="hidden" name="dupe_reason_header_text" id="dupe_reason_header_text" value=""> <!-- IN047686 -->
		<input type="hidden" name="multi_pat_catalog_count" id="multi_pat_catalog_count" value="<%=multi_pat_catalog_count%>"> <!-- IN024984 -->
		<input type="hidden" name="firstDupWindow" id="firstDupWindow" value="<%=firstDupWin%>"><!--IN062607-->
		
		
	</form>
	</body>
</html>
<%
	// no need to set it back persistence
	// putObjectInBean(bean_id,bean,request);
%>

