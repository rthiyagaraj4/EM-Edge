package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __manufacturingreceiptslistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ManufacturingReceiptsListResult.jsp", 1720288486195L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--<!DOCTYPE html>-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n<title> </title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eST/js/StTransaction.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eST/js/ManufacturingReceipts.js\"></script>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body>\n<form name=\'formDetail\' id=\'formDetail\' >\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=300 align=center >\n\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t<th >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<script>var short_desc_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="=encodeURIComponent(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");</script>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t//if(!confirm(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'+\' For the Item \'+\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'));\n\t\t\t\t\t\t\t\t\t//alert(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<tr id=\"tr_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<td  width=\'1\' class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"><input type=\'checkbox\' name=\"checkbox";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"checkbox";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ></td>\n\t\t<td width=\'230\' class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\"WORD-BREAK:BREAK-ALL;\"><font size=1>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<img src=\"../images\\info1.gif\" alt=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"  height=12 >&nbsp;\n\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \\n ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" height=12 >&nbsp;\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<img src=\"../images\\info1.gif\" alt=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" height=12 >&nbsp;\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n<!--  commented on 25/11/04\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<a name=\"a_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" href=\"javascript:populateData(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\');\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<br>Quantity:";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;Value:";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</font></a>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</font>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="-->\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',short_desc_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =",\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<br>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;<span style=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</span></font></a>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</span></font>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t<input type=\"hidden\" name=\"qty_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"qty_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"></input><input type=\"hidden\" name=\"child_item_code_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"child_item_code_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"></input><input type=\"hidden\" name=\"child_item_desc_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"child_item_desc_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"></input></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n</table>\n\t<input type=\"hidden\" name=\"total_checkboxes\" id=\"total_checkboxes\"\t\tvalue=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\"hidden\" name=\"records_to_delete\" id=\"records_to_delete\"\t\tvalue=\"\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\"hidden\" name=\"batch_id\" id=\"batch_id\" >\n\t<input type=\"hidden\" name=\"expiry_date\" id=\"expiry_date\" >\n\t<input type=\"hidden\" name=\"bin_location\" id=\"bin_location\" >\n\t<input type=\"hidden\" name=\"trade_id\" id=\"trade_id\" >\n\t<input type=\"hidden\" name=\"process_loss\" id=\"process_loss\" >\n\t<input type=\"hidden\" name=\"batch_function\" id=\"batch_function\" >\n\t<input type=\"hidden\" name=\"composition_for_qty\" id=\"composition_for_qty\" >\n\t<input type=\"hidden\" name=\"checkBoxVals\" id=\"checkBoxVals\" >\n\t<input type=\"hidden\" name=\"baseqty\" id=\"baseqty\" >\n\t<input type=\"hidden\" name=\"finalized_yn\" id=\"finalized_yn\" >\n\t<input type=\"hidden\" name=\"remarks\" id=\"remarks\" > \n\t<input type=\"hidden\" name=\"packed_by\" id=\"packed_by\" >\n\t<input type=\"hidden\" name=\"counter\" id=\"counter\" >\n\t<input type=\"hidden\" name=\"auto_gen_batch_yn\" id=\"auto_gen_batch_yn\" >\n\t<input type=\"hidden\" name=\"sbi\" id=\"sbi\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\"hidden\" name=\"sbn\" id=\"sbn\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" name=\"dflt_mfg_mode\" id=\"dflt_mfg_mode\"\t\tvalue=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\t\t\t\n</form>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n</body>\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\n<script>\n \nvar arr_string = new Array();\nvar Item_Desc=\"\";\nvar Item_First;\nvar Item_sec;\narr_string = formDetail.sbi.value;\n\nif(arr_string != null && arr_string.length > 0) {\n\t\tarr_string      = arr_string.split(\",\");\n\tfor(var i=0;i<arr_string.length;i++) {\n\t\tif (i==0){\n\t\t\tItem_First =arr_string[i];\n\t\t\tItem_First = Item_First+\",\"+\"\\n\";\n\t\t}else{\n\t\t\tfor(var k=i;k<i+3;k++){\n\t\t\t\tif(arr_string[k]!=undefined) \n\t\t\t\t\tItem_Desc = Item_Desc +\",\"+arr_string[k];\n\t\t\t}\n            Item_Desc = Item_Desc+\"\\n\";\n\t\t\ti=k-1;\n\t\t} \n\t }\n\n}\n Item_Desc =Item_Desc.substring(1,Item_Desc.length-1);\n if(Item_Desc.length>0)\n\tItem_Desc=Item_First+Item_Desc;\n  else\n\tItem_Desc =Item_First.substring(0,Item_First.length-2);\n \n alert(getMessage(\"ITEM_STORE_NOT_FOUND\",\"ST\")+\" \"+Item_Desc);\n</script>\t\t\t \n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\t\t\n<script>\n//\t\t\t\talert(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\');\nvar arr_string = new Array();\nvar arr_string1 = new Array();\nvar Item_Desc=\"\";\nvar Item_First=\"\";\nvar Item_sec=\"\";\nvar temp=0;\nvar temp1=0;\narr_string = formDetail.sbn.value;\narr_string1=formDetail.sbi.value;\n\t\nvar arr_string3 = new Array();\n\n\tif((arr_string != null && arr_string.length > 0)&&(arr_string1 != null && arr_string1.length > 0)) {\n\t\tarr_string      = arr_string.split(\",\");\n\t\tarr_string1      = arr_string1.split(\",\");\n\n\t\tfor(var i=0;i<arr_string.length;i++) {\n\t\t\tfor(var j=0;j<arr_string1.length;j++) {\n\t\t\t//alert(\"arr_string1[j]\"+arr_string1[j]+arr_string[i]);\n\t\t\tif(arr_string[i]!=arr_string1[j])\n\t\t\t\t{   temp=temp+1;\n\t\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t temp=0; \t\n\t\t\t\tbreak;\n\t\t\t\t  }\n\t\t\t}\n\t\t\t\t\n\t\t\t\tif(temp!=0)\n\t\t\t\tarr_string3[i]=arr_string[i]\n\t\t}\n\t}else { \n\tif(arr_string != null && arr_string.length > 0) \t\n\t\t{\n\t\t\tarr_string      = arr_string.split(\",\");\n\t\t\tfor(var i=0;i<=arr_string.length;i++) {\n\t\t\t\tarr_string3[i]=arr_string[i];\n\t\t\t}\n\t\t }\n\t}\n\tif(arr_string3 != null && arr_string3.length > 0) {\n\t\tfor(var i=0;i<arr_string3.length;i++) {\n\t\t\t if ((i==0)&&(arr_string3[i]!=undefined)){\n\t\t\t\tItem_First =arr_string3[i];\n\t\t\t\tItem_First = Item_First+\",\"+\"\\n\";\n\t\t\t}else{\n\t\t\t\tfor(var k=i;k<i+3;k++){\n\t\t\t\t\tif(arr_string3[k]!=undefined) \n\t\t\t\t\t\tItem_Desc = Item_Desc +\",\"+arr_string[k];\n\t\t\t\t}\n\t\t\t\tItem_Desc = Item_Desc+\"\\n\";\n\t\t\t\ti=k-1;\n\t\t\t} \n\t\t }\n\t}\n Item_Desc =Item_Desc.substring(1,Item_Desc.length-2);\n\tif(Item_Desc.length>0)\n\t\tItem_Desc=Item_First+Item_Desc;\n\telse\n\t\tItem_Desc =Item_First.substring(0,Item_First.length-3);\n\tif(Item_Desc.length>0)\n\t {\n\t\tItem_Desc =Item_Desc.substring(0,Item_Desc.length-3);\n\t\talert(getMessage(\"INSUFFICIENT_BATCH_QTY\",\"ST\")+\" \"+Item_Desc);\n\t }\n</script>\n     ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t<script language=\"JavaScript\">\n\t\tdocument.getElementById(\"a_\")";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =".scrollIntoView();\n\t\tchangeRowColor(document.getElementById(\"tr_\")";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =");\t\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	int i								=	0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String check						=	"";
	String baseqty						=	"1";
	String alt_text						=	"";
	String ExpiredBatch					=	"";
	//String EWD						=	"";
	String sbi							=	"";  
	String sbn							=	"";
	String display_flag					=	"visibility:hidden";
	String allow_deci_yn        =       "";
	String no_deci              =       "";

	ArrayList ALDetailData				=	new ArrayList();
	ArrayList alDfltList				=	new ArrayList();
	boolean proceed						=	false;
	boolean display						=	true;
	mode								=	request.getParameter( "mode" ) ;
	if(mode==null)
		mode="1";
	function_id							=	request.getParameter( "function_id" ) ;
	
	bean_id								=	"ManufacturingReceiptsBean" ;
	bean_name							=	"eST.ManufacturingReceiptsBean";

	ManufacturingReceiptsBean bean		=	(ManufacturingReceiptsBean) getBeanObject( "ManufacturingReceiptsBean","eST.ManufacturingReceiptsBean", request  );
	bean.setLanguageId(locale);
	ExpiredBatch						=	 bean.checkForNull(bean.getExpiredBatch(),""); 
	//EWD								=	 bean.checkForNull(bean.getEWD(),"");
	String datMode						=	 bean.checkForNull(request.getParameter("datMode"),"Add");
    //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	String dflt_mfg_mode						=	 bean.checkForNull(request.getParameter("dflt_mfg_mode"),"R");
	String expiry						        =	 bean.checkForNull(request.getParameter("expiry"),"");
	
	String composition_for_qty			=	"";
	String ROL_YN						=	"";
	String Min_YN						=	"";
	String doc_no						=	"";

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
		doc_no							=	request.getParameter("doc_no");

	double prep_qty						=	0.0;
	ArrayList al123Exp					=	new ArrayList();
	try { 
			if(datMode.equals("Add")){
				proceed					=	true;
				composition_for_qty		=	request.getParameter("composition_for_qty");
				baseqty					=	request.getParameter("baseqty");

				bean.setComposition_for_qty(composition_for_qty);
				if (baseqty==null || baseqty.equals("") )
					baseqty				=	bean.getReq_qty();
					bean.setBase_qty(baseqty);

			}
			else{
				composition_for_qty		=			bean.getComposition_for_qty();
				baseqty					=			bean.getBase_qty();
				proceed					=			false;
			}
			if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
				ArrayList ALDtlData		=			bean.getDataDtlList();
			
				ArrayList ALExpDataAll	=			bean.getExpDetailsList();
				HashMap ALExpData		=			new HashMap();
				int index				=			0;
				int size				=			ALDtlData.size();
				bean.setBatchDataDisp(doc_no,bean.getDoc_type_code());
		
				ArrayList al123Exptemp	=		new ArrayList();
				for(int j=0;j<size;j++) {
					al123Exptemp = new ArrayList();
						
						if(bean.getDoc_type_code().equals((String)(((HashMap)ALDtlData.get(j)).get("DOC_TYPE_CODE"))) &&  
						bean.getDoc_no().equals((String)(((HashMap)ALDtlData.get(j)).get("DOC_NO")))) {
						ALDetailData.add(ALDtlData.get(j));
						if(proceed){
							index=Integer.parseInt((String)(((HashMap)ALDtlData.get(j)).get("DOC_SRL_NO")) );
							for (int k=0;k<ALExpDataAll.size();k++){
							if(bean.getDoc_type_code().equals((String)(((HashMap)ALExpDataAll.get(k)).get("DOC_TYPE_CODE"))) &&  
									bean.getDoc_no().equals((String)(((HashMap)ALExpDataAll.get(k)).get("DOC_NO"))) && 
									index==(Integer.parseInt((String)(((HashMap)ALExpDataAll.get(k)).get("DOC_SRL_NO")) )) ){
				
									ALExpData	=		(HashMap)ALExpDataAll.get(k);
									al123Exptemp.add(ALExpData);
								}
							}
							al123Exp.add(al123Exptemp);
						}
					}
				}
			}
		   else{
				ALDetailData			=		bean.getDataDtlList();
				alDfltList				=		bean.getExpBatchDetailsList();
				if(datMode.equals("Add"))
					proceed=true;
		   }

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	int expired_batch_no		=		0;
	int exp_batch               =       0;
	String nod					=		"";
	StringBuffer sb				=		new StringBuffer();
	StringBuffer sb2			=		new StringBuffer();
	int EWDays					=		bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
	
	HashMap ht				=	new HashMap();
	HashMap hmParameters	=	new HashMap();
	ArrayList alBatchRecords=new ArrayList();
	HashMap a =  null;
	HashMap hmReturn	= null;
	HashMap hmTemp		= null;
	StUtilities bean1;
	for(i=0;i<ALDetailData.size();i++)
	{
		
	if (mode.equals("2") && datMode.equals("Add")){
		expired_batch_no		=		0;
		for(int k=0; k<((ArrayList)al123Exp.get(i)).size(); k++)	{
			nod					=		(String)((HashMap)((ArrayList)al123Exp.get(i)).get(k)).get("NOD");
			
			if(Integer.parseInt(nod) < EWDays)
				expired_batch_no++;
			}
		}
		if(mode.equals("2") && datMode.equals("modify")){
		 ArrayList alExpModifydata	=			bean.getExpDetailsList();
		 expired_batch_no		=		0;
		    for(int l=0; l<((ArrayList)alExpModifydata.get(i)).size(); l++)	{
			nod		=		(String)((HashMap)((ArrayList)alExpModifydata.get(i)).get(l)).get("NOD");
			if(Integer.parseInt(nod) < EWDays)
				expired_batch_no++;
			}
		 }
		 
		
		String classValue		=	"";
		ht=(HashMap)ALDetailData.get(i);
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ht.get("SHORT_DESC")));
            _bw.write(_wl_block15Bytes, _wl_block15);
