package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import java.sql.Types;
import java.util.*;
import com.ehis.util.*;

public final class __specimenrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SpecimenRecord.jsp", 1709120360000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<HTML>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/CheckOutFromOR.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n<script language=\'javascript\'>\n\nfunction Class_row(){\n  this.specimen_dtls =\"\";\n  this.dept_desc =\"\";\n  this.dept_code =\"\";\n  this.quantity =\"\";\n  this.recId=\"\";\n  this.db_mode=\"\";\n}\nfunction disableDocLevel(){\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\tvar formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   \n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n}\nfunction loadDBRows(specimen_dtls,dept_code,dept_desc,quantity,index,mode){ \n  var objrow = newRow();\n  var rows=parent.parent.ObjectCollect.specimen_rows;\n  var rowLength=parent.parent.ObjectCollect.specimen_len;\n  if(mode==\'L\' && rowLength==0){\n\t  //Added decodeURIComponent below for IN024246 on 10/7/2010 by AnithaJ\n\t  objrow.specimen_dtls=decodeURIComponent(specimen_dtls);\n\t  objrow.dept_code=dept_code;\n\t  objrow.dept_desc=unescape(dept_desc);\n\t  objrow.quantity=quantity;\n\t  objrow.db_mode=\"L\";\n\t  objrow.recId = index;\n\t  rows.push(objrow);\n\t}\n}\nfunction refresh(){\n\tvar formObj = document.forms[0];\n\tvar params = formObj.params.value;\n\t  parent.DetailFrame.location.href=\'../../eOT/jsp/SpecimenDtls.jsp?\'+params;\n}\t\nfunction addRow(){\n  var objrow = newRow();\n  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  var rows=parent.parent.ObjectCollect.specimen_rows;\n  var formObj = document.SpecimenRecordForm;\n  var mode =formObj.mode.value;\n  if(chkEmpty()){\n\tif(mode==\'I\'){\n\t   if(alreadyExist()){\n\t\t   objrow.specimen_dtls=formObj.specimen_dtls.value;\n\t\t   objrow.dept_code=formObj.dept_code.value;\n\t\t   objrow.dept_desc=formObj.dept_desc.value;\n\t\t   objrow.quantity=formObj.quantity.value;\n\t\t   objrow.db_mode=\"I\";\n\t\t   objrow.recId = getRecId();\n\t\t   rows.push(objrow);\n\t\t   resetFields();\n\t\t   parent.DetailFrame.location.href=\'../../eOT/jsp/SpecimenDtls.jsp\';\n\t\t\t parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\t \n\t} else{\n\t\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t}\n\t}else\n\t  updateRow();\n  }\n}\nfunction newRow(){\n  var objrow = new Class_row();\n   return(objrow);\n}\n\n\nfunction alreadyExist(){\n\tvar formObj = document.SpecimenRecordForm;\n\tvar codeDtl = parent.DetailFrame.code; \n\tvar rows = parent.parent.ObjectCollect.specimen_rows;\n\tvar specimen_dtls=formObj.specimen_dtls.value;\n\tvar dept_code = formObj.dept_code.value;\n\tvar codeRecord = specimen_dtls+dept_code;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n }\n\n function assignRecId(){\n\tvar rows = parent.parent.ObjectCollect.specimen_rows;\n\tparent.parent.ObjectCollect.specimen_len=rows.length;\n\t\n}\n\nfunction getRecId(){\n    var rowLength=parent.parent.ObjectCollect.specimen_len;\n\tvar recId = rowLength+1;\n\tparent.parent.ObjectCollect.specimen_len  =  recId;\n\treturn recId;\n}\n\nfunction chkEmpty(){\n\t\n\tvar specimenDetails_title=getLabel(\"Common.SpecimenDetails.label\",\"Common\");\n\tvar department_title=getLabel(\"Common.department.label\",\"Common\");\n\tvar quantity_title=getLabel(\"Common.Quantity.label\",\"Common\");\n\tvar formObj = document.SpecimenRecordForm;\n\tvar chk_out_flag=formObj.recovery_in_out_flag.value\n\tvar function_id=formObj.function_id.value\n\tvar fields = new Array(formObj.specimen_dtls,formObj.dept_desc,formObj.quantity);\n\tvar names = new Array(specimenDetails_title,department_title,quantity_title);\n\tvar messageFrame = parent.parent.messageFrame;\n\tif(chk_out_flag==\"CHECK_OUT_RECO\"){\n\t\tparent.parent.frames[0].location.href=\"../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&recovery_in_out_flag=CHECK_OUT_RECO&function_id=OT_CHECKOUT_FROM_RECOVERY&function_name=Check-Out%20From%20Recovery%20Room&called_from=OT_SLATE\";\n\t\t\n\t}else if(function_id==\"OT_CHECKOUT_FROM_OR\"){\n\t\tparent.parent.frames[0].location.href=\"../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&function_id=OT_CHECKOUT_FROM_OR&function_name=Check-Out%20From%20OR&called_from=OT_SLATE\";\n\t}\n\tif(checkFields( fields, names, messageFrame))\n\t\n\t\n\treturn true;\n}\n\nfunction removeRow(){\nvar formObj = document.SpecimenRecordForm;\nvar rows=parent.parent.ObjectCollect.specimen_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nif(rows.length>0 && mode==\'U\'){        \n  for(var jj=0;jj<rows.length;jj++){\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\t\t\t if(rows[jj].db_mode==\'L\')\n\t\t\t\trows[jj].db_mode=\'D\';\n\t\t\t else\n\t\t\t  delete rows[jj];\n\t\t\t   break;\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n resetFields();\n parent.DetailFrame.location.href=\'../../eOT/jsp/SpecimenDtls.jsp\';\n parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}else\n   resetFields();\n}\n\nfunction updateRow(){\n\tvar formObj = document.SpecimenRecordForm;\n\tvar specimen_dtls = formObj.specimen_dtls.value;\n\tvar dept_code =  formObj.dept_code.value;\n\tvar dept_desc =  formObj.dept_desc.value;\n\tvar quantity =  formObj.quantity.value;\n\tvar mode =formObj.mode.value\n\tvar recId = formObj.recId.value;\n\tvar rows=parent.parent.ObjectCollect.specimen_rows;\n\t\tif(rows.length>0 && mode==\'U\'){        \n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\tif(rows[jj]!=null) {\n\t\t\t\t\tif(rows[jj].recId==recId){\n\t\t\t\t\t\trows[jj].specimen_dtls=specimen_dtls;\t\n\t\t\t            rows[jj].dept_code=dept_code;\n\t\t\t\t\t\trows[jj].dept_desc=dept_desc;\n\t\t\t            rows[jj].quantity=quantity;\n\t\t\t\t\t\tif(rows[jj].db_mode==\'L\')\n\t\t\t\t\t\t\trows[jj].db_mode=\'U\'\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n      resetFields();\n\t  parent.DetailFrame.location.href=\'../../eOT/jsp/SpecimenDtls.jsp\';\n }\n}\n\n\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar frmObj = document.SpecimenRecordForm;\n\tfrmObj.specimen_dtls.value=arr[0];\n\tfrmObj.dept_code.value=arr[1];\n\tfrmObj.dept_desc.value = arr[2];\n\tfrmObj.quantity.value=arr[3];\n\tfrmObj.recId.value=arr[4];\n\tfrmObj.mode.value=arr[5];\n\tfrmObj.dept_desc.disabled=true;\n\tfrmObj.specimen_dtls.disabled=true;\n\tfrmObj.DeptLookUp.disabled=true;\n}\n\nfunction resetFields(){\n\tvar frmObj = document.SpecimenRecordForm;\n\tfrmObj.specimen_dtls.value=\'\';\n\tfrmObj.dept_desc.value=\'\';\n\tfrmObj.quantity.value=\'\';\n\tfrmObj.mode.value=\'I\';\n\tfrmObj.DeptLookUp.disabled=false;\n\tfrmObj.dept_desc.disabled=false;\n\tfrmObj.specimen_dtls.disabled=false;\n\tfrmObj.specimen_dtls.focus();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name = \'SpecimenRecordForm\'>\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\n<BODY OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<script>refresh()</script>\n\t<script>assignRecId()</script>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<input type=\'hidden\' name=\'lab_module_yn\' id=\'lab_module_yn\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t <td class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </td>\n      <td>\n\t\t<input type=\'text\' name=\'specimen_dtls\' id=\'specimen_dtls\' maxlength=\'27\' size=\'27\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >\n\t\t <!-- Commented against ML-BRU-SCF-1054 by MuthuN on 10/3/2013\n\t\t\t   <img src=\'../../eCommon/images/mandatory.gif\'></img>-->\n\t  </td>\n\n\t  <td class=\"label\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td>\n\t  <td class=\"fields\" >\n\t\t  <input type=\'hidden\' name=\'dept_code\' id=\'dept_code\' > \n\t\t  <input type=\'text\' name=\'dept_desc\' id=\'dept_desc\' maxlength=\'15\'   ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" onBlur=\"if(this.value!=\'\')searchDepartment(dept_code,dept_desc);else dept_code.value=\'\'\"> \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'DeptLookUp\' id=\'DeptLookUp\' onClick=\'searchDepartment(dept_code,dept_desc);\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" > \n\t\t  <!-- Commented against ML-BRU-SCF-1054 by MuthuN on 10/3/2013\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>-->\n\t  </td>\n </tr>\n<tr>\n\t <td class=\"label\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </td>\n     <td class=\"fields\" >\n\t\t<input type=\'text\' name=\'quantity\' id=\'quantity\' maxlength=\'3\' size=\'2\' onkeypress=\"return checkForSpecCharsforID(event);\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" > \n\t\t<!-- Commented against ML-BRU-SCF-1054 by MuthuN on 10/3/2013\n\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\'></img>-->\n\t</td>\n<td></td>\n<td class=\"button\">\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onClick=\'addRow();disableDocLevel();\'  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n\t</td>\n</tr>\n</table>\n   <!-- added by Rajesh for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<!-- end --><input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\'hidden\' name=\'recovery_in_out_flag\' id=\'recovery_in_out_flag\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
 
	String encode(String data){	  
	  byte byteData[] = data.getBytes();
		String outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block3Bytes, _wl_block3);
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
 
	String recovery_in_out_flag = CommonBean.checkForNull(request.getParameter("recovery_in_out_flag")); 
	String function_id = CommonBean.checkForNull(request.getParameter("function_id")); 

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(!recovery_in_out_flag.equals("CHECK_OUT_RECO")){ 
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
 String params = request.getQueryString(); 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);


	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String  nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String disable_flag="",lab_module_yn="",SQL="";

	if(nursing_doc_comp_yn.equals("Y") && function_id.equals("OT_CHECKOUT_FROM_OR") )
{
	  disable_flag="";
}else if(nursing_doc_comp_yn.equals("Y") && function_id.equals("OT_CHECKOUT_FROM_RECOVERY") )
{
	disable_flag="";
}else if(nursing_doc_comp_yn.equals("Y") && function_id.equals(""))
{
	   disable_flag="disabled";
}
  	
	String SQL_AM = "SELECT A.SPECIMEN_DTL,A.DEPT_CODE,B.SHORT_DESC,A.QTY FROM OT_POST_OPER_SPECIMENS A, AM_DEPT_LANG_VW B WHERE B.language_id='"+locale+"' and  A.DEPT_CODE = B.DEPT_CODE  AND OPERATING_FACILITY_ID=? AND OPER_NUM=?"; 
	String SQL_RL = "SELECT A.SPECIMEN_DTL,A.DEPT_CODE,B.SHORT_NAME SHORT_DESC,A.QTY FROM OT_POST_OPER_SPECIMENS A, RL_SECTION_CODE B WHERE  A.DEPT_CODE = B.SECTION_CODE  AND OPERATING_FACILITY_ID=? AND OPER_NUM=?"; 
	
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		lab_module_yn=cstmt.getString(2);
		if(lab_module_yn.indexOf("RL|")>=0)
			SQL=SQL_RL; // When RL is  Operational
		else
			SQL=SQL_AM; //When RL is not Operational

	pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		int index = 0;
		while(rst.next()){
			index++;
			out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPECIMEN_DTL"))+"','"+CommonBean.checkForNull(rst.getString("DEPT_CODE"))+"','"+encode(CommonBean.checkForNull(rst.getString("SHORT_DESC")))+"','"+CommonBean.checkForNull(rst.getString("QTY"))+"','"+index+"','L'); </script>");	

		}
	
            _bw.write(_wl_block12Bytes, _wl_block12);

		
	}catch(Exception e){
		 System.err.println("Err Msg in Specimen Records"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(cstmt!=null)cstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(lab_module_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
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
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(recovery_in_out_flag));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SpecimenNoDtl.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.department.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
