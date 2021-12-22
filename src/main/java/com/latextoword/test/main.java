package com.latextoword.test;

import java.util.List;

import com.latextoword.Latex_Word;
import com.latextoword.anal.InitAtom;
import com.latextoword.anal.AtomAnalysis;
import com.latextoword.anal.AtomToOMath;
import com.latextoword.atom.Atom;
import com.latextoword.common.MyJsonUtil;

public class main {
	
	public static void main(String[] args){

		String latex="\\(\\left\\rangle\\frac{\\frac{a}{2}}{b} \\right.\\)";
		String latex1="\\(\\sqrt[3]{2+x}\\)";
		String latex2="\\(\\{\\frac{3-a}{2+x}\\}\\)";
		String latex3="\\(\\frac3{2+x}\\)";
		String latex4="\\({3-a}^{2+x}\\)";
		String latex5="\\(3^x\\)";
		String latex9="\\(3^(x+1)\\)";
		String latex6="\\({3-a}_{2+x^2}\\)";
		String latex7="\\(a_{i,j}\\)";
		String latex8="\\(x+y_2^(4+x)+\\frac{3+\\frac{1}{x}+a+\\frac1x}{2+x}+{3-a}_{2+x^2}+\\sqrt[4]{2+x}\\)";
        String latex10="\\(\\[RR\\]\\qquad\\{A+B+&pound;\\}\\)";
        String latex11="\\(\\begin{vmatrix} x & y \\\\ z & v \\end{vmatrix}\\)";
        String latex12="\\(\\bar{2A}+\\bar{\\frac3{2+x}}\\)";
        String latex13="\\(\\lim_{t\\to n}T+\\theta\\)";
        String latex14="\\(A_{12}^x\\)";
        String latex15="\\(k'(x)=\\lim_{\\Delta x\\to 0}\\frac{k(x)-k(x-\\Delta x)}{\\Delta x\\%}\\)";
        String latex16="\\(AB+\\vec{AB}+\\overrightarrow D+AB-\\ddot{EE}+\\overleftarrow F+\\widehat{YU}+\\overline P+\\overset{RR}\\)";
		String latex17="\\(7+97+997+9997+\\cdots\\underbrace{99\\cdots9}_{10个9}7\\)";
		String latex18="\\(7+97+997+9997+\\cdots\\overbrace{99\\cdots9}^{10个9}7\\)";
		String latex19="\\(\\stackrel{0--1}{\\overbrace{abcd}}\\)";
		String latex20="\\(\\underset{dddd}{\\underbrace{abcd}}\\)";
		String latex21="\\(\\begin{matrix} 5050 \\\\ \\overbrace{ 1+2+\\cdots+100 }\\end{matrix}\\)";
		String latex22="\\(\\underline{FFFFFF}\\)";
		String latex23="\\(\\overparen{FFFFFF}\\)";
		String latex24="\\(ABC\\bf{YYY}EE^\\circ\\)";
		String latex25="\\(f(x)= \\begin{cases}x,x>0 \\\\ 0,x=0 \\\\-x,x<0 \\end{cases}\\)";
		String latex26="\\(\\left.\\dfrac12x^2\\right|_a^b\\)";
		String latex27="\\(\\dfrac12x\\)";
		String latex28="\\(\\int\\nolimits_a^b\\)";
		String latex29="\\(\\sum\\limits_{i=1}^n\\)";
		String latex30="\\(\\sum\\limits^{i=1}_n\\)";
		String latex31="\\(\\begin{pmatrix}a&b\\\\c&d\\end{pmatrix}\\)";
		String latex32="\\(\\begin{bmatrix}a&b\\\\c&d\\end{bmatrix}\\)";
		String latex33="\\(\\begin{Bmatrix}a&b\\\\c&d\\end{Bmatrix}\\)";
		String latex34="\\(\\begin{vmatrix}a&b\\\\c&d\\end{vmatrix}\\)";
		String latex35="\\(\\left(1,\\dfrac12\\right]\\)";
		String latex36="\\(\\begin{array}{1C}f(x) & = A+B+S & a>0;\\\\ & = G+O & b+a<0;\\\\ & = G & d<0;\\end{array}\\)";
		String latex38="\\(37.5^\\circ {\\rm C}\\)";
		String latex39="\\(A\\xleftarrow{x&#160;>&#160;a&times;b&sup3;}B\\xrightarrow[x<0]{x>-2}C\\)";
        String latex40="\\({\\color{Blue}x^2+\\#\\$\\^\\_\\%}+{\\color{Brown}2x}-{\\color{OliveGreen}1}\\)";
        String latex41="\\(R\\&amp;D\\)";
		String latex42="\\(\\left\\{ \\begin{array}{*{35}{l}}   2k+b=3  \\\\<br>   -k+b=0  \\\\ \\end{array} \\right.\\)";
		String latex43="\\(90^{\\circ}\\)";
		String latex44="\\(f(x)= \\begin{cases} \\overset{x^{2},x\\in D}{x,x\\notin D}\\end{cases}\\)";//##
		String latex45="\\(|f(x)|_{max}\\leqslant |a^{2}-a+2|_{min}\\)";
		String latex46="\\(\\overrightarrow{GN}^{2}\\)";//##
		String latex47="\\({3{x}^2}\\)";//##
		String latex48="\\(\\sqrt{a^2+\\left(\\dfrac{3}{2}a\\right)^{2}}\\)";//##
		String latex49="\\(\\left(b+a\\right)^{2}\\)";//##
		String latex491="\\(\\left(\\dfrac{3}{2}+a\\right]\\)";//##
		//String latex48="\\(\\left(b+a\\right)^{2}\\)";//##
		String latex481="\\({\\left[B+a\\right)^{2}}\\)";//#
        String latex421="\\(\\left\\{\\begin{array}  2k+b=3\\end{array}\\right.\\)";
        String latex422="\\(\\begin{array}   2k+b=3\\end{array}\\)";

        String latex482="\\(\\over{3\\pi}{4}+AC\\)";//#
        String latex483="\\((2\\overrightarrow{a}+\\overrightarrow{b})\\cdot(\\overrightarrow{a}+\\overrightarrow{b})=2\\overrightarrow{a}^2+3\\overrightarrow{a}\\cdot\\overrightarrow{b}+\\overrightarrow{b}^2=2+3\\overrightarrow{a}\\cdot\\overrightarrow{b}+1=3\\)";
		//String latex48="\\(\\sqrt{\\left(\\dfrac{1}{2}a\\right)^{2}+\\left(\\dfrac{3}{2}a\\right)^{2}}\\)";//##
		String latex50="\\( \\begin{bmatrix} a &amp; 0 \\\\ 0 &amp; b\\end{bmatrix} \\begin{bmatrix} \\overset{x}{y}\\end{bmatrix}═ \\begin{bmatrix} \\overset{x{{'}}}{y{{'}}}\\end{bmatrix}\\)";//
        String latex51="\\(\\begin{bmatrix} a &amp; 0 \\\\ 0 &amp; b \\\\ \\end{bmatrix}\\)";
        String latex52="\\( \\begin{cases}  x+y+11+9=40 \\\\  \\frac {1}{4}[(x-10)^{2}+(y-10)^{2}+1^{2}+(-1)^{2}]=2\\end{cases}\\)";
		String latex53="\\( \\frac {S_{\\text{圆}}}{S_{\\text{正方形}}}\\)";

		String latex54="\\(f(x)= \\begin{cases}  x^{2}e^{x}，x≤1 \\\\ lnx- \\sqrt {-x^{2}+2x}，x＞1\\end{cases}\\)";
		String latex55="\\(f(x)= \\begin{cases}  x^{2}e^{x}，x≤1 \\\\ lnx- \\sqrt {-x^{2}+2x}，x＞1\\end{cases}\\)";
		String latex56="\\(\\begin{cases}\\begin{matrix}x-y\\leqslant 0 \\\\ x+y-4\\leqslant 0\\end{matrix} \\\\ x-1\\geqslant 0\\end{cases} \\)";
        String latex57="\\( \\begin{cases}  \\overset{x=-2+tcos\\alpha }{y=4+tsin\\alpha }\\end{cases}\\)";
        String latex58="\\(\\dfrac{n{\\left(ad-bc\\right)}^{2}}{\\left(a+b\\right)\\left(c+d\\right)\\left(a+c\\right)\\left(b+d\\right)}\\)";
        String latex59="\\(\\left(ad-bc\\right)\\)";
        String latex60="\\({\\left(ad-bc\\right)}^{2}\\)";
        String latex62="\\(2{{\\text{S}}_{2}}\\text{O}_{3}^{2-}+{{\\text{I}}_{2}}={{\\text{S}}_{4}}\\text{O}_{6}^{2-}+2{{\\text{I}}^{-}}\\)";
        String latex63="\\(\\begin{split}9&amp;=1\\times9\\\\108&amp;=12\\times9\\\\1107&amp;=123\\times9\\\\11106&amp;=1234\\times9\\\\111105&amp;=12345\\times9\\\\?&amp;=123456\\times9\\\\?&amp;=1234567\\times9\\\\?&amp;=12345678\\times9\\\\?&amp;=123456789\\times9\\end{split}\\)";
        String latex64="\\(\\begin{cases} \\overrightarrow {n}\\cdot \\overrightarrow {BC}=0 & \\\\ \\overrightarrow {n}\\cdot \\overrightarrow {BF}=0 & \\end{cases}\\)";
        String latex66="\\( \\left\\{ 0,x > 0 \\\\  \\pi ,x = 0 \\\\  {\\pi ^2} + 1,x < 0 \\\\  \\beta <0 \\right.\\)";
        String latex67="\\({\\rm N}^   *\\)";
        String latex68="\\(f(x) = \\left\\{ \\begin{gathered} {3^x}(0 < x < 1) \\hfill \\\\ \\left| {x - 3} \\right| + 1(x \\geqslant 1) \\hfill \\\\ \\end{gathered} \\right.\\)";
		String latex69="\\(\\left\\{\\begin{gathered}\\left| {x - 3} \\right|\\end{gathered}\\right.\\)";
		String latex70="\\(\\left| \\left. \\dfrac{1}{3}a+ \\dfrac{1}{6}b \\right. \\right|\\)";
		String latex72="\\(x = {-b \\pm \\sqrt{b^2-4ac} \\over 2a}.\\)";
		String latex71="\\({\\pm t \\over 2a+ 1}\\)";
		String latex73="\\(A = {\\rm{\\{ }}x \\in R|a{x^2} + ax + 1 = 0{\\rm{\\} }}\\)";
        String latex76="\\(P=(\\dfrac{E}{R+r}{{\\text{)}}^{2}}R=(\\dfrac{0.975}{2500+478}{{\\text{)}}^{2}}\\times 2500\\text{W=}2.68\\times {{10}^{-4}}\\text{W=}0.268\\text{mW}\\)";
        String latex74="\\(\\rm{\\text{Zn+}\\text{4O}{{\\text{H}}^{\\text{-}}-2e^{\\text{-}}=Zn}\\left( \\text{OH} \\right)_{\\text{4}}^{\\text{2-}}}\\)";
        String latex741="\\(\\begin{align}\\dfrac{1}{7}+x&=\\dfrac{5}{6}\\\\x&=\\dfrac{5}{6}-\\dfrac{1}{7}\\\\x&=\\dfrac{29}{42}\\end{align}\\)";
        String latex75="\\(\\begin{split}&\\rm 2Na+2H_2O=\\; 2&\\rm Na\\rm OH+&\\rm H_2\\\\&46\\qquad\\quad &80&2\\\\&2.3\\rm g&\\rm X&\\rm Y\\end{split}\\)";
        String latex77="\\(\\overset\\frown{DO}=2\\theta \\times \\sqrt{3}=2\\sqrt{3}\\theta\\)";
        String latex781="\\(b_n=\\left\\{\\begin{matrix} 0,1\\leq n&lt;10\\\\1,10\\leq n&lt;100 \\\\2,100\\leq n&lt;1000 \\\\ 3,n=1000 \\end{matrix}\\right.\\)";
        String latex782="\\(S\\left ( t \\right )=\\left\\{\\begin{matrix} -4t\\left ( t-13 \\right ),0\\leq t\\leq 3\\\\ 168,3&lt; t\\leq 6 \\\\ 60t-192,6&lt; t\\leq 8.8 \\end{matrix}\\right.\\)";
        String latex783="\\(\\left\\{\\begin{matrix} -4t\\left ( AAA \\right ) \\end{matrix}\\right.\\)";
        String latex784="\\(（\\frac{2}{3}）^{\\frac{1}{2}}\\times+2^{\\frac{3}{4}}\\times2^{\\frac{1}{4}}+(2^{\\frac{1}{3}}\\times3^{\\frac{1}{2}})^6-(\\frac{2}{3})^{\\frac{2}{3}\\times\\frac{1}{2}}\\)";
        String latex78="\\(\\begin{matrix} -4t+8 \\end{matrix}\\)";
        String latex791="\\(\\left(\\sqrt{x} )^{5-r}\\cdot\\dfrac{a}{\\sqrt[3]{x}}\\right)^{r}\\)";
        String latex79="\\(\\left(\\sqrt{x} )^{5-r}\\cdot\\dfrac{a}{\\sqrt[3]{x}}\\right)^{r}\\)";
        String latex792="\\(\\rm{4N{{H}_{3}}+5{{O}_{2}}\\underset{加热}{\\overset{催化剂}{\\mathop{=}}}\\,4NO+6{{H}_{2}}O}\\)";
		String latex80="\\(x^\\dfrac{1}{2}\\)";
		String latex83="\\(A+\\dfrac{1}{2}\\)";
		String latex82="\\(\\overset\\frown{AB}\\)";
		String latex811="${\\rm Rt}\\triangle BOD\\overset{\\Large∽}{=} {\\rm Rt}\\triangle COE$";
		String latex81="$\\boxed{9}$";
		String latex812="$\\diamondsuit +3434$";
		String latex813="$\\left\\{(x,y)\\left| \\begin{cases}x+y-2=0\\\\x-2y+4=0\\end{cases} \\right\\} \\right.⊆\\{(x,y)|y=3x+c\\}$";//问题
		String latex84="$\\int_{0}^{1}\\left ( \\sqrt{x} -x\\right )dx= \\left ( \\frac{2}{3}x^\\frac{3}{2}-\\frac{x^{2}}{2} \\right )|_{0}^{1}= \\frac{1}{6}$";
        String latex85="$= \\dfrac {1}{ \\sqrt {17}}\\left|4\\left(x_{0}- \\dfrac {1}{2}\\right)^{2}+1\\right|$";
        String latex86="$\\left(4 \\right)\\left| s \\right.$";
        String latex87="$x^\\frac{3}{2}$";
        String latex88="$=\\left(x- \\dfrac {1}{3}x^{3}\\right)\\left| \\begin{matrix} {}^{1} \\\\ {}_{0}\\\\ \\end{matrix} \\right.+\\left(\\dfrac {1}{3}x^{3}-x\\right)\\left| \\begin{matrix} {}^{2} \\\\ {}_{1}\\\\ \\end{matrix} \\right.$";
        String latex89="$=\\left| \\begin{matrix} {}^{2} \\\\ {}_{1}\\\\ \\end{matrix} \\right.$";
        String latex90="$\\sqrt{\\begin{vmatrix}\\overrightarrow{AB}\\\\\\end{vmatrix}^{2}}$";//问题1
        String latex91="$f(x)=\\left\\{\\begin{matrix}\\left(\\dfrac{1}{2}\\right)^{x},&x\\geqslant 3\\\\f(x+1),&x<3\\\\\\end{matrix}\\right. $";
        String latex92="$N=\\left\\{x\\left|\\left( \\dfrac {1}{2}\\right)^{x}\\leqslant 4\\right.\\right\\}$";//问题3
        String latex93="d= \\dfrac {|x-x^{2}-2|}{ \\sqrt {2}}= \\dfrac {\\left |\\left (x- \\dfrac {1}{2}\\right )^{2}+ \\dfrac {7}{4}\\right |}{ \\sqrt {2}}\\geqslant \\dfrac {7 \\sqrt {2}}{8}";
        String latex94="$A=\\left\\{x\\left|\\left( \\dfrac {1}{3}\\right)^{x^{2}-x-6}\\leqslant 1\\right.\\right\\}\\)，\\(B=\\{x|\\log _{3}(x+a)\\geqslant 1\\}$";
        String latex95="$d= \\dfrac { \\sqrt {6}}{30}\\times\\left|{\\left(t+ \\dfrac { \\sqrt {6}}{2}\\right)}^{2}- \\dfrac {75}{2}\\right|$";
        String latex96="=\\left|\\left(y- \\dfrac {1}{2}\\right)^{2}+\\left(x+ \\dfrac {1}{x}\\right)- \\dfrac {1}{4}\\right|";
        String latex97="$\\left\\{A+\\dfrac{1}{3}\\right.^{2}$";
        String latex98="$\\left\\vert \\dfrac{3-\\rm i}{1+2\\rm i}\\right\\vert$";
        String latex99="$\\left\\vert 2353 \\right\\vert$";
        String latex100="\\\\left[ ]*(\\\\([a-zA-Z]+|[\\W\\S])|[\\W\\S])" +
				        "\\\\right[ ]*(\\\\([a-zA-Z]+|[\\W\\S])|[\\W\\S])" +
						"\\\\begin[ ]*\\{[a-zA-Z]+\\}" +
						"\\\\end[ ]*\\{[a-zA-Z]+\\}";

        String latex101="\\left\\{x\\left|\\left( A\\right) B \\right.\\right\\}";
        String latex102="$\\left|\\frac{\\left(\\text{-}\\frac{1}{2}\\text{,}\\frac{\\sqrt{3}}{2}\\text{,-}1\\right)\\text{·}\\left(0\\text{,}\\frac{\\sqrt{3}}{2}\\text{,}0\\right)}{\\sqrt{2}\\times \\frac{\\sqrt{3}}{2}}\\right| $";
        String latex103="$A\\rightarrow C\\rightarrow B$";
        String latex104="$\\left | 3x_{0} +4\\left ( 3x_{0}+3 \\right )-17\\right |$";
        String latex1051="$\\begin{cases}{y}_{C}=2{x}_{C}+1\\\\{{x}_{C}}^{2}+4{{y}_{C}}^{2}=4\\end{cases}$";

		String latex105="$f(x)=|\\ln x|-a^x(x\\gt 0,0\\lt a\\lt 1)$";
		String latex106="$f(x)=|\\ln x|-a^x(x\\gt 0,0\\lt a\\lt 1)$";

		String latex107="$y=\\begin{cases}3x^{2}-2&x\\lt 0\\\\{{\\rm e}}^{x}&x\\geqslant 0\\end{cases}$";
		String latex108="$y=\\begin{cases}3x^{2}-2&x\\lt 0\\\\{\\rm e}^{x}&x\\geqslant 0\\end{cases}$";
		String latex109="$y=\\begin{cases} 3x^{2}-2 & x\\lt 0\\\\ {\\rm e}^{x} & x \\geqslant 0 \\end{cases}$";
        String latex110 ="$1+\\frac{1}{3}+\\frac{1}{5}+\\frac{1}{7}+\\cdots+\\frac{1}{21}$";
        String latex111 ="\\mathbb{又} \\because 5 m^{2}&gt;0, \\therefore(*)";
        String latex112 ="$\\{x\\mathrel{|} \\log _{}x\\lt 2\\}$";

		System.out.println("-----------------start!---------------------");
		latex=latex112.replace("$", "");

		List<Atom> atoms=InitAtom.latexIntoAtomAll(latex);//层级块级化结构
		System.out.println(MyJsonUtil.toJson(atoms));
		System.out.println("-----------------atomToOMath!---------------------");
		AtomAnalysis atomAnalysis=new AtomAnalysis();
		String message=atomAnalysis.atomListToOMathAtomList(atoms);//块级结构化
		System.out.println(message);
		System.out.println(MyJsonUtil.toJson(atoms));
		System.out.println("-----------------atomToOMathStr!---------------------");
		AtomToOMath atomToOMath = new AtomToOMath();
		String oMathStr=atomToOMath.atomToOMathStrMain(atoms);//拼接oMath结构
		System.out.println(oMathStr);
		if(Latex_Word.checkOmmlFormat(oMathStr)){
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
	}
	
	

}
