<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@page import="java.util.ArrayList" %>
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
	//String legendstyle="padding-left:0px;padding-right:0px";
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script><!-- used for date validation-->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language="JavaScript" src="../../eOR/js/ORMultiPatientOrdersResultingReport.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload='FocusFirstElement();enableSearch()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;

	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";
	String facility_id = (String)session.getValue("facility_id");
	String billed_trxn_yn 		= (String)session.getValue("billed_trxn_yn");

	/* Initialize Function specific start */
	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
//	bean.clear() ;
	bean.setMode( mode ) ;


	String location_type = request.getParameter("location_type");
	String locn = request.getParameter("locn");
	String period_from = request.getParameter("period_from");
	String period_to = request.getParameter("period_to");
	String order_category = request.getParameter("order_category");
	String order_type = request.getParameter("order_type");
	String result_format = request.getParameter("result_format");
	String order_catalog = request.getParameter("order_catalog");
	String group_by = request.getParameter("group_by");
	String result_type = request.getParameter("result_type");
	
	

	ArrayList resultFormatRecords = null;

	String ivalues = request.getParameter("ivalues");
	if(ivalues==null)
		ivalues = "";
	if(result_format==null || result_format.equals(""))
	{
		
		resultFormatRecords = (ArrayList)bean.getResultFormatting(period_from,period_to,order_category,order_type,order_catalog,facility_id,location_type,locn.trim());
		
		for (int i=0;i<resultFormatRecords.size();i++)
		{
			String records[] = (String[])resultFormatRecords.get(i);
			result_format = records[0];
			break;
		}
	}
//	if(result_type == null || result_type.equals(""))
//	{
		result_type = bean.getResultType(result_format);
//	}

	if(order_type==null)
	{
		order_type="";
	}

	//  New Code Starts Here
	
	int row_disp=OrRepository.DISPLAY_MIN_RECORDS;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String dispMode="";

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;


	eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();

	dispMode			=	request.getParameter("dispMode") ;
	from				=	request.getParameter("from") ;
	to					=	request.getParameter("to") ;


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
		ArrayList allValues = new ArrayList();
		allValues.add(order_catalog);
		allValues.add(order_category);
		allValues.add(order_type);
		allValues.add(result_format);
		allValues.add(period_from);
		allValues.add(period_to);
		allValues.add(location_type);
		allValues.add(locn);
		allValues.add(group_by);
		allValues.add(facility_id);
		bean.getOrdersResulting(allValues);
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
		row_count			=  MultiRecordSet.getSize("DB");

		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start);
		to   = ""+(end);
		
		if(row_count ==0)
		{
			%>
			<script>
				recordsNotFound();
			</script>
			<%
		}
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
		MultiRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
		
	}
	String code = "";
	String tempCode = "";
	int groupCount=0;
	int indGrpCount = 0;


	String order_id			= "";
	String order_line_num	= "";
	String catalog_code		= "";
	String catalog_desc		= "";
	String start_datetime	= "";
	String patient_id		= "";
	String patient_name		= "";
	String location_type_val= "";
	String location_code	= "";
	String location_name	= "";
	String sex	= "";
	String patient_class	= "";
	String encounter_id	= "";

	int page_count			= 0;

	String classval			= ""; 


%>

<form name="multiPatientOrdersResultingHdrResult" id="multiPatientOrdersResultingHdrResult" target='' action='' method='POST'>

