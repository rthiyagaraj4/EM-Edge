package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __viewcareplanvariance extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ViewCarePlanVariance.jsp", 1736916441671L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCP/js/CpMessages.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script> -->\n<script language=\"JavaScript\" src=\"../../eCP/js/CarePlanVariance.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCP/js/ViewCarePlan.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCP/js/CpMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\nTD.FONTVALHYPER\n{\n\tFONT-SIZE: 10 ;\n\tcolor:BLUE;\n\tcursor:pointer;\n}\n</style>\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body onMouseDown=\"CodeArrest()\"  onload=\'FocusFirstElement()\' onKeyDown=\"lockKey()\" >\n<form name=\"CarePlanVarianceDetail_Form\" id=\"CarePlanVarianceDetail_Form\" method=\"post\" action=\"\" target=\"care_plan_dyn_val\">\n<table cellpadding=0 cellspacing=0 width=\"100%\" border=0>\n\n<tr>\n<td align=\"left\" class=\"data\" colspan=\"5\">List of Variances</td>\n</tr>\n</table>\n<table cellpadding=0 cellspacing=0 width=\"100%\" border=1>\n<tr>\n<th  width=\'36%\' align=\'center\'>Outcome</th>\n<th  width=\'25%\' align=\'center\'>Cause</th>\n<th  width=\'25%\' align=\'center\'>Reason</th>\n<th  width=\'7%\' >&nbsp;</th>\n<th  width=\'7%\' >&nbsp;</th>\n</tr>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<tr>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<td align=\'left\'  class=\"label\"  >";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<td align=\'left\' class=\"label\">&nbsp;</td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<td align=\'left\' class=\"label\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td align=\'left\' class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<td align=\'center\' class=\"FONTVALHYPER\" onClick=\"getRemarks(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\" nowrap>Remarks</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<td align=\'center\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<td align=\'center\' class=\"FONTVALHYPER\" onClick=\"getActionPlan(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\" nowrap>Action Plan</td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</table>\n<input type=hidden name=\"p_care_plan_id\" id=\"p_care_plan_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=hidden name=\"p_md_care_plan_id\" id=\"p_md_care_plan_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=hidden name=\"p_var_comp_type\" id=\"p_var_comp_type\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<body>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
RecordSet	CarePlanVariance	=	null;
CarePlanVariance	=	(webbeans.eCommon.RecordSet)session.getAttribute("CarePlanVariance");
Connection conn=null;

PreparedStatement pstmt=null;
ResultSet rset=null;

try
{
conn=ConnectionManager.getConnection(request);


String p_care_plan_id=request.getParameter("p_care_plan_id")==null?"":request.getParameter("p_care_plan_id");
String p_md_care_plan_id=request.getParameter("p_md_care_plan_id")==null?"":request.getParameter("p_md_care_plan_id");
String p_var_comp_type=request.getParameter("p_var_comp_type")==null?"":request.getParameter("p_var_comp_type");
String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");


            _bw.write(_wl_block4Bytes, _wl_block4);

String expected_outcome="";
String expected_outcome_desc="";
String variance_cause="";
String variance_cause_desc="";
String variance_reason="";
String variance_reason_desc="";
String variance_remark="";
String variance_action_plan="";
pstmt=conn.prepareStatement("select a.var_outcome_code expected_outcome,b.short_desc expected_outcome_desc,a.var_cause_code variance_cause,c.var_cause_desc variance_cause_desc,a.var_reason_code variance_reason,d.var_reason_desc variance_reason_desc, a.variance_remarks variance_remark,a.action_plan variance_action_plan from cp_pat_care_plan_var_dtl a,cp_outcome b,cp_variance_cause c,cp_variance_reason d where md_care_plan_id=? and care_plan_id=? and var_comp_type=? and a.added_facility_id=? and a.VAR_OUTCOME_CODE=b.outcome_code(+) and a.VAR_CAUSE_CODE=c.var_cause_code and a.VAR_REASON_CODE=d.VAR_REASON_CODE order by variance_log_id,srl_no");
	pstmt.setString(1,p_md_care_plan_id);
	pstmt.setString(2,p_care_plan_id);
	pstmt.setString(3,p_var_comp_type);
	pstmt.setString(4,facility_id);
	rset=pstmt.executeQuery();

	
while(rset!=null && rset.next())
{
	
        expected_outcome	=	checkForNull(rset.getString("expected_outcome"));
        expected_outcome_desc=checkForNull(rset.getString("expected_outcome_desc"));
        variance_cause=checkForNull(rset.getString("variance_cause"));
        variance_cause_desc=checkForNull(rset.getString("variance_cause_desc"));
        variance_reason=checkForNull(rset.getString("variance_reason"));
        variance_reason_desc=checkForNull(rset.getString("variance_reason_desc"));
        variance_remark=checkForNull(rset.getString("variance_remark"));
        variance_action_plan=checkForNull(rset.getString("variance_action_plan"));
		

            _bw.write(_wl_block5Bytes, _wl_block5);

	if(!(expected_outcome.equals("")))
	{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(expected_outcome_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);

	}
    else
	{

            _bw.write(_wl_block8Bytes, _wl_block8);

	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(variance_cause_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(variance_reason_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);

	if(!(variance_remark.equals("")))
	{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(variance_remark));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
    else
	{

            _bw.write(_wl_block13Bytes, _wl_block13);

	}
    if(!(variance_action_plan.equals("")))
	{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(variance_action_plan));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}
  else
	{

            _bw.write(_wl_block13Bytes, _wl_block13);

	}

            _bw.write(_wl_block16Bytes, _wl_block16);


}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_care_plan_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_md_care_plan_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_var_comp_type));
            _bw.write(_wl_block20Bytes, _wl_block20);

}
catch(Exception exp)
{
  System.out.println("111 Exception in ViewCarePlanVariance.jsp="+exp.toString());
  exp.printStackTrace();
}
finally
{
	try
	{

	if(rset!=null)	 rset.close();
	if(pstmt!=null)	 pstmt.close();
	
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception exp)
	{
		System.out.println("2222 Exception in ViewCarePlanVariance.jsp="+exp.toString());
		exp.printStackTrace();
	}
}

            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
