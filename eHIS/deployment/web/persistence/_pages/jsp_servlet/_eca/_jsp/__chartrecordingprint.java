package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import webbeans.eCommon.*;
import org.jfree.chart.servlet.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingprint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingPrint.jsp", 1738143285810L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script Language=\"vbscript\">\n    Dim WSHShell\n    Dim myHeader\n    Dim myFooter\n    Dim myMarginleft \n    Dim myMarginright \n    Set WSHShell = CreateObject(\"WScript.Shell\")\n    REM myHeader = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\")\n    REM myFooter = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\")\n    REM myMarginleft = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\") \n    REM myMarginright = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\") \n\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"&bPage &p of &P\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"&b&d\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\", \"0.5\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\", \"0.3\"\n\n  \n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="onLoad = \"Print()\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n<form>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<table width=\'95%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<img src=\"../../eCA/MediPainter/images/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" alt = \'Graph\' border=0 /><br>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n</form>\n<script>\n\tfunction Print() \n\t{\n\t\t\tvar res = confirm(\'Continue printing?\');\n\t\t\tif(res)  \n\t\t\t{\n\t\t\t\twindow.print();\n\t\t\t}\n\t\t\twindow.close();\n\t}\n</script>\n</body>\n</html>\n\t\n\n";
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);


			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String filename		= request.getParameter("filename") == null ? "" : request.getParameter("filename");
	//out.println("<script>alert('Printing page---"+filename+"');</script>");
	String[] filenames = filename.split(",");
	//out.println("<script>alert('"+filenames.length+"');</script>");
	String callOn		= request.getParameter("callOn") == null ? "callOnExit" : request.getParameter("callOn");
	//String patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String pat_line		= request.getParameter("pat_line") == null ? "" : request.getParameter("pat_line");
	boolean deleted = false;
	String name = "";

            _bw.write(_wl_block10Bytes, _wl_block10);
if(callOn.equals("callOnPrint")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

	if(callOn.equals("callOnPrint"))
	{
		/*String patient_name = "",		age = "";
		String sex = "";
		String sql = "select a.patient_name, a.sex, GET_AGE(a.date_of_birth) age from mp_patient a where patient_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		

		try
		{
			con = ConnectionManager.getConnection(p);
			
			if(con != null)
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id.trim());
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					patient_name = rs.getString(1)== null ? "" : rs.getString(1);
					sex = rs.getString(2)== null ? "" : rs.getString(2);
					age = rs.getString(3)== null ? "" : rs.getString(3);
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

					
			

			if(sex.equals("M"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				
			if(sex.equals("F"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				 
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);

		} */

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block14Bytes, _wl_block14);

		for(int i=0;i<filenames.length;i++)
		{
			name = filenames[i];

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(name));
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
	}
	else if(callOn.equals("callOnExit"))
	{
		try
		{
			for(int i=0;i<filenames.length;i++)
			{
				name = filenames[i];
				File file = new File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + name);
				if(file.exists())
					deleted = file.delete();
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
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

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Graphs.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
