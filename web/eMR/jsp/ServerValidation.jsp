
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
	request.setCharacterEncoding("UTF-8");
   Connection conn=null;
   Statement stmt=null;
   ResultSet rset=null;
   String locale=(String)session.getAttribute("LOCALE"); 

String param = request.getParameter("param");
if(param == null) param="";
String entered_date = request.getParameter("entered_date");
if(entered_date == null) entered_date="";
String calculateFlag = request.getParameter("calculateFlag");
if(calculateFlag == null) calculateFlag="";
String event_sdate =request.getParameter("event_sdate");
if(event_sdate == null) event_sdate="";



try
{
  conn=ConnectionManager.getConnection(request);
  
String sql="",dateValue="";

if(calculateFlag.equals("from"))
	sql="select to_char(sysdate-decode('"+param+"','D',"+entered_date+",'Y',"+entered_date+"*365,'M',(add_months(sysdate,"+entered_date+")-sysdate)),'dd/mm/yyyy') from_date from dual ";
else
	sql="select to_char(to_date('"+event_sdate+"','dd/mm/yyyy')+decode('"+param+"','D',"+entered_date+",'Y',"+entered_date+"*365,'M',(add_months(sysdate,"+entered_date+")-sysdate)),'dd/mm/yyyy') to_date from dual ";

//out.println("<script>alert(\""+sql+"\");</script>");

stmt = conn.createStatement();
rset = stmt.executeQuery(sql);
if(rset !=null)
	if(rset.next())
		dateValue= rset.getString(1);
	if(!(dateValue==null || dateValue.equals("")))
		dateValue = DateUtils.convertDate(dateValue,"DMY","en",locale);

out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onKeyDown = 'lockKey()'  CLASS='MESSAGE'><form name='nam1' id='nam1'>");
if(calculateFlag.equals("from"))
	{
	//	dateValue = "01"+dateValue.substring(2,dateValue.length());
		/*out.println("<script>parent.frames[1].document.frames[2].document.forms[0].event_sdate.value='"+dateValue+"'; parent.frames[1].document.frames[2].document.forms[0].event_sdate.focus() </script>");*/
		/*out.println("<script>"parent.query.document.addmodify.document.getElementById('event_sdate').value=+dateValue+;parent.query.document.addmodify.document.getElementById('event_sdate').focus() "</script>");*/
		out.println("<script>" +"parent.f_query_add_mod.addmodify.document.getElementById('event_sdate').value = '" + dateValue + "';" +"parent.f_query_add_mod.addmodify.document.getElementById('event_sdate').focus();" + "</script>");
	}
else	
	{
//	dateValue = "01"+dateValue.substring(2,dateValue.length());
	out.println("<script>parent.f_query_add_mod.addmodify.document.getElementById('event_edate').value='"+dateValue+"'; parent.f_query_add_mod.addmodify.document.getElementById('event_edate').focus() </script>");
	}
	

}catch(Exception e){
			e.toString();
	     }
	     finally{
			 try
			 {
		if(stmt!=null)
	     	stmt.close();
	     	if(rset!=null)
	     	rset.close();
			 }
			 catch(Exception e){
			
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

