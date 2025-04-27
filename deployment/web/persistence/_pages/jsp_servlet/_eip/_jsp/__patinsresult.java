package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;

public final class __patinsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PatInsResult.jsp", 1742447089409L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n﻿";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eIP/js/IPBkgPatientInstructions.js\" language=\'javascript\'></script>\n<HTML><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'> \n\n</head>\n<script>\n</script>\n<BODY  class=\'CONTENT\' onLoad=\'ClearMsg();\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<form name=\'PatInsForm\' id=\'PatInsForm\' action=\'../../eIP/jsp/PatInsResult.jsp\' method=\'post\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n\t\t\t\t\t\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t\t\t<p>\n\t\t\t\t\t<table align=\'right\' >\n\t\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</p>\n\t\t\t\t\t<br><br>\n\t\t\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<script>\t\t\n\t\t\t\t\t\t\tif(document.getElementById(\'nextval\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<input type=\'hidden\' name=\'InsCount\' id=\'InsCount\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'selectedInstns\' id=\'selectedInstns\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'excludeInstns\' id=\'excludeInstns\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'patInsCount\' id=\'patInsCount\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'search_text\' id=\'search_text\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'/>\n\t\t\t\t<input type=\'hidden\' name=\'searchcriteria\' id=\'searchcriteria\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'/>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n</td></tr>\n</table>\n</form>\n</BODY>\n</HTML>\n";
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	request.setCharacterEncoding("UTF-8");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String sql="select instruction_id code, instruction_desc description from am_pat_instructions_lang_vw where eff_status = 'E' and LANGUAGE_ID='en' and upper(instruction_id) like upper(?) and upper(instruction_desc) like upper(?) ";
	String searchby=request.getParameter("search_by")==null?"":request.getParameter("search_by");
	String searchtext=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	String searchcriteria=request.getParameter("searchcriteria")==null?"":request.getParameter("searchcriteria");
	String excludeInstns=request.getParameter("excludeInstns")==null?"":request.getParameter("excludeInstns");
	String patInsCount=request.getParameter("patInsCount")==null?"0":request.getParameter("patInsCount");
	String excludeInstnsFormatted="";
	if(excludeInstns!=null && !excludeInstns.equals("")){		
		excludeInstnsFormatted="'"+excludeInstns.replaceAll(",","','");
		excludeInstnsFormatted = excludeInstnsFormatted.substring(0,excludeInstnsFormatted.length()-2);
		sql=sql+" and instruction_id not in ("+excludeInstnsFormatted+") ";
	}
// 	StringBuffer sql = new StringBuffer();
	String from  = request.getParameter( "from" ) ;
	String to    = request.getParameter( "to" ) ;
	String selectedInstns    = request.getParameter( "selectedInstns" ) ;
	if (selectedInstns ==null || selectedInstns.equals("null"))
		selectedInstns="";
	int andCheck = 0;
	
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	String endOfRes="1";
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
	Connection conn = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try{		
			conn=ConnectionManager.getConnection(request);
			stmt=conn.prepareStatement(sql);
			if(searchby.equals("C")){
				if (searchcriteria.equals("S")){					
					stmt.setString(1,searchtext+"%");
				}else if (searchcriteria.equals("E")){
					stmt.setString(1,"%"+searchtext);
				}else if (searchcriteria.equals("C")){
					stmt.setString(1,"%"+searchtext+"%");
				}
				//stmt.setString(1,searchtext+"%");
				stmt.setString(2,"%");
			}else{				
				stmt.setString(1,"%");
				//stmt.setString(2,searchtext+"%");
				if (searchcriteria.equals("S")){
					stmt.setString(2,searchtext+"%");
				}else if (searchcriteria.equals("E")){
					stmt.setString(2,"%"+searchtext);
				}else if (searchcriteria.equals("C")){
					stmt.setString(2,"%"+searchtext+"%");
				}
			}
			rs=stmt.executeQuery();

			String codeArray[]=selectedInstns.split(",");
			String codeChecked="";

			if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		  }
            _bw.write(_wl_block8Bytes, _wl_block8);


					String classValue="";
				while (i<=end  && rs.next()  )
				{ 
					if (maxRecord==0)
				{
				  
            _bw.write(_wl_block9Bytes, _wl_block9);

					if ( !(start <= 1) )
						out.println("<td class='label' align='right'><A HREF='javascript:submitPrevNext("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");//modified for the incident 39911

					if ( endOfRes.equals("1"))
						out.println("<td class='label' align='right'><A  id='nextval' HREF='javascript:submitPrevNext("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");//modified for the incident 39911
					
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

						
						
				}

						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						codeChecked="";
						for(int instnId=0;instnId<codeArray.length;instnId++){
							
							if(codeArray[instnId].equals(rs.getString(1))){
								codeChecked="checked";						
								break;
							}
						}
						out.println("<tr><td class='" + classValue + "'><font size='1'>"+rs.getString(1)+"</td>");
						out.println("<td class='" + classValue + "'><font size='1'>"+rs.getString(2)+"</td>");
						out.println("<td class='" + classValue + "'><input type='checkbox' name='patInsChk"+i+"' id='patInsChk"+i+"' onclick='addSelectedIns(this,"+i+");' "+codeChecked+"/></td></tr>");
						out.println("<input type='hidden' name='patInsCode"+i+"' id='patInsCode"+i+"' value='"+rs.getString(1)+"' />");
						

					i++;
					maxRecord++;
				}

				if( !rs.next() && maxRecord!=0 )
						{
							endOfRes="0";
						
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(selectedInstns));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(excludeInstns));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patInsCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(to));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(searchtext));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(searchby));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(searchcriteria));
            _bw.write(_wl_block23Bytes, _wl_block23);

		
			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			}

			boolean flag = false;
	
			
	}catch(Exception e){ out.println(e);e.printStackTrace();
	}
	finally   
	{
		if(stmt!=null) stmt.close();
		if(rs!=null) 	 rs.close();
		ConnectionManager.returnConnection(conn,request);
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
