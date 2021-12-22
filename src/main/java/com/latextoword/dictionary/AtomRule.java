package com.latextoword.dictionary;
//元素具有的格式规则

import com.latextoword.atom.Atom;
import com.latextoword.atom.AtomBE;

import java.util.Arrays;

public enum AtomRule {
	CFRAC(7,"\\cfrac",new Atom(7,"\\cfrac","{",new Atom(),"}",1,"{",new Atom(),"}",1),1,0,0,0,OMathRule.CFRAC),
	OVER(8,"\\over",new Atom(11,"\\over","{",new Atom(),"}",1,"{",new Atom(),"}",1),-99,0,0,0,OMathRule.OVER),
    DFRAC(9,"\\dfrac",new Atom(9,"\\dfrac","{",new Atom(),"}",1,"{",new Atom(),"}",1),1,0,0,0,OMathRule.DFRAC),
	SQRT(10,"\\sqrt",new Atom(10,"\\sqrt","[",new Atom(),"]",0,"{",new Atom(),"}",1),1,0,0,0,OMathRule.SQRT),
	FRAC(11,"\\frac",new Atom(11,"\\frac","{",new Atom(),"}",1,"{",new Atom(),"}",1),1,0,0,0,OMathRule.FRAC),
    BEGIN(12,"\\begin",new Atom(12,"\\begin","{",new Atom(),"}",0,1),1,1,7,1,OMathRule.BEGIN),
    END(13,"\\end",new Atom(13,"\\end","{",new Atom(),"}",0,1),1,2,7,4,OMathRule.END),
    QQUAD(14,"\\qquad",new Atom(14,"\\qquad"),0,0,0,0,OMathRule.QQUAD),
    QUAD(15,"\\quad",new Atom(15,"\\quad"),0,0,0,0,OMathRule.QUAD),
    ONESPACE(16,"\\ ",new Atom(16,"\\ "),0,0,0,0,OMathRule.ONESPACE),
    MIDDLESPACE(17,"\\;",new Atom(17,"\\;"),0,0,0,0,OMathRule.MIDDLESPACE),
    SMALLSPACE(18,"\\,",new Atom(18,"\\,"),0,0,0,0,OMathRule.SMALLSPACE),
    CLOSESPACE(19,"\\!",new Atom(19,"\\!"),0,0,0,0,OMathRule.CLOSESPACE),
	LEFT(20,"\\left",new Atom(20,"\\left", Arrays.asList(new AtomBE(1,3))),1,1,20,1,OMathRule.LEFT),
	RIGHT(21,"\\right",new Atom(21,"\\right",Arrays.asList(new AtomBE(1,3))),1,2,20,2,OMathRule.RIGHT),
	BRACES_BEGIN(22,"\\{",new Atom(22,"\\{"),0,0,0,0,OMathRule.BRACES_BEGIN),
	BRACES_END(23,"\\}",new Atom(23,"\\}"),0,0,0,0,OMathRule.BRACES_END),
	SQARE_BRACKET_BEGIN(24,"\\[",new Atom(24,"\\["),0,0,0,0,OMathRule.SQARE_BRACKET_BEGIN),
	SQARE_BRACKET_END(25,"\\]",new Atom(15,"\\]"),0,0,0,0,OMathRule.SQARE_BRACKET_END),
	BRACKET_BEGIN(26,"\\(",new Atom(26,"\\)"),0,0,0,0,OMathRule.BRACKET_BEGIN),
	BRACKET_END(27,"\\)",new Atom(27,"\\)"),0,0,0,0,OMathRule.BRACKET_END),
	BAR(28,"\\bar",new Atom(28,"\\bar","{",new Atom(),"}",1),1,0,0,0,OMathRule.BAR),
	DOT(29,"\\dot",new Atom(29,"\\dot","{",new Atom(),"}",1),1,0,0,0,OMathRule.DOT),
	SIN(30,"\\sin",new Atom(30,"\\sin"),0,0,0,0,OMathRule.SIN),
	COS(31,"\\cos",new Atom(31,"\\cos"),0,0,0,0,OMathRule.COS),
	TAN(32,"\\tan",new Atom(32,"\\tan"),0,0,0,0,OMathRule.TAN),
	LOG(33,"\\log",new Atom(33,"\\log"),0,0,0,0,OMathRule.LOG),


