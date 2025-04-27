package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __qapopulateindicatordesc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAPopulateIndicatorDesc.jsp", 1742817545887L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t\t<script>\n\t\t\tvar objFrom=parent.f_query_add_mod.document.forms[0].P_FROM;\n\t\t\tvar objTo=parent.f_query_add_mod.document.forms[0].P_TO;\n\t\t\tvar arr = new Array();\n\t\t\tparent.f_query_add_mod.document.forms[0].P_FROM.disabled=false\n\t\t\tparent.f_query_add_mod.document.forms[0].P_TO.disabled=false\n\t\t\tparent.f_query_add_mod.document.getElementById(\'hide\').style.visibility=\'visible\'\t\n\t\t\tarr = new Array(\"1-JAN\",\"2-FEB\",\"3-MAR\",\"4-APR\",\"5-MAY\",\"6-JUN\",\"7-JUL\", \"8-AUG\",\"9-SEP\",\"10-OCT\",\"11-NOV\",\"12-DEC\");\n\t\t\tparent.f_query_add_mod.removeAll(objFrom);\n\t\t\tparent.f_query_add_mod.removeAll(objTo);\n\t\t\tparent.f_query_add_mod.addAll(objFrom,arr);\n\t\t\tparent.f_query_add_mod.addAll(objTo,arr);\n\t\t</script>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<script>\n\t\t\tvar objFrom=parent.f_query_add_mod.document.forms[0].P_FROM;\n\t\t\tvar objTo=parent.f_query_add_mod.document.forms[0].P_TO;\n\t\t\tvar arr = new Array();\n\t\t\tparent.f_query_add_mod.document.forms[0].P_FROM.disabled=false\n\t\t\tparent.f_query_add_mod.document.forms[0].P_TO.disabled=false\n\t\t\t\n\t\t\tarr = new Array(\"Q1-Quarter 1\",\"Q2-Quarter 2\",\"Q3-Quarter 3\",\"Q4-Quarter 4\");\n\t\t\tparent.f_query_add_mod.document.getElementById(\'hide\').style.visibility=\'visible\'\t\n\t\t\tparent.f_query_add_mod.removeAll(objFrom);\n\t\t\tparent.f_query_add_mod.removeAll(objTo);\n\t\t\tparent.f_query_add_mod.addAll(objFrom,arr);\n\t\t\tparent.f_query_add_mod.addAll(objTo,arr);\n\t\t</script>\n\n\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\n\t\t<script>\n\t\t\tvar objFrom=parent.f_query_add_mod.document.forms[0].P_FROM;\n\t\t\tvar objTo=parent.f_query_add_mod.document.forms[0].P_TO;\n\t\t\tvar arr = new Array();\n\t\t\tarr = new Array(\"F-First Half\",\"S-Second Half\");\n\t\t\tparent.f_query_add_mod.document.forms[0].P_FROM.disabled=false\n\t\t\tparent.f_query_add_mod.document.forms[0].P_TO.disabled=false\n\t\t\tparent.f_query_add_mod.document.getElementById(\'hide\').style.visibility=\'visible\'\t\n\t\t\tparent.f_query_add_mod.removeAll(objFrom);\n\t\t\tparent.f_query_add_mod.removeAll(objTo);\n\t\t\tparent.f_query_add_mod.addAll(objFrom,arr);\n\t\t\tparent.f_query_add_mod.addAll(objTo,arr);\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<script>\n\t\t\tvar objFrom=parent.f_query_add_mod.document.forms[0].P_FROM;\n\t\t\tvar objTo=parent.f_query_add_mod.document.forms[0].P_TO;\n\t\t\tvar arr = new Array();\n\t\t\tparent.f_query_add_mod.removeAll(objFrom);\n\t\t\tparent.f_query_add_mod.removeAll(objTo);\n\t\t\tparent.f_query_add_mod.document.getElementById(\'hide\').style.visibility=\'hidden\'\n\t\t\tparent.f_query_add_mod.document.forms[0].P_FROM.disabled=true\n\t\t\tparent.f_query_add_mod.document.forms[0].P_TO.disabled=true\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script>parent.f_query_add_mod.document.getElementById(\'indicator\').innerHTML=\"<b>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</b>\"\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script>parent.f_query_add_mod.document.getElementById(\'diag\').innerHTML=\"Code\"\n\tparent.f_query_add_mod.document.getElementById(\'mandatorydiag\').style.visibility=\'hidden\'\n\tparent.f_query_add_mod.document.getElementById(\'Schemetype\').style.visibility=\'hidden\'\n</script>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n\tparent.f_query_add_mod.document.getElementById(\'mandatorydiag\').style.visibility=\'hidden\'\n\tparent.f_query_add_mod.document.getElementById(\'Schemetype\').style.visibility=\'hidden\'\n\t\n</script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n";
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


	PreparedStatement pstmt = null;
	ResultSet         rs    = null;
    Connection        conn  = null; 
	conn  = ConnectionManager.getConnection(request);
