package jsp_servlet._eoh._jsp;

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

public final class __periosummaryactive extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/PerioSummaryActive.jsp", 1709119362864L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</title>\n\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/PerioChart.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form >\n<table align=\'center\' cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'30%\'></td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'70%\' style=\'text-align:left\'>\n\t\t\t\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<!--  added 210108 by parul for  SCR#6149  -->\n\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<tr></tr>\n\t\t\t\t\t\t<tr></tr>\n\t\t\t\t\t\t<tr></tr>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\'10%\'></td>\n\t\t\t\t\t\t<td class=\"label\" width=\'90%\' style=\'text-align:left\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
 
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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE");
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection connection=null;
	CallableStatement cstmt=null;
	PreparedStatement pstmt=null;
	ResultSet rst = null;
	String facility_id = (String)session.getValue("facility_id") ;
	String login_user      = (String) session.getAttribute("login_user");

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address = prop.getProperty( "client_ip_address" );

	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
	String patient_class = checkForNull(request.getParameter( "patient_class" )) ;
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String chart_code =checkForNull(request.getParameter( "chart_code" )) ;
	String chart_num =checkForNull(request.getParameter( "chart_num" )) ;
	String chart_line_num =checkForNull(request.getParameter( "chart_line_num" )) ;
	String component_code =checkForNull(request.getParameter( "component_code" )) ;
	String index_code =checkForNull(request.getParameter( "index_code" )) ;
	String p_index_value="";
	String component_value="";
	String status="";
	String err_msg="";
	String lang_err_msg_id="";
	String index_desc = "" ;
	String[]  index_code_value_arr = null;
	String[]  component_value_arr = null;
	String[]  index_code_arr = null;
	String[] component_arr = null;
	String index_cut_off_value = "" ;
	String cut_off = "" ;
	String component_desc = "" ;
	String ns_tooth_no = "" ;
	String value = "" ;
	String index_display_text = "" ;
	StringBuffer component_display_text = new StringBuffer() ;
	String temp_str = "";
	String sql_string="";
	String tooth_no="";
	String teethwith_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TeethWith.Label","oh_labels");

	
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try{
		connection=ConnectionManager.getConnection(request);

       /*OH_CALCULATE_SUMMARY(P_FACILITY_ID, P_PATIENT_ID, P_ENCOUNTER_ID, P_PATIENT_CLASS, P_CHART_NUM, P_CHART_CODE, P_CHART_LINE_NUM, P_CLOSING_CHART_YN, P_USER_ID, P_WS_NO, P_INDEX_VALUE, P_COMPONENT_VALUE, P_STATUS, P_ERR_MSG, P_LANG_ERR_MSG_ID)*/

		cstmt=connection.prepareCall("{call OH_CALCULATE_SUMMARY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id);  //P_FACILITY_ID
		cstmt.setString(2,patient_id); //P_PATIENT_ID
		cstmt.setString(3,encounter_id); //P_ENCOUNTER_ID
		cstmt.setString(4,patient_class);  //P_PATIENT_CLASS
		cstmt.setString(5,chart_num);  //P_CHART_NUM
		cstmt.setString(6,chart_code);  //P_CHART_CODE
		cstmt.setString(7,chart_line_num); //P_CHART_LINE_NUM
		cstmt.setString(8,"N");                   //P_CLOSING_CHART_YN
		cstmt.setString(9,login_user);       //P_USER_ID
		cstmt.setString(10,client_ip_address); //P_WS_NO

		//cstmt.registerOutParameter(11,Types.VARCHAR);	//P_INDEX_VALUE
		cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);	//P_INDEX_VALUE
		cstmt.registerOutParameter(12,Types.VARCHAR);	//P_COMPONENT_VALUE
		cstmt.registerOutParameter(13,Types.VARCHAR);	//P_STATUS
		cstmt.registerOutParameter(14,Types.VARCHAR);	//P_ERR_MSG
		cstmt.registerOutParameter(15,Types.VARCHAR);	//P_LANG_ERR_MSG_ID
		cstmt.execute();
		p_index_value 		= checkForNull(cstmt.getString(11),"");
		component_value 	= checkForNull(cstmt.getString(12),"");
		status		        = checkForNull(cstmt.getString(13),"");
		err_msg		        = checkForNull(cstmt.getString(14),"");
		lang_err_msg_id		= checkForNull(cstmt.getString(15),"");
		HashMap map = new HashMap();
		ArrayList index_code_list = new ArrayList();	
		//p_index_value="BLDIND~12!PLQIND~7!DEBIND~1";
		/*
			P_INDEX_VALUE will have the index values like below
			<INDEX_CODE>$<INDEX_VALUE>!
			Ex:  BLDIND$12!PLQIND$7!DEBIND$1
		*/
		///// For Indexes
		if(p_index_value!=null && !p_index_value.equals("")){
				//Split the Index_values for Index_codes
				index_code_value_arr = p_index_value.split("!");
				for(int i=0;i<index_code_value_arr.length;i++){
					temp_str = index_code_value_arr[i];
					index_code_arr = temp_str.split("~");
					map.put(index_code_arr[0] ,index_code_arr[1]);
					index_code_list.add(index_code_arr[0]);
				}
				StringBuffer index_append_qry= new StringBuffer();
				index_append_qry.append("SELECT INDEX_CODE, INDEX_DESC, INDEX_CUT_OFF_VALUE FROM OH_INDEXES WHERE INDEX_CODE IN (");
				for(int j=0;j<index_code_list.size();j++){
					if(j==0)
						index_append_qry.append("?");
					else
						index_append_qry.append(",?");
				}
				index_append_qry.append(")");
				pstmt=connection.prepareStatement(index_append_qry.toString());
				for(int j=0;j<index_code_list.size();j++){
					pstmt.setString(j+1,(String)index_code_list.get(j));
				}
				rst=pstmt.executeQuery();
				while(rst!= null && rst.next()){
					index_code = rst.getString("INDEX_CODE");
					value = (String)map.get(index_code);
					index_desc = rst.getString("INDEX_DESC");
					index_cut_off_value = rst.getString("INDEX_CUT_OFF_VALUE");
					//index_display_text = index_desc+" "+value; //commented on 210108 by parul ("%" was not coming for BLDIND and PLQIND )
					//added 210108 by parul for  SCR#6149 
				    if(index_cut_off_value!=null && !index_cut_off_value.equals("null") && !index_cut_off_value.equals("")){
				      if(index_code.equals("BLDIND") || index_code.equals("PLQIND") ||  index_code.equals("CALIND")|| index_code.equals("OHIIND") || index_code.equals("DEBIND")){
					//	if(index_code.equals("BLDIND") || index_code.equals("PLQIND")){
					         index_display_text = index_desc+" ("+index_cut_off_value+"%)";
						}else{
							index_display_text = index_desc+"("+index_cut_off_value+")";
					    }
				   }else{

				           index_display_text = index_desc;
			       }
				   //end 
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(index_display_text));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(index_display_text));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(value));
            _bw.write(_wl_block11Bytes, _wl_block11);

			     }
			  
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
// End of Code for Indexes

		sql_string="SELECT TOOTH_NO,NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM=? ORDER BY TOOTH_NO";
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

		pstmt=connection.prepareStatement(sql_string);
		pstmt.setString(1,tooth_numbering_system);
		rst=pstmt.executeQuery();
		HashMap tooth_map=new HashMap();
		while(rst.next()){
			tooth_no	= rst.getString("TOOTH_NO");
			ns_tooth_no	= rst.getString("NS_TOOTH_NO");
			tooth_map.put(tooth_no,ns_tooth_no);
		}
