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
import oracle.jdbc.driver.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __termcodecustomresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TermCodeCustomResult.jsp", 1743671644663L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--  modified on 4th Oct 2002 by Dheeraj to change the query and also to incorporate the prev/next  -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script src=\'../js/rowcolor.js\' language=\'javascript\'></script>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\nfunction closew(Diagcode)\n  {\n\twindow.parent.parent.parent.returnValue=Diagcode;\n\twindow.parent.parent.parent.close();\n  }\n  //added by arvind krishnan on 25-07-04\nasync function showLongDescription(a)\n{\n\tvar dialogHeight= \"20vh\" ;\n    var dialogWidth = \"23vw\" ;\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\tawait window.showModalDialog(\"../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc=\"+a,\"\",features);\n}\n//addition by arvind ends  here\n</script>\n\n\n<body onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n<table width=\'100%\' border=\'1\' cellspacing=\'0\' cellpadding=\'2\' id=\'tb1\'>\n<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</table>\n</body>\n<SCRIPT LANGUAGE=\"JavaScript\">\nif(parent.searchframe != null)\n\tparent.searchframe.document.radio.Search.disabled = false;\n</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</html>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String Diag_code="";
		String age_spec_ind_val = "";
		String gender_spec_ind = "";
		String age_spec_ind = "";

/*String qrystring=request.getQueryString();
out.println(qrystring);
Enumeration enum = request.getParameterNames();
while(enum.hasMoreElements())
{
	String param_name = (String)enum.nextElement();
}*/
            _bw.write(_wl_block8Bytes, _wl_block8);


 Connection conn=null;
PreparedStatement stmt=null;
ResultSet rset=null;
PreparedStatement stmt_1=null;
ResultSet rs_1=null;


String Diag_desc="";
String diagcode=request.getParameter("p_diag_code")==null?"":request.getParameter("p_diag_code");
String diagdesc=request.getParameter("p_diag_scheme_desc")==null?"":request.getParameter("p_diag_scheme_desc");
String authorize=request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn");
String DiagGcode=request.getParameter("Diag_code")==null?"":request.getParameter("Diag_code");
String cause_indicator=request.getParameter("cause_indicator")==null?"":request.getParameter("cause_indicator");
//added by arvind on 27-7-2004
//String search_by = (request.getParameter("Search_By")==null?"":request.getParameter("Search_By"));
String search_by = request.getParameter("Search_By")==null?"":request.getParameter("Search_By");
String notifiable_yn = (request.getParameter("opt_notifiable")==null?"":request.getParameter("opt_notifiable"));
String search_criteria = (request.getParameter("Search_Criteria")==null?"":request.getParameter("Search_Criteria"));
String sensitive_yn = (request.getParameter("sensitive_yn")==null?"":request.getParameter("sensitive_yn"));
String search_text = (request.getParameter("Search_Text")==null?"":request.getParameter("Search_Text"));


String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
String p_code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");

String long_description="";
String searchcondition="";
String notifiable_value="";
String sensitive_value="";

search_text = search_text.toUpperCase();
//addition by arvind ends here
if(cause_indicator==null)
	cause_indicator="";
	searchcondition="";
//
if (!(search_by ==null || search_by.equals("")))
{
	if(search_by.equals("D"))
	           searchcondition = searchcondition+ " and  upper(diag_desc)  like ";

	else
		searchcondition = searchcondition + " and diag_code  like ";

	if  (search_criteria.equals("S"))

	searchcondition= searchcondition+"'"+search_text+"%'";

	else if  (search_criteria.equals("E"))

	searchcondition= searchcondition+"'%"+search_text+"'";

	else if  (search_criteria.equals("C"))
     {
	searchcondition= searchcondition+ "'%"+search_text+"%'";
	}
	if(sensitive_yn.equals("Y"))
	   searchcondition = searchcondition + " and  SENSITIVE_YN = 'Y' ";
	else if(sensitive_yn.equals("N"))
       searchcondition = searchcondition + " and nvl(SENSITIVE_YN, 'N') = 'N'";
	if (notifiable_yn.equals("Y"))
	   searchcondition = searchcondition + " and notifiable_yn = 'Y'";
	else if(notifiable_yn.equals("N"))
	    searchcondition = searchcondition + " and nvl(notifiable_yn, 'N') = 'N'";
}

//
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

	int start = 0 ;
    int end = 0 ;
    int i=1;
	int maxRecord=0;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

