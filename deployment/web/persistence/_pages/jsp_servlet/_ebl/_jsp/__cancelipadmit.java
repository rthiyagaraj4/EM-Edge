package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __cancelipadmit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CancelIPAdmit.jsp", 1734521963710L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--,op.CurrencyFormat.*-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<script>\n\tasync function cancelIPadmit (){\n\tvar frames_list = parent.frames[2].document.forms[0];\n\tif( frames_list.modal.value != \'yes\')\n\t{   \n\t\tvar jsp_name1=frames_list.jsp_name.value;\n\t\t//var jsp_name1=\'addmodifyCancelDischargeAdvice\';\n\t\tvar patient_id\t= \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\t\n\n\t\tvar allowCancelAdmsn\t= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";//Added by Thamizh selvi on 22nd Feb 2017 against MMS-QH-CRF-0182\n\n\t\tvar encid\t\t= \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\tvar practitioner_id = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\n\t\tvar call_function = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\tvar sex = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\t\t\t\n\t\tvar IPval = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\t\t\n\t\tvar p_service_type = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"; \t\t\t\t\n\t\tvar win_height=frames_list.win_height.value;\n\t\tif(win_height == \"\") win_height=\"80vh\";\n\t\t\t\t\n\t\tvar dialogTop=frames_list.dialogTop.value;\n\t\tif(dialogTop == \"\") dialogTop=\"80\";\t\t\t\t\n\t\t\t\t\n\t\tvar win_width=frames_list.win_width.value;\n\t\tif(win_width == \"\") win_width=\"80vw\";\n\t\t\t\t\n\t\tvar module1=frames_list.module.value;\n\t\tif(module1 == \"\") module1=\"eIP\";\n\t\t\t\t\n\t\tvar model_window=frames_list.model_window.value;\n\t\tif( model_window == \"\") model_window =\"\";\n\t\t\t\t\t\t\n\t\tif( model_window == \'NO\')\n\t\t{\n\t\t\tparent.parent.frames[1].document.location.href=\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_d+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex;\n\t\t}\n\t\telse\n\t\tif( model_window == \'N\')\n\t\t{\n\t\t\tparent.frames[3].document.location.href=\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_id+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex;\n\t\t}\t\t\t\n\t\telse\n\t\t{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= win_height ;\n\t\t\tvar dialogWidth\t= win_width ;\n\t\t\tvar dialogTop = dialogTop;\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight: 80vh; scroll=no; dialogWidth: 80vw; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\n\t\t\tretVal = await window.showModalDialog(\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?location_code=\"+IPval+\"&encounterId=\"+encid+\"&allowCancelAdmsn=\"+allowCancelAdmsn+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_id+\"&callfrom=IP&call_function=\"+call_function+\"&p_service_type=\"+p_service_type.value+\"&Sex=\"+sex+\"&mode=modal\",arguments,features); //Added \"allowCancelAdmsn\" on 22nd Feb 2017 against MMS-QH-CRF-0182\n\t\t\tparent.frames[2].document.location.reload();\t\n\t\t\tparent.frames[3].document.location = \'../../eCommon/jsp/error.jsp\';\n\t\t}\n\t}\n\telse\n\t{\n\t\twindow.parent.returnValue=enc;\n\t\twindow.parent.close();\n\t}\n\t}\n\tcancelIPadmit();\n\t</script> \n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

	Connection con	= null;
	Statement stmt1 = null;
	ResultSet rs1	= null;
	Statement stmt2 = null;
	ResultSet rs2	= null;
	
