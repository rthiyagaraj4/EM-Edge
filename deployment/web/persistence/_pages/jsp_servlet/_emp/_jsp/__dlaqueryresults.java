package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eMP.DLAInterfaceUtil;
import java.util.*;
import com.ehis.util.*;

public final class __dlaqueryresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/DLAQueryResults.jsp", 1709118609260L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eMP/js/dlainterface.js\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<script>\n\tvar msg = getMessage(\"SQL_DB_CONN_FAIL\",\"MP\");\n\tparent.message_frame.location.href = \'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+msg;\n\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\tvar msg = getMessage(\"SQL_DB_CONN_FAIL\",\"MP\");\n\t\tparent.message_frame.location.href = \'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+msg;\n\t\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\n\t\t<P>\n\t\t<DIV id=\"details\" STYLE=\"display:block\">\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<td align =\'right\' class=\'CAGROUP\' width=\"10%\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t<BR><BR>\n\t\t</P>\n\n\t\t<center>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\t\t\n\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<script>\n\tif(document.getElementById(\"next\") != null)\n\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<script >\t\n\tif(document.getElementById(\"next\") != null)\n\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</tr>\n\t</table>\n\t</DIV>\n\t</center>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<script>\n\t\tvar msg = getMessage(\"INVALID_VALUE\",\"common\");\t\t\n\t\tmsg = msg.replace(\'#\',getLabel(\"Common.birthDate.label\",\"Common\"));\n\t\talert(msg);\n\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n<!-- </center> -->\n\n<FORM ID=\"dla_search_form\" ACTION=\"../../servlet/eMP.DLATransactionServlet\" METHOD=\"post\">\n<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" VALUE=\"DLASearch\">\n<INPUT TYPE=\"hidden\" name=\"flag\" id=\"flag\" ID=\"flag\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\"hidden\" name=\"search_by\" id=\"search_by\" ID=\"search_by\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<INPUT TYPE=\"hidden\" name=\"isFromOracleDB\" id=\"isFromOracleDB\" ID=\"isFromOracleDB\" VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<!-- <INPUT TYPE=\"hidden\" name=\"nat_id\" id=\"nat_id\" ID=\"nat_id\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"> -->\n<INPUT TYPE=\"hidden\" name=\"new_request\" id=\"new_request\" ID=\"new_request\" VALUE=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<INPUT TYPE=\"hidden\" name=\"code\" id=\"code\" ID=\"code\" VALUE=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n</FORM>\n\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		String temp = ((inputString == null) || (inputString.equals("null")) || (inputString.equals(""))) ? defaultValue : inputString;
		return(temp);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	String locale = ((String)session.getAttribute("LOCALE"));
	String patient_id = (String)session.getAttribute("dla_patient_id");

            _bw.write(_wl_block6Bytes, _wl_block6);

