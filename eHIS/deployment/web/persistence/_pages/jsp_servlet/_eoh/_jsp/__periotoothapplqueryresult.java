package jsp_servlet._eoh._jsp;

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

public final class __periotoothapplqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioToothApplQueryResult.jsp", 1742903555157L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\t</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<P>\n<form name=\'QueryResult\' id=\'QueryResult\' >\n<table align=\'right\'>\n<tr>\n<td>\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n \n\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n    <td class=\"ColumnHeaderCenter\">\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</td> \n\t<td class=\"ColumnHeaderCenter\">\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</td>\n\t\t\n\t<td class=\"ColumnHeaderCenter\">\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</td>\n\n\t<td class=\"ColumnHeaderCenter\">\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t</td> \n\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</td></tr>\n</table>\n</center>\n<br>\n<center>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</center>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );
 
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
 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
    String facility_id = (String)session.getValue( "facility_id" ) ;

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	try{
	String whereClause = checkForNull(request.getParameter("whereclause"));
    String from = checkForNull(request.getParameter( "from" ),"1") ;
    String to = checkForNull(request.getParameter( "to" ),"14" ) ;
    String sql = " ";
    String component_desc_user_def =  request.getParameter("component_desc_user_def")==null?"":request.getParameter( "component_desc_user_def" ).toUpperCase();
	String ns_tooth_no = request.getParameter("ns_tooth_no")==null?"":request.getParameter( "ns_tooth_no" ).toUpperCase();
	String chart_code = request.getParameter("chart_code")==null?"":request.getParameter( "chart_code" ).toUpperCase();
	String status = checkForNull(request.getParameter( "status"));
    String tooth_numbering_system="";
	  if ( (whereClause == null || whereClause.equals("")) ) {

		int cnt=0;
		if ( !(chart_code == null || chart_code.equals("")) ){
	        sql = sql + " and upper(A.CHART_CODE ) like upper('"+chart_code +"%')";
			cnt++;
        }

		if ( !(component_desc_user_def == null || component_desc_user_def.equals("")) ){
			if(cnt>0)
				sql = sql + " and UPPER(A.COMPONENT_CODE) like upper('"+component_desc_user_def+"%')";
			else{
	        sql = sql + " and upper(A.COMPONENT_CODE ) like upper('"+component_desc_user_def +"%')";
			cnt=1;
			}
        }

        if ( !(ns_tooth_no == null || ns_tooth_no.equals("")) ){
			if(cnt>0){
				//sql = sql + " and UPPER(A.TOOTH_NO) like upper('"+ns_tooth_no+"%')";
				sql = sql + " and A.TOOTH_NO = '"+ns_tooth_no+"'";
			}else{
				//sql=sql+" and UPPER(A.TOOTH_NO) like upper('"+ns_tooth_no+"%')";
				sql=sql+" and A.TOOTH_NO = '"+ns_tooth_no+"'";
				cnt=1;
			}
        }
	   	if ( !(status == null || status.equals("")) ){
		  if( status.equals("Y") ){
			if(cnt>0)
			   sql = sql+" and nvl(required_yn,'Y')='Y' ";
			else{
				sql=sql+ " and  nvl(required_yn,'Y')='Y' ";
				cnt=1;
			}
         }

		 if ( status.equals("N") ){
            if(cnt>0)
			   sql = sql+" and required_yn='N'";
			else
				sql=sql+ "and  required_yn='N'";
         }

         if ( status.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
    }

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql=sql+" order by ";
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql=sql+ord[i];
        else
            sql=sql+ord[i]+",";
        }
    }

    } //end of where clause IF
   else
            sql = whereClause;

    int start = 0 ;
    int end = 0 ;
    int i=1;
	start = Integer.parseInt( from ) ;
	end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);

	PreparedStatement pstmt = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rst=null;
	ResultSet rs = null;
	String mode = "";
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = "";
	//
	try{
		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		//Based on the Chart Level the paramters need to be taken.
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
		pstmt = conn.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
		rs = pstmt.executeQuery();
		while (rs != null && rs.next()){
			oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
		}

		if(oh_chart_level.equals("E")){
			String sql1="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM";
			pstmt = conn.prepareStatement(sql1);
		}else{//End
			String sql1="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
			conn  =  ConnectionManager.getConnection(request);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
		}
	    rst = pstmt.executeQuery();
		while(rst.next()){
			tooth_numbering_system=rst.getString("TOOTH_NUMBERING_SYSTEM");
		}
		
		//String strsql="select count(*) as total from OH_PERIODONTAL_CHART_DEF_HDR WHERE LANGUAGE_ID =? "+sql;
		//String strsql1="Select chart_code, long_desc, short_desc, nvl(eff_status,'E') status from OH_PERIODONTAL_CHART_DEF_HDR Where LANGUAGE_ID = ? "+sql;
		String strsql="SELECT COUNT(*) AS TOTAL FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_PERIODONTAL_CHART_COMP B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE   A.CHART_CODE = NVL(?,A.CHART_CODE) AND  A.COMPONENT_CODE 		= B.COMPONENT_CODE AND   (A.TOOTH_NO		= '*A'OR     A.TOOTH_NO		= C.TOOTH_NO) AND   C.NUMBERING_SYSTEM	= ? "+sql;
	//	String strsql1="SELECT CHART_CODE, CHART_DESC, NVL(EFF_STATUS,'E') STATUS FROM OH_PERIODONTAL_CHART_DEF_HDR "+sql;
		/*String strsql1="SELECT  B.COMPONENT_DESC_USER_DEF, C.NS_TOOTH_NO, A.REQUIRED_YN FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_PERIODONTAL_CHART_COMP B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE        A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE AND   (A.TOOTH_NO = '*A' OR A.TOOTH_NO = C.TOOTH_NO) AND   C.NUMBERING_SYSTEM	= ? "+sql;*/
		String strsql1="SELECT  (SELECT  CHART_DESC  FROM OH_PERIODONTAL_CHART_DEF_HDR WHERE  CHART_CODE= A.CHART_CODE) CHART_DESC ,B.COMPONENT_DESC_USER_DEF, C.NS_TOOTH_NO, A.REQUIRED_YN FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_PERIODONTAL_CHART_COMP B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE  A.CHART_CODE = NVL(?,A.CHART_CODE) AND A.COMPONENT_CODE = B.COMPONENT_CODE AND   (A.TOOTH_NO = '*A' OR A.TOOTH_NO = C.TOOTH_NO) AND   C.NUMBERING_SYSTEM	= ? "+sql;
 
//out.println(strsql1);
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,chart_code);
		stmt.setString(2,tooth_numbering_system);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("TOTAL");
		

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,chart_code);
		stmt1.setString(2,tooth_numbering_system);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		System.err.println("Error in PerioToothApplQueryResult.jsp "+e);
		out.println("Error in PerioToothApplQueryResult.jsp "+e);
	}

            _bw.write(_wl_block7Bytes, _wl_block7);

