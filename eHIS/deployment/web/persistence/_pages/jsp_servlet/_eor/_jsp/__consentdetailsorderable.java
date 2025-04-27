package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __consentdetailsorderable extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ConsentDetailsOrderable.jsp", 1731500448000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n04/09/2012    IN034888        Menaka V     CRF-CA- Bru-HIMS-CRF-121/01-Only One Orderable is displayed\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<head>\n\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" --";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script type=\"text/javascript\" \tsrc=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOR/js/ConsentDetails.js\"></script>\n</head>\n\n<body Onload=\'FocusFirstElement()\'  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\'; \ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<form name=\'formConsentOrderable\' id=\'formConsentOrderable\'  action=\"../../eOR/jsp/ConsentNotesValidate.jsp\" method=\'POST\'>\n\n<table cellpadding=3 cellspacing=0 border=\'0\' width=\"100%\" height=\"100%\" align=\"center\">\n<tr>\n\n<td colspan=\'3\' class=\"Label\" >\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<table cellpadding=3 cellspacing=0 border=1 width=\"100%\">\n\t\t<tr>\n\t\t\t<td class=COLUMNHEADER width=\'50%\' colspan=\'\'> <font size=\"1\"><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></font> </td>\n\t\t\t<td class=COLUMNHEADER width=\'50%\'><font size=\"1\"><B>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</B></font><!--<input type=\"checkbox\" name=\"cat_chk\" id=\"cat_chk\" onClick=\'selectAll(\"\")\'>--></td>\n\t\t\t\t\n\t\t</tr>\n\t\t</table>\n\t\t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" class=\"grid\">\n\t<tr> \n\t\t<td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" colspan=\'\' width=\'50%\' ><font size=\"1\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font></td>\n\n\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" width=\'50%\' ><font size=\"1\"><A class=\'gridLink\' href=\'javascript:consentNotes(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\")\')>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></font><!--<input type=\"checkbox\" name=\"chk";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"chk";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onClick=\'chkValidate(";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\'>--></td>\n\t</tr>\n\t\t<input type=hidden name=\'catalog_cd";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'catalog_cd";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'\'>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</table>\n</td>\n\t\t<input type=hidden name=\'cat_cnt\' id=\'cat_cnt\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type=\'hidden\' name=\'orderable_chk\' id=\'orderable_chk\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<input type=\'hidden\' name=\"query_string\" id=\"query_string\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t \n  \t\t<input type=\"hidden\" name=\"new_consent_format_id\" id=\"new_consent_format_id\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\"hidden\" name=\"new_consent_format_label\" id=\"new_consent_format_label\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<!-- EMR - Ramesh  --->\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\"hidden\" name=\"index\" id=\"index\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type=\"hidden\" name=\"task_categ\" id=\"task_categ\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<!-- EMR - Ramesh --->\n\n</tr>\n\n\n\n</table>\n \t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<script>consentNotes(\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\")</script>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n</form>\n</body>\n</html>\n<script>//selectAll(\'load\');</script>\n\n\n \n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block2Bytes, _wl_block2);
 String patient_details= request.getParameter("patientdetails");
if(patient_details == null || patient_details.equals("null")) patient_details =" "; else patient_details = patient_details.trim();

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_details));
            _bw.write(_wl_block11Bytes, _wl_block11);

	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block13Bytes, _wl_block13);


	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";

String pat_name_def			= request.getParameter( "pat_name_def");
String patient_name			= request.getParameter( "patient_name" ) ;
String practitioner_name	= request.getParameter( "practitioner_name" ) ;
String order_pract_name		= request.getParameter( "order_pract_name" ) ;
String curr_sys_date		= request.getParameter( "curr_sys_date" ) ;
String remarks				= request.getParameter( "remarks" ) ;
String ord_id				= request.getParameter("ord_id");
//String Consent_detail		= request.getParameter("Consent_detail");
//String flag					= request.getParameter("flag");
String self					= request.getParameter("self");
String pract_id				= request.getParameter("pract_id");
String relation				= request.getParameter("relation");
String relation_text		= request.getParameter("relation_text");
String index			    = request.getParameter("index");
String order_catalog_cd		= request.getParameter("orderable_val");
//String catalog_code			= "";
String patient_id			= request.getParameter("patient_id");
String encounter_id			= request.getParameter("encounter_id");
String facility_id			= (String)session.getValue("facility_id");
String order_line_num		= request.getParameter("ord_line_num");
String consent_frm_id		= request.getParameter("consent_frm_id");
String task_categ				= request.getParameter("task_categ"); // EMR - Ramesh 

//if(order_catalog_cd == null || order_catalog_cd.equals("null")) order_catalog_cd =""; else order_catalog_cd = order_catalog_cd.trim();
 //out.println("<script>alert('order_catalog_cd--"+order_catalog_cd+"')</script>");
