<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
	
	String locale			= (String)session.getAttribute("LOCALE");
	String loginUser	= checkForNull((String)session.getValue("login_user"));


	try
	{
		String facility_id			= checkForNull((String) session.getAttribute("facility_id"));
		String call_function		= checkForNull(request.getParameter("call_function"));
		String clinic_code			= checkForNull(request.getParameter("clinic_code"));
		String treatment_area		= checkForNull(request.getParameter("treatment_area"));
		String priority_zone		= checkForNull(request.getParameter("priority_zone"));
		String bed_no				= checkForNull(request.getParameter("bed_no"));
		String age					= checkForNull(request.getParameter("age"));
		String bed_classification	= checkForNull(request.getParameter("bed_classification"));
		String bed_status			= checkForNull(request.getParameter("bed_status"));
		String where_condition		= checkForNull(request.getParameter("where_condition"));
		String select_check			= checkForNull(request.getParameter("select_check"));
		String oper_stn_id=checkForNull(request.getParameter("oper_stn_id"));
		connection					= (Connection)ConnectionManager.getConnection(request);
		String code					=	"",   code1		 =  "";
		String desc					=	"",	  desc1		 =  "";
		String selectValue			=	"";
        String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script language='javascript' src='../../eAE/js/AEBedAvailChart.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onMouseDown="CodeArrest();" onLoad = "loadTreatmentArea();" onKeyDown = 'lockKey()'>
	<form name='AEBedAvailChartForm' id='AEBedAvailChartForm' action = "../../eAE/jsp/AEBedAvailChartResult.jsp" target="result1"><input type="hidden" name="priority_zone" id="priority_zone" value="<%=priority_zone %>">
	<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id %>" >
	<table cellpadding="0" cellspacing="0" border="0" width="100%" align = "center">
	<tr><td colspan='4' class='label' height='5'></td></tr>

<%
	// chnages made for pt issues

		if(!call_function.equals("AssignTrmtArea"))
		{
	
		%>

	<tr >
	<td width="25%" class="LABEL" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
	</td>
	<td width="25%" class="QUERYDATA" >
	
	<select name="clinic_code" id="clinic_code" value="<%=clinic_code%>" onChange="getTreatmentArea();"  disabled>
	<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
	<%
        // Monday, January 11, 2010 18108
		//String sqlLocation="select clinic_code,long_desc clinic_desc from op_clinic_lang_vw where language_id='"+locale+"'  and facility_id=? and care_locn_type_ind='C' and level_of_care_ind='E' and eff_status='E' order by 2";
		//String sqlLocation="select clinic_code,op_get_desc.op_clinic(facility_id,clinic_code,'"+locale+"',1)  clinic_desc from op_clinic where facility_id=? and clinic_code='"+clinic_code+"' and care_locn_type_ind='C' and level_of_care_ind='E' and eff_status='E' order by 2";
	// Thursday, May 06, 2010 PE_EXE 
		String sqlLocation="select clinic_code, long_desc clinic_desc from OP_CLINIC_LANG_VW where language_id='"+locale+"' and eff_status = 'E' AND LEVEL_OF_CARE_IND = 'E' and (facility_id,clinic_code,CLINIC_TYPE) in (select facility_id,locn_code,locn_type from AM_OS_USER_LOCN_ACCESS_VW where facility_id =? and oper_stn_id =? and appl_user_id = ? and RESERVE_BED_BAY_YN='Y') order by 2";

		pStatement	= connection.prepareStatement(sqlLocation);
		pStatement.setString(1, facility_id);
		pStatement.setString(2, oper_stn_id);
		pStatement.setString(3, loginUser);
		resultSet	=	pStatement.executeQuery();

		if (resultSet != null)
		{
			while(resultSet.next())
			{
				code = checkForNull(resultSet.getString("clinic_code"));
				desc = checkForNull(resultSet.getString("clinic_desc"));
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
		
		 if (resultSet != null)	resultSet.close();
		 if (pStatement != null)	pStatement.close();
		 }

	%>
	</select>
	</td>
	<td width="25%" class="LABEL" ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/> 
	</td>
	<td width="20%" class="QUERYDATA" >
	<select name="treatment_area" id="treatment_area" value="<%=treatment_area%>" disabled>
	<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
    <%

		StringBuffer sqlTreat = new StringBuffer();
        sqlTreat.append("select treatment_area_code,short_desc treatment_area_desc,  to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date from ae_tmt_area_for_clinic_lang_vw  where language_id='"+locale+"'  and facility_id = ? and CLINIC_CODE = ? ");

		if(!priority_zone.equals(""))
		{		
			sqlTreat.append(" AND PRIORITY_ZONE= ?	");
		}
		
		sqlTreat.append(" and eff_status = 'E'  order by 2");
		pStatement	= connection.prepareStatement(sqlTreat.toString());
		pStatement.setString(1, facility_id);
		pStatement.setString(2, clinic_code);
		if(!priority_zone.equals(""))
		{	
			pStatement.setString(3, priority_zone);
		}
		resultSet	=	pStatement.executeQuery();

		if (resultSet != null)
		{
			while(resultSet.next())
			{
				code1 = checkForNull(resultSet.getString("treatment_area_code"));
				desc1 = checkForNull(resultSet.getString("treatment_area_desc"));

				if (treatment_area.equals(code1))
				{
				%>
				<option value="<%=code1%>" selected><%=desc1%></option>
				<%
				}
				else
				{
				%>
				<option value="<%=code1%>" ><%=desc1%></option>
				<%
				}
			}
		}
		if (pStatement != null)	pStatement.close();
		if (resultSet != null)	resultSet.close();
		if((sqlTreat != null) && (sqlTreat.length() > 0))
			{
				sqlTreat.delete(0,sqlTreat.length());
			} 
	%>
	</select>
	</td>
	</tr>	
	<%}
	
	else if(call_function.equals("AssignTrmtArea"))
		{
		%>
			<tr >
				<td width="25%" class="LABEL" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
				</td>
				<td width="25%" class="QUERYDATA" >
				
				<select name="clinic_code" id="clinic_code" value="<%=clinic_code%>" onChange="getTreatmentArea();"  disabled>
				<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>

		<%

			StringBuffer sqlTreat = new StringBuffer();
			 sqlTreat.append("SELECT   clinic_code, op_get_desc.op_clinic(facility_id,clinic_code,'"+locale+"' ,1) clinic_desc, treatment_area_code, short_desc treatment_area_desc, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_date  FROM ae_tmt_area_for_clinic_lang_vw    WHERE language_id ='"+locale+"' AND facility_id = ? AND clinic_code =? and treatment_area_code =?");

			if(!priority_zone.equals(""))
			{		
				sqlTreat.append(" AND PRIORITY_ZONE= ?	");
			}
		
			sqlTreat.append(" and eff_status = 'E'  order by 2");
			pStatement	= connection.prepareStatement(sqlTreat.toString());
			

		pStatement.setString(1, facility_id);
		pStatement.setString(2, clinic_code);
		pStatement.setString(3, treatment_area);
		

		if(!priority_zone.equals(""))
		{	
			pStatement.setString(4, priority_zone);
		
		}		

		resultSet	=	pStatement.executeQuery();

		if (resultSet != null)
		{
			while(resultSet.next())
			{
				code1 = checkForNull(resultSet.getString("treatment_area_code"));
				desc1 = checkForNull(resultSet.getString("treatment_area_desc"));


				code = checkForNull(resultSet.getString("clinic_code"));
				desc = checkForNull(resultSet.getString("clinic_desc"));
				}

		} 

		if (pStatement != null)	pStatement.close();
		if (resultSet != null)	resultSet.close();
		if((sqlTreat != null) && (sqlTreat.length() > 0))
			{
				sqlTreat.delete(0,sqlTreat.length());
			} 

				%>

				<option value="<%=code%>" selected><%=desc%></option>
				</select>
				</td>

			
				<td width="25%" class="LABEL" ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/> 
				</td>
				<td width="20%" class="QUERYDATA" >
				<select name="treatment_area" id="treatment_area" value="<%=treatment_area%>" disabled>
				<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%

					if (treatment_area.equals(code1))
				{
				%>
				<option value="<%=code1%>" selected><%=desc1%></option>
				<%
				}
				else
				{
				%>
				<option value="<%=code1%>" ><%=desc1%></option>
				<%
				}
			
			%>

			</select>
				</td>
				</tr>
		<%	
		}
		%>
		
	<tr width="98%">
	<td width="25%" class="LABEL" ><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/>
	</td>
	<td width="25%" class="QUERYDATA" >
		<%
		if(!call_function.equals("ReserveBed"))
		{
		%>
	<select name="bed_classification" id="bed_classification">
		<%
			if(bed_classification.equals(""))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="" <%=selectValue%> >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<%
			if(bed_classification.equals("N"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="N" <%=selectValue%>><fmt:message key="eAE.NormalBedBay.label" bundle="${ae_labels}"/></option>
		<%
			if(bed_classification.equals("P"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="P" <%=selectValue%> ><fmt:message key="eAE.PseudoBedBay.label" bundle="${ae_labels}"/></option>
		<%
			if(bed_classification.equals("B"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="B" <%=selectValue%> ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
	</select>
			<%
		}
		else
		{ 
		%>
			<input type='text' name='bed_classification_desc' id='bed_classification_desc' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")%>' size='10' maxlength='10' readonly>
			<input type='hidden' name='bed_classification' id='bed_classification' value='<%=bed_classification%>'>
		<%
		}
			%>
	</td>
	<td width="25%" class="LABEL" ><fmt:message key="eAE.BedBayStatus.label" bundle="${ae_labels}"/>
	</td>
	<td width="25%" class="QUERYDATA" align="LEFT">
<%
	if(!call_function.equals("ReserveBed") && ! call_function.equals("AssignTrmtArea"))
	{
	%>
	<select name="bed_status" id="bed_status">
	<option value="B" <%=selectValue%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<%
			if(bed_status.equals("O"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="O" <%=selectValue%> ><fmt:message key="Common.Occupied.label" bundle="${common_labels}"/></option>

		<%
			if(bed_status.equals("R"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="R" <%=selectValue%> ><fmt:message key="Common.Reserved.label" bundle="${common_labels}"/></option>
	<%
			if(bed_status.equals("V"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="V" <%=selectValue%> ><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/></option>
		<%
			if(bed_status.equals("X"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	</select>
	<%	}
		else
		{ 
	%>
		<input type='text' name='bed_status_desc' id='bed_status_desc' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Vacant.label","common_labels")%>' size='10' maxlength='10' readonly>
		<input type='hidden' name='bed_status' id='bed_status' value='<%=bed_status%>' >
	<%
		}
	%>
	</td>
	</tr>
	<tr><td></td><td></td><td></td>
	<td  class='button'align="right"><input type="Button" name="search" id="search" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class="BUTTON" onClick="getBedDetails();"><input type="Button" name="clear" id="clear" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class="BUTTON" onclick="clearContent();"></td>
	</tr>
		<tr><td colspan='4' class='label' height='5'></td></tr>
	</table>
	<%
		if ((select_check.equals("N")) || (select_check.equals("X")))
		{
		  out.println("<script>document.forms[0].clinic_code.disabled=false;</script>");
          out.println("<script>document.forms[0].treatment_area.disabled=false;</script>");
		}
	%>
	<input type="Hidden" name="call_function" id="call_function" value="<%=call_function%>">
	<input type="Hidden" name="age" id="age" value="<%=age%>">
	<input type="Hidden" name="bed_no" id="bed_no" value="<%=bed_no%>">
	<input type="Hidden" name="where_condition" id="where_condition" value="<%=where_condition%>">
	<input type="Hidden" name="select_check" id="select_check" value="<%=select_check%>">
    <input type="Hidden" name="call_function" id="call_function" value="<%=call_function%>">
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
		ConnectionManager.returnConnection(connection, request);
	}
%>
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

