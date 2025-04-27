<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String patient_id			= request.getParameter("patient_id");
		String facilityId 			= (String) session.getValue( "facility_id" ) ;
		String sql_query			= request.getParameter("sql_query");
		String contact_no			= request.getParameter("contact_no"); 
		int p_rec_cnt				= 0;
		boolean valid=true;

		if( ! (patient_id.equals("") || patient_id ==null) )
		{
			Connection con = null;
			java.sql.Statement stmt=null;
			ResultSet rs=null;

			String valid_pat_id ="";
			StringBuffer sql1 = new StringBuffer();
	    	
		    String e_msg ="";
			try
			{
			 con  =  ConnectionManager.getConnection(request);
		     stmt = con.createStatement();
			 sql1.append("select patient_id from mp_patient where patient_id='"+patient_id+"'");
	         rs = stmt.executeQuery(sql1.toString());

		     if(rs != null) 
			 if(rs.next())
                    valid_pat_id=rs.getString("patient_id");

			 if (rs != null) rs.close();
		     if (stmt != null) stmt.close();
			 sql1.delete(0,sql1.length());
         
		         if(valid_pat_id==null || valid_pat_id.equals(""))
				 {
				valid=false;
				e_msg="INVALID_PATIENT";
				 }
              


				if(!valid)
				{
			    
				out.print("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'; alert(getMessage('"+e_msg+"','MP'));parent.frames[1].document.forms[0].search.disabled=false</script>");         
			    
				}
				else
				{
					stmt = con.createStatement();
					sql1.append("select count(*) as total from op_patient_queue a,mp_patient b,ae_pat_related_contacts c where a.facility_id='"+facilityId+"'"+sql_query+" ");
					if (!contact_no.equals(""))
						sql1.append(" and c.res1_tel_no= nvl('"+contact_no+"',res1_tel_no) ");
					rs = stmt.executeQuery(sql1.toString());

					while (rs.next())
					{
						p_rec_cnt = rs.getInt("total");
					}
		            if (stmt != null) stmt.close();
					if (p_rec_cnt == 0 )
					{
						valid=false;
					}
					else
					{
						valid=true;
					}
				}
                 sql1.delete(0,sql1.length());
				 if(rs != null)	rs.close();
		         if(stmt != null) stmt.close();
			}
			catch(Exception e)
			{e.printStackTrace();}
			finally
			{ 
		      if(con!=null) ConnectionManager.returnConnection(con,request);
			}

		}

		String url = "../../eAE/jsp/AEPatByCriteriaResult.jsp?contact_no="+java.net.URLEncoder.encode(contact_no)+"&sql_query="+sql_query;

		if (valid)
		{
%>
<script>var src = "<%=url%>"; parent.frames[2].location.href=src</script>
<!-- <iframe name='AEPatDetailsResultFrame' id='AEPatDetailsResultFrame' src="<%=url%>" frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
  -->
<%
		}
		else
		{
		%>
			<script>
	            parent.f_patientByCriteria.document.AEPatientByCriteriaForm.search.disabled = false;
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			</script>
		<%
		}
%>

</html>

