package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __chartapplicabilityaddmodifyintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartApplicabilityaddModifyIntermediate.jsp", 1709115646918L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"JavaScript\" src =\"../../eCA/js/ChartApplicability.js\"></script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\tvar returnArray;\n\t\t</SCRIPT>\n\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n\t<form name=\"chartApplicabilityIntermediateForm\" id=\"chartApplicabilityIntermediateForm\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\t\tretArray = callFunction(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\",\"Specialty\",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc)\n\t\t\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc.value = retArray[1];\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyCode.value = retArray[0];\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc.value = \'ALL\';\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyCode.value = \'*ALL\';\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<script>\n\t\t retArray = callFunction(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"Practitioner Type\",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc)\n\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc.value = retArray[1];\n\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeCode.value = retArray[0];\n\t\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc.value = \'ALL\';\n\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeCode.value = \'*A\';\n\t\t\t\t\n\t\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"Location\",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc)\n\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc.value = retArray[1];\n\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationCode.value = retArray[0];\n\t\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc.value = \'ALL\';\n\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationCode.value = \'*ALL\';\n\t\t\t\t\n\t\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"Age  Group\",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc)\n\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc.value = retArray[1];\n\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpCode.value = retArray[0];\n\t\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc.value = \'ALL\';\n\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpCode.value = \'*ALL\';\n\t\t\t\t\n\t\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"Chart\",parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc)\n\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc.value = retArray[1];\n\t\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartCode.value = retArray[0];\n\t\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc.value = \'\';\n\t\t\t\tparent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartCode.value = \'\';\n\t\t\t\t\n\t\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</form>\n\t</body>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
    String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);


	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String description = "";
	String sql = "";
	int count = 0;
	try
	{
		String textName = "";
		con = ConnectionManager.getConnection(request);
		textName = request.getParameter("textName") == null ? "" : request.getParameter("textName");
		if(textName.equals("specialty"))
		{
			description = request.getParameter("specialty") == null ? "" : request.getParameter("specialty");
			sql = "SELECT  speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(short_desc) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.specialtyCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				sql = "SELECT  speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((sql)));
            _bw.write(_wl_block10Bytes, _wl_block10);
	if(rs != null) rs.close();
				if(ps != null) ps.close();}
		}
		if(textName.equals("practType"))
		{
			description = request.getParameter("practType") == null ? "" : request.getParameter("practType");
			sql = "SELECT PRACT_TYPE,DESC_SYSDEF  FROM am_pract_type where eff_status='E' and upper(DESC_SYSDEF) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.practTypeCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				sql = "SELECT PRACT_TYPE code,  DESC_SYSDEF description FROM am_pract_type where eff_status='E'  and upper(PRACT_TYPE) like upper(?) and upper(DESC_SYSDEF) like upper(?) order by 2 ";
			

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block12Bytes, _wl_block12);
		if(rs != null) rs.close();
		if(ps != null) ps.close();
			}
		}	
		if(textName.equals("location"))
		{
			description = request.getParameter("location") == null ? "" : request.getParameter("location");
			String tableName = request.getParameter("tableName") == null ? "" : request.getParameter("tableName");
			if(tableName.equals("OP_CLINIC"))
			{
				sql = "select CLINIC_CODE, SHORT_DESC from op_clinic where EFF_STATUS='E' and upper(SHORT_DESC) like upper(?) order by 2";
			}
			if(tableName.equals("IP_NURSING_UNIT"))
			{
				sql = "select NURSING_UNIT_CODE, SHORT_DESC from IP_NURSING_UNIT where EFF_STATUS='E' and upper(SHORT_DESC) like upper(?) order by 2";
			}
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.locationCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				
			if(tableName.equals("OP_CLINIC"))
				{
					sql = "select CLINIC_CODE code, SHORT_DESC description from op_clinic where EFF_STATUS='E' and upper(CLINIC_CODE) like upper(?)  and upper(SHORT_DESC) like (?) order by 2";
				}
				else
				{
					sql = "select NURSING_UNIT_CODE code, SHORT_DESC description from ip_nursing_unit where EFF_STATUS='E' and upper(NURSING_UNIT_CODE) like upper(?)  and upper(SHORT_DESC) like (?) order by 2";
				}

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block13Bytes, _wl_block13);
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			
		}
		if(textName.equals("ageGrp"))
			{
			description = request.getParameter("ageGrpCode") == null ? "" : request.getParameter("ageGrpCode");
			sql = "Select AGE_GROUP_CODE, SHORT_DESC from am_age_group where eff_status='E' and upper(SHORT_DESC) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}

			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.ageGrpCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
		if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				sql = "Select AGE_GROUP_CODE code, SHORT_DESC description from am_age_group where eff_status='E' and upper(AGE_GROUP_CODE) like upper(?)  and upper(SHORT_DESC) like upper(?) order by 2";
			

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block14Bytes, _wl_block14);
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			
		}
		if(textName.equals("chart"))
			{
			description = request.getParameter("chartCode") == null ? "" : request.getParameter("chartCode");
			sql = "Select CHART_ID, SHORT_DESC from ca_chart where eff_status='E' and upper(SHORT_DESC) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
				
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartDesc.value='"+rs.getString(2)+"' ");
				out.println("parent.f_query_add_mod.document.chartApplicabilityaddmodifyForm.chartCode.value='"+rs.getString(1)+"' ");
				}
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			}
			if(count == 0 || count > 1)
			{
				sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E'  and upper(CHART_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
			

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block15Bytes, _wl_block15);
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			
		}
		

            _bw.write(_wl_block1Bytes, _wl_block1);

	}
	catch(Exception ee)
	{
		//out.println("Exception in ChartAddModify Intermediate Module "+ee.toString());//common-icn-0181
                 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}


            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
