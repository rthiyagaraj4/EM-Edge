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
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
	<script language="JavaScript" src="../js/OrderEntryCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  	
			
</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%		
	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = "1" ;	
	String bean_id = "Or_PendingAppointmentbean" ;
	String bean_name = "eOR.PendingAppointmentbean";	
	/* Mandatory checks end */

	String practitioner_id = (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");	
	String facility_id =(String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");
	//String pract_reln_id = (String)request.getParameter("relationship_id")==null?"":(String)request.getParameter("relationship_id");	
	String security_level = "";
	security_level = (String)session.getValue("security_level")==null?"":(String)session.getValue("security_level");	
	request.setCharacterEncoding("UTF-8");
	String source_type= request.getParameter( "source_type" )==null?"":request.getParameter( "source_type" ) ;
	String source_code= request.getParameter( "source_code" ) ==null?"":request.getParameter( "source_code" ) ;
	String patientId  = request.getParameter("patientId")==null?"":request.getParameter( "patientId" ) ;
	String priority	= request.getParameter( "priority" ) ==null?"":request.getParameter( "priority" ) ;
	String ord_cat	= request.getParameter( "ord_cat" ) ==null?"":request.getParameter( "ord_cat" ) ;
	String order_by= request.getParameter( "order_by" ) ==null?"":request.getParameter( "order_by" ) ;
	String ord_cat_desc=request.getParameter("ord_cat_desc" )==null?"":request.getParameter( "ord_cat_desc" );
	String priority_desc= request.getParameter( "priority_desc" )==null?"":request.getParameter("priority_desc" );
	//String total_recs	= request.getParameter( "total_recs" ) ==null?"":request.getParameter( "total_recs" ) ;
	String period_from= request.getParameter("period_from")==null?"":request.getParameter( "period_from" ) ;
	String period_to	= request.getParameter("period_to")==null?"":request.getParameter( "period_to" ) ;

	/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added for take Filter criteria value from request . 
						*/
	String filter		= request.getParameter("filter")==null?"":request.getParameter( "filter" ) ;		
	String total_query_records  = "0";
	String catlog_code="";		

	PendingAppointmentbean bean = (PendingAppointmentbean)getBeanObject( bean_id, bean_name , request ) ;
	bean.setLanguageId(localeName);
	String slClassValue = "";	
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to); 	
 	bean.clear() ;
	ArrayList StatusDetail=new ArrayList();	
	StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,resp_id,priority,ord_cat,order_by,patientId, period_from, period_to,start,end,filter) ;	

