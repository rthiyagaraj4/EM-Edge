package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __freqaccessfunctionlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/FreqAccessFunctionList.jsp", 1742358751070L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eSM/js/FreqAccessFunc.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\nfunction callFunction()\n{\n\tparent.frames[1].location.href=\'../../eSM/jsp/FreqAccessFunctionList.jsp\'\n}\n</script>\n<body onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\'include_func\' id=\'include_func\' method=post ACTION=\'../../servlet/eSM.FreqAccessFuncServlet\' target=\'messageFrame\'   >\n<table border=\"1\" align=\'center\' width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<th align=left width=\'30%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;&nbsp;&nbsp;&nbsp;</th>\n<th align=left width=\'20%\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t<script>\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'COMMON\'));\t\n\t\tparent.frames[2].location.href=\"../../eCommon/html/blank.html\";\n\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n\n\t</table>\n<input type=\'hidden\' name=\'nochbox\' id=\'nochbox\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'checkval\' id=\'checkval\'  >\n<input type=\'hidden\' name=\'Log_user\' id=\'Log_user\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'responsibility_id\' id=\'responsibility_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\"insert\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n</center>\n</BODY>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</form>\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);




	Connection conn=null;
	try{
		request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	ResultSet rs=null;
	Statement stmt = conn.createStatement();
	int count=0;
	String Log_user= (String) session.getValue("login_user");
	String responsibility_id= (String) session.getValue("responsibility_id");
	String submenu_id=request.getParameter("submenu_id");
	String Function_name=request.getParameter("Function_name");
	String p_menu_id=request.getParameter("menu_id");

	int i=0;
	int c=0;
	StringBuffer	sql_count =new StringBuffer();
				sql_count.append(" Select count(*) from sm_freq_func_by_user  ");
				sql_count.append(" where appl_user_id='"+Log_user+"' ");
				sql_count.append(" and resp_id='"+responsibility_id+"'");				
	rs=stmt.executeQuery(sql_count.toString());
	if(rs!=null)
	{
		while(rs.next())
		{
			c=rs.getInt(1);
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
	}

	if(c<10)
	{
	StringBuffer	sql = new StringBuffer();
		sql.append("Select Distinct FUNCTION_ID, MODULE_ID,menu_id, OPTION_SEQUENCE_NO, ");
				sql.append(" OPTION_DESCRIPTOR from SM_MENU_DTL  where  ");
				sql.append(" option_type in ('F','R')   "); //Changed by S.Sathish for IN020879 on Monday, April 26, 2010
				sql.append(" and function_id not in (select function_id from sm_freq_func_by_user ");
				sql.append(" where appl_user_id='"+Log_user+"' ");
				sql.append(" and resp_id='"+responsibility_id+"')");
		try{
			if ((submenu_id!=null) && (!submenu_id.equals("")))
			{
				sql.append("  and  MENU_ID='"+submenu_id+"'  ");
				sql.append(" and FUNCTION_ID not in ( ");
				sql.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				sql.append(" where RESP_ID='"+responsibility_id+"' and ");
				sql.append(" MENU_ID='"+submenu_id+"'   ");
				sql.append(" and EXCL_RESTRICT_IND='E' ");
				sql.append("  )");
			}
			else
			{
				sql.append("  and  MENU_ID='"+p_menu_id+"'  ");
				sql.append(" and FUNCTION_ID not in ( ");
				sql.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				sql.append(" where RESP_ID='"+responsibility_id+"'  ");
				sql.append(" and EXCL_RESTRICT_IND='E' ");
				sql.append("  )");
			}
			if ((Function_name!=null) && (!Function_name.equals(""))){
			sql.append("  and upper(OPTION_DESCRIPTOR) like upper('"+Function_name+"%"+"')  ");
		}
		sql.append(" order by option_descriptor ");	
	stmt = conn.createStatement();	
	rs = stmt.executeQuery(sql.toString());
	}catch (Exception ce) {out.println("Here "+ce);}

try
{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

String classValue = "" ; 	 
while ( rs.next()  )  
{
	 if ( i % 2 == 0 )
	 	  	classValue = "QRYODD" ;
	 	  else
	 	  	classValue = "QRYEVEN" ;

	String name = rs.getString("OPTION_DESCRIPTOR"); 
	String id = rs.getString("function_id"); 
	String menu_id = rs.getString("menu_id"); 
	String option_sequence_no = rs.getString("option_sequence_no"); 
	String module_id = rs.getString("module_id"); 

	out.println("<tr width='100%'><td width='30%' class='"+classValue+"'  >");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+name+"</td><td class='"+classValue+"'   width='20%'  >");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox'  name=Incchkbox_val2 id=Incchkbox_val2' value="+id+"|"+menu_id+"|"+option_sequence_no+"|"+module_id+" ");
	out.println("</td></tr>");
i++;
	count++;
}
//Added by S.Sathish for IN020879 on Monday, April 26, 2010 starts here
if(count == 0)
{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
	//Ends here
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(count));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Log_user));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(responsibility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

}
catch ( Exception e ){ out.println("Exception "+e);}

finally{
	
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;

	}
}
else
{
	out.println("<script>alert(getMessage('FREQ_FUNCTION_LIMIT_10','SM'));</script>");
}

            _bw.write(_wl_block17Bytes, _wl_block17);

}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}	

            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FunctionName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
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
