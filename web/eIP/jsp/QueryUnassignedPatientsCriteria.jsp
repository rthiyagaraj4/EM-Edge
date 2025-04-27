<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String facilityID	=(String)session.getAttribute("facility_id");
	String fromquery	= checkForNull(request.getParameter("fromQuery"));
	String call_function= checkForNull(request.getParameter("call_function"));
	String locale		= (String)session.getAttribute("LOCALE");
	String Curr_date	= "";
	if(call_function.equals("")) call_function=request.getParameter("fromQuery");
	Statement stmt		=	null;
	ResultSet rs		=	null;
	int maxLengthId		=	0;
	Connection con		=	null;
	StringBuffer sqlQuery = new StringBuffer();

	String function_id=request.getParameter("function_id");
		if(function_id == null) function_id = "";

	sqlQuery.append("select PATIENT_ID_LENGTH, to_char(sysdate,'dd/mm/rrrr') Curr_date from MP_PARAM  ");
	try
	{
		con	=	ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		rs		= stmt.executeQuery(sqlQuery.toString());
		if(rs.next())
		{
			maxLengthId = rs.getInt("PATIENT_ID_LENGTH");
			Curr_date   = rs.getString("Curr_date");
		}
	} catch (Exception e) 
	{
		out.println(e);	
	}
	finally
	{
		if(stmt != null)	stmt.close();
		if(rs != null)		rs.close();
		ConnectionManager.returnConnection(con,request);
	}
		
%>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src="../../eCommon/js/CommonLookup.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>




</head>
<script>

async function beforeGetCancelledBy()
{
	if(document.forms[0].user.value != document.forms[0].user_name.value)
	{
		if(document.forms[0].user_name.value != "")
			await showLookUpCancel();
		else
		{
			document.forms[0].user_hid.value="";
			document.forms[0].user.value = "";
		}
	}
}

async function showLookUp(val)
{
                if(val == 'P')
                {
					var patientid=await PatientSearch('','','','','','','Y','','','OTHER');
					if(patientid != null)
                    document.getElementById('patient_no').value = patientid;
                }
}

/*function beforeGetSpecialty(getFacilitID)
{
	if(document.forms[0].spec_desc_hid.value != document.forms[0].specialty_desc.value)
	{
		if(document.forms[0].specialty_desc.value != "")
			getSpecialty(getFacilitID);
		else
		document.forms[0].Splcode.value="";
	}
}*/


/*function submitPage_unAsgPat()
{               
	document.forms[0].search.disabled=true;
	var params = "";
	if(document.getElementById('nursing_unit').value != '')
	params+="&nursing_unit="+escape(document.getElementById('nursing_unit').value);
	if(document.getElementById('Splcode').value != '')
		params+="&specialty="+escape(document.getElementById('Splcode').value);
	if(document.getElementById('practid').value != '')
		params+="&practitioner="+escape(document.getElementById('practid').value);
	if(document.getElementById('from_date').value != '')
		params+="&from_date="+document.getElementById('from_date').value;
	if(document.getElementById('to_date').value != '')
		params+="&to_date="+document.getElementById('to_date').value;
	if(document.getElementById('gender').value != '')
		params+="&gender="+document.getElementById('gender').value;
	if(document.getElementById("display"))
	{
		if(document.getElementById("display").value != '')
		params+="&display="+document.getElementById("display").value;
	}
	if(document.getElementById('patient_no').value != '')
		params+="&patient_no="+document.getElementById('patient_no').value;
	if(document.getElementById('encounter_id').value != '')
		params+="&encounter_id="+document.getElementById('encounter_id').value;

	if(document.getElementById('cancelled_from_date') != null)
	if(document.getElementById('cancelled_from_date').value != '')
		params+="&cancelled_from_date="+document.getElementById('cancelled_from_date').value;

	if(document.getElementById('cancelled_to_date') != null)
	if(document.getElementById('cancelled_to_date').value != '')
		params+="&cancelled_to_date="+document.getElementById('cancelled_to_date').value;

	if(document.getElementById('user') != null)
	if(document.getElementById('user').value != '')
		params+="&user="+document.getElementById('user').value;
	
	if('<%=fromquery%>' == 'RA')
		parent.result.location.href= '../jsp/QueryReAdmissionResult.jsp?'+params
	else if('<%=fromquery%>' == 'CA')
	{
		parent.result.location.href= '../jsp/QueryCancelledAdmissionsResult.jsp?'+params
	}
	else if('<%=fromquery%>' == 'CT')
	{
		if(document.getElementById('cancelled_from_date').value != '')
			params+="&cancelled_from_date="+document.getElementById('cancelled_from_date').value;
		if(document.getElementById('cancelled_to_date').value != '')
			params+="&cancelled_to_date="+document.getElementById('cancelled_to_date').value;
		params+="&call_function="+document.getElementById('call_function').value;
		parent.result.location.href= '../jsp/QueryCancelTransferResult.jsp?'+params
	}
	else if('<%=fromquery%>' == 'OP')
	{
		if(document.getElementById('exp_dis_date').value != '')
			params+="&exp_dis_date="+document.getElementById('exp_dis_date').value;
		parent.result.location.href= '../jsp/QueryOverstayPatientsResult.jsp?'+params
	}
	else if('<%=fromquery%>' == 'NR')
	{
		if(document.getElementById('leave_from_date').value != '')
			params+="&leave_from_date="+document.getElementById('leave_from_date').value;
		if(document.getElementById('leave_to_date').value != '')
			params+="&leave_to_date="+document.getElementById('leave_to_date').value;
		parent.result.location.href= '../jsp/QueryPatientsNotReturnedFmLeaveResult.jsp?'+params
	}
	else
	{
		parent.result.location.href= '../jsp/QueryUnassignedPatientsResult.jsp?'+params
	}
}*/

