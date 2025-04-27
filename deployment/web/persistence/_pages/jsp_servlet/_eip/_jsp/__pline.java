package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __pline extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/pline.jsp", 1709117838069L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n\t<head>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t</head>\n\t\n\t<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\tvar eidar=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'.split(\":\");\n\t\t\tvar pidar=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'.split(\":\");\n\t\t\tvar elab=\"\"\n\t\t\tvar evalu=\"\"\n\t\t\tvar plab=\"\"\n\t\t\tvar pvalu=\"\"\n\t\t\tif(eidar!=null)\n\t\t\t\t{elab=eidar[0];evalu=eidar[1];}\n\t\t\tplab=pidar[0];pvalu=\":\"+pidar[1];\n\n\t\t\tif(elab==null || evalu==\"\")\n\t\t\t\telab=\" \"\n\t\t\t\t\n\t\t\tif(evalu!=null || evalu!=\"\")\n\t\t\t{\n\t\t\t\tevalu=\":\"+evalu\t\t\t\t\n\t\t\t}\n\n\t\t</script>\n\t\t<table  width=\'100%\' style=\"\" border=0 valign=\'top\' CELLSPACING=0 CELLPADDING=0>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' class=\'IPCAHIGHERLEVELCOLOR\'><FONT  size=\'2\' ><b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t<td class=\'IPCAHIGHERLEVELCOLOR\' align=right ID =\'plab\'><font size=\'-1\' ><script>document.write(plab)</script></td>\n\t\t\t\t<td class=\'IPCAHIGHERLEVELCOLOR\'><font size=\'-1\' ><script>document.write(pvalu)</script></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  width=\'100%\' class=\'IPCAHIGHERLEVELCOLOR\'><font size=\'-1\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<td class=\'IPCAHIGHERLEVELCOLOR\'><font size=\'-1\' ><script>document.write(elab)</script></td>\n\t\t\t\t<td class=\'IPCAHIGHERLEVELCOLOR\'><font size=\'-1\' ><script>document.write(evalu)</script></td>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</tr>\n\t\t</table>\n\t</body>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</html>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			Connection	con		= null;
			Statement	stmt	=null;
			ResultSet	rs		=null;
			try
			{
				String locale		= (String)session.getAttribute("LOCALE");
				con			= ConnectionManager.getConnection(request);			
				String fid			= request.getParameter("Facility_Id");			
				if(fid == null)
					fid = (String) session.getValue("facility_id") ;
				String patid		= request.getParameter("Patient_ID");
				String encounterid	= checkForNull(request.getParameter("EncounterId"));
		
            _bw.write(_wl_block4Bytes, _wl_block4);

			StringBuffer sqlQuery=new StringBuffer();
			if(patid!=null &&  (encounterid ==null || encounterid.equals("")))
				sqlQuery.append("select get_patient.get_line_detail('"+patid+"','"+locale+"') Pline FROM dual");
			else
				sqlQuery.append("select get_patient.get_line_detail('"+fid+"','"+encounterid+"','"+locale+"') Pline FROM dual");
			String name="";
			String en="";
			String id="";
			String pr="";

				stmt=con.createStatement();
			 	rs=stmt.executeQuery(sqlQuery.toString());
			 	if(rs!=null)
			 	{
			 		if(rs.next())
			 		{
			 			String s=rs.getString("Pline");
			 			StringTokenizer token=new StringTokenizer(s,"|");
			 			while(token.hasMoreTokens())
			 			{
			 				name=token.nextToken();
			 				id=token.nextToken();
			 				
			 				if(encounterid!=null &&  !encounterid.equals("") )
			 				{
			 					en=token.nextToken();
			 					pr=token.nextToken();
			 				}
			 			}
			 		}
			 	}
			
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(pr));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(name));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(en));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(encounterid!=null && !encounterid.equals("")){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(rs!=null)   rs.close();
			if(stmt!=null) stmt.close();
	}catch(Exception e){out.println(e);}
	finally
	{
		ConnectionManager.returnConnection(con,request);			
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
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
