package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.placeorder.bc.PlaceOrderBC;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __blchargepatientencountertabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientEncounterTabs.jsp", 1738154011646L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<title>Charge Patient</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<Script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></Script>\n\n\n\n</head>\n\n <script>\n if($(\'#showBillDtl\').val() == \'Y\'){\n\t $(\'#finImg\').hide();\n }\n $(\'#finImg\').click(function(){\n\t  var retVal  =          new String();\n      var episode1  =\"\";\n      var dialogTop = \"200\";\n      var dialogHeight = \"42\" ; \n      var dialogWidth = \"70\" ; \n      var features = \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n      var arguments  = \"\" ;\n      var search_desc  =\"\"; \n      var title =getLabel(\"eBL.PAT_ENCOUNTER_FIN_DTLS.label\",\"BL\");\n\t    var column_sizes = escape(\"\");               \n      var column_descriptions =\"\";       \n      var param =            \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"episodeid=\"+\n      episodeid+\"&\"+\"visitid=\"+visitid+\"&\"+\"patientid=\"+patientid+\"&episode1=\"+episode1;\n      retVal=window.showModalDialog(\"../../eBL/jsp/BLFinDtlQryMain.jsp?\"+param,arguments,features);\n });\n function callOnMouseOver(obj){\n\t\tcurrClass = obj.className ;\n\t\t\tobj.className = \'CASECONDSELECTHORZ\';\n\t}\n\n\tfunction callOnMouseOut(obj){\n\t\tobj.className = currClass;\n\t}\n\n\tfunction changeColor(obj,from_name)\n\t{\n\t\tif(from_name==\"OR_BUTTONS\")\n\t\t\tcellref = criteriaCategoryButtonFrame.document.getElementById(\"tab\").rows[0].cells\n\t\telse if(from_name==\"COMMON\")\n\t\t\tcellref = document.getElementById(\"tab\").rows[0].cells\n\t\tfor(i=0; i<cellref.length; i++)\n\t\t{\n\t\t\tif(i!=2 && i!=3)\n\t\t\t cellref[i].className = \'CAFIRSTSELECTHORZ\'\n\t\t}\n\t\tobj.className = \"CASECONDSELECTHORZ\"\n\t\tcurrClass =\"CASECONDSELECTHORZ\";\n\t}\n\t\n\tfunction existingOrders(){\n\t\tchangeColor(this,\'COMMON\');\n\t\tvar frm = parent.BLChargePatientEncounterTabPage.document.forms[0];\n\t\tvar patient_id = frm.patient_id.value;\n\t\tvar episode_id = frm.episode_id.value;\n\t\tvar visit_id = frm.visit_id.value;\n\t\tvar encounter_date = frm.encounter_date.value;\n\t\tvar encounter_id = frm.encounter_id.value;\n\t\tvar episode_type = frm.episode_type.value;\n\t\tvar queryString = frm.queryString.value;\n\t\t//<input type=\'hidden\' id=\'allFramesExisting\' name=\'allFramesExisting\'  value=\'7%,0%,0%,6%,25%,28%,28%,0%,4%\'>\n\t\t//parent.document.getElementById(\'BL_mainFrame\').rows = parent.parent.document.getElementById(\'allFramesExisting\').value;\n\t\tparent.document.getElementById(\"pline\").style.height = \"7vh\";\n\t\tparent.document.getElementById(\'BillingBanner\').style.height = \"0vh\";\n\t\tparent.document.getElementById(\'BillingMenu\').style.height = \"0vh\";\n\t\tparent.document.getElementById(\'BLChargePatientEncounterTab\').style.height = \"6vh\";\n\t\tparent.document.getElementById(\'BLChargePatientEncounterTabPage\').style.height = \"25vh\";\n\t\tparent.document.getElementById(\'BLChargePatientExisOrderTraverse\').style.height = \"24vh\";\n\t\tparent.document.getElementById(\'BLChargePatientExisOrderServDetails\').style.height = \"25vh\";\n\t\tparent.document.getElementById(\'BLChargePatientExisOrderServEdit\').style.height = \"0vh\";\n\t\tparent.document.getElementById(\'messageFrame1\').style.height = \"4vh\";\n\t\tparent.BLChargePatientEncounterTabPage.location.href=\'BLChargePatientEncounterExistingOrder.jsp?\'+queryString+\"&encoded=Y\";//patient_id=\'+patient_id+\'&episode_id=\'+episode_id+\'&visit_id=\'+visit_id+\'&encounter_date=\'+encounter_date+\'&encounter_id=\'+encounter_id+\'&episode_type=\'+episode_type;\n\t\tparent.BLChargePatientExisOrderTraverse.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.BLChargePatientExisOrderServDetails.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.messageFrame1.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\tparent.BLChargePatientExisOrderServEdit.location.href = \"../../eCommon/html/blank.html\";\n\t}\n\t\n\tfunction newOrders(){\n\t\tif($(\'#enterServiceRequest\').val() != \'Y\'){\n\t\t\talert(getMessage(\'BL1178\',\'BL\'));\n\t\t\treturn false;\n\t\t}\n\t\tchangeColor(this,\'COMMON\');\t\n\t\tvar frm = parent.BLChargePatientEncounterTabPage.document.forms[0];\n\t\tvar patient_id = frm.patient_id.value;\n\t\tvar episode_id = frm.episode_id.value;\n\t\tvar visit_id = frm.visit_id.value;\n\t\tvar encounter_date = frm.encounter_date.value;\n\t\tvar encounter_id = frm.encounter_id.value;\n\t\tvar episode_type = frm.episode_type.value;\n\t\tvar queryString = frm.queryString.value;\n\t\tparent.BLChargePatientEncounterTabPage.location.href=\'BLChargePatientEncounterNewOrder.jsp?\'+queryString;//patient_id=\'+patient_id+\'&episode_id=\'+episode_id+\'&visit_id=\'+visit_id+\'&encounter_date=\'+encounter_date+\'&encounter_id=\'+encounter_id+\'&episode_type=\'+episode_type;\n\t\tparent.BLChargePatientExisOrderTraverse.location.href=\'../../eCommon/html/blank.html\';\n\t\tparent.BLChargePatientExisOrderServDetails.location.href=\'../../eCommon/html/blank.html\';\n\t\t//parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\tparent.messageFrame1.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\tparent.BLChargePatientExisOrderServEdit.location.href = \"../../eCommon/html/blank.html\";\n\t}\n\t/*function futureOrder(){\n\t\tvar frm = parent.BLChargePatientEncounterTabPage.document.forms[0];\n\t\tvar patient_id = frm.patient_id.value;\n\t\tvar episode_id = frm.episode_id.value;\n\t\tvar visit_id = frm.visit_id.value;\n\t\t\n\t\tvar episode_type = frm.episode_type.value;\n\t\tvar facility_id=frm.facility_id.value;\n\t\talert(facility_id);\n\t\t\n\t\t$.ajax({\n\t\t\ttype:\"POST\",\n\t\t\turl:\"../jsp/BLFutureOrder.jsp\",\n\t\t\tdata:\" &patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&episode_type=\"+episode_type+\"&facility_id=\"+facility_id,\t\n\t\t\tsuccess: function(data){\t\n\t\t\tvar arr= data.split(\"::\");\n\t\t\talert(arr);\n\t\t\t\tif(arr[0]==\'Y\'){\n\t\t\t\t\t\n\t\t\t\t\talert(getMessage(arr[1],\'BL\'));\n\t\t\t\t\treturn;\n\t\t\t\t}\n\t\t\t},\n\t\t\t error: function(data){\n\t\talert(\"error\");\n\t\t     }\n\t\t});\n\n\t\t\t\n\t\t\t}*/\n </script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!-- Selected stuff should be highlighted in black use:CASECONDSELECTHORZ-->\n\n<form name=\"ChargePatientEncounterTabsForm\" id=\"ChargePatientEncounterTabsForm\">\n\t<table id=\"tab\" cellspacing=0 cellpadding=\"3\" border=\"0\" width=\"20%\">\n\n\t<tr>\n\t\t\t<td id=\"ExistingOrder\" \tclass=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"existingOrders();\" nowrap>\n\t\t\t<a style=\'color:white;cursor:pointer\' href=\"#\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a>\n\t\t\t</td>\n\t\t\t<!--added against MOHE-CRF-0039--> \n\t\t\t<td id=\"NewOrder\" \tclass=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style=\"\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"newOrders();\" nowrap>\n\t\t\t<a  style=\'color:white;cursor:pointer\' href=\"#\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a>\n\t\t\t</td>\t\t\t\n\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'enterServiceRequest\' id=\'enterServiceRequest\'  value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' >\n\t<input type=\'hidden\' name=\'confirmServiceRequest\' id=\'confirmServiceRequest\'  value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' >\n\t<input type=\'hidden\' name=\'cancelConfirmedService\' id=\'cancelConfirmedService\'  value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' >\n\t<input type=\'hidden\' name=\'cancelSelfEntered\' id=\'cancelSelfEntered\'  value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' >\n\t<input type=\'hidden\' name=\'cancelIndirect\' id=\'cancelIndirect\'  value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' >\n\t<input type=\'hidden\' name=\'enterNegative\' id=\'enterNegative\'  value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\t\n\t<input type=\'hidden\' name=\'noOfDecimals\' id=\'noOfDecimals\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >\n</form>\n</body>\n</html> \n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
  
