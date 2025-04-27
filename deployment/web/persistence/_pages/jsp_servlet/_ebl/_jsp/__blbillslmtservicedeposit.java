package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.Common.*;
import eBL.*;
import oracle.sql.*;
import webbeans.op.CurrencyFormat;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blbillslmtservicedeposit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtServiceDeposit.jsp", 1737915580486L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script language=\'javascript\' src=\'../../eBL/js/BillReceipt.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\n<script>\nfunction putDecimal_Text(Obj,maxvalue,deci)\n{\n\tvar temp1=$.trim(Obj.text());\n\tvar temp4=temp1.length;\n\tvar count=parseInt(maxvalue) -parseInt(deci);\n\tif (parseInt(deci) > 0)\n\t{\n\t\tif(temp1.indexOf(\'.\') <0)\n\t\t{\n\t\t\tif (temp4 <= parseInt(maxvalue))\n\t\t\t{\n\t\t\t\tif(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)\n\t\t\t\t{\n\t\t\t\t\tvar temp2=temp1.substring(0,count);\n\t\t\t\t\tvar temp3=temp2+\".\"+temp1.substring(count,temp1.length)\n\t\t\t\t\tif(temp3.length-1 < parseInt(maxvalue))\n\t\t\t\t\t{\n\t\t\t\t\t\tfor(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\ttemp3+=\"0\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tObj.text(temp3);\n\t\t\t\t}\n\t\t\t\telse if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)\n\t\t\t\t{\n\t\t\t\t\tvar temp3=temp1+\'.\';\n\t\t\t\t\tfor(var m=0;m<deci;m++)\n\t\t\t\t\ttemp3+=\"0\";\n\t\t\t\t\tObj.text(temp3);\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif (temp1.length == 0 )\n\t\t\t\t{\n\t\t\t \t\ttemp3=\"0.\";\n\t\t\t\t\tfor(var m=0;m<deci;m++)\n\t\t\t\t\ttemp3+=\"0\";\n\t\t\t\t\tObj.text(temp3);\n\t \n\t\t\t\t}\n   \n \n\t\t\t}\n\n\t\t}else{\n\t\t\tvar temp5=temp1.indexOf(\'.\');\n\t\t\tvar temp7=temp1.substring(0,temp5);\n\t\t\tvar temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));\n\t\t\tvar localTemp=\'\';\n\t\t\tvar len=parseInt(deci)-parseInt(temp6.length);\n\t\t\tfor(var m=0;m<len;m++){\n\t\t\t\tlocalTemp+=\'0\';\n\t\t\t}\n\t\t\tObj.text(temp7+\".\"+temp6+localTemp);\n\t\n\t\t}\n\t}\n}\nfunction putdeci(object)\n{\t\t\n\t\n\tif(object.value!=\'\')\n\t{\n\tputDecimal(object,17,2);\n\t}\n\t\n\t\n}\n</script>\n<script type=\"text/javascript\">\n $(document).ready(function(){\n\t \n\t if($(\'#submitBtn\').val() != \'Y\'){\n\t\t $(\'.depositCheckClass\').each(function(){\n\t\t\t$(this).prop(\'disabled\',true); \n\t\t });\n\t\t $(\'#selectedDepositList\').prop(\'disabled\',true);\n\t }\n\t \n\t  $(\"#selectedDepositList\").click(function(){\n\n\t\t  $.ajax({\n                    url:\"../../eBL/jsp/BLBillSlmtServiceDepositStorage.jsp\",\n                    type:\'post\',\n                    data: $(\"#BillSlmtDepositForm\").serialize() + \"&total_records=\"+$(\'#docTypeTable tr\').length + \"&checked_records=\"+$(\"[type=\'checkbox\']:checked\").length,\n                    success: function(data) {\n                        var obj = jQuery.parseJSON(data);\n                        //alert(obj.flag);\n                        if(obj.flag==\"SUCCESS\"){\n                        \tvar adjustedAmt = 0;\n                        \t$(\'[id^=adjustedAmt]\').each(function(){\n                        \t\tadjustedAmt = parseFloat(adjustedAmt) + parseFloat($(this).val());\n                        \t});\n\n                        \t//window.returnValue=$(\"#payableAmount\").val()+\":::\"+adjustedAmt;\n                        \tparent.document.querySelectorAll(\"#dialog-body\")[parent.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = $(\"#payableAmount\").val()+\":::\"+adjustedAmt;\n\n                        \t//window.close();\n                        \tparent.document.querySelectorAll(\"#dialog_tag\")[parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n                        }\n                    }\n\t\t          }); \n   \n\t\t});\n\t  \n\t  $(\"#cancelDepositList\").click(function(){\n\t\t  //window.close();\n\t\t  parent.document.querySelectorAll(\"#dialog_tag\")[parent.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n\t  });\n\t  \n\t  \n\t \n\t $(\".depositCheckClass\").click(function(){\n\t\t\n\t\t var index=$(\'#docTypeTable tr\').index($(this).closest(\'tr\'));\t\n\t\t var noofdecimal=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =";\n\t\t if($(this).prop(\'checked\')==true){\t\n\n\t\t\t var settlement=$(\"#afterAdjustment\").val();\n\t\n\t\t\t if(settlement>0){ // settlement should be Valid a positive number\n\t\t\t\t \n\t\t\t var deposit= $(\"#deposit\"+(index)).val();\n\t\t\t var adjustedAmt=0;\n\t\n\t\t\t if(parseFloat(deposit)>parseFloat(settlement)){\n\t\t\t\t $(\"#adjusted\"+index).text(settlement);\n\t\t\t\t putDecimal_Text($(\"#adjusted\"+index),17,noofdecimal);\n\t\t\t\t $(\"#adjustedAmt\"+index).val(settlement);\n\t\t\t\t $(\"#afterAdjustment\").val(0);\n\t\t\t }else{\n\t\t\t\t $(\"#adjusted\"+index).text(deposit);\n\t\t\t\t putDecimal_Text($(\"#adjusted\"+index),17,noofdecimal);\n\t\t\t\t $(\"#adjustedAmt\"+index).val(deposit);\n\t\t\t\t adjustedAmt=parseFloat(settlement)-parseFloat(deposit);\n\t\t\t\t $(\"#afterAdjustment\").val(adjustedAmt);\n\t\t\t\t putDecimal_field($(\"#afterAdjustment\").get(0),17,noofdecimal);\t\t\t\t \n\t\t\t }\n\t\t\t $(\"#payableAmount\").val(adjustedAmt);\n\t\t\t putDecimal_field($(\"#payableAmount\").get(0),17,noofdecimal);\n\t\t\t \n\t\t \n\t\t\t }else{\n\t\t\t\t alert(\"Settlement Amount is already adjusted from existing deposits\");\n\t\t\t\t $(this).prop(\'checked\', false);\n\t\t\t }\n\t\t }else{\n\t\t\t var deposit= $(\"#deposit\"+ (index) ).val();\n\t\t\t var settlement= $(\"#afterAdjustment\").val();\t\n\t\t\t var adjustedAmt=parseFloat(settlement)+parseFloat($(\"#adjustedAmt\"+index).val());\n\t\t\t $(\"#adjusted\"+index).text(0);\n\t\t\t putDecimal_Text($(\"#adjusted\"+index),17,noofdecimal);\n\t\t\t $(\"#adjustedAmt\"+index).val(0);\n\t\t\t $(\"#afterAdjustment\").val(adjustedAmt);\n\t\t\t $(\"#payableAmount\").val(adjustedAmt);\n\t\t\t putDecimal_field($(\"#payableAmount\").get(0),17,noofdecimal);\t\t\n\t\t }\n\t  });\n\t \n });\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n<HTML>\n<HEAD>\n<TITLE>Adjust from Deposit</TITLE>\n</HEAD>\n</HEAD>\n<BODY>\n<FORM name=\'BillSlmtDepositForm\' id=\'BillSlmtDepositForm\' id=\'BillSlmtDepositForm\'>\n<table  width=\'100%\'> \n<tr>\n<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n</tr>\n</table>\n<div id=\"ageGroupTableDiv\" STYLE=\"width:100%; height:100; overflow: auto;\">\n<table id=\'docTypeTable\' width=\'100%\'> \n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr >\n\t\t<td class=\"fields\"  width=\'10%\'><input class=\'depositCheckClass\' type=\"checkbox\" value=\"true\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="  name=\"adjustChk";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"adjustChk";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"> </td>\n\t\t<td class=\"fields\"  width=\'15%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td><input type=\'hidden\' name=\"docType";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"docType";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  id=\"docType";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<td class=\"fields\"  width=\'15%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td><input type=\'hidden\' name=\"docNumber";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"docNumber";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"  id=\"docNumber";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<td class=\"fields\"  width=\'20%\'><input type=\"text\" name=\"remarks";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"remarks";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  id=\"remarks";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' maxlength=\'100\' ></input></td><input type=\'hidden\' name=\"remarks";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<td class=\"fields\"  width=\'10%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td><input type=\'hidden\' name=\"docSrlNo";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"docSrlNo";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  id=\"docSrlNo";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td><input type=\'hidden\' name=\"slmtType";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"slmtType";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  id=\"slmtType";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\t\t\t\n\t\t<td class=\"fields\"  width=\'10%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td><input type=\'hidden\' name=\"deposit";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"deposit";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"  id=\"deposit";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<td class=\"fields\"  width=\'10%\'><div id=\"adjusted";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</div></td>\t<input type=\'hidden\' name=\"adjustedAmt";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"adjustedAmt";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"  id=\"adjustedAmt";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n<script>\n\t\t\talert(\"Patient Deposit Not Found\");\n\t\t\tparent.window.returnValue=\"N\";\n\t\t\twindow.close();\n</script>\n\t\t  ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</table>\n<br>\n</div>\n\n<table  width=\'100%\' >\n<tr>\n<td class=\"fields\"  width=\'25%\'></td>\n<td class=\"fields\"  width=\'25%\'></td>\n<td class=\"label\" width=\'30%\' >";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n<td class=\"fields\"  width=\'*\'><input type=\"text\" size=10 readonly name=\"payableAmount\" id=\"payableAmount\" id=\"payableAmount\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></td>\n</tr>\n</table>\n\n\n<table  width=\'100%\' >\n<tr>\n<td class=\"fields\"  width=\'25%\'></td>\n<td class=\"fields\"  width=\'25%\'></td>\n<td class=\"fields\"   width=\'30%\' ></td>\n<td class=\"fields\"  width=\'*\'><input class=\'button\' type=\"button\" name=\'cancelDepositList\' id=\'cancelDepositList\' id=\'cancelDepositList\' value=\'Cancel\'></td>\n<td class=\"fields\"  width=\'*\'><input class=\'button\' type=\"button\" name=\'selectedDepositList\' id=\'selectedDepositList\' id=\'selectedDepositList\' value=\'Submit\'></td>\n</tr>\n</table>\n\n</BODY>\n<input type=\"hidden\" id=\"billslmtamtdet\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n<input type=\"hidden\" id=\"afterAdjustment\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n<input type=\"hidden\" id=\"submitBtn\" name=\"submitBtn\" id=\"submitBtn\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n</FORM>\n\n</HTML>\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );
	
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



private String formattedAmt(String amt){
	if(amt==null || amt.equals("")) {
		return "0.00";
	}
CurrencyFormat cf = new CurrencyFormat();		
amt = cf.formatCurrency(amt,2); 
return amt;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString(); 
		String noofdecimal=request.getParameter("noofdecimal");
		System.out.println("gayathriii========"+noofdecimal);
		System.out.println("DepositPage QryString" + params);
		String submitBtn = request.getParameter("submitBtn");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);



String patientid=request.getParameter("patientid");
String strfacilityid	=  (String) session.getValue("facility_id");
int count=0;

String beanId = "BillDetailsBean";
String beanName = "eBL.BLBillDetailsBean";
BLBillDetailsBean bean=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=bean.getBillDtlMap();
System.out.println(billDtlMap);
ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");

StringBuilder docNumList=new StringBuilder();
for(BLBillDetailsBean beanObj:billDetailList ){
	docNumList.append("'");
	docNumList.append(beanObj.getDocNum());
	docNumList.append("'");
	docNumList.append(",");
}
docNumList.deleteCharAt(docNumList.length()-1);

System.out.println(docNumList);
System.out.println(billDetailList);


ARRAY slmt_by_svc_parameter_array = (ARRAY) session.getAttribute("deposit_parameter_array_session");
Object[] recievedArray=null;
if(slmt_by_svc_parameter_array!=null){
recievedArray = (Object[])(slmt_by_svc_parameter_array.getArray());
}

boolean depositAlreadyAdjustedFlag=false;


Connection con	=	ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs = null; 
String sql=BlRepository.getBlKeyValue("MULTI_BILL_SLMT_DEPOSIT_LIST");


System.out.println(sql);

try
{				
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,patientid);
	pstmt.setString(2,strfacilityid);
	pstmt.setString(3,patientid);
	pstmt.setString(4,strfacilityid);
	pstmt.setString(5,patientid);
	rs = pstmt.executeQuery();	

	while ( rs.next() && rs != null ) 
	{
	
		String docType=rs.getString(1);
		String docNumber=rs.getString(2);
		String docSrlNo=rs.getString(3);
		String slmtType=rs.getString(4);
		String deposit=rs.getString(5);
		String adjustedAmount="0";
		String checked="";
       		
		String remarks=BLHelper.getDescriptionViaSQL(con,BlRepository.getBlKeyValue("MULTI_BILL_SLMT_DEPOSIT_REMARK"),patientid,docType,docNumber);
		if(remarks==null) remarks="";
		
		if(recievedArray!=null){
		for(Object tmp : recievedArray) {
			if(tmp!=null){
			Struct row = (Struct) tmp;
			Object[] attribute = row.getAttributes();
			if(attribute[1]!=null && docNumber!=null ){
				if(docNumber.equals(attribute[1].toString()) && docSrlNo.equals(attribute[2].toString())){
					 docType=attribute[0].toString();
					 docNumber=attribute[1].toString();
					 docSrlNo=attribute[2].toString();
					 slmtType=attribute[3].toString();
					 deposit=attribute[4].toString();
					 adjustedAmount=attribute[5].toString();
					 remarks=attribute[6].toString();
					 checked="checked";
					 depositAlreadyAdjustedFlag=true;
				}
			 }
			}
		  }
		}
		
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(docType));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(docType));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(docNumber));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(docNumber));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(docSrlNo));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(docSrlNo));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(slmtType));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(count));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slmtType));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(formattedAmt(deposit)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(count));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(formattedAmt(deposit)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(count));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(formattedAmt(adjustedAmount)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(formattedAmt(adjustedAmount)));
            _bw.write(_wl_block46Bytes, _wl_block46);

		count++;
	}	

}catch(Exception e) 
{   e.printStackTrace();
	System.out.println("Exception in bl_parameters query:"+e);
}finally{
	rs.close();
	pstmt.close();
}

if(count==0){
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

String payableAmount=request.getParameter("billslmtamtdet");
/*if(depositAlreadyAdjustedFlag==true){
payableAmount=formattedAmt((String)session.getAttribute("deposit_adjusted_payable_amount"));
}*/

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(formattedAmt(payableAmount)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(formattedAmt(request.getParameter("billslmtamtdet"))));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(formattedAmt(request.getParameter("billslmtamtdet"))));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(submitBtn ));
            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBSelect.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBDocumentType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBDocumentNumber.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Remarks.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBDocumentSrNo.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBSettlementType.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBAmount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBAdjustedAmount.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IRBAmountPayable.label", java.lang.String .class,"key"));
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
}