//Added by suresh.r on 26-03-2015
		System.out.println("ht=180==>" +ht);
	
		if(i%2==0)classValue	=	"QRYEVEN";
		else classValue			=	"QRYODD";
        double qty				=	0.0;
        double cost				=	0.0;
		String disable			=	"";
		
		//Added by Rabbani #Inc no:29950 on 27/FEB/2013 Starts
		  if (mode.equals("1") && expiry.equals("expiry")){
		        exp_batch			=		0;
				nod				  =		bean.checkForNull((String)ht.get("NOD"),"0");				
				 if(Integer.parseInt(nod) < EWDays && Integer.parseInt(nod) != 0){
						exp_batch++;
					}
			}
			//ends
		
		allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN((String)ht.get("CHILD_ITEM_CODE")),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";
		
		if(((String)ht.get("MANDATORY_ITEM")).equals("Y") || ((String)ht.get("MANDATORY_ITEM")).equals("E")){
				disable			=	"disabled";
		}
		else{
				disable			=	"";
		}
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		//if(dflt_mfg_mode.equals("D"))
		//disable			=	"";
		String item_names		=	"";
		double conv_qty			=	0.0;
		qty						=	Double.parseDouble((String)ht.get("COMPONENT_QTY"))*Double.parseDouble(bean.checkForNull(composition_for_qty,"0"));
	
		if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
			conv_qty=qty*Double.parseDouble(bean.checkForNull(((String)ht.get("CONV_FACTOR")),"1"));
	//		if(!((String)ht.get("MANDATORY_ITEM")).equals("E"))
			conv_qty=conv_qty/Double.parseDouble(baseqty);
		}
		else{
			conv_qty=qty;	
		}
