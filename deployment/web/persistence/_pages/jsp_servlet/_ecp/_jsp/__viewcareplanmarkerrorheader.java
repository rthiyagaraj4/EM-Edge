package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __viewcareplanmarkerrorheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ViewCarePlanMarkErrorHeader.jsp", 1709116630183L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCP/js/common.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\"../../eCommon/js/MstCodeCommon.js\" language=\"javascript\"></script>\n<script src=\"../../eCP/js/ViewCarePlan.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCP/js/CpMessages.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</head>\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\"view_cp_mrk_err_hdr_form\" id=\"view_cp_mrk_err_hdr_form\">\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<tr >\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'  colspan=\'2\'>&nbsp;Care Manager Name</td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'>&nbsp;Start Date</td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'>&nbsp;Target Date</td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'>&nbsp;Status</td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'  colspan=\'2\'><b>&nbsp;";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</b></td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'><b>&nbsp;";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b></td>\n\t</tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<tr>\n\t\t<td class = \'ITRVNHDR\' width=\'25%\' align=\'left\' colspan=\'2\'>&nbsp;&nbsp;&nbsp;&nbsp;<B>Evaluation Date</B></td>\n\t\t<td class = \'ITRVNHDR\' width=\'20%\' align=\'left\'><B>Evaluated By</B></td>\n\t\t<td class = \'ITRVNHDR\' width=\'20%\' align=\'left\' colspan=\'2\'><B>Remarks</B></td>\n\t</tr>\n";
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

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);


String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String care_plan_id = request.getParameter("planid");
String md_plan_id = request.getParameter("md_plan_id");
String cp_start_date = request.getParameter("cp_start_date");
String cp_target_date = request.getParameter("cp_target_date");
String current_status = request.getParameter("current_status");
String care_mgr_name = request.getParameter("care_mgr_name");
String remarks = "";
String error_color = "";
String error_color_plus = "";
if(current_status.equals("O"))
	current_status = "Pending";
else if(current_status.equals("C"))
	current_status = "Completed";
else if(current_status.equals("A"))
	current_status = "Active";
else if(current_status.equals("D"))
	current_status = "Discontinued";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(care_mgr_name));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(cp_start_date));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(cp_target_date));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(current_status ));
            _bw.write(_wl_block8Bytes, _wl_block8);

try
{
	con = ConnectionManager.getConnection(request);
	String sql = "select eval_id,practitioner_name,to_char(eval_datetime,'dd/mm/yyyy hh:mi') eval_date,remarks,status from cp_pat_care_plan_eval,am_practitioner where md_care_plan_id=? and care_plan_id=? and practitioner_id=eval_by order by eval_id DESC";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,md_plan_id);
	pstmt.setString(2,care_plan_id);
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
		int i = 0;

            _bw.write(_wl_block9Bytes, _wl_block9);

		while(rs.next())
		{
			if(rs.getString("status").equals("E"))
			{
				error_color = "red";
				error_color_plus = "red";
			}
			else
			{
				error_color = "";
				error_color_plus = "blue";
			}
			remarks = rs.getString("remarks")==null?"&nbsp;":rs.getString("remarks");
			out.println("<tr>");
			out.println("<td width='1%'class='label' onclick=viewCarePlanShowDetail('"+md_plan_id+"','"+care_plan_id+"','"+rs.getString("eval_id")+"')><font color='"+error_color_plus+"'  style='cursor:pointer'><B>+&nbsp;</B></font></td>");
			out.println("<td width='25%' class='label' align='left'>&nbsp;<font  color='"+error_color+"'>"+rs.getString("eval_date")+"</font></td>");
			out.println("<td width='20%' class='label' align='left'><font color='"+error_color+"'>"+rs.getString("practitioner_name")+"</font></td>");
			out.println("<td width='20%' class='label' align='left'><font color='"+error_color+"' onclick=viewCarePlanCallreason('"+md_plan_id+"','"+care_plan_id+"','"+rs.getString("eval_id")+"') style='cursor:pointer'><B>Text</B></font></td>");
			out.println("<td width='20%'class='label' align='left'>&nbsp;</td>");
			out.println("</tr>");
			i++;
		}
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}
catch (Exception e)
{
	e.printStackTrace(System.err);
	System.out.println("Exception in ViewCarePlanMarkErrorHeader.jsp="+e.toString());
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
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
