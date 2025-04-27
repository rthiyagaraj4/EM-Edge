Content:
========
This document explains the changes needs to be done to the web.xml, weblogic-application.xml and application.xml in case of any new EJB projects or Web component additions.

Description:
============
EM currently available 22 EJB projects are considered in the current version (as on 22/02/2013) of configuration xmls mentioned in the content section. Both the files need to be modified to add any new EJB projects, in future.

Any new Servlets, TLDs and EJB mapping needs to be done in the web.xml as well. The file is up-to-date as on 22/02/2013. Currently web.xml is maintained specific to OC4J and WebLogic. The context root for the default application access is HIS.


