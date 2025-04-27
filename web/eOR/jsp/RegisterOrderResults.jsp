<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------------------
15/12/2017	IN065942		Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the 																				barcode functionality at the time of 																							Registration of order,required patient 																							Id,patient name,age,sex,register date and name 																					of study.
23/04/2020	IN071618	    Nijitha S	 						PMG2019-MMS-CRF-0004
--------------------------------------------------------------------------------------------------------------------------------
*/
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
	<!---->
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../js/RegisterOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!-- <style>
	*
	{
		margin :0;
		padding : 0;
	}
	</style> -->
 	<Script>
 	function dummy(){
	}

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
	
		document.getElementById("tooltiplayer").style.left= x+"px";
		document.getElementById("tooltiplayer").style.top = y+"px";
		document.getElementById("tooltiplayer").style.background='grey';
		document.getElementById("tooltiplayer").style.visibility='visible';
	}

	function displayToolTip(val,ord_cat,val1,orderId,patient_id,sex,order_line_num,performing_facility,performing_location_type,performing_location,encounter_id,int_or_ext,priority,patient_class,order_type_code,source_type,source_code,dob,orderctlHDR,imgObj) {
			callMouseOverOnTD(orderctlHDR,imgObj)

		  	buildTable (val,ord_cat,val1,orderId,patient_id,sex,order_line_num,performing_facility,performing_location_type,performing_location,encounter_id,int_or_ext,priority,patient_class,order_type_code,source_type,source_code,dob)
			resizeWindow(orderctlHDR)

	}

	function buildTable(val,ord_cat,val1,orderId,patient_id,sex,order_line_num,performing_facility,performing_location_type,performing_location,encounter_id,int_or_ext,priority,patient_class,order_type_code,source_type,source_code,dob) {

//		alert(val);
//		alert(val1);
        var rowval   = val.split (",");
		var row      = ("View,ChangePerformLocn,SentOut,ReceiveResult,");
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
		for( var i=0; i<rowval.length; i++ ) {
			var colval  = rowval[i]

			var colval1 = rowval1[i];
		if (colval != "")
		{
		
			tab_dat = tab_dat+"<tr>"
			tab_dat=tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+ord_cat+"','"+escape(val1)+"','"+orderId+"','"+sex+"','"+patient_id+"','"+order_line_num+"','"+performing_facility+"','"+performing_location_type+"','"+performing_location+"','"+encounter_id+"','"+int_or_ext+"','"+priority+"','"+patient_class+"','"+order_type_code+"','"+source_type+"','"+source_code+"','"+dob+"')>"+colval+" </a></td>"
			tab_dat=tab_dat+ "</tr> "
		}
		}
			tab_dat=tab_dat+ "</table> "
		document.getElementById("t").innerHTML = tab_dat
	}
