package jsp_servlet._emr._jsp;

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

public final class __recdiagnosisevidencedtladdmodify1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisEvidenceDtlAddModify1.jsp", 1709119020755L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisGetValidation.jsp", 1730014091638L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/CAStyle.css\"></link>\n<script src=\'../../eMR/js/RecDiagnosisMain.js\' language=\'javascript\'></script>\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<form name=\'recDiagnosisEvidenceForm\' id=\'recDiagnosisEvidenceForm\' >\n\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\'  align=center>\n\t<TH>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TH>\t\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</form>\n</table>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));

	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	request.setCharacterEncoding("UTF-8");
	Connection con						= null;
	PreparedStatement pstmtSql = null;
	ResultSet rset						= null;

	String definecode="",definedesc="",checked="";
	int ilRow = 0;
	int ilCount = 0;
	int srl_num	=0;
	String slClassValue = "",flag_yn="";
	String as_evidenced_by_defn =checkForNull(request.getParameter("as_evidenced_by_defn"));
	String Patient_Id			=checkForNull(request.getParameter("Patient_Id"));
	String term_set_id			=checkForNull(request.getParameter("term_set_id"));
	String term_code			=checkForNull(request.getParameter("term_code"));
	String occur_srl_no_hid=checkForNull(request.getParameter("occur_srl_no_hid")); 
	
	//StringTokenizer st_as_evidenced_by_defn = new StringTokenizer(as_evidenced_by_defn, "#");
	

	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

con = ConnectionManager.getConnection(request);
StringBuffer sqlQuery = new StringBuffer();
try
{
	if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
	sqlQuery.append("select max(STATUS_SRL_NO) srl_num from PR_DIAGNOSIS_EVIDENCE ");
	sqlQuery.append("where patient_id=? and term_set_id=? and term_code=? and occur_srl_no=?");
	pstmtSql = con.prepareStatement(sqlQuery.toString());
	pstmtSql.setString(1,Patient_Id);
	pstmtSql.setString(2,term_set_id);
	pstmtSql.setString(3,term_code);
	pstmtSql.setString(4,occur_srl_no_hid);
	rset= pstmtSql.executeQuery();
		
		if(rset.next())
			srl_num=rset.getInt("srl_num");
			
	if(rset != null) rset.close();
	if(pstmtSql != null) pstmtSql.close();

	if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
	sqlQuery.append("select decode(a.FACTOR_CODE,'','N','Y') flag_YN,b.FACTOR_CODE,b.SHORT_DESC	");
	sqlQuery.append("from PR_DIAGNOSIS_EVIDENCE a,mr_factor_lang_vw b where ");
	sqlQuery.append(" b.factor_code =a.FACTOR_CODE(+) and a.PATIENT_ID(+) =? ");
	sqlQuery.append(" and a.term_set_id(+) =? and a.term_code(+) =? and a.OCCUR_SRL_NO(+) =?");
	sqlQuery.append(" and b.DEFN_CHARACTERISTIC_YN='Y' and  ");
	sqlQuery.append(" b.EFF_STATUS='E' and a.status_srl_no(+)=? and b.language_id=? and (exists (select 1 from mr_factor_for_term_code where TERM_SET_ID=? and TERM_CODE=? and FACTOR_CODE=b.FACTOR_CODE ) or NOT EXISTS (SELECT 1 FROM MR_FACTOR_FOR_TERM_CODE WHERE TERM_SET_ID=? AND TERM_CODE =?)) order by 2,3");
	pstmtSql = con.prepareStatement(sqlQuery.toString());
	pstmtSql.setString(1,Patient_Id);
	pstmtSql.setString(2,term_set_id);
	pstmtSql.setString(3,term_code);
	pstmtSql.setString(4,occur_srl_no_hid);
	pstmtSql.setInt(5,srl_num);
	pstmtSql.setString(6,locale);
	pstmtSql.setString(7,term_set_id);
	pstmtSql.setString(8,term_code);
	pstmtSql.setString(9,term_set_id);
	pstmtSql.setString(10,term_code);
	rset= pstmtSql.executeQuery();
	int flag = 0;
	while(rset.next())
	{
		flag = 1;
		definecode	= rset.getString("FACTOR_CODE");
		definedesc	= rset.getString("SHORT_DESC");
		flag_yn		= rset.getString("FLAG_YN");
		if(flag_yn.equals("Y"))
		{
			checked="checked";
		}
		else
		{
			checked="";
		}
		
		StringTokenizer st_as_evidenced_by_defn = new StringTokenizer(as_evidenced_by_defn, "#");
		
		while(st_as_evidenced_by_defn.hasMoreTokens())
		{
			String define_code = (String) st_as_evidenced_by_defn.nextToken();
			StringTokenizer define_code1 = new StringTokenizer(define_code,"~");
			while(define_code1.hasMoreTokens())
			{
				String code = (String) define_code1.nextToken();	
				if(definecode.equals(code))
				{
				checked = "checked";
							//out.println("<script>alert('define_code"+define_code+"')</script>");
				}
			}
		}
	out.println("<tr>");
	slClassValue= ((ilCount % 2) == 0) ? "QRYEVEN" : "QRYODD";
	out.println("<td class='"+slClassValue+"'><input type='checkbox' name= 'evidence"+ilRow+"' value='"+definecode+"'  "+ checked+ " onclick='checkforOK(this)' > &nbsp;&nbsp;"+definedesc+"</td>");
	ilCount++;
	ilRow++;	
	out.println("</tr>");
	}

	if(flag == 0)
	{
		//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
		out.println("<script>parent.rec_evidence_cols.cols='*,0%';</script>");
	}

		out.println("<input type='hidden' name='ilRow' id='ilRow' value='"+ilRow+"'>");
		out.println("<input type='hidden' name='define_factor_type' id='define_factor_type' value='DC'>");
		out.println("<input type='hidden' name='flag' id='flag' value='"+flag+"'>");

}
catch(Exception e)
{
	//out.println("Exception in RecDiagnosisEvidenceDtlAddModify1.jsp :"+e.toString());
	e.printStackTrace();
}
finally
{
	if(rset!=null) rset.close();
	if(pstmtSql!=null) pstmtSql.close();
	if(con != null)ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DefiningCharacteristics.label", java.lang.String .class,"key"));
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
}
