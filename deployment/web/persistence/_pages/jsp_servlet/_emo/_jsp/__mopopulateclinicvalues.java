package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __mopopulateclinicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOPopulateClinicValues.jsp", 1709118413556L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\n\t\t\t <script> \n\t\t\t    var obj\t\t= parent.frames[1].document.forms[0].clinic_code1;\n\t\t\t    var length\t= obj.length;\n\t\t\t    for(i=0;i<length;i++)\n\t\t\t\t    obj.remove(1);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t         opt\t\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t     opt.text\t= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t     opt.value\t= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t parent.frames[1].document.forms[0].clinic_code1.add(opt);\n\t\t\t\t\t if(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"==\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\")\n\t\t             opt.selected= true;\n                </script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script> \n\t\t\t\tvar obj=parent.frames[1].document.forms[0].clinic_code1;\n\t\t\t    var length = obj.length;\n\t\t\t    for(i=0;i<length;i++)\n\t\t\t\t    obj.remove(1);\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\t    //parent.frames[1].frames[0].location.reload();\n\t\t\t\t//parent.frames[1].frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t// Modified against - PAS-MO-Deceased Registration [IN:045484] by Lenin \t\t\n\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\tparent.frames[1].location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t//[IN:045484] ends\n\t\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script>\n\t\t\t         opt=parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t     opt.text=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t     opt.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\")\n\t\t             opt.selected=true;\n                </script>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].clinic_code1.focus();\n\t\t\t\t\treturn false;\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

	
	Statement stmt					= null;
	ResultSet rs					= null;
	Connection con					= null;
	StringBuffer sql				= new StringBuffer();
	request.setCharacterEncoding("UTF-8");
	String clinic_typ				= request.getParameter("clinic_code");
	String clinic_code1				= request.getParameter("clinic_code1");
	String care_ind					= request.getParameter("care_ind");
	String facility_id				= (String)session.getValue("facility_id");
	String clinic_type				= "";
	String age_group				= "";
	String department				= "";
	String dept_code				= "";
	String nursing_unit_short_desc	= "";
	String short_desc				= "";
    String sStyle	                =   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	try{
		    con = ConnectionManager.getConnection(request);
			
			if(clinic_typ.equals("N"))
		    {
		         sql.append("select NURSING_UNIT_CODE,short_desc from  ip_nursing_unit_lang_vw where language_id='"+localeName+"' and eff_status='E' order by 2");
		         stmt	= con.createStatement();
			     rs		= stmt.executeQuery(sql.toString()) ;
            _bw.write(_wl_block6Bytes, _wl_block6);
	if(rs!=null)
				{
					while (rs.next())
					{			
						 clinic_type	= rs.getString(1);	
						 if(clinic_type==null) clinic_type="";
				 
						 short_desc		= rs.getString(2);
						 if(short_desc==null) short_desc="";
				 	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
				}
				if(rs != null) rs.close();
				sql.setLength(0);
		   }else
		   {
			
			stmt			= con.createStatement();
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body>");
				
			StringBuffer sql_check = new StringBuffer();
			
			sql_check.append("Select count(*) from op_clinic ");
			sql_check.append("where upper(care_locn_type_ind)=upper('"+care_ind+"') and ");
			sql_check.append("facility_id='"+facility_id+"' and eff_status = 'E' ");
			
			
			ResultSet rs_check	=stmt.executeQuery(sql_check.toString());
			rs_check.next();
			int count			=rs_check.getInt(1);
			
			if(rs_check != null) rs_check.close();
		 
		    sql_check.setLength(0);
			
			
            _bw.write(_wl_block12Bytes, _wl_block12);
	if(count==0) 
			{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
			else
			{
			 sql.append("Select clinic_code, short_desc from op_clinic_lang_vw where (care_locn_type_ind='"+care_ind+"') and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+clinic_typ+"') and facility_id='"+facility_id+"' and language_id = '"+localeName+"' and eff_status='E' order by 2");
		
			 rs = stmt.executeQuery(sql.toString()) ;

			 if(rs!=null)
				{
					while (rs.next())
					{			
						 clinic_type = rs.getString(1);	
						 if(clinic_type==null) clinic_type="";
				 
						 short_desc = rs.getString(2);
						 if(short_desc==null) short_desc="";
				 	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block16Bytes, _wl_block16);
	}
				}
				if(rs != null) rs.close();
				sql.setLength(0);

		    sql.append("SELECT CARE_LOCN_DESC,AGE_GROUP_DESC,DEPT_DESC,SERVICE_DESC, SPECIALITY_DESC,DEPT_CODE  FROM OP_CLINIC_VW WHERE clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+care_ind+"' and facility_id='"+facility_id+"' ");
            
			rs = stmt.executeQuery(sql.toString()) ;
			if(rs!=null)
			{
			while (rs.next())
				{			
                   		 clinic_type		= rs.getString(1);	
						 if(clinic_type==null) clinic_type="";
						 age_group			= rs.getString(2);
						 if(age_group==null) age_group="";
						 department			= rs.getString(3);	
						 if(department==null) department="";
						 nursing_unit_short_desc=rs.getString(5);
					     if(nursing_unit_short_desc==null) nursing_unit_short_desc="";
						 dept_code			= rs.getString(6);
						 if (dept_code==null) dept_code = "";
						 nursing_unit_short_desc = java.net.URLEncoder.encode(nursing_unit_short_desc);
				}
			}
			else
			{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
		}
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
        sql.setLength(0);
		   }
	}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		

            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
