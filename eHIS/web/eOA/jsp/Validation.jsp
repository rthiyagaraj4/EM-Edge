<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%
Connection con = null;
Statement stmt = null;
ResultSet rs=null;
ResultSet rs1=null;
PreparedStatement pstmt=null;
try{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
 stmt = con.createStatement();
	String Pract_Type_Code = request.getParameter("Pract_Type_Code");
	if (Pract_Type_Code!=null){
			String facilityid=(String)session.getValue("facility_id");
		    String sql1 = "Select practitioner_name,practitioner_id from am_pract_for_facility_vw Where operating_facility_id=? and pract_type=? and  Eff_status='E' order by practitioner_name" ;
			//rs = stmt.executeQuery("Select practitioner_name,practitioner_id from am_pract_for_facility_vw Where operating_facility_id='"+facilityid+"' and pract_type='"+Pract_Type_Code+"' and  Eff_status='E' order by practitioner_name");
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,Pract_Type_Code);
			rs = pstmt.executeQuery(); 

		%>
		<script>
			var n=parent.querying.document.getElementById("practitioner").options.length;
			for(var i=0;i<n;i++){
				parent.querying.document.getElementById("practitioner").remove("pract");	
			}
			var tp =" -------Select------ ";
			var opt=parent.querying.document.createElement("OPTION");
			opt.text=tp;
			opt.value="";
			parent.querying.document.getElementById("practitioner").add(opt);
		</script>
		<%
			while (rs.next()){
			%>
				<script language="JavaScript">
				tp = '<%=rs.getString("practitioner_name")%>';
				opt=parent.querying.document.createElement("OPTION");
				opt.text=tp;
				opt.value = '<%=rs.getString("practitioner_id")%>';
				parent.querying.document.getElementById("practitioner").add(opt);
				</script>
			<%
			}
		

	}else{

	String to_date = request.getParameter("to_date");
	String from_date=request.getParameter("from_date");
	from_date = from_date;
	
			String wd1="";
			if(rs !=null)rs.close();
			//String sql="select ROUND(to_date('"+to_date+"', 'dd/mm/yyyy') - TRUNC(SYSDATE)) dtval FROM DUAL";
			String sql="select ROUND(to_date(?, 'dd/mm/yyyy') - TRUNC(SYSDATE)) dtval FROM DUAL";
			rs = stmt.executeQuery(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,to_date);
			rs = pstmt.executeQuery(); 
			while(rs.next()){
			wd1 = rs.getString("dtval");
			}
			
		
		
	int check=Integer.parseInt(wd1);
	if(check < 0 ){
		String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link>";%>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>alert(getMessage('SCH_GR_TODAY','OA'););"
		+"parent.frames[1].document.frames[1].document.forms[0].prefdate.value='"+from_date+"' </script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
		<%out.println(a1);
		}
		else
		{
		String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>"
		+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
		out.println(a1);	
		}
	}	

	if(rs !=null) rs.close();
	if(rs1 !=null) rs1.close();
	if(stmt !=null) stmt.close();


}catch( Exception e ){
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>



