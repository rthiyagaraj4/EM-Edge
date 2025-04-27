<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------
Date       	  Edit History  Name        	Description
-----------------------------------------------------------------------
?             100         	?           	created
12/11/2012	  EMG			Chowminya G	   PACS LIVE	
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/09/2014  IN050936		Chowminya										None of the order retrieving any image from RIS/PACS but already having order image in PACS
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ViewResults.js"></script>
 	<script language="JavaScript" src="../../eCA/js/CAOpenExternalApplication.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<script>
		function alignWidth()
		{
			var last=eval(document.getElementById('detailTab').rows.length)-1;
			if(document.getElementById('detailTab')!=null)
			{
				for(i=0;i <document.getElementById('detailTab').rows(last).cells.length;i++)
				{
					var wid=document.getElementById('detailTab').rows(last).cells(i).offsetWidth;
					var wid1= parent.ViewResultsHeader.document.getElementById('titleTab').rows(0).cells(i).offsetWidth;
					if(eval(wid1) <eval(wid))
						parent.ViewResultsHeader.document.getElementById('titleTab').rows(0).cells(i).width=wid;
					else
						document.getElementById('detailTab').rows(last).cells(i).width = wid1;
				}
			}
		}
	</script>
	 
</head>
<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()">     
<%
	String mode							= "1";

	String bean_id						= "Or_ViewResults" ;
	String bean_name					= "eOR.ViewResults";


	String practitioner_id				= (String)session.getValue("ca_practitioner_id");
	String resp_id						= (String)session.getValue("responsibility_id");
    String user_id						= (String)session.getValue("login_user");
	
	if(resp_id== null)resp_id = "";
	if (user_id == null) user_id = "";

	String priority						= CommonBean.checkForNull((String)request.getParameter("priority"));
	String normal_ind					= CommonBean.checkForNull((String)request.getParameter("normalcy_ind"));
	String result_type					= CommonBean.checkForNull((String)request.getParameter("result_type"));
	String patientId					= CommonBean.checkForNull((String)request.getParameter("patientId"));
	String encounter_id					= CommonBean.checkForNull((String)request.getParameter("encounter_id"));
	String encounter_chk				= CommonBean.checkForNull((String)request.getParameter("encounter_chk"));
	String group_by						= CommonBean.checkForNull((String)request.getParameter("groupby"));
	System.out.println(" group_by " + group_by);
	String modal						= CommonBean.checkForNull((String)request.getParameter("modal"));
	String period_from					= CommonBean.checkForNull((String)request.getParameter("period_from"));
	String period_to					= CommonBean.checkForNull((String)request.getParameter("period_to"));
	String facilityid					= CommonBean.checkForNull((String)request.getParameter("facilityid"));
	String from							= CommonBean.checkForNull(request.getParameter( "from" ),"1") ;
	String to							= CommonBean.checkForNull(request.getParameter( "to" ),"7") ;
	String selectmode=CommonBean.checkForNull((String)request.getParameter("selectmode"));
 	int start							= Integer.parseInt(from);
	int end								= Integer.parseInt(to);

	ArrayList allValues					= new ArrayList();

	String total_query_records			= "0";
	int total_records					= 0;

	ViewResults bean					= (ViewResults)getBeanObject( bean_id, bean_name, request) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	if (practitioner_id == null)
	{
	   String [] practitionerDetails = (String[])bean.getPractitionerDetails(user_id);
	   practitioner_id = practitionerDetails[0];
	}

	if(practitioner_id == null)practitioner_id = "";
	
	allValues		= bean.getDetails(practitioner_id,priority,normal_ind,result_type,resp_id,patientId,encounter_id,encounter_chk,group_by,modal,period_from,period_to,start,end,facilityid);

	String result_data[]				= (String[])bean.getAbnormalCondition();

	String high_str						= result_data[0];
	String low_str						= result_data[1];
	String abn_str						= result_data[2];
	String crit_str						= result_data[3];
	String crit_high_str				= result_data[4];
	String crit_low_str					= result_data[5];
	String tooltip						= "";
	String result						= "";

	if(allValues.size() == 0)
	{
%>
		<script>
			alert('APP-002415 Query caused No records to be retrieved...');
			parent.ViewResultsSearch.document.view_results_search.search_btn.disabled =false;
			parent.ViewResultsHeader.location.href = "../../eCommon/html/blank.html"
			parent.ViewResultsDetail.location.href = "../../eCommon/html/blank.html"
		</script>
<%	
	}
