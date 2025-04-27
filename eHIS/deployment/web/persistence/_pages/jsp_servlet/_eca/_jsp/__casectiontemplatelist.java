package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __casectiontemplatelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CASectionTemplateList.jsp", 1732105276072L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!-- <modifeid by Arvind @09-12-2008> -->\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../js/SectionTemplate.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<center>\n<form name=\'CASectionTemplateListForm\' id=\'CASectionTemplateListForm\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t\t<table  class=\'grid\' width=\'100%\' border=\'1\' cellspacing=\'0\' cellpadding=\'3\' >\n\t\t<tr>\n\t\t\t<th class =\'columnheadercenter\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t<th class =\'columnheadercenter\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t</tr>\n\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t<tr>\n\t\t\t\t<!--IN061907 start-->\n\t\t\t\t<!--<td  class=\'gridData\' ><a class=\'gridLink\'  href =\'javascript:sendtoDetail(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\")\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a> <!-- added new parameter for GHL-CRF-0401 -->\n\t\t\t\t\n\t\t\t\t<td  class=\'gridData\' ><a class=\'gridLink\'  href =\'javascript:sendtoDetail(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<input type=\"hidden\" name=\"temp_title_value\" id=\"temp_title_value\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\t\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<td   class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<!--\t<td align=\'right\'  class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' nowrap><a href=\'javascript:PopUpShiftRow(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\");\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</a></td> -->\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<!--\t<td align=\'right\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' nowrap>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<td align=\'left\'  class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td> -->\n\t\t\t\t\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</table>\n</form>\n</center>\n</body>\n</html>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

		
	String replaceSpecialChar(String resultStr)
	{
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","&quot;");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","&#39;");
		if(resultStr.indexOf("<")!=-1)
			resultStr = resultStr.replaceAll("<","&lt;");
		if(resultStr.indexOf(">")!=-1)
			resultStr = resultStr.replaceAll("<","&gt;");
		
		return resultStr;
	}


	/*String replaceSpecialChar(String resultStr)
	{		
		while(resultStr.indexOf("\n")!=-1)
		{	
			int a=resultStr.indexOf("\n");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"~");
			resultStr=temp.toString();
			
		}

		while(resultStr.indexOf("\"")!=-1)
		{	
			int a=resultStr.indexOf("\"");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"&quot;");
			resultStr=temp.toString();
			
		}

		while(resultStr.indexOf("'")!=-1)
		{	
			int a=resultStr.indexOf("'");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"&#39;");
			resultStr=temp.toString();
			
		}
		while(resultStr.indexOf("<")!=-1)
		{	
			int a=resultStr.indexOf("<");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"&lt;");
			resultStr=temp.toString();
		}
		while(resultStr.indexOf(">")!=-1)
		{	
			int a=resultStr.indexOf(">");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"&gt;");
			resultStr=temp.toString();
		}

		return resultStr;
	}*/




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
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
29/06/2016	IN059630	Krishna	Gowtham	J							   			GHL-CRF-0401	
31/03/2017	IN061907	Krishna Gowtham J		26/02/2017		Ramesh G		ML-MMOH-CRF-0559		
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	String item_type			=	"",					title_id				=	"";
	String comp_id				=	"",					prompt_id				=	"";
	String prompt_display_loc	=	"",					section					=	"";
	String classValue			=	"",					srl_no					=	"";
	String comp_type			=	"",					age_group_code			=	"";
	String hist_rec_type		=	"",					list_selection			=	"";
	String list_presentation	=	"",					hint_text			=	"";
	String num_prefix_required_yn = "",					operation_mode			=	"";
	String shift_row_num		=	"",					curr_row_num			=	"";
	String mode					=	"",					formula_result_type		=	"";
	String event_code			=	"",					querychkrowpos			=	"";
	String acceptOption			=	"",					includeyn				=	"";
	String link_to_std_value_yn	=	"",					dflt_from_hist_appl_yn	=	"";
	String update_sql			=	"",					prompt_text				=	"";


	String old_hist_time_frame_unit	=	"",				old_hist_time_frame_val =	"";
	String formula_includes_date_yn	=	"",				formula_result_unit		=	"";
	String title_text				=	"",				hint_id					=	"";