if ( !(start <= 1) )
	out.println("<A HREF='../jsp/PerioToothApplQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../jsp/PerioToothApplQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


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

	   if ( start != 1 )
	     for( int j=1; j<start; i++,j++ )
	      rset.next() ;
			String classValue= " ";
		      while ( rset.next() && i<=end  ) {
			    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
					classValue = "QRYODD" ;
				out.println("<tr><td align=='left' class='" + classValue + "'>");
				String chart_desc = rset.getString("CHART_DESC");
				component_desc_user_def = rset.getString("COMPONENT_DESC_USER_DEF");
				ns_tooth_no=rset.getString("NS_TOOTH_NO");
				status= rset.getString("REQUIRED_YN");
				//String mode="modify";
				mode="modify";
			//	out.println("<a href='../../eOH/jsp/PeriodontalChartMain.jsp?mode="+mode+"&Component="+ Component+"' target='f_query_add_mod' >");
			//	out.println(chart_code+"</a></td>");
				out.println(chart_desc+"</td><td class='" + classValue + "'>");
				out.println(component_desc_user_def+"</td><td class='" + classValue + "'>");
				out.println(ns_tooth_no+"</td><td class='" + classValue + "'>");
				
				
				if (  rset.getString("REQUIRED_YN").equals("Y") || rset.getString("REQUIRED_YN").equals("null"))
				   out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</td>");
				
				i++;
			}


            _bw.write(_wl_block13Bytes, _wl_block13);

				if(stmt!=null)	stmt.close();
				if(stmt1!=null)	stmt1.close();
				if(rs!=null)	rs.close();
				if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception e)
		{
			System.err.println("Error in PerioToothApplQueryResult "+e);
			out.println("Error in PerioToothApplQueryResult "+e);
		}

            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ChartID.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Component.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.ToothApplicable.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Required?.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
