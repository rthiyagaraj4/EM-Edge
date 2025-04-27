package jsp_servlet._eqa._jsp;

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

public final class __qamodifyindicatorsfordiscipline extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAModifyIndicatorsForDiscipline.jsp", 1742817545536L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language=\'javascript\'  src=\'../../eCommon/js/ValidateControl.js\' ></script>\n\t<script type=\'text/javascript\' src=\'../../eQA/js/QAIndicatorGroup.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eQA/js/QAValidate.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\'  src=\'../../eCommon/js/MstCodeCommon.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\t\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n\t<body  onKeyDown = \'lockKey()\' >\n\t<form name=\'QA_fac_ind\' id=\'QA_fac_ind\' target=\'messageFrame\' method=\'post\' action = \'\'  >\n\t<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n  <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\n  <tr>\n  <td width=\'40%\' >&nbsp;</td>\n  \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n\n  <tr>\n      <td width=\'40%\' align=\'right\' class=\'label\' >Discipline</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t  \n\t\t\t<input type=\'text\' name=\'oper_name\' id=\'oper_name\' size=\'30\'  value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'  maxlength=\'30\' readonly >&nbsp;\n\t\t\t<input type=\'hidden\' name=\'qind_discipline_id\' id=\'qind_discipline_id\' size=\'2\'  value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>&nbsp;\n\t       </td>\n    </tr>\n\t\n  <tr>\n  <td width=\'40%\' >&nbsp;</td>\n  \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n\t<tr>\n      <td width=\'40%\' align=\'right\' class=\'label\'>Indicator ID</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t  \n\t\t\t<input type=\'text\' name=\'qind\' id=\'qind\' size=\'2\'  value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'  maxlength=\'2\' onBlur=\'ChangeUpperCase(this)\' readonly onKeyPress=\'return CheckForSpecChars(event)\'>&nbsp;\n\t       </td>\n    </tr>\n  \n  <tr>\n           <td width=\'40%\' >&nbsp;</td>\n  \t     <td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  \n  <tr>\n      <td width=\'40%\' align=\'right\' class=\'label\' nowrap>&nbsp;Indicator Description</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t  \n\t\t\t<input type=\'text\' name=\'qinddesc\' id=\'qinddesc\' size=\'60\'  value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'  maxlength=\'60\'  readonly onKeyPress=\'return CheckForSpecChars(event)\'>&nbsp;\n\t       </td>\n    </tr>\n  <tr>\n           <td width=\'40%\' >&nbsp;</td>\n  \t     <td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n  <tr>\n      <td width=\'40%\' align=\'right\' class=\'label\'>Serial No</td>\n      <td width=\'60%\' align=\'left\' colspan=\'2\'>\n      &nbsp;&nbsp;\n\t  \n\t\t\t<input type=\'text\' name=\'serlno\' id=\'serlno\' size=\'3\'  value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'  maxlength=\'60\'  readonly onKeyPress=\'return CheckForSpecChars(event)\'>&nbsp;\n\t       </td>\n    </tr>\n  </tr>\n\t<td width=\'40%\' >&nbsp;</td>\n    \t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n  </tr>\n\n\n  </table>\n\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n</form>\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}


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

		Connection conn			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
        String qind_clind_desc  = "";
	    String disp_name        = "";
        String qind_slno        = "";
		try
		{
		String qind_clind_id=request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	
		String qind_discipline_id=request.getParameter("qind_discipline_id")==null ?"":request.getParameter("qind_discipline_id");	
		String mode="U";
	
        conn = ConnectionManager.getConnection(request);

        pstmt=conn.prepareCall("select qind_discipline_desc,qind_clind_id,qind_clind_desc ,qind_slno from qa_qind_discipline_clind_vw  where qind_clind_id=? and qind_discipline_id=?");
		pstmt.setString(1,qind_clind_id);
		pstmt.setString(2,qind_discipline_id);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
		
		disp_name      =  checkForNull(rs.getString("qind_discipline_desc"));
		qind_clind_id  =  checkForNull(rs.getString("QIND_CLIND_ID"));
		qind_clind_desc=  checkForNull(rs.getString("qind_clind_desc"));
        qind_slno      =  checkForNull(rs.getString("qind_slno"));

  	}   if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		


            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(disp_name));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(qind_discipline_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(qind_clind_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(qind_clind_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(qind_slno));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		catch(Exception e)
		{
		out.println("Exception in File QAModifyIndicatorsForDiscipline"+e.toString());
		}
		finally
		{
		
	    ConnectionManager.returnConnection(conn,request);
		
		}
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
