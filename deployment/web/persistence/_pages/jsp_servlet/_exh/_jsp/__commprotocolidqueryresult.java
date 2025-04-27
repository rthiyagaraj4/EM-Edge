package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __commprotocolidqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/CommProtocolIdQueryResult.jsp", 1709122307242L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head> \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eXH/js/CommProtocolId.js\'></script> \n<script Language=\"JavaScript\"  src=\"../../eCommon/js/common.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"APPL_RESULTS\" id=\"APPL_RESULTS\" method=\"POST\" action=\'\'  >\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<script>\nalert(getMessage(\"XH1021\",\"XH\"));history.go(-1);\n</script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n\t<td colspan=\"5\" align=\"right\" class=\"CAGROUP\" > \n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</A>\n\t</td>\n\t</tr>\n\n<tr>\n\t<td class=\'COLUMNHEADER\'  width=\'30%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>  \n</tr>\n\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t<tr>\n\t<td style=\'cursor:pointer\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" align=\"left\" >\n\t<a href=\'#\' onClick=\'funModify(this)\' protocol_id=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' protocol_name=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' protocol_type=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'\n\tprotocol_mode=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' \n\tfile_dir=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' file_type=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ip_address=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' port_no=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' ack_type=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' retry_intrvl=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' max_retries=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' file_intrvl=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'\n\tfilenaming_api=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' \n\tdata_intrvl=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' datainput_api=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' \n\tstatistics_api=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' auto_restart_type=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' auto_restart_time=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' \tmodule_Id=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' db_conn_string=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'\n\tdb_driver=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' fax_id=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'\n\tmail_id=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' module_Name=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' \n\toracle_table_qry=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'\n\toracle_table_ins_qry=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' solicitedYN=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' ack_dir=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' \n\tstylesht_path=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' sub_module_Id=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'\n\tsub_module_Name=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' error_dir=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' odbc_uid=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' odbc_pwd=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' odbc_sid=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' dblink_name=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' httpUserAgent=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' httpContentType=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' httpTransferEncoding=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' httpSoapAction=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' httpContentLength=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'  mail_host=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' mail_port=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' mail_config=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' mail_smtp_auth_flag=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' mail_smtp_starttls_flag=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' mail_attachment_flag=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' >\n\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" \n\t</a> \n\t</b>\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" align=\"left\"> \n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" align=\"center\">\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t</td>\n\n\t</tr>\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t</table>\n\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'U\' >\n\t<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'protocol_id\' id=\'protocol_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'protocol_name\' id=\'protocol_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'protocol_type\' id=\'protocol_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'protocol_mode\' id=\'protocol_mode\' value=\'\'>\n\t<input type=\'hidden\' name=\'file_dir\' id=\'file_dir\' value=\'\'>\n\t<input type=\'hidden\' name=\'file_type\' id=\'file_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'ip_address\' id=\'ip_address\' value=\'\'>\n\t<input type=\'hidden\' name=\'port_no\' id=\'port_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'ack_type\' id=\'ack_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'retry_intrvl\' id=\'retry_intrvl\' value=\'\'>\n\t<input type=\'hidden\' name=\'max_retries\' id=\'max_retries\' value=\'\'>\n\t<input type=\'hidden\' name=\'file_intrvl\' id=\'file_intrvl\' value=\'\'>\n\t<input type=\'hidden\' name=\'filenaming_api\' id=\'filenaming_api\' value=\'\'>\n\t<input type=\'hidden\' name=\'data_intrvl\' id=\'data_intrvl\' value=\'\'>\n\t<input type=\'hidden\' name=\'datainput_api\' id=\'datainput_api\' value=\'\'>\n\t<input type=\'hidden\' name=\'statistics_api\' id=\'statistics_api\' value=\'\'>\n\t<input type=\'hidden\' name=\'auto_restart_type\' id=\'auto_restart_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'auto_restart_time\' id=\'auto_restart_time\' value=\'\'>\n\t<input type=\'hidden\' name=\'module_Id\' id=\'module_Id\' value=\'\'>\n\t<input type=\'hidden\' name=\'db_conn_string\' id=\'db_conn_string\' value=\'\'>\n\t<input type=\'hidden\' name=\'db_driver\' id=\'db_driver\' value=\'\'>\n\t<input type=\'hidden\' name=\'fax_id\' id=\'fax_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'mail_id\' id=\'mail_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'module_Name\' id=\'module_Name\' value=\'\'>\n    <input type=\'hidden\' name=\'recipient_name\' id=\'recipient_name\' value=\'\'>\n    <input type=\'hidden\' name=\'to_mail\' id=\'to_mail\' value=\'\'>\n    <input type=\'hidden\' name=\'solicitedYN\' id=\'solicitedYN\' value=\'\'>\n\t<input type=\'hidden\' name=\'oracle_table_qry\' id=\'oracle_table_qry\' value=\'\'>\n    <input type=\'hidden\' name=\'oracle_table_ins_qry\' id=\'oracle_table_ins_qry\' value=\'\'>\n\t<input type=\'hidden\' name=\'ack_dir\' id=\'ack_dir\' value=\'\'>  \n\t<input type=\'hidden\' name=\'stylesht_path\' id=\'stylesht_path\' value=\'\'> \n\t<input type=\'hidden\' name=\'sub_module_Id\' id=\'sub_module_Id\' value=\'\'> \n\t<input type=\'hidden\' name=\'sub_module_Name\' id=\'sub_module_Name\' value=\'\'> \n\t<input type=\'hidden\' name=\'error_dir\' id=\'error_dir\' value=\'\'>  \n\t<input type=\'hidden\' name=\'odbc_uid\' id=\'odbc_uid\' value=\'\'> \n\t<input type=\'hidden\' name=\'odbc_pwd\' id=\'odbc_pwd\' value=\'\'> \n\t<input type=\'hidden\' name=\'odbc_sid\' id=\'odbc_sid\' value=\'\'> \n\t<input type=\'hidden\' name=\'dblink_name\' id=\'dblink_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'httpUserAgent\' id=\'httpUserAgent\' value=\'\'>\n\t<input type=\'hidden\' name=\'httpContentType\' id=\'httpContentType\' value=\'\'>\n\t<input type=\'hidden\' name=\'httpTransferEncoding\' id=\'httpTransferEncoding\' value=\'\'>\n\t<input type=\'hidden\' name=\'httpSoapAction\' id=\'httpSoapAction\' value=\'\'>\n\t<input type=\'hidden\' name=\'httpContentLength\' id=\'httpContentLength\' value=\'\'>\n\t\n\t<input type=\'hidden\' name=\'mail_host\' id=\'mail_host\' value=\'\'>\n\t<input type=\'hidden\' name=\'mail_port\' id=\'mail_port\' value=\'\'>\n\t<input type=\'hidden\' name=\'mail_config\' id=\'mail_config\' value=\'\'>\n\t<input type=\'hidden\' name=\'mail_smtp_auth_flag\' id=\'mail_smtp_auth_flag\' value=\'\'>\n\t<input type=\'hidden\' name=\'mail_smtp_starttls_flag\' id=\'mail_smtp_starttls_flag\' value=\'\'>\n\t<input type=\'hidden\' name=\'mail_attachment_flag\' id=\'mail_attachment_flag\' value=\'\'>\n</form>\n</html>\n\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "COMMPROTID";
			Connection conn = null;
								 
			try
			{
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"48"); //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification -added 5 new columns for soap 37 tp 42
				
				conn = ConnectionManager.getConnection(request);	
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = "Previous"; 
				String strNext  = "Next"; 
				if (boolPrevious == true)
				{
					strPrevious = "Previous"; 
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = "Next"; 
				}
				else
				{
					strNext  = " ";
				}
		
            _bw.write(_wl_block8Bytes, _wl_block8);

