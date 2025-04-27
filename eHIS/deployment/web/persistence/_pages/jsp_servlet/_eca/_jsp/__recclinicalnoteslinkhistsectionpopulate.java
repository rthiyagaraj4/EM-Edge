package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkhistsectionpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkHistSectionPopulate.jsp", 1738316282456L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n\n<html><head>\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=javascript src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=javascript src=\'../../eCA/js/RecClinicalNotesLinkHist.js\'></script>\n <script language=\'javascript\'>\n\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n   \t\t\t\t\n\t\t\tvar opt\t\t=\tparent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.createElement(\'OPTION\'); \n \t\t\t\topt.text\t=\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\topt.value\t=\t\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tparent.RecClinicalNotesLinkHistNoteCriteriaFrame.document.forms[0].section.add(opt); \n \t\t \t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n</head><body class=\'MESSAGE\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'></body></html>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</head>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection			conlCon		=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rslRst		=	null;

	
	String	note_type	="";
	String	sec_hdg_code	="";
	String	sec_hdg_desc	="";
	//String	child_sec_hdg_code	="";
	//String	child_sec_hdg_desc	="";
	

	try	{
		conlCon				=	(Connection)	ConnectionManager.getConnection(request);
		note_type		=	(request.getParameter("note_type")==null)	? "" : request.getParameter("note_type");
	
		
				String sblQry = "select SEC_HDG_CODE,SEC_HDG_DESC,CHILD_SEC_HDG_CODE,CHILD_SEC_HDG_DESC from ca_note_section_view where NOTE_TYPE=? order by NOTE_SEC_SEQ_NUM,CHILD_SEQ_NUM";
				//String sblQry = "SELECT A.NOTE_TYPE ,A.SEC_HDG_CODE ,C.SEC_HDG_DESC ,A.NOTE_SEC_SEQ_NUM ,D.CHILD_SEC_HDG_CODE ,D.CHILD_SEQ_NUM ,E.SEC_HDG_DESC CHILD_SEC_HDG_DESC ,E.CONTENT_TYPE CHILD_SEC_CONTENT_TYPE FROM CA_NOTE_SECTION A,CA_NOTE_TYPE B,CA_SECTION_HDG_LANG_VW C,CA_SUBSECTION_LINK D ,CA_SECTION_HDG_LANG_vW E WHERE B.NOTE_TYPE=A.NOTE_TYPE AND C.SEC_HDG_CODE=A.SEC_HDG_CODE AND D.HEADER_SEC_HDG_CODE(+)=C.SEC_HDG_CODE  AND E.SEC_HDG_CODE(+)=D.CHILD_SEC_HDG_CODE  and C.LANGUAGE_ID = ? AND E.LANGUAGE_ID = ?";
				pstmt = conlCon.prepareStatement( sblQry);
				
				pstmt.setString(1,note_type);
				rslRst = pstmt.executeQuery();

				while(rslRst.next()) {
					
				sec_hdg_code		=	rslRst.getString("SEC_HDG_CODE");
				sec_hdg_desc		=	rslRst.getString("SEC_HDG_DESC");
				//child_sec_hdg_code	=	rslRst.getString("CHILD_SEC_HDG_CODE");
				//child_sec_hdg_desc	=	rslRst.getString("CHILD_SEC_HDG_DESC");
					
 
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block9Bytes, _wl_block9);

			} // end of while

				
		if(rslRst!=null) rslRst.close();
		if(pstmt!=null) pstmt.close();
		 // end of if(pop_mode.equals("section"))
		
	}catch(Exception e){
		//out.println("Exception@1: "+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}finally{

            _bw.write(_wl_block10Bytes, _wl_block10);
		
		if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
	//out.println("<script>alert('note_type"+note_type+"')</script>");
	//out.println("<script>alert('sec_hdg_desc"+sec_hdg_desc+"')</script>");
	}


            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