%>
<form name='cosign_order_dtl' id='cosign_order_dtl'   action="../../eOR/jsp/PendingAppointmentBottomRightDtl.jsp" method="post">
<table cellpadding=3 cellspacing=0 border=1 width="100%" class="grid">
<%
	if(!(priority.equals(" ")))
	{
		if(priority.equals("U"))
		{
			out.println("<tr><td align=left class='ORRED' colspan=6>"+priority_desc+"</td></tr>");
		}
		else if(priority.equals("S"))
		{
			out.println("<tr><td align=left class='ORBROWN' colspan=6>"+priority_desc+"</td></tr>");
		}
		else if(priority.equals("R"))
		{
			out.println("<tr><th align=left  colspan=6>"+priority_desc+"</td></tr>");
		}
	}

	String tmp_ord_cat = "";
	String tmp_urgency = "";
	String fontValue ="";		
	String cont_order_ind = "";
	int i = 0;

 	for( int k=0 ; k< StatusDetail.size() ; k++ ) 
	{				
		slClassValue="gridData";
		String slClassValueTmp = slClassValue;				
		String[] record = (String[])StatusDetail.get(k);		
		
		if(record[7].equals("U"))
		{
			fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
			record[6]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

		}
		else if(record[7].equals("S"))
		{
			fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
			record[6]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}
		else
		{
			fontValue = "<font size=1 color=black><b>";
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			record[6]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
				
		catlog_code =(String)	bean.getCatalogCode(record[0],record[1]);

		if(record[20].equals("M"))
			record[20]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels") ;
		else
			record[20]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels") ;

		if(record[14].equals("C"))
			record[14]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels") ;
		else
			record[14]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels") ;

		if(k==0)
		{
			if(record[23] != null)
				total_query_records = bean.checkForNull((String)record[23],"0");
%>
			<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="from" value="<%=start%>"/>
			<jsp:param name="to" value="<%=end%>"/>
			<jsp:param name="check_box_name" value="chk"/>
			<jsp:param name="form_name" value="cosign_order_dtl"/>
			<jsp:param name="total_size" value="<%=total_query_records%>"/>
			</jsp:include>
<%				
			if(!(ord_cat.equals("")))
			{
				out.println("<tr><th align=left colspan=6>"+ord_cat_desc+"</td></tr>");
			}
		}

		cont_order_ind = (String)record[23];	

		/* the following 2 if conditions are used to display in "group BY"
		format of order category or urgency
		*/

		if(!(tmp_ord_cat.equals(record[6])) && (!(order_by.equals("") ||(order_by.equals("P")))))
		{
			out.println("<tr><th  colspan=6 align=\"left\">"+record[6]+"</th></tr>");
			tmp_ord_cat = record[6];
		}

		if(!(tmp_urgency.equals(record[8])) && (!(order_by.equals("") ||(order_by.equals("O")))))
		{
			out.println("<tr><td class=columnheader  colspan=6 align=\"left\" >"+record[8]+"</td></tr>");
			tmp_urgency = record[8];
		}						
				
%>
		<tr>
		<td  width='15%' id='status<%=i%>' class='<%=slClassValue%>'>
		<input type=checkbox name='chk<%=i%>' id='chk<%=i%>'  onclick="callAppointmentBooking1(this,'<%=record[17]%>','<%=record[15]%>','<%=record[14]%>','<%=record[9]%>','<%=replaceSplChars(record[10])%>','','<%=record[0]%>','<%=record[1]%>','<%=record[4]%>','<%=period_from%>','<%=com.ehis.util.DateUtils.convertDate(period_to,"DMYHM","en",localeName)%>','<%=catlog_code%>','<%=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en",localeName)%>')">
		</td>

<%
		if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals(""))
		{
%>
			<td width='15%' class='<%=slClassValue%>'><font size=1><%=record[6]%></font></td>
<%
		}

		if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals(""))
		{  
%>
			<td width='15%' class='<%=slClassValue%>'><%=fontValue%><%=record[8]%></td>

<%
		}

		slClassValue = slClassValueTmp;

		if(record[3].indexOf("$$RD##")!=-1)
		{
			String[] str = (String[])record[3].split("!~!");
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

			record[3] = order_detail;

			if(record[3].lastIndexOf(",") ==((record[3].length())-2))
			{
				record[3] = record[10] .substring(0,((record[3].length())-2));
			}
		}

		if(record[3].indexOf("!~!")!=-1)
		{
			record[3] = record[3].replace("!~!",",");
		}
%>				
		<td width='19%' class='<%=slClassValue%>'><font size=1><%=com.ehis.util.DateUtils.convertDate(record[2],"DMYHM","en",localeName)%></td> <!--  data of ordered AT -->
		<td width='15%' class='<%=slClassValue%>'><font size=1><a class='gridLink' href='#' onClick="callMenuFunctions('View','<%=record[6]%>','<%=record[0]%>','<%=record[20]%>','<%=record[17]%>')"  ><%=record[3]%></a></td><!--  data of ordered Catalogs -->
		<td width='40%' class='<%=slClassValue%>'><font size=1><%=record[19]%>,<%=record[20]%>/<%=record[22]%>,<fmt:message key="eOR.ID:.label" bundle="${or_labels}"/><%=record[17]%><BR><fmt:message key="eOR.Encounter Dtls:.label" bundle="${or_labels}"/><%=record[18]%>,<%=record[14]%>/<%=record[16]%></td><!--  data of ordering locn details -->
		<input type=hidden name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=record[5]%>">				
		<input type=hidden name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=record[0]%>">
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=record[12]%>">
		<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=record[17]%>">
		<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=record[7]%>">
		<input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=record[21]%>">
		<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=record[11]%>">
		</tr>
<%
		i++;
	}
%>
</table>

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
<input type="hidden" name="filter" id="filter" value="<%=filter%>">
</form>
</body>
<script>

parent.parent.parent.CosignOrderTop.document.cosign_order.search_btn.disabled = false;
if(parent.CosignOrdersBottomRight0.document.cosign_order_hdg)
{
	if(parent.CosignOrdersBottomRight0.document.cosign_order_hdg.select_all)
	{
		parent.CosignOrdersBottomRight0.document.cosign_order_hdg.select_all.disabled = false;
	}
}
</script>
</html>
<%
	putObjectInBean( bean_id, bean , request );
%>
<%!
public String replaceSplChars(String input)
{
	if (input==null) return input;
	if(input.indexOf("'")!=-1)
		input = input.replaceAll("'","~##");
	
	return input;
}
%>

