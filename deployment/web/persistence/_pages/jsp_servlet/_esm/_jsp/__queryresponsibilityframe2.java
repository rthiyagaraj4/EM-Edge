package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __queryresponsibilityframe2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/QueryResponsibilityFrame2.jsp", 1712655770881L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t\t<script>\n\t\tfunction populate_menu()\n\t\t{\n\t\t\t\n\t\t\tn=parent.frames[1].document.forms[0].Menu.options.length;\n\t\t\t\n\t\t\t\n\t\t\tfor(i=0;i<n;i++)\n\t\t\t\tparent.frames[1].document.forms[0].Menu.remove(\"Menu\");\n\n\t\t\tHTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link> </HEAD><BODY CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'GetQueryValues.jsp?Chksrc=seven\'><input name=\'Common_Text\' id=\'Common_Text\' type=\'hidden\' value=\'\"+document.getElementById(\"menu_id\").value+ \"\'><input name=\'User\' id=\'User\' type=\'hidden\' value=\'\"+document.getElementById(\"User\").value+\"\'></form></BODY></HTML>\";\n\t\t\tparent.parent.messageFrame.document.write(HTMLVal);\n\t\t\tparent.parent.messageFrame.document.form1.submit();\n\n\t\t}\n\t\tasync function displayaccess()\n\t\t{\n\t\t var menu_val=parent.frames[1].document.forms[0].Menu.options.value;\n\t\t var resp_val=parent.frames[1].document.forms[0].Menu.options.value;\n\t\t var resp_val=parent.frames[0].document.forms[0].resp_id.options.value;\n\t\t var menu_arr = new Array();\n\t\t menu_arr = menu_val.split(\'#\');\n         var menu_id = menu_arr[0];\n         var function_id = menu_arr[2];\n         var func_type = menu_arr[4];\n         var access = menu_arr[5];\n         var function_name = menu_arr[6];\n\t\t var dialogHeight= \"11\" ;\n\t\t var dialogWidth = \"27\" ;                    \n\t\t var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no;scroll=no\" ;\n         var arguments   = \"\" ;\n\t\t if (func_type==\"F\")\n\t\t\t  var retVal = await window.showModalDialog(\"../../eSM/jsp/QueryUsersAccess.jsp?function_name=\"+escape(function_name)+\"&access=\"+access+\"&resp_id=\"+resp_val+\"&menu_id=\"+menu_id+\"&function_id=\"+function_id,arguments,features);\n\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</head>\n\t\t<body OnMouseDown=\'CodeArrest()\' class=\'CONTENT\' onKeyDown = \'lockKey()\'; >\n\t\t<form name=\'frame2_form\' id=\'frame2_form\'>\n\t\t<table border=0 cellspacing=0 cellpadding=0 align=center width=\'102%\'>\n\t\t<tr>\n\t\t<th align=left width=\'35%\'>&nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t</th>\n\t\t<th align=left width=\'65%\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t\t<tr>\n\t\t\t\t<td width=\"35%\" class=\'fields\'>&nbsp;<Select name=\"User\" id=\"User\" size=\"5\" style=\"HEIGHT: 160px; WIDTH: 267px\">\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\n\t\t\t\t</Select></td>\n\t\t\t\t<td class=\'fields\' width=\"65%\" rowspan=\"5\" valign=\"top\">&nbsp;&nbsp;&nbsp;&nbsp;<Select name=\"Menu\" id=\"Menu\" size=\"15\" onClick = return displayaccess()\' style=\"HEIGHT: 360px; WIDTH: 280px\" >\n\t\t\t\t\n\t\t\t\t</Select></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<th width=\"35%\" align=left>&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td width=\"35%\" class=\'fields\' valign=\"bottom\">&nbsp;<Select name=\"Facility\" id=\"Facility\" size=\"5\" style=\"HEIGHT: 160px; WIDTH: 267px\" >\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t</Select></td>\n\t\t</tr>\n\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"root_menu\" id=\"root_menu\" value =\'\' >\n\t\t<input type=\"hidden\" name=\"Responsibility\" id=\"Responsibility\" value=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="> \n\t\t<input type=\"hidden\" name=\"menu_id\" id=\"menu_id\" value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="> \n\t\t<script>\n\t\tpopulate_menu();\n\t\t</script>\n\t\t</form>\n\t\t\n\t</body>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			Connection con=null;
			try{
				request.setCharacterEncoding("UTF-8");
				request= new XSSRequestWrapper(request);
				response.addHeader("X-XSS-Protection", "1; mode=block");
				response.addHeader("X-Content-Type-Options", "nosniff");
			con = ConnectionManager.getConnection(request);

			String resp_id=request.getParameter("resp_id");
			String menu_id="";
			try{
					
					String	sql_menu="Select   menu_id from SM_RESP where resp_id='"+resp_id+"' ";

					Statement stmt_menu=con.createStatement();
					ResultSet rs_menu=stmt_menu.executeQuery(sql_menu);
					if(rs_menu!=null)
					{
						while(rs_menu.next())
						{
							menu_id=rs_menu.getString(1);
						}
					}
					if(rs_menu!=null) rs_menu.close();
					if(stmt_menu!=null) stmt_menu.close();
					
				}
				catch( Exception e){//out.println(e);
					e.printStackTrace();
				}
				finally
				{
				}
				


			
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

					try{
							
							String id = "";
							String dat = "";
							
							//String	sql_resp="Select   a.appl_user_id, a.appl_user_name from sm_appl_user a, SM_RESP_FOR_USER b where a.appl_user_id=b.appl_user_id and b.resp_id='"+resp_id+"' order by 2 ";
							//out.println(sql_resp);
							//Statement stmt_resp=con.createStatement();
							//ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
							
							String	sql_resp="Select   a.appl_user_id, a.appl_user_name from sm_appl_user a, SM_RESP_FOR_USER b where a.appl_user_id=b.appl_user_id and b.resp_id=? order by 2 ";
							PreparedStatement pstmt = con.prepareStatement(sql_resp);
							pstmt.setString	(	1,	resp_id		);
							ResultSet rs_resp = pstmt.executeQuery();
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
									
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
							}
							
							if(rs_resp!=null) rs_resp.close();
							//if(stmt_resp!=null) stmt_resp.close();
							if(pstmt!=null) pstmt.close();
						}
						catch( Exception e){//out.println(e);
							e.printStackTrace();
						}
							
				
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

				try{
							String id = "";
							String dat = "";
							//String sql_fac="Select A.Facility_Id, B.Facility_Name from SM_facility_for_resp A, Sm_Facility_Param B where A.Facility_Id = B.Facility_ID and upper(A.resp_id) = upper('"+resp_id+"') order by 2";
							//Statement stmt_fac=con.createStatement();
							//ResultSet rs_fac=stmt_fac.executeQuery(sql_fac);
							
							String sql_fac="Select A.Facility_Id, B.Facility_Name from SM_facility_for_resp A, Sm_Facility_Param B where A.Facility_Id = B.Facility_ID and upper(A.resp_id) = upper(?) order by 2";
							PreparedStatement pstmt_fac = con.prepareStatement(sql_fac);
							pstmt_fac.setString	(	1,	resp_id		);
							ResultSet rs_fac = pstmt_fac.executeQuery();
							if(rs_fac!=null)
							{
								while(rs_fac.next() )
								{
									id=rs_fac.getString(1);
									dat=rs_fac.getString(2);
									
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block13Bytes, _wl_block13);

								}
							}
							
							if(rs_fac!=null) rs_fac.close();
							//if(stmt_fac!=null) stmt_fac.close();
							if(pstmt_fac!=null) pstmt_fac.close();
						}
						catch( Exception e){//out.println(e);
							e.printStackTrace();
						}	
						
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
			finally { 
	ConnectionManager.returnConnection(con,request);
}			

            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.AssociatedUsers.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.AssociatedMenuFunctions.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.AssociatedFacilities.label", java.lang.String .class,"key"));
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
}