try
{
	conn = ConnectionManager.getConnection(request);
	if(!(sex.equals("") || dob.equals("")))
	{
		String sql_age_spec_ind = "select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER";
		stmt_1 = conn.prepareStatement(sql_age_spec_ind);
		stmt_1.setString(1,dob);
		stmt_1.setString(2,dob);
		stmt_1.setString(3,dob);
		rs_1 = stmt_1.executeQuery();
		if(rs_1.next())
			age_spec_ind_val = rs_1.getString(1);
	}
	if(rs_1 != null) rs_1.close();
	if(stmt_1 != null )stmt_1.close();
	StringBuffer sql1 = new StringBuffer("select count(*) from mr_diag_group_dtl_vw where diag_group_code=? AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|')) ");
	if(p_code_indicator.equals(""))
		sql1.append( "and ( code_indicator in ('C','D') OR code_indicator IS NULL ) ");
	/*else if(p_code_indicator.equals("C"))
		sql1.append("and code_indicator in ('E') ");
	else if(p_code_indicator.equals("D"))
		sql1.append("and code_indicator in ('A') ");
	*/
	else
	sql1.append(" and code_indicator = '"+p_code_indicator+"'");

	if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals("")))
			sql1.append(" and ( gender_spec_ind = ? OR gender_spec_ind IS NULL ) ");
	sql1.append(searchcondition);	

	StringBuffer sql = new StringBuffer("select diag_code || nvl2(cause_indicator,'/' || cause_indicator,null) diag_code , diag_desc, diag_long_desc, nvl(notifiable_yn,' ') notifiable_yn, nvl(sensitive_yn,' ')  sensitive_yn ,code_indicator, age_spec_ind, gender_spec_ind from mr_diag_group_dtl_vw  where diag_group_code=?  AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|')) ");
	
	if(p_code_indicator.equals(""))
		sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");
	/*
	else if(p_code_indicator.equals("C"))
		sql.append("and code_indicator = 'E' ");
	else if(p_code_indicator.equals("D"))
		sql.append("and code_indicator = 'A' ");
	*/
	else
			sql.append(" and code_indicator = '"+p_code_indicator+"'");

	if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals("")))
		sql.append(" and ( gender_spec_ind = ? OR gender_spec_ind IS NULL ) ");
	sql.append(searchcondition);	
   
	if(diagcode.equals("2"))
		sql.append(" AND RECORD_TYPE='D' ");

	sql.append("  order by diag_code");
    stmt=conn.prepareStatement(sql1.toString());
	stmt.setString(1,DiagGcode);
	stmt.setString(2,cause_indicator);

	if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals("")))
	{
		stmt.setString(3,sex);
	}
	rset=stmt.executeQuery();
    
	while(rset.next()){

		 maxRecord = rset.getInt(1);
	
	}
		if(maxRecord == 0 && !(sex.equals("") || dob.equals("")))
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
	
	if(rset != null) rset.close();
	if(stmt != null )stmt.close();

	stmt=conn.prepareStatement(sql.toString());
	stmt.setString(1,DiagGcode);
	stmt.setString(2,cause_indicator);		
	
	if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals("")))
	{
		stmt.setString(3,sex);
	}
	rset=stmt.executeQuery();

            _bw.write(_wl_block9Bytes, _wl_block9);

if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/TermCodeCustomResult.jsp?code_indicator="+p_code_indicator+"&from="+(start-14)+"&to="+(end-14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&Diag_code="+DiagGcode+"&cause_indicator="+cause_indicator+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eCA/jsp/TermCodeCustomResult.jsp?code_indicator="+p_code_indicator+"&from="+(start+14)+"&to="+(end+14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&Diag_code="+DiagGcode+"&cause_indicator=	"+cause_indicator+"'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String rowclass="";

	while (rset.next()&& i<=end ) 
	{
		if (i%2==0)
			 rowclass="QRYEVEN";
		else
			 rowclass="QRYODD";

		Diag_code=rset.getString("diag_code");
		Diag_desc=rset.getString("diag_desc");
		long_description = rset.getString("diag_long_desc");
	    long_description = java.net.URLEncoder.encode(long_description);
		notifiable_value = rset.getString("notifiable_yn");
		sensitive_value = rset.getString("sensitive_yn").trim();
		p_code_indicator = rset.getString("code_indicator")==null?"":rset.getString("code_indicator");
		gender_spec_ind = rset.getString("gender_spec_ind")==null?"":rset.getString("gender_spec_ind");
		age_spec_ind = rset.getString("age_spec_ind")==null?"":rset.getString("age_spec_ind");
		
		p_code_indicator = (p_code_indicator.equals("D")?"Dagger(+)":(p_code_indicator.equals("C")?"Consequence(C)":(p_code_indicator.equals("E")?"External Cause Indicator(E)":(p_code_indicator.equals("A")?"*":""))));

		out.println("<tr style='background-color:;' >");

		if ((age_spec_ind.equals(age_spec_ind_val)|| dob.equals("")||age_spec_ind.equals("")) &&        (gender_spec_ind.equals(sex) || gender_spec_ind.equals("")|| sex.equals("")))
			out.println("<td class='"+rowclass+"'><a href=javascript:closew('"+Diag_code+"')>" + Diag_code + "</a></td>");
		else
			out.println("<td title='This Diagnosis Code is not applicable for this patient...' class='"+rowclass+"'>" + Diag_code + "</td>");

		  out.println("<td  class='"+rowclass+"'>");
		  out.println(Diag_desc+"</td>");
		  if (!Diag_desc.equals(long_description))
			 out.println("<td class='"+rowclass+"' align=center><a href= javascript:showLongDescription(\"" + long_description + "\"); ><b>!</b></a></td>");
		  else
			  out.println("<td class="+rowclass+">&nbsp;</td>");
		  out.println("<td class='"+rowclass+"'>");
	/*	  if(notifiable_value.equals("Y"))
			  out.println("Yes");
		  else 
			  out.println("No");*/
//		out.println(notifiable_value);
	 out.println(notifiable_value.equals("Y")?"Yes":"No"+"</td>");
		  out.println("<td class='"+rowclass+"'>");
		  out.println(sensitive_value.equals("Y")?"Yes":(sensitive_value.equals("N")?"No":"&nbsp;")+"</td>");
		  out.println("<td class='"+rowclass+"' align = center>");
		  out.println(p_code_indicator+"</td>");

		  out.println("</tr>");
		i++;
	}
	if(rset != null) rset.close();
	if(stmt != null )stmt.close();

 }catch  (Exception e) {
	 //out.println(e);
	 e.printStackTrace();
 } finally {
	   if (rset!=null) rset.close();
	   if (stmt!=null) stmt.close();
	   ConnectionManager.returnConnection(conn,request);
 }


            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Notifiable.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sensitive.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CodeIndicator.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
