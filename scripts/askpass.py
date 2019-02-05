#!/usr/bin/env python3
#
# Short & sweet script for use with git clone and fetch credentials.
# Requires GIT_USERNAME and GIT_PASSWORD environment variables,
# intended to be called by Git via GIT_ASKPASS.
#

from sys import argv
from os import environ

print("pregunta user")
if 'username' in argv[1].lower():
    print(environ['GIT_USERNAME'])
    exit()

print("pregunta pass")
if 'password' in argv[1].lower():
    print(environ['GIT_PASSWORD'])
    exit()

exit(1)
