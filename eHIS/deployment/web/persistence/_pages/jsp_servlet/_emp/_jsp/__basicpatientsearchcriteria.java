package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __basicpatientsearchcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/BasicPatientSearchCriteria.jsp", 1742476495830L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/23/2005 11:28 AM -->\t\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eMP/js/SmartCard.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eXH/js/ExternalApplication.js\" language=\"JavaScript\"></Script><!--Added by kamatchi S form MOHE-CRF-0016.1 on 26-AUG-2020-->\n<Script language=\'javascript\' src=\'../../eMP/js/PatientSearch.js\'></Script><!--Added by Lakshmanan form MOHE-CRF-00164.1 on 17-feb-2022-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<Script src=\"../../eMP/js/json02.js\"></Script>\n<Script src=\"../../eMP/js/jquery.min.js\"></Script>\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<Script language=\"JavaScript\"src=\"../../eCommon/js/DateUtils.js\" ></Script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n    <head>\n        <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n          \n        <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>       \n\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n        <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n        <Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration3.js\'></Script>\n\t\t<Script language=\'javascript\' src=\'../../eMP/js/PatientSearch.js\'></Script>\n        <Script language=\"JavaScript\">\n            //Added by kumar on 16/03/2003 for Family Name Search if Pat Name as Multi Part is N\n\t\t\tfunction EnableFamSearch(obj)\n\t\t\t{\n\t\t\t\t\n\t\t\t}\n\n        </Script>\n\n\n\n\n    </head>\n\n                         ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\n\n    <body class=\'content\' topmargin=\'0\' OnMouseDown=\"CodeArrest()\" onLoad=\"\" onKeyDown = \'lockKey()\'> \n    <form name=\"Basic_Patient_Search_Form\" id=\"Basic_Patient_Search_Form\" method=\'post\' action=\'../../eMP/jsp/BasicPatientSearchCriteria.jsp\'>\n\t<input type=\"hidden\" name=\"maintain_doc_or_file\" id=\"maintain_doc_or_file\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type =\'hidden\' name=\'family_org_id_accept_yn\' id=\'family_org_id_accept_yn\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></input>\n\t<input type =\'hidden\' name=\'func_idpassed\' id=\'func_idpassed\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></input>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\n\n    <a name=\'simple\' id=\'simple\'></a>\n\t\n\n<center>\n            <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\">\n\t\t\t<tr>\n                    <td width=\'100%\' class=\"BORDER\" valign=top>\n\t\t\t\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\">\t\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  width=\'20%\' class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\n\t\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"fields\" ><input type=\"text\" name=\"Patient_Id1\" id=\"Patient_Id1\" onKeyPress=\"return CheckForSpecChars(event)\"  size=\"25\" onFocus=\"MoveFocusSimple(2)\" maxlength=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" onBlur=\"makeValidQueryCriteria(this);ChangeCase(this)\"> &nbsp; \n\t\t\t\t\t\t\t\t\t\t<select name=\"patient_id_search_by\" id=\"patient_id_search_by\">\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"S\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"C\" selected>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<td  width=\'20%\' class=\"label\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"fields\"><input type=\"text\" name=\"National_Id_No1\" id=\"National_Id_No1\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" \n\t\t\t\t\t\t\t\t\t\tonKeyPress=\"return CheckForSpecChars(event)\" onBlur=\"makeValidQueryCriteria(this)\" onFocus=\"MoveFocusSimple(2)\"> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="  \n\t\t\t\t\t\t\t\t\t\t<input name=\'NatID_Btn\' id=\'NatID_Btn\' class=\'button\' Onclick=\"NationalID_Search(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\" type=\"button\" value=\'M\'    ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </td>\n\t\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t  <input type=\"hidden\" name=\"National_Id_No1\" id=\"National_Id_No1\"  \n\t\t\t\t\t\t\t\t       value=\'\'> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" <!--Below line modified by venkatesh on 07/Oct/2013 against 43291-->\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t    <td  width=\'20%\' class=\"label\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t     <td  width=\'30%\' class=\"fields\" ><input type=\"text\" name=\"Alt_Id1_No1\" id=\"Alt_Id1_No1\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" value=\'\' onKeyPress=\'return CheckForSpeclChars(event,\"Alt_Id1\")\'onFocus=\"MoveFocusSimple(2)\" onBlur=\"makeValidQueryCriteria(this);enableSuffix()\"  ><input type=\"hidden\" name=\"Expiry_Date11\" id=\"Expiry_Date11\" size=\"18\" maxlength=\"10\"  onFocus=\"MoveFocusSimple(1)\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"newborn_suffix\" id=\"newborn_suffix\" size=\'1\' onKeyPress=\"return allowValidNumber(this,event,2,0);\" onBlur=\"makeValidQueryCriteria(this);\"\n\t\t\t\t\t\t\t\tmaxlength=\'2\'  disabled></td>\n                            ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="   \n\t\t\t\t\t\t\t\t<!--below code change done for SRR20056-SCF-12671-->\n\t\t\t\t\t\t\t\t<td  width=\'20%\' class=\"label\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"fields\"><input type=\"text\" name=\"Alt_Id2_No1\" id=\"Alt_Id2_No1\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" value=\'\' onKeyPress=\"return altID234Validations(event)\" onBlur=\"makeValidQueryCriteria(this)\" onFocus=\"MoveFocusSimple(2)\" ><input type=\"hidden\" name=\"Expiry_Date21\" id=\"Expiry_Date21\" size=\"8\" maxlength=\"10\"  onFocus=\"MoveFocusSimple(1)\"></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<!--Added by kamatchi S form MOHE-CRF-0016.1 on 26-AUG-2020-->\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t<td class=\'label\'  width=\'15%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t\t\t\t<td class=\'fields\' ><div id=\'insurance_div\'><textarea name=\'insurance_id\' id=\'insurance_id\' rows=\"3\" cols=\"50\" maxlength=\"300\"  tabindex = \'6\'   value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" readonly></textarea>&nbsp;<input type=\'button\' class=\'button\' Value=\' Read \' onClick=\'insCardReader(insurance_id,insurance_div)\'> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"insurance_id_1\" id=\"insurance_id_1\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></div></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"fields\"><input type=\"text\" name=\"Alt_Id3_No1\" id=\"Alt_Id3_No1\" size=\"25\" value=\'\' maxlength=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onKeyPress=\"return altID234Validations(event)\" onBlur=\"makeValidQueryCriteria(this)\" onFocus=\"MoveFocusSimple(2)\" ><input type=\"hidden\" name=\"Expiry_Date31\" id=\"Expiry_Date31\" size=\"8\" maxlength=\"10\"  onFocus=\"MoveFocusSimple(1)\"></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<!--below code change done for SRR20056-SCF-12671-->\n\t\t\t\t\t\t\t\t<td  width=\'20%\' class=\"label\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"fields\"><input type=\"text\" name=\"Alt_Id4_No1\" id=\"Alt_Id4_No1\" size=\"25\" maxlength=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" value=\'\' onKeyPress=\"return altID234Validations(event)\" onBlur=\"makeValidQueryCriteria(this)\" onFocus=\"MoveFocusSimple(2)\" ><input type=\"hidden\" name=\"Expiry_Date41\" id=\"Expiry_Date41\" size=\"8\" maxlength=\"10\"  onFocus=\"MoveFocusSimple(1)\" ></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t</tr>\n\t\t\t\t<!--<tr>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"pat_name1\" id=\"pat_name1\" size=\"25\" value=\'\' maxlength=\"80\" onBlur=\"ChangeInitCase(this);\"></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"pat_name_local1\" id=\"pat_name_local1\" size=\"25\" value=\'\' maxlength=\"80\"></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t</tr>-->\n\n<!--Patient Name Derivation Logic Starts For Basic Search-->\n<!--modified onBlur=\'makeValidQueryCriteria\' to  onBlur=\'makeValidString\' for the incident IN031010 on 8-3-2012 by Shanthi Begins-->\n\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t     <input type=\"hidden\" name=\"First_Name1\" id=\"First_Name1\">\n\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"Second_Name1\" id=\"Second_Name1\">\n\t\t\t\t\t\t\t\t <input type=\"hidden\" name=\"Third_Name1\" id=\"Third_Name1\">\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t    \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t<tr>  \n                                ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n                               \n                          ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n                           \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t<tr>                    \n                           \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</tr><tr>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</tr>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t</tr>\n\n<!--modified onBlur=\'makeValidQueryCriteria\' to  onBlur=\'makeValidString\' for the incident IN031010 on 8-3-2012 by Shanthi Ends-->\n<!--Patient Name Derivation Logic Ends For Basic Search -->\n\n\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"pr_resNo1\" id=\"pr_resNo1\" size=\"25\" value=\'\' maxlength=\"20\"></td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"label\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t\t\t\t\t\t<td  width=\'25%\' class=\"fields\"><input type=\"text\" name=\"oth_no1\" id=\"oth_no1\" size=\"25\" value=\'\' maxlength=\"20\" onblur=\'movefocusout(this)\'></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td   class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td> <td class=\'fields\'>\n\t\t\t\t<select name=\'order_by1\' id=\'order_by1\'>\n\t\t\t\t<OPTION value=\'P\'>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<!--Patient Id defaulted in the search patient page for the incident 30979 by Shanthi on 22-2-2012 -->\n\t\t\t\t<OPTION value=\'X\'>----";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="----\n\t\t\t\t \n\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t\t<td/><td/>\n\t\t\t\t</tr>\n\n</table>\n</center>\n   </table>\n\t\t\t\n   </table>\n   <!-- <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><br><br> -->\n<input type=\'hidden\' name=\'isAlternateAddressAppl\' id=\'isAlternateAddressAppl\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601-->\n<input type=\'hidden\' name=\'isAddressLengthIncAppl\' id=\'isAddressLengthIncAppl\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"><!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2-->\n <input type=\"hidden\" name=\"isInsuranceCardReader\" id=\"isInsuranceCardReader\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"><!--Added by kamatchi S for MOHE-CRF-0016.1 ON 28-AUG-2020-->\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t<!--//Maheshwaran K added for MMS-DM-CRF-0208.1 - suspend_inactive_pat_yn-->\n\t<input type=\"hidden\" name=\"suspend_inactive_pat_yn\" id=\"suspend_inactive_pat_yn\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n    <input type=\"hidden\" name=\"1\" id=\"1\" value=\"\">\n    <input type=\"hidden\" name=\"FULLSQL\" id=\"FULLSQL\" value=\"\">\n    <input type=\"hidden\" name=\"ORDERBY\" id=\"ORDERBY\" value=\"\">\n    <input type=\"hidden\" name=\"jsp_name\" id=\"jsp_name\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n    <input type=\"hidden\" name=\"window_styl\" id=\"window_styl\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n    <input type=\"hidden\" name=\"close_yn\" id=\"close_yn\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n    <input type=\"hidden\" name=\"register_button_yn\" id=\"register_button_yn\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n    <input type=\"hidden\" name=\"func_act\" id=\"func_act\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n    <input type=\"hidden\" name=\"soundex_dflt\" id=\"soundex_dflt\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\'hidden\' name=\'alt_id1_accept_alphanumeric\' id=\'alt_id1_accept_alphanumeric\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n   \t<input type=\"hidden\" name=\"names_in_oth_lang_yn_hd\" id=\"names_in_oth_lang_yn_hd\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n   \t<input type=\"hidden\" name=\"pat_name_as_multipart_yn_hd\" id=\"pat_name_as_multipart_yn_hd\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<!-- Suresh on 13.12.2010 language_direction -->\n   \t<input type=\"hidden\" name=\"language_direction\" id=\"language_direction\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n   \t<input type=\"hidden\" name=\"simplesearch_select_yn\" id=\"simplesearch_select_yn\" value=\"Y\">\n   \t<input type=\"hidden\" name=\"morelessexpand\" id=\"morelessexpand\" value=\"Y\">\n\n   \t<input type=\"hidden\" name=\"cr_jsp_name\" id=\"cr_jsp_name\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n   \t<input type=\"hidden\" name=\"cr_window_styl\" id=\"cr_window_styl\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n   \t<input type=\"hidden\" name=\"cr_close_yn\" id=\"cr_close_yn\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n   \t<input type=\"hidden\" name=\"cr_win_top\" id=\"cr_win_top\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n   \t<input type=\"hidden\" name=\"cr_win_width\" id=\"cr_win_width\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n   \t<input type=\"hidden\" name=\"cr_win_height\" id=\"cr_win_height\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n   \t<input type=\"hidden\" name=\"cr_act_yn\" id=\"cr_act_yn\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n   \t<input type=\"hidden\" name=\"cr_srr\" id=\"cr_srr\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n   \t<input type=\"hidden\" name=\"cr_register_button_yn\" id=\"cr_register_button_yn\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n   \t<input type=\"hidden\" name=\"cr_func_act\" id=\"cr_func_act\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n   \t<input type=\"hidden\" name=\"cr_defaultgender\" id=\"cr_defaultgender\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n   \t<input type=\"hidden\" name=\"cr_enablegenderyn\" id=\"cr_enablegenderyn\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n   \t<input type=\"hidden\" name=\"cr_function_id\" id=\"cr_function_id\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n   \t<input type=\"hidden\" name=\"cr_func_idpassed\" id=\"cr_func_idpassed\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n   \t<input type=\"hidden\" name=\"Gender\" id=\"Gender\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t<!--Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]-->\n\t<input type=\"hidden\" name=\"alt_id1_pat_sch_exact_yn\" id=\"alt_id1_pat_sch_exact_yn\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t<input type=\"hidden\" name=\"alt_id2_pat_sch_exact_yn\" id=\"alt_id2_pat_sch_exact_yn\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\"hidden\" name=\"alt_id3_pat_sch_exact_yn\" id=\"alt_id3_pat_sch_exact_yn\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\"hidden\" name=\"alt_id4_pat_sch_exact_yn\" id=\"alt_id4_pat_sch_exact_yn\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n    <!--Below line added for this CRF HSA-CRF-0289 -->\t\n\t  <input type=\"hidden\" name=\"alterIdSearch\" id=\"alterIdSearch\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t  <input type=\"hidden\" name=\"isAlternateId\" id=\"isAlternateId\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t  <input type=\"hidden\" name=\"alternate_no\" id=\"alternate_no\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\n\t  <input type=\"hidden\" name=\"fam_name_ind\" id=\"fam_name_ind\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t  <!--//Added by Maheshwaran K for AAKH-CRF-0168-->\n  <input type=\"hidden\" name=\"dft_national_id\" id=\"dft_national_id\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t   <!--Added by Rameswar on  19-04-2016 for HSA-CRF-0299 -->\n\t  \n   </form>\n    <script>\n\tif(\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'!=\"\"&&\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'==\"true\"){ \n\t     setTimeout(\"AlternateIdFocus(\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\')\",500)\n\t}else{ \n\t     setTimeout(\'FocusFirstElement()\',500)\n\t}</script>\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	
	if(session.getValue("smart_path")!= null) {
		if(!session.getValue("smart_path").equals(" ")){
			out.println(session.getValue("smart_path"));
		}
	}
	
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>");
		}
	}
	
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sessionID 		= 			session.getId();
	String facility			= (String) session.getValue("facility_id");
	String loginUser		= (String) session.getValue("login_user");
	Properties p = (java.util.Properties) session.getValue("jdbc");
	String p_ws_no = p.getProperty("client_ip_address");

    Connection con = null;
    PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
    ResultSet rs=null;
    ResultSet rs1=null;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String language_direction="";
	//String pat_ser_grp_code="";
	//String pat_ser_grp_desc="";
	int count=0;
	String nat_id_prompt ="";
	String names_in_oth_lang_yn="";
	String ext_system_interface_yn="";
	String nat_data_source_id="";
    String First_Name_Accept_Yn ="";
    int First_Name_Order=0;
    String First_Name_Prompt ="";
    String Second_Name_Accept_Yn ="";
    int Second_Name_Order =0;
    String Second_Name_Prompt ="";
    String Third_Name_Accept_Yn ="";
    int Third_Name_Order =0;
    String Third_Name_Prompt ="";
    String Family_Name_Accept_Yn =""; 
    int Family_Name_Order =0;
    String Family_Name_Prompt ="";
    int patient_id_length =0;
    int nat_id_length =0;
    int alt_id1_length =0;
    int alt_id2_length =0;
    int alt_id3_length =0;
    int alt_id4_length =0;

    String Family_No_Link_Yn ="";
    String Family_No_Prompt ="";
    String Res_Area_Prompt = "";
    //String orderby="";
    String Alt_Id1 = "" ;
    String Alt_Id2 = "" ;
    String Alt_Id3 = "" ;
    String Alt_Id4 = "" ;
	String prn_label="";
	String orn_label="";
    String addl_field1_prompt = "";
    int addl_field1_length = 0;
    String addl_field2_prompt = "";
    int addl_field2_length = 0;
    String addl_field3_prompt = "";
    int addl_field3_length = 0;
    String addl_field4_prompt = "";
    int addl_field4_length = 0;
    String addl_field5_prompt = "";
    int addl_field5_length = 0;
	String accept_national_id_no_yn = "N";
	String nat_id_accept_alphanumeric_yn = "N";
	String alt_id1_accept_alphanumeric_yn ="";
	String accept_oth_alt_id_yn = "N";
	String family_org_id_accept_yn = "N";
	String Family_Name_loc_lang_Prompt="";
	String Third_Name_loc_lang_Prompt="";
	String Second_Name_loc_lang_Prompt="";
	String First_Name_loc_lang_Prompt="";
	String jsp_name=request.getParameter("jsp_name");
	String cr_jsp_name=request.getParameter("jsp_name");
    String window_styl=request.getParameter("window_styl");
    String cr_window_styl=request.getParameter("window_styl");
    String close_yn=request.getParameter("close_yn");
    String cr_close_yn=request.getParameter("close_yn");
    //String win_height   =request.getParameter("win_height");
    String cr_win_height   =request.getParameter("win_height");
  //  String win_width    =request.getParameter("win_width");
    String cr_win_width    =request.getParameter("win_width");
   // String win_top      =request.getParameter("win_top");
    String cr_win_top      =request.getParameter("win_top");
   // String act_yn   =request.getParameter("act_yn");
    String cr_act_yn   =request.getParameter("act_yn");
   // String srr = request.getParameter("srr");
    String cr_srr = request.getParameter("srr");
    String register_button_yn = request.getParameter("register_button_yn");
    String cr_register_button_yn = request.getParameter("register_button_yn");
    String func_act = request.getParameter("func_act");
    String cr_func_act = request.getParameter("func_act");
    func_act = (func_act == null)?"":func_act;
    String func_idpassed = request.getParameter("func_idpassed");
    String cr_func_idpassed = request.getParameter("func_idpassed");
	if (func_idpassed == null || func_idpassed.equals("null")) func_idpassed = "";
	if (cr_func_idpassed == null || cr_func_idpassed.equals("null")) cr_func_idpassed = "";

	String defaultgender        =   request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
	String cr_defaultgender        =   request.getParameter("default_gender")==null?"":request.getParameter("default_gender");
    String enablegenderyn   =   request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");
    String cr_enablegenderyn   =   request.getParameter("enable_gender_yn")==null?"":request.getParameter("enable_gender_yn");
	
	//Added for this CRF HSA-CRF-0289
	String alterIdSearch=request.getParameter("alterIdSearch")==null?"":request.getParameter("alterIdSearch");
	String isAlternateId=request.getParameter("isAlternateId")==null?"":request.getParameter("isAlternateId");
	String alternate_no=request.getParameter("alternate_no")==null?"":request.getParameter("alternate_no");
	//End HSA-CRF-0289
	//Maheshwaran K added for MMS-DM-CRF-0208.1 - suspend_inactive_pat_yn
	String suspend_inactive_pat_yn=request.getParameter("suspend_inactive_pat_yn")==null?"N":request.getParameter("suspend_inactive_pat_yn");

    String self     = "";
    String selm = "";
    String dis      = "";
    String sdisable = "";
	//Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
	String alt_id1_pat_sch_exact_yn="";
	String alt_id2_pat_sch_exact_yn="";
	String alt_id3_pat_sch_exact_yn="";
	String alt_id4_pat_sch_exact_yn="";

    if(defaultgender.equals("F")) self = "selected";
    else if(defaultgender.equals("M")) selm = "selected";

    if(enablegenderyn.equals("N")) dis = "DISABLED";


    String Soundex ="";
  //  String fieldname = "";
 //   String str="";
 //   String str_new ="";
  //  String dateofbirthyn="N";
    //Added by kumar on 8/3/2002 for DR Module
    String function_id  =   request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
    String cr_function_id  =   request.getParameter("dr_function_id")==null?"":request.getParameter("dr_function_id");
   
    if(!function_id.equals("") && !function_id.equals("PAT_REG") && !function_id.equals("NEWBORN_REG")) sdisable = "disabled";
	
	if(func_act.equals("DuplicateRegistration"))
	sdisable = "";
	String dr_install_yn = "N";
   // boolean Sndx = false;
    String errFlag = "N";
	String separate_file_no_yn = "N";
	String mrn_length = "20";
	int cntPrefFac = 0;
	String dft_national_id="";
	String pat_name_as_multipart_yn	= "";
	String maintain_doc_or_file		= "";
	String docDisableField			= "";
	String first_name_length = "";
	String second_name_length = "";
	String third_name_length = "";
	String family_name_length = "";
	String file_type_appl_yn = "";
	String firstRowElement="";
	String firstRowCompleted="";

	/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
	String fam_name_ind="N";

	boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

	boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2
	
	boolean isPatientNameContainsAppl = false;  //Added by Mujafar  against ML-MMOH-CRF-1127
	String select_val=""; //Added by Mujafar  against ML-MMOH-CRF-1127
	/*Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020*/
	boolean isInsuranceCardReader = false;
	
	String Smartcard_path="" ; //Added by lakshmanan MOHE-CRF-0164.1 
	String function_name="" ; //Added by lakshmanan MOHE-CRF-0164.1 
			
	String insurance_id = "";
	/*Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020*/
	try 
	{	 
		con = ConnectionManager.getConnection(request);
		//for smart card
		pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

		rs = pstmt.executeQuery();	


		if(rs!=null && rs.next())
		{
		Smartcard_path=rs.getString("VALUE_1");
		function_name=rs.getString("VALUE_2");  

		}
		

		isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601

		isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0860.2
		
		isPatientNameContainsAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","PATIENT_NAME_CONTAINS_APPL"); //Added by Mujafar  against ML-MMOH-CRF-1127

		isInsuranceCardReader = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INSURANCE_CARD_READER"); //Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020

		
		if(isPatientNameContainsAppl)
			select_val = "selected";
		
		if(pstmt!=null)
		pstmt.close();
		if(rs!=null)
		rs.close();
		
		
		
		

        pstmt = con.prepareStatement("SELECT Dflt_Sndx_type, separate_file_no_yn, pat_name_as_multipart_yn, maintain_doc_or_file,family_org_id_accept_yn,first_name_length, second_name_length,third_name_length,family_name_length,file_type_appl_yn,dft_national_id FROM mp_param where module_id='MP'");
        rs=pstmt.executeQuery();
        if(rs.next()) 
		{
            Soundex = checkForNull(rs.getString(1));      
			separate_file_no_yn = checkForNull(rs.getString(2));
			pat_name_as_multipart_yn = checkForNull(rs.getString(3));
			maintain_doc_or_file = checkForNull(rs.getString(4));
			first_name_length = rs.getString("first_name_length");
			second_name_length = rs.getString("second_name_length");
			third_name_length = rs.getString("third_name_length");
			family_name_length = rs.getString("family_name_length");
			file_type_appl_yn = checkForNull(rs.getString("file_type_appl_yn"));
			if(maintain_doc_or_file == null) maintain_doc_or_file = "F";
			family_org_id_accept_yn = checkForNull(rs.getString("family_org_id_accept_yn"),"N"); 
			dft_national_id=checkForNull(rs.getString("dft_national_id"));//Added by Maheshwaran K for AAKH-CRF-0168
        }       
        else
        {
            errFlag = "Y";
            out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));</script>");
            out.println("<script>parent.window.close();</script>");         
        }
		
		if(maintain_doc_or_file.equals("D")) docDisableField = "disabled";
	    try 
		{
			pstmt = con.prepareStatement("Select install_yn from sm_module where module_id ='DR'");
	        rs=pstmt.executeQuery();
			if(rs.next()) 
			{           
				dr_install_yn= rs.getString(1);
			}
		}
		catch(Exception e)
		{   
			out.println(e.toString());
		}

		try 
		{
pstmt = con.prepareStatement("Select count(1) from mp_pat_search_result where field_select='Y' and UPPER(field_name)='PREF_FACILITY_ID'");
			rs=pstmt.executeQuery();
			if(rs.next()) 
			{           
				cntPrefFac = rs.getInt(1);
			}
		}
	    catch(Exception e)
		{   
			out.println(e.toString());
		}

		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

		
		
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();


		pstmt = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status = 'E'" ) ;
		
		rs = pstmt.executeQuery() ;
             
			
        if ( rs != null && rs.next() ) 
		 {
		 count = rs.getInt("total");
		 }

		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}


		 if(pstmt != null) pstmt.close();
		 if(rs != null) rs.close();
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

                            try{
								  //String sql1="Select nvl(param.Nat_Id_Prompt, 'National ID No') Nat_ID_Prompt, param.nat_data_source_id,  param.Patient_Id_Length,param.Nat_Id_Length,param.Family_No_Link_Yn,param.Family_No_Prompt,param.First_Name_Accept_Yn,param.First_Name_Order,param.First_Name_Prompt,param.Second_Name_Accept_Yn,param.Second_Name_Order,param.Second_Name_Prompt,param.Third_Name_Accept_Yn,param.Third_Name_Order,param.Third_Name_Prompt,param.Family_Name_Accept_Yn,param.Family_Name_Order,param.Family_Name_Prompt,First_Name_loc_lang_Prompt, Second_Name_loc_lang_Prompt, Third_Name_loc_lang_Prompt, Family_Name_loc_lang_Prompt,param.alt_id1_accept_alphanumeric_yn, param.Alt_Id1_type,alt_id1.long_desc alt_id1_desc, param.Alt_Id2_type,alt_id2.long_desc alt_id2_desc, param.Alt_Id3_type,alt_id3.long_desc alt_id3_desc,param.Alt_Id4_type,(alt_id4.long_desc) alt_id4_desc, param.alt_id1_length, param.alt_id2_length, param.alt_id3_length, param.alt_id4_length, param.addl_field1_prompt, param.addl_field1_length, param.addl_field2_prompt, param.addl_field2_length, addl_field3_prompt, addl_field3_length, param.addl_field4_prompt, param.addl_field4_length, param.addl_field5_prompt, param.addl_field5_length,param.accept_national_id_no_yn,param.nat_id_accept_alphanumeric_yn,param.ext_system_interface_yn,param.accept_oth_alt_id_yn,NAMES_IN_OTH_LANG_YN from MP_PARAM_LANG_VW param,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id1,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id2,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id3,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id4 where param.module_id='MP' and param.language_id ='"+locale+"' and  param.language_id=alt_id1.language_id and param.language_id=alt_id2.language_id(+) and param.language_id=alt_id3.language_id(+) and param.language_id=alt_id4.language_id(+) and param.alt_id1_type=alt_id1.alt_id_type and param.alt_id2_type=alt_id2.alt_id_type(+) and param.alt_id3_type=alt_id3.alt_id_type(+) and param.alt_id4_type=alt_id4.alt_id_type(+)";

								  /*String sql1="SELECT NVL(param.nat_id_prompt, 'National ID No') nat_id_prompt,   param.nat_data_source_id, param.patient_id_length, param.nat_id_length,       param.family_no_link_yn, param.family_no_prompt,      param.first_name_accept_yn, param.first_name_order,       param.first_name_prompt, param.second_name_accept_yn,       param.second_name_order, param.second_name_prompt,       param.third_name_accept_yn, param.third_name_order,       param.third_name_prompt, param.family_name_accept_yn,       param.family_name_order, param.family_name_prompt,       first_name_loc_lang_prompt, second_name_loc_lang_prompt,       third_name_loc_lang_prompt, family_name_loc_lang_prompt,       param.alt_id1_accept_alphanumeric_yn, (CASE WHEN param.alt_id1_type IS NOT NULL	THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id1_type AND language_id = '"+locale+"')END) alt_id1_desc, (CASE WHEN param.alt_id2_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id2_type             AND language_id = '"+locale+"') END) alt_id2_desc, (CASE WHEN param.alt_id3_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw            WHERE alt_id_type = param.alt_id3_type AND language_id = '"+locale+"') END) alt_id3_desc, (CASE WHEN param.alt_id4_type IS NOT NULL THEN (SELECT long_desc  FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id4_type        AND language_id = '"+locale+"') END) alt_id4_desc, param.alt_id1_length, param.alt_id2_length, param.alt_id3_length, param.alt_id4_length, param.addl_field1_prompt, param.addl_field1_length, param.addl_field2_prompt,   param.addl_field2_length, addl_field3_prompt, addl_field3_length,     param.addl_field4_prompt, param.addl_field4_length,       param.addl_field5_prompt, param.addl_field5_length,       param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,       param.ext_system_interface_yn, param.accept_oth_alt_id_yn,       names_in_oth_lang_yn FROM mp_param_lang_vw param WHERE param.module_id = 'MP' AND param.language_id = '"+locale+"' ";*/

                                 
								  String sql1="SELECT alt_id1_pat_sch_exact_yn,alt_id2_pat_sch_exact_yn,alt_id3_pat_sch_exact_yn,alt_id4_pat_sch_exact_yn,NVL(param.nat_id_prompt, 'National ID No') nat_id_prompt,   param.nat_data_source_id, param.patient_id_length, param.nat_id_length,       param.family_no_link_yn, param.family_no_prompt,      param.first_name_accept_yn, param.first_name_order,       param.first_name_prompt, param.second_name_accept_yn,       param.second_name_order, param.second_name_prompt,       param.third_name_accept_yn, param.third_name_order,       param.third_name_prompt, param.family_name_accept_yn,       param.family_name_order, param.family_name_prompt,       first_name_loc_lang_prompt, second_name_loc_lang_prompt,       third_name_loc_lang_prompt, family_name_loc_lang_prompt,       param.alt_id1_accept_alphanumeric_yn, (CASE WHEN param.alt_id1_type IS NOT NULL	THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id1_type AND language_id = '"+locale+"')END) alt_id1_desc, (CASE WHEN param.alt_id2_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id2_type             AND language_id = '"+locale+"') END) alt_id2_desc, (CASE WHEN param.alt_id3_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type_lang_vw            WHERE alt_id_type = param.alt_id3_type AND language_id = '"+locale+"') END) alt_id3_desc, (CASE WHEN param.alt_id4_type IS NOT NULL THEN (SELECT long_desc  FROM mp_alternate_id_type_lang_vw WHERE alt_id_type = param.alt_id4_type        AND language_id = '"+locale+"') END) alt_id4_desc, param.alt_id1_length, param.alt_id2_length, param.alt_id3_length, param.alt_id4_length, param.addl_field1_prompt, param.addl_field1_length, param.addl_field2_prompt,   param.addl_field2_length, addl_field3_prompt, addl_field3_length,     param.addl_field4_prompt, param.addl_field4_length,       param.addl_field5_prompt, param.addl_field5_length,       param.accept_national_id_no_yn, param.nat_id_accept_alphanumeric_yn,       param.ext_system_interface_yn, param.accept_oth_alt_id_yn,       names_in_oth_lang_yn FROM mp_param_lang_vw param WHERE param.module_id = 'MP' AND param.language_id = '"+locale+"' ";
								  //Modified by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
								  pstmt = con.prepareStatement(sql1);

									
                                    rs = pstmt.executeQuery();
                                    if (rs !=null) {
                                        if (rs.next())
                                        {
                                            nat_id_prompt = rs.getString("Nat_Id_Prompt");
                                            if (nat_id_prompt==null) nat_id_prompt = "";
											ext_system_interface_yn = rs.getString("ext_system_interface_yn");
											nat_data_source_id = checkForNull(rs.getString("nat_data_source_id"),"");
                                            patient_id_length = rs.getInt("Patient_Id_Length");
                                            nat_id_length = rs.getInt("Nat_Id_Length");
                                            Family_No_Link_Yn =rs.getString("Family_No_Link_Yn")== null ?  "N" : rs.getString("Family_No_Link_Yn");
                                            Family_No_Prompt =rs.getString("Family_No_Prompt")== null ? "Head of the Family" : rs.getString("Family_No_Prompt");
                                            First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
											names_in_oth_lang_yn=rs.getString("names_in_oth_lang_yn");
                                            First_Name_Order = rs.getInt("First_Name_Order");
                                            First_Name_Prompt = rs.getString("First_Name_Prompt")==null ? "First Name" : rs.getString("First_Name_Prompt");
                                            Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
											
                                            Second_Name_Order = rs.getInt("Second_Name_Order");
                                            Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null ? "Second Name" : rs.getString("Second_Name_Prompt");
                                            Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
                                            Third_Name_Order = rs.getInt("Third_Name_Order");
                                            Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null ? "Third Name" : rs.getString("Third_Name_Prompt");
											
											 First_Name_loc_lang_Prompt=checkForNull(rs.getString("First_Name_loc_lang_Prompt"));
											Second_Name_loc_lang_Prompt=checkForNull(rs.getString("Second_Name_loc_lang_Prompt"));
											Third_Name_loc_lang_Prompt=checkForNull(rs.getString("Third_Name_loc_lang_Prompt"));
											Family_Name_loc_lang_Prompt=checkForNull(rs.getString("Family_Name_loc_lang_Prompt"));

                                            Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
                                            Family_Name_Order = rs.getInt("Family_Name_Order");
											accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "N" : rs.getString("accept_oth_alt_id_yn");
											
											alt_id1_accept_alphanumeric_yn = rs.getString("alt_id1_accept_alphanumeric_yn")==null ? "N" : rs.getString("alt_id1_accept_alphanumeric_yn");
											
											 
											if 	(pat_name_as_multipart_yn.equals("N"))
										{
												Family_Name_Order = 4;
												//family_name_length = "40";
											}
											else
											{
												//family_name_length = "15";
											
										}											
											Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null ? "Family Name" : rs.getString("Family_Name_Prompt");
                                            Res_Area_Prompt = "Area";
                                            Alt_Id1 = rs.getString("alt_id1_desc")==null?"Alt ID No":rs.getString("alt_id1_desc");
                                            Alt_Id2 = rs.getString("alt_id2_desc")==null?"":rs.getString("alt_id2_desc");
                                            Alt_Id3 = rs.getString("alt_id3_desc")==null?"":rs.getString("alt_id3_desc");
                                            Alt_Id4 = rs.getString("alt_id4_desc")==null?"":rs.getString("alt_id4_desc");
											
                                            alt_id1_length = rs.getInt("alt_id1_length");
                                            alt_id2_length = rs.getInt("alt_id2_length");
                                            alt_id3_length = rs.getInt("alt_id3_length");
                                            alt_id4_length = rs.getInt("alt_id4_length");
											
                                            addl_field1_prompt = rs.getString("addl_field1_prompt")==null?"":rs.getString("addl_field1_prompt");
                                            addl_field1_length = rs.getInt("addl_field1_length");
                                            addl_field2_prompt = rs.getString("addl_field2_prompt")==null?"":rs.getString("addl_field2_prompt");
                                            addl_field2_length = rs.getInt("addl_field2_length");   
                                            addl_field3_prompt = rs.getString("addl_field3_prompt")==null?"":rs.getString("addl_field3_prompt");
                                            addl_field3_length = rs.getInt("addl_field3_length");  
											
                                            addl_field4_prompt = rs.getString("addl_field4_prompt")==null?"":rs.getString("addl_field4_prompt");
                                            addl_field4_length = rs.getInt("addl_field4_length");   
                                            addl_field5_prompt = rs.getString("addl_field5_prompt")==null?"":rs.getString("addl_field5_prompt");
                                            addl_field5_length = rs.getInt("addl_field5_length");
											
											accept_national_id_no_yn = rs.getString("accept_national_id_no_yn");
											if (accept_national_id_no_yn==null) accept_national_id_no_yn = "N";

											nat_id_accept_alphanumeric_yn = rs.getString("nat_id_accept_alphanumeric_yn");
											if (nat_id_accept_alphanumeric_yn==null) nat_id_accept_alphanumeric_yn = "N";
											if (separate_file_no_yn.equals("N")) mrn_length= rs.getString("Patient_Id_Length");

											//Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
											alt_id1_pat_sch_exact_yn=rs.getString("alt_id1_pat_sch_exact_yn")==null?"N":rs.getString("alt_id1_pat_sch_exact_yn");
											alt_id2_pat_sch_exact_yn=rs.getString("alt_id2_pat_sch_exact_yn")==null?"N":rs.getString("alt_id2_pat_sch_exact_yn");
											alt_id3_pat_sch_exact_yn=rs.getString("alt_id3_pat_sch_exact_yn")==null?"N":rs.getString("alt_id3_pat_sch_exact_yn");
											alt_id4_pat_sch_exact_yn=rs.getString("alt_id4_pat_sch_exact_yn")==null?"N":rs.getString("alt_id4_pat_sch_exact_yn");
											
											
                                        }
                                    }
                                }catch(Exception e) { out.println(e.toString());}
                                finally
                                {
                                    if (pstmt != null) pstmt.close();
                                    if (rs != null) rs.close();
                                }

                                  pstmt = con.prepareStatement("select contact_mode, short_desc from mp_contact_mode_lang_vw where contact_mode in ('PRN', 'ORN') and language_id = ?");
								  try{
									pstmt.setString(1,locale);
									rs = pstmt.executeQuery();
									String cnt_mode="";
									while(rs!=null && rs.next()){
										cnt_mode=rs.getString("contact_mode");
										if(cnt_mode.equals("PRN"))
											prn_label=rs.getString("short_desc");
										if(cnt_mode.equals("ORN"))
											orn_label=rs.getString("short_desc");
									}
								  } catch(Exception ex) {
									  ex.printStackTrace();
								  } finally {
									  if (pstmt != null) pstmt.close();
									  if (rs != null) rs.close();
								  }

                                
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(family_org_id_accept_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(func_idpassed));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 

									if (accept_national_id_no_yn.equals("Y"))
									{ 
									
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block22Bytes, _wl_block22);
if(function_name.equals("07")){ 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sessionID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_ws_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
} // MOHE-CRF-0164.1
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{
            _bw.write(_wl_block27Bytes, _wl_block27);
}	
            _bw.write(_wl_block28Bytes, _wl_block28);
