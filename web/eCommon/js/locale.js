/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var localeArray = new Array() ;

function getLocale( locale_ref ) {
	var locale = localeArray[locale_ref] ; 
	if ( locale == null ) locale = "00000400" ;
	return locale ; 
}

localeArray["Language Neutral"]                                      = "00000000" ;
localeArray["Process Default Language"]                              = "00000400" ;
localeArray["Afrikaans"]                                             = "00000436" ;
localeArray["Albanian"]                                              = "0000041c" ;
localeArray["Arabic (Saudi Arabia)"]                                 = "00000401" ;
localeArray["Arabic (Iraq)"]                                         = "00000801" ;
localeArray["Arabic (Egypt)"]                                        = "00000c01" ;
localeArray["Arabic (Libya)"]                                        = "00001001" ;
localeArray["Arabic (Algeria)"]                                      = "00001401" ;
localeArray["Arabic (Morocco)"]                                      = "00001801" ;
localeArray["Arabic (Tunisia)"]                                      = "00001c01" ;
localeArray["Arabic (Oman)"]                                         = "00002001" ;
localeArray["Arabic (Yemen)"]                                        = "00002401" ;
localeArray["Arabic (Syria)"]                                        = "00002801" ;
localeArray["Arabic (Jordan)"]                                       = "00002c01" ;
localeArray["Arabic (Lebanon)"]                                      = "00003001" ;
localeArray["Arabic (Kuwait)"]                                       = "00003401" ;
localeArray["Arabic (U.A.E.)"]                                       = "00003801" ;
localeArray["Arabic (Bahrain)"]                                      = "00003c01" ;
localeArray["Arabic (Qatar)"]                                        = "00004001" ;
localeArray["Windows 2000: Armenian. This is Unicode only."]         = "0000042b" ;
localeArray["Windows 2000: Assamese. This is Unicode only."]         = "0000044d" ;
localeArray["Azeri (Latin)"]                                         = "0000042c" ;
localeArray["Azeri (Cyrillic)"]                                      = "0000082c" ;
localeArray["Basque"]                                                = "0000042d" ;
localeArray["Belarussian"]                                           = "00000423" ;
localeArray["Windows 2000: Bengali. This is Unicode only."]          = "00000445" ;
localeArray["Bulgarian"]                                             = "00000402" ;
localeArray["Burmese"]                                               = "00000455" ;
localeArray["Catalan"]                                               = "00000403" ;
localeArray["Chinese (Taiwan)"]                                      = "00000404" ;
localeArray["Chinese (PRC)"]                                         = "00000804" ;
localeArray["Chinese (Hong Kong SAR, PRC)"]                          = "00000c04" ;
localeArray["Chinese (Singapore)"]                                   = "00001004" ;
localeArray["Chinese (Macau SAR)"]                                   = "00001404" ;
localeArray["Croatian"]                                              = "0000041a" ;
localeArray["Czech"]                                                 = "00000405" ;
localeArray["Danish"]                                                = "00000406" ;
localeArray["Dutch (Netherlands)"]                                   = "00000413" ;
localeArray["Dutch (Belgium)"]                                       = "00000813" ;
localeArray["English (United States)"]                               = "00000409" ;
localeArray["English (United Kingdom)"]                              = "00000809" ;
localeArray["English (Australian)"]                                  = "00000c09" ;
localeArray["English (Canadian)"]                                    = "00001009" ;
localeArray["English (New Zealand)"]                                 = "00001409" ;
localeArray["English (Ireland)"]                                     = "00001809" ;
localeArray["English (South Africa)"]                                = "00001c09" ;
localeArray["English (Jamaica)"]                                     = "00002009" ;
localeArray["English (Caribbean)"]                                   = "00002409" ;
localeArray["English (Belize)"]                                      = "00002809" ;
localeArray["English (Trinidad)"]                                    = "00002c09" ;
localeArray["English (Zimbabwe)"]                                    = "00003009" ;
localeArray["English (Philippines)"]                                 = "00003409" ;
localeArray["Estonian"]                                              = "00000425" ;
localeArray["Faeroese"]                                              = "00000438" ;
localeArray["Farsi"]                                                 = "00000429" ;
localeArray["Finnish"]                                               = "0000040b" ;
localeArray["French (Standard)"]                                     = "0000040c" ;
localeArray["French (Belgian)"]                                      = "0000080c" ;
localeArray["French (Canadian)"]                                     = "00000c0c" ;
localeArray["French (Switzerland)"]                                  = "0000100c" ;
localeArray["French (Luxembourg)"]                                   = "0000140c" ;
localeArray["French (Monaco)"]                                       = "0000180c" ;
localeArray["Windows 2000: Georgian. This is Unicode only."]         = "00000437" ;
localeArray["German (Standard)"]                                     = "00000407" ;
localeArray["German (Switzerland)"]                                  = "00000807" ;
localeArray["German (Austria)"]                                      = "00000c07" ;
localeArray["German (Luxembourg)"]                                   = "00001007" ;
localeArray["German (Liechtenstein)"]                                = "00001407" ;
localeArray["Greek"]                                                 = "00000408" ;
localeArray["Windows 2000: Gujarati. This is Unicode only."]         = "00000447" ;
localeArray["Hebrew"]                                                = "0000040d" ;
localeArray["Windows 2000: Hindi. This is Unicode only."]            = "00000439" ;
localeArray["Hungarian"]                                             = "0000040e" ;
localeArray["Icelandic"]                                             = "0000040f" ;
localeArray["Indonesian"]                                            = "00000421" ;
localeArray["Italian (Standard)"]                                    = "00000410" ;
localeArray["Italian (Switzerland)"]                                 = "00000810" ;
localeArray["Japanese"]                                              = "00000411" ;
localeArray["Windows 2000: Kannada. This is Unicode only."]          = "0000044b" ;
localeArray["Kashmiri (India)"]                                      = "00000860" ;
localeArray["Kazakh"]                                                = "0000043f" ;
localeArray["Windows 2000: Konkani. This is Unicode only."]          = "00000457" ;
localeArray["Korean"]                                                = "00000412" ;
localeArray["Korean (Johab)"]                                        = "00000812" ;
localeArray["Latvian"]                                               = "00000426" ;
localeArray["Lithuanian"]                                            = "00000427" ;
localeArray["Lithuanian (Classic)"]                                  = "00000827" ;
localeArray["Macedonian"]                                            = "0000042f" ;
localeArray["Malay (Malaysian)"]                                     = "0000043e" ;
localeArray["Malay (Brunei Darussalam)"]                             = "0000083e" ;
localeArray["Windows 2000: Malayalam. This is Unicode only."]        = "0000044c" ;
localeArray["Manipuri"]                                              = "00000458" ;
localeArray["Windows 2000: Marathi. This is Unicode only."]          = "0000044e" ;
localeArray["Windows 2000: Nepali (India). This is Unicode only."]   = "00000861" ;
localeArray["Norwegian (Bokmal)"]                                    = "00000414" ;
localeArray["Norwegian (Nynorsk)"]                                   = "00000814" ;
localeArray["Windows 2000: Oriya. This is Unicode only."]            = "00000448" ;
localeArray["Polish"]                                                = "00000415" ;
localeArray["Portuguese (Brazil)"]                                   = "00000416" ;
localeArray["Portuguese (Standard)"]                                 = "00000816" ;
localeArray["Windows 2000: Punjabi. This is Unicode only."]          = "00000446" ;
localeArray["Romanian"]                                              = "00000418" ;
localeArray["Russian"]                                               = "00000419" ;
localeArray["Windows 2000: Sanskrit. This is Unicode only."]         = "0000044f" ;
localeArray["Serbian (Cyrillic)"]                                    = "00000c1a" ;
localeArray["Serbian (Latin)"]                                       = "0000081a" ;
localeArray["Sindhi"]                                                = "00000459" ;
localeArray["Slovak"]                                                = "0000041b" ;
localeArray["Slovenian"]                                             = "00000424" ;
localeArray["Spanish (Traditional Sort)"]                            = "0000040a" ;
localeArray["Spanish (Mexican)"]                                     = "0000080a" ;
localeArray["Spanish (Modern Sort)"]                                 = "00000c0a" ;
localeArray["Spanish (Guatemala)"]                                   = "0000100a" ;
localeArray["Spanish (Costa Rica)"]                                  = "0000140a" ;
localeArray["Spanish (Panama)"]                                      = "0000180a" ;
localeArray["Spanish (Dominican Republic)"]                          = "00001c0a" ;
localeArray["Spanish (Venezuela)"]                                   = "0000200a" ;
localeArray["Spanish (Colombia)"]                                    = "0000240a" ;
localeArray["Spanish (Peru)"]                                        = "0000280a" ;
localeArray["Spanish (Argentina)"]                                   = "00002c0a" ;
localeArray["Spanish (Ecuador)"]                                     = "0000300a" ;
localeArray["Spanish (Chile)"]                                       = "0000340a" ;
localeArray["Spanish (Uruguay)"]                                     = "0000380a" ;
localeArray["Spanish (Paraguay)"]                                    = "00003c0a" ;
localeArray["Spanish (Bolivia)"]                                     = "0000400a" ;
localeArray["Spanish (El Salvador)"]                                 = "0000440a" ;
localeArray["Spanish (Honduras)"]                                    = "0000480a" ;
localeArray["Spanish (Nicaragua)"]                                   = "00004c0a" ;
localeArray["Spanish (Puerto Rico)"]                                 = "0000500a" ;
localeArray["Sutu"]                                                  = "00000430" ;
localeArray["Swahili (Kenya)"]                                       = "00000441" ;
localeArray["Swedish"]                                               = "0000041d" ;
localeArray["Swedish (Finland)"]                                     = "0000081d" ;
localeArray["Windows 2000: Tamil. This is Unicode only."]            = "00000449" ;
localeArray["Tatar (Tatarstan)"]                                     = "00000444" ;
localeArray["Windows 2000: Telugu. This is Unicode only."]           = "0000044a" ;
localeArray["Thai"]                                                  = "0000041e" ;
localeArray["Turkish"]                                               = "0000041f" ;
localeArray["Ukrainian"]                                             = "00000422" ;
localeArray["Urdu (Pakistan)"]                                       = "00000420" ;
localeArray["Urdu (India)"]                                          = "00000820" ;
localeArray["Uzbek (Latin)"]                                         = "00000443" ;
localeArray["Uzbek (Cyrillic)"]                                      = "00000843" ;
localeArray["Vietnamese"]                                            = "0000042a" ;
    function loadEnglish() {
        var locale = getLocale( "English (United States)" ) ;
        loadLocale( locale ) ;
    }

    function loadArabic() {
        var locale = getLocale( "Arabic (Saudi Arabia)" ) ;
        loadLocale( locale ) ;
    }

    function loadGerman() {
        var locale = getLocale( "German (Standard)" ) ;
        loadLocale( locale ) ;
    }

    function loadFrench() {
        var locale = getLocale( "French (Standard)" ) ;
        loadLocale( locale ) ;
    }

    function loadLocale( locale ) {
        window.status = locale ;
        document.getElementById("locale").loadLocale( locale ) ;
    }
