<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name            Description
--------------------------------------------------------------------------------------------------------------
?             100            ?               created
02/11/2011    IN29375       Menaka      	CA >> Record consent
											Function pending consent is show code of clinic but system should be show the clinic name same as register order function.
20/09/2012    IN034888      Chowminya G     CRF-CA- Bru-HIMS-CRF-121/01-Only One Orderable is displayed
24/09/2012    IN034904      Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal
24/04/2013	  IN029323		Karthi L		System displays External order details as "null" and unable to Record the Result for that order.	
22/07/2013    IN041421      Chowminya G     Special characters - While record consent "Internal Server Error" is displayed
20/08/2013	  IN038797	   Karthi L		To include the field (Filter) of "Speciality" in the function of "Pending Consent" in Practitioner's homepage
19/12/2013    IN045800	    Dinesh T		CA>Chart Summary>Orders>Place a radiology order which requires consent to be recorded>Pending/Record Consent>Click on 'Radiology' category>System throws an error message.
21/10/2015    IN057196	    Ramesh G		Recording Of Consent Form
---------------------------------------------------------------------------------------------------------------
--> 
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,eOR.*,java.net.URLEncoder,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
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
<script language="JavaScript" src="../js/ConsentOrder.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
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

	function callMouseOver(obj)	
	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';
	}

	function callOnMouseOut(obj)
	{
		obj.className = 'contextMenuItem';
	}

	function resizeWindow(orderctlHDR)
	{
		var orderctlHDR1 = orderctlHDR.id;
		var wdth = document.getElementById(orderctlHDR1).offsetWidth;
		var hght1 = document.getElementById(orderctlHDR1).offsetHeight;				
		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;	
		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight		
		var z = bodwidth- (event.x + wdth);				
		var x 	  = event.x;
		var y 	  = event.y;	
		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);
		if(x<bodwidth)
		{
			x= wdth1;			
		}
		else
		{			
			x = getPos(orderctlHDR).x;
		}
		if(y<bodheight)
		{			
			y = hght;				
		}
		else
		{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
		}	
		y += 65;
		document.getElementById("tooltiplayer").style.posLeft= x+"px";
		document.getElementById("tooltiplayer").style.posTop = y+"px";
		document.getElementById("tooltiplayer").style.visibility='visible'
	}
	//--[IN034904]	- passing p/m consentLinenum
	function displayToolTip(val,val1,orderId,sex,patient_id,patient_class,source_type,source_code,encounter_id, order_type_code,location_type,location_code,priority,ord_line_num,orderctlHDR,imgObj,consentLinenum) 
	{			
		callMouseOverOnTD(orderctlHDR,imgObj);
		buildTable (val,val1,orderId,sex,patient_id,patient_class,source_type,source_code,encounter_id,order_type_code,location_type,location_code,priority,ord_line_num,consentLinenum)
		resizeWindow(orderctlHDR)
	}

	function buildTable(val,val1,orderId,sex,patient_id,patient_class,source_type,source_code,encounter_id,order_type_code,location_type,location_code,priority,ord_line_num,consentLinenum) 
	{
		var rowval   = val.split (",");
		var row      = ("View,Refusal,");
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
		for( var i=0; i<rowval.length; i++ ) 
		{
			var colval  = rowval[i]
			var colval1 = rowval1[i];
			if (colval != "")
			{
				tab_dat     += "<tr>"
				if(colval1 == "Reprint")
				{
					//tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:callAmmendFunctions('"+orderId+"','"+patient_id+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+escape(visit_adm_date)+"','"+iv_prep_yn+"')><B>"+colval+" </B></a></td>"
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a  class= 'contextMenuLink' href=javascript:callReprinting('"+orderId+"','"+patient_class+"','"+source_type+"','"+source_code+"')>"+colval+" </a></td>"
				}
				else
				{
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+escape(val1)+"','"+orderId+"','"+sex+"','"+patient_id+"','"+encounter_id+"','"+patient_class+"','"+order_type_code+"','"+location_type+"','"+location_code+"','"+priority+"','"+ord_line_num+"','"+consentLinenum+"')>"+colval+" </a></td>"
				}
				tab_dat     += "</tr> "
			}
		}
		tab_dat     += "</table> "
		document.getElementById("t").innerHTML = tab_dat;
	}	

	function moveFrame()
	{
		parent.ConsentOrdersBottomRight0.document.body.scrollLeft= document.body.scrollLeft;
	}

	function alignHeading()
	{
		if(parent.ConsentOrdersBottomRight0)
		{
			if(parent.ConsentOrdersBottomRight0.document.getElementById("TitleTab") != null) 
			{
				
				parent.ConsentOrdersBottomRight0.document.getElementById("TitleTab").width =	eval(document.getElementById("consent_table").offsetWidth);
				
				var last_row = eval(document.getElementById("consent_table").rows.length)-1;
				for (j=0; j < document.getElementById("consent_table").rows[last_row].cells.length; j++) 
				{
					var wid=eval(document.getElementById("consent_table").rows[last_row].cells[j].offsetWidth);
					if(parent.ConsentOrdersBottomRight0.document.getElementById("TitleTab").rows[0].cells[j] != null)
					{
						parent.ConsentOrdersBottomRight0.document.getElementById("TitleTab").rows[0].cells[j].width=wid;
					}
				}
			}
			else
			{
				setTimeout("alignHeading();",300);
			}
		}
	}
	</script>
	<STYLE TYPE="text/css">
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
   TD.TDHEADER
	{
	   BACKGROUND-COLOR: #404040;
	   COLOR: white ;
	   FONT-SIZE: 8pt;
	   FONT-WEIGHT: bolder;
	}
	</STYLE>
 	<%--End--%>	
