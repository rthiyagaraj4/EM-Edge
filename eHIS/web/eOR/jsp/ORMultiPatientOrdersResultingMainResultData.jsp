<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,eCommon.Common.*,eOR.Common.*,eCommon.XSSRequestWrapper" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%!int row_count=0;%>
<html>
<head><title>MultiPatientOrdersResultingHdr</title>
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
		
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="JavaScript" src="../../eOR/js/ORMultiPatientOrdersResultingReport.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script><!-- used for date validation-->
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	/* Mandatory checks start */


	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";
	String facility_id = (String)session.getValue("facility_id");

	String text_area_exists = request.getParameter("text_area_exists");
	int count = Integer.parseInt(request.getParameter("count"));
	String result_format = request.getParameter("result_format");

	String header_values = request.getParameter("header_values");

	String order_values = request.getParameter("order_values");
	String location			= "";
	String catalog_desc		= "";
	String catalog_code		= "";
	String patient_name		= "";
	String patient_id		= "";
	String order_start_time = "";
	String classval			= "";
	String order_id			= "";
	String order_line_num	= "";
	String order_type_code	= "";
	String encounter_id		= "";
	String patient_class	= "";
	String sex="";


	String header_location_type		= "";
	String header_locn				= "";
	String header_period_from		= "";
	String header_period_to			= "";
	String header_order_category	= "";
	String header_order_type		= "";
	String header_order_catalog_code = "";
	String header_result_format_code = "";
	String group_by					= "";
	if(header_values!=null && !header_values.equals("") && !header_values.equals("null"))
	{
		StringTokenizer st = new StringTokenizer(header_values,"~~~");
		while(st.hasMoreElements())
		{
			header_location_type			= st.nextToken();
			header_locn						= st.nextToken();
			header_period_from				= st.nextToken();
			header_period_to				= st.nextToken();
			header_order_category			= st.nextToken();
			header_order_type				= st.nextToken();
											  st.nextToken();
			header_order_catalog_code		= st.nextToken();
											  st.nextToken();
			header_result_format_code		= st.nextToken();
			group_by						= st.nextToken();
											  st.nextToken();
											  st.nextToken();
											  st.nextToken();
			header_location_type			= header_location_type.trim();
			header_locn						= header_locn.trim();
			header_period_from				= header_period_from.trim();
			header_period_to				= header_period_to.trim();
			header_order_category			= header_order_category.trim();
			header_order_type				= header_order_type.trim();
			header_order_catalog_code		= header_order_catalog_code.trim();
			header_result_format_code		= header_result_format_code.trim();
			group_by						= group_by.trim();
		}
	}
	ArrayList allValues = new ArrayList();
	allValues.add(header_order_catalog_code);
	allValues.add(header_order_category);
	allValues.add(header_order_type);
	allValues.add(result_format);
	allValues.add(header_period_from);
	allValues.add(header_period_to);
	allValues.add(header_location_type);
	allValues.add(header_locn);
	allValues.add(group_by);
	allValues.add(order_values);
	allValues.add(facility_id);
	String[] resultList = null;

	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;


	int row_disp=OrRepository.DISPLAY_MIN_RECORDS;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String dispMode="";

	String temp_dispMode="", temp_from="", temp_to="";

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;


	eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();

	dispMode			=	request.getParameter("dispMode") ;
	from				=	request.getParameter("from") ;
	to					=	request.getParameter("to") ;

	temp_dispMode		=	dispMode;
	temp_from			=	from;
	temp_to				=	to;


	if ( from == null || from=="null" || from.equals("null") )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp - 1;
	else
		end = Integer.parseInt( to ) ;

	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(dispMode.equals(""))
	{
		bean.getOrdersResultingValues(allValues);

		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
		row_count			=  MultiRecordSet.getSize("DB");
		
		if(row_count ==0)
		{
			%>
			<script>
				resultingRecordsNotFound();
			</script>
			<%
		}
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start);
		to   = ""+(end);
	}
	else
	{
//		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
		}else if(dispMode.equals("Previous")){
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
		if(to_val > (row_count-1))
			to_val=(row_count-1);
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
%>
<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="multiPatientOrdersResultingMainResult" id="multiPatientOrdersResultingMainResult">
<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
<%
if(dispMode.equals(""))
{
	for(int i=0;i<row_count;i++)
	{
		htListRecord		= (java.util.HashMap)	MultiRecordSet.getObject(i);
		resultList = (String[]) htListRecord.get("result");
		order_id		= resultList[0];
		order_line_num	= resultList[1];
		order_type_code = resultList[10];
		catalog_code	= resultList[2];
		patient_id		= resultList[5];
		encounter_id	= resultList[11];
		patient_class	= resultList[12];
		sex	= resultList[13];
		%>
		<input type="hidden" name="order_id<%=i%>" id="order_id<%=i%>" value="<%=order_id%>">
		<input type="hidden" name="order_line_num<%=i%>" id="order_line_num<%=i%>" value="<%=order_line_num%>">
		<input type="hidden" name="order_type_code<%=i%>" id="order_type_code<%=i%>" value="<%=order_type_code%>">
		<input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=catalog_code%>">
		<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id<%=i%>" id="encounter_id<%=i%>" value="<%=encounter_id%>">
		<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=patient_class%>">
	<%
	}
	%>
		<script>
		loadOrderValues();
		</script>
	<%
}
%>

<div id='divUnitTitle' style='postion:relative'>
	<table border='1' width='100%' id='unitTitleTable' >
		<TR>
			<!--<TD style="width: 35px;" class="COLUMNHEADER">
			</TD>-->
			<TD style="width: 125px;" class="COLUMNHEADER" nowrap>
				 <fmt:message key="Common.Location.label" bundle="${common_labels}"/>		 
			</TD>
			<TD style="width: 125px;" class="COLUMNHEADER" nowrap> 
				 <fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>			 
			</TD>
			<TD style="width: 125px;" class="COLUMNHEADER" nowrap>
				 <fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			</TD>
		</TR>
		<TR>
			<!--<TD style="width: 25px;" class="COLUMNHEADER">&nbsp;
			</TD>-->
			<TD class="COLUMNHEADER" nowrap>
				 <fmt:message key="eOR.OrderStartDate.label" bundle="${or_labels}"/>
			</TD>
			<TD class="COLUMNHEADER" colspan="2" nowrap>			 
				  <fmt:message key="Common.catalog.label" bundle="${common_labels}"/>
			</TD>
		</TR>
	</table>
</div>
<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
	<tr align='right' width='10%'>
	<%
	
	if ( (!(start <= 1)) && (start < row_count)){
	%>
		<td class='WHITE' width='89%'>&nbsp;</td>
		<td class='WHITE' width='11%'>
		<!--<A HREF='javascript:onClick=submitPage("Previous");' text-decoration='none' >Previous</A>-->
		</td>
	<%	
	}
//	if ( !( (start+row_disp) > row_count ) ){
	if ( !( (start+row_disp) >= row_count ) ){
	%>
		<td class='WHITE' width='94%'>&nbsp;</td>
		<td class='WHITE' width='6%'>
		<!--<A HREF='javascript:onClick=submitPage("Next");' text-decoration='none' >Next</A>-->
		</td>
	<%
	}
	%>
	</tr>
</table> 
<table width="100%" border="0" id='unitTable' style="border-bottom:#ffffff">
<%
for(int i=fm_disp;i<=to_disp;i++)
{
	
	if(i % 2 == 0 )
	{
		classval	=	"CACHARTQRYEVEN";
	}
	else
	{
		classval	=	"CACHARTQRYEVEN";
	}

	htListRecord		= (java.util.HashMap)	MultiRecordSet.getObject(i);
	resultList = (String[]) htListRecord.get("result");

	order_id = resultList[0];
	location = resultList[9];
	patient_name = resultList[6];
	patient_id = resultList[5];
	order_start_time = resultList[4];
	catalog_desc = resultList[3];
	if(catalog_desc==null)
		catalog_desc ="";
	if(order_start_time==null)
		order_start_time ="";
	if(patient_name==null)
		patient_name ="";
	if(location==null)
		location ="";
	if(patient_id==null)
		patient_id ="";

	if(!localeName.equals("en"))
	{
		order_start_time = com.ehis.util.DateUtils.convertDate(order_start_time,"DMYHM","en",localeName);
	}


%>

	<TR>
		<!--<TD style="width: 35px;" class="<%=classval%>" align="left">&nbsp;
			
		</TD>-->
		<TD style="width: 125px;" class="<%=classval%>" align="left" nowrap>
			<%=location%>
		</TD>
		<TD style="width: 125px;" class="<%=classval%>" nowrap>
			 <%=patient_name%>
		</TD>
		<TD style="width: 125px;" class="<%=classval%>" nowrap>
			<%=patient_id%>
		</TD>
	
	</TR>
	<TR>
		<!--<TD style="width: 25px;" class="<%=classval%>">&nbsp;
		<a href="#" onClick="displayOrder('<%=order_id%>','<%=sex%>','<%=patient_class%>','<%=encounter_id%>','<%=patient_id%>')"> + </a>
		</TD>-->
		<TD class="<%=classval%>" nowrap>
			&nbsp; <%=order_start_time%>
		</TD>
		<TD class="<%=classval%>" colspan="2" align="left" nowrap>
			&nbsp; <a href="#" onClick="displayOrder('<%=order_id%>','<%=sex%>','<%=patient_class%>','<%=encounter_id%>','<%=patient_id%>')"> <%=catalog_desc%> </a>
		</TD>
		
	</TR>
<%
}
%>
	<!--<TR style="display: none;">
		<TD class="<%=classval%>">&nbsp;</TD>
		<TD class="<%=classval%>">&nbsp;</TD>
		<TD class="<%=classval%>">&nbsp;</TD>
		<TD class="<%=classval%>">&nbsp;</TD>
	</TR>
	<TR style="display: none;">
		<TD class="<%=classval%>">&nbsp;</TD>
		<TD class="<%=classval%>">&nbsp;</TD>
		<TD class="<%=classval%>" colspan="2">&nbsp;</TD>
	</TR>--> 
</table>

<input type="hidden" name="text_area_exists" id="text_area_exists" value=<%=text_area_exists%> >
<input type="hidden" name="count" id="count" value=<%=count%> >
<input type="hidden" name="result_format" id="result_format" value=<%=result_format%> >
<input type="hidden" name="header_values" id="header_values" value=<%=header_values%> >
<input type="hidden" name="order_values" id="order_values" value=<%=order_values%> >

<input type="hidden" name="from" id="from" value="<%=from%>">
<input type="hidden" name="to" id="to" value=<%=to%>>

<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> >
<input type="hidden" name="temp_dispMode" id="temp_dispMode" value=<%=temp_dispMode%> >
<input type="hidden" name="temp_from" id="temp_from" value="<%=temp_from%>">
<input type="hidden" name="temp_to" id="temp_to" value=<%=temp_to%>>
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
<script>
	setTimeout("alignUnitsAndTitle()",100);
	loadResultingMainResult1();
	parent.multiPatientOrdersResultingMainButtons.location.href="../../eOR/jsp/ORMultiPatientOrdersResultingMainButtons.jsp";
</script>
</form>
</body>
</html>
<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);
%>