if(!Alt_Id1.equals("")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Alt_Id1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(alt_id1_length));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!isInsuranceCardReader){//Added by kamatchi S for MOHE-CRF-0016.1 ON 26-AUG-2020
									if(!Alt_Id2.equals("")){
							
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Alt_Id2));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_id2_length));
            _bw.write(_wl_block35Bytes, _wl_block35);
}}else{
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(insurance_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(insurance_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!Alt_Id3.equals("")){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Alt_Id3));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(alt_id3_length));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!Alt_Id4.equals("")){
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(Alt_Id4));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_id4_length));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
if(names_in_oth_lang_yn.equals("Y")){
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
if(pat_name_as_multipart_yn.equals("Y")){  
								 	
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   width='20%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='First_Name1' id='First_Name1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td  width='20%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields' ><input type='text' name='Second_Name1' id='Second_Name1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   width='20%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td    width='30%' class='fields'><input type='text' name='Third_Name1' id='Third_Name1' size='25' maxlength='15' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										firstRowElement="Y";
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									
                                        out.println("<td   width='20%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
										firstRowElement="Y";

						/*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-Start*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){
 
											fam_name_ind ="Y";
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								} /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-End*/

                                    }
                                   

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='First_Name1' id='First_Name1' >");
                                }
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Second_Name1' id='Second_Name1' >");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Third_Name1' id='Third_Name1' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='Family_Name1' id='Family_Name1' >");
                                    }
									 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td  width='20%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td  width='30%' class='fields' ><input type='text' name='First_Name1' id='First_Name1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td  width='20%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td  width='30%' class='fields' ><input type='text' name='Second_Name1' id='Second_Name1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td  width='20%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Third_Name1' id='Third_Name1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                                        out.println("<td   width='20%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\">");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-Start*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								} /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-End*/

                                    }
                                   

									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='20%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='First_Name1' id='First_Name1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%'  class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Second_Name1' id='Second_Name1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'   style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Third_Name1' id='Third_Name1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='20%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}

										 /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-Start*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								} /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-End*/

                                    }
                         
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%' class='label'>" + First_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields' ><input type='text' name='First_Name1' id='First_Name1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%' class='label'>" + Second_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Second_Name1' id='Second_Name1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td></tr><tr>");
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td  width='20%' class='label'>" + Third_Name_Prompt + "</td>");
                                        out.println("<td   width='30%' class='fields'><input type='text' name='Third_Name1' id='Third_Name1' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\"></td>");
                                    }
                                   else
									  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
									   if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   width='20%' class='label'>" + Family_Name_Prompt + "</td>");
                                        out.println("<td  width='30%' class='fields'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);'  style=\"text-align:left\">");
										
								    /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-Start*/
						  if (First_Name_Accept_Yn.equals("N") && Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") && Family_Name_Accept_Yn.equals("Y") ){

											fam_name_ind ="Y";
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
								} /*Added by Rameswar on  21-04-2016 for HSA-CRF-0299-End*/


								   }
								      else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }

                                  
								}
								
								if (pat_name_as_multipart_yn.equals("N"))	
								{			out.println("<td nowrap  width='20%' class='label'>" + Family_Name_Prompt + "</td>");
											out.println("<td nowrap  class='fields' width='30%'><input type='text' name='Family_Name1' id='Family_Name1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);ChangeInitCase(this);EnableSearchBy(this)'   style=\"text-align:left\">");
//											String selects1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By' id='Search_By' ><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
									}
										else
										out.println("</td>");
                                    
                            /*        else {
                                        out.println("<td  width='13%' class='label'>&nbsp;</td>");
                                        out.println("<td  width='11%' class='label'>&nbsp;&nbsp;</td>");
                                    }*/ 
            _bw.write(_wl_block52Bytes, _wl_block52);
	
					if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) 
					  {
						 if (pat_name_as_multipart_yn.equals("N"))	
						 { 
            _bw.write(_wl_block53Bytes, _wl_block53);
}
					 }
                  
            _bw.write(_wl_block54Bytes, _wl_block54);

					      if(names_in_oth_lang_yn.equals("Y")){
							firstRowElement="";
							firstRowCompleted="";

							if(!language_direction.equals("R"))
							{
					      if(pat_name_as_multipart_yn.equals("Y")){  
								
            _bw.write(_wl_block55Bytes, _wl_block55);
 
										
                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields' ><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 firstRowElement="Y";

                                    }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==1 )
									{
										 out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
									}
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";


                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   class='label' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";


                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
									
                                        out.println("<td   class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										firstRowElement="Y";
                                    }
                                   

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
                                }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==0)
								{
									 out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
								}
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='second_name_loc_lang1' id='second_name_loc_lang1'>");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='third_name_loc_lang1' id='third_name_loc_lang1' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='family_name_loc_lang1' id='family_name_loc_lang1' >");
                                    }
									 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										 out.println("></td>");
										 if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
                                        out.println("<td   class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}
                                    }
                                   

									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                     
										out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}
                                    }
                                    
									

									
                                
            _bw.write(_wl_block56Bytes, _wl_block56);
