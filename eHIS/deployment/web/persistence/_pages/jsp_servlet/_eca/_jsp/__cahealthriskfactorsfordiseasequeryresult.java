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

public final class __cahealthriskfactorsfordiseasequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAHealthRiskFactorsForDiseaseQueryResult.jsp", 1734265057109L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n<HTML>\n<head>\n\t<script language=\'javascript\' src=\'../../eCA/js/RiskFactorGroup.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n</head>\n\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td class=\'white\' width=\'100%\'></td> \n\t\t\t<td  width=\'25%\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\n\t<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t<tr>\t\t\t\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'10%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'15%\'>Term Set Desc</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'12%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'28%\'>Diagnosis Desc</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'12%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td> \n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'18%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" Desc</td> \n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'5%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td> \n\t</tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</table>\n\t<br>\n\t<center>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</center>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String term_set_id  = request.getParameter("term_set_id") == null? "" : request.getParameter("term_set_id").trim() ;
    String term_set_code = request.getParameter("term_set_code") == null? "" : request.getParameter("term_set_code").trim() ;
	
	term_set_code = term_set_code.toUpperCase();
	System.out.println("28. CAHealthRiskFactorsForDiseaseQueryResult.jsp TERM SET ID " + term_set_id );
	
	System.out.println(" 29. CAHealthRiskFactorsForDiseaseQueryResult.jsp TERM SET CODE " +  term_set_code);
	
	
   
    String risk_grp_type= request.getParameter("risk_grp_type");
	if ( (whereClause == null || whereClause.equals("")) )
    {	
		if ( !(term_set_id == null || term_set_id.equals("")) )
        {	 
			sql.append(" where upper(GD.TERM_SET_ID) like upper('"+term_set_id+"%')");
        }

        if ( !(term_set_code == null || term_set_code.equals("")) )
        {		if(term_set_id == null || term_set_id.equals("")){
					sql.append(" where upper(GD.TERM_SET_CODE) like upper('"+term_set_code+"%')");
				}
				else
				{
					sql.append(" and upper(GD.TERM_SET_CODE) like upper('"+term_set_code+"%')");
				}	
        }  
	/*	if ( !(risk_grp_type == null || risk_grp_type.equals("")) )
		{	if((term_set_code == null || term_set_code.equals("")) && (term_set_id == null || term_set_id.equals("")))
			{
				 if( risk_grp_type.equals("I") )
					   sql.append(" where RISK_GRP_TYPE='I'");
				 
				 if ( risk_grp_type.equals("G") )
					   sql.append(" where RISK_GRP_TYPE='G'");
			}
			else {
				 if( risk_grp_type.equals("I") )
					   sql.append(" and RISK_GRP_TYPE='I'");
				 
				 if ( risk_grp_type.equals("G") )
					   sql.append(" and RISK_GRP_TYPE='G'");
			}
	   } */
    
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
			{
				if ( i == ord.length - 1 )
					sql.append(ord[i]);
				else
					sql.append(ord[i]+",");
			}
		}

    }else
		 sql.append(whereClause);

    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null ){
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
		end =  Integer.parseInt(MstQryPageCnt);
	}
    else
        end = Integer.parseInt( to ) ;

Connection conn  = null;
PreparedStatement pstmt;
ResultSet rs = null;

int maxRecord = 0;
System.out.println(" WHERE CONDITON " + sql.toString());  
//String strsql1="SELECT distinct GD.TERM_SET_ID,GD.TERM_SET_CODE, decode(GD.RISK_GRP_TYPE, 'I','Individual','G','Group') RISK_GRP_TYPE,(SELECT TERM_SET_DESC FROM mr_term_set WHERE term_set_id = gd.TERM_SET_ID) term_set_desc, (SELECT short_desc FROM mr_term_code WHERE term_set_id = gd.TERM_SET_ID and term_code = gd.TERM_SET_CODE) diag_code_desc FROM CA_DIAG_RISK_FACTOR GD " +sql.toString();
//String strsql1="SELECT GD.TERM_SET_ID,GD.TERM_SET_CODE,decode(GD.RISK_GRP_TYPE, 'I','Individual','G','Group') RISK_GRP_TYPE,(SELECT TERM_SET_DESC FROM mr_term_set WHERE term_set_id = gd.TERM_SET_ID) term_set_desc, (SELECT short_desc FROM mr_term_code WHERE term_set_id = gd.TERM_SET_ID and term_code = gd.TERM_SET_CODE) diag_code_desc FROM CA_DIAG_RISK_FACTOR GD " +sql.toString();
String strsql1="SELECT GD.TERM_SET_ID,(SELECT TERM_SET_DESC FROM mr_term_set WHERE term_set_id = gd.TERM_SET_ID) term_set_desc,GD.TERM_SET_CODE, (SELECT short_desc FROM mr_term_code WHERE term_set_id = gd.TERM_SET_ID and term_code = gd.TERM_SET_CODE) diag_code_desc,GD.RISK_GRP_TYPE,GD.RISK_FACTOR, case when RISK_GRP_TYPE = 'G' then  (select RISK_FACTOR_DESC from CA_GROUP_RISK_FACTOR_TYPE where  RISK_FACTOR_GROUP = RISK_FACTOR) when RISK_GRP_TYPE = 'I' then (select RISK_FACTOR_DESC from CA_RISK_FACTOR_TYPE where  RISK_FACTOR_TYPE = RISK_FACTOR) END risk_factor_desc FROM CA_DIAG_RISK_FACTOR GD  " +sql.toString();

