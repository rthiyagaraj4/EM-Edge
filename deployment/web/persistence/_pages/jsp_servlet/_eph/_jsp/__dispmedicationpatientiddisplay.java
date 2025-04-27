package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationpatientiddisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationPatientIDDisplay.jsp", 1742793814802L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n/*******************************************************************************\n * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.\n *  \n * Warning: This computer program is protected by copyright law and international treaties.\n * Unauthorized reproduction or distribution of this program, or any portion of it, \n * may result in severe civil and criminal penalties, and will be prosecuted to \n * the maximum extent possible under the law.\n ******************************************************************************/\n/* \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?                created\n04/17/2017      KDAH-CRF-0338     Devindra/Mukesh    Inclusion of Bed No in the Fill and Deliver screen in Dispense Medication.\n09/01/2017\t\tIN:065140\t\t\tMukesh M\t\t Internal issue related to GHL-CRF-0453\t\n01/10/2021\t\tTFS-23793         Prabha \t\t\t ML-MMOH-SCF-1904\n11/10/2023\t\t40147\t\t\t  Sushant Tambe\t\t MMS-DM-CRF-0228\n---------------------------------------------------------------------------------------------------------------\n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!-- Modified for ML-MMOH-CRF-0532 [IN061327] -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t/*function blinkImage(){ //Commented for ML-BRU-SCF-1144[IN045159] - start\n\t\t\t\tvar e;\n\t\t\t\tvar count=0;\n\t\t\t\ttry{\n\t\t\t\t\tcount = document.frmDispMedicationPatientIDDisplay.tot_rec.value;\n\t\t\t\t}\n\t\t\t\tcatch(e){}\n\n\t\t\t\tfor(var i=0;i<count;i++){\n\t\t\t\t\ttry{\n\t\t\t\t\t\te = document.getElementById(\"appt_list_\"+i);//eval(\"document.getElementById(\"appt_list_\")\"+i);//\n\t\t\t\t\t\tif(e.style.display==\'inline\'){\n\t\t\t\t\t\t\te.style.visibility = ( e.style.visibility == \'visible\' )? \'hidden\' : \'visible\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tcatch(e){}\n\t\t\t\t}\n\t\t\t}\n\t\t\twindow.onload = function(){\n\t\t\t\twindow.setInterval(\"blinkImage()\",500);\n\t\t\t}*/ //Commented for ML-BRU-SCF-1144[IN045159] - End\n\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t</head>\n\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\" onLoad=\"clickPatient()\"><!--added onload for Bru-HIMS-CRF-416[IN045566] -->\n\t\t<form name=\"frmDispMedicationPatientIDDisplay\" id=\"frmDispMedicationPatientIDDisplay\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tclickPatient();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<!-- Display the Previous Next link -->\n\t\t\t <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"customGroupTable\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<tr >\n\t\t\t\t\t<td id=\"pastOrders\"  width=\"15%\"class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onClick=\"changeButtonColor(this,\'PH_CUSTOM_GROUP\');javascript:showPatientsBasedOnTheCriteria(\'I\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'1\');\" nowrap>\n\t\t\t\t\t\t<a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" name=\"print_report\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp; < &nbsp; ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" &nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td id=\"currentOrders\" width=\"15%\" class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'2\')\" nowrap>\n\t\t\t\t\t\t<a class=\"MENUHIGHERLEVELLINK\" style=\"color:white\" name=\"bal_med_dtl\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp; > &nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td id=\'dummy\' align=\"left\"  width=\"*\" />\n\t\t\t\t</tr> \n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t</table>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<script language=\"javascript\">\n\t\t\t\t\t//alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\")); //commented [IN:037465]\n\t\t\t\t\tparent.parent.parent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+ getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"); //added for [IN:037465]\n\t\t\t\t\t//parent.parent.parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled=false;\n\t\t\t\t\tconst button = document.getElementById(\"btnSearch\");\n\t\t\t\t\tif (button) {\n\t\t\t\t\t\tbutton.disabled = false;\n\t\t\t\t\t\t}\n\t\t\t\t\tenableCriteria();\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<script> setTimeout(\"setAutoRefresh()\",\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');</script>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t\t\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<script language=\"javascript\">\n\t\t\t\t\t\tparent.parent.parent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 align=\"center\" id=\"nav_table\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t        <Script language=\"JavaScript\">\n\t\t\t\t\t\t\tparent.parent.patient_id_pagination.document.getElementById(\"disprec\").style.visibility=\'visible\' ; \n\t\t\t\t\t\t\tvar maxrec = \'\';\n\t\t\t\t\t\t\tvar str = \'\';\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\")\n\t\t\t\t\t\t\tmaxrec = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\t\t\tif(parent.parent.patient_id_pagination.document.getElementById(\"to\"))\n\t\t\t\t\t\t\tstr=parent.parent.patient_id_pagination.document.getElementById(\"to\").value;\n\t\t\t\t\t\t\tif (eval(maxrec) > 50)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.parent.patient_id_pagination.document.forms[0].prev.style.visibility = \'visible\';\n\t\t\t\t\t\t        parent.parent.patient_id_pagination.document.forms[0].next.style.visibility = \'visible\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</Script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t        <Script language=\"JavaScript\">\n\t\t\t\t        var defaultwindow= parent.patient_id_pagination.document.forms[0].defaultwindow.value;\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="                  \n\t\t\t\t            var md = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t            if (md==\"\")\n\t\t\t\t            {\n\t\t\t\t\t\t\t\tvar td = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";            \n\t\t\t\t                var scroll_view = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";   \n\t\t\t\t\t\t\t\tif (scroll_view>0)\n\t\t\t\t                {\n\t\t\t\t\t\t\t\t\tif(defaultwindow!=\"\"){\n\t\t\t\t\t\t\t\t\t\tparent.patient_id_pagination.document.getElementById(\'disprec\').innerHTML= defaultwindow;\n\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\tparent.patient_id_pagination.document.getElementById(\'disprec\').innerHTML = td;\n\t\t\t\t\t\t\t\t\t\tparent.patient_id_pagination.document.getElementById(\'defaultwindow\').value= td;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t                    parent.patient_id_pagination.document.getElementById(\"disprec\").style.visibility=\'visible\' ; \n\t\t\t\t\t\t\t\t}\n\t\t\t\t                if (scroll_view>5) \n\t\t\t\t                {\n\t\t\t\t                \tparent.patient_id_pagination.document.getElementById(\'next\').style.visibility = \'visible\';            \n\t\t\t\t                \tparent.patient_id_pagination.document.getElementById(\'prev\').style.visibility = \'visible\';\n\t\t\t\t                \tparent.patient_id_pagination.document.getElementById(\'prev\').disabled = true;\n\t\t\t\t                \tparent.patient_id_pagination.document.getElementById(\'next\').disabled = false;\t\n\t\t\t\t                \t\n\t\t\t\t                \tparent.patient_id_pagination.document.getElementById(\'first\').style.visibility=\'visible\' ;\n\t\t\t\t                    parent.patient_id_pagination.document.getElementById(\'last\').style.visibility=\'visible\' ;\n\t\t\t\t                    parent.patient_id_pagination.document.getElementById(\'first\').disabled = false;\n\t\t\t\t                \tparent.patient_id_pagination.document.getElementById(\'last\').disabled = false;\t\n\t\t\t\t\t\t\t\t}           \n\t\t\t\t                mode = \"Y\";\n\t\t\t\t            if(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'<=12)parent.patient_id_pagination.defaultSetting(); \n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t</td></tr>\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" id=\"patientiddisplaytable\">\n\t\t\t\t<tr id=\"header\">\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"2%\">&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"15%\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"3%\" nowrap ><img src=\'../../ePH/images/Locked.gif\'></td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"30%\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"20%\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t\t<!-- <td class=\"COLUMNHEADER\" width=\"10%\" nowrap >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td> -->\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"3%\" nowrap ><img src=\'../../ePH/images/Locked.gif\'></td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"35%\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"3%\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"6%\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\t\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\t\t<td class=\"COLUMNHEADER\" width=\"10%\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"25%\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\t\t\n\t\t\t\t\t<td class=\"COLUMNHEADER\" width=\"15%\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\n\t<td class=\"COLUMNHEADER\" width=\"25%\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t<tr colspan=\"8\"></tr>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"center\" id=\"th1\" colspan=\"11\"><b>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</b></td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"center\" id=\"th2\" colspan=\"11\"><b>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t<tr colspan=\"8\"></tr><tr colspan=\"8\"></tr><tr colspan=\"8\"></tr>\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"left\" id=\"th_";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" colspan=\"9\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t<label id=\"th_";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" style=\"display:none\"></label> \n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" style=\"display:\">\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td> \n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" style=\"font-size:9px\">\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t<label style=\'cursor:pointer;color:blue;font-size:9px;font-weight:bold\'  onMouseOver=\'showToolTip(this,\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\",\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\")\' onClick=\'if(CheckAccessRights(\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\")){collapse(\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\");LockStatus(\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\");displayOrdersForPatient(\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\",\"\",\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\");}\'\tid=\"patient_id_label";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\t</label>\n\t\t\t\t\t\t\t\t\t<label  onClick=\'collapse(\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\")\'  id=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">&nbsp;</label>\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n                                    <label  style=\'color:red;font-size:9px;font-weight:bold\' id=\"BinLocation";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">&nbsp;";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" </label>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t\t<label style=\'cursor:pointer;color:blue;font-size:9px;font-weight:bold\' onMouseOver=\'showToolTip(this,\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\")\' id=\"patient_id_label";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t\t<label style=\'cursor:pointer;color:blue;font-size:9px\' id=\"tokenNumbers";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" onclick=\"viewTokenDetails(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\')\">&nbsp;";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</label>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/CallToken.png\" align=\"center\" title=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' id=\'QMS_call_token\' onclick=\'callQMSToken(\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\");\'></img>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t\t\t\t<img  src=\"../../ePH/images/printed_fully.gif\" height=\'20\'  width=\'20\' onmouseover = \"showToolTipPrint(this,\'Fully Printed\')\"></img>\n\n\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t\t\t<img  src=\"../../ePH/images/printed_partial.gif\" height=\'20\'  width=\'20\' onmouseover = \"showToolTipPrint(this,\'Partially Printed\')\"></img>\n\n\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" \n \t\t\t\t\t\t\t\t<img src=\'../../ePH/images/print.gif\' align=\"center\"\n\t\t\t\t\t\t\t\t\ttitle=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' style=\"cursor:pointer;width:20;height:20\" id=\"printPres_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" onClick=\"showPrintPrescription(\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\')\"> \n \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" style=\"font-size:9px\"><label id=\"Logout_gif\" style=\'cursor:pointer;color:blue;font-size:9px;font-weight:bold\'  onMouseOver=\"showToolTipLockStatus(this,\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\')\"onClick=\'UnLockRecord(\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\")\'><b><img src=\'../../eCommon/images/enabled.gif\'></B></td> \n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\')\"><b><img src=\'../../eCommon/images/enabled.gif\'></B></td>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" style=\"font-size:9px\"><b>&nbsp;</B></td>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"lock_status";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" id=\"lock_status";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" style=\"font-size:9px\"><b>";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</b>&nbsp;\n             \t\t\t\t\t<!--  Added for Bru-HIMS-CRF-142 [IN:030195] - start-->\t\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"black\" size=1><b>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</b></font> <input type=\"checkbox\" name=\"str_lcn_chk\" id=\"str_lcn_chk\" onclick=\"storageLocation(this,\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\',\'1\',\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\');\"><!--  added for ML-BRU-SCF-0792 [IN:039236] delivery_bin_yn,15 added for TH-KW-CRF-0020.9-->\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"black\" size=1>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</font> <input type=\"checkbox\" name=\"str_lcn_chk\" id=\"str_lcn_chk\" onclick=\"storageLocation(this,\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\',\'2\',\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\');\"><!--  added for ML-BRU-SCF-0792 [IN:039236]-->\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t</td>\t<!-- Added for Bru-HIMS-CRF-142 [IN:030195] - End -->\t\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" style=\"font-size:9px\" ><labels id=\"number_of_orders";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</label></td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" style=\"font-size:9px\">&nbsp;";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" style=\"font-size:9px\">";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="&nbsp;</td>\n";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" id=\"patient_id";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\'2\' align=\"left\" id=\"all_det_th_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" style=\"font-size:9px;display:none\">";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr id=\"all_det_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" style=\"font-size:9px;display:none\">\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" style=\"font-size:9px;\" width=\'70%\'>\n\n\t\t\t\t\t\t\t\t\t<label id= \"patient_bt";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" style=\'cursor:pointer;color:blue;font-size:9px;font-weight:bold\'  onMouseOver=\'showToolTip(this,\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\")\' onClick=\'collapse(\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\")\'>";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</label><!--id added for Bru-HIMS-CRF-416[IN045566] -->\n\t\t\t\t\t\t\t\t\t<label id=\"number_of_orders";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">&nbsp;(";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =")</label>\n \t\t\t\t\t\t\t\t\t<br><B>";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="&nbsp;</B>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" style=\"font-size:9px;\" width=\'30%\'>\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/print.gif\' align=\"center\"\n\t\t\t\t\t\t\t\t\ttitle=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' style=\"display:none;cursor:pointer;width:20;height:20\" id=\"print_pres_";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\')\"> \n\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/MI_View-ScheduleAppionment.gif\' title=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' style=\"display:none;cursor:pointer;width:20;height:20\" id=\"appt_list_";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" onClick=\"DiplayAppointmentDtls(\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\')\" ><label id=\"next_appt_days";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\"></label>\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/CallToken.png\" align=\"center\" title=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'  id=\'QMS_call_token\' onclick=\'callQMSToken(\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" \n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'Ordering_Facility_id_";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' id=\'Ordering_Facility_id_";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' value =\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'encounter_id";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' id=\'encounter_id";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'><!-- added for RUT-CRF-0083.5 [IN:041511] Start -->\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'episode_id";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' id=\'episode_id";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'patient_class";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' id=\'patient_class";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'> <!-- added for RUT-CRF-0083.5 [IN:041511] -End -->\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'desp_name_code";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' id=\'desp_name_code";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'locn_code";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' id=\'locn_code";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'> <!-- added for BSP-SCF-0060 -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'locn_code";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'> <!-- added for BSP-SCF-0060 -->\n\t\t\t\t\t\t      ";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'bed_num";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' id=\'bed_num";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\' value =\"\">";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="<!-- added for KDAH-CRF-0338 -->\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_name_";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" id=\"patient_name_";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" style=\"display:\">\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t\t\t<label style=\'cursor:pointer;color:blue;font-size:9px;font-weight:bold\'  onMouseOver=\'showToolTip(this,\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\")}\'  id=\"patient_id_label";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</label>\n\t\t\t\t\t\t\t\t<label  onClick=\'collapse(\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\')\"> ";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\n\t\t\t\t\t\t\t\t</td> \n";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="</b>&nbsp; \n\t\t\t\t             \t<!--  Added for Bru-HIMS-CRF-142 [IN:030195] - start-->\t\n";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\');\">\n";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n                               </td>\n\t\t\t\t\t\t\t\t<!-- Added for Bru-HIMS-CRF-142 [IN:030195] - End -->\t\n\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="&nbsp;</b></td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" style=\"font-size:9px\" ><label id=\"number_of_orders";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">&nbsp;<B>";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</B></label></td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="</td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr id=\"all_det_";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" style=\"font-size:9px;\" width=\'70%\'>\n\t\t\t\t\t\t\t\t<label id=\"patient_bt";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" style=\'cursor:pointer;color:blue;font-size:9px\'  onMouseOver=\'showToolTip(this,\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\")\'> ";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</label><!-id added for Bru-HIMS-CRF-416[IN045566]-->\n\t\t\t\t\t\t\t\t<label id=\"number_of_orders";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\" style=\'font-weight:bold\'>&nbsp;(";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 =")</label>\n\t\t\t\t\t\t\t\t<br>";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" style=\"font-size:9px;\" width=\'30%\'>\n\n\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/print.gif\' align=\"center\"\n\t\t\t\t\t\t\t\ttitle=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/MI_View-ScheduleAppionment.gif\' title=\'";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t\t\t\t\t<img src=\"../../ePH/images/CallToken.png\" align=\"center\" title=\'";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 =" \n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'Ordering_Facility_id_";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\' value = \'";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'encounter_id";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\'><!-- added for RUT-CRF-0083.5 [IN:041511] Start -->\n\t\t\t\t\t\t<input type=\'hidden\' name=\'episode_id";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'patient_class";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\'> <!-- added for RUT-CRF-0083.5 [IN:041511] -End -->\n\t\t\t\t\t\t<input type=\'hidden\' name=\'desp_name_code";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\'>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'bed_num";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\' value =\"\"> <!-- added for KDAH-CRF-0338 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t\t\t\t\t\t<tr colspan=\"8\"></tr>\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"left\" id=\"th_";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" colspan=\"12\"><b>";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="</b></td> <!-- colspan=\"10\" Changed to colspan=\"11\" for KDAH-CRF-0338 -->\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t\t\t\t\t<label id=\"th_";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t\t\t\t\t<tr colspan=\"8\"></tr><tr colspan=\"8\"></tr><tr colspan=\"9\"></tr>\n\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"left\" id=\"th_";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\" colspan=\"10\">";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="</td <!-- colspan changed from 9 to 10 for KDAH-CRF-0338 -->\n";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =" \n\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\" style=\"font-size:9px\">\n\t\t\t\t\t\t\t\t<label style=\'cursor:pointer;color:blue;font-size:9px;font-weight:bold\'  onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\')\" onClick=\'if(CheckAccessRights(\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t<label  onClick=\'collapse(\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">&nbsp;</label>  \n\n";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\t\t\t\t\t\t\t\t</td>\n\n";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\')\"><b><img src=\'../../eCommon/images/enabled.gif\'></B></td>";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"lock_status";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</B>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="</b>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" style=\"font-size:9px\"><label id=\"number_of_orders";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="</td>\t\t\t\t\t\n";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n                             ";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n                                <td class=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="</td>  <!-- Added for KAUH-CRF-0338  -->\n\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n\t\t\t\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</td>\t\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\'2\' class=\"COLUMNHEADER\" align=\"left\" id=\"all_det_th_";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" style=\"font-size:9px;display:none\" width=\'70%\'>\n";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" style=\"font-size:9px;\">\n\t\t\t\t\t\t\t\t\t<label id= \"patient_bt";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" style=\'cursor:pointer;color:blue;font-size:9px;font-weight:bold\'  onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\')\" onClick=\'collapse(\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\")\' ><!--id added for Bru-HIMS-CRF-416[IN045566] -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="</label>\n\n\t\t\t\t\t\t\t\t\t<label id=\"number_of_orders";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 =")</label>\n\t\t\t\t\t\t\t\t\t<br><b>";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="</b>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" style=\"font-size:9px;\" width=\'30%\'>\n";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\')\" >\n\t\t\t\t\t\t\t\t\t\t<label id=\"next_appt_days";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'Ordering_Facility_id_";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'encounter_id";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'><!-- added for RUT-CRF-0083.5 [IN:041511] Start -->\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'episode_id";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'patient_class";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\'> <!-- added for RUT-CRF-0083.5 [IN:041511] -End -->\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\'desp_name_code";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\'>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\'> <!-- added for KDAH-CRF-0338 -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\'> <!-- index Will be 20 for location code if All option is selected in Dispence loc -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'> <!-- added for BSP-SCF-0060 -->\n\t";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'> <!-- added for MMS-ME-SCF-0001 -->\n\t";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\n\t\t\t\t\t\t\t\t\t<tr colspan=\"8\"></tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"left\" id=\"th_";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="</b></td> <!-- colspan=\"10\" Changed to colspan=\"11\" for KDAH-CRF-0338 -->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\n\t\t\t\t\t\t\t\t\t<label id=\"th_";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" style=\"display:none\"></label> \n\t";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\n\t\t\t\t\t\t\t\t<tr colspan=\"8\"></tr><tr colspan=\"8\"></tr><tr colspan=\"9\"></tr>\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"left\" id=\"th_";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="</td <!-- colspan changed from 9 to 10 for KDAH-CRF-0338 -->\n\t";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\t\t\t\t\t\t\t\t\t<tr colspan=\"8\"></tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"left\" id=\"th1\" colspan=\"12\"><center><b>";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="</b></center></td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n\t\t\t\t\t\t\t\t<tr colspan=\"8\"></tr>\n\t\t\t\t\t\t\t\t\t<td class=\"COLUMNHEADER\" align=\"left\" id=\"th1\" colspan=\"12\"><center><b>";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="</b></center></td>\n\t\t\t\t\t\t\t\t</tr>";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 =" \n\t\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\" style=\"font-size:9px\">\n\t\t\t\t\t\t\t\t\t<label style=\'cursor:pointer;color:blue;font-size:9px;font-weight:bold\'  onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\n\t\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t\t<label  onClick=\'collapse(\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\">&nbsp;</label>  \n\n\t";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<img  src=\"../../ePH/images/printed_fully.gif\" height=\'20\'  width=\'20\' onmouseover = \"showToolTipPrint(this,\'Fully Printed\')\"></img>\n\n\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<img  src=\"../../ePH/images/printed_partial.gif\" height=\'20\'  width=\'20\' onmouseover = \"showToolTipPrint(this,\'Partially Printed\')\"></img>\n\n\n\t";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\t\t\t\t\t\t\t\t</td>\n\n\t";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\")\'><b><img src=\'../../eCommon/images/enabled.gif\'></B></td> \n\t";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\" style=\"font-size:9px\"><b>&nbsp;</B></td>\n\t";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"lock_status";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\">\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="</B>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="</b>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="</label></td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="</td>\n\t";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="</td>\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="</td>\t\n\t";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="</td>\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\n\t                             ";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\n\t                                <td class=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="</td>  <!-- Added for KAUH-CRF-0338  -->\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\t\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\">\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\'2\' class=\"COLUMNHEADER\" align=\"left\" id=\"all_det_th_";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr id=\"all_det_";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\" style=\"font-size:9px;display:none\" width=\'70%\'>\n\t";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\t\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\" style=\"font-size:9px;\">\n\t\t\t\t\t\t\t\t\t\t<label id= \"patient_bt";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\")\' ><!--id added for Bru-HIMS-CRF-416[IN045566] -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="</label>\n\n\t\t\t\t\t\t\t\t\t\t<label id=\"number_of_orders";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 =")</label>\n\t\t\t\t\t\t\t\t\t\t<br><b>";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="</b>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\" style=\"font-size:9px;\" width=\'30%\'>\n\t";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../ePH/images/MI_View-ScheduleAppionment.gif\' title=\'";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\')\" >\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"next_appt_days";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\"></label>\n\t";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'Ordering_Facility_id_";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\'> <!-- added for RUT-CRF-0083.5 [IN:041511] -End -->\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'desp_name_code";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\'>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\'> <!-- index Will be 20 for location code if All option is selected in Dispense loc -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\" value=\"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\">\n\t\t\t<input type=\"hidden\" name=\"sel_rec\" id=\"sel_rec\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"disp_locn_catg\" id=\"disp_locn_catg\" value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\">\n\t\t\t<input type=\"hidden\" name=\"print_yn\" id=\"print_yn\" value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n\t\t\t<input type=\"hidden\" name=\"from\" id=\"from\" id=\"from\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"to\" id=\"to\" id=\"to\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"orderType\" id=\"orderType\" value=\"";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\">\n\t\t\t<input type=\"hidden\" name=\"criteria_patient_id\" id=\"criteria_patient_id\" value=\"";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\">\n\t\t\t<input type=\"hidden\" name=\"headerCount\" id=\"headerCount\" value=\"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\">\n\t\t\t<input type=\"hidden\" name=\"tab_based_group_sort_disp\" id=\"tab_based_group_sort_disp\" value=\"";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\">\n\t\t\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\">\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\">\n\t\t\t<input type=\"hidden\" name=\"ptindex\" id=\"ptindex\" value=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\"><!-- added for Bru-HIMS-CRF-416[IN045566] -->\n\t\t\t<input type=\"hidden\" name=\"relflag\" id=\"relflag\" value=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\"><!-- added for Bru-HIMS-CRF-416[IN045566] -->\n\t\t\t<input type=\"hidden\" name=\"refresh_pat_details\" id=\"refresh_pat_details\" value=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\"><!-- Added for TH-KW-CRF-0011 -->\n\t\t\t\n\t\t\t<!-- Added for MMS-DM-CRF-0228 start --> \n\t\t\t<input type=\"hidden\" name=\"ph_print_prescription\" id=\"ph_print_prescription\" id=\"ph_print_prescription\" value=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" id=\"mode\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"maxdisplay\" id=\"maxdisplay\" id=\"maxdisplay\" value=\"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\">\n\t\t\t<input type=\"hidden\" name=\"maxdisplay1\" id=\"maxdisplay1\" id=\"maxdisplay1\" value=\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\">\n\t\t\t<input type=\"hidden\" name=\"searchthreshold\" id=\"searchthreshold\" id=\"searchthreshold\" value=\"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\">\n\t\t\t<input type=\"hidden\" name=\"Hit_Limit\" id=\"Hit_Limit\" value=\"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\">\n\t\t\t<input type=\"hidden\" name=\"searchBasedOn\" id=\"searchBasedOn\" id=\"searchBasedOn\" value=\"\">\n\t\t\t<!-- Added for MMS-DM-CRF-0228 end --> \n\t\t\t\n\t\t</form>\n\t</body>\n</html>\n<script language=\"javascript\">\n";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t\tdocument.getElementById(\"patient_id_label0\").click();\n\t\tdocument.getElementById(\"patientiddisplaytable\").rows(1).cells(0).style.backgroundColor\t= \"#fde6d0\";\n";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\n\t\t//document.getElementById(\"patient_id_label0\").click();\n\t\t//document.getElementById(\"patientiddisplaytable\").rows(1).cells(0).style.backgroundColor\t= \"#fde6d0\";\n";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\n\t\tloadPatientDRugDtl(\'";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\');\n";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\n\tfunction showToolTip(obj,sex,age,nationality,national_id_no){\n\t\tif(sex==\"M\")\n\t\t\tsex= \"         \"+getLabel(\"Common.Sex.label\",\"Common\") +\" : \" + getLabel(\"Common.male.label\",\"Common\");\n\t\telse if(sex==\"F\")\n\t\t\tsex=\"         \"+getLabel(\"Common.Sex.label\",\"Common\") +\" : \" + getLabel(\"Common.female.label\",\"Common\");\n\t\telse \n\t\t\tsex=\"         \"+ getLabel(\"Common.Sex.label\",\"Common\") +\" : \" + getLabel(\"Common.Both.label\",\"Common\");\n\t\t//age =\"           Age : \"+age;\n\t\tage =\"         \"+getLabel(\"Common.age.label\",\"Common\")+\" : \"+age;\n\t\tif(nationality!=\"null\")\n\t\t\tnationality = \"\\n \"+getLabel(\"Common.nationality.label\",\"Common\")+\" : \"+nationality;\n\t\telse\n\t\t\tnationality = \"\";\n\t\t\n\t\tobj.title=sex+\"\\n\"+age+nationality;\n\t\tif(national_id_no!=\"null\")\n\t\t\tnational_id_no = \"\\nNational ID No : \"+national_id_no;\n\t\telse\n\t\t\tnational_id_no = \"\";\n\t}\n\ttryLocatingPatient();\n\t//parent.parent.parent.document.f_query_criteria_buttons.frmDispMedicationQueryCriteriaButtons.btnSearch.disabled=false;\n\tconst button = document.getElementById(\"btnSearch\");\n\tif (button) {\n\t\tbutton.disabled = false;\n\t\t}\n";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\n\t\t\tdocument.getElementById(\"patient_id_label0\").click();\n";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\t\n\t</script>\n";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);
 Connection con				= null;
	try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String login_user	=	(String)session.getValue("login_user");
		//String facility_id		=	(String)session.getValue("facility_id");//Commented for Checkstyle
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

			
			String sUrgentTitle = SpringCacheBean.getLabel(pageContext,"ePH.UrgentOrderExists.label","ph_labels.resources.Labels");
			sUrgentTitle		= sUrgentTitle ==null?"":sUrgentTitle;
			int ptindex = 0;//added for Bru-HIMS-CRF-416[IN045566]
			String bean_id			= "DispMedicationBean" ;
			String bean_name		= "ePH.DispMedicationBean";	
			DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);
			String	bean_id_2		=	"DispMedicationAllStages" ;
			String	bean_name_2		=	"ePH.DispMedicationAllStages";
			DispMedicationAllStages bean_2	= (DispMedicationAllStages)getBeanObject( bean_id_2, bean_name_2, request);
			String sort_token_series_ind     =   bean.getSortTokenSeriesInd(); //Added for HSA-CRF-0136 [IN:048412]
			String gender			=	null;
			String sOrderType		= bean.getCriteriaOrderType()==null?"":bean.getCriteriaOrderType();
			String from				= CommonBean.checkForNull(request.getParameter("from"));
			String to				= CommonBean.checkForNull(request.getParameter("to"));
			String sPriorityImg		= "&nbsp;";
			String dispname="";
			String desp_name_code_loc="";
			String desp_name_code="";
			boolean newaeheader=false;
		//if(!from.equals("") && !to.equals(""))
			//bean.setPatientID("");
			String tab_based_group_sort_disp	 = bean.getTabBasegGroupSortDisp();
			String customGroupBy	 = bean.getCustomGroupBy();
			String customGroupByHeader = "";
			String prevCustomGroupByHeader = "";
			ArrayList result		 = bean.getAllThePatientsBasedOnCriteria(from,to);

			if(result == null)
				result = new ArrayList();
			String relflag= "false";// Added for Bru-HIMS-CRF-416[IN045566]--start
			relflag = bean.getreleaseFlag();
			ArrayList patientsList		 = bean.getallPatients();
			String selptid = bean.getRelPatientID();
			if(patientsList.contains(selptid)){
				ptindex = patientsList.indexOf(selptid);
			}
			else{
				relflag = "disp";

            _bw.write(_wl_block9Bytes, _wl_block9);
				
			}//Added for Bru-HIMS-CRF-416[IN045566] --end
			String disp_locn_catg	   = bean.getDispLocnCatg();	
			String sysdate             = bean.getTodaysDate();
			String getDate_plus_365	   = bean.getDate_plus_365();	

			if(!(locale.equals("en"))){//added for IN25886 --26/04/2011-- priya
				 sysdate = com.ehis.util.DateUtils.convertDate(sysdate, "DMY","en", locale);
				 getDate_plus_365 =  com.ehis.util.DateUtils.convertDate(getDate_plus_365, "DMY","en", locale);
			} 

			String scope               = bean.getScope();
			String disp_stage		   = bean.getDispStage();
			String disp_locn_code	   = bean.getDispLocnCode();
			String patient_id		   = "";
			String lock_status		   = "";
			//String patient_id_status   = "";	//Commented for Checkstyle
			String user_id             = "";
			String locked_date_time    = "";
			String Unlock_all_records_yn      = "";
			String allow_disp_record_lock_yn  = "";
			HashMap AccessRightMap            = new HashMap();
			int resultSize			= 19; //changed from 15 to 18 for RUT-CRF-0083.5 [IN:041511] // 18 Changed to 19 for BSP-SCF-0060
			if((disp_locn_catg.equals("IAE") || disp_locn_catg.equals("I")) && !((String) bean.getFillList()).equals("AF")){ // Added for KDAH-CRF-0338 - Start
				resultSize			= 20; // 19 Changed to 20 for BSP-SCF-0060
			} // Added for KDAH-CRF-0338 - End
			
			if((disp_locn_catg.equals("IAE") || (disp_locn_catg.equals("I") && !((String) bean.getFillList()).equals("AF"))) && bean.getDisp_locn_iae().contains("@@@")) //modified  by Himanshu For MMS-DM-CRF-0232 starts
			{
				resultSize			= 21;
			}
			//Added  by Himanshu For MMS-DM-CRF-0232 starts
			if(disp_locn_catg.equals("O") && bean.getDisp_locn_iae().contains("@@@"))
			{
				resultSize			= 20;
			}
			
			int recCount			= 0;
			int tmp_recCount		= 0;
			String ord_loc			= "";
			String classvalue		= "";
			String flag				="N";
			
			String flag1				="N";
			String patient_class="";
			String patient_class_temp="";
			
			String sTokenNumbers	= "";
			String clinic_or_nursing_unit ="";
			String criteria_patient_id = request.getParameter("patient_id");
			boolean record_found=true;
			String QMS_required_yn = "Y"; // Added for Bru-HIMS-CRF-076 [IN:029942]
			if(bean.getIssueTokenOnRegnYN().equals("Y"))// Added for Bru-HIMS-CRF-076 [IN:029942]
				QMS_required_yn = bean.getQMSRequiredYN();
			if(!bean.getIssueTokenOnRegnYN().equals("Y") || disp_locn_catg.equals("I"))
				sort_token_series_ind="O";
			//String patinet_tokens	= ""; //Added for Bru-HIMS-CRF-142 [IN:030195] - start//Commented for Checkstyle
			String storage_locn_appl_yn = bean.getStorageLocnApplYN(disp_locn_code);
			String storage_locn_text = "Patient Called";
			String patient_arvd		= "";	//Added for Bru-HIMS-CRF-142 [IN:030195] - End
			String ordering_facility_id="";// added for ML-BRU-SCF-0792 [IN:039236]
			String sTokenNos="";// added for ML-BRU-SCF-0786 [IN:039204]
			//String patient_class="", encounter_id, episode_id;// added for RUT-CRF-0083.5 [IN:041511] Commented for Checkstyle
			String order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");//Added for JD-CRF-0181[IN045511]		
			String bed_no = ""; // Added for KDAH-CRF-0338
			String refresh_pat_details ="YES";//Added for TH-KW-CRF-0011
			String disp_auto_refresh =bean.getDispAutoRefresh();//Added for TH-KW-CRF-0011
			int refresh_time = Integer.parseInt(disp_auto_refresh)*60000;//Added for TH-KW-CRF-0011
			/* Added for ML-MMOH-CRF-0532 [IN061327]  start*/
			
			 con						= ConnectionManager.getConnection(request);
			 boolean siteOrder = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ORDER_LOCATION");
			 boolean site  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PATIENT_LOCATION"); //Added for ML-MMOH-SCF-1904
			 boolean auto_refresh  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_MEDICATION_AUTO_REFRESH"); //Added for TH-KW-CRF-0011
			 boolean display_delivery_bin = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISPLAY_DELIVERY_BIN");//Adding start for TH-KW-CRF-0020.9
			 boolean ph_print_prescription  = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_PRINT_PRESCRIPTION"); //Added for MMS-DM-CRF-0228	 		 
			boolean isSite_integration_em_bd_pyxis =  eCommon.Common.CommonBean.isSiteSpecific(con,"PH","PH_INTEGRATION_EM_BD_PYXIS"); //  Added  by Himanshu For MMS-DM-CRF-0232
			 String delivery_bin_yn ="";
					 
			//MMS-DM-CRF-0228 start
			String maxRecord1 = "";
			double maxRecord = 0;
			
			if(ph_print_prescription){
				maxRecord1 = (String)result.get(0);
			}
			
			if(maxRecord1 == null) maxRecord1="";
			if (!maxRecord1.equals(""))
			maxRecord = Double.parseDouble((String)maxRecord1);
	
			int start			= 0;
			int end				= 0;
			int searchThreshold	= 12;
			double maxDisplay	= 0;
			double maxDisplay1	= 0;
			int TotalNoRecords = 0;
			String mode = "";
			
			if(ph_print_prescription){
			from = request.getParameter( "from" );
			to = request.getParameter( "to" );

			if ( from == null || from.equals(""))
			    start = 1 ;
			else
			    start = Integer.parseInt( from ) ;
			if ( to == null || to.equals(""))
			    end = searchThreshold ;
			else
			    end = Integer.parseInt( to ) ;
			}

			double Hit=0;
			double Hit_for_buttons=0;
			String maxDisp = eCommon.Common.CommonBean.checkForNull(request.getParameter("maxdisplay"),"0");
			String maxDisp1 = eCommon.Common.CommonBean.checkForNull(request.getParameter("maxdisplay1"),"0");
	
			if (maxDisp==null ||maxDisp.equals("0.0")) maxDisp = "0";
			if (maxDisp1==null ||maxDisp1.equals("0.0")) maxDisp1 = "0";
			maxDisplay = Double.parseDouble(maxDisp);
			maxDisplay1 = Double.parseDouble(maxDisp1);					 	 
			//MMS-DM-CRF-0228 end	 
			
			 if(display_delivery_bin)
                   delivery_bin_yn ="Y";
			 else
				   delivery_bin_yn = "N";//Adding end for TH-KW-CRF-0020.9
			 /* Added for ML-MMOH-CRF-0532 [IN061327] end */
			
			
				
					//if(scope.equals("EX"))
				//resultSize = 17; //Commented for IN 32923 //14->17 RUT-CRF-0083.5 [IN:041511]

            _bw.write(_wl_block10Bytes, _wl_block10);
 
			if(tab_based_group_sort_disp.equals("Y") && bean.getCustomTabBased().equals("Y")){
				String customTabBasedHrs = bean.getCustomTabBasedHrs();
				String customTabBasedOption = bean.getCustomTabBasedOption();
				String pastTabClass="CAFIRSTSELECTHORZ", currentTabClass="CASECONDSELECTHORZ";
				if(customTabBasedOption.equals("PAST")){
					pastTabClass="CASECONDSELECTHORZ";
					currentTabClass="CAFIRSTSELECTHORZ";
				}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(currentTabClass));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean.getIssueTokenOnRegnYN()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean.getFillList()));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(customTabBasedHrs));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pastTabClass));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bean.getIssueTokenOnRegnYN()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean.getFillList()));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(customTabBasedHrs));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

			}

            _bw.write(_wl_block21Bytes, _wl_block21);

			if((result.size()<resultSize && disp_locn_catg.equals("O"))||(result.size()<15 && disp_locn_catg.equals("I"))||(result.size()<15 && disp_locn_catg.equals("IAE"))){
				record_found = false;

            _bw.write(_wl_block22Bytes, _wl_block22);
            if(auto_refresh && refresh_pat_details.equals("YES")){//Added if condition for TH-KW-CRF-0011

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(refresh_time));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

				if(!tab_based_group_sort_disp.equals("Y") && !bean.getCustomTabBased().equals("Y")){
					return;
				}
			}
			if(record_found){
				if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ) && ( !( ((String) result.get(0)).equals("")) )){

            _bw.write(_wl_block26Bytes, _wl_block26);
                  if(auto_refresh && refresh_pat_details.equals("YES")){ //Added if condition for TH-KW-CRF-0011

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(refresh_time));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

	// For display the previous/next link
			if(!ph_print_prescription){ //Added for MMS-DM-CRF-0228 start
				out.println(result.get(0));
			}
			else{
				if ( !(start <= 1) ) 
		    	{

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Hit));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Hit));
            _bw.write(_wl_block30Bytes, _wl_block30);

					}
				    else 
				    {

            _bw.write(_wl_block31Bytes, _wl_block31);

				            String display_anchors = "";  
				            if(mode.equals(""))
				            {                                               
								maxDisplay = maxRecord/searchThreshold;                             
				                if (maxRecord > 10)
								{
									maxDisplay = Math.ceil(maxDisplay); 
								}else
								{
									maxDisplay = Math.floor(maxDisplay);
								}
				                if (maxDisplay>5) maxDisplay1=5; else maxDisplay1 = maxDisplay;
				                int noofRec = 1;
				                int number=0;
				                display_anchors = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";             
				                for (int i=1;i<=maxDisplay1;i++) 
								{
				                	noofRec=(i-1)*12+1;
				                	number=number+12;
				                    display_anchors = display_anchors +"<b><a name='str"+noofRec+"' href='javascript:SubmitLinkForPagination("+noofRec+","+(number)+","+noofRec+")'>"+(i)+"</a></b>";
				                    display_anchors = display_anchors +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				                   // noofRec =noofRec +searchThreshold;
				                }											
							}
				            				            

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(display_anchors));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(maxDisplay));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block36Bytes, _wl_block36);

					}
				}//Added for MMS-DM-CRF-0228 end
			
				//result.remove(0);

            _bw.write(_wl_block37Bytes, _wl_block37);
 
				}

            _bw.write(_wl_block38Bytes, _wl_block38);