	THETA(34,"\\theta",new Atom(34,"\\theta"),0,0,0,0,OMathRule.THETA),
	ALPHA(35,"\\alpha",new Atom(35,"\\alpha"),0,0,0,0,OMathRule.ALPHA),
	ETA(36,"\\eta",new Atom(36,"\\eta"),0,0,0,0,OMathRule.ETA),
	GAMMA(37,"\\gamma",new Atom(37,"\\gamma"),0,0,0,0,OMathRule.GAMMA),
	DELTA(38,"\\delta",new Atom(38,"\\delta"),0,0,0,0,OMathRule.DELTA),
	PHI(39,"\\phi",new Atom(39,"\\phi"),0,0,0,0,OMathRule.PHI),
	P_HI(40,"\\Phi",new Atom(40,"\\Phi"),0,0,0,0,OMathRule.P_HI),
	SIGMA(41,"\\sigma",new Atom(41,"\\sigma"),0,0,0,0,OMathRule.SIGMA),
	S_IGMA(42,"\\Sigma",new Atom(42,"\\Sigma"),0,0,0,0,OMathRule.S_IGMA),
	VARPHI(43,"\\varphi",new Atom(43,"\\varphi"),0,0,0,0,OMathRule.VARPHI),
	PARTIAL(44,"\\partial",new Atom(44,"\\partial"),0,0,0,0,OMathRule.PARTIAL),
	INFTY(45,"\\infty",new Atom(45,"\\infty"),0,0,0,0,OMathRule.INFTY),
	NEQ(46,"\\neq",new Atom(46,"\\neq"),0,0,0,0,OMathRule.NEQ),
	NE(47,"\\ne",new Atom(46,"\\ne"),0,0,0,0,OMathRule.NE),
	PM(48,"\\pm",new Atom(48,"\\pm"),0,0,0,0,OMathRule.PM),
	APPROX(49,"\\approx",new Atom(49,"\\approx"),0,0,0,0,OMathRule.APPROX),
	BETA(50,"\\beta",new Atom(50,"\\beta"),0,0,0,0,OMathRule.BETA),
	VAREPSILON(51,"\\varepsilon",new Atom(51,"\\varepsilon"),0,0,0,0,OMathRule.VAREPSILON),
	EPSILON(52,"\\epsilon",new Atom(52,"\\epsilon"),0,0,0,0,OMathRule.EPSILON),
	MU(53,"\\mu",new Atom(53,"\\mu"),0,0,0,0,OMathRule.MU),
	OMEGA(54,"\\omega",new Atom(54,"\\omega"),0,0,0,0,OMathRule.OMEGA),
	PI(55,"\\pi",new Atom(55,"\\pi"),0,0,0,0,OMathRule.PI),
	TIMES(56,"\\times",new Atom(56,"\\times"),0,0,0,0,OMathRule.TIMES),
	DIV(57,"\\div",new Atom(57,"\\div"),0,0,0,0,OMathRule.DIV),
	PROPTO(58,"\\propto",new Atom(58,"\\propto"),0,0,0,0,OMathRule.PROPTO),
	LE(59,"\\le",new Atom(59,"\\le"),0,0,0,0,OMathRule.LE),
	LEQ(60,"\\leq",new Atom(60,"\\leq"),0,0,0,0,OMathRule.LEQ),
	GE(61,"\\ge",new Atom(61,"\\ge"),0,0,0,0,OMathRule.GE),
	FORALL(62,"\\forall",new Atom(62,"\\forall"),0,0,0,0,OMathRule.FORALL),
	EXISTS(63,"\\exists",new Atom(63,"\\exists"),0,0,0,0,OMathRule.EXISTS),
	IN(64,"\\in",new Atom(64,"\\in"),0,0,0,0,OMathRule.IN),
	NI(65,"\\ni",new Atom(65,"\\ni"),0,0,0,0,OMathRule.NI),
	CUP(66,"\\cup",new Atom(66,"\\cup"),0,0,0,0,OMathRule.CUP),
	CAP(67,"\\cap",new Atom(67,"\\cap"),0,0,0,0,OMathRule.CAP),
	THEREFORE(56,"\\therefore",new Atom(56,"\\therefore"),0,0,0,0,OMathRule.THEREFORE),
	BECAUSE(57,"\\because",new Atom(57,"\\because"),0,0,0,0,OMathRule.BECAUSE),
	COT(58,"\\cot",new Atom(58,"\\cot"),0,0,0,0,OMathRule.COT),
	SEC(59,"\\sec",new Atom(59,"\\sec"),0,0,0,0,OMathRule.SEC),
	XI(60,"\\xi",new Atom(60,"\\xi"),0,0,0,0,OMathRule.XI),
	RHO(61,"\\rho",new Atom(61,"\\rho"),0,0,0,0,OMathRule.RHO),
	TAU(62,"\\tau",new Atom(62,"\\tau"),0,0,0,0,OMathRule.TAU),
	UPSILON(63,"\\upsilon",new Atom(63,"\\upsilon"),0,0,0,0,OMathRule.UPSILON),
	LAMBDA(64,"\\lambda",new Atom(64,"\\lambda"),0,0,0,0,OMathRule.LAMBDA),
	D_ELTA(65,"\\Delta",new Atom(65,"\\Delta"),0,0,0,0,OMathRule.D_ELTA),
	G_AMMA(66,"\\Gamma",new Atom(66,"\\Gamma"),0,0,0,0,OMathRule.G_AMMA),
	P_I(67,"\\Pi",new Atom(67,"\\Pi"),0,0,0,0,OMathRule.P_I),
	GETS(68,"\\gets",new Atom(68,"\\gets"),0,0,0,0,OMathRule.GETS),
	LEFTARROW(69,"\\leftarrow",new Atom(69,"\\leftarrow"),0,0,0,0,OMathRule.LEFTARROW),
	RIGHTARROW(70,"\\rightarrow",new Atom(70,"\\rightarrow"),0,0,0,0,OMathRule.RIGHTARROW),
	TO(71,"\\to",new Atom(71,"\\to"),0,0,0,0,OMathRule.TO),
	UPARROW(72,"\\uparrow",new Atom(72,"\\uparrow"),0,0,0,0,OMathRule.UPARROW),
	DOWNARROW(73,"\\downarrow",new Atom(73,"\\downarrow"),0,0,0,0,OMathRule.DOWNARROW),
	LEFTRIGHTARROW(74,"\\leftrightarrow",new Atom(74,"\\leftrightarrow"),0,0,0,0,OMathRule.LEFTRIGHTARROW),
	UPDOWNARROW(75,"\\updownarrow",new Atom(75,"\\updownarrow"),0,0,0,0,OMathRule.UPDOWNARROW),
	LEFT_ARROW(76,"\\Leftarrow",new Atom(76,"\\Leftarrow"),0,0,0,0,OMathRule.LEFT_ARROW),
	RIGHT_ARROW(77,"\\Rightarrow",new Atom(77,"\\Rightarrow"),0,0,0,0,OMathRule.RIGHT_ARROW),
	UP_ARROW(78,"\\Uparrow",new Atom(78,"\\Uparrow"),0,0,0,0,OMathRule.UP_ARROW),
	DOWN_ARROW(79,"\\Downarrow",new Atom(79,"\\Downarrow"),0,0,0,0,OMathRule.DOWN_ARROW),
	LEFT_RIGHTARROW(80,"\\Leftrightarrow",new Atom(80,"\\Leftrightarrow"),0,0,0,0,OMathRule.LEFT_RIGHTARROW),
	UP_DOWNARROW(81,"\\Updownarrow",new Atom(81,"\\Updownarrow"),0,0,0,0,OMathRule.UP_DOWNARROW),
	LONGLEFTARROW(82,"\\longleftarrow",new Atom(82,"\\longleftarrow"),0,0,0,0,OMathRule.LONGLEFTARROW),
	LONGRIGHTARROW(83,"\\longrightarrow",new Atom(83,"\\longrightarrow"),0,0,0,0,OMathRule.LONGRIGHTARROW),
	LONGLEFTRIGHTARROW(84,"\\longleftrightarrow",new Atom(84,"\\longleftrightarrow"),0,0,0,0,OMathRule.LONGLEFTRIGHTARROW),
	LONG_LEFTARROW(85,"\\Longleftarrow",new Atom(85,"\\Longleftarrow"),0,0,0,0,OMathRule.LONG_LEFTARROW),
	LONG_RIGHTARROW(86,"\\Longrightarrow",new Atom(86,"\\Longrightarrow"),0,0,0,0,OMathRule.LONG_RIGHTARROW),
	LONG_LEFTRIGHTARROW(87,"\\Longleftrightarrow",new Atom(87,"\\Longleftrightarrow"),0,0,0,0,OMathRule.LONG_LEFTRIGHTARROW),
	NEARROW(88,"\\nearrow",new Atom(88,"\\nearrow"),0,0,0,0,OMathRule.NEARROW),
	NWARROW(89,"\\nwarrow",new Atom(89,"\\nwarrow"),0,0,0,0,OMathRule.NWARROW),
	ANGLE(90,"\\angle",new Atom(90,"\\angle"),0,0,0,0,OMathRule.ANGLE),
	PERP(91,"\\perp",new Atom(91,"\\perp"),0,0,0,0,OMathRule.PERP),
	BOT(92,"\\bot",new Atom(92,"\\bot"),0,0,0,0,OMathRule.BOT),
	PARALLEL(93,"\\parallel",new Atom(93,"\\parallel"),0,0,0,0,OMathRule.PARALLEL),
	TRIANGLE(94,"\\triangle",new Atom(94,"\\triangle"),0,0,0,0,OMathRule.TRIANGLE),
	B_OX(95,"\\Box",new Atom(95,"\\Box"),0,0,0,0,OMathRule.B_OX),
	SQUARE(96,"\\square",new Atom(96,"\\square"),0,0,0,0,OMathRule.SQUARE),
	D_IAMOND(97,"\\Diamond",new Atom(97,"\\Diamond"),0,0,0,0,OMathRule.D_IAMOND),
	CIRC(98,"\\circ",new Atom(98,"\\circ"),0,0,0,0,OMathRule.CIRC),
	OMICRON(99,"\\omicron",new Atom(99,"\\omicron"),0,0,0,0,OMathRule.OMICRON),
	OPLUS(100,"\\oplus",new Atom(100,"\\oplus"),0,0,0,0,OMathRule.OPLUS),
	BIGOPLUS(101,"\\bigoplus",new Atom(101,"\\bigoplus"),0,0,0,0,OMathRule.BIGOPLUS),
	OTIMES(102,"\\otimes",new Atom(102,"\\otimes"),0,0,0,0,OMathRule.OTIMES),
	BIGOTIMES(103,"\\bigotimes",new Atom(103,"\\bigotimes"),0,0,0,0,OMathRule.BIGOTIMES),
	BULLET(104,"\\bullet",new Atom(104,"\\bullet"),0,0,0,0,OMathRule.BULLET),
	CDOT(105,"\\cdot",new Atom(105,"\\cdot"),0,0,0,0,OMathRule.CDOT),
	CLUBSUIT(106,"\\clubsuit",new Atom(106,"\\clubsuit"),0,0,0,0,OMathRule.CLUBSUIT),
	SPADESUIT(107,"\\spadesuit",new Atom(107,"\\spadesuit"),0,0,0,0,OMathRule.SPADESUIT),
	SHARP(108,"\\sharp",new Atom(108,"\\sharp"),0,0,0,0,OMathRule.SHARP),
	LDOTS(109,"\\ldots",new Atom(109,"\\ldots"),0,0,0,0,OMathRule.LDOTS),
	DOTS(110,"\\dots",new Atom(110,"\\dots"),0,0,0,0,OMathRule.DOTS),
	PRIME(111,"\\prime",new Atom(111,"\\prime"),0,0,0,0,OMathRule.PRIME),
	WEDGE(112,"\\wedge",new Atom(112,"\\wedge"),0,0,0,0,OMathRule.WEDGE),
	LAND(113,"\\land",new Atom(113,"\\land"),0,0,0,0,OMathRule.LAND),
	BIGWEDGE(114,"\\bigwedge",new Atom(114,"\\bigwedge"),0,0,0,0,OMathRule.BIGWEDGE),
	LOR(115,"\\lor",new Atom(115,"\\lor"),0,0,0,0,OMathRule.LOR),
	VEE(116,"\\vee",new Atom(116,"\\vee"),0,0,0,0,OMathRule.VEE),
	BIGVEE(117,"\\bigvee",new Atom(117,"\\bigvee"),0,0,0,0,OMathRule.BIGVEE),
	LNOT(118,"\\lnot",new Atom(118,"\\lnot"),0,0,0,0,OMathRule.LNOT),
	NEG(119,"\\neg",new Atom(119,"\\neg"),0,0,0,0,OMathRule.NEG),
	SETMINUS(120,"\\setminus",new Atom(120,"\\setminus"),0,0,0,0,OMathRule.SETMINUS),
	SMALLSETMINUS(121,"\\smallsetminus",new Atom(121,"\\smallsetminus"),0,0,0,0,OMathRule.SMALLSETMINUS),
	NABLA(122,"\\nabla",new Atom(122,"\\nabla"),0,0,0,0,OMathRule.NABLA),
	SIM(123,"\\sim",new Atom(123,"\\sim"),0,0,0,0,OMathRule.SIM),
	RIGHTHARPOONUP(124,"\\rightharpoonup",new Atom(124,"\\rightharpoonup"),0,0,0,0,OMathRule.RIGHTHARPOONUP),
	RIGHTHARPOONDOWN(125,"\\rightharpoondown",new Atom(125,"\\rightharpoondown"),0,0,0,0,OMathRule.RIGHTHARPOONDOWN),
	LEFTHARPOONDOWN(126,"\\leftharpoondown",new Atom(126,"\\leftharpoondown"),0,0,0,0,OMathRule.LEFTHARPOONDOWN),
	LEFTHARPOONUP(127,"\\leftharpoonup",new Atom(127,"\\leftharpoonup"),0,0,0,0,OMathRule.LEFTHARPOONUP),
	UPHARPOONLEFT(128,"\\upharpoonleft",new Atom(128,"\\upharpoonleft"),0,0,0,0,OMathRule.UPHARPOONLEFT),
	UPHARPOONRIGHT(129,"\\upharpoonright",new Atom(129,"\\upharpoonright"),0,0,0,0,OMathRule.UPHARPOONRIGHT),
	DOWNHARPOONLEFT(130,"\\downharpoonleft",new Atom(130,"\\downharpoonleft"),0,0,0,0,OMathRule.DOWNHARPOONLEFT),
	DOWNHARPOONRIGHT(131,"\\downharpoonright",new Atom(131,"\\downharpoonright"),0,0,0,0,OMathRule.DOWNHARPOONRIGHT),
	PERCENT(132,"\\%",new Atom(132,"\\%"),0,0,0,0,OMathRule.PERCENT),
	MHO(133,"\\mho",new Atom(133,"\\mho"),0,0,0,0,OMathRule.MHO),
	HBAR(134,"\\hbar",new Atom(134,"\\hbar"),0,0,0,0,OMathRule.HBAR),
	ELL(135,"\\ell",new Atom(135,"\\ell"),0,0,0,0,OMathRule.ELL),
	CDOTS(136,"\\cdots",new Atom(136,"\\cdots"),0,0,0,0,OMathRule.CDOTS),
	INT(137,"\\int",new Atom(137,"\\int"),0,0,0,0,OMathRule.INT),
	SUM(138,"\\sum",new Atom(138,"\\sum"),0,0,0,0,OMathRule.SUM),
	PROD(139,"\\prod",new Atom(139,"\\prod"),0,0,0,0,OMathRule.PROD),
	IINT(140,"\\iint",new Atom(140,"\\iint"),0,0,0,0,OMathRule.IINT),
	IIINT(141,"\\iiint",new Atom(141,"\\iiint"),0,0,0,0,OMathRule.IIINT),
	BIGCAP(142,"\\bigcap",new Atom(142,"\\bigcap"),0,0,0,0,OMathRule.BIGCAP),
	BIGCUP(143,"\\bigcup",new Atom(143,"\\bigcup"),0,0,0,0,OMathRule.BIGCUP),
	U200B(144,"\\u200B",new Atom(143,"\\u200B"),0,0,0,0,OMathRule.U200B),
	GT_(145,">",new Atom(145,">"),0,0,0,0,OMathRule.GT_),
	LT_(146,"<",new Atom(146,"<"),0,0,0,0,OMathRule.LT_),
	NOLIMITS(147,"\\nolimits",new Atom(147,"\\nolimits"),0,0,0,0,OMathRule.NOLIMITS),
	LIMITS(148,"\\limits",new Atom(148,"\\limits"),0,0,0,0,OMathRule.LIMITS),
	LANGLE(149,"\\langle",new Atom(149,"\\langle"),0,0,0,0,OMathRule.LANGLE),
	RANGLE(150,"\\rangle",new Atom(150,"\\rangle"),0,0,0,0,OMathRule.RANGLE),
	LVERT(151,"\\lvert",new Atom(151,"\\lvert"),0,0,0,0,OMathRule.LVERT),
	RVERT(152,"\\rvert",new Atom(152,"\\rvert"),0,0,0,0,OMathRule.RVERT),
	OINT(153,"\\oint",new Atom(153,"\\oint"),0,0,0,0,OMathRule.OINT),
	COPROD(154,"\\coprod",new Atom(154,"\\coprod"),0,0,0,0,OMathRule.COPROD),
	GEQ(155,"\\geq",new Atom(155,"\\geq"),0,0,0,0,OMathRule.GEQ),
	SUBSET(156,"\\subset",new Atom(156,"\\subset"),0,0,0,0,OMathRule.SUBSET),
	SUPSET(157,"\\supset",new Atom(157,"\\supset"),0,0,0,0,OMathRule.SUPSET),
    COLON(158,"\\colon",new Atom(158,"\\colon"),0,0,0,0,OMathRule.COLON),
    MATHOP(159,"\\mathop",new Atom(159,"\\mathop"),0,0,0,0,OMathRule.MATHOP),
    MOD(160,"\\mod",new Atom(160,"\\mod"),0,0,0,0,OMathRule.MOD),
    BMOD(161,"\\bmod",new Atom(161,"\\bmod"),0,0,0,0,OMathRule.BMOD),
    PMOD(162,"\\pmod",new Atom(162,"\\pmod","{",new Atom(),"}",1),1,0,0,0,OMathRule.PMOD),
    POD(163,"\\pod",new Atom(163,"\\pod","{",new Atom(),"}",1),1,0,0,0,OMathRule.POD),
    EQUIV(164,"\\equiv",new Atom(164,"\\equiv"),0,0,0,0,OMathRule.EQUIV),
    MAX(165,"\\max",new Atom(165,"\\max"),0,0,0,0,OMathRule.MAX),
    MIN(166,"\\min",new Atom(166,"\\min"),0,0,0,0,OMathRule.MIN),
    PHANTOM(167,"\\phantom",new Atom(167,"\\phantom"),0,0,0,0,OMathRule.PHANTOM),
    WELL(168,"\\#",new Atom(168,"\\#"),0,0,0,0,OMathRule.WELL),
    DOLLAR(169,"\\$",new Atom(169,"\\$"),0,0,0,0,OMathRule.DOLLAR),
    TIPHAT(170,"\\^",new Atom(170,"\\^"),0,0,0,0,OMathRule.TIPHAT),
    DOWNLINE(171,"\\_",new Atom(171,"\\_"),0,0,0,0,OMathRule.DOWNLINE),
    WAVELINE(172,"\\~",new Atom(172,"\\~"),0,0,0,0,OMathRule.WAVELINE),
	GEQSLANT(173,"\\geqslant",new Atom(173,"\\geqslant"),0,0,0,0,OMathRule.GEQSLANT),
	CLOSE_SPACE(174,"\\:",new Atom(174,"\\:"),0,0,0,0,OMathRule.CLOSE_SPACE),
	VARNOTHING(175,"\\varnothing",new Atom(175,"\\varnothing"),0,0,0,0,OMathRule.VARNOTHING),
	NOTIN(176,"\\notin",new Atom(176,"\\notin"),0,0,0,0,OMathRule.NOTIN),
	LG(177,"\\lg",new Atom(177,"\\lg"),0,0,0,0,OMathRule.LG),
	BACKSLASH(178,"\\backslash",new Atom(178,"\\backslash"),0,0,0,0,OMathRule.BACKSLASH),
	ARCTAN(179,"\\arctan",new Atom(179,"\\arctan"),0,0,0,0,OMathRule.ARCTAN),
	ARCSIN(180,"\\arcsin",new Atom(180,"\\arcsin"),0,0,0,0,OMathRule.ARCSIN),
	ARCCOS(181,"\\arccos",new Atom(181,"\\arccos"),0,0,0,0,OMathRule.ARCCOS),
	LEQSLANT(182,"\\leqslant",new Atom(182,"\\leqslant"),0,0,0,0,OMathRule.LEQSLANT),
    CONG(183,"\\cong",new Atom(183,"\\cong"),0,0,0,0,OMathRule.CONG),
    COMPLEMENT(184,"\\complement",new Atom(184,"\\complement"),0,0,0,0,OMathRule.COMPLEMENT),
    VERT(185,"\\vert",new Atom(185,"\\vert"),0,0,0,0,OMathRule.VERT),
	BACK_SLASH(186,"\\",new Atom(186,"\\"),0,0,0,0,OMathRule.BACK_SLASH),
	BIGTRIANGLEUP(187,"\\bigtriangleup",new Atom(187,"\\bigtriangleup"),0,0,0,0,OMathRule.BIGTRIANGLEUP),
    ODOT(188,"\\odot",new Atom(188,"\\odot"),0,0,0,0,OMathRule.ODOT),
    MID(189,"\\mid",new Atom(189,"\\mid"),0,0,0,0,OMathRule.MID),
    TRIANGLEQ(190,"\\triangleq",new Atom(190,"\\triangleq"),0,0,0,0,OMathRule.TRIANGLEQ),
	O_MEGA(191,"\\Omega",new Atom(191,"\\Omega"),0,0,0,0,OMathRule.O_MEGA),
	RIGHTLEFTHARPOONS(192,"\\rightleftharpoons",new Atom(192,"\\rightleftharpoons"),0,0,0,0,OMathRule.RIGHTLEFTHARPOONS),
	LEFTRIGHTHARPOONS(193,"\\leftrightharpoons",new Atom(193,"\\leftrightharpoons"),0,0,0,0,OMathRule.LEFTRIGHTHARPOONS),
	RIGHTLEFTARROWS(194,"\\rightleftarrows",new Atom(194,"\\rightleftarrows"),0,0,0,0,OMathRule.RIGHTLEFTARROWS),
	LEFTRIGHTARROWS(195,"\\leftrightarrows",new Atom(195,"\\leftrightarrows"),0,0,0,0,OMathRule.LEFTRIGHTARROWS),
	TILDE(196,"\\tilde",new Atom(196,"\\tilde"),0,0,0,0,OMathRule.TILDE),
	VARTRIANGLE(197,"\\vartriangle",new Atom(197,"\\vartriangle"),0,0,0,0,OMathRule.VARTRIANGLE),
	L_AMBDA(198,"\\Lambda",new Atom(198,"\\Lambda"),0,0,0,0,OMathRule.L_AMBDA),
	NU(199,"\\nu",new Atom(199,"\\nu"),0,0,0,0,OMathRule.NU),
	TFRAC(200,"\\tfrac",new Atom(9,"\\tfrac","{",new Atom(),"}",1,"{",new Atom(),"}",1),1,0,0,0,OMathRule.TFRAC),
    CENTERDOT(201,"\\centerdot",new Atom(201,"\\centerdot"),0,0,0,0,OMathRule.CENTERDOT),
    T_HETA(202,"\\Theta",new Atom(202,"\\Theta"),0,0,0,0,OMathRule.T_HETA),
    GG(203,"\\gg",new Atom(203,"\\gg"),0,0,0,0,OMathRule.GG),
    LL(204,"\\ll",new Atom(204,"\\ll"),0,0,0,0,OMathRule.LL),
    BIGCIRC(205,"\\bigcirc",new Atom(205,"\\bigcirc"),0,0,0,0,OMathRule.BIGCIRC),
	BACKSIM(206,"\\backsim",new Atom(206,"\\backsim"),0,0,0,0,OMathRule.BACKSIM),
    BIGSTAR(207,"\\bigstar",new Atom(207,"\\bigstar"),0,0,0,0,OMathRule.BIGSTAR),
    SMALL(208,"\\small",new Atom(208,"\\small"),0,0,0,0,OMathRule.SMALL),
    VARTHETA(209,"\\vartheta",new Atom(209,"\\vartheta"),0,0,0,0,OMathRule.VARTHETA),
    BLACKTRIANGLE(210,"\\blacktriangle",new Atom(210,"\\blacktriangle"),0,0,0,0,OMathRule.BLACKTRIANGLE),
    SURD(211,"\\surd",new Atom(211,"\\surd"),0,0,0,0,OMathRule.SURD),
    SUBSETEQ(212,"\\subseteq",new Atom(212,"\\subseteq"),0,0,0,0,OMathRule.SUBSETEQ),
    SUPSETEQ(213,"\\supseteq",new Atom(213,"\\supseteq"),0,0,0,0,OMathRule.SUPSETEQ),
    EMPTYSET(214,"\\emptyset",new Atom(214,"\\emptyset"),0,0,0,0,OMathRule.EMPTYSET),
    VARGAMMA(215,"\\varGamma",new Atom(215,"\\varGamma"),0,0,0,0,OMathRule.VARGAMMA),
    LOZENGE(216,"\\lozenge",new Atom(216,"\\lozenge"),0,0,0,0,OMathRule.LOZENGE),
    FROWN(217,"\\frown",new Atom(217,"\\frown"),0,0,0,0,OMathRule.FROWN),
	GT(218,"\\gt",new Atom(145,"\\gt"),0,0,0,0,OMathRule.GT),
	LT(218,"\\lt",new Atom(146,"\\lt"),0,0,0,0,OMathRule.LT),
	ZETA(219,"\\zeta",new Atom(219,"\\zeta"),0,0,0,0,OMathRule.ZETA),
	PSI(220,"\\psi",new Atom(220,"\\psi"),0,0,0,0,OMathRule.PSI),
	VARSIGMA(221,"\\varsigma",new Atom(221,"\\varsigma"),0,0,0,0,OMathRule.VARSIGMA),
	NOT(222,"\\not",new Atom(222,"\\not"),0,0,0,0,OMathRule.NOT),
	BLACKSQUARE(223,"\\blacksquare",new Atom(223,"\\blacksquare"),0,0,0,0,OMathRule.BLACKSQUARE),
	DIVIDEONTIMES(224,"\\divideontimes",new Atom(224,"\\divideontimes"),0,0,0,0,OMathRule.DIVIDEONTIMES),
	STAR(225,"\\star",new Atom(225,"\\star"),0,0,0,0,OMathRule.STAR),
	SUBSETNEQ(226,"\\subsetneq",new Atom(226,"\\subsetneq"),0,0,0,0,OMathRule.SUBSETNEQ),
	URCORNER(227,"\\urcorner",new Atom(227,"\\urcorner"),0,0,0,0,OMathRule.URCORNER),
	TRIANGLERIGHT(228,"\\triangleright",new Atom(228,"\\triangleright"),0,0,0,0,OMathRule.TRIANGLERIGHT),
	TRIANGLELEFT(229,"\\triangleleft",new Atom(229,"\\triangleleft"),0,0,0,0,OMathRule.TRIANGLELEFT),
	TRIANGLEDOWN(230,"\\triangledown",new Atom(230,"\\triangledown"),0,0,0,0,OMathRule.TRIANGLEDOWN),
	CHECKMARK(231,"\\checkmark",new Atom(231,"\\checkmark"),0,0,0,0,OMathRule.CHECKMARK),
	AST(232,"\\ast",new Atom(232,"\\ast"),0,0,0,0,OMathRule.AST),
	CIRCLEDCIRC(233,"\\circledcirc",new Atom(233,"\\circledcirc"),0,0,0,0,OMathRule.CIRCLEDCIRC),
	THICKAPPROX(234,"\\thickapprox",new Atom(234,"\\thickapprox"),0,0,0,0,OMathRule.THICKAPPROX),
	PREC(235,"\\prec",new Atom(235,"\\prec"),0,0,0,0,OMathRule.PREC),
	LBRACE(236,"\\lbrace",new Atom(236,"\\lbrace"),0,0,0,0,OMathRule.LBRACE),
	RBRACE(237,"\\rbrace",new Atom(237,"\\rbrace"),0,0,0,0,OMathRule.RBRACE),
	VDOTS(238,"\\vdots",new Atom(238,"\\vdots"),0,0,0,0,OMathRule.VDOTS),
	RDDOTS(239,"\\rddots",new Atom(239,"\\rddots"),0,0,0,0,OMathRule.RDDOTS),
	DDOTS(240,"\\ddots",new Atom(240,"\\ddots"),0,0,0,0,OMathRule.DDOTS),
	A_ND(241,"\\And",new Atom(241,"\\And"),0,0,0,0,OMathRule.A_ND),
	BIGODOT(242,"\\bigodot",new Atom(242,"\\bigodot"),0,0,0,0,OMathRule.BIGODOT),
	BLACKLOZENGE(243,"\\blacklozenge",new Atom(243,"\\blacklozenge"),0,0,0,0,OMathRule.BLACKLOZENGE),
	DIAMOND(244,"\\diamond",new Atom(244,"\\diamond"),0,0,0,0,OMathRule.DIAMOND),
	DIAMONDSUIT(245,"\\diamondsuit",new Atom(245,"\\diamondsuit"),0,0,0,0,OMathRule.DIAMONDSUIT),
	VAR_DELTA(246,"\\varDelta",new Atom(246,"\\varDelta"),0,0,0,0,OMathRule.VAR_DELTA),
	SEARROW(247,"\\searrow",new Atom(247,"\\searrow"),0,0,0,0,OMathRule.SEARROW),
	SWARROW(248,"\\swarrow",new Atom(248,"\\swarrow"),0,0,0,0,OMathRule.SWARROW),
	NSUBSETEQ(249,"\\nsubseteq",new Atom(249,"\\nsubseteq"),0,0,0,0,OMathRule.NSUBSETEQ),
	NRIGHTARROW(250,"\\nRightarrow",new Atom(250,"\\nRightarrow"),0,0,0,0,OMathRule.NRIGHTARROW),
	NLEFTARROW(251,"\\nleftarrow",new Atom(251,"\\nleftarrow"),0,0,0,0,OMathRule.NLEFTARROW),
	SUCC(252,"\\succ",new Atom(252,"\\succ"),0,0,0,0,OMathRule.SUCC),
	MP(253,"\\mp",new Atom(253,"\\mp"),0,0,0,0,OMathRule.MP),




