package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import eBL.BLShowRecalc;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public final class __blshowrecalcjobs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLShowRecalcJobs.jsp", 1737916836513L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nSr No        Version           TFS/Incident        SCF/CRF            \t\tDeveloper Name\n----------------------------------------------------------------------------------------------\n1\t\t\t V210517\t\t\t 17598\t\t\tCommon-ICN-0034\t\t\t\tMohana Priya K\n----------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Job Status</title>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../js/BLShowRecalcJobs.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</head>\n<body>\n\t<table class=\'grid\' border=\'1\' width=\'90%\' cellpadding=\'3\'  cellspacing=0 align=\"center\" id=\'showJobs\'>\n\t\t<tr style=\"width: 100%\">\n\t\t\t<td style=\"width: 7%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >S no</td>\n\t\t\t<td style=\"width: 10%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Request Id</td>\n\t\t\t<td style=\"width: 10%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Patient Id</td>\n\t\t\t<td style=\"width: 9%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Episdoe Type</td>\n\t\t\t<td style=\"width: 10%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Episode Id</td>\n\t\t\t<td style=\"width: 9%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Visit Id</td>\n\t\t\t<td style=\"width: 10%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Submission Date</td>\n\t\t\t<td style=\"width: 9%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Status</td>\n\t\t\t<td style=\"width: 20%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Remarks</td>\n\t\t\t<td style=\"width: 6%;overflow: hidden;display: inline-block;\" class=\'COLUMNHEADER\' >Re Run</td>\n\t\t</tr>  \n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\t\t<tr  style=\"width: 100%\">\n\t\t<td style=\"width: 7%;overflow: hidden;display: inline-block;\" class=\'field\' >";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n\t\t<td style=\"width: 10%;overflow: hidden;display: inline-block;\" class=\'field\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t<td style=\"width: 9%;overflow: hidden;display: inline-block;\" class=\'field\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td style=\"width: 20%;overflow: hidden;display: inline-block;\" class=\'field\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td style=\"width: 6%;overflow: hidden;display: inline-block;\" class=\'field\' >\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<a href=\"javascript:runJob(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\">Run Job</a>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t&nbsp;\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

	private String replaceForVisit(String input){
		if(input == null || "null".equals(input) || "0".equals(input)){
			input = "&nbsp;";
		}
		return input;
	}

	private String checkForNull(String input){
		if(input == null || "null".equals(input) ){
			input = "";
		}
		return input;
	}

	private String replaceEpisodeType(String input){
		if("O".equalsIgnoreCase(input)){
			input = "Out Patient";
		}
		else if("I".equalsIgnoreCase(input)){
			input = "In Patient";
		}
		else if("D".equalsIgnoreCase(input)){
			input = "Day Care";	
		}
		else if("E".equalsIgnoreCase(input)){
			input = "Emergency";	
		}
		else if("R".equalsIgnoreCase(input)){
			input = "External";	
		}
		return input;
	}

	private String replaceForStatus(String input){
		if("C".equalsIgnoreCase(input)){
			input = "Completed";
		}
		else if("I".equalsIgnoreCase(input)){
			input = "In progress";
		}
		else if("O".equalsIgnoreCase(input)){
			input = "Open";
		}
		else if("F".equalsIgnoreCase(input)){
			input = "Failed";
		}
		return input;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String reqId = request.getParameter("reqId");

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	BLShowRecalc job = null;

	List<BLShowRecalc> jobList = new ArrayList<BLShowRecalc>();
	String jobQuery = "Select req_id,patient_id,episode_type,episode_id,visit_id,to_char(submission_date,'dd/mm/yyyy') submission_date, "+
	" status, remarks from bl_background_process ";

	String userId = (String) session.getAttribute("login_user");
	System.err.println("User Id is->"+userId);
	String patientId = checkForNull(request.getParameter("patient_id"));
	String episodeType = checkForNull(request.getParameter("episode_type"));
	String episodeId = checkForNull(request.getParameter("episode_id"));
	String visitId = replaceForVisit(request.getParameter("visit_id"));
	String effFrom = checkForNull(request.getParameter("eff_from"));
	String effTo = checkForNull(request.getParameter("eff_to"));
	String userAuthentication = "Y";

	if("R".equals(episodeType) && "0".equals(episodeId)){
		episodeId = "";
	}

	if(!"Y".equals(userAuthentication)){
		jobQuery = jobQuery+ " where user_id = '"+userId+"' and patient_id = '"+patientId+"'";	
	}
	else{
		jobQuery = jobQuery+ " where patient_id = '"+patientId+"'";	
	}

	if(!"".equals(episodeType)){
		jobQuery = jobQuery+ " and episode_type = '"+episodeType+"' ";
	}
	if(!"".equals(episodeId)){
		jobQuery = jobQuery+ " and episode_id = '"+episodeId+"' ";
	}
	if(!"".equals(visitId)){
		jobQuery = jobQuery+ " and visit_id = '"+visitId+"' ";
	}

	if(!"".equals(effFrom) && !"".equals(effTo)){
		jobQuery = jobQuery+ " and trunc(submission_date) between to_date('"+effFrom+"','dd/mm/yyyy') and to_date('"+effTo+"','dd/mm/yyyy') ";
	}
	else if("".equals(effFrom) && !"".equals(effTo)){
		jobQuery = jobQuery+ " and trunc(submission_date) <=  to_date('"+effTo+"','dd/mm/yyyy') ";
	}
	else if(!"".equals(effFrom) && "".equals(effTo)){
		jobQuery = jobQuery+ " and trunc(submission_date) >=  to_date('"+effFrom+"','dd/mm/yyyy') ";
	}

	jobQuery = jobQuery + " order by req_id desc ";
	System.err.println("jobQuery -> "+jobQuery);
	try{
		con = ConnectionManager.getConnection();
		pstmt = con.prepareStatement(jobQuery);
		rst = pstmt.executeQuery();
		if(rst != null){
			while(rst.next()){
				job = new BLShowRecalc();
				job.setReqId(rst.getString("req_id"));
				job.setPatientId(rst.getString("patient_id"));		
				job.setEpisodeType(replaceEpisodeType(rst.getString("episode_type")));
				job.setEpisodeId(rst.getString("episode_id"));
				job.setVisitId(replaceForVisit(rst.getString("visit_id")));
				job.setSubmissionDate(rst.getString("submission_date"));
				job.setStatus(replaceForStatus(rst.getString("status")));
				job.setRemarks(rst.getString("remarks"));
				jobList.add(job);
			}
		}
	}
	catch(Exception e){
		System.err.println("The Exception is ->"+e);
		e.printStackTrace();
	}
	finally{
		if(con!=null)  ConnectionManager.returnConnection(con, request); //V210517
		if(pstmt != null){
			pstmt.close();
		}
		if(rst!= null){
			rst.close();
		}
	}

            _bw.write(_wl_block5Bytes, _wl_block5);

		int sno = 0;
		for(BLShowRecalc jobStat: jobList){
			sno++;
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sno ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(jobStat.getReqId() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(jobStat.getPatientId() ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(jobStat.getEpisodeType() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(jobStat.getEpisodeId() ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(jobStat.getVisitId() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(jobStat.getSubmissionDate() ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(jobStat.getStatus() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(jobStat.getRemarks() ));
            _bw.write(_wl_block10Bytes, _wl_block10);
if("Failed".equalsIgnoreCase(jobStat.getStatus())){ 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(jobStat.getReqId()));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
	else{ 
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block14Bytes, _wl_block14);
}	
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
