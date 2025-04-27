<!DOCTYPE html>
<!--
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
28/06/2012    IN032687		 Nijitha S		All the associated elements in the Discrete measure Panel is not Displayed in
											intervention in Task List.
-----------------------------------------------------------------------
-->
<%@page import="java.util.*,eCA.PatTaskListRepository,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
<title><fmt:message key="eCA.PerformedDetails.label" bundle="${ca_labels}"/></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script src='../../eCA/js/CAMessages.js' language='javascript'></SCRIPT>
	<script language="javascript" src="../../eCA/js/PatTaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<script language='javascript'>

	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name='patTaskListDiscreteForm' id='patTaskListDiscreteForm' action='../../servlet/eCA.PatTaskListServlet' method='post' target='messageFrame'>
<%
String encounter_id =  request.getParameter("encounter_id")==null ? "" :request.getParameter("encounter_id");
String status = request.getParameter("status")==null ? "" :request.getParameter("status");
String dateTime =request.getParameter("p_start_date_time")==null ? "" :request.getParameter("p_start_date_time");

String task  =request.getParameter("task")==null ? "" :request.getParameter("task");
String taskType  =request.getParameter("taskType")==null ? "" :request.getParameter("taskType");
String patientId =request.getParameter("patient_id")==null ? "" :request.getParameter("patient_id");

String pract_type =(String) session.getValue("practitioner_type");
String taskSrlNo =request.getParameter("taskSrlNo")==null ? "" :request.getParameter("taskSrlNo");
String sysdate = patTask.getSysdate();
String performedId=request.getParameter("performedId")==null ? "" :request.getParameter("performedId");
String detail  =request.getParameter("detail")==null ? "" :request.getParameter("detail");
String readOnly ="";
ArrayList retArray= null;
String resultType= request.getParameter("resultType")==null ? "" :request.getParameter("resultType");
String resultId  = request.getParameter("Chart_Id")==null ? "" :request.getParameter("Chart_Id");

HashMap hashData = patTask.getQueryForDiscrete(request);

