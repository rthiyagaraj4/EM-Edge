<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;	
	ResultSet	rs			= null;
	PreparedStatement pst	= null;

	String patient_id			 = "";
	String patientid			 = "";	
	String file_no				 = "";
	String file_type_code		 = "";
	String short_desc			 = "";
	String file_type_appl_yn	 = "";
	String facilityid			 = "";
	String operation			 = "";
	String sqlString             = "";
	String patient_id_max_length = "";

	int rec_count = 0;

try
{
	con	= ConnectionManager.getConnection(request);

	facilityid			  = (String) session.getValue("facility_id");
	patient_id			  = request.getParameter("patient_id");
	file_no				  = request.getParameter("file_no");
	file_type_code		  = request.getParameter("file_type_code");
	file_type_appl_yn	  = request.getParameter("file_type_appl_yn");
	operation			  = request.getParameter("operation");
	patient_id_max_length = request.getParameter("patient_id_max_length");
	
	if(patient_id == null || patient_id.equals("null")) patient_id = "";
	if(file_no == null || file_no.equals("null")) patient_id = "";
	if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";
	if(operation == null || operation.equals("null")) operation = "";

	if (!patient_id.equals(""))
	{
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(facilityid);
		String patient_status = patdata.CheckStatus(con,patient_id);
		if (patient_status.equals("INVALID_PATIENT"))
		{
%>
			<script>
			var msg = getMessage('INVALID_VALUE','Common'); 
			msg = msg.replace('#',getLabel('Common.patientId.label','Common'));
			alert(msg);
			parent.createvolume_header.document.FMCreateFileVolumeSearchForm.patient_id.value="";;
			parent.createvolume_header.document.FMCreateFileVolumeSearchForm.patient_id.select();
			</script>
<%		
		}
	}
	if(patient_id.equals("") && operation.equals("POP_PATIENTID"))
	{
		if(!file_no.equals("") && file_type_appl_yn.equals("N"))
		{
			sqlString = "SELECT patient_id FROM mr_pat_file_index WHERE facility_id = ? AND file_no = ? ";
			pst	=	con.prepareStatement(sqlString);
			pst.setString(1, facilityid);
			pst.setString(2, file_no);
			rs	=	pst.executeQuery();

			if(rs != null && rs.next())
			{
				patientid = rs.getString("patient_id");
				%>
				<script>
						parent.createvolume_header.document.getElementById("PatientID").innerHTML = "<input type='text' name='patient_id' id='patient_id' value='"+"<%=patientid%>"+"' size='<%=patient_id_max_length+2%>' maxlength='<%=patient_id_max_length%>'  onBlur='return popData(this);'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				</script>
				<%
			} 
			if(rs!=null)	rs.close();
			if(pst !=null) pst.close();
		}
	}
	if(file_type_appl_yn.equals("N"))
	{
		String mysql = "select count(*) reccount from MR_PAT_FILE_INDEX where FACILITY_ID = ? AND PATIENT_ID = ? ";	

		pst = con.prepareStatement(mysql);
		pst.setString(1,facilityid);
		pst.setString(2,patient_id);
		rs = pst.executeQuery();

		if(rs != null && rs.next())
		{
			rec_count = rs.getInt("reccount");
		}
		if(rs!=null)	rs.close();
		if(pst !=null) pst.close();

		out.println("<script>parent.frames[2].document.location.href='../../eCommon/html/blank.html'</script>");
		out.println("<script>var obj =parent.createvolume_header.document.FMCreateFileVolumeSearchForm.file_no;");
		out.println("var length  = obj.length;");
		out.println("for(i=0;i<length;i++) {obj.remove(0);}</script>");
		
		String mysql1 = "SELECT FILE_NO FROM MR_PAT_FILE_INDEX WHERE FACILITY_ID = ? AND PATIENT_ID = ?";
		
		pst = con.prepareStatement(mysql1);
		pst.setString(1,facilityid);
		pst.setString(2,patient_id);
		rs  = pst.executeQuery();

		if(rec_count == 0)
		{
			%>
			<script>
				parent.createvolume_header.document.getElementById("FileID").innerHTML = "<input type='text' name='file_no' id='file_no' value='' size='<%=patient_id_max_length+2%>' maxlength='<%=patient_id_max_length%>' onBlur='popPatientID(this);'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			</script>
			<%
		}
		else if(rec_count == 1)
		{
			if(rs != null && rs.next())
			{
				file_no = rs.getString("FILE_NO");
				%>
				<script>
					parent.createvolume_header.document.getElementById("FileID").innerHTML = "<input type='text' name='file_no' id='file_no' value='"+"<%=file_no%>"+"' size='<%=patient_id_max_length+2%>' maxlength='<%=patient_id_max_length%>' onBlur='popPatientID(this);'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				</script>
				<%
			}
		}
		else if(rec_count > 1)
		{
			%>
			<script>
				var opt = "";
				<%
				while(rs != null && rs.next())
				{
					file_no		=	rs.getString("FILE_NO");
					%>
					opt = opt + "<option value='"+"<%=file_no%>"+"'>"+"<%=file_no%>"+"</option>";
					<%
				}
				%>
				var selectBox	= "<select name='file_no' id='file_no' value = '' onBlur='popPatientID(this);'><option>---------"+getLabel('Common.defaultSelect.label','common')+"---------</option>";
				selectBox += opt;
				selectBox += "</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				parent.createvolume_header.document.getElementById("FileID").innerHTML = selectBox;
			</script>
		<%
		}
		if(rs != null)  rs.close();
		if(pst != null) pst.close();
	}
	else if(file_type_appl_yn.equals("Y"))
	{
		out.println("<script>parent.frames[2].document.location.href='../../eCommon/html/blank.html'</script>");

		out.println("<script>var obj1 =parent.createvolume_header.document.FMCreateFileVolumeSearchForm.file_type_code;");
		out.println("var length  = obj1.length;");
		out.println("for(i=0;i<length;i++) {obj1.remove(0);}</script>");

		String mysql2 = "SELECT distinct A.FILE_TYPE_CODE FILE_TYPE_CODE, A.SHORT_DESC FROM MR_FILE_TYPE A,MR_PAT_FILE_INDEX  B WHERE A.FACILITY_ID = B.FACILITY_ID AND A.FILE_TYPE_CODE = B.FILE_TYPE_CODE AND A.FACILITY_ID = ? AND B.PATIENT_ID = ?";

		pst = con.prepareStatement(mysql2);
		pst.setString(1,facilityid);
		pst.setString(2,patient_id);
		rs = pst.executeQuery();
			
		%>
		<script>
			var opt = "";
			<%
			while(rs != null && rs.next())
			{
				file_type_code = rs.getString("FILE_TYPE_CODE");
				short_desc = rs.getString("SHORT_DESC");
					
				%>
				opt = opt + "<option value='"+"<%=file_type_code%>"+"'>"+"<%=short_desc%>"+"</option>";
				<%
			}
			%>
			var selectBox	= "<select name='file_type_code' id='file_type_code' value = '' ><option>---------"+getLabel('Common.defaultSelect.label','common')+"---------</option>";
			selectBox += opt;
			selectBox += "</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			parent.createvolume_header.document.getElementById("FileType").innerHTML = selectBox;
		</script>
		<%
	if(rs!=null)	rs.close();
	if(pst !=null)  pst.close();
	}
}catch(Exception e){out.println("Exception e :" +e.toString());}
finally
{			
		ConnectionManager.returnConnection(con,request);	
}
%>
<SCRIPT>
	parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp";
</SCRIPT>

