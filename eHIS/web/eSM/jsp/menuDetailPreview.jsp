<!DOCTYPE html>
<head>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<script language=JavaScript src="../../eCommon/js/menu.js"></script>
<%
    request.setCharacterEncoding("UTF-8");
	String root_menu=request.getParameter("menuid");
%>



<SCRIPT LANGUAGE="JavaScript" TYPE="text/javascript">
	NS4 = (document.layers);
	IE4 = (document.all);
	ver4 = (NS4 || IE4);
	IE5 = (IE4 && navigator.appVersion.indexOf("5.")!=-1);
	isMac = (navigator.appVersion.indexOf("Mac") != -1);
	isMenu = (NS4 || (IE4 && !isMac) || (IE5 && isMac));

	function popUp(){ return } ;
	function popDown(){ return } ;
	if (!ver4) event=null;

	if (isMenu)	{
		menuVersion = 3;
		menuWidth = 120;
		childOverlap = 20;
		childOffset = 5;
		perCentOver = null;
		secondsVisible = .5;
		fntCol = "blue";
		fntSiz = "10";
		fntBold = false;
		fntItal = false;
		fntFam = "Arial,sans-serif";
		backCol = "#DDDDDD";
		overCol = "#FFCCCC";
		overFnt 		= "purple";
		borWid = 2;
		borCol = "black";
		borSty = "solid";
		itemPad = 3;
		imgSrc = 		"../../eCommon/images/tri.gif";
		imgSiz = 10;
		separator = 1;
		separatorCol = "black";
		isFrames = false;
		keepHilite = true;
		clickStart = false;
		clickKill = true;
	}
</script>

<%

%>

