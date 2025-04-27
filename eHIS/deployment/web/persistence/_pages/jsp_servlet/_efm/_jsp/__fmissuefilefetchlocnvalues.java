package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmissuefilefetchlocnvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFileFetchLocnValues.jsp", 1742885004224L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\' class=\'message\'>\n<form name=\'fetchLocnValues_form\' id=\'fetchLocnValues_form\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<SCRIPT>\n\t\t\t\t\tparent.frames[2].document.getElementById(\'td1\').innerHTML = getLabel(\"Common.designation.label\",\"common\");\n\t\t\t\t\tparent.frames[2].document.getElementById(\'td2\').innerHTML = \"<B>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</B>\";\n\t\t\t\t\tparent.frames[2].document.getElementById(\'td3\').innerHTML = getLabel(\"Common.primaryspeciality.label\",\"common\");\n\t\t\t\t\tparent.frames[2].document.getElementById(\'td4\').innerHTML = \"<B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</B>\";\n\t\t\t\t</SCRIPT>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<SCRIPT>\n\t\t\t\t\tparent.frames[2].document.getElementById(\'td1\').innerHTML = \"\";\n\t\t\t\t\tparent.frames[2].document.getElementById(\'td2\').innerHTML = \"\";\n\t\t\t\t\tparent.frames[2].document.getElementById(\'td3\').innerHTML = \"\";\n\t\t\t\t\tparent.frames[2].document.getElementById(\'td4\').innerHTML = \"\";\n\t\t\t\t</SCRIPT>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script>\n\t\t\tvar x = parent.issue_tab.document.forms[0].locations.options.length;\n\t\t\tfor(var i=0;i<x;i++)\n\t\t\t{\n\t\t\t\tparent.issue_tab.document.forms[0].locations.remove(\"locations\");\n\t\t\t}\n\n\t\t\tvar tp =\"        --- \"+getLabel(\'Common.defaultSelect.label\',\'common\')+\" ---        \";\n\t\t\t\n\t\t\tvar opt1=parent.issue_tab.document.createElement(\"OPTION\");\n\t\t\topt1.text=tp;\n\t\t\topt1.value=\"\";\n\n\t\t\tparent.issue_tab.document.forms[0].locations.add(opt1);\n\n\t\t\tvar y = parent.issue_tab.document.forms[0].narration.options.length;\n\t\t\tfor(var i=0;i<y;i++)\n\t\t\t{\n\t\t\t\tparent.issue_tab.document.forms[0].narration.remove(\"narration\");\n\t\t\t}\n\n\t\t\tvar tp2 =\"        --- \"+getLabel(\'Common.defaultSelect.label\',\'common\')+\" ---        \";\n\t\t\tvar opt2=parent.issue_tab.document.createElement(\"OPTION\");\n\t\t\topt2.text=tp2;\n\t\t\topt2.value=\"\";\n\n\t\t\tparent.issue_tab.document.forms[0].narration.add(opt2);\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\n\t\t\t\tvar element   = parent.issue_tab.document.createElement(\'OPTION\');\n\t\t\t\telement.value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="@";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\telement.text  = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\tparent.issue_tab.document.forms[0].locations.add(element);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\tvar element1   = parent.issue_tab.document.createElement(\'OPTION\');\n\t\t\t\t\telement1.value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\telement1.text  = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\tparent.issue_tab.document.forms[0].narration.add(element1);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>\n\t\tif(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" == 1)\n\t\t{\n\t\t\tparent.issue_detail.document.forms[0].locations(1).selected = true;\n\t\t\t\n\t\t\tvar ObjValue = parent.issue_detail.document.forms[0].locations(1).value;\n\t\t\tvar reqLocnArr = ObjValue.split(\"@\");\n\t\t\t\n\t\t\tparent.issue_detail.document.forms[0].Req_locn_code.value = reqLocnArr[0];\n\t\t\tparent.issue_detail.document.forms[0].Req_locn_iden.value = reqLocnArr[1];\tparent.issue_detail.document.forms[0].Req_locn_mr_locn.value = reqLocnArr[2];\t\n\n\t\t\tvar narrcode = reqLocnArr[3];\n\t\t\tif(narrcode == null || narrcode == \"null\")\tnarrcode = \"\";\n\t\t\tparent.issue_detail.document.forms[0].narration.value = narrcode;\n\n\t\t\tvar noofdays = reqLocnArr[4];\n\t\t\tif(noofdays == null || noofdays == \"null\")\tnoofdays = \"0\";\n\t\t\tparent.issue_detail.document.forms[0].No_Of_Days.value = noofdays;\n\t\t\tparent.issue_detail.document.forms[0].files.disabled = false;\n\t\t}\n\t</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String facility_id = (String) session.getValue("facility_id");
	
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	

	int x = 0;

	String selFacility	= request.getParameter("Facility");
	String selUser		= request.getParameter("User");
	String issueLocn	= request.getParameter("issueLocn");
	String selUserSecurity	= request.getParameter("userSecurity");

	try
	{
		String sql						= "";
		String Code						= "";
		String Desc						= "";
		String Code1					= "";
		String Desc1					= "";
		String LocnIden					= "";
		String LocnNarr					= "";
		String LocnMRyn					= "";
		String NoOfDays					= "";
		String access_all				= "";
		String moreCriteria				= "";
		String called_from				= "";	
		String primary_splty_long_desc	= "";	
		String pract_type_desc			= "";

		int record_count = 0;

		boolean present  = false;

		stmt = con.createStatement();
			
		 // from FMIssueFileManualEntry.jsp - function populateLocations(user)
		called_from = request.getParameter("called_from");
		if(called_from == null || called_from.equals("null")) called_from = "";
	
		if(called_from.equals("1"))
		{
			//sql = "SELECT pract_type_desc,primary_splty_long_desc FROM  am_practitioner_vw WHERE practitioner_id = ?";

			//sql = "SELECT a.pract_type_desc,a.primary_splty_long_desc FROM  am_practitioner_vw a, sm_appl_user b WHERE b.appl_user_id = ? and a.practitioner_id = b.func_role_id";
			sql = "SELECT"
					  +"  AM_GET_DESC.AM_PRACT_TYPE(A.PRACT_TYPE,'"+localeName+"','1') prAct_Type_desc"
					  +"  , AM_GET_DESC.AM_SPECIALITY(a.PRIMARY_SPECIALITY_CODE,'"+localeName+"','2') primary_splty_long_desc"
					  +"  , A.primary_speciality_code "
					  +"FROM"
					  +"  am_practitioner a"
					  +"  , sm_appl_user b "
					  +"WHERE b.apPl_User_Id = ? "
					  +"  AND a.Practitioner_Id = b.Func_Role_Id";

		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,selUser);
			rs  = pstmt.executeQuery();
			if(rs != null && rs.next())
			{
				pract_type_desc			= rs.getString("pract_type_desc"); 
				primary_splty_long_desc = rs.getString("primary_splty_long_desc");
				
				record_count++;
			}
			if(rs != null)	rs.close();
			if(pstmt != null) pstmt.close();
		
			if(pract_type_desc == null || pract_type_desc.equals("null")) pract_type_desc = "";
			if(primary_splty_long_desc == null || primary_splty_long_desc.equals("null"))
				primary_splty_long_desc = "";
		
			if(record_count != 0)
			{
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(primary_splty_long_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
			else 
			{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
		}		

		if(selUserSecurity == null || selUserSecurity.equals("null")|| selUserSecurity.equals(""))
			selUserSecurity = "N";

		if(selUserSecurity.equals("Y"))
		{
			sql = "";
			sql = "select 1 rec_cnt from fm_user_access_rights where appl_user_id = ? and facility_id = ? and (fs_locn_code = '*ALL' or manual_request_yn = 'Y') ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,selUser);
			pstmt.setString(2,selFacility);
			rs  = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				access_all = rs.getString("rec_cnt");
			}
			if(rs != null)	rs.close();
			if(pstmt != null) pstmt.close();

			if (access_all.equals("1"))
			{
				if(facility_id.equals(selFacility))
				   moreCriteria = " and FS_LOCN_CODE != '"+issueLocn+"' ";
				
				sql = "";
				//sql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, NARRATION_CODE, MR_LOCN_YN ,NO_OF_DAYS_TO_RETURN from FM_STORAGE_LOCN where FACILITY_ID = ? "+moreCriteria+" and EFF_STATUS = 'E' order by 2"; 	
				
				sql = "SELECT"
					  +"  FS_LOCN_CODE"
					  +"  ,fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"',2) SHORT_DESC"
					  +"  , LOCN_IDENTITY"
					  +"  , NARRATION_CODE"
					  +"  , MR_LOCN_YN"
					  +"  , NO_OF_DAYS_TO_RETURN "
					  +"FROM"
					  +"  FM_STORAGE_LOCN "
					  +" WHERE EFF_STATUS = 'E' "
					  +"  AND FACILITY_ID = ? "
					  +	moreCriteria
					 //  +"  AND LANGUAGE_ID='"+localeName+"' "
					  +"ORDER BY"
					  +" 2";


				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,selFacility);
			}
			else
			{
				if(facility_id.equals(selFacility))
				   moreCriteria = " AND REQ_YN = 'Y' and B.FS_LOCN_CODE != '"+issueLocn+"' ";
				else
				   moreCriteria = " AND REQ_ACROSS_FACILITIES_YN = 'Y' ";
				
				sql = "";
				//sql = "Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC SHORT_DESC, LOCN_IDENTITY, NARRATION_CODE, MR_LOCN_YN ,NO_OF_DAYS_TO_RETURN from FM_USER_ACCESS_RIGHTS_VW where FACILITY_ID = ? AND APPL_USER_ID = ? "+moreCriteria+" order by 2";
				sql = "SELECT"
				  +"  A.FS_LOCN_CODE"
				  +"  , ("
				  +"  CASE "
				  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
				  +"  THEN"
				  +"    '*ALL' "
				  +"  ELSE B.SHORT_DESC "
				  +"  END) SHORT_DESC"
				  +"  , B.LOCN_IDENTITY"
				  +"  , B.NARRATION_CODE"
				  +"  , B.MR_LOCN_YN"
				  +"  , B.NO_OF_DAYS_TO_RETURN "
				  +"FROM"
				  +"  FM_USER_ACCESS_RIGHTS A"
				  +"  , FM_STORAGE_LOCN_LANG_VW B "
				  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
				  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
				  +"  AND A.FACILITY_ID = ? "
				  +"  AND A.APPL_USER_ID = ? "
				  + moreCriteria
				  +"ORDER BY"
				  +"  2";

				
				if(pstmt != null) pstmt.close();

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,selFacility);
				pstmt.setString(2,selUser);
			}
		}
		else if(selUserSecurity.equals("N"))
		{
			if(facility_id.equals(selFacility))
			   moreCriteria = " and FS_LOCN_CODE != '"+issueLocn+"' ";
			
			sql = "";
			//sql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY, NARRATION_CODE, MR_LOCN_YN ,NO_OF_DAYS_TO_RETURN from FM_STORAGE_LOCN where FACILITY_ID = ? "+moreCriteria+" and EFF_STATUS = 'E' order by 2"; 
			sql = "SELECT"
				  +"  FS_LOCN_CODE"
				  +"  ,fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"',2) SHORT_DESC"
				  +"  , LOCN_IDENTITY"
				  +"  , NARRATION_CODE"
				  +"  , MR_LOCN_YN"
				  +"  , NO_OF_DAYS_TO_RETURN "
				  +"FROM"
				  +"  FM_STORAGE_LOCN "
				  +" WHERE EFF_STATUS = 'E' "
				  +"  AND FACILITY_ID = ? "
				  +	moreCriteria
				  	//  +"  AND LANGUAGE_ID='"+localeName+"' "
				  +"ORDER BY"
				  +"  2";

			
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,selFacility);
		}
		rs = pstmt.executeQuery();
		
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			if(selUserSecurity.equals("Y"))
			{
				if(access_all.equals("")){
					//out.println("parent.frames[2].document.forms[0].username1.value=''");
					out.println("alert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\"))");
				}
			}
			
            _bw.write(_wl_block13Bytes, _wl_block13);

		while(rs != null && rs.next())
		{
			present		= true;

			Code		= rs.getString("FS_LOCN_CODE");
			Desc		= rs.getString("SHORT_DESC");
			LocnIden	= rs.getString("LOCN_IDENTITY"); 
			LocnMRyn	= rs.getString("MR_LOCN_YN"); 
			LocnNarr	= rs.getString("NARRATION_CODE"); 
			NoOfDays	= rs.getString("NO_OF_DAYS_TO_RETURN"); 

			x++;
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(LocnIden));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(LocnMRyn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(LocnNarr));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(NoOfDays));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

		} if(rs != null) rs.close(); if(pstmt != null) pstmt.close();
		if(present)
		{
			sql = "";
			//sql = "Select NARRATION_CODE, SHORT_DESC from FM_NARRATION  where EFF_STATUS = 'E' order by 2";
			sql = "SELECT   NARRATION_CODE,SHORT_DESC FROM fm_narration_lang_vw WHERE    EFF_STATUS = 'E' AND LANGUAGE_ID='"+localeName+"' ORDER BY 2";

			rs = stmt.executeQuery(sql);
			while(rs != null && rs.next())
			{
				Code1 = rs.getString("NARRATION_CODE");
				Desc1 = rs.getString("SHORT_DESC");
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Code1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Desc1));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
		}
	if(rs != null)	 rs.close();
	if(stmt != null) stmt.close();
	if(pstmt != null) pstmt.close();
	}catch(Exception e){out.println("Main :"+e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(x));
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