if(pat_name_as_multipart_yn.equals("Y")){  }
            _bw.write(_wl_block57Bytes, _wl_block57);

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
									if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td></tr><tr>");
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td   class='label' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"'	onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									   out.println("></td>");
                                    }
                                   else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4) {
									   if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}
                                        out.println("<td    class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\">");
                                        out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
										
								   }
						       else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
						  }
										if (pat_name_as_multipart_yn.equals("N"))	
										{
											 out.println("<td  nowrap  class='label' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
											out.println("<td nowrap  class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);EnableSearchBy(this);'   style=\"text-align:left\">");
//											String selects1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By_Lang' id='Search_By_Lang'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
							
										}

										out.println("</td>");

						}
						else
						{
							/**** Added for Arabic ****/
							firstRowElement="";
							firstRowCompleted="";
					      if(pat_name_as_multipart_yn.equals("Y")){  
								
            _bw.write(_wl_block58Bytes, _wl_block58);

                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
									//	firstRowElement="Y";
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
									//	firstRowElement="Y";
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"'	onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"'	onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									   out.println("></td>");
									  // firstRowElement="Y";
                                    }
                                   else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2) {
                                        out.println("<td    class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\">");
                                        out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
								//	 firstRowElement="Y";
										
								   }
						       else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }


									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                        
										out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}*/
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                       // out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										} */
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										}*/
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
                                        out.println("<td   class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                     
										out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									    out.println("></td>");
										/*
										if(firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else{
											firstRowElement="Y";
										} */

                                    } else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
									
            _bw.write(_wl_block59Bytes, _wl_block59);

									
									if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
										/*(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");
									 /*
									 if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										} */
                                    }
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
										//if(firstRowCompleted.equals("Y")){
											//out.println("</tr><tr>");
										//}
                                        out.println("<td   class='arabic' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");
                                       
										out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)' ");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										 out.println("></td>");
										 /*
										 if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

                                        out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");
                                      
										out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

										if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
										/*
										if(!firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="Y";
										}else if(firstRowCompleted.equals("Y") && firstRowElement.equals("Y")){
											firstRowCompleted="N";
										}*/
                                    } else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }


                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + First_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields' ><input type='text' name='first_name_loc_lang' id='first_name_loc_lang' size='"+first_name_length+"' maxlength='"+first_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='first_name_loc_lang1' id='first_name_loc_lang1' size='25' maxlength='"+first_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
									 out.println("></td>");

                                    }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==3 )
									{
										 out.println("<input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' >");
									}
                                    else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + Second_Name_loc_lang_Prompt + "</td>");
                                     //   out.println("<td   class='fields'><input type='text' name='second_name_loc_lang' id='second_name_loc_lang' size='"+second_name_length+"' maxlength='"+second_name_length+"' onBlur='makeValidQueryCriteria(this)'   style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='30%'><input type='text' name='second_name_loc_lang1' id='second_name_loc_lang1' size='25' maxlength='"+second_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");


                                    }
                                    else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
                                        out.println("<td   class='arabic' width='20%'>" + Third_Name_loc_lang_Prompt + "</td>");
                                    //    out.println("<td   class='fields'><input type='text' name='third_name_loc_lang' id='third_name_loc_lang' size='"+third_name_length+"' maxlength='"+third_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									 out.println("<td   class='fields' width='30%'><input type='text' name='third_name_loc_lang1' id='third_name_loc_lang1' size='25' maxlength='"+third_name_length+"' onBlur='makeValidString(this)'");

									 if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");


                                    }
                                    else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
										/*if(firstRowCompleted.equals("Y")){
											out.println("</tr><tr>");
										}*/
									
                                        out.println("<td   class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
                                      //  out.println("<td   class='fields' ><input type='text' name='family_name_loc_lang' id='family_name_loc_lang' size='"+family_name_length+"' maxlength='"+family_name_length+"' onBlur='makeValidQueryCriteria(this)'  style=\"text-align:left\"></td>");

									  out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this)'");

									  if(language_direction.equals("R"))
										{
										out.println( "dir='RTL' ");
										}else
										{
										out.println("dir='LTR'");
										}
												 
										out.println("></td>");
                                    }  else {
                                        out.println("<td   class='label'>&nbsp;</td>");
                                        out.println("<td   class='label'>&nbsp;</td>");
                                    }
                                   
            _bw.write(_wl_block60Bytes, _wl_block60);


                                    if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
                                }else if( First_Name_Accept_Yn.equals("N") && First_Name_Order ==0)
								{
									 out.println("<input type='hidden' name='first_name_loc_lang1' id='first_name_loc_lang1' >");
								}
                                else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='second_name_loc_lang1' id='second_name_loc_lang1'>");
                                }
                                else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='third_name_loc_lang1' id='third_name_loc_lang1' >");
                                }
                                else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
                                    out.println("<input type='hidden' name='family_name_loc_lang1' id='family_name_loc_lang1' >");
                                    }
					
                              
						  }
										if (pat_name_as_multipart_yn.equals("N"))	
										{
											 out.println("<td    class='arabic' width='20%'>" + Family_Name_loc_lang_Prompt + "</td>");
											out.println("<td   class='fields' width='30%'><input type='text' name='family_name_loc_lang1' id='family_name_loc_lang1' size='25' maxlength='"+family_name_length+"' onBlur='makeValidString(this);EnableSearchBy(this);'   dir='RTL' >");
//											String selects1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
											String startwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startsWith.label","common_labels");
											String contains = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contains.label","common_labels");
											String endwith = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.endsWith.label","common_labels");
											out.println("&nbsp;&nbsp;<select name='Search_By_Lang' id='Search_By_Lang'><option value='S'>"+startwith+"</option><option value='C' "+select_val+" >"+contains+"</option><option value='E'>"+endwith+"</option></select></td>");
											//Added by Mujafar  against ML-MMOH-CRF-1127
							
										}

										out.println("</td>");

										/**** End of Arabic changes ****/

						}
						} 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(prn_label));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(orn_label));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(isAlternateAddressAppl));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(isAddressLengthIncAppl));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(isInsuranceCardReader));
            _bw.write(_wl_block69Bytes, _wl_block69);
      
            }catch(Exception e) {
                out.println(e.toString());
            }
            finally {
                if(pstmt != null) pstmt.close();
				if(pstmt1 != null) pstmt1.close();
                if(rs !=null) rs.close();
				if(rs1 !=null) rs1.close();
                if(con!=null) ConnectionManager.returnConnection(con,request);                
            }            
        
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(suspend_inactive_pat_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(window_styl));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(close_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(register_button_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(Soundex));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(alt_id1_accept_alphanumeric_yn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(language_direction));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(cr_jsp_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(cr_window_styl));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(cr_close_yn));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(cr_win_top));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(cr_win_width));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(cr_win_height));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(cr_act_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(cr_srr));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(cr_register_button_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cr_func_act));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(cr_defaultgender));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(cr_enablegenderyn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(cr_function_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(cr_func_idpassed));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(defaultgender));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(alt_id1_pat_sch_exact_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(alt_id2_pat_sch_exact_yn));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(alt_id3_pat_sch_exact_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(alt_id4_pat_sch_exact_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(alterIdSearch));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(isAlternateId));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(alternate_no));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(fam_name_ind));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(dft_national_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(alterIdSearch));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(isAlternateId));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(alterIdSearch));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(isAlternateId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(alternate_no));
            _bw.write(_wl_block108Bytes, _wl_block108);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Insurance.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientNameLocal.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
