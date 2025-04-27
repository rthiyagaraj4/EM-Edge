package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public final class __medboardrequestdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedBoardRequestDetail.jsp", 1735058175580L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script src=\'../../eMR/js/MedBoardRequest.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eMR/js/MedBoardReqTransaction.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tfunction localValidations()// do not remove the func.. used for natAltIDComponent.jsp\n\t{\n\t}\n\n\tfunction FocusFirstElement1(){\n\tif(document.MedBoardReqDetailForm){\n\t\tif(document.MedBoardReqDetailForm.search!=null){\n\tdocument.MedBoardReqDetailForm.search.focus();\n\t}\n\t}\n\t}\n\n</script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body  onload=\'FocusFirstElement1()\' OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\'>\n\t<form name=\'MedBoardReqDetailForm\' id=\'MedBoardReqDetailForm\'  method=post >\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'1\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<tr>\t\t\n\t\t\t\t\t<td  colspan=\'4\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<tr><td class=\"COLUMNHEADER\" colspan=4>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td></tr> \n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  width=\"20%\"  class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t<td  width=\"25%\"  class=querydata >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t<td  width=\"30%\"  class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t<td   class=querydata >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t<td  class=\'querydata\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td   class=\'label\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t<td   class=\'label\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<tr><td colspan=\'4\' class=\'label\'>&nbsp;</td></tr>\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

/*
 ****************************************************************************************
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 23 MARCH 2005
* @Function		: MEDICAL_BOARD_REQUEST
 ****************************************************************************************
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String locale = (String) session.getValue("LOCALE");
	Connection con				= null;
	PreparedStatement detailStmt= null;
	Statement Stmt				= null;
	ResultSet detailRS			= null;
	request.setCharacterEncoding("UTF-8");
	String Facility_Id			= (String) session.getValue("facility_id");
	String request_id			= checkForNull(request.getParameter("request_id"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String nat_id_prompt			= "";	String accept_national_id_no_yn	= "";
	String alt_id1_type				= "";	
	String patient_id			= "";
	String patient_name			= "";
	String nameprefix			= "";
	String familyname			= "";
	String firstname			= "";
	String secondname			= "";
	String thirdname			= "";
	String namesuffix			= "";
	String gender				= "";
	String gender_desc			= "";
	String date_of_birth		= "";
	String place_of_birth_code	= "";
	String  place_of_birth_desc	= "";
	String nationality_code		= "";
	String nationality_long_desc= "";
	String national_id_no		= "";
	String alt_id1_no			= "";
	String alt_id2_no			= "";
	String alt_id3_no			= "";
	String alt_id4_no			= "";
	String alt_id1_exp_date		= "";
	String alt_id2_exp_date		= "";
	String alt_id3_exp_date		= "";
	String alt_id4_exp_date		= "";
	String oth_alt_id_type		= "";
	String oth_alt_id_no		= "";
	String eth_grp				= "";
	String eth_sub_grp			= ""; 
	String res_addr_line1		= "";
	String res_addr_line2		= "";
	String res_addr_line3		= "";
	String res_addr_line4		= "";
	String res_town_code		= "";
	String res_town_desc		= "";
	String res_area_code		= "";
	String res_area_desc		= "";
	String res_region_code		= "";
	String res_region_desc		= "";		
	String res_country_code		= "";
	String res_country_desc		= "";
	String citizen				= "";
	String legal				= "";
	String postal_code			= "";
	String mail_addr_line1		= "";
	String mail_addr_line2		= "";
	String mail_addr_line3		= "";
	String mail_addr_line4		= "";
	String mail_town_code		= "";
	String mail_town_desc		= "";
	String mail_area_code		= "";
	String mail_area_desc		= "";
	String mail_postal_code		= "";
	String mail_region_code		= "";
	String mail_region_desc		= "";
	String mail_country_code	= "";
	String mail_country_desc	= "";
	String other_tel_no			= "";
	String oth_contact_no		= "";
	String email_id				= "";
	String years				= "";
	String months				= "";
	String days					= "";
	/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
	String alt_addr_line1	= "";
	String alt_addr_line2	= "";
	String alt_addr_line3	= "";
	String alt_addr_line4	= "";
	String alt_postal_code  = "";
	String alt_postal_desc  = "";
	String alt_country_code = "";
	String alt_country_desc = "";
	String alt_area_code	= "";
	String alt_area_desc	= "";
	String alt_town_code	= "";
	String alt_town_desc	= "";
	String alt_region_code	= "";
	String alt_region_desc	= "";
	/*End*/
	