if(arrRow.size()==0)
{

            _bw.write(_wl_block9Bytes, _wl_block9);
 } else { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strPrevious ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strNext ));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
		String prot_type = (String)arrCol.get(36);
		String prot_mode = "";
/*
		if(arrCol.get(2).equals("T")){
		    prot_type = "TCP/IP";
		}
		else if(arrCol.get(2).equals("F")){
		    prot_type = "File";
		}

	else if(arrCol.get(2).equals("R")){
		    prot_type = "RS232";
		}
		else if(arrCol.get(2).equals("X")){
		    prot_type = "Fax";
		}
		else if(arrCol.get(2).equals("M")){
		    prot_type = "Mail";
		}
		else if(arrCol.get(2).equals("S")){
		    prot_type = "SMS";
		}
		else if(arrCol.get(2).equals("D")){
		    prot_type = "ODBC";
		}
		else if(arrCol.get(2).equals("OT")){
		    prot_type = "Oracle Table";
		}
		else if(arrCol.get(2).equals("RP")){
		    prot_type = "Replication";
		}else if(arrCol.get(2).equals("W")){
		    prot_type = "Webservice";
		}
		else if(arrCol.get(2).equals("JM")){
		    prot_type = "Java Mail";
		}
*/
		if(arrCol.get(3).equals("I")){
		    prot_mode = "Inbound";
		}
		else if(arrCol.get(3).equals("O")){
		    prot_mode = "Outbound";
		}

	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(arrCol.get(2)+""));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(arrCol.get(3)+""));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(arrCol.get(4)+""));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(arrCol.get(5)+""));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(arrCol.get(6)+""));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(arrCol.get(7)+""));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(arrCol.get(8)+""));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(arrCol.get(9)+""));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(arrCol.get(10)+""));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(arrCol.get(11)+""));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(arrCol.get(12)+""));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(arrCol.get(13)+""));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(arrCol.get(14)+""));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(arrCol.get(15)+""));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(arrCol.get(16)+""));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrCol.get(17)+""));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(arrCol.get(18)+""));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(arrCol.get(19)+""));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(arrCol.get(20)+""));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(arrCol.get(21)+""));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(arrCol.get(22)+""));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(arrCol.get(23)+""));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)arrCol.get(24))+""));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)arrCol.get(25))+""));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(arrCol.get(26)+""));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(arrCol.get(27)+""));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(arrCol.get(28)+""));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(arrCol.get(29)+""));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(arrCol.get(30)+""));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(arrCol.get(31)+""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(arrCol.get(32)+""));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(arrCol.get(33)+""));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(arrCol.get(34)+""));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(arrCol.get(35)+""));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(arrCol.get(37)+""));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(arrCol.get(38)+""));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(arrCol.get(39)+""));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(arrCol.get(40)+""));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(arrCol.get(41)+""));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(arrCol.get(42)+""));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(arrCol.get(43)+""));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(arrCol.get(44)+""));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(arrCol.get(45)+""));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(arrCol.get(46)+""));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(arrCol.get(47)+""));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(""+arrCol.get(1) ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prot_type ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(prot_mode ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(""+arrCol.get(18) ));
            _bw.write(_wl_block68Bytes, _wl_block68);

	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	
            _bw.write(_wl_block69Bytes, _wl_block69);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.CommunicationType.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mode.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Module.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
