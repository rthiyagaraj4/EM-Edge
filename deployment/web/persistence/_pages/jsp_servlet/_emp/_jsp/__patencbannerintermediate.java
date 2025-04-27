package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patencbannerintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatEncBannerIntermediate.jsp", 1720074065382L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\t\n\t\t<script>\n\t\t\tparent.patEncBannerDetailsFrame.location.href = \'../../eMP/jsp/PatEncBannerDetails.jsp?loadFirstTime=No&oldDispLine=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&bannerCateg=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&bannerRef=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\tparent.patEncBannerDetailsFrame.location.href = \'../../eMP/jsp/PatEncBannerDetails.jsp?loadFirstTime=No&bannerRef=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String newLineNum = request.getParameter("newLineNum") == null ? "" : request.getParameter("newLineNum");
	String dispLine = request.getParameter("dispLine") == null ? "" : request.getParameter("dispLine");
	String dispOrder = request.getParameter("dispOrder") == null ? "" : request.getParameter("dispOrder");
	String maxOrderForLine1 = request.getParameter("maxOrderForLine1") == null ? "" : request.getParameter("maxOrderForLine1");
	String maxOrderForLine2 = request.getParameter("maxOrderForLine2") == null ? "" : request.getParameter("maxOrderForLine2");
	String concatMapValues = request.getParameter("concatMapValues") == null ? "" : request.getParameter("concatMapValues");
	String sentFromLineChange = request.getParameter("sentFromLineChange") == null ? "N" : request.getParameter("sentFromLineChange");
	String firstDispOrderVal = request.getParameter("firstDispOrderVal") == null ? "1" : request.getParameter("firstDispOrderVal");
	String bannerCateg = request.getParameter("bannerCateg") == null ? "P" : request.getParameter("bannerCateg");
	String bannerRef = request.getParameter("bannerRef") == null ? "U01" : request.getParameter("bannerRef");


	eMP.PatientBannerGroupLine patBannerGrpBean = null;

	patBannerGrpBean = (eMP.PatientBannerGroupLine)getObjectFromBean("patBannerGrpBean","eMP.PatientBannerGroupLine",session);

	if(sentFromLineChange.equals("Y"))
	{
		try
		{
			ArrayList list1 = patBannerGrpBean.returnList1();
			ArrayList list2 = patBannerGrpBean.returnList2();

			if(list1 == null) list1 = new ArrayList();
			if(list2 == null) list2 = new ArrayList();

			String arrayValues[] = concatMapValues.split("`");	
			StringTokenizer strTok = null;
			String listValues = "";
			String changedDispOrdVals = "";
			String LineNumDup = "";
			String defSelDup = "";
			String dispOrdDup = "";
			
			if(dispLine.equals("1"))
			{
				concatMapValues = newLineNum+"`"+arrayValues[1]+"`"+(Integer.parseInt(maxOrderForLine2)+1)+"`"+arrayValues[3]+"`"+arrayValues[4]+"`"+arrayValues[5]+"`"+arrayValues[6]+"`"+arrayValues[7]+"`"+arrayValues[8]+"`"+arrayValues[9]+"`"+arrayValues[10]+"`"+arrayValues[11]+"`"+arrayValues[12];
				list2.add(concatMapValues);

				list1.remove((Integer.parseInt(dispOrder) - 1));
				putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
				
				list1 = patBannerGrpBean.returnList1();
				int arrSize = list1.size();

				for(int i=0;i<arrSize;i++)
				{
					listValues = (String) list1.get(i);
					list1.remove(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						LineNumDup = strTok.nextToken();
						defSelDup = strTok.nextToken();
						dispOrdDup = strTok.nextToken();

						if(Integer.parseInt(dispOrdDup) >= Integer.parseInt(dispOrder))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup)-1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup))+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
					}
					list1.add(i,changedDispOrdVals);
				}
			}
			else if(dispLine.equals("2"))
			{
				concatMapValues = newLineNum+"`"+arrayValues[1]+"`"+(Integer.parseInt(maxOrderForLine1)+1)+"`"+arrayValues[3]+"`"+arrayValues[4]+"`"+arrayValues[5]+"`"+arrayValues[6]+"`"+arrayValues[7]+"`"+arrayValues[8]+"`"+arrayValues[9]+"`"+arrayValues[10]+"`"+arrayValues[11]+"`"+arrayValues[12];
				list1.add(concatMapValues);
				list2.remove((Integer.parseInt(dispOrder) - 1));
				putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
				
				list2 = patBannerGrpBean.returnList2();

				if(list1 == null) list1 = new ArrayList();
				if(list2 == null) list2 = new ArrayList();

				int arrSize = list2.size();

				for(int i=0;i<arrSize;i++)
				{
					listValues = (String) list2.get(i);
					list2.remove(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						LineNumDup = strTok.nextToken();
						defSelDup = strTok.nextToken();
						dispOrdDup = strTok.nextToken();

						if(Integer.parseInt(dispOrdDup) >= Integer.parseInt(dispOrder))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup)-1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup))+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
					}
					list2.add(i,changedDispOrdVals);
				}
			}
			putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
	}//end of try
	catch(Exception e)
	{
		
		e.printStackTrace(System.err);
	}
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(dispLine));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(bannerCateg));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(bannerRef));
            _bw.write(_wl_block7Bytes, _wl_block7);

	}//end of if sentFromLineChange
	else if(sentFromLineChange.equals("N"))
	{
		ArrayList list = new ArrayList();
		if(dispLine.equals("1"))
			list = patBannerGrpBean.returnList1();
		else if(dispLine.equals("2"))
			list = patBannerGrpBean.returnList2();


		int arrSize = list.size();
		StringTokenizer strTok = null;
		String listValues = "";
		String changedDispOrdVals = "";
		String LineNumDup = "";
		String defSelDup = "";
		String dispOrdDup = "";
		try
		{
			if(Integer.parseInt(firstDispOrderVal) < Integer.parseInt(dispOrder))
			{
				for(int i=0;i<arrSize;i++)
				{
					listValues = (String) list.get(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						LineNumDup = strTok.nextToken();
						defSelDup = strTok.nextToken();
						dispOrdDup = strTok.nextToken();

						if(Integer.parseInt(dispOrdDup) < Integer.parseInt(firstDispOrderVal))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+dispOrdDup+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else if(Integer.parseInt(dispOrdDup) == Integer.parseInt(firstDispOrderVal))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrder)-1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else if(Integer.parseInt(dispOrdDup) > Integer.parseInt(firstDispOrderVal))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup)-1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}

					}//end of while

					if(i < (Integer.parseInt(dispOrder)-2))
					{
						list.remove(i);
						if(Integer.parseInt(dispOrdDup) != Integer.parseInt(firstDispOrderVal))
						{
							list.add(i,changedDispOrdVals);
						}
						else
						{
							list.add((Integer.parseInt(dispOrder)-2),changedDispOrdVals);
							i--;
						}
					}
				}//end of for
			}//end of if
			else
			{
				for(int i=0;i<arrSize;i++)
				{
					listValues = (String) list.get(i);
					strTok = new StringTokenizer(listValues,"`");
					while(strTok.hasMoreTokens())
					{
						LineNumDup = strTok.nextToken();
						defSelDup = strTok.nextToken();
						dispOrdDup = strTok.nextToken();

						if(Integer.parseInt(dispOrdDup) < Integer.parseInt(dispOrder) || (Integer.parseInt(dispOrdDup) > Integer.parseInt(firstDispOrderVal)))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+dispOrdDup+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else if((Integer.parseInt(dispOrdDup) >= Integer.parseInt(dispOrder)) && (Integer.parseInt(dispOrdDup) < Integer.parseInt(firstDispOrderVal)))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrdDup) +1)+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
						else if(Integer.parseInt(dispOrdDup) == Integer.parseInt(firstDispOrderVal))
						{
							changedDispOrdVals = LineNumDup+"`"+defSelDup+"`"+(Integer.parseInt(dispOrder))+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken()+"`"+strTok.nextToken();
						}
					}//end of while
					list.remove(i);
					if(Integer.parseInt(dispOrdDup) != Integer.parseInt(firstDispOrderVal))
					{
						list.add(i,changedDispOrdVals);
					}
					else
					{
						list.add((Integer.parseInt(dispOrder)-1),changedDispOrdVals);
					}
				}//end of for
			}//end of else
		}//end of try
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			
		}//end of catch

		putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bannerRef));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(bannerCateg));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}//end of else sentFromLineChange
	else if(sentFromLineChange.equals("fromTextObj"))
	{
		String objValue = request.getParameter("objValue") == null ? "" : request.getParameter("objValue");
		if(objValue.equals("")){
			objValue = " ";
		}else{
			objValue=java.net.URLDecoder.decode(objValue,"UTF-8");
		}
		String objType = request.getParameter("objType") == null ? "" : request.getParameter("objType");
		String concatVals = "";

		try
		{
			ArrayList list = new ArrayList();
			if(dispLine.equals("1"))
				list = patBannerGrpBean.returnList1();
			else if(dispLine.equals("2"))
				list = patBannerGrpBean.returnList2();

			String listValues = (String) list.get((Integer.parseInt(dispOrder)-1));

			list.remove((Integer.parseInt(dispOrder)-1));

			String arrayVals[] = listValues.split("`");

			if(objType.equals("dispLenTxt"))
			{
				concatVals = arrayVals[0]+"`"+arrayVals[1]+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+objValue+"`"+arrayVals[6]+"`"+arrayVals[7]+"`"+arrayVals[8]+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];
			}
			else if(objType.equals("numSpacesTxt"))
			{
				if(objValue.equals(" ")) objValue = "0";
				concatVals = arrayVals[0]+"`"+arrayVals[1]+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+arrayVals[5]+"`"+objValue+"`"+arrayVals[7]+"`"+arrayVals[8]+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];
			}
			else if(objType.equals("dispTextTxt"))
			{
				concatVals = arrayVals[0]+"`"+arrayVals[1]+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+arrayVals[5]+"`"+arrayVals[6]+"`"+objValue+"`"+arrayVals[8]+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];
			}
			else if(objType.equals("toolTipTxt"))
			{
				concatVals = arrayVals[0]+"`"+arrayVals[1]+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+arrayVals[5]+"`"+arrayVals[6]+"`"+arrayVals[7]+"`"+objValue+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];
			}
			list.add((Integer.parseInt(dispOrder)-1),concatVals);
			putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
		}//end of try
		catch(Exception ee)
		{
			
			ee.printStackTrace(System.err);
		}//end of catch
	}//end of if sentFromLineChange = fromTextObj
	else if(sentFromLineChange.equals("sel"))
	{
		String selValue = request.getParameter("selValue") == null ? "N" : request.getParameter("selValue");
		ArrayList list = new ArrayList();
		try
		{
			if(dispLine.equals("1"))
				list = patBannerGrpBean.returnList1();
			else if(dispLine.equals("2"))
				list = patBannerGrpBean.returnList2();

			String listValues = (String) list.get((Integer.parseInt(dispOrder)-1));
			list.remove((Integer.parseInt(dispOrder)-1));
			String arrayVals[] = listValues.split("`");

			String concatVals = arrayVals[0]+"`"+selValue+"`"+arrayVals[2]+"`"+arrayVals[3]+"`"+arrayVals[4]+"`"+arrayVals[5]+"`"+arrayVals[6]+"`"+arrayVals[7]+"`"+arrayVals[8]+"`"+arrayVals[9]+"`"+arrayVals[10]+"`"+arrayVals[11]+"`"+arrayVals[12];

			list.add((Integer.parseInt(dispOrder)-1),concatVals);
			putObjectInBean("patBannerGrpBean",patBannerGrpBean,session);
		}//end of try
		catch(Exception e)
		{
			
			e.printStackTrace(System.err);
		}
	}//end of if sentFromLineChange = sel

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
