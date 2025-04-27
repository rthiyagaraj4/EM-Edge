package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import eCommon.Common.CommonBean;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __personneldtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PersonnelDtls.jsp", 1743663015429L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n<title> ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/RecordSurgeon.js\'></script>\n<script language=\"javascript\">\nvar code=new String();\nvar splty_code=new String(); \n\nfunction sendparams(index){\n\tvar isMandateEffortEstimation = document.forms(0).isMandateEffortEstimation.value;\n\tvar rows = parent.parent.parent.ObjectCollect.personnelrows[index]; \n\tvar mode = \'\';\n\tvar\ttime_in_date = \'\';\n\tvar\ttime_in_time = \'\';\n\tvar\ttime_out_date = \'\';\n\tvar\ttime_out_time = \'\';\n\tif(rows.time_in == null || rows.time_in == \'undefined\') rows.time_in = \'\';\n\tif(rows.time_out == null || rows.time_out == \'undefined\') rows.time_out = \'\';\n\tvar\ttime_out = rows.time_out;\n\t//Added Against ML-MMOH-CRF-1979-US2...starts\n\tif(isMandateEffortEstimation == \'true\'){\n\tvar\toperation_code=rows.operation_code;\n\tvar\toperation_desc=rows.operation_desc;\n\tif(operation_desc == \'\' || operation_desc == \'undefined\' || operation_desc == null) operation_desc = document.forms(0).operation_desc2.value;\n\tif(operation_code == \'\' || operation_code == \'undefined\' || operation_code == null) operation_code = document.forms(0).operation_code2.value;\n\tvar\tteam=rows.team;\n\tif(rows.time_in.length > 15 && rows.time_out.length > 15){\n\ttime_in_date = trimString((rows.time_in).slice(0,10));\n\ttime_in_time = trimString((rows.time_in).slice(11,16));\n\ttime_out_date = trimString((rows.time_out).slice(0,10));\n\ttime_out_time = trimString((rows.time_out).slice(11,16));\n\t}\n\tif(rows.db_mode == \'I\') mode = \'L\';\n\telse mode = \'U\';\n\t}else{\n\t\tmode = \'U\';\n\t}\n\t//Added Against ML-MMOH-CRF-1979-US2...ends\t\n\tvar\tspeciality_code=rows.speciality_code;\n\tvar\tspeciality_desc=rows.speciality_desc;\n\tvar\trole_id=rows.role_id;\n\tvar\trole_desc=rows.role_id+\"##\"+rows.role_type;\n\tvar\tpractitioner_id=rows.practitioner_id;\n\tvar\tpractitioner_name=rows.practitioner_name;\n\tvar\trecId = rows.recId;\t\t\t   \n\tvar role_type=rows.role_type;\n\tvar mode = \"U\";\n\tvar str =  speciality_code+\"::\"+speciality_desc+\'::\'+role_id+\'::\'+role_desc+\'::\'+practitioner_id+\'::\'+practitioner_name+\'::\'+recId+\'::\'+role_type+\'::\'+mode+\'::\'+operation_code+\'::\'+operation_desc+\'::\'+team+\'::\'+time_in_date+\'::\'+time_in_time+\'::\'+time_out_date+\'::\'+time_out_time;\n\tvar frmObj = parent.RecordFrame;\n\tfrmObj.splitString(str);\n}\nfunction createTable(){    \n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n var isMandateEffortEstimation = document.forms(0).isMandateEffortEstimation.value;\n  var rows = parent.parent.parent.ObjectCollect.personnelrows; \n  var tempPersonnelRows = parent.parent.parent.ObjectCollect.tempPersonnelRows;\n  var obj=document.getElementById(\"test\");\n  var disp_hosp = document.forms(0).disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]\n  var tab_data=\"\";\n  var speciality_desc=\"\";\n  var speciality_code=\"\";\n  var role_id = \"\";\n  var role_desc = \"\";\n  var practitioner_id=\"\";\n  var practitioner_name = \"\";\n  var queryVal=\"\";\n  var recId=\"\";\n  var args=\"\";\n  tab_data=\"<table border=\'1\' cellpadding=3 cellspacing=\'0\' width=\'100%\' align=\'center\'>\"\n  if(isMandateEffortEstimation==\'true\'){\n  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\"//Added Against ML-MMOH-CRF-1979-US02\n  }\n  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\"\n  if(isMandateEffortEstimation==\'true\'){\n  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\"\n  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\"//Added Against ML-MMOH-CRF-1979-US02\n  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\"//Added Against ML-MMOH-CRF-1979-US02\n  }\n \n\n if(rows!=null && rows.length>0)\n  {\n\tfor(var jj=0;jj<rows.length;jj++)\n\t{\n\t  if(rows[jj]!=null &&  rows[jj].db_mode!=\'D\'){\n\t   //Added Against ML-MMOH-CRF-1979-US2...starts\n\t   if(isMandateEffortEstimation==\'true\'){\n\t   operation_code=rows[jj].operation_code;\n\t   operation_desc=rows[jj].operation_desc;\n\t   team=rows[jj].team;\n\t   time_in=rows[jj].time_in;\n\t   time_out=rows[jj].time_out;\n\t   if(operation_desc == \'\' || operation_desc == \'undefined\' || operation_desc == null) operation_desc = document.forms(0).operation_desc2.value;\n\t   if(operation_code == \'\' || operation_code == \'undefined\' || operation_code == null) operation_code = document.forms(0).operation_code2.value;\n\t   if(team == \'\' || team == \'undefined\' || team == null) team = \'\';\n\t   if(time_in == \'\' || time_in == \'undefined\' || time_in == null) time_in = \'\';\n\t   if(time_out == \'\' || time_out == \'undefined\' || time_out == null) time_out = \'\';\n\t   }\n\t   //Added Against ML-MMOH-CRF-1979-US2...ends \n\t   speciality_code=rows[jj].speciality_code;\n\t   speciality_desc=rows[jj].speciality_desc;\n\t   role_id=rows[jj].role_id;\n\t   role_desc= rows[jj].role_id+\"::\"+rows[jj].role_type;\n\t   role_type = rows[jj].role_type;\n\t   practitioner_id=rows[jj].practitioner_id;\n\t   practitioner_name=rows[jj].practitioner_name;\n\t   recId = rows[jj].recId;\t\t\t   \n\t   args = jj;\n\n\t   code+=practitioner_id+\",\"; \n\t   splty_code+=speciality_code+\",\"; \n\t\t//if(disp_hosp == \"Y\")//Added for CHL-CRF-0020.1 [IN:043132]\n\t\t//{\n\t\t   if(jj%2==0)\n\t\t\t qryVal=\"gridData\";\n\t\t   else\n\t\t\t qryVal=\"gridData\"; \n\t\t\t ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\ttab_data+=\"<tr>\";\n\t\t\t\t\n\t\t\t\tif(isMandateEffortEstimation==\'true\') tab_data+=\"<td nowrap class=\"+qryVal+\">\"+operation_desc+\"</td>\";\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+speciality_desc+\"</td>\";\n\t\t\t\tif(isMandateEffortEstimation==\'true\') tab_data+=\"<td nowrap class=\"+qryVal+\">\"+team+\"</td>\";\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+rows[jj].role_desc+\"</td>\";\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+rows[jj].practitioner_name+\"</td>\";\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+rows[jj].position_desc+\"</td>\";\n\t\t\t\tif(isMandateEffortEstimation==\'true\'){\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+time_in+\"</td>\";\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+time_out+\"</td>\";\n\t\t\t\t}\n\t\t\t\ttab_data+=\"</tr>\"; \n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\ttab_data+=\"<tr>\";\n\t\t\t\tif(isMandateEffortEstimation==\'true\') tab_data+=\"<td nowrap class=\"+qryVal+\">\"+operation_desc+\"</td>\";\n\t\t\t\ttab_data+=\"<td class=\"+qryVal+\">\";\n\t\t\t\ttab_data+=\"<a class=\'gridLink\' href=\\\"javascript:sendparams(\"+args+\");\\\">\"+speciality_desc+\"</a></td>\";\n\t\t\t\tif(isMandateEffortEstimation==\'true\') tab_data+=\"<td nowrap class=\"+qryVal+\">\"+team+\"</td>\";\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+rows[jj].role_desc+\"</td>\";\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+rows[jj].practitioner_name+\"</td>\";\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+rows[jj].position_desc+\"</td>\";\n\t\t\t\tif(isMandateEffortEstimation==\'true\'){\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+time_in+\"</td>\";\t\t\t\t\n\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+time_out+\"</td>\";\n\t\t\t\t}\n\t\t\t\ttab_data+=\"</tr>\"; \n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t//}//Added for CHL-CRF-0020.1 [IN:043132]\n\t\t}\n\t  }//end of for Loop\n  }// end if \n\tif(tempPersonnelRows != null && tempPersonnelRows.length > 0)\n\t{\n\t\tfor(var kk=0; kk < tempPersonnelRows.length; kk++)\n\t\t{\n\t\t\tif(tempPersonnelRows[kk]!=null &&  tempPersonnelRows[kk].db_mode!=\'D\')\n\t\t\t{\n\t\t\t\tspeciality_code=tempPersonnelRows[kk].speciality_code;\n\t\t\t\tspeciality_desc=tempPersonnelRows[kk].speciality_desc;\n\t\t\t\trole_id=tempPersonnelRows[kk].role_id;\n\t\t\t\trole_desc= tempPersonnelRows[kk].role_id+\"::\"+tempPersonnelRows[kk].role_type;\n\t\t\t\trole_type = tempPersonnelRows[kk].role_type;\n\t\t\t\tpractitioner_id=tempPersonnelRows[kk].practitioner_id;\n\t\t\t\tpractitioner_name=tempPersonnelRows[kk].practitioner_name;\n\t\t\t\trecId = tempPersonnelRows[kk].recId;\t\t\t   \n\t\t\t\targs = kk;\n\t\t\t\tcode += practitioner_id+\",\"; \n\t\t\t\tsplty_code+=speciality_code+\",\"; \n\t\t\t\tif(disp_hosp == \"N\")//Added for CHL-CRF-0020.1 [IN:043132]\n\t\t\t\t{\n\t\t\t\t\tif(kk%2==0)\n\t\t\t\t\t\tqryVal=\"gridData\";\n\t\t\t\t\telse\n\t\t\t\t\t\tqryVal=\"gridData\"; \n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\ttab_data+=\"<tr>\";\n\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+speciality_desc+\"</td>\";\n\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+tempPersonnelRows[kk].role_desc+\"</td>\";\n\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+tempPersonnelRows[kk].practitioner_name+\"</td>\";\n\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+tempPersonnelRows[kk].position_desc+\"</td>\";\n\t\t\t\t\t\ttab_data+=\"</tr>\"; \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\ttab_data+=\"<tr><td class=\"+qryVal+\">\";\n\t\t\t\t\t\ttab_data+=\"<a class=\'gridLink\' href=\\\"javascript:sendparams(\"+args+\");\\\">\"+speciality_desc+\"</a></td>\";\n\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+tempPersonnelRows[kk].role_desc+\"</td>\";\n\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+tempPersonnelRows[kk].practitioner_name+\"</td>\";\n\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;\"+tempPersonnelRows[kk].position_desc+\"</td>\"; \n\t\t\t\t\t\ttab_data+=\"</tr>\"; \n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t}//Added for CHL-CRF-0020.1 [IN:043132]\n\t\t\t}\n\t\t}//end of for Loop\n\t}\n\ttab_data+=\"</table>\";\n\n  document.getElementById(\'test\').innerHTML = tab_data;\n  document.getElementById(\'test\').style.visibility=\"visible\";\n  parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}\n\n</script>\n</head>\n<body onLoad=\"createTable();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<div id=\"test\"></div>\n<form name=\"PersonnelDetailForm\" >\n<!-- Added for CHL-CRF-0020.1 [IN:043132] -->\n<input type=\'hidden\' name=\'disp_hosp\' id=\'disp_hosp\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'isMandateEffortEstimation\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'operation_desc2\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'operation_code2\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<!-- Added for CHL-CRF-0020.1 [IN:043132] -->\n</form>\n</body>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	String surgeon_doc_comp_yn = "";
	String nursing_doc_comp_yn = "";
	String tab = CommonBean.checkForNull(request.getParameter("tab"));
	//Added Against ML-MMOH_CRF-1979-US02...starts
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String operation_desc = "";
	String locale = (String)session.getAttribute("LOCALE");
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String operation_code = "";
	//Added Against ML-MMOH_CRF-1979-US02...ends
	String disp_hosp = CommonBean.checkForNull(request.getParameter("disp_hosp"));//Added for CHL-CRF-0020.1 [IN:043132]
	if(tab.equals("record_surgeon")){
		 surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	}else if(tab.equals("record_nursing")){
		 nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn")); 
	}
	
	boolean isMandateEffortEstimation = false;
	Connection con = null;
	try{
		con = ConnectionManager.getConnection(request);
		String sql = "SELECT M.LONG_DESC,D.OPER_CODE FROM OT_OPER_MAST M,OT_POST_OPER_DTLS D WHERE M.OPER_CODE = D.OPER_CODE AND D.OPER_NUM = ? AND D.OPERATING_FACILITY_ID = ? AND D.OPER_LINE_NUM = 1";
;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,oper_num);
		pstmt.setString(2,facility_id);
		rst = pstmt.executeQuery();	 
		while(rst.next()){
           operation_desc = CommonBean.checkForNull(rst.getString(1));
           operation_code = CommonBean.checkForNull(rst.getString(2));
		}
		
		isMandateEffortEstimation = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "MANDATE_EFFORT_ESTIMATION");//Added Against ML-MMOH-CRF-1979-US02
		//isMandateEffortEstimation = true;
		System.err.println("personeldtl.jsp isMandateEffortEstimation-------------->"+isMandateEffortEstimation);
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{ 
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( request.getParameter("title")));
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
Thread.sleep(1500); //Added Against SKR-SCF-1744 
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 if (surgeon_doc_comp_yn.equals("Y") ||  nursing_doc_comp_yn.equals("Y") ){ 
            _bw.write(_wl_block14Bytes, _wl_block14);
 } else {
            _bw.write(_wl_block15Bytes, _wl_block15);
 } 
            _bw.write(_wl_block16Bytes, _wl_block16);
 
					if (surgeon_doc_comp_yn.equals("Y") ||  nursing_doc_comp_yn.equals("Y"))
					{

            _bw.write(_wl_block17Bytes, _wl_block17);
 
					}
					else
					{

            _bw.write(_wl_block18Bytes, _wl_block18);

					}

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disp_hosp));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(isMandateEffortEstimation));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(operation_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(operation_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Operation.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Team.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TimeIn.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TimeOut.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
