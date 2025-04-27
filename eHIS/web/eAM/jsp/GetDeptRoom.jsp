<!DOCTYPE html>
<%--
	FileName	: GetDeptRoom.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<%
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			Statement stmt1 = null;
			ResultSet rset=null;
			ResultSet rset1=null;
			
			String servicecode="";
			String servicedesc="";
			String common=request.getParameter("Common_Text");
			String scode = request.getParameter("Service_code");
			String facilityId=(String)session.getValue("facility_id");
			String chksrc=request.getParameter("Chksrc");
			String operating_facilityID = request.getParameter("operating_facilityID");
			if(operating_facilityID == null) operating_facilityID="";
			String short_desc="",room_num ="";
			String dept_code="", dept_short_desc ="";
			
			if(scode!=null)
				scode=scode.trim();

		try{
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			stmt1 = con.createStatement();
		
			if(operating_facilityID.equals(""))
			{
			
			if(chksrc.trim().equals("department"))
			{
                        
						//String sql = "SELECT service_short_desc, service_code from am_facility_service_vw where eff_status='E' and operating_facility_id='"+facilityId+"' "+" and dept_code='"+common.trim()+"' order by service_short_desc" ;
						//rset = stmt.executeQuery(sql);
						
						String sql = "SELECT service_short_desc, service_code from am_facility_service_vw where eff_status='E' and operating_facility_id=? "+" and dept_code=? order by service_short_desc" ;
						pstmt   = con.prepareStatement(sql);
						pstmt.setString	(	1,	facilityId );
						pstmt.setString	(	2,	common.trim() );
						rset		 = pstmt.executeQuery();

						out.println("<html><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
						if(rset != null)
						{
			%>
						<script>
								var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
								var opt=parent.f_query_add_mod.document.createElement("OPTION");
								opt.text=tp;
								opt.value="";

								parent.f_query_add_mod.document.getElementById('service').add(opt);
						</script>


			<%
						while( rset.next() )
						{
							servicecode=rset.getString("service_code");
							servicedesc=rset.getString("service_short_desc");

			%>

							<script>

								var scode="<%=scode%>";
								var temp = "<%=servicecode%>";
								var temp1="<%=servicedesc%>";
								var opt=parent.f_query_add_mod.document.createElement("OPTION");
								opt.text=temp1;
								opt.value=temp;
								
								if (scode==temp)
									opt.selected=true;
								parent.f_query_add_mod.document.getElementById('service').add(opt);

							</script>

			<%
						}
						}
						if(rset!=null) rset.close();
                        if(stmt!=null) stmt.close();
                        if(pstmt!=null) pstmt.close();
						out.println("</form></body></html>");
			}
			
			}
			else
			{
				
				String sql = "select short_desc,room_num from am_facility_room where operating_facility_id=? and eff_status='E' order by short_desc";
				String sql1=" SELECT dept_code, dept_short_desc from am_facility_dept_vw where operating_facility_id=? and eff_status='E' order by Dept_Short_desc " ;
				stmt = con.createStatement();
				//rset = stmt.executeQuery(sql);
				//rset1 = stmt1.executeQuery(sql1);
				
				pstmt   = con.prepareStatement(sql);
				pstmt.setString	(	1,	operating_facilityID );
				rset		 = pstmt.executeQuery();
				
				pstmt1   = con.prepareStatement(sql1);
				pstmt1.setString	(	1,	operating_facilityID );
				rset1		 = pstmt1.executeQuery();
				
				out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
				if(rset != null)
				{
			%>
						<script>
								var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
								var opt=parent.f_query_add_mod.document.createElement("OPTION");
								opt.text=tp;
								opt.value="";

								parent.f_query_add_mod.document.getElementById('room').add(opt);
						</script>


			<%
						while( rset.next() )
						{
							room_num=rset.getString("room_num");
							short_desc=rset.getString("short_desc");

			%>

							<script>

								var temp = "<%=room_num%>";
								var temp1="<%=short_desc%>";
								var opt=parent.f_query_add_mod.document.createElement("OPTION");
								opt.text=temp1;
								opt.value=temp;
								parent.f_query_add_mod.document.getElementById('room').add(opt);

							</script>

			<%
						}
						
					}
					
				if(rset1 != null)
				{
			%>
						<script>
								var tp ="-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
								var opt=parent.f_query_add_mod.document.createElement("OPTION");
								opt.text=tp;
								opt.value="";

								parent.f_query_add_mod.document.getElementById('department').add(opt);
						</script>


			<%
						while( rset1.next() )
						{
							dept_code=rset1.getString("dept_code");
							dept_short_desc=rset1.getString("dept_short_desc");

			%>

							<script>

								var temp = "<%=dept_code%>";
								var temp1="<%=dept_short_desc%>";
								var opt=parent.f_query_add_mod.document.createElement("OPTION");
								opt.text=temp1;
								opt.value=temp;
								parent.f_query_add_mod.document.getElementById('department').add(opt);

							</script>

			<%
						}
						
					}					
					
					
						out.println("</form></body></html>");
				}			
			
			}
		catch(Exception e) { out.println(e.toString());}

		finally {
			try{
		  if (rset != null)   rset.close();
		  if (rset1!= null)   rset1.close();
		  if (stmt != null)   stmt.close();
		  if (stmt1 != null)  stmt1.close();
		  if (pstmt!=null) pstmt.close();
		  if (pstmt1!=null) pstmt1.close();
			}
			catch(Exception e)
			{}
		  ConnectionManager.returnConnection(con,request);

		}
%>

