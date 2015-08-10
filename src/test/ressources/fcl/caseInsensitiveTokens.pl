#!/usr/bin/perl


while( $l = <STDIN> ) {
	chomp $l;
	if( $l =~ /(.*?)\s*=\s*'(.*)'/ ) {
		($var, $val) = ($1, $2);
		print "$var\t:\t";

		(@c) = split("", $val);
		for( $i=0 ; $i <= $#c ; $i++ ) {
			$char = $c[$i];
			$lc = $uc = $char;
			$lc =~ tr/[A-Z]/[a-z]/;
			$uc =~ tr/[a-z]/[A-Z]/;
			print "('$lc'|'$uc')";
		}
		print ";\n";
	}
}

