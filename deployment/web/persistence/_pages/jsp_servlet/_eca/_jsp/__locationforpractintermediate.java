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

public final class __locationforpractintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/LocationForPractIntermediate.jsp", 1732623094326L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t\t<script language=\"JavaScript\" src =\"../../eCA/js/LocationForPractitioner.js\"></script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\tvar returnArray;\n\t\t</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest();\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\nasync function openShowmodal(){\n\t\tvar chkVal = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\n\t\tif (chkVal == \"Pract\")\n\t\t{\t\t\t\n\t\t\t retArray = await callFunction(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",\"LocationPract\",parent.parent.f_query_add_mod.Header.document.LPract.pctr)\n\n\t\t\tif(retArray != null && retArray !=\"\")\t\n\t\t\t{\n\t\t\t\tvar ret1=unescape(retArray);\n\t\t\t\t var arr=ret1.split(\",\");\n\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t{\n\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t}\n\t\t\t\t    \n\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.pctr.value = arr[1];\n\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.practitioner_id.value = arr[0];\n\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.flag.value = \'true\'\n\t\t\t\t\t\n\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.pctr.value = \'\'\n\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.practitioner_id.value = \'\'\n\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.flag.value = \'true\'\n\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t}\n\t\t}else if (chkVal == \"Location\")\n\t\t{\t\t\n\t\t\t\tretVal =await callFunction1(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"Location\",parent.parent.f_query_add_mod.AddModify.document.Section_form.loca)\n\n\t\t\t\tif(retVal != null && retVal !=\"\")\t\n\t\t\t\t{\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\t var arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.parent.f_query_add_mod.AddModify.document.Section_form.loca.value = arr[1];\n\t\t\t\t\t\tparent.parent.f_query_add_mod.AddModify.document.Section_form.locn_code.value = arr[0];\n\t\t\t\t\t\tparent.parent.f_query_add_mod.AddModify.document.Section_form.flag.value = \'true\'\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.parent.f_query_add_mod.AddModify.document.Section_form.loca.value = \'\'\n\t\t\t\t\tparent.parent.f_query_add_mod.AddModify.document.Section_form.locn_code.value = \'\'\n\t\t\t\t\tparent.parent.f_query_add_mod.AddModify.document.Section_form.flag.value = \'true\'\n\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t\t\t}else if (chkVal == \"Location1\")\n\t\t     {\t\t\t\t\n\t\t\t\tretVal = await callFunction2(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"Location\",parent.parent.f_query_add_mod.Query.document.qry_location.locn_code)\n\n\t\t\t\tif(retVal != null && retVal !=\"\")\t\n\t\t\t\t{      \n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\t var arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.locn_code.value = arr[1];\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.locaSerch.value = arr[0];\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.flag.value = \'true\'\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.locn_code.value = \'\'\n\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.locaSerch.value = \'\'\n\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.flag.value = \'true\'\n\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\n\t\t\t }else if (chkVal == \"Speciality\")\n\t\t        {\t\t\t\t\n\t\t\t\tretVal = await callFunction3(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"Speciality\",parent.parent.f_query_add_mod.Header.document.LPract.spl)\n\n\t\t\t\tif(retVal != null && retVal !=\"\")\t\n\t\t\t\t{      \n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\t var arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.spl.value = arr[1];\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.spl_code.value = arr[0];\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.flag.value = \'true\'\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.spl.value = \'\'\n\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.spl_code.value = \'\'\n\t\t\t\t\tparent.parent.f_query_add_mod.Header.document.LPract.flag.value = \'true\'\n\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\t\t\t  }else if (chkVal == \"PrimeSpeciality\")\n\t\t       {\t\t\t\t  \n\t\t\t\tretVal = await callFunction4(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\",\"Speciality\",parent.parent.f_query_add_mod.Query.document.qry_location.speciality)\n\n\t\t\t\tif(retVal != null && retVal !=\"\")\t\n\t\t\t\t{\t\t\n\t\t\t\t\tvar ret1=unescape(retVal);\n\t\t\t\t\t var arr=ret1.split(\",\");\n\t\t\t\t\t\tif(arr[1]==undefined) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tarr[0]=\"\";\t\n\t\t\t\t\t\t\tarr[1]=\"\";\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.speciality.value = arr[1];\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.prime_spl_code.value = arr[0];\n\t\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.flag.value = \'true\'\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.speciality.value = \'\'\n\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.prime_spl_code.value = \'\'\n\t\t\t\t\tparent.parent.f_query_add_mod.Query.document.qry_location.flag.value = \'true\'\n\t\t\t\t\tparent.parent.messageFrame.location.href = \'../../eCommon/jsp/MstCodeError.jsp\';\n\t\t\t\t}\n\n\t\t\t }\n\t\t\n\t\t}\nopenShowmodal();\n\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n </body>\n</html>\n\n";
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
	String practitioner = "";
	String speciality = "";
	String locationcode = "";
	String locationcode1 = "";
	String specialitycode = "";
	String primespeciality = "";
	String locn_type = "";
	String sql = "";
	String selFunVal = "";
	int count =0;
	try
	{
		
			con = ConnectionManager.getConnection(request);
			practitioner = request.getParameter("practitioner") == null ? "" : request.getParameter("practitioner");
		    speciality = request.getParameter("speciality")==null ? "" : request.getParameter("speciality");
			locationcode = request.getParameter("locationcode")==null ? "" : request.getParameter("locationcode");
			locationcode1 = request.getParameter("locationcode1")==null ? "" : request.getParameter("locationcode1");
			specialitycode = request.getParameter("specialitycode")==null ? "" : request.getParameter("specialitycode");
			primespeciality = request.getParameter("primespeciality")==null ? "" : request.getParameter("primespeciality");
			locn_type = request.getParameter("locn_type")==null ? "" : request.getParameter("locn_type");
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			

			if (selFunVal.equals("Pract")){
				practitioner = practitioner + "%";

				if(!speciality.equals(""))
				{
					sql ="select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id =? and b.primary_speciality_code=? and upper(b.practitioner_name) like upper(?)";					
				}
				else
				{
					sql ="select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id =? and upper(b.practitioner_name) like upper(?) ";	
					

				}
			
			}else if (selFunVal.equals("Location"))
			{
				locationcode = locationcode + "%";
				 if(!locationcode.equals(""))
				{
					sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = ? and facility_id = ?  and upper(short_desc) like upper(?) ";
				}
			}else if (selFunVal.equals("Location1"))
			{
				 if(!locationcode1.equals(""))
				{
					sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = ? and facility_id = ?  and upper(short_desc) like upper(?) ";
					
					locationcode1 = locationcode1 + "%";					
				}
			}else if (selFunVal.equals("Speciality"))
			{
					if(!specialitycode.equals(""))
					{
						sql ="Select speciality_code code, short_desc description from am_speciality where upper(short_desc) like upper(?) ";

						specialitycode = specialitycode + "%";
					}
			
			}else if (selFunVal.equals("PrimeSpeciality")){
				if(!primespeciality.equals(""))
				{
					sql ="Select speciality_code code, short_desc description from am_speciality where upper(short_desc) like upper(?) ";
					primespeciality = primespeciality + "%";				
				}
			}
		
			
			ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			if (selFunVal.equals("Pract")){
				if(!speciality.equals(""))
				{
					ps.setString(1,facility_id);
					ps.setString(2,speciality);
					ps.setString(3,practitioner);
				}
				else
				{
					ps.setString(1,facility_id);
					ps.setString(2,practitioner);

				}
			
			}else if (selFunVal.equals("Location"))
			{
				 if(!locationcode.equals(""))
				{					
					ps.setString(1,locn_type);
					ps.setString(2,facility_id);
					ps.setString(3,locationcode);
				}
			}else if (selFunVal.equals("Location1"))
			{
				 if(!locationcode1.equals(""))
				{
					ps.setString(1,locn_type);
					ps.setString(2,facility_id);
					ps.setString(3,locationcode1);
				}
			}else if (selFunVal.equals("Speciality"))
			{
					if(!specialitycode.equals(""))
					{					
						ps.setString(1,specialitycode);	
					}
			
			}else if (selFunVal.equals("PrimeSpeciality")){
				if(!primespeciality.equals(""))
				{
					ps.setString(1,primespeciality);	
				}
			}
					
			rs = ps.executeQuery();
		
			while(rs.next())
			{
				count++;
			}
			
			
			if(count == 1)
			 {
		
				rs.beforeFirst() ;				
				out.println("<script>");
               if(!speciality.equals(""))
			  {
				   while(rs.next())
				{						
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.pctr.value='"+rs.getString(2)+"' ");
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Header.document.LPract.practitioner_id.value='"+rs.getString(1)+"' ");
					out.println("PopulateName('"+rs.getString(1)+"');");
				}
				
			  }
			  else if(speciality.equals("") && selFunVal.equals("Pract"))
			  {
				while(rs.next())
				{						
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.pctr.value='"+rs.getString(2)+"' ");
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Header.document.LPract.practitioner_id.value='"+rs.getString(1)+"' ");
					out.println("PopulateName('"+rs.getString(1)+"');");
				}
			  }

			 
			  
			  if(!locationcode.equals(""))
			  {
					  while(rs.next())
				{
					out.println("parent.parent.f_query_add_mod.AddModify.document.Section_form.loca.value='"+rs.getString(1)+"' ");
					out.println("parent.parent.f_query_add_mod.AddModify.document.Section_form.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.AddModify.document.Section_form.locn_code.value='"+rs.getString(2)+"' ");
				}
			}
			if(!locationcode1.equals(""))
			  {
					  while(rs.next())
				{
					out.println("parent.parent.f_query_add_mod.Query.document.qry_location.locn_code.value='"+rs.getString(1)+"' ");
					out.println("parent.parent.f_query_add_mod.Query.document.qry_location.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Query.document.qry_location.locaSerch.value='"+rs.getString(2)+"' ");
				}
			}

			if(!specialitycode.equals(""))
			  {
				 while(rs.next())
				{
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.spl.value='"+rs.getString(2)+"' ");
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Header.document.LPract.spl_code.value='"+rs.getString(1)+"' ");
				}
			}

			if(!primespeciality.equals(""))
			  {
					  while(rs.next())
				{
					out.println("parent.parent.f_query_add_mod.Query.document.qry_location.speciality.value='"+rs.getString(2)+"' ");
					out.println("parent.parent.f_query_add_mod.Query.document.qry_location.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Query.document.qry_location.prime_spl_code.value='"+rs.getString(1)+"' ");
				}
			}
			out.println("</script>");
		   }
		  
		    if(ps != null) ps.close();
		    if(rs != null) rs.close();

			if(count == 0 || count > 1)
			{			
				if(!speciality.equals(""))
			{
				sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+facility_id+"' and b.primary_speciality_code='"+speciality+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2";
			}
			else
			{
				sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2";
                


			}
			if(!locationcode.equals(""))
			{
				sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = '"+locn_type+"' and facility_id = '"+facility_id+"'  and  upper(locn_code) like upper(?) and upper(short_desc) like upper(?) order by 1";
			}
			if(!locationcode1.equals(""))
			{
				sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = '"+locn_type+"' and facility_id = '"+facility_id+"'  and  upper(locn_code) like upper(?) and upper(short_desc) like upper(?) order by 1";
			}

			if(!specialitycode.equals(""))
			{
				sql ="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
			}
			if(!primespeciality.equals(""))
			{
				sql ="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
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
            out.print( String.valueOf(sql));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block15Bytes, _wl_block15);
	
	}
	
}
	catch(Exception ee)
	{
		ee.printStackTrace();
		//out.println("Exception in Location For Pract Intermediate Module "+ee.toString());//COMMON-ICN-0181	
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
