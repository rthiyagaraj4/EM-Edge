package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import eXH.*;

public final class __xhpopulatetransmasternexternal extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/XHPopulateTransMasterNExternal.jsp", 1709122420881L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<script> \n\t\t\tvar obj=parent.frames[1].document.forms[0].master_name;\n\t\t\tvar obj1=parent.frames[1].document.forms[0].hidden_trans_table_id;\n\t\t\tvar length = obj.length;\n\t\t\tfor(i=0;i<length;i++){\n\t\t\t\tobj.remove(1);\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n\t\t\t\tobj1.remove(1);\n\t\t\t}\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t         opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t     opt.text=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t     opt.value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t parent.frames[1].document.forms[0].master_name.add(opt);\t    \n\t\t\t\t\t opt1=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t     opt1.text=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t     opt1.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"; \n\n\t\t\t    </script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 	
    request.setCharacterEncoding("UTF-8");								 
	Connection con            = null;
	Statement stmt            = null;
	PreparedStatement  pstmt  = null;													 
	ResultSet rs              = null;						  
    StringBuffer sql          = new StringBuffer();
	String code               = "";								   
	String desc               = "";
	String code1              = "";					 				 						   
	String desc1              = "";									   
	String trans_tbl_id		= "";																				   
	String fun_id=XHDBAdapter.checkNull(request.getParameter("fun_id")); 
	String module= request.getParameter("module")==null?"":request.getParameter("module"); 

	String master_code        = request.getParameter("master_code")==null?"":request.getParameter("master_code");
	String master_table_id	= request.getParameter("master_table_id")==null?"":request.getParameter("master_table_id");		     
	//System.out.println("module 28 :"+module);	 			    
	String ModuleFlag        = request.getParameter("ModuleFlag")==null?"":request.getParameter("ModuleFlag");	    
//		System.out.println("ModuleFlag : "+ModuleFlag);
	try{
		   con = ConnectionManager.getConnection(request);		     
		    sql.setLength(0);	
			sql.append("select distinct MASTER_TABLE_ID,TABLE_DESC,TRANS_TABLE_ID from xh_mapping where MASTER_TABLE_ID in(select PLUGIN_TYPE from xh_interactive_connect_param )");
			stmt= con.createStatement();
				rs = stmt.executeQuery(sql.toString()) ;
            _bw.write(_wl_block4Bytes, _wl_block4);
	
					while (rs.next())
					{		
				

						 code = rs.getString("MASTER_TABLE_ID");	
						 if(code==null) code="";
				 
						 desc = rs.getString("TABLE_DESC");
						 if(desc==null) desc="";

 						 trans_tbl_id = rs.getString(3);	


				 	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(trans_tbl_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code));
            _bw.write(_wl_block9Bytes, _wl_block9);
	}
				if(rs != null) rs.close();											 
				if(stmt != null) stmt.close();
				sql.setLength(0);
		}catch(Exception e) { 
			System.out.println(" XHPopulateTransMasterNExternal sqlQuery 34 : "+sql.toString());
			out.println("XHPopulateTransMasterNExternal.jsp :Exception : "+e.toString());}
	finally
	{
		try{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();												    
		}catch(Exception e) {}
		if(con != null) ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
