package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __assignrelationshipgetrelndtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AssignRelationshipGetRelnDtls.jsp", 1738042929874L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	String hyperLinkStartDate = "",hyperLinkEndDate="";
	String query_relationship_details = "", phys_prov_reln_id = "",modal = "";
	String expiry_based_yn = "",   exp_period="",start_date = "", end_date = "";

	String expiry_period="",expiry_rule="";
	modal = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	hyperLinkStartDate = request.getParameter("hyperLinkStartDate")==null?"":request.getParameter("hyperLinkStartDate");
	hyperLinkEndDate = request.getParameter("hyperLinkEndDate")==null?"":request.getParameter("hyperLinkEndDate");
//	out.println("<script>alert('hyperLinkStartDate"+hyperLinkStartDate+"');</script>");
//	out.println("<script>alert('hyperLinkEndDate"+hyperLinkEndDate+"');</script>");
	out.println("<html><head>");
	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css' /><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
	out.println("<script language='javascript'> var frmref = '';  if('"+modal+"' == 'Y') frmref =parent ; else frmref = top.content.workAreaFrame;");

	try
	{
		//con	=	(Connection) session.getValue("connection");
		con = ConnectionManager.getConnection(request);
		
		phys_prov_reln_id	=	request.getParameter("phys_prov_reln_id");
		
		if(phys_prov_reln_id==null) phys_prov_reln_id = "0";

		//out.println("alert('phys_prov_reln_id	: "+phys_prov_reln_id+"');");

		//query_relationship_details = " select expiry_based_yn, to_char(expiry_period)||decode(expiry_rule, 'DAE', ' Days After Effect', 'HAE', ' Hours After Effect', 'DAA', ' Days After Adm/Visit', 'HAA', ' Hours After Adm/Visit', 'DAT', ' Days After Transfer', 'HAT', ' Hours After Transfer', 'DAD', ' Days After Discharge', 'HAD', ' Hours After Discharge') expiry_rule, to_char(sysdate,'dd/mm/yyyy hh24:mi') start_date, to_char(decode(expiry_rule, 'DAE', sysdate+expiry_period, 'HAE',sysdate+expiry_period/24,null),'dd/mm/yyyy HH24:MI') end_date from CA_PRACT_RELN where pract_reln_id = ?";
		query_relationship_details=" select expiry_based_yn, to_char(expiry_period) expiry_period, expiry_rule, to_char(sysdate,'dd/mm/yyyy hh24:mi') start_date, to_char(decode(expiry_rule, 'DAE', sysdate+expiry_period, 'HAE',sysdate+expiry_period/24,null),'dd/mm/yyyy HH24:MI') end_date from CA_PRACT_RELN where pract_reln_id = ?";

		pstmt		=	con.prepareStatement(query_relationship_details);
		
		//out.println("<br>query_relationship_details	: "+query_relationship_details);
		//out.println("<br>phys_prov_reln_id : "+phys_prov_reln_id);
		//int int_phys_prov_reln_id = Integer.parseInt(phys_prov_reln_id);
		pstmt.setString(1, phys_prov_reln_id);

		rs	=	pstmt.executeQuery();

		//out.println("alert('frame name : '+frmref.frames[0].name);");

		while(rs.next())
		{
			expiry_based_yn	=	rs.getString("expiry_based_yn");
			expiry_period	=	rs.getString("expiry_period");
			exp_period		=	rs.getString("expiry_rule");
			start_date		=	rs.getString("start_date");
			end_date		=	rs.getString("end_date");

			if(expiry_based_yn==null)	expiry_based_yn	=	"N";
			if(exp_period==null)		exp_period		=	"";
			if(start_date==null)		start_date		=	"";
			if(end_date==null)			end_date		=	"";
			if(expiry_period==null)		expiry_period	=	"";

			if(!start_date.equals("&nbsp;") )
				start_date	= com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",locale);

			if(!end_date.equals("&nbsp;") )
				end_date	= com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale);


			if(exp_period.equals("DAE"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterEffect.label","ca_labels");

			if(exp_period.equals("HAE"))
				expiry_rule = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterEffect.label","ca_labels");

			if(exp_period.equals("DAA"))
				expiry_rule= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterAdmit.label","ca_labels");

			if(exp_period.equals("HAA"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterAdmit.label","ca_labels");

			if(exp_period.equals("DAT"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterTransfer.label","ca_labels");
				
			if(exp_period.equals("HAT"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterTransfer.label","ca_labels");

			if(exp_period.equals("DAD"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DayAfterDischarge.label","common_labels");

			if(exp_period.equals("HAD"))
				expiry_rule= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HourAfterDischarge.label","common_labels");

			expiry_rule = expiry_period + " " + expiry_rule;

			if(expiry_based_yn.equals("Y"))
			{
				out.println("frmref.AssignRelationshipFrame.document.forms[0].expiry_based_yn.checked = true; ");
			}
			else
			{
				out.println("frmref.AssignRelationshipFrame.document.forms[0].expiry_based_yn.checked = false; ");
			}
			out.println("frmref.AssignRelationshipFrame.document.forms[0].expiry_rule.value = '"+expiry_rule+"'; ");
			if(!hyperLinkStartDate.equals("")){
				out.println("frmref.AssignRelationshipFrame.document.forms[0].start_date.value = '"+hyperLinkStartDate+"'; ");			
			}else{
				out.println("frmref.AssignRelationshipFrame.document.forms[0].start_date.value = '"+start_date+"'; ");
			}

			if(!hyperLinkEndDate.equals("")){
				out.println("frmref.AssignRelationshipFrame.document.forms[0].end_date.value = '"+hyperLinkEndDate+"'; ");
			}else{
				out.println("frmref.AssignRelationshipFrame.document.forms[0].end_date.value = '"+end_date+"'; ");
			}
			out.println("frmref.AssignRelationshipFrame.document.forms[0].phys_prov_reln_id.value = '"+phys_prov_reln_id+"'; ");
			out.println("frmref.AssignRelationshipFrame.document.forms[0].currentDateTime.value = '"+start_date+"'; ");
		}
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in AssignRelationshipGetRelnDtls.jsp:"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language='JavaScript'></Script></head><body class='MESSAGE' onKeyDown='lockKey()'></body></html>");
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
