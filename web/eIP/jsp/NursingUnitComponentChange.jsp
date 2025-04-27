<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<%
request.setCharacterEncoding("UTF-8");
Connection con =null;
Statement  stmt=null;
ResultSet  rs =null;
String	   operstn = "";

Statement stmt1=null;
ResultSet rs1 =null;

Statement stmt2=null;
ResultSet rs2 =null;

try{ 
con = ConnectionManager.getConnection(request);

String facilityID=(String)session.getValue("facility_id");
String loginUser = (String)session.getValue("login_user");
String wherecondn = request.getParameter("wherecondn");
if(wherecondn == null) wherecondn ="";

String operSql = " select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b 	   "+
" where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   "+
" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   "+
" and trunc(sysdate) between b.eff_date_from and 			   "+
" nvl(b.eff_date_to,trunc(sysdate)) ";
stmt1 = con.createStatement();
rs1 = stmt1.executeQuery(operSql);

if(rs1!=null)
{
while(rs1.next())
{
operstn	 = rs1.getString("oper_stn_id");
if(operstn == null) operstn ="";
}
}
if(rs1!=null)rs1.close();
if(stmt1!=null)stmt1.close();
String name= request.getParameter("attribute");
if(name==null)
name = "nursing_unit";
%><select name="<%=name%>" id="<%=name%>" width="15" onChange='popDynamicValues(this)'><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---

<%	
stmt = con.createStatement();

if(wherecondn.equals(""))
{ 

String sql1="Select short_desc,nursing_unit_code  from ip_nursing_unit where facility_id='"+facilityID+"' and locn_type =  'N' and eff_status='E' order by short_desc ";
rs = stmt.executeQuery(sql1);

if( rs != null )
{
while( rs.next() )
{
String classcode = rs.getString( "nursing_unit_code" ) ;
String classname = rs.getString( "short_desc" ) ;
%>	      				<OPTION VALUE="<%= classcode %>" ><%= classname %>
<%	      	          }
}
if(rs!=null) rs.close();	      	
}
else
{
String sql2=" Select 1 from ip_nursing_unit a,      "+
" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' 	   "+
" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
" and a.locn_type=b.locn_type and b.locn_type =  'N' and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
" and b."+wherecondn+"='Y'order by a.short_desc";		
rs = stmt.executeQuery(sql2);			

if( rs != null )
{
if( rs.next() )
{      	
String sql1=" Select a.short_desc short_desc,a.nursing_unit_code nursing_unit_code from ip_nursing_unit a,      "+
" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' 	   "+
" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type =  'N' "+
" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
" and b."+wherecondn+"='Y' order by a.short_desc";		
//				out.println("sql1"+sql1);	     	    
rs2 = stmt.executeQuery(sql1);			
if( rs2 != null )
{
while( rs2.next() )
{
String classcode = rs2.getString( "nursing_unit_code" ) ;
String classname = rs2.getString( "short_desc" ) ;
%>							<OPTION VALUE="<%= classcode %>" ><%= classname %>

<%	
}
}
}
else
{
String classcode = "";
String classname = "";


%>							<OPTION VALUE="<%=classcode%>" ><%=classname%>

<%
}
}
if(rs!=null) rs.close();	      	
}//e.o.Else

}catch(Exception e)	{out.println(e);}
finally{
if(stmt!=null) stmt.close();
if(rs1!=null) rs1.close();
if(stmt1!=null) stmt1.close();
if(stmt2!=null) stmt2.close();
if(rs2!=null) rs2.close();
if(rs!=null) rs.close();

ConnectionManager.returnConnection(con,request);

}

%>

</select>

