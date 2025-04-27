package jsp_servlet._emp._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __ethnicgroupmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/EthnicGroupModify.jsp", 1709118616026L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String RACE_CODE = request.getParameter("RACE_CODE");
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
String eff_date_from="",eff_date_to="";

try{

out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></script></head><body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>");

//conn = (Connection) session.getValue( "connection" );
conn = ConnectionManager.getConnection(request);



String status = "" ;

String sql = "select RACE_CODE,LONG_DESC,SHORT_DESC,eff_date_from,eff_date_to,EFF_STATUS from MP_RACE where RACE_CODE=? ";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, RACE_CODE); // Added by lakshmanan for security issue ID 174167469 on 05-09-2023
rset = pstmt.executeQuery();

if ( rset != null ) {
    rset.next();
    status = rset.getString( "EFF_STATUS" ) ;
}

out.println(" <form name='ETHNIC_GROUP_FORM' id='ETHNIC_GROUP_FORM' action='../../servlet/eMP.EthnicGroupServlet' method='post' target='messageFrame'> <div align='left'><BR><BR><BR><BR><BR><BR><BR><BR><BR><table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'>" );
out.println( "<input type='text' size='10' maxlength='10' name='ETHNIC_GROUP_CODE' id='ETHNIC_GROUP_CODE' readonly value=" + rset.getString("RACE_CODE") + ">" ) ;
out.println("<img src='../images/mandatory.gif'></img>");

out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'>" ) ;

if ( status.equals( "E" ) )
	out.println( "<input type='text' name='LONG_DESC' id='LONG_DESC' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" + rset.getString( "LONG_DESC" ) + "\">" );
else
	out.println( "<input type='text' name='LONG_DESC' id='LONG_DESC' size='30' readonly value=\"" + rset.getString( "LONG_DESC" ) + "\">" );
out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;

out.println( "<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'>" ) ;

if ( status.equals( "E" ) )
	out.println( "<input type='text' name='SHORT_DESC' id='SHORT_DESC' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + rset.getString( "SHORT_DESC" ) + "\">" );
else
	out.println( "<input type='text' name='SHORT_DESC' id='SHORT_DESC' size='15' readonly value=\""  + rset.getString( "SHORT_DESC" ) + "\">" );
out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;

/*out.println( "<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");

out.println("<tr><td align='right' width='40%' class='label'>Effective From</td><td width='13%' align='left'>&nbsp;&nbsp;" ) ;*/

if ( status.equals( "E" ) )
	out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' value='"+eff_date_from+"'>");
else
	out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' readonly value='"+eff_date_from+"'>");

if ( rset.getDate("eff_date_from") != null )
{
 java.util.Date date = rset.getDate("eff_date_from");
 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
 eff_date_from = formatter.format(date);
 date = null;
 formatter = null;
 }

/*out.println("' onblur='checkdate(this)'></td><td width='47%' align='left' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp; " ) ;*/

if ( status.equals( "E" ) )
	out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"'>");
else
	out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  readonly value='"+eff_date_to+"'>");

if ( rset.getDate("eff_date_to") != null)
{
 java.util.Date date1 = rset.getDate("eff_date_to");
 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
 eff_date_to = formatter.format(date1);
 date1 = null;
 formatter = null;
}


/*out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/

out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='EFF_STATUS' id='EFF_STATUS' value='E'");

String eff_status = rset.getString("EFF_STATUS");

if  ( eff_status.equals("E") )
	out.println("checked >");
else
	out.println(">");

out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr></table></div><input type='hidden' name='mode' id='mode' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>");

}catch ( Exception e ){ 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174112769 on 05-09-2023
	}
finally{
  	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
	ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block5Bytes, _wl_block5);
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
