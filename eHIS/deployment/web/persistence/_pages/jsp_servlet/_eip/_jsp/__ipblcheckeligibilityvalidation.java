package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eBL.Common.*;
import com.ehis.util.*;
import eBL.*;
import java.sql.*;
import blipin.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ipblcheckeligibilityvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPBLCheckEligibilityValidation.jsp", 1718790811733L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script>\n\tasync function callPkgElgibility(sameblngClassYN,val,error_text)\n\t{\t\t\n\t\tif(error_text!=\"\")\n\t\t{\n\t\t\talert(error_text);\n\t\t\treturn false;\n\t\t}\n\t\tvar js =  \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\tif(sameblngClassYN==\'N\')\n\t\t{\n\t\t\t/*var dialogTop\t= \"330\";\n\t\t\tvar dialogHeight= \"10\" ; \n\t\t\tvar dialogWidth\t= \"30\" ;\t\n\t\t\tvar dialogLeft\t= \"200\" ;*/\n\t\t\tvar dialogTop\t= \"300\";\n\t\t\tvar dialogHeight= \"8\" ; \n\t\t\tvar dialogWidth\t= \"30\" ;\t\n\t\t\tvar dialogLeft\t= \"200\" ;\n\t\t\t\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop + \"; status=no;scrolling=no;valign=center; dialogLeft: \"+dialogLeft ; \n\t\t\t\t\n\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\tvar tit\t\t\t\t= \"Package Eligibility by Billing Class\";\n\t\t\tvar bed_type = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\tvar billing_group = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tvar bed_no = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tvar bed_ref = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\tvar bed_type_ref = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\tretVal=await window.showModalDialog(\"../../eBL/jsp/pkgEligibilityByBlngClass.jsp?bed_type=\"+bed_type+\"&billing_group=\"+billing_group+\"&bed_no=\"+bed_no+\"&title=\"+encodeURIComponent(tit),arguments,features);\t\n\t\t\t\tif(retVal==undefined || retVal==\'undefined\'){\n\t\t\t\t\tretVal=\'N\';\t}\n\t\t\tif(retVal != null)\n\t\t\t{\n\t\t\t\tif(retVal==\'Y\')\n\t\t\t\t{\n\t\t\t\t\tshowModal(val);\n\t\t\t\t}else{\n\t\t\t\t\tif((js == \'../js/AdmitPatient.js\') ||(js == \'../js/AdmitPatient1.js\'))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.blr_check.value=\'Y\';\n\t\t\t\t\t\t\t\tparent.frames[0].location.href =\'../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit%20Patient&function_type=F&menu_id=IP_ADMISSION&access=NYNNN\';\n\t\t\t\t\t\t\t\teval(bed_ref).onblur();\n\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(js == \'../js/EmergencyTransfer.js\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].transfer.disabled=false;\n\t\t\t\t\t\t\t\tparent.frames[1].location.reload();\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(js == \'../js/ConfirmBedClass.js\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(js == \'../js/TransferPatient.js\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(js == \'../js/AssignBedDetail.js\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t/*2/23/2009 7067\tMF-CRF-0059\tIP*/\n\t\t\t\t\t\t\telse if(js == \'../js/PatientEmergencyTransfer.js\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].confirm.disabled=false;\n\t\t\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t}\n\t\t}else{\n\t\t\tshowModal(val);}\n\t}\n\tasync function showModal(val)\n\t{\n\t\tvar js =  \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\tif(val == \'Y\')\n\t\t{\n\t\t\tvar dialogTop\t= \"200\";\n\t\t\tvar dialogHeight= \"600px\" ;  \n\t\t\tvar dialogWidth\t= \"1200px\" ;\t\n\t\t\tvar dialogLeft\t= \"90\" ;\n\t\t\t\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop + \"; status=no;scrolling=no;valign=center; dialogLeft: \"+dialogLeft ;\n\t\t\t\t\n\t\t\tvar arguments\t\t\t= \"\" ;\n\t\t\tvar tit\t\t\t\t= \"Patient Charging Basis on \"+\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\tvar bed_type = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\tvar billing_group = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\tvar bed_no = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\tvar bed_ref = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\tvar bed_type_ref = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\tvar reasonForTransfer = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\n\t\t\t//retVal=window.showModalDialog(\"../../eBL/jsp/BLCheckEligibilityLevel.jsp?bed_type=\"+bed_type+\"&billing_group=\"+billing_group+\"&bed_no=\"+bed_no+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\t\t\t/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/\n\t\t\tvar retVal = \"\";\n\t\t\tvar reqRadioBtn = \"\";\n\t\t\tvar remarks\t= \"\";\n\t\t\t/*End*/\n\t\t\tretArr=await window.showModalDialog(\"../../eBL/jsp/BLCheckEligibilityLevel.jsp?bed_type=\"+bed_type+\"&billing_group=\"+billing_group+\"&bed_no=\"+bed_no+\"&reasonForTransfer=\"+reasonForTransfer+\"&title=\"+encodeURIComponent(tit),arguments,features);\n\t\t\t\n\t\t\tif(retArr != null)\n\t\t\t{\t\n\t\t\t\t/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/\n\t\t\t\t\n\t\t\t\tif(retArr.length == \'3\'){\n\t\t\t\t\tretVal\t\t= retArr[0];\n\t\t\t\t\treqRadioBtn\t= retArr[1];\n\t\t\t\t\t/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 Start*/\n\t\t\t\t\tremarks\t\t= retArr[2];\n\t\t\t\t\tvar frameRef\t= \"\";\t\n\t\t\t\t\tif((js == \'../js/AdmitPatient.js\') ||(js == \'../js/AdmitPatient1.js\')) {\n\t\t\t\t\t\tframeRef\t= parent.frames[1].frames[2].document.AdmitPatient_form;\n\t\t\t\t\t}else if(js == \'../js/EmergencyTransfer.js\' || js == \'../js/PatientEmergencyTransfer.js\'){\n\t\t\t\t\t\tframeRef\t= parent.frames[1].document.forms[0];\n\t\t\t\t\t}\n\n\t\t\t\t\tif(frameRef!=\"\"){\n\t\t\t\t\t\tif(frameRef.bl_adm_remarks!=null){\n\t\t\t\t\t\t\tframeRef.bl_adm_remarks.value = remarks;\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(frameRef.bl_bed_request!=null){\n\t\t\t\t\t\t\tframeRef.bl_bed_request.value = reqRadioBtn;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(frameRef.bl_bed_type_code!=null){\n\t\t\t\t\t\t\tframeRef.bl_bed_type_code.value = retVal;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t/*Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 End*/\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t}else if (retArr.length == \'5\')\n\t\t\t\t{\n\t\t\t\t\tretVal = retArr;\n\t\t\t\t}/*End*/\n\t\t\t\tif(retVal == \'close\' || retVal==\'0\')\n\t\t\t\t{\t\n\t\t\n\t\t\t\t\tif((js == \'../js/AdmitPatient.js\') ||(js == \'../js/AdmitPatient1.js\'))\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.blr_check.value=\'Y\';\n\t\t\t\t\t\tparent.frames[0].location.href =\'../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit%20Patient&function_type=F&menu_id=IP_ADMISSION&access=NYNNN\';\n\t\t\t\t\t\teval(bed_ref).onblur();\n\n\t\t\t\t\t}\n\t\t\t\t\telse if(js == \'../js/EmergencyTransfer.js\')\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].transfer.disabled=false;\n\t\t\t\t\t\tparent.frames[1].location.reload();\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse if(js == \'../js/ConfirmBedClass.js\')\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t}\n\t\t\t\t\telse if(js == \'../js/TransferPatient.js\')\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t}\n\t\t\t\t\telse if(js == \'../js/AssignBedDetail.js\')\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t}\n\t\t\t\t\t/*2/23/2009 7067\tMF-CRF-0059\tIP*/\n\t\t\t\t\telse if(js == \'../js/PatientEmergencyTransfer.js\')\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].confirm.disabled=false;\n\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if(retVal != \'\')\n\t\t\t\t{\n\t\t\t\t\t//Modified below function calls (passed reqRadioBtn parameter) for ML-MMOH-CRF-0866 by Thamizh selvi on 15th Nov 2017\t\t\t\t\n\t\t\t\t\teval(bed_type_ref).value  = retVal;\n\t\t\t\t\tif(js == \'../js/EmergencyTransfer.js\')\n\t\t\t\t\t\tapplyone_em(\'Y\', val, reqRadioBtn);\n\t\t\t\t\telse if(js == \'../js/ConfirmBedClass.js\')\n\t\t\t\t\t\tapplyone_confirm(\'Y\', reqRadioBtn);\n\t\t\t\t\t/*2/23/2009 7067\tMF-CRF-0059\tIP*/\n\t\t\t\t\telse if(js == \'../js/PatientEmergencyTransfer.js\')\n\t\t\t\t\t\tapplyone_emp(\'Y\', val, reqRadioBtn);\n\t\t\t\t\telse\n\t\t\t\t\t\tapplyone(\'Y\', val, reqRadioBtn);\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//Modified below function calls (passed reqRadioBtn parameter) for ML-MMOH-CRF-0866 by Thamizh selvi on 15th Nov 2017\t\t\t\n\t\t\t\t\tif(js == \'../js/EmergencyTransfer.js\')\n\t\t\t\t\t\tapplyone_em(\'Y\', val, reqRadioBtn);\n\t\t\t\t\telse if(js == \'../js/ConfirmBedClass.js\')\n\t\t\t\t\t\tapplyone_confirm(\'Y\', reqRadioBtn);\n\t\t\t\t\t/*2/23/2009 7067\tMF-CRF-0059\tIP*/\n\t\t\t\t\telse if(js == \'../js/PatientEmergencyTransfer.js\')\n\t\t\t\t\t\tapplyone_emp(\'Y\', val, reqRadioBtn);\n\t\t\t\t\telse\n\t\t\t\t\t\tapplyone(\'Y\', val, reqRadioBtn);\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[2].document.AdmitPatient_form.blr_check.value=\'Y\';\n\t\t\t\tparent.frames[0].location.href =\'../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit%20Patient&function_type=F&menu_id=IP_ADMISSION&access=NYNNN\';\n\t\t\t\teval(bed_ref).onblur();\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\telse if(val == \'N\')\n\t\t{\t\n\t\t\t//Modified below function calls (passed reqRadioBtn parameter) for ML-MMOH-CRF-0866 by Thamizh selvi on 15th Nov 2017\n\t\t\tif(js == \'../js/EmergencyTransfer.js\')\n\t\t\t\tapplyone_em(\'Y\', val, \'\');\n\t\t\telse if(js == \'../js/ConfirmBedClass.js\')\n\t\t\t\tapplyone_confirm(\'Y\',\'\');\n\t\t\t/*2/23/2009 7067\tMF-CRF-0059\tIP*/\n\t\t\telse if(js == \'../js/PatientEmergencyTransfer.js\')\n\t\t\t\tapplyone_emp(\'Y\', val, \'\');\n\t\t\telse\n\t\t\t\tapplyone(\'Y\', val, \'\');\n\t\t}\n\t}\n\t\t\n</script>\n\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
	
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


	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
