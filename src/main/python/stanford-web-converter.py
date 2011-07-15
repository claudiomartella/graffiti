#!/usr/bin/python

import codecs
import sys

if len(sys.argv) != 2:
    print "You should pass me the filename"
    sys.exit()

out = codecs.open(sys.argv[1]+"-adj", "w", "UTF-8")
inf = codecs.open(sys.argv[1], "r", "UTF-8")

last = -1

for line in inf:
    # ignore comments
    if line.startswith("#"):
        continue
    
    (src, dst) = line.split('\t')
    
    if src != last:
        if last != -1:
            out.write("\n")
        last = src
        out.write(src + "\t" + dst.strip())
    else:
        out.write("\t" + dst.strip())

out.flush()
out.close()
inf.close()