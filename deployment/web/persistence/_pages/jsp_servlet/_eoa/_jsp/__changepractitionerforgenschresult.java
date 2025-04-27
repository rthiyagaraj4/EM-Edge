package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __changepractitionerforgenschresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ChangePractitionerforGenSchResult.jsp", 1729083085236L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n   <script src=\'../../eOA/js/ChangePractitionerforGenSch.js\' language=\'javascript\'></script>\n   <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n   <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\n</head>\n\n<BODY  class=\'CONTENT\'  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n   <form name=\"search_result_form\" id=\"search_result_form\" action=\'../../servlet/eOA.ChangePractitionerforGenSchServlet\' method=\'post\' target=\'messageFrame\'>\n   <DIV align=\'left\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\t\n\t\t\t  <table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n        <td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n        <td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td> \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t  \t   <tr><td  class=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t  \t \t  \t   <input type=\'hidden\' name=\'clinic_date";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' id=\'clinic_date";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t  \t   </td><td  class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t  \t      \t</td><td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<a href=javascript:show_modwin(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\') alt=\'Appointment Details\' >\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\t  \t   \t</td><td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t  \t   </td><td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  > \n\t  \t   <input type=\'checkbox\' name=\'ad_chk_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'ad_chk_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' checked  onClick=\'setVal(this)\'> </td> \n\t\t\t\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'con_val_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'con_val_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'> </td></tr>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t           <script language=\'javascript\'>\n                parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num= \'\n\t\t\t\tparent.frames[0].document.forms[0].genRep1.disabled = false;\n\t\t\t  </script>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t  <script>alert(getMessage(\'NO_RECORD_FETCHED\',\'OA\'))</script> \n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t           <script language=\'javascript\'>\n\t\t\t\tparent.frames[0].document.forms[0].genRep1.disabled = true;                parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+getMessage(\'NO_RECORD_FETCHED\',\'OA\');\n              </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n      </table>\n      <input type=\'hidden\' name=\'no_of_rec\' id=\'no_of_rec\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >\n\t\t<input type=\'hidden\' name=\'day\' id=\'day\'  value= \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' >\n\t\t<input type=\'hidden\' name=\'final_vals\' id=\'final_vals\'  value= \'\' >\n\t\t<input type=\'hidden\' name=\'sel_rec\' id=\'sel_rec\'  value= \'\' >\n\t\t<input type=\'hidden\' name=\'P_Practitioner_Id\' id=\'P_Practitioner_Id\'  value= \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t\t<input type=\'hidden\' name=\'P_To_Practitioner_Id\' id=\'P_To_Practitioner_Id\'  value= \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t\t<input type=\'hidden\' name=\'eff_from\' id=\'eff_from\'  value= \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t\t<input type=\'hidden\' name=\'eff_to\' id=\'eff_to\'  value= \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\'hidden\' name=\'reason\' id=\'reason\'  value= \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t\t<input type=\'hidden\' name=\'reason1\' id=\'reason1\'  value= \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"   value=\"OA\"></input>\n\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\"   value=\"OAAFAPLST\"></input>\n\t\t<input type=\"hidden\" name=\"P_Facility_id\" id=\"P_Facility_id\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'></input>\n\t\t<input type=\"hidden\" name=\"locncode\" id=\"locncode\" value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'></input>\n\t\t<input type=\"hidden\" name=\"P_Report_Title\" id=\"P_Report_Title\" value=\'List_of_Appointments_for_change_of_Practitioner\'></input>\n\t\t<input type=\"hidden\" name=\"maxRecs\" id=\"maxRecs\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"></input>\n\t\t<input type=\"hidden\" name=\"locnType\" id=\"locnType\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name=\"resType\" id=\"resType\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"hidden\" name=\"resource_value\" id=\"resource_value\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n    </DIV>\n   </form>\n   </body>\n  </html>\n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

  Connection conn=null;
  Statement stmt=null;
  ResultSet rs=null;
  PreparedStatement pstmt=null;
  int maxRecord = 0;
  int i=0;
  request.setCharacterEncoding("UTF-8");	
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
  String locale = (String)session.getAttribute("LOCALE");


  String facility_id = request.getParameter("facility_id")==null ?"":request.getParameter("facility_id");
  String loc = request.getParameter("locn")==null ?"":request.getParameter("locn");
  String from_pract = request.getParameter("from_pract")==null ?"":request.getParameter("from_pract");
  String to_pract = request.getParameter("to_pract")==null ?"":request.getParameter("to_pract");
  String day = request.getParameter("day")==null ?"":request.getParameter("day");
  String from_date = request.getParameter("from_dt")==null ?"":request.getParameter("from_dt");
  String to_date = request.getParameter("to_dt")==null ?"":request.getParameter("to_dt");
  String reason = request.getParameter("reason")==null ?"":request.getParameter("reason");
  String reason1 = request.getParameter("reason1")==null ?"":request.getParameter("reason1");
  String locationType=request.getParameter("locationType")==null?"":request.getParameter("locationType");
  String resourceType=request.getParameter("resourceType")==null?"":request.getParameter("resourceType");
  String practid ="";
  String cliniccode ="";
  String clinicdate ="";
  String L_clinic_code="";
  String primary_yn = "";
  String care_locn_type_ind="";
  String resource_class="";

  from_date=DateUtils.convertDate(from_date,"DMY",locale,"en");
  to_date=DateUtils.convertDate(to_date,"DMY",locale,"en");


  StringTokenizer st = new StringTokenizer(loc,"|");
  while (st.hasMoreTokens()) 
  {
        L_clinic_code=st.nextToken();
    st.nextToken();
  st.nextToken();
  }

