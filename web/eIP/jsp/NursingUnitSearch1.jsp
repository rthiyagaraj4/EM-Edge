<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con					= null;
	Statement stmt=null;
	ResultSet rs =null;
	String called_from=request.getParameter("called_from");
	String facility_id=(String)session.getValue("facility_id");
	int count=0;
	try{
		con=ConnectionManager.getConnection(request);
		String sql="Select count(*) from IP_NURSING_UNIT where facility_id='"+facility_id+"' and eff_status='E' ";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		rs.next();
		count=rs.getInt(1);
	
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>

function PopulateResult()
{
	var nursing_unit=document.forms[0].nursing_unit.value;
	var called_from='<%=called_from%>';
	
	if(nursing_unit!="")
	{
		
		if(called_from==5)
		{
		parent.frames[2].location.href='../../eIP/jsp/addModifyIPOnlineReport.jsp?nursing_unit_code='+nursing_unit;
		}
	}
	else
	{
		alert(getMessage('NU_NOTNULL','IP'));
		document.forms[0].nursing_unit.focus();
	}
}
async function showmodal()
{
	var facility_id=document.forms[0].facility_id.value;
	 facility_id="`"+'<%=facility_id%>'+"`";

	var target = document.forms[0].nursing_unit;

	var retVal =    new String();
	var dialogTop   = "40";
	var dialogHeight    = "500px" ;
	var dialogWidth = "900px" ;
	var features    ="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;

	var sql="select NURSING_UNIT_CODE,SHORT_DESC from IP_NURSING_UNIT where  facility_id="+facility_id;	
	var search_code="NURSING_UNIT_CODE";
	var search_desc="SHORT_DESC";
	var tit=getLabel('Common.NursingUnitCode.label','Common');
	
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
		target.focus();
	}
	else
		target.focus();
}

function PopulateValues(obj)
{
	alert(parent.parent.frames[2].document.getElementById('td5').innerHTML);
		if(obj.value!="")
		{
			var nursing_unit=obj.value;
			alert(parent.parent.frames[2].document.getElementById('td5').innerHTML);
			var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='nursingunit' id='nursingunit' method='post' action='../../eIP/jsp/PopulateNursingUnitValues.jsp'><input type='hidden' name='nursing_unit' id='nursing_unit' value='"+nursing_unit+"'></form></body></html>";	
		
			parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.frames[2].document.forms[0].submit();
		}
}

</script>

</head>

<body onLoad='FocusFirstElement()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='Search_form' id='Search_form'>
  <table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
	<tr>
		<td width="20%" >&nbsp;</td>
		<td width="30%" >&nbsp;</td>
		<td width="20%" >&nbsp;</td>
		<td width="30%" >&nbsp;</td>
	</tr>
	 <tr>
	  	<td align='right' class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		 <td align='left' class=label id=td5>
		 <%
			if(count>15)
			{	 
		 %>
			 <input type=text name=nursing_unit id=nursing_unit size=4 maxlength=4 onblur='ChangeUpperCase(this);'><input type=button class=button name='?' id='?' value='?' onclick='showmodal()'></td>
			 <td class=label align=left>&nbsp;</td>
			 <td>&nbsp;</td>
		<%
			}
			else
			{
		 %>
			 <select name=nursing_unit id=nursing_unit>
				<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<%
					try{
							String sqln="select NURSING_UNIT_CODE,SHORT_DESC from IP_NURSING_UNIT where  facility_id='"+facility_id+"' ";
							String id="";
							String dat="";
							stmt=con.createStatement();
							rs=stmt.executeQuery(sqln);
							if(rs!=null)
							{
								while(rs.next())
								{
									id=rs.getString(1);
									dat=rs.getString(2);
									out.println("<option value='"+id+"'>"+dat+"</option>");
								}
							}
							if(rs!=null)rs.close();
							if(stmt!=null)stmt.close();



						}
						catch(Exception e) {out.println(e);}
				%>
			 </select></td>
			<td colspan=2>&nbsp;</td>
		<%
			}
		 %>
   	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td class=label align=right><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
		<td align=left class=label id=td1></td>
		<td class=label align=right><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align=left class=label id=td2></td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
	<tr>
		<td class=label align=right><fmt:message key="Common.department.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align=left class=label id=td3></td>
		<td class=label align=right><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td align=left class=label id=td4></td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;</td>
	</tr>
		<tr>
		<td colspan=3>&nbsp;&nbsp;</td>
		<td align=right><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='PopulateResult()'></td>
	</tr>
	<tr>
		<td colspan=4>&nbsp;&nbsp;</td>
	</tr>
<input type=hidden name=called_from id=called_from value='<%=called_from%>'>
<input type=hidden name=facility_id id=facility_id value='<%=facility_id%>'>

</form>
<%
}
catch ( Exception e ){out.println(e.toString());}
finally{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
		ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

