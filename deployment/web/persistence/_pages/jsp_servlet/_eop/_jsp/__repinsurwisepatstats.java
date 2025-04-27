package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __repinsurwisepatstats extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/repInsurWisePatStats.jsp", 1720530385235L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\nfunction fnExportToExcel(){  \n\tvar isProceed\t= false;\t\n\tvar fields = new Array ( document.reportInsWisePatStatsform.p_from_date,document.reportInsWisePatStatsform.p_to_date);\n\tvar visitDate=getLabel(\"eOP.VisitAdmDate.label\",\"op\");\n\tvar names = new Array(getLabel(\"Common.from.label\",\"Common\")+\" \"+visitDate,getLabel(\"Common.to.label\",\"Common\")+\" \"+visitDate);\n\tif(checkFields( fields, names, parent.frames[2])) \n\t\t{\n\t\t\t if(chkGrtr(document.reportInsWisePatStatsform.p_from_date,\n\t\t\t\t\tdocument.reportInsWisePatStatsform.p_to_date)==true)\n\t\t\t\t{\n\t\t\t\t if(CheckString(getLabel(\"Common.speciality.label\",\"Common\")+\" \"+getLabel(\"Common.code.label\",\"Common\"),document.forms[0].p_fm_specialty_code,document.forms[0].p_to_specialty_code,parent.frames[2]))\n\t\t\t\t if(CheckString(getLabel(\"Common.locationcode.label\",\"Common\"),document.forms[0].p_fm_locn_code,document.forms[0].p_to_locn_code,parent.frames[2]))\n\t\t\t\t if(CheckString(getLabel(\"Common.NursingUnitCode.label\",\"Common\"),document.forms[0].p_fm_nursing_code,document.forms[0].p_to_nursing_code,parent.frames[2]))\n\t\t\t\t if(CheckString(getLabel(\"Common.practitionerid.label\",\"Common\"),document.forms[0].p_from_pract_id,document.forms[0].p_to_pract_id,parent.frames[2]))\n\t\t\t\t if(CheckString(getLabel(\"Common.BillingGroup.label\",\"Common\"),document.forms[0].p_from_bl_grp_id,document.forms[0].p_to_bl_grp_id,parent.frames[2]))\n\t\t\t\t if(CheckString(getLabel(\"Common.BillingGroup.label\",\"Common\"),document.forms[0].p_from_bl_grp_id,document.forms[0].p_to_bl_grp_id,parent.frames[2]))\n\t\t\t\t if(CheckString(getLabel(\"Common.Customer.label\",\"Common\")+\" \"+getLabel(\"Common.GroupCode.label\",\"Common\"),document.forms[0].p_from_cust_grp_code,document.forms[0].p_to_cust_grp_code,parent.frames[2]))\n\t\t\t\t if(CheckString(getLabel(\"Common.CustomerCode.label\",\"Common\"),document.forms[0].p_from_cust_code,document.forms[0].p_to_cust_code,parent.frames[2]))\n\t\t\t\t\tisProceed\t= true;\n\t\t\t\t}\n\t\t}\n\n\n\t\tif(isProceed==true){\n\t\t\tvar visitAdmDateFrom\t\t= document.forms[0].p_from_date.value;            \n\t\t\tvar visitAdmDateTo\t\t\t= document.forms[0].p_to_date.value;              \n\t\t\tvar episodeType\t\t\t\t= document.forms[0].p_patient_class.value;        \n\t\t\tvar specialityFrom\t\t\t= document.forms[0].p_fm_specialty_code.value;        \n\t\t\tvar specialityTo\t\t\t= document.forms[0].p_to_specialty_code.value;    \n\t\t\tvar locationCodeFrom\t\t= document.forms[0].p_fm_locn_code.value;         \n\t\t\tvar locationCodeTo\t\t\t= document.forms[0].p_to_locn_code.value;         \n\t\t\tvar nursingUnitCodeFrom\t\t= document.forms[0].p_fm_nursing_code.value;      \n\t\t\tvar nursingUnitCodeTo\t\t= document.forms[0].p_to_nursing_code.value;      \n\t\t\tvar practitionerIdFrom\t\t= document.forms[0].p_from_pract_id.value;        \n\t\t\tvar practitionerIdTo\t\t= document.forms[0].p_to_pract_id.value;          \n\t\t\tvar billingGroupFrom\t\t= document.forms[0].p_from_bl_grp_id.value;       \n\t\t\tvar billingGroupTo\t\t\t= document.forms[0].p_to_bl_grp_id.value;         \n\t\t\tvar customerGroupFrom\t\t= document.forms[0].p_from_cust_grp_code.value;   \n\t\t\tvar customerGroupTo\t\t\t= document.forms[0].p_to_cust_grp_code.value;     \n\t\t\tvar customerCodeFrom\t\t= document.forms[0].p_from_cust_code.value;   \n\t\t\tvar customerCodeTo\t\t\t= document.forms[0].p_to_cust_code.value;     \n\t\t\tvar policyType\t\t\t\t= document.forms[0].p_policy_type_code.value;     \n\t\t\tvar policyNo\t\t\t\t= document.forms[0].p_policy_number.value;        \n\t\t\tvar patientId\t\t\t\t= document.forms[0].p_patient_id.value;           \n\t\t\tvar orderBy\t\t\t\t\t= document.forms[0].p_order_by.value;   \n\t\t\t\n\t\t\tvar orderByTxt\t\t\t\t= document.forms[0].p_order_by.options[document.forms[0].p_order_by.selectedIndex].innerHTML;\n\t\t\tvar episodeTypeTxt\t\t\t= document.forms[0].p_patient_class.options[document.forms[0].p_patient_class.selectedIndex].innerHTML;\n\t\t\t\n\t\t\n\n\t\t\t\t\n\t\t\t\t/*var HTMLVal\t= \"\";\n\t\t\t\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'get\' action=\'../../servlet/eOP.repInsuranceWisePatientVisitStatServlet\'><input type=\'hidden\' name=\'visitAdmDateFrom\' id=\'visitAdmDateFrom\' value=\\\"\"+visitAdmDateFrom+\"\\\"><input type=\'hidden\' name=\'visitAdmDateTo\' id=\'visitAdmDateTo\' value=\\\"\"+visitAdmDateTo+\"\\\"><input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' value=\\\"\"+episodeType+\"\\\"><input type=\'hidden\' name=\'specialityFrom\' id=\'specialityFrom\' value=\\\"\"+specialityFrom+\"\\\"><input type=\'hidden\' name=\'specialityTo\' id=\'specialityTo\' value=\\\"\"+specialityTo+\"\\\"><input type=\'hidden\' name=\'locationCodeFrom\' id=\'locationCodeFrom\' value=\\\"\"+locationCodeFrom+\"\\\"><input type=\'hidden\' name=\'locationCodeTo\' id=\'locationCodeTo\' value=\\\"\"+locationCodeTo+\"\\\"><input type=\'hidden\' name=\'nursingUnitCodeFrom\' id=\'nursingUnitCodeFrom\' value=\\\"\"+nursingUnitCodeFrom+\"\\\"><input type=\'hidden\' name=\'nursingUnitCodeTo\' id=\'nursingUnitCodeTo\' value=\\\"\"+nursingUnitCodeTo+\"\\\"><input type=\'hidden\' name=\'practitionerIdFrom\' id=\'practitionerIdFrom\' value=\\\"\"+practitionerIdFrom+\"\\\"><input type=\'hidden\' name=\'practitionerIdTo\' id=\'practitionerIdTo\' value=\\\"\"+practitionerIdTo+\"\\\"><input type=\'hidden\' name=\'billingGroupFrom\' id=\'billingGroupFrom\' value=\\\"\"+billingGroupFrom+\"\\\"><input type=\'hidden\' name=\'billingGroupTo\' id=\'billingGroupTo\' value=\\\"\"+billingGroupTo+\"\\\"><input type=\'hidden\' name=\'customerGroupFrom\' id=\'customerGroupFrom\' value=\\\"\"+customerGroupFrom+\"\\\"><input type=\'hidden\' name=\'customerGroupTo\' id=\'customerGroupTo\' value=\\\"\"+customerGroupTo+\"\\\"><input type=\'hidden\' name=\'customerCodeFrom\' id=\'customerCodeFrom\' value=\\\"\"+customerCodeFrom+\"\\\"><input type=\'hidden\' name=\'customerCodeTo\' id=\'customerCodeTo\' value=\\\"\"+customerCodeTo+\"\\\"><input type=\'hidden\' name=\'policyType\' id=\'policyType\' value=\\\"\"+policyType+\"\\\"><input type=\'hidden\' name=\'policyNo\' id=\'policyNo\' value=\\\"\"+policyNo+\"\\\"><input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\\\"\"+patientId+\"\\\"><input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\\\"\"+orderBy+\"\\\"><input type=\'hidden\' name=\'orderByTxt\' id=\'orderByTxt\' value=\\\"\"+orderByTxt+\"\\\"><input type=\'hidden\' name=\'episodeTypeTxt\' id=\'episodeTypeTxt\' value=\\\"\"+episodeTypeTxt+\"\\\"></form></body></html>\";  \n\t\t\t\t\n\t\t\t\tparent.frames[2].location.href = \"../../eCommon/jsp/error.jsp\";\n\t\t\t\tparent.frames[3].document.innerHTML\t= \"\";\n\t\t\t\tparent.frames[3].document.write(\"\");\n\t\t\t\tparent.frames[3].document.write(HTMLVal);\n\t\t\t\tparent.frames[3].document.form1.submit();*/\n\n\n\t\t\t\tparent.frames[1].document.forms[0].method\t= \"POST\";\n\t\t\t\tparent.frames[1].document.forms[0].action\t=\'../../servlet/eOP.repInsuranceWisePatientVisitStatServlet?visitAdmDateFrom=\'+visitAdmDateFrom+\'&visitAdmDateTo=\'+visitAdmDateTo+\'&episodeType=\'+episodeType+\'&specialityFrom=\'+specialityFrom+\'&specialityTo=\'+specialityTo+\'&locationCodeFrom=\'+locationCodeFrom+\'&locationCodeTo=\'+locationCodeTo+\'&nursingUnitCodeFrom=\'+nursingUnitCodeFrom+\'&nursingUnitCodeTo=\'+nursingUnitCodeTo+\'&practitionerIdFrom=\'+practitionerIdFrom+\'&practitionerIdTo=\'+practitionerIdTo+\'&billingGroupFrom=\'+billingGroupFrom+\'&billingGroupTo=\'+billingGroupTo+\'&customerGroupFrom=\'+customerGroupFrom+\'&customerGroupTo=\'+customerGroupTo+\'&customerCodeFrom=\'+customerCodeFrom+\'&customerCodeTo=\'+customerCodeTo+\'&policyType=\'+policyType+\'&policyNo=\'+policyNo+\'&patientId=\'+patientId+\'&orderBy=\'+orderBy+\'&orderByTxt=\'+orderByTxt+\'&episodeTypeTxt=\'+episodeTypeTxt;\n\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t\n\t\t}\n\n}\nfunction chkGrtr(obj1,obj2)\n{\n\t\t\n\t\tif(isBefore(obj1.value,obj2.value,\"DMYHM\",localeName)==false)\n\t\t{\n\t\t\tvar error=getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\");\n\t\t\tparent.frames[2].location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error ;\n            return false;\n\t\t}\n\t\telse \n\t\t\treturn true;\n}\n\tasync function getPatID()\n\t{\t\t\t\t\t  \n\t\tvar pat_id=await PatientSearch();\n\t\tif( pat_id != null )\t\t\t\t\t\t\n\t\t\tdocument.forms[0].p_patient_id.value = pat_id ;\t\t\t\t\t\n\t}\n\n\tfunction searchCode1(obj,target)\n\t{\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"28\" ;\n\t\tvar dialogWidth\t= \"43\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar sql=\"\";\n\t\tvar search_code=\"\";\n\t\tvar search_desc=\"\";\n\t\tvar tit=\"\";\n\t\tvar locale= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\";\n\t\tvar p_facility_id =document.forms[0].p_facility_id.value;\n\t\tvar argumentArray  = new Array();\n\t\tvar dataNameArray  = new Array();\n\t\tvar dataValueArray = new Array();\n\t\tvar dataTypeArray  = new Array();\n\t\tvar p_patient_class = document.forms[0].p_patient_class.value;\n\n\t\tif(obj.name==\"frmSpeciality\"||obj.name==\"toSpeciality\")\n\t\t{\n\t\t\ttit=getLabel(\'Common.speciality.label\',\'common\');\n\n\t\t\targumentArray[0]=\"select speciality_code code, short_desc description from am_speciality_lang_vw where language_id=\'\"+locale+\"\' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?)\";\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = CODE_LINK;\n\t\t\targumentArray[7] = CODE_DESC;\n\t\t}\n\t\tif(obj.name==\"fromlocn\" || obj.name==\"tolocn\")\n\t\t{\n\t\t\ttit=getLabel(\"Common.locationcode.label\",\"Common\");\n\n\t\t\tif(p_patient_class==\'OP\')\n\t\t\t{\n\t\t\t\targumentArray[0]=\"select clinic_code code, long_desc description from op_clinic_lang_vw where language_id=\'\"+locale+\"\' and facility_id =\'\"+p_facility_id+\"\' and clinic_type IN (\'C\',\'E\') and LEVEL_OF_CARE_IND = \'A\' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) \";\n\t\t\t}\n\t\t\telse if(p_patient_class==\'EM\')\n\t\t\t{\n\t\t\t\targumentArray[0]=\"select clinic_code code, long_desc description  from op_clinic_lang_vw where language_id=\'\"+locale+\"\' and facility_id  =\'\"+p_facility_id+\"\' and clinic_type =\'C\' and LEVEL_OF_CARE_IND = \'E\' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)\";\n\t\t\t}\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = CODE_LINK;\n\t\t\targumentArray[7] = CODE_DESC;\n\t\t}\n\n\t\tif(obj.name==\"frmnursing_unit_code\"||obj.name==\"tonursing_unit_code\")\n\t\t{\n\t\t\ttit=getLabel(\'Common.NursingUnitCode.label\',\'common\');\n\t\t\t\n\t\t\targumentArray[0]=\"select nursing_unit_code code, short_desc description from ip_nursing_unit_lang_vw where facility_id=\'\"+p_facility_id+\"\' and patient_class=\'\"+p_patient_class+\"\' and language_id=\'\"+locale+\"\' and upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?)\";\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = CODE_LINK;\n\t\t\targumentArray[7] = CODE_DESC;\n\t\t}\n\t\tif(obj.name==\"practitioner_id2\" || obj.name==\"practitioner_id1\")\n\t\t{\n\t\t\ttit=getLabel(\'Common.practitioner.label\',\'common\')\n\n\t\t\targumentArray[0]  = \"select a.Practitioner_id  code,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,\'\"+locale+\"\', \'1\') description  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where b.FACILITY_ID=\'\"+p_facility_id+\"\' AND a.Practitioner_id=b.Practitioner_id and upper(a.Practitioner_id) like upper(?) and upper(a.Practitioner_id) like upper(?)\";\n\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = CODE_LINK;\n\t\t\targumentArray[7] = CODE_DESC;\n\t\t}\n\n\t\tif(obj.name==\"billing_group\"){\n\t\t\ttit=getLabel(\'Common.BillingGroup.label\',\'common\');\n\t\t\targumentArray[0]=\"select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where  language_id=\'\"+locale+\"\' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?)\";\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = CODE_LINK;\n\t\t\targumentArray[7] = CODE_DESC;\n\t\t}\n\t\tif(obj.name==\"cust_grp_code\"){\n\n\t\t\ttit=getLabel(\'Common.Customer.label\',\'common\')+\' \'+getLabel(\'Common.GroupCode.label\',\'common\');\n\t\t\targumentArray[0]=\"select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id=\'\"+locale+\"\' and (cust_group_code) like upper(nvl(?,cust_group_code)) and upper(short_desc) like upper(nvl(?,short_desc)) \";\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = CODE_LINK;\n\t\t\targumentArray[7] = CODE_DESC;\n\n\t\t}\n\n\t\tif(obj.name==\"cust_code\"){\n\t\t\ttit=getLabel(\'Common.CustomerCode.label\',\'common\');\n\t\t\tvar group_id\t= \"\";\n\t\t\tif(target.name==\"p_from_cust_code\"){\n\t\t\t\tgroup_id\t= document.forms[0].p_from_cust_grp_code.value;\n\t\t\t}else{\n\t\t\t\tgroup_id\t= document.forms[0].p_to_cust_grp_code.value;\n\t\t\t}\n\t\t\tif(group_id==\"\"){\n\t\t\t\targumentArray[0]=\"select cust_code code, long_name description from ar_customer_lang_vw where \'1\' like ? and language_id=\'\"+locale+\"\' and upper(cust_code) like upper(nvl(?,cust_code)) and upper(long_name) like upper(nvl(?,long_name)) order by 2 \";\n\t\t\t}else{ \n\t\t\t\targumentArray[0]=\"select code,description from (SELECT a.cust_code code, a.long_name description FROM ar_customer_lang_vw a,ar_cust_group_lang_vw b, bl_cust_by_cust_group d  WHERE a.acc_entity_code =  b.acc_entity_code AND b.acc_entity_code =d.acc_entity_code AND a.language_id = b.language_id AND b.cust_group_code = d.cust_group_code AND a.cust_group_code = b.cust_group_code AND a.cust_code = d.cust_code AND b.cust_group_code = \'\"+group_id+\"\' AND a.language_id = \'\"+locale+\"\' AND a.acc_entity_code IN (SELECT d.acc_entity_code FROM sy_acc_entity d  WHERE acc_entity_id = d.acc_entity_id) ) where 1 like ? and UPPER (code) LIKE UPPER (NVL (?, code)) AND UPPER (description) LIKE UPPER (NVL (?, description)) ORDER BY 2\"; \n\t\t\t}\t\n\t\t\targumentArray[1]=new Array(\"1\");\n\t\t\targumentArray[2]=new Array(\"1\");\n\t\t\targumentArray[3]=new Array(STRING);\n\t\t\targumentArray[4]=\"2,3\";\n\t\t\targumentArray[5]=target.value;\n\t\t\targumentArray[6]=CODE_DESC_LINK;\n\t\t\targumentArray[7]=CODE_DESC; \n\t\t}\n\t\tif(obj.name==\"p_policy_type\"){\n\t\t\ttit=getLabel(\'eBL.POLICY_TYPE.label\',\'bl\');\n\t\t\targumentArray[0] =\"SELECT policy_type_code code, short_desc description FROM bl_ins_policy_types_lang_vw  where language_id = \'\"+locale+\"\' and upper(policy_type_code) like upper(?) and upper(short_desc) like upper(?)\";\n\n\t\t\targumentArray[1] = dataNameArray ;\n\t\t\targumentArray[2] = dataValueArray ;\n\t\t\targumentArray[3] = dataTypeArray ;\n\t\t\targumentArray[4] = \"1,2\";\n\t\t\targumentArray[5] = target.value;\n\t\t\targumentArray[6] = CODE_LINK;\n\t\t\targumentArray[7] = CODE_DESC;\n\t\t}\n\n\t\tretVal = await CommonLookup( tit, argumentArray ) ;\n\n\t\tif(retVal != null && retVal != \"\" )\n\t\t{\n\t\t\tvar ret1=unescape(retVal);\n\t\t\tarr=ret1.split(\",\");\n\t\t\ttarget.value=arr[0];\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttarget.value=\'\';\n\t\t}\n\t}\n\n/*\tfunction setValue()\n\t{\n\n\t\tif ( document.forms[0].sum_id.checked == true)\n\t\t{\n\t\t\tdocument.forms[0].p_sum_yn.value=\"Y\";\t\t\t \n\t\t}              \n\t\tif ( document.forms[0].detail_id.checked == true)\n\t\t{\n\t\t\tdocument.forms[0].p_sum_yn.value=\"N\";\n\t\t}           \n\t}*/\n\n\tfunction setDate(Object){ \n\n\t\tif(Object.value!=\"\")\n\t\t{\n\t\t\tif(!validDateObjforAdm(Object.value,\'DMYHM\',localeName))\n\t\t\t{\n\t\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\'SM\'));\n\t\t\t\tObject.select();\n\t\t\t}else {\n\t\t\t\tif (isBeforeNow(Object.value,\"DMYHM\",localeName))\n\t\t\t\t{\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"DATE_LESS_EQL_SYS_DATE\",\'FM\'));\n\t\t\t\t\tObject.value=\"\";\n\t\t\t\t\tObject.focus();            \n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\tfunction disablefields()\n\t{\n\t\tif(document.forms[0].p_patient_class.value==\"ALL\"){\n\t\t\tdocument.forms[0].p_fm_locn_code.disabled=true;\n\t\t\tdocument.forms[0].fromlocn.disabled=true;\n\t\t\tdocument.forms[0].p_to_locn_code.disabled=true;\n\t\t\tdocument.forms[0].tolocn.disabled=true;\n\t\t\tdocument.forms[0].p_fm_nursing_code.disabled=true;\n\t\t\tdocument.forms[0].p_to_nursing_code.disabled=true;\n\t\t\tdocument.forms[0].frmnursing_unit_code.disabled=true;\n\t\t\tdocument.forms[0].tonursing_unit_code.disabled=true;\n\t\t\t\n\t\t\t\n\t\t}\n\n\t\tif(document.forms[0].p_patient_class.value==\"IP\" || document.forms[0].p_patient_class.value==\"DC\"){\n\t\t\tdocument.forms[0].p_fm_locn_code.disabled=true;\n\t\t\tdocument.forms[0].fromlocn.disabled=true;\n\t\t\tdocument.forms[0].p_to_locn_code.disabled=true;\n\t\t\tdocument.forms[0].tolocn.disabled=true;\n\t\t\t\n\t\t\tdocument.forms[0].p_fm_nursing_code.disabled=false;\n\t\t\tdocument.forms[0].p_to_nursing_code.disabled=false;\n\t\t\tdocument.forms[0].frmnursing_unit_code.disabled=false;\n\t\t\tdocument.forms[0].tonursing_unit_code.disabled=false;\n\n\t\t\t\n\n\t\t}\n\t\tif(document.forms[0].p_patient_class.value==\"OP\" || document.forms[0].p_patient_class.value==\"EM\"){\n\t\t\tdocument.forms[0].p_fm_nursing_code.disabled=true;\n\t\t\tdocument.forms[0].p_to_nursing_code.disabled=true;\n\t\t\tdocument.forms[0].frmnursing_unit_code.disabled=true;\n\t\t\tdocument.forms[0].tonursing_unit_code.disabled=true;\n\t\t\t\n\t\t\tdocument.forms[0].p_fm_locn_code.disabled=false;\n\t\t\tdocument.forms[0].fromlocn.disabled=false;\n\t\t\tdocument.forms[0].p_to_locn_code.disabled=false;\n\t\t\tdocument.forms[0].tolocn.disabled=false;\n\n\t\t}\n\n\t\tdocument.forms[0].p_fm_locn_code.value=\'\';\n\t\tdocument.forms[0].p_to_locn_code.value=\'\';\n\t\tdocument.forms[0].p_fm_nursing_code.value=\'\';\n\t\tdocument.forms[0].p_to_nursing_code.value=\'\';\n\t\tdocument.forms[0].p_fm_specialty_code.value=\'\';\n\t\tdocument.forms[0].p_to_specialty_code.value=\'\';\n\n\t}\n\tfunction validDateObjforAdm(Object3){\n\n\t\tvar checkFlag= true ;\n\t\tvar strDate;\n\t\tvar strDay;\n\t\tvar strMonth;\n\t\tvar strYear;\n\n\t\tvar dateArray1=Object3.split(\" \");\n\t\tvar\tdateArray=(dateArray1[0]).split(\"/\");\n\t\tvar time1arr=dateArray1[1].split(\":\")\n\t\tif(time1arr.length==2)\n\t\t{\n\t\t\tvar time1hr=time1arr[0]\n\t\t\tvar time1min=time1arr[1]\n\n\t\t\tif(time1hr < 0 && time1hr >24 && time1min < 00 && time1min > 59)\n\t\t\t{\n\t\t\t\tcheckFlag=false;\n\t\t\t}\n\n\t\t\tif (time1hr.length != 2 || time1min.length != 2)\n\t\t\t{\n\t\t\t\tcheckFlag=false;\n\t\t\t}\n\t\t}\n\t\tvar strDateArray = new Array();\n\n\n\t\tif (dateArray.length == 0) checkFlag= true;\n\n\n\t\tstrDateArray = dateArray;\n\t\tif (strDateArray.length != 3) {\n\t\t\tcheckFlag= false;\n\t\t}\n\t\telse {\n\t\t\tstrDay = trimString(strDateArray[0]);\n\t\t\tstrMonth = trimString(strDateArray[1]);\n\t\t\tstrYear = trimString(strDateArray[2]);\n\t\t}\n\n\n\t\tif (strYear.length < 4 || strYear.length > 4) checkFlag= false;\n\t\tif (strMonth.length != 2) checkFlag= false;\n\t\tif (strDay.length != 2) checkFlag= false;\n\n\t\tif (isNaN(strDay)==true) checkFlag= false;\n\t\tif (isNaN(strMonth)==true) checkFlag = false;\n\t\tif (isNaN(strYear)==true) checkFlag= false;\n\n\t\tif (strYear < 1800) checkFlag = false;\n\n\t\tif (strMonth>12 || strMonth<1)  checkFlag = false;\n\n\t\tif ((strMonth == 01 || strMonth == 03 || strMonth == 05 || strMonth == 07 || strMonth == 08 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) checkFlag = false;\n\n\t\tif ((strMonth == 04 || strMonth == 06 |";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="| strMonth == 09 || strMonth == 11) && (strDay > 30 || strDay < 01)) checkFlag = false;\n\n\t\tif (strMonth == 02) {\n\t\t\tif (strDay < 01) checkFlag = false;\n\n\t\t\tif (LeapYear(strYear) == true) {\n\t\t\t\tif (strDay > 29) checkFlag = false;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tif (strDay > 28) checkFlag = false;\n\t\t\t}\n\t\t}\n\t\treturn checkFlag;\n\t}\n\n</script>\n<body onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\' onload=\'disablefields();\'>\n\t<center>\n\t\t<form name=\"reportInsWisePatStatsform\" id=\"reportInsWisePatStatsform\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n\t\t\t<BR>\n\t\t\t\t<table width=\'80%\' align=\'center\' valign=\'top\'>\n\t\t\t\t\t<th class=\'columnheader\' align=\"left\" width=\'100%\'>";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t</table>   \n\t\t\t\t<table width=\'80%\' cellPadding=\"2\" cellSpacing=\"0\"  align=\'center\' border=\'0\'>        \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td >&nbsp;</td>\n\t\t\t\t\t\t<td class=\"querydata\" style=\"font-weight: bold;\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;</td>\n\t\t\t\t\t\t<td class=\"querydata\" style=\"font-weight: bold;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\n\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t<td class=\'fields\'><input type=text id=\'p_from_date\'  name=\'p_from_date\' id=\'p_from_date\' size=\"16\" maxlength=\"16\" align=\"left\" onBlur=\'if(validDateObj(this,\"DMYHM\",localeName)){setDate(this)};\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'p_from_date\',null,\'hh:mm\');\" style=\"cursor=\'hand\'\"></img><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\t\n\t\t\t\t\t\t<td class=\'fields\'><input type=text id=\'p_to_date\'  name=\'p_to_date\' id=\'p_to_date\' size=\"16\" maxlength=\"16\" align=\"left\" onBlur=\'if(validDateObj(this,\"DMYHM\",localeName)){setDate(this)};\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'p_to_date\',null,\'hh:mm\');\" style=\"cursor=\'hand\'\"></img><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr> \n\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'fields\'><select name=\"p_patient_class\" id=\"p_patient_class\" onchange=\'disablefields();\'>\n\t\t\t\t\t\t<option value=\'ALL\' selected>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t\t\t\t\t<option value=\"OP\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<option value=\"EM\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t<option value=\"IP\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"DC\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t\t\t\t</tr>  \n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td align=\'right\'  class=\"label\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" &nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_fm_specialty_code\' id=\'p_fm_specialty_code\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'frmSpeciality\' id=\'frmSpeciality\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_fm_specialty_code)\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'> \n\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_to_specialty_code\' id=\'p_to_specialty_code\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'toSpeciality\' id=\'toSpeciality\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_to_specialty_code)\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr class=\'fields\'>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"p_fm_locn_code\" id=\"p_fm_locn_code\" size=\"4\" maxlength=\"4\" ><input type=\'button\' name=\'fromlocn\' id=\'fromlocn\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_fm_locn_code)\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\'fields\'><input type=\"text\" name=\"p_to_locn_code\" id=\"p_to_locn_code\" size=\"4\" maxlength=\"4\"><input type=\'button\' name=\'tolocn\' id=\'tolocn\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_to_locn_code)\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" &nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\'40%\'  >\n\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_fm_nursing_code\' id=\'p_fm_nursing_code\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'frmnursing_unit_code\' id=\'frmnursing_unit_code\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_fm_nursing_code)\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\'30%\'> \n\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_to_nursing_code\' id=\'p_to_nursing_code\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'tonursing_unit_code\' id=\'tonursing_unit_code\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_to_nursing_code)\'>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" &nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\'40%\'  >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_from_pract_id\' id=\'p_from_pract_id\' size=\"15\" maxlength=\"15\" align=\"center\"><input type=\'button\' name=\'practitioner_id1\' id=\'practitioner_id1\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_from_pract_id)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\'30%\'> \n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_to_pract_id\' id=\'p_to_pract_id\' size=\"15\" maxlength=\"15\" align=\"center\"><input type=\'button\' name=\'practitioner_id2\' id=\'practitioner_id2\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_to_pract_id)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'20%\'  >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_from_bl_grp_id\' id=\'p_from_bl_grp_id\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'billing_group\' id=\'billing_group\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_from_bl_grp_id)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'40%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_to_bl_grp_id\' id=\'p_to_bl_grp_id\' size=\"4\" maxlength=\"4\" align=\"center\"><input type=\'button\' name=\'billing_group\' id=\'billing_group\' value=\'?\' class=\'button\' onclick=\'searchCode1(this,  p_to_bl_grp_id)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'20%\'  >\n\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_from_cust_grp_code\' id=\'p_from_cust_grp_code\' size=\"2\" maxlength=\"2\" align=\"center\"><input type=\'button\' name=\'cust_grp_code\' id=\'cust_grp_code\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_from_cust_grp_code)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'40%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_to_cust_grp_code\' id=\'p_to_cust_grp_code\' size=\"2\" maxlength=\"2\" align=\"center\"><input type=\'button\' name=\'cust_grp_code\' id=\'cust_grp_code\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_to_cust_grp_code)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'20%\'  >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_from_cust_code\' id=\'p_from_cust_code\' size=\"8\" maxlength=\"8\" align=\"center\"><input type=\'button\' name=\'cust_code\' id=\'cust_code\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_from_cust_code)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\'40%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_to_cust_code\' id=\'p_to_cust_code\' size=\"8\" maxlength=\"8\" align=\"center\"><input type=\'button\' name=\'cust_code\' id=\'cust_code\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_to_cust_code)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" &nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td width=\'40%\'  >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_policy_type_code\' id=\'p_policy_type_code\' size=\"15\" maxlength=\"15\" align=\"center\"><input type=\'button\' name=\'p_policy_type\' id=\'p_policy_type\' value=\'?\' class=\'button\' onclick=\'searchCode1(this, p_policy_type_code)\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<td  width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\'40%\'  >\n\t\t\t\t\t\t\t\t\t\t\t<input type=text  name=\'p_policy_number\' id=\'p_policy_number\' size=\"30\" maxlength=\"30\" onkeypress=\"return CheckForSpecChars(event);\" align=\"center\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" &nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\'40%\'  >\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\"  name=\"p_patient_id\" id=\"p_patient_id\" align=\"left\" size=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' maxlength=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onBlur=\"ChangeUpperCase(this);\" onkeypress=\"return CheckForSpecChars(event);\"><input type=\"button\" value=\"?\" class=\"button\" name=\'pat_search\' id=\'pat_search\' onClick=\"getPatID()\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\n\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" &nbsp;\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td  width=\'40%\' align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t<select name=\'p_order_by\' id=\'p_order_by\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'1\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'2\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'3\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td align=\'right\' width=\'100%\' class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"export\" id=\"export\" value=\"Export\" onclick=\"return fnExportToExcel();\" />\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\'right\' width=\'30%\' class=\"label\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\'3%\'><input type=\'radio\' id=\'sum_id\' name=\'p_sum_yn\' id=\'p_sum_yn\' value = \'Y\' checked onClick=\"setValue();\"></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\'right\' width=\'5%\' class=\"label\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td><input type=\'radio\' id=\'detail_id\' name=\'p_sum_yn\' id=\'p_sum_yn\' value = \'N\'  onClick=\"setValue();\">  </td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table> -->\n\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"       value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"         value=\"OP\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"         value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"         value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"p_function_id\" id=\"p_function_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"p_function_name\" id=\"p_function_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"p_function_type\" id=\"p_function_type\"\t\tvalue=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</form>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t</center>\n\t\t\t\t\t\t\t\t\t</body>\n\t\t\t\t\t\t\t\t\t</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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

