package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyopspractitioner extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addModifyOPSPractitioner.jsp", 1709113965676L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eAM/js/OPSPractitioner.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t</head>\n\n\t<body  OnMouseDown=\"CodeArrest()\" onLoad=\"Focusing(\'pract\')\" onKeyDown = \'lockKey()\'>\n\t\t<form name=\'facility_form\' id=\'facility_form\' action=\'../../servlet/eAM.OPSPServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t<div>\n\t\t\t<br><br><br><br><br><br><br><br><br><br><br><br>\n\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'auto\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t     <td   class=\'label\'><!--width=\'40%\'--><fmt:message key=\"Common.practitioner.label\" bundle=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/></td>\n    \t\t\t\t     <td cc><!-- width=\'60%\' colspan=\'2\'-->&nbsp;&nbsp;\n    \t\t\t\t     ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    \t\t\t\t     <select name=\'pract\' id=\'pract\'>\n    \t\t\t\t     <option value=\'\'>----------<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/>---------</option>\n\n    \t\t\t\t       ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    \t\t\t\t    \t </select>\n    \t\t\t\t    \t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<img src=\'../../eCommon/images/mandatory.gif\'></img>\n    \t\t\t\t   </td>\n    \t\t\t\t   <td>&nbsp;</td>\n    \t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t\t<td>&nbsp;</td>\n    \t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t     <td  class=\'label\'><!--width=\'40%\'--><fmt:message key=\"Common.speciality.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/></td>\n    \t\t\t\t     <td class=\'fields\'><!--width=\'60%\' colspan=\'2\'-->&nbsp;&nbsp;\n\n    \t\t\t\t      ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n    \t\t\t\t   \t<select name=\'splty_code\' id=\'splty_code\'>\n    \t\t\t\t   \t<option value=\'\'>----------<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>---------</option>\n\n    \t\t\t\t    \t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    \t\t\t\t    \t <img src=\'../../eCommon/images/mandatory.gif\'>\n    \t\t\t\t     </td>\n    \t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t\t<td>&nbsp;</td>\n    \t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\n  \t\t\t</table>\n\t\t</div>\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String dat="";
	String facility="";
	String pract="";
	String en="";
	String fnval="insert";
	String id="";
	//String fname="";
	String prname="";
	//String ps="";
	//SimpleDateFormat formatter=null;
	String fid=(String)session.getValue("facility_id") ;
	String spcode="";
	String spname="";

	facility=request.getParameter("practitioner_id");
	pract=request.getParameter("speciality_id");
	try
	{
		con = ConnectionManager.getConnection(request);

	if(facility!=null )
	{
		fnval="modify";
		pstmt=con.prepareStatement("select am_practitioner.practitioner_name,am_pract_specialities.practitioner_id,am_pract_specialities.speciality_code,am_speciality.short_desc from am_practitioner,am_pract_for_facility, am_pract_specialities,am_speciality where am_pract_specialities.practitioner_id=am_pract_for_facility.practitioner_id and am_practitioner.practitioner_id=am_pract_for_facility.practitioner_id and am_speciality.speciality_code=am_pract_specialities.speciality_code and am_pract_specialities.facility_id=am_pract_for_facility.facility_id and am_pract_specialities.speciality_code=? and am_pract_specialities.practitioner_id=?");

		pstmt.setString(1,pract);
		pstmt.setString(2,facility);
		rset=pstmt.executeQuery();
		if(rset.next())
		{
		pract=rset.getString("Practitioner_id");
		prname=rset.getString("practitioner_name");
		spcode=rset.getString("speciality_code");
		spname=rset.getString("short_desc");

		}
 	}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
if(fnval.equals("modify"))
    				     {
    				     	out.println("<input type='text' name='t' id='t' value='"+prname+"' readonly>");
    				     	out.println("<input type='hidden' name='pract1' id='pract1' value='"+pract+"'>");
    				     }
    				     else{
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

     				    		if(rset!=null)rset.close();
						        if(pstmt!=null)pstmt.close();
						   
						        stmt=con.createStatement();
    				    		rset=stmt.executeQuery("select am_practitioner.practitioner_name,am_practitioner.practitioner_id from am_pract_for_facility, am_practitioner where  am_practitioner.practitioner_id =am_pract_for_facility.practitioner_id and am_pract_for_facility.facility_id='"+fid+"' and (trunc(sysdate) between nvl(trunc(am_pract_for_facility.eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(am_pract_for_facility.eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) and am_practitioner.eff_status='E'  order by am_practitioner.practitioner_name") ;
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat=rset.getString("practitioner_name");
    				    			id=rset.getString("practitioner_id");
    				    				out.println("<option value='"+id+ "' "+en +">"+dat);
    				    		   }
    				    		}
            _bw.write(_wl_block8Bytes, _wl_block8);
out.print("");}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
if(fnval.equals("modify"))
				        {
				       		out.println("<input type='text' name='p' id='p' value='"+spname+"' readonly>");
				       		out.println("<input type='hidden' name='splty_code1' id='splty_code1' value='"+spcode+"'>");
				        }
    				     else{
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);

    				    	  if(rset!=null)rset.close();
							   if(stmt!=null)stmt.close();

							    stmt=con.createStatement();
    				    		rset=stmt.executeQuery("select short_desc,speciality_code from am_speciality where eff_status='E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_desc");
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    		   dat=rset.getString("short_desc");
    				    		   id=rset.getString("speciality_code");
    				    		   if(id.equals(pract))
    				    		   	en="selected";
    				    		    else
    				    			en="";

    				    		 out.println("<option value='"+id+ "' "+en+">"+dat);

    				    		   }
    				    		}
    				    	 	out.print("</select>");
    				    	 	}
    				    	 }
    				    	  catch(Exception e){e.printStackTrace();}
    				    	  finally
    				    	  {
    				    	  if(rset!=null)	rset.close();
							  if(stmt!=null)	stmt.close();
    				    	  if(pstmt!=null)	pstmt.close();
    				    	  
    				    	  	ConnectionManager.returnConnection(con,request);

    				    	  }
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
