package jsp_servlet._emr._jsp;

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
import eBL.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __mrpatientidvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MRPatientIDValidations.jsp", 1717652017599L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html><head> <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link><body class=\'MESSAGE\' OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n  <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script> \n  <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n  \n  <script language=\'javascript\' src=\"../../eBL/js/BLMedRepOutStdAmt.js\"></script>\n  <Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\tfunction get_message_text(message,moduleid,prompt) \n\t{\n\t\tvar message_text;\n\t\tmessage_text = getMessage(message,moduleid);\n\t    return message_text;\n\t}\n</script>\n\n</head>\n<form name=\'mr_validations_form\' id=\'mr_validations_form\'  method=\'post\' target=\'messageFrame\'>\t\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<script>var pat_id = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\t\t\t\t\tvar retAuth1 = checkOutstdAmtExists(pat_id,\"MR\"); \n\t\t\t\t\t\t\t\t</script>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t\t<script>\n\t\t\t\tvar error= getMessage( \"PATIENT_MERGED_VALID\" ,\'MP\');\n\t\t\t\terror = error.replace(\'#\',\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\");\t\t\t\t\n\t\t\t\talert(error);\n\t\t\t\t\n\t\t\t\t//Below conditions added by Dharma on 20th Feb 2018 against for ML-MMOH-SCF-0919 [IN:066388]\n\t\t\t\tvar call_function\t= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\tif(call_function==\'VIEW_ENCOUNTER_DTLS\' ||call_function== \'UPDATE_FILE_DETAILS\' || call_function==\'MARK_MLC_OSCC\' || call_function==\'DIAG_RECODE\' || call_function==\'MR_REC_PAT_VAL\' || call_function==\'RECORD_DIAGNOSIS\' || call_function==\'PROCEDURE_RECORDING\' || call_function==\'TRANSMIT_NOTIFY_REP\' || call_function==\'QUERY_MARK_MLC_OSCC\' || call_function==\'QUERY_MARK_MLC_OSCC\' || call_function==\'QUERY_MATERNAL_REPORT\' || call_function==\'MR_VIEW_DTH_REG\' || call_function==\'CONF_TRANSMIT_NOTIFY_REP\'){\n\t\t\t\t\tparent.frames[1].document.forms[0].PatientId.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t}else if(call_function== \'MEDICAL_REPORT_REQUEST\' || call_function==\'MR_INTERNAL_REPORTS_REPRINT\'){\n\t\t\t\t\tparent.frames[2].document.forms[0].PatientId.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t}else{\n\t\t\t\t\ttop.content.searchFrame.document.forms[0].patient_id.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t}\n\t\n\t\t\t</script>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<input type = \'hidden\' name = \'patientIdStatus\' value = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t </form>\n\t </body>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute(
		"PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

        Connection con               = null;

   	    PreparedStatement pstmtEncounter		 = null;
        ResultSet rsetEncounter               = null ;

		//String patientId			 = "";
		String patient_id			 = checkForNull(request.getParameter("patient_id"));		
		String encounter_id			 = checkForNull(request.getParameter("encounter_id"));		
		String facility_id			 = (String)session.getValue("facility_id");
		String prompt                ="";

		String patient_class			 = checkForNull(request.getParameter("patient_class"));	
		String conVal					= checkForNull(request.getParameter("conVal"));	
		//added on 31-07-08 for SCR 4964
		String called_from			 = checkForNull(request.getParameter("called_from"));
		String query_String          = checkForNull(request.getParameter("query_String"));
		String condition			 = checkForNull(request.getParameter("condition"));
		String oper_stn			     = checkForNull(request.getParameter("oper_stn"));
		String call_function		 = checkForNull(request.getParameter("call_function"));
			

