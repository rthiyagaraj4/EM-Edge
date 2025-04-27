package jsp_servlet._efm._jsp;

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
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmtransfilefrompopfslocn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMTransFileFromPopFSLocn.jsp", 1726141212000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 1/20/2003\n\tCreated By\t: Marayan Kumar K.R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Request File\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eFM/js/FMTransferFile.js\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<SCRIPT>\n\t\t\t\tvar len = parent.frames[1].document.forms[0].fromfslocn.length;\n\t\t\t\tfor (var i=0; i<=len; i++) \n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].fromfslocn.remove(\"fromfslocn\");\n\t\t\t\t}\n\t\t\t\tvar opt\t= parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\topt.value =\t\"\";\n\t\t\t\topt.text = \"      ----- \"+getLabel(\'Common.defaultSelect.label\',\'common\')+\" -----      \";\n\t\t\t\tparent.frames[1].document.forms[0].fromfslocn.add(opt);\n\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<SCRIPT>\n\t\t\t\tvar opt\t= parent.frames[1].document.createElement(\'OPTION\');\n\t\t\t\topt.value =\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tparent.frames[1].document.forms[0].fromfslocn.add(opt);\n\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<SCRIPT>\nparent.frames[1].document.forms[0].fromfslocn.options(1).selected = true;\n\tsetDisabled(parent.frames[1].document.forms[0].fromfslocn.value)\n\tvar Obj=parent.frames[1].document.forms[0].fromfslocn.value;\n\tvar identity = parent.frames[1].document.forms[0].FS_LOCN_ID.value; \n\tif(Obj == \'\') {\n\t\tparent.frames[1].document.forms[0].returning_desc.value=\'\';\n\t\tparent.frames[1].document.forms[0].returning_code.value=\'\';\n\t\tparent.frames[1].document.forms[0].returning_desc.disabled=true;\n\t\tparent.frames[1].document.forms[0].ret_button.disabled=true;\n\t}\n\telse  if(identity!=\"D\") {\n\t\tparent.frames[1].document.forms[0].returning_desc.disabled=false;\n\t\tparent.frames[1].document.forms[0].ret_button.disabled=false;\n\t}\n\t</SCRIPT>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<SCRIPT>\n\t\t\t\t\t\t\n\t\t\tvar flag=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t \tvar errors = getMessage(\'PATIENT_IS_NOT_INPATIENT\',\'FM\');\n\t\t\t\t\talert(errors);\n\t\t\t\t if(flag==\"Report_encdetails\")\n\t\t\t{\n          parent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t  parent.parent.frames[2].frames[3].document.forms[0].encounter_id.value=\"\";\n\t      parent.parent.frames[2].frames[3].document.forms[0].encounter_id.focus();\t\t\n               }else{\n\t\t\t\t parent.deficiency_header.FileDeficiencyMonitoring_header.encounter_id.value=\"\";\n\t\t\t\tparent.deficiency_header.FileDeficiencyMonitoring_header.encounter_id.focus();\n\t\t\t}\n\t\t\t</SCRIPT>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<SCRIPT>\n\tvar flag=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t if(flag==\"Report_encdetails\"){\n \n\t }else{\n\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t }\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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


            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	PreparedStatement pstmt1		= null;
	ResultSet rs1				= null;

	
	String userSecurity 				= "";
	String Dflt_archive_fs_locn_code	= "";
	String Dflt_lost_fs_locn_code		= "";
	String sql2							= "";
	String access_all					= "";
	String locn_code					= "";

	String enc_id						= "";
	String patient_id					= "";
	String flag                        ="";
