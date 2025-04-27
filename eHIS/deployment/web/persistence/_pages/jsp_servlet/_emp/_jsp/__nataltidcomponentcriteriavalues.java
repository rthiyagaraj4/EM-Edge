package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __nataltidcomponentcriteriavalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/natAltIDComponentCriteriaValues.jsp", 1712639685955L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\t\t\t\n\t\tvar err_age1 = getMessage(\"PAT_DECEASED_NOT_ALLOWED\",\"MP\");\t\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\terr_age1= err_age1.substring(0,err_age1.indexOf(\"cannot\")) ;\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\talert(err_age1);\n\t\tdocument.forms[0].txtSmartcard_dup.value=\"D\";\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\tvar err_age2 = getMessage(\"PAT_SUSPENDED_NOT_ALLOWED\",\"MP\");\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\terr_age2= err_age2.substring(0,err_age2.indexOf(\"cannot\")) ;\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\talert(err_age2);\n\t\tdocument.forms[0].txtSmartcard_dup.value=\"D\";\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\tvar err_age3 = getMessage(\"PAT_INACTIVE_PATIENT\",\"MP\");\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\terr_age3= err_age3.substring(0,err_age3.indexOf(\"cannot\")) ;\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\talert(err_age3);\n\t\tdocument.forms[0].txtSmartcard_dup.value=\"D\";\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\tdocument.forms[0].txtSmartcard_pat_id.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\tdocument.forms[0].txtSmartcard_dup.value=\"D\";\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\tvar err_age3 = getMessage( \"CURRENTLY_IN_PATIENT\",\"Common\");\n\t\t\talert(err_age3);\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n//\t\t\t\talert(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"); \n\t\t\t\t/*\n\t\t\t\tvar contyn = confirm(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\");  \n\t\t\t\tif(contyn) {\t\t\t}\n\t\t\t\t*/\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n//\t\t\t\t\talert(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"); \n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t//populateDetail(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t//populateDetail(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\");\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\tvar msg = getMessage(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'MP\');\n\t\t\t\t\t\tmsg = msg.replace(\'#\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\n\t\t\t\t\t\tmsg = msg.replace(\'@\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');\n\t\t\t\t\t\talert(msg);\t\n\t\t\t\t\t\tdocument.forms[0].national_id_no.focus();\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'MP\');\n\t\t\t\t\t\tmsg = msg.replace(\'$\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\tdocument.forms[0].national_id_no.value=\'\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'MP\');\n\t\t\t\t\t\talert(msg);\t\n\t\t\t\t\t\tdocument.forms[0].national_id_no.focus();\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n\t\t\t\tvar idVal = \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\';\n\t\t\t\tvar step1 = \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\';\n\t\t\t\tvar field_name1= \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\t\tvar alert_reqd_yn = \'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\n\t\t\t\tvar err = getMessage(\'INVALID_VALUE\',\'Common\');\n\t\t\t\tif(step1==\"A5\"){\n\t\t\t\t\terr = err.replace(\'#\',\'Other Alt ID\');\n\t\t\t\t\tif(document.forms[0].txtSmartcard_path.value==\'\'){ // if condition for smartcard\n\t\t\t\t\t\talert(err);\n\t\t\t\t\t\tdocument.forms[0].other_alt_Id.focus();\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\tdocument.forms[0].other_alt_Id.value=\'\';\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t   if(alert_reqd_yn == \"Y\"){\n\t\t\t\t\t\terr = err.replace(\'#\',idVal);\n\t\t\t\t\t\talert(err);\n\t\t\t\t\t\teval(\"document.forms[0].\"+field_name1+\".focus()\")\n\t\t\t\t\t\teval(\"document.forms[0].\"+field_name1+\".value=\'\'\");\n\t\t\t\t   }\n\t\t\t\t}\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
	
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	java.sql.Statement stmtn=null,stmt=null;
	ResultSet rset3 = null,rset=null ;
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String step=(String) hash.get("step");
	String id=(String) hash.get("id");
	String oth_id_type=(String) hash.get("oth_id_type");
	String alert_reqd_yn = (String) hash.get("alert_reqd_yn");
	String mr_transaction = (String) hash.get("mr_transaction");
	if(step == null) step = "";		
	if(id == null) id="";
	if(oth_id_type == null) oth_id_type="";
	if(alert_reqd_yn == null) alert_reqd_yn="N";
	if(mr_transaction == null) mr_transaction="N";
	String patient_id = "";
	String result = "";
	String error_message = "";
	String date_of_birth = "";
	String facilityid=(String)session.getValue("facility_id");
	String alt_id1_type = "";
	String alt_id2_type = "";
	String alt_id3_type = "";
	String alt_id4_type = "";
	String disp_prompt="";
	String field_name="";
	String patient_id_detail="";
	String nat_invoke_routine="";
	String nat_data_source_id="";
	String nat_id_length ="";
	String age_in_years  = "";
	String age_in_months = "";
	String age_in_days   = "";
	String sex = "";		
	String patient_id_addresses= "";		
	int altcount=0;//Added by Rameswar on 15th July 2015 against IN056434	
	
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();			
	try{
		con = ConnectionManager.getConnection(request);
		String sql1 = "select decode('"+step+"','N',nat_id_prompt,'A1',alt_id1_type,'A2',alt_id2_type,'A3',alt_id3_type,'A4',alt_id4_type),alt_id1_type,alt_id2_type,alt_id3_type,alt_id4_type,invoke_routine,nat_data_source_id,nat_id_length from mp_param ";
		
		stmtn=con.createStatement();
		rset3=stmtn.executeQuery(sql1);
		     
		if(rset3!= null && rset3.next())
		{
			disp_prompt= rset3.getString(1);
			alt_id1_type= rset3.getString(2);
			alt_id2_type= rset3.getString(3);
			alt_id3_type= rset3.getString(4);
			alt_id4_type= rset3.getString(5);
			nat_invoke_routine= rset3.getString(6);
			nat_data_source_id= rset3.getString(7);
			nat_id_length= rset3.getString(8);
		} if(rset3 != null) rset3.close();
			if(disp_prompt==null) disp_prompt="";
			if(alt_id1_type==null) alt_id1_type="";
			if(alt_id2_type==null) alt_id2_type="";
			if(alt_id3_type==null) alt_id3_type="";
			if(alt_id4_type==null) alt_id4_type="";
			if(nat_invoke_routine==null) nat_invoke_routine="";
			if(nat_data_source_id==null) nat_data_source_id="";
			if(nat_id_length==null) nat_id_length=""; 
			
		//Modified below Query Query tuning for full table scan [IN:051268]
		String sql="select a.patient_id,a.patient_id||'||'||decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) ||'||'||a.national_id_no||'||'||a.alt_id1_no||'||'||a.alt_id2_no||'||'||a.alt_id3_no||'||'||a.alt_id4_no||'||'||a.name_prefix||'||'||a.first_name||'||'||a.second_name||'||'||a.third_name||'||'||a.family_name||'||'||a.name_suffix||'||'||a.sex||'||'||to_char(a.date_of_birth,'dd/mm/yyyy')||'||'||a.contact1_no||'||'||a.contact2_no||'||'||a.email_id||'||'||a.nationality_code||'||'||to_char(a.alt_id1_exp_date,'dd/mm/yyyy')||'||'||to_char(a.alt_id2_exp_date,'dd/mm/yyyy') ||'||'||to_char(a.alt_id3_exp_date,'dd/mm/yyyy') ||'||'||to_char(a.alt_id4_exp_date,'dd/mm/yyyy')||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),1) ||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),2) ||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),3)||'||'||a.oth_alt_id_type ||'||'|| a.oth_alt_id_no,b.ADDR1_TYPE    ||'||'||B.ADDR1_LINE1   ||'||'||B.ADDR1_LINE2   ||'||'||B.ADDR1_LINE3   ||'||'||B.ADDR1_LINE4   ||'||'||a.RES_TOWN_CODE ||'||'||a.RES_AREA_CODE ||'||'||B.POSTAL1_CODE||'||'||a.REGION_CODE ||'||'||B.COUNTRY1_CODE||'||'||B.CONTACT1_NAME ||'||'||B.INVALID1_YN ||'||'||B.ADDR2_TYPE    ||'||'||B.ADDR2_LINE1   ||'||'||B.ADDR2_LINE2   ||'||'||B.ADDR2_LINE3   ||'||'||B.ADDR2_LINE4   ||'||'||B.RES_TOWN2_CODE||'||'||B.RES_AREA2_CODE||'||'||B.REGION2_CODE||'||'||B.POSTAL2_CODE  ||'||'||B.COUNTRY2_CODE ||'||'||B.CONTACT2_NAME ||'||'||B.INVALID2_YN    ||'||'||B.ADDR3_TYPE    ||'||'||B.ADDR3_LINE1   ||'||'||B.ADDR3_LINE2   ||'||'||B.ADDR3_LINE3   ||'||'||B.ADDR3_LINE4   ||'||'||B.POSTAL3_CODE  ||'||'||B.COUNTRY3_CODE ||'||'||B.CONTACT3_NAME ||'||'||B.INVALID3_YN   ||'||'||B.ADDR4_TYPE    ||'||'||B.ADDR4_LINE1   ||'||'||B.ADDR4_LINE2   ||'||'||B.ADDR4_LINE3   ||'||'||B.ADDR4_LINE4   ||'||'||B.POSTAL4_CODE  ||'||'||B.COUNTRY4_CODE ||'||'||B.CONTACT4_NAME ||'||'||B.INVALID4_YN   ||'||'||B.ADDR5_TYPE    ||'||'||B.ADDR5_LINE1   ||'||'||B.ADDR5_LINE2   ||'||'||B.ADDR5_LINE3   ||'||'||B.ADDR5_LINE4   ||'||'||B.POSTAL5_CODE  ||'||'||B.COUNTRY5_CODE ||'||'||B.CONTACT5_NAME from mp_patient a ,mp_pat_addresses b where a.patient_id = b.patient_id(+) AND a.patient_id BETWEEN NVL ('%%','%%')  AND NVL ('',a.patient_id) AND a.patient_id LIKE '%%'";
		
		if(step.equals("N")){
			sql=sql+" and  a.national_id_no='"+id+"' ";
			field_name = "national_id_no";
		}
		else if(step.equals("A1")){
			sql=sql+" and  a.alt_id1_no='"+id+"' ";
			field_name = "alt_id1_no";
		}
		else if(step.equals("A2")){
			sql=sql+" and  a.alt_id2_no='"+id+"' ";
			field_name = "alt_id2_no";
		}
		else if(step.equals("A3")){
			sql=sql+" and  a.alt_id3_no='"+id+"' ";
			field_name = "alt_id3_no";
		}
		else if(step.equals("A4")){
			sql=sql+" and  a.alt_id4_no='"+id+"' ";
			field_name = "alt_id4_no";
		}
		else if(step.equals("A5")){
			sql=sql+" and  a.oth_alt_id_no='"+id+"' and  a.oth_alt_id_type = '"+oth_id_type+"' ";
			field_name = "other_alt_Id";
		}
		
		rset3=stmtn.executeQuery(sql);
		if(rset3!= null){
			while(rset3.next()){
				patient_id = rset3.getString(1);
				patient_id_detail = rset3.getString(2);
				patient_id_addresses = rset3.getString(3);
				altcount++;
			}
		} if(rset3 != null) rset3.close();
		/*Added by Rameswar on 15th July 2015 against IN056434*/
		/*When multiple patients has same Alt ID then patient ID should be populate in Patient ID field
			If Alt Id is Unique, it should be populated*/
		if(altcount>1){
		patient_id="";
		}
if(!patient_id.equals("")){
	String chkst=patdata.CheckStatus(con,patient_id);
	if(chkst.equals("DECEASED")){
		patient_id_detail="DECEASED";
		
            _bw.write(_wl_block4Bytes, _wl_block4);
 if(mr_transaction.equals("Y")) { 
            _bw.write(_wl_block5Bytes, _wl_block5);
 }
            _bw.write(_wl_block6Bytes, _wl_block6);

	}
	else if(chkst.equals("SUSPENDED")){
		patient_id_detail="SUSPENDED";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(mr_transaction.equals("Y")) { 
            _bw.write(_wl_block8Bytes, _wl_block8);
 }
            _bw.write(_wl_block9Bytes, _wl_block9);

	} 
	else if(chkst.equals("INACTIVE")){
		patient_id_detail="INACTIVE";
		
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(mr_transaction.equals("Y")) { 
            _bw.write(_wl_block11Bytes, _wl_block11);
 }
            _bw.write(_wl_block12Bytes, _wl_block12);

	} 	
	if(chkst.equals("INACTIVE") || chkst.equals("SUSPENDED") || chkst.equals("DECEASED")){
	}
	else
	{
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);

		String In_patient_status =  patdata.CheckInPatient(con,patient_id,facilityid);
		//added condition to restict alert in Medical Records for ML-MMOH-441 on 27/7/2015 By Sangeetha
		if(In_patient_status.equals("CURRENTLY_IN_PATIENT") && !mr_transaction.equals("Y"))
		{
			
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
			
		String alt_status = patdata.CheckAlternateId(con,patient_id,localeName);
		//char alt_stat = 'Y';
		if(!alt_status.equals(""))
		{
			char val = alt_status.charAt(0);

			if(val == 'W')
			{
				String msg = alt_status.substring(2,alt_status.length());
			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block18Bytes, _wl_block18);
	}
			else if(val =='C')
			{			
				String msg = alt_status.substring(1,alt_status.length());
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block20Bytes, _wl_block20);
	}
			else 
			{	
				String msg = alt_status.substring(2,alt_status.length());
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(msg));
            _bw.write(_wl_block20Bytes, _wl_block20);
	}
		}
	}	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(field_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id_detail));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id_addresses));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}
	else{
       if(step.equals("N")&&nat_invoke_routine.equals("Y")&&nat_data_source_id.equals("NRIC")){
			sql = "select VERIFY_NATIONAL_ID('"+id+"') from dual";
			rset3=stmtn.executeQuery(sql);
			if(rset3!= null && rset3.next())
			result = rset3.getString(1);
						
			StringTokenizer strTok = new StringTokenizer(result,"$");				
					
			if(strTok.hasMoreTokens())
				result = strTok.nextToken();
				if(result.equals("TRUE")){
					if(strTok.hasMoreTokens())
						date_of_birth = strTok.nextToken();	
					if(strTok.hasMoreTokens())
						age_in_years = strTok.nextToken();	
					if(strTok.hasMoreTokens())
						age_in_months = strTok.nextToken();	
					if(strTok.hasMoreTokens())
						age_in_days = strTok.nextToken();	
					if(strTok.hasMoreTokens())
						sex = strTok.nextToken();
					result = "NAT_ID_VALUES"+"||"+date_of_birth+"||"+age_in_years+"||"+age_in_months+"||"+age_in_days+"||"+sex;
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(field_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(result));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id_addresses));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
				else if(result.equals("FALSE")){
					if(strTok.hasMoreTokens())
					{
						error_message = strTok.nextToken();
						if(error_message.equals("NAT_ID_CHARS")){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(error_message));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disp_prompt));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(error_message));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disp_prompt));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(!mr_transaction.equals("Y")) { 
            _bw.write(_wl_block32Bytes, _wl_block32);
 }
					}
				}
				else
				{
					if(strTok.hasMoreTokens()){
						error_message = strTok.nextToken();
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(error_message));
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(!mr_transaction.equals("Y")) { 
            _bw.write(_wl_block32Bytes, _wl_block32);
 }
            _bw.write(_wl_block34Bytes, _wl_block34);
							
					}
				}
			}
			else{
				
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disp_prompt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(step));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(field_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(alert_reqd_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
 if(!mr_transaction.equals("Y")) { 
            _bw.write(_wl_block40Bytes, _wl_block40);
 }
            _bw.write(_wl_block41Bytes, _wl_block41);
							
			}
		}
		if(stmtn!= null) stmtn.close();
		if(stmt!= null) stmt.close();
		if(rset3 != null) rset3.close();
		if(rset != null) rset.close();
		hash.clear();
	}
	catch(Exception e){	 
		out.println(e.toString());
	}
	finally{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
