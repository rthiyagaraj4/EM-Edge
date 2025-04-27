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
import eOT.Common.OTRepository;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __nursingdisposalrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/NursingDisposalRecord.jsp", 1709120258000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\'javascript\'>\n\nfunction Class_disposalrow(){\n     this.anatomical_code=\"\";\n\t this.anatomical_desc=\"\";\n\t this.disposal_code =\"\";\n     this.disposal_desc =\"\";\n\t this.given_by=\"\";\n\t this.received_by=\"\";\n     this.db_mode=\"\";\n\t this.recId =\"\";\n}\n\n/*function disableDocLevel(){\n   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   formObj.doc_level.disabled=true;\n}*/\n\nfunction loadDBRows(str){ \n  var objrow = newRow();\n  var arr = str.split(\"::\");\n  var rows=parent.parent.ObjectCollect.disposal_rows;\n  var rowLength=parent.parent.ObjectCollect.disposal_len;\n   //alert(\"rowLength=\"+rowLength);\n   if(arr[7]==\'L\' && rowLength==0)\n\t{\n\t   objrow.anatomical_code = arr[0];\n\t   objrow.anatomical_desc = unescape(arr[1].replace(/\\+/g,\" \"));\n\t   //objrow.anatomical_desc = decodeURIComponent(arr[1]);\n\t   objrow.disposal_code= arr[2];\n\t  // objrow.disposal_desc= decodeURIComponent(arr[3].replace(\"+\",\" \"));\n\t  \t //objrow.given_by = decodeURIComponent(arr[4].replace(\"+\",\" \"));\n\t   //objrow.received_by = decodeURIComponent(arr[5].replace(\"+\",\" \"));\n   \t   //Added decodeURIComponent for 26039 on 1/21/2011 by AnithaJ\n\n\t   objrow.disposal_desc= decodeURIComponent(arr[3],\"UTF-8\").replace(/\\+/g,\" \");\n\t   objrow.given_by= decodeURIComponent(arr[4],\"UTF-8\").replace(/\\+/g,\" \");\n\t   objrow.received_by= decodeURIComponent(arr[5],\"UTF-8\").replace(/\\+/g,\" \");\n\t   objrow.recId=arr[6];\n\t   objrow.db_mode=arr[7];\n\t   rows.push(objrow);\n\t}\n}\n\n\n\nfunction addRow(){\n  var objrow = newRow();\n  var formObj = document.DisposalRecordForm;\n  var mode = formObj.mode.value;\n  if(mode==\'I\'){\n\t\t if(chkEmpty()){\t\n\t\t if(alreadyExist()){\n\t\t\t\t  var rows = parent.parent.ObjectCollect.disposal_rows;\n\t\t\t\t  objrow.anatomical_code =formObj.anatomical_site_code.value; \n\t\t\t\t  objrow.anatomical_desc=formObj.anatomical_site_desc.value;\n\t\t\t\t  objrow.disposal_code=formObj.disposal_code.value;\n\t\t\t\t  objrow.disposal_desc=formObj.disposal_desc.value;\n\t\t\t\t  objrow.given_by = formObj.given_by.value;\n\t\t\t\t  objrow.received_by = formObj.received_by.value;\n\t\t\t\t  objrow.db_mode=\'I\';\n\t\t\t\t  objrow.recId = getRecId();\n\t\t\t\t  rows.push(objrow);\n\t\t\t\t  resetFields();\n\t\t\t\t parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingDisposalDtls.jsp\';\n\t\t\t\t  parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t   }else { //else part of alreadyExist method\n\t\t\t\t\n\t\t\t\tvar msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n\t\t\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t   }\n\t\t}//End of chkEmpty \n    }else {//else part of mode \n\tif (chkEmpty())\t{\n\t\tupdateRow();\n\t}\n\t}\n}\n\n\nfunction updateRow(){\n var formObj = document.DisposalRecordForm;\n var rows=parent.parent.ObjectCollect.disposal_rows;\n var mode = formObj.mode.value;\n\n var recId = formObj.recId.value;\n\n if(rows.length>0 && mode==\'U\'){        \n for(var jj=0;jj<rows.length;jj++){\n if(rows[jj]!=null ) {\n      if(rows[jj].recId==recId){\n\t\t \n\t\t  rows[jj].anatomical_code=formObj.anatomical_site_code.value;\t\n\t\t  rows[jj].anatomical_desc=formObj.anatomical_site_desc.value;\n\t\t  rows[jj].disposal_code=formObj.disposal_code.value;\n\t\t  rows[jj].disposal_desc=formObj.disposal_desc.value;\n\t\t  rows[jj].given_by = formObj.given_by.value;\n\t\t  rows[jj].received_by = formObj.received_by.value;\n\t\t  if(rows[jj].db_mode==\'L\')\n\t\t\trows[jj].db_mode=\'U\'\n\t\t    break;\n\t  }\n  }else  \n\t  continue;\n }\n   \n   resetFields();\n   parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingDisposalDtls.jsp\';\n }\n}\n\n\nfunction assignRecId(){\n\tvar rows = parent.parent.ObjectCollect.disposal_rows;\n\tparent.parent.ObjectCollect.disposal_len=rows.length;\n\t\n\t\n}\n\n\nfunction getRecId(){\n    var rowLength=parent.parent.ObjectCollect.disposal_len;\n\tvar recId = rowLength+1;\n\tparent.parent.ObjectCollect.disposal_len  =  recId;\n\treturn recId;\n}\n\n\nfunction removeRow(){\n var formObj = document.DisposalRecordForm;\n var mode = formObj.mode.value;\n var recId = formObj.recId.value;\n var rows = parent.parent.ObjectCollect.disposal_rows;\n if(rows.length>0&& mode==\'U\'){        \n for(var jj=0;jj<rows.length;jj++){\n if(rows[jj]!=null ) {\n\t if(rows[jj].recId==recId ){\n      if(rows[jj].db_mode==\'L\')\n\t    rows[jj].db_mode=\'D\';\n\t  else\n\t\tdelete rows[jj];\n\t   break;\n\t }\n  }else\n\tcontinue;\n }//end for-Loop\n   resetFields();\n   parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n   parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingDisposalDtls.jsp\';\n }else\n   resetFields();\n}\n\nfunction newRow()\n{\n   var objrow = new Class_disposalrow();\n    return(objrow);\n}\n\nfunction chkEmpty(){\n\tvar formObj = document.DisposalRecordForm;\n\tvar fields = new Array(formObj.anatomical_site_desc,formObj.disposal_desc,formObj.given_by,formObj.received_by);\n\tvar disposedItem= getLabel(\"eOT.DisposedItem.Label\",\"OT\");\n\tvar\tdisposal     = getLabel(\"eOT.Disposal.Label\",\"OT\");\n\tvar\tgivenBy\t\t =getLabel(\"Common.givenby.label\",\"Common\");\n\tvar\treceivedBy\t= getLabel(\"Common.ReceivedBy.label\",\"Common\");\n\t\n\tvar names = new Array(disposedItem,disposal,givenBy,receivedBy);\n\tvar messageFrame = parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n\nfunction alreadyExist(){\n\tvar formObj = document.DisposalRecordForm;\n\tvar codeDtl = parent.parent.RecordFrame.DetailFrame.code; \n\tvar rows = parent.parent.ObjectCollect.disposal_rows;\n\tvar anatomical_code=formObj.anatomical_site_code.value;\n\tvar disposal_code = formObj.disposal_code.value;\n\tvar codeRecord = anatomical_code+disposal_code;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n }\n\n\n\nfunction resetFields()\n{\n\tvar frmObj = document.forms[0];\n\tfrmObj.anatomical_site_code.value=\'\';\n\tfrmObj.anatomical_site_desc.value=\'\';\n\tfrmObj.disposal_code.value=\'\';\n\tfrmObj.disposal_desc.value=\'\'\n\tfrmObj.given_by.value=\'\';\n\tfrmObj.received_by.value=\'\';\n\tfrmObj.mode.value=\'I\';\n\tfrmObj.recId.value=\'\'\n\tfrmObj.anatomicalLookUp.disabled=false;\n\tfrmObj.disposalLookUp.disabled=false;\n\tfrmObj.anatomicalLookUp.focus();\n}\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar frmObj = document.forms[0];\n\tfrmObj.anatomical_site_code.value=arr[0];\n\tfrmObj.anatomical_site_desc.value=arr[1];\n\tfrmObj.disposal_code.value=arr[2];\n\tfrmObj.disposal_desc.value=arr[3];\n\t//frmObj.given_by.value=arr[4];\n\tfrmObj.given_by.value=decodeURIComponent(arr[4],\"UTF-8\").replace(/\\+/g,\" \");\n\tfrmObj.received_by.value=decodeURIComponent(arr[5],\"UTF-8\").replace(/\\+/g,\" \");\n\t//frmObj.received_by.value=arr[5];\n\tfrmObj.recId.value=arr[6];\n\tfrmObj.mode.value=arr[7];\n\tfrmObj.anatomicalLookUp.disabled=true;\n\tfrmObj.disposalLookUp.disabled=false;\n\t\n}\n\nfunction refresh(){\n\tvar formObj = document.forms[0];\n\tvar params = formObj.params.value;\n\t//parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingDisposalDtls.jsp?\'+params;\n\tparent.DetailFrame.location.href=\'../../eOT/jsp/NursingDisposalDtls.jsp?\'+params;\n}\n\nfunction checkForSpecCharsSymbol(event){\n\tvar strCheck = \"+%\";\n\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\tif (strCheck.indexOf(key) != -1) return false;  // Not a valid key\n\treturn true ;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<form name=\'DisposalRecordForm\' id=\'DisposalRecordForm\' >\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr> \n\t<td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td> \n\t<td class=\"fields\" width=\'25%\'>\n\t   <input type=\'hidden\' name=\'anatomical_site_code\' id=\'anatomical_site_code\'>\n\t\t<input type=\'text\' name=\'anatomical_site_desc\' id=\'anatomical_site_desc\' size=\'15\'  value=\'\'    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" onBlur=\"if(this.value!=\'\')searchAnatomicalSite(anatomical_site_code,anatomical_site_desc);\">\n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'anatomicalLookUp\' id=\'anatomicalLookUp\' onClick=\'searchAnatomicalSite(anatomical_site_code,anatomical_site_desc);\'  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n<!--  </tr>\n\n<tr> -->\n\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td> \n\t<td class=\"fields\" width=\'25%\'>\n\t\t\t<input type=\'hidden\' name=\'disposal_code\' id=\'disposal_code\'>\n\t\t\t<input type=\'text\' name=\'disposal_desc\' id=\'disposal_desc\' size=\'15\'  value=\'\'  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" onBlur=\"if(this.value!=\'\')searchDisposal(disposal_code,disposal_desc);\">\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'disposalLookUp\' id=\'disposalLookUp\' onClick=\'searchDisposal(disposal_code,disposal_desc);\'  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </td> \n\t<td class=\"fields\" width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'given_by\' id=\'given_by\' size=\'15\'  maxlength=\'100\' onkeypress=\"return checkForSpecCharsSymbol(event);\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n<!-- </tr>\n<tr> -->\n\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td> \n\t<td class=\"fields\" width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'received_by\' id=\'received_by\' size=\'15\' maxlength=\'100\' onkeypress=\"return checkForSpecCharsSymbol(event);\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\n\t</td>\n</tr>\n\n<tr>  <td></td>\n      <td></td>\n\t<td class=\"button\" width=\'25%\' colspan=\'2\'>\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onClick=\'addRow();\'  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n\t\t\n\t</td>\n</tr>\n</table>\n<!-- added by Sathish for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<!-- end -->\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n</form>\n</body>\n</html>\n\t\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");