    SUP(20,"^",new Atom(20,"^","{",new Atom(),"}",1,"{",new Atom(),"}",1),-1,0,0,0,OMathRule.SUP),
	SUB(30,"_",new Atom(30,"_","{",new Atom(),"}",1,"{",new Atom(),"}",1),-1,0,0,0,OMathRule.SUB),


    AND(40,"&",new Atom(40,"&"),0,3,7,2,OMathRule.AND,OMathRule._AMP),
    POUND(41,"&pound;",new Atom(41,"&pound;"),0,0,0,0,OMathRule.POUND),

    ENTER(50,"\\\\",new Atom(50,"\\\\"),0,3,7,3,OMathRule.ENTER,OMathRule.DOUBLEENTER),

	LONGEQUAL(51,"═",new Atom(50,"═"),0,0,0,0,OMathRule.LONGEQUAL),
    WAVE(52,"~",new Atom(50,"~"),0,0,0,0,OMathRule.WAVE),

	HFILL(53,"\\hfill",new Atom(53,"\\hfill"),0,3,7,3,OMathRule.HFILL),



    LN(200,"\\ln",new Atom(200,"\\ln"),0,0,0,0,OMathRule.LN),

	LIM(400,"\\lim",new Atom(400,"\\lim"),0,0,0,0,OMathRule.LIM),