function submitPage_unAsgPat()
	{               
		//added on 20-10-2003 by dhanasekaran
		document.forms[0].search.disabled=true;
		
		var params = "";
		if(document.getElementById('nursing_unit').value != '')
	    params+="&nursing_unit="+escape(document.getElementById('nursing_unit').value);
		if(document.getElementById('Splcode').value != '')
			params+="&specialty="+escape(document.getElementById('Splcode').value);
		if(document.getElementById('practid').value != '')
			params+="&practitioner="+escape(document.getElementById('practid').value);
		if(document.getElementById('from_date').value != '')
			//params+="&from_date="+document.getElementById('from_date').value;
			params+="&from_date="+convertDate(document.getElementById('from_date').value,'DMY',localeName,'en');
		if(document.getElementById('to_date').value != '')
			//params+="&to_date="+document.getElementById('to_date').value;
			params+="&to_date="+convertDate(document.getElementById('to_date').value,'DMY',localeName,'en');
		if(document.getElementById('gender').value != '')
			params+="&gender="+document.getElementById('gender').value;
		if(document.getElementById("display"))
		{
			if(document.getElementById("display").value != '')
			params+="&display="+document.getElementById("display").value;
		}
		if(document.getElementById('patient_no').value != '')
			params+="&patient_no="+document.getElementById('patient_no').value;
		if(document.getElementById('encounter_id').value != '')
			params+="&encounter_id="+document.getElementById('encounter_id').value;

		/* Added by Nanda on 10/10/2002 to include the Cancelled From Date and To Date and CancelledBy Id irrespective of from whereever it is invoked from */

		if(document.getElementById('cancelled_from_date') != null)
		if(document.getElementById('cancelled_from_date').value != '')
			//params+="&cancelled_from_date="+document.getElementById('cancelled_from_date').value;
			params+="&cancelled_from_date="+convertDate(document.getElementById('cancelled_from_date').value,'DMY',localeName,'en');

		if(document.getElementById('cancelled_to_date') != null)
		if(document.getElementById('cancelled_to_date').value != '')
			//params+="&cancelled_to_date="+document.getElementById('cancelled_to_date').value;
			params+="&cancelled_to_date="+convertDate(document.getElementById('cancelled_to_date').value,'DMY',localeName,'en');

		if(document.getElementById('user') != null)
		if(document.getElementById('user').value != '')
			params+="&user="+document.getElementById('user').value;

			if(document.getElementById('transferred_from_date') != null)
		if(document.getElementById('transferred_from_date').value != '')
			//params+="&cancelled_from_date="+document.getElementById('cancelled_from_date').value;
			params+="&transferred_from_date="+convertDate(document.getElementById('transferred_from_date').value,'DMY',localeName,'en');

		if(document.getElementById('transferred_to_date') != null)
		if(document.getElementById('transferred_to_date').value != '')
			//params+="&cancelled_to_date="+document.getElementById('cancelled_to_date').value;
			params+="&transferred_to_date="+convertDate(document.getElementById('transferred_to_date').value,'DMY',localeName,'en');
		
		if('<%=fromquery%>' == 'RA')
		{
			parent.result.location.href= "../../eIP/jsp/QueryReAdmissionResult.jsp?function_id=<%=function_id%>"+params
				
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}
		else if('<%=fromquery%>' == 'CA')
		{
			var names = new Array (	getLabel("Common.CancelledDateFrom.label","Common"),
									getLabel("eIP.CancelledDateTo.label","IP"));
			var fields=new Array();

			fields[0]= document.forms[0].cancelled_from_date;
			fields[1]= document.forms[0].cancelled_to_date;

			if(!parent.criteria.checkFields( fields, names, parent.messageFrame))
			{
				document.forms[0].search.disabled = false;
			}
			else
			{
			parent.result.location.href= "../../eIP/jsp/QueryCancelledAdmissionsResult.jsp?function_id=<%=function_id%>"+params
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
		}
		else if('<%=fromquery%>' == 'CT')
		{
			if(document.getElementById('cancelled_from_date').value != '')
				//params+="&cancelled_from_date="+document.getElementById('cancelled_from_date').value;
				params+="&cancelled_from_date="+convertDate(document.getElementById('cancelled_from_date').value,'DMY',localeName,'en');
			if(document.getElementById('cancelled_to_date').value != '')
				//params+="&cancelled_to_date="+document.getElementById('cancelled_to_date').value;
				params+="&cancelled_to_date="+convertDate(document.getElementById('cancelled_to_date').value,'DMY',localeName,'en');
			params+="&call_function="+document.getElementById('call_function').value;
			parent.result.location.href= "../../eIP/jsp/QueryCancelTransferResult.jsp?function_id=<%=function_id%>"+params
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}
		else if('<%=fromquery%>' == 'OP')
		{
			var name = new Array (	getLabel("eIP.AdmDateFrom.label","IP"), getLabel("eIP.AdmDateTo.label","IP") );
			var field =new Array();
			field[0]= document.forms[0].from_date;
			field[1]= document.forms[0].to_date;

			if(!parent.criteria.checkFields( field, name, parent.messageFrame))
			{
				document.forms[0].search.disabled=false;
				
			}
			else
			{
				if(document.getElementById('exp_dis_date').value != '')
					//params+="&exp_dis_date="+document.getElementById('exp_dis_date').value;
					params+="&exp_dis_date="+convertDate(document.getElementById('exp_dis_date').value,'DMY',localeName,'en');
				parent.result.location.href= "../../eIP/jsp/QueryOverstayPatientsResult.jsp?function_id=<%=function_id%>"+params
					
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
		}
		else if('<%=fromquery%>' == 'NR')
		{
			if(document.getElementById('leave_from_date').value != '')
				//params+="&leave_from_date="+document.getElementById('leave_from_date').value;
				params+="&leave_from_date="+convertDate(document.getElementById('leave_from_date').value,'DMY',localeName,'en');
			if(document.getElementById('leave_to_date').value != '')
				//params+="&leave_to_date="+document.getElementById('leave_to_date').value;
				params+="&leave_to_date="+convertDate(document.getElementById('leave_to_date').value,'DMY',localeName,'en');
			parent.result.location.href= "../../eIP/jsp/QueryPatientsNotReturnedFmLeaveResult.jsp?function_id=<%=function_id%>"+params
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}
		else if('<%=fromquery%>' == 'CE')
		{
			var names = new Array (	getLabel("eIP.Transferred.label","IP")+" "+getLabel("Common.from.label","Common")+" "+getLabel("Common.date.label","Common"),
									getLabel("eIP.Transferred.label","IP")+" "+getLabel("Common.to.label","Common")+" "+getLabel("Common.date.label","Common"));
			var fields=new Array();
			
			fields[0]= document.forms[0].transferred_from_date;
			fields[1]= document.forms[0].transferred_to_date;
			params+="&fromquery="+"<%=fromquery%>";
			if(!parent.criteria.checkFields( fields, names, parent.messageFrame))
			{
				document.forms[0].search.disabled = false;
			}
			else
			{
			parent.result.location.href= "../../eIP/jsp/QueryUnassignedPatientsResult.jsp?function_id=<%=function_id%>"+params
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
		}
		else
		{
			parent.result.location.href= "../../eIP/jsp/QueryUnassignedPatientsResult.jsp?function_id=<%=function_id%>"+params
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}
	}


</script>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>

    <form name='Criteria_Form' id='Criteria_Form' >
        <table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		    <%
                String legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
                if(fromquery.equals("CT")) legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels");
            %>
			<tr>
                <td  class='label'  nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                <td><input type=text name='nursing_unit_desc' id='nursing_unit_desc'  size=15 onblur='beforeGetNursingUnit("<%=facilityID%>")'><input type=hidden class=label name='nursing_unit' id='nursing_unit' size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick='getNursingUnit("<%=facilityID%>")'></td>
				<input type='hidden' name='nurs_desc_hid' id='nurs_desc_hid' >


                <td class='label' nowrap><%=legend%> <fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>&nbsp;</td>
				<!--  id="date_from" & id="date_to" duplicate id removed from below filed-->
                <td nowrap><input type='text' maxlength='10' size='10' name='from_date' id='from_date'   onBlur='DateCompare_unasgPat(this,to_date);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="from_date.focus();return showCalendar('from_date');"/><%if(call_function.equals("OP")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>&nbsp;-<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' maxlength='10' size='10' name='to_date' id='to_date' onBlur='DateCompare_unasgPat(from_date,this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="to_date.focus();return showCalendar('to_date');"/><%if(call_function.equals("OP")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>&nbsp;</td>
            </tr>

            <tr>
			    <td  class='label'  nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
                <td><input type=text name=specialty_desc id=specialty_desc size=15 onblur='beforeGetSpecialty(this,"<%=facilityID%>")' ><input type=hidden class=label name=Splcode id=Splcode size=15 ><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick='getSpecialty(specialty_desc,"<%=facilityID%>")'></td>
				<input type=hidden name="spec_desc_hid" id="spec_desc_hid" >

				<td  class='label' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                <td><input type=text name=pract_desc id=pract_desc size=15 onblur='beforeGetPractitioner(practitioner_lookup,pract_desc,"<%=facilityID%>")'><input type=hidden class=label name=practid id=practid size=15 ><input type=button class=button name='practitioner_lookup' id='practitioner_lookup' value='?' onClick='getPractitionerLocal(practitioner_lookup,pract_desc,"<%=facilityID%>")'></td>
				<input type=hidden name="pract_desc_hid" id="pract_desc_hid" >
			</tr>
<!--modify-->
			<tr>
				<td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td><input type='text' maxlength='<%=maxLengthId%>' size='20' name='patient_no' id='patient_no' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);chkSplChar(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
				<td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td>
					<select name="gender" id="gender">
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
				</td><!--end modify-->
			</tr>
				<%if(fromquery.equals("NR")){%>
			<tr>                
                <td class='label'  nowrap><fmt:message key="eIP.LeaveDatefrom.label" bundle="${ip_labels}"/> &nbsp;</td>
                <td nowrap><input type='text' id="leave_date_from" maxlength='10' size='10' name='leave_from_date' id='leave_from_date'   onBlur='DateCompare_unasgPat(this,leave_to_date);'><img src = "../../eCommon/images/CommonCalendar.gif" onClick="leave_from_date.focus();return showCalendar('leave_date_from');"/>&nbsp;&nbsp;-<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="leave_date_to"  maxlength='10' size='10' name='leave_to_date' id='leave_to_date' onBlur='DateCompare_unasgPat(leave_from_date,this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="leave_to_date.focus();return showCalendar('leave_date_to');"/></td>
          		<td colspan='2'>&nbsp;</td>
			</tr>
				 <%}%>

            <tr> 
                <td class='label' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                <td ><input type='text'  maxlength='12' size='12' name='encounter_id' id='encounter_id' onkeyPress="return allowValidNumber(this,event,12,0);" onBlur="CheckNum(this)"></td>
				<%	
				if(!call_function.equals("QUERY_UNASSIGNED_PATS") && !call_function.equals("CA") && !call_function.equals("CT")&& !call_function.equals("RA") && !call_function.equals("OP") && !call_function.equals("CE"))
				{	%>
				<td class='label' ><fmt:message key="Common.display.label" bundle="${common_labels}"/>&nbsp;</td>
				<td><SELECT name="display" id="display">
				<option value="0"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
				<option value="1"><fmt:message key="Common.Leave.label" bundle="${common_labels}"/></option>
				<option value="2"><fmt:message key="Common.Abscond.label" bundle="${common_labels}"/></option>
				</SELECT></td>
		<%	}else{	%>
                <td class='label' align='right'>&nbsp;&nbsp;</td>
                <td class='label' align='right'>&nbsp;&nbsp;</td>
	<%	}	
	
			if(!call_function.equals("NR"))
			{	%>
				<!--<td class='label' align='right'>vxzvzv&nbsp;&nbsp;</td>
                <td class='label' align='right'>fsafassf&nbsp;&nbsp;</td>-->
		<%	}	%>
             <!--   <td class='label' align='right'nowrap>Encounter ID&nbsp;&nbsp;</td>
                <td ><input type='text'  maxlength='12' size='12' name='encounter_id' id='encounter_id' onkeyPress="return allowValidNumber(this,event,12,0);" onBlur="CheckNum(this)"></td>-->
            </tr>       
               <%if(fromquery.equals("CA") || fromquery.equals("CT")){%>
             <tr>

                <td class='label'  nowrap><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                <td><input type='text' maxlength='15' size='15' name='user_name' id='user_name'  value='' onblur='beforeGetCancelledBy()' ><input type='hidden'   name='user' id='user' value=''><input type="button" class=BUTTON name="cancel_search" id="cancel_search" value="?" onClick="javascript:showLookUpCancel()"><input type='hidden'   name='user_hid' id='user_hid' value=''>
                </td>

				<td class='label'  nowrap><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                <td nowrap><input type='text' maxlength='10' size='10' name='cancelled_from_date' id='cancelled_from_date'   onBlur='DateCompare_unasgPat(this,cancelled_to_date);date_compare_sysdate(this);' ><img src='../../eCommon/images/CommonCalendar.gif' onClick="cancelled_from_date.focus();return showCalendar('cancelled_from_date');"/><%if(call_function.equals("CA")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img>&nbsp;<%}else{%>&nbsp;<%}%>-<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' maxlength='10' size='10' name='cancelled_to_date' id='cancelled_to_date' onBlur='DateCompare_unasgPat(cancelled_from_date,this);date_compare_sysdate(this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="cancelled_to_date.focus();return showCalendar('cancelled_to_date');"/><%if(call_function.equals("CA")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img>&nbsp;<%}%></td>

				<!--<td colspan='2'>&nbsp;</td>-->
            </tr>       
            <%} else if (fromquery.equals("CE")){%>
				 <tr>

                <td class='label'  nowrap><fmt:message key="Common.TransferredBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                <td><input type='text' maxlength='15' size='15' name='user_name' id='user_name'  value='' onblur='beforeGetTransferedBy()' ><input type='hidden'   name='user' id='user' value=''><input type="button" class=BUTTON name="cancel_search" id="cancel_search" value="?" onClick="javascript:showLookUpTransfer()"><input type='hidden'   name='user_hid' id='user_hid' value=''>
                </td>

				<td class='label'  nowrap><fmt:message key="eIP.Transferred.label" bundle="${ip_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                <td nowrap><input type='text'  maxlength='10' size='10' name='transferred_from_date' id='transferred_from_date'   onBlur='DateCompare_unasgPat(this,transferred_to_date);date_compare_sysdate(this);' ><img src='../../eCommon/images/CommonCalendar.gif' onClick="transferred_from_date.focus();return showCalendar('transferred_from_date');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img>&nbsp;-<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text'   maxlength='10' size='10' name='transferred_to_date' id='transferred_to_date' onBlur='DateCompare_unasgPat(transferred_from_date,this);date_compare_sysdate(this);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="transferred_to_date.focus();return showCalendar('transferred_to_date');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img>&nbsp;</td>

				<!--<td colspan='2'>&nbsp;</td>-->
            </tr>  
			<%}%>
            <%if(fromquery.equals("OP")){%>
                <tr>
                    <td class='label' ><fmt:message key="eIP.ExpectesDischargeDate.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
                    <td colspan=5><input type='text' maxlength='10' size='10'  name='exp_dis_date' id='exp_dis_date' onBlur='validDateObj(this,"DMY",localeName);'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('exp_dis_date');"/></td>
                </tr>
            <%}%>
        </table>
      <table align='right'>
        <tr>
            <td align='right' class='white'>
            <input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage_unAsgPat();'>
			<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick="clearAll_unAsgPat()"></td>
        </tr>               
	  </table>
	 <input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	 <input type='hidden' name='facilityID' id='facilityID' value="<%=facilityID%>" >
	 <input type='hidden' name='Curr_date' id='Curr_date' value="<%=Curr_date%>" >
	 <input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	 <input type='hidden' name='booking_type' id='booking_type' value="" >
	 <input type='hidden' name='daycare_unit' id='daycare_unit' value="" >
   </form>
  </body>
</html>


<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

