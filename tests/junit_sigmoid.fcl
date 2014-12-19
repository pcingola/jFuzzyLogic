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
	TERM poor := SIGM -4 3;
	TERM good := SIGM 2 5;
	TERM excellent := SIGM 9 8;
END_FUZZIFY

END_FUNCTION_BLOCK

