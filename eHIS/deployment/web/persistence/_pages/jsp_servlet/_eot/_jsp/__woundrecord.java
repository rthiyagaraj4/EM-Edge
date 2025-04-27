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
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __woundrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/WoundRecord.jsp", 1709120426000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n<HEAD>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordSurgeon.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<!-- <script language=\"javascript\" src=\"../../eOT/js/OTMessages.js\"></script>\n -->\n \n <script language=\"JavaScript\">\n\n/*function updateWoundText(){\n\tvar formObjCommon =parent.parent.ObjectCollect;\n\tvar formObj = document.forms[0];\n\tformObjCommon.diagnosis_text=formObj.wound_txt.value;\n\talert(parent.parent.ObjectCollect.wound_text)\n}*/\n\nfunction refresh(){\n\tvar params = document.forms[0].params.value;\n\t parent.DetailFrame.location.href=\'../../eOT/jsp/WoundDtls.jsp?\'+params;\n}\n\nfunction Class_row()\n{\n  this.speciality_code =\"\";\n  this.speciality_desc=\"\";\n  this.wound_code=\"\";\n  this.wound_desc=\"\";\n  this.db_mode=\"\";\n  this.recId=\"\";\n}\n\nfunction loadDBRows(speciality_code,speciality_desc,wound_code,wound_desc,index,mode){ \n  var objrow = newRow();\n  var rows=parent.parent.parent.ObjectCollect.wound_rows;\n  //var rowLength=rows.length;\n  var rowLength=parent.parent.parent.ObjectCollect.wound_len; //Modified on 13/02/2009 for display  problem of records.\n  \n  if(mode==\'L\' && rowLength==0){\n\t  objrow.speciality_code=speciality_code;\n\t  objrow.speciality_desc=speciality_desc;\n\t  objrow.wound_code=wound_code;\n\t  objrow.wound_desc=unescape(wound_desc);\n\t  objrow.recId = index;\n\t  objrow.db_mode=\"L\";\n\t  rows.push(objrow);\n\t }\n}\n\nfunction addRow(){\n  var objrow = newRow();\n  var msg = trimString(getMessage(\"SPECIALITY_DUPLICATE\",\"OT\"));\n  var rows=parent.parent.parent.ObjectCollect.wound_rows;\n  var formObj = document.WoundRecordForm;\n  var params = formObj.params.value;\n  var mode =formObj.mode.value;\n  var obj = formObj.speciality;\n  if(chkEmpty()){\n\tif(mode==\'I\'){\n\t   if(alreadyExist()){\n\t\t  objrow.speciality_code=formObj.speciality.value;\n\t\t  objrow.speciality_desc=formObj.speciality.options[obj.selectedIndex].text;\n\t\t  objrow.wound_code=formObj.wound_code.value;\n\t\t  objrow.wound_desc=formObj.wound_txt.value;\n\t\t  objrow.recId = rows.length+1;\n\t\t  objrow.db_mode=\"I\";\n\t\t  rows.push(objrow);\n\t\t  resetFields();\n\t\t  parent.DetailFrame.location.href=\'../../eOT/jsp/WoundDtls.jsp?\'+params;\n\t\t  parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t} else{\n\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t}\n\t\t}else\n\t\t  updateRow();\n\t  }\n}\n\nfunction newRow(){\n  var objrow = new Class_row();\n   return(objrow);\n}\n\nfunction alreadyExist(){\n\tvar formObj = document.WoundRecordForm;\n\tvar codeDtl = parent.DetailFrame.code; \n\tvar codeRecord = formObj.speciality.value;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n}\n\nfunction removeRow(){\nvar formObj = document.WoundRecordForm;\nvar params = formObj.params.value;\nvar rows=parent.parent.parent.ObjectCollect.wound_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nvar data_exist = getMessage(\"APP-OT0195\",\"OT\");\nif(rows.length>0 && mode==\'U\'){        \n  for(var jj=0;jj<rows.length;jj++){\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\t\t\t if(rows[jj].db_mode==\'L\'){\n\t\t\t\talert(data_exist);\n\t\t\t    break;\n\t\t\t }\n\t\t\t else {\n\t\t\t\tdelete rows[jj];\n\t\t\t\tresetFields();\n\t\t\t\tparent.DetailFrame.location.href=\'../../eOT/jsp/WoundDtls.jsp?\'+params;\n\t\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\t    break;\n\t\t\t }\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n \n}else\n   resetFields();\n}\n\nfunction updateRow(){\n\tvar formObj = document.WoundRecordForm;\n\tvar params = formObj.params.value;\n\tvar\twound_code=formObj.wound_code.value;\n\tvar\twound_desc=formObj.wound_txt.value;\n\tvar mode =formObj.mode.value;\n\tvar recId = formObj.recId.value;\n\tvar rows=parent.parent.parent.ObjectCollect.wound_rows;\n\t\tif(rows.length>0 && mode==\'U\'){        \n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\tif(rows[jj]!=null) {\n\t\t\t\t\tif(rows[jj].recId==recId){\n\t\t\t\t\t\trows[jj].wound_code=wound_code;\n\t\t\t\t\t\trows[jj].wound_desc=wound_desc;\n\t\t\t\t\t\tif(rows[jj].db_mode==\'L\')\n\t\t\t\t\t\t   \trows[jj].db_mode=\'U\';\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n      resetFields();\n\t parent.DetailFrame.location.href=\'../../eOT/jsp/WoundDtls.jsp?\'+params;\n }\n}\n\nfunction chkEmpty(){\n\treturn true;\n}\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar formObj = document.WoundRecordForm;\n\tformObj.speciality.value=arr[0];\n//alert \n//  alert( \'wound code \'+ arr[1]);\n//Modified by DhanasekarV against issue 27263 on 05/05/2011\n\tformObj.wound_code.value=arr[2];\n\tformObj.wound_txt.value = arr[3];\n\tformObj.recId.value = arr[4];\n\tformObj.mode.value = arr[5];\n\tformObj.speciality.disabled=true;\n}\n\nfunction resetFields(){\n\tvar formObj = document.WoundRecordForm;\n\tformObj.wound_code.value=\'\';\n\tformObj.wound_txt.value=\'\';\n\tformObj.mode.value=\'I\';\n\tformObj.WoundLookUp.focus();\n\tformObj.speciality.disabled=false;\n}\n\n function assignSpeciality(){\n\tvar formObjHdr = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar doc_level = formObjHdr.doc_level.value;\n\tif(document.forms[0].tab.value !=\"record_surgeon\")\n\t{\n\tcallPopulateList(doc_level);\n\t}else\n\t{\n\t\t\tif(doc_level==\"IS\")\n\t\t{\n\t\t\t\tvar facility_id=document.forms[0].facility_id.value;\n\t\t\t\tvar db_mode=parent.parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value;\n\t\t\t\tvar status_value=parent.parent.parent.frames[4].RecordSurgeonTabForm.status_value.value;\n\t\t\t\tvar oper_code_all=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value;\n\t\t\t\tvar oper_code_new=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value;\n\t\t\t\tvar spec_code_final=parent.parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value;\n\t\t\t\tvar oper_num=document.forms[0].oper_num.value;\n\t\t\t\tvar arr2=oper_code_all.split(\"*\");\n\t\t\t\tvar arr3=status_value.split(\"*\");\n\t\t\t\tvar arr1=db_mode.split(\"*\");\n\t\n\t\t\t\tvar oper_code=\"\";\n\t\t\t\tvar chk_status=\"\";\n\t\t\t\tvar db_mode_val=\"\";\n\t\t\t\t\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t    xmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=exist_operation_speciality&spec_code_final=\"+spec_code_final,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar arr_spec=retVal.split(\"*\");\n\t\t\t\tvar spec_code_new=\"\";\n\t\t\t\tvar spec_code_old=\"\";\n\t\t\t\tvar arr2_spec=\"\";\n\t\t\t\tvar opt =\"\";\n\t\t\t\tfor (var m=0;m<arr_spec.length-1;m++ )\n\t\t\t\t{\n\t\t\t\t\tspec_code_new=arr_spec[m];\n\t\t\t\t\t arr2_spec=spec_code_new.split(\",\");\n\t\t\t\t\t opt = parent.frames[0].document.createElement(\'OPTION\');\n\t\t\t\t\topt.text =arr2_spec[1];\n\t\t\t\t\topt.value=arr2_spec[0];\n\t\t\t\t\tdocument.forms[0].speciality.add(opt);\n\t\t\t\t}\n}else\n\t\t{\n\t\t\tassignListItems(\'*ALL\',\'All Specialities\');\n\t\t}\n\t}\n\t\t\t\n}\n\nfunction disableDocLevel(){\n\tvar formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   if(formObj.doc_level.disabled==false)\n\t   formObj.doc_level.disabled=true;\n}\nfunction assignRecId(){\n\tvar rows = parent.parent.parent.ObjectCollect.wound_rows;\n\tparent.parent.parent.ObjectCollect.wound_len=rows.length;\n\t//alert(rows.length);\n\t\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<body onLoad=\"assignSpeciality()\">\n<form name = \"WoundRecordForm\">\n<input type=\'hidden\' name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" >\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n<tr> \n\t<td class=\'label\' nowrap>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</td>\n\t <td class=\'fields\'>\n\t\t  <select name=\"speciality\" id=\"speciality\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >\n\t\t   </select>\n\t </td>\n\t <td></td>\n</tr>\n<tr>\n\t<td class=\'label\' valign=\'top\' nowrap>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</td>\n\t<td class=\'fields\'>\n\t\t<input type=\"hidden\" name=\"wound_code\" id=\"wound_code\" valign=\'top\'>\n\t\t<textarea name=\'wound_txt\' rows=\'5\' cols=\'35\' readonly ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" > </textarea>\n\t\t<td class=\'label\' align=\'left\' valign=\'top\' nowrap >\n\t\t<input type=\'button\' name=\'WoundLookUp\' id=\'WoundLookUp\' class=\'button\' value=\'?\' onClick=\'searchWoundText(wound_code,wound_txt);\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >\n\t\t</td>\n\t</td>\n</tr>\n<tr>\n    <td width=\"25%\"></td>\n\t<td width=\"25%\"></td>\n\t<td width=\"25%\"></td>\n\t<td width=\"25%\"></td>\n<td class=\'label\' nowrap colspan=3>\n  \n\t<input type=\'button\' name=\'record\' id=\'record\' class=\'button\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onClick=\'addRow();disableDocLevel()\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n\t<input type=\'button\' name=\'cancel\' id=\'cancel\' class=\'button\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n</td>\n\n</tr>\n</table>\n<!-- added by Sathish for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<!-- end -->\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'tab\' id=\'tab\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<!-- Added below hidden field on march 1,2011 by Anitha -->\n<input type=\'hidden\' name=\'tab_id\' id=\'tab_id\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n</form>\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

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

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
 
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
		String tab = CommonBean.checkForNull(request.getParameter("tab")); 

	String disable_flag="";
	if(surgeon_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";
	//String SQL = "SELECT A.SPECIALITY_CODE SPL_CODE,DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities',B.SHORT_DESC) SPL_DESC,A.WOUND_TYPE WOUND_CODE,C.WOUND_TEXT WOUND_DESC FROM OT_POST_OPER_DTL2 A,AM_SPECIALITY B,OT_WOUND_TYPE C WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.WOUND_TYPE=C.WOUND_TYPE_CODE(+) AND A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=?";


	String SQL = "SELECT A.SPECIALITY_CODE SPL_CODE,DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities',B.SHORT_DESC) SPL_DESC,A.WOUND_TYPE WOUND_CODE,C.WOUND_TEXT WOUND_DESC FROM OT_POST_OPER_DTL2 A,AM_SPECIALITY B,OT_WOUND_TYPE_LANG_VW C WHERE C.LANGUAGE_ID(+)='"+locale+"' AND A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.WOUND_TYPE=C.WOUND_TYPE_CODE(+) AND A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=?";
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
System.err.println("SQL :" +SQL);
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			++index;
		out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(rst.getString("WOUND_CODE"))+"','"+CommonBean.checkForNull(rst.getString("WOUND_DESC"))+"','"+index+"','L'); </script>");
			
		}
		out.println("<script>assignRecId();</script>");
		out.println("<script>refresh();</script>");
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg in WoundRecord.jsp"+e.getMessage());
	} finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}


            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(CommonBean.checkForNull(request.getParameter("tab_id"))));
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.WoundType.Label", java.lang.String .class,"key"));
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
