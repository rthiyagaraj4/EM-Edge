package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import java.net.URLEncoder;
import java.util.*;
import com.ehis.util.*;

public final class __addresslookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/AddressLookupResult.jsp", 1742369813413L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/AddressLookup.js\'></Script>\n\t</head>\n\t<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t\t\t<P>\n\t\t\t\t<table align=\'right\'>\n\t\t\t\t<tr>\n\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t\t<BR><BR>\n\t\t\t\t</P>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\t\n\t\t\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\n\t\t\t\t<th>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\n\t\t\t\t<th>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<script>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\tReturnValues(\'1\');\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\tReturnValues(\'1\');\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</script>\n</td></tr>\n</table>\n<br><center>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n</center>\n</body>\n</html>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

/*String res_town_prompt=request.getParameter("res_town_prompt");
String res_area_prompt=request.getParameter("res_area_prompt");
String region_prompt=request.getParameter("region_prompt");
String postal_code_prompt=request.getParameter("postal_code_prompt");*/

String search_text=request.getParameter("search_text");
String searchcriteria=request.getParameter("search_criteria");
String search_by=request.getParameter("search_by");

if(search_text==null)
search_text="";

//search_text = java.net.URLDecoder.decode(search_text,"UTF-8");

int index= search_text.indexOf("'");
if(index != -1)
{
search_text = search_text.replace("'","''");
}


String fieldname=request.getParameter("fieldname");

