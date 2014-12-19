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
	TERM poor := COSINE 1 0;
	TERM good := COSINE 4 4;
	TERM excellent := COSINE 2 8;
END_FUZZIFY

END_FUNCTION_BLOCK