request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

//String p_menu_id=request.getParameter("menu_id");
//String p_module_id      = request.getParameter("module_id");
String p_report_id      = "OPIWPVSR" ;
String p_facility_id    = (String) session.getValue( "facility_id" ) ;
String p_user_name      = (String) session.getValue( "login_user" ) ;
String locale      = (String)session.getAttribute("LOCALE");
String function_id		= request.getParameter("function_id");
String function_name	=  request.getParameter("function_name");
String function_type	=  request.getParameter("function_type");
//String access			=  request.getParameter("access");

Statement stmt=null;
ResultSet rset=null ;
Connection con=null;
//String ID="";
//String dat="";
//String en="";
try{
con=ConnectionManager.getConnection(request); 

//String sql="";
String pid_length="";
stmt = con.createStatement();
String sql4 = "select patient_id_length from mp_param";
rset = stmt.executeQuery(sql4);
if(rset != null){
if(rset.next())
pid_length = rset.getString(1);

}
if(pid_length==null || pid_length.equals(""))
pid_length = "10";
if(rset != null) rset.close();
if(stmt != null) stmt.close();


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pid_length));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(pid_length));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( p_report_id ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( p_user_name ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( function_id ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( function_name ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( function_type ));
            _bw.write(_wl_block45Bytes, _wl_block45);
 }
														catch(Exception e)
														{ out.println(e.toString());}
														finally{
														try{
														if(stmt != null) stmt.close();
														if(rset != null) rset.close();
													}
													catch(Exception e)
													{
													e.printStackTrace();
												}
												if( con !=null ) ConnectionManager.returnConnection(con,request);
											}
											
            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportcritera.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.VisitAdmDate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Outpatient.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatient.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daycare.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationcode.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitCode.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionerid.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GroupCode.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CustomerCode.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_TYPE.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NUM.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.orderBy.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Customer.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Summary.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Detail.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
