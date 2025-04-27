package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __ipencounterdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/IPEncounterDisplay.jsp", 1724824000890L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\t\n<HEAD>\n\t\t<TITLE></TITLE>\n\t\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tfunction sendtomain(encid)\n\t\t{\n\t\t\t//parent.window.returnValue=encid;\n\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\tdialogBody.contentWindow.returnValue = encid;\n\t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t    dialogTag.close();       \n\t\t}\n\t\t</script>\n\t\t</HEAD>\n\t\t<BODY onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n\t\t<form name=\"RepMovementHistForm\" id=\"RepMovementHistForm\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<br>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr>\n\t\t\t<th width = \'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t<th width = \'25%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t</tr>\n\t\t<tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</tr>\n\t\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</TABLE>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<br>\n\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t\t<tr>\n\t\t<th width = \'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t<th width = \'15%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t<th width = \'20%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t<th width = \'40%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</table>\n<br>\n<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<tr>\n\t<td class=\'button\'  colspan=\'5\' align=\'right\'>\n\t\t<input type=\'button\' class=\'BUTTON\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onClick=\"const dialogTag = parent.parent.document.getElementById(\'dialog_tag\'); dialogTag.close();\">\n\t </td>\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<script>\n\t\t\tvar msg =\tgetMessage(\'NO_DISCHARGED_ENCOUTER\',\'FM\');\n\t\t\talert(msg);\n\t\twindow.close();\n\t\t</script>\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con  = null;
	Statement stmt  = null;
	ResultSet rs    = null;
	Statement stmt1 = null;
	ResultSet rs1   = null;
		
	String deficiency_status="";
	String deficiency_flag="";
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;	

	String called_from = request.getParameter("called_from"); // From QueryFMEncounterDetailsSearch.jsp
		
	if(called_from == null || called_from.equals("null"))
		called_from = "";
		
	try
	{
		con  =  ConnectionManager.getConnection(request);
		stmt=con.createStatement();

		if(called_from.equals("QFMED"))
		{
			String sql = "SELECT distinct encounter_id, TO_CHAR(encounter_date_time,'dd/mm/yyyy hh24:mi')encounter_date_time_date_time FROM fm_encounter_volume_link WHERE facility_id = '"+p_facility_id+"'";
			rs=stmt.executeQuery(sql);

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
			int i = 0;
			String classValue="";
			String encounter_date_time="";
			while(rs!=null && rs.next())
			{
				i = i +1;
				encounter_date_time=rs.getString(2);
				 if(!localeName.equals("en"))
				{
					 encounter_date_time=DateUtils.convertDate(encounter_date_time,"DMYHM","en",localeName);
				}
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;		 
				out.println("<td width = '25%' class='"+classValue+"'><a href=\"javascript:sendtomain('"+rs.getString(1)+"')\">"+rs.getString(1)+"</a></td>");
				out.println("<td width = '25%' class='" + classValue + "'>"+encounter_date_time+"</td>");

            _bw.write(_wl_block11Bytes, _wl_block11);

			}

            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		else
		{
			String sql="";
			String file_type = request.getParameter("file_type");	
			String patientid = request.getParameter("patient_id");	
			String file_no	 =	request.getParameter("file_no");		
			String file_type_appl_yn =	request.getParameter("file_type_appl_yn");		
			String volume_no =request.getParameter("volume_no");	
			
			file_no = ((file_no==null)||(file_no.equals("null"))) ? "" : file_no;
			file_type = ((file_type==null)||(file_type.equals("null"))) ? "" : file_type;
			patientid = ((patientid==null)||(patientid.equals("null"))) ? "" : patientid;
			volume_no = ((volume_no==null)||(volume_no.equals("null"))) ? "" : volume_no;
			file_type_appl_yn = ((file_type_appl_yn==null)||(file_type_appl_yn.equals("null"))) ? "N" : file_type_appl_yn;
			if(rs!=null)	rs.close();		
			if(called_from.equals("Report_encdetails"))
			{
			 if(file_type_appl_yn.equals("Y"))
				{
			if(file_no.equals(""))
					{
                      sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"' and a.facility_id ='"+p_facility_id+"'  AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)   ORDER BY a.visit_adm_date_time DESC ";
					} else if(volume_no.equals(""))		
					{
       sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status  FROM fm_deficiency_hdr WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id  AND file_no ='"+file_no+"') deficiency_status   FROM pr_encounter a WHERE a.patient_id = '"+patientid+"' AND   a.facility_id = '"+p_facility_id+"'   order by a.visit_adm_date_time desc ";

					}
					
					else {			 
				 sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status  FROM fm_deficiency_hdr WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id  AND file_no ='"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE a.patient_id = '"+patientid+"'  AND  a.facility_id = '"+p_facility_id+"'  order by a.visit_adm_date_time desc ";
					}
						
						}
				 if(file_type_appl_yn.equals("N"))
				{
			
			 if(file_no.equals(""))
					{
                      sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"' AND  a.facility_id ='"+p_facility_id+"'     AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)   ORDER BY a.visit_adm_date_time DESC ";
					}else if(volume_no.equals(""))		
					{
					 sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"' AND  a.facility_id = '"+p_facility_id+"'  AND b.file_no(+) ='"+file_no+"' AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)   ORDER BY a.visit_adm_date_time DESC ";
				}
					
					else{
				 
			 sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status  FROM fm_deficiency_hdr WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id  AND file_no ='"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE  a.patient_id = '"+patientid+"'  AND  a.facility_id = '"+p_facility_id+"'   order by a.visit_adm_date_time desc ";
				}
				}
			}else if(called_from.equals("deficiecy_slip"))
			
			{
             if(file_type_appl_yn.equals("Y"))
				{
			 						  
			  if(file_no.equals(""))
					{
                      sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"'  AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}	else if(volume_no.equals(""))		
					{				
					 sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"' AND b.file_no ='"+file_no+"' AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}
					
					else{
				   sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status FROM fm_deficiency_hdr   WHERE facility_id = a.facility_id  AND encounter_id = a.encounter_id AND file_no = '"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE a.facility_id = '"+p_facility_id+"' AND a.patient_id = '"+patientid+"' and discharge_date_time is not null order by a.visit_adm_date_time desc ";
					  
					
					}
				}
				 if(file_type_appl_yn.equals("N"))
				{
			       
				   if(file_no.equals(""))
					{
                    sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"'  AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					} else if(volume_no.equals(""))		
					{	
					  sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"' AND b.file_no ='"+file_no+"' AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}
					else{
				   sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status FROM fm_deficiency_hdr       WHERE facility_id = a.facility_id  AND encounter_id = a.encounter_id AND file_no = '"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE a.patient_id = '"+patientid+"' AND  a.facility_id = '"+p_facility_id+"'  and discharge_date_time is not null order by a.visit_adm_date_time desc ";
					}
					
					}

			}
			else if(called_from.equals("file_encounter"))
			{
      sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"'  AND  a.facility_id ='"+p_facility_id+"'   AND   a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
			}
			
			else{
             if(file_type_appl_yn.equals("Y"))
				{
			  if(file_type.equals(""))
					{			  
			 sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"'  AND  a.facility_id ='"+p_facility_id+"'   AND    a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}else{
        sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class,(SELECT deficiency_status FROM fm_deficiency_hdr       WHERE facility_id = a.facility_id  AND encounter_id = a.encounter_id AND file_type = '"+file_type+"' AND volume_no ='"+volume_no+"') deficiency_status  FROM pr_encounter a WHERE a.patient_id = '"+patientid+"' AND  a.facility_id = '"+p_facility_id+"'   and discharge_date_time is not null order by a.visit_adm_date_time desc ";
					}
				
				
				}
				 if(file_type_appl_yn.equals("N"))
				{
			      
				    if(file_no.equals(""))
					{	 
				   sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"'  AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}else{
				   sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status FROM fm_deficiency_hdr       WHERE facility_id = a.facility_id  AND encounter_id = a.encounter_id AND file_no = '"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE a.facility_id = '"+p_facility_id+"' AND a.patient_id = '"+patientid+"' and discharge_date_time is not null order by a.visit_adm_date_time desc ";
					}
					
					}
			
			
			}
		
			rs=stmt.executeQuery(sql);


            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
	int i = 0;
			String classValue="";
			String visit_adm_date_time="";
			String visit_dis_date_time="";
			while(rs.next())
			{
				 i = i+1;
				 visit_adm_date_time=rs.getString(2);   
				 visit_dis_date_time=rs.getString(3);     
				 if(!localeName.equals("en"))
				{
					 visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",localeName);
					  visit_dis_date_time=DateUtils.convertDate(visit_dis_date_time,"DMYHM","en",localeName);
				}
				if(visit_dis_date_time==null) visit_dis_date_time="&nbsp;";
				 
				 if(i % 2 == 0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";	
				out.println("<td width = '10%' class='" + classValue + "'>"+rs.getString(5)+"</td>");
				out.println("<td width = '25%' class='"+classValue+"'><a href=\"javascript:sendtomain('"+rs.getString(1)+"')\">"+rs.getString(1)+"</a></td>");
				out.println("<td width = '25%' class='" + classValue + "'>"+visit_adm_date_time+"</td>");
				out.println("<td width = '25%' class='" + classValue + "'>"+visit_dis_date_time+"</td>");
				out.println("<td width = '50%' class='" + classValue + "'>"+(rs.getString(4)==null?"&nbsp;":rs.getString(4))+"</td>");
              deficiency_status=rs.getString("deficiency_status");
			deficiency_status = ((deficiency_status==null)||(deficiency_status.equals("null"))) ? "" : deficiency_status;  
			  
			  if(!deficiency_status.equals(""))
			{
				switch(deficiency_status.charAt(0))
				{
					case 'O' : deficiency_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels"); break;

					case 'C' : deficiency_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels"); break;

					case 'X' : deficiency_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels"); break;
				   
				}
			}
				  
			    if(deficiency_status.equals(""))
				{
                   deficiency_flag="&nbsp;";
				}
		   out.println("<td width = '50%' class='" + classValue + "'>"+deficiency_flag+"</td>");

            _bw.write(_wl_block18Bytes, _wl_block18);

			}


            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);

	if(i==0)
			{	
            _bw.write(_wl_block21Bytes, _wl_block21);
}
		}
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	if(rs1!=null)	rs1.close();
	if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedatetime.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DeficiencyStatus.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
