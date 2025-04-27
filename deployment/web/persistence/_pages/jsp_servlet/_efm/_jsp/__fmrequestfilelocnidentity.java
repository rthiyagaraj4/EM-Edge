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

public final class __fmrequestfilelocnidentity extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMRequestFileLocnIdentity.jsp", 1709116870453L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 6/17/2002\n\tCreated By\t: Nanda Kumar R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Request File\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<HEAD>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'>\n\t<form name=\'testform\' id=\'testform\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\tvar Re_Flag=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\n\t\t\t\tif(Re_Flag==\"Report\")\t\t\n\t\t\t\t\t{\n                      parent.frames[2].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.clinic.label\",\"common\");\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t}else{\n\t\t\t\t      parent.frames[1].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.clinic.label\",\"common\");\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar Re_Flag=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\t\n\t\t\t\tif(Re_Flag==\"Report\")\t\n\t\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.nursingUnit.label\",\"common\");\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t}else{\n\t\t\t\t     parent.frames[1].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.nursingUnit.label\",\"common\");\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar Re_Flag=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\t\n\t\t\t\t      if(Re_Flag==\"Report\")\t\t\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[2].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.DaycareUnit.label\",\"common\");\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t\t  \n\t\t\t\t\t\t}else{\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.DaycareUnit.label\",\"common\");\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\tvar Re_Flag=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\t\n\t\t\t\t      if(Re_Flag==\"Report\")\t\t\n\t\t\t\t\t   {\n\t\t\t\t\t parent.frames[2].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.ProcedureUnit.label\",\"common\");\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t   \n\t\t\t\t\t   }else{\tparent.frames[1].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.ProcedureUnit.label\",\"common\");\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t   }\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\t\n\t\t\t\t      if(Re_Flag==\"Report\")\t\t\n\t\t\t\t\t   {\n\t\t\t\t\t  parent.frames[2].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.practitioner.label\",\"common\");\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t   }else{\n\t\t\t\t      parent.frames[1].document.getElementById(\"id1\").innerHTML=getLabel(\"Common.practitioner.label\",\"common\");\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting.disabled=false;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].requesting_btn.disabled=false;\n\t\t\t\t\t   }\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<script>\n\t\t\t\tvar p_req_yn\t\t= \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\tvar p_req_across_yn = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\t\t\t\t\n\t            var Re_Flag=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\t\n\t\t\t\tif(Re_Flag==\"Report\")\t\n\t\t\t{\n          if(p_req_yn==\'Y\' && p_req_across_yn==\'N\')\n\t\t\t\t{\t\t\t\t\t\tparent.searchResultFrame1.location.href=\'../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp?p_print_enter_fcy=N&selected_fcy=YN&p_chosen_fcy=L\';\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if (p_req_yn==\'N\' && p_req_across_yn==\'Y\')\n\t\t\t\t{\n\t\t\t\t\tparent.searchResultFrame1.location.href=\'../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp?p_print_enter_fcy=Y&selected_fcy=NY&p_chosen_fcy=E\';\n\t\t\t\t}\n\t\t\t\telse if (p_req_yn==\'Y\' && p_req_across_yn==\'Y\')\n\t\t\t\t{\n\t\t\t\t\tparent.searchResultFrame1.location.href=\'../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp?p_print_enter_fcy=N&selected_fcy=YY&p_chosen_fcy=L\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].logged_fcy.disabled=true;\n\t\t\t\t}\t\t\n\t\t\t\n\t\t\t\n\t\t\t}else{\n\t\t\t\tif(p_req_yn==\'Y\' && p_req_across_yn==\'N\')\n\t\t\t\t{\t\t\t\t\t\tparent.frames[2].document.location.href=\'../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=N&selected_fcy=YN&p_chosen_fcy=L\';\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if (p_req_yn==\'N\' && p_req_across_yn==\'Y\')\n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.location.href=\'../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=Y&selected_fcy=NY&p_chosen_fcy=E\';\n\t\t\t\t}\n\t\t\t\telse if (p_req_yn==\'Y\' && p_req_across_yn==\'Y\')\n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.location.href=\'../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=N&selected_fcy=YY&p_chosen_fcy=L\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.forms[0].logged_fcy.disabled=true;\n\t\t\t\t}\t\t\t\t\t\n\t\t\t}\n\t\t\t\t\t \t\t\t\n\t\t\tparent.frames[1].document.forms[0].req_narration.value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\';\n\t\t\t /* Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */\n\t\t\tif(parent.frames[1].document.forms[0].req_narration.options[parent.frames[1].document.forms[0].req_narration.selectedIndex].text.toLowerCase()==\'others\'){\n\t\t\t  parent.frames[1].document.getElementById(\"remark_visible\").style.visibility=\'visible\' \n\t         parent.frames[1].document.forms[0].reason.style.visibility=\'visible\'\n\t\t\t parent.frames[1].document.forms[0].mandatory.style.visibility=\'visible\'\n\t\t\t  parent.frames[1].document.forms[0].reason.value=\"\";\n\t\t\t} else {\n\t\t\t  parent.frames[1].document.getElementById(\"remark_visible\").style.visibility=\'hidden\' \n\t         parent.frames[1].document.forms[0].reason.style.visibility=\'hidden\'\n\t\t\t parent.frames[1].document.forms[0].mandatory.style.visibility=\'hidden\'\n\t\t\t}\n\t\t\t/* end ML-MMOH-CRF-0393-IN057159  */\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<script>\n\t\tparent.frames[1].document.forms[0].req_narration.value=\"\";\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);



	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	java.sql.Statement stmt		= null;
	java.sql.Statement stmt1	= null;	
	ResultSet rs				= null;
	ResultSet rs1				= null;	
	ResultSet rs3				= null;
	
	try
	{
		con	= ConnectionManager.getConnection(request);
		
		Properties p	= (Properties) session.getValue("jdbc");

		String fac_id		= (String) session.getValue("facility_id");
		String addedById	= p.getProperty("login_user");

		String storage_location	= request.getParameter("storage_location");
		String p_access_all		= request.getParameter("p_access_all");
		String fs_locn_code		= request.getParameter("fs_locn_code")==null?"":request.getParameter("fs_locn_code");
		String Re_Flag		= request.getParameter("Re_Flag")==null?"":request.getParameter("Re_Flag");
		String sql							= "";
		String sql1							= "";	
		String p_req_yn						= "";
		String p_req_across_yn				= "";
		String p_narration_desc				= "";
		String p_access_all_locn_identity	= "";

		stmt  = con.createStatement();
		stmt1 = con.createStatement();		

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		if(!(storage_location.equals("")))
		{
			if(!fs_locn_code.equals(""))
			{
				if(fs_locn_code.equals("C"))
				{
					
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Re_Flag));
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
				else if(fs_locn_code.equals("N"))
				{
					
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Re_Flag));
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
				else if(fs_locn_code.equals("Y"))
				{
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Re_Flag));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
				else if(fs_locn_code.equals("E"))
				{
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Re_Flag));
            _bw.write(_wl_block15Bytes, _wl_block15);

				}
				else if(fs_locn_code.equals("T"))
				{
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Re_Flag));
            _bw.write(_wl_block16Bytes, _wl_block16);

				}
			}

			sql  = "SELECT a.NARRATION_CODE ,permanent_file_area_yn FROM FM_STORAGE_LOCN a  WHERE  a.FS_LOCN_CODE='"+storage_location+"' and a.facility_id='"+fac_id+"' ";	
			rs  = stmt.executeQuery(sql) ;
			if( rs != null )
			{
				while (rs.next())
				{
					p_narration_desc= rs.getString( "NARRATION_CODE" )==null?"":rs.getString( "NARRATION_CODE" );
					p_access_all_locn_identity = rs.getString("permanent_file_area_yn")==null?"":rs.getString("permanent_file_area_yn");
				}
			}	
			if(rs!=null) rs.close();		
	
			if(p_access_all.equals("*ALL"))
			{	
				if(p_access_all_locn_identity.equals("Y"))
				{
					p_req_yn		=	"Y";
					p_req_across_yn	=	"Y";
							}
				else
				{
					p_req_yn		=	"Y";
					p_req_across_yn	=	"N";
				}
			}
			else
			{
				sql1 = "select req_yn,req_across_facilities_yn from fm_user_access_rights where facility_id='"+fac_id+"' and fs_locn_code='"+storage_location+"' and appl_user_id='"+addedById+"' ";

				rs1 = stmt1.executeQuery(sql1);

				if(rs1.next())
				{
					p_req_yn		= rs1.getString("req_yn");
					p_req_across_yn = rs1.getString("req_across_facilities_yn");
				}
					}
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_req_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_req_across_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Re_Flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_narration_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

		}
		else
		{ 
            _bw.write(_wl_block22Bytes, _wl_block22);
}	
		if(rs!=null)	rs.close();	
		if(rs1!=null)	rs1.close();	
		if(rs3!=null)	rs3.close();
		if(stmt!=null)  stmt.close();
		if(stmt1!=null) stmt1.close();		
	}
	catch( Exception e )
	{
		out.println("Exception e :"+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
