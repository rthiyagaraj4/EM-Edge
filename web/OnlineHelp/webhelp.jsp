<!DOCTYPE html>
<%@ page import="java.net.URL,java.util.*"%>
<html>
<head>
<%
HashMap QryStrMap = new HashMap();
String strUrl = checkForNull(request.getParameter("url"), "");
String option_id = checkForNull(request.getParameter("option_id"), "");
String appl_task_id = checkForNull(request.getParameter("appl_task_id"), "");
String function_id = checkForNull(request.getParameter("function_id"), "");
String voFunctionId = checkForNull(request.getParameter("vo.functionId"), "");
String functionid = checkForNull(request.getParameter("functionid"), "");
String locale = checkForNull(request.getParameter("locale"), "");

/*
System.out.println("strUrl : " + strUrl);
System.out.println("option_id : " + option_id);
System.out.println("appl_task_id : " + appl_task_id);
System.out.println("function_id : " + function_id);
System.out.println("functionid : " + functionid);
System.out.println("voFunctionId : " + voFunctionId);
System.out.println("locale : " + locale);
*/

/*
Function id from LC/DS/OH modules may come like vo.functionid or function_id or functionid
-Vinod 3/12/2009
 */
if (function_id.equals(""))
{
  function_id = voFunctionId;
}

if (function_id.equals(""))
{
  function_id = functionid;
}

/*	if (function_id.equals(""))
{
strUrl = strUrl.replace("?","@");
String arr[] = new String[10];
arr = strUrl.split("@");

System.out.println("arr[0] : -"+arr[0]+"-");
System.out.println("arr[1] : -"+arr[1]+"-");
}
 */
/*
If the parameters function_id,option_id,appl_task_id,locale are not part of the query string but passed as parametrs in request string, they will be added in to hashmap manually here.
If they are not passed as request parameters but are part of query string then the same will be derived in the next block (Block to derive the key value pair from query string)
Vinod - 3/4/2009
 */
if (!function_id.equals(""))
{
  QryStrMap.put("function_id", function_id);
}
if (!option_id.equals(""))
{
  QryStrMap.put("option_id", option_id);
}
if (!appl_task_id.equals(""))
{
  QryStrMap.put("appl_task_id", appl_task_id);
}
if (!locale.equals(""))
{
  QryStrMap.put("locale", locale);
}

/*
If there is any "//" in the URL, replace it with "/". In eOT few functions are passing "//".
 */
strUrl = strUrl.replace("//", "/");

/*
Module id is taken from strURL so no need to take from request
String module_id = checkForNull(request.getParameter("module_id"),"");
 */
URL url = new URL(strUrl);

/* properties file with  JSP to HTML mapping */
PropertyResourceBundle bundle = (PropertyResourceBundle)ResourceBundle
  .getBundle("map");
/* properties file with  function_id to HTML mapping */
/*
If cross module JSP reference is there, the function id must be prefixed with the Module id to which	the file belongs to.
E.g :
addModifyRoom.jsp belongs to AM module, but it is accessed from IP in the function ROOM/CUBICLE.
So the mapping should have 'AM' not 'IP' like
AM_ROOM_CUBICLE=IBA_online_help/Inpatient_Management/CodeSetup/Room_Cubicle.htm

If the mapping is done with IP, it will fail. The below mapping won't work.
IP_ROOM_CUBICLE=IBA_online_help/Inpatient_Management/CodeSetup/Room_Cubicle.htm
 */
PropertyResourceBundle bundleFunc = (PropertyResourceBundle)ResourceBundle
  .getBundle("mapfunc");
/* properties file with  option_id/appl_task_id to HTML mapping */
PropertyResourceBundle bundleOptTask = (PropertyResourceBundle)ResourceBundle
  .getBundle("mapca");
String id = "";
String paramUrl = "";
String module_id = "";
String temp = "";
String element = "";
String modFunc = "";
String qryString = "";
/* List of all modules except CA*/
String moduleList =
  "eAE,eAM,eAT,eBL,eBT,eCommon,eCP,eDR,eDS,eFM,eIP,eLC,eMM,eMO,eMP,eMR,eOA,eOH,eOP,eOR,eOT,ePH,eRS,eSM,eSP,eSS,eST,eXH,eXI";
StringTokenizer elementToken = null;
String arr[] = new String[10];
String arr1[] = new String[10];
boolean jspNotListed = false;