String a_area_code="";
String a_area_desc="";
String a_postal_code="";
String a_postal_desc="";
String a_region_code="";
String a_region_desc="";
String a_town_code="";
String a_town_desc="";
String res_area_appl_yn ="";
String res_town_appl_yn ="";
String region_appl_yn ="";
String postal_code_appl_yn ="";
String res_area_prompt ="";
String res_town_prompt ="";
String postal_code_prompt ="";
String region_prompt ="";
String a_country_code="";
String a_country_desc="";
if(fieldname==null)
fieldname="";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String whereClause	= "";
	whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");

	StringBuffer sbQuery = new StringBuffer();

	//if((whereClause == null || whereClause.equals(""))) {		

		if(search_by.equals("T") && !search_text.equals(""))
		{
			 if(fieldname.equals("town_code"))
			 {
				if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
			 }
			 else
			 {
				 if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(d.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(d.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(d.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}

			}
		}
		else if(search_by.equals("P") && !search_text.equals(""))
		{
			if(fieldname.equals("town_code")) {
			if(searchcriteria.equals("S"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(d.short_desc) like '");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			else if(searchcriteria.equals("E"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(d.short_desc) like '%");
			sbQuery.append(search_text);
			sbQuery.append("'");
				
			}
			else if(searchcriteria.equals("C"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(d.short_desc) like '%");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
		 }
		 else
			{
				 if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.short_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.short_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.short_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}

			}
		}
		else if(search_by.equals("A") && !search_text.equals(""))
		{
			if(fieldname.equals("town_code") || fieldname.equals("postal_code")) 
			{
				if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(c.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(c.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(c.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
		   }
		   else if(fieldname.equals("area_code"))
           {
			   if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}

		   }
		}
		else if(search_by.equals("R") && !search_text.equals(""))
		{
			if(fieldname.equals("town_code") || fieldname.equals("postal_code")) 
			{
				if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(b.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(b.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(b.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
		   }
		   else if(fieldname.equals("area_code"))
           {
			   String sql_temp="and Upper(( CASE WHEN a.region_code IS not null THEN (SELECT long_desc FROM mp_region_lang_vw WHERE region_code = a.region_code AND language_id = a.language_id AND EFF_STATUS='E' ) END)) like '";
			   if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(sql_temp);
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(sql_temp +"%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(sql_temp+"%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}

		   }
		   else  if(fieldname.equals("region_code"))
			{
				if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
		   }
		}
		else if(search_by.equals("C") && !search_text.equals(""))
		{	
		String sql_temp1="and Upper(( CASE WHEN a.country_code IS not null THEN (SELECT long_name FROM mp_country_lang_vw WHERE country_code = a.country_code AND language_id = a.language_id AND EFF_STATUS='E' ) END)) like '";
			if(searchcriteria.equals("S"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(sql_temp1);
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			else if(searchcriteria.equals("E"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(sql_temp1);
			sbQuery.append("%");
			sbQuery.append(search_text);
			sbQuery.append("'");
				
			}
			else if(searchcriteria.equals("C"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(sql_temp1);
			sbQuery.append("%");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			
		}
		else if(search_by.equals("D") && !search_text.equals(""))
		{
			if(searchcriteria.equals("S"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(long_desc) like '");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			else if(searchcriteria.equals("E"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(long_desc) like '%");
			sbQuery.append(search_text);
			sbQuery.append("'");
				
			}
			else if(searchcriteria.equals("C"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(long_desc) like '%");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			
		}


		if(search_by.equals("P"))
		{
			sbQuery.append(" order by postal_desc");
		}
		else if(search_by.equals("D") || search_by.equals("R")) 
		{
			sbQuery.append(" order by region_desc");
		}
		else if(search_by.equals("A")) {
			sbQuery.append(" order by area_desc");
		}
		else if(search_by.equals("T")) {
			sbQuery.append(" order by town_desc");
		}
		else if(search_by.equals("C"))
		{
			//sbQuery.append(" order by region_code");
			sbQuery.append(" order by country_desc");
		}
/*	} 
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
	}
*/

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

	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	PreparedStatement stmt			= null;
	ResultSet rset				= null;

	String sql="SELECT initcap(res_area_prompt) res_area_prompt,initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt,res_area_appl_yn,res_town_appl_yn,region_appl_yn,postal_code_appl_yn from sm_site_param_LANG_VW where language_id='"+locale+"'";
	
	try{
		conn = ConnectionManager.getConnection(request);
	//	pstmt = conn.prepareStatement("SELECT a.region_code region_code , mp_get_desc.MP_REGION(a.region_code,'"+locale+"',1) region_desc , b.res_area_code area_code ,  mp_get_desc.MP_RES_AREA( b.res_area_code,'"+locale+"',1) area_desc , c.res_town_code town_code , mp_get_desc.MP_RES_TOWN( c.res_town_code,'"+locale+"',1) town_desc , d.postal_code postal_code , mp_get_desc.MP_POSTAL_CODE( d.postal_code,'"+locale+"',2) postal_desc  FROM mp_region a , mp_res_area b , mp_res_town c , mp_postal_code d  WHERE a.region_code = b.region_code (+)  AND b.res_area_code = c.res_area_code(+)  AND c.res_town_code = d.res_town_code(+) "+sbQuery.toString());


	stmt = conn.prepareStatement(sql.toString());
			rset = stmt.executeQuery();
			if(rset.next())
			{
				//out.println("res_area_prompt:"+rset.getString("res_area_prompt"));
				res_area_prompt=rset.getString("res_area_prompt");
				res_town_prompt=rset.getString("res_town_prompt");
				postal_code_prompt=rset.getString("postal_code_prompt");
				region_prompt=rset.getString("region_prompt");
				res_area_appl_yn=rset.getString("res_area_appl_yn");
				region_appl_yn=rset.getString("region_appl_yn");
				postal_code_appl_yn=rset.getString("postal_code_appl_yn");
				res_town_appl_yn=rset.getString("res_town_appl_yn");
			}
			if(res_area_appl_yn==null)
			res_area_appl_yn="N";

			if(region_appl_yn==null)
			region_appl_yn="N";

			if(postal_code_appl_yn==null)
			postal_code_appl_yn="N";

			if(res_town_appl_yn==null)
			res_town_appl_yn="N";

			if(res_area_prompt==null)
			res_area_prompt="";

			if(res_town_prompt==null)
			res_town_prompt="";

			if(postal_code_prompt==null)
			postal_code_prompt="";

			if(region_prompt==null)
			region_prompt="";

		//pstmt = conn.prepareStatement("SELECT a.region_code region_code , a.long_desc region_desc , b.res_area_code area_code, b.long_desc area_desc , c.res_town_code town_code, c.long_desc town_desc , d.postal_code postal_code, d.short_desc postal_desc FROM mp_region_lang_vw a , mp_res_area_lang_vw b , mp_res_town_lang_vw c , mp_postal_code_lang_vw d WHERE a.region_code = b.region_code (+) and a.language_id = b.language_id (+) AND b.res_area_code = c.res_area_code(+) and b.language_id = c.language_id (+) AND c.res_town_code = d.res_town_code(+) and c.language_id = d.language_id (+) and a.language_id = '"+locale+"'"+sbQuery.toString());
		if(fieldname.equals("postal_code"))
		{
			pstmt = conn.prepareStatement("select a.postal_code postal_code, a.short_desc postal_desc, d.res_town_code town_code, d.long_desc town_desc, d.res_area_code area_code, c.long_desc area_desc, c.region_code region_code, b.long_desc region_desc from mp_postal_code_lang_vw a, (select region_code, long_desc from mp_region_lang_vw where language_id = '"+localeName+"' and EFF_STATUS='E') b, (select res_area_code, long_desc, region_code from mp_res_area_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') c, (select res_town_code, long_desc, res_area_code from mp_res_town_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') d where a.res_town_code = d.res_town_code(+) and d.res_area_code = c.res_area_code(+) and c.region_code = b.region_code(+) and a.language_id(+) = '"+localeName+"'  and a.EFF_STATUS='E' "+sbQuery.toString());
		}
		else if(fieldname.equals("region_code")) 
		{
			//pstmt = conn.prepareStatement("Select region_code,long_Desc region_desc from Mp_region_lang_vw where language_id='"+locale+"' and eff_status='E' "+sbQuery.toString());
			pstmt = conn.prepareStatement("SELECT   a.region_code, a.long_desc region_desc,a.country_code country_code,      (CASE WHEN a.country_code IS NOT NULL THEN (SELECT long_name  FROM mp_country_lang_vw WHERE country_code = a.country_code  AND language_id = a.language_id    AND eff_status = 'E')  END) country_desc  FROM mp_region_lang_vw a  WHERE a.language_id = 'en' AND a.eff_status = 'E' "+sbQuery.toString());
		}
		else if(fieldname.equals("area_code")) {
			pstmt = conn.prepareStatement("SELECT a.res_area_code area_code, a.long_desc area_desc, a.region_code region_code, (case when a.region_code is not null then (select long_desc from mp_region_lang_vw where region_code = a.region_code and language_id = a.language_id and EFF_STATUS='E') end) region_desc FROM mp_res_area_lang_vw a WHERE 	a.language_id = '"+localeName+"'  and a.EFF_STATUS='E' "+sbQuery.toString());
		}
		else if(fieldname.equals("town_code")) {
			pstmt = conn.prepareStatement("select a.res_town_code town_code, a.long_desc town_desc, a.res_area_code area_code, c.long_desc area_desc, c.region_code region_code, b.long_desc region_desc, d.postal_code postal_code, d.short_desc postal_desc from mp_res_town_lang_vw a, (select region_code, long_desc from mp_region_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') b, (select res_area_code, long_desc, region_code from mp_res_area_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') c, (select postal_code, short_desc, res_town_code from mp_postal_code_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') d where a.res_area_code = c.res_area_code(+) and b.region_code(+) = c.region_code and a.res_town_code = d.res_town_code(+) and a.language_id = '"+localeName+"'  and a.EFF_STATUS='E' "+sbQuery.toString());
		}

		
		rs = pstmt.executeQuery();

            _bw.write(_wl_block9Bytes, _wl_block9);

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		String classValue = "" ;
//		String code="";
		int cnt=0;
		while (i<=end && rs.next()){

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			if(fieldname.equals("postal_code") || fieldname.equals("town_code"))
			{
				a_town_code = rs.getString("town_code");
				a_town_desc = rs.getString("town_desc");
				a_area_code = rs.getString("area_code");
				a_area_desc =  rs.getString("area_desc");
				a_region_code = rs.getString("region_code");
				a_region_desc = rs.getString("region_desc");
				a_postal_code = rs.getString("postal_code");
				a_postal_desc = rs.getString("postal_desc");
			}
			else if(fieldname.equals("region_code")) 
			{
				a_region_code = rs.getString("region_code");
				a_region_desc = rs.getString("region_desc");
				a_country_code = rs.getString("country_code");
				a_country_desc = rs.getString("country_desc");
			}
			else if(fieldname.equals("area_code")) {
				a_area_code = rs.getString("area_code");
				a_area_desc =  rs.getString("area_desc");
				a_region_code = rs.getString("region_code");
				a_region_desc = rs.getString("region_desc");
			}
					
			
			if(a_town_code == null)
				a_town_code="";
			if(a_town_desc == null)
				a_town_desc="";
			if(a_area_code == null)
				a_area_code="";
			if(a_area_desc == null)
				a_area_desc="";
			if(a_region_code == null)
				a_region_code="";
			if(a_region_desc == null)
				a_region_desc="";
			if(a_postal_code == null)
				a_postal_code="";
			if(a_postal_desc == null)
				a_postal_desc="";
			if(a_country_code == null)
				a_country_code="";
			if(a_country_desc == null)
				a_country_desc="";	

			if(cnt==0)
			{
            _bw.write(_wl_block10Bytes, _wl_block10);

						if ( !(start <= 1) )
							out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/AddressLookupResult.jsp?from="+(start-14)+"&to="+(end-14)+"&search_text="+java.net.URLEncoder.encode(search_text,"UTF-8")+"&search_criteria="+searchcriteria+"&search_by="+search_by+"&fieldname="+fieldname+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
				
            _bw.write(_wl_block11Bytes, _wl_block11);

					//	if ( !( (start+14) > maxRecord ) )
							out.println("<A HREF='../../eMP/jsp/AddressLookupResult.jsp?from="+(start+14)+"&to="+(end+14)+"&search_text="+java.net.URLEncoder.encode(search_text,"UTF-8")+"&search_criteria="+searchcriteria+"&search_by="+search_by+"&fieldname="+fieldname+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				
            _bw.write(_wl_block12Bytes, _wl_block12);
if(fieldname.equals("town_code")) {
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(res_town_prompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(res_area_appl_yn.equals("Y")){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(res_area_prompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
				if(region_appl_yn.equals("Y")){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
				if(postal_code_appl_yn.equals("Y")){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(postal_code_prompt));
            _bw.write(_wl_block17Bytes, _wl_block17);
 }
				}

				if(fieldname.equals("area_code")) {
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(res_area_prompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
 if(region_appl_yn.equals("Y")){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block19Bytes, _wl_block19);
 }
				}

				if(fieldname.equals("region_code")) {
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 
				}

				if(fieldname.equals("postal_code")) {
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(postal_code_prompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(res_town_appl_yn.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(res_town_prompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
}	if(res_area_appl_yn.equals("Y")){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(res_area_prompt));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
				if(region_appl_yn.equals("Y")){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block17Bytes, _wl_block17);
 }
				}
			}
			
			if(fieldname.equals("town_code")) {
				out.println("<tr>");

				out.println("<td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");
					
				if(a_town_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_town_desc );
				}
				out.println("</a><input type = 'hidden' name = 'code"+i+"' id = 'code"+i+"' value = \""+a_town_code+"\"><input type = 'hidden' name = 'desc"+i+"' id = 'desc"+i+"'  value = \""+a_town_desc+"\"></td>");

				if(res_area_appl_yn.equals("Y")){
				
				out.println("<td class='" + classValue + "'>");				
				if(a_area_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_area_desc );
				}
				out.println("</td>");
				}
				if(region_appl_yn.equals("Y")){

				out.println("<td class='" + classValue + "'>");
				if(a_region_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_region_desc );
				}				
				out.println("</td>");
				}
				
				if(postal_code_appl_yn.equals("Y")){
				out.println("<td class='" + classValue + "'>");
				if(a_postal_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_postal_desc );
				}
				}
			}
			else if(fieldname.equals("area_code")) {
				out.println("<tr>");

				out.println("<td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");	
				
				if(a_area_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_area_desc );
				}
				out.println("</a><input type = 'hidden' name = 'code"+i+"' id = 'code"+i+"' value = \""+a_area_code+"\"><input type = 'hidden' name = 'desc"+i+"' id = 'desc"+i+"' value = \""+a_area_desc+"\"></td>");

				if(region_appl_yn.equals("Y")){

				out.println("<td class='" + classValue + "'>");
				if(a_region_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_region_desc );
				}
				out.println("</td>");
				}

			}
			else if(fieldname.equals("region_code")) {
				out.println("<tr>");
				//out.println("<td class='" + classValue + "'>");
				//Added for incident[57733]
				out.println("<td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");
				if(a_region_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_region_desc );
				}
				//Added for incident[57733]
				//out.println("</td><td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");	
				
				out.println("</td><td class='" + classValue + "'>");
				
				if(a_country_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_country_desc );
				}
				out.println("</a><input type = 'hidden' name = 'code"+i+"' id = 'code"+i+"' value = \""+a_region_code+"\"><input type = 'hidden' name = 'desc"+i+"' id = 'desc"+i+"' value = \""+a_region_desc+"\"></td>");
				
			}
			else if(fieldname.equals("postal_code")) {
				out.println("<tr>");

				out.println("<td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");
				
				if(a_postal_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_postal_desc );
				}
				out.println("</a><input type = 'hidden' name = 'code"+i+"' id = 'code"+i+"' value = \""+a_postal_code+"\"><input type = 'hidden' name = 'desc"+i+"'  id= 'desc"+i+"' value = \""+a_postal_desc+"\"></td>");

				if(res_town_appl_yn.equals("Y")){
				out.println("<td class='" + classValue + "'>");
				if(a_town_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_town_desc );
				}
				out.println("</td>");
				}
				if(res_area_appl_yn.equals("Y")){
				
				out.println("<td class='" + classValue + "'>");
				if(a_area_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_area_desc );
				}
				out.println("</td>");
				}
				if(region_appl_yn.equals("Y")){
			
				out.println("<td class='" + classValue + "'>");
				if(a_region_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_region_desc );
				}
				
				}
				
			}
			i++;
			cnt++;
		} 
		
		if (cnt==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		boolean flag = false;
		if ( cnt < 14 || (!rs.next()) ) {
		
            _bw.write(_wl_block22Bytes, _wl_block22);
 flag = true;
				} else {
            _bw.write(_wl_block23Bytes, _wl_block23);
}
		
		
            _bw.write(_wl_block24Bytes, _wl_block24);
if(fieldname.equals("postal_code") && cnt==1 && start==1)
		{
            _bw.write(_wl_block25Bytes, _wl_block25);
}
		else if(fieldname.equals("region_code") && cnt==1 && start==1) 
		{
            _bw.write(_wl_block26Bytes, _wl_block26);
}
		else if(fieldname.equals("area_code") && cnt==1 && start==1) {
            _bw.write(_wl_block26Bytes, _wl_block26);
}
		else if(fieldname.equals("town_code") && cnt==1 && start==1) {
            _bw.write(_wl_block26Bytes, _wl_block26);
}
		
            _bw.write(_wl_block27Bytes, _wl_block27);

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		sbQuery.setLength(0);
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
	}finally{
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}



            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.country.label", java.lang.String .class,"key"));
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
}
