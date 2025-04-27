package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __camainchart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainChart.jsp", 1742377395146L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</title>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><script language=\"JavaScript\" src=\"../../eCA/js/CAMenu.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script>\n\tif(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'==\"\"){  //IN044811\n\t\twindow.moveTo(0,0); \n\t\twindow.resizeTo(screen.availWidth ,screen.availHeight); \n\t}//IN044811\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<!-- [IN030566] Starts -->\n\t<iframe name=\'plineFrame\' id=\'plineFrame\'  frameborder=\"no\" src=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Patient_ID=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&visit_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&enableCDR=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' scrolling=\'no\' noresize style=\'height:7vh;width:100vw\'></iframe><!--IN068658 added  CRD-->\n\t<iframe name=\'content\' id=\'content\' src=\'../../eCA/jsp/CAMain.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'yes\' frameborder=0 noresize style=\'height:92vh;width:100vw\'></iframe>\n\t<iframe name=\'blankFrameForCharts\' id=\'blankFrameForCharts\' src=\'../../eCommon/html/blank.html\' SCROLLING=\'no\'  style=\'display:none;border:none;height:0vh;width:100vw\'></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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

/*
-----------------------------------------------------------------------
Date       	Edit History   Name        Description
-----------------------------------------------------------------------
?             100            		?           created
30/01/2012	IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.	
13/06/2013	IN038776	Ramesh G	This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes							  
18/11/2013	IN044811	Ramesh G	In genogram, double click on the 'Double Square' symbol.
19/09/2018	IN068658	Ramesh G	MMS-DM-CRF-0115.3
-----------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String title = "";
	String PGeno_Name = request.getParameter("PGeno_Name")==null?"":request.getParameter("PGeno_Name");  //IN044811
	try
	{
		con = ConnectionManager.getConnection(request);
		ps = con.prepareStatement("SELECT PRODUCT_DESCRIPTION FROM SM_INSTALLATION");
		rs = ps.executeQuery();

		while(rs.next())
		{
			title = rs.getString("PRODUCT_DESCRIPTION") == null ? "" : rs.getString("PRODUCT_DESCRIPTION");
		}

		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}
	catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(title));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(PGeno_Name));
            _bw.write(_wl_block6Bytes, _wl_block6);


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String query_string = request.getQueryString() == null? "" :request.getQueryString()+"&child_window=Y";
String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
String patientId	= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String episodeId	= request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
String visitId		= request.getParameter("visit_id") == null ? "" : request.getParameter("visit_id");
String enableCDR	="N";//IN068658
String windowName	= patientId+episodeId+visitId;
String patChartCalledFrm =  request.getParameter("patChartCalledFrm") == null ? "" : request.getParameter("patChartCalledFrm");  //IN038776
session.putValue(patientId+"patChartCalledFrm",patChartCalledFrm);  //IN038776
int headerFrameSize = 7;
if(lookupFileName.equals("")){
	headerFrameSize = 7;
	enableCDR="Y";//IN068658
}else{
	headerFrameSize = 0;
}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(enableCDR));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
