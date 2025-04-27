package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __fetchvalforlocnforoperator extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/FetchValForLocnForOperator.jsp", 1709114002898L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t<script>\n\t\t\tvar temp = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\t//parent.document.frames[1].document.forms[0].clinic.add(opt);\n\t\t\tvar comp=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\tcomp.add(opt);\n\t\t\n\t\t\t//parent.document.frames[1].document.getElementById(\"opr_type\").innerText=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\n\t\t\t//parent.document.frames[1].document.getElementById(\"opr_type\").style.visibility=\'visible\';\n\n\n\t</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n";
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

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
	String sql=" ";
		Connection con = null;

		Statement stmt = null;
		Statement st=null;
		ResultSet rset=null;
		ResultSet rset1=null;
		String code="";
		String desc="";
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		String fid=request.getParameter("fid").trim();
		String loctype=request.getParameter("loctype");
		String oid=request.getParameter("oprstn");
		String comp=" ";
		//String comp1=" ";
	//	String sql1=null;
		//String func=request.getParameter("function");
		String sel=request.getParameter("selval");
		String oper_stn_type="";

	try
	{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	st=con.createStatement();
	
		if(name!=null)
			name=name.trim();

		if(fid!=null)
			fid=fid.trim();

		if(sel!=null)
			sel=sel.trim();

	
		sql="select oper_stn_type from am_oper_stn where facility_id='"+fid+"' and oper_stn_id='"+oid+"'";

		rset1= st.executeQuery(sql);
		if(rset1.next())
			oper_stn_type    = rset1.getString("oper_stn_type")==null ?"":rset1.getString("oper_stn_type");

		if(name.equals("oprstn"))
		{
			if (oper_stn_type.equals("O"))
			{
				sql="select locn_type,short_desc from am_care_locn_type where CARE_LOCN_TYPE_IND = 'C' ";
			}
			else if (oper_stn_type.equals("I"))
			{
				sql="select locn_type,short_desc from am_care_locn_type where CARE_LOCN_TYPE_IND = 'N' ";
			}
			else if (oper_stn_type.equals("B"))
			{
				sql="select locn_type,short_desc from am_care_locn_type where CARE_LOCN_TYPE_IND in('C','N') ";
			}
			comp="parent.document.frames[1].document.forms[0].loctype";
		}
		if(name.equals("loctype"))
		{
			sql="select CARE_LOCN_TYPE_IND  from am_care_locn_type where LOCN_TYPE ='"+value+"'";
			 rset1=st.executeQuery(sql);
			 rset1.next();
			String ind=rset1.getString("CARE_LOCN_TYPE_IND");
/*
			if(res.equals("N") && ind.equals("R"))
				sql=" Select room_num,short_desc from am_facility_room where operating_facility_id = '"+fid+"' and RESIDENT_STAY_YN = 'N'  and ROOM_TYPE='"+loctype+"' order by short_desc";

			else 
*/			 
			if(ind.equalsIgnoreCase("C"))
				sql="Select clinic_code,long_desc from op_clinic where facility_id = '"+fid+"' and clinic_type='"+loctype+"' and eff_status = 'E' order by long_desc";
			
			else if (ind.equalsIgnoreCase("N"))
				sql="Select NURSING_UNIT_CODE,long_desc from  ip_nursing_unit where facility_id = '"+fid+"' and eff_status = 'E' and locn_type='"+loctype+"' order by long_desc";
/*			
			else if (ind.equalsIgnoreCase("S"))
				sql="Select store_code,short_desc from  st_store  where facility_id = '"+fid+"' and eff_status = 'E'  order by short_desc";
*/
			comp="parent.document.frames[1].document.forms[0].locid";
		}
		  if (rset1 != null) rset1.close();
          if (st != null) st.close();

			if(sql!=null || sql.equals(""))
				rset = stmt.executeQuery(sql);

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
		if(rset != null)
		{
		while( rset.next() )
		{
			code=rset.getString(1);
			desc=rset.getString(2);

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(code));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(oper_stn_type));
            _bw.write(_wl_block6Bytes, _wl_block6);

		}
		}
		if (rset != null) rset.close();
        if (stmt != null) stmt.close();
	}
	catch(Exception e){e.toString();}

finally {
  if (rset != null)   rset.close();
  if (rset1 != null)   rset1.close();
  if (stmt != null) stmt.close();
  if (st != null) st.close();
  ConnectionManager.returnConnection(con,request);
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