// String sql="Select TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') Clinic_date,CLINIC_DATE clnc_date, INITCAP(to_char(Clinic_date,'DAY')) day, NVL(Total_slots_booked,0)+ NVL(Total_slots_overbooked,0) no_of_appts,nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked,primary_resource_yn, practitioner_id, clinic_code,care_locn_type_ind,resource_class from OA_CLINIC_SCHEDULE Where facility_id = '"+facility_id+"' and clinic_code = '"+L_clinic_code+"'  and practitioner_id = '"+from_pract+"' and care_locn_type_ind='"+locationType+"'and resource_class='"+resourceType+"' and rtrim(to_char(clinic_date,'DAY')) = nvl(rtrim('"+day+"'), rtrim(to_char(clinic_date,'DAY'))) and clinic_date between TO_DATE('"+from_date+"','DD/MM/YYYY') and TO_DATE('"+to_date+"','DD/MM/YYYY') and clinic_date not in ( Select   Clinic_date from OA_CLINIC_SCHEDULE Where facility_id ='"+facility_id+"' and clinic_code = '"+L_clinic_code+"' and practitioner_id = '"+to_pract+"' and rtrim(to_char(clinic_date,'DAY'))  =nvl(rtrim('"+day+"'),rtrim(to_char(clinic_date,'DAY')) )  and care_locn_type_ind='"+locationType+"'and resource_class='"+resourceType+"' and clinic_date between TO_DATE('"+from_date+"','DD/MM/YYYY') and TO_DATE('"+to_date+"','DD/MM/YYYY'))  order by clnc_date   ";
 String sql="Select TO_CHAR(CLINIC_DATE,'DD/MM/YYYY') Clinic_date,CLINIC_DATE clnc_date, INITCAP(to_char(Clinic_date,'DAY')) day, NVL(Total_slots_booked,0)+ NVL(Total_slots_overbooked,0) no_of_appts,nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked,primary_resource_yn, practitioner_id, clinic_code,care_locn_type_ind,resource_class from OA_CLINIC_SCHEDULE Where facility_id = ? and clinic_code = ?  and practitioner_id = ? and care_locn_type_ind=? and resource_class=? and rtrim(to_char(clinic_date,'DAY')) = nvl(rtrim(?), rtrim(to_char(clinic_date,'DAY'))) and clinic_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') and clinic_date not in ( Select   Clinic_date from OA_CLINIC_SCHEDULE Where facility_id =? and clinic_code = ? and practitioner_id = ? and rtrim(to_char(clinic_date,'DAY'))  =nvl(rtrim(?),rtrim(to_char(clinic_date,'DAY')) )  and care_locn_type_ind=? and resource_class=? and clinic_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY'))  order by clnc_date   ";
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 	
try
	{
		conn = ConnectionManager.getConnection(request);  
		stmt = conn.createStatement();
	  	//rs = stmt.executeQuery(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,L_clinic_code);
		pstmt.setString(3,from_pract);
		pstmt.setString(4,locationType);
		pstmt.setString(5,resourceType);
		pstmt.setString(6,day);
		pstmt.setString(7,from_date);
		pstmt.setString(8,to_date);
		pstmt.setString(9,facility_id);
		pstmt.setString(10,L_clinic_code);
		pstmt.setString(11,to_pract);
		pstmt.setString(12,day);
		pstmt.setString(13,locationType);
		pstmt.setString(14,resourceType);
		pstmt.setString(15,from_date);
		pstmt.setString(16,to_date);
		rs = pstmt.executeQuery();
	  	String noofappts = "";
	  	String classValue = "";
		String clinicdate_disp="";
		String day_code="";
		String day_desc="";
	  	if(rs!=null) 
	      	{
	  	  while(rs.next() )
	  	  {
			  if(i==0)
			  {

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

		  }
			 if ( i % 2 == 0 )
		      classValue = "QRYEVEN" ;
		   else
		      classValue = "QRYODD" ;
		    practid 	= rs.getString ("practitioner_id");
	  	   cliniccode 	= rs.getString ("clinic_code");
	  	   clinicdate 	= rs.getString("clinic_date");
		   clinicdate_disp=DateUtils.convertDate(clinicdate,"DMY","en",locale);

		   care_locn_type_ind= rs.getString("care_locn_type_ind");	
		   resource_class= rs.getString("resource_class");	
			noofappts = rs.getString("total_slots_booked");
			primary_yn = rs.getString("primary_resource_yn");

			day_code = rs.getString("day");
			day_code=day_code.trim();
				if(day_code.equalsIgnoreCase("Monday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Tuesday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Wednesday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Thursday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Friday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_code.equalsIgnoreCase("Saturday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_code.equalsIgnoreCase("Sunday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}




            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(clinicdate_disp));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString("clinic_date")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(day_desc));
            _bw.write(_wl_block2Bytes, _wl_block2);

	  	   if(!(noofappts.equals("0"))){ 

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(primary_yn.equals("Y")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("day").trim()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinicdate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(care_locn_type_ind));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block1Bytes, _wl_block1);

				}
				else {

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(noofappts));
            _bw.write(_wl_block26Bytes, _wl_block26);
 
					} 

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString("clinic_date")));
            _bw.write(_wl_block32Bytes, _wl_block32);
 i++;
	  	   maxRecord++;
			  }

            _bw.write(_wl_block33Bytes, _wl_block33);

	   if(i==0){

            _bw.write(_wl_block34Bytes, _wl_block34);

		   }
			  }
	      else {
	        
            _bw.write(_wl_block35Bytes, _wl_block35);

	      }


	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();

} catch(Exception e){
//out.println("ee"+e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally   {
   ConnectionManager.returnConnection(conn,request);
}
 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(day));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(from_pract));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(to_pract));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(from_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(reason1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(loc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(resourceType));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.NoOfAppts.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
