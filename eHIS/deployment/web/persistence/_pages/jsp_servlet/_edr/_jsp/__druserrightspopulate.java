package jsp_servlet._edr._jsp;

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

public final class __druserrightspopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/DRUserRightspopulate.jsp", 1719913860884L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n      <html><HEAD>\n\t\t  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link></HEAD><body CLASS=\'MESSAGE\' onKeyDown=\'lockKey();\'><form name=\'userform\' id=\'userform\'>\n\n\t\t <!-- out.println(\"<html><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link></HEAD><body CLASS=\'MESSAGE\'><form name=\'userform\' id=\'userform\'>\");*/ -->\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1]. document.getElementById(\'EMPNO\').value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'EMPNO\')EMPNO.disabled=true;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'userID\').value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_user_name\').value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'userID\').value\t\t\t= \'\';\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'p_user_name\').value\t= \'\';\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<script>\n\t\t\t\tvar gm  = getMessage(\"INVALID_VALUE\",\"Common\");\n\t\t\t\tgm = gm.replace(\"#\",getLabel(\"Common.EmployeeNo.label\",\"Common\"));\n\t\t\t\talert(gm);\t\n\t\t\t\tparent.frames[1].document.getElementById(\'userID\').value\t\t\t= \'\';\n\t\t\t\tparent.frames[1].document.getElementById(\'p_user_name\').value\t= \'\';\n\t\t\t\tparent.frames[1].document.getElementById(\'EMPNO\').value\t\t\t= \'\';\t\n\t\t\t\tparent.frames[1].document.getElementById(\'EMPNO\').focus();\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con				= null;
	java.sql.Statement stmt		= null;
	java.sql.Statement stmt2	= null;
	java.sql.Statement stmt1	= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	ResultSet rs2				= null;

	String user_id	= "";
	String username	= "";
	String step		= "";
	String EmpNo	= "";

	int k	= 0;

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		stmt1	= con.createStatement();
		stmt2	= con.createStatement();

		user_id		= request.getParameter("user_id");
		username	= request.getParameter("p_user_name");
		step		= request.getParameter("step");
		EmpNo		= request.getParameter("EmpNo");

		if(EmpNo == null) EmpNo = "";
		if(user_id == null) user_id = "";
		if(username == null) username = "";
		if(step == null) step = "";
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(step.equals("1"))
		{
			String sql = "select EMPLOYEE_NO from sm_appl_user where APPL_USER_ID='"+user_id+"'";
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
				while(rs.next())
				{
					EmpNo	= rs.getString("EMPLOYEE_NO");
					if(EmpNo == null) EmpNo = "";
					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(EmpNo));
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
			}
		}
		if(step.equals("2") && !EmpNo.equals(""))
		{
			int i = 0;

			String sql1 = "SELECT count(*) aa FROM sm_appl_user WHERE employee_no = '"+EmpNo+"'";
			rs2 = stmt2.executeQuery(sql1); 
			if(rs2 != null)
			{
				while(rs2.next())
				{
					 k	= rs2.getInt("aa");
				}
			}
			if(k > 0)
			{
				String sql = "SELECT appl_user_id,appl_user_name FROM sm_appl_user WHERE employee_no = '"+EmpNo+"'";
				rs1 = stmt1.executeQuery(sql); 

				if(rs1 != null)
				{
					while(rs1.next())
					{
						user_id		= rs1.getString("appl_user_id");
						username	= rs1.getString("appl_user_name");
						i++;
					}
				}
				if( i <= 1)
				{
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(username));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
				else
				{
					
            _bw.write(_wl_block15Bytes, _wl_block15);

				}
			}
			else
			{
				
            _bw.write(_wl_block16Bytes, _wl_block16);

		}		
	}

	if(rs !=null) rs.close();
	if(rs1 !=null) rs1.close();
	if(rs2 !=null) rs2.close();
	if(stmt !=null) stmt.close();
	if(stmt1 !=null) stmt1.close();
	if(stmt2 !=null) stmt2.close();
}
catch(Exception e)
{
	out.println("Exception e :"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
