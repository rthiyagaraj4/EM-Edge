package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __getcomments extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/GetComments.jsp", 1723809302140L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t <script>\n\t\t\t\t\t\t temp = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t\t temp1=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar opt= parent.frames[1].frames[0].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].term_set_id.add(opt);\n\t\t\t\t\t\t\t\t\t \t\n\t\t\t\t </script>\n              ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\tvar opt= parent.frames[1].frames[0].document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].term_set_id.add(opt);\n\n\t\t\t \t\n\t\t\t\t </script>\n              ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<head>\n\n<title>\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</title>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n<script>\n\tfunction closeWindow()\n\t{\n\t\t//parent.window.returnValue=document.getElementById(\"remarks\").value;\n\t\t//parent.window.close();\n\t\tlet dialogBody = parent.document.getElementById(\'dialog-body\');\n\t    dialogBody.contentWindow.returnValue = document.getElementById(\"remarks\").value;\n\t    \n\t    const dialogTag = parent.document.getElementById(\'dialog_tag\');    \n\t    dialogTag.close(); \n\t}\n\tfunction populateRemarks()\n\t{\n\t\tvar text=window.dialogArguments;\n\t\tif(text == null || text ==\'null\') text=\'\';\n\t\tdocument.getElementById(\"remarks\").value=unescape(text);\n\t}\n\tfunction chkMaxLength(Obj)\n\t{\n\t\tif(Obj.value.length >200)\n\t\t\t{\n\t\t\talert(getMessage(\'REMARKS_NOT_EXCEED_200_CH\',\'SM\'));\n\t\t\tObj.focus();\n\t\t\t}\n\t}\n</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<body onLoad=\'populateRemarks()\' onUnload=\'closeWindow()\' onKeyDown = \'lockKey()\';>\n\t<form>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'90%\'\n\t<tr><td>&nbsp;</td></tr>\n\t<tr>\n\t\t<td>\n\t\t\t<textarea  name=\'remarks\' id=\'remarks\' cols=\'50\'  readOnly  rows=\'4\'></textarea>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td align=\'right\' class=\'button\'>\n\t\t\t<input type=\'button\' class=\'button\' value=\'  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="  \' onClick=\'closeWindow()\' >\n\t\t</td>\n\t</tr>\n\t</table>\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	
/// Added by SRIDHAR R on 16 OCT 2004
/// To fetch Tabulation List No for the Tabulation List Type selected ...
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	ResultSet rs			= null;
	PreparedStatement stmt			= null;
String age_spec="";
try
{
	con = ConnectionManager.getConnection(request);

	String TabListNo	= request.getParameter("TabListNo");
	if(TabListNo == null) TabListNo = "";

	String criteria	=	request.getParameter("criteria");
	if(criteria == null) criteria = "";

	//String tab_list_type		= "";
	//String tab_list_type_desc	= "";
	String dia_code_schme		= "";
	String dia_code_schme_desc	= "";

	age_spec=request.getParameter("age_spec");
    if(age_spec == null) age_spec = "";
	
	if(age_spec.equals("D"))
    {
		String term_id="";
		String term_set_desc="";

		try{

		//String sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE DIAG_SPEC_YN = 'Y' ";
		String sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE EFF_STATUS = 'E' AND DIAG_SPEC_YN = 'Y' ORDER BY TERM_SET_DESC";
        stmt= con.prepareStatement(sql);
        rs	= stmt.executeQuery();
		if(rs!=null){
			 while(rs.next()){
				 term_id=rs.getString("TERM_SET_ID");
				 term_set_desc=rs.getString("TERM_SET_DESC");
				 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(term_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);

			 }
		    }
				 if(rs!=null)	rs.close();
	             if(stmt!=null)	stmt.close();
             out.println("<script>parent.frames[1].frames[0].document.forms[0].call_result.value='1';</script>");
             out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
		}catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace();}
		finally
	   {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	   }
		
	}

	if(age_spec.equals("P"))
    {
		String term_id="";
		String term_set_desc="";

		try{

		//String sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE PROC_SPEC_YN = 'Y' ";
         String sql="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE EFF_STATUS = 'E' AND PROC_SPEC_YN = 'Y' ORDER BY TERM_SET_DESC";
        stmt= con.prepareStatement(sql);
        rs	= stmt.executeQuery();
		if(rs!=null){
			 while(rs.next()){
				 term_id=rs.getString("TERM_SET_ID");
				 term_set_desc=rs.getString("TERM_SET_DESC");
				 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(term_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);

			 }
		    }
				 if(rs!=null)	rs.close();
	             if(stmt!=null)	stmt.close();
				
	         out.println("<script>parent.frames[1].frames[0].document.forms[0].call_result.value='1';</script>");
             out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
		}catch(Exception e) { /* out.println(e.toString()); */e.printStackTrace();}
		finally
	   {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	   }
		
	}

	if(criteria.equals("populateTabType"))
	{
		String Sql = " select DIAG_CODE_SCHEME from MR_TAB_LIST where eff_status='E' and TAB_LIST_NO = ?"; 

		stmt= con.prepareStatement(Sql);
		stmt.setString(1,TabListNo);
		rs	= stmt.executeQuery();
		if(rs != null && rs.next())
		{
			dia_code_schme	= rs.getString("DIAG_CODE_SCHEME");
			if(dia_code_schme == null) dia_code_schme = "";
			if(dia_code_schme.equals("1")) dia_code_schme_desc="ICD10";
			else dia_code_schme_desc="ICD9-CM";
		}

		out.println("<script>parent.frames[0].document.forms[0].all.diag_code_disp.innerText='"+dia_code_schme_desc+"';parent.frames[0].document.forms[0].diag_code_scheme.value='"+dia_code_schme+"';parent.frames[0].document.forms[0].all.call_result.value='1';</script>");
	}

	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
}
catch(Exception e)
{
	//out.println("Exception @ try "+e.toString());
	e.printStackTrace();
}
finally 
{ 
	ConnectionManager.returnConnection(con,request);		
}
/// End of addition...by Sridhar R

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);
if(age_spec.equals("")){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
