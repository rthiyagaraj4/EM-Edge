package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __sectionchartdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SectionChartDtl.jsp", 1732506761866L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\t\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\n\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<!-- Added by Arvind @ 08-12-08 -->\n\t\t\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script language=\"JavaScript\" src =\"../../eCA/js/SectionChart.js\"></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\'>\n\t<form name=\'sectionChartDtlForm\' id=\'sectionChartDtlForm\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t<tr>\n\t <td class=\'white\' width=\'100%\' ></td> <!-- <updated by Arvind width 84 to 100 and added nowrap@ 29-12-08> -->\n\t<td class=\'label\' width=\'0%\' align=\'right\' nowrap>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td>\n\t</tr>\n</table>\t\n\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'1\' id=\'dataTitleTable\' width=\'100%\' align=\'center\' >\n\t\t<tr align=\'left\'>\n\t\t\t<th class=\'columnheadercenter\' width=\'73%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t<th class=\'columnheadercenter\' width=\'20%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t</tr>\n</table>\t\n</div>\t                      \n<table class=\'grid\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' id=\'dataTitleTable1\' width=\'100%\' align=\'center\' >\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<tr  id=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' width=\'73%\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' width=\'20%\' >\n\t\t\t\t\t<input type=\'checkbox\' name=\'select_yn";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'select_yn";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'   value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" onClick=\"stringConCatenate(";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =",";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =")\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"sectionCode";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"sectionCode";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t<input type=\'hidden\' name=\'sequence_num";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'sequence_num";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</table>\t\t\n\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block9Bytes, _wl_block9);

		eCA.SectionChartBean bean = (eCA.SectionChartBean)getObjectFromBean("bean","eCA.SectionChartBean",session);
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		ArrayList retArray = null;
		String trRowId = "";
		int start = 0;
		int end = 0;
		int index = 0;
		StringTokenizer tokenPipe = null;
		StringTokenizer tokenTilde = null;
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		int rowCount = 0;
		int maxRecord = 0;
		String error_msg = "";
		Connection con = null;
		String searchText = request.getParameter("chartDesc");	
		String mode = request.getParameter("mode")==null ? "" : request.getParameter("mode");
		String selectYN = "";
		String classValue = "";
		String sectionCode = "";
		String finalString = "";
		String flagYN="";
		String tempString="";
		if(to == null)
			end = 6;
		else
			end = Integer.parseInt(to);

		if(from == null)
			start = 1;
		else
			start = Integer.parseInt(from);
		String chartId = request.getParameter("chartId");
		if(searchText==null || searchText.equals("")||searchText.equals("%"))
				searchText = "%";
		else
			searchText = searchText.toUpperCase() +"%";
		if(chartId==null || chartId.equals(""))
				chartId = "";
		ArrayList arrayDesc =null;
		
		ArrayList flag = null;
		ArrayList arrayCodeCmp =null;
		ArrayList arrayFlag = null;	
		retArray = null;
		ArrayList discreteMeasureId = null;
		ArrayList orderSeqNo = null;
		try
		{	bean.clearArray(retArray);
			con = ConnectionManager.getConnection(request);
			maxRecord = bean.getMaxRecord(chartId,searchText,con);
			//out.println("maxRecord"+maxRecord);
			//out.println("searchText"+searchText);

            _bw.write(_wl_block2Bytes, _wl_block2);
	
		finalString = bean.getConcatenatedString();
		if(finalString==null || finalString.equals(""))
			{
				finalString = "";
			}
		retArray = bean.getQueryForChart(chartId,searchText,con,start,end);	
		if(retArray != null)
			{
				if( retArray.size()!=0)
				{
						
					arrayDesc = (ArrayList)retArray.get(0);

					
					discreteMeasureId  = (ArrayList)retArray.get(2);
					orderSeqNo = (ArrayList)retArray.get(1);
					flag = (ArrayList)retArray.get(3);
					if(arrayDesc.size()==0 || discreteMeasureId.size()==0||orderSeqNo.size()==0 || flag.size()==0)
					{
						error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";
						out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");
						out.println("<script>parent.sectionChartSearchFrame.document.sectionChartSearchForm.searchtext.value=''</script>");
					
						out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
						
					}
					if(!finalString.equals(""))
					{
						
						tokenTilde = new StringTokenizer(finalString,"~");
						arrayCodeCmp = new ArrayList();
						arrayFlag =  new ArrayList();
						while(tokenTilde.hasMoreTokens())
						{
							tokenPipe = new StringTokenizer(tokenTilde.nextToken(),"||");
							tempString = tokenPipe.nextToken();
							arrayCodeCmp.add(index,tokenPipe.nextToken());
							tempString = tokenPipe.nextToken();
							arrayFlag.add(index,tokenPipe.nextToken());
							index++;
						}
					}
				

            _bw.write(_wl_block11Bytes, _wl_block11);

		if ( !(start <= 1) )
			out.println("<A class='gridLink' HREF='../../eCA/jsp/SectionChartDtl.jsp?from="+(start-6)+"&chartDesc="+java.net.URLEncoder.encode(searchText)+"&chartId="+chartId+"&mode=modify"+"&to="+(end-6)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		if ( !( (start+6) > maxRecord ) )
			out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/SectionChartDtl.jsp?from="+(start+6)+"&chartId="+chartId+"&chartDesc="+java.net.URLEncoder.encode(searchText)+"&mode=modify"+"&to="+(end+6)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
	
					for(rowCount=0;rowCount < arrayDesc.size();rowCount++)
					{
						//out.println("<script>alert('arrayDesc "+arrayDesc.size()+"')</script>");

							trRowId = "trRowId"+rowCount;
							if(finalString.equals(""))
							{
						
								if( !(mode.equals("modify")))
								{
									if(((String)flag.get(rowCount)).equals("Y"))
										selectYN = "checked";
									else
										selectYN = "";
								}
								else
								{
									int descLength = bean.getLength();
									if(descLength > 0)
									{
										if(((String)flag.get(rowCount)).equals("Y"))
										selectYN = "checked";
									else
										selectYN = "";
									}
									else
									{
										selectYN = "";
									}
											
								}
							}
							else
							{
								selectYN = "";
								for(index = 0;index < arrayCodeCmp.size();index++)
								{
									
									tempString = (String)arrayCodeCmp.get(index);
									sectionCode = (String)discreteMeasureId.get(rowCount);
									if(sectionCode.equalsIgnoreCase(tempString))
									{
											flagYN = (String)arrayFlag.get(index);
											if(flagYN.equals("Y"))
													selectYN = "checked";
												else
													selectYN = "";
									}
									
								}
							}
							if(rowCount % 2 ==0) 
								classValue = "gridData";
							else
								classValue = "gridData";

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trRowId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)arrayDesc.get(rowCount)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)flag.get(rowCount)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(selectYN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(trRowId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)discreteMeasureId.get(rowCount)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((String)orderSeqNo.get(rowCount)));
            _bw.write(_wl_block31Bytes, _wl_block31);
				}
			}	
				else
				{
					error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";

					out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");
					out.println("<script>parent.sectionChartSearchFrame.document.sectionChartSearchForm.searchtext.value=''</script>");

					out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
					
				}
			}
			out.println("<input type='hidden' name='sequence' id='sequence' value='"+rowCount+"'> ");
			
			//bean.returnConnection();
	}
		catch(Exception e)
		{
			//out.println("Exception in Section Chart Dtl Block :"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SectionDescription.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
