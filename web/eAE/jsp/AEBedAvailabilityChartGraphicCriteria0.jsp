<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
<% 
	Connection connection			=	null;
	PreparedStatement pStatement	=	null;
	ResultSet		resultSet		=	null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	try
	{
	    String locale				= (String)session.getAttribute("LOCALE");
		String facility_id			= checkForNull((String) session.getAttribute("facility_id"));
		String call_function		= checkForNull(request.getParameter("call_function"));
		String clinic_code			= checkForNull(request.getParameter("clinic_code"));
		String treatment_area		= checkForNull(request.getParameter("treatment_area"));
		String age					= checkForNull(request.getParameter("age"));
		String gender				= checkForNull(request.getParameter("gender"));
		String where_condition		= checkForNull(request.getParameter("where_condition"));
		connection					= (Connection)ConnectionManager.getConnection(request);
		String sqlString			=	"";
		String code					=	"";
		String desc					=	"";
		String selectValue			=	"";
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
	function getTreatmentArea()
	{
		var clinic		= document.AEBedAvailChartForm.clinic_code.value;
		var HTMLValue	= "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEReserveBedPopulateGraphicValue.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='BedAvailChart'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='TreatmentArea'><input type='Hidden' name='field1' id='field1' value='"+clinic+"'><input type='Hidden' name='field2' id='field2' value='"+'<%=treatment_area%>'+"'></form></body></html>"
		parent.frames[4].document.body.insertAdjacentHTML('afterbegin', HTMLValue);
		parent.frames[4].document.dummy_form.submit();
	}
	
	function loadTreatmentArea()
	{
		//if ('<%=treatment_area%>' != "")
		//{
			var HTMLValue	= "<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEReserveBedPopulateGraphicValue.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='BedAvailChart'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='TreatmentArea'><input type='Hidden' name='field1' id='field1' value='"+'<%=clinic_code%>'+"'><input type='Hidden' name='field2' id='field2' value='"+'<%=treatment_area%>'+"'>input type='Hidden' name='field3' value='"+'<%=call_function%>'+"'></form></body></html>"
			var HTMLVal = escape(HTMLValue);
			setTimeout("submitFunction('"+HTMLVal+"');", 250);

//			parent.frames[4].document.body.insertAdjacentHTML('afterbegin', HTMLValue);
//			parent.frames[4].document.dummy_form.submit();
		//}
	}

	function submitFunction(HTMLValue)
	{
		//var HTMLVal = unescape(HTMLValue);
		//parent.frames[4].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		//parent.frames[4].document.dummy_form.submit();
	}

	function clearContent()
	{
		parent.frames[1].document.AEBedAvailChartForm.reset();
		parent.frames[2].document.location.href = '../../eCommon/html/blank.html' ;
	}

	function getBedDetails()
	{
		
		//	parent.frames[2].document.location.href = '../../eAE/jsp/AEBedAvailChartResult.jsp' ;
			//document.AEBedAvailChartForm.clinic_code.disabled = false;
			//document.AEBedAvailChartForm.submit();
			//parent.processBar.document.location.href = "../../eCommon/html/process.html";
		
	}	

	function getBedDetails1()
	{
		parent.frames[2].document.location.href = '../../eAE/jsp/AEBedAvailChartResult.jsp' ;
			document.AEBedAvailChartForm.clinic_code.disabled = false;
			document.AEBedAvailChartForm.submit();
			parent.processBar.document.location.href = "../../eCommon/html/process.html";
		
	}	

	

	function specialChar(obj)
	{
		if(obj.value!='')
		{
			var fields1 = new Array(obj);
			var names1 = new Array(obj.name.toUpperCase());
			var messageFrame = ""; var error_page = "";
			if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
			{
				if(CheckNum(obj))
				{
					 return true;
				}
				else 
				{
					 obj.focus();
					 return false;
				}
			}
			else
			{
			   obj.focus()
			   return false;
			}
		}
		
	}
	
	function submitPage()
	{
	}

	function checkFields1( fields, names)
	{
		var errors = "" ;
		for( var i=0; i<fields.length; i++ ) {
			if(trimCheck1(fields[i].value)) {}
			else	errors = errors + getMessage("CAN_NOT_BE_BLANK","Common")  + names[i] + " cannot be blank..." + "\n" ;
		}
		if ( errors.length != 0 ) {
			alert(errors) ;
			return false ;
		}
		return true ;
	}

	function trimCheck1(inString)
	{
		var startPos;
		var ch;
		startPos = 0;
		strlength = inString.length;

		for(var i=0;i<=strlength;i++) {
			ch = inString.charAt(startPos);
			if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
				startPos++;
			}
		}
		if(startPos == inString.length) return false;
		else return true;
	}
	

	function removeitems(obj)
	{
		var len=obj.length;
		var i=1;
		while(i<len)
		{
			len=obj.length
			obj.remove(i)
		}
	}
			
		</script>
	</head>

	<body onLoad="loadTreatmentArea();" onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name='AEBedAvailChartForm' id='AEBedAvailChartForm' action = "../../eAE/jsp/AEBedAvailChartGraphicResult.jsp" target='result' >
	<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr width="100%">
	<td width="15%" class="LABEL" align="RIGHT"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	</td>
	<td width="15%" class="QUERYDATA" align="LEFT">
	<select name="clinic_code" id="clinic_code" value="<%=clinic_code%>" onChange="getTreatmentArea();" >
	<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
	<%
		sqlString	= "SELECT DISTINCT CLINIC_CODE, LONG_DESC SHORT_DESC FROM op_clinic_lang_vw WHERE language_id='"+locale+"'  and FACILITY_ID = ? ORDER BY UPPER(2) ";	

		if (pStatement != null)	pStatement	= null;
		if (resultSet != null)	resultSet	= null;
		pStatement	= connection.prepareStatement(sqlString);
		pStatement.setString(1, facility_id);

		resultSet	=	pStatement.executeQuery();

		if (resultSet != null)
		{
			while(resultSet.next())
			{
				code = checkForNull(resultSet.getString("CLINIC_CODE"));
				desc = checkForNull(resultSet.getString("SHORT_DESC"));
				if (clinic_code.equals(code))
				{
				%>
				<option value="<%=code%>" selected><%=desc%></option>
				<%
				}
				else
				{
				%>
				<option value="<%=code%>" ><%=desc%></option>
				<%
				}
			}
		}
	%>
	</select>
	</td>
	<td width="15%" class="LABEL" align="RIGHT"><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	</td>
	<td width="15%" class="QUERYDATA" align="LEFT">
	<select name="treatment_area" id="treatment_area" value="<%=treatment_area%>">
	<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
	</select>
	</td>

		<td width="15%" class="LABEL" align="RIGHT"><fmt:message key="Common.bedstatus.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	</td>
	<td width="15%" class="QUERYDATA" align="LEFT">
	<select name="bed_status" id="bed_status">
	<option value="A" <%=selectValue%> ><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/></option>
	<option value="O" <%=selectValue%> selected><fmt:message key="Common.Occupied.label" bundle="${common_labels}"/></option>
	<option value="R" <%=selectValue%> ><fmt:message key="Common.Reserved.label" bundle="${common_labels}"/></option>
	<option value="B" <%=selectValue%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	</select>
	</td>
	
	<td align="RIGHT" ><input type="Button" name="search" id="search" value = "Search" class="BUTTON" onClick="getBedDetails1();"></td>



	</tr>
	</table>

	<input type="Hidden" name="call_function" id="call_function" value="<%=call_function%>">
	<input type="Hidden" name="age" id="age" value="<%=age%>">
	<input type="Hidden" name="gender" id="gender" value="<%=gender%>">
	<input type="Hidden" name="where_condition" id="where_condition" value="<%=where_condition%>">
	</form>
	</body>
<%
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	finally
	{
		%>
	<script>

	</script>

        <%
		if (resultSet != null)	resultSet.close();
		if (pStatement != null)	pStatement.close();
		ConnectionManager.returnConnection(connection, request);
	}
%>
<script>
document.forms[0].clinic_code.disabled=false;
document.forms[0].search.click();
</script>
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

