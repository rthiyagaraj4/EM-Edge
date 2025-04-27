<!DOCTYPE html>

<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

<%

Connection con             = null;
ResultSet rs	           = null;
java.sql.Statement stmt	   = null;
String sql         = "";
request.setCharacterEncoding("UTF-8");
String objname=request.getParameter("objname");
if(objname == null) objname="";
String objValue=request.getParameter("objValue");
if(objValue == null) objValue="";

String bodypart=request.getParameter("bodypart");
if(bodypart==null)bodypart="";
String system_date="";
try
{
	
	 sql = "select to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date from dual";
	 con = ConnectionManager.getConnection(request);
	 stmt = con.createStatement();
	 rs = stmt.executeQuery(sql);
	if(rs != null)
	{
		if(rs.next())
		{
			system_date=rs.getString(1);	
		}
	}          
 
	 if(stmt!=null) stmt.close();
	 if(rs!=null) rs.close();
 
 if(bodypart.equals("deceasedregn1"))
	{
	 %>
 <script>
      start_date = "<%=objValue%>"
	 
    target_date = "<%=system_date%>"
	if(start_date!="")
		{
	fromDt = start_date.split(" ");
	fromarray = fromDt[0].split("/");
	fromtime = fromDt[1].split(":");
	
	fromDt1= target_date.split(" ");		
	toarray = fromDt1[0].split("/");
	totime = fromDt1[1].split(":"); 
	
	start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
	target_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];


	st_date = new Date();
	tr_date = new Date();
	dt_diff  = new Date();

	// Validates first date 
	st_datetemp = new Date(start_date);
	st_date.setTime(st_datetemp.getTime());

	// Validates second date 
	tr_datetemp = new Date(target_date);
	tr_date.setTime(tr_datetemp.getTime());

	// sets difference date to difference of first date and second date

	dt_diff.setTime(st_date.getTime() - tr_date.getTime());
		
	imediff = dt_diff.getTime();
	 if(imediff>0)
    {

			alert(getMessage('START_DATE_GREATER_SYSDATE','Common'))
			eval("parent.frames[0].document.forms[0].<%=objname%>.focus()")
			eval("parent.frames[0].document.forms[0].<%=objname%>.value=''")
			
			}
		}	
	 </script>
 <%
	}else

 if(bodypart.equals("bodypart")||bodypart.equals("deceasedregn"))
	{
	 %>
 <script>
     start_date = "<%=objValue%>"
	 
    target_date = "<%=system_date%>"
	if(start_date!="")
		{
	fromDt = start_date.split(" ");
	fromarray = fromDt[0].split("/");
	fromtime = fromDt[1].split(":");
	
	fromDt1= target_date.split(" ");		
	toarray = fromDt1[0].split("/");
	totime = fromDt1[1].split(":"); 
	
	start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
	target_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];


	st_date = new Date();
	tr_date = new Date();
	dt_diff  = new Date();

	// Validates first date 
	st_datetemp = new Date(start_date);
	st_date.setTime(st_datetemp.getTime());

	// Validates second date 
	tr_datetemp = new Date(target_date);
	tr_date.setTime(tr_datetemp.getTime());

	// sets difference date to difference of first date and second date

	dt_diff.setTime(st_date.getTime() - tr_date.getTime());
		
	imediff = dt_diff.getTime();
	 if(imediff>0)
    {
			alert(getMessage('START_DATE_GREATER_SYSDATE','Common'))
			eval("parent.frames[3].document.forms[0].<%=objname%>.focus()")
			eval("parent.frames[3].document.forms[0].<%=objname%>.value=''")
		
			}
		}		
 </script>
 <%
	}else
	
	{
	 %>
 <script>
	//if(eval(Date.parse("<%=system_date%>") )< eval(Date.parse("<%=objValue%>")))
	
	start_date = "<%=objValue%>"
	 
    target_date = "<%=system_date%>"
	if(start_date!="")
		{
	fromDt = start_date.split(" ");
	fromarray = fromDt[0].split("/");
	fromtime = fromDt[1].split(":");
	
	fromDt1= target_date.split(" ");		
	toarray = fromDt1[0].split("/");
	totime = fromDt1[1].split(":"); 
	
	start_date = fromarray[2]+"/"+fromarray[1]+"/"+fromarray[0]+" "+fromtime[0]+":"+fromtime[1];
	target_date = toarray[2]+"/"+toarray[1]+"/"+toarray[0]+" "+totime[0]+":"+totime[1];


st_date = new Date();
tr_date = new Date();
dt_diff  = new Date();

// Validates first date 
st_datetemp = new Date(start_date);
st_date.setTime(st_datetemp.getTime());

// Validates second date 
tr_datetemp = new Date(target_date);
tr_date.setTime(tr_datetemp.getTime());

// sets difference date to difference of first date and second date

dt_diff.setTime(st_date.getTime() - tr_date.getTime());
	
imediff = dt_diff.getTime();

if(imediff>0)
	{
alert(getMessage('START_DATE_GREATER_SYSDATE','Common'))
eval("parent.frames[2].document.forms[0].<%=objname%>.focus()")
eval("parent.frames[2].document.forms[0].<%=objname%>.value=''")
	}
    

		}
 </script>
 <%
	
		}
 }
 catch(Exception ee)
 {
	 ee.printStackTrace();
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();

 }
finally
{
   ConnectionManager.returnConnection(con,request);
}
%>


