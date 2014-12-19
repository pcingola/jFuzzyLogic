/*
	Example: A tip calculation FIS (fuzzy inference system)
	Calculates tip based on 'servie' and 'food'

	If you want to about this example (and fuzzy logic), please 
	read Matlab's tutorial on fuzzy logic toolbox 
	http://www.mathworks.com/access/helpdesk/help/pdf_doc/fuzzy/fuzzy.pdf

									Pablo Cingolani 
									pcingola@users.sourceforge.net
*/

FUNCTION_BLOCK tipper	// Block definition (there may be more than one block per file)

VAR_INPUT				// Define input variables
	service : REAL;
	food : REAL;
END_VAR

VAR_OUTPUT				// Define output variable
	tip : REAL;
END_VAR

FUZZIFY service			// Fuzzify input variable 'service': {'poor', 'good' , 'excellent'}
	TERM poor := TRIAN 0 0 4;
	TERM good := TRAPE 1 4 6 9;
	TERM excellent := TRAPE 6 9 10 10;
END_FUZZIFY

FUZZIFY food			// Fuzzify input variable 'food': { 'rancid', 'delicious' }
	TERM rancid := TRAPE 0 0 1 3; //
	TERM delicious :=  (7,0) (9,1);
END_FUZZIFY

DEFUZZIFY tip			// Defzzzify output variable 'tip' : {'cheap', 'average', 'generous' }
	TERM cheap := TRIAN 0 5 10;
	TERM average := TRIAN 10 15 20;
	TERM generous := TRIAN 20 25 30;
	METHOD : COG;		// Use 'Center Of Gravity' defuzzification method
	DEFAULT := 0;		// Default value is 0 (if no rule activates defuzzifier)
END_DEFUZZIFY

RULEBLOCK No1
	AND : MIN;			// Use 'min' for 'and' (also implicit use 'max' for 'or' to fulfill DeMorgan's Law)
	ACT : MIN;			// Use 'min' activation method
	ACCU : MAX;			// Use 'max' accumulation method

	RULE 1 : IF service IS poor OR food IS rancid THEN tip IS cheap;
	RULE 2 : IF service IS good THEN tip IS average; 
	RULE 3 : IF service IS excellent AND food IS delicious THEN tip IS generous;
END_RULEBLOCK

END_FUNCTION_BLOCK

