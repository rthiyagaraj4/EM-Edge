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
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __getvaltransfersch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/GetValTransferSch.jsp", 1712740052341L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<html><HEAD>\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n</HEAD><body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'><form name=\'testform\' id=\'testform\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\tparent.frames[1].document.getElementById(locn_type).innerText = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\tvar opt = parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text = \"----";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="----\";\n\t\t\topt.value= \'\';\n\t\t\tparent.frames[1].document.forms[0].practitioner.add(opt);\n\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].practitioner.add(element);\n\n\t\t\t\t\t</script>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>\n\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].from_day.add(element);\n\n\t\t\t</script>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<script>\n\t\t\tvar opt = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\topt.text = \"----";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="----\";\n\t\t\topt.value= \'\';\n\t\t\tparent.frames[1].document.forms[0].from_day.add(opt);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<script> /* Below line was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/\n\t\t\t\t\tvar element = parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="----\";\n\t\t\topt.value= \'\';\n\t\t\tparent.frames[1].document.forms[0].to_day.add(opt);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\t/* Below line was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/\n\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].to_day.add(element);\n\n\t\t\t</script>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locn = request.getParameter("locn");
	String pract = request.getParameter("pract");
	String fromday = request.getParameter("fromday");
	String P_flag = request.getParameter("p_flag");
	Connection con = null;
	String facilityId = (String)session.getValue("facility_id");
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	String sql="";
	String dat="";
	String id = "";
	String locn_id="";
	String locn_type = "";
	String opentoall = "";
	String day_in_caps="";
    String locale=(String)session.getAttribute("LOCALE");

	String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	
	StringTokenizer st = new StringTokenizer(locn,"|");
	while (st.hasMoreTokens())
	{

			locn_id = st.nextToken();
			locn_type = st.nextToken();
			opentoall = st.nextToken();

	}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try {

	con = ConnectionManager.getConnection(request);
 	stmt = con.createStatement() ;

		if((pract.equals("") || pract == null) && (fromday.equals("") || fromday == null)){
		if (!(locn_id.equals("") || locn_id == null))
		{


		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(default_select));
            _bw.write(_wl_block11Bytes, _wl_block11);

			if(opentoall.equals("Y")){
			//	sql  = " select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name from  am_pract_for_facility where eff_status = 'E'  and operating_facility_id = '"+facilityId+"'  order by 2";
				sql  = " select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1') practitioner_name from  am_pract_for_facility where eff_status = 'E'  and operating_facility_id = ? order by 2";
			}else{
			   //sql="Select a.practitioner_id, b.practitioner_name practitioner_name from am_pract_for_facility a,  am_practitioner_lang_vw b, op_clinic c  where b.language_id = '"+locale+"' and b.practitioner_id = a.practitioner_id  and a.eff_status = 'E' and a.facility_id = '"+facilityId+"'  and c.facility_id = a.facility_id and c.clinic_code = '"+locn_id+"' and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityId+"' and  practitioner_id = b.practitioner_id ))  and nvl(c.pract_type, b.pract_type) = b.pract_type order by practitioner_name";
			   sql="Select a.practitioner_id, b.practitioner_name practitioner_name from am_pract_for_facility a,  am_practitioner_lang_vw b, op_clinic c  where b.language_id = ? and b.practitioner_id = a.practitioner_id  and a.eff_status = 'E' and a.facility_id = ?  and c.facility_id = a.facility_id and c.clinic_code = ? and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = ? and  practitioner_id = b.practitioner_id ))  and nvl(c.pract_type, b.pract_type) = b.pract_type order by practitioner_name";
			}
				
			//rs = stmt.executeQuery(sql) ;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,facilityId);
			if(opentoall.equals("Y")){
			}else{
			pstmt.setString(3,locn_id);
			pstmt.setString(4,facilityId);
			}
			rs = pstmt.executeQuery();
			if (rs != null)
			{
				while(rs.next())
				{
					

					dat=rs.getString("practitioner_name");
					id=rs.getString("practitioner_id");
					
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
		}
		if(rs !=null) rs.close();
}


}

if(P_flag.equals("Y")){
if(pract.equals("") || pract == null ){
if (!(locn_id.equals("") || locn_id == null))
{



			
			sql = "Select initcap(DAY_OF_WEEK)day_week, DAY_NO FROM SM_DAY_OF_WEEK Order by 2 ";
			rs = stmt.executeQuery(sql) ;

			if (rs != null)
			{
				while(rs.next())
				{
					dat=rs.getString("day_week");
					id=rs.getString("DAY_NO");

					if(dat.equals("Monday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dat.equals("Tuesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dat.equals("Wednesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dat.equals("Thursday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dat.equals("Friday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dat.equals("Saturday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dat.equals("Sunday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
		}
		if(rs !=null) rs.close();
}
}
}

if(fromday.equals("") || fromday == null){
if(!(locn_id.equals("") || locn_id == null)){
if (!(pract.equals("") || pract == null))
{


            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(default_select));
            _bw.write(_wl_block19Bytes, _wl_block19);

				sql = "Select initcap(DAY_OF_WEEK)day_week, DAY_NO FROM SM_DAY_OF_WEEK Order by 2 ";
			rs = stmt.executeQuery(sql) ;

			if (rs != null)
			{
				while(rs.next())
				{

					dat=rs.getString("day_week");
					id=rs.getString("DAY_NO");
					day_in_caps	=dat.toUpperCase();
					
					 
					 

					if(dat.equals("Monday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dat.equals("Tuesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dat.equals("Wednesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dat.equals("Thursday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dat.equals("Friday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dat.equals("Saturday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dat.equals("Sunday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(day_in_caps));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
		}
		if(rs !=null) rs.close();
}
}
}

if(!(fromday.equals("") || fromday == null)){
if(!(locn_id.equals("") || locn_id == null)){


            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(default_select));
            _bw.write(_wl_block21Bytes, _wl_block21);

		//sql = "Select initcap(DAY_OF_WEEK)day_week, DAY_NO FROM SM_DAY_OF_WEEK where initcap(rtrim(DAY_OF_WEEK)) != rtrim('"+fromday+"') Order by 2 ";
		sql = "Select initcap(DAY_OF_WEEK)day_week, DAY_NO FROM SM_DAY_OF_WEEK where initcap(rtrim(DAY_OF_WEEK)) != rtrim(?) Order by 2 ";
		//	rs = stmt.executeQuery(sql) ;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,fromday);
			rs = pstmt.executeQuery();
			if (rs != null)
			{
				while(rs.next())
				{
					dat=rs.getString("day_week");
					id=rs.getString("DAY_NO");
                    day_in_caps	=dat.toUpperCase();
					if(dat.equals("Monday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dat.equals("Tuesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dat.equals("Wednesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dat.equals("Thursday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dat.equals("Friday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dat.equals("Saturday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dat.equals("Sunday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(day_in_caps));
            _bw.write(_wl_block23Bytes, _wl_block23);

				}
			}
			if(rs !=null) rs.close();
	}
	}
	if(rs != null) rs.close();
	if(rs1 != null) rs1.close();
	if(stmt != null)stmt.close();
}catch(Exception e){
//out.print("thre :" +e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
