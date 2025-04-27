<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------------------------------------
07/02/2013	  IN029949	    Chowminya G  	Created 
12/02/2013	  IN037898	  	Chowminya G     Pharmacy Orders - On Hold �->Duplicate Records displayed for Multi Orders 	
12/02/2013	  IN037901	  	Chowminya G     Pharmacy Orders - On Hold ->View->HTML tags displayed in header
13/02/2013	  IN037906	  	Chowminya G     Pharmacy Orders - On Hold ->No Proper Message prompt
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eOR.* ,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!---->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/MedicationHoldOrder.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function dummy()
	{
	}
	function hideToolTip(obj,imgObj,row)	
	{
		dynamichide(obj, window.event,row);	  
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
	
		document.getElementById("tooltiplayer").style.posLeft= x;
		document.getElementById("tooltiplayer").style.posTop = y;
		document.getElementById("tooltiplayer").style.visibility='visible'
	}


	function displayToolTip(val,ord_cat,val1,orderId,patient_id,encounter_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,patient_class,order_catalog_code,order_type_code,order_line_num,cont_order_ind,order_line_status,orderctlHDR,imgObj) {
		
			callMouseOverOnTD(orderctlHDR,imgObj);

		  	buildTable (val,ord_cat,val1,orderId,patient_id,encounter_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,patient_class,order_catalog_code,order_type_code,order_line_num,cont_order_ind,order_line_status)
			resizeWindow(orderctlHDR)
	}

	function buildTable(val,ord_cat,val1,orderId,patient_id,encounter_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,patient_class,order_catalog_code,order_type_code,order_line_num,cont_order_ind,order_line_status) {
	
		bean_id      = document.medi_hold_order_dtl.bean_id.value;
        var rowval   = val.split (",");
		var row      = ("View,Discontinue,,,,");
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>";
		for( var i=0; i<rowval.length; i++ ) {
			var colval  = rowval[i]

			var colval1 = rowval1[i];
           if (colval != "")
           {
           
				tab_dat     += "<tr>"
				
					tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','PH','"+escape(val1)+"','"+orderId+"','"+sex+"','"+patient_id+"','"+encounter_id+"','"+patient_class+"','"+order_catalog_code+"','"+order_type_code+"','"+order_line_num+"','"+cont_order_ind+"','"+order_line_status+"')>"+colval+"</a></td>"
				
				tab_dat     += "</tr> "
			}
		}
			tab_dat     += "</table> "
		
		document.getElementById("t").innerHTML = tab_dat
	}
</script>

</head>
<body  onScroll="processScroll()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String mode	   = "1" ;
	String bean_id = "Or_CancelOrder" ;
	String bean_name = "eOR.CancelOrder";
	String bean_id1 = "Or_ExistingOrder" ;
	String bean_name1 = "eOR.ExistingOrder";
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");

	String resp_id = (String)session.getValue("responsibility_id");
	String practitioner_type = (String)session.getValue("practitioner_type"); //IN037898
	String pract_reln_id = (String)request.getParameter("relationship_id");
	if(resp_id== null)resp_id = "";
	if(pract_reln_id== null) pract_reln_id= "";
	String order_category ="";	
	String encounter_dtls="";
	String patientdetails="";
	String location="";
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
	String patientId  	    = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");

	String total_query_records  = "0";

	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ;
	if(period_from== null) period_from="" ; else period_from = period_from.trim();
	if(period_to== null) period_to="" ; else period_to = period_to.trim();
	
	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name, request   ) ;
	ExistingOrder bean1 = (ExistingOrder)getBeanObject( bean_id1, bean_name1, request   ) ;
	
	bean.setLanguageId(localeName);	
	bean1.setLanguageId(localeName);
	
	String slClassValue = "";
	
	String from	 = bean1.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean1.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
 	
	bean.setMode( mode ) ;

	ArrayList StatusDetail = new ArrayList();

	StatusDetail = bean1.getMedicationHoldOrders(facility_id,practitioner_id,ord_cat,patientId,period_from,period_to,start,end,source_type,source_code,practitioner_type); //IN037898
 
	String menu_security = "";
	String menu_security1 = "";
