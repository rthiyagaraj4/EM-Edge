package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import javax.servlet.http.*;
import java.util.*;
import com.ehis.util.*;

public final class __patienthistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatientHistResult.jsp", 1709118677871L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Latest Modified Date/Time : 12/5/2005 3:48 PM -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/PatHistSearch.js\'></script>\n\n\t\t<style>\n\n\t\tTD.QRYEVEN1{\n       BACKGROUND-COLOR: #F0F0F2;  \n\tFONT-SIZE: 9pt ;\n\tBORDER-STYLE: SOLID;\n\tborder-left-color: #B2B6D7;\n\tborder-right-color: #B2B6D7;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: #E2E3F0;\n\theight:18;\t\n\n       }\n\n\tTD.QRYODD1{\n\tFONT-SIZE: 9pt ;\n    BACKGROUND-COLOR: #E2E3F0;  \n\tBORDER-STYLE: SOLID;\n\tborder-left-color: #B2B6D7;\n\tborder-right-color: #B2B6D7;\n\tborder-top-color: #E2E3F0;\n\tborder-bottom-color: #E2E3F0;\n\theight:18;\n\t\n    }\n\n\n\t\t</style>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n</head>\n<body onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<table border=\"1\" width=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\' id=\'t\'>\n\t\t\t\t\t\t<!--Added by Ashwini on 16-Mar-2017 for GDOH-CRF-0144-->\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\'3\' class=\'CAFIRSTNOSELECT\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =": ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<!--End GDOH-CRF-0144-->\n\t\t\t\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</table>\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\'>\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'auto\' height=\'100%\' align=\'center\'>\n\t\t\t<tr><td width=\'100%\' id=\'t\'></td></td> </tr>\n\t\t</table>\n\t\t</div>\t\n\t\t<script language=\"JavaScript\">\n\t\t\tif(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" && ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="){\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/pline.jsp?Patient_ID=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[2].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\talert(getMessage(\"INVALID_PATIENT\",\"MP\"))\n\t\t\t}\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

	public String getItemName(String key)
	{
		String []keySplit = key.split("\\."); // To split by '.'
		String module = keySplit[0];
		if (module.length() == 3)
			module = (module.substring(1,3)).toLowerCase()+"_labels";
		else
			module = module.toLowerCase()+"_labels";
		return module.trim();
	}

	/*public String getValue(String key)
	{
		if (key.indexOf(".label") != -1)
				return  com.ehis.util.BundleMessage.getBundleMessage(pageContext,key.trim(),getItemName(key));
		else
			return key;
	}
	*/


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

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	String pat_id = "";
	int hist_type = 0;
	boolean pat_exists = false;
	Connection conn			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	String whereClause = request.getParameter("whereclause");
	 boolean status = false;
    PreparedStatement pstmt1	= null;
	ResultSet rs2			= null;
  String locale="";
  locale = (String)session.getValue("LOCALE");
	String language_direction="";
	int count1=0;


            _bw.write(_wl_block7Bytes, _wl_block7);

	try
	{
		int count = 0;
		if((whereClause == null || whereClause.equals("")) )
		{	
			pat_id = request.getParameter("pat_id");
			hist_type = Integer.parseInt(request.getParameter("hist_type"));
	
			if(pat_id !=null && !pat_id.equals("") && !pat_id.equals("null"))
				whereClause=" and a.patient_id=?" ;
	 
			if(hist_type > 0)
			{
				count = 1;
				whereClause = whereClause +" and hist_type= ?";
			}
			
		}
		conn = ConnectionManager.getConnection(request);
		
	   //Added for this CRF ML-MMOH-CRF-0860.2
	   String tab_width="100%";
	  
       String header_width="";	
	   String data_width ="40%";	
       String data_word_wrap="";	
	   Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","INCREASED_ADDRESS_LINE_LENGTH");	   
	   if(increasedaddressLength){
	       tab_width="1350px";
		   header_width="150px";
           data_width="600px";
		   data_word_wrap="word-wrap: break-word;width:600px";
       }	   
	   //End ML-MMOH-CRF-0860.2
		
		
		pstmt = conn.prepareStatement("select 'X' from mp_patient where patient_id =?");
		pstmt.setString(1,pat_id);
		rs = pstmt.executeQuery();
	
		if(rs.next())
		{
			pat_exists = true;
		}
	
		int i		= 1;
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();


		
			if(pstmt1 != null) pstmt1.close();
			if(rs2 != null) rs2.close();
			
			pstmt1 = conn.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
			rs2 = pstmt1.executeQuery() ;
				 
			 if ( rs2 != null && rs2.next() ) 
			 {
			 count1 = rs2.getInt("total");
			 }

			if ( count1==1 ) 
			{
				 language_direction = "R" ;
			}else
			{
				 language_direction = "L" ;
			}

			
			
/*Below Query Modified for this SCF [SKR-SCF-0419], using this function [Sm_convert_date_2t] incided of Sm_convert_date*/
//Below Query Modified by Ashwini on 16-Mar-2017 for GDOH-CRF-0144

String sSQL = "SELECT"
      +"  sm_Get_desc.Sm_function(a.module_id,a.Function_Id,'"+locale+"',1) Function_Name"
      +"  , sm_Get_desc.Sm_facility_param(a.Updated_Facility_Id,'"+locale+"',1) Facility_Name"
      +"  , a.Function_Id"
      +"  , a.Updated_By_Id"
	  +"  , sm_Get_desc.Sm_appl_user(e.added_by_id,'"+locale+"',1) added_by_name"
	  +"  , TO_CHAR(e.regn_date,'dd/mm/yyyy hh24:mi')regn_date"
      +"  , sm_Get_desc.Sm_appl_user(a.Updated_By_Id,'"+locale+"',1) apple_user_name"

	  +"  , TO_CHAR(a.Updated_Date,'dd/mm/yyyy hh24:mi') Updated_Date"
      +"  , a.Hist_Type"
      +"  , DECODE(a.Hist_Type,'10','Common.gender.label', '20','Common.DateofBirth.label', '30','Common.PatientName.label', '35','eMP.PatientNameLocal.label', '40','eMP.AliasName.label', '60','Common.contactmode.label', '80','Common.Suspended.label', '90','Common.Reinstated.label', '100','eMP.Activated.label', '110','eMP.InActivated.label', '120','Common.deceased.label', '130','Common.Revoked.label', '140','Common.employerdetails.label', '150','eMP.residenceaddress.label', '155','Common.MailingAddress.label', '160',mp_Get_desc.Mp_alternate_id_type(d.alt_Id1_Type,c.Language_Id,1), '170',mp_Get_desc.Mp_alternate_id_type(d.alt_Id2_Type,c.Language_Id,1), '180',mp_Get_desc.Mp_alternate_id_type(d.alt_Id3_Type,c.Language_Id,1), '190',mp_Get_desc.Mp_alternate_id_type(d.alt_Id4_Type,c.Language_Id,1), '200','Common.nationality.label', '210','Common.category.label', '220','eMP.headpatientdetails.label', '230','Common.Organization.label', '240',nvl(d.NAT_ID_PROMPT,'National ID No'), '250','Common.birthPlace.label','270','eMP.PatientSeries.label','280','Common.OldFileNo.label','290','eMP.OtherAltNo.label','300','eMP.maritalstatus.label','330','Common.residency.label','350','Common.status.label','370','Common.race.label','390','Common.religion.label','410','eMP.ethnicity.label','430','Common.RegistrationDate.label','450','Common.nextofkin.label','460','Common.firsttonotify.label','480', mp_get_desc.mp_contact_mode ('PRN', c.language_id, 2),'500', mp_get_desc.mp_contact_mode ('ORN', c.language_id, 2)) Hist_Type_desc"
      +"  , b.Item_Name"
      +"  , ("
      +"CASE "
      +"  WHEN b.Item_Name IN ('DECEASED_DATE') "
      +"  THEN"
      +"    'Common.DeceasedDate.label' || '  ^  ' || Sm_convert_date_2t(TO_DATE(b.Item_Value_Before,'DD-MM-RRRR'), c.Language_Id) ||' ^  ' ||nvl(Sm_convert_date_2t(TO_DATE(b.Item_Value_After,'DD-MM-RRRR'), c.Language_Id),' ') "
      +"  WHEN b.Item_Name IN ('DATE_OF_BIRTH') "
      +"  THEN"
      +"    Sm_convert_date_2t(TO_DATE(b.Item_Value_Before,'DD-MM-RRRR'), c.Language_Id) ||'  ^  ' ||Sm_convert_date_2t(TO_DATE(b.Item_Value_After,'DD-MM-RRRR'), c.Language_Id) "
      +"  WHEN b.item_name= 'DEATH_STATUS_REMARKS' "
      +"  THEN"
      +"    'eMP.deceasedremarks.label' || '  ^  ' || b.Item_Value_Before || '  ^  ' || b.Item_Value_After "
      +"  WHEN b.item_name= 'INACT_ACT_REMARKS' "
      +"  THEN"
      +"    'Common.remarks.label' || '  ^  ' || b.Item_Value_Before || '  ^  ' || b.Item_Value_After "
      +"  WHEN b.Item_Name = 'CONTACT1_MODE' "
      +"  THEN"
      +"    mp_Get_desc.Mp_contact_mode(e.Contact1_Mode,c.Language_Id,1) ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = 'CONTACT2_MODE' "
      +"  THEN"
      +"    mp_Get_desc.Mp_contact_mode(e.Contact2_Mode,c.Language_Id,1) ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = 'CONTACT3_MODE' "
      +"  THEN"
      +"    mp_Get_desc.Mp_contact_mode(e.Contact3_Mode,c.Language_Id,1) ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = 'CONTACT4_MODE' "
      +"  THEN"
      +"    mp_Get_desc.Mp_contact_mode(e.Contact4_Mode,c.Language_Id,1) ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = 'NATIONALITY_CODE' "
      +"  THEN"
      +"    mp_Get_desc.Mp_country(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_country(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('ALT_ID1_NO', 'ALT_ID1_EXP_DATE') "
      +"  THEN"
      +"    mp_Get_desc.Mp_alternate_id_type(d.alt_Id1_Type,c.Language_Id,1) ||'  ^  ' ||DECODE(b.Item_Name,'ALT_ID1_NO',b.Item_Value_Before, ('Common.expiryDate.label'||'  ^  '||Sm_convert_date_2t(TO_DATE(b.Item_Value_Before,'DD-MM-RRRR'), c.Language_Id))) ||'  ^  ' ||DECODE(b.Item_Name,'ALT_ID1_NO',b.Item_Value_After, Sm_convert_date_2t(TO_DATE(b.Item_Value_After,'DD-MM-RRRR'), c.Language_Id)) "
      +"  WHEN b.Item_Name IN ('ALT_ID2_NO', 'ALT_ID2_EXP_DATE') "
      +"  THEN"
      +"    mp_Get_desc.Mp_alternate_id_type(d.alt_Id2_Type,c.Language_Id,1) ||'  ^  ' ||DECODE(b.Item_Name,'ALT_ID2_NO',b.Item_Value_Before, ('Common.expiryDate.label'||'  ^  '||Sm_convert_date_2t(TO_DATE(b.Item_Value_Before,'DD-MM-RRRR'), c.Language_Id))) ||'  ^  ' ||DECODE(b.Item_Name,'ALT_ID2_NO',b.Item_Value_After, Sm_convert_date_2t(TO_DATE(b.Item_Value_After,'DD-MM-RRRR'), c.Language_Id)) "
      +"  WHEN b.Item_Name IN ('ALT_ID3_NO', 'ALT_ID3_EXP_DATE') "
      +"  THEN"
      +"    mp_Get_desc.Mp_alternate_id_type(d.alt_Id3_Type,c.Language_Id,1) ||'  ^  ' ||DECODE(b.Item_Name,'ALT_ID3_NO',b.Item_Value_Before, ('Common.expiryDate.label'||'  ^  '||Sm_convert_date_2t(TO_DATE(b.Item_Value_Before,'DD-MM-RRRR'), c.Language_Id))) ||'  ^  ' ||DECODE(b.Item_Name,'ALT_ID3_NO',b.Item_Value_After, Sm_convert_date_2t(TO_DATE(b.Item_Value_After,'DD-MM-RRRR'), c.Language_Id)) "
      +"  WHEN b.Item_Name IN ('ALT_ID4_NO', 'ALT_ID4_EXP_DATE') "
      +"  THEN"
      +"    mp_Get_desc.Mp_alternate_id_type(d.alt_Id4_Type,c.Language_Id,1) ||'  ^  ' ||DECODE(b.Item_Name,'ALT_ID4_NO',b.Item_Value_Before, ('Common.expiryDate.label'||'  ^  '||Sm_convert_date_2t(TO_DATE(b.Item_Value_Before,'DD-MM-RRRR'), c.Language_Id))) ||'  ^  ' ||DECODE(b.Item_Name,'ALT_ID4_NO',b.Item_Value_After, Sm_convert_date_2t(TO_DATE(b.Item_Value_After,'DD-MM-RRRR'), c.Language_Id)) "
      +"  WHEN b.Item_Name IN ('ORGANIZATION_NAME') "
      +"  THEN"
      +"    'Common.orgName.label' || '  ^  ' || b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('CONTACT3_NAME') "
      +"  THEN"
      +"    'eMP.ContactPersonName.label' || '  ^  ' || b.Item_Value_Before ||'  ^  ' || b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('PATIENT_EMPLOYEE_ID') "
      +"  THEN"
      +"    'Common.employmentid.label' || '  ^  ' || b.Item_Value_Before ||'  ^  ' || b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('EMPLOYMENT_STATUS') "
      +"  THEN"
      +"    'Common.status.label' ||'  ^  ' ||DECODE( b.Item_Value_Before, 'FS','eMP.FullTimeStudent.label', 'FE','eMP.FullTimeEmployed.label', 'NA','Common.notapplicable.label', 'PE','eMP.PartTimeEmployed.label', 'PS','eMP.PartTimeStudent.label', 'SE','eMP.SelfEmployed.label', 'UE','eMP.Unemployed.label', 'UK','Common.unknown.label', b.Item_Value_Before) || '  ^  ' ||DECODE( b.Item_Value_After, 'FS','eMP.FullTimeStudent.label', 'FE','eMP.FullTimeEmployed.label', 'NA','Common.notapplicable.label', 'PE','eMP.PartTimeEmployed.label', 'PS','eMP.PartTimeStudent.label', 'SE','eMP.SelfEmployed.label', 'UE','eMP.Unemployed.label', 'UK','Common.unknown.label', b.Item_Value_After) "
      +"  WHEN b.Item_Name IN ('OFF3_TEL_NO') "
      +"  THEN"
      +"    'Common.officephoneno.label' || '  ^  ' || b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('RES3_TEL_NO') "
      +"  THEN"
      +"    'Common.homephoneno.label' || '  ^  ' || b.Item_Value_Before ||'  ^  ' || b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('FAMILY_ORG_ID') "
      +"  THEN"
      +"    'Common.Organization.label' || '  ^  ' || mp_Get_desc.Mp_family_org(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_family_org(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('FAMILY_ORG_SUB_ID') "
      +"  THEN"
      +"    'eMP.suborgn.label' || '  ^  ' || mp_Get_desc.Mp_family_org_sub(e.Family_Org_Id,b.Item_Value_Before,c.Language_Id, 1) ||'  ^  ' ||mp_Get_desc.Mp_family_org_sub(e.Family_Org_Id,b.Item_Value_After,c.Language_Id, 1) "
      +"  WHEN b.Item_Name IN ('PAT_CAT_CODE') "
      +"  THEN"
      +"    mp_Get_desc.Mp_pat_category(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_pat_category(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('BIRTH_PLACE_CODE') "
      +"  THEN"
      +"    mp_Get_desc.Mp_birth_place(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_birth_place(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('RES_TOWN1_CODE', 'RES_TOWN2_CODE', 'CONTACT3_RES_TOWN_CODE','CONTACT1_RES_TOWN_CODE','CONTACT2_RES_TOWN_CODE') "
      +"  THEN"
      +"    c.res_Town_Prompt ||'  ^  ' ||mp_Get_desc.Mp_res_town(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_res_town(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('CONTACT3_RES_AREA_CODE', 'RES_AREA1_CODE', 'RES_AREA2_CODE','CONTACT1_RES_AREA_CODE','CONTACT2_RES_AREA_CODE') "
      +"  THEN"
      +"    c.res_Area_Prompt ||'  ^  ' ||mp_Get_desc.Mp_res_area(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_res_area(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('CONTACT3_REGION_CODE', 'REGION1_CODE', 'REGION2_CODE','CONTACT1_REGION_CODE') "
      +"  THEN"
      +"    c.Region_Prompt ||'  ^  ' ||mp_Get_desc.Mp_region(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_region(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('POSTAL3_CODE', 'POSTAL1_CODE', 'POSTAL2_CODE') "
      +"  THEN"
      +"    c.Postal_Code_Prompt ||'  ^  ' ||mp_Get_desc.Mp_postal_code(b.Item_Value_Before,c.Language_Id,2) ||'  ^  ' ||mp_Get_desc.Mp_postal_code(b.Item_Value_After,c.Language_Id,2) "
      +"  WHEN b.Item_Name IN ('COUNTRY3_CODE', 'COUNTRY1_CODE', 'COUNTRY2_CODE') "
      +"  THEN"
      +"    'Common.country.label'||'  ^  '||mp_Get_desc.Mp_country(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_country(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('OCPN_CLASS_CODE') "
      +"  THEN"
      +"    'eMP.OccupationClass.label'||'  ^  ' || mp_Get_desc.Mp_occupation_class(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_occupation_class(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('OCPN_CODE', 'OCPN_DESC') "
      +"  THEN"
      +"    'eMP.OccupationClassDesc.label'||'  ^  ' || DECODE(b.Item_Name,'OCPN_DESC',b.Item_Value_Before, mp_Get_desc.Mp_occupation(b.Item_Value_Before,c.Language_Id,1)) ||'  ^  ' ||DECODE(b.Item_Name,'OCPN_DESC',b.Item_Value_After, mp_Get_desc.Mp_occupation(b.Item_Value_After,c.Language_Id,1)) "
      +"  WHEN b.Item_Name IN ('ADDR1_LINE1', 'ADDR2_LINE1', 'ADDR3_LINE1') "
      +"  THEN"
      +"    c.Addr_Line1_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('ADDR1_LINE1', 'ADDR2_LINE1', 'ADDR3_LINE1') "
      +"  THEN"
      +"    c.Addr_Line1_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('ADDR1_LINE2', 'ADDR2_LINE2', 'ADDR3_LINE2') "
      +"  THEN"
      +"    c.Addr_Line2_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('ADDR1_LINE3', 'ADDR2_LINE3', 'ADDR3_LINE3') "
      +"  THEN"
      +"    c.Addr_Line3_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('ADDR1_LINE4', 'ADDR2_LINE4', 'ADDR3_LINE4') "
      +"  THEN"
      +"    c.Addr_Line4_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('NAME_PREFIX') "
      +"  THEN"
      +"    d.Name_Prefix_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('FIRST_NAME') "
      +"  THEN"
      +"    d.First_Name_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('SECOND_NAME') "
      +"  THEN"
      +"    d.Second_Name_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('THIRD_NAME') "
      +"  THEN"
      +"    d.Third_Name_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('FAMILY_NAME') "
      +"  THEN"
      +"    d.Family_Name_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('NAME_SUFFIX') "
      +"  THEN"
      +"    d.Name_Suffix_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('NAME_PREFIX_LOC_LANG') "
      +"  THEN"
      +"    d.Name_Prefix_Loc_lAng_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('FIRST_NAME_LOC_LANG') "
      +"  THEN"
      +"    d.First_Name_Loc_lAng_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('SECOND_NAME_LOC_LANG') "
      +"  THEN"
      +"    d.Second_Name_Loc_lAng_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('THIRD_NAME_LOC_LANG') "
      +"  THEN"
      +"    d.Third_Name_Loc_lAng_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('FAMILY_NAME_LOC_LANG') "
      +"  THEN"
      +"    d.Family_Name_Loc_lAng_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name = ('NAME_SUFFIX_LOC_LANG') "
      +"  THEN"
      +"    d.Name_Suffix_Loc_lAng_Prompt ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('STATUS_REASON_CODE') "
      +"  THEN"
      +"    'Common.reason.label' ||'  ^  ' || mp_Get_desc.Mp_pat_susp_reason(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' || mp_Get_desc.Mp_pat_susp_reason(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('INACT_ACT_REASON_CODE') "
      +"  THEN"
      +"    mp_Get_desc.Mp_pat_inact_reason(b.Item_Value_Before,c.Language_Id,1) ||' ^  ' || mp_Get_desc.Mp_pat_inact_reason(b.Item_Value_After,c.Language_Id,1) "
      +"  WHEN b.Item_Name IN ('CONTACT3_RELATION') "
      +"  THEN"
      +"    mp_Get_desc.Mp_relationship(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.Mp_relationship(b.Item_Value_After,c.Language_Id,1) "

	  +"  WHEN b.Item_Name IN ('PAT_SER_GRP_CODE') "
      +"  THEN"
      +"    mp_Get_desc.MP_PAT_SER_GRP(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' ||mp_Get_desc.MP_PAT_SER_GRP(b.Item_Value_After,c.Language_Id,1) "

      +"  WHEN b.Item_Name IN ('STATUS_REMARKS') "
      +"  THEN"
      +"    'Common.remarks.label' ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  WHEN b.Item_Name IN ('SEX') "
      +"  THEN"
      +"    'Common.gender.label' ||'  ^  ' || DECODE(b.Item_Value_Before,'M', 'Common.male.label','F','Common.female.label','Common.unknown.label') ||'  ^  ' ||DECODE(b.Item_Value_After,'M','Common.male.label','F','Common.female.label','Common.unknown.label') "
	
	  +"  WHEN b.Item_Name in ('CONTACT1_NAME','CONTACT2_NAME') "
      +"  THEN"
      +"    'Common.name.label' ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
	  +"  WHEN b.Item_Name = ('NATIONAL_ID_NO') "
      +"  THEN"
      +"    nvl(d.NAT_ID_PROMPT,'National ID No') ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
	  +"  WHEN b.Item_Name = ('CONTACT1_NAT_ID_NO') "
      +"  THEN"
      +"    nvl(d.NAT_ID_PROMPT,'National ID No') ||'  ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
	 +"  WHEN b.Item_Name = ('CONTACT1_ALT_ID1_NO') "
      +"  THEN"
      +"    mp_Get_desc.Mp_alternate_id_type(d.alt_Id1_Type,c.Language_Id,1) ||'  ^  ' ||DECODE(b.Item_Name,'CONTACT1_ALT_ID1_NO',b.Item_Value_Before) ||'  ^  ' ||DECODE(b.Item_Name,'CONTACT1_ALT_ID1_NO',b.Item_Value_After) "
	 +"  WHEN b.Item_Name = ('CONTACT1_ALT_ID2_NO') "
      +"  THEN"
      +"    mp_Get_desc.Mp_alternate_id_type(d.alt_Id2_Type,c.Language_Id,1) ||'  ^  ' ||DECODE(b.Item_Name,'CONTACT1_ALT_ID2_NO',b.Item_Value_Before) ||'  ^  ' ||DECODE(b.Item_Name,'CONTACT1_ALT_ID2_NO',b.Item_Value_After) "
	 +"  WHEN b.Item_Name = ('CONTACT1_ALT_ID3_NO') "
      +"  THEN"
      +"    mp_Get_desc.Mp_alternate_id_type(d.alt_Id3_Type,c.Language_Id,1) ||'  ^  ' ||DECODE(b.Item_Name,'CONTACT1_ALT_ID3_NO',b.Item_Value_Before) ||'  ^  ' ||DECODE(b.Item_Name,'CONTACT1_ALT_ID3_NO',b.Item_Value_After) "
	 +"  WHEN b.Item_Name = ('CONTACT1_ALT_ID4_NO') "
      +"  THEN"
      +"    mp_Get_desc.Mp_alternate_id_type(d.alt_Id4_Type,c.Language_Id,1) ||'  ^  ' ||DECODE(b.Item_Name,'CONTACT1_ALT_ID4_NO',b.Item_Value_Before) ||'  ^  ' ||DECODE(b.Item_Name,'CONTACT1_ALT_ID4_NO',b.Item_Value_After) "
	
	   +"  WHEN b.Item_Name = ('CONTACT1_BIRTH_DATE') "
      +"  THEN"
      +"  'Common.DateofBirth.label' ||'  ^  '||Sm_convert_date_2t(TO_DATE(b.Item_Value_Before,'DD-MM-RRRR'), c.Language_Id) ||'  ^  ' ||Sm_convert_date_2t(TO_DATE(b.Item_Value_After,'DD-MM-RRRR'), c.Language_Id) "	
	 
	  +"  WHEN b.Item_Name in ('CONTACT1_RELATION','CONTACT2_RELATION') "
      +"  THEN"
     +"'Common.relationship.label' ||'  ^  ' || mp_Get_desc.Mp_relationship(b.Item_Value_Before,c.Language_Id,2) ||'  ^  ' || mp_Get_desc.Mp_relationship(b.Item_Value_After,c.Language_Id,2) "
	 
	  +"  WHEN b.Item_Name = ('CONTACT1_OTH_ALT_ID_TYPE') "
      +"  THEN"
     +"'Common.otheraltid.label' ||'  ^  ' || mp_Get_desc.Mp_alternate_id_type(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' || mp_Get_desc.Mp_alternate_id_type(b.Item_Value_After,c.Language_Id,1) "
	
	  +"  WHEN b.Item_Name = ('CONTACT1_OTH_ALT_ID_NO') "
      +"  THEN"
	 +"'eMP.OtherAltIdDetails.label' ||'   ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
	  +"  WHEN b.Item_Name in ('CONTACT1_MOB_TEL_NO','CONTACT2_MOB_TEL_NO') "
      +"  THEN"
	 +"'Common.MobileNo.label' ||'   ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
	  +"  WHEN b.Item_Name in  ('RES1_TEL_NO','RES2_TEL_NO') "
      +"  THEN"
	 +"'Common.homephoneno.label' ||'   ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "

	 +"  WHEN b.Item_Name = ('OTH_ALT_ID_TYPE') "
      +"  THEN"
     +"'eMP.OtherAltNo.label' ||'  ^  ' || mp_Get_desc.Mp_alternate_id_type(b.Item_Value_Before,c.Language_Id,1) ||'  ^  ' || mp_Get_desc.Mp_alternate_id_type(b.Item_Value_After,c.Language_Id,1) "
	
	  +"  WHEN b.Item_Name = ('OTH_ALT_ID_NO') "
      +"  THEN"
	 +"'eMP.OtherAltNoDetails.label' ||'   ^  ' ||b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "

	  +"  WHEN b.Item_Name = ('MAR_STATUS_CODE') "
      +"  THEN"
      +"    mp_Get_desc.mp_marital_status(b.Item_Value_Before,c.Language_Id,2) ||'  ^  ' ||mp_Get_desc.mp_marital_status(b.Item_Value_After,c.Language_Id,2) "

	  +"  WHEN b.Item_Name = ('CITIZEN_YN') "
      +"  THEN"
      +"    'Common.residency.label'  ||'   ^  ' || DECODE(b.Item_Value_Before,'Y', 'Common.citizen.label','N','Common.noncitizen.label')||'  ^  ' ||DECODE(b.Item_Value_After,'Y', 'Common.citizen.label','N','Common.noncitizen.label') "
	
	  +"  WHEN b.Item_Name = ('LEGAL_YN') "
      +"  THEN"
      +"    'Common.status.label'  ||'   ^  ' || DECODE(b.Item_Value_Before,'Y', 'Common.legal.label','N','Common.illegal.label')||'  ^  ' ||DECODE(b.Item_Value_After,'Y', 'Common.legal.label','N','Common.illegal.label') "

	  +"  WHEN b.Item_Name = ('RACE_CODE') "
      +"  THEN"
      +"    mp_Get_desc.mp_race(b.Item_Value_Before,c.Language_Id,2) ||'  ^  ' ||mp_Get_desc.mp_race(b.Item_Value_After,c.Language_Id,2) "
	  +"  WHEN b.Item_Name = ('RELGN_CODE') "
      +"  THEN"
      +"    mp_Get_desc.mp_religion(b.Item_Value_Before,c.Language_Id,2) ||'  ^  ' ||mp_Get_desc.mp_religion(b.Item_Value_After,c.Language_Id,2) "
	  +"  WHEN b.Item_Name = ('ETHNIC_GRP_CODE') "
      +"  THEN"
      +"    mp_Get_desc.mp_ethnic_group(b.Item_Value_Before,c.Language_Id,2) ||'  ^  ' ||mp_Get_desc.mp_ethnic_group(b.Item_Value_After,c.Language_Id,2) "
	  +"  WHEN b.item_name = ('CONTACT1_NO') "
      +"  THEN"
      +"  mp_get_desc.mp_contact_mode ('PRN', c.language_id, 2) || '  ^  ' || b.item_value_before || '  ^  ' || b.item_value_after "
	  +"  WHEN b.item_name = ('CONTACT2_NO') "
      +"  THEN"
      +"  mp_get_desc.mp_contact_mode ('ORN', c.language_id, 2) || '  ^  ' || b.item_value_before || '  ^  ' || b.item_value_after "
	  
	  +"  ELSE b.Item_Value_Before ||'  ^  ' ||b.Item_Value_After "
      +"  END) Item_Data "
      +"FROM"
      +"  mp_Pat_chng_Hist_hdr a"
      +"  , mp_Pat_chng_Hist_dtl b"
      +"  , sm_Site_Param_lAng_vw c"
      +"  , mp_Param_lAng_vw d"
      +"  , mp_Patient e "
      +"WHERE a.Hist_ref_Id = b.Hist_ref_Id "
      +"  AND a.Patient_Id = e.Patient_Id "
      +"  AND d.Module_Id = 'MP' "
	  +"  AND C.LANGUAGE_ID = '"+localeName+"' "
	  +"  AND D.LANGUAGE_ID = '"+localeName+"' "
	  +   whereClause
	//  +" ORDER BY 1,4,5 ,2,b.rowid";
	
	  +" ORDER BY a.updated_date desc, 1 ASC,4 ASC,5 ASC,2 ASC,b.rowid ASC"; //abobe line commented and this line added for this RUT-SCF-0312 [IN:044548]

	
	
	if(pat_exists) {
	pstmt = conn.prepareStatement(sSQL);
	pstmt.setString(1,pat_id);
	if(count > 0)
		pstmt.setInt(2,hist_type);
	rs = pstmt.executeQuery();
				String classValue			= "";
				String function_name		= "";
				String old_function_name	= "";
				String updated_by_id		= "";
				String apple_user_name="";
				//Added by Ashwini on 16-Mar-2017 for GDOH-CRF-0144
				String added_by_name="";
				String regn_date="";
				String old_updated_by_id	= "";
				String updated_date			= "";
				String old_updated_date		= "";
				String updated_facility		= "";
				String old_updated_facility	= "";
				String hdr_hist_type		= "";
				String itemVal = "";
				String itemVal0 = "";
				String item_data  = "";
				String itemVals[] = null;
				String histTypeDesc = "";
				String prevHistTypeDesc = "";
				String prevClass  = "";
				String hist_type_desc  = "";
				String itemName="";
				boolean flag = false;
				int prevItemVals = 0;
				int cnt = 0;
				
				while(rs.next() )
				{
					status=true;
					//Added by Ashwini on 16-Mar-2017 for GDOH-CRF-0144
					if (added_by_name == null) added_by_name = "";
					added_by_name = rs.getString("added_by_name");
					if (regn_date == null) regn_date = "";
					regn_date= rs.getString("regn_date");
					if ( cnt==0 )
					{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(tab_width));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(added_by_name));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(regn_date));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
					cnt++;
					pat_exists = true;

					if(i % 2 == 0) classValue = "QRYEVEN1" ;
					else classValue = "QRYODD1" ;
		
					function_name		= rs.getString("function_name");
					if (function_name==null) function_name = "";
					updated_by_id		= rs.getString("updated_by_id");
					if (updated_by_id==null) updated_by_id = "";
					apple_user_name= rs.getString("apple_user_name");
					if (apple_user_name==null) apple_user_name = "";
					updated_facility	= rs.getString("facility_name");
					if (updated_facility==null) updated_facility = "";
					updated_date		= rs.getString("updated_date");
					itemName=rs.getString("item_name");
					if(itemName==null)itemName="";

					if (updated_date!=null) 
						updated_date=DateUtils.convertDate(updated_date,"DMYHM","en",localeName);
					else
						updated_date="";
					hdr_hist_type		= rs.getString("hist_type");

					out.println("<tr>");



              
					                   
			
					if(!function_name.equals(old_function_name))
						out.println("<td colspan='3'class='CAGROUPHEADING'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.TransactionName.label","mp_labels")+": "+function_name+"</td></tr><tr>");
					if(!updated_by_id.equals(old_updated_by_id))
						out.println("<td colspan='3' class='CAFIRSTNOSELECT'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Changedby.label","common_labels")+": "+apple_user_name+"</td></tr><tr>");
					if(!updated_facility.equals(old_updated_facility))
						out.println("<td colspan='3'class='CAGROUPHEADING'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ChangedAt.label","mp_labels")+": "+updated_facility+"</td></tr><tr>");
						// CAFIRSTNOSELECT CATHIRDSELECTHORZ  CATHIRDSELECTVERT CAPLL1NORMAL
					if(!updated_date.equals(old_updated_date))
						out.println("<td colspan='3' class='CAFIRSTNOSELECT'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ChangedOn.label","mp_labels")+": "+updated_date+"</td></tr><tr>");		
					






					hist_type_desc = rs.getString("hist_type_desc") == null?"&nbsp;":rs.getString("hist_type_desc");
					if(hdr_hist_type.equals("260")){
						hist_type_desc="Common.bloodgroup.label";
					}
					if (hist_type_desc.indexOf(".label")!=-1 )
						histTypeDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,hist_type_desc,getItemName(hist_type_desc));
					else
						histTypeDesc = hist_type_desc;

					
					item_data  = rs.getString("item_data");
					itemVals = item_data.split(" \\^ ");

					if(!language_direction.equals("R") || !hist_type_desc.equals("eMP.PatientNameLocal.label"))
					{

					if ( !prevHistTypeDesc.equals(histTypeDesc) )
						out.println("<td colspan='3' class='CAPLL1NORMAL'>"+histTypeDesc+"</td></tr><tr>");
					if (itemVals.length==2)
					{
						if(hdr_hist_type!=null && hdr_hist_type.equals("260")){
							if(itemName!=null && itemName.equals("BLOOD_GRP"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels");
							else if(itemName!=null && itemName.equals("RH_FACTOR"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RHDFactor.label","mr_labels");
						}
						out.println("<td class='" + classValue + "' width='30%'>"+histTypeDesc+"</td>");
						out.println("<td class='" + classValue + "'>");
						if (itemVals[0].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[0]).trim(),getItemName(itemVals[0]));
						else
							itemVal = itemVals[0];

						if (itemVal.trim().equals("") )
							out.println("&nbsp;");
						else
							out.println(itemVal);
						out.println("</td><td width=40% class='" + classValue + "'>");

						if (itemVals[1].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[0]).trim(),getItemName(itemVals[1]));
						else
							itemVal = itemVals[1];
						if ( itemVal.trim().equals(""))
							out.println("&nbsp;");
						else
							out.println(itemVal);
						
					}
					else
					if (itemVals.length==3)
					{
						if(hdr_hist_type!=null && hdr_hist_type.equals("260")){
							if(itemName!=null && itemName.equals("BLOOD_GRP"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels");
							else if(itemName!=null && itemName.equals("RH_FACTOR"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RHDFactor.label","mr_labels");
						}

						if (itemVals[0].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[0]).trim(),getItemName(itemVals[0]));
						else
							itemVal = itemVals[0];
							
						//Below line modified for ML-MMOH-CRF-0860.2	
						out.println("<td width='"+header_width+"' class='" + classValue + "'>"+itemVal+"</td><td width='"+data_width+"' class='" + classValue + "' style='"+data_word_wrap+"' >");
						if (itemVals[1].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[1]).trim(),getItemName(itemVals[1]));
						else
							itemVal = itemVals[1];
						if ( itemVal.trim().equals(""))
							out.println( "&nbsp;");
						else
							out.println(itemVal);

						out.println("</td><td width='"+data_width+"' class='" + classValue + "' style='"+data_word_wrap+"' >");
						
						//End ML-MMOH-CRF-0860.2
						
						if (itemVals[2].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[2]).trim(),getItemName(itemVals[2]));
						else
							itemVal = itemVals[2];
						if ( itemVal.trim().equals(""))
							out.println( "&nbsp;");
						else
							out.println(itemVal);
					}
					else
					if (itemVals.length==4)
					{

						if(hdr_hist_type!=null && hdr_hist_type.equals("260")){
							if(itemName!=null && itemName.equals("BLOOD_GRP"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels");
							else if(itemName!=null && itemName.equals("RH_FACTOR"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RHDFactor.label","mr_labels");
						}
						if (itemVals[0].indexOf(".label") != -1)
								itemVal0 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[1]).trim(),getItemName(itemVals[0]));
						else
							itemVal0 = itemVals[0];

						if (itemVals[1].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[1]).trim(),getItemName(itemVals[1]));
						else
							itemVal = itemVals[1];
						out.println("<td class='" + classValue + "'>"+itemVal0+" "+itemVal+"</td><td width=40% class='" + classValue + "'>");
						if ( itemVals[2].trim().equals(""))
							out.println("&nbsp;");
						else
							out.println(itemVals[2]);
						out.println("</td><td width=40% class='" + classValue + "'>");
						if ( itemVals[3].trim().equals(""))
							out.println("&nbsp;");
						else
							out.println(itemVals[3]);
					}

				}
				else
					if(language_direction.equals("R") && hist_type_desc.equals("eMP.PatientNameLocal.label"))
					{

										if ( !prevHistTypeDesc.equals(histTypeDesc) )
						out.println("<td colspan='3' class='CAPLL1NORMAL' dir='RTL'>"+histTypeDesc+"</td></tr><tr>");
					if (itemVals.length==2)
					{
						if(hdr_hist_type!=null && hdr_hist_type.equals("260")){
							if(itemName!=null && itemName.equals("BLOOD_GRP"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels");
							else if(itemName!=null && itemName.equals("RH_FACTOR"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RHDFactor.label","mr_labels");
						}

						out.println("<td class='" + classValue + "' width='30%' dir='RTL'>"+histTypeDesc+"</td>");
						out.println("<td class='" + classValue + "' dir='RTL'>");
						if (itemVals[0].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[0]).trim(),getItemName(itemVals[0]));
						else
							itemVal = itemVals[0];

						if (itemVal.trim().equals("") )
							out.println("&nbsp;");
						else
							out.println(itemVal);
						out.println("</td><td width=40% class='" + classValue + "' dir='RTL'>");

						if (itemVals[1].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[0]).trim(),getItemName(itemVals[1]));
						else
							itemVal = itemVals[1];
						if ( itemVal.trim().equals(""))
							out.println("&nbsp;");
						else
							out.println(itemVal);
					}
					else
					if (itemVals.length==3)
					{
						if(hdr_hist_type!=null && hdr_hist_type.equals("260")){
							if(itemName!=null && itemName.equals("BLOOD_GRP"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels");
							else if(itemName!=null && itemName.equals("RH_FACTOR"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RHDFactor.label","mr_labels");
						}

						if (itemVals[0].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[0]).trim(),getItemName(itemVals[0]));
						else
							itemVal = itemVals[0];
						out.println("<td class='" + classValue + "' dir='RTL'>"+itemVal+"</td><td width=40% class='" + classValue + "' dir='RTL'>");
						if (itemVals[1].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[1]).trim(),getItemName(itemVals[1]));
						else
							itemVal = itemVals[1];
						if ( itemVal.trim().equals(""))
							out.println( "&nbsp;");
						else
							out.println(itemVal);

						out.println("</td><td width=40% class='" + classValue + "' dir='RTL'>");
						if (itemVals[2].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[2]).trim(),getItemName(itemVals[2]));
						else
							itemVal = itemVals[2];
						if ( itemVal.trim().equals(""))
							out.println( "&nbsp;");
						else
							out.println(itemVal);
					}
					else
					if (itemVals.length==4)
					{

						if(hdr_hist_type!=null && hdr_hist_type.equals("260")){
							if(itemName!=null && itemName.equals("BLOOD_GRP"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels");
							else if(itemName!=null && itemName.equals("RH_FACTOR"))
								histTypeDesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RHDFactor.label","mr_labels");
						}

						if (itemVals[0].indexOf(".label") != -1)
								itemVal0 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[1]).trim(),getItemName(itemVals[0]));
						else
							itemVal0 = itemVals[0];

						if (itemVals[1].indexOf(".label") != -1)
								itemVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,(itemVals[1]).trim(),getItemName(itemVals[1]));
						else
							itemVal = itemVals[1];
						out.println("<td class='" + classValue + "' dir='RTL'>"+itemVal0+" "+itemVal+"</td><td width=40% class='" + classValue + "' dir='RTL'>");
						if ( itemVals[2].trim().equals(""))
							out.println("&nbsp;");
						else
							out.println(itemVals[2]);
						out.println("</td><td width=40% class='" + classValue + "' dir='RTL'>");
						if ( itemVals[3].trim().equals(""))
							out.println("&nbsp;");
						else
							out.println(itemVals[3]);
					}
					
					}
					out.println("</td></tr>");
					old_function_name		= function_name;
					i++;
					
					old_updated_by_id		= updated_by_id;
					old_updated_facility	= updated_facility;
					old_updated_date		= updated_date;
					prevHistTypeDesc		= histTypeDesc;
					prevItemVals			= itemVals.length;
					if ( !flag )
					prevClass				= classValue;
				}
				if(status==false) {
					String loca_href="../../eCommon/html/blank.html";
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
					out.println("<script>parent.frames[2].location.href='"+loca_href+"'</script>");	
					return;
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				}
			}
			catch(Exception e) { 
				out.println(e.toString());
				e.printStackTrace();
				}
			finally
			{
				if(conn!=null) ConnectionManager.returnConnection(conn,request);
			}
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_exists));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(status));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(pat_id)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Registeredby.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Registrationdatetime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FieldName.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.oldvalues.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewValue.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
