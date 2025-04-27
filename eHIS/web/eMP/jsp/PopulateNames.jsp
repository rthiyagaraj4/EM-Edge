<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.io.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>



<%  
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);	

try{	
	String called_function=request.getParameter("called_function")==null?"":request.getParameter("called_function"); 
	if(called_function.equals("MP")) { 
		String sqlbuf = "";
		String other_name_loc_lang = "" ;
		PreparedStatement pstmt=null;
		ResultSet rs1=null;
		String lang=request.getParameter("lang")==null?"":request.getParameter("lang");
		String familyname=request.getParameter("familyname")==null?"N":request.getParameter("familyname");
		String othername="";
		othername=request.getParameter("othername")==null?"":request.getParameter("othername");
		if(lang.equals("O")){
		 othername= java.net.URLDecoder.decode(request.getParameter("othername"),"UTF-8");
		}
		
		if(familyname.equals("Y")){
			if(lang.equals("O")){		 
			 sqlbuf = "select LAST_NAME from mp_std_family_name where upper(LAST_NAME_LOC_LANG) =upper(?) ";  
			}else{
			 sqlbuf ="select LAST_NAME_LOC_LANG from mp_std_family_name where upper(LAST_NAME) = upper(?) ";
			}	
			pstmt = conn.prepareStatement(sqlbuf);
			pstmt.setString(1,othername);
	 		rs1 = pstmt.executeQuery();			
			if(rs1!=null && rs1.next()) {			
				if(lang.equals("O")){
					other_name_loc_lang = rs1.getString("LAST_NAME")==null?"":rs1.getString("LAST_NAME");		
				}else{
					other_name_loc_lang = rs1.getString("LAST_NAME_LOC_LANG")==null?"":rs1.getString("LAST_NAME_LOC_LANG");				
				 }
			} 
		}else{
			if(lang.equals("O")){		 
				sqlbuf = "select OTHER_NAME from mp_std_other_name where upper(OTHER_NAME_LOC_LANG) =upper(?) ";  
			}else{
				sqlbuf ="select OTHER_NAME_LOC_LANG from mp_std_other_name where upper(OTHER_NAME) = upper(?) ";
			}	
			pstmt = conn.prepareStatement(sqlbuf);
			pstmt.setString(1,othername);
	 		rs1 = pstmt.executeQuery();			
			if(rs1!=null && rs1.next()) {			
				if(lang.equals("O")){
					other_name_loc_lang = rs1.getString("OTHER_NAME")==null?"":rs1.getString("OTHER_NAME");		
				}else{
					other_name_loc_lang = rs1.getString("OTHER_NAME_LOC_LANG")==null?"":rs1.getString("OTHER_NAME_LOC_LANG");				
				 }
			} 
		}
		
			out.println("#"+other_name_loc_lang);	
			if(pstmt != null) pstmt.close();
			if(rs1  != null) rs1.close();			
		}
}catch(Exception e) { 
	//if(resultSet != null) resultSet.close();
	//if(stmt != null) stmt.close();
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            

