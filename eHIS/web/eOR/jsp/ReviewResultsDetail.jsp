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
Date       	  Edit History  Name        Description
-----------------------------------------------------------------------
?             100         	?            created	
05/07/2012    IN033610      Chowminya G	 Add Notification Alert in summary 								 
09/10/2012 	  IN035654		Nijithas	 Attachment icon we get tool tip as �X-ray�. It should be "Result"		
03/06/2013	  EMG   		Chowminya G	  PACS LIVE issue	 
22/06/2013    IN041006		Chowminya G	  Review Results->Image hyperlink not displayed	
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/09/2014  IN050936		Chowminya										None of the order retrieving any image from RIS/PACS but already having order image in PACS
26/02/2018  IN066119		Raja S		26/02/2018		Ramesh G		ML-MMOH-CRF-1024
07/06/2018	IN067651		Raja S		07/06/2018		Ramesh G		GHL-SCF-1338
-----------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../js/ReviewResults.js"></script>
 	<script language="JavaScript" src="../../eCA/js/CAOpenExternalApplication.js"></script>

	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<script>
		function alignWidth() {
			var last=eval(document.getElementById('detailTab').rows.length)-1;
				if(document.getElementById('detailTab')!=null) {
					for(i=0;i <document.getElementById('detailTab').rows[last].cells.length;i++) {
						var wid=document.getElementById('detailTab').rows[last].cells[i].offsetWidth;
						var wid1= parent.ReviewResultsHeader.document.getElementById('titleTab').rows[0].cells[i].offsetWidth;
						if(eval(wid1) <eval(wid)){
							parent.ReviewResultsHeader.document.getElementById('titleTab').rows[0].cells[i].width=wid;
						} else {
							document.getElementById('detailTab').rows[last].cells[i].width = wid1;
						}
					}
				}
			}

	</script>
	 
</head>
<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()">     
<%
	
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;



	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";


	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
    String user_id = (String)session.getValue("login_user");

	if(resp_id== null)resp_id = "";
	if (user_id == null) user_id = "";


