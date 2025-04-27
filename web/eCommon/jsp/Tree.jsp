<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.io.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
	<%
		int plevel = 0;
		int prnt		=1;
		int genCtr		=1;
		int lvl1		=1;
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
		StringBuffer executableBfr	= new StringBuffer("");	
		StringBuffer tempString	= new StringBuffer("");	
		String sRespName	="";
		String desktopFlag = "";
		String locale = (String)session.getAttribute("LOCALE");
		String restrnexists ="N";
		int restrnexistscount = 0;
		int ds_count=0;
		// below 2 lines added on 9th Apr 2010 for integra demo
		//String executable_name_integra = "";
		//String function_id_integra  = "";
		request.setCharacterEncoding("UTF-8");
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String responsibility_id=(String) session.getValue( "responsibility_id" ) ;
		String desktop_code="" ;
		desktop_code=(String) session.getValue( responsibility_id ) ;
		String selectLink = "selectLink";
		if(desktop_code!=null) {
			selectLink = "selectLinkUser";	
		} else  {
			selectLink = "selectLink";
		}

	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script type='text/javascript' src='../../eCommon/js/dtree.js'></script></head>
	<script src='../../eCommon/js/common.js' language='javascript'></script>

	<script>
		function changeTree(toggleButton) {
			if(toggleButton.id == 'toggleTreeExpand') {
				d.openAll();
				document.getElementById('exp_collapse_img').innerHTML="<IMG style='cursor:pointer' id = 'toggleTreeCollapse' SRC='../images/close-all.gif'  BORDER=0 ALT=\"<fmt:message key='Common.closeAll.label' bundle='${common_labels}'/>\" onClick=javascript:changeTree(this)>";
			} else if(toggleButton.id == 'toggleTreeCollapse') {
				d.closeAll();
				document.getElementById('exp_collapse_img').innerHTML="<IMG SRC='../images/expand-all.gif' id='toggleTreeExpand' style='cursor:pointer' BORDER='0' ALT=\"<fmt:message key='Common.openAll.label' bundle='${common_labels}'/>\" onClick=javascript:changeTree(this);>";
			}

		}
	</script>

	<STYLE TYPE="text/CSS">
		/* This style is used for locking the table's heading  */
		div#tree_tbl {
			height: 95%;
			width: 100%;
			overflow: auto;
			position: absolute;
		}

	</STYLE>

	<%
		//System.out.println("Menu Tree form started.");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rsetResp = null;
		ResultSet funcStrnRset = null;
		ResultSet rsetFunc = null;
		ResultSet rsetFunc1 = null;
		ResultSet rsetMain = null;
		ResultSet restrnRset = null;
		ResultSet rsetSub = null;
		PreparedStatement stmtSub = null;
		PreparedStatement funcStrnStmt = null;
		PreparedStatement restrnStmt = null;
		PreparedStatement stmtFunc1 = null;
		PreparedStatement stmtMain = null;
		PreparedStatement stmtFunc = null;	
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		try{
			String respId		= (String) session.getValue("responsibility_id");
			String login_user	= (String) session.getValue("login_user");
			String sParam=respId;		
			String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	%>
	</HEAD>
	<body class='deskTopBorder' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<%
		if(desktop_code!=null){
			desktopFlag ="Y";
	%>
			<table width="100%" cellspacing='0' cellpadding='0' border='0' Height = '20' valign='top'>
				<tr class='slideActive'>
					<td width="80%"><fmt:message key="eSM.Navigation.label" bundle="${sm_labels}"/></td>                     
					<td align='right' id = 'exp_collapse_img'>
						<IMG SRC="../images/expand-all.gif" style="cursor:pointer"	 BORDER='0' ALT='<fmt:message key="Common.openAll.label" bundle="${common_labels}"/>' id='toggleTreeExpand' onClick="javascript:changeTree(this);">
					</td>
				</tr>   
			</table>			
			<div id='tree_tbl'>
	<%
		}else{
			desktopFlag ="N";
	%>
		<div class='dtree'>
	<%	
		} 
	%>
		<script type='text/javascript'>
			d = new dTree('d');
			d.config.useStatusText=true;
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<!-- <body class='TREEBODY' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>  -->
		<script>
	<%
		/*String findMenu = "select menu_id, resp_name from sm_resp_lang_vw where resp_id='"+sParam+"' and language_id = '"+locale+"'";	
		Statement stmtResp=con.createStatement ();
		rsetResp =stmtResp.executeQuery (findMenu);
		while(rsetResp.next())
		{
			sParam = rsetResp.getString("menu_id");
			sRespName =  rsetResp.getString("RESP_NAME");
			
		}
		rsetResp.close();
		stmtResp.close();
		//added by sri 9/4/2007
		findMenu = "select count(1)  from sm_menu_rstrn_resp  where resp_id = '"+respId+"'";
		stmtResp=con.createStatement ();
		rsetResp =stmtResp.executeQuery (findMenu);
		if (rsetResp != null && rsetResp.next())
		{
			restrnexistscount = rsetResp.getInt(1);					
		}

		if (restrnexistscount>0) restrnexists = "Y";
		if(login_user.equals("SYSADMIN")){
			restrnexists = "N";
		}
		//end added by sri 9/4/2007			
		if (rsetResp!= null) rsetResp.close();
		if (stmtResp!= null) stmtResp.close();*/			
		// added for performance tuning
		String findMenu = "select menu_id, resp_name,(select count(1)  from sm_menu_rstrn_resp  where resp_id = ?)rest_count from sm_resp_lang_vw where resp_id=? and language_id = ?";
		pstmt = con.prepareStatement(findMenu);
		pstmt.setString(1,respId);
		pstmt.setString(2,sParam);
		pstmt.setString(3,locale);
		rSet = pstmt.executeQuery();
		if(rSet!=null && rSet.next()){
			sParam = rSet.getString("menu_id");
			sRespName =  rSet.getString("RESP_NAME");
			restrnexistscount = rSet.getInt("rest_count");		
		}
		if (restrnexistscount>0) restrnexists = "Y";
		if(login_user.equals("SYSADMIN")){
			restrnexists = "N";
		}
		out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
		String mainSql ="SELECT menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type,(CASE WHEN menu_dtl.submenu_id is not null THEN sm_get_desc.SM_MENU_HDR(menu_dtl.submenu_id,?,'1') ELSE menu_dtl.option_descriptor END) option_descriptor,  menu_dtl.function_id function_id, (SELECT executable_name FROM sm_function    WHERE module_id = menu_dtl.module_id AND function_id = menu_dtl.function_id) executable_name, menu_dtl.option_sequence_no   FROM sm_menu_hdr menu_hdr, (SELECT LEVEL p_level, menu_id, submenu_id, function_id, module_id, option_type, option_sequence_no, NVL((SELECT option_descriptor FROM sm_menu_dtl_lang WHERE menu_id = sm_menu_dtl.menu_id AND option_sequence_no = sm_menu_dtl.option_sequence_no AND language_id = ?), sm_menu_dtl.option_descriptor) option_descriptor FROM sm_menu_dtl CONNECT BY PRIOR submenu_id = menu_id START WITH menu_id = ?) menu_dtl WHERE menu_dtl.menu_id = menu_hdr.menu_id AND submenu_id IS NOT NULL AND menu_dtl.p_level = 1 ORDER BY option_sequence_no, p_level";
		String funcSql 	= "SELECT   menu_dtl.p_level, menu_dtl.menu_id menu_id,menu_dtl.submenu_id submenu_id, menu_dtl.option_type,(CASE WHEN menu_dtl.submenu_id is not null THEN sm_get_desc.SM_MENU_HDR(menu_dtl.submenu_id,?,'1') ELSE menu_dtl.option_descriptor END) option_descriptor,  menu_dtl.function_id function_id, menu_dtl.module_id module_id, menu_dtl.insert_access_yn insert_access_yn, menu_dtl.update_access_yn update_access_yn, menu_dtl.delete_access_yn delete_access_yn, menu_dtl.print_access_yn print_access_yn, menu_dtl.query_only_access_yn query_only_access_yn, (SELECT executable_name FROM sm_function WHERE module_id = menu_dtl.module_id AND function_id = menu_dtl.function_id) executable_name, menu_dtl.option_type function_type FROM sm_menu_hdr menu_hdr, (SELECT LEVEL p_level, menu_id, submenu_id, option_type, NVL((SELECT option_descriptor FROM sm_menu_dtl_lang WHERE menu_id = sm_menu_dtl.menu_id AND option_sequence_no = sm_menu_dtl.option_sequence_no AND language_id = ?), sm_menu_dtl.option_descriptor ) option_descriptor, function_id, module_id, insert_access_yn, update_access_yn, delete_access_yn, print_access_yn, query_only_access_yn, option_sequence_no, srl_no FROM sm_menu_dtl CONNECT BY PRIOR submenu_id = menu_id START WITH menu_id = ? ORDER BY ROWNUM) menu_dtl WHERE menu_dtl.p_level = 1 AND menu_dtl.menu_id = menu_hdr.menu_id AND submenu_id IS NULL ORDER BY menu_dtl.option_sequence_no, menu_dtl.srl_no";
		String funrstrnsql = "select EXCL_RESTRICT_IND ,INSERT_ACCESS_YN ,UPDATE_ACCESS_YN  ,DELETE_ACCESS_YN  ,PRINT_ACCESS_YN  ,QUERY_ONLY_ACCESS_YN  from sm_menu_rstrn_resp  where resp_id =?  and menu_id = ?   and module_id = ?  and function_id = ?" ;
		funcStrnStmt = con.prepareStatement( funrstrnsql ) ;
		funcStrnStmt.setString(1,respId) ;
		//funcStrnStmt.setString(2,sParam) ;  Friday, January 22, 2010 18274
		String restrnsql = " select EXCL_RESTRICT_IND from sm_menu_rstrn_resp where resp_id =? and menu_id =? and submenu_id =?";
		restrnStmt = con.prepareStatement( restrnsql ) ;
		if(login_user.equals("SYSADMIN")){
			restrnStmt.setString(1,"");
		}else{
			restrnStmt.setString(1,respId);
		}
		restrnStmt.setString(2,sParam);				
		stmtFunc1 = con.prepareStatement(funcSql);
		stmtFunc1.setString(1,locale) ;
		stmtFunc1.setString(2,locale) ;
		stmtFunc1.setString(3,sParam) ;
		rsetFunc1 	= stmtFunc1.executeQuery();
		while(rsetFunc1.next()){
			p_level = rsetFunc1.getString( "p_level" );
			plevel = Integer.parseInt(p_level);
			menu_id = rsetFunc1.getString( "menu_id" ) ;
			option_type = rsetFunc1.getString( "option_type" ) ;
			submenu_id = rsetFunc1.getString( "submenu_id" ) ;
			option_descriptor = rsetFunc1.getString( "option_descriptor" ) ;				
			executable_name = rsetFunc1.getString( "executable_name" ) ;
			function_id  = rsetFunc1.getString("function_id");
			// below 2 lines added on 9th Apr 2010 for integra demo
			//if(function_id.length()>=11){
				//function_id_integra  = function_id.substring(0,11);
			//}
			//executable_name_integra  = executable_name;

			// block to handle meal rejection count --ML-MMOH-CRF-0685
			//DS_MEAL_COMPLAINTS_NOTIF  -  2
			if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
				PreparedStatement pstmt_ds = null;
				ResultSet rSet_ds = null;
				
				try{
					pstmt_ds = con.prepareStatement("select ds_meal_rej_cnt(?,?) reject_cnt from dual");
					pstmt_ds.setString(1,facilityId) ;

					if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF")){
						pstmt_ds.setString(2,"1") ;
					}else{
						pstmt_ds.setString(2,"2") ;
					}

					rSet_ds = pstmt_ds.executeQuery();
					if(rSet_ds!=null && rSet_ds.next()){
						ds_count = rSet_ds.getInt("reject_cnt");		
					}
				}catch(Exception ex){
				}finally {
					if(rSet_ds!=null)rSet_ds.close();
					if(pstmt_ds!=null)pstmt_ds.close();
				}								
			}
			

			insert_access_yn = rsetFunc1.getString("insert_access_yn");
			update_access_yn = rsetFunc1.getString("update_access_yn");
			query_only_access_yn = rsetFunc1.getString("query_only_access_yn");
			delete_access_yn = rsetFunc1.getString("delete_access_yn");
			print_access_yn = rsetFunc1.getString("print_access_yn");
			function_type = rsetFunc1.getString("function_type");
			module_id = rsetFunc1.getString("module_id");
			boolean construct = true ;
			boolean alreadyFetched =false;
			if(restrnexists.equals("Y")){
				funcStrnStmt.setString(2,rsetFunc1.getString( "menu_id" ) );// 18274  Friday, January 22, 2010
				funcStrnStmt.setString(3,rsetFunc1.getString( "module_id" ) );
				funcStrnStmt.setString(4,rsetFunc1.getString( "function_id" ) );
				funcStrnRset = funcStrnStmt.executeQuery();
				if(funcStrnRset.next()){
					if(funcStrnRset.getString("EXCL_RESTRICT_IND").equals("E")){
						construct = false;
					}else{
						alreadyFetched =true;
						insert_access_yn = funcStrnRset.getString("insert_access_yn");         
						update_access_yn = funcStrnRset.getString("update_access_yn");         
						query_only_access_yn = funcStrnRset.getString("query_only_access_yn"); 
						delete_access_yn = funcStrnRset.getString("delete_access_yn");         
						print_access_yn = funcStrnRset.getString("print_access_yn");						
						if(executable_name.indexOf("?")==-1){
							/*executable  =       "" +    executable_name     +
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
									   "&desktopFlag="+desktopFlag+""  ;*/
							executableBfr.append("").append(executable_name);
							executableBfr.append("?module_id=").append(module_id);
							executableBfr.append("&function_id=").append(function_id);
							executableBfr.append("&function_name=").append(option_descriptor);
							executableBfr.append("&function_type=").append(function_type);
							executableBfr.append("&menu_id=").append(menu_id);
							executableBfr.append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn);
							executableBfr.append("&desktopFlag=").append(desktopFlag);
						}else{
							/*executable  =       "" +    executable_name     +
										"&module_id="   + module_id     +
										"&function_id=" + function_id   +
										"&function_name=" + option_descriptor   +
										"&function_type="   + function_type +
										"&menu_id="+ menu_id +
										"&access=" +    insert_access_yn    +
													update_access_yn    +
													query_only_access_yn +
													delete_access_yn    +
													print_access_yn     +
									   "&desktopFlag="+desktopFlag+""  ;*/										   
							executableBfr.append("").append(executable_name);
							executableBfr.append("&module_id=").append(module_id);
							executableBfr.append("&function_id=").append(function_id);
							executableBfr.append("&function_name=").append(option_descriptor);
							executableBfr.append("&function_type=").append(function_type);
							executableBfr.append("&menu_id=").append(menu_id);
							executableBfr.append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn);
							executableBfr.append("&desktopFlag=").append(desktopFlag);
						}						
						// if condition added on 9th Apr 2010 for integra demo
						//if(function_id_integra.equals("SM_INTEGRA_")){
							//out.println ("d.add("+ genCtr + ",0,'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executable_name_integra+"','"+function_id_integra+"')\" );");
						//}else{
							//out.println ("d.add("+ genCtr + ",0,'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executable+"','"+function_id+"')\" );");
							//out.println ("d.add("+ genCtr + ",0,'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executableBfr.toString()+"','"+function_id+"')\" );");
							tempString.setLength(0);
							// block to handle meal rejection count --ML-MMOH-CRF-0685
							if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
								tempString.append("d.add(").append(genCtr).append(",0,'").append(rsetFunc1.getString(5)).append("(").append(ds_count).append(")").append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(function_id).append("')\" );");
							}else{
								tempString.append("d.add(").append(genCtr).append(",0,'").append(rsetFunc1.getString(5)).append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(function_id).append("')\" );");
							}
							
							out.println(tempString.toString());
						//}
						//System.out.println("AA");
					}
					//funcStrnRset.close();
					//Commented by Muthu for ICN IN013564
					//executable="" ;
					//End of Comment
				}
				if(funcStrnRset !=null) funcStrnRset.close();
			}
			if(!alreadyFetched && construct){
				if(executable_name.indexOf("?")==-1){
					executableBfr.setLength(0);
					//executable  = executable_name+"?menu_id="+sParam+"&module_id="	+ module_id		+"&function_id="	+ function_id 	+"&function_name=" + option_descriptor 	+"&function_type="	+ function_type	+"&access=" + 	insert_access_yn	+update_access_yn 	+query_only_access_yn +	delete_access_yn 	+print_access_yn ;
					executableBfr.append(executable_name).append("?menu_id=").append(sParam).append("&module_id=").append(module_id).append("&function_id=").append(function_id).append("&function_name=").append(option_descriptor).append("&function_type=").append(function_type).append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn);
				}else{
					executableBfr.setLength(0);
					//executable  = executable_name+"&menu_id="+sParam+"&module_id="	+ module_id		+"&function_id="	+ function_id 	+"&function_name=" + option_descriptor 	+"&function_type="	+ function_type	+"&access=" + 	insert_access_yn	+update_access_yn 	+query_only_access_yn +	delete_access_yn 	+print_access_yn +"&desktopFlag="+desktopFlag+""  ;
					executableBfr.append(executable_name).append("&menu_id=").append(sParam).append("&module_id=").append(module_id).append("&function_id=").append(function_id).append("&function_name=").append(option_descriptor).append("&function_type=").append(function_type).append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn).append("&desktopFlag=").append(desktopFlag);
				}
				// if condition added on 9th Apr 2010 for integra demo
				//if(function_id_integra.equals("SM_INTEGRA_")){
					//out.println ("d.add("+ genCtr + ",0,'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executable_name_integra+"','"+rsetFunc1.getString(6)+"','"+function_id_integra+"')\" );");
				//}else{
					//out.println ("d.add("+ genCtr + ",0,'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executable+"','"+rsetFunc1.getString(6)+"','"+function_id+"')\" );");
					//out.println ("d.add("+ genCtr + ",0,'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executableBfr.toString()+"','"+rsetFunc1.getString(6)+"','"+function_id+"')\" );");
					tempString.setLength(0);
					// block to handle meal rejection count --ML-MMOH-CRF-0685
					if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
						tempString.append("d.add(").append(genCtr).append(",0,'").append(rsetFunc1.getString(5)).append("(").append(ds_count).append(")").append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(rsetFunc1.getString(6)).append("','").append(function_id).append("')\" );");
					}else{
						tempString.append("d.add(").append(genCtr).append(",0,'").append(rsetFunc1.getString(5)).append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(rsetFunc1.getString(6)).append("','").append(function_id).append("')\" );");
					}
					
					out.println(tempString.toString());
				//}
				//System.out.println("BB");
				//Commented by Muthu for ICN IN013564
				//genCtr++;					 
				//executable="" ;
				// End of Comment
			}
			//Added by Muthu for ICN IN013564
			genCtr++;					 
			executable="" ;
			executableBfr.setLength(0);
			// End				
		}
		stmtFunc1.close();
		rsetFunc1.close();
		stmtMain = con.prepareStatement(mainSql) ;
		stmtMain.setString(1,locale) ;
		stmtMain.setString(2,locale) ;
		stmtMain.setString(3,sParam) ;
		rsetMain 		= stmtMain.executeQuery ();
		while(rsetMain.next ()){
			if(rsetMain.getString(2).equals(sParam)){
				boolean construct  =true;
				restrnStmt.setString(2, rsetMain.getString("menu_id")) ;
				restrnStmt.setString(3, rsetMain.getString("submenu_id")) ;
				restrnRset = restrnStmt.executeQuery();
				if(restrnRset.next()){
					if(restrnRset.getString(1).equals("E")) construct  =false;
				}
				if(restrnRset !=null) restrnRset.close();
				if(construct) {
					//out.println ("d.add("+ genCtr + ",0,'"+rsetMain.getString (5)+"');");
					tempString.setLength(0);
					tempString.append("d.add(").append(genCtr).append(",0,'").append(rsetMain.getString (5)).append("');");
					out.println(tempString.toString());
					//System.out.println("CC");
					prnt 		= genCtr;
					genCtr++;
					stmtSub = con.prepareStatement(mainSql) ;
					stmtSub.setString(1,locale) ;
					stmtSub.setString(2,locale) ;
					stmtSub.setString(3,rsetMain.getString (3)) ;
					rsetSub	= stmtSub.executeQuery ();
					stmtFunc1 = con.prepareStatement(funcSql) ;
					stmtFunc1.setString(1,locale) ;
					stmtFunc1.setString(2,locale) ;
					stmtFunc1.setString(3,rsetMain.getString (3)) ;
					rsetFunc1	= stmtFunc1.executeQuery ();
					while(rsetFunc1.next()){
						p_level = rsetFunc1.getString( "p_level" );
						plevel = Integer.parseInt(p_level);
						menu_id = rsetFunc1.getString( "menu_id" ) ;
						option_type = rsetFunc1.getString( "option_type" ) ;
						submenu_id = rsetFunc1.getString( "submenu_id" ) ;
						option_descriptor =rsetFunc1.getString( "option_descriptor" );				
						executable_name = rsetFunc1.getString( "executable_name" ) ;
						function_id  = rsetFunc1.getString("function_id");
						// below lines  added on 9th Apr 2010 for integra demo
						//if(function_id.length()>11){
							//function_id_integra  = function_id.substring(0,11);
						//}
						//executable_name_integra  = executable_name;

						// block to handle meal rejection count --ML-MMOH-CRF-0685
						if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
							PreparedStatement pstmt_ds = null;
							ResultSet rSet_ds = null;
							
							try{
								pstmt_ds = con.prepareStatement("select ds_meal_rej_cnt(?,?) reject_cnt from dual");
								pstmt_ds.setString(1,facilityId) ;

								if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF")){
									pstmt_ds.setString(2,"1") ;
								}else{
									pstmt_ds.setString(2,"2") ;
								}
						
								rSet_ds = pstmt_ds .executeQuery();
								if(rSet_ds!=null && rSet_ds.next()){
									ds_count = rSet_ds.getInt("reject_cnt");		
								}
							}catch(Exception ex){
							}finally {
								if(rSet_ds!=null)rSet_ds.close();
								if(pstmt_ds!=null)pstmt_ds.close();
							}								
						}

						insert_access_yn = rsetFunc1.getString("insert_access_yn");
						update_access_yn = rsetFunc1.getString("update_access_yn");
						query_only_access_yn = rsetFunc1.getString("query_only_access_yn");
						delete_access_yn = rsetFunc1.getString("delete_access_yn");
						print_access_yn = rsetFunc1.getString("print_access_yn");
						function_type = rsetFunc1.getString("function_type");
						module_id = rsetFunc1.getString("module_id");
						 construct = true ;
						 boolean alreadyFetched =false;
						if(restrnexists.equals("Y")){				 
							funcStrnStmt.setString(2,rsetFunc1.getString( "menu_id" ) );//  18274  January 22, 2010
							funcStrnStmt.setString(3,rsetFunc1.getString( "module_id" ) );
							funcStrnStmt.setString(4,rsetFunc1.getString( "function_id" ) );
							funcStrnRset = funcStrnStmt.executeQuery();
							if(funcStrnRset.next()){
								if(funcStrnRset.getString("EXCL_RESTRICT_IND").equals("E")) {
									construct = false;
								}else{
									alreadyFetched =true;
									insert_access_yn = funcStrnRset.getString("insert_access_yn");         
									update_access_yn = funcStrnRset.getString("update_access_yn");         
									query_only_access_yn = funcStrnRset.getString("query_only_access_yn"); 
									delete_access_yn = funcStrnRset.getString("delete_access_yn");         
									print_access_yn = funcStrnRset.getString("print_access_yn");   
									if(executable_name.indexOf("?")==-1){
										executableBfr.setLength(0);
										/*executable  =       "" +    executable_name     +
												"?module_id="   + module_id     +
												"&function_id=" + function_id   +
												"&function_name="+option_descriptor+"&function_type="+ function_type +"&menu_id="+ menu_id +"&access=" +insert_access_yn +update_access_yn    +query_only_access_yn +delete_access_yn+	print_access_yn     +
											   "&desktopFlag="+desktopFlag+""  ;*/
										executableBfr.append("").append(executable_name).append("?module_id=").append(module_id).append("&function_id=").append(function_id).append("&function_name=").append(option_descriptor).append("&function_type=").append(function_type).append("&menu_id=").append(menu_id).append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn).append("&desktopFlag=").append(desktopFlag);
									}else{
										executableBfr.setLength(0);
										/*executable  =       "" +    executable_name     +
												"&module_id="   + module_id     +
												"&function_id=" + function_id   +
												"&function_name="+option_descriptor+"&function_type="+ function_type +"&menu_id="+ menu_id +"&access=" +insert_access_yn +update_access_yn    +query_only_access_yn +delete_access_yn+	print_access_yn     +
											   "&desktopFlag="+desktopFlag+""  ;*/
										executableBfr.append("").append(executable_name).append("&module_id=").append(module_id).append("&function_id=").append(function_id).append("&function_name=").append(option_descriptor).append("&function_type=").append(function_type).append("&menu_id=").append(menu_id +"&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn).append("&desktopFlag=").append(desktopFlag);
									}
									// if condition added on 9th Apr 2010 for integra demo

									//if(function_id_integra.equals("SM_INTEGRA_")){
										//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executable_name_integra+"','"+function_id_integra+"')\",'"+rsetFunc1.getString(5)+"','');");
									//}else{
										//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executable+"','"+function_id+"')\",'"+rsetFunc1.getString(5)+"','');");
										//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executableBfr.toString()+"','"+function_id+"')\",'"+rsetFunc1.getString(5)+"','');");
										tempString.setLength(0);
										// block to handle meal rejection count --ML-MMOH-CRF-0685
										if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
											tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetFunc1.getString(5)).append("(").append(ds_count).append(")").append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(function_id).append("')\",'").append(rsetFunc1.getString(5)).append("','');");
										}else{
											tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetFunc1.getString(5)).append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(function_id).append("')\",'").append(rsetFunc1.getString(5)).append("','');");
										}
										
										out.println(tempString.toString());									
									//}
									//System.out.println("DD");
								}
								//funcStrnRset.close();
								//Commented by Muthu for ICN IN013564
								//executable="" ;
								// End of Comment
							}
							if(funcStrnRset !=null) funcStrnRset.close();
						}
						if(!alreadyFetched &&  construct) {
							if(executable_name.indexOf("?")==-1){
								executableBfr.setLength(0);
								//executable  = executable_name+"?menu_id="+sParam+"&module_id="	+ module_id		+"&function_id="	+ function_id 	+"&function_name=" + option_descriptor 	+"&function_type="	+ function_type	+"&access=" + 	insert_access_yn	+update_access_yn 	+query_only_access_yn +	delete_access_yn 	+print_access_yn 	 +"&desktopFlag="+desktopFlag+""  ;
								executableBfr.append(executable_name).append("?menu_id=").append(sParam).append("&module_id=").append(module_id).append("&function_id=").append(function_id).append("&function_name=").append(option_descriptor).append("&function_type=").append(function_type).append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn).append("&desktopFlag=").append(desktopFlag);
							}else{
								executableBfr.setLength(0);
								//executable  = executable_name+"&menu_id="+sParam+"&module_id="	+ module_id		+"&function_id="	+ function_id 	+"&function_name=" + option_descriptor 	+"&function_type="	+ function_type	+"&access=" + 	insert_access_yn	+update_access_yn 	+query_only_access_yn +	delete_access_yn 	+print_access_yn 	  +"&desktopFlag="+desktopFlag+""  ;
								executableBfr.append(executable_name).append("&menu_id=").append(sParam+"&module_id=").append(module_id).append("&function_id=").append(function_id).append("&function_name=").append(option_descriptor).append("&function_type=").append(function_type).append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn).append("&desktopFlag=").append(desktopFlag);
							}
							// if condition added on 9th Apr 2010 for integra demo
							//if(function_id_integra.equals("SM_INTEGRA_")){
								//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executable_name_integra+"','"+function_id_integra+"')\",'"+rsetFunc1.getString(5)+"','');");	
							//}else{
								//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executable+"','"+function_id+"')\",'"+rsetFunc1.getString(5)+"','');");
								//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc1.getString(5)+"',\"javascript:"+selectLink+"('"+executableBfr.toString()+"','"+function_id+"')\",'"+rsetFunc1.getString(5)+"','');");
								tempString.setLength(0);
								// block to handle meal rejection count --ML-MMOH-CRF-0685
								if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
									tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetFunc1.getString(5)).append("(").append(ds_count).append(")").append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(function_id).append("')\",'").append(rsetFunc1.getString(5)).append("','');");
								}else{
									tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetFunc1.getString(5)).append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(function_id).append("')\",'").append(rsetFunc1.getString(5)).append("','');");
								}
								
								out.println(tempString.toString());
							//}
							//System.out.println("EE");
							//Commented by Muthu for ICN IN013564
							//genCtr++;
							//executable="" ;
							// End of Comment
						}
						//Added by Muthu for ICN IN013564
						genCtr++;
						executable="" ;
						executableBfr.setLength(0);
						//End 
					}
					lvl1=prnt;
					rsetFunc1.close();
					stmtFunc1.close() ;
					while(rsetSub.next()){
						construct  =true;
						restrnStmt.setString(2, rsetSub.getString("menu_id")) ;
						restrnStmt.setString(3, rsetSub.getString("submenu_id")) ;
						restrnRset = restrnStmt.executeQuery();
						if(restrnRset.next()){
							if(restrnRset.getString(1).equals("E")) construct  =false;
						}
						if(restrnRset!=null)restrnRset.close();
						if(construct){
								  prnt 		= lvl1;
								  //out.println ("d.add("+ genCtr + "," + prnt + ",'"+ rsetSub.getString(5)+"');");
								  tempString.setLength(0);
								  tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetSub.getString(5)).append("');");
								  out.println(tempString.toString());
								  //System.out.println("FF");
								  prnt 		= genCtr;
								  
								  genCtr++;
						}
						stmtFunc = con.prepareStatement(funcSql) ;
						stmtFunc.setString(1,locale) ;
						stmtFunc.setString(2,locale) ;
						stmtFunc.setString(3,rsetSub.getString(3)) ;
						rsetFunc	= stmtFunc.executeQuery ();				
						while(rsetFunc.next()){
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
							construct = true ;
							boolean alreadyFetched =false;

							// block to handle meal rejection count --ML-MMOH-CRF-0685
							if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
								PreparedStatement pstmt_ds = null;
								ResultSet rSet_ds = null;
								
								try{
									pstmt_ds = con.prepareStatement("select ds_meal_rej_cnt(?,?) reject_cnt from dual");
									pstmt_ds.setString(1,facilityId) ;

									if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF")){
										pstmt_ds.setString(2,"1") ;
									}else{
										pstmt_ds.setString(2,"2") ;
									}
							
									rSet_ds = pstmt_ds .executeQuery();
									if(rSet_ds!=null && rSet_ds.next()){
										ds_count = rSet_ds.getInt("reject_cnt");		
									}
								}catch(Exception ex){
								}finally {
									if(rSet_ds!=null)rSet_ds.close();
									if(pstmt_ds!=null)pstmt_ds.close();
								}								
							}

							if(restrnexists.equals("Y")){
								funcStrnStmt.setString(2,rsetFunc.getString( "menu_id" ) ); // January 22, 2010 18274
								funcStrnStmt.setString(3,rsetFunc.getString( "module_id" ) );
								funcStrnStmt.setString(4,rsetFunc.getString( "function_id" ) );
								funcStrnRset = funcStrnStmt.executeQuery();
								if(funcStrnRset.next()) {
									if(funcStrnRset.getString("EXCL_RESTRICT_IND").equals("E")){
										construct = false;
									}else{
										alreadyFetched =true;
										insert_access_yn = funcStrnRset.getString("insert_access_yn");         
										update_access_yn = funcStrnRset.getString("update_access_yn");         
										query_only_access_yn = funcStrnRset.getString("query_only_access_yn"); 
										delete_access_yn = funcStrnRset.getString("delete_access_yn");         
										print_access_yn = funcStrnRset.getString("print_access_yn");  										
										if(executable_name.indexOf("?")==-1){
											executableBfr.setLength(0);
											/*executable  =       "" +    executable_name     +
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
											"&desktopFlag="+desktopFlag+""  ;*/
											executableBfr.append("").append(executable_name);
											executableBfr.append("?module_id=").append(module_id);
											executableBfr.append("&function_id=").append(function_id);
											executableBfr.append("&function_name=").append(option_descriptor);
											executableBfr.append("&function_type=").append(function_type);
											executableBfr.append("&menu_id=").append(menu_id);
											executableBfr.append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn);
											executableBfr.append("&desktopFlag=").append(desktopFlag);
										}else{
											executableBfr.setLength(0);
											/*executable  =       "" +    executable_name     +
											"&module_id="   + module_id     +
											"&function_id=" + function_id   +
											"&function_name=" + option_descriptor   +
											"&function_type="   + function_type +
											"&menu_id="+ menu_id +
											"&access=" +    insert_access_yn    +
											update_access_yn    +
											query_only_access_yn +
											delete_access_yn    +
											print_access_yn     +
											"&desktopFlag="+desktopFlag+""  ;*/
											executableBfr.append("").append(executable_name);
											executableBfr.append("&module_id=").append(module_id);
											executableBfr.append("&function_id=").append(function_id);
											executableBfr.append("&function_name=").append(option_descriptor);
											executableBfr.append("&function_type=").append(function_type);
											executableBfr.append("&menu_id=").append(menu_id);
											executableBfr.append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn);
											executableBfr.append("&desktopFlag=").append(desktopFlag);
										}
										// if condition added on 9th Apr 2010 for integra demo
										//if(function_id_integra.equals("SM_INTEGRA_")){
											//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc.getString(5)+"',\"javascript:"+selectLink+"('"+executable_name_integra+"','"+function_id_integra+"')\",'"+rsetFunc.getString(5)+"','');");
										//}else{
											//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc.getString(5)+"',\"javascript:"+selectLink+"('"+executable+"','"+function_id+"')\",'"+rsetFunc.getString(5)+"','');");
											//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc.getString(5)+"',\"javascript:"+selectLink+"('"+executableBfr.toString()+"','"+function_id+"')\",'"+rsetFunc.getString(5)+"','');");
											tempString.setLength(0);
											// block to handle meal rejection count --ML-MMOH-CRF-0685
											if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
												tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetFunc.getString(5)).append("(").append(ds_count).append(")").append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(function_id).append("')\",'").append(rsetFunc.getString(5)).append("','');");
											}else{
												tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetFunc.getString(5)).append("',\"javascript:").append(selectLink).append("('").append(executableBfr.toString()).append("','").append(function_id).append("')\",'").append(rsetFunc.getString(5)).append("','');");
											}
											
											out.println(tempString.toString());										
										//}
										//System.out.println("GG");
									}
									//funcStrnRset.close();
								}
								if(funcStrnRset !=null) funcStrnRset.close();
							}
							if(!alreadyFetched && construct) {
								if(executable_name.indexOf("?")==-1){
									executableBfr.setLength(0);
									//executable  = 		"" +	executable_name		+	"?menu_id="+sParam+"&module_id="	+ module_id		+"&function_id="	+ function_id 	+"&function_name=" + option_descriptor 	+"&function_type="	+ function_type	+"&access=" + 	insert_access_yn	+update_access_yn 	+query_only_access_yn +	delete_access_yn 	+print_access_yn 	+""  ;
									executableBfr.append("").append(executable_name).append("?menu_id=").append(sParam).append("&module_id=").append(module_id).append("&function_id=").append(function_id).append("&function_name=").append(option_descriptor).append("&function_type=").append(function_type).append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn);
								}else{
									executableBfr.setLength(0);
									//executable  = 		"" +	executable_name		+	"&menu_id="+sParam+"&module_id="	+ module_id		+"&function_id="	+ function_id 	+"&function_name=" + option_descriptor 	+"&function_type="	+ function_type	+"&access=" + 	insert_access_yn	+update_access_yn 	+query_only_access_yn +	delete_access_yn 	+print_access_yn 	+"&desktopFlag="+desktopFlag+""  ;
									executableBfr.append("").append(executable_name).append("&menu_id=").append(sParam).append("&module_id=").append(module_id).append("&function_id=").append(function_id).append("&function_name=").append(option_descriptor).append("&function_type=").append(function_type).append("&access=").append(insert_access_yn).append(update_access_yn).append(query_only_access_yn).append(delete_access_yn).append(print_access_yn).append("&desktopFlag=").append(desktopFlag);
								}
								// if condition added on 9th Apr 2010 for integra demo
								//if(function_id_integra.equals("SM_INTEGRA_")){
									//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc.getString(5)+"',\"javascript:"+selectLink+"('"+executable_name_integra+"','"+function_id_integra+"')\",'"+rsetFunc.getString(5)+"','');");
								//}else{
									//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc.getString(5)+"',\"javascript:"+selectLink+"('"+executable+"','"+function_id+"')\",'"+rsetFunc.getString(5)+"','');");
									//out.println ("d.add("+ genCtr + ","+prnt+",'"+rsetFunc.getString(5)+"',\"javascript:"+selectLink+"('"+executableBfr.toString()+"','"+function_id+"')\",'"+rsetFunc.getString(5)+"','');");
									tempString.setLength(0);
									// block to handle meal rejection count --ML-MMOH-CRF-0685
									if(function_id.equals("DS_MEAL_REJECTIONS_NOTIF") || function_id.equals("DS_MEAL_COMPLAINTS_NOTIF") ){
										tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetFunc.getString(5)).append("(").append(ds_count).append(")").append("',\"javascript:").append(selectLink).append("('"+executableBfr.toString()).append("','").append(function_id).append("')\",'").append(rsetFunc.getString(5)).append("','');");
									}else{
										tempString.append("d.add(").append(genCtr).append(",").append(prnt).append(",'").append(rsetFunc.getString(5)).append("',\"javascript:").append(selectLink).append("('"+executableBfr.toString()).append("','").append(function_id).append("')\",'").append(rsetFunc.getString(5)).append("','');");
									}
									
									out.println(tempString.toString());
								//}
								//System.out.println("HH");
								//Commented by Muthu for ICN IN013564
								//genCtr++;
								// End of Commen
							}
							//Added by Muthu for ICN IN013564
							genCtr++;
							// End									
						 }
						if(rsetFunc !=null)rsetFunc.close();
						if(stmtFunc !=null)stmtFunc.close() ;
					}
					if(rsetSub !=null)rsetSub.close();
					if(stmtSub !=null )stmtSub.close();
				}
			}
		}
		rsetMain.close();
		stmtMain.close();
		restrnStmt.close() ;
		funcStrnStmt.close();
		executableBfr.setLength(0);
	%>

	<%}catch(Exception e) {
			out.println(e) ;
			e.printStackTrace() ;
		}finally{
			if(rsetResp != null) rsetResp.close();
			if(funcStrnRset != null) funcStrnRset.close();
			if(rsetFunc != null) rsetFunc.close();
			if(rsetFunc1 != null) rsetFunc1.close();
			if(rsetMain != null) rsetMain.close();
			if(restrnRset != null) restrnRset.close();
			if(rsetSub != null) rsetSub.close();

			if(stmtSub != null) stmtSub.close();
			if(funcStrnStmt != null) funcStrnStmt.close();
			if(restrnStmt != null) restrnStmt.close();
			if(stmtFunc1 != null) stmtFunc1.close();
			if(stmtMain != null) stmtMain.close();
			if(stmtFunc != null) stmtFunc.close();	
			if(rSet!=null)rSet.close();
			if(pstmt!=null)pstmt.close();
			ConnectionManager.returnConnection(con,request) ;			
		}
	%>
	document.write(d);
	d.closeAll();
	<%
		if(desktop_code==null) {
	%>
			parent.expand();
	<%
		}
	%>
	</script>			
</body>
	</div>
</HTML>

