package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __nursingobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/NursingObjectCollect.jsp", 1709120258000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script type=\'text/javascript\' src=\'../../eOT/js/OTCommon.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/RecordNursing.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/CommonOperDtlsHdr.js\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script type=\'text/javascript\' src=\'../../eOT/js/CheckOutFromOR.js\'></script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4_0 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\'javascript\'>\n\t\n\nvar personnelrows = new Array();\nvar personnelrowLength=0;\nvar rows = new Array();\nvar rowLength=0;\nvar line_no=0;\n\n\nvar specimen_rows = new Array();\nvar specimen_len=0;\nvar disposal_rows = new Array();\nvar disposal_len=0;\nvar instrument_rows = new Array();\nvar instrument_len=0;\nvar equipment_rows = new Array();\nvar equipment_len = 0;\nvar packs_rows=new Array();\nvar packs_len = 0;\nvar implants_rows = new Array();\nvar implants_len = 0;\nvar time_rows = new Array();\nvar time_len = 0;\nvar visit_pers_rows=new Array();\nvar visit_pers_len=0;\n\n//For Sugery History\nvar diagnosis_rows = new Array();\nvar diagnosis_len = 0;\n//for displaying the rows only one time from db(initially)\nvar db_flag=\"ON\";\nvar splty_code=\"\";\nvar TIME_AND_DETAILS_ENTERED=\"N\";\nvar VISIT_PERSONEL_ENTERED=\"N\";\nvar mandatory_proc=new Array();\n</script>\n\n<script language=\'javascript\'>\nfunction convertDate(date,format,from,to){\n\tvar xhr =  getXHR();\n\tvar url = \"../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format=\"+format+\"&date=\"+date+\"&fromLocale=\"+from+\"&toLocale=\"+to;\n    xhr.open(\"POST\", url, false);\n\txhr.setRequestHeader(\"Content-Type\",\"text/plain\")\n   \txhr.send(\"\");\n\t\n\tvar xmlText =  trimString(xhr.responseText)\n\treturn(xmlText);\n}\n\nfunction getXHR(){\n\tvar request = false;\n\ttry {\n\t\trequest = new XMLHttpRequest();\n\t}catch (trymicrosoft) {\n\t\ttry {\n\t\t\trequest = new ActiveXObject(\"Msxml2.XMLHTTP\");\n\t\t}catch (othermicrosoft) {\n\t\t\ttry {\n\t\t\t\trequest = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\t\t} catch (failed) {\n\t\t\t\trequest = false;\n\t\t\t}\n\t\t}\n    }\n\tif (!request){\n\t\talert(\"System Error initializing XMLHttpRequest!\");\n\t\treturn;\n\t}else return request;\n}\n\n function createXMLForPersonnel(){\n  var rows=parent.ObjectCollect.personnelrows;\n  var table_name=\"OT_POST_OPER_PERSONNEL\";\n  var len = rows.length;\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t if(rows[i]!=null &&  rows[i].db_mode!=\'L\'){\n\t\txmlString+=\"<PER_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+rows[i].speciality_code+\"\\\"\"+\" \";\n\t\txmlString+=\"role_id=\\\"\"+rows[i].role_id+\"\\\"\"+\" \";\n\t\txmlString+=\"role_type=\\\"\"+rows[i].role_type+\"\\\"\"+\" \";\n\t\txmlString+=\"practitioner_id=\\\"\"+rows[i].practitioner_id+\"\\\"\"+\" \";\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t\n\t }\n  }\n  return xmlString;\n}\n\n//Commented by rajesh for Uniue Constraing PK error TH_OT_SPR-3270\n/*function createXMLForVisitPersonnel(){\n  var rows=parent.ObjectCollect.visit_pers_rows;\n  var table_name=\"VISIT_PERSONNEL\";\n  var len = rows.length;\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t if(rows[i]!=null &&  rows[i].db_mode!=\'L\' && rows[i].verify_flag==\"OFF\" ){\n\t\txmlString+=\"<PER_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+rows[i].speciality_code+\"\\\"\"+\" \";\n\t\txmlString+=\"visit_desc=\\\"\"+rows[i].visit_desc+\"\\\"\"+\" \";\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t}\n  }\n  return xmlString;\n}*/\n\n/*function createXMLForVisitPersonnel(){\n  var rows=parent.ObjectCollect.visit_pers_rows;\n  var rows_time=parent.ObjectCollect.time_rows;\n//  var locale=document.forms[0].locale.value;\n//var l=rows_time.length;\n  var table_name=\"VISIT_PERSONNEL\";\n  var len = rows.length;\n //  TIME_AND_DETAILS_ENTERED = (l>0)?\"Y\":\"N\";\n\n // if(TIME_AND_DETAILS_ENTERED==\"Y\") return \"\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t if(rows[i]!=null && rows[i].db_mode!=\'L\'){\n\t\txmlString+=\"<PER_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+rows[i].speciality_code+\"\\\"\"+\" \";\n\t\txmlString+=\"visit_desc=\\\"\"+encodeURIComponent(rows[i].visit_desc,\"UTF-8\")+\"\\\"\"+\" \";\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t}\n  }\n  return xmlString;\n\n}*/\nfunction createXMLForVisitPersonnel(){\n  var rows=parent.ObjectCollect.visit_pers_rows;\n  var rows_time=parent.ObjectCollect.time_rows;\n//  var locale=document.forms[0].locale.value;\n  var l=rows_time.length;\n  var table_name=\"VISIT_PERSONNEL\";\n  var len = rows.length;\n  var locale=document.forms[0].locale.value;\n\n //  TIME_AND_DETAILS_ENTERED = (l>0)?\"Y\":\"N\";\n\n // if(TIME_AND_DETAILS_ENTERED==\"Y\") return \"\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  TIME_AND_DETAILS_ENTERED = (l>0)?\"Y\":\"N\";\n\t if(rows[i]!=null && rows[i].db_mode!=\'L\'){\n\t\txmlString+=\"<PER_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+rows[i].speciality_code+\"\\\"\"+\" \";\n\t\txmlString+=\"visit_desc=\\\"\"+encodeURIComponent(rows[i].visit_desc,\"UTF-8\")+\"\\\"\"+\" \";\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" \";\n\n\t\tif(TIME_AND_DETAILS_ENTERED==\"Y\")\n\t\t {\n\t\txmlString+=\"preparation_time=\\\"\"+convertDate(rows[i].db_preparation_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"procedure_start_time=\\\"\"+convertDate(rows[i].db_procedure_start_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"procedure_end_time=\\\"\"+convertDate(rows[i].db_procedure_end_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"anaesthesia_start_time=\\\"\"+convertDate(rows[i].db_anaesthesia_start_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"anaesthesia_end_time=\\\"\"+convertDate(rows[i].db_anaesthesia_end_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"surgery_start_time=\\\"\"+convertDate(rows[i].db_surgery_start_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"surgery_end_time=\\\"\"+convertDate(rows[i].db_surgery_end_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" />\";\n\t\txmlString+=\"prep_start_time=\\\"\"+convertDate(rows[i].db_prep_start_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" />\";\n\t\txmlString+=\"prep_end_time=\\\"\"+convertDate(rows[i].db_prep_end_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" />\";\n\t\t }\n\t\t else\n\t\t\t xmlString+=\" />\";\n\t}\n\tl--;\n  }\n  return xmlString;\n\n}\n\n function createXMLForInstruments(){\n  var rows=parent.ObjectCollect.instrument_rows;\n  var table_name=\"OT_SURGICAL_ACCESSORIES_INSTRUMENT\";\n  var accessory_type = \"I\";\n  var len = rows.length;\n  var xmlString =\"\";\n   var bill_flag=document.forms[0].bill_flag.value;\n\n  for(var i=0;i<len;i++){\n\n\t if(rows[i]!=null){\n\t\txmlString+=\"<INSTR_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"instr_code=\\\"\"+rows[i].instr_code+\"\\\"\"+\" \";\n\t\txmlString+=\"key_line=\\\"\"+rows[i].key_line+\"\\\"\"+\" \"; // Use this during update mode for Billing\n\t\tif(bill_flag==\"true\")\n\t\t{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str+\"\\\"\"+\" \"; // Newly added by bshankar\n\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \"; // Newly Added by bshankar\n\t\t}\n\t\txmlString+=\"oper_line_no=\\\"\"+rows[i].oper_line_no+\"\\\"\"+\" \";\n\t\t//Encoded for CRF-0058 by Rajesh\n\t\txmlString+=\"tray_no=\\\"\"+encodeURIComponent(rows[i].tray_no)+\"\\\"\"+\" \";\n\t\t//Encoded for CRF-0058 by Rajesh\n\t\t//xmlString+=\"remarks=\\\"\"+ rows[i].remarks+\"\\\"\"+\" \";\n\t\t//Added encodeURIComponent on 10/27/2010 for IN023758 by AnithaJ\n\t\txmlString+=\"remarks=\\\"\"+encodeURIComponent(rows[i].remarks)+\"\\\"\"+\" \";\n\n\t\txmlString+=\"accessory_type=\\\"\"+accessory_type+\"\\\"\"+\" \";\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\txmlString+=\"frm_pick_list=\\\"\"+rows[i].frm_pick_list+\"\\\"\"+\" \";\n\t\tif(rows[i].db_mode==\"L\")\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t\n\t }\n  }\n   return xmlString;\n}\n\nfunction createXMLForEquipments(){\n  var rows=parent.ObjectCollect.equipment_rows;\n  var table_name=\"OT_SURGICAL_ACCESSORIES_EQUIPMENTS\";\n  var accessory_type = \"E\";\n  var len = rows.length;\n  var xmlString =\"\";\n  var bill_flag=document.forms[0].bill_flag.value;\n   for(var i=0;i<len;i++){\n\t //if(rows[i]!=null &&  rows[i].db_mode!=\'L\')\n\t if(rows[i]!=null){\n\t\txmlString+=\"<EQUIP_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"equip_code=\\\"\"+rows[i].equip_code+\"\\\"\"+\" \";\n\t\txmlString+=\"key_line=\\\"\"+rows[i].key_line+\"\\\"\"+\" \"; // Use this during update mode for Billing\n\t\tif(bill_flag==\"true\")\n\t\t{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str+\"\\\"\"+\" \"; // Newly added by bshankar\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \"; // Newly Added by bshankar\n\t\t}\n\t\txmlString+=\"oper_line_no=\\\"\"+rows[i].oper_line_no+\"\\\"\"+\" \";\n\t\txmlString+=\"equip_id=\\\"\"+rows[i].equip_id+\"\\\"\"+\" \";\n\t\t//xmlString+=\"remarks=\\\"\"+ rows[i].remarks+\"\\\"\"+\" \";\n\t\t//Added encodeURIComponent on 10/27/2010 for IN023758 by AnithaJ\n\t\txmlString+=\"remarks=\\\"\"+encodeURIComponent(rows[i].remarks)+\"\\\"\"+\" \";\n\t\txmlString+=\"desiredDate=\\\"\"+rows[i].desiredDate+\"\\\"\"+\" \";\n\t\txmlString+=\"accessory_type=\\\"\"+accessory_type+\"\\\"\"+\" \";\n\t\txmlString+=\"frm_pick_list=\\\"\"+rows[i].frm_pick_list+\"\\\"\"+\" \";\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\tif(rows[i].db_mode==\"L\"){\n\t\t\t//Added Against Start AMRI-CRF-0294 [IN049121]\n\t\t\tif(rows[i].oper_line_status==\'99\'){\n\t\t\t\txmlString+=\"db_mode=\\\"\"+\"D\"+\"\\\"\"+\" \";\n\t\t\t}else{ //Added Against End AMRI-CRF-0294 [IN049121]\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\t\t} //Added Against AMRI-CRF-0294 [IN049121]\n\t\t}\t\t\t\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t\n\t }\n  }\n\n  return xmlString;\n}\n\nfunction createXMLForImplants(){\n  var rows=parent.ObjectCollect.implants_rows;\n  var table_name=\"OT_SURGICAL_ACCESSORIES_IMPLANTS\";\n  var accessory_type = \"S\";\n  var len = rows.length;\n  var xmlString =\"\";\n  var bill_flag=document.forms[0].bill_flag.value;\n  for(var i=0;i<len;i++){\n\t //if(rows[i]!=null &&  rows[i].db_mode!=\'L\'){\n\t if(rows[i]!=null){\n\t\txmlString+=\"<IMPL_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"implant_code=\\\"\"+rows[i].implant_code+\"\\\"\"+\" \";\n\t\txmlString+=\"key_line=\\\"\"+rows[i].key_line+\"\\\"\"+\" \"; // Use this during update mode for Billing\n\t\tif(bill_flag==\"true\")\n\t\t{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str+\"\\\"\"+\" \"; // Newly added by bshankar\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \"; // Newly Added by bshankar\n\t\t}\n\t\txmlString+=\"oper_line_no=\\\"\"+rows[i].oper_line_no+\"\\\"\"+\" \";\n\t\txmlString+=\"frm_pick_list=\\\"\"+rows[i].frm_pick_list+\"\\\"\"+\" \";\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\txmlString+=\"reserved_qty=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\txmlString+=\"requested_qty";
    private final static byte[]  _wl_block4_0Bytes = _getBytes( _wl_block4_0 );

    private final static java.lang.String  _wl_block4_1 ="=\\\"\"+rows[i].requested_qty+\"\\\"\"+\" \";\n\t\txmlString+=\"req_store_code=\\\"\"+rows[i].req_store_code+\"\\\"\"+\" \";\n\t\t//xmlString+=\"Store_desc=\\\"\"+rows[i].Store_desc+\"\\\"\"+\" \";\n\t\txmlString+=\"sale_document_no=\\\"\"+rows[i].sale_document_no+\"\\\"\"+\" \";\n\t\txmlString+=\"sale_document_type=\\\"\"+rows[i].sale_document_type+\"\\\"\"+\" \";\n\t\txmlString+=\"Stockavail=\\\"\"+rows[i].Stockavail+\"\\\"\"+\" \";\n\t\txmlString+=\"manufacturer=\\\"\"+rows[i].manufacturer+\"\\\"\"+\" \";\n\t\txmlString+=\"batch=\\\"\"+rows[i].batch+\"\\\"\"+\" \";\n\t\t//Added encodeURIComponent on 10/18/2010 for IN023758 by AnithaJ\n\t\txmlString+=\"remarks=\\\"\"+encodeURIComponent(rows[i].remarks)+\"\\\"\"+\" \";\n\t\t//xmlString+=\"remarks=\\\"\"+rows[i].remarks+\"\\\"\"+\" \";\n\t\txmlString+=\"accessory_type=\\\"\"+accessory_type+\"\\\"\"+\" \";\n\t\tif(rows[i].db_mode==\"L\")\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t\n\t }\n  }\n\n  return xmlString;\n}\n\nfunction createXMLForPackage(){\n  var rows=parent.ObjectCollect.packs_rows;\n  var table_name=\"OT_SURGICAL_ACCESSORIES_PACKAGES\";\n  var accessory_type = \"P\";\n  var len = rows.length;\n  var xmlString =\"\";\n  var bill_flag=document.forms[0].bill_flag.value;\n  for(var i=0;i<len;i++){\n\t //if(rows[i]!=null &&  rows[i].db_mode!=\'L\'){\n\t if(rows[i]!=null){\n\t\txmlString+=\"<PACK_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"package_code=\\\"\"+rows[i].package_code+\"\\\"\"+\" \";\n\t\txmlString+=\"key_line=\\\"\"+rows[i].key_line+\"\\\"\"+\" \"; // Use this during update mode for Billing\n\t\tif(bill_flag==\"true\")\n\t\t{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str_conspack+\"\\\"\"+\" \"; // Newly added by bshankar\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \"; // Newly Added by bshankar\n\t\t}\n\t\txmlString+=\"oper_line_no=\\\"\"+rows[i].oper_line_no+\"\\\"\"+\" \";\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\txmlString+=\"frm_pick_list=\\\"\"+rows[i].frm_pick_list+\"\\\"\"+\" \";\n\t\t//xmlString+=\"reserved_qty=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\t//xmlString+=\"requested_qty=\\\"\"+rows[i].requested_qty+\"\\\"\"+\" \";\n\t\t//xmlString+=\"req_store_code=\\\"\"+rows[i].req_store_code+\"\\\"\"+\" \";\n\t\t////xmlString+=\"sale_document_no=\\\"\"+rows[i].sale_document_no+\"\\\"\"+\" \";\n\t\t//xmlString+=\"sale_document_type=\\\"\"+rows[i].sale_document_type+\"\\\"\"+\" \";\n\n\t\t//xmlString+=\"remarks=\\\"\"+rows[i].remarks+\"\\\"\"+\" \";\n\t\t//Added encodeURIComponent on 10/27/2010 for IN023758 by AnithaJ\n\t\txmlString+=\"remarks=\\\"\"+encodeURIComponent(rows[i].remarks)+\"\\\"\"+\" \";\n\n\t\txmlString+=\"accessory_type=\\\"\"+accessory_type+\"\\\"\"+\" \";\n\t\tif(rows[i].db_mode==\"L\")\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n  }\n  return xmlString;\n}\n\n\n\nfunction createXMLForSpecimenDtls(){\n  var rows=parent.ObjectCollect.specimen_rows;\n  var len = rows.length;\n  var table_name = \"OT_POST_OPER_SPECIMENS\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].db_mode!=\'L\' ){\n\t\txmlString+=\"<SPEC_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"specimen_dtls=\\\"\"+checkSpl( rows[i].specimen_dtls )+\"\\\"\"+\" \";\n\t\txmlString+=\"dept_code=\\\"\"+rows[i].dept_code+\"\\\"\"+\" \";\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n  }\n return xmlString;\n}\n\n function createXMLForDisposalDtls(){\n  var rows=parent.ObjectCollect.disposal_rows;\n  var table_name=\"OT_POST_OPER_ORGAN\";\n  var len = rows.length;\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t if(rows[i]!=null && rows[i].db_mode!=\'L\'){\n\t\txmlString+=\"<DISPOSAL_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"anatomical_code=\\\"\"+rows[i].anatomical_code+\"\\\"\"+\" \";\n\t\txmlString+=\"disposal_code=\\\"\"+rows[i].disposal_code+\"\\\"\"+\" \";\n\t\txmlString+=\"given_by=\\\"\"+checkSpl( rows[i].given_by )+\"\\\"\"+\" \";\n\t\txmlString+=\"received_by=\\\"\"+checkSpl(rows[i].received_by )+\"\\\"\"+\" \";\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t}\n  }\n  return xmlString;\n}\n\n//Commented by rajesh for Uniue Constraing PK error TH_OT_SPR-3270\n/*function createXMLForTimeAndDetails(){\n  var rows=parent.ObjectCollect.time_rows;\n  var table_name=\"OT_POST_OPER_DTL2\";\n  var len = rows.length;\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t if(rows[i]!=null &&  rows[i].db_mode!=\'L\' && rows[i].verify_flag==\"OFF\" ){\n\t\txmlString+=\"<TIME_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+rows[i].speciality_code+\"\\\"\"+\" \";\n\t\txmlString+=\"preparation_time=\\\"\"+rows[i].db_preparation_time+\"\\\"\"+\" \";\n\t\txmlString+=\"procedure_start_time=\\\"\"+rows[i].db_procedure_start_time+\"\\\"\"+\" \";\n\t\txmlString+=\"procedure_end_time=\\\"\"+rows[i].db_procedure_end_time+\"\\\"\"+\" \";\n\t\txmlString+=\"anaesthesia_start_time=\\\"\"+rows[i].db_anaesthesia_start_time+\"\\\"\"+\" \";\n\t\txmlString+=\"anaesthesia_end_time=\\\"\"+rows[i].db_anaesthesia_end_time+\"\\\"\"+\" \";\n\t\txmlString+=\"surgery_start_time=\\\"\"+rows[i].db_surgery_start_time+\"\\\"\"+\" \";\n\t\txmlString+=\"surgery_end_time=\\\"\"+rows[i].db_surgery_end_time+\"\\\"\"+\" \";\n\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t\n\t }\n  }\n  return xmlString;\n}*/\n\nfunction createXMLForTimeAndDetails(){\n  var rows=parent.ObjectCollect.time_rows;\n\t var visit_pers_rows=parent.ObjectCollect.visit_pers_rows;\n\t var locale=document.forms[0].locale.value;\n  var table_name=\"OT_POST_OPER_DTL2\";\n  VISIT_PERSONEL_ENTERED = (visit_pers_rows.length>0)?\"Y\":\"N\"\n  var len = rows.length;\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t //if(rows[i]!=null &&  rows[i].db_mode!=\'L\' && rows[i].verify_flag==\"OFF\" ){\n\t if(rows[i]!=null && rows[i].db_mode!=\'L\' ){\n\t\txmlString+=\"<TIME_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+rows[i].speciality_code+\"\\\"\"+\" \";\n\n\t\tif(VISIT_PERSONEL_ENTERED==\"Y\" && (rows[i].speciality_code == visit_pers_rows[i].speciality_code) ){\n\t\t\txmlString+=\"visit_desc=\\\"\"+encodeURIComponent(visit_pers_rows[i].visit_desc,\"UTF-8\")+\"\\\"\"+\" \";\n\t\t}\n\n\t\txmlString+=\"preparation_time=\\\"\"+convertDate(rows[i].db_preparation_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"procedure_start_time=\\\"\"+convertDate(rows[i].db_procedure_start_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"procedure_end_time=\\\"\"+convertDate(rows[i].db_procedure_end_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"anaesthesia_start_time=\\\"\"+convertDate(rows[i].db_anaesthesia_start_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"anaesthesia_end_time=\\\"\"+convertDate(rows[i].db_anaesthesia_end_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"surgery_start_time=\\\"\"+convertDate(rows[i].db_surgery_start_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"surgery_end_time=\\\"\"+convertDate(rows[i].db_surgery_end_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"prep_start_time=\\\"\"+convertDate(rows[i].db_prep_start_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\txmlString+=\"prep_end_time=\\\"\"+convertDate(rows[i].db_prep_end_time,\'DMYHM\',locale,\"en\")+\"\\\"\"+\" \";\n\t\t\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t\n\t }\n  }\n  return xmlString;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block4_1Bytes = _getBytes( _wl_block4_1 );

    private final static java.lang.String  _wl_block5 ="\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<form name=\"OperCollectForm\" id=\"OperCollectForm\">\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' >\n<input type=\'hidden\' name=\'bill_flag\' id=\'bill_flag\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' >\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >\n\n<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' \t\t\tvalue=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
 
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
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

  String locale = (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block2Bytes, _wl_block2);
 
String tab=checkForNull(request.getParameter("tab"));
if(!("record_nursing").equals(tab)){ 
            _bw.write(_wl_block3Bytes, _wl_block3);
}
            _bw.write(_wl_block4_0Bytes, _wl_block4_0);
            _bw.write(_wl_block4_1Bytes, _wl_block4_1);
 String oper_num = checkForNull(request.getParameter("oper_num"));

            _bw.write(_wl_block5Bytes, _wl_block5);
 String bill_flag = request.getParameter("bill_flag");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(checkForNull(request.getParameter("slate_user_id"))));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