//     String  fs_locn_code="";  checkstyle changes 35865

	String sql1							="";
	int count						=0;
   int cnt                           =0;
	try  
	{
		con	= ConnectionManager.getConnection(request);
		
		java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" );

		String facility_id		= (String) session.getValue( "facility_id" );
		String user_id			= p.getProperty( "login_user" );

		locn_code					= request.getParameter("locn_code");

		enc_id					= request.getParameter("enc_id");
		patient_id					= request.getParameter("patient_id");

	
		access_all					= request.getParameter("accessAll");
		userSecurity				= request.getParameter("userSecurity");
		Dflt_archive_fs_locn_code	= request.getParameter("Dflt_archive_fs_locn_code");
		Dflt_lost_fs_locn_code		= request.getParameter("Dflt_lost_fs_locn_code");
		flag                               = request.getParameter("flag");
		
		if(flag == null || flag.equals("null")) flag = "";
		if(enc_id == null || enc_id.equals("null")) enc_id = "";
		if(patient_id == null || patient_id.equals("null")) patient_id = "";
		if(locn_code == null || locn_code.equals("null")) locn_code = "";
		if(access_all == null || access_all.equals("null")) access_all = "";
		if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";
		if(Dflt_archive_fs_locn_code == null || Dflt_archive_fs_locn_code.equals("null")) 					Dflt_archive_fs_locn_code = "";
		if(Dflt_lost_fs_locn_code == null || Dflt_lost_fs_locn_code.equals("null")) 						Dflt_lost_fs_locn_code = "";

		
		 sql1="select encounter_id from pr_encounter where patient_id='"+patient_id+"' and encounter_id='"+enc_id+"'";	
		 		pstmt1 = con.prepareStatement(sql1);				
			rs1 = pstmt1.executeQuery();

		if(rs1 != null && rs1.next())
		{
			count ++;
			
		}
	
		if(!flag.equals("encounter_details") && !flag.equals("Report_encdetails") )
		{
				
	if(userSecurity.equals("Y")) 
		{
			
            _bw.write(_wl_block6Bytes, _wl_block6);

			if(access_all.equals("1")) 
			{
			//	sql2=" Select FS_LOCN_CODE,fm_get_desc.fm_storage_locn (facility_id,FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC from FM_STORAGE_LOCN where facility_id = ?  and LOCN_IDENTITY=? and EFF_STATUS = 'E' and LOCN_IDENTITY in ('C','N','T','E','Y') and (FS_LOCN_CODE != ? and FS_LOCN_CODE != ?)  Order by 2";
				
			sql2=" Select distinct a.fs_Locn_Code,fm_get_desc.fm_storage_locn (a.facility_id,a.fs_Locn_Code,'"+localeName+"',2 ) SHORT_DESC from fm_storage_locn_lang_vw a ,fm_User_Access_Rights b  where a.eff_Status = 'E' and  a.Facility_Id = b.Facility_Id   AND (a.fs_locn_code = b.fs_locn_code OR b.fs_locn_code = '*ALL') and   b.apPl_User_Id = '"+user_id+"' and b.TRANSFER_FILE_YN = 'Y' and a.facility_id = ?  and a.LOCN_IDENTITY=? and a.EFF_STATUS = 'E' and a.LOCN_IDENTITY in ('C','N','T','E','Y','D') and (a.FS_LOCN_CODE != ? and a.FS_LOCN_CODE != ?)  Order by 2";
				
				pstmt	= con.prepareStatement(sql2);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locn_code);
				pstmt.setString(3,Dflt_archive_fs_locn_code);
				pstmt.setString(4,Dflt_lost_fs_locn_code);
			//	pstmt.setString(4,locn_code);
			//	pstmt.setString(5,localeName);
					
			}
			else 
			{
				//sql2=" Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC SHORT_DESC from FM_USER_ACCESS_RIGHTS_VW Where facility_id = ? and appl_user_id =? and TRANSFER_FILE_YN = 'Y' and LOCN_IDENTITY in ('C','N','T','E','Y') and (FS_LOCN_CODE != ? and FS_LOCN_CODE != ?) AND LOCN_IDENTITY=? order by 2";
				sql2 = "SELECT distinct A.FS_LOCN_CODE ,  (CASE WHEN A.FS_LOCN_CODE = '*ALL' THEN   '*ALL'   ELSE B.SHORT_DESC  END) short_desc  FROM FM_USER_ACCESS_RIGHTS_VW A   , FM_STORAGE_LOCN_LANG_VW B  WHERE A.FACILITY_ID = B.FACILITY_ID(+) AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) AND A.FACILITY_ID = ? AND A.appl_user_id = ?  AND A.TRANSFER_FILE_YN = 'Y' AND A.LOCN_IDENTITY IN ('C','N','T','E','Y','D')  AND (A.FS_LOCN_CODE != ? AND A.FS_LOCN_CODE != ?) AND A.LOCN_IDENTITY=?  AND B.LANGUAGE_ID=?  ORDER BY 2 ";
			
				if(pstmt!=null) pstmt.close();
						
					
				pstmt	= con.prepareStatement(sql2);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);
				pstmt.setString(3,Dflt_archive_fs_locn_code);
				pstmt.setString(4,Dflt_lost_fs_locn_code);
				pstmt.setString(5,locn_code);
				pstmt.setString(6,localeName);
			}
		}
		else
		{
		//	sql2=" Select FS_LOCN_CODE,fm_get_desc.fm_storage_locn (facility_id,FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC from FM_STORAGE_LOCN where facility_id = ? AND LOCN_IDENTITY=?   and EFF_STATUS = 'E' and LOCN_IDENTITY in ('C','N','T','E','Y') and (FS_LOCN_CODE != ? and FS_LOCN_CODE != ?)  order by 2";
			
		sql2=" Select distinct a.fs_Locn_Code,fm_get_desc.fm_storage_locn (a.facility_id,a.fs_Locn_Code,'"+localeName+"',2 ) SHORT_DESC from fm_storage_locn_lang_vw a ,fm_User_Access_Rights b  where a.eff_Status = 'E' and  a.Facility_Id = b.Facility_Id   AND (a.fs_locn_code = b.fs_locn_code OR b.fs_locn_code = '*ALL') and   b.apPl_User_Id = '"+user_id+"' and b.TRANSFER_FILE_YN = 'Y' and a.facility_id = ?  and a.LOCN_IDENTITY=? and a.EFF_STATUS = 'E' and a.LOCN_IDENTITY in ('C','N','T','E','Y','D') and (a.FS_LOCN_CODE != ? and a.FS_LOCN_CODE != ?)  Order by 2";
			
			
			if(pstmt!=null) pstmt.close();
			
			pstmt	= con.prepareStatement(sql2);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locn_code);
			pstmt.setString(3,Dflt_archive_fs_locn_code);
			pstmt.setString(4,Dflt_lost_fs_locn_code);
		//	pstmt.setString(4,locn_code);
		//	pstmt.setString(5,localeName);
		}
		
		rs		= pstmt.executeQuery();

		while(rs != null && rs.next() ) 
		{
			cnt++;
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( rs.getString("fs_locn_code") ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( rs.getString("short_desc")));
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
	if(cnt==1)
			{ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}
	}else if(count>0)
		{

		}else{
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block12Bytes, _wl_block12);
			
		}

		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null)	rs1.close();
		if(pstmt1!=null) pstmt1.close();
	}catch(Exception e){out.println("Exception e :"+e);e.printStackTrace();}
	finally 
	{		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
