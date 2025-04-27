package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __qpvresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/QPVresult.jsp", 1723183648783L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n    <!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<!--\t\t<script>parent.frames[0].document.forms[0].search_button.disabled=false;</script>\n\t\t<!--//;-->\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<iframe name=\'pline_frame\' id=\'pline_frame\' src=\"../../eCommon/html/blank.html\" frameborder=0 scrolling=\'no\' noresize style=\'height:25vh;width:100vw\'></iframe>\n    <iframe name=\'result_frame\' id=\'result_frame\' src=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" frameborder=0 noresize style=\'height:65vh;width:100vw\'></iframe>\n\n<form>\n<input type=\'hidden\' name=\'params1\' id=\'params1\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n</form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

    String url1 = "../../eOP/jsp/QPVpline.jsp?" ;
    String url2 = "../../eCommon/html/blank.html" ;
    String blnk = request.getParameter("blnk") ;
    
    if(blnk.equals("N")) {

    String openEpisode = request.getParameter("openEpisode");
    if(openEpisode == null) openEpisode="";
  
    String patid=request.getParameter("patid");
    String mrnno=request.getParameter("mrnno");
    String dtfrm=request.getParameter("dtfrm");
    String dtto=request.getParameter("dtto");
    String serv=request.getParameter("serv");
    String loc=request.getParameter("loc");
    String pract=request.getParameter("pract");
    String srch=request.getParameter("srch");
	//String Facility_Id = (String) session.getValue("facility_id");
	
	String episode_id=request.getParameter("episode_id");
	
	String service_code = request.getParameter("service_code");
	//String episode_no = request.getParameter("episode_no");
	String user_id = request.getParameter("user_id");
	String speciality_id = request.getParameter("speciality_id");
	
	//if(episode_no==null) episode_no="";
	if(user_id==null) user_id="";
	if(speciality_id==null) speciality_id="";
	if(mrnno==null) mrnno="";
	if(dtfrm==null) dtfrm="";
	if(dtto==null) dtto="";
	if(serv==null) serv="";
	if(loc==null) loc="";
	if(pract==null) pract="";
	if(episode_id==null) episode_id="";
	if(service_code==null)	service_code = "";
	
	/*StringBuffer where_criteria = new StringBuffer();
	String and_yn = "";
	Connection conn = null ;
	Statement stmt=null;
	ResultSet rset=null;*/

try
{
	//conn  =  ConnectionManager.getConnection(request);
	//stmt = conn.createStatement();

	//StringBuffer sql =new StringBuffer();
	//String FromDateTime = "";
	//String ToDateTime = "";
	//String extra_criteria = "";
	String source1 ="";
	String source2 ="";

	/*	if (!patid.equals(""))
		{
			where_criteria.append("patient_id = '"+patid+"'" );
			and_yn = " and ";
		}
		// MRN
		if (!mrnno.equals(""))
		{
			where_criteria.append(and_yn).append( " patient_id in(select patient_id from mr_pat_file_index  where facility_id='"+Facility_Id+"' and file_no ='"+mrnno+"')" );
			and_yn = " and ";
		}
		// Date From
		if (!dtfrm.equals(""))
		{
			where_criteria.append(and_yn).append("trunc(visit_adm_date_time) >= to_date('"+dtfrm+"','dd/mm/yyyy')" );
			and_yn = " and ";
		}
		// To
		if (!dtto.equals(""))
		{
			where_criteria.append(and_yn) .append("trunc(visit_adm_date_time) <= to_date('"+dtto+"','dd/mm/yyyy')" );
			and_yn = " and ";
		}
		// Service
		if (!serv.equals(""))
		{
			where_criteria.append(and_yn ).append( "service_code ='"+ serv +"'" );
			and_yn      = " and ";
		}
		// Clinic
		if (!loc.equals(""))
		{
			where_criteria.append(and_yn ).append("assign_care_locn_code ='"+loc+"'");
			and_yn      = " and ";
		}
		// Practitioner
		if (!pract.equals(""))
		{
			where_criteria.append(and_yn).append( "attend_practitioner_id='"+pract+"'" );
			and_yn      = " and ";
		}
		if (episode_id != null && !episode_id.equals(""))
		{
			where_criteria.append( and_yn).append( "episode_id >= "+episode_id+" " );
			and_yn      = " and ";
		}
	//out.println("service_code"+service_code);
	if(!service_code.equals(""))
	{
		
	   sql.append("Select to_char(queue_date,'dd/mm/yyyy hh24:mi') from_date,to_char(queue_date,'dd/mm/yyyy hh24:mi') to_date, queue_date visit_adm_date_time ");
		sql.append(" from OP_PATIENT_QUEUE  ");
		sql.append(" where facility_id = '"+Facility_Id+"' and patient_class = 'OP' ");
		sql.append( " and service_code = '"+service_code+"' and patient_id = '"+patid+"' ");
		sql.append(" and episode_id = "+episode_id+" ");
		sql.append(" order by queue_date ");
		rset = stmt.executeQuery(sql.toString());

		if(rset != null)
		{
			if(rset.next())
			{
				FromDateTime = rset.getString(1);
			}
		}
		
		if(FromDateTime == null)	FromDateTime = "";

		if(rset != null) rset.close();

		sql.setLength(0);
		
		sql.append("Select to_char(queue_date,'dd/mm/yyyy hh24:mi') to_date,queue_date  visit_adm_date_time ");
		sql.append(" from OP_PATIENT_QUEUE  ");
		sql.append(" where facility_id = '"+Facility_Id+"'  and patient_class = 'OP' ");
		sql.append(" and service_code = '"+service_code+"' and patient_id = '"+patid+"' ");
		sql.append( " and episode_id > "+episode_id+" and visit_type_ind = 'F' ");
		sql.append( " order by queue_date ");
		rset = stmt.executeQuery(sql.toString());
		if(rset != null)
		{
			if(rset.next())
			{
				ToDateTime = rset.getString(1);
			}
		}
		if(ToDateTime == null)	ToDateTime = "";

		if(rset != null) rset.close();

		sql.setLength(0);
		
		if(!FromDateTime.equals(""))
			extra_criteria = " and visit_adm_date_time between to_date('"+FromDateTime+"','dd/mm/yyyy hh24:mi') and nvl(to_date('"+ToDateTime+"','dd/mm/yyyy hh24:mi'),sysdate) and service_code = '"+service_code+"' ";
	}

	sql.setLength(0); */

	//int maxRecord = 0;
	
    /*sql.append("select count(*) as total from Pr_Search_visit_vw ");
    sql.append("where facility_id = '"+Facility_Id+"' and nvl(level_of_care_ind,'XX') ='A' and ").append(where_criteria).append(extra_criteria);
   // out.println(sql.toString());
	rset = stmt.executeQuery(sql.toString());
	rset.next();
	maxRecord = rset.getInt("total");

	if(rset != null) rset.close();

	sql.setLength(0);
		
	if(maxRecord == 0)
	{				
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>"); */
	
            _bw.write(_wl_block4Bytes, _wl_block4);

 //	 }
//	else
//	 {  

	    String params1="blnk="+blnk+"&patid="+patid+"&mrnno="+mrnno+"&dtfrm="+dtfrm+"&dtto="+dtto+"&serv="+serv+"&loc="+loc+"&pract="+pract+"&openEpisode="+openEpisode+"&speciality_id="+speciality_id+"&user_id="+user_id+"&episode_id="+episode_id;
		String params2 = "";
		source1 = url1 + params1;
    
		if((srch != null) && (!srch.equals(""))) {
        url2 = "../../eOP/jsp/QPVvisits.jsp?";
        params2 = params1; 
		}
		source2 = url2 + params2;
	
 

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(source2));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(params1));
            _bw.write(_wl_block7Bytes, _wl_block7);

//	}
  
  //if(rset != null) rset.close();
  //if(stmt != null) stmt.close();

}catch(Exception e){out.println("Excep Result:"+e);}

	finally{
		try
		{
			//if(rset!=null) rset.close();
			//if(stmt != null) stmt.close();
		}catch(Exception e){}
	
	//if(conn!=null) ConnectionManager.returnConnection(conn,request);
	
	 }

            _bw.write(_wl_block8Bytes, _wl_block8);
 } 
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
