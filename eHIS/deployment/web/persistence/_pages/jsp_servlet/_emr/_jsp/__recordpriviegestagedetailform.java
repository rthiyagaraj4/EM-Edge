package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __recordpriviegestagedetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordPriviegeStageDetailForm.jsp", 1709119035411L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nCreateted by:Anjaneya Reddy M\nDate        :12/19/2008\nModule      :eMR\nFunction    :Record PrivlegeStage Datils Form\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../../eMR/js/RecodePrivilegeSetup.js\'></script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n\n\t\n\n</HEAD>\n\t\n<BODY onKeyDown = \'lockKey()\' OnMouseDown=\'CodeArrest()\'>\t\n<FORM name=\"RecordPriviegeStageDetailForm\" id=\"RecordPriviegeStageDetailForm\" >\n\n<TABLE BORDER=0 WIDTH=\'100%\' CELLSPACING=1 CELLPADDING=1 ALIGN=\'CENTER\'  >\n<TR>\n\t<TH WIDTH=\'5%\' CLASS=\'DATA\'>&nbsp;&nbsp; <b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</B></TH>\n\t<TH WIDTH=\'5%\'  CLASS=\'DATA\'><B>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</B></TH>\n</TR>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<TR>\n\t\t<TD WIDTH=\'5%\' CLASS=\'DATA\'><A><a href=\'javascript:viewUserDetails(encodeURIComponent(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"),encodeURIComponent(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"))\'><FONT SIZE=1>  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</FONT></A></A></TD>\n\t\t<TD WIDTH=\'5%\' CLASS=\'DATA\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TD>\n\t\t<TD WIDTH=\'5%\'  CLASS=\'DATA\' >&nbsp;&nbsp;<input type=checkbox name=\'deleteUser";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'deleteUser";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' disabled ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" value=\'\'></TD>\n\t\t\t\t\n    </TR>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</TABLE>\n\n<INPUT TYPE=\'hidden\' name=\'locale\' id=\'locale\' VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<INPUT TYPE=\'hidden\' name=\'p_string_val\' id=\'p_string_val\' VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\'hidden\' name=\'unChkAllAuth\' id=\'unChkAllAuth\' VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<INPUT TYPE=\'hidden\' name=\'unChk_String_Val\' id=\'unChk_String_Val\' VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<INPUT TYPE=\'hidden\' name=\'update_string_val\' id=\'update_string_val\' VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<INPUT TYPE=\'hidden\' name=\'_spec_user_id\' id=\'_spec_user_id\' VALUE=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\n\n</FORM>\n</BODY>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

			
			
			String p_string_val	= checkForNull(request.getParameter("p_string_val"));
			String p_string_newval	= checkForNull(request.getParameter("p_string_newval"));
			String update_column	= checkForNull(request.getParameter("remove_column"));
			//String authorise	= checkForNull(request.getParameter("authorise"));

			//Thursday, March 26, 2009 Logic for the uncheck the authorise ,all users should uncheck
			String unChkAllAuth	= checkForNull(request.getParameter("unChkAllAuth"));
			String unChk_String_Val="";

			String update_string_val="";


			if(update_column.equals("remove_column")){
				
				       String user_id="";
				       String user_name="";
				       String auth_user="";
						StringTokenizer splitedtoken = null;
						String tokenvalue = "";
						tokenvalue="";
						int j = 0;
					   StringTokenizer token1=new StringTokenizer(p_string_val,"~");
					   update_string_val=update_string_val;
						while(token1.hasMoreTokens()){
								j++ ;
								tokenvalue      = token1.nextToken();
								splitedtoken=new StringTokenizer(tokenvalue,"`");
							while (splitedtoken.hasMoreTokens()){
								user_id		=	splitedtoken.nextToken();
								user_name			=	splitedtoken.nextToken();
								auth_user			=	splitedtoken.nextToken();
								if(!p_string_newval.equals(user_id))
                                  update_string_val=update_string_val+user_id+"`"+user_name+"`"+auth_user+"~";
							}
						}
			}
			
	
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

 String      user_id		=	"";
String		user_name			=	"";
String		auth_user		=	"";
int i=0;
String auth_chk="";
/*
 number of user ids coming frommthe db
*/
String _update_mode_yn	= checkForNull(request.getParameter("_update_mode_yn"));
String _spec_user_id	= checkForNull(request.getParameter("all_user"));
if(_update_mode_yn.equals("update_db"))
p_string_val=_spec_user_id;

if(update_column.equals("remove_column"))
p_string_val=update_string_val;



		if(unChkAllAuth.equals("unChk")){
		StringTokenizer splitedtoken = null;
			String tokenvalue = "";
			tokenvalue="";
			i = 0;
		   StringTokenizer token1=new StringTokenizer(p_string_val,"~");
			while(token1.hasMoreTokens()){
					i++ ;
					tokenvalue      = token1.nextToken();
					splitedtoken=new StringTokenizer(tokenvalue,"`");
				while (splitedtoken.hasMoreTokens()){
					user_id		=	splitedtoken.nextToken();
					user_name			=	splitedtoken.nextToken();
					auth_user			=	splitedtoken.nextToken();

					//Thursday, March 26, 2009 Logic for the uncheck the authorise ,all users should uncheck
							if(unChkAllAuth.equals("unChk")){
								auth_chk="";
								auth_user="N";
								unChk_String_Val +=user_id+"`"+user_name+"`"+auth_user+"~";
								
								
							}
							else{
								//Thursday, March 26, 2009 this common before code for unchk
										if(auth_user.equals("Y")){
										auth_chk="checked";
									}
									else
										auth_chk="";
							}
					
					}
			}
			p_string_val=unChk_String_Val;

}




	if (!p_string_val.equals("")){
		   StringTokenizer splitedtoken = null;
			String tokenvalue = "";
			tokenvalue="";
			i = 0;
		   StringTokenizer token1=new StringTokenizer(p_string_val,"~");
			while(token1.hasMoreTokens()){
					i++ ;
					tokenvalue      = token1.nextToken();
					splitedtoken=new StringTokenizer(tokenvalue,"`");
				while (splitedtoken.hasMoreTokens()){
					user_id		=	splitedtoken.nextToken();
					user_name			=	splitedtoken.nextToken();
					user_name = user_name.replaceAll("%27", "\'");
					auth_user			=	splitedtoken.nextToken();

					//Thursday, March 26, 2009 Logic for the uncheck the authorise ,all users should uncheck
					if(unChkAllAuth.equals("unChk")){
						auth_chk="";
						auth_user="N";
						unChk_String_Val +=user_id+"`"+user_name+"`"+auth_user+"~";
						
						
					}
					else{
						//Thursday, March 26, 2009 this common before code for unchk
						if(auth_user.equals("Y")){
						auth_chk="checked";
					}
					else
						auth_chk="";
					}
					
				

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(user_name.replaceAll("\'", "%27")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(auth_user));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_string_val.replaceAll("\'", "%27")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(auth_chk));
            _bw.write(_wl_block17Bytes, _wl_block17);
 
				}
			}
		}
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_string_val));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(unChkAllAuth));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(unChk_String_Val));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(update_string_val));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(_spec_user_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.userid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.username.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
