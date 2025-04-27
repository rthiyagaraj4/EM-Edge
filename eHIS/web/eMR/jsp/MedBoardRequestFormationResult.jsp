<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="MedBoardReqFormBean" class="webbeans.eCommon.RecordSet" scope='session'/>
<%	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String facility_id = (String)session.getValue( "facility_id" );
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../js/MedBoardRequestMain.js" language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<!-- <script src="../../eMR/js/MedBoardRequestButtons.js" language='javascript'></script> -->
<script language='javascript' src="../../eMR/js/MedBoardReqButtons.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	function assignValue()
	{
		parent.MedBoardRequestFormationMain.document.forms[0].RecordTime.value='Y';
	}
</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String formation_status = checkForNull(request.getParameter("formation_status"));
	String medical_board	= checkForNull(request.getParameter("medical_board"));
	String appt_date		= checkForNull(request.getParameter("appt_date"));
	String user_type		= checkForNull(request.getParameter("user_type"));
	String user				= checkForNull(request.getParameter("user"));
	String role				= checkForNull(request.getParameter("role"));
	String pract_id			= checkForNull(request.getParameter("pract_id"));
	String practid_desc		= checkForNull(request.getParameter("practid_desc"));
	String request_id		= checkForNull(request.getParameter("request_id"));
	String check_value		= checkForNull(request.getParameter("check_value"));
	String mode				= checkForNull(request.getParameter("mode"));
	String RecordTime		= checkForNull(request.getParameter("RecordTime"));
		if(RecordTime.equals("")) RecordTime = "N";
	String queryFire_yn		= checkForNull(request.getParameter("queryFire_yn"));
		if(queryFire_yn == null || queryFire_yn.equals("")) queryFire_yn = "Y";

	String appendStr			= "";
	String record				= "";
	String modify_record		= "";
	String check				= "";
	String chk_value			= "";
	String classValue			= "";
	String mod_pract_id			= "";
	String mod_request_id		= "";
	String role1				= "";
	String pract_id1			= "";
	String request_id1			= "";
	String practitioner_name	= "";
	String practitioner_id		= "";
	String medical_board_code	= "";
	String new_role				= "";
	String user_code			= "";
	String pract_type_code		= "";
	String appt_dt				= "";
	String table_values			= "";

	int rec_count =0; 
	int rec_count1 =0; 
	int cnt = 0;
	int role_cnt =0;

	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;

	String Sql = "";
//out.println("<script>alert('queryFire_yn : "+queryFire_yn+" || RecordTime : "+RecordTime+"')</script>");

