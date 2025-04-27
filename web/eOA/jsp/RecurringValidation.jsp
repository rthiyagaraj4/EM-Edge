<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
 
<%
			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			request.setCharacterEncoding("UTF-8");

try
{

			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;
			String fromTime = (String) hash.get("fromTime");
			String toTime = (String) hash.get("toTime");
			String clinic_date =(String) hash.get("clinic_date");
			String patient_id = (String) hash.get("patient_id");
			String steps = (String) hash.get("steps");
			if (steps==null)		steps="";
			if (fromTime==null)	fromTime="";
			if (toTime==null)	toTime="";
			if (clinic_date==null)	clinic_date="";
			if (patient_id==null)  patient_id="";

	if(steps.equals("dateTime"))
	{
		if ((clinic_date==null) || (clinic_date.equals("null")))
		{
			clinic_date = "";
		}
		
		boolean overlap=true;
				
		String sqlr="select '1' from oa_appt where (to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi') > to_date('"+fromTime+"','hh24:mi') and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')< to_date('"+toTime+"','hh24:mi')) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"' union select '1' from oa_appt where (to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi') > to_date('"+fromTime+"','hh24:mi') and to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')< to_date('"+toTime+"','hh24:mi')) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"' union select '1' from oa_appt where to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi') = to_date('"+fromTime+"','hh24:mi') and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi') = to_date('"+toTime+"','hh24:mi') and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"'";

		rs= stmt.executeQuery(sqlr);
	
		
		if(rs !=null){
			if(!rs.next())
			{
				overlap=false;
			}
				if (overlap==true)
				{
					
					out.println("APPT_OVERLAP_NOT_PROCEED");
					
				}
				else
				{
					
				}

		    }
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	hash.clear();
}catch( Exception e ){
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}
%>


