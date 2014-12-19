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
	TERM poor := (0,1) (2, 1) (4, 0) ; 
	TERM good := (1, 0) (2, 0.5) (3, 0.7) (4,1) (4.5, 1) (5, 0.6) (6, 0.3) (7, 0.3) (8, 0.8) (9, 0.8) (10,0);
	TERM excellent := (6, 0) (9, 1) (10,1);
END_FUZZIFY

END_FUNCTION_BLOCK

