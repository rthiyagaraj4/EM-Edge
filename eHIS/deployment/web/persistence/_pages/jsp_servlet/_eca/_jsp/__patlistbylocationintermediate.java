package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __patlistbylocationintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByLocationIntermediate.jsp", 1731175997436L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t\t<script language=\"JavaScript\" src =\"../../eCA/js/LocationForPractitioner.js\"></script>\n\t\t<script language=\"JavaScript\" src =\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\tvar returnArray;\n\t\t\t\n\t\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\t\t\n\t\t\tvar chkVal = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t        if (chkVal == \"ByLocationSpeciality\")\n\t\t    {\t\n\t\t\t  \t//alert();\n\t\t\t\tretVal=\n\t\t\t\tcallFunction3(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",\"Speciality\",parent.PatCriteriaFr.document.PatCriteriaFrm.specialty,parent.PatCriteriaFr.document.PatCriteriaFrm.specialty_code);  \n\t\t\t\t/* if(retVal != null && retVal !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\t parent.PatCriteriaFr.document.PatCriteriaFrm.specialty.value=retVal[1];\n\t\t\t\t\t parent.PatCriteriaFr.document.PatCriteriaFrm.specialty_code.value=retVal[0];\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.PatCriteriaFr.document.PatCriteriaFrm.specialty.value=\'\';\n\t\t\t\t\tparent.PatCriteriaFr.document.PatCriteriaFrm.specialty_code.value=\'\';\t\n\t\t\t\t} */\n\t\t\t}\n\t\t   \telse if (chkVal == \"AttendingPractitioner\")\n\t\t   \t{\n\t        \tretVal=\n\t\t\t\tcallFunction3(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"Practitioner\",parent.PatCriteriaFr.document.PatCriteriaFrm.pract,parent.PatCriteriaFr.document.PatCriteriaFrm.AttendPract);\n\t\t\t\t/* if(retVal != null && retVal !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\t parent.PatCriteriaFr.document.PatCriteriaFrm.pract.value=retVal[1];\n\t\t\t\t\t parent.PatCriteriaFr.document.PatCriteriaFrm.AttendPract.value=retVal[0];\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.PatCriteriaFr.document.PatCriteriaFrm.pract.value=\'\';\n\t\t\t\t\tparent.PatCriteriaFr.document.PatCriteriaFrm.AttendPract.value=\'\';\t\n\t\t\t\t} */\n\t\t   }\n\t\t   else if (chkVal == \"ClinicCode\")\n\t\t   {\n\t\t\t\tretVal=\n\t\t\t   \tcallFunction3(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",parent.PatCriteriaFr.document.PatCriteriaFrm.locationDesc, parent.PatCriteriaFr.document.PatCriteriaFrm.locationCode);\n\t\t\t  \t/*if(retVal != null && retVal !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\t parent.PatCriteriaFr.document.PatCriteriaFrm.locationDesc.value=retVal[1];\n\t\t\t\t\t parent.PatCriteriaFr.document.PatCriteriaFrm.locationCode.value=retVal[0];\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.PatCriteriaFr.document.PatCriteriaFrm.locationDesc.value=\'\';\n\t\t\t\t\tparent.PatCriteriaFr.document.PatCriteriaFrm.locationCode.value=\'\';\t\n\t\t\t\t} */\n\t\t\t}\n\t</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n </body>\n</html>\n\n";
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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String facility_id = (String)session.getValue("facility_id");
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String target = "";
	String stdval = "";
	String sql = "";
	String selFunVal = "";
	String facilityid = "";
	String pract = "";
	String locale = "";
	String Specialty = "";
	String practitioner = "";
	String pract_id = "";
	String loc_type = "";
	String title = "";
	int count =0;
	try
	{
		
			con = ConnectionManager.getConnection(request);
			
		    target = request.getParameter("target")==null ? "" : request.getParameter("target");
			stdval = request.getParameter("stdval")==null ? "" : request.getParameter("stdval");
			pract = request.getParameter("pract")==null ? "" : request.getParameter("pract");
			facilityid = request.getParameter("facilityid")==null ? "" : request.getParameter("facilityid");
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			locale = request.getParameter("locale")==null ? "" : request.getParameter("locale");
			Specialty = request.getParameter("Specialty")==null ? "" : request.getParameter("Specialty");
			practitioner = request.getParameter("practitionerValue")==null ? "" : request.getParameter("practitionerValue");
			pract_id = request.getParameter("pract_id")==null ? "" : request.getParameter("pract_id");
			loc_type = request.getParameter("loc_type")==null ? "" : request.getParameter("loc_type");
			title = request.getParameter("title")==null ? "" : request.getParameter("title");

		   if (selFunVal.equals("ByLocationSpeciality"))
			{
			  
					if(!Specialty.equals(""))
					{
						sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'";
						if(!pract.equals(""))
                        sql=sql+" and SPECIALITY_CODE  in (select nvl(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id='"+pract+"' union all select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where FACILITY_ID='"+facilityid+"' and PRACTITIONER_ID='"+pract+"' )";
						sql=sql+" and upper(a.SHORT_DESC) like upper(?) order by 2";
                      //  sql="SELECT order_type_code code,  short_desc description FROM or_order_type_lang_vw WHERE language_id=? and eff_status='E' AND order_category like ?  and upper(short_desc) like upper(?)";
						Specialty = Specialty + "%";
					}
			}
			else if(selFunVal.equals("AttendingPractitioner"))
		   {
				//out.println("<script>alert('hi"+practitioner+"')</script>");
			   if(!practitioner.equals(""))
			   {
					//IN059520 Start
					//sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id   and b.language_id = '"+locale+"' and a.eff_status = 'E' and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
					sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id   and a.eff_status = b.eff_status and b.language_id = '"+locale+"' and a.eff_status = 'E' and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
					//IN059520 Start
				  practitioner = practitioner + "%";
				 // out.println("<script>alert('hi"+practitioner+"')</script>");
			   }
		   }
		   else if(selFunVal.equals("ClinicCode"))
		   {
			   if(!stdval.equals(""))
			   {
			   sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+facilityid+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+facilityid+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+facilityid+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+facilityid+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+facilityid+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";
			   stdval = stdval + "%";
			   }
		   }
			ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			if (selFunVal.equals("ByLocationSpeciality"))
			{
                 
					if(!Specialty.equals(""))
					{	
						ps.setString(1,Specialty);
						//ps.setString(2,order_category);
						//ps.setString(3,orderTypevalue);		
					}
			}
			else if(selFunVal.equals("AttendingPractitioner"))
		    {
                    if(!practitioner.equals(""))
			        {
                       ps.setString(1,practitioner);
					}
		    }
			else if(selFunVal.equals("ClinicCode"))
		    {
				 if(!stdval.equals(""))
			        {
                       ps.setString(1,stdval);
					}

			}
		    rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			//out.println("<script>alert('count"+count+"')</script>");
			if(count == 1)
		 {		 
				rs.beforeFirst() ;				
				out.println("<script>");
             
           // out.println("alert('89')");
				if(!Specialty.equals(""))
			   {				
					 while(rs.next())
					{
					  
						out.println("parent.PatCriteriaFr.document.PatCriteriaFrm.specialty.value='"+rs.getString(2)+"'");
						out.println(" parent.PatCriteriaFr.document.PatCriteriaFrm.specialty_code.value='"+rs.getString(1)+"' ");
					}
			   }
			    else if(!practitioner.equals(""))
			   {
					while(rs.next())
					{
					   out.println("parent.PatCriteriaFr.document.PatCriteriaFrm.pract.value='"+rs.getString(2)+"'");
					   out.println(" parent.PatCriteriaFr.document.PatCriteriaFrm.AttendPract.value='"+rs.getString(1)+"' ");
					}
				}
				else if(!stdval.equals(""))
			    {
					//out.println("alert('hi')");
					while(rs.next())
					{
					   out.println("parent.PatCriteriaFr.document.PatCriteriaFrm.locationDesc.value='"+rs.getString(2)+"'");
					   out.println(" parent.PatCriteriaFr.document.PatCriteriaFrm.locationCode.value='"+rs.getString(1)+"' ");
					}

			    }
			out.println("</script>");
		   }
		  
		    if(ps != null) ps.close();
		    if(rs != null) rs.close();

			if(count == 0 || count > 1)
			{	
				if(!Specialty.equals(""))
			{
					sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'";

					if(!pract.equals(""))
                    sql=sql+" and SPECIALITY_CODE  in (select nvl(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id='"+pract+"' union all select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where FACILITY_ID='"+facilityid+"' and PRACTITIONER_ID='"+pract+"' )";
					sql=sql + " and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";
				//sql ="SELECT order_type_code code,  short_desc description FROM or_order_type_lang_vw WHERE language_id='"+localeName1+"' and eff_status='E' AND order_category like '"+order_category+"' and upper(order_type_code) like upper(?) and upper(short_desc) like upper(?)";
			}
			else if(!practitioner.equals(""))
			{
				//IN059520 Start
                //sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
				sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and a.eff_status = b.eff_status  and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
				//IN059520 End.
			}
			else if(!stdval.equals(""))
			{
				sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+facilityid+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+facilityid+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+facilityid+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+facilityid+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+facilityid+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";

			}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(title));
            _bw.write(_wl_block14Bytes, _wl_block14);
	
	}
	
}
	catch(Exception ee)
	{
		ee.printStackTrace();
		//out.println("Exception in By Location Intermediate Module "+ee.toString());//common-icn-0181
	}
	finally
	{
		try{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}

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
