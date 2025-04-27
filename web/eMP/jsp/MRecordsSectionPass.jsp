<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.* , eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	Connection con = null;
	PreparedStatement pstmt =null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String facilityid = (String) session.getValue("facility_id");
	String separate_file_no_yn="N";
	String single_or_multi_files_ind="";
	boolean proceed = false;

try {
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("Select single_or_multi_files_ind,separate_file_no_yn from mp_param_for_facility where facility_id='" + facilityid + "' ");
	rs = pstmt.executeQuery();
	if(rs != null) {
		if(rs.next()) {
			separate_file_no_yn=rs.getString("separate_file_no_yn")==null ? "N" : rs.getString("separate_file_no_yn");
			single_or_multi_files_ind=rs.getString("single_or_multi_files_ind")==null ? "S" : rs.getString("single_or_multi_files_ind");
			proceed = true;
		}
		else {
			try{
				pstmt=con.prepareStatement("Select single_or_multi_files_ind,separate_file_no_yn from mp_param");
				rs1 = pstmt.executeQuery();
				if(rs1 != null) {
					if(rs1.next()) {
						separate_file_no_yn=rs1.getString("separate_file_no_yn")==null ? "N" : 	rs1.getString("separate_file_no_yn");
						single_or_multi_files_ind=rs1.getString("single_or_multi_files_ind")==null ? "S" : rs1.getString("single_or_multi_files_ind");
						proceed = true;
					}
				}
			}catch(Exception e) { 
				e.printStackTrace();
				// out.println("Exception :"+e.toString());
				}
			finally
			{
				if (pstmt != null) pstmt.close();
				if (rs1 != null) rs1.close();
			}
		}
	}
	else {
		try{
			pstmt=con.prepareStatement("Select single_or_multi_files_ind,separate_file_no_yn from mp_param");
			rs1 = pstmt.executeQuery();
			if(rs1 != null) {
				if(rs1.next()) {
					separate_file_no_yn=rs1.getString("separate_file_no_yn")==null ? "N" : 	rs1.getString("separate_file_no_yn");
					single_or_multi_files_ind=rs1.getString("single_or_multi_files_ind")==null ? "S" : rs1.getString("single_or_multi_files_ind");
					proceed = true;
				}
			}
		}catch(Exception e) { 
			e.printStackTrace();
			//out.println("Exception :"+e.toString());
			}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rs1 != null) rs1.close();
		}
	}
}catch(Exception e) { 
	e.printStackTrace();
	//out.println("Exceptiom :"+e.toString());
	}
finally {
	if(pstmt !=null) pstmt.close();
	if(rs!=null) rs.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

	if(proceed && ((single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N")) || (single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("Y")) || (single_or_multi_files_ind.equals("S") && separate_file_no_yn.equals("Y")))) {
		%>
			<html>
				<head>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
			<Script language='javascript' src='../js/MRecordsSection.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



				</head>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:83vh;width:100vw'></iframe>
					<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
			</html>
		<%
	}
	else if( proceed && (single_or_multi_files_ind.equals("S") && separate_file_no_yn.equals("N"))) {
		%>
			<html> 				
				
				<Script language="JavaScript">
					document.location.href="../../eCommon/html/blank.html";
					alert(getMessage("MR_SECTION_NOT_ALL_FAC",'MP'));
					document.location.href='../../eCommon/jsp/dmenu.jsp';
				</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			</html>
		<%
	}
	else {
		%>
			<html> 	
				<Script language="JavaScript">
					document.location.href="../../eCommon/html/blank.html";
					alert(getMessage("MP_PARAM_NOT_FOUND",'MP'));
					document.location.href='../../eCommon/jsp/dmenu.jsp';
				</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			</html>
		<%
	}
%>