if(disp_locn_catg.equals("I") && !((String) bean.getFillList()).equals("AF")){ //&& !((String) bean.getFillList()).equals("AF") added for ip with fill list// Added for KDAH-CRF-0338 - Start 
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
} else{ 
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
} // Added for KDAH-CRF-0338 - End 
            _bw.write(_wl_block2Bytes, _wl_block2);

					if(sort_token_series_ind.equals("R")){

            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

					}
					else if(sort_token_series_ind.equals("P")){

            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

					}
					else {

            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

					}

            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

					if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
						/* Added for ML-MMOH-CRF-0532 [IN061327] start */
						if(siteOrder && disp_locn_catg.equalsIgnoreCase("I")){
						
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
			}
						else if(disp_locn_catg.equalsIgnoreCase("I") && !((String) bean.getFillList()).equals("AF")){ // else if condition Added for KAUH-CRF-0338 - Start
				
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
	} // else if condition Added for KAUH-CRF-0338 - End
						else{
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            _bw.write(_wl_block2Bytes, _wl_block2);

		                          }/* Added for ML-MMOH-CRF-0532 [IN061327] end */	
                                        }
					if((disp_locn_catg.equalsIgnoreCase("I") || disp_locn_catg.equalsIgnoreCase("IAE")) && !((String) bean.getFillList()).equals("AF")){
						//condition Added for KAUH-CRF-0338 -Start 
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
 	} 