try{
                
		con                  = ConnectionManager.getConnection(request);

		Boolean isOutstAmtChkApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","OUTSTAMT_CHECK_MED_REPORT_REQ");//Added by Thamizh selvi on 8th Feb 2017 against ML-MMOH-CRF-0777

		webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
		patdata.setFacility_id(facility_id);
		String patientIdStatus = patdata.CheckStatus(con,patient_id);
		prompt = patient_id;

	     if(!patient_id.equals(""))
		  {
			  if (!patientIdStatus.equals("INVALID_PATIENT") && !(patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0))
			  {
			  if(conVal.equals("Y"))
				{
					if(!patient_id.equals("") || !encounter_id.equals(""))
					{
						
						//added on 31-07-08 for SCR 4964
						if(called_from.equals("MEDICAL_REPORT_REQUEST")) 
						{	
							/*Added by Thamizh selvi on 7th Feb 2017 against ML-MMOH-CRF-0777 Start*/
							if(isOutstAmtChkApplicable){
						
								
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);

									out.println("<html><script>if(retAuth1=='Y'){top.content.resultFrame.location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?"+query_String+"&"+condition+"&oper_stn_id="+oper_stn+"&show_bed_yn=Y&fromSelect=fromSelect'}else{top.content.resultFrame.location.href='../../eCommon/html/blank.html';top.content.criteriaFrame.document.forms[0].PatientId.value='';}</script></html>");

							}/*End*/
							else{
									out.println("<html><script>top.content.resultFrame.location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?"+query_String+"&"+condition+"&oper_stn_id="+oper_stn+"&show_bed_yn=Y&fromSelect=fromSelect'</script></html>");
							}
								
							
						}
						else
						{
							out.println("<html><script>top.content.patientLine.location.href='../../eCommon/jsp/pline.jsp?EncounterId="+encounter_id+"&Facility_Id="+facility_id+"&Patient_ID="+patient_id+"';top.content.workAreaFrame.location.href='../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=MEDICAL_CERTFICATE&title=Medical Certificate&patient_id="+patient_id+"&encounter_id="+encounter_id+"&open_in_normal_yn=Y&episode_type=&visit_adm_date=&patient_class="+patient_class+"';</script></html>");
						}
						
					}
				
				}
			  }
			else if ( patientIdStatus.equals("INVALID_PATIENT"))
			{
			//added on 31-07-08 for SCR 4964
				
				if(call_function.equals("MEDICAL_REPORT_REQUEST"))
				{
					
					out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));top.content.resultFrame.location.href='../../eCommon/html/blank.html';top.content.criteriaFrame.document.forms[0].PatientId.value='';</script></html>");
				}//
				else if(call_function.equals("RECORD_DIAGNOSIS"))
				{
					
					out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));parent.frames[2].location.href='../../eCommon/html/blank.html';parent.frames[1].document.forms[0].PatientId.value='';</script></html>");
					
				}else if(call_function.equals("Medical_Certificate"))
				{
					
					out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));parent.frames[2].location.href='../../eCommon/html/blank.html';parent.frames[1].document.forms[0].patient_id.value='';</script></html>");
					
				}
			else
				{
					//out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));top.content.patientLine.location.href='../../eCommon/html/blank.html';top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';top.content.searchFrame.document.forms[0].patient_id.focus();top.content.searchFrame.document.forms[0].patient_id.value='';</script></html>");
					out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));parent.frames[2].location.href='../../eCommon/html/blank.html';parent.frames[1].document.forms[0].PatientId.value='';</script></html>");
				}

         	}
			else if(patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0)
		    {
				StringTokenizer token=new StringTokenizer(patientIdStatus,"$");
				String valid_patient_id = token.nextToken();
				valid_patient_id = token.nextToken();
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(valid_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
		
			out.println("<html><script>if(top.content.patientLine)top.content.patientLine.location.href='../../eCommon/jsp/pline.jsp?EncounterId="+encounter_id+"&Facility_Id="+facility_id+"&Patient_ID="+valid_patient_id+"';if(top.content.workAreaFrame)top.content.workAreaFrame.location.href='../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=MEDICAL_CERTFICATE&title=Medical Certificate&patient_id="+valid_patient_id+"&encounter_id="+encounter_id+"&open_in_normal_yn=Y&episode_type=&visit_adm_date=&patient_class="+patient_class+"';</script></html>");
			}
		 
		  
		 }
		  if(!encounter_id.equals(""))
		  {
				 try 			

				  {	
				   StringBuffer sqlPr = new StringBuffer();
				   int countRecEnc =0;
				   sqlPr.append("select count(*) from pr_encounter where ");
				   sqlPr.append("facility_id= ?  and patient_id = ? and encounter_id =? ");
				   pstmtEncounter = con.prepareStatement(sqlPr.toString());
				   pstmtEncounter.setString(1,facility_id );
				   pstmtEncounter.setString(2,patient_id );
				   pstmtEncounter.setString(3,encounter_id );

				   rsetEncounter = pstmtEncounter.executeQuery();
					  while(rsetEncounter!=null && rsetEncounter.next())
							 {
							  countRecEnc=rsetEncounter.getInt(1);
							 }
					  if(rsetEncounter!=null) rsetEncounter.close();
					  if(pstmtEncounter!=null) pstmtEncounter.close();
					  if((sqlPr != null) && (sqlPr.length() > 0))
					  {
						sqlPr.delete(0,sqlPr.length());
					  }
					  if (countRecEnc==0)
					  {
						  out.println("<html><script>alert(get_message_text('INVALID_ENCOUNTER_ID','IP','"+encounter_id+"'));top.content.patientLine.location.href='../../eCommon/html/blank.html';top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';top.content.searchFrame.document.forms[0].encounter_id.focus();top.content.searchFrame.document.forms[0].encounter_id.value='';</script></html>");
					  }
					}catch(Exception e) {/* out.println("Exception in Encounter="+e); */ e.printStackTrace();}		  
				}
				
				



		  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patientIdStatus));
            _bw.write(_wl_block18Bytes, _wl_block18);
	    }
		 catch(Exception e)
		{
			//out.print(e.toString());
			e.printStackTrace();
		 }
		finally
		{
			 ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
