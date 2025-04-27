package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import blipin.*;
import java.util.*;

public final class __findcanceldischargeadvice extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FindCancelDischargeAdvice.jsp", 1743071615724L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- MOD#0A -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t<script>\n\t\t\t\t\t\t//alert(getMessage(\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'));\n\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\',\'BL\'));\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script> \n\nasync function findCancelDischargeAdvise(){\n\t\tvar frames_list = parent.frames[2].document.forms[0];\n\t\t if( frames_list.modal.value != \'yes\')\n\t\t    {   \n\t\t\t\tvar jsp_name1=frames_list.jsp_name.value;\n\t\t\t\tvar patient_id\t= \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\t\n\t\t\t\tvar encid\t\t= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\tvar practitioner_id = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\t\n\t\t\t\tvar call_function = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tvar sex = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\t\t\t\n\t\t\t\tvar IPval = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\t\t\n\t\t\t\tvar p_service_type = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"; \t\t\t\t\n\t\t\t\tvar function_id = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"; \t\n\t\t\t\tvar enable_height_bmi_pat_cls = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"; \t\n\t\t\t\n\t\t\t\tvar win_height=frames_list.win_height.value;\n\t\t\t\tif(win_height == \"\") win_height=\"70vh\";\n\t\t\t\t\n\t\t\t\tvar dialogTop=frames_list.dialogTop.value;\n\t\t\t\tif(dialogTop == \"\") dialogTop=\"80\";\t\t\t\t\n\t\t\t\t\n\t\t\t\tvar win_width=frames_list.win_width.value;\n\t\t\t\tif(win_width == \"\") win_width=\"40vw\";\n\t\t\t\t\n\t\t\t\tvar module1=frames_list.module.value;\n\t\t\t\tif(module1 == \"\") module1=\"eIP\";\n\t\t\t\t\n\t\t\t\tvar model_window=frames_list.model_window.value;\n\t\t\t\tif( model_window == \"\") model_window =\"\";\n\t\t\t\t\t\t\n\t\t\t\tif( model_window == \'NO\')\n\t\t\t\t{\n\t\t\t\tparent.parent.frames[1].document.location.href=\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_d+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex+\"&function_id=\"+function_id+\"&enable_height_bmi_pat_cls=\"+enable_height_bmi_pat_cls;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\tif( model_window == \'N\')\n\t\t\t\t{\n\t\t\t\tparent.frames[3].document.location.href=\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_id+\"&callfrom=IP&call_function=\"+call_function+\"&Sex=\"+sex+\"&function_id=\"+function_id+\"&enable_height_bmi_pat_cls=\"+enable_height_bmi_pat_cls;\n\t\t\t\t}\t\t\t\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"500px\";\n\t\t\t\t\tvar dialogWidth = \"700px\";\n\t\t\t\t\tvar dialogTop\t= \"72\";\n\t\t\t\t\tvar center = \"1\" ;\n\t\t\t\t\tvar status=\"no\";\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\tretVal = await window.showModalDialog(\"../../\"+module1+\"/jsp/\"+jsp_name1+\"?location_code=\"+IPval+\"&encounterId=\"+encid+\"&patientId=\"+patient_id+\"&Practitioner_Id=\"+practitioner_id+\"&callfrom=IP&call_function=\"+call_function+\"&p_service_type=\"+p_service_type.value+\"&Sex=\"+sex+\"&enable_height_bmi_pat_cls=\"+enable_height_bmi_pat_cls+\"&mode=modal&function_id=\"+function_id,arguments,features);\n\t\t\t\t\tparent.frames[2].document.location.reload();\t\n\t\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\twindow.parent.returnValue=enc;\n\t\t\twindow.parent.close();\n\t\t}\n}\nfindCancelDischargeAdvise();\n\t</script> \n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8"); 
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rsetBL = null;
	String bl_operational =	(String)session.getValue("bl_operational");
	con = ConnectionManager.getConnection(request);		
	String err_mesg = "";
	String disc_bill_exists = "";
	String disch_yn = "";
	String mode = request.getParameter("mode");
	if (mode==null) mode = "";

	String patient_id = request.getParameter("patient_Id");
	if (patient_id==null) patient_id = "";
	
	String encid		= request.getParameter("encounter_Id");
	if (encid==null) encid = "";

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
String function_id    = checkForNull(request.getParameter("function_id"));
String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
	CallableStatement cstmt = null;
	try 
	{
			// MOD#01 Billing starts here

			HttpSession httpSession = request.getSession(false);
			String facility_id = (String)httpSession.getValue("facility_id");
		 	
			stmt = con.createStatement();
		 	if ( bl_operational.equals("Y")) 
		 	{
		 		
		 		String episode_id = encid;
				rsetBL = stmt.executeQuery("SELECT BL_IP_DETAILS.GET_DISCHARGE_BILL_EXIST('"+facility_id+"',"+episode_id+") disc_bill_exists FROM dual");
				while(rsetBL.next())
				{
					disc_bill_exists = rsetBL.getString("disc_bill_exists");
					if(disc_bill_exists == null) disc_bill_exists = "";
				}
				if(rsetBL!=null) rsetBL.close();
				if(stmt!=null) stmt.close();
				if(disc_bill_exists.equals("Y"))
					err_mesg = "BL9311";

				if(err_mesg.equals("0"))
				{stmt = con.createStatement() ;
					rsetBL = stmt.executeQuery("SELECT BL_IP_DETAILS.GET_EPISODE_DISCHARGE_FLAG('"+facility_id+"',"+episode_id+") disch_yn FROM dual");
					while(rsetBL.next())
					{
						disch_yn = rsetBL.getString("disch_yn");
						if(disch_yn == null) disch_yn = "";
					}
					
					if(disch_yn.equals("Y"))
						err_mesg = "CANC_DISC_ADV_NOT_ALLOWED";
				}
				if(rsetBL!=null)rsetBL.close();
				if(stmt!=null)stmt.close();
		 		if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";				

				if(err_mesg.equals("0") || err_mesg.equals(""))
				{
					String billinSql =  "{call BL_IP_DETAILS.CHECK_FIN_CLEAR_DUR_IP_TRX(?,?,?,?)}";
					CallableStatement fileCreateCS = con.prepareCall(billinSql);
					fileCreateCS.setString(1, function_id);
					fileCreateCS.setString(2, facility_id);
					fileCreateCS.setString(3, episode_id);
					fileCreateCS.registerOutParameter( 4,java.sql.Types.VARCHAR);

					try{
						fileCreateCS.execute();
						err_mesg = fileCreateCS.getString(4);
						if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";

						

					 fileCreateCS.close();
					} catch(Exception e1) {
						e1.printStackTrace();
						
					} 
                }
			}

		   
	/* END MODIFICATION BY ARUN */
	
	if (err_mesg==null || err_mesg.equals("")) err_mesg = "0";
	if(!(err_mesg.equals("0")))
	{
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
			
		out.println("</head><body class='message' onMouseDown='CodeArrest()' onKeyDown='lockKey()'></body></html>");
		
		if (!err_mesg.substring(0,2).equals("**")) 
		 {
			
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(err_mesg));
            _bw.write(_wl_block4Bytes, _wl_block4);

		 }
		 else		
			out.println("<script>alert('"+err_mesg+"');</script>");			
	}
else
{ 
	out.println("<html><head>");
	out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>");
	
	out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script> <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> </head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' class='message'></body></html>");
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(encid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block14Bytes, _wl_block14);

}
		if (rs!=null) rs.close();
		if (cstmt!=null) cstmt.close();

	}catch (Exception e)
	{
		out.println("Exception "+e);
	}
	finally
	{	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