System.out.println(" STRING SQL  " +  strsql1);
try
{
	conn 	= ConnectionManager.getConnection(request);
	pstmt	= conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	rs		= pstmt.executeQuery();
	
	while(rs.next())
	{
		maxRecord++;
	}
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

				String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
				int pageCnt = Integer.parseInt(MstQryPageCnt);
			if ( !(start <= 1) )
				out.println("<A class='gridLink' HREF='../../eCA/jsp/CAHealthRiskFactorsForDiseaseQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+pageCnt) > maxRecord ) )
				out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/CAHealthRiskFactorsForDiseaseQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	rs.beforeFirst();

	if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
			rs.next() ;
	String classValue= " ";
	while ( rs.next() && i<=end  ){
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		out.println("<tr>");
		//out.println("<td class='gridData'>");
			String term_set_id_	=(rs.getString("TERM_SET_ID")==null)?"":rs.getString("TERM_SET_ID");
			String term_set_desc_	=(rs.getString("term_set_desc")==null)?"":rs.getString("term_set_desc");
			String term_set_code_	 =(rs.getString("TERM_SET_CODE")==null)?"":rs.getString("TERM_SET_CODE");		
			String diag_code_desc_	=(rs.getString("diag_code_desc")==null)?"":rs.getString("diag_code_desc");
			String risk_grp_type_		=(rs.getString("RISK_GRP_TYPE")==null)?"":rs.getString("RISK_GRP_TYPE");
			String	risk_fact_code_	=(rs.getString("RISK_FACTOR")==null)?"":rs.getString("RISK_FACTOR");
			String risk_fact_desc_	=(rs.getString("risk_factor_desc")==null)?"":rs.getString("risk_factor_desc");
			if(risk_grp_type_.equals("I")) {
				risk_grp_type_ = "Individual";
			}
			else {
				risk_grp_type_ = "Group";
			}	
//out.println("<a class='gridLink' href='../../eCA/jsp/AddModifyHealthRiskFactorsForDisease.jsp?mode=2&term_set_id="+ URLEncoder.encode(term_set_id_)+"&term_set_desc="+ URLEncoder.encode(term_set_desc_)+"&term_set_code="+ URLEncoder.encode(term_set_code_)+"&diag_code_desc="+ URLEncoder.encode(diag_code_desc_)+"'target='f_query_add_mod' >");
		out.println("<td class='gridData'>");
		//out.println(term_set_id_ + "</a></td>");
		out.println(term_set_id_ + "</td>");
		out.println("<td class='gridData'>");
		out.println(term_set_desc_);
		out.println("</td>");
		out.println("<td class='gridData'>");
		out.println(term_set_code_);
		out.println("</td>");
		out.println("<td class='gridData'>");
		out.println(diag_code_desc_);
		out.println("</td>");
		out.println("<td class='gridData'>");	 
		out.println(risk_fact_code_); 
		out.println("</td>");
		out.println("<td class='gridData'>");	 
		out.println(risk_fact_desc_); 
		out.println("</td>");
		out.println("<td class='gridData'>");	 
		out.println(risk_grp_type_); 
		out.println("</td>");
		out.println("</tr>"); 
		
		i++;
	} 
	
            _bw.write(_wl_block15Bytes, _wl_block15);

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

}catch(Exception e){
	//out.println("Exception from CAHealthRiskFactorsForDiseaseQueryResult JSP : "+e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();	
}finally{
	if (conn != null) 
		ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DiagnosisSet.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DiagnosisCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.riskfactor.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.riskfactor.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