try
{
  /* Get the path part of the URL. (path of the file)
  Eg:  /eHIS/eAM/jsp/AddModifyPractForExternalReferral.jsp
   */
  String path = url.getPath();

  /* Gets the context path.
  Eg: /eHIS
   */
  String contextPath = request.getContextPath();

  /* Remove the context path and storing the path from the module id.
  arr[1] will store the Key for the map file 'map.properties'
  Eg: arr[1] = eAM/jsp/AddModifyPractForExternalReferral.jsp
   */
  arr = path.split(contextPath + "/");

  /* Get the module id.
  Eg: eAM
   */
  if (arr[1].indexOf("/") >  - 1)
    module_id = arr[1].substring(0, arr[1].indexOf("/"));
  else
    if (!voFunctionId.equals(""))
      module_id = "e" + voFunctionId.substring(0, voFunctionId.indexOf("_"));


  /* For all modules except CA get the key id from the
  PropertyResourceBundle
   */
  if (moduleList.indexOf(module_id) >  - 1)
  {
    if (arr != null)
    {
      jspNotListed = false;
      id = bundle.getString(arr[1]);
    }
  }
  /* For most of the CA transactions Option_id or Task id will be there as part of the URL */
  else
  {
    /* Get the parameter list from the URL */
    paramUrl = strUrl.substring(strUrl.indexOf("?") + 1);
    /*
    Block to derive the key value pair from query string
     */
    /* If there are one or more parameters */
    if (strUrl.indexOf("?") >  - 1)
    {
      /* If only one parameter is passed with value or with out value */
      if (paramUrl.indexOf("&") ==  - 1)
      {
        /* If atleast one parameter & value pair exists */
        if (paramUrl.indexOf("=") >  - 1)
        {
          String eleArr[] = paramUrl.split("=");
          /* If only key value pair exists - the value for the parameter should not be null */
          if (eleArr.length > 1)
          {
            if (!QryStrMap.containsKey(eleArr[0]))
              QryStrMap.put(eleArr[0], eleArr[1]);
          }
        }
        /* If no value is passed to the parameter the html file will be taken as per map.properties */
      }
      /* If more than one parameters are passed. Store them all in QryStrMap */
      else
      {
        arr1 = qryString.split("&");
        for (int i = 0; i < arr1.length; ++i)
        {
          String eleArr[] = arr1[i].split("=");
          if (!QryStrMap.containsKey(eleArr[0]))
            QryStrMap.put(eleArr[0], eleArr[1]);
        }
      }
    }
    /*
    If function_id / functionid is passed in the URL, assign it to function_id
     */
    if (function_id.equals(""))
    {
      if ((QryStrMap.containsKey("function_id")) && (!QryStrMap.get(
        "function_id").equals("")))
        function_id = checkForNull(QryStrMap.get("function_id").toString());
      else
        if (QryStrMap.containsKey("functionid"))
          function_id = checkForNull(QryStrMap.get("functionid").toString());
    }
    /*
    If option_id / appl_task_id is passed in the URL, assign it to option_id
     */
    try
    {
      if (QryStrMap.containsKey("option_id"))
      {
        option_id = QryStrMap.get("option_id").toString();
      }
      else if (QryStrMap.containsKey("appl_task_id"))
      {
        option_id = QryStrMap.get("appl_task_id").toString();
      }
      /*
      If option_id / appl_task_id is not present the mapping will be in map.properties. so throw an exception and set the flag jspNotListed to FALSE so that the map id will be checked in next block
       */
      else
      {
        /*
        If the parameter url doesn't contain option_id or appl_task_id we have to look up		JSP mapping to online help. In Masters and few transactions this scenario occurs
         */
        throw new MissingResourceException("Missing Resource",
          "mapca.properties", option_id);
      }
      option_id = "CA_" + option_id;
      id = bundleOptTask.getString(option_id);
    }
    catch (MissingResourceException mref)
    {
      jspNotListed = false;
      try
      {
        /*
        Even if option_id / appl_task_id is present but mapping is not done based on that.	The map id will be checked based on jsp in map.properties
         */
        id = bundle.getString(arr[1]);
      }
      catch (MissingResourceException mref1)
      {
        /* JSP file is not mapped in map.properties*/
        try
        {
          modFunc = module_id.substring(1, module_id.length()) + "_" +
            function_id;
          id = bundleFunc.getString(modFunc);
        }
        catch (MissingResourceException mrefunc)
        {
          out.println("Help is not available for this page.");
          /* Function ID is not mapped in mapfunc.properties*/
          jspNotListed = true;
        }
      }
    }
  }
}
catch (MissingResourceException mre)
{
  mre.printStackTrace();
  jspNotListed = true;
  System.out.println("excep : " + mre);
}

/*If the mapping is not done based on JSP*/