</Script>
    <!-- <STYLE TYPE="text/css">
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
<body  onScroll="processScroll()" onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%

	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String total_query_records  = "0";
	String view_by = request.getParameter( "view_by" ) ;
	String ord_cat = request.getParameter( "ord_cat" ) ;
	String single_multi = request.getParameter( "single_multi" ) ;
	String ord_type = request.getParameter( "ord_type" ) ;
	String priority = request.getParameter( "priority" ) ;
	String location_type = request.getParameter( "location_type" ) ;
	String locn = request.getParameter( "locn" ) ;
	String patientId = request.getParameter( "patientId" ) ;
	String encntr_id = request.getParameter( "encntr_id" ) ;

	String order_no = request.getParameter( "order_no" ) ;
	String date_from = request.getParameter( "date_from" ) ;
	String date_to = request.getParameter( "date_to" ) ;
	String performing_location_code = request.getParameter("performing_location_code");
	String int_or_ext = request.getParameter("int_or_ext");
	String specimen_no = request.getParameter("specimen_no");
	String activity_type = request.getParameter("activity_type")==null?"":request.getParameter("activity_type");
	String login_value = request.getParameter("login_value")==null?"":request.getParameter("login_value");
	String location="";

	view_by = (view_by == null) ? "" : view_by.trim();
	ord_cat = (ord_cat == null) ? "" : ord_cat.trim();
	single_multi = (single_multi == null) ? "" : single_multi.trim();
	ord_type = (ord_type == null) ? "" : ord_type.trim();
	priority = (priority == null) ? "" : priority.trim();
	location_type = (location_type == null) ? "" : location_type.trim();
	locn = (locn == null) ? "" : locn.trim();
	patientId = (patientId == null) ? "" : patientId.trim();
	encntr_id = (encntr_id == null) ? "" : encntr_id.trim();
	order_no = (order_no == null) ? "" : order_no.trim();
	date_from = (date_from == null) ? "" : date_from.trim();
	date_to = (date_to == null) ? "" : date_to.trim();
	performing_location_code = (performing_location_code == null) ? "" : performing_location_code.trim();
	int_or_ext = (int_or_ext == null) ? "" : int_or_ext.trim();
	specimen_no = (specimen_no == null) ? "" : specimen_no.trim();

	/*view_by = view_by.trim();
	ord_cat = ord_cat.trim();
	single_multi = single_multi.trim();
	ord_type = ord_type.trim();
	priority = priority.trim();
	location_type = location_type.trim();
	locn = locn.trim();
	patientId = patientId.trim();
	encntr_id = encntr_id.trim();
	order_no = order_no.trim();
	date_from = date_from.trim();
	date_to = date_to.trim();*/


	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_RegisterOrder" ;
	String bean_name = "eOR.RegisterOrder";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String pract_type = (String)session.getValue("practitioner_type");//IN065942
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

//	out.println(">"+practitioner_id+"<<br>");
//	out.println(">"+resp_id+"<");
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	RegisterOrder bean = (RegisterOrder)getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	String bill_yn=bean.checkForNull((String)bean.getBillInterfaceYn(),"N");
	//IN071618 Starts
	String split_unbilled_order_yn="N";
	String split_order_site_speci_yn=bean.checkForNull((String)bean.getSpiltUnBilledOrderYN(),"N");
	String order_stage = "";
	String checkyn     = "";
	//IN071618 Ends
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;

	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);
 	//if(from!=null && from.equals("1")) {
  		bean.clear() ;
	//}


	/*if(view_by.equals("H")){
		//out.println("<script>alert('resp_id="+resp_id+",practitioner_id="+practitioner_id+",ord_cat="+ord_cat+"')</script>");
		allValues		= bean.getSearchDetails(view_by,ord_cat,single_multi,ord_type,priority,location_type,locn,patientId,encntr_id,order_no,date_from,date_to,practitioner_id,resp_id,performing_location_code);
	}else{
		allValues		= bean.getSearchDetails(view_by,ord_cat,single_multi,ord_type,priority,location_type,locn,patientId,encntr_id,order_no,date_from,date_to,practitioner_id,resp_id,performing_location_code);
	}*/

//	out.println("<script>alert('view_by-"+view_by+"--int_or_ext="+int_or_ext+",specimen_no="+specimen_no+"')</script>");
//	if(from!=null && from.equals("1")) {
  		allValues		= bean.getSearchDetails(view_by,ord_cat,single_multi,ord_type,priority,location_type,locn,patientId,encntr_id,order_no,date_from,date_to,practitioner_id,resp_id,performing_location_code,int_or_ext,specimen_no,activity_type,start,end,login_value);
 		// Setting as a persistence bean
		//bean.setDetails(allValues);
 	//} else {
	//	allValues=bean.getDetails();
  	//}


/* Initialize Function specific end */

	if(allValues.size() == 0)
	{
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))
			parent.RegisterOrderSearch.document.register_order_search.search_btn.disabled = false;
			//parent.RegisterOrderHeader.location.href = "../../eCommon/html/blank.html"
			parent.RegisterOrderResult.location.href = "../../eCommon/html/blank.html"
			parent.RegisterOrderBtn.location.href = "../../eCommon/html/blank.html"
		</script>

