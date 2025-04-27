package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __patcatorgmbspdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatCatOrgMbspDtls.jsp", 1709118668496L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eMP/js/PatCatOrgMbsp.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n \n</script>\n</head>\n<BODY  class=\'CONTENT\' onLoad=\'\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t</tr>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\tparent.frames[1].location.href =\"../../eMP/jsp/PatCatOrgMbspQueryCriteria.jsp?param=query\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<P>\n\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</P>\n\t\t<br>\n\t\t<br>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
//String facilityId		= (String) session.getValue( "facility_id" ) ;

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

String param		= request.getParameter("param");

if(param.equals("CREATE"))
{
	String category		= request.getParameter("category");
	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;
	try
	{
		con =ConnectionManager.getConnection(request);
		StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from MP_PAT_CATEGORY_DERIV_RULE where PAT_CAT_CODE='"+category+"'");
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		stmt.close();
		rs.close();
		//out.println("<script>alert('here 222----"+maxRecord+"');</script>");

	if(maxRecord == 0)
		{
		//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA')+'"+maxRecord+"');history.go(-1);</script>");
		}
		else
		{
		StringBuffer strsql2 = new StringBuffer();
		//strsql2.append("SELECT a.MEMBERSHIP_TYPE, a.FAMILY_ORG_ID, a.FAMILY_ORG_SUB_ID,a.RELATIONSHIP_CODE ,DECODE (a.membership_type,'1', 'Organization Member','2', 'Related Member - Family', '3', 'Related Member - Non-Family','4', 'Non-Organization Member') membership,a.name_prefix, b.family_org_sub_name,c.short_desc relation_desc,d.FAMILY_ORG_NAME  FROM mp_pat_category_deriv_rule a, mp_family_org_sub b, mp_relationship c,MP_FAMILY_ORG d WHERE a.family_org_sub_id = b.family_org_sub_id   AND c.relationship_code = a.relationship_code  and d.FAMILY_ORG_ID=a.FAMILY_ORG_ID and  a.PAT_CAT_CODE='"+category+"'");

		strsql2.append("SELECT a.MEMBERSHIP_TYPE Membership_code, membership_type,a.name_prefix,a.relationship_code,( case when a.relationship_code != '*ALL' and a.relationship_code != '*NA' then (select short_desc from mp_relationship where relationship_code = a.relationship_code) when a.relationship_code = '*ALL' then 'ALL' when a.relationship_code = '*NA' then 'NA' end ) relation_desc, a.pat_cat_code, (select short_desc from mp_pat_category where pat_cat_code = a.pat_cat_code) pat_cat_desc, a.family_org_id, ( case when a.family_org_id != '*ALL' and a.family_org_id != '*NA' then (select family_org_name from mp_family_org where family_org_id = a.family_org_id) when a.family_org_id = '*ALL' then 'ALL' when a.family_org_id = '*NA' then 'NA' end ) family_org_desc, a.family_org_sub_id, ( case when a.family_org_sub_id = '*ALL'  then 'ALL' when a.family_org_sub_id = '*NA' then 'NA' when a.family_org_id != '*ALL' and a.family_org_sub_id != '*ALL' and a.family_org_id != '*NA' and a.family_org_sub_id != '*NA' then (select family_org_sub_name from mp_family_org_sub where family_org_id = a.family_org_id and family_org_sub_id = a.family_org_sub_id) end ) family_org_sub_desc FROM  mp_pat_category_deriv_rule a where a.PAT_CAT_CODE='"+category+"' order by membership_code");
		//strsql2.append(category);
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());


            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				String classValue = "" ;
				int i=1;
				String membership_type = "" ;
				String family_org_id = "" ;
				String family_org_sub_id = "" ;
				String name_prefix = "" ;
				String relationship_code = "" ;
				String membership_type_code = "" ;
				String family_org_id_code = "" ;
				String family_org_sub_id_code = "" ;
				String relationship_code1 = "" ;
				String mode = "update" ;

				while ( rs.next())
				{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
				//DECODE (membership_type, '1', 'Organization Member','2', 'Related Member - Family','3', 'Related Member - Non-Family','4', 'Non-Organization Member' )

						membership_type	  =rs.getString("MEMBERSHIP_TYPE");

						if(membership_type.equals("1"))
							membership_type="Organization Member";
						if(membership_type.equals("2"))
							membership_type="Related Member - Family";
						if(membership_type.equals("3"))
							membership_type="Related Member - Non-Family";
						if(membership_type.equals("4")) 
							membership_type="Non-Organization Member";

						family_org_id	  =rs.getString("FAMILY_ORG_DESC");
						family_org_sub_id =rs.getString("FAMILY_ORG_SUB_DESC");
						name_prefix		  =rs.getString("NAME_PREFIX");
						relationship_code =rs.getString("RELATION_DESC");

						membership_type_code	  =rs.getString("Membership_code");
						family_org_id_code	  =rs.getString("FAMILY_ORG_ID");
						family_org_sub_id_code =rs.getString("FAMILY_ORG_SUB_ID");
						relationship_code1 =rs.getString("RELATIONSHIP_CODE");

						out.println("<tr>");
						//out.println("<td class='" + classValue + "'><a  href=\"../jsp/AddModifyNursUnitPhysLocn.jsp?nursing_unit_code="+URLEncoder.encode(nursing_unit_code)+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc)+"&building_desc="+URLEncoder.encode(building_desc)+"&floor_desc="+URLEncoder.encode(floor_desc)+"&bldng_code="+URLEncoder.encode(building_code)+"&floor_code="+URLEncoder.encode(floor_code)+"\" target='f_query_add_mod' >");  
						//out.println(nursing_unit_code+"</a></td>");

						out.println("<td nowrap class='" + classValue + "'><a  href=\"../jsp/PatCatOrgMbspSub.jsp?membership_type_code="+URLEncoder.encode(membership_type_code)+"&family_org_id_code="+URLEncoder.encode(family_org_id_code)+"&family_org_sub_id_code="+URLEncoder.encode(family_org_sub_id_code)+"&relationship_code1="+URLEncoder.encode(relationship_code1)+"&name_prefix="+URLEncoder.encode(name_prefix)+"&mode="+URLEncoder.encode(mode)+"\" target='sub_frame' >");  
						
					out.println(membership_type+"</a></td>");

						

						out.print("<td class='" + classValue + "'>"+family_org_id+"</td>");

						out.print("<td class='" + classValue + "'>"+family_org_sub_id+"</td>");
						out.print("<td class='" + classValue + "'>"+name_prefix+"</td>");
						out.print("<td class='" + classValue + "'>"+relationship_code+"</td>");
						
						out.print("</tr>");
					i++;
				}

            _bw.write(_wl_block1Bytes, _wl_block1);

		}
}
catch(Exception e)
{
	out.print(e.toString());
}
finally   
{
	try{

		if(stmt!=null) 	stmt.close();
		if(rs!=null) 		rs.close();
	}
	catch(Exception e)
	{out.println("Exception in tryCatch : "+ e.toString());}
		ConnectionManager.returnConnection(con,request); ;
}
}
else
if(param.equals("QUERY"))
{

	StringBuffer sql	= new StringBuffer();

	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	String whereClause		= request.getParameter("whereclause");
	String category			= "";
	String membership		= "";
	String organization		= "";
	String sub_org			= "";
	String prefix			= "";
	String relationship		= "";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		 membership			= request.getParameter("membership");
		 category			= request.getParameter("category");
		 organization		= request.getParameter("organization");
		 sub_org			= request.getParameter("sub_org");
		 prefix				= request.getParameter("prefix");
		 relationship		= request.getParameter("relationship");

		int andCheck		= 0;

		if(category!=null && !category.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(PAT_CAT_CODE) like upper('"+category+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(PAT_CAT_CODE) like upper('"+category+"%')");
				andCheck = 1;
			}				
		}

		if(membership!=null && !membership.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(membership_type) like upper('"+membership+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(membership_type) like upper('"+membership+"%')");
				andCheck = 1;
			}				
		}

		if(organization!=null && !organization.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(family_org_id) like upper('"+organization+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(family_org_id) like upper('"+organization+"%')");
				andCheck = 1;
			}
		}

		if(sub_org!=null && !sub_org.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(family_org_sub_id) like upper('"+sub_org+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(family_org_sub_id) like upper('"+sub_org+"%')");
				andCheck = 1;
			}				
		}

		if(prefix!=null && !prefix.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(name_prefix)= upper(?)");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(name_prefix) = upper(?)");
				andCheck = 1;
			}				
		}

		if(relationship!=null && !relationship.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(relationship_code) like upper('"+relationship+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(relationship_code) like upper('"+relationship+"%')");
				andCheck = 1;
			}				
		}
	}
	else
	{
		sql.append(whereClause);
	}

	int start = 0 ;			
	int end = 0 ;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;


	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{
		con =ConnectionManager.getConnection(request);
		StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from MP_PAT_CATEGORY_DERIV_RULE ");
		strsql1.append(sql.toString());
		pstmt=con.prepareStatement(strsql1.toString());
        if(prefix!=null && !prefix.equals(""))
		{	
		  pstmt.setString(1,prefix);	
        }
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		pstmt.close();
		rs.close();

	if(maxRecord == 0)
		{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
		
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else
		{
		//out.println("<script>alert('inside else...');</script>");
		StringBuffer strsql2 = new StringBuffer();
		//strsql2.append("select DECODE (MEMBERSHIP_TYPE,'1', 'Organization Member','2', 'Related Member - Family','3', 'Related Member - Non-Family','4','Non-Organization Member') MEMBERSHIP_TYPE, FAMILY_ORG_ID, FAMILY_ORG_SUB_ID, NAME_PREFIX, RELATIONSHIP_CODE,PAT_CAT_CODE from MP_PAT_CATEGORY_DERIV_RULE ");
		//strsql2.append("select DECODE (MEMBERSHIP_TYPE,'1', 'Organization Member','2', 'Related Member - Family','3', 'Related Member - Non-Family','4','Non-Organization Member') MEMBERSHIP_TYPE,a.family_org_id,b.FAMILY_ORG_NAME, a.family_org_sub_id,c.FAMILY_ORG_SUB_NAME, name_prefix, d.relationship_code, d.SHORT_DESC relationship_desc, a.pat_cat_code,e.SHORT_DESC category_desc  FROM mp_pat_category_deriv_rule a,MP_FAMILY_ORG b,MP_FAMILY_ORG_SUB c,mp_relationship d,mp_pat_category e  where  a.family_org_id =  b.family_org_id and  a.family_org_sub_id = c.family_org_sub_id and  a.RELATIONSHIP_CODE=d.RELATIONSHIP_CODE and a.pat_cat_code = e.pat_cat_code ");

		//strsql2.append("SELECT DECODE (membership_type, '1', 'Organization Member','2', 'Related Member - Family','3', 'Related Member - Non-Family','4', 'Non-Organization Member' ) membership_type,a.name_prefix,a.relationship_code,( case when a.relationship_code != '*ALL' and a.relationship_code != '*NA' then (select short_desc from mp_relationship where relationship_code = a.relationship_code) when a.relationship_code = '*ALL' then 'ALL' when a.relationship_code = '*NA' then 'NA' end ) relation_desc, a.pat_cat_code, (select short_desc from mp_pat_category where pat_cat_code = a.pat_cat_code) pat_cat_desc, a.family_org_id, ( case when a.family_org_id != '*ALL' and a.family_org_id != '*NA' then (select family_org_name from mp_family_org where family_org_id = a.family_org_id) when a.family_org_id = '*ALL' then 'ALL' when a.family_org_id = '*NA' then 'NA' end ) family_org_desc, a.family_org_sub_id, ( case when a.family_org_sub_id = '*ALL'  then 'ALL' when a.family_org_sub_id = '*NA' then 'NA' when a.family_org_id != '*ALL' and a.family_org_sub_id != '*ALL' and a.family_org_id != '*NA' and a.family_org_sub_id != '*NA' then (select family_org_sub_name from mp_family_org_sub where family_org_id = a.family_org_id and family_org_sub_id = a.family_org_sub_id) end ) family_org_sub_desc FROM  mp_pat_category_deriv_rule a ");
		strsql2.append("SELECT membership_type,a.name_prefix,a.relationship_code,( case when a.relationship_code != '*ALL' and a.relationship_code != '*NA' then (select short_desc from mp_relationship where relationship_code = a.relationship_code) when a.relationship_code = '*ALL' then 'ALL' when a.relationship_code = '*NA' then 'NA' end ) relation_desc, a.pat_cat_code, (select short_desc from mp_pat_category where pat_cat_code = a.pat_cat_code) pat_cat_desc, a.family_org_id, ( case when a.family_org_id != '*ALL' and a.family_org_id != '*NA' then (select family_org_name from mp_family_org where family_org_id = a.family_org_id) when a.family_org_id = '*ALL' then 'ALL' when a.family_org_id = '*NA' then 'NA' end ) family_org_desc, a.family_org_sub_id, ( case when a.family_org_sub_id = '*ALL'  then 'ALL' when a.family_org_sub_id = '*NA' then 'NA' when a.family_org_id != '*ALL' and a.family_org_sub_id != '*ALL' and a.family_org_id != '*NA' and a.family_org_sub_id != '*NA' then (select family_org_sub_name from mp_family_org_sub where family_org_id = a.family_org_id and family_org_sub_id = a.family_org_sub_id) end ) family_org_sub_desc FROM  mp_pat_category_deriv_rule a ");

		strsql2.append(sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());

            _bw.write(_wl_block12Bytes, _wl_block12);

					if ( !(start <= 1) )
						out.println("<A HREF='../jsp/PatCatOrgMbspDtls.jsp?from="+(start-14)+"&to="+(end-14)+"&category="+URLEncoder.encode(category)+"&membership="+URLEncoder.encode(membership)+"&organization="+URLEncoder.encode(organization)+"&param="+URLEncoder.encode("QUERY")+"&sub_org="+URLEncoder.encode(sub_org)+"&prefix="+URLEncoder.encode(prefix)+"&relationship="+URLEncoder.encode(relationship)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( !( (start+14) > maxRecord ) )
						out.println("<A HREF='../jsp/PatCatOrgMbspDtls.jsp?from="+(start+14)+"&to="+(end+14)+"&category="+URLEncoder.encode(category)+"&membership="+URLEncoder.encode(membership)+"&organization="+URLEncoder.encode(organization)+"&param="+URLEncoder.encode("QUERY")+"&sub_org="+URLEncoder.encode(sub_org)+"&prefix="+URLEncoder.encode(prefix)+"&relationship="+URLEncoder.encode(relationship)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				String classValue = "" ;
				int i=1;
				String category_desc = "" ;
				String membership_type = "" ;
				String family_org_id = "" ;
				String family_org_sub_id = "" ;
				String name_prefix = "" ;
				String relationship_code = "" ;

				while ( rs.next())
				{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						membership_type	  = rs.getString("MEMBERSHIP_TYPE");

						
						if(membership_type.equals("1"))
							membership_type="Organization Member";
						if(membership_type.equals("2"))
							membership_type="Related Member - Family";
						if(membership_type.equals("3"))
							membership_type="Related Member - Non-Family";
						if(membership_type.equals("4")) 
							membership_type="Non-Organization Member";

						category_desc	  = rs.getString("PAT_CAT_DESC");

						family_org_id	  = rs.getString("FAMILY_ORG_DESC");
						if(family_org_id.equals("*ALL")) family_org_id = "ALL";
						if(family_org_id.equals("*NA"))  family_org_id = "NA";

						family_org_sub_id = rs.getString("FAMILY_ORG_SUB_DESC");
						if(family_org_sub_id.equals("*ALL")) family_org_sub_id = "ALL";
						if(family_org_sub_id.equals("*NA")) family_org_sub_id = "NA";

						name_prefix		  = rs.getString("NAME_PREFIX");
						if(name_prefix.equals("*ALL")) name_prefix = "ALL";

						relationship_code = rs.getString("RELATION_DESC");

						out.println("<tr>");
						out.print("<td class='" + classValue + "'>"+category_desc+"</td>");
						out.print("<td class='"+classValue+ "'>"+membership_type+"</td>");
						out.print("<td class='" + classValue + "'>"+family_org_id+"</td>");
					out.print("<td class='"+classValue+"'>"+family_org_sub_id+"</td>");
						out.print("<td class='" + classValue + "'>"+name_prefix+"</td>");
					out.print("<td class='"+classValue+ "'>"+relationship_code+"</td>");
						out.print("</tr>");
					i++;				}
		}
}
catch(Exception e)
{
	out.print(e.toString());
}
finally   
{
	try{

		if(stmt!=null) 	stmt.close();
		if(rs!=null) 		rs.close();
	}
	catch(Exception e)
	{out.println("Exception in tryCatch : "+ e.toString());}
		ConnectionManager.returnConnection(con,request); ;
}
}

            _bw.write(_wl_block15Bytes, _wl_block15);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.membership.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Organization.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SubUnit.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NamePrefix.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.membership.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Organization.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.suborgn.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.prefix.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
