package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __checkfornationality extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/CheckForNationality.jsp", 1709113983258L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	Statement stmt1=null;
	
	Statement stmt2=null;
	Statement stmt3=null;
	Statement stmt4=null;
	ResultSet rs1=null;
	
	ResultSet rs2=null;
	ResultSet rs3 =null;
	ResultSet rs4=null;

	String function = request.getParameter("step");
String locale=(String)session.getAttribute("LOCALE");


try
	{
	conn = ConnectionManager.getConnection(request);

	if ( function.equals("first"))
	{
	stmt1=conn.createStatement();
	String sql1 = "select count(*) from mp_param";
	rs1 = stmt1.executeQuery(sql1);
	rs1.next();

	if ( rs1.getInt(1) == 0 )
		{
		out.println("<script>var error=getMessage('MP_PARAM_NOT_FOUND','MP')</script>");
		response.sendRedirect("../../eCommon/jsp/MstCodeError.jsp?err_value=error");
		}
	}
	else if(function.equals("second"))
	{
	stmt1=conn.createStatement();
	String nat_id_prompt="";
	String nat_id_check_program_name="";
	String nat_id_check_digit_id="";
	rs1 = stmt1.executeQuery("select A.NAT_ID_CHECK_DIGIT_ID, A.nat_id_prompt, B.PROGRAM_NAME from mp_param_lang_vw a, MP_CHECK_DIGIT_SCHEME b where A.NAT_ID_CHECK_DIGIT_ID = b.scheme_id and language_id ='"+locale+"' ");
	if(rs1 !=null && rs1.next())
		{
	 nat_id_check_digit_id = rs1.getString("NAT_ID_CHECK_DIGIT_ID");
	if(nat_id_check_digit_id == null) nat_id_check_digit_id="";
	 nat_id_check_program_name = rs1.getString("PROGRAM_NAME");
	if(nat_id_check_program_name == null) nat_id_check_program_name="";
	 nat_id_prompt = rs1.getString("nat_id_prompt");
	if (nat_id_prompt == null) nat_id_prompt="National ID No";
		}
	String national_id_no = request.getParameter("national_id_no");
	String from_val = request.getParameter("FROM_VAL");

	if (rs1 != null)   rs1.close();
	if (stmt1 != null) stmt1.close();
	stmt2=conn.createStatement();
	String result ="Y";
	if(!nat_id_check_digit_id.equals(""))
	{
		String sql2="select  "+nat_id_check_program_name +" ('"+national_id_no+"') from dual";
		rs2=stmt2.executeQuery(sql2);
		
		if(rs2 !=null && rs2.next())
		{
		result = rs2.getString(1);
		}
	}
	if (rs2 != null)   rs2.close();
	if (stmt2 != null) stmt2.close();
	if ( result.equals("Y") )
	{
			String duplicateSql = "select practitioner_id from am_practitioner where national_id_num = '"+national_id_no+"'";			
			stmt3 = conn.createStatement();
			rs3 = stmt3.executeQuery(duplicateSql);

		if ( rs3.next() )
			{

			if(from_val.equals("PRACTITIONER"))
				{
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></head><body class='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>var val1 = parent.f_query_add_mod.practitioner_sub.getMessage('DUP_NAT_ID','MP');val1 = val1.replace('#',parent.f_query_add_mod.practitioner_sub.document.practitioner1_form.nat_id_prompt.value);alert(val1); parent.f_query_add_mod.practitioner_sub.document.practitioner1_form.national_id_no.value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>");
				}else
				{
					out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>var val1 = parent.f_query_add_mod.OtherStaff_sub.getMessage('DUP_NAT_ID','MP');val1 = val1.replace('#',parent.f_query_add_mod.OtherStaff_sub.document.OtherStaff1_form.nat_id_prompt.value);alert(val1);parent.f_query_add_mod.OtherStaff_sub.document.OtherStaff1_form.national_id_no.value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>");
				}
			}
			else
			{
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body class='MESSAGE' onKeyDown = 'lockKey()'></body></html>");
			}
			if (rs3 != null)   rs3.close();
	        if (stmt3 != null) stmt3.close();

	}
	else
	{
		
			if(from_val.equals("PRACTITIONER"))
				{
				out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></head><body class='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>				var val1 = parent.f_query_add_mod.practitioner_sub.getMessage('INVALID_NAT_ID','MP');val1 = val1.replace('#',parent.f_query_add_mod.practitioner_sub.document.practitioner1_form.nat_id_prompt.value);alert(val1);parent.f_query_add_mod.practitioner_sub.document.practitioner1_form.national_id_no.value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>");
				}else
				{
				out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></head><body class='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>var val1 = parent.f_query_add_mod.OtherStaff_sub.getMessage('INVALID_NAT_ID','MP');val1 = val1.replace('#',parent.f_query_add_mod.OtherStaff_sub.document.OtherStaff1_form.nat_id_prompt.value);alert(val1);parent.f_query_add_mod.OtherStaff_sub.document.OtherStaff1_form.national_id_no.value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>");
				}
        
	}

	
	}

if(rs1 != null) rs1.close();
if(rs2 != null) rs2.close();
if(rs3 != null) rs3.close();
if(rs4!= null) rs4.close();
if(stmt2 != null) stmt2.close();
if(stmt1 != null) stmt1.close();
if(stmt3 != null) stmt3.close();
if(stmt4 != null) stmt4.close();

}

catch(Exception e)
{
	e.printStackTrace();
}
finally 
{
	ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
