<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<%
            request.setCharacterEncoding("UTF-8");
			Connection con=null;
			con = ConnectionManager.getConnection(request);
			Statement stmt1 = con.createStatement();
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1=null;
			PreparedStatement pstmt2=null;
			Statement rootstmt= con.createStatement();
			Statement stmt_resp =null;
			ResultSet rset=null;
			ResultSet rset1=null;
			ResultSet rset2=null;
			ResultSet rootrset=null;
			String common=request.getParameter("Common_Text");
			if(common==null) common="";
			
			String Responsibility=request.getParameter("Responsibility");
			if(Responsibility==null) Responsibility="";
		
			String user_id=request.getParameter("User");
			if(user_id==null) user_id="";
			String chksrc = request.getParameter("Chksrc");

			String menu_id="";
			String option_type="";
			String module_id="";
			String function_id="";
			String submenu_id ="";
			String option_descriptor="";
			String access1="";
			String array[][]=null;
			String root_yn="";
			int row=0;
		    String sStyle	=
            (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  
try{
	if(chksrc.trim().equals("seven1")){
			String dat1 = "";
			try{
				//String	sql_resp="Select A.Resp_Id, B.Resp_Name, B.Menu_Id from SM_RESP_FOR_USER A, SM_RESP B Where upper(A.Appl_User_Id)= upper('"+user_id.trim()+"') and A.Resp_Id = B.Resp_Id  and a.resp_id='"+common.trim()+"' ";
				//stmt_resp=con.createStatement();
				//ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
				
				String	sql_resp="Select A.Resp_Id, B.Resp_Name, B.Menu_Id from SM_RESP_FOR_USER A, SM_RESP B Where upper(A.Appl_User_Id)= upper(?) and A.Resp_Id = B.Resp_Id  and a.resp_id=? ";
				pstmt   = con.prepareStatement(sql_resp);
				pstmt.setString	(	1,	user_id.trim()		);
				pstmt.setString	(	2,	common.trim()		);
				ResultSet rs_resp		 = pstmt.executeQuery();
					if(rs_resp!=null)
						{
							while(rs_resp.next())
							{
								dat1=rs_resp.getString(3);
							}
						if(rs_resp!=null) rs_resp.close();
						if(stmt_resp!=null) stmt_resp.close();
						if(pstmt!=null) pstmt.close();
						}
					}
				catch( Exception e){out.println(e);}
				chksrc="seven";
				common=dat1;
			
				}

			 if(chksrc.trim().equals("seven")) 
				{
					String rootsql=" select ROOT_MENU_YN  from sm_menu_hdr  where MENU_ID='" + common.trim() + "'";
					rootrset=rootstmt.executeQuery(rootsql);
					if(rootrset.next())
					{
						root_yn = rootrset.getString(1);
					}
					if(rootrset!=null)rootrset.close();
					if(rootstmt!=null)rootstmt.close();

				String countsql="select count(*) from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "'";
				rset1=stmt1.executeQuery(countsql);
				if(rset1.next())
				{
				 row=rset1.getInt(1);
				array=new String[row][7];
				if(rset1!=null)rset1.close();
				
				}

				String sql = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor,insert_access_yn||update_access_yn||delete_access_yn||query_only_access_yn||print_access_yn access1 from Sm_Menu_Dtl where Menu_Id='" + common.trim() + "'";
				if(stmt1!=null) stmt1.close();
				stmt1 = con.createStatement();
				rset = stmt1.executeQuery(sql);
		   		%>
				<html>
					<HEAD>
						<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
						</link> -->
						<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
					</HEAD>
					<body CLASS='MESSAGE'onKeyDown = 'lockKey()'>
					<form name='nam1' id='nam1'>
				<%
				if(rset != null)
				{
					 row=0;
				        while( rset.next() ) 
						{
							array[row][0]=rset.getString(1);
							array[row][1]=rset.getString(2);
							array[row][2]=rset.getString(3);
							array[row][3]=rset.getString(4);
							array[row][4]=rset.getString(5);
							array[row][5]=rset.getString(6);
							array[row][6]=rset.getString(7);
							row++;
						}
					
					}
					if(rset!=null)rset.close();
					if(stmt1!=null) stmt1.close();
					
					String sql1 = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor,insert_access_yn||update_access_yn||delete_access_yn||query_only_access_yn||print_access_yn access1  from Sm_Menu_Dtl where Menu_Id=? order by option_sequence_no,srl_no";
					
					pstmt1 = con.prepareStatement(sql1);


					String subsql = "select menu_id,option_type,module_id,function_id,submenu_id,option_descriptor,insert_access_yn||update_access_yn||delete_access_yn||query_only_access_yn||print_access_yn access1  from Sm_Menu_Dtl where Menu_Id=? order by option_sequence_no,srl_no";
					
					pstmt2 = con.prepareStatement(subsql);
					
					for(int i=0;i<array.length;i++)
					{

						menu_id = array[i][0]==null ? "" : array[i][0];
						option_type = array[i][1]==null ? "" : array[i][1];
						module_id = array[i][2]==null ? "" : array[i][2];
						function_id = array[i][3]==null ? "" : array[i][3];
						submenu_id = array[i][4]==null ? "" : array[i][4];
						option_descriptor = array[i][5]==null ? "" : array[i][5];
						access1 = array[i][6]==null ? "" : array[i][6];
					%>	<script>
						var rootyn= '<%=root_yn%>';
						var spc="" ;
	
						parent.frames[1].frames[1].document.forms[0].root_menu.value = rootyn;
						var opt=parent.frames[1].frames[1].document.createElement("OPTION");
						var opt_type="<%=option_type%>";
						var access1="<%=access1%>";
						if(parent.frames[1].frames[1].document.forms[0].root_menu.value == 'N')
								spc="              " ;
						if(opt_type=="F") opt.text= spc  +  "<%=option_descriptor%>" ;
						else opt.text= spc  +"<%=option_descriptor%>" ;
						opt.value="<%=menu_id%>" + "#" + "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "<%=submenu_id%>" + "#" + opt_type +"#"+access1+"#"+"<%=option_descriptor%>";
						parent.frames[1].frames[1].document.forms[0].Menu.add(opt);
					</script>
<%
					String colour = "";
					pstmt1.setString(1,submenu_id.trim());
					rset1=pstmt1.executeQuery();
					if(rset1 != null) {
						while( rset1.next() ) {
							menu_id = rset1.getString( "menu_id" )==null ? "" :  rset1.getString( "menu_id" );
							option_type = rset1.getString( "option_type" )==null ? "" :  rset1.getString( "option_type" );
							module_id = rset1.getString("module_id")==null ? "" : rset1.getString("module_id");
							function_id = rset1.getString("function_id")==null ? "" : rset1.getString("function_id");
							submenu_id = rset1.getString("submenu_id")==null ? "" : rset1.getString("submenu_id");
							option_descriptor = rset1.getString( "option_descriptor" )==null ? "" : rset1.getString( "option_descriptor" );
							access1 = rset1.getString( "access1" )==null ? "" : rset1.getString( "access1" );

							if(submenu_id == null || submenu_id.equals(""))
								colour = "";
							else{
								colour="RED";
								option_type="S";
							}
%>
							<script>

								var spc="          ";
								var opt=parent.frames[1].frames[1].document.createElement("OPTION");
								if(parent.frames[1].frames[1].document.forms[0].root_menu.value == 'N')
								spc="                        ";
								var opt_type="<%=option_type%>";
								var access1="<%=access1%>";
								if(opt_type=="F") opt.text= spc +  "<%=option_descriptor%>" ;
								else opt.text=spc +"<%=option_descriptor%>" ;
								opt.style.color="<%=colour%>";
								opt.value="<%=menu_id%>" + "#" + "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "<%=submenu_id%>" + "#" + opt_type +"#"+access1+"#"+"<%=option_descriptor%>";
								opt.id='t2';
								parent.frames[1].frames[1].document.forms[0].Menu.add(opt);
							</script>
<%
								
								while(!(submenu_id.equals("") || submenu_id == null ))
								{
																	
									pstmt2.setString(1,submenu_id.trim());
					                rset2=pstmt2.executeQuery();
									if(rset2 != null) {
										while( rset2.next() ) {
											menu_id = rset2.getString( "menu_id" )==null ? "" :  rset2.getString( "menu_id" );
											option_type = rset2.getString( "option_type" )==null ? "" :  rset2.getString( "option_type" );
											module_id = rset2.getString("module_id")==null ? "" : rset2.getString("module_id");
											function_id = rset2.getString("function_id")==null ? "" : rset2.getString("function_id");
											submenu_id = rset2.getString("submenu_id")==null ? "" : rset2.getString("submenu_id");
											option_descriptor = rset2.getString( "option_descriptor" )==null ? "" : rset2.getString( "option_descriptor" );
											access1 = rset2.getString("access1")==null ? "" : rset2.getString("access1");
											if(!(submenu_id == null || submenu_id.equals("")))
											{ %> <script>spc+="              ";</script><%}

				%>
											<script>
												var opt=parent.frames[1].frames[1].document.createElement("OPTION");
												var opt_type="<%=option_type%>";
												var access1="<%=access1%>";
												if(opt_type=="F") opt.text= spc +"              "+ "<%=option_descriptor%>" ;
												else opt.text=spc+"<%=option_descriptor%>" ;
												opt.value="<%=menu_id%>" + "#" + "<%=module_id%>" + "#" + "<%=function_id%>" + "#" + "<%=submenu_id%>" + "#" + opt_type +"#"+access1+"#"+"<%=option_descriptor%>";												parent.frames[1].frames[1].document.forms[0].Menu.add(opt);
											</script>
				<%
										}
									}if(rset2!=null)rset2.close();
									
									

				%> <script>spc+="              ";</script><%
								}
						}
					
					
					}if(rset1!=null)rset1.close();
					}
					if(pstmt1 !=null) pstmt1.close();
					if(pstmt2 !=null) pstmt2.close();
			%>
		</form>
				</body>
					</html>
			 <%
			}

			if(stmt1!=null) stmt1.close();
			if(rootstmt!=null) rootstmt.close();
			if(stmt_resp!=null) stmt_resp.close();
		}catch(Exception e){
			out.println(e);
            e.printStackTrace();
			}
			finally { 
		ConnectionManager.returnConnection(con,request);
}
%>