//	out.println(">"+practitioner_id+"<<br>");
//	out.println(">"+resp_id+"<");

	String priority		= CommonBean.checkForNull((String)request.getParameter("priority"));
	String normal_ind = CommonBean.checkForNull((String)request.getParameter("normalcy_ind"));
	String result_type	= CommonBean.checkForNull((String)request.getParameter("result_type"));

	String patientId	= CommonBean.checkForNull((String)request.getParameter("patientId"));
	String event_class	= CommonBean.checkForNull((String)request.getParameter("event_class"));

	String group_by		= CommonBean.checkForNull((String)request.getParameter("groupby"));

	String patient_class		= CommonBean.checkForNull((String)request.getParameter("patient_class"));
	String ca_normalcy_ind		= CommonBean.checkForNull((String)request.getParameter("ca_normalcy_ind"));

	String modal                = CommonBean.checkForNull((String)request.getParameter("modal"));
	String period_from                = CommonBean.checkForNull((String)request.getParameter("period_from"));
	String period_to                = CommonBean.checkForNull((String)request.getParameter("period_to"));
	String get_task_applicability   = CommonBean.checkForNull((String)request.getParameter("get_task_applicability"));
	//out.println("<script>alert('in jsp,period_from="+period_from+"');</script>");
	//out.println("<script>alert('in jsp,period_to="+period_to+"');</script>");
	ArrayList allValues = new ArrayList();

	String total_query_records  = "0";
	String from	 = CommonBean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = CommonBean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);

		//IN066119 starts
		String fac_id= (String) session.getValue("facility_id");//IN066119
		String bean_id1 = "Or_ViewOrder" ;
		String bean_name1 = "eOR.ViewOrder";
		ViewOrder vbean = (ViewOrder)getBeanObject( bean_id1, bean_name1,request ) ;
		String hideSpecimenType = "N";
		HashMap orParamFac = new HashMap();
		String mainGrpDisable ="";
		Connection con = null;
		int j = 1;
	try{
		con =  ConnectionManager.getConnection(request);
		orParamFac=vbean.orParamFacility(con, fac_id);
		hideSpecimenType = (String)orParamFac.get("HIDE_SPECIMENTYPE");
		//IN066119 ends
		//Added for IN067651 starts
		boolean isPracSiteSpecific = false;
		isPracSiteSpecific=eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");
		//Added for IN067651 starts
/* Mandatory checks end */

	/* Initialize Function specific start */
	ReviewResults bean = (ReviewResults)getBeanObject( bean_id, bean_name ,  request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	if (practitioner_id == null) {
	   String [] practitionerDetails = (String[])bean.getPractitionerDetails(user_id);
	   practitioner_id = practitionerDetails[0];
	}

	if(practitioner_id == null)practitioner_id = "";

	//allValues		= bean.getDetails(practitioner_id,priority,normal_ind,result_type,resp_id,patientId,event_class);
		//out.println("<script>alert('=group_by=="+group_by+"=event_class===="+event_class+"===');</script>");

	//out.println("practitioner_id"+practitioner_id+"priority"+priority+"normal_ind"+normal_ind+"result_type"+result_type+"resp_id"+resp_id+"patientId"+patientId+"event_class"+event_class+"group_by"+group_by+"patient_class"+patient_class+"ca_normalcy_ind"+ca_normalcy_ind+"modal"+modal+"period_from"+period_from+	"period_to"+period_to+"start"+start+"end"+end);

	allValues		= bean.getDetails(practitioner_id,priority,normal_ind,result_type,resp_id,patientId,event_class,group_by,patient_class,ca_normalcy_ind,modal,period_from,period_to,get_task_applicability,start,end);

	String result_data[] = (String[])bean.getAbnormalCondition();


	String high_str			= result_data[0];
	String low_str			= result_data[1];
	String abn_str			= result_data[2];

	String crit_str			= result_data[3];
	String crit_high_str	= result_data[4];
	String crit_low_str		= result_data[5];
	String tooltip			= "";
	String result			= "";

/* Initialize Function specific end */
//out.println("allValues.size() " + allValues.size());
	if(allValues.size() == 0){
%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
			parent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =false;
			parent.ReviewResultsHeader.location.href = "../../eCommon/html/blank.html"
			parent.ReviewResultsResult.location.href = "../../eCommon/html/blank.html"
			parent.ReviewResultsBtn.location.href = "../../eCommon/html/blank.html"

		</script>

<%	}%>
<%if(allValues.size() != 0){%>
<script>focusOnResult();</script>
<%}%>
<form name='review_results_dtl' id='review_results_dtl'  action="../../eOR/jsp/ReviewResultsDetail.jsp" method="post">
<table cellpadding=3 cellspacing=0 border=1 width="100%" id='detailTab' class="grid" >
<%

	String 	episode_details				= "";
	String temp_episode_details         = "";
	String 	event						= "";
	String 	contr_sys_event_code		= "";
	//String 	order_type_code				= "";
	String 	order_id					= "";
	String 	accession_num				= "";
	String 	hist_rec_type				= "";
	String 	contr_sys_id				= "";
	//String 	pract_id					= "";
	String 	review_types				= "";
	String 	review_type					= "";
	String 	hist_data_type				= "";
	//String 	reported_by					= "";
	String 	reported_at					= "";
	//String 	authorized_by_id			= "";
	//String 	event_auth_date_time		= "";
	String 	result_num					= "";
	String 	result_num_uom				= "";
	String 	result_str					= "";
	String 	normal_low					= "";
	String 	normal_high					= "";
	String 	normalcy_ind				= "";
	String 	ext_image_obj_id			= "";
	String 	ext_image_appl_id			= "";
	String 	practitioner_name			= "";
	String 	create_date_time			= "";
	String  status						= "";
    String  ordering_practitioner		= "";
    //Added by Siva Kumar
    String  hist_rec_type_desc          = "";
    String  event_class_desc            = "";
    String  event_group_desc            = "";
	String  temp_res_event_header       = "";
	String  temp_event_group_desc       = "";
    String	temp_order_id				= "";
    String  patient_id                  = "";
    String  event_code                  = "";
    String  event_group                 = "";
    String  event_class_code            = "";
    String  requested_by_pract_id            = "";
    String  requested_by_pract_name            = "";
	String  ext_image_upld_id            = "";//IN041006
    //End of Addition
	
	StringBuffer disp_value = new StringBuffer();
	String slClassValue = "";
	String[] record  = null;
	
	for(int i=0; i<allValues.size(); i++){
		record  = (String[])allValues.get(i);
		if (record[0].indexOf(",")!=-1){

			StringTokenizer fieldTokenizer = new StringTokenizer(record[0],",");
			record[0]="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();
		 
		   if ((tempToken.indexOf('/'))==1)
			{
			  String tempstr=tempToken.substring(1);
			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
			record[0]=record[0].concat(tempToken).concat(",");
			  
         

		}
					 }
					
		
		episode_details				=CommonBean.checkForNull(record[0]);
		event						=CommonBean.checkForNull(record[1]);
		contr_sys_event_code		=CommonBean.checkForNull(record[2]);
		//order_type_code				=CommonBean.checkForNull(record[3]);
		order_id					=CommonBean.checkForNull(record[4]);
		accession_num				=CommonBean.checkForNull(record[5]);
		hist_rec_type				=CommonBean.checkForNull(record[6]);
		contr_sys_id				=CommonBean.checkForNull(record[7]);
		//pract_id					=CommonBean.checkForNull(record[8]);
		review_types				=CommonBean.checkForNull(record[9]);
		review_type					=CommonBean.checkForNull(record[10]);
		hist_data_type				=CommonBean.checkForNull(record[11]);
		//reported_by					=CommonBean.checkForNull(record[12]);
		reported_at					=CommonBean.checkForNull(record[13]);
		reported_at = com.ehis.util.DateUtils.convertDate(reported_at,"DMYHM","en",localeName);// for thai date validations. convert date from english to local language(thai)
		//authorized_by_id			=CommonBean.checkForNull(record[14]);
		//event_auth_date_time		=CommonBean.checkForNull(record[15]);
		result_num					=CommonBean.checkForNull(record[16]);
		result_num_uom				=CommonBean.checkForNull(record[17]);
		result_str					=CommonBean.checkForNull(record[18]);
		normal_low					=CommonBean.checkForNull(record[19]);
		normal_high					=CommonBean.checkForNull(record[20]);
		normalcy_ind				=CommonBean.checkForNull(record[21]);
		ext_image_obj_id			=CommonBean.checkForNull(record[22]);
		ext_image_appl_id			=CommonBean.checkForNull(record[23]);
		//IN067651 changes starts
		//practitioner_name			=CommonBean.checkForNull(record[24]);
		if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
		{
			practitioner_name			=CommonBean.checkForNull(record[41]);
		}else{
			practitioner_name			=CommonBean.checkForNull(record[24]);
		}
		//IN067651 changes ends
		create_date_time			=CommonBean.checkForNull(record[26]);
		create_date_time = com.ehis.util.DateUtils.convertDate(create_date_time,"DMYHM","en",localeName);// for thai date validations. convert date from english to local language(thai)
		status						=CommonBean.checkForNull(record[27]);
		ordering_practitioner		=CommonBean.checkForNull(record[28]);
		hist_rec_type_desc          =CommonBean.checkForNull(record[29]);
		event_class_desc            =CommonBean.checkForNull(record[30]);
		event_group_desc            =CommonBean.checkForNull(record[31]);
		patient_id                  = CommonBean.checkForNull(record[32]);
        event_code                  = CommonBean.checkForNull(record[33]);
        event_group                 = CommonBean.checkForNull(record[34]);
        event_class_code            = CommonBean.checkForNull(record[35]);
		result			            = CommonBean.checkForNull(record[36]);
		//out.println("result"+result+"*");
		requested_by_pract_id	    = CommonBean.checkForNull(record[37]);
		requested_by_pract_name     = CommonBean.checkForNull(record[38]);
		ext_image_upld_id			= CommonBean.checkForNull(record[39]);//IN041006
		if(review_type.equalsIgnoreCase("O"))
		{
			review_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingPractitioner.label","common_labels");
		}
			else if (review_type.equalsIgnoreCase("A"))
		{
			review_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels");
		}
		if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(high_str) || normalcy_ind.equalsIgnoreCase(low_str) || normalcy_ind.equalsIgnoreCase(abn_str) ))
			normalcy_ind = "<FONT COLOR='RED' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"<br></FONT>";  //<a href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' align=center></img></a>
		else if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
			normalcy_ind= "<FONT COLOR='MAGENTA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalAbnormal.label","or_labels")+"<br></FONT>";
			 //<a href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' align=center></img></a>
		else if(normalcy_ind!=null && normalcy_ind.equals("."))
			normalcy_ind = "<FONT COLOR='BLACK' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"<br></FONT>";  //<a href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' align=center></img></a>
		else
			normalcy_ind = "<FONT COLOR='RED' ></FONT>";   //<a href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' align=center></img></a>
		//out.println(">"+normalcy_ind+"<");
		if(!status.equals("") && status.equals("C"))
		{
			slClassValue = "ORSTATUSPARTIAL";
			tooltip      = "This result has been Modified";
		}
		else
		{
			tooltip = "";
			/*if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}*/
			slClassValue="gridData";
		}  

		if(i==0){
					//if(record[39] != null)//IN041006
				if(record[40] != null)//IN041006	
					total_query_records = bean.checkForNull((String)record[40],"0");//Changed from 39 to 40
				 %>
				 <!--
					<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from" value= "<%=start%>" /> 
					<jsp:param name ="to" value= "<%=end%>" />	
					<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
					<jsp:param name ="check_box_name" value= "chk" />					 
					<jsp:param name ="form_name" value= "review_results_dtl" />  
					</jsp:include>				
				-->
				<%				
		}
	disp_value = new StringBuffer();
 	disp_value.append("&nbsp;");
	//IN066119 start
	if("Y".equals(hideSpecimenType))
		result_str="";
	//IN066119 ends
		if(hist_data_type.trim().equals("NUM")){

			disp_value.append(result_num + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;"+"("+normal_low+"-"+normal_high+")"+" "+normalcy_ind);
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value .append( "<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComments.label","or_labels")+" </a>");
			}
			//disp_value = disp_value +"<br>"+(result_str == null ? "" : result_str);
