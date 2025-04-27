<!DOCTYPE html>
<%@page import="java.util.*,eCA.PatTaskListRepository,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
	<jsp:useBean id="patTask" class="eCA.PatTaskListRepository" scope='page'/>
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
	<script language="javascript" src="../../eCA/js/PatTaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<BODY onKeyDown = 'lockKey();'  OnMouseDown="CodeArrest()">
		<FORM name='patTaskListAdhocForm' id='patTaskListAdhocForm'>
		<table border="0" cellpadding="3" cellspacing="0"  width="100%" >
<%
ArrayList retArray=null;
ArrayList arrayDesc = null;
ArrayList arrayCode=null;
Properties property = null;
String pract_type =(String) session.getValue("practitioner_type");
try
{
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	property = (java.util.Properties) session.getValue( "jdbc" );
	String sysdate = patTask.getSysdateTimeForIntervention();

	sysdate		=	com.ehis.util.DateUtils.convertDate(sysdate,"DMYHM","en",locale);
	String practitioner_id ="";
	String patientId = request.getParameter("patientId")==null ? "" : request.getParameter("patientId");
		String priority = request.getParameter("priority")==null ? "" : request.getParameter("priority");
	String encounterId = request.getParameter("encounterId")==null ? "" : request.getParameter("encounterId");
	practitioner_id = (String) session.getValue("ca_practitioner_id");
	String name="";
	name	=(String)session.getValue("practitioner_name");
%>
			<TR>
			<TD class="label" width='25%'><fmt:message key="eCA.TaskType.label" bundle="${ca_labels}"/></TD>
			<TD class="fields" width='25%' >
				<SELECT name="taskType" id="taskType">
					<OPTION  value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
	<%
				if(property != null)
				{
					retArray = patTask.getQueryForTask(property);

					if(retArray != null)
					{
						arrayDesc =(ArrayList) retArray.get(0);
						arrayCode =(ArrayList) retArray.get(1);

						for(int index =0 ;index < arrayDesc.size();index++)
						{
							out.println("<option value='"+(String)arrayCode.get(index)+"'>"+(String)arrayDesc.get(index)+"</option>");
						}
					}
				}
	%>
				</SELECT>
				<img align=center src='../../eCommon/images/mandatory.gif'></img>
			</TD><td class="label" width='25%'></td><td class="label" width='25%'></td></tr>
		   <TR> 
			<TD class="label" width='25%'><fmt:message key="Common.Task.label" bundle="${common_labels}"/></TD>
			<TD class="fields" width='25%'>	<INPUT type="text" name="taskDesc" id="taskDesc" size='20'  readOnly><INPUT type="hidden" name="taskCode" id="taskCode"><INPUT class="button" type="button" name="buttonTask" id="buttonTask" value="?"  onclick="getTaskforCriteria(this)"><img align=center src='../../eCommon/images/mandatory.gif'></img>
			</TD><td class="label" width='25%'></td><td class="label" width='25%'></td>
		</TR>
		
		<TR>
			<TD class="label" width='25%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></TD>
			<TD  class="fields" width='25%'>
				<INPUT type="text" name="dateTime" id="dateTime" maxlength='16' size ='20' value='<%=sysdate%>' OnBlur='CheckDateTime(this);'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('dateTime')"><img align=center src='../../eCommon/images/mandatory.gif'></img>
			</TD><td class="label" width='25%'></td><td class="label" width='25%'></td>
		</TR>
		
		<TR>
			<TD class="label" width='25%'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/><fmt:message key="Common.by.label" bundle="${common_labels}"/></TD>
			<TD  class="fields" width='25%'><INPUT type="hidden" name="practitonerId" id="practitonerId" size ='20' value='<%=practitioner_id%>'><INPUT type="text" name="practitonerName" id="practitonerName" size ='20' value='<%=name%>'><input type='button' class='button' name='buttonPractitioner' id='buttonPractitioner' value='?' OnClick='getPractitionerCriteria()' ><img align=center src='../../eCommon/images/mandatory.gif'></img>
			</TD><td class="label" width='25%'></td><td class="label" width='25%'></td>
			
		</TR>
		
		<TR>
			<TD class="label" width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
			<TD class="fields" width='25%' nowrap>
				<TEXTAREA NAME="remarks" ROWS="7" COLS="50" STYLE="overflow:hidden" OnKeyDown='return checkTheLength(this)'></TEXTAREA>
				<img align=center src='../../eCommon/images/mandatory.gif'></img>
			</TD><td class="label" width='25%'></td><td class="label" width='25%'></td>
		</TR>
		<TR><td class="label" colspan='2'></td>
			<TD width='25%'nowrap>
				<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' OnClick='recordingAdhoc()'>
				<input type='button' name='buttonRecord' id='buttonRecord' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' OnClick='cancel()'>
			</TD><td class="label" width='25%'></td>
		</TR>
		

	</TABLE>
	<INPUT TYPE="hidden" name="pract_type" id="pract_type" value='<%=pract_type%>'>
	<INPUT TYPE="hidden" name="patientId" id="patientId" value='<%=patientId%>'>
	<INPUT TYPE="hidden" name="encounterId" id="encounterId" value='<%=encounterId%>'>
	<INPUT TYPE="hidden" name="priority" id="priority" value='<%=priority%>'>
		<INPUT TYPE="hidden" name="locale" id="locale" value='<%=locale%>'>
		</FORM>
<%
}
catch(Exception ee)
{
//	out.println("Exception from PatTaskListAdhocIntervention.jsp File "+ee.toString());//COMMON-ICN-0181
        ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(retArray != null)
		retArray.clear();

	if(arrayDesc != null)
		arrayDesc.clear();

	if(arrayCode != null)
		arrayCode.clear();

}
%>
	</BODY>
</HTML>

