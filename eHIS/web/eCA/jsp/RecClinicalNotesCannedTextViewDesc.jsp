<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2013	IN038542		Karthi L 	Create text block and assigned practitioner. this canned text does not appear in the transaction in CA		
										
--------------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html> 
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<!-- This was commented before changes to the style sheet for V3....So no style sheet has been added... -->
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function doInit()
{
	var val 	= window.dialogArguments;
	document.getElementById("comments").innerHTML = "<pre>" + val + "</pre>";
	//document.getElementById("comments").focus();
}


</script>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String title_name = request.getParameter("title_name");
  if(title_name==null || title_name=="" || title_name.equals(""))
  title_name = "";
  //[IN033786] Start
  String textType = request.getParameter("textType");
  String text_blk_id = request.getParameter("text_blk_id");
  String locale = request.getParameter("locale");
  String l_pract_id = (String)session.getValue("ca_practitioner_id"); // IN038542
  String service_code = request.getParameter("service_code");
  String login_user_id = request.getParameter("login_user_id");
  String note_type = request.getParameter("note_type");
  String sec_hdg_code = request.getParameter("sec_hdg_code");
  String text_blk = "";
  String query_canned_text ="";
  Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	
	try
		{
			con				=	ConnectionManager.getConnection(request);
			
			if("T".equals(textType)){ 				
				query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='T' AND text_blk_id = ? AND CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL ORDER BY text_blk_id";
			}else{ 
				query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='E' AND text_blk_id = ? AND  CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL ORDER BY text_blk_id";
			}
			
			pstmt		=	con.prepareStatement(query_canned_text);

			pstmt.setString(1,locale);
			pstmt.setString(2,service_code);
			pstmt.setString(3,service_code);
			//pstmt.setString(4,login_user_id); commented for  IN038542
			//pstmt.setString(5,login_user_id); commented for  IN038542
			pstmt.setString(4,l_pract_id); // IN038542
			pstmt.setString(5,l_pract_id); // IN038542
			pstmt.setString(6,note_type);
			pstmt.setString(7,note_type);
			pstmt.setString(8,sec_hdg_code);
			pstmt.setString(9,sec_hdg_code);			
			pstmt.setString(10,text_blk_id);
			pstmt.setString(11,locale);

			rs			=	pstmt.executeQuery();
			
			if(rs.next()){
			text_blk		=	rs.getString("text_blk");
			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@1: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
  //[IN033786] End
  
%>
<title><%=title_name%></title>
</head>
<!--[IN033786]<body onload='doInit()'  style='background-color:#E2E3F0;'  onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>-->
<body   style='background-color:#E2E3F0;'  onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<div style="overflow: auto;height:90vh">
<table width='100%' align='center' height=100% border='1' cellspacing='0' cellpadding='3'  style='background-color:white'>
	
	<tr>
		<!--[IN033786]<td  width='100%' height='100%' class='label' id="comments">&nbsp;&nbsp;</td>-->
		<td  width='100%' height='100%' class='label' id="comments"><%=text_blk%></td>
	</tr>
</table>
</div>
</body>
</html>