	VEC(402,"\\vec",new Atom(402,"\\vec","{",new Atom(),"}",1),1,0,0,0,OMathRule.VEC),
	OVERRIGHTARROW(403,"\\overrightarrow",new Atom(403,"\\overrightarrow","{",new Atom(),"}",1),1,0,0,0,OMathRule.OVERRIGHTARROW),
	DDOT(404,"\\ddot",new Atom(404,"\\ddot","{",new Atom(),"}",1),1,0,0,0,OMathRule.DDOT),
	OVERLEFTARROW(405,"\\overleftarrow",new Atom(405,"\\overleftarrow","{",new Atom(),"}",1),1,0,0,0,OMathRule.OVERLEFTARROW),
	WIDEHAT(406,"\\widehat",new Atom(406,"\\widehat","{",new Atom(),"}",1),1,0,0,0,OMathRule.WIDEHAT),
	OVERLINE(407,"\\overline",new Atom(407,"\\overline","{",new Atom(),"}",1),1,0,0,0,OMathRule.OVERLINE),
	//OVERSET(408,"\\overset",new Atom(408,"\\overset","{",new Atom(),"}",1),1,0,0,0,OMathRule.OVERSET),
	OVERSET(408,"\\overset",new Atom(408,"\\overset","{",new Atom(),"}",1,"{",new Atom(),"}",1),1,0,0,0,OMathRule.OVERSET),
	OVERBRACE(409,"\\overbrace",new Atom(409,"\\overbrace","{",new Atom(),"}",1),1,0,0,0,OMathRule.OVERBRACE),
	UNDERBRACE(410,"\\underbrace",new Atom(410,"\\underbrace","{",new Atom(),"}",1),1,0,0,0,OMathRule.UNDERBRACE),
	STACKREL(411,"\\stackrel",new Atom(411,"\\stackrel","{",new Atom(),"}",1,"{",new Atom(),"}",1),1,0,0,0,OMathRule.STACKREL),
	UNDERSET(412,"\\underset",new Atom(412,"\\underset","{",new Atom(),"}",1,"{",new Atom(),"}",1),1,0,0,0,OMathRule.UNDERSET),
	UNDERLINE(413,"\\underline",new Atom(413,"\\underline","{",new Atom(),"}",1),1,0,0,0,OMathRule.UNDERLINE),
	HAT(414,"\\hat",new Atom(414,"\\hat","{",new Atom(),"}",1),1,0,0,0,OMathRule.HAT),
	OVERPAREN(415,"\\overparen",new Atom(415,"\\overparen","{",new Atom(),"}",1),1,0,0,0,OMathRule.OVERPAREN),
	XLEFTARROW(416,"\\xleftarrow",new Atom(416,"\\xleftarrow","[",new Atom(),"]",0,"{",new Atom(),"}",1),1,0,0,0,OMathRule.XLEFTARROW),
	XRIGHTARROW(417,"\\xrightarrow",new Atom(417,"\\xleftarrow","[",new Atom(),"]",0,"{",new Atom(),"}",1),1,0,0,0,OMathRule.XRIGHTARROW),
	OPERATORNAME(418,"\\operatorname",new Atom(414,"\\operatorname","{",new Atom(),"}",1),1,0,0,0,OMathRule.OPERATORNAME),
	UNDERRIGHTARROW(419,"\\underrightarrow",new Atom(410,"\\underrightarrow","{",new Atom(),"}",1),1,0,0,0,OMathRule.UNDERRIGHTARROW),
	VERB(420,"\\verb",new Atom(420,"\\verb"),0,0,0,0,OMathRule.VERB),
	BOXED(421,"\\boxed",new Atom(421,"\\boxed","{",new Atom(),"}",1),1,0,0,0,OMathRule.BOXED),
	FBOX(422,"\\fbox",new Atom(422,"\\fbox","{",new Atom(),"}",1),1,0,0,0,OMathRule.FBOX),





