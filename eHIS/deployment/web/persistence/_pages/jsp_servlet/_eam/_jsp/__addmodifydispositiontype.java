package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifydispositiontype extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/AddModifyDispositionType.jsp", 1709113962442L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<script>\nfunction Change() {\n if (dispositiontype_form.eff_status.checked == true)\n\tdispositiontype_form.eff_status.value=\"E\";\n else\n\tdispositiontype_form.eff_status.value=\"D\";\n}\nfunction Change2(obj) {\n if (obj.checked == true)\n\tobj.value=\"Y\";\n else\n\tobj.value=\"N\";\n}\nfunction changeCase(Obj)\n{\n\tObj.value=Obj.value.toUpperCase();\n\n}\n/*\nfunction checkForDeceasedIndicator(Obj)  //added by Sangeetha on 5-Jan-17 for ML-MMOH-CRF-0630\n{ \n\tif(Obj.checked == true)\n\t{\n\t\tdocument.forms[0].deceased_yn.checked = false;\n\t\n\t\tif(document.forms[0].isDidCallNotAroundDgnNotAppl.value == \'true\')  //Added by Mano aganist ML-MMOH-CRF-0783\n\t\t\tdocument.forms[0].callnotaround_yn.checked = false;             //Added by Mano aganist ML-MMOH-CRF-0783\n\t}\n}\n\nfunction checkForAbscondedIndicator(Obj)  //added by Sangeetha on 5-Jan-17 for ML-MMOH-CRF-0630\n{ \n\tif(Obj.checked == true)\n\t{\n\t\tdocument.forms[0].absconded_yn.checked = false;  //Added by Mano against ML-MMOH-CRF-0783\n\t\n\t\tif(document.forms[0].isDidCallNotAroundDgnNotAppl.value == \'true\') //Added by Mano aganist ML-MMOH-CRF-0783\n\t\t\tdocument.forms[0].callnotaround_yn.checked = false;            //Added by Mano aganist ML-MMOH-CRF-0783\n\t}\n}\n\nfunction checkForCallNotAroundIndicator(Obj)  //added by Mano against ML-MMOH-CRF-0783\n{\n\tif(Obj.checked == true)\n\t{\n\t\tdocument.forms[0].callnotaround_yn.checked = false;\n\t\tif(document.forms[0].isDidCallNotAroundDgnNotAppl.value == \'true\')  //Added by Mano aganist ML-MMOH-CRF-0783\n\t\t\tdocument.forms[0].callnotaround_yn.checked = false;             //Added by Mano aganist ML-MMOH-CRF-0783\n\t}\n} */\n //Below method added by Mano against ML-MMOH-CRF-0783 on 14-Nov-2017\nfunction checkForAll(Obj)\n{\n\tif(Obj.name == \"absconded_yn\")\n\t{\n\t\tif(Obj.checked == true)\n\t\t\t{\n\t\t\t\tdocument.forms[0].deceased_yn.checked = false;\n\t\t\t\tif(document.forms[0].isDidCallNotAroundDgnNotAppl.value== \'true\')\n\t\t\t\t\tdocument.forms[0].callnotaround_yn.checked = false;\n\t\t\t\t\n\t\t\t}\n\t\t\n\t}\n\telse\n\t\tif(Obj.name == \"deceased_yn\")\n\t\t{\n\t\t\tif(Obj.checked == true)\n\t\t\t{\n\t\t\t\tdocument.forms[0].absconded_yn.checked = false;\n\t\t\t\tif(document.forms[0].isDidCallNotAroundDgnNotAppl.value== \'true\')\n\t\t\t\t\tdocument.forms[0].callnotaround_yn.checked = false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(Obj.checked == true)\n\t\t\t{\n\t\t\t\tdocument.forms[0].absconded_yn.checked = false;\n\t\t\t\tif(document.forms[0].isDidCallNotAroundDgnNotAppl.value== \'true\')\n\t\t\t\t\tdocument.forms[0].deceased_yn.checked = false;\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t}\n\t\n\t\n\t\n\t\n}\n//End of ML-MMOH-CRF-0783\n\n</script>\n<html>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onLoad=\'FocusFirstElement()\'>\n<form name=\'dispositiontype_form\' id=\'dispositiontype_form\' action=\'../../servlet/eAM.DispositionTypeServlet\' method=\'post\' target=\'messageFrame\'> <div align=\'left\'><table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' width=\'auto\'><BR><BR><BR><BR><BR><BR>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<input type=\"hidden\" name=\"isDidCallNotAroundDgnNotAppl\" id=\"isDidCallNotAroundDgnNotAppl\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" >\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
*
*	Application		:	eAM
*   File Name       :	AddModifyDispositionType.jsp
*	
*
*	Created On		:	19-02-2005
*/

            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	request.setCharacterEncoding("UTF-8");
	String disp_type 	= request.getParameter("disp_type");

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rset = null;
    Boolean isDidCallNotAroundDgnNotAppl=false;
	try
		{
			conn = ConnectionManager.getConnection(request);
			isDidCallNotAroundDgnNotAppl = CommonBean.isSiteSpecific(conn, "AE", "DID_CALLNOTAROUND_NOT_REQ_DGN");
	if (disp_type == null)
	{
		out.println("<tr><td width='10%'>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td width='10%'>&nbsp;</td></tr>");

		/*out.println("<tr><td>&nbsp;</td><td align='right' width='40%' class='label'>Type</td><td width='60%' colspan='2'>&nbsp;&nbsp;");*/

		out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")+"</td><td class='fields'>&nbsp;&nbsp;");
		out.println("<input type='text'  onBlur='makeValidString(this);changeCase(this);' name='disp_type' id='disp_type' size='2' maxlength='2'  onKeyPress='return CheckForSpecChars(event)'  onBlur='ChangeUpperCase(this)'>");
		out.println("<img src='../../eCommon/images/mandatory.gif'></img>");
		out.println("</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td nowrap class='fields' >&nbsp;&nbsp;");
		out.println("<input type='text' onBlur='makeValidString(this)'  name='long_desc' id='long_desc' size='30' maxlength='30' style='{ font-size: ;}'>");
		out.println("<img src='../../eCommon/images/mandatory.gif'></img>");
		out.println("</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td class='fields' >&nbsp;&nbsp;");
		out.println("<input type='text' name='short_desc' id='short_desc' onBlur='makeValidString(this)'  size='15' maxlength='15'>");
		out.println("<img src='../../eCommon/images/mandatory.gif'></img>");
		out.println("</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.DeceasedIndicator.label","am_labels")+"</td><td   class='fields'>&nbsp;&nbsp;");
		out.println("<input type='checkbox' name='deceased_yn' id='deceased_yn' value='N' onClick='Change2(this);checkForAll(this)'>&nbsp;"); //added by Sangeetha for ML-MMOH-CRF-0630
		out.println("</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

        //Added by Sangeetha on 5-Jan-17 for ML-MMOH-CRF-0630
		out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AbscondedIndicator.label","am_labels")+"</td><td   class='fields'>&nbsp;&nbsp;");
		out.println("<input type='checkbox' name='absconded_yn' id='absconded_yn' value='N' onClick='Change2(this);checkForAll(this);'>&nbsp;");
		out.println("</td><td>&nbsp;</td></tr>");
		if(isDidCallNotAroundDgnNotAppl){
		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
		//Added by Mano against ML-MMOH-CRF-0783
		
		out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CallNotAroundIndicator.label","am_labels")+"</td><td   class='fields'>&nbsp;&nbsp;");
		out.println("<input type='checkbox' name='callnotaround_yn' id='callnotaround_yn' value='N' onClick='Change2(this);checkForAll(this);'>&nbsp;");
		out.println("</td><td>&nbsp;</td></tr>");
		}
		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseatVisitConclusion.label","am_labels")+"</td><td  class='fields'>&nbsp;&nbsp;");
		out.println("<input type='checkbox' name='use_at_concl_yn' id='use_at_concl_yn' value='Y' checked onClick='Change2(this)'>&nbsp;");
		out.println("</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseforMaternalDeath.label","am_labels")+"</td><td   class='fields'>&nbsp;&nbsp;");
		out.println("<input type='checkbox' name='use_at_disch_yn' id='use_at_disch_yn' value='Y'  onClick='Change2(this)'>&nbsp;");
		out.println("</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td   class='fields'>&nbsp;&nbsp;");
		out.println("<input type='checkbox' name='eff_status' id='eff_status' value='E' checked onClick='Change()'>&nbsp;");
		out.println("</td><td>&nbsp;</td></tr>");

		out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

		out.println("</table></div>");
		out.println("<input type='hidden' name='function' id='function' value='insert'>");
		out.println("<input type='hidden' name='function_name' id='function_name' value='insert'>");
	}
	else
	{
		
			String sql = "select disp_type,long_desc,short_desc, deceased_yn, use_at_concl_yn, use_at_disch_yn, eff_status, absconded_yn, callnotaround_yn from am_disposition_type where disp_type=?";   //Modified by Sangeetha on 6-Jan-2017 for ML-MMOH-CRF-0630
		
			pstmt1   = conn.prepareStatement(sql);
			pstmt1.setString	(	1,	disp_type		);
			rset = pstmt1.executeQuery();
			rset.next();

			//out.println("<BR><BR><BR><BR><BR><BR>");

			out.println("<tr><td width='10%'>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td width='10%'>&nbsp;</td></tr>");

			out.println( "<tr><td>&nbsp;</td><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")+"</td> <td class='fields' >&nbsp;&nbsp;&nbsp;<input type='text'  name='disp_type' id='disp_type' value=\""+ rset.getString("disp_type")+"\" size='2' maxlength='2' readonly >" ) ;
			out.println("<img src='../../eCommon/images/mandatory.gif'></img>  </td><td>&nbsp;</td></tr>");
			
			out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
			if ( rset.getString("eff_status").equals("E") )
			{
				out.println("<tr><td>&nbsp;</td><td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td nowrap class='fields'>&nbsp;&nbsp;&nbsp;<input type='text' onBlur='makeValidString(this)'  name='long_desc' id='long_desc' size='30' maxlength='30' value=\""+rset.getString("long_desc")+"\">");

				out.println("<img src='../../eCommon/images/mandatory.gif'></img></td><td>&nbsp;</td></tr>");
				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><td>&nbsp;</td><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td  >&nbsp;&nbsp;&nbsp;<input type='text'  onBlur='makeValidString(this)' name='short_desc' id='short_desc' size='15' maxlength='15' value=\"");
				out.println( rset.getString("short_desc"));

				out.println("\">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.DeceasedIndicator.label","am_labels")+"</td><td class='fields'>&nbsp;&nbsp;<input type='checkbox' name='deceased_yn' id='deceased_yn' value='"+rset.getString("deceased_yn")+"' ");

				/*out.println("<tr><td>&nbsp;</td><td   align='right' class='label'>Deceased Indicator</td><td align='left' class='label>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='deceased_yn' id='deceased_yn' value='"+rset.getString("deceased_yn")+"'");
*/
				/*out.println("<td>&nbsp;</td></tr>");*/

				if (rset.getString("deceased_yn").equals("Y"))
					out.println(" checked disabled ></td><td>&nbsp;</td></tr>");
				else
					out.println(" disabled ></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

                //Added by Sangeetha on 6-Jan-2017 for ML-MMOH-CRF-0630
				out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AbscondedIndicator.label","am_labels")+"</td><td class='fields'>&nbsp;&nbsp;<input type='checkbox' name='absconded_yn' id='absconded_yn' value='"+rset.getString("absconded_yn")+"' ");
				
				String abscn_yn1 = rset.getString("absconded_yn");
				if(abscn_yn1 == null || abscn_yn1.equals("null"))	
					abscn_yn1 = "N";
				
				if (abscn_yn1.equals("Y"))
					out.println(" checked disabled ></td><td>&nbsp;</td></tr>");
				else
					out.println(" disabled ></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
				
				//Added By Mano against ML-MMOH-CRF-0783
				if(isDidCallNotAroundDgnNotAppl){
				out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CallNotAroundIndicator.label","am_labels")+"</td><td class='fields'>&nbsp;&nbsp;<input type='checkbox' name='callnotaround_yn' id='callnotaround_yn' value='"+rset.getString("callnotaround_yn")+"' ");
				
				String callnotaround_yn1 = rset.getString("callnotaround_yn");
				if(callnotaround_yn1 == null || callnotaround_yn1.equals("null"))	
					callnotaround_yn1 = "N";
				
				if (callnotaround_yn1.equals("Y"))
					out.println(" checked disabled ></td><td>&nbsp;</td></tr>");
				else
					out.println(" disabled ></td><td>&nbsp;</td></tr>");
				
				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");
                }
				out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseatVisitConclusion.label","am_labels")+"</td><td  class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='use_at_concl_yn' id='use_at_concl_yn' value='"+rset.getString("use_at_concl_yn")+"' ");

				if (rset.getString("use_at_concl_yn").equals("Y"))
					out.println("checked onClick='Change2(this)'></td><td>&nbsp;</td></tr>");
				else
					out.println("onClick='Change2(this)'></td><td>&nbsp;</td></tr>");

			out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td    class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseforMaternalDeath.label","am_labels")+"</td><td  class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='use_at_disch_yn' id='use_at_disch_yn' value='"+rset.getString("use_at_disch_yn")+"'");

				if (rset.getString("use_at_disch_yn").equals("Y"))
					out.println("checked onClick='Change2(this)'></td><td>&nbsp;</td></tr>");
				else
					out.println("onClick='Change2(this)'></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td    class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td   class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E'");

				out.println("checked onClick='Change()'>");

				out.println("</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
			}
			if ( rset.getString("eff_status").equals("D") )
			{

				//out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td nowrap class='fields'>&nbsp;&nbsp;&nbsp;<input type='text' onBlur='makeValidString(this)' name='long_desc' id='long_desc' size='30' maxlength='30' value=\""+rset.getString("long_desc")+"\" readonly>");

				out.println("<img src='../../eCommon/images/mandatory.gif'></img></td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td class='fields' >&nbsp;&nbsp;&nbsp;<input type='text' onBlur='makeValidString(this)' name='short_desc' id='short_desc' size='15' maxlength='15' value=\"");
				out.println( rset.getString("short_desc"));

				out.println("\" readonly >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.DeceasedIndicator.label","am_labels")+"</td><td   class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='deceased_yn' id='deceased_yn' value='"+rset.getString("deceased_yn")+"'");

				if (rset.getString("deceased_yn").equals("Y"))
					out.println(" disabled checked></td><td>&nbsp;</td></tr>");
				else
					out.println(" disabled ></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

                //Added by Sangeetha on 6-Jan-2017 for ML-MMOH-CRF-0630
				out.println("<tr><td>&nbsp;</td><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AbscondedIndicator.label","am_labels")+"</td><td   class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='absconded_yn' id='absconded_yn' value='"+rset.getString("absconded_yn")+"'");
                
                String abscn_yn = rset.getString("absconded_yn");
				if(abscn_yn == null || abscn_yn.equals("null"))	
					abscn_yn = "N";

				if (abscn_yn.equals("Y"))
					out.println(" disabled checked></td><td>&nbsp;</td></tr>");
				else
					out.println(" disabled ></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseatVisitConclusion.label","am_labels")+"</td><td  class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='use_at_concl_yn' id='use_at_concl_yn' value='"+rset.getString("use_at_concl_yn")+"' disabled ");

				if (rset.getString("use_at_concl_yn").equals("Y"))
					out.println("checked></td><td>&nbsp;</td></tr>");
				else
					out.println("></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseforMaternalDeath.label","am_labels")+"</td><td  class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='use_at_disch_yn' id='use_at_disch_yn' value='"+rset.getString("use_at_disch_yn")+"' disabled");

				if (rset.getString("use_at_disch_yn").equals("Y"))
					out.println("checked></td><td>&nbsp;</td></tr>");
				else
					out.println("></td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

				out.println("<tr><td>&nbsp;</td><td   class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td  class='fields'>&nbsp;&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='D' onClick='Change(this)' ");

				out.println("></td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>  ");

				out.println("</table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'>");
			}
				if(rs!=null) 	rs.close();
				if(rset!=null) 	rset.close();
				if(stmt!=null) 	stmt.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();

		

	}
	}
		catch ( Exception e )
		{
			out.println(disp_type);
		}
		finally{
			
	     	ConnectionManager.returnConnection(conn,request);

		}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(isDidCallNotAroundDgnNotAppl));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