///// For Components
		//Split the Index_values for Index_codes
		/*<COMPONENT_CODE$TOOTH_NUM#TOOTH_NUM!
		   Ex: MOBL$11#12!MITH$3#17!*/
        ArrayList component_code_list = new ArrayList();
		//component_value=" MOBL~11#12!MITH~3#17!";
	//	map.clear();
		if(component_value!=null && !component_value.equals("")){
			component_value_arr = component_value.split("!");
			for(int i=0;i<component_value_arr.length;i++){
				temp_str = component_value_arr[i];
				component_arr = temp_str.split("~");
				map.put(component_arr[0] ,component_arr[1]);
				component_code_list.add(component_arr[0]);
			}
			StringBuffer component_append_qry= new StringBuffer();
			component_append_qry.append("SELECT COMPONENT_CODE, COMPONENT_SHORT_DESC_USER_DEF, CUT_OFF FROM OH_PERDONTAL_CHRT_COMP_LANG_VW WHERE LANGUAGE_ID = ? AND COMPONENT_CODE IN (");
			for(int j=0;j<component_code_list.size();j++){
				if(j==0)
					component_append_qry.append("?");
				else
					component_append_qry.append(",?");
			}
			component_append_qry.append(") ORDER BY COMPONENT_CODE");
			pstmt=connection.prepareStatement(component_append_qry.toString());
			pstmt.setString(1,locale);
			for(int j=0;j<component_code_list.size();j++){
				pstmt.setString(j+2,(String)component_code_list.get(j));
			}
			rst=pstmt.executeQuery();
			String[] tooth_value_arr = null;
		//	String cutt_off = "";

			while(rst!= null && rst.next()){
				component_display_text.setLength(0);
				component_code = rst.getString("COMPONENT_CODE");
				component_desc = rst.getString("COMPONENT_SHORT_DESC_USER_DEF");
				//value = (String)map.get(component_desc);
				cut_off = rst.getString("CUT_OFF");
				value = (String)map.get(component_code);
				//index_cut_off_value = rst.getString("INDEX_CUT_OFF_VALUE");

				if(!component_code.equals("MITH") && !component_code.equals("FOI") && !component_code.equals("LOC") && !component_code.equals("BOP") && !component_code.equals("PLA") && !component_code.equals("SUP")){
					if(cut_off!=null && !cut_off.equals("null") && !cut_off.equals("")){
						component_display_text.append(teethwith_legend);
						component_display_text.append(" ");
						component_display_text.append(component_desc);
						component_display_text.append(" >= (");
						component_display_text.append(cut_off);
						component_display_text.append(")mm :   ");
					}else{
						component_display_text.append(teethwith_legend);
						component_display_text.append(" ");
						component_display_text.append(component_desc);
						component_display_text.append(" :   ");
					}
				}else{ //Legend for Missing tooth   //else part added by parul on 221008 for scr#6149 
				     if(cut_off!=null && !cut_off.equals("null") && !cut_off.equals("")){
						component_display_text.append(" ");
						component_display_text.append(component_desc);
						component_display_text.append(" : ");
					}else{
						component_display_text.append(component_desc);
						component_display_text.append(" : ");
					}
				}
				tooth_value_arr = value.split("#");
				int z=0;
				for(int k=0;k<tooth_value_arr.length;k++){
					if(z==0){
						component_display_text.append((String)tooth_map.get(tooth_value_arr[k]));
					}else{
						component_display_text.append(",");
						component_display_text.append((String)tooth_map.get(tooth_value_arr[k]));
					}
					z++;

				}
		   
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(component_display_text.toString()));
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
		}
// End of Code for Components
 
            _bw.write(_wl_block15Bytes, _wl_block15);

	}catch ( Exception e ) {
	        e.printStackTrace() ;
	}finally {
		try{
            if(cstmt!=null) cstmt.close();
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null)
				ConnectionManager.returnConnection(connection,request);
        }catch(Exception es){es.printStackTrace();}
    }

            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.PeriodontalSummary.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
