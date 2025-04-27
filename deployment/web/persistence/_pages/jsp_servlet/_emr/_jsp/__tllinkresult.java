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
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __tllinkresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TlLinkResult.jsp", 1742366668530L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/ValidateControl.js\" Language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMR/js/TLReportSetup.js\' language=\'javascript\'></script>\n</head>\n<body OnMouseDown=\"CodeArrest()\">\n<form name=\"ssorderresult\" id=\"ssorderresult\" action=\"../../servlet/eMR.OrderCatalogForReportServlet\" method=\'post\' target=\"messageFrame\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n \n <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n  \n <tr>\n\t<th align=\"left\" width=\'10%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\t\n    <th align=\"left\" width=\'50%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t<th align=\"left\" width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\t\t\n\t<th align=\"left\" width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n  </tr>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="    \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"count1\" id=\"count1\" value=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t\t\t\t\t   \n\t\t\t\t\t   \n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </td>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tab_list";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"tab_list";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"tab_list_no";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"tab_list_no";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' align=center>\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"text";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"text";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" size=\'6\' maxLength=\'6\' onBlur=\"chkSerialno(this);\" onkeypress=\"return allowPositiveNumber()\"  value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" maxLength=\'4\' onBlur=\"chkvalidnum(this);\"></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" size=\'6\' maxLength=\'4\' onBlur=\"chkSerialno(this);\" onkeypress=\"return allowPositiveNumber()\"  value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' align=center>\n\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"text";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" size=\'6\'  maxLength=\'6\' onBlur=\"chkSerialno(this);\" onkeypress=\"return allowPositiveNumber()\" value=\"\" onBlur=\"chkdup(this); chkvalidnum(this);\"></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" size=\'6\'  maxLength=\'4\' onBlur=\"chkSerialno(this);\" onkeypress=\"return allowPositiveNumber()\" value=\"\" onBlur=\"chkdup(this); chkvalidnum(this);\"></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" size=\'6\'  maxLength=\'4\' onBlur=\"chkSerialno(this);\" onkeypress=\"return allowPositiveNumber()\" value=\"\" onBlur=\"chkdup(this); chkvalidnum(this);\"></td>\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' align=\'center\'><input type=\'checkbox\' name=\'inc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'inc";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' onClick=\'funchk(this)\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' checked onClick=\'funchk(this)\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\t<!--\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t\tparent.parent.f_query_add_mod.f_query_add_mod_result.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t//-->\n\t\t\t\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t</table>\n\t\t\t\t <input type =\'hidden\' name =\'alphabet\' value =\'\'>\n\t\t\t\t <input type =\'hidden\' name =\'report_id\' value =\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'group_code\' value =\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'sub_group_code\' value =\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'maxrecord\' value =\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'maxrecord1\' value =\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'concat\' value =\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'mast_table_name_reference\' value =\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'function_name1\' value =\'\'>\n\t\t\t\t <input type =\'hidden\' name =\'level_code\' value =\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t \n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rset			= null;
	ResultSet	rset2			= null;
	ResultSet	rset3			= null;
	StringBuffer sb=null;
	

	String classValue			= "";
	String ord_cat				= "";
	String chkd					= "";
	String tab_list_no			= "";
	String report_id			= "";
	String group_code			= "";
	String sub_group_code		= "";
	String level_code3			= "";
	String type					= "";
	StringBuffer concat		= new StringBuffer("");
	String code_from			= "";
	String code_to				= "";
	String code_desc			= "";
	String group_type			= "";
   
	int		maxrecord			= 0;
	float   count_float			= 0;
	int		count				= 0;
	
	try
	{
		type						= checkForNull(request.getParameter("alphabet"));
		report_id					= checkForNull(request.getParameter("report_id"));
		group_code					= checkForNull(request.getParameter("group_code"));

		code_from					= checkForNull(request.getParameter("code_from"));
		code_to						= checkForNull(request.getParameter("code_to"));
		code_desc					= checkForNull(request.getParameter("code_desc"));
		
		StringTokenizer sp=new StringTokenizer(code_from,"|");
		if(sp.hasMoreTokens())
		{
		 code_from=sp.nextToken();
		 if(sp.hasMoreTokens())
		 {
			  code_to=sp.nextToken();
		 }
		}
		
        
		sub_group_code				= checkForNull(request.getParameter("sub_group_code"));
		level_code3				    = checkForNull(request.getParameter("level_code3"));
		type						= type.trim();
		report_id					= report_id.trim();
		group_code					= group_code.trim();
		sub_group_code				= sub_group_code.trim();
		con				            = ConnectionManager.getConnection(request);
		stmt			            = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
   
   
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
 
	
	  int p=0;
	  sb = new StringBuffer();
	  //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
	  if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
		{  //Modified for this CRF PER-RH-0206
            sb.append("SELECT tab_list_no, long_desc, 0 cnt, 'N' chkd FROM mr_tab_list WHERE eff_status = 'E' ");
			if(!code_from.equals("") && !code_to.equals(""))
            {
				sb.append(" and upper(tab_list_no) between upper('"+code_from+"') and upper('"+code_to+"') and ");
				p=1;
				
			}
			else if(code_from.equals("") && !code_to.equals(""))
            {
               sb.append(" and upper(tab_list_no) like upper('"+code_to+"%') and ");
			   p=1;
			
			}
			else if(!code_from.equals("") && code_to.equals(""))
            {
				sb.append(" and upper(tab_list_no) like upper('"+code_from+"%') and ");
				p=1;
			
			}
			if(!code_desc.equals(""))
			{
				 if(p==0)
				 sb.append(" and ");
				 sb.append("  upper(LONG_DESC) like upper('"+code_desc+"%') and ");
				 p=1;
			   
		    }
            if(p==0)
				sb.append(" and ");
            sb.append(" tab_list_no not in (select mast_code FROM mr_report_mapping where ");
			sb.append(" report_id ='"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null) and (sub_group_code = '"+sub_group_code+"' or  sub_group_code is not null ) and (level3_code ='"+level_code3+"' or level3_code is not null) and mast_table_name_reference ='TL') union ");
			sb.append("select a.mast_code tab_list_no, b.long_desc long_desc, a.order_by_srl_no cnt, 'Y' chkd from mr_report_mapping a, mr_tab_list b where a.mast_code = b.tab_list_no and ");
			if(!code_from.equals("") && !code_to.equals(""))
            {
				sb.append(" upper(a.mast_code) between upper('"+code_from+"') and upper( '"+code_to+"') and ");
			}
			else if(code_from.equals("") && !code_to.equals(""))
            {
               sb.append(" upper(a.mast_code) like upper('"+code_to+"%') and ");
			}
			else if(!code_from.equals("") && code_to.equals(""))
            {
				sb.append(" upper(a.mast_code) like upper('"+code_from+"%') and ");
			}
			if(!code_desc.equals(""))
			{
				
				sb.append(" upper(b.LONG_DESC) like upper('"+code_desc+"%') and ");
			
			   
		    }
			sb.append("a.report_id ='"+report_id+"' and a.group_code ='"+group_code+"' and a.sub_group_code = '"+sub_group_code+"' and a.level3_code ='"+level_code3+"'  and a.mast_table_name_reference ='TL'");
		}

         		
		//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
		else if(report_id.equals("MROPCSMS") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS")) 
		{
			sb.append("SELECT tab_list_no, long_desc, 0 cnt, 'N' chkd FROM mr_tab_list WHERE eff_status = 'E' ");
			
			if(!(code_from.equals("")) && !(code_to.equals("")))
            {
				sb.append(" and upper(tab_list_no)  between upper('"+code_from+"') and upper('"+code_to+"') and ");
			
				p=1;
				
			}
			else if(code_from.equals("") && (!code_to.equals("")))
            {
               sb.append(" and  upper(tab_list_no) like upper('"+code_to+"%') and ");
			   
			   p=1;
			
			}
			else if((!code_from.equals("")) && code_to.equals(""))
            {
				sb.append(" and upper(tab_list_no) like upper('"+code_from+"%')  and ");
				p=1;
				
			
			}
			if((!code_desc.equals("")))
			{
				 if(p==0)
				 sb.append(" and ");
				 sb.append("upper(LONG_DESC) like upper('"+code_desc+"%') and ");
				 p=1;
			
			   
		    }
            if(p==0)
			sb.append(" and ");
			sb.append(" tab_list_no not in (select mast_code FROM mr_report_mapping where ");
			sb.append(" report_id ='"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null) and mast_table_name_reference ='TL') union ");
			sb.append("select a.mast_code tab_list_no, b.long_desc long_desc, a.order_by_srl_no cnt, 'Y' chkd from mr_report_mapping a, mr_tab_list b where a.mast_code = b.tab_list_no and ");
			if((!code_from.equals("")) && (!code_to.equals("")))
            {
				sb.append(" upper(a.mast_code) between upper('"+code_from+"') and  upper('"+code_to+"') and ");
			}
			else if(code_from.equals("") && (!code_to.equals("")))
            {
               sb.append(" upper(a.mast_code) like upper('"+code_to+"%') and ");
			}
			else if((!code_from.equals("")) && code_to.equals(""))
            {
				sb.append(" upper(a.mast_code) like upper('"+code_from+"%') and ");
			}
			if((!code_desc.equals("")))
			{
			   sb.append(" upper(b.LONG_DESC) like upper('"+code_desc+"%') and ");
			}
			sb.append("a.report_id ='"+report_id+"' and a.group_code ='"+group_code+"'  and a.mast_table_name_reference ='TL'");
		}
		else if ( report_id.equals("MRBPD207")	&& type.equals("BC") )
		{ 
			
			 sb.append("select '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, serv_classification_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd from bl_Serv_classification where serv_classification_code not in (select mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND (group_code = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"' )) union select a.report_id, a.mast_table_name_reference, a.mast_code, (select short_desc from bl_serv_classification where serv_classification_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'");
		}
		else
		{

          if(type.equals("BT"))
		  {
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,BED_TYPE_CODE mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM ip_bed_type WHERE BED_TYPE_CODE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) and (sub_group_code = '"+sub_group_code+"' or sub_group_code is not null ))UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from ip_bed_type where BED_TYPE_CODE = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'" );
		  }
		  else if(type.equals("BD"))
		  {
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,BED_CLASS_CODE mast_code, short_desc, 0 cnt,  NULL report_desc, NULL group_code, 'N' chkd FROM ip_bed_class WHERE BED_CLASS_CODE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"') UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from ip_bed_class where BED_CLASS_CODE = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'" );
		  }
		  else if((type.equals("SP") && report_id.equals("MRIPCSBD")) || (type.equals("SP") && report_id.equals("MRIPCSOBD")))
		  {  //Below line modified for this CRF PER-PD-209A
			  
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,speciality_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_speciality WHERE speciality_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) and (sub_group_code = '"+sub_group_code+"' or sub_group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_speciality where speciality_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'");
		  }
		  else if(type.equals("SP"))
		  {
			
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,speciality_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_speciality WHERE speciality_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_speciality where speciality_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
		  }
		  else if(type.equals("RC"))
		  { 
			   
				  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,race_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM mp_race WHERE race_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from mp_race where race_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
	      }
		  else if(type.equals("DT"))
		  {
			  
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,nod_type mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM mp_nod_type WHERE nod_type NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from mp_nod_type where nod_type = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
		  }
		  else if(type.equals("HC"))
		  {
			   
			 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,hcare_setting_type_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_hcare_setting_type WHERE hcare_setting_type_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_hcare_setting_type where hcare_setting_type_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
		  }
		  else if(type.equals("BC"))
	     {
			   
			   sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,hcare_setting_type_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_hcare_setting_type WHERE hcare_setting_type_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_hcare_setting_type where hcare_setting_type_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
			}
			else if(type.equals("NU"))
			{
				


			   sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, a.nursing_unit_code mast_code, a.short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM ip_nursing_unit a, ae_param b where a.facility_id = b.operating_facility_id  and a.nursing_unit_code = b.nursing_unit_code and a.appl_patient_class = 'IP' and a.eff_status = 'E' and (a.facility_id, a.nursing_unit_code) not in (select added_facility_id, mast_code from mr_report_mapping  WHERE report_id =  '"+report_id+"' AND  mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null)) union SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, speciality_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_speciality where eff_status = 'E' and speciality_code  not in ( select mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null)) union select a.report_id, a.mast_table_name_reference, a.mast_code, ( select short_desc from ip_nursing_unit where facility_id = a.added_facility_id and nursing_unit_code = a.mast_code UNION select short_desc from am_speciality where speciality_code = a.mast_code ) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
				
				/* sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, nursing_unit_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM ip_nursing_unit where appl_patient_class = 'IP' and (facility_id, nursing_unit_code) not in (select added_facility_id, mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null)) union SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, clinic_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM op_clinic where level_of_care_ind = 'E' and (facility_id, clinic_code) not in (select added_facility_id, mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null)) union select a.report_id, a.mast_table_name_reference, a.mast_code, (select short_desc from ip_nursing_unit where facility_id = a.added_facility_id and nursing_unit_code = a.mast_code UNION select CLINIC_CODE from op_clinic where level_of_care_ind='E' and facility_id = a.added_facility_id and clinic_code = a.mast_code) short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");   */
                

	 

             }
			else if(type.equals("CL"))
			{
				
			  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,clinic_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd from op_clinic where care_locn_type_ind = 'C' and (facility_id, clinic_code) not in (select added_facility_id, mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null) ) union select a.report_id,a.mast_table_name_reference, a.mast_code, (select short_desc from op_clinic where facility_id = a.added_facility_id and clinic_code = a.mast_code) short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and  a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
			   }
	else if(type.equals("HC") && report_id.equals("IPBMCREF"))
			{
		         
			   sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, hcare_setting_type_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_hcare_setting_type WHERE hcare_setting_type_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_hcare_setting_type where hcare_setting_type_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
          }
	else if(type.equals("CP"))
		{
		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, speciality_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd from am_speciality where eff_status = 'E' and  speciality_code not in (select mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null) ) union select  a.report_id,a.mast_table_name_reference, a.mast_code, (select short_desc from am_speciality where speciality_code = a.mast_code)short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"'  and a.group_code = '"+group_code+"'");
		   

		 /* sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, clinic_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd from op_clinic where care_locn_type_ind in ('C','E') and (facility_id, clinic_code) not in (select added_facility_id, mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null) ) union select a.report_id,a.mast_table_name_reference, a.mast_code, (select short_desc from op_clinic where clinic_code = a.mast_code)short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");  */
        }
		else if(type.equals("DP"))
		{
			
		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, DISP_TYPE mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM AM_DISPOSITION_TYPE WHERE  DISP_TYPE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from AM_DISPOSITION_TYPE where DISP_TYPE = a.mast_code ) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
        }
		else if(type.equals("NS"))
		{
			
			String sql12="select group_type from mr_report_grouping where group_code = '"+group_code+"'";
		 rset3=stmt.executeQuery(sql12);
		 while(rset3.next())
			 {
				group_type=rset3.getString("group_type");
			 }
			 if(rset3!=null) rset3.close();

		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, NAME_SUFFIX mast_code, NAME_SUFFIX short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM MP_NAME_SUFFIX WHERE NAME_SUFFIX NOT IN (SELECT a.mast_code FROM mr_report_mapping a,mr_report_grouping b WHERE a.report_id =  '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' AND a.group_code=b.group_code AND ( a.GROUP_CODE = '"+group_code+"' or a.group_code is not null) AND b.group_type='"+group_type+"')UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT NAME_SUFFIX short_desc from MP_NAME_SUFFIX where NAME_SUFFIX = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
        }
		/*Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340*/
		else if(type.equals("SC"))
		{
		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, clinic_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM op_clinic WHERE clinic_code NOT IN ( SELECT mast_code FROM mr_report_mapping WHERE report_id = '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND (group_code = '"+group_code+"' OR group_code IS NOT NULL)) AND specialist_clinic_yn != 'Y' AND care_locn_type_ind IN ('C', 'E') UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc FROM op_clinic WHERE clinic_code = a.mast_code AND specialist_clinic_yn != 'Y' AND care_locn_type_ind IN ('C', 'E')) short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' AND a.group_code = '"+group_code+"' AND mast_code IN ( SELECT clinic_code FROM op_clinic WHERE clinic_code = a.mast_code AND specialist_clinic_yn != 'Y' AND care_locn_type_ind IN ('C', 'E'))");
        }
		/*End ML-MMOH-CRF-1340*/
		/*Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341*/
		else if(type.equals("DA"))
		{
		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, position_code mast_code, position_desc short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_position WHERE position_code NOT IN ( SELECT mast_code FROM mr_report_mapping WHERE report_id = '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND (group_code = '"+group_code+"' OR group_code IS NOT NULL)) UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT position_desc short_desc FROM am_position WHERE position_code = a.mast_code) short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' AND a.group_code = '"+group_code+"'");
        }
		/*End ML-MMOH-CRF-1341*/
	}		int i=1;
			 String count_float_string="";
			// stmt			= con.createStatement();
		    if(report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS") || report_id.equals("MRIPCSMB") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCCSMB") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS"))
		    {   //below and above line also Modified for this CRF PER-RH-0206 
				String supsql="";
				//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
				if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
				  supsql="select order_by_srl_no from mr_report_mapping where report_id ='"+report_id+"' and group_code = '"+group_code+"' and sub_group_code ='"+sub_group_code+"' and level3_code ='"+level_code3+"'";
				//MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
				else if(report_id.equals("MROPCSMS") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS"))
					supsql="select order_by_srl_no from mr_report_mapping where report_id ='"+report_id+"' and group_code = '"+group_code+"'" ;
								 
                 rset2=stmt.executeQuery(supsql);
				 while(rset2.next())
				 {
					  String order_by_srl_no_new=rset2.getString("order_by_srl_no");
					  int index_known=order_by_srl_no_new.indexOf('.');
                      order_by_srl_no_new=order_by_srl_no_new.substring((index_known+1),(order_by_srl_no_new.length()));
					  concat.append(order_by_srl_no_new+"#");
					   
				 }
				 if(rset2!=null) rset2.close();

                  concat.append("1000#");
			}
			//out.println("SQL = "+sb.toString());	 
			rset	= stmt.executeQuery(sb.toString());
			
			if(rset!=null)
			 {
				rset.last();
				maxrecord = rset.getRow();
				rset.beforeFirst();
				while(rset.next())
				{   
				    //Below line Modified for this CRF PER-RH-0206
					if(report_id.equals("MRIPCSMB") || report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCCSMB") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS"))
					{	
						 tab_list_no		= rset.getString("tab_list_no");
						 ord_cat            = rset.getString("long_desc");
					}
				    count              = rset.getInt("cnt");
					chkd               = rset.getString("chkd");
					//Below line Modified for this CRF PER-RH-0206
					//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
					if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
					{	
						   count_float      = rset.getFloat("cnt");
						   int occ			= String.valueOf(count_float).indexOf('.');
						   String  number2	= String.valueOf(count_float).substring((occ+1),(String.valueOf(count_float).length()));
						   if(number2.length()<2)
							   count_float_string=String.valueOf(count_float)+"0";
						   else
							   count_float_string=String.valueOf(count_float);
					}
					else{
					  
					count              = rset.getInt("cnt");}
   										                   
					 if ( (i+1) % 2 == 0 )
						 classValue = "QRYEVEN" ;
					 else
						 classValue = "QRYODD" ;
						
			       
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(report_id.equals("MRIPCSMB") || report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCCSMB") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS"))
							{  //Above line Modified for this CRF PER-RH-0206 
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rset.getString("TAB_LIST_NO")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rset.getString("long_desc"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tab_list_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
						else { 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rset.getString("MAST_CODE")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rset.getString("short_desc"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(rset.getString("short_desc"))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rset.getString("mast_code")));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
 if(count > 0)
							{
            _bw.write(_wl_block26Bytes, _wl_block26);
 //Modified for this CRF PER-RH-0206 
								//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
 								if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB")){ 
								
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count_float_string));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
								else if(report_id.equals("MRIPCSBD") || report_id.equals("MRIPCSOBD"))
								{ //Modified for this CRF PER-PD-209A 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
								else
								{ 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
							 }
						 else 
						  { 
						    //Below line Modified for this CRF PER-RH-0206 
							//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
						     if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
								{
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
								else if(report_id.equals("MRIPCSBD") || report_id.equals("MRIPCSOBD"))
								{ //Modified for this CRF PER-PD-209A
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
								else
								{
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
						  }
						 if(chkd.equals("N"))
						 {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chkd));
            _bw.write(_wl_block42Bytes, _wl_block42);
} 
						else 
						{
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chkd));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
 i++;
				}
				 if(rset!=null) rset.close(); 
            _bw.write(_wl_block44Bytes, _wl_block44);
		
			}
			   if(maxrecord==0){
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(report_id ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sub_group_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(concat.toString()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(type));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(level_code3));
            _bw.write(_wl_block54Bytes, _wl_block54);
  if(stmt!=null) stmt.close();
   
   }
  catch(Exception e)
  {
	  //out.println("Exception in File TlLinkResult"+e.toString());
	  e.printStackTrace();
  }
 finally
 {
    ConnectionManager.returnConnection(con,request);
 }

 
            _bw.write(_wl_block55Bytes, _wl_block55);
            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderSrlNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
}
