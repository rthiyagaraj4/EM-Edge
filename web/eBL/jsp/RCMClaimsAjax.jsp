<!DOCTYPE html>
<%@page import="java.io.*"%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,eBL.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String functionMode="";
	try{
	    con = ConnectionManager.getConnection();
		String facilityId = (String) session.getValue("facility_id");
		String loginUser = (String) session.getValue("login_user");
		functionMode = request.getParameter("functionMode");
		if (null == functionMode) {
			functionMode = "";
		}
		if(functionMode.equals("SinglePDF")){
			String rcmid = request.getParameter("rcmid");
			System.out.println("rcmid " + rcmid); 
			String locale = request.getParameter("locale");
			String file_name="";
			String file_path="";
			String obj="";
			 try {
				pstmt=con.prepareStatement("select file_path,file_name from BL_RCM_DATA_ENC_DTL hdr where hdr.rcm_id='"+rcmid+"' and hdr.operating_facility_id = '"+facilityId+"'");			
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					file_name =rs.getString("file_name");
					file_path =rs.getString("file_path");
				}
				if (null == file_name) {
					file_name = "";
				}
				if (null == file_path) {
					file_path = "";
				}
				if(file_name!="" && file_path!="" ){
					obj=file_path+"\\"+file_name;
					System.out.println("rcm file_path " + obj); 
					System.out.println("obj " + obj); 
					obj= obj.replaceAll("\\\\", "/");
					System.out.println("obj  1 " + obj); 
					out.println(obj);
				}else{
					System.out.println("else rcm folder click"); 
					out.println(obj);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("rcm file_path exception " + e);
			} 
			
			
			//out.println(obj);
		}
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception from BLCommonAjax :" + e);
	} finally {
		ConnectionManager.returnConnection(con, request);
	}
%>