if (jspNotListed)
{
  try
  {
    /* Retrieve the query string from session if available*/
    qryString = (session.getValue("queryString")).toString();
    arr = qryString.split("&");
    String moduleIdFromSession = (arr[1].split("="))[1];

    /*
    In some cases the value in session is not cleared from previous function. So we may see wrong data irrelevant to current context. Hence here we compare the module id from URL with value in  Session, if they both match it is valid value else we clear the value.
    One exception - If the previous context is from same module then we can't validate that. So we give the file URL higher priority over the session data to fetch function_id in the next block.
    If the function id is not available in URL then only we check the Session data.

    menu_id=AE&module_id=AE&function_id=AE_REGISTER_ATTN&function_name=Register%20Attendance&function_type=F&access=NYNNN&desktopFlag=N

    menu_id=OT_JAVA_DFLT&module_id=OT&function_id=OT_RECORD_ANESTHESIA&function_name=Record%20Anaesthesia%20Details&function_type=F&access=YYNNY&desktopFlag=N&facility_id=GW
     */
    if (!moduleIdFromSession.equals(module_id.substring(1, module_id.length())))
      qryString = "";
  }
  catch (Exception mref)
  {
    /* If the query string is null assign empty string*/
    qryString = "";
  }

  /*
  To fetch the html file based on Function Id
   */
  try
  {
    /*
    If the function id is not available from session.
    Derive it from the URL
     */
    if (!strUrl.equals(""))
    {
      /* Get the parameter list from the URL */
      paramUrl = strUrl.substring(strUrl.indexOf("?") + 1);
      /* If there are one or more parameters */
      if (strUrl.indexOf("?") >  - 1)
      {
        /* If only one parameter is passed with value or with out value */
        if (paramUrl.indexOf("&") ==  - 1)
        {
          /* If atleast one parameter & value pair exists */
          if (paramUrl.indexOf("=") >  - 1)
          {
            String eleArr[] = paramUrl.split("=");
            /* If only key value pair exists - the value for the parameter should not be null */
            if (eleArr.length > 1)
            {
              if (!QryStrMap.containsKey(eleArr[0]))
                QryStrMap.put(eleArr[0], eleArr[1]);
            }
          }
          /* If no value is passed to the parameter the html file will be taken as per map.properties */
        }
        /* If more than one parameters are passed. Store them all in QryStrMap */
        else
        {
          arr1 = paramUrl.split("&");
          for (int i = 0; i < arr1.length; ++i)
          {
            String eleArr[] = arr1[i].split("=");
            if (!QryStrMap.containsKey(eleArr[0]))
              QryStrMap.put(eleArr[0], eleArr[1]);
          }
        }
      }
      /*
      If function_id / functionid is passed in the URL, assign it to function_id
       */
      if (function_id.equals(""))
      {
        if ((QryStrMap.containsKey("function_id")) && (!QryStrMap.get(
          "function_id").equals("")))
          function_id = checkForNull(QryStrMap.get("function_id").toString());
        else
          if (QryStrMap.containsKey("functionid"))
            function_id = checkForNull(QryStrMap.get("functionid").toString());
      }
      modFunc = module_id.substring(1, module_id.length()) + "_" + function_id;
      id = bundleFunc.getString(modFunc);
    }
    /*
    If there is valid data in query string get the map id based on function_id in qryString
     */
    else if (!qryString.equals(""))
    {
      for (int i = 0; i < arr.length; ++i)
      {
        String eleArr[] = arr[i].split("=");
        QryStrMap.put(eleArr[0], eleArr[1]);
      }
      /*
      If function_id / functionid is passed in the URL, assign it to function_id
       */
      if (function_id.equals(""))
      {
        if ((QryStrMap.containsKey("function_id")) && (!QryStrMap.get(
          "function_id").equals("")))
          function_id = checkForNull(QryStrMap.get("function_id").toString());
        else
          if (QryStrMap.containsKey("functionid"))
            function_id = checkForNull(QryStrMap.get("functionid").toString());
      }
      modFunc = QryStrMap.get("module_id") + "_" + function_id;

      id = bundleFunc.getString(modFunc);
    }
    /*
    If there is a no data in query string or URL. The frame location is not proper or Mapping is missed out in all of the properties files.
     */
    else
      out.println("Help is not available for this page.");
  }
  catch (MissingResourceException mref)
  {
    out.println("Help is not available for this page.");
    mref.printStackTrace(System.err);
    return ;
  }
  catch (Exception mref)
  {
    out.println(mref.toString());
    mref.printStackTrace(System.err);
  }
}
%>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

	<iframe SRC="toolbar.html" name="toolbar" id="toolbar" style="height:80%;width:100vw"></iframe><iframe SRC="<%=id%>" NAME="contentsFrame" id="contentsFrame" style="height:100vh;width:100vw"></iframe>

