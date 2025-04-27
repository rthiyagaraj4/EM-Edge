package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __fetchvalforblockbed extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FetchValForBlockBed.jsp", 1742378978040L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<script language=\"JavaScript\">\n\nfunction bedDetails(errMsg)\n{\n\tvar err_msg = errMsg;\n\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+err_msg;\t\t\n\tvar obj= parent.frames[1].document.forms[0]\t\n\tif(parent.frames[1].document.getElementById(\"bedclass\"))\n\t\tparent.frames[1].document.getElementById(\"bedclass\").innerText=\'\'\n\n\tif(parent.frames[1].document.getElementById(\"roomno\"))\n\t\tparent.frames[1].document.getElementById(\"roomno\").innerText=\'\'\n\n\tobj.bed_class.value = \'\';\n\tobj.bed_type.value = \'\';\n\tobj.room_no.value = \'\';\t\n\tobj.bed_no.value = \'\';\n\tobj.bed_no.focus();\n}\n</script>\n\t<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\n\t<body class=\'message\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t <script>\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" == \"main_bed_no\")\n\t\t\t\t\t{\n\t\n\t\t\t\tparent.frames[1].document.forms[0].room.value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\tparent.frames[1].document.forms[0].room.disabled = true;\n\n\t\t\t\tvar bedClassOpt\t\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\tbedClassOpt.text\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\tbedClassOpt.value\t= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\tbedClassOpt.selected = true;\n\t\t\t\tparent.frames[1].document.forms[0].bed_class.add(bedClassOpt);\n\t\t\t\tparent.frames[1].document.forms[0].bed_class.disabled = true;\n\n\t\t\t\tvar bedTypeOpt\t\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\tbedTypeOpt.text\t\t= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\tbedTypeOpt.value\t= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\tbedTypeOpt.selected = true;\n\t\t\t\tparent.frames[1].document.forms[0].bed_type.add(bedTypeOpt);\n\t\t\t\tparent.frames[1].document.forms[0].bed_type.disabled = true;\n\t\t\t\tparent.frames[1].document.forms[0].gender_specific_ind.disabled = true;//IN015822\n\t\t\t\tvar spl = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\tif(spl!=\"\")\n\t\t\t\t{\n\t\t\t\tvar specialtyOpt\t\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\tspecialtyOpt.text\t\t= \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\tspecialtyOpt.value\t\t= \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\tspecialtyOpt.selected\t= true;\n\t\t\t\tparent.frames[1].document.forms[0].speciality.add(specialtyOpt);\n\t\t\t\tparent.frames[1].document.forms[0].speciality.disabled = true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tparent.frames[1].document.forms[0].speciality.disabled = true;\n\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar obj= parent.frames[1].document.forms[0]\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'bedclass\').innerText=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'roomno\').innerText=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"\n\t\t\t\t\t\tobj.bed_class.value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\n\t\t\t\t\t\tobj.bed_type.value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\n\t\t\t\t\t\tobj.room_no.value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"\t\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t <script>\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar err_msg=getMessage(\'INVALID_BED\',\'IP\');\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" == \"main_bed_no\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(err_msg);\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].main_bed_no.value = \'\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tbedDetails(err_msg);\n\t\t\t\t\t\t}\n\t\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar err_msg = getMessage(\'CANNOT_BLOCK_PSEUDO_BED\',\'IP\');//\"APP-IP0193 Pseudo bed cannot be blocked. \"\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" == \"main_bed_no\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(err_msg);\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].main_bed_no.value = \'\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tbedDetails(err_msg);\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<script>\n\n\t\tvar obj= parent.frames[1].document.forms[0]\n\t\tobj.from_date.value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"\n\t\t</script>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tvar obj= parent.frames[1].document.forms[0]\n\t\t\t\t\t\t\t\t\t\tobj.until_date.value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\tvar obj= parent.frames[1].document.forms[0]\n\t\t\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"==\"Y\")\n\t\t\t\t\t\t\t\t\t\tobj.override.checked=true\n\t\t\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\t\t\tobj.override.checked=false\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );


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

			request.setCharacterEncoding("UTF-8");
			Connection con = null;
			String facility_id = (String)session.getAttribute("facility_id");
			Statement stmt = null;
			ResultSet rs =null;
			String obj_name		 = request.getParameter("obj_name");
		
            _bw.write(_wl_block8Bytes, _wl_block8);

