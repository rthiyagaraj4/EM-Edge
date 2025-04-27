<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
26/06/2012    IN033488      Chowminya G      	Incident No: IN033488 -  Error Marking - Result completed indicator> 
-----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 			10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
14/03/2019	IN068778			Selvin M					14/03/2019		Ramesh G		TBMC-CRF-0011
22/08/2020	IN073625			Ramesh Goli				22/08/2020		Ramesh G		OR-PMG2020-TECH-CRF-0001/01-Place Order
16/08/2021	19112			Ramesh												NMC-JD-CRF-0106
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,java.sql.* "%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
   request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!---->
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ResultReporting.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
 	<script src='../../eCA/js/CAMenu.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>

	function hideToolTip(obj,imgObj,row)	
	{
		dynamichide(obj, window.event,row);
	  /*document.getElementById("tooltiplayer").style.visibility = 'hidden'
	   if (obj != null)
	  {
			obj.className = 'gridDataBlue';
			eval("document.all."+imgObj).src = "../../eCommon/images/inactiveArrow.gif";
	  }*/

	}


	function callMouseOver(obj)	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';

	}

	function callOnMouseOut(obj){
		obj.className = 'contextMenuItem';
	}


//aaaa
	function displayToolTip(val,val1,orderId, encounterId,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performed_only,performing_location_type,performing_location,int_or_ext,sent_out_flag,order_type_code,priority,source_type,source_code,patient_dtls,discr_msr_id,proc_code_scheme,orderctlHDR,imgObj,order_set_id,pat_dob,accssion_num) {

		callMouseOverOnTD(orderctlHDR,imgObj);

	  	buildTable (val,val1,orderId, encounterId,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performed_only,performing_location_type,performing_location,int_or_ext,sent_out_flag,order_type_code,priority,source_type,source_code,patient_dtls,discr_msr_id,proc_code_scheme,order_set_id,pat_dob,accssion_num);
		
		var orderctlHDR1 = orderctlHDR.id;

		/*var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
 		var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;*/

		var element = document.getElementById(orderctlHDR1);
		var wdth = element.offsetWidth;
		var hght1 = element.offsetHeight;		
		
		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;

		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
	
		var z = bodwidth- (event.x + wdth);	
		
		var x 	  = event.x;
		var y 	  = event.y;	

		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	

		if(x<bodwidth){
			x= wdth1;			
		}else{			
			x = getPos(orderctlHDR).x;
		}
		if(y<bodheight){			
			y = hght;
			
		}else
		{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
		}
		   y += 100;
		document.getElementById("tooltiplayer").style.Left= x+"px";
		document.getElementById("tooltiplayer").style.Top = y+"px";
		document.getElementById("tooltiplayer").style.visibility='visible'
		
	}

	function buildTable(val,val1,orderId, encounterId,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performed_only,performing_location_type,performing_location,int_or_ext,sent_out_flag,order_type_code,priority,source_type,source_code,patient_dtls,discr_msr_id,proc_code_scheme,order_set_id,pat_dob,accssion_num) {
//Replace/Add

        var rowval   = val.split (",");
		var nn=0;
		
		//var row      = ("UpdateOrder,UpdateLine,Completion,Notes,Image,ResultEntry,RecordProcedure,Preps,Comments,Instructions,Discontinue,Hold,Resume,Renew,ChangePerformLocn,SentOut,ReceiveResult,Replace,ChangeChargeType");
		var row=new Array();
		if(val.indexOf("View")==-1)
		{
			//IN061903 starts
			row      = ("Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn");
			//IN061903 ends			
		}
		else
		{
			//IN061903 start
			 row      = ("View,Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn");
			 //row      = ("View,Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn");
			//IN061903 ends
		}
	
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
 		for( var i=0; i<rowval.length; i++ ) {
			var colval  = rowval[i];
			var colval1 = rowval1[i];
		if (colval != "")
		{				
					tab_dat   =  tab_dat+"<tr>" ;
					if(colval1=="LB"){
							if(colval=="LINE")
							{
								if(nn>0)
								{
									tab_dat    = tab_dat+ "<td class='contextMenuItemSeperator'  nowrap id='mouse' ><hr class='contextMenuItemSeperator' width='88%' align=center></td>" ;
									nn=0;
								}
							}
							else
							{
								tab_dat    = tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>"+colval+" </td>" ;
								nn=nn+1;
							}
					}					
					else	if (colval1 != "ChangePerformLocn" && colval1 != "SentOut" && colval1 != "ReceiveResult" && (!((sent_out_flag == 'S' || sent_out_flag == 'R') && (colval1 == "ResultEntry" || colval1 == "Completion"))) ||  colval1 == "Replace" ||  colval1 == "ChangeChargeType" || colval1=="View") {
						nn=nn+1;
						tab_dat    =tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+escape(val1)+"','"+orderId+"','"+encounterId+"','"+sex+"','"+patient_id+"','"+escape(procedure_code)+"','"+patient_class+"','','"+ord_cat+"','"+order_status+"','"+order_line_num+"','"+performing_facility+"','"+performing_location_type+"','"+performing_location+"','"+int_or_ext+"','"+sent_out_flag+"','"+escape(patient_dtls)+"','"+escape(discr_msr_id)+"','"+proc_code_scheme+"','"+order_type_code+"','"+order_set_id+"','"+pat_dob+"','"+accssion_num+"','"+performed_only+"');>"+colval+" </a></td>" ;
					}
					else {
						nn=nn+1;

						tab_dat    = tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callPerfMenuFunctions('"+colval1+"','"+escape(val1)+"','"+orderId+"','"+encounterId+"','"+sex+"','"+patient_id+"','"+escape(procedure_code)+"','"+patient_class+"','"+ord_cat+"','"+order_status+"','"+order_line_num+"','"+performing_facility+"','"+performing_location_type+"','"+performing_location+"','"+int_or_ext+"','"+sent_out_flag+"','"+priority+"','"+order_type_code+"','"+source_type+"','"+source_code+"','"+pat_dob+"');>"+colval+" </a></td>" ;
					}
					tab_dat     =tab_dat+ "</tr> " ;
			}
		}
			tab_dat     =tab_dat+ "</table> ";
		document.getElementById("t").innerHTML = tab_dat;
	}

	

	function dummy()
	{}


	</script>
      <!--  <STYLE TYPE="text/css">
       	A:link
       	 {
       	     COLOR: blue;
       	 }
     	A:visited
     	 {
             COLOR: blue ;
         }
        A:active
         {
             COLOR: red;
         }         

   </STYLE> -->
   
