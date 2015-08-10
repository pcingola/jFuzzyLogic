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
	TERM poor := DSIGM 1 1 1 3;
	TERM good := DSIGM 9 4 9 6;
	TERM excellent := DSIGM 1 8 5 9;
END_FUZZIFY

END_FUNCTION_BLOCK

