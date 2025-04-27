<!DOCTYPE html>
<%--
	FileName	: GetBuilding.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>

<%
			request.setCharacterEncoding("UTF-8");
			Connection con = null;
         
			Statement stmt =null;
			PreparedStatement pstmt = null;			
			ResultSet rset=null;
			try{
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();		
			//String servicecode="";
			//String servicedesc="";
			String operating_facilityID = request.getParameter("operating_facilityID");
			if(operating_facilityID == null) operating_facilityID="";
			String bldng_code="", short_desc ="";
			
			
			String sql = "Select bldng_code,short_desc  from am_bldng  where eff_status='E' and  operating_facility_id =? order by SHORT_DESC " ;
			//rset = stmt.executeQuery(sql);
			
			pstmt   = con.prepareStatement(sql);
			pstmt.setString	(	1,	operating_facilityID);
			rset= pstmt.executeQuery();

			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
			if(rset != null)
			{
	%>
				<script>
						var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
						//var opt=parent.document.frames[1].document.createElement("OPTION");
						var opt=parent.f_query_add_mod.document.createElement("OPTION");
						opt.text=tp;
						opt.value="";

								parent.f_query_add_mod.document.getElementById('bldng_code').add(opt);
								//parent.document.frames[1].document.forms[0].bldng_code.add(opt);
						</script>


			<%
						while( rset.next() )
						{
							bldng_code=rset.getString("bldng_code");
							short_desc=rset.getString("short_desc");

			%>

							<script>
								var temp = "<%=bldng_code%>";
								var temp1="<%=short_desc%>";
								var opt=parent.f_query_add_mod.document.createElement("OPTION");
								opt.text=temp1;
								opt.value=temp;
								parent.f_query_add_mod.document.getElementById('bldng_code').add(opt);

							</script>

			<%
						}
						}
					out.println("</form></body></html>");
			
			}
		catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace();
		}

		finally {
			try
			{
		  if (rset != null) rset.close();
		  if (stmt != null) stmt.close();
			}
			catch(Exception e)
			{}
		  ConnectionManager.returnConnection(con,request);

		}

		
%>