<!-- added by chitra-->
<script language='JavaScript'>
function MainMenu() {
<%!
	Connection con =null;
	PreparedStatement pstmt ;
	Statement stmt;
	ResultSet rs ;
	ResultSet rset ;
%>
<%

try{
	con=ConnectionManager.getConnection(request);

	String root_menu_id = root_menu;

	String menu="";
	int maxRecord=0;
	int max=0;

%>

<%
	String menu_sql	= "select menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type,menu_dtl.option_descriptor option_descriptor, menu_dtl.function_id function_id, sm_function.executable_name from sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=?order by rownum) menu_dtl,sm_module module,sm_function sm_function where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and submenu_id is not null order by p_level desc";

		String submenu_sql	= "select menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type,menu_dtl.option_descriptor option_descriptor, menu_dtl.function_id function_id, sm_function.executable_name from sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor,OPTION_SEQUENCE_NO from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? order by rownum) menu_dtl,sm_module module,sm_function sm_function where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and submenu_id is not null order by OPTION_SEQUENCE_NO";

	String function_sql="select  menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id,menu_dtl.option_type, menu_dtl.OPTION_DESCRIPTOR option_descriptor, menu_dtl.function_id function_id,menu_dtl.module_id module_id,menu_dtl.insert_access_yn insert_access_yn,menu_dtl.update_access_yn update_access_yn, menu_dtl.delete_access_yn delete_access_yn,menu_dtl.print_access_yn print_access_yn, menu_dtl.QUERY_ONLY_ACCESS_YN query_only_access_yn,sm_function.executable_name executable_name,sm_function.FUNCTION_TYPE function_type from sm_menu_hdr menu_hdr, ( select  level p_level, menu_id,submenu_id ,option_type, option_descriptor ,function_id, module_id,insert_access_yn, update_access_yn, delete_access_yn, print_access_yn, query_only_access_yn,option_sequence_no,srl_no from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? order by rownum) menu_dtl,sm_module module,sm_function sm_function where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and  sm_function.module_id (+) = menu_dtl.module_id and sm_function.function_id  (+)= menu_dtl.function_id and submenu_id is null order by menu_dtl.option_sequence_no, menu_dtl.srl_no ";


	stmt = con.createStatement();
	String strsql=" select count(*) as total from sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor,srl_no from sm_menu_dtl connect by prior submenu_id=menu_id start with menu_id=?order by rownum) menu_dtl,sm_module module,sm_function sm_function where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and submenu_id is not null order by p_level desc ,menu_dtl.submenu_id";

	//rset = stmt.executeQuery(strsql);
	pstmt   = con.prepareStatement(strsql);
	pstmt.setString	(	1,	root_menu_id		);
	rset		 = pstmt.executeQuery();

	rset.next();
	maxRecord = rset.getInt("total");
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();
	maxRecord++;

	String srtcount =" select  count(*) as total  from sm_menu_hdr menu_hdr, ( select  level p_level, menu_id,submenu_id ,option_type, option_descriptor ,function_id, module_id,insert_access_yn, update_access_yn, delete_access_yn, print_access_yn, query_only_access_yn,option_sequence_no,srl_no from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? order by rownum) menu_dtl,sm_module module,sm_function sm_function where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and sm_function.module_id (+) = menu_dtl.module_id and sm_function.function_id  (+)= menu_dtl.function_id and submenu_id is null order by menu_dtl.option_sequence_no, menu_dtl.srl_no";

	//stmt = con.createStatement();
	//rset = stmt.executeQuery(srtcount);
	pstmt   = con.prepareStatement(srtcount);
	pstmt.setString	(	1,	root_menu_id		);
	rset		 = pstmt.executeQuery();
	
	rset.next();
	max = rset.getInt("total");
	max++;
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();
	String submenuid[] = new String[maxRecord];
	int cnt=0;
	boolean first=true;

	String optiondescriptor[] = new String[max];
	String optionmenu[] = new String[max];

	pstmt = con.prepareStatement( menu_sql ) ;
	pstmt.setString	(	1,	root_menu_id);
	rs = pstmt.executeQuery() ;

	submenuid[0]="";
	if ( rs != null  && rs.next()){
	do {
		first=true;
		String menu_id = rs.getString( "menu_id" ) ;

		String submenu_id = rs.getString( "submenu_id" ) ;
		String option_descriptor = rs.getString( "option_descriptor" ) ;

		if ( submenu_id != null ) {
				for(int k=0;k<=cnt;k++){
					if(submenu_id.equals(submenuid[k]))	first=false;
				}

				if(first){

					out.println( "window." + submenu_id + " = new Menu('" + option_descriptor + "')") ;
				}
		}
		out.println( "window." + menu_id + " = new Menu('" + option_descriptor + "')") ;
		cnt++;
		submenuid[cnt]=submenu_id;

		}while(rs.next() );
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
}
	out.println( "window.mainMenu = new Menu() ;" ) ;
	
	pstmt = con.prepareStatement( function_sql ) ;
		pstmt.setString( 1, root_menu_id ) ;
		rs = pstmt.executeQuery() ;
		cnt=0;


		while ( rs != null && rs.next() ) {
			String p_level = rs.getString( "p_level" );
			int plevel = Integer.parseInt(p_level);
			String menu_id = rs.getString( "menu_id" ) ;
			
			String submenu_id = rs.getString( "submenu_id" ) ;
			String option_descriptor = rs.getString( "option_descriptor" ) ;
			
			///String function_id  = rs.getString("function_id");
			//String insert_access_yn = rs.getString("insert_access_yn");
			//String update_access_yn = rs.getString("update_access_yn");
			//String query_only_access_yn = rs.getString("query_only_access_yn");
			//String delete_access_yn = rs.getString("delete_access_yn");
			//String print_access_yn = rs.getString("print_access_yn");
			//String function_type = rs.getString("function_type");
			//String module_id = rs.getString("module_id");
		
			 if(plevel == 1)
					menu = "mainMenu";
			else
				menu =menu_id;

			first=true;
			if(submenu_id == null){

				for(int k=0;k<=cnt;k++){
										if(option_descriptor.equals(optiondescriptor[k]))	
										{
										 if(menu.equals(optionmenu[k]))
											{
												first=false;
											}
										}



				}

				if(first){
					out.println( menu + ".addMenuItem( '" + option_descriptor + "' )" ) ;
				}

				first=false;
			}
			cnt++;
			optiondescriptor[cnt]=option_descriptor;
			optionmenu[cnt]=menu;
	}
 		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	pstmt = con.prepareStatement( submenu_sql ) ;
		pstmt.setString( 1, root_menu_id ) ;
		rs = pstmt.executeQuery() ;


		while ( rs != null && rs.next() ) {
			String menu_id = rs.getString( "menu_id" ) ;
			
			String submenu_id = rs.getString( "submenu_id" ) ;
			
			
			if ( submenu_id != null ) {
				if ( !menu_id.equalsIgnoreCase( root_menu_id ) ) {
							out.println( menu_id + ".addMenuItem("+submenu_id+")" );
	 				} else {
					out.println( "mainMenu.addMenuItem( " + submenu_id + " )" ) ;
				}
			}
	}
 		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	out.println( "mainMenu.writeMenus() ;" ) ;

%>

<%
	
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	



%>
}

</script>
<!-- added by chitra ends-->
</head>

<body bgcolor="#F0F0F2" onKeyDown = 'lockKey()'>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr><td width="100%" valign="top" colspan="2"><img src="../../eCommon/images/eCIS.gif"></td></tr>
				<tr><td width="40%" valign="top"><IMG alt="Menu " border="0" src="../../eCommon/images/Menu.gif" onClick='javascript:window.showMenu( window.mainMenu );'> </td><td align="left" width="60%" rowspan="13" valign="top"><img src="../../eCommon/images/Logo.gif"></td></tr>
				<tr><td width="40%" valign="top"><IMG alt="Switch Responsibility" border="0" src="../../eCommon/images/SwitchResponsibility.gif" onClick=""></td></tr>
				<tr><td width="40%" valign="top"><IMG alt="Change Password" border="0" src="../../eCommon/images/ChangePassword.gif" onClick=""></td></tr>
		<tr><td width="40%" valign="top"><IMG alt="Logout" border="0" src="../../eCommon/images/Logout.gif" onClick=""</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
	</table>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr><td width="52%"><td><td width="48%" valign="top" vspace="0"><font face="Verdana" color="black" size="2"><b>MEDICOM Solutions (P) Ltd.</b></font></td></tr>
		<tr><td width="52%"><td><td width="48%" valign="top" vspace="0"><font face="Verdana" color="black" size="1">73-D, Electronics City, Hosur Road, Bangalore - 561 229, INDIA.</td></tr>
		<tr><td width="52%"><td><td width="48%" valign="top" vspace="0"><font face="Verdana" color="black" size="1">Tel : +91-80-8520230  Fax : +91-80-8520231.</td></tr>
		<tr><td width="52%"><td><td width="48%" valign="top" vspace="0"><font face="Verdana" color="black" size="1">Web : www.medicomsoft.com</td></tr>
		<tr><td width="52%"><td><td width="48%" valign="top" vspace="0"><font face="Verdana" color="black" size="1">E-mail : bangalore@medicomsoft.com</td></tr>
	</table>

	<input type="hidden" name="root" id="root"  value ='<%=root_menu%>' >
	<script language='JavaScript'>
	  	if ( document.all ) MainMenu() ;
		if ( document.layers ) MainMenu() ;
</script>
</body>