	BF(1000,"\\bf",new Atom(1000,"\\bf","{",new Atom(),"}",1),1,0,0,0,OMathRule.BF),
	MATHBF(1001,"\\mathbf",new Atom(1001,"\\mathbf","{",new Atom(),"}",1),1,0,0,0,OMathRule.MATHBF),
	MATHRM(1002,"\\mathrm",new Atom(1002,"\\mathrm","{",new Atom(),"}",1),1,0,0,0,OMathRule.MATHRM),
	RM(1003,"\\rm",new Atom(1003,"\\rm","{",new Atom(),"}",1),1,0,0,0,OMathRule.RM),
    BOLDSYMBOL(1004,"\\boldsymbol",new Atom(1004,"\\boldsymbol","{",new Atom(),"}",1),1,0,0,0,OMathRule.BOLDSYMBOL),
    COLOR(1005,"\\color",new Atom(1005,"\\color","{",new Atom(),"}",1,2),1,0,0,0,OMathRule.COLOR),
	TEXT(1006,"\\text",new Atom(1006,"\\text","{",new Atom(),"}",1),1,0,0,0,OMathRule.TEXT),
	SF(1007,"\\sf",new Atom(1007,"\\sf","{",new Atom(),"}",1),1,0,0,0,OMathRule.SF),
	MATHSF(1008,"\\mathsf",new Atom(1008,"\\mathsf","{",new Atom(),"}",1),1,0,0,0,OMathRule.MATHSF),
	DISPLAYSTYLE(1009,"\\displaystyle",new Atom(1009,"\\displaystyle","{",new Atom(),"}",1),1,0,0,0,OMathRule.DISPLAYSTYLE),
	TEXTSTYLE(1010,"\\textstyle",new Atom(1010,"\\textstyle","{",new Atom(),"}",1),1,0,0,0,OMathRule.TEXTSTYLE),
	SCRIPTSTYLE(1011,"\\scriptstyle",new Atom(1011,"\\scriptstyle","{",new Atom(),"}",1),1,0,0,0,OMathRule.SCRIPTSTYLE),
	SCRIPTSCRIPTSTYLE(1012,"\\scriptscriptstyle",new Atom(1012,"\\scriptscriptstyle","{",new Atom(),"}",1),1,0,0,0,OMathRule.SCRIPTSCRIPTSTYLE),
	TEXTRM(1012,"\\textrm",new Atom(1012,"\\textrm","{",new Atom(),"}",1),1,0,0,0,OMathRule.TEXTRM),
	TEXTIT(1013,"\\textit",new Atom(1013,"\\textit","{",new Atom(),"}",1),1,0,0,0,OMathRule.TEXTIT),
	_LARGE(1014,"\\Large",new Atom(1014,"\\Large","{",new Atom(),"}",1),1,0,0,0,OMathRule._LARGE),
	LARGE(1015,"\\large",new Atom(1015,"\\large","{",new Atom(),"}",1),1,0,0,0,OMathRule.LARGE),
	HUGE(1016,"\\huge",new Atom(1016,"\\huge","{",new Atom(),"}",1),1,0,0,0,OMathRule.HUGE),
	MATHCAL(1017,"\\mathcal",new Atom(1017,"\\mathcal","{",new Atom(),"}",1),1,0,0,0,OMathRule.MATHCAL),
	TEXTBF(1018,"\\textbf",new Atom(1018,"\\textbf","{",new Atom(),"}",1),1,0,0,0,OMathRule.TEXTBF),
    MATHBB(1019,"\\mathbb",new Atom(1019,"\\mathbb","{",new Atom(),"}",1),1,0,0,0,OMathRule.MATHBB),
    MATHREL(1020,"\\mathrel",new Atom(1019,"\\mathrel","{",new Atom(),"}",1),1,0,0,0,OMathRule.MATHREL),




