<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created	
13/09/2012    IN029712	    Akbar        BRU-hims-CRF-001 - Spell check CRF
21/09/2012	  IN035323		Ramesh G	 Bru-HIMS-CRF-001 /02- Add Button not displayed	
---------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/RapidSpellWeb.tld" prefix="RapidSpellWeb" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML//EN">
<html>
<title>Spell Check</title>
<body>
<center>
<%
//IN035323 Start.
String backSlash = "\\";
String frontSlash = "/";
String dictFilePath = "";
//IN035323 End.
String 	userid	=	(String)session.getValue("login_user");
//String dictFileName = "~/userdictionaries/";
String dictFileName = "~/eCA/userdictionaries/";
String userDictionary = userid+"-dictionary.txt";
	dictFileName = dictFileName + userDictionary;
String dictPath = session.getServletContext().getRealPath(dictFileName);
	dictFilePath = dictPath.replace(backSlash, frontSlash);
//IN035323 Start.
//Medical Dictionary Path
	String medDictFilePath = "";
	String medDictPath = session.getServletContext().getRealPath("~/eCA/Dictionaries/DICT-EN-G-UK+US.dict");
	medDictFilePath = medDictPath.replace(backSlash, frontSlash);
//IN035323 End.

%>
<RapidSpellWeb:rapidSpellWeb licenseKey="2A787A2822217E24212D7E7E543F3B3D273E3E3E3C4042444046464644484A4C465E5A4B6"
userDictionaryFile="<%= dictFileName %>"  assumedApplicationEncoding="8859_1" 
/>
</center>
</body>
</html>
