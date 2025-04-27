<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
  <%@page contentType="text/html;charset=UTF-8"%>   
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--  -->
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ReprintForms.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	
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
       
	</STYLE>
	<SCRIPT>
	function alignHeading()
	{
		
		if(parent.ReprintFormsHeader.document.getElementById("TitleTab") != null) 
		{
			
			parent.ReprintFormsHeader.document.getElementById("TitleTab").width =	eval(document.getElementById("reprint_table").offsetWidth);
				
			var last_row = eval(document.getElementById("reprint_table").rows.length)-1;
			for (j=0; j < document.getElementById("reprint_table").rows(last_row).cells.length; j++) 
			{
				var wid=eval(document.getElementById("reprint_table").rows(last_row).cells(j).offsetWidth);
				if(parent.ReprintFormsHeader.document.getElementById("TitleTab").rows(0).cells(j) != null)
				{
					parent.ReprintFormsHeader.document.getElementById("TitleTab").rows(0).cells(j).width=wid;
				}
			}
		}
		else
		{
			setTimeout("alignHeading();",300);
		}
	}
	</SCRIPT>

</head>
<body onload='alignHeading();' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String mode			= "1";//request.getParameter( "mode" ) ;

	String report_type	= request.getParameter("rep_type");
	String ord_cat 		= request.getParameter( "ord_cat" ) ;
	String ord_type 	= request.getParameter( "ord_type" ) ;
	String source_type 	= request.getParameter( "source_type" ) ;
	String source_from	= request.getParameter("source_from");
	String source_to	= request.getParameter("source_to");
	String locntype		= request.getParameter("locntype");
	String locn 		= request.getParameter( "locn" ) ;
	String patient_id 	= request.getParameter( "patientId" ) ;
	String encntr_id 	= request.getParameter( "encntr_id" ) ;
	String order_id 	= request.getParameter( "order_id" ) ;
	String date_from 	= request.getParameter( "date_from" ) ;
	String date_to 		= request.getParameter( "date_to" ) ;
	String total_query_records="0";

	report_type			= (report_type == null) ? "":report_type.trim();
	ord_cat 			= (ord_cat == null)? "":ord_cat.trim();
	ord_type 			= (ord_type == null)?"":ord_type.trim();
	source_type 		= (source_type == null)?"":source_type.trim();
	source_from 		= (source_from == null)?"":source_from.trim();
	locn 				= (locn == null)?"":locn.trim();
	patient_id 			= (patient_id == null)?"":patient_id.trim();
	encntr_id 			= (encntr_id == null)?"":encntr_id.trim();
	order_id 			= (order_id == null)?"":order_id.trim();
	date_from 			= (date_from == null)?"":date_from.trim();
	date_to 			= (date_to == null)?"":date_to.trim();

	/*System.out.println("#####report_type"+report_type);
	System.out.println("#####ord_cat"+ord_cat);
	System.out.println("#####ord_type"+ord_type);
	System.out.println("#####source_type"+source_type);
	System.out.println("#####source_from"+source_from);
	System.out.println("#####locn"+locn);
	System.out.println("#####patient_id"+patient_id);
	System.out.println("#####encntr_id"+encntr_id);
	System.out.println("#####order_id"+order_id);
	System.out.println("#####date_from"+date_from);
	System.out.println("#####date_to"+date_to);*/
	
	//String function_id 	= request.getParameter( "function_id" ) ;
	String bean_id 		= "ReprintFormsBean" ;
	String bean_name 	= "eOR.ReprintFormsBean";

	String practitioner_id 	= (String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id");
	String resp_id 			= (String)session.getValue("responsibility_id");

	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";
//out.println("facility_id:"+facility_id);
//out.println(">"+practitioner_id+"<<br>");
//out.println(">"+resp_id+"<");
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	ReprintFormsBean bean = (ReprintFormsBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);
 
	allValues		= bean.getSearchDetails(report_type,ord_cat,ord_type,order_id,date_from,date_to,source_type,source_from,source_to,patient_id,encntr_id,facility_id,start,end);

	//out.println("<script>alert("+allValues.size()+")</script>");
	 
/* Initialize Function specific end */
//out.println("<script>alert('allValues.size()="+allValues.size()+"');</script>");
//out.println("<script>alert('report_type="+report_type+"');</script>");

	if(allValues.size() == 0){
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.ReprintFormsSearch.document.reprint_forms_search.search_btn.disabled = false;
			parent.ReprintFormsHeader.location.href = "../../eCommon/html/blank.html"
			parent.ReprintFormsResult.location.href = "../../eCommon/html/blank.html"
			parent.ReprintFormsBtn.location.href = "../../eCommon/html/blank.html"
		</script>

<%	}
%>
<form name='reprint_forms_dtl' id='reprint_forms_dtl'  method="post" action="../../eOR/jsp/ReprintFormsResults.jsp">
<table cellpadding=0 cellspacing=0 border=1 width="101%" class="grid">
<%
	String slClassValue = "";
		//int i = 0;
	for(int i=0; i<allValues.size(); i++){
			String[] reprint_details = (String[])allValues.get(i);
		if(i==0){
			if(report_type.equalsIgnoreCase("R")){
				if(reprint_details[25] != null)
				total_query_records=bean.checkForNull((String)reprint_details[25],"0");}
			else if (report_type.equalsIgnoreCase("C")){
				if(reprint_details[27] != null)
				total_query_records=bean.checkForNull((String)reprint_details[27],"0");}
			else if (report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))
				{
				if(reprint_details[28] != null)
				total_query_records=bean.checkForNull((String)reprint_details[28],"0");}
			else{
				if(reprint_details[24] != null)
				total_query_records=bean.checkForNull((String)reprint_details[24],"0");
			}
			
//			out.println("<script>alert('total_query_records="+total_query_records+"');</script>");%>
				
			<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="from" value="<%=start%>"/>
			<jsp:param name="to" value="<%=end%>"/>
			<jsp:param name="check_box_name" value="chk"/>
			<jsp:param name="total_size" value="<%=total_query_records%>"/>
			<jsp:param name="form_name" value="reprint_forms_dtl"/>
			</jsp:include>
		<%}
		
		reprint_details[0] = (reprint_details[0] == null)?"":reprint_details[0];
		reprint_details[1] = (reprint_details[1] == null)?"":reprint_details[1];
		reprint_details[2] = (reprint_details[2] == null)?"":reprint_details[2];
		reprint_details[3] = (reprint_details[3] == null)?"":reprint_details[3];
		reprint_details[4] = (reprint_details[4] == null)?"":reprint_details[4];
		reprint_details[5] = (reprint_details[5] == null)?"":reprint_details[5];
		reprint_details[6] = (reprint_details[6] == null)?"":reprint_details[6];
		reprint_details[7] = (reprint_details[7] == null)?"":reprint_details[7];
		reprint_details[8] = (reprint_details[8] == null)?"":reprint_details[8];
		reprint_details[9] = (reprint_details[9] == null)?"":reprint_details[9];
		reprint_details[10] = (reprint_details[10] == null)?"":reprint_details[10];
		reprint_details[11] = (reprint_details[11] == null)?"":reprint_details[11];
		reprint_details[12] = (reprint_details[12] == null)?"":reprint_details[12];
		reprint_details[13] = (reprint_details[13] == null)?"":reprint_details[13];
		reprint_details[14] = (reprint_details[14] == null)?"":reprint_details[14];
		reprint_details[15] = (reprint_details[15] == null)?"":reprint_details[15];
		reprint_details[16] = (reprint_details[16] == null)?"":reprint_details[16];
		reprint_details[17] = (reprint_details[17] == null)?"":reprint_details[17];
		reprint_details[18] = (reprint_details[18] == null)?"":reprint_details[18];
		reprint_details[19] = (reprint_details[19] == null)?"":reprint_details[19];
		reprint_details[20] = (reprint_details[20] == null)?"":reprint_details[20];
		reprint_details[21] = (reprint_details[21] == null)?"":reprint_details[21];
		reprint_details[22] = (reprint_details[22] == null)?"":reprint_details[22];
		reprint_details[23] = (reprint_details[23] == null)?"":reprint_details[23];
		//out.println("<script>alert("+reprint_details[23]+")</script>");
		if (report_type.equalsIgnoreCase("R"))
			reprint_details[24] = (reprint_details[24] == null)?"":reprint_details[24];
		//out.println("<script>alert("+reprint_details[24]+")</script>");
		else if (report_type.equalsIgnoreCase("C")) {

			reprint_details[24] = (reprint_details[24] == null)?"":reprint_details[24];
			reprint_details[25] = (reprint_details[25] == null)?"":reprint_details[25];
			reprint_details[26] = (reprint_details[26] == null)?"":reprint_details[26];
			//out.println("<script>alert("+reprint_details[24]+")</script>");
		}
	
		else if (report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X")) {
			reprint_details[24] = (reprint_details[24] == null)?"":reprint_details[24];
			reprint_details[25] = (reprint_details[25] == null)?"":reprint_details[25];
			reprint_details[26] = (reprint_details[26] == null)?"":reprint_details[26];
			reprint_details[27] = (reprint_details[27] == null)?"":reprint_details[27];
			//out.println("<script>alert("+reprint_details[27]+")</script>");
		}
		

		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";
		
		%>
		<TR>
			<!--<td width='6%' class='<%=slClassValue%>' wrap> <font size=1><%=(report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))?reprint_details[27]:(report_type.equalsIgnoreCase("R")?reprint_details[24]:"")%></font></td>-->
			<%if (reprint_details[10]== null || reprint_details[10] == "null") reprint_details[10]="";
			String ReprintDate;
			if ( !localeName.equals("en") )
			{ 
				 ReprintDate 	=com.ehis.util.DateUtils.convertDate(reprint_details[10],"DMYHM","en",localeName);
			}
			else
			{
					ReprintDate=reprint_details[10];
			}

			if(reprint_details[11].indexOf("$$RD##")!=-1)
			{
				String[] str = (String[])reprint_details[11].split("!~!");
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
				reprint_details[11] = order_detail;
				if(reprint_details[11].lastIndexOf(",") ==((reprint_details[11].length())-2))
				{
					reprint_details[11] = reprint_details[11] .substring(0,((reprint_details[11].length())-2));
				}
			}
			if(reprint_details[11].indexOf("!~!")!=-1)
			{
				reprint_details[11] =reprint_details[11].replace("!~!",",");
			}
			%>
			<td width='15%' class='<%=slClassValue%>' wrap> <font size=1><%=ReprintDate%></font></td>
			<td width='25%' class='<%=slClassValue%>' wrap> <font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=reprint_details[2]%>','<%=reprint_details[7]%>','<%=reprint_details[23]%>','<%=reprint_details[8]%>')"> <%=reprint_details[11]%></a></font></td>
			<td width='40%' class='<%=slClassValue%>' wrap> <font size=1><%=reprint_details[3]%></font></td>
			<td width='9%' class='<%=slClassValue%>' wrap> <font size=1><%=reprint_details[20]%></font></td>
			<td width='10%' class='<%=slClassValue%>' align='center'> <input type='checkbox' name='chk<%=i%>' id='chk<%=i%>' value='N' onClick='changeCheckValue(this,"<%=i%>")' <%=(report_type.equals("L"))?"disabled":""%> style="display:<%=(report_type.equals("C"))?"none":"inline"%>">
			
			<%
				if(report_type.equals("C")){ 	
					//System.out.println("========="+reprint_details[7]+"======="+reprint_details[25]+"==="+reprint_details[24]);
					ArrayList Consents = bean.getConsents(reprint_details[7],reprint_details[25],reprint_details[24]);
					for(int j=0;j<Consents.size();j++){
						String[] record = (String[])Consents.get(j);
						//System.out.println("========="+reprint_details[7]+"======="+reprint_details[25]+"==="+record[2]);
						%><A class='gridLink' HREF="#" title='<fmt:message key="eOR.ClickLinkToPrintConsentDetails.label" bundle="${or_labels}"/>' onClick="callConsent('<%=reprint_details[7]%>','<%=reprint_details[25]%>','<%=record[2]%>')"><FONT SIZE="1" ><B><%if(Consents.size()!=1)out.println(j+1+". ");%><%=record[1]%></B></FONT></A><br><%
					}
				}
			
			%>
			
			</td>


			<input type='hidden' name='ord_id<%=i%>' id='ord_id<%=i%>' value='<%=reprint_details[7]%>'>
			<input type='hidden' name='ord_cat<%=i%>' id='ord_cat<%=i%>' value='<%=reprint_details[0]%>'>
			<input type='hidden' name='pat_class<%=i%>' id='pat_class<%=i%>' value='<%=reprint_details[5]%>'>
			<input type='hidden' name='pat_id<%=i%>' id='pat_id<%=i%>' value='<%=reprint_details[8]%>'>
			<input type='hidden' name='encounter_id<%=i%>' id='encounter_id<%=i%>' value='<%=reprint_details[9]%>'>
			<input type='hidden' name='order_date_time<%=i%>' id='order_date_time<%=i%>' value='<%=reprint_details[10]%>'>
			<input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value='<%=(report_type.equalsIgnoreCase("C")|| report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))?reprint_details[24]:""%>'>
			<input type='hidden' name='source_types<%=i%>' id='source_types<%=i%>' value='<%=reprint_details[12]%>'>
			<input type='hidden' name='source_code<%=i%>' id='source_code<%=i%>' value='<%=reprint_details[13]%>'>
			<input type='hidden' name='priority<%=i%>' id='priority<%=i%>' value='<%=reprint_details[14]%>'>
			<input type='hidden' name='order_type<%=i%>' id='order_type<%=i%>' value='<%=reprint_details[15]%>'>
			<input type='hidden' name='order_type_desc<%=i%>' id='order_type_desc<%=i%>' value='<%=reprint_details[16]%>'>
			<input type='hidden' name='ord_pract_id<%=i%>' id='ord_pract_id<%=i%>' value='<%=reprint_details[17]%>'>
			<input type='hidden' name='order_status<%=i%>' id='order_status<%=i%>' value='<%=reprint_details[19]%>'>
			<input type='hidden' name='order_line_num<%=i%>' id='order_line_num<%=i%>' value='<%=(report_type.equalsIgnoreCase("C")|| report_type.equalsIgnoreCase("S")||report_type.equalsIgnoreCase("X"))?reprint_details[25]:""%>'>
			<input type='hidden' name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value='<%=reprint_details[22]%>'>
			<input type='hidden' name='facility_id<%=i%>' id='facility_id<%=i%>' value='<%=facility_id%>'>
			<input type='hidden' name='location_type<%=i%>' id='location_type<%=i%>' value='<%=locntype%>'>
			<input type='hidden' name='location_code<%=i%>' id='location_code<%=i%>' value='<%=locn%>'>
			<input type='hidden' name='report_srl_no<%=i%>' id='report_srl_no<%=i%>' value='<%=(report_type.equalsIgnoreCase("R")?reprint_details[24]:(report_type.equalsIgnoreCase("X")||report_type.equalsIgnoreCase("S"))?reprint_details[27]:"")%>'>
		</TR>
	<%
				}
