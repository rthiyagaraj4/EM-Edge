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
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __nursingtimerecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/NursingTimeRecord.jsp", 1709120259126L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction formatTime(obj){\n\tvar duration=obj.value;\n\tvar arr=duration.split(\":\");\n\tif(duration!=\'\'){\n\tif(duration.length!=\"5\" || arr[0].length!=\"2\"){\n\t\talert(getMessage(\"APP-OT0130\",\"OT\"));\n\t\tobj.select();\n\t\tobj.focus()\n\t\treturn;\n\t}\n}\n\tvar RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;\n\tif(obj.value!=\"\" && !RE_EXP.test(obj.value) ){\n\t\tvar err_text=\"\";\n\t    var time = obj.value;\n\t    var arr_time =  time.split(\":\")\n        if(arr_time.length!=2){\n\t\t\tcal_error(getMessage(\"VALID_TIME_SLOTS\",\"OT\"),obj);\n\t\t}\n\t\tif(arr_time[1]==\'\' || arr_time[0]==\'\'){\n\t\tcal_error(getMessage(\"VALID_TIME_SLOTS\",\"OT\"),obj);\n\t\t}\n\t\tif(arr_time[0]<0 || arr_time[0]>23 ){\n\t\t\terr_text+=getMessage(\"APP-OT0040\",\"OT\");\n\t\t}\n\t\tif(arr_time[1]<0 || arr_time[1]>59 ){\n\t\t\terr_text+=getMessage(\"APP-OT0041\",\"OT\");\n\t\t}\n\t\tif(err_text.length>0)\t\n\t\t\tcal_error(err_text,obj);\n\t}\n\treturn true\n}\n\n\nfunction cal_error (str_message,obj) {\n\talert (str_message);\n\tobj.focus();\n\tobj.select();\n\treturn null;\n}\n\n\nfunction ChkNumber(obj){\n\tvar quantity_value=getLabel(\"Common.Quantity.label\",\"Common\");\n\tvar stock_val=getLabel(\"eOT.StockAvailable.Label\",\"OT\");\n\tvar quantity=obj.value;\n\tCheckNum(obj);\n\tif(obj.value!=\"\" ){\n\t  if(quantity==0)\n\t\t{\n\t  alert(quantity_value + getMessage(\"VALUE_SHOULD_BE_GR_ZERO\",\"common\"));\n\t  obj.select();\n\t  obj.focus();\n\t\t}\n\t}\n}\n\nfunction assignSpeciality(){\n\tvar formObjHdr = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar doc_level = formObjHdr.doc_level.value;\n\tif(document.forms[0].tab.value !=\"record_surgeon\")\n\t{\n\tcallPopulateList(doc_level);\n\t}else\n\t{\n\t\t\tif(doc_level==\"IS\")\n\t\t{\n\t\t\t\tvar facility_id=document.forms[0].facility_id.value;\n\t\t\t\tvar db_mode=parent.parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value;\n\t\t\t\tvar status_value=parent.parent.parent.frames[4].RecordSurgeonTabForm.status_value.value;\n\t\t\t\tvar oper_code_all=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value;\n\t\t\t\tvar oper_code_new=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value;\n\t\t\t\tvar spec_code_final=parent.parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value;\n\t\t\t\tvar oper_num=document.forms[0].oper_num.value;\n\t\t\t\tvar arr2=oper_code_all.split(\"*\");\n\t\t\t\tvar arr3=status_value.split(\"*\");\n\t\t\t\tvar arr1=db_mode.split(\"*\");\n\t\n\t\t\t\tvar oper_code=\"\";\n\t\t\t\tvar chk_status=\"\";\n\t\t\t\tvar db_mode_val=\"\";\n\t\t\t\t\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t    xmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=exist_operation_speciality&spec_code_final=\"+spec_code_final,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tvar arr_spec=retVal.split(\"*\");\n\t\t\t\tvar spec_code_new=\"\";\n\t\t\t\tvar spec_code_old=\"\";\n\t\t\t\tvar arr2_spec=\"\";\n\t\t\t\tvar opt =\"\";\n\t\t\t\tfor (var m=0;m<arr_spec.length-1;m++ )\n\t\t\t\t{\n\t\t\t\t\tspec_code_new=arr_spec[m];\n\t\t\t\t\t arr2_spec=spec_code_new.split(\",\");\n\t\t\t\t\t opt = parent.frames[0].document.createElement(\'OPTION\');\n\t\t\t\t\topt.text =arr2_spec[1];\n\t\t\t\t\topt.value=arr2_spec[0];\n\t\t\t\t\tdocument.forms[0].speciality.add(opt);\n\t\t\t\t}\n}else\n\t\t{\n\t\t\tassignListItems(\'*ALL\',\'All Specialities\');\n\t\t}\n\t}\n }\n\n\nfunction Class_row(){\n\n  var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936\n\n  this.speciality_code =\"\";\n  this.speciality_desc =\"\";\n  \n  this.db_preparation_time=\"\";\n  this.preparation_mts=\"\";\n\n  this.db_procedure_start_time=\"\";\n  this.procedure_start_time=\"\";\n  this.procedure_start_date=\"\";\n\n  this.db_procedure_end_time=\"\";\n  this.procedure_end_time=\"\";\n  this.procedure_end_date=\"\";\n\n  this.db_anaesthesia_start_time=\"\";\n  this.anaesthesia_start_time=\"\";\n  this.anaesthesia_start_date=\"\";\n\n  this.db_anaesthesia_end_time=\"\";\n  this.anaesthesia_end_time=\"\";\n  this.anaesthesia_end_date=\"\";\n\n  //Added by Arthi for ML-MMOH-CRF-1936\n  if(isTimeDtlsSurNurAppl==\"true\"){\n  this.db_prep_start_time=\"\";\n  this.prep_start_time=\"\";\n  this.prep_start_date=\"\";\n\n  this.db_prep_end_time=\"\";\n  this.prep_end_time=\"\";\n  this.prep_end_date=\"\";\n  }\n  //End ML-MMOH-CRF-1936\n  \n  this.db_surgery_start_time=\"\";\n  this.surgery_start_time=\"\";\n  this.surgery_start_date=\"\";\n\n  this.db_surgery_end_time=\"\";\n  this.surgery_end_time=\"\";\n  this.surgery_end_date=\"\";\n\n  this.recId=\"\";\n  this.db_mode=\"\";\n  this.verify_flag=\"OFF\";\n}\n\nfunction loadDBRows(speciality_code,speciality_desc,prep_time,proc_start_time,proc_end_time,anaes_start_time,anaes_end_time,prepr_start_time,prepr_end_time,surg_start_time,surg_end_time,index,mode){ \n  var objrow = newRow();\n  var rows=parent.parent.ObjectCollect.time_rows;\n  var result = \"\";\n  var rowLength=parent.parent.parent.ObjectCollect.time_len;\n  var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936\n\n  if(mode==\'L\' && rowLength==0){\n\t  objrow.speciality_code=speciality_code;\n\t  objrow.speciality_desc=speciality_desc;\n\n\t//Added by Arthi for ML-MMOH-CRF-1936\n\tif(isTimeDtlsSurNurAppl==\"true\"){\n\t //preparation time\n\t if(prep_time!=\"\"){\n\t\tobjrow.db_preparation_time=prep_time;\n\t\tvar arr1= prep_time.split(\" \");\n\t\tresult = arr1[1];\n\t\tvar arr2 = result.split(\":\");\n\t\tobjrow.preparation_mts = eval(arr2[0]*60) + eval(arr2[1]);\n\t }else{\n\t\t objrow.db_preparation_time=\"\";\n\t\t objrow.preparation_date = \"\"; \n\t\t objrow.preparation_time = \"\";\n\t  }\n\t //procedure start\n\t  if(proc_start_time!=\"\"){\n\t  objrow.db_procedure_start_time=proc_start_time;\n\t\tvar arr2 = proc_start_time.split(\" \");\n\t\tobjrow.procedure_start_date = arr2[0];\n\t\tobjrow.procedure_start_time = arr2[1];\n\t  }else{\n\t\tobjrow.db_procedure_start_time=\"\";\n\t\tobjrow.procedure_start_date =\"\";\n\t\tobjrow.procedure_start_time =\"\";\n\t  }\n\t //procedure end\n\t  if(proc_end_time!=\"\"){\n\t  objrow.db_procedure_end_time=proc_end_time;\n\t\tvar arr3 = proc_end_time.split(\" \");\n\t\tobjrow.procedure_end_date = arr3[0];\n\t\tobjrow.procedure_end_time = arr3[1];\n\t  }else{\n\t\t  objrow.db_procedure_end_time=\"\";\n\t\t  objrow.procedure_end_date =\"\";\n\t\t  objrow.procedure_end_time = \"\";\n\t  }\n\t  //anaesthesia start\n\t  if(anaes_start_time!=\"\"){\n\t  objrow.db_anaesthesia_start_time=anaes_start_time;\n\t    var arr4 = anaes_start_time.split(\" \");\n\t\tobjrow.anaesthesia_start_date = arr4[0];\n\t\tobjrow.anaesthesia_start_time = arr4[1];\n\t  }else{\n\t\t  objrow.db_anaesthesia_start_time=\"\";\n\t      objrow.anaesthesia_start_date = \"\";\n\t\t  objrow.anaesthesia_start_time = \"\";\n\t  }\n\t  //anaesthesia end\n\t  if(anaes_end_time){\n\t\t  objrow.db_anaesthesia_end_time=anaes_end_time;\n\t\t  var arr5 = anaes_end_time.split(\" \");\n          objrow.anaesthesia_end_date = arr5[0];\n\t      objrow.anaesthesia_end_time = arr5[1];\n\t\t}else{\n\t\t\tobjrow.db_anaesthesia_end_time=\"\";\n\t  \t    objrow.anaesthesia_end_date = \"\";\n\t\t    objrow.anaesthesia_end_time = \"\";\n\n\t\t}\n\t  //Preparation start\n\t\tif(prepr_start_time!=\"\"){\n\t\tobjrow.db_prep_start_time=prepr_start_time;\n\t  \tvar arr6 = prepr_start_time.split(\" \");\n\t\tobjrow.prep_start_date = arr6[0];\n\t\tobjrow.prep_start_time = arr6[1];\n\t\t}else{\n\t\t\tobjrow.db_prep_start_time=\"\";\n\t  \t\tobjrow.prep_start_date = \"\";\n\t\t\tobjrow.prep_start_time = \"\";\n\t\t}\n\t  //Preparation end\n\t\tif(prepr_end_time!=\"\"){\n\t\t\tobjrow.db_prep_end_time=prepr_end_time;\n\t\t\tvar arr7 = prepr_end_time.split(\" \");\n\t\t\tobjrow.prep_end_date = arr7[0];\n\t\t\tobjrow.prep_end_time = arr7[1];\n\t\t}else{\n\t\t\tobjrow.db_prep_end_time=\"\"\n\t\t\tobjrow.prep_end_date = \"\";\n\t\t\tobjrow.prep_end_time = \"\";\n\t\t}\n\t  //surgery start\n\t\tif(surg_start_time!=\"\"){\n\t\tobjrow.db_surgery_start_time=surg_start_time;\n\t  \tvar arr8 = surg_start_time.split(\" \");\n\t\tobjrow.surgery_start_date = arr8[0];\n\t\tobjrow.surgery_start_time = arr8[1];\n\t\t}else{\n\t\t\tobjrow.db_surgery_start_time=\"\";\n\t  \t\tobjrow.surgery_start_date = \"\";\n\t\t\tobjrow.surgery_start_time = \"\";\n\t\t}\n\t//surgery end\n\t\tif(surg_end_time!=\"\"){\n\t\t\tobjrow.db_surgery_end_time=surg_end_time;\n\t\t\tvar arr9 = surg_end_time.split(\" \");\n\t\t\tobjrow.surgery_end_date = arr9[0];\n\t\t\tobjrow.surgery_end_time = arr9[1];\n\t\t}else{\n\t\t\tobjrow.db_surgery_end_time=\"\"\n\t\t\tobjrow.surgery_end_date = \"\";\n\t\t\tobjrow.surgery_end_time = \"\";\n\t\t}\n\t}else{\n\t\t//preparation time\n\t if(prep_time!=\"\"){\n\t\tobjrow.db_preparation_time=prep_time;\n\t\tvar arr1= prep_time.split(\" \");\n\t\tresult = arr1[1];\n\t\tvar arr2 = result.split(\":\");\n\t\tobjrow.preparation_mts = eval(arr2[0]*60) + eval(arr2[1]);\n\t }else{\n\t\t objrow.db_preparation_time=\"\";\n\t\t objrow.preparation_date = \"\"; \n\t\t objrow.preparation_time = \"\";\n\t  }\n\t //procedure start\n\t  if(proc_start_time!=\"\"){\n\t  objrow.db_procedure_start_time=proc_start_time;\n\t\tvar arr2 = proc_start_time.split(\" \");\n\t\tobjrow.procedure_start_date = arr2[0];\n\t\tobjrow.procedure_start_time = arr2[1];\n\t  }else{\n\t\tobjrow.db_procedure_start_time=\"\";\n\t\tobjrow.procedure_start_date =\"\";\n\t\tobjrow.procedure_start_time =\"\";\n\t  }\n\t //procedure end\n\t  if(proc_end_time!=\"\"){\n\t  objrow.db_procedure_end_time=proc_end_time;\n\t\tvar arr3 = proc_end_time.split(\" \");\n\t\tobjrow.procedure_end_date = arr3[0];\n\t\tobjrow.procedure_end_time = arr3[1];\n\t  }else{\n\t\t  objrow.db_procedure_end_time=\"\";\n\t\t  objrow.procedure_end_date =\"\";\n\t\t  objrow.procedure_end_time = \"\";\n\t  }\n\t  //anaesthesia start\n\t  if(anaes_start_time!=\"\"){\n\t  objrow.db_anaesthesia_start_time=anaes_start_time;\n\t    var arr4 = anaes_start_time.split(\" \");\n\t\tobjrow.anaesthesia_start_date = arr4[0];\n\t\tobjrow.anaesthesia_start_time = arr4[1];\n\t  }else{\n\t\t  objrow.db_anaesthesia_start_time=\"\";\n\t      objrow.anaesthesia_start_date = \"\";\n\t\t  objrow.anaesthesia_start_time = \"\";\n\t  }\n\t  //anaesthesia end\n\t  if(anaes_end_time){\n\t\t  objrow.db_anaesthesia_end_time=anaes_end_time;\n\t\t  var arr5 = anaes_end_time.split(\" \");\n          objrow.anaesthesia_end_date = arr5[0];\n\t      objrow.anaesthesia_end_time = arr5[1];\n\t\t}else{\n\t\t\tobjrow.db_anaesthesia_end_time=\"\";\n\t  \t    objrow.anaesthesia_end_date = \"\";\n\t\t    objrow.anaesthesia_end_time = \"\";\n\t\t}\n\t  //surgery start\n\t\tif(surg_start_time!=\"\"){\n\t\tobjrow.db_surgery_start_time=surg_start_time;\n\t  \tvar arr6 = surg_start_time.split(\" \");";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="\n\t\tobjrow.surgery_start_date = arr6[0];\n\t\tobjrow.surgery_start_time = arr6[1];\n\t\t}else{\n\t\t\tobjrow.db_surgery_start_time=\"\";\n\t  \t\tobjrow.surgery_start_date = \"\";\n\t\t\tobjrow.surgery_start_time = \"\";\n\t\t}\n\t//surgery end\n\t\tif(surg_end_time!=\"\"){\n\t\t\tobjrow.db_surgery_end_time=surg_end_time;\n\t\t\tvar arr7 = surg_end_time.split(\" \");\n\t\t\tobjrow.surgery_end_date = arr7[0];\n\t\t\tobjrow.surgery_end_time = arr7[1];\n\t\t}else{\n\t\t\tobjrow.db_surgery_end_time=\"\"\n\t\t\tobjrow.surgery_end_date = \"\";\n\t\t\tobjrow.surgery_end_time = \"\";\n\t\t}\n\t}\n\t    objrow.db_mode=\"L\";\n\t    objrow.recId = index;\n\t    rows.push(objrow);\n\t}\n}\n\n\nfunction refresh(){\n\tvar formObj = document.forms[0];\n\tvar params = formObj.params.value;\n\t parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingTimeDtls.jsp?\'+params;\n}\n\nfunction addRow(){\n\n\t//Added by Arthi for ML-MMOH-CRF-1936\n\tvar isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;\n\tif(isTimeDtlsSurNurAppl==\"true\"){\n\t\tvar fields = new Array ();\n\t\tvar names = new Array ();\n\t\tif(document.getElementById(\"anesProcmandImgStart\").style.visibility==\'visible\'){\n\t\t\tfields = fields.concat( document.forms[0].procedure_start_date ) ;\n            names = names.concat( getLabel(\'eOT.AnaesthesiaProcedureStartTime.Label\',\'OT\') ) ;\n\t\t}\n\t\tif(document.getElementById(\"anesProcmandImgEnd\").style.visibility==\'visible\'){\n\t\t\tfields = fields.concat( document.forms[0].procedure_end_date ) ;\n            names = names.concat( getLabel(\'eOT.AnaesthesiaProcedureEndTime.Label\',\'OT\') ) ;\n\t\t}\n\t\tif(document.getElementById(\"anesmandImgStart\").style.visibility==\'visible\'){\n\t\t\tfields = fields.concat( document.forms[0].anaesthesia_start_date ) ;\n            names = names.concat( getLabel(\'eOT.AnaesthesiaStartTime.Label\',\'OT\') ) ;\n\t\t}\n\t\tif(document.getElementById(\"anesmandImgEnd\").style.visibility==\'visible\'){\n\t\t\tfields = fields.concat( document.forms[0].anaesthesia_end_date ) ;\n            names = names.concat( getLabel(\'eOT.AnaesthesiaEndTime.Label\',\'OT\') ) ;\n\t\t}\n\t\tif(document.getElementById(\"prepmandImgStart\").style.visibility==\'visible\'){\n\t\t\tfields = fields.concat( document.forms[0].prep_start_date ) ;\n            names = names.concat( getLabel(\'eOT.Preparation.Label\',\'OT\')+\" \"+getLabel(\'Common.StartTime.label\',\'common\') ) ;\n\t\t}\n\t\tif(document.getElementById(\"prepmandImgEnd\").style.visibility==\'visible\'){\n\t\t\tfields = fields.concat( document.forms[0].prep_end_date ) ;\n            names = names.concat( getLabel(\'eOT.Preparation.Label\',\'OT\')+\" \"+getLabel(\'Common.EndTime.label\',\'common\') ) ;\n\t\t}\n\t\tif(document.getElementById(\"surgmandImgStart\").style.visibility==\'visible\'){\n\t\t\tfields = fields.concat( document.forms[0].surgery_start_date ) ;\n            names = names.concat( getLabel(\'Common.Surgery.label\',\'common\')+\" \"+getLabel(\'Common.StartTime.label\',\'common\') ) ;\n\t\t}\n\t\tif(document.getElementById(\"surgmandImgEnd\").style.visibility==\'visible\'){\n\t\t\tfields = fields.concat( document.forms[0].surgery_end_date ) ;\n            names = names.concat( getLabel(\'Common.Surgery.label\',\'common\')+\" \"+getLabel(\'Common.EndTime.label\',\'common\') ) ;\n\t\t}\n\t\tif(checkFieldsofMst( fields, names, parent.parent.messageFrame)){\n\t\t\n\t\t\t  var objrow = newRow();\n\t\t\t  var rows=parent.parent.ObjectCollect.time_rows;\n\t\t\t  var formObj = document.NursingTimeRecordForm;\n\t\t\t  var obj = formObj.speciality;\n\t\t\t  var mode =formObj.mode.value;\n\t\t\t  var result = convertMts();\n\t\t\t  result = trimString(result);\n\t\t\t  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n\t\t\t  if(mode==\'I\' && validateEndDate()==true ){\n\t\t\t\tif(alreadyExist()){ \t\t\n\t\t\t\t objrow.speciality_code=formObj.speciality.value;\n\t\t\t\t objrow.speciality_desc=formObj.speciality[obj.selectedIndex].text;\n\t\t\t\t \n\t\t\t\t  objrow.db_preparation_time=result;\n\t\t\t\t  objrow.preparation_mts = formObj.preparation_time.value;\n\t\t\t\t\t\t \n\t\t\t\t //procedure start\n\t\t\t\t objrow.db_procedure_start_time=formObj.procedure_start_date.value+\" \"+formObj.procedure_start_time.value;\n\t\t\t\t objrow.procedure_start_time=formObj.procedure_start_time.value;\n\t\t\t\t objrow.procedure_start_date=formObj.procedure_start_date.value;\n\t\t\t\t\n\t\t\t\t//procedure end\n\t\t\t\t objrow.db_procedure_end_time=formObj.procedure_end_date.value+\" \"+formObj.procedure_end_time.value;\n\t\t\t\t objrow.procedure_end_time=formObj.procedure_end_time.value;\n\t\t\t\t objrow.procedure_end_date=formObj.procedure_end_date.value;\n\t\t\t\t //anaesthesia start\n\t\t\t\t objrow.db_anaesthesia_start_time=formObj.anaesthesia_start_date.value+\" \"+formObj.anaesthesia_start_time.value;\n\t\t\t\t objrow.anaesthesia_start_time=formObj.anaesthesia_start_time.value;\n\t\t\t\t objrow.anaesthesia_start_date=formObj.anaesthesia_start_date.value;\n\t\t\t\t //anaesthesia end\n\t\t\t\t objrow.db_anaesthesia_end_time=formObj.anaesthesia_end_date.value+\" \"+formObj.anaesthesia_end_time.value;\n\t\t\t\t objrow.anaesthesia_end_time=formObj.anaesthesia_end_time.value;\n\t\t\t\t objrow.anaesthesia_end_date=formObj.anaesthesia_end_date.value;\n\n\t\t\t\t//Preparation start\n\t\t\t\t objrow.db_prep_start_time=formObj.prep_start_date.value+\" \"+formObj.prep_start_time.value;\n\t\t\t\t objrow.prep_start_time=formObj.prep_start_time.value;\n\t\t\t\t objrow.prep_start_date=formObj.prep_start_date.value;\n\t\t\t\t//Preparation end\n\t\t\t\t objrow.db_prep_end_time=formObj.prep_end_date.value+\" \"+formObj.prep_end_time.value;\n\t\t\t\t objrow.prep_end_time=formObj.prep_end_time.value;\n\t\t\t\t objrow.prep_end_date=formObj.prep_end_date.value;\n\t\t\t\t\n\t\t\t\t //surgery start\n\t\t\t\t objrow.db_surgery_start_time=formObj.surgery_start_date.value+\" \"+formObj.surgery_start_time.value;\n\t\t\t\t objrow.surgery_start_time=formObj.surgery_start_time.value;\n\t\t\t\t objrow.surgery_start_date=formObj.surgery_start_date.value;\n\t\t\t\t//surgery end\n\t\t\t\t objrow.db_surgery_end_time=formObj.surgery_end_date.value+\" \"+formObj.surgery_end_time.value;\n\t\t\t\t objrow.surgery_end_time=formObj.surgery_end_time.value;\n\t\t\t\t objrow.surgery_end_date=formObj.surgery_end_date.value;\n\t\t\t\t  \n\t\t\t\t  objrow.db_mode=\"I\";\n\t\t\t\t  objrow.recId = rows.length+1;\n\t\t\t\t  rows.push(objrow);\n\t\t\t\t   resetFields();\n\t\t\t\t   parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingTimeDtls.jsp\';\n\t\t\t\t  parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\n\t\t\t\t}else\n\t\t\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t\t} else if(validateEndDate()==true){\n\t\t\t\t  updateRow();\n\t\t\t\t  parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t\t\t\t}\n\t}\n\t}else{\n\t  var objrow = newRow();\n\t  var rows=parent.parent.ObjectCollect.time_rows;\n\t  var formObj = document.NursingTimeRecordForm;\n\t  var obj = formObj.speciality;\n\t  var mode =formObj.mode.value;\n\t  var result = convertMts();\n  result = trimString(result);\n   var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  if(mode==\'I\' && validateEndDate()==true ){\n\tif(alreadyExist()){ \t\t\n\t objrow.speciality_code=formObj.speciality.value;\n\t objrow.speciality_desc=formObj.speciality[obj.selectedIndex].text;\n\t \n\t  objrow.db_preparation_time=result;\n\t  objrow.preparation_mts = formObj.preparation_time.value;\n\t \t \t \n\t //procedure start\n\t objrow.db_procedure_start_time=formObj.procedure_start_date.value+\" \"+formObj.procedure_start_time.value;\n\t objrow.procedure_start_time=formObj.procedure_start_time.value;\n\t objrow.procedure_start_date=formObj.procedure_start_date.value;\n\t\n\t//procedure end\n\t objrow.db_procedure_end_time=formObj.procedure_end_date.value+\" \"+formObj.procedure_end_time.value;\n\t objrow.procedure_end_time=formObj.procedure_end_time.value;\n\t objrow.procedure_end_date=formObj.procedure_end_date.value;\n\t //anaesthesia start\n\t objrow.db_anaesthesia_start_time=formObj.anaesthesia_start_date.value+\" \"+formObj.anaesthesia_start_time.value;\n\t objrow.anaesthesia_start_time=formObj.anaesthesia_start_time.value;\n\t objrow.anaesthesia_start_date=formObj.anaesthesia_start_date.value;\n\t //anaesthesia end\n\t objrow.db_anaesthesia_end_time=formObj.anaesthesia_end_date.value+\" \"+formObj.anaesthesia_end_time.value;\n\t objrow.anaesthesia_end_time=formObj.anaesthesia_end_time.value;\n\t objrow.anaesthesia_end_date=formObj.anaesthesia_end_date.value;\n\t //surgery start\n\t objrow.db_surgery_start_time=formObj.surgery_start_date.value+\" \"+formObj.surgery_start_time.value;\n\t objrow.surgery_start_time=formObj.surgery_start_time.value;\n\t objrow.surgery_start_date=formObj.surgery_start_date.value;\n\t//surgery end\n\t objrow.db_surgery_end_time=formObj.surgery_end_date.value+\" \"+formObj.surgery_end_time.value;\n\t objrow.surgery_end_time=formObj.surgery_end_time.value;\n\t objrow.surgery_end_date=formObj.surgery_end_date.value;\n\t  \n\t  objrow.db_mode=\"I\";\n\t  objrow.recId = rows.length+1;\n\t  rows.push(objrow);\n\t   resetFields();\n\t   parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingTimeDtls.jsp\';\n\t  parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\n\t}else\n\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n} else if(validateEndDate()==true){\n\t  updateRow();\n\t  parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t}\n\t\t\n\t}\n\t  \n}\n\nfunction disableDocLevel(){\n   var formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   if(formObj.doc_level.disabled==false)\n\t   formObj.doc_level.disabled=true;\n}\n\n\n\n\nfunction newRow(){\n  var objrow = new Class_row();\n   return(objrow);\n}\n\n\nfunction alreadyExist(){\n\tvar formObj = document.forms[0];\n\tvar codeDtl = parent.parent.RecordFrame.DetailFrame.code; \n\tvar codeRecord = formObj.speciality.value;\n\tif(codeDtl.indexOf(codeRecord)>=0){\n\t   return false;\n\t}\n\telse\n\t   return true;\n }\n\n\n\nfunction removeRow(){\nvar formObj = document.forms[0];\nvar rows=parent.parent.ObjectCollect.time_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nif(rows.length>0 && mode==\'U\'){        \n  for(var jj=0;jj<rows.length;jj++){\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\t\t\t if(rows[jj].db_mode==\'L\')\n\t\t\t\trows[jj].db_mode=\'D\';\n\t\t\t else\n\t\t\t  delete rows[jj];\n\t\t\t   break;\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n resetFields();\n parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingTimeDtls.jsp\';\n parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}else\n   resetFields();\n}\n\nfunction updateRow(){\n\tvar isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936\n\tvar formObj = document.forms[0];\n\tvar mode =formObj.mode.value\n\tvar recId = formObj.recId.value;\n\tvar result = convertMts();\n\tresult = trimString(result);\n\tvar rows=parent.parent.ObjectCollect.time_rows;\n\tif(rows.length>0 && mode==\'U\'){        \n\tfor(var jj=0;jj<rows.length;jj++){\n\tif(rows[jj]!=null){\n\t if(rows[jj].recId==recId){\n\t rows[jj].db_prepar";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block7_2 ="ation_time=result;\n\t rows[jj].preparation_mts = formObj.preparation_time.value;\n\t\t//procedure start\n\t\t rows[jj].db_procedure_start_time=formObj.procedure_start_date.value+\" \"+formObj.procedure_start_time.value;\n\t\t rows[jj].procedure_start_time=formObj.procedure_start_time.value;\n\t\t rows[jj].procedure_start_date=formObj.procedure_start_date.value;\n\t\t\n\t\t//procedure end\n\t\t rows[jj].db_procedure_end_time=formObj.procedure_end_date.value+\" \"+formObj.procedure_end_time.value;\n\t\t rows[jj].procedure_end_time=formObj.procedure_end_time.value;\n\t\t rows[jj].procedure_end_date=formObj.procedure_end_date.value;\n\t\t //anaesthesia start\n\t\t rows[jj].db_anaesthesia_start_time=formObj.anaesthesia_start_date.value+\" \"+formObj.anaesthesia_start_time.value;\n\t\t rows[jj].anaesthesia_start_time=formObj.anaesthesia_start_time.value;\n\t\t rows[jj].anaesthesia_start_date=formObj.anaesthesia_start_date.value;\n\t\t //anaesthesia end\n\t\t rows[jj].db_anaesthesia_end_time=formObj.anaesthesia_end_date.value+\" \"+formObj.anaesthesia_end_time.value;\n\t\t rows[jj].anaesthesia_end_time=formObj.anaesthesia_end_time.value;\n\t\t rows[jj].anaesthesia_end_date=formObj.anaesthesia_end_date.value;\n\n\t\t//Added by Arthi for ML-MMOH-CRF-1936\n\t\tif(isTimeDtlsSurNurAppl==\"true\"){\n\t\t//Preparation start\n\t\trows[jj].db_prep_start_time=formObj.prep_start_date.value+\" \"+formObj.prep_start_time.value;\n\t\trows[jj].prep_start_time=formObj.prep_start_time.value;\n\t\trows[jj].prep_start_date=formObj.prep_start_date.value;\n\t\t//Preparation end\n\t\trows[jj].db_prep_end_time=formObj.prep_end_date.value+\" \"+formObj.prep_end_time.value;\n\t\trows[jj].prep_end_time=formObj.prep_end_time.value;\n\t\trows[jj].prep_end_date=formObj.prep_end_date.value;\n\t\t}\n\t\t//End ML-MMOH-CRF-1936\n\n\t\t//surgery start\t\n\t\trows[jj].db_surgery_start_time=formObj.surgery_start_date.value+\" \"+formObj.surgery_start_time.value;\n\t\trows[jj].surgery_start_time=formObj.surgery_start_time.value;\n\t\trows[jj].surgery_start_date=formObj.surgery_start_date.value;\n\t\t//surgery end\n\t\trows[jj].db_surgery_end_time=formObj.surgery_end_date.value+\" \"+formObj.surgery_end_time.value;\n\t\trows[jj].surgery_end_time=formObj.surgery_end_time.value;\n\t\trows[jj].surgery_end_date=formObj.surgery_end_date.value;\n        if(rows[jj].db_mode==\'L\'){\n\t\t    rows[jj].db_mode=\'U\'\n\t\t\tbreak;\n\t\t}\n\t  }\n\t}else  \n\t\t\tcontinue;\n\t}//END OF FOR LOOP\n      resetFields();\n\t  parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/NursingTimeDtls.jsp\';\n }\n}\n\nfunction splitString(strVal){\n\tvar isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936\n    var arr = strVal.split(\'::\');\n\tvar frmObj = document.NursingTimeRecordForm;\n\n\t//Added by Arthi for ML-MMOH-CRF-1936\n\tif(isTimeDtlsSurNurAppl==\"true\"){\n\tfrmObj.speciality.value=arr[0];\n\tfrmObj.speciality.disabled=true;\n\tfrmObj.preparation_time.value=arr[3];\n\t\t\n\tfrmObj.procedure_start_time.value = arr[4];\n\tfrmObj.procedure_start_date.value = arr[5];\n\tfrmObj.procedure_end_time.value = arr[6];\n\tfrmObj.procedure_end_date.value = arr[7];\n\n\tfrmObj.anaesthesia_start_time.value = arr[8];\n\tfrmObj.anaesthesia_start_date.value = arr[9];\n\tfrmObj.anaesthesia_end_time.value = arr[10];\n\tfrmObj.anaesthesia_end_date.value = arr[11];\n\n\tfrmObj.prep_start_time.value = arr[12];\n\tfrmObj.prep_start_date.value = arr[13];\n\tfrmObj.prep_end_time.value = arr[14];\n\tfrmObj.prep_end_date.value = arr[15];\n\n\tfrmObj.surgery_start_time.value = arr[16];\n\tfrmObj.surgery_start_date.value = arr[17];\n\tfrmObj.surgery_end_time.value = arr[18];\n\tfrmObj.surgery_end_date.value = arr[19];\n\t\n\tfrmObj.recId.value=arr[20];\n\tfrmObj.mode.value=arr[21];\n\t}else{\n\tfrmObj.speciality.value=arr[0];\n\tfrmObj.speciality.disabled=true;\n\tfrmObj.preparation_time.value=arr[3];\n\t\t\n\tfrmObj.procedure_start_time.value = arr[4];\n\tfrmObj.procedure_start_date.value = arr[5];\n\tfrmObj.procedure_end_time.value = arr[6];\n\tfrmObj.procedure_end_date.value = arr[7];\n\n\tfrmObj.anaesthesia_start_time.value = arr[8];\n\tfrmObj.anaesthesia_start_date.value = arr[9];\n\tfrmObj.anaesthesia_end_time.value = arr[10];\n\tfrmObj.anaesthesia_end_date.value = arr[11];\n\n\tfrmObj.surgery_start_time.value = arr[12];\n\tfrmObj.surgery_start_date.value = arr[13];\n\tfrmObj.surgery_end_time.value = arr[14];\n\tfrmObj.surgery_end_date.value = arr[15];\n\t\n\tfrmObj.recId.value=arr[16];\n\tfrmObj.mode.value=arr[17];\t\n\t}\n\t\n}\n\nfunction resetFields(){\n\tvar isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936\n\tvar frmObj = document.NursingTimeRecordForm;\n\tfrmObj.preparation_time.value=\"\";\n\t\n\tfrmObj.procedure_start_time.value = \"\";\n\tfrmObj.procedure_start_date.value = \"\";\n\tfrmObj.procedure_end_time.value = \"\";\n\tfrmObj.procedure_end_date.value = \"\";\n\n\tfrmObj.anaesthesia_start_time.value = \"\";\n\tfrmObj.anaesthesia_start_date.value = \"\";\n\tfrmObj.anaesthesia_end_time.value = \"\";\n\tfrmObj.anaesthesia_end_date.value =\"\";\n\n\t//Added by Arthi for ML-MMOH-CRF-1936\n\tif(isTimeDtlsSurNurAppl==\"true\"){\n\tfrmObj.prep_start_time.value = \"\";\n\tfrmObj.prep_start_date.value = \"\";\n\tfrmObj.prep_end_time.value = \"\";\n\tfrmObj.prep_end_date.value = \"\";\n\t}\n\t//End ML-MMOH-CRF-1936\n\n\tfrmObj.surgery_start_time.value = \"\";\n\tfrmObj.surgery_start_date.value = \"\";\n\tfrmObj.surgery_end_time.value = \"\";\n\tfrmObj.surgery_end_date.value = \"\";\n\t\n\tfrmObj.recId.value=\"\";\n\tfrmObj.mode.value=\'I\';\n\tfrmObj.speciality.disabled=false;\n}\n\nfunction assignRecId(){\n\tvar rows = parent.parent.parent.ObjectCollect.time_rows;\n\tparent.parent.parent.ObjectCollect.time_len=rows.length;\n\t\n}\n\n</script>\n</head>\n\n<body onLoad=\"assignSpeciality(); surNurMandatory();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"NursingTimeRecordForm\" id=\"NursingTimeRecordForm\">\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block7_2Bytes = _getBytes( _wl_block7_2 );

    private final static java.lang.String  _wl_block8 ="\" > \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<input type=\'hidden\' name=\'isTimeDtlsSurNurAppl\' id=\'isTimeDtlsSurNurAppl\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"><!-- Added Against ML-MMOH-CRF-1936 -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr> \n\t<td class=\"label\" width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t <td class=\"fields\" width=\'25%\'>\n\t\t  <select name=\"speciality\" id=\"speciality\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" > </select>\n\t  </td>\n\t<td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </td>\n\t  <td class=\"fields\" width=\'25%\'>\n\t\t <input type=\'text\' name=\'preparation_time\' id=\'preparation_time\' size=\'2\' maxlength=\'3\' onblur=\"ChkNumber(this);\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" > (in mins)\n\t </td>\n</tr>\n<tr>\n\t <td class=\"label\" width=\'25%\'> \n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td >\n\t<td class=\"fields\" width=\'25%\'>\n\t\t<input type=\'text\' name=\'procedure_start_date\' id=\'procedure_start_date\' size=\'8\' value=\"\" readonly>\n\t\t <img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'procedure_start_date\');\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n\t\t<input type=\'text\' name=\'procedure_start_time\' id=\'procedure_start_time\' size=\'2\' maxlength=\'5\' onkeypress =\'return checkForSpecCharsforIDTime(event);\' onBlur=\"if(this.value!=\'\')checkTimeFormat(procedure_start_date,this);\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'anesProcmandImgStart\'></img>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\n\t<td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </td>\n\t <td class=\"fields\" width=\'25%\'>\n\t\t  <input type=\'text\' name=\'procedure_end_date\' id=\'procedure_end_date\' size=\'8\' value=\"\" readonly>\n\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return validateStartDate(procedure_end_date);\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n\t\t  <input type=\'text\' name=\'procedure_end_time\' id=\'procedure_end_time\' size=\'2\' maxlength=\'5\' onkeypress =\'return checkForSpecCharsforIDTime(event);\'  onBlur=\"if(this.value!=\'\')checkTimeFormat(procedure_end_date,this);chkAnaesProcFromToTime()\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="  >\n\t\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t  <img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'anesProcmandImgEnd\'></img>\n\t\t  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</td>\n</tr>\n<tr>\n\t <td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </td>\n     <td class=\"fields\" width=\'25%\'>\n\t\t<input type=\'text\' name=\'anaesthesia_start_date\' id=\'anaesthesia_start_date\' size=\'8\' readonly>\n\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'anaesthesia_start_date\');\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t\t<input type=\'text\' name=\'anaesthesia_start_time\' id=\'anaesthesia_start_time\' size=\'2\' maxlength=\'5\' onkeypress =\'return checkForSpecCharsforIDTime(event);\' onBlur=\"if(this.value!=\'\'){checkTimeFormat(anaesthesia_start_date,this);}\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" > \n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'anesmandImgStart\'></img>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" </td>\n\t <td class=\"fields\" width=\'25%\'>\n\t\t  <input type=\'text\' name=\'anaesthesia_end_date\' id=\'anaesthesia_end_date\' size=\'8\' readonly>\n\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return validateStartDate(anaesthesia_end_date);\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" >\n\t\t  <input type=\'text\' name=\'anaesthesia_end_time\' id=\'anaesthesia_end_time\' size=\'2\' maxlength=\'5\' onkeypress =\'return checkForSpecCharsforIDTime(event);\' onBlur=\"if(this.value!=\'\'){checkTimeFormat(anaesthesia_end_date,this);chkAnaesFromToTime();}\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" >\n\t\t  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t  <img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'anesmandImgEnd\'></img>\n\t\t  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t </td>\n</tr>\n\n<!-- Added by Arthi for ML-MMOH-CRF-1936 -->\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<tr>\n\t <td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp;";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t<td class=\"fields\" width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'prep_start_date\' id=\'prep_start_date\' size=\'8\' readonly> \n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'prep_start_date\');\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" >\n\t\t\t<input type=\'text\' name=\'prep_start_time\' id=\'prep_start_time\' size=\'2\' maxlength=\'5\' onkeypress =\'return checkForSpecCharsforIDTime(event);\' onBlur=\"if(this.value!=\'\')checkTimeFormat(prep_start_date,this);\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" > \n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'prepmandImgStart\'></img>\n\t</td>\n\t<td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t <td class=\"fields\" width=\'25%\'>\n\t\t  <input type=\'text\' name=\'prep_end_date\' id=\'prep_end_date\' size=\'8\' readonly> \n\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return validateStartDate(prep_end_date);\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" >\n\t\t  <input type=\'text\' name=\'prep_end_time\' id=\'prep_end_time\' size=\'2\' maxlength=\'5\'  onBlur=\"if(this.value!=\'\')checkTimeFormat(prep_end_date,this);chkPrepFromToTime();\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" > \n\t\t  <img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'prepmandImgEnd\'></img>\n\t </td>\n</tr>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n<!-- End ML-MMOH-CRF-1936 -->\n\n<tr>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t <td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" </td>\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t<td class=\"fields\" width=\'25%\'>\n\t\t\t<input type=\'text\' name=\'surgery_start_date\' id=\'surgery_start_date\' size=\'8\' readonly> \n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'surgery_start_date\');\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" >\n\t\t\t<input type=\'text\' name=\'surgery_start_time\' id=\'surgery_start_time\' size=\'2\' maxlength=\'5\' onkeypress =\'return checkForSpecCharsforIDTime(event);\' onBlur=\"if(this.value!=\'\')checkTimeFormat(surgery_start_date,this);\" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" >\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'surgmandImgStart\'></img>\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t</td>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t <td class=\"fields\" width=\'25%\'>\n\t\t  <input type=\'text\' name=\'surgery_end_date\' id=\'surgery_end_date\' size=\'8\' readonly> \n\t\t  <img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return validateStartDate(surgery_end_date);\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" >\n\t\t  <input type=\'text\' name=\'surgery_end_time\' id=\'surgery_end_time\' size=\'2\' maxlength=\'5\'  onBlur=\"if(this.value!=\'\')checkTimeFormat(surgery_end_date,this);chkProcFromToTime();\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t  <img src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\' id=\'surgmandImgEnd\'></img>\n\t\t  ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t </td>\n</tr>\n<tr>\n\t\t <td class=\"fields\" width=\'25%\'></td>\n\t\t <td class=\"fields\" width=\'25%\'></td>\n\t\t <td class=\"fields\" width=\'25%\'></td>\n\t\t<td  width=\'25%\' class=\"button\">\n\t\t<input type=\'button\' name=\'record\' id=\'record\' class=\'button\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' onClick=\'addRow();disableDocLevel();\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" >\n\t\t<input type=\'button\' name=\'cancel\' id=\'cancel\' class=\'button\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" >\n\t\t</td>\n\t\t \n</tr>\n</table>\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\"\" > \n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"I\" > \n<input type=\'hidden\' name=\'tab_id\' id=\'tab_id\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<input type=\'hidden\' name=\'check_into_or_time\' id=\'check_into_or_time\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<input type=\'hidden\' name=\'sysdate1\' id=\'sysdate1\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type=\'hidden\' name=\'tab\' id=\'tab\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\n<!-- Added by Arthi for ML-MMOH-CRF-1936 -->\n<input type=\'hidden\' name=\'anes_proc_start_end_time_yn\' id=\'anes_proc_start_end_time_yn\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\'hidden\' name=\'anes_start_end_time_yn\' id=\'anes_start_end_time_yn\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\'hidden\' name=\'surgery_start_end_time_yn\' id=\'surgery_start_end_time_yn\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type=\'hidden\' name=\'preparation_start_end_time_yn\' id=\'preparation_start_end_time_yn\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n<input type=\'hidden\' name=\'record_surgeon_notes_yn\' id=\'record_surgeon_notes_yn\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n<input type=\'hidden\' name=\'record_nursing_notes_yn\' id=\'record_nursing_notes_yn\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n<!-- End ML-MMOH-CRF-1936 -->\n\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

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
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            _bw.write(_wl_block7_2Bytes, _wl_block7_2);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);
 

	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String disable_flag="",sysdate1="";
	String nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn")); 
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	String check_into_or_time = CommonBean.checkForNull(request.getParameter("check_into_or_time")); 
	String function_id = CommonBean.checkForNull(request.getParameter("function_id")); 
	String tab = CommonBean.checkForNull(request.getParameter("tab")); 

	//Added by Arthi for ML-MMOH-CRF-1936
	String anes_proc_start_end_time_yn = "";
	String anes_start_end_time_yn = "";
	String surgery_start_end_time_yn = "";
	String preparation_start_end_time_yn = "";
	String record_surgeon_notes_yn = "";
	String record_nursing_notes_yn = "";
	Boolean isTimeDtlsSurNurAppl = false;
	//End ML-MMOH-CRF-1936
	
	if(tab.equals("record_nursing")){
		disable_flag = (nursing_doc_comp_yn.equals("Y") )?"disabled":"";
	}else if(tab.equals("record_surgeon") ) {
		disable_flag = (surgeon_doc_comp_yn.equals("Y") )?"disabled":"";
	}

    	String SQL1 = "SELECT A.SPECIALITY_CODE SPL_CODE,DECODE(A.SPECIALITY_CODE, '*ALL','All Specialities',B.SHORT_DESC) SPL_DESC,TO_CHAR(A.PREPARATION_TIME,'DD/MM/YYYY HH24:MI') PREP_TIME,TO_CHAR(A.ANEST_PROC_START_TIME,'DD/MM/YYYY HH24:MI') PROC_START_TIME,TO_CHAR(A.ANEST_PROC_END_TIME,'DD/MM/YYYY HH24:MI') PROC_END_TIME,TO_CHAR(A.ANEST_START_TIME,'DD/MM/YYYY HH24:MI') ANST_START_TIME,TO_CHAR(A.ANEST_END_TIME,'DD/MM/YYYY HH24:MI') ANST_END_TIME,TO_CHAR(A.PREP_START_TIME,'DD/MM/YYYY HH24:MI') PRE_START_TIME,TO_CHAR(A.PREP_END_TIME,'DD/MM/YYYY HH24:MI') PRE_END_TIME,TO_CHAR(A.SURG_START_TIME,'DD/MM/YYYY HH24:MI') SUG_START_TIME,TO_CHAR(A.SURG_END_TIME,'DD/MM/YYYY HH24:MI') SUG_END_TIME,TO_CHAR(sysdate,'DD/MM/YYYY HH24:MI') sysdate1 FROM OT_POST_OPER_DTL2 A,AM_SPECIALITY B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.SPECIALITY_CODE = B.SPECIALITY_CODE(+)";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		
		//Added by Arthi for ML-MMOH-CRF-1936
		JSONArray SurNurMandYNJsonArr = new JSONArray();
		SurNurMandYNJsonArr = eOT.OTCommonBean.getSurNurMandatoryYN(con,facility_id);
		isTimeDtlsSurNurAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "TIMEDTLS_NUR_SUR_NOTE_MAND");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isTimeDtlsSurNurAppl));
            _bw.write(_wl_block10Bytes, _wl_block10);

		for(int i = 0 ; i < SurNurMandYNJsonArr.size() ; i++) 
		{
			JSONObject json	= (JSONObject)SurNurMandYNJsonArr.get(i);
			anes_proc_start_end_time_yn = (String) json.get("anes_proc_start_end_time_yn");
			anes_start_end_time_yn = (String) json.get("anes_start_end_time_yn");
			surgery_start_end_time_yn = (String) json.get("surgery_start_end_time_yn");
			preparation_start_end_time_yn = (String) json.get("preparation_start_end_time_yn");
			record_surgeon_notes_yn = (String) json.get("record_surgeon_notes_yn");
			record_nursing_notes_yn = (String) json.get("record_nursing_notes_yn");
		}
		//End ML-MMOH-CRF-1936

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();	
		while(rst.next()){
			 ++index;
		sysdate1=rst.getString("sysdate1");
		if(sysdate1 ==null) sysdate1="";
		//out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(rst.getString("PREP_TIME"))+"','"+CommonBean.checkForNull(rst.getString("PROC_START_TIME"))+"','"+CommonBean.checkForNull(rst.getString("PROC_END_TIME"))+"','"+CommonBean.checkForNull(rst.getString("ANST_START_TIME"))+"','"+CommonBean.checkForNull(rst.getString("ANST_END_TIME"))+"','"+CommonBean.checkForNull(rst.getString("SUG_START_TIME"))+"','"+CommonBean.checkForNull(rst.getString("SUG_END_TIME"))+"','"+index+"','L'); </script>");	

		//if(isTimeDtlsSurNurAppl){
			
		//out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PREP_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PRE_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PRE_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_END_TIME"),"DMYHM","en",locale))+"','"+index+"','L'); </script>");
		//}else{
			
			//Added By Gaurav added for ML-BRU-SCF-2237
			out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PREP_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PRE_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PRE_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_END_TIME"),"DMYHM","en",locale))+"','"+index+"','L'); </script>");
			
			//out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PREP_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_END_TIME"),"DMYHM","en",locale))+"','"+index+"','L'); </script>");
			//com.ehis.util.DateUtils.convertDate(,"DMYHM","en",locale);
		//}
			
		}
		out.println("<script>assignRecId();</script>"); 
		out.println("<script>refresh()</script>");
	
	}catch(Exception e){
		System.err.println("NursingTimeRecord.jsp"+e.getMessage());
	}
	finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}


            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block50Bytes, _wl_block50);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(isTimeDtlsSurNurAppl){
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block60Bytes, _wl_block60);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(CommonBean.checkForNull(request.getParameter("tab_id"))));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(check_into_or_time));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(sysdate1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(anes_proc_start_end_time_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(anes_start_end_time_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(surgery_start_end_time_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(preparation_start_end_time_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(record_surgeon_notes_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(record_nursing_notes_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreparationTime.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaProcedureStartTime.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaProcedureEndTime.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaStartTime.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaEndTime.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Preparation.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Preparation.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgery.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProcedureStartTime.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgery.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProcedureEndTime.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