//	String comp_prompt = "";
	String text_allign_yn			=	"N";
	String auto_result_yn			=	"N"; //IN061907 
	
	int row_pos_no = 0, column_pos_no = 0, no_of_col_span = 0,i=0;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet	rs = null;
	operation_mode = request.getParameter("operation_mode");
	section=request.getParameter("section");

	
	
	try
	{
		con = ConnectionManager.getConnection(request);	
	}
	catch(Exception e)
	{
		
		out.println("Exception@:"+e);
	}
	
	if(operation_mode==null) 
		operation_mode="";
/********************************/
String template_type="";
if((section !=null)&& (!section.equals(""))){
	try
		{
			String sql = "select template_type from ca_section_hdg where SEC_HDG_CODE=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,section);
			rs=pstmt.executeQuery();
//			Clob formula_def_clb = null;
			if(rs.next())
			{
				template_type = rs.getString(1);
				if (template_type == null) template_type="";

			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}
}
/********************************/
	if(operation_mode.equals("ShiftRow"))
	{
		shift_row_num  = request.getParameter("shift_row_num");
		curr_row_num   = request.getParameter("curr_row_num");
		mode		   = request.getParameter("mode");	
	    
		if(shift_row_num==null)shift_row_num="";
		if(curr_row_num==null)curr_row_num="";
		if(mode==null)mode="";
		
		int curr_row_no  = Integer.parseInt(curr_row_num);
		int shift_row_no = Integer.parseInt(shift_row_num);
		
		if(mode.equals("backward"))
		{
			int  curr_next_max_row_pos=0;

			querychkrowpos="select nvl(max(row_pos_no),0) curr_next_max_row_pos from ca_section_template where SEC_HDG_CODE=? and row_pos_no <?  ";
			pstmt	=	con.prepareStatement(querychkrowpos);

			pstmt.setString(1,section);
			pstmt.setString(2,curr_row_num);
			rs = pstmt.executeQuery();
			
			if (rs!=null)
			{
				if (rs.next())
					curr_next_max_row_pos=rs.getInt("curr_next_max_row_pos");
			}
			
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();

			if(curr_row_no-shift_row_no<curr_next_max_row_pos+1 )
				 out.println("<script>alert(getMessage('MIN_ROW_VAL','CA'))</script>");			
			else
			{
				update_sql="update ca_section_template set row_pos_no = row_pos_no - ? where sec_hdg_code = ? and row_pos_no >= ? ";
			}
		}
		else if(mode.equals("forward"))
		{
            int  curr_max_row_pos=0;

			querychkrowpos="select nvl(max(row_pos_no),99) curr_max_row_pos from ca_section_template where SEC_HDG_CODE=? ";

			pstmt	=	con.prepareStatement(querychkrowpos);
			pstmt.setString(1,section);
			rs = pstmt.executeQuery();
			
			if (rs!=null)
			{
				if (rs.next())
					curr_max_row_pos=rs.getInt("curr_max_row_pos");
			}

			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
	
			if(curr_max_row_pos+shift_row_no>99 )
				 out.println("<script>alert(getMessage('MAX_ROW_VAL','CA'))</script>");
			else
			{
				update_sql="update ca_section_template set row_pos_no = row_pos_no + ? where sec_hdg_code = ? and row_pos_no >= ? ";
			}
		}
	
		if(!(update_sql.equals("")))
		{
			try
			{
				if(pstmt != null)pstmt.close();
				con.setAutoCommit(false);
				pstmt	=	con.prepareStatement(update_sql);
				
				pstmt.setString(1,shift_row_num);
				pstmt.setString(2,section);
                pstmt.setString(3,curr_row_num);

				pstmt.executeUpdate();
				pstmt.close();
				String insertSQL=" update ca_section_hdg set TEMPLATE_FORMAT = empty_clob() where SEC_HDG_CODE=?";
				PreparedStatement ptmtInsert = con.prepareStatement(insertSQL);
				ptmtInsert.setString(1, section);
				ptmtInsert.executeUpdate();
				ptmtInsert.close();
				String sql = "Select TEMPLATE_FORMAT from ca_section_hdg  where SEC_HDG_CODE = ? for update "; 
				PreparedStatement ptmtInsert1 = con.prepareStatement(sql);
				ptmtInsert1.setString(1, section);					
				ResultSet rsInsert= ptmtInsert1.executeQuery() ;
				Clob clb = null;

				if(rsInsert!=null && rsInsert.next())
				{
					  clb = rsInsert.getClob(1);
				}
				//BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
				BufferedWriter w = new BufferedWriter(clb.setCharacterStream(0));
				eCA.SectionTemplateXMLDefinitionBean objBean = new eCA.SectionTemplateXMLDefinitionBean();
				StringBuffer XMLString=null;
				/***************/
				if((template_type==null) || (template_type.equals("")) ||(template_type.equals("B"))){
						XMLString=objBean.constructXML(con,section);
					}else{
						XMLString=objBean.constructTemplateTypeXML(con,section);
					}
				/***************/
				
				objBean = null;
				String removeSplChar=XMLString.toString();				
				w.write(removeSplChar,0,removeSplChar.length());				
				w.flush();
				w.close();
				rsInsert.close();
				ptmtInsert1.close();
				//ends here----------------			
				con.commit();
			}
			catch(Exception e)
			{
				con.rollback();
				//out.println("Exception in update query"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		}			
	}

	try
	{
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	
		if(section==null)section="";
		//String sql = " SELECT DECODE(ITEM_TYPE, 'C', 'Component/'||NVL(DECODE(COMP_TYPE, 'C', 'Check Box', 'D', 'Date', 'T', 'Time', 'I', 'Integer Numeric', 'L', 'List', 'N', 'Decimal Numeric', 'H', 'Short Text', 'F', 'Long Text', 'E', 'Datetime', 'P', 'Embedded', 'A','Formula','R','Grid Component','X', 'Matrix Component','M','Multi-List Component'),'System'), 'T', 'Title') ITEM_TYPE,COMP_ID, PROMPT_ID,CASE WHEN PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(PROMPT_ID,'en','2') ELSE COMP_PROMPT END PROMPT_TEXT, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, DECODE(PROMPT_DISPLAY_LOC, 'L', 'Left', 'T', 'Top', 'C', 'Center') PROMPT_DISPLAY_LOC, SRL_NO, COMP_TYPE, AGE_GROUP_CODE, HIST_REC_TYPE, NVL(ACCEPT_OPTION, 'O') ACCEPT_OPTION,list_presentation, list_selection, num_prefix_required_yn, HINT_ID,CASE WHEN HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(HINT_ID,'en','2') ELSE '' END HINT_TEXT,FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,nvl(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN,LINK_TO_STD_VALUE_YN ,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT,EVENT_CODE,TITLE_ID,CASE WHEN TITLE_ID IS NOT NULL then	CA_GET_DESC.CA_TEMPLATE_LABEL(TITLE_ID,'en','2')  ELSE TITLE_VALUE   END TITLE_TEXT  FROM CA_SECTION_DISCR_MSR_VW WHERE SEC_HDG_CODE=? ORDER BY ROW_POS_NO,COLUMN_POS_NO"; //IN059630_GHL-CRF-0401
		//IN061907 start
		//String sql = " SELECT DECODE(ITEM_TYPE, 'C', 'Component/'||NVL(DECODE(COMP_TYPE, 'C', 'Check Box', 'D', 'Date', 'T', 'Time', 'I', 'Integer Numeric', 'L', 'List', 'N', 'Decimal Numeric', 'H', 'Short Text', 'F', 'Long Text', 'E', 'Datetime', 'P', 'Embedded', 'A','Formula','R','Grid Component','X', 'Matrix Component','M','Multi-List Component'),'System'), 'T', 'Title') ITEM_TYPE,COMP_ID, PROMPT_ID,CASE WHEN PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(PROMPT_ID,'en','2') ELSE COMP_PROMPT END PROMPT_TEXT, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, DECODE(PROMPT_DISPLAY_LOC, 'L', 'Left', 'T', 'Top', 'C', 'Center') PROMPT_DISPLAY_LOC, SRL_NO, COMP_TYPE, AGE_GROUP_CODE, HIST_REC_TYPE, NVL(ACCEPT_OPTION, 'O') ACCEPT_OPTION,list_presentation, list_selection, num_prefix_required_yn, HINT_ID,CASE WHEN HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(HINT_ID,'en','2') ELSE '' END HINT_TEXT,FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,nvl(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN,LINK_TO_STD_VALUE_YN ,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT,EVENT_CODE,TITLE_ID,CASE WHEN TITLE_ID IS NOT NULL then	CA_GET_DESC.CA_TEMPLATE_LABEL(TITLE_ID,'en','2')  ELSE TITLE_VALUE   END TITLE_TEXT,TEXT_ALLIGN_YN  FROM CA_SECTION_DISCR_MSR_VW WHERE SEC_HDG_CODE=? ORDER BY ROW_POS_NO,COLUMN_POS_NO"; //IN059630_GHL-CRF-0401
		String sql = " SELECT DECODE(ITEM_TYPE, 'C', 'Component/'||NVL(DECODE(COMP_TYPE, 'C', 'Check Box', 'D', 'Date', 'T', 'Time', 'I', 'Integer Numeric', 'L', 'List', 'N', 'Decimal Numeric', 'H', 'Short Text', 'F', 'Long Text', 'E', 'Datetime', 'P', 'Embedded', 'A','Formula','R','Grid Component','X', 'Matrix Component','M','Multi-List Component'),'System'), 'T', 'Title') ITEM_TYPE,COMP_ID, PROMPT_ID,CASE WHEN PROMPT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(PROMPT_ID,'en','2') ELSE COMP_PROMPT END PROMPT_TEXT, ROW_POS_NO, COLUMN_POS_NO, NO_OF_COL_SPAN, DECODE(PROMPT_DISPLAY_LOC, 'L', 'Left', 'T', 'Top', 'C', 'Center') PROMPT_DISPLAY_LOC, SRL_NO, COMP_TYPE, AGE_GROUP_CODE, HIST_REC_TYPE, NVL(ACCEPT_OPTION, 'O') ACCEPT_OPTION,list_presentation, list_selection, num_prefix_required_yn, HINT_ID,CASE WHEN HINT_ID IS NOT NULL THEN CA_GET_DESC.CA_TEMPLATE_LABEL(HINT_ID,'en','2') ELSE '' END HINT_TEXT,FORMULA_RESULT_TYPE, FORMULA_INCLUDES_DATE_YN, FORMULA_RESULT_UNIT,nvl(INCLUDE_FOR_ANAL_YN,'N') INCLUDE_FOR_ANAL_YN,LINK_TO_STD_VALUE_YN ,DFLT_FROM_HIST_APPL_YN,OLD_HIST_TIME_FRAME_VAL,OLD_HIST_TIME_FRAME_UNIT,EVENT_CODE,TITLE_ID,CASE WHEN TITLE_ID IS NOT NULL then	CA_GET_DESC.CA_TEMPLATE_LABEL(TITLE_ID,'en','2')  ELSE TITLE_VALUE   END TITLE_TEXT,TEXT_ALLIGN_YN,AUTO_RESULT_YN  FROM CA_SECTION_DISCR_MSR_VW WHERE SEC_HDG_CODE=? ORDER BY ROW_POS_NO,COLUMN_POS_NO";
		//IN061907 ends
		pstmt	=	con.prepareStatement(sql);
		pstmt.setString(1,section);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			i++;
			if(i%2 != 0)
				classValue = "gridData";
			else
				classValue = "gridData";		

			item_type						=	rs.getString("ITEM_TYPE");	
			comp_id							=	rs.getString("COMP_ID")==null?"":rs.getString("COMP_ID");	

			prompt_id						=	rs.getString("PROMPT_ID")==null?"":rs.getString("PROMPT_ID");	
			title_id						=   rs.getString("TITLE_ID")==null?"":rs.getString("TITLE_ID");	
			hint_id							=   rs.getString("HINT_ID")==null?"":rs.getString("HINT_ID");	
			
			title_text						=	rs.getString("TITLE_TEXT")==null?"":rs.getString("TITLE_TEXT");	
			hint_text						=	rs.getString("HINT_TEXT")==null?"":rs.getString("HINT_TEXT");
			prompt_text						=	rs.getString("PROMPT_TEXT")==null?"":rs.getString("PROMPT_TEXT");

			row_pos_no						=	rs.getInt("ROW_POS_NO");	
			column_pos_no					=	rs.getInt("COLUMN_POS_NO");	
			no_of_col_span					=	rs.getInt("NO_OF_COL_SPAN");	
			prompt_display_loc				=	rs.getString("PROMPT_DISPLAY_LOC");	
			srl_no							=	rs.getString("SRL_NO");	
			comp_type						=	rs.getString("COMP_TYPE");
			age_group_code					=	rs.getString("AGE_GROUP_CODE")==null?"":rs.getString("AGE_GROUP_CODE");
			hist_rec_type					=	rs.getString("HIST_REC_TYPE")==null?"":rs.getString("HIST_REC_TYPE");
			acceptOption					=	rs.getString("ACCEPT_OPTION")==null?"":rs.getString("ACCEPT_OPTION");
			list_presentation				=	rs.getString("list_presentation")==null?"":rs.getString("list_presentation");
			list_selection					=	rs.getString("list_selection")==null?"":rs.getString("list_selection");

			num_prefix_required_yn			=	rs.getString("num_prefix_required_yn")==null?"":rs.getString("num_prefix_required_yn");
			formula_result_type				=	rs.getString("formula_result_type")==null?"":rs.getString("formula_result_type");
			formula_includes_date_yn		=	rs.getString("formula_includes_date_yn")==null?"":rs.getString("formula_includes_date_yn");
			formula_result_unit				=	rs.getString("formula_result_unit")==null?"":rs.getString("formula_result_unit");
			includeyn						=	rs.getString("INCLUDE_FOR_ANAL_YN")==null?"N":rs.getString("INCLUDE_FOR_ANAL_YN");
			link_to_std_value_yn			=	rs.getString("LINK_TO_STD_VALUE_YN")==null?"N":rs.getString("LINK_TO_STD_VALUE_YN");
			dflt_from_hist_appl_yn			=	rs.getString("DFLT_FROM_HIST_APPL_YN")==null?"N":rs.getString("DFLT_FROM_HIST_APPL_YN");
			old_hist_time_frame_unit		=	rs.getString("OLD_HIST_TIME_FRAME_UNIT")==null?"":rs.getString("OLD_HIST_TIME_FRAME_UNIT");
			old_hist_time_frame_val			=	rs.getString("OLD_HIST_TIME_FRAME_VAL")==null?"":rs.getString("OLD_HIST_TIME_FRAME_VAL");
			event_code						=	rs.getString("EVENT_CODE") == null ? "" : rs.getString("EVENT_CODE");
			text_allign_yn					=	rs.getString("TEXT_ALLIGN_YN"); //IN059630_GHL-CRF-0401
			auto_result_yn					= 	rs.getString("AUTO_RESULT_YN"); //IN061907	
			title_text = replaceSpecialChar(title_text);
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(item_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(title_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(title_text));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(comp_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prompt_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(row_pos_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(column_pos_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(no_of_col_span));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prompt_display_loc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(comp_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(acceptOption));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_selection));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_presentation));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(num_prefix_required_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hint_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(formula_result_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(formula_includes_date_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(formula_result_unit));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(includeyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(link_to_std_value_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dflt_from_hist_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(old_hist_time_frame_unit));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(old_hist_time_frame_val));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prompt_text));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(text_allign_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(item_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(title_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(title_text));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(comp_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prompt_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(row_pos_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(column_pos_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(no_of_col_span));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prompt_display_loc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(comp_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(acceptOption));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_selection));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(list_presentation));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(num_prefix_required_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hint_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(formula_result_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(formula_includes_date_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(formula_result_unit));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(includeyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(link_to_std_value_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dflt_from_hist_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(old_hist_time_frame_unit));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(old_hist_time_frame_val));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prompt_text));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(text_allign_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(auto_result_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(item_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(acceptOption.equals("R")?"<img src='../../eCommon/images/mandatory.gif' align='center'></img>":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(title_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
if(title_text.equals(""))
				{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				else
				{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(title_text));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
				if(prompt_text.equals(""))
				{
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
				else
				{
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(replaceSpecialChar(prompt_text)));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row_pos_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_pos_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
 String row_col_pos_loc = "<a class='gridLink'  href ='javascript:PopUpShiftRow("+row_pos_no+");'>"+ row_pos_no+"/"+column_pos_no+"/"+ no_of_col_span+"/"+ prompt_display_loc ;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_col_pos_loc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(no_of_col_span));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(prompt_display_loc));
            _bw.write(_wl_block32Bytes, _wl_block32);
} 		
			
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
	} // end of try
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception@1:"+e);//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block33Bytes, _wl_block33);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Itemtype.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TitleValue.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Component.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Row.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Column.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Span.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
