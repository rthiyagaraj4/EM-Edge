package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __clinicaleventgroupindtabcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventGroupIndTabCriteria.jsp", 1709115734933L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ClinicalEventGroup.js\'></script>\n\n</head>\n<body onLoad=\'\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\'EventIndTabCriteriaForm\' id=\'EventIndTabCriteriaForm\' action=\'../../servlet/eCA.ClinicalEventGroupServlet\' method=\'post\' target=\'messageFrame\'>\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\'  width=\'100%\' align=\'left\'>\n<tr>\n   \n\t\t<td class=label align=\'right\' width=\'25%\'>&nbsp;&nbsp;History Type</td>\n\t\t<td align=left>&nbsp;&nbsp;<select name=\'histype\' id=\'histype\'  onchange=\'populateCntrSys(this)\'>\n\t\t<option value=\"\">------------Select-------------</option>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\n</select>\n<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n</td>\n</tr>\n\n<tr>\n<td align=\'right\' class=\'label\'>Source</td>\n<td>&nbsp;&nbsp;<input type=\"radio\" name=\"source\" id=\"source\" value=\"M\" checked onClick=\"display()\">From Master\n<input type=\"radio\" name=\"source\" id=\"source\" value=\"N\" onClick=\"display()\">New\n</td>\n</tr>\n\n<tr>\n   \n\t\t<td class=label align=\'right\' width=\'25%\'>&nbsp;&nbsp;Contr System</td>\n\t\t<td align=left>&nbsp;&nbsp;<select name=\'contr\' id=\'contr\'  onchange=\'callAddElement(this)\'>\n\t\t<option value=\"\">------------Select-------------</option>\n        </select>\n        <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n</tr>\n\n<tr id=\'grp\' style=\'display:block\'>\n<td align=\'right\' class=\'label\'>Event Group Code</td>\n\t<td>&nbsp;&nbsp;<input type=\'text\' name=\"groupcode\" id=\"groupcode\" value=\"\" size=\'20\' maxlength=\'40\' onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"\"><input type=\"button\" value=\"?\" class=\"button\" onClick=\"callGroupCode()\" name=\'search\' id=\'search\'  >\n<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\n</td>\n</tr>\n\n<tr id=\'grp2\' style=\'display:none\'>\n<td align=\'right\' class=\'label\'>Event Group Code</td>\n<td>&nbsp;\n<input type=\'text\' name=\"dollar\" id=\"dollar\" value=\"$\" size=\'1\' maxlength=\'1\' readonly><input type=\'text\' name=\"groupcode2\" id=\"groupcode2\" value=\"\" size=\'20\' maxlength=\'40\' onKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"\">\n<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n</td> \n</tr>\n\n<tr>\n\t<td  align=\'right\' class=\'label\' >Long Description</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;<input type=\'text\'  name=\'long_desc\' id=\'long_desc\' value=\"\"   size=\"40\" maxlength=\"60\" onBlur=\"makeValidString(this)\"\" ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t</td>\n</tr>\n\n<tr >\n\t<td  align=\'right\' class=\'label\'>Short Description</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;<input type=\'text\'  name=\'short_desc\' id=\'short_desc\' value=\"\"   size=\"20\" maxlength=\"40\"  onBlur=\"makeValidString(this)\">\n    <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t</td>\n</tr>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n</select>\n</td>\n</tr>\n<tr>\n\t<td >&nbsp;</td>\n\t<td >&nbsp;</td>\n\t\n</tr>\n</table>\n<input type=\'hidden\' name=\'groupcodeval\' id=\'groupcodeval\' value=\'\'>\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'ind\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String rectype="";
	String longdesc="";
	String sql="select HIST_REC_TYPE,LONG_DESC from  cr_hist_rec_type where HIST_REC_TYPE in ('CLNT','PTCR','TRET','LBIN','RDIN','SUNT') order by 1";	
	try
	{
			con =	ConnectionManager.getConnection(request);
			

            _bw.write(_wl_block8Bytes, _wl_block8);

    
	
	pstmt= con.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs!=null && rs.next())
	{
		rectype=rs.getString("HIST_REC_TYPE");
		longdesc=rs.getString("LONG_DESC");
				
		out.println("<option value='"+rectype+"'>"+longdesc+"</option>");
	}
	
	if(rs!=null)   rs.close(); 
	if(pstmt!=null) pstmt.close();

            _bw.write(_wl_block9Bytes, _wl_block9);
 

}
catch(Exception eg)
{
  // out.println("Exception="+eg.toString());//COMMON-ICN-0181
  eg.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 


            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
