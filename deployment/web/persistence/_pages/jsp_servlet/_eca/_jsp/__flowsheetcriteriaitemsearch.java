package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __flowsheetcriteriaitemsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetCriteriaItemSearch.jsp", 1709115882466L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t\t<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t\t\t<script src=\'../../eCA/js/FlowSheet.js\' language=\'javascript\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t\t</head>\n\n\t<body   class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\tif(top.content!= null)\n\t\t\t\t\t{\t\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[0].document.forms[0].event_item.value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t\t\t\ttop.content.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\' ;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\t\n\t\t\t\t\t\tparent.criteria_f0.criteria_f1.document.forms[0].event_item.value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'\t;\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\' ;\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script language=javascript>\n\t\t\t\t\tif(top.content!=null)\n\t                {\n\t\t\t\t\t\ttop.content.workAreaFrame.frames[0].document.forms[0].event_item_but.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.criteria_f0.criteria_f1.document.forms[0].event_item_but.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\t\tcallfunctionitemsearch();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</body>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\n";
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
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String eventItem=request.getParameter("eventItem")==null?"":request.getParameter("eventItem");
	String hist_type=request.getParameter("history_type");
	String resEventItem	="";
	int count=0;
	try{
			con=ConnectionManager.getConnection(request);
			if (!eventItem.equals("")){
				eventItem = eventItem+"%";
			}
				
			//String sql= " select EVENT_CODE ,long_desc SHORT_DESC from CR_CLIN_EVENT_MAST where hist_rec_type= ? and upper(SHORT_DESC) like upper(?) ";

			String sql= " select EVENT_CODE ,long_desc SHORT_DESC from CR_CLN_EVT_MST_LANG_VW where hist_rec_type= ? and upper(SHORT_DESC) like upper(?) and language_id = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,hist_type);
			pstmt.setString(2,eventItem);
			pstmt.setString(3,locale);
			rset=pstmt.executeQuery();

			while(rset.next())
			{
				resEventItem = rset.getString("SHORT_DESC");
				count++;
			}

			if (count == 1)
			{
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(resEventItem));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(resEventItem));
            _bw.write(_wl_block8Bytes, _wl_block8);
 }
	
			if (count>1 || count==0)
			{
            _bw.write(_wl_block9Bytes, _wl_block9);
}
	
		if (rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	
	}catch(Exception e){
					//out.println("Error Raise"+e);//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
	}finally{
			
			if (con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
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
