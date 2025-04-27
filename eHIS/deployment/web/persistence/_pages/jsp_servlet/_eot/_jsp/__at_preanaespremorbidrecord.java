package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.CommonBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;

public final class __at_preanaespremorbidrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_PreAnaesPreMorbidRecord.jsp", 1709120160000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script> \n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction checkForSpecCharsforID(event)\n\t{\n\t\t//function created for spl chars\n\t\tvar strCheck = \"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$*()_+{}|\':?><,./;\\][\";\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  \n\t\tif(event.keyCode==37 || event.keyCode==38 || event.keyCode==94 || event.keyCode==60 || event.keyCode==43){\n\t\t\treturn false\n\t\t}else\n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\treturn true ;\n}\n\n\t/*Added by Suma for incident 18700*/\n\tfunction checkForSpecCharsforID1(event)\n{   \n    var strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/-.,=+ \';\n    var whichCode = (window.Event) ? event.which : event.keyCode;\n    key = String.fromCharCode(whichCode); \n    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;  \n\treturn true ;\n}\n/*added by Suma ends here*/\n\tfunction Class_premorbd_row()\n\t{\n\t\t this.pre_morbid_code=\"\";\n\t\t this.remarks=\"\";\n\t\t this.pre_morbid_desc=\"\";\n\t\t this.db_mode=\"\";\n\t\t this.recId =\"\";\n\t}\n\n\tfunction checkForDeletedRecords()\n\t{\n\t    var rows=parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;\n\t\tvar formObj = document.forms[0];\n\t\tvar code = formObj.pre_morbid_code.value;\n\t\tfor(var i=0;i<rows.length;i++){\n\t\t\tif(rows[i]!=null){\n\t\t\t\tif( rows[i].pre_morbid_code==code && rows[i].db_mode==\"D\" )\n\t\t\t\t{\n\t\t\t\t\trows[i].db_mode=\"L\";\n\t\t\t\t\treturn true\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}else\n\t\t\t\tcontinue;\n\t\t}\n\t\treturn false;\t\n\t\t\t\n\t}\n\n\tfunction loadDBRows(pre_morbid_code,pre_morbid_desc,remarks,recId,mode)\n\t{ \n\t\t  var objrow = newRow();\n\t\t  var rows=parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;\n\t\t  var rowLength=parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_len;\n\t\t  if(mode==\'L\' && rowLength==0)\n\t\t  {\n\t\t\t  objrow.pre_morbid_code = pre_morbid_code;\n\t\t\t  objrow.pre_morbid_desc= pre_morbid_desc;\n\t\t\t  // Added by AnithaJ for 24816\n\t\t\t  objrow.remarks=decodeURIComponent(remarks,\"UTF-8\").replace(/\\+/g,\" \");\n\t\t\t  //objrow.remarks=remarks;\n\t\t\t  objrow.db_mode=\"L\";\n\t\t\t  objrow.recId=recId;\n\t\t\t  rows.push(objrow);\n\t\t\n\t\t  }\n\t}\n\n\tfunction newRow()\n\t{\n\t\t   var objrow = new Class_premorbd_row();\n\t\t   objrow.recId = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows.length+1;\n\t\t   return(objrow);\n\t}\n\tfunction assignRecId()\n\t{\n\t\tvar rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;\n\t\tparent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_len=rows.length;\n\t}\n\tfunction refresh()\n\t{\n\t\tvar params = document.forms[0].params.value;\n\t\tparent.parent.parent.pre_anesth_tab_details_frame.frames[1].pre_morbid_detail_frame.location.href=\'../../eOT/jsp/AT_PreAnaesPreMorbidDetails.jsp?\'+params;\n\t}\n\n\tfunction addRow()\n\t{\n\t\tvar objrow = newRow();\n\t\tvar formObj = document.pre_morbid_form;\n\t\tvar params = formObj.params.value;\n\t\tvar mode = formObj.mode.value;\n\t\tif(mode==\'I\'){\n\t\t\t if(chkEmpty()){\t\n\t\t\t  if(alreadyExist()){\n\t\t\t\t  var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;\n\t\t\t\t  objrow.pre_morbid_code=formObj.pre_morbid_code.value;\n\t\t\t\t  objrow.pre_morbid_desc=formObj.pre_morbid_desc.value;\n\t\t\t\t  objrow.remarks=formObj.remarks.value;\n\t\t\t\t  objrow.db_mode=\'I\';\n\t\t\t\t  objrow.recId = getRecId();\n\t\t\t\t  if(checkForDeletedRecords()==false)\n\t\t\t\t  rows.push(objrow);\n\t\t\t\t  resetFields();\n\t\t\t\t parent.frames[2].location.href=\'../../eOT/jsp/AT_PreAnaesPreMorbidDetails.jsp?\'+params;\n\t\t\t\t \n\t\t\t\t  parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t   }else { \n\t\t\t\t\tvar msg = \'Record already Selected...\';\n\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t   }\n\t\t}//mandatory_check\n    }//if part of mode Check Ends Here\n}\n\nfunction chkEmpty(){\n\tvar formObj = document.pre_morbid_form;\n\tvar fields = new Array(formObj.pre_morbid_desc);\n\tvar pre =getLabel(\"eOT.PreMorbidStatus.Label\",\"OT\") ;\n\tvar names = new Array(pre);\n\tvar messageFrame = parent.parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n function alreadyExist()\n {\n\tvar formObj = document.pre_morbid_form;\n\tvar codeDtl = parent.frames[2].code;\n\tvar rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;\n\tvar pre_morbid_code=formObj.pre_morbid_code.value;\n\tvar codeRecord = pre_morbid_code;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n }\n\n\tfunction getRecId()\n\t{\n\t\tvar rowLength=parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_len;\n\t\tvar recId = rowLength+1;\n\t\tparent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_len  =  recId;\n\t\treturn recId;\n\t}\n\nfunction resetFields()\n{\n\tvar frmObj = document.pre_morbid_form;\n\tfrmObj.mode.value=\'I\';\n\tfrmObj.pre_morbid_code.value=\'\';\n\tfrmObj.pre_morbid_desc.value=\'\';\n\tfrmObj.remarks.value=\'\';\n\tfrmObj.pre_morbid_desc.disabled=false;\n\tfrmObj.remarks.disabled=false;\n\tfrmObj.generic_search.disabled=false;\n\tfrmObj.select_button.disabled=false;\n}\n\nfunction splitString(strVal)\n{\n\tvar arr = strVal.split(\'::\');\n\tvar frmObj = document.forms[0];\n\tfrmObj.pre_morbid_code.value=arr[0];\n\tfrmObj.pre_morbid_desc.value=arr[1];\n//\tfrmObj.remarks.value=arr[2];\n\tfrmObj.remarks.value=decodeURIComponent(arr[2],\"UTF-8\");\n\tfrmObj.recId.value=arr[3]\n\tfrmObj.mode.value=arr[4];\n\tfrmObj.pre_morbid_desc.disabled=true;\n\tfrmObj.remarks.disabled=true;\n\tfrmObj.generic_search.disabled=true;\n\tfrmObj.select_button.disabled=true;\t\t\n}\n\nfunction SpecialCharRestriction(event){\n\tvar strCheck = \"\\\"`\'&<>\";\n\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\tif (strCheck.indexOf(key) != -1) return false;  // Not a valid key\n\treturn true ;\n}\n\nfunction removeRow(){\n var formObj = document.pre_morbid_form;\n var mode = formObj.mode.value;\n var recId = formObj.recId.value;\n var params = formObj.params.value;\n var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;\n\n if(rows.length>0&& mode==\'U\'){        \n for(var jj=0;jj<rows.length;jj++){\n if(rows[jj]!=null  && rows[jj].recId!=null && rows[jj].recId!=\"\") {\n\t if(rows[jj].recId==recId ){\n      if(rows[jj].db_mode==\'L\')\n\t    rows[jj].db_mode=\'D\';\n\t  else\n\t\tdelete rows[jj];\n\t   break;\n\t }\n  }else\n\tcontinue;\n }//end for-Loop\n   resetFields();\n   parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n  \n   parent.frames[2].location.href=\'../../eOT/jsp/AT_PreAnaesPreMorbidDetails.jsp?\'+params;\n }else\n   resetFields();\n}\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onLoad=\"\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<form name=\"pre_morbid_form\" id=\"pre_morbid_form\" >\n<input type = \"hidden\"  name=\'params\' id=\'params\'  value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" > \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table cellpadding=3  cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t<tr>\n\t\t<td align=\"right\" class=\"label\">\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t\t<td align=\"left\" class=\"fields\">\n\t\t\t<input type=\"hidden\" name=\"pre_morbid_code\" id=\"pre_morbid_code\" value=\"\">\n\t\t\t<input type=\"text\"  name=\"pre_morbid_desc\" id=\"pre_morbid_desc\" size=\'30\' value=\"\" onkeypress=\"return checkForSpecCharsforID(event);\" onblur=\"if(this.value!=\'\')callPreMorbidValues(pre_morbid_code,pre_morbid_desc);else pre_morbid_code.value=\'\'\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t\t\t<input type=\"button\" class=\"button\" name=\"generic_search\" id=\"generic_search\" value=\"?\" onclick=\"callPreMorbidValues(pre_morbid_code,pre_morbid_desc);\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >\n\t\t</td>\n\t\n\t<td class=\'label\' align=\'right\'>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</td>\n\t<td align=\'left\'>\n\t\t<textarea rows=\'3\' cols=\'30\' name=\'remarks\'  Onblur=\"makeValidString(this);\" onkeypress=\"return checkForSpecCharsforID(event);\" onChange=\'checkLimit(this,500)\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" ></textarea>\n\t</td>\n\t</tr>\n\t<tr>\n\t\t<td align=\"right\" class=\"label\"></td>\n\t\t<td align=\"right\" class=\"label\"></td>\n\t\t<td align=\"right\" class=\"label\"></td>\n\t\t<td align=\"right\" class=\'label\' >\n\t\t\t<input type=\'button\' name=\'select_button\' id=\'select_button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onClick=\'addRow();\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t\t<input type=\'button\' name=\'cancel_button\' id=\'cancel_button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onClick=\'removeRow();\'  ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n\t\t</td>\n\t</tr>\n</table>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<!-- end -->\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' >\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >\n<input type=\'hidden\' name=\'anesthesia_srl_no\' id=\'anesthesia_srl_no\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' >\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'refresh_flag\' id=\'refresh_flag\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String params		= request.getQueryString() ;
	String facility_id	=request.getParameter("facility_id");
	String anesthesia_srl_no	=request.getParameter("anesthesia_srl_no");
	String preop_asse_done_yn	=request.getParameter("preop_asse_done_yn");
	String disable_flag="";
	if(preop_asse_done_yn.equalsIgnoreCase("Y"))
	disable_flag="disabled";
	else if(preop_asse_done_yn.equalsIgnoreCase("N") || preop_asse_done_yn.equalsIgnoreCase(""))
	disable_flag="";
	String refresh_flag="1";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);


	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String remarks="";
	try{
		String sql_premorbid_status="SELECT A.PREMORBID_CODE, B.LONG_DESC,A.REMARKS  FROM  AT_RECORD_PREOP_PREMORBID A, AT_PREMORBID_MAST B WHERE A.OPERATING_FACILITY_ID =? AND A.ANAESTHESIA_SERIAL_NUM =? AND	 A.PREMORBID_CODE = B.PREMORBID_CODE";
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql_premorbid_status);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,anesthesia_srl_no);
		rs = pstmt.executeQuery();
		int index = 0;
		while(rs.next()){
			index++;
			remarks=rs.getString("REMARKS");
			//remarks=java.net.URLEncoder.encode(remarks,"UTF-8");
			if(remarks==null)remarks="";
			//Added by AnithaJ for 24816
			out.println("<script>loadDBRows(\""+rs.getString("PREMORBID_CODE")+"\",\""+rs.getString("LONG_DESC")+"\",\""+java.net.URLEncoder.encode(remarks,"UTF-8")+"\",\""+index+"\",\"L\"); </script>");	

		}
		out.println("<script>assignRecId()</script>");
		out.println("<script>refresh()</script>");
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disable_flag ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_flag ));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_flag ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_flag ));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disable_flag ));
            _bw.write(_wl_block19Bytes, _wl_block19);

					if(!imgUrl.equals("")){ 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(params));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(anesthesia_srl_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(refresh_flag));
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreMorbidStatus.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
