package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;

public final class __fetchvalfornursingunitbed extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FetchValForNursingUnitBed.jsp", 1709117758147L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body class=\'message\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar selected = parent.frames[1].document.forms[0].bed_class;\n\t\t\t\t\twhile ( selected.options.length > 0 )\n\t\t\t\t\t\tselected.remove(selected.options[0]);\n\t\t\t\t\tvar opt=document.createElement(\"Option\");\n\t\t\t\t\topt.text=\"--- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" ---\";\n\t\t\t\t\topt.value=\"\";\n\t\t\t\t\tparent.frames[1].document.forms[0].bed_class.add(opt);\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar obj=parent.frames[1].document.forms[0].bed_class\n\t\t\t\t\tvar element=parent.frames[1].document.createElement(\"option\");\n\t\t\t\t\telement.text=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"\n\t\t\t\t\telement.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\n\t\t\t\t\tobj.add(element)\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t<script>\n\t\t\tvar mainBedNo = parent.frames[1].document.forms[0].main_bed_no\n\t\t\tif(mainBedNo)\n\t\t\t{\n\t\t\t\tparent.frames[1].document.forms[0].main_bed_no.disabled = false;\n\t\t\t\tparent.frames[1].document.forms[0].search_bed.disabled\t= false;\n\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t\t<script>\n\t\t\tif(parent.frames[1].document.forms[0].main_bed_no)\n\t\t\t{\n\t\t\t\tparent.frames[1].document.forms[0].main_bed_no.disabled = true;\n\t\t\t\tparent.frames[1].document.forms[0].search_bed.disabled\t= true;\n\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar gender_object=parent.f_query_add_mod.Nursing_Unit_Bed.gender_specific_ind\n\t\t\t\t\t\t\t\tfor(var i=0;i<gender_object.options.length;i++)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tif(gender_object.options[i].value == \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\n\t\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].gender_specific_ind_code.value!=gender_object.value)\n\t\t\t\t\t\t\t\t\t\t\tparent.f_query_add_mod.forms[0].gender_specific_ind_code.value=gender_object.value\n\t\t\t\t\t\t\t\t\t\tif(gender_object.value==\"\")\n\t\t\t\t\t\t\t\t\t\t\tgender_object.options[i].selected=true\n\t\t\t\t\t\t\t\t\t\tgender_object.disabled=true;\n\t\t\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar obj = parent.f_query_add_mod.document.Nursing_Unit_Bed.room\n\t\t\t\t\t\tvar element=parent.f_query_add_mod.document.createElement(\"option\");\n\t\t\t\t\t\telement.text=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\telement.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.Nursing_Unit_Bed.hdd_room.value == \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\telement.selected = true;\n\t\t\t\t\t\t\tobj.disabled = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\tobj.add(element)\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"==\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\n\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\tobj.add(element)\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar obj=\t\tparent.f_query_add_mod.document.Nursing_Unit_Bed.bed_class\n\t\t\t\t\tvar element=parent.f_query_add_mod.document.createElement(\"option\");\n\t\t\t\t\telement.text=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"\n\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].hdd_bed_class.value==\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\")\n\t\t\t\t\t{\t\n\t\t\t\t\t\telement.selected = true;\n\t\t\t\t\t\tobj.disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t\tobj.add(element)\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar obj=\t\tparent.f_query_add_mod.document.Nursing_Unit_Bed.bed_type\n\t\t\t\t\t\tvar element=parent.f_query_add_mod.document.createElement(\"option\");\n\t\t\t\t\t\telement.text=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"\n\t\t\t\t\t\telement.value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.forms[0].hdd_bed_type.value==\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\")\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\telement.selected = true;\n\t\t\t\t\t\t\tobj.disabled = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tobj.add(element)\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar obj=\t\tparent.f_query_add_mod.document.Nursing_Unit_Bed.speciality\n\t\t\t\t\t\tvar element=parent.f_query_add_mod.document.createElement(\"option\");\n\t\t\t\t\t\telement.text=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"\n\t\t\t\t\t\tif(parent.f_query_add_mod.document.Nursing_Unit_Bed.hdd_speciality_code.value == \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\")\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\telement.selected = true;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tobj.disabled = true;\n\t\t\t\t\t\tobj.add(element)\n\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\")\n\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\tobj.add(element)\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\n\n\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\")\n\t\t\t\t\t\t\telement.selected=true;\n\t\t\t\t\t\tobj.add(element)\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


request.setCharacterEncoding("UTF-8"); 
Connection con	= null;
Statement stmt	= null;
ResultSet rs	= null;
String calling_object = "";

String facility_id		= (String)session.getValue("facility_id");
String calling_from	= request.getParameter("calling_from");
	if(calling_from==null) calling_from="";

calling_object	= request.getParameter("object_name");

String param_val		= request.getParameter("object_val");
String other_code		= request.getParameter("other_code");
	if(other_code==null)	other_code="";
String room_no	= request.getParameter("room_no");
	if(room_no==null) room_no="";

            _bw.write(_wl_block4Bytes, _wl_block4);

try
{

	con = ConnectionManager.getConnection(request);

	if(calling_object.equals("nursing_unit") || calling_from.equals("MAINBED") )
	{
		String sql_gender	  ="select gender from am_age_group where  age_group_code=(select age_group_code from ip_nursing_unit where facility_id='"+facility_id+"' and nursing_unit_code='"+param_val+"') order by 1 ";
		String gender="";

		String sql_room	="select room_no from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+param_val+"' and eff_status='E' order by 1 ";

		String appl_patient_class="";
		

		String  pateint_class="SELECT appl_patient_class  FROM ip_nursing_unit  WHERE facility_id = '"+facility_id+"' AND nursing_unit_code = '"+param_val+"' AND eff_status = 'E'";
		try{
			stmt= con.createStatement();
			if(rs!=null) rs=null;
			rs	= stmt.executeQuery(pateint_class);
			if(rs!=null)
			{
				while(rs.next())
				{
						appl_patient_class=rs.getString(1);
				}

			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		if(appl_patient_class.equals("DC"))
			{

	 sql_room="SELECT room_no   FROM ip_nursing_unit_room  WHERE nursing_unit_code = '"+param_val+"'     AND (facility_id, room_no) IN ( SELECT facility_id, practitioner_id FROM op_pract_for_clinic a  WHERE clinic_code IN (SELECT clinic_code       FROM ip_dc_unit_for_nurs_unit  WHERE facility_id =  '"+facility_id+"'  AND nursing_unit_code = '"+param_val+"')   AND a.facility_id =  '"+facility_id+"'    AND a.resource_class = 'R' AND a.eff_status = 'E') ";

		}
	

		String sql_speciality	="select specialty_code, specialty_short_desc from ip_nurs_unit_for_specialty_vw where facility_id='"+facility_id+"' and nursing_unit_code='"+param_val+"' order by specialty_short_desc";
		
		String new_born_yn = "N";
		String sql_New_Born = "select ALLOW_NEW_BORN_REGN_YN from IP_NURSING_UNIT where NURSING_UNIT_CODE = '"+param_val+"' and facility_id='"+facility_id+"' ";

	if(calling_object.equals("nursing_unit"))	
	{
		String sql_bed_class ="select bed_class_code, short_desc from ip_bed_class where eff_status='E' order by short_desc";
											
		try
		{
			stmt= con.createStatement();
			if(rs!=null) rs=null;
			rs	= stmt.executeQuery(sql_bed_class);
	
			
			if(rs!=null)
			{
			
            _bw.write(_wl_block5Bytes, _wl_block5);

				while(rs.next())
				{	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block8Bytes, _wl_block8);
	}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print(":"+e);
		}
		}

	try
	{
		stmt= con.createStatement();
		rs	= stmt.executeQuery(sql_New_Born);
		if(rs!=null)
		{
			while(rs.next())
			{
				new_born_yn = rs.getString("ALLOW_NEW_BORN_REGN_YN");
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		if(new_born_yn.equals("Y"))
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else if(new_born_yn.equals("N"))
		{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
	
		}
	}catch(Exception e)
	{
		out.print("New Born : "+e);
	}


		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_gender);
			if(rs!=null)
			{
				if(rs.next())
				{
					gender=rs.getString(1);
					if(gender!=null)
					{
						if(gender.equals("M") || gender.equals("F") || gender.equals("U"))
						{	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block12Bytes, _wl_block12);

						}
					}
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print("gender:"+e);					
		}

		/* ROOM population */
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_room);
			
			if(calling_from.equals("MAINBED"))
			{
				if(rs!=null)
				{
					while(rs.next())
					{	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
	}
				}
				
			}
			else
			{
				if(rs!=null)
				{
					while(rs.next())
					{	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
				}
			}
			if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();

		}
		catch(Exception e)
		{
			out.print("room:"+e);
		}

	if(calling_from.equals("MAINBED"))
	{
		/// Added on 15 SEP 2004 by SRIDHAR R ...
		/// **** BED CLASS ******
		String bed_class_sql = "select short_desc, bed_class_code from ip_bed_class where eff_status='E' order by short_desc";
											
		try
		{
			stmt= con.createStatement();
			rs	= stmt.executeQuery(bed_class_sql);
			
			if(rs!=null)
			{
				while(rs.next())
				{	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block22Bytes, _wl_block22);
	}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print(":"+e);
		}

		/// Added on 15 SEP 2004 by SRIDHAR R ...
		// BED TYPE 	
		String bed_class_code	= request.getParameter("bed_class_code");
			if(bed_class_code == null) bed_class_code = "";

		String sql_bed_type	="select short_desc, bed_type_code from ip_bed_type where bed_class_code='"+bed_class_code+"' and eff_status='E' order by short_desc";
		try
		{
			stmt=con.createStatement();
			rs=	stmt.executeQuery(sql_bed_type);
			if(rs!=null)
			{
				while(rs.next())
				{	
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block26Bytes, _wl_block26);
	}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print(":"+e);
		}
		finally
		{
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
		}
	}
		/// Added on 15 SEP 2004 by SRIDHAR R ...
		// SPECIALTY 
		try
		{
			stmt=con.createStatement();
			rs=	stmt.executeQuery(sql_speciality);
			
			if(calling_from.equals("MAINBED"))
			{
				if(rs!=null)
				{
					while(rs.next())
					{	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block29Bytes, _wl_block29);
	}
				}
				
			}
			else
			{
				if(rs!=null)
				{
					while(rs.next())
					{	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(other_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block31Bytes, _wl_block31);
	}
				}
			}
			if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print(":"+e);
		}

		/// Added on 15 SEP 2004 by SRIDHAR R for Main Bed No...
		/// If New_Born indicator is 'Y' in ip_nursing_unit table for that nursing_unit then, Main Bed No can be entered...else disabled
		finally
		{
			if(stmt!=null)	stmt.close();
			if(rs!=null)		rs.close();
		}
	} //end of calling_object.equals("nursing_unit")
	else if(calling_object.equals("bed_class"))
	{
		String sql_bed_type	="select short_desc, bed_type_code from ip_bed_type where bed_class_code='"+param_val+"' and eff_status='E' order by short_desc";
		try
		{
			stmt=con.createStatement();
			rs=	stmt.executeQuery(sql_bed_type);
			if(rs!=null)
			{
				while(rs.next())
				{
					
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(other_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block33Bytes, _wl_block33);

				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			out.print("Error : "+e);
		}
		finally
		{
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
		}
	} // end of if calling_object.equals("bed_class")
}catch(Exception e)
{
	out.println("<script>alert('Error in intermediate page')</script>");
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
