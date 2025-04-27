package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import java.util.HashMap;
import eOT.*;
import eOT.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __examschecklistresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ExamsCheckListResults.jsp", 1709120216000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/ExamsCheckList.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style type=\"text/css\">\n\t\t.menu1 {text-align:left;position:relative;width:860px;}\n\t</style>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body  onKeyDown = \'lockKey()\' >\n\t<form name=\"ExamsCheckListResultsForm\" id=\"ExamsCheckListResultsForm\" method=\"POST\" action=\"../../servlet/eOT.ExamsCheckListServlet\">\n<table cellpadding=\"3\" cellspacing=\"0\" align=\"center\" border=\"1\" width=\"100%\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\t\n\t\t\t<input type=\"hidden\" name=\"checklist_code_";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" id=\"checklist_code_";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t<input type=\"hidden\" name=\"checklist_item_code_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"checklist_item_code_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<input type=\"hidden\" name=\"checklist_item_srl_no_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"checklist_item_srl_no_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t<input type=\"hidden\" name=\"old_remarks_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"old_remarks_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<input type=\"hidden\" name=\"new_remarks_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"new_remarks_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"insert_update_flag_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"insert_update_flag_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<input type=\"hidden\" name=\"description_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"description_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" disabled>\n\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" width=\"80%\" style=\"font-weight:normal\" wrap>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" width=\"10%\">\n\t\t\t\t<input type=\"checkbox\" name=\"checkbox_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"checkbox_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onClick=\"assignCheckBoxValue(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">\n\t\t\t</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" width=\"10%\">\n\t\t\t\t<label style=\"color:blue;cursor:pointer\" onClick=\"openCheckListRemarksWindow(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\"> &nbsp;Remarks</label>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</table>\n\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' >\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\t\n\t<input type=\"hidden\" name=\"checklist_user_id\" id=\"checklist_user_id\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\"hidden\" name=\"size\" id=\"size\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" name=\"confirm_yn\" id=\"confirm_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"check_list_code\" id=\"check_list_code\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" name=\"completed_by_id\" id=\"completed_by_id\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\t\n\t<input type=\"hidden\" name=\"checklist_completed_yn\" id=\"checklist_completed_yn\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" disabled>\t\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<input type=\"hidden\" name=\"hdr_insert_update_flag\" id=\"hdr_insert_update_flag\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	int rownum = 0;
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String facility_id		= (String) session.getValue("facility_id");
	String user_id			= request.getParameter("slate_user_id");
	String mode				= (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
	String params			= request.getQueryString() ;
	String order_id			= request.getParameter("order_id");
	String patient_id		= request.getParameter("patient_id");
	String data_exists		= request.getParameter("data_exists");
	String checklist_completed_yn = request.getParameter("checklist_completed_yn");
	String check_list_code	= request.getParameter("check_list_code");
	ArrayList checklist_details = new ArrayList();
	String sql				= "";
	String disabled= "";
	if(checklist_completed_yn.equals("Y"))
		disabled="disabled";
	HashMap existing_checklist_dtls = new HashMap();
	HashMap temp_checklist_dtls = null;
	String checklist_item_code = "";
	String checklist_remarks = "";
try{

            _bw.write(_wl_block9Bytes, _wl_block9);

	connection = ConnectionManager.getConnection(request);
	if(data_exists.equalsIgnoreCase("DATA_EXISTS")){
		sql="SELECT CHECK_LIST_ITEM_CODE, NVL(CHECK_LIST_ITEM_VALUE,'N') CHECK_LIST_ITEM_VALUE,CHECK_LIST_REMARKS FROM RD_REQUEST_CHECK_LSIT_DTL WHERE OPERATING_FACILITY_ID = ? AND CHECK_LIST_REF=? AND CHECK_LIST_SRL='1'";

		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,order_id);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			temp_checklist_dtls = new HashMap();
			checklist_item_code = resultset.getString("CHECK_LIST_ITEM_CODE");
			temp_checklist_dtls.put("checklist_item_code",checklist_item_code);
			temp_checklist_dtls.put("check_list_item_value",resultset.getString("CHECK_LIST_ITEM_VALUE"));
			temp_checklist_dtls.put("check_list_remarks",resultset.getString("CHECK_LIST_REMARKS"));	existing_checklist_dtls.put(checklist_item_code,temp_checklist_dtls);		
		}

		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
	}

	sql="SELECT D.CHECKLIST_CODE CHECKLIST_CODE, D.CHECKLIST_ITEM_CODE CHECKLIST_ITEM_CODE, D.CHECKLIST_ITEM_SRL_NO CHECKLIST_ITEM_SRL_NO, I.DESCRIPTION DESCRIPTION FROM RD_CHECKLIST_DTL D, RD_CHECKLIST_ITEMS I WHERE D.CHECKLIST_ITEM_CODE=I.CHECKLIST_ITEM_CODE AND NVL(STATUS,'E')='E' AND D.CHECKLIST_CODE = ? ORDER BY 2,3 ";
	pstmt = connection.prepareStatement(sql);
	pstmt.setString(1,check_list_code);
	resultset = pstmt.executeQuery();
	while(resultset.next()){
		checklist_details.add(resultset.getString("CHECKLIST_CODE"));
		checklist_details.add(resultset.getString("CHECKLIST_ITEM_CODE"));
		checklist_details.add(resultset.getString("CHECKLIST_ITEM_SRL_NO"));
		checklist_details.add(resultset.getString("DESCRIPTION"));			
	}
	if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("59:Err Msg in ExamsCheckListResults.jsp"+e.getMessage());
} finally{
	try{
		temp_checklist_dtls = null;
		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
		if(connection!=null)
		ConnectionManager.returnConnection(connection,request);
	}catch(Exception e){e.printStackTrace();}
}

	String classValue = "";
	String dtl_insert_update_flag = "";
	String checklist_value	= "";
	String chkbox_checked	= "";
	checklist_item_code = "";
	if(checklist_details.size()>0){
		for(int row_num=0;row_num<checklist_details.size();row_num+=4){
			rownum++;
			if ( rownum % 2 == 0 )
				classValue = "QRYODD" ;
			else
				classValue = "QRYEVEN" ;

			checklist_item_code = (String)checklist_details.get(row_num+1);
			if(existing_checklist_dtls.size()>0 && (HashMap)existing_checklist_dtls.get(checklist_item_code)!=null){
				checklist_value = (String)((HashMap)existing_checklist_dtls.get(checklist_item_code)). get("check_list_item_value");
				checklist_remarks = (String)((HashMap)existing_checklist_dtls.get(checklist_item_code)). get("check_list_remarks");
				if(checklist_value.equals("Y"))
					chkbox_checked = "checked";
				else
					chkbox_checked = "";
				dtl_insert_update_flag="U";
			}else{
				chkbox_checked = "";
				checklist_value="";
				checklist_remarks = "";
				dtl_insert_update_flag="I";
			}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)checklist_details.get(row_num)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(checklist_item_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)checklist_details.get(row_num+2)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(checklist_remarks));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dtl_insert_update_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)checklist_details.get(row_num+3)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)checklist_details.get(row_num+3)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(checklist_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(chkbox_checked));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block35Bytes, _wl_block35);

		}
	}
	existing_checklist_dtls = null;
	temp_checklist_dtls		= null;

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(params));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(check_list_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(checklist_completed_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);

	// to check whether data exists or not
	String hdr_insert_update_flag = "";
	if(data_exists.equals("DATA_EXISTS"))
		hdr_insert_update_flag = "U";
	else
		hdr_insert_update_flag = "I";

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(hdr_insert_update_flag));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block49Bytes, _wl_block49);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
