package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import com.ehis.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __diagrecodingaudittrailqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagRecodingAuditTrailQueryResult.jsp", 1720592359736L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t\n\t<script src=\'../../eMR/js/QueryDiagRecodingAuditTrail.js\' language=\'javascript\'></script>\t\n\t\n\t</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n <body OnMouseDown=\"CodeArrest()\" onLoad=\'loadHeader()\' onKeyDown=\'lockKey()\'> \n\t<form name=Trail_query_resultform>\n\t<!-- <div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:50%; visibility:hidden;\' bgcolor=\'red\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\' bgcolor=\'red\'>\n\t<tr >\n\t\t<td  width=\'100%\' id=\'t\'></td>\n\t\t</td>\n\t</tr>\n\t</table>\n\t</div> -->\n\t\t\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' >\n  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<tr>\n\t\t\t<td class=\'CAGROUPHEADING\' colspan=8\t><FONT   style=\'font-size:8pt\'><B>\n\t\t\t<!--Modified By Dharma on Mar 12th 2015 against against HSA-SCF-0205 [IN:053238]-->\n\t\t\t<!--";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" -->\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" / ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\n\t\t\t&nbsp; :</B>\n\t\t\t       ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</FONT>\n\t\t\t</td>\n\t  \t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t<td   width=\'14%\' class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t<a href=\"javascript:showEncounter(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t\t\t\t\n\t\t\t\t\t<td   width=\'15%\' class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   width=\'9%\' class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'\t>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td width=\'10%\' id=\"new_desc\" onMouseOver=\"displayToolTip_org(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',this);\" onMouseOut =\'hideToolTip();\' class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t<!--Commented by Dharma on Feb 5th 2015 against HSA-SCF-0205 [IN:053238]-->\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td width=\'10%\' id=\"new_desc\" onMouseOver=\"displayToolTip(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td  width=\'14%\'  class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</table>\n</form>\n</body>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</html>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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


String locale			= (String)session.getAttribute("LOCALE");
String facilityId		=	(String)session.getValue("facility_id");
request.setCharacterEncoding("UTF-8");
Connection con=null; 
Statement stmt=null;
ResultSet rset=null;  
String patient_id1="";
//String patient_id_prev="";
String classValue	 = "";
StringBuffer whereClause = new StringBuffer("");
String patient_id="";
String encounter_id="";
int andCheck=0;

int i=0;
String mr_diagnosis_code=request.getParameter("mr_diagnosis_code")==null?"":request.getParameter("mr_diagnosis_code");
if(mr_diagnosis_code == null) mr_diagnosis_code="";
String recodedfromdate=request.getParameter("recodedfromdate")==null?"":request.getParameter("recodedfromdate");

if(recodedfromdate == null) recodedfromdate="";
String recodedtodate=request.getParameter("recodedtodate")==null?"":request.getParameter("recodedtodate");
if(recodedtodate == null) recodedtodate="";
String mr_diagnosis_code1=request.getParameter("mr_diagnosis_code1")==null?"":request.getParameter("mr_diagnosis_code1");
if(mr_diagnosis_code1 == null) mr_diagnosis_code1="";
 patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
if(patient_id == null) patient_id=""; 
 encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
if(encounter_id == null) encounter_id="";
encounter_id=encounter_id.trim();
String update_by=request.getParameter("update_by")==null?"":request.getParameter("update_by");
if(update_by == null) update_by="";
//Newly added by Shyam on 17/09/2005
String location_hidden=request.getParameter("location_hidden")==null?"":request.getParameter("location_hidden");
if(location_hidden == null) location_hidden="";
String gender_val=request.getParameter("gender_val")==null?"":request.getParameter("gender_val");
if(gender_val == null) gender_val="";
String age_from=request.getParameter("age_from")==null?"":request.getParameter("age_from");
if(age_from == null) age_from="";
String age_to=request.getParameter("age_to")==null?"":request.getParameter("age_to");
if(age_to == null) age_to="";
String diagnosis_stage=request.getParameter("diagnosis_stage")==null?"":request.getParameter("diagnosis_stage");
if(diagnosis_stage == null) diagnosis_stage="";
String location_sel=request.getParameter("location_sel")==null?"":request.getParameter("location_sel");
if(location_sel == null) location_sel="";
String encounter_type_sel=request.getParameter("encounter_type_sel")==null?"":request.getParameter("encounter_type_sel");


