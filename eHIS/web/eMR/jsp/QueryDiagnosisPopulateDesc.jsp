<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
     
	 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

</head>

<body class='message' onKeyDown='lockKey()'>
<%
		Connection con = ConnectionManager.getConnection(request);
        PreparedStatement pstmt = null;
		ResultSet rset = null;
       try 
		{
		
		String scheme = request.getParameter("scheme")==null?"":request.getParameter("scheme");



        String code = request.getParameter("code")==null?"":request.getParameter("code");

		String desc = "";
		String sql = "";
		String status = request.getParameter("status")==null?"":request.getParameter("status");
		String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
		if(status.equals("QUERY_PROC"))
			{
				if(scheme.equals("4"))//for CPT 4
				{
					//sql = "select short_desc from MR_ICD_CODE where diag_code = upper(?) and diag_code_scheme = (select proc_coding_scheme from MR_PARAM) ";
					sql = "SELECT short_desc FROM mr_term_code WHERE term_set_id = UPPER(?) AND term_code = UPPER(?)";
				}
				else if (scheme.equals("3"))//for ICD 9CM
				{
					//sql = "select short_desc from MR_ICD_CODE where diag_code = upper(?) and diag_code_scheme = (select proc_coding_scheme from MR_PARAM) ";
					sql = "SELECT short_desc FROM mr_term_code WHERE term_set_id = UPPER(?) AND term_code = UPPER(?)";
				}

					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,term_set_id);
					pstmt.setString(2,code);

					rset = pstmt.executeQuery();
					if(rset!=null && rset.next())
						   {
										desc = rset.getString("SHORT_DESC");
								%>
										<script>
										var temp ="<%=desc%>";
										parent.frames[1].document.forms[0].procedure_desc.value=temp;
										</script>
								<%
								
						   }
						   else
							{%>
							   <script>
							   var str = getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common');
							   alert(str);
							   parent.frames[1].document.forms[0].procedure_code.select();
							   parent.frames[1].document.forms[0].procedure_code.focus();
							   </script>
							<%}


			}else{
					/*if (scheme.equals("1"))
					{
						//sql = "SELECT SHORT_DESC,LONG_DESC FROM MR_ICD_CODE WHERE DIAG_CODE = upper(?)";
						sql = "SELECT short_desc FROM mr_term_code WHERE term_set_id = UPPER(?) AND term_code = UPPER(?)";
					}
					else if (scheme.equals("2"))
					{
						//sql = "SELECT SHORT_DESC,LONG_DESC FROM MR_ICD_CODE WHERE DIAG_CODE = upper(?)  AND RECORD_TYPE='D'";
						sql = "SELECT short_desc FROM mr_term_code WHERE term_set_id = UPPER(?) AND term_code = UPPER(?)";
						
					}*/
					sql = "SELECT short_desc FROM mr_term_code WHERE term_set_id = UPPER(?) AND term_code = UPPER(?)";					
					if(rset != null)rset.close();
					if(pstmt != null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,term_set_id);
					pstmt.setString(2,code);
					rset = pstmt.executeQuery();
					if(rset!=null && rset.next()){
							desc = rset.getString("SHORT_DESC");%>
										<script>
											var temp ="<%=desc%>";
											parent.frames[1].document.forms[0].mr_diagnosis_desc.value=temp;
										</script>
								<%
						   }else{%>
							  <script>
								  var str = parent.frames[1].getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common');
								  alert(str);
								  parent.frames[1].document.forms[0].mr_diagnosis_code.select();	 parent.frames[1].document.forms[0].mr_diagnosis_code.focus();
  						      </script>
							<%}



			}//end of else part
		}
		catch(Exception e)
			{/* out.println(e.toString()); */ e.printStackTrace();}
  		finally {
					try
			{
					if(rset != null)rset.close();
					if(pstmt != null)pstmt.close();
			}
			catch(Exception e)
			{}
			  ConnectionManager.returnConnection(con,request);
				}
%>


