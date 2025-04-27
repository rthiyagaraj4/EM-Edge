package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.security.*;
import webbeans.eCommon.*;
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __camaintitle extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainTitle.jsp", 1742378537642L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script>var pat_info = new Array();\nvar ph_info = new Array(); //IN066055\nvar screensize = screen.width; //IN057272\n</script> \n<script>\n/*IN32540 IE 9 fix starts  */\nfunction SelectedPatient1(patient_id,episode_id,visit_id,episode_type, location_code, location_type,option_id,pat_oth_dtls,window_obj, relationship_id,patient_security_level,patient_protection_ind)\n{\n\t\n\t\n\treturn new pat(patient_id,episode_id,visit_id,episode_type, location_code, location_type,option_id,pat_oth_dtls,window_obj, relationship_id,patient_security_level,patient_protection_ind); \n\n\t\n\t   \n}\n\nvar pat = function (patient_id,episode_id,visit_id,episode_type, location_code, location_type,option_id,pat_oth_dtls,window_obj, relationship_id,patient_security_level,patient_protection_ind){\n\t  this.patient_id\t\t\t\t=\tpatient_id\n\t   this.episode_id\t\t\t\t=   episode_id\n\t   this.visit_id\t\t\t\t=   visit_id\n\t   this.episode_type\t\t\t=   episode_type\n\t   this.location_code\t\t\t=   location_code\n\t   this.location_type\t\t\t=   location_type\n\t   this.option_id\t\t\t\t=   option_id\n\t   this.pat_oth_dtls\t\t\t=\tpat_oth_dtls\n\t   this.window_obj\t\t\t\t=   window_obj\n\t   this.relationship_id\t\t\t=\trelationship_id\n\t   this.patient_security_level\t=\tpatient_security_level\n\t   this.patient_protection_ind\t=\tpatient_protection_ind\n\t   this.winname\t\t\t\t\t=\tpatient_id+episode_id+visit_id;\n\t   if (window_obj){\n\t\t\twindow_obj.focus();   \n\t   }\n}\n/*32540 IE 9 fix Ends  */\n</script>\n<script>\n  /*function putSometexttoClipBoard(\n  {\n\t  var text = parent.window.clipboardData.getData(\"Text\");\n\t  \n\t // var text = navigator.clipboardData.getData(\"Text\");\n \n\t  if(text == \"\" || text == null)\n\t  {\n\t\tif(document.getElementById(\"clipTxtBtn\")!=null)\n\t\t{\n\t\t\tvar clipBoardVal=document.getElementById(\"clipTxtBtn\").createTextRange();\n\t\t\tclipBoardVal.select();\n\t\t\tclipBoardVal.execCommand(\"copy\",\"\",\"\");\n\t\t\tclipBoardVal.execCommand(\"Unselect\",\"\",\"\");\n\t\t}\n\t  }\n  }*/\n  function putSometexttoClipBoard() {\n    // Check if Clipboard API is supported\n    if (navigator.clipboard) {\n        // Trigger clipboard access in response to a user action, such as a button click\n        document.getElementById(\"clipTxtBtn\").addEventListener(\'click\', function() {\n            navigator.clipboard.readText().then(function(text) {\n                if (!text) {\n                    let clipTxtBtn = document.getElementById(\"clipTxtBtn\");\n                    if (clipTxtBtn) {\n                        // Create a temporary textarea to copy text\n                        let clipBoardVal = document.createElement(\'textarea\');\n                        clipBoardVal.value = clipTxtBtn.value;  // Assuming it\'s the text you want to copy\n                        document.body.appendChild(clipBoardVal);\n                        clipBoardVal.select();\n                        document.execCommand(\"copy\");\n                        document.body.removeChild(clipBoardVal);\n                        console.log(\"Text copied to clipboard\");\n                    }\n                } else {\n                    console.log(\"Text already present in clipboard: \" + text);\n                }\n            }).catch(function(err) {\n                console.error(\'Failed to read from clipboard: \', err);\n            });\n        });\n    } else {\n        console.error(\'Clipboard API is not supported in this browser.\');\n    }\n}\n\n\n</script>\n <head>\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<STYLE TYPE=\"text/css\">\n\tA.imageClass1 \n\t{\n\t\twidth:30px;\n\t\theight:28px;\n\t\tmargin-left:0;\n\t\tmargin-right:0;\n\t\tmargin-top:0;\n\t\tmargin-bottom:0;\n\t\tpadding-left:3px;\n\t\tpadding-right:3px;\n\t\tpadding-top:2px;\n\t\tpadding-bottom:1px;\n\t\tborder-top:0px;\n\t}\n\tA.imageClass2 \n\t{\n\t\tbackground-color:#FFFFFF;\n\t\twidth:30px;\n\t\theight:28px;\n\t\tmargin-left:0;\n\t\tmargin-right:0;\n\t\tmargin-top:0;\n\t\tmargin-bottom:0;\n\t\tpadding-left:2px;\n\t\tpadding-right:2px;\n\t\tpadding-top:2px;\n\t\tpadding-bottom:1px;\n\t\tborder-left:1px solid;\n\t\tborder-right:1px solid;\n\t\tBORDER-COLOR: #75768B;\n\t}\n\timg\n\t{\n\t\tborder:0;\n\t}\n\n\tTR.iconBarRow\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBG.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowBlue\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGBlue.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowLime\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGLime.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowOrange\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGOrange.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tTR.iconBarRowViolet\n\t{\n\t\tBACKGROUND-image: url(\'../../eCommon/images/toolBarBGViolet.jpg\');\n\t\twidth:1024;\n\t\theight:28px;\n\t\tborder-bottom:none;\n\t}\n\tIMG.imageClass\n\t{\n\t\tvertical-align: middle;\n\t}\n\n</STYLE>\n      <script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n      <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t  <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t  <script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t  <script src=\'../../eCA/js/CAMainMenuLookup.js\' language=\'javascript\'></script>\n\t  <script src=\'../../eCA/js/CACalculator.js\' language=\'javascript\'></script>\n\t  <script src=\'../../eCA/js/SwitchLanguage.js\' language=\'javascript\'></script>\n\t  <script src=\'../../eCA/js/SwitchBetPatChart.js\' language=\'javascript\'></script><!--IN32540 IE 9 Fix -->\n        ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n        ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n      <input type=\"hidden\" id=\"facility_id\"  name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'><!-- 32902  --> \n      <input type=\"hidden\" id=\"practitioner_id\"  name=\"practitioner_id\" id=\"practitioner_id\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'><!-- 32902  --> \n\t<script>\n\t\tvar patient_selected = false;\n\t\tvar encounter_selected = false;\n\t\tvar win_count = 0;\n\t\tvar modal_win = new Array();\n\t\tvar  firstwindow = top.window ;\n\t\tvar opener_win;\n\t\tif(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'==\"Y\" && \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" == \"N\")\n\t\t{\n\t\t\t////Bru-HIMS-CRF-016 for Genogram Start.[for Genogram]\n\t\t\t//firstwindow = top.opener.top\n\t\t\tif(top.opener!=null){\n\t\t\t\tfirstwindow = top.opener.top\n\t\t\t}else{\n\t\t\t\tfirstwindow = top\n\t\t\t}\n\t\t\t////Bru-HIMS-CRF-016 for Genogram End.[for Genogram]\n\t\t\tif(firstwindow.content != null)\n\t\t\t\tfirstwindow = firstwindow.content\n\t\t\tif(firstwindow.CommonToolbar != null)\n\t\t\t\tfirstwindow = firstwindow.CommonToolbar.firstwindow\n\t\t\t   top.opener = firstwindow\n\t\t}\n\n\t\tfunction displayFunctionName(name,id)\n\t\t{\n\t\t\tdispname.innerHTML = \"<b>\"+name+\"&nbsp;&nbsp;&nbsp;\"+\"</b>\";\n\t\t\tif(name==\"Practitioner Home Page\")\n\t\t\t{\n\t\t\t\tmyTask.style.display=\'inline\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tmyTask.style.display=\'none\';\n\t\t\t}\n\t\t\t\n\t\t//\tif(name == \"User Home - By Location\" || name == \"By Location\")\n\t\t//Below code added by Channaveer B on  08/07/2010.\n\t\t//\tif(id == \"BY_LOCATION\" || id==\'FLOW_SHEET\' || id==\'MEDICAL_CERTIFICATE\' || id==\'PREVIOUS_NOTES\'||id==\'CLINICAL_NOTES\'||id==\'DISCHARGE_SUMMARY\'||id==\'REFERRAL_LETTER\')\t  //IN27088 //Commented for IN061898\n\t\t\t//if(id == \"BY_LOCATION\" || id==\'FLOW_SHEET\' || id==\'MEDICAL_CERTIFICATE\' || id==\'PREVIOUS_NOTES\'||id==\'CLINICAL_NOTES\'||id==\'DISCHARGE_SUMMARY\'||id==\'REFERRAL_LETTER\'||id==\'CA_TASK_LIST\')\t  //Added task list for IN061898\n\t\t\tif(id == \"BY_LOCATION\" || id==\'FLOW_SHEET\' || id==\'MEDICAL_CERTIFICATE\' || id==\'PREVIOUS_NOTES\'||id==\'CLINICAL_NOTES\'||id==\'DISCHARGE_SUMMARY\'||id==\'REFERRAL_LETTER\'||id==\'CA_TASK_LIST\'||id==\'FLOW_SHEET_NEW\')\t  //Added IN069654\n\t\t\t{\n\t\t\t\tvar optlength = parent.CommonToolbar.filter.options.length;\n\t\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t\t{\n\t\t\t\t\tparent.CommonToolbar.filter.options.remove(\"filter\");\n\t\t\t\t}\n\t\t\t\t\n             \tfilter_by.style=\'display\';\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\t\t\txmlStr +=\" /></root>\" ;\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open( \"POST\",\"../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id=\"+id, false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tresponseText=xmlHttp.responseText;\n\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\teval(responseText);\t\t\t\t\n\t\t\t\t//parent.CommonToolbar.filter.options.remove(\"filter\");\t //IN27088\n\t\t\t}\n\t\t\t/*else\n\t\t\t{\n\t\t\t\tfilter_by.style.display=\'none\';\n\t\t\t}*/\n\t\t\t//ends here.\n\t\t\t//IN065889 starts\n\t\t\tif(name== \"Record External Clinical Notes\" || name == \"Record Charts\")\n\t\t\t\tfilter_by.style.display=\'none\';\n\t\t\t//IN065889 ends\n\t\t}\n\n\t\tfunction recordView(obj)\n\t\t{\n\t\t\tvar qs = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'\n\t\t\tif(obj.id == \'R\')\n\t\t\t{\n\t\t\t\tobj.id=\'V\';\n\t\t\t\tobj.value = \'Chart Recording\';\n\t\t\t\tif(qs.indexOf(\'mode=R\')>=0)\n\t\t\t\t\tqs= qs.replace(\'mode=R\',\'mode=V\');\n\t\t\t\ttop.content.Options1.location.href = \'CAMainOptions1.jsp?\'+qs;\t\n\t\t\t}\n\t\t\telse if(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' == \'R\')\n\t\t\t{\n\t\t\t\tobj.id=\'R\';\n\t\t\t\tobj.value = \'Chart History\';\n\t\t\t\tif(qs.indexOf(\'mode=V\')>=0)\n\t\t\t\t\tqs= qs.replace(\'mode=V\',\'mode=R\');\n\t\t\t\ttop.content.Options1.location.href = \'CAMainOptions1.jsp?\'+qs;\n\t\t\t}\n\t\t}\n\n\n\t\tasync function PatientSearch()\n\t\t{\t\n\t\t\tvar episodeid = \'\';\n\t\t\tvar patientid=await PatientSearchWithDefaultGender_new(\'\',\'\');\n\t         \tvar facility_id=document.getElementById(\"facility_id\").value;//32902\n\t         \tvar practitioner_id=document.getElementById(\"practitioner_id\").value;//32902\n\t\t\tif(patientid !=null && patientid!=\'\')\n\t\t\t{  //32902 start\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t xmlStr += \" p_action=\\\"IS_PAT_RESTRICTED\\\"\";\n\t\t\t\t xmlStr += \" facility_id=\\\"\"+ facility_id + \"\\\" \";\n\t\t\t\t xmlStr += \" patientid=\\\"\"+ patientid + \"\\\" \";\n\t\t\t\t xmlStr += \" practitioner_id=\\\"\"+ practitioner_id + \"\\\" \";\n\t\t\t\t xmlStr +=\" /></root>\";\n\t\t\t\t var temp_jsp=\"../../eCA/jsp/CAGetAcccessRightPatientDtl.jsp\";\n\t\t\t\t var xmlDoc = \"\" ;\n\t\t\t\t var xmlHttp = new XMLHttpRequest() ;\n\t\t\t\t xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t xmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\t\t xmlHttp.send(xmlDoc);\n\t\t\t\t var responseText = xmlHttp.responseText;\n\t\t\t\t var response = trimString(xmlHttp.responseText);\n\t\t         if(response == \"Y\"){\n\t\t\t\t alert(getMessage(\"AC_RSTR_PAT_LMT_AUT\",\"CA\")); \n\t\t\t\t return;\n\t\t\t\t } \n\t\t         //32902  end\n\t\t         document.PatSearchFrm.patient_id.value=patientid;\n\t\t\t     document.PatSearchFrm.submit();\n\t\t\t}\n\t\t}\n\n\t    async function PatientSearchWithDefaultGender_new(defaultgender, enablegenderyn) \n\t\t{\n\t\t\twindow_styl=\'O\';\n\t\t\tclose_yn=\'Y\';\n\t\t\tjsp_name=\'\';\n\t\t\twin_top= \'61\';\n\t\t\twin_height= \'37\';\n\t\t\twin_width= \'50\';\n\t\t\tact_yn= \'N\';\n\t\t\tregister_button_yn = \'N\';\n\t\t\tfunc_act=\'VIEW\';\n\t\t\tsrr=\'Y\';\n\n\t\t\twindow_styl = window_styl.toUpperCase();\n\t\t\tclose_yn = close_yn.toUpperCase();\n\t\t\tact_yn = act_yn.toUpperCase();\n\t\t\t//if(confirm_yn)\n\t\t\t{\n\t\t\t\tvar url     = \"../../eMP/jsp/ModelPatientSearch.jsp?jsp_name=\"+jsp_name+\"&window_styl=\"+window_styl+\"&close_yn=\"+close_yn+\"&win_top=\"+win_top+\"&win_height=\"+win_height+\"&win_width=\"+win_width+\"&act_yn=\"+act_yn+\"&srr=\"+srr+\"&register_button_yn=\"+register_button_yn+\"&func_act=\"+func_act+\"&default_gender=\"+defaultgender+\"&enable_gender_yn=\"+enablegenderyn+\"&suspend_inactive_patient_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\tvar dialogTop   = \"10px\";\n\t\t\t\tvar dialogHeight    = \"600px\" ;\n\t\t\t\tvar dialogWidth = \"900px\" ;\n\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop + \"; status: no\" ;\n\t\t\t\tvar returnval = await window.showModalDialog( url, arguments, features ) ;\n\t\t\t\treturn returnval;\n\t\t\t}\n\t\t}\n\t\t\n           \n\t\t\n\n\t\tfunction MM_preloadImages()\n\t\t{ \n\t\t\tvar d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();\n\t\t\tvar i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)\n\t\t\tif (a[i].indexOf(\"#\")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}\n\t\t}\n\n\t\tfunction MM_swapImgRestore()\n\t\t{ \n\t\t\tvar i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;\n\t\t}\n\n\t\tfunction MM_findObj(n, d)\n\t\t{\n\t\t\tvar p,i,x;  if(!d) d=document; if((p=n.indexOf(\"?\"))>0&&parent.frames.length) {\n\t\t\td=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}\n\t\t\tif(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];\n\t\t\t for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);\n\t\t\tif(!x && d.getElementById) x=d.getElementById(n); return x;\n\t\t}\n\n\t\tfunction MM_swapImage()\n\t\t{\n\t\t\tvar i,j=0,x,a=MM_swapImage.arguments;\n\t\t\tdocument.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)\n\t\t\tif ((x=MM_findObj(a[i]))!=null)\n\t\t\t{\n\t\t\t  document.MM_sr[j++]=x; \n\t\t\t  if(!x.oSrc) x.oSrc=x.src; \n\t\t\t  x.src=a[i+2];\n\t\t\t}\n\t\t}\n\t\t\n\t\tfunction closeFunction(childyn,wname,flag)\n\t\t{\t\t\t\n\t\t\ttop.content.messageFrame.document.write(\"<html><body><form name=\'openChartWrapperIntermediateForm\' id=\'openChartWrapperIntermediateForm\' method=\'post\' action=\'../../eCA/jsp/OpenChartWrapperIntermediate.jsp\'><input type=\'hidden\' name=\'patientID\' id=\'patientID\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'><input type=\'hidden\' name=\'episodeID\' id=\'episodeID\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'><input type=\'hidden\' name=\'child_window\' id=\'child_window\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'><input type=\'hidden\' name=\'FromPatChart\' id=\'FromPatChart\' value=\'\'><input type=\'hidden\' name=\'FromCloseOrSwitch\' id=\'FromCloseOrSwitch\' value=\'Close\'><input type=\'hidden\' name=\'windName\' id=\'windName\' value=\'\"+wname+\"\'></form></body></html>\");\n\t\t\ttop.content.messageFrame.openChartWrapperIntermediateForm.submit();\n\t\t}\n\n\t\tfunction ShowPats(FromPatChart)\n\t\t{\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" /* IN32540 IE 9 Fix  */\n\t\t\t//IN32540\n\t\t \tshowPatientInfo(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');  \n\t\t}\n//IN061891 starts\n\t\tfunction addPersonalise(FromPatChart)\n\t\t{\n\t\t\tdocument.getElementById(\'ppatlist\').style.display=\"none\";\n\t\t\tdocument.PersonalisePatient.submit();\n\t\t}\n//IN061891 Ends\n\t</script>\n\t\n\t<title>eHIS ver10.2 - [";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" - ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="]</title>\n\n</head>\n<body class=\"COMMON_TOOLBAR\" leftmargin=0 topmargin=0 onKeyDown=\"lockKey()\" OnMouseDown=\'CodeArrest()\' \n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\tonunload=\'hideLookupButtonOnX()\'\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\tonunload =\'closeAllLookups()\' onfocus=\'alignLookupButtons()\'\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\tonload=\"MM_preloadImages(\'\',\'../../eCA/images/MI_SwitchT1.gif\',\'../../eCA/images/MI_CloseT1.gif\');\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\tputSometexttoClipBoard()\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\n\t\t\">\n\n<!-- <form name=\'CAMainTitleForm\' id=\'CAMainTitleForm\' >-->\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\n\n<table width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n    <tr class=\'iconBarRow";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\n\t\t\t<td width=\'96%\'>&nbsp;</td>\n\t\t\t<td width=\'1%\'>&nbsp;</td>\n\t\t\t<td align=\'center\' width=\'3%\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\n\t\t\t<td width=\'96%\'>\n\t\t\t&nbsp;\n\t\t\t</td>\n\t\t\t<td width=\'1%\'>\n\t\t\t<img class=\'imageClass\' id=\'seperator\' src=\'../../eCA/images/MI_htStrip";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =".gif\' alt=\'\'></img></td>\n\t\t\t<td align=\'center\' width=\'3%\'>\n\t\t\t\t<a href=\"#\" name=\'History\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' >\n\t\t\t\t\t<img onclick=\"loadOrUnloadLookup(this)\" name=\'HideAndShowLookup\' accesskey=\'L\' title=\'History\' src=\'../../eCA/images/mc_history.gif\'></img>\n\t\t\t\t</a>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<td width=\'5%\'>\n\t\t\t\t<input type=\'button\' name=\'clipTxtBtn\' id=\'clipTxtBtn\' style=\'display:none\' value=\'Clip Text\'>\n\t\t\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t\t<tr class=\'iconBarRow";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t<td><a href=\"#\" name=\'Menu\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'><img align=\'center\' src=\'../../eCA/images/MI_Show.gif\' name=\'ShowMenu\' style=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onclick=\"loadOrUnloadMenus(this)\" accesskey=\'M\' alt=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' title=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'></img>\n\t\t\t\t\t\t<img align=\'center\' src=\'../../eCA/images/MI_Hide.gif\' name=\'HideMenu\' style=\'display:none\'  onclick=\"loadOrUnloadMenus(this)\" accesskey=\'M\' alt=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'> </img></a></td>\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\n\t\t\t\t\t\t\t<td id=\"home\" class=\'iconBarRow";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'><a href=\"#\" name=\'Home\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'><img onclick=\"loadHomePage(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' ,loadOrUnloadMenus(document.ShowMenu))\" id=\'searchPatHome\' src=\'../../eCA/images/MI_Home.gif\' align=\'center\' alt= \'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'></img></a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t<td class=\'iconBarRow";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><a href=\"#\" name=\'Patient\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'><img align=\'center\' onclick=\"PatientSearch()\"  src=\'../../eCA/images/MI_SearchPatient.gif\' alt=\'Patient Search\'  title=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' ></img></a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'><a href=\"#\" name=\'ClinicalCalc\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'><img align=\'center\' src=\'../../eCA/images/MI_ClinicalCalc.gif\' onclick=\"callCalculator()\" alt=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<td ><img align=\'center\' name=\'divider\' id=\'divider\' src=\'../../eCA/images/MI_htStrip";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =".gif\' alt=\'\' ></img></td>\t\n\t\t\t\t\t<td id=\'refreshIcons\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- IN0052635 starts-->\n\t\t\t\t\t<!--<td><a href=\"#\" name=\'RightStripImg\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'RightStrip1\',\'\',\'../../eCA/images/MI_RightStrip1";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =".gif\',1)\"><img src=\"../../eCA/images/MI_RightStrip2";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =".gif\" alt=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' name=\"RightStrip1\"  border=\"0\" id=\"RightStrip1\" onclick=\'customizeIcons()\' style=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' /></a></td>-->\n\t\t\t\t\t<td><a href=\"#\" name=\'RightStripImg\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'RightStrip1\',\'\',\'../../eCA/images/MI_RightStrip1";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' /></a><input type=\'hidden\' name=\'totMenuDisplay\' id=\'totMenuDisplay\' value=\'\'></td>\n\t\t\t\t\t<!-- IN0052635 ends-->\n\t\t\t\t\t</tr></table>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'\' align=\'right\' width=\'40%\'><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr class=\'iconBarRow";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\t\t\t\t\t\t<td class=\'iconBarRow";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' align=\'right\' id=\'quick\' >\n\t\t\t\t\t\t<select name=\'quick_links\' id=\'quick_links\'  onchange=\'loadFunction(this)\' style=\'FONT-SIZE:8pt\'>\n\t\t\t\t\t\t<option value = \'\'>-----";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="-----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</option>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t<td><a href=\"#\" name=\'RightStripQL\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'RightStrip1\',\'\',\'../../eCA/images/MI_RightStrip1";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' name=\"RightStrip1\"  border=\"0\" id=\"RightStrip1\" onclick=\'UpdateResp()\' style=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' /></a>&nbsp;&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t<td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t<tr class=\'iconBarRow";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<img class=\'imageClass\' id=\'seperator\' src=\'../../eCA/images/MI_htStrip";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =".gif\' alt=\'\'\n\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\tstyle=\'display:none\'\n\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" \n\t\t\t\t\t\t\t></img><td>\n\t\t\t\t\t\t\t<td align=\'center\'>\n\t\t\t\t\t\t\t<a href=\"#\" name=\'History\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'  \n\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" \n\t\t\t\t\t\t\t><img onclick=\"loadOrUnloadLookup(this)\" name=\'HideAndShowLookup\' accesskey=\'L\' title=\'History\' src=\'../../eCA/images/mc_history.gif\'></img></a></td>\n\t\t\t\t\t\t\t<!--IN061891 Starts -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t<td align=\'center\' id=\"ppatlist\" style=\"\" >\n\t\t\t\t\t\t\t<a href=\"#\" name=\'Add Patient to Pat List\' class=\"imageClass1\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'\n\t\t\t\t\t\t\t><img onclick=\"addPersonalise(this)\" name=\'HideAndShowLookup\' accesskey=\'L\' title=\'Add Patient to Personalized List\' src=\'../../eCA/images/FavPatient.png\'></img></a></td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t<!--IN061891 Ends-->\n\t\t\t\t\t\t\t<!-- Added By : Arvind\n\t\t\t\t\t\t\t\tDate : 1/25/2010\n\t\t\t\t\t\t\t\tCRF  : PMG20089-CRF-429\n\t\t\t\t\t\t\t\tDiscription : Below code added for \"default select Filter criteria \". \n\t\t\t\t\t\t -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t<td><img onclick=\"switchLanguage(this, \'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\')\"  name=\'SwitchLanguage\' accesskey=\'L\' title=\'Switch Language\' src=\'../../eCA/images/SwitchLanguageicon.JPG\'\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t></img></a></td>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"cur_lang_id\" id=\"cur_lang_id\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"opt_lang_id\" id=\"opt_lang_id\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t\t\t\t<!-- End Here -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t <td><a href=\"#\" name=\"link0\" style=\"display:none\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' class = \'imageClass1\'><img align=\'center\' onclick=\'callWindow(0)\' src=\'../../eCA/images/mc_history_1.gif\' name=\'btn0\'></img></a></td>\n\t\t\t\t\t\t <td><a href=\"#\" name=\"link1\" style=\"display:none\" onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' class = \'imageClass1\'><img align=\'center\' onclick=\'callWindow(1)\' src=\'../../eCA/images/mc_history_2.gif\' name=\'btn1\'></img></td> \n\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n      \t\n\t\t<td align=\'right\' width=\'3%\'><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\'right\'>\n\t\t<tr class=\'iconBarRow";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t<td>\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t<img class=\'imageClass\' id=\'seperator\' src=\'../../eCA/images/MI_htStrip";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =".gif\' alt=\'\'></img>\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t&nbsp;\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t<td>\n\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t<td><img class = \'imageClass\' align=\'center\' onclick=\"ShowPats()\" src=\'../../eCA/images/MI_SwitchT1.gif\' alt=\'Switch\' title=\'Switch\' id=\'switch\' name=\'switch\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'switch\',\'\',\'../../eCA/images/MI_SwitchT2.gif\',1)\" style=\"margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;\"></img></td>\n\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t<td><img class = \'imageClass\' align=\'center\' src=\'../../eCA/images/MI_SwitchT1.gif\' onclick=\'getParentWindow()\' alt=\'Patient Chart\' title=\'Patient Chart\' id=\'pc\' name=\'pc\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'pc\',\'\',\'../../eCA/images/MI_SwitchT2.gif\',1)\" style=\"margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;\"></img></td>\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t<td>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\n\t\t\t\t<td><img class = \'imageClass\' align=\'center\' src=\'../../eCA/images/MI_CloseT1.gif\' onclick=\"closeFunction(\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\',\'Y\')\" alt=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' id=\'close\' name=\'close\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'close\',\'\',\'../../eCA/images/MI_CloseT2.gif\',1)\" style=\"margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;\"></img></td>\n\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t<td><img class = \'imageClass\' align=\'center\' src=\'../../eCA/images/MI_CloseT1.gif\' onclick=\'hideLookupButton()\' alt=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' id=\'cc\' name=\'cc\' onmouseout=\"MM_swapImgRestore()\" onmouseover=\"MM_swapImage(\'cc\',\'\',\'../../eCA/images/MI_CloseT2.gif\',1)\" style=\"margin-left:3px;margin-right:3px;margin-top:2px;margin-right:2px;\"></img></td>\n\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t</tr></table>\n\t\t</td>\n\n    </tr>\n</table>\n<table width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\t<tr>\n\t\t<td class=\'iconBarRow";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' id=\'dispname\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t\t<td class=\'iconBarRow";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' id=\'filter_by\' style=\'display:none\' align=\'right\'><img src=\"../../eCA/images/filter.gif\" name=\'filterImg\' alt=\'Filter\' title=\'Filter\' /> : <select name=\'filter\' id=\'filter\' onchange=\'loadFilterFunction(this)\'><option value=\'\'>---";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="---</option></select><a href=\"#\"><img src=\"../../eCA/images/customize.gif\" alt=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' name=\"RightStrip1\"  border=\"0\" id=\"RightStrip1\" onclick=\'UpdateFilter()\' /></a>&nbsp;&nbsp;\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'\'><input type=\'hidden\' name=\'executable_path\' id=\'executable_path\' value=\'\'></td>\n\t\t<td class =\'LABELRIGHT\' id=\'myTask\' style=\'display:none\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="&nbsp;";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A href=\'javascript:refresh();\'><u>";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</u></A></td>\n\t</tr>\n</table>\n\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n<form name=\'appt\' id=\'appt\'>\n    <input type=\'hidden\' name=\'reviseparams\' id=\'reviseparams\'>\n    <input type=\'hidden\' name=\'reviseref\' id=\'reviseref\'>\n</form>\n<form name=\'refForm\' id=\'refForm\'>\n\t<input type=\"hidden\" name = \"ref_patient_id\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t<input type=\"hidden\" name = \"nursing_unit\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\n\t<input type=\"hidden\" name = \"ref_episode_id\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t<input type=\"hidden\" name = \"queryString\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t<input type=\"hidden\" name = \"bed_patient_id\" value=\"\">\n</form>\n\n<form name=\'pat_info\' id=\'pat_info\'>\n    <input type=\'hidden\' name=\'patientId\' id=\'patientId\'>\n    <input type=\'hidden\' name=\'visitId\' id=\'visitId\'>\n    <input type=\'hidden\' name=\'episodeId\' id=\'episodeId\'>\n    <input type=\'hidden\' name=\'locationCode\' id=\'locationCode\'>\n    <input type=\'hidden\' name=\'locationType\' id=\'locationType\'>\n    <input type=\'hidden\' name=\'pat_info\' id=\'pat_info\'>\n\t<input type=\'hidden\' name=\'window_name\' id=\'window_name\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t<input type=\'hidden\' name=\'lookup_window_name\' id=\'lookup_window_name\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n</form>\n<form name=\'PatSearchFrm\' id=\'PatSearchFrm\' action=\'OpenChartWrapper.jsp\' method = \'post\' target=messageFrame>\n    <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'>\n    <input type=\'hidden\' name=\'episode_visit_id\' id=\'episode_visit_id\'>\n    <input type=\'hidden\' name=\'episode_id\' id=\'episode_id\'>\n    <input type=\'hidden\' name=\'from_function\' id=\'from_function\' value=\'M\'>\n</form>\n<!-- IN061891 Starts -->\n<form name=\'PersonalisePatient\' id=\'PersonalisePatient\' action=\'../../servlet/eCA.PersonalisePatListServlet\' method = \'post\' target=messageFrame >\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t<input type=\'hidden\' name=\'login_id\' id=\'login_id\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t<input type=\'hidden\' name=\'resp_id\' id=\'resp_id\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t<input type=\'hidden\' name=\'system_id\' id=\'system_id\' value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\"><!--IN061891-->\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'insert\'>\n</form>\n<!-- IN061891 ends-->\n<form name=\'homePageParam\' id=\'homePageParam\' >\n    <input type=\'hidden\' name=\'layout_value\' id=\'layout_value\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n    <input type=\'hidden\' name=\'desktod_id\' id=\'desktod_id\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n    <input type=\'hidden\' name=\'dfltFunctionId\' id=\'dfltFunctionId\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t<!-- Added By Arvind For ICN-22310   -->\n\t <input type=\'hidden\' name=\'menuId\' id=\'menuId\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>  \n</form>\n<input type=\'hidden\' name=\'toolbarQueryString\' id=\'toolbarQueryString\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'><!--IN057446-->\n<!--<input type=\'hidden\' name=\'menuId\' id=\'menuId\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>  <!--ICON_COUNT_ISSUE--> <!-- IN058755 commented for the script error -->\n</body>\n<script>\n\nasync function customizeIcons()\n{\t\n\tvar dialogHeight= \"92vh\" ;\n\tvar dialogWidth\t= \"26vw\" ;\n\tvar dialogTop\t= \"0vh\";\n\tvar dialogLeft\t= \"0vw\";\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\" ;dialogLeft=\"+dialogLeft+\";scroll=no; status:no;help:no \";\n\t\n\tvar totMenuDisplay\t=\tparent.CommonToolbar.totMenuDisplay.value; //IN0052635\n\t\n\t//IN0052635 starts\n\t//var ret = window.showModalDialog(\"../../eCA/jsp/CAMainCustomizeToolbar.jsp?";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="&menuId=";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="&patientclass=";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\",arguments,features);\n\tvar ret = await window.showModalDialog(\"../../eCA/jsp/CAMainCustomizeToolbar.jsp?";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="&totMenuDisplay=\"+totMenuDisplay,arguments,features);\n\t//IN0052635 ends\n\t\n\tif(ret != \'\' && ret != undefined)\n\t{\n\t\t//alert(getMessage(\"RECORD_INSERTED\",\"CA\"));\n\t\tdisplayIcons(ret);\n\t}\n}\nfunction displayIcons(tableVal)\n{\n\ttableVal = tableVal.replace(/~/g,\'\"\');\n\n\trefreshIcons.innerHTML = tableVal;\n\n}\nasync function UpdateResp()\n{\t\n\t/*\n\tvar dialogHeight= \"31\" ;\n\tvar dialogWidth\t= \"35\" ;\n\tvar dialogTop\t= \"150\";\n\tvar dialogLeft\t= \"200\";\n\t*/\n\n\tvar dialogHeight= \"65vh\" ;\n\tvar dialogWidth\t= \"35vw\" ;\n\tvar dialogTop\t= \"0vh\";\n\tvar dialogLeft\t= \"0vw\";\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\" ;dialogLeft=\"+dialogLeft+\";scroll=no; status:no \";\n\n\tvar ret = window.showModalDialog(\"../../eCA/jsp/QuickLinksForRespCustomize.jsp?";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="&link_type=Q&patientclass=";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\",arguments,features);\n\t\n\tif(ret != \'\' && ret != undefined)\n\t{\n\n\t\tif(parent.CommonToolbar.quick_links != null)\n\t\t{\n\t\t\tvar optlength = parent.CommonToolbar.quick_links.options.length;\n\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t{\n\t\t\t\tparent.CommonToolbar.quick_links.options.remove(\"quick_links\");\n\t\t\t}\n\t\t\tvar HTMLVal=\"<html><body><form name=\'QuickLinksUpdateDescForm\' id=\'QuickLinksUpdateDescForm\' method=\'post\' action=\'../../eCA/jsp/QuickLinksForRespUpdateDesc.jsp?";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\"+\n\t\t\t\"</form></body></html>\";\n\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\tparent.messageFrame.document.QuickLinksUpdateDescForm.submit();\n\t\t}\n\t}\n}\nasync function UpdateFilter()\n{\n\tvar function_id = parent.CommonToolbar.function_id.value;\n\t/*\n\tvar dialogHeight= \"31\" ;\n\tvar dialogWidth\t= \"35\" ;\n\tvar dialogTop\t= \"150\";\n\tvar dialogLeft\t= \"200\";\n\t*/\n\n\tvar dialogHeight= \"65vh\" ;\n\tvar dialogWidth\t= \"35vw\" ;\n\tvar dialogTop\t= \"0vh\";\n\tvar dialogLeft\t= \"0vw\";\n\tvar arguments\t= \"\" ;\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\" ;dialogLeft=\"+dialogLeft+\";scroll=no; status:no \";\n\n\tvar ret = await window.showModalDialog(\"../../eCA/jsp/QuickLinksForRespCustomize.jsp?function_id=\"+function_id+\"&";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="&link_type=F\",arguments,features);\n\t\n\tif(ret != \'\' && ret != undefined)\n\t{\n\t\tif(parent.CommonToolbar.filter != null)\n\t\t{\n\t\t\tvar optlength = parent.CommonToolbar.filter.options.length;\n\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t{\n\t\t\t\tparent.CommonToolbar.filter.options.remove(\"filter\");\n\t\t\t}\n\t\t\t\t\n\t\t\tparent.messageFrame.document.addEventListener(\'DOMContentLoaded\', function() {\n\t\t\t\tvar HTMLVal=\"<html><body><form name=\'QuickLinksUpdateDescForm\' id=\'QuickLinksUpdateDescForm\' method=\'post\' action=\'../eCA/jsp/QuickLinksForRespUpdateFilter.jsp\'>\"+\n\t\t\t\t\"<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'\"+function_id+\"\'>\"+\n\t\t\t\t\"</form></body></html>\";\n\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\t\tparent.messageFrame.document.QuickLinksUpdateDescForm.submit();\n\t\t\t});\n\t\t}\n\t}\n}\n</script>\n\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t<script>\n\t//var screensize = screen.width; //IN057229 //IN057272 commented and created globally\n\t\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\n\t\t//IN057229 starts //parent.menuFrame.location.href=\'../../eCA/jsp/CAMainMenu.jsp?locale=";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="&";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="&limit_function_id=";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\';\n\t\tparent.menuFrame.location.href=\'../../eCA/jsp/CAMainMenu.jsp?locale=";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="&screensize=\'+screensize;\n\t\t//IN057229 ends\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t//parent.workArea.cols = \'200px,0%,*,0%\';\n\t\t\n\t\tloadOrUnloadMenus(document.ShowMenu);\n\t\t//IN057229 starts\n\t\t//parent.menuFrame.location.href=\'../../eCA/jsp/CAMainMenuHome.jsp?locale=";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="&layoutValue=";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="&dfltFunctionId=";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="&deskTopID=";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\';\n\t\tparent.menuFrame.location.href=\'../../eCA/jsp/CAMainMenuHome.jsp?locale=";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t        \n\t\t\tparent.lookupMenuFrame.location.href=\'../../eCA/jsp/CAMainLookupMenu.jsp?";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\';\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t//document.getElementById(\"HideAndShow\").value = \'Show Menu\';\n\t\t\t\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t</script>\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t<script>\n\t\t\n\t\tfunction loadWorkArea()\n\t\t{\t\n\t\t\ttop.content.workAreaFrame.location.href=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="?";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\';\n\t\t\t//alert(top.content.workAreaFrame.location.href);\n\t\t}\n\t\tsetTimeout(\"loadWorkArea()\",750);\n\t\tgetChartWindow(\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"); //to get the chart window object\n\t\tmakeLookupButtonsVisible(\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"); // to make the lookup buttons visible\n\t\tparent.CommonToolbar.displayFunctionName(\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\");\n\t\tif(parent.CommonToolbar.filter_by != null)\n\t\t{\n\t\t\tif(\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' == \'Clinical Event History\')\n\t\t\t{\n\t\t\t\tparent.CommonToolbar.filter_by.style=\'display\';\n\t\t\t\tvar optlength = parent.CommonToolbar.filter.options.length;\n               // alert(\"here\"+optlength);\n\t\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t\t{\n\t\t\t\t\tparent.CommonToolbar.filter.options.remove(\"filter\");\n\t\t\t\t}\n\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\t\t\txmlStr +=\" /></root>\" ;\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open( \"POST\",\"../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id=FLOW_SHEET\", false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tresponseText=xmlHttp.responseText;\n\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\teval(responseText);\n\n\t\t\t\t/*var HTMLVal=\"<html><body><form name=\'CAMainFunctionFilterForm\' id=\'CAMainFunctionFilterForm\' method=\'post\' action=\'../../eCA/jsp/CAMainFunctionFilterCriteria.jsp\'>\"+\n\t\t\t\t\"<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'FLOW_SHEET\'>\"+\n\t\t\t\t\"</form></body></html>\";\n\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\t\t\tparent.messageFrame.document.CAMainFunctionFilterForm.submit(); */\n\t\t\t}\n\t\t\t//IN069654 starts\n\t\t\telse if(\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' == \'New Clinical Event History\')\n\t\t\t{\n\t\t\t\t\n\t\t\t\tparent.CommonToolbar.filter_by.style=\'display\';\n\t\t\t\tvar optlength = parent.CommonToolbar.filter.options.length;\n\t\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t\t{\n\t\t\t\t\tparent.CommonToolbar.filter.options.remove(\"filter\");\n\t\t\t\t}\n\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\t\t\txmlStr +=\" /></root>\" ;\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open( \"POST\",\"../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id=FLOW_SHEET_NEW\", false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tresponseText=xmlHttp.responseText;\n\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\teval(responseText);\n\n\t\t\t}\n\t\t\t//IN069654  ends\n\t\t\t//IN051294 start\n\t\t\telse if(\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' == \'View Clinical Notes\')\n\t\t\t{\n\t\t\t\tparent.CommonToolbar.filter_by.style=\'display\';\n\t\t\t\t\n\t\t\t\tvar optlength = parent.CommonToolbar.filter.options.length;\n              \n\t\t\t\tfor (var i=0; i<optlength; i++)\n\t\t\t\t{\n\t\t\t\t\tparent.CommonToolbar.filter.options.remove(\"filter\");\n\t\t\t\t}\n\n\t\t\t\tvar xmlDoc=\"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\t\t\txmlStr +=\" /></root>\" ;\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open( \"POST\",\"../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id=PHYSICIAN_NOTES\", false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tresponseText=xmlHttp.responseText;\n\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\teval(responseText);\n\t\t\t}\n\t\t\t//IN051294 ends\n\t\t\telse\n\t\t\t\tparent.CommonToolbar.filter_by.style.display = \'none\';\n\t\t}\n\n\t\ttop.window.document.title = \"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\"\n\n\t</script>\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t<script>\n\t\t\ttop.window.document.title = \"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" ver";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =" - [ ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" ]\"\n\t\t</script>\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t<script>\n\t\t\t\ttop.window.document.title = \"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 =" for the patient ";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"\n\t\t\t</script>\n";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n<script>\n\tif(parent.mainFrameSet != null && \'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' != \'\')\n\t\tparent.mainFrameSet.rows = \'8%,95%,5%,0%\';\t\t\n</script>\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );
	
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