/*	
		cost=(conv_qty)*Float.parseFloat(bean.setNumber(((String)ht.get("UNIT_COST")),3));
		cost=Float.parseFloat(bean.setNumber(""+cost,3));	
		
*/
		int count = bean.LinkChk((String)ht.get("CHILD_ITEM_CODE"),(String)bean.getStore_code());
		if(count==0){
			check="checked";
			display=false;    
			         
			if ( (mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) && !(datMode.equals("modify")))||(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) )
			{
			 sb.append(ht.get("SHORT_DESC"));
	 		 sb.append(",");
			}
		}else{
			check="";
			display=true;    
		}

		a = bean.getROL((String)ht.get("CHILD_ITEM_CODE"),bean.getStore_code());
		 if(a!=null&&a.size()>0){
		 //if( mode.equals("1") && ExpiredBatch != ""  && Integer.parseInt(ExpiredBatch) > 0 ) {
		 if( mode.equals("1") && exp_batch > 0 ) { //Added by Rabbani #Inc no:29950 on 27/FEB/2013
		String exp_legend= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
			//alt_text = ExpiredBatch+exp_legend;
			 alt_text = exp_batch+exp_legend;
		}
		else if (mode.equals("2") && expired_batch_no > 0){
			String exp_legend_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
				alt_text = expired_batch_no+exp_legend_1;
		}
		if((Double.parseDouble((String)a.get("QTY_ON_HAND")) - qty) < Double.parseDouble((String)a.get("REORDER_LEVEL")))
				ROL_YN = "Y";
			else
				ROL_YN = "N" ;
			
			if((Double.parseDouble((String)a.get("QTY_ON_HAND")) - qty) < Double.parseDouble((String)a.get("MIN_STK_QTY")))
				Min_YN = "Y";
			else
				Min_YN = "N";
		 }
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ){
		try { 
				bean1 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
					hmParameters.put("ITEM_CODE",ht.get("CHILD_ITEM_CODE"));
					hmParameters.put("STORE_CODE",bean.getStore_code());
					// added by Pankaj 
                    double conv_qty1 = ((double)conv_qty);
					// Critical Check Once 1/13/2010
					hmParameters.put("TRN_QTY",""+Double.parseDouble((bean.setNumber(""+conv_qty1,Integer.parseInt(no_deci)))));
					hmReturn	=	bean1.getBatches(hmParameters);
				if(proceed){
					alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA");
					alDfltList.add(alBatchRecords);
					exp_batch			=		0;
				/*for(int n=0; n<((ArrayList)alDfltList.get(i)).size(); n++){
				nod		=		(String)((HashMap)((ArrayList)alDfltList.get(i)).get(n)).get("NOD");
                 ht.put("NOD", nod);
				 ALDetailData.set(i,ht);				
				 if(Integer.parseInt(nod) < EWDays){
						exp_batch++;
					}
				}*/
				for(int n=0;n<alBatchRecords.size(); n++)
			 {
				hmTemp			=	(HashMap)alBatchRecords.get(n); 
				nod	            =	(String)hmTemp.get("NOD");
				ht.put("NOD", nod);
				ALDetailData.set(i,ht);				
			   if(Integer.parseInt(nod) < EWDays){
					exp_batch++;
				   }
					break;
			 }
				if(a!=null&&a.size()>0){
		        if(exp_batch > 0 ) { //Added by Rabbani #Inc no:29950 on 28/FEB/2013
		        String exp_legend= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
			     alt_text = exp_batch+exp_legend;
		         }
				}
			}
					display=true;
					check="";
					putObjectInBean("stUtilities",bean1,request);

			}catch (eST.Common.InsufficientBatchException insufficientBatchException) {
				display=false;
						if(((String)ht.get("MANDATORY_ITEM")).equals("Y")  || ((String)ht.get("MANDATORY_ITEM")).equals("E")  ){
						check="checked";
								}
						else{
							check="checked";
						}
							if(proceed){
							if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ){
								item_names=item_names+ht.get("SHORT_DESC");
								
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(insufficientBatchException.getMessage()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(item_names));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(insufficientBatchException.getMessage()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(item_names));
            _bw.write(_wl_block19Bytes, _wl_block19);
	//insufficientBatchException.printStackTrace();
						    sb2.append(ht.get("SHORT_DESC"));
	 						sb2.append(",");
							}
						}
			}
			catch (Exception exception) {
				out.println(exception.getMessage());
				exception.printStackTrace();
			}
			finally {
			}
		}


	/*	if(datMode.equals("modify") && request.getParameter("index") != null && Integer.parseInt(request.getParameter("index"))==i)
			conv_qty=Integer.parseInt((String)ht.get("COMPONENT_QTY"));
		out.println(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ));
		out.println("MODE_MODIFY  inserta------"+datMode);*/
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )  && !(datMode.equals("modify"))){
//			prep_qty = Float.parseFloat((String)ht.get("COMPONENT_QTY"));
			prep_qty = Double.parseDouble((String)ht.get("TRANS_QTY"));

		}else{
				prep_qty = Double.parseDouble((String)ht.get("PREP_QTY"));
		if(prep_qty == 0.0)
				prep_qty=conv_qty;
		}
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )  && !(datMode.equals("modify"))) 
				prep_qty = conv_qty;
		/**
		 * @Name - Priya
		 * @Date - 03/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and round up cost with noOfDecimalsForCost
		 */
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

		cost=(prep_qty)*Double.parseDouble(bean.setNumber(((String)ht.get("UNIT_COST")),noOfDecimalsForCost));
		cost=Double.parseDouble(bean.setNumber(""+cost,noOfDecimalsForCost));	
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(check));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
//alDfltList.get(0)
            _bw.write(_wl_block28Bytes, _wl_block28);
 

		if (Min_YN.equals("Y") && Min_YN.equals("Y")){
			//String less_than_min_stock=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.lessthanminstock.label","st_labels");
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(alt_text));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
		else if (ROL_YN.equals("Y")){
			String less_than_rol=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.lessthanROL.label","st_labels");
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(less_than_rol));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(alt_text));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
		else if((exp_batch > 0)|| (mode.equals("2") && expired_batch_no > 0)){
			
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_text));
            _bw.write(_wl_block34Bytes, _wl_block34);
		}
		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag			= "visibility:visible";
		
            _bw.write(_wl_block35Bytes, _wl_block35);