//Added  by Himanshu For MMS-DM-CRF-0232 starts
if(isSite_integration_em_bd_pyxis && bean.getDisp_locn_iae().contains("@@@"))
{
	
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

	}
//Added  by Himanshu For MMS-DM-CRF-0232 ends

// condition Added for KDAH-CRF-0338 - End

            _bw.write(_wl_block61Bytes, _wl_block61);
				//added for GHL-CRF-0453 - start
				String print_value = "";
				String min_value   = "0";//GHL-CRF-0453
				String max_value   = "0";//GHL-CRF-0453
				String print_msg   = "";
				String print_spilt = "";//GHL-CRF-0453
				String bin_location ="";
				HashMap printValueForOrders = bean.getPrintValueForOrders(); //CRF-453
				//added for GHL-CRF-0453 - end
				if( disp_locn_catg.equals("O")&&!scope.equals("EX")){
					for(int i=0;i<result.size();i=i+resultSize){

						if(recCount%2==0){
							classvalue = "QRYODD";
						}
						else{
							classvalue = "QRYEVEN";
						}
						if(i==0)
							++i;	
						
						////Added  by Himanshu For MMS-DM-CRF-0232 starts
						if(isSite_integration_em_bd_pyxis)
						{
						if(bean.getDisp_locn_iae().contains("@@@")){
						desp_name_code_loc=(String) result.get(i+18);
						String desp_code_loc[]=	desp_name_code_loc.split(" &&& ");
						//bean.setDisp_locn_codeall(desp_code_loc[0]); // this is created for getOrders(patient id) for all dispnce location scenario
						desp_name_code=desp_code_loc[0];
						dispname=desp_code_loc[1];
						 }else
						 {
							// bean.setDisp_locn_codeall(bean.getDisp_locn_iae());
							 desp_name_code=bean.getDisp_locn_iae();
						 }
						}//Added  by Himanshu For MMS-DM-CRF-0232 ends
						
						
						//Added for Bru-HIMS-CRF-142 [IN:030195] - start
						sTokenNos="";
						if(bean.getIssueTokenOnRegnYN().equals("Y")){
							sTokenNumbers = result.get(i+10)!=null?result.get(i+10).toString():"";
							if(sTokenNumbers != null && !sTokenNumbers.equals("") && sTokenNumbers.length() >1){
								if(sTokenNumbers.indexOf("~")!=-1){ //if condition and else block added for RUT-SCF-0264 [IN:039436]
									if(sTokenNumbers.indexOf("/")!=-1) //if and else block added for RUT-SCF-0264 [IN:039436]
										sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1, sTokenNumbers.indexOf("/"));	// added for ML-BRU-SCF-0786 [IN:039204]
									sTokenNumbers = sTokenNumbers.replaceAll("~",",").substring(0,sTokenNumbers.length());
								}
							 }
							if(sTokenNos.equals("")){
								if(sTokenNumbers.indexOf("/")!=-1) //if and else block added for RUT-SCF-0264 [IN:039436]
									sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1, sTokenNumbers.indexOf("/"));	// added for ML-BRU-SCF-0786 [IN:039204]
								else
									sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1,sTokenNumbers.length());	// added for ML-BRU-SCF-0786 [IN:039204]
							}
						}
						if(sTokenNumbers.indexOf("><")>1){
							 patient_arvd   = sTokenNumbers.substring(sTokenNumbers.indexOf("=")+1,sTokenNumbers.indexOf("><"));
						}
						if(storage_locn_appl_yn.equals("Y")){
							storage_locn_text = "Keep in Delivery Bin";
						}
						//Added for Bru-HIMS-CRF-142 [IN:030195] - End
						sPriorityImg =  result.get(i+11).toString().equals("U")?"<img src='../../ePH/images/Urgent.gif' style='width:14;height:10' title='"+sUrgentTitle+"' >":"&nbsp;";
						if(disp_stage.equals("AS")||disp_stage.equals("A")||disp_stage.equals("F")||disp_stage.equals("D")||disp_stage.equals("V")){

            _bw.write(_wl_block62Bytes, _wl_block62);

							if(clinic_or_nursing_unit.equals("")|| !(clinic_or_nursing_unit.equals(((String)result.get(i+9))))){
								clinic_or_nursing_unit =result.get(i+9)==null?"":(String)result.get(i+9);
								flag="Y";
							}
							if(flag.equals("Y")){
								if(clinic_or_nursing_unit.equals("N")){

            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

								}
								else{

            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
	
								}
								flag="N";
							}
						}
						if(!ord_loc.equals((String)result.get(i))&&((bean.getGroupByOrdLocn()).equals("Y"))) {
							ord_loc	=	result.get(i)==null?"":(String)result.get(i);		

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(ord_loc));
            _bw.write(_wl_block60Bytes, _wl_block60);
	
								tmp_recCount	=	recCount;
						}
						else {

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
	
						}	
						patient_id					=	(String)result.get(i+1);
					    ordering_facility_id =    (String)result.get(i+14);// added for ML-BRU-SCF-0792 [IN:039236]
			//changed during PE BY Naveen
					   // allow_disp_record_lock_yn	=	bean.getAllowdisprecordlock(facility_id);
						allow_disp_record_lock_yn	=	bean.getAllow_disp_record_lock_yn();
						if(allow_disp_record_lock_yn.equals("Y")){
							 lock_status   =  bean.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
						
							ArrayList AccessRight	=	bean.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
				//commented during PE By Naveen
						   // Unlock_all_records_yn	=	bean.getUnLockRecordsYN(login_user,disp_locn_code);
							Unlock_all_records_yn   =   bean.geuUnlockAllRecordsYN();
							if(AccessRight.size()>0){
							  for(int j=0; j<AccessRight.size(); j++){
									AccessRightMap		= (HashMap)AccessRight.get(j);
									user_id				= (String)AccessRightMap.get("user_id");
									locked_date_time	= (String)AccessRightMap.get("locked_date_time");
								}
							}
						}
						else if(allow_disp_record_lock_yn.equals("N")){
							 lock_status   = "0";
						}			

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sPriorityImg));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block74Bytes, _wl_block74);

								if(!patient_arvd.equals("red")||!(disp_stage.equals("D")||disp_stage.equals("AS"))){ //if condition Added for Bru-HIMS-CRF-142 [IN:030195] - start

            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(ord_loc)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allow_disp_record_lock_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+14)));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(lock_status));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allow_disp_record_lock_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf((String)result.get(i+14)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf("S"+result.get(i+1)));
            _bw.write(_wl_block85Bytes, _wl_block85);

                                  if(delivery_bin_yn.equals("Y") && storage_locn_appl_yn.equals("Y")){//Adding start for TH-KW-CRF-0020.9
										String en_id = (String)result.get(i+15);

										bin_location =bean_2.getBinLocation(patient_id,en_id,disp_locn_code);

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bin_location));
            _bw.write(_wl_block88Bytes, _wl_block88);

                                 }//Adding end for TH-KW-CRF-0020.9
								}
								else{ //else block Added for Bru-HIMS-CRF-142 [IN:030195] - start

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block2Bytes, _wl_block2);

								}
								if(bean.getIssueTokenOnRegnYN().equals("Y")){
									/*sTokenNumbers = result.get(i+(resultSize-4))!=null?result.get(i+(resultSize-4)).toString():"";
									if(sTokenNumbers != null && !sTokenNumbers.equals("") && sTokenNumbers.length() >1){
										sTokenNumbers = sTokenNumbers.replaceAll("~",",").substring(0,sTokenNumbers.length()-1);*/ //Commented for  Bru-HIMS-CRF-142 [IN:030195]

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(sTokenNumbers));
            _bw.write(_wl_block94Bytes, _wl_block94);

										if(QMS_required_yn.equals("Y") && disp_stage.equals("D")){

            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sTokenNos));
            _bw.write(_wl_block97Bytes, _wl_block97);

										}
									 //} //commented for  Bru-HIMS-CRF-142 [IN:030195]
								 }
								 //added for GHL-CRF-0453 - start							
								if(printValueForOrders!=null && printValueForOrders.size()>0)
									{
										print_value = "";
											print_spilt = (String)printValueForOrders.get(patient_id);//8/2/2017 GHL-CRF-0453
											if(print_spilt!=null){ //GHL-CRF-0453
												min_value = ((String)printValueForOrders.get(patient_id)).split("~")[0];
												max_value = ((String)printValueForOrders.get(patient_id)).split("~")[1];
											}
											if(Integer.parseInt(max_value)==1)
												print_value = "1";
											
										//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
											if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
												print_msg = "P";

											if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
												print_msg = "F";

									//	System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====346====>"+print_msg);
									}
								
								if(disp_stage.equals("F") || disp_stage.equals("A")){	//Added for IN:065140
									if(print_value.equals("1")){
										if(print_msg.equals("F")){

            _bw.write(_wl_block98Bytes, _wl_block98);
											}else{ 
            _bw.write(_wl_block99Bytes, _wl_block99);
											}
										} 
									} //added for GHL-CRF-0453 - end
									
								if(ph_print_prescription && (disp_stage.equals("A") || disp_stage.equals("AS") || disp_stage.equals("D"))){ //Added for MMS-DM-CRF-0228 start	
								
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sOrderType));
            _bw.write(_wl_block103Bytes, _wl_block103);
}//Added for MMS-DM-CRF-0228 end 
            _bw.write(_wl_block104Bytes, _wl_block104);

								if(lock_status.equals("1")){
									if(Unlock_all_records_yn.equals("Y")){

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locked_date_time));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(Unlock_all_records_yn));
            _bw.write(_wl_block108Bytes, _wl_block108);

									}
									else if(Unlock_all_records_yn.equals("N")){

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locked_date_time));
            _bw.write(_wl_block109Bytes, _wl_block109);

									}
							   }
							   else if(lock_status.equals("0")||lock_status.equals("")){

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block111Bytes, _wl_block111);

								}

            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(lock_status));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block117Bytes, _wl_block117);

								if((disp_stage.equals("D") || disp_stage.equals("AS"))  && storage_locn_appl_yn.equals("Y") && (patient_arvd.equals("red") || patient_arvd.equals("green")) || ((disp_stage.equals("D") || disp_stage.equals("AS")) && delivery_bin_yn.equals("Y") && storage_locn_appl_yn.equals("Y"))){//|| ((disp_stage.equals("D") || disp_stage.equals("AS")) && delivery_bin_yn.equals("Y")) added for TH-KW-CRF-0020.9 and storage_locn_appl_yn.equals("Y") added for ICN-40445

            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(storage_locn_text));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_arvd));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(storage_locn_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(delivery_bin_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+15)));
            _bw.write(_wl_block121Bytes, _wl_block121);

								}
								else if(disp_stage.equals("D") && storage_locn_appl_yn.equals("N") && patient_arvd.equals("green")){

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(storage_locn_text));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_arvd));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(storage_locn_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block125Bytes, _wl_block125);

								}

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale)));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block60Bytes, _wl_block60);
 
								if( ((String)result.get(i+7)).equals("M"))
									gender	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
								else if( ((String)result.get(i+7)).equals("F")) 
									gender	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
								if( ((String)result.get(i+7)).equals("U")) 
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block60Bytes, _wl_block60);

								if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i)==null?"":result.get(i)));
            _bw.write(_wl_block134Bytes, _wl_block134);

								}
						//Added  by Himanshu For MMS-DM-CRF-0232 starts
						if(isSite_integration_em_bd_pyxis && bean.getDisp_locn_iae().contains("@@@"))
						{

            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(dispname));
            _bw.write(_wl_block136Bytes, _wl_block136);

								}
						
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(ord_loc));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block142Bytes, _wl_block142);

								//String next_appt_days =bean.CheckForAppointments((String)result.get(i+1));

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sOrderType));
            _bw.write(_wl_block154Bytes, _wl_block154);

								//	if(!next_appt_days.equals("")){

            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(getDate_plus_365));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block159Bytes, _wl_block159);

								//	} <!--&nbsp;<b>(<%/*=next_appt_days%*/>)</b> -->
									if(bean.getIssueTokenOnRegnYN().equals("Y") && QMS_required_yn.equals("Y") && disp_stage.equals("D")){	// added for ML-BRU-SCF-0786 [IN:039204]

            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sTokenNos));
            _bw.write(_wl_block97Bytes, _wl_block97);

									}			

            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+15)));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+16)));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+17)));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(desp_name_code));
            _bw.write(_wl_block173Bytes, _wl_block173);
