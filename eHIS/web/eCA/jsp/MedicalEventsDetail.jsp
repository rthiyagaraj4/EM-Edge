<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/dchk.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCA/js/MedicalEvents.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='MajorEventsAddModify' id='MajorEventsAddModify' method='post' action='../../servlet/eCA.MajorMedicalEventsServlet' target='messageFrame'>
<div align='left'>
<table border=0 cellspacing=0 cellpadding=3 align=center width='80%'>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	
	String	mode					=	"";
	String	patient_id				=	"";
	String  med_event_type_code		=	"";	
	String  event_sdate				=	"";
	String	event_edate				=	"";
	String  event_psdate			=	"";
	String	event_pedate			=	"";

	String	event_details			=	"";
	String	event_confirmed_flag	=	"";
	String	event_confirmed_checked	=	"";
	String	dob						=	"";
	String	display_prop			=	"";
	String	disable_prop			=	"";
	String	sys_date				=	"";
	String	tmp_med_event_type_code	=	"";
	String	tmp_med_event_type_desc	=	"";
	String	selected_prop			=	"";
	String	query_mr_med_event_type	=	"";
	StringBuffer	query_sys_date			=	new StringBuffer();
	StringBuffer	query_mr_med_event_log	=	new StringBuffer();
	

	int		log_count				=	0;

	try
	{

		con						=	ConnectionManager.getConnection(request);

		patient_id				=	checkForNull(request.getParameter("patient_id"));
		med_event_type_code		=	checkForNull(request.getParameter("med_event_type_code"));
		event_sdate				=	checkForNull(request.getParameter("event_sdate"));

		event_psdate			=	event_sdate;

		if(!event_psdate.equals("&nbsp;") )
			event_psdate	= com.ehis.util.DateUtils.convertDate(event_psdate,"DMY","en",locale);

		/*query_sys_date			=	" select to_char(date_of_birth,'dd/mm/yyyy') dob, "+
									" to_char(sysdate,'dd/mm/yyyy') sys_date "+
									" from mp_patient where patient_id = ? ";*/
		if(query_sys_date.length() > 0) query_sys_date.delete(0,query_sys_date.length());

		query_sys_date.append(" select to_char(date_of_birth,'dd/mm/yyyy') dob ");
		query_sys_date.append(" from mp_patient where patient_id = ? ");

		pstmt					=	con.prepareStatement(query_sys_date.toString());
		pstmt.setString	(1,	patient_id	);
		rs						=	pstmt.executeQuery();
		
		if(rs.next())
			dob					=	rs.getString("dob");
		
		sys_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		dob				= com.ehis.util.DateUtils.convertDate(dob,"DMY","en",locale);

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		if(med_event_type_code.equals(""))		mode = "insert";
		else
		{
			mode					=	"modify";
			if(query_mr_med_event_log.length() > 0) query_mr_med_event_log.delete(0,query_mr_med_event_log.length());
			query_mr_med_event_log.append(" select to_char(event_edate,'dd/mm/yyyy') event_edate1, ");
			query_mr_med_event_log.append(" event_details, event_confirmed_flag ");
			query_mr_med_event_log.append(" from mr_med_event_log");
			query_mr_med_event_log.append(" where patient_id = ? and  med_event_type_code= ? ");
			query_mr_med_event_log.append(" and to_char(event_sdate,'dd/mm/yyyy') = ?  "); 

			pstmt					=	con.prepareStatement(query_mr_med_event_log.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			pstmt.setString	(	1,	patient_id			);
			pstmt.setString	(	2,	med_event_type_code	);
			pstmt.setString	(	3,	event_sdate			);

			rs						=	pstmt.executeQuery();

			rs.last();

			log_count	=	rs.getRow();
			//out.println("<script>alert('log_count="+log_count+"')</script>");
			if (log_count==0)	mode		=	"insert";
			else				mode		=	"modify";

			rs.beforeFirst();

			while(rs.next())
			{
				event_edate				=	checkForNull(rs.getString("event_edate1"));
				event_details			=	checkForNull(rs.getString("event_details"));
				event_confirmed_flag	=	checkForNull(rs.getString("event_confirmed_flag"));

				if(event_confirmed_flag.equals("Y"))
				{
					event_confirmed_checked	=	" CHECKED ";
					disable_prop			=	" DISABLED ";
				}

				event_pedate			=	event_edate;

				if(!event_pedate.equals("&nbsp;") )
					event_pedate	= com.ehis.util.DateUtils.convertDate(event_pedate,"DMY","en",locale);

			}
		}
		
			if(mode.equals("modify"))	display_prop	=	"readOnly";

	%>

		<tr>
		<td  class=label width='40%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
	<%
		if(display_prop.equals("readOnly"))
		{
			
			out.println("<td class='fields' width='60%' ><input type='text' name=\"med_event_type_code\" id=\"med_event_type_code\" value=\""+med_event_type_code+"\"  readonly>");
		}
		else
		{
	%>
			<td class='fields' width='60%' ><select name="med_event_type_code" id="med_event_type_code">
			<option value="">------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
	<%
			try
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				//query_mr_med_event_type	=	"Select med_event_type_code, short_desc from mr_med_event_type  where eff_status='E' order by 2";

				query_mr_med_event_type = "Select med_event_type_code, short_desc from mr_med_event_type_LANG_VW  a where a.eff_status='E' AND LANGUAGE_ID = ? order by 2 ";

				pstmt					=	con.prepareStatement(query_mr_med_event_type);
				pstmt.setString	( 1, locale );
				rs						=	pstmt.executeQuery();
				while(rs.next())
				{
					tmp_med_event_type_code	=	rs.getString(1);
					tmp_med_event_type_desc	=	rs.getString(2);

					if(tmp_med_event_type_code.equals(med_event_type_code))
						selected_prop		=	"selected";
					else
						selected_prop		=	"";
			%>
				<option value="<%=tmp_med_event_type_code%>" <%=selected_prop%>> <%=tmp_med_event_type_desc%></option>
			<%
				}
				if(rs!=null) rs.close();
				if(pstmt!=null)	pstmt.close();
			}
			catch( Exception e)
			{
				//out.println("Exception@1: "+e.toString());//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			
	%>
			</select>
	<%
		}
	%>	
		<img src="../../eCommon/images/mandatory.gif" align='center'></td>
			
		</tr>
		<tr>
			<td class=label  width='40%'><fmt:message key="Common.EventStartDate.label" bundle="${common_labels}"/></td>
			<td class='fields' width='60%'><input type="text" name="event_sdate" id="event_sdate" value="<%=event_psdate%>" size=10 maxlength=10 onblur='CheckStartDate(this)' <%=display_prop%> ><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('event_sdate');" <%=disable_prop%>><img src="../../eCommon/images/mandatory.gif" > </td>
				
			
		</tr>
		<tr>
			
			<td class=label width='40%'><fmt:message key="Common.EventEndDate.label" bundle="${common_labels}"/></td>
			<td class='fields' width='60%'><input type="text" name="event_edate" id="event_edate" value="<%=event_pedate%>" size=10 maxlength=10 onblur='CheckEndDate(this)'><%if((!event_edate.equals(""))&& disable_prop.equals("disabled")){out.println("readonly");}else{%><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('event_edate');" ><%}%>
			</td>
				
			
		</tr>
		<tr>
			
			<td class=label width='40%'><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></td>
			<td class='fields' width='60%'><textarea name="event_details" rows="3" cols="50" maxlength='2000' onkeyPress='checkMaxLimit(this,2000)'  onBlur="return makeValidString(this);checkMaxLimit(this,2000)" <%if(disable_prop.equals("disabled"))out.println("readonly");%>><%=event_details%></textarea><img src="../../eCommon/images/mandatory.gif"  ></td>
				
			
		</tr>
		<tr>
			
			<td class=label width='40%'><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/></td>
			<td class='fields' width='60%'><input type="checkbox" name="event_confirmed_flag" id="event_confirmed_flag" value='Y' <%=disable_prop%>  <%=event_confirmed_checked%> ></td>
				
			
		</tr>
		<tr>
			<td align='left' class='white'>
			<td  class='white' align=right><input type="button" class=button name="Record" id="Record" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="apply()">&nbsp;<input type="button" class=button name="Clear" id="Clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onclick="clearme()">&nbsp;<input type="button" class=button name=Cancel value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onclick="cancelOperation()"></td>
		</tr>
<%	
		
	}
	catch(Exception e)
	{
		out.println(" Exception @ MedicalEventsDetail " +e.toString());
	}
	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
<%!
	public String checkForNull(String inputString)
	{
		return ((inputString==null)? "" : inputString);
	}

%>
</table>
<input type='hidden' name='mode' id='mode'		value="<%=mode%>">
<input type='hidden' name='sys_date' id='sys_date'	value="<%=sys_date%>" >
<input type='hidden' name='patient_id' id='patient_id'	value="<%=patient_id%>" >
<input type='hidden' name='called_from' id='called_from'	value="CA">
<input type='hidden' name='dob' id='dob'			value="<%=dob%>" >
<input type='hidden' name='med_event_type_code1' id='med_event_type_code1' value="<%=med_event_type_code%>" >
<input type='hidden' name='confirmed' id='confirmed'  >
</form>
</body>
</html>

<%if(mode.equals("modify")){ %>
		<script language=javascript>
				top.content.messageFrame.location.href= "../../eCommon/jsp/error.jsp";
		</script>
<% } %>

