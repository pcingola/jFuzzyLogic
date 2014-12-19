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
	TERM poor := TRAPE 0 2 3 4;
	TERM good := TRAPE 3 4 5 6;
	TERM excellent := TRAPE 5 6 8 10;
END_FUZZIFY

END_FUNCTION_BLOCK

