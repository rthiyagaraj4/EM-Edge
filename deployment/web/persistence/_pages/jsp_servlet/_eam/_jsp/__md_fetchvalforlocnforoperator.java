package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __md_fetchvalforlocnforoperator extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/md_FetchValForLocnForOperator.jsp", 1711432640628L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tvar opt=parent.f_query_add_mod.f_query_add_mod_query.document.createElement(\"OPTION\");\n\t\t\t\t//var opt=parent.f_query_add_mod.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tvar comp=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\tcomp.add(opt);\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

StringBuffer sql=new StringBuffer(" ");
Connection con = null;

Statement stmt = null;
Statement st=null;
ResultSet rset=null;
ResultSet rset1=null;
String code="";
String desc="";
String comp=" ";
String oper_stn_type="";
String name=request.getParameter("name");
String value=request.getParameter("value");
String fid=request.getParameter("fid");
String loctype=request.getParameter("loctype");
String oid=request.getParameter("oprstn");
String sel=request.getParameter("selval");
String operating_facilityID = request.getParameter("operating_facilityID");
if(operating_facilityID == null) operating_facilityID="";

try
{
	con = ConnectionManager.getConnection(request);

	st=con.createStatement();

	if(name!=null)
	name=name.trim();

	if(fid!=null)
	fid=fid.trim();

	if(sel!=null)
	sel=sel.trim();

	sql.setLength(0);

	sql.append("select oper_stn_type from am_oper_stn where facility_id='"+fid+"' and oper_stn_id='"+oid+"'");

	rset1= st.executeQuery(sql.toString());
	if(rset1.next())
	oper_stn_type    = rset1.getString("oper_stn_type")==null ?"":rset1.getString("oper_stn_type");

	if(name.equals("oprstn"))
	{
		if (oper_stn_type.equals("O"))
		{	
			sql.setLength(0);
			sql.append("select locn_type,short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and care_locn_type_ind != 'N'  order by upper(short_desc)");
		}
		else if (oper_stn_type.equals("I"))
		{
			sql.setLength(0);
			sql.append("select locn_type,short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and care_locn_type_ind = 'N' order by upper(short_desc) ");
		}
		else if (oper_stn_type.equals("B"))
		{
			sql.setLength(0);
			sql.append("select locn_type,short_desc from am_care_locn_type where sys_user_def_ind = 'S' order by upper(short_desc) ");
		}
		comp="parent.f_query_add_mod.f_query_add_mod_query.document.forms[0].loctype";
	}
	if(rset1!=null)rset1.close();

	if(name.equals("loctype"))
	{
		sql.setLength(0);
		sql.append("select CARE_LOCN_TYPE_IND  from am_care_locn_type where LOCN_TYPE ='"+value+"'");
		rset1=st.executeQuery(sql.toString());
		rset1.next();
		String ind=rset1.getString("CARE_LOCN_TYPE_IND");
		if(ind.equalsIgnoreCase("C"))
		{	
			sql.setLength(0);
			sql.append("Select clinic_code,long_desc from op_clinic where facility_id = '"+fid+"' and clinic_type='"+loctype+"' and eff_status = 'E' order by upper(long_desc)");
		}
		else if (ind.equalsIgnoreCase("N"))
		{
			sql.setLength(0);
			sql.append("Select NURSING_UNIT_CODE,long_desc from  ip_nursing_unit where facility_id = '"+fid+"' and eff_status = 'E' and locn_type='"+loctype+"' order by upper(long_desc)");
		}
		comp="parent.f_query_add_mod.f_query_add_mod_query.document.forms[0].locid";
	}

	if(name.equals("fromFac"))
	{
		sql.setLength(0);
		sql.append("SELECT  oper_stn_id,short_desc  FROM  am_oper_stn WHERE  facility_id='"+operating_facilityID+"' " +
		" and EFF_STATUS='E'  ORDER BY short_desc");

		comp="parent.f_query_add_mod.f_query_add_mod_query.document.forms[0].oprstn";
	}

	if(rset!=null)rset.close();
	stmt = con.createStatement();
	rset = stmt.executeQuery(sql.toString());

	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script></HEAD><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
	if(rset != null)
	{
		while( rset.next() )
		{
			code =	rset.getString(1);
			desc =	rset.getString(2);
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
	}
}catch(Exception e){e.toString();}
finally
{
	try
	{
		if (rset != null)   rset.close();
		if (rset1 != null)   rset1.close();
		if (stmt != null) stmt.close();
		if (st != null) st.close();
	}catch(Exception e)
	{}
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
