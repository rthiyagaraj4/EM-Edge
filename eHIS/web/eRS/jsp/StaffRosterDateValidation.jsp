<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*, webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<% 
Connection con = null;
ResultSet rs1=null;
ResultSet rssql1=null;
PreparedStatement pstsql1 = null;
try
{
    con=ConnectionManager.getConnection(request);
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String from_date=(String) hash.get("from_date");
	String steps=(String) hash.get("steps");
	String to_date=(String) hash.get("to_date");
	String from_date_for_prev="";
	if(from_date ==null) from_date="";
	if(to_date==null) to_date="";
	if(steps==null) steps="";
	String to_date_cal="";
	String next_fromdate="";

    if(steps.equals("1"))
	{
	String Date_sql="select decode(  sign( (to_date(?,'dd/mm/yyyy')+29 ) - to_date(?,'dd/mm/yyyy')),1,?,to_char(to_date(?,'dd/mm/yyyy') + 29,'dd/mm/yyyy')) todate from dual";
	
	pstsql1 = con.prepareStatement(Date_sql);
	pstsql1.setString(1,from_date);
	pstsql1.setString(2,to_date);
	pstsql1.setString(3,to_date);
	pstsql1.setString(4,from_date);

	rssql1 = pstsql1.executeQuery();

	while(rssql1.next())
	{
		to_date_cal=rssql1.getString("todate");
	}

	if(pstsql1 != null)
		pstsql1.close();
	if(rssql1!= null)
		rssql1.close();
%>		
parent.frames[0].document.forms[0].to_date1.value='<%=to_date_cal%>';
parent.frames[0].document.forms[0].getFlag.value='Y';
<%
	String next_date="select to_char(to_date(to_date(?,'dd/mm/yyyy')+1),'dd/mm/yyyy')from_date from dual";
	pstsql1=con.prepareStatement(next_date);
	pstsql1.setString(1,to_date_cal);
	rs1=pstsql1.executeQuery();
	if(rs1.next())
	next_fromdate=rs1.getString("from_date");
		if(pstsql1 != null)
			pstsql1.close();
		if(rs1 != null)
			rs1.close();
	%>
	parent.frames[0].document.forms[0].from_date1.value='<%=next_fromdate%>';

<%
}     
if(steps.equals("2"))
	{
	
	String Date_sql="select decode(  sign( (to_date(?,'dd/mm/yyyy')+29 ) - to_date(?,'dd/mm/yyyy')),1,?,to_char(to_date(?,'dd/mm/yyyy') + 29,'dd/mm/yyyy')) todate from dual";
	
	pstsql1 = con.prepareStatement(Date_sql);
	pstsql1.setString(1,from_date);
	pstsql1.setString(2,to_date);
	pstsql1.setString(3,to_date);
	pstsql1.setString(4,from_date);
	rssql1 = pstsql1.executeQuery();
	while(rssql1.next()){
		to_date_cal=rssql1.getString("todate");		
	}
		if(pstsql1 != null)
			pstsql1.close();
		if(rssql1 != null)
			rssql1.close();
%>	
	
parent.frames[0].document.forms[0].new_todate.value='<%=to_date_cal%>';
parent.parent.frames[0].document.forms[0].getFlag.value='Y';
<%
	String next_date="select to_char(to_date(to_date(?,'dd/mm/yyyy')+1),'dd/mm/yyyy')from_date,to_char(to_date(to_date(?,'dd/mm/yyyy')-1),'dd/mm/yyyy')from_date_for_prev from dual";
	pstsql1=con.prepareStatement(next_date);
	pstsql1.setString(1,to_date_cal);
	pstsql1.setString(2,from_date);
	rs1=pstsql1.executeQuery();
		next_fromdate=rs1.getString("from_date");
		from_date_for_prev=rs1.getString("from_date_for_prev");

		if(pstsql1 != null)
			pstsql1.close();
		if(rs1 != null)
			rs1.close();

	if(rs1.next())
	%>
	parent.frames[0].document.forms[0].d_next.value='<%=next_fromdate%>';
	parent.frames[0].document.forms[0].from_date_for_prev.value='<%=from_date_for_prev%>';
<%
}     
if(steps.equals("3"))
	{
	String Date_sql="select to_char(to_date(to_date(to_date(to_date(?,'dd/mm/yyyy')-1,'dd/mm/yyyy')-29,'dd/mm/yyyy')),'dd/mm/yyyy') todate from dual";
	pstsql1=con.prepareStatement(Date_sql);
	pstsql1.setString(1,from_date);
	rssql1 = pstsql1.executeQuery();

	while(rssql1.next()){
		to_date_cal=rssql1.getString("todate");		
	}
		if(pstsql1 != null)
			pstsql1.close();
		if(rssql1 != null)
			rssql1.close();

%>	
	
	parent.frames[0].document.forms[0].new_todate.value='<%=to_date_cal%>';
	parent.frames[0].document.forms[0].new_from_date_for_next.value='<%=from_date%>';
<%
	String next_date="select to_char(to_date(to_date(?,'dd/mm/yyyy')-1),'dd/mm/yyyy')from_date from dual";
	pstsql1=con.prepareStatement(next_date);
	pstsql1.setString(1,to_date_cal);
	rs1=pstsql1.executeQuery();
	if(rs1.next())
	next_fromdate=rs1.getString("from_date");
		if(pstsql1 != null)
			pstsql1.close();
		if(rs1 != null)
			rs1.close();
	%>
	 parent.frames[0].document.forms[0].d_prev.value='<%=next_fromdate%>';
	

<%}     
}catch( Exception e ){
out.println(e.toString());
}
finally
{
		if(pstsql1 != null)
			pstsql1.close();
		if(rssql1 != null)
			rssql1.close();
		if(rs1 != null)
			rs1.close();
	ConnectionManager.returnConnection(con,request);
}
%>	
