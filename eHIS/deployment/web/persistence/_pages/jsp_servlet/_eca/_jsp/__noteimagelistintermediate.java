package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __noteimagelistintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/NoteImageListIntermediate.jsp", 1709115960483L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../js/NoteImageList.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script>\n//\t\t\t\t\t\tvar result = confirm(getMessage(\'IMAGE_ALRDY_EXISTS\',\'CA\'));\n\n//\t\t\t\t\t\tif(result==true) -->\n\t\t\t\t\t\t{\n//\t\t\t\t\t\t\tparent.f_query_add_mod.document.ImageListForm.flag.value=true;\n//\t\t\t\t\t\t\tparent.f_query_add_mod.document.ImageListForm.record.value=\'Y\';\n//\t\t\t\t\t\t\tparent.f_query_add_mod.document.ImageListForm.submit();\n\t\t\t\t\t\t}\n//\t\t\t\t\t\telse\n//\t\t\t\t\t\t\talert(getMessage(\'FAILED_TRANSACTION\',\'CA\'));\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].flag.value=false;\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].record.value=\'Y\'\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.forms[0].submit();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>\n\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n\t</script>\n\n\t</html>\n";
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
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	String imageurl_sql = "";
	String note_image_rep_folder = "";
	String image_name = "";

	//File filecreate;
	
	boolean flag			= true;
	//boolean fileexists		= true;
	//boolean filecreateRes	= false;
	
	image_name = request.getParameter("image_name")==null?"":request.getParameter("image_name");

	try
	{
			con = ConnectionManager.getConnection();
			note_image_rep_folder = "";

			imageurl_sql = " select NOTE_IMAGE_REP_FOLDER from ca_note_param";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(imageurl_sql);

			if(rs.next())
				note_image_rep_folder = rs.getString("note_image_rep_folder");

			if(stmt!=null)
				stmt.close();
			if(rs!=null)
				rs.close();
			

			//String filename = note_image_rep_folder+"/"+image_name;

//			filecreate     = new File(filename);

//			if(filecreate.exists())
//			{
				
            _bw.write(_wl_block6Bytes, _wl_block6);

//			}
////			else
	///			flag = filecreate.createNewFile();

			
			
			if(flag)
			{
				
            _bw.write(_wl_block7Bytes, _wl_block7);

			}


            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception @ NoteImageListIntermediate.jsp "+e.toString());//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

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
