package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __termcodesearchscreen3 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TermCodeSearchScreen3.jsp", 1709119109285L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n\t\t<script>\n\t\t\tvar prev=0\n\t\t\tfunction  change_row_color(obj)\n\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"t\").rows(prev).cells(0).style.backgroundColor=obj.bgColor\n\t\t\t\t\tobj.cells(0).style.backgroundColor=\"#B2B6D7\"\n\t\t\t\t\tprev\t=obj.rowIndex\n\t\t\t}\n\t\t\tfunction loadOtherFrames(scheme,code,desc)\n\t\t\t{\n\t\t\t\t//parent.parent.frames[1].document.forms[0].elements(1).disabled=true\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements(1).disabled=false;\n\t\t\t\twhile(desc.indexOf(\";\")!=-1)\n\t\t\t\t\tdesc=desc.replace(\";\" ,\' \');\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements(0).value=desc+\", \"+code;\n\t\t\t\tparent.parent.frames[1].document.forms[0].elements(2).value=code;\n\t\t\t\tparent.parent.frames[1].document.f.diag_scheme.value=scheme;\n\n\t\t\tparent.frames[3].location.href=\'TermCodeSearchScreen4.jsp?p_auth_yn=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Scheme=\'+scheme+\'&Search_Code=\'+code+\'&Sex=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Dob=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t}\n\t\t</script>\n\t</head>\n\n\t<body onKeyDown=\'lockKey()\'>\n\t<table cellspacing=1 cellpadding=2 width=\'100%\' id=\'t\'  border=0 name=\'t\' id=\'t\'>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<tr  onclick=\'change_row_color(this)\'>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<a href=javascript:loadOtherFrames(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\') ><font size=1>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<a><br>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

		
			Connection con=null; 
			PreparedStatement stmt=null;
			ResultSet rs		 	= null;
			String from_diag=request.getParameter("From_Diag");
			String to_diag=request.getParameter("To_Diag");
			String auth=request.getParameter("p_auth_yn");			
			String sql="";
			String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
			String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(auth));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block12Bytes, _wl_block12);

			try
			{
				con = ConnectionManager.getConnection(request);
/*
				sql="select diag_code,long_desc,short_desc, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between '"+from_diag+"' and '"+to_diag+"' and nvl(sensitive_yn,'N')=decode('"+auth+"' ,'N' ,'N',nvl(sensitive_yn,'N'))order by diag_code";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
*/
				sql="select diag_code,long_desc,short_desc, diag_code||'-'||short_desc diag_desc,diag_code_scheme from mr_icd_code where length(diag_code)=3 and diag_code between ? and ?  and (code_indicator in ('D','C') or code_indicator is null)  order by diag_code ";

				stmt=con.prepareStatement(sql);
				stmt.setString(1,from_diag);
				stmt.setString(2,to_diag);
				rs=stmt.executeQuery();
					
				if(rs!=null)
				{
					String s="";
					while(rs.next())
					{	
						s=rs.getString("long_desc");
						if(s!=null)
							s=s.replace(' ', ';');
						
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rs.getString("diag_code_scheme")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString("diag_code")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(s));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString("diag_desc")));
            _bw.write(_wl_block16Bytes, _wl_block16);
	}
				
				}
			}
			catch(Exception e){/* out.print(e+sql); */e.printStackTrace(); }
			finally
			{
				if(rs!=null)	rs.close();
				if(stmt!=null)	stmt.close();
				ConnectionManager.returnConnection(con,request);
			}
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
