package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __querysubsection extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QuerySubSection.jsp", 1731391206647L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<head>\n\t\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<!-- <modifeid by Arvind @06-12-2008> -->\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<style>\n\ttd,th,tr\n\t{border-bottom: 1px solid #d5e2e5;\n\t}\n\t</style>\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\' >\n<tr>\n<td class=\'white\' width=\'88%\'></td> \n<td class=\'label\' align=\'right\' width=\'4%\' nowrap>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n\n<table class=\'grid\'  width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'  >\n<tr align=\'left\'>\n<th class=\'columnheadercenter\' width=\'20%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n<th class=\'columnheadercenter\' width=\'30%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n<th class=\'columnheadercenter\' width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n</tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<tr>\n\t\t<!--<td align==\'left\' class=\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'><a href=\'../../eCA/jsp/addSubSection.jsp?slSec_hdg_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&sec_hdg_desc=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&sub_sec_code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&sub_sec_desc=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&seq_num=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' target=\'f_query_add_mod\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>-->\n\t\t<td align==\'left\' class=\'gridData\'  >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td class=\'gridData\'><!-- <a href=\'../../eCA/jsp/addSubSection.jsp?slSec_hdg_code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' target=\'f_query_add_mod\' > -->";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<!-- </a> --></td>\n\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t<td class=\'gridNumericData\' align=\'right\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</table>\n</center>\n<br><center>\n</center>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql =new StringBuffer();
    String section_code  = request.getParameter("mainSectionCode");
    String section_desc = request.getParameter("mainSectionDesc");
    String subsection_code = request.getParameter("subSectionCode");
    String subsection_desc = request.getParameter("subSectionDesc");
	String seq_num = request.getParameter("seq_num");
	String section_code_display = "";
	String section_desc_display = "";
	String subsection_code_display = "";
	String subsection_desc_display = "";
	String seq_num_display = "";
    String ord[] = request.getParameterValues("orderbycolumns");
	String classValue= "";
	Connection con = null;
	PreparedStatement stmt=null,stmt1=null,ps=null;
	StringBuffer strsql =new StringBuffer();
	StringBuffer strsql1 =new StringBuffer();

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	int maxRecord = 0;
	ResultSet rset=null,rs=null;
    int start = 0 ;
    int end = 0 ;
    int i=1;
	int cnt=0;
	if(section_code  == null)
	{
		section_code  = "";
	}
	else
	{
		section_code = section_code.toUpperCase();
	}
	if(section_desc  == null)
	{
		section_desc  = "";
	}
	else
	{
		section_desc = section_desc.toUpperCase();
	}	
    if ((whereClause == null || whereClause.equals("")) )
		{
			if ( !(section_code == null || section_code.equals("")) )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(header_sec_hdg_code) like upper('"+section_code +"%')");
				cnt++;
			}
			if ( !(section_desc == null || section_desc.equals("")) )
			{
				if(cnt>0)
					sql.append(" and upper(header_sec_hdg_desc) like '"+section_desc+"%'");
				else
				{
					sql.append(" where upper(header_sec_hdg_desc) like '"+section_desc+"%'");
					cnt=1;
				}
			}
		   if ( !(subsection_code == null || subsection_code.equals("")) )
			{
				if(cnt>0)
					sql.append(" and  upper(child_sec_hdg_code) like upper('"+subsection_code+"%')");
				else
				{
					sql.append(" where  upper(child_sec_hdg_code) like upper('"+subsection_code+"%')");
					cnt=1;
				}
			}
			if ( !(subsection_desc == null || subsection_desc.equals("")) )
			{
				if(cnt>0)
					sql.append(" and upper(child_sec_hdg_desc) like upper('"+subsection_desc+"%')");
				else
				{
					sql.append(" where upper(child_sec_hdg_desc) like upper('"+subsection_desc +"%')");
					cnt=1;
				}
			}
		//appending order by clause
		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for (i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else
				sql.append(ord[i]+",");
			}
		}
    } //end of where clause IF
    else
         sql.append(whereClause);
    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;
    if ( to == null )
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;
try
{
	con  =  ConnectionManager.getConnection(request);
	ps = con.prepareStatement("delete from   ca_subsection_link  where child_seq_num is null");
	ps.executeUpdate();
	con.commit();
	strsql.append("select count(*) as total from ca_subsection_link_vw ");
	strsql.append(sql.toString());
	//out.println(sql);
	strsql1.append("SELECT header_sec_hdg_code,header_sec_hdg_desc||nvl2(HEADER_SEC_HDR_META_DESC,'-'||HEADER_SEC_HDR_META_DESC,NULL) header_sec_hdg_desc ,child_sec_hdg_code,  child_sec_hdg_desc||nvl2(child_SEC_HDR_META_DESC,'-'||CHILD_SEC_HDR_META_DESC,NULL) child_sec_hdg_desc, child_seq_num FROM  ca_subsection_link_vw ");
	strsql1.append(sql.toString());
	stmt = con.prepareStatement(strsql.toString());
	rs = stmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	stmt1=con.prepareStatement(strsql1.toString());
	rset = stmt1.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);

	if ( !(start <= 1) )
		out.println("<A class='gridLink'  href='../../eCA/jsp/QuerySubSection.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	if ( !( (start+pageCnt) > maxRecord ) )
		out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/QuerySubSection.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
      while ( rset.next() && i<=end  ) {
		if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
        else
            classValue = "QRYODD" ;
	section_code = rset.getString("header_sec_hdg_code");
	section_desc=rset.getString("header_sec_hdg_desc");
	subsection_code= rset.getString("child_sec_hdg_code");
	subsection_desc= rset.getString("child_sec_hdg_desc");
	seq_num= rset.getString("child_seq_num");
	section_code_display = section_code;
	section_desc_display = section_desc;
	subsection_code_display = subsection_code;
	subsection_desc_display = subsection_desc;
	seq_num_display = seq_num;
	section_code = java.net.URLEncoder.encode(section_code);
	section_desc = java.net.URLEncoder.encode(section_desc);
	subsection_code = java.net.URLEncoder.encode(subsection_code);
	subsection_desc = java.net.URLEncoder.encode(subsection_desc);
	seq_num = java.net.URLEncoder.encode(seq_num);

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(section_code ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( section_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(subsection_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(subsection_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(seq_num));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( section_code_display ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(section_code_display));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( section_desc_display ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( section_code ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( section_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(subsection_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(subsection_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(seq_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( subsection_code_display ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( subsection_desc_display ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( seq_num_display));
            _bw.write(_wl_block26Bytes, _wl_block26);

		i++;
  }
	if(rset != null) rset.close();
	if(rs != null)rs.close();
	if(ps != null)ps.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
}	
catch(Exception e)
{
	//out.println("Exception in Main Block :"+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con !=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MainSectionCode.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MainSectionDesc.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SubSectionCode.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SubSectionDescription.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.OrderSequenceNumber.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