// exception not null indicates SQL server connection failed while processing the request & 
// message will be displayed in message frame.
String exception = (String)session.getAttribute("exception");
if(exception != null)
{

            _bw.write(_wl_block7Bytes, _wl_block7);

}
else
{

Connection sqlServerConn = null;
PreparedStatement isExistingPStmt = null;
ResultSet isExistingRSet = null;

String from = null;
String to = null;
String function_id = (String)session.getAttribute("dla_function_id");

boolean isFromOracleDB = true;
boolean invalidDOB = false;

try
{
	out.println("<HTML><head>"+
	"<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
	"</head>"+
	"<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String searchQuery = "";
	String serach_mode = request.getParameter("serach_mode");
	String dateFormat = "";	

	isFromOracleDB = Boolean.valueOf(request.getParameter("isFromOracleDB"));

	sqlServerConn = DLAInterfaceUtil.getConnection("DLAP");
	if(sqlServerConn == null)
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else
	{

	from = request.getParameter("from");
	to = request.getParameter("to");

	String today_datetime1 = (String)session.getAttribute("today_datetime");	
	String dla_machine_name1 = (String)session.getAttribute("dla_machine_name");

/*	if(serach_mode != null && serach_mode.equalsIgnoreCase("N"))
	{
	

		searchQuery = DLAInterfaceUtil.getSqlDBQueryByNationalID();

		

		isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);
		isExistingPStmt.setString(2,national_id_name);			
		search_type = "0";
		req_search = national_id_name;

		
	}
	else if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
	{
	

		boolean flag_fname = false;

		search_type = "1";
		req_search = first_name;
		if(first_name != null && !first_name.equalsIgnoreCase(""))
		{
		//	searchQuery = searchQuery+" fname LIKE '"+first_name+"%'";
			searchQuery = searchQuery+" fname LIKE ?";
			flag_fname = true;
			req_search = req_search+" ";
		}
		if(sur_name != null && !sur_name.equalsIgnoreCase(""))
		{
			if(flag_fname)
			{
				searchQuery = searchQuery+" AND lname LIKE ?";
				isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);
				isExistingPStmt.setString(2,first_name+"%");
				isExistingPStmt.setString(3,sur_name+"%");
			}
			else
			{
				searchQuery = searchQuery+" lname LIKE ?";
				isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);				
				isExistingPStmt.setString(2,sur_name+"%");
			}
			req_search = req_search+sur_name;
		}
		else
		{
			isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);				
			isExistingPStmt.setString(2,first_name+"%");
		}
*/	
	searchQuery = DLAInterfaceUtil.getSqlDBSearchByName();

	isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);

		
//	}

	isExistingRSet = isExistingPStmt.executeQuery();
	
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if(from == null) start = 1 ;
	else start = Integer.parseInt(from) ;

	if(to == null)	end = 10 ;
	else end = Integer.parseInt(to) ;

//Connection conn = (Connection) session.getValue( "connection" ) ;



//int maxRecord = 0;
	

/*	isExistingRSet.last();
	int rowCount = isExistingRSet.getRow();
	isExistingRSet.beforeFirst();



	boolean newRequest = Boolean.valueOf(request.getParameter("newRequest"));

	// If only one patient exists with the entered search criteria, that patient details will be derectly displayed.
	if(rowCount == 1 && newRequest)
	{		
		isExistingRSet.next();
		String code = checkForNull(isExistingRSet.getString(1),"&nbsp;");
		response.sendRedirect("../../eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id="+code+"&isFromOracleDB="+isFromOracleDB);
	}
	else
	{		
*/	if ( start != 1 )
	{
		for(int j=1; j<start; i++,j++)
		{
			isExistingRSet.next() ;
		}
	}
	String classValue = "" ;
	int cnt=0;	
	while (i <= end && isExistingRSet.next())
	{
		
		if(cnt == 0)
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
		
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev' class='CAGROUP'><A HREF='../../eMP/jsp/DLAQueryResults.jsp?from="+(start-10)+"&isFromOracleDB="+isFromOracleDB+"&to="+(end-10)+"&serach_mode="+serach_mode+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");			

            _bw.write(_wl_block10Bytes, _wl_block10);
		 
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/DLAQueryResults.jsp?from="+(start+10)+"&isFromOracleDB="+isFromOracleDB+"&to="+(end+10)+"&serach_mode="+serach_mode+"'"+" text-decoration='none' style='visibility:hidden' id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");			

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( DLAInterfaceUtil.getLabelPrompt(locale,"FirstName") ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( DLAInterfaceUtil.getMiddleNamePrompt(locale) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( DLAInterfaceUtil.getLabelPrompt(locale,"FamilyName") ));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		}		
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		out.println("<tr><td align='left' class='" + classValue + "'>");
		String code = checkForNull(isExistingRSet.getString(1),"&nbsp;");		
	//	out.println("<a href='../../eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id="+code+"&isFromOracleDB="+isFromOracleDB+"'>");
		out.println("<a href='../../eMP/jsp/DlaIDupChk.jsp?national_id="+code+"&patient_id="+patient_id+"'>");
		out.println(code+"</a></td><td class='" + classValue + "'>");
		out.println( checkForNull(isExistingRSet.getString(13),"&nbsp;") );
		out.println("</td><td class='" + classValue + "'>");
		out.println( checkForNull(isExistingRSet.getString(2),"&nbsp;") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(checkForNull(isExistingRSet.getString(21),"&nbsp;"));
		out.println("</td><td class='" + classValue + "'>");
		out.println(checkForNull(isExistingRSet.getString(3),"&nbsp;"));
		out.println("</td><td class='" + classValue + "'>");
		
		String tempDate = checkForNull(isExistingRSet.getString(4),"&nbsp;");
		dateFormat = "yyyyMMdd";
		//java.util.Date utilDate = (java.util.Date)DLAInterfaceUtil.convertToDate(tempDate,dateFormat);
		//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		if(tempDate.length() == 8)
		{
			try
			{
				Integer.parseInt(tempDate.substring(0,4));
			}
			catch(NumberFormatException exp)
			{
				invalidDOB = true;
			}
		}
		else
		{
			invalidDOB = true;
		}

		if(locale != null && locale.equalsIgnoreCase("th") && !invalidDOB)
		{
		//	tempDate = DLAInterfaceUtil.convertStringDateFormats(tempDate,dateFormat,"dd/MM/yyyy");
			tempDate = tempDate.substring(6,8) + "/" + tempDate.substring(4,6) + "/" + tempDate.substring(0,4);
		}
		else if(!invalidDOB)
		{
		//	String tempDate1 = DLAInterfaceUtil.convert_to_greg_date(sqlDate,"th");						
		//	tempDate = DLAInterfaceUtil.convertStringDateFormats(tempDate1,"yyyy-MM-dd","dd/MM/yyyy");

			tempDate = tempDate.substring(6,8) + "/" + tempDate.substring(4,6) + "/" 
						+ (Integer.parseInt(tempDate.substring(0,4)) - 543);
		}

		out.println(tempDate);
		out.println("</td><td class='" + classValue + "'>");		
		out.println(checkForNull(isExistingRSet.getString(7),"&nbsp;"));
		out.println("&nbsp;</td><td class='" + classValue + "'>");		
		out.println(checkForNull(isExistingRSet.getString(8),"&nbsp;"));
		out.println("&nbsp;</td>");			
		i++;
		cnt++;
	} 


//	if (cnt==0 && !isFromOracleDB && newRequest)
	if (cnt == 0)
	{		
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}	
	boolean flag = false;
	if ( cnt < 2 || (!isExistingRSet.next()) )
	{

            _bw.write(_wl_block15Bytes, _wl_block15);
 	
	flag = true;
	} 
	else 
	{

            _bw.write(_wl_block16Bytes, _wl_block16);
	}
	if (cnt == 0)
	{

            _bw.write(_wl_block17Bytes, _wl_block17);

	}
if(invalidDOB)
{

            _bw.write(_wl_block18Bytes, _wl_block18);

}
//	}



            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getParameter("mode")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getParameter("serach_mode")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getParameter("isFromOracleDB")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(session.getAttribute("dla_national_id")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request.getParameter("newRequest")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(request.getParameter("code")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

	}
	}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{
	try
	{
		if(isExistingRSet != null) isExistingRSet.close();
		if(isExistingPStmt != null) isExistingPStmt.close();
		if(sqlServerConn != null) DLAInterfaceUtil.closeConnection(sqlServerConn);
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
}}
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DOB.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.fathername.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.mothername.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