if(bean.getDisp_locn_iae().contains("@@@")){ //modified  by Himanshu For MMS-DM-CRF-0232 starts
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+19)));
            _bw.write(_wl_block176Bytes, _wl_block176);
 }else{
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+18)));
            _bw.write(_wl_block178Bytes, _wl_block178);
 } 
								if(  !((String) bean.getFillList()).equals("AF")){//if  condtion is add for Ip with fill  
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block181Bytes, _wl_block181);
  } 
            _bw.write(_wl_block182Bytes, _wl_block182);
     
								recCount++;
							}
						}
						else if ( disp_locn_catg.equals("O")&&scope.equals("EX")){	
							for(int i=0;i<result.size();i=i+resultSize){
								if(recCount%2==0){
									classvalue = "QRYODD";
								}
								else{
									classvalue = "QRYEVEN";
								}
							
								if(i==0)
									i++;
								
								//Added  by Himanshu For MMS-DM-CRF-0232 starts
								if(isSite_integration_em_bd_pyxis)
								{
								if(bean.getDisp_locn_iae().contains("@@@")){
								desp_name_code_loc=(String) result.get(i+18);
								String desp_code_loc[]=	desp_name_code_loc.split(" &&& ");
								//bean.setDisp_locn_codeall(desp_code_loc[0]); // this is created for getOrders(patient id) for all dispnce location scenario
								desp_name_code=desp_code_loc[0];
								dispname=desp_code_loc[1];
								 }else
								 {
									// bean.setDisp_locn_codeall(bean.getDisp_locn_iae());
									 desp_name_code=bean.getDisp_locn_iae();
								 }
								}
								//Added  by Himanshu For MMS-DM-CRF-0232 ends
								
								//Added for Bru-HIMS-CRF-142 [IN:030195] - start
								sTokenNos="";
								if(bean.getIssueTokenOnRegnYN().equals("Y")){
									sTokenNumbers = result.get(i+10)!=null?result.get(i+10).toString():"";
									if(sTokenNumbers != null && !sTokenNumbers.equals("") && sTokenNumbers.length() >1){
										if(sTokenNumbers.indexOf("~")!=-1){ //if condition and else block added for RUT-SCF-0264 [IN:039436]
											if(sTokenNumbers.indexOf("/")!=-1) //if and else block added for RUT-SCF-0264 [IN:039436]
												sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1, sTokenNumbers.indexOf("/"));	// added for ML-BRU-SCF-0786 [IN:039204]
											sTokenNumbers = sTokenNumbers.replaceAll("~",",").substring(0,sTokenNumbers.length());
										}
									 }
									if(sTokenNos.equals("")){
										if(sTokenNumbers.indexOf("/")!=-1) //if and else block added for RUT-SCF-0264 [IN:039436]
											sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1, sTokenNumbers.indexOf("/"));	// added for ML-BRU-SCF-0786 [IN:039204]
										else
											sTokenNos = sTokenNumbers.substring(sTokenNumbers.indexOf("(")+1,sTokenNumbers.length());	// added for ML-BRU-SCF-0786 [IN:039204]
									}
								}
								if(sTokenNumbers.indexOf("><")>1){
									 patient_arvd   = sTokenNumbers.substring(sTokenNumbers.indexOf("=")+1,sTokenNumbers.indexOf("><"));
								}
								if(storage_locn_appl_yn.equals("Y")){
									storage_locn_text = "Keep in Delivery Bin";
								}
								//Added for Bru-HIMS-CRF-142 [IN:030195] - End
								sPriorityImg = result.get(i+12).toString().equals("U")?"<img src='../../ePH/images/Urgent.gif' style='width:14;height:10' title='"+sUrgentTitle+"' />":"&nbsp;";
								patient_id=(String)result.get(i+1);
								String patient_name=(String)result.get(i+2);
								 ordering_facility_id =    (String)result.get(i+14);// added for ML-BRU-SCF-0792 [IN:039236]
								//changed during PE By Naveen
								//  allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
								allow_disp_record_lock_yn=bean.getAllow_disp_record_lock_yn();
								if(allow_disp_record_lock_yn.equals("Y")){
									lock_status=bean.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
									ArrayList AccessRight=bean.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
									//commented during PE By Naveen
									// Unlock_all_records_yn=bean.getUnLockRecordsYN(login_user,disp_locn_code);
									Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();
									if(AccessRight.size()>0){
									  for(int j=0; j<AccessRight.size(); j++){
											AccessRightMap = (HashMap)AccessRight.get(j);
											user_id = (String)AccessRightMap.get("user_id");
											locked_date_time = (String)AccessRightMap.get("locked_date_time");
										}
									}
								}
								else if(allow_disp_record_lock_yn.equals("N")){
									lock_status="0";
								}

            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_name,"UTF-8")));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sPriorityImg));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block74Bytes, _wl_block74);

								if(!patient_arvd.equals("red")||!(disp_stage.equals("D")||disp_stage.equals("AS"))){ //if condition Added for Bru-HIMS-CRF-142 [IN:030195] - start

            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+4)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_name,"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(ord_loc)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allow_disp_record_lock_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+14)));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf("S"+result.get(i+1)));
            _bw.write(_wl_block85Bytes, _wl_block85);

								}
								else{ //else block Added for Bru-HIMS-CRF-142 [IN:030195] - start

            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+9)));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block2Bytes, _wl_block2);

								}

								if(bean.getIssueTokenOnRegnYN().equals("Y")){
									/*sTokenNumbers = result.get(i+(resultSize-4))!=null?result.get(i+(resultSize-4)).toString():"";
									if(sTokenNumbers != null && !sTokenNumbers.equals("")  && sTokenNumbers.length() >1){
										sTokenNumbers = sTokenNumbers.replaceAll("~",",").substring(0,sTokenNumbers.length()-1);*/

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(sTokenNumbers));
            _bw.write(_wl_block94Bytes, _wl_block94);

									//}
									if( QMS_required_yn.equals("Y") && disp_stage.equals("D")){	// added for ML-BRU-SCF-0786 [IN:039204]

            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sTokenNos));
            _bw.write(_wl_block97Bytes, _wl_block97);

									}			
								}

            _bw.write(_wl_block190Bytes, _wl_block190);
 //added for GHL-CRF-0453 - start								
								if(printValueForOrders!=null && printValueForOrders.size()>0)
									{
										print_value = "";
											print_spilt = (String)printValueForOrders.get(patient_id);//8/2/2017 GHL-CRF-0453
											if(print_spilt!=null){ //GHL-CRF-0453
												min_value = ((String)printValueForOrders.get(patient_id)).split("~")[0];
												max_value = ((String)printValueForOrders.get(patient_id)).split("~")[1];
											}
											if(Integer.parseInt(max_value)==1)
												print_value = "1";
											
										//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
											if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
												print_msg = "P";

											if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
												print_msg = "F";

									//	System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====346====>"+print_msg);
									}
								
								if(disp_stage.equals("F") || disp_stage.equals("A")){	//Added for IN:065140	
									if(print_value.equals("1")){
										if(print_msg.equals("F")){

            _bw.write(_wl_block98Bytes, _wl_block98);
											}else{ 
            _bw.write(_wl_block99Bytes, _wl_block99);
											}
									}
									} //added for GHL-CRF-0453 - end 
            _bw.write(_wl_block191Bytes, _wl_block191);
								if(ph_print_prescription && (disp_stage.equals("A") || disp_stage.equals("AS") || disp_stage.equals("D"))){ //Added for MMS-DM-CRF-0228 start	

            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sOrderType));
            _bw.write(_wl_block192Bytes, _wl_block192);
            _bw.write(_wl_block2Bytes, _wl_block2);
								}//Added for MMS-DM-CRF-0228 end 
            _bw.write(_wl_block193Bytes, _wl_block193);
								
								if(lock_status.equals("1")){
									if(Unlock_all_records_yn.equals("Y")){

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locked_date_time));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(Unlock_all_records_yn));
            _bw.write(_wl_block108Bytes, _wl_block108);

									}
									else if(Unlock_all_records_yn.equals("N")){

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locked_date_time));
            _bw.write(_wl_block109Bytes, _wl_block109);

									}
								}
								else if(lock_status.equals("0")||lock_status.equals("")){

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block111Bytes, _wl_block111);

								}

            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(lock_status));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block195Bytes, _wl_block195);

								if((disp_stage.equals("D") || disp_stage.equals("AS"))  && storage_locn_appl_yn.equals("Y") && (patient_arvd.equals("red") || patient_arvd.equals("green"))){

            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(storage_locn_text));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_arvd));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(storage_locn_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block196Bytes, _wl_block196);

								}
								else if(disp_stage.equals("D") && storage_locn_appl_yn.equals("N") && patient_arvd.equals("green")){

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(storage_locn_text));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_arvd));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(storage_locn_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ordering_facility_id));
            _bw.write(_wl_block196Bytes, _wl_block196);

								}

            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale)));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block60Bytes, _wl_block60);
	
							if( ((String)result.get(i+7)).equals("M"))
								gender	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if( ((String)result.get(i+7)).equals("F"))
								gender	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							if( ((String)result.get(i+7)).equals("U")) 
								gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block204Bytes, _wl_block204);
		//Added  by Himanshu For MMS-DM-CRF-0232 starts
						if(isSite_integration_em_bd_pyxis && bean.getDisp_locn_iae().contains("@@@"))
						{

            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(dispname));
            _bw.write(_wl_block136Bytes, _wl_block136);

								}
						
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(result.get(i)));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block142Bytes, _wl_block142);

							//String next_appt_days =bean.CheckForAppointments((String)result.get(i));

            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sOrderType));
            _bw.write(_wl_block192Bytes, _wl_block192);
            _bw.write(_wl_block2Bytes, _wl_block2);

								//if(!next_appt_days.equals("")){

            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(result.get(i)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(getDate_plus_365));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block159Bytes, _wl_block159);

								//} &nbsp;(<%*/=next_appt_days%*/>)
								if(bean.getIssueTokenOnRegnYN().equals("Y") && QMS_required_yn.equals("Y") && disp_stage.equals("D")){	// added for ML-BRU-SCF-0786 [IN:039204]

            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(sTokenNos));
            _bw.write(_wl_block97Bytes, _wl_block97);

								}

            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+15)));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+16)));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+17)));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(desp_name_code));
            _bw.write(_wl_block224Bytes, _wl_block224);
