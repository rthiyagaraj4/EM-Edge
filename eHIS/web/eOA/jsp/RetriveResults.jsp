<!DOCTYPE html>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*" %>
<%
request.setCharacterEncoding("UTF-8");
String clinic_type = request.getParameter("clinic_type");
if(clinic_type == null || clinic_type.equals("null") || clinic_type.equals("undefined")) clinic_type="";

String open_to_all_pract_yn=request.getParameter("open_to_all_pract_yn");
if(open_to_all_pract_yn == null || open_to_all_pract_yn.equals("") || open_to_all_pract_yn.equals("undefined")) open_to_all_pract_yn="";

String clinic_code=request.getParameter("clinic_code");
if(clinic_code == null || clinic_code.equals("") || clinic_code.equals("undefined")) clinic_code="";

String facilityid=(String)session.getValue("facility_id");
 Connection con = null;  
Statement stmt =null;
Statement stmt2 =null;
PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rs2=null;
try{
	
	 con = ConnectionManager.getConnection(request);  
	 stmt = con.createStatement();
	 stmt2 = con.createStatement();

	String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>"
	+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
	out.println(a1);


String sql2="";
if(open_to_all_pract_yn.equals("Y"))
{
//sql2="select practitioner_name,practitioner_id from am_pract_for_facility_vw where eff_status='E' and OPERATING_FACILITY_ID='"+facilityid+"' order  by practitioner_name ";
sql2="select practitioner_name,practitioner_id from am_pract_for_facility_vw where eff_status='E' and OPERATING_FACILITY_ID=? order  by practitioner_name ";
}
else
if(open_to_all_pract_yn.equals("N"))
{
// sql2=" select practitioner_short_name,practitioner_id from op_pract_for_clinic_vw where FACILITY_ID='"+facilityid+"' and clinic_code='"+clinic_code+"' order by practitioner_short_name ";
 sql2=" select practitioner_short_name,practitioner_id from op_pract_for_clinic_vw where FACILITY_ID=? and clinic_code=? order by practitioner_short_name ";
}

else
{
sql2="";
}
String str1="";
String str2="";

if(! sql2.equals(""))
{
//rs2=stmt2.executeQuery(sql2);
pstmt = con.prepareStatement(sql2);
pstmt.setString(1,facilityid);
if(open_to_all_pract_yn.equals("N")){
pstmt.setString(2,clinic_code);
}
rs2 = pstmt.executeQuery();
if( rs2 != null ) 
{
%>
	<script>
	var n=parent.frames[1].document.frames[0].document.forms[0].pract.options.length;
	for(var i=0;i<n;i++)
	{
	parent.frames[1].document.frames[0].document.forms[0].pract.remove("pract");	
	}
	var tp =" -------Select------ ";
	var opt=parent.frames[1].document.frames[0].document.createElement("OPTION");
	opt.text=tp;
	opt.value="";
	parent.frames[1].document.frames[0].document.forms[0].pract.add(opt);	
	</script>	        
	
<%	while( rs2.next() ) 
		{
			str1 = rs2.getString( "practitioner_name" ) ;
			str2 = rs2.getString( "practitioner_id" );
			out.println("<script>var element = parent.f_query_add_mod.document.frames[0].document.createElement('OPTION');element.text = '"+str1+"';element.value= '"+str2+"';parent.f_query_add_mod.document.frames[0].document.forms[0].pract.add(element);</script>");
		}
		
}	

else
{ 
%>	
	<script>
	var n=parent.frames[1].document.frames[0].document.forms[0].pract.options.length;
	for(var i=0;i<n;i++)
	{
	parent.frames[1].document.frames[0].document.forms[0].pract.remove("pract");	
	}
	var tp =" -------Select------ ";
	var opt=parent.frames[1].document.frames[0].document.createElement("OPTION");
	opt.text=tp;
	opt.value="";
	parent.frames[1].document.frames[0].document.forms[0].pract.add(opt);	
	</script>	        


<% 
} 

}
	if(rs !=null) rs.close();
	if(rs2 !=null) rs2.close();
	if(stmt2 !=null) stmt2.close();
	if(stmt !=null) stmt.close();


}catch(Exception e){
//out.println(e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
ConnectionManager.returnConnection(con,request);

}

%>



