<!DOCTYPE html>

<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%	Map hash= new HashMap();
    
	hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
request.setCharacterEncoding("UTF-8");
	String holiday_from=(String)hash.get("holiday_date");
	if(holiday_from == null) holiday_from="";

	String locnCode=(String) hash.get("location");
	if (locnCode==null) locnCode="";
	String clinicCodes=(String) hash.get("clinics");
	if (clinicCodes==null) clinicCodes="";
	String facilityId	    = (String) session.getValue( "facility_id" ) ;   
	
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	try{
		con = ConnectionManager.getConnection(request);
	
			if(pstmt !=null) pstmt.close();

			int sch_cnt = 0;
			String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = '"+facilityId+"' and clinic_date = to_date('"+holiday_from+"','dd/mm/yyyy') and care_locn_type_ind='"+locnCode+"' and clinic_code = '"+clinicCodes+"'";
			pstmt=con.prepareStatement(sqlstr);
		
			rs=pstmt.executeQuery();
			if (rs!=null && rs.next()){
				
				sch_cnt=rs.getInt("cnt");
				
			}
			%>	var flag=true;<%
			if (sch_cnt >0) 
				{
					%>
						 flag=false;
						
					<%
				}
				else
				{
					%>
						 flag=true;
					<%
				}

	if(pstmt != null)pstmt.close();
	if(rs != null) rs.close();
hash.clear();

}
catch(Exception e)
{
	//out.print(e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>