</head>
<body  onscroll='processScroll()' onload='FocusFirstElement();alignHeading()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */

	try
	{
	 /*Added by kishore kumar N on 30-Oct-09  for CRF 15741*/
	String qryString = request.getQueryString()== null?"":request.getQueryString();
	/* ends here.*/
	
	String mode	   = "1" ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";	//String disabled = "" ;
//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String practitioner_name = (String)session.getValue("practitioner_name");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	String patientdetails="";
	//String[] allsess_vals = (String[])session.getValueNames();
//	for(int i=0; i<allsess_vals.length; i++)
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	String security_level = "";
	security_level = (String)session.getValue("security_level");
	if(security_level == null)
		security_level  = "1"; // needs to be replaced with session values	
	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String patientId		= request.getParameter( "patientId" );
	String period_from		= request.getParameter( "period_from" );
	String period_to		= request.getParameter( "period_to" );
	String consentRec_order_id = request.getParameter("consentRec_order_id")== null?"":request.getParameter("consentRec_order_id"); //IN057196
	String speciality_code  = request.getParameter( "speciality_code" )== null?"":request.getParameter( "speciality_code" ); //added for BRU-HIMS-CRF-359 [IN038797]
	String total_query_records  = "0";
	String function_id		= request.getParameter("function_id");
	StringBuffer con_id=new StringBuffer();
	StringBuffer con_stage=new StringBuffer();
	String encounter_dtls="";
	String consent_req_bef_order="";
	String consent_req_bef_regn="";
	String consentLinenum = "";//--[IN034904]

 	//int total_records = 0;
	if(function_id == null) function_id =""; else function_id = function_id.trim();
	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =" "; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =" "; else period_to = period_to.trim();
	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ;

	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
 	//if(from!=null && from.equals("1")) {
 	bean.clear() ;
	//}
	bean.setMode( mode ) ;
	bean.clearHash();	 
	String slClassValue = "";
	//String classValue = "";
	//int total = 0;
//	ArrayList StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,resp_id,priority,ord_cat,order_by,patientId) ;

	ArrayList StatusDetail = new ArrayList();
//	if(from!=null && from.equals("1")){
	//StatusDetail		   = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type) ; //commented for BRU-HIMS-CRF-359 [IN038797]	
	//IN057196 Start.
			//StatusDetail		   = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code) ; //added for BRU-HIMS-CRF-359 [IN038797]
			StatusDetail		   = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code, consentRec_order_id) ;
	//IN057196 End.				
	//bean.setDetails(StatusDetail);
	//}else{
	//StatusDetail=bean.getDetails();
	//}
	 ArrayList multiConsentList = new ArrayList();
	 ArrayList multiNonAssConsentList = new ArrayList();
	String[] multiConsentDtls = null;
	String order_catalog_code ="";
	String checkcolor="";	
	String curr_sys_date ="";
	//String last_week_date ="";
	//String curr_week_date ="";
	ArrayList sysdate = (ArrayList)bean.getSysDateTime();
	for(int i=0;i<sysdate.size();i++)
	{
		//last_week_date =  (String)sysdate.get(0);
		//curr_week_date =  (String)sysdate.get(1);
		curr_sys_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName);
	}