try
{ 
	con = ConnectionManager.getConnection(request);
	request.setCharacterEncoding("UTF-8");
	//con = (Connection) session.getValue("connection" );
	stmt1=con.createStatement();
	stmt2=con.createStatement();	
	
	String err_mesg = "0";
	int v_cnt=0;
	int t_ctr=0;
	String err="";

	String facilityid = (String) session.getValue("facility_id");
	if (facilityid==null) facilityid = "";

	String mode = request.getParameter("mode");
	if (mode==null) mode = "";

	String patient_id = request.getParameter("patient_Id");
	if (patient_id==null) patient_id = "";
	
	String encid		= request.getParameter("encounter_Id");
	if (encid==null) encid = "";
	String encounter_id = encid; //encid.substring(4);

	String practitioner_id = request.getParameter("practitioner_Id");
	if (practitioner_id==null) practitioner_id ="";
	
	String call_function = request.getParameter("call_function");		
	if (call_function==null) call_function ="";

	String sex = request.getParameter("Sex");		
	if (sex==null) sex ="";
	
	String IPval = request.getParameter("IPval");		
	if (IPval==null) IPval ="";
	
	String p_service_type = request.getParameter("p_service_type");	
	if (p_service_type==null) p_service_type =""; 
	
	String allowCancelAdmsn = request.getParameter("allowCancelAdmsn");
	if (allowCancelAdmsn==null) allowCancelAdmsn ="N";//Added by Thamizh selvi on 22nd Feb 2017 against MMS-QH-CRF-0182
	
	/*
	*Commented Below Query and added the below one against 63756 - Rajesh V
	String query_bl_pat_charges_folio="select count(1) as v_cnt from bl_patient_charges_folio where operating_facility_id = '"+facilityid+"' and episode_type IN ('I','D') and patient_id='"+patient_id+"' and  episode_id='"+encounter_id+"' and nvl(trx_finalize_ind,'N') = 'Y' and nvl(trx_status,'N') != 'C'";
	*/
	String query_bl_pat_charges_folio = " SELECT COUNT (1) AS v_cnt "+
			" FROM bl_patient_charges_folio a "+
			  " WHERE operating_facility_id = '"+facilityid+"' "+
			  " AND episode_type IN ('I', 'D') "+
			  " AND patient_id = '"+patient_id+"' "+
			  " AND episode_id = '"+encounter_id+"' "+
			  " AND NVL (trx_finalize_ind, 'N') = 'Y' "+
			    " AND NVL (trx_status, 'N') != 'C' "+
			   "  AND (   module_id NOT IN ('ST', 'PH') "+ 
			"  OR (    module_id IN ('ST', 'PH') "+
			             " AND EXISTS ( "+
			                    " SELECT   1 "+
			                        " FROM bl_patient_charges_folio b "+
			                      "  WHERE a.sec_key_main = b.sec_key_main "+
			                        "  AND a.sec_key_line_no = b.sec_key_line_no "+
			                        "  AND a.operating_facility_id = b.operating_facility_id "+
			                         " AND a.patient_id = b.patient_id "+
			                         " AND a.episode_type = b.episode_type "+
			                         " AND a.episode_id = b.episode_id "+			                         
			                         " AND b.operating_facility_id = '"+facilityid+"' "+
			                         " AND b.patient_id = '"+patient_id+"' "+
			                         " AND b.episode_id = '"+encounter_id+"'  "+                  
			                         " HAVING SUM (b.serv_qty) > 0 "+
			                    " GROUP BY b.sec_key_main, b.sec_key_line_no) "+
			           " ) "+
			        " )  ";
	//out.println("query_bl_pat_charges_folio :"+query_bl_pat_charges_folio);
	System.out.println("query_bl_pat_charges_folio :"+query_bl_pat_charges_folio);
	rs1=stmt1.executeQuery(query_bl_pat_charges_folio);
	if(rs1.next())
	{
		v_cnt=rs1.getInt("v_cnt");
		
	}	

	if(v_cnt > 0)
	{
		err_mesg="1";
		err="Business Amt is greater than zero - Admission cannot be cancelled";
	
	}
	else
	{
		String query_bl_ins_track_dtls="select count(*) as t_ctr from bl_ins_track_dtls where operating_facility_id = '"+facilityid+"' and patient_id = '"+patient_id+"' and episode_type IN ('I','D') and episode_id = '"+encounter_id+"' and adm_status = 'C'";

		try
		{
			//out.println("query_bl_ins_track_dtls :"+query_bl_ins_track_dtls);
			rs2=stmt2.executeQuery(query_bl_ins_track_dtls);
			if(rs2.next())
			{
				t_ctr=rs2.getInt("t_ctr");
							
			}

			if(t_ctr > 1)
			{
				err_mesg="1";
				err="Admission cannot be cancelled - More than one entry in the credit authorization details";
				//out.println("<script>alert('Admission cannot be cancelled - More than one entry in the credit authorization details');</script>");
			}
		}
		catch(Exception ee)
		{
			out.println("Exception @query_bl_ins_track_dtls"+ee);
		}			
	}
	if (err_mesg==null) err_mesg = "0";
	if(!(err_mesg.equals("0")))
	{
		out.println("<html><head>");	
//		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css'/>");
		out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>");
//		out.println("<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>
		out.println("<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");	
		out.println("</head><body class='message'></body></html>");
		out.println("<script>alert('"+err+"');parent.frames[3].document.location = '../../eCommon/jsp/error.jsp';</script>");
	}
	else
	{ 
		out.println("<html><head>");
	//	out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css'/>");

		out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>");
		out.println("<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>");
		out.println("<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		out.println("</head><body class='message'></body></html>");
	
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(allowCancelAdmsn));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(encid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
}
catch(Exception ee)
{
	out.println("Exception @try2"+ee);
}
finally 
{
	if (rs1 != null)   rs1.close();
	if (rs2 != null)   rs2.close();
	if (stmt1 != null) stmt1.close();
	if (stmt2 != null) stmt2.close();
	ConnectionManager.returnConnection(con, request);
}

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