try
{
	String repyn = request.getParameter("reportyn")==null?"":request.getParameter("reportyn");

	if(repyn.equals("Y"))
	{
	String dflt_rep_periodicity="";
	String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	String indicator_id = request.getParameter("indicator_id")==null?"":request.getParameter("indicator_id");
	//conn  = ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement("select DFLT_REP_PERIODICITY FROM QA_QIND_FACILITY_CLIND WHERE OPERATING_FACILITY_ID =? and QIND_CLIND_ID =?");
	pstmt.setString(1,facilityId);
	pstmt.setString(2,indicator_id);
	rs = pstmt.executeQuery();
	
		
	if(rs!=null)
		{
			while(rs.next())
			{
				dflt_rep_periodicity = rs.getString(1);
			}
		}
		if(dflt_rep_periodicity.equals("M"))
		{
		out.println("<script>parent.f_query_add_mod.document.getElementById('P_PERIODICITY').options[1].selected=true</script>"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
	}else if(dflt_rep_periodicity.equals("Q")){ 
		out.println("<script>parent.f_query_add_mod.document.getElementById('P_PERIODICITY').options[2].selected=true</script>"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
	}else if(dflt_rep_periodicity.equals("B"))
		{
		out.println("<script>parent.f_query_add_mod.document.getElementById('P_PERIODICITY').options[3].selected=true</script>"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
}else if(dflt_rep_periodicity.equals("A"))
		{
		out.println("<script>parent.f_query_add_mod.document.getElementById('P_PERIODICITY').options[4].selected=true</script>"); 
            _bw.write(_wl_block4Bytes, _wl_block4);
}




		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
	}else
	{
	String popclind = request.getParameter("popclind")==null?"":request.getParameter("popclind");
	String indicator_id = request.getParameter("indicator_id")==null?"":request.getParameter("indicator_id");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
    String indicator_desc = "";
    String indi_class = "";
	//conn  = ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement("select QIND_CLIND_DESC,CLIND_CLASS from qa_qind_clind where QIND_CLIND_ID = ?");
	pstmt.setString(1,indicator_id);
	rs = pstmt.executeQuery();
	if(rs!=null)
		{
			while(rs.next())
			{
				indicator_desc = rs.getString(1);
			    indi_class     = rs.getString(2);
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if((indicator_desc==null) || (indicator_desc.equals("null")))
			indicator_desc="";

if(popclind.equals("popclind") &&(!mode.equals("U")))
{
		out.println("<script>var obj=parent.f_query_add_mod.document.getElementById('diag_proc_ind');</script>");
        out.println("<script> var length = obj.length;for(i=0;i<length;i++) obj.remove(1);</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('mandatorydiag').style.visibility='visible'</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('Schemetype').style.visibility ='visible'</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('CLIND_CLASS').value ='"+indi_class+"'</script>");

if(indi_class.equals("D"))
	{
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Diagnosis';</script>");
        out.println("<script>opt.value='D';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
	
	out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').options[1].selected=true</script>");
	}
	
	if(indi_class.equals("P"))
	{
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Procedure';</script>");
        out.println("<script>opt.value='P';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
	
	out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').options[1].selected=true</script>");
	}
	if(indi_class.equals("O"))
	{
		
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Orderable';</script>");
        out.println("<script>opt.value='O';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
	
	out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').options[1].selected=true</script>");
	}


if(indi_class.equals("Z"))
	{
		
		

		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Diagnosis';</script>");
        out.println("<script>opt.value='D';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='Procedure';</script>");
        out.println("<script>opt.value='P';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').add(opt)</script>");
	
	out.println("<script>parent.f_query_add_mod.document.getElementById('diag_proc_ind').options[1].selected=true</script>");
	}
}
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(indicator_desc));
            _bw.write(_wl_block6Bytes, _wl_block6);
if(indi_class.equals("M"))
	{
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);
if(indi_class.equals("S") || indi_class.equals("A") || indi_class.equals("N"))
	{
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
}catch(Exception e)
{
	out.println("Exception in File QAPopulateIndicatorDesc"+e.toString());
}
finally
{
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
