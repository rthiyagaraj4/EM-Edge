package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;

public final class __freqaccesstree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/freqaccessTree.jsp", 1737631662228L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html><head>\n<script src=\'../js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n<script type=\'text/javascript\' src=\'../../eCommon/js/dtree.js\'></script></head>\n<div class=\'freqdtree\'>\n\n<body class=\'NavigIconsBorderTop\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'> \n<script type=\'text/javascript\'>\n\t<!--\n\td = new dTree(\'d\');\n\td.config.useStatusText=true;\n\td.add(0,-1,\'<b>Frequently Accessed List</b>\');\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\talert(top.header.getMessage(\"FREQ_ACCESS_NOT_AVAILABLE\",\"SM\"));\n\t\t\tdocument.location.href=\"about:blank\"\n\t\t\t//parent.toolFunction(4);\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\ndocument.write(d);\n\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n</div>\n\n</body> </html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
 
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
	
	
            _bw.write(_wl_block5Bytes, _wl_block5);

	}
}
catch(Exception e){e.printStackTrace();}
  finally {
		ConnectionManager.returnConnection(conn);
  }


            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
