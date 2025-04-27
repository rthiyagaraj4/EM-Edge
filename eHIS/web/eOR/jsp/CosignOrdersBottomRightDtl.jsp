<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ConsignOrder.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onScroll="processScroll()" onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%	
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */


		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = "1" ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ConsignOrders" ;
	String bean_name = "eOR.ConsignOrders";
	String location="";
	//String disabled = "" ;

/* Mandatory checks end */

	/* Initialize Function specific start */

//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

/* Initialize Function specific end */


	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	if(practitioner_id == null || practitioner_id.equals("null")) practitioner_id= " ";
	String facility_id = (String)session.getValue("facility_id");
	if(facility_id == null || facility_id.equals("null")) facility_id= " ";
	String encounter_dtls="";
	String patientdetails="";
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id == null || resp_id.equals("null")) resp_id= " ";
	String pract_reln_id = (String)request.getParameter("relationship_id");
	if(pract_reln_id== null) pract_reln_id= "";



	//String[] allsess_vals = (String[])session.getValueNames();
//	for(int i=0; i<allsess_vals.length; i++)
	//out.println(allsess_vals[i]+" = ");


	String security_level = "";
	security_level = (String)session.getValue("security_level");
	if(security_level == null)
		security_level  = "1"; // needs to be replaced with session values
	request.setCharacterEncoding("UTF-8");
	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String patientId  	    = request.getParameter("patientId");
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String total_query_records  = "0";
 	//int total_records = 0;
	//out.println("source_type"+source_type);

	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();

	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ;

	ConsignOrders bean = (ConsignOrders)getBeanObject( bean_id, bean_name , request ) ;

	bean.setLanguageId(localeName);
//out.println("<script>alert('period_from==="+period_from+"=period_to=="+period_to+"==')</script>");
	String slClassValue = "";
	//String classValue = "";
	//int total = 0;

	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
 	//if(from!=null && from.equals("1")) {
 		bean.clear() ;
	//}

	ArrayList StatusDetail=new ArrayList();

	//if(from!=null && from.equals("1")){
		StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,resp_id,priority,ord_cat,order_by,patientId, period_from, period_to,start,end,"CS") ;
	//	bean.setDetails(StatusDetail);
	//}else{
	//	StatusDetail=bean.getDetails();
	//}

 


//	out.println(bean.chk);

	//String menu_security = "";
	//String menu_security1 = "";

%>
<form name='cosign_order_dtl' id='cosign_order_dtl'   action="../../eOR/jsp/CosignOrdersBottomRightDtl.jsp" method="post">
<div id="divHeadSep" >
<table cellpadding=3 cellspacing=0 border=1 width="100%" height="" id="tableresult" class="grid">
<tr id="heading">
		<td class='COLUMNHEADER' width='' nowrap><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></td>
	<%if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals("")){%>
		<td class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
	<%}%>

	<%if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals("")){	%>
		<td class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<%}%>
		<td class='COLUMNHEADER' width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER' width='' nowrap><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER' width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
	</tr>

<%





