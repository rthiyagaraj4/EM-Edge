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
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __at_intraanaespersonalrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_IntraAnaesPersonalRecord.jsp", 1709120154000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="              \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script> \n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordIntraAnesthesia.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/Booking.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction Class_Personnel()\n\t{\n\t\t\n\t\t this.pract_type=\"\";\n\t\t this.desc_userdef=\"\";\n\t\t this.practitioner_id=\"\";\n\t\t this.practitioner_name=\"\";\n\t\t this.db_mode=\"\";\n\t\t this.position_desc=\"\";\n\t\t this.recId =\"\";\n\t}\n\n\tfunction checkForDeletedRecords(){\n\t    var rows=parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;\n\t\tvar formObj = document.forms[0];\n\t\tvar code = formObj.practitioner_id.value;\n\t\tfor(var i=0;i<rows.length;i++){\n\t\t\tif(rows[i]!=null){\n\t\t\t\tif((rows[i].practitioner_id)==code && rows[i].db_mode==\"D\" )\n\t\t\t\t{\n\t\t\t\t\trows[i].db_mode=\"L\";\n\t\t\t\t\treturn true\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}else\n\t\t\t\tcontinue;\n\t\t}\n\t\treturn false;\t\n\t\t\t\n\t}\n\t\n\tfunction loadDBRows(pract_type,desc_userdef,practitioner_id,practitioner_name,recId,mode,locale,order)\n\t{ \n\t\t  var objrow = newRow();\n\t\t  var rows=parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;\n\t\t  var rowLength=parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_len;\n\n\t\t  if(mode==\'L\' && rowLength==0)\n\t\t  {\n\t\t\t  objrow.pract_type = pract_type;\n\t\t\t  objrow.desc_userdef= desc_userdef;\n\t\t\t  objrow.practitioner_id = practitioner_id;\n\t\t\t  objrow.practitioner_name= practitioner_name;\n\t\t\t  objrow.db_mode=(order==1)?\"L\":\"I\";\n\t\t\t  //alert(\"DB_MODE\"+objrow.db_mode);\n\t\t\t  objrow.recId=recId;\n\t\t\t  objrow.position_desc=getPositionDesc(practitioner_id,locale);\n\t\t\t  rows.push(objrow);\n\t\t\n\t\t  }\n\t}\n\t\n\tfunction newRow()\n\t{\n\t\t   var objrow = new Class_Personnel();\n\t\t   objrow.recId = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows.length+1;\n\t\t   return(objrow);\n\t}\n\tfunction assignRecId()\n\t{\n\t\tvar rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;\n\t\tparent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_len=rows.length;\n\t}\n\tfunction refresh()\n\t{\n\t\tvar params = document.forms[0].params.value;\n\t\tparent.parent.parent.intra_anesth_tab_details_frame.personal_details_frame.location.href=\'../../eOT/jsp/AT_IntraAnaesPersonalDetails.jsp?\'+params;\n\t\t\n\t}\n\n\tfunction addRow()\n\t{\n\t\tvar objrow = newRow();\n\t\tvar formObj = document.personnel_form;\n\t\tvar params = formObj.params.value;\n\t\tvar mode = formObj.mode.value;\n\t\tvar locale = document.forms[0].locale.value;\n\t\tif(mode==\'I\'){\n\t\t\t if(chkEmpty()){\n\t\t\t if(alreadyExist()){\n\t\t\t\t  var obj = formObj.pract_type;\n\t\t\t\t  var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;\n\t\t\t\t  objrow.pract_type=formObj.pract_type.value;\n\t\t\t\t  objrow.desc_userdef=formObj.pract_type.options[obj.selectedIndex].text;\n\t\t\t\t//  objrow.desc_userdef=formObj.desc_userdef.value;\n\t\t\t\t  objrow.practitioner_id=formObj.practitioner_id.value;\n\t\t\t\t  objrow.practitioner_name=formObj.practitioner_name.value;\n\n\t\t\t\t  objrow.db_mode=\'I\';\n\t\t\t\t  objrow.recId = getRecId();\n\t\t\t\t  objrow.position_desc=getPositionDesc(formObj.practitioner_id.value,locale);\n\t\t\t\t  if(checkForDeletedRecords()==false)\n\t\t\t\t  rows.push(objrow);\n\t\t\t\t  resetFields();\n\t\t\t\t parent.parent.parent.intra_anesth_tab_details_frame.personal_details_frame.location.href=\'../../eOT/jsp/AT_IntraAnaesPersonalDetails.jsp?\'+params;\n\t\t\t\t \n\t\t\t\t  parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t   }else { \n\t\t\t\t\t//commented below line by Anitha\n\t\t\t\t\t//var msg =getLabel(\"CODE_ALREADY_EXISTS\",\"Common\");\n\t\t\t\t\tvar msg =getMessage(\"CODE_ALREADY_EXISTS\",\"Common\");\n\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t   }\n\t\t}//mandatory_check\n    }//if part of mode Check Ends Here\n}\n\n\nfunction chkEmpty(){\n\tvar formObj = document.personnel_form;\n\tvar fields = new Array(formObj.pract_type,formObj.practitioner_name);\n\n\tvar practitionerType =getLabel(\"Common.practitionertype.label\",\"Common\");\n\tvar practitionerName =getLabel(\"Common.practitionername.label\",\"Common\");\n\tvar names = new Array(practitionerType ,practitionerName);\n\tvar messageFrame = parent.parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n function alreadyExist()\n {\n\tvar formObj = document.personnel_form;\n\tvar codeDtl = parent.frames[1].code;\n\tvar rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;\n\tvar practitioner_id=formObj.practitioner_id.value;\n\tvar codeRecord = practitioner_id;\n\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n }\n\n\tfunction getRecId()\n\t{\n\t\tvar rowLength= parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_len;\n\t\tvar recId = rowLength+1;\n\t\t parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_len =  recId;\n\t\treturn recId;\n\t}\n\nfunction resetFields()\n{\n\tvar frmObj = document.personnel_form;\n\tfrmObj.mode.value=\'I\';\n\tfrmObj.pract_type.value=\'\';\n\tfrmObj.desc_userdef.value=\'\';\n\tfrmObj.practitioner_id.value=\'\';\n\tfrmObj.practitioner_name.value=\'\';\n\n\tfrmObj.practitioner_name.disabled=false;\n\tfrmObj.pract_type.disabled=false;\n\tfrmObj.generic_search.disabled=false;\n\tfrmObj.select_button.disabled=false;\n\n}\n\nfunction splitString(strVal)\n{\n\tvar arr = strVal.split(\'::\');\n\tvar frmObj = document.forms[0];\n\tfrmObj.pract_type.value=arr[0];\n\tfrmObj.desc_userdef.value=arr[1];\n\tfrmObj.practitioner_id.value=arr[2];\n\tfrmObj.practitioner_name.value=arr[3];\n\tfrmObj.recId.value=arr[4]\n\tfrmObj.mode.value=arr[5];\n\tfrmObj.practitioner_name.disabled=true;\n\tfrmObj.pract_type.disabled=true;\n\tfrmObj.generic_search.disabled=true;\n\tfrmObj.select_button.disabled=true;\n}\n\nfunction removeRow(){\n var formObj = document.personnel_form;\n var mode = formObj.mode.value;\n var recId = formObj.recId.value;\n var params = formObj.params.value;\n var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;\n if(rows.length>0&& mode==\'U\'){        \n for(var jj=0;jj<rows.length;jj++){\n if(rows[jj]!=null  && rows[jj].recId!=null && rows[jj].recId!=\"\") {\n\t if(rows[jj].recId==recId ){\n      if(rows[jj].db_mode==\'L\')\n\t    rows[jj].db_mode=\'D\';\n\t  else\n\t\tdelete rows[jj];\n\t   break;\n\t }\n  }else\n\tcontinue;\n }//end for-Loop\n  resetFields();\n   parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n  \nparent.parent.parent.intra_anesth_tab_details_frame.personal_details_frame.location.href=\'../../eOT/jsp/AT_IntraAnaesPersonalDetails.jsp?\'+params;\n}else\n   resetFields();\n}\n\nfunction clearPractitioner()\n{\n\tdocument.forms[0].practitioner_id.value=\"\";\n\tdocument.forms[0].practitioner_name.value=\"\";\n\n}\n\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onLoad=\"\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"personnel_form\" id=\"personnel_form\" >\n<input type = \"hidden\"  name=\'params\' id=\'params\'  value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" > \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table cellpadding=3  cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\n\t<tr>\n\t\t<td align=\"right\" class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td>\n\t\t<td  align=\"left\" width=\'25%\' >\n\t\t\n\t\t<select name=\'pract_type\' id=\'pract_type\' OnChange=\'clearPractitioner();\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >\n\t\t<option value=\'\'>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</option>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</select>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\n\t\t<td align=\"right\" class=\"label\" width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</td>\n\t\t<td align=\"left\" class=\"label\" width=\'25%\'>\n\t\t\t<input type=\"text\"  name=\"practitioner_name\" id=\"practitioner_name\" size=\'15\' value=\"\" onblur=\"if(this.value!=\'\')callPractitioners(this); else practitioner_id.value=\'\';\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\t\t\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"\">\n\t\t\t<input type=\"button\" class=\"button\" name=\"generic_search\" id=\"generic_search\" value=\"?\" onclick=\"callPractitioners(practitioner_name);\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td align=\"left\" class=\"label\"></td>\n\t\t\t<td align=\"left\" class=\"label\"></td>\n\t\t\t\t<td align=\"left\" class=\"label\"></td>\n\t\t<td align=\"right\" class=\'label\' >\n\t\t\t<input type=\'button\' name=\'select_button\' id=\'select_button\'class=\'button\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onClick=\'addRow();\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n\t\t\t<input type=\'button\' name=\'cancel_button\' id=\'cancel_button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n\t\t</td>\n\t</tr>\n</table>\n   <!-- added by Rajesh for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<!-- end -->\n\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' >\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >\n<input type=\'hidden\' name=\'anesthesia_srl_no\' id=\'anesthesia_srl_no\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' >\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'refresh_flag\' id=\'refresh_flag\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'desc_userdef\' id=\'desc_userdef\' >\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n </form>\n</body>\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String) session.getAttribute("LOCALE");	
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String params		= request.getQueryString() ;
	String facility_id	= request.getParameter("facility_id");
	String anaesthesia_srl_no	= request.getParameter("anesthesia_srl_no");
	String intraop_done_yn	= request.getParameter("intraop_done_yn");
	String accession_num	= request.getParameter("accession_num");
	String disable_flag="";
	if(intraop_done_yn.equalsIgnoreCase("Y"))
		disable_flag="disabled";
	else if(intraop_done_yn.equalsIgnoreCase("N") || 	intraop_done_yn.equalsIgnoreCase(""))
	
	disable_flag="";
	String refresh_flag="1";
String trace="0";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(params));
            _bw.write(_wl_block10Bytes, _wl_block10);


	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rs1=null;

	trace = "1";
	//Added ORDER BY B.ROLE_DESC in below query for IN024272 on 10/6/2010 by AnithaJ
	String sql_pra="SELECT B.ROLE_TYPE, B.ROLE_DESC,A.PRACTITIONER_ID,C.PRACTITIONER_NAME,A.ROLE_ID FROM  AT_PERSONNEL A, OT_ROLES_LANG_VW B, AM_PRACTITIONER_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID =? AND A.ANAESTHESIA_SERIAL_NUM =? AND	 A.PRACT_TYPE = B.ROLE_TYPE AND A.PRACTITIONER_ID = C.PRACTITIONER_ID AND A.ROLE_ID=B.ROLE_ID ORDER BY B.ROLE_DESC";
	String sql_ot =	"SELECT  A.ROLE_TYPE PRACT_TYPE, A.PRACTITIONER_ID, B.PRACTITIONER_NAME, ROLE_ID, GET_DESC('"+locale+"','OT_ROLES_LANG_VW','ROLE_DESC','ROLE_ID',ROLE_ID) ROLE_DESC FROM OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER_LANG_VW B WHERE  OPERATING_FACILITY_ID = ? AND B.LANGUAGE_ID=? AND OPER_NUM = ? AND A.PRACTITIONER_ID = B.PRACTITIONER_ID AND B.PRACTITIONER_ID NOT IN (SELECT PRACTITIONER_ID FROM AT_PERSONNEL WHERE OPERATING_FACILITY_ID= ? AND ANAESTHESIA_SERIAL_NUM = ? )";
	try{
	trace = "2";
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql_pra);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,anaesthesia_srl_no);
		rs = pstmt.executeQuery();
		int index = 0;
	trace = "3";
		while(rs.next()){
			index++;
		out.println("<script>loadDBRows('"+rs.getString("ROLE_TYPE")+"##"+rs.getString("ROLE_ID")+"','"+rs.getString("ROLE_DESC")+"','"+rs.getString("PRACTITIONER_ID")+"','"+rs.getString("PRACTITIONER_NAME")+"','"+index+"','L','"+locale+"','1'); </script>");	
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		if(index==0){
			    
				trace = "4";
				pstmt = con.prepareStatement(sql_ot);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locale);		    
				pstmt.setString(3,accession_num);
				pstmt.setString(4,facility_id);				
				pstmt.setString(5,anaesthesia_srl_no);				
				rs = pstmt.executeQuery();
				while(rs.next()){
					index++;
					trace = "4.1";	out.println("<script>loadDBRows('"+rs.getString("PRACT_TYPE")+"##"+rs.getString("ROLE_ID")+"','"+rs.getString("ROLE_DESC")+"','"+rs.getString("PRACTITIONER_ID")+"','"+rs.getString("PRACTITIONER_NAME")+"','"+index+"','L','"+locale+"','2'); </script>");	
				trace = "4.2";				
			}
			trace = "5";
		}
		trace = "6";
		out.println("<script>assignRecId()</script>");
		out.println("<script>refresh()</script>");


            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);


		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		String pract_sql="SELECT ROLE_DESC, ROLE_TYPE ,ROLE_ID FROM OT_ROLES_LANG_VW WHERE  LANGUAGE_ID=? AND APPL_TO_OT_SLATE='N' AND NVL(STATUS,'E') = 'E'";
		pstmt=con.prepareStatement(pract_sql);
		pstmt.setString(1,locale);
		rs1=pstmt.executeQuery();
		while(rs1!=null && rs1.next())
		{
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs1.getString("ROLE_TYPE")+"##"+rs1.getString("ROLE_ID")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs1.getString("ROLE_DESC")));
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		if(rs1!=null)rs1.close();
		if(pstmt!=null)pstmt.close();
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{
			if(rs!=null)rs.close();
			if(rs1!=null)rs1.close();
			if(pstmt!=null)pstmt.close();
		    ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
		
	
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(params));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(anaesthesia_srl_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(refresh_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