if(!detail.equals(""))
{
	readOnly="ReadOnly";
}
try
	{
		
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		String practitioner_id ="";
		practitioner_id = (String) session.getValue("ca_practitioner_id");
		String name="";
		if(performedId.equals(""))
		{
			name	=(String)session.getValue("practitioner_name");
		}
		else
		{
			name = performedId;
		}

		String remarks= "";
		if(!status.equals(""))
		{

				if(status.equals("P"))
				{
						remarks=request.getParameter("remarks")==null ? "" :request.getParameter("remarks");
					
		
%>

<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="100%" align='center'>
	
	<tr>
		<td width='25%' class='label'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'>	
				<INPUT TYPE="text" name="dateTime" id="dateTime" value='<%=dateTime%>' size='20' maxlength='16' OnBlur='checkForCurrentDate();CheckDateTime(this);' <%=readOnly%>>
				<%if(detail.equals("")){ %>
				<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('dateTime')">		
				<img align=center src='../../eCommon/images/mandatory.gif' ></img>
				<%}%>		
		</td>
		<td width='25%' class='label'>	<fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'>	
				<INPUT TYPE="text" name="practitonerName" id="practitonerName" value='<%=name%>' size='20' maxlength='16' readOnly>
				<INPUT TYPE="hidden" name="practitonerId" id="practitonerId" value='<%=practitioner_id%>'>
				<INPUT TYPE="hidden" name="locale" id="locale" value='<%=locale%>'>
				<%if(detail.equals("")){ %>
				<input type='button' class='button' name='buttonPractitioner' id='buttonPractitioner' value='?' OnClick='getPractitionerDiscreteMeasure()' >
				<img align=center src='../../eCommon/images/mandatory.gif'></img>
				<%} %>
		</td>
	</tr>
	
	<tr>
		<td  class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=3>	

				<TEXTAREA NAME="remarks" ROWS="3" COLS="50" <%=readOnly%> OnKeyDown='return checkTheLength(this)' ><%=remarks%></TEXTAREA>
					<%if(detail.equals("")){ %>
				<img align=center src='../../eCommon/images/mandatory.gif'></img>
					<%} %>
		</td>
	</tr>
		
	<%
			if(resultType.equals("DP") || resultType.equals("DA"))
			{
					
	%>
		<script>
	//	document.getElementById("tableId").border='1'
		</script>
<tr>
<td colspan='6' width='100%'>

<table id='tableID' width='100%' border='0' cellspacing='0' cellpadding='0'>
	<script>
		document.getElementById("tableID").border='1'
		</script>
		<tr>
		<td colspan='6'  align ='left' class='CAGROUPHEADING'><fmt:message key="Common.Result.label" bundle="${common_labels}"/></td>	
		</tr>
<%

		if(!resultType.equals("DA"))
			{

	%>
		
		
		<tr>
		<td colspan='6'  align ='left' class='label'><B><%=resultId%></B></td>	
		</tr>	
		<%
			}
		%>
		
	<%
			String classValue = "";	
			String  maxSize = "";
			String  minSize = "";
			String decSize = "";
			String mandatory="";	
			int index = 0;
			ArrayList arrayCode=null;
			ArrayList arrayDesc= null;
%>
<%	
		for(int 	count=0; count < hashData.size();count++)//IN032687
				{
					
					if(count % 2 == 0 )
					classValue = "QRYEVEN";
					else
					classValue = "QRYODD";

					maxSize = patTask.checkForNull((String)hashData.get("num_digits_max"+count));
					minSize = patTask.checkForNull((String)hashData.get("num_digits_min"+count));
					decSize = patTask.checkForNull((String)hashData.get("num_digits_dec"+count));
					mandatory= patTask.checkForNull((String)hashData.get("mandatory_yn"+count));
					
					if(maxSize.equals(""))
					{
						maxSize ="20";
					}
					if(minSize.equals(""))
					{
						minSize ="0";
					}
					if(decSize.equals(""))
					{
						decSize = "0";
					}
					if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("N")||patTask.checkForNull((String)hashData.get("result_type"+count)).equals("I"))
					{
						out.println("<tr>");
						out.println("<td colspan='2' class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
						
						out.println("<td colspan='2' class='"+classValue+"'><input type='text'  name='comp_"+count+"' id='comp_"+count+"' size='"+maxSize+"' maxlength='"+maxSize+"' value=''    onkeypress=\"return allowValidNumber(this, event, '"+maxSize+"','"+decSize+"')\" onblur=\"setText(this,"+count+")\"> ");
						out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
						if(mandatory.equals("Y"))
						{
								out.println("<img src ='../../eCommon/images/mandatory.gif'></img>");
						}
						out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
						out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
						out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
						out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
						out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
						out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
						out.println("</td>");
						out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
						out.println("</tr>");
					}
					else if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("L"))
						{
							out.println("<tr>");							
								retArray =  patTask.getListItemsForDiscreteMeasure(patTask.checkForNull((String)hashData.get("discr_msr_id"+count)));
								out.println("<td colspan='2' class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
								out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
								out.println("<td colspan='2' >");
								out.println("<Select name='comp_"+count+"' id='comp_"+count+"' OnChange='setValueforText(this,"+count+")'>");
								
								out.println("<option value=''>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
								if(retArray != null)
								{
									arrayCode = (ArrayList)retArray.get(0);
									arrayDesc =  (ArrayList)retArray.get(1);
									while(index < arrayCode.size())
									{
										out.println("<option value='"+patTask.checkForNull((String)arrayCode.get(index))+"'>"+patTask.checkForNull((String)arrayDesc.get(index))+"</option>");
											index++;
									}
								}

								out.println("</Select>");
								if(mandatory.equals("Y"))
								{
									out.println("<img src ='../../eCommon/images/mandatory.gif'></img>");
								}
						out.println("</td>");
						out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
						out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
						out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
						out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
						out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
						out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
						out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
						out.println("</tr>");
						}
						else
						if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("C"))
						{
							out.println("<tr>");
							out.println("<td colspan='2' class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
							out.println("<td colspan='2' class='"+classValue+"'><input type='checkBox'  name='comp_"+count+"' id='comp_"+count+"'  value='' OnClick='evalCheckBox(this)'> ");
							out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
						if(mandatory.equals("Y"))
						{
								out.println("<img src ='../../eCommon/images/mandatory.gif'></img>");
						}
						out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
						out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
						out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
						out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
						out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
						out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
						out.println("</td>");
						out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
						out.println("</tr>");
						}
						else 
							if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("D"))
							{
									out.println("<tr>");
									out.println("<td colspan='2' class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
									out.println("<td colspan='2' class='"+classValue+"'><input type='text' name='comp_"+count+"' id='comp_"+count+"' size='10' maxlength='10' value='' onblur= 'checkDateForDetail(this)'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick='return showCalendarValidateForDate(\"comp_"+count+"\")'> ");
									out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
									if(mandatory.equals("Y"))
									{
										out.println("<img src 	='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
									out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
									out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
									out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
									out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
									out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
								out.println("</td>");
								out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
								out.println("</tr>");
							}
						else if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("E"))
								{
									out.println("<tr>");
									out.println("<td colspan='2'  class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
									out.println("<td colspan='2' class='"+classValue+"'><input type='text' name='comp_"+count+"' id='comp_"+count+"' size='16' maxlength='16' value='' onblur= 'CheckDateTime(this)'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onclick='return showCalendarValidate(\"comp_"+count+"\")'>");
									out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
									if(mandatory.equals("Y"))
									{
										out.println("<img src 	='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
									out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
									out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
									out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
									out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
									out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
								out.println("</td>");
								out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
								out.println("</tr>");
							}
						else if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("T"))
						{
							out.println("<tr>");
									out.println("<td colspan='2'  class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
									out.println("<td colspan='2' class='"+classValue+"'><input type='text' name='comp_"+count+"' id='comp_"+count+"' size='5' maxlength='5' value='' onblur= 'chkValidityOfTime(this)'>");
									out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
									if(mandatory.equals("Y"))
									{
										out.println("<img src 	='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
									out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
									out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
									out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
									out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
									out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
								out.println("</td>");
								out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
								out.println("</tr>");
						}
						else if(patTask.checkForNull((String)hashData.get("result_type"+count)).equals("F"))
						{
							out.println("<tr>");
									out.println("<td colspan='2'  class='"+classValue+"'>&nbsp;&nbsp;"+patTask.checkForNull((String)hashData.get("short_desc"+count))+"</td>");
									out.println("<td colspan='2' class='"+classValue+"'><input type='text' name='comp_"+count+"' id='comp_"+count+"' size='20' maxlength='20' onblur=\"setText(this,"+count+")\" value='' >");
									out.println("<input type='hidden' name='selectListText"+count+"' id='selectListText"+count+"' value=''>");
									if(mandatory.equals("Y"))
									{
										out.println("<img src 	='../../eCommon/images/mandatory.gif'></img>");
									}
									out.println("<input type='hidden' name='discr_msr_id"+count+"' id='discr_msr_id"+count+"' value='"+patTask.checkForNull((String)hashData.get("discr_msr_id"+count))+"'>");
									out.println("<input type='hidden' name='maxSize"+count+"' id='maxSize"+count+"' value='"+maxSize+"'>");
									out.println("<input type='hidden' name='minSize"+count+"' id='minSize"+count+"' value='"+minSize+"'>");
									out.println("<input type='hidden' name='resultType"+count+"' id='resultType"+count+"' value='"+patTask.checkForNull((String)hashData.get("result_type"+count))+"'>");
									out.println("<input type='hidden' name='unit_of_measure"+count+"' id='unit_of_measure"+count+"' value='"+patTask.checkForNull((String)hashData.get("unit_of_measure"+count))+"'>");
									out.println("<input type='hidden' name='mandatory"+count+"' id='mandatory"+count+"' value='"+patTask.checkForNull((String)hashData.get("mandatory_yn"+count))+"'>");
								out.println("</td>");
								out.println("<td colspan='2' class='"+classValue+"'>"+(patTask.checkForNull((String)hashData.get("unit_of_measure"+count)).equals("") ? "&nbsp;" :patTask.checkForNull((String)hashData.get("unit_of_measure"+count)))+"</td>");
								out.println("</tr>");
						}

				}
				if (arrayCode != null)
					arrayCode.clear();
				if (arrayDesc != null)
					arrayDesc.clear();

				out.println("<input type='hidden' name='count' id='count' value='"+ hashData.size()+"'>");
				out.println("<INPUT TYPE='hidden' name='resultType' id='resultType' value='"+resultType+"'>");
				out.println("</table>");			
				out.println("</td>");
				out.println("</tr>");

		}
		
	%>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>	
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td align='right'>
	<%if(detail.equals("")){ %>
		<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' OnClick='recordingForDiscrete()'>
		<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' OnClick='cancel()'>
		<%}else
		{
		%>
		<input type='button' name='buttonClose' id='buttonClose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' OnClick='cancel()'>
		<%
		}
		%>
	</td>
	</tr>
</table>

<%			}
				else
				{
					

					remarks=request.getParameter("remarks")==null ? "" :request.getParameter("remarks");
		
%>
<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="100%" >
	<script>
		document.body.scroll="no";
		document.body.onscroll= "";
	</script>

	<%if(!detail.equals("")){ %>
	<tr>

	<td colspan='4'align='right' class='label'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
	<td align='left'><INPUT TYPE="text" name="dateTime" id="dateTime" value='<%=dateTime%>' size='20' maxlength='16'  readOnly></td>
	</tr>
<%} 
%>
		<tr>
		<td colspan='4'align='right' class='label'><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/></td>
		<td align='left'>	
				<INPUT TYPE="text" name="practitonerName" id="practitonerName" value='<%=name%>' size='30'   readOnly>
				<INPUT TYPE="hidden" name="practitonerId" id="practitonerId" value='<%=practitioner_id%>'>
			<%if(detail.equals("")){ %>
				<!-- <input type='button' class='button' name='buttonPractitioner' id='buttonPractitioner' value='?' OnClick='getPractitioner()'><img align=center src='../../eCommon/images/mandatory.gif'></img> -->
			<%}%>
		</td>
	</tr>
	<tr>
	<td colspan='6'>&nbsp;</td>
	</tr>
	<tr>
		<td colspan='4'align='right' class='label'><fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;&nbsp; 
		</td>
			<td align='left'>	
				<TEXTAREA NAME="remarks" ROWS="3" COLS="50" <%=readOnly%> OnKeyDown='return checkTheLength(this)' STYLE="overflow:hidden"><%=remarks%></TEXTAREA>
				<%if(detail.equals("")){ %>
			<img align=center src='../../eCommon/images/mandatory.gif'></img>
			<%}%>
		</td>
	</tr>
	<tr>
	<td colspan='6'>&nbsp;</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>	
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td align='right'>
		<%if(detail.equals("")){ %>
		<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' OnClick='recordingForNotPerform()'>
		<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' OnClick='cancel()'>
		<%}else
		{
		%>
		<input type='button' name='buttonClose' id='buttonClose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' OnClick='cancel()'>
		<%
		}
		%>



	</td>
	</tr>
		
</table>
<%			}
		}

%>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception from PatTaskListDiscreteMeasureAtomic.jsp :"+ee.toString());//common-icn-0181
		 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if (retArray != null)
			retArray.clear();
		if (hashData != null)
			hashData.clear();
	
	}
%>
<INPUT TYPE="hidden" name="status" id="status" value='<%=status%>'>
<INPUT TYPE="hidden" name="patientId" id="patientId" value='<%=patientId%>'>
<INPUT TYPE="hidden" name="taskCode" id="taskCode" value='<%=taskType%>'>
<INPUT TYPE="hidden" name="taskType" id="taskType" value='<%=task%>'>
<INPUT TYPE="hidden" name="pract_type" id="pract_type" value='<%=pract_type%>'>
<INPUT TYPE="hidden" name="sysdate" id="sysdate" value='<%=sysdate%>'>
<INPUT TYPE="hidden" name="taskSrlNo" id="taskSrlNo" value='<%=taskSrlNo%>'>
<INPUT TYPE="hidden" name="encounter_id" id="encounter_id" value='<%=encounter_id%>'>
<INPUT TYPE="hidden" name="result_id" id="result_id" value='<%=resultId%>'>
</form>
</body>
</html>