if(encounter_type_sel == null) encounter_type_sel="";

try
{
	con =  ConnectionManager.getConnection(request); 
	
	if (!(mr_diagnosis_code == null || mr_diagnosis_code.equals("")) )
	{
		if(andCheck==0)
		{
			//whereClause modified on 8-3-2012 for the incident IN031056 - Begins
			whereClause.append(" and C.orig_term_code = '"+mr_diagnosis_code+"'");
			andCheck = 1;
		}
		else
		{
			whereClause.append(" and C.orig_term_code ='"+mr_diagnosis_code+"'");
		}
	}
	if (!(diagnosis_stage == null || diagnosis_stage.equals("")) )
	{
		if(andCheck==0)
		{
			whereClause.append("and D.encounter_id in (Select encounter_id from pr_diagnosis_enc_dtl where patient_id=a.patient_id and enc_stage='"+diagnosis_stage+"')");
     		//whereClause.append(" and a.ip_diag_stage = '"+diagnosis_stage+"'");
			andCheck = 1;
		}
		else
		{
			whereClause.append("and D.encounter_id in (Select encounter_id from pr_diagnosis_enc_dtl where patient_id=a.patient_id and enc_stage='"+diagnosis_stage+"')");
			//whereClause.append(" and a.ip_diag_stage =  '"+diagnosis_stage+"'");
		}
	}
	if (!(encounter_type_sel == null || encounter_type_sel.equals("")) )
	{
		if(andCheck==0)
		{
     	   whereClause.append(" and patient_class = '"+encounter_type_sel+"'");
		   andCheck = 1;
		}
		else
		{
			whereClause.append(" and patient_class = '"+encounter_type_sel+"'");
		}
	}
	//out.println("Before Locn Sel");
	if (!(location_sel == null || location_sel.equals("")) )
	{
		if(andCheck==0)
		{
     		whereClause.append(" and D.pat_curr_locn_type = '"+location_sel+"'");
			andCheck = 1;
		}
		else
		{
			whereClause.append(" and D.pat_curr_locn_type =  '"+location_sel+"'");
		}
		
	}
	if (!(location_hidden == null || location_hidden.equals("")) )
	 {
	  if(andCheck==0)
		{
     	   whereClause.append(" and D.pat_curr_locn_code = '"+location_hidden+"'");
		   andCheck = 1;
		}
		else
		{
			whereClause.append(" and D.pat_curr_locn_code = '"+location_hidden+"'");
		}
		
	}
	//out.println("Before Cal Age");
	if (!(age_from == null || age_from.equals("")) && (age_to == null || age_to.equals("")))
	 {
	  if(andCheck==0)
		{
     	   whereClause.append(" AND CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) >=   '"+age_from+"'");
		   andCheck = 1;
		}
		else
		{
			whereClause.append(" AND CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) >=  '"+age_from+"'");
		}
		
	}
	if (!(age_to == null || age_to.equals("")) )
	 {
	  if(andCheck==0)
		{
     	   whereClause.append(" AND CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) BETWEEN "+age_from+" AND "+age_to);
		   andCheck = 1;
		}
		else
		{
			whereClause.append(" AND CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) BETWEEN "+age_from+" AND "+age_to);
		   andCheck = 1;
		}
		
	}
	//out.println("Before Gender");
	if ( !(gender_val == null || gender_val.equals("")) )
	{
    	  if(andCheck==0)
	     {
		     whereClause.append("  AND B.SEX = '"+gender_val+"'");
		     andCheck = 1;
		 }
		 else
		{
		     whereClause.append("  AND B.SEX = '"+gender_val+"'");
		}
	}
	if ( !(patient_id == null || patient_id.equals("")) )
		{
		  if(andCheck==0)
			{
		   
			whereClause.append("  and a.patient_id = '"+patient_id+"'");
		    andCheck = 1;
			}
			else
			{
			whereClause.append(" and a.patient_id = '"+patient_id+"'");
			}
		
		}
	if ( !(encounter_id == null || encounter_id.equals("")) )
	{
		if(andCheck==0)
		{
//			whereClause.append(" and a.ONSET_ENCOUNTER_ID = '"+encounter_id+"'");
			whereClause.append(" and a.ENCOUNTER_ID = '"+encounter_id+"'");
			andCheck = 1;
		}
		else
		{
//			whereClause.append(" and a.ONSET_ENCOUNTER_ID = '"+encounter_id+"'");
			whereClause.append(" and a.ENCOUNTER_ID = '"+encounter_id+"'");
		}
	}
    
		if ( !(update_by == null || update_by.equals("")) )
		{
		  if(andCheck==0)
			{
		   whereClause.append(" and a.ADDED_BY_ID= '"+update_by+"'");
		   andCheck = 1;
			}
			else
			{
			whereClause.append(" and a.ADDED_BY_ID= '"+update_by+"'");
			}
		
		}
	//out.println("Before exists in prenc");
		///////////////////////
		if ( (!(recodedfromdate == null || recodedfromdate.equals(""))) && (!(recodedtodate == null || recodedtodate.equals(""))))
		{
		  if(andCheck==0)
			{
		  // whereClause.append(" and  EXISTS (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID and TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TO_DATE('"+recodedfromdate+"','DD/MM/YYYY') AND TO_DATE('"+recodedtodate+"','DD/MM/YYYY')) order by  a.added_date, a.patient_id, visit_adm_date_time, a.encounter_id");
		   whereClause.append(" and  EXISTS (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID and TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TO_DATE('"+recodedfromdate+"','DD/MM/YYYY') AND TO_DATE('"+recodedtodate+"','DD/MM/YYYY')) order by  a.patient_id, visit_adm_date_time, a.encounter_id,a.added_date ");
		   andCheck = 1;
			}
			else
			{
			//whereClause.append(" and  EXISTS (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID and TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TO_DATE('"+recodedfromdate+"','DD/MM/YYYY') AND TO_DATE('"+recodedtodate+"','DD/MM/YYYY')) order by a.added_date, a.patient_id, visit_adm_date_time, a.encounter_id");
			whereClause.append(" and  EXISTS (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID and TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TO_DATE('"+recodedfromdate+"','DD/MM/YYYY') AND TO_DATE('"+recodedtodate+"','DD/MM/YYYY')) order by a.patient_id, visit_adm_date_time, a.encounter_id,a.added_date ");
			}
		}
		else
		{
			//whereClause.append(" order by a.added_date, a.patient_id, visit_adm_date_time, a.encounter_id ");
			//whereClause.append(" order by a.patient_id, visit_adm_date_time, a.encounter_id,a.added_date ");  Jit- 06-mar-15
			whereClause.append(" order by a.patient_id,visit_adm_date_time, a.encounter_id, ORIG_RECORDED_DATE");
			
		}//whereClause modified on 8-3-2012 for the incident IN031056 - Ends

		//////////////////////
		
		//out.println("Before max rec");
	int maxRecord = 0;
	//out.println("After max rec");

            _bw.write(_wl_block8Bytes, _wl_block8);

	//out.println("Inside Query Result Line 334");

	//StringBuffer sqlBuff=new StringBuffer();
 	//sqlBuff.append("SELECT (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.ONSET_FACILITY_ID AND ENCOUNTER_ID = A.ONSET_ENCOUNTER_ID ) VISIT_ADM_DATE_TIME, A.PATIENT_ID, CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'"+locale+"'),'#') > 0 THEN SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'"+locale+"'), 1, INSTR( GET_PATIENT_LINE (A.PATIENT_ID,'"+locale+"'),'#')-1) END ) PATIENT_LINE, A.ONSET_FACILITY_ID, A.ONSET_ENCOUNTER_ID, A.ORIG_DIAG_CODE, (SELECT SHORT_DESC FROM MR_ICD_CODE WHERE DIAG_CODE_SCHEME=A.ORIG_DIAG_CODE_SCHEME AND DIAG_CODE=A.ORIG_DIAG_CODE AND NVL(RECORD_TYPE,'D')=NVL(A.ORIG_RECORD_TYPE,'D') AND NVL(CAUSE_INDICATOR,'*')=NVL(A.ORIG_CAUSE_INDICATOR,'*')) ORIG_DIAG_DESC, A.OLD_RECODED_DIAG_CODE,(SELECT SHORT_DESC FROM MR_ICD_CODE WHERE NVL(DIAG_CODE_SCHEME,'*')=NVL(A.OLD_RECODED_DIAG_CODE_SCHEME,'*') AND DIAG_CODE=NVL(A.OLD_RECODED_DIAG_CODE,'*') AND NVL(RECORD_TYPE,'D')=NVL(A.OLD_RECODED_RECORD_TYPE,'D') AND NVL(CAUSE_INDICATOR,'*')=NVL(A.OLD_RECODED_CAUSE_INDICATOR,'*')) OLD_RECODED_DIAG_DESC,A.OLD_REMARKS,A.NEW_RECODED_DIAG_CODE,(SELECT SHORT_DESC FROM MR_ICD_CODE WHERE DIAG_CODE_SCHEME=A.NEW_RECODED_DIAG_CODE_SCHEME AND DIAG_CODE=A.NEW_RECODED_DIAG_CODE AND NVL(RECORD_TYPE,'D')=NVL(A.NEW_RECODED_RECORD_TYPE,'D') AND NVL(CAUSE_INDICATOR,'*')=NVL(A.NEW_RECODED_CAUSE_INDICATOR,'*')) NEW_RECODED_DIAG_DESC, A.NEW_REMARKS,(SELECT appl_user_name FROM sm_appl_user         WHERE appl_user_id = a.added_by_id) added_by_id,TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY') ADDED_DATE,A.ADDED_AT_WS_NO,B.SEX,B.DATE_OF_BIRTH,GET_AGE(B.DATE_OF_BIRTH) AGE, A.PATIENT_CLASS,(SELECT SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS = A.PATIENT_CLASS) PATIENT_CLASS_DESC,A.IP_DIAG_STAGE, to_char(C.onset_date ,'dd/mm/yyyy') ORIG_RECORDED_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.onset_practitioner_id) ORIG_RECORDED_BY,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID) RECORDED_BY,to_char(A.ADDED_DATE,'dd/mm/yyyy') RECORDED_DATE,c.onset_remarks original_ramarks  FROM MR_DIAG_RECODING_AUDIT A,MP_PATIENT B,pr_diagnosis c,mr_term_code d  WHERE B.PATIENT_ID = A.PATIENT_ID AND A.PATIENT_ID = C.PATIENT_ID AND a.srl_no = c.occur_srl_no  AND c.term_set_id = d.term_set_id AND c.term_code = d.term_code ");
	
	/*Modified by Dharma on Feb 5th 2015 Against HSA-SCF-0205 [IN:053238] Start */
/*
	StringBuffer sqlBuff=new StringBuffer();
	sqlBuff.append("SELECT (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID ) VISIT_ADM_DATE_TIME, A.PATIENT_ID, CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'),'#') > 0 THEN SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'), 1, INSTR( GET_PATIENT_LINE (A.PATIENT_ID,'en'),'#')-1) END ) PATIENT_LINE, A.FACILITY_ID, A.ENCOUNTER_ID ONSET_ENCOUNTER_ID, C.ORIG_TERM_CODE ORIG_DIAG_CODE, C.ORIG_TERM_CODE OLD_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.ORIG_TERM_SET_ID and TERM_CODE=C.ORIG_TERM_CODE) ORIG_DIAG_DESC, C.TERM_CODE NEW_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.TERM_SET_ID and TERM_CODE=C.TERM_CODE) NEW_RECODED_DIAG_DESC, (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE appl_user_id = a.MODIFIED_BY_ID) ADDED_BY_ID, TO_CHAR(C.ADDED_DATE,'DD/MM/YYYY') ADDED_DATE, A.ADDED_AT_WS_NO, B.SEX, B.DATE_OF_BIRTH ,GET_AGE(B.DATE_OF_BIRTH) AGE, D.patient_class, (SELECT SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS = D.PATIENT_CLASS) PATIENT_CLASS_DESC,to_char(C.added_date ,'dd/mm/yyyy') ORIG_RECORDED_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.practitioner_id) ORIG_RECORDED_BY,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID) RECORDED_BY,to_char(C.RECORDED_DATE_TIME,'dd/mm/yyyy') RECORDED_DATE,(SELECT distinct onset_remarks FROM PR_DIAGNOSIS WHERE patient_id=a.patient_id and term_code=C.orig_term_code) original_ramarks, C.remarks new_remarks, lag(C.remarks,1) over(order by stage_srl_no) as old_remarks, (SELECT SHORT_DESC FROM mr_term_code WHERE term_set_id=C.TERM_SET_ID and term_code=C.TERM_CODE) OLD_RECODED_DIAG_DESC, (select enc_stage from pr_diagnosis_enc_dtl where patient_id=a.patient_id and encounter_id=a.encounter_id and term_code=c.ORIG_TERM_CODE ) ip_diag_stage FROM MR_DIAG_PROC_RECODING_HDR A, MP_PATIENT B,MR_DIAGNOSIS_RECODING_DTL C, PR_ENCOUNTER D where B.PATIENT_ID = A.PATIENT_ID AND C.STAGE_SRL_NO not in (1,2) AND C.STAGE_NO != 0 AND A.PATIENT_ID = C.PATIENT_ID AND A.ENCOUNTER_ID=C.ENCOUNTER_ID and A.ENCOUNTER_ID=D.ENCOUNTER_ID AND a.facility_id= '"+facilityId+"' ");
	*/
	//Query modified on 8-3-2012 for the incident 31056
	
	StringBuffer sqlBuff=new StringBuffer();
	//sqlBuff.append("SELECT (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID ) VISIT_ADM_DATE_TIME, A.PATIENT_ID, CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'),'#') > 0 THEN SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'), 1, INSTR( GET_PATIENT_LINE (A.PATIENT_ID,'en'),'#')-1) END ) PATIENT_LINE, A.FACILITY_ID, A.ENCOUNTER_ID ONSET_ENCOUNTER_ID, C.ORIG_TERM_CODE ORIG_DIAG_CODE, C.ORIG_TERM_CODE OLD_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.ORIG_TERM_SET_ID and TERM_CODE=C.ORIG_TERM_CODE) ORIG_DIAG_DESC, C.TERM_CODE NEW_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.TERM_SET_ID and TERM_CODE=C.TERM_CODE) NEW_RECODED_DIAG_DESC, (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE appl_user_id = a.MODIFIED_BY_ID) ADDED_BY_ID, TO_CHAR(C.ADDED_DATE,'DD/MM/YYYY hh24:mi:ss') ADDED_DATE, A.ADDED_AT_WS_NO, B.SEX, B.DATE_OF_BIRTH ,GET_AGE(B.DATE_OF_BIRTH) AGE, D.patient_class, (SELECT SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS = D.PATIENT_CLASS) PATIENT_CLASS_DESC,to_char(C.added_date ,'dd/mm/yyyy hh24:mi') ORIG_RECORDED_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.practitioner_id) ORIG_RECORDED_BY,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.ADDED_BY_ID) RECORDED_BY,to_char(C.RECORDED_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') RECORDED_DATE,(SELECT distinct onset_remarks FROM PR_DIAGNOSIS WHERE patient_id=a.patient_id and term_code=C.orig_term_code) original_ramarks, C.remarks new_remarks, lag(C.remarks,1) over(order by stage_srl_no) as old_remarks, (SELECT SHORT_DESC FROM mr_term_code WHERE term_set_id=C.TERM_SET_ID and term_code=C.TERM_CODE) OLD_RECODED_DIAG_DESC, (select enc_stage from pr_diagnosis_enc_dtl where patient_id=a.patient_id and encounter_id=a.encounter_id and term_code=c.ORIG_TERM_CODE ) ip_diag_stage, mr_get_orig_term_code_dtls(C.FACILITY_ID,C.ENCOUNTER_ID,C.STAGE_SRL_NO) org_rec_data FROM MR_DIAG_PROC_RECODING_HDR A, MP_PATIENT B,MR_DIAGNOSIS_RECODING_DTL C, PR_ENCOUNTER D where B.PATIENT_ID = A.PATIENT_ID AND C.STAGE_SRL_NO not in (1,2) AND C.STAGE_NO != 0 AND A.PATIENT_ID = C.PATIENT_ID AND A.ENCOUNTER_ID=C.ENCOUNTER_ID and A.ENCOUNTER_ID=D.ENCOUNTER_ID AND a.facility_id= '"+facilityId+"' ");

	sqlBuff.append("SELECT (SELECT to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') FROM PR_ENCOUNTER WHERE FACILITY_ID = A.FACILITY_ID AND ENCOUNTER_ID = A.ENCOUNTER_ID ) VISIT_ADM_DATE_TIME, A.PATIENT_ID, CALCULATE_AGE(TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY'),1) AGE, (CASE WHEN INSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'),'#') > 0 THEN SUBSTR(GET_PATIENT_LINE(A.PATIENT_ID,'en'), 1, INSTR( GET_PATIENT_LINE (A.PATIENT_ID,'en'),'#')-1) END ) PATIENT_LINE, A.FACILITY_ID, A.ENCOUNTER_ID ONSET_ENCOUNTER_ID, C.ORIG_TERM_CODE ORIG_DIAG_CODE, C.ORIG_TERM_CODE OLD_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.ORIG_TERM_SET_ID and TERM_CODE=C.ORIG_TERM_CODE) ORIG_DIAG_DESC, C.TERM_CODE NEW_RECODED_DIAG_CODE, (SELECT SHORT_DESC FROM MR_TERM_CODE WHERE TERM_SET_ID=C.TERM_SET_ID and TERM_CODE=C.TERM_CODE) NEW_RECODED_DIAG_DESC, (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE appl_user_id = a.MODIFIED_BY_ID) ADDED_BY_ID, TO_CHAR(C.ADDED_DATE,'DD/MM/YYYY hh24:mi:ss') ADDED_DATE, A.ADDED_AT_WS_NO, B.SEX, B.DATE_OF_BIRTH ,GET_AGE(B.DATE_OF_BIRTH) AGE, D.patient_class, (SELECT SHORT_DESC FROM AM_PATIENT_CLASS WHERE PATIENT_CLASS = D.PATIENT_CLASS) PATIENT_CLASS_DESC,to_char(C.added_date ,'dd/mm/yyyy hh24:mi') ORIG_RECORDED_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.practitioner_id) ORIG_RECORDED_BY,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID=C.MODIFIED_BY_ID) RECORDED_BY,to_char(C.MODIFIED_DATE,'dd/mm/yyyy hh24:mi:ss') RECORDED_DATE,(SELECT distinct CASE WHEN LENGTH(onset_remarks)>30 THEN SUBSTR(onset_remarks,1,30)||'..' ELSE SUBSTR(onset_remarks,1,30) END FROM PR_DIAGNOSIS WHERE patient_id=a.patient_id and term_code=C.orig_term_code) original_ramarks,  CASE WHEN LENGTH(C.remarks)>30 THEN SUBSTR(C.remarks,1,30)||'..' ELSE SUBSTR(C.remarks,1,30) END new_remarks, lag(C.remarks,1) over(order by stage_srl_no) as old_remarks, (SELECT SHORT_DESC FROM mr_term_code WHERE term_set_id=C.TERM_SET_ID and term_code=C.TERM_CODE) OLD_RECODED_DIAG_DESC, (select enc_stage from pr_diagnosis_enc_dtl where patient_id=a.patient_id and encounter_id=a.encounter_id and term_code=c.ORIG_TERM_CODE and OCCUR_SRL_NO=c.OCCUR_SRL_NO) ip_diag_stage, mr_get_orig_term_code_dtls(C.FACILITY_ID,C.ENCOUNTER_ID,C.STAGE_SRL_NO) org_rec_data FROM MR_DIAG_PROC_RECODING_HDR A, MP_PATIENT B,MR_DIAGNOSIS_RECODING_DTL C, PR_ENCOUNTER D where B.PATIENT_ID = A.PATIENT_ID AND C.STAGE_NO != 0 AND A.PATIENT_ID = C.PATIENT_ID AND A.ENCOUNTER_ID=C.ENCOUNTER_ID and A.ENCOUNTER_ID=D.ENCOUNTER_ID AND a.facility_id= '"+facilityId+"' and C.RECODE_STATUS not in ( 'E' ,'O')");


	


	/*Modified by Dharma on Feb 5th 2015 Against HSA-SCF-0205 [IN:053238] End*/
	sqlBuff.append(whereClause.toString()); 
	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
    rset=stmt.executeQuery(sqlBuff.toString());
	rset.last();
	maxRecord=rset.getRow();
	rset.beforeFirst();
	if(maxRecord == 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
		out.println("parent.parent.frames[2].frames[3].location.href='../../eCommon/html/blank.html'");
		out.println("parent.parent.frames[2].frames[2].location.href='../../eCommon/html/blank.html' </script>");
	}else{
		while (rset.next())
    {
		//if patient_id_prev
		patient_id1=rset.getString("PATIENT_ID");  
		
		i=1;
		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((rset.getString("PATIENT_LINE")==null?"":rset.getString("PATIENT_LINE"))));
            _bw.write(_wl_block13Bytes, _wl_block13);
 classValue = "QRYEVEN" ;
               String new_diag_desc="";
			   String new_diag_remarks="";
			   String ip_diag_stage="";
			   String diag_type="";
			   String orig_recorded_date="";
			   String orig_recorded_by="";
			   StringBuffer concat=new StringBuffer("");
			   String old_diag_desc="";
			   String old_diag_remarks="";
			   String old_new_recorded_by="";
			   String old_new_recorded_date="";
				String old_recoded_code="";
				String new_recoded_code="";
				String orig_rec_data	= ""; //Added by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238]
			  // if (old_recoded_diag_code != null && new_recoded_diag_code != null && old_recoded_diag_code.equals(new_recoded_diag_code))
				//	break;
			   StringBuffer concat1=new StringBuffer("");
			   String original_ramarks="";
			while(patient_id1.equals(rset.getString("PATIENT_ID")))
		    {
				old_recoded_code=rset.getString("OLD_RECODED_DIAG_CODE");
				new_recoded_code=rset.getString("NEW_RECODED_DIAG_CODE");
				
				 /*below line was commented by venkatesh.s on 04-MARCH-2013 Reason is java.sql.SQLException: Exhausted Resultset  error happening */
				/*if (old_recoded_code != null && new_recoded_code != null && old_recoded_code.equals(new_recoded_code))
				{
					rset.next();
					continue;
				}*/
				old_new_recorded_by=checkForNull(rset.getString("RECORDED_BY"));
				old_new_recorded_date=checkForNull(rset.getString("RECORDED_DATE"));

				new_diag_desc=checkForNull(rset.getString("NEW_RECODED_DIAG_DESC"));
				new_diag_remarks=checkForNull(rset.getString("NEW_REMARKS"));
				ip_diag_stage=checkForNull(rset.getString("ip_diag_stage"));
				//diag_type=checkForNull(rset.getString("diag_type"));
				/* Commented by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238] Start */
				//orig_recorded_date=checkForNull(rset.getString("orig_recorded_date"));
				//orig_recorded_by=checkForNull(rset.getString("orig_recorded_by"));
				/* Commented by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238] End */
				original_ramarks=checkForNull(rset.getString("original_ramarks"));
                //Added by shyam on 03/11/2005///
				
				if(diag_type.equals("P")) diag_type="Provisional";
				else if(diag_type.equals("D")) diag_type="Differential";
				else if(diag_type.equals("F")) diag_type="Final";
               
			    if(ip_diag_stage.equals("A")) ip_diag_stage="Admission";
				else if(ip_diag_stage.equals("I")) ip_diag_stage="Intermediate";
				else if(ip_diag_stage.equals("D")) ip_diag_stage="Discharge";

				concat.append(new_diag_desc+"!"+new_diag_remarks+"|");

				old_diag_desc=checkForNull(rset.getString("ORIG_DIAG_DESC"));
				old_diag_remarks=checkForNull(rset.getString("OLD_REMARKS"));
				concat1.append(old_diag_desc+"!"+old_diag_remarks+"|");
				/*Added by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238] Start*/
				orig_rec_data			= checkForNull(rset.getString("org_rec_data"));
				if(!orig_rec_data.equals("") && !orig_rec_data.equals(null)){
					if(orig_rec_data.contains("@@@")){
						String arr_orig_rec_data[]	= orig_rec_data.split("@@@");
						orig_recorded_by			= arr_orig_rec_data[0];
						orig_recorded_date			= arr_orig_rec_data[1];
					}
				}
				/*Added by Dharma on Mar 9th 2015 against HSA-SCF-0205 [IN:053238] End*/
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rset.getString("ONSET_ENCOUNTER_ID")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rset.getString("PATIENT_ID")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((rset.getString("PATIENT_CLASS")==null)?"":rset.getString("PATIENT_CLASS")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rset.getString("ONSET_ENCOUNTER_ID")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);

						String vis_dat_tim_display = rset.getString("VISIT_ADM_DATE_TIME");
						if(vis_dat_tim_display == null) 
							vis_dat_tim_display = "&nbsp;";
						else
							vis_dat_tim_display = DateUtils.convertDate(vis_dat_tim_display,"DMYHM","en",locale);
						out.println(vis_dat_tim_display);
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rset.getString("PATIENT_CLASS_DESC")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(rset.getString("ORIG_DIAG_DESC"))));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(original_ramarks)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ip_diag_stage));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(diag_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orig_recorded_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orig_recorded_by));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rset.getString("ORIG_DIAG_CODE")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(java.net.URLEncoder.encode(new_diag_desc) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(new_diag_remarks) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ip_diag_stage));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(diag_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(old_new_recorded_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(old_new_recorded_by));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((rset.getString("NEW_RECODED_DIAG_CODE")==null)?"&nbsp;":rset.getString("NEW_RECODED_DIAG_CODE")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
// =(rset.getString("ADDED_BY_ID")==null)?"&nbsp; ":rset.getString("ADDED_BY_ID") ---- Jit- 06-mar-15
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((rset.getString("RECORDED_BY")==null)?"&nbsp; ":rset.getString("RECORDED_BY")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
					
						/*String added_dat_display = rset.getString("ADDED_DATE");
 
						if(added_dat_display == null || added_dat_display.equals("")) 
							added_dat_display = "&nbsp;";
						else
							dded_dat_display = DateUtils.convertDate(added_dat_display,"DMY","en",locale);
							added_dat_display = DateUtils.convertDate(added_dat_display,"DMYHMS","en",locale);*/
						// Modified By Dharma on Mar 16th 2015 against HSA-SCF-0205 [IN:053238]

 
						out.println(old_new_recorded_date);
					
            _bw.write(_wl_block30Bytes, _wl_block30);

			if(rset.next()) 
		    {
			  if (i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				i++;

			}
			else
			{
				break;
			}
				
			}
			rset.previous();
		}
	}
if(rset!=null)
	rset.close();
if(stmt!=null)
	stmt.close();


            _bw.write(_wl_block31Bytes, _wl_block31);

}
catch(Exception e)
{	
	//out.println("Exception="+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.PatientIdName.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
}
