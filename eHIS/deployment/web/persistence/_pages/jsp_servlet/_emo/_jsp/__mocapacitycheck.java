package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __mocapacitycheck extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOCapacityCheck.jsp", 1709116974814L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection conn = null; 
ResultSet rs	= null;
Statement stmt	= null;
StringBuffer sql=new StringBuffer();
//int capacity=0;
//int ncapacity=0;
int bedCount =0;
try
{
   	request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String bedVaild = (String)hash.get("bedVaild");
	String registration_no = (String)hash.get("registration_no");
	if(bedVaild==null) bedVaild="";
	String occupying_patient_id="";
	
	if(bedVaild.equals("Y"))
	{
			
			String result ="";
			String bed_no = (String)hash.get("bed_no");
			if(bed_no==null) bed_no="";
			String area_code = (String)hash.get("area_code");
			if(area_code==null)area_code="";

			String patient_id = (String)hash.get("patient_id");
			if(patient_id==null)patient_id="";
            if((sql != null) && (sql.length() > 0))
			{
				sql.delete(0,sql.length());
			}
            stmt=conn.createStatement();
			sql.append("select OCCUPYING_PATIENT_ID from mo_bed_for_area where AREA_CODE='"+area_code+"' and  bed_no='"+bed_no+"' and facility_id = '"+facilityId+"' and EFF_STATUS='E'");
			rs=stmt.executeQuery(sql.toString());
              while(rs.next())
			   {
				occupying_patient_id = rs.getString("OCCUPYING_PATIENT_ID");

			    }   if(rs != null)	rs.close();	
	                if(stmt !=null) stmt.close();
			if(occupying_patient_id==null) occupying_patient_id="";
			stmt=conn.createStatement();
            if (occupying_patient_id.equals(patient_id))
		    {
				if((sql != null) && (sql.length() > 0))
				{
					sql.delete(0,sql.length());
				}
				
				sql.append("select count(*) from mo_bed_for_area where  AREA_CODE='"+area_code+"' and  bed_no='"+bed_no+"' and facility_id = '"+facilityId+"' and (((OCCUPYING_PATIENT_ID is null or occupying_patient_id='"+patient_id+"') and (registration_no is null or registration_no='"+registration_no+"') and BLOCKED_YN='N') OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE)) and EFF_STATUS='E' ");
				rs=stmt.executeQuery(sql.toString());
			}
			else
			{
				if((sql != null) && (sql.length() > 0))
				{
					sql.delete(0,sql.length());
				}
				sql.append("select count(*) from mo_bed_for_area where  AREA_CODE='"+area_code+"' and  bed_no='"+bed_no+"' and facility_id = '"+facilityId+"' and (((OCCUPYING_PATIENT_ID is null or occupying_patient_id='') and (registration_no is null or registration_no='') and BLOCKED_YN='N') OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE)) and EFF_STATUS='E' ");
				rs=stmt.executeQuery(sql.toString());
			
			}
			while(rs.next()) 
			{
				bedCount = rs.getInt(1);
      
			} if(rs != null)	rs.close();	
  	          if(stmt !=null) stmt.close();
	 
			if (bedCount==0)
			{
				result ="Invalid"; 
			
			}
			out.println(result);
     }
	 sql.setLength(0);
	if(rs != null)	rs.close();	
    if(stmt !=null) stmt.close();
hash.clear();
}
catch(Exception e) {out.println("Exception in File MOCapcityCheck"+e.toString());e.printStackTrace();}
finally
{
	 ConnectionManager.returnConnection(conn,request);
}

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
