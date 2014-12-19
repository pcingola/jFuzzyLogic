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
	TERM poor := GBELL 2 4 2;
	TERM good := GBELL 4 4 5;
	TERM excellent := GBELL 2 1 8;
END_FUZZIFY

END_FUNCTION_BLOCK