</head>

<body onscroll='processScroll()'  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%!

    private boolean compareDate(String from_date,String to_date) {
    try{
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat ("dd/MM/yyyy kk:mm");
		
         // Parse the previous string back into a Date.
         java.text.ParsePosition pos = new java.text.ParsePosition(0);
         java.text.ParsePosition pos1 = new java.text.ParsePosition(0);
         java.util.Date from = formatter.parse(from_date, pos);
         java.util.Date to = formatter.parse(to_date, pos1);
        
         int result = from.compareTo(to);
         if (result > 0) {
            return false;
         } else {
            return true;
         }
    } catch(Exception e) {
        
		e.printStackTrace();	
    }
    return true;
    }
%>
<%
	HashMap Parameters = new HashMap();
	Enumeration paramNames = request.getParameterNames();
	while(paramNames.hasMoreElements())
	{
		String pName = (String)paramNames.nextElement();
		String paramValue = request.getParameter(pName);
		if(paramValue == null)	paramValue = "";
		else paramValue = paramValue.trim();
		Parameters.put(pName, paramValue);
	}
	//19112 Start.
	Connection connection =  null;	
	boolean isSiteSpecificBillStatus = false; 
	try{
		connection = ConnectionManager.getConnection(request); 	
		isSiteSpecificBillStatus = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BILL_STATUS_DISPLAY");
	}catch(Exception e){
		out.println("Exception@1: "+e);
	}finally{
		if(connection!=null)	ConnectionManager.returnConnection(connection,request);
	}
	//19112 End.
	/* Mandatory checks start */
	String location="";
	String mode	   				= "1";//request.getParameter( "mode" ) ;
	String function_id 			= request.getParameter( "function_id" ) ;
	String practitioner_id 		= (String)session.getValue("ca_practitioner_id");
	String responsibility_id 	= (String)session.getValue("responsibility_id");
	String facility_id 			= (String)session.getValue("facility_id");
	String practitioner_type 	= (String)session.getValue("practitioner_type");
	String patient_id_found 	= request.getParameter("patient_id_found");
	String order_category 		= request.getParameter("order_category");
 	String group_by             = request.getParameter("group_by");
 	String performing_location_code             = request.getParameter("performing_location_code");
 	//String taskCode             = request.getParameter("taskCode");
	String from_ca              = request.getParameter("from_ca");
	String can_location_type			= request.getParameter("location_type");
	String can_location					= request.getParameter("location");
	String can_order_category			= request.getParameter("order_category");
	String can_single_multi				= request.getParameter("single_multi");
	String can_priority					= request.getParameter("priority");
	String can_date_from				= request.getParameter("date_from");
	String can_date_to					= request.getParameter("date_to");
	String can_patient_id				= request.getParameter("patient_id");
	String can_order_id					= request.getParameter("order_id");
	String can_encounter_id				= request.getParameter("encounter_id");
	String can_patient_id_found			= request.getParameter("patient_id_found");
	String can_order_type				= request.getParameter("order_type");
	String can_performing_location_code = request.getParameter("performing_location_code");
	String can_view_by 					= request.getParameter("view_by");
	//String can_task_status 				= request.getParameter("can_task_status");
	String can_specimen_no				= request.getParameter("specimen_no");
	String can_catalog_desc				= request.getParameter("catalog_desc");
	String can_search_criteria			= request.getParameter("search_criteria");
	String can_task_status 				= request.getParameter("task_status");
	String can_source_location_type		= request.getParameter("source_type");
	String can_source_locn 				= request.getParameter("source_location");
	String can_group_by 				= request.getParameter("group_by");
	String performed_only 				= request.getParameter("performed_only")==null ?"":request.getParameter("performed_only");
	String period_mod_rslt_completed 				= request.getParameter("period_mod_rslt_completed")==null ?"":request.getParameter("period_mod_rslt_completed");
	String by_24hrs_yn 				= request.getParameter("by_24hrs_yn")==null ?"":request.getParameter("by_24hrs_yn");
	String total_query_records			= "0";	
	can_catalog_desc 		= (can_catalog_desc == null) ? "" : can_catalog_desc;
	can_search_criteria 		= (can_search_criteria == null) ? "" : can_search_criteria;
	can_source_location_type 		= (can_source_location_type == null) ? "" : can_source_location_type;
	can_source_locn 		= (can_source_locn == null) ? "" : can_source_locn;
	can_group_by 		= (can_location_type == null) ? "" : can_group_by;
	if(practitioner_id == null)	practitioner_id = "";
	if(responsibility_id == null)	responsibility_id = "";
	if(facility_id == null) facility_id = "";
	if(practitioner_id == null)practitioner_id = "";
	if(order_category == null) order_category = "";
	if (group_by == null) group_by = "";
	if (from_ca == null) from_ca = "";
	if(can_location_type == null) can_location_type = "";
	if(can_location == null) can_location = "";
	if(can_order_category == null) can_order_category = "";
	if(can_single_multi == null) can_single_multi = "";
	if(can_priority == null) can_priority = "";
	if(can_date_from == null) can_date_from = "";
	if(can_date_to == null) can_date_to = "";
	if(can_patient_id == null) can_patient_id = "";
	if(can_order_id == null) can_order_id = "";
	if(can_encounter_id == null) can_encounter_id = "";
	if(can_patient_id_found == null) can_patient_id_found = "";
	if(can_order_type == null) can_order_type = "";
	if(can_performing_location_code == null) can_performing_location_code = "";
	if(can_view_by == null) can_view_by = "";
	if (can_task_status == null) can_task_status = "";
	if (can_specimen_no == null) can_specimen_no = "";
	Parameters.put("practitioner_id", practitioner_id);
	Parameters.put("responsibility_id", responsibility_id);
	Parameters.put("facility_id", facility_id);
	Parameters.put("practitioner_type", practitioner_type);
	Parameters.put("from_ca",from_ca);
	Parameters.put("catalog_desc",can_catalog_desc);
	Parameters.put("search_criteria",can_search_criteria);
	Parameters.put("performing_location_code",performing_location_code);
	Parameters.put("period_mod_rslt_completed",period_mod_rslt_completed);
	Parameters.put("by_24hrs_yn",by_24hrs_yn);
	Parameters.put("pract_reln_id",request.getParameter("pract_reln_id")==null ?"":request.getParameter("pract_reln_id"));
	//Parameters.put("taskCode",taskCode);

	String bean_id = "Or_ResultReporting";//request.getParameter("bean_id");
	String bean_name = "eOR.ResultReportingBean";//request.getParameter("bean_name");