//result = bean.getClobData(accession_num);
			if(result!=null && !result.equals(""))
			{
 
				disp_value.append( "<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		} else
		if(hist_data_type.trim().equals("STR")){
			//disp_value  = result_str+" "+normalcy_ind;
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComments.label","or_labels")+" </a>");
			}
			disp_value.append(" "+normalcy_ind);
//result = bean.getClobData(accession_num);
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		} else
		if(hist_data_type.trim().equals("TXT")){
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComments.label","or_labels")+" </a>");
			}
			disp_value.append(" "+normalcy_ind);
//result = bean.getClobData(accession_num);
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobData('"+accession_num+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
			//disp_value  = "<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0>";
		}else
	 	if(hist_data_type.trim().equals("HTM")){
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewComments('"+i+"')\"> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComments.label","or_labels")+" </a>");
			}
			disp_value.append(" "+normalcy_ind);
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<br><a class='gridLink' href=\"javascript:viewClobDataHtm('"+accession_num+"','"+hist_data_type+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0 align=center></a>");
			}
		}
	/*	if ((ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_appl_id!=null && !ext_image_appl_id.equals("")) ) {
			disp_value.append("<br><a class='gridLink' href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"')\"> ");
		//disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='XRAY' align=center></a>");//IN035654
		disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result' align=center></a>");//IN035654
			
		}*/ //Commentted for EMG
		//Added docul condition for EMG
		if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
		{
			if(!("DOCUL").equals(ext_image_appl_id)) 
			{
				if(!ext_image_upld_id.equals("SPEC_IMG")) //IN041006 Added if condition 
				{
					//IN050936 included patient_id
					disp_value.append("<br><a class='gridLink' href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+ext_image_obj_id+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\"> ");
					disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result' align=center></a>");//IN035654
				}	
			}
			else
			{
				//IN050936 included patient_id
				disp_value.append("<br><a class='gridLink' href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\"> ");
				disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result' align=center></a>");//IN035654
			}
											
		}		

		disp_value.append("<a class='gridLink' href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' title='Previous Results' border='0' align=center></img></a>");

		if(status.equals("P"))
			disp_value.append("<font color='red'>(Preliminary)</font>");