request.setCharacterEncoding("UTF-8");
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String bl_install_yn = (String)session.getValue("bl_operational") == null ? "" : (String)session.getValue("bl_operational");
String user = (String) session.getValue("login_user");
String facilityId = (String) session.getValue("facility_id");
System.out.println("Bl Install YN ,BLChargePatientEncounterTabs.jsp->"+bl_install_yn);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String existing_order_class="";
	String new_order_class="";
	String selectedTab=(String)request.getParameter("selectedTab");
	PlaceOrderBC placeOrderBC = new PlaceOrderBC();
	String[] privelege = placeOrderBC.getPrivilegeForUser(user, facilityId);
	String enterServiceRequest = privelege[1];
	String confirmServiceRequest = privelege[2];
	String cancelConfirmedService = privelege[3];
	String cancelSelfEntered = privelege[4];
	String cancelIndirect = privelege[5];
	String enterNegative = privelege[7];

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String noOfDecimals = "";
	try{
		con = ConnectionManager.getConnection();
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) no_of_decimal from  sm_acc_entity_param");
		rst = pstmt.executeQuery();
		if(rst != null && rst.next()){
			noOfDecimals = rst.getString("no_of_decimal");
			System.err.println("noOfDecimals "+noOfDecimals);
		}
	}
	catch(Exception eX){	
		noOfDecimals = "2";
		System.err.println("Exception in getting Charge Logic YN ->"+eX);
	}
	finally{
		pstmt = null;
		rst = null;
		ConnectionManager.returnConnection(con);
	}
	if(selectedTab.equalsIgnoreCase("ExistingOrder")){
		existing_order_class="CASECONDSELECTHORZ";
		new_order_class="CAFIRSTSELECTHORZ";
	}else if(selectedTab.equalsIgnoreCase("NewOrder")){
		existing_order_class="CAFIRSTSELECTHORZ";
		new_order_class="CASECONDSELECTHORZ";
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(existing_order_class));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(new_order_class));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(enterServiceRequest ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(confirmServiceRequest ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cancelConfirmedService ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cancelSelfEntered ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cancelIndirect ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(enterNegative ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(noOfDecimals ));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EXISTING_ORDERS.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NEW_ORDERS.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