%>
<form name='consent_order_dtl' id='consent_order_dtl'  action="../../eOR/jsp/ConsentOrdersBottomRightDtl.jsp" method="post" >
<div id="divHeadSep" style="position: absolute;">
	<table cellpadding=0 cellspacing=0 border=1 width="100%" id='consent_table' class="grid">
		<tr id="heading">
		   <th width='3%' nowrap><fmt:message key="eOR.SNO.label" bundle="${or_labels}"/>&nbsp;&nbsp;</th><!-- added for multi consent on 04/05/2007 -->
			<td class=COLUMNHEADER width='17%'><fmt:message key="Common.Consent.label" bundle="${common_labels}"/></td>
			<td class=COLUMNHEADER  width='10%'><fmt:message key="Common.required.label" bundle="${common_labels}"/></td><!-- added for multi consent on 04/05/2007 -->
			<%
			if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals(""))
			{
			%>
				<td class=COLUMNHEADER width='15%'><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
			<%
			}
			if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals(""))
			{	
			%>
				<td class=COLUMNHEADER width='15%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<%
			}
			%>
			<td class=COLUMNHEADER width='18%'><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
			<td class=COLUMNHEADER width='20%'><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></td>
			<td class=COLUMNHEADER width='30%'><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
		</tr>
		<%
		String tmp_ord_cat = "";
		String tmp_pat_id = "";
		String tmp_urgency = "";
		String fontValue ="";
		String cont_order_ind = "";
		String ord_appr_by_user_id = "";
		String ord_appr_reqd_yn = "";
		String ord_consent_reqd_yn = "";
		String ord_consent_by_id = "";
		String location="";//IN29375
		StringBuffer recd_consent_id = null;
		int i= 0;
		int bo_cnt,br_cnt= 0;
		int con_bo_cnt,con_br_cnt= 0;
		int scon_bo_cnt,scon_br_cnt= 0;
		String stage_label = "";
		//String define_label = "Define";
		String define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Define.label","common_labels");	
		boolean stage_label_count = false;
		String tdClassValue = "";
		StringBuffer noteligible_consent_id = null;
		//ArrayList consentedList = new ArrayList();
		/*if(StatusDetail.size() < 7 || end > StatusDetail.size()) {
			end = StatusDetail.size();
		}	*/
		//for( int i=0 ; i< StatusDetail.size() ; i++ ) {
		for( int k=0 ; k< StatusDetail.size() ; k++ ) 
		{
			slClassValue="gridData";
			String slClassValueTmp = slClassValue;
			String[] record = (String[])StatusDetail.get(k);
			if(record[2].compareTo("R")==0)
			{
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}
			else if(record[2].compareTo("U")==0)
			{		 
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");	
			}
			else if(record[2].compareTo("S")==0)
			{
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
			}	
			if(k==0)
			{
				if(record[30] != null)//IN29375
					total_query_records = bean.checkForNull((String)record[30],"0");//IN29375
				if((Integer.parseInt(total_query_records)>0) || (start>1))
				{
				%>				
					<tr align="right">
						<td colspan="11">			
							<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="from" value="<%=start%>"/>
							<jsp:param name="to" value="<%=end%>"/>
							<jsp:param name="check_box_name" value="chk"/>
							<jsp:param name="total_size" value="<%=total_query_records%>"/>
							<jsp:param name="qryString" value="<%=qryString%>"/>
							<jsp:param name="form_name" value="consent_order_dtl"/>
							</jsp:include>
						</td>
					</tr>
				<%
				}				
				if(!priority.equals(" ") || !ord_cat.equals(" ") )
				{
					if(!(priority.equals(" ")))
					{
						if(priority.equals("U"))
						{
							out.println("<tr><td align=left class='ORRED' colspan=7>"+priority_desc+"</td>");
						}else if(priority.equals("S"))
						{
							out.println("<tr><td align=left class='ORBROWN' colspan=7>"+priority_desc+"</td>");
						}else if(priority.equals("R"))
						{
							out.println("<tr><th align=left colspan=7>"+priority_desc+"</td>");
						}
					}
					if(!(ord_cat.equals(" ")))
					{
						out.println("<tr><th align=left colspan=7>"+ord_cat_desc+"</td>");
					}					
				}
			}
			//String[] record = (String[])StatusDetail.get(i);
			cont_order_ind = (String)record[14];
			String sex1;
			sex1="";
			if (record[19].equalsIgnoreCase("M"))
			  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		  else if(record[19].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			patientdetails=record[20]+","+sex1+"/"+record[27]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[6];
			//IN29375 Starts
			if(record[10].equalsIgnoreCase("C"))
			{
						location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(record[10].equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}
			else if(record[10].equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}
			else if(record[10].equalsIgnoreCase("E"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			}
			// added for IN029323 - Start
			if(record[7] == null )
			{
				record[7] = "";
			}
			if(record[29] == null )
			{
				record[29] = "";
			}
			//IN029323 - End
			//encounter_dtls=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+record[7]+","+record[10]+"/"+record[11];
			encounter_dtls=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+record[7]+","+location+"/"+record[29];
			System.out.println("424 encounter_dtls===="+encounter_dtls);
			//IN29375 Ends
			//patientdetails=(String)record[11];
			//the following 2 if conditions are used to display in "group BY"
			if(patientId.trim().equals("") && !(tmp_pat_id.equals(record[6])))
			{
				if(!ord_cat.equals(" ") || !priority.equals(" ") )
					out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan=7 align=left><B> "+patientdetails+"</B></td></tr>");
				else
				out.println("<tr><th  colspan=7 style='border-right:0px' align=left><B> "+patientdetails+"</B></th>");
				tmp_pat_id = record[6];
				tmp_ord_cat="";tmp_urgency="";
			}
			if(patientId.trim().equals(""))
				tdClassValue = "CAHIGHERLEVELCOLOR" ;
			else
				tdClassValue = "TDHEADER" ;
			//format of order category or urgency
			if(!(tmp_ord_cat.equals(record[1])) && (!(order_by.equals(" ") ||(order_by.equals("P")))))
			{
				out.println("<tr><td class='"+tdClassValue+"' colspan=7 style='border-right:0px' align=left>"+record[1]+"</td>");
				tmp_ord_cat = record[1];				
			}
			if(!(tmp_urgency.equals(record[2])) && (!(order_by.equals(" ") ||(order_by.equals("O")))))
			{	
				out.println("<tr><td class='"+tdClassValue+"'  colspan=7 style='border-right:0px' align=left>"+record[2]+"</td>");
				tmp_urgency = record[2];				
			}
			ord_appr_by_user_id	 = (String)record[16];
			ord_appr_reqd_yn	 = (String)record[15];
			ord_consent_reqd_yn	 = (String)record[17];
			ord_consent_by_id	 = (String)record[18];
			//order_catalog_code	 ="MULTICONSE";// (String)record[29];
			order_catalog_code	=(String)record[24];
			stage_label			 = "";
			recd_consent_id		 = new StringBuffer();
			noteligible_consent_id = new StringBuffer();
		//	noteligible_consent_id = "";
			bo_cnt				 = 0;con_bo_cnt = 0;scon_bo_cnt=0;
			br_cnt				 = 0;con_br_cnt = 0;scon_br_cnt=0;
			stage_label_count	 = false;
			define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Define.label","common_labels");
			/*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/
			String multiConsentLine[] = new String[4];
			multiConsentLine=bean.MultiListConsentsLine((String)record[5],(String)record[25]);	consent_req_bef_order = (String) multiConsentLine[2];
			consent_req_bef_regn = (String) multiConsentLine[3];	/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/

			multiConsentDtls	 = bean.MultiListDtls(order_catalog_code, practitioner_id);

			
			multiConsentList	 = bean.MultiListConsentsdtl(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);
			if(multiConsentList.size()==0)
			{
				multiConsentList	 = bean.MultiListConsents(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);
			}
			multiNonAssConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);			
			%>
			<tr>
				<td class='<%=slClassValue%>' width='3%'><label class='label'><B><%=(i+1)%>.</B>&nbsp;</label></td>
				<input type="hidden" name="consent_form_list<%=i%>" id="consent_form_list<%=i%>" value="<%=multiConsentDtls[0]%>" >
				<td  width='17%' id="status<%=i%>" class='<%=slClassValue%>'><font size="1">
				<%if(multiConsentDtls != null && multiConsentList.size() > 0 )
					{
						int srl =0;
						for(int j=0;j<multiConsentList.size();j++)
						{
							String[] consentedarray = (String[])multiConsentList.get(j);
							if(consentedarray[10].equals("Y"))
							{
								//if(consentedarray[3].equals("A"))con_bo_cnt++;
								//if(consentedarray[3].equals("R"))con_br_cnt++;
								recd_consent_id.append(consentedarray[1]);
								recd_consent_id.append("~");
								//recd_consent_id += consentedarray[1] +"~" ;
								%>
								<A class="gridLink" HREF="javascript:showConsentReview('<%=consentedarray[1]%>','<%=consentedarray[2]%>', '<%=record[5]%>', '<%=record[25]%>','<%=consentedarray[11]%>')" title='Recorded  Consent' style="COLOR:#CC3300;"><B><%=++srl%>.<%=consentedarray[2]%></B></A><BR>								
								<!-- <script>consented_array["<%=j%>"] = "<%=consentedarray[1]%>";</script> -->
								<%	
							}
						}
					}else if(multiNonAssConsentList != null && multiNonAssConsentList.size() > 0 )
					{
						int srl =0;
						for(int j=0;j<multiNonAssConsentList.size();j++)
						{
							String[] consentedarray = (String[])multiNonAssConsentList.get(j);
							if(consentedarray[10].equals("Y"))
							{
								if(consentedarray[3].equals("A"))con_bo_cnt++;
								if(consentedarray[3].equals("R"))con_br_cnt++;

								recd_consent_id.append(consentedarray[1]);
								recd_consent_id.append("~");
								//recd_consent_id += consentedarray[1] +"~" ;
								%>
								<A class="gridLink"  HREF="javascript:showConsentReview('<%=consentedarray[1]%>','<%=consentedarray[2]%>', '<%=record[5]%>', '<%=record[25]%>','<%=consentedarray[11]%>')" title='Recorded  Consent' style="COLOR:#CC3300;"><B><%=++srl%>.<%=consentedarray[2]%></B></A><BR>							
						<!-- <script>consented_array["<%=j%>"] = "<%=consentedarray[1]%>";</script> -->
								<% 
							}
						}
					}
					if(multiConsentDtls[6].equals("N"))
					{
					%>	
						<input type="hidden" name="recd_consent_id<%=i%>" id="recd_consent_id<%=i%>" value=<%=recd_consent_id.toString()%>><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' value='' onClick="noPermission1('<%=i%>')"><A  class='gridLink' id='details<%=i%>'style="visibility:hidden" HREF="javascript:displayDetails('<%=i%>',true)" title="Preview Consent Form for <%=(record[9].substring(1,(record[9].length()-1)))%>"><font size="1"><!-- Details --><B><fmt:message key="Common.details.label" bundle="${common_labels}"/></B></A><label id='multi_consent<%=i%>' class='label'><font size=1 color=''>
					<%
					}
					else
					{
					%>
						<input type="hidden" name="recd_consent_id<%=i%>" id="recd_consent_id<%=i%>" value=<%=recd_consent_id.toString()%>><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' value='' onClick="displayDetails(<%=i%>,false)"><A  class='gridLink' id='details<%=i%>'style="visibility:hidden" HREF="javascript:displayDetails('<%=i%>',true)" title="Preview Consent Form for <%=(record[9].substring(1,(record[9].length()-1)))%>"><font size="1"><!-- Details --><B><fmt:message key="Common.details.label" bundle="${common_labels}"/></B></A><label id='multi_consent<%=i%>' class='label'><font size=1 color=''>
					<%
					}
					%><BR>
					<%if(multiConsentDtls != null && multiConsentDtls.length >0 )
					{
						stage_label = multiConsentDtls[4];					
						////if( multiConsentDtls[0].equals("F") && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1) || (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]) > 1) ) ){//changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
						if( multiConsentDtls[0].equals("F") && ( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1) || (Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn) > 1) ) )
						{
							stage_label_count = true;
							%>  
							<input type='hidden' name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="">
							<select style='font-size:8pt' name='consent_form_id<%=i%>' id='consent_form_id<%=i%>' onChange="chkConsented(this,'<%=i%>');clearConsents('<%=i%>','Select');"><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>								
							<%	
							if(multiConsentList.size() > 0)
							{
								for(int j=0;j<multiConsentList.size();j++)
								{
									String[] multiConsentValues = (String[])multiConsentList.get(j);									
									if(multiConsentValues[10].equals("Y"))
									{
										if(multiConsentValues[3].equals("A"))con_bo_cnt++;
										if(multiConsentValues[3].equals("R"))con_br_cnt++;
									}
									if(multiConsentValues[12].equals("N"))
									{
										//noteligible_consent_id  += multiConsentValues[1] +"~" ;
										noteligible_consent_id.append(multiConsentValues[1]);
										noteligible_consent_id.append("~");
									}
									//	if(multiConsentValues[9].equals("Y"))
									{
											if(multiConsentValues[3].equals("A"))bo_cnt++;
											if(multiConsentValues[3].equals("R"))br_cnt++;								
									%>										
											<option style='<%=((multiConsentValues[10].equals("Y"))? "background-color:#FFA8A8;color:#000000":"")%>' value='<%=multiConsentValues[1]%>' ><%=multiConsentValues[2]%><%=(multiConsentValues[12].equals("N"))? "  (*)":""%></option>								
									<%			
										//define_label = "View Consents";
										define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewConsents.label","or_labels");
									}
								}if(!(bo_cnt >0 || br_cnt >0))
								{
									out.println("<script>document.getElementById('consent_form_id'+i).style.visibility = 'hidden';</script>");
								}
							}
							else
							{
								out.println("<script>document.getElementById('consent_form_id'+i).style.visibility = 'hidden';</script>");
							}
							%>
							</select>
							<%
						}
						else if( multiConsentDtls[0].equals("F"))
						{ 
							if(!multiConsentDtls[5].equals("") && !multiConsentDtls[3].equals(""))
							{ 
								define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewConsents.label","or_labels");
								if(multiConsentDtls[6].equals("N"))
								{
									//noteligible_consent_id  += multiConsentDtls[3] +"~" ;
									noteligible_consent_id.append(multiConsentDtls[3]);
									noteligible_consent_id.append("~");
								}
								if(multiConsentDtls[6].equals("N"))
								{
								%>
									<A class="gridLink" HREF="javascript:noPermission()" title='Consent to be Recorded'><%=multiConsentDtls[5]%><%=multiConsentDtls[6].equals("N")?"(*)":""%></A>
								<%
								}
								else
								{
								%>
									<A class="gridLink" HREF="javascript:displayDetails('<%=i%>',true)" title='Consent to be Recorded'><%=multiConsentDtls[5]%><%=multiConsentDtls[6].equals("N")?"(*)":""%></A>
								<%
								}
								%>
							<input type='hidden' name="consent_form_id<%=i%>" id="consent_form_id<%=i%>" value="<%=multiConsentDtls[3]%>">
							<input type='hidden' name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="<%=multiConsentDtls[4]%>">							
							<%	
							}else if(multiConsentList.size() > 0)
							{
								for(int j=0;j<multiConsentList.size();j++)
								{
									String[] multiConsentValues = (String[])multiConsentList.get(j);											
									if(multiConsentValues[9].equals("Y") && !multiConsentValues[9].equals("Y"))
									{
										//define_label = "Redefine";
										define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
										if(multiConsentValues[12].equals("N"))
										{
											//	noteligible_consent_id  += multiConsentValues[1] +"~" ;
											noteligible_consent_id.append(multiConsentValues[1]);
											noteligible_consent_id.append("~");
										}
										if(multiConsentDtls[6].equals("N"))
										{
										%>
											<A class="gridLink" HREF="javascript:noPermission()" title='Consent to be Recorded'><%=multiConsentDtls[5]%><%=multiConsentDtls[6].equals("N")?"(*)":""%></A>
										<%
										}
										else if(multiConsentValues[12].equals("N"))
										{
										%>
											<A class="gridLink" HREF="javascript:noPermission()" title='Consent to be Recorded'><%=multiConsentValues[2]%><%=multiConsentValues[12].equals("N")?"(*)":""%></A>
										<%
										}
										else
										{
										%>	
											<A class="gridLink" HREF="javascript:displayDetails('<%=i%>',true)" title='Consent to be Recorded'><%=multiConsentValues[2]%><%=(multiConsentValues[12].equals("N"))? "(*)":""%></A>
										<%
										}
										%>
											<input type='hidden' name="consent_form_id<%=i%>" id="consent_form_id<%=i%>" value="<%=multiConsentValues[1]%>">
											<input type='hidden' name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="<%=multiConsentValues[3]%>">
										<%
									}
									else
									{
										if(multiConsentList.size() == 1)
										{
											multiConsentValues = (String[])multiConsentList.get(0);
											if(!multiConsentValues[1].equals("")&&!multiConsentValues[2].equals(""))
											{ 
												define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewConsents.label","or_labels");
												if(multiConsentValues[12].equals("N"))
												{
													//noteligible_consent_id  += multiConsentDtls[3] +"~" ;
													noteligible_consent_id.append(multiConsentValues[1]);
													noteligible_consent_id.append("~");
												}
												if(multiConsentValues[12].equals("N"))
												{
												%>
													<A class="gridLink" HREF="javascript:noPermission()" title='Consent to be Recorded'><%=multiConsentValues[2]%><%=multiConsentValues[12].equals("N")?"(*)":""%></A>
												<%
												}
												else
												{
												%>
													<A class="gridLink" HREF="javascript:displayDetails('<%=i%>',true)" title='Consent to be Recorded'><%=multiConsentValues[2]%><%=multiConsentValues[12].equals("N")?"(*)":""%></A>
												<%
												}
												%>
												<input type='hidden' name="consent_form_id<%=i%>" id="consent_form_id<%=i%>" value="<%=multiConsentValues[1]%>">
												<input type='hidden' name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="<%=multiConsentValues[2]%>">
											<%	
											}
										}
									}
								}	
							}
						}
						else if(multiConsentDtls[0].equals("V") &&( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1) || (Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn) > 1) ))
						{//changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008							
						%>
							<input type='hidden' name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="">
							<select style='font-size:8pt' name='consent_form_id<%=i%>' id='consent_form_id<%=i%>' onChange="chkConsented(this,'<%=i%>');reccheck(this,'<%=i%>');clearConsents('<%=i%>','Select');">
							<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>						
						<%	
							if(multiConsentList.size() > 0)
							{
								stage_label_count = true;	
								for(int j=0;j<multiConsentList.size();j++)
								{
									String[] multiConsentValues1 = (String[])multiConsentList.get(j);										
									if(multiConsentValues1[10].equals("Y"))
									{
											if(multiConsentValues1[3].equals("A"))scon_bo_cnt++;
											if(multiConsentValues1[3].equals("R"))scon_br_cnt++;
									}
								}
								/*if(scon_bo_cnt==Integer.parseInt(multiConsentDtls[1]))
								{
									 checkcolor="color";
								}
								if(scon_br_cnt==Integer.parseInt(multiConsentDtls[2]))
								{
									 checkcolor="color";
								}*/
								for(int j=0;j<multiConsentList.size();j++)
								{
									checkcolor="";
									String[] multiConsentValues = (String[])multiConsentList.get(j);
								
									if(multiConsentValues[10].equals("Y")){
										if(multiConsentValues[3].equals("A"))con_bo_cnt++;
										if(multiConsentValues[3].equals("R"))con_br_cnt++;
									}
									else
									{
										if(multiConsentValues[3].equals("A"))
										{
										////if(scon_bo_cnt==Integer.parseInt(multiConsentDtls[1]))////changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
											if(scon_bo_cnt==Integer.parseInt(consent_req_bef_order))
											{
												checkcolor="color";
											}
										}
										if(multiConsentValues[3].equals("R"))
										{
											////if(scon_br_cnt==Integer.parseInt(multiConsentDtls[2]))////changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
											if(scon_br_cnt==Integer.parseInt(consent_req_bef_regn))
											{
												checkcolor="color";
											}
										}
									}
									if(multiConsentValues[9].equals("Y"))
									{
										if(multiConsentValues[3].equals("A"))bo_cnt++;
										if(multiConsentValues[3].equals("R"))br_cnt++;
										if(multiConsentValues[12].equals("N"))
										{
											//noteligible_consent_id  += multiConsentValues[1] +"~" ;
											noteligible_consent_id.append(multiConsentValues[1]);
											noteligible_consent_id.append("~");
										}
										con_id.append(multiConsentValues[1]).append("~");
										con_stage.append(multiConsentValues[3]).append("~");					
										if(multiConsentValues[10].equals("Y"))	
										{
										%>
											<option style='background-color:#FFA8A8;color:#000000' value='<%=multiConsentValues[1]%>' ><%=multiConsentValues[2]%><%=(multiConsentValues[12].equals("N"))? "(*)":""%></option>
										<%
										}
										else if(checkcolor.equals("color"))
										{
										%>
											<option style='background-color:LightGrey;color:#000000' value='<%=multiConsentValues[1]%>' ><%=multiConsentValues[2]%><%=(multiConsentValues[12].equals("N"))? "(*)":""%></option>
											<%
										}
										else
										{
										%>
											<option style='' value='<%=multiConsentValues[1]%>' ><%=multiConsentValues[2]%><%=(multiConsentValues[12].equals("N"))? "(*)":""%></option><%
										}
											define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
									}
								}
								if(!(bo_cnt >0 || br_cnt >0))
								{
									out.println("<script>document.getElementById('consent_form_id'+i).style.visibility = 'hidden';</script>");
								}
							}
							else
							{
								//define_label = "";
								//	stage_label_count = true;														
								for(int j=0;j<multiNonAssConsentList.size();j++)
								{
									String[] multiConsentValues = (String[])multiNonAssConsentList.get(j);
									bo_cnt++;define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
									if(multiConsentValues[12].equals("N"))
									{
										//noteligible_consent_id  += multiConsentValues[1] +"~" ;
										noteligible_consent_id.append(multiConsentValues[1]);
										noteligible_consent_id.append("~");
									}
							%>
									<option style='<%=multiConsentValues[10].equals("Y")? "background-color:#FFA8A0;color:#000000":""%>' value='<%=multiConsentValues[1]%>'><%=multiConsentValues[2]%><%=(multiConsentValues[12].equals("N"))? "(*)":""%></option>							
						<%	}
								if( !(bo_cnt >0) )
								{
									out.println("<script>document.getElementById('consent_form_id'+i).style.visibility = 'hidden';</script>");
								}
							}
						%>
							</select>
						<% 
						}
						else if( multiConsentDtls[0].equals("V"))
						{ 
							//if(!multiConsentDtls[5].equals("") && !multiConsentDtls[3].equals("")){
							if(multiNonAssConsentList.size()>0)
							{
								for(int j=0;j<multiNonAssConsentList.size();j++)
								{
									String[] multiConsentValues = (String[])multiNonAssConsentList.get(j);
									define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
									if(multiConsentValues[12].equals("N"))
									{
										//	noteligible_consent_id  += multiConsentValues[1] +"~" ;
										noteligible_consent_id.append(multiConsentValues[1]);
										noteligible_consent_id.append("~");
									}
									if(	multiConsentDtls[6].equals("N"))
									{%>
										<A class="gridLink" HREF="javascript:noPermission()" title='Consent to be Recorded'><%=multiConsentDtls[5]%><%=multiConsentDtls[6].equals("N")?"(*)":""%></A>
									<%
									}
									else
									{
									%>
										<A class="gridLink" HREF="javascript:displayDetails('<%=i%>',true)" title='Consent to be Recorded'><%//=multiConsentDtls[5]%><%=multiConsentValues[2]%><%=(multiConsentValues[12].equals("N"))? "(*)":""%></A><%}%>
										<input type='hidden' name="consent_form_id<%=i%>" id="consent_form_id<%=i%>" value="<%//=multiConsentDtls[3]%><%=multiConsentValues[1]%>">  
										<input type='hidden' name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="<%=multiConsentValues[3]%>">
					<%			}
								}
								else if(multiConsentList.size() > 0)	
								{
									for(int j=0;j<multiConsentList.size();j++)
									{
										String[] multiConsentValues = (String[])multiConsentList.get(j);											
										if(multiConsentValues[9].equals("Y") && !multiConsentValues[10].equals("Y") )
										{
											define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
											if(multiConsentValues[12].equals("N"))
											{
												//noteligible_consent_id  += multiConsentValues[1] +"~" ;
												noteligible_consent_id.append(multiConsentValues[1]);
												noteligible_consent_id.append("~");
											}
											if(	multiConsentDtls[6].equals("N"))
											{
											%>
												<A class="gridLink" HREF="javascript:noPermission()" title='Consent to be Recorded'><%=multiConsentDtls[5]%><%=multiConsentDtls[6].equals("N")?"(*)":""%></A>
											<%
											}
											else
											{
											%>
												<A class="gridLink" HREF="javascript:displayDetails('<%=i%>',true)" title='Consent to be Recorded'><%=multiConsentValues[2]%><%=(multiConsentValues[12].equals("N"))? "(*)":""%></A>
											<%
											}
											%>
												<input type='hidden' name="consent_form_id<%=i%>" id="consent_form_id<%=i%>" value="<%=multiConsentValues[1]%>">
												<input type='hidden' name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="<%=multiConsentValues[3]%>">
											<%
											}
										}
									}
								}
							}
						%>
						<input type='hidden' name="noteligible_consent_id<%=i%>" id="noteligible_consent_id<%=i%>" value="<%=noteligible_consent_id.toString()%>">
						</label>
						<!-- <div ALIGN='right' CLASS='label' id='link_consent<%=i%>' title='Link Consent' style="visibility:<%=define_label.equals("Define")?"hidden":"visible"%>"> uncomment when link consent link is required nd remove teh below line-->
						<div ALIGN='right' CLASS='label' id='link_consent<%=i%>' title='Link Consent' style="visibility:hidden">
							<A class="gridLink" HREF="javascript:linkConsents('<%=record[6]%>','<%=record[7]%>','<%=facility_id%>','<%=i%>')"><FONT SIZE="1" ><fmt:message key="eOR.LinkConsent.label" bundle="${or_labels}"/></A>	
						</div>
							<!-- <A  id='details<%=i%>'style="visibility:hidden" HREF="javascript:displayDetails('<%=i%>')" title="Preview Consent Form"><FONT SIZE="1">Details</FONT></A> --></td>  <!-- <%=cont_order_ind %>- kept for testing the status DR/CR/DO/CO -->
							<!-- Details() -->
						<td width='10%' class='<%=slClassValue%>'><font color="#000099"><B><%=(multiConsentDtls != null && !multiConsentDtls[0].equals(""))?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BeforeOrder.label","or_labels"):""%><BR>
						<%//if(stage_label.equals("") && multiConsentDtls != null){
						////	if(multiConsentDtls != null && ( ( Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( Integer.parseInt(multiConsentDtls[1]) + Integer.parseInt(multiConsentDtls[2]) > 1 ) )){//changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
						if(multiConsentDtls != null && ( ( Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1 ) || ( Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn) > 1 ) ))
						{
							/**changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008	*start**/				%>
							&nbsp;&nbsp;<fmt:message key="eOR.Release.label" bundle="${or_labels}"/>&nbsp;(<%=con_bo_cnt%>/<%=consent_req_bef_order%>)<BR>&nbsp;&nbsp;<fmt:message key="Common.Registration.label" bundle="${common_labels}"/>:&nbsp;(<%=con_br_cnt%>/<%=consent_req_bef_regn%>)
							<%
						/**changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008	*end**/		
						}
						else
						{
						%>
								&nbsp;&nbsp;<%//=stage_label%><%=(multiConsentDtls != null && !multiConsentDtls[0].equals(""))?stage_label:""%>
						<%
						}
						//if( multiConsentDtls != null || consentedList.size() != ( Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]) ) && ( Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]) > 0 ) ){
						if( multiConsentDtls != null &&( multiConsentDtls[0].equals("V") || ( Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn) > 0 )))
						{
							//--[IN034888] - Start
							if(record[9].indexOf("!~!")!=-1)
							{
								record[9] = record[9].replace("!~!",",");
								consentLinenum = bean.getOrderLineNum(record[5]); //--[IN034904]
							}
							//--[IN034888] - End
						%>
							<BR><BR><A class='gridLink' id='multi_label<%=i%>' HREF="javascript:callMultipleConsents('<%=record[24]%>','<%=URLEncoder.encode(record[9],"UTF-8")%>','<%=record[5]%>','<%=record[25]%>','','<%=i%>')"><%//=define_label?"Redefine":"Define"%><%=define_label%></A> <!-- IN041421 -->
						<%
						}
						%>
						</B>
					</td>
					<%
					if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals(""))
					{
					%>
						<td width='13%' class='<%=slClassValue%>'><%=record[1]%></td>
					<%
					}
					if(record[2].equals("U"))
					{
						fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
					}
					else if(record[2].equals("S"))
					{
						fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
					}
					else
					{
						fontValue = "<font size=1 color=black><b>";
					}
					if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals(""))
					{  
					%>
						<td width='15%' class='<%=slClassValue%>'><%=fontValue%><%=record[2]%></td>
					<%
					}
					slClassValue = slClassValueTmp;
					int detailSize = record[9].length();//IN45800
					if(record[9].indexOf("$$RD##")!=-1)
					{
						String[] str = (String[])record[9].split("!~!");
						//String order_detail ="";
						String order_detail ="(";//IN45800
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
								//strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";//IN45800
								//strtitle[0] = "(<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";//IN45800
								strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";//IN45800
								//order_detail = order_detail+strtitle[0]+strtitle[2]+", ";//IN45800
								order_detail = order_detail + strtitle[2]+", ";//IN45800
							}
							else
							{
								order_detail = order_detail+str[s]+", ";
							}
						}
						record[9] = order_detail;
						
						//if(record[9].lastIndexOf(",") ==((record[9].length())-2))//IN45800
						if(record[9].lastIndexOf(",") == detailSize-2)//IN45800
						{
							//record[9] = record[10] .substring(0,((record[9].length())-2));//IN45800
							record[9] = record[10] .substring(0,detailSize-2);//IN45800
						}
					}
					if(record[9].indexOf("!~!")!=-1)
					{
						record[9] = record[9].replace("!~!",",");
					}
				%>
				<td width='13%' class='<%=slClassValue%>'><%=com.ehis.util.DateUtils.convertDate(record[8],"DMYHM","en",localeName)%></td> <!--  data of ordered AT -->
				<!--<td width='15%' class='<%=slClassValue%>'><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=record[1]%>','<%=record[5]%>','<%=record[19]%>','<%=record[7]%>')"  ><%=record[9]%></a></td>-->
					<!--  data of ordered Catalogs -->
				<!-- <td width='20%' nowrap id='orderctl<%=i%>' class='gridDataBlue' style='cursor:pointer' onClick="displayToolTip(''+getLabel('Common.view.label','Common')+','+getLabel('eOR.Refusal.label','OR')+'','<%=record[1]%>','<%=record[5]%>','<%=record[19]%>','<%=record[6]%>','<%=record[4]%>','<%=record[10]%>','<%=record[11]%>','<%=record[7]%>','<%=record[12]%>','<%=record[10]%>','<%=record[11]%>','<%=record[2]%>','<%=record[25]%>',this,'imgArrow<%=i%>','<%=consentLinenum%>')"  onMouseOver="hideToolTip(this,'imgArrow<%=i%>','<%=i%>')" >	<%=record[9]%><img align='right' src="../../eCommon/images/inactiveArrow.gif" name="imgArrow<%=i%>"> -->