/*
--------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
?            	100            		?           								created
10/14/2011	 	IN27088			Dinesh T										Changed for displaying the quick link onload
																				of that particular function
05/12/2011	  	IN29822			MenakaV	 										For quick link & filter when Ist time 
																				resposibility is assigned its taking all links. After logging it shows only 2 responsibilty.
07/09/2012	  	IN32540			Nijitha S										IE 9 is creating an issue in the CA 	
																				module 										 
28/01/2013		IN036367		Dinesh T										Global level filter is changed to filter 
																				the data							 
06/08/2013		IN036733		Nijitha											Bru-HIMS-CRF-328 
15/10/2013		IN044083		Ramesh G										Genogram - Click on index patient - 
																				The Clinical Event History window opens - Click on 'Close Chart' icon	
26/08/2015		IN0052635		Vijayakumar K	26/08/2015		Ramesh Goli		PMG2014-CRF-0020 [IN:052635]
28/08/2015		IN057229		Vijayakumar K	28/08/2015		Ramesh Goli		Regression-EM-Alpha-Unable to access 
01/08/2015		IN057272		Vijayakumar K	01/08/2015						Practitioner Desktop/Patient Chart->
																				Click on Home Page icon->Expect first 4 icons the other icons disappear in Practitioner Desktop
09/10/2015		IN057446		Vijayakumar K									PMG2014-CRF-0020.1 [IN:057446]
29/12/2015	ICON_COUNT_ISSUE	Vijayakumar K	29/12/2015		Ramesh Goli		Icon count improper
30/12/2015		IN058755		Vijayakumar K	30/12/2015		Ramesh Goli			Regression-CRF-CA-PMG2014-CRF-0020.1/01- 
																					System does not respond when "Home" Button is pressed in CA-Desk Top. [IN:058755] 
21/12/2015      IN058149    Mukesh M											When opening patient chart from manage patient queue function, clock icon (clinical history) and 
																				clinical calculator is missing.
18/03/2016	 	IN059659		Karthi												Webpage cannot be found error appears when clicking list of option from history menu.		
20/01/2017		IN061898		Raja S			23/01/2017		Ramesh G		ML-MMOH-CRF-0550
15/03/2017		IN051294		Krishna Gowtham J									MO-CRF-20087
27/07/2017		IN061891		Raja S			27/07/2017		Ramesh G		ML-MMOH-CRF-0543
28/11/2017		IN065889		Raja S			28/11/2017		Ramesh G		CA-ML-MMOH-CRF-0824/03-Record External Clinical Note
12/02/2018		IN066055		Raja S			12/02/2018		Ramesh 			ML-MMOH-CRF-0891.2
07/02/2019		IN069654	   sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
03/02/2022		IN27710	       Suji Keerthi G 	03/02/2022		Ramesh G			GHL-CRF-0658
09/02/2022		IN28627	       Suji Keerthi G 	09/02/2022		Ramesh G			CA-GHL-CRF-0658/01-Quick Link
11/02/2022		IN28689	       Suji Keerthi G 	11/02/2022		Ramesh G			CA-GHL-CRF-0658/02-Quick Link Parameter in External URL
02/06/2022		31884			Ramesh Goli			02/06/2022	Ramesh G 	MMS=DM-CRF-0208
21/05/2023		44162			Ramesh Goli			21/02/2023	Ramesh G	ML-BRU-SCF-2224
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
--------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            eCA._ca_license_rights keyGen= null;{
                keyGen=(eCA._ca_license_rights)pageContext.getAttribute("keyGen");
                if(keyGen==null){
                    keyGen=new eCA._ca_license_rights();
                    pageContext.setAttribute("keyGen",keyGen);
                    _bw.write(_wl_block8Bytes, _wl_block8);

                }
            }
            _bw.write(_wl_block9Bytes, _wl_block9);

			
			try
			{
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

			String locale					=	(String) p.getProperty("LOCALE");
			String  suspendInactivePatientYN ="N"; //31884
			String client_ip_address = p.getProperty("client_ip_address");//IN061891
			String addFavPatientIcon = "N";//IN061891
			String queryStringForChart		=	request.getQueryString() == null ? "" : request.getQueryString();		String executable_name = "";	
			String strSql					=	"";
			String patient_name				=	"";	
			StringBuffer strBuffPatientInfo = new StringBuffer();
			String productName = "";
			String versionNum = "";
			String respid= (String) session.getValue("responsibility_id");
			 if(respid == null) respid="";
			String lookup_window_name = request.getParameter("lookup_window_name")==null?"":request.getParameter("lookup_window_name");
			
			String function_display_name = request.getParameter("function_display_name")==null?"":request.getParameter("function_display_name");
			String window_name = request.getParameter("window_name")==null?"":request.getParameter("window_name");
			String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
			String from_service_yn = request.getParameter("from_service_yn")==null?"N":request.getParameter("from_service_yn");
			String strRelnYn		= request.getParameter("RelnYn")==null?"Y":request.getParameter("RelnYn");
			String Genotitle		= request.getParameter("Genotitle")==null?"N":(String)request.getParameter("Genotitle");
			if (from_service_yn.equals("") )
				from_service_yn="N";
			String accession_type = request.getParameter("accession_type")==null?"":request.getParameter("accession_type");
			//IN059659 - Start
			if("RL".equalsIgnoreCase(accession_type) || "RD".equalsIgnoreCase(accession_type)) {
				from_service_yn = "Y";
			} else {
				from_service_yn = "N";
			}
			//IN059659 - End
			String limit_function_id = request.getParameter("limit_function_id")==null?"":request.getParameter("limit_function_id");
			String chartTitle = request.getParameter("chartTitle")== null?"":request.getParameter("chartTitle");
            String name=(String)session.getValue("practitioner_name");
			String practitioner_id	= (String) session.getValue("ca_practitioner_id"); 
			String pract_type =(String) session.getValue("practitioner_type");
			String menu_Active = "N";

			String dektop_params="";
			String layout_value="";
			String desktod_id="";
			String dfltFunctionId="";			
			String cur_lang_id="";	
			String opt_lang_id="";	
			String nric_code = "";
			String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");//IN061891
			String login_user = (String)session.getValue("login_user") == null ? "" : (String)session.getValue("login_user");//IN061891
			String archivalYN = request.getParameter("archivalYN") == null ? "N" : request.getParameter("archivalYN"); //52176
			int langListSize=0;
			String age="",sex="",visit_type="",visittype_desc=""; //IN28627 //IN28689
			Connection con=null;

			/* Added By : Arvind
				  Date : 1/25/2010
				  CRF  : PMG20089-CRF-429
				  Discription : Below code added for "default select Filter criteria ". 
			 */
			PreparedStatement stmt=null; 
			ResultSet rst=null;
			Map<String,String> langList =null;
			try{
				langList = new HashMap<String,String>();		
				cur_lang_id = locale;
				String sqlStr="select LANGUAGE_ID,SHORT_NAME from SM_LANGUAGE WHERE EFF_STATUS='E' and LANGUAGE_ID != ?" ;
				con = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement(sqlStr);
				stmt.setString(1,locale);
				rst = stmt.executeQuery();
				//int k=0;
				while(rst.next())
				{ 
					langList.put(rst.getString("LANGUAGE_ID"),rst.getString("SHORT_NAME"));
				/* if(k==0)
					cur_lang_id=rst.getString("LANGUAGE_ID"); */								
					opt_lang_id=rst.getString("LANGUAGE_ID");
					//k++;					
				}				
				 langListSize=langList.size();	
				if(rst != null) rst.close();
				if(stmt != null) stmt.close();

			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			/*
				End Here 
			*/

			try{				
				//desktod_id ="DFLT_CADT";
				//layout_value="H";
				//dfltFunctionId="REV_PROV_APPT";
				con = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement("SELECT CA_GET_DESKTOP_DTL_FUN(?,?,?) DEKTOP_PARAMS FROM DUAL");
				stmt.setString(1,pract_type);
				stmt.setString(2,practitioner_id);	
				stmt.setString(3,respid );
				rst=stmt.executeQuery();
				while(rst.next())
				{ 
					 dektop_params= rst.getString("DEKTOP_PARAMS");
				}
						if (dektop_params==null ) dektop_params="";
		
				StringTokenizer token=new StringTokenizer(dektop_params,"|");
				if(token.hasMoreTokens())
				{
						desktod_id = token.nextToken();
						layout_value = token.nextToken();
						dfltFunctionId = token.nextToken();
				}
				
				if(rst != null) rst.close();
				if(stmt != null) stmt.close();
				}	
				catch(Exception ex)
				{	
					ex.printStackTrace();
				}	

				finally 
				{
					
					if(con != null) ConnectionManager.returnConnection(con,request);
				}
				
			//31884 Start.
			
			/* 32902  try{
				con = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement("SELECT SUSP_INACT_PAT_YN FROM CA_PARAM WHERE MODULE_ID='CA'");
				rst=stmt.executeQuery();
				while(rst.next())
				{ 
					 suspendInactivePatientYN= rst.getString("SUSP_INACT_PAT_YN");
				}
				if (suspendInactivePatientYN==null ) suspendInactivePatientYN="N";
		
				
				if(rst != null) rst.close();
				if(stmt != null) stmt.close();
			}catch(Exception ex){	
				ex.printStackTrace();
			}finally{
					
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			end 32902  */
			
			//31884 End 
            if(name == null) name="";
            String child_window = request.getParameter("child_window") ;			
            if(child_window == null) child_window="";

			if(!child_window.equals("Y") )
			{
				if(strRelnYn.equals("Y") )
				{
					HashMap tempPatMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());
					ArrayList tempPatList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());
					tempPatMap = new HashMap();
					tempPatList = new ArrayList();
					session.setAttribute("sessionMainMap"+session.getId(), new HashMap());
					session.setAttribute("sessionList"+session.getId(), new ArrayList());
				}
			 }

             String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
             String queryString = request.getQueryString()== null?"":request.getQueryString() ;
             String defmode = mode;
			 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			 String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
 			 String visit_id = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
			
			 String wname = patient_id+episode_id+visit_id; 

			 String nursing_unit = request.getParameter("location_code")==null?"":request.getParameter("location_code");

			 String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
			 String facility_id      = (String)session.getValue( "facility_id" ) ;
			 PreparedStatement pstmt=null,pstmtMenu=null;
			 ResultSet rs = null,rsMenu=null;			
			 String menu_id="MED_DFLT",patientclass="",speciality_code="";
			 StringBuffer detl_sql = new StringBuffer();
			 String relationcode="";

			 //relationcode = (String)session.getValue("relationship_id");
			 relationcode = request.getParameter("relationship_id");
			 if(relationcode == null) relationcode = "";
			 
			 String facilityName = "";

			 String styleMap = "";
			 if(sStyle.equals("IeStyleBlue.css"))
			 {
				styleMap = "Blue";
			 }
			 else if(sStyle.equals("IeStyleLime.css"))
			 {
				styleMap = "Lime";
			 }
			 else if(sStyle.equals("IeStyleOrange.css"))
			 {
				styleMap = "Orange";
			 }
			 else if(sStyle.equals("IeStyleVoilet.css"))
			 {
				styleMap = "Violet";
			 }
			 else
			 {
				styleMap = "";
			 }
			
			if(window_name.equals("") || window_name ==null)
			{
				window_name = patient_id+episode_id+visit_id;
			}
			
			try
			{
				con = ConnectionManager.getConnection(request);
					
				//String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");//IN061891
				//String login_user = (String)session.getValue("login_user") == null ? "" : (String)session.getValue("login_user");/IN061891

				pstmt = con.prepareStatement("select product_id,VERSION_NO from sm_installation");
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					productName = rs.getString("product_id");
					versionNum = rs.getString("VERSION_NO");
				}

				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();

				if(pstmt != null)pstmt.close();
				
				pstmt = con.prepareStatement("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id= ? ");

				pstmt.setString(1, locale);
				pstmt.setString(2, facility_id);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					facilityName = rs.getString("FACILITY_NAME");
				}
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				
				if(!patient_id.equals(""))
				{
					strSql="select DECODE (?,'en', c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,sex,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age  FROM mp_patient c where c.patient_id=?"; //IN28627
					pstmt = con.prepareStatement(strSql);
					pstmt.setString(1, locale);
					pstmt.setString(2, patient_id);
					rs = pstmt.executeQuery();

					while(rs.next())
					{
						patient_name = rs.getString(1);
						sex = rs.getString(2); //IN28627
						//IN28689-Starts
						if(sex.equals("M"))
							sex="Male";
						else if(sex.equals("F"))
							sex="Female";
						else if(sex.equals("U"))
							sex="Unknown";
						//IN28689-Ends
						age = rs.getString(3); //IN28627
					}
					if(rs != null)rs.close();
					if(pstmt != null)pstmt.close();
					//IN061891 starts
					try{
						String perListSQL = "Select CA_PERS_PAT_LIST_FLAG(?,?,?,?) PERSONALISE_ICON_FLG from dual";
						pstmt = con.prepareStatement(perListSQL);
						pstmt.setString(1, facility_id);
						pstmt.setString(2, patient_id);
						pstmt.setString(3, practitioner_id);
						pstmt.setString(4, episode_id);
						rs = pstmt.executeQuery();

						while(rs.next())
						{
							addFavPatientIcon = rs.getString(1);
						}
						if(rs != null)rs.close();
						if(pstmt != null)pstmt.close();
					
					}catch(Exception pl)
					{
						pl.printStackTrace();
					}
					//IN061891 ENds
				}

			
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(from_service_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(defmode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(suspendInactivePatientYN));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(queryStringForChart));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block25Bytes, _wl_block25);

		if(! lookupFileName.equals(""))
		{

            _bw.write(_wl_block26Bytes, _wl_block26);

		}
		else if(menu_Active.equals("N"))
		{

            _bw.write(_wl_block27Bytes, _wl_block27);

		}

            _bw.write(_wl_block28Bytes, _wl_block28);

		if(patient_id.equals(""))
		{

            _bw.write(_wl_block29Bytes, _wl_block29);

		}

            _bw.write(_wl_block30Bytes, _wl_block30);


	String spacesForImage = "";
	String altText = "Close Chart";
	StringBuffer option_id = new StringBuffer();
	String v_query_string = "";
	String splty_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	String reln_id	  = request.getParameter("relationship_id");
	if(reln_id == null) reln_id = "";
	StringBuffer sql = new StringBuffer();
	int Existance_Count = 0;
	

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block32Bytes, _wl_block32);

		System.out.println("---------archivalYN---------->"+archivalYN);
		System.out.println("---------limit_function_id---------->"+limit_function_id);
		//52176 Start.
		if(archivalYN.equals("Y")){
			
            _bw.write(_wl_block33Bytes, _wl_block33);

		}else if(!limit_function_id.equals("") && archivalYN.equals("S")){			
			
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block35Bytes, _wl_block35);

		//52176 End.				
		}else if(lookupFileName.equals("") && limit_function_id.equals(""))
		{
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block37Bytes, _wl_block37);

					if(menu_Active.equals("N") && lookupFileName.equals(""))
					{
				
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(limit_function_id.equals("")?"display":"display:none"));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

					}
					if(lookupFileName.equals("") && from_service_yn.equals("N"))
					{
												
				
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dfltFunctionId));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
				
					}	
					if(patient_id.equals(""))
					{
				
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

					}
					if(from_service_yn.equals("N") && lookupFileName.equals("")&& limit_function_id.equals(""))
					{
				
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

					}
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block52Bytes, _wl_block52);
 //=styleMap
            _bw.write(_wl_block53Bytes, _wl_block53);
 //=styleMap
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
 //=limit_function_id.equals("")?"display":"display:none"
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(limit_function_id.equals("")?"display":"display:none"));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block58Bytes, _wl_block58);

					if(lookupFileName.equals("") && limit_function_id.equals(""))
						{
					
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

						if (!episode_id.equals(""))
						{
							try
							{
								String strSqln1 = "SELECT SPECIALTY_CODE, PATIENT_CLASS,VISIT_ADM_TYPE,CASE WHEN patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_admission_type(visit_adm_type,'en',2) WHEN patient_class IN ('OP', 'EM') THEN op_get_desc.op_visit_type (facility_id,visit_adm_type,'en',2) END VISIT_TYPE_DESC FROM PR_ENCOUNTER WHERE FACILITY_ID=? AND ENCOUNTER_ID=? "; //IN28627 //IN28689 
								pstmt = con.prepareStatement(strSqln1);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,episode_id);
								rs = pstmt.executeQuery();
							
								if(rs.next())
								{
									patientclass = rs.getString("PATIENT_CLASS");
									if(patientclass == null) patientclass = "";
									speciality_code = rs.getString("SPECIALTY_CODE");
									if(speciality_code == null) speciality_code = "";
									visit_type = rs.getString("VISIT_ADM_TYPE"); //IN28627
									if(visit_type == null) visit_type = ""; //IN28627
									visittype_desc = rs.getString("VISIT_TYPE_DESC"); //IN28689
									if(visittype_desc == null) visittype_desc = ""; //IN28689
								}

								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();	
							}
							catch(Exception ew)
							{ 
								ew.printStackTrace();
							}
						}
						//String strSql2 = "SELECT CA_GET_MENU_ID(?,?,?,?) MENU_ID FROM DUAL ";		//IN036733 - commented
						String strSql2 = "SELECT CA_GET_MENU_ID(?,?,?,?,?) MENU_ID FROM DUAL ";		//IN036733
						
						pstmtMenu = con.prepareStatement(strSql2);
						pstmtMenu.setString(1,speciality_code);
						pstmtMenu.setString(2,patientclass);
						pstmtMenu.setString(3,practitioner_id);
						pstmtMenu.setString(4,pract_type);
						pstmtMenu.setString(5,facility_id);	//IN036733
						try
						{
							rsMenu = pstmtMenu.executeQuery();
						
							if(rsMenu.next())
							{
								menu_id = rsMenu.getString("MENU_ID");
							}

							if(rsMenu!=null) rsMenu.close();
							if(pstmtMenu!=null) pstmtMenu.close();	
							if(patientclass == null) patientclass = "";
						}
						catch(Exception ew)
						{ 
							out.println(ew.getMessage());
						}

						if(menu_id == null)		menu_id="MED_DFLT";	

						if(!patient_id.equals(""))
						{
							String sql_nric = "SELECT NATIONAL_ID_NO FROM MP_PATIENT where PATIENT_ID = ?";
							pstmt = con.prepareStatement(sql_nric);
							pstmt.setString(1,patient_id);
							rs = pstmt.executeQuery();
							if(rs.next())
							{
								nric_code = rs.getString("NATIONAL_ID_NO") == null ? "" : rs.getString("NATIONAL_ID_NO");
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						}

						/*Added By Jyothi to fix IN018529 on 27/01/2010 at 2:00 PM*/
						sql.append("SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b,        sm_quick_link_list_lang_vw c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'Q' AND c.eff_status = 'E' AND c.language_id = ? AND c.global_yn = 'Y' AND DECODE (c.QUICK_LINK_TYPE,'EX','Y',NVL((SELECT 'Y' FROM CA_OPTION WHERE OPTION_ID = C.OPTION_ID ");
						
						if(patient_id.equals(""))
							sql.append(" AND DESKTOP_YN = 'Y' ");
						else
							sql.append(" AND DESKTOP_YN = 'N' ");
						sql.append("),'N')) = 'Y'"); 

						pstmt = con.prepareStatement(sql.toString());
	
						pstmt.setString(1,login_user);
						pstmt.setString(2,resp_id);
						pstmt.setString(3,locale);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							Existance_Count = rs.getInt("EXISTANCE_COUNT");
						}
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();

						/*END*/

						if(detl_sql.length() > 0)
							detl_sql.delete(0,detl_sql.length());

						//detl_sql.append("select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID,  B.EXECUTABLE_NAME EXECUTABLE_NAME, B.LONG_DESC,A.QUERY_STRING from sm_quick_link_list_lang_vw A, CA_OPTION B,");//IN29822
						//detl_sql.append("select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID,  B.EXECUTABLE_NAME EXECUTABLE_NAME, B.LONG_DESC,A.QUERY_STRING from sm_quick_link_list_lang_vw A, CA_OPTION B,sm_quick_link_resp d,");//IN29822
						detl_sql.append("select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, A.OPTION_ID,  B.EXECUTABLE_NAME EXECUTABLE_NAME, B.LONG_DESC,A.QUERY_STRING,a.QUICK_LINK_REF from sm_quick_link_list_lang_vw A, CA_OPTION B,sm_quick_link_resp d,");//IN036367
						if(Existance_Count>0)
							detl_sql.append(" SM_QUICK_LINK_FOR_USER C where C.APPL_USER_ID = ? ");
						else
							detl_sql.append(" SM_QUICK_LINK_RESP C where C.RESP_ID = ? ");

						//detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND B.OPTION_ID(+)=A.OPTION_ID AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND B.EXECUTABLE_NAME IS NOT NULL ");//IN29822
						detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND B.OPTION_ID(+)=A.OPTION_ID AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND B.EXECUTABLE_NAME IS NOT NULL AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? AND d.link_type = 'Q'");//IN29822
						if(patient_id.equals(""))
							detl_sql.append(" and B.DESKTOP_YN(+) = 'Y' ");
						else
						{
							detl_sql.append(" and B.DESKTOP_YN(+) = 'N' ");
							if(mode.equals("V"))
								detl_sql.append(" and b.HIST_OR_RECORD = 'H' ");
							if(patient_class.equals(""))
								patient_class = "XT";
							detl_sql.append(" and b.APPL_"+patient_class+"_YN = 'Y' ");
						}
						detl_sql.append(" and exists (select 1 from ca_appl_task ia where OPTION_ID(+) = a.OPTION_ID and  GET_TASK_APPLICABILITY(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) = 'A' and (ia.BASE_MODULE_ID = 'CA' or exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");
						
						if(!patient_id.equals(""))
							detl_sql.append(" and ( MODULE_GROUP_ID!='SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID = ia.BASE_MODULE_ID AND  SPECIALITY_CODE = ? )) ");

						//detl_sql.append(" ))) UNION ALL select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, '' OPTION_ID, A.EXTERNAL_URL_APPL EXECUTABLE_NAME, '' LONG_DESC,A.QUERY_STRING   from sm_quick_link_list_lang_vw A,");//IN29822
						//detl_sql.append(" ))) UNION ALL select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, '' OPTION_ID, A.EXTERNAL_URL_APPL EXECUTABLE_NAME, '' LONG_DESC,A.QUERY_STRING from sm_quick_link_list_lang_vw A,sm_quick_link_resp d, ");//IN29822
						detl_sql.append(" ))) UNION ALL select distinct a.quick_link_ref, QUICK_LINK_TYPE, a.quick_link_description, '' OPTION_ID, A.EXTERNAL_URL_APPL EXECUTABLE_NAME, '' LONG_DESC,A.QUERY_STRING,a.QUICK_LINK_REF  from sm_quick_link_list_lang_vw A,sm_quick_link_resp d, ");//IN036367
						if(Existance_Count>0)
							detl_sql.append(" SM_QUICK_LINK_FOR_USER C where C.APPL_USER_ID = ? ");
						else
							detl_sql.append(" SM_QUICK_LINK_RESP C where C.RESP_ID = ? ");

						//detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX' order by 2");//IN29822
						detl_sql.append(" AND A.LANGUAGE_ID = '"+locale+"' AND A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.link_type = 'Q' AND A.QUICK_LINK_REF = C.QUICK_LINK_REF AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX' AND a.quick_link_ref = d.quick_link_ref AND d.resp_id = ? order by 2");//IN29822
						
						pstmt = con.prepareStatement(detl_sql.toString());
						int val = 0;
						if(Existance_Count>0)
							pstmt.setString(++val,login_user);
						else
							pstmt.setString(++val,resp_id);
						pstmt.setString(++val,resp_id);//IN29822
						pstmt.setString(++val,resp_id);
						pstmt.setString(++val,reln_id);
						pstmt.setString(++val,facility_id);
						pstmt.setString(++val,episode_id);
						pstmt.setString(++val,patient_id);
						
						if(!patient_id.equals(""))
						{
							pstmt.setString(++val,splty_code);
						}
						if(Existance_Count>0)
							pstmt.setString(++val,login_user);
						else
							pstmt.setString(++val,resp_id);
						pstmt.setString(++val,resp_id);//IN29822
						
						rs = pstmt.executeQuery();
						//44162 Start.
						String Encry_login_user=""; 
						//System.out.println("CAMainTitle.jsp==============>968");
						Boolean isExtAppUserIdEncrypted =  CommonBean.isSiteSpecific(con, "OR", "EXTAPP_LOGIN_USER_ID_ENCRY");
					//	System.out.println("CAMainTitle.jsp========isExtAppUserIdEncrypted======>"+isExtAppUserIdEncrypted);	
						if(isExtAppUserIdEncrypted){
							try{
							//	System.out.println("CAMainTitle.jsp==============>973");			
								String data_user="app_id=bruhims&app_secret=3e17cad3f0a771d7c7af34098443d533&data.user_info.id="+login_user.toLowerCase();
							//	System.out.println("CAMainTitle.jsp==============>975=====>"+data_user);
								java.security.MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
							//	System.out.println("CAMainTitle.jsp==============>977=================>"+digest);
								digest.reset();
							//	System.out.println("CAMainTitle.jsp==============979=================>"+data_user.getBytes("UTF-8"));
								byte[] hash = digest.digest(data_user.getBytes("UTF-8"));
							//	System.out.println("CAMainTitle.jsp==============>981======hash.length=============>"+hash.length);
							//	System.out.println("CAMainTitle.jsp==============>982===================>"+new String(hash));			
								
								// Convert byte array into signum representation
								java.math.BigInteger no = new java.math.BigInteger(1, hash);
					  
								// Convert message digest into hex value
								Encry_login_user = no.toString(16);
								while (Encry_login_user.length() < 32) {
									Encry_login_user = "0" + Encry_login_user;
								}
							//	System.out.println("CAMainTitle.jsp==============>992======1=========>"+Encry_login_user);
								
								//Encry_login_user=javax.xml.bind.DatatypeConverter.printHexBinary(hash);
								//System.out.println("CAMainTitle.jsp==============>995======2=========>"+Encry_login_user);
							
							}catch(NoSuchAlgorithmException e){
								System.out.println("CAMainTitle.jsp==998=======Error========>"+e.toString());
							}catch(Exception e1){
								e1.printStackTrace();
								System.out.println("CAMainTitle.jsp==1001=======Error========>"+e1.toString());
							}
							
						}
						//44162 End.

						while(rs.next())
						{
							//option_id = rs.getString("OPTION_ID") + "|" + rs.getString("QUICK_LINK_TYPE") + "|"+ rs.getString("LONG_DESC") + "|" + rs.getString("EXECUTABLE_NAME");	
							executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");
							if(!executable_name.equals("")){
								if (executable_name.indexOf("~PATIENT_ID`") >= 0){
										executable_name = executable_name.replaceAll("~PATIENT_ID`",patient_id);
								}
								if (executable_name.indexOf("~ENCOUNTER_ID`")>=0){
										executable_name = executable_name.replaceAll("~ENCOUNTER_ID`",episode_id);	
								}if (executable_name.indexOf("~FACILITY_ID`")>= 0){
										executable_name = executable_name.replaceAll("~FACILITY_ID`",facility_id);
								}
								if (executable_name.indexOf("~NRIC`")>= 0){
										executable_name = executable_name.replaceAll("~NRIC`",nric_code);
								}
								 //IN27710 - Start
                                if (executable_name.indexOf("~LOGIN_USRID`")>= 0){									
									executable_name = executable_name.replaceAll("~LOGIN_USRID`",login_user); //IN28627									
								}
								//44162 Start.	
								if (executable_name.indexOf("~ENC_LOGIN_USRID`")>= 0){																	
									if(isExtAppUserIdEncrypted ){ 
										executable_name = executable_name.replaceAll("~ENC_LOGIN_USRID`",Encry_login_user);
									}else{
										executable_name = executable_name.replaceAll("~ENC_LOGIN_USRID`",login_user);	
									}									
								}
								//44162 End.
								if (executable_name.indexOf("~PATIENT_NAME`")>= 0){
										executable_name = executable_name.replaceAll("~PATIENT_NAME`",patient_name);
								}
								if (executable_name.indexOf("~AGE`")>= 0){
										executable_name = executable_name.replaceAll("~AGE`",age);
								}
								if (executable_name.indexOf("~GENDER`")>= 0){
										executable_name = executable_name.replaceAll("~GENDER`",sex); //IN28627
								}
								if (executable_name.indexOf("~VISIT_TYPE_DESC`")>= 0){
										executable_name = executable_name.replaceAll("~VISIT_TYPE_DESC`",visittype_desc); //IN28689
								}
								  //IN27710 - End
							}
							v_query_string = rs.getString("QUERY_STRING")==null?"":rs.getString("QUERY_STRING");
							if(!v_query_string.equals("")){
								
								if (v_query_string.indexOf("~PATIENT_ID`") >= 0){
										v_query_string = v_query_string.replaceAll("~PATIENT_ID`",patient_id);
								}
								if (v_query_string.indexOf("~ENCOUNTER_ID`")>=0){
										v_query_string = v_query_string.replaceAll("~ENCOUNTER_ID`",episode_id);	
								}if (v_query_string.indexOf("~FACILITY_ID`")>= 0){
										v_query_string = v_query_string.replaceAll("~FACILITY_ID`",facility_id);
								}
								if (v_query_string.indexOf("~NRIC`")>= 0){
										v_query_string = v_query_string.replaceAll("~NRIC`",nric_code);
								}
                               //IN27710 - Start
								if (v_query_string.indexOf("~LOGIN_USRID`")>= 0){	
									v_query_string = v_query_string.replaceAll("~LOGIN_USRID`",login_user); //IN28627
								}
								//44162 Start.	
								if (v_query_string.indexOf("~ENC_LOGIN_USRID`")>= 0){	
									if(isExtAppUserIdEncrypted ){ 
										v_query_string = v_query_string.replaceAll("~ENC_LOGIN_USRID`",Encry_login_user);
									}else{
										v_query_string = v_query_string.replaceAll("~ENC_LOGIN_USRID`",login_user);	
									}
								}
								//44162 End.
								if (v_query_string.indexOf("~PATIENT_NAME`")>= 0){
										v_query_string = v_query_string.replaceAll("~PATIENT_NAME`",patient_name);
								}
								if (v_query_string.indexOf("~AGE`")>= 0){
										v_query_string = v_query_string.replaceAll("~AGE`",age);
								}
								if (v_query_string.indexOf("~GENDER`")>= 0){
										v_query_string = v_query_string.replaceAll("~GENDER`",sex); //IN28627
								}
								if (v_query_string.indexOf("~VISIT_TYPE_DESC`")>= 0){
										v_query_string = v_query_string.replaceAll("~VISIT_TYPE_DESC`",visittype_desc); //IN28689
								}
								//IN27710 - End
							} 	
							option_id.delete(0,option_id.length());
							option_id.append(rs.getString("OPTION_ID"));
							option_id.append("|");
							option_id.append(rs.getString("QUICK_LINK_TYPE"));
							option_id.append("|");
							option_id.append(rs.getString("LONG_DESC"));
							option_id.append("|");
							option_id.append(executable_name);
							option_id.append("|");//IN036367
							option_id.append(rs.getString("QUICK_LINK_REF"));//IN036367
							if(!v_query_string.equals("")){ 
								option_id.append("?");							
								option_id.append(v_query_string);
							}
							
				
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(option_id.toString()));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rs.getString("quick_link_description")));
            _bw.write(_wl_block64Bytes, _wl_block64);

						}//end of rs.next()
						if(rs != null)rs.close();
						if(pstmt != null)pstmt.close();
				
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(limit_function_id.equals("")?"display":"display:none"));
            _bw.write(_wl_block67Bytes, _wl_block67);

						}
				
            _bw.write(_wl_block68Bytes, _wl_block68);

							if(!patient_id.equals(""))
							{
					
            _bw.write(_wl_block69Bytes, _wl_block69);

						if(menu_Active.equals("N") && lookupFileName.equals("") && limit_function_id.equals(""))
						{ 
							if(patient_id.equals("")) 
								spacesForImage = ""; 
							else  
								spacesForImage = "&nbsp;&nbsp;";
					
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block72Bytes, _wl_block72);

							if(patient_id.equals("") || !from_service_yn.equals("N"))
							{
					
            _bw.write(_wl_block73Bytes, _wl_block73);

							}
					
            _bw.write(_wl_block74Bytes, _wl_block74);

							if(patient_id.equals("") || !from_service_yn.equals("N"))
							{
					
            _bw.write(_wl_block73Bytes, _wl_block73);

							}
					
            _bw.write(_wl_block75Bytes, _wl_block75);
     if("Y".equals(addFavPatientIcon)){
            _bw.write(_wl_block76Bytes, _wl_block76);
		}
            _bw.write(_wl_block77Bytes, _wl_block77);

							if(langListSize >= 1)
							{
					
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(langListSize));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cur_lang_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(opt_lang_id));
            _bw.write(_wl_block79Bytes, _wl_block79);

							if(patient_id.equals("") || !from_service_yn.equals("N"))
							{
					
            _bw.write(_wl_block73Bytes, _wl_block73);

							}
					
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(cur_lang_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(opt_lang_id));
            _bw.write(_wl_block82Bytes, _wl_block82);

							}
						}
						if(menu_Active.equals("N") && !patient_id.equals(""))
						{
					
            _bw.write(_wl_block83Bytes, _wl_block83);

						}
					
            _bw.write(_wl_block84Bytes, _wl_block84);

						}
					
            _bw.write(_wl_block85Bytes, _wl_block85);

				}
			
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block87Bytes, _wl_block87);

		// IN044083 Start.
		//IN058149 start 
		if("N".equals(Genotitle) && from_service_yn.equals("N")){
		//IN058149 end
		
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block89Bytes, _wl_block89);

		}else{
		
            _bw.write(_wl_block90Bytes, _wl_block90);

		}
		// IN044083 End.
		
            _bw.write(_wl_block91Bytes, _wl_block91);

			if((eCA._ca_license_rights.getKey()).equals("CACLDC")  || (eCA._ca_license_rights.getKey()).equals("CABASIC"))
			{	
				if(lookupFileName.equals("") && from_service_yn.equals("N")&& limit_function_id.equals(""))
				{
					//out.println("lookupFileName :"+lookupFileName);
					//out.println("from_service_yn :"+from_service_yn);
					//out.println("limit_function_id :"+limit_function_id);

	
            _bw.write(_wl_block92Bytes, _wl_block92);
			}
			}
			if(!lookupFileName.equals(""))
			{ // IN044083 Start.
			  //IN058149  start
			  if("N".equals(Genotitle) && from_service_yn.equals("N")){
			  //IN058149 end
				
	
            _bw.write(_wl_block93Bytes, _wl_block93);
	
				}else{
	
            _bw.write(_wl_block94Bytes, _wl_block94);
			
				}
				// IN044083 End.
			}
			if(!child_window.equals("Y"))
			{
				
				altText = "Close";
			}
			if(lookupFileName.equals("")){
				
				
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(wname));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(altText));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(altText));
            _bw.write(_wl_block97Bytes, _wl_block97);

			}
	
			else if(!lookupFileName.equals(""))
			{
				// IN044083 Start.
				//IN058149 start
				if("N".equals(Genotitle) && from_service_yn.equals("N")){
				//IN058149 end
	
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(altText));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(altText));
            _bw.write(_wl_block99Bytes, _wl_block99);
		
				}else{
	
            _bw.write(_wl_block94Bytes, _wl_block94);
			
				}
				// IN044083 End.
			}
	
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(function_display_name));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(styleMap));
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale)));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
	
	if(rs!=null) rs.close();
	if (pstmt != null) pstmt.close();
	} 
	catch (Exception e) 
	{
		out.println("CAMainTitle: "+e);
	}
	 finally 
	{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(request.getParameter("episode_id")==null?"":request.getParameter("episode_id")));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(window_name));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(lookup_window_name));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(client_ip_address));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(layout_value));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(desktod_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(dfltFunctionId));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block126Bytes, _wl_block126);
 //=menu_id
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(patientclass));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block135Bytes, _wl_block135);

	if(menu_Active.equals("N") && lookupFileName.equals(""))
	{

            _bw.write(_wl_block136Bytes, _wl_block136);
	if (!patient_id.equals(""))
	{					
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
	}	else{
		
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(layout_value));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dfltFunctionId));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(desktod_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(layout_value));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(dfltFunctionId));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(desktod_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
	}	
	//if(desktod_id.equals("")){
		if(!patient_id.equals(""))
		{

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(limit_function_id));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block148Bytes, _wl_block148);

			if(patient_class.equals("EM"))
			{

            _bw.write(_wl_block149Bytes, _wl_block149);

			}
		}

            _bw.write(_wl_block150Bytes, _wl_block150);

	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	if(! lookupFileName.equals(""))
	{

            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(lookupFileName));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(window_name));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(lookup_window_name));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(function_display_name));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(function_display_name));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(function_display_name));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(function_display_name));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf((function_display_name+"-"+(patient_name+strBuffPatientInfo))));
            _bw.write(_wl_block160Bytes, _wl_block160);

	}
	else
	{
		if(limit_function_id.equals(""))
		{
			if(!patient_id.equals(""))
			{

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(productName));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(versionNum));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block164Bytes, _wl_block164);

			}
		}
		else if(!limit_function_id.equals(""))
		{

            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(chartTitle));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block167Bytes, _wl_block167);

		}
	}
			

            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block169Bytes, _wl_block169);

	}
			catch(Exception eeee)
			{
				eeee.printStackTrace();
			}
	
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ShowMenu.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ShowMenu.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HideMenu.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HideMenu.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HOMEPAGE.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HOMEPAGE.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientwithoutEncounter.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClinicalCalculator.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClinicalCalculator.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomizeIcons.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomizeIcons.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomizeIcons.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomizeIcons.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.QuickLinks.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomiseLinks.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomiseLinks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomiseFilter.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CustomiseFilter.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MyTaskList.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Detailsason.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Refresh.label", java.lang.String .class,"key"));
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
}