try
{
	if(queryFire_yn.equals("Y") && RecordTime.equals("N"))
	{
		con = ConnectionManager.getConnection(request);

		//Sql = " SELECT a.PRACT_TYPE, a.USER_PRACT_YN, TO_CHAR (c.appt_date, 'dd/mm/yyyy') appt_date, DECODE (a.pract_type,'I', 'Internal','E', 'External') pract_type_desc, DECODE (a.user_pract_yn, 'U', 'User', 'P', 'Practitioner') user_desc,(CASE WHEN a.pract_type = 'I' AND a.user_pract_yn = 'U' THEN (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID = A.PRACTITIONER_ID) WHEN a.pract_type = 'I' AND a.user_pract_yn = 'P' THEN (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = A.PRACTITIONER_ID) WHEN a.pract_type = 'E' AND a.user_pract_yn = 'P' THEN (SELECT PRACTITIONER_NAME FROM AM_EXT_PRACTITIONER WHERE PRACTITIONER_ID = A.PRACTITIONER_ID) END ) PRACTITIONER_NAME,a.practitioner_id, a.medical_board_code, a.request_id, a.ROLE, a.srl_no, a.user_pract_yn user_code, a.pract_type pract_type_code FROM MR_MED_BOARD_MEMBER a, MR_REPORT_REQUEST_HDR c WHERE a.facility_id = '"+facility_id+"' AND a.request_id = '"+request_id+"' AND A.FACILITY_ID = C.FACILITY_ID AND a.request_id = c.request_id ";

		Sql = " SELECT a.prAct_Type, a.User_prAct_yn, To_char(c.appt_Date,'dd/mm/yyyy') appt_Date, DECODE(a.prAct_Type,'I','Internal','E','External') prAct_Type_desc, DECODE(a.User_prAct_yn,'U','User','P','Practitioner') User_desc, (CASE WHEN a.prAct_Type = 'I' AND a.User_prAct_yn = 'U' THEN sm_get_desc.SM_APPL_USER(a.Practitioner_Id,'"+locale+"','1') WHEN a.prAct_Type = 'I' AND a.User_prAct_yn = 'P' THEN am_get_desc.AM_PRACTITIONER(a.Practitioner_Id,'"+locale+"','1') WHEN a.prAct_Type = 'E' AND a.User_prAct_yn = 'P' THEN am_get_desc.AM_EXT_PRACTITIONER(a.Practitioner_Id,'"+locale+"','1') END) Practitioner_Name, a.Practitioner_Id, a.Medical_Board_Code, a.Request_Id, a.ROLE, a.srl_No, a.User_prAct_yn User_Code, a.prAct_Type prAct_Type_Code FROM   MR_MED_BOARD_MEMBER a, MR_REPORT_REQUEST_HDR c WHERE  a.Facility_Id = '"+facility_id+"' AND a.Request_Id = '"+request_id+"' AND a.Facility_Id = c.Facility_Id AND a.Request_Id = c.Request_Id ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(Sql);

		if(rs != null && rs.next())
		{
			MedBoardReqFormBean.clearAll();
		}
		if(rs != null) rs.close();		
		
		rs	=	stmt.executeQuery(Sql);
		if(rs != null)
		{
			while(rs.next())
			{
				practitioner_name	= checkForNull(rs.getString("practitioner_name"));
				practitioner_id		= checkForNull(rs.getString("practitioner_id"));
				medical_board_code	= checkForNull(rs.getString("medical_board_code"));
				new_role			= checkForNull(rs.getString("role"));
				user_code			= checkForNull(rs.getString("user_code"));
				pract_type_code		= checkForNull(rs.getString("pract_type_code"));
				appt_dt				= checkForNull(rs.getString("appt_date")," ");
				table_values		= pract_type_code+"~"+user_code+"~"+practitioner_id+"~"+practitioner_name+"~"+new_role+"~"+"Checked~"+appt_dt+"~"+request_id+"~"+medical_board_code;

				MedBoardReqFormBean.putObject(table_values);
				out.println("<script>setTimeout('assignValue()',1000);</script>");
			}
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}
}catch (Exception Ex)
{
	//out.println("Exception in query : "+Ex.toString());
	Ex.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

try
{
	if(mode.equals("insert"))
	{
		int k=0,incr =0;
		if(!check_value.equals(""))
		{
			StringTokenizer chk_val_split = new StringTokenizer(check_value,"~");
			while(chk_val_split.hasMoreTokens())
			{
				mod_pract_id = chk_val_split.nextToken();
				mod_request_id = chk_val_split.nextToken();
			}
		}

		rec_count1 = MedBoardReqFormBean.getSize();		

		if(	rec_count1 > 0 )
		{
			for(k=0;k<rec_count1;k++)
			{
				modify_record = (String)MedBoardReqFormBean.getObject(k);
				StringTokenizer mod_split_rec = new StringTokenizer(modify_record,"~");
				while(mod_split_rec.hasMoreTokens())
				{		
					mod_split_rec.nextToken();
					mod_split_rec.nextToken();
					pract_id1 = mod_split_rec.nextToken();
					mod_split_rec.nextToken();
					role1 = mod_split_rec.nextToken();
					check = mod_split_rec.nextToken();
					mod_split_rec.nextToken();
					request_id1 = mod_split_rec.nextToken();
					mod_split_rec.nextToken();

					if(	pract_id.equals(pract_id1) && request_id.equals(request_id1))
						incr++;

					if(role1.equals("C") && role.equals("C"))
						role_cnt++;
				}
			}

			if(incr>0)
			{
				out.println("<script>alert(getMessage('RECORD_ALREADY_EXISTS','SM'))</script>");
			}
			else if(role_cnt ==1)
			{
				out.println("<script>alert(getMessage('CONT_MRTHN_ONE_CHIEF','MR'))</script>");
			}
			else
			{
				appendStr = user_type+"~"+user+"~"+pract_id+"~"+practid_desc+"~"+role+"~"+"Checked~"+appt_date+"~"+request_id+"~"+medical_board;
				MedBoardReqFormBean.putObject(appendStr);
			}
		}
		else if(rec_count1 == 0)
		{
			appendStr = user_type+"~"+user+"~"+pract_id+"~"+practid_desc+"~"+role+"~"+"Checked~"+appt_date+"~"+request_id+"~"+medical_board;
			MedBoardReqFormBean.putObject(appendStr);
		}
	}
	else if(mode.equals("modify"))
	{
		int k=0,incr =0;
		StringTokenizer chk_val_split = new StringTokenizer(check_value,"~");
		while(chk_val_split.hasMoreTokens())
		{
			mod_pract_id = chk_val_split.nextToken();
			mod_request_id = chk_val_split.nextToken();
		}

		rec_count1 = MedBoardReqFormBean.getSize();		
		if(	rec_count1 > 0 )
		{
			for(k=0;k<rec_count1;k++)
			{
				modify_record = (String)MedBoardReqFormBean.getObject(k);
				StringTokenizer mod_split_rec = new StringTokenizer(modify_record,"~");
				while(mod_split_rec.hasMoreTokens())
				{		
					user_type = mod_split_rec.nextToken();
					user = mod_split_rec.nextToken();
					pract_id = mod_split_rec.nextToken();
					practid_desc = mod_split_rec.nextToken();
					role = mod_split_rec.nextToken();
					check = mod_split_rec.nextToken();
					appt_date = mod_split_rec.nextToken();
					request_id = mod_split_rec.nextToken();
					medical_board = mod_split_rec.nextToken();

					if(	pract_id.equals(mod_pract_id) && request_id.equals(mod_request_id))
					{
						check="unChecked";
						incr = k;
						k= rec_count1;
					}
					appendStr = user_type+"~"+user+"~"+pract_id+"~"+practid_desc+"~"+role+"~"+check+"~"+appt_date+"~"+request_id+"~"+medical_board;
				}
			}
			MedBoardReqFormBean.setObject(incr,appendStr);
			
			/// New logic to remove value from bean if chk box is unchecked
			if(	pract_id.equals(mod_pract_id) && request_id.equals(mod_request_id))
			{
				if((MedBoardReqFormBean.containsObject(appendStr)))
				{
					int removeCodeIndex = MedBoardReqFormBean.indexOfObject(appendStr);
						MedBoardReqFormBean.removeObject(removeCodeIndex);
				}
			}

		}
	}
	%>	
	<body onScroll='scrollTitle()' onKeyDown='lockKey()'>
	<form name='MedBoardReqFormResult' id='MedBoardReqFormResult' action='../../servlet/eMR.MedBoardFormationServlet' method='get' target='messageFrame'>
	<div id='divDataTitle' style='postion:relative'>
		<table border=1 cellspacing=0 cellpadding=0 id='dataTitleTable' width='100%'>
			<tr>
				<th width='30%'><fmt:message key="eMR.MemberType.label" bundle="${mr_labels}"/></th>
				<th width='40%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
				<th width='15%'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>
				<th width='15%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
			</tr>
		</table>
	</div>
	<table border='1' width='100%' id='dataTable' cellpadding='0' cellspacing='0' align='center' style="border-bottom:#ffffff">
	<%

	//ArrayList record = MedBoardReqFormBean.getAllRecord();
	rec_count = MedBoardReqFormBean.getSize();
	//MedBoardReqFormBean.clearAll();
	if(	rec_count > 0 )
	{
		for(int j=0;j<rec_count;j++)
		{
			if(cnt%2 == 0)
				classValue = "QRYEVEN";
			else
				classValue = "QRYODD";

			record = (String)MedBoardReqFormBean.getObject(j);
//			out.println("getObject "+record);
//			out.println("<br>");

			StringTokenizer split_rec = new StringTokenizer(record,"~");
			while(split_rec.hasMoreTokens())
			{
				user_type = split_rec.nextToken();
				if(user_type.equals("I"))
					user_type = "Internal";
				else if(user_type.equals("E"))
					user_type = "External";

				user = split_rec.nextToken();
				if(user.equals("U"))
					user = "User";
				else if(user.equals("P"))
					user = "Practitioner";

				pract_id = split_rec.nextToken();
				practid_desc = split_rec.nextToken();
				role = split_rec.nextToken();
				if(role.equals("C"))
					role = "Chief";
				else if(role.equals("M"))
					role = "Member";

				check = split_rec.nextToken();
				appt_date = split_rec.nextToken();
				request_id = split_rec.nextToken();
				medical_board = split_rec.nextToken();

				chk_value = pract_id+"~"+request_id;
			}
			out.println("<tr>");
				out.println("<td width='30%' align='left' class='"+classValue+"'>"+user_type+" / "+user+"</td>");
				out.println("<td align='left' class='"+classValue+"'>"+practid_desc+"</td>");
				out.println("<td align='left' class='"+classValue+"'>"+role+"</td>");
				out.println("<td align='center' class='"+classValue+"'><input type='checkbox' name='check_"+cnt+"' id='check_"+cnt+"' value='"+chk_value+"'  "+check+"  Onclick='uncheckval(this)'><input type='hidden' name='pract_"+cnt+"' id='pract_"+cnt+"' value='"+user+"'><input type='hidden' name='role_"+cnt+"' id='role_"+cnt+"' value='"+role+"'></input><input type='hidden' name='user_type_"+cnt+"' id='user_type_"+cnt+"' value='"+user_type+"'></input></td>");
			out.println("</tr>");
			cnt++;
		}
	}

	%>		
			<TR style='visibility:hidden'>
				<th width='30%'><fmt:message key="eMR.MemberType.label" bundle="${mr_labels}"/></th>
				<th><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
			</tr>	
		</table>
	</div>
	<input type='hidden' name='call_function' id='call_function' value='MEDICAL_BOARD_FORMATION'>
	<input type='hidden' name='count' id='count' value='<%=cnt%>'>
	<input type='hidden' name='request_id' id='request_id' value='<%=request_id%>'>
	<input type='hidden' name='formation_status' id='formation_status' value='<%=formation_status%>'>
<%

}catch(Exception e)
{
	//out.println("Exception @ MedBoardRequestFormationResult "+e.toString());
	e.printStackTrace();
}
%>	
</form>
</body>	
</html>

<script>alignWidth();</script>

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

