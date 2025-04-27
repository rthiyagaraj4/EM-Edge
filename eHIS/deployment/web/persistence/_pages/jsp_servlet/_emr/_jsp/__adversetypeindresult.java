package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __adversetypeindresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AdverseTypeIndResult.jsp", 1709118874110L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t\t<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\">\t</script>\n\t\t<script language=\'javascript\' src=\'../js/AdverseReaction.js\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\"JavaScript\" src=\"../js/eMRmessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t \n\t </head>\n\t<body  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onscroll=\'scrollTitle()\'>\n\t<form name=\'Adverse_event_result\' id=\'Adverse_event_result\' action=\'../../servlet/eMR.AdverseEventTypeServlet\' method=\'post\' target=\'messageFrame\' > \n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\' align=\'center\'>\n\t\t\t\t\t<th>Applicable Adverse Event Type Indicators&nbsp;<img id = \'IND_mand\' src = \'../../eCommon/images/mandatory.gif\'></th>\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' width=\'14%\' nowrap>&nbsp;";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" nowrap width=\'2%\'>&nbsp;<input type=\'checkbox\' id=\'check_box\'name=\'checkBox";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'onClick=\'javascript:checkBoxOnClick(this);\' value=\'\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" ><input type=\'hidden\' name=\'ret_value\' id=\'ret_value\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =",";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'></td>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'causative_code";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'causative_code";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'reaction_val";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'reaction_val";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'eff_status1\' id=\'eff_status1\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'fin_vals\' id=\'fin_vals\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'adv_reac_code\' id=\'adv_reac_code\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'adv_reac_long_desc\' id=\'adv_reac_long_desc\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'adv_reac_short_desc\' id=\'adv_reac_short_desc\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'eff_status\' id=\'eff_status\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'causative_code_val\' id=\'causative_code_val\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'reaction_fin_val\' id=\'reaction_fin_val\' value=\'\'>\n\n\t\t\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle	=	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		Connection conn = null;
		Statement stmt1=null;
		ResultSet rsas=null;
		ResultSet rs=null;
		String mode="";
		String checkBoxAttribute="";
		String ADV_REAC_CODE_1="";	
		String ADVR_TYPE="";
        String facilityId	=(String) session.getValue("facility_id");
	    facilityId	=(String) session.getValue("facility_id");
	    ADVR_TYPE=request.getParameter("ADVR_TYPE")==null?"":request.getParameter("ADVR_TYPE");	ADV_REAC_CODE_1=request.getParameter("ADV_REAC_CODE")==null?"":request.getParameter("ADV_REAC_CODE");
	mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	if(mode ==null || mode=="") mode="insert";
		 
            _bw.write(_wl_block5Bytes, _wl_block5);

			try
		{
 
				conn = ConnectionManager.getConnection(request);
				stmt1 = conn.createStatement();
				String causative_code="";
				String causative_desc="";
				String allow_one="";
				String allow_two="";
				String allow_three="";
				String allow_four="";
				String reaction_type="";
				String reaction_val="";
				int rowcolor=0;
				String classValue	 = "";
				String eff_status="";
				int k=0;
				int i=0;

				String sql_cnt="select count(*) count from MR_ALLERGEN ";
				rs=stmt1.executeQuery(sql_cnt);
				if(rs !=null && rs.next())
				{
					i = rs.getInt("count");
				}
				String sql_list="select A.ALLERGEN_CODE,A.long_desc,A.ADV_EVENT_TYPE_IND1_YN,A.ADV_EVENT_TYPE_IND2_YN, A.ADV_EVENT_TYPE_IND3_YN,A.ADV_EVENT_TYPE_IND4_YN,B.EFF_STATUS from MR_ALLERGEN A,MR_ADV_REA_CAUSE_AGENT  B where A.ADDED_FACILITY_ID='"+facilityId+"' AND A.ALLERGEN_CODE=B.ALLERGEN_CODE(+) and b.ADV_REAC_CODE(+)='"+ADV_REAC_CODE_1+"'  order by A.ADV_EVENT_TYPE_IND4_YN,A.ADV_EVENT_TYPE_IND3_YN ,A.ADV_EVENT_TYPE_IND2_YN,A.ADV_EVENT_TYPE_IND1_YN";
				rsas=stmt1.executeQuery(sql_list);
				if(rsas !=null )
				{
					while(rsas.next())
					{
							causative_code =	rsas.getString("ALLERGEN_CODE");
							causative_desc =	rsas.getString("long_desc");
							allow_one	   =	rsas.getString("ADV_EVENT_TYPE_IND1_YN");
							allow_two	   =	rsas.getString("ADV_EVENT_TYPE_IND2_YN");
							allow_three	   =	rsas.getString("ADV_EVENT_TYPE_IND3_YN");
							allow_four     =	rsas.getString("ADV_EVENT_TYPE_IND4_YN");
							eff_status     =    rsas.getString("EFF_STATUS");
							if(eff_status ==null) eff_status="";
							if(allow_one.equals("Y"))
							{
								reaction_type="Allergy";
								reaction_val="1";
							}else if(allow_two.equals("Y"))
							{
								reaction_type="Hypersensitivity Type II";
								reaction_val="2";
							}else if(allow_three.equals("Y"))
							{
								reaction_type="Hypersensitivity Type III";
								reaction_val="3";
							}else if(allow_four.equals("Y"))
							{	
								reaction_type="Hypersensitivity Type IV";
								reaction_val="4";
							}
							if(eff_status.equals("E"))
							{
								checkBoxAttribute="CHECKED";
							}else if(eff_status.equals("")){
								checkBoxAttribute="";

							}
							
						if ( rowcolor % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(causative_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(reaction_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(k));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(reaction_val));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(k));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(k));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(k));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(k));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(k));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(reaction_val));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
					k=k+1;
					rowcolor++;	
				  }
				}

			
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block23Bytes, _wl_block23);
}catch(Exception e)
	{

}
            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
