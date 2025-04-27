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

public final class __ssordercataloglinkresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/SSOrderCatalogLinkResult.jsp", 1709119099504L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eMR/js/SSOrderCatalog.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\'>\n<form name=\"ssorderresult\" id=\"ssorderresult\" action=\"../../servlet/eMR.OrderCatalogForReportServlet\" method=\'post\' target=\"messageFrame\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n  <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\t\n\t<tr id=\'alpha\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<TD colspan=\'2\' >\n <a href=\"javascript:callMember(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a>&nbsp;&nbsp;\n\t\t\t\n  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t&nbsp;&nbsp;</td><td>\n <a href=\"javascript:callMember(\'Others\')\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>&nbsp;&nbsp;\n</TD>\n</TR>\n</table>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n   ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t    <th align=\"left\" width=15%>Diag Code</th>\n\t\t<th align=\"left\" width=70%>Description</th>\n\t\t\n\t\t<th width=15%>Select</th></tr>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t   <th align=\"left\" width=60%>Description</th>\n\t\t<th width=20%>Order Srl No</th>\n\t\t<th width=20%>Select</th></tr>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="    \n\t\t\t\t<tr>\n\t\t\t  <input type=\"hidden\" name=\"count1\" id=\"count1\" value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </td>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </td>\n\t\t\t   <input type=\"hidden\" name=\"ord_cat";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"ord_cat";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t   <input type=\"hidden\" name=\"order_catalog_code";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"order_catalog_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n                   \n\t\t\t\t   ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t       <td class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' align=center>\n\t\t\t       <INPUT TYPE=\"text\" name=\"text";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"text";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" size=\'3\' onkeypress=\"return allowPositiveNumber()\"  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" maxLength=\'3\' onBlur=\"chkdup(this)\"></td>\n\t\t\t  ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n                     ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t      <td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' align=center>\n\t\t\t      <INPUT TYPE=\"text\" name=\"text";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" size=\'3\'  maxLength=\'3\' onkeypress=\"return allowPositiveNumber()\" value=\"\" onBlur=\"chkdup(this)\"></td>\n\t\t     ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t <td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' align=\'center\'><input type=\'checkbox\' name=\'inc";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'inc";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onClick=\'funchk(this)\'></td>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n     \t\t\t <td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' checked onClick=\'funchk(this)\'></td>\n\t    \t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t</tr>\n\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t</table>\n\t\t\t\t <input type =\'hidden\' name =\'alphabet\' value =\'\'>\n\t\t\t\t <input type =\'hidden\' name =\'report_id\' value =\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'group_code\' value =\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'sub_group_code\' value =\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'maxrecord\' value =\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'maxrecord1\' value =\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'concat\' value =\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t\t <input type =\'hidden\' name =\'mast_table_name_reference\'  value =\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t \n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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
	
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rs				= null;
	ResultSet	rset			= null;
	//ResultSet	rset1			= null;
	ResultSet	rset2			= null;

	String selalpha				= "";
	String classValue			= "";
	//String str21				= "";
	String str22				= "";
	String ord_cat				= "";
	String chkd					= "";
	String order_catalog_code	= "";
	String diag_code	= "";
	String dbvalue				= "";
	String report_id			= "";
	String group_code			= "";
	String sub_group_code		= "";
	
	StringBuffer concat	  	= new StringBuffer("");
    String master= "";
	String alphadescription="";
     String searchby="";
	 String searchcrt="";
	int maxrecord =0;
	int count     =0;
	try
	{

	dbvalue						= checkForNull(request.getParameter("alphabet"));
	report_id					= checkForNull(request.getParameter("report_id"));
	group_code					= checkForNull(request.getParameter("group_code"));
	sub_group_code				= checkForNull(request.getParameter("sub_group_code"));
     
	searchby					= checkForNull(request.getParameter("searchby"));
	 searchcrt					= checkForNull(request.getParameter("searchcrt"));
	alphadescription				= checkForNull(request.getParameter("alphadescription"));
	master   = checkForNull(request.getParameter("reference"));
	//String sp_mast_table_name_reference   = checkForNull(request.getParameter("sp"));

    dbvalue						= dbvalue.trim();
	report_id					= report_id.trim();
	group_code					= group_code.trim();
	sub_group_code				= sub_group_code.trim();
	
	con				            = ConnectionManager.getConnection(request);
	stmt			            = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
   
    ArrayList hr				= new ArrayList();
	rs = stmt.executeQuery("select distinct upper(substr(short_desc,1,1))selaplha  from or_order_catalog where short_desc between 'A%' AND 'Z%' Order by selaplha");// Modified by Kamatchi S for ML-MMOH-SCF-2007
	while (rs.next())
	{
		selalpha = rs.getString("selaplha");
		hr.add(selalpha);
	}

    if(rs != null )rs.close();
		
 if(!alphadescription.equals("") && report_id.equals("MRIPCSMH") && master.equals("IC")) {} else {
            _bw.write(_wl_block8Bytes, _wl_block8);

	  Iterator e7 = hr.iterator();
	         
	  while(e7.hasNext())
	   {
		 String jj = (String)e7.next();
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(jj));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
  
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(report_id.equals("MRIPCSMH")){
            _bw.write(_wl_block15Bytes, _wl_block15);
}else {
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
 
			  if(dbvalue.equals("Others"))
			   {
					
					if(report_id.equals("MRBRADEX") || report_id.equals("MRBLABRG"))
					{
						str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'RD' and eff_status = 'E' and upper(substr(long_desc,1,1)) not between 'A' and 'Z' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )  and (sub_group_code = '"+sub_group_code+"' or sub_group_code is not null )) UNION select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"'  and a.sub_group_code ='"+sub_group_code+"'  and upper(substr(report_desc,1,1)) not between 'A' and 'Z' order by 2";
						
					}
					else if(report_id.equals("MRBLABWL"))
				    {
                         str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'LB' and eff_status = 'E' and upper(substr(long_desc,1,1)) not between 'A' and 'Z' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )) UNION select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and upper(substr(report_desc,1,1)) not between 'A' and 'Z' order by 2";
					}
					//Newly added by Shyam on 16/12/2005 for PD-205 and Master is IC
					/*else if(report_id.equals("MRIPCSMH"))
				     {
							
							str22="select diag_srl_no, short_desc, 'N' chkd from mr_icd_code where upper(substr(long_desc,1,1)) not between 'A' and 'Z' and to_char(diag_srl_no) not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"'  and (group_code ='"+group_code+"' or group_code is not null ))UNION select to_number(a.mast_code) diag_srl_no, b.short_desc,  'Y' chkd from mr_report_mapping a, mr_icd_code b where a.mast_code = b.diag_srl_no and a.report_id = '"+report_id+"' and a.group_code = '"+group_code+"' and upper(substr(report_desc,1,1)) not between 'A' and 'Z'  order by 2";
					 }*/
					 //end 
					 else
					 {
						 str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'TR' and eff_status = 'E' and upper(substr(long_desc,1,1)) not between 'A' and 'Z' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )) UNION select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and upper(substr(report_desc,1,1)) not between 'A' and 'Z' order by 2";
						
					}
					 
				 
			   }
			 else
				{
					 
					 if(report_id.equals("MRBRADEX") || report_id.equals("MRBLABRG"))
					 {
							 str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'RD' and eff_status = 'E' and UPPER (long_desc) LIKE '"+dbvalue+"%' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )  and (sub_group_code = '"+sub_group_code+"' or sub_group_code is not null )) UNION  select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"' and UPPER (b.long_desc) LIKE '"+dbvalue+"%' order by 2";
					 }
					 else if(report_id.equals("MRBLABWL"))
				     {
							 str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'LB' and eff_status = 'E' and UPPER (long_desc) LIKE '"+dbvalue+"%' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null)) UNION  select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and UPPER (b.long_desc) LIKE '"+dbvalue+"%' order by 2";
					 }
					 //Newly added for PD-205 BY SHYAM ON 15/12/2005
					 else if(report_id.equals("MRIPCSMH"))
				     {
							
							//str22="select diag_code,diag_srl_no, short_desc, 'N' chkd from mr_icd_code where ";  JIT 27/may/2016
							str22="select term_code diag_code, 1 diag_srl_no, short_desc, 'N' chkd from mr_term_code where ";
							if(searchby.equals("D"))
							{
								if(searchcrt.equals("C"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
							}
							else if(searchby.equals("C"))
							{
								/*if(searchcrt.equals("C"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '"+alphadescription+"%')";&*/ //  JIt 27-may -2016

								if(searchcrt.equals("C"))
								str22=str22+" UPPER (term_code) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (term_code) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (term_code) LIKE  upper( '"+alphadescription+"%')";
							}
							//str22=str22+" and to_char(diag_srl_no) not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"'  and (group_code ='"+group_code+"' or group_code is not null ))UNION select b.diag_code,to_number(a.mast_code) diag_srl_no, b.short_desc,  'Y' chkd from mr_report_mapping a, mr_icd_code b where a.mast_code = to_char(b.diag_srl_no) and a.report_id = '"+report_id+"' and a.group_code = '"+group_code+"' and "; JIT 27/may/2016
							str22=str22+" and term_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"'  and (group_code ='"+group_code+"' or group_code is not null ))UNION select b.term_code diag_code, 1 diag_srl_no ,b.short_desc,  'Y' chkd from mr_report_mapping a, mr_term_code b where a.mast_code = b.term_code and a.report_id = '"+report_id+"' and a.group_code = '"+group_code+"' and ";
							if(searchby.equals("D"))
							{
								if(searchcrt.equals("C"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
							}
							else if(searchby.equals("C"))
							{
								/*if(searchcrt.equals("C"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (diag_code) LIKE  upper( '"+alphadescription+"%')";*/// jit 27th mau 2016

								if(searchcrt.equals("C"))
								str22=str22+" UPPER (term_code) LIKE  upper( '%"+alphadescription+"%')";
								else if(searchcrt.equals("E"))
								str22=str22+" UPPER (term_code) LIKE  upper( '%"+alphadescription+"')";
								else if(searchcrt.equals("S"))
								str22=str22+" UPPER (term_code) LIKE  upper( '"+alphadescription+"%')";
							}
							if(searchby.equals("D"))
								str22=str22+" order by 2";
							else if(searchby.equals("C"))
								str22=str22+" order by 1";
							
					 }
					 ///END
					 else
						{
					
							str22="select order_catalog_code, long_desc, 0 count, 'N' chkd from or_order_catalog where order_category = 'TR' and eff_status = 'E' and UPPER (long_desc) LIKE '"+dbvalue+"%' and order_catalog_code not in (select mast_code from mr_report_mapping where report_id = '"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null )) UNION  select a.mast_code order_catalog_code, b.long_desc, a.order_by_srl_no count, 'Y' chkd from mr_report_mapping a, or_order_catalog b where a.mast_code = b.order_catalog_code and a.report_id ='"+report_id+"' and a.group_code = '"+group_code+"' and UPPER (b.long_desc) LIKE '"+dbvalue+"%' order by 2";
						}
				
				}
				
				int i=1;
				//stmt			= con.createStatement();
				 if(!report_id.equals("MRIPCSMH")){
				 String supsql="select order_by_srl_no from mr_report_mapping where report_id ='"+report_id+"' and group_code = '"+group_code+"' and sub_group_code ='"+sub_group_code+"'";
				 
                 rset2=stmt.executeQuery(supsql);
				 while(rset2.next())
				 {
					  concat.append(rset2.getString("order_by_srl_no")+"#");
					   
				 }
				 if(rset2!=null) rset2.close();

                  concat.append("1000#");
				 }
				  rset	= stmt.executeQuery(str22);
		  
                     
				 if(rset!=null)
				 {
					rset.last();
			        maxrecord = rset.getRow();
			        rset.beforeFirst();
					while(rset.next())
					{
						 if(report_id.equals("MRIPCSMH"))
						{
							// order_catalog_code = rset.getString("diag_srl_no");
							 order_catalog_code = rset.getString("diag_code");//Modified by Dharma
						     ord_cat            = rset.getString("short_desc");
							 diag_code          = rset.getString("diag_code");
						}
						else
						{
						 order_catalog_code = rset.getString("order_catalog_code");
						 ord_cat            = rset.getString("long_desc");
						 count              = rset.getInt("count");
						}
						 chkd               = rset.getString("chkd");
	                    
						
				if ( (i+1) % 2 == 0 )
						classValue = "QRYEVEN" ;
				else
						classValue = "QRYODD" ;
						
			
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
 if(report_id.equals("MRIPCSMH")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
			  if(count > 0)
			  { 
				   if(report_id.equals("MRIPCSMH")){
            _bw.write(_wl_block30Bytes, _wl_block30);
}else {
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(count));
            _bw.write(_wl_block35Bytes, _wl_block35);
}}else { 
				    if(report_id.equals("MRIPCSMH")){
            _bw.write(_wl_block36Bytes, _wl_block36);
}else {
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
}} 
			 if(chkd.equals("N")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chkd));
            _bw.write(_wl_block44Bytes, _wl_block44);
} 
			  else {
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chkd));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
 i++;
					}if(rset!=null) rset.close(); 
            _bw.write(_wl_block48Bytes, _wl_block48);
		
					

				
				}
				   
				if(maxrecord==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sub_group_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(concat.toString()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(master));
            _bw.write(_wl_block56Bytes, _wl_block56);
  if(stmt!=null) stmt.close();
   //if(rs!=null) rs.close();
   }
  catch(Exception e)
  {
	  //out.println("Exception in File SSOrderCatalogLinkResult"+e.toString());
	  e.printStackTrace();
  }
   finally
 {
    ConnectionManager.returnConnection(con,request);
 }

 
            _bw.write(_wl_block57Bytes, _wl_block57);
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
