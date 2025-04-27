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
import eCommon.XSSRequestWrapper;

public final class __icdcodequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ICDCodeQueryResult.jsp", 1722255817921L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\n\n\n<script>\nasync function showModal(code_ind,diag_srl_no,eff_status)\n\t{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"350px\" ;\n\t\t\tvar dialogTop \t= \"110\";\n\t\t\tvar dialogWidth\t= \"700px\" ;\n\t\t\tvar dialogLeft=\"218\";\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar tit=\"\";\n\t\t\ttit=getLabel(\"Common.ICDCode.label\",\"Common\");\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status+\"; dialogLeft:\"+dialogLeft+\";dialogTop:\"+dialogTop;\n\t\t\tretVal = await window.showModalDialog(\"../../eMR/jsp/ModifyICDCodeMain.jsp?diag_srl_no=\"+diag_srl_no+\"&eff_status=\"+eff_status+\"&code_ind=\"+code_ind+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\t\t\tif(retVal == \'cancel\');\n\t\t\telse\t\t\t\n\t\t\tdocument.location.reload();\n\t}\n\n</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t\t<P>\n\t\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<br><br>\n\t\t\t</P>\n\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\t\tif(document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script>\n\t\t\tif(document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</table>\n<br><center>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n</center>\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><form name='icdcode' id='icdcode' method='post' target='f_query_mod' action='ICDCodeQueryResult.jsp'>");

String whereClause = request.getParameter("whereclause");
StringBuffer sql = new StringBuffer();
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String orderBy=request.getParameter("orderBy");
	if(orderBy == null) orderBy="";

if ( (whereClause == null || whereClause.equals(""))&& orderBy.equals("") )
	{
	sql= new StringBuffer();
	String record_type_desc=request.getParameter("record_type_desc");
	if(record_type_desc == null) record_type_desc = "";
	String diag_code=request.getParameter("diag_code");
	String short_desc=request.getParameter("title");
	String gender_spec_ind_desc=request.getParameter("gender_spec_ind_desc");
	String age_spec_ind_desc=request.getParameter("age_spec_ind_desc");
	String tab_list=request.getParameter("tab_list");
	String sensitive_yn=request.getParameter("sensitive_yn");
	String notifiable_yn=request.getParameter("notifiable_yn");
	String diag_code_scheme_desc=request.getParameter("diag_code_scheme_desc");
	String code_ind=request.getParameter("code_ind");
	String order_by = request.getParameter("order_by");

	if(order_by == null) order_by="";

	int andCheck = 0;

	if ( !(record_type_desc == null || record_type_desc.equals("") || record_type_desc.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(record_type) =  upper('"+record_type_desc+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(record_type) = upper('"+record_type_desc+"')");
			andCheck = 1;
		}
	}
	if ( !(diag_code == null || diag_code.equals("") || diag_code.equals("null")) )
	{
		
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(diag_code) like  upper('"+diag_code+"%')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(diag_code) like upper('"+diag_code+"%')");
			andCheck = 1;
		}
	}
	if ( !(short_desc == null || short_desc.equals("") || short_desc.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(short_desc) like  upper('"+short_desc+"%')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(short_desc) like upper('"+short_desc+"%')");
			andCheck = 1;
		}
	}
	if ( !(gender_spec_ind_desc == null || gender_spec_ind_desc.equals("") || gender_spec_ind_desc.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(gender_spec_ind) =  upper('"+gender_spec_ind_desc+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(gender_spec_ind) = upper('"+gender_spec_ind_desc+"')");
			andCheck = 1;
		}
	}
	if ( !(age_spec_ind_desc == null || age_spec_ind_desc.equals("") || age_spec_ind_desc.equals("null")) )
	{		
		if ( andCheck == 1 )
		{	sql.append(" and ");
			if (age_spec_ind_desc.equals("O"))
				sql.append("nvl(age_spec_ind,'X') not in ('N', 'P', 'M', 'A')");
			else
				sql.append("upper(age_spec_ind) =  upper('"+age_spec_ind_desc+"')");
		}
		else
		{
			if (age_spec_ind_desc.equals("O"))
				sql.append( "where nvl(age_spec_ind,'X') not in ('N', 'P', 'M', 'A')") ;
			else{
				sql = new StringBuffer();
				sql.append("where upper(age_spec_ind) = upper('"+age_spec_ind_desc+"')");
			}
			andCheck = 1;
		}
	}
	if ( !(tab_list == null || tab_list.equals("") || tab_list.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(tab_list) like upper('"+tab_list+"'%)");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(tab_list) like upper('"+tab_list+"'%)");
			andCheck = 1;
		}
	}
	if ( !(sensitive_yn == null || sensitive_yn.equals("") || sensitive_yn.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(nvl(sensitive_yn,'N') ) = upper('"+sensitive_yn+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(nvl(sensitive_yn,'N') )   = upper('"+sensitive_yn+"')");
			andCheck = 1;
		}
	}
	if ( !(notifiable_yn == null || notifiable_yn.equals("") || notifiable_yn.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(nvl(notifiable_yn,'N') ) = upper('"+notifiable_yn+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(nvl(notifiable_yn,'N') )  = upper('"+notifiable_yn+"')");
			andCheck = 1;
		}
	}

	if ( !(diag_code_scheme_desc == null || diag_code_scheme_desc.equals("") || diag_code_scheme_desc.equals("null")) )
	{
	/*
ICD[2] - pro - 4
ICD[1] - pro - 1

ICD[2] - diag - 2
ICD[1] - diag - 1
		*/
		if ( andCheck == 1 )
		{	
			if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("1"))
				sql.append( " and diag_code_scheme = '1' ");
			//else if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("2"))
				//sql.append( " and diag_code_scheme = '4' ");
			else if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("2"))
				sql.append( " and diag_code_scheme = '2' ");
			else if(record_type_desc.equals("O") && diag_code_scheme_desc.equals("1"))
				sql.append( " and diag_code_scheme = '1' ");
			else if(record_type_desc.equals("O") && diag_code_scheme_desc.equals("2"))
				sql.append( " and diag_code_scheme = '4' ");
			else if(diag_code_scheme_desc.equals("2"))
				sql.append( " and diag_code_scheme in ('2','4')");
			else
				sql.append( " and upper(diag_code_scheme) = upper('"+diag_code_scheme_desc+"')");
		}
		else
		{
			sql = new StringBuffer();
			if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("1"))
				sql.append( " where diag_code_scheme = '1' ");
			//else if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("2"))
				//sql.append( " where diag_code_scheme = '4' ");
			else if(record_type_desc.equals("D") && diag_code_scheme_desc.equals("2"))
				sql.append( " where diag_code_scheme = '2' ");
			else if(record_type_desc.equals("O") && diag_code_scheme_desc.equals("1"))
				sql.append( " where diag_code_scheme = '1' ");
			else if(record_type_desc.equals("O") && diag_code_scheme_desc.equals("2"))
				sql.append( " where diag_code_scheme = '4' ");
			else if(diag_code_scheme_desc.equals("2"))
				sql.append( " where diag_code_scheme in ('2','4')");
			else
				sql.append(" where upper(diag_code_scheme) = upper('"+diag_code_scheme_desc+"')");
			andCheck = 1;
		}
	}

	if ( !(code_ind == null || code_ind.equals("") || code_ind.equals("null")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(CODE_INDICATOR) = upper('"+code_ind+"')");
		}
		else
		{
			sql = new StringBuffer();
			sql.append("where upper(CODE_INDICATOR) = upper('"+code_ind+"')");
			andCheck = 1;
		}
	}

		orderBy=" order by " + order_by;

} //end of where clause IF
else {
sql = new StringBuffer();
	sql.append(whereClause);
}

