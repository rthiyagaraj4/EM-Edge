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
import java.util.*;
import com.ehis.util.*;

public final class __respmenurstrnforresp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/RespMenuRstrnForResp.jsp", 1742365634273L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n<html>\n\t<head>\n\t\t\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\t<script>\n\t\t\n\t\tfunction CallRemove()\n\t\t{\n\t\t\tvar resp_id=document.forms[0].resp_id.value;\n\t\t\tparent.frames[1].document.location.href=\'../jsp/RemoveMenuRstrnForResp.jsp?resp_id=\'+resp_id;\n\t\t\tparent.frames[2].document.location.href =\'../jsp/QueryMenuRstrnForResp.jsp?resp_id=\'+resp_id;\n\t\t\tparent.frames[3].document.location.href =\'../../eCommon/html/blank.html\';\n\t\t}\n\t\tfunction populate_menu_name(obj)\n\t\t{\n\t\t\tif(obj.value !=\'\')\n\t\t\t{\n\t\t\tvar resp_id = obj.value;\n\t\t\tvar htmlText = \"\";\n\t\t\thtmlText+=\"<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link></head>\";\n\t\t\thtmlText+=\"<body class=\'message\' onKeyDown = \'lockKey()\'>\";\n\t\t\thtmlText+=\"<form name=\'dummyform\' id=\'dummyform\' method=\'post\' action=\'../jsp/GetMenuForResp.jsp\'>\";\n\t\t\thtmlText+=\"<input type=hidden name=\'menu_id\' id=\'menu_id\' value=\'\"+document.forms[0].menu_id.value+\"\'>\";\n\t\t\thtmlText+=\"<input type=hidden name=\'resp_id\' id=\'resp_id\' value=\'\"+resp_id+\"\'>\";\n\t\t\thtmlText+=\"</form>\";\n\t\t\thtmlText+=\"</body>\";\n\t\t\thtmlText+=\"</html>\";\n\t\t\tparent.parent.messageFrame.document.write(htmlText);\n\t\t\tparent.parent.messageFrame.document.forms[0].submit();\n\t\t\tCallRemove();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\tdocument.getElementById(\'menu_name\').innerText=\"\";\n\t\t\tdocument.getElementById(\'menudisp\').innerText=\"\";\n\t\t\tparent.frames[1].document.location.href =\'../../eCommon/html/blank.html\';\n\t\t\tparent.frames[2].document.location.href =\'../../eCommon/html/blank.html\';\n\t\t\tparent.frames[3].document.location.href =\'../../eCommon/html/blank.html\';\n\t\t\t}\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t</head>\n\t<body  onKeyDown = \'lockKey()\';  onload=\'FocusFirstElement()\'>\n\t<form name=\'form1\' id=\'form1\'>\n\t\t<table border=0 cellspacing=0 cellpadding=0 align=center width=\'102%\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<select name=\'resp_id\' id=\'resp_id\' onchange=\'populate_menu_name(this)\'>\n\t\t\t\t\t\t<option value=\'\'>--------";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="---------</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr><td colspan=\'2\'>&nbsp;</td></tr>\n\t\t\t\t<tr>\n\t\t\t\t<td class=label  id=\'menudisp\' >&nbsp;&nbsp;</td>\n\t\t\t\t<td id=\'menu_name\' nowrap  class=\'queryData\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\t\t\t\t</tr>\n\t\t</table>\n\t\t<input type=hidden name=\'menu_id\' id=\'menu_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

			Connection con=null;
			//Statement stmt=null;
			Statement stmt_resp=null;
			try{
			request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
			String resp_id=request.getParameter("resp_id");
			if (resp_id==null) resp_id="";
			String menu_id=request.getParameter("menu_id");
			if (menu_id==null) menu_id="";
			String menu_name=request.getParameter("menu_name");
			if (menu_name==null) menu_name="";
			String sql_resp="";
		/*	String Log_user= (String) session.getValue("login_user");
			ResultSet rset=null ;
			int Medadmin=0;
			stmt=con.createStatement();
			String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	

			rset=stmt.executeQuery(sql);
			if (rset !=null)
			{
				while (rset.next())
				{
					Medadmin=Integer.parseInt(rset.getString(1));
				}
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();

		if (Medadmin >0   ) 
		{
			sql_resp="Select resp_id, resp_name,menu_id  from sm_resp where eff_status='E' and resp_group_id in ( select  resp_group_id from sm_menu_admin where menu_admin_id='"+Log_user+"') order by 2 ";
		}
		else 
		{*/
			sql_resp="Select resp_id, resp_name,menu_id  from sm_resp where eff_status='E' order by 2 ";
		//}

		
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

						try{
							
							String id = "";
							String dat = "";
							//String dat1 = "";
							String sel = "";
							stmt_resp=con.createStatement();
							ResultSet rs_resp=stmt_resp.executeQuery(sql_resp);
							if(rs_resp!=null)
							{
								while(rs_resp.next())
								{
									id=rs_resp.getString(1);
									dat=rs_resp.getString(2);
								
									if(id.equals(resp_id))
										sel="selected";
									out.println("<option value='"+id+"'"+sel+">"+dat+"</option>");
									sel = "";
								}
							}
							if(rs_resp!=null)rs_resp.close();
							if(stmt_resp!=null)stmt_resp.close();
						}
						catch( Exception e){out.println(e);}
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(menu_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

			if(stmt_resp!=null) stmt_resp.close();
			//if(stmt!=null) stmt.close();
			
}catch(Exception e){out.println(e);}
	finally {
		ConnectionManager.returnConnection(con,request);
}
		

            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.responsibility.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
