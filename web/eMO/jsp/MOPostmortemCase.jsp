<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	Connection con =null;
	Statement stmt = null;
	ResultSet rs=null ;
	String strd="";
	String p_report_id="";
	String	facilityId 	= (String) session.getValue( "facility_id" ) ;
	String function_id = request.getParameter("function_id");
	String p_user_name			= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String p_module_id="MO";
	String CurrentDate = "";
	String CurrentDate1="";
	if(function_id.equals("MO_MONTHLY_PM"))
		p_report_id="MOMPOSMC";
	else
	if(function_id.equals("MO_MONTHLY_INVESTIGATION_PM"))
		p_report_id="MOMIPMC";
	else
		p_report_id="MOMPMMLC";
	
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		String curr_date_qry ="select to_char(sysdate,'yyyy') CurrentDate,to_char(sysdate,'DD/MM/yyyy') CurrentDate1 from dual" ;
		
		rs = stmt.executeQuery(curr_date_qry);
		if(rs!=null && rs.next())
		{
			CurrentDate=rs.getString("CurrentDate");
			CurrentDate1=rs.getString("CurrentDate1");
			CurrentDate1=DateUtils.convertDate(CurrentDate1,"DMY","en",locale);
			CurrentDate = DateUtils.convertDate(CurrentDate,"YY","en",locale);
			
		}
	
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally 
	{ 
		if(rs != null)    rs.close();
		if(stmt != null)    stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
		
		
	
%>
<html>
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>


<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>	
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/MOPostmortemCase.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
function validDateObj(date, format, locale){
	if (date.value != '')
	{
		if ( !validDate(date.value, format, locale) )
		{	
			
			if(format=='YY')
			{
				if(top.header != null)
				alert(top.header.getMessage("INVALID_YEAR_FMT", "SM"));
				else
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
			}
			else
			if(format=='DMY'){
			if(top.header != null)
				alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
			else
				alert(getMessage("INVALID_DATE_FMT", "SM"));
			}
			else
			{
				if(top.header != null)
				alert(top.header.getMessage("MONTH_YEAR_INVALID", "SM"));
			else
				alert(getMessage("MONTH_YEAR_INVALID", "SM"));
				
			}
			date.value="";
			date.select();
			date.focus();
			return false;
		}
		else
			return true;
	}
}
function compare_date1(from,to,localeName)
{
	
	if(from.value !="" && to.value !="" )
			if(isBefore(from.value,to.value,"DMY","en")==false) 
				{
					var invaldt = getMessage("TO_DT_GR_EQ_FM_DT","SM") ;
					alert(invaldt);
					to.value="";
					to.focus();
					to.select();
				}
	
}
function compare_date2(from,to,localeName)
{
	if(from.value !="" && to.value !="" )
			if(isBefore(from.value,to.value,"MY","en")==false) 
				{
					var invaldt = getMessage("REMARKS_MUST_GR_EQUAL","COMMON") ;
					var to_year=getLabel("Common.to.label","Common")+" "+getLabel("Common.month.label","Common")+"/"+getLabel("Common.year.label","Common");
					var from_year=getLabel("Common.month.label","Common")+"/"+getLabel("Common.year.label","Common");
					invaldt = invaldt.replace('$',to_year);
					invaldt = invaldt.replace('#',from_year);
					alert(invaldt);
					to.value="";
					to.focus();
					to.select();
				}
	
}


function compare_date(from,to,localeName)
{
	var from_val = convertDate(from.value,'YY',localeName,'en');
	var to_val = convertDate(to.value,'YY',localeName,'en');
	if(from.value !="" && to.value !="" )
			if(to_val < from_val) 
				{
					var invaldt = getMessage("REMARKS_MUST_GR_EQUAL","COMMON") ;
					var to_year=getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common");
					var from_year=getLabel("Common.year.label","Common");
					invaldt = invaldt.replace('$',to_year);
					invaldt = invaldt.replace('#',from_year);
					alert(invaldt);
					to.value="";
					to.focus();
					to.select();
				}
	
}
function validate_date1(obj)
{
			var from = convertDate(obj.value,'DMY',localeName,'en');
			var to  = convertDate(document.forms[0].CurrentDate1.value,'DMY',localeName,'en');
			if(from !="")
			if(isBefore(from,to,"DMY","en")==false) 
				{
					var invaldt = getMessage("START_DATE_GREATER_SYSDATE","COMMON") ;
					alert(invaldt);
					obj.value="";
					obj.focus();
					obj.select();
				}
	
}
function validate_date(obj) 
		{
			var from = convertDate(obj.value,'YY',localeName,'en');
			var to   = convertDate(document.forms[0].CurrentDate.value,'YY',localeName,'en');
				if(to < from) 
				{
					var invaldt = getMessage("CAN_NOT_GREAT_CURR_YR","IP") ;
					var stat_year=getLabel("Common.year.label","Common");
					invaldt = invaldt.replace('$',stat_year);
					alert(invaldt);
					obj.value="";
					obj.focus();
					obj.select();
				}
				
				
			
		}
function validate_date_mon_year(obj) 
		{ 
				
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate1.value;
        var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");

		var fromdt = new Date(fromarray[1],fromarray[0]);
		var todt = new Date(toarray[1],toarray[0]);

		if (!isBeforeNow(obj.value,"MY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
				 
					var invaldt		 = getMessage("REMARKS_SHOULD_LS_EQUAL",'common') ;
					var vis_adm_date = "Month/Year";
					var currentDate  = "Current Month/Year";
					invaldt=invaldt.replace('$',vis_adm_date);
					invaldt=invaldt.replace('#',currentDate);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
				
				
			
		}
		
</script>
</head>
<body  OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="menu_form" id="menu_form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame"  >
<BR>

  <table border="0" cellpadding="0" cellspacing="0" width="60%" align='left'>
 



 <tr>
 <td width="20%"  class="label"></td>
    <%
	if(p_report_id.equals("MOMPOSMC"))
	{
	%>
	<td width="15%"  class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
	<td width="7%"  class="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class='fields' width="30%"><input type='text'  name='from_date' id='from_date'  onblur='validDateObj(this,"DMY",localeName);validate_date1(this);compare_date1(this,document.forms[0].to_date,localeName);'  size="10" maxlength="10"   >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].from_date.select();return showCalendar('from_date', null, null );" style="cursor='hand'"><img src='../../eCommon/images/mandatory.gif'></img></td>
	
	 <td width="5%"  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text'  name='to_date' id='to_date'  onblur='validDateObj(this,"DMY",localeName);validate_date1(this);compare_date1(document.forms[0].from_date,this,localeName);'  size="10" maxlength="10"   >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].to_date.select();return showCalendar('to_date', null, null );" style="cursor='hand'"><img src='../../eCommon/images/mandatory.gif'></img></td>
	<%
	}
	else
	if(p_report_id.equals("MOMIPMC"))
	{
	%>
	<td width="15%"  class="label"><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
	<td width="7%"  class="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	   <td  class="fields" width="30%" ><input type=text  name='from_date' id='from_date' size="4" maxlength="4" align="center"  onblur='validDateObj(this,"YY",localeName);validate_date(this);compare_date(this,document.forms[0].to_date,localeName);'>&nbsp;<input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from_date','y',null)"><img  src='../../eCommon/images/mandatory.gif'></img>
					</td>
	
	 <td width="5%"  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td  class="fields" width="30%" ><input type=text  name='to_date' id='to_date' size="4" maxlength="4" align="center"  onblur='validDateObj(this,"YY",localeName);validate_date(this);compare_date(document.forms[0].from_date,this,localeName);'>&nbsp;<input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to_date','y',null)"><img  src='../../eCommon/images/mandatory.gif'></img>
					</td>
	
	<%
	}
	else
	{
	%>
	<td width="15%"  class="label"><fmt:message key="Common.month.label" bundle="${common_labels}"/>/<fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
	<td width="7%"  class="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	
	   <td  class="fields" width="30%" ><input type=text  name='from_date' id='from_date' size="7" maxlength="7" align="center"  onblur='validDateObj(this,"MY",localeName);validate_date_mon_year(this);compare_date2(this,document.forms[0].to_date,localeName);'>&nbsp;<input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from_date','mm/y',null)"><img  src='../../eCommon/images/mandatory.gif'></img>
					</td>
	
	 <td width="5%"  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td  class="fields" width="30%" ><input type=text  name='to_date' id='to_date' size="7" maxlength="7" align="center"  onblur='validDateObj(this,"MY",localeName);validate_date_mon_year(this);compare_date2(document.forms[0].from_date,this,localeName);'>&nbsp;<input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to_date','mm/y',null)"><img  src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<%
	}
	%>
	
    </tr>
	
   
   </table>
    <input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facilityId%>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id%>">
<input type="hidden" name="p_user_name" id="p_user_name" 		value="<%=p_user_name%>">
<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">
<input type="hidden" name="CurrentDate1" id="CurrentDate1"		value="<%= CurrentDate1 %>">
<input type="hidden" name="p_from_date" id="p_from_date" 		value="">
<input type="hidden" name="p_to_date" id="p_to_date" 		value="">

</form>


</body>
</html>


