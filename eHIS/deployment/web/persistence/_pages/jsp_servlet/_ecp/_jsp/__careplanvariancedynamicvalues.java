package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __careplanvariancedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/CarePlanVarianceDynamicValues.jsp", 1741260775699L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
String variance_cause=request.getParameter("variance_cause")==null?"":request.getParameter("variance_cause");
String sql_variance_reason="";
//String variance_reason_code="";
//String variance_reason_desc="";
String[] record	= null;

ArrayList Variance_Reason=new ArrayList();

Connection conn = null;
PreparedStatement pstmt_sql_variance_reason=null;
ResultSet rset_sql_variance_reason = null;

if(mode.equals("1"))
{
try
{
	conn=ConnectionManager.getConnection(request);
//	sql_variance_reason="select var_reason_code,var_reason_desc from cp_variance_reason where var_cause_code = ? order by var_reason_desc";
	sql_variance_reason="SELECT var_reason_code,var_reason_desc FROM cp_variance_reason_LANG_VW WHERE var_cause_code = ? AND LANGUAGE_ID = ? ORDER BY var_reason_desc";
	pstmt_sql_variance_reason=conn.prepareStatement(sql_variance_reason);
	pstmt_sql_variance_reason.setString(1,variance_cause);
	pstmt_sql_variance_reason.setString(2,locale);
	rset_sql_variance_reason=pstmt_sql_variance_reason.executeQuery();

	if(rset_sql_variance_reason!=null)
	{
		while(rset_sql_variance_reason.next())
		{
			record=new String[2];
            record[0]=rset_sql_variance_reason.getString("var_reason_code");
            record[1]=rset_sql_variance_reason.getString("var_reason_desc");
			Variance_Reason.add(record);
		}
	}

	for( int i=0 ; i< Variance_Reason.size() ; i++ ) 
	{
		record = (String[])Variance_Reason.get(i);
		out.println("addVarianceReason(\"" + record[0] + "\",\"" + record[1] + "\") ; " );
	}
}
catch(Exception exp)
{
//	out.println("Exception"+exp.toString());//COMMON-ICN-0181
          exp.printStackTrace();//COMMON-ICN-0181
}
finally
{
  try
  {
  if(rset_sql_variance_reason!=null) rset_sql_variance_reason.close();
  if(pstmt_sql_variance_reason!=null) pstmt_sql_variance_reason.close();
  if(conn!=null) conn.close();
  }
  catch(Exception exp)
  {
	//  out.println(exp.toString());//COMMON-ICN-0181
	     exp.printStackTrace();//COMMON-ICN-0181
  }
}
}
else
{
try
{
RecordSet	CarePlanVariance	=	null;
CarePlanVariance	=	(webbeans.eCommon.RecordSet)session.getAttribute("CarePlanVariance");
String select_mode=request.getParameter("select_mode")==null?"":request.getParameter("select_mode");
String index1="";
String select_yn=request.getParameter("select_yn1")==null?"":request.getParameter("select_yn1");
ArrayList one=new ArrayList();
index1=request.getParameter("index")==null?"":request.getParameter("index");
int index=Integer.parseInt(index1);
if(select_mode.equals("3"))
{
one=(ArrayList)CarePlanVariance.getObject(index);
one.set(5,select_yn);
}
else 
{
	select_yn="Y";
}
}
catch(Exception exp)
{
 // out.println(exp.toString());//COMMON-ICN-0181
    exp.printStackTrace();//COMMON-ICN-0181
}
}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
