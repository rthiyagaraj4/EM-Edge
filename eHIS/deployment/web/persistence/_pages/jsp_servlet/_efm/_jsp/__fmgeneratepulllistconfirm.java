package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmgeneratepulllistconfirm extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMGeneratePullListConfirm.jsp", 1709116850985L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMGeneratePullList.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onMouseDown=\'CodeArrest()\' class=message onKeyDown = \'lockKey();\'>\n\t<form name=\'GenaratePulingListConfirm\' id=\'GenaratePulingListConfirm\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<!-- <script>\t\t\t\n\t\tvar msg1 = getMessage(\"FILES_ALREADY_TRACKED\",\"FM\");\n\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg1+\"&err_value=0\";\n\t\t</script> -->\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t   <script>\n\t\t\t\talert(getMessage(\"PULL_LIST_GEN_FOR_MAIN\",\"FM\"));\n\t\t\t    parent.frames[1].frames[1].document.forms[0].print_pull_list_type.value=\"S\";\n\t\t\t    parent.frames[1].frames[1].document.forms[0].print_pull_list_type.focus();\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].generate.disabled=false;\n\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"calend\").style.display=\"inline\";\n\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"calend\").style.visibility=\"visible\";\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].fm_appt_date.readOnly=false;\n\t\t\t\t\n\t\t\t   </script>\n\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t   <script>\n\t\t\t\t\talert(getMessage(\"PULL_LIST_NOT_GEN_FOR_MAIN\",\"FM\"));\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].print_pull_list_type.value=\"M\";\n\t\t\t\t    parent.frames[1].frames[1].document.forms[0].print_pull_list_type.focus();\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].generate.disabled=false;\n\t\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"calend\").style.display=\"inline\";\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].fm_appt_date.readOnly=true;\n\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].fm_appt_date.value=parent.frames[1].frames[1].document.forms[0].to_appt_date_disp.value;\n\n\t\t\t\t  </script>\n\t\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t   <script>\n\t\t\t\t\talert(getMessage(\"PULL_TYPE_ALL\",\"FM\"));\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].print_pull_list_type.value=\"A\";\n\t\t\t\t    parent.frames[1].frames[1].document.forms[0].print_pull_list_type.focus();\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].generate.disabled=false;\n\t\t\t\t\tparent.frames[1].frames[1].document.getElementById(\"calend\").style.display=\"inline\";\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].fm_appt_date.readOnly=true;\n\n\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].fm_appt_date.value=parent.frames[1].frames[1].document.forms[0].to_appt_date_disp.value;\n\n\t\t\t\t\t</script>\n\t\t\t\t ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t    <script>\n\t\t\t\t//parent.parent.frames[2].commontoolbarFrame.location.href =\'../../eCommon/html/process.html\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].method=\'post\';\t\t\t\tparent.frames[1].frames[1].document.forms[0].action=\'../../servlet/eFM.FMGeneratePullingListServlet\';\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].target=parent.frames[2].name;\n\t\t\t\tparent.frames[1].frames[1].document.forms[0].submit();\n\t\t\t   </script> \n\t\t\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</form>\n\t\t\n\t</body>\n\t</html>\n\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

      public synchronized void doOnlineReportPrinting( HttpServletRequest req, HttpServletResponse res,String p_report_id, String locale,String facility_id,String user_id,String fm_clinic_code,String to_clinic_code,String fm_pract_id,String to_pract_id ,String p_gender,String fm_appt_date,String fs_locn_code,String print_pull_list_type,String appl_user_id,String order_by_pull_list,String print_tel_no,String print_bar_code,String p_order_term ,String p_pull_list_seq )
{
//	java.io.PrintWriter out = null;
	try
	{
	//	out = res.getWriter();
		String 	rs_report_id = p_report_id;	
		String ReportOutput = "";
        String fm_appt_date1="";
					if (fm_appt_date != null)
					{
					fm_appt_date1=fm_appt_date;	//fm_appt_date1=DateUtils.convertDate(fm_appt_date,"DMY","en",locale);
					}

		     	
				ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport(facility_id, "FM",rs_report_id) ;

				report1.addParameter( "p_facility_id",facility_id ) ;
				report1.addParameter("p_user_name",user_id);
				report1.addParameter("p_report_id",rs_report_id);
				report1.addParameter("p_fm_clinic_code",fm_clinic_code);
				report1.addParameter("p_to_clinic_code",to_clinic_code);
				report1.addParameter("p_fm_pract_id",fm_pract_id);
				report1.addParameter("p_to_pract_id",to_pract_id);
				report1.addParameter("p_gender",p_gender);
				report1.addParameter("p_appt_date",fm_appt_date1);
				report1.addParameter("p_module_id","FM");
				report1.addParameter("p_src_fs_locn_code",fs_locn_code);
				report1.addParameter("p_status",print_pull_list_type);
				report1.addParameter("P_PULL_LIST_TYPE",print_pull_list_type);
				report1.addParameter("p_appl_user_id",appl_user_id);
				report1.addParameter("p_call_from","GENERATE_PULLING_LIST");				
				report1.addParameter("ORDER_BY",order_by_pull_list);				
				report1.addParameter("P_T_NAME","FM_PULLING_LIST");				
				report1.addParameter("p_print_tel_no",print_tel_no);				
				report1.addParameter("print_bar_code",print_bar_code);				
				report1.addParameter("p_order_term",p_order_term);
				report1.addParameter("P_LANGUAGE_ID",locale);
				report1.addParameter("p_pull_list_seq",p_pull_list_seq);
				onlineReports.add( report1) ;
	 			ReportOutput = onlineReports.execute( req, res );
				  	}
catch ( Exception e )
	{
		e.printStackTrace();
	}
}
public synchronized void doOnlineReq_file_ReportPrinting(HttpServletRequest req, HttpServletResponse res,String p_report_id, String locale,String facility_id,String user_id,String fm_clinic_code,String to_clinic_code,String fm_pract_id,String to_pract_id ,String p_gender,String fm_appt_date,String fs_locn_code,String print_pull_list_type,String appl_user_id,String order_by_pull_list,String print_tel_no,String print_bar_code,String p_order_term ,String p_pull_list_seq)
{
	//java.io.PrintWriter out = null;
	try
	{
		//out = res.getWriter();
		String 	rs_report_id = p_report_id;	
		String ReportOutput = "";
       	String fm_appt_date1="";			
					if (fm_appt_date != null)
					{
					fm_appt_date1=fm_appt_date;	//fm_appt_date1=DateUtils.convertDate(fm_appt_date,"DMY","en",locale);
					}
			     
			   ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport(facility_id,"FM",rs_report_id,"F",fs_locn_code) ;
	        		        			
				
				report1.addParameter( "p_facility_id",facility_id ) ;
				report1.addParameter("p_user_name",user_id);
				report1.addParameter("p_report_id",rs_report_id);
				report1.addParameter("p_fm_clinic_code",fm_clinic_code);
				report1.addParameter("p_to_clinic_code",to_clinic_code);
				report1.addParameter("p_fm_pract_id",fm_pract_id);
				report1.addParameter("p_to_pract_id",to_pract_id);
				report1.addParameter("p_gender",p_gender);
				report1.addParameter("p_appt_date",fm_appt_date1);
				report1.addParameter("p_module_id","FM");
				report1.addParameter("p_src_fs_locn_code",fs_locn_code);
				report1.addParameter("p_status",print_pull_list_type);
				report1.addParameter("P_PULL_LIST_TYPE",print_pull_list_type);
				report1.addParameter("p_appl_user_id",appl_user_id);
		        report1.addParameter("p_call_from","GENERATE_OP_PULLING_LIST");	
		        report1.addParameter("ORDER_BY",order_by_pull_list);				
				report1.addParameter("P_T_NAME","FM_PULLING_LIST");				
				report1.addParameter("p_print_tel_no",print_tel_no);				
				report1.addParameter("print_bar_code",print_bar_code);				
				report1.addParameter("p_order_term",p_order_term);
				report1.addParameter("P_LANGUAGE_ID",locale);
			    report1.addParameter("p_pull_list_seq",p_pull_list_seq);
				onlineReports.add( report1) ;
				ReportOutput = onlineReports.execute( req, res );
					         					
				}
	catch ( Exception e )
	{
		e.printStackTrace();
	}
	
} 
	
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	Connection con	=	null;
	java.sql.Statement stmt	=	null;
	ResultSet rs	=	null;
	String facility_id="",sql="",p_appt_date="",p_fm_clinic_code="",p_to_clinic_code="";
	String pull_list_gen_by_gender = "";
	String p_fs_locn_code="",p_pull_type="",p_gender="";
	//String p_fm_pract_id="",p_to_pract_id="",alert_flag="";
  	String fm_appt_date="", to_appt_date="", fm_clinic_code="", to_clinic_code="", fm_pract_id="";
	String to_pract_id="",	pull_list_yn="" ; 
	String locale				= (String)session.getAttribute("LOCALE");
	String gen_tracer="";
	String p_order_term = "";
	String user_id="", fs_locn_code="",appl_user_id="" ; 
	String   p_gen_report="",print_pull_list_type="",order_by_pull_list="",print_tel_no="",print_bar_code="",operation_type="";
    String p_print_req_slip=""; 
	String flag=""; 
	facility_id	=	(String)session.getValue("facility_id");
	String login_facility_id="";
	String login_user_id;
	String from_clinic="";
	String to_clinic="";
	String p_fm_pract_id="";
	String p_to_pract_id="";
	String appt_date2="";
	String appt_date="" ,p_pull_list_seq="";
	 try
	{
		con			=	ConnectionManager.getConnection(request);
		flag    =request.getParameter("flag");
	
		if(flag ==null || flag .equals("null"))flag ="";
		p_appt_date			=	request.getParameter("p_appt_date");
		if(p_appt_date != null)
		{
			p_appt_date=DateUtils.convertDate(p_appt_date,"DMY",locale,"en");
		}

		p_fm_clinic_code	=	request.getParameter("p_fm_clinic_code");
		p_to_clinic_code	=	request.getParameter("p_to_clinic_code");
//		p_fm_pract_id		=	request.getParameter("p_fm_pract_id");
//		p_to_pract_id		=	request.getParameter("p_to_pract_id");
		p_fs_locn_code		=	request.getParameter("p_fs_locn_code");
		p_pull_type		    =	request.getParameter("p_pull_type");
		p_gender		    =	request.getParameter("p_gender");
		pull_list_gen_by_gender		    =	request.getParameter("pull_list_gen_by_gender");

			
		if(flag.equals("true"))
		{
			
			user_id			=	(String)session.getValue("login_user");	
			fm_appt_date	= request.getParameter("fm_appt_date");
			to_appt_date	= request.getParameter("to_appt_date");
			fm_clinic_code	= request.getParameter("fm_clinic_code");
			to_clinic_code	= request.getParameter("to_clinic_code");
			fm_pract_id		= request.getParameter("fm_pract_id");
			to_pract_id		= request.getParameter("to_pract_id");
			p_gender		= request.getParameter("p_gender");
			pull_list_yn	= request.getParameter("pull_list_yn");
			fs_locn_code	= request.getParameter("fs_locn_code");	
			appl_user_id	= request.getParameter("appl_user_id");	
			p_gen_report	= request.getParameter("p_gen_report");
			print_tel_no	= request.getParameter("print_tel_no");
			print_bar_code	= request.getParameter("print_bar_code");
			gen_tracer	= request.getParameter("gen_tracer");
			operation_type	= request.getParameter("operation_type");
			order_by_pull_list	= request.getParameter("order_by_pull_list");
			print_pull_list_type = request.getParameter("print_pull_list_type");			
			p_order_term = request.getParameter("p_order_term");	
			p_print_req_slip = request.getParameter("p_print_req_slip");
           p_pull_list_seq  = request.getParameter("p_pull_list_seq");
		 locale	   	= (String)session.getAttribute("LOCALE");
			if(fm_appt_date !=null )
			{
				fm_appt_date=DateUtils.convertDate(fm_appt_date,"DMY",locale,"en");//Comment line removed by Rameswar Aganist SKR-SCF-1104 and SKR-SCF-1103 on 4th Sept 2015
			}
			else
				fm_appt_date=""; 

			if(to_appt_date!=null )
			{
				to_appt_date=DateUtils.convertDate(to_appt_date,"DMY",locale,"en");//Comment line removed by Rameswar Aganist SKR-SCF-1104 and SKR-SCF-1103 on 4th Sept 2015
			}
			else
				to_appt_date=""; 

			if(fm_clinic_code==null || fm_clinic_code.equals("null"))fm_clinic_code="";
			if(fm_clinic_code==null || fm_clinic_code.equals("null"))fm_clinic_code="";
			if(to_clinic_code==null || to_clinic_code.equals("null"))to_clinic_code="";
			if(fm_pract_id==null || fm_pract_id.equals("null"))fm_pract_id="";
			if(to_pract_id==null || to_pract_id.equals("null"))to_pract_id="";
			if(p_gender==null || p_gender.equals("null"))p_gender="";
			if(pull_list_yn==null || pull_list_yn.equals("null"))pull_list_yn="N";
			if(fs_locn_code==null || fs_locn_code.equals("null"))fs_locn_code="";
			if(appl_user_id==null || appl_user_id.equals("null"))appl_user_id="";			
			if(gen_tracer==null || gen_tracer.equals("null"))gen_tracer="";		
			if(order_by_pull_list==null || order_by_pull_list.equals("null"))order_by_pull_list="";		
			if(print_tel_no==null || print_tel_no.equals("null"))print_tel_no="N";		
			if(print_bar_code==null || print_bar_code.equals("null"))print_bar_code="N";		
			if(operation_type==null || operation_type.equals("null"))operation_type="N";
		    if(p_print_req_slip==null || p_print_req_slip.equals("null")) p_print_req_slip="N";
			 if(p_pull_list_seq==null || p_pull_list_seq.equals("null")) p_pull_list_seq="0";
			if(p_order_term==null || p_order_term.equals("null"))p_order_term="";		
					
			
			if (print_pull_list_type==null)
			{
				print_pull_list_type="N";
			}
			if (p_gen_report==null)
			{
				p_gen_report="N";
			}
		 							 
					  if (p_gen_report.equals("Y"))
			        {
					  doOnlineReportPrinting(request,response,"FMBMRPLA",locale, facility_id, user_id, fm_clinic_code, to_clinic_code, fm_pract_id, to_pract_id , p_gender, fm_appt_date, fs_locn_code, print_pull_list_type, appl_user_id, order_by_pull_list, print_tel_no, print_bar_code,p_order_term,p_pull_list_seq);
				      }
						if (gen_tracer.equals("Y"))
			           {
						doOnlineReportPrinting(request,response,"FMBAPTRC",locale,facility_id, user_id, fm_clinic_code, to_clinic_code, fm_pract_id, to_pract_id , p_gender, fm_appt_date, fs_locn_code, print_pull_list_type, appl_user_id, order_by_pull_list, print_tel_no, print_bar_code,p_order_term,p_pull_list_seq);
					   }
						 
						 if (p_print_req_slip.equals("Y"))
						{
						 doOnlineReq_file_ReportPrinting(request,response,"FMFLRQSL",locale,facility_id, user_id, fm_clinic_code, to_clinic_code, fm_pract_id, to_pract_id , p_gender, fm_appt_date, fs_locn_code, print_pull_list_type, appl_user_id, order_by_pull_list, print_tel_no, print_bar_code,p_order_term,p_pull_list_seq);
						   	}
		
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
	} else if(flag.equals("Auto Track out to OPD"))
		{

		     from_clinic			=	request.getParameter("from_clinic");
			 to_clinic			=	request.getParameter("to_clinic");
		     login_facility_id			=	request.getParameter("login_facility_id");
			login_user_id			=	request.getParameter("login_user_id");
		    p_fm_pract_id			=	request.getParameter("p_fm_pract_id");
			p_to_pract_id			=	request.getParameter("p_to_pract_id");
			appt_date			=	request.getParameter("appt_date2");
		    fs_locn_code	= request.getParameter("fs_locn_code");	
			 if (from_clinic==null || from_clinic.equals("null"))
			{
				from_clinic="";
			}

			if (to_clinic==null || to_clinic.equals("null"))
			{
				to_clinic="";
			}	
			
			  if (login_facility_id==null || login_facility_id.equals("null"))
			{
				login_facility_id="";
			}

			if (login_user_id==null || login_user_id.equals("null"))
			{
				login_user_id="";
			}	
			
			 
			  if (p_fm_pract_id==null || p_fm_pract_id.equals("null"))
			{
				p_fm_pract_id="";
			}

			if (p_to_pract_id==null || p_to_pract_id.equals("null"))
			{
				p_to_pract_id="";
			}	
			 
					 if (appt_date != null)
					{
						appt_date2=DateUtils.convertDate(appt_date,"DMY","en",locale);
					}

					ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
					String ReportOutput="";
			
					ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport( login_facility_id, "FM","FMBATRCD") ;
					report1.addParameter( "p_facility_id",	login_facility_id ) ;
					report1.addParameter("p_user_name",login_user_id);
					report1.addParameter("p_report_id","FMBATRCD");
					report1.addParameter("p_fm_clinic_code",from_clinic);
					report1.addParameter("p_to_clinic_code",to_clinic);
					report1.addParameter("p_fm_pract_id",p_fm_pract_id);
					report1.addParameter("p_to_pract_id",p_to_pract_id);
					report1.addParameter("p_gender","A");
					report1.addParameter("p_appt_date",appt_date2);
					report1.addParameter("p_module_id","FM");
					report1.addParameter("P_T_NAME","FM_AUTO_TRACK_LOG");	
					report1.addParameter("p_call_from","AUTO_TRACK");
					report1.addParameter("p_src_fs_locn_code",fs_locn_code);
					onlineReports.add( report1) ;

					ReportOutput = onlineReports.execute( request, response ); 
							
		
		}else
		{
		
		stmt		=	con.createStatement();

		String pull_type="";

		sql="select FM_GET_PULLING_LIST_TYPE('"+facility_id+"','"+p_fs_locn_code+"','"+p_appt_date+"','"+p_fm_clinic_code+"','"+p_to_clinic_code+"') Pulling_List_Type from dual";
		
		rs = stmt.executeQuery(sql);
		if(rs!=null && rs.next())
		{
			pull_type=rs.getString("Pulling_List_Type");
	
		
		}
		
		if(rs!= null) rs.close();

/*		sql			=	"select status,male_pull_list_type, female_pull_list_type, unknown_pull_list_type from fm_pulling_list_ctl where facility_id='"+facility_id+"' and src_fs_locn_code = '"+p_fs_locn_code+"' and trunc(appt_date)=to_date('"+p_appt_date+"','dd/mm/rrrr') and clinic_code between nvl('"+p_fm_clinic_code+"','!') and nvl('"+p_to_clinic_code+"','~')  " ;
		
		rs = stmt.executeQuery(sql);
		if (rs!=null)
		{
			
			
			while (rs.next())
			{
				

				p_status				 = rs.getString("status");
				p_male_pull_list_type	 = rs.getString("male_pull_list_type");
				p_female_pull_list_type	 = rs.getString("female_pull_list_type");
				p_unknown_pull_list_type = rs.getString("unknown_pull_list_type");
				if (p_status==null) p_status="";
				if (p_male_pull_list_type==null) p_male_pull_list_type="";
				if (p_female_pull_list_type==null) p_female_pull_list_type="";
				if (p_unknown_pull_list_type==null) p_unknown_pull_list_type="";

					if (p_status.equals("T"))
					{
						p_T_status_cnt++;
					}
					else if (p_status.equals("S") || p_status.equals("M"))
					{
                       if (p_status.equals("M")) p_M_status_cnt++;
					   else
						p_S_status_cnt++;
						p_MS_status_cnt++;
                        if (p_male_pull_list_type.equals("M")) p_male_main_cnt++;
						else p_male_supp_cnt++;
                        if (p_female_pull_list_type.equals("M")) p_female_main_cnt++;
						else p_female_supp_cnt++;
                        if (p_unknown_pull_list_type.equals("M")) p_unknown_main_cnt++;
						else p_unknown_supp_cnt++;

					}
					
				p_total_cnt++;
				
			}
		}
		
		if (p_total_cnt==0)
		{
			p_total_cnt=1;
		}
		if (p_total_cnt == p_T_status_cnt)
		{   */
		
            _bw.write(_wl_block10Bytes, _wl_block10);

	/*	}
		else if (p_MS_status_cnt > 0)
		{
		 if (p_pull_type.equals("M"))
			alert_flag = "M";
	
		}
		else if (p_MS_status_cnt == 0)
		{
		 if (p_pull_type.equals("S"))
			alert_flag = "S";

		}
		if (pull_list_gen_by_gender.equals("Y"))
		{
			if (!p_gender.equals("A")&&p_pull_type.equals("M")){
				alert_flag="";
				if (p_gender.equals("M")){
					if (p_male_main_cnt>0) alert_flag = "M";
				}
				else if (p_gender.equals("F")){
					if (p_female_main_cnt>0) alert_flag = "M";
				}
				else if (p_gender.equals("U")){
					if (p_unknown_main_cnt>0) alert_flag = "M";
				}
			}
			if (!p_gender.equals("A")&&p_pull_type.equals("S")){
				alert_flag="";
				if (p_gender.equals("M")){
					if (p_male_main_cnt==0) alert_flag = "S";
				}
				else if (p_gender.equals("F")){
					if (p_female_main_cnt==0) alert_flag = "S";
				}
				else if (p_gender.equals("U")){
					if (p_unknown_main_cnt==0) alert_flag = "S";
				}
			}
		}

		  */

			if (pull_type.equals("S") && !p_pull_type.equals("S")){
			 
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
			else if (pull_type.equals("M") && !p_pull_type.equals("M")){
				 
            _bw.write(_wl_block12Bytes, _wl_block12);

				}
			   else if (pull_type.equals("A") && !p_pull_type.equals("A")){
				 
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
			//  else if (pull_type.equals("N")){
					//<script>
				 // alert(getMessage("GEN_PULL_NO_FILE_INCLUDED","FM"));
				//	parent.frames[1].frames[1].document.forms[0].print_pull_list_type.value="M";
				 //  parent.frames[1].frames[1].document.forms[0].print_pull_list_type.focus();
				//	parent.frames[1].frames[1].document.forms[0].generate.disabled=false;
				//	parent.frames[1].frames[1].document.getElementById("calend").style.display="inline";
				//	parent.frames[1].frames[1].document.forms[0].fm_appt_date.readOnly=true;

				//	parent.frames[1].frames[1].document.forms[0].fm_appt_date.value=parent.frames[1].frames[1].document.forms[0].to_appt_date_disp.value; 
				// </script>  
						//} 
				else
				{
					  	 
            _bw.write(_wl_block14Bytes, _wl_block14);

				}

		
            _bw.write(_wl_block15Bytes, _wl_block15);

	

if(rs   != null)	rs.close();
	if(stmt != null)stmt.close();
		}
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
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
