package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eOT.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.OTBillingBean;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.net.URLEncoder;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.*;

public final class __otgeneralsearchresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTGeneralSearchResults.jsp", 1734010930000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="    \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="      \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n<head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<title> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n <base target=\"_self\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'/>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<script Language=\"JavaScript\">\n\tfunction funCurrencyFormat()\n\t{\n\t\ttry\n\t\t{\n\t\t\tvar ids = document.getElementById(\"currency_id\");\n\t\t\tif (ids.length ==\tnull)\n\t\t\t{\n\t\t\t\tcurrencyTableFormat(ids);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\n\t\t\t\tfor(i=0;i<ids.length;i++)\n\t\t\t\t{\n\t\t\t\t\tcurrencyTableFormat(ids[i]);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tcatch(e)\n\t\t{\n\t\t}\n\t}\n\tfunction submitFormN()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from + maxval;\n\t\tdocument.forms[0].to.value = to + maxval;\n\t\tdocument.forms[0].nextFlag.value = \'N\'; //046704\n\t\tdocument.forms[0].submit();\n\t}\n\tfunction submitFormP()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from - maxval;\n\t\tdocument.forms[0].to.value = to - maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\n\t\tfunction closew(index)\n\t\t{\n\t\t\tvar Dcode=eval(\"document.forms[0].hyper\"+index+\".value\");\n\t\t\t//parent.window.returnValue = Dcode;\n\t\t\t//parent.window.close();\t\n\t\t\t/*let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\tdialogBody.contentWindow.returnValue = Dcode;\n    \n\t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t\tdialogTag.close(); */\n\t\t\tconst diagElement = parent.parent.document.getElementsByTagName(\"dialog\");\n\t\t\tvar i = 0; var j = 0;\n\t\t\tfor (i = 0; i < diagElement.length; i++) {\n\t\t\t\tfor (j = 0; j < diagElement[i].children.length; j++) {\n\t\t\t\t\tvar element = diagElement[i].children[j];\n\t\t\t\t\tlet dialogSrc = element.src;\n\t\t\t\t\tif (typeof dialogSrc !== \"undefined\")\n\t\t\t\t\t{ \n\t\t\t\t\t\tif (dialogSrc.includes(\"OTGeneralSearchFrames.jsp\"))\n\t\t\t\t\t\t{\t  \n\t\t\t\t\t\t\telement.contentWindow.returnValue = Dcode;\n\t\t\t\t\t\t\tconst dialogTag = diagElement[i];    \n\t\t\t\t\t\t\tdialogTag.close();\n\t\t\t\t\t\t}\n\t\t\t\t\t}    \t\t\n\t\t\t\t} \n\t\t\t}\n\n\t\t}\n\n\t   function callNoRecords(){\n\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'common\');\n\t\talert(msg);\n\t   }\n </script>\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\n<form name=\'form_query\' id=\'form_query\' method=\'post\' action=\'OTGeneralSearchResults.jsp\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<table align=\'center\' width=\'100%\'>\n\t\t<tr>\n\t\t<td align=\'right\' nowrap>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\n\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\n\t\n\t\t\n\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=\'hidden\' name=\'search_by_index\' id=\'search_by_index\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\'hidden\' name=\'search_text\' id=\'search_text\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\'hidden\' name=\'column_names\' id=\'column_names\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\'hidden\' name=\'column_sizes\' id=\'column_sizes\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\'hidden\' name=\'column_types\' id=\'column_types\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\'hidden\' name=\'column_descriptions\' id=\'column_descriptions\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\'hidden\' name=\'sql_pass_back\' id=\'sql_pass_back\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\'hidden\' name=\'max_records\' id=\'max_records\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\'hidden\' name=\'sql_order_by\' id=\'sql_order_by\'  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\'hidden\' name=\'nextFlag\' id=\'nextFlag\'> <!-- 046704 -->\n\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<script Language=\'JavaScript\'> funCurrencyFormat(); </script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
 
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

 

