package jsp_servlet._emr._jsp;

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
import eCommon.XSSRequestWrapper;

public final class __factorsfortermcodedetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/FactorsForTermCodeDetail.jsp", 1709118921345L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!--  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="   -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<head>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../js/FactorsForTermCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\'\'>\n<form name=\'FactorsForTermCodeDetail\' id=\'FactorsForTermCodeDetail\' method=\'post\' action=\'\'>\n<table width=\'95%\'>\n\n</table>\n<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<TR>\n\t\t<TH width=\'60%\' align=\'left\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</TH>\n\t\t<TH width=\'25%\' align=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TH>\n\t\t<TH>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;<INPUT TYPE=\"checkbox\" name=\"chkall\" id=\"chkall\" onclick=\'chkallvall(this,";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =")\'></TH>\n\t</TR>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' align=\'center\'><INPUT TYPE=\'checkbox\' name=\'chks_factor";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'chks_factor";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  onclick=\'remchk(this);\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" ></td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</table>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<INPUT type=hidden name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<INPUT type=hidden name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<INPUT type=hidden name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<INPUT type=hidden name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<INPUT type=hidden name=\"selectall\" id=\"selectall\" value=\"\">\n<INPUT type=hidden name=\"term_set_id\" id=\"term_set_id\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<INPUT type=hidden name=\"term_code\" id=\"term_code\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<INPUT type=hidden name=\"total_count\" id=\"total_count\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet FactorsForTermCodebn= null;synchronized(session){
                FactorsForTermCodebn=(webbeans.eCommon.RecordSet)pageContext.getAttribute("FactorsForTermCodebn",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FactorsForTermCodebn==null){
                    FactorsForTermCodebn=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("FactorsForTermCodebn",FactorsForTermCodebn,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = checkForNull((String)session.getAttribute("LOCALE")); 

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
Statement pstmt = null;
PreparedStatement pstmt1=null;
ResultSet rs = null;
String term_set_id = request.getParameter("term_set_id");
String term_code = request.getParameter("term_code");
//String flagSelect=request.getParameter("flagSelect");
//String from = request.getParameter("from") ;
//String to = request.getParameter("to") ;
String className = "";
String chked_factor = "";
String factor_val = "";
int maxRecord = 0;
int start = 1 ;
int end = 1 ;
int j = 1;
//int rec_index = -1;
try
{
	con = ConnectionManager.getConnection(request);
	ArrayList arr_factor = null;
	ArrayList arr_main = new ArrayList();

	//FactorsForTermCodebn.clearAll();
	String sql_factors_for_bean = "select a.factor_code factor_code ,b.defn_characteristic_yn defn_characteristic_yn,b.related_factor_yn related_factor_yn,b.risk_factor_yn risk_factor_yn  from mr_factor_for_term_code a, mr_factor_lang_vw b where a.term_set_id =? and a.term_code =? and b.factor_code=a.factor_code and b.language_id=?";
	//pstmt = con.createStatement();
	pstmt1 = con.prepareStatement(sql_factors_for_bean);
	pstmt1.setString(1,term_set_id);
	pstmt1.setString(2,term_code);
	pstmt1.setString(3,locale);
	rs = pstmt1.executeQuery();
	if(rs!=null)
	{
		while(rs.next())
		{
			arr_factor = new ArrayList();
			arr_factor.add(rs.getString("factor_code"));
			arr_factor.add(rs.getString("defn_characteristic_yn"));
			arr_factor.add(rs.getString("related_factor_yn"));
			arr_factor.add(rs.getString("risk_factor_yn"));
			arr_main.add(arr_factor);
			//FactorsForTermCodebn.putObject(arr_factor);
		}
		if(rs!=null) rs.close();
		if(pstmt1!=null) pstmt1.close();
	}
	
	
	String sql_factors = "select factor_code, long_desc factor_desc,	decode(defn_characteristic_yn,'Y','Defining Characteristics',		decode(related_factor_yn||risk_factor_yn,'YY','Related & Risk Factor','YN','Related Factor','NY','Risk Factor'))factor_type,defn_characteristic_yn,related_factor_yn,risk_factor_yn,'I' db_action from mr_factor where factor_code not in (select factor_code from mr_factor_for_term_code where term_set_id = '"+term_set_id+"' and term_code ='"+term_code+"') and eff_status = 'E' union all select a.factor_code, b.long_desc factor_desc, decode(b.defn_characteristic_yn,'Y','Defining Characteristic',		decode(b.related_factor_yn||b.risk_factor_yn,'YY','Related & Risk Factor','YN','Related Factor','NY','Risk Factor')) factor_type,b.defn_characteristic_yn,b.related_factor_yn,b.risk_factor_yn,'U' db_action  from mr_factor_for_term_code a, mr_factor_lang_vw b where a.term_set_id = '"+term_set_id+"' and a.term_code = '"+term_code+"' and b.factor_code=a.factor_code and b.language_id='"+locale+"' order by factor_desc";
	try
	{
		pstmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=pstmt.executeQuery(sql_factors);
		rs.last();
		maxRecord = rs.getRow();
		end=maxRecord;
		rs.beforeFirst();
	}
	catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);

	if(rs!=null)
	{
		while(rs.next() && j<=maxRecord)
		{
			chked_factor="";
			if ( j % 2 == 0 )
				className = "QRYEVEN" ;
			else
				className = "QRYODD" ;
			out.println("<tr>");
			out.println("<td class='"+className+"' align='left'>"+rs.getString(2)+"</td>");
			out.println("<td class='"+className+"' align='left'>"+rs.getString(3)+"</td>");
			//rec_index=-1;
			int iSize = arr_main.size();
			for(int l=0;l<iSize;l++)
		    {
				ArrayList fact_arr=new ArrayList();
				//fact_arr=(ArrayList)FactorsForTermCodebn.getObject(l);
				fact_arr = (ArrayList)arr_main.get(l);
				String fact_code = (String) fact_arr.get(0);
				if(fact_code.equals(rs.getString(1)))
				{
					chked_factor = "checked";
					factor_val = "U";
					//rec_index=l;
					break;
				}
				else
				{
					chked_factor = "";
					factor_val = "I";
				}
			}
/*			if(rec_index!=-1)
			if(chked_factor.equals("checked"))   	 
				//FactorsForTermCodebn.removeObject(rec_index);
				arr_main.remove(rec_index);
				*/

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(className));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(j));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(factor_val));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chked_factor));
            _bw.write(_wl_block22Bytes, _wl_block22);

			out.println("</tr>");
			out.println("<input type='hidden' name=factor_code"+j+" value='"+rs.getString(1)+"'>");
			out.println("<input type='hidden' name=defn_characteristic_yn"+j+" value='"+rs.getString(4)+"'>");
			out.println("<input type='hidden' name=related_factor_yn"+j+" value='"+rs.getString(5)+"'>");
			out.println("<input type='hidden' name=risk_factor_yn"+j+" value='"+rs.getString(6)+"'>");
			j++;
		}
		--j;
	}

            _bw.write(_wl_block23Bytes, _wl_block23);

}
catch(Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con);
	//session.setAttribute("FactorsForTermCodebn", FactorsForTermCodebn);
}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(start));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(end));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(j));
            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Factors.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.FactorTypes.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
