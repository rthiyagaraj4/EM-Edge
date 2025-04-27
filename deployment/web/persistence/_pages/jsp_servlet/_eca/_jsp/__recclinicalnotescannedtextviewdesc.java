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

public final class __recclinicalnotescannedtextviewdesc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesCannedTextViewDesc.jsp", 1739364477407L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n22/03/2013\tIN038542\t\tKarthi L \tCreate text block and assigned practitioner. this canned text does not appear in the transaction in CA\t\t\n\t\t\t\t\t\t\t\t\t\t\n--------------------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html> \n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n<!-- This was commented before changes to the style sheet for V3....So no style sheet has been added... -->\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction doInit()\n{\n\tvar val \t= window.dialogArguments;\n\tdocument.getElementById(\"comments\").innerHTML = \"<pre>\" + val + \"</pre>\";\n\t//document.getElementById(\"comments\").focus();\n}\n\n\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n</head>\n<!--[IN033786]<body onload=\'doInit()\'  style=\'background-color:#E2E3F0;\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>-->\n<body   style=\'background-color:#E2E3F0;\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<div style=\"overflow: auto;height:90vh\">\n<table width=\'100%\' align=\'center\' height=100% border=\'1\' cellspacing=\'0\' cellpadding=\'3\'  style=\'background-color:white\'>\n\t\n\t<tr>\n\t\t<!--[IN033786]<td  width=\'100%\' height=\'100%\' class=\'label\' id=\"comments\">&nbsp;&nbsp;</td>-->\n\t\t<td  width=\'100%\' height=\'100%\' class=\'label\' id=\"comments\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t</tr>\n</table>\n</div>\n</body>\n</html>\n\n";
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String title_name = request.getParameter("title_name");
  if(title_name==null || title_name=="" || title_name.equals(""))
  title_name = "";
  //[IN033786] Start
  String textType = request.getParameter("textType");
  String text_blk_id = request.getParameter("text_blk_id");
  String locale = request.getParameter("locale");
  String l_pract_id = (String)session.getValue("ca_practitioner_id"); // IN038542
  String service_code = request.getParameter("service_code");
  String login_user_id = request.getParameter("login_user_id");
  String note_type = request.getParameter("note_type");
  String sec_hdg_code = request.getParameter("sec_hdg_code");
  String text_blk = "";
  String query_canned_text ="";
  Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	
	try
		{
			con				=	ConnectionManager.getConnection(request);
			
			if("T".equals(textType)){ 				
				query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='T' AND text_blk_id = ? AND CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL ORDER BY text_blk_id";
			}else{ 
				query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='E' AND text_blk_id = ? AND  CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL ORDER BY text_blk_id";
			}
			
			pstmt		=	con.prepareStatement(query_canned_text);

			pstmt.setString(1,locale);
			pstmt.setString(2,service_code);
			pstmt.setString(3,service_code);
			//pstmt.setString(4,login_user_id); commented for  IN038542
			//pstmt.setString(5,login_user_id); commented for  IN038542
			pstmt.setString(4,l_pract_id); // IN038542
			pstmt.setString(5,l_pract_id); // IN038542
			pstmt.setString(6,note_type);
			pstmt.setString(7,note_type);
			pstmt.setString(8,sec_hdg_code);
			pstmt.setString(9,sec_hdg_code);			
			pstmt.setString(10,text_blk_id);
			pstmt.setString(11,locale);

			rs			=	pstmt.executeQuery();
			
			if(rs.next()){
			text_blk		=	rs.getString("text_blk");
			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@1: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
  //[IN033786] End
  

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(title_name));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(text_blk));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
