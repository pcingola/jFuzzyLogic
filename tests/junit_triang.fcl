/*
	Example: Different membership functions

									Pablo Cingolani 
									pcingola@users.sourceforge.net
*/

FUNCTION_BLOCK testVariables

VAR_INPUT				// Define input variables
	inVar : REAL;
END_VAR

// Pairwise linear
FUZZIFY inVar
	TERM poor := TRIAN 0 2.5 5;
	TERM good := TRIAN 2.5 5 7.5;
	TERM excellent := TRIAN 5 7.5 10;
END_FUZZIFY

END_FUNCTION_BLOCK

