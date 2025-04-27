package jsp_servlet._efm._jsp;

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
import webbeans.eFM.FileDeficiencyMonitoring;
import java.util.*;
import com.ehis.util.*;

public final class __fmfiledeficiencymonitoringdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileDeficiencyMonitoringDetails.jsp", 1741319564211L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMFileDeficiencyMonitoring.js\' ></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\" ></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<form name=\'FileDeficiencyMonitoring_detail\' id=\'FileDeficiencyMonitoring_detail\'>\n\t<table id=\'tb1\' border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\' align=\"CENTER\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<a name=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" id=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onClick=\'changeRowColor(this,7)\'\thref=\'javascript:OnDefMonitorDtlsSelection(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<input type=\'hidden\' name=\'defi_code\' id=\'defi_code\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=\'hidden\' name=\'row_count_up\' id=\'row_count_up\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t<input type=\'hidden\' name=\'Status_flag\' id=\'Status_flag\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t<input type=\'hidden\' name=\'row_count1\' id=\'row_count1\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t<input type=\'hidden\' name=\'cnt\' id=\'cnt\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t<input type=\'hidden\' name=\'flagclick\' id=\'flagclick\' value=\'\'>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</table>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            webbeans.eFM.FileDeficiencyMonitoring recordSetDeficiency= null;synchronized(session){
                recordSetDeficiency=(webbeans.eFM.FileDeficiencyMonitoring)pageContext.getAttribute("recordSetDeficiency",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordSetDeficiency==null){
                    recordSetDeficiency=new webbeans.eFM.FileDeficiencyMonitoring();
                    pageContext.setAttribute("recordSetDeficiency",recordSetDeficiency,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	//String EncounterId	= request.getParameter("EncounterId");	
	//String Admndate		= request.getParameter("Admndate");	
	//String Discdate		= request.getParameter("Discdate");	
	//String Carelocn		= request.getParameter("Carelocn");
	
	String PatientId	= request.getParameter("PatientId");
	String Found		= request.getParameter("Found");
  
   
   Object row_count1 = session.getAttribute("row_count");
	if(row_count1==null)  row_count1="";
	String  fac_id					=	"";
	String  encounter_id			=	"";
	String	file_no					=	"";
	String	file_type				=	"";
	String	volume_no				=	"";
	String	patient_class			=	"";
	String	defi_code				=	"";
	String	defi_desc				=	"";
	String	admission_date			=	"";
	String	discharge_date			=	"";
	String	care_locn_code			=	"";
	String	defi_completed_status	=	"";
	String	practitioner			=	"";
	String	practitioner_name		=	"";
	String	defi_reported_date		=	"";
	String	defi_status				=	"";
	String	defi_resolved_date		=	"";
	String	defi_remarks			=	"";
	//String  item_delete_yn			=	"";
	String  defi_status_desc		=	"";  
	String	operation_mode			=	"";
	String	record_from				=	"";
	 int cnt=0;
	boolean Status_flag	= false;

            _bw.write(_wl_block8Bytes, _wl_block8);

		//String facility_id	= (String) session.getValue("facility_id");

		String classValue		= "";
		String checkboxval		= "";
		String checkboxstate	= "";
		String compStat			= "&nbsp;Closed";
		//String compStatId		= "C";

		int rowid		= 1;
		int row_count	= 0;

		HashMap	htRecord	= null; 

		try
		{
			out.println("<tr><td width='14%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")+"</td>");
			out.println("<td width='15%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DateReported.label","fm_labels")+"</td>");
			out.println("<td width='19%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.PractitionerResponsible.label","fm_labels")+"</td>");
			out.println("<td width='8%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
			out.println("<td width='15%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DateResolvedCancelled.label","fm_labels")+"</td>");
			out.println("<td width='25%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</td>");
			out.println("<td width='4%' class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"?</td></tr>");

			row_count	=recordSetDeficiency.getSize();
			
			for(int i=0; i<row_count; i++)
			{
				classValue	=	((i%2)==0 ) ? "QRYEVEN" : "QRYODD";

				htRecord	=	(HashMap) recordSetDeficiency.getObject(i);

				fac_id					=	(String)	htRecord.get("facility_id");
				encounter_id			=	(String)	htRecord.get("encounter_id");
				file_no					=	(String)	htRecord.get("file_no");
				file_type				=	(String)	htRecord.get("file_type");
				volume_no				=	(String)	htRecord.get("volume_no");
				patient_class			=	(String)	htRecord.get("patient_class");
				defi_code				=	(String)	htRecord.get("defi_code");
				defi_desc				=	(String)	htRecord.get("defi_desc");
				admission_date			=	(String)	htRecord.get("admission_date");
				discharge_date			=	(String)	htRecord.get("discharge_date");
				care_locn_code			=	(String)	htRecord.get("care_locn_code");
				defi_completed_status	=	(String)	htRecord.get("defi_completed_status");
				practitioner			=	(String)	htRecord.get("practitioner");
				practitioner_name		=	(String)	htRecord.get("practitioner_name");
				defi_reported_date		=	(String)	htRecord.get("defi_reported_date");
				defi_status				=	(String)	htRecord.get("defi_status");
				defi_resolved_date		=	(String)	htRecord.get("defi_resolved_date");
				defi_remarks			=	(String)	htRecord.get("defi_remarks");
				//item_delete_yn			=	(String)	htRecord.get("item_delete_yn");
				operation_mode			=	(String)	htRecord.get("operation_mode");
				record_from				=	(String)	htRecord.get("record_from");
				//String header_exist		=	(String)	htRecord.get("header_exist");
				/*if(defi_reported_date != null)
				{
					defi_reported_date=DateUtils.convertDate(defi_reported_date,"DMYHM","en",localeName);
				}
				else
					defi_reported_date="";

				if(defi_resolved_date != null)
				{
					defi_resolved_date=DateUtils.convertDate(defi_resolved_date,"DMYHM","en",localeName);
				}
				else
					defi_reported_date="";*/
				
				if(defi_resolved_date == null || defi_resolved_date.equals("null"))
				{
					defi_resolved_date = "";
				}
				if(defi_status.equals("O"))
				{
					defi_status_desc	= "Open";
					compStat			= "&nbsp;Open";
					//compStatId			= "O";
					checkboxval			= "Checked";
					checkboxstate		= "";
					Status_flag	= true;
				}
				else if(defi_status.equals("C"))
				{
					defi_status_desc	= "Closed";
					checkboxval			= "Checked";
					if(record_from.equals("DATABASE"))
					{
						checkboxstate = "Disabled";
					}
				}
				else if(defi_status.equals("X"))
				{
					defi_status_desc	= "Cancelled";
					compStat			= "&nbsp;Closed";
					checkboxval			= "Checked";
					if(record_from.equals("DATABASE"))
					{
						checkboxstate = "Disabled";
					}
				}
				if(operation_mode.equals("Modify") && record_from.equals("DATABASE"))
				{
					checkboxval		= "Checked";
					checkboxstate	= "Disabled";
				}

				out.println("<tr><td class='"+classValue+"'><font size='1'>");

				if(record_from.equals("DATABASE") && (defi_status.equals("C")||defi_status.equals("X")))
				{	
					out.println(defi_desc);		
				}
				else
				{
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(compStat));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(defi_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(defi_desc)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(admission_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(discharge_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(care_locn_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(defi_completed_status));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(defi_reported_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(defi_status));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(defi_resolved_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(defi_remarks));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Found));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block13Bytes, _wl_block13);

					out.println(defi_desc);
				}

				out.println("</a></font></td><td class='"+classValue+"'><font size='1'>");
				out.println(defi_reported_date);
				out.println("</font></td><td class='"+classValue+"'><font size='1'>");
				out.println(practitioner_name);
				out.println("</font></td><td class='"+classValue+"'><font size='1'>");
				out.println(defi_status_desc);
				out.println("</font></td><td class='"+classValue+"'><font size='1'>");

				if(!defi_resolved_date.equals(""))
					out.println(defi_resolved_date);
				else
					out.println("&nbsp;");

				out.println("</font></td><td class='"+classValue+"'><font size='1'>");

				if(defi_remarks.equals(""))
				{
					out.println("&nbsp;");
				}
				else
				{
					out.println(defi_remarks);
				}
				out.println("</font></td><td align='center' class='"+classValue+"'><font size='1'>");
           				
				if(record_from.equals("SCREEN"))
				{
					cnt++;
					out.println("<input type='checkbox' name='select"+i+"' id='select"+i+"' "+checkboxval+" "+checkboxstate+" onClick='Remove("+i+");'>");
				}
				else
				{
					
					out.println("&nbsp;");
				}
				
				out.println("</font></td></tr>");
				out.println("<script>");
				out.println("parent.frames[2].document.getElementById('completed_status').innerHTML=\"<b>"+compStat+"\"");
	
				out.println("</script>");

				rowid++;
			} // end of for

			if(row_count!=0)
			{
			htRecord.put ("Status_flag",	Status_flag);
			}
			

			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(defi_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Status_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(row_count1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		catch(Exception e)
		{
			out.println("Exception e :"+e);
		}
	
            _bw.write(_wl_block20Bytes, _wl_block20);
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
