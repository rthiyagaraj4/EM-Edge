package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;

public final class __trmtcomplicationheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/TrmtComplicationHeader.jsp", 1742903747344L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--Created by sathish on 20-01-2010-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eOH/js/TrmtComplicationDetails.js\" language=\"javascript\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/Hashtable.js\"></script>\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t<form name=\"TrmtComplicationHeaderForm\" id=\"TrmtComplicationHeaderForm\" method=\"post\">\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t\t<table border=\"0\" width=\"98%\" cellspacing=\'0\' cellpadding=\'2\'  align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'CAGROUPHEADING\' width=\"20%\" colspan=4>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=\"1\" width=\"98%\" cellspacing=\'0\' cellpadding=\'2\'  align=\'center\'>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t</table>\n\t\t\t<br>\n\t\t   ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<table align=\'right\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"delete1\" id=\"delete1\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onclick =\"deleteCompRecorded()\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t\t<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t\t<input type=\"hidden\" name=\"totalSelected\" id=\"totalSelected\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t\t<input type=\"hidden\" name=\"tooth_range_count_for_order\" id=\"tooth_range_count_for_order\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t\t<input type=\"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<input type=\"hidden\" name= \"chart_num\" value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<input type=\"hidden\" name= \"chart_line_num\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<input type=\"hidden\" name= \"trmt_code\" value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<input type=\"hidden\" name= \"maxRecord\" value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<input type=\"hidden\" name= \"i\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t<input type=\"hidden\" name= \"totalrec\" value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t<input type=\"hidden\" name= \"modified_flag\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t<input type=\"hidden\" name= \"ind_chart_line_num\" value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t<input type=\"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t<input type=\"hidden\" name= \"task_code_req\" value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t<input type=\"hidden\" name= \"status_disabled\" value = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\n\t\t\t\n\t\t\t<input type=\"hidden\" name= \"task_desc\" value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\n\n\t\t\t<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t<input type = \"hidden\" name= \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t<input type = \"hidden\" name= \"seq_no\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection conn=null;												    
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String strsql = "";
    int maxRecord = 0;
	int totalrec=0;
	String modified_flag="N";
	String facility_id = (String)session.getValue( "facility_id" ) ;
    String task_code_req = checkForNull(request.getParameter("task_code_req")); 
    String task_cmplication_cmpl_yn=  "";
	String disable_flag="";
    String task_desc = checkForNull(request.getParameter("task_desc"));
    String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));
    String date_diff_flag = checkForNull(request.getParameter("date_diff_flag"));//Added by Sridevi Joshi on 6/1/2010 for IN021668

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
   
			 String select_value="Y";
			 String select_checked="";
			 String complication_code="";
			 String complication_desc="";
			 //String composition_desc="";
			 String complication_remarks="";
			 String complication_seq_no="";
			 String classValue="";

			 String from = checkForNull(request.getParameter( "from" )) ;
			 String to =   checkForNull(request.getParameter( "to" ) ) ;

			 int start = ( from.equals("") )?1:Integer.parseInt(from);
			 int end =  ( to.equals("") )?10:Integer.parseInt(to);

			 int total=0;

			 int i=1;

			 StringBuffer sbr = new StringBuffer();
			 String totalSelected=checkForNull(request.getParameter("totalSelected"));
			 String tooth_range_count_for_order=checkForNull(request.getParameter("tooth_range_count_for_order"));
			 String patient_id=checkForNull(request.getParameter("patient_id"));
			 String chart_num=checkForNull(request.getParameter("chart_num"));
			 String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
			 String trmt_code=checkForNull(request.getParameter("trmt_code"));
			 String ind_chart_line_num=checkForNull(request.getParameter("ind_chart_line_num"));
			 String status_disabled =  checkForNull(request.getParameter("status_disabled"));
			 String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
			 String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
             
			 
			 String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;	
			 String others_label =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.othersfreetext.Label","oh_labels");
			 if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
				other_chart_facility_id=facility_id;
			 }

			 if(!other_chart_facility_id.equals(facility_id)){
				status_disabled = "disabled";
			 }
			 
			 try{
				conn  =  ConnectionManager.getConnection(request);
				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();

				pstmt=conn.prepareStatement("SELECT TASK_CMPLICATION_CMPL_YN TASK_CMPLICATION_CMPL_YN1 FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ? AND TASK_CODE=? AND TASK_SEQ = ?");
				pstmt.setString(1,patient_id); 
				pstmt.setString(2,chart_num); 
				pstmt.setString(3,chart_line_num); 
				pstmt.setString(4,trmt_code); 
				pstmt.setString(5,task_code_req); 
				pstmt.setString(6,seq_no); 
				rst = pstmt.executeQuery();

				while(rst.next()){
					task_cmplication_cmpl_yn = rst.getString("TASK_CMPLICATION_CMPL_YN1");
				}
				
				//By Sridevi Joshi for CRF-709(IN012626) : This is to disable the fields if dataentry is already completed and we are loading this page without closing the window.
				if(task_cmplication_cmpl_yn.equals("Y") || ("Y").equals(baseline_chart_yn) || date_diff_flag.equals("disable")){//condition for date_diff_flag is added by Sridevi Joshi on 6/1/2010 for IN021668
					disable_flag= "disabled";
				}else{
					disable_flag= "";
				}

				//strsql="SELECT A.TASK_CODE,C.TASK_DESC,A.COMPLICATION_CODE, A.COMPLICATION_REMARKS, A.COMPLICATION_SEQ_NO, B.COMPLICATION_DESC COMPLICATION_DESC FROM OH_RESTO_CHRT_COMPLICATION  A,  (SELECT COMPLICATION_CODE, COMPLICATION_DESC FROM OH_COMPLICATION  UNION SELECT '$OTH','OTHERS' FROM DUAL) B, OH_TASKS_LANG C WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPLICATION_CODE = B.COMPLICATION_CODE AND A.TASK_CODE =C.TASK_CODE AND C.LANGUAGE_ID = ? ORDER BY B.COMPLICATION_DESC,A.COMPLICATION_REMARKS";
				strsql="SELECT A.TASK_CODE,C.TASK_DESC,A.COMPLICATION_CODE, A.COMPLICATION_REMARKS, A.COMPLICATION_SEQ_NO,DECODE(B.COMPLICATION_CODE,'$OTH',A.COMPLICATION_REMARKS,B.COMPLICATION_DESC) COMPLICATION_DESC  FROM OH_RESTO_CHRT_COMPLICATION  A,  (SELECT COMPLICATION_CODE, COMPLICATION_DESC FROM OH_COMPLICATION  UNION SELECT '$OTH','OTHERS' FROM DUAL) B, OH_TASKS_LANG C WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.TASK_SEQ = ? AND A.COMPLICATION_CODE = B.COMPLICATION_CODE AND A.TASK_CODE =C.TASK_CODE AND C.LANGUAGE_ID = ? ORDER BY COMPLICATION_DESC";
				
				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
				pstmt = conn.prepareStatement(strsql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,ind_chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,task_code_req);
				pstmt.setString(6,seq_no);
				pstmt.setString(7,locale);
				rst = pstmt.executeQuery();
				while(rst.next()){
					total++;
				}
				maxRecord = total;

				pstmt = conn.prepareStatement(strsql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,task_code_req);
				pstmt.setString(6,seq_no);
				pstmt.setString(7,locale);
				rst = pstmt.executeQuery();
			
            _bw.write(_wl_block7Bytes, _wl_block7);

							int m=1;
							for(int k=1;k<=maxRecord;k=k+10){
								if(maxRecord > 10){
									out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='showRecords("+k+");'>"+m+"</font>");
								}
								m++;
							}
						
            _bw.write(_wl_block8Bytes, _wl_block8);

					if ( start != 1 ){
						for( int j=1; j<start; i++,j++ ){
							rst.next() ;
						}
					}
				
					while ( rst.next() && i<=end  ){
						classValue  = ( i % 2 == 0 )?"QRYEVENSMALL":"QRYODDSMALL" ;
						complication_code= rst.getString("COMPLICATION_CODE");
						complication_desc= rst.getString("COMPLICATION_DESC");
						//composition_desc=rst.getString("COMPOSITION_DESC");
						complication_remarks=checkForNull(rst.getString("COMPLICATION_REMARKS"));
						complication_seq_no=checkForNull(rst.getString("COMPLICATION_SEQ_NO"));

						
						
						sbr.append("<tr>");
						if(("$OTH").equals(complication_code)) 
						{
						sbr.append("<td  width='60%' class='"+classValue+"' wrap>"+complication_remarks+"-"+others_label+"</td>");
						}else 
						{
						sbr.append("<td  width='60%' class='"+classValue+"' wrap>"+complication_desc+"</td>");
						}
						//sbr.append("<td  width='30%' class='"+classValue+"' wrap>"+composition_desc+"</td>");
						sbr.append("<td  width='10%' class='" + classValue+"'><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" complication_seq_no='"+complication_seq_no+"' complication_remarks='"+complication_remarks+"' complication_code='"+complication_code+"'select_yn='"+select_value+"'modified_flag='"+modified_flag+"' onclick='validateCheckBox(this)'" +status_disabled+" "+disable_flag+" >");
						sbr.append("</td>");
						sbr.append("</tr>");
						
						if(totalSelected!=null && !totalSelected.equals(null) && totalSelected.length()>0){
							String tokens[] = totalSelected.split(",");
							for(int p = 0;p<tokens.length;p++){
								if(Integer.parseInt(tokens[p])==i)
									sbr.append("<script>assingListItemValue("+tokens[p]+");</script>");
							}
						}
						i++;
					}	
					out.println(sbr.toString());	
				
            _bw.write(_wl_block9Bytes, _wl_block9);
 
		   }catch(Exception e){
				out.println("TrmtDetailsForm : "+e);
			}finally{
				try{
					if(rst!=null)	rst.close();
					if(pstmt!=null)	pstmt.close();
					if(sbr!=null)   sbr.setLength(0);
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
		   
            _bw.write(_wl_block10Bytes, _wl_block10);
if(!task_code_req.equals("")){
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(totalSelected));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tooth_range_count_for_order));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(totalrec));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(modified_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ind_chart_line_num));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(task_code_req));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
}
