package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patencbannerdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatEncBannerDetails.jsp", 1722948647498L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t\t<script src=\'../../eMP/js/PatEncBanner.js\' language=\'javascript\'></script>\n\t\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head>\n\t\t<body onKeyDown = \'lockKey();\'>\n\t\t<form name=\'patEncBannerDtlForm\' id=\'patEncBannerDtlForm\'>\n\t\t\t<table  align=\'center\' cellpadding=3 cellspacing=0 border=0 width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\' width=\'80%\'><input type=\'button\' class=\'button\' name=\'defaultBannerView\' id=\'defaultBannerView\' onclick=\"loadDefault()\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></td>\n\t\t\t\t\t<td align=\'right\'><input type=\'button\' class=\'button\' name=\'Preview\' id=\'Preview\' onclick=\"buildHTMLForPreviewBanner()\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></td>\n\t\t\t\t<tr>\n\t\t\t</table>\n\n\t\t\t<table  align=\'center\' cellpadding=3 cellspacing=0 border=1 width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<th colspan=\'5\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\n\t\t\t\t\t</th>\n\t\t\t\t\t<th colspan=\'3\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\t\t\n\t\t\t\t\t</th>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'CAFLOWSHEETLEVEL1\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class=\'CAFLOWSHEETLEVEL1\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'numOfRecs\' id=\'numOfRecs\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<input type=\'hidden\' name=\'bannerCateg\' id=\'bannerCateg\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=\'hidden\' name=\'bannerRef\' id=\'bannerRef\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=\'hidden\' name=\'bannerContent\' id=\'bannerContent\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'maxOrderForLine1\' id=\'maxOrderForLine1\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<input type=\'hidden\' name=\'maxOrderForLine2\' id=\'maxOrderForLine2\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=\'hidden\' name=\'firstClick\' id=\'firstClick\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'firstDispOrderVal\' id=\'firstDispOrderVal\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'cntLine1\' id=\'cntLine1\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=\'hidden\' name=\'cntLine2\' id=\'cntLine2\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<input type=\'hidden\' name=\'htmlContent\' id=\'htmlContent\' value=\'\'>\n\t\t<div id=\'linkLine\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");	
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String bannerCateg = request.getParameter("bannerCateg") == null ? "P" : request.getParameter("bannerCateg");
		String bannerRef = request.getParameter("bannerRef") == null ? "U01" : request.getParameter("bannerRef");
		String loadFirstTime = request.getParameter("loadFirstTime") == null ? "No" : request.getParameter("loadFirstTime");

		eMP.PatientBannerGroupLine patBannerGrpBean = null;

		patBannerGrpBean = (eMP.PatientBannerGroupLine)getObjectFromBean("patBannerGrpBean","eMP.PatientBannerGroupLine",session);
		if(loadFirstTime.equals("Yes"))
			patBannerGrpBean.clearBean();
    
            _bw.write(_wl_block6Bytes, _wl_block6);

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		String elementRef = "";
		String dispLine = "";
		String prevDispLine = "";
		String toolTip = "";
		String dispText = "";
		String elementDesc = "";
		String configYN = "N";
		String maxLength = "";
		String dispOrder = "";
		String dispLength = "";
		String defaultSelYN = "N";
		String defSel = "";
		String configYes = "";
		String configNo = "";
		String elementRefDef = "";
		String configReadOnly = "";
		String onblurFunc = "";
		String elmtRefForBean = "";
		String iconYN = "N";
		String imageName = "";
		String numOfSpaces = "0";
		String cntDtlRecs = "0";
		String maxOrderForLine1 = "0";
		String maxOrderForLine2 = "0";
		int i = 1;
		int cntLine1 = 0;
		int cntLine2 = 0;


		String sqlStr = "select a.ELMT_REF element_ref, a.display_length display_len, a.line_ref display_line, 	a.disp_ord display_order, a.tool_tip_text tool_tip,	a.prefix_label_text display_text, a.NUM_OF_SPACES no_of_spaces, b.ELMT_DESC element_desc, b.MAX_LENGTH 	max_length,b. DISP_LENGTH_CONFIG_YN config, b.DFLT_DISP_LENGTH default_disp_length, b.DFLT_LINE_REF 	default_disp_line,b.DFLT_DISP_ORD default_disp_order, 	b.DFLT_TOOL_TIP_TEXT 	default_tool_tip, b.DFLT_SEL_YN def_sel_yn, b.PREFIX_LABEL_TYPE prefix_label_type,b.ELMT_REF element_ref_def, b.ICON_BASED_YN icon_yn, b.IMAGE_NAME img_name from mp_pat_banner_dtl a, mp_pat_banner_elmt b	where a.BANNER_REF(+) = ? and a.BANNER_CATEG(+) = ? and a.ELMT_REF (+) = b.ELMT_REF and b.APPL_CATEG IN (?,'B') ORDER BY decode(b.ELMT_REF,'PAT_PHOTO',1,2), NVL2(a.line_ref,a.line_ref,b.dflt_line_ref), a.disp_ord, b.DFLT_DISP_ORD";

		String sqlCountDtl = "select count(*) from mp_pat_banner_dtl where BANNER_REF = ? and BANNER_CATEG in (?,'B')";
		
		try
		{
			con = ConnectionManager.getConnection(request);
			
			ps = con.prepareStatement(sqlCountDtl);
			ps.setString(1,bannerRef);
			ps.setString(2,bannerCateg);

			res = ps.executeQuery();
			while(res.next())
			{
				cntDtlRecs = res.getString(1) == null ? "0" : res.getString(1);
			}

			if(res != null) res.close();
			if(ps != null) ps.close();
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

					if(loadFirstTime.equals("Yes"))
					{							
						ps = con.prepareStatement(sqlStr);
						ps.setString(1,bannerRef);
						ps.setString(2,bannerCateg);
						ps.setString(3,bannerCateg);
						res = ps.executeQuery();

						while(res.next())
						{
							elementRef = res.getString("element_ref") == null ? "" : res.getString("element_ref");

							if(Integer.parseInt(cntDtlRecs) == 0)
								defaultSelYN = res.getString("def_sel_yn") == null ? "N" : res.getString("def_sel_yn");
							
							if(!elementRef.equals(""))
							{
								dispLength = res.getString("display_len") == null ? "0" : res.getString("display_len");
								dispLine = res.getString("display_line") == null ? "" : res.getString("display_line");
								//dispOrder = res.getString("display_order") == null ? "0" : res.getString("display_order");
								toolTip = res.getString("tool_tip") == null ? "" : res.getString("tool_tip");
								dispText = res.getString("display_text") == null ? "" : res.getString("display_text");
								if(Integer.parseInt(cntDtlRecs) > 0)
									defaultSelYN = "Y";									
							}
							else
							{
								dispLength = res.getString("default_disp_length") == null ? "0" : res.getString("default_disp_length");
								dispLine = res.getString("default_disp_line") == null ? "" : res.getString("default_disp_line");
								//dispOrder = res.getString("default_disp_order") == null ? "0" : res.getString("default_disp_order");
								toolTip = res.getString("default_tool_tip") == null ? "" : res.getString("default_tool_tip");
								dispText = res.getString("display_text") == null ? "" : res.getString("display_text");
								if(Integer.parseInt(cntDtlRecs) > 0)
									defaultSelYN = "N";
							}
							elementDesc = res.getString("element_desc") == null ? "" : res.getString("element_desc");
							maxLength = res.getString("max_length") == null ? "0" : res.getString("max_length");
							configYN = res.getString("config") == null ? "N" : res.getString("config");
							elementRefDef = res.getString("element_ref_def") == null ? "" : res.getString("element_ref_def");
							iconYN = res.getString("icon_yn") == null ? "N" : res.getString("icon_yn");
							numOfSpaces = res.getString("no_of_spaces") == null ? "0" : res.getString("no_of_spaces");
							imageName = res.getString("img_name") == null ? " " : res.getString("img_name");

							if(toolTip==null||toolTip.equals(" "))
								toolTip = "";

							if(dispText==null||dispText.equals(" "))
								dispText = "";

							if(!prevDispLine.equals(dispLine))
							{
								i = 1;
							}

							dispOrder = Integer.toString(i);

							if(elementRef.equals("")) elmtRefForBean = elementRefDef;
							else if(!elementRef.equals("")) elmtRefForBean = elementRef;
							
							if(defaultSelYN.equals("Y"))
								defSel = "checked";
							else 
								defSel = " ";

							if(configYN.equals("Y"))
							{
								//toolTip = elementDesc;
								//dispText = elementDesc;
								configReadOnly = "";
								onblurFunc = "onblur = \"addToBean(this,'"+dispLine+"','"+dispOrder+"')\" ";
							}
							else
							{
								configYes = "";
								configNo = "selected";
								configReadOnly = " readOnly ";
								onblurFunc = "";
							}
							
							if(!prevDispLine.equals(dispLine))
							{
								if(!prevDispLine.equals(""))
								{
									out.println("<tr style='display:none' id='hiddenTRForLine1'>");
									out.println("<td>&nbsp;</td>");
									out.println("<td><a href=\"javascript:changeDispOrder('"+prevDispLine+"')\">"+(Integer.parseInt(maxOrderForLine1)+1)+"</a></td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("<td>&nbsp;</td>");
									out.println("</tr>");
								}
								out.println("<tr>");
								out.println("<td class='CAFLOWSHEETLEVEL3' colspan='8'> Line "+dispLine+" </td>");
								out.println("</tr>");								
							}
							else
							{
								if(dispLine.equals("1")) maxOrderForLine1 = dispOrder;
								if(dispLine.equals("2")) maxOrderForLine2 = dispOrder;
							}

							out.println("<tr onMouseOver='hideToolTip();' id='id"+dispLine+"ForTr"+dispOrder+"'>");
							out.println("<td><input type='checkbox' name='defSelect"+i+"' id='defSelect"+i+"' id='def"+dispLine+"Sel"+dispOrder+"' "+defSel+" onclick='chkUnchkSel(\""+dispLine+"\",\""+dispOrder+"\",this)'></td>");
							if(dispOrder.equals("1") && dispLine.equals("1"))
								out.println("<td id='disp"+dispLine+"Order"+dispOrder+"'>"+dispOrder+"</td>");
							else
							out.println("<td id='disp"+dispLine+"Order"+dispOrder+"'><a href=\"javascript:changeColor('"+dispLine+"','"+dispOrder+"')\" >"+dispOrder+"</a></td>");

							if(dispOrder.equals("1") && dispLine.equals("1"))
								out.println("<td id='element"+dispLine+"Desc"+dispOrder+"' name='element"+dispLine+"Desc"+dispOrder+"' value='"+elementDesc+"'>"+elementDesc+"</td>");
							else
								out.println("<td onclick='javascript:showPopupForLines(\""+dispLine+"\",\""+dispOrder+"\",this)' id='element"+dispLine+"Desc"+dispOrder+"' name='element"+dispLine+"Desc"+dispOrder+"' value='"+elementDesc+"'><a href='javascript:'>"+elementDesc+"</a></td>");
							if(iconYN.equals("N"))
							{
								out.println("<td id='max"+dispLine+"Length"+dispOrder+"'>"+maxLength+"</td>");
								out.println("<td><input type='text' maxlength='3' size='2' id='disp"+dispLine+"Length"+dispOrder+"' value='"+dispLength+"' "+configReadOnly+" "+onblurFunc+" onkeypress=\"return allowNumbers(event)\"></td>");
							}
							else if(iconYN.equals("Y"))
							{
								out.println("<td colspan='2' align='center'><img src='../../eCommon/images/"+imageName+"'></td>");
								maxLength = " ";
								dispLength = " ";
							}
							out.println("<td><input type='text' size='4' maxLength='2' id='num"+dispLine+"Spaces"+dispOrder+"' "+onblurFunc+" value='"+numOfSpaces+"' onblur = \"addToBean(this,'"+dispLine+"','"+dispOrder+"')\" onkeypress=\"return allowNumbers(event)\"></td>");			
							
							out.println("<td><input type='text' maxlength='30' value='"+dispText+"' name='dispText"+i+"' id='dispText"+i+"' id='disp"+dispLine+"Text"+dispOrder+"' "+onblurFunc+" "+configReadOnly+"></td>");

							out.println("<td><input type='text' maxlength='60' value='"+toolTip+"' name='toolTip"+i+"' id='toolTip"+i+"' id='toolTip"+dispLine+"Text"+dispOrder+"' "+onblurFunc+" "+configReadOnly+"></td>");

							out.println("</tr>");
							out.println("<input type='hidden' name='dispOrder"+i+"' id='dispOrder"+i+"' value='"+dispOrder+"'>");
							out.println("<input type='hidden' name='dispLength"+i+"' id='dispLength"+i+"' value='"+dispLength+"'>");
							out.println("<input type='hidden' name='config"+dispLine+"Val"+dispOrder+"' id='config"+dispLine+"Val"+dispOrder+"' value='"+configYN+"'>");
							out.println("<input type='hidden' name='elmt"+dispLine+"Ref"+dispOrder+"' id='elmt"+dispLine+"Ref"+dispOrder+"' value='"+elmtRefForBean+"'>");
							out.println("<input type='hidden' name='icon"+dispLine+"YN"+dispOrder+"' id='icon"+dispLine+"YN"+dispOrder+"' value='"+iconYN+"'>");
							out.println("<input type='hidden' name='image"+dispLine+"Name"+dispOrder+"' id='image"+dispLine+"Name"+dispOrder+"' value='"+imageName+"'>");
							i++;
							prevDispLine = dispLine;
							
							if(toolTip.equals("")) toolTip = " ";
							if(dispText.equals("")) dispText = " ";
							if(dispLine.equals("1"))
							{
								patBannerGrpBean.addRecordstoLine1(dispLine+"`"+defSel+"`"+dispOrder+"`"+elementDesc+"`"+maxLength+"`"+dispLength+"`"+numOfSpaces+"`"+dispText+"`"+toolTip+"`"+configYN+"`"+elmtRefForBean+"`"+iconYN+"`"+imageName);
								cntLine1++;
							}
							else if(dispLine.equals("2"))
							{
								patBannerGrpBean.addRecordstoLine2(dispLine+"`"+defSel+"`"+dispOrder+"`"+elementDesc+"`"+maxLength+"`"+dispLength+"`"+numOfSpaces+"`"+dispText+"`"+toolTip+"`"+configYN+"`"+elmtRefForBean+"`"+iconYN+"`"+imageName);
								cntLine2++;
							}							
						}//end of while
						putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);

						out.println("<tr style='display:none' id='hiddenTRForLine2'>");
						out.println("<td>&nbsp;</td>");
						out.println("<td><a href=\"javascript:changeDispOrder('"+dispLine+"')\">"+(Integer.parseInt(maxOrderForLine2)+1)+"</a></td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("<td>&nbsp;</td>");
						out.println("</tr>");
					}//end of if loadFirstTime					
					else
					{
						String displayLineNum = "";
						String defaultSelect = "";
						String displayOrderNum = "";
						String elementDescription = "";
						String actualLength = "";
						String displayLength = "";
						String displayText = "";
						String toolTipText = "";
						String arrValues = "";
						String configValue = "";
						prevDispLine = "";

						try
						{						
							ArrayList list1 = patBannerGrpBean.returnList1();
							ArrayList list2 = patBannerGrpBean.returnList2();

							StringTokenizer strTok = null;

							for(int j=0;j<list1.size();j++)
							{
								arrValues = (String) list1.get(j);
								strTok = new StringTokenizer(arrValues,"`");
								while(strTok.hasMoreTokens())
								{
									displayLineNum = (String)strTok.nextToken();
									defaultSelect = (String)strTok.nextToken();
									displayOrderNum = (String)strTok.nextToken();
									elementDescription = (String)strTok.nextToken();
									actualLength = (String)strTok.nextToken(); 
									displayLength = (String)strTok.nextToken();
									numOfSpaces = (String)strTok.nextToken();
									displayText = (String)strTok.nextToken();
									toolTipText = (String)strTok.nextToken();
									configValue = (String)strTok.nextToken();
									elmtRefForBean = (String)strTok.nextToken();
									iconYN = (String)strTok.nextToken();
									imageName = (String)strTok.nextToken();

									if(toolTipText==null||toolTipText.equals(" "))
										toolTipText = "";

									if(displayText==null||displayText.equals(" "))
										displayText = "";

									if(configValue.equals("Y"))
									{
										configReadOnly = "";
										onblurFunc = "onblur = \"addToBean(this,'"+displayLineNum+"','"+displayOrderNum+"')\" ";
									}
									else if(configValue.equals("N"))
									{
										configReadOnly = " readOnly ";
										onblurFunc = "";
									}

									if(!prevDispLine.equals(displayLineNum))
									{
										out.println("<tr>");
										out.println("<td class='CAFLOWSHEETLEVEL3' colspan='8'> Line "+displayLineNum+" </td>");
										out.println("</tr>");
									}
									else
									{
										if(displayLineNum.equals("1")) maxOrderForLine1 = displayOrderNum;
										if(displayLineNum.equals("2")) maxOrderForLine2 = displayOrderNum;
									}


									if(defaultSelect.equals("Y") || defaultSelect.equals("checked")) defSel = "checked";
									else defSel = "";

									out.println("<tr onMouseOver='hideToolTip();' id='id"+displayLineNum+"ForTr"+displayOrderNum+"'>");
									out.println("<td><input type='checkbox' id='def"+displayLineNum+"Sel"+displayOrderNum+"' "+defSel+" onclick='chkUnchkSel(\""+displayLineNum+"\",\""+displayOrderNum+"\",this)'></td>");
									if(displayOrderNum.equals("1"))
										out.println("<td id='disp"+displayLineNum+"Order"+displayOrderNum+"'>"+displayOrderNum+"</td>");
									else
										out.println("<td id='disp"+displayLineNum+"Order"+displayOrderNum+"'><a href=\"javascript:changeColor('"+displayLineNum+"','"+displayOrderNum+"')\" >"+displayOrderNum+"</a></td>");
									if(displayOrderNum.equals("1"))
										out.println("<td id='element"+displayLineNum+"Desc"+displayOrderNum+"'>"+elementDescription+"</td>");
									else
										out.println("<td onclick='javascript:showPopupForLines(\""+displayLineNum+"\",\""+displayOrderNum+"\",this)' id='element"+displayLineNum+"Desc"+displayOrderNum+"' name='element"+displayLineNum+"Desc"+displayOrderNum+"' value='"+elementDescription+"'><a href='javascript:'>"+elementDescription+"</a></td>");
									if(iconYN.equals("N"))
									{
										out.println("<td id='max"+displayLineNum+"Length"+displayOrderNum+"'>"+actualLength+"</td>");
										out.println("<td><input type='text' maxlength='3' size='2' id='disp"+displayLineNum+"Length"+displayOrderNum+"' value='"+displayLength+"' "+configReadOnly+" "+onblurFunc+" "+configReadOnly+" onkeypress=\"return allowNumbers(event)\"></td>");
									}
									else
									{
										out.println("<td colspan='2' align='center'><img src='../../eCommon/images/"+imageName+"'></td>");
										actualLength = " ";
										displayLength = " ";
									}
									out.println("<td><input type='text' size='4' maxLength='2' id='num"+displayLineNum+"Spaces"+displayOrderNum+"' value='"+numOfSpaces+"' "+onblurFunc+" onkeypress=\"return allowNumbers(event)\" onblur = \"addToBean(this,'"+displayLineNum+"','"+displayOrderNum+"')\"></td>");
									out.println("<td><input type='text' maxlength='30' value='"+displayText+"' id='disp"+displayLineNum+"Text"+displayOrderNum+"' "+onblurFunc+" "+configReadOnly+"></td>");
									out.println("<td><input type='text' maxlength='60' value='"+toolTipText+"' id='toolTip"+displayLineNum+"Text"+displayOrderNum+"' "+onblurFunc+" "+configReadOnly+"></td>");
									out.println("</tr>");
									out.println("<input type='hidden' name='config"+displayLineNum+"Val"+displayOrderNum+"' id='config"+displayLineNum+"Val"+displayOrderNum+"' value='"+configValue+"'>");
									out.println("<input type='hidden' name='elmt"+displayLineNum+"Ref"+displayOrderNum+"' id='elmt"+displayLineNum+"Ref"+displayOrderNum+"' value='"+elmtRefForBean+"'>");
									out.println("<input type='hidden' name='icon"+displayLineNum+"YN"+displayOrderNum+"' id='icon"+displayLineNum+"YN"+displayOrderNum+"' value='"+iconYN+"'>");
									out.println("<input type='hidden' name='image"+displayLineNum+"Name"+displayOrderNum+"' id='image"+displayLineNum+"Name"+displayOrderNum+"' value='"+imageName+"'>");
								}//end of while
								prevDispLine = displayLineNum;
								cntLine1++;
							}//end of for
							out.println("<tr style='display:none' id='hiddenTRForLine1'>");
							out.println("<td>&nbsp;</td>");
							out.println("<td><a href=\"javascript:changeDispOrder('"+displayLineNum+"')\">"+(Integer.parseInt(maxOrderForLine1)+1)+"</a></td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("</tr>");

							for(int j=0;j<list2.size();j++)
							{
								arrValues = (String) list2.get(j);
								strTok = new StringTokenizer(arrValues,"`");
								while(strTok.hasMoreTokens())
								{
									displayLineNum = (String)strTok.nextToken();
									defaultSelect = (String)strTok.nextToken();
									displayOrderNum = (String)strTok.nextToken();
									elementDescription = (String)strTok.nextToken();
									actualLength = (String)strTok.nextToken(); 
									displayLength = (String)strTok.nextToken();
									numOfSpaces = (String)strTok.nextToken();
									displayText = (String)strTok.nextToken();
									toolTipText = (String)strTok.nextToken();
									configValue = (String)strTok.nextToken();
									elmtRefForBean = (String)strTok.nextToken();
									iconYN = (String)strTok.nextToken();
									imageName = (String)strTok.nextToken();

									if(toolTipText==null||toolTipText.equals(" "))
										toolTipText = "";

									if(displayText==null||displayText.equals(" "))
										displayText = "";

									if(configValue.equals("Y"))
									{
										configReadOnly = "";
										onblurFunc = "onblur = \"addToBean(this,'"+displayLineNum+"','"+displayOrderNum+"')\" ";
									}
									else if(configValue.equals("N"))
									{
										configReadOnly = " readOnly ";
										onblurFunc = "";
									}


									if(!prevDispLine.equals(displayLineNum))
									{
										out.println("<tr>");
										out.println("<td class='CAFLOWSHEETLEVEL3' colspan='8'> Line "+displayLineNum+" </td>");
										out.println("</tr>");
									}
									else
									{
										if(displayLineNum.equals("1")) maxOrderForLine1 = displayOrderNum;
										if(displayLineNum.equals("2")) maxOrderForLine2 = displayOrderNum;
									}

									if(defaultSelect.equals("Y") || defaultSelect.equals("checked")) defSel = "checked";
									else defSel = "";

									out.println("<tr onMouseOver='hideToolTip();' id='id"+displayLineNum+"ForTr"+displayOrderNum+"'>");
									out.println("<td><input type='checkbox' id='def"+displayLineNum+"Sel"+displayOrderNum+"' "+defSel+" onclick='chkUnchkSel(\""+displayLineNum+"\",\""+displayOrderNum+"\",this)'></td>");
									out.println("<td id='disp"+displayLineNum+"Order"+displayOrderNum+"'><a href=\"javascript:changeColor('"+displayLineNum+"','"+displayOrderNum+"')\" >"+displayOrderNum+"</a></td>");
									out.println("<td onclick='javascript:showPopupForLines(\""+displayLineNum+"\",\""+displayOrderNum+"\",this)' id='element"+displayLineNum+"Desc"+displayOrderNum+"'><a href='javascript:'>"+elementDescription+"</a></td>");
									if(iconYN.equals("N"))
									{
										out.println("<td id='max"+displayLineNum+"Length"+displayOrderNum+"'>"+actualLength+"</td>");
										out.println("<td><input type='text' maxlength='3' size='2' id='disp"+displayLineNum+"Length"+displayOrderNum+"' value='"+displayLength+"' "+configReadOnly+" "+onblurFunc+" "+configReadOnly+" onkeypress=\"return allowNumbers(event)\"></td>");
									}
									else
									{
										out.println("<td colspan='2' align='center'><img src='../../eCommon/images/"+imageName+"'></td>");
										actualLength = " ";
										displayLength = " ";
									}
									out.println("<td><input type='text' size='4' maxLength='2' id='num"+displayLineNum+"Spaces"+displayOrderNum+"' value='"+numOfSpaces+"' "+onblurFunc+" onkeypress=\"return allowNumbers(event)\" onblur = \"addToBean(this,'"+displayLineNum+"','"+displayOrderNum+"')\"></td>");
									out.println("<td><input type='text' maxlength='30' value='"+displayText+"' id='disp"+displayLineNum+"Text"+displayOrderNum+"' "+onblurFunc+" "+configReadOnly+"></td>");
									out.println("<td><input type='text' maxlength='60' value='"+toolTipText+"' id='toolTip"+displayLineNum+"Text"+displayOrderNum+"' "+onblurFunc+" "+configReadOnly+"></td>");
									out.println("</tr>");
									out.println("<input type='hidden' name='config"+displayLineNum+"Val"+displayOrderNum+"' id='config"+displayLineNum+"Val"+displayOrderNum+"' value='"+configValue+"'>");
									out.println("<input type='hidden' name='elmt"+displayLineNum+"Ref"+displayOrderNum+"' id='elmt"+displayLineNum+"Ref"+displayOrderNum+"' value='"+elmtRefForBean+"'>");
									out.println("<input type='hidden' name='icon"+displayLineNum+"YN"+displayOrderNum+"' id='icon"+displayLineNum+"YN"+displayOrderNum+"' value='"+iconYN+"'>");
									out.println("<input type='hidden' name='image"+displayLineNum+"Name"+displayOrderNum+"' id='image"+displayLineNum+"Name"+displayOrderNum+"' value='"+imageName+"'>");
								}//end of while
								prevDispLine = displayLineNum;
								cntLine2++;
							}
							out.println("<tr style='display:none' id='hiddenTRForLine2'>");
							out.println("<td>&nbsp;</td>");
							out.println("<td><a href=\"javascript:changeDispOrder('"+displayLineNum+"')\">"+(Integer.parseInt(maxOrderForLine2)+1)+"</a></td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("<td>&nbsp;</td>");
							out.println("</tr>");
						}//end of try
						catch(Exception ee)
						{
							//out.println("Exception in bean part of PatEncBannerDetails.jsp --"+ee.toString());
							ee.printStackTrace();
						}
					}//end of if loadFirstTime
				}//end of try
				catch(Exception e)
				{
					e.printStackTrace();
					
					//out.println("Exception in try of PatEncBannerDetails.jsp --"+e.toString());
				}//end of catch
				finally
				{
					if(res != null) res.close();
					if(ps != null) ps.close();
					if(con != null) ConnectionManager.returnConnection(con,request);
				}
				
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bannerCateg));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bannerRef));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(maxOrderForLine1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(maxOrderForLine2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cntLine1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cntLine2));
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ViewDefaultBanner.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PreviewBanner.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Values.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Legend.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DisplayOrder.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FieldName.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ActualLength.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DisplayLenght.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SpaceBeforeText.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.DisplayText.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ToolTipText.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
