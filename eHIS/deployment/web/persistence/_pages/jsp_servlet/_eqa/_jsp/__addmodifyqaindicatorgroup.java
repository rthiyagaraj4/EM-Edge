package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __addmodifyqaindicatorgroup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/addModifyQAIndicatorGroup.jsp", 1742817542173L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script type=\'text/javascript\' src=\'../../eQA/js/QAIndicatorGroup.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/MstCodeCommon.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'QA_QIND_GROUP\' id=\'QA_QIND_GROUP\' target=\'messageFrame\' method=\'post\' action = \'../../servlet/eQA.QAIndicatorGroupServlet\'  >\n<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n<tr>\n\t<td width=\'40%\' >&nbsp;</td>\n\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td width=\'40%\' align=\'right\' class=\'label\'>Group Code</td>\n\t<td width=\'60%\' align=\'left\' colspan=\'2\'> &nbsp;\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<input type=\'text\' name=\'QIND_GROUP_ID\' id=\'QIND_GROUP_ID\' size=\'4\'  value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' maxlength=\'4\' onBlur=\'ChangeUpperCase(this);\' readonly >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t  <input type=\'text\' name=\'QIND_GROUP_ID\' id=\'QIND_GROUP_ID\' size=\'4\'   value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'  maxlength=\'4\' \n\t\t\t onKeyPress=\'return CheckForSpecChars(event)\' onBlur=\'ChangeUpperCase(this)\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</td>\n</tr>\n<tr>\n\t<td width=\'40%\' >&nbsp;</td>\n\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td width=\'40%\' align=\'right\' class=\'label\'>Description</td>\n\t<td width=\'60%\' align=\'left\' colspan=\'2\'>&nbsp;\n\t<input type=\'text\' name=\'QIND_GROUP_DESC\' id=\'QIND_GROUP_DESC\' size=\'30\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="  maxlength=\'40\' >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n<tr>\n\t<td width=\'40%\' >&nbsp;</td>\n\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td width=\'40%\' align=\'right\' class=\'label\'>Enabled</td>\n    <td width=\'60%\' align=\'left\' colspan=\'2\'>&nbsp;\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<input type=\'checkbox\' name=\'EFF_STATUS\' id=\'EFF_STATUS\'  value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  onClick=\'funCheckBox(); \'  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<input type=\'checkbox\' name=\'EFF_STATUS\' id=\'EFF_STATUS\'   value=\'E\' onClick=\'funCheckBox(); \' checked >\t  \n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n    &nbsp;</td>\n</tr>\n<tr>\n\t<td width=\'40%\' >&nbsp;</td>\n\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection conn         = null;
	PreparedStatement pstmt = null;
	ResultSet rs            = null;
	String qind_group_id=request.getParameter("qind_group_id")==null ?"":request.getParameter("qind_group_id");	
	String mode             = "";
	String qind_group_desc  = "";
	String eff_status       = "";
	String status           = "";
	String disabledfield      ="";
	try
	{
		conn = ConnectionManager.getConnection(request);
		if(!qind_group_id.equals(""))
		{  
			pstmt=conn.prepareStatement("select QIND_GROUP_ID,QIND_GROUP_DESC QADES,EFF_STATUS ES From QA_QIND_GROUP where QIND_GROUP_ID=?");
			pstmt.setString(1,qind_group_id);
			rs=pstmt.executeQuery();
			if(rs.next()==true)			
			{
				 mode="U";
				 qind_group_desc=rs.getString("QADES");
				 eff_status=rs.getString("ES");
				 if(eff_status.equals("E"))
				 status="checked";
				 else
                 disabledfield="disabled";
			 }
	    }
	    else
	 		 mode="I";
   
   if(rs!=null)rs.close();
   if(pstmt!=null)pstmt.close();	
   }
   catch(Exception ee)
   {
		out.println("Error"+ee);
   }
   finally
   { 
	 ConnectionManager.returnConnection(conn, request);
   }

            _bw.write(_wl_block4Bytes, _wl_block4);
if(mode.equalsIgnoreCase("U")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(qind_group_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
} else {
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(qind_group_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(qind_group_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disabledfield));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(mode.equalsIgnoreCase("U")) {
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(status));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else { 
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mode));
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
