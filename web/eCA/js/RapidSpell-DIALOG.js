/*--Keyoti js--*/
/*<![CDATA[*/
//Version 1.4 (RapidSpell Web assembly version 3.5 onwards)
//Copyright Keyoti Inc. 2005-2008
//This code is not to be modified, copied or used without a license in any form.

var rsS60=new Array("rsTCInt",
"undefined",
"IgnoreXML",
"True",
"popUpCheckSpelling",
"('rsTCInt",
"')",
"g",
"&#34;",
"&",
"&amp;",
"Error: element ",
" does not exist, check TextComponentName.",
"",
"Sorry, a textbox with ID=",
" couldn't be found - please check the TextComponentID or TextComponentName property.",
"_IF",
"TEXTAREA",
"INPUT",
" EDITABLE",
"\r\n",
" ",
"contentEditable",
"true",
"designMode",
"on",
"IFRAME",
" --has contentWindow.document",
"*",
"script",
"Sorry, cannot find a script import named ",
".js, please do not rename any RapidSpell scripts.",
"RapidSpell-",
"<",
"blank.html",
"menu.css",
"rs_style.css",
"RapidSpellModalHelper.html",
"UserDictionaryFile",
"SuggestionsMethod",
"SeparateHyphenWords",
"IncludeUserDictionaryInSuggestions",
"IgnoreCapitalizedWords",
"GuiLanguage",
"LanguageParser",
"Modal",
"AllowAnyCase",
"IgnoreWordsWithDigits",
"ShowFinishedMessage",
"ShowNoErrorsMessage",
"ShowXMLTags",
"AllowMixedCase",
"WarnDuplicates",
"DictFile",
"PopUpWindowName",
"CreatePopUpWindow",
"ConsiderationRange",
"LookIntoHyphenatedText",
"CheckCompoundWords",
"EnableUndo",
"LeaveWindowOpenForUndo",
"SSLFriendlyPage",
"IgnoreURLsAndEmailAddresses",
"IgnoreIncorrectSentenceCapitalization",
"IgnoreInEnglishLowerCaseI",
"SuggestSplitWords",
"CorrectionNotifyListener",
"~/user-dictionary.txt",
"HASHING_SUGGESTIONS",
"false",
"ENGLISH",
"80",
"rsw_ondialogcorrection",
"dialog_correction",
"FRENCH",
"SPANISH",
"GERMAN",
"ITALIAN",
"PORTUGUESE",
"DUTCH",
"POLISH",
"Ignore",
"Ignore All",
"Add",
"Edit...",
"All",
"Remove duplicate word",
"No suggestions",
"Ignorer",
"Ignorer Tout",
"Ajouter",
"�?ditez...",
"Tout",
"Enlevez le mot double",
"Aucun",
"Ignorar",
"Ignorar Todas",
"Agregar",
"Corrija...",
"Todas",
"Quite la palabra duplicada",
"Ningunas sugerencias",
"Ignorieren",
"Alle ignorieren",
"Hinzufügen",
"Redigieren...",
"Alle",
"Doppelte Wörter entfernen",
"Keine vorschläge",
"Ignora",
"Ignora tutto",
"Aggiungi",
"Modifica...",
"Tutto",
"Rimuovi la parola duplicata",
"Nessun suggerimento",
"Ignore Tudo",
"Adicione",
"Edite...",
"Tudo",
"Remova a palavra duplicada",
"Nenhumas sugestões",
"Negeren",
"Alles negeren",
"Toevoegen",
"Corrigeren...",
"Allen",
"Verwijder herhaald woord",
"Geen suggesties",
"Ignoruj",
"Ignoruj wszystko",
"Dodaj",
"Edytuj...",
"Wszystko",
"Usun podwójne wystapienie slowa",
"Nie ma sugestii",
"default",
"hidden",
"none",
"Please ensure that you include the RapidSpell-Core.js file in your page, before the RapidSpell-Launcher.js file is imported.",
"popup.aspx",
"dialog_finishedcheckingall",
"function",
"text",
"nospell",
"rs",
"textarea",
"input",
"rsw_oldOnLoad",
"&#",
";",
"<input type=hidden name=",
" value='",
"'>",
"rspellwin",
"resizable=yes,scrollbars=auto,dependent=yes,toolbar=no,left=100,top=100,status=no,location=no,menubar=no,width=370,height=400",
"The spell checker popup has been blocked, most likely from a popup blocker.",
"typeof(",
"var curState=",
"_SpellChecker.state",
"var cs=",
"overlay",
"_SpellChecker.OnSpellButtonClicked()",
"dialog_startedcheckingtextbox",
"rsTCInt['",
"']",
"dialogHeight: ",
"px; dialogWidth: ",
"px; ",
"dialogLeft:",
"; ",
"dialogTop:",
"edge: Sunken; center: Yes; help: No; resizable: No; status: No;",
"resizable=yes,scrollbars=auto,dependent=yes,toolbar=no,left=",
",top=",
",status=no,location=no,menubar=no,width=",
",height=",
"dialog_finishedcheckingtextbox",
"The spelling check is complete.");																																				var rs_s2=window;var rs_s3=document; var rsw_launcher_script_loaded = true; var rsw_suppressWarnings=false; function SpellCheckLauncher(clientID){ this.clientID = clientID;
																																						 this.OnSpellButtonClicked = OnSpellButtonClicked; this.config; this.hasRunFieldID; this.getParameterValue = getParameterValue; this.setParameterValue = setParameterValue;
																																						 this.tbInterface = null; function getParameterValue(param){ for(var pp=0; pp<this.config.keys.length; pp++){ if(this.config.keys[pp]==param) return this.config.values[pp];
																																						 } } function setParameterValue(param, value){ for(var pp=0; pp<this.config.keys.length; pp++){ if(this.config.keys[pp]==param) this.config.values[pp] = value; } } function OnSpellButtonClicked(){ this.tbInterface = eval(rsS60[0]+this.clientID);
																																						 if(this.tbInterface!=null && typeof(this.tbInterface.findContainer)!=rsS60[1]){ this.textBoxID = this.tbInterface.findContainer().id; if (!this.tbInterface.targetIsPlain){ this.setParameterValue(rsS60[2], rsS60[3]);
																																						 } } eval(rsS60[4]+this.clientID+rsS60[5]+this.clientID+rsS60[6]); } } function RS_writeDoc(toWindow, isSafari){ toWindow.document.open(); toWindow.document.write(spellBoot);
																																						 toWindow.document.close(); if(isSafari) toWindow.document.forms[0].submit(); } function escQuotes(text){ var rx = new RegExp("\"", rsS60[7]); return text.replace(rx,rsS60[8]);
																																						 } function escEntities(text){ var rx = new RegExp(rsS60[9], rsS60[7]); return text.replace(rx,rsS60[10]); } function RSStandardInterface(tbElementName){ this.tbName = tbElementName;
																																						 this.getText = getText; this.setText = setText; function getText(){ if(!document.getElementById(this.tbName) && !rsw_suppressWarnings) { alert(rsS60[11]+this.tbName+rsS60[12]);
																																						 return rsS60[13]; } else return rs_s3.getElementById(this.tbName).value; } function setText(text){ if(rs_s3.getElementById(this.tbName)) rs_s3.getElementById(this.tbName).value = text;
																																						 if(typeof(rsw_tbs)!=rsS60[1]){ for(var i=0; i<rsw_tbs.length; i++){ if(rsw_tbs[i].shadowTB.id==this.tbName){ if(rsw_tbs[i].updateIframe){rsw_tbs[i].updateIframe();
																																						rsw_tbs[i].focus();} } } } } } function RSAutomaticInterface(tbElementName){ this.tbName = tbElementName;this.getText = getText;this.setText = setText; this.identifyTarget = identifyTarget;
																																						 this.target=null; this.targetContainer = null; this.searchedForTarget = false; this.targetIsPlain = true; this.showNoFindError = showNoFindError; this.finder = null;
																																						 this.findContainer = findContainer; function findContainer(){ this.identifyTarget(); return this.targetContainer; } function showNoFindError(){ alert(rsS60[14]+this.tbName+rsS60[15]);
																																						 } function identifyTarget(){ if(!this.searchedForTarget){ this.searchedForTarget = true; if(this.finder == null) this.finder = new RSW_EditableElementFinder(); var plain = this.finder.findPlainTargetElement(this.tbName);
																																						 var richs = this.finder.findRichTargetElements(); if(plain==null && (richs==null || richs.length==0) && !rsw_suppressWarnings) showNoFindError(); else{ if(richs==null || richs.length==0){ this.targetIsPlain = true;
																																						 this.target = plain; this.targetContainer = plain; } else { if(plain==null && richs.length==1){ this.targetIsPlain = false; this.target = this.finder.obtainElementWithInnerHTML(richs[0][0]);
																																						 this.targetContainer = richs[0][1]; } else { for (var rp = 0; rp < richs.length; rp ++){ if(typeof(richs[rp][1].id)!=rsS60[1] && richs[rp][1].id.indexOf(this.tbName)>-1){ if(plain!=null && richs[rp][1].id == plain.id+rsS60[16]){ this.targetIsPlain = true;
																																						 this.target = plain; this.targetContainer = plain; break; } else { this.targetIsPlain = false; this.target = this.finder.obtainElementWithInnerHTML(richs[rp][0]);
																																						 this.targetContainer = richs[rp][1]; break; } } } if(this.target==null){ this.target = plain; this.targetIsPlain = true; this.targetContainer = plain; } } } } } } function getText(){ this.identifyTarget();
																																						 if( this.targetIsPlain ) return this.target.value; else return this.target.innerHTML; } function setText(text){ this.identifyTarget(); if( this.targetIsPlain ) this.target.value= text;
																																						 else this.target.innerHTML = text; if(typeof(rsw_tbs)!=rsS60[1]){ for(var i=0; i<rsw_tbs.length; i++){ if(rsw_tbs[i].shadowTB.id==this.tbName){ if(rsw_tbs[i].updateIframe){rsw_tbs[i].updateIframe();
																																						rsw_tbs[i].focus();} } } } } } function RSW_EditableElementFinder(){ this.findPlainTargetElement = findPlainTargetElement; this.findRichTargetElements = findRichTargetElements;
																																						 this.obtainElementWithInnerHTML = obtainElementWithInnerHTML; this.findEditableElements = findEditableElements; this.elementIsEditable = elementIsEditable; this.getEditableContentDocument = getEditableContentDocument;
																																						 function findPlainTargetElement(elementID){ var rsw_elected = rs_s3.getElementById(elementID); if(rsw_elected!=null && rsw_elected.tagName && (rsw_elected.tagName.toUpperCase()==rsS60[17] || rsw_elected.tagName.toUpperCase()==rsS60[18])){ return rsw_elected;
																																						 } else return null; } function findRichTargetElements(debugTextBox){ var editables = new Array(); this.findEditableElements(document, editables, window,rsS60[13], debugTextBox);
																																						 return editables; } function obtainElementWithInnerHTML(editable){ if(typeof(editable.innerHTML)!=rsS60[1]) return editable; else if(typeof(editable.documentElement)!=rsS60[1]) return editable.documentElement;
																																						 return null; } function findEditableElements(node, editables, parent, debugInset, debugTextBox){ var children = node.childNodes; var editableElement; if(debugTextBox) debugTextBox.value += debugInset + node.tagName;
																																						 if( (editableElement=this.elementIsEditable(node))!=null || (editableElement=this.getEditableContentDocument(node, debugTextBox))!=null ){ if(debugTextBox) debugTextBox.value += rsS60[19];
																																						 editables[editables.length] = editableElement; } if(debugTextBox) debugTextBox.value += rsS60[20]; for (var i = 0; i < children.length; i++) { this.findEditableElements(children[i], editables, node, debugInset+rsS60[21], debugTextBox);
																																						 } } function elementIsEditable(element){ if ( ( typeof(element.getAttribute)!=rsS60[1] && ( element.getAttribute(rsS60[22])==rsS60[23] || element.getAttribute(rsS60[24])==rsS60[25] ) ) || ( (element.contentEditable && element.contentEditable==true) || (element.designMode && element.designMode.toLowerCase()==rsS60[25]) ) ) return [element, element];
																																						 else return null; } function getEditableContentDocument(element, debugTextBox){ if(element.tagName && element.tagName==rsS60[26]){ var kids = new Array(); if(element.contentWindow && element.contentWindow.document){ if(debugTextBox) debugTextBox.value += rsS60[27];
																																						 this.findEditableElements(element.contentWindow.document, kids, element, rsS60[28], debugTextBox); if(kids.length>0){ var editable = kids[0][0]; if(typeof(editable.body)!=rsS60[1]) editable = editable.body;
																																						 return [editable, element]; } } } return null; } } if( typeof(Sys)!=rsS60[1] && typeof(Sys.Application)!=rsS60[1]) Sys.Application.notifyScriptLoaded(); if(typeof(RapidSpell)==rsS60[1])RapidSpell = function () { };
																																						 RapidSpell.prototype.getConfigurationObject = rsw_getConfigurationObject; RapidSpell.prototype.setParameterValue = rsw_setParameterValue; RapidSpell.prototype.getParameterValue = rsw_getParameterValue;
																																						 RapidSpell.prototype.addEventListener = rsw_addEventListener; RapidSpell.prototype.removeEventListener = rsw_removeEventListener; var rsw_eventListeners = []; function rswEventListener(eventName, listener) { this.eventName = eventName;
																																						 this.listener = listener; } function rsw_addEventListener(eventName, listenerFunction) { rsw_eventListeners[rsw_eventListeners.length] = new rswEventListener(eventName, listenerFunction);
																																						 } function rsw_removeEventListener(eventName, listenerFunction) { var foundAt=-1; for (var i = 0; foundAt==-1 && i < rsw_eventListeners.length; i++) { if(rsw_eventListeners[i].listener==listenerFunction && rsw_eventListeners[i].eventName==eventName) foundAt=i;
																																						 } if(foundAt>-1) rsw_eventListeners.splice(foundAt, 1); } function rsw_broadcastEvent(eventName, source, data1, data2, data3, data4, data5) { for (var i = 0; i < rsw_eventListeners.length;
																																						 i++) { if (rsw_eventListeners[i].eventName == eventName) rsw_eventListeners[i].listener(source, data1, data2, data3, data4, data5); } } function rsw_getScriptLocation(name) { var scripts = rs_s3.getElementsByTagName(rsS60[29]);
																																						 var l; for (var i = 0; i < scripts.length; i++) { if ((l = scripts[i].src.indexOf(name)) > -1) { return scripts[i].src.substring(0, l); } } alert(rsS60[30] + name + rsS60[31]);
																																						 } var rsw_scriptLocation = rsw_getScriptLocation(rsS60[32]); var rapidSpell = rapidSpell ? rapidSpell : new RapidSpell(); var rsw_RapidSpell_Core=true; var rsw_ignoreDisabledTextBoxes = true;
																																						 var rsw_ignoreReadyOnlyTextBoxes = true; var rsw_blankLocation = '<%= WebResource("blank.html") %>'.indexOf(rsS60[33]) > -1 ? rsw_scriptLocation + rsS60[34] : '<%= WebResource("blank.html") %>';
																																						 rsw_rs_menu_styleURL = '<%= WebResource("menu-net2.css") %>'.indexOf(rsS60[33]) > -1 ? rsw_scriptLocation + rsS60[35] : '<%= WebResource("menu-net2.css") %>'; rsw_rs_styleURL = '<%= WebResource("rs_style-net2.css") %>'.indexOf(rsS60[33]) > -1 ? rsw_scriptLocation + rsS60[36] : '<%= WebResource("rs_style-net2.css") %>';
																																						 rsw_modalHelperURL = '<%= WebResource("RapidSpellModalHelperNET2.html") %>'.indexOf(rsS60[33]) > -1 ? rsw_scriptLocation + rsS60[37] : '<%= WebResource("RapidSpellModalHelperNET2.html") %>';
																																						 var rsw_targetIDs = new Array(); var rsw_rapidSpellControls = new Array(); var rsw_config_textBoxKeys = new Array(); var rsw_config_textBoxValues = new Array(); var rsw_config_defaults = { keys: [rsS60[38], rsS60[39], rsS60[40], rsS60[41], rsS60[2], rsS60[42], rsS60[43], rsS60[44], rsS60[45], rsS60[46], rsS60[47], rsS60[48], rsS60[49], rsS60[50], rsS60[51], rsS60[52], rsS60[53], rsS60[54], rsS60[55], rsS60[56], rsS60[57], rsS60[58], rsS60[59], rsS60[60], rsS60[61], rsS60[62], rsS60[63], rsS60[64], rsS60[65], rsS60[66]], values: [rsS60[67], rsS60[68], rsS60[69], rsS60[23], rsS60[69], rsS60[69], rsS60[70], rsS60[70], rsS60[69], rsS60[69], rsS60[69], rsS60[69], rsS60[69], rsS60[69], rsS60[69], rsS60[23], rsS60[13], rsS60[13], rsS60[69], rsS60[71], rsS60[23], rsS60[69], rsS60[23], rsS60[69], rsw_blankLocation, rsS60[69], rsS60[69], rsS60[69], rsS60[23], rsS60[72]] };
																																						 function rsw_ondialogcorrection(a, b, c, tbName) { rsw_broadcastEvent(rsS60[73], null, rs_s3.getElementById(tbName), a, b, c); } var rsw_menuOptionKeys = [rsS60[70], rsS60[74], rsS60[75], rsS60[76], rsS60[77], rsS60[78], rsS60[79], rsS60[80]];
																																						 var rsw_menuOptionValues = [ [rsS60[81], rsS60[82], rsS60[83], rsS60[84], rsS60[85], rsS60[86], rsS60[87]], [rsS60[88], rsS60[89], rsS60[90], rsS60[91], rsS60[92], rsS60[93], rsS60[94]], [rsS60[95], rsS60[96], rsS60[97], rsS60[98], rsS60[99], rsS60[100], rsS60[101]], [rsS60[102], rsS60[103], rsS60[104], rsS60[105], rsS60[106], rsS60[107], rsS60[108]], [rsS60[109], rsS60[110], rsS60[111], rsS60[112], rsS60[113], rsS60[114], rsS60[115]], [rsS60[81], rsS60[116], rsS60[117], rsS60[118], rsS60[119], rsS60[120], rsS60[121]], [rsS60[122], rsS60[123], rsS60[124], rsS60[125], rsS60[126], rsS60[127], rsS60[128]], [rsS60[129], rsS60[130], rsS60[131], rsS60[132], rsS60[133], rsS60[134], rsS60[135]] ];
																																						 function rsw_getLanguageArray(lang) { for (var i = 0; i < rsw_menuOptionKeys.length; i++) { if (rsw_menuOptionKeys[i] == lang) return rsw_menuOptionValues[i]; } return null;
																																						 } function rsw_getParameterValue(textBox, param) { var searchObj; var pos = rsw_getTextBoxIndex(textBox); if (pos == -1 && textBox != rsS60[136]) return rsw_getParameterValue(rsS60[136], param);
																																						 else { if (textBox == rsS60[136]) { searchObj = rsw_config_defaults; } else searchObj = rsw_config_textBoxValues[pos]; var found = -1; for (var pp = 0; searchObj.keys && pp < searchObj.keys.length && found == -1;
																																						 pp++) { if (searchObj.keys[pp] == param) found = pp; } if (found == -1) return rsw_getParameterValue(rsS60[136], param); else { return searchObj.values[found]; } } } function rsw_getConfigurationObject(textBox) { var synthObject = {keys:[], values:[]};
																																						 for (var i = 0; i < rsw_config_defaults.keys.length; i++) { synthObject.keys[synthObject.keys.length] = rsw_config_defaults.keys[i]; synthObject.values[synthObject.values.length] = rsw_getParameterValue(textBox, rsw_config_defaults.keys[i]);
																																						 } return synthObject; } function rsw_getTextBoxIndex(textBox) { for (var i = 0; i < rsw_config_textBoxKeys.length; i++) { if (rsw_config_textBoxKeys[i] == textBox) return i;
																																						 } return -1; } function rsw_setParameterValue(textBox, param, value) { var pos; if (textBox != rsS60[136]) { pos = rsw_getTextBoxIndex(textBox); if (pos == -1) { rsw_config_textBoxKeys[rsw_config_textBoxKeys.length] = textBox;
																																						 pos = rsw_config_textBoxKeys.length - 1; rsw_config_textBoxValues[pos] = {}; } } var targ; if (textBox != rsS60[136]) targ = rsw_config_textBoxValues[pos]; else targ = rsw_config_defaults;
																																						 var found = -1; for (var pp = 0; targ.keys && pp < targ.keys.length && found == -1; pp++) { if (targ.keys[pp] == param) found = pp; } if (!targ.keys) { targ.keys = new Array();
																																						 targ.values = new Array(); } if (found == -1) found = targ.keys.length; targ.keys[found] = param; targ.values[found] = value; if(typeof(rsw_scs)!=rsS60[1]){ for (var i = 0;
																																						 i < rsw_scs.length; i++) { if (textBox==rsS60[136] || rsw_scs[i].textBoxId == textBox.id) { rsw_scs[i].config = rsw_getConfigurationObject(rs_s3.getElementById(rsw_scs[i].textBoxId));
																																						 if (param == rsS60[43]) { var langArray = rsw_getLanguageArray(value); if (langArray != null) { rsw_scs[i].ignoreText = langArray[0]; rsw_scs[i].ignoreAllText = langArray[1];
																																						 rsw_scs[i].addText = langArray[2]; rsw_scs[i].editText = langArray[3]; rsw_scs[i].changeAllText = langArray[4]; rsw_scs[i].removeDuplicateText = langArray[5]; rsw_scs[i].noSuggestionsText = langArray[6];
																																						 } } } } } } function rsw_isElementVisible(tb) { if (rs_s3.getElementById(tb.id + rsS60[16]) != null) return true; if ((tb.style && tb.style.visibility && tb.style.visibility == rsS60[137]) || (tb.style && tb.style.display == rsS60[138])) return false;
																																						 if (tb.parentElement != null) return rsw_isElementVisible(tb.parentElement); else if (typeof (tb.parentElement) == rsS60[1] && tb.parentNode != null) return rsw_isElementVisible(tb.parentNode);
																																						 else return true; } var rsw_RapidSpell_Launcher = true; if (!rsw_RapidSpell_Core) alert(rsS60[139]); rapidSpell.dialog_popupURL = rsw_scriptLocation+rsS60[140]; rapidSpell.dialog_modal = false;
																																						 rapidSpell.dialog_width = 370; rapidSpell.dialog_height= 400; rapidSpell.dialog_left = 100; rapidSpell.dialog_top = 100; rapidSpell.dialog_ignoreTextBoxIds = new Array();
																																						 var rsw_mult_use_update = true; var rsTCInt = new Object(); rapidSpell.addEventListener(rsS60[141], function (src, textBox) { if (typeof (rapidSpell.ayt_spellCheck) == rsS60[142]) rapidSpell.ayt_spellCheck();
																																						 }); RapidSpell.prototype.dialog_spellCheck = rswm_RunSpellCheck; function rsw_isTextBoxIgnoredDialog(tbId) { for (var i = 0; i < rapidSpell.dialog_ignoreTextBoxIds.length;
																																						 i++) if (tbId == rapidSpell.dialog_ignoreTextBoxIds[i]) return true; return false; } function rsw_setup_SpellControls(optionalID) { rsw_targetIDs = []; var myElements = rs_s3.forms[0].elements;
																																						 for (var i = 0; i < myElements.length; i++) { var cobj = myElements[i]; if ((typeof (optionalID) != rsS60[1] && cobj.id == optionalID) || typeof (optionalID) == rsS60[1]) { if ((((cobj.tagName == rsS60[18] && cobj.type.toLowerCase() == rsS60[143]) || (cobj.tagName == rsS60[17]) || (cobj.tagName == rsS60[26])) && (!rsw_ignoreReadyOnlyTextBoxes || !cobj.readOnly) && (!rsw_ignoreDisabledTextBoxes || !cobj.disabled) && cobj.value != rsS60[13]) && cobj.getAttribute(rsS60[144]) != rsS60[23] && rsw_isElementVisible(cobj) && !rsw_isTextBoxIgnoredDialog(cobj.id) ) { rsw_targetIDs[rsw_targetIDs.length] = cobj.id;
																																						 } } } if (rsw_targetIDs.length == 0 && typeof(optionalID)!=rsS60[1]) { rsw_targetIDs[rsw_targetIDs.length] = optionalID; } rsw_rapidSpellControls = []; for (var i = 0;
																																						 i < rsw_targetIDs.length; i++) { if (typeof (rapidSpell.textInterfaceNeeded) == rsS60[142]) rsTCInt[rsS60[145] + i] = new rapidSpell.textInterfaceNeeded(rsw_targetIDs[i]);
																																						 else rsTCInt[rsS60[145] + i] = new RSAutomaticInterface(rsw_targetIDs[i]); rsw_rapidSpellControls[i] = rsS60[145] + i; } } function rsw_findTextBoxes() { var textareas = rs_s3.getElementsByTagName(rsS60[146]);
																																						 var inputs = rs_s3.getElementsByTagName(rsS60[147]); for (var i = 0; i < textareas.length; i++) { if (!textareas[i].readOnly && !textareas[i].disabled && textareas[i].getAttribute(rsS60[144]) != rsS60[23]) rsw_targetIDs[rsw_targetIDs.length] = textareas[i].id;
																																						 } for (var i = 0; i < inputs.length; i++) { if (!inputs[i].readOnly && !inputs[i].disabled && inputs[i].type.toLowerCase() == rsS60[143] && inputs[i].getAttribute(rsS60[144]) != rsS60[23]) rsw_targetIDs[rsw_targetIDs.length] = inputs[i].id;
																																						 } for (var i = 0; i < rsw_targetIDs.length; i++) { rsTCInt[rsS60[145] + i] = new RSAutomaticInterface(rsw_targetIDs[i]); rsw_rapidSpellControls[i] = rsS60[145] + i;
																																						 } if (typeof (rsS60[148]) == rsS60[142]) rsw_oldOnLoad(); } function RSStandardInterface(tbElementName) { this.tbName = tbElementName; this.getText = getText; this.setText = setText;
																																						 function getText() { return rs_s3.getElementById(this.tbName).value; } function setText(text) { rs_s3.getElementById(this.tbName).value = text; } } function rsw_escQuotes(text) { var rx = new RegExp("\"", rsS60[7]);
																																						 return text.replace(rx, rsS60[8]); } function rsw_escEntities(text) { var rx = new RegExp(rsS60[9], rsS60[7]); text = text.replace(rx, rsS60[10]); for (var i = 161;
																																						 i <= 255; i++) { rx = new RegExp(String.fromCharCode(i), rsS60[7]); text = text.replace(rx, rsS60[149] + i + rsS60[150]); } return text; } function rsw_getrsw_spellBootString(interfaceObject) { var res = new String();
																																						 var textBox = rs_s3.getElementById(interfaceObject.tbName); for(var i=0; i<rsw_config_defaults.keys.length; i++){ var key = rsw_config_defaults.keys[i]; var value = rsw_config_defaults.values[i];
																																						 var cval = rsw_getParameterValue(textBox, key); if(cval!=null) value = cval; res += rsS60[151] + key + rsS60[152] + value + rsS60[153]; } return res; } function rsw_createSpellBoot(interfaceObject, interfaceObjectName) { rsw_spellBoot = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body onload=\"if(navigator.userAgent.indexOf('MSIE') > -1)docu" + "ment.forms[0].submit();\"><font face='arial, helvetica' size=2>Spell checking docu" + "ment...</font><form action='" + rapidSpell.dialog_popupURL + "' method='post' ACCEPT-CHARSET='UTF-8'>";
																																						 rsw_spellBoot += "<input type='hidden' name='FinishedListener' id='FinishedListener' value='rswm_NotifyDone'><input type='hidden' name='InterfaceObject' id='InterfaceObject' value=\"" + interfaceObjectName + "\"><input type='hidden' name='textToCheck' id='textToCheck' value=\"" + rsw_escQuotes(rsw_escEntities(interfaceObject.getText())) + "\"><input type='hidden' name='mode' id='mode' value='popup'><input type='hidden' name='callBack' id='callBack' value=''><input type='hidden' name='RswlClientID' id='RswlClientID' value='r7a4z4'><input type='hidden' name='UseUpdate' id='UseUpdate' value='" + (typeof (rsw_mult_use_update) != 'undefined' ? rsw_mult_use_update : '') + "'>";
																																						 rsw_spellBoot += rsw_getrsw_spellBootString(interfaceObject); rsw_spellBoot += "<scri" + "pt type='text/javascript'>if(navigator.userAgent.indexOf('MSIE') == -1)docu" + "ment.forms[0].submit();</scri" + "pt></form></body></html>";
																																						 } var rsw_spellBoot = rsS60[13]; function rsw_popUpCheckSpelling(interfaceObject, interfaceObjectName) { rsw_createSpellBoot(interfaceObject, interfaceObjectName);
																																						 var sc; if (typeof (rsw_create_popup_window) == rsS60[142]) { sc = rsw_create_popup_window(rsS60[13], rsS60[154], rsS60[155]); } else sc = rs_s2.open(rsS60[13], rsS60[154], rsS60[155]);
																																						 if (!sc) { alert(rsS60[156]); } sc.focus(); if (typeof (rsw_mult_use_update) != rsS60[1] && rsw_mult_use_update) RS_writeDoc(sc.addWordFrame); else RS_writeDoc(sc);
																																						 } function RS_writeDoc(toWindow) { toWindow.document.open(); toWindow.document.write(rsw_spellBoot); toWindow.document.close(); } var checking = false; var rswm_PopUpWin;
																																						 var checkCompleted = true; var currentlyChecking = 0; function rswm_RunSpellCheck(buttonClick, optionalID) { if (typeof (buttonClick) == rsS60[1]) buttonClick = true;
																																						 if (buttonClick) { rsw_setup_SpellControls(optionalID); if (rsw_rapidSpellControls.length == 0) { rswm_NotifyDone(true); return; } } checkComplete = true; if (eval(rsS60[157] + rsw_rapidSpellControls[currentlyChecking] + '_SpellChecker)!="undefined"')) { eval(rsS60[158] + rsw_rapidSpellControls[currentlyChecking] + rsS60[159]);
																																						 if (currentlyChecking == 0) { isOverlayed = false; for (var ch = 0; ch < rsw_rapidSpellControls.length; ch++) { eval(rsS60[160] + rsw_rapidSpellControls[ch] + rsS60[159]);
																																						 if (cs == rsS60[161]) isOverlayed = true; } } if (isOverlayed && curState != rsS60[161]) { rswm_NotifyDone(true); } else { eval(rsw_rapidSpellControls[currentlyChecking] + rsS60[162]);
																																						 } } else { if (buttonClick && rswm_PopUpWin != null && !rswm_PopUpWin.closed) { rswm_PopUpWin.focus(); } else { if (buttonClick) { checking = true; currentlyChecking = 0;
																																						 } if (!(currentlyChecking > 0 && rsTCInt[rsw_rapidSpellControls[currentlyChecking]].getText() == rsS60[13])) { rsw_broadcastEvent(rsS60[163], null, rs_s3.getElementById(rsTCInt[rsw_rapidSpellControls[currentlyChecking]].tbName));
																																						 rsTCInt[rsw_rapidSpellControls[currentlyChecking]].hasRun = true; if (rapidSpell.dialog_modal) { rapidSpell.setParameterValue(rsS60[136], rsS60[55], true); rapidSpell.setParameterValue(rsS60[136], rsS60[45], true);
																																						 rsw_mult_use_update = false; rsw_createSpellBoot(rsTCInt[rsw_rapidSpellControls[currentlyChecking]], rsS60[164] + rsw_rapidSpellControls[currentlyChecking] + rsS60[165]);
																																						 var pair = [window, rsw_spellBoot]; showModalDialog(rsw_modalHelperURL, pair, rsS60[166] + (rapidSpell.dialog_height + 10) + rsS60[167] + (rapidSpell.dialog_width + 5) + rsS60[168] + (rapidSpell.dialog_left >= 0 ? rsS60[169] + rapidSpell.dialog_left + rsS60[170] : rsS60[13]) + (rapidSpell.dialog_top >= 0 ? rsS60[171] + rapidSpell.dialog_top + rsS60[170] : rsS60[13]) + rsS60[172]);
																																						 if (currentlyChecking < rsw_rapidSpellControls.length && checkCompleted) rswm_RunSpellCheck(false); } else{ if (checking && (rswm_PopUpWin == null || rswm_PopUpWin.closed)) { if (typeof (rsw_create_popup_window) == rsS60[142]) { rswm_PopUpWin = rsw_create_popup_window(rsS60[13], rsS60[154], rsS60[173]+rapidSpell.dialog_left+rsS60[174]+rapidSpell.dialog_top+rsS60[175]+rapidSpell.dialog_width+rsS60[176]+rapidSpell.dialog_height);
																																						 } else rswm_PopUpWin = rs_s2.open(rsS60[13], rsS60[154], rsS60[173]+rapidSpell.dialog_left+rsS60[174]+rapidSpell.dialog_top+rsS60[175]+rapidSpell.dialog_width+rsS60[176]+rapidSpell.dialog_height);
																																						 var oldUnload = rs_s2.onunload; rs_s2.onunload = function () { if (typeof (oldUnload) == rsS60[142]) oldUnload(); if (rswm_PopUpWin != null) rswm_PopUpWin.close();
																																						 }; } if (rswm_PopUpWin != null && !rswm_PopUpWin.closed) { rsw_mult_use_update = true && currentlyChecking > 0; rsw_popUpCheckSpelling(rsTCInt[rsw_rapidSpellControls[currentlyChecking]], rsS60[164]+rsw_rapidSpellControls[currentlyChecking]+rsS60[165]);
																																						 rsw_mult_use_update = false; } } } else rswm_NotifyDone(true); } } } function rswm_NotifyDone(spellCheckFinished) { currentlyChecking++; checkCompleted = spellCheckFinished;
																																						 if (rapidSpell.dialog_modal) return; if (currentlyChecking < rsw_rapidSpellControls.length && spellCheckFinished) { rsw_broadcastEvent(rsS60[177], null, rs_s3.getElementById(rsTCInt[rsw_rapidSpellControls[currentlyChecking]].tbName), spellCheckFinished);
																																						 rswm_RunSpellCheck(false); } else { checking = false; if (spellCheckFinished) if (rswm_PopUpWin) rswm_PopUpWin.alert(rsS60[178]); else alert(rsS60[178]); if (rswm_PopUpWin) rswm_PopUpWin.close();
																																						 if (rsw_rapidSpellControls.length > currentlyChecking - 1) { rsw_broadcastEvent(rsS60[177], null, rs_s3.getElementById(rsTCInt[rsw_rapidSpellControls[currentlyChecking - 1]].tbName), spellCheckFinished);
																																						 rsw_broadcastEvent(rsS60[141], null, null, spellCheckFinished); } else { rsw_broadcastEvent(rsS60[177], null, null, spellCheckFinished); rsw_broadcastEvent(rsS60[141], null, null, spellCheckFinished);
																																						 } currentlyChecking = 0; } } function RSAutomaticInterface(tbElementName) { this.tbName = tbElementName; this.getText = getText; this.setText = setText; this.identifyTarget = identifyTarget;
																																						 this.target = null; this.targetContainer = null; this.searchedForTarget = false; this.targetIsPlain = true; this.showNoFindError = showNoFindError; this.finder = null;
																																						 this.findContainer = findContainer; function findContainer() { this.identifyTarget(); return this.targetContainer; } function showNoFindError() { alert(rsS60[14] + this.tbName + rsS60[15]);
																																						 } function identifyTarget() { if (!this.searchedForTarget) { this.searchedForTarget = true; if (this.finder == null) this.finder = new RSW_EditableElementFinder();
																																						 var plain = this.finder.findPlainTargetElement(this.tbName); var richs = this.finder.findRichTargetElements(); if (plain == null && (richs == null || richs.length == 0) && !rsw_suppressWarnings) showNoFindError();
																																						 else { if (richs == null || richs.length == 0) { this.targetIsPlain = true; this.target = plain; this.targetContainer = plain; } else { if (plain == null && richs.length == 1) { this.targetIsPlain = false;
																																						 this.target = this.finder.obtainElementWithInnerHTML(richs[0][0]); this.targetContainer = richs[0][1]; } else { for (var rp = 0; rp < richs.length; rp++) { if (typeof (richs[rp][1].id) != rsS60[1] && richs[rp][1].id.indexOf(this.tbName) > -1) { if (plain != null && richs[rp][1].id == plain.id + rsS60[16]) { this.targetIsPlain = true;
																																						 this.target = plain; this.targetContainer = plain; break; } else { this.targetIsPlain = false; this.target = this.finder.obtainElementWithInnerHTML(richs[rp][0]);
																																						 this.targetContainer = richs[rp][1]; break; } } } if (this.target == null) { this.target = plain; this.targetIsPlain = true; this.targetContainer = plain; } } } } } } function getText() { this.identifyTarget();
																																						 if (this.targetIsPlain) return this.target.value; else return this.target.innerHTML; } function setText(text) { this.identifyTarget(); if (this.targetIsPlain) this.target.value = text;
																																						 else this.target.innerHTML = text; if (typeof (rsw_tbs) != rsS60[1]) { for (var i = 0; i < rsw_tbs.length; i++) { if (rsw_tbs[i].shadowTB.id == this.tbName) { if (rsw_tbs[i].updateIframe) { rsw_tbs[i].updateIframe();
																																						 rsw_tbs[i].focus(); } } } } } } function RSW_EditableElementFinder() { this.findPlainTargetElement = findPlainTargetElement; this.findRichTargetElements = findRichTargetElements;
																																						 this.obtainElementWithInnerHTML = obtainElementWithInnerHTML; this.findEditableElements = findEditableElements; this.elementIsEditable = elementIsEditable; this.getEditableContentDocument = getEditableContentDocument;
																																						 function findPlainTargetElement(elementID) { var rsw_elected = rs_s3.getElementById(elementID); if (rsw_elected != null && rsw_elected.tagName && (rsw_elected.tagName.toUpperCase() == rsS60[17] || rsw_elected.tagName.toUpperCase() == rsS60[18])) { return rsw_elected;
																																						 } else return null; } function findRichTargetElements(debugTextBox) { var editables = new Array(); this.findEditableElements(document, editables, window, rsS60[13], debugTextBox);
																																						 return editables; } function obtainElementWithInnerHTML(editable) { if (typeof (editable.innerHTML) != rsS60[1]) return editable; else if (typeof (editable.documentElement) != rsS60[1]) return editable.documentElement;
																																						 return null; } function findEditableElements(node, editables, parent, debugInset, debugTextBox) { var children = node.childNodes; var editableElement; if (debugTextBox) debugTextBox.value += debugInset + node.tagName;
																																						 if ((editableElement = this.elementIsEditable(node)) != null || (editableElement = this.getEditableContentDocument(node, debugTextBox)) != null ) { if (debugTextBox) debugTextBox.value += rsS60[19];
																																						 editables[editables.length] = editableElement; } if (debugTextBox) debugTextBox.value += rsS60[20]; for (var i = 0; i < children.length; i++) { this.findEditableElements(children[i], editables, node, debugInset + rsS60[21], debugTextBox);
																																						 } } function elementIsEditable(element) { if ( ( typeof (element.getAttribute) != rsS60[1] && ( element.getAttribute(rsS60[22]) == rsS60[23] || element.getAttribute(rsS60[24]) == rsS60[25] ) ) || ( (element.contentEditable && element.contentEditable == true) || (element.designMode && element.designMode.toLowerCase() == rsS60[25]) ) ) return [element, element];
																																						 else return null; } function getEditableContentDocument(element, debugTextBox) { if (element.tagName && element.tagName == rsS60[26]) { var kids = new Array(); if (element.contentWindow && element.contentWindow.document) { if (debugTextBox) debugTextBox.value += rsS60[27];
																																						 this.findEditableElements(element.contentWindow.document, kids, element, rsS60[28], debugTextBox); if (kids.length > 0) { var editable = kids[0][0]; if (typeof (editable.body) != rsS60[1]) editable = editable.body;
																																						 return [editable, element]; } } } return null; } } if (typeof (Sys) != rsS60[1] && typeof (Sys.Application) != rsS60[1]) Sys.Application.notifyScriptLoaded(); 

