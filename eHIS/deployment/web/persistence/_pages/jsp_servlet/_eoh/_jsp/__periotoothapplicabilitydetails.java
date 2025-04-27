package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;

public final class __periotoothapplicabilitydetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioToothApplicabilityDetails.jsp", 1709119363645L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eOH/js/PerioToothApplicability.js\" language=\"javascript\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/Hashtable.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<body onLoad=\"parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=true;\" OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name=\"PerioToothApplicabilityDetails\" id=\"PerioToothApplicabilityDetails\" method=\"post\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<p>\n<table align=\'right\' border=0>\n<tr>\n\t<td>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</td>\n</tr>\n</table>\n<br><br>\n</p>\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'2\'  align=\'center\'>\n<br>\n       <tr>\n\t\t\t<td class=\'columnHeader\'  width=\"30%\" align=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</td>\n\t\t\t<td class=\"columnHeader\" width=\'30%\' align=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</td>\n\t\t\t\t\n\t  </tr>\n     ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n  \n</table>\n ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n<input type=\"hidden\" name=\"totalSelected\" id=\"totalSelected\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name=\"tooth_range_count_for_order\" id=\"tooth_range_count_for_order\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n<input type=\"hidden\" name=\"tooth_numbering_system\" id=\"tooth_numbering_system\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n<input type=\"hidden\" name=\"component_desc_user_def\" id=\"component_desc_user_def\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n<input type=\"hidden\" name=\"ns_tooth_no\" id=\"ns_tooth_no\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n<input type=\"hidden\" name=\"required_yn\" id=\"required_yn\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n<input type=\"hidden\" name=\"chart_code\" id=\"chart_code\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n<input type=\"hidden\" name=\"oh_chart_level\" id=\"oh_chart_level\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String strsql = "";
	String sql="";
	String params = request.getQueryString() ;
    String facility_id = (String)session.getValue( "facility_id" ) ;
	String tooth_numbering_system="";
	String chart_code=checkForNull(request.getParameter( "chart_code" )) ;
	String required_yn="";
	String oh_chart_level=checkForNull(request.getParameter( "oh_chart_level" )) ;


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
   
     String select_value="Y";
	 String select_checked="";
	 String component_desc_user_def="";
	 String ns_tooth_no="";
     String classValue="";
     String from = checkForNull(request.getParameter( "from" )) ;
     String to =   checkForNull(request.getParameter( "to" ) ); 
     int start = ( from.equals("") )?1:Integer.parseInt(from);
     int end =  ( to.equals("") )?10:Integer.parseInt(to);
	 StringBuffer sbr = new StringBuffer();
	 String totalSelected=request.getParameter("totalSelected");
	 String tooth_range_count_for_order=request.getParameter("tooth_range_count_for_order");
	
     int i=1;
     try{
   		conn  =  ConnectionManager.getConnection(request);
		if(oh_chart_level.equals("E")){//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
			sql="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM";
			pstmt = conn.prepareStatement(sql);
		}else{	 
			sql="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,facility_id);
		}
	    rst = pstmt.executeQuery();
		while(rst.next()){
			tooth_numbering_system=rst.getString("TOOTH_NUMBERING_SYSTEM");
		}

        if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
	    strsql="SELECT A.COMPONENT_CODE,B.COMPONENT_DESC_USER_DEF, NS_TOOTH_NO,A.TOOTH_NO,REQUIRED_YN FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_PERIODONTAL_CHART_COMP B, (SELECT TO_CHAR(TOOTH_NO) TOOTH_NO, NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = ? UNION SELECT '*A', '*All Tooth' FROM DUAL) C WHERE A.CHART_CODE = ?  AND            A.COMPONENT_CODE  = B.COMPONENT_CODE AND   A.TOOTH_NO		= C.TOOTH_NO ORDER BY 2,3";

		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,chart_code);

		rst = pstmt.executeQuery();
		
		int total=0;
	    int maxRecord  = 0;
		
		while(rst.next()){
			total++;
		}
		maxRecord = total;
		
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();

		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,chart_code);
		rst = pstmt.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);
 
		if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
		if ( !( (start+10) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 
		   
		if(start != 1 )
			for(int j=1; j<start; i++,j++ )
				rst.next() ;
		
			while ( rst.next() && i<=end){
				classValue  = ( i % 2 == 0 )?"QRYEVENSMALL":"QRYODDSMALL" ;
				String component_code=rst.getString("COMPONENT_CODE");
				String tooth_no=rst.getString("TOOTH_NO");
				component_desc_user_def= rst.getString("COMPONENT_DESC_USER_DEF");
				ns_tooth_no= rst.getString("NS_TOOTH_NO");
				required_yn= rst.getString("REQUIRED_YN");
				
				if(required_yn.equals("Y")){
				 select_value="Y";
				 select_checked="checked";
				}
				else{
				 select_value="N";
				 select_checked="";
				}
        
				sbr.append("<tr>");
				
				sbr.append("<td  width='45%' class='"+classValue+"'><a href='../../eOH/jsp/PerioToothApplicabilityFooter.jsp?flag=1&component_desc_user_def="+component_desc_user_def+"&ns_tooth_no="+ns_tooth_no+"&select_checked="+select_checked+"&select_value="+select_value+"&component_code="+component_code+"&tooth_no="+tooth_no+"&tooth_numbering_system="+tooth_numbering_system+"&oh_chart_level="+oh_chart_level+"&chart_code="+chart_code+"' target='PerioToothApplicabilityFooter' >"+component_desc_user_def+"</a></td>");
				
				sbr.append("<td  width='40%' class='"+classValue+"'>"+ns_tooth_no+"</td>");
				sbr.append("<td  width='15%' class='" + classValue+"'>");
			
				if (rst.getString("REQUIRED_YN").equals("Y") || rst.getString("REQUIRED_YN").equals("null"))
				   sbr.append("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					sbr.append("<img src='../../eCommon/images/RRnwd.gif'></img>");

				//out.println("</td>");

				sbr.append("</td>");
				sbr.append("</tr>");
			
				i++;
			}

			out.println(sbr.toString());	
   
            _bw.write(_wl_block12Bytes, _wl_block12);
 
   }catch(Exception e){
		e.printStackTrace() ;
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			if(sbr!=null)   sbr.setLength(0);
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){}
	}
   
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(end));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(totalSelected));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(params));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(tooth_range_count_for_order));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tooth_numbering_system));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(component_desc_user_def));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ns_tooth_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(required_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chart_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block25Bytes, _wl_block25);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Component.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothApplicable.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Required?.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
