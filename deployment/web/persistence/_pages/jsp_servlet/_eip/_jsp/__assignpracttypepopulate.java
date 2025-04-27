package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;

public final class __assignpracttypepopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/assignPractTypePopulate.jsp", 1709117710988L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\t\n<html><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</HEAD><body CLASS=\'MESSAGE\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"><form name=\'practtype\' id=\'practtype\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\t\t\t\t<script>\n\t\t\t\t\t\tvar element = parent.document.frames[1].document.frames[1].document.createElement(\'OPTION\');\n\t\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\t\telement.value= \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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

	request.setCharacterEncoding("UTF-8"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String strRole		= request.getParameter("role");	
	String strPractitionerId				= request.getParameter("pract_id");
	StringBuffer strSql = new StringBuffer();
	Connection con 		= null;
	PreparedStatement stmtPractType = null;
	ResultSet rsPractType	= null;
	String ID		= "";
	String dat		= "";

if(strRole.equals("med"))
{
	strSql.append(" SELECT a.short_desc short_desc ,a.team_id teamid FROM am_medical_team a,am_pract_for_team b WHERE a.facility_id ='C1' AND a.facility_id = b.facility_id AND b.practitioner_id ='"+strPractitionerId+"' AND b.team_id=a.team_id AND a.appl_for_ip_yn = 'Y' ORDER BY 1 ");
}
if(strRole.equals("2"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MD','SG','DN','PS','AN') order by 1 ");
}
if(strRole.equals("3"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MD','SG','DN','PS','AN','RD','PT','PL') order by 1 ");
}
if(strRole.equals("4"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MD','SG','DN','PS','AN','RD','PT') order by 1 ");
}
if(strRole.equals("5"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MD','SG','DN','PS','AN') order by 1 ");
}
if(strRole.equals("6"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('TH','PH','DT','SW','PL') order by 1 ");
}
if(strRole.equals("7"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('SG') order by 1 ");
}
if(strRole.equals("8"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('MW','NS') order by 1 ");
}
if(strRole.equals("9"))
{
	strSql.append("SELECT desc_userdef,pract_type from am_pract_type where eff_status='E' and pract_type in ('TR','TN') order by 1 ");
}
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	try
	{
		con = ConnectionManager.getConnection(request);
		stmtPractType =con.prepareStatement(strSql.toString());
		rsPractType = stmtPractType.executeQuery();
		if(rsPractType!=null)
			{
				while(rsPractType.next())
				{
					
					if(strRole.equals("med"))	
					{
						dat=rsPractType.getString("short_desc");
						ID  = rsPractType.getString(2);
					}
					else
					{
						dat=rsPractType.getString("desc_userdef");
						ID  = rsPractType.getString("pract_type");
					}
					

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(dat));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block6Bytes, _wl_block6);

					if(strRole.equals("med"))	
					{
							out.println("<script>parent.document.frames[1].document.frames[1].document.CompleteVisit_form.medical_team.add(element);</script>");	 
					}
					else
					{
						out.println("<script>parent.document.frames[1].document.frames[1].document.forms[0].pract_type.add(element);</script>");	 
					}
				}
	if(rsPractType !=null) rsPractType.close(); if(stmtPractType != null) stmtPractType.close();
			}


	}catch(Exception e){
		//out.print(e);
		e.printStackTrace();
	}
	finally{
	 ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