try
{

	con = ConnectionManager.getConnection(request);

/// Added by SRIDHAR R on 5 OCT 2004...
// if obj_name.equals("main_bed_no").. then it is called from [ BED FOR NURSING UNIT ] FUNCTION ..IP MASTER CODE SET UP...

	if(obj_name.equals("bed_no") || obj_name.equals("main_bed_no") )
	{
		String nursing_unit	= request.getParameter("nursing_unit");
		String bed_no		= request.getParameter("bed_no");
		
		String sql = "select room_no, bed_class_long_desc, bed_class_code, bed_type_code,bed_class_short_desc, BED_TYPE_SHORT_DESC, SPECAILTY_SHORT_DESC, SPECIALTY_CODE from ip_nursing_unit_bed_vw where nursing_unit_code='"+nursing_unit+"' and bed_no='"+bed_no+"' and PSEUDO_BED_YN='N' and facility_id = '"+facility_id+"' ";
		try
		{					
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);
			if(rs!=null)
			{
				if(rs.next())
				{
					 String room_no= rs.getString(1);
					 String bed_class_code=rs.getString(3);
					 String bed_type_code=rs.getString(4);
					 String bed_class_short_desc=rs.getString(5);
					 String bed_type_short_desc=rs.getString("BED_TYPE_SHORT_DESC");
					 String specialty_code=rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
					 String specailty_short_desc=rs.getString("SPECAILTY_SHORT_DESC");
					
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(obj_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bed_class_short_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bed_type_short_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(specailty_short_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bed_class_short_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block23Bytes, _wl_block23);

				}
				else
				{
					sql = "select room_no, bed_class_long_desc, bed_class_code,bed_type_code,bed_class_short_desc from ip_nursing_unit_bed_vw where nursing_unit_code='"+nursing_unit+"' and bed_no='"+bed_no+"' and PSEUDO_BED_YN='Y' and current_status = 'A' ";
					stmt = con.createStatement();
					rs	= stmt.executeQuery(sql);
					
					if(!rs.next())
					{	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(obj_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
	}
					
					else
					{	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(obj_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
	}
						if(stmt!=null)stmt.close();
					if(rs!=null)rs.close();
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch (Exception e)
		{
			out.println(e.toString());
		}
		finally 
		{					
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
		}
	}
	else if(obj_name.equals("remarks"))
	{
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
		java.util.Date dt=new java.util.Date();
		String currDate = dateFormat.format( dt ) ;
		 if(!(currDate==null || currDate.equals("")))
				currDate =  DateUtils.convertDate(currDate,"DMYHM","en",localeName); 
						

		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block29Bytes, _wl_block29);
	}
	else
	{
		if(obj_name.equals("from_date"))
		{
			String from_date = request.getParameter("from_date");
			String from_date1= from_date;
			String block_type_code = request.getParameter("blocking_type_code");
			String sql = "";
			String blocking_hour = "";
			String blocking_unit = "";
						
			//String sql = "select to_char(to_date('"+from_date1+ "','dd/mm/rrrr hh24:mi')+(nvl(bed_block_period_normal,0)/24),'dd/mm/rrrr hh24:mi') from ip_param where facility_id='"+facility_id+"'";

			if(!(block_type_code==null || block_type_code.equals("")))
			{
				sql = "select DFLT_MIN_BLOCK_PERIOD, DFLT_BLOCK_UNITS from IP_BLOCKING_TYPE where  BLOCKING_TYPE_CODE = '"+block_type_code+"'";

				try
					{
						stmt = con.createStatement();
						rs	= stmt.executeQuery(sql);
						if(rs!=null)
						{
							if(rs.next())
							{
								 blocking_hour =  rs.getString("DFLT_MIN_BLOCK_PERIOD");
								 blocking_unit =  rs.getString("DFLT_BLOCK_UNITS");
							}
						}
					}
					catch (Exception e)
					{
						out.println(e.toString());
					}
					finally 
					{					
						if(stmt!=null)	stmt.close();
						if(rs!=null)	rs.close();
					}
			}

			
			
			if(!(block_type_code==null || block_type_code.equals("")) && !(blocking_hour==null || blocking_hour.equals("")) && blocking_unit!=null && blocking_unit.equals("H"))
				sql = "select to_char(to_date('"+from_date1+ "','dd/mm/rrrr hh24:mi')+(nvl(DFLT_MIN_BLOCK_PERIOD,0)/24),'dd/mm/rrrr hh24:mi') from IP_BLOCKING_TYPE where  BLOCKING_TYPE_CODE = '"+block_type_code+"'";
			else if(!(block_type_code==null || block_type_code.equals("")) && !(blocking_hour==null || blocking_hour.equals("")) && blocking_unit!=null && blocking_unit.equals("D"))
				sql = "select to_char(to_date('"+from_date1+ "','dd/mm/rrrr hh24:mi')+(nvl(DFLT_MIN_BLOCK_PERIOD,0)),'dd/mm/rrrr hh24:mi') from IP_BLOCKING_TYPE where  BLOCKING_TYPE_CODE = '"+block_type_code+"'";
			else
				sql = "select to_char(to_date('"+from_date1+ "','dd/mm/rrrr hh24:mi')+(nvl(bed_block_period_normal,0)/24),'dd/mm/rrrr hh24:mi') from ip_param where facility_id='"+facility_id+"'";

				

				StringTokenizer tok1=new StringTokenizer(from_date," ");
				from_date = tok1.nextToken();
				String from_time = tok1.nextToken();

				StringTokenizer tok=new StringTokenizer(from_date,"/");
				String a[]=new String [3];
				for(int i=0;tok.hasMoreTokens();i++)
					a[i]= tok.nextToken();

				tok1=null;
				tok1=new StringTokenizer(from_time,":");
				String a1[]=new String [2];
				for(int i=0;tok1.hasMoreTokens();i++)
					a1[i]= tok1.nextToken();

			//if(userdate.after(currentdate) || userdate.equals(currentdate))
			{
					try
					{
						stmt = con.createStatement();
						rs	= stmt.executeQuery(sql);
						if(rs!=null)
						{
							if(rs.next())
							{
								String until_dt =  rs.getString(1);

								 
								
								 if(!(until_dt==null || until_dt.equals("")))
									until_dt =  DateUtils.convertDate(until_dt,"DMYHM","en",localeName);
																
								
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(until_dt));
            _bw.write(_wl_block31Bytes, _wl_block31);

							}
						}
						if(stmt!=null)stmt.close();
						if(rs!=null)rs.close();
					}
					catch (Exception e)
					{
						out.println(e.toString());
					}
					finally 
					{					
						if(stmt!=null)	stmt.close();
						if(rs!=null)	rs.close();
					}
				}
			}
			else
			{
				String block_type_code = request.getParameter("block_type");
				String sql = "select override_yn  from ip_blocking_type where blocking_type_code='"+block_type_code+"'";
				try
				{
					stmt = con.createStatement();
					rs	= stmt.executeQuery(sql);

					if(rs!=null)
					{
						if(rs.next())
						{
							 String override_yn= rs.getString(1);
							
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(override_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);

						}
					}
					if(stmt!=null)stmt.close();
					if(rs!=null)rs.close();
				}
				catch (Exception e)
				{
					out.println(e.toString());
				}
				finally 
				{					
					if(stmt!=null)	stmt.close();
					if(rs!=null)	rs.close();
				}
			}
	}
}catch (Exception e)
	{
			
			e.printStackTrace();
	}
	finally 
	{
		if(con != null)ConnectionManager.returnConnection(con,request);	
	}	

            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