<table cellpadding=0 cellspacing=0 border='1' width='100%' align=center >
	<TR id="divTitleTable">
		<!--<TD width="5%" class="COLUMNHEADER" id="select_yn">&nbsp;
		</TD>-->
		<TD class="COLUMNHEADER" id="select_yn"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><Input Type='CheckBox' name='CheckMultiOrderPatient1' id='CheckMultiOrderPatient1' value="" class='Header'  align ='center' onClick='clickAll()'></TD>
		<%
		if(group_by.equals("P"))
		{
		%>
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="eOR.StartDateTime.label" bundle="${or_labels}"/></TD>
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></TD>
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
		<%
		}
		else if (group_by.equals("O"))
		{
		%>			
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></TD>
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></TD>
			<TD class="COLUMNHEADER" width="30%" align="center"> <fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
		<%
		}
		else if (group_by.equals("C"))
		{
		%>
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></TD>
			<TD class="COLUMNHEADER" width="15%" align="center"><fmt:message key="eOR.StartDateTime.label" bundle="${or_labels}"/></TD>
			<TD class="COLUMNHEADER" width="15%" align="center"><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></TD>
			<TD class="COLUMNHEADER" width="30%" align="center"> <fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
		<%
		}
		else if (group_by.equals("L"))
		{
		%>
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></TD>
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="eOR.StartDateTime.label" bundle="${or_labels}"/></TD>
			<TD class="COLUMNHEADER" width="30%" align="center"><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></TD>
		<%
		}
		%>
		
	</TR>
</table>
<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
	<tr align='right' width='10%'>
	<%
	if ( (!(start <= 1)) && (start < row_count)){
	%>
		<td class='WHITE' width='89%'>&nbsp;</td>
		<td width='11%'>
		<A HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' class='gridLink'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		</td>
	<%	
	}
//	if ( !( (start+row_disp) > row_count ) ){
	if ( !( (start+row_disp) >= row_count ) ){
	%>
		<td class='WHITE' width='94%'>&nbsp;</td>
		<td width='6%'>
		<A HREF='javascript:onClick=checkVal("Next");' text-decoration='none' class='gridLink' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		</td>
	<%
	}
	%>
	</tr>