%>

		<%
		String tmp_ord_cat = "";
		String tmp_urgency = "";
		String fontValue ="";
		//String visit_admn_date = "";
		String cont_order_ind = "";
		int i = 0;

		/*if(StatusDetail.size() < 7 || end > StatusDetail.size()) {
			end = StatusDetail.size();
		}*/	


		//for( int i=0 ; i< StatusDetail.size() ; i++ ) {
 		for( int k=0 ; k< StatusDetail.size() ; k++ ) {
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}*/
				slClassValue="gridData";
				String slClassValueTmp = slClassValue;
				//String[] record = (String[])StatusDetail.get(i);
				String[] record = (String[])StatusDetail.get(k);
				for( int z=0 ; z<record.length ; z++ ) 
				{
					if(record[z]== null) record[z]="" ; else record[z] = record[z].trim();
				}
				if(record[13].equals("U")){
					fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
					record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

				}else if(record[13].equals("S")){
					fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				}else{
					fontValue = "<font size=1 color=black><b>";
					record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
					record[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
				}
					
					if(k==0){
						if(record[25] != null)
					total_query_records = bean.checkForNull((String)record[25],"0");%>
					<%if((Integer.parseInt(total_query_records)>0) || (start>1)){%>
					<tr  align="right">
						<td colspan="5">
							<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="from" value="<%=start%>"/>
							<jsp:param name="to" value="<%=end%>"/>
							<jsp:param name="check_box_name" value="chk"/>
							<jsp:param name="form_name" value="cosign_order_dtl"/>
							<jsp:param name="total_size" value="<%=total_query_records%>"/>
							</jsp:include>
						</td>
					</tr>
					<%}%>
				<%
				if(!(priority.equals(" "))){
	if(priority.equals("U")){
		out.println("<tr><td align=left class='ORRED' colspan=6>"+priority_desc+"</td></tr>");
	}else if(priority.equals("S")){
		out.println("<tr><td align=left class='ORBROWN' colspan=6>"+priority_desc+"</td></tr>");
	}else if(priority.equals("R")){
		out.println("<tr><th align=left  colspan=6>"+priority_desc+"</td></tr>");
	}
}
					if(!(ord_cat.equals(" "))){
						out.println("<tr><th align=left colspan=6>"+ord_cat_desc+"</td></tr>");
					}
				}
				cont_order_ind = (String)record[24];

				String sex1;
				sex1="";
				if (record[22].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(record[22].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(record[14].equalsIgnoreCase("C"))
	{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(record[14].equalsIgnoreCase("N"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}else if(record[14].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}
				patientdetails=record[11]+","+sex1+"/"+record[23]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[7];
			encounter_dtls=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+record[8]+","+location+"/"+record[5];
				//the following 2 if conditions are used to display in "group BY"
				//format of order category or urgency
				if(!(tmp_ord_cat.equals(record[1])) && (!(order_by.equals(" ") ||(order_by.equals("P"))))){
					out.println("<tr><th  colspan=6 align=\"left\">"+record[1]+"</th></tr>");
					tmp_ord_cat = record[1];
				}
				if(!(tmp_urgency.equals(record[2])) && (!(order_by.equals(" ") ||(order_by.equals("O"))))){
					out.println("<tr><th class=columnheader  colspan=6 align=\"left\" >"+record[2]+"</th></tr>");
					tmp_urgency = record[2];
				}
				
		%>

			<tr>
				<td  width='' nowrap id='status<%=i%>' class='<%=slClassValue%>'><input type=checkbox name='chk<%=i%>' id='chk<%=i%>'></td>

				<%if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals("")){%>
				<td width='' nowrap class='<%=slClassValue%>'><font size=1><%=record[1]%></font></td>
				<%}%>
				
				<%if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals("")){  %>
				<td width='' nowrap class='<%=slClassValue%>'><%=fontValue%><%=record[2]%></td>

				<% }%>
				<%
					slClassValue = slClassValueTmp;
				%>
				<td width='' nowrap class='<%=slClassValue%>'><font size=1><%=com.ehis.util.DateUtils.convertDate(record[9],"DMYHM","en",localeName)%></td> <!--  data of ordered AT -->
				<td width='' nowrap class='<%=slClassValue%>'><font size=1>
				<%
					if(record[10].indexOf("$$RD##")!=-1)
					{
						String[] str = (String[])record[10].split("!~!");
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
								if(strtitle.length>2)
									order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
								else
									order_detail = order_detail+strtitle[0]+", ";
							}
							else
							{
								order_detail = order_detail+str[s]+", ";
							}
						}
						record[10] = order_detail;
						if(record[10].lastIndexOf(",") ==((record[10].length())-2))
						{
							record[10] = record[10] .substring(0,((record[10].length())-2));
						}
					}
					if(record[10].indexOf("!~!")!=-1)
					{
						record[10] = record[10].replace("!~!",",");
					}
				%>
				<a class="gridLink" href='#' onClick="callMenuFunctions('View','<%=record[1]%>','<%=record[6]%>','<%=record[22]%>','<%=record[7]%>','<%=record[8]%>','<%=record[4]%>')"  ><%=record[10]%></a></td><!--  data of ordered Catalogs -->
				<td width='' nowrap class='<%=slClassValue%>'><font size=1><%=patientdetails%><BR><%=encounter_dtls%></td><!--  data of ordering locn details -->
				<input type=hidden name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=record[16]%>">
				<input type=hidden name='ord_status<%=i%>' id='ord_status<%=i%>' value="">
				<input type=hidden name='ord_consent_yn<%=i%>' id='ord_consent_yn<%=i%>' value="">
				<input type=hidden name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=record[6]%>">
				<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=record[19]%>">
				<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=record[7]%>">
				<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=record[13]%>">
				<input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=record[20]%>">
				<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>">
			</tr>
		<%
				i++;
			}
		%>
</table>
</div>

<%--<input type=hidden name='total_recs' id='total_recs' value='<%//=StatusDetail.size()%>'>--%>
<input type="hidden" name="from" id="from" value="<%=from%>">
<input type="hidden" name="to" id="to" value="<%=to%>">
<input type=hidden name='total_recs' id='total_recs' value='<%=i%>'>
<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">

<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="ord_cat" id="ord_cat" value="<%=ord_cat%>">
<input type="hidden" name="order_by" id="order_by" value="<%=order_by%>">
<input type="hidden" name="ord_cat_desc" id="ord_cat_desc" value="<%=ord_cat_desc%>">
<input type="hidden" name="priority_desc" id="priority_desc" value="<%=priority_desc%>">
<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>">
<script>
			//if(parent.CosignOrdersBottomRight0.document.getElementById("tableheader")==null)
			//{
				//setTimeout("alignHeading();",300);
			//}
			//else 
				//alignHeading();
</script>
</form>
</body>
<script>
parent.parent.parent.CosignOrderTop.document.cosign_order.search_btn.disabled = false;
//if(parent.CosignOrdersBottomRight0.document.cosign_order_hdg){
	//if(parent.CosignOrdersBottomRight0.document.cosign_order_hdg.select_all){
		//parent.CosignOrdersBottomRight0.document.cosign_order_hdg.select_all.disabled = false;
	//}
	if(document.getElementById("select_all"))
	{
		document.getElementById("select_all").disabled = false;
	}
</script>
</html>
<%
putObjectInBean( bean_id, bean , request ) ;
%>