<td width='20%' nowrap id='orderctl<%=i%>' class='gridDataBlue' style='cursor:pointer' onClick="displayToolTip(''+getLabel('Common.view.label','Common')+','+getLabel('eOR.Refusal.label','OR')+'','<%=record[1]%>','<%=record[5]%>','<%=record[19]%>','<%=record[6]%>','<%=record[4]%>','<%=record[10]%>','<%=record[11]%>','<%=record[7]%>','<%=record[12]%>','<%=record[10]%>','<%=record[11]%>','<%=record[2]%>','<%=record[25]%>',this,'imgArrow<%=i%>','<%=consentLinenum%>')" onmouseover="hideToolTip(this,'imgArrow<%=i%>','<%=i%>')">
  <a href="javascript:displayToolTip(''+getLabel('Common.view.label','Common')+','+getLabel('eOR.Refusal.label','OR')+'','<%=record[1]%>','<%=record[5]%>','<%=record[19]%>','<%=record[6]%>','<%=record[4]%>','<%=record[10]%>','<%=record[11]%>','<%=record[7]%>','<%=record[12]%>','<%=record[10]%>','<%=record[11]%>','<%=record[2]%>','<%=record[25]%>',this,'imgArrow<%=i%>','<%=consentLinenum%>')"  
     >
    <%=record[9]%>
    <img align='right' src="../../eCommon/images/inactiveArrow.gif" name="imgArrow<%=i%>" id="imgArrow<%=i%>">
  </a>				
