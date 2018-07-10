"""
ID: jameszh1
LANG: PYTHON2
TASK: ride
"""

def caculate(string) :
    size = len(string)
    result = 1
    for i in range(size):
        result = result * (ord(string[i]) - ord('A') + 1)
    return result % 47

fin = open ('ride.in', 'r')
fout = open ('ride.out', 'w')
comet = fin.readline().strip()
group = fin.readline().strip()
if (caculate(comet) == caculate(group)):
    fout.write('GO' + '\n')
else:
    fout.write('STAY' + '\n')
fout.close()

