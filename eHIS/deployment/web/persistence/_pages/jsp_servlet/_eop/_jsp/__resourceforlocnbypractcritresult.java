package jsp_servlet._eop._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __resourceforlocnbypractcritresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ResourceForLocnByPractCritResult.jsp", 1742279268075L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eOP/js/menuItemCheck.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eOP/js/OPPractitionerComponent.js\'></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eOP/js/ResourceForLocnByPract.js\'></script>\n<script language=\'javascript\' src=\'../../eOP/js/ResourceForUnit.js\'></script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey();\' onKeyPress=\'\'> \n<form name=\"clinic_res_by_pract_form\" id=\"clinic_res_by_pract_form\" action=\"../../eOP/jsp/ResourceForLocnByPractCritResult.jsp\" method=\"post\" target=\"messageFrame\">\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table><br><br>\t\n\n<tr width=\'100%\' >\n\t\t\t\t<td align=\'right\' class=\'white\'>\n\t\t\t\t\t<table align=\'right\'><tr>\n\t\t\t\t\t\t   <td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\n\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"80%\" align=\"center\" >\t\n\t\t<tr>\n\t\t\t<th class=\'columnheader\' align=\"left\"> ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\t\t\t\n\t\t\t<th class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\t\n\t\t\t<th class=\'columnheader\' align=\"left\"></td>\t\t\t\n\t\t\t<th class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" <input type=\'checkbox\' onClick=\'toggle_check(this, ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =", ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =");\'> </td>\n\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<tr>\n\t\t<td width=\'20%\' class=\'fields\'> ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td width=\'20%\' class=\'fields\'> ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td>\n\t\t\n\t\t<td width=\'20%\' class=\'fields\' style=\"background-color:white\"> \n\t\t<span style=\"font-size:8pt; cursor: pointer;color:blue;\" OnMouseOver=\"Tip(reasonToolTip1(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\', \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'))\"  onmouseout=\"UnTip()\" onclick=\"pointToLocn(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\" >\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \n\t\t</span>\n\t\t</td>\n\t\t\n\t\t<td width=\'20%\' class=\'fields\'> <input type=\'checkbox\' name=\'check_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onClick=\"setChecked(this, \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" /> \n\t\t<input type=\'hidden\' name=\"code";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" />\n\t\t<input type=\'hidden\' name=\"checked";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" />\n\t\t </td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\n<!-- <div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'width:30%; visibility:hidden;\' bgcolor=\'blue\' ></div> -->\n<input type=\'hidden\' name = \'facility_id\' value = \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'/>\n<input type=\'hidden\' name = \'pract_id\' value = \'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'/>\n<input type=\'hidden\' name = \'clinic_type\' value = \'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'/>\n<input type=\'hidden\' name = \'isSimplifyPractNursUnit\' value = \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'/>\n<input type=\'hidden\' name = \'speciality_id\' value = \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'/>\n<input type=\'hidden\' name = \'search_by\' value = \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'/>\n<input type=\'hidden\' name = \'search_desc\' value = \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'/>\n<input type =\'hidden\' name=\'called_from\' id=\'called_from\' value=\'RES_BY_PRACT\'>\n<input type=\"hidden\" name=\"function\" id=\"function\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"oper\" id=\"oper\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=hidden name=\'isOnApply\' id=\'isOnApply\' value=\'N\'>\n</form>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eOT/js/wz_tooltip.js\'></script>\n\t</body>\n\t</html>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<script>\n\t\tdocument.getElementById(\'nextval\').innerHTML=\" \";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

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
            webbeans.eCommon.RecordSet SimplifyPractNurs= null;synchronized(session){
                SimplifyPractNurs=(webbeans.eCommon.RecordSet)pageContext.getAttribute("SimplifyPractNurs",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(SimplifyPractNurs==null){
                    SimplifyPractNurs=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("SimplifyPractNurs",SimplifyPractNurs,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet ClinicForPracts= null;synchronized(session){
                ClinicForPracts=(webbeans.eCommon.RecordSet)pageContext.getAttribute("ClinicForPracts",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(ClinicForPracts==null){
                    ClinicForPracts=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("ClinicForPracts",ClinicForPracts,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet NextPrevRecClinis= null;synchronized(session){
                NextPrevRecClinis=(webbeans.eCommon.RecordSet)pageContext.getAttribute("NextPrevRecClinis",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(NextPrevRecClinis==null){
                    NextPrevRecClinis=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("NextPrevRecClinis",NextPrevRecClinis,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
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
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Connection con = null;

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String fnval = request.getParameter("function")==null?"insertByPract":request.getParameter("function") ;

String whereClause = request.getParameter("whereclause")==null?"":request.getParameter("whereclause"); 
StringBuffer sql = new StringBuffer();
StringBuffer sql1 = new StringBuffer();

int start = 0;
int end = 0;
int i = 1;
int cnt = 0; 
String ext_count = "0";
String endOfRes="1";

 if ( from == null )
    start = 1 ;
else
    start = Integer.parseInt( from ) ;

if ( to == null )
    end = 10;
else
    end = Integer.parseInt( to ) ; 

String is_origin = request.getParameter("is_origin");
if(is_origin==null)is_origin="true";

try{
con=ConnectionManager.getConnection(request);    
PreparedStatement pstmt = null;
ResultSet rs = null;
String callfunc=request.getParameter("call_func");
String oper=request.getParameter("oper")==null?"":request.getParameter("oper");

Boolean isSimplifyPractNursUnit = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","SIMPLIFY_PRACT_FOR_NURS_RES");
Boolean fromSession = false;
String c_code ="";
if(is_origin.equals("true") && session.getAttribute("ResForLocnByPract") != null){
	session.removeAttribute("ResForLocnByPract");
}else{
	int page1 = end/10;
	HashMap<String, String> map = (HashMap<String, String>)(session.getAttribute("ResForLocnByPract")==null ? new HashMap<String, String>() : session.getAttribute("ResForLocnByPract")) ;
	c_code = map.get("c_clinic_id"+page1);
	if(c_code != null){
		NextPrevRecClinis.clearAll();
		String[] NextPrevCodes = c_code.split(",");
		for(String npCode : NextPrevCodes){
			NextPrevRecClinis.putObject(npCode);	
		}
		fromSession = true;
	}
}

String practname="";
String effstatus="E";

String facilityid=(String)session.getValue("facility_id");
String care_locn_type_ind = (request.getParameter("unit_type") == null)?"":request.getParameter("unit_type");
String practitionerid=(request.getParameter("pract_id") == null)?"":request.getParameter("pract_id");
String speciality_id=(request.getParameter("speciality_id") == null)?"":request.getParameter("speciality_id");
String search_desc=(request.getParameter("search_desc") == null)?"":request.getParameter("search_desc");
String search_by=(request.getParameter("search_by") == null)?"":request.getParameter("search_by");

String checkClinic = "";
String checkClinicValue = "N";
String proceedToByLocn = "N";
String ext_count_str = "";

sql1.append("select clinic_code  from op_pract_for_clinic where practitioner_id = ? and facility_id = ? and resource_class = 'P'");

pstmt = con.prepareStatement(sql1.toString());
pstmt.setString(1, practitionerid);
pstmt.setString(2, facilityid);
rs = pstmt.executeQuery();
ClinicForPracts.clearAll();
SimplifyPractNurs.clearAll();
int cntOFPract = 0;
if(rs != null){
	while(rs.next()){
		ext_count = rs.getString("clinic_code");
		ClinicForPracts.putObject(ext_count);
		
		if(cntOFPract == 0){
			ext_count_str = "'"+ext_count+"'";
		}else{
			ext_count_str = ext_count_str + ",'"+ext_count+"'";	
		}
		cntOFPract++;
	}
}
if(cntOFPract <= 0 && oper.equals("create")){
sql1.setLength(0);
if(pstmt!=null)pstmt.close();
if(rs!=null)rs.close();
sql1.append("SELECT locn_code FROM am_locn_for_oper_stn WHERE oper_stn_id = (SELECT oper_stn_id	FROM am_user_for_oper_stn WHERE appl_user_id = (SELECT appl_user_id FROM sm_appl_user WHERE func_role_id = ?) AND (TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (eff_date_from, 'DD/MM/YYYY') AND (eff_date_to IS NULL OR TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (eff_date_to, 'DD/MM/YYYY'))) and facility_id = ?) ");

pstmt=con.prepareStatement(sql1.toString());
pstmt.setString(1, practitionerid);
pstmt.setString(2, facilityid);
rs = pstmt.executeQuery();
if(rs != null){
	while(rs.next()){
		SimplifyPractNurs.putObject(rs.getString(1));
	}
}

if(pstmt!=null)pstmt.close();
if(rs!=null)rs.close();

}

if(!whereClause.equals("")) 
	{
		sql.append(whereClause);   
   }else{

	   sql.append("SELECT a.practitioner_id, a.practitioner_name, b.clinic_code, B.long_desc locn_long_desc, b.care_locn_type_ind, am_get_desc.AM_SPECIALITY (b.speciality_code, 'en', 2 ) specialty_short_desc, b.speciality_code, b.clinic_type, b.PRIMARY_RESOURCE_CLASS, b.OPEN_TO_ALL_PRACT_YN FROM am_practitioner a, op_clinic b WHERE a.practitioner_id = ? AND b.clinic_type = ? and b.facility_id=? and (b.SPECIALITY_CODE in (select speciality_code from AM_PRACT_SPECIALITIES where facility_id = ? and practitioner_id = ? ) or b.SPECIALITY_CODE = a.PRIMARY_SPECIALITY_CODE) and (b.PRIMARY_RESOURCE_CLASS != 'P' OR b.OPEN_TO_ALL_PRACT_YN != 'Y') and b.eff_status = 'E' ");
//	   sql.append("SELECT a.practitioner_id, a.practitioner_name, b.clinic_code, B.long_desc locn_long_desc, b.care_locn_type_ind, am_get_desc.AM_SPECIALITY (b.speciality_code, 'en', 2 ) specialty_short_desc, b.speciality_code, b.clinic_type, b.PRIMARY_RESOURCE_CLASS, b.OPEN_TO_ALL_PRACT_YN FROM am_practitioner a, op_clinic b WHERE a.practitioner_id = ? AND b.clinic_type = ? and b.facility_id=? and b.SPECIALITY_CODE = a.PRIMARY_SPECIALITY_CODE and (b.PRIMARY_RESOURCE_CLASS != 'P' OR b.OPEN_TO_ALL_PRACT_YN != 'Y') and b.eff_status = 'E' ");
	
	
	if(!speciality_id.equals("")){
		sql.append(" and b.speciality_code = '"+ speciality_id +"' ");
	}
	
	if(!search_by.equals("") && !search_desc.equals("")){
		if(search_by.equals("c")){
			sql.append(" and b.clinic_code like '%"+search_desc.toUpperCase()+"%' ");
		}else if(search_by.equals("d")){
			sql.append(" and UPPER(b.long_desc) like UPPER('%"+search_desc+"%')");//Modified By Gaurav for ML-MMOH-SCF-3045
		}	
	}
	
	if(oper.equals("modify")){
		sql.append(" and b.clinic_code in ("+ ext_count_str+")");
	}
	
	sql.append("order by B.long_desc asc");
}
System.err.println("168 in ResourceForLocnByPractCritResult.jsp sql="+sql.toString());
	pstmt=con.prepareStatement(sql.toString());
	pstmt.setString(1, practitionerid);
	pstmt.setString(2, care_locn_type_ind.toUpperCase());
	pstmt.setString(3, facilityid);
	pstmt.setString(4, facilityid);
	pstmt.setString(5, practitionerid);
	rs=pstmt.executeQuery();
	// Added for ML-MMOH-SCF-3045 start
	int rowCount = 0;
	if(cntOFPract <= 0 && oper.equals("create")){
		sql1.setLength(0);
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		HashMap<String, String> map1 = (HashMap<String, String>)(session.getAttribute("ResForLocnByPract")==null ? new HashMap<String, String>() : session.getAttribute("ResForLocnByPract"));
		String c_clinic_id="";
		// if(!fromSession){
		pstmt2=con.prepareStatement(sql.toString());
		pstmt2.setString(1, practitionerid);
		pstmt2.setString(2, care_locn_type_ind.toUpperCase());
		pstmt2.setString(3, facilityid);
		pstmt2.setString(4, facilityid);
		pstmt2.setString(5, practitionerid);
		rs2=pstmt2.executeQuery();
		int mapcnt=0;
		int prevPageno=1;
		while(rs2.next()){
			++mapcnt;
			int pageno = (int) Math.ceil(mapcnt/10.0);
			if(pageno<=prevPageno){
				prevPageno=pageno;
			}else{
				c_clinic_id="";
				prevPageno=pageno;
			}
			if(SimplifyPractNurs.containsObject(rs2.getString("clinic_code"))){
				if(c_clinic_id.equals(""))
					c_clinic_id=rs2.getString("clinic_code");
				else
					c_clinic_id=c_clinic_id+","+rs2.getString("clinic_code");
			}
			if(map1.get("page")!=null){
				int page1 = Integer.parseInt(map1.get("page"));
					if(pageno > page1){
					map1.put("c_clinic_id"+pageno, c_clinic_id);
					}
				}else{
					map1.put("c_clinic_id"+pageno, c_clinic_id);
				}
		}
		map1.put("oper", oper);
		map1.put("cntOFPract",Integer.toString(cntOFPract));
		map1.put("prevPageno",Integer.toString(prevPageno));
		session.setAttribute("ResForLocnByPract", map1);
		if(pstmt2!=null)pstmt2.close();
		if(rs2!=null)rs2.close();
	}
	 // Added for ML-MMOH-SCF-3045 end

            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start== 1) )			
	for( int j=1; j<start; i++,j++ )   
		rs.next() ; 

while(i <= end &&  rs.next())
{
	if(cnt == 0){

            _bw.write(_wl_block9Bytes, _wl_block9);

							if ( !(start <= 1) )
							{
								out.println("<A HREF='javascript:submitPrevNext("+(start-10)+","+(end-10)+", "+start+", "+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							}
							if (endOfRes.equals("1"))
							 {
								out.println("<A id='nextval' HREF='javascript:submitPrevNext("+(start+10)+","+(end+10)+", "+start+", "+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
							 }

							
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(end));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
		if(ClinicForPracts.containsObject(rs.getString("clinic_code"))){
			proceedToByLocn = "Y";
		}
	
		if(SimplifyPractNurs.containsObject(rs.getString("clinic_code")) || ClinicForPracts.containsObject(rs.getString("clinic_code"))){
			checkClinic = " checked ";
			checkClinicValue = "Y";
		}else{
			checkClinic = " ";
			checkClinicValue = "N";
		}
		//Added by Ajay Hatwate for ML-MMOH-SCF-3045
		if(fromSession){
			if(c_code != null){
				if(NextPrevRecClinis.containsObject(rs.getString("clinic_code"))){
					checkClinic = " checked ";
					checkClinicValue = "Y";
				}else{
					checkClinic = " ";
					checkClinicValue = "N";
				}
			}
		}
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString("locn_long_desc") ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("specialty_short_desc") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("practitioner_id") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("speciality_code") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("clinic_code") ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(care_locn_type_ind ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( rs.getString("clinic_type")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(proceedToByLocn ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("practitioner_id") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("speciality_code") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("clinic_code") ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(care_locn_type_ind ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( rs.getString("clinic_type")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(proceedToByLocn ));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(checkClinic ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs.getString("clinic_code")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkClinicValue ));
            _bw.write(_wl_block29Bytes, _wl_block29);

	i++;
	cnt++;
} 

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(care_locn_type_ind.toUpperCase()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(isSimplifyPractNursUnit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(speciality_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(search_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(start));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(end));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(oper));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block42Bytes, _wl_block42);

	if (!rs.next() && cnt!=0 )
	{
	endOfRes = "0";	
	
            _bw.write(_wl_block43Bytes, _wl_block43);

	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();

}catch(Exception e){
		e.printStackTrace();
	}
	finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}

if(cnt==0)	
	   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WeekAppl.label", java.lang.String .class,"key"));
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
