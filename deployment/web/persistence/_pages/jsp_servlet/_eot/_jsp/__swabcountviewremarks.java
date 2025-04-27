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
import webbeans.eCommon.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __swabcountviewremarks extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SwabCountViewRemarks.jsp", 1723612606000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOT/js/SwabCount.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t\t<form name=\"SwabCountViewRemarksForm\" id=\"SwabCountViewRemarksForm\" >\n\t\t\t<table cellpadding=3  cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" width=\"25%\" valign=\"top\" colspan=\"4\"> <b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b> </td>\n\t\t\t\t\t<td width=\"25%\" class=\'fields\' colspan=\"4\">\n\t\t\t\t\t\t<textarea rows=\"5\" cols=\"70\" name=\"op_remarks\" readOnly >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</textarea>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" colspan=\"4\" valign=\"top\" width=\"25%\" > <b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\n\t\t\t\t\t<td width=\"25%\" class=\'fields\' colspan=\"4\" >\n\t\t\t\t\t\t<textarea rows=\"5\" cols=\"70\" name=\"add_dur_op_remarks\" readOnly >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</textarea>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" colspan=\"4\" valign=\"top\"> <b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </td>\n\t\t\t\t\t\t<td width=\"25%\" class=\'fields\' colspan=\"4\">\n\t\t\t\t\t\t\t<textarea rows=\"5\" cols=\"70\" name=\"second_count_remarks\" readOnly >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</textarea>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" colspan=\"4\" width=\"25%\" valign=\"top\"> <b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> \n\t\t\t\t\t\t<td width=\"25%\" class=\'fields\' colspan=\"4\">\n\t\t\t\t\t\t\t<textarea rows=\"5\" cols=\"70\" name=\"add_after_cc_remarks\" readOnly >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</textarea>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\"25%\" colspan=\"4\" valign=\"top\"> <b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </td>\n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'fields\' colspan=\"4\">\n\t\t\t\t\t\t\t\t\t<textarea rows=\"5\" cols=\"70\" name=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" readOnly >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</textarea>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\"4\" width=\"25%\" valign=\"top\"> <b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td> \n\t\t\t\t\t\t\t\t<td width=\"25%\" class=\'fields\' colspan=\"4\">\n\t\t\t\t\t\t\t\t\t<textarea rows=\"5\" cols=\"70\" name=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</textarea>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" colspan=\"4\" width=\"25%\" valign=\"top\"><b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t<td width=\"25%\" class=\'fields\' colspan=\"4\">\n\t\t\t\t\t\t<textarea rows=\"5\" cols=\"70\" name=\"final_count_remarks\" readOnly >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</textarea>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"25%\" class=\'button\' colspan=\"8\" align=\'right\'>\n\t\t\t\t\t\t<input  type=\"button\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' class=\"button\"  onClick=\"let dialogBody =parent.document.getElementById(\'dialog-body\'); dialogBody.contentWindow.returnValue =\'\';const dialogTag = parent.document.getElementById(\'dialog_tag\'); dialogTag.close();\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t</form>\n\t</body>\n</html>\n\n";
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getParameter("remarks_title")));
            _bw.write(_wl_block9Bytes, _wl_block9);

		Connection connection  = null;
		PreparedStatement pstmt=null;
		ResultSet resultset =null;
		StringBuffer remarks_buf = new StringBuffer();
		String initial_remarks = "",add_dur_op_remarks = "",second_count_remarks = "",add_after_cc_remarks = "",final_count_remarks = "",remarks	= "",added_by = "",added_time = "",item_value = "",where_clause = "",sql = "", main_sql = "";

		LinkedHashMap labelNameMap = new LinkedHashMap();
		LinkedHashMap dataMap = new LinkedHashMap();
		String[] getKeyVal;
		String[] getDataMapKeyVal;
		int allwdSwabCntsVal = 0;
		StringBuffer sqlBuffer = new StringBuffer();
		String third_count_remarks = "";
		String add_after_3c_remarks = "";
		String fourth_count_remarks = "";
		String add_after_4c_remarks = "";
		String fifth_count_remarks = "";
		String add_after_5c_remarks = "";
		try
		{
			connection = ConnectionManager.getConnection(request);
			String oper_num = checkForNull(request.getParameter("oper_num"));
			String facility_id	= (String) session.getValue("facility_id");
			String template_id	= checkForNull(request.getParameter("template_id"));
			String item_code = checkForNull(request.getParameter("item_code"));
			String swab_serial_number	= checkForNull(request.getParameter("swab_serial_number"));
			if(swab_serial_number == null || swab_serial_number.trim().length() == 0)
				swab_serial_number = "1";

			allwdSwabCntsVal = Integer.parseInt(checkForNull((request.getParameter("allwdSwabCntsVal") == null || request.getParameter("allwdSwabCntsVal").equals("0")) ? "3" : checkForNull(request.getParameter("allwdSwabCntsVal"))));
			if(allwdSwabCntsVal == 0)
				allwdSwabCntsVal = 3;
			System.out.println("====allwdSwabCntsVal=====SwabCountViewRemarks====="+allwdSwabCntsVal);
			labelNameMap.put(2, "eOT.SecondCount.Label~second_count_remarks~eOT.AddtSecondCount.Label~add_after_cc_remarks");
			labelNameMap.put(3, "eOT.ThirdCount.Label~third_count_remarks~eOT.AddtThirdCount.Label~add_after_3c_remarks");
			labelNameMap.put(4, "eOT.FourthCount.Label~fourth_count_remarks~eOT.AddtFourthCount.Label~add_after_4c_remarks");
			labelNameMap.put(5, "eOT.FifthCount.Label~fifth_count_remarks~eOT.AddtFifthCount.Label~add_after_5c_remarks");


			main_sql = "SELECT ADDED_BY_ID, TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH24:MI') ADDED_TIME, ITEM_VALUE, REMARKS FROM OT_OPER_SWAB_INSTR_CNT_DTL WHERE OPERATING_FACILITY_ID =? AND OPER_NUM = ? AND SWAB_SERIAL_NUMBER=? AND TEMPLATE_ID=? AND ITEM_CODE=?";
			for(int i = 1; i <= 6; i++)
			{
				remarks = "";
				remarks_buf.setLength(0);

				if(i == 1)
				{ // initial
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'ZZ' AND  NVL(FIRST_COUNT_YN,'N')='Y' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='N'";
				}
				else if(i == 2)
				{ // additions during OP //Added order by Anitha
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'OP' AND  NVL(FIRST_COUNT_YN,'N')='N' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='N' ORDER BY ADDED_DATE";
				}
				else if(i == 4)
				{ //second count
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'ZZ' AND  NVL(FIRST_COUNT_YN,'N')='N' AND NVL(SECOND_COUNT_YN,'N') ='Y' AND NVL(FINAL_COUNT_YN,'N')='N'";
				}
				else if(i == 5)
				{ //additions after closing the cavity //Added order by Anitha
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'CL' AND  NVL(FIRST_COUNT_YN,'N')='N' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='N' ORDER BY ADDED_DATE";
				}
				else if(i == 6)
				{ // final count
					where_clause = " AND NVL(INITIAL_COUNT_YN,'N')='N' AND NVL(ADDITIONS_DURING,'ZZ') = 'ZZ' AND  NVL(FIRST_COUNT_YN,'N')='N' AND NVL(SECOND_COUNT_YN,'N') ='N' AND NVL(FINAL_COUNT_YN,'N')='Y'";
				}
				sql = "";
				sql = main_sql + where_clause;
				if(resultset != null) 
					resultset.close();
				if(pstmt != null) 
					pstmt.close();
				System.out.println("=========sql=====SwabCountViewRemarks========"+sql);
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();

				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));

					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;

					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";

					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}

				if(i == 1) 
					initial_remarks = checkForNull(remarks_buf.toString());
				if(initial_remarks == null || initial_remarks.trim().length() == 0)
					initial_remarks = "";
				if(i == 2) 
					add_dur_op_remarks = checkForNull(remarks_buf.toString());
				if(add_dur_op_remarks == null || add_dur_op_remarks.trim().length() == 0)
					add_dur_op_remarks = "";
				if(i == 4) 
					second_count_remarks = checkForNull(remarks_buf.toString());
				if(second_count_remarks == null || second_count_remarks.trim().length() == 0)
					second_count_remarks = "";
				if(i == 5) 
					add_after_cc_remarks = checkForNull(remarks_buf.toString());
				if(add_after_cc_remarks == null || add_after_cc_remarks.trim().length() == 0)
					add_after_cc_remarks = "";
				if(i == 6) 
					final_count_remarks = checkForNull(remarks_buf.toString());
				if(final_count_remarks == null || final_count_remarks.trim().length() == 0)
					final_count_remarks = "";
			}
			dataMap.put(2, second_count_remarks + " ~ " + add_after_cc_remarks);

			if(allwdSwabCntsVal > 3)
			{
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl																	");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?											");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?				");
				sqlBuffer.append("	AND NVL (additions_during, 'ZZ') = 'ZZ' AND NVL (first_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'Y' 		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'			");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				third_count_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (additions_during, 'ZZ') = '3C'		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	ORDER BY added_date		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				add_after_3c_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				dataMap.put(3, third_count_remarks + " ~ " + add_after_3c_remarks);
			}
			if(allwdSwabCntsVal > 4)
			{
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (additions_during, 'ZZ') = 'ZZ' AND NVL (first_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'Y' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				fourth_count_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (additions_during, 'ZZ') = '4C'		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	ORDER BY added_date		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				add_after_4c_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				dataMap.put(4, fourth_count_remarks + " ~ " + add_after_4c_remarks);
			}
			if(allwdSwabCntsVal > 5)
			{
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (additions_during, 'ZZ') = 'ZZ' AND NVL (first_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (second_count_yn, 'N') = 'N' AND NVL (third_count_yn, 'N') = 'N' 		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'Y' AND NVL (final_count_yn, 'N') = 'N'		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				fifth_count_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				sqlBuffer.delete(0, sqlBuffer.length());
				if(resultset!=null)
					resultset.close();
				if(pstmt!=null)
					pstmt.close();
				sqlBuffer.append("	SELECT added_by_id, TO_CHAR (added_date, 'DD/MM/YYYY HH24:MI') added_time, item_value, remarks		");
				sqlBuffer.append("	FROM ot_oper_swab_instr_cnt_dtl		");
				sqlBuffer.append("	WHERE operating_facility_id = ? AND oper_num = ?		");
				sqlBuffer.append("	AND swab_serial_number = ? AND template_id = ? AND item_code = ?		");
				sqlBuffer.append("	AND NVL (first_count_yn, 'N') = 'N' AND NVL (second_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	AND NVL (third_count_yn, 'N') = 'N' AND NVL (additions_during, 'ZZ') = '5C'		");
				sqlBuffer.append("	AND NVL (fourth_count_yn, 'N') = 'N' AND NVL (fifth_count_yn, 'N') = 'N' AND NVL (final_count_yn, 'N') = 'N'		");
				sqlBuffer.append("	ORDER BY added_date		");
				pstmt = connection.prepareStatement(sqlBuffer.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, oper_num);
				pstmt.setString(3, swab_serial_number);		
				pstmt.setString(4, template_id);
				pstmt.setString(5, item_code);
				resultset = pstmt.executeQuery();
				while(resultset.next())
				{
					added_by	= resultset.getString("ADDED_BY_ID");
					added_time = (com.ehis.util.DateUtils.convertDate(resultset.getString("ADDED_TIME"),"DMYHM","en",locale));
					item_value	= checkForNull(resultset.getString("ITEM_VALUE"));
					if(item_value == null || item_value.trim().length() == 0)
						item_value = "0";
					remarks = checkForNull(resultset.getString("REMARKS"));
					remarks = remarks.equals("\n") ? "" : remarks;
					if(Integer.parseInt(item_value) > 0)
						remarks_buf.append(added_by + " added "+ item_value + " number(s) on "+ added_time+"\n");
					else if(Integer.parseInt(item_value) < 0)
						remarks_buf.append(added_by + " deducted " + item_value + " number(s) on " + added_time+"\n");
					if(!remarks.equals(""))
						remarks_buf.append("Remarks: " + remarks + "\n\n");
				}
				add_after_5c_remarks = remarks_buf.toString();
				remarks_buf.setLength(0);
				dataMap.put(5, fifth_count_remarks + " ~ " + add_after_5c_remarks);
			}
			if(resultset!=null)
				resultset.close();
			if(pstmt!=null)
				pstmt.close();
		}
		catch(Exception e)
		{
			System.err.println("196: Caught Exception in Swab Count Remarks"+e);
			e.printStackTrace();
		}
		finally
		{
			remarks_buf.setLength(0);
			if(resultset!=null)
				resultset.close();
			if(pstmt!=null)
				pstmt.close();
			ConnectionManager.returnConnection(connection,request);
		}

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(initial_remarks));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(add_dur_op_remarks));
            _bw.write(_wl_block14Bytes, _wl_block14);

				if(allwdSwabCntsVal == 3)
				{

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(second_count_remarks));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(add_after_cc_remarks));
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
				else if(allwdSwabCntsVal > 3)
				{
					for(int i=2; i<allwdSwabCntsVal; i++)
					{
						getKeyVal = ((String) labelNameMap.get(i)).split("~");
						getDataMapKeyVal = ((String) dataMap.get(i)).split("~");

            _bw.write(_wl_block20Bytes, _wl_block20);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
            int __result__tag4 = 0 ;

            if (__tag4 == null ){
                __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
            }
            __tag4.setPageContext(pageContext);
            __tag4.setParent(null);
            __tag4.setKey(getKeyVal[0]
);
            __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag4;
            __result__tag4 = __tag4.doStartTag();

            if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag4);
                return;
            }
            _activeTag=__tag4.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
            __tag4.release();
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(getKeyVal[1]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(getDataMapKeyVal[0]));
            _bw.write(_wl_block23Bytes, _wl_block23);
             org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
            int __result__tag5 = 0 ;

            if (__tag5 == null ){
                __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
            }
            __tag5.setPageContext(pageContext);
            __tag5.setParent(null);
            __tag5.setKey(getKeyVal[2]
);
            __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
            _activeTag=__tag5;
            __result__tag5 = __tag5.doStartTag();

            if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag5);
                return;
            }
            _activeTag=__tag5.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
            __tag5.release();
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(getKeyVal[3]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(getDataMapKeyVal[1]));
            _bw.write(_wl_block25Bytes, _wl_block25);

					}
				}

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(final_count_remarks));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InCount.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AdditionsduringOperation.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SecondCount.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AdditionsafterClcavityCompl.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FinalCount.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
}
