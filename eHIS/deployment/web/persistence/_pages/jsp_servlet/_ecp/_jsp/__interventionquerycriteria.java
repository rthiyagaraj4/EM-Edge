package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eOR.*;
import eOR.Common.*;

public final class __interventionquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/InterventionQueryCriteria.jsp", 1709116524388L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teCP\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tHema Malini B\n*\tCreated On\t\t:\t5th Jan 2005\n-->\n\n<!--InterventionQueryCriteria.jsp-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'stylesheet\' type=\'text/css\'href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
//This file is saved on 18/10/2005.
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
String locale=(String)session.getAttribute("LOCALE");

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
 
ecis.utils.CommonQueryPage querypage= new ecis.utils.CommonQueryPage();
StringBuffer strbuf;

Connection con=null;
Statement Intervention_stmt=null;
ResultSet Intervention_rs=null;

try
{
  con=ConnectionManager.getConnection(request);
	
  //Values for Intervention Type List from sql
  ArrayList Locn_Data		= new ArrayList() ;
  String[] record  = null;
  String Intervention_sql="";

  Intervention_stmt=con.createStatement();

  //Intervention_sql="select intervention_type, short_desc from ca_intervention_type where eff_status = 'E' order by short_desc";
  Intervention_sql="SELECT intervention_type, short_desc FROM ca_intervention_type_lang_vw WHERE eff_status = 'E' AND language_id = '"+locale+"' ORDER BY short_desc";

  Intervention_rs= Intervention_stmt.executeQuery(Intervention_sql);
  	 	try{
		   if(Intervention_rs!=null)
		     {
			 while(Intervention_rs.next())
			  {
				 record=new String[2];
					record[0]= Intervention_rs.getString("intervention_type");
					record[1]=  Intervention_rs.getString("short_desc");
					Locn_Data.add(record);
			  }
			 }
	 }catch(Exception exp){exp.toString();}

 //Values for Result Type List from sql
  Statement Intervention_result_stmt=null;
  ResultSet Intervention_result_rs=null;
  ArrayList Locn_Data1	= new ArrayList() ;

  String Intervention_result_sql="";
  String[] record1=null;
  Intervention_result_stmt=con.createStatement();

 // Intervention_result_sql="select result_type, result_type_desc from ca_result_type order by result_type_desc";
  Intervention_result_sql="SELECT result_type, result_type_desc FROM ca_result_type_lang_vw where language_id = '"+locale+"' and result_type not in('NT') ORDER BY result_type_desc";

  Intervention_result_rs= Intervention_result_stmt.executeQuery(Intervention_result_sql);
   		try{
		   if(Intervention_result_rs!=null)
		     {
			 while(Intervention_result_rs.next())
			  {
				    record1=new String[2];
					record1[0]= Intervention_result_rs.getString("result_type");
					record1[1]=  Intervention_result_rs.getString("result_type_desc");
					Locn_Data1.add(record1);
			  }
			 }
		}catch(Exception exp){exp.toString();}
		finally
		{
			if( Intervention_result_stmt!= null)
				Intervention_result_stmt.close();

			if( Intervention_result_rs != null)
				Intervention_result_rs.close();
		}	
	ArrayList finalArray=new ArrayList();
	String interv_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionCode.label","cp_labels");
	String interv_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionDescription.label","cp_labels");
	String interv_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InterventionType.label","common_labels");
	String dependency=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Dependency.label","common_labels");
	String dependency_level=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Dependency.label","common_labels");
	String res_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResultType.label","common_labels");
	String interv=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Interventions.label","cp_labels");
	
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
    String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	String all=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	String def_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DefinitionType.label","common_labels");
	String sys_defined=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDefined.label","common_labels");
	String user_defined=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels");
	String def_type_list="%,"+Both_legend+",Y,"+sys_defined+",N,"+user_defined;
	ArrayList firstItem=new ArrayList();
	firstItem.add("Text"); //Type of item
	firstItem.add(interv_code); // label
	firstItem.add("intervention_code"); //name
	firstItem.add("10");  //size
    firstItem.add("10");   //Length
	finalArray.add(firstItem);

    ArrayList secondItem=new ArrayList();
	secondItem.add("Text"); //Type of item
	secondItem.add(interv_desc); // label
	secondItem.add("intervention_description"); //name
	secondItem.add("50");  //size
    secondItem.add("60");   //Length
	finalArray.add(secondItem);

	ArrayList ThirdItem=new ArrayList();
	ThirdItem.add("List"); //Type of item
	ThirdItem.add(interv_type); // label
	ThirdItem.add("intervention_type"); //name
	String strList="%"+","+"-------------------"+all+"----------------------"+",";
	for( int k=0;k<Locn_Data.size();k++)
	{
		record=(String[])Locn_Data.get(k);
		strList=strList+ (String)record[0]+","+(String)record[1]+",";
	}
	ThirdItem.add(strList);  //Values to be passed
   	finalArray.add(ThirdItem);

    ArrayList FourthItem=new ArrayList();
	FourthItem.add("List"); //Type of item
	FourthItem.add(dependency); // label
	FourthItem.add("dependency"); //name
	FourthItem.add("%,--"+all+"--,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9");  //Values to be passed
   	finalArray.add(FourthItem);

	ArrayList FifthItem=new ArrayList();
	FifthItem.add("List"); //Type of item
	FifthItem.add(res_type); // label
	FifthItem.add("result_type"); //name
	String strResult="%"+","+"-----"+all+"-----"+",";
	  
	for(int k=0;k<Locn_Data1.size();k++)
	{
		record1=(String[])Locn_Data1.get(k);
		strResult=strResult+(String)record1[0]+","+(String)record1[1]+",";
	}
	FifthItem.add(strResult);  //Values to be passed
   	finalArray.add(FifthItem);

	ArrayList SixthItem=new ArrayList();
	SixthItem.add("List"); //Type of item
	SixthItem.add(def_type); // label
	SixthItem.add("system_defined_yn"); //name
	SixthItem.add(def_type_list);  //values to be passed
  	finalArray.add(SixthItem);

	ArrayList SeventhItem=new ArrayList();
	SeventhItem.add("List"); //Type of item
	SeventhItem.add(Nature); // label
	SeventhItem.add("eff_status"); //name
	SeventhItem.add(Nature_List);  //values to be passed
  	finalArray.add(SeventhItem);

	String orderByCols[] = new String[5];
	String orderByColVals[] = new String[5];

	orderByCols[0]	= interv_code;
	orderByCols[1]	= interv_desc;
	orderByCols[2]	= interv_type;
	orderByCols[3]	= dependency_level;
	orderByCols[4]	= res_type;
	
	orderByColVals[0] = "a.intervention_code";
	orderByColVals[1] = "a.short_desc";
	orderByColVals[2] = "a.intervention_type";
	orderByColVals[3] = "a.appl_dependency_level";
	orderByColVals[4] = "a.result_type";
String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

strbuf = querypage.getQueryPage(con,finalArray,interv,"../jsp/InterventionQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols,orderByColVals,ExecuteQuery);

   out.println(strbuf.toString());
}
catch(Exception e)
{
	out.println(e.toString());
}
finally
{
	if( Intervention_rs != null)
		Intervention_rs.close();
	if( Intervention_stmt!= null)
		Intervention_stmt.close();
    if(con != null)
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
