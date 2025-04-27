<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.io.*,webbeans.eCommon.*" %>
<html><head>
<script src='../js/ValidateControl.js' language='javascript'></script>
<%
	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script type='text/javascript' src='../../eCommon/js/dtree.js'></script></head>
<div class='freqdtree'>

<body class='NavigIconsBorderTop' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> 
<script type='text/javascript'>
	<!--
	d = new dTree('d');
	d.config.useStatusText=true;
	d.add(0,-1,'<b>Frequently Accessed List</b>');
<% 
boolean recordExists = false;
ResultSet funcStrnRset=null;
Connection conn		= ConnectionManager.getConnection();

try{
	request.setCharacterEncoding("UTF-8");
	String locale					= (String)session.getAttribute("LOCALE");
	int plevel = 0;
	String p_level = "";
	String menu_id = "";
	String option_type =""; 
	String submenu_id = "";
	String option_descriptor = "";
	String executable_name = "";
	String function_id  = "";
	String insert_access_yn = "";
	String update_access_yn = "";
	String query_only_access_yn = "";
	String delete_access_yn = "";
	String print_access_yn = "";
	String function_type = "";
	String module_id = "";
	String executable  = "";	
	//String sRespName	="";
	String responsibility_id    =  (String) session.getAttribute( "responsibility_id" ) ;
	String userId =  (String) session.getAttribute( "login_user" ) ;

	StringBuffer sMenu = new StringBuffer();
	Statement stmtResp	=null;	

	String findMenu = "select menu_id,RESP_NAME from sm_resp where resp_id = '"+responsibility_id+"'";
	try{
			stmtResp=conn.createStatement ();
	}catch(SQLException sqlEx)
	{
	}
	
	ResultSet rsetFunc =stmtResp.executeQuery (findMenu);

	while(rsetFunc.next())
	{
		menu_id = rsetFunc.getString("menu_id");
	}
	rsetFunc.close();

	String restrnsql = " select EXCL_RESTRICT_IND ,INSERT_ACCESS_YN ,UPDATE_ACCESS_YN  ,DELETE_ACCESS_YN  ,PRINT_ACCESS_YN  ,QUERY_ONLY_ACCESS_YN  from sm_menu_rstrn_resp  where resp_id =?  and menu_id = ?   and module_id = ?  and function_id = ?";
	
	PreparedStatement funcStrnStmt = conn.prepareStatement( restrnsql ) ;
	funcStrnStmt.setString(1,responsibility_id) ;
	funcStrnStmt.setString(2,menu_id) ;


	String sql =  "SELECT   menu_dtl.p_level,"+
					 "          menu_dtl.menu_id menu_id,"+
					 "          menu_dtl.submenu_id submenu_id,"+
					 "          menu_dtl.option_type,"+
					 "          nvl( (SELECT option_descriptor FROM sm_menu_dtl_lang WHERE menu_id = menu_dtl.menu_id AND  option_sequence_no = menu_dtl.option_sequence_no AND  language_id = '"+locale+"'),menu_dtl.option_descriptor)  option_descriptor,"+
					 "          menu_dtl.function_id function_id,"+
					 "          menu_dtl.module_id module_id,"+
					 "          menu_dtl.insert_access_yn insert_access_yn,"+
					 "          menu_dtl.update_access_yn update_access_yn,"+
					 "          menu_dtl.delete_access_yn delete_access_yn,"+
					 "          menu_dtl.print_access_yn print_access_yn,"+
					 "          menu_dtl.query_only_access_yn query_only_access_yn,"+
					 "          sm_function.executable_name executable_name,"+
					 "          sm_function.function_type function_type"+
					 " FROM     sm_menu_hdr menu_hdr,"+
					 "          (SELECT   LEVEL p_level,"+
					 "                    menu_id,"+
					 "                    submenu_id,"+
					 "                    option_type,"+
					 "                    option_descriptor,"+
					 "                    function_id,"+
					 "                    module_id,"+
					 "                    insert_access_yn,"+
					 "                    update_access_yn,"+
					 "                    delete_access_yn,"+
					 "                    print_access_yn,"+
					 "                    query_only_access_yn,"+
					 "                    option_sequence_no,"+
					 "                    srl_no"+
					 "           FROM     sm_menu_dtl"+
					 "           CONNECT BY PRIOR submenu_id = menu_id"+
					 "           ORDER BY ROWNUM) menu_dtl,"+
					 "          sm_module module,"+
					 "          sm_function sm_function"+
					 " WHERE    menu_dtl.p_level = 1"+
					 "          AND menu_dtl.menu_id = menu_hdr.menu_id"+
					 "          AND menu_dtl.module_id = module.module_id (+) "+
					 "          AND sm_function.module_id (+)  = menu_dtl.module_id"+
					 "          AND sm_function.function_id (+)  = menu_dtl.function_id"+
					 "          AND (menu_dtl.function_id,menu_dtl.menu_id) IN (SELECT function_id,menu_id "+
					 "                                       FROM   sm_freq_func_by_user_vw"+
					 "                                       WHERE  appl_user_id = '"+userId+"'"+
					 "                                              AND resp_id = '"+responsibility_id+"')"+
					 "          AND submenu_id IS NULL "+
					 " ORDER BY menu_dtl.option_sequence_no,"+
					 "          menu_dtl.srl_no";
	
	
//	out.println(sql);
	rsetFunc	= stmtResp.executeQuery( sql ) ;
	int prnt		=1;
	int genCtr		=1;


	 while(rsetFunc.next())
		  {
		 recordExists = true;
			funcStrnStmt.setString(3,rsetFunc.getString( "module_id" ) );
				funcStrnStmt.setString(4,rsetFunc.getString( "function_id" ) );
				 funcStrnRset = funcStrnStmt.executeQuery();

				boolean construct = true ;
				boolean alreadyFetched =false;

				if(funcStrnRset.next()) {
                if(funcStrnRset.getString("EXCL_RESTRICT_IND").equals("E"))
                    construct = false;
					
				else{
						alreadyFetched =true;
						insert_access_yn = funcStrnRset.getString("insert_access_yn");         
						update_access_yn = funcStrnRset.getString("update_access_yn");         
						query_only_access_yn = funcStrnRset.getString("query_only_access_yn"); 
						delete_access_yn = funcStrnRset.getString("delete_access_yn");         
						print_access_yn = funcStrnRset.getString("print_access_yn");           

						executable  =       "" +    executable_name     +
										"?module_id="   + module_id     +
										"&function_id=" + function_id   +
										"&function_name=" + option_descriptor   +
										"&function_type="   + function_type +
										"&menu_id="+ menu_id +
										"&access=" +    insert_access_yn    +
													update_access_yn    +
													query_only_access_yn +
													delete_access_yn    +
													print_access_yn     +
									   ""  ;

						sMenu.append("d.add("+ genCtr + ","+prnt+",0',\"javascript:selectLink('"+executable+"')\",'"+rsetFunc.getString(5)+"');");
					out.println ("d.add("+ genCtr + ",0,'"+rsetFunc.getString(5)+"',\"javascript:selectLink('"+executable+"')\" );");
					}
					funcStrnRset.close();
				}
				if(funcStrnRset !=null) funcStrnRset.close();
				if(!alreadyFetched) {
				p_level = rsetFunc.getString( "p_level" );
				plevel = Integer.parseInt(p_level);
				menu_id = rsetFunc.getString( "menu_id" ) ;
				option_type = rsetFunc.getString( "option_type" ) ;
				submenu_id = rsetFunc.getString( "submenu_id" ) ;
				option_descriptor = rsetFunc.getString( "option_descriptor" ) ;
				executable_name = rsetFunc.getString( "executable_name" ) ;
				function_id  = rsetFunc.getString("function_id");
				insert_access_yn = rsetFunc.getString("insert_access_yn");
				update_access_yn = rsetFunc.getString("update_access_yn");
				query_only_access_yn = rsetFunc.getString("query_only_access_yn");
				delete_access_yn = rsetFunc.getString("delete_access_yn");
				print_access_yn = rsetFunc.getString("print_access_yn");
				function_type = rsetFunc.getString("function_type");
				module_id = rsetFunc.getString("module_id");
				executable  = 		"" +	executable_name		+	"?module_id="	+ module_id		+"&function_id="	+ function_id 	+"&function_name=" + option_descriptor 	+"&function_type="	+ function_type	+"&access=" + 	insert_access_yn	+update_access_yn 	+query_only_access_yn +	delete_access_yn 	+print_access_yn 	+""  ;

			 sMenu.append("d.add("+  genCtr + ","+0+",'"+rsetFunc.getString(5)+"',\"javascript:selectLink('"+executable+"')\",'"+rsetFunc.getString(5)+"','');");
				out.println ("d.add("+  genCtr + ","+0+",'"+rsetFunc.getString(5)+"',\"javascript:selectLink('"+executable+"')\",'');");

			  genCtr++;
			  }
		}
	rsetFunc.close() ;
	stmtResp.close() ;

	funcStrnStmt.close();
	if(funcStrnRset !=null) funcStrnRset.close();
	if(!recordExists) {
	
	%>
			alert(top.header.getMessage("FREQ_ACCESS_NOT_AVAILABLE","SM"));
			document.location.href="about:blank"
			//parent.toolFunction(4);

	<%
	}
}
catch(Exception e){e.printStackTrace();}
  finally {
		ConnectionManager.returnConnection(conn);
  }

%>

document.write(d);

</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
</div>

</body> </html>