	_NBSP(2000,"&nbsp;",new Atom(2000,"&nbsp;"),0,0,0,0,OMathRule._NBSP),
	_LT(2001,"&lt;",new Atom(2001,"&lt;"),0,0,0,0,OMathRule._LT),
	_GT(2002,"&gt;",new Atom(2002,"&gt;"),0,0,0,0,OMathRule._GT),
	_AMP(2003,"&amp;",new Atom(2003,"&amp;"),0,3,7,2,OMathRule.AND,OMathRule._AMP),
	_QUOT(2004,"&quot;",new Atom(2004,"&quot;"),0,0,0,0,OMathRule._QUOT),
	_APOS(2005,"&apos;",new Atom(2005,"&apos;"),0,0,0,0,OMathRule._APOS),
	_CENT(2006,"&cent;",new Atom(2006,"&cent;"),0,0,0,0,OMathRule._CENT),
	_POUND(2007,"&pound;",new Atom(2007,"&pound;"),0,0,0,0,OMathRule._POUND),
	_YEN(2008,"&yen;",new Atom(2008,"&yen;"),0,0,0,0,OMathRule._YEN),
	_EURO(2009,"&euro;",new Atom(2009,"&euro;"),0,0,0,0,OMathRule._EURO),
	_SECT(2010,"&sect;",new Atom(2010,"&sect;"),0,0,0,0,OMathRule._SECT),
	_COPY(2011,"&copy;",new Atom(2011,"&copy;"),0,0,0,0,OMathRule._COPY),
	_REG(2012,"&reg;",new Atom(2012,"&reg;"),0,0,0,0,OMathRule._REG),
	_TRADE(2013,"&trade;",new Atom(2013,"&trade;"),0,0,0,0,OMathRule._TRADE),
	_TIMES(2014,"&times;",new Atom(2014,"&times;"),0,0,0,0,OMathRule._TIMES),
	_DIVIDE(2015,"&divide;",new Atom(2015,"&divide;"),0,0,0,0,OMathRule._DIVIDE),
	_ENSP(2016,"&ensp;",new Atom(2016,"&ensp;"),0,0,0,0,OMathRule._ENSP),
	_EMSP(2017,"&emsp;",new Atom(2017,"&emsp;"),0,0,0,0,OMathRule._EMSP),
	_A_LPHA(2018,"&Alpha;",new Atom(2018,"&Alpha;"),0,0,0,0,OMathRule._A_LPHA),
	_G_AMMA(2019,"&Gamma;",new Atom(2019,"&Gamma;"),0,0,0,0,OMathRule._G_AMMA),
	_E_PSILON(2020,"&Epsilon;",new Atom(2020,"&Epsilon;"),0,0,0,0,OMathRule._E_PSILON),
	_E_TA(2021,"&Eta;",new Atom(2021,"&Eta;"),0,0,0,0,OMathRule._E_TA),
	_I_OTA(2022,"&Iota;",new Atom(2022,"&Iota;"),0,0,0,0,OMathRule._I_OTA),
	_L_AMBDA(2023,"&Lambda;",new Atom(2023,"&Lambda;"),0,0,0,0,OMathRule._L_AMBDA),
	_N_U(2024,"&Nu;",new Atom(2024,"&Nu;"),0,0,0,0,OMathRule._N_U),
	_O_MICRON(2025,"&Omicron;",new Atom(2025,"&Omicron;"),0,0,0,0,OMathRule._O_MICRON),
	_R_HO(2026,"&Rho;",new Atom(2026,"&Rho;"),0,0,0,0,OMathRule._R_HO),
	_T_AU(2027,"&Tau;",new Atom(2027,"&Tau;"),0,0,0,0,OMathRule._T_AU),
	_P_HI(2028,"&Phi;",new Atom(2028,"&Phi;"),0,0,0,0,OMathRule._P_HI),
	_P_SI(2029,"&Psi;",new Atom(2029,"&Psi;"),0,0,0,0,OMathRule._P_SI),
	_ALPHA(2030,"&alpha;",new Atom(2030,"&alpha;"),0,0,0,0,OMathRule._ALPHA),
	_GAMMA(2031,"&gamma;",new Atom(2031,"&gamma;"),0,0,0,0,OMathRule._GAMMA),
	_EPSILON(2032,"&epsilon;",new Atom(2032,"&epsilon;"),0,0,0,0,OMathRule._EPSILON),
	_ETA(2033,"&eta;",new Atom(2033,"&eta;"),0,0,0,0,OMathRule._ETA),
	_IOTA(2034,"&iota;",new Atom(2034,"&iota;"),0,0,0,0,OMathRule._IOTA),
	_LAMBDA(2035,"&lambda;",new Atom(2035,"&lambda;"),0,0,0,0,OMathRule._LAMBDA),
	_NU(2036,"&nu;",new Atom(2036,"&nu;"),0,0,0,0,OMathRule._NU),
	_OMICRON(2037,"&omicron;",new Atom(2037,"&omicron;"),0,0,0,0,OMathRule._OMICRON),
	_RHO(2038,"&rho;",new Atom(2038,"&rho;"),0,0,0,0,OMathRule._RHO),
	_SIGMA(2039,"&sigma;",new Atom(2039,"&sigma;"),0,0,0,0,OMathRule._SIGMA),
	_UPSILON(2040,"&upsilon;",new Atom(2040,"&upsilon;"),0,0,0,0,OMathRule._UPSILON),
	_CHI(2041,"&chi;",new Atom(2041,"&chi;"),0,0,0,0,OMathRule._CHI),
	_OMEGA(2042,"&omega;",new Atom(2042,"&omega;"),0,0,0,0,OMathRule._OMEGA),
	_UPSIH(2043,"&upsih;",new Atom(2043,"&upsih;"),0,0,0,0,OMathRule._UPSIH),
	_BULL(2044,"&bull;",new Atom(2044,"&bull;"),0,0,0,0,OMathRule._BULL),
	_PRIME(2045,"&prime;",new Atom(2045,"&prime;"),0,0,0,0,OMathRule._PRIME),
	_OLINE(2046,"&oline;",new Atom(2046,"&oline;"),0,0,0,0,OMathRule._OLINE),
	_WEIERP(2047,"&weierp;",new Atom(2047,"&weierp;"),0,0,0,0,OMathRule._WEIERP),
	_REAL(2048,"&real;",new Atom(2048,"&real;"),0,0,0,0,OMathRule._REAL),
	_ALEFSYM(2049,"&alefsym;",new Atom(2049,"&alefsym;"),0,0,0,0,OMathRule._ALEFSYM),
	_UARR(2050,"&uarr;",new Atom(2050,"&uarr;"),0,0,0,0,OMathRule._UARR),
	_DARR(2051,"&darr;",new Atom(2051,"&darr;"),0,0,0,0,OMathRule._DARR),
	_CRARR(2052,"&crarr;",new Atom(2052,"&crarr;"),0,0,0,0,OMathRule._CRARR),
	_UA_RR(2053,"&uArr;",new Atom(2053,"&uArr;"),0,0,0,0,OMathRule._UA_RR),
	_DA_RR(2054,"&dArr;",new Atom(2054,"&dArr;"),0,0,0,0,OMathRule._DA_RR),
	_FORALL(2055,"&forall;",new Atom(2055,"&forall;"),0,0,0,0,OMathRule._FORALL),
	_EXIST(2056,"&exist;",new Atom(2056,"&exist;"),0,0,0,0,OMathRule._EXIST),
	_NABLA(2057,"&nabla;",new Atom(2057,"&nabla;"),0,0,0,0,OMathRule._NABLA),
	_NOTIN(2058,"&notin;",new Atom(2058,"&notin;"),0,0,0,0,OMathRule._NOTIN),
	_PROD(2059,"&prod;",new Atom(2059,"&prod;"),0,0,0,0,OMathRule._PROD),
	_MINUS(2060,"&minus;",new Atom(2060,"&minus;"),0,0,0,0,OMathRule._MINUS),
	_RADIC(2061,"&radic;",new Atom(2061,"&radic;"),0,0,0,0,OMathRule._RADIC),
	_INFIN(2062,"&infin;",new Atom(2062,"&infin;"),0,0,0,0,OMathRule._INFIN),
	_AND(2063,"&and;",new Atom(2063,"&and;"),0,0,0,0,OMathRule._AND),
	_CAP(2064,"&cap;",new Atom(2064,"&cap;"),0,0,0,0,OMathRule._CAP),
	_INT(2065,"&int;",new Atom(2065,"&int;"),0,0,0,0,OMathRule._INT),
	_SIM(2066,"&sim;",new Atom(2066,"&sim;"),0,0,0,0,OMathRule._SIM),
	_ASYMP(2067,"&asymp;",new Atom(2067,"&asymp;"),0,0,0,0,OMathRule._ASYMP),
	_EQUIV(2068,"&equiv;",new Atom(2068,"&equiv;"),0,0,0,0,OMathRule._EQUIV),
	_GE(2069,"&ge;",new Atom(2069,"&ge;"),0,0,0,0,OMathRule._GE),
	_SUP(2070,"&sup;",new Atom(2070,"&sup;"),0,0,0,0,OMathRule._SUP),
	_SUBE(2071,"&sube;",new Atom(2071,"&sube;"),0,0,0,0,OMathRule._SUBE),
	_OPLUS(2072,"&oplus;",new Atom(2072,"&oplus;"),0,0,0,0,OMathRule._OPLUS),
	_PERP(2073,"&perp;",new Atom(2073,"&perp;"),0,0,0,0,OMathRule._PERP),
	_LCEIL(2074,"&lceil;",new Atom(2074,"&lceil;"),0,0,0,0,OMathRule._LCEIL),
	_LFLOOR(2075,"&lfloor;",new Atom(2075,"&lfloor;"),0,0,0,0,OMathRule._LFLOOR),
	_LOZ(2076,"&loz;",new Atom(2076,"&loz;"),0,0,0,0,OMathRule._LOZ),
	_CLUBS(2077,"&clubs;",new Atom(2077,"&clubs;"),0,0,0,0,OMathRule._CLUBS),
	_DIAMS(2078,"&diams;",new Atom(2078,"&diams;"),0,0,0,0,OMathRule._DIAMS),
	_IEXCL(2079,"&iexcl;",new Atom(2079,"&iexcl;"),0,0,0,0,OMathRule._IEXCL),
	_LAQUO(2080,"&laquo;",new Atom(2080,"&laquo;"),0,0,0,0,OMathRule._LAQUO),
	_SHY(2081,"&shy;",new Atom(2081,"&shy;"),0,0,0,0,OMathRule._SHY),
	_MACR(2082,"&macr;",new Atom(2082,"&macr;"),0,0,0,0,OMathRule._MACR),
	_PLUSMN(2083,"&plusmn;",new Atom(2083,"&plusmn;"),0,0,0,0,OMathRule._PLUSMN),
	_SUP3(2084,"&sup3;",new Atom(2084,"&sup3;"),0,0,0,0,OMathRule._SUP3),
	_MICRO(2085,"&micro;",new Atom(2085,"&micro;"),0,0,0,0,OMathRule._MICRO),
	_B_ETA(2086,"&Beta;",new Atom(2086,"&Beta;"),0,0,0,0,OMathRule._B_ETA),
	_D_ELTA(2087,"&Delta;",new Atom(2087,"&Delta;"),0,0,0,0,OMathRule._D_ELTA),
	_Z_ETA(2088,"&Zeta;",new Atom(2088,"&Zeta;"),0,0,0,0,OMathRule._Z_ETA),
	_T_HETA(2089,"&Theta;",new Atom(2089,"&Theta;"),0,0,0,0,OMathRule._T_HETA),
	_K_APPA(2090,"&Kappa;",new Atom(2090,"&Kappa;"),0,0,0,0,OMathRule._K_APPA),
	_M_U(2091,"&Mu;",new Atom(2091,"&Mu;"),0,0,0,0,OMathRule._M_U),
	_X_I(2092,"&Xi;",new Atom(2092,"&Xi;"),0,0,0,0,OMathRule._X_I),
	_P_I(2093,"&Pi;",new Atom(2093,"&Pi;"),0,0,0,0,OMathRule._P_I),
	_S_IGMA(2094,"&Sigma;",new Atom(2094,"&Sigma;"),0,0,0,0,OMathRule._S_IGMA),
	_U_PSILON(2095,"&Upsilon;",new Atom(2095,"&Upsilon;"),0,0,0,0,OMathRule._U_PSILON),
	_C_HI(2096,"&Chi;",new Atom(2096,"&Chi;"),0,0,0,0,OMathRule._C_HI),
	_O_MEGA(2097,"&Omega;",new Atom(2097,"&Omega;"),0,0,0,0,OMathRule._O_MEGA),
	_BETA(2098,"&beta;",new Atom(2098,"&beta;"),0,0,0,0,OMathRule._BETA),
	_DELTA(2099,"&delta;",new Atom(2099,"&delta;"),0,0,0,0,OMathRule._DELTA),
	_ZETA(2100,"&zeta;",new Atom(2100,"&zeta;"),0,0,0,0,OMathRule._ZETA),
	_THETA(2101,"&theta;",new Atom(2101,"&theta;"),0,0,0,0,OMathRule._THETA),
	_KAPPA(2102,"&kappa;",new Atom(2102,"&kappa;"),0,0,0,0,OMathRule._KAPPA),
	_MU(2103,"&mu;",new Atom(2103,"&mu;"),0,0,0,0,OMathRule._MU),
	_XI(2104,"&xi;",new Atom(2104,"&xi;"),0,0,0,0,OMathRule._XI),
	_PI(2105,"&pi;",new Atom(2105,"&pi;"),0,0,0,0,OMathRule._PI),
	_SIGMAF(2106,"&sigmaf;",new Atom(2106,"&sigmaf;"),0,0,0,0,OMathRule._SIGMAF),
	_TAU(2107,"&tau;",new Atom(2107,"&tau;"),0,0,0,0,OMathRule._TAU),
	_PHI(2108,"&phi;",new Atom(2108,"&phi;"),0,0,0,0,OMathRule._PHI),
	_PSI(2109,"&psi;",new Atom(2109,"&psi;"),0,0,0,0,OMathRule._PSI),
	_THETASYM(2110,"&thetasym;",new Atom(2110,"&thetasym;"),0,0,0,0,OMathRule._THETASYM),
	_PIV(2111,"&piv;",new Atom(2111,"&piv;"),0,0,0,0,OMathRule._PIV),
	_HELLIP(2112,"&hellip;",new Atom(2112,"&hellip;"),0,0,0,0,OMathRule._HELLIP),
	_P_RIME(2113,"&Prime;",new Atom(2113,"&Prime;"),0,0,0,0,OMathRule._P_RIME),
	_FRASL(2114,"&frasl;",new Atom(2114,"&frasl;"),0,0,0,0,OMathRule._FRASL),
	_IMAGE(2115,"&image;",new Atom(2115,"&image;"),0,0,0,0,OMathRule._IMAGE),
	_LARR(2116,"&larr;",new Atom(2116,"&larr;"),0,0,0,0,OMathRule._LARR),
	_RARR(2117,"&rarr;",new Atom(2117,"&rarr;"),0,0,0,0,OMathRule._RARR),
	_HARR(2118,"&harr;",new Atom(2118,"&harr;"),0,0,0,0,OMathRule._HARR),
	_LA_RR(2119,"&lArr;",new Atom(2119,"&lArr;"),0,0,0,0,OMathRule._LA_RR),
	_RA_RR(2120,"&rArr;",new Atom(2120,"&rArr;"),0,0,0,0,OMathRule._RA_RR),
	_HA_RR(2121,"&hArr;",new Atom(2121,"&hArr;"),0,0,0,0,OMathRule._HA_RR),
	_PART(2122,"&part;",new Atom(2122,"&part;"),0,0,0,0,OMathRule._PART),
	_EMPTY(2123,"&empty;",new Atom(2123,"&empty;"),0,0,0,0,OMathRule._EMPTY),
	_ISIN(2124,"&isin;",new Atom(2124,"&isin;"),0,0,0,0,OMathRule._ISIN),
	_NI(2125,"&ni;",new Atom(2125,"&ni;"),0,0,0,0,OMathRule._NI),
	_SUM(2126,"&sum;",new Atom(2126,"&sum;"),0,0,0,0,OMathRule._SUM),
	_LOWAST(2127,"&lowast;",new Atom(2127,"&lowast;"),0,0,0,0,OMathRule._LOWAST),
	_PROP(2128,"&prop;",new Atom(2128,"&prop;"),0,0,0,0,OMathRule._PROP),
	_ANG(2129,"&ang;",new Atom(2129,"&ang;"),0,0,0,0,OMathRule._ANG),
	_OR(2130,"&or;",new Atom(2130,"&or;"),0,0,0,0,OMathRule._OR),
	_CUP(2131,"&cup;",new Atom(2131,"&cup;"),0,0,0,0,OMathRule._CUP),
	_THERE4(2132,"&there4;",new Atom(2132,"&there4;"),0,0,0,0,OMathRule._THERE4),
	_CONG(2133,"&cong;",new Atom(2133,"&cong;"),0,0,0,0,OMathRule._CONG),
	_NE(2134,"&ne;",new Atom(2134,"&ne;"),0,0,0,0,OMathRule._NE),
	_LE(2135,"&le;",new Atom(2135,"&le;"),0,0,0,0,OMathRule._LE),
	_SUB(2136,"&sub;",new Atom(2136,"&sub;"),0,0,0,0,OMathRule._SUB),
	_NSUB(2137,"&nsub;",new Atom(2137,"&nsub;"),0,0,0,0,OMathRule._NSUB),
	_SUPE(2138,"&supe;",new Atom(2138,"&supe;"),0,0,0,0,OMathRule._SUPE),
	_OTIMES(2139,"&otimes;",new Atom(2139,"&otimes;"),0,0,0,0,OMathRule._OTIMES),
	_SDOT(2140,"&sdot;",new Atom(2140,"&sdot;"),0,0,0,0,OMathRule._SDOT),
	_RCEIL(2141,"&rceil;",new Atom(2141,"&rceil;"),0,0,0,0,OMathRule._RCEIL),
	_RFLOOR(2142,"&rfloor;",new Atom(2142,"&rfloor;"),0,0,0,0,OMathRule._RFLOOR),
	_SPADES(2143,"&spades;",new Atom(2143,"&spades;"),0,0,0,0,OMathRule._SPADES),
	_HEARTS(2144,"&hearts;",new Atom(2144,"&hearts;"),0,0,0,0,OMathRule._HEARTS),
	_CURREN(2145,"&curren;",new Atom(2145,"&curren;"),0,0,0,0,OMathRule._CURREN),
	_BRVBAR(2146,"&brvbar;",new Atom(2146,"&brvbar;"),0,0,0,0,OMathRule._BRVBAR),
	_UML(2147,"&uml;",new Atom(2147,"&uml;"),0,0,0,0,OMathRule._UML),
	_ORDF(2148,"&ordf;",new Atom(2148,"&ordf;"),0,0,0,0,OMathRule._ORDF),
	_NOT(2149,"&not;",new Atom(2149,"&not;"),0,0,0,0,OMathRule._NOT),
	_DEG(2150,"&deg;",new Atom(2150,"&deg;"),0,0,0,0,OMathRule._DEG),
	_SUP2(2151,"&sup2;",new Atom(2151,"&sup2;"),0,0,0,0,OMathRule._SUP2),
	_ACUTE(2152,"&acute;",new Atom(2152,"&acute;"),0,0,0,0,OMathRule._ACUTE),
    _MIDDOT(2153,"&middot;",new Atom(2153,"&middot;"),0,0,0,0,OMathRule._MIDDOT),
    _OSLASH(2154,"&oslash;",new Atom(2154,"&oslash;"),0,0,0,0,OMathRule._OSLASH),
	_AACUTE(2155,"&aacute;",new Atom(2155,"&aacute;"),0,0,0,0,OMathRule._AACUTE),
	_ORDM(2156,"&ordm;",new Atom(2155,"&ordm;"),0,0,0,0,OMathRule._ORDM),


