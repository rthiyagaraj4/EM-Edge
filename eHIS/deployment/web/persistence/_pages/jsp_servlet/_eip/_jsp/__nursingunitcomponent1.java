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

public final class __nursingunitcomponent1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/NursingUnitComponent1.jsp", 1709117806087L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="<select name=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" id=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" width=\"15\" onChange=\'popDynamicValues(this)\'><option value=\'\' selected>--- ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ---\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<OPTION VALUE=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</select>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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


request.setCharacterEncoding("UTF-8");
Connection con =null;
Statement  stmt=null;
ResultSet  rs =null;
String	   operstn = "";

Statement stmt1=null;
ResultSet rs1 =null;

Statement stmt2=null;
ResultSet rs2 =null;

String classcode = "";
String classname = "";

try
{ 
	con = ConnectionManager.getConnection(request);
	String facilityID=(String)session.getValue("facility_id");
	String loginUser = (String)session.getValue("login_user");
	String wherecondn = request.getParameter("wherecondn");
	String pract_id="";
	if(wherecondn == null) wherecondn ="";
	
	/////*-Modified on 27th Sept 2002-*/

	if(wherecondn.equals("revise_booking_yn"))
	{
		pract_id = request.getParameter("pract_id");
		if(pract_id == null || pract_id.equals("null"))pract_id="";
	}

	String operSql = " select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b 	   "+
	" where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   "+
	" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   "+
	" and trunc(sysdate) between b.eff_date_from and 			   "+
	" nvl(b.eff_date_to,trunc(sysdate)) ";
	stmt1 = con.createStatement();
	rs1 = stmt1.executeQuery(operSql);
	
	if(rs1!=null)
	{
		while(rs1.next())
		{
			operstn	 = rs1.getString("oper_stn_id");
				if(operstn == null) operstn ="";
		}
	}
	if(rs1!=null)rs1.close();
	if(stmt1!=null)stmt1.close();
	
	String name= request.getParameter("attribute");
	if(name==null)
	name = "nursing_unit";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(name));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(name));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
	
	       	stmt = con.createStatement();
	       	
	       	if(wherecondn.equals(""))
	       	{ 
	       	
 				String sql1="Select short_desc,nursing_unit_code  from ip_nursing_unit where facility_id='"+facilityID+"' and locn_type =  'N'  and eff_status='E' order by short_desc ";
	      		rs = stmt.executeQuery(sql1);
	      
	      	    if( rs != null )
	      	    {
	      	         while( rs.next() )
	      	         {
	      				classcode = rs.getString( "nursing_unit_code" ) ;
	      				classname = rs.getString( "short_desc" ) ;
						
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( classcode ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( classname));

					}
	      		}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
	      	}
	      	else
	      	{
				String sql2=" Select 1 from ip_nursing_unit a,      "+
			     " am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' 	   "+
			     " and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
			     " and a.locn_type=b.locn_type and b.locn_type =  'N' and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
			     " and b."+wherecondn+"='Y'order by a.short_desc";
				
				rs = stmt.executeQuery(sql2);			
		
				if( rs != null )
				{
					if(rs.next())
					{      	
						String sql1="";

						if(wherecondn.equals("revise_booking_yn"))
						{
							sql1="Select nursing_unit_code , nursing_unit_short_desc short_desc from IP_NURSING_UNIT_FOR_PRACT_VW where PRACTITIONER_ID='"+pract_id+"' and facility_id='"+facilityID+"'";	
						}
						else
						{

							sql1=" Select a.short_desc short_desc,a.nursing_unit_code nursing_unit_code from ip_nursing_unit a,      "+
							" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' 	   "+
							" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type =  'N' "+
							" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
							" and b."+wherecondn+"='Y' order by a.short_desc";		
						}
	      		
						rs2 = stmt.executeQuery(sql1);			
	      				if( rs2 != null )
	      				{
	       		   			while( rs2.next() )
	          				{
								classcode = rs2.getString( "nursing_unit_code" ) ;
								classname = rs2.getString( "short_desc" ) ;
								
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( classcode ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( classname));
	
							}
	      				}
							if(rs2!=null) rs2.close();
							if(stmt2!=null) stmt2.close();
	      			}
			}
		}//e.o.Else
	        
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();


}catch(Exception e)	{out.println(e);}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block12Bytes, _wl_block12);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