</table>
<table  width='100%' align='center' class='grid' >
	<%
	for(int i=fm_disp;i<=to_disp;i++)
	{
		classval   =   "gridData";

		htListRecord		= (java.util.HashMap)	MultiRecordSet.getObject(i);
		order_id			= (String)	htListRecord.get("code");
		order_line_num		= (String)	htListRecord.get("order_line_num");
		catalog_code		= (String)	htListRecord.get("catalog_code");
		catalog_desc		= (String)	htListRecord.get("catalog_desc");
		start_datetime		= (String)	htListRecord.get("start_datetime");
		patient_id			= (String)	htListRecord.get("patient_id");
		patient_name		= (String)	htListRecord.get("patient_name");
		location_type_val	= (String)	htListRecord.get("location_type");
		location_code		= (String)	htListRecord.get("location_code");
		location_name	= (String)	htListRecord.get("location_name");
		sex						= (String)	htListRecord.get("sex");
		patient_class		= (String)	htListRecord.get("patient_class");
		encounter_id		= (String)	htListRecord.get("encounter_id");
		
		if(location_name==null)
			location_name ="";
		if(location_code==null)
			location_code ="";
		if(location_type_val==null)
			location_type_val ="";
		if(patient_name==null)
			patient_name ="";
		if(patient_id==null)
			patient_id ="";
		if(start_datetime==null)
			start_datetime ="";
		if(catalog_desc==null)
			catalog_desc ="";
		if(catalog_code==null)
			catalog_code ="";
		if(order_line_num==null)
			order_line_num ="";

		if(group_by.equals("P"))
		{
			code = patient_id;
			
		}
		else if (group_by.equals("O"))
		{
			code = start_datetime;
		}
		else if (group_by.equals("C"))
		{
			code = catalog_code;
		}
		else if (group_by.equals("L"))
		{
			if(location_code==null || location_code.equals(""))
				code = location_name;
			else
				code = location_code;
		}
		if(code==null)
			code = "";
	%>
	
		<%
		if((!code.equals("") && tempCode.equals("")) || !code.equals(tempCode))
		{
			if(groupCount>0)
			{
		%>
				<input type="hidden" name="indGrpCount<%=groupCount%>" id="indGrpCount<%=groupCount%>" value="<%=indGrpCount%>">
		<%
			}
			indGrpCount=0;
			groupCount++;
		%>
	<TR>
		<!--<TD width="5%" class="CAHIGHERLEVELCOLOR">&nbsp;
			
		</TD>-->
		<TD align='center'class="CAHIGHERLEVELCOLOR">
			<input type="checkbox" name="select_group<%=groupCount%>" id="select_group<%=groupCount%>" value="" onClick="selectGroup(<%=groupCount%>)">
		</TD>
		<TD colspan="4" class="CAHIGHERLEVELCOLOR">
			<%
			if(group_by.equals("P"))
			{
			%>
				&nbsp;&nbsp;<%=patient_id%> &nbsp; <%=patient_name%>
			<%
			}
			else if (group_by.equals("O"))
			{
				if(!localeName.equals("en"))
				{
					start_datetime = com.ehis.util.DateUtils.convertDate(start_datetime,"DMYHM","en",localeName);
				}
			%>

				&nbsp;&nbsp;<%=start_datetime%>
			<%
			}
			else if (group_by.equals("C"))
			{
			%>
				&nbsp;&nbsp;<%=catalog_desc%>
			<%
			}
			else if (group_by.equals("L"))
			{
			%>
				&nbsp;&nbsp;<%=location_name%>
			<%
			}
			%>
			
		</TD>
		
	</TR>
	<TR>
		<!--<TD width="5%" align="center" class="<%=classval%>">&nbsp;
			<a href="#" onClick="displayOrder('<%=order_id%>','<%=sex%>','<%=patient_class%>','<%=encounter_id%>','<%=patient_id%>')"> + </a>
		</TD>-->
		<%
		
		}
		else
		{
		%>
		
	<TR>
		<!--<TD width="5%" align="center" class="<%=classval%>">&nbsp;
			<a href="#" onClick="displayOrder('<%=order_id%>','<%=sex%>','<%=patient_class%>','<%=encounter_id%>','<%=patient_id%>')"> + </a>
		</TD>-->
		<%
		}
		tempCode = code;
		indGrpCount++;
			if((i)==to_disp && groupCount>0)
			{
		%>
				<input type="hidden" name="indGrpCount<%=groupCount%>" id="indGrpCount<%=groupCount%>" value="<%=indGrpCount%>">
		<%
			}%>
			<TD  class="<%=classval%>" style="text-align:center;">
			<input type="checkbox" id="checkId<%=groupCount%><%=indGrpCount%>" name="CheckMultiPatientOrdersResulting<%=i%>"  onClick="deselectHeaderChk(<%=groupCount%>)" align="center" value="('<%=order_id%>','<%=order_line_num%>')">
			<input type="hidden" name="order_check_id<%=groupCount%><%=indGrpCount%>" id="order_check_id<%=groupCount%><%=indGrpCount%>" value="<%=order_id%>">
			<input type="hidden" name="order_line_num_check_id<%=groupCount%><%=indGrpCount%>" id="order_line_num_check_id<%=groupCount%><%=indGrpCount%>" value="<%=order_line_num%>">
			<input type="hidden" name="order_id<%=i%>" id="order_id<%=i%>" value="<%=order_id%>">
			<input type="hidden" name="order_line_num<%=i%>" id="order_line_num<%=i%>" value="<%=order_line_num%>">
			<input type="hidden" name="catalog<%=i%>" id="catalog<%=i%>" value="<%=catalog_code%>">
			<input type="hidden" name="catalog_desc<%=i%>" id="catalog_desc<%=i%>" value="<%=catalog_desc%>">
			<input type="hidden" name="order_start_time<%=i%>" id="order_start_time<%=i%>" value="<%=start_datetime%>">
			<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=patient_id%>">
			<input type="hidden" name="patient_name<%=i%>" id="patient_name<%=i%>" value="<%=patient_name%>">
			<input type="hidden" name="locn<%=i%>" id="locn<%=i%>" value="<%=location_name%>">
		</TD>
			<%
		if(group_by.equals("P"))
		{
		%>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<%=start_datetime%> </TD>
			<TD width="30%" class="<%=classval%>" > &nbsp;&nbsp;&nbsp;<a href="#" onClick="displayOrder('<%=order_id%>','<%=sex%>','<%=patient_class%>','<%=encounter_id%>','<%=patient_id%>')"><%=catalog_desc%></a> </TD>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp; <%=location_name%> </TD>
		<%
		}
		else if (group_by.equals("O"))
		{
		%>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<%=patient_id%> &nbsp; &nbsp; <%=patient_name%></TD>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<a href="#" onClick="displayOrder('<%=order_id%>','<%=sex%>','<%=patient_class%>','<%=encounter_id%>','<%=patient_id%>')"> <%=catalog_desc%> </a> </TD>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<%=location_name%> </TD>
		<%
		}
		else if (group_by.equals("C"))
		{
		%>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<%=patient_id%> &nbsp; &nbsp; <%=patient_name%> </TD>
			<TD width="15%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<%=start_datetime%> </TD>
			<TD width="15%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<a href="#" onClick="displayOrder('<%=order_id%>','<%=sex%>','<%=patient_class%>','<%=encounter_id%>','<%=patient_id%>')"> <%=catalog_desc%> </a> </TD>	
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<%=location_name%> </TD>
		<%
		}
		else if (group_by.equals("L"))
		{
		%>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<%=patient_id%> &nbsp; &nbsp; <%=patient_name%> </TD>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<%=start_datetime%> </TD>
			<TD width="30%" class="<%=classval%>"> &nbsp;&nbsp;&nbsp;<a href="#" onClick="displayOrder('<%=order_id%>','<%=sex%>','<%=patient_class%>','<%=encounter_id%>','<%=patient_id%>')"> <%=catalog_desc%> </a> </TD>
		<%
		}
		%>
		
	</TR>
	
	<%
	page_count++;
	}
	%>
