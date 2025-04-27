package jsp_servlet._eot._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __drugnotificationmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/DrugNotificationModify.jsp", 1721824848000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="             \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<!-- <script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script>\n<script language=\'JavaScript\' src=\'../../eOT/js/OTMessages.js\'></script> -->\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eOT/js/DrugNotification.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey();\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'UpdateQueryResultForm\' id=\'UpdateQueryResultForm\'>\n<P>\n<table align=\'right\'>\n<center>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=3  align=\'center\'>\n<th class=\"columnheadercenter\" nowrap>  <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</th>\n<th class=\"columnheadercenter\" nowrap>  <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</th>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</table>\n</center>\n\n<br><center>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</center>\n<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n<input type=\"hidden\" name=\"def_type\" id=\"def_type\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
		String from = checkForNull(request.getParameter( "from" ) ) ;
		String to =   checkForNull(request.getParameter( "to" ) ) ;
		String def_type = checkForNull(request.getParameter("def_type"),"S");
		String drug_desc = checkForNull(request.getParameter("drug_desc"));
		String status = checkForNull(request.getParameter("status"),"B");
		if(status.equals("E")) status = "Y";
		if(status.equals("D")) status = "N";
		String empty = "".intern();
		String whereClause = empty;
		//String notify_anesthesia_yn=empty;
		int start = ( from.equals("") )?1:Integer.parseInt(from);
		int end = ( from.equals("") )?14:Integer.parseInt(to);
		String sql = empty;
		switch(def_type.charAt(0)){
			case 'D' : sql ="SELECT 'Drug', A.DRUG_DESC,  DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) FROM PH_DRUG_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND A.DRUG_CODE = B.DRUG(+) AND B.DEFN_TYPE(+) = 'D'";
			whereClause=whereClause+( (drug_desc.length()>0)?" and UPPER(A.DRUG_DESC) LIKE UPPER('"+drug_desc+"%')":"");
			whereClause=whereClause+" AND DECODE(B.DRUG,NULL,'B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) = DECODE(B.DRUG,NULL,'"+status+"',DECODE('"+status+"','B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N'),'"+status+"')) ";
			sql=sql+whereClause;
			break;

			case 'G' : sql ="SELECT 'Generic', A. GENERIC_NAME,  DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) FROM  PH_GENERIC_NAME_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND A. GENERIC_ID = B.DRUG(+) AND B.DEFN_TYPE(+)	= 'G' ";
			whereClause=whereClause+( (drug_desc.length()>0)?" and UPPER(A.GENERIC_NAME) LIKE UPPER('"+drug_desc+"%')":"");
			whereClause=whereClause+" AND DECODE(B.DRUG,NULL,'B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) = DECODE(B.DRUG,NULL,'"+status+"',DECODE('"+status+"','B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N'),'"+status+"')) ";
			sql=sql+whereClause;
			break;

			case 'S' : 
			sql="SELECT 'Drug' DEFN_TYPE,A.DRUG_DESC DRUG,  DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) NOTIFY_PRE_ANESTHESIA_YN FROM PH_DRUG_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND A.DRUG_CODE = B.DRUG(+) AND B.DEFN_TYPE(+) = 'D'";
			whereClause=(drug_desc.length()>0)?" and UPPER(A.DRUG_DESC) LIKE UPPER('"+drug_desc+"%')":"";
			whereClause=whereClause+" AND DECODE(B.DRUG,NULL,'B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) = DECODE(B.DRUG,NULL,'"+status+"',DECODE('"+status+"','B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N'),'"+status+"')) ";
			sql=sql+whereClause;
			sql=sql+" UNION SELECT 'Generic' DEFN_TYPE,A.GENERIC_NAME,  DECODE(B.DRUG,NULL,'N',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) NOTIFY_PRE_ANESTHESIA_YN FROM   PH_GENERIC_NAME_LANG_VW A, OT_DRUGS_FOR_NOTIFICATION B WHERE A.LANGUAGE_ID='"+locale+"' AND  A. GENERIC_ID = B.DRUG(+) AND B.DEFN_TYPE(+) = 'G' ";
			whereClause= (drug_desc.length()>0)?" and UPPER(A.GENERIC_NAME) LIKE UPPER('"+drug_desc+"%')":"";
			whereClause=whereClause+" AND DECODE(B.DRUG,NULL,'B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N')) = DECODE(B.DRUG,NULL,'"+status+"',DECODE('"+status+"','B',NVL(B.NOTIFY_PRE_ANESTHESIA_YN,'N'),'"+status+"')) ";
			sql=sql+whereClause;
			break;
		}

	//appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");
    if (ord!=null && ord.length>0){
        sql=sql+" ORDER BY ";
        for ( int i=0;i < ord.length;i++ ){
		  sql=sql+((i==ord.length-1)?ord[i]:ord[i]+",");
		}
    }
    
    //out.println("Line-->71"+sql);
	   
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	int maxRecord = 0;
	int i=1;
	try{
		 conn  =  ConnectionManager.getConnection(request);
		 pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rst = pstmt.executeQuery();
		//move the pointer to last record to get the maxRecord
		rst.last();maxRecord=rst.getRow();
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		//move the resultset pointer to initial position.
		rst.beforeFirst();


            _bw.write(_wl_block9Bytes, _wl_block9);

if ( !(start <= 1) )
	out.println("<A href='../../eOT/jsp/DrugNotificationModify.jsp?from="+(start-14)+"&to="+(end-14)+"&status="+status+"&drug_desc="+drug_desc+"&def_type="+def_type+"'"+" text-decoration='none' target='f_query_add_mod'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
	   out.println("<A href=../../eOT/jsp/DrugNotificationModify.jsp?from="+(start+14)+"&to="+(end+14)+"&status="+status+"&drug_desc="+drug_desc+"&def_type="+def_type+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	   //out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='nxt();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");

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

	
   if ( start != 1 ) rst.absolute(start-1);
		i=start;
   	String classValue= "";
	String flag="";
	StringBuffer sbr = new StringBuffer();
	while (rst.next() && i<=end  ){
		classValue = ( i % 2 == 0 )?"gridData":"gridData" ; // changed by yadav
	     
	//String mode="modify";
	//out.println("<a href='../../eOT/jsp/BlockSlotsBySpecialityFrameForCreate.jsp?update_mode_yn="+mode+"&oper_room_code="+oper_room_code+"&wd_start_time="+rset.getString(3)+"&wd_end_time="+rset.getString(4)+"&hd_start_time="+rset.getString(5)+"&hd_end_time="+rset.getString(6)+"' target='f_query_add_mod' >");
    //out.println(oper_room_code+"</a></td>");
	sbr.append("<tr>");
	sbr.append("<td class='"+classValue+"'>"+rst.getString(1)+"</td>");
	sbr.append("<td class='"+classValue+"'>"+rst.getString(2)+"</td>");
	flag =(rst.getString(3).equals("Y"))?"enabled.gif":"RRnwd.gif"; 
	sbr.append("<td class='").append(classValue).append("'><img src='../../eCommon/images/"+flag+"'></img></td></tr>");
    i++;
  } 
out.println(sbr.toString());
sbr.setLength(0);

            _bw.write(_wl_block13Bytes, _wl_block13);

}catch(Exception e){
		e.printStackTrace();
		//out.println("Err Msg in DrugNotificationModify.jsp(OT)-->"+e);
}finally{
		try{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
}


            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(def_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locale));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefinitionType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDescription.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NotifyAtPreAnaesthesia.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
