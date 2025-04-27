package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;

public final class __commprotocolidcontrolstructure extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/CommProtocolIdControlStructure.jsp", 1709122306758L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>   \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<HEAD>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/CommProtocolIdFileCtrlStr.js\" ></script> \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\n<script language=\"JavaScript\">\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<form name=\"InterfaceStandard_CtrlStr\" id=\"InterfaceStandard_CtrlStr\" target=\'messageFrame\' method=\'post\' action=\'\'>\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t<td width=\'20%\'></td>\n\t<td width=\'40%\'></td>\n\t<td width=\'20%\'></td>\n\t<td width=\'40%\'></td>\n</tr>\n\n<tr>\n<td class=label >File Control Type</td>\n<td align=left>\n<select name =\'file_ctrl_type\' >\n\t<option value=\'\'>----------Select--------</option>\n\t<option value=\'H\' ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =">File Header</option>\n\t<option value=\'F\' ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =">File Footer</option>\n</select>\n<img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td><td> </td>\n</tr>\n\n\n<tr>\n<td class=label >Segment Name</td>\n<td align=left>\n\t<input type=\"hidden\" name=\"segment_type_id\" id=\"segment_type_id\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=text id=\"segment_type\"  name=segment_type size=35 value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  > <input class=\"button\" type=\"button\"  name=SegmentTypeSearch value=\'?\'    onClick=\"searchSegmentType()\">\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td><td> </td>\n</tr>\n\n<tr id=\'IncDel\' style=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n<td> </td><td> </td>\n<td colspan=2 class=\"BUTTON\"><input class=\'button\' type=\'button\'  name=\'Record\' id=\'Record\' value=\'Record\' onClick=\"record(\'I\')\">\n<input class=\'button\' type=\'button\'  name=\'delete\' id=\'delete\' value=\'Delete\' onClick=\"deleteRecord()\">\n<input class=\'button\' type=\'button\'  name=\'Cancel\' id=\'Cancel\' value=\'Cancel\' onClick=\"cancel()\"></td>\n</tr>\n\n<tr id=\'ExcDel\' style=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n<td> </td><td> </td>\n<td colspan=2 class=\"BUTTON\"><input class=\'button\' type=\'button\'  name=\'Record\' id=\'Record\' value=\'Record\' onClick=\"record(\'I\')\">\n<!--<input class=\'button\' type=\'button\'  name=\'delete\' id=\'delete\' value=\'Delete\' onClick=\"deleteRecord()\"> -->\n<input class=\'button\' type=\'button\'  name=\'Cancel\' id=\'Cancel\' value=\'Cancel\' onClick=\"cancel()\"></td>\n</tr>\n\n<tr>\n\t<td width=\'20%\'></td>\n\t<td width=\'40%\'></td>\n\t<td width=\'20%\'></td>\n\t<td width=\'40%\'></td>\n</tr>\n</table>\n\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<input type=\"hidden\" name=\"act_mode\" id=\"act_mode\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'> \n<input type=\"hidden\" name=\"srlno\" id=\"srlno\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\n</form>\n</BODY>\n</HTML> \n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 // String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block2Bytes, _wl_block2);
  
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
String IndelStyle = "";
String ExdelStyle = "";

            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);


String segment_type_id="";
String segment_type="";
String file_ctrl_type=""; 
String srlno="";

String mode			=	request.getParameter("mode");
if(mode.equals("U"))
{
	IndelStyle	 = "display:block";
	ExdelStyle = "display:none";
	srlno=request.getParameter("srlno");
	segment_type=request.getParameter("segment_type");
	segment_type_id		=	request.getParameter("segment_type_id");
	file_ctrl_type=request.getParameter("file_ctrl_type");
}
else{
	IndelStyle	 = "display:none";
	ExdelStyle = "display:block";
}

//segment_type_id		=	request.getParameter("segment_type_id");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(file_ctrl_type.equals("H")?"selected":""));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(file_ctrl_type.equals("F")?"selected":""));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(segment_type_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(IndelStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ExdelStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);

		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(srlno));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
