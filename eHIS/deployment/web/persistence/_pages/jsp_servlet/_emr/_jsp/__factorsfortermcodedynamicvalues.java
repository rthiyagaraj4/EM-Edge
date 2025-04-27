package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __factorsfortermcodedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/FactorsForTermCodeDynamicValues.jsp", 1709118921610L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n<head>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body onKeyDown=\'lockKey()\'>\n<form name=\'fact_for_dynaval\' id=\'fact_for_dynaval\'>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<INPUT TYPE=\"hidden\" name=\'chkselect\' id=\'chkselect\' value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String factor_val = request.getParameter("factor_val")==null?"":request.getParameter("factor_val");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(factor_val));
            _bw.write(_wl_block3Bytes, _wl_block3);

				 RecordSet FactorsForTermCodebn	=	null;
							   ArrayList arr_factor = null;
try
{
	con = ConnectionManager.getConnection(request);
	
	
	FactorsForTermCodebn = (webbeans.eCommon.RecordSet)	session.getAttribute("FactorsForTermCodebn");
	if(factor_val.equals("FACTORSCLEARED"))
		FactorsForTermCodebn.clearAll();
	else if(factor_val.equals("FACTORSSELECTED"))
	{
		String sql_factors = "select factor_code, long_desc factor_desc,	decode(defn_characteristic_yn,'Y','Defining Characteristics',		decode(related_factor_yn||risk_factor_yn,'YY','Related & Risk Factor','YN','Related Factor','NY','Risk Factor'))factor_type,defn_characteristic_yn,related_factor_yn,risk_factor_yn,'I' db_action from mr_factor where factor_code not in (select factor_code from mr_factor_for_term_code where term_set_id = ? and term_code =?) and eff_status = 'E' union all select a.factor_code, b.long_desc factor_desc, decode(b.defn_characteristic_yn,'Y','Defining Characteristic',		decode(b.related_factor_yn||b.risk_factor_yn,'YY','Related & Risk Factor','YN','Related Factor','NY','Risk Factor')) factor_type,b.defn_characteristic_yn,b.related_factor_yn,b.risk_factor_yn,'U' db_action  from mr_factor_for_term_code a, mr_factor b where a.term_set_id = ? and a.term_code = ? and b.factor_code=a.factor_code order by factor_desc";
		FactorsForTermCodebn.clearAll();
		pstmt = con.prepareStatement(sql_factors);
		pstmt.setString(1,term_set_id);
		pstmt.setString(2,term_code);
		pstmt.setString(3,term_set_id);
		pstmt.setString(4,term_code);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				arr_factor = new ArrayList();
				arr_factor.add(rs.getString("factor_code"));
				arr_factor.add(rs.getString("defn_characteristic_yn"));
				arr_factor.add(rs.getString("related_factor_yn"));
				arr_factor.add(rs.getString("risk_factor_yn"));
				FactorsForTermCodebn.putObject(arr_factor);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
	}
	if ( arr_factor != null ) arr_factor.clear();
}
catch (Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