</td><!--  data of ordered Catalogs //added consentLinenum --[IN034904]-->
				<td width='30%' class='<%=slClassValue%>'><%=patientdetails%><BR><%=encounter_dtls%></td><!--  data of ordering locn details -->
				
				<input type=hidden name='patient_name<%=i%>' id='patient_name<%=i%>' value="<%=record[20]%>">
				<input type=hidden name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=record[12]%>">
				<input type=hidden name='ord_status<%=i%>' id='ord_status<%=i%>' value="<%=record[13]%>">
				<input type=hidden name='ord_consent_yn<%=i%>' id='ord_consent_yn<%=i%>' value="<%=record[17]%>">
				<input type=hidden name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=record[5]%>">
				<input type=hidden name='ord_line_num<%=i%>' id='ord_line_num<%=i%>' value="<%=record[25]%>">
				<input type=hidden name='appt_reqd_yn<%=i%>' id='appt_reqd_yn<%=i%>' value="<%=record[26]%>">
				<input type=hidden name='order_pract_name<%=i%>' id='order_pract_name<%=i%>' value="<%=record[21]%>">
				<input type=hidden name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value="<%=cont_order_ind%>">
				<input type="hidden" name="ord_appr_by_user_id<%=i%>" id="ord_appr_by_user_id<%=i%>" value="<%=ord_appr_by_user_id%>">
				<input type="hidden" name="ord_appr_reqd_yn<%=i%>" id="ord_appr_reqd_yn<%=i%>" value="<%=ord_appr_reqd_yn%>">
				<input type="hidden" name="ord_consent_by_id<%=i%>" id="ord_consent_by_id<%=i%>" value="<%=ord_consent_by_id%>">
				<input type="hidden" name="ord_consent_reqd_yn<%=i%>" id="ord_consent_reqd_yn<%=i%>" value="<%=ord_consent_reqd_yn%>">
				<input type="hidden" name="order_catalog_code<%=i%>" id="order_catalog_code<%=i%>" value="<%=record[24]%>">				
				<input type=hidden name='patientdetails<%=i%>' id='patientdetails<%=i%>' value="<%=patientdetails%>">
				<input type=hidden name='order_category<%=i%>' id='order_category<%=i%>' value='<%=record[0]%>'>
				<input type=hidden name='ord_catalog_desc<%=i%>' id='ord_catalog_desc<%=i%>' value='<%=record[9]%>'>
				<input type=hidden name='pat_class<%=i%>' id='pat_class<%=i%>' value='<%=record[4]%>'>
				<input type=hidden name='pat_id<%=i%>' id='pat_id<%=i%>' value='<%=record[6]%>'>
				<input type=hidden name='priority<%=i%>' id='priority<%=i%>' value='<%=record[2]%>'>
				<input type=hidden name='location_type<%=i%>' id='location_type<%=i%>' value='<%=record[10]%>'>
				<input type=hidden name='location_code<%=i%>' id='location_code<%=i%>' value='<%=record[11]%>'>
				<input type=hidden name='encount_id<%=i%>' id='encount_id<%=i%>' value='<%=record[7]%>'>
				<input type=hidden name='ord_auth_reqd_yn<%=i%>' id='ord_auth_reqd_yn<%=i%>' value='<%=record[22]%>'>
				<input type=hidden name='ord_auth_by_pract_id<%=i%>' id='ord_auth_by_pract_id<%=i%>' value='<%=record[23]%>'>
				<input type="hidden" name="link_ref_no<%=i%>" id="link_ref_no<%=i%>" value="">
				<input type="hidden" name="link_ref<%=i%>" id="link_ref<%=i%>" value="">
				<input type="hidden" name="link_ref_det<%=i%>" id="link_ref_det<%=i%>" value="">
				<input type=hidden name='con_bo_cnt<%=i%>' id='con_bo_cnt<%=i%>' value="<%=con_bo_cnt%>">
				<input type=hidden name='con_br_cnt<%=i%>' id='con_br_cnt<%=i%>' value="<%=con_br_cnt%>">
				<!-- <input type=hidden name='con_rbo_cnt<%=i%>' id='con_rbo_cnt<%=i%>' value="<%=multiConsentDtls[1]%>"> -->
				<input type=hidden name='con_rbo_cnt<%=i%>' id='con_rbo_cnt<%=i%>' value="<%=consent_req_bef_order%>">
				<!-- <input type=hidden name='con_rbr_cnt<%=i%>' id='con_rbr_cnt<%=i%>' value="<%=multiConsentDtls[2]%>">
				 --><input type=hidden name='con_rbr_cnt<%=i%>' id='con_rbr_cnt<%=i%>' value="<%=consent_req_bef_regn%>">
				<input type='hidden' name="con_id<%=i%>" id="con_id<%=i%>" value="<%=con_id.toString()%>">
				<input type='hidden' name="con_stage<%=i%>" id="con_stage<%=i%>" value="<%=con_stage.toString()%>">
				<input type='hidden' name="order_set_id<%=i%>" id="order_set_id<%=i%>" value="<%=bean.checkForNull(record[28],"")%>">
				<%con_id.setLength(0);
				con_stage.setLength(0);
								%>
				<!--<input type=hidden name='pat_name<%=i%>' id='pat_name<%=i%>' value=''>
				<input type=hidden name='Practioner_name<%=i%>' id='Practioner_name<%=i%>' value=''>
				<input type=hidden name='dat_time<%=i%>' id='dat_time<%=i%>' value=''>
				<input type=hidden name='remarks<%=i%>' id='remarks<%=i%>' value=''>
				<input type=hidden name='ord_pract<%=i%>' id='ord_pract<%=i%>' value=''>
				<input type=hidden name='Consent_detail<%=i%>' id='Consent_detail<%=i%>' value=''>
				<input type=hidden name='self<%=i%>' id='self<%=i%>' value=''>
				<input type=hidden name='relation<%=i%>' id='relation<%=i%>' value=''>
				<input type=hidden name='relation_text<%=i%>' id='relation_text<%=i%>' value=''>
				<input type=hidden name='orderable_val<%=i%>' id='orderable_val<%=i%>' value=''>-->
			</tr>
			<SCRIPT>
				defaultSelect("<%=i%>");
			</SCRIPT>
		<%
			i++;
		}
		%>
