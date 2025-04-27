<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!--,oracle.jdbc.driver.*-->
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<Script src="../../eMR/js/CreatePatientFile.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eMR/js/MajorMedicalEvents.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script>
function cancelthis()
{
		parent.parent.frames[1].document.location.href='../../eMR/jsp/mrblank.jsp?step_1=8';
		parent.parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp';
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onload='FocusFirstElement();aa()' onKeyDown = 'lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn=null;
	Statement stmt=null;
	ResultSet rset=null;
	Statement stmt2=null;
	ResultSet rset1=null;
	PreparedStatement pstmt=null;
	int startDays=0,startMonths=0,startYears=0;
	int endDays=0,endMonths=0,endYears=0;
	String mode="";String long_desc="";
try
{
	conn=ConnectionManager.getConnection(request);
	String PatId=request.getParameter("Patient_Id");
	long_desc=request.getParameter("long_desc");
		if(long_desc == null) long_desc="";
	String  med_event_type_code=request.getParameter("med_event_type_code");
	String  event_sdate=request.getParameter("event_sdate");
	String event_sdate_converted="";
	String locale=(String)session.getAttribute("LOCALE"); 
	if(event_sdate==null) event_sdate="";
	
	if(!(event_sdate==null || event_sdate.equals("")))
		event_sdate_converted = DateUtils.convertDate(event_sdate,"DMY","en",locale);

	String event_edate="";
	String event_edate_converted="";
	String event_details="";
	String event_confirmed_flag="";
	String event_confirmed_checked="";
	String dob="";
	String dis_code="";
	String dis_code1="";
	String dis_confirmed="";
	String cur_date="";
	
	String sql_dob="Select to_char (trunc(sysdate),'dd/mm/yyyy') cur_date, to_char(date_of_birth,'dd/mm/yyyy') dob from mp_patient where patient_id='"+PatId+"' ";
		Statement stmt_dob=conn.createStatement();
		ResultSet rs_dob=stmt_dob.executeQuery(sql_dob);
		if(rs_dob!=null)
		{
			while(rs_dob.next())
			{
				cur_date=rs_dob.getString("cur_date");
				dob=rs_dob.getString("dob");
			}
		}
		if(stmt_dob!=null) stmt_dob.close();
		if(rs_dob!=null) rs_dob.close();

	  if(med_event_type_code==null) 
	  {
		  med_event_type_code="";
		  mode="insert";
	  }
	  else
	  {
			mode="modify";
	     	if(rset!=null)     	rset.close();
			if(pstmt!=null)   	stmt.close();
			
			String count="";
			int numOfRecord;
			
			String sql = "select to_char(event_edate,'dd/mm/yyyy') event_edate1,event_details, event_confirmed_flag from mr_med_event_log  where patient_id='"+PatId+"' and  med_event_type_code= '"+med_event_type_code+"' and to_char(event_sdate,'dd/mm/yyyy')='"+event_sdate+"' "; 
	  		
			pstmt = conn.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rset = pstmt.executeQuery();
			if(rset!=null)
			{
				rset.last();
				numOfRecord=rset.getRow();
				rset.beforeFirst();
				count=Integer.toString(numOfRecord);
			}

			if (count.equals("0"))
			{
				mode = "insert";
			}
			else
			{
				mode = "modify";
				if(rset!=null)
				{
					while(rset.next())
					{
						event_edate=rset.getString("event_edate1");
						if(event_edate==null) event_edate="";

						if(!(event_edate==null || event_edate.equals("")))
							event_edate_converted = DateUtils.convertDate(event_edate,"DMY","en",locale);
						
						String sqldb="select calculate_age('"+event_edate+"',1),calculate_age('"+event_edate+"',2),calculate_age('"+event_edate+"',3),calculate_age('"+event_sdate+"',1),calculate_age('"+event_sdate+"',2),calculate_age('"+event_sdate+"',3) from dual";
						stmt2= conn.createStatement();
						rset1=stmt2.executeQuery(sqldb);
						rset1.next();
						endYears =rset1.getInt(1);
						endMonths=rset1.getInt(2);
						endDays=rset1.getInt(3);
						
						startYears=rset1.getInt(4);
						startMonths=rset1.getInt(5);
						startDays=rset1.getInt(6);
						
						if(rset1!=null) rset1.close();
						if(stmt2!=null) stmt2.close();

						event_details=rset.getString("event_details");
						if(event_details==null) event_details="";

						event_confirmed_flag=rset.getString("event_confirmed_flag");
						if(event_confirmed_flag==null) event_confirmed_flag="N";

						if(event_confirmed_flag.equals("Y"))
						{
							event_confirmed_checked="checked";
							dis_confirmed="disabled";
						}
						else 
							if(event_confirmed_flag.equals("N")) 
								event_confirmed_checked="";
					}
			  }
		}
	 }
	if(mode.equals("modify"))
	{ dis_code="readonly"; dis_code1="disabled";}
%>
 
      	<form name='MajorEventsAddModify' id='MajorEventsAddModify' method='post' action='../../servlet/eMR.MajorMedicalEventsServlet' target='messageFrame'>
      	<div align='left'>
      	<table border='0' cellspacing=0 cellpadding='3' align=center width='100%'>
		<tr>
			<td colspan=4>&nbsp;</td>
		</tr>
      	<tr>
      		<td width='25%' class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
      		<td width='25%' class='fields'>
<%if(dis_code.equals("readonly")) { 
		out.println("<input type='text' name=\"med_event_type_desc\" id=\"med_event_type_desc\" value=\""+long_desc+"\"  size='30' readonly>");out.println("<input type='hidden' name=\"med_event_type_code\" id=\"med_event_type_code\" value=\""+med_event_type_code+"\"  readonly>");}else{%><select name="med_event_type_code" id="med_event_type_code">
				<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
			<%
			Statement stmt_resp=null;
		ResultSet rs_resp=null;
			try{
							//String sql_resp="Select med_event_type_code, short_desc from mr_med_event_type  where eff_status='E' order by 2";

							String sql_resp = "Select med_event_type_code, short_desc from MR_MED_EVENT_TYPE_LANG_VW  where eff_status='E' AND language_id='"+locale+"' order by 2";

							String id = "";
							String dat = "";
							String sel = "";
							stmt_resp=conn.createStatement();
							rs_resp=stmt_resp.executeQuery(sql_resp);
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
									if(id.equals(med_event_type_code))
										sel="selected";
									out.println("<option value='"+id+"'"+sel+">"+dat+"</option>");
									sel = "";
								}
							}
						}
						catch( Exception e){/* out.println(e); */e.printStackTrace();}
						finally
						{
							try
								{
							if(stmt_resp!=null) stmt_resp.close();
							if(rs_resp!=null) rs_resp.close();
								}
								catch( Exception e){}
						}
			
			%></select><%}%><img src="../../eCommon/images/mandatory.gif"></td>
      	<td class='label' width='25%'></td>	
		<td class='label' width='25%'></td>	
		
      	</tr>
      	<tr>
			<td class='label' ><fmt:message key="Common.since.label" bundle="${common_labels}"/></td>
      		<td class='fields'><input type='text' name='entered_start' id='entered_start'  size='2' maxlength='2'  onChange='defaultValuePop("start")'  onKeyPress='return(ChkNumberInput(this,event,0))' <%=dis_confirmed%> <%=dis_code1%> ><select name='start_select' id='start_select' onChange='calFromDate(this,event_sdate,entered_start)' <%=dis_confirmed%> <%=dis_code1%>><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/><option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/><option value= 'Y'><fmt:message key="Common.year.label" bundle="${common_labels}"/></select></td>
			<td class='label'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<!-- START MODIFICATION BY ARUN   -->
			
