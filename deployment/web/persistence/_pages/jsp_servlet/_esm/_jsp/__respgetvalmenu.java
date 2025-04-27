package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __respgetvalmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/RespGetValMenu.jsp", 1709121720479L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t<html>\n\t\t\t\t<HEAD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\n\t\t\t\t</HEAD>\n\t\t\t\t<body  onKeyDown = \'lockKey()\'; OnMouseDown=\'CodeArrest()\' ; CLASS=\'MESSAGE\'>\n\t\t\t\t<form name=\'testform\' id=\'testform\'>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t\t\t<script>\n\t\t\t\t\tvar opt = parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\topt.text = \'------------------------ Select ------------------------------\';\n\t\t\t\t\topt.value= \'\';\n\t\t\t\t\tparent.frames[1].document.forms[0].menu_id.add(opt);\n\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar p = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t\t\t\t\tvar d = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\t\t\t\tif (p ==d)\n\t\t\t\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].menu_id.add(element);\n\t\t\t\t\t\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\n\n\t\t\t\t\tvar opt = parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\topt.text = \'------------------------ Select ------------------------------\';\n\t\t\t\t\topt.value= \'\';\n\t\t\t\t\tparent.frames[1].document.forms[0].menu_id.add(opt);\n\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\t\n\t\t\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</form>\n</body>\n</html>\n\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
	String MenuName		= request.getParameter("MenuName");
	String menuid		= request.getParameter("Menu_id");
	Connection con=null;
			try{
			con = ConnectionManager.getConnection(request);
			Statement stmt=null;
			ResultSet rs = null;
			String sql="";
			String dat="";
			String id="";

			String responsibility_id= (String) session.getValue("responsibility_id");
			stmt=con.createStatement();
			String sqlResp="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"'";
			rs=stmt.executeQuery(sqlResp);
			if (rs !=null){
				while (rs.next()){

				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			
            _bw.write(_wl_block2Bytes, _wl_block2);

          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		try{
			if (!(MenuName.equals("") || MenuName == null)){
			
            _bw.write(_wl_block5Bytes, _wl_block5);

							sql  = " select menu_id, menu_NAME from sm_menu_hdr where root_menu_yn='Y'  and resp_group_id='"+MenuName+"'  order by  menu_NAME ";
				
						stmt = con.createStatement() ;
						rs = stmt.executeQuery(sql) ;

						if (rs != null)
						{
							while(rs.next())
							{
								dat=rs.getString("menu_NAME");
								id=rs.getString("menu_id");

						

					
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(menuid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(id));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
		}
		else 
				{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

						sql  = " select menu_id, menu_NAME from sm_menu_hdr where root_menu_yn='Y'  order by  menu_NAME "  ;
					stmt = con.createStatement() ;
					rs = stmt.executeQuery(sql) ;

					if (rs != null)
					{
						while(rs.next())
						{
							dat=rs.getString("menu_NAME");
							id=rs.getString("menu_id");
		
						

					
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(menuid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(id));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();

		}
		}
		catch(Exception e)
		{
			out.print(e);
		}
			if(stmt != null)stmt.close();
			if(rs != null) rs.close();

			}catch(Exception e){out.println(e);}
			finally { 
				ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