</table>
<input type="hidden" name="from" id="from" value="<%=from%>">
<input type="hidden" name="to" id="to" value="<%=to%>">
 <input type=hidden name='total_recs' id='total_recs' value='<%=i%>'>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%= practitioner_id%>">
<input type="hidden" name="practitioner_name" id="practitioner_name" value="<%= practitioner_name%>">
<input type="hidden" name="security_level" id="security_level" value="<%=security_level%>">
<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
<!--<input type="hidden" name="pract_id" id="pract_id" value="">--><!--returned frm modal window-->
<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="ord_cat" id="ord_cat" value="<%=ord_cat%>">
<input type="hidden" name="order_by" id="order_by" value="<%=order_by%>">
<input type="hidden" name="ord_cat_desc" id="ord_cat_desc" value="<%=ord_cat_desc%>">
<input type="hidden" name="priority_desc" id="priority_desc" value="<%=priority_desc%>">
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<!-- Added by kishore kumar N on 30-Oct-09  for CRF 15741 -->
<input type="hidden" name="qryString" id="qryString" value="<%=qryString%>">
<!-- ends here. -->
<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute;left:77%;top:42%; width:10%; visibility:hidden;' bgcolor='blue'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
			<td width='100%' id='t'></td>
			</td>
		</tr>
	</table>
</div>
</form>
</body>
<script>
	parent.parent.parent.ConsentOrderTop.document.consent_order.search_btn.disabled = false;
</script>
</html>
<%
putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e)
	{
		System.err.println("ConsentOrdersBottomRightDtl.jsp,1108,message=>"+e.getMessage());
		e.printStackTrace();
	}
%>