<td class='fields'>		
<input type='text' name='event_sdate' id='event_sdate' size='10' onBlur='CheckStartDate(this)'  value=`<%=event_sdate_converted%>`  maxLength='10'   <%=dis_code%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('event_sdate',null,null,'modal');" <%=dis_code1%>/><img src="../../eCommon/images/mandatory.gif"> </td>



				<!-- END MODIFICATION BY ARUN -->
      	</tr>
      	<tr>
      		<td class='label' ><fmt:message key="Common.till.label" bundle="${common_labels}"/></td>
      		<td class='fields'><input type='text' name='entered_to' id='entered_to' size='2' onChange ='defaultValuePop("end")' onKeyPress='return(ChkNumberInput(this,event,0))' maxlength='2'><select name='end_select' id='end_select' onChange='calToDate(this,event_edate,entered_to,event_sdate)' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---<option value='D'><fmt:message key="Common.days.label" bundle="${common_labels}"/><option value='M'><fmt:message key="Common.months.label" bundle="${common_labels}"/><option value='Y'><fmt:message key="Common.year.label" bundle="${common_labels}"/></select></td>
			<td class='label'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
			
			
		<td class='fields'>
		<input type='text' name='event_edate' id='event_edate' size='10' onBlur='CheckEndDate(this);' maxLength='10' value=`<%=event_edate_converted%>`   <%if(dis_confirmed.equals("disabled")) out.println("readonly");%>  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('event_edate',null,null,'modal');" <%if(dis_confirmed.equals("disabled")) out.println("disabled");%>/> </td>
		
      		
      	</tr>
      	<tr>
      		<td class=label ><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></td>
      		<td class='fields' colspan='3'><textarea name="event_details" rows="3" cols="60" onBlur='makeValidString(this);chkMaxLen(this)' onkeyPress='checkMaxLimit(this,2000)' <%if(dis_confirmed.equals("disabled"))out.println("readonly");%>><%=event_details%></textarea><img src="../../eCommon/images/mandatory.gif"></td>	
      	</tr>
      	<tr>
      		<td class=label ><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/></td>
      		<td class='fields' colspan='3'><input type="checkbox" name="event_confirmed_flag" id="event_confirmed_flag" value='Y' <%=dis_confirmed%>  <%=event_confirmed_checked%> ></td>
      		
      	</tr>
      	<tr>
				<td colspan=3 class=label></td>
				<td colspan=1 class=button><input type="button" class=button name="Record" id="Record" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="apply()"><input type="button" class=button name="Clear" id="Clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onclick="clearme()"><input type="button" class=button name=Cancel value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="cancelthis()"></td>
				 
		</tr>
      	</table>
		<input type=hidden name=mode value='<%=mode%>'>
		<input type='hidden' name='cur_date' id='cur_date' value='<%=cur_date%>' >
		<input type='hidden' name='patient_id' id='patient_id' value='<%=PatId%>' >
		<input type='hidden' name='dob' id='dob' value='<%=dob%>' >
		<input type='hidden' name='med_event_type_code1' id='med_event_type_code1' value='<%=med_event_type_code%>' >
		<input type='hidden' name='confirmed' id='confirmed'  >
		<input type='hidden' name='sStyle' id='sStyle' value='<%=sStyle%>' >