/* Mandatory checks end */

/* Initialize Function specific start */

	ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name ,request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.setMode( mode ) ;

	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
 	//if(from!=null && from.equals("1")) {
 		
	//}
	Parameters.put("start", String.valueOf(start));
	Parameters.put("end",String.valueOf(end));

 /* Initialize Function specific end */
    //String encounter_id = bean.checkForNull((String)Parameters.get("encounter_id"),"");
	ArrayList allValues = new ArrayList();
//	if(from!=null && from.equals("1")){
		allValues = bean.getSearchDetails(Parameters);
// 		bean.setDetails(allValues);
//	}else{
//		allValues=bean.getDetails();
//	}
	//ArrayList arrSysDateTime = bean.getSysDateTime();
	//String sys_date_time = (String)arrSysDateTime.get(2);

	String patient_id = "";
	String sex = "";
	//String[] Result_Type=new String[2];
	String discr_msr_id="";
	//String resultType = "";String discr_msr_id="";
	//String[] Result_Type=new String[2];

	int i = 0;
if( allValues.size() == 0){ %>
	<script>
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
	clearValuesfor(); //added by prasad
	</script>
 <%}else{%>
<form name='result_reporting' id='result_reporting'  action="../../eOR/jsp/ResultReportingQueryResult.jsp" method="post">
<div id="divHeadSep" style="position: ;">
<table cellpadding=3 cellspacing=0 border=1 width="100%" height="" id="tableresult" class="grid">
<tr id="heading">
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
        <td class=columnheader width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		<%
		//19112 Start.
		if(isSiteSpecificBillStatus){
			%>
			<td class=columnheader width='' nowrap><fmt:message key="eOR.BillingStatus.label" bundle="${or_labels}"/></td>
		<%
		}
		//19112 end.
		%>
		<td class=columnheader width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
</tr>
<%
	String slClassValue = "";
	String tmp_ord_cat = "";
	//String temp_menu_text = ""; // temp variable created on 13/04/2007 - Anji Prasad
	
//	if(allValues.size() < 7 || end > allValues.size()) {
//			end = allValues.size();
//	}	

	
	for(int k=0; k<allValues.size(); k++)
	{
		String fontValue 		= "";
		String imageTag 		= "";
		String procedure_code	= "";
		String proc_code_scheme	= "";
		String result_type		= "";
		//String auto_report_yn	= "";
		//String bill_yn	= "";
		//String charge_type_applicable	= "";
		//String[] row_details = new String[18];
		//row_details = (String[])allValues.get(i);
		String[] row_details= (String[])allValues.get(k);
		/*for(int x=0;row_details[x]!="\0";x++)
			*/
		if(row_details[1].compareTo("R")==0){
					row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(row_details[1].compareTo("U")==0)
				{
					
					row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(row_details[1].compareTo("S")==0)
				{
				
				row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					

				}	
				StringBuffer menuText = new StringBuffer();
				StringBuffer viewmenuText = new StringBuffer();
				StringTokenizer kv=new StringTokenizer(row_details[12],"|");
				int count=kv.countTokens();
				boolean linef=false;
				//boolean lined=false;
				boolean lineg=false;
				int menutext=0;
				String tempTokens="";
				StringBuffer stringtoken=new StringBuffer();
				while (kv.hasMoreTokens()) 
				{
					tempTokens = kv.nextToken();
					if(tempTokens.trim().length()>1)
					{
						String[] values1=row_details[12].split(":");
						proc_code_scheme=values1[1];
						procedure_code=values1[2];
						tempTokens=tempTokens.substring(0,1);
					}
					stringtoken.append(tempTokens);				
					stringtoken.append("|");				
				}
				row_details[12]=stringtoken.toString();
				stringtoken.setLength(0);
				int n=1;
				if(count>1)
				{
					//IN073625 Start.
					//String[] values=row_details[12].split("|");
					String[] values=(row_details[12]).split("\\|");
					//IN073625 Start.
					 menutext=0;
					//for(int m=0;m<count*2;m++)//IN073625
					for(int m=0;m<values.length;m++)//IN073625
					{
						//if(m%2==1) //IN073625
						//{ //IN073625
							if(values[m].equals("Y") || values[m].equals("_"))
							{
								menutext++;
								switch(n)
								{
									//IN061903 start
									/*
									case 1: menuText.append( "'+getLabel('eOR.OrderCompletion.label','OR')+',");lineg=true;break;
									case 2: menuText.append( "'+getLabel('eOR.ResultEntry.label','OR')+',");lineg=true;break;
									case 3: menuText.append( "'+getLabel('eOR.RecordProcedure.label','OR')+',");lineg=true;*/
												/*String[] values1=row_details[12].split(":");
												proc_code_scheme=values1[1];
												procedure_code=values1[2];*/
									/*													
									break;
									case 4: menuText.append( "'+getLabel('eOR.SentOut.label','OR')+',");lineg=true;break;
									case 5: menuText.append( "'+getLabel('eOR.ReceiveResult.label','OR')+',");lineg=true;break;
									case 6: menuText.append( "LINE,");break;
									case 7:*/ /*if(lineg)
												menuText.append( "LINE,");
												else
												menuText.append( ",");
												linef=true;*/
												/*menuText.append( "'+getLabel('Common.Discontinue.label','COMMON')+',");break;
									case 8: *//*if(!linef && lineg)
												{
													//menuText.append( "LINE,");
													menuText.append( ",");
												}
												else if(!linef && !lineg)
												menuText.append( ",");
												linef=true;*/
												/*menuText.append( "'+getLabel('Common.Hold.label','COMMON')+',");break;
									case 9:*/ /* if(!linef && lineg)
												menuText.append( "LINE,");
												else if(!linef && !lineg)
												menuText.append( ",");
												linef=true;*/
												/*menuText.append( "'+getLabel('eOR.ReviewLineStatus.label','OR')+',");break;
									case 10:*//* if(!linef && lineg)
												{
												menuText.append( "LINE,");
												linef=true;
												}*/
												/*menuText.append( "'+getLabel('eOR.ReviewOrderStatus.label','OR')+',");break;
									case 11: menuText.append( "LINE,");break;
									case 12: 
												*//*if(!linef)
												menuText.append(",");
												if(linef || lineg)
												{
												menuText.append( "LINE,");
												lined=true;
												}*/
											/*	menuText.append( "'+getLabel('Common.Replace.label','COMMON')+',");break;
									case 13: */
												/*if(!linef && lineg)
												menuText.append(",");
												if((linef || lineg) && !lined)
												{
												menuText.append( "LINE,");
												lined=true;
												}*/
												/*menuText.append( "'+getLabel('eOR.RedirectOrder.label','OR')+',");break;
									*/
									
									case 1: menuText.append( "'+getLabel('eOR.OrderCompletion.label','OR')+',");lineg=true;break;
									case 2: menuText.append( "'+getLabel('eOR.ResultEntry.label','OR')+',");lineg=true;break;
									case 3: menuText.append( "'+getLabel('eOR.RecordProcedure.label','OR')+',");lineg=true;break;
									case 4: menuText.append( "'+getLabel('eOR.SentOut.label','OR')+',");lineg=true;break;
									case 5: menuText.append( "'+getLabel('eOR.ReceiveResult.label','OR')+',");lineg=true;break;
									case 6: menuText.append( "LINE,");break;
									case 7: menuText.append( "'+getLabel('Common.Discontinue.label','COMMON')+',");break;
									//case 8: menuText.append( "'+getLabel('Common.NOTDONE.label','COMMON')+',");break;
									case 8: menuText.append( "'+getLabel('Common.Hold.label','COMMON')+',");break;
									case 9: menuText.append( "'+getLabel('eOR.ReviewLineStatus.label','OR')+',");break;
									case 10:menuText.append( "'+getLabel('eOR.ReviewOrderStatus.label','OR')+',");break;
									case 11:menuText.append( "LINE,");break;
									case 12:menuText.append( "'+getLabel('Common.Replace.label','COMMON')+',");break;
									case 13:menuText.append( "'+getLabel('eOR.RedirectOrder.label','OR')+',");break; 
									//IN061903 ENDS										
									
									default: if(!linef)
												menuText.append(",");
												
			
								}
							}
							else
								menuText.append(",");						
							n++;
						//} //IN073625

					}
				 }
				 if(menutext==2)
				 {
					 viewmenuText.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels"));
					 viewmenuText.append(","+menuText);
					 menuText.setLength(0);
					 menuText.append(viewmenuText);
				 }
				String sex1;
				sex1="";
				if (row_details[14].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(row_details[14].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(row_details[18].equalsIgnoreCase("C"))
			{
						location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(row_details[18].equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}else if(row_details[18].equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}
			row_details[3]=row_details[3]+","+sex1+"/"+row_details[25]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+row_details[11]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+row_details[16]+","+location+"/"+row_details[13]+",";
		/*	 if (row_details[3].indexOf(",")!=-1){
			StringTokenizer fieldTokenizer = new StringTokenizer(row_details[3],",");
			row_details[3]="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();


		  if ((tempToken.indexOf('/'))==2)
			{
			  String tempstr=tempToken.substring(2);

			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
		row_details[3]=row_details[3].concat(tempToken).concat(",");
		}
			 }*/

		for (int index = 0;index < row_details.length;index++) 
		{
		  if (row_details[index] == null)  row_details[index] = "";
		}

		if(k==0) 
		{ 

		// Header
			if(row_details[36] != null)
				total_query_records = bean.checkForNull((String)row_details[36],"0");
	
%>	
<%if((Integer.parseInt(total_query_records)>0) || (start>1)){%>
<tr align="right">
	<%if(isSiteSpecificBillStatus){%>
	<td colspan="6">
	<%}else{%>
	<td colspan="5">
	<%}%>
		 <jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
		  <jsp:param name ="from" value= "<%=start%>" /> 
		  <jsp:param name ="to" value= "<%=end%>" />	
		  <jsp:param name ="total_size" value= "<%=total_query_records%>" />   
		  <jsp:param name ="check_box_name" value= "" />					 
		  <jsp:param name ="form_name" value= "result_reporting" />  
		</jsp:include>
	</td>
</tr>
<%}%>
<%		}  

		%><!--<script>alert('<%=row_details[2]%>');</script>--><%

		//String visit_adm_date = "";//bean.getVisAdmDate(facility_id,row_details[16]);	    
		patient_id = row_details[11];

		//if(row_details[5].trim().equalsIgnoreCase("PH") && !(can_order_type.equals("TDM")) && !(can_order_type.equals("PDC")))
		//	row_details[12] = "C";
		


		//if(row_details[5].trim().equalsIgnoreCase("PH") && !(row_details[7].equals("TDM")) && !(row_details[7].equals("PDC")))
		   //row_details[12] = "C";
        //row_details[12] = "Y";
		
 
		String grpCheckValue = "";
		if (group_by.equals("P")) {
		  grpCheckValue = (String)row_details[11];
		} else if (group_by.equals("") || group_by.equals("D")) {
		  grpCheckValue = (String)row_details[17];
		} else if (group_by.equals("C")) {
		  grpCheckValue = (String)row_details[5];
		}  else if (group_by.equals("T")) {
		  grpCheckValue = (String)row_details[7];
		}   else if (group_by.equals("L")) {
		  grpCheckValue = (String)row_details[18]+"/"+(String)row_details[13];
		}  else if (group_by.equals("U")) {
		  grpCheckValue = (String)row_details[1];
		}  else if (group_by.equals("O")) {
		  grpCheckValue = (String)row_details[2];
		}
		String result_applicable_yn = "";
		String complete_remarks 	= "";
		String complete_date_time 	= "";
		//StringBuffer menu_text = new StringBuffer();
		//String replace_text			= "";
		String sent_out_flag 		= "";
		String order_line_num 		= bean.checkForNull((String)row_details[37],"");

		  //order_line_num		= "1";
		  result_applicable_yn = (String)row_details[20];
		  complete_remarks = (String)row_details[21];
		  complete_date_time = bean.checkForNull((String)row_details[27],"");



			/*StringTokenizer menuTokenizer = new StringTokenizer(row_details[28],"!");
			int count = 0;
			while (menuTokenizer.hasMoreTokens()) {
			  String tempToken = menuTokenizer.nextToken();
			  switch (count) {

			      case 1: if (tempToken.equals("C")) menu_text .append(",Redirect Order");
			               else if (tempToken.equals("N")) menu_text.append(",");break;

			      case 2: if (tempToken.equals("N")) menu_text.append(",");
			               else if (tempToken.equals("S")) {menu_text.append(",Send Out");sent_out_flag = "S";}
			               else if (tempToken.equals("R")) {menu_text.append(",,Receive Results");sent_out_flag = "R";}
						   break;

			      case 3: if (tempToken.equals("N")) sent_out_flag = "";
			               else if (tempToken.equals("Y") && (sent_out_flag.equals("S"))) sent_out_flag = "S";
						   else if (tempToken.equals("Y") && (sent_out_flag.equals("R"))) sent_out_flag = "R";
						   else sent_out_flag = "";break;
			  }
			  count++;

			}*/
	

		/*StringTokenizer replaceTokenizer = new StringTokenizer(menu_text.toString(),",");
		String tempReplaceToken="";

		if(replaceTokenizer.countTokens()==0)
			replace_text=",,'+getLabel('eOR.Replace.label','OR')+'";
		else if(replaceTokenizer.countTokens()==1){
			tempReplaceToken = replaceTokenizer.nextToken();
			if(tempReplaceToken.equals("Redirect Order") )
				replace_text=",'+getLabel('eOR.Replace.label','OR')+'";
			else if(tempReplaceToken.equals("Send Out"))
				replace_text=",'+getLabel('eOR.Replace.label','OR')+'";
			else if(tempReplaceToken.equals("Receive Results"))
				replace_text="'+getLabel('eOR.Replace.label','OR')+'";
		}else if(replaceTokenizer.countTokens()==2){
			replaceTokenizer.nextToken();
			tempReplaceToken = replaceTokenizer.nextToken();
			if(tempReplaceToken.equals("Send Out"))
				replace_text=",'+getLabel('eOR.Replace.label','OR')+'";
			else if(tempReplaceToken.equals("Receive Results"))
				replace_text="'+getLabel('eOR.Replace.label','OR')+'";
		
		}*/
		
 		//if (result_applicable_yn.equals("Y") || (result_applicable_yn.equals("N") && complete_date_time.equals(""))) {
			/*if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}
			else{
				slClassValue = "QRYODD";
			}*/
			slClassValue="gridData";
          if(!(tmp_ord_cat.equals(grpCheckValue)))
		{
			

		%>
		<%--<Script>alert('<%=group_by%>')</Script>--%>
        <tr>
			<%if ((group_by.equals("") || group_by.equals("D"))&& isSiteSpecificBillStatus) {%>
            <td class=columnheader colspan=6> <%=com.ehis.util.DateUtils.convertDate(row_details[17],"DMY","en",localeName)%></td>
            <%tmp_ord_cat = (String)row_details[17];
            }else if (group_by.equals("") || group_by.equals("D")) {%>
            <td class=columnheader colspan=5> <%=com.ehis.util.DateUtils.convertDate(row_details[17],"DMY","en",localeName)%></td>
            <%tmp_ord_cat = (String)row_details[17];
            }%>
			
            <%if (group_by.equals("P") && isSiteSpecificBillStatus) {%>
            <td class=columnheader colspan=6> <%=row_details[3]%></td>
             <%tmp_ord_cat = (String)row_details[11];
            }else if (group_by.equals("P")) {%>
            <td class=columnheader colspan=5> <%=row_details[3]%></td>
             <%tmp_ord_cat = (String)row_details[11];
            }%>
			
            <%if (group_by.equals("C") && isSiteSpecificBillStatus) {%>
            <td class=columnheader colspan=6> <%=row_details[6]%></td>
             <%tmp_ord_cat = (String)row_details[5];
            }else if (group_by.equals("C")) {%>
            <td class=columnheader colspan=5> <%=row_details[6]%></td>
             <%tmp_ord_cat = (String)row_details[5];
            }%>

            <%if (group_by.equals("T") && isSiteSpecificBillStatus) {%>
            <td class=columnheader colspan=6> <%=row_details[8]%></td>
           <%tmp_ord_cat = (String)row_details[7];
            }else if (group_by.equals("T")) {%>
            <td class=columnheader colspan=5> <%=row_details[8]%></td>
           <%tmp_ord_cat = (String)row_details[7];
            }%>

            <%if (group_by.equals("L") && isSiteSpecificBillStatus) {%>
            <td class=columnheader colspan=6> <%=(((String)row_details[18]).equals("") && ((String)row_details[19]).equals(""))? "Others" : location + "/" + (String)row_details[13]%></td>
        
               <% tmp_ord_cat = (String)row_details[18]+"/"+(String)row_details[13];
            }else if (group_by.equals("L")) {%>
            <td class=columnheader colspan=5> <%=(((String)row_details[18]).equals("") && ((String)row_details[19]).equals(""))? "Others" : location + "/" + (String)row_details[13]%></td>
        
               <% tmp_ord_cat = (String)row_details[18]+"/"+(String)row_details[13];
            }%>

            <%if (group_by.equals("U") && isSiteSpecificBillStatus) {%>
            <td class=columnheader colspan=6> <%=row_details[1]%></td>
             <%tmp_ord_cat = (String)row_details[1];
            }else if (group_by.equals("U")) {%>
            <td class=columnheader colspan=5> <%=row_details[1]%></td>
             <%tmp_ord_cat = (String)row_details[1];
            }%>

            <%if (group_by.equals("O")) {%>            
            <td class=columnheader colspan=6> <%=row_details[2]%></td>
             <%tmp_ord_cat = (String)row_details[2];
            }else if (group_by.equals("O")) {%>            
            <td class=columnheader colspan=5> <%=row_details[2]%></td>
             <%tmp_ord_cat = (String)row_details[2];
            }%>

		</tr>
		<%}%>
	
  
		<%
		String [] colorString = {"X","X","X"};
		String color_string = "";
		  /*if (can_view_by.equals("L")) {
		      color_string = bean.getColorCodings(facility_id,row_details[9],row_details[21],row_details[20]);
		  } else {
		      color_string = bean.getColorCodings(facility_id,row_details[9],"","");
		  }*/
		  StringTokenizer colorTokenizer = new StringTokenizer(color_string,",");
            int index = 0;
            while(colorTokenizer.hasMoreTokens()) {
                String tempToken = colorTokenizer.nextToken();
                if (tempToken.equals("#800080"))
                    colorString[index] = "QRY1";
                else if (tempToken.equals("#008080"))
                    colorString[index] = "QRY2";
                else if (tempToken.equals("#A52A2A"))
                    colorString[index] = "QRY3";
                else if (tempToken.equals("#FF0000"))
                    colorString[index] = "QRY4";
                else if (tempToken.equals("#40E0D0"))
                    colorString[index] = "QRY5";
                else if (tempToken.equals("#FF8C00"))
                    colorString[index] = "QRY6";
                else if (tempToken.equals("#CD5C5C"))
                    colorString[index] = "QRY7";
                else if (tempToken.equals("X"))
                    colorString[index] = slClassValue;
                index++;
            }
        
			
			//String [] record 	= bean.getProcedureCode(row_details[9]);
				//bill_yn				= bean.checkForNull(record[4],"");
				//charge_type_applicable= bean.checkForNull(record[5],"");
				//bill_yn="Y";
				//charge_type_applicable="M";
			/*if (!row_details[12].equalsIgnoreCase("C")) {				
				result_type			= bean.checkForNull(record[0],"");
				procedure_code		= bean.checkForNull(record[1],"");
				proc_code_scheme	= bean.checkForNull(record[2],"");
				auto_report_yn		= bean.checkForNull(record[3],"");
			}*/
			//procedure_code		= bean.checkForNull(record[1],"");
			//proc_code_scheme	= bean.checkForNull(record[2],"");
			//auto_report_yn		= bean.checkForNull(record[3],"");
			sex = row_details[14];
			if(row_details[1].equals("U")){
				fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
			}else if(row_details[1].equals("S")){
				fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
				imageTag = "<img src=\"../images/StatOrders.gif\" width=\"26\" height=\"24\" border=0 alt=\"Stat\">";
			}else{
				fontValue = "<font size=1 color=black><b>";
			}
			
			//Result_Type = bean.getResultType(row_details[9]);
			//discr_msr_id = bean.checkForNull(Result_Type[1],"");
			
/**
	modified by Deepa on 13/05/2010 for IN021020
	added dob to the function displayToolTip to handle multiple reference range
**/	
		
			%>
			<tr>			
			<td width='' id='orderctl<%=i%>' class='gridDataBlue' style='cursor:pointer' nowrap  onClick="displayToolTip('<%=menuText%>','<%=row_details[6]%>', '<%=row_details[9]%>', '<%=row_details[16]%>','<%=sex%>','<%=patient_id%>','<%=procedure_code%>','<%=row_details[15]%>','<%=row_details[5]%>','<%=row_details[10]%>','<%=order_line_num%>','<%=row_details[29]%>','<%=performed_only%>','<%=row_details[30]%>','<%=row_details[31]%>','<%=row_details[32]%>','<%=sent_out_flag%>','<%=row_details[7]%>','<%=row_details[1]%>','<%=row_details[18]%>','<%=row_details[19]%>','<%=java.net.URLEncoder.encode(row_details[3])%>','<%=java.net.URLEncoder.encode(discr_msr_id)%>','<%=proc_code_scheme%>',this,'imgArrow<%=i%>','<%=bean.checkForNull(row_details[35],"")%>','<%=row_details[26]%>','<%=bean.checkForNull(row_details[38],"")%>')"    onMouseOver="hideToolTip(this,'imgArrow<%=i%>','<%=i%>')"><%=com.ehis.util.DateUtils.convertDate(row_details[0],"DMYHM","en",localeName)%><img align='right' src="../../eCommon/images/inactiveArrow.gif" name="imgArrow<%=i%>" id="imgArrow<%=i%>" style="margin-top: 7px;"></td>
          	<td class='<%=slClassValue%>' width='' nowrap> <%=fontValue%> <%=row_details[1]%>  <%=imageTag%> </td>
			<%
				if(row_details[2].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])row_details[2].split("!~!");
					String order_detail ="";
					String[] strtitle = null;
					for(int s=0;s<str.length;s++)
					{
						if(str[s].indexOf("$$RD##")!=-1)
						{
							String line_order = (String)str[s];
							strtitle  =line_order.split("::");
							String titleText = "";
							if(strtitle[1].length()>0)
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
							}
							else
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
							}
							strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
							order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
						}
						else
						{
							order_detail = order_detail+str[s]+", ";
						}
					}
					row_details[2]  = order_detail;
					if(row_details[2].lastIndexOf(",") ==((row_details[2].length())-2))
					{
						row_details[2] = row_details[2] .substring(0,((row_details[2].length())-2));
					}
				}
				if(row_details[2].indexOf("!~!")!=-1)
				{
					row_details[2] =row_details[2].replace("!~!",",");
				}
			%>
			<td class='<%=slClassValue%>' width='' nowrap> <a class="gridLink" href='#' onClick="callMenuFunctions('View','<%=row_details[6]%>','<%=row_details[9]%>','<%=row_details[16]%>','<%=sex%>','<%=patient_id%>','<%=procedure_code%>','<%=row_details[15]%>','<%=row_details[33]%>','<%=proc_code_scheme%>','','','','','','','','','','','','','','<%=row_details[38]%>')"><%=row_details[2]%></a><%if(row_details[34].equals("Y")){%><IMG SRC="../images/Alert.gif" WIDTH="27" HEIGHT="36" BORDER=0 ALT="Alert"><%}%> </td>
			<td class='<%=slClassValue%>' width='' wrap><%=row_details[3]%></td>
			<!-- 19112 Start.-->
			<%
			String billingStatus = row_details[40];
			if("B".equals(row_details[40]))
				billingStatus	= "Billed&nbsp;<img src='../../eOR/images/Billed.png' border='0'  title='Billed'/>";
			else if("U".equals(row_details[40]))
				billingStatus	= "Unbilled&nbsp;<img src='../../eOR/images/Unbilled.png' border='0'  title='Unbilled'/>";
			
			if(isSiteSpecificBillStatus && !"".equals(billingStatus))
			{
			%>		
			<td width='' nowrap class='<%=slClassValue%>'>&nbsp;&nbsp;&nbsp;&nbsp;<%=billingStatus%></td>
			<%
			}else if(isSiteSpecificBillStatus)
			{
			%>
			<td width='' nowrap class='<%=slClassValue%>'>&nbsp;</td>	
			<%
			}
			%>
			<!-- 19112 End.-->
			
			<td class='<%=slClassValue%>' width='' nowrap> <%=row_details[4]%> 
			<!-- Added BY Arvind --->
			<%
				
			if(performed_only.equals("Y") && !row_details[38].equals("")){%>
			<br>
			<%
				
				
				StringBuffer forward_desc=new StringBuffer();
				String forward_to_id = "";
				String modified_by_id = "";
				StringBuffer modify_desc=new StringBuffer();
				StringBuffer error_desc=new StringBuffer();				
				//--[IN033488]
				String forwardDescYN = "N";
				String modifyDescYN = "N";
				String errorDescYN = "N";
				//--[IN033488]
				
				ArrayList notesStatus = bean.getLatestStatus(row_details[38],facility_id,localeName);
				forward_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels"));
				forward_desc.append(" ");
				forward_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels"));
				forward_desc.append(" ");

				error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
				error_desc.append(" ");
				error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
				error_desc.append(" ");
				modify_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels"));
				modify_desc.append(" ");
				modify_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
				modify_desc.append(" ");
				
				if (notesStatus != null && notesStatus.size()>0){
					for (int j=0;j< notesStatus.size();j++){
							String[] latestStatus = (String[])notesStatus.get(j);
						if (latestStatus != null && latestStatus.length>0){
							if(latestStatus[1].equals("SP")){							
								
								if(!forward_to_id.equals( latestStatus[6])){
									forward_to_id = latestStatus[6];
									forward_desc.append(latestStatus[5]);
									forwardDescYN = "Y"; //--[IN033488]
								}
								forward_desc.append(",");
							}if(latestStatus[1].equals("FS"))	{								
								forward_desc.append(latestStatus[4]);								
								forward_desc.append(", ");
								forwardDescYN = "Y"; //--[IN033488]
							}if(latestStatus[1].equals("ER"))	{
								error_desc.append(latestStatus[0]);
								error_desc.append(", ");
								errorDescYN = "Y"; //--[IN033488]
							}if((latestStatus[1].equals("RV")) && (latestStatus[2].equals("CO")))	{									
								if(!modified_by_id.equals(latestStatus[3]))
								{
									modified_by_id = latestStatus[3];
									modify_desc.append(latestStatus[0]);	
									modifyDescYN = "Y"; //--[IN033488]
								}								
								modify_desc.append(", ");					
							}
						}
					}
				}
				//--[IN033488] Modified 		- Start		
				if (forwardDescYN.equals("Y"))
				{	forward_desc.delete(forward_desc.length()-1,forward_desc.length());					
					%>
					 <img title='<%=forward_desc%>' src="../../eCA/images/ForwardNotes.gif"/>
		<%		}if (errorDescYN.equals("Y"))
				{
					error_desc.delete(error_desc.length()-2,error_desc.length());			
					%>
					 <img title='<%=error_desc%>' src="../../eCA/images/MarkError.gif"/>
		<%		}if (modifyDescYN.equals("Y"))
				{
						
						modify_desc.delete(modify_desc.length()-2,modify_desc.length());			
					%>
					 <img title='<%=modify_desc%>' src="../../eCA/images/modify1.gif"/>
		<%		}//--[IN033488] Modified 	-End
				}
				%>	
			</td>
			<input type='hidden' name='procedure_code<%=i%>' id='procedure_code<%=i%>' value='<%=procedure_code%>'>
			<input type='hidden' name='result_type<%=i%>' id='result_type<%=i%>' value='<%=result_type%>'>
			<input type='hidden' name='instrn_type<%=i%>' id='instrn_type<%=i%>' value='<%=row_details[39]%>'>
		</tr>
	<%i++;
    }%>
</table>
</div>
 <% 
	}%>
	
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value="<%=to%>">
	<Input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
	<Input type="hidden" name="can_location_type" id="can_location_type" value="<%=can_location_type%>">
	<Input type="hidden" name="can_location" id="can_location" value="<%=can_location%>">
	<Input type="hidden" name="can_order_category" id="can_order_category" value="<%=can_order_category%>">
	<Input type="hidden" name="can_single_multi" id="can_single_multi" value="<%=can_single_multi%>">
	<Input type="hidden" name="can_priority" id="can_priority" value="<%=can_priority%>">
	<Input type="hidden" name="can_date_from" id="can_date_from" value="<%=can_date_from%>">
	<Input type="hidden" name="can_date_to" id="can_date_to" value="<%=can_date_to%>">
	<Input type="hidden" name="can_patient_id" id="can_patient_id" value="<%=can_patient_id%>">
	<Input type="hidden" name="can_order_id" id="can_order_id" value="<%=can_order_id%>">
	<Input type="hidden" name="can_encounter_id" id="can_encounter_id" value="<%=can_encounter_id%>">
	<Input type="hidden" name="can_patient_id_found" id="can_patient_id_found" value="<%=can_patient_id_found%>">
	<Input type="hidden" name="can_order_type" id="can_order_type" value="<%=can_order_type%>">
	<Input type="hidden" name="can_performing_location_code" id="can_performing_location_code" value="<%=can_performing_location_code%>">
	<Input type="hidden" name="can_task_status" id="can_task_status" value="<%=can_task_status%>">
	<Input type="hidden" name="can_specimen_no" id="can_specimen_no" value="<%=can_specimen_no%>">
	<Input type='hidden' name='accession_num' id='accession_num' value=''>
	<input type='hidden' name='note_signed' id='note_signed' value=''>
	<input type='hidden' name='total_recs' id='total_recs' value="<%=i%>">
	<input type='hidden' name='patient_id_found' id='patient_id_found' value="<%=patient_id_found%>">
	<input type='hidden' name='group_by' id='group_by' value="<%=group_by%>">
	<input type='hidden' name='from_ca' id='from_ca' value="<%=from_ca%>">
	<input type='hidden' name='location' id='location' value="<%=can_location%>">
	<input type='hidden' name='single_multi' id='single_multi' value="<%=can_single_multi%>">
	<input type='hidden' name='priority' id='priority' value="<%=can_priority%>">
	<input type='hidden' name='date_from' id='date_from' value="<%=can_date_from%>">
	<input type='hidden' name='date_to' id='date_to' value="<%=can_date_to%>">
	<input type='hidden' name='order_id' id='order_id' value="<%=can_order_id%>">
	<input type='hidden' name='patient_id' id='patient_id' value="<%=can_patient_id%>">
	<input type='hidden' name='encounter_id' id='encounter_id' value="<%=can_encounter_id%>">
   	<input type='hidden' name='order_type' id='order_type' value="<%=can_order_type%>">
   	<input type='hidden' name='performing_location_code' id='performing_location_code' value="<%=can_performing_location_code%>">
   	<input type='hidden' name='view_by' id='view_by' value="<%=can_view_by%>">
  	<input type='hidden' name='specimen_no' id='specimen_no' value="<%=can_specimen_no%>">
  	<input type='hidden' name='catalog_desc' id='catalog_desc' value="<%=request.getParameter("catalog_desc")%>">
  	<input type='hidden' name='task_status' id='task_status' value="<%=request.getParameter("task_status")%>">
  	<input type='hidden' name='source_type' id='source_type' value="<%=request.getParameter("source_type")%>">
  	<input type='hidden' name='peforming_location_code' id='peforming_location_code' value="<%=request.getParameter("peforming_location_code")%>">
  	<input type='hidden' name='source_location' id='source_location' value="<%=request.getParameter("source_location")%>">
  	<input type='hidden' name='search_criteria' id='search_criteria' value="<%=request.getParameter("search_criteria")%>">
  	<input type='hidden' name='activity_type' id='activity_type' value="<%=request.getParameter("activity_type")%>">

	<Input type="hidden" name="can_catalog_desc" id="can_catalog_desc" value="<%=can_catalog_desc%>">
	<Input type="hidden" name="can_search_criteria" id="can_search_criteria" value="<%=can_search_criteria%>">
	<Input type="hidden" name="can_source_location_type" id="can_source_location_type" value="<%=can_source_location_type%>">
	<Input type="hidden" name="can_source_locn" id="can_source_locn" value="<%=can_source_locn%>">
	<Input type="hidden" name="can_group_by" id="can_group_by" value="<%=can_group_by%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<input type="hidden" name="performed_only" id="performed_only" value="<%=performed_only%>">
	<input type="hidden" name="period_mod_rslt_completed" id="period_mod_rslt_completed" value="<%=period_mod_rslt_completed%>">
	<input type="hidden" name="by_24hrs_yn" id="by_24hrs_yn" value="<%=by_24hrs_yn%>">
	<script>
			//if(parent.parent.ResultReportingHeader.document.getElementById("tableheader")==null)
			//{
				//setTimeout("alignHeading();",300);
			//}
			//else 
				//alignHeading();
	</script>
</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; left: 227px; top: 40px; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
					</td>
				</tr>
			</table>
		</div>
</body>
<script>
if(parent.parent.ResultReportingSearch)
parent.parent.ResultReportingSearch.document.result_reporting_search.search_btn.disabled= false;
else 
parent.parent.parent.ResultReportingSearch.document.result_reporting_search.search_btn.disabled= false;
	</script>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>