%>
  <input type=hidden name='hist_rec_type<%=i%>' id='hist_rec_type<%=i%>' value='<%=hist_rec_type%>'>
		<input type=hidden name='contr_sys_id<%=i%>' id='contr_sys_id<%=i%>' value='<%=contr_sys_id%>'>
		<input type=hidden name='contr_sys_event_code<%=i%>' id='contr_sys_event_code<%=i%>' value='<%=contr_sys_event_code%>'>
		<input type=hidden name='accession_num<%=i%>' id='accession_num<%=i%>' value='<%=accession_num%>'>
		<input type=hidden name='review_type<%=i%>' id='review_type<%=i%>' value='<%=review_types%>'>
		<input type=hidden name='result_str<%=i%>' id='result_str<%=i%>' value='<%=result_str%>'>
		<input type=hidden name='create_date_time<%=i%>' id='create_date_time<%=i%>' value='<%=create_date_time%>'>
		<input type=hidden name='patient_id<%=i%>' id='patient_id<%=i%>' value='<%=patient_id%>'>
		<input type=hidden name='event_code<%=i%>' id='event_code<%=i%>' value='<%=event_code%>'>
		<input type=hidden name='event_group<%=i%>' id='event_group<%=i%>' value='<%=event_group%>'>
		<input type=hidden name='event_class_code<%=i%>' id='event_class_code<%=i%>' value='<%=event_class_code%>'>
		<input type=hidden name='normalcy_ind<%=i%>' id='normalcy_ind<%=i%>' value='<%=(record[21]==null)?"":record[21]%>'>
		<input type=hidden name='normal_ind<%=i%>' id='normal_ind<%=i%>' value='<%=normal_ind%>'> 
		<% //IN033610 included normal_ind above
			if (!group_by.equals("E")) {
        if (!temp_episode_details.equals(episode_details)) { %>
		<tr><Td colspan='9' class ='PATIENTLINECOLOROTHLANG'><%=episode_details%></Td></tr>
		<%
		  temp_episode_details = episode_details;
		  temp_res_event_header = "";
		  }
    if (!temp_res_event_header.equals(hist_rec_type_desc+"/"+event_class_desc)) {%>
		 <tr> <Td colspan='9' class ='CAGROUPHEADING'><%=hist_rec_type_desc+"/"+event_class_desc%></Td></tr>
		  <%
         temp_res_event_header =  hist_rec_type_desc+"/"+event_class_desc;
         }
       %>
       <tr>
			<%if (event_group_desc.equals("")) {//out.println("here");
				//IN066119 starts
	   			j++;
				temp_event_group_desc="";
				temp_order_id ="";
				//IN066119 ends
			%>
                 <td width='7%' id='status<%=i%>' class='<%=slClassValue%>' title = "<%=tooltip%>"><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick="clickChk('<%=i%>')" value=""><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='review_remarks<%=i%>' value=''></td>
			     <td width='22%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=event%></font></td>
			     <td width='9.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=disp_value%></font></td>
			     <td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=practitioner_name%></font></td>
			     <%--<td width='13%' class='<%=//slClassValue%>' title = "<%=//tooltip%>"><font size=1><%=//episode_details%></font></td>--%>
			     <td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=reported_at%></font> </td>
			     <td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=review_type%> </font></td>
	   		     <td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=ordering_practitioner%></font></td>
	   		    <!--  <td id="remark_td<%=i%>" width='5.5%' class='<%=slClassValue%>' title = "<%=tooltip%>">&nbsp;</td> -->
				<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=requested_by_pract_name%></font></td>
			<%}else {//out.println("here in elseif");%>
			        <!--<table cellpadding=0 cellspacing=0 border=1 width="98%" id='innerTab' >-->
                    <%if ((!temp_event_group_desc.equals(event_group_desc))|| (!temp_order_id.equals(order_id))) {    // || (!temp_order_id.equals(order_id))
                    		j++;	//IN066119 added
                    %>
					<TR>
			        <TR ><TD><input type=checkbox name='chkgrp<%=j%>' id='chkgrp<%=j%>' id='maingrp<%=j%>' onClick="checkgroup('<%=j%>')" <%=mainGrpDisable%>  value='chk<%=i%>'  ></TD><!--IN066119 added check box-->
			        <TD colspan='9' >
                    <Font size=1><%=event_group_desc%></Font>
                    </TD>
                    </TR>

			        <TR>
			           <%-- <td width='7%' class='<%=slClassValue%>' title = "<%=tooltip%>" > <input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value="" ><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='review_remarks<%=i%>' value=''></td> //commented for IN066119--%>
			            <td width='7%' class='<%=slClassValue%>' title = "<%=tooltip%>" > <input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" id='subgrp<%=j%><%=i%>' value="" ><input type='hidden' name='headval<%=i%>' id='headval<%=i%>' id='headval<%=i%>' value='<%=j%>'><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='review_remarks<%=i%>' id='subgrp_remarks<%=j%><%=i%>' value=''></td><!-- Added for IN066119-->
			            <td width='22%' class='<%=slClassValue%>' title = "<%=tooltip%>" ><font size=1><%=event%></font></td>
			            <td width='9.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=disp_value%></font></td>
			            <td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=practitioner_name%></font></td>

			            <%--<td width='13%' class='<%=//slClassValue%>' title = "<%=//tooltip%>"><font size=1><%=//episode_details%></font></td>--%>
			            <td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=reported_at%></font> </td>
			            <td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=review_type%> </font></td>
			            <td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=ordering_practitioner%></font></td>
			           <!--  <td width='5.5%' id="remark_td<%=i%>" class='<%=slClassValue%>' title ="<%=tooltip%>" >&nbsp;</td> -->
						<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=requested_by_pract_name%></font>&nbsp;</td>
			        </TR>
                   <%temp_order_id=order_id;temp_event_group_desc = event_group_desc;}else {%>
                   <TR>
			            <%--<td width='7%' class='<%=slClassValue%>' title = "<%=tooltip%>"> <input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value="" ><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='review_remarks<%=i%>' value=''></td> //Commented for IN066119 --%>
			            <td width='7%' class='<%=slClassValue%>' title = "<%=tooltip%>"> <input type=checkbox id='subgrp<%=j%><%=i%>' name='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value="" ><input type='hidden' name='headval<%=i%>' id='headval<%=i%>' id='headval<%=i%>' value='<%=j%>'><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='review_remarks<%=i%>' id='subgrp_remarks<%=j%><%=i%>' value=''></td><!-- IN066119 Modified-->
			            <td width='22%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=event%></font></td>
			            <td width='9.5' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=disp_value%></font></td>
			            <td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=practitioner_name%></font></td>

			            <%--<td width='13%' class='<%=//slClassValue%>' title = "<%=//tooltip%>"><font size=1><%=//episode_details%></font></td>--%>
			            <td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=reported_at%></font> </td>
			            <td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=review_type%> </font></td>
			            <td width='14%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=ordering_practitioner%></font></td>
			           <!--  <td width='5.5%' id="remark_td<%=i%>"  class='<%=slClassValue%>' title = "<%=tooltip%>">&nbsp;</td> -->
						<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=requested_by_pract_name%></font>&nbsp;</td>
			        </TR>
                   <%}%>
			<!--</Table>--><%}%>
		</tr>


<%  	} else {%>
		<TR>
			<td width='8.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick="javascript:clickChk('<%=i%>')" value="" ><label id="remark_td<%=i%>"></label><input type='hidden' name='review_remarks<%=i%>' id='review_remarks<%=i%>' value=''></td>
			<td width='22%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=event%></font></td>
			<td width='9.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=disp_value%></font></td>
			<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=practitioner_name%></font></td>
			<td width='8%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=reported_at%></font></td>
			<td width='14.5%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=episode_details%></font></td>
			<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=review_type%> </font></td>
			<td width='10%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=ordering_practitioner%></font></td>
			<!-- <td width='4%' id="remark_td<%=i%>" class='<%=slClassValue%>' title = "<%=tooltip%>">&nbsp;</td> -->
			<td width='9%' class='<%=slClassValue%>' title = "<%=tooltip%>"><font size=1><%=requested_by_pract_name%></font></td>
		</TR>
    <%}
	}
