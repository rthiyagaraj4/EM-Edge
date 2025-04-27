package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __recordpatientadverseeventview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordPatientAdverseEventView.jsp", 1740388282846L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\"../../eMR/js/RecordPatientAdverseEvent.js\"></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"allergen_view_form1\" id=\"allergen_view_form1\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}


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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rs			= null;

	//String locale					= (String)session.getAttribute("LOCALE");
	String facilityId				=	(String)session.getValue("facility_id");
	String allergen			        = checkForNull(request.getParameter("allergen"));
	String x_coordinate				= checkForNull(request.getParameter("x_coordinate"));
	String y_coordinate				= checkForNull(request.getParameter("y_coordinate"));
	String patient_id				= checkForNull(request.getParameter("patient_id"));
	String onset_date               = "";
	String last_reaction_date       = "";
	String reaction_desc            = "";
	String severity                 = "";
	String allergen_desc			="";
//out.println("<script>alert(\""+allergen+"\");</script>");

	try
	{
		StringBuffer sql	=	new StringBuffer();
		StringBuffer tooltipStr	=  new StringBuffer();
		int maxCount		= 0;

		sql.append("SELECT CASE WHEN a.allergen_code IS NOT NULl THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = 'en'),(SELECT long_desc FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = 'en')))END allergen, TO_CHAR (a.onset_date, 'dd/mm/yyyy') onset_date, TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') last_reaction_date,am_get_desc.am_reaction (g.reaction_code, 'en', '1') reac_desc,a.severity severity FROM pr_allergy_sensitivity a, am_reaction g, pr_adverse_event_reaction f WHERE a.allergen_code = '"+allergen+"' AND a.allergen_code = f.allergen_code AND a.patient_id = '"+patient_id+"' and a.PATIENT_ID=f.PATIENT_ID and a.ADV_EVENT_TYPE_IND=f.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=f.ADV_EVENT_TYPE and a.ALLERGEN_CODE=f.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO=f.ADV_EVENT_SRL_NO and a.REACTION_CODE_VALUES=g.reaction_code ");
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
		rs		=	stmt.executeQuery(sql.toString());
		while(rs.next())
		{
			if(maxCount==0)
			{
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Allergen.label","mr_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.onsetdate.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Last.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append("<br>");
			}
				 allergen_desc            = checkForNull(rs.getString("allergen"));
				 onset_date               = checkForNull(rs.getString("onset_date"));
				 last_reaction_date       = checkForNull(rs.getString("last_reaction_date"));
				 reaction_desc            = checkForNull(rs.getString("reac_desc"));
				 severity                 = checkForNull(rs.getString("severity"));
//out.println("<script>alert(\""+reaction_desc+"\");</script>");
				 tooltipStr.append(allergen);
				 tooltipStr.append("^^");
				 tooltipStr.append(onset_date);
				 tooltipStr.append("^^");
				 tooltipStr.append(last_reaction_date);
				 tooltipStr.append("^^");
				 tooltipStr.append(reaction_desc);
				 tooltipStr.append("^^");
				 tooltipStr.append(severity);
				 tooltipStr.append("^^");
				 tooltipStr.append("<br>");
				 maxCount++;
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		if(maxCount>0)
		{
			out.println("<script>displayToolTip(\""+tooltipStr.toString()+"\",\""+x_coordinate+"\",\""+y_coordinate+"\");</script>");
		
		}
	}
	catch(Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