// if(Consent_detail == null){
// }
if(self == null || self.equals("null")) self =""; else self = self.trim();
if(patient_id == null || patient_id.equals("null")) patient_id =""; else patient_id = patient_id.trim();
if(encounter_id == null || encounter_id.equals("null")) encounter_id =" "; else encounter_id = encounter_id.trim();
if(patient_name == null || patient_name.equals("null")) patient_name =" "; else patient_name = patient_name.trim();
if(practitioner_name == null || practitioner_name.equals("null")) practitioner_name =" "; else practitioner_name = practitioner_name.trim();
if(order_pract_name == null || order_pract_name.equals("null")) order_pract_name =" "; else order_pract_name = order_pract_name.trim();
if(curr_sys_date == null || curr_sys_date.equals("null")) curr_sys_date =" "; else curr_sys_date = curr_sys_date.trim();
if(remarks == null || remarks.equals("null")) remarks =" "; else remarks = remarks.trim();
if(ord_id == null || ord_id.equals("null")) ord_id =" "; else ord_id = ord_id.trim();

if(pract_id == null || pract_id.equals("null")) pract_id =" "; else pract_id = pract_id.trim();
if(relation == null || relation.equals("null")) relation =" "; else relation = relation.trim();
if(relation_text == null || relation_text.equals("null")) relation_text =" "; else relation_text= relation_text.trim();
if(pat_name_def == null || pat_name_def.equals("null")) pat_name_def =" "; else pat_name_def = pat_name_def.trim();
if(order_line_num == null ) order_line_num =""; 
if(consent_frm_id == null) consent_frm_id =""; 

 
/*
if(remarks != ""){
	//remarks = java.net.URLDecoder.decode(remarks);
}
*/
//String ConsentFormId="";
ArrayList ConsentFormId = null;
String order_catalog_code = ""; //String Consent_detail="";
StringBuffer order_catalog_desc = new StringBuffer();
StringBuffer order_consent_format  = new StringBuffer();
String consent_format	  = "";
StringBuffer order_consent_id= new StringBuffer();
String consent_form_id	  = "";
StringBuffer order_consent_form_label = new StringBuffer();
String consent_form_label = "",  old_consent_format_id	  = "";
String first_consent_format_id  = "";

StringBuffer new_consent_format_id = new StringBuffer();
StringBuffer new_consent_format_label = new StringBuffer();

//HashMap consentCatalog = new HashMap();

//if(flag.equals("yes") ){
	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id,  bean_name, request ) ;
		bean.setLanguageId(localeName);
		//bean.clearHash();	 
		//ConsentFormId = bean.getFormId(ord_id) ;
		//if(ConsentFormId == null) ConsentFormId ="";
		ConsentFormId = bean.getFormId(ord_id);
		if(order_line_num.equals("") || consent_frm_id.equals("")){
			ConsentFormId = bean.getFormId(ord_id);
		}else{
			
			ConsentFormId = bean.getFormId(ord_id,order_line_num,consent_frm_id);
		}
		HashMap consent= (HashMap)bean.getConsentDetail();
 		String consent_details = "";
		ArrayList consent_ids = new ArrayList(); //--[IN034888]
 		if(ConsentFormId.size()>0){
			//--[IN034888]-Commentted - Start
			/*for(int j=0; j<ConsentFormId.size(); j++)
			{
				
				String[] records = (String[]) ConsentFormId.get(j);
				if(records[0]!=null && !records[0].equals("") && !records[0].equals(old_consent_format_id))
				{
					if(consent!=null && consent.size()>0 )
						consent_details = (String)consent.get(index+records[0].trim());
  					if(consent==null || consent_details==null || consent_details.equals("")  )
					{
						if(patient_id.equals(""))
						{
							if(!patient_details.equals(""))
							{
								patient_id = patient_details.substring((patient_details.indexOf(",ID:")+4));
								if(patient_id == null || patient_id.equals("null")) 
									patient_id =""; 
								else 
									patient_id = patient_id.trim();
							}
						}						
						bean.getConsentDetail(records[0].trim(),index,   records[3],   patient_id, facility_id, encounter_id, ord_id) ;		
 					}

 					if(first_consent_format_id==null || first_consent_format_id.equals("")){
						first_consent_format_id = records[0].trim();
 					}
					//order_catalog_code += records[1]+"||"; 
					order_catalog_desc.append(records[2]+"||"); 
					if(order_catalog_desc==null) order_catalog_desc.append("~~");
					order_consent_format.append(records[3]+"||"); 
					if(order_consent_format==null) order_consent_format.append("~~");
					order_consent_id.append(records[0]+"||"); 
					if((order_consent_id==null)|| (order_consent_id.equals(""))) order_consent_id.append("~~");
					order_consent_form_label.append(records[4]+"||"); 
					if(order_consent_form_label==null) order_consent_form_label.append("~~");
 
  					//Consent_detail = (String)consent.get(index+records[0]);
 					//if(Consent_detail==null){
					//	Consent_detail= "";
					//	bean.getConsentDetail(records[0].trim(),index, records[1]) ;
					//}
					old_consent_format_id = records[0];
					consent_ids.add(records[0]);
				} else
				{  //concatenate the description
					// THEN REMOVE THE LAST || TO APPEND THE DESCRIPTION
					if(!consent_ids.contains(records[0]))
					{
					
				if(order_catalog_desc.lastIndexOf("||")!=-1) {
												
						order_catalog_desc.append(order_catalog_desc.substring(0,order_catalog_desc.lastIndexOf("||")));
					}	
				}
  					order_catalog_desc.append(","+records[2]);  //order_catalog_description
				}
 	 		}*/ //--[IN034888]-Commentted - End
			//--[IN034888] - Start
			for(int j=0; j<ConsentFormId.size(); j++)
			{
				String[] records = (String[]) ConsentFormId.get(j);

				if(!consent_ids.contains(records[0]))
				{
										if(consent!=null && consent.size()>0 )
						consent_details = (String)consent.get(index+records[0].trim());
  					if(consent==null || consent_details==null || consent_details.equals("")  )
					{
						if(patient_id.equals(""))
						{
							if(!patient_details.equals(""))
							{
								patient_id = patient_details.substring((patient_details.indexOf(",ID:")+4));
								if(patient_id == null || patient_id.equals("null")) 
									patient_id =""; 
								else 
									patient_id = patient_id.trim(); 
							}
						}						
						bean.getConsentDetail(records[0].trim(),index,   records[3],   patient_id, facility_id, encounter_id, ord_id) ;		
 					}

 					if(first_consent_format_id==null || first_consent_format_id.equals("")){
						first_consent_format_id = records[0].trim();
 					}
					order_catalog_desc.append(records[2]);
					if(order_catalog_desc==null) order_catalog_desc.append("~~");
					order_consent_format.append(records[3]+"||"); 
					if(order_consent_format==null) order_consent_format.append("~~");
					order_consent_id.append(records[0]+"||"); 
					if((order_consent_id==null)|| (order_consent_id.equals(""))) order_consent_id.append("~~");
					order_consent_form_label.append(records[4]+"||"); 
					if(order_consent_form_label==null) order_consent_form_label.append("~~");
					consent_ids.add(records[0]);
				}
				else
				{
					order_catalog_desc.append(",");
					order_catalog_desc.append(records[2]);
				}
			} //--[IN034888] - End
 			//bean.setCatalogDetail(index, order_catalog_code);
		}
		putObjectInBean(bean_id,bean,request);	
