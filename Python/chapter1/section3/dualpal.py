"""
ID: jameszh1
LANG: PYTHON2
TASK: dualpal
"""
def is_palindromic(string):
    return string == string[::-1]

def baseN(num,b):
  return ((num == 0) and  "0" ) or ( baseN(num // b, b).lstrip("0") + "0123456789abcdefghijklmnopqrstuvwxyz"[num % b])

fin = open ('dualpal.in', 'r')
fout = open ('dualpal.out', 'w')
N, S = map(int, fin.readline().split())
start = S + 1
while(N > 0):
    count = 0
    for base in range(2, 11):
        if (is_palindromic(str(baseN(start, base)))):
            count = count + 1
            if (count >= 2):
                fout.write(str(start) + '\n')
                N = N - 1
                break
    start = start + 1

fout.close()