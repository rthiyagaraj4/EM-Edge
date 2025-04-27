package jsp_servlet._emr._jsp;

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
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __selectproblemframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/selectProblemFrames.jsp", 1732528406897L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<head>\n\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<iframe name=\"selectProblemFrame\" id=\"selectProblemFrame\" src=\'../../eMR/jsp/selectProblem.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0 ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="scrolling=\"Yes\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" noresize style=\'height:82vh;width:95vw\'></iframe>\n<iframe name=\"selectProblemButton\" id=\"selectProblemButton\" src=\'../../eMR/jsp/selectProblemButton.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 scrolling=\"no\" noresize style=\'height:8vh;width:95vw\'></iframe>\n\n</html>\n\n";
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
	java.util.Properties p			= (java.util.Properties) session.getValue( "jdbc" ) ;

	String facility_id				= (String) session.getValue("facility_id");
	String qrystr			= request.getQueryString();
	String callFunction     = request.getParameter("callFunction");
	String short_desc       = request.getParameter("short_desc");
	String encounter_id       = request.getParameter("encounter_id");
	String term_code       = request.getParameter("term_code");
	String occur_srl_no       = request.getParameter("occur_srl_no");
	String term_set_id       = request.getParameter("term_set_id");
	String Title			="";
	Connection con					= null;
	Statement		stmt			= null;
	ResultSet rs					= null;
	StringBuffer sdesc				= new StringBuffer();

	con	= ConnectionManager.getConnection(request);

	String diag_desc = "";
	try
	{
		if(sdesc.length() > 0) sdesc.delete(0,sdesc.length());

		 sdesc.append("select term_code_short_desc from pr_diagnosis_compl_enc_dtl a where a.facility_id='"+facility_id+"' and a.encounter_id='"+encounter_id+"' and a.term_set_id='"+term_set_id+"'  "); 
		
		//if(!term_code.equals("*OTH"))
			sdesc.append("and a.term_code = '"+term_code+"' ");
		//else
			sdesc.append("and a.occur_srl_no = '"+occur_srl_no+"' ");
			stmt   = con.createStatement();
			rs	   = stmt.executeQuery(sdesc.toString());
		while(rs.next()){
				diag_desc=rs.getString("term_code_short_desc");
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

	}
	catch(Exception e){
	}finally{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con!=null){
			ConnectionManager.returnConnection(con,request);
		}
 }

	if(callFunction.equals("showProblem"))
		Title				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChiefComplaint.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.for.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")+" "+diag_desc;
	else
		Title				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Select.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Problem.label","common_labels");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Title));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(qrystr));
            _bw.write(_wl_block8Bytes, _wl_block8);
if(!callFunction.equals("showProblem")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qrystr));
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
