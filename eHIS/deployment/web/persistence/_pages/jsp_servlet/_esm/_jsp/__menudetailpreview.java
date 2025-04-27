package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __menudetailpreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/esm/jsp/menuDetailPreview.jsp", 1709121706682L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<script language=JavaScript src=\"../../eCommon/js/menu.js\"></script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n\n<SCRIPT LANGUAGE=\"JavaScript\" TYPE=\"text/javascript\">\n\tNS4 = (document.layers);\n\tIE4 = (document.all);\n\tver4 = (NS4 || IE4);\n\tIE5 = (IE4 && navigator.appVersion.indexOf(\"5.\")!=-1);\n\tisMac = (navigator.appVersion.indexOf(\"Mac\") != -1);\n\tisMenu = (NS4 || (IE4 && !isMac) || (IE5 && isMac));\n\n\tfunction popUp(){ return } ;\n\tfunction popDown(){ return } ;\n\tif (!ver4) event=null;\n\n\tif (isMenu)\t{\n\t\tmenuVersion = 3;\n\t\tmenuWidth = 120;\n\t\tchildOverlap = 20;\n\t\tchildOffset = 5;\n\t\tperCentOver = null;\n\t\tsecondsVisible = .5;\n\t\tfntCol = \"blue\";\n\t\tfntSiz = \"10\";\n\t\tfntBold = false;\n\t\tfntItal = false;\n\t\tfntFam = \"Arial,sans-serif\";\n\t\tbackCol = \"#DDDDDD\";\n\t\toverCol = \"#FFCCCC\";\n\t\toverFnt \t\t= \"purple\";\n\t\tborWid = 2;\n\t\tborCol = \"black\";\n\t\tborSty = \"solid\";\n\t\titemPad = 3;\n\t\timgSrc = \t\t\"../../eCommon/images/tri.gif\";\n\t\timgSiz = 10;\n\t\tseparator = 1;\n\t\tseparatorCol = \"black\";\n\t\tisFrames = false;\n\t\tkeepHilite = true;\n\t\tclickStart = false;\n\t\tclickKill = true;\n\t}\n</script>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<!-- added by chitra-->\n<script language=\'JavaScript\'>\nfunction MainMenu() {\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n}\n\n</script>\n<!-- added by chitra ends-->\n</head>\n\n<body bgcolor=\"#F0F0F2\" onKeyDown = \'lockKey()\'>\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t<tr><td width=\"100%\" valign=\"top\" colspan=\"2\"><img src=\"../../eCommon/images/eCIS.gif\"></td></tr>\n\t\t\t\t<tr><td width=\"40%\" valign=\"top\"><IMG alt=\"Menu \" border=\"0\" src=\"../../eCommon/images/Menu.gif\" onClick=\'javascript:window.showMenu( window.mainMenu );\'> </td><td align=\"left\" width=\"60%\" rowspan=\"13\" valign=\"top\"><img src=\"../../eCommon/images/Logo.gif\"></td></tr>\n\t\t\t\t<tr><td width=\"40%\" valign=\"top\"><IMG alt=\"Switch Responsibility\" border=\"0\" src=\"../../eCommon/images/SwitchResponsibility.gif\" onClick=\"\"></td></tr>\n\t\t\t\t<tr><td width=\"40%\" valign=\"top\"><IMG alt=\"Change Password\" border=\"0\" src=\"../../eCommon/images/ChangePassword.gif\" onClick=\"\"></td></tr>\n\t\t<tr><td width=\"40%\" valign=\"top\"><IMG alt=\"Logout\" border=\"0\" src=\"../../eCommon/images/Logout.gif\" onClick=\"\"</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t</table>\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t<tr><td width=\"52%\"><td><td width=\"48%\" valign=\"top\" vspace=\"0\"><font face=\"Verdana\" color=\"black\" size=\"2\"><b>MEDICOM Solutions (P) Ltd.</b></font></td></tr>\n\t\t<tr><td width=\"52%\"><td><td width=\"48%\" valign=\"top\" vspace=\"0\"><font face=\"Verdana\" color=\"black\" size=\"1\">73-D, Electronics City, Hosur Road, Bangalore - 561 229, INDIA.</td></tr>\n\t\t<tr><td width=\"52%\"><td><td width=\"48%\" valign=\"top\" vspace=\"0\"><font face=\"Verdana\" color=\"black\" size=\"1\">Tel : +91-80-8520230  Fax : +91-80-8520231.</td></tr>\n\t\t<tr><td width=\"52%\"><td><td width=\"48%\" valign=\"top\" vspace=\"0\"><font face=\"Verdana\" color=\"black\" size=\"1\">Web : www.medicomsoft.com</td></tr>\n\t\t<tr><td width=\"52%\"><td><td width=\"48%\" valign=\"top\" vspace=\"0\"><font face=\"Verdana\" color=\"black\" size=\"1\">E-mail : bangalore@medicomsoft.com</td></tr>\n\t</table>\n\n\t<input type=\"hidden\" name=\"root\" id=\"root\"  value =\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' >\n\t<script language=\'JavaScript\'>\n\t  \tif ( document.all ) MainMenu() ;\n\t\tif ( document.layers ) MainMenu() ;\n</script>\n</body>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

	Connection con =null;
	PreparedStatement pstmt ;
	Statement stmt;
	ResultSet rs ;
	ResultSet rset ;


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

    request.setCharacterEncoding("UTF-8");
	String root_menu=request.getParameter("menuid");

            _bw.write(_wl_block2Bytes, _wl_block2);



            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);


try{
	con=ConnectionManager.getConnection(request);

	String root_menu_id = root_menu;

	String menu="";
	int maxRecord=0;
	int max=0;


            _bw.write(_wl_block5Bytes, _wl_block5);

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


            _bw.write(_wl_block5Bytes, _wl_block5);

	
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	




            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(root_menu));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
