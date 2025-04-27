package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __adddatabaserole extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/AddDatabaseRole.jsp", 1709121689698L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\'></link>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<HTML>\n<HEAD>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/OraRole.js\'></script>\n<TITLE>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TITLE>\n<SCRIPT LANGUAGE=\"JavaScript\">\n\tparent.frames[0].document.forms[0].reset.disabled=true;\n\n\nvar bol = 0;\nvar temp=\"\";\n\n\nfunction ValidPw(Obj1,Obj)\n{\tenable=Obj1.name\n\n\t if(enable==\"enab1\")\n\t{\n\t\t\tif(document.forms[0].enab1.checked)\n\t\t\t{\n\t\t\tdocument.forms[0].enab2.disabled=true\n\t\t\tdocument.forms[0].enab3.disabled=true\n\t\t\t}else\n\t\t\t{\n         \n\t\t\tdocument.forms[0].enab2.disabled=false\n\t\t\tdocument.forms[0].enab3.disabled=false\n\n\t\t\t}\n\t}\n\n if(enable==\"enab2\")\n\t{\n\t if(document.forms[0].enab2.checked)\n\t{\n\tdocument.forms[0].enab1.disabled=true\n\tdocument.forms[0].enab3.disabled=true\n\t}else\n\t{\n\t\t \n\t\tdocument.forms[0].enab1.disabled=false\n\t\tdocument.forms[0].enab3.disabled=false\n\t}\n\t}\n\t if(enable==\"enab3\")\n\t{\n\tif(document.forms[0].enab3.checked)\n\t{\n\tdocument.forms[0].enab1.disabled=true\n\tdocument.forms[0].enab2.disabled=true\n\t}else\n\t{ \n\t\tdocument.forms[0].enab1.disabled=false\n\t\tdocument.forms[0].enab2.disabled=false\n\t}\n\t}\n\t\n\t\n\tif((document.forms[0].enab1.checked)||(document.forms[0].enab2.checked)||(document.forms[0].enab3.checked))\n\t{\n        document.forms[0].ObjVal.value=Obj.value;\n\t    parent.frames[1].document.forms[0].action=\"../../eSM/jsp/change_role_passwd.jsp\";\n\t\tparent.frames[1].document.forms[0].target=\"result\";\n\t\tparent.frames[1].document.forms[0].submit();\n\t}\nelse\n\t{\n\n\tparent.frames[2].location.href =\"../../eCommon/html/blank.html\";\n\t}\n}\n\n\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</HEAD>\n\n<BODY OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n<FORM name=\'AddDatabaseRole_form\' id=\'AddDatabaseRole_form\' METHOD=POST ACTION=\"../../servlet/eSM.DatabaseRoleServlet\" target=\'messageFrame\'>\n\n\n<BR><BR><BR>\n\n<TABLE border = \'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\' ALIGN=\'CENTER\'>\n<TR><TD colspan=\'4\' width=\"25%\">&nbsp;<TD><td width=\"25%\"></td><td width=\"25%\"></td><td width=\"25%\"></td></TR>\n<TR><TD colspan=\'4\'>&nbsp;<TD><td width=\"25%\"></td><td width=\"25%\"></td><td width=\"25%\"></td></TR>\n<TR>\n\t<TD width=\'25%\' class=\'labelcenter\' > ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </TD>\n\t<TD width=\'25%\' class=\'labelcenter\' > ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </TD>\n\t<TD  class=\'labelcenter\' width=\'25%\'> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;&nbsp;</TD>\n\t<TD width=\'25%\'></TD>\n</TR>\t\n<TR >\n\n\t<TD width=\'25%\' class=\'labelcenter\'>\n\t\t<INPUT TYPE=\"text\" name=\"role1\" id=\"role1\" readonly size=\'3\' >\n\t\t<INPUT TYPE=\"hidden\" name=\"roleH1\" id=\"roleH1\"\'>\t\n\t</TD>\n\t<TD width=\'25%\' class=\'labelcenter\'>\n\t\t<INPUT TYPE=\"text\" name=\"id1\" id=\"id1\" readonly maxlength=\'20\'>\n\t\t<INPUT TYPE=\"hidden\" name=\"idH1\" id=\"idH1\"\'>\n\t</TD>\t\n \t<TD width=\'25%\' class=\'labelcenter\'><INPUT TYPE=\"checkbox\" name=\"enab1\" id=\"enab1\" onClick=\'ValidPw(this,document.forms[0].idH1)\'></TD>\n\t<TD width=\'25%\'></TD>\n\n</TR>\n<TR >\n\t<TD width=\'25%\' class=\'labelcenter\'>\n\t\t<INPUT TYPE=\"text\" name=\"role2\" id=\"role2\"  size=\'3\' readonly >\n\t\t<INPUT TYPE=\"hidden\" name=\"roleH2\" id=\"roleH2\"\'>\t\n\t</TD>\n\t<TD width=\'25%\' class=\'labelcenter\'>\n\t\t<INPUT TYPE=\"text\" name=\"id2\" id=\"id2\" readonly >\n\t\t<INPUT TYPE=\"hidden\" name=\"idH2\" id=\"idH2\"\'>\t\n\t</TD>\n \t<TD width=\'25%\' class=\'labelcenter\'><INPUT TYPE=\"checkbox\" name=\"enab2\" id=\"enab2\" onClick=\'ValidPw(this,document.forms[0].idH2)\'></TD>\n\t<TD width=\'25%\'>&nbsp;</TD>\n\n</TR>\n<TR >\n\t<TD width=\'25%\' class=\'labelcenter\'>\n\t\t<INPUT TYPE=\"text\" name=\"role3\" id=\"role3\" readonly size=\'3\'  >\n\t\t<INPUT TYPE=\"hidden\" name=\"roleH3\" id=\"roleH3\"\'>\t\n\t</TD>\n\t<TD width=\'25%\' class=\'labelcenter\'>\n\t\t<INPUT TYPE=\"text\" name=\"id3\" id=\"id3\" readonly >\n\t\t<INPUT TYPE=\"hidden\" name=\"idH3\" id=\"idH3\"\'>\t\n\t</TD>\n \t<TD width=\'25%\' class=\'labelcenter\'>\n\t\t<INPUT TYPE=\"checkbox\" name=\"enab3\" id=\"enab3\" onClick=\'ValidPw(this,document.forms[0].idH3)\'>\n\t</TD>\n\t<TD width=\'25%\'></TD>\n</TR>\n<TR><TD colspan=\'4\' width=\"25%\">&nbsp;<TD><TD width=\'25%\'></TD><TD width=\'25%\'></TD><TD width=\'25%\'></TD></TR>\n\t </table>\n\t <table border=0 cellspacing=0 cellpadding=0 border=0 align=center width=\'80%\'>\n<TR >\n\t<TD >\n\t\t\n\t</TD>\t\n</TR>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<SCRIPT>\n\t\t\tdocument.forms[0].role";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =".value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\tdocument.forms[0].roleH";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\tdocument.forms[0].id";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\tdocument.forms[0].idH";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\n\t</SCRIPT>\t\n\n\t\t\t\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<TR><TD >&nbsp;<TD></TR>\n\t<INPUT TYPE=\"hidden\" name=\'ObjVal\' id=\'ObjVal\'>\n</TABLE>\n\t\t<input type=\'hidden\' name=\"CompVal\" id=\"CompVal\" value=\"C\">\n</FORM>\n</BODY>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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

       String sStyle	=
      (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

    request.setCharacterEncoding("UTF-8");
	Connection con=null;
	PreparedStatement pstmt = null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null;
	String ora_type = "";
	String ora_id	= "";
	StringBuffer totVal	= new StringBuffer();	
	String totVal1	= "";
	String ora_type1 = "";
	String ora_id1	= "";
	int i = 1;

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	try{
		String Sql1= "SELECT ora_role_type,ora_role_id,app_password.decrypt(ora_role_password), ora_privilege from sm_ora_role order by ora_role_type";

		pstmt = con.prepareStatement( Sql1 );
		rs    = pstmt.executeQuery();

		if(rs!=null)
		{
			while(rs.next())
			{	
				ora_type = rs.getString(1);			
				ora_id	 = rs.getString(2);
			
				totVal.append(ora_type+"@"+ora_id+"#");				
                



            _bw.write(_wl_block4Bytes, _wl_block4);
	
			}
		StringTokenizer token = new StringTokenizer(totVal.toString(), "#");

	    while (token.hasMoreTokens())
		 {
			totVal1 = token.nextToken();
			StringTokenizer token1 = new StringTokenizer(totVal1, "@");
				while(token1.hasMoreTokens())
				{					
					ora_type1 = token1.nextToken();
					ora_id1	  = token1.nextToken();
                    

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ora_type1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ora_type1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ora_id1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ora_id1));
            _bw.write(_wl_block18Bytes, _wl_block18);
			
					i++;
				 }
		 }
		}
		if(rs!=null)rs.close();
	}catch(Exception e ){out.println("Errors Encountered " + e);}

            _bw.write(_wl_block19Bytes, _wl_block19);
if(pstmt != null) pstmt.close();
}catch(Exception e){out.println(e);}
finally {
				
	ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.DatabaseRoles.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.RoleName.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.changepassword.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