int recSize=0;
int hits=0;
Cookie cookie1 = null;
Cookie cookie2 = null;
 String encode(String data)
 {	  
  String outDat = replace(data); 
	  byte byteData[] = outDat.getBytes();
		outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
 }


	String replace(String data)
	{
		char strRep = '`';
		String strSpecial = "\f\n\r\t\'\"\\";
		char charArray[] = strSpecial.toCharArray();
		String strOutData = data;
		for (int i =0;i<charArray.length;i++)
		{
			strOutData = strOutData.replace(charArray[i],strRep);
		}
		return(strOutData);
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	
	// this line is commented by marwan, since this wrapper is sanitizing the request parameters
	// in column_descriptions request parameter ir removes the script word from description, that's why i commented it
	// request= new XSSRequestWrapper(request);

	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( request.getParameter("title")));
            _bw.write(_wl_block9Bytes, _wl_block9);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String strColumnDelimiter = ",";
		String userWhereClause = "";
		String SQL = "";
		String sqlWithColumnsOnly = "";
		//String sqlActualWithColumnsOnly = "";
		String strWhereColumn = "";
		String strWhereColumnType = "";
		//String sqlFifteenRecords = "";
		//String sqlGroupBy = "";//commented  v3
		String sql_pass_back = "";
		String sql_order_by = "";
		String sql_proc=request.getParameter("sql");
