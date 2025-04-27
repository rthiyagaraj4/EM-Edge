package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public final class __validaterenewperiod extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ValidateRenewPeriod.jsp", 1709117946635L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t<script>\n\t\t\t\tparent.frames[1].document.getElementById(\"informed_name\").value = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\t\tif(parent.frames[1].document.forms[0].informed_name.value.disabled==true)\n\t\t\t\t{ \t\t\t   \n\t\t\t\tparent.frames[1].document.forms[0].informed_name.value.disabled=false;\n\t\t\t\tparent.frames[1].document.forms[0].informed_name.value.focus();\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar opt=parent.frames[4].document.createElement(\"OPTION\");\n\t\t\t\t\topt.text\t= \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"; \n\t\t\t\t\topt.value\t= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\tparent.frames[1].document.forms[0].location1.add(opt);\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar opt=parent.frames[3].document.createElement(\"OPTION\");\n\t\t\t\t\topt.text\t= \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckOutLodger && Lodger -> RenewGatePass
/// Developer		:	SRIDHAR R
/// Created On		:	26 APR 2004
/// Function		:	This Page is called for validating the Maximum Renewal Period for the Renew Gate Pass Function. It will add the no of Days/Hours to the Renew period from & return the value.

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


Connection conn = null; 
ResultSet rs	= null;
Statement stmt	= null;
Statement stmt_loc1	= null;
ResultSet rset	= null;
ResultSet rs_loc1	= null;
Statement pstmt	= null;
String value1  = "";
String value2 = ""; 
String value3 = "";
String from = "";
String value5 = "";
String clinicDesc = "";
String clinicCode = "";

try
{
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

	conn = ConnectionManager.getConnection(request);
	
	//Added on 8/24/2004 by Raghavendra for InformedDetails.jsp  
	value1 = request.getParameter("field1")==null?"":request.getParameter("field1");;

	if(!((value1.equals("InformDetails"))||(value1.equals("BedSideReferral"))))
	{
		Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH");
		String criteria = (String) hash.get("criteria");

		if(criteria.equals("Days"))
		{
			String prefDateTime =(String) hash.get("prefDateTime");
			String expDaysofStay=(String) hash.get("expDaysofStay");

			String sql = "Select to_char(to_date('"+prefDateTime+"','DD/MM/rrrr HH24:MI')+"+expDaysofStay+",'dd/mm/rrrr hh24:mi') From DUAL";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			out.println(rs.getString(1));
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		else if(criteria.equals("Hours"))
		{
			String prefDateTime		= (String) hash.get("prefDateTime");
			String expHoursofStay	= (String) hash.get("expHoursofStay");

			String sql = "Select to_char(to_date('"+prefDateTime+"','DD/MM/rrrr HH24:MI')+"+expHoursofStay+",'dd/mm/rrrr hh24:mi') From DUAL";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			out.println(rs.getString(1));
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		hash.clear();
	}
	else if(value1.equals("InformDetails"))
	{
		value2				=	request.getParameter("field2")==null?"":request.getParameter("field2");

		value3				=	request.getParameter("field3")==null?"":request.getParameter("field3");

		from				=	request.getParameter("field4")==null?"":request.getParameter("field4");

		value5				=	request.getParameter("field5")==null?"":request.getParameter("field5");

		if((value1.equals("InformDetails")) && (from.equals("RecordInpatientLeave")))
		{
			StringBuffer sqlBuffer	= new StringBuffer();
			String info_pat_name	= "";
			
			if (value3.equals("01"))
				{
					sqlBuffer.append("select contact1_name info_pat_name from mp_pat_rel_contacts where patient_id = '");
					sqlBuffer.append(value2);
					sqlBuffer.append("' ");
				}
				else if (value3.equals("02"))
				{
					sqlBuffer.append("select contact2_name info_pat_name from mp_pat_rel_contacts where patient_id = '");
					sqlBuffer.append(value2);
					sqlBuffer.append("' ");
				}

			String mysql = sqlBuffer.toString();
			pstmt	=	conn.createStatement();
		
			rset	=	pstmt.executeQuery(mysql);	

			if ((rset != null) && (rset.next()))
			info_pat_name = rset.getString("info_pat_name")==null?"":rset.getString("info_pat_name");
	 
 			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

				if ((value5.equals("Leave")) && !(info_pat_name.equals("")))
				{
				
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(info_pat_name));
            _bw.write(_wl_block4Bytes, _wl_block4);

				}
		}
	}

		else if(value1.equals("BedSideReferral"))
		{ 
		String ref_to =	request.getParameter("ref_to")==null?"":request.getParameter("ref_to");

		String loc_type =	request.getParameter("loc_type")==null?"":request.getParameter("loc_type");
		if(loc_type.equals("C")) 
		{	

		String sql_loc1=" SELECT SHORT_DESC CLINIC_DESC, CLINIC_CODE FROM `OP_CLINIC_LANG_VW  WHERE  LANGUAGE_ID = '"+locale+"' and EFF_STATUS = 'E' and clinic_type='C' AND FACILITY_ID = '"+ref_to+"' order by 1 "; 


		stmt_loc1=conn.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);
		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				clinicDesc	= rs_loc1.getString("CLINIC_DESC");
				clinicCode	= rs_loc1.getString("CLINIC_CODE");
				
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(clinicDesc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(clinicCode));
            _bw.write(_wl_block7Bytes, _wl_block7);

			}// E.O While 
		if(rs_loc1!=null)	rs_loc1.close();
		if(stmt_loc1!=null)	stmt_loc1.close();
		}// E.O If 
	}//end of if for loc_type c.
	else
	if(loc_type.equals("D")) 
	{	

		String sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT_LANG_VW   WHERE  LANGUAGE_ID = '"+locale+"' AND EFF_STATUS = 'E' AND LOCN_TYPE = 'N' AND FACILITY_ID = '"+ref_to+"' AND APPL_PATIENT_CLASS = 'DC' order by 1 ";

		String nursingUnitDesc= "";
		String nursingUnitCode= "";
		
		stmt_loc1=conn.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);
		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				nursingUnitDesc	= rs_loc1.getString("NU_DESC");
				nursingUnitCode	= rs_loc1.getString("NURSING_UNIT_CODE");
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(nursingUnitDesc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(nursingUnitCode));
            _bw.write(_wl_block7Bytes, _wl_block7);

			}// E.O While
		if(rs_loc1!=null)	rs_loc1.close();
		if(stmt_loc1!=null)	stmt_loc1.close();
		}// E.O If 
	} //end of if for loc_type "D".
	}//end of BedSideReferral else 
	
	if(rs != null)	rs.close();	
	if(stmt !=null) stmt.close();
}catch(Exception e) {out.println(e.toString());}
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
