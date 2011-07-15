#!/usr/bin/python

import codecs
import sys

if len(sys.argv) != 2:
    print "You should pass me the filename"
    sys.exit()

inf = codecs.open(sys.argv[1], "r", "UTF-8")

last = -1
counter = 0

for line in inf:
    # ignore comments
    if line.startswith("#"):
        continue
    
    (src, dst) = line.split('\t')
    
    if src != last:
        if last != -1:
            print "%d %d" % (counter, int(last))
        last = src
        counter = 1
    else:
        counter = counter + 1

inf.close()