package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __caassicd2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAAssIcd2.jsp", 1709115472670L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n\n\t\t<script>\n\t\tvar chapter=\'\';\n\t\tvar prev=0\n\t\tfunction  change_row_color(obj)\n\t\t{\n\t\t\t\tdocument.getElementById(\"t\").rows(prev).cells(1).style.backgroundColor=obj.bgColor\n\t\t\t\tobj.cells(1).style.backgroundColor=\"#d3d3d3\"\n\t\t\t\tprev\t=obj.rowIndex\n\t\t}\n\n\t\t\tfunction loadOptions(chapter1)\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\'\n\t\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\'\n\n\t\t\t\tvar code=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\n\n\t\t\t\tif(code==\"null\" ||code==null || code!=chapter1)\n\t\t\t\t\tchapter=\'&chapter_code=\'+chapter1\n\t\t\t\telse\n\t\t\t\t\tchapter=\'\';\n\t\t\t\tself.location.href=\'../../eCA/jsp/CAAssIcd2.jsp?p_diag_code=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&p_auth_yn=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&cause_indicator=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'+chapter\n\t\t\t}\n\n\n\t\t\tfunction scrl()\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"scrollname\").scrollIntoView()\n\t\t\t}\n\n\t\t\tfunction loadOtherFr(from, to)\n\t\t\t{\n\t\t\t\tparent.frames[1].location.href=\'../../eCA/jsp/CAAssSecondScreen.jsp?p_diag_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&from_diag_code=\'+from+\'&to_diag_code=\'+to+\'&cause_indicator=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'\n\t\t\t}\n\t\t</script>\n\t</head>\n\n\t<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<table cellspacing=1 cellpadding=2 width=\'100%\' id=\'t\'  border=0 >\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<a href=javascript:loadOptions(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\') ><font size=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a>\n\t\t\t\t</td>\n\t\n\t\t\t\t<td><font size=1>&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<a id=\'scrollname\' name=\'scrollname\'></a>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t<tr  onclick=\'change_row_color(this)\'>\n\t\t\t\t\t\t\t\t\t\t\t<td>&nbsp</td>\n\t\t\t\t\t\t\t\t\t\t\t<td><a href=javascript:loadOtherFr(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')><font size=1>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<script>scrl();</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</table>\n\n\t</body>\n<html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			Connection con= null;
			String chapter_code=request.getParameter("chapter_code");
			String auth=request.getParameter("p_auth_yn");
			String scheme=request.getParameter("p_diag_code");
			String cause_indicator=request.getParameter("cause_indicator");
			String sql="";
			String optsql="";
		

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(chapter_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(auth));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(auth));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(cause_indicator));
            _bw.write(_wl_block13Bytes, _wl_block13);

			try
			{
				con= ConnectionManager.getConnection(request);
				PreparedStatement stmt 	= null;
				PreparedStatement optstmt=null;
				ResultSet rs	= null;
				ResultSet optrs	= null;
				
				sql= " select '+' expand, chapter_code, long_desc, to_char(null) from_diag_code, to_char(null) to_diag_code from mr_icd9_chapter ";

				stmt=con.prepareStatement(sql);
				rs=stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
					{
				
            _bw.write(_wl_block14Bytes, _wl_block14);

					String exp="+";
						if(rs.getString("chapter_code").equals(chapter_code) )
							exp="-";
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString("chapter_code")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(exp));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("long_desc")));
            _bw.write(_wl_block18Bytes, _wl_block18);

							if(rs.getString("chapter_code").equals(chapter_code) )
							{
								optsql=" select to_char(null) expand, a.chapter_code,lpad('',5)|| a.long_desc long_desc, from_diag_code, to_diag_code from  mr_icd9_subchapter  a, mr_icd9_chapter b where a.chapter_code=? and a.chapter_code=b.chapter_code  order by 1,2, 3";

								optstmt=con.prepareStatement(optsql);
								optstmt.setString(1,chapter_code);
								optrs=optstmt.executeQuery();

								if(optrs!=null)
								{
								
            _bw.write(_wl_block19Bytes, _wl_block19);

									while(optrs.next())
									{
									
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(optrs.getString("from_diag_code")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(optrs.getString("to_diag_code")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(optrs.getString("long_desc")));
            _bw.write(_wl_block23Bytes, _wl_block23);

									}
								}
								
            _bw.write(_wl_block24Bytes, _wl_block24);


				if(optrs!=null) optrs.close();
				if(optstmt!=null) optstmt.close();
						}
						
            _bw.write(_wl_block25Bytes, _wl_block25);

					}
				}
			
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				
			
			}
			catch(Exception e){
				//out.print("Exception in CAAssIcd2.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
				
					if(con!=null) ConnectionManager.returnConnection(con,request);
					}
		
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