try
{
	con = ConnectionManager.getConnection(request);
	if(!request_id.equals(""))
	{
		StringBuffer ExeSQL = new StringBuffer();

		ExeSQL.append("SELECT a.oth_Contact_No,");
		ExeSQL.append("        To_char(a.Date_Of_Birth,'dd/mm/yyyy') Date_Of_Birth,");
		ExeSQL.append("        Calculate_age(To_char(a.Date_Of_Birth,'dd/mm/yyyy'),1) Years,");
		ExeSQL.append("        Calculate_age(To_char(a.Date_Of_Birth,'dd/mm/yyyy'),2) Months,");
		ExeSQL.append("        Calculate_age(To_char(a.Date_Of_Birth,'dd/mm/yyyy'),3) Days,");
		ExeSQL.append("        a.eMail_Id,");
		ExeSQL.append("        a.Gender,");
		ExeSQL.append("        a.Patient_Id,");
		ExeSQL.append("        decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) Patient_Name,");
		ExeSQL.append("        a.res_Addr_Line1,");
		ExeSQL.append("        a.res_Addr_Line2,");
		ExeSQL.append("        a.res_Addr_Line3,");
		ExeSQL.append("        a.res_Addr_Line4,");
		ExeSQL.append("        a.res_tel_No,");
		ExeSQL.append("        a.Name_Prefix,");
		ExeSQL.append("        a.First_Name,");
		ExeSQL.append("        a.Second_Name,");
		ExeSQL.append("        a.Third_Name,");
		ExeSQL.append("        a.Family_Name,");
		ExeSQL.append("        a.Name_Suffix,");
		ExeSQL.append("        a.Citizen_yn,");
		ExeSQL.append("        a.Legal_Illegal_yn,");
		ExeSQL.append("        a.alt_Id1_No,");
		ExeSQL.append("        To_char(a.alt_Id1_exp_Date,'dd/mm/yyyy') alt_Id1_exp_Date,");
		ExeSQL.append("        a.alt_Id2_No,");
		ExeSQL.append("        To_char(a.alt_Id2_exp_Date,'dd/mm/yyyy') alt_Id2_exp_Date,");
		ExeSQL.append("        a.alt_Id3_No,");
		ExeSQL.append("        To_char(a.alt_Id3_exp_Date,'dd/mm/yyyy') alt_Id3_exp_Date,");
		ExeSQL.append("        a.alt_Id4_No,");
		ExeSQL.append("        To_char(a.alt_Id4_exp_Date,'dd/mm/yyyy') alt_Id4_exp_Date,");
		ExeSQL.append("        a.oth_alt_Id_Type oth_alt_Id_Type,");
		ExeSQL.append("        a.oth_alt_Id_No oth_alt_Id_No,");
		ExeSQL.append("        a.Mail_Addr_Line1,");
		ExeSQL.append("        a.Mail_Addr_Line2,");
		ExeSQL.append("        a.Mail_Addr_Line3,");
		ExeSQL.append("        a.Mail_Addr_Line4,");
		ExeSQL.append("        a.National_Id_No,");
		ExeSQL.append("        a.Birth_Place_Code Birth_Place_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_birth_place(b.Birth_Place_Code,'"+locale+"','1') Birth_Place_desc,");
		ExeSQL.append("        a.Ethnic_grp_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_race(d.Race_Code,'"+locale+"','1') Race_Description,");
		ExeSQL.append("        a.Mail_Area_Code Mail_Area_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_res_area(e.res_Area_Code,'"+locale+"','1') Mail_Area_Description,");
		ExeSQL.append("        a.Mail_Town_Code Mail_Town_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_res_town(f.res_Town_Code,'"+locale+"','2') Mail_Town_Description,");
		ExeSQL.append("        a.Mail_Region_Code Mail_Region_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_region(g.Region_Code,'"+locale+"','1') Mail_Region_Description,");
		ExeSQL.append("        a.Mail_Postal_Code Mail_Postal_Code,");
		ExeSQL.append("        a.Mail_Country_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_country(i.Country_Code,'"+locale+"','2') Mail_Country_Description,");
		ExeSQL.append("        a.res_Area_Code res_Area_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_res_area(j.res_Area_Code,'"+locale+"','1') res_Area_Description,");
		ExeSQL.append("        a.res_Town_Code res_Town_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_res_town(f.res_Town_Code,'"+locale+"','2') res_Town_Description,");
		ExeSQL.append("        a.res_Region_Code res_Region_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_region(g.Region_Code,'"+locale+"','1') res_Region_Description,");
		ExeSQL.append("        mp_Get_desc.Mp_postal_code(q.Postal_Code,'"+locale+"','2') res_Postal_Description,");
		ExeSQL.append("        a.res_Country_Code,");
		ExeSQL.append("        mp_Get_desc.Mp_country(i.Country_Code,'"+locale+"','2') res_Country_Description,");
		ExeSQL.append("        mp_Get_desc.Mp_country(o.Country_Code,'"+locale+"','1') Nationality_desc,");
		ExeSQL.append("        a.Nationality_Code Nationality_Code ");
		ExeSQL.append(" , a.alt_addr_line1, a.alt_addr_line2, a.alt_addr_line3, a.alt_addr_line4, a.alt_area_code, MP_GET_DESC.MP_RES_AREA(a.alt_area_code,'"+locale+"','1') alt_area_desc, a.alt_town_code, MP_GET_DESC.MP_RES_TOWN(a.alt_town_code,'"+locale+"','1') alt_town_desc, a.alt_region_code, MP_GET_DESC.MP_REGION(a.alt_region_code,'"+locale+"','1') alt_region_desc, a.alt_postal_code, MP_GET_DESC.mp_postal_code(a.alt_postal_code,'"+locale+"','2') alt_postal_desc, a.alt_country_code, MP_GET_DESC.MP_COUNTRY(a.alt_country_code,'"+locale+"','1') alt_country_desc ");//Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601
		ExeSQL.append(" FROM   ");
		ExeSQL.append("		   MR_REPORT_REQUEST_HDR a,");
		ExeSQL.append("        MP_BIRTH_PLACE b,");
		ExeSQL.append("        MP_ETHNIC_GROUP c,");
		ExeSQL.append("        MP_RACE d,");
		ExeSQL.append("        MP_RES_AREA e,");
		ExeSQL.append("        MP_RES_TOWN f,");
		ExeSQL.append("        MP_REGION g,");
		ExeSQL.append("        MP_POSTAL_CODE h,");
		ExeSQL.append("        MP_COUNTRY i,");
		ExeSQL.append("        MP_RES_AREA j,");
		ExeSQL.append("        MP_RES_TOWN k,");
		ExeSQL.append("        MP_REGION l,");
		ExeSQL.append("        MP_POSTAL_CODE m,");
		ExeSQL.append("        MP_COUNTRY n,");
		ExeSQL.append("        MP_COUNTRY o,");
		ExeSQL.append("        MP_ALTERNATE_ID_TYPE p,");
		ExeSQL.append("        MP_POSTAL_CODE q");
		ExeSQL.append(" WHERE  ");
		ExeSQL.append("		   a.Birth_Place_Code = b.Birth_Place_Code (+) ");
		ExeSQL.append("        AND a.Ethnic_grp_Code = c.Ethnic_Group_Code (+) ");
		ExeSQL.append("        AND a.Race_Code = d.Race_Code (+) ");
		ExeSQL.append("        AND a.Mail_Area_Code = e.res_Area_Code (+) ");
		ExeSQL.append("        AND a.Mail_Town_Code = f.res_Town_Code (+) ");
		ExeSQL.append("        AND a.Mail_Region_Code = g.Region_Code (+) ");
		ExeSQL.append("        AND a.Mail_Postal_Code = h.Postal_Code (+) ");
		ExeSQL.append("        AND a.Mail_Country_Code = i.Country_Code (+) ");
		ExeSQL.append("        AND a.res_Area_Code = j.res_Area_Code (+) ");
		ExeSQL.append("        AND a.res_Town_Code = k.res_Town_Code (+) ");
		ExeSQL.append("        AND a.res_Region_Code = l.Region_Code (+) ");
		ExeSQL.append("        AND a.res_Postal_Code = m.Postal_Code (+) ");
		ExeSQL.append("        AND a.res_Country_Code = n.Country_Code (+) ");
		ExeSQL.append("        AND a.Nationality_Code = o.Country_Code (+) ");
		ExeSQL.append("        AND a.oth_alt_Id_No = p.alt_Id_Type (+) ");
		ExeSQL.append("        AND a.Mail_Postal_Code = q.Postal_Code (+) ");
		ExeSQL.append("		   AND facility_id = '"+Facility_Id+"' ");
		ExeSQL.append("		   AND request_id = '"+request_id+"' ");

		
		detailStmt = con.prepareStatement(ExeSQL.toString());
		detailRS = detailStmt.executeQuery();

		if(detailRS !=null && detailRS.next())
		{
			patient_id				= checkForNull(detailRS.getString("PATIENT_ID"));
			patient_name			= checkForNull(detailRS.getString("PATIENT_NAME"));

			date_of_birth			= checkForNull(detailRS.getString( "date_of_birth" ));
			if(!(date_of_birth==null || date_of_birth.equals("")))
				date_of_birth =  DateUtils.convertDate(date_of_birth,"DMY","en",locale);

			years					= checkForNull(detailRS.getString( "years" ));
			months					= checkForNull(detailRS.getString( "months" ));
			days					= checkForNull(detailRS.getString( "days" ));
			gender					= checkForNull(detailRS.getString( "gender" ));
			if(gender.equals("M")) 
				gender_desc = "Male";
			else if(gender.equals("F")) 
				gender_desc = "Female";
			else if(gender.equals("U")) 
				gender_desc = "Unknown";

			nameprefix				= checkForNull(detailRS.getString( "NAME_PREFIX" ));
			firstname				= checkForNull(detailRS.getString( "FIRST_NAME" ));
			secondname				= checkForNull(detailRS.getString( "SECOND_NAME"));
			thirdname				= checkForNull(detailRS.getString( "THIRD_NAME" ));
			familyname				= checkForNull(detailRS.getString( "FAMILY_NAME" ));
			namesuffix				= checkForNull(detailRS.getString( "NAME_SUFFIX" ));
			citizen					= checkForNull(detailRS.getString("CITIZEN_YN"));
			legal					= checkForNull(detailRS.getString("LEGAL_ILLEGAL_YN"));
			alt_id1_exp_date		= checkForNull(detailRS.getString( "ALT_ID1_EXP_DATE"));
			alt_id2_exp_date		= checkForNull(detailRS.getString( "ALT_ID2_EXP_DATE" ));
			alt_id3_exp_date		= checkForNull(detailRS.getString( "ALT_ID3_EXP_DATE" ));
			alt_id4_exp_date		= checkForNull(detailRS.getString( "ALT_ID4_EXP_DATE" ));
			alt_id1_no				= checkForNull(detailRS.getString( "ALT_ID1_NO" ));
			alt_id2_no				= checkForNull(detailRS.getString( "ALT_ID2_NO" ));
			alt_id3_no				= checkForNull(detailRS.getString( "ALT_ID3_NO" ));
			alt_id4_no				= checkForNull(detailRS.getString( "ALT_ID4_NO" ));
			oth_alt_id_no			= checkForNull(detailRS.getString( "OTH_ALT_ID_NO" ));
			oth_alt_id_type			= checkForNull(detailRS.getString( "OTH_ALT_ID_TYPE" ));
			place_of_birth_desc		= checkForNull(detailRS.getString( "birth_place_desc" ));
			place_of_birth_code		= checkForNull(detailRS.getString( "BIRTH_PLACE_CODE" ));
			eth_grp					= checkForNull(detailRS.getString( "ETHNIC_GRP_CODE" ));
			eth_sub_grp				= checkForNull(detailRS.getString( "RACE_DESCRIPTION" ));
			national_id_no			= checkForNull(detailRS.getString( "NATIONAL_ID_NO" ));
			nationality_code		= checkForNull(detailRS.getString( "NATIONALITY_CODE" ));
			nationality_long_desc	= checkForNull(detailRS.getString( "NATIONALITY_DESC" ));
			
			res_addr_line1			= checkForNull(detailRS.getString( "RES_ADDR_LINE1" ));
			res_addr_line2			= checkForNull(detailRS.getString( "RES_ADDR_LINE2" ));
			res_addr_line3			= checkForNull(detailRS.getString( "RES_ADDR_LINE3" ));
			res_addr_line4			= checkForNull(detailRS.getString( "RES_ADDR_LINE4" ));
			res_town_code			= checkForNull(detailRS.getString( "RES_TOWN_CODE" ));
			res_town_desc			= checkForNull(detailRS.getString( "RES_TOWN_DESCRIPTION" ));
			res_area_code			= checkForNull(detailRS.getString( "RES_AREA_CODE" ));
			res_area_desc			= checkForNull(detailRS.getString( "RES_AREA_DESCRIPTION" ));
			res_region_code			= checkForNull(detailRS.getString( "RES_REGION_CODE"));
			res_region_desc			= checkForNull(detailRS.getString( "RES_REGION_DESCRIPTION"));
			postal_code				= checkForNull(detailRS.getString( "RES_POSTAL_DESCRIPTION" ));
			res_country_desc		= checkForNull(detailRS.getString( "RES_COUNTRY_DESCRIPTION" ));
			res_country_code		= checkForNull(detailRS.getString( "RES_COUNTRY_CODE" ));

			mail_addr_line1			= checkForNull(detailRS.getString( "MAIL_ADDR_LINE1" ));
			mail_addr_line2			= checkForNull(detailRS.getString( "MAIL_ADDR_LINE2" ));
			mail_addr_line3			= checkForNull(detailRS.getString( "MAIL_ADDR_LINE3" ));
			mail_addr_line4			= checkForNull(detailRS.getString( "MAIL_ADDR_LINE4" ));
			mail_town_code			= checkForNull(detailRS.getString("MAIL_TOWN_CODE"));
			mail_town_desc			= checkForNull(detailRS.getString("MAIL_TOWN_DESCRIPTION"));
			mail_area_code			= checkForNull(detailRS.getString("MAIL_AREA_CODE"));
			mail_area_desc			= checkForNull(detailRS.getString("MAIL_AREA_DESCRIPTION"));
			mail_region_code		= checkForNull(detailRS.getString("MAIL_REGION_CODE"));
			mail_region_desc		= checkForNull(detailRS.getString("MAIL_REGION_DESCRIPTION"));
			mail_postal_code		= checkForNull(detailRS.getString("MAIL_POSTAL_CODE"));
			mail_country_code		= checkForNull(detailRS.getString("MAIL_COUNTRY_CODE"));
			mail_country_desc		= checkForNull(detailRS.getString("MAIL_COUNTRY_DESCRIPTION"));

			/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
			alt_addr_line1		= checkForNull(detailRS.getString("alt_addr_line1"));
			alt_addr_line2		= checkForNull(detailRS.getString("alt_addr_line2"));
			alt_addr_line3		= checkForNull(detailRS.getString("alt_addr_line3"));
			alt_addr_line4		= checkForNull(detailRS.getString("alt_addr_line4"));
			alt_area_code		= checkForNull(detailRS.getString("alt_area_code"));
			alt_area_desc		= checkForNull(detailRS.getString("alt_area_desc"));
			alt_town_code		= checkForNull(detailRS.getString("alt_town_code"));
			alt_town_desc		= checkForNull(detailRS.getString("alt_town_desc"));
			alt_region_code		= checkForNull(detailRS.getString("alt_region_code"));
			alt_region_desc		= checkForNull(detailRS.getString("alt_region_desc"));
			alt_postal_code		= checkForNull(detailRS.getString("alt_postal_code"));
			alt_postal_desc		= checkForNull(detailRS.getString("alt_postal_desc"));
			alt_country_code	= checkForNull(detailRS.getString("alt_country_code"));
			alt_country_desc	= checkForNull(detailRS.getString("alt_country_desc"));
			/*End*/

			oth_contact_no			= checkForNull(detailRS.getString( "OTH_CONTACT_NO" ));
			other_tel_no			= checkForNull(detailRS.getString( "RES_TEL_NO" ));
			email_id				= checkForNull(detailRS.getString( "EMAIL_ID" ));
		}

		if(detailRS!=null)	detailRS.close();
		if(detailStmt!=null)detailStmt.close();
	}

	String contactSql=" SELECT nat_id_prompt, accept_national_id_no_yn FROM MP_PARAM where module_id='MP'";

	Stmt	= con.createStatement();
	detailRS	= Stmt.executeQuery(contactSql);

	if(detailRS.next() && detailRS != null)
	{
		nat_id_prompt			= checkForNull(detailRS.getString("nat_id_prompt"));
		accept_national_id_no_yn= checkForNull(detailRS.getString("accept_national_id_no_yn"));
	}
	if(detailRS !=null) detailRS.close();
	if(Stmt !=null) Stmt.close();

	String alt_id_sql=" SELECT short_desc FROM MP_ALTERNATE_ID_TYPE_LANG_VW a , MP_PARAM b WHERE a.alt_id_type = b.alt_id1_type and b.module_id='MP' and a.language_id='"+locale+"'";

	Stmt= con.createStatement();
	detailRS	= Stmt.executeQuery(alt_id_sql);

	if(detailRS.next() && detailRS != null)
	{
		alt_id1_type			= checkForNull(detailRS.getString("short_desc"));
	}
	if(detailRS !=null) detailRS.close();
	if(Stmt !=null) Stmt.close();

}catch(Exception exp)
{
	//out.println("Exception in MedBoardRequestDetail.jsp : "+exp.toString());
	exp.printStackTrace();
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
			if(call_function.equals("MEDICAL_BOARD_REQUEST"))
			{	
            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[2]")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("parent.frames[4]")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block13Bytes, _wl_block13);
	}
				else
				{	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
	if(accept_national_id_no_yn.equals("Y"))
					{	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}else{	
            _bw.write(_wl_block24Bytes, _wl_block24);
	}	
            _bw.write(_wl_block25Bytes, _wl_block25);
	if(!alt_id1_type.equals(""))
					{	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(alt_id1_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}else{	
            _bw.write(_wl_block24Bytes, _wl_block24);
	}	
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(gender_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
	}	
            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
