package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __medrecadminalertresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MedRecAdminAlertResult.jsp", 1709115939652L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n    \n\t<link rel=\'stylesheet\' type=\'text/css\' href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\t\n\t<script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></script>\n\t<script language=\"javascript\" src=\"../js/MedRecAdminAlert.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'MedRecAdminAlertResult_Form\' id=\'MedRecAdminAlertResult_Form\' >\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table cellpadding=\'3\' align=\'center\' width=\'100%\'>\n\t\t\t\t<tr >\n\t\t\t<td  width=\'100%\' class=\'white\' ></td>\n\t\t\t\t<td nowrap width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\t\t\n    \t<table class=\"grid\" width=\'100%\' border=\'0\' cellpadding=\'3\' cellspacing=\'0\'>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\t\n        \n\t</form>\n</body>\n</html>\n\t\t\t\n\t\t\t\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			
			Connection con = null;			
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");					
				String classValue = "gridData";

				String from 					= request.getParameter("from") ;
	
				String to 						= request.getParameter("to") ;

				String fromDate			=	request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
				
				String toDate			=	request.getParameter("ToDate") == null ? "" : request.getParameter("ToDate"); 
				if(!localeName.equals("en"))
				{
                 fromDate		=	com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
			     toDate	=	com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
				}
				
				 String group_by	=	request.getParameter("group_by") == null ? "" :		request.getParameter("group_by");

				
				 String practitioner_id	=	request.getParameter("practitioner_id") == null ? "" :		request.getParameter("practitioner_id");
				 String code	=	request.getParameter("code") == null ? "" :		request.getParameter("code");	
				 String fnName	=	request.getParameter("fnName") == null ? "" :		request.getParameter("fnName");
		       

				 String Categ_desc = "";
				 String Event_desc = "";
				 String GroupLabel = "";
				 String group1Value = "";
				 String group1Ref = "";
				 String group2Ref = "";
				 String prevGroup1Value = "";
				 String group2Value = "";
				 String alert_remarks = "";
				 //String Patient_id = "";
				 //String Patient_name = "";
				//String encounter_id = "";
				 String action_pend_datetime = "";
				 //String facility_id = "";				 
				 StringBuffer sql1 = new StringBuffer();
				 StringBuffer sql2 = new StringBuffer();
				 //String displaycatalog = "";
			   con = ConnectionManager.getConnection(request);
			   PreparedStatement stmt= null;
			   PreparedStatement stmt1= null;
			   ResultSet rset=null;
			   ResultSet rset1=null;
			   int count =0;
			   int count1 =0;
			  int k =	0;
				int maxRecord = 0;
				int start = 0 ;
				int end = 0 ;
				int i=1;

				if ( from == null )
					start = 1 ;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null )
	  				end = 10 ;
				else
				end = Integer.parseInt( to ) ;			
				
				try
			 {
			sql2.append("SELECT COUNT(*) total_records  FROM CA_ALERT_CATEG_LANG a,CA_ALERT_ACTION_LOG b WHERE  a.ALERT_CATEG_CODE=b.ALERT_CATEG_CODE   AND  b.ACTION_PEND_DATETIME BETWEEN TO_DATE(?,'DD/MM/YYYY')  AND TO_DATE(?,'DD/MM/YYYY') AND a.LANGUAGE_ID = ?");
		
			if(!(code.equals("")||code.equals("null")))
				{
					sql2.append( "and b.ALERT_CATEG_CODE =? ");
				}	
				if(!(practitioner_id.equals("")||practitioner_id.equals("null"))){
					sql2.append( "and b.ACTION_BY_USER_ID =? ");
				}
				stmt1 = con.prepareStatement(sql2.toString());			   	  
			    stmt1.setString(++count1,fromDate);
			    stmt1.setString(++count1,toDate);
			    stmt1.setString(++count1,locale);
           if(!(code.equals("")||code.equals("null")))
			{
                stmt1.setString(++count1,code);
			}

			 if(!(practitioner_id.equals("")||practitioner_id.equals("null")))
				{
				
					stmt1.setString(++count1,practitioner_id);
					}
		    rset1 = stmt1.executeQuery();		
			if(rset1.next())
			{
				maxRecord = rset1.getInt("total_records");	
				
			}
			
			if (rset1 != null)
				rset1.close();

			if (stmt1 != null)
				stmt1.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		 if(maxRecord==0){	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");	}	
		 if(maxRecord !=0) { 
            _bw.write(_wl_block8Bytes, _wl_block8);



				if ( !(start <= 1) )
				{
				out.println("<A HREF='../../eCA/jsp/MedRecAdminAlertResult.jsp?from="+(start-10)+"&to="+(end-10)+"&code="+code+"&practitioner_id="+practitioner_id+"&fromDate="+fromDate+"&ToDate="+toDate+"&group_by="+group_by+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");					
		  }			

				  if ( !( (start+10) >= maxRecord ) )
					{
			out.println("<A HREF='../../eCA/jsp/MedRecAdminAlertResult.jsp?from="+(start+10)+"&to="+(end+10)+"&code="+code+"&practitioner_id="+practitioner_id+"&fromDate="+fromDate+"&ToDate="+toDate+"&group_by="+group_by+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");	

	}
	

            _bw.write(_wl_block9Bytes, _wl_block9);
  
			
				if(group_by.equals("PAT")) 
				{
					group1Ref="  mp.PATIENT_NAME||', '||mp.sex||'/'||get_age(mp.date_of_birth)||','||mp.PATIENT_ID||', '||pr.encounter_id||','|| case when pr.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(pr.facility_id,pr.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(pr.facility_id,pr.ASSIGN_CARE_LOCN_CODE,?,'2') end ||','||AM_GET_DESC.AM_PATIENT_CLASS(pr.patient_class, ?,'2') ";
					group2Ref="  d.APPL_USER_NAME ";
					GroupLabel="Common.user.label";
				}
				else
			 	{
					group2Ref="   mp.PATIENT_NAME||', '||mp.sex||'/'||get_age(mp.date_of_birth)||','||mp.PATIENT_ID||'<br>'||pr.encounter_id||','|| case when pr.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(pr.facility_id,pr.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(pr.facility_id,pr.ASSIGN_CARE_LOCN_CODE,?,'2') end ||','||AM_GET_DESC.AM_PATIENT_CLASS(pr.patient_class, ?,'2')  ";
					group1Ref="  d.APPL_USER_NAME ";
					GroupLabel="Common.PatientDetails.label";
				}
				if(fnName.equals("CAMS_MRADMIN_ALERT")) 
				{
					
				out.println("<tr><td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,GroupLabel,"common_labels")+"</td>");

				}
				
				out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategory.label","ca_labels")+"</td>");
				//out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventDescription.label","common_labels")+"</td>");
				out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionEvent.label","ca_labels")+"</td>");
				out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DateAndTime.label","ca_labels")+"</td>");
				out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</td>");
				out.println("</tr>");
				sql1.append("SELECT "+group1Ref+" group1Value, "+group2Ref +" group2Value,  a.ALERT_CATEG_DESC,c.ALERT_EVENT_DESC,to_char(ACTION_PEND_DATETIME,'dd/mm/yyyy hh24:mi') ACTION_PEND_DATETIME, b.ALERT_REMARKS FROM mp_patient mp,pr_encounter pr,CA_ALERT_CATEG_LANG a,CA_ALERT_ACTION_LOG b,CA_ALERT_EVENT_LANG_VW c ,sm_appl_user_lang_vw d WHERE mp.PATIENT_ID=pr.PATIENT_ID AND a.ALERT_CATEG_CODE=b.ALERT_CATEG_CODE and b.ALERT_EVENT_CODE=c.ALERT_EVENT_CODE  and b.facility_id=pr.facility_id and b.ENCOUNTER_ID=pr.encounter_id and  b.ACTION_PEND_DATETIME BETWEEN to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and a.LANGUAGE_ID = ? AND C.LANGUAGE_ID=A.LANGUAGE_ID and d.appl_user_id=b.ACTION_BY_USER_ID and d.LANGUAGE_ID=A.LANGUAGE_ID ");
									
				if(!(code.equals("")||code.equals("null")))
				{
					sql1.append( "and b.ALERT_CATEG_CODE =? ");
				}	
				if(!(practitioner_id.equals("")||practitioner_id.equals("null"))){
					sql1.append( " and b.ACTION_BY_USER_ID =? ");
				}
				sql1.append( " order by 1,2 ");
				stmt = con.prepareStatement(sql1.toString());	
				stmt.setString(++count,locale);
				stmt.setString(++count,locale);
				stmt.setString(++count,locale);
				stmt.setString(++count,fromDate);
				stmt.setString(++count,toDate);
				stmt.setString(++count,locale);
				if(!(code.equals("")||code.equals("null")))
				{
					stmt.setString(++count,code);
				}

				if(!(practitioner_id.equals("")||practitioner_id.equals("null")))
				{
					stmt.setString(++count,practitioner_id);
				}	
				//stmt.setString(++count,group_by);
				rset = stmt.executeQuery();
				if ( start != 1 )
				{
					for( int j=1; j<start; i++,j++ )
						 rset.next() ;
				}
				while(rset!=null && rset.next() && i<=end)   
				{	
				 group1Value = rset.getString("group1Value")==null?"":rset.getString("group1Value");
				 group2Value = rset.getString("group2Value")==null?"":rset.getString("group2Value");
				 Categ_desc = rset.getString("ALERT_CATEG_DESC")==null?"":rset.getString("ALERT_CATEG_DESC");
				 Event_desc = rset.getString("ALERT_EVENT_DESC")==null?"":rset.getString("ALERT_EVENT_DESC");
				 action_pend_datetime = rset.getString("action_pend_datetime")==null?"":rset.getString("action_pend_datetime");
				 alert_remarks = rset.getString("ALERT_REMARKS")==null?"":rset.getString("ALERT_REMARKS");
				 if (!prevGroup1Value.equals(group1Value))
					{
					 out.println("<tr>");
					 out.println("<td class='"+classValue+"' name='Patdetail' colspan='4'><B>"+group1Value+"</B></td></tr>");
					 out.println("<tr>");	
					 prevGroup1Value=group1Value;
					}
					if(fnName.equals("CAMS_MRADMIN_ALERT")) 
				{
					
				out.println("<td  class='"+classValue+"' name='group2'>"+group2Value);

				}
				 	
				 out.println("</td><td  class='"+classValue+"' name='Catdesc'>"+Categ_desc);	
				 out.println("</td><td  class='"+classValue+"' name='Eventdesc'>"+Event_desc);	
				 out.println("</td><td  class='"+classValue+"' name='action_pend_datetime'>"+action_pend_datetime);	
				 out.println("</td><td  class='"+classValue+"' name='alertremarks'>"+alert_remarks);	
				 out.println("</td></tr>");
				
				  k++;
				 i++;
				 }
				 
			 if(k==0)
				 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			  }
			  
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
 
}
catch(Exception e)
{
	//out.println("Exception at try of MedRecAdminAlertResult.jsp -"+e.toString());//common-icn-0181
	e.printStackTrace();
}
finally 
{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