%>

<form name='view_results_dtl' id='view_results_dtl'  action="../../eOR/jsp/ViewResultsDetail.jsp" method="post">
<table cellpadding=0 cellspacing=0 border=1 width="100%" id='detailTab' class="grid">
<%

	String 	event_short_desc			= "";
	String  event_code					= "";
	String 	contr_sys_event_code		= "";
	String 	accession_num				= "";
	String 	hist_rec_type				= "";
	String 	hist_rec_type_desc				= "";
	String 	text_exisits				= "";
	String 	contr_sys_id				= "";
	String 	hist_data_type				= "";
	String 	reporting_date				= "";
	String 	resulting_date				= "";
	String 	result_num					= "";
	String 	result_num_uom				= "";
	String 	result_str					= "";
	String 	normal_low					= "";
	String 	normal_high					= "";
	String 	critical_low				= "";
	String 	critical_high				= "";
	String 	normalcy_ind				= "";
	String 	ext_image_obj_id			= "";
	String 	ext_image_appl_id			= "";
	String  reporting_practitioner		= "";
    String  parent_short_desc           = "";
	String  child_desc					= "";
	//String  temp_parent_short_desc		= "";
	//String  temp_hist_rec_type		= "";
	//String  temp_reporting_practitioner		= "";
	//String  temp_resulting_date		= "";
	String  event_group					= "";
	String  event_class					= "";
	String  slClassValue				= "";
	String[] record						= null;

	

	for(int i=0; i<allValues.size(); i++)
	{
		StringBuffer  disp_value			= new StringBuffer();
		record							= (String[])allValues.get(i);

		result							= CommonBean.checkForNull(record[0]);
		event_short_desc				= CommonBean.checkForNull(record[1]);
		event_code						= CommonBean.checkForNull(record[2]);
		result_num						= CommonBean.checkForNull(record[3]);
		result_num_uom					= CommonBean.checkForNull(record[4]);
		result_str						= CommonBean.checkForNull(record[5]);
		reporting_date					= CommonBean.checkForNull(record[6]);
		resulting_date					= CommonBean.checkForNull(record[7]);
		normalcy_ind					= CommonBean.checkForNull(record[8]);
		normal_low						= CommonBean.checkForNull(record[9]);
		normal_high						= CommonBean.checkForNull(record[10]);
		critical_low					= CommonBean.checkForNull(record[11]);
		critical_high					= CommonBean.checkForNull(record[12]);
		parent_short_desc				= CommonBean.checkForNull(record[13]);
		child_desc						= CommonBean.checkForNull(record[14]);
		hist_data_type					= CommonBean.checkForNull(record[15]);
		ext_image_obj_id				= CommonBean.checkForNull(record[17]);
		ext_image_appl_id				= CommonBean.checkForNull(record[18]);
		reporting_practitioner			= CommonBean.checkForNull(record[19]);
		hist_rec_type					= CommonBean.checkForNull(record[20]);
		accession_num					= CommonBean.checkForNull(record[21]);
		contr_sys_event_code			= CommonBean.checkForNull(record[22]);
		contr_sys_id					= CommonBean.checkForNull(record[23]);
		event_class						= CommonBean.checkForNull(record[24]);
		event_group						= CommonBean.checkForNull(record[25]);
		hist_rec_type_desc				= CommonBean.checkForNull(record[27]);
		text_exisits				= CommonBean.checkForNull(record[28]);
		if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(high_str) || normalcy_ind.equalsIgnoreCase(low_str) || normalcy_ind.equalsIgnoreCase(abn_str) ))
			normalcy_ind = "<FONT COLOR='RED' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"<br></FONT>";
		else if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
			normalcy_ind = "<FONT COLOR='MAGENTA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalAbnormal.label","or_labels")+"<br></FONT>";
		else if(normalcy_ind!=null && !normalcy_ind.equals(""))
			normalcy_ind = "<FONT COLOR='RED' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"<br></FONT>"; 
		else
			normalcy_ind = "&nbsp;<FONT COLOR='RED' ></FONT>";  


		tooltip = "";
		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";
	
		if(i==0)
		{
			if(record[26] != null)
				total_query_records = bean.checkForNull((String)record[26],"0");

			total_records = Integer.parseInt(total_query_records);
 %>
			<div align='right'>
<%
				if ( !(start <= 1) )  
		  			out.println("<A class='gridLink' align='right' HREF='../../eOR/jsp/ViewResultsDetail.jsp?from="+(start-7)+"&to="+(end-7)+"&normalcy_ind="+normal_ind+"&result_type="+result_type+"&patientId="+patientId+"&encounter_id="+encounter_id+"&encounter_chk="+encounter_chk+"&groupby="+group_by+"&modal="+modal+"&period_from="+period_from+"&period_to="+period_to+"&facilityid="+facilityid+"' text-decoration='none'>Previous</A>");
 				if( !( (start+7) > total_records)) 
 					out.println("<A class='gridLink' align='right' HREF='../../eOR/jsp/ViewResultsDetail.jsp?from="+(start+7)+"&to="+(end+7)+"&normalcy_ind="+normal_ind+"&result_type="+result_type+"&patientId="+patientId+"&encounter_id="+encounter_id+"&encounter_chk="+encounter_chk+"&groupby="+group_by+"&modal="+modal+"&period_from="+period_from+"&period_to="+period_to+"&facilityid="+facilityid+"' text-decoration='none'>Next</A>");

				out.println("&nbsp;&nbsp;");
%>
			</div>

								
<%				
		}
		
		if(hist_data_type.equals("NUM"))
				{
					disp_value.append("<tr><td width='100%'>"+child_desc+":"+result_num+"nbsp;"+result_num_uom+"("+normal_low+"~"+normal_high+")</td>");
					disp_value.append("</tr>");

					if(!result_str.equals(""))
					{
						disp_value.append("<tr><td><br>Comments:"+result_str+"</td></tr>");
					}
					if(text_exisits.equals("Y"))
					{
						disp_value.append("<tr><td><br>Result Text:"+bean.returnClobValue(hist_rec_type,contr_sys_id,accession_num,contr_sys_event_code)+"</td></tr>");		
					}

		}
		else if(hist_data_type.trim().equals("STR"))
		{
			disp_value.append("<tr><td width='100%'>"+child_desc+":"+result_num+"nbsp;"+result_num_uom+"("+normal_low+"~"+normal_high+")</td>");
					disp_value.append("</tr>");

					if(!result_str.equals(""))
					{
						disp_value.append("<tr><td><br>Comments:"+result_str+"</td></tr>");
					}
					if(text_exisits.equals("Y"))
					{
						disp_value.append("<tr><td><br>Result Text:"+bean.returnClobValue(hist_rec_type,contr_sys_id,accession_num,contr_sys_event_code)+"</td></tr>");						
						
					}
		}
		else if(hist_data_type.trim().equals("TXT"))
		{
					disp_value.append("<tr><td width='100%'>"+child_desc+":"+result_num+"nbsp;"+result_num_uom+"("+normal_low+"~"+normal_high+")</td>");
					disp_value.append("</tr>");

					if(!result_str.equals(""))
					{
						disp_value.append("<tr><td><br>Comments:"+result_str+"</td></tr>");
					}
					if(text_exisits.equals("Y"))
					{
						disp_value.append(bean.returnClobValue(hist_rec_type,contr_sys_id,accession_num,contr_sys_event_code)+"</td></tr>");			
						//out.println("</td><td width='20%'>&nbsp;</td></tr>");						
						
					}

				}
		else if(hist_data_type.trim().equals("HTM"))
		{
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value.append("<tr><td><br>Comments:"+result_str+"</td></tr>");
			}
			disp_value.append(" "+normalcy_ind);
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<a class='gridLink'  href=\"javascript:viewClobDataHtm('"+accession_num+"','"+hist_data_type+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
			}
		}
		else
		{
			disp_value.append("&nbsp;");
		}

		//Added docul condition for EMG
		if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
		{
			if(!("DOCUL").equals(ext_image_appl_id)) 
			{
				//IN050936 included patient_id	
				disp_value.append("<br><a class='gridLink'  href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+ext_image_obj_id+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patientId+"')\"> ");
				disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result'></a>");
			}
			else
			{
				//IN050936 included patient_id	
				disp_value.append("<br><a class='gridLink'  href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patientId+"')\"> ");
				disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result'></a>");
			}
								
		}

		disp_value.append("<a class='gridLink' href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' title='Previous Results' border='0'></img>&nbsp;</a>");
%>
		<input type=hidden name='hist_rec_type<%=i%>' id='hist_rec_type<%=i%>' value='<%=hist_rec_type%>'>
		<input type=hidden name='contr_sys_id<%=i%>' id='contr_sys_id<%=i%>' value='<%=contr_sys_id%>'>
		<input type=hidden name='contr_sys_event_code<%=i%>' id='contr_sys_event_code<%=i%>' value='<%=contr_sys_event_code%>'>
		<input type=hidden name='accession_num<%=i%>' id='accession_num<%=i%>' value='<%=accession_num%>'>
		<input type=hidden name='result_str<%=i%>' id='result_str<%=i%>' value='<%=result_str%>'>
		<input type=hidden name='event_code<%=i%>' id='event_code<%=i%>' value='<%=event_code%>'>
		<input type=hidden name='event_class<%=i%>' id='event_class<%=i%>' value='<%=event_class%>'>
		<input type=hidden name='event_group<%=i%>' id='event_group<%=i%>' value='<%=event_group%>'>
<% 
	if(selectmode.equals("")){%>
			<tr>
			<td width='15%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=reporting_date%></font></td>
			<td width='15%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=hist_rec_type_desc%></font></td>
			<td width='70%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><table border=0 cellspacing=0 cellpadding=0 width='100%' ><td width='100%' class='<%=slClassValue%>' title = "<%=tooltip%>"><%=disp_value.toString()%></td></table></font></td>
			</tr>
	<%}else{%>
			<tr>
			<td width='15%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=reporting_date%></font></td>
			<td width='85%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><table border=0 cellspacing=0 cellpadding=0 width='100%' ><td width='100%' class='<%=slClassValue%>' title = "<%=tooltip%>"><%=disp_value.toString()%></td></table></font></td>
			</tr>
	<%}

	}
%>

</table>
<input type="hidden" name="from" id="from" value="<%=from%>" >
<input type="hidden" name="to" id="to" value="<%=to%>" >
<input type="hidden" name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
<input type="hidden" name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="encounter_chk" id="encounter_chk" value="<%=encounter_chk%>">
<input type="hidden" name="priority" id="priority" value="<%=(String)request.getParameter("priority")%>">
<input type="hidden" name="normalcy_ind" id="normalcy_ind" value="<%=(String)request.getParameter("normalcy_ind")%>">
<input type="hidden" name="groupby" id="groupby" value="<%=(String)request.getParameter("groupby")%>">
<input type="hidden" name="modal" id="modal" value="<%=(String)request.getParameter("modal")%>">
<input type="hidden" name="period_from" id="period_from" value="<%=(String)request.getParameter("period_from")%>">
<input type="hidden" name="period_to" id="period_to" value="<%=(String)request.getParameter("period_to")%>">
</form>
<script>
	if(parent.ViewResultsHeader.document.getElementById('titleTab')!=null) {
		alignWidth();
	}
	parent.ViewResultsSearch.document.view_results_search.search_btn.disabled =false;

</script>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

