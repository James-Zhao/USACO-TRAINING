"""
ID: jameszh1
LANG: PYTHON2
TASK: palsquare
"""
def is_palindromic(string):
    return string == string[::-1]

def baseN(num,b):
  return ((num == 0) and  "0" ) or ( baseN(num // b, b).lstrip("0") + "0123456789abcdefghijklmnopqrstuvwxyz"[num % b])

fin = open ('palsquare.in', 'r')
fout = open ('palsquare.out', 'w')
base = int(fin.readline().strip())

for number in range(1, 301):
    number_square = number * number
    if (is_palindromic(str(baseN(number_square, base)))):
        fout.write(str(baseN(number, base).upper()) + " " +  str(baseN(number_square, base).upper()) + '\n')
fout.close()