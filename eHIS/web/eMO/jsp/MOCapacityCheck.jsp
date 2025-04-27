<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
Connection conn = null; 
ResultSet rs	= null;
Statement stmt	= null;
StringBuffer sql=new StringBuffer();
//int capacity=0;
//int ncapacity=0;
int bedCount =0;
try
{
   	request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String bedVaild = (String)hash.get("bedVaild");
	String registration_no = (String)hash.get("registration_no");
	if(bedVaild==null) bedVaild="";
	String occupying_patient_id="";
	
	if(bedVaild.equals("Y"))
	{
			
			String result ="";
			String bed_no = (String)hash.get("bed_no");
			if(bed_no==null) bed_no="";
			String area_code = (String)hash.get("area_code");
			if(area_code==null)area_code="";

			String patient_id = (String)hash.get("patient_id");
			if(patient_id==null)patient_id="";
            if((sql != null) && (sql.length() > 0))
			{
				sql.delete(0,sql.length());
			}
            stmt=conn.createStatement();
			sql.append("select OCCUPYING_PATIENT_ID from mo_bed_for_area where AREA_CODE='"+area_code+"' and  bed_no='"+bed_no+"' and facility_id = '"+facilityId+"' and EFF_STATUS='E'");
			rs=stmt.executeQuery(sql.toString());
              while(rs.next())
			   {
				occupying_patient_id = rs.getString("OCCUPYING_PATIENT_ID");

			    }   if(rs != null)	rs.close();	
	                if(stmt !=null) stmt.close();
			if(occupying_patient_id==null) occupying_patient_id="";
			stmt=conn.createStatement();
            if (occupying_patient_id.equals(patient_id))
		    {
				if((sql != null) && (sql.length() > 0))
				{
					sql.delete(0,sql.length());
				}
				
				sql.append("select count(*) from mo_bed_for_area where  AREA_CODE='"+area_code+"' and  bed_no='"+bed_no+"' and facility_id = '"+facilityId+"' and (((OCCUPYING_PATIENT_ID is null or occupying_patient_id='"+patient_id+"') and (registration_no is null or registration_no='"+registration_no+"') and BLOCKED_YN='N') OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE)) and EFF_STATUS='E' ");
				rs=stmt.executeQuery(sql.toString());
			}
			else
			{
				if((sql != null) && (sql.length() > 0))
				{
					sql.delete(0,sql.length());
				}
				sql.append("select count(*) from mo_bed_for_area where  AREA_CODE='"+area_code+"' and  bed_no='"+bed_no+"' and facility_id = '"+facilityId+"' and (((OCCUPYING_PATIENT_ID is null or occupying_patient_id='') and (registration_no is null or registration_no='') and BLOCKED_YN='N') OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE)) and EFF_STATUS='E' ");
				rs=stmt.executeQuery(sql.toString());
			
			}
			while(rs.next()) 
			{
				bedCount = rs.getInt(1);
      
			} if(rs != null)	rs.close();	
  	          if(stmt !=null) stmt.close();
	 
			if (bedCount==0)
			{
				result ="Invalid"; 
			
			}
			out.println(result);
     }
	 sql.setLength(0);
	if(rs != null)	rs.close();	
    if(stmt !=null) stmt.close();
hash.clear();
}
catch(Exception e) {out.println("Exception in File MOCapcityCheck"+e.toString());e.printStackTrace();}
finally
{
	 ConnectionManager.returnConnection(conn,request);
}
%>


