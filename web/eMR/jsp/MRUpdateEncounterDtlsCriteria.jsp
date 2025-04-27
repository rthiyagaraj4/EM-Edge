<!DOCTYPE html>

<html>
	<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html; charset=UTF-8"%>
	<%	request.setCharacterEncoding("UTF-8");	%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<head>
		<%
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eMR/js/MRUpdateEncounterDtls.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		Connection con=null;
		Statement stmt=null;
		ResultSet rSet=null;
		String	Patient_Id_Length="";	
		try{
			con=ConnectionManager.getConnection(request);
			stmt	= con.createStatement();
			rSet	= stmt.executeQuery("Select patient_id_length from mp_param where module_id='MP'");
			if(rSet!=null && rSet.next()){
				Patient_Id_Length=rSet.getString("patient_id_length");
			}			
	%>
	<body onMouseDown="CodeArrest();" onKeyDown ='lockKey();'>
		<form name="EncDtlsCriteria" id="EncDtlsCriteria">
			<table  border="0" width='70%' cellspacing='0' cellpadding='2' align="center">
				<tr>
					<td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text"  name="patient_id" id="patient_id" align="left" size='15' maxlength='<%=Patient_Id_Length%>' onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);"><input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="getPatID()">
					</td>	
					<td class='label' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td class='fields'>
					<select name='patient_class' id='patient_class'><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						rSet=stmt.executeQuery("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS_LANG_VW where patient_class not in ('XT') AND language_id='"+localeName+"' order by 1");
						while(rSet!=null && rSet.next()){%>
							<option value='<%=rSet.getString("PATIENT_CLASS")%>'><%=rSet.getString("short_desc")%></option>
						<%}
					%>
					</select>
					</td>	
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text"  name="encounter_id" id="encounter_id" align="left" size='12' maxlength='12' onKeyPress=''><!--<input type="button" value="?" class="button" name='enc_search' id='enc_search' onClick="">-->
					</td>
					<td class='label' ><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
					<td nowrap class='fields'><input type='text' id='encDateFromID' name='encDateFrom' id='encDateFrom' size='10' maxlength='10' onBlur="validDateObjLoc(this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].encDateFromID.select();return showCalendar('encDateFromID');"></img>		
				&nbsp;-&nbsp;<input type='text' id='encDateToID' name='encDateTo' id='encDateTo' size='10' maxlength='10' onBlur="validDateObjLoc(this);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].encDateTo.select();return showCalendar('encDateToID');"></td>
					</td>
				</tr>
				 <tr>
					<td><td>	 	
					<td  colspan=2 align='right'><input type="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='SearchResult()' class='button'><input type="button" name="Clear" id="Clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class='button' onClick='ClearFrame()'></td>
				</tr>
			<table>
		</form>
	</body>
	<%
		}catch(Exception Ex){
			Ex.printStackTrace();
		}finally{
			if(con!=null){
				ConnectionManager.returnConnection(con,request);
			}
		}
	%>
</html>

