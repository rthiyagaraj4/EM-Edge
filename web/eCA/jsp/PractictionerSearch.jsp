<!DOCTYPE html>
<%@page  language="java" contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
			<script language=javascript src='../js/TextBlock.js'></script>
			<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
			</head>

	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<%
			request.setCharacterEncoding("UTF-8");	
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rset=null;
			
			String pracid=request.getParameter("pracid")==null?"":request.getParameter("pracid");
			String resPracId="";
			String resPracDesc="";
			int count=0;
			try{
					con=ConnectionManager.getConnection(request);

						if (!pracid.equals("")){
							pracid=pracid+"%";
						}
				
					String sql="SELECT practitioner_id, practitioner_name FROM am_practitioner where eff_status='E' and   upper(practitioner_name) like upper(?) ";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,pracid);
					rset=pstmt.executeQuery();

					while(rset.next()){
								resPracId=rset.getString("practitioner_id");
								resPracDesc=rset.getString("practitioner_name");
								count=count+1;
					}

					if (count==1){ 
								out.println("<script>");
								out.println("parent.frames[1].document.forms[0].practitioner_desc.value='"+resPracDesc+"'");
								out.println("parent.frames[1].document.forms[0].practitioner.value='"+resPracId+"'");
								out.println("parent.frames[1].document.forms[0].flagPractitioner.value='true'");
								out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
								out.println("</script>");
					 }

					if (count>1 || count==0){ 	%>
					 	<script language=javascript>
									parent.frames[1].document.forms[0].practitioner_desc_search.disabled=true;
									parent.frames[1].document.forms[0].flagPractitioner.value='true'
								callfunctionforpract();
						</script> 
			<%  }

				if (rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			
			}catch(Exception e){
							//out.println("Error Raise"+e);//common-icn-0181
			                                  e.printStackTrace();//COMMON-ICN-0181
			}finally{
						
						if (con!=null) ConnectionManager.returnConnection(con,request);
					}
		%>
	</body>

