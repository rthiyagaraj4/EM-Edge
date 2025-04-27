<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/ShiftForWorkplace.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode = request.getParameter("mode")==null ? "1":request.getParameter("mode");
	String facility_id = (String)session.getAttribute("facility_id");

	String shift_code = request.getParameter("shift_code")==null ? "": request.getParameter("shift_code");
	String locn_type = request.getParameter("locn_type")==null ? "": request.getParameter("locn_type");
	String shift_mnemonic=request.getParameter("shift_mnemonic")==null?"":request.getParameter("shift_mnemonic");
	String totalRecords = "";
	ArrayList Workplace_Data=new ArrayList();
	String record[]=null;

	try{
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//String qry_facility = "select 	a.locn_type locn_type,b.long_desc locn_desc,a.facility_id facility_id, a.workplace_code workplace_code, a.workplace_desc workplace_desc, 'I' db_action, 'E' enabled from 	rs_workplace a, am_care_locn_type b where 	a.facility_id = ? and a.locn_type = nvl(?,a.locn_type) and 	a.eff_status = 'E' and 	a.locn_type = b.locn_type and 	(a.facility_id,a.workplace_code) not in  (select facility_id,workplace_code from rs_shift_for_workplace where facility_id = ? and shift_code = ?) union all select 	d.locn_type locn_type,e.long_desc locn_desc, c.facility_id facility_id, c.workplace_code workplace_code, d.workplace_desc workplace_desc, 'U' db_action, c.eff_status enabled from 	rs_shift_for_workplace c, rs_workplace d, am_care_locn_type e where 	c.facility_id = ? and c.shift_code = ? and 	d.facility_id = c.facility_id and d.workplace_code = c.workplace_code and 	d.locn_type = nvl(?,d.locn_type) and d.locn_type = e.locn_type order by locn_type,workplace_desc";
		String qry_facility = "select  a.locn_type locn_type,b.long_desc locn_desc,a.facility_id facility_id, a.workplace_code workplace_code, a.workplace_desc workplace_desc, 'I' db_action, 'E' enabled from  rs_workplace_lang_vw a, am_care_locn_type_lang_vw b where  a.facility_id = ? and a.locn_type = nvl(?,a.locn_type) and  a.eff_status = 'E' and  a.locn_type = b.locn_type and  (a.facility_id,a.workplace_code) not in  (select facility_id,workplace_code from rs_shift_for_workplace where facility_id = ? and shift_code = ?) and a.language_id = ? and b.language_id = a.language_id union all select  d.locn_type locn_type,e.long_desc locn_desc, c.facility_id facility_id, c.workplace_code workplace_code, d.workplace_desc workplace_desc, 'U' db_action, c.eff_status enabled from  rs_shift_for_workplace c, rs_workplace_lang_vw d, am_care_locn_type_lang_vw e where  c.facility_id = ? and c.shift_code = ? and  d.facility_id = c.facility_id and d.workplace_code = c.workplace_code and  d.locn_type = nvl(?,d.locn_type) and d.locn_type = e.locn_type and d.language_id = ? and e.language_id = d.language_id order by locn_type,workplace_desc";

		pstmt = conn.prepareStatement(qry_facility);
		
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locn_type);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,shift_code);
		pstmt.setString(5,locale);
		pstmt.setString(6,facility_id);
		pstmt.setString(7,shift_code);
		pstmt.setString(8,locn_type);
		pstmt.setString(9,locale);

		rs = pstmt.executeQuery();
		
		while(rs.next())	{

			record		 = new String[6];
			record[0] = rs.getString("locn_type")==null ? "":rs.getString("locn_type");
			record[1] = rs.getString("locn_desc")==null ? "":rs.getString("locn_desc");
			record[2] = rs.getString("workplace_code")==null ? "":rs.getString("workplace_code");
			record[3] = rs.getString("workplace_desc")==null ? "":rs.getString("workplace_desc");
			record[4] = rs.getString("db_action")==null ? "": rs.getString("db_action");
			record[5] = rs.getString("enabled")==null ? "": rs.getString("enabled");
			Workplace_Data.add(record);
		}
		totalRecords = String.valueOf(Workplace_Data.size());

		if (pstmt != null) pstmt.close();
		if (rs != null)   rs.close();
		  ConnectionManager.returnConnection(conn,request);
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='frm_workplace_list' id='frm_workplace_list' action='../../servlet/eRS.ShiftForWorkplaceServlet' method='POST' target='messageFrame' >
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<tr>
			<th  width='30%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th  width='60%'><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></th>
			<th  width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' onclick='click_selectall();'</th>
		</tr>
<%
		String select = "";
		String curr_locn = "";
		String classValue="";

		for(int i=0,j=0;i<Workplace_Data.size();i++,j++){
			record=(String[])Workplace_Data.get(i);
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			  else
				classValue = "QRYODD" ;
			if(!(curr_locn.equals((String)record[0]))){
%>
				<tr><td class='<%=classValue%>' width='30%' align='left'><b><%=record[1]%></b></td>
<%
				curr_locn=(String)record[0];
			}
			else{
				curr_locn=(String)record[0];
%>
				<tr><td class='<%=classValue%>' width='30%' align='left'>&nbsp;</td>
<%
			}
%>
			<td class='<%=classValue%>' align='left' width='60%'><%=record[3]%></td>
<%
			if((record[4].equalsIgnoreCase("U"))&&(record[5].equals("E")))
					select="checked";
				else
					select="";
%>
			<td class='<%=classValue%>' align='center'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='' <%=select%> onclick='click_select(this);'>
			</td>
			</tr>
			<input type='hidden' name='locn_type<%=i%>' id='locn_type<%=i%>' value='<%= record[0] %>'>
			<input type='hidden' name='workplace_code<%=i%>' id='workplace_code<%=i%>' value='<%=record[2] %>'>
			<input type='hidden' name='db_action<%=i%>' id='db_action<%=i%>' value='<%=record[4]%>' ></td>
<%	
		}
%>
		</table>
<%
	}catch(Exception e){
		out.println(e.getMessage());
		e.printStackTrace();
	}
%>
<input type='hidden' name='mode' id='mode' value='<%= mode %>'>	
<input type='hidden' name='facility_id' id='facility_id' value='<%= facility_id %>'>
<input type='hidden' name='shift_code' id='shift_code' value='<%= shift_code %>'>
<input type='hidden' name='totalRecords' id='totalRecords' value='<%= totalRecords %>'>
<input type='hidden' name='shift_mnemonic' id='shift_mnemonic' value='<%= shift_mnemonic %>' >
<input type='hidden' name='formName' id='formName' value='frm_workplace_list'>
</form>
</body>
</html>