int start = 0 ;
int end = 0 ;
int i=1;

if ( from == null )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null )
	end = 6 ;
else
	end = Integer.parseInt( to ) ;


		Connection dbconn =null;

		Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;

try
{
	dbconn=ConnectionManager.getConnection(request);
	/*stmt = dbconn.createStatement();
	String strsql1="select count(1) as total from mr_icd_code "+sql.toString()+" "+orderBy;
	rs = stmt.executeQuery(strsql1);
	rs.next();
	maxRecord = rs.getInt("total");

	if(rs!=null)
		rs.close();
	if(stmt!=null)
		stmt.close();

	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'</script>");*/

	String strsql2="select diag_srl_no, DECODE(RECORD_TYPE,'D','Disease','O','Procedure',null) record_type_desc, "+
	" diag_code,short_desc,"+
	" decode(GENDER_SPEC_IND,'M','Male','F','Female','Common') gender_spec_ind_desc, decode(AGE_SPEC_IND ,'C','Common','N','Newborn','P','Pediatric','A','Adult','M','Maternity','Others') age_spec_ind_desc, "+
	" sensitive_yn,notifiable_yn,"+
	" decode(diag_code_scheme ,'1','ICD10','2','ICD9-CM','3','CPT4','4','ICD9-CM') diag_code_scheme_desc, "+
	" decode(CODE_INDICATOR ,'D','Dagger','E','External Cause','A','Asterik','C','Consequence') code_indicator, "+ 
	" CODE_INDICATOR code_ind, "+
	" eff_status from mr_icd_code "+ sql.toString()+" "+orderBy;

	//out.println(strsql2);

	stmt = dbconn.createStatement();
	rs = stmt.executeQuery(strsql2);

	if (start != 1)
	for( int j=1; j<start; i++,j++ ) 
	{
		rs.next() ;
	}

	while (i<=end && rs.next() )
	{
		if (maxRecord==0)
		{	
            _bw.write(_wl_block7Bytes, _wl_block7);

			if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/ICDCodeQueryResult.jsp?from="+(start-6)+"&to="+(end-6)+"&whereclause="+URLEncoder.encode(sql.toString())+"&orderBy="+URLEncoder.encode(orderBy)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			//if ( !( (start+6) > maxRecord ) )
				out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ICDCodeQueryResult.jsp?from="+(start+6)+"&to="+(end+6)+"&whereclause="+URLEncoder.encode(sql.toString())+"&orderBy="+URLEncoder.encode(orderBy)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
			
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
		/*if ( start != 1 )
		for( int j=1; j<start; i++,j++ ) {
		rs.next() ;
		}*/
		String classValue="";
		//while ( rs.next() && i<=end )
		//{
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		String d_diag_srl_no=rs.getString("diag_srl_no");
		String d_record_type_desc=rs.getString("record_type_desc");
		String d_diag_code=rs.getString("diag_code");
		String d_short_desc=rs.getString("short_desc");
		String d_gender_spec_ind_desc=rs.getString("gender_spec_ind_desc");
		String d_age_spec_ind_desc=rs.getString("age_spec_ind_desc");
		String d_sensitive_yn=rs.getString("sensitive_yn");
		String d_notifiable_yn=rs.getString("notifiable_yn");
		String d_diag_code_scheme_desc=rs.getString("diag_code_scheme_desc");
		String d_code_ind=rs.getString("code_indicator");
		String d_codeind=rs.getString("code_ind");
		String eff_status=rs.getString("eff_status");

		if (d_diag_srl_no == null || d_diag_srl_no.equals("null")) d_diag_srl_no="&nbsp;";
		if (d_record_type_desc == null || d_record_type_desc.equals("null")) d_record_type_desc="&nbsp;";
		if (d_diag_code == null || d_diag_code.equals("null")) d_diag_code="&nbsp;";
		if (d_code_ind == null || d_code_ind.equals("null")) d_code_ind="&nbsp;";
		if (d_short_desc == null || d_short_desc.equals("null")) d_short_desc="&nbsp;";
		if (d_gender_spec_ind_desc == null || d_gender_spec_ind_desc.equals("null")) d_gender_spec_ind_desc="&nbsp;";
		if (d_age_spec_ind_desc == null || d_age_spec_ind_desc.equals("null")) d_age_spec_ind_desc="&nbsp;";
		if (d_sensitive_yn == null || d_sensitive_yn.equals("null")) d_sensitive_yn="&nbsp;";
		if (d_notifiable_yn == null || d_notifiable_yn.equals("null"))
		d_notifiable_yn="&nbsp;";
		if (eff_status == null || eff_status.equals("null")) eff_status="&nbsp;";
		if (d_diag_code_scheme_desc == null || d_diag_code_scheme_desc.equals("null")) d_diag_code_scheme_desc="&nbsp;";

		out.println("<tr><td class='" + classValue + "'>");
		out.println("<a href=javascript:showModal('"+d_codeind+"','"+d_diag_srl_no+"','"+eff_status+"') </a>");
		out.println(d_diag_code+"</a></td><td class='" + classValue + "'>");
		out.println(d_short_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_diag_code_scheme_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_record_type_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_gender_spec_ind_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_age_spec_ind_desc);
		out.println("</td><td class='" + classValue + "'>");
		out.println(d_code_ind);
		out.println("</td><td class='" + classValue + "' align='center' >");

		if (d_sensitive_yn.equals("Y"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

		out.println("&nbsp;");
		out.println("</td><td class='" + classValue + "' align='center' >");

		if (d_notifiable_yn.equals("Y"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	
		out.println("&nbsp;");
		//out.println("</td></tr>");
		out.println("</td><td  class='" + classValue + "' align='center' >");

		i++;
		maxRecord++;
	}//endwhile

	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}

	if(maxRecord < 6 || (!rs.next()))
	{	
            _bw.write(_wl_block11Bytes, _wl_block11);
 	}
	else
	{	
            _bw.write(_wl_block12Bytes, _wl_block12);
	}	
            _bw.write(_wl_block13Bytes, _wl_block13);

	java.util.Enumeration eHISEnum = request.getParameterNames() ;
	while(eHISEnum.hasMoreElements())
	{
		 String name = (String)eHISEnum.nextElement() ;
		out.println("<input type='hidden' name=\""+request.getParameter(name)+"\" id=\""+request.getParameter(name)+"\">") ;
	}
}catch(Exception ce)
{
	//out.print("Exception @ "+ce.toString());
	ce.printStackTrace();
}
finally
{
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
ConnectionManager.returnConnection(dbconn,request);
}


            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TITLE.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.ICDCodeType.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenderSpecificInd.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AgeSpecificIndicator.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CodeIndicator.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sensitive.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Notifiable.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
