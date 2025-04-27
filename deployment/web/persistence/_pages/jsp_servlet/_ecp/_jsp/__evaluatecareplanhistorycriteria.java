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

public final class __evaluatecareplanhistorycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/EvaluateCarePlanHistoryCriteria.jsp", 1736916329415L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n<title>Evaluation History</title>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<!-- <script src=\"../../eCP/js/common.js\" language=\"JavaScript\"></script> -->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></script>\n<!-- <script src=\"../../eCommon/js/MstCodeCommon.js\" language=\"javascript\"></script> -->\n<script src=\"../../eCP/js/EvaluateCarePlan.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCP/js/CpMessages.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\'eval_cp_history_criteria\' id=\'eval_cp_history_criteria\'>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<tr>\n<td width=\"25%\" class=\"ITRVNHDR\" align=\'left\'><B>&nbsp;&nbsp;Evaluation Date</B></td>\n<td width=\"35%\" class=\"ITRVNHDR\" align=\'left\'><B>&nbsp;&nbsp;Evaluated By</B></td>\n<td width=\"35%\" class=\"ITRVNHDR\" align=\'left\'><B>Evaluation Remarks</B></td> \n<td class=\"ITRVNHDR\">&nbsp;</td>\n</tr>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<tr>\n<td width=\"25%\" class=\"label\" align=\'left\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</td> \n<td width=\"35%\" class=\"label\" align=\'left\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n<td width=\"35%\" class=\"label\" align=\'left\' style=\'cursor:pointer;color=#3333FF\' onclick=\"ShowRemarks(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\">Remarks</td> \n<td class=\"label\">&nbsp;</td>\n</tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<tr>\n<td align=\"right\"><input type=button class=\'button\' name=\"close\" id=\"close\" value=\"Close\" onclick=\"wincls()\">&nbsp;&nbsp;&nbsp;&nbsp;</td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

Connection conn = null;
PreparedStatement stmt_eval_cnt = null;
PreparedStatement stmt = null;
ResultSet rs_eval_cnt = null;
ResultSet rset = null;
try
{

int eval_cnt=0;

String care_plan_id=request.getParameter("care_plan_id")==null?"":request.getParameter("care_plan_id") ;
String md_care_plan_id=request.getParameter("md_care_plan_id")==null?"":request.getParameter("md_care_plan_id") ;

String eval_count_sql = "select count(*) from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ? and status = 'V'";

String sql="SELECT a.eval_by,to_char(a.eval_datetime,'dd/mm/yy hh24:mi:ss') eval_date ,to_char(b.care_plan_start_date,'dd/mm/yyyy') start_date,to_char(b.care_plan_target_date,'dd/mm/yyyy') target_date,a.remarks,a.eval_id FROM cp_pat_care_plan_eval a,cp_pat_care_plan b WHERE a.md_care_plan_id=b.md_care_plan_id AND a.care_plan_id=b.care_plan_id AND a.md_care_plan_id=? AND a.care_plan_id=? AND a.status='V' ORDER BY a.eval_datetime  desc";

conn= ConnectionManager.getConnection(request);

try
{
stmt_eval_cnt = conn.prepareStatement(eval_count_sql);
stmt_eval_cnt.setString(1,md_care_plan_id);
stmt_eval_cnt.setString(2,care_plan_id);
rs_eval_cnt = stmt_eval_cnt.executeQuery();

if(rs_eval_cnt!=null)
{
	while(rs_eval_cnt.next())
	{
		eval_cnt=rs_eval_cnt.getInt(1);
	}

}
}
catch(Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs_eval_cnt!=null) rs_eval_cnt.close();
	if(stmt_eval_cnt!=null) stmt_eval_cnt.close();
}


            _bw.write(_wl_block4Bytes, _wl_block4);

String eval_date="";
String eval_date_time="";
String start_date="";
String target_date="";
String remarks="";
String eval_id="";
String eval_by="";

try
{
	stmt=conn.prepareStatement(sql);
	stmt.setString(1,md_care_plan_id);
	stmt.setString(2,care_plan_id);
	rset=stmt.executeQuery();

	if(rset!=null)
	{
		while(rset.next())
		{
			eval_date=rset.getString("eval_date");
			eval_date_time=eval_date.substring(0,14);
			start_date=rset.getString("start_date");
			target_date=rset.getString("target_date");
			remarks=rset.getString("remarks")==null?"":rset.getString("remarks");
			eval_id=rset.getString("eval_id");
			eval_by=rset.getString("eval_by");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(eval_date_time));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(eval_by));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

}
catch(Exception e)
{
//	out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
}
}
catch(Exception e)
{
//	out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rs_eval_cnt!=null) rs_eval_cnt.close();
	if(stmt_eval_cnt!=null) stmt_eval_cnt.close();
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	
	if(conn!=null)
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
