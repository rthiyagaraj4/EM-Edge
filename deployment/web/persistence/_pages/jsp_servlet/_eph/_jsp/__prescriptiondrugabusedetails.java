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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __prescriptiondrugabusedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PrescriptionDrugAbuseDetails.jsp", 1709121211099L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="   \n \n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link> <!-- added for MMS-KH-CRF-0029[IN070606] -->\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/Prescription_1.js\"></SCRIPT> \n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body >\n\t\t<form name=\"FormDrugInteractionsDetail\" id=\"FormDrugInteractionsDetail\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<TABLE name=\"DrugInteractionAlert\" id=\"DrugInteractionAlert\" cellpadding=0 cellspacing=0 width=\"110%\" align=\"center\" border=\"0\">   \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr> <!-- MMS-KH-CRF-0029[IN070606] start-->\n\t\t\t\t\t\t\t\t<td width= \"180%\" class=\"white\">\n\t\t\t\t\t\t\t\t <ul id=\"tablist\" class=\"tablist\" >   \n\n\t\t\t\t\t\t\t\t<li class=\"tablistitem\" title=\'Drug Abuse\' style=\"display:inline\">\n\t\t\t\t\t\t\t\t <a onclick=\"tab_click3(\'DrugLab_tab\')\" class=\"tabA\" id=\"DrugLab_tab\" >\n\t\t\t\t\t\t\t\t\t<span class=\"tabAspan\" id=\"DrugLab_tabspan\">\n\t\t\t\t\t\t\t\t\tDrug Abuse</span>\n\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\t<TABLE cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width = \"100%\" align=\"center\" id=\"lab_interations\" style=\"display:inline\"> \n\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t<!--\t<td class=\"label\" width=\'2px\' style=\'vertical-align:top;\'><img value=\"\" src=\"../../ePH/images/redAlert.png\" height=\'40 \' width=\'40\'></img>-->\n\t\t\t\t\t\t\t\t<td  class=\"label\" align=\'left\' style=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"><label id=\'labIntrAlertMsg1\'></label><br><label id=\'labIntrAlertMsg2\' style=\"color:red;font-size:12;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =".</label><br><label id=\'labIntrAlertMsg3\' style=\"color:red;font-size:12;\"></label></td ><!-- modified for MMS-KH-CRF-0029[IN070606]  and removed decode for MMS-KH-SCF-0079-->\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_desc\" id=\"drug_desc\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"><!-- added for RUT-SCF-0318.1 [IN:046811] -->\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar msg = getMessage(\"PH_INTERACTION_ALERT\",\"PH\");\n\t\t\t\t\t\t\t\t\tvar\tmsg1 = getMessage(\"PH_INTERACTION_RESTRICT\",\"PH\");\n\t\t\t\t\t\t\t\t\tmsg = msg.replace(\"$$$\",document.FormDrugInteractionsDetail.drug_desc.value);\n\t\t\t\t\t\t\t\t//\tdocument.getElementById(\"drugIntrAlertMsg1\").innerText=msg; commented for MMS-KH-CRF-0029[IN070606]\n\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"labIntrAlertMsg3\").innerText=msg1; //modified for MMS-KH-CRF-0029[IN070606]\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t        \n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<TABLE name=\"DrugInteractionList\" id=\"DrugInteractionList\" cellspacing=\"0\" cellpadding=\"3\" border=\"1\" width = \"100%\" style=\"BACKGROUND-COLOR:#FFFFCC\">   \n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'2\' align=\'center\'>&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;&nbsp;</td >\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">    \n\t\t\t\t\t\t\t\t\tRestriction Type</td>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;</td >\n</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\'15%\' style=\"color:red;BACKGROUND-COLOR:#FFFFCC\">\n\n\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t\t<td width=\'*\' style=\"color:red;BACKGROUND-COLOR:#FFFFCC\"><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></td >\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">RestrictTransaction\n\t\t\t\t\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/enabled.gif\'>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/disabled.gif\'>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t</td >\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">Remarks\n\t\t\t\t\t\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" commented RUT-SCF-0319 [IN:044814]-->\n\t\t\t\t\t\t\t\t\t</td > \n\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr> <td colspan=\'2\' style=\"BACKGROUND-COLOR:#FFFFCC\">&nbsp;</td>\n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t<TABLE name=\"DrugInteractionList\" id=\"DrugInteractionList\" cellspacing=\"0\" cellpadding=\"3\" border=\"1\" width = \"100%\" style=\"BACKGROUND-COLOR:#FFFFCC\">   \n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'2\' align=\'center\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td >\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
	
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
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
25-05-2022     AAKH-CRF-0140  PRATHYUSHA
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

			try{
				java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
				String patient_id				=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
				String drug_code		        = request.getParameter( "drug_code" )==null?"":request.getParameter("drug_code");
				String srl_no		        = request.getParameter( "srl_no" )==null?"":request.getParameter("srl_no");
				String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
				String bean_name		= "ePH.PrescriptionBean_1";
				String calledFor		        = request.getParameter( "CalledFro" )==null?"":request.getParameter("CalledFro");
			//	String intr_restric_trn		        = request.getParameter( "intr_restric_trn" )==null?"":request.getParameter("intr_restric_trn");
				String CalledFrom		        = request.getParameter( "calledFrom" )==null?"":request.getParameter("calledFrom");
				String fontStyle="color:blue;font-size:12;";
				String order_id		        = request.getParameter( "order_id" )==null?"":request.getParameter("order_id");
				String order_line_no		        = request.getParameter( "order_line_no" )==null?"":request.getParameter("order_line_no");
				String drug_class		        = "";//request.getParameter( "drug_class" )==null?"":request.getParameter("drug_class");
				String drug_desc		        ="";// request.getParameter( "drug_desc" )==null?"":request.getParameter("drug_desc");
				//added for aakh-crf-0140 start
				String abuse_restric_trn="N";// abuseDrugMap.get("RESTRICT_TRAN_TYPE");
				String abuse_exists="Y";// abuseDrugMap.get("Y");
				String abuse_remarks="";//abusedrugmap.get("REMARKS");
				String abuse_action="B";//abuseDrugMap.get("ACTION_TYPE_FLAG");
				String abuse_type="DC";//abuseDrugMap.get("RESTRICTION_TYPE");
				String abuse_value="";
				String abuse_type_value="";
				String drug_abuse_value="";
				//added for aakh-crf-0140 end
				//String fontStyle="font-size:12;";
				if(order_id==null || order_id.equals("undefined"))
					order_id="";
				ArrayList prescriptionDetails = null;
				PrescriptionBean_1 bean_1 = null; //MMS-KH-CRF-0034.4
				
				

				if(CalledFrom.equals("DD")){
					bean_id					= "DirectDispensingBean";
					bean_name		= "ePH.DirectDispensingBean";
					DirectDispensingBean bean	= (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
					bean.setLanguageId(locale);
					prescriptionDetails	=	bean.getpresDetails();
				}
				else{
					PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
					bean.setLanguageId(locale);
					prescriptionDetails	=	bean.getpresDetails();
					System.out.println("patient_id"+patient_id);
					System.out.println("drug_code"+drug_code);
					System.out.println("drug_class"+drug_class);
					drug_class=bean.getDrugClassByOrderId(drug_code);
					HashMap abuseData=bean.getabusedetails(patient_id, drug_code, drug_class);
					System.out.println("abuseData"+abuseData);
					abuse_restric_trn= (String)abuseData.get("restrict_tran");
					 abuse_exists= "Y";//(String)abuseData.get("ABUSE_EXISTS");
					 abuse_remarks= (String)abuseData.get("remarks");
					 abuse_action= (String)abuseData.get("action_type_flag");
					 abuse_type= (String)abuseData.get("restriction_type");
					 drug_desc=bean.getDrugDescByOrderId(drug_code);
					 abuse_value= (String)abuseData.get("DRUG_CLASS_OR_DRUG_CODE");
					 System.out.println("abuseData95"+abuseData);	
					 
					 System.out.println("abuseData95"+drug_desc+""+abuse_value+"abuse_type"+abuse_type);
					 System.out.println("abuseData95"+abuse_remarks+""+abuse_action+"abuse_restric_trn"+abuse_restric_trn);
					 if(abuse_value.equals("G")){
							abuse_value="General";
						}
						else if(abuse_value.equals("N")){
							abuse_value="Norcotics";
						}
						else{
							abuse_value="Controlled";
						}
						if(abuse_type.equals("DC")){
							abuse_type_value="Drug Class";
						}
						else{
							abuse_type_value="Drug Name";
						}
						if(abuse_type.equals("DN")){
							drug_abuse_value=drug_desc;	
						}
						else{
							drug_abuse_value=abuse_value;
						}
				}
					 
			
				StringBuffer intr_msg_content = new StringBuffer();
				StringBuffer intr_msg_content_drug_lab = new StringBuffer();
				System.out.println("calledFor");
				    if(calledFor.equals("Alert")){
				    	System.out.println("else 137");

						//added for MMS-KH-CRF-0029[IN070606] - start
						ArrayList drugLabInteractionList = new ArrayList();
						
						
										intr_msg_content.append("has been marked for Substance Abuse for the patient.<br>");
										intr_msg_content.append("The patient is under risk of overdose.Remarks entered in 'Substance Abuse' with restriction<br>");
										
										drugLabInteractionList.add(drug_desc + " " +intr_msg_content.toString());
						
						System.out.println("drugLabInteractionList115"+drugLabInteractionList);

						if(drugLabInteractionList!=null && drugLabInteractionList.size()>0){
						intr_msg_content_drug_lab = new 	StringBuffer();
							
								intr_msg_content_drug_lab.append("<hr size=1>");

								intr_msg_content_drug_lab.append((String)drugLabInteractionList.get(0));
								
							
							intr_msg_content_drug_lab = new 	StringBuffer(intr_msg_content_drug_lab.toString());  //Removed the encode for MMS-KH-CRF-0029[IN71814]
						}
						System.out.println("drugLabInteractionList115"+intr_msg_content_drug_lab);

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fontStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(intr_msg_content_drug_lab.toString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

									if(abuse_restric_trn.equals("Y")){

            _bw.write(_wl_block14Bytes, _wl_block14);

									}

            _bw.write(_wl_block15Bytes, _wl_block15);

					}
					else{
						System.out.println("else 205");
						if(abuse_exists.equals("Y")){
							System.out.println("abuse_exists 205"+abuse_exists);

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(abuse_type_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(abuse_type_value));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(drug_abuse_value));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

									if(abuse_restric_trn.equals("Y")){

            _bw.write(_wl_block22Bytes, _wl_block22);

									}
									else if(abuse_restric_trn.equals("N")){

            _bw.write(_wl_block23Bytes, _wl_block23);

									}

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(abuse_remarks));
            _bw.write(_wl_block27Bytes, _wl_block27);

							

            _bw.write(_wl_block28Bytes, _wl_block28);

						}
						else{

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						}
					}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}

            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugInteraction.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RestrictTransaction.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Interaction.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoDrugInteractionFound.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
