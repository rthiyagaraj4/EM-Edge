package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __otgeneralsearchrecordresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTGeneralSearchRecordResults.jsp", 1709117272000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
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
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

//	String func_mode	= request.getParameter("func_mode");
	
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		String strColumnDelimiter = ",";
		String userWhereClause = "";
		String SQL = "";
		String sqlWithColumnsOnly = "";
		String strWhereColumn = "";
		String strWhereColumnType = "";
		String sql_pass_back = "";
		String sql_order_by = "";
		String sql_proc=request.getParameter("sql");
		String search_criteria_dir=request.getParameter("search_criteria");
		String strData = "";
		String strLinkData = "";
		String strTempColumnType = "VARCHAR2";
		String strTempColumnName = "";
		StringBuffer loc_type_buff = new StringBuffer();
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
		int start = 0,end = 0;
		int intFetchedRecords = 0;
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 14:Integer.parseInt(request.getParameter("max_records"));
			String sql = request.getParameter("sql");
			sql = (sql == null) ? "":sql;
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;

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
			if(calling_from_main == true)
			{
				sql = sql.replace('`','\'') ;
				intGroupIndex = SQL.lastIndexOf(" GROUP");
				if (intGroupIndex > 0)
				{
					intGroupByIndex = SQL.indexOf(" BY",intGroupIndex);
				}
				j = SQL.indexOf(" WHERE");
				if(j <0)
				 sql= sql +" where (1=1) and ";
				if(j > 0)
				{
					String sqlTemp = sql.substring(0,j+6);
					String sqlWhere = sql.substring(j+6);
					//sqlWhere = " ( " + sqlWhere +" ) and ";
					sqlWhere = sqlWhere +" and ";
					sql = sqlTemp + sqlWhere;
				}
				i = 0;
				j = 0;
				i = SQL.indexOf("SELECT");
				j = SQL.indexOf(" FROM");
				sqlWithColumnsOnly = SQL.substring(i+7,j);
				if (int_search_by_index >0)
				{
					String strTempSelectedColumn = (String)ArrayListColumnNames.get(int_search_by_index);
					String strTempPreviousColumn = (String)ArrayListColumnNames.get(int_search_by_index-1);
					int intTempSelectedIndex = sqlWithColumnsOnly.indexOf(strTempSelectedColumn);
					int intTempPreviousIndex = sqlWithColumnsOnly.indexOf(strTempPreviousColumn);
					int intCommaIndex = sqlWithColumnsOnly.indexOf(",",intTempPreviousIndex+1);
					strWhereColumn = sqlWithColumnsOnly.substring(intCommaIndex+1,intTempSelectedIndex);
				}
				else
				{
					String strTempColumn = (String) ArrayListColumnNames.get(int_search_by_index);
					int intTempIndex = sqlWithColumnsOnly.indexOf(strTempColumn );
					strWhereColumn = sqlWithColumnsOnly.substring(0,intTempIndex);
				}
				strWhereColumn = strWhereColumn.trim();
				int intTempWhereColumnLen = strWhereColumn.length();
				String strTempSpace = " ";
				String strTempQuote = "'";
				String strTempComma =",";
				i = 0;
				i = strWhereColumn.indexOf(strTempSpace);
				if ((i>0) && (int_search_by_index == 0)){
					j = 0;
					j = strWhereColumn.indexOf(strTempQuote);
					if (j<0){
						j = strWhereColumn.indexOf(strTempComma);
						if (j<0){
							strWhereColumn = strWhereColumn.substring(i,intTempWhereColumnLen);
						}
					}
				}
				strWhereColumnType = (String) ArrayListColumnTypes.get(int_search_by_index);
				if (strWhereColumnType.equalsIgnoreCase("VARCHAR2")){
					if(search_criteria.equals("S")){
						search_text = search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) ";
					}else if(search_criteria.equals("E")){
						search_text = "%" + search_text;
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}else if(search_criteria.equals("C")){
						search_text = "%" + search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}
				}else{
					userWhereClause = "( ceil( "+strWhereColumn+ ") like ceil(?)";
				}
				sql = sql + userWhereClause;
				sql = sql + " )";
				sql_pass_back = sql;
				sql_order_by = " order by "+(int_search_by_index+1);
				for (int l = 1;l<=intTotalColumns ; l++ ){
					if (l != (int_search_by_index+1)){
						sql_order_by = sql_order_by +"," +l;
					}
				}
			}else{
				sql_pass_back = request.getParameter("sql_pass_back");
				sql_order_by = request.getParameter("sql_order_by");
				sql = sql_pass_back;
			}
			sql = sql+ " "+sql_order_by;
			int intTempStart = start;
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search_text);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if (!(intTempStart<=0)){
					--intTempStart;
					continue;
				}
				++intFetchedRecords;
				for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace){
					strData = checkForNull(rs.getString(intTrace));
					strLinkData = strLinkData +strData+ "::";

					strTempColumnType = (String) ArrayListColumnTypes.get(intTrace-1);
					strTempColumnName = (String) ArrayListColumnNames.get(intTrace-1);
					strTempColumnName = strTempColumnName.trim();
				}
				if (intFetchedRecords >= max_records){
					break;
				}
			}
			if(intFetchedRecords==1){
				strLinkData=strLinkData+intFetchedRecords;
				out.println(strLinkData);	
			}

	}catch (Exception e) {
		System.err.println("Execpetion in OTGeneralSearchRecordResults.jsp: "+e);
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}finally{
		rs.close();
		pstmt.close();
        ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
