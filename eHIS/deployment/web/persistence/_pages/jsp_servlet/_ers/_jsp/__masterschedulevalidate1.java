package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eRS.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __masterschedulevalidate1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/MasterScheduleValidate1.jsp", 1709117441275L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

/*
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleValidate1.jsp
*	Purpose 		:	To list the posotion according to the seceted role type & staff type
*	Created By		:	Subbulakshmy. K
*	Created On		:	25-11-2004
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
  //System.err.println("entering into validate1jsp");
	String role_type= request.getParameter("role")==null?"":request.getParameter("role");		
	String staff_type= request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String facility_id= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String requirement_id= request.getParameter("requirement_id")==null?"":request.getParameter("requirement_id");		

	if(staff_type==null)
		staff_type="";
	Connection conn 				= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 			= null;
	ArrayList Position_List		= new ArrayList();
	ArrayList StaffType_List	= new ArrayList();	
	ArrayList Date_Data			= new ArrayList();	
	String[] record					= null;
	String sql_position				="";
	try {
	    conn = ConnectionManager.getConnection(request);
		if(staff_type.equals("")){
			System.err.println("chking if ondition");
			sql_position	="select position_code, position_desc from am_position where eff_Status = 'E' and role_type=?";
			String sql_stafftype			="select pract_type staff_type, desc_userdef staff_desc from am_pract_type where eff_Status = 'E' and ? = 'P' union select other_staff_type staff_type, short_desc staff_desc from am_other_staff_type where eff_status = 'E' and ? = 'O' order by staff_desc";

			pstmt = conn.prepareStatement( sql_stafftype) ;
			pstmt.setString(1, role_type);
			pstmt.setString(2, role_type);

			resultSet = pstmt.executeQuery() ;
			System.err.println("role_type-->" +role_type);
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "staff_type");
				record[1] = resultSet.getString( "staff_desc");
				StaffType_List.add(record) ;
			}
			if(pstmt!= null)
				pstmt.close();
			if(resultSet!= null)
				resultSet.close();
			//to list staff_type
			for( int i=0 ; i< StaffType_List.size() ; i++ ) {
				System.err.println("executing for loop");
				record = (String[])StaffType_List.get(i);
				out.println( "addStaffType(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;			
			}
		}else{
			sql_position	="select position_code, position_desc from am_position where eff_Status = 'E' and role_type=? and staff_type =?";
		}
		//to get the locantion type
		pstmt = conn.prepareStatement( sql_position);
		pstmt.setString(1,role_type);
		if(!staff_type.equals(""))
			pstmt.setString(2,staff_type);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("position_code");
			record[1] = resultSet.getString("position_desc");
			Position_List.add(record) ;
		}
		if(pstmt!= null)
			pstmt.close();
		if(resultSet!= null)
			resultSet.close();
		//to list postion
		for( int i=0 ; i< Position_List.size() ; i++ ) {
			record = (String[])Position_List.get(i);
           System.out.println("record ---> "+i+" - "+record[0]+" - "+record[1]);
			out.println( "addPosition(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;			
		}
		//to display date
		if((facility_id!=null)&&(workplace_code!=null)&&(requirement_id!=null)){
			System.err.println("chking if condition whn facid!=null n wp!=null n req!=null");
			String sql_date="select to_char(requirement_date_fm, 'dd/mm/yyyy') frmdate,to_char(requirement_date_to, 'dd/mm/yyyy') todate from rs_workplace_requirement where facility_id=? and workplace_code=? and requirement_id=?";
			//to get the locantion type
			pstmt = conn.prepareStatement( sql_date);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,workplace_code);
			pstmt.setString(3,requirement_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()) {
				record = new String[2];				
				record[0] = resultSet.getString("frmdate");
				record[1] = resultSet.getString("todate");
				Date_Data.add(record) ;
			}
			if(pstmt!= null)
				pstmt.close();
			if(resultSet!= null)
				resultSet.close();
			//to list postion
			for( int i=0 ; i< Date_Data.size() ; i++ ) {
				record = (String[])Date_Data.get(i);
				out.println( "assignDateRange(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;			
			}
		}

	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(pstmt!= null)
			pstmt.close();
		if(resultSet!= null)
			resultSet.close();
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