/***************Addded for package billing******************/
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(request.getParameter("field7")));
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8"); 
	String bed_type="",billing_group="",bed_no="",parent="";
	Connection			con			=	null;
	PreparedStatement	stmt		=	null;
	ResultSet			rs		=	null;
	con					=	ConnectionManager.getConnection(request);
	String result = "",sql="";
	//String result = "",sql="",sql1="";
	String bed_ref="";
	String modified_bed_type_ref = "";
	String reasonForTransfer = "";
	/******************ADDDED FOR PACKAGE BILLING**********************/
	String facility_id			= (String)session.getAttribute("facility_id");
	String patient_id = "";
	String p_episode_id = "";
	String sameblngClassYN = "N";
	String error_text = "";
	String pkg_dtls="";
	String pkg_seq_no="";
	String pkg_code="";
	String pkg_desc="";
	StringTokenizer pkgSt=null;			
	String bl_package_enabled_yn="N";
	/******************END FOR PACKAGE BILLING**********************/
	
	try
	{
		bed_type = request.getParameter("field1");
		billing_group = request.getParameter("field2");
		bed_no = request.getParameter("field3");
		parent = request.getParameter("field4");
		bed_ref = request.getParameter("field5");
		modified_bed_type_ref = request.getParameter("field6");
		reasonForTransfer = checkForNull(request.getParameter("reasonForTransfer"),"");
				
		/******************ADDDED FOR PACKAGE BILLING**********************/	
		try{

			PreparedStatement pstmt1=con.prepareStatement("select bl_package_enabled_yn('"+facility_id+"') from dual");	
			ResultSet rs2 = pstmt1.executeQuery();	
			if( rs2 != null ) 
			{
				if( rs2.next() )
				{			
					bl_package_enabled_yn  =  rs2.getString(1);	
				}
			}
			if(bl_package_enabled_yn == null) bl_package_enabled_yn="N";			
			pstmt1.close();
			if(rs2!=null) rs2.close();	
			if(bl_package_enabled_yn.equals("Y"))
			{
				String bean_id		= "PkgAssociateBean" ;
				String bean_name	= "eBL.PkgAssociateBean";
				PkgAssociateBean bean			= (PkgAssociateBean)getBeanObject( bean_id, bean_name, request ) ;	
				patient_id = request.getParameter("field8");
				if(parent.equals("Admission"))
				{
				ArrayList  patPackAssociateDtls=(ArrayList)bean.getAssociatedPkgs();	
				if(patPackAssociateDtls!=null && patPackAssociateDtls.size()>0)
				{
					for(int i=0;i<patPackAssociateDtls.size();i++)
					{
						pkg_dtls=(String)patPackAssociateDtls.get(i);
						pkgSt=new StringTokenizer(pkg_dtls,"~~");
						if(pkgSt.hasMoreTokens())
							pkg_code=(String)pkgSt.nextToken();
						else
							pkg_code="";
						if(pkgSt.hasMoreTokens())
						pkg_desc=(String)pkgSt.nextToken();
						else
							pkg_desc="";
						//
						if(pkgSt.hasMoreTokens()){
							if(pkg_seq_no.equals(""))
							{
								pkg_seq_no=(String)pkgSt.nextToken();	
							}
							else{
								pkg_seq_no=pkg_seq_no+"|"+(String)pkgSt.nextToken();	
							}
						}
						else
							pkg_seq_no="";
					}
				}
				if(!pkg_seq_no.equals(""))
				{				
					CallableStatement call_pkg = con.prepareCall("{ call  blpackage.IsBlngClassSameAsPkg_Adm(?,?,?,?,?,?)}");				
					call_pkg.setString(1,facility_id);
					call_pkg.setString(2,patient_id);
					call_pkg.setString(3,bed_type);
					call_pkg.setString(4,pkg_seq_no);	
					call_pkg.registerOutParameter(5,java.sql.Types.VARCHAR);
					call_pkg.registerOutParameter(6,java.sql.Types.VARCHAR);
					call_pkg.execute();	
					sameblngClassYN = call_pkg.getString(5);		
					error_text = call_pkg.getString(6);						
					
					if ( sameblngClassYN == null ) sameblngClassYN = "";
					if ( error_text == null ) error_text = "";
					call_pkg.close();

				}else{
					sameblngClassYN="Y";
				}
				}else if(parent.equals("Transfer"))
				{
					p_episode_id =request.getParameter("field9");			
					String patientid123	= (String)session.getValue("patientid");
					String encounter_id123	= (String)session.getValue("encounter_id");

					try{
					CallableStatement call_pkg1 = con.prepareCall("{ call  blpackage.IsBlngClassSameAsPkg_Trf(?,?,?,?,?,?,?)}");				
					call_pkg1.setString(1,facility_id);
					call_pkg1.setString(2,patientid123);
					call_pkg1.setString(3,bed_type);
					call_pkg1.setString(4,"I");	
					call_pkg1.setString(5,encounter_id123);	
					call_pkg1.registerOutParameter(6,java.sql.Types.VARCHAR);
					call_pkg1.registerOutParameter(7,java.sql.Types.VARCHAR);
					call_pkg1.execute();	
					sameblngClassYN = call_pkg1.getString(6);		
					error_text = call_pkg1.getString(7);						
					
					if ( sameblngClassYN == null ) sameblngClassYN = "";
					if ( error_text == null ) error_text = "";
					call_pkg1.close();
				}catch (Exception e)
				{ 
					

					e.printStackTrace();
				}
				}
		}
		}catch (Exception e)
		{ 
			
			e.printStackTrace();
		}
			
		
	/******************END FOR PACKAGE BILLING**********************/
				
		sql= "select BL_CHECK_ELIGIBILITY_LEVEL('"+billing_group+"','"+bed_type+"') from dual";
		result = "";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		while(rs.next())
		{
			result = rs.getString(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

	}catch (Exception e)
	{ 
		out.println ("Exception :"+e); 
		e.printStackTrace();
	}
	finally 
	{
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}	


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getParameter("field7")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bed_ref));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(modified_bed_type_ref));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getParameter("field7")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(parent));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bed_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(billing_group));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bed_ref));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(modified_bed_type_ref));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(reasonForTransfer));
            _bw.write(_wl_block20Bytes, _wl_block20);

if(bl_package_enabled_yn.equals("Y"))
{
	out.println("<script>callPkgElgibility('"+sameblngClassYN+"','"+result+"','"+error_text+"');</script>");
}else{
	out.println("<script>showModal('"+result+"');</script>");
}

            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
