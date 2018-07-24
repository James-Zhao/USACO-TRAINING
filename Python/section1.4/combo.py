"""
ID: jameszh1
LANG: PYTHON2
TASK: combo
"""
def is_number_close(a, b, n):
     if (abs(a-b) <= 2):
         return True
     if (abs(a-b) >= n-2):
         return True
     return False

def is_list_close(a, b, c, d, e, f, N):
    return is_number_close(a, d, N) and is_number_close(b, e, N) and is_number_close(c, f , N)

fin = open ('combo.in', 'r')
fout = open ('combo.out', 'w')
N = int(fin.readline().strip())
a, b, c = map(int, fin.readline().split(" "))
x, y, z = map(int, fin.readline().split(" "))
total = 0
for i in range(1, N + 1):
    for j in range(1, N + 1):
        for k in range(1, N + 1):
            if (is_list_close(i, j, k, a, b, c, N) or is_list_close(i, j, k, x, y, z, N)):
                total = total + 1
fout.write(str(total) + '\n')
fout.close()