if(bean.getDisp_locn_iae().contains("@@@")){ //modfied  by Himanshu For MMS-DM-CRF-0232 starts 
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+19)));
            _bw.write(_wl_block176Bytes, _wl_block176);
 }else{
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+18)));
            _bw.write(_wl_block178Bytes, _wl_block178);
 } 
						 if(  !((String) bean.getFillList()).equals("AF")){ //if  condtion is add for Ip with fill 
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block226Bytes, _wl_block226);
} 
            _bw.write(_wl_block2Bytes, _wl_block2);
     
						recCount++;
					}
				}
				else if(disp_locn_catg.equals("I")){
					classvalue	= "";
					//String ord_loc		= "";
					for(int i=0;i<result.size();i=i+resultSize){
						if(recCount%2==0){
							classvalue = "QRYODD";
						}
						else{
							classvalue = "QRYEVEN";
						}
						if(i==0){
							++i;
						}

						//Added  by Himanshu For MMS-DM-CRF-0232 starts
						if(isSite_integration_em_bd_pyxis){
							if(bean.getDisp_locn_iae().contains("@@@")){
								desp_name_code_loc=(String) result.get(i+19);
							String desp_code_loc[]=	desp_name_code_loc.split(" &&& ");
							//bean.setDisp_locn_codeall(desp_code_loc[0]); // this is created for getOrders(patient id) for all dispnce location scenario
							desp_name_code=desp_code_loc[0];
							dispname=desp_code_loc[1];
							 }else
							 {
								// bean.setDisp_locn_codeall(bean.getDisp_locn_iae());
								 desp_name_code=bean.getDisp_locn_iae();
							 }
						}
						//Added  by Himanshu For MMS-DM-CRF-0232 ends
						
						sPriorityImg = result.get(i+11).toString().equals("U")?"<img src='../../ePH/images/Urgent.gif' style='width:14;height:10' title='"+sUrgentTitle+"' />":"&nbsp;";
						if(tab_based_group_sort_disp.equals("Y") && !customGroupBy.equals("NONE")  ){
							if(customGroupBy.equals("NURSING_UNIT"))
								customGroupByHeader = (String)result.get(i);
							if(customGroupBy.equals("RELEASE_DATE_TIME")){
								customGroupByHeader = com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale);
								customGroupByHeader = customGroupByHeader.substring(0,10);
							}
							if(customGroupBy.equals("ORD_DATE_TIME")){
								customGroupByHeader = com.ehis.util.DateUtils.convertDate((String)result.get(i+13),"DMY","en",locale);
								customGroupByHeader = customGroupByHeader.substring(0,10);
							}
							if(customGroupBy.equals("PRIORITY"))
								customGroupByHeader = (String)result.get(i+11);
							if(customGroupBy.equals("PERFORMING_DEPTLOC_CODE") && bean.getDisp_locn_iae().contains("@@@"))
								customGroupByHeader = dispname;
							if(!prevCustomGroupByHeader.equals(customGroupByHeader)){
								prevCustomGroupByHeader = customGroupByHeader ;

            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(customGroupByHeader));
            _bw.write(_wl_block229Bytes, _wl_block229);

							}
							else{

            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block69Bytes, _wl_block69);

							}
						}
						else if(!ord_loc.equals((String)result.get(i))&&((bean.getGroupByOrdLocn()).equals("Y"))) {
							ord_loc	=	result.get(i)==null?"":(String)result.get(i);		

            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(ord_loc));
            _bw.write(_wl_block233Bytes, _wl_block233);
	
								tmp_recCount	=	recCount;
						}
						else{

            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block69Bytes, _wl_block69);

						}
						patient_id=(String)result.get(i+1);
						//changed during PE BY Naveen	   		
						//allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
						allow_disp_record_lock_yn=bean.getAllow_disp_record_lock_yn();

						if(allow_disp_record_lock_yn.equals("Y")){
							lock_status=bean.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
							ArrayList AccessRight=bean.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
				//commented during PE By Naveen
						   // Unlock_all_records_yn=bean.getUnLockRecordsYN(login_user,disp_locn_code);
							Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();

							if(AccessRight.size()>0){
								for(int j=0; j<AccessRight.size(); j++){
									AccessRightMap = (HashMap)AccessRight.get(j);
									user_id = (String)AccessRightMap.get("user_id");
									locked_date_time = (String)AccessRightMap.get("locked_date_time");
								}
							}	 		    
						}
						else if(allow_disp_record_lock_yn.equals("N")){
							lock_status="0";
						}

            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sPriorityImg));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(ord_loc)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allow_disp_record_lock_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+14)));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(lock_status));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allow_disp_record_lock_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(ord_loc)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf("S"+result.get(i+1)));
            _bw.write(_wl_block238Bytes, _wl_block238);
								//added for GHL-CRF-0453 - start
								if(printValueForOrders!=null && printValueForOrders.size()>0)
									{
										print_value = "";
											print_spilt = (String)printValueForOrders.get(patient_id);//8/2/2017 GHL-CRF-0453
											if(print_spilt!=null){//GHL-CRF-0453
												min_value = ((String)printValueForOrders.get(patient_id)).split("~")[0];
												max_value = ((String)printValueForOrders.get(patient_id)).split("~")[1];
											}
						//System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====877====>"+print_msg);
											if(Integer.parseInt(max_value)==1)
												print_value = "1";
											
										//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
											if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
												print_msg = "P";

											if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
												print_msg = "F";

									//	System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====346====>"+print_msg);
									}

            _bw.write(_wl_block239Bytes, _wl_block239);
								if(disp_stage.equals("F") || disp_stage.equals("A")){	//Added for IN:065140	
									if(print_value.equals("1")){
										if(print_msg.equals("F")){

            _bw.write(_wl_block98Bytes, _wl_block98);
											}else{ 
            _bw.write(_wl_block99Bytes, _wl_block99);
											}
									}
									}//added for GHL-CRF-0453 - end

            _bw.write(_wl_block240Bytes, _wl_block240);

								if(lock_status.equals("1")){
									if(Unlock_all_records_yn.equals("Y")){

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locked_date_time));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(Unlock_all_records_yn));
            _bw.write(_wl_block108Bytes, _wl_block108);

									}
									else if(Unlock_all_records_yn.equals("N")){

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locked_date_time));
            _bw.write(_wl_block241Bytes, _wl_block241);
}
								   }
								   else if(lock_status.equals("0")||lock_status.equals("")){

            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block111Bytes, _wl_block111);

								   }

            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(lock_status));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale)));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block60Bytes, _wl_block60);
 
							   if( ((String)result.get(i+7)).equals("M"))
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
								else if( ((String)result.get(i+7)).equals("F"))
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
								if( ((String)result.get(i+7)).equals("U"))
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block60Bytes, _wl_block60);
  
 							//Added for ML-MMOH-SCF-1904
 							
								String pat_id=result.get(i+1)==null?"":(String)result.get(i+1);
								String enc_id=result.get(i+16)==null?"":(String)result.get(i+16);
								
								String locn_desc = bean.getPatientLocation(pat_id, enc_id);
								
							
								if(site){
									if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(locn_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);

									}
								}
								else{
									if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){

            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i)));
            _bw.write(_wl_block246Bytes, _wl_block246);

									}
								} //Modified for ML-MMOH-SCF-1904 -END

            _bw.write(_wl_block247Bytes, _wl_block247);
 if(  !((String) bean.getFillList()).equals("AF")){ //if  condtion is add for Ip with fill
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i+18)));
            _bw.write(_wl_block249Bytes, _wl_block249);
}
                             
								    if(bean.getDisp_locn_iae().contains("@@@")){ //Added  by Himanshu For MMS-DM-CRF-0232 starts
									 
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(dispname));
            _bw.write(_wl_block251Bytes, _wl_block251);
} 
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(ord_loc));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block254Bytes, _wl_block254);

								//String next_appt_days =bean.CheckForAppointments((String)result.get(i+1));

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(ord_loc)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block262Bytes, _wl_block262);

									//if(!next_appt_days.equals("")){

            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(getDate_plus_365));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block159Bytes, _wl_block159);

									//} &nbsp;(<%/*=next_appt_days%*/>)
									if(  !((String) bean.getFillList()).equals("AF")){//if  condtion is add for Ip with fill
									bed_no = (String)result.get(i+18)==null?"":(String)result.get(i+18); }// Added for KDAH-CRF-0338 

            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+15)));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+16)));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+17)));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(desp_name_code));
            _bw.write(_wl_block269Bytes, _wl_block269);
 if(  !((String) bean.getFillList()).equals("AF")){ 
									//if  condtion is add for Ip with fill 
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block270Bytes, _wl_block270);
 if(bean.getDisp_locn_iae().contains("@@@")){ //modified  by Himanshu For MMS-DM-CRF-0232 
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+20)));
            _bw.write(_wl_block271Bytes, _wl_block271);
 }else{ 
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+19)));
            _bw.write(_wl_block272Bytes, _wl_block272);
                     }
								}else{
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+18)));
            _bw.write(_wl_block273Bytes, _wl_block273);
                          }
							recCount++;
						}
					}else if(disp_locn_catg.equals("IAE") && isSite_integration_em_bd_pyxis)
					{

						classvalue	= "";
						for(int i=0;i<result.size();i=i+resultSize){
							if(recCount%2==0){
								classvalue = "QRYODD";
							}
							else{
								classvalue = "QRYEVEN";
							}
							if(i==0){
								++i;
							}
							
							//Added  by Himanshu For MMS-DM-CRF-0232 starts
							if(isSite_integration_em_bd_pyxis){
									if(bean.getDisp_locn_iae().contains("@@@"))
									{
									desp_name_code_loc=(String) result.get(i+19);
									String desp_code_loc[]=	desp_name_code_loc.split(" &&& ");
									//bean.setDisp_locn_codeall(desp_code_loc[0]); // this is created for getOrders(patient id) for all dispnce location scenario
									desp_name_code=desp_code_loc[0];
									dispname=desp_code_loc[1];
									 }else
									 {
										// bean.setDisp_locn_codeall(bean.getDisp_locn_iae());
										desp_name_code=bean.getDisp_locn_iae();
									 }
							}
							//Added  by Himanshu For MMS-DM-CRF-0232 ends
							
							
							sPriorityImg = result.get(i+11).toString().equals("U")?"<img src='../../ePH/images/Urgent.gif' style='width:14;height:10' title='"+sUrgentTitle+"' />":"&nbsp;";
							if(tab_based_group_sort_disp.equals("Y") && !customGroupBy.equals("NONE")  ){
							
								if(customGroupBy.equals("NURSING_UNIT"))
									customGroupByHeader = (String)result.get(i);
								if(customGroupBy.equals("RELEASE_DATE_TIME")){
									customGroupByHeader = com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale);
									customGroupByHeader = customGroupByHeader.substring(0,10);
								}
								if(customGroupBy.equals("ORD_DATE_TIME")){
									customGroupByHeader = com.ehis.util.DateUtils.convertDate((String)result.get(i+13),"DMY","en",locale);
									customGroupByHeader = customGroupByHeader.substring(0,10);
								}
								if(customGroupBy.equals("PRIORITY"))
									customGroupByHeader = (String)result.get(i+11);
								if(customGroupBy.equals("PERFORMING_DEPTLOC_CODE") && bean.getDisp_locn_iae().contains("@@@"))
									customGroupByHeader = dispname;
								if(!prevCustomGroupByHeader.equals(customGroupByHeader)){
									prevCustomGroupByHeader = customGroupByHeader ;
									newaeheader=true;
	
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(customGroupByHeader));
            _bw.write(_wl_block275Bytes, _wl_block275);

								}
								else{
	
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block277Bytes, _wl_block277);

								}
							}
							else if(!ord_loc.equals((String)result.get(i))&&((bean.getGroupByOrdLocn()).equals("Y"))) {
								ord_loc	=	result.get(i)==null?"":(String)result.get(i);		
	
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(ord_loc));
            _bw.write(_wl_block279Bytes, _wl_block279);
	
									tmp_recCount	=	recCount;
							}
							else{
	
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block277Bytes, _wl_block277);

							}
							///////////////////////////////////////////////////////////////////////////////////////
							if(customGroupBy.equals("NONE")){
							if(patient_class.equals("")|| !(patient_class.equals(((String)result.get(i+17))))){
								patient_class =result.get(i+17)==null?"":(String)result.get(i+17);
								
								if(patient_class.equals("IP"))
							{
								patient_class_temp="Inpatients";
							}else if(patient_class.equals("EM"))
							{
								patient_class_temp="AE patients";
							}else
							{
								patient_class_temp="";
							}
							
								flag1="Y";
							}
							if(flag1.equals("Y")){
								if(patient_class.equals("N")){

            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(patient_class_temp));
            _bw.write(_wl_block281Bytes, _wl_block281);

								}
								else{

            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(patient_class_temp));
            _bw.write(_wl_block281Bytes, _wl_block281);
	
								}
								flag1="N";
							}
							}
							
							
							if(patient_class.equals("")|| !(patient_class.equals(((String)result.get(i+17)))))
							{
								newaeheader=true;
									patient_class =result.get(i+17)==null?"":(String)result.get(i+17);
												
												if(patient_class.equals("IP"))
											{
												patient_class_temp="Inpatients";
											}else if(patient_class.equals("EM"))
											{
												patient_class_temp="AE patients";
											}else
											{
												patient_class_temp="";
											}
							}
							if(newaeheader){
								
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(patient_class_temp));
            _bw.write(_wl_block283Bytes, _wl_block283);

								newaeheader=false;
							}
							
							patient_id=(String)result.get(i+1);
							//changed during PE BY Naveen	   		
							//allow_disp_record_lock_yn=bean.getAllowdisprecordlock(facility_id);
							allow_disp_record_lock_yn=bean.getAllow_disp_record_lock_yn();

							if(allow_disp_record_lock_yn.equals("Y")){
								lock_status=bean.getLockStatus(patient_id,disp_locn_code,login_user,disp_stage);
								ArrayList AccessRight=bean.getAccessRightStatus(login_user,patient_id,disp_locn_code,disp_stage);
					//commented during PE By Naveen
							   // Unlock_all_records_yn=bean.getUnLockRecordsYN(login_user,disp_locn_code);
								Unlock_all_records_yn=bean.geuUnlockAllRecordsYN();

								if(AccessRight.size()>0){
									for(int j=0; j<AccessRight.size(); j++){
										AccessRightMap = (HashMap)AccessRight.get(j);
										user_id = (String)AccessRightMap.get("user_id");
										locked_date_time = (String)AccessRightMap.get("locked_date_time");
									}
								}	 		    
							}
							else if(allow_disp_record_lock_yn.equals("N")){
								lock_status="0";
							}
	
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(sPriorityImg));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(ord_loc)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allow_disp_record_lock_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+14)));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(lock_status));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(allow_disp_record_lock_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(ord_loc)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf("S"+result.get(i+1)));
            _bw.write(_wl_block287Bytes, _wl_block287);
								//added for GHL-CRF-0453 - start
									if(printValueForOrders!=null && printValueForOrders.size()>0)
										{
											print_value = "";
												print_spilt = (String)printValueForOrders.get(patient_id);//8/2/2017 GHL-CRF-0453
												if(print_spilt!=null){//GHL-CRF-0453
													min_value = ((String)printValueForOrders.get(patient_id)).split("~")[0];
													max_value = ((String)printValueForOrders.get(patient_id)).split("~")[1];
												}
												if(Integer.parseInt(max_value)==1)
													print_value = "1";
												
											//	System.err.println("min_value=339=>"+min_value+"==max_value==>"+max_value);
												if(Integer.parseInt(min_value)!=Integer.parseInt(max_value))
													print_msg = "P";

												if(Integer.parseInt(min_value)!=0 && Integer.parseInt(min_value)==Integer.parseInt(max_value))
													print_msg = "F";

										//	System.err.println("DispMedicationPatientIDDisplay.jsp===print_msg=====346====>"+print_msg);
										}
	
            _bw.write(_wl_block288Bytes, _wl_block288);
								if(disp_stage.equals("F") || disp_stage.equals("A")){	//Added for IN:065140	
										if(print_value.equals("1")){
											if(print_msg.equals("F")){
	
            _bw.write(_wl_block289Bytes, _wl_block289);
											}else{ 
            _bw.write(_wl_block290Bytes, _wl_block290);
											}
										}
										}//added for GHL-CRF-0453 - end
	
            _bw.write(_wl_block291Bytes, _wl_block291);

									if(lock_status.equals("1")){
										if(Unlock_all_records_yn.equals("Y")){
	
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locked_date_time));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(Unlock_all_records_yn));
            _bw.write(_wl_block293Bytes, _wl_block293);

										}
										else if(Unlock_all_records_yn.equals("N")){
	
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locked_date_time));
            _bw.write(_wl_block241Bytes, _wl_block241);
}
									   }
									   else if(lock_status.equals("0")||lock_status.equals("")){
	
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block294Bytes, _wl_block294);

									   }
	
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(lock_status));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)result.get(i+12),"DMYHM","en",locale)));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block300Bytes, _wl_block300);
 
								   if( ((String)result.get(i+7)).equals("M"))
										gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
									else if( ((String)result.get(i+7)).equals("F"))
										gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
									if( ((String)result.get(i+7)).equals("U"))
										gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
	
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block300Bytes, _wl_block300);
  
	 							//Added for ML-MMOH-SCF-1904
	 							
									String pat_id=result.get(i+1)==null?"":(String)result.get(i+1);
									String enc_id=result.get(i+16)==null?"":(String)result.get(i+16);
									
									String locn_desc = bean.getPatientLocation(pat_id, enc_id);
									
								
									if(site){
										if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
	
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(locn_desc));
            _bw.write(_wl_block302Bytes, _wl_block302);

										}
									}
									else{
										if((bean.getGroupByOrdLocn()).equals("N")&&!scope.equals("EX")){
	
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i)));
            _bw.write(_wl_block303Bytes, _wl_block303);

										}
									} //Modified for ML-MMOH-SCF-1904 -END
	
            _bw.write(_wl_block304Bytes, _wl_block304);
 if(  !((String) bean.getFillList()).equals("AF")){ //if  condtion is add for Ip with fill
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(result.get(i+18)));
            _bw.write(_wl_block306Bytes, _wl_block306);
}
	                             if(bean.getDisp_locn_iae().contains("@@@")){ //Added  by Himanshu For MMS-DM-CRF-0232 
									 
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(dispname));
            _bw.write(_wl_block251Bytes, _wl_block251);
} 
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(ord_loc));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block310Bytes, _wl_block310);

									//String next_appt_days =bean.CheckForAppointments((String)result.get(i+1));
	
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+5)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(i+8)));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)result.get(i+1)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode((String)result.get(i+2),"UTF-8")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+7)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+6)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(java.net.URLEncoder.encode(ord_loc)));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(result.get(i+3)));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block317Bytes, _wl_block317);

										//if(!next_appt_days.equals("")){
	
            _bw.write(_wl_block318Bytes, _wl_block318);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(getDate_plus_365));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block320Bytes, _wl_block320);

										//} &nbsp;(<%/*=next_appt_days%*/>)
										if(  !((String) bean.getFillList()).equals("AF")){//if  condtion is add for Ip with fill
										bed_no = (String)result.get(i+18)==null?"":(String)result.get(i+18); }// Added for KDAH-CRF-0338 
	
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(result.get(i+14)));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+15)));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+16)));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+17)));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(desp_name_code));
            _bw.write(_wl_block323Bytes, _wl_block323);
 if(  !((String) bean.getFillList()).equals("AF")){ 
									
									
									//if  condtion is add for Ip with fill 
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block270Bytes, _wl_block270);
 if(bean.getDisp_locn_iae().contains("@@@")){ //modified  by Himanshu For MMS-DM-CRF-0232 starts
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+20)));
            _bw.write(_wl_block324Bytes, _wl_block324);
 }else{ 
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+19)));
            _bw.write(_wl_block272Bytes, _wl_block272);
                     }
								}else{
		//else added for MMS-ME-SCF-001
		
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(result.get(i+18)));
            _bw.write(_wl_block273Bytes, _wl_block273);
                          }
								recCount++;
							}
						
					}

            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(disp_locn_catg));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(bean.getUserPrintYN()));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(bean.getOrderType()));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(bean.getSFunctionId()));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(criteria_patient_id));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(tmp_recCount));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(tab_based_group_sort_disp));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(ptindex));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(relflag));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(refresh_pat_details));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(ph_print_prescription));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(maxDisplay));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(maxDisplay1));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(searchThreshold));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(Hit));
            _bw.write(_wl_block343Bytes, _wl_block343);

	if((result.size()==9 && disp_locn_catg.equals("O"))){

            _bw.write(_wl_block344Bytes, _wl_block344);

	}
	else if((result.size()==9 && disp_locn_catg.equals("I"))){

            _bw.write(_wl_block345Bytes, _wl_block345);

	}

	if(criteria_patient_id!=null && !criteria_patient_id.equals("") && recCount>0 ){

            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(criteria_patient_id));
            _bw.write(_wl_block347Bytes, _wl_block347);

	}

            _bw.write(_wl_block348Bytes, _wl_block348);

		if(!order_id.equals("")){ //Added for JD-CRF-0181[IN045511]

            _bw.write(_wl_block349Bytes, _wl_block349);

		}

            _bw.write(_wl_block350Bytes, _wl_block350);

		}
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{ //CRF-413.8
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Orders.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hrs.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Orders.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hrs.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.UserLocked.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RegisterDateTime.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PatientArrived.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ReleaseDateTime.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.No.OfOrders.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingLocation.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingLocation.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DischargeMedications.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Outpatients.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.callQmsToken.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrintPrescription.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrintPrescription.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.APPOINTMENTLIST.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.callQmsToken.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.callQmsToken.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrintPrescription.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrintPrescription.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.APPOINTMENTLIST.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.callQmsToken.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.APPOINTMENTLIST.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.APPOINTMENTLIST.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }
}
