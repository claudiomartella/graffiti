#!/usr/bin/python

import codecs
import sys

prefix = "<http://localhost/bnodes/%s>"

out = codecs.open(sys.argv[1]+"-clean", "w", "UTF-8")
inf = codecs.open(sys.argv[1], "r", "UTF-8")

for line in inf:
    (subject, predicate, object) = line.split(' ', 2)
    if subject.startswith("_:"):
        subject = prefix % subject[2:]
    out.write(subject)
    out.write(" " + predicate)
    if object.startswith("_:"):
        object = prefix % object[2:-2] + ".\n"
    out.write(" " + object)
    
inf.close()
out.flush()
out.close()