request.setCharacterEncoding("UTF-8");
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 String params = request.getQueryString(); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String  nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String disable_flag="";
	if( nursing_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";

	/*String anatomical_code="";
	String anatomical_desc="";
	String disposal_code="";
	String disposal_desc="";
	String received_by="";
	String given_by="";*/
	    
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_DISPOSAL_DTLS_SELECT")) ;
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		pstmt.setString(4,locale);
		rst = pstmt.executeQuery();
		int index = 0;
		while(rst.next()){
			index++;
			/*anatomical_code=rst.getString("SITE_CODE");
			//anatomical_desc=replace(rst.getString("SITE_DESC"));
			anatomical_desc=java.net.URLEncoder.encode(rst.getString("SITE_DESC"),"UTF-8");
			disposal_code=rst.getString("DISP_CODE");
			//disposal_desc=replace(rst.getString("DISP_DESC"));
			disposal_desc=java.net.URLEncoder.encode(rst.getString("DISP_DESC"),"UTF-8");
			given_by = java.net.URLEncoder.encode(checkForNull(rst.getString("GIVEN")),"UTF-8");
			received_by = java.net.URLEncoder.encode(checkForNull(rst.getString("RECEIVED")),"UTF-8");*/
			String args = rst.getString("SITE_CODE")+"::"+java.net.URLEncoder.encode(rst.getString("SITE_DESC"),"UTF-8")+"::"+rst.getString("DISP_CODE")+"::"+java.net.URLEncoder.encode(rst.getString("DISP_DESC"),"UTF-8")+"::"+java.net.URLEncoder.encode(checkForNull(rst.getString("GIVEN")),"UTF-8")+"::"+java.net.URLEncoder.encode(checkForNull(rst.getString("RECEIVED")),"UTF-8")+"::"+index+"::"+"L";
				
				out.println("<script>loadDBRows('"+args+"'); </script>");	

		}
		out.println("<script>refresh()</script>");
		out.println("<script>assignRecId()</script>");
	}catch(Exception e){
		 System.err.println("Err Msg in Nursing Disposal Records"+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
	

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disable_flag));
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

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DisposedItem.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Disposal.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.givenby.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedBy.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
