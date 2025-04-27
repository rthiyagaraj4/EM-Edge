package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __removemenurstrnforresp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/RemoveMenuRstrnForResp.jsp", 1742361761074L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t\t<script>\n\t\t\t\n\t\tfunction showSubfunctions(resp_id,module_id,menu_id,option_sequence_no,function_id,option_descriptor,num)\n\t\t{\n\t\t\t var retVal =    new String();\n\t\t\t var dialogHeight= \"15\" ;\n\t\t\t var dialogWidth = \"40\" ;\n\t\t\t var center = \"1\" ;\n\t\t\t var dialogTop = \"150\";\n\t\t\t var dialogLeft = \"155\";\n\t\t\t var status=\"no\";\n\t\t\t var features    = \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop + \"; dialogLeft :\" + dialogLeft;\n\t\t\t var arguments   = \"\" ;\n\t\t\t retVal = window.showModalDialog(\"../jsp/AddMenuRstrnForSubFunc.jsp?Step=Remove&ModuleID=\"+module_id+\"&MenuID=\"+menu_id+\"&OptionSequenceNo=\"+option_sequence_no+\"&FunctionID=\"+function_id+\"&FunctionVal=\"+option_descriptor+\"&Resp_id=\"+resp_id,arguments,features);\t\n\t\t}\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</head>\n\t<body  class=\'CONTENT\'  onKeyDown = \'lockKey()\'; OnMouseDown=\'CodeArrest()\'>\n\t<form name=\'form2\' id=\'form2\'>\n\t</head>\n\t<body  class=\'CONTENT\'  onKeyDown = \'lockKey()\'; OnMouseDown=\'CodeArrest()\'>\n\t<form name=\'form2\' id=\'form2\'>\n\t\t<b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b>\n\t\t<table border=1 cellspacing=0 cellpadding=0 align=center width=\'100%\'>\n\t\t<tr>\n\t\t<th rowspan=2 width=\'1%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t<th rowspan=2 width=\'1%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t<th rowspan=2 width=\'5%\' align=left>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th rowspan=2 width=\'20%\' align=left>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\n          <th width=\'2%\' align=left>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th rowspan=2 width=\'10%\' align=left>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t<th>&nbsp;I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;U&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;P&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Q&nbsp;</th>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'><input type=checkbox name=\'RE";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'RE";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' value=\'E";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' disabled></td>\n\t\t\t\t\t\n\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'><input type=checkbox name=\'RA";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'RA";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'Y";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' disabled></td>\n\n\t\t\t\t\t\n\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<td align=left class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><a href=\"javascript:showSubfunctions(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\n\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>&nbsp;&nbsp;<input type=checkbox name=\'RI\' id=\'RI\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" value=\'Y\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" disabled>&nbsp;&nbsp;\n\t\t\t\t\t<input type=checkbox name=\'RU";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'RU";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\'Y\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" disabled>&nbsp;&nbsp;\n\t\t\t\t\t<input type=checkbox name=\'RD";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'RD";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" disabled>&nbsp;&nbsp;\n\t\t\t\t\t<input type=checkbox name=\'RP";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'RP";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" disabled>&nbsp;&nbsp;\n\t\t\t\t\t<input type=checkbox name=\'RQ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'RQ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" disabled>&nbsp;&nbsp\n\n\t\t\t\t\t<td align=center class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t\t\t<input type=checkbox name=\'RC";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'RC";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\'Y\'>\n\t\t\t\t\t<input type=hidden name=\'RO";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'RO";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t\t<input type=hidden name=\'RM";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'RM";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t\t\t<input type=hidden name=\'RS";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'RS";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t<input id=\'menu_id\'  type=hidden name=\'menu_id\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t</table>\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

		request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

			Connection con=null;
			java.sql.Statement stmt = null;
			ResultSet rs =null;
			PreparedStatement pstmt = null;
			ResultSet prs =null;

			try{
			con = ConnectionManager.getConnection(request);
			stmt	=	con.createStatement();
			String resp_id=request.getParameter("resp_id");
			String menu_id=request.getParameter("menu_id");
			if (menu_id==null) menu_id="";
			
			String option_type_desc ="";

			String option_descriptor="";
			String option_sequence_no="";
			String option_type="";
			String excl_restrict_ind="";
			String module_id="";
			String function_id="";
			String submenu_id="";
			String insert_access_yn="";
			String update_access_yn="";
			String delete_access_yn="";
			String print_access_yn="";
			String query_only_access_yn="";
			String insert_checked="";
			String update_checked="";
			String delete_checked="";
			String print_checked="";
			String query_only_checked="";
			String insert_enabled="disabled";
			String update_enabled="disabled";
			String delete_enabled="disabled";
			String print_enabled="disabled";
			String query_enabled="disabled";

			String exclude_checked="";
			String rights_checked="";

			int num=0;
			int i=0;
			int j=1;
			String classValue = "" ;

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
			String sql_menu="Select menu_id,menu_name from sm_resp_vw where resp_id='"+resp_id+"'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_menu);
			if(rs!=null)
			{
				while(rs.next())
				{
					menu_id=rs.getString("menu_id");
					
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			StringBuffer sql_count=new StringBuffer();
			sql_count.append(" Select count(*) ");
			sql_count.append(" from SM_MENU_RSTRN_RESP_VW ");
			sql_count.append(" where RESP_ID='"+resp_id+"' ");
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql_count.toString());
			if(rs!=null)
				{
				while(rs.next()){
						i=rs.getInt(1);
					}
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			num=1;
			StringBuffer sql=new StringBuffer();
			sql.append(" Select OPTION_TYPE, OPTION_SEQUENCE_NO, ");
			sql.append(" EXCL_RESTRICT_IND, MODULE_ID, FUNCTION_ID, ");
			sql.append(" SUBMENU_ID, INSERT_ACCESS_YN, ");
			sql.append(" UPDATE_ACCESS_YN, DELETE_ACCESS_YN, ");
			sql.append(" PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN, OPTION_DESCRIPTOR , MENU_ID ");
			sql.append(" from SM_MENU_RSTRN_RESP_VW ");
			sql.append(" where RESP_ID='"+resp_id+"' ");
			sql.append(" ORDER BY OPTION_TYPE, OPTION_DESCRIPTOR");
		
			String menu_id1="";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());
			if(rs!=null)
			{
				while(rs.next() &&  j<=i )
				{
					if ( j % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					option_type=rs.getString(1);
					if(option_type.equals("M")) option_type_desc="Menu";
					else if(option_type.equals("F")) option_type_desc="Function";

					option_sequence_no=rs.getString(2);

					excl_restrict_ind=rs.getString(3);
					if( excl_restrict_ind.equals("E") ) 
					{
						exclude_checked="checked";
						rights_checked="";
					}
					else if(excl_restrict_ind.equals("R"))
					{
						exclude_checked="";
						rights_checked="checked";
					}

					module_id=rs.getString(4);
					function_id=rs.getString(5);
					submenu_id=rs.getString(6);

					insert_access_yn=rs.getString(7);
					if(insert_access_yn!=null)
					if(insert_access_yn.equals("Y"))
					{
						insert_checked="checked";
						insert_enabled="";
					}
					else{
					insert_checked="";
					insert_enabled="disabled";
										
					}
					
					update_access_yn=rs.getString(8);
					if( update_access_yn!=null)
					if( update_access_yn.equals("Y"))
					{
					update_checked="checked";
					update_enabled="";
					}
					else{
					update_checked="";
					update_enabled="disabled";
					}

					delete_access_yn=rs.getString(9);
					if(delete_access_yn!=null)
					if( delete_access_yn.equals("Y"))
					{
					delete_checked="checked";
					delete_enabled="";
					}
					else{
					delete_checked="";
					delete_enabled="disabled";
					
					}

					print_access_yn=rs.getString(10);
					if(print_access_yn!=null)
					if( print_access_yn.equals("Y"))
					{
					print_checked="checked";
					print_enabled="";
					}
					else{
					print_checked="";
					print_enabled="disabled";
					}

					query_only_access_yn=rs.getString(11);
					if(query_only_access_yn!=null)
					if( query_only_access_yn.equals("Y")){
					query_only_checked="checked";
					query_enabled="";
					}
					else{
					query_only_checked="";
					query_enabled="disabled";

					}

					option_descriptor=rs.getString(12);
					if(option_descriptor==null) option_descriptor="";

					menu_id1=rs.getString(13);
					if(menu_id1==null)menu_id1="";

					pstmt = con.prepareStatement("Select count(*) from SM_SFUNC_RSTRN_RESP Where RESP_ID = '"+resp_id+"'  and MENU_ID  = '"+menu_id1+"'  and OPTION_SEQUENCE_NO  = '"+option_sequence_no+"'  and MODULE_ID  = '"+module_id+"'  and FUNCTION_ID = '"+function_id+"' ");
					prs = pstmt.executeQuery();

					int rec_count = 0;
					if(prs.next())
					{
						rec_count = prs.getInt(1);
					}if(prs != null)  prs.close();
					if(pstmt != null)  pstmt.close();

					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(num));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(exclude_checked));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rights_checked));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(option_type_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
if(rec_count > 0){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(menu_id1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(option_sequence_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(option_descriptor));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(insert_checked));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(insert_enabled));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(num));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(update_checked));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(update_enabled));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(num));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(delete_checked));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(delete_enabled));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(print_checked));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(print_enabled));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(query_only_checked));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(query_enabled));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(num));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(num));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(num));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(option_sequence_no));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(num));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(num));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(menu_id1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(num));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(num));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(submenu_id));
            _bw.write(_wl_block55Bytes, _wl_block55);

					
					num++;
					j++;
				}
			}
			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
	
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block57Bytes, _wl_block57);

	if(rs != null)  rs.close();
	
	if(stmt != null)  stmt.close();
	

}catch(Exception e){out.println(e);}
finally 
{ 
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.RestrictedSubmenuFunctionDetls.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Exclude.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AccessRights.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.AccessLevel.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Remove.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