</table>
<input type="hidden" name="page_count" id="page_count" value="<%=page_count%>">
<input type="hidden" name ="total_count" value="<%=row_count%>">
<input type="hidden" name ="group_count" value="<%=groupCount%>">
<input type="hidden" name ="result_format" value="<%=result_format%>">
<input type="hidden"  name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden"  name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="result_type" id="result_type" value="<%=result_type%>">
<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
<input type="hidden" name="locn" id="locn" value="<%=locn%>">
<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>">
<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
<input type="hidden" name="order_catalog" id="order_catalog" value="<%=order_catalog%>">
<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
<input type="hidden" name="order_type" id="order_type" value="<%=order_type%>">
<input type="hidden" name="ivalues" id="ivalues" value="">

<input type="hidden" name="from" id="from" value="<%=from%>">
<input type="hidden" name="to" id="to" value=<%=to%>>
<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> >
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
<input type="hidden" name="facility_id" id="facility_id" value=<%=facility_id%> >
<input type='hidden' name='billed_trxn_yn' id='billed_trxn_yn' value='<%=billed_trxn_yn%>'>
<%
if(dispMode.equals(""))
{
	if(row_count!=0)
	{
		out.println("<script>loadCheckBoxes();</script>");
	}
}
if(!ivalues.equals("") && dispMode.equals(""))
{
	ArrayList front_page_records = (ArrayList) bean.getFront_page_records();
	//StringTokenizer st = new StringTokenizer(ivalues,"||");
	String desc = "";
	if(front_page_records.size()==row_count)
	{
		//while(st.hasMoreElements())
		for(int i=0;i<front_page_records.size();i++)
		{
			//int value = Integer.parseInt(st.nextToken());
			desc = (String) front_page_records.get(i);
			if(!desc.equals("N"))
			{
			%>
			<Script>
				loadSelectedCheckBoxes("<%=i%>","<%=desc%>");
			</script>
		<%
			}
		}
	}
}
%>
<Script>
	setCheckBoxValues();		
</script>
</form>
</body>
</html>
<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);
%>