//		String search_criteria_dir=request.getParameter("search_criteria");
		
		
		int ctr=0;
		int max_records = 14;		
		int intTotalColumns = 0;
		int intGroupIndex = 0;
		int intGroupByIndex = 0;

		int j = 0;
		int i = 0;
		ArrayList ArrayListColumnNames = new ArrayList();
		ArrayList ArrayListColumnSizes = new ArrayList();
		ArrayList ArrayListColumnDescriptions = new ArrayList();
		ArrayList ArrayListColumnTypes = new ArrayList();
		ArrayList ArrayListHtmlData = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
		String sql = "";
		//Added Against ML-MMOH-CRF-1939-US2...starts
		String facility_id		= (String)session.getValue("facility_id") ;
		String title2 = CommonBean.checkForNull(request.getParameter("title2"));
		String Fpp_yn = CommonBean.checkForNull(request.getParameter("Fpp_yn"));
		String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
		String tab_name = CommonBean.checkForNull(request.getParameter("tab_name"));
		String FPPPatient_yn = "";
		String Include_Fpp_yn = "";
		boolean isIncludeFpp = false;
		boolean bill_flag = false;
		Integer count =0;
		ArrayList fppList = new ArrayList();
		String fpp_order_yn = "N";
		String fpp_category = "";
		String oper_code = "";
		String bean_id = "OTCommonBean";
		String bean_name = "eOT.OTCommonBean";
		OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
		
		String ot_bean_id = "OTBillingBean";
		String ot_bean_name= "eOT.OTBillingBean";
		OTBillingBean billing_bean = (OTBillingBean)mh.getBeanObject( ot_bean_id, request,ot_bean_name  ) ;
		//Added Against ML-MMOH-CRF-1939-US2...ends
		try
		{	
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 14:Integer.parseInt(request.getParameter("max_records"));
			
			//Added Against ML-MMOH-CRF-1939-US2...starts
			
			Include_Fpp_yn = bean.getIncludeFpp(facility_id);
			System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
			isIncludeFpp = CommonBean.isSiteSpecific(conn,"OT","OT_FPP");
			System.err.println("isIncludeFpp --->"+isIncludeFpp);
			
			count = bean.getFppIcon();
			bill_flag = bean.getBillFlag(facility_id);

			//Added Against ML-MMOH-CRF-1939-US2...ends
			
			sql = request.getParameter("sql");
			sql = (sql == null) ? "":sql;
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			String nextFlag = request.getParameter("nextFlag") == null ? "" : request.getParameter("nextFlag");//046704
	
			boolean calling_from_main =  true;
			if ( (from == null) && ( to == null) )
			{
				calling_from_main = true;
			}
			else
			{
				calling_from_main = false;
			}
			from = (from == null) ? "0":from;
			to = (to == null) ? max_records+"":to;
			String search_criteria = request.getParameter("search_criteria");
			search_criteria = (search_criteria == null) ? "":search_criteria;
			String search_by_index = request.getParameter("search_by_index");
			search_by_index = (search_by_index == null) ? "0":search_by_index;
			int int_search_by_index = Integer.parseInt(	search_by_index);
			String search_text = request.getParameter("search_text");
			search_text = (search_text == null) ? "%":search_text;
			String search_by = 	request.getParameter("search_by");
			search_by = (search_by == null) ? "":search_by;
			String column_names = request.getParameter("column_names");
			column_names = (column_names == null) ? "":column_names;
			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null) ? "":column_sizes;
			String column_types = request.getParameter("column_types");
			column_types = (column_types == null) ? "":column_types;
			String column_descriptions = request.getParameter("column_descriptions");
			column_descriptions = (column_descriptions == null) ? "":column_descriptions;
			StringTokenizer strTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
			String addOprn = request.getParameter("addOprn");

			i =0;
			while(strTokenizer.hasMoreTokens())
			{
				ArrayListColumnNames.add( " "+strTokenizer.nextToken());
				++i;
			}
			intTotalColumns = i;
			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				ArrayListColumnSizes.add( strTokenizer.nextToken());
				++i;
			}

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_types,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				ArrayListColumnTypes.add( strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;

			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				ArrayListColumnDescriptions.add( strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;
			SQL = sql.toUpperCase();
			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";
			
			//sqlFifteenRecords = " and rownum between "+from+" and  " +to +"";

			if(calling_from_main == true)
			{
				sql = sql.replace('`','\'') ;

				intGroupIndex = SQL.lastIndexOf(" GROUP");
				
				//sqlGroupBy = " ";
				if (intGroupIndex > 0)
				{
					intGroupByIndex = SQL.indexOf(" BY",intGroupIndex);
					//debug("intGroupByIndex="+intGroupByIndex);
					if (intGroupByIndex >0)
					{
						//sqlGroupBy = sql.substring(intGroupIndex);
						//sql = sql.substring(0,intGroupIndex);
						
					}
				}
				//debug("sqlGroupBy="+sqlGroupBy);
				//debug("sql="+sql);
				j = SQL.lastIndexOf(" WHERE");
				//debug("SQL="+SQL);
		
				if(j <0)
				 sql= sql +" where (1=1) and ";
				if(j > 0)
				{		
					String sqlTemp = sql.substring(0,j+6);
					String sqlWhere = sql.substring(j+6);
					sqlWhere = " ( " + sqlWhere +" ) and ";
					sql = sqlTemp + sqlWhere;
				}
				i = 0;
				j = 0;
				i = SQL.indexOf("SELECT");
				j = SQL.lastIndexOf(" FROM");
				sqlWithColumnsOnly = SQL.substring(i+7,j);
				//sqlActualWithColumnsOnly = sql.substring(i+7,j);
				//debug("sqlWithColumnsOnly="+sqlWithColumnsOnly);
				//debug("int_search_by_index ="+int_search_by_index );
				if (int_search_by_index >0)
				{
					String strTempSelectedColumn = (String)ArrayListColumnNames.get(int_search_by_index);
					//debug("strTempSelectedColumn="+strTempSelectedColumn);
					String strTempPreviousColumn = (String)ArrayListColumnNames.get(int_search_by_index-1);
					//debug("strTempPreviousColumn ="+strTempPreviousColumn );
					int intTempSelectedIndex = sqlWithColumnsOnly.indexOf(strTempSelectedColumn);

					//debug("intTempSelectedIndex = "+intTempSelectedIndex);

					int intTempPreviousIndex = sqlWithColumnsOnly.indexOf(strTempPreviousColumn);
					//debug("intTempPreviousIndex = "+intTempPreviousIndex);
					int intCommaIndex = sqlWithColumnsOnly.indexOf(",",intTempPreviousIndex+1);
					//debug("intCommaIndex = "+intCommaIndex);

					strWhereColumn = sqlWithColumnsOnly.substring(intCommaIndex+1,intTempSelectedIndex);
					//debug("strWhereColumn = "+strWhereColumn);
					
					//hard coded for speciality
					if(addOprn != null && addOprn.equals("Y"))
					{
						strWhereColumn = "SPECIALITY_CODE";
					}
				}
				else
				{
					String strTempColumn = (String) ArrayListColumnNames.get(int_search_by_index);
					//debug("strTempColumn = "+strTempColumn);
					int intTempIndex = sqlWithColumnsOnly.indexOf(strTempColumn );
					//debug("intTempIndex = "+intTempIndex);
					strWhereColumn = sqlWithColumnsOnly.substring(0,intTempIndex);
					//debug("strWhereColumn = "+strWhereColumn);
				}
				strWhereColumn = strWhereColumn.trim();
				int intTempWhereColumnLen = strWhereColumn.length();
				String strTempSpace = " ";
				String strTempQuote = "'";
				String strTempComma =",";
				i = 0;
				i = strWhereColumn.lastIndexOf(strTempSpace);
				if ((i>0) && (int_search_by_index == 0))
				{
					j = 0;
					j = strWhereColumn.indexOf(strTempQuote);
					if (j<0)
					{
						j = strWhereColumn.indexOf(strTempComma);
						if (j<0)
						{
							strWhereColumn = strWhereColumn.substring(i,intTempWhereColumnLen);
						}
							
					}
					

				}
				strWhereColumnType = (String) ArrayListColumnTypes.get(int_search_by_index);
				//debug("strWhereColumnType = "+strWhereColumnType);
				if (strWhereColumnType.equalsIgnoreCase("VARCHAR2"))
				{
					if(search_criteria.equals("S"))
					{
						search_text = search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) ";
					}
					else if(search_criteria.equals("E"))
					{
						search_text = "%" + search_text;
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}
					else if(search_criteria.equals("C"))
					{
						search_text = "%" + search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}
				}else{

					userWhereClause = "( ceil( "+strWhereColumn+ ") like ceil(?)";
				}
				
				userWhereClause = userWhereClause + " ) ";
				//Added for CRF 012 
				if(addOprn != null && addOprn.equals("Y"))
				{
					String description = "";
					if(search_criteria.equals("S"))
					{
						description = request.getParameter("description") + "%";
					}
					else if(search_criteria.equals("E"))
					{
						description = "%" + request.getParameter("description");
					}
					else if(search_criteria.equals("C"))
					{
						description = "%" + request.getParameter("description") + "%";
					}
					
					userWhereClause += " AND ( upper(OPER.SHORT_DESC) like upper('" +  description + "') )";//Modified Against ML-MMOH-CRF-1939-US2
				}
				//Added for CRF 012 
				sql = sql + userWhereClause;
				sql_pass_back = sql;
				sql_order_by = " order by "+(int_search_by_index+1);
				for (int l = 1;l<=intTotalColumns ; l++ )
				{
					if (l != (int_search_by_index+1))
					{
						sql_order_by = sql_order_by +"," +l;
					}
				}
			
			}
			else
			{
				sql_pass_back = request.getParameter("sql_pass_back");
				sql_order_by = request.getParameter("sql_order_by");
				sql = sql_pass_back;
			}
			sql = sql+ " "+sql_order_by;

			//sqlFifteenRecords;
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			try
			{
				String row = "<tr style='background-color:;'>";
				String evn = "<td nowrap class='gridData'";
				String odd = "<td nowrap class='gridData'";
				String strStartLink = "<a href=javascript:closew('";
				String strEndLink = "')>";
				String strHtmlData = "";
				String strData = "";
				String strLinkData = "";
				//String strSpecialData = "";
				//String strNumberFormat = "";

				String strTempColumnType = "VARCHAR2";

				String strTempColumnName = "";
				String strIDCurrency = " id='currency_id' ";
				//String strSpecialIDCurrency = " id='currency_id' ";
				String strAlign = "align = 'right'";
				//String strSpecialAlign = "align = 'right'>";
				
				//int intArrayListTrace = 0;
				int intTempStart = start;
				//int intTempEnd = end;
				pstmt = conn.prepareStatement(sql);
				
				//Added Against ML-MMOH-CRF-1939-US2...starts
				if(isIncludeFpp && bill_flag && count==1 && Include_Fpp_yn.equals("Y") && title2.equals("Operation") && !tab_name.equals("UNSCHEDULED") && (called_from.equals("DIRECT_BOOKING") || called_from.equals("Record_Surgeon")) ){

				pstmt.setString( 1 , Fpp_yn );
				pstmt.setString(2,search_text);
				}else{
				//Added Against ML-MMOH-CRF-1939-US2...ends
				
				pstmt.setString(1,search_text);	
				
				}//Added Against ML-MMOH-CRF-1939-US2...
				rs = pstmt.executeQuery();
				
				ArrayListHtmlData.add("<table class='grid' border='1' width='100%' cellspacing='0' cellpadding='3' id='tb1'>");

				//strNumberFormat = "";
				for (int l = 0;l<intTotalColumns ; l++ )
				{
					strTempColumnType = (String) ArrayListColumnTypes.get(l);

					if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
					{
						strAlign = "align = 'left'";
					}
					else
					{
						strAlign = "align = 'right'";

					}
						ArrayListHtmlData.add("<th nowrap width='"+(String)ArrayListColumnSizes.get(l)+"'  "+ strAlign +"  >"+(String)ArrayListColumnDescriptions.get(l)+"</th>");
				}	
				while(rs.next())
				{
					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					ArrayListHtmlData.add(row);					
					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
						strData = checkForNull(rs.getString(intTrace));
						strLinkData = strLinkData +strData+ "::" ;
						strTempColumnType = (String) ArrayListColumnTypes.get(intTrace-1);
						strTempColumnName = (String) ArrayListColumnNames.get(intTrace-1);
						strTempColumnName = strTempColumnName.trim();
						if (strTempColumnName.indexOf("_$$")>0)
						{
							strIDCurrency = "  id='currency_id'  ";
						}
						else
						{
							strIDCurrency = "";
						}
						if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
						{
							strAlign = "align='left'>";
						}
						else
						{
							strAlign = "align='right'>";
						}


						if (intFetchedRecords%2 == 0)
						{	
							strHtmlData =""+ evn + strIDCurrency + strAlign +strStartLink+intFetchedRecords+strEndLink+strData+"</td>";
						}
						else
						{
							strHtmlData =""+odd + strIDCurrency + strAlign +strStartLink+intFetchedRecords+strEndLink+strData+"</td>";
						}						
						
							ArrayListHtmlData.add(strHtmlData);						

					}
					out.println("<input type='hidden' name='hyper"+intFetchedRecords+"' id='hyper"+intFetchedRecords+"' value=\""+strLinkData+"\">");
					strLinkData = "";
					ArrayListHtmlData.add("</tr>");
					if (intFetchedRecords >= max_records)
					{
						break;
					}
				}
				ArrayListHtmlData.add("</table>");
				//046704
//				if(intFetchedRecords==1)
//					out.println("assignCodeDesc(\"" + strLinkData + "\");") ;
			}
			catch(Exception expSQL)
			{
				expSQL.printStackTrace();
				//out.println("Error="+expSQL);
			}

			try{
				
				pstmt = conn.prepareStatement(sql);
				
				//Added Against ML-MMOH-CRF-1939-US2...starts
				if(isIncludeFpp && bill_flag && count==1 && Include_Fpp_yn.equals("Y") && title2.equals("Operation") && !tab_name.equals("UNSCHEDULED") && (called_from.equals("DIRECT_BOOKING") || called_from.equals("Record_Surgeon"))){
				pstmt.setString( 1 , Fpp_yn );
				pstmt.setString(2,search_text);
				}else{
				//Added Against ML-MMOH-CRF-1939-US2...ends
				
				pstmt.setString(1,search_text);	
				
				}//Added Against ML-MMOH-CRF-1939-US2
				rs = pstmt.executeQuery();
				while(rs.next()){
					ctr=ctr+1;
				}
			}
			catch(Exception expSQL)
			{
				expSQL.printStackTrace();
				//out.println("Error="+expSQL);
			}
			finally{
					ConnectionManager.returnConnection(conn, request);
									pstmt.close();
				}

		
            _bw.write(_wl_block13Bytes, _wl_block13);

		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		if (intFetchedRecords >= max_records)
		{	
		recSize=intFetchedRecords+recSize;
		String recs = Integer.toString(recSize);
		String hits1 = Integer.toString(hits);
			cookie1 = new Cookie("recSize", recs);
			cookie2 = new Cookie("hits", hits1);
			cookie1.setMaxAge(24 * 60 * 60);
			cookie2.setMaxAge(24 * 60 * 60);
			response.addCookie(cookie1); 
			response.addCookie(cookie2); 
			Cookie[] cookies = request.getCookies();
	 		for(int loopIndex = 0; loopIndex < cookies.length; loopIndex++) { 
				if (cookies[loopIndex].getName().equals("recSize")) {
					if(recs != "" || recs != null)
					recs = (String)cookies[loopIndex].getValue();
					recSize=Integer.parseInt(recs.trim());
					recSize=intFetchedRecords+recSize;
				break;
				}if (cookies[loopIndex].getName().equals("hits")) {
					hits1 = (String)cookies[loopIndex].getValue();
					hits=Integer.parseInt(hits1.trim());
					hits=hits+1;
				}
			}
			if(recSize != ctr  )
			{
				if(recSize%ctr == 0)
					out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </a>");
				else if(recSize%ctr != 0)
					out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </a>");				
			}
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		
            _bw.write(_wl_block14Bytes, _wl_block14);

			if (intFetchedRecords == 0)
			{
				out.println("<script>callNoRecords()</script>");
			}else{
				for (int l=0;l<ArrayListHtmlData.size() ;++l){
					out.println((String)ArrayListHtmlData.get(l));
				}
			}

 			if(intFetchedRecords == 1 && nextFlag.trim().length() == 0)//046704
				out.println("<script>closew(1)</script>");
	
			try{
				conn.close();
			}
			catch(Exception er){er.printStackTrace();}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_by_index));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(column_names));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(column_sizes));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(column_types));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(column_descriptions));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sql_pass_back));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(max_records));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(sql_order_by));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			//System.err.println("OTGeneralSearchresults.jsp : " + exp);
		}
		finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				ConnectionManager.returnConnection(conn,request);
			}



            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