//}

 
            _bw.write(_wl_block14Bytes, _wl_block14);
	int j=0;
	if(!order_consent_id.equals("")){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	 //StringTokenizer stOrder = new StringTokenizer(order_catalog_code,"||");
	 StringTokenizer stOrder1 = new StringTokenizer(order_catalog_desc.toString(),"||");
     StringTokenizer stOrder2 = new StringTokenizer(order_consent_format.toString(),"||");
     StringTokenizer stOrder3 = new StringTokenizer(order_consent_id.toString(),"||");
     StringTokenizer stOrder4 = new StringTokenizer(order_consent_form_label.toString(),"||");
	 
	
	 String catalog_desc="";
	 String classvalue="";
	 //while(stOrder.hasMoreTokens())
	 while(stOrder3.hasMoreTokens())
	 {
		// catalog_code	= stOrder.nextToken();
		if(stOrder1.hasMoreTokens())
		 catalog_desc	= stOrder1.nextToken();
		 if(catalog_desc!=null && catalog_desc.equals("~~")) catalog_desc = "";
		 consent_format = stOrder2.nextToken();
		 if(consent_format!=null && consent_format.equals("~~")) consent_format = "";
 		 consent_form_id= stOrder3.nextToken();
		 consent_form_label= stOrder4.nextToken();
		 new_consent_format_id.append(consent_form_id+"||"); 
 		 new_consent_format_label.append(consent_form_label+"||");

		 if(consent_form_id==null || consent_form_id.equals("~~")) consent_form_id = "";

		 if(consent_form_label==null || consent_form_label.equals("~~") || consent_form_label.length()==0 || consent_form_label.equals("null") ) consent_form_label = "";
//		 out.println("consent_form_label  " + consent_form_label);

			// Consent = (String)consent.get(index+catalog_code);
		/*if(j%2==0)
			classvalue="QRYODD";
		else
			classvalue="QRYEVEN";*/
			classvalue="gridData";
	

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consent_form_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(((consent_form_label==null||consent_form_label.equals(""))?consent_form_id:consent_form_label)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(j));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(j));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
	j++; }
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(order_catalog_cd==null?order_catalog_code:order_catalog_cd));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(new_consent_format_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(new_consent_format_label));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(index));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(task_categ));
            _bw.write(_wl_block38Bytes, _wl_block38);
	
		if(first_consent_format_id!=null && !first_consent_format_id.equals("")) {  
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(first_consent_format_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
 }	
            _bw.write(_wl_block41Bytes, _wl_block41);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Consent.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Orderable.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