<%	}
%>
<form name='register_order_dtl' id='register_order_dtl'  action="../../eOR/jsp/RegisterOrderResults.jsp" method="post">
<div id="divHeadSep" >
<table cellpadding=3 cellspacing=0 border=1 width="100%" height="" id="tableresult" class="grid">
<tr id="heading">
		
		<th class=columnheader width='' nowrap align='left'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th> 
		<th class=columnheader width='' nowrap align='left'><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
		<th class=columnheader width='' nowrap align='left'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
		<th class=columnheader width='' nowrap align='left'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
		<th class=columnheader width='' nowrap align='left'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
		<th class=columnheader width='' nowrap align='left'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
		<th class=columnheader width='' nowrap align='left'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		<%
		if(bill_yn.equalsIgnoreCase("Y"))
		{
		%>
			<th class=columnheader width='' nowrap align='left'><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/></th>
		<%
		}
		%>
		<%--<BR><input type=checkbox name='select_all' id='select_all' onClick='clickAll()'>--%></td>
	</tr>
		
<%
	String slClassValue = "";
	String tmp_ord_cat = "";
	String cont_order_ind = "";
	String order_line_num = "";
    String	encounter_dtls="";

	if (view_by.equals("H")) order_line_num = "1";
	int i = 0;

/*	if(allValues.size() < 7 || end > allValues.size()) {
			end = allValues.size();
	}	*/
	//for(int i=0; i<allValues.size(); i++){
		for(int k=0; k<allValues.size(); k++){
		//String[] register_details = new String[15];
		//register_details = (String[])allValues.get(i);
		String[] register_details = (String[])allValues.get(k);
		if(k==0){
			//if(register_details[29] != null)//IN065942
			if(register_details[31] != null)//IN065942//IN071618
				//total_query_records = bean.checkForNull((String)register_details[29],"0");//IN065942
				total_query_records = bean.checkForNull((String)register_details[31],"0");//IN065942//IN071618
			%>
			<%
				if((Integer.parseInt(total_query_records)>0) || (start>1))
				{
			%>
			
					<tr  align="right">
						<td colspan="8">
							<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name ="from" value= "<%=start%>" /> 
							<jsp:param name ="to" value= "<%=end%>" />	
							<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
							<jsp:param name ="check_box_name" value= "chk" />					 
							<jsp:param name ="form_name" value= "register_order_dtl" />  
							</jsp:include>
						</td>
					</tr>
			
			    <%
				}
			}
		if (view_by.equals("L")) order_line_num = register_details[10];

		
		StringBuffer menu_text = new StringBuffer();

		String sent_out_flag = "";

		StringTokenizer menuTokenizer = new StringTokenizer(register_details[13],"!");

		int count = 0;
		while (menuTokenizer.hasMoreTokens()) {
		  String tempToken = menuTokenizer.nextToken();
		  switch (count) {
		      case 0: if (tempToken.equals("V")) menu_text.append( "'+getLabel('Common.view.label','Common')+'"); break;

              case 1: if (tempToken.equals("C")) menu_text.append( ",'+getLabel('eOR.RedirectOrder.label','OR')+'");
		               else if (tempToken.equals("N")) menu_text.append( ",");break;

              case 2: if (tempToken.equals("N")) menu_text.append(",");
                       else if (tempToken.equals("S")) {menu_text.append( ",'+getLabel('eOR.SendOut.label','OR')+'");sent_out_flag = "S";}
                       else if (tempToken.equals("R")) {menu_text.append( ",,'+getLabel('eOR.ReceiveResult.label','OR')+'");sent_out_flag = "R";}
					   break;

              case 3: if (tempToken.equals("N")) sent_out_flag = "";
                       else if (tempToken.equals("Y") && (sent_out_flag.equals("S"))) sent_out_flag = "S";
					   else if (tempToken.equals("Y") && (sent_out_flag.equals("R"))) sent_out_flag = "R";
					   else sent_out_flag = "";break;
		  }
          count++;

		}
		slClassValue="gridData";
		if(view_by.equals("L")){
			out.println("<input type=hidden name='line_id"+i+"' id='line_id"+i+"' value='"+register_details[10]+"'>");
		}else{
			cont_order_ind = (String)register_details[10];
			out.println("<input type=hidden name='cont_order_ind"+i+"' id='cont_order_ind"+i+"' value='"+cont_order_ind+"'>");
		}

		if(!(tmp_ord_cat.equals(register_details[8]))){
			tmp_ord_cat = (String)register_details[8];
	%>
		<!-- <tr>
			<th colspan=7 align=left> <font size=1><%=register_details[9]%></font></th>
		</tr> -->
		<%}
			//System.out.println("==========="+register_details[12]+"==="+register_details[7]);
			String patientdetails="";
			String sex1;
				sex1="";
				if (register_details[12].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(register_details[12].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			if((register_details[20]==null) || (register_details[20].equals("")))
			{
				register_details[20]="R";
			}
			if(register_details[20].equalsIgnoreCase("C"))
			{
						location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(register_details[20].equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}else if(register_details[20].equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}

			patientdetails=register_details[7]+","+sex1+"/"+register_details[25]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+register_details[11];
			encounter_dtls=patientdetails+"<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+register_details[17]+","+location+"/"+register_details[26];
			if(register_details[4].compareTo("R")==0)
			{
				register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
									
			}
				else if(register_details[4].compareTo("U")==0)
			{
				
				register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
								

			}
				else if(register_details[4].compareTo("S")==0)
			{
			
				register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					

			}	
			if(register_details[12]!=null)
			{
				if(register_details[12].compareTo("M")==0){
					register_details[12]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
										
				}
					else if(register_details[12].compareTo("F")==0)
				{
					
					register_details[12]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
									

				}
			}else
				{
					register_details[12]="";
				}
			//IN071618 Starts
			String isDisabled = "";
			String chkColor = slClassValue;
			String  color_billed = slClassValue;

			
			if(!"null".equals(register_details[30]) || !"".equals(register_details[30]))
			{
					StringTokenizer stoken = new StringTokenizer(register_details[30],"!");
				
					while (stoken.hasMoreTokens()) 
					{
					  
					      order_stage = stoken.nextToken();
			          
					  
					      checkyn = stoken.nextToken();
					 
						  split_unbilled_order_yn = stoken.nextToken();
						  color_billed = stoken.nextToken();
					 
					}	
					
					
						if (color_billed.equals("FULLYORPARTIALLYPAID")) {
						  chkColor = "QRY3";
						} 
						if (order_stage.equals("NOTPAID")) {
						  chkColor = "QRY5";
						}
					
					if(checkyn.equals("N") )
					{
						isDisabled = "disabled";
						
					}
				} 
			//IN071618 Ends
		%>

		<tr>
			<!-- <td width='15%' class='<%=slClassValue%>'> <font size=1><%=register_details[1]%></font></td> -->
			<td width='' class='<%=slClassValue%>' nowrap><%=register_details[9]%></td>
			<td width='' class='<%=slClassValue%>' nowrap><%=register_details[2]%></td>
			<input type=hidden name='ord_id<%=i%>' id='ord_id<%=i%>' value='<%=register_details[2]%>'>
			<input type=hidden name='view_by<%=i%>' id='view_by<%=i%>' value='<%=view_by%>'>
			<td width='' class='<%=slClassValue%>' value="<%=com.ehis.util.DateUtils.convertDate(register_details[3],"DMYHM","en",localeName)%>" nowrap>  </td>
			<td width='' class='<%=slClassValue%>' nowrap> <%=register_details[4]%></td>
			<%--<td width='15%' class='<%=slClassValue%>'><a class="gridLink" href='#' onClick="callMenuFunctions('View','<%=register_details[1]%>','<%=register_details[2]%>','<%=register_details[12]%>','<%=register_details[11]%>')"> <%=register_details[6]%></a></td>--%>
			<%
				if(register_details[6].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])register_details[6].split("!~!");
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
					register_details[6]  = order_detail;
					if(register_details[6].lastIndexOf(",") ==((register_details[6].length())-2))
					{
						register_details[6] = register_details[6] .substring(0,((register_details[6].length())-2));
					}
				}
				if(register_details[6].indexOf("!~!")!=-1)
				{
					register_details[6] = register_details[6].replace("!~!",",");
				}
			%>
			<td width='' nowrap  id='orderctl<%=i%>' class='gridDataBlue' style = 'cursor:pointer' onClick="displayToolTip('<%=menu_text%>','<%=register_details[0]%>','<%=register_details[1]%>','<%=register_details[2]%>','<%=register_details[11]%>','<%=register_details[12]%>','<%=order_line_num%>','<%=register_details[14]%>','<%=register_details[15]%>','<%=register_details[16]%>','<%=register_details[17]%>','<%=register_details[18]%>','<%=register_details[5]%>','<%=register_details[19]%>','<%=register_details[8]%>','<%=register_details[20]%>','<%=register_details[21]%>','<%=register_details[28]%>',this,'imgArrow<%=i%>')"   onMouseOver="hideToolTip(this,'imgArrow<%=i%>','<%=i%>')"> <%=register_details[6]%>
			

		<%
 			if(register_details[22]!=null && register_details[22].equals("Y")) {
				out.println("<img src=\"../images/Alert.gif\" align=center>");
			} 
		%>
			<img align='right' src="../../eCommon/images/inactiveArrow.gif" name="imgArrow<%=i%>" id="imgArrow<%=i%>">
			</td>
            <% 
				//	System.out.println("==="+register_details[7]);
	/*	if (encounter_dtls.indexOf(",")!=-1){

			StringTokenizer fieldTokenizer = new StringTokenizer(encounter_dtls,",");
			encounter_dtls="";
		
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
			encounter_dtls=encounter_dtls.concat(tempToken).concat(",");
			  
         

		}
					 }*/
		%>



			<td width='' class='<%=slClassValue%>'><%=encounter_dtls%> </td>
			<%--<script>alert('<%=sent_out_flag%>')</script>--%>
			<%if (sent_out_flag.equals("S") ||  sent_out_flag.equals("R")) {%>
			<td width='' class='<%=slClassValue%>'><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' onClick="chkSentOut('<%=sent_out_flag%>','<%=register_details[0]%>','<%=register_details[1]%>','<%=register_details[2]%>','<%=register_details[11]%>','<%=register_details[12]%>','<%=order_line_num%>','<%=register_details[14]%>','<%=register_details[15]%>','<%=register_details[16]%>','<%=register_details[17]%>','<%=register_details[18]%>','<%=register_details[5]%>','<%=register_details[19]%>','<%=register_details[8]%>','<%=register_details[20]%>','<%=register_details[21]%>','<%=register_details[28]%>')"></td><td class='<%=slClassValue%>' width='' nowrap></td>
			<%} else {%>
				<%
			StringBuffer menu_text1 = new StringBuffer();
			menu_text1.append( "'+getLabel('Common.view.label','Common')+'");%>
			<td class='<%=chkColor%>' width='' id='status<%=i%>'nowrap><input type=checkbox name='chk<%=i%>' id='chk<%=i%>'  <%=isDisabled %> onClick="chkUnbilled('<%=bean.checkForNull(register_details[2],"")%>','<%=bean.checkForNull(register_details[11],"")%>','<%=bean.checkForNull(register_details[14],"")%>','<%=bean.checkForNull(register_details[17],"")%>','<%=bean.checkForNull(register_details[19],"")%>','<%=bean.checkForNull(register_details[8],"")%>','<%=i%>')"></td><!-- Modified for //IN071618  -->
			<%	// if(register_details[24] != null && register_details[24].equals("Y")){%>
			<%if(!(register_details[0]).equalsIgnoreCase("PH")&&bill_yn.equalsIgnoreCase("Y"))
			{
			%>
					<td class='<%=slClassValue%>' width="" nowrap><a class="gridLink"  href="javascript:callBilling('<%=i%>','<%=bean.checkForNull(register_details[2],"")%>','<%=bean.checkForNull(register_details[11],"")%>','<%=bean.checkForNull(register_details[14],"")%>','<%=bean.checkForNull(register_details[17],"")%>','<%=bean.checkForNull(register_details[19],"")%>','<%=bean.checkForNull(register_details[12],"")%>','<%=bean.checkForNull(register_details[0],"")%>','<%=bean.checkForNull(register_details[1],"")%>','<%=bean.checkForNull(order_line_num,"")%>','<%=bean.checkForNull(register_details[16],"")%>','<%=bean.checkForNull(register_details[18],"")%>','<%=bean.checkForNull(register_details[5],"")%>','<%=bean.checkForNull(register_details[8],"")%>','<%=bean.checkForNull(register_details[20],"")%>','<%=bean.checkForNull(register_details[21],"")%>','<%=menu_text1%>','<%=bean.checkForNull(register_details[2],"")%>','<%=bean.checkForNull(register_details[27],"")%>')" title='Charge Details'> <!--<fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/>--><fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/></a></td>
				<%//}%>
			<%}else if(bill_yn.equalsIgnoreCase("Y"))
				{%>
						<td class='<%=slClassValue%>' width="" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<%}%>
			<%}
			if(register_details[23] ==null ) 
				register_details[23] ="";	

			%>
				<input type=hidden name="ord_consent_status<%=i%>" id="ord_consent_status<%=i%>" value="<%=register_details[23]%>">
				<input type=hidden name="order_set_id<%=i%>" id="order_set_id<%=i%>" value="<%=bean.checkForNull(register_details[27],"")%>">
				<input type=hidden name="order_category<%=i%>" id="order_category<%=i%>" value="<%=bean.checkForNull(register_details[0],"")%>"><!--IN065942-->
				<input type=hidden name="prn_reg_ord<%=i%>" id="prn_reg_ord<%=i%>" value="<%=bean.checkForNull(register_details[29],"N")%>"><!--IN065942-->
				<input type="hidden" name="split_unbilled_order_yn<%=i%>" id="split_unbilled_order_yn<%=i%>" value="<%=split_unbilled_order_yn%>"><!-- IN071618  -->
		</tr>
<%
	i++;
	}
%>
</table>
</div>
<%--<input type=hidden name='total_recs' id='total_recs' value='<%//=allValues.size()%>'>--%>
<input type=hidden name='total_recs' id='total_recs' value='<%=i%>'>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type="hidden" name="view_by" id="view_by" value="<%=view_by%>">
<input type="hidden" name="ord_cat" id="ord_cat" value="<%=ord_cat%>">
<input type="hidden" name="single_multi" id="single_multi" value="<%=single_multi%>">
<input type="hidden" name="ord_type" id="ord_type" value="<%=ord_type%>">
<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
<input type="hidden" name="locn" id="locn" value="<%=locn%>">
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<input type="hidden" name="encntr_id" id="encntr_id" value="<%=encntr_id%>">
<input type="hidden" name="order_no" id="order_no" value="<%=order_no%>">
<input type="hidden" name="date_from" id="date_from" value="<%=date_from%>">
<input type="hidden" name="date_to" id="date_to" value="<%=date_to%>">
 <input type="hidden" name="performing_location_code" id="performing_location_code" value="<%=performing_location_code%>">
<input type="hidden" name="int_or_ext" id="int_or_ext" value="<%=int_or_ext%>">
<input type="hidden" name="specimen_no" id="specimen_no" value="<%=specimen_no%>">
<input type="hidden" name="activity_type" id="activity_type" value="<%=activity_type%>">
<input type="hidden" name="login_value" id="login_value" value="<%=login_value%>">
<input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>"><!--IN065942-->
  
 <!-- For Next & previous -->
<input type='hidden' name='from' id='from' value='<%=from%>'>
<input type='hidden' name='to' id='to' value='<%=to%>'>
<!-- IN071618 Starts -->

<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="called_from" id="called_from" value="">
<!-- IN071618 Ends -->
 <!-- For Next & previous -->
 <script>
			//if(parent.RegisterOrderHeader.document.getElementById("tableheader")==null)
			//{
				//setTimeout("alignHeading();",300);
			//}
			//else 
				//alignHeading();
			</script>

</form>
		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
					</td>
				</tr>
			</table>
		</div>
</body>
<script>parent.RegisterOrderSearch.document.register_order_search.search_btn.disabled = false;</script>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

