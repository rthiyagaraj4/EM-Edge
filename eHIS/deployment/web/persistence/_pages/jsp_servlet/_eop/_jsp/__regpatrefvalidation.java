package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __regpatrefvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/RegPatRefValidation.jsp", 1709119477194L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n</head>\n<body class=\'MESSAGE\' onKeyDown = \'lockKey();\'>\t\t\t\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\tvar hcare_setting_type_desc=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\tvar hcare_setting_type=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\t\t\t\t\t\t\n\t\t   \n\t\t\t\t\t\tvar opt3=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt3.text=temp1;\n\t\t\t\t\t\topt3.value=hcare_setting_type+\"~\"+temp;     \n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_fm_ref_source.value=temp1;\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_fm_ref_source.disabled=true;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].referralfrm.disabled=true;\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].referral_source_lkp_bkup_text_frm.value=temp1;\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].referral_source_lkp_id_frm.value=hcare_setting_type+\"~\"+temp;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_fm_ref_source_code.value=temp;\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" != \"ReferredOutReport\"){\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].p_to_ref_source.value=temp1;\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].p_to_ref_source.disabled=true;\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].referralto.disabled=true;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].referral_source_lkp_bkup_text_to.value=temp1;\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].referral_source_lkp_id_to.value=hcare_setting_type+\"~\"+temp;\n\t\t\t\t\t\t\t\tparent.frames[1].document.forms[0].p_to_ref_source_code.value=temp;\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_hcare_type.disabled=false;\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_hcare_type.value=hcare_setting_type;\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_hcare_type.disabled=true;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\topt=document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].p_location_type_refto.add(opt);                         \n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale =((String)session.getAttribute("LOCALE"));
 request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String pr_id = request.getParameter("process_id");
	int process = Integer.parseInt(pr_id);
	Connection con = null;	
	PreparedStatement pstmt=null;
	ResultSet rs = null;	
		
	String loginfacility = (String) session.getValue("facility_id");	

	try
	{
		con = ConnectionManager.getConnection(request);
		
		if(process == 9)
		{
		 String ref_type = request.getParameter("ref_type");
		 if(ref_type==null) ref_type="";
		 String hcare_type_code = request.getParameter("hcare_type");
		 if(hcare_type_code==null) ref_type="";
		 String function_name = request.getParameter("function_name");
		 if(function_name==null) function_name="";
		 String referredtoid="";
		 String referredtodesc="";
		 String hcare_setting_type_desc="";
		 String hcare_setting_type="";
		 String locntypecode="";
		 String locntypedesc="";
		 String sql = "";
		 StringBuffer sql1= new StringBuffer();
		 
		if(ref_type.equals("X"))
		{
			
		}
		else if(ref_type.equals("E") || ref_type.equals("L"))
		{
		
			if(ref_type.equals("E"))
			{
            _bw.write(_wl_block8Bytes, _wl_block8);
				
				sql="SELECT a.FACILITY_ID referred_to_id ,a.FACILITY_NAME referred_to_id_desc   ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc FROM SM_FACILITY_PARAM_LANG_VW a  , AM_HCARE_SETTING_TYPE_LANG_VW b WHERE a.facility_id != '"+loginfacility+"'  AND a.hcare_setting_type_code='"+hcare_type_code+"'   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN (SELECT to_hcare_setting_type_code FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code = a.HCARE_SETTING_TYPE_CODE AND (ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id='"+locale+"'   AND b.language_id='"+locale+"' ORDER BY  a.facility_name";
			}
			else
			{
				sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' and a.facility_id='"+loginfacility+"' order by a.facility_name";
			}
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					referredtoid=rs.getString("referred_to_id");
					referredtodesc=rs.getString("referred_to_id_desc");
					hcare_setting_type_desc=rs.getString("hcare_setting_type_desc");
					hcare_setting_type=rs.getString("hcare_setting_type_code");
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(referredtoid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(referredtodesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(hcare_setting_type_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(hcare_setting_type));
            _bw.write(_wl_block13Bytes, _wl_block13);

						if(ref_type.equals("L"))
						{
						
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block15Bytes, _wl_block15);

						}
						
            _bw.write(_wl_block16Bytes, _wl_block16);

				}
			}	 
			if (rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
			
			if(function_name.equals("ReferredOutReport"))
			{
				int ip=0;
				int op=0;

			sql1.append("select locn_type,short_desc from am_care_locn_type_lang_vw  where ");

			if(ref_type.equals("E"))
			{
				
				sql="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct           decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";

				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs!=null)
				{
					if (rs.next())
					{
						ip=rs.getInt(1);
						op=rs.getInt(2);
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		

				if (ip> 0 )
				{
				   if (op > 0)
					{
					   sql1.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");
				
					}
					else
					{
						sql1.append(" care_locn_type_ind in ('N') and locn_type in('N') and ");				
					}
				}
				else
				{       
					if(op>0)
					{
						sql1.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
					
					}
				
				}
			} //main if ends here
			else{
					sql1.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");				
				}
			sql1.append(" sys_user_def_ind='S' and  language_id='"+locale+"' order by 2");


			pstmt=con.prepareStatement(sql1.toString());
			rs=pstmt.executeQuery();
			if(rs !=null)
			{
				while(rs.next())
				{
					locntypecode=rs.getString("locn_type");
					locntypedesc=rs.getString("short_desc");
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locntypecode));
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			sql1.setLength(0);
			}
	   }
	}
	}catch(Exception e){out.println(e);}
finally
{
	try{
			if(rs != null)		rs.close();			
			if(pstmt != null) pstmt.close();			
	}catch(Exception ee){}
	if(con != null) ConnectionManager.returnConnection(con,request);
}	
	
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
