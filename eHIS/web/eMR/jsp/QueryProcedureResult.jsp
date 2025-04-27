<!DOCTYPE html>
<html>
	<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<% request.setCharacterEncoding("UTF-8"); %>
	<head>
		<%String sStyle	=
		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
		<%

		Connection connection			=	null;
		PreparedStatement pStatement	=	null;
		ResultSet resultSet				=	null ;

		String procedure_code			=	"";
		//String procedure_desc			=	"";
		String patient_id				=	"";
		String patient_name				=	"";
		String date_of_birth			=	"";
		String gender					=	"";
		String proc_date				=	"";
		String practitioner_name		=	"";
		String class_value				= "QRYEVEN";


		try
		{
			connection					=	ConnectionManager.getConnection(request);
			procedure_code				=	checkForNull(request.getParameter("procedure_code"));
		//	procedure_desc				=	checkForNull(request.getParameter("procedure_desc"));
			
			//StringBuffer countBuffer	=   new StringBuffer();
			String locale = (String) session.getValue("LOCALE");
			//int count_value				= 0;
			int maxRecord				= 0;
			/*countBuffer.append("SELECT count(*) count_value FROM pr_encounter_procedure a, mp_patient b, ");
			countBuffer.append("am_practitioner c WHERE a.patient_id = b.patient_id AND a.practitioner_id = c.practitioner_id AND a.proc_code like upper(?)");

			pStatement	=	connection.prepareStatement(countBuffer.toString());
			pStatement.setString(1, procedure_code);
			resultSet	=	pStatement.executeQuery();

			if ((resultSet != null) && (resultSet.next()))
				count_value = resultSet.getInt("count_value");

			if (count_value==0)
			{*/
			%>
				<!--<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				</script>-->
			<%/*
				return;
			}
			else
			{*/
			StringBuffer sqlBuffer		=	new StringBuffer();
			sqlBuffer.append("SELECT a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))patient_name, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, ");
			sqlBuffer.append("decode(b.sex,'M','Male','F','Female','U','Unknown') gender, to_char(a.proc_date, 'dd/mm/rrrr hh24:mi') proc_date, ");
			sqlBuffer.append("c.practitioner_name FROM pr_encounter_procedure a, mp_patient b, ");
			sqlBuffer.append("am_practitioner c WHERE a.patient_id = b.patient_id AND a.ERROR_YN='N' AND ");
			sqlBuffer.append("a.practitioner_id = c.practitioner_id AND a.proc_code = upper(?) order by a.patient_id");

			//if (resultSet != null)   resultSet.close();
			//if (pStatement != null)  pStatement.close();
			pStatement	=	connection.prepareStatement(sqlBuffer.toString());
			pStatement.setString(1, procedure_code);
			resultSet	=	pStatement.executeQuery();
			%>
			<form name="QUERY_PROC_RESULT_FROM" id="QUERY_PROC_RESULT_FROM">
					<table cellpadding="0" cellspacing="0" border="1" width="100%">
					<!--<tr>
					<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/></th>
					</tr>-->
					<%
					if (resultSet != null){
						while(resultSet.next()){
							if(maxRecord==0){%>
								<tr>
									<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
									<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
									<th nowrap><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></th>
									<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
									<th nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
									<th nowrap><fmt:message key="Common.recordeddate.label" bundle="${common_labels}"/></th>
									</tr>
									<%
									}
									patient_id			= checkForNull(resultSet.getString("patient_id"));
									patient_name		= checkForNull(resultSet.getString("patient_name"));
									date_of_birth		= checkForNull(resultSet.getString("date_of_birth"));
									if(!(date_of_birth==null || date_of_birth.equals("")))
									date_of_birth	= DateUtils.convertDate(date_of_birth,"DMYHM","en",locale);
									gender				= checkForNull(resultSet.getString("gender"));
									proc_date			= checkForNull(resultSet.getString("proc_date"));
									if(!(proc_date==null || proc_date.equals("")))
									proc_date		= DateUtils.convertDate(proc_date,"DMYHM","en",locale);

									practitioner_name	= checkForNull(resultSet.getString("practitioner_name"));

									if(class_value.equals("QRYEVEN"))
									class_value = "QRYODD";
									else
									class_value = "QRYEVEN";
									%>
									<tr>
									<td class="<%=class_value%>" nowrap><%=patient_id%></td>
									<td class="<%=class_value%>" nowrap><%=patient_name%></td>
									<td class="<%=class_value%>" nowrap><%=date_of_birth%></td>
									<td class="<%=class_value%>" nowrap><%=gender%></td>
									<td class="<%=class_value%>" nowrap><%=practitioner_name%></td>
									<td class="<%=class_value%>" nowrap><%=proc_date%></td>
								</tr>
							<%
							maxRecord++;
						}
					}
					%>
					</table>
					<%
					//}
					if (maxRecord==0){%>
						<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
					<%}
					}
					catch (Exception e){/* out.println(e.toString()); */e.printStackTrace();}
					finally {
						try
						{
						if(pStatement!=null) pStatement.close();
						if(resultSet!=null) resultSet.close();
						}
						catch (Exception e){}
						ConnectionManager.returnConnection(connection,request);
					}

					%>
			</form>
	</body>
</html>

<%!
	// To Handle java.lang.NullPointerException
	public static String checkForNull(String inputString)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
	}

%>

