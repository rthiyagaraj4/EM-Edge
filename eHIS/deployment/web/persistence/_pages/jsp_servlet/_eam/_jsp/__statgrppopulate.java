package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;

public final class __statgrppopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/StatGrpPopulate.jsp", 1710441455735L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\n\t\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n          <script>\n\t\t\t obj=parent.frames[1].frames[0].document.getElementById(\'stat_group\')  \n\t\t     len=obj.length\n\t\t\t\tvar i=1;\n\t\t\t\twhile(i<len)\n\t\t\t\t{\n\t\t\t\t\tlen=obj.length\n\t\t\t\t\tobj.remove(i)\n\t\t\t\t}\n\t\t   </script>\n\t\t ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t       \n\t\t\t//\t\tvar obj =parent.frames[1].frames[1].document.practitioner1_form.stat_group;\n\t\t\t\t\topt=parent.frames[1].frames[0].document.createElement(\"OPTION\");\n\t\t\t\t    opt.text=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\';\n\t\t\t\t    opt.value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[1].frames[0].document.getElementById(\'stat_group\').add(opt);\n\n\t\t\t\n\n\n                </script>\n         ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");	
	String category = request.getParameter("category");
	


	String stat_code="";
	String stat_desc="";
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;
            _bw.write(_wl_block3Bytes, _wl_block3);
try{
		    con = ConnectionManager.getConnection(request);
			out.println("<html><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>");
			stmt= con.createStatement();	
		
			String sql="";
     	  //added condition check clinic_type,CARE_LOCN_TYPE_IND by rajesh 19/10/2004 
           sql="select  stat_grp_desc,stat_grp_id from am_stat_group where STAT_GRP_CAT = '"+category+"'  order by 1";
            _bw.write(_wl_block4Bytes, _wl_block4);
  rs = stmt.executeQuery(sql) ;
		   	if(rs!=null)
			    {
					while (rs.next())
					{			
                        
						
						 stat_code = rs.getString(1);	
						 if(stat_code==null) stat_code="";
				 
						 stat_desc = rs.getString(2);
						 if(stat_desc==null) stat_desc="";
					
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(stat_code ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(stat_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);
}
					
					
		}

				
				
			
			
			
		

		}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request); 
	}
	out.println("</html>");		
	

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
