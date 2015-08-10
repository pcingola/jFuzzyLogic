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
	TERM poor := GAUSS 2 2;
	TERM good := GAUSS 5 3;
	TERM excellent := GAUSS 8 4;
END_FUZZIFY

END_FUNCTION_BLOCK