%>
<form name='medi_hold_order_dtl' id='medi_hold_order_dtl'  action="../../eOR/jsp/MedicationHoldOrdersBottomResult.jsp" method="post">
<div id="divHeadSep" style="position: absolute;">
<table class='grid' cellpadding=3 cellspacing=0 border=1 width="100%" height="" id="tableresult">
<tr id="heading">
		<td class='columnheader' width='' nowrap><fmt:message key="eOR.OnHoldRemarks.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>

	</tr>

		<%

		String display_checked="";
		menu_security = (String)bean1.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
		menu_security1 = (String)bean1.getMenu("AMEND_ORDER",resp_id,pract_reln_id);
	
		String disabled= "";
		String strOrderCtl = "";
		int i = 0;
		//IN037906 - Start
		if(StatusDetail!=null && StatusDetail.size() == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html' </script>");
		}
		//IN037906 - End
		for( int k=0 ; k< StatusDetail.size() ; k++ ) 
		{
			
				slClassValue="gridData";
				String slClassValueTmp = slClassValue;
				String[] record = (String[])StatusDetail.get(k);

				if(record[1].compareTo("R")==0){
					record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(record[1].compareTo("U")==0)
				{
					
					record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(record[1].compareTo("S")==0)
				{
				
				record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				
				}	

				String sex1;
				sex1="";
				if (record[4].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(record[4].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(record[9].equalsIgnoreCase("C"))
	{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(record[9].equalsIgnoreCase("N"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}else if(record[9].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}
				patientdetails=record[3]+","+sex1+"/"+record[6]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[10];
			encounter_dtls=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+record[8]+","+location+"/"+record[7];
			
			if(k==0)
			{
					if(record[20] != null)
					total_query_records = bean1.checkForNull((String)record[20],"0");
					
				%>
					<%if((Integer.parseInt(total_query_records)>0) || (start>1)){%>
					<tr  align="right">
						<td colspan="6">
							<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name ="from" value= "<%=start%>" /> 
							<jsp:param name ="to" value= "<%=end%>" />	
							<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
							<jsp:param name ="check_box_name" value= "chk" />					 
							<jsp:param name ="form_name" value= "medi_hold_order_dtl" />  
							</jsp:include>
						</td>
					</tr>
				<%}%>				
				<%	
					if(!priority.equals(" ") || !ord_cat.equals(" ") )
					{
						if(!(priority.equals(" "))){
							if(priority.equals("U")){
								out.println("<tr><td class='ORRED' colspan=6>"+priority_desc+"</td>");
							}else if(priority.equals("S")){
								out.println("<tr><td class='ORBROWN' colspan=6>"+priority_desc+"</td>");
							}else if(priority.equals("R")){
								out.println("<tr><td class=columnheader colspan=6>"+priority_desc+"</td>");
							}
					}
					if(!(ord_cat.equals(" "))){
						out.println("<tr><td class=columnheader colspan=6>"+ord_cat_desc+"</td>");
					}
				}
			
				}
				order_category = "PH";

		%>

			<tr>
				<td  width='30%' wrap id='status<%=i%>' class='<%=slClassValue%>'><%=record[0]%></td><!--IN037901  -->
				<td width='' nowrap class='<%=slClassValue%>'><%=record[1]%></td>
			
				<td width='' nowrap class='<%=slClassValue%>'><%=com.ehis.util.DateUtils.convertDate(record[11],"DMYHM","en",localeName)%></td> <!--  date of ordered AT -->
				<%
								
				strOrderCtl = "";
				strOrderCtl = "<td nowrap width='' wrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue'";
				
				strOrderCtl = strOrderCtl + " onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((order_category.trim().equals("PH"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((record[5].trim().equals("A"))?"'+getLabel('Common.Amend.label','Common')+'":"")+"','','"+record[2]+"','"+record[12]+"','"+record[10]+"','"+record[8]+"','"+record[9]+"','"+record[13]+"','"+record[14]+"','','Y','"+record[4]+"','"+record[6]+"','"+record[5]+"','"+record[14]+"','"+record[15]+"','"+record[16]+"','"+record[17]+"','"+record[18]+"','"+record[19]+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\" >"+record[2];
									
				strOrderCtl = strOrderCtl + "<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>";

					out.println(strOrderCtl);	
					
		
					
		%>		
		<!--  data of ordered Catalogs -->
				<td width='' wrap class='<%=slClassValue%>'><%=patientdetails%><BR><%=encounter_dtls%>
				   
					</td><!--  data of ordering locn details -->
				   <%
					StringBuffer menu_text1 = new StringBuffer();
					menu_text1.append( "'+getLabel('Common.view.label','Common')+'");
					%>
			
				
			
				<input type=hidden name='order_category<%=i%>' id='order_category<%=i%>' value="PH">
				<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=record[10]%>">
				<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=record[1]%>">
				<input type="hidden" name="date_of_birth<%=i%>" id="date_of_birth<%=i%>" value="<%=record[5]%>">
				<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value="<%=record[4]%>">
				<input type="hidden" name="age<%=i%>" id="age<%=i%>" value="<%=record[6]%>">
				
			</tr>
		<%
			i++;
			}
		%>
		
</table>
</div>
<!-- Next, Prev --> 
<input type="hidden" name="from" id="from" value="<%=from%>" >
<input type="hidden" name="to" id="to" value="<%=to%>" >
<input type=hidden name='total_recs' id='total_recs' value='<%=i%>'>
<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="security_level" id="security_level" value="<%=security_level%>">
<input type="hidden" name="relationship_id" id="relationship_id" value="<%=pract_reln_id%>">


<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="ord_cat" id="ord_cat" value="PH">
<input type="hidden" name="priority_desc" id="priority_desc" value="<%=priority_desc%>">
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="which_place" id="which_place" value="hold_line_rec">
 
<input type="hidden" name="help_function_id" id="help_function_id" value="MEDICATION_HOLD_ORDERS">

		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
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
parent.parent.MediHoldOrderTop.document.hold_order.search_btn.disabled = false;
</script>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

