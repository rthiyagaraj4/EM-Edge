package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.text.SimpleDateFormat;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifyinsupldimghdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyInsUpldImgHdr.jsp", 1743576263594L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!-- \nSr No        Version              TFS\t\t\t\t\tSCF/CRF\t\t           \t    Developer Name\n-------------------------------------------------------------------------------------------------------\n1\t    V220728\t\t33245\t\t\t\tRBU-GHL-CRF-0005 US001\t\t\tMohanapriyaK\n-->\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script Language=\"javascript\" src=\"../../eCommon/js/ScanDocument.js\"></script>\t\n\t\n\t<script >\n\n\t$(document).ready(function(){\n\t$(\'#scanDoc\').attr(\'disabled\',\'disabled\');\n\t$.ajax({\n\t\ttype : \'POST\',\n\t\turl : \"../jsp/ScannerFunctionAjaxcall.jsp\",\n\t    dataType : \"text\",\n\t\tdata: { operation:\'SCANNER_ENABLED\' },\n\t\tasync:false,\n\t\tsuccess : function(data) {\t\t\t\n\t\t\tvar obj=jQuery.parseJSON(data);\t\t\t\t\n\t\t\tif(obj.Flag==\"True\")\n\t\t\t{\t\t\t\t\n\t\t\t\t$(\'#scanDoc\').removeAttr(\'disabled\');\n\t\t\t}else {\n\t\t\t\t$(\'#scanDoc\').attr(\'disabled\',\'disabled\');\n\t\t\t}\t\t\n\t\t}\n\t});\n\t\n \t$(\"#scanDoc\").click(function(){\n  \t\t\tvar currentdate = new Date(); \n\t\t\tvar documentId =  \"BL\" + currentdate.getDate() \n\t\t\t                + (currentdate.getMonth()+1)  \n\t\t\t                + currentdate.getFullYear()   \n\t\t\t                + currentdate.getHours()   \n\t\t\t                + currentdate.getMinutes() \n\t\t\t                + currentdate.getSeconds()\n\t\t\t\t\t\t\t+ currentdate.getMilliseconds();\n\t\t\n\t\t\tif(validateForm()){\n\t\t\t\t//Scanner Interface is Called here with 4 Parameters{ Patient_ID(If present),Document Type,Document_ID, Validation Object }\n\t\t\t\t//alert($(\"#patient_id\").val());\n\t\t\t\tvar patientId=document.getElementById(\"patient_id\").value;\n\t\t\t\tvar retVal=ShowScanner(patientId,\'FN\',documentId,this);\n\n\t\t\t\t$.ajax({\n\t\t\t\t\ttype : \'POST\',\n\t\t\t\t\turl : \"../jsp/ScannerImagePersistance.jsp\",\n\t\t\t\t    dataType : \"text\",\n\t\t\t\t\tdata: { \n\t\t\t\t\t\toperation:\'LOAD_SCANNED_IMAGE\',\n\t\t\t\t\t\tdocId: documentId,\n\t\t\t\t\t\tpayrGrpCode: $(\'#payrGrpCode\').val(),\n\t\t\t\t\t\tpayrCode:$(\'#payrCode\').val(),\n\t\t\t\t\t\tplcyCode:$(\'#plcyCode\').val(),\n\t\t\t\t\t\tplcyNo:$(\'#plcyNo\').val(),\n\t\t\t\t\t\tplcystartDate:$(\'#plcystartDate\').val(),\n\t\t\t\t\t\tplcyExpryDate:$(\'#plcyExpryDate\').val()\t\n\t\t\t\t\t},\n\t\t\t\t\tasync:false,\n\t\t\t\t\tsuccess : function(data) {\n\n\t\t\t\t\t\t\tvar obj=jQuery.parseJSON(data);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(obj.Flag==\"SUCCESS\")\n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\talert(\"Scanned Image loaded Successfully\");\n\t\t\t\t\t\t\t\tparent.frames[1].document.location.href=\"../../eBL/jsp/AddModifyInsUpldImgDtl.jsp\";\t\n\t\t\t\t\t\t\t\tresetHdr();\n\t\t\t\t\t\t\t}else {\n\t\t\t\t\t\t\t\talert(\"Scanned Image is not Loaded\");\n\t\t\t\t\t\t\t}\t \t\t\t\n\t\t\t\t\t}\n\t\t\t\t});\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\talert(\"Some fields doesnt have values\");\n\t\t\t}\n\t  });\n});\n\nfunction selectCheck(obj,obj1)\t\n{\n\tvar objBut = document.forms[0].addBut;\n\n\tif (obj.checked)  \t\n\t{\n\t\tobj1.value = \'Y\';\t\n\t\tobjBut.value = \'Remove\';\n\t\tdocument.getElementById(\'Add\').name =\'Remove\';\n\t\talert(document.getElementById(\'Add\').name);\n\t}\n\telse\n\t{\n\t\tobj1.value = \'N\';\n\t\tobjBut.value = \'Add\';\n\t}\n}\n\n</script>\n<!--  ADDED FOR GHL_CRF_0550 PALANI NARAYANAN  STARTS-->\n<script>\n\nfunction ChooseContact(obj,creditAuthNo,creditAuthDate) {\t\n\tif(obj.value==\"\" && creditAuthNo!=null)\n\t{\n\t\tdocument.getElementById (\"docRemarks\").value = getLabel(\"Common.Select.label\",\"Common\");\n\t\tif(document.getElementById (\"docRemarks\").value!=null)\n\t\t{\n\t\t\tdocument.getElementById (\"docRemarks\").value=\'\';\n\t\t}//modified by Mohanapriya 21-04-20\n\t\tdocument.getElementById(\"astr\").style.display = \"none\";\n\t\tdocument.getElementById(\"creditAuthNo\").disabled=true;\n\t\tdocument.getElementById(\"creditAuthDate\").disabled=false;\n\t\tdocument.getElementById (\"creditAuthDate\").value = \"\";\n\t}\n\tif(obj.value==\"A\")\n\t{\n\t\tdocument.getElementById (\"docRemarks\").value = getLabel(\"Common.AadharCard.label\",\"Common\");\n\t\tdocument.getElementById(\"astr\").style.display = \"none\";\n\t\tdocument.getElementById(\"creditAuthNo\").disabled=false;\n\t\tdocument.getElementById (\"creditAuthNo\").value = \"\";\n\t\tdocument.getElementById(\"creditAuthDate\").disabled=false;\n\t\tdocument.getElementById (\"creditAuthDate\").value = \"\";\n\t\t//Added by Mohanapriya  21-04-20\n\t\tif(document.getElementById(\"credit_img\").disabled=true){\n\t\t\tdocument.getElementById(\"credit_img\").disabled=false;\n\t\t}\n\t}\n\tif(obj.value==\"L\")\n\t{\n\t\tdocument.getElementById(\"astr\").style.display = \"block\";\n\t\tdocument.getElementById (\"docRemarks\").value = getLabel(\"eBL.AuthorizationLetter.label\",\"eBL\");\n\t\tdocument.getElementById(\"creditAuthNo\").disabled=true;\n\t\tdocument.getElementById(\"creditAuthDate\").disabled=true;\n\t\tdocument.getElementById(\"credit_img\").disabled=true;//modified by Mohanapriya 21-04-20\n\t\tdocument.getElementById (\"creditAuthNo\").value = creditAuthNo;\n\t\tdocument.getElementById (\"creditAuthDate\").value = creditAuthDate;\n\t}\n\tif(obj.value==\"P\")\n\t{\n\t\tdocument.getElementById (\"docRemarks\").value = getLabel(\"eBL.PanCard.label\",\"eBL\");\n\t\tdocument.getElementById(\"astr\").style.display = \"none\";\n\t\tdocument.getElementById(\"creditAuthNo\").disabled=false;\n\t\tdocument.getElementById (\"creditAuthNo\").value = \"\";\n\t\tdocument.getElementById(\"creditAuthDate\").disabled=false;\n\t\tdocument.getElementById (\"creditAuthDate\").value = \"\";\t\n\t\t//Added by Mohanapriya  21-04-20\n\t\tif(document.getElementById(\"credit_img\").disabled=true){\n\t\t\tdocument.getElementById(\"credit_img\").disabled=false;\n\t\t}\n\t}\n\tif(obj.value==\"T\")\n\t{\n\t\tdocument.getElementById (\"docRemarks\").value = getLabel(\"eBL.Passport.label\",\"eBL\");\n\t\tdocument.getElementById(\"astr\").style.display = \"none\";\n\t\tdocument.getElementById (\"creditAuthNo\").value = \"\";\n\t\tdocument.getElementById(\"creditAuthDate\").disabled=false;\n\t\tdocument.getElementById (\"creditAuthDate\").value = \"\";\n\t\t//Added by Mohanapriya  21-04-20\n\t\tif(document.getElementById(\"credit_img\").disabled=true){\n\t\t\tdocument.getElementById(\"credit_img\").disabled=false;\n\t\t}\n\t}\n\tif(obj.value==\"O\")\n\t{\n\t\tdocument.getElementById (\"docRemarks\").value = getLabel(\"Common.others.label\",\"Common\");\n\t\tdocument.getElementById(\"astr\").style.display = \"none\";\n\t\tdocument.getElementById(\"creditAuthNo\").disabled=false;\n\t\tdocument.getElementById (\"creditAuthNo\").value = \"\";\n\t\tdocument.getElementById(\"creditAuthDate\").disabled=false;\n\t\tdocument.getElementById (\"creditAuthDate\").value = \"\";\n\t\t//Added by Mohanapriya  21-04-20\n\t\tif(document.getElementById(\"credit_img\").disabled=true){\n\t\t\tdocument.getElementById(\"credit_img\").disabled=false;\n\t\t}\n\t}\n}\n</script>\n<!--  ADDED FOR GHL_CRF_0550 PALANI NARAYANAN  ENDS-->\n\n<script type=\"text/javascript\">\nfunction chkRemarksField(obj) {\t\n   if (obj.value==\"\" ) \n   {\t   \n\t alert(\"Doc Type Cannot Be Blank\");\n   }\n}\n\n//V220728\nfunction getSize() {\n     //var myFSO = new ActiveXObject(\"Scripting.FileSystemObject\");\n\t var myFSO = \"\";\n     var filepath = document.IMG_UPLOAD.InsImage.value;\n     var thefile = myFSO.getFile(filepath);\n     var size = thefile.size;\n     var sizeInMB = (size / (1024*1024)).toFixed(2);\n     if(sizeInMB>2){\n    \t alert(\"Uploading File size must be less than 2MB\");\n    \t return false;\n     }else{\n    \t return true;\n     }\n}\n//V220728\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\'../js/InsUpldImage.js\'></script> \n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body onMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\" >\n<form name=\"IMG_UPLOAD\" id=\"IMG_UPLOAD\"  id=\"IMG_UPLOAD\" action=\"../../servlet/eBL.BLInsImageUploadServlet\" method=\"post\" enctype=\"multipart/form-data\">\n\t    <table  align=\"center\" cellpadding=3 cellspacing=0 border=0 width=\"100%\"  scrolling=\"auto\" >\t\t\t\n\t\t<tr>\n\t\t\t<td class=\"label\" nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</td>\n\t\t\t<td class=\"fields\">\n\t\t\t\t&nbsp;<select id=\"episode_type\" name=\"episode_type\" id=\"episode_type\"  style=\"width: 70px;\" onchange=\'clearPayerFields();\'>\n\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option>\n\t\t\t\t\t<option value=\"O\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t\t<option value=\"I\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\n\t\t\t\t\t<option value=\"D\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t\t\t<option value=\"E\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t\t<option value=\"R\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t</select>\n\t\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</td>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t<!--&nbsp;<input type=\"text\" name=\"episode_id\" id=\"episode_id\" id=\"episode_id\"  maxlength=\"30\"  onBlur=\"if(this.value!=\'\'){return episodetypevalidation(); }\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >-->\n\t\t\t\t\t&nbsp;<input type=\"text\" name=\"episode_id\" id=\"episode_id\" id=\"episode_id\"  maxlength=\"30\"  onBlur=\"return episodetypevalidation();\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" > <!-- Modified Against ICN:74031-->\n\t\t\t\t\t<input type=\'hidden\' name=\'hdnEpisode_id\' id=\'hdnEpisode_id\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'episode_type_ins\' id=\'episode_type_ins\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'visit_id_ins\' id=\'visit_id_ins\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'episode_id_ins\' id=\'episode_id_ins\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'encounter_id_ins\' id=\'encounter_id_ins\'>\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"episode_idbut\" id=\"episode_idbut\" value=\'?\' onClick=\"episodeLookup(episode_id,hdnEpisode_id)\"  tabindex=\'2\' /> \n\t\t  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<!-- Added V191112-Aravindh/GHL-CRF-0550/Starts -->\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t\t<input type=\"text\" name=\"blngGroupDesc\" id=\"blngGroupDesc\" id=\"blngGroupDesc\" size=\"30\" maxlength=\"30\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"  onBlur=\"\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" />\n\t\t\t\t\t<input type=\'hidden\' name=\'blngGrpCode\' id=\'blngGrpCode\' id=\'blngGrpCode\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' />\n\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"blngGroupCls\" id=\"blngGroupCls\" value=\"?\" style=\"visibility:hidden\" onClick=\"callPlcyLookup(1,payerGroupDesc,payrGrpCode)\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" />\n\t\t\t\t</td>\n\t\t\t\t<!-- Added V191112-Aravindh/GHL-CRF-0550/Ends -->\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\"label\" \talign=\"right\" nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" &nbsp;</td><td class=\"label\" \talign=\"right\">\n\t\t\t<input type=\"text\" name=\"payerGroupDesc\" id=\"payerGroupDesc\" size=\"25\" maxlength=\"30\"  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n\t\t\t<input type= \'hidden\'  name=\'payrGrpCode\' id=\'payrGrpCode\' id=\'payrGrpCode\'   value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'><input type=\"button\" class=\"button\" name=\"payerGroupCls\" id=\"payerGroupCls\" value=\"?\" style=\"visibility:hidden\" onClick=\"callPlcyLookup(1,payerGroupDesc,payrGrpCode)\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" />\n\t\t\t</td>\n\n\t\t\t<td class=\"label\" \talign=\"left\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;</td><td class=\"label\" \talign=\"right\">\n\t\t\t<input type=\"text\" name=\"payer\" id=\"payer\" size=\"30\" maxlength=\"30\"  value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"\t  onBlur=\"\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="><input type= \"hidden\"  name=\"payrCode\" id=\"payrCode\" id=\'payrCode\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" ><input type=\"button\" class=\"button\" style=\"visibility:hidden\" name=\"payerCls\" id=\"payerCls\" value=\"?\" onClick=\"callPlcyLookup(2,payer,payrCode,payrGrpCode)\"  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="></td>\t\t\t\t\n\n\t\t\t<td class=\"label\"  align=\"left\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t&nbsp;</td>\n\t\t\t<td class=\"label\" \talign=\"right\">\n\t\t\t<input type=\"text\" name=\"plcy\" id=\"plcy\" size=\"30\" maxlength=\"30\"  value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="><input type= \"hidden\"  name=\"plcyCode\" id=\"plcyCode\" id=\"plcyCode\"  value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" ><input type=\"button\" style=\"visibility:hidden\" class=\"button\" name=\"plcyCls\" id=\"plcyCls\" value=\"?\" onClick=\"callPlcyLookup(3,plcy,plcyCode)\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="></td>\t\t\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td class=\"label\" \talign=\"left\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;</td><td class=\"label\" \talign=\"right\"><input type=\"text\" id=\'plcyNo\' name=\"plcyNo\" id=\"plcyNo\" size=\"10\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =">\n\t\t\t</td>\t\t\t\n\n\t\t\t<td class=\"label\" \talign=\"left\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;</td><td class=\"label\" \talign=\"right\">\n\t\t\t<input type=\"text\" name=\"plcystartDate\" id=\"plcystartDate\" id=\"plcystartDate\" size=\"10\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"   onBlur=\"\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="><img id = \"start_img\" name=\"start_img\"\t  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'plcystartDate\');\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="></td>\n\t\t\t\n\t\t\t<td class=\"label\" width=\"15%\"\talign=\"left\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</td><td class=\"label\" \talign=\"right\">\n\t\t\t<input type=\"\"text\" name=\"plcyExpryDate\" id=\"plcyExpryDate\" id=\"plcyExpryDate\" size=\"10\" maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"   onBlur=\"\"  ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="><img id = \"start_img\" name=\"start_img\"\t  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'plcyExpryDate\');\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="></td>\n\t\t\t<input type = \'hidden\' name =\'cancel\' value =\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t</tr>\n\t\t<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\t\n\t\t<tr>\n\t\t\t<td class=\"label\" \talign=\"right\" nowrap>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" &nbsp;</td>\n\t\t\t<td class=\"label\" \talign=\"right\">\n\t\t\t\t<select onchange=\"ChooseContact(this,\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\',\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\')\" name=\"docType\" id=\"docType\"  style=\"width: 150px;\" >\n\t\t\t\t\t<option value=\"\" >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</option>\n\t\t\t\t\t<option value=\"A\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</option>\n\t\t\t\t\t<option value=\"L\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</option>\n\t\t\t\t\t<option value=\"P\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</option>\n\t\t\t\t\t<option value=\"T\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\"label\" align=\"left\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t<td class=\"label\" align=\"right\" >\n\t\t\t\t <input type=\"text\" name=\"docRemarks\" id=\"docRemarks\" id=\"docRemarks\" size=\"20\" maxlength=\"20\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" onclick=\"chkRemarksField(this);\"  />\n\t\t\t\t \n\t\t\t<!-- <input type=\"text\" name=\"docRemarks\" id=\"docRemarks\" id=\"docRemarks\" size=\"35\" /> -->\t\n\t\t\t</td>\n\t\t\t\t\n\t\t\t<td class=\"label\" align=\"left\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;</td>\n\t\t\t<td class=\"label\" align=\"right\" >&nbsp;\n\t\t\t<input type=\"text\" name=\"creditAuthNo\" id=\"creditAuthNo\" id=\"creditAuthNo\" size=\"20\" maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"  >\n\t\t \n\t\t\t<!-- modified by Mohanapriya 21-04-20 -->\n\t\t\t<input type=\"text\" name=\"creditAuthDate\" id=\"creditAuthDate\" id=\"creditAuthDate\" size=\"10\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"  ><img id=\"credit_img\" name=\"credit_img\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'creditAuthDate\');\" >\n\t\t    </td>\n\t\t\t<td>\n\t\t\t\t<img  id=\"astr\" src=\"../../eCommon/images/mandatory.gif\" style=\"display:none;\" cellspaceing=\"0\">\n\t\t\t</td>\n\t\t</tr>\t\t\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->\t\n\t\t<tr>\n\t\t\t<td colspan=\'2\' class=\"label\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" \t\t\t\n\t\t\t\t<input type=\'checkbox\' name=\'CancelChk\' id=\'CancelChk\' value=\"N\" Onclick=\"selectCheck(this,cancel);\" ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="  ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =">\n\t\t\t</td>\n\t\t\t\t\n\t\t\t<td colspan=\'2\'>\n\t\t\t\t<input type=\"button\" name=\'scanDoc\' id=\'scanDoc\' id=\'scanDoc\' value=\"Scan Document\">\n\t\t\t</td> \t\t\t\n\n\t\t\t<td class=\"label\" \talign=\"right\" >\n\t\t\t\t<input type=\"file\" name=\"InsImage\" id=\"InsImage\"  id=\"InsImage\" value=\"\" > \t\t\t\n\t\t\t</td>\t\t\t\n\t\t\t<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->\n\t\t\t<td class=\"label\" align=\"right\" nowrap>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\t\t\t\t\n\t\t\t\t<input type=\"button\" name=\"addBut\" id=\"addBut\" class=\"button\" value=\"Add\" id=\"Add\" onclick=\"if(getSize()){uploadFile_ghl(this);showImage_ghl();disableButton(this);}\" /><!-- //V220728 -->\t\t\t\t\n\t\t\t\t<input type=\"button\" name=\"updateBut\" id=\"updateBut\" class=\"button\" value=\"Update\"  onclick=\"if(getSize()){uploadFile_ghl(this);showImage_ghl();disableButton(this);}\" /><!-- Added V191112-Aravindh/GHL-CRF-0550 //V220728-->\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<input type=\"button\" name=\"addBut\" id=\"addBut\"  class=\"button\"\tvalue=\"Add\" id=\"Add\" onclick=\"uploadFile();showImage();\" />\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\n\t\t\t\t<input type=\"button\" class=\"button\"\t value=\"Close\"  onclick=\"closw();\" />\n\t\t\t</td>\t\t\t\n\t\t</tr>\t\n</table>\n \n<input type= \"hidden\" name=\"mode\" id=\"mode\"  value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n<input type=\"hidden\" name=\"dbload\" id=\"dbload\"  value=\"N\">\n<input type=\'hidden\' id=\'facility_id\' name=\'facility_id\' id=\'facility_id\'  value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\t\t\n<input type=\'hidden\' id=\'locale\' name=\'locale\' id=\'locale\'  value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' >\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'  id=\'patient_id\'   value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" >\n<input type=\'hidden\' name=\'totRec\' id=\'totRec\'  value=\'1\'>\n<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->\n<input type=\'hidden\' name=\'strModuleId\' id=\'strModuleId\'  id=\'strModuleId\'   value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" >\n<input type=\'hidden\' name=\'strfunction_id\' id=\'strfunction_id\'  id=\'strfunction_id\'   value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" >\n<input type=\'hidden\' name=\'smt_ind\' id=\'smt_ind\'  id=\'smt_ind\'   value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n<input type=\"hidden\" name=\"clicked_button\" id=\"clicked_button\" id=\"clicked_button\" value=\"\"/>\n<script>\n</script>\n<input type=\"hidden\" name=\"checked_row\" id=\"checked_row\" id=\"checked_row\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"/>\n<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->\n</form>\n</body>\n</html>\n<script>\nfunction closw(){\n\t \n\t const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t    dialogTag.close();\n}\n</script>\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	String strPatientId = ""+request.getParameter("patient_id");
	strPatientId=(strPatientId==null)?"":strPatientId;
	//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
	String strModuleId= "";
	String strFunctionId = "";
	String Uindex=request.getParameter("index");				 
	session.setAttribute("uindex",Uindex );
	String params = request.getQueryString();
	//GHL-CRF-0550.1
	String totalRecords= checkForNull(request.getParameter("totalRecords"));
	session.setAttribute("totalRecords", totalRecords);
	//GHL-CRF-0550.1
	String strbilling_grp_Name=checkForNull(request.getParameter("billing_grp_Name"));
	session.setAttribute("strbilling_grp_Name", strbilling_grp_Name);
	strModuleId = request.getParameter("strModuleId");
	session.setAttribute("strModuleId", strModuleId);
	strFunctionId = request.getParameter("strfunction_id");
	if (strModuleId == null) strModuleId= ""; 
	if (strFunctionId == null) strFunctionId = "";
	String checkedRow=checkForNull(request.getParameter("checked_row"));
	//GHL-CRF-0550.1
	session.setAttribute("checkedRow", checkedRow);
	String policy_no=checkForNull(request.getParameter("policy_no"));
	session.setAttribute("policy_no", policy_no);
	//GHL-CRF-0550.1
	//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	String episode_type_ins ="";
	if (strModuleId.equals("OP"))  episode_type_ins = "O";
	if (strModuleId.equals("AE"))  episode_type_ins = "E";
	if (strModuleId.equals("IP"))  episode_type_ins = "I";
	if (strModuleId.equals("DC"))  episode_type_ins = "D";
	if (strModuleId.equals("MP"))  episode_type_ins = "R";
	//Ended by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	String smtind="";
	//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes

            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;

	String payerGroupCode="";  
	String  payerGroupDesc="";
	String payerCode="";
	String payerDesc="";
	String policyCode="";
	String policyDesc="";
	String policyNo="";
	String startDate="";
	String endDate="";
	String  strCancelChk ="";
	String chkValue="";
	//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
	String docRemarks="";
	String creditAuthNo="";
	String creditAuthNumber="";
	String creditAuthDate="";
	String docType="";
	String creditAuthDate1="";
	//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
	String billingGroupCode = "", billingGroupDesc = "";//Added V191114-Aravindh/GHL-CRF-0550
	boolean cancelChk;

	String index = request.getParameter("index");
	index= (index==null?"0":index);
	//Added Against Incident No:9983
	/* String index1 = request.getParameter("index1");
	index1= (index1==null?"0":index1); */
	//Added Against Incident No:9983

	String mode  = request.getParameter("mode");	
	mode= (mode==null?"I":mode);

	String sStyle 		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String locale 			= 	(String)session.getAttribute("LOCALE");
	String facilityId		= (String) session.getValue( "facility_id" ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);
 

	String strDisabled= "disabled";
	String strdisableBut= "";
	String strModDisabled="";
	String called_from = request.getParameter("callfrom");
	called_from = (called_from==null)?"":called_from;
	//Added V191028-Aravindh/GHL-CRF-0550
	boolean siteSpecUploadDocAll = false;
	
	try {
			con	=	ConnectionManager.getConnection(request);
			siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
		
	} catch(Exception ex) {
		System.err.println("Error in AddModifyInsUpldImgHdr.jsp for getting Connection: "+ex);
		ex.printStackTrace();
	}
	//Added V191028-Aravindh/GHL-CRF-0550

	if(called_from.equals("CH_PAT"))	
	{
		strModDisabled= "";	
		strdisableBut="";
	}
	else 	
	{
		strdisableBut= "";
		strModDisabled= "";
	}

   if (mode.equals("U"))
   {
	strdisableBut= "disabled";
	strDisabled="";
	strModDisabled= "readonly onfocus='this.blur()'";

	String    bean_id							= 	"bl_blinsuranceimagebean" ;
	String  bean_name						= 	"eBL.BLInsuranceImageBean";
	HashMap 	blInsuranceImageList							=	null;
	BLInsuranceImageBean blInsuranceImageBean 			= 	null;
	BLInsuranceImage	blInsuranceImage = null;	

	blInsuranceImageList	=	new HashMap();
	blInsuranceImageBean	= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
	blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 

	//Added Against Incident No:9983 Starts
	/* BLInsuranceImage	blInsuranceImage1 = null;	
	blInsuranceImage1 	= (BLInsuranceImage)blInsuranceImageList.get(""+index1);
	if(blInsuranceImage1!=null)
	{			
		creditAuthNumber=blInsuranceImage1.getCreditAuthNo();	
		creditAuthNumber=(creditAuthNumber==null) ?  "" : creditAuthNumber;
		creditAuthDate1=blInsuranceImage1.getCreditAuthDate();
		creditAuthDate1=(creditAuthDate1==null) ? "" : creditAuthDate1;
	} */
	//Added Against Incident No:9983 Ends
	
	blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+index);
	if(blInsuranceImage!=null)
	 {			
		 payerGroupCode = blInsuranceImage.getPayerGroupCode();  
		 payerCode    = blInsuranceImage.getPayerCode();  
		 policyCode   = blInsuranceImage.getPolicyCode();  
		 policyNo     = blInsuranceImage.getPolicyNo();  
		 startDate    = blInsuranceImage.getStartDate();  
		 endDate      = blInsuranceImage.getEndDate();  
		 cancelChk    = blInsuranceImage.getCancelMod();
		 //Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes 	
		 billingGroupCode = blInsuranceImage.getBillingGroup();
		 docRemarks=blInsuranceImage.getDocRemarks();			 
		 docRemarks=(docRemarks==null)?"":docRemarks;
		 creditAuthNo=blInsuranceImage.getCreditAuthNo();			 
		 creditAuthDate=blInsuranceImage.getCreditAuthDate();
		 docType=blInsuranceImage.getDocType();
		 //Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
		if(cancelChk==true)	 
		{
			strCancelChk="Y";
			chkValue ="checked";
		}
		else 
		{
			strCancelChk="N";
			chkValue ="";
		}
try  {
		//con	=	ConnectionManager.getConnection(request);
		String sql;

		stmt = con.createStatement();
		sql ="select long_desc description from ar_cust_group_lang_vw 	where status is null and language_id = '"+locale+"'  and cust_group_code ='"+payerGroupCode+"'";

		rs = stmt.executeQuery(sql);
		if(rs.next())
		{
			payerGroupDesc=rs.getString(1);		
		}

		sql="Select long_name description from ar_customer_lang_vw Where language_id = '"+locale+"'  and  cust_code='"+payerCode+"'";  //Modified Against ICN:9943
		rs = stmt.executeQuery(sql);
		if(rs.next())
		{
			payerDesc=rs.getString(1);		
		}

		sql="select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facilityId+"' and language_id= '"+locale+"' and policy_type_code ='"+policyCode+"'";

		rs = stmt.executeQuery(sql);
		if(rs.next())
		{
			policyDesc=rs.getString(1);		
		}

		if(siteSpecUploadDocAll){
			//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
			sql="select long_desc blng_grp_desc from bl_blng_grp_lang_vw where blng_grp_id = '"+billingGroupCode+"' and language_id = '"+locale+"'";

			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				billingGroupDesc = rs.getString("blng_grp_desc");		
			}
		}
		//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
	   }
	   catch(Exception ee)
	   {
			ee.printStackTrace();
	   }
	   finally
	   {
		if(rs != null)   rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(con, request);	
	   }
	   }
   }  

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
 //Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes			  
				if((siteSpecUploadDocAll==true) && !(strModuleId.equals("IP")) && (!strFunctionId.equals("ADMISSION"))&& (!strModuleId.equals("OP")) &&(!strFunctionId.equals("VISIT_REGISTRATION"))) { 
		 
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(episode_type_ins));
            _bw.write(_wl_block21Bytes, _wl_block21);

			if((siteSpecUploadDocAll==true) && !(strModuleId.equals("IP")) && (!strFunctionId.equals("ADMISSION"))&& (!strModuleId.equals("OP")) &&(!strFunctionId.equals("VISIT_REGISTRATION"))) { 
		 
            _bw.write(_wl_block22Bytes, _wl_block22);
  }
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(siteSpecUploadDocAll) { 
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(checkForNull(billingGroupCode)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strModDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(billingGroupCode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strdisableBut));
            _bw.write(_wl_block29Bytes, _wl_block29);
 } 
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(payerGroupDesc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strModDisabled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(payerGroupCode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strdisableBut));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(payerDesc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strModDisabled));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(payerCode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strdisableBut));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(policyDesc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strModDisabled));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(policyCode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strdisableBut));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(policyNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strModDisabled));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(startDate));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strModDisabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strdisableBut));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(endDate));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strModDisabled));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strdisableBut));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strCancelChk));
            _bw.write(_wl_block54Bytes, _wl_block54);
 if(siteSpecUploadDocAll) { 
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(creditAuthNo));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(creditAuthDate));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(docRemarks));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(creditAuthNo));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(creditAuthDate));
            _bw.write(_wl_block69Bytes, _wl_block69);
 } 
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(chkValue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(strDisabled));
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(siteSpecUploadDocAll) { 
            _bw.write(_wl_block74Bytes, _wl_block74);
 } else{
            _bw.write(_wl_block75Bytes, _wl_block75);
 }
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(strFunctionId));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strbilling_grp_Name));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(checkedRow));
            _bw.write(_wl_block84Bytes, _wl_block84);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OP.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IP.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DC.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EM.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EX.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingGroupId.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_START_DATE.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_EXPIRY_DATE.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AadharCard.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AuthorizationLetter.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PanCard.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Passport.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Document.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Remarks.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CreditAuthNoDate.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }
}
