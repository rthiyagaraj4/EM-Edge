package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __cahealthriskassessmentordercatalogs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAHealthRiskAssessmentOrderCatalogs.jsp", 1737957680755L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------\nDate       \t\tEdit History   Name       Description\n-----------------------------------------------------------------------\n22/03/2013\tIN030469\tDineshT\t\tOrder Entry Place order screen to show catalogs on load\n07/05/2013  IN039476\tAkbar\t\tNot to display Place order button for patient without encounter\n27/07/2022\t26826\t\tRamesh G\tMMS-DM-CRF-0197\n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCA/js/RiskFactorGroup.js\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nvar check_box_value = new Array();\nvar totalChecked = 0;\n\nasync function showPlaceOrderScreen(reqString,patId,encId)\n{\n\t\n\t//var xmlDoc \t\t\t\t= new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\t//var xmlHttp \t\t\t= new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;\n\nvar xmlDoc = \"\"; \nvar xmlHttp = new XMLHttpRequest();\t\n \txmlStr\t\t\t\t\t= \"<root><SEARCH \" ;\n\n\tif(parseInt(totalChecked)==0)\n\t{\n\t\talert(\"APP-CA0401 Atleaset one catalog should be selected\");\n\t\treturn;\n\t}\n\n\tform_obj = document.CAHealthRiskAssessmentOrderCatalogsForm;\n\n   \tvar formObj \t\t\t= form_obj.elements;\n\t\n\tfor(var i=0;i<formObj.length;i++)\n\t{\n\t\tvar value \t\t= \"\" ;\n\n\t\tif(formObj[i].type == \"checkbox\")\n\t\t{\n\t\t\tif(formObj[i].checked && !formObj[i].disabled)\n\t\t\t\tvalue \t= formObj[i].value;\n\n\t\t\tif(formObj[i].name != null && formObj[i].name != \"\" && !formObj[i].disabled)\n\t\t\t\txmlStr\t+= formObj[i].name+\"=\\\"\" + (value) + \"\\\" \" ;//IN030469\n\t\t}\n\t\telse if(formObj[i].type == \"hidden\")\n\t\t{\n\t\t\tvalue\t= formObj[i].value;\n\t\t\txmlStr\t+= formObj[i].name+\"=\\\"\" + escape(value) + \"\\\" \" ;\n\t\t}\n\t}\n\txmlStr += \" CHECK_BOX_VALUE = \\\"\"+check_box_value+\"\\\" \";\n\n\tbean_id = \"@orderentrybean\"+patId+encId;\n\tbean_name = \"eOR.OrderEntryBean\";\n\t\n\txmlStr \t\t\t+=\" /></root>\" ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open( \"POST\", \"../../eOR/jsp/OrderEntryStoreValues.jsp?\"+reqString+\"&bean_id=\" + bean_id + \"&bean_name=\"+ bean_name+\"&function_from=STORE_ASSESS_CATALOG&l_patientId=\"+patId+\"&l_encounter_id=\"+encId, false ) ;//IN030469\n\txmlHttp.send( xmlDoc ) ;\n\tresponseText=xmlHttp.responseText ;\n\teval( responseText ) ;\n\n\tvar dialogHeight =\'90vh\' ;\n\tvar dialogWidth = \'90vw\' ;\n\tvar dialogTop\t= \'\';\n\tvar dialogLeft = \'\' ;\n\n\treqString = \"option_id=NEW_ORDER&\"+reqString\n\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';dialogTop:\'+dialogTop+\';dialogLeft:\'+dialogLeft+\'; scroll=no; status=no\';\n\tvar retVals = await top.window.showModalDialog(\"../../eOR/jsp/EnterOrder.jsp?\"+reqString+\"&function_from=HIGH_RISK_ASSESS&bean_id=\"+bean_id+\"&bean_name=\"+bean_name+\"&check_box_value=\"+check_box_value,arguments,features);\n\t\n}\n\n//function onclickCatalog(thisObj)  //26826\nfunction onclickCatalog(thisObj,orderCategory)//26826\n{\t\t\n\tif(thisObj.checked)\n\t{\tif(eval(\"document.CAHealthRiskAssessmentOrderCatalogsForm.dxChkBfrPlaceOrder\"+orderCategory).value==\'Y\' && document.CAHealthRiskAssessmentOrderCatalogsForm.dxChkBfrPlaceOrderSpec.value==\"Y\" ){  ////26826\n\t\t\tcheck_box_value[check_box_value.length]=thisObj.name;\n\t\t\ttotalChecked = parseInt(totalChecked)+1;\n\t\t//26826 Start.\n\t\t}else{\n\t\t\talert(getMessage(\"DIAG_NOT_RECORDED\",\"OR\"));\n\t\t\tthisObj.checked=false;\n\t\t}\n\t\t////26826 End.\n\t}\n\telse\n\t{\n\t\tfor(i=0;i<check_box_value.length;i++)\n\t\t{\n\t\t\tif(thisObj.name == check_box_value[i])\n\t\t\t{\n\t\t\t\tdelete(check_box_value[i]);\t\t\n\t\t\t\ttotalChecked = parseInt(totalChecked)-1\n\t\t\t}\n\t\t}\n\t}\t\n}\n</script>\n\n</head>\n<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form name=\'CAHealthRiskAssessmentOrderCatalogsForm\' id=\'CAHealthRiskAssessmentOrderCatalogsForm\'>\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\t\n\t<tr style=\"height:30px\" width=\'100%\'>\n\t\t<th class=\'columnHeadercenter\' colspan=\"2\" width=\"100%\" align=\"center\">Order Catalogs for Screening</th>\n\t\t<!--IN039476/start-->\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<!--IN039476/End-->\n\t\t<th class=\'columnHeadercenter\'  width=\"100%\" align=\"right\"><input type=\"button\"  value=\"Place Order\" onclick=\"showPlaceOrderScreen(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\" /></th>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="  <!--IN039476-->\n\t</tr>\n\n\t<tr width=\'100%\'>\n\t\t<td valign=\"top\" colspan=\"3\">\n\t\t\t<DIV style=\"height:160px;overflow:auto;\" id =\'catalogTable\'>\n\t\t\t\n\t\t\t\n\t\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t\t\n\t\t\t\t\t\t<tr>\t\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'fields\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\"5%\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'fields\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\'fields\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderSpec\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderMI\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderOT\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderCN\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderLB\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderTR\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderPC\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderPH\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderNC\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderDS\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderRX\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderRD\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderCS\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"> <!-- 26826 -->\n\t\t\t\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderOH\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"> <!-- 26826 -->\n\t\t\t</DIV>\n\t\t</td>\n\t</tr>\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String reqString = request.getQueryString();
reqString=reqString.replaceAll("&option_id=CA_HEALTH_RISK","&option_id=NEW_ORDER");
String patid=request.getParameter("Patient_ID"); 
String encId=request.getParameter("encounter_id"); 
String defaultDiag = request.getParameter("TermSetCode")==null?"":(String)request.getParameter("TermSetCode");
String[] defaultDiag_=defaultDiag.split("\\|");
defaultDiag="";
for(int i=0;i<defaultDiag_.length;i++){
	defaultDiag=defaultDiag+"'"+defaultDiag_[i]+"'";
	if((i+1)!=defaultDiag_.length)
		defaultDiag=defaultDiag+",";
}
//26826 Start.
String patient_class =request.getParameter("patient_class")==null?"":(String)request.getParameter("patient_class");
String facility_id				= (String)session.getValue("facility_id");
String or_bean_id 						= "@orderentrybean"+patid+encId;
String or_bean_name 					= "eOR.OrderEntryBean";
OrderEntryBean bean					= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
bean.setLanguageId(localeName);
HashMap  dxChkBfrPlaceOrderMap=new HashMap();
//26826 End.	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		if(!"".equals(encId)){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(reqString));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encId));
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block12Bytes, _wl_block12);

				PreparedStatement pstmt2 = null;
				ResultSet rs2 = null;
				Connection con = null;
				System.out.println("	CAHealthRiskAssessmentOrderCatalogs.jsp===============>"+defaultDiag+"<------");
				String qry2 = "SELECT distinct A.ORDER_CATALOG_CODE CODE,B.SHORT_DESC DESCRIPTION,b.ORDER_CATEGORY,b.ORDER_TYPE_CODE FROM OR_ORDER_SET_COMPONENT A, OR_ORDER_CATALOG B WHERE A.ORDER_CATALOG_CODE = B.ORDER_CATALOG_CODE AND A.ORDER_SET_CODE IN (SELECT ORDER_SET_CODE FROM OR_ORDER_SET_BY_INDEX WHERE DIAGNOSIS_CODE IN ("+defaultDiag+"))";

				System.out.println("CAHealthRiskAssessmentOrderCatalogs.jsp,100,qry2=>"+qry2);
				try
				{
					con = ConnectionManager.getConnection(request);
					//int cnt = 0; //Checkstyle 4.0 Beta 6
					
					pstmt2 = con.prepareStatement(qry2);
					rs2 = pstmt2.executeQuery();					

					while(rs2!=null && rs2.next())
					{
						//String ORDER_CATALOG_CODE  = rs2.getString("CODE")==null?"":(String)rs2.getString("CODE"); //Checkstyle 4.0 Beta 6
						String catalogCode1 = "<input type ='checkbox' name = 'ck"+rs2.getString("CODE")+"' value='Y' onclick = \"onclickCatalog(this,'"+rs2.getString("ORDER_CATEGORY")+"')\"/>";
						catalogCode1 = catalogCode1 + "<input type = 'hidden' name = 'h1"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_CATEGORY")+"'/>";//IN030469
						catalogCode1 = catalogCode1 + "<input type = 'hidden' name = 'h2"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_TYPE_CODE")+"'/>";//IN030469
						String catalogDesc1 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");
						String catalogCode2 = "&nbsp;";
						String catalogDesc2 = "&nbsp;";
						String catalogCode3 = "&nbsp;";
						String catalogDesc3 = "&nbsp;";
						String catalogCode4 = "&nbsp;";
						String catalogDesc4 = "&nbsp;";
						catalogDesc1 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");//IN030469
						if(rs2.next()){
							catalogCode2 = "<input type ='checkbox' name = 'ck"+rs2.getString("CODE")+"' value='Y' onclick = \"onclickCatalog(this,'"+rs2.getString("ORDER_CATEGORY")+"')\"/>";
							catalogCode2 = catalogCode2 + "<input type = 'hidden' name = 'h1"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_CATEGORY")+"'/>";
							catalogCode2 = catalogCode2 + "<input type = 'hidden' name = 'h2"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_TYPE_CODE")+"'/>";
							catalogDesc2 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");
						}
						if(rs2.next()){
							catalogCode3 = "<input type ='checkbox' name = 'ck"+rs2.getString("CODE")+"' value='Y' onclick = \"onclickCatalog(this,'"+rs2.getString("ORDER_CATEGORY")+"')\"/>";
							catalogCode3 = catalogCode3 + "<input type = 'hidden' name = 'h1"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_CATEGORY")+"'/>";
							catalogCode3 = catalogCode3 + "<input type = 'hidden' name = 'h2"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_TYPE_CODE")+"'/>";
							catalogDesc3 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");
						}
						if(rs2.next()){
							catalogCode4 = "<input type ='checkbox' name = 'ck"+rs2.getString("CODE")+"' value='Y' onclick = \"onclickCatalog(this,'"+rs2.getString("ORDER_CATEGORY")+"')\"/>";
							catalogCode4 = catalogCode4 + "<input type = 'hidden' name = 'h1"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_CATEGORY")+"'/>";
							catalogCode4 = catalogCode4 + "<input type = 'hidden' name = 'h2"+rs2.getString("CODE")+"' value = '"+rs2.getString("ORDER_TYPE_CODE")+"'/>";
							catalogDesc4 = rs2.getString("DESCRIPTION")==null?"":(String)rs2.getString("DESCRIPTION");
						}
						System.out.println("CAHealthRiskAssessmentOrderCatalogs.jsp,138,catalogCode1=>"+catalogCode1+",catalogCode2=>"+catalogCode2+",catalogCode3=>"+catalogCode3+",catalogCode4=>"+catalogCode4);
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(catalogDesc1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(catalogCode1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(catalogDesc2));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(catalogCode2));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(catalogDesc3));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(catalogCode3));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(catalogDesc4));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(catalogCode4));
            _bw.write(_wl_block17Bytes, _wl_block17);

					}
					
					
					dxChkBfrPlaceOrderMap = bean.allowedNewOrders(patid,encId,patient_class,facility_id,"");//26826
				}
				catch(Exception e)
				{
					e.printStackTrace();				
				}finally
				{
						if(pstmt2!=null)pstmt2.close();			
						if(rs2!=null)rs2.close();
						if(con!=null)con.close();
				}
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderSpec")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderMI")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOT")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCN")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderLB")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderTR")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPC")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPH")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderNC")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderDS")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRX")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRD")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCS")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOH")));
            _bw.write(_wl_block32Bytes, _wl_block32);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
