package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __progressnotesmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ProgressNotesMain.jsp", 1709116077293L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../../eCA/js/ProgressNotes.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<iframe name=\'matcycleframe\' id=\'matcycleframe\' src=\'../../eCA/jsp/ProgressNotesOpenProgression.jsp?cycle_status=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&p_cycle_no=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&p_event_title=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&new_cycle=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&NewEvent=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:*%;width:100vw\'></iframe>\n\t\t<iframe name=\'matactionframe\' id=\'matactionframe\' src=\'../../eCA/jsp/MaternityConsOpenActionbar.jsp\' frameborder=0 scrolling=\'no\' noresize style=\'height:10%;width:100vw\'></iframe>\n\t\t\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<iframe name=\'matcycleframe\' id=\'matcycleframe\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'height:80%;width:100vw\'></iframe>\n\t\t<iframe name=\'matactionframe\' id=\'matactionframe\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'height:10%;width:100vw\'></iframe>\n\t\t\n\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String	module_id	=  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String	patient_id	=  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String	new_cycle	=  request.getParameter("new_cycle") == null ? "O" : request.getParameter("new_cycle");
	String	NewEvent	=  request.getParameter("NewEvent") == null ? "" : request.getParameter("NewEvent");

	String	called_from	=  request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String	progression_ref	=  request.getParameter("progression_ref") == null ? "" : request.getParameter("progression_ref");

	/*
	The below Query was changed by
	Name   : DINESH T
	Date   : 2010-05-03
	INCNO  : 21026
	Changes: Added an extra condition called_from = ? in the query and an extra setString statement for the same
	*/
	String SQL3="SELECT PROGRESSION_CYCLE_NO, PROGRESSION_STATUS FROM CA_PAT_PROGRESSION_HDR WHERE PATIENT_ID = ? AND  MODULE_ID = ?  AND CALLED_FROM= ? ORDER  BY 2 desc, 1 desc";

	Connection		  con	 = null;
	
	PreparedStatement pstmt3 = null;

	ResultSet		  rs3	 = null;

//	String	splty_episode_desc=null;
	String	splty_title_event_desc=null;
	
	int		cycle_no=0;
	String	cycle_status="";

try{
con = ConnectionManager.getConnection(request);

	if(!called_from.equals("OH_TREATMENT"))
	{

	try
	{
		pstmt3=con.prepareStatement(SQL3);
		pstmt3.setString(1,patient_id);
		pstmt3.setString(2,module_id);
		pstmt3.setString(3,called_from);
		rs3	 =pstmt3.executeQuery();
		if (rs3.next())
		{
			cycle_no=Integer.parseInt(rs3.getString(1));
			cycle_status=rs3.getString(2);
		}

		if(rs3!=null) 		rs3.close();
		if(pstmt3!=null)	pstmt3.close();	
		
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}
	}
	else
	{	
		if(progression_ref.equals(""))
		{
			cycle_no = 0;
		}
		else
		{
			cycle_no = 1;
		}
	}


            _bw.write(_wl_block2Bytes, _wl_block2);


if(cycle_no==0 || new_cycle.equals("N") || NewEvent.equals("NewEvent")){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(cycle_status));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(splty_title_event_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(new_cycle));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(NewEvent));
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
}catch(Exception e){
	e.printStackTrace() ;
}
finally
{
	try
	{
	if(con!= null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
	out.println("Exception in CAMainMenu.jsp"+e.toString());
	}
}

            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
