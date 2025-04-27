package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryformatbottomdepend extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryFormatBottomDepend.jsp", 1732097040000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- \n-----------------------------------------------------------------------\nDate       Edit History      Name        \t\tDescription\n-----------------------------------------------------------------------\n?             100            ?           \t\tcreated\n24/07/2013    IN038529      Chowminya G     Field Mnemonic restriction in format item based on the level value\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       \tEdit History     Name        \tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n02/07/2014\tIN049133\t\tChowminya\t\t\t\t\t\t\t\t\tCRF:Disallow user to enter the future date in the LMP date field\n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n    \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 =" \n\n<head>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrderEntryFormats.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\n\n<SCRIPT LANGUAGE=\"JavaScript\">\n\n\nvar i=0;\nvar dontChk=\"\";\n\nfunction closeWindow(){\n\t//var level\t\t\t= document.list_dtl.level.value;\n\tvar level\t\t\t= document.getElementById(\"list_dtl\").level.value;\n\t//var topPageForm = parent.list_top.document.forms[0];\n\tvar topPageForm = parent.document.getElementById(\"list_top\");\n\tvar finalString = \"\";\n\tif (topPageForm) {\n\t\ttopPageForm.seq_arr = new Array(); // Make sure to assign the array properly\n\t}\n\n\t\tif(Array.isArray(topPageForm.seq_arr.length>0) && Array.isArray(topPageForm.seq_arr.length<=5)){\n\t\tfor(count=0; count<parent.list_top.seq_arr.length; count++){\n\t\t/*\tif( (level == \"L\") && (topPageForm.defFlag.value  == \'1\')){\n\t\t\t\tif((parent.list_top.seq_arr[count] == \"1\")||(parent.list_top.seq_arr[count] == \"2\")||(parent.list_top.seq_arr[count] == \"3\")){\n\t\t\t\t\tparent.list_top.agegroup_arr[count] = \" \";\n\t\t\t\t\tparent.list_top.object_type_arr[count] = \"\";\n\t\t\t\t\tparent.list_top.value_arr1[count] = \"\";\n\t\t\t\t\tparent.list_top.value_arr2[count] = \"\";\n\t\t\t\t}\n\t\t\t}*/\n\t\t\tif(parent.list_top.deflt_value_arr[count] == \"\")\n\t\t\t\tparent.list_top.deflt_value_arr[count] = \" \";\n\t\t\tif(parent.list_top.agegroup_arr[count] == \"\")\n\t\t\t\tparent.list_top.agegroup_arr[count] = \" \";\n\t\t\tfinalString += parent.list_top.seq_arr[count]+\"$\"+parent.list_top.mnemonic_arr[count]+\"$\"+parent.list_top.label_text_arr[count]+\"$\"+parent.list_top.accept_option_arr[count]+\"$\"+parent.list_top.deflt_value_arr[count]+\"$\"+parent.list_top.agegroup_arr[count]+\"$\"+parent.list_top.object_type_arr[count]+\"$\"+parent.list_top.value_arr1[count]+\"$\"+parent.list_top.value_arr2[count]+\"$\"+parent.list_top.dependency_arr[count]+\"!!\"\n\n\t\t}\n\t}\n\tdocument.list_dtl.finalString.value = finalString;\n\t//window.returnValue = document.list_dtl.finalString.value\n\t//window.close();\n\ttop.document.querySelectorAll(\"#dialog-body\")[top.document.querySelectorAll(\"#dialog-body\").length -1 ].contentWindow.returnValue = document.list_dtl.finalString.value;\n\ttop.document.querySelectorAll(\"#dialog_tag\")[top.document.querySelectorAll(\"#dialog_tag\").length -1].close();\n}\n\n\n\n\nfunction removeValues(){\n\nvar age_group_sd= document.list_dtl.age_group_sd.value;\nvar age_group_cd= document.list_dtl.age_group_cd.value\nvar tmp_seq_arr\t\t\t\t= new Array();\nvar tmp_mnemonic_arr\t\t= new Array();\nvar tmp_agegroup_arr\t\t= new Array();\nvar tmp_lbl_txt_arr\t\t\t= new Array();\nvar tmp_accept_option_arr\t= new Array();\nvar tmp_dflt_val_arr\t\t= new Array();\nvar tmp_dependency_arr\t\t= new Array();//IN049133\n\nvar count = 0;\n\t\n\tif(document.list_dtl.seq_no.value == \"\" ){\n\t\talert(getMessage(\'SELECT_TO_CLEAR\',\'OR\'))\n\t\treturn false;\n\t}\n\t\n//\tdocument.list_dtl.agegroup.value=\"select\"\n\tdontChk = document.list_dtl.dontChk.value ;\n\tfor(i=0; i<parent.list_top.seq_arr.length; i++){\n\t\tif( (dontChk == \"\") || (i != dontChk)){\n\t\t\ttmp_seq_arr[count] =  parent.list_top.seq_arr[i];\n\t\t\ttmp_mnemonic_arr[count] =  parent.list_top.mnemonic_arr[i];\n\t\t\ttmp_lbl_txt_arr[count] =  parent.list_top.label_text_arr[i];\n\t\t\ttmp_accept_option_arr[count] =  parent.list_top.accept_option_arr[i];\n\t\t\ttmp_agegroup_arr[count] =  parent.list_top.agegroup_arr[i];\n\t\t\ttmp_dflt_val_arr[count] =  parent.list_top.deflt_value_arr[i];\n\t\t\ttmp_dependency_arr[count] =  parent.list_top.dependency_arr[i];//IN049133\n\t\t\tcount++;\n\t\t}\n\n\t}\n\tparent.list_top.seq_arr\t\t\t\t= tmp_seq_arr;\n\tparent.list_top.mnemonic_arr\t\t= tmp_mnemonic_arr;\n\tparent.list_top.label_text_arr\t\t= tmp_lbl_txt_arr;\n\tparent.list_top.accept_option_arr\t= tmp_accept_option_arr;\n\tparent.list_top.deflt_value_arr\t\t= tmp_dflt_val_arr;\n\tif(tmp_agegroup_arr == \"\"){tmp_agegroup_arr= \"\";}\n\tparent.list_top.agegroup_arr\t\t= tmp_agegroup_arr;\n\tparent.list_top.dependency_arr\t\t= tmp_dependency_arr;//IN049133\n\tvar finalString = \"\";\n\tif(parent.list_top.seq_arr.length>0){\n\t\tfor(count=0; count<parent.list_top.seq_arr.length; count++){\n\t\t\tfinalString += parent.list_top.seq_arr[count]+\"$\"+parent.list_top.mnemonic_arr[count]+\"$\"+parent.list_top.label_text_arr[count]+\"$\"+parent.list_top.accept_option_arr[count]+\"$\"+parent.list_top.deflt_value_arr[count]+\"$\"+parent.list_top.agegroup_arr[count]+\"$\"+parent.list_top.mnemonic_arr[count]+\"$\"+parent.list_top.dependency_arr[count]+\"!!\"\n\t\t\t//+\"*\"+parent.list_top.position_arr[count]+\"^\"\n\t\t}\n\t}\n\t\n\tdocument.list_dtl.finalString.value = finalString;\n\tdocument.list_dtl.mode.value = \"insert\";\n\tdocument.list_dtl.action  = \"OrderEntryFormatTopDepend.jsp\";\n\tdocument.list_dtl.target = \"list_top\";\n\t//document.list_dtl.submit(); -----------err\n\n\n\t/***This is in case where Order Category is Laboratroy******/\n\tvar topPageForm1 = parent.list_top.document.forms[0];\n\tvar ord_cat= \"\";\n\tif(topPageForm1.defFlag.value  == \'1\'){//in case of Lab in create mode\n\t\t\tord_cat = \"LB\" ;\n\t}\n\n    //j var test = setFinalString(finalString)\n \t//if(test == finalString) {\n \t//\talert(\"done\");\n \t//}\n\tif(ord_cat == \"\")\n\t\tord_cat = document.list_dtl.ord_cat.value;\n\tparent.list_top.document.location.href=\"../jsp/OrderEntryFormatTopDepend.jsp?finalString=\"+escape(finalString)+\"&ord_cat=\"+ord_cat+\"&age_group_sd=\"+age_group_sd+\"&age_group_cd=\"+age_group_cd;\n\n\n\tdocument.list_dtl.seq_no.value = \"\";\n\tdocument.list_dtl.mnemonic.value = \"\";\n\tdocument.list_dtl.lbl_txt.value = \"\";\n\tdocument.list_dtl.accept_option.selectedIndex = 0;\n\tif(\tdocument.list_dtl.dflt_val)\n\t\tdocument.list_dtl.dflt_val.value = \"\";\n\tif(document.list_dtl.agegroup)\n\t\tdocument.list_dtl.agegroup.value = \"\";\n\tif(document.getElementById(\"deflt_value1\"))\n\t\tdocument.getElementById(\"deflt_value1\").innerHTML = \"\";\n\tif(document.getElementById(\"deflt_value2\"))\n\t\tdocument.getElementById(\"deflt_value2\").innerHTML = \"\";\n\tif(document.getElementById(\"depend1\"))\n\t\tdocument.getElementById(\"depend1\").innerHTML = \"\";\n\tif(document.getElementById(\"depend2\"))\n\t\tdocument.getElementById(\"depend2\").innerHTML = \"\";\n\tif(document.list_dtl.dontChk)\n\t\tdocument.list_dtl.dontChk.value = \"\";\n}\n\nfunction chkMandatory(){\n\tvar count=0;\n\tvar finalString = \"\";\n\tvar seq_num= document.list_dtl.seq_no.value;\n\tvar parentindex = document.list_dtl.parentindex.value ;\n\tvar dontChkLabel = document.list_dtl.dontChk.value ;\n\tvar indexLabel= document.list_dtl.index.value;\n\tvar mnemonic = document.list_dtl.mnemonic.value;\n\tvar position = document.list_dtl.mnemonic.selectedIndex;\n\tvar indexVal = document.list_dtl.mnemonic.selectedIndex\n\tvar agegroup = document.list_dtl.agegroup.value;\n\tvar age_group_sd= document.list_dtl.age_group_sd.value;\n\tvar age_group_cd= document.list_dtl.age_group_cd.value;\n\tvar isSpace = 0;\n\n\tvar ord_cat = \"\";\n\n\n\tfor(i=0; i<mnemonic.length; i++){\n\t\tif(mnemonic.charAt(i) != \" \"){\n\t\t\tisSpace = 1\n\t\t\tbreak;\n\t\t}\n\t}\n\nif(document.list_dtl.seq_no.value == \"\"){\n\t\talert(getMessage(\'SEQ_NO_NOT_BLANK\',\'OR\'))\n\t\tdocument.list_dtl.seq_no.focus();\n\t\treturn false;\n\t}else if(isNaN(document.list_dtl.seq_no.value) == true){\n\t\talert(getMessage(\'ONLY_NUMBERS\',\'OR\'))\n\t\tdocument.list_dtl.seq_no.value=\"\";\n\t\tdocument.list_dtl.seq_no.focus();\n\t\treturn false;\n\t}else if(document.list_dtl.seq_num == 0){\n\t\talert(getMessage(\'SEQ_NO_NOT_ZERO\',\'OR\'))\n\t\tdocument.list_dtl.seq_no.focus();\n\t\treturn false;\n\t}else if(document.list_dtl.mnemonic.value == \"\"){\n\t\t//alert(\'Mnemonic can not be Blank...\')\n\t\talert(getMessage(\'FIELD_MNEMONIC_CANNOT_BE_EMPTY\',\'OR\'))\n\t\tdocument.list_dtl.mnemonic.focus();\n\t\treturn false;\n\t}else if(document.list_dtl.lbl_txt.value == \"\"){\n\t\t//alert(\'Label Text can not be Blank...\')\n\t\talert(getMessage(\'LABEL_TEXT_CANNOT_BE_BLANK\',\'OR\'))\n\t\tdocument.list_dtl.lbl_txt.focus();\n\t\treturn false;\n\t}else if(((seq_num.charAt(0) == \"0\") && (seq_num.length == \"1\")) || ((seq_num.charAt(0) == \"0\") && (seq_num.charAt(1) == \"0\") &&  (seq_num.length == \"2\"))){\n\t\talert(getMessage(\'SEQ_NO_NOT_ZERO\',\'OR\'))\n\t\treturn false\n\t}else if(seq_num.substring(0,1) == \'0\'){\n\t\tdocument.list_dtl.seq_no.value = seq_num.substring(1,seq_num.length);\n\t}\n\tvar mnemonic_type = (eval(\"document.list_dtl.hdn_fld_type\"+indexVal).value)\n\t\n\tvar tmp_seq_no\t\t\t= document.list_dtl.seq_no.value;\n\tvar tmp_agegroup\t\t=document.list_dtl.agegroup.value;\n\tvar tmp_mnemonic\t\t= document.list_dtl.mnemonic.value;\n\tvar tmp_lbl_txt\t\t\t= document.list_dtl.lbl_txt.value;\n\t\t\n\tvar tmp_accept_option\t= document.list_dtl.accept_option.value;\n\t//IN049133 - Start\n\tvar tmp_depend_yn = \"N\";\n\tif(document.list_dtl.chk_depnd)\n\t{\n\t\ttmp_depend_yn\t\t= document.list_dtl.chk_depnd.checked;\n\t\t\n\t\tif(tmp_depend_yn)\n\t\t\ttmp_depend_yn = \"Y\";\n\t\telse\n\t\t\ttmp_depend_yn = \"N\";\t\t\n\t}\t\n\t//IN049133 - End\n\t/*for (var repl=0;repl < tmp_lbl_txt.length;repl++) {\n\t\tif (tmp_lbl_txt.indexOf(\"&\") != -1) {\n\t\t\ttmp_lbl_txt = tmp_lbl_txt.replace(\"&\",\"�\");\n\t\t}\n\t\tif (tmp_lbl_txt.indexOf(\"%\") != -1) {\n\t\t\ttmp_lbl_txt = tmp_lbl_txt.replace(\"%\",\"!!\");\n\t\t}\n\t\tif (tmp_lbl_txt.indexOf(\"!!\") != -1) {\n\t\t\ttmp_lbl_txt = tmp_lbl_txt.replace(\"!!\",\"�\");\n\t\t}\n\t\tif (tmp_lbl_txt.indexOf(\"+\") != -1) {\n\t\t\ttmp_lbl_txt = tmp_lbl_txt.replace(\"+\",\"�\");\n\t\t}\n\t\tif (tmp_lbl_txt.indexOf(\"\\\\\") != -1) {\n\t\t\ttmp_lbl_txt = tmp_lbl_txt.replace(\"\\\\\",\"�\");\n\t\t}\n\t}*/\n\t//alert(tmp_lbl_txt);\n\tvar tmp_dflt_val;\n\tif(document.list_dtl.dflt_val.type   == \"checkbox\"){\n\t\tif(document.list_dtl.dflt_val.checked)\n\t\t\ttmp_dflt_val = \'Y\'\n\t\telse\n\t\t\ttmp_dflt_val  = \'N\';\n\t}else{ \n\t\ttmp_dflt_val\t\t= document.list_dtl.dflt_val.value;\n\t}\n\t\n\n\tvar tmp_mnemonic_type\t= mnemonic_type\n\tvar tmp_position1\t\t= eval(\"document.list_dtl.hdn_minVal\"+position).value\n\tvar tmp_position2\t\t= eval(\"document.list_dtl.hdn_maxVal\"+position).value\n\n\n\tvar val_length = tmp_dflt_val.length;\n\tif(tmp_mnemonic_type == \"N\"){\n\t\tif((isValidDecimal(tmp_dflt_val))){\n\n\t\t\tif(tmp_dflt_val.indexOf(\".\") != -1){\n\t\t\t\tint_part = tmp_dflt_val.split(\".\")\n\t\t\t\tdecimal_val = int_part[1]\n\t\t\t\tdecimal_pos = int_part.length +1\n\t\t\t\t//alert(\'ASK:TEMP_DTLT_VAL\'+tmp_dflt_val+\'ASK:DECIMAL_POS:\'+decimal_pos+\'ASK:DECIMAL_PART:\'+decimal_val+\'ASK:DECIMAL_VAL_LENG:\'+decimal_val.length)\n\t\t\t\t//if((val_length - decimal_pos) > 3){\n\t\t\t\tif(decimal_val.length > 3) {\n\t\t\t\t\talert(getMessage(\'MAX_NO_DECIMAL\',\'OR\'))\n\t\t\t\t\t//alert(\'Cannot have more than 3 decimal numbers\')\n\t\t\t\t\treturn false\n\t\t\t\t}\n\t\t\t}\n\n\t\t\tif(tmp_position1 != \"\" && tmp_position2 != \"\"){\n\t\t\t\tif((checkDecimalRange(tmp_dflt_val,tmp_position1,tmp_position2)) == false){\n\t\t\t\t\t//alert(\"Invalid Decimal Range...\")\n\t\t\t\t\talert(getMessage(\'INVALID_DECIMAL_RANGE\',\'OR\'))  ;\n\t\t\t\t\tdocument.list_dtl.dflt_val.select()\n\t\t\t\t\treturn false\n\t\t\t\t}\n\t\t\t}\n\t\t}else{\n\t\t\treturn false\n\t\t}\n\t}\n\n\tif(tmp_mnemonic_type == \"I\"){\n\t\tif(tmp_position1 != \"\" && tmp_position2 != \"\"){\n\t\t";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="\tif((checkIntegerRange(tmp_dflt_val,tmp_position1,tmp_position2)) == false){\n\t\t\t\t//alert(\"Invalid Integer Range...\")\n\t\t\t\talert(getMessage(\'INVALID_INTEGER_RANGE\',\'OR\'))  ;\n\t\t\t\treturn false\n\t\t\t}\n\t\t}\n\t}\n\n\tif(tmp_position1 == null)tmp_position1 = \" \";\n\tif(tmp_position2 == null)tmp_position2 = \" \";\n\n\tdontChk = document.list_dtl.dontChk.value ;\n\n\n\n\tif(tmp_mnemonic == \"\")\t\ttmp_mnemonic = \" \";\n\tif(tmp_lbl_txt == \"\")\t\ttmp_lbl_txt = \" \";\n\tif(tmp_accept_option == \"\")\ttmp_accept_option = \" \";\n\tif(tmp_dflt_val == \"\")\t\ttmp_dflt_val = \" \";\n\tif(tmp_agegroup == \"\")\t\ttmp_agegroup = \" \";\n\n\n\n\t/*******CHK FOR SINGLE MULTIPLE *******************/\n\tif(parent.list_top.mnemonic_arr.length>0){\n\t\tvar single_multiple =  eval(\"document.getElementById(\'single_multiple\'\"+position+\").value\");\n\t\tfor(count=0; count<parent.list_top.mnemonic_arr.length; count++){\n\t\t\tcount = parseInt(count);\n\t\t\tdontChk = parseInt(dontChk)\n\t\t \tif(count != dontChk){\n\t\t\t\tif(single_multiple == \'S\'){\n\t\t\t\t\tif(parent.list_top.mnemonic_arr[count] == mnemonic){\n\t\t\t\t\t\talert(getMessage(\'SINGLE_RECORD_CHK\',\'OR\'))  ;\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\t/********/\n\n\t/****CHK FOR DUPLICATE*******/\n\t\n\tvar topPageForm = parent.list_top.document.forms[0];\n\tlevel\t\t\t= document.list_dtl.level.value\n\t/*if(level == \"L\"){\n\t\tif(topPageForm.defFlag.value  == \'1\' ){//in case of Order Category is Lab\n\t\t\t/*if(tmp_seq_no == 2  ) {  //tmp_seq_no == 1 ||\n\t\t\t\talert(getOrMessage(\'DUP_SEQ_NUM\')) ;\n\t\t\t\tdocument.list_dtl.seq_no.value= \"\";\n\t\t\t\tdocument.list_dtl.seq_no.focus();\n\t\t\t\treturn false;\n\t\t\t}//seq no duolicated for  Order Category is Lab\n\t\t}\n\t}*/\n\n\tif(parent.list_top.seq_arr.length>0){\n\t\tfor(count=0; count<parent.list_top.seq_arr.length; count++){\n\n\t\t\tcount = parseInt(count);\n\t\t\tdontChk = parseInt(dontChk)\n\t\t\t\t\n\t\t\tif(count != dontChk){\n\t\t\t\tif(parent.list_top.seq_arr[count] == tmp_seq_no){\n\t\t\t\t\talert(getMessage(\'DUP_SEQ_NUM\',\'OR\'))\n\t\t\t\t//\talert(getOrMessage(\'COL_NO_CANNOT_REPEATED_SAME_ROW\'))\n\t\t\t\t\tdocument.list_dtl.seq_no.value= \"\";\n\t\t\t\t\tdocument.list_dtl.seq_no.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\t/*******CHK FOR DUP ENDS*********/\n\n\tif(document.list_dtl.mode.value == \'update\'){\n\t\tvar ref_val = parseInt(dontChk)\n\t\tfor(count=0; count<parent.list_top.seq_arr.length; count++){\n\t\t\t//alert(desc_arr[count]);\n//\t\t\talert(document.list_dtl.old_desc.value);\n\t\t\t/*alert(count);\n\t\t\tfor (var repl=0;repl < parent.list_top.label_text_arr[count].length;repl++) {\n\t\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"&\") != -1) {\n\t\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"&\",\"�\");\n\t\t\t\t}\n\t\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"%\") != -1) {\n\t\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"%\",\"!!\");\n\t\t\t\t}\n\t\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"!!\") != -1) {\n\t\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"!!\",\"�\");\n\t\t\t\t}\n\t\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"+\") != -1) {\n\t\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"+\",\"�\");\n\t\t\t\t}\n\t\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"\\\\\") != -1) {\n\t\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"\\\\\",\"�\");\n\t\t\t\t}\n\t\t\t}*/\n\t\t\tif(tmp_position1 == \"\") tmp_position1 = \" \";\n\t\t\tif(tmp_position2 == \"\") tmp_position2 = \" \";\n\t\t\tif(parent.list_top.seq_arr[count] == document.list_dtl.old_seq_no.value){\n\t\t\t\tparent.list_top.seq_arr[count]\t\t\t\t= tmp_seq_no;\n\t\t\t\tparent.list_top.mnemonic_arr[count]\t\t\t= tmp_mnemonic;\n\t\t\t\tif((tmp_lbl_txt!=undefined) ||(tmp_lbl_txt!=null))\n\t\t\t\t{\n\t\t\t\t\tsetFormatValues(\"labeltext_\"+parentindex+\"Othernemonic_\"+indexLabel+\"array\"+dontChkLabel,tmp_lbl_txt);\n\t\t\t\t}\n\t\t\t\tparent.list_top.label_text_arr[count]\t\t= \"labeltext_\"+parentindex+\"Othernemonic_\"+indexLabel+\"array\"+dontChkLabel;\n\t\t\t\tparent.list_top.accept_option_arr[ref_val]\t= tmp_accept_option;\n\t\t\t\tparent.list_top.value_arr1[count]\t\t\t= tmp_position1;\n\t\t\t\tparent.list_top.value_arr2[count]\t\t\t= tmp_position2;\n\t\t\t\tparent.list_top.object_type_arr[count]\t\t= tmp_mnemonic_type\n\t\t\t\tif((tmp_dflt_val!=undefined) ||(tmp_dflt_val!=null))\n\t\t\t\t{\n\t\t\t\t\t//setFormatValues(\"dfltValue_\"+dontChkLabel+\"Othernemonic_array\"+indexLabel,tmp_dflt_val);\n\t\t\t\t\tsetFormatValues(\"dfltValue_\"+parentindex+\"Othernemonic_\"+indexLabel+\"array\"+dontChkLabel,tmp_dflt_val);\n\n\t\t\t\t}\n\t\t\t\tparent.list_top.deflt_value_arr[count]\t\t= \"dfltValue_\"+parentindex+\"Othernemonic_\"+indexLabel+\"array\"+dontChkLabel;\n\t\t\t\tparent.list_top.agegroup_arr[count]\t\t\t=tmp_agegroup;\n\t\t\t\tparent.list_top.dependency_arr[count]\t\t=document.list_dtl.finalValue.value;\n\t\t\t}\n\t\t\n\t\t\t/***This is in case where Order Category is Laboratroy******/\n\t\t\tvar topPageForm1 = parent.list_top.document.forms[0];\n\t\t\tif(topPageForm1.defFlag.value  == \'1\'){//in case of Lab in create mode\n\t\t\tord_cat = \"LB\" ;\n\t\t\t}\n\n\n\n//\t\t\tif(parent.list_top.deflt_value_arr[count] == document.list_dtl.old_dflt_val.value){\n//\t\t\t\talert(\'here >\'+tmp_dflt_val+\'<\')\n\t\t\t\t//parent.list_top.deflt_value_arr[ref_val] = \"dfltValue_\"+dontChkLabel+\"Othernemonic_array\"+indexLabel;\n//\t\t\t}\n\t\t}\n\t}else {\n\t\tvar level\t  = document.list_dtl.level.value;\n\t\tvar arrLength = parent.list_top.seq_arr.length\n\t\tif(parseInt(arrLength) !=0){\n\t\t\t\ti = parseInt(arrLength);\n\t\t}/*else if(level == \'L\'){\n\t\t\t\ti=0;\n\n\t\t\tif(topPageForm.defFlag.value  == \'1\'){//in case of Lab in create mode\n\n\t\t\t\tparent.list_top.seq_arr[i]\t\t\t= \"1\";\n\t\t\t//\tparent.list_top.cseq_arr[i]\t\t\t= \"1\";\n\t\t\t\tparent.list_top.mnemonic_arr[i]\t\t= \"SPECIMEN_TYPE\";\n\t\t\t\tparent.list_top.label_text_arr[i]\t= \"Specimen Type\";\n\t\t\t\tparent.list_top.accept_option_arr[i]= \"O\";\n\t\t\t\tparent.list_top.deflt_value_arr[i]\t= \" \";\n\t\t\t\tparent.list_top.agegroup_arr[i]\t= \" \";\n\t\t\t\tparent.list_top.object_type_arr[i]\t= \"\";\n\t\t\t\tparent.list_top.value_arr1[i]\t\t= \"\";\n\t\t\t\tparent.list_top.value_arr2[i]\t\t= \"\";\n\t\t\t\ti++;\n\n\n\t\t\t\tparent.list_top.seq_arr[i]\t\t\t= \"2\";\n\t\t\t//\tparent.list_top.cseq_arr[i]\t\t\t= \"1\";\n\t\t\t\tparent.list_top.mnemonic_arr[i]\t\t= \"NURSE_COLLECT_YN\";\n\t\t\t\tparent.list_top.label_text_arr[i]\t= \"Nurse Collect\";\n\t\t\t\tparent.list_top.accept_option_arr[i]= \"O\";\n\t\t\t\tparent.list_top.deflt_value_arr[i]\t= \" \";\n\t\t\t\tparent.list_top.agegroup_arr[i]\t= \" \";\n\t\t\t\tparent.list_top.object_type_arr[i]\t= \"\";\n\t\t\t\tparent.list_top.value_arr1[i]\t\t= \"\";\n\t\t\t\tparent.list_top.value_arr2[i]\t\t= \"\";\n\t\t\t\ti++;\n\n                parent.list_top.seq_arr[i]\t\t\t= \"3\";\n\t\t\t//\tparent.list_top.cseq_arr[i]\t\t\t= \"1\";\n\t\t\t\tparent.list_top.mnemonic_arr[i]\t\t= \"COLLECTION_STAGE\";\n\t\t\t\tparent.list_top.label_text_arr[i]\t= \"Collection Stage\";\n\t\t\t\tparent.list_top.accept_option_arr[i]= \"O\";\n\t\t\t\tparent.list_top.deflt_value_arr[i]\t= \"Separate\";\n\t\t\t\tparent.list_top.agegroup_arr[i]\t= \" \";\n\t\t\t\tparent.list_top.object_type_arr[i]\t= \"\";\n\t\t\t\tparent.list_top.value_arr1[i]\t\t= \"\";\n\t\t\t\tparent.list_top.value_arr2[i]\t\t= \"\";\n\t\t\t\ti++;\n\n\t\t\t\tord_cat = \"LB\" ;\n\t\t\t }\t //if lab in create mode\n\t\t}*/\n\n//\t\t\t\tvar topPageForm1 = parent.list_top.document.forms[0];\n\n\t\t\tif(topPageForm.defFlag.value  == \'1\'){//in case of Lab in create mode\n\t\t\tord_cat = \"LB\" ;\n\t\t\t}\n\t\t\t\n\t\t\tif(tmp_position1 == \"\") tmp_position1 = \" \";\n\t\t\tif(tmp_position2 == \"\") tmp_position2 = \" \";\n\n\t\t\tparent.list_top.seq_arr[i]\t\t\t= tmp_seq_no;\n\t\t\tparent.list_top.mnemonic_arr[i]\t\t= tmp_mnemonic;\n\t\t\tif(tmp_depend_yn == \"Y\"){\n\t\t\t\tparent.list_top.dependency_arr[i]\t= document.list_dtl.finalValue.value;//IN049133\n\t\t\t}\t\n\t\t\telse\n\t\t\t\tparent.list_top.dependency_arr[i]\t= tmp_depend_yn;//IN049133\n\t\t\tif((tmp_lbl_txt!=undefined) ||(tmp_lbl_txt!=null))\n\t\t\t{\n\t\t\t\tsetFormatValues(\"labeltext_\"+parentindex+\"Othernemonic_\"+indexLabel+\"array\"+i,tmp_lbl_txt);\t\t\t\t\n\t\t\t}\n\t\t\tparent.list_top.label_text_arr[i]\t= \"labeltext_\"+parentindex+\"Othernemonic_\"+indexLabel+\"array\"+i;\n\t\t\tparent.list_top.accept_option_arr[i]= tmp_accept_option;\n\t\t\tif((tmp_dflt_val!=undefined) ||(tmp_dflt_val!=null))\n\t\t\t{\n\t\t\t\tsetFormatValues(\"dfltValue_\"+parentindex+\"Othernemonic_\"+indexLabel+\"array\"+i,tmp_dflt_val);\t\t\t\t\n\t\t\t}\n\t\t\tparent.list_top.deflt_value_arr[i]\t= \"dfltValue_\"+parentindex+\"Othernemonic_\"+indexLabel+\"array\"+i;\n\t\t\tparent.list_top.agegroup_arr[i]\t\t\t= tmp_agegroup;\n\t\t\tparent.list_top.object_type_arr[i]\t= tmp_mnemonic_type\n\t\t\tparent.list_top.value_arr1[i]\t\t= tmp_position1;\n\t\t\tparent.list_top.value_arr2[i]\t\t= tmp_position2;\n\n\t}\t//insert mode\n\t\n\tif(parent.list_top.seq_arr.length>0){\n\t\t/*for (var repl=0;repl < parent.list_top.label_text_arr[count].length;repl++) {\n\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"&\") != -1) {\n\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"&\",\"�\");\n\t\t\t}\n\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"%\") != -1) {\n\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"%\",\"!!\");\n\t\t\t}\n\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"!!\") != -1) {\n\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"!!\",\"�\");\n\t\t\t}\n\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"+\") != -1) {\n\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"+\",\"�\");\n\t\t\t}\n\t\t\tif (parent.list_top.label_text_arr[count].indexOf(\"\\\\\") != -1) {\n\t\t\t\tparent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace(\"\\\\\",\"�\");\n\t\t\t}\n\t\t}*/\n\t\t\n\t\tfor(count=0; count<parent.list_top.seq_arr.length; count++){\n\t\t\t\n\t\t\tfinalString += parent.list_top.seq_arr[count]+\"$\"+parent.list_top.mnemonic_arr[count]+\"$\"+parent.list_top.label_text_arr[count]+\"$\"+parent.list_top.accept_option_arr[count]+\"$\"+parent.list_top.deflt_value_arr[count]+\"$\"+parent.list_top.agegroup_arr[count]+\"$\"+parent.list_top.object_type_arr[count]+\"$\"+parent.list_top.value_arr1[count]+\"$\"+parent.list_top.value_arr2[count]+\"$\"+parent.list_top.dependency_arr[count]+\"!!\";//IN049133 added dependency_arr\n\t\t\t//setFormatValues(\"dfltValueOthernemonic_array\"+tmp_seq_no,tmp_dflt_val);\n\t\t\t\n\n\t\t}\n\t\tif(parent.list_top.seq_arr.length>5)\n\t\t{\n\t\t\talert(getMessage(\'NO_MORE_MNEMONICS_SELECTED\',\'OR\'));\n\t\t\tdocument.list_dtl.seq_no.value = \"\";\n\t\t\tdocument.list_dtl.mnemonic.value = \"\";\n\t\t\tdocument.list_dtl.lbl_txt.value = \"\";\n\t\t//\tdocument.list_dtl.accept_option.selectedIndex = 0;\n\t\t\tdocument.list_dtl.dflt_val.value = \"\";\n\t\t\tdocument.list_dtl.agegroup.value= \"\";\n\t\t\tdocument.getElementById(\"deflt_value1\").innerHTML = \"\"\n\t\t\tdocument.getElementById(\"deflt_value2\").innerHTML = \"\"\n\t\t\tdocument.list_dtl.chk_depnd.checked = false;//IN049133\n\t\t\treturn false;\n\t\t}\n\t}\n\t//j var test = setFinalString(finalString)\n\t//alert(\"test:\"+test);\n \t//if(test == finalString) {\n \t//\talert(\"done\");\n \t//}\n\tdocument.list_dtl.finalString.value = finalString;\n\tdocument.list_dtl.mode.value = \"insert\";\n\tdocument.list_dtl.action\t = \"OrderEntryFormatTopDepend.jsp\";\n\tdocume";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="nt.list_dtl.target\t = \"list_top\";\n//\tdocument.list_dtl.submit();\t ---cannot get the err....\n\n\t//Add line\n//\talert(\"AGE Short DEsc:\"+age_group_sd);\n//alert(\"in bottom depend jsp,finalString=\"+finalString);\n//parent.list_top.document.location.href=\"../jsp/OrderEntryFormatTopDepend.jsp?finalString=\"+escape(finalString)+\"&ord_cat=\"+ord_cat+\"&age_group_sd=\"+age_group_sd+\"&age_group_cd=\"+age_group_cd;\n\n\tif(ord_cat == \"\")\n\t\tord_cat = document.list_dtl.ord_cat.value;\n\n\tparent.list_top.document.location.href=\"../jsp/OrderEntryFormatTopDepend.jsp?finalString=\"+finalString+\"&ord_cat=\"+ord_cat+\"&age_group_sd=\"+age_group_sd+\"&age_group_cd=\"+age_group_cd;\n\t//parent.list_top.document.location.href=\"../jsp/OrderEntryFormatTop.jsp?ord_cat=\"+ord_cat;\n\n\tdocument.list_dtl.seq_no.value = \"\";\n\tdocument.list_dtl.mnemonic.value = \"\";\n\tdocument.list_dtl.lbl_txt.value = \"\";\n\tdocument.list_dtl.accept_option.selectedIndex = 0;\n\tdocument.list_dtl.dflt_val.value = \"\";\n\tdocument.list_dtl.agegroup.value= \"\";\n\tdocument.list_dtl.dontChk.value = \"\";\n\tdocument.getElementById(\"deflt_value1\").innerHTML = \"\"\n\tdocument.getElementById(\"deflt_value2\").innerHTML = \"\"\n\tdocument.getElementById(\"depend1\").innerHTML = \"\"\n\tdocument.getElementById(\"depend2\").innerHTML = \"\"\n\n\tparent.list_bottom.list_dtl.clear.disabled = false;\n\tparent.list_bottom.list_dtl.seq_no.disabled = false;\n\tparent.list_bottom.list_dtl.mnemonic.disabled = false;\n\tparent.list_bottom.list_dtl.accept_option.disabled = false;\n}\n\n\n\nfunction takeValues(){\n\tvar level\t\t\t= document.list_dtl.level.value;\n\t//var tempfinalString=\"\";\n//\tvar ord_cat\t\t\t= document.ord_cat.level.value;\n\tvar topPageForm = parent.list_top.document.forms[0];\n\tvar finalString = \"\";\n\tif(parent.list_top.seq_arr.length>0 && parent.list_top.seq_arr.length<=5){\n\t\tfor(count=0; count<parent.list_top.seq_arr.length; count++){\t\t\n\t\t\t/*if( (level == \"L\") && (topPageForm.defFlag.value  == \'1\')){\n\t\t\t\tif((parent.list_top.seq_arr[count] == \"1\")||(parent.list_top.seq_arr[count] == \"2\")||(parent.list_top.seq_arr[count] == \"3\")){\n\t\t\t\t\tparent.list_top.agegroup_arr[count] = \" \";\n\t\t\t\t\tparent.list_top.object_type_arr[count] = \"\";\n\t\t\t\t\tparent.list_top.value_arr1[count] = \"\";\n\t\t\t\t\tparent.list_top.value_arr2[count] = \"\";\n\t\t\t\t}\n\t\t\t}*/\n\t\t\tif(parent.list_top.deflt_value_arr[count] == \"\")\n\t\t\t\tparent.list_top.deflt_value_arr[count] = \" \";\n\t\t\tif(parent.list_top.agegroup_arr[count] == \"\")\n\t\t\t\tparent.list_top.agegroup_arr[count] = \" \";\n\t\t\t\t//IN049133 - Start\n\t\t\tif(parent.list_top.dependency_arr[count] == \"\" || parent.list_top.dependency_arr[count] == undefined )\n\t\t\t\tparent.list_top.dependency_arr[count] = \" \";\n\t\t\tfinalString += parent.list_top.seq_arr[count]+\"$\"+parent.list_top.mnemonic_arr[count]+\"$\"+parent.list_top.label_text_arr[count]+\"$\"+parent.list_top.accept_option_arr[count]+\"$\"+parent.list_top.deflt_value_arr[count]+\"$\"+parent.list_top.agegroup_arr[count]+\"$\"+parent.list_top.object_type_arr[count]+\"$\"+parent.list_top.value_arr1[count]+\"$\"+parent.list_top.value_arr2[count]+\"$\"+parent.list_top.dependency_arr[count]+\"!!\";\n\t\t\t\t//IN049133 - End\n\t\t\t//+\"*\"+parent.list_top.position_arr[count]\n\t\t}\t\t\n\t}\n\t\t//var depend=finalString;\n\t\t//var depend1=finalString.split(\"^\");\n\t\t//if(depend1[1].indexOf(\"$$\")!=-1)\n\t\t\t//\t{\n\t\t\t//var applystr=depend1[1].split(\"$$\");\n\t\t\t\t//\tdepend1[1]=applystr[1];\n\t\t\t\t//}\n\t\t\t\t //tempfinalString=depend1[0].concat(\"^\").concat(depend1[1]).concat(\"^\").concat(depend1[2]).concat(\"^\").concat(depend1[3]).concat(\"^\").concat(depend1[4]).concat(\"^\").concat(depend1[5]).concat(\"^\").concat(depend1[6]).concat(\"^\").concat(depend1[7]).concat(\"^\").concat(depend1[8]);\n\tdocument.list_dtl.finalString.value = finalString;\t\n\twindow.returnValue = document.list_dtl.finalString.value;\n\twindow.close();\n}\n\n\n\nfunction checkIntegerRange(val,position1,position2){\n\tif(val == \"\" )\n\t\treturn true ;\n\n\t\tval = parseInt(val)\n\t\tposition1 = parseInt(position1)\n\t\tposition2 = parseInt(position2)\n\n\t\tif(!((val >= position1) && (val <= position2))){\n\t\t\treturn false\n\t\t}\n\treturn true\n}\n\n// this is to check whether the decimal is a valid decimal - should validate number like 23.3.44\nfunction isValidDecimal(val){\n\tif(isNaN(val)){\n\t\talert(getMessage(\'INVALID_DECIMAL_NUMBER\',\'OR\'));\n\t\t//alert(\'Not a Valid Decimal Number\');\n\t\treturn false\n\t}else{\n\t\treturn true\n\t}\n}\n\nfunction checkDecimalRange(val,position1,position2){\n\tvar val_length = val.length;\n\n\tif(val == \"\" )\n\t\treturn true ;\n\tif(val.indexOf(\".\") != -1){\n\t\tval = parseFloat(val)\n\n\t\tposition1 = parseFloat(position1)\n\t\tposition2 = parseFloat(position2)\n\t\tif(!((val >= position1) && (val <= position2))){\n\t\t\treturn false\n\t\t}\n\n\t}else{\n\t\tval = parseFloat(val)\n\t\tposition1 = parseFloat(position1)\n\t\tposition2 = parseFloat(position2)\n\n\t\tif(!((val >= position1) && (val <= position2))){\n\n\t\t\treturn false\n\t\t}\n\t}\n\treturn true\n}\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n</head>\n<html>\n<body onload=\'FocusFirstElement();\' onunload=\"javascript:closeWindow()\"  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n\n<form name=\"list_dtl\" id=\"list_dtl\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<input type=hidden name=\'install_yn\' id=\'install_yn\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<input type=hidden name=\'level\' id=\'level\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\n<table cellpadding=0 cellspacing=0 border=0 width=\"98%\" align=center>\n\n<tr><td colspan=2>&nbsp;</td></tr>\n\n<tr><td width=\"40%\" class=\"label\" align=\"right\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td><td class=\"fields\"><input type=text name=\"seq_no\" id=\"seq_no\" value=\"\" size=2 maxlength=2 onKeyPress=\'return allowPositiveNumber()\' onChange=\"populateListValues(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'mnemonic\',\'\',\'seqTop\')\" onBlur=\"return checkPositiveNumber(this)\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td></tr>\n\n<!-- <tr><td width=\"40%\" class=\"label\" align=\"right\"> Column Sequence No&nbsp;</td><td><input type=text name=\"cseq_no\" id=\"cseq_no\" value=\"\" size=2 maxlength=1 onKeyPress=\"return limitNumber()\" >&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td></tr>\n -->\n<tr>\n\t<td width=\"40%\" class=\"label\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td >\n\t\t<!--<SELECT name=\"mnemonic\" id=\"mnemonic\" onChange=\"populateValues2()\" > -->\n\t\t<SELECT name=\"mnemonic\" id=\"mnemonic\" onChange=\"populateValues3()\" > <!--IN049133-->\n\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ---</option>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<!-- <option value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="$$";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option> -->\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</SELECT><img src=\"../../eCommon/images/mandatory.gif\">\n\t</td>\n</tr>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<tr><td width=\"40%\" class=\"label\" >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td><td><input type=text name=\"lbl_txt\" id=\"lbl_txt\" value=\"\" size=50 maxlength=50  onKeyPress=\'checkSpecialChar(event);\'  onBlur=\'return checkSpecialCharBlur(this)\'><img src=\"../../eCommon/images/mandatory.gif\"></td></tr>   <!--onKeyPress = \'return CheckForSpecCharsWithoutSpace(event)\' -->\n\t<tr><td width=\"40%\" class=\"label\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td><td class=\"fields\"><SELECT name=\"accept_option\" id=\"accept_option\" ><option value=\"O\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option><option value=\"R\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option><option value=\"D\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option></SELECT></td></tr>\n\t<tr>\n\t\t<td  id=\'deflt_value1\' class=label ></td>\n\n\t\t<td  id=\'deflt_value2\' class=\"fields\" ><!--   style=\"visibility:hidden\"-->\n\t\t\t<!-- <select name=\"dflt_val\" id=\"dflt_val\"><option value=\'\'>-----Select-----</select> -->\n\t\t</td>\n\t</tr>\n\t<tr><td width=\"40%\" class=\"label\" >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" </td>\n\t    <td class=\"fields\">\n\t\t<SELECT name=\"agegroup\" id=\"agegroup\" >\n\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" ---  \n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</option>\n\t\t\t\t<!-- <input type=hidden name=\"\" id=\"\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'> -->\n\t\t\t             \n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t</SELECT>\n\t\t</td>\n\t</tr>\n\t<!-- <tr><td colspan=2>&nbsp;</td></tr> -->\n\t<!-- IN049133 modified-->\n\t<!--<tr style=\'display:none\'> -->\n\t<tr>\n\t\t<td  id=\'depend1\' class=label ></td>\n\n\t\t<td  id=\'depend2\' class=\"fields\" >\n\t\t</td>\n\t</tr>\n\t\n<tr>\n\t<td colspan=2 align=right>\n\t<input type=hidden name=\"finalString\" id=\"finalString\" value=\"\">\n\t<input type=button class=\"button\" name=\"select\" id=\"select\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onClick=\"chkMandatory();\">\n\t<input type=button class=\"button\" name=\"ok\" id=\"ok\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onClick=\"takeValues();\">\n\t<input type=button  class=\"button\" name=\"clear\" id=\"clear\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"  onClick=\"removeValues();\">\n\t<input type=button class=\"button\" name=\"close\" id=\"close\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" onClick=\"closeWindow();\">\n\t</td>\n</tr>\n</table>\n<input type=hidden name=\'ord_cat\' id=\'ord_cat\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=hidden name=\'object_format_type\' id=\'object_format_type\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=hidden name=\'order_type\' id=\'order_type\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=hidden name=\'order_catalog\' id=\'order_catalog\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=hidden name=\'level1\' id=\'level1\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=hidden name=\'finalString\' id=\'finalString\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=hidden name=\'finalValue\' id=\'finalValue\' value=\"\">\n<input type=hidden name=\'index\' id=\'index\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=hidden name=\'format_id\' id=\'format_id\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=hidden name=\'parentindex\' id=\'parentindex\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=hidden name=\'mode\' id=\'mode\' value=\"\">\n<input type=hidden name=\'old_mnemonic\' id=\'old_mnemonic\' value=\"\">\n<input type=hidden name=\'old_seq_no\' id=\'old_seq_no\' value=\"\">\n<input type=hidden name=\'old_lbl_txt\' id=\'old_lbl_txt\' value=\"\">\n<input type=hidden name=\'old_accept_opt\' id=\'old_accept_opt\' value=\"\">\n<input type=hidden name=\'old_dflt_val\' id=\'old_dflt_val\' value=\"\">\n<input type=hidden name=\'old_agegroup\' id=\'old_agegroup\' value=\"\">\n<input type=hidden name=\'old_order_type\' id=\'old_order_type\' value=\"\">\n<input type=hidden name=\'old_position\' id=\'old_position\' value=\"\">\n<input type=hidden name=\'old_dependency_yn\' id=\'old_dependency_yn\' value=\"\"><!--IN049133-->\n<input type=hidden name=\'dontChk\' id=\'dontChk\' value=\"\">\n\n</form>\n\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
 	
   request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String ord_cat = request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");
	String level = request.getParameter("level")==null?"":request.getParameter("level");
	String index = request.getParameter("index")==null?"":request.getParameter("index");
	String parentindex = request.getParameter("parentindex")==null?"":request.getParameter("parentindex");
	String object_format_type = request.getParameter("object_format_type")==null?"":request.getParameter("object_format_type");
	String format_id = request.getParameter("format_id")==null?"":request.getParameter("format_id");
	String order_type =  request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String order_catalog = request.getParameter("ord_catalog")==null?"":request.getParameter("ord_catalog");
	String finalString = request.getParameter("finalString");
	String mnemonic = request.getParameter("mnemonic");
    out.println("<input type=hidden name='depend_mnemonic' id='depend_mnemonic' value='"+mnemonic+"'>" );
	ArrayList Mnemonic_Data =  new ArrayList();
	ArrayList AgeGroup_Data =  new ArrayList();  
	String bean_id = "Or_OrderEntryFormats" ;
	String bean_name = "eOR.OrderEntryFormats";
	String install_yn = "N";
	OrderEntryFormats bean = (OrderEntryFormats)getBeanObject( bean_id,  bean_name, request ) ;
	if(ord_cat.equals("RD"))
		install_yn = bean.getInstallyn(ord_cat);


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(level));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
try{
				Mnemonic_Data = bean.getMnemonic(ord_cat,level);//IN038529

				for(int i=0; i<Mnemonic_Data.size(); i++){
					String[] record = (String [])Mnemonic_Data.get(i);
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
			}catch(Exception e){
				e.printStackTrace();
			}
		
            _bw.write(_wl_block22Bytes, _wl_block22);

		for(int i=0; i<Mnemonic_Data.size(); i++){
			String[] record = (String [])Mnemonic_Data.get(i);
			if(record[2] == null)record[2] = "";
			if(record[3] == null)record[3] = "";
			out.println("<input type=hidden name='hdn_fld_type"+(i+1)+"' id='hdn_fld_type"+(i+1)+"' value='"+record[1]+"'>" );
			out.println("<input type=hidden name='hdn_minVal"+(i+1)+"' id='hdn_minVal"+(i+1)+"' value='"+record[2]+"'>" );
			out.println("<input type=hidden name='hdn_maxVal"+(i+1)+"' id='hdn_maxVal"+(i+1)+"' value='"+record[3]+"'>" );
			out.println("<input type=hidden name='single_multiple"+(i+1)+"' id='single_multiple"+(i+1)+"' value='"+record[4]+"'>" );
			out.println("<input type=hidden name='presentation_type"+(i+1)+"' id='presentation_type"+(i+1)+"' value='"+record[5]+"'>" );
		}

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
try{String res="";String res1="";
				AgeGroup_Data = bean.getAgeGroup();
				for(int i=0; i<AgeGroup_Data.size(); i++){
					String[] record = (String [])AgeGroup_Data.get(i);
			
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(res.equals("") && res1.equals(""))
					 {
						res = record[0];
						res1 = record[1];
					 }
					 else
					 {
						res =res +":"+record[0];
						res1 =res1+":"+record[1];
					 }
				}
				 out.println("<input type=hidden name='age_group_sd' id='age_group_sd' value='"+res+"'>" );
				 out.println("<input type=hidden name='age_group_cd' id='age_group_cd' value='"+res1+"'>" );
			}catch(Exception e){
				e.printStackTrace();
			}
		
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(object_format_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(order_catalog));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(level));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(finalString));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(index));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(format_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(parentindex));
            _bw.write(_wl_block47Bytes, _wl_block47);


		putObjectInBean(bean_id,bean,request);
 

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SequenceNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FieldMnemonicDesc.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.labelText.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AcceptOption.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Optional.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.required.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DisplayOnly.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.agegroup.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
