package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __addassociatecodegetdiagval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AddAssociateCodeGetDiagVal.jsp", 1709118859454L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<HTML>\n<HEAD>\n\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n</HEAD>\n<BODY onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = \'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = \'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=false;\n\t\t\t\t\tif(parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value == \'Y\')\n\t\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.doSelect(\'A\');\n\t\t\t\t\telse\n\t\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = \'Y\'\n\n\t\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\talert(parent.getMessage(\"MR_INVALID_DIAG_CODE_FOR_PATIENT\",\"MR\"));\n\t\t\t\t\t\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = \'\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = \'\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = \'\';\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;\n\t\t\t\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = \'\';\n\t\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\talert(getMessage(\'INVALID_DIAGCODE\'));\n\t\t\n\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = \'\';\n\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();\n\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();\n\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = \'\';\n\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = \'\';\n\t\tparent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;\n\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
	Connection con = null;  
	PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
	ResultSet rs = null;
	ResultSet rs1 = null;

try
{
	String diag_code = (request.getParameter("diag_code")==null?"":request.getParameter("diag_code"));
	String p_scheme = (request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme"));
	String sex = (request.getParameter("Sex")==null?"":request.getParameter("Sex"));
	String dob = (request.getParameter("Dob")==null?"":request.getParameter("Dob"));
	String code_indicator = (request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator"));
	String short_desc = "";
	String long_desc = "";

	StringBuffer sql = new StringBuffer();

	sql.append("select short_desc, diag_srl_no, record_type, cause_indicator, analysis_code, notifiable_yn, sensitive_yn, long_desc, code_indicator from mr_icd_code where diag_code=? and diag_code_scheme=?  ");

	if(code_indicator.equals(""))
		sql.append(" and code_indicator in ('C','D','') ");
	else if(code_indicator.equals("C"))
		sql.append("and code_indicator = 'E' ");
	else if(code_indicator.equals("D"))
		sql.append("and code_indicator = 'A' ");

	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(sql.toString());
	pstmt.setString(1, diag_code.toUpperCase());
	pstmt.setString(2, p_scheme);
	if(p_scheme.equals("2"))
		sql.append(" and record_type='D' "); 
	rs = pstmt.executeQuery();
	if(rs.next())
	{
		short_desc = rs.getString("short_desc");
		long_desc = rs.getString("long_desc");
		sql = new StringBuffer();
		sql.append("select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and (gender_spec_ind is null or gender_spec_ind = ? ) and ( age_spec_ind is null or age_spec_ind = (select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ))  ");
		if(code_indicator.equals(""))
		sql.append(" and (code_indicator in ('C','D') or code_indicator is null)");
		else if(code_indicator.equals("C"))
			sql.append("and code_indicator = 'E' ");
		else if(code_indicator.equals("D"))
			sql.append("and code_indicator = 'A' ");

		if(p_scheme.equals("2"))
				sql.append(" and record_type='D' "); 
		pstmt1 = con.prepareStatement(sql.toString());
		pstmt1.setString(1, diag_code.toUpperCase());
		pstmt1.setString(2, p_scheme);
		pstmt1.setString(3, sex);
		pstmt1.setString(4, dob);
		pstmt1.setString(5, dob);
		pstmt1.setString(6, dob);
		rs1 = pstmt1.executeQuery();
		if(rs1.next())
		{
			if(rs1.getInt(1) != 0)
			{
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block4Bytes, _wl_block4);
}
			else
			{
            _bw.write(_wl_block5Bytes, _wl_block5);
}
		}
		if(rs1 !=null) rs1.close();
		if(pstmt1 !=null)pstmt1.close();
	}
	else
	{

            _bw.write(_wl_block6Bytes, _wl_block6);

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	}
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{	
	if(con != null) ConnectionManager.returnConnection(con, request);
}

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
