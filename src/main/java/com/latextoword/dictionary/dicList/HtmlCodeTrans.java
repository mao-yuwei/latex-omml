package com.latextoword.dictionary.dicList;

import java.util.Hashtable;

/**
 * @Author: maoyuwei
 * @Date: 2019/4/15 19:13
 * @Desc: html特殊符号转换
 **/
public class HtmlCodeTrans {

       private HtmlCodeTrans(){};

       private static Hashtable<String,String> htmlCodeDic;

       private static volatile HtmlCodeTrans htmlCodeTrans;

       public static Hashtable<String,String> getHtmlCodeDic(){
           if(htmlCodeTrans!=null) return HtmlCodeTrans.htmlCodeDic;
           synchronized (HtmlCodeTrans.class){
                 if(htmlCodeTrans==null){
                     inithtmlCodeDic();
                     return HtmlCodeTrans.htmlCodeDic;
                 }
           }
           return HtmlCodeTrans.htmlCodeDic;
       }

       private static HtmlCodeTrans inithtmlCodeDic(){
           htmlCodeTrans=new HtmlCodeTrans();
           htmlCodeDic=new Hashtable<String,String>();
           htmlCodeDic.put("&nbsp;","&#160;");
           htmlCodeDic.put("&lt;","&#60;");
           htmlCodeDic.put("&gt;","&#62;");
           htmlCodeDic.put("&amp;","&#38;");
           htmlCodeDic.put("&quot;","&#34;");
           htmlCodeDic.put("&apos;","&#39;");
           htmlCodeDic.put("&cent;","&#162;");
           htmlCodeDic.put("&pound;","&#163;");
           htmlCodeDic.put("&yen;","&#165;");
           htmlCodeDic.put("&euro;","&#8364;");
           htmlCodeDic.put("&sect;","&#167;");
           htmlCodeDic.put("&copy;","&#169;");
           htmlCodeDic.put("&reg;","&#174;");
           htmlCodeDic.put("&trade;","&#8482;");
           htmlCodeDic.put("&times;","&#215;");
           htmlCodeDic.put("&divide;","&#247;");
           htmlCodeDic.put("&ensp;","&#160;");
           htmlCodeDic.put("&emsp;","&#160;");
           htmlCodeDic.put("&Alpha;","&#913;");
           htmlCodeDic.put("&Gamma;","&#915;");
           htmlCodeDic.put("&Epsilon;","&#917;");
           htmlCodeDic.put("&Eta;","&#919;");
           htmlCodeDic.put("&Iota;","&#921;");
           htmlCodeDic.put("&Lambda;","&#923;");
           htmlCodeDic.put("&Nu;","&#925;");
           htmlCodeDic.put("&Omicron;","&#927;");
           htmlCodeDic.put("&Rho;","&#929;");
           htmlCodeDic.put("&Tau;","&#932;");
           htmlCodeDic.put("&Phi;","&#934;");
           htmlCodeDic.put("&Psi;","&#936;");
           htmlCodeDic.put("&alpha;","&#945;");
           htmlCodeDic.put("&gamma;","&#947;");
           htmlCodeDic.put("&epsilon;","&#949;");
           htmlCodeDic.put("&eta;","&#951;");
           htmlCodeDic.put("&iota;","&#953;");
           htmlCodeDic.put("&lambda;","&#955;");
           htmlCodeDic.put("&nu;","&#957;");
           htmlCodeDic.put("&omicron;","&#959;");
           htmlCodeDic.put("&rho;","&#961;");
           htmlCodeDic.put("&sigma;","&#963;");
           htmlCodeDic.put("&upsilon;","&#965;");
           htmlCodeDic.put("&chi;","&#967;");
           htmlCodeDic.put("&omega;","&#969;");
           htmlCodeDic.put("&upsih;","&#978;");
           htmlCodeDic.put("&bull;","&#8226;");
           htmlCodeDic.put("&prime;","&#8242;");
           htmlCodeDic.put("&oline;","&#8254;");
           htmlCodeDic.put("&weierp;","&#8472;");
           htmlCodeDic.put("&real;","&#8476;");
           htmlCodeDic.put("&alefsym;","&#8501;");
           htmlCodeDic.put("&uarr;","&#8593;");
           htmlCodeDic.put("&darr;","&#8595;");
           htmlCodeDic.put("&crarr;","&#8629;");
           htmlCodeDic.put("&uArr;","&#8657;");
           htmlCodeDic.put("&dArr;","&#8659;");
           htmlCodeDic.put("&forall;","&#8704;");
           htmlCodeDic.put("&exist;","&#8707;");
           htmlCodeDic.put("&nabla;","&#8711;");
           htmlCodeDic.put("&notin;","&#8713;");
           htmlCodeDic.put("&prod;","&#8719;");
           htmlCodeDic.put("&minus;","&#8722;");
           htmlCodeDic.put("&radic;","&#8730;");
           htmlCodeDic.put("&infin;","&#8734;");
           htmlCodeDic.put("&and;","&#8869;");
           htmlCodeDic.put("&cap;","&#8745;");
           htmlCodeDic.put("&int;","&#8747;");
           htmlCodeDic.put("&sim;","&#8764;");
           htmlCodeDic.put("&asymp;","&#8773;");
           htmlCodeDic.put("&equiv;","&#8801;");
           htmlCodeDic.put("&ge;","&#8805;");
           htmlCodeDic.put("&sup;","&#8835;");
           htmlCodeDic.put("&sube;","&#8838;");
           htmlCodeDic.put("&oplus;","&#8853;");
           htmlCodeDic.put("&perp;","&#8869;");
           htmlCodeDic.put("&lceil;","&#8968;");
           htmlCodeDic.put("&lfloor;","&#8970;");
           htmlCodeDic.put("&loz;","&#9674;");
           htmlCodeDic.put("&clubs;","&#9827;");
           htmlCodeDic.put("&diams;","&#9830;");
           htmlCodeDic.put("&iexcl;","&#161;");
           htmlCodeDic.put("&pound;","&#163;");
           htmlCodeDic.put("&yen;","&#165;");
           htmlCodeDic.put("&sect;","&#167;");
           htmlCodeDic.put("&copy;","&#169;");
           htmlCodeDic.put("&laquo;","&#171;");
           htmlCodeDic.put("&shy;","&#173;");
           htmlCodeDic.put("&macr;","&#175;");
           htmlCodeDic.put("&plusmn;","&#177;");
           htmlCodeDic.put("&sup3;","&#179;");
           htmlCodeDic.put("&micro;","&#181;");
           htmlCodeDic.put("&Beta;","&#914;");
           htmlCodeDic.put("&Delta;","&#916;");
           htmlCodeDic.put("&Zeta;","&#918;");
           htmlCodeDic.put("&Theta;","&#920;");
           htmlCodeDic.put("&Kappa;","&#922;");
           htmlCodeDic.put("&Mu;","&#924;");
           htmlCodeDic.put("&Xi;","&#926;");
           htmlCodeDic.put("&Pi;","&#928;");
           htmlCodeDic.put("&Sigma;","&#931;");
           htmlCodeDic.put("&Upsilon;","&#933;");
           htmlCodeDic.put("&Chi;","&#935;");
           htmlCodeDic.put("&Omega;","&#937;");
           htmlCodeDic.put("&beta;","&#946;");
           htmlCodeDic.put("&delta;","&#948;");
           htmlCodeDic.put("&zeta;","&#950;");
           htmlCodeDic.put("&theta;","&#952;");
           htmlCodeDic.put("&kappa;","&#954;");
           htmlCodeDic.put("&mu;","&#956;");
           htmlCodeDic.put("&xi;","&#958;");
           htmlCodeDic.put("&pi;","&#960;");
           htmlCodeDic.put("&sigmaf;","&#962;");
           htmlCodeDic.put("&tau;","&#964;");
           htmlCodeDic.put("&phi;","&#966;");
           htmlCodeDic.put("&psi;","&#968;");
           htmlCodeDic.put("&thetasym;","&#977;");
           htmlCodeDic.put("&piv;","&#982;");
           htmlCodeDic.put("&hellip;","&#8230;");
           htmlCodeDic.put("&Prime;","&#8243;");
           htmlCodeDic.put("&frasl;","&#8260;");
           htmlCodeDic.put("&image;","&#8465;");
           htmlCodeDic.put("&trade;","&#8482;");
           htmlCodeDic.put("&larr;","&#8592;");
           htmlCodeDic.put("&rarr;","&#8594;");
           htmlCodeDic.put("&harr;","&#8596;");
           htmlCodeDic.put("&lArr;","&#8656;");
           htmlCodeDic.put("&rArr;","&#8658;");
           htmlCodeDic.put("&hArr;","&#8660;");
           htmlCodeDic.put("&part;","&#8706;");
           htmlCodeDic.put("&empty;","&#8709;");
           htmlCodeDic.put("&isin;","&#8712;");
           htmlCodeDic.put("&ni;","&#8715;");
           htmlCodeDic.put("&sum;","&#8722;");
           htmlCodeDic.put("&lowast;","&#8727;");
           htmlCodeDic.put("&prop;","&#8733;");
           htmlCodeDic.put("&ang;","&#8736;");
           htmlCodeDic.put("&or;","&#8870;");
           htmlCodeDic.put("&cup;","&#8746;");
           htmlCodeDic.put("&there4;","&#8756;");
           htmlCodeDic.put("&cong;","&#8773;");
           htmlCodeDic.put("&ne;","&#8800;");
           htmlCodeDic.put("&le;","&#8804;");
           htmlCodeDic.put("&sub;","&#8834;");
           htmlCodeDic.put("&nsub;","&#8836;");
           htmlCodeDic.put("&supe;","&#8839;");
           htmlCodeDic.put("&otimes;","&#8855;");
           htmlCodeDic.put("&sdot;","&#8901;");
           htmlCodeDic.put("&rceil;","&#8969;");
           htmlCodeDic.put("&rfloor;","&#8971;");
           htmlCodeDic.put("&spades;","&#9824;");
           htmlCodeDic.put("&hearts;","&#9829;");
           htmlCodeDic.put("&nbsp;","&#160;");
           htmlCodeDic.put("&cent;","&#162;");
           htmlCodeDic.put("&curren;","&#164;");
           htmlCodeDic.put("&brvbar;","&#166;");
           htmlCodeDic.put("&uml;","&#168;");
           htmlCodeDic.put("&ordf;","&#170;");
           htmlCodeDic.put("&not;","&#172;");
           htmlCodeDic.put("&reg;","&#174;");
           htmlCodeDic.put("&deg;","&#176;");
           htmlCodeDic.put("&sup2;","&#178;");
           htmlCodeDic.put("&acute;","&#180;");
           htmlCodeDic.put("&middot;","·");
           htmlCodeDic.put("&oslash;","ø");
           htmlCodeDic.put("&aacute;","á");
          return htmlCodeTrans;
       }

}
