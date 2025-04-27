package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __reportsserverside extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ReportsServerSide.jsp", 1711968477614L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n       \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\n\t var element = document.createElement(\'OPTION\');\n\telement.text = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\telement.value= \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\tdocument.forms[0].fm_pract_type.add(element);\n\t var element1 = document.createElement(\'OPTION\');\n\telement1.text = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\telement1.value= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\tdocument.forms[0].to_pract_type.add(element1);\n\t ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n     var i=2;\n     var len=parent.frames[1].document.forms[0].location_name.options.length;\n     var lBox=parent.frames[1].document.forms[0].location_name; \n     lBox.remove(lBox.options[0]);\n     var opt=parent.frames[1].document.createElement(\'OPTION\');\n     opt.value=\'\';\n     opt.text=\'  --Select-- \';\n\t lBox.add(opt);\n     while(i<= len){\n\t\t lBox.remove(lBox.options[i]);\n\t\t i+=1;\n\t}\n\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="    \n\t\n\t\t\n\t\tvar opt=parent.frames[1].document.createElement(\'OPTION\');\n\t\topt.value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="$";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\topt.text=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\tparent.frames[1].document.forms[0].location_name.add(opt);\n       \t\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\tparent.frames[1].document.getElementById(\"resource_class\").value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\tparent.frames[1].document.getElementById(\"P_RESOURCE_CLASS\").value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\n\t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\n\tparent.frames[1].document.forms[0].appt_date.value=convertDate(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\"DMY\",\"en\",localeName);\n\tparent.frames[1].document.forms[0].patient_id.value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n//Mahesh added for the IN:034921  as on 04/09/2012\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n//End\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
 

	Connection con = null;
	ResultSet rs=null;
	Statement stmt = null;
	String SQL="";
	request.setCharacterEncoding("UTF-8");

try
	{
	con = ConnectionManager.getConnection(request);
	 stmt = con.createStatement();
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;
			String facilityId	=(String) session.getValue("facility_id");
			String loginuser 	= (String) session.getValue( "login_user");
			String locale = (String)session.getAttribute("LOCALE");
			
			String f_mode		= request.getParameter("function_mode");
			String resource1		=(String) hash.get("resource1");
			String steps		=(String) hash.get("steps");
			String clinic_type		=(String) hash.get("clinic_type");
			String speciality		=(String) hash.get("speciality");
			String clinic_code1		=(String) hash.get("clinic_code1");
			if(steps==null) steps="";
			if(f_mode==null) f_mode="";
			if(resource1==null) resource1="";
			if(speciality==null) speciality="";
			if(clinic_code1==null) clinic_code1="";
			if(clinic_type==null) clinic_type="";
	
			ResultSet rssql1=null;
			ResultSet rssql2=null;
			
			String oper_stn_id="";

			Statement stsql2 = con.createStatement();	
			Statement stsql1 = con.createStatement();
		 if(steps.equals("1")){
	 if(resource1.equals("R")){
	SQL="select locn_type res_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind='R' and language_id='"+locale+"' ";
	
	 }
	 if(resource1.equals("P"))
	 {
		 SQL="select pract_type res_type,Desc_Userdef short_desc from am_pract_type_lang_vw where language_id='"+locale+"' order by 2";
	 }
	  if(resource1.equals("E") || resource1.equals("O"))
	 {
		 SQL="select resource_type res_type,short_desc from  am_resource_type_lang_vw  where resource_Class='"+resource1+"' and language_id='"+locale+"' ";
	 }
	 

rssql1 = stsql1.executeQuery(SQL);
String short_desc="";
String room_type="";
	


		while(rssql1!=null && rssql1.next() ){
		room_type=rssql1.getString("res_type");
	short_desc=rssql1.getString("short_desc");
		
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(room_type));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(room_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
    }
if (rssql1!=null) rssql1.close();
}else if(steps.equals("11")){

		String sql2="SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
		rssql2=stsql2.executeQuery(sql2);
			
		if (rssql2!=null && rssql2.next()){
		oper_stn_id=rssql2.getString("oper_stn_id");
		}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
		if (rssql2!=null) rssql2.close();

	 StringBuffer sql_main=new StringBuffer();
   sql_main.append("select a.open_to_all_pract_yn,a.long_desc,a.clinic_code from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id='"+oper_stn_id+"' and a.language_id='"+locale+"' and b.appl_user_id='"+loginuser+"' and (b.book_appt_yn='Y' or b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type and ");
	
	if(!speciality.equals("")){
		sql_main.append(" a.SPECIALITY_CODE='"+speciality+"' and ");
	}
	
	
	
	if(clinic_type.equals("D")){
	  sql_main.append("  a.clinic_type='Y' ");

	  }else{
		sql_main.append("  a.clinic_type='"+clinic_type+"' ");

	  }
	
	sql_main.append(" and a.CARE_LOCN_TYPE_IND='"+clinic_type+"' order by a.long_desc");
    
	if (rs!=null) rs.close();
	rs = stmt.executeQuery(sql_main.toString());
	sql_main.setLength(0);
	
            _bw.write(_wl_block9Bytes, _wl_block9);
	
		String short_desc="";
	String clinic_code="";
	String open_to_all_pract_yn="";

   while(rs!=null && rs.next() )
	   {
		short_desc=rs.getString("long_desc");
		clinic_code=rs.getString("clinic_code");
		open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
	
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}	
}
else if(steps.equals("X")){
	 String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";

	 String code="";
	 String desc="";

    if (rs!=null) rs.close();
	rs = stmt.executeQuery(sql);

	 while(rs!=null && rs.next()){
		 code=rs.getString("primary_resource_class");
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
		
	 }
	 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(code));
            _bw.write(_wl_block16Bytes, _wl_block16);


}
//Mahesh added for the IN:034921 as on 04/09/2012
else if(steps.equals("reprint_appt_slip"))
	{
	String appt_id		= (String) hash.get("appt_id");
	String appt_date="";
	String patient_id="";
	try
		{
		rs=stmt.executeQuery("Select to_char(appt_date,'dd/MM/yyyy') appt_date,patient_id from oa_appt where APPT_REF_NO='"+appt_id+"'");
		if(rs.next())
			{
			appt_date=checkForNull(rs.getString(1));
			patient_id=checkForNull(rs.getString(2));
			}
		}
	catch(Exception e)	
		{
		//System.out.println("Exception occurred while getting Pat ID and Appt Date "+e);
		e.printStackTrace();
		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
//End	
if(rs !=null) rs.close();
if(rssql1 !=null)rssql1.close();
if(stmt !=null) stmt.close();
if (stsql1!=null) stsql1.close();
if (stsql2!=null) stsql2.close();
hash.clear();
}catch( Exception e ){
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
