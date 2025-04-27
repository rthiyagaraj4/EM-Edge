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
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __medicationplannerprint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationPlannerPrint.jsp", 1709120957892L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<style type=\"text/css\"> \n\t\t\tTH {background:none;COLOR: black;background-color:white;}\n\t\t\t@media print {\n\t\t\tthead { display: table-header-group; }\n\t\t\ttfoot { display: table-footer-group; }}\n\t\t\t@media screen {\n\t\t\tthead { display: block; }\n\t\t\ttfoot { display: block; }}\n\t\t\t.wrapword{COLOR:black;FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;word-wrap: break-word;word-break: keep-all;display: inline-block;}\n\t\t</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form action=\"\" name=\"formMedicationPlannerPrint\" id=\"formMedicationPlannerPrint\" method=\"post\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<br>\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t<thead>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th colspan=\"9\" style=\"font-size:13\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th colspan=\"9\" style=\"font-size:13\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th colspan=\"9\" style=\"font-size:13\"> Medication Plan Sheet</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th colspan=\"3\" style=\"text-align:left\">Patient ID : ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t\t<th colspan=\"5\" style=\"text-align:left\">Patient Name : ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t\t\t<th style=\"text-align:left\">Dispensing Date : ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >No.</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Drug Name</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Qty Issue&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img></th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >How To Take</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Morning</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Afternoon</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Evening</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Night</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Important Notes</th>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"1%\" class=\"wrapword\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td width=\"15%\" class=\"wrapword\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;</td>\n\t\t\t\t\t<td width=\"8%\" class=\"wrapword\" style=\'text-align:center;\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</td>\n\t\t\t\t\t<td width=\"18%\" class=\"wrapword\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;</td>\n\t\t\t\t\t<td width=\"26%\" class=\"wrapword\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;</td>\n\t\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" colspan=\"8\" style=\"text-align:right\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" :&nbsp;</td>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</table>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t<br>\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t<thead>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th colspan=\"9\" style=\"font-size:13\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th colspan=\"9\" style=\"font-size:13\">Pelan Medikasi</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th colspan=\"3\" style=\"text-align:left\">No.Pendaftaran : ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n\t\t\t\t\t\t<th colspan=\"5\" style=\"text-align:left\">Nama Pesakit : ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t\t\t\t\t<th style=\"text-align:left\">Tarikh Pemberian : ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >No.</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Nama Ubat Awda</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Kuantiti Dibekalkan&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img></th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Cara Penggunaan</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Pagi</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Tengah Hari</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Petang</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Malam</th>\n\t\t\t\t\t\t<th class=\"COLUMNHEADER\" >Nota Penting</th>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"1%\" class=\"wrapword\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;</td>\n\t\t\t\t</tr>\t\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\" colspan=\"8\" style=\"text-align:right\">Jumlah Harga Ubat :&nbsp;</td>\n\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n\t\t<br>\t\n\t\t\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</form>\n</body>\n<script>\n\twindow.onload=function(){\n\t\twindow.print();\n\t\twindow.focus();\n\t\t//window.close();\n\t\twindow.onfocus=function(){ window.close();}\n\t}\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try {
		String  strarrKey[] = new String[4];
		MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); 
		DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( "DispMedicationBean", "ePH.DispMedicationBean",request);
		medplan_bean.setObject(dispBean);
		medplan_bean.setLanguageId(locale);
		
		String sysdate = dispBean.getTodaysDate();
		if(sysdate.equals(""))
			sysdate = com.ehis.util.DateUtils.getCurrentDate("DMY", locale);
		String facility_id = (String) session.getValue("facility_id");
		HashMap hshDrugMap = medplan_bean.getMedPlan_DrugDetails();
		Set <String> hshKeys = new HashSet<String>();
		hshKeys = hshDrugMap.keySet();
		HashMap hshtemp = new HashMap();
		int i=0;
		String plan_recorded="",chkdrug="";
		boolean boolmedplan=false,boolmedplanlocal=false;
		if(hshKeys!=null && hshKeys.size()>0){
			for(String key:hshKeys){
				hshtemp = (HashMap)hshDrugMap.get(key);
				plan_recorded = (String)hshtemp.get("plan_recorded");
				chkdrug = (String)hshtemp.get("chkdrug");
				if(plan_recorded.equals("Y") && chkdrug.equals("E"))
					boolmedplan=true;
			}
		}

            _bw.write(_wl_block9Bytes, _wl_block9);
	if(boolmedplan){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(medplan_bean.getStrSiteName()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(medplan_bean.getStrFacility_DispLoc()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dispBean.getPatient_name(patient_id,medplan_bean.getStrPrimaryLangID())));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block15Bytes, _wl_block15);
				for(String key:hshKeys){
						hshtemp = (HashMap)hshDrugMap.get(key);
						strarrKey = key.split("_");
						plan_recorded = (String)hshtemp.get("plan_recorded");
						chkdrug = (String)hshtemp.get("chkdrug");
						if(plan_recorded.equals("Y") && chkdrug.equals("E")){
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(++i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)hshtemp.get("drug_name")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("qty_issue")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)hshtemp.get("howtotake")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("morning")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("afternoon")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("evening")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("night")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)hshtemp.get("impnote")));
            _bw.write(_wl_block21Bytes, _wl_block21);
			}}		
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(medplan_bean.getStrTotal_gross_charge_amount()));
            _bw.write(_wl_block21Bytes, _wl_block21);
			} 
            _bw.write(_wl_block25Bytes, _wl_block25);
			hshDrugMap = medplan_bean.getMedPlan_Local_DrugDetails();
				hshKeys = hshDrugMap.keySet();i=0;
				if(hshKeys!=null && hshKeys.size()>0){
					for(String key:hshKeys){
						hshtemp = (HashMap)hshDrugMap.get(key);
						plan_recorded = (String)hshtemp.get("plan_recorded");
						chkdrug = (String)hshtemp.get("chkdrug");
						if(plan_recorded.equals("Y") && chkdrug.equals("E"))
							boolmedplanlocal = true;
					}
				}
				if(boolmedplanlocal){
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(medplan_bean.getStrSiteNameLocal()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(medplan_bean.getStrFacility_DispLocLocal()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dispBean.getPatient_name(patient_id,medplan_bean.getStrLocalLangID())));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block30Bytes, _wl_block30);
				for(String key:hshKeys){
						hshtemp = (HashMap)hshDrugMap.get(key);
						strarrKey = key.split("_");
						plan_recorded = (String)hshtemp.get("plan_recorded");
						chkdrug = (String)hshtemp.get("chkdrug");
						if(plan_recorded.equals("Y") && chkdrug.equals("E")){
	
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(++i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)hshtemp.get("drug_name")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("qty_issuelocal")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)hshtemp.get("howtotake")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("morninglocal")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("afternoonlocal")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("eveninglocal")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)hshtemp.get("nightlocal")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)hshtemp.get("impnote")));
            _bw.write(_wl_block32Bytes, _wl_block32);
		}} 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(medplan_bean.getStrTotal_gross_charge_amount()));
            _bw.write(_wl_block34Bytes, _wl_block34);
		} 
            _bw.write(_wl_block35Bytes, _wl_block35);
} catch (Exception exception) {
		exception.printStackTrace();
	}

            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicationPlanSheet.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Price.label", java.lang.String .class,"key"));
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
}
