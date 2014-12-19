#!/usr/bin/perl

use strict;


#------------------------------------------------------------------------------
# Read a file
#------------------------------------------------------------------------------
sub readFile($) {
	my($fileName) = @_;
	open FILE, $fileName;
	undef $/;
	my($file) = <FILE>;
	close FILE;
	return( $file );
}

#------------------------------------------------------------------------------
# Main
#------------------------------------------------------------------------------

# Command line arguments
my($frameFile, $contentFile) = ($ARGV[0], $ARGV[1]);
if( $contentFile eq '' ) 	{ die "Usage: addFrame.pl frameFile contentFile\n"; }

# Read content file
my($content) = readFile($contentFile);
my($frame) = readFile($frameFile);

my(@lines) = split('\n', $frame);
my($l);
for( $l = 0 ; $l <= $#lines ; $l++ ) {
	if( $lines[$l] =~ /<!-- CONTENTS -->/ ) {
		print "$content\n";
	} else {
		print "$lines[$l]\n";
	}
}