%>
	<input type='hidden' name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
	<!-- Next, Prev --> 
	<input type="hidden" name="from" id="from" value="<%=from%>" >
	<input type="hidden" name="to" id="to" value="<%=to%>" >
<!-- Next, Prev Till here--> 

	<input type='hidden' name='report_type' id='report_type' value='<%=report_type%>'>
	<%--<input type='hidden' name='source_type' id='source_type' value='<%=locntype%>'>--%> <%--print_at_locn_type--%>
	<input type='hidden' name='location_code' id='location_code' value='<%=locn%>'>  <%--print_at_locn--%>
	<input type='hidden' name='date_from' id='date_from' value='<%=date_from%>'>  <%--date_from--%>
	<input type='hidden' name='date_to' id='date_to' value='<%=date_to%>'>  <%--date_to--%>
	<input type='hidden' name='location_type' id='location_type' value='<%=source_type%>'>  <%--source_type--%>
	<input type='hidden' name='locn2' id='locn2' value='<%=source_from%>'>  <%--source_from--%>
	<input type='hidden' name='locn1' id='locn1' value='<%=source_to%>'>  <%--source_to--%>
	<input type='hidden' name='order_type' id='order_type' value='<%=ord_type%>'>  <%--ord_type--%>
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>  <%--patient_id--%>
	<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>  <%--order_id--%>
	<input type='hidden' name='encntr_id' id='encntr_id' value='<%=encntr_id%>'>  <%--order_id--%>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
	<input type='hidden' name='rep_type' id='rep_type' value='<%=request.getParameter("rep_type")%>'>
	<input type='hidden' name='ord_cat' id='ord_cat' value='<%=request.getParameter("ord_cat")%>'>

	<input type='hidden' name='ord_type' id='ord_type' value='<%=request.getParameter("ord_type")%>'>
	<input type='hidden' name='source_from' id='source_from' value='<%=request.getParameter("source_from")%>'>
	<input type='hidden' name='source_to' id='source_to' value='<%=request.getParameter("source_to")%>'>
	<input type='hidden' name='patientId' id='patientId' value='<%=request.getParameter("patientId")%>'>
	<input type='hidden' name='locntype' id='locntype' value='<%=request.getParameter("locntype")%>'>
	<input type='hidden' name='source_type' id='source_type' value='<%=request.getParameter("source_type")%>'>
	<input type='hidden' name='locn' id='locn' value='<%=request.getParameter("locn")%>'>

</Table>
<script>
parent.ReprintFormsSearch.document.reprint_forms_search.search_btn.disabled = false;
</script>
</Form>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

