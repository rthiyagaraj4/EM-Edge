<!DOCTYPE html>
<%@page import=" java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="eCA.CannedText.label" bundle="${ca_labels}"/></title>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<% 	request.setCharacterEncoding("UTF-8");	%>
 <%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!--added by Arvind @ 05-12-08-->

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection			con			=	null;
	PreparedStatement pstmt			=	null;
	ResultSet			rs			=	null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//String locale=(String)session.getValue( "LOCALE" ) ;
	String	service_code		=	"",		login_user_id	=	"";
	String	text_blk_id			=	"",		text_blk		=	"";
	String	query_canned_text	=	"",		selectBlockId	=	"";
	String	text_blk_id_name	=	"",		text_blk_name	=	"";
	String	classValue			=	"";
	
	int selectIndex = 0;
%>
	<!-- <center> -->
	<form name='RecClinicalNotesCannedTextForm' id='RecClinicalNotesCannedTextForm'>
	<!-- <div id="container" style="width:630;height:400;overflow:auto"> -->
		<table class='grid' border='1' cellpadding='3' cellspacing='0' width='100%' >
		<tr>
		<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.BlockID.label" bundle="${ca_labels}"/></td></tr>
	<%
		String Encounter_Id=request.getParameter("Encounter_Id");

		if(Encounter_Id == null)
			Encounter_Id = "";

		
		try
		{
			con				=	ConnectionManager.getConnection(request);
			login_user_id	=	(String) session.getValue("login_user");
		
			String			facility_id	=(String)session.getValue("facility_id");

			String sql	=	"SELECT service_code FROM pr_encounter WHERE encounter_id = ? and facility_id= ? ";
			
			try
			{
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,Encounter_Id);
				pstmt.setString(2,facility_id);
				rs=pstmt.executeQuery();
			
				while (rs.next())
				{
					service_code=rs.getString("service_code");
				}
				
				if (rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

			}
			catch(Exception e)
			{
			    e.printStackTrace();
				//out.println("Error Is "+e);//COMMON-ICN-0181
			}

			//query_canned_text = "Select text_blk_id, text_blk from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and APPLICABLE_CATEGORY='P' ";
			query_canned_text="Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk  from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and APPLICABLE_CATEGORY='P'";
			
			pstmt		=	con.prepareStatement(query_canned_text);
			pstmt.setString(1,locale);
			pstmt.setString(2,service_code);
			pstmt.setString(3,service_code);
			pstmt.setString(4,login_user_id);
			pstmt.setString(5,login_user_id);
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				text_blk_id		=	rs.getString("text_blk_id");
				text_blk		=	rs.getString("text_blk");

				while(text_blk.indexOf("\r\n")!=-1)
				{
					int a=text_blk.indexOf("\r\n");
					StringBuffer temp=new StringBuffer(text_blk);
					temp.replace(a,a+2,"<br>");
					text_blk=temp.toString();
				}

				text_blk_name		=	"text_blk"	  + selectIndex ;
				text_blk_id_name	=	"text_blk_id" + selectIndex ;
				selectBlockId		=	"block_id"	  + selectIndex ;

				if( (selectIndex%2)==0 )  
					classValue = "QRYEVEN";
				else 
					classValue = "QRYODD";

				selectIndex ++ ;
	%>
				<tr>
					<td class='gridData' ><input type='checkbox' name='<%=selectBlockId%>' id='<%=selectBlockId%>' value='Y'>
						<input type='hidden' name='<%=text_blk_id_name%>' id='<%=text_blk_id_name%>' value='<%=text_blk_id%>'>
					</td>
					<td class='gridData' id='<%=text_blk_name%>'><%=text_blk%></td>
					<td class='gridData'><%=text_blk_id%></td>
				</tr>
	<%
			} 
		
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception@1: "+e);//COMMON-ICN-0181
		}finally	{
			
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
	%>
		</table>
		<!-- </div> -->
		<input type='hidden' name='totalBlocks' id='totalBlocks' value='<%=selectIndex%>'>
	</form>
	<!-- </center> -->
</body>
</html>

