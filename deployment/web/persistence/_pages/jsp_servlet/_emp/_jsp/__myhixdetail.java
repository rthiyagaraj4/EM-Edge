package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import eXH.*;

public final class __myhixdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/MyHixDetail.jsp", 1742537288166L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- Changes made for ML-MMOH-CRF-1130.3 -->\n<Script>\n\tfunction recordReplyNote()\n\t{                                           \n\t\tvar patient_id=document.getElementById(\'patient_id\').value;                                             \n\t\tvar dialogHeight= \"500\" ;\n\t\tvar dialogWidth = \"500\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments   = \"\" ;\n\t\tvar features       = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=yes;  status:\" + status;                                                     \n\t\twindow.showModalDialog(\"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=REPLY_NOTES&option_id=REPLY_NOTES&patient_id=\"+patient_id+\"\",arguments,features);\n\t}\n</Script>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	?	""	:	inputString;
		}
		
		public static String checkForNull(String inputString, String defaultValue)
		{
			return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}
		//Changes made for ML-MMOH-CRF-1130.3

		public String FetchFieldValue(String message, String identifier, String standardCode, String fieldSep, String procID){

			String l_app_msg = "", l_app_key = "", l_field_value = "";

			boolean isDebugYN = false; 

			isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
			if (isDebugYN) System.out.println(l_app_msg);	

			l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
			if (isDebugYN) System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Deriving Field Value..."+identifier;
			if (isDebugYN) System.out.println(l_app_msg);	

			try
			{
				if(standardCode != null && !(standardCode.length()>0))
				{

				}
				else
				{
					if (message.indexOf(identifier) >= 0 )
					{
						if (message.indexOf(fieldSep) >= 0)
						{
							l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
							if (l_field_value.indexOf(fieldSep) >= 0)
							{						
								l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
							}
						}
					}
				}
			}
			catch (Exception e)
			{
				l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
			}		

			l_app_msg = " ::: l_field_value ::: "+l_field_value;
			if (isDebugYN) System.out.println(l_app_msg);

			return l_field_value;
		}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

		String dataElements=request.getParameter("dataElements"); // Added by Sethu for MyHix changes required.
		dataElements = java.net.URLDecoder.decode(dataElements, "UTF-8");
		//String data_details=checkForNull(request.getParameter("details")); // Commented by Sethu.
		StringBuffer htmlData = new StringBuffer(); // Variables added by Sethu.
		String data_details="";	
		
		//Changes made for ML-MMOH-CRF-1130.3
		
		String l_field_separator= "$!^";

		String l_request_id = "", l_patient_id = "", l_facility_id = "", l_ecounter_id = "";

		String refStr = "REFREQQ";

		int refStrPos = 0;

		System.out.println(" ::: MyHixDetail ::: ");
		
		boolean isDebugYN = false; 

		isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		System.out.println("MyHixDetail isDebugYN--> "+isDebugYN);
	
		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Data Elements ::: "+dataElements);

		l_request_id = FetchFieldValue(dataElements, "<REQ_ID>", null, l_field_separator, "MyHixDisplay");

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Request ID ::: "+l_request_id);
		
		l_patient_id = FetchFieldValue(dataElements, "<PATIENT_ID>", null, l_field_separator, "MyHixDisplay");

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Patient ID ::: "+l_patient_id);

		l_facility_id = FetchFieldValue(dataElements, "<FACILITY_ID>", null, l_field_separator, "MyHixDisplay");

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Facility ID ::: "+l_facility_id);

		l_ecounter_id = FetchFieldValue(dataElements, "<ENCOUNTER_ID>", null, l_field_separator, "MyHixDisplay");

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Encounter ID ::: "+l_ecounter_id);
		
		//Changes made for ML-MMOH-CRF-1130.3

		InvokeMyHixRequest myHixRequest = new InvokeMyHixRequest(); 
		htmlData = myHixRequest.processRequest(dataElements);		
		
		data_details = htmlData.toString();
		
		//Changes made for ML-MMOH-CRF-1130.3

		refStrPos = dataElements.indexOf( refStr );

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Position ::: "+refStrPos);

		////Changes made for ML-MMOH-CRF-1130.3
		if (!(data_details.equals("")) && (refStrPos>0))
		{
			data_details = data_details + "\n"+ "<input type=\"button\" name=\"Print\" id=\"Print\"  value=\"Print\" onClick=\"window.print()\">" + "\t" + "<input type=\"button\" name=\"Reply Note\" id=\"Reply Note\"  value=\"Reply\" onClick=\"recordReplyNote()\">";
		}
		else if (!(data_details.equals("")))
		{
			data_details = data_details + "\n"+ "<input type=\"button\" name=\"Print\"  id=\"Print\" value=\"Print\" onClick=\"window.print()\">";
		}
		
		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: data_details ::: "+data_details);
	
		if (!(data_details.equals("")))
		{		
			out.println(data_details);			
		}
		
		//Changes made for ML-MMOH-CRF-1130.3

		if (!(data_details.equals("")))
		{
		
			out.println("<input type='hidden' name=action id=action value='"+l_request_id+"'>");
			out.println("<input type='hidden' name=facilityid id=facilityid value='"+l_facility_id+"'>");
			out.println("<input type='hidden' name=patient_id id=patient_id value='"+l_patient_id+"'>");
			out.println("<input type='hidden' name=encounter_id id=encounter_id value='"+l_ecounter_id+"'>");	
		}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
