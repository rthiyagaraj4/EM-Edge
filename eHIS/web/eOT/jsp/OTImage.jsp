<!DOCTYPE html>
<!-- Added by Rajesh 4-9-2012-->
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.io.FileUtils"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<!-- Added by Rajesh 4-9-2012-->
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <%
 String sql_image_flag = request.getParameter("sql_image_flag"); 
/*RUT-CRF-0091 by MuthuN Starts Here
 String eq_image = request.getParameter("image");
 out.println(" eq_image nursing notes "+eq_image);
 String eq_location = checkForNull(request.getParameter("location")); 
//RUT-CRF-0091 by MuthuN Ends Here*/
 //Added by Rajesh 4-9-2012
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
 String imageUrl = "";
 try{
	String facility_id	= (String) session.getValue("facility_id");
	String sql_instr_cssd = "select cssd_image_location from ot_param_for_facility where operating_facility_id ='"+facility_id+"'";
	con = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(sql_instr_cssd) ;
	rs = stmt.executeQuery();
	while(rs.next()){
		imageUrl=checkForNull(rs.getString(1));			
	}

	if(rs!=null)rs.close();
	if(stmt !=null)stmt.close();
}
catch(Exception e){
	System.err.println("Err Msg SetupParam4FacilityOtheretails.jsp "+e.getMessage());
}
finally{
	if(rs!=null)rs.close();
	if(stmt !=null)stmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request); 
}

try{
 //File eOtPath,localPath;
 //eOtPath = new File(application.getRealPath("eOT/images/"+sql_image_flag));
 //System.err.println("eOtPath->"+eOtPath);
 //localPath = new File(imageUrl+"\\"+sql_image_flag);
 /*System.err.println("localPath->"+localPath);
 if(!eOtPath.exists()&&localPath.exists()){
	 String url = application.getRealPath("eOT/images/");
	 System.err.println("eOT url->"+url);
	 File dest = new File(url);
	 FileUtils.copyFileToDirectory(localPath, dest);
 }*/
 //Added by Rajesh 4-9-2012
 //sql_image_flag = "../../eOT/images/"+sql_image_flag;
 //sql_image_flag = localPath.getAbsolutePath();
 //sql_image_flag= ""+(char)92+(char)92+"130.78.89.120"+(char)92+"OTimages";
	//sql_image_flag = imageUrl+(char)92+sql_image_flag;
	sql_image_flag = imageUrl+(char)92+sql_image_flag;
}
catch(Exception e){
	System.err.println("Err Msg Copying File "+e.getMessage());
}
 %>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- div align='right' -->
<div align='center'>
<table  cellpadding='0' cellspacing='0' >
<br><br>
	<tr>
		<td>
			<img src ='<%=sql_image_flag%>' width="400" height="400" align="middle">
			<!-- img src =' ' width="350" height="350" align="middle"> -->			
		</td>		
	</tr>
</table>
</div>
</body>
</html>

