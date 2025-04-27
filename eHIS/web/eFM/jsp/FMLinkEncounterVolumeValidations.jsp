<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String facilityID				=	"";
String patientID				=	"";
String file_type_appl_yn		=	"N";
String sqlString				=	"";
String file_no					=	"";
String file_type_code			=	"";
String file_type_desc			=	"";
String fileNo					=	"";

int record_count				=	0;

try
{
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	patientID			=	checkForNull(request.getParameter("patientID"));
	file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	fileNo				=	checkForNull(request.getParameter("fileNo"));
	connection			=	ConnectionManager.getConnection(request);	

	if (!patientID.equals(""))
	{
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(facilityID);
		String patient_status = patdata.CheckStatus(connection,patientID);
		if (patient_status.equals("INVALID_PATIENT"))
			out.println("<script>var msg = getMessage('INVALID_VALUE','Common'); msg = msg.replace('#',getLabel('Common.patientId.label','Common'));alert(msg);parent.frames[1].document.forms[0].patient_id.value='';parent.frames[1].document.forms[0].patient_id.select();</script>");
	}
	if (fileNo.equals(""))
	{
		if (file_type_appl_yn.equals("N"))
			sqlString = "SELECT count(*) record_count FROM mr_pat_file_index WHERE facility_id = ? AND patient_id = ? ";
		else if (file_type_appl_yn.equals("Y"))
			sqlString = "SELECT count(*) record_count FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id = ? AND b.patient_id = ? ";

		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, patientID);

		resultSet = preStatement.executeQuery();
		if ((resultSet != null) && (resultSet.next()))
			record_count = resultSet.getInt("record_count");

		if (file_type_appl_yn.equals("N"))
			sqlString = "SELECT file_no FROM mr_pat_file_index WHERE facility_id = ? AND patient_id = ? ";
		else if (file_type_appl_yn.equals("Y"))
			sqlString = "SELECT DISTINCT a.file_type_code file_type_code, a.short_desc file_type_desc FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id = ? AND b.patient_id = ? ";

		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();

		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, patientID);

		resultSet = preStatement.executeQuery();
		if (resultSet != null)
		{
			if (file_type_appl_yn.equals("N"))
			{
				if (record_count==0)
				{
					%>
						<script>
							parent.frames[1].document.getElementById("FileNo").innerHTML = "<input type='text' name='file_no' id='file_no' value='' onBlur='getPaientID(this.value);'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
						</script>
					<%
				}
				else if (record_count==1)
				{
					if(resultSet.next())
					{
						file_no		=	checkForNull(resultSet.getString("file_no"));
					%>
						<script>
							parent.frames[1].document.getElementById("FileNo").innerHTML = "<input type='text' name='file_no' id='file_no' value='"+"<%=file_no%>"+"' onBlur='getPaientID(this.value);'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
						</script>
					<%
					}
				}
				else if (record_count > 1)
				{
				%>
					<script>
						var optionValue	= "";	
				<%
					while(resultSet.next())
					{
						file_no		=	checkForNull(resultSet.getString("file_no"));
				%>
						optionValue = optionValue + "<option value='"+"<%=file_no%>"+"'>"+"<%=file_no%>"+"</option>";
				<%
					}
				%>
						var selectBox	= "<select name='file_no' id='file_no' value = '' ><option>------------------------"+getLabel('Common.defaultSelect.label','common')+"-----------------------</option>";
						selectBox += optionValue;
						selectBox += "</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
						parent.frames[1].document.getElementById("FileNo").innerHTML = selectBox;
						</script>
				<%
				}
			}
			else
			if (file_type_appl_yn.equals("Y"))
			{
				if (record_count==0)
				{
					%>
						<script>
							parent.frames[1].document.getElementById("FileType").innerHTML = "<input type='text' name='file_type' id='file_type' value='' ><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
						</script>
					<%
				}
				else if (record_count==1)
				{
					if(resultSet.next())
					{
						file_type_code		=	checkForNull(resultSet.getString("file_type_code"));
						file_type_desc		=	checkForNull(resultSet.getString("file_type_desc"));
					%>
						<script>
							parent.frames[1].document.getElementById("FileType").innerHTML = "<input type='text' name='file_type' id='file_type' value='"+"<%=file_type_desc%>"+"'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
							parent.frames[1].document.forms[0].patient_file_type.value = "<%=file_type_code%>";
						</script>
					<%
					}
				}
				else if (record_count > 1)
				{
				%>
					<script>
						var optionValue	= "";	
				<%
					while(resultSet.next())
					{
						file_type_code		=	checkForNull(resultSet.getString("file_type_code"));
						file_type_desc		=	checkForNull(resultSet.getString("file_type_desc"));
				%>
						optionValue = optionValue + "<option value='"+"<%=file_type_code%>"+"'>"+"<%=file_type_desc%>"+"</option>";
				<%
					}
				%>
						var selectBox	= "<select name='file_type' id='file_type' onChange='setValues(this.value)'><option value = '' >----------"+getLabel('Common.defaultSelect.label','common')+"---------</option>";
						selectBox += optionValue;
						selectBox += "</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
						parent.frames[1].document.getElementById("FileType").innerHTML = selectBox;
						</script>
				<%
				}
			}
		}
	}
	else if (!fileNo.equals(""))
	{
		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		sqlString = "SELECT patient_id FROM mr_pat_file_index WHERE facility_id = ? AND file_no = ? ";
		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, fileNo);
		
		resultSet	=	preStatement.executeQuery();
		if ((resultSet != null) && (resultSet.next()))
		{
		%>
			<script>
				parent.frames[1].document.forms[0].patient_id.value = '<%=checkForNull(resultSet.getString("patient_id"))%>';
			</script>
		<%
		}
		else
		{
		%>
			<script>
				parent.frames[1].document.forms[0].patient_id.value = '';
			</script>
		<%
		}	
	}

%>

</head>

<script>parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';</script>
<%
if(preStatement!=null) preStatement.close();
if(resultSet!=null)	resultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}
%>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}

%>

