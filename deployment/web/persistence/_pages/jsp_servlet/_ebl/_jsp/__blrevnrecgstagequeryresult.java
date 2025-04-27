package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __blrevnrecgstagequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLRevnRecgStageQueryResult.jsp", 1723102102011L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<HTML>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'QueryResult\' id=\'QueryResult\'>\n<P>\n<table align=\'right\'>\n\t<tr>\n\t\t<td>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</td>\n\t</tr>\n</table>\n<br><br>\n</p>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t<th class=\"columnheadercenter\" nowrap> \n\t\tOrder Category\n\t</th>\n\t<th class=\"columnheadercenter\" nowrap> \n\t\tLong Desc\n\t</th>\n\t<th class=\"columnheadercenter\" nowrap> \n\t\tShort Desc\n\t</th>\n\t<th class=\"columnheadercenter\" nowrap> \n\t\tOrder Type Code\n\t</th>\n\t<th class=\"columnheadercenter\" nowrap> \n\t\tRevenue Stage\n\t</th>\n\t<th class=\"columnheadercenter\" nowrap> \n\t\tEff From\n\t</th>\n\t<th class=\"columnheadercenter\" nowrap> \n\t\tEff to\n\t</th>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</tr>\n</table>\n<br><center>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</center>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

     private String checkForNull(String inputString) {
 		if(inputString == null || "null".equals(inputString)){
 			inputString = "";
 		}
 		return inputString;
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

/*
Sr No        Version               Incident              SCF/CRF             	Developer Name
1            V200922               74105             NMC-JD-CRF-0011        	 Shikha Seth
2			 V210518			   17598			  Common-ICN-0034			 Mohana Priya K
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try{	
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String sql = " ";    
    
    String order_category = request.getParameter("order_cat")==null?"":request.getParameter( "order_cat" ).trim().toUpperCase();
    String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" ).trim().toUpperCase();
    String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" ).trim().toUpperCase();
	String order_type_code =request.getParameter("order_type")==null?"":request.getParameter( "order_type" ).trim().toUpperCase();
	String rev_satge =request.getParameter("Revenue_Stage")==null?"":request.getParameter( "Revenue_Stage" ).trim().toUpperCase();

	String eff_from =request.getParameter("p_fm_date")==null?"":request.getParameter( "p_fm_date" ).trim().toUpperCase();
	String eff_to ="";	
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;        

        if ( !(order_category == null || order_category.equals("")) ){
	        sql = sql + "and upper(hdr.order_category) like upper('"+order_category +"%')";
			cnt++;
        }       
       /* if ( !(short_desc == null || short_desc.equals("")) ){
	        sql = sql + "and upper(hdr.short_desc) like upper('"+short_desc +"%')";
			cnt=2;
        }
       if ( !(long_desc == null || long_desc.equals("")) ){
	        sql = sql + "and upper(hdr.long_desc) like upper('"+long_desc +"%')";
			cnt=2;
        }*/
        if ( !(order_type_code == null || order_type_code.equals("") || order_type_code.equals("--SELECT--")) ){
			sql=sql+" and upper(hdr.order_type_code) like '"+order_type_code+"%'";
			cnt=2;
         }
		if ( !(rev_satge == null || rev_satge.equals("")) || rev_satge.equals("--SELECT--")){
			sql=sql+" and upper(hdr.rev_satge) like '"+rev_satge+"%'";
			cnt=2;
         }
		if ( !(eff_from == null || eff_from.equals("")) ){
			//sql=sql+" and hdr.eff_from >=  to_date('"+eff_from+"','DD/MM/YYYY') ";		
			sql=sql+" and ((trunc(to_date('"+eff_from+"','DD/MM/YYYY')) between trunc(hdr.eff_from) and trunc(nvl(hdr.eff_to,sysdate)))or(trunc(hdr.eff_from) > trunc(to_date('"+eff_from+"','DD/MM/YYYY'))))";			
			cnt=2;
         }	 
	}   

	String from=null;
	String to=null;
    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	PreparedStatement stmt2 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;
	ResultSet rs2 = null;

	try{		
		String strsql="SELECT count(*) as total FROM bl_order_revenue_stage hdr where operating_facility_id='"+facility_id+"' "+sql ;
		
		String strsql1="SELECT order_category, long_desc,short_desc, order_type_code,rev_satge, to_char(eff_from,'dd/mm/yyyy') eff_from, to_char(eff_to,'dd/mm/yyyy') eff_to,eff_from eff_from1 FROM "+"bl_order_revenue_stage hdr where operating_facility_id='"+facility_id+"' "+sql +" order by 1,4,eff_from1";
		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	}catch(Exception e){
		System.err.println("exception occurred "+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

		if ( !(start <= 1) )
			out.println("<A HREF='../../eBL/jsp/BLRevnRecgStageQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eBL/jsp/BLRevnRecgStageQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		
            _bw.write(_wl_block9Bytes, _wl_block9);
             org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setValue(locale 
);
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	int mOrder = 0;
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String classValue= " ";
    while ( rset.next() && i<=end  )
	{
		if ( i % 2 == 0 )
            classValue = "gridData" ;  
        else
            classValue = "gridData" ;  		
    
		order_category=checkForNull(rset.getString("order_category"));
		long_desc=checkForNull(rset.getString("long_desc"));
		short_desc=checkForNull(rset.getString("short_desc"));
		order_type_code=checkForNull(rset.getString("order_type_code"));
		rev_satge=checkForNull(rset.getString("rev_satge"));   
		eff_from=checkForNull(rset.getString("eff_from"));   
		eff_to=checkForNull(rset.getString("eff_to"));   
		String order_type_code_desc = "";
		try {
			String strsql2="SELECT long_desc FROM or_order_type where order_type_code='"+order_type_code+"'" ;
			stmt2=conn.prepareStatement(strsql2);
			rs2 = stmt2.executeQuery();
			while (rs2.next())
			{
				order_type_code_desc = checkForNull(rs2.getString(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
			order_type_code_desc = order_type_code;
		}
		
		//V200922 Start
		if (order_type_code_desc == null || order_type_code_desc.equals("")) {
			order_type_code_desc = "**";
		}
		//V200922 End
		
		String rev_satge_desc = "";
		if (rev_satge.equals("BLD")) rev_satge_desc = "Billed";
		if (rev_satge.equals("REG")) rev_satge_desc = "Registered";
		if (rev_satge.equals("CMP")) rev_satge_desc = "Completed";		
				
		String mode="modify";
		out.println("<tr>");	
		out.println("<td class='" + classValue+"' nowrap>"+order_category+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+long_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+short_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+order_type_code_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+rev_satge_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+eff_from+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+eff_to+"</td>");

		i++;
} 
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(stmt2!=null)	stmt2.close(); //V200518
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception e)
	{
		out.println("here "+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setBasename(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDSN.resources.Labels", java.lang.String .class,"basename"));
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("dl_labels", java.lang.String .class,"var"));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
