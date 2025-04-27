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

public final class __fmissuefilesheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFilesHeader.jsp", 1709116860875L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eFM/js/FMIssueFiles.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\t\tif(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"==getLabel(\'Common.hideMenu.label\',\'common\'))\n\t\t{\n\t\t\tparent.commontoolbarFrame.document.getElementById(\"home\").value= getLabel(\'Common.hideMenu.label\',\'common\');\n\t\t}\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body OnMouseDown=\"CodeArrest();\" onLoad=\"FocusFirstElement();\" onKeyDown = \'lockKey();\'>\n<form name=\'IssueFilesHeader\' id=\'IssueFilesHeader\'>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t<td width=\'25%\' class=\'fields\'>\n\t\t\t\t<select name=\'issuetype\' id=\'issuetype\' onChange=\'refresh();\'>\n\t\t\t\t\t<option value=\'SelectAll\'>------";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="------</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td width=\'25%\' class=\'fields\'>\n\t\t\t\t<input type=\'text\' size=\'30\' maxlength=\'30\' name=\'username1\' id=\'username1\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" readonly><input type=\'hidden\' size=\'30\' maxlength=\'30\' name=\'username\' id=\'username\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' readonly><input type=\'button\' name=\'searchuser\' id=\'searchuser\' value=\'?\' class=\'button\' valign=\'center\' onClick=\"searchIssueFileHeaderUser(username,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\t\t\t</td>\n\t      </tr>\n\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\n\t<input type=\"hidden\" name=\"issue_select\" id=\"issue_select\" value=\"N\">\n\t<input type=\"hidden\" name=\"file_doc\" id=\"file_doc\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"file_type_yn\" id=\"file_type_yn\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"print_tracer_card\" id=\"print_tracer_card\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"file_type_appl_yn\" id=\"file_type_appl_yn\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<INPUT type=\"hidden\" name=\"selected_tab\" id=\"selected_tab\" value=\"O\" >\n\t<INPUT type=\"hidden\" name=\"username_desc\" id=\"username_desc\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014 Start-->\n\t<input type=\'hidden\' name=\'issue_file_refresh_interval\' id=\'issue_file_refresh_interval\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\t\n\t<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014 End-->\n\t\n</form>\n<script>\n\tif(\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" == 1)\n\t{\t\n\t\tIssueFilesHeader.issuetype.options(1).selected = true;\n\t\trefresh();\n\t}\n\n\tfunction refresh() { \n\tvar strLocn = IssueFilesHeader.issuetype.value;\n\tif(strLocn == \"SelectAll\") \n\t{ \n\t\tparent.frames[2].location.href = \'../../eCommon/html/blank.html\';\n\t\tparent.frames[3].location.href = \'../../eCommon/html/blank.html\';\n\t}\n\telse\n\t{ \n\t\tif(parent.frames[1].document.forms[0].file_doc.value==\"F\") \n\t\t{\n\t\t\t// issue_file_refresh_interval Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014*/\n\t\t\tparent.frames[2].location.href = \'../../eFM/jsp/FMIssueFilesTab.jsp?userSecurity=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&resLocnIdentities=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&refresh=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&file_doc=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&file_type_yn=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&access_all=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&strLocn=\'+strLocn+\'&issue_file_refresh_interval=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\t\n\t\t\tparent.frames[1].document.forms[0].issuetype.disabled = true;\n\t    } \n\t    else if(parent.frames[1].document.forms[0].file_doc.value == \"D\") \n\t\t{\n\t\t   parent.frames[2].location.href = \'../../eFM/jsp/DTIssueFilesTab.jsp?userSecurity=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&strLocn=\'+strLocn;\n\t\t\tparent.frames[1].document.forms[0].issuetype.disabled = true;\n\t\t}\n\t}\n}\n</script>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


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
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	String prev_menu			= request.getParameter("prev_menu");	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            webbeans.eFM.FMFilesIssueCart FMIssueFilesCart= null;synchronized(session){
                FMIssueFilesCart=(webbeans.eFM.FMFilesIssueCart)pageContext.getAttribute("FMIssueFilesCart",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFilesCart==null){
                    FMIssueFilesCart=new webbeans.eFM.FMFilesIssueCart();
                    pageContext.setAttribute("FMIssueFilesCart",FMIssueFilesCart,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block8Bytes, _wl_block8);
            eFM.FMIssueFileAddBean FMIssueFileAddBean= null;synchronized(session){
                FMIssueFileAddBean=(eFM.FMIssueFileAddBean)pageContext.getAttribute("FMIssueFileAddBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFileAddBean==null){
                    FMIssueFileAddBean=new eFM.FMIssueFileAddBean();
                    pageContext.setAttribute("FMIssueFileAddBean",FMIssueFileAddBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(prev_menu));
            _bw.write(_wl_block10Bytes, _wl_block10);

	Connection con				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;

	ResultSet rs				 = null;
	
	String facility_id				= (String) session.getValue("facility_id");
	String user_id				= (String) session.getValue("login_user");

	String userSecurity		= request.getParameter("userSecurity");
	String resLocnIdentities	= request.getParameter("resLocnIdentities");
	String refresh				= request.getParameter("refresh");
	String file_doc				= request.getParameter("file_doc");	
	String file_type_yn			= request.getParameter("file_type_yn")==null?"N":request.getParameter("file_type_yn");
	String access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");
	String p_tracer_card_yn  = request.getParameter("p_tracer_card_yn")==null?"N":request.getParameter("p_tracer_card_yn");
	String issue_file_refresh_interval	= (request.getParameter("issue_file_refresh_interval")=="" || request.getParameter("issue_file_refresh_interval")==null)?"":request.getParameter("issue_file_refresh_interval"); /*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014*/

            _bw.write(_wl_block11Bytes, _wl_block11);

		String username			= "";
		String userButtAttr		= "";
		String sql				= "";
		String sql1				= "";		
        String value       ="";
		StringBuffer IssueFSLocnBuffer	= null;
		IssueFSLocnBuffer				= new StringBuffer();

		int selects = 0;

		try
		{
			FMIssueFilesCart.clearCart();
			FMIssueFileAddBean.clearCart();
				
			value=(String)session.getAttribute("username");
			if(value==null) value="";
			
			if(value.equals(""))
			{
			sql1= "SELECT apPl_User_Name FROM   sm_appl_user_lang_vw WHERE  apPl_User_Id = ? AND LANGUAGE_ID=?" ;
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,user_id);
			pstmt.setString(2,localeName);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				username = rs.getString("appl_user_name");
			
				}
					
				session.setAttribute("username",username);
			}else{
    username=value;
			}
			
			if(rs!=null)	rs.close();
			if(pstmt!=null) pstmt.close();
				
			if(userSecurity.equals("Y"))
			{
				userButtAttr = "Disabled";				
							
				if (access_all.equals("*ALL"))
				{
					
				//	sql = "SELECT FS_LOCN_CODE, SHORT_DESC FS_LOCN_SHORT_DESC FROM FM_STORAGE_LOCN_LANG_VW WHERE Facility_Id = '"+facility_id+"' 		 AND LANGUAGE_ID='"+localeName+"' AND eff_Status = 'E' AND PERMANENT_FILE_AREA_YN = 'Y' ORDER BY 2 ";
				
				sql = "SELECT   fs_locn_code, fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"', 2 ) fs_locn_short_desc  FROM fm_storage_locn  WHERE facility_id ='"+facility_id+"'  AND fs_locn_code LIKE '%%'      AND eff_status = 'E'     AND permanent_file_area_yn = 'Y' ORDER BY 2";
				
				}
				else
				{
					
					sql = "SELECT A.FS_LOCN_CODE, (CASE WHEN A.FS_LOCN_CODE = '*ALL' THEN '*ALL' ELSE B.SHORT_DESC END) FS_LOCN_SHORT_DESC FROM FM_USER_ACCESS_RIGHTS_VW A, FM_STORAGE_LOCN_LANG_VW B WHERE A.FACILITY_ID = B.FACILITY_ID(+) 	 AND B.LANGUAGE_ID='"+localeName+"' AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) AND A.Facility_Id = '"+facility_id+"'  AND (Iss_yn = 'Y' OR ISS_ACROSS_FACILITIES_YN = 'Y') AND A.PERMANENT_FILE_AREA_YN = 'Y' and a.APPL_USER_ID='"+user_id+"'   ORDER BY 2";
				}
			}
			else
			{
				
				//sql = "SELECT   FS_LOCN_CODE, SHORT_DESC FROM FM_STORAGE_LOCN_LANG_VW WHERE    Facility_Id = '"+facility_id+"' AND EFF_STATUS = 'E' AND  PERMANENT_FILE_AREA_YN = 'Y' AND LANGUAGE_ID='"+localeName+"' ORDER BY 2";
		    	sql = "SELECT   fs_locn_code, fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"', 2 ) fs_locn_short_desc  FROM fm_storage_locn  WHERE facility_id ='"+facility_id+"'  AND fs_locn_code LIKE '%%'      AND eff_status = 'E'     AND permanent_file_area_yn = 'Y'   ORDER BY 2";
			
			}
			
			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			
			while(rs != null && rs.next())
			 {
				selects++;
				String ID		= rs.getString(1);
				String desc	= rs.getString(2);
				IssueFSLocnBuffer.append("<option value='"+ID+"'>"+desc+"</option>");
			}

			
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(IssueFSLocnBuffer.toString()));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(username));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(userButtAttr));
            _bw.write(_wl_block20Bytes, _wl_block20);

	if((IssueFSLocnBuffer != null) && (IssueFSLocnBuffer.length() > 0))
	{
		IssueFSLocnBuffer.delete(0,IssueFSLocnBuffer.length());
	}
	
	if(rs!=null)	rs.close();
	if(pstmt!=null)	pstmt.close();

	}
	catch(Exception e)
	{
		out.println(e);
		e.printStackTrace();
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(file_doc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_tracer_card_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(username));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(issue_file_refresh_interval));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(selects));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(refresh));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(file_doc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(issue_file_refresh_interval));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(refresh));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(file_doc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.IssueFSLocation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.issuedby.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