if (display){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ht.get("CHILD_ITEM_CODE")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.getStore_code()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ht.get("COMPONENT_QTY")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.getReq_qty()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ht.get("SHORT_DESC")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(conv_qty));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(baseqty));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ht.get("SHORT_DESC")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(prep_qty));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(cost));
            _bw.write(_wl_block42Bytes, _wl_block42);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ht.get("SHORT_DESC")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(conv_qty));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(cost));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
if (display){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ht.get("CHILD_ITEM_CODE")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.getStore_code()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ht.get("COMPONENT_QTY")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.getReq_qty()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(prep_qty));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(baseqty));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ht.get("SHORT_DESC")));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(bean.setNumber(""+prep_qty,Integer.parseInt(no_deci))));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(cost));
            _bw.write(_wl_block51Bytes, _wl_block51);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ht.get("SHORT_DESC")));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(bean.setNumber(""+conv_qty,Integer.parseInt(no_deci))));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(display_flag));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(cost));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(conv_qty));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(ht.get("CHILD_ITEM_CODE")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(ht.get("SHORT_DESC")));
            _bw.write(_wl_block60Bytes, _wl_block60);

		((HashMap)ALDetailData.get(i)).remove("PREP_QTY");
		if (display){
			((HashMap)ALDetailData.get(i)).put("PREP_QTY",prep_qty+"");
		}else{
			((HashMap)ALDetailData.get(i)).put("PREP_QTY",conv_qty+"");
		}
		
		}

		
		bean.setDataDtlList(ALDetailData);	
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
			bean.setModDtlList(ALDetailData);
			if(proceed){
			
				bean.setExpDetailsList(al123Exp);
			}
		}
		else{
			if(proceed)
		
				bean.setExpDetailsList(alDfltList);
		}
		if(sb.length()>0){
			sbi=sb.toString();
			sbi =sbi.substring(0,sbi.length()-1);	
		}
		if(sb2.length()>0) {
			sbn=sb2.toString();
			
			sbn =sbn.substring(0,sbn.length()-1);	
			
	   }
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( function_id ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(sbi));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(sbn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(dflt_mfg_mode));
            _bw.write(_wl_block69Bytes, _wl_block69);

		}
		catch (Exception exception) {
			out.println(exception.getMessage());
			exception.printStackTrace();
		}
		finally {
		}

            _bw.write(_wl_block70Bytes, _wl_block70);

putObjectInBean("ManufacturingReceiptsBean",bean,request);

            _bw.write(_wl_block71Bytes, _wl_block71);
if (sbi.length()>0) {
            _bw.write(_wl_block72Bytes, _wl_block72);
 }
            _bw.write(_wl_block2Bytes, _wl_block2);
if (sbn.length()>0) {
	
	eST.Common.InsufficientBatchException insufficientBatchException=new eST.Common.InsufficientBatchException();

            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(insufficientBatchException.getMessage()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sbn));
            _bw.write(_wl_block74Bytes, _wl_block74);
 }
            _bw.write(_wl_block2Bytes, _wl_block2);
if (request.getParameter("index")!=null) {
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ItemDetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Quantity.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
