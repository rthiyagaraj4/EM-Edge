package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eBL.*;
import eBL.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public final class __blmultifactordeductrulemain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLMultiFactorDeductRuleMain.jsp", 1717650629436L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<HTML>\n\n<HEAD>\n</HEAD>\n<!--\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'</link>\n-->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLMultiFactorDeductRule.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>          \n\t\t\t<iframe name=\'MultiFactorDeductRuleMainFrame\' id=\'MultiFactorDeductRuleMainFrame\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'\' noresize style=\'height:83vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:9vh;width:100vw\'></iframe>  \n\t\t\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script>   \n\t</script>\n</HTML> \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
			String source = url + params ;
			Connection con = null;
			ResultSet rst = null;
			PreparedStatement pstmt = null;
			String MFDRMandYN = "N";
			String drugCatTab_YN = "N";
			String diagCatTab_YN = "N";
			String servicesAndItemsTab_YN = "N";
			String facility_id = (String)session.getAttribute("facility_id");
			
			try{
				
				con = ConnectionManager.getConnection(request);
				//V221017
				String qry_MFDRMandYN = "select NVL(MULTI_FACTOR_DED_RULE_APPL_YN,'N') MULTI_FACTOR_DED_RULE_APPL_YN, NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN, NVL(MFDR_DIAG_CAT_APPL_YN,'N') MFDR_DIAG_CAT_APPL_YN, NVL(MFDR_SERV_ITEM_CAT_APPL_YN,'N') MFDR_SERV_ITEM_CAT_APPL_YN from bl_parameters where OPERATING_FACILITY_ID = '"+facility_id+"'";
			
				pstmt = con.prepareStatement(qry_MFDRMandYN);
				rst = pstmt.executeQuery();
						
				if(rst != null){
					while(rst.next()) {
						MFDRMandYN 	= rst.getString("MULTI_FACTOR_DED_RULE_APPL_YN");
						drugCatTab_YN = rst.getString("MFDR_DRUG_CAT_APPL_YN");
						diagCatTab_YN = rst.getString("MFDR_DIAG_CAT_APPL_YN");
						servicesAndItemsTab_YN = rst.getString("MFDR_SERV_ITEM_CAT_APPL_YN");
					}
				}
				System.err.println("Value of MFDR is: "+MFDRMandYN);
				
				//V221017
			}catch(Exception e){
				System.err.println("Exception is: "+e);
			}finally{
				if(rst !=null) rst.close();
				if(pstmt !=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con);
			}
			
			if(MFDRMandYN.equals("Y") && (diagCatTab_YN.equals("Y") || drugCatTab_YN.equals("Y") || servicesAndItemsTab_YN.equals("Y"))){

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(source));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
				
			   out.println("<script>alert('Multi Factor Deductible Rule is not enabled, cannot use this function');document.location.href='../../eCommon/jsp/dmenu.jsp';</script>"); 
			}
			
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
