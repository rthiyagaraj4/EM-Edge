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

public final class __timetablepract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/TimeTablePract.jsp", 1709119280553L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!--\n\tDeveloped by \t:\tR.Nanda Kumar\n\tCreated on \t:\t17/02/2001\n\tModule\t\t:\tOA\n\tFunction\t:\tThis function is used\n\n \n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>\t\t\t\n\t\tvar opt = parent.frames[1].document.createElement(\'OPTION\');\n\t\tvar opt1 = parent.frames[1].document.createElement(\'OPTION\');\n\t\tvar opt = parent.frames[1].document.createElement(\'OPTION\');\n\t\tvar opt1 = parent.frames[1].document.createElement(\'OPTION\');\n\t\topt1.text = \"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\topt1.value= \'*A\';\n\t\tparent.frames[1].document.forms[0].b_day.add(opt1);\n\t\tparent.frames[1].document.forms[0].l_ident_at_checkin.value \t=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" ;\n\t\tparent.frames[1].document.forms[0].l_fi_visit_type_appl_yn.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" ;\n\t\tparent.frames[1].document.forms[0].l_open_to_all_pract_yn.value\t=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" ;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].b_day.add(element);\n\t\t\t\t\t\t//parent.frames[1].document.forms[0].b_day.focus(); Commented by S.Sathish for IN022500 on Wednesday, July 07, 2010\n\t\t\t\t\t</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].b_day.add(element);\n\t\t\t\t\t\t\t//parent.frames[1].document.forms[0].b_day.focus(); Commented by S.Sathish for IN022500 on Wednesday, July 07, 2010\n\t\t\t\t\t\t</script>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].b_day.add(element);\n\t\t\t\t\t\t\t//parent.frames[1].document.forms[0].b_day.focus();   Commented by S.Sathish for IN022500 on Wednesday, July 07, 2010\n\t\t\t\t\t</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<script>\n\t\t\tparent.frames[1].document.getElementById(\"imgpract\").style.visibility = \'visible\';\n\t\t\t//parent.frames[1].document.forms[0].b_day.disabled=true;\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<script>\n\t\t\tparent.frames[1].document.getElementById(\"imgpract\").style.visibility = \'hidden\';\n\t\t\t//parent.frames[1].document.forms[0].b_day.disabled=false;\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<script>\n\t\t\tvar opt = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\tparent.frames[1].document.forms[0].b_practitioner.add(opt);\n\t\t\tvar opt = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\tparent.frames[1].document.forms[0].b_day.add(opt);\n\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\tvar element1 = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\telement1.text = \"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t\t\telement1.value= \"*A\";\n\t\t\tparent.frames[1].document.forms[0].b_day.add(element1);\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].b_practitioner.add(element);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].b_day.add(element);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  \n\t<script>\n\tdayObj=parent.frames[1].document.forms[0].b_day;\n    parent.frames[1].document.forms[0].DaysForClinic.value=\'\';\n\tvar len=dayObj.options.length;\n\tfor(i=2;i<len;i++) \n\tparent.frames[1].document.forms[0].DaysForClinic.value+=dayObj.options[i].value+\'\'+dayObj. options[i].text+\'|\'; \n\t</script>\n\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con = null;
Statement stmt=null;
ResultSet rs=null;
request.setCharacterEncoding("UTF-8");
try{
con = ConnectionManager.getConnection(request);
	String fac_id  		= (String) session.getValue( "facility_id" ) ;
	String p_clinic_code	= request.getParameter("cliniccode");
	String resource_type		= request.getParameter("resource_type");
	//System.out.println("p_clinic_code :"+p_clinic_code);
	//System.out.println("resource_type :"+resource_type);
	String resource_id		= request.getParameter("resource_id");
	String primary_resource_class="";
	StringBuffer sql1=new StringBuffer();
	//System.out.println("resource_id :"+resource_id);
    
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>");

	stmt = con.createStatement() ;
	if(!(p_clinic_code.equals("*A"))){

		sql1.append("select clinic_type,ident_at_checkin,fi_visit_type_appl_yn,open_to_all_pract_yn,primary_resource_class from op_clinic where facility_id = '"+fac_id+"' and eff_status = 'E' and clinic_code = '"+p_clinic_code+"' order by short_desc ");

		rs  = stmt.executeQuery(sql1.toString()) ;

		sql1.setLength(0);

		rs.next() ;

		String p_fi_visit_type_appl_yn 	= rs.getString("fi_visit_type_appl_yn") ;
		String p_ident_at_checkin	= rs.getString("ident_at_checkin") ;
		String p_clinic_type		= rs.getString("clinic_type") ;
		String p_open_to_all_pract_yn	= rs.getString("open_to_all_pract_yn") ;
		primary_resource_class	= rs.getString("primary_resource_class") ;

		sql1.append("select short_desc from am_care_locn_type where locn_type = '"+p_clinic_type+"' " );

		if (rs!=null) rs.close();
		rs   = stmt.executeQuery(sql1.toString()) ;

		sql1.setLength(0);
		rs.next() ;

		//String p_clinic_type_desc	= rs.getString("short_desc") ;

		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(p_ident_at_checkin));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_fi_visit_type_appl_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_open_to_all_pract_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);

		String str1 = "";
		String str2 = "";
		int counter=0;

		if (p_open_to_all_pract_yn.equalsIgnoreCase("Y")){

			if (rs!=null)rs.close();
			//if(primary_resource_class.equals("P") && !resource_type.equals("P")){
				sql1.append( "select initcap(day_of_week)day_of_week, day_no from sm_day_of_week a where exists " );
				sql1=sql1.append("(select '1' from op_pract_for_clinic_vw where decode(a.day_no,'1',working_day_1," );
				sql1 =sql1.append("'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,") ;
				sql1 = sql1.append("'6',working_day_6,'7',working_day_7)='Y' and facility_id='"+fac_id+"' and clinic_code = '"+p_clinic_code+"' and PRACTITIONER_ID='"+resource_id+"' ") ;
				sql1 = sql1.append("and eff_status='E') order by 2") ;
				stmt = con.createStatement() ;
				rs = stmt.executeQuery(sql1.toString()) ;
				//System.out.println("sql1.toString() AA:"+sql1.toString());
				sql1.setLength(0);
				if (rs != null)	{
					while (rs.next()){
					str1 = rs.getString( "day_of_week" ) ;
					str2 = rs.getString( "day_no" );

					if(str1.equals("Monday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(str1.equals("Tuesday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(str1.equals("Wednesday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(str1.equals("Thursday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(str1.equals("Friday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(str1.equals("Saturday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(str1.equals("Sunday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block12Bytes, _wl_block12);

					counter++;
				}
				if(counter>0)
					stmt.close();
				}
			//}
			if(counter==0){
				sql1.append("select initcap(day_of_week)day_of_week, day_no from sm_day_of_week a where exists " );
				sql1 =sql1.append("(select '1' from op_clinic where " );
				sql1 =sql1.append("decode(a.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3, ");
				sql1 =sql1.append("'4',working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' ");
				sql1 =sql1.append("and facility_id='"+fac_id+"' and clinic_code='"+p_clinic_code+"'and eff_status='E' ) order by 2 ");

				if (rs!=null) rs.close();
				//System.out.println("sql1.toString() 11:"+sql1.toString());
				rs = stmt.executeQuery(sql1.toString()) ;

				sql1.setLength(0);

				if (rs != null)	{
					while (rs.next()){
						str1 = rs.getString( "day_of_week" ) ;
						str2 = rs.getString( "day_no" );

						if(str1.equals("Monday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
									}else if(str1.equals("Tuesday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
									}else if(str1.equals("Wednesday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
									}else if(str1.equals("Thursday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
									}else if(str1.equals("Friday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
									}else if(str1.equals("Saturday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
									}else  if(str1.equals("Sunday"))
									{
										str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
									}

						
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}
					stmt.close();
				}
			}
    	}else{
			rs.close() ;

			sql1.append( "select initcap(day_of_week)day_of_week, day_no from sm_day_of_week a where exists " );
			sql1=sql1.append("(select '1' from op_pract_for_clinic_vw where decode(a.day_no,'1',working_day_1," );
			sql1 =sql1.append("'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,") ;
			sql1 = sql1.append("'6',working_day_6,'7',working_day_7)='Y' and facility_id='"+fac_id+"' and clinic_code = '"+p_clinic_code+"' and PRACTITIONER_ID='"+resource_id+"' ") ;
			sql1 = sql1.append("and eff_status='E') order by 2") ;
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql1.toString()) ;
			//System.out.println("sql1.toString() 22:"+sql1.toString());
			sql1.setLength(0);

			str1 = "" ;
			str2 = "" ;

			if (rs != null)	{
				while (rs.next()){
						str1 = rs.getString( "day_of_week" ) ;
					str2 = rs.getString( "day_no" );

					if(str1.equals("Monday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(str1.equals("Tuesday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(str1.equals("Wednesday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(str1.equals("Thursday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(str1.equals("Friday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(str1.equals("Saturday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(str1.equals("Sunday"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
		
			}

		}

		if(p_ident_at_checkin.equals("P")){
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
}

	
	}else if(p_clinic_code.equals("*A")){
            _bw.write(_wl_block20Bytes, _wl_block20);


		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		stmt = con.createStatement() ;
		sql1.append("select a.practitioner_id,a.short_name from am_practitioner a, am_pract_for_facility  b where a.practitioner_id=b.practitioner_id  and b.facility_id ='"+fac_id+"' and a.eff_status='E' and b.eff_status = 'E' ");
		rs = stmt.executeQuery(sql1.toString()) ;
		sql1.setLength(0);
		String str1 = "";
		String str2 = "";

		if( rs != null ){
			while( rs.next() ){
				str1 = rs.getString( "short_name" ) ;
				str2 = rs.getString( "practitioner_id" );
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
		}

		rs.close() ;
		sql1.append("select day_of_week,day_no from sm_day_of_week ") ;
		if (stmt!=null) stmt.close();
		stmt = con.createStatement() ;
		rs = stmt.executeQuery(sql1.toString()) ;
		sql1.setLength(0) ;
		str1 = "" ;
		str2 = "" ;

		if (rs != null){
			while (rs.next()){
				str1 = rs.getString( "day_of_week" ) ;
				str2 = rs.getString( "day_no" );

				if(str1.equals("MONDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(str1.equals("TUESDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(str1.equals("WEDNESDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(str1.equals("THURSDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(str1.equals("FRIDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(str1.equals("SATURDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(str1.equals("SUNDAY"))
								{
									str1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block24Bytes, _wl_block24);

			}
		}

	}
	
            _bw.write(_wl_block25Bytes, _wl_block25);

	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