	;
	private Integer  atomId;
	private String atomName;
	private Atom atom;
	private Integer type;//起始位置  -99:从本块里第一个开始，最后一个结束
	private Integer groupBeginEnd;//组的起始结束:0:非组；1:开始；2:结束；3:只在本组内有效成员
	private Integer group ;//组ID
	private Integer order ;//组内顺序
	private OMathRule oMathRule;
	private OMathRule oMathSecRule; //组不存在时出现只在此组内有效的元素的备用解析方案

	private AtomRule(Integer atomId, String atomName, Atom atom, Integer type, Integer groupBeginEnd, Integer group, Integer order, OMathRule oMathRule){
		this.atomId=atomId;
		this.atomName=atomName;
		this.atom=atom;
		atom.setAtomId(atomId);
		this.type=type;
		this.groupBeginEnd=groupBeginEnd;
		this.group=group;
		this.order=order;
		this.oMathRule=oMathRule;
	}
	private AtomRule(Integer atomId,String atomName,Atom atom,Integer type,Integer groupBeginEnd,Integer group,Integer order,OMathRule oMathRule,OMathRule oMathSecRule){
		this.atomId=atomId;
		this.atomName=atomName;
		this.atom=atom;
		atom.setAtomId(atomId);
		this.type=type;
		this.groupBeginEnd=groupBeginEnd;
		this.group=group;
		this.order=order;
		this.oMathRule=oMathRule;
		this.oMathSecRule=oMathSecRule;
	}
	public Integer getAtomId() {
		return atomId;
	}

	public void setAtomId(Integer atomId) {
		this.atomId = atomId;
	}

	public String getAtomName() {
		return atomName;
	}

	public void setAtomName(String atomName) {
		this.atomName = atomName;
	}

	public Atom getAtom() {
		return atom;
	}

	public void setAtom(Atom atom) {
		this.atom = atom;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getGroupBeginEnd() {
		return groupBeginEnd;
	}

	public void setGroupBeginEnd(Integer groupBeginEnd) {
		this.groupBeginEnd = groupBeginEnd;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public OMathRule getoMathRule() {
		return oMathRule;
	}

	public void setoMathRule(OMathRule oMathRule) {
		this.oMathRule = oMathRule;
	}


	public OMathRule getoMathSecRule() {
		return oMathSecRule;
	}

	public void setoMathSecRule(OMathRule oMathSecRule) {
		this.oMathSecRule = oMathSecRule;
	}


}