<%
	if(startYears >0)
		out.println("<script>document.forms[0].entered_start.value='"+startYears+"';document.forms[0].entered_start.readOnly=true;document.forms[0].start_select.value='Y';document.forms[0].start_select.disabled=true;</script>");
	else if(startYears == 0 && startMonths >0)
		out.println("<script>document.forms[0].entered_start.value='"+startMonths+"';document.forms[0].entered_start.readOnly=true;document.forms[0].start_select.value='M';document.forms[0].start_select.disabled=true;</script>");
	else if(startYears == 0 && startMonths ==0 && startDays >0)
		out.println("<script>document.forms[0].entered_start.value='"+startDays+"';document.forms[0].entered_start.readOnly=true;document.forms[0].start_select.value='D';document.forms[0].start_select.disabled=true;</script>");

	if(endYears >0)
		out.println("<script>document.forms[0].entered_to.value='"+endYears+"';document.forms[0].end_select.value='Y';</script>");
	else if(endYears == 0 && endMonths >0)
		out.println("<script>document.forms[0].entered_to.value='"+endMonths+"';document.forms[0].end_select.value='M';</script>");
	else if(endYears == 0 && endMonths ==0 && endDays >0)
		out.println("<script>document.forms[0].entered_to.value='"+endDays+"';document.forms[0].end_select.value='D';</script>");
	
	if(event_confirmed_flag.equals("Y"))
		out.println("<script>document.forms[0].end_select.disabled=true;document.forms[0].entered_to.readOnly=true;document.forms[0].end_select.checked=true</script>");
	

%>

      	</form>
      	</body>
      	</html>
<%
}
catch(Exception e)
{
	//out.println("Exception "+e.toString());
	e.printStackTrace();
}
 finally
{
	try
	{
		if(rset!=null)     	rset.close();
		if(stmt!=null)   	stmt.close();
		if(pstmt!=null)   	pstmt.close();
	}

	catch(Exception e)
	{
		//out.println("Exception @ finally"+e.toString());
		e.printStackTrace();
	}
		ConnectionManager.returnConnection(conn,request);
}
					
%>
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

