<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eOR.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
     <head>
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../js/ShiftForPosition.js' language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">	
<%
Connection conn = null;
PreparedStatement pstmt_shift = null;
PreparedStatement pstmt_shift_select = null;
ResultSet rs_shift = null;
ResultSet rs_shift_select = null;
try{
request.setCharacterEncoding("UTF-8");	
conn = ConnectionManager.getConnection(request);
String shift_indicator = "";
String appl_for_working_days = "";
String appl_for_nonworking_days = "";
String appl_for_holidays = "";
String shift_start_time = "";
String shift_end_time = "";

String durn_hh = "";
String durn_mm = "";
String start_hh = "";
String start_mm = "";
String end_hh = "";
String end_mm = "";

int hh = 0;
int mm = 0;

StringTokenizer ST = null;



ArrayList shift_list=new ArrayList();

	String qry_shift = "Select shift_code, short_desc shift_desc from am_shift where eff_status = 'E' order by shift_desc";
	String qry_shift_select = "select shift_code,shift_indicator,appl_for_working_days,appl_for_nonworking_days,appl_for_holidays,to_char(shift_start_time,'hh24:mi') shift_start_time,to_char(shift_end_time,'hh24:mi') shift_end_time from am_shift where shift_code = ?";

pstmt_shift_select = conn.prepareStatement(qry_shift_select);
pstmt_shift = conn.prepareStatement(qry_shift);

	rs_shift = pstmt_shift.executeQuery();
	while(rs_shift.next())
	{
		shift_list.add(rs_shift.getString("shift_code"));
		shift_list.add(rs_shift.getString("shift_desc"));
	}
	
	String shift_code = request.getParameter("shift_code")==null ? "":request.getParameter("shift_code");
	if(!shift_code.equals(""))
	{
		pstmt_shift_select.setString(1,shift_code);
		rs_shift_select = pstmt_shift_select.executeQuery();
		
		while(rs_shift_select.next())
		{
		
		shift_indicator = rs_shift_select.getString("shift_indicator");
		appl_for_working_days = rs_shift_select.getString("appl_for_working_days");
		appl_for_nonworking_days = rs_shift_select.getString("appl_for_nonworking_days");
		appl_for_holidays = rs_shift_select.getString("appl_for_holidays");
		shift_start_time = rs_shift_select.getString("shift_start_time");
		shift_end_time = rs_shift_select.getString("shift_end_time");
		ST = new StringTokenizer(shift_start_time,":");
		start_hh = ST.nextToken();
		start_mm = ST.nextToken();
		ST = new StringTokenizer(shift_end_time,":");
		end_hh = ST.nextToken();
		end_mm = ST.nextToken();

		hh = Math.abs(Integer.parseInt(end_hh) - Integer.parseInt(start_hh));
		mm = Math.abs(Integer.parseInt(end_mm) - Integer.parseInt(start_mm));
		if(hh < 10)
			durn_hh = "0" + hh;
		else
			durn_hh = String.valueOf(hh);

		if(mm < 10)
			durn_mm = "0" + mm;
		else
			durn_mm = String.valueOf(mm);


			if(shift_indicator.equals("P"))
				shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Productive.label","am_labels");
			else
			{
				if(shift_indicator.equals("U"))
					shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unproductive.label","common_labels");
				else
				{
					if(shift_indicator.equals("A"))
						shift_indicator = "Absence";
					else
						shift_indicator = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels");
				}
			}
			if(appl_for_working_days.equals("Y"))
				appl_for_working_days = "checked";
			if(appl_for_nonworking_days.equals("Y"))
				appl_for_nonworking_days = "checked";
			if(appl_for_holidays.equals("Y"))
				appl_for_holidays = "checked";
		}
	}

%>
<form name='frm_shift_by_shift' id='frm_shift_by_shift'>
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			
			<tr>
				<td colspan="3">&nbsp</td>
			</tr>
			<tr>
				<td class="label" width="25%"> <fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/> &nbsp;</td>
				<td class="fields" width="55%">
				<select name="shift_code" id="shift_code" onchange="selectShift(this)">
					<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
				//
				for(int i=0;i<shift_list.size();i+=2)
				{
				%>
					<option value='<%= shift_list.get(i) %>' <%=eHISFormatter.select(shift_code,(String)shift_list.get(i))%>> <%= shift_list.get(i+1) %> </option>
				<%
				}
				%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				<td width="20%"></td>
			</tr>
					<tr><td colspan="3">&nbsp</td></tr>
					<tr>
				<td class="label" width="25%"> <fmt:message key="Common.ShiftIndicator.label" bundle="${common_labels}"/> &nbsp</td>
				<td class="fields" width="55%">
				<input type=text name='shift_indicator' id='shift_indicator' readOnly value="<%= shift_indicator %>">
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<label class='label' id='show_shift_radio'></label>	
				</td>
				<td width="20%"></td>
			</tr>
			<tr><td colspan="3">&nbsp</td></tr>
			<tr>
				<td class="label" width="25%"> <fmt:message key="Common.Applicability.label" bundle="${common_labels}"/> &nbsp</td>
				<td class="fields" width="55%">
				 <fmt:message key="Common.WorkingDays.label" bundle="${common_labels}"/> <input type=checkbox name='appl_for_working_days' id='appl_for_working_days' onclick="checkActiveApplicable(this)" disabled <%=appl_for_working_days%> >&nbsp&nbsp
				<fmt:message key="Common.Non-WorkingDays.label" bundle="${common_labels}"/> <input type=checkbox name='appl_for_nonworking_days' id='appl_for_nonworking_days'
				 onclick="checkActiveApplicable(this)" disabled <%=appl_for_nonworking_days%>>&nbsp&nbsp
				 <fmt:message key="Common.Holidays.label" bundle="${common_labels}"/> <input type=checkbox name='appl_for_holidays' id='appl_for_holidays'
				 onclick="checkActiveApplicable(this)" disabled <%=appl_for_holidays%>>&nbsp&nbsp
				</td>
				<td width="20%"></td>
			</tr>
			<tr><td colspan="3">&nbsp</td></tr>
			<tr>
				<td class="label" width="25%"><fmt:message key="Common.duration.label" bundle="${common_labels}"/>(hh:mi) &nbsp</td>
				<td class="fields" width="55%">
				<input type=text size=1 name='durn_hh' id='durn_hh' maxlength=2 readonly value='<%= durn_hh %>'> :
				<input type=text size=1 name='durn_mm' id='durn_mm' maxlength=2 readonly value='<%= durn_mm %>'> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
			<input type=button class=button value='<fmt:message key="Common.ShowPositions.label" bundle="${common_labels}"/> ' onclick='showPositionsList()'></td><td>&nbsp;</td></tr>
			<tr><td colspan="3">&nbsp</td></tr>
	</table>
<%
shift_list.clear();}catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally
{
	if (pstmt_shift_select != null) pstmt_shift_select.close();
	if (pstmt_shift != null) pstmt_shift.close();
	if (rs_shift != null)   rs_shift.close();
	if (rs_shift_select != null)   rs_shift_select.close();
	ConnectionManager.returnConnection(conn,request);	
}
%>
</form>
</body>
</html>