%>
</table>
<!-- Next, Prev --> 
	<input type="hidden" name="from" id="from" value="<%=from%>" >
	<input type="hidden" name="to" id="to" value="<%=to%>" >
<!-- Next, Prev Till here--> 

<input type=hidden name='requested_by_pract_id' id='requested_by_pract_id' value='<%=requested_by_pract_id%>'>
<input type=hidden name='requested_by_pract_name' id='requested_by_pract_name' value='<%=requested_by_pract_name%>'>
<input type=hidden name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
<input type=hidden name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">

<input type="hidden" name="priority" id="priority" value="<%=(String)request.getParameter("priority")%>">
<input type="hidden" name="normalcy_ind" id="normalcy_ind" value="<%=(String)request.getParameter("normalcy_ind")%>">
<input type="hidden" name="result_type" id="result_type" value="<%=(String)request.getParameter("result_type")%>">
<input type="hidden" name="patientId" id="patientId" value="<%=(String)request.getParameter("patientId")%>">
<input type="hidden" name="event_class" id="event_class" value="<%=(String)request.getParameter("event_class")%>">
<input type="hidden" name="groupby" id="groupby" value="<%=(String)request.getParameter("groupby")%>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=(String)request.getParameter("patient_class")%>">
<input type="hidden" name="ca_normalcy_ind" id="ca_normalcy_ind" value="<%=(String)request.getParameter("ca_normalcy_ind")%>">
<input type="hidden" name="modal" id="modal" value="<%=(String)request.getParameter("modal")%>">
<input type="hidden" name="period_from" id="period_from" value="<%=(String)request.getParameter("period_from")%>">
<input type="hidden" name="period_to" id="period_to" value="<%=(String)request.getParameter("period_to")%>">
</form>
<script>
	if(parent.ReviewResultsHeader.document.getElementById('titleTab')!=null) {
		alignWidth();
	}
	parent.ReviewResultsSearch.document.review_result_search.search_btn.disabled =false;

//alert("111"+parent.ReviewResultsSearch.document.review_result_search.remark_td0.innerHTML);
//parent.ReviewResultsSearch.document.review_result_search.remark_td0.innerHTML="ragha";
//alert("sss"+parent.ReviewResultsSearch.document.review_result_search.remark_td0.innerHTML);

</script>
</body>
</html>
<%putObjectInBean(bean_id,bean,request);
} 
catch(Exception ex) {
	System.out.println(" 1084. ReviewResultsDetail.jsp ===> " + ex.getMessage());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

