package jsp_servlet._emp._jsp;

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
import java.sql.ResultSetMetaData;
import webbeans.eCommon.ConnectionManager;

public final class __multiplemrn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/MultipleMRN.jsp", 1709118645447L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Latest Modified Date Time : 9/23/2005 11:25 AM -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\t\t<html>\n\t\t<head>\n\t\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\t<script>\n\t\t\t\tfunction returnValues(mrn)\n\t\t\t\t{\n\t\t\t\t\twindow.returnValue = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'+\':\'+mrn;\t\n\t\t\t\t\twindow.close();\t\t\t\t\n\t\t\t\t}\n\t\t\t\tfunction setValues()\n\t\t\t\t{\n\t\t\t\t\tif(window.returnValue);\n\t\t\t\t\telse window.returnValue = \'\'; \n\t\t\t\t}\n\t\t\t</script>\n\t\t</head>\n\t\t<!-- <body onLoad=\"GifBlink(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'document.forms[0]\'); startBlink();\" onUnload=\"setValues();\" onKeyDown = \'lockKey()\'> -->\n\t\t<body onLoad=\"startBlink();\" onUnload=\"setValues();\" onKeyDown = \'lockKey()\'>\n\t\t\t<form>\n\t\t\t\t<br>\n\t\t\t\t<CENTER>\n\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"97%\">\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t<td class=\'PATIENTLINECOLOROTHLANG\' width=\'90%\' id=\'patdetails\' style=\'position:relative;\'>&nbsp;</td>\n\t\t\t\t\t\t<TD style=\'background-color:red\' align=\'center\' id=\'nam\' nowrap></TD>\n\t\t\t\t\t\t<!-- <td class=\'PATIENTLINECOLOROTHLANG\' width=\'30%\' align=\'right\'><img name=\'nam\' src=\'../../eCommon/images/Status.gif\'><img name=\'nam1\' src=\'../../eCommon/images/Status.gif\'></td> -->\n\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t</CENTER>\n\t\t\t\t<br>\n\t\t\t\t<CENTER>\n\t\t\t\t<table border=\'1\' cellpadding=0 cellspacing=0 width=\"97%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<th align=left>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<tr>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t\t\t\t<a onClick=\"returnValues(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\" class=\'showlink\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</table>\t\n\t\t</CENTER>\n\t</form>\n\t</body>\n\t<script>\n\tGifBlink(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\",\"document.forms[0]\"); \n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
	
	boolean link = false; 
	String queryString = (String)session.getValue("queryString");
	queryString = (queryString == null) ? "" : queryString;	
	if((queryString.indexOf("MP") != -1) &&(queryString.indexOf("ONLINE_REPORT") != -1))link = true;
	request.setCharacterEncoding("UTF-8");
	String patient = request.getParameter("Patient_Id");
	
	Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;
	
	String Pat_Details	= "";
	String headerDisp	= "";
	
	con = ConnectionManager.getConnection(request); 

	try
	{
		pstmt	= con.prepareStatement("select get_patient_line('"+patient+"','"+localeName+"') from dual");
		rs		= pstmt.executeQuery();
		rs.next();
			Pat_Details = rs.getString(1);

		if(Pat_Details == null || Pat_Details.equals("null")) Pat_Details = "";

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e) { out.println(e.toString());}

	String single_or_multi_files_ind	= "";
	String separate_file_no_yn			= "";
	//Array Size was changed by Maheshwaran K for the Inc No :33654 as 27/06/2012
	String tabHeaders[] = new String [6];
	String fieldFetch[] = new String [6];

	int p		= 0;
	int posMRN	= 0;

	try
	{
		pstmt = con.prepareStatement("select SINGLE_OR_MULTI_FILES_IND, SEPARATE_FILE_NO_YN  from mp_param ");
		rs = pstmt.executeQuery();

		while (rs.next())
		{
			single_or_multi_files_ind	= rs.getString(1);
		    separate_file_no_yn			= rs.getString(2);
		}
	
	   if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close();
	   //Added by Maheshwaran K for the Inc No :33654 as 27/06/2012
		//Start
		tabHeaders[p] = new String(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));
		fieldFetch[p] = new String("Facility_Id");
		p++;
		//End
		pstmt = con.prepareStatement(" SELECT field_name, field_desc FROM mp_pat_search_result WHERE field_select = 'Y' ORDER BY field_order ");
		rs = pstmt.executeQuery();
		while (rs.next())
		{
		//Commented by Maheshwaran K for the Inc No :33654 as on 27/06/2012
		//Start
			/*if(rs.getString("field_name").equalsIgnoreCase("Facility_Id"))
			{
				tabHeaders[p] = rs.getString("field_desc");
				fieldFetch[p] = "Facility_Name";
				p++;
			}*/
		//End
			if(single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N"))
			{
				if (rs.getString("field_name").equalsIgnoreCase("Patient_Id"))
				{
					tabHeaders[p] = "M.R. No";
					fieldFetch[p] = rs.getString("field_name");
					p++;
					posMRN = p;
				}
			}
			else
			{
				if (rs.getString("field_name").equalsIgnoreCase("File_No"))
				{
					tabHeaders[p] = rs.getString("field_desc");
					fieldFetch[p] = rs.getString("field_name");
					p++;
					posMRN = p;
				}
			}
			if (rs.getString("field_name").equalsIgnoreCase("Old_File_No"))
			{
				tabHeaders[p] = rs.getString("field_desc");
				fieldFetch[p] = rs.getString("field_name");
				p++;
			}	
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e) { out.println(e.toString());}
	//Added by Maheshwaran K for the Inc No :33654 as 27/06/2012
	//Start
	tabHeaders[p] = new String(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.filetype.label","common_labels"));
	fieldFetch[p] = new String("file_type_desc");
	p++;
	//End
	tabHeaders[p] = new String(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MRSection.label","common_labels"));
	fieldFetch[p] = new String("Section_Name");
	p++;
	tabHeaders[p] = new String(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CreatedOn.label","common_labels"));
	fieldFetch[p] = new String("to_char(file_created_date,'dd/mm/yyyy')");
	

	String fields  = "";
	boolean exist_flag = true;

	for(int j=0;j<fieldFetch.length;j++)
	{
		if(fieldFetch[j] != null)
		{
			fields = fields + fieldFetch[j]+" , ";
		}
	}
	fields = fields.substring(0,fields.length()-2);
	
	try
	{
		pstmt = con.prepareStatement("SELECT "+fields+" FROM mr_pat_file_index_vw WHERE patient_id = '"+patient+"'");
		rs = pstmt.executeQuery();
		ResultSetMetaData rsmd	= rs.getMetaData();

		int colCount	= rsmd.getColumnCount();
		String sStyle	= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
		
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Pat_Details));
            _bw.write(_wl_block10Bytes, _wl_block10);

					for(int k = 0;k<tabHeaders.length;k++)
					{
						headerDisp = tabHeaders[k];
						if(headerDisp == null) 
						{
							headerDisp="";
							exist_flag = false;
						}
						if(!(headerDisp.equals("")))			
						{
							
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(headerDisp));
            _bw.write(_wl_block12Bytes, _wl_block12);

						}
					}
					
					int i = 1;
					String classValue	= "";
					String prtVal		= ""; 
		
					while(rs.next())
					{
						if (i%2 == 0) classValue="QRYEVEN" ;
						else classValue="QRYODD" ;

						
            _bw.write(_wl_block13Bytes, _wl_block13);

						for(int j = 1;j<=colCount;j++)
						{
							prtVal	= ""; 
							prtVal	= (rs.getString(j) == null) ? "&nbsp;" : rs.getString(j);

							if(link &&(j == posMRN))
							{
								
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(prtVal));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(prtVal));
            _bw.write(_wl_block17Bytes, _wl_block17);

							}
							else
							{
								if(!((exist_flag == false)  && (j == colCount)))
								{
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(prtVal));
            _bw.write(_wl_block20Bytes, _wl_block20);

								}
								else if((exist_flag == false)  && (j == colCount))
								{
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(prtVal));
            _bw.write(_wl_block20Bytes, _wl_block20);

								}
							}
						}
						i++;
						
            _bw.write(_wl_block21Bytes, _wl_block21);

				}
				
				if (rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			catch(Exception e) { out.println(e.toString());}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Pat_Details));
            _bw.write(_wl_block23Bytes, _wl_block23);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientFileNo.label", java.lang.String .class,"key"));
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